package qc;

import android.content.Intent;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.common.viewmodel.l;
import com.qzone.reborn.albumx.qzonex.bean.upload.QZAlbumxUploadSelectAlbumInitBean;
import com.qzone.reborn.albumx.qzonex.utils.i;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.z;
import com.tencent.qqnt.kernel.nativeinterface.AlbumInfo;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetAlbumListCallback;
import com.tencent.qqnt.kernel.nativeinterface.PAGetAlbumListReq;
import com.tencent.qqnt.kernel.nativeinterface.PAGetAlbumListRsp;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000  2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJX\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\u000e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012J\b\u0010\u0015\u001a\u00020\fH\u0016J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\fH\u0014R$\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00178\u0006@BX\u0086.\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lqc/h;", "Lcom/qzone/reborn/albumx/common/viewmodel/l;", "", "traceId", "", "retCode", "errMsg", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/AlbumInfo;", "Lkotlin/collections/ArrayList;", "albumList", "attachInfo", "", "hasMore", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "", "b2", "getLogTag", "Landroid/content/Intent;", "intent", "c2", "Q1", "W1", "Lcom/qzone/reborn/albumx/qzonex/bean/upload/QZAlbumxUploadSelectAlbumInitBean;", "<set-?>", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/albumx/qzonex/bean/upload/QZAlbumxUploadSelectAlbumInitBean;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()Lcom/qzone/reborn/albumx/qzonex/bean/upload/QZAlbumxUploadSelectAlbumInitBean;", "initBean", "<init>", "()V", "G", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class h extends l {

    /* renamed from: F, reason: from kotlin metadata */
    private QZAlbumxUploadSelectAlbumInitBean initBean;

    private final void b2(String traceId, int retCode, String errMsg, ArrayList<AlbumInfo> albumList, String attachInfo, boolean hasMore, boolean isLoadMore) {
        ArrayList arrayList;
        UIStateData.ModifyListRecord obtainNotifyDataSetChanged;
        int collectionSizeOrDefault;
        QLog.i(getLogTag(), 1, "handleAlbumListRsp seq: " + traceId + " | retCode: " + retCode + " | errMsg:" + errMsg + " | attachInfo:" + attachInfo + " | hasMore:" + hasMore + " | isLoadMore:" + isLoadMore);
        getLoadInfo().setCurrentState(4);
        if (retCode != 0) {
            QLog.e(getLogTag(), 1, "handleAlbumListResponse rsp error  retCode = " + retCode + " errMsg = " + errMsg);
            P1().postValue(UIStateData.obtainError(errMsg).setRetCode((long) retCode).setLoadMore(isLoadMore));
            return;
        }
        getLoadInfo().setStringAttachInfo(attachInfo);
        if (!isLoadMore) {
            N1().clear();
        }
        int size = N1().size();
        if (albumList != null) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(albumList, 10);
            arrayList = new ArrayList(collectionSizeOrDefault);
            for (AlbumInfo albumInfo : albumList) {
                arrayList.add(new com.qzone.reborn.albumx.common.bean.h(xh.a.a(albumInfo), Intrinsics.areEqual(albumInfo.albumId, a2().getAlbumId())));
            }
        } else {
            arrayList = new ArrayList();
        }
        N1().addAll(arrayList);
        String logTag = getLogTag();
        int size2 = albumList != null ? albumList.size() : 0;
        QLog.d(logTag, 1, "[handleAlbumListResponse]  | rsp.vecAlbumList.size: " + size2 + " | allAlbumList.size: " + N1().size());
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
        getLoadInfo().setFinish(!hasMore);
        P1().postValue(UIStateData.obtainSuccess(VSNetworkHelper.isProtocolCache(errMsg)).setData(isLoadMore, N1()).setLatestModifyRecord(obtainNotifyDataSetChanged).setFinish(getLoadInfo().isFinish()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d2(long j3, final h this$0, final boolean z16, final PAGetAlbumListRsp pAGetAlbumListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!pAGetAlbumListRsp.isFromCache) {
            mc.c.f416541a.e("getAlbumList", System.currentTimeMillis() - j3, pAGetAlbumListRsp.result);
        }
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: qc.g
            @Override // java.lang.Runnable
            public final void run() {
                h.e2(h.this, pAGetAlbumListRsp, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e2(h this$0, PAGetAlbumListRsp pAGetAlbumListRsp, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = pAGetAlbumListRsp.traceId;
        Intrinsics.checkNotNullExpressionValue(str, "response.traceId");
        this$0.b2(str, pAGetAlbumListRsp.result, pAGetAlbumListRsp.errMs, pAGetAlbumListRsp.albums, pAGetAlbumListRsp.attachInfo, pAGetAlbumListRsp.hasMore, z16);
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.l
    public boolean Q1() {
        return true;
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.l
    protected void W1(final boolean isLoadMore) {
        PAGetAlbumListReq pAGetAlbumListReq = new PAGetAlbumListReq();
        final long currentTimeMillis = System.currentTimeMillis();
        pAGetAlbumListReq.user.uin = a2().getUin();
        String stringAttachInfo = getLoadInfo().getStringAttachInfo();
        if (stringAttachInfo == null) {
            stringAttachInfo = "";
        }
        pAGetAlbumListReq.attachInfo = stringAttachInfo;
        pAGetAlbumListReq.requestTimeLine.requestInvokeTime = currentTimeMillis;
        pAGetAlbumListReq.count = 10;
        pAGetAlbumListReq.enableCache = !isLoadMore;
        z b16 = i.b();
        if (b16 != null) {
            b16.getAlbumList(pAGetAlbumListReq, new IPersonalAlbumServiceGetAlbumListCallback() { // from class: qc.f
                @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetAlbumListCallback
                public final void onGetAlbumList(PAGetAlbumListRsp pAGetAlbumListRsp) {
                    h.d2(currentTimeMillis, this, isLoadMore, pAGetAlbumListRsp);
                }
            });
        }
    }

    public final QZAlbumxUploadSelectAlbumInitBean a2() {
        QZAlbumxUploadSelectAlbumInitBean qZAlbumxUploadSelectAlbumInitBean = this.initBean;
        if (qZAlbumxUploadSelectAlbumInitBean != null) {
            return qZAlbumxUploadSelectAlbumInitBean;
        }
        Intrinsics.throwUninitializedPropertyAccessException("initBean");
        return null;
    }

    public final void c2(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Serializable serializableExtra = intent.getSerializableExtra("key_bundle_common_init_bean");
        Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type com.qzone.reborn.albumx.qzonex.bean.upload.QZAlbumxUploadSelectAlbumInitBean");
        this.initBean = (QZAlbumxUploadSelectAlbumInitBean) serializableExtra;
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.l, com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QZAlbumxUploadSelectAlbumViewModel";
    }
}
