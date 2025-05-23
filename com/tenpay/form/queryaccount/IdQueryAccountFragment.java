package com.tenpay.form.queryaccount;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.qwallet.activity.patternlock.PatternLockHelper;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.compat.f;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.base.FragmentAnimation;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.qwallet.PayAccountPB$CheckCreIDForIdentifiedUserReq;
import com.tencent.mobileqq.pb.qwallet.PayAccountPB$CheckCreIDForIdentifiedUserRsp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.qwallet.utils.k;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tenpay.api.TenpayInterface;
import com.tenpay.face.FaceVerifyBean;
import com.tenpay.form.QWalletBaseIdFormVC;
import com.tenpay.form.queryaccount.IdQueryAccountFragment;
import com.tenpay.sdk.activity.PassVerifyActivity;
import com.tenpay.sdk.net.gateway.QWalletGatewayServlet;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import pl2.h;
import sk2.WalletConstantsConfig;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 '2\u00020\u0001:\u0004%&'(B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001e\u0010\u0013\u001a\u00020\u00142\b\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0014J&\u0010\u001c\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u00192\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00060\u0006R\u00020\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00060\bR\u00020\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/tenpay/form/queryaccount/IdQueryAccountFragment;", "Lcom/tenpay/form/queryaccount/IdQueryBaseFragment;", "()V", "baseIdFormVC", "Lcom/tenpay/form/QWalletBaseIdFormVC;", "checkFaceProcessor", "Lcom/tenpay/form/queryaccount/IdQueryAccountFragment$CheckFaceProcessor;", "checkPwdProcessor", "Lcom/tenpay/form/queryaccount/IdQueryAccountFragment$CheckPwdProcessor;", "currentID", "", "currentName", "faceVerifyBean", "Lcom/tenpay/face/FaceVerifyBean;", "nameMask", "nextStep", "Lcom/tenpay/form/queryaccount/IdQueryAccountFragment$EnumNextStep;", "getFragmentAnimation", "Lcom/tencent/mobileqq/base/FragmentAnimation;", "gotoQueryResultPage", "", "qpwdToken", "initData", "initInfoVC", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/View;", "isStatusBarImmersive", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "view", "CheckFaceProcessor", "CheckPwdProcessor", "Companion", "EnumNextStep", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class IdQueryAccountFragment extends IdQueryBaseFragment {

    @NotNull
    public static final String KEY_NAME_MASK = "KEY_NAME_MASK";

    @NotNull
    public static final String TAG = "IdQueryAccountFragment";

    @Nullable
    private QWalletBaseIdFormVC baseIdFormVC;

    @Nullable
    private String currentID;

    @Nullable
    private String currentName;

    @Nullable
    private FaceVerifyBean faceVerifyBean;

    @Nullable
    private String nameMask;

    @NotNull
    private EnumNextStep nextStep = EnumNextStep.CHECK_FACE;

    @NotNull
    private final CheckFaceProcessor checkFaceProcessor = new CheckFaceProcessor();

    @NotNull
    private final CheckPwdProcessor checkPwdProcessor = new CheckPwdProcessor();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tenpay/form/queryaccount/IdQueryAccountFragment$CheckFaceProcessor;", "", "(Lcom/tenpay/form/queryaccount/IdQueryAccountFragment;)V", "onNextCheckFace", "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public final class CheckFaceProcessor {
        public CheckFaceProcessor() {
        }

        public final void onNextCheckFace() {
            boolean z16;
            boolean z17;
            FaceVerifyBean faceVerifyBean;
            if (IdQueryAccountFragment.this.baseIdFormVC != null) {
                QWalletBaseIdFormVC qWalletBaseIdFormVC = IdQueryAccountFragment.this.baseIdFormVC;
                boolean z18 = true;
                if (qWalletBaseIdFormVC != null && !qWalletBaseIdFormVC.validateId(IdQueryAccountFragment.this.currentID)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    String str = IdQueryAccountFragment.this.currentName;
                    if (str != null && str.length() != 0) {
                        z17 = false;
                    } else {
                        z17 = true;
                    }
                    if (!z17) {
                        String str2 = IdQueryAccountFragment.this.currentID;
                        if (str2 != null && str2.length() != 0) {
                            z18 = false;
                        }
                        if (z18 || (faceVerifyBean = IdQueryAccountFragment.this.faceVerifyBean) == null) {
                            return;
                        }
                        FaceVerifyBean faceVerifyBean2 = new FaceVerifyBean(faceVerifyBean.getTokenId(), faceVerifyBean.getChannelInfo(), faceVerifyBean.getChannel(), IdQueryAccountFragment.this.currentName, IdQueryAccountFragment.this.currentID, null, 32, null);
                        final IdQueryAccountFragment idQueryAccountFragment = IdQueryAccountFragment.this;
                        idQueryAccountFragment.startCheckFace(faceVerifyBean2, new Function1<FaceVerifyBean, Unit>() { // from class: com.tenpay.form.queryaccount.IdQueryAccountFragment$CheckFaceProcessor$onNextCheckFace$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(FaceVerifyBean faceVerifyBean3) {
                                invoke2(faceVerifyBean3);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@Nullable FaceVerifyBean faceVerifyBean3) {
                                IdQueryAccountFragment.gotoQueryResultPage$default(IdQueryAccountFragment.this, faceVerifyBean3, null, 2, null);
                            }
                        });
                    }
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001:\u0001\bB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tenpay/form/queryaccount/IdQueryAccountFragment$CheckPwdProcessor;", "", "(Lcom/tenpay/form/queryaccount/IdQueryAccountFragment;)V", "requestCheckCreId", "", "startCheckPsd", "rsp", "Lcom/tencent/mobileqq/pb/qwallet/PayAccountPB$CheckCreIDForIdentifiedUserRsp;", "VerifyAccountReceiver", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public final class CheckPwdProcessor {

        /* compiled from: P */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tenpay/form/queryaccount/IdQueryAccountFragment$CheckPwdProcessor$VerifyAccountReceiver;", "Landroid/os/ResultReceiver;", "handler", "Landroid/os/Handler;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "(Lcom/tenpay/form/queryaccount/IdQueryAccountFragment$CheckPwdProcessor;Landroid/os/Handler;Landroid/app/Activity;)V", "mActivityRef", "Lmqq/util/WeakReference;", "onReceiveResult", "", QzoneIPCModule.RESULT_CODE, "", "resultData", "Landroid/os/Bundle;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes27.dex */
        public final class VerifyAccountReceiver extends ResultReceiver {

            @NotNull
            private final WeakReference<Activity> mActivityRef;
            final /* synthetic */ CheckPwdProcessor this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public VerifyAccountReceiver(@Nullable CheckPwdProcessor checkPwdProcessor, @NotNull Handler handler, Activity activity) {
                super(handler);
                Intrinsics.checkNotNullParameter(activity, "activity");
                this.this$0 = checkPwdProcessor;
                this.mActivityRef = new WeakReference<>(activity);
            }

            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int resultCode, @NotNull Bundle resultData) {
                boolean z16;
                Intrinsics.checkNotNullParameter(resultData, "resultData");
                Activity activity = this.mActivityRef.get();
                if (activity != null && !activity.isFinishing()) {
                    QLog.i(IdQueryAccountFragment.TAG, 2, "resultCode: " + resultCode + ", resultData: " + resultData);
                    String string = resultData.getString(PassVerifyActivity.KEY_OUT_RETDATA);
                    if (string != null && string.length() != 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (z16) {
                        return;
                    }
                    try {
                        String optString = new JSONObject(string).optString(PassVerifyActivity.KEY_OUT_QPWD_TOKEN);
                        IdQueryAccountFragment idQueryAccountFragment = IdQueryAccountFragment.this;
                        idQueryAccountFragment.gotoQueryResultPage(idQueryAccountFragment.faceVerifyBean, optString);
                    } catch (JSONException e16) {
                        QLog.w(IdQueryAccountFragment.TAG, 2, "parse pwd verify result fail:", e16);
                    }
                }
            }
        }

        public CheckPwdProcessor() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void startCheckPsd(PayAccountPB$CheckCreIDForIdentifiedUserRsp rsp) {
            FragmentActivity activity = IdQueryAccountFragment.this.getActivity();
            if (activity == null) {
                return;
            }
            TenpayInterface.gotoView(activity, "checkPsw", com.tencent.mobileqq.base.a.c(), com.tencent.mobileqq.base.a.b(), PatternLockHelper.b(rsp), new VerifyAccountReceiver(this, null, activity));
        }

        public final void requestCheckCreId() {
            String tokenId;
            PayAccountPB$CheckCreIDForIdentifiedUserReq payAccountPB$CheckCreIDForIdentifiedUserReq = new PayAccountPB$CheckCreIDForIdentifiedUserReq();
            IdQueryAccountFragment idQueryAccountFragment = IdQueryAccountFragment.this;
            FaceVerifyBean faceVerifyBean = idQueryAccountFragment.faceVerifyBean;
            if (faceVerifyBean != null && (tokenId = faceVerifyBean.getTokenId()) != null) {
                payAccountPB$CheckCreIDForIdentifiedUserReq.token_id.set(tokenId);
            }
            String str = idQueryAccountFragment.currentID;
            if (str != null) {
                payAccountPB$CheckCreIDForIdentifiedUserReq.cre_id.set(str);
            }
            final IdQueryAccountFragment idQueryAccountFragment2 = IdQueryAccountFragment.this;
            h<PayAccountPB$CheckCreIDForIdentifiedUserRsp> hVar = new h<PayAccountPB$CheckCreIDForIdentifiedUserRsp>(idQueryAccountFragment2) { // from class: com.tenpay.form.queryaccount.IdQueryAccountFragment$CheckPwdProcessor$requestCheckCreId$callback$1
                @Override // pl2.k
                public void onFail(int errCode, @NotNull String errMsg) {
                    Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                    QLog.i(IdQueryAccountFragment.TAG, 1, "CheckCreIDForIdentifiedUser fail. " + errCode + " " + errMsg);
                }

                @Override // pl2.k
                public void onSuccess(@NotNull PayAccountPB$CheckCreIDForIdentifiedUserRsp rsp) {
                    Intrinsics.checkNotNullParameter(rsp, "rsp");
                    QLog.i(IdQueryAccountFragment.TAG, 1, "CheckCreIDForIdentifiedUser succeed.");
                    this.startCheckPsd(rsp);
                }
            };
            QWalletGatewayServlet qWalletGatewayServlet = QWalletGatewayServlet.INSTANCE;
            Object newInstance = PayAccountPB$CheckCreIDForIdentifiedUserRsp.class.newInstance();
            Intrinsics.checkNotNullExpressionValue(newInstance, "Rsp::class.java.newInstance()");
            qWalletGatewayServlet.sendRequest("trpc.qwallet.cancel.Account", "CheckCreIDForIdentifiedUser", payAccountPB$CheckCreIDForIdentifiedUserReq, (MessageMicro) newInstance, true, false, true, null, hVar);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tenpay/form/queryaccount/IdQueryAccountFragment$EnumNextStep;", "", "(Ljava/lang/String;I)V", "CHECK_FACE", "CHECK_PWD", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public enum EnumNextStep {
        CHECK_FACE,
        CHECK_PWD
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void gotoQueryResultPage(FaceVerifyBean faceVerifyBean, String qpwdToken) {
        String stringExtra;
        Intent intent = new Intent();
        intent.putExtra(IdQueryEntryFragment.KEY_FACE_VERIFY_BEAN, faceVerifyBean);
        if (qpwdToken != null) {
            intent.putExtra(IdQueryResultFragment.KEY_QPWD_TOKEN, qpwdToken);
        }
        Intent intent2 = getIntent();
        if (intent2 != null && (stringExtra = intent2.getStringExtra(IdQueryResultFragment.KEY_REGBIND_PARAM)) != null) {
            intent.putExtra(IdQueryResultFragment.KEY_REGBIND_PARAM, stringExtra);
        }
        com.tencent.mobileqq.base.c.f(getContext(), intent, IdQueryResultFragment.class, false, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void gotoQueryResultPage$default(IdQueryAccountFragment idQueryAccountFragment, FaceVerifyBean faceVerifyBean, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = null;
        }
        idQueryAccountFragment.gotoQueryResultPage(faceVerifyBean, str);
    }

    private final void initData() {
        FaceVerifyBean faceVerifyBean;
        boolean z16;
        EnumNextStep enumNextStep;
        Intent intent = getIntent();
        String str = null;
        if (intent != null) {
            faceVerifyBean = (FaceVerifyBean) intent.getParcelableExtra(IdQueryEntryFragment.KEY_FACE_VERIFY_BEAN);
        } else {
            faceVerifyBean = null;
        }
        this.faceVerifyBean = faceVerifyBean;
        Intent intent2 = getIntent();
        if (intent2 != null) {
            str = intent2.getStringExtra(KEY_NAME_MASK);
        }
        this.nameMask = str;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            enumNextStep = EnumNextStep.CHECK_FACE;
        } else {
            enumNextStep = EnumNextStep.CHECK_PWD;
        }
        this.nextStep = enumNextStep;
    }

    private final void initInfoVC(View rootView) {
        boolean z16;
        String str;
        ((TextView) rootView.findViewById(R.id.ivTitleBtnLeft)).setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.form.queryaccount.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IdQueryAccountFragment.initInfoVC$lambda$0(IdQueryAccountFragment.this, view);
            }
        });
        QWalletBaseIdFormVC qWalletBaseIdFormVC = new QWalletBaseIdFormVC(this, rootView);
        qWalletBaseIdFormVC.setTitle(getString(R.string.f2179662f), getString(R.string.f2179562e));
        String str2 = this.nameMask;
        if (str2 != null && str2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QWalletBaseIdFormVC.setNameData$default(qWalletBaseIdFormVC, null, getString(R.string.f21789629), false, true, new Function1<String, Unit>() { // from class: com.tenpay.form.queryaccount.IdQueryAccountFragment$initInfoVC$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str3) {
                    invoke2(str3);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull String it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    IdQueryAccountFragment.this.currentName = it;
                }
            }, 5, null);
        } else {
            QWalletBaseIdFormVC.setNameData$default(qWalletBaseIdFormVC, this.nameMask, null, false, false, null, 22, null);
        }
        QWalletBaseIdFormVC.setIdTypeData$default(qWalletBaseIdFormVC, getString(R.string.f2187564k), null, false, 6, null);
        QWalletBaseIdFormVC.setIdData$default(qWalletBaseIdFormVC, null, getString(R.string.f2179062_), false, true, new Function1<String, Unit>() { // from class: com.tenpay.form.queryaccount.IdQueryAccountFragment$initInfoVC$2$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str3) {
                invoke2(str3);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                IdQueryAccountFragment.this.currentID = it;
            }
        }, 5, null);
        QWalletBaseIdFormVC.setConfirmBtnDate$default(qWalletBaseIdFormVC, false, new Function1<View, Unit>() { // from class: com.tenpay.form.queryaccount.IdQueryAccountFragment$initInfoVC$2$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                IdQueryAccountFragment.EnumNextStep enumNextStep;
                IdQueryAccountFragment.EnumNextStep enumNextStep2;
                IdQueryAccountFragment.CheckPwdProcessor checkPwdProcessor;
                IdQueryAccountFragment.CheckFaceProcessor checkFaceProcessor;
                Intrinsics.checkNotNullParameter(it, "it");
                enumNextStep = IdQueryAccountFragment.this.nextStep;
                if (enumNextStep == IdQueryAccountFragment.EnumNextStep.CHECK_FACE) {
                    checkFaceProcessor = IdQueryAccountFragment.this.checkFaceProcessor;
                    checkFaceProcessor.onNextCheckFace();
                    return;
                }
                enumNextStep2 = IdQueryAccountFragment.this.nextStep;
                if (enumNextStep2 == IdQueryAccountFragment.EnumNextStep.CHECK_PWD) {
                    checkPwdProcessor = IdQueryAccountFragment.this.checkPwdProcessor;
                    checkPwdProcessor.requestCheckCreId();
                }
            }
        }, 1, null);
        final WalletConstantsConfig.NormalQuestion unableVerifyIdentify = ((WalletConstantsConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_COMMON_CONSTANT, new WalletConstantsConfig(null, 1, null))).getContent().getUnableVerifyIdentify();
        if (unableVerifyIdentify != null) {
            str = unableVerifyIdentify.getTitle();
        } else {
            str = null;
        }
        QWalletBaseIdFormVC.setLinkTextDate$default(qWalletBaseIdFormVC, str, false, new Function1<View, Unit>() { // from class: com.tenpay.form.queryaccount.IdQueryAccountFragment$initInfoVC$2$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Context context = IdQueryAccountFragment.this.getContext();
                WalletConstantsConfig.NormalQuestion normalQuestion = unableVerifyIdentify;
                k.h(context, normalQuestion != null ? normalQuestion.getUrl() : null);
            }
        }, 2, null);
        this.baseIdFormVC = qWalletBaseIdFormVC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initInfoVC$lambda$0(IdQueryAccountFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    @NotNull
    public FragmentAnimation getFragmentAnimation() {
        return FragmentAnimation.IN_NONE_OUT_DEFAULT;
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
        View inflate = inflater.inflate(R.layout.hi8, container, false);
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
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initData();
        initInfoVC(view);
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
