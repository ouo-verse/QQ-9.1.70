package com.tencent.mobileqq.gamecenter.qa.fragment;

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
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.gamecenter.qa.util.GameQAUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.SystemBarCompact;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J&\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/fragment/QQGameTransparentFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "rh", "qh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "onResume", "", BdhLogUtil.LogTag.Tag_Conn, "Z", "isFirst", "", "D", "Ljava/lang/String;", WadlProxyConsts.KEY_JUMP_URL, "", "E", "I", "miniAppId", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class QQGameTransparentFragment extends QPublicBaseFragment {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isFirst = true;

    /* renamed from: D, reason: from kotlin metadata */
    private String jumpUrl;

    /* renamed from: E, reason: from kotlin metadata */
    private int miniAppId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/fragment/QQGameTransparentFragment$a;", "", "", WadlProxyConsts.KEY_JUMP_URL, "", "miniAppId", "Landroid/content/Intent;", "a", "EXTRA_JUMP_URL", "Ljava/lang/String;", "EXTRA_MINI_APP_ID", "TAG", "<init>", "()V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.gamecenter.qa.fragment.QQGameTransparentFragment$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final Intent a(@NotNull String jumpUrl, int miniAppId) {
            Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString(WadlProxyConsts.KEY_JUMP_URL, jumpUrl);
            bundle.putInt("miniAppId", miniAppId);
            intent.putExtras(bundle);
            return intent;
        }

        Companion() {
        }
    }

    @JvmStatic
    @NotNull
    public static final Intent ph(@NotNull String str, int i3) {
        return INSTANCE.a(str, i3);
    }

    private final void qh() {
        int i3 = this.miniAppId;
        if (i3 > 0) {
            GameQAUtil.w(i3);
        }
    }

    private final void rh() {
        boolean startsWith$default;
        boolean startsWith$default2;
        String str = null;
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[2];
            objArr[0] = "jumpPage jumpUrl:";
            String str2 = this.jumpUrl;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(WadlProxyConsts.KEY_JUMP_URL);
                str2 = null;
            }
            objArr[1] = str2;
            QLog.d("QQGameTransparentFragment", 1, objArr);
        }
        String str3 = this.jumpUrl;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(WadlProxyConsts.KEY_JUMP_URL);
            str3 = null;
        }
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str3, "mqqapi://", false, 2, null);
        if (!startsWith$default) {
            String str4 = this.jumpUrl;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(WadlProxyConsts.KEY_JUMP_URL);
                str4 = null;
            }
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(str4, "mqqguild://", false, 2, null);
            if (!startsWith$default2) {
                Intent intent = new Intent(getActivity(), (Class<?>) QQBrowserActivity.class);
                String str5 = this.jumpUrl;
                if (str5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(WadlProxyConsts.KEY_JUMP_URL);
                } else {
                    str = str5;
                }
                intent.putExtra("url", str);
                requireActivity().startActivity(intent);
                return;
            }
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.business.BaseQQAppInterface");
        BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
        FragmentActivity activity = getActivity();
        String str6 = this.jumpUrl;
        if (str6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(WadlProxyConsts.KEY_JUMP_URL);
        } else {
            str = str6;
        }
        ax c16 = bi.c(baseQQAppInterface, activity, str);
        if (c16 != null) {
            c16.b();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString(WadlProxyConsts.KEY_JUMP_URL);
            if (string == null) {
                string = "";
            }
            this.jumpUrl = string;
            this.miniAppId = arguments.getInt("miniAppId");
        }
        SystemBarCompact systemBarComp = SystemBarActivityModule.getSystemBarComp(getQBaseActivity());
        if (systemBarComp != null) {
            systemBarComp.init();
            systemBarComp.setgetStatusBarVisible(false, 0);
        }
        rh();
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QLog.d("QQGameTransparentFragment", 1, "OpenFeedDetailMethod resume isFirst:", Boolean.valueOf(this.isFirst));
        if (!this.isFirst) {
            qh();
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
        this.isFirst = false;
    }
}
