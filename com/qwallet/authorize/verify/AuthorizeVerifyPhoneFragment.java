package com.qwallet.authorize.verify;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00182\u00020\u0001:\u0002\u0019\u001aB\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J&\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\b\u0010\u0010\u001a\u00020\u000eH\u0014J\b\u0010\u0011\u001a\u00020\u000eH\u0016R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001b"}, d2 = {"Lcom/qwallet/authorize/verify/AuthorizeVerifyPhoneFragment;", "Lcom/tencent/mobileqq/base/QWalletBaseFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "isStatusBarImmersive", "isStatusBarDarkText", "isAllowLandscape", "Lcom/qwallet/authorize/verify/AuthorizeBaseVerifyVC;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qwallet/authorize/verify/AuthorizeBaseVerifyVC;", "verifyVC", "<init>", "()V", "D", "a", "EnumVerifyMode", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class AuthorizeVerifyPhoneFragment extends QWalletBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private AuthorizeBaseVerifyVC verifyVC;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/qwallet/authorize/verify/AuthorizeVerifyPhoneFragment$EnumVerifyMode;", "", "(Ljava/lang/String;I)V", "ADD", "RENEW", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public enum EnumVerifyMode {
        ADD,
        RENEW
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment
    public boolean isAllowLandscape() {
        return true;
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    protected boolean isStatusBarDarkText() {
        return !QQTheme.isColorDark(requireActivity().getWindow().getDecorView().getResources().getColor(R.color.qui_common_bg_middle_light));
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    protected boolean isStatusBarImmersive() {
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.f168971hi0, container, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        AuthorizeBaseVerifyVC authorizeBaseVerifyVC = this.verifyVC;
        if (authorizeBaseVerifyVC == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyVC");
            authorizeBaseVerifyVC = null;
        }
        authorizeBaseVerifyVC.s();
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Serializable serializable;
        AuthorizeBaseVerifyVC aVar;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        requireActivity().getWindow().setSoftInputMode(19);
        Bundle arguments = getArguments();
        if (arguments == null || (serializable = arguments.getSerializable("KEY_VERIFY_MODE")) == null) {
            serializable = EnumVerifyMode.ADD;
        }
        Intrinsics.checkNotNullExpressionValue(serializable, "arguments?.getSerializab\u2026DE) ?: EnumVerifyMode.ADD");
        if (serializable == EnumVerifyMode.ADD) {
            aVar = new a(view, getArguments(), this);
        } else if (serializable == EnumVerifyMode.RENEW) {
            aVar = new AuthorizeRenewVC(view, getArguments(), this);
        } else {
            aVar = new a(view, getArguments(), this);
        }
        this.verifyVC = aVar;
    }
}
