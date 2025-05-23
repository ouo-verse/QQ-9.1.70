package nk;

import android.content.Intent;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateSelectAlbumInitBean;
import com.qzone.reborn.intimate.bean.init.Source;
import com.qzone.reborn.intimate.request.QZoneIntimateGetAlbumListRequest;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceAlbum$GetAlbumListRsp;
import qzone.QZoneBaseAlbumMeta$AlbumInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000  2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ2\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u0002H\u0002J8\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\u000e\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002H\u0014R$\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00178\u0006@BX\u0086.\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lnk/bb;", "Lcom/qzone/reborn/albumx/common/viewmodel/l;", "", "isSuccess", "", "retCode", "", "errMsg", "Lqzone/QZIntimateSpaceAlbum$GetAlbumListRsp;", "rsp", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "", ICustomDataEditor.STRING_ARRAY_PARAM_2, "msg", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "req", "c2", "getLogTag", "Landroid/content/Intent;", "intent", "b2", "Q1", "W1", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateSelectAlbumInitBean;", "<set-?>", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateSelectAlbumInitBean;", "Z1", "()Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateSelectAlbumInitBean;", "initBean", "<init>", "()V", "G", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class bb extends com.qzone.reborn.albumx.common.viewmodel.l {

    /* renamed from: F, reason: from kotlin metadata */
    private QZoneIntimateSelectAlbumInitBean initBean;

    private final void a2(boolean isSuccess, long retCode, String errMsg, QZIntimateSpaceAlbum$GetAlbumListRsp rsp, boolean isLoadMore) {
        int collectionSizeOrDefault;
        UIStateData.ModifyListRecord obtainNotifyDataSetChanged;
        getLoadInfo().setCurrentState(4);
        if (isSuccess && rsp != null && retCode == 0) {
            getLoadInfo().setStringAttachInfo(rsp.attach_info.get());
            if (!isLoadMore) {
                N1().clear();
            }
            int size = N1().size();
            List<QZoneBaseAlbumMeta$AlbumInfo> list = rsp.album_list.get();
            Intrinsics.checkNotNullExpressionValue(list, "rsp.album_list.get()");
            List<QZoneBaseAlbumMeta$AlbumInfo> list2 = list;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (QZoneBaseAlbumMeta$AlbumInfo it : list2) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.add(new com.qzone.reborn.albumx.common.bean.h(mj.a.b(it), Intrinsics.areEqual(it.album_id.get(), Z1().getAlbumId())));
            }
            N1().addAll(arrayList);
            QLog.d(getLogTag(), 1, "[handleAlbumListResponse]  | attachInfo: " + rsp.attach_info.get() + " | hasMore: " + rsp.has_more.get() + " | rsp.vecAlbumList.size: " + rsp.album_list.get().size() + " | allAlbumList.size: " + N1().size());
            if (bl.b(N1())) {
                P1().postValue(UIStateData.obtainEmpty().setRetCode(retCode).setLoadMore(isLoadMore));
                return;
            }
            if (isLoadMore) {
                obtainNotifyDataSetChanged = UIStateData.ModifyListRecord.obtainNotifyItemRangeInsert(size, arrayList.size());
                Intrinsics.checkNotNullExpressionValue(obtainNotifyDataSetChanged, "{\n            UIStateDat\u2026ion, list.size)\n        }");
            } else {
                obtainNotifyDataSetChanged = UIStateData.ModifyListRecord.obtainNotifyDataSetChanged();
                Intrinsics.checkNotNullExpressionValue(obtainNotifyDataSetChanged, "{\n            UIStateDat\u2026ataSetChanged()\n        }");
            }
            getLoadInfo().setFinish(!rsp.has_more.get());
            P1().postValue(UIStateData.obtainSuccess(VSNetworkHelper.isProtocolCache(errMsg)).setData(isLoadMore, N1()).setLatestModifyRecord(obtainNotifyDataSetChanged).setFinish(getLoadInfo().isFinish()));
            return;
        }
        QLog.e(getLogTag(), 1, "handleAlbumListResponse rsp error  isSuccess = " + isSuccess + " retCode = " + retCode + " errMsg = " + errMsg + " rsp = " + rsp);
        P1().postValue(UIStateData.obtainError(errMsg).setRetCode(retCode).setLoadMore(isLoadMore));
    }

    private final void c2(String msg2, boolean isSuccess, BaseRequest req, long retCode, String errMsg, boolean isLoadMore) {
        QLog.i(getLogTag(), 1, msg2 + " responseLog onReceive, isSuccess: " + isSuccess + " | traceId: " + req.getTraceId() + " | seqId:" + req.getCurrentSeq() + " | cmdName:" + req.getCmdName() + " | retCode:" + retCode + " | retMessage:" + errMsg + " | isLoadMore:" + isLoadMore);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d2(bb this$0, boolean z16, BaseRequest request1, boolean z17, long j3, String errMsg, QZIntimateSpaceAlbum$GetAlbumListRsp qZIntimateSpaceAlbum$GetAlbumListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(request1, "request1");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        this$0.c2("[requestAlbumList]", z17, request1, j3, errMsg, z16);
        this$0.a2(z17, j3, errMsg, qZIntimateSpaceAlbum$GetAlbumListRsp, z16);
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.l
    public boolean Q1() {
        return Z1().isFromUploadAlbum();
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.l
    protected void W1(final boolean isLoadMore) {
        int i3 = Z1().getSource() == Source.DISSOLUTION_RELATIONSHIP ? 2 : 0;
        String spaceId = Z1().getSpaceId();
        String stringAttachInfo = getLoadInfo().getStringAttachInfo();
        if (stringAttachInfo == null) {
            stringAttachInfo = "";
        }
        sendRequest(new QZoneIntimateGetAlbumListRequest(spaceId, stringAttachInfo, i3), new VSDispatchObserver.OnVSRspCallBack() { // from class: nk.ba
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                bb.d2(bb.this, isLoadMore, baseRequest, z16, j3, str, (QZIntimateSpaceAlbum$GetAlbumListRsp) obj);
            }
        });
    }

    public final QZoneIntimateSelectAlbumInitBean Z1() {
        QZoneIntimateSelectAlbumInitBean qZoneIntimateSelectAlbumInitBean = this.initBean;
        if (qZoneIntimateSelectAlbumInitBean != null) {
            return qZoneIntimateSelectAlbumInitBean;
        }
        Intrinsics.throwUninitializedPropertyAccessException("initBean");
        return null;
    }

    public final void b2(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Serializable serializableExtra = intent.getSerializableExtra("key_bundle_common_init_bean");
        Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type com.qzone.reborn.intimate.bean.init.QZoneIntimateSelectAlbumInitBean");
        this.initBean = (QZoneIntimateSelectAlbumInitBean) serializableExtra;
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.l, com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QZoneIntimateSelectAlbumViewModel";
    }
}
