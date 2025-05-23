package com.tenpay.bank.quick;

import android.os.Bundle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.qwallet.PayGatewayProto$ProxyReq;
import com.tencent.mobileqq.pb.qwallet.PayGatewayProto$ProxyRsp;
import com.tencent.mobileqq.qwallet.pb.BindBank$Bank;
import com.tencent.mobileqq.qwallet.pb.BindBank$CardType;
import com.tencent.mobileqq.qwallet.pb.BindBank$GetBankInfoReq;
import com.tencent.mobileqq.qwallet.pb.BindBank$GetBankInfoRsp;
import com.tencent.mobileqq.qwallet.pb.BindBank$GetBindURLReq;
import com.tencent.mobileqq.qwallet.pb.BindBank$GetBindURLRsp;
import com.tencent.mobileqq.qwallet.pb.BindBank$GetVerifyFaceKeyReq;
import com.tencent.mobileqq.qwallet.pb.BindBank$GetVerifyFaceKeyRsp;
import com.tencent.mobileqq.qwallet.pb.BindBank$ProtoFile;
import com.tencent.mobileqq.qwallet.pb.BindBank$QueryBindReq;
import com.tencent.mobileqq.qwallet.pb.BindBank$QueryBindRsp;
import com.tencent.mobileqq.utils.fh;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.bank.BankConstants;
import com.tenpay.bank.quick.BankItemData;
import com.tenpay.face.FaceVerifyBean;
import com.tenpay.sdk.net.gateway.QWalletGatewayBaseServlet;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import pl2.m;
import pl2.o;
import pl2.p;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001=B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010)\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0007H\u0002J,\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00072\b\b\u0002\u00100\u001a\u00020\u00072\b\b\u0002\u00101\u001a\u00020\u00072\b\b\u0002\u00102\u001a\u00020\u0007J\u0006\u00103\u001a\u00020.J4\u00104\u001a\u00020.2\u0006\u00105\u001a\u0002062$\u00107\u001a \u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020.08J,\u0010:\u001a\u00020.2$\u00107\u001a \u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020.08J&\u0010;\u001a\u00020.2\u001e\u00107\u001a\u001a\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020.0<R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\t\"\u0004\b!\u0010\u000bR\u0011\u0010\"\u001a\u00020#\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\t\"\u0004\b(\u0010\u000b\u00a8\u0006>"}, d2 = {"Lcom/tenpay/bank/quick/BindBankQuickViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LifecycleObserver;", "stateHandle", "Landroidx/lifecycle/SavedStateHandle;", "(Landroidx/lifecycle/SavedStateHandle;)V", "bankId", "", "getBankId", "()Ljava/lang/String;", "setBankId", "(Ljava/lang/String;)V", "bankItemLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/tenpay/bank/quick/BankItemData;", "getBankItemLiveData", "()Landroidx/lifecycle/MutableLiveData;", "bankPanelLiveData", "Lcom/tencent/mobileqq/qwallet/pb/BindBank$GetBankInfoRsp;", "getBankPanelLiveData", "bankType", "getBankType", "setBankType", "protoList", "", "Lcom/tenpay/bank/quick/BankItemData$Proto;", "getProtoList", "()Ljava/util/List;", "setProtoList", "(Ljava/util/List;)V", "reqKey", "getReqKey", "setReqKey", "scene", "", "getScene", "()I", "sessionId", "getSessionId", "setSessionId", "parseBankData", "bankData", "Lcom/tencent/mobileqq/qwallet/pb/BindBank$Bank;", "imageUrlForget", "reportTo644", "", "actionName", "r2", "r4", "r5", "requestBankInfo", "requestBindUrl", "faceVerifyBean", "Lcom/tenpay/face/FaceVerifyBean;", "onCallback", "Lkotlin/Function4;", "", "requestQueryBind", "requestVerifyFaceKey", "Lkotlin/Function3;", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class BindBankQuickViewModel extends ViewModel implements LifecycleObserver {

    @NotNull
    private static final String CMD_SERVICE = "trpc.qwallet.regbind.BindCard";

    @NotNull
    private static final String TAG = "BindBankQuickViewModel";

    @NotNull
    private String bankId;

    @NotNull
    private final MutableLiveData<List<BankItemData>> bankItemLiveData;

    @NotNull
    private final MutableLiveData<BindBank$GetBankInfoRsp> bankPanelLiveData;

    @NotNull
    private String bankType;

    @NotNull
    private List<BankItemData.Proto> protoList;

    @NotNull
    private String reqKey;
    private final int scene;

    @NotNull
    private String sessionId;

    public BindBankQuickViewModel(@NotNull SavedStateHandle stateHandle) {
        int intValue;
        Intrinsics.checkNotNullParameter(stateHandle, "stateHandle");
        Integer num = (Integer) stateHandle.get(BankConstants.EXTRA_KEY_BIND_SCENE_TYPE);
        if (num == null) {
            intValue = 3;
        } else {
            intValue = num.intValue();
        }
        this.scene = intValue;
        this.bankItemLiveData = new MutableLiveData<>();
        this.bankPanelLiveData = new MutableLiveData<>();
        this.reqKey = "";
        this.sessionId = "";
        this.bankId = "";
        this.bankType = "";
        this.protoList = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BankItemData parseBankData(BindBank$Bank bankData, String imageUrlForget) {
        String replace$default;
        String str = bankData.name.get();
        Intrinsics.checkNotNullExpressionValue(str, "bankData.name.get()");
        String str2 = bankData.image_id.get();
        Intrinsics.checkNotNullExpressionValue(str2, "bankData.image_id.get()");
        replace$default = StringsKt__StringsJVMKt.replace$default(imageUrlForget, "{image_id}", str2, false, 4, (Object) null);
        String str3 = bankData.bank_id.get();
        Intrinsics.checkNotNullExpressionValue(str3, "bankData.bank_id.get()");
        String str4 = bankData.promotion.get();
        Intrinsics.checkNotNullExpressionValue(str4, "bankData.promotion.get()");
        ArrayList arrayList = new ArrayList();
        List<BindBank$CardType> list = bankData.card_type.get();
        Intrinsics.checkNotNullExpressionValue(list, "bankData.card_type.get()");
        for (BindBank$CardType bindBank$CardType : list) {
            String str5 = bindBank$CardType.name.get();
            Intrinsics.checkNotNullExpressionValue(str5, "it.name.get()");
            String str6 = bindBank$CardType.bank_type.get();
            Intrinsics.checkNotNullExpressionValue(str6, "it.bank_type.get()");
            arrayList.add(new BankItemData.CardType(str5, str6));
        }
        Unit unit = Unit.INSTANCE;
        ArrayList arrayList2 = new ArrayList();
        List<BindBank$ProtoFile> list2 = bankData.proto_file.get();
        Intrinsics.checkNotNullExpressionValue(list2, "bankData.proto_file.get()");
        for (BindBank$ProtoFile bindBank$ProtoFile : list2) {
            String str7 = bindBank$ProtoFile.name.get();
            Intrinsics.checkNotNullExpressionValue(str7, "it.name.get()");
            String str8 = bindBank$ProtoFile.url.get();
            Intrinsics.checkNotNullExpressionValue(str8, "it.url.get()");
            String str9 = bindBank$ProtoFile.version.get();
            Intrinsics.checkNotNullExpressionValue(str9, "it.version.get()");
            arrayList2.add(new BankItemData.Proto(str7, str8, str9));
        }
        Unit unit2 = Unit.INSTANCE;
        return new BankItemData(str, replace$default, str3, str4, arrayList, arrayList2);
    }

    public static /* synthetic */ void reportTo644$default(BindBankQuickViewModel bindBankQuickViewModel, String str, String str2, String str3, String str4, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = "";
        }
        if ((i3 & 4) != 0) {
            str3 = "";
        }
        if ((i3 & 8) != 0) {
            str4 = "";
        }
        bindBankQuickViewModel.reportTo644(str, str2, str3, str4);
    }

    @NotNull
    public final String getBankId() {
        return this.bankId;
    }

    @NotNull
    public final MutableLiveData<List<BankItemData>> getBankItemLiveData() {
        return this.bankItemLiveData;
    }

    @NotNull
    public final MutableLiveData<BindBank$GetBankInfoRsp> getBankPanelLiveData() {
        return this.bankPanelLiveData;
    }

    @NotNull
    public final String getBankType() {
        return this.bankType;
    }

    @NotNull
    public final List<BankItemData.Proto> getProtoList() {
        return this.protoList;
    }

    @NotNull
    public final String getReqKey() {
        return this.reqKey;
    }

    public final int getScene() {
        return this.scene;
    }

    @NotNull
    public final String getSessionId() {
        return this.sessionId;
    }

    public final void reportTo644(@NotNull String actionName, @NotNull String r26, @NotNull String r46, @NotNull String r56) {
        Intrinsics.checkNotNullParameter(actionName, "actionName");
        Intrinsics.checkNotNullParameter(r26, "r2");
        Intrinsics.checkNotNullParameter(r46, "r4");
        Intrinsics.checkNotNullParameter(r56, "r5");
        com.tencent.mobileqq.qwallet.c.e(actionName, r26, "", r46, r56);
    }

    public final void requestBankInfo() {
        BindBank$GetBankInfoReq bindBank$GetBankInfoReq = new BindBank$GetBankInfoReq();
        bindBank$GetBankInfoReq.scene.set(String.valueOf(this.scene));
        final m<BindBank$GetBankInfoRsp> mVar = new m<BindBank$GetBankInfoRsp>() { // from class: com.tenpay.bank.quick.BindBankQuickViewModel$requestBankInfo$callback$1
            @Override // pl2.m, pl2.k
            public void onFail(int errCode, @NotNull String errMsg) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                QLog.d("BindBankQuickViewModel", 1, errMsg);
            }

            @Override // pl2.m
            public void onRetFail(@NotNull String retMsg) {
                Intrinsics.checkNotNullParameter(retMsg, "retMsg");
                QLog.d("BindBankQuickViewModel", 1, retMsg);
            }

            @Override // pl2.k
            public void onSuccess(@NotNull BindBank$GetBankInfoRsp rsp) {
                BankItemData parseBankData;
                Intrinsics.checkNotNullParameter(rsp, "rsp");
                ArrayList arrayList = new ArrayList();
                String imageUrlForget = rsp.image_format.get();
                List<BindBank$Bank> list = rsp.bank.get();
                Intrinsics.checkNotNullExpressionValue(list, "rsp.bank.get()");
                BindBankQuickViewModel bindBankQuickViewModel = BindBankQuickViewModel.this;
                for (BindBank$Bank it : list) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    Intrinsics.checkNotNullExpressionValue(imageUrlForget, "imageUrlForget");
                    parseBankData = bindBankQuickViewModel.parseBankData(it, imageUrlForget);
                    arrayList.add(parseBankData);
                }
                BindBankQuickViewModel.this.getBankItemLiveData().setValue(arrayList);
                BindBankQuickViewModel.this.getBankPanelLiveData().setValue(rsp);
            }
        };
        p.Companion companion = p.INSTANCE;
        PayGatewayProto$ProxyReq payGatewayProto$ProxyReq = new PayGatewayProto$ProxyReq();
        payGatewayProto$ProxyReq.service.set(CMD_SERVICE);
        payGatewayProto$ProxyReq.method.set("GetBankInfo");
        payGatewayProto$ProxyReq.payload.set(ByteStringMicro.copyFrom(bindBank$GetBankInfoReq.toByteArray()));
        final o<PayGatewayProto$ProxyRsp> oVar = new o<PayGatewayProto$ProxyRsp>() { // from class: com.tenpay.bank.quick.BindBankQuickViewModel$requestBankInfo$$inlined$sendRequestByGateway$default$1
            @Override // pl2.k
            public void onFail(int errCode, @NotNull String errMsg) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                m.this.onFail(errCode, errMsg);
            }

            @Override // pl2.k
            public void onSuccess(@NotNull PayGatewayProto$ProxyRsp proxyRsp) {
                Intrinsics.checkNotNullParameter(proxyRsp, "proxyRsp");
                if (proxyRsp.retcode.get() == 0) {
                    MessageMicro rsp = ((MessageMicro) BindBank$GetBankInfoRsp.class.newInstance()).mergeFrom(proxyRsp.payload.get().toByteArray());
                    m mVar2 = m.this;
                    Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                    mVar2.onSuccess((m) rsp);
                    return;
                }
                m mVar3 = m.this;
                String str = proxyRsp.retmsg.get();
                Intrinsics.checkNotNullExpressionValue(str, "proxyRsp.retmsg.get()");
                mVar3.onRetFail(str);
            }
        };
        QLog.i("QWalletHttp-QWalletPbServlet", 1, "send req: cmd=" + QWalletGatewayBaseServlet.GATEWAY_CMD + " callback: " + oVar + TokenParser.SP);
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        NewIntent newIntent = new NewIntent(waitAppRuntime.getApplication(), p.class);
        newIntent.putExtra("cmd", QWalletGatewayBaseServlet.GATEWAY_CMD);
        newIntent.putExtra("data", fh.b(payGatewayProto$ProxyReq.toByteArray()));
        newIntent.putExtra("timeout", 30000L);
        newIntent.setObserver(new BusinessObserver() { // from class: com.tenpay.bank.quick.BindBankQuickViewModel$requestBankInfo$$inlined$sendRequestByGateway$default$2
            @Override // mqq.observer.BusinessObserver
            public final void onReceive(int i3, boolean z16, Bundle bundle) {
                int i16;
                String str;
                if (bundle != null) {
                    i16 = bundle.getInt("rsp_code");
                } else {
                    i16 = 1001;
                }
                if (bundle != null) {
                    str = bundle.getString("rsp_msg");
                } else {
                    str = null;
                }
                if (z16) {
                    try {
                        MessageMicro rsp = ((MessageMicro) PayGatewayProto$ProxyRsp.class.newInstance()).mergeFrom(bundle.getByteArray("rsp_bytes"));
                        o oVar2 = o.this;
                        if (oVar2 != null) {
                            Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                            oVar2.onSuccess((o) rsp);
                            return;
                        }
                        return;
                    } catch (Exception unused) {
                        QLog.e("QWalletHttp-QWalletPbServlet", 1, "mergeFrom bytes array to " + PayGatewayProto$ProxyRsp.class + " failed.");
                        o oVar3 = o.this;
                        if (oVar3 != null) {
                            oVar3.onFail(i16, p.INSTANCE.a());
                            return;
                        }
                        return;
                    }
                }
                o oVar4 = o.this;
                if (oVar4 != null) {
                    if (str == null) {
                        str = "empty bundle";
                    }
                    oVar4.onFail(i16, str);
                }
            }
        });
        waitAppRuntime.startServlet(newIntent);
    }

    public final void requestBindUrl(@NotNull FaceVerifyBean faceVerifyBean, @NotNull final Function4<? super Boolean, ? super String, ? super String, ? super String, Unit> onCallback) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(faceVerifyBean, "faceVerifyBean");
        Intrinsics.checkNotNullParameter(onCallback, "onCallback");
        BindBank$GetBindURLReq bindBank$GetBindURLReq = new BindBank$GetBindURLReq();
        bindBank$GetBindURLReq.bank_id.set(this.bankId);
        bindBank$GetBindURLReq.bank_type.set(this.bankType);
        bindBank$GetBindURLReq.token_id.set(faceVerifyBean.getTokenId());
        PBRepeatMessageField<BindBank$ProtoFile> pBRepeatMessageField = bindBank$GetBindURLReq.agreement;
        List<BankItemData.Proto> list = this.protoList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (BankItemData.Proto proto : list) {
            BindBank$ProtoFile bindBank$ProtoFile = new BindBank$ProtoFile();
            bindBank$ProtoFile.name.set(proto.getName());
            bindBank$ProtoFile.url.set(proto.getUrl());
            bindBank$ProtoFile.version.set(proto.getVersion());
            arrayList.add(bindBank$ProtoFile);
        }
        pBRepeatMessageField.set(arrayList);
        QLog.i(TAG, 1, "requestBindUrl putAgreement: " + this.protoList);
        final m<BindBank$GetBindURLRsp> mVar = new m<BindBank$GetBindURLRsp>() { // from class: com.tenpay.bank.quick.BindBankQuickViewModel$requestBindUrl$callback$1
            @Override // pl2.m, pl2.k
            public void onFail(int errCode, @NotNull String errMsg) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                onCallback.invoke(Boolean.FALSE, "", "", "");
                QQToast.makeText(MobileQQ.sMobileQQ, 1, "\u7f51\u7edc\u9519\u8bef\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 0).show();
                QLog.e("BindBankQuickViewModel", 1, errMsg);
            }

            @Override // pl2.m
            public void onRetFail(@NotNull String retMsg) {
                Intrinsics.checkNotNullParameter(retMsg, "retMsg");
                onCallback.invoke(Boolean.FALSE, "", "", "");
                QQToast.makeText(MobileQQ.sMobileQQ, 1, retMsg, 0).show();
                QLog.w("BindBankQuickViewModel", 1, retMsg);
            }

            @Override // pl2.k
            public void onSuccess(@NotNull BindBank$GetBindURLRsp rsp) {
                Intrinsics.checkNotNullParameter(rsp, "rsp");
                BindBankQuickViewModel bindBankQuickViewModel = BindBankQuickViewModel.this;
                String str = rsp.req_key.get();
                Intrinsics.checkNotNullExpressionValue(str, "rsp.req_key.get()");
                bindBankQuickViewModel.setReqKey(str);
                BindBankQuickViewModel bindBankQuickViewModel2 = BindBankQuickViewModel.this;
                String str2 = rsp.session_id.get();
                Intrinsics.checkNotNullExpressionValue(str2, "rsp.session_id.get()");
                bindBankQuickViewModel2.setSessionId(str2);
                Function4<Boolean, String, String, String, Unit> function4 = onCallback;
                Boolean bool = Boolean.TRUE;
                String str3 = rsp.url.get();
                Intrinsics.checkNotNullExpressionValue(str3, "rsp.url.get()");
                String str4 = rsp.method.get();
                Intrinsics.checkNotNullExpressionValue(str4, "rsp.method.get()");
                String str5 = rsp.body.get();
                Intrinsics.checkNotNullExpressionValue(str5, "rsp.body.get()");
                function4.invoke(bool, str3, str4, str5);
                QLog.d("BindBankQuickViewModel", 1, "reqKey = " + BindBankQuickViewModel.this.getReqKey() + " sessionId = " + BindBankQuickViewModel.this.getSessionId());
            }
        };
        p.Companion companion = p.INSTANCE;
        PayGatewayProto$ProxyReq payGatewayProto$ProxyReq = new PayGatewayProto$ProxyReq();
        payGatewayProto$ProxyReq.service.set(CMD_SERVICE);
        payGatewayProto$ProxyReq.method.set("GetBindURL");
        payGatewayProto$ProxyReq.payload.set(ByteStringMicro.copyFrom(bindBank$GetBindURLReq.toByteArray()));
        final o<PayGatewayProto$ProxyRsp> oVar = new o<PayGatewayProto$ProxyRsp>() { // from class: com.tenpay.bank.quick.BindBankQuickViewModel$requestBindUrl$$inlined$sendRequestByGateway$default$1
            @Override // pl2.k
            public void onFail(int errCode, @NotNull String errMsg) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                m.this.onFail(errCode, errMsg);
            }

            @Override // pl2.k
            public void onSuccess(@NotNull PayGatewayProto$ProxyRsp proxyRsp) {
                Intrinsics.checkNotNullParameter(proxyRsp, "proxyRsp");
                if (proxyRsp.retcode.get() == 0) {
                    MessageMicro rsp = ((MessageMicro) BindBank$GetBindURLRsp.class.newInstance()).mergeFrom(proxyRsp.payload.get().toByteArray());
                    m mVar2 = m.this;
                    Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                    mVar2.onSuccess((m) rsp);
                    return;
                }
                m mVar3 = m.this;
                String str = proxyRsp.retmsg.get();
                Intrinsics.checkNotNullExpressionValue(str, "proxyRsp.retmsg.get()");
                mVar3.onRetFail(str);
            }
        };
        QLog.i("QWalletHttp-QWalletPbServlet", 1, "send req: cmd=" + QWalletGatewayBaseServlet.GATEWAY_CMD + " callback: " + oVar + TokenParser.SP);
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        NewIntent newIntent = new NewIntent(waitAppRuntime.getApplication(), p.class);
        newIntent.putExtra("cmd", QWalletGatewayBaseServlet.GATEWAY_CMD);
        newIntent.putExtra("data", fh.b(payGatewayProto$ProxyReq.toByteArray()));
        newIntent.putExtra("timeout", 30000L);
        newIntent.setObserver(new BusinessObserver() { // from class: com.tenpay.bank.quick.BindBankQuickViewModel$requestBindUrl$$inlined$sendRequestByGateway$default$2
            @Override // mqq.observer.BusinessObserver
            public final void onReceive(int i3, boolean z16, Bundle bundle) {
                int i16;
                String str;
                if (bundle != null) {
                    i16 = bundle.getInt("rsp_code");
                } else {
                    i16 = 1001;
                }
                if (bundle != null) {
                    str = bundle.getString("rsp_msg");
                } else {
                    str = null;
                }
                if (z16) {
                    try {
                        MessageMicro rsp = ((MessageMicro) PayGatewayProto$ProxyRsp.class.newInstance()).mergeFrom(bundle.getByteArray("rsp_bytes"));
                        o oVar2 = o.this;
                        if (oVar2 != null) {
                            Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                            oVar2.onSuccess((o) rsp);
                            return;
                        }
                        return;
                    } catch (Exception unused) {
                        QLog.e("QWalletHttp-QWalletPbServlet", 1, "mergeFrom bytes array to " + PayGatewayProto$ProxyRsp.class + " failed.");
                        o oVar3 = o.this;
                        if (oVar3 != null) {
                            oVar3.onFail(i16, p.INSTANCE.a());
                            return;
                        }
                        return;
                    }
                }
                o oVar4 = o.this;
                if (oVar4 != null) {
                    if (str == null) {
                        str = "empty bundle";
                    }
                    oVar4.onFail(i16, str);
                }
            }
        });
        waitAppRuntime.startServlet(newIntent);
    }

    public final void requestQueryBind(@NotNull final Function4<? super Boolean, ? super Integer, ? super String, ? super String, Unit> onCallback) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(onCallback, "onCallback");
        BindBank$QueryBindReq bindBank$QueryBindReq = new BindBank$QueryBindReq();
        bindBank$QueryBindReq.req_key.set(this.reqKey);
        bindBank$QueryBindReq.session_id.set(this.sessionId);
        bindBank$QueryBindReq.bank_type.set(this.bankType);
        PBRepeatMessageField<BindBank$ProtoFile> pBRepeatMessageField = bindBank$QueryBindReq.agreement;
        List<BankItemData.Proto> list = this.protoList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (BankItemData.Proto proto : list) {
            BindBank$ProtoFile bindBank$ProtoFile = new BindBank$ProtoFile();
            bindBank$ProtoFile.name.set(proto.getName());
            bindBank$ProtoFile.url.set(proto.getUrl());
            bindBank$ProtoFile.version.set(proto.getVersion());
            arrayList.add(bindBank$ProtoFile);
        }
        pBRepeatMessageField.set(arrayList);
        QLog.i(TAG, 1, "requestQueryBind putAgreement: " + this.protoList);
        final m<BindBank$QueryBindRsp> mVar = new m<BindBank$QueryBindRsp>() { // from class: com.tenpay.bank.quick.BindBankQuickViewModel$requestQueryBind$callback$1
            @Override // pl2.m, pl2.k
            public void onFail(int errCode, @NotNull String errMsg) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                onCallback.invoke(Boolean.FALSE, 0, "", "");
                QQToast.makeText(MobileQQ.sMobileQQ, 1, "\u7f51\u7edc\u9519\u8bef\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 0).show();
                QLog.e("BindBankQuickViewModel", 1, errMsg);
            }

            @Override // pl2.m
            public void onRetFail(@NotNull String retMsg) {
                Intrinsics.checkNotNullParameter(retMsg, "retMsg");
                onCallback.invoke(Boolean.FALSE, 0, "", "");
                QQToast.makeText(MobileQQ.sMobileQQ, 1, retMsg, 0).show();
                QLog.w("BindBankQuickViewModel", 1, retMsg);
            }

            @Override // pl2.k
            public void onSuccess(@NotNull BindBank$QueryBindRsp rsp) {
                Intrinsics.checkNotNullParameter(rsp, "rsp");
                Function4<Boolean, Integer, String, String, Unit> function4 = onCallback;
                Boolean bool = Boolean.TRUE;
                Integer valueOf = Integer.valueOf(rsp.bind_status.get());
                String str = rsp.res_info.get();
                Intrinsics.checkNotNullExpressionValue(str, "rsp.res_info.get()");
                String str2 = rsp.bind_serial.get();
                Intrinsics.checkNotNullExpressionValue(str2, "rsp.bind_serial.get()");
                function4.invoke(bool, valueOf, str, str2);
            }
        };
        p.Companion companion = p.INSTANCE;
        PayGatewayProto$ProxyReq payGatewayProto$ProxyReq = new PayGatewayProto$ProxyReq();
        payGatewayProto$ProxyReq.service.set(CMD_SERVICE);
        payGatewayProto$ProxyReq.method.set("QueryBind");
        payGatewayProto$ProxyReq.payload.set(ByteStringMicro.copyFrom(bindBank$QueryBindReq.toByteArray()));
        final o<PayGatewayProto$ProxyRsp> oVar = new o<PayGatewayProto$ProxyRsp>() { // from class: com.tenpay.bank.quick.BindBankQuickViewModel$requestQueryBind$$inlined$sendRequestByGateway$default$1
            @Override // pl2.k
            public void onFail(int errCode, @NotNull String errMsg) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                m.this.onFail(errCode, errMsg);
            }

            @Override // pl2.k
            public void onSuccess(@NotNull PayGatewayProto$ProxyRsp proxyRsp) {
                Intrinsics.checkNotNullParameter(proxyRsp, "proxyRsp");
                if (proxyRsp.retcode.get() == 0) {
                    MessageMicro rsp = ((MessageMicro) BindBank$QueryBindRsp.class.newInstance()).mergeFrom(proxyRsp.payload.get().toByteArray());
                    m mVar2 = m.this;
                    Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                    mVar2.onSuccess((m) rsp);
                    return;
                }
                m mVar3 = m.this;
                String str = proxyRsp.retmsg.get();
                Intrinsics.checkNotNullExpressionValue(str, "proxyRsp.retmsg.get()");
                mVar3.onRetFail(str);
            }
        };
        QLog.i("QWalletHttp-QWalletPbServlet", 1, "send req: cmd=" + QWalletGatewayBaseServlet.GATEWAY_CMD + " callback: " + oVar + TokenParser.SP);
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        NewIntent newIntent = new NewIntent(waitAppRuntime.getApplication(), p.class);
        newIntent.putExtra("cmd", QWalletGatewayBaseServlet.GATEWAY_CMD);
        newIntent.putExtra("data", fh.b(payGatewayProto$ProxyReq.toByteArray()));
        newIntent.putExtra("timeout", 30000L);
        newIntent.setObserver(new BusinessObserver() { // from class: com.tenpay.bank.quick.BindBankQuickViewModel$requestQueryBind$$inlined$sendRequestByGateway$default$2
            @Override // mqq.observer.BusinessObserver
            public final void onReceive(int i3, boolean z16, Bundle bundle) {
                int i16;
                String str;
                if (bundle != null) {
                    i16 = bundle.getInt("rsp_code");
                } else {
                    i16 = 1001;
                }
                if (bundle != null) {
                    str = bundle.getString("rsp_msg");
                } else {
                    str = null;
                }
                if (z16) {
                    try {
                        MessageMicro rsp = ((MessageMicro) PayGatewayProto$ProxyRsp.class.newInstance()).mergeFrom(bundle.getByteArray("rsp_bytes"));
                        o oVar2 = o.this;
                        if (oVar2 != null) {
                            Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                            oVar2.onSuccess((o) rsp);
                            return;
                        }
                        return;
                    } catch (Exception unused) {
                        QLog.e("QWalletHttp-QWalletPbServlet", 1, "mergeFrom bytes array to " + PayGatewayProto$ProxyRsp.class + " failed.");
                        o oVar3 = o.this;
                        if (oVar3 != null) {
                            oVar3.onFail(i16, p.INSTANCE.a());
                            return;
                        }
                        return;
                    }
                }
                o oVar4 = o.this;
                if (oVar4 != null) {
                    if (str == null) {
                        str = "empty bundle";
                    }
                    oVar4.onFail(i16, str);
                }
            }
        });
        waitAppRuntime.startServlet(newIntent);
    }

    public final void requestVerifyFaceKey(@NotNull final Function3<? super Boolean, ? super String, ? super String, Unit> onCallback) {
        Intrinsics.checkNotNullParameter(onCallback, "onCallback");
        BindBank$GetBankInfoRsp value = this.bankPanelLiveData.getValue();
        if (value == null) {
            QLog.e(TAG, 1, "bankPanelLiveData is null");
            return;
        }
        BindBank$GetVerifyFaceKeyReq bindBank$GetVerifyFaceKeyReq = new BindBank$GetVerifyFaceKeyReq();
        bindBank$GetVerifyFaceKeyReq.channel_id.set(value.channel_id.get());
        bindBank$GetVerifyFaceKeyReq.busi_info.set(value.busi_info.get());
        final m<BindBank$GetVerifyFaceKeyRsp> mVar = new m<BindBank$GetVerifyFaceKeyRsp>() { // from class: com.tenpay.bank.quick.BindBankQuickViewModel$requestVerifyFaceKey$callback$1
            @Override // pl2.m, pl2.k
            public void onFail(int errCode, @NotNull String errMsg) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                onCallback.invoke(Boolean.FALSE, "", "");
                QQToast.makeText(MobileQQ.sMobileQQ, 1, "\u7f51\u7edc\u9519\u8bef\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 0).show();
                QLog.e("BindBankQuickViewModel", 1, errMsg);
            }

            @Override // pl2.m
            public void onRetFail(@NotNull String retMsg) {
                Intrinsics.checkNotNullParameter(retMsg, "retMsg");
                onCallback.invoke(Boolean.FALSE, "", "");
                QQToast.makeText(MobileQQ.sMobileQQ, 1, retMsg, 0).show();
                QLog.w("BindBankQuickViewModel", 1, retMsg);
            }

            @Override // pl2.k
            public void onSuccess(@NotNull BindBank$GetVerifyFaceKeyRsp rsp) {
                Intrinsics.checkNotNullParameter(rsp, "rsp");
                String tokenId = rsp.token_id.get();
                String channelInfo = rsp.channel_info.get();
                Function3<Boolean, String, String, Unit> function3 = onCallback;
                Boolean bool = Boolean.TRUE;
                Intrinsics.checkNotNullExpressionValue(tokenId, "tokenId");
                Intrinsics.checkNotNullExpressionValue(channelInfo, "channelInfo");
                function3.invoke(bool, tokenId, channelInfo);
                QLog.d("BindBankQuickViewModel", 1, "tokenId = " + tokenId + " channelInfo = " + channelInfo);
            }
        };
        p.Companion companion = p.INSTANCE;
        PayGatewayProto$ProxyReq payGatewayProto$ProxyReq = new PayGatewayProto$ProxyReq();
        payGatewayProto$ProxyReq.service.set(CMD_SERVICE);
        payGatewayProto$ProxyReq.method.set("GetVerifyFaceKey");
        payGatewayProto$ProxyReq.payload.set(ByteStringMicro.copyFrom(bindBank$GetVerifyFaceKeyReq.toByteArray()));
        final o<PayGatewayProto$ProxyRsp> oVar = new o<PayGatewayProto$ProxyRsp>() { // from class: com.tenpay.bank.quick.BindBankQuickViewModel$requestVerifyFaceKey$$inlined$sendRequestByGateway$default$1
            @Override // pl2.k
            public void onFail(int errCode, @NotNull String errMsg) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                m.this.onFail(errCode, errMsg);
            }

            @Override // pl2.k
            public void onSuccess(@NotNull PayGatewayProto$ProxyRsp proxyRsp) {
                Intrinsics.checkNotNullParameter(proxyRsp, "proxyRsp");
                if (proxyRsp.retcode.get() == 0) {
                    MessageMicro rsp = ((MessageMicro) BindBank$GetVerifyFaceKeyRsp.class.newInstance()).mergeFrom(proxyRsp.payload.get().toByteArray());
                    m mVar2 = m.this;
                    Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                    mVar2.onSuccess((m) rsp);
                    return;
                }
                m mVar3 = m.this;
                String str = proxyRsp.retmsg.get();
                Intrinsics.checkNotNullExpressionValue(str, "proxyRsp.retmsg.get()");
                mVar3.onRetFail(str);
            }
        };
        QLog.i("QWalletHttp-QWalletPbServlet", 1, "send req: cmd=" + QWalletGatewayBaseServlet.GATEWAY_CMD + " callback: " + oVar + TokenParser.SP);
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        NewIntent newIntent = new NewIntent(waitAppRuntime.getApplication(), p.class);
        newIntent.putExtra("cmd", QWalletGatewayBaseServlet.GATEWAY_CMD);
        newIntent.putExtra("data", fh.b(payGatewayProto$ProxyReq.toByteArray()));
        newIntent.putExtra("timeout", 30000L);
        newIntent.setObserver(new BusinessObserver() { // from class: com.tenpay.bank.quick.BindBankQuickViewModel$requestVerifyFaceKey$$inlined$sendRequestByGateway$default$2
            @Override // mqq.observer.BusinessObserver
            public final void onReceive(int i3, boolean z16, Bundle bundle) {
                int i16;
                String str;
                if (bundle != null) {
                    i16 = bundle.getInt("rsp_code");
                } else {
                    i16 = 1001;
                }
                if (bundle != null) {
                    str = bundle.getString("rsp_msg");
                } else {
                    str = null;
                }
                if (z16) {
                    try {
                        MessageMicro rsp = ((MessageMicro) PayGatewayProto$ProxyRsp.class.newInstance()).mergeFrom(bundle.getByteArray("rsp_bytes"));
                        o oVar2 = o.this;
                        if (oVar2 != null) {
                            Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                            oVar2.onSuccess((o) rsp);
                            return;
                        }
                        return;
                    } catch (Exception unused) {
                        QLog.e("QWalletHttp-QWalletPbServlet", 1, "mergeFrom bytes array to " + PayGatewayProto$ProxyRsp.class + " failed.");
                        o oVar3 = o.this;
                        if (oVar3 != null) {
                            oVar3.onFail(i16, p.INSTANCE.a());
                            return;
                        }
                        return;
                    }
                }
                o oVar4 = o.this;
                if (oVar4 != null) {
                    if (str == null) {
                        str = "empty bundle";
                    }
                    oVar4.onFail(i16, str);
                }
            }
        });
        waitAppRuntime.startServlet(newIntent);
    }

    public final void setBankId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bankId = str;
    }

    public final void setBankType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bankType = str;
    }

    public final void setProtoList(@NotNull List<BankItemData.Proto> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.protoList = list;
    }

    public final void setReqKey(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.reqKey = str;
    }

    public final void setSessionId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sessionId = str;
    }
}
