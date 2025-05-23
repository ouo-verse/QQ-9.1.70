package com.qzone.reborn.feedpro.viewmodel;

import android.content.Intent;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.covercomponent.env.CoverEnv;
import com.qzone.reborn.feedx.util.ah;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.consts.QzoneDataUpdateAction;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.IQzoneFeedUpdateCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneFriendFeedManager;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetFriendFeedPageHeadRsp;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\b\t*\u00011\u0018\u0000 72\u00020\u0001:\u00018B\u0007\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\t\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u001e\u0010\f\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\u0007H\u0016J\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0002J\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012J\u0010\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u0006\u0010\u0018\u001a\u00020\u0002J\u001e\u0010\u001c\u001a\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0002H\u0016R(\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010-\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00069"}, d2 = {"Lcom/qzone/reborn/feedpro/viewmodel/p;", "Lcom/qzone/reborn/feedpro/viewmodel/c;", "", SemanticAttributes.DbSystemValues.H2, "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedsData", "", "action", "g2", "f2", "data", "c2", "getLogTag", "", ICustomDataEditor.NUMBER_PARAM_2, ICustomDataEditor.STRING_ARRAY_PARAM_2, "d2", "", "time", "j2", "Landroid/content/Intent;", "intent", "m2", "Z1", "feedList", "", "loadType", "e2", "R1", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetFriendFeedPageHeadRsp;", "D", "Landroidx/lifecycle/MutableLiveData;", "b2", "()Landroidx/lifecycle/MutableLiveData;", "setHeadInfo", "(Landroidx/lifecycle/MutableLiveData;)V", "headInfo", "E", "Z", "getNeedRefresh", "()Z", "l2", "(Z)V", "needRefresh", UserInfo.SEX_FEMALE, "J", "mRefreshStartTime", "com/qzone/reborn/feedpro/viewmodel/p$c", "G", "Lcom/qzone/reborn/feedpro/viewmodel/p$c;", "feedUpdateCallback", "<init>", "()V", "H", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class p extends com.qzone.reborn.feedpro.viewmodel.c {

    /* renamed from: H, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static int I;
    public static int J;
    public static long K;

    /* renamed from: D, reason: from kotlin metadata */
    private MutableLiveData<GetFriendFeedPageHeadRsp> headInfo = new MutableLiveData<>();

    /* renamed from: E, reason: from kotlin metadata */
    private boolean needRefresh;

    /* renamed from: F, reason: from kotlin metadata */
    private long mRefreshStartTime;

    /* renamed from: G, reason: from kotlin metadata */
    private c feedUpdateCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/qzone/reborn/feedpro/viewmodel/p$a;", "", "", "b", "Lcom/tencent/biz/richframework/part/block/BlockContainer;", "blockContainer", "a", "", "FRIEND_FEED_ENTER_TIME", "Ljava/lang/String;", "TAG", "", "sFriendFeedEnterTime", "J", "", "sLastFeedIndex", "I", "sLastFeedOffset", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.feedpro.viewmodel.p$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        @JvmStatic
        public final void b() {
            p.I = 0;
            p.J = 0;
        }

        @JvmStatic
        public final void a(BlockContainer blockContainer) {
            NestScrollRecyclerView recyclerView;
            int abs;
            if (blockContainer == null || (recyclerView = blockContainer.getRecyclerView()) == null) {
                return;
            }
            Companion companion = p.INSTANCE;
            p.I = ah.a(recyclerView);
            View childAt = recyclerView.getChildAt(0);
            if (childAt != null) {
                abs = childAt.getTop();
            } else {
                abs = Math.abs(CoverEnv.getCoverFriendPaddingTop()) + 0;
            }
            p.J = abs;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J.\u0010\u000f\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u0010"}, d2 = {"com/qzone/reborn/feedpro/viewmodel/p$b", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "", "errorCode", "", "errorMsg", "", "onFailure", "t", "retCode", "msg", "", "isFinish", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements DataCallback<List<? extends CommonFeed>> {
        b() {
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(List<CommonFeed> t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(t16, "t");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            dh.d.f393812a.d();
            p.this.S1(com.qzone.reborn.feedpro.viewmodel.b.INSTANCE.d());
            p.this.l2(false);
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        public void onFailure(long errorCode, String errorMsg) {
            p.this.S1(com.qzone.reborn.feedpro.viewmodel.b.INSTANCE.d());
            p.this.N1().postValue(UIStateData.obtainError(errorMsg));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J&\u0010\f\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\r"}, d2 = {"com/qzone/reborn/feedpro/viewmodel/p$c", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/IQzoneFeedUpdateCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "commonFeed", "", "action", "", "index", "", "onDataUpdate", "", "list", "onListUpdate", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements IQzoneFeedUpdateCallback {
        c() {
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.IQzoneFeedUpdateCallback
        public void onDataUpdate(CommonFeed commonFeed, String action, int index) {
            Intrinsics.checkNotNullParameter(commonFeed, "commonFeed");
            Intrinsics.checkNotNullParameter(action, "action");
            p.this.P1(commonFeed, action, index);
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.IQzoneFeedUpdateCallback
        public void onListUpdate(List<CommonFeed> list, String action, int index) {
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(action, "action");
            p.this.c2(list, action);
            p.this.g2(list, action);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/feedpro/viewmodel/p$d", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetFriendFeedPageHeadRsp;", "headRsp", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class d implements DataCallback<GetFriendFeedPageHeadRsp> {
        d() {
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(GetFriendFeedPageHeadRsp headRsp, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(headRsp, "headRsp");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.d(p.this.getTAG(), 1, "fetch head info success");
            p.this.b2().postValue(headRsp);
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        public void onFailure(long errorCode, String errorMsg) {
            QLog.d(p.this.getTAG(), 1, "fetch head info error, errorCode: " + errorCode + ", errorMsg: " + errorMsg);
        }
    }

    public p() {
        c cVar = new c();
        this.feedUpdateCallback = cVar;
        QzoneFriendFeedManager.INSTANCE.registerFeedUpdateCallback(cVar, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c2(List<CommonFeed> data, String action) {
        UIStateData<List<CommonFeed>> value;
        List<CommonFeed> data2;
        switch (action.hashCode()) {
            case -1785516855:
                if (!action.equals(QzoneDataUpdateAction.UPDATE)) {
                    return;
                }
                e2(data, 1);
                return;
            case -89436402:
                if (action.equals(QzoneDataUpdateAction.LOAD_MORE)) {
                    e2(data, 2);
                    return;
                }
                return;
            case -44153180:
                if (!action.equals(QzoneDataUpdateAction.MEMORY_CACHE)) {
                    return;
                }
                break;
            case -26888640:
                if (!action.equals(QzoneDataUpdateAction.DISK_CACHE)) {
                    return;
                }
                break;
            case 1803427515:
                if (!action.equals("REFRESH")) {
                    return;
                }
                e2(data, 1);
                return;
            case 2012838315:
                if (!action.equals("DELETE")) {
                    return;
                }
                e2(data, 1);
                return;
            case 2078940443:
                if (!action.equals(QzoneDataUpdateAction.INSERT_FAKE)) {
                    return;
                }
                e2(data, 1);
                return;
            default:
                return;
        }
        MutableLiveData<UIStateData<List<CommonFeed>>> N1 = N1();
        if ((N1 == null || (value = N1.getValue()) == null || (data2 = value.getData()) == null) ? true : data2.isEmpty()) {
            e2(data, 1);
        }
    }

    private final void f2() {
        QzoneFriendFeedManager.INSTANCE.fetchFriendFeedHead(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g2(List<CommonFeed> feedsData, String action) {
        if (Intrinsics.areEqual(action, "REFRESH")) {
            long j3 = this.mRefreshStartTime;
            if (j3 > 0) {
                lg.g.f414459a.g(System.currentTimeMillis() - this.mRefreshStartTime, feedsData);
                this.mRefreshStartTime = 0L;
                return;
            }
            RFWLog.e("FriendFeedxViewModel", RFWLog.USR, "reportRefreshFinish error: " + j3);
        }
    }

    private final void h2() {
        this.mRefreshStartTime = System.currentTimeMillis();
        lg.g.f414459a.i();
    }

    @JvmStatic
    public static final void i2() {
        INSTANCE.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k2() {
        u5.c.I("friendfeedentertime", K, LoginData.getInstance().getUin());
    }

    @Override // com.qzone.reborn.feedpro.viewmodel.c
    public void R1() {
        c cVar = this.feedUpdateCallback;
        if (cVar != null) {
            QzoneFriendFeedManager.INSTANCE.unregisterFeedUpdateCallback(cVar);
        }
    }

    public final void Z1() {
        RFWLog.i("request_feedx", RFWLog.USR, "checkRefreshData");
        if (getNeedRefresh()) {
            a2();
        } else {
            RFWLog.i("request_feedx", RFWLog.USR, "do not need do refresh");
            f2();
        }
    }

    public final void a2() {
        List<CommonFeed> data;
        QLog.d(getTAG(), 1, "doRefresh");
        UIStateData<List<CommonFeed>> value = N1().getValue();
        if ((value == null || (data = value.getData()) == null || !data.isEmpty()) ? false : true) {
            QzoneFriendFeedManager.INSTANCE.loadCache();
        }
        S1(com.qzone.reborn.feedpro.viewmodel.b.INSTANCE.c());
        h2();
        QzoneFriendFeedManager.INSTANCE.refresh(new b());
        f2();
        INSTANCE.b();
    }

    public final MutableLiveData<GetFriendFeedPageHeadRsp> b2() {
        return this.headInfo;
    }

    public final void d2() {
        QzoneFriendFeedManager.loadMore$default(QzoneFriendFeedManager.INSTANCE, null, 1, null);
    }

    public void e2(List<CommonFeed> feedList, int loadType) {
        int i3;
        int i16;
        List<CommonFeed> data;
        Intrinsics.checkNotNullParameter(feedList, "feedList");
        QLog.d(getTAG(), 1, "onFeedDataChange, feedList: " + feedList.size());
        boolean z16 = loadType == 2;
        boolean isListFinish = QzoneFriendFeedManager.INSTANCE.isListFinish();
        int size = feedList.size();
        if (z16) {
            UIStateData<List<CommonFeed>> value = N1().getValue();
            i16 = (value == null || (data = value.getData()) == null) ? 0 : data.size();
            i3 = RangesKt___RangesKt.coerceAtLeast(feedList.size() - i16, 0);
        } else {
            i3 = size;
            i16 = 0;
        }
        QLog.d(getTAG(), 1, "lastModifyRecord, startPosition: " + i16 + ", pageCount: " + i3);
        UIStateData.ModifyListRecord obtainNotifyItemRangeInsert = UIStateData.ModifyListRecord.obtainNotifyItemRangeInsert(i16, i3);
        UIStateData<List<CommonFeed>> obtainSuccess = UIStateData.obtainSuccess(false);
        obtainSuccess.setData(z16, feedList);
        obtainSuccess.setFinish(isListFinish);
        obtainSuccess.setLatestModifyRecord(obtainNotifyItemRangeInsert);
        N1().postValue(obtainSuccess);
        com.qzone.reborn.feedpro.utils.e.f54320a.a(feedList);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QzoneFriendFeedProViewModel";
    }

    public final void j2(long time) {
        K = time;
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.reborn.feedpro.viewmodel.o
            @Override // java.lang.Runnable
            public final void run() {
                p.k2();
            }
        });
    }

    public final void l2(boolean z16) {
        this.needRefresh = z16;
    }

    /* renamed from: n2, reason: from getter */
    public final boolean getNeedRefresh() {
        return this.needRefresh;
    }

    public final void m2(Intent intent) {
        boolean z16 = true;
        if (!(intent != null && intent.getBooleanExtra("force_refresh", false))) {
            if (!(intent != null && intent.getBooleanExtra(QCircleScheme.AttrDetail.HAS_RED_DOT, false))) {
                z16 = false;
            }
        }
        this.needRefresh = lg.g.f414459a.q(z16);
    }
}
