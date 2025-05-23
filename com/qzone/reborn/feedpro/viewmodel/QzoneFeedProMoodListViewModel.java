package com.qzone.reborn.feedpro.viewmodel;

import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.account.LoginData;
import com.qzone.common.event.EventCenter;
import com.qzone.reborn.route.QZoneMoodListInitBean;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.consts.QzoneDataUpdateAction;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.QzoneMoodListInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.IQzoneFeedUpdateCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneMoodListManager;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.SealOffMemory;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\b*\u0001>\u0018\u0000 &2\u00020\u0001:\u0001DB\u0007\u00a2\u0006\u0004\bB\u0010CJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\u000b\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u001e\u0010\u000e\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\tH\u0016J\u001a\u0010\u0014\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0017\u001a\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\u0015J\b\u0010\u001b\u001a\u00020\u0004H\u0014R$\u0010#\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010+\u001a\u00020$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u00102\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u001d\u0010=\u001a\b\u0012\u0004\u0012\u000208078\u0006\u00a2\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@\u00a8\u0006E"}, d2 = {"Lcom/qzone/reborn/feedpro/viewmodel/QzoneFeedProMoodListViewModel;", "Lcom/qzone/reborn/feedpro/viewmodel/c;", "", "shuoshuoCount", "", "i2", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "data", "", "action", "b2", "feedList", "loadType", "f2", "getLogTag", "Landroid/content/Intent;", "intent", "Landroid/os/Bundle;", "savedInstance", "g2", "", "d2", "X1", SemanticAttributes.DbSystemValues.H2, "e2", "c2", "onCleared", "Lcom/qzone/reborn/route/QZoneMoodListInitBean;", "D", "Lcom/qzone/reborn/route/QZoneMoodListInitBean;", "getInitBean", "()Lcom/qzone/reborn/route/QZoneMoodListInitBean;", "setInitBean", "(Lcom/qzone/reborn/route/QZoneMoodListInitBean;)V", "initBean", "", "E", "J", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()J", "setMUin", "(J)V", "mUin", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "getMNickName", "()Ljava/lang/String;", "setMNickName", "(Ljava/lang/String;)V", "mNickName", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneMoodListManager;", "G", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneMoodListManager;", "feedManager", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/SealOffMemory;", "H", "Landroidx/lifecycle/MutableLiveData;", "Z1", "()Landroidx/lifecycle/MutableLiveData;", "mSealOffMemory", "com/qzone/reborn/feedpro/viewmodel/QzoneFeedProMoodListViewModel$b", "I", "Lcom/qzone/reborn/feedpro/viewmodel/QzoneFeedProMoodListViewModel$b;", "feedUpdateCallback", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProMoodListViewModel extends com.qzone.reborn.feedpro.viewmodel.c {

    /* renamed from: D, reason: from kotlin metadata */
    private QZoneMoodListInitBean initBean;

    /* renamed from: E, reason: from kotlin metadata */
    private long mUin;

    /* renamed from: F, reason: from kotlin metadata */
    private String mNickName;

    /* renamed from: G, reason: from kotlin metadata */
    private QzoneMoodListManager feedManager;

    /* renamed from: H, reason: from kotlin metadata */
    private final MutableLiveData<SealOffMemory> mSealOffMemory = new MutableLiveData<>();

    /* renamed from: I, reason: from kotlin metadata */
    private b feedUpdateCallback = new b();

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J&\u0010\f\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\r"}, d2 = {"com/qzone/reborn/feedpro/viewmodel/QzoneFeedProMoodListViewModel$b", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/IQzoneFeedUpdateCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "commonFeed", "", "action", "", "index", "", "onDataUpdate", "", "list", "onListUpdate", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements IQzoneFeedUpdateCallback {
        b() {
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.IQzoneFeedUpdateCallback
        public void onDataUpdate(CommonFeed commonFeed, String action, int index) {
            Intrinsics.checkNotNullParameter(commonFeed, "commonFeed");
            Intrinsics.checkNotNullParameter(action, "action");
            QzoneFeedProMoodListViewModel.this.P1(commonFeed, action, index);
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.IQzoneFeedUpdateCallback
        public void onListUpdate(List<CommonFeed> list, String action, int index) {
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(action, "action");
            QzoneFeedProMoodListViewModel.this.b2(list, action);
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/feedpro/viewmodel/QzoneFeedProMoodListViewModel$c", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/QzoneMoodListInfo;", "", "errorCode", "", "errorMsg", "", "onFailure", "t", "retCode", "msg", "", "isFinish", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements DataCallback<QzoneMoodListInfo> {
        c() {
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(QzoneMoodListInfo t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(t16, "t");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QzoneFeedProMoodListViewModel.this.S1(com.qzone.reborn.feedpro.viewmodel.b.INSTANCE.d());
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        public void onFailure(long errorCode, String errorMsg) {
            QzoneFeedProMoodListViewModel.this.S1(com.qzone.reborn.feedpro.viewmodel.b.INSTANCE.d());
            QzoneFeedProMoodListViewModel.this.N1().postValue(UIStateData.obtainError(errorMsg));
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/feedpro/viewmodel/QzoneFeedProMoodListViewModel$d", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/QzoneMoodListInfo;", "", "errorCode", "", "errorMsg", "", "onFailure", "t", "retCode", "msg", "", "isFinish", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class d implements DataCallback<QzoneMoodListInfo> {
        d() {
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(QzoneMoodListInfo t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(t16, "t");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QzoneFeedProMoodListViewModel.this.Z1().postValue(t16.getSealOffMemory());
            QzoneFeedProMoodListViewModel.this.S1(com.qzone.reborn.feedpro.viewmodel.b.INSTANCE.d());
            QzoneFeedProMoodListViewModel.this.i2(t16.getShuoshuoTimerUnpublishedCount());
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        public void onFailure(long errorCode, String errorMsg) {
            QzoneFeedProMoodListViewModel.this.S1(com.qzone.reborn.feedpro.viewmodel.b.INSTANCE.d());
            QzoneFeedProMoodListViewModel.this.N1().postValue(UIStateData.obtainError(errorMsg));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0004. Please report as an issue. */
    public final void b2(List<CommonFeed> data, String action) {
        switch (action.hashCode()) {
            case -1785516855:
                if (!action.equals(QzoneDataUpdateAction.UPDATE)) {
                    return;
                }
                f2(data, 1);
                return;
            case -89436402:
                if (action.equals(QzoneDataUpdateAction.LOAD_MORE)) {
                    f2(data, 2);
                    return;
                }
                return;
            case -44153180:
                if (!action.equals(QzoneDataUpdateAction.MEMORY_CACHE)) {
                    return;
                }
                f2(data, 1);
                return;
            case 1803427515:
                if (!action.equals("REFRESH")) {
                    return;
                }
                f2(data, 1);
                return;
            case 2012838315:
                if (!action.equals("DELETE")) {
                    return;
                }
                f2(data, 1);
                return;
            case 2078940443:
                if (!action.equals(QzoneDataUpdateAction.INSERT_FAKE)) {
                    return;
                }
                f2(data, 1);
                return;
            default:
                return;
        }
    }

    private final void f2(List<CommonFeed> feedList, int loadType) {
        int i3;
        int i16;
        List<CommonFeed> data;
        QLog.i(getTAG(), 1, "onFeedDataChange, feedList: " + feedList.size());
        boolean z16 = loadType == 2;
        QzoneMoodListManager qzoneMoodListManager = this.feedManager;
        boolean z17 = qzoneMoodListManager != null && qzoneMoodListManager.getIsListFinish();
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
        obtainSuccess.setFinish(z17);
        obtainSuccess.setLatestModifyRecord(obtainNotifyItemRangeInsert);
        N1().postValue(obtainSuccess);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i2(int shuoshuoCount) {
        EventCenter.getInstance().post("TimerShuoShuo", 1, Integer.valueOf(shuoshuoCount));
    }

    public final MutableLiveData<SealOffMemory> Z1() {
        return this.mSealOffMemory;
    }

    /* renamed from: a2, reason: from getter */
    public final long getMUin() {
        return this.mUin;
    }

    public final boolean c2() {
        List<CommonFeed> data;
        UIStateData<List<CommonFeed>> value = N1().getValue();
        return (value == null || (data = value.getData()) == null || !(data.isEmpty() ^ true)) ? false : true;
    }

    public final boolean d2() {
        return this.mUin == LoginData.getInstance().getUin();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x006d, code lost:
    
        if (r3 != false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g2(Intent intent, Bundle savedInstance) {
        QzoneMoodListManager qzoneMoodListManager;
        if (savedInstance != null && savedInstance.containsKey("key_uin")) {
            this.mUin = savedInstance.getLong("key_uin");
            this.mNickName = savedInstance.getString("key_nickname");
            this.initBean = (QZoneMoodListInitBean) savedInstance.getParcelable("qzone_route_bean");
            if (this.mUin <= 0) {
                this.mUin = LoginData.getInstance().getUin();
            }
        }
        if (intent == null) {
            return;
        }
        if (this.mUin == 0) {
            this.mUin = intent.getLongExtra("key_uin", LoginData.getInstance().getUin());
        }
        if (this.mUin <= 0) {
            this.mUin = LoginData.getInstance().getUin();
        }
        String str = this.mNickName;
        if (str != null) {
            boolean z16 = false;
            if (str != null && str.length() == 0) {
                z16 = true;
            }
        }
        this.mNickName = intent.getStringExtra("key_nickname");
        this.initBean = (QZoneMoodListInitBean) intent.getParcelableExtra("qzone_route_bean");
        this.feedManager = new QzoneMoodListManager(String.valueOf(this.mUin));
        if (this.mUin == LoginData.getInstance().getUin() && (qzoneMoodListManager = this.feedManager) != null) {
            qzoneMoodListManager.loadCache();
        }
        QzoneMoodListManager qzoneMoodListManager2 = this.feedManager;
        Intrinsics.checkNotNull(qzoneMoodListManager2);
        qzoneMoodListManager2.registerFeedUpdateCallback(this.feedUpdateCallback, true);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QzoneFeedProMoodListViewModel";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        QzoneMoodListManager qzoneMoodListManager = this.feedManager;
        if (qzoneMoodListManager != null) {
            qzoneMoodListManager.clear();
        }
        QzoneMoodListManager qzoneMoodListManager2 = this.feedManager;
        if (qzoneMoodListManager2 != null) {
            qzoneMoodListManager2.unregisterFeedUpdateCallback(this.feedUpdateCallback);
        }
    }

    public final void X1() {
        QLog.i("QzoneFeedProMoodListViewModel", 1, "doRefresh");
        h2();
    }

    public final void e2() {
        QLog.i("QzoneFeedProMoodListViewModel", 1, "loadMoreFeeds");
        QzoneMoodListManager qzoneMoodListManager = this.feedManager;
        if (qzoneMoodListManager != null) {
            qzoneMoodListManager.loadMore(new c());
        }
    }

    public final void h2() {
        QLog.i("QzoneFeedProMoodListViewModel", 1, "requestFeeds");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new QzoneFeedProMoodListViewModel$requestFeeds$1(this, null), 3, null);
        QzoneMoodListManager qzoneMoodListManager = this.feedManager;
        if (qzoneMoodListManager != null) {
            qzoneMoodListManager.refresh(new d());
        }
    }
}
