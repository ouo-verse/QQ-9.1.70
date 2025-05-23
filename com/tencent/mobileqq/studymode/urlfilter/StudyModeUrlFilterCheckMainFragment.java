package com.tencent.mobileqq.studymode.urlfilter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.studymode.JumpKidModeMgr;
import com.tencent.mobileqq.studymode.KidModeObserver;
import com.tencent.mobileqq.studymode.KidModeServlet;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.studymode.f;
import com.tencent.mobileqq.studymode.urlfilter.StudyModeUrlFilterCheckMainFragment;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import cooperation.qzone.QzoneIPCModule;
import hr2.d;
import hr2.g;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.IAccountCallback;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\ba\u0010bJ\u001c\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J*\u0010\u0010\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0014J&\u0010\u001b\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ\"\u0010\"\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\b\u0010#\u001a\u00020\u0011H\u0016J\b\u0010$\u001a\u00020\u000fH\u0016J\n\u0010&\u001a\u0004\u0018\u00010%H\u0004J\b\u0010'\u001a\u00020\u0011H\u0016J\b\u0010(\u001a\u00020\u0011H\u0016J\b\u0010)\u001a\u00020\u000fH\u0016J\b\u0010*\u001a\u00020\u000fH\u0016J\b\u0010+\u001a\u00020\u000fH\u0016J \u0010/\u001a\u00020\u000f2\u0016\b\u0002\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020-\u0018\u00010,H\u0007J \u00100\u001a\u00020\u000f2\u0016\b\u0002\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020-\u0018\u00010,H\u0007J0\u00104\u001a\u00020\u000f2\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u00020\u000b2\u0016\b\u0002\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020-\u0018\u00010,H\u0007J0\u00105\u001a\u00020\u000f2\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u00020\u000b2\u0016\b\u0002\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020-\u0018\u00010,H\u0007J0\u00106\u001a\u00020\u000f2\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u00020\u000b2\u0016\b\u0002\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020-\u0018\u00010,H\u0007R\u001a\u0010;\u001a\u00020\u000b8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR$\u0010J\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bK\u00108\u001a\u0004\bL\u0010:\"\u0004\bM\u0010NR\"\u0010V\u001a\u00020O8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0014\u0010Z\u001a\u00020W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010\\\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b[\u00108R\u0014\u0010^\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b]\u00108R\u0014\u0010`\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b_\u00108\u00a8\u0006c"}, d2 = {"Lcom/tencent/mobileqq/studymode/urlfilter/StudyModeUrlFilterCheckMainFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "", "colorAlpha", "", "stroke", "Landroid/graphics/drawable/Drawable;", "rh", "Landroid/content/Context;", "context", "status", "", "url", "", "time", "", "wh", "", "vh", "xh", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "Lcom/tencent/mobileqq/app/QQAppInterface;", "Ih", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "onBackEvent", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lmqq/app/AppRuntime;", "getAppRuntime", "needImmersive", "useQUISecNavBar", "onPostThemeChanged", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "", "", "params", "Gh", "Eh", "Landroid/view/View;", "view", "key", "Ch", "yh", "Ah", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "D", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", QQWinkConstants.TAB_SUBTITLE, "Lcom/tencent/biz/qui/quibutton/QUIButton;", UserInfo.SEX_FEMALE, "Lcom/tencent/biz/qui/quibutton/QUIButton;", "getBtn", "()Lcom/tencent/biz/qui/quibutton/QUIButton;", "setBtn", "(Lcom/tencent/biz/qui/quibutton/QUIButton;)V", "btn", "G", "getUrl", "setUrl", "(Ljava/lang/String;)V", "Lcom/tencent/mobileqq/studymode/KidModeObserver;", "H", "Lcom/tencent/mobileqq/studymode/KidModeObserver;", "getKidModeObserver", "()Lcom/tencent/mobileqq/studymode/KidModeObserver;", "setKidModeObserver", "(Lcom/tencent/mobileqq/studymode/KidModeObserver;)V", "kidModeObserver", "Lmqq/app/IAccountCallback;", "I", "Lmqq/app/IAccountCallback;", "accountCallback", "J", "pageId", "K", "passWordBtnId", "L", "knowBtnId", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public class StudyModeUrlFilterCheckMainFragment extends QIphoneTitleBarFragment {

    /* renamed from: D, reason: from kotlin metadata */
    private ViewGroup rootView;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView subTitle;

    /* renamed from: F, reason: from kotlin metadata */
    private QUIButton btn;

    /* renamed from: G, reason: from kotlin metadata */
    private String url;

    /* renamed from: C, reason: from kotlin metadata */
    private final String TAG = "StudyModeUrlFilterCheckMainFragment";

    /* renamed from: H, reason: from kotlin metadata */
    private KidModeObserver kidModeObserver = new b();

    /* renamed from: I, reason: from kotlin metadata */
    private final IAccountCallback accountCallback = new a();

    /* renamed from: J, reason: from kotlin metadata */
    private final String pageId = "pg_bas_link_blocking";

    /* renamed from: K, reason: from kotlin metadata */
    private final String passWordBtnId = "em_bas_validate_password";

    /* renamed from: L, reason: from kotlin metadata */
    private final String knowBtnId = "em_bas_know";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/studymode/urlfilter/StudyModeUrlFilterCheckMainFragment$b", "Lcom/tencent/mobileqq/studymode/KidModeObserver;", "Lcom/tencent/mobileqq/studymode/KidModeObserver$QueryPasswordStateResult;", "result", "", "c", "Lcom/tencent/mobileqq/studymode/KidModeObserver$VerifyPasswordResult;", "j", "Lcom/tencent/mobileqq/studymode/KidModeObserver$SetNewPasswordResult;", "i", "", "isSuccess", "Landroid/os/Bundle;", "bundle", "g", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends KidModeObserver {
        b() {
        }

        @Override // com.tencent.mobileqq.studymode.KidModeObserver
        public void g(boolean isSuccess, Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            super.g(isSuccess, bundle);
        }

        @Override // com.tencent.mobileqq.studymode.KidModeObserver
        public void i(KidModeObserver.SetNewPasswordResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            super.i(result);
        }

        @Override // com.tencent.mobileqq.studymode.KidModeObserver
        public void j(KidModeObserver.VerifyPasswordResult result) {
            super.j(result);
        }

        @Override // com.tencent.mobileqq.studymode.KidModeObserver
        public void c(KidModeObserver.QueryPasswordStateResult result) {
            if (result == null) {
                QLog.i("KidModeObserver", 1, "onQueryPasswordState result == null");
                return;
            }
            super.c(result);
            QLog.i("KidModeObserver", 1, "onQueryPasswordState errCode=" + result.errCode + ",State=" + result.passwordState + ",salt=" + f.b(result.salt));
            if (result.errCode == 0) {
                StudyModeManager.N(result.passwordState, result.salt);
            }
        }
    }

    private final Drawable rh(float colorAlpha, int stroke) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        Context context = getContext();
        if (context != null) {
            gradientDrawable.setColor(context.getColor(R.color.qui_common_fill_standard_extra));
        }
        gradientDrawable.setCornerRadius(Utils.o(4.0f, BaseApplication.getContext().getResources()));
        Context context2 = getContext();
        if (context2 != null) {
            gradientDrawable.setStroke(stroke, context2.getColor(R.color.qui_common_fill_standard_extra));
        }
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void th(StudyModeUrlFilterCheckMainFragment this$0, QUIButton btn, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(btn, "$btn");
        zh(this$0, btn, this$0.passWordBtnId, null, 4, null);
        JumpKidModeMgr.b().q(this$0.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uh(StudyModeUrlFilterCheckMainFragment this$0, QUIButton btn, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(btn, "$btn");
        zh(this$0, btn, this$0.knowBtnId, null, 4, null);
        this$0.onBackEvent();
    }

    private final boolean vh() {
        return ThemeUtil.isNowThemeIsNight(getAppRuntime(), true, null);
    }

    private final void wh(Context context, int status, String url, long time) {
        String str = (("https://accounts.qq.com/teen-mode/index.html?_wv=3" + ContainerUtils.FIELD_DELIMITER + status) + ContainerUtils.FIELD_DELIMITER + time) + ContainerUtils.FIELD_DELIMITER + url;
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("url", str);
        if (context != null) {
            context.startActivity(intent);
        }
    }

    private final void xh() {
        boolean vh5 = vh();
        ViewGroup viewGroup = this.rootView;
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(vh5 ? -16777216 : -1);
        }
        View view = ((QIphoneTitleBarFragment) this).mContentView;
        if (view != null) {
            view.setBackgroundColor(vh5 ? -16777216 : -1);
        }
        TextView textView = this.subTitle;
        if (textView != null) {
            textView.setTextColor(vh() ? -1 : getResources().getColor(R.color.csy));
        }
    }

    public final void Ah(View view, String key, Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(key, "key");
        VideoReport.setPageId(view, key);
        VideoReport.reportEvent("dt_imp_end", view, params);
    }

    public final void Ch(View view, String key, Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(key, "key");
        VideoReport.setPageId(view, key);
        VideoReport.reportEvent("dt_imp", view, params);
    }

    public final void Eh(Map<String, ? extends Object> params) {
        VideoReport.setPageId(((QIphoneTitleBarFragment) this).mContentView, this.pageId);
        VideoReport.reportEvent("dt_pgout", ((QIphoneTitleBarFragment) this).mContentView, params);
    }

    public final void Gh(Map<String, ? extends Object> params) {
        VideoReport.setPageId(((QIphoneTitleBarFragment) this).mContentView, this.pageId);
        VideoReport.reportEvent("dt_pgin", ((QIphoneTitleBarFragment) this).mContentView, params);
    }

    public final QQAppInterface Ih() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        Intrinsics.checkNotNullExpressionValue(waitAppRuntime, "sMobileQQ.waitAppRuntime()");
        if (waitAppRuntime instanceof QQAppInterface) {
            return (QQAppInterface) waitAppRuntime;
        }
        QLog.i(this.TAG, 1, "YouthModeChoiceHandler QQAppInterface is null--- ");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intent intent;
        super.doOnCreateView(inflater, container, savedInstanceState);
        FragmentActivity activity = getActivity();
        this.url = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getStringExtra(IStudyModeManager.STUDY_MODE_URL_FILTER_PATH_URL);
        QUIButton qUIButton = (QUIButton) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f181124);
        this.btn = qUIButton;
        if (qUIButton != null) {
            qUIButton.setBackground(sh(this, 0.0f, 0, 3, null));
        }
        final QUIButton qUIButton2 = this.btn;
        if (qUIButton2 != null) {
            Dh(this, qUIButton2, this.passWordBtnId, null, 4, null);
            qUIButton2.setOnClickListener(new View.OnClickListener() { // from class: hr2.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StudyModeUrlFilterCheckMainFragment.th(StudyModeUrlFilterCheckMainFragment.this, qUIButton2, view);
                }
            });
        }
        final QUIButton qUIButton3 = (QUIButton) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f18051y);
        if (qUIButton3 != null) {
            Dh(this, qUIButton3, this.knowBtnId, null, 4, null);
            qUIButton3.setOnClickListener(new View.OnClickListener() { // from class: hr2.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StudyModeUrlFilterCheckMainFragment.uh(StudyModeUrlFilterCheckMainFragment.this, qUIButton3, view);
                }
            });
        }
        this.rootView = (ViewGroup) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.root_layout);
        this.subTitle = (TextView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f896750e);
        xh();
        QQAppInterface Ih = Ih();
        if (Ih != null) {
            Ih.registObserver(this.kidModeObserver);
        }
        MobileQQ.sMobileQQ.registerAccountCallback(this.accountCallback);
        KidModeServlet.m(Ih());
    }

    protected final AppRuntime getAppRuntime() {
        if (getQBaseActivity() != null) {
            return getQBaseActivity().getAppRuntime();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f127310b;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null || !data.getBooleanExtra("extra_mode_pass_word_check_sucess", false)) {
            return;
        }
        String str = this.url;
        if (str == null) {
            str = "";
        }
        String str2 = str;
        d.f406079a.p(IStudyModeManager.STUDY_MODE_URL_FILTER_RESULT_SUC, str2);
        StudyModeUrlFilterCachesInfo i3 = g.f406087a.i(str2);
        if (i3 != null) {
            wh(getContext(), 1, str2, i3.getInvalidTime());
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        String str = this.url;
        if (str != null) {
            d.f406079a.p(IStudyModeManager.STUDY_MODE_URL_FILTER_RESULT_FAIL, str);
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        QQAppInterface Ih = Ih();
        if (Ih != null) {
            Ih.unRegistObserver(this.kidModeObserver);
        }
        MobileQQ.sMobileQQ.unregisterAccountCallback(this.accountCallback);
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Fh(this, null, 1, null);
        QUIButton qUIButton = this.btn;
        if (qUIButton != null) {
            Bh(this, qUIButton, this.passWordBtnId, null, 4, null);
        }
        QUIButton qUIButton2 = (QUIButton) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f18051y);
        if (qUIButton2 != null) {
            Bh(this, qUIButton2, this.knowBtnId, null, 4, null);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        xh();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Hh(this, null, 1, null);
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        return true;
    }

    public final void yh(View view, String key, Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(key, "key");
        VideoReport.setPageId(view, key);
        VideoReport.reportEvent("dt_clck", view, params);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void Bh(StudyModeUrlFilterCheckMainFragment studyModeUrlFilterCheckMainFragment, View view, String str, Map map, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                map = null;
            }
            studyModeUrlFilterCheckMainFragment.Ah(view, str, map);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportEndExpose");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void Dh(StudyModeUrlFilterCheckMainFragment studyModeUrlFilterCheckMainFragment, View view, String str, Map map, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                map = null;
            }
            studyModeUrlFilterCheckMainFragment.Ch(view, str, map);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportExpose");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void Fh(StudyModeUrlFilterCheckMainFragment studyModeUrlFilterCheckMainFragment, Map map, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                map = null;
            }
            studyModeUrlFilterCheckMainFragment.Eh(map);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportPageExit");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void Hh(StudyModeUrlFilterCheckMainFragment studyModeUrlFilterCheckMainFragment, Map map, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                map = null;
            }
            studyModeUrlFilterCheckMainFragment.Gh(map);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportPageExpose");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void zh(StudyModeUrlFilterCheckMainFragment studyModeUrlFilterCheckMainFragment, View view, String str, Map map, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                map = null;
            }
            studyModeUrlFilterCheckMainFragment.yh(view, str, map);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportClick");
    }

    static /* synthetic */ Drawable sh(StudyModeUrlFilterCheckMainFragment studyModeUrlFilterCheckMainFragment, float f16, int i3, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 1) != 0) {
                f16 = 0.5f;
            }
            if ((i16 & 2) != 0) {
                i3 = 0;
            }
            return studyModeUrlFilterCheckMainFragment.rh(f16, i3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createBtnBgDrawable");
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/studymode/urlfilter/StudyModeUrlFilterCheckMainFragment$a", "Lmqq/app/IAccountCallback;", "Lmqq/app/AppRuntime;", "newRuntime", "", "onAccountChanged", "onAccountChangeFailed", "Lmqq/app/Constants$LogoutReason;", "reason", "onLogout", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements IAccountCallback {
        a() {
        }

        @Override // mqq.app.IAccountCallback
        public void onLogout(Constants.LogoutReason reason) {
            FragmentActivity activity = StudyModeUrlFilterCheckMainFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
            StudyModeUrlFilterCheckMainFragment.this.onBackEvent();
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChangeFailed(AppRuntime newRuntime) {
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChanged(AppRuntime newRuntime) {
        }
    }
}
