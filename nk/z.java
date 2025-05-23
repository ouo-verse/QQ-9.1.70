package nk;

import ak.d;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.common.bean.CommonAlbumListBean;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateMainPageInitBean;
import com.qzone.reborn.intimate.event.QZIntimateEnableSyncFromQZoneEvent;
import com.qzone.reborn.intimate.request.QZoneIntimateGetAlbumListRequest;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.bl;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import qzone.QZIntimateSpaceAlbum$AlbumCommData;
import qzone.QZIntimateSpaceAlbum$GetAlbumListRsp;
import qzone.QZoneBaseAlbumMeta$AlbumInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 R2\u00020\u0001:\u0001SB\u0007\u00a2\u0006\u0004\bP\u0010QJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J2\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J8\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u0014\u001a\u00020\tH\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u0019\u001a\u00020\u0002J\u0006\u0010\u001a\u001a\u00020\u0002J\u0006\u0010\u001b\u001a\u00020\u0002J\u0006\u0010\u001c\u001a\u00020\u0002J\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dJ\u0006\u0010 \u001a\u00020\u0004R\"\u0010'\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010.\u001a\u00020(2\u0006\u0010)\u001a\u00020(8\u0006@BX\u0086.\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\"\u00101\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R(\u0010D\u001a\b\u0012\u0004\u0012\u00020\u001d0=8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR4\u0010M\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0=0F0E8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001c\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00020E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010H\u00a8\u0006T"}, d2 = {"Lnk/z;", "Lcom/qzone/reborn/base/n;", "", "O1", "", "Q1", "isSuccess", "", "retCode", "", "errMsg", "Lqzone/QZIntimateSpaceAlbum$GetAlbumListRsp;", "rsp", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "X1", SemanticAttributes.DbSystemValues.H2, "msg", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "req", "i2", "getLogTag", "Landroid/content/Intent;", "intent", "d2", "f2", "Z1", ICustomDataEditor.STRING_ARRAY_PARAM_2, "b2", "c2", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumListBean;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "P1", "e2", "i", "Ljava/lang/String;", "W1", "()Ljava/lang/String;", "j2", "(Ljava/lang/String;)V", "mSpaceId", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateMainPageInitBean;", "<set-?>", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateMainPageInitBean;", "U1", "()Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateMainPageInitBean;", "mInitBean", BdhLogUtil.LogTag.Tag_Conn, "Z", "isOpenDebugEnableSync", "()Z", "k2", "(Z)V", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "D", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "loadInfo", "Lqzone/QZIntimateSpaceAlbum$AlbumCommData;", "E", "Lqzone/QZIntimateSpaceAlbum$AlbumCommData;", "mCommData", "", UserInfo.SEX_FEMALE, "Ljava/util/List;", "T1", "()Ljava/util/List;", "setMAllAlbumList", "(Ljava/util/List;)V", "mAllAlbumList", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "G", "Landroidx/lifecycle/MutableLiveData;", "S1", "()Landroidx/lifecycle/MutableLiveData;", "setMAlbumData", "(Landroidx/lifecycle/MutableLiveData;)V", "mAlbumData", "H", "mEnableSync", "<init>", "()V", "I", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class z extends com.qzone.reborn.base.n {

    /* renamed from: E, reason: from kotlin metadata */
    private QZIntimateSpaceAlbum$AlbumCommData mCommData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QZoneIntimateMainPageInitBean mInitBean;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String mSpaceId = "";

    /* renamed from: D, reason: from kotlin metadata */
    private LoadInfo loadInfo = new LoadInfo();

    /* renamed from: F, reason: from kotlin metadata */
    private List<CommonAlbumListBean> mAllAlbumList = new ArrayList();

    /* renamed from: G, reason: from kotlin metadata */
    private MutableLiveData<UIStateData<List<CommonAlbumListBean>>> mAlbumData = new MutableLiveData<>();

    /* renamed from: H, reason: from kotlin metadata */
    private MutableLiveData<Boolean> mEnableSync = new MutableLiveData<>(Boolean.FALSE);

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isOpenDebugEnableSync = gd.a.f401926a.c("KEY_OPEN_INTIMATE_ALBUM_SYNC_ENABLE", false);

    private final boolean O1() {
        if (!PreLoader.exists("album_list_data_preload_id")) {
            return false;
        }
        QLog.d(getLogTag(), 1, "canFetchDataFromPreloadTask from preload task");
        Q1();
        return true;
    }

    private final void Q1() {
        PreLoader.addListener("album_list_data_preload_id", new OnTaskListener() { // from class: nk.y
            @Override // com.tencent.mobileqq.engineering.preload.inter.OnTaskListener
            public final void onComplete(Object[] objArr) {
                z.R1(z.this, objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R1(z this$0, Object[] objArr) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (objArr == null || objArr.length != 1) {
            return;
        }
        Object obj = objArr[0];
        if (obj instanceof d.b) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.qzone.reborn.intimate.preload.QZoneIntimateAlbumListPreLoaderTask.RspBean");
            d.b bVar = (d.b) obj;
            this$0.X1(bVar.getIsSuccess(), bVar.getRetCode(), bVar.getErrMsg(), bVar.getRsp(), false);
        }
    }

    private final void X1(boolean isSuccess, long retCode, String errMsg, QZIntimateSpaceAlbum$GetAlbumListRsp rsp, boolean isLoadMore) {
        UIStateData.ModifyListRecord obtainNotifyDataSetChanged;
        this.loadInfo.setCurrentState(4);
        if (isSuccess && rsp != null && retCode == 0) {
            this.loadInfo.setStringAttachInfo(rsp.attach_info.get());
            this.mCommData = rsp.comm_data.get();
            this.mEnableSync.postValue(Boolean.valueOf(rsp.enable_sync_from_qzone.get()));
            QLog.i("QZoneIntimateAlbumListViewModel", 1, "enable_sync_from_qzone is " + rsp.enable_sync_from_qzone.get());
            SimpleEventBus.getInstance().dispatchEvent(new QZIntimateEnableSyncFromQZoneEvent(c2() && rsp.enable_sync_from_qzone.get()));
            if (!isLoadMore) {
                this.mAllAlbumList.clear();
            }
            int size = this.mAllAlbumList.size();
            ArrayList arrayList = new ArrayList();
            for (QZoneBaseAlbumMeta$AlbumInfo item : rsp.album_list.get()) {
                Intrinsics.checkNotNullExpressionValue(item, "item");
                CommonAlbumListBean commonAlbumListBean = new CommonAlbumListBean(mj.a.b(item));
                commonAlbumListBean.setItemType(0);
                arrayList.add(commonAlbumListBean);
            }
            this.mAllAlbumList.addAll(arrayList);
            QLog.d(getLogTag(), 1, "[handleAlbumListResponse]  | attachInfo: " + rsp.attach_info.get() + " | hasMore: " + rsp.has_more.get() + " | rsp.vecAlbumList.size: " + rsp.album_list.get().size() + " | mAllAlbumList.size: " + this.mAllAlbumList.size() + " | rsp.enable_sync_from_qzone: " + rsp.enable_sync_from_qzone.get());
            if (bl.b(this.mAllAlbumList)) {
                this.mAlbumData.postValue(UIStateData.obtainEmpty().setRetCode(retCode).setLoadMore(isLoadMore));
                return;
            }
            if (!isLoadMore && c2()) {
                List<CommonAlbumListBean> list = this.mAllAlbumList;
                CommonAlbumListBean commonAlbumListBean2 = new CommonAlbumListBean(new CommonAlbumInfo());
                commonAlbumListBean2.setItemType(2);
                Unit unit = Unit.INSTANCE;
                list.add(0, commonAlbumListBean2);
            }
            if (isLoadMore) {
                obtainNotifyDataSetChanged = UIStateData.ModifyListRecord.obtainNotifyItemRangeInsert(size, this.mAllAlbumList.size());
                Intrinsics.checkNotNullExpressionValue(obtainNotifyDataSetChanged, "{\n            ModifyList\u2026AlbumList.size)\n        }");
            } else {
                obtainNotifyDataSetChanged = UIStateData.ModifyListRecord.obtainNotifyDataSetChanged();
                Intrinsics.checkNotNullExpressionValue(obtainNotifyDataSetChanged, "{\n            ModifyList\u2026ataSetChanged()\n        }");
            }
            this.loadInfo.setFinish(!rsp.has_more.get());
            this.mAlbumData.postValue(UIStateData.obtainSuccess(VSNetworkHelper.isProtocolCache(errMsg)).setData(isLoadMore, this.mAllAlbumList).setLatestModifyRecord(obtainNotifyDataSetChanged).setFinish(this.loadInfo.isFinish()));
            return;
        }
        QLog.e(getLogTag(), 1, "handleAlbumListResponse rsp error  isSuccess = " + isSuccess + " retCode = " + retCode + " errMsg = " + errMsg + " rsp = " + rsp);
        this.mAlbumData.postValue(UIStateData.obtainError(errMsg).setRetCode(retCode).setLoadMore(isLoadMore));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g2(z this$0, boolean z16, BaseRequest request1, boolean z17, long j3, String errMsg, QZIntimateSpaceAlbum$GetAlbumListRsp qZIntimateSpaceAlbum$GetAlbumListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(request1, "request1");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        this$0.i2("[requestAlbumList]", z17, request1, j3, errMsg, z16);
        this$0.X1(z17, j3, errMsg, qZIntimateSpaceAlbum$GetAlbumListRsp, z16);
    }

    private final void h2() {
        LoadInfo loadInfo = new LoadInfo();
        this.loadInfo = loadInfo;
        loadInfo.setStringAttachInfo("");
        this.loadInfo.setFinish(false);
        this.mCommData = null;
    }

    private final void i2(String msg2, boolean isSuccess, BaseRequest req, long retCode, String errMsg, boolean isLoadMore) {
        QLog.i(getLogTag(), 1, msg2 + " responseLog onReceive, isSuccess: " + isSuccess + " | traceId: " + req.getTraceId() + " | seqId:" + req.getCurrentSeq() + " | cmdName:" + req.getCmdName() + " | retCode:" + retCode + " | retMessage:" + errMsg + " | isLoadMore:" + isLoadMore);
    }

    public final void P1(CommonAlbumListBean item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (this.mAllAlbumList.contains(item)) {
            this.mAllAlbumList.remove(item);
            e2();
        }
    }

    public final MutableLiveData<UIStateData<List<CommonAlbumListBean>>> S1() {
        return this.mAlbumData;
    }

    public final List<CommonAlbumListBean> T1() {
        return this.mAllAlbumList;
    }

    public final QZoneIntimateMainPageInitBean U1() {
        QZoneIntimateMainPageInitBean qZoneIntimateMainPageInitBean = this.mInitBean;
        if (qZoneIntimateMainPageInitBean != null) {
            return qZoneIntimateMainPageInitBean;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mInitBean");
        return null;
    }

    /* renamed from: W1, reason: from getter */
    public final String getMSpaceId() {
        return this.mSpaceId;
    }

    public final boolean Z1() {
        boolean contains$default;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) com.qzone.reborn.configx.g.f53821a.h().u(), (CharSequence) this.mSpaceId, false, 2, (Object) null);
        QLog.i(getLogTag(), 1, "[hasOwnerHeadView] is expose syn button = " + contains$default);
        if (c2() && b2() && (!this.mAllAlbumList.isEmpty())) {
            return !contains$default || this.isOpenDebugEnableSync;
        }
        return false;
    }

    public final boolean a2() {
        return c2() && b2() && this.mAllAlbumList.isEmpty();
    }

    public final boolean b2() {
        return Intrinsics.areEqual(this.mEnableSync.getValue(), Boolean.TRUE);
    }

    public final boolean c2() {
        PBBoolField pBBoolField;
        QZIntimateSpaceAlbum$AlbumCommData qZIntimateSpaceAlbum$AlbumCommData = this.mCommData;
        if (qZIntimateSpaceAlbum$AlbumCommData == null || (pBBoolField = qZIntimateSpaceAlbum$AlbumCommData.is_member) == null) {
            return false;
        }
        return pBBoolField.get();
    }

    public final void e2() {
        RFWLog.d(getLogTag(), RFWLog.USR, "refreshAdapter");
        UIStateData<List<CommonAlbumListBean>> value = this.mAlbumData.getValue();
        if (value != null) {
            if (!this.mAllAlbumList.isEmpty()) {
                RFWLog.d(getLogTag(), RFWLog.USR, "refreshAdapter set to succeed");
                value.setState(2);
            } else {
                RFWLog.d(getLogTag(), RFWLog.USR, "refreshAdapter set to empty");
                value.setState(0);
            }
            value.setDataList(this.mAllAlbumList);
        }
        this.mAlbumData.postValue(value);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QZoneIntimateAlbumListViewModel";
    }

    public final void j2(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mSpaceId = str;
    }

    public final void k2(boolean z16) {
        this.isOpenDebugEnableSync = z16;
    }

    public final void d2(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("key_bundle_common_init_bean")) {
            return;
        }
        Serializable serializable = extras.getSerializable("key_bundle_common_init_bean");
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.qzone.reborn.intimate.bean.init.QZoneIntimateMainPageInitBean");
        this.mInitBean = (QZoneIntimateMainPageInitBean) serializable;
        this.mSpaceId = U1().getSpaceId();
    }

    public final void f2(final boolean isLoadMore) {
        if (!isLoadMore) {
            h2();
        }
        QLog.d(getLogTag(), 1, "requestAlbumList  attachInfo : " + this.loadInfo + ".stringAttachInfo | isLoadMore : " + isLoadMore);
        if (isLoadMore || !O1()) {
            if (this.loadInfo.getCurrentState() != 4) {
                QLog.w(getLogTag(), 1, "requestAlbumList  mLoadInfo.currentState = " + this.loadInfo + ".currentState");
                return;
            }
            this.loadInfo.setCurrentState(2);
            String str = this.mSpaceId;
            String stringAttachInfo = this.loadInfo.getStringAttachInfo();
            if (stringAttachInfo == null) {
                stringAttachInfo = "";
            }
            sendRequest(new QZoneIntimateGetAlbumListRequest(str, stringAttachInfo, U1().getScene()), new VSDispatchObserver.OnVSRspCallBack() { // from class: nk.x
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str2, Object obj) {
                    z.g2(z.this, isLoadMore, baseRequest, z16, j3, str2, (QZIntimateSpaceAlbum$GetAlbumListRsp) obj);
                }
            });
        }
    }
}
