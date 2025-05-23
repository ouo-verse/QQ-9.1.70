package com.qwallet.home;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$GetPopWindowReq;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$GetPopWindowRsp;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.net.gateway.QWalletGatewayServlet;
import com.tenpay.sdk.util.QWSoterConstans;
import cooperation.qwallet.plugin.ipc.QWalletRedTouchInfo;
import cooperation.vip.pb.TianShuAccess;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import pl2.o;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0002\u0018\u0019B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0010\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0014J\b\u0010\u000e\u001a\u00020\rH\u0014J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001a"}, d2 = {"Lcom/qwallet/home/BackendControlPopViewModel;", "Lcom/qwallet/home/c;", "Landroidx/lifecycle/LifecycleObserver;", "Landroidx/lifecycle/LiveData;", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$GetPopWindowRsp;", "T1", "Lcooperation/qwallet/plugin/ipc/QWalletRedTouchInfo;", "appInfo", "", "W1", "", "Lcom/tencent/mobileqq/tianshu/data/TianShuAdPosItemData;", "N1", "Lcom/tencent/mobileqq/tianshu/data/TianShuGetAdvCallback;", "M1", "Lcooperation/vip/pb/TianShuAccess$AdItem;", "L1", "Landroidx/lifecycle/MutableLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "mBackendPopLiveData", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "EnumRedPointExtraType", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class BackendControlPopViewModel extends c implements LifecycleObserver {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<QWalletHomePage$GetPopWindowRsp> mBackendPopLiveData = new MutableLiveData<>();

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/qwallet/home/BackendControlPopViewModel$EnumRedPointExtraType;", "", "(Ljava/lang/String;I)V", "NONE", "BACKEND_CONTROL_POP", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public enum EnumRedPointExtraType {
        NONE,
        BACKEND_CONTROL_POP
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/qwallet/home/BackendControlPopViewModel$b", "Lpl2/o;", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$GetPopWindowRsp;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public static final class b implements o<QWalletHomePage$GetPopWindowRsp> {
        b() {
        }

        @Override // pl2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull QWalletHomePage$GetPopWindowRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            BackendControlPopViewModel.this.mBackendPopLiveData.postValue(rsp);
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.d("BackendControlPopViewModel", 1, "requestGetPhoneList onFail errCode=" + errCode + " errMsg=" + errMsg);
        }
    }

    @Override // com.qwallet.home.c
    @Nullable
    protected TianShuAccess.AdItem L1() {
        return null;
    }

    @Override // com.qwallet.home.c
    @NotNull
    protected TianShuGetAdvCallback M1() {
        return new TianShuGetAdvCallback() { // from class: com.qwallet.home.a
            @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
            public final void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
                BackendControlPopViewModel.U1(z16, getAdsRsp);
            }
        };
    }

    @Override // com.qwallet.home.c
    @NotNull
    protected List<TianShuAdPosItemData> N1() {
        List<TianShuAdPosItemData> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    @NotNull
    public final LiveData<QWalletHomePage$GetPopWindowRsp> T1() {
        return this.mBackendPopLiveData;
    }

    public final boolean W1(@Nullable QWalletRedTouchInfo appInfo) {
        if (appInfo == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(appInfo.fullBuffer);
            int optInt = jSONObject.optInt(QWSoterConstans.CGI_KEY_BUSI_TYPE, EnumRedPointExtraType.NONE.ordinal());
            QLog.i("BackendControlPopViewModel", 1, "handle tianshu redPoint, busiType=" + optInt);
            if (optInt != EnumRedPointExtraType.BACKEND_CONTROL_POP.ordinal()) {
                return false;
            }
            QLog.i("BackendControlPopViewModel", 1, "handle BackendControlPop, extraData=" + jSONObject);
            QWalletHomePage$GetPopWindowReq qWalletHomePage$GetPopWindowReq = new QWalletHomePage$GetPopWindowReq();
            qWalletHomePage$GetPopWindowReq.scene.set(1);
            qWalletHomePage$GetPopWindowReq.biz_request.set(jSONObject.toString());
            b bVar = new b();
            QWalletGatewayServlet qWalletGatewayServlet = QWalletGatewayServlet.INSTANCE;
            Object newInstance = QWalletHomePage$GetPopWindowRsp.class.newInstance();
            Intrinsics.checkNotNullExpressionValue(newInstance, "Rsp::class.java.newInstance()");
            qWalletGatewayServlet.sendRequest("trpc.qpay.homepage2.Homepage2", "GetPopWindow", qWalletHomePage$GetPopWindowReq, (MessageMicro) newInstance, false, true, false, null, bVar);
            return true;
        } catch (JSONException e16) {
            QLog.e("BackendControlPopViewModel", 1, e16, new Object[0]);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
    }
}
