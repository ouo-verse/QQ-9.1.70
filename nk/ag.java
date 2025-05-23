package nk;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.qzone.reborn.base.n;
import com.qzone.reborn.intimate.request.QZoneIntimateNewBadgeRequest;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.trpcprotocol.qqrelation.operation_profile.operation_profile.OperationProfile$ShareParam;
import com.tencent.trpcprotocol.qqrelation.operation_profile.operation_profile.OperationProfile$ShareReq;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.json.JSONObject;
import qzone.QZIntimateSpaceMedal$MainPageMedalDetail;
import qzone.QZIntimateSpaceMedal$StGetMedalListByMainPageRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\f\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tJE\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR(\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lnk/ag;", "Lcom/qzone/reborn/base/n;", "", "isSuccess", "", "T1", "", "getLogTag", "spaceId", "Lcom/qzone/reborn/base/n$a;", "Lqzone/QZIntimateSpaceMedal$MainPageMedalDetail;", "dataCallback", "R1", "Lmqq/app/AppRuntime;", "app", "", "toUin", "fileId", "relation", "isFriendCheckInAlready", "O1", "(Lmqq/app/AppRuntime;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "i", "Z", "isNewBadgeRequesting", "()Z", "S1", "(Z)V", "Landroidx/lifecycle/MutableLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "Q1", "()Landroidx/lifecycle/MutableLiveData;", "setShareBadgeArkSuccess", "(Landroidx/lifecycle/MutableLiveData;)V", "shareBadgeArkSuccess", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class ag extends com.qzone.reborn.base.n {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isNewBadgeRequesting;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<Boolean> shareBadgeArkSuccess = new MutableLiveData<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J4\u0010\r\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"nk/ag$b", "Lcom/tencent/biz/richframework/network/observer/VSDispatchObserver$OnVSRspCallBack;", "Lqzone/QZIntimateSpaceMedal$StGetMedalListByMainPageRsp;", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", Const.BUNDLE_KEY_REQUEST, "", "isSuccess", "", "retCode", "", "errMsg", "rsp", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements VSDispatchObserver.OnVSRspCallBack<QZIntimateSpaceMedal$StGetMedalListByMainPageRsp> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ n.a<QZIntimateSpaceMedal$MainPageMedalDetail> f420270b;

        b(n.a<QZIntimateSpaceMedal$MainPageMedalDetail> aVar) {
            this.f420270b = aVar;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest request, boolean isSuccess, long retCode, String errMsg, QZIntimateSpaceMedal$StGetMedalListByMainPageRsp rsp) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            ag.this.S1(false);
            if (isSuccess && rsp != null && retCode == 0) {
                this.f420270b.onSuccess(rsp.medal_detail.get(), retCode, errMsg, true);
            } else {
                this.f420270b.onFailure(retCode, errMsg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T1(final boolean isSuccess) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: nk.af
            @Override // java.lang.Runnable
            public final void run() {
                ag.U1(ag.this, isSuccess);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(ag this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.shareBadgeArkSuccess.setValue(Boolean.valueOf(z16));
    }

    public final void O1(AppRuntime app, long toUin, String fileId, String spaceId, String relation, Boolean isFriendCheckInAlready) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        OperationProfile$ShareReq operationProfile$ShareReq = new OperationProfile$ShareReq();
        operationProfile$ShareReq.activity_id.set(22);
        operationProfile$ShareReq.to_uin.set(toUin);
        operationProfile$ShareReq.to_group_code.set(0L);
        if (Intrinsics.areEqual(isFriendCheckInAlready, Boolean.TRUE)) {
            operationProfile$ShareReq.select_tag.set("after");
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ShortVideoConstants.FILE_UUID, fileId);
        jSONObject.put("store_id", 1);
        ArrayList arrayList = new ArrayList();
        OperationProfile$ShareParam operationProfile$ShareParam = new OperationProfile$ShareParam();
        operationProfile$ShareParam.key.set("signpic");
        operationProfile$ShareParam.value.set(jSONObject.toString());
        arrayList.add(operationProfile$ShareParam);
        OperationProfile$ShareParam operationProfile$ShareParam2 = new OperationProfile$ShareParam();
        operationProfile$ShareParam2.key.set("spaceid");
        operationProfile$ShareParam2.value.set(spaceId);
        arrayList.add(operationProfile$ShareParam2);
        if (!TextUtils.isEmpty(relation)) {
            OperationProfile$ShareParam operationProfile$ShareParam3 = new OperationProfile$ShareParam();
            operationProfile$ShareParam3.key.set("relation");
            operationProfile$ShareParam3.value.set(relation);
            arrayList.add(operationProfile$ShareParam3);
        }
        operationProfile$ShareReq.share_params.set(arrayList);
        ProtoUtils.a(app, new a(), operationProfile$ShareReq.toByteArray(), "OidbSvcTrpcTcp.0x911a", 37146, 22);
    }

    public final MutableLiveData<Boolean> Q1() {
        return this.shareBadgeArkSuccess;
    }

    public final void R1(String spaceId, n.a<QZIntimateSpaceMedal$MainPageMedalDetail> dataCallback) {
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        if ((spaceId == null || spaceId.length() == 0) || this.isNewBadgeRequesting) {
            return;
        }
        this.isNewBadgeRequesting = true;
        VSNetworkHelper.getInstance().sendRequest(this.contextHashCode, new QZoneIntimateNewBadgeRequest(spaceId), new b(dataCallback));
    }

    public final void S1(boolean z16) {
        this.isNewBadgeRequesting = z16;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneIntimateBadgeViewModel";
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"nk/ag$a", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "", "errorCode", "", "data", "Landroid/os/Bundle;", "bundle", "", "onResult", "", "errorMsg", "", "onError", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a extends ProtoUtils.TroopProtocolObserver {
        a() {
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public boolean onError(int errorCode, String errorMsg, Bundle bundle) {
            QLog.e(ag.this.getTAG(), 1, "doBadgeArkShareRequest on error, error code is " + errorCode + ", error msg is " + errorMsg);
            ag.this.T1(false);
            QQToastUtil.showQQToastInUiThread(1, com.qzone.util.l.a(R.string.v8k));
            return true;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int errorCode, byte[] data, Bundle bundle) {
            boolean z16 = errorCode == 0 && data != null;
            ag.this.T1(z16);
            if (!z16) {
                QLog.e(ag.this.getTAG(), 1, "doBadgeArkShareRequest fail, fail code is " + errorCode);
                return;
            }
            QQToastUtil.showQQToastInUiThread(5, com.qzone.util.l.a(R.string.v8m));
        }
    }
}
