package com.tenpay.form.queryaccount;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.compat.f;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.base.FragmentAnimation;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.qwallet.PayAccountPB$GetInitializationInfoReq;
import com.tencent.mobileqq.pb.qwallet.PayAccountPB$GetInitializationInfoRsp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tenpay.face.FaceVerifyBean;
import com.tenpay.sdk.net.gateway.QWalletGatewayServlet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl2.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0014J&\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u001a\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0002J\b\u0010\u0018\u001a\u00020\u0012H\u0002J\u001c\u0010\u0019\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u001d\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/tenpay/form/queryaccount/IdQueryEntryFragment;", "Lcom/tenpay/form/queryaccount/IdQueryBaseFragment;", "()V", "currentFaceBean", "Lcom/tenpay/face/FaceVerifyBean;", "getFragmentAnimation", "Lcom/tencent/mobileqq/base/FragmentAnimation;", "isStatusBarImmersive", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onInitSuccess", "", "rsp", "Lcom/tencent/mobileqq/pb/qwallet/PayAccountPB$GetInitializationInfoRsp;", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "view", "requestInitializationInfo", "startCheckFacePage", "startFillAccount", "nameMask", "", "faceVerifyBean", "startQueryResult", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class IdQueryEntryFragment extends IdQueryBaseFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String KEY_FACE_VERIFY_BEAN = "KEY_FACE_VERIFY_BEAN";

    @NotNull
    private static final String TAG = "IdQueryEntryFragment";

    @Nullable
    private FaceVerifyBean currentFaceBean;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J8\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/tenpay/form/queryaccount/IdQueryEntryFragment$Companion;", "", "()V", IdQueryEntryFragment.KEY_FACE_VERIFY_BEAN, "", "TAG", "startIdQuery", "", "channelInfo", "tokenId", WadlProxyConsts.CHANNEL, "regbindParam", "context", "Landroid/content/Context;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void startIdQuery(@Nullable String channelInfo, @Nullable String tokenId, @Nullable String channel, @Nullable String regbindParam, @Nullable Context context) {
            FaceVerifyBean faceVerifyBean = new FaceVerifyBean(tokenId, channelInfo, channel, null, null, null, 56, null);
            Intent intent = new Intent();
            intent.putExtra(IdQueryEntryFragment.KEY_FACE_VERIFY_BEAN, faceVerifyBean);
            intent.putExtra(IdQueryResultFragment.KEY_REGBIND_PARAM, regbindParam);
            com.tencent.mobileqq.base.c.f(context, intent, IdQueryEntryFragment.class, false, 8, null);
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onInitSuccess(PayAccountPB$GetInitializationInfoRsp rsp) {
        FaceVerifyBean faceVerifyBean;
        boolean z16 = true;
        QLog.i(TAG, 1, "onInitSuccess: name=" + rsp.name + ",face_verified=" + rsp.face_verified + ",has_provided_namecreid=" + rsp.has_provided_namecreid);
        String str = rsp.channel.get();
        if (str != null && str.length() != 0) {
            z16 = false;
        }
        if (!z16 && (faceVerifyBean = this.currentFaceBean) != null) {
            faceVerifyBean.setChannel(rsp.channel.get());
        }
        if (rsp.face_verified.get()) {
            startQueryResult(this.currentFaceBean);
            return;
        }
        if (rsp.is_identified.get()) {
            startFillAccount(rsp.name.get(), this.currentFaceBean);
        } else if (rsp.has_provided_namecreid.get()) {
            startCheckFacePage();
        } else {
            startFillAccount(null, this.currentFaceBean);
        }
    }

    private final void requestInitializationInfo() {
        String channel;
        String channelInfo;
        String tokenId;
        PayAccountPB$GetInitializationInfoReq payAccountPB$GetInitializationInfoReq = new PayAccountPB$GetInitializationInfoReq();
        FaceVerifyBean faceVerifyBean = this.currentFaceBean;
        if (faceVerifyBean != null && (tokenId = faceVerifyBean.getTokenId()) != null) {
            payAccountPB$GetInitializationInfoReq.token_id.set(tokenId);
        }
        FaceVerifyBean faceVerifyBean2 = this.currentFaceBean;
        if (faceVerifyBean2 != null && (channelInfo = faceVerifyBean2.getChannelInfo()) != null) {
            payAccountPB$GetInitializationInfoReq.channel_info.set(channelInfo);
        }
        FaceVerifyBean faceVerifyBean3 = this.currentFaceBean;
        if (faceVerifyBean3 != null && (channel = faceVerifyBean3.getChannel()) != null) {
            payAccountPB$GetInitializationInfoReq.channel.set(channel);
        }
        h<PayAccountPB$GetInitializationInfoRsp> hVar = new h<PayAccountPB$GetInitializationInfoRsp>() { // from class: com.tenpay.form.queryaccount.IdQueryEntryFragment$requestInitializationInfo$callback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(IdQueryEntryFragment.this);
            }

            @Override // pl2.k
            public void onFail(int errCode, @NotNull String errMsg) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                QLog.i("IdQueryEntryFragment", 1, "GetInitializationInfo fail. " + errCode + " " + errMsg);
            }

            @Override // pl2.k
            public void onSuccess(@NotNull PayAccountPB$GetInitializationInfoRsp rsp) {
                Intrinsics.checkNotNullParameter(rsp, "rsp");
                QLog.i("IdQueryEntryFragment", 1, "GetInitializationInfo succeed.");
                IdQueryEntryFragment.this.onInitSuccess(rsp);
            }
        };
        QWalletGatewayServlet qWalletGatewayServlet = QWalletGatewayServlet.INSTANCE;
        Object newInstance = PayAccountPB$GetInitializationInfoRsp.class.newInstance();
        Intrinsics.checkNotNullExpressionValue(newInstance, "Rsp::class.java.newInstance()");
        qWalletGatewayServlet.sendRequest("trpc.qwallet.cancel.Account", "GetInitializationInfo", payAccountPB$GetInitializationInfoReq, (MessageMicro) newInstance, true, false, true, null, hVar);
    }

    private final void startCheckFacePage() {
        FaceVerifyBean faceVerifyBean = this.currentFaceBean;
        if (faceVerifyBean == null) {
            QLog.w(TAG, 1, "startFace fail, currentFaceBean is null");
        } else {
            startCheckFace(faceVerifyBean, new Function1<FaceVerifyBean, Unit>() { // from class: com.tenpay.form.queryaccount.IdQueryEntryFragment$startCheckFacePage$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(FaceVerifyBean faceVerifyBean2) {
                    invoke2(faceVerifyBean2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable FaceVerifyBean faceVerifyBean2) {
                    IdQueryEntryFragment.this.startQueryResult(faceVerifyBean2);
                }
            }, new Function1<FaceVerifyBean, Unit>() { // from class: com.tenpay.form.queryaccount.IdQueryEntryFragment$startCheckFacePage$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(FaceVerifyBean faceVerifyBean2) {
                    invoke2(faceVerifyBean2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable FaceVerifyBean faceVerifyBean2) {
                    IdQueryEntryFragment.this.finish();
                }
            });
        }
    }

    private final void startFillAccount(String nameMask, FaceVerifyBean faceVerifyBean) {
        String stringExtra;
        Intent intent = new Intent();
        intent.putExtra(KEY_FACE_VERIFY_BEAN, faceVerifyBean);
        intent.putExtra(IdQueryAccountFragment.KEY_NAME_MASK, nameMask);
        Intent intent2 = getIntent();
        if (intent2 != null && (stringExtra = intent2.getStringExtra(IdQueryResultFragment.KEY_REGBIND_PARAM)) != null) {
            intent.putExtra(IdQueryResultFragment.KEY_REGBIND_PARAM, stringExtra);
        }
        com.tencent.mobileqq.base.c.f(getContext(), intent, IdQueryAccountFragment.class, false, 8, null);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startQueryResult(FaceVerifyBean faceVerifyBean) {
        String stringExtra;
        Intent intent = new Intent();
        intent.putExtra(KEY_FACE_VERIFY_BEAN, faceVerifyBean);
        Intent intent2 = getIntent();
        if (intent2 != null && (stringExtra = intent2.getStringExtra(IdQueryResultFragment.KEY_REGBIND_PARAM)) != null) {
            intent.putExtra(IdQueryResultFragment.KEY_REGBIND_PARAM, stringExtra);
        }
        com.tencent.mobileqq.base.c.f(getContext(), intent, IdQueryResultFragment.class, false, 8, null);
        finish();
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    @NotNull
    public FragmentAnimation getFragmentAnimation() {
        return FragmentAnimation.IN_DEFAULT_OUT_NONE;
    }

    @Override // com.tenpay.form.queryaccount.IdQueryBaseFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    protected boolean isStatusBarImmersive() {
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.hjg, container, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.form.queryaccount.IdQueryBaseFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tenpay.form.queryaccount.IdQueryBaseFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        FaceVerifyBean faceVerifyBean;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            faceVerifyBean = (FaceVerifyBean) arguments.getParcelable(KEY_FACE_VERIFY_BEAN);
        } else {
            faceVerifyBean = null;
        }
        this.currentFaceBean = faceVerifyBean;
        requestInitializationInfo();
    }

    @Override // com.tenpay.form.queryaccount.IdQueryBaseFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tenpay.form.queryaccount.IdQueryBaseFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
