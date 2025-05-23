package com.tencent.mobileqq.mini.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityForMultiProcess;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.search.report.SearchDtReportExtKt;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.mini.ui.QQMiniAppMigrateDialog;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.base.widget.RoundRectImageView;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\u001a\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/mini/ui/QQMiniAppMigrateDialog;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "()V", "miniAppInfo", "Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;", "getContentLayoutId", "", "getReportInfoMap", "", "", "initWindowStyleAndAnimation", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "miniAppText", "needStatusTrans", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "view", "Landroid/view/View;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "setMigrateImageIcon", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class QQMiniAppMigrateDialog extends QPublicBaseFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String KEY_BUNDLE_MINI_APP_INFO = "key_mini_app_info";
    private static final float MINI_APP_MIGRATE_IMAGE_ASPECT_RATIO = 0.8979592f;
    private static final String TAG = "QQMiniAppMigrateFragment";
    private MiniAppInfo miniAppInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/mini/ui/QQMiniAppMigrateDialog$Companion;", "", "()V", "KEY_BUNDLE_MINI_APP_INFO", "", "MINI_APP_MIGRATE_IMAGE_ASPECT_RATIO", "", "TAG", "showMiniAppMigrateDialog", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "miniAppInfo", "Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void showMiniAppMigrateDialog$lambda$0(MiniAppInfo miniAppInfo, Activity activity) {
            Intrinsics.checkNotNullParameter(miniAppInfo, "$miniAppInfo");
            Intrinsics.checkNotNullParameter(activity, "$activity");
            Intent intent = new Intent();
            intent.putExtra("public_fragment_window_feature", 1);
            intent.putExtra("key_mini_app_info", (Serializable) miniAppInfo);
            QPublicFragmentActivity.b.b(activity, intent, QPublicTransFragmentActivityForMultiProcess.class, QQMiniAppMigrateDialog.class);
        }

        public final void showMiniAppMigrateDialog(final Activity activity, final MiniAppInfo miniAppInfo) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(miniAppInfo, "miniAppInfo");
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mini.ui.l
                @Override // java.lang.Runnable
                public final void run() {
                    QQMiniAppMigrateDialog.Companion.showMiniAppMigrateDialog$lambda$0(MiniAppInfo.this, activity);
                }
            });
        }

        Companion() {
        }
    }

    private final Map<String, String> getReportInfoMap() {
        String str;
        Map<String, String> mutableMapOf;
        com.tencent.mobileqq.wxmini.api.data.d bindingWeChatUserInfo = ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).getBindingWeChatUserInfo();
        if (bindingWeChatUserInfo != null) {
            str = bindingWeChatUserInfo.f();
        } else {
            str = "";
        }
        Pair[] pairArr = new Pair[5];
        pairArr[0] = TuplesKt.to("pgid", "pg_applet_migration_notice_panel");
        MiniAppInfo miniAppInfo = this.miniAppInfo;
        MiniAppInfo miniAppInfo2 = null;
        if (miniAppInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniAppInfo");
            miniAppInfo = null;
        }
        pairArr[1] = TuplesKt.to("applet_appid", miniAppInfo.appId);
        MiniAppInfo miniAppInfo3 = this.miniAppInfo;
        if (miniAppInfo3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniAppInfo");
            miniAppInfo3 = null;
        }
        pairArr[2] = TuplesKt.to("applet_type", String.valueOf(miniAppInfo3.engineType));
        MiniAppInfo miniAppInfo4 = this.miniAppInfo;
        if (miniAppInfo4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniAppInfo");
        } else {
            miniAppInfo2 = miniAppInfo4;
        }
        pairArr[3] = TuplesKt.to("applet_jump_appid", miniAppInfo2.bindingAppId);
        pairArr[4] = TuplesKt.to(StartupReportKey.WX_OPENID, str);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        return mutableMapOf;
    }

    private final String miniAppText() {
        MiniAppInfo miniAppInfo = this.miniAppInfo;
        if (miniAppInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniAppInfo");
            miniAppInfo = null;
        }
        if (miniAppInfo.getReportType() == 0) {
            return QzoneConfig.DEFAULT_MINI_APP_FULL_SCREEN_TITLE;
        }
        return "\u5c0f\u6e38\u620f";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(QQMiniAppMigrateDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).miniAppDesktopCommonPageReport("dt_clck", SearchDtReportExtKt.EM_ID_APPLET_BACK_BUTTON, this$0.getReportInfoMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2$lambda$1(QQMiniAppMigrateDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IWxMiniManager iWxMiniManager = (IWxMiniManager) QRoute.api(IWxMiniManager.class);
        BaseApplication context = BaseApplication.getContext();
        MiniAppInfo miniAppInfo = this$0.miniAppInfo;
        if (miniAppInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniAppInfo");
            miniAppInfo = null;
        }
        iWxMiniManager.startWxMiniAppByAppId(context, miniAppInfo.bindingAppId, "", 3422);
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).miniAppDesktopCommonPageReport("dt_clck", MiniAppDesktopDtReportHelper.MINI_APP_GOTO_WX_APPLET_BUTTON, this$0.getReportInfoMap());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.djc;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        if (activity instanceof QBaseActivity) {
            QBaseActivity qBaseActivity = (QBaseActivity) activity;
            Window window = qBaseActivity.getWindow();
            window.clearFlags(67108864);
            window.getDecorView().setSystemUiVisibility(1024);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
            qBaseActivity.overridePendingTransition(0, 0);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).miniAppDesktopCommonReport("dt_pgout", "", getReportInfoMap(), "pg_applet_migration_notice_panel");
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intent intent;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        view.setPadding(0, ImmersiveUtils.getStatusBarHeight(getContext()), 0, 0);
        FragmentActivity activity = getActivity();
        Serializable serializableExtra = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getSerializableExtra("key_mini_app_info");
        Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type com.tencent.mobileqq.mini.apkg.MiniAppInfo");
        this.miniAppInfo = (MiniAppInfo) serializableExtra;
        setMigrateImageIcon(view);
        ((ImageView) view.findViewById(R.id.rc6)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.ui.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QQMiniAppMigrateDialog.onViewCreated$lambda$0(QQMiniAppMigrateDialog.this, view2);
            }
        });
        TextView textView = (TextView) view.findViewById(R.id.rgz);
        MiniAppInfo miniAppInfo = this.miniAppInfo;
        if (miniAppInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniAppInfo");
            miniAppInfo = null;
        }
        textView.setText(miniAppInfo.name);
        RoundRectImageView roundRectImageView = (RoundRectImageView) view.findViewById(R.id.rjn);
        roundRectImageView.setCornerRadiusAndMode(ViewUtils.dip2px(12.0f), 1);
        Option obtain = Option.obtain();
        MiniAppInfo miniAppInfo2 = this.miniAppInfo;
        if (miniAppInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniAppInfo");
            miniAppInfo2 = null;
        }
        QQPicLoader.f201806a.d().loadImage(obtain.setUrl(miniAppInfo2.iconUrl).setTargetView(roundRectImageView), null);
        ((TextView) view.findViewById(R.id.rcz)).setText("\u6211\u4eec\u5df2\u5b8c\u6210QQ" + miniAppText() + "\u7684\u4f53\u9a8c\u4f18\u5316\uff0c\u540e\u7eed\u4f60\u53ef\u4ee5\u5728QQ\u5185\u76f4\u63a5\u6253\u5f00\u6211\u4eec\u7684\u5fae\u4fe1" + miniAppText() + "\uff0c\u4f7f\u7528\u5347\u7ea7\u540e\u7684\u529f\u80fd\u670d\u52a1\u3002\u70b9\u51fb\u4e0b\u65b9\u6309\u94ae\u5373\u53ef\u4f53\u9a8c\u3002");
        ((Button) view.findViewById(R.id.rdr)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.ui.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QQMiniAppMigrateDialog.onViewCreated$lambda$2$lambda$1(QQMiniAppMigrateDialog.this, view2);
            }
        });
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).miniAppDesktopCommonReport("dt_pgin", "", getReportInfoMap(), "pg_applet_migration_notice_panel");
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }

    private final void setMigrateImageIcon(View view) {
        int roundToInt;
        ImageView imageView = (ImageView) view.findViewById(R.id.rf8);
        if (QQTheme.isNowThemeIsNight()) {
            imageView.setBackgroundResource(R.drawable.iqv);
        } else {
            imageView.setBackgroundResource(R.drawable.iqu);
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        int g16 = com.tencent.videocut.utils.o.g() - Utils.n(32.0f, view.getResources());
        layoutParams2.width = g16;
        roundToInt = MathKt__MathJVMKt.roundToInt(g16 * MINI_APP_MIGRATE_IMAGE_ASPECT_RATIO);
        layoutParams2.height = roundToInt;
        layoutParams2.topMargin = Utils.n(16.0f, view.getResources());
        layoutParams2.addRule(14);
        imageView.setLayoutParams(layoutParams2);
    }
}
