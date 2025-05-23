package hl;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import bl.CommonNoticeBean;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.reborn.base.n;
import com.qzone.reborn.configx.g;
import com.qzone.reborn.message.data.QZonePassiveMessageFeedPreprocessor;
import com.qzone.reborn.util.o;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0093\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t*\u00018\b\u0016\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001JB\u0007\u00a2\u0006\u0004\bH\u0010IJ6\u0010\u000e\u001a\u00020\r2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0006H\u0002J$\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\"\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\rH\u0002J\u001e\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00162\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u0012\u0010\u0019\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u0010\u001d\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u001a\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00030\u001f0\u001eH\u0016J\b\u0010!\u001a\u00020\rH\u0016J\b\u0010\"\u001a\u00020\rH\u0016J\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J$\u0010'\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00042\u0014\u0010&\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\r0%J\u0018\u0010*\u001a\u00020\r2\u0006\u0010)\u001a\u00020(2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004J\u0006\u0010+\u001a\u00020\rJ\u0006\u0010,\u001a\u00020\rJ\u001e\u00100\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00042\u000e\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010.0-R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00107\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u001d\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00040<8\u0006\u00a2\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R,\u0010G\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00030\u001f0B8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\u00a8\u0006K"}, d2 = {"Lhl/d;", "Lcom/qzone/reborn/base/n;", "Lcom/qzone/reborn/message/common/e;", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedList", "", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "", "retCode", "", "errMsg", "isFinish", "", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Lbl/a;", "R1", "errorCode", "errorMsg", "Z1", "e2", "feedData", "Lkotlin/Pair;", "", "U1", "X1", "getLogTag", "Landroid/content/Intent;", "intent", "c2", "Landroidx/lifecycle/LiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "v", UserInfo.SEX_FEMALE, "S0", "d2", "Q1", "Lkotlin/Function1;", "block", "f2", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "S1", "P1", "b2", "Lcom/qzone/reborn/base/n$a;", "", "dataCallback", "T1", "Lcom/qzone/reborn/message/repo/d;", "i", "Lcom/qzone/reborn/message/repo/d;", "mServerRepo", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "mFromNotify", "hl/d$d", BdhLogUtil.LogTag.Tag_Conn, "Lhl/d$d;", "mHandler", "", "D", "Ljava/util/List;", "W1", "()Ljava/util/List;", "mFeedsListData", "Landroidx/lifecycle/MutableLiveData;", "E", "Landroidx/lifecycle/MutableLiveData;", "getMNoticeListData", "()Landroidx/lifecycle/MutableLiveData;", "mNoticeListData", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public class d extends n implements com.qzone.reborn.message.common.e {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mFromNotify;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.message.repo.d mServerRepo = new com.qzone.reborn.message.repo.d();

    /* renamed from: C, reason: from kotlin metadata */
    private final HandlerC10449d mHandler = new HandlerC10449d(Looper.getMainLooper());

    /* renamed from: D, reason: from kotlin metadata */
    private final List<BusinessFeedData> mFeedsListData = new ArrayList();

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableLiveData<UIStateData<List<CommonNoticeBean>>> mNoticeListData = new MutableLiveData<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"hl/d$b", "Lcom/qzone/reborn/base/n$a;", "", "t", "", "retCode", "", "msg", "", "isFinish", "", "onSuccess", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements n.a<Object> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f405233b;

        b(BusinessFeedData businessFeedData) {
            this.f405233b = businessFeedData;
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            o.f59556a.c(R.string.f169558w92, 4);
        }

        @Override // com.qzone.reborn.base.n.a
        public void onSuccess(Object t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            d.this.X1(this.f405233b);
            o.f59556a.c(R.string.f169559w93, 5);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J.\u0010\f\u001a\u00020\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u001a\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u0010"}, d2 = {"hl/d$c", "Lcom/qzone/reborn/base/n$a;", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedList", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class c implements n.a<List<? extends BusinessFeedData>> {
        c() {
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(List<? extends BusinessFeedData> feedList, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(feedList, "feedList");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            d.this.a2(feedList, true, retCode, msg2, isFinish);
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            d.this.Z1(errorCode, errorMsg, true);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"hl/d$d", "Landroid/os/Handler;", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: hl.d$d, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class HandlerC10449d extends Handler {
        HandlerC10449d(Looper looper) {
            super(looper);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J.\u0010\f\u001a\u00020\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u001a\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u0010"}, d2 = {"hl/d$e", "Lcom/qzone/reborn/base/n$a;", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedList", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class e implements n.a<List<? extends BusinessFeedData>> {
        e() {
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(List<? extends BusinessFeedData> feedList, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(feedList, "feedList");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            dh.d.f393812a.e();
            d.this.a2(feedList, false, retCode, msg2, isFinish);
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            d.this.Z1(errorCode, errorMsg, false);
        }
    }

    private final List<CommonNoticeBean> R1(List<? extends BusinessFeedData> feedList, boolean isLoadMore) {
        UIStateData<List<CommonNoticeBean>> value = this.mNoticeListData.getValue();
        List<CommonNoticeBean> data = value != null ? value.getData() : null;
        if (data == null) {
            data = new ArrayList<>();
        }
        ArrayList arrayList = new ArrayList();
        if (isLoadMore) {
            arrayList.addAll(data);
        }
        arrayList.addAll(Q1(feedList));
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004c, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r6, r7) != false) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Pair<Integer, BusinessFeedData> U1(BusinessFeedData feedData) {
        Iterator<BusinessFeedData> it = this.mFeedsListData.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                return null;
            }
            int i16 = i3 + 1;
            BusinessFeedData next = it.next();
            if (feedData == next) {
                return new Pair<>(Integer.valueOf(i3), next);
            }
            String a16 = ef.b.a(feedData);
            String a17 = ef.b.a(next);
            boolean z16 = true;
            if (!(a16 == null || a16.length() == 0)) {
                if (!(a17 == null || a17.length() == 0)) {
                }
            }
            z16 = false;
            CellFeedCommInfo cellFeedCommInfo = feedData.cellFeedCommInfo;
            Long valueOf = cellFeedCommInfo != null ? Long.valueOf(cellFeedCommInfo.time) : null;
            CellFeedCommInfo cellFeedCommInfo2 = next.cellFeedCommInfo;
            boolean areEqual = Intrinsics.areEqual(valueOf, cellFeedCommInfo2 != null ? Long.valueOf(cellFeedCommInfo2.time) : null);
            if (z16 && areEqual) {
                return new Pair<>(Integer.valueOf(i3), next);
            }
            i3 = i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X1(BusinessFeedData feedData) {
        TypeIntrinsics.asMutableCollection(this.mFeedsListData).remove(feedData);
        e2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z1(long errorCode, String errorMsg, boolean isLoadMore) {
        this.mNoticeListData.postValue(UIStateData.obtainError(errorMsg).setRetCode(errorCode).setLoadMore(isLoadMore));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a2(List<? extends BusinessFeedData> feedList, boolean isLoadMore, long retCode, String errMsg, boolean isFinish) {
        UIStateData.ModifyListRecord obtainNotifyDataSetChanged;
        List<CommonNoticeBean> data;
        List<BusinessFeedData> d26 = d2(feedList);
        if (!isLoadMore) {
            this.mFeedsListData.clear();
        }
        this.mFeedsListData.addAll(d26);
        List<CommonNoticeBean> R1 = R1(d26, isLoadMore);
        if (bl.b(R1)) {
            this.mNoticeListData.postValue(UIStateData.obtainEmpty().setRetCode(retCode).setLoadMore(isLoadMore));
            return;
        }
        UIStateData<List<CommonNoticeBean>> value = this.mNoticeListData.getValue();
        int size = (value == null || (data = value.getData()) == null) ? 0 : data.size();
        if (isLoadMore) {
            obtainNotifyDataSetChanged = UIStateData.ModifyListRecord.obtainNotifyItemRangeInsert(size, R1.size());
        } else {
            obtainNotifyDataSetChanged = UIStateData.ModifyListRecord.obtainNotifyDataSetChanged();
        }
        this.mNoticeListData.postValue(UIStateData.obtainSuccess(VSNetworkHelper.isProtocolCache(errMsg)).setData(isLoadMore, R1).setLatestModifyRecord(obtainNotifyDataSetChanged).setFinish(isFinish));
    }

    private final void e2() {
        RFWLog.d(getTAG(), RFWLog.USR, "[refreshDataFromLocal]");
        UIStateData<List<CommonNoticeBean>> value = this.mNoticeListData.getValue();
        if (value != null) {
            if (!this.mFeedsListData.isEmpty()) {
                if (value.getState() == 0) {
                    RFWLog.d(getTAG(), RFWLog.USR, "[refreshDataFromLocal] set to succeed");
                    value.setState(2);
                } else {
                    RFWLog.d(getTAG(), RFWLog.USR, "[refreshDataFromLocal] set to modify");
                    value.setState(7);
                }
            } else {
                RFWLog.d(getTAG(), RFWLog.USR, "[refreshDataFromLocal] set to empty");
                value.setState(0);
            }
            value.setDataList(Q1(this.mFeedsListData));
        }
        this.mNoticeListData.postValue(value);
    }

    @Override // com.qzone.reborn.message.common.e
    public void F() {
        this.mServerRepo.j(this.mFromNotify, new c());
    }

    public final void P1() {
        QZoneWriteOperationService.v0().P(this.mHandler, 1L);
    }

    public List<CommonNoticeBean> Q1(List<? extends BusinessFeedData> feedList) {
        Intrinsics.checkNotNullParameter(feedList, "feedList");
        return com.qzone.reborn.message.data.d.f58259a.a(feedList);
    }

    @Override // com.qzone.reborn.message.common.e
    public void S0() {
        this.mServerRepo.k(this.mFromNotify, new e());
    }

    public final void S1(Activity activity, BusinessFeedData feedData) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (feedData == null) {
            RFWLog.e("QZonePassiveMessageViewModel", RFWLog.USR, "[deletePassiveFeed] feedData is null");
        } else if (!NetworkUtil.isNetSupport(activity)) {
            o.f59556a.b(g.f53821a.m().k());
        } else {
            this.mServerRepo.d(feedData, new b(feedData));
        }
    }

    public final void T1(BusinessFeedData feedData, n.a<Object> dataCallback) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        this.mServerRepo.h(feedData, dataCallback);
    }

    public final List<BusinessFeedData> W1() {
        return this.mFeedsListData;
    }

    public final void b2() {
        QZoneWriteOperationService.v0().P(this.mHandler, 0L);
    }

    public List<BusinessFeedData> d2(List<? extends BusinessFeedData> feedList) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(feedList, "feedList");
        List<? extends BusinessFeedData> list = feedList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(QZonePassiveMessageFeedPreprocessor.f58250a.o((BusinessFeedData) it.next()));
        }
        return arrayList;
    }

    public final void f2(BusinessFeedData feedData, Function1<? super BusinessFeedData, Unit> block) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        Intrinsics.checkNotNullParameter(block, "block");
        Pair<Integer, BusinessFeedData> U1 = U1(feedData);
        block.invoke(U1 != null ? U1.getSecond() : null);
        if ((U1 != null ? U1.getSecond() : null) == null) {
            RFWLog.e(getTAG(), RFWLog.USR, "[updateSpecificFeedData] can not find target feedData");
        } else {
            this.mFeedsListData.set(U1.component1().intValue(), U1.component2());
            e2();
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZonePassiveMessageViewModel";
    }

    @Override // com.qzone.reborn.message.common.e
    public LiveData<UIStateData<List<CommonNoticeBean>>> v() {
        return this.mNoticeListData;
    }

    public final void c2(Intent intent) {
        Boolean valueOf = intent != null ? Boolean.valueOf(intent.getBooleanExtra("FromNotification", false)) : null;
        this.mFromNotify = valueOf != null ? valueOf.booleanValue() : false;
    }
}
