package com.tencent.mobileqq.zplan.aigc.vm;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.aigc.data.AIGCFeedItemInfo2;
import com.tencent.mobileqq.zplan.aigc.data.FeedListCache;
import com.tencent.mobileqq.zplan.aigc.data.LikeData;
import com.tencent.mobileqq.zplan.aigc.data.PromoteItemInfo;
import com.tencent.mobileqq.zplan.aigc.utils.AIGCHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u001b\u0018\u0000 B2\u00020\u0001:\u0003CDEB\u0007\u00a2\u0006\u0004\b@\u0010AJ-\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eJ\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0010\u0010\u0014\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0005J\u000e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018J\u0018\u0010 \u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eR \u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R#\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070%8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020+0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010#R\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020+0%8\u0006\u00a2\u0006\f\n\u0004\b.\u0010'\u001a\u0004\b/\u0010)R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010#R\u001d\u00105\u001a\b\u0012\u0004\u0012\u00020\u00020%8\u0006\u00a2\u0006\f\n\u0004\b3\u0010'\u001a\u0004\b4\u0010)R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\u00160!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u0010#R\u001d\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00160%8\u0006\u00a2\u0006\f\n\u0004\b8\u0010'\u001a\u0004\b9\u0010)R\u0018\u0010=\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010;\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/vm/SuitFeedViewModel;", "Landroidx/lifecycle/ViewModel;", "", "hasActivity", "", "Liu4/b;", "feedInfos", "", "Lcom/tencent/mobileqq/zplan/aigc/data/b;", "e2", "(Z[Liu4/b;)Ljava/util/List;", "b2", "", "g2", "Landroid/content/Context;", "context", "U1", "X1", "Lcom/tencent/mobileqq/zplan/aigc/vm/SuitFeedViewModel$b;", "channelInfoCallback", "T1", "feed", "", "c2", "Liu4/a;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/zplan/aigc/data/n;", "d2", "Lcom/tencent/mobileqq/zplan/aigc/data/c;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/zplan/aigc/vm/SuitFeedViewModel$c;", "callback", "f2", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "_dataList2", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "Z1", "()Landroidx/lifecycle/LiveData;", "dataList2", "", BdhLogUtil.LogTag.Tag_Conn, "_currentETag", "D", "W1", "currentETag", "E", "_finishFlag", UserInfo.SEX_FEMALE, "getFinishFlag", "finishFlag", "G", "_fetchStatus", "H", ICustomDataEditor.STRING_ARRAY_PARAM_2, "fetchStatus", "I", "Ljava/lang/String;", "channelSig", "J", "currentPage", "<init>", "()V", "K", "a", "b", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SuitFeedViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<String> _currentETag;

    /* renamed from: D, reason: from kotlin metadata */
    private final LiveData<String> currentETag;

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> _finishFlag;

    /* renamed from: F, reason: from kotlin metadata */
    private final LiveData<Boolean> finishFlag;

    /* renamed from: G, reason: from kotlin metadata */
    private final MutableLiveData<Integer> _fetchStatus;

    /* renamed from: H, reason: from kotlin metadata */
    private final LiveData<Integer> fetchStatus;

    /* renamed from: I, reason: from kotlin metadata */
    private String channelSig;

    /* renamed from: J, reason: from kotlin metadata */
    private int currentPage;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<List<com.tencent.mobileqq.zplan.aigc.data.b>> _dataList2;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final LiveData<List<com.tencent.mobileqq.zplan.aigc.data.b>> dataList2;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/vm/SuitFeedViewModel$b;", "", "", PreloadTRTCPlayerParams.KEY_SIG, "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface b {
        void a(String sig);
    }

    public SuitFeedViewModel() {
        MutableLiveData<List<com.tencent.mobileqq.zplan.aigc.data.b>> mutableLiveData = new MutableLiveData<>();
        this._dataList2 = mutableLiveData;
        this.dataList2 = mutableLiveData;
        MutableLiveData<String> mutableLiveData2 = new MutableLiveData<>();
        this._currentETag = mutableLiveData2;
        this.currentETag = mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>();
        this._finishFlag = mutableLiveData3;
        this.finishFlag = mutableLiveData3;
        MutableLiveData<Integer> mutableLiveData4 = new MutableLiveData<>();
        this._fetchStatus = mutableLiveData4;
        this.fetchStatus = mutableLiveData4;
        this.currentPage = 1;
    }

    public final void T1(b channelInfoCallback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SuitFeedViewModel$fetchChannelSig$1(channelInfoCallback, this, null), 3, null);
    }

    public final void U1(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Integer value = this._fetchStatus.getValue();
        if (value != null && value.intValue() == 2) {
            return;
        }
        if (!NetworkUtil.isNetSupport(context)) {
            QLog.d("SuitFeedViewModel", 2, "network errror");
            this._fetchStatus.postValue(3);
            return;
        }
        this._fetchStatus.postValue(1);
        String value2 = this.currentETag.getValue();
        Intrinsics.checkNotNull(value2);
        QLog.d("SuitFeedViewModel", 2, "fetchData2 currentEtag: " + ((Object) value2));
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SuitFeedViewModel$fetchData2$1(this, null), 3, null);
    }

    public final LiveData<String> W1() {
        return this.currentETag;
    }

    public final List<com.tencent.mobileqq.zplan.aigc.data.b> X1() {
        List<com.tencent.mobileqq.zplan.aigc.data.b> value = this._dataList2.getValue();
        if (value == null) {
            value = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (com.tencent.mobileqq.zplan.aigc.data.b bVar : value) {
            if (bVar.getType() != be3.a.INSTANCE.j()) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public final LiveData<List<com.tencent.mobileqq.zplan.aigc.data.b>> Z1() {
        return this.dataList2;
    }

    public final LiveData<Integer> a2() {
        return this.fetchStatus;
    }

    public final List<com.tencent.mobileqq.zplan.aigc.data.b> b2() {
        List<com.tencent.mobileqq.zplan.aigc.data.b> listOf;
        List<com.tencent.mobileqq.zplan.aigc.data.b> listOf2;
        FeedListCache s16 = AIGCHelper.f330685a.s();
        if (s16 != null && s16.b() != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList<com.tencent.mobileqq.zplan.aigc.data.b> b16 = s16.b();
            Intrinsics.checkNotNull(b16);
            arrayList.addAll(b16);
            this._fetchStatus.setValue(0);
            this._dataList2.setValue(arrayList);
            this._currentETag.setValue(s16.getETag());
            return arrayList;
        }
        com.tencent.mobileqq.zplan.aigc.data.b bVar = new com.tencent.mobileqq.zplan.aigc.data.b(0, null, 3, null);
        bVar.c(be3.a.INSTANCE.f());
        this._fetchStatus.setValue(1);
        MutableLiveData<List<com.tencent.mobileqq.zplan.aigc.data.b>> mutableLiveData = this._dataList2;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(bVar);
        mutableLiveData.setValue(listOf);
        this._currentETag.setValue("");
        listOf2 = CollectionsKt__CollectionsJVMKt.listOf(bVar);
        return listOf2;
    }

    public final int c2(iu4.b feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        if (feed.f408764c == 301019001) {
            return be3.a.INSTANCE.h();
        }
        return be3.a.INSTANCE.g();
    }

    public final PromoteItemInfo d2(iu4.a activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        PromoteItemInfo promoteItemInfo = new PromoteItemInfo(null, null, null, null, null, null, 63, null);
        promoteItemInfo.c(be3.a.INSTANCE.i());
        if (!TextUtils.isEmpty(activity.f408760b)) {
            JSONObject jSONObject = new JSONObject(activity.f408760b);
            String str = activity.f408759a;
            Intrinsics.checkNotNullExpressionValue(str, "activity.name");
            promoteItemInfo.k(str);
            String string = jSONObject.getString("title");
            Intrinsics.checkNotNullExpressionValue(string, "promoteJson.getString(\"title\")");
            promoteItemInfo.m(string);
            String string2 = jSONObject.getString("junp_url");
            Intrinsics.checkNotNullExpressionValue(string2, "promoteJson.getString(\"junp_url\")");
            promoteItemInfo.j(string2);
            String string3 = jSONObject.getString("subtitle");
            Intrinsics.checkNotNullExpressionValue(string3, "promoteJson.getString(\"subtitle\")");
            promoteItemInfo.l(string3);
            String string4 = jSONObject.getString("image_url");
            Intrinsics.checkNotNullExpressionValue(string4, "promoteJson.getString(\"image_url\")");
            promoteItemInfo.i(string4);
        }
        return promoteItemInfo;
    }

    public final void f2(AIGCFeedItemInfo2 item, c callback) {
        Intrinsics.checkNotNullParameter(item, "item");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SuitFeedViewModel$requestLikeClick$1(item, callback, null), 3, null);
    }

    public final void g2() {
        if (this._dataList2.getValue() == null || this.currentETag.getValue() == null) {
            return;
        }
        AIGCHelper aIGCHelper = AIGCHelper.f330685a;
        List<com.tencent.mobileqq.zplan.aigc.data.b> value = this._dataList2.getValue();
        Intrinsics.checkNotNull(value);
        String value2 = this.currentETag.getValue();
        Intrinsics.checkNotNull(value2);
        aIGCHelper.z(value, value2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r22v0 */
    /* JADX WARN: Type inference failed for: r22v1, types: [int] */
    /* JADX WARN: Type inference failed for: r22v3 */
    public final List<com.tencent.mobileqq.zplan.aigc.data.b> e2(boolean hasActivity, iu4.b[] feedInfos) {
        iu4.b[] bVarArr = feedInfos;
        ArrayList arrayList = new ArrayList();
        int length = bVarArr.length;
        boolean z16 = false;
        int i3 = hasActivity;
        int i16 = 0;
        while (i16 < length) {
            iu4.b bVar = bVarArr[i16];
            LikeData likeData = new LikeData(z16, 0L);
            iu4.i iVar = bVar.f408770i;
            if (iVar != null) {
                likeData = new LikeData(iVar.f408784a, iVar.f408785b);
            }
            long j3 = bVar.f408762a;
            String str = bVar.f408765d;
            Intrinsics.checkNotNullExpressionValue(str, "feed.name");
            String str2 = bVar.f408766e;
            Intrinsics.checkNotNullExpressionValue(str2, "feed.desc");
            String str3 = bVar.f408768g;
            Intrinsics.checkNotNullExpressionValue(str3, "feed.url");
            long j16 = bVar.f408769h;
            String str4 = bVar.f408772k;
            Intrinsics.checkNotNullExpressionValue(str4, "feed.authorName");
            String str5 = bVar.f408773l;
            int i17 = length;
            Intrinsics.checkNotNullExpressionValue(str5, "feed.authorHeadUrl");
            ArrayList arrayList2 = arrayList;
            int i18 = i16;
            AIGCFeedItemInfo2 aIGCFeedItemInfo2 = new AIGCFeedItemInfo2(i3, j3, str, str2, str3, j16, str4, str5, String.valueOf(bVar.f408771j), likeData, null, bVar.f408764c, null, 4096, null);
            aIGCFeedItemInfo2.c(c2(bVar));
            arrayList2.add(aIGCFeedItemInfo2);
            i16 = i18 + 1;
            bVarArr = feedInfos;
            arrayList = arrayList2;
            length = i17;
            z16 = false;
            i3++;
        }
        return arrayList;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/vm/SuitFeedViewModel$c;", "", "Lcom/tencent/mobileqq/zplan/aigc/data/c;", "data", "", "b", "", "result", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface c {
        void a(long result);

        void b(AIGCFeedItemInfo2 data);

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes35.dex */
        public static final class a {
            public static void a(c cVar, long j3) {
            }
        }
    }
}
