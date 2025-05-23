package com.tencent.mobileqq.qqlive.room.anchorcenter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.data.auth.QQLiveRealNameAuthData;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.widget.verify.l;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.util.SSODebugUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.api.ITimiGameApi;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nf4.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 62\u00020\u00012\u00020\u0002:\u00017B\u0007\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J\u0012\u0010\u0010\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0012\u0010\u0016\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0018\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014H\u0016R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010\u001eR\u0018\u0010)\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010\u001eR\u0018\u0010+\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010\u001eR\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/anchorcenter/i;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View$OnClickListener;", "", "G9", "H9", "K9", "D9", "L9", "B9", "E9", "F9", "initData", "I9", "Lcom/tencent/mobileqq/qqlive/data/auth/QQLiveRealNameAuthData;", "authData", "M9", "A9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "v", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/qqlive/room/anchorcenter/QQLiveAnchorCenterViewModel;", "d", "Lcom/tencent/mobileqq/qqlive/room/anchorcenter/QQLiveAnchorCenterViewModel;", "prepareViewModel", "e", "Landroid/view/View;", "authDataView", "f", "liveDataView", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "authDescText", "i", "authArrowImage", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "myAudienceDataView", BdhLogUtil.LogTag.Tag_Conn, "socialOrderDataView", "Lcom/tencent/mobileqq/qqlive/api/IQQLiveSDK;", "D", "Lcom/tencent/mobileqq/qqlive/api/IQQLiveSDK;", "sdk", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "E", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "aegisLog", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class i extends Part implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private View socialOrderDataView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private IQQLiveSDK sdk;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final IAegisLogApi aegisLog;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQLiveAnchorCenterViewModel prepareViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View authDataView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View liveDataView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView authDescText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View authArrowImage;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View myAudienceDataView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/anchorcenter/i$a;", "", "", "LIVE_DATA_ENTRANCE_NAME_DEFAULT", "Ljava/lang/String;", "LIVE_DATA_ENTRANCE_URL_DEFAULT", "MY_AUDIENCE_ENTRANCE_URL_DEFAULT", "QUERY_KEY_BID", "SOCIAL_ORDER_ENTRANCE_URL_DEFAULT", "TAG", "TEST_MY_AUDIENCE_ENTRANCE_URL", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.room.anchorcenter.i$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqlive/room/anchorcenter/i$b", "Lcom/tencent/biz/common/offline/a;", "", "param1", "", "code", "", "loaded", "progress", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements com.tencent.biz.common.offline.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f271506d;

        b(String str) {
            this.f271506d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.biz.common.offline.a
        public void loaded(@Nullable String param1, int code) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) param1, code);
                return;
            }
            AegisLogger.INSTANCE.i("Open_Live|QQLiveAnchorCenterItemsPart", "preloadOfflineBid", "loaded bid:" + this.f271506d + ", code:" + code);
        }

        @Override // com.tencent.biz.common.offline.a
        public void progress(int progress) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, progress);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24177);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.aegisLog = (IAegisLogApi) api;
    }

    private final void A9() {
        View view = this.authDataView;
        if (view != null) {
            ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a(view, false, null, "em_qqlive_anchorcenter_certification", new ConcurrentHashMap());
            ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().reportEvent("imp", view, new ConcurrentHashMap());
        }
        View view2 = this.socialOrderDataView;
        if (view2 != null) {
            ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a(view2, false, null, "em_qqlive_anchorcenter_violations", new ConcurrentHashMap());
            ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().reportEvent("imp", view2, new ConcurrentHashMap());
        }
    }

    private final void B9() {
        TextView textView;
        View view = this.authDataView;
        View view2 = null;
        if (view != null) {
            textView = (TextView) view.findViewById(R.id.f6332338);
        } else {
            textView = null;
        }
        this.authDescText = textView;
        View view3 = this.authDataView;
        if (view3 != null) {
            view2 = view3.findViewById(R.id.f6330336);
        }
        this.authArrowImage = view2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C9(i this$0, QQLiveRealNameAuthData qQLiveRealNameAuthData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.M9(qQLiveRealNameAuthData);
    }

    private final void D9() {
        int i3;
        L9();
        int b16 = ht3.a.b("qqlive_need_show_live_data_entrance", 1);
        String d16 = ht3.a.d("qqlive_show_live_data_entrance_name", "\u76f4\u64ad\u6570\u636e");
        QLog.d(getTAG(), 1, "initLiveDataView, showLiveDataEntrance:" + b16 + ", liveDataEntranceName:" + d16);
        View view = this.liveDataView;
        if (view != null) {
            if (b16 == 1) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
            view.findViewById(R.id.f6332338).setVisibility(8);
            ((TextView) view.findViewById(R.id.f6331337)).setText(d16);
            d.a.a(((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil(), view, false, null, "em_qqlive_anchorcenter_live_data", null, 20, null);
        }
    }

    private final void E9() {
        View view = this.myAudienceDataView;
        if (view != null) {
            ((TextView) view.findViewById(R.id.f6331337)).setText(getActivity().getResources().getString(R.string.f210265hn));
            view.findViewById(R.id.f6332338).setVisibility(8);
        }
    }

    private final void F9() {
        View view = this.socialOrderDataView;
        if (view != null) {
            ((TextView) view.findViewById(R.id.f6331337)).setText(getActivity().getResources().getString(R.string.f210285hp));
            view.findViewById(R.id.f6332338).setVisibility(8);
        }
    }

    private final void G9() {
        String d16 = ht3.a.d("qqlive_data_entrance_url", "https://qlive.qq.com/cos/live/h5/anchor-dashboard/index.html?_bid=5193&_wv=2");
        QLog.d(getTAG(), 1, "jumpToDataWebPage, url:" + d16);
        Intent intent = new Intent(getActivity(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        intent.putExtra("url", d16);
        intent.putExtra("hide_more_button", true);
        getActivity().startActivity(intent);
    }

    private final void H9() {
        String d16;
        if (SSODebugUtil.isTestEnv()) {
            d16 = "https://tde.qlive.qq.com/page/h5/live-h5/audience?_wv=2&_tde_id=6881";
        } else {
            d16 = ht3.a.d("qqlive_anchor_center_my_audience_url", "https://qlive.qq.com/page/h5/live-h5/audience?_wv=2");
        }
        QLog.d(getTAG(), 1, "jumpToMyAudienceWebPage, url:" + d16);
        Intent intent = new Intent(getActivity(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        intent.putExtra("url", d16);
        intent.putExtra("hide_more_button", true);
        getActivity().startActivity(intent);
    }

    private final void I9() {
        String str;
        IQQLiveModuleLogin loginModule;
        LoginInfo loginInfo;
        l lVar = l.f274086a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        com.tencent.mobileqq.qqlive.config.b a16 = QQLiveBusinessConfig.f271165b.a();
        IQQLiveSDK iQQLiveSDK = this.sdk;
        if (iQQLiveSDK == null || (loginModule = iQQLiveSDK.getLoginModule()) == null || (loginInfo = loginModule.getLoginInfo()) == null || (str = Long.valueOf(loginInfo.uid).toString()) == null) {
            str = "";
        }
        lVar.m(context, a16, str, new com.tencent.mobileqq.qqlive.widget.verify.g() { // from class: com.tencent.mobileqq.qqlive.room.anchorcenter.g
            @Override // com.tencent.mobileqq.qqlive.widget.verify.g
            public final void a(int i3, String str2) {
                i.J9(i.this, i3, str2);
            }
        });
        View view = this.authDataView;
        if (view != null) {
            ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().reportEvent("clck", view, new ConcurrentHashMap());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(i this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.aegisLog.e(this$0.getTAG(), "code=" + i3 + ", message=" + str);
    }

    private final void K9() {
        String d16 = ht3.a.d("qqlive_violation_url", "https://qlive.qq.com/cos/live/h5/anchor-dashboard/violation.html?_bid=5193&_wv=2");
        QLog.d(getTAG(), 1, "jumpToSocialOrderPage, url:" + d16);
        Intent intent = new Intent(getActivity(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        intent.putExtra("url", d16);
        intent.putExtra("hide_more_button", true);
        getActivity().startActivity(intent);
        View view = this.socialOrderDataView;
        if (view != null) {
            ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().reportEvent("clck", view, new ConcurrentHashMap());
        }
    }

    private final void L9() {
        String str;
        AppInterface a16 = com.tencent.mobileqq.qqlive.utils.g.a();
        if (a16 == null) {
            return;
        }
        try {
            str = Uri.parse(ht3.a.d("qqlive_data_entrance_url", "https://qlive.qq.com/cos/live/h5/anchor-dashboard/index.html?_bid=5193&_wv=2")).getQueryParameter("_bid");
        } catch (Exception unused) {
            str = null;
        }
        if (str == null) {
            return;
        }
        HtmlOffline.k(str, a16, new b(str), true, 0, true);
    }

    private final void M9(QQLiveRealNameAuthData authData) {
        String str;
        TextView textView = this.authDescText;
        Integer num = null;
        if (textView != null) {
            if (authData != null) {
                str = authData.getTipsContent();
            } else {
                str = null;
            }
            textView.setText(str);
        }
        if (authData != null) {
            num = Integer.valueOf(authData.getAuthState());
        }
        if (num != null && num.intValue() == 0) {
            TextView textView2 = this.authDescText;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            View view = this.authArrowImage;
            if (view != null) {
                view.setVisibility(0);
            }
            TextView textView3 = this.authDescText;
            if (textView3 != null) {
                textView3.setText(getActivity().getResources().getString(R.string.f210255hm));
            }
            View view2 = this.authDataView;
            if (view2 != null) {
                view2.setClickable(true);
                return;
            }
            return;
        }
        if (num != null && num.intValue() == 1) {
            TextView textView4 = this.authDescText;
            if (textView4 != null) {
                textView4.setVisibility(0);
            }
            View view3 = this.authArrowImage;
            if (view3 != null) {
                view3.setVisibility(8);
            }
            TextView textView5 = this.authDescText;
            if (textView5 != null) {
                textView5.setText(getActivity().getResources().getString(R.string.f210235hk));
            }
            View view4 = this.authDataView;
            if (view4 != null) {
                view4.setClickable(false);
                return;
            }
            return;
        }
        if (num != null && num.intValue() == 2) {
            TextView textView6 = this.authDescText;
            if (textView6 != null) {
                textView6.setVisibility(0);
            }
            View view5 = this.authArrowImage;
            if (view5 != null) {
                view5.setVisibility(0);
            }
            TextView textView7 = this.authDescText;
            if (textView7 != null) {
                textView7.setText(getActivity().getResources().getString(R.string.f210255hm));
            }
            View view6 = this.authDataView;
            if (view6 != null) {
                view6.setClickable(true);
                return;
            }
            return;
        }
        if (num != null && num.intValue() == 3) {
            TextView textView8 = this.authDescText;
            if (textView8 != null) {
                textView8.setVisibility(0);
            }
            View view7 = this.authArrowImage;
            if (view7 != null) {
                view7.setVisibility(8);
            }
            TextView textView9 = this.authDescText;
            if (textView9 != null) {
                textView9.setText(getActivity().getResources().getString(R.string.f210245hl));
            }
            View view8 = this.authDataView;
            if (view8 != null) {
                view8.setClickable(false);
            }
        }
    }

    private final void initData() {
        MutableLiveData<QQLiveRealNameAuthData> O1;
        this.sdk = com.tencent.mobileqq.qqlive.base.sdk.a.c(null);
        QQLiveAnchorCenterViewModel qQLiveAnchorCenterViewModel = (QQLiveAnchorCenterViewModel) new ViewModelProvider(getHostFragment(), QQLiveAnchorCenterViewModel.INSTANCE.a()).get(QQLiveAnchorCenterViewModel.class);
        this.prepareViewModel = qQLiveAnchorCenterViewModel;
        if (qQLiveAnchorCenterViewModel != null && (O1 = qQLiveAnchorCenterViewModel.O1()) != null) {
            O1.observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.qqlive.room.anchorcenter.h
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    i.C9(i.this, (QQLiveRealNameAuthData) obj);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "QQLiveAnchorCenterItemsPart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) v3);
        } else {
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.f6326332) {
                I9();
            } else if (num != null && num.intValue() == R.id.f6329335) {
                G9();
            } else if (num != null && num.intValue() == R.id.f633533a) {
                H9();
            } else if (num != null && num.intValue() == R.id.f634033f) {
                K9();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        View view;
        View view2;
        View view3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        View view4 = null;
        if (rootView != null) {
            view = rootView.findViewById(R.id.f6326332);
        } else {
            view = null;
        }
        this.authDataView = view;
        if (rootView != null) {
            view2 = rootView.findViewById(R.id.f6329335);
        } else {
            view2 = null;
        }
        this.liveDataView = view2;
        if (rootView != null) {
            view3 = rootView.findViewById(R.id.f633533a);
        } else {
            view3 = null;
        }
        this.myAudienceDataView = view3;
        if (rootView != null) {
            view4 = rootView.findViewById(R.id.f634033f);
        }
        this.socialOrderDataView = view4;
        View view5 = this.authDataView;
        if (view5 != null) {
            view5.setOnClickListener(this);
        }
        View view6 = this.liveDataView;
        if (view6 != null) {
            view6.setOnClickListener(this);
        }
        View view7 = this.myAudienceDataView;
        if (view7 != null) {
            view7.setOnClickListener(this);
        }
        View view8 = this.socialOrderDataView;
        if (view8 != null) {
            view8.setOnClickListener(this);
        }
        B9();
        D9();
        E9();
        F9();
        initData();
        A9();
    }
}
