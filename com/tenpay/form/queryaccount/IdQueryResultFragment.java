package com.tenpay.form.queryaccount;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.compat.f;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.qwallet.PayAccountPB$CancelAccountByFaceReq;
import com.tencent.mobileqq.pb.qwallet.PayAccountPB$CancelAccountByFaceRsp;
import com.tencent.mobileqq.pb.qwallet.PayAccountPB$GetMyAccountsReq;
import com.tencent.mobileqq.pb.qwallet.PayAccountPB$GetMyAccountsRsp;
import com.tencent.mobileqq.pb.qwallet.PayAccountPB$UIN;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.qwallet.utils.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tenpay.face.FaceVerifyBean;
import com.tenpay.form.queryaccount.IdQueryResultAdapter;
import com.tenpay.sdk.net.gateway.QWalletGatewayServlet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl2.h;
import sk2.WalletConstantsConfig;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B\u0005\u00a2\u0006\u0002\u0010\u0003J%\u0010\n\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u000e0\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\tH\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/tenpay/form/queryaccount/IdQueryResultFragment;", "Lcom/tenpay/form/queryaccount/IdQueryBaseFragment;", "Lcom/tenpay/form/queryaccount/IdQueryResultAdapter$OnCancelAccountListener;", "()V", "accountAdapter", "Lcom/tenpay/form/queryaccount/IdQueryResultAdapter;", "faceVerifyBean", "Lcom/tenpay/face/FaceVerifyBean;", "tempCancelUin", "Lcom/tencent/mobileqq/pb/qwallet/PayAccountPB$UIN;", "getFaceVerifySuccessAction", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "initData", "initView", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/View;", "isStatusBarImmersive", "", "onCancelClick", "data", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "view", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class IdQueryResultFragment extends IdQueryBaseFragment implements IdQueryResultAdapter.OnCancelAccountListener {
    private static final int ERR_CODE_NEED_RE_FACE = 268441750;

    @NotNull
    public static final String KEY_QPWD_TOKEN = "KEY_QPWD_TOKEN";

    @NotNull
    public static final String KEY_REGBIND_PARAM = "KEY_REGBIND_PARAM";

    @NotNull
    public static final String TAG = "IdQueryResultFragment";
    private IdQueryResultAdapter accountAdapter;
    private FaceVerifyBean faceVerifyBean;

    @Nullable
    private PayAccountPB$UIN tempCancelUin;

    private final void initData() {
        String str;
        PayAccountPB$GetMyAccountsReq payAccountPB$GetMyAccountsReq = new PayAccountPB$GetMyAccountsReq();
        FaceVerifyBean faceVerifyBean = this.faceVerifyBean;
        String str2 = null;
        if (faceVerifyBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("faceVerifyBean");
            faceVerifyBean = null;
        }
        String tokenId = faceVerifyBean.getTokenId();
        if (tokenId != null) {
            payAccountPB$GetMyAccountsReq.token_id.set(tokenId);
        }
        FaceVerifyBean faceVerifyBean2 = this.faceVerifyBean;
        if (faceVerifyBean2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("faceVerifyBean");
            faceVerifyBean2 = null;
        }
        String channelInfo = faceVerifyBean2.getChannelInfo();
        if (channelInfo != null) {
            payAccountPB$GetMyAccountsReq.channel_info.set(channelInfo);
        }
        FaceVerifyBean faceVerifyBean3 = this.faceVerifyBean;
        if (faceVerifyBean3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("faceVerifyBean");
            faceVerifyBean3 = null;
        }
        String channel = faceVerifyBean3.getChannel();
        if (channel != null) {
            payAccountPB$GetMyAccountsReq.channel.set(channel);
        }
        FaceVerifyBean faceVerifyBean4 = this.faceVerifyBean;
        if (faceVerifyBean4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("faceVerifyBean");
            faceVerifyBean4 = null;
        }
        String creId = faceVerifyBean4.getCreId();
        if (creId != null) {
            payAccountPB$GetMyAccountsReq.cre_id.set(creId);
        }
        FaceVerifyBean faceVerifyBean5 = this.faceVerifyBean;
        if (faceVerifyBean5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("faceVerifyBean");
            faceVerifyBean5 = null;
        }
        String name = faceVerifyBean5.getName();
        if (name != null) {
            payAccountPB$GetMyAccountsReq.name.set(name);
        }
        FaceVerifyBean faceVerifyBean6 = this.faceVerifyBean;
        if (faceVerifyBean6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("faceVerifyBean");
            faceVerifyBean6 = null;
        }
        Integer creType = faceVerifyBean6.getCreType();
        if (creType != null) {
            payAccountPB$GetMyAccountsReq.cre_type.set(creType.intValue());
        }
        Intent intent = getIntent();
        if (intent != null) {
            str = intent.getStringExtra(KEY_QPWD_TOKEN);
        } else {
            str = null;
        }
        if (str != null) {
            payAccountPB$GetMyAccountsReq.pwd_token.set(str);
        }
        Intent intent2 = getIntent();
        if (intent2 != null) {
            str2 = intent2.getStringExtra(KEY_REGBIND_PARAM);
        }
        if (str2 != null) {
            payAccountPB$GetMyAccountsReq.regbind_param.set(str2);
        }
        h<PayAccountPB$GetMyAccountsRsp> hVar = new h<PayAccountPB$GetMyAccountsRsp>() { // from class: com.tenpay.form.queryaccount.IdQueryResultFragment$initData$callback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(IdQueryResultFragment.this);
            }

            @Override // pl2.k
            public void onFail(int errCode, @NotNull String errMsg) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                QLog.i(IdQueryResultFragment.TAG, 1, "GetMyAccountsRsp fail. " + errCode + " " + errMsg);
            }

            @Override // pl2.k
            public void onSuccess(@NotNull PayAccountPB$GetMyAccountsRsp rsp) {
                IdQueryResultAdapter idQueryResultAdapter;
                Intrinsics.checkNotNullParameter(rsp, "rsp");
                List<PayAccountPB$UIN> list = rsp.uins.get();
                IdQueryResultAdapter idQueryResultAdapter2 = null;
                QLog.i(IdQueryResultFragment.TAG, 1, "GetMyAccountsRsp succeed. " + (list != null ? Integer.valueOf(list.size()) : null));
                idQueryResultAdapter = IdQueryResultFragment.this.accountAdapter;
                if (idQueryResultAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("accountAdapter");
                } else {
                    idQueryResultAdapter2 = idQueryResultAdapter;
                }
                idQueryResultAdapter2.updateData(rsp.uins.get());
            }
        };
        QWalletGatewayServlet qWalletGatewayServlet = QWalletGatewayServlet.INSTANCE;
        Object newInstance = PayAccountPB$GetMyAccountsRsp.class.newInstance();
        Intrinsics.checkNotNullExpressionValue(newInstance, "Rsp::class.java.newInstance()");
        qWalletGatewayServlet.sendRequest("trpc.qwallet.cancel.Account", "GetMyAccounts", payAccountPB$GetMyAccountsReq, (MessageMicro) newInstance, true, false, true, null, hVar);
    }

    private final void initView(View rootView) {
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.xfm);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        IdQueryResultAdapter idQueryResultAdapter = this.accountAdapter;
        String str = null;
        if (idQueryResultAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountAdapter");
            idQueryResultAdapter = null;
        }
        recyclerView.setAdapter(idQueryResultAdapter);
        TextView textView = (TextView) rootView.findViewById(R.id.xf7);
        final WalletConstantsConfig.NormalQuestion accountQuestion = ((WalletConstantsConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_COMMON_CONSTANT, new WalletConstantsConfig(null, 1, null))).getContent().getAccountQuestion();
        if (accountQuestion != null) {
            str = accountQuestion.getTitle();
        }
        textView.setText(str);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.form.queryaccount.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IdQueryResultFragment.initView$lambda$3$lambda$2(IdQueryResultFragment.this, accountQuestion, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3$lambda$2(IdQueryResultFragment this$0, WalletConstantsConfig.NormalQuestion normalQuestion, View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        if (normalQuestion != null) {
            str = normalQuestion.getUrl();
        } else {
            str = null;
        }
        k.h(context, str);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(IdQueryResultFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tenpay.form.queryaccount.IdQueryBaseFragment
    @NotNull
    public Function1<FaceVerifyBean, Unit> getFaceVerifySuccessAction() {
        Function1<FaceVerifyBean, Unit> faceVerifySuccessAction = super.getFaceVerifySuccessAction();
        if (faceVerifySuccessAction != null) {
            return faceVerifySuccessAction;
        }
        return new Function1<FaceVerifyBean, Unit>() { // from class: com.tenpay.form.queryaccount.IdQueryResultFragment$getFaceVerifySuccessAction$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FaceVerifyBean faceVerifyBean) {
                invoke2(faceVerifyBean);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable FaceVerifyBean faceVerifyBean) {
                PayAccountPB$UIN payAccountPB$UIN;
                payAccountPB$UIN = IdQueryResultFragment.this.tempCancelUin;
                if (payAccountPB$UIN != null) {
                    IdQueryResultFragment idQueryResultFragment = IdQueryResultFragment.this;
                    idQueryResultFragment.onCancelClick(payAccountPB$UIN);
                    idQueryResultFragment.tempCancelUin = null;
                }
            }
        };
    }

    @Override // com.tenpay.form.queryaccount.IdQueryBaseFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    protected boolean isStatusBarImmersive() {
        return true;
    }

    @Override // com.tenpay.form.queryaccount.IdQueryResultAdapter.OnCancelAccountListener
    public void onCancelClick(@NotNull final PayAccountPB$UIN data) {
        Intrinsics.checkNotNullParameter(data, "data");
        PayAccountPB$CancelAccountByFaceReq payAccountPB$CancelAccountByFaceReq = new PayAccountPB$CancelAccountByFaceReq();
        FaceVerifyBean faceVerifyBean = this.faceVerifyBean;
        IdQueryResultAdapter idQueryResultAdapter = null;
        if (faceVerifyBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("faceVerifyBean");
            faceVerifyBean = null;
        }
        String tokenId = faceVerifyBean.getTokenId();
        if (tokenId != null) {
            payAccountPB$CancelAccountByFaceReq.token_id.set(tokenId);
        }
        FaceVerifyBean faceVerifyBean2 = this.faceVerifyBean;
        if (faceVerifyBean2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("faceVerifyBean");
            faceVerifyBean2 = null;
        }
        String channelInfo = faceVerifyBean2.getChannelInfo();
        if (channelInfo != null) {
            payAccountPB$CancelAccountByFaceReq.channel_info.set(channelInfo);
        }
        FaceVerifyBean faceVerifyBean3 = this.faceVerifyBean;
        if (faceVerifyBean3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("faceVerifyBean");
            faceVerifyBean3 = null;
        }
        String channel = faceVerifyBean3.getChannel();
        if (channel != null) {
            payAccountPB$CancelAccountByFaceReq.channel.set(channel);
        }
        payAccountPB$CancelAccountByFaceReq.uin.set(data);
        IdQueryResultAdapter idQueryResultAdapter2 = this.accountAdapter;
        if (idQueryResultAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountAdapter");
        } else {
            idQueryResultAdapter = idQueryResultAdapter2;
        }
        final IdQueryResultFragment fragment = idQueryResultAdapter.getFragment();
        h<PayAccountPB$CancelAccountByFaceRsp> hVar = new h<PayAccountPB$CancelAccountByFaceRsp>(fragment) { // from class: com.tenpay.form.queryaccount.IdQueryResultFragment$onCancelClick$callback$1
            @Override // pl2.k
            public void onFail(int errCode, @NotNull String errMsg) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                QLog.i(IdQueryResultFragment.TAG, 1, "cancelAccount fail. " + errCode + " " + errMsg);
                this.tempCancelUin = PayAccountPB$UIN.this;
            }

            @Override // pl2.k
            public void onSuccess(@NotNull PayAccountPB$CancelAccountByFaceRsp rsp) {
                IdQueryResultAdapter idQueryResultAdapter3;
                Intrinsics.checkNotNullParameter(rsp, "rsp");
                QLog.i(IdQueryResultFragment.TAG, 1, "cancelAccount succeed. " + PayAccountPB$UIN.this.uin.get());
                idQueryResultAdapter3 = this.accountAdapter;
                if (idQueryResultAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("accountAdapter");
                    idQueryResultAdapter3 = null;
                }
                idQueryResultAdapter3.onCancelAccountSuccess(PayAccountPB$UIN.this);
            }
        };
        QWalletGatewayServlet qWalletGatewayServlet = QWalletGatewayServlet.INSTANCE;
        Object newInstance = PayAccountPB$CancelAccountByFaceRsp.class.newInstance();
        Intrinsics.checkNotNullExpressionValue(newInstance, "Rsp::class.java.newInstance()");
        qWalletGatewayServlet.sendRequest("trpc.qwallet.cancel.Account", "CancelAccountByFace", payAccountPB$CancelAccountByFaceReq, (MessageMicro) newInstance, true, false, true, null, hVar);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.hji, container, false);
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
        ((TextView) view.findViewById(R.id.ivTitleBtnLeft)).setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.form.queryaccount.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                IdQueryResultFragment.onViewCreated$lambda$0(IdQueryResultFragment.this, view2);
            }
        });
        Intent intent = getIntent();
        if (intent != null) {
            faceVerifyBean = (FaceVerifyBean) intent.getParcelableExtra(IdQueryEntryFragment.KEY_FACE_VERIFY_BEAN);
        } else {
            faceVerifyBean = null;
        }
        if (faceVerifyBean == null) {
            QLog.i(TAG, 1, "param error. " + getIntent());
            finish();
            return;
        }
        this.faceVerifyBean = faceVerifyBean;
        this.accountAdapter = new IdQueryResultAdapter(this, this);
        initView(view);
        initData();
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
