package com.tencent.biz.qqcircle.immersive.search.prompt.rank.staggered;

import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import circlesearch.CircleSearchExhibition$GetRankingDataRsp;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.immersive.search.prompt.rank.QFSSearchPromptRankDataModel;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u0000 52\u00020\u0001:\u00016B\u0007\u00a2\u0006\u0004\b3\u00104J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J!\u0010\u0010\u001a\u00028\u0000\"\u0004\b\u0000\u0010\r2\u0006\u0010\u000f\u001a\u00020\u000eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0006\u0010\u0015\u001a\u00020\u0004J\b\u0010\u0017\u001a\u00020\u0016H\u0016R \u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00190\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR#\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00190\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R \u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00190\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010\u001bR#\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00190\u001d8\u0006\u00a2\u0006\f\n\u0004\b%\u0010\u001f\u001a\u0004\b&\u0010!R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u001e\u00102\u001a\n /*\u0004\u0018\u00010\u00070\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00067"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/search/prompt/rank/staggered/QFSSearchPromptRankVideoViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Lcirclesearch/CircleSearchExhibition$GetRankingDataRsp;", "rsp", "", ICustomDataEditor.STRING_ARRAY_PARAM_2, "", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "byteList", "Lfeedcloud/FeedCloudMeta$StFeed;", "e2", "bytes", "d2", "T", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", Const.BUNDLE_KEY_REQUEST, "f2", "(Lcom/tencent/biz/richframework/network/request/BaseRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/os/Bundle;", "bundle", "b2", "c2", "", "getLogTag", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/biz/qqcircle/immersive/search/prompt/rank/a;", "i", "Landroidx/lifecycle/MutableLiveData;", "_initLiveData", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "Z1", "()Landroidx/lifecycle/LiveData;", "initLiveData", BdhLogUtil.LogTag.Tag_Conn, "_appendLiveData", "D", "X1", "appendLiveData", "", "E", "Z", "hasMore", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "attachInfo", "kotlin.jvm.PlatformType", "G", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "serverParams", "<init>", "()V", "H", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSSearchPromptRankVideoViewModel extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<QFSSearchPromptRankDataModel<FeedCloudMeta$StFeed>> _appendLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<QFSSearchPromptRankDataModel<FeedCloudMeta$StFeed>> appendLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean hasMore;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private String attachInfo;

    /* renamed from: G, reason: from kotlin metadata */
    private ByteStringMicro serverParams;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<QFSSearchPromptRankDataModel<FeedCloudMeta$StFeed>> _initLiveData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<QFSSearchPromptRankDataModel<FeedCloudMeta$StFeed>> initLiveData;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n \u0005*\u0004\u0018\u00010\u000b0\u000b2\u000e\u0010\f\u001a\n \u0005*\u0004\u0018\u00010\r0\rH\n\u00a2\u0006\u0002\b\u000e"}, d2 = {"<anonymous>", "", "T", "<anonymous parameter 0>", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "kotlin.jvm.PlatformType", "success", "", "retCode", "", "errMsg", "", "rsp", "", "onReceive"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class b<T> implements VSDispatchObserver.OnVSRspCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<T> f89973a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QFSSearchPromptRankVideoViewModel f89974b;

        /* JADX WARN: Multi-variable type inference failed */
        b(CancellableContinuation<? super T> cancellableContinuation, QFSSearchPromptRankVideoViewModel qFSSearchPromptRankVideoViewModel) {
            this.f89973a = cancellableContinuation;
            this.f89974b = qFSSearchPromptRankVideoViewModel;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
            if (!this.f89973a.isActive()) {
                QLog.d(this.f89974b.getTAG(), 1, "[sendRequestSuspend] cont is not active");
                return;
            }
            if (z16 && j3 == 0 && obj != null) {
                this.f89973a.resumeWith(Result.m476constructorimpl(obj));
                return;
            }
            QLog.w(this.f89974b.getTAG(), 1, "[sendRequestSuspend] success=" + z16 + ", retCode=" + j3 + ", errMsg=" + str);
            CancellableContinuation<T> cancellableContinuation = this.f89973a;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new RuntimeException(str))));
        }
    }

    public QFSSearchPromptRankVideoViewModel() {
        MutableLiveData<QFSSearchPromptRankDataModel<FeedCloudMeta$StFeed>> mutableLiveData = new MutableLiveData<>();
        this._initLiveData = mutableLiveData;
        this.initLiveData = mutableLiveData;
        MutableLiveData<QFSSearchPromptRankDataModel<FeedCloudMeta$StFeed>> mutableLiveData2 = new MutableLiveData<>();
        this._appendLiveData = mutableLiveData2;
        this.appendLiveData = mutableLiveData2;
        this.attachInfo = "";
        this.serverParams = ByteStringMicro.EMPTY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a2(CircleSearchExhibition$GetRankingDataRsp rsp) {
        String str = rsp.attachInfo.get();
        Intrinsics.checkNotNullExpressionValue(str, "rsp.attachInfo.get()");
        this.attachInfo = str;
        this.serverParams = rsp.serverParams.get();
        this.hasMore = rsp.hasMore.get();
        List<ByteStringMicro> list = rsp.data.get();
        Intrinsics.checkNotNullExpressionValue(list, "rsp.data.get()");
        this._appendLiveData.postValue(new QFSSearchPromptRankDataModel<>(true, e2(list), rsp.hasMore.get(), null, 8, null));
    }

    private final FeedCloudMeta$StFeed d2(ByteStringMicro bytes) {
        try {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
            feedCloudMeta$StFeed.mergeFrom(bytes.toByteArray());
            return feedCloudMeta$StFeed;
        } catch (Exception e16) {
            QLog.e(getTAG(), 1, "[parseFeed] ", e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<FeedCloudMeta$StFeed> e2(List<ByteStringMicro> byteList) {
        ArrayList arrayList = new ArrayList();
        Iterator<ByteStringMicro> it = byteList.iterator();
        while (it.hasNext()) {
            FeedCloudMeta$StFeed d26 = d2(it.next());
            if (d26 != null) {
                arrayList.add(d26);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> Object f2(BaseRequest baseRequest, Continuation<? super T> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        sendRequest(baseRequest, new b(cancellableContinuationImpl, this));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @NotNull
    public final LiveData<QFSSearchPromptRankDataModel<FeedCloudMeta$StFeed>> X1() {
        return this.appendLiveData;
    }

    @NotNull
    public final LiveData<QFSSearchPromptRankDataModel<FeedCloudMeta$StFeed>> Z1() {
        return this.initLiveData;
    }

    public final void b2(@Nullable Bundle bundle) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new QFSSearchPromptRankVideoViewModel$initData$1(this, bundle, null), 3, null);
    }

    public final void c2() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new QFSSearchPromptRankVideoViewModel$loadMoreVideo$1(this, null), 3, null);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSSearchPromptRankViewModel";
    }
}
