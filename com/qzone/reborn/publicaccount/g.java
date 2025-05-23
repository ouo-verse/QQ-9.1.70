package com.qzone.reborn.publicaccount;

import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.qzone.reborn.base.n;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.oskplayer.proxy.VideoProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzone.pb.QZoneOfficialAccount$GetMessageListRsp;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$BottomMenu;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$Message;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mm.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000 52\u00020\u0001:\u00016B\u0007\u00a2\u0006\u0004\b3\u00104J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\"\u0010\n\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J*\u0010\u000e\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0002J(\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0010J\u001c\u0010\u001c\u001a\u00020\u00052\u0012\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u001a0\u0019H\u0004J\u0006\u0010\u001d\u001a\u00020\u0005J\u0006\u0010\u001e\u001a\u00020\u0005J\u0006\u0010\u001f\u001a\u00020\u0005R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R)\u0010(\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u001a0\u00190#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020)0#8\u0006\u00a2\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b+\u0010'R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00067"}, d2 = {"Lcom/qzone/reborn/publicaccount/g;", "Lcom/qzone/reborn/base/n;", "", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, VideoProxy.PARAM_ENABLE_CACHE, "", "d2", QAdRewardDefine$VideoParams.ISCACHE, "Lcom/tencent/qzone/pb/QZoneOfficialAccount$GetMessageListRsp;", "rsp", "T1", "W1", "X1", "isFinish", "Z1", "", "Lmm/a;", TabPreloadItem.TAB_NAME_MESSAGE, "c2", "dataList", "P1", "", "getLogTag", "messageData", "S1", "Lcom/tencent/richframework/data/base/UIStateData;", "", "data", ICustomDataEditor.STRING_ARRAY_PARAM_2, "init", "refresh", FeedManager.LOAD_MORE, "i", "Ljava/lang/String;", "mAttachInfo", "Landroidx/lifecycle/MutableLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "R1", "()Landroidx/lifecycle/MutableLiveData;", "mMsgListData", "Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$BottomMenu;", BdhLogUtil.LogTag.Tag_Conn, "Q1", "mMsgListBottomMenuData", "D", "Ljava/util/List;", "mMessageListData", "E", "Z", "mIsFinish", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class g extends n {

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mIsFinish;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String mAttachInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<UIStateData<List<mm.a>>> mMsgListData = new MutableLiveData<>();

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<QZoneOfficialAccountBase$BottomMenu> mMsgListBottomMenuData = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    private final List<mm.a> mMessageListData = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J2\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/qzone/reborn/publicaccount/g$b", "Lcom/tencent/biz/richframework/network/observer/VSDispatchObserver$OnVSRspCallBack;", "Lcom/tencent/qzone/pb/QZoneOfficialAccount$GetMessageListRsp;", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "baseRequest", "", "isSuccess", "", "retCode", "", "errorMsg", "rsp", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements VSDispatchObserver.OnVSRspCallBack<QZoneOfficialAccount$GetMessageListRsp> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f58777b;

        b(boolean z16) {
            this.f58777b = z16;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean isSuccess, long retCode, String errorMsg, QZoneOfficialAccount$GetMessageListRsp rsp) {
            PBRepeatMessageField<QZoneOfficialAccountBase$Message> pBRepeatMessageField;
            Intrinsics.checkNotNullParameter(baseRequest, "baseRequest");
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            boolean isProtocolCache = VSNetworkHelper.isProtocolCache(errorMsg);
            QLog.d(g.this.getTAG(), 1, hashCode() + " | requestAIOMsgList onReceive: dispatch Success:" + isSuccess + " | traceId:" + baseRequest.getTraceId() + " | retCode:" + retCode + " | retMessage:" + errorMsg + " | isLoadMore:" + this.f58777b + " | isCache:" + isProtocolCache + " | size:" + ((rsp == null || (pBRepeatMessageField = rsp.message_list) == null) ? 0 : pBRepeatMessageField.size()));
            if (isSuccess && retCode == 0) {
                g.this.T1(isProtocolCache, rsp, this.f58777b);
                return;
            }
            g gVar = g.this;
            UIStateData<List<mm.a>> loadMore = UIStateData.obtainError(errorMsg).setRetCode(retCode).setLoadMore(this.f58777b);
            Intrinsics.checkNotNullExpressionValue(loadMore, "obtainError<List<QZonePu\u2026 .setLoadMore(isLoadMore)");
            gVar.a2(loadMore);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T1(final boolean isCache, final QZoneOfficialAccount$GetMessageListRsp rsp, final boolean isLoadMore) {
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.qzone.reborn.publicaccount.f
            @Override // java.lang.Runnable
            public final void run() {
                g.U1(g.this, rsp, isLoadMore, isCache);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(g this$0, QZoneOfficialAccount$GetMessageListRsp qZoneOfficialAccount$GetMessageListRsp, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.W1(qZoneOfficialAccount$GetMessageListRsp);
        boolean X1 = this$0.X1(qZoneOfficialAccount$GetMessageListRsp);
        this$0.mIsFinish = X1;
        this$0.Z1(qZoneOfficialAccount$GetMessageListRsp, z16, z17, X1);
        Intrinsics.checkNotNull(qZoneOfficialAccount$GetMessageListRsp);
        if (qZoneOfficialAccount$GetMessageListRsp.bottom_menu.has()) {
            this$0.mMsgListBottomMenuData.postValue(qZoneOfficialAccount$GetMessageListRsp.bottom_menu);
        }
    }

    private final void Z1(QZoneOfficialAccount$GetMessageListRsp rsp, boolean isLoadMore, boolean isCache, boolean isFinish) {
        List<mm.a> list = this.mMessageListData;
        if (list == null) {
            RFWLog.e("QZonePublicAcntListViewModel", RFWLog.USR, "message list data is null");
            return;
        }
        if (!isLoadMore) {
            list.clear();
        }
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNull(rsp);
        for (QZoneOfficialAccountBase$Message msg2 : rsp.message_list.get()) {
            a.Companion companion = mm.a.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(msg2, "msg");
            arrayList.add(companion.a(msg2));
        }
        List<mm.a> c26 = c2(arrayList, isCache);
        List<mm.a> list2 = this.mMessageListData;
        Intrinsics.checkNotNull(c26);
        list2.addAll(c26);
        UIStateData<List<mm.a>> data = UIStateData.obtainSuccess(isCache).setFinish(isFinish).setData(isLoadMore, this.mMessageListData);
        Intrinsics.checkNotNullExpressionValue(data, "obtainSuccess<List<QZone\u2026adMore, mMessageListData)");
        a2(data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b2(g this$0, UIStateData data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.mMsgListData.setValue(data);
    }

    private final void d2(boolean isLoadMore, boolean enableCache) {
        QZonePublicAccountMsgListRequest qZonePublicAccountMsgListRequest = new QZonePublicAccountMsgListRequest(isLoadMore ? this.mAttachInfo : null);
        qZonePublicAccountMsgListRequest.setEnableCache(enableCache);
        sendRequest(qZonePublicAccountMsgListRequest, new b(isLoadMore));
    }

    public final MutableLiveData<QZoneOfficialAccountBase$BottomMenu> Q1() {
        return this.mMsgListBottomMenuData;
    }

    public final MutableLiveData<UIStateData<List<mm.a>>> R1() {
        return this.mMsgListData;
    }

    protected final void a2(final UIStateData<List<mm.a>> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.publicaccount.e
            @Override // java.lang.Runnable
            public final void run() {
                g.b2(g.this, data);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZonePublicAcntListViewModel";
    }

    public final void refresh() {
        d2(false, false);
    }

    private final List<mm.a> P1(List<mm.a> dataList) {
        String str;
        if (dataList != null && !dataList.isEmpty()) {
            RFWLog.i("QZonePublicAcntListViewModel", RFWLog.USR, "befor filter adv, msg list size is " + dataList.size());
            Iterator<mm.a> it = dataList.iterator();
            while (it.hasNext()) {
                mm.a next = it.next();
                if (next.e() == 1) {
                    int i3 = RFWLog.USR;
                    if (next.a() == null) {
                        str = "";
                    } else {
                        str = (String) next.a().first;
                    }
                    RFWLog.i("QZonePublicAcntListViewModel", i3, "remove adv has been exposed, ad id is " + str);
                    it.remove();
                }
            }
            RFWLog.i("QZonePublicAcntListViewModel", RFWLog.USR, "after filter adv, msg list size is " + dataList.size());
        }
        return dataList;
    }

    private final boolean X1(QZoneOfficialAccount$GetMessageListRsp rsp) {
        PBBoolField pBBoolField;
        if (rsp == null || (pBBoolField = rsp.is_finish) == null) {
            return true;
        }
        return pBBoolField.get();
    }

    private final List<mm.a> c2(List<mm.a> msgList, boolean isCache) {
        return (msgList == null || msgList.isEmpty()) ? msgList : (isCache || StudyModeManager.t()) ? P1(msgList) : msgList;
    }

    public final void S1(mm.a messageData) {
        if (messageData == null) {
            RFWLog.e("QZonePublicAcntListViewModel", RFWLog.USR, "message data is null");
            return;
        }
        if (this.mMessageListData.isEmpty()) {
            RFWLog.e("QZonePublicAcntListViewModel", RFWLog.USR, "message list data is null");
            return;
        }
        if (!this.mMessageListData.remove(messageData)) {
            RFWLog.e("QZonePublicAcntListViewModel", RFWLog.USR, "not find third adv");
            return;
        }
        RFWLog.i("QZonePublicAcntListViewModel", RFWLog.USR, "user close ad, ad id is " + messageData.a().first);
        UIStateData<List<mm.a>> data = UIStateData.obtainDelete().setFinish(this.mIsFinish).setData(false, this.mMessageListData);
        Intrinsics.checkNotNullExpressionValue(data, "obtainDelete<List<QZoneP\u2026(false, mMessageListData)");
        a2(data);
    }

    public final void init() {
        d2(false, true);
    }

    public final void loadMore() {
        d2(true, false);
    }

    private final void W1(QZoneOfficialAccount$GetMessageListRsp rsp) {
        if (rsp == null) {
            return;
        }
        this.mAttachInfo = rsp.attach_info.get();
    }
}
