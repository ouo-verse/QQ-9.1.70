package com.tencent.mobileqq.springhb.entry.module;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.bannerprocessor.VasADBannerProcessor;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.springhb.api.ISpringHbReportApi;
import com.tencent.mobileqq.springhb.api.ISpringHbTempApi;
import com.tencent.mobileqq.springhb.entry.SpringBannerTextVB;
import com.tencent.mobileqq.springhb.entry.model.MsgTabBannerData;
import com.tencent.mobileqq.springhb.entry.model.UserData;
import com.tencent.mobileqq.springhb.entry.worker.e;
import com.tencent.mobileqq.springhb.main.SpringToMainHelper;
import com.tencent.mobileqq.springhb.preload.SpringResApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.dd;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \n2\u00020\u0001:\u0001EB\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0017\u00a2\u0006\u0004\bC\u0010DJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0012\u001a\u00020\bH\u0016J\b\u0010\u0013\u001a\u00020\bH\u0016J\u0006\u0010\u0014\u001a\u00020\bJ\u0006\u0010\u0015\u001a\u00020\bJ\u0006\u0010\u0016\u001a\u00020\bR\u0017\u0010\u001b\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\"\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R$\u0010,\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0018\u0010.\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010'R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00106\u001a\u0002038BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b4\u00105R\u0014\u0010:\u001a\u0002078BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b8\u00109R\u0014\u0010>\u001a\u00020;8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b<\u0010=R\u0014\u0010@\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b?\u0010\u001fR\u0014\u0010B\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bA\u0010\u001f\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/springhb/entry/module/m;", "Lcom/tencent/mobileqq/springhb/entry/worker/e$b;", "Lcom/tencent/mobileqq/springhb/entry/model/MsgTabBannerData;", "msgTabBannerData", "", "G", "", "bannerJumpUrl", "", "y", BdhLogUtil.LogTag.Tag_Conn, "itemId", "operId", "P", "subModule", "E", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "B", "b", "d", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, UserInfo.SEX_FEMALE, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/springhb/entry/worker/d;", "Lcom/tencent/mobileqq/springhb/entry/worker/d;", "getSpringApi", "()Lcom/tencent/mobileqq/springhb/entry/worker/d;", "springApi", "e", "Z", HippyTKDListViewAdapter.X, "()Z", "setShowingTabBanner", "(Z)V", "isShowingTabBanner", "f", "Lcom/tencent/mobileqq/springhb/entry/model/MsgTabBannerData;", "curMsgTabBannerData", tl.h.F, "Ljava/lang/String;", "getCurBannerId", "()Ljava/lang/String;", "setCurBannerId", "(Ljava/lang/String;)V", "curBannerId", "i", "reportJumpUrl", "Lcom/tencent/mobileqq/springhb/entry/SpringBannerTextVB;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/springhb/entry/SpringBannerTextVB;", "springBannerTextVB", "Lcom/tencent/mobileqq/activity/home/Conversation;", "u", "()Lcom/tencent/mobileqq/activity/home/Conversation;", "conversation", "Landroid/view/View;", "v", "()Landroid/view/View;", "mTitleView", "Landroid/app/Activity;", ReportConstant.COSTREPORT_PREFIX, "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "t", "canShowTabBanner", "w", "isCloseToday", "<init>", "(Lcom/tencent/mobileqq/springhb/entry/worker/d;)V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class m extends e.b {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.springhb.entry.worker.d springApi;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isShowingTabBanner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MsgTabBannerData curMsgTabBannerData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String curBannerId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String reportJumpUrl;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SpringBannerTextVB springBannerTextVB;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/springhb/entry/module/m$a;", "", "", "BANNER_DEFAULT_TEXT", "Ljava/lang/String;", "REPORT_VALUE_ENTRANCE", "REPORT_VALUE_EXP_ID", "REPORT_VALUE_ITEM_BANNER", "REPORT_VALUE_ITEM_CLOSE_BUTTON", "REPORT_VALUE_SUBMODULE_MAIN", "REPORT_VALUE_SUBMODULE_MAIN_CLOSE", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.springhb.entry.module.m$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60635);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public m(@NotNull com.tencent.mobileqq.springhb.entry.worker.d springApi) {
        Intrinsics.checkNotNullParameter(springApi, "springApi");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) springApi);
        } else {
            this.springApi = springApi;
            springApi.l().c(this);
        }
    }

    private final void C() {
        QLog.d("SpringTabBannerModule", 2, "removeTitleBanner");
        View v3 = v();
        View findViewById = v3.findViewById(R.id.f87554uo);
        if (findViewById == null) {
            return;
        }
        if (v3 instanceof ViewGroup) {
            ((ViewGroup) v3).removeView(findViewById);
            SpringBannerTextVB springBannerTextVB = this.springBannerTextVB;
            if (springBannerTextVB != null) {
                springBannerTextVB.d();
            }
            this.springBannerTextVB = null;
        }
        u().refreshStatusBarUIByTheme();
        if (ThemeUtil.isNowThemeIsSuperTheme() && this.springApi.k().j0()) {
            dd.a(v3, R.drawable.skin_header_bar_bg);
        }
        v3.requestLayout();
        v3.post(new Runnable() { // from class: com.tencent.mobileqq.springhb.entry.module.d
            @Override // java.lang.Runnable
            public final void run() {
                m.D(m.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(m this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.springApi.k().U0(0);
    }

    private final void E(String subModule, String operId) {
        boolean z16;
        String str;
        Map<String, String> mapOf;
        ISpringHbReportApi iSpringHbReportApi;
        if (!this.isShowingTabBanner) {
            return;
        }
        String str2 = this.reportJumpUrl;
        if (str2 != null && str2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            str = "0";
        } else {
            str = this.reportJumpUrl;
        }
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("buss_id", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE), TuplesKt.to("module_id", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE), TuplesKt.to("submodule_id", subModule), TuplesKt.to("ext1", str), TuplesKt.to(WadlReportBuilder.TableElem.OPER_ID, operId), TuplesKt.to("changci_id", this.curBannerId));
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iSpringHbReportApi = (ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")) != null) {
            iSpringHbReportApi.reportForGameCenter(mapOf);
        }
    }

    private final boolean G(MsgTabBannerData msgTabBannerData) {
        final String str = msgTabBannerData.liuhaiBgUrl;
        final String str2 = msgTabBannerData.jumpUrl;
        this.reportJumpUrl = str2;
        QLog.d("SpringTabBannerModule", 1, "showTitleBanner ,bannerBgUrl = " + str + ", bannerJumpUrl = " + str2);
        View v3 = v();
        if (!(v3 instanceof RelativeLayout)) {
            QLog.e("SpringTabBannerModule", 1, "showTitleBanner return, titleView is not RelativeLayout");
            return false;
        }
        View findViewById = v3.findViewById(R.id.f87554uo);
        if (findViewById != null) {
            ((RelativeLayout) v3).removeView(findViewById);
            SpringBannerTextVB springBannerTextVB = this.springBannerTextVB;
            if (springBannerTextVB != null) {
                springBannerTextVB.d();
            }
            this.springBannerTextVB = null;
        }
        View inflate = LayoutInflater.from(s()).inflate(R.layout.gx6, (ViewGroup) v3, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.RelativeLayout");
        RelativeLayout relativeLayout = (RelativeLayout) inflate;
        int i3 = u().statusTitleHeightInNormalState;
        final Ref.IntRef intRef = new Ref.IntRef();
        int dip2px = ViewUtils.dip2px(40.0f);
        if (i3 > 0) {
            intRef.element = i3 + dip2px;
        } else {
            int height = ((RelativeLayout) v3).getHeight();
            u().statusTitleHeightInNormalState = height;
            intRef.element = height + dip2px;
        }
        QLog.d("SpringTabBannerModule", 2, "showTitleBanner, statusTitleHeight = " + intRef.element + " , 40dp = " + dip2px);
        if (intRef.element <= ViewUtils.dip2px(50.0f)) {
            intRef.element = ViewUtils.dip2px(125.0f);
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) v3;
        if (relativeLayout2.getChildCount() > 0 && relativeLayout2.getChildAt(0).getId() == R.id.f164618t91) {
            relativeLayout2.addView(relativeLayout, 1, new RelativeLayout.LayoutParams(-1, intRef.element));
        } else {
            relativeLayout2.addView(relativeLayout, 0, new RelativeLayout.LayoutParams(-1, intRef.element));
        }
        relativeLayout.requestLayout();
        v3.requestLayout();
        v3.post(new Runnable() { // from class: com.tencent.mobileqq.springhb.entry.module.e
            @Override // java.lang.Runnable
            public final void run() {
                m.H(m.this, intRef);
            }
        });
        View findViewById2 = relativeLayout.findViewById(R.id.f87564up);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "bannerContainer.findView\u2026ring_festival_banner_img)");
        final ImageView imageView = (ImageView) findViewById2;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.springhb.entry.module.f
            @Override // java.lang.Runnable
            public final void run() {
                m.I(str, imageView);
            }
        }, 16, null, false);
        SpringBannerTextVB springBannerTextVB2 = new SpringBannerTextVB(this.springApi);
        springBannerTextVB2.e(relativeLayout, msgTabBannerData);
        this.springBannerTextVB = springBannerTextVB2;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.springhb.entry.module.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m.K(m.this, str2, view);
            }
        });
        View findViewById3 = relativeLayout.findViewById(R.id.f87544un);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "bannerContainer.findView\u2026ng_2022_banner_close_btn)");
        final ImageView imageView2 = (ImageView) findViewById3;
        imageView2.setImageResource(R.drawable.muw);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.springhb.entry.module.h
            @Override // java.lang.Runnable
            public final void run() {
                m.M(imageView2);
            }
        }, 16, null, false);
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.springhb.entry.module.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m.O(m.this, view);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(m this$0, Ref.IntRef statusTitleHeight) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(statusTitleHeight, "$statusTitleHeight");
        this$0.springApi.k().U0(statusTitleHeight.element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(String bannerBgUrl, final ImageView bannerImage) {
        Intrinsics.checkNotNullParameter(bannerImage, "$bannerImage");
        Bundle bundle = new Bundle();
        int apngPlayCount = ((ISpringHbTempApi) QRoute.api(ISpringHbTempApi.class)).getApngPlayCount();
        QLog.i("SpringTabBannerModule", 1, "playCount = " + apngPlayCount);
        bundle.putInt("key_loop", apngPlayCount);
        bundle.putBoolean("key_get_reset_loop", false);
        bundle.putBoolean("key_stop_on_first", false);
        Drawable TRANSPARENT = com.tencent.mobileqq.urldrawable.b.f306350a;
        Intrinsics.checkNotNullExpressionValue(TRANSPARENT, "TRANSPARENT");
        Intrinsics.checkNotNullExpressionValue(bannerBgUrl, "bannerBgUrl");
        final Drawable b16 = SpringResApi.k(bannerBgUrl, TRANSPARENT, bundle).b();
        if (b16 instanceof URLDrawable) {
            ((URLDrawable) b16).downloadImediatly(true);
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.springhb.entry.module.j
            @Override // java.lang.Runnable
            public final void run() {
                m.J(bannerImage, b16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(ImageView bannerImage, Drawable bgDrawable) {
        Intrinsics.checkNotNullParameter(bannerImage, "$bannerImage");
        Intrinsics.checkNotNullParameter(bgDrawable, "$bgDrawable");
        bannerImage.setImageDrawable(bgDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(m this$0, String str, final View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        view.setClickable(false);
        view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.springhb.entry.module.k
            @Override // java.lang.Runnable
            public final void run() {
                m.L(view);
            }
        }, 1000L);
        this$0.y(str);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(View view) {
        view.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(final ImageView bannerClose) {
        Intrinsics.checkNotNullParameter(bannerClose, "$bannerClose");
        final Drawable b16 = SpringResApi.j("game_spring_msg_banner_close.png", null, 2, null).b();
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.springhb.entry.module.l
            @Override // java.lang.Runnable
            public final void run() {
                m.N(bannerClose, b16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(ImageView bannerClose, Drawable closeDrawable) {
        Intrinsics.checkNotNullParameter(bannerClose, "$bannerClose");
        Intrinsics.checkNotNullParameter(closeDrawable, "$closeDrawable");
        bannerClose.setImageDrawable(closeDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(m this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.E("banner_mainpg_close", "clk");
        this$0.P("em_top_banner_close", "em_clk");
        this$0.A();
        UserData N = this$0.springApi.n().N();
        Intrinsics.checkNotNullExpressionValue(N, "springApi.manager.userData");
        N.closeTabBannerTime = this$0.springApi.n().I();
        this$0.springApi.n().g0();
        QLog.i("SpringTabBannerModule", 2, "showTitleBanner: banner onClick close");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void P(String itemId, String operId) {
        Map<String, String> mapOf;
        ISpringHbReportApi iSpringHbReportApi;
        if (this.isShowingTabBanner) {
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("buss_id", "mqq"), TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.PG_ID, "pg_msg_list"), TuplesKt.to("module_id", "md_top_banner"), TuplesKt.to("item_id", itemId), TuplesKt.to(WadlReportBuilder.TableElem.OPER_ID, operId), TuplesKt.to("changci_id", this.curBannerId));
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null && (iSpringHbReportApi = (ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")) != null) {
                iSpringHbReportApi.reportForSpringHb(mapOf);
            }
        }
    }

    private final void Q() {
        QLog.d("SpringTabBannerModule", 2, "tryRecoverTianShuBanner");
        BannerManager.l().D(VasADBannerProcessor.f185279h, 3003);
    }

    private final Activity s() {
        return this.springApi.i().a();
    }

    private final boolean t() {
        if (this.springApi.t() || this.springApi.s()) {
            return false;
        }
        return true;
    }

    private final Conversation u() {
        return this.springApi.i().c();
    }

    private final View v() {
        return this.springApi.i().f();
    }

    private final boolean w() {
        return this.springApi.n().a0(this.springApi.n().N().closeTabBannerTime);
    }

    private final void y(String bannerJumpUrl) {
        boolean z16;
        if (this.springApi.k().t0()) {
            QLog.i("SpringTabBannerModule", 2, "onBannerClicked: HongBaoCtrl consumes the click event");
            return;
        }
        if (bannerJumpUrl != null && bannerJumpUrl.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("SpringTabBannerModule", 2, "onBannerClicked: jump url is null or empty");
            return;
        }
        SpringToMainHelper.k(s(), bannerJumpUrl, "0");
        E("banner_mainpg", "clk");
        P("em_top_banner", "em_clk");
        QLog.i("SpringTabBannerModule", 2, "onBannerClicked: banner onClick");
    }

    public final void A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        QLog.d("SpringTabBannerModule", 1, "onMsgTabBannerHide");
        this.isShowingTabBanner = false;
        this.curBannerId = null;
        this.curMsgTabBannerData = null;
        C();
        Q();
    }

    public final void B(@NotNull MsgTabBannerData msgTabBannerData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) msgTabBannerData);
            return;
        }
        Intrinsics.checkNotNullParameter(msgTabBannerData, "msgTabBannerData");
        if (!this.springApi.l().e()) {
            QLog.d("SpringTabBannerModule", 1, "onMsgTabBannerShow is not resume");
            this.springApi.r().o(true);
            return;
        }
        QLog.d("SpringTabBannerModule", 1, "onMsgTabBannerShow");
        if (w()) {
            QLog.d("SpringTabBannerModule", 2, "onMsgTabBannerShow return: is close today");
            A();
            return;
        }
        if (!t()) {
            QLog.d("SpringTabBannerModule", 2, "onMsgTabBannerShow return: is not DefaultTheme or study or elder");
            A();
            return;
        }
        if (this.isShowingTabBanner && Intrinsics.areEqual(msgTabBannerData, this.curMsgTabBannerData)) {
            QLog.d("SpringTabBannerModule", 2, "onMsgTabBannerShow, data is same");
            return;
        }
        this.springApi.i().h().l();
        QLog.d("SpringTabBannerModule", 2, "onMsgTabBannerShow, data = " + msgTabBannerData);
        boolean G = G(msgTabBannerData);
        this.isShowingTabBanner = G;
        if (G) {
            this.curBannerId = msgTabBannerData.f289095id;
            this.curMsgTabBannerData = msgTabBannerData;
        }
        u().removeTitleBackground();
        F();
    }

    public final void F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (!this.springApi.l().e()) {
            return;
        }
        UserData N = this.springApi.n().N();
        Intrinsics.checkNotNullExpressionValue(N, "springApi.manager.userData");
        if (TextUtils.equals(this.curBannerId, N.lastReportTabBannerId)) {
            return;
        }
        E("banner_mainpg", "exp");
        P("", "md_exp");
        N.lastReportTabBannerId = this.curBannerId;
        this.springApi.n().g0();
    }

    @Override // com.tencent.mobileqq.springhb.entry.worker.e.b
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            u().removeTitleBackground();
        }
    }

    @Override // com.tencent.mobileqq.springhb.entry.worker.e.b
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            u().removeTitleBackground();
        }
    }

    public final boolean x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.isShowingTabBanner;
    }

    public final void z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        QLog.d("SpringTabBannerModule", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.isShowingTabBanner = false;
        this.curBannerId = null;
        C();
    }
}
