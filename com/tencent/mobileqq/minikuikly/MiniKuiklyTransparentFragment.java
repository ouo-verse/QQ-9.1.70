package com.tencent.mobileqq.minikuikly;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.LaunchScene;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.SystemBarCompact;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J&\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/minikuikly/MiniKuiklyTransparentFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "qh", "ph", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "onResume", "", BdhLogUtil.LogTag.Tag_Conn, "Z", "isFirst", "", "D", "Ljava/lang/String;", WadlProxyConsts.KEY_JUMP_URL, "E", "miniAppId", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MiniKuiklyTransparentFragment extends QPublicBaseFragment {

    /* renamed from: F, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: D, reason: from kotlin metadata */
    private String jumpUrl;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isFirst = true;

    /* renamed from: E, reason: from kotlin metadata */
    private String miniAppId = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/minikuikly/MiniKuiklyTransparentFragment$a;", "", "", WadlProxyConsts.KEY_JUMP_URL, "miniAppId", "Landroid/content/Intent;", "a", "EXTRA_JUMP_URL", "Ljava/lang/String;", "EXTRA_MINI_APP_ID", "TAG", "<init>", "()V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.minikuikly.MiniKuiklyTransparentFragment$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Intent a(String jumpUrl, String miniAppId) {
            Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
            Intrinsics.checkNotNullParameter(miniAppId, "miniAppId");
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString(WadlProxyConsts.KEY_JUMP_URL, jumpUrl);
            bundle.putString("miniAppId", miniAppId);
            intent.putExtras(bundle);
            return intent;
        }

        Companion() {
        }
    }

    private final void ph() {
        QLog.d("MiniKuiklyTransparentFragment", 1, "jumpMiniGameApp miniAppId:" + this.miniAppId);
        if (this.miniAppId.length() > 0) {
            QRouteApi api = QRoute.api(IMiniAppService.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IMiniAppService::class.java)");
            ((IMiniAppService) api).startAppByAppid(MobileQQ.sMobileQQ, this.miniAppId, "", "", LaunchScene.LAUNCH_SCENE_GAME_CENTER_QA, null);
        }
    }

    private final void qh() {
        boolean startsWith$default;
        String str = null;
        if (QLog.isColorLevel()) {
            String str2 = this.jumpUrl;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(WadlProxyConsts.KEY_JUMP_URL);
                str2 = null;
            }
            QLog.d("MiniKuiklyTransparentFragment", 2, "jumpPage jumpUrl:" + str2);
        }
        String str3 = this.jumpUrl;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(WadlProxyConsts.KEY_JUMP_URL);
            str3 = null;
        }
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str3, "mqqapi://", false, 2, null);
        if (startsWith$default) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.business.BaseQQAppInterface");
            BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
            FragmentActivity activity = getActivity();
            String str4 = this.jumpUrl;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(WadlProxyConsts.KEY_JUMP_URL);
            } else {
                str = str4;
            }
            ax c16 = bi.c(baseQQAppInterface, activity, str);
            if (c16 != null) {
                c16.b();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString(WadlProxyConsts.KEY_JUMP_URL);
            if (string == null) {
                string = "";
            }
            this.jumpUrl = string;
            String string2 = arguments.getString("miniAppId");
            this.miniAppId = string2 != null ? string2 : "";
        }
        SystemBarCompact systemBarComp = SystemBarActivityModule.getSystemBarComp(getQBaseActivity());
        if (systemBarComp != null) {
            systemBarComp.init();
            systemBarComp.setgetStatusBarVisible(false, 0);
        }
        qh();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QLog.d("MiniKuiklyTransparentFragment", 1, "onResume isFirst:" + this.isFirst);
        if (!this.isFirst) {
            ph();
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
        this.isFirst = false;
    }
}
