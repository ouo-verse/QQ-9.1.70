package com.tenpay.face;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.richframework.compat.f;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.mobileqq.base.c;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.qwallet.PayRecognitionPB$AuthenReq;
import com.tencent.mobileqq.pb.qwallet.PayRecognitionPB$AuthenRsp;
import com.tencent.mobileqq.pb.qwallet.PayRecognitionPB$VerifyReq;
import com.tencent.mobileqq.pb.qwallet.PayRecognitionPB$VerifyRsp;
import com.tencent.mobileqq.qqconnectface.IIdentificationApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.utils.g;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.net.gateway.QWalletGatewayServlet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl2.h;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002JY\u0010\u0014\u001a\u00020\u00022O\u0010\u0013\u001aK\u0012\u0015\u0012\u0013\u0018\u00010\u000f\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00020\u000eH\u0002Ja\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000f2O\u0010\u0013\u001aK\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00020\u000eH\u0002J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0002Ja\u0010\u001c\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\b2M\u0010\u0013\u001aI\u0012\u0013\u0012\u00110\u001a\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00020\u000eH\u0002J\u0012\u0010\u001f\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010 \u001a\u00020\u001aH\u0014R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tenpay/face/QWalletFaceProxyFragment;", "Lcom/tencent/mobileqq/base/QWalletBaseFragment;", "", "start", "Lcom/tenpay/face/FaceVerifyStep;", "enumType", "", "retCode", "", "retMsg", "onFaceFail", "tokenId", "onFaceSuccess", "finishInner", "Lkotlin/Function3;", "Lcom/tencent/mobileqq/pb/qwallet/PayRecognitionPB$AuthenRsp;", "Lkotlin/ParameterName;", "name", "rsp", "callback", WinkDaTongReportConstant.ElementParamValue.XSJ_OPERATION_TYPE_AUTH, "idKey", "gotoFaceGuidePage", "Lcom/tencent/mobileqq/qqconnectface/a;", "requestCallback", "unregisterIdentificationApi", "", "verifySuccess", "verifyIdKey", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "isStatusBarImmersive", "Lcom/tenpay/face/FaceVerifyBean;", "faceVerifyBean", "Lcom/tenpay/face/FaceVerifyBean;", "<init>", "()V", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class QWalletFaceProxyFragment extends QWalletBaseFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int FACE_REQUEST_CODE = 1;

    @NotNull
    public static final String KEY_FACE_START_BEAN = "KEY_FACE_START_BEAN";

    @NotNull
    public static final String KEY_OUT_PARAM_FACE_BEAN = "KEY_OUT_PARAM_FACE_BEAN";

    @NotNull
    public static final String KEY_OUT_PARAM_RET_CODE = "KEY_OUT_PARAM_RET_CODE";

    @NotNull
    public static final String KEY_OUT_PARAM_RET_MSG = "KEY_OUT_PARAM_RET_MSG";

    @NotNull
    public static final String KEY_OUT_PARAM_STEP_TYPE = "KEY_OUT_PARAM_STEP_TYPE";

    @NotNull
    private static final String TAG = "QWalletFaceProxyFragment";
    private FaceVerifyBean faceVerifyBean;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tenpay/face/QWalletFaceProxyFragment$Companion;", "", "()V", "FACE_REQUEST_CODE", "", QWalletFaceProxyFragment.KEY_FACE_START_BEAN, "", QWalletFaceProxyFragment.KEY_OUT_PARAM_FACE_BEAN, QWalletFaceProxyFragment.KEY_OUT_PARAM_RET_CODE, QWalletFaceProxyFragment.KEY_OUT_PARAM_RET_MSG, QWalletFaceProxyFragment.KEY_OUT_PARAM_STEP_TYPE, "TAG", "start", "", "context", "Landroid/content/Context;", "bean", "Lcom/tenpay/face/FaceVerifyBean;", "requestCode", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void start(@NotNull Context context, @NotNull FaceVerifyBean bean, int requestCode) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(bean, "bean");
            Intent intent = new Intent();
            intent.putExtra(QWalletFaceProxyFragment.KEY_FACE_START_BEAN, bean);
            c.i(context, intent, QWalletFaceProxyFragment.class, requestCode, false, 16, null);
        }

        Companion() {
        }
    }

    private final void auth(final Function3<? super PayRecognitionPB$AuthenRsp, ? super Integer, ? super String, Unit> callback) {
        showLoading();
        PayRecognitionPB$AuthenReq payRecognitionPB$AuthenReq = new PayRecognitionPB$AuthenReq();
        FaceVerifyBean faceVerifyBean = this.faceVerifyBean;
        FaceVerifyBean faceVerifyBean2 = null;
        if (faceVerifyBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("faceVerifyBean");
            faceVerifyBean = null;
        }
        String tokenId = faceVerifyBean.getTokenId();
        if (tokenId != null) {
            payRecognitionPB$AuthenReq.token_id.set(tokenId);
        }
        FaceVerifyBean faceVerifyBean3 = this.faceVerifyBean;
        if (faceVerifyBean3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("faceVerifyBean");
            faceVerifyBean3 = null;
        }
        String channelInfo = faceVerifyBean3.getChannelInfo();
        if (channelInfo != null) {
            payRecognitionPB$AuthenReq.channel_info.set(channelInfo);
        }
        FaceVerifyBean faceVerifyBean4 = this.faceVerifyBean;
        if (faceVerifyBean4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("faceVerifyBean");
            faceVerifyBean4 = null;
        }
        String name = faceVerifyBean4.getName();
        if (name != null) {
            payRecognitionPB$AuthenReq.name.set(name);
        }
        FaceVerifyBean faceVerifyBean5 = this.faceVerifyBean;
        if (faceVerifyBean5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("faceVerifyBean");
            faceVerifyBean5 = null;
        }
        Integer creType = faceVerifyBean5.getCreType();
        if (creType != null) {
            payRecognitionPB$AuthenReq.cre_type.set(creType.intValue());
        }
        FaceVerifyBean faceVerifyBean6 = this.faceVerifyBean;
        if (faceVerifyBean6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("faceVerifyBean");
        } else {
            faceVerifyBean2 = faceVerifyBean6;
        }
        String creId = faceVerifyBean2.getCreId();
        if (creId != null) {
            payRecognitionPB$AuthenReq.cre_id.set(creId);
        }
        h<PayRecognitionPB$AuthenRsp> hVar = new h<PayRecognitionPB$AuthenRsp>() { // from class: com.tenpay.face.QWalletFaceProxyFragment$auth$requestCallback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(QWalletFaceProxyFragment.this);
            }

            @Override // pl2.k
            public void onFail(int errCode, @NotNull String errMsg) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                QWalletFaceProxyFragment.this.dismissLoading();
                QLog.i("QWalletFaceProxyFragment", 1, "auth onFail. " + errMsg);
                callback.invoke(null, Integer.valueOf(errCode), errMsg);
            }

            @Override // pl2.k
            public void onSuccess(@NotNull PayRecognitionPB$AuthenRsp rsp) {
                Intrinsics.checkNotNullParameter(rsp, "rsp");
                QWalletFaceProxyFragment.this.dismissLoading();
                QLog.i("QWalletFaceProxyFragment", 1, "auth succeed. " + rsp.token_id.get() + "," + rsp.openid.get() + "," + rsp.appid.get() + "," + rsp.tmpkey.get());
                Function3<PayRecognitionPB$AuthenRsp, Integer, String, Unit> function3 = callback;
                FaceVerifyErr faceVerifyErr = FaceVerifyErr.OK;
                function3.invoke(rsp, Integer.valueOf(faceVerifyErr.getRetCode()), faceVerifyErr.getRetMsg());
            }
        };
        QWalletGatewayServlet qWalletGatewayServlet = QWalletGatewayServlet.INSTANCE;
        Object newInstance = PayRecognitionPB$AuthenRsp.class.newInstance();
        Intrinsics.checkNotNullExpressionValue(newInstance, "Rsp::class.java.newInstance()");
        qWalletGatewayServlet.sendRequest("trpc.qwallet.face.Recognition", "Authen", payRecognitionPB$AuthenReq, (MessageMicro) newInstance, true, false, false, null, hVar);
    }

    private final void finishInner() {
        int e16 = g.e("qwallet_end_face_delay", 0);
        if (e16 == 0) {
            finish();
        } else {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tenpay.face.b
                @Override // java.lang.Runnable
                public final void run() {
                    QWalletFaceProxyFragment.finishInner$lambda$4(QWalletFaceProxyFragment.this);
                }
            }, e16 * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void finishInner$lambda$4(QWalletFaceProxyFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void gotoFaceGuidePage(PayRecognitionPB$AuthenRsp rsp, final Function3<? super String, ? super Integer, ? super String, Unit> callback) {
        com.tencent.mobileqq.qqconnectface.b bVar = new com.tencent.mobileqq.qqconnectface.b();
        try {
            String str = rsp.appid.get();
            Intrinsics.checkNotNullExpressionValue(str, "rsp.appid.get()");
            bVar.f262371a = Integer.parseInt(str);
        } catch (Exception unused) {
            QLog.w(TAG, 1, "appId error: " + rsp.appid.get());
        }
        bVar.f262372b = "qwalletIdentify";
        bVar.f262374d = com.tencent.mobileqq.base.a.c();
        bVar.f262376f = rsp.tmpkey.get();
        bVar.f262375e = rsp.openid.get();
        bVar.f262377g = 1;
        ((IIdentificationApi) QRoute.api(IIdentificationApi.class)).startIdentification(getContext(), bVar, new com.tencent.mobileqq.qqconnectface.a() { // from class: com.tenpay.face.QWalletFaceProxyFragment$gotoFaceGuidePage$requestCallback$1
            @Override // com.tencent.mobileqq.qqconnectface.a
            public void onIdentificationCanceled() {
                super.onIdentificationCanceled();
                QLog.w("QWalletFaceProxyFragment", 1, "onIdentificationCanceled");
                QWalletFaceProxyFragment.this.unregisterIdentificationApi(this);
                Function3<String, Integer, String, Unit> function3 = callback;
                FaceVerifyErr faceVerifyErr = FaceVerifyErr.ERROR_CANCEL;
                function3.invoke(null, Integer.valueOf(faceVerifyErr.getRetCode()), faceVerifyErr.getRetMsg());
            }

            @Override // com.tencent.mobileqq.qqconnectface.a
            public void onIdentificationFailed(@Nullable com.tencent.mobileqq.qqconnectface.c result) {
                int retCode;
                String str2;
                super.onIdentificationFailed(result);
                QLog.w("QWalletFaceProxyFragment", 1, "onIdentificationFailed " + result);
                QWalletFaceProxyFragment.this.unregisterIdentificationApi(this);
                Function3<String, Integer, String, Unit> function3 = callback;
                if (result != null) {
                    retCode = result.f262378a;
                } else {
                    retCode = FaceVerifyErr.ERROR_PARAMS.getRetCode();
                }
                Integer valueOf = Integer.valueOf(retCode);
                if (result != null) {
                    str2 = result.f262379b;
                } else {
                    str2 = null;
                }
                function3.invoke(null, valueOf, str2);
            }

            @Override // com.tencent.mobileqq.qqconnectface.a
            public void onIdentificationSuccess(@Nullable com.tencent.mobileqq.qqconnectface.c result) {
                String str2;
                super.onIdentificationSuccess(result);
                QLog.i("QWalletFaceProxyFragment", 1, "onIdentificationSuccess " + result);
                QWalletFaceProxyFragment.this.unregisterIdentificationApi(this);
                Function3<String, Integer, String, Unit> function3 = callback;
                if (result != null) {
                    str2 = result.f262380c;
                } else {
                    str2 = null;
                }
                FaceVerifyErr faceVerifyErr = FaceVerifyErr.OK;
                function3.invoke(str2, Integer.valueOf(faceVerifyErr.getRetCode()), faceVerifyErr.getRetMsg());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(QWalletFaceProxyFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onFaceFail(FaceVerifyStep enumType, int retCode, String retMsg) {
        QLog.i(TAG, 1, "onFaceFail: " + enumType + " " + retCode + " " + retMsg);
        Intent intent = new Intent();
        intent.putExtra(KEY_OUT_PARAM_RET_CODE, retCode);
        intent.putExtra(KEY_OUT_PARAM_RET_MSG, retMsg);
        intent.putExtra(KEY_OUT_PARAM_STEP_TYPE, enumType);
        setResult(-1, intent);
        finishInner();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onFaceSuccess(int retCode, String tokenId) {
        QLog.i(TAG, 1, "onFaceSuccess: " + tokenId);
        Intent intent = new Intent();
        intent.putExtra(KEY_OUT_PARAM_RET_CODE, retCode);
        intent.putExtra(KEY_OUT_PARAM_STEP_TYPE, FaceVerifyStep.FINISH);
        FaceVerifyBean faceVerifyBean = this.faceVerifyBean;
        if (faceVerifyBean == null) {
            Intrinsics.throwUninitializedPropertyAccessException("faceVerifyBean");
            faceVerifyBean = null;
        }
        intent.putExtra(KEY_OUT_PARAM_FACE_BEAN, faceVerifyBean);
        setResult(-1, intent);
        finishInner();
    }

    @JvmStatic
    public static final void start(@NotNull Context context, @NotNull FaceVerifyBean faceVerifyBean, int i3) {
        INSTANCE.start(context, faceVerifyBean, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void unregisterIdentificationApi(com.tencent.mobileqq.qqconnectface.a requestCallback) {
        try {
            ((IIdentificationApi) QRoute.api(IIdentificationApi.class)).unregisterCallback(getContext(), requestCallback);
        } catch (Exception unused) {
            QLog.w(TAG, 1, "unregisterCallback");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void verifyIdKey(String idKey, final Function3<? super Boolean, ? super Integer, ? super String, Unit> callback) {
        boolean z16;
        if (idKey != null && idKey.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        FaceVerifyBean faceVerifyBean = null;
        if (z16) {
            QLog.i(TAG, 1, "verifyIdKey fail: idKey is null");
            callback.invoke(Boolean.FALSE, Integer.valueOf(FaceVerifyErr.ERROR_PARAMS.getRetCode()), null);
            return;
        }
        PayRecognitionPB$VerifyReq payRecognitionPB$VerifyReq = new PayRecognitionPB$VerifyReq();
        FaceVerifyBean faceVerifyBean2 = this.faceVerifyBean;
        if (faceVerifyBean2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("faceVerifyBean");
            faceVerifyBean2 = null;
        }
        String tokenId = faceVerifyBean2.getTokenId();
        if (tokenId != null) {
            payRecognitionPB$VerifyReq.token_id.set(tokenId);
        }
        FaceVerifyBean faceVerifyBean3 = this.faceVerifyBean;
        if (faceVerifyBean3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("faceVerifyBean");
        } else {
            faceVerifyBean = faceVerifyBean3;
        }
        String channelInfo = faceVerifyBean.getChannelInfo();
        if (channelInfo != null) {
            payRecognitionPB$VerifyReq.channel_info.set(channelInfo);
        }
        payRecognitionPB$VerifyReq.id_key.set(idKey);
        h<PayRecognitionPB$VerifyRsp> hVar = new h<PayRecognitionPB$VerifyRsp>() { // from class: com.tenpay.face.QWalletFaceProxyFragment$verifyIdKey$requestCallback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(QWalletFaceProxyFragment.this);
            }

            @Override // pl2.k
            public void onFail(int errCode, @NotNull String errMsg) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                QWalletFaceProxyFragment.this.dismissLoading();
                QLog.w("QWalletFaceProxyFragment", 1, "verifyIdKey onFail. " + errMsg);
                callback.invoke(Boolean.FALSE, Integer.valueOf(errCode), errMsg);
            }

            @Override // pl2.k
            public void onSuccess(@NotNull PayRecognitionPB$VerifyRsp rsp) {
                Intrinsics.checkNotNullParameter(rsp, "rsp");
                QWalletFaceProxyFragment.this.dismissLoading();
                QLog.i("QWalletFaceProxyFragment", 1, "verifyIdKey succeed: " + rsp.result.get());
                if (rsp.result.get() == 1) {
                    callback.invoke(Boolean.TRUE, 0, null);
                } else {
                    callback.invoke(Boolean.FALSE, Integer.valueOf(rsp.result.get()), null);
                }
            }
        };
        QWalletGatewayServlet qWalletGatewayServlet = QWalletGatewayServlet.INSTANCE;
        Object newInstance = PayRecognitionPB$VerifyRsp.class.newInstance();
        Intrinsics.checkNotNullExpressionValue(newInstance, "Rsp::class.java.newInstance()");
        qWalletGatewayServlet.sendRequest("trpc.qwallet.face.Recognition", "Verify", payRecognitionPB$VerifyReq, (MessageMicro) newInstance, true, false, false, null, hVar);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    protected boolean isStatusBarImmersive() {
        return true;
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        FaceVerifyBean faceVerifyBean;
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if (intent != null) {
            faceVerifyBean = (FaceVerifyBean) intent.getParcelableExtra(KEY_FACE_START_BEAN);
        } else {
            faceVerifyBean = null;
        }
        if (faceVerifyBean == null) {
            QLog.w(TAG, 1, "start param error, no KEY_FACE_START_BEAN");
            onFaceFail(FaceVerifyStep.AUTH, FaceVerifyErr.ERROR_PARAMS.getRetCode(), getString(R.string.f214485t1));
            return;
        }
        this.faceVerifyBean = faceVerifyBean;
        int e16 = g.e("qwallet_start_face_delay", 0);
        if (e16 == 0) {
            start();
        } else {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tenpay.face.a
                @Override // java.lang.Runnable
                public final void run() {
                    QWalletFaceProxyFragment.onCreate$lambda$1(QWalletFaceProxyFragment.this);
                }
            }, e16 * 1000);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    private final void start() {
        auth(new Function3<PayRecognitionPB$AuthenRsp, Integer, String, Unit>() { // from class: com.tenpay.face.QWalletFaceProxyFragment$start$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(PayRecognitionPB$AuthenRsp payRecognitionPB$AuthenRsp, Integer num, String str) {
                invoke(payRecognitionPB$AuthenRsp, num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable final PayRecognitionPB$AuthenRsp payRecognitionPB$AuthenRsp, int i3, @Nullable String str) {
                if (payRecognitionPB$AuthenRsp == null) {
                    QWalletFaceProxyFragment.this.onFaceFail(FaceVerifyStep.AUTH, i3, str);
                } else {
                    final QWalletFaceProxyFragment qWalletFaceProxyFragment = QWalletFaceProxyFragment.this;
                    qWalletFaceProxyFragment.gotoFaceGuidePage(payRecognitionPB$AuthenRsp, new Function3<String, Integer, String, Unit>() { // from class: com.tenpay.face.QWalletFaceProxyFragment$start$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(String str2, Integer num, String str3) {
                            invoke(str2, num.intValue(), str3);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@Nullable String str2, int i16, @Nullable String str3) {
                            if (str2 == null) {
                                QWalletFaceProxyFragment.this.onFaceFail(FaceVerifyStep.FACE, i16, str3);
                                return;
                            }
                            final QWalletFaceProxyFragment qWalletFaceProxyFragment2 = QWalletFaceProxyFragment.this;
                            final PayRecognitionPB$AuthenRsp payRecognitionPB$AuthenRsp2 = payRecognitionPB$AuthenRsp;
                            qWalletFaceProxyFragment2.verifyIdKey(str2, new Function3<Boolean, Integer, String, Unit>() { // from class: com.tenpay.face.QWalletFaceProxyFragment.start.1.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num, String str4) {
                                    invoke(bool.booleanValue(), num.intValue(), str4);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(boolean z16, int i17, @Nullable String str4) {
                                    if (!z16) {
                                        QWalletFaceProxyFragment.this.onFaceFail(FaceVerifyStep.VERIFY, i17, str4);
                                        return;
                                    }
                                    QWalletFaceProxyFragment qWalletFaceProxyFragment3 = QWalletFaceProxyFragment.this;
                                    String str5 = payRecognitionPB$AuthenRsp2.token_id.get();
                                    Intrinsics.checkNotNullExpressionValue(str5, "authParamRsp.token_id.get()");
                                    qWalletFaceProxyFragment3.onFaceSuccess(i17, str5);
                                }
                            });
                        }
                    });
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
