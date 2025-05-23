package j40;

import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.immersive.datacardcover.interceptor.QFSGetCoverFeedRequest;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.sender.call.Call;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 ,2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001-B\u0007\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0016J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u0004J>\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR(\u0010#\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f0\u001e0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R+\u0010)\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f0\u001e0$8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lj40/b;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Lcom/tencent/richframework/sender/call/Call$OnRspCallBack;", "Lcom/tencent/biz/qqcircle/requests/QCircleBaseRequest;", "", "R1", "Lcom/tencent/biz/qqcircle/immersive/datacardcover/interceptor/QFSGetCoverFeedRequest;", "L1", "", "N1", "getLogTag", "", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, "Q1", "O1", "isSuccess", "", "retCode", "errMsg", Const.BUNDLE_KEY_REQUEST, "", "rspObj", "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "P1", "Lcom/tencent/biz/qqcircle/immersive/datacardcover/interceptor/a;", "i", "Lcom/tencent/biz/qqcircle/immersive/datacardcover/interceptor/a;", "coverFeedUIStateManager", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Le30/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "_coverFeedData", "Landroidx/lifecycle/LiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "M1", "()Landroidx/lifecycle/LiveData;", "coverFeedData", "<init>", "()V", "D", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class b extends BaseViewModel implements Call.OnRspCallBack<QCircleBaseRequest> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final LiveData<UIStateData<List<e30.b>>> coverFeedData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.biz.qqcircle.immersive.datacardcover.interceptor.a coverFeedUIStateManager = new com.tencent.biz.qqcircle.immersive.datacardcover.interceptor.a();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<UIStateData<List<e30.b>>> _coverFeedData;

    public b() {
        MutableLiveData<UIStateData<List<e30.b>>> mutableLiveData = new MutableLiveData<>();
        this._coverFeedData = mutableLiveData;
        this.coverFeedData = mutableLiveData;
    }

    private final QFSGetCoverFeedRequest L1() {
        QFSGetCoverFeedRequest a16 = new QFSGetCoverFeedRequest.b(N1()).f(8).a();
        Intrinsics.checkNotNullExpressionValue(a16, "Builder(getOwnerUin())\n \u2026VER)\n            .build()");
        return a16;
    }

    private final String N1() {
        String currentAccount = QCircleCommonUtil.getCurrentAccount();
        Intrinsics.checkNotNullExpressionValue(currentAccount, "getCurrentAccount()");
        return currentAccount;
    }

    private final void R1() {
        this._coverFeedData.setValue(UIStateData.obtainLoading());
    }

    @NotNull
    public final LiveData<UIStateData<List<e30.b>>> M1() {
        return this.coverFeedData;
    }

    public final void O1() {
        QLog.d("QFSPersonalCoverFeedViewModel", 1, "loadMoreFeeds ");
        com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b().j(this.coverFeedUIStateManager).i(true).addRequest(L1()).m250setRspOnCallBack((Call.OnRspCallBack) this).execute();
    }

    @Override // com.tencent.richframework.sender.call.Call.OnRspCallBack
    /* renamed from: P1, reason: merged with bridge method [inline-methods] */
    public void onReceive(boolean isSuccess, long retCode, @Nullable String errMsg, @NotNull QCircleBaseRequest request, @Nullable Object rspObj, @Nullable Bundle extraData) {
        Intrinsics.checkNotNullParameter(request, "request");
        QLog.d("QFSPersonalCoverFeedViewModel", 1, "onReceive, traceId: " + request.getTraceId() + ", isSuccess: " + isSuccess + ", retCode: " + retCode + ", errMsg: " + errMsg + ", isCache: " + VSNetworkHelper.isProtocolCache(errMsg));
        if (rspObj instanceof UIStateData) {
            this._coverFeedData.setValue((UIStateData) rspObj);
        }
    }

    public final void Q1(boolean first) {
        QLog.d("QFSPersonalCoverFeedViewModel", 1, "requestFeeds, first:" + first);
        if (first) {
            R1();
        }
        com.tencent.biz.qqcircle.richframework.sender.iml.b.a().b().j(this.coverFeedUIStateManager).addRequest(L1()).m250setRspOnCallBack((Call.OnRspCallBack) this).execute();
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "QFSPersonalCoverFeedViewModel";
    }
}
