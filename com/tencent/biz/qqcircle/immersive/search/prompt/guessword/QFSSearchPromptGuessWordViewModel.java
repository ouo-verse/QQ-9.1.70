package com.tencent.biz.qqcircle.immersive.search.prompt.guessword;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import circlesearch.CircleSearchExhibition$PromptGuess;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudCommon$StCommonExt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J!\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\tH\u0016J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\tJ\u0006\u0010\u000e\u001a\u00020\fR\u001c\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006!"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/search/prompt/guessword/QFSSearchPromptGuessWordViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Lfeedcloud/FeedCloudCommon$StCommonExt;", "P1", "T", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", Const.BUNDLE_KEY_REQUEST, "R1", "(Lcom/tencent/biz/richframework/network/request/BaseRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "getLogTag", "attach", "", "S1", "refresh", "Landroidx/lifecycle/MutableLiveData;", "Lcirclesearch/CircleSearchExhibition$PromptGuess;", "i", "Landroidx/lifecycle/MutableLiveData;", "_guessLiveData", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "Q1", "()Landroidx/lifecycle/LiveData;", "guessRefreshLiveData", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "attachInfo", "<init>", "()V", "D", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSSearchPromptGuessWordViewModel extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String attachInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<CircleSearchExhibition$PromptGuess> _guessLiveData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<CircleSearchExhibition$PromptGuess> guessRefreshLiveData;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n \u0005*\u0004\u0018\u00010\u000b0\u000b2\u000e\u0010\f\u001a\n \u0005*\u0004\u0018\u00010\r0\rH\n\u00a2\u0006\u0002\b\u000e"}, d2 = {"<anonymous>", "", "T", "<anonymous parameter 0>", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", "kotlin.jvm.PlatformType", "success", "", "retCode", "", "errMsg", "", "rsp", "", "onReceive"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class b<T> implements VSDispatchObserver.OnVSRspCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<T> f89907a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QFSSearchPromptGuessWordViewModel f89908b;

        /* JADX WARN: Multi-variable type inference failed */
        b(CancellableContinuation<? super T> cancellableContinuation, QFSSearchPromptGuessWordViewModel qFSSearchPromptGuessWordViewModel) {
            this.f89907a = cancellableContinuation;
            this.f89908b = qFSSearchPromptGuessWordViewModel;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
            if (!this.f89907a.isActive()) {
                QLog.d(this.f89908b.getLogTag(), 1, "[sendRequestSuspend] cont is not active");
                return;
            }
            if (z16 && j3 == 0 && obj != null) {
                this.f89907a.resumeWith(Result.m476constructorimpl(obj));
                return;
            }
            QLog.w(this.f89908b.getLogTag(), 1, "[sendRequestSuspend] success=" + z16 + ", retCode=" + j3 + ", errMsg=" + str);
            CancellableContinuation<T> cancellableContinuation = this.f89907a;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new RuntimeException(str))));
        }
    }

    public QFSSearchPromptGuessWordViewModel() {
        MutableLiveData<CircleSearchExhibition$PromptGuess> mutableLiveData = new MutableLiveData<>();
        this._guessLiveData = mutableLiveData;
        this.guessRefreshLiveData = mutableLiveData;
        this.attachInfo = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FeedCloudCommon$StCommonExt P1() {
        boolean isBlank;
        FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt = new FeedCloudCommon$StCommonExt();
        if (QFSVideoView.L0() != null) {
            FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
            feedCloudCommon$Entry.key.set("current_video_id");
            feedCloudCommon$Entry.value.set(QFSVideoView.L0());
            feedCloudCommon$StCommonExt.mapInfo.get().add(feedCloudCommon$Entry);
        }
        isBlank = StringsKt__StringsJVMKt.isBlank(this.attachInfo);
        if (!isBlank) {
            FeedCloudCommon$Entry feedCloudCommon$Entry2 = new FeedCloudCommon$Entry();
            feedCloudCommon$Entry2.key.set("guess_attach_info");
            feedCloudCommon$Entry2.value.set(this.attachInfo);
            feedCloudCommon$StCommonExt.mapInfo.get().add(feedCloudCommon$Entry2);
        }
        if (QFSVideoView.K0() > 0) {
            FeedCloudCommon$Entry feedCloudCommon$Entry3 = new FeedCloudCommon$Entry();
            feedCloudCommon$Entry3.key.set("click_id");
            feedCloudCommon$Entry3.value.set(String.valueOf(QFSVideoView.K0()));
            feedCloudCommon$StCommonExt.mapInfo.get().add(feedCloudCommon$Entry3);
        }
        return feedCloudCommon$StCommonExt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> Object R1(BaseRequest baseRequest, Continuation<? super T> continuation) {
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
    public final LiveData<CircleSearchExhibition$PromptGuess> Q1() {
        return this.guessRefreshLiveData;
    }

    public final void S1(@NotNull String attach) {
        Intrinsics.checkNotNullParameter(attach, "attach");
        this.attachInfo = attach;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "QFSSearchPromptGuessWordViewModel";
    }

    public final void refresh() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new QFSSearchPromptGuessWordViewModel$refresh$1(this, null), 3, null);
    }
}
