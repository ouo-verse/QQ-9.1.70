package nk;

import ak.f;
import android.content.Intent;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.intimate.bean.QZoneAlbumSyncBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateAlbumSyncInitBean;
import com.qzone.reborn.intimate.request.QZoneIntimateGetQzoneAlbumListRequest;
import com.qzone.reborn.intimate.request.QZoneIntimateSyncAlbumRequest;
import com.qzone.util.ToastUtil;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceAlbum$GetQzoneAlbumListRsp;
import qzone.QZIntimateSpaceAlbum$SyncQzoneAlbumRsp;
import qzone.QZoneBaseAlbumMeta$AlbumInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bI\u0010JJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J2\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J8\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u0014\u001a\u00020\tH\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002J\u001e\u0010\u001c\u001a\u00020\u00042\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0019j\b\u0012\u0004\u0012\u00020\t`\u001aJ\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u0019j\b\u0012\u0004\u0012\u00020\u001d`\u001aJ\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0019j\b\u0012\u0004\u0012\u00020\t`\u001aJ\u000e\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0002R$\u0010(\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"8\u0006@BX\u0086.\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\"\u00103\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R(\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001d048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R4\u0010D\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d040=0<8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR(\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00020<8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010?\u001a\u0004\bF\u0010A\"\u0004\bG\u0010C\u00a8\u0006K"}, d2 = {"Lnk/ae;", "Lcom/qzone/reborn/base/n;", "", "P1", "", "Q1", "isSuccess", "", "retCode", "", "errMsg", "Lqzone/QZIntimateSpaceAlbum$GetQzoneAlbumListRsp;", "rsp", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "Z1", "d2", "msg", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "req", "e2", "getLogTag", "Landroid/content/Intent;", "intent", ICustomDataEditor.STRING_ARRAY_PARAM_2, "b2", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "albumIds", "g2", "Lcom/qzone/reborn/intimate/bean/QZoneAlbumSyncBean;", "W1", "X1", "isAllDisable", "f2", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateAlbumSyncInitBean;", "<set-?>", "i", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateAlbumSyncInitBean;", "U1", "()Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateAlbumSyncInitBean;", "mInitBean", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "loadInfo", BdhLogUtil.LogTag.Tag_Conn, "Z", "getMIsAllDisable", "()Z", "setMIsAllDisable", "(Z)V", "mIsAllDisable", "", "D", "Ljava/util/List;", "getMAllAlbumList", "()Ljava/util/List;", "setMAllAlbumList", "(Ljava/util/List;)V", "mAllAlbumList", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "E", "Landroidx/lifecycle/MutableLiveData;", "S1", "()Landroidx/lifecycle/MutableLiveData;", "setMAlbumData", "(Landroidx/lifecycle/MutableLiveData;)V", "mAlbumData", UserInfo.SEX_FEMALE, "T1", "setMAlbumSyncIsSuccess", "mAlbumSyncIsSuccess", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class ae extends com.qzone.reborn.base.n {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mIsAllDisable;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZoneIntimateAlbumSyncInitBean mInitBean;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private LoadInfo loadInfo = new LoadInfo();

    /* renamed from: D, reason: from kotlin metadata */
    private List<QZoneAlbumSyncBean> mAllAlbumList = new ArrayList();

    /* renamed from: E, reason: from kotlin metadata */
    private MutableLiveData<UIStateData<List<QZoneAlbumSyncBean>>> mAlbumData = new MutableLiveData<>();

    /* renamed from: F, reason: from kotlin metadata */
    private MutableLiveData<Boolean> mAlbumSyncIsSuccess = new MutableLiveData<>(Boolean.FALSE);

    private final boolean P1() {
        if (!PreLoader.exists("qzone_album_list_data_preload_id")) {
            return false;
        }
        QLog.d(getTAG(), 1, "canFetchDataFromPreloadTask from preload task");
        Q1();
        return true;
    }

    private final void Q1() {
        PreLoader.addListener("qzone_album_list_data_preload_id", new OnTaskListener() { // from class: nk.ad
            @Override // com.tencent.mobileqq.engineering.preload.inter.OnTaskListener
            public final void onComplete(Object[] objArr) {
                ae.R1(ae.this, objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R1(ae this$0, Object[] objArr) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (objArr == null || objArr.length != 1) {
            return;
        }
        Object obj = objArr[0];
        if (obj instanceof f.b) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.qzone.reborn.intimate.preload.QZoneIntimateAlbumSyncPreLoaderTask.RspBean");
            f.b bVar = (f.b) obj;
            this$0.Z1(bVar.getIsSuccess(), bVar.getRetCode(), bVar.getErrMsg(), bVar.getRsp(), false);
        }
    }

    private final void Z1(boolean isSuccess, long retCode, String errMsg, QZIntimateSpaceAlbum$GetQzoneAlbumListRsp rsp, boolean isLoadMore) {
        UIStateData.ModifyListRecord obtainNotifyDataSetChanged;
        this.loadInfo.setCurrentState(4);
        if (isSuccess && rsp != null && retCode == 0) {
            this.loadInfo.setStringAttachInfo(rsp.attach_info.get());
            if (!isLoadMore) {
                this.mAllAlbumList.clear();
            }
            int size = this.mAllAlbumList.size();
            ArrayList arrayList = new ArrayList();
            for (QZoneBaseAlbumMeta$AlbumInfo item : rsp.album_list.get()) {
                Intrinsics.checkNotNullExpressionValue(item, "item");
                QZoneAlbumSyncBean qZoneAlbumSyncBean = new QZoneAlbumSyncBean(item);
                qZoneAlbumSyncBean.setDisable(this.mIsAllDisable);
                arrayList.add(qZoneAlbumSyncBean);
            }
            this.mAllAlbumList.addAll(arrayList);
            QLog.d(getTAG(), 1, "[handleAlbumListResponse]  | attachInfo: " + rsp.attach_info.get() + " | hasMore: " + rsp.has_more.get() + " | rsp.vecAlbumList.size: " + rsp.album_list.get().size() + " | mAllAlbumList.size: " + this.mAllAlbumList.size());
            if (bl.b(this.mAllAlbumList)) {
                this.mAlbumData.postValue(UIStateData.obtainEmpty().setRetCode(retCode).setLoadMore(isLoadMore));
                return;
            }
            if (isLoadMore) {
                obtainNotifyDataSetChanged = UIStateData.ModifyListRecord.obtainNotifyItemRangeInsert(size, arrayList.size());
                Intrinsics.checkNotNullExpressionValue(obtainNotifyDataSetChanged, "{\n            ModifyList\u2026ion, list.size)\n        }");
            } else {
                obtainNotifyDataSetChanged = UIStateData.ModifyListRecord.obtainNotifyDataSetChanged();
                Intrinsics.checkNotNullExpressionValue(obtainNotifyDataSetChanged, "{\n            ModifyList\u2026ataSetChanged()\n        }");
            }
            this.loadInfo.setFinish(!rsp.has_more.get());
            this.mAlbumData.postValue(UIStateData.obtainSuccess(VSNetworkHelper.isProtocolCache(errMsg)).setData(isLoadMore, this.mAllAlbumList).setLatestModifyRecord(obtainNotifyDataSetChanged).setFinish(this.loadInfo.isFinish()));
            return;
        }
        QLog.e(getTAG(), 1, "handleAlbumListResponse rsp error  isSuccess = " + isSuccess + " retCode = " + retCode + " errMsg = " + errMsg + " rsp = " + rsp);
        this.mAlbumData.postValue(UIStateData.obtainError(errMsg).setRetCode(retCode).setLoadMore(isLoadMore));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c2(ae this$0, boolean z16, BaseRequest request1, boolean z17, long j3, String errMsg, QZIntimateSpaceAlbum$GetQzoneAlbumListRsp qZIntimateSpaceAlbum$GetQzoneAlbumListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(request1, "request1");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        this$0.e2("[requestAlbumList]", z17, request1, j3, errMsg, z16);
        this$0.Z1(z17, j3, errMsg, qZIntimateSpaceAlbum$GetQzoneAlbumListRsp, z16);
    }

    private final void d2() {
        LoadInfo loadInfo = new LoadInfo();
        this.loadInfo = loadInfo;
        loadInfo.setStringAttachInfo("");
        this.loadInfo.setFinish(false);
        this.mIsAllDisable = false;
    }

    private final void e2(String msg2, boolean isSuccess, BaseRequest req, long retCode, String errMsg, boolean isLoadMore) {
        QLog.i(getTAG(), 1, msg2 + " responseLog onReceive, isSuccess: " + isSuccess + " | traceId: " + req.getTraceId() + " | seqId:" + req.getCurrentSeq() + " | cmdName:" + req.get$cmd() + " | retCode:" + retCode + " | retMessage:" + errMsg + " | isLoadMore:" + isLoadMore);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h2(ae this$0, BaseRequest request1, boolean z16, long j3, String errMsg, QZIntimateSpaceAlbum$SyncQzoneAlbumRsp qZIntimateSpaceAlbum$SyncQzoneAlbumRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(request1, "request1");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        this$0.e2("[syncAlbumToIntimateSpace]", z16, request1, j3, errMsg, false);
        if (z16 && qZIntimateSpaceAlbum$SyncQzoneAlbumRsp != null && j3 == 0) {
            this$0.mAlbumSyncIsSuccess.postValue(Boolean.TRUE);
        } else {
            ToastUtil.o(R.string.v6y, 1);
        }
    }

    public final MutableLiveData<UIStateData<List<QZoneAlbumSyncBean>>> S1() {
        return this.mAlbumData;
    }

    public final MutableLiveData<Boolean> T1() {
        return this.mAlbumSyncIsSuccess;
    }

    public final QZoneIntimateAlbumSyncInitBean U1() {
        QZoneIntimateAlbumSyncInitBean qZoneIntimateAlbumSyncInitBean = this.mInitBean;
        if (qZoneIntimateAlbumSyncInitBean != null) {
            return qZoneIntimateAlbumSyncInitBean;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mInitBean");
        return null;
    }

    public final ArrayList<QZoneAlbumSyncBean> W1() {
        ArrayList<QZoneAlbumSyncBean> arrayList = new ArrayList<>();
        for (QZoneAlbumSyncBean qZoneAlbumSyncBean : this.mAllAlbumList) {
            if (qZoneAlbumSyncBean.getIsSelected()) {
                arrayList.add(qZoneAlbumSyncBean);
            }
        }
        return arrayList;
    }

    public final ArrayList<String> X1() {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<T> it = W1().iterator();
        while (it.hasNext()) {
            arrayList.add(((QZoneAlbumSyncBean) it.next()).getAlbumInfo().album_id.get());
        }
        return arrayList;
    }

    public final void f2(boolean isAllDisable) {
        Iterator<T> it = this.mAllAlbumList.iterator();
        while (it.hasNext()) {
            ((QZoneAlbumSyncBean) it.next()).setDisable(isAllDisable);
        }
        this.mIsAllDisable = isAllDisable;
        this.mAlbumData.postValue(UIStateData.obtainModify().setDataList(this.mAllAlbumList));
    }

    public final void g2(ArrayList<String> albumIds) {
        Intrinsics.checkNotNullParameter(albumIds, "albumIds");
        QZoneIntimateSyncAlbumRequest qZoneIntimateSyncAlbumRequest = new QZoneIntimateSyncAlbumRequest(U1().getSpaceId(), albumIds);
        QLog.d(getTAG(), 1, "syncAlbumToIntimateSpace spaceId: " + U1().getSpaceId() + ",albumIds : " + albumIds);
        sendRequest(qZoneIntimateSyncAlbumRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: nk.ac
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                ae.h2(ae.this, baseRequest, z16, j3, str, (QZIntimateSpaceAlbum$SyncQzoneAlbumRsp) obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneIntimateAlbumSyncViewModel";
    }

    public final void b2(final boolean isLoadMore) {
        if (!isLoadMore) {
            d2();
        }
        QLog.d(getTAG(), 1, "requestAlbumList  attachInfo : " + this.loadInfo + ".stringAttachInfo | isLoadMore : " + isLoadMore);
        if (isLoadMore || !P1()) {
            if (this.loadInfo.getCurrentState() != 4) {
                QLog.w(getTAG(), 1, "requestAlbumList  mLoadInfo.currentState = " + this.loadInfo + ".currentState");
                return;
            }
            this.loadInfo.setCurrentState(2);
            String stringAttachInfo = this.loadInfo.getStringAttachInfo();
            if (stringAttachInfo == null) {
                stringAttachInfo = "";
            }
            sendRequest(new QZoneIntimateGetQzoneAlbumListRequest(stringAttachInfo, U1().getSpaceId()), new VSDispatchObserver.OnVSRspCallBack() { // from class: nk.ab
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                    ae.c2(ae.this, isLoadMore, baseRequest, z16, j3, str, (QZIntimateSpaceAlbum$GetQzoneAlbumListRsp) obj);
                }
            });
        }
    }

    public final void a2(Intent intent) {
        if (intent == null) {
            return;
        }
        Serializable serializableExtra = intent.getSerializableExtra("key_bundle_common_init_bean");
        Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type com.qzone.reborn.intimate.bean.init.QZoneIntimateAlbumSyncInitBean");
        this.mInitBean = (QZoneIntimateAlbumSyncInitBean) serializableExtra;
    }
}
