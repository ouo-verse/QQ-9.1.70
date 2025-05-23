package com.qzone.reborn.groupalbum.viewmodel;

import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.common.bean.CommonAlbumListBean;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumMainPageInitBean;
import com.qzone.reborn.groupalbum.block.GroupAlbumAlbumListHeaderAdapter;
import com.qzone.reborn.groupalbum.event.GroupAlbumBannerEvent;
import com.qzone.reborn.groupalbum.event.GroupAlbumMainFragmentRightEvent;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.AlbumInfo;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetAlbumListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetMainPageCallback;
import com.tencent.qqnt.kernel.nativeinterface.NTGetAlbumListReq;
import com.tencent.qqnt.kernel.nativeinterface.NTGetAlbumListRsp;
import com.tencent.qqnt.kernel.nativeinterface.QunMediaRightEnum;
import com.tencent.qqnt.kernel.nativeinterface.QunRight;
import com.tencent.qqnt.kernel.nativeinterface.StBanner;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qzone.QzoneIPCModule;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseAlbumMeta$AlbumInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 Q2\u00020\u0001:\u0001RB\u0007\u00a2\u0006\u0004\bO\u0010PJ\u0080\u0001\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0007j\b\u0012\u0004\u0012\u00020\u0004`\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\fH\u0002J\u001a\u0010\u0015\u001a\u00020\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\fH\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\u0010\u0010\u001a\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u0006\u0010\u001b\u001a\u00020\u0002J\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\fJ\u0006\u0010\u001d\u001a\u00020\fJ\u0006\u0010\u001e\u001a\u00020\fJ\u0006\u0010\u001f\u001a\u00020\fJ\u0006\u0010 \u001a\u00020\fJ\u0006\u0010!\u001a\u00020\u0013J\u0006\u0010\"\u001a\u00020\u0013R$\u0010)\u001a\u00020#2\u0006\u0010$\u001a\u00020#8\u0006@BX\u0086.\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R(\u00102\u001a\b\u0012\u0004\u0012\u00020+0*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R4\u0010;\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0*04038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R(\u0010@\u001a\b\u0012\u0004\u0012\u00020<038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u00106\u001a\u0004\b>\u00108\"\u0004\b?\u0010:R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\"\u0010K\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR&\u0010N\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0007j\b\u0012\u0004\u0012\u00020\u0004`\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010M\u00a8\u0006S"}, d2 = {"Lcom/qzone/reborn/groupalbum/viewmodel/g;", "Lcom/qzone/reborn/base/n;", "", "traceId", "", QzoneIPCModule.RESULT_CODE, "errMsg", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/AlbumInfo;", "Lkotlin/collections/ArrayList;", "albumList", "attachInfo", "", "hasMore", "isNormalUpLoad", "rightList", "Lcom/tencent/qqnt/kernel/nativeinterface/StBanner;", "banner", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "", ICustomDataEditor.STRING_ARRAY_PARAM_2, "c2", "l2", "getLogTag", "Landroid/content/Intent;", "intent", "d2", "T1", "f2", "b2", "Q1", "S1", "R1", "e2", "i2", "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumMainPageInitBean;", "<set-?>", "i", "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumMainPageInitBean;", "Z1", "()Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumMainPageInitBean;", "mInitBean", "", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumListBean;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "X1", "()Ljava/util/List;", "setMAllAlbumList", "(Ljava/util/List;)V", "mAllAlbumList", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "U1", "()Landroidx/lifecycle/MutableLiveData;", "setMAlbumData", "(Landroidx/lifecycle/MutableLiveData;)V", "mAlbumData", "Lcom/qzone/reborn/groupalbum/block/GroupAlbumAlbumListHeaderAdapter$GroupAlbumHeadInfoBean;", "D", "W1", "setMAlbumHeaderInfo", "mAlbumHeaderInfo", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "E", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "loadInfo", UserInfo.SEX_FEMALE, "Z", "getNormalUpLoad", "()Z", "setNormalUpLoad", "(Z)V", "normalUpLoad", "G", "Ljava/util/ArrayList;", "rightArray", "<init>", "()V", "H", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class g extends com.qzone.reborn.base.n {

    /* renamed from: F, reason: from kotlin metadata */
    private boolean normalUpLoad;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private GroupAlbumMainPageInitBean mInitBean;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private List<CommonAlbumListBean> mAllAlbumList = new ArrayList();

    /* renamed from: C, reason: from kotlin metadata */
    private MutableLiveData<UIStateData<List<CommonAlbumListBean>>> mAlbumData = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    private MutableLiveData<GroupAlbumAlbumListHeaderAdapter.GroupAlbumHeadInfoBean> mAlbumHeaderInfo = new MutableLiveData<>();

    /* renamed from: E, reason: from kotlin metadata */
    private LoadInfo loadInfo = new LoadInfo();

    /* renamed from: G, reason: from kotlin metadata */
    private ArrayList<Integer> rightArray = new ArrayList<>();

    private final void c2(String errMsg, boolean isLoadMore) {
        this.mAlbumData.postValue(UIStateData.obtainError(errMsg).setRetCode(0L).setLoadMore(isLoadMore));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g2(NTGetAlbumListReq request, final g this$0, final boolean z16, final NTGetAlbumListRsp nTGetAlbumListRsp) {
        Intrinsics.checkNotNullParameter(request, "$request");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i3 = nTGetAlbumListRsp.result;
        fj.v.a(i3 == 0, 2, i3, System.currentTimeMillis() - request.requestTimeLine.requestInvokeTime, nTGetAlbumListRsp.traceId);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.groupalbum.viewmodel.e
            @Override // java.lang.Runnable
            public final void run() {
                g.h2(g.this, nTGetAlbumListRsp, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h2(g this$0, NTGetAlbumListRsp nTGetAlbumListRsp, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = nTGetAlbumListRsp.traceId;
        Intrinsics.checkNotNullExpressionValue(str, "response.traceId");
        int i3 = nTGetAlbumListRsp.result;
        String str2 = nTGetAlbumListRsp.errMs;
        ArrayList<AlbumInfo> arrayList = nTGetAlbumListRsp.albumList;
        String str3 = nTGetAlbumListRsp.attachInfo;
        boolean z17 = nTGetAlbumListRsp.hasMore;
        QunRight qunRight = nTGetAlbumListRsp.right;
        boolean z18 = qunRight.normalUpload;
        ArrayList<Integer> arrayList2 = qunRight.right;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "response.right.right");
        StBanner stBanner = nTGetAlbumListRsp.banner;
        Intrinsics.checkNotNullExpressionValue(stBanner, "response.banner");
        this$0.a2(str, i3, str2, arrayList, str3, z17, z18, arrayList2, stBanner, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j2(final g this$0, final int i3, final int i16, final String str, final int i17, final int i18) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.groupalbum.viewmodel.f
            @Override // java.lang.Runnable
            public final void run() {
                g.k2(i16, i17, i18, this$0, i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k2(int i3, int i16, int i17, g this$0, int i18, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            this$0.mAlbumHeaderInfo.postValue(new GroupAlbumAlbumListHeaderAdapter.GroupAlbumHeadInfoBean(i16, i17, false, 4, null));
        } else {
            QLog.e(this$0.getTAG(), 1, "requestGroupMainPage failed!groupId:", this$0.Z1().getGroupId(), ",seq:", Integer.valueOf(i18), "errorCode:", Integer.valueOf(i3), ",errMsg:", str);
        }
    }

    private final void l2() {
        LoadInfo loadInfo = new LoadInfo();
        this.loadInfo = loadInfo;
        loadInfo.setStringAttachInfo("");
        this.loadInfo.setFinish(false);
    }

    public final boolean Q1() {
        return this.rightArray.contains(Integer.valueOf(QunMediaRightEnum.KQUNMEDIARIGHTENUMADDALBUM.ordinal()));
    }

    public final boolean R1() {
        return this.rightArray.contains(Integer.valueOf(QunMediaRightEnum.KQUNMEDIARIGHTENUMUPLOADMEDIA.ordinal()));
    }

    public final boolean S1() {
        return this.rightArray.contains(Integer.valueOf(QunMediaRightEnum.KQUNMEDIARIGHTENUMUPLOADMEDIA.ordinal()));
    }

    public final String T1() {
        return Z1().getGroupId();
    }

    public final MutableLiveData<UIStateData<List<CommonAlbumListBean>>> U1() {
        return this.mAlbumData;
    }

    public final MutableLiveData<GroupAlbumAlbumListHeaderAdapter.GroupAlbumHeadInfoBean> W1() {
        return this.mAlbumHeaderInfo;
    }

    public final List<CommonAlbumListBean> X1() {
        return this.mAllAlbumList;
    }

    public final GroupAlbumMainPageInitBean Z1() {
        GroupAlbumMainPageInitBean groupAlbumMainPageInitBean = this.mInitBean;
        if (groupAlbumMainPageInitBean != null) {
            return groupAlbumMainPageInitBean;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mInitBean");
        return null;
    }

    public final boolean b2() {
        return this.rightArray.contains(Integer.valueOf(QunMediaRightEnum.KQUNMEDIARIGHTENUMADDALBUM.ordinal())) || this.rightArray.contains(Integer.valueOf(QunMediaRightEnum.KQUNMEDIARIGHTENUMUPLOADMEDIA.ordinal()));
    }

    public final void e2() {
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
        return "GroupAlbumAlbumListViewModel";
    }

    public final void i2() {
        com.tencent.qqnt.kernel.api.g b16 = fj.r.b();
        if (b16 != null) {
            b16.n(Z1().getGroupId(), new IAlbumServiceGetMainPageCallback() { // from class: com.qzone.reborn.groupalbum.viewmodel.d
                @Override // com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetMainPageCallback
                public final void onGetMainPage(int i3, int i16, String str, int i17, int i18) {
                    g.j2(g.this, i3, i16, str, i17, i18);
                }
            });
        }
    }

    public final void d2(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("key_bundle_common_init_bean")) {
            return;
        }
        Serializable serializable = extras.getSerializable("key_bundle_common_init_bean");
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.qzone.reborn.groupalbum.bean.init.GroupAlbumMainPageInitBean");
        this.mInitBean = (GroupAlbumMainPageInitBean) serializable;
    }

    public final void f2(final boolean isLoadMore) {
        if (!isLoadMore) {
            if (!NetworkUtil.isNetworkAvailable()) {
                c2(com.qzone.util.l.a(R.string.f1330351), false);
                return;
            } else {
                l2();
                i2();
            }
        }
        QLog.d(getTAG(), 1, "requestAlbumList  attachInfo : " + this.loadInfo.getStringAttachInfo() + " | isLoadMore : " + isLoadMore);
        if (this.loadInfo.getCurrentState() != 4) {
            QLog.w(getTAG(), 1, "requestAlbumList  mLoadInfo.currentState = " + this.loadInfo.getCurrentState());
            return;
        }
        this.loadInfo.setCurrentState(2);
        final NTGetAlbumListReq nTGetAlbumListReq = new NTGetAlbumListReq();
        nTGetAlbumListReq.qunId = Z1().getGroupId();
        String stringAttachInfo = this.loadInfo.getStringAttachInfo();
        if (stringAttachInfo == null) {
            stringAttachInfo = "";
        }
        nTGetAlbumListReq.attachInfo = stringAttachInfo;
        nTGetAlbumListReq.requestTimeLine.requestInvokeTime = System.currentTimeMillis();
        com.tencent.qqnt.kernel.api.g b16 = fj.r.b();
        if (b16 != null) {
            b16.getAlbumList(nTGetAlbumListReq, new IAlbumServiceGetAlbumListCallback() { // from class: com.qzone.reborn.groupalbum.viewmodel.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetAlbumListCallback
                public final void onGetAlbumList(NTGetAlbumListRsp nTGetAlbumListRsp) {
                    g.g2(NTGetAlbumListReq.this, this, isLoadMore, nTGetAlbumListRsp);
                }
            });
        }
    }

    private final void a2(String traceId, int resultCode, String errMsg, ArrayList<AlbumInfo> albumList, String attachInfo, boolean hasMore, boolean isNormalUpLoad, ArrayList<Integer> rightList, StBanner banner, boolean isLoadMore) {
        UIStateData.ModifyListRecord obtainNotifyDataSetChanged;
        QLog.i(getTAG(), 1, "handleAlbumListRsp seq: " + traceId + " | resultCode: " + resultCode + " | errMsg:" + errMsg + " | attachInfo:" + attachInfo + " | hasMore:" + hasMore + " | isNormalUpLoad:" + isNormalUpLoad + " | rightList:" + rightList + " | isLoadMore:" + isLoadMore);
        this.loadInfo.setCurrentState(4);
        this.normalUpLoad = isNormalUpLoad;
        this.rightArray.clear();
        this.rightArray.addAll(rightList);
        if (resultCode != 0) {
            QLog.e(getTAG(), 1, "handleAlbumListResponse rsp error  retCode = " + resultCode + " errMsg = " + errMsg);
            c2(errMsg, isLoadMore);
            return;
        }
        this.loadInfo.setStringAttachInfo(attachInfo);
        if (!isLoadMore) {
            this.mAllAlbumList.clear();
        }
        int size = this.mAllAlbumList.size();
        ArrayList arrayList = new ArrayList();
        if (albumList != null) {
            Iterator<AlbumInfo> it = albumList.iterator();
            while (it.hasNext()) {
                AlbumInfo item = it.next();
                Intrinsics.checkNotNullExpressionValue(item, "item");
                CommonAlbumListBean commonAlbumListBean = new CommonAlbumListBean(xh.a.a(item));
                commonAlbumListBean.setItemType(0);
                arrayList.add(commonAlbumListBean);
            }
        }
        this.mAllAlbumList.addAll(arrayList);
        String tag = getTAG();
        int size2 = albumList != null ? albumList.size() : 0;
        QLog.d(tag, 1, "[handleAlbumListResponse]  | attachInfo: " + attachInfo + " | hasMore: " + hasMore + " | rsp.vecAlbumList.size: " + size2 + " | mAllAlbumList.size: " + this.mAllAlbumList.size());
        SimpleEventBus.getInstance().dispatchEvent(new GroupAlbumMainFragmentRightEvent(S1(), 0));
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        String id5 = banner.f359222id;
        String img = banner.img;
        String color = banner.color;
        String text = banner.text;
        int i3 = banner.actionType;
        String actionUrl = banner.actionUrl;
        long j3 = banner.intervalTime;
        Intrinsics.checkNotNullExpressionValue(id5, "banner.id");
        boolean z16 = id5.length() == 0;
        Intrinsics.checkNotNullExpressionValue(id5, "id");
        Intrinsics.checkNotNullExpressionValue(img, "img");
        Intrinsics.checkNotNullExpressionValue(color, "color");
        Intrinsics.checkNotNullExpressionValue(text, "text");
        Intrinsics.checkNotNullExpressionValue(actionUrl, "actionUrl");
        simpleEventBus.dispatchEvent(new GroupAlbumBannerEvent(id5, img, color, text, actionUrl, j3, i3, z16));
        if (bl.b(this.mAllAlbumList) && !Q1()) {
            this.mAlbumData.postValue(UIStateData.obtainEmpty().setRetCode(resultCode).setLoadMore(isLoadMore));
            return;
        }
        if (!isLoadMore && Q1()) {
            QZoneBaseAlbumMeta$AlbumInfo qZoneBaseAlbumMeta$AlbumInfo = new QZoneBaseAlbumMeta$AlbumInfo();
            List<CommonAlbumListBean> list = this.mAllAlbumList;
            CommonAlbumListBean commonAlbumListBean2 = new CommonAlbumListBean(mj.a.b(qZoneBaseAlbumMeta$AlbumInfo));
            commonAlbumListBean2.setItemType(2);
            Unit unit = Unit.INSTANCE;
            list.add(0, commonAlbumListBean2);
        }
        if (isLoadMore) {
            obtainNotifyDataSetChanged = UIStateData.ModifyListRecord.obtainNotifyItemRangeInsert(size, this.mAllAlbumList.size());
            Intrinsics.checkNotNullExpressionValue(obtainNotifyDataSetChanged, "{\n            UIStateDat\u2026AlbumList.size)\n        }");
        } else {
            obtainNotifyDataSetChanged = UIStateData.ModifyListRecord.obtainNotifyDataSetChanged();
            Intrinsics.checkNotNullExpressionValue(obtainNotifyDataSetChanged, "{\n            UIStateDat\u2026ataSetChanged()\n        }");
        }
        this.loadInfo.setFinish(!hasMore);
        this.mAlbumData.postValue(UIStateData.obtainSuccess(VSNetworkHelper.isProtocolCache(errMsg)).setData(isLoadMore, this.mAllAlbumList).setLatestModifyRecord(obtainNotifyDataSetChanged).setFinish(this.loadInfo.isFinish()));
    }
}
