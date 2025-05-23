package nc;

import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.common.bean.CommonAlbumListBean;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxMainPageInitBean;
import com.qzone.reborn.base.n;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.AlbumInfo;
import com.tencent.qqnt.kernel.nativeinterface.AlbumListReqScene;
import com.tencent.qqnt.kernel.nativeinterface.AlbumPageInfo;
import com.tencent.qqnt.kernel.nativeinterface.AlbumPageOpMask;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetAlbumListCallback;
import com.tencent.qqnt.kernel.nativeinterface.PAGetAlbumListReq;
import com.tencent.qqnt.kernel.nativeinterface.PAGetAlbumListRsp;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZonePhotoDegrade$QueryNotifyMsgRsp;
import tb.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 I2\u00020\u0001:\u0001JB\u0007\u00a2\u0006\u0004\bG\u0010HJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002J \u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001a\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\rH\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u0016\u0010\u0017\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002J\u0006\u0010\u0018\u001a\u00020\u0002J\u0006\u0010\u0019\u001a\u00020\u0002J\u0006\u0010\u001a\u001a\u00020\u0002J\u0006\u0010\u001b\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\u0004R$\u0010#\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d8\u0006@BX\u0086.\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R(\u0010,\u001a\b\u0012\u0004\u0012\u00020%0$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R4\u00105\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$0.0-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R*\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001060-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u00100\u001a\u0004\b8\u00102\"\u0004\b9\u00104R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R$\u0010F\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E\u00a8\u0006K"}, d2 = {"Lnc/ae;", "Lcom/qzone/reborn/base/n;", "", "R1", "", "T1", "Lcom/tencent/qqnt/kernel/nativeinterface/PAGetAlbumListRsp;", "response", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "c2", "", "startPosition", ICustomDataEditor.NUMBER_PARAM_2, "", "errMsg", "e2", "l2", "m2", "getLogTag", "Landroid/content/Intent;", "intent", "f2", "canReadCache", SemanticAttributes.DbSystemValues.H2, "Q1", "S1", "d2", "g2", "k2", "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxMainPageInitBean;", "<set-?>", "i", "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxMainPageInitBean;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxMainPageInitBean;", "mInitBean", "", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumListBean;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "X1", "()Ljava/util/List;", "setMAllAlbumList", "(Ljava/util/List;)V", "mAllAlbumList", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "W1", "()Landroidx/lifecycle/MutableLiveData;", "setMAlbumData", "(Landroidx/lifecycle/MutableLiveData;)V", "mAlbumData", "Lqzone/QZonePhotoDegrade$QueryNotifyMsgRsp;", "D", "Z1", "setMDegradeTipsData", "mDegradeTipsData", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "E", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "loadInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/AlbumPageInfo;", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/kernel/nativeinterface/AlbumPageInfo;", "b2", "()Lcom/tencent/qqnt/kernel/nativeinterface/AlbumPageInfo;", "setPageInfo", "(Lcom/tencent/qqnt/kernel/nativeinterface/AlbumPageInfo;)V", "pageInfo", "<init>", "()V", "G", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class ae extends com.qzone.reborn.base.n {

    /* renamed from: F, reason: from kotlin metadata */
    private AlbumPageInfo pageInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZAlbumxMainPageInitBean mInitBean;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private List<CommonAlbumListBean> mAllAlbumList = new ArrayList();

    /* renamed from: C, reason: from kotlin metadata */
    private MutableLiveData<UIStateData<List<CommonAlbumListBean>>> mAlbumData = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    private MutableLiveData<QZonePhotoDegrade$QueryNotifyMsgRsp> mDegradeTipsData = new MutableLiveData<>();

    /* renamed from: E, reason: from kotlin metadata */
    private LoadInfo loadInfo = new LoadInfo();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"nc/ae$b", "Lcom/qzone/reborn/base/n$a;", "Lqzone/QZonePhotoDegrade$QueryNotifyMsgRsp;", "", "errorCode", "", "errorMsg", "", "onFailure", "t", "retCode", "msg", "", "isFinish", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements n.a<QZonePhotoDegrade$QueryNotifyMsgRsp> {
        b() {
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(QZonePhotoDegrade$QueryNotifyMsgRsp t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(t16, "t");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            ae.this.Z1().setValue(t16);
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            ae.this.Z1().setValue(null);
        }
    }

    private final boolean R1() {
        if (!PreLoader.exists("qzone_albumx_album_list_data_preload_id")) {
            return false;
        }
        QLog.d(getTAG(), 1, "canFetchDataFromPreloadTask from preload task");
        T1();
        return true;
    }

    private final void T1() {
        PreLoader.addListener("qzone_albumx_album_list_data_preload_id", new OnTaskListener() { // from class: nc.ab
            @Override // com.tencent.mobileqq.engineering.preload.inter.OnTaskListener
            public final void onComplete(Object[] objArr) {
                ae.U1(ae.this, objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(ae this$0, Object[] objArr) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (objArr == null || objArr.length != 1) {
            return;
        }
        Object obj = objArr[0];
        if (obj instanceof b.C11280b) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.qzone.reborn.albumx.qzonex.preload.QZAlbumxAlbumListPreLoaderTask.RspBean");
            b.C11280b c11280b = (b.C11280b) obj;
            if (c11280b.getResponse() == null) {
                QLog.e(this$0.getTAG(), 1, "fetchAlbumListDataFromPreload  rspBean.response == null");
                return;
            }
            PAGetAlbumListRsp response = c11280b.getResponse();
            Intrinsics.checkNotNull(response);
            this$0.c2(response, false);
        }
    }

    private final void e2(String errMsg, boolean isLoadMore) {
        this.mAlbumData.postValue(UIStateData.obtainError(errMsg).setRetCode(0L).setLoadMore(isLoadMore));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i2(long j3, final ae this$0, final boolean z16, final PAGetAlbumListRsp pAGetAlbumListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!pAGetAlbumListRsp.isFromCache) {
            mc.c.f416541a.e("getAlbumList", System.currentTimeMillis() - j3, pAGetAlbumListRsp.result);
        }
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: nc.ac
            @Override // java.lang.Runnable
            public final void run() {
                ae.j2(ae.this, pAGetAlbumListRsp, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j2(ae this$0, PAGetAlbumListRsp response, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(response, "response");
        this$0.c2(response, z16);
    }

    private final void l2() {
        LoadInfo loadInfo = new LoadInfo();
        this.loadInfo = loadInfo;
        loadInfo.setStringAttachInfo("");
        this.loadInfo.setFinish(false);
    }

    private final void n2(final PAGetAlbumListRsp response, final boolean isLoadMore, final int startPosition) {
        UIStateData.ModifyListRecord obtainNotifyDataSetChanged;
        if (!RFWThreadManager.isMainThread()) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: nc.ad
                @Override // java.lang.Runnable
                public final void run() {
                    ae.o2(ae.this, response, isLoadMore, startPosition);
                }
            });
            return;
        }
        if (com.tencent.mobileqq.utils.bl.b(this.mAllAlbumList)) {
            this.mAlbumData.setValue(UIStateData.obtainEmpty().setRetCode(response.result).setLoadMore(isLoadMore));
            return;
        }
        if (!isLoadMore && Q1()) {
            List<CommonAlbumListBean> list = this.mAllAlbumList;
            CommonAlbumListBean commonAlbumListBean = new CommonAlbumListBean(new CommonAlbumInfo());
            commonAlbumListBean.setItemType(2);
            Unit unit = Unit.INSTANCE;
            list.add(0, commonAlbumListBean);
        }
        if (isLoadMore) {
            obtainNotifyDataSetChanged = UIStateData.ModifyListRecord.obtainNotifyItemRangeInsert(startPosition, this.mAllAlbumList.size());
            Intrinsics.checkNotNullExpressionValue(obtainNotifyDataSetChanged, "{\n            UIStateDat\u2026e\n            )\n        }");
        } else {
            obtainNotifyDataSetChanged = UIStateData.ModifyListRecord.obtainNotifyDataSetChanged();
            Intrinsics.checkNotNullExpressionValue(obtainNotifyDataSetChanged, "{\n            UIStateDat\u2026ataSetChanged()\n        }");
        }
        this.loadInfo.setFinish(!response.hasMore);
        this.mAlbumData.setValue(UIStateData.obtainSuccess(response.isFromCache).setData(isLoadMore, this.mAllAlbumList).setLatestModifyRecord(obtainNotifyDataSetChanged).setFinish(this.loadInfo.isFinish()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o2(ae this$0, PAGetAlbumListRsp response, boolean z16, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(response, "$response");
        this$0.n2(response, z16, i3);
    }

    public final boolean Q1() {
        ArrayList<Integer> arrayList;
        AlbumPageInfo albumPageInfo = this.pageInfo;
        if (albumPageInfo == null || (arrayList = albumPageInfo.masks) == null) {
            return false;
        }
        return arrayList.contains(Integer.valueOf(AlbumPageOpMask.ALBUMPAGEOPMASKCREATE.ordinal()));
    }

    public final boolean S1() {
        ArrayList<Integer> arrayList;
        AlbumPageInfo albumPageInfo = this.pageInfo;
        if (albumPageInfo == null || (arrayList = albumPageInfo.masks) == null) {
            return false;
        }
        return arrayList.contains(Integer.valueOf(AlbumPageOpMask.ALBUMPAGEOPMASKUPLOAD.ordinal()));
    }

    public final MutableLiveData<UIStateData<List<CommonAlbumListBean>>> W1() {
        return this.mAlbumData;
    }

    public final List<CommonAlbumListBean> X1() {
        return this.mAllAlbumList;
    }

    public final MutableLiveData<QZonePhotoDegrade$QueryNotifyMsgRsp> Z1() {
        return this.mDegradeTipsData;
    }

    public final QZAlbumxMainPageInitBean a2() {
        QZAlbumxMainPageInitBean qZAlbumxMainPageInitBean = this.mInitBean;
        if (qZAlbumxMainPageInitBean != null) {
            return qZAlbumxMainPageInitBean;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mInitBean");
        return null;
    }

    /* renamed from: b2, reason: from getter */
    public final AlbumPageInfo getPageInfo() {
        return this.pageInfo;
    }

    public final boolean d2() {
        AlbumPageInfo albumPageInfo = this.pageInfo;
        ArrayList<Integer> arrayList = albumPageInfo != null ? albumPageInfo.masks : null;
        if (arrayList == null || arrayList.isEmpty()) {
            return false;
        }
        AlbumPageInfo albumPageInfo2 = this.pageInfo;
        Intrinsics.checkNotNull(albumPageInfo2);
        if (albumPageInfo2.masks.contains(Integer.valueOf(AlbumPageOpMask.ALBUMPAGEOPMASKCREATE.ordinal()))) {
            return true;
        }
        AlbumPageInfo albumPageInfo3 = this.pageInfo;
        Intrinsics.checkNotNull(albumPageInfo3);
        return albumPageInfo3.masks.contains(Integer.valueOf(AlbumPageOpMask.ALBUMPAGEOPMASKUPLOAD.ordinal()));
    }

    public final void g2() {
        RFWLog.d(getTAG(), RFWLog.USR, "refreshAdapter");
        UIStateData<List<CommonAlbumListBean>> value = this.mAlbumData.getValue();
        if (value != null) {
            if (!this.mAllAlbumList.isEmpty()) {
                RFWLog.d(getTAG(), RFWLog.USR, "refreshAdapter set to succeed");
                value.setState(2);
            } else {
                RFWLog.d(getTAG(), RFWLog.USR, "refreshAdapter set to empty");
                value.setState(0);
            }
            value.setDataList(this.mAllAlbumList);
        }
        this.mAlbumData.postValue(value);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxAlbumListViewModel";
    }

    public final void k2() {
        if (!(a2().getUin().length() == 0) && Intrinsics.areEqual(a2().getUin(), LoginData.getInstance().getUinString())) {
            na.c.f419539a.i(1, new b());
        } else {
            RFWLog.d("QZAlbumxAlbumListViewModel", RFWLog.USR, "requestPhotoDegradeNotify fail: guest user");
        }
    }

    private final void m2() {
        this.pageInfo = null;
    }

    public final void f2(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("key_bundle_common_init_bean")) {
            return;
        }
        Serializable serializable = extras.getSerializable("key_bundle_common_init_bean");
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxMainPageInitBean");
        this.mInitBean = (QZAlbumxMainPageInitBean) serializable;
    }

    public final void h2(final boolean isLoadMore, boolean canReadCache) {
        if (!isLoadMore) {
            l2();
            m2();
        }
        QLog.d(getTAG(), 1, "requestAlbumList  attachInfo : " + this.loadInfo.getStringAttachInfo() + " | isLoadMore : " + isLoadMore + " | currentState : " + this.loadInfo.getCurrentState());
        if (!(!isLoadMore && canReadCache && R1()) && this.loadInfo.getCurrentState() == 4) {
            this.loadInfo.setCurrentState(2);
            PAGetAlbumListReq pAGetAlbumListReq = new PAGetAlbumListReq();
            final long currentTimeMillis = System.currentTimeMillis();
            pAGetAlbumListReq.user.uin = a2().getUin();
            String stringAttachInfo = this.loadInfo.getStringAttachInfo();
            if (stringAttachInfo == null) {
                stringAttachInfo = "";
            }
            pAGetAlbumListReq.attachInfo = stringAttachInfo;
            pAGetAlbumListReq.requestTimeLine.requestInvokeTime = currentTimeMillis;
            pAGetAlbumListReq.count = 10;
            pAGetAlbumListReq.scene = AlbumListReqScene.KALBUMLISTREQSCENEALBUMTAB.ordinal();
            pAGetAlbumListReq.enableCache = !isLoadMore;
            pAGetAlbumListReq.canReadCache = canReadCache;
            com.tencent.qqnt.kernel.api.z b16 = com.qzone.reborn.albumx.qzonex.utils.i.b();
            if (b16 != null) {
                b16.getAlbumList(pAGetAlbumListReq, new IPersonalAlbumServiceGetAlbumListCallback() { // from class: nc.aa
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetAlbumListCallback
                    public final void onGetAlbumList(PAGetAlbumListRsp pAGetAlbumListRsp) {
                        ae.i2(currentTimeMillis, this, isLoadMore, pAGetAlbumListRsp);
                    }
                });
            }
        }
    }

    private final void c2(PAGetAlbumListRsp response, boolean isLoadMore) {
        String tag = getTAG();
        int i3 = response.seq;
        String str = response.traceId;
        int i16 = response.result;
        String str2 = response.errMs;
        String str3 = response.attachInfo;
        boolean z16 = response.hasMore;
        AlbumPageInfo albumPageInfo = response.pageInfo;
        QLog.i(tag, 1, "handleAlbumListRsp seq:" + i3 + " | traceId:" + str + " | resultCode:" + i16 + " | errMsg:" + str2 + " | attachInfo:" + str3 + " | hasMore:" + z16 + " | albumNum:" + albumPageInfo.albumNum + " | photoNum:" + albumPageInfo.photoNum + " | videoNum:" + albumPageInfo.videoNum + " | masks:" + Arrays.toString(albumPageInfo.masks.toArray()) + " | isLoadMore:" + isLoadMore + " | isFromCache:" + response.isFromCache);
        this.loadInfo.setCurrentState(4);
        if (response.result != 0) {
            QLog.e(getTAG(), 1, "handleAlbumListResponse rsp error,retCode=" + response.result + ",errMsg=" + response.errMs);
            e2(response.errMs, isLoadMore);
            return;
        }
        this.loadInfo.setStringAttachInfo(response.attachInfo);
        if (!isLoadMore) {
            this.mAllAlbumList.clear();
            this.pageInfo = response.pageInfo;
        }
        int size = this.mAllAlbumList.size();
        ArrayList arrayList = new ArrayList();
        ArrayList<AlbumInfo> arrayList2 = response.albums;
        if (arrayList2 != null) {
            Iterator<AlbumInfo> it = arrayList2.iterator();
            while (it.hasNext()) {
                AlbumInfo item = it.next();
                Intrinsics.checkNotNullExpressionValue(item, "item");
                CommonAlbumListBean commonAlbumListBean = new CommonAlbumListBean(xh.a.a(item));
                if (commonAlbumListBean.getAlbumInfo().getQzAlbumType() == 13) {
                    commonAlbumListBean.setItemType(3);
                } else {
                    commonAlbumListBean.setItemType(0);
                }
                arrayList.add(commonAlbumListBean);
            }
        }
        this.mAllAlbumList.addAll(arrayList);
        String tag2 = getTAG();
        ArrayList<AlbumInfo> arrayList3 = response.albums;
        int size2 = arrayList3 != null ? arrayList3.size() : 0;
        QLog.d(tag2, 1, "[handleAlbumListResponse]  | rsp.vecAlbumList.size: " + size2 + " | mAllAlbumList.size: " + this.mAllAlbumList.size());
        n2(response, isLoadMore, size);
    }
}
