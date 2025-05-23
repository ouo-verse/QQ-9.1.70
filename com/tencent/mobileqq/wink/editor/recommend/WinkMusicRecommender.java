package com.tencent.mobileqq.wink.editor.recommend;

import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.wink.editor.extractor.ExtractCoverHelper;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.TimeoutKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleSmartMatchMusic$MusicInfo;
import qqcircle.QQCircleSmartMatchMusic$MusicStuckPointInfo;
import qqcircle.QQCircleSmartMatchMusic$MusicStuckPointInfoRsp;
import qqcircle.QQCircleSmartMatchMusic$SmartMatchMusicRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002#$B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J3\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ)\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002JF\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00062!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u0016H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001fJL\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00062!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u0016H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010\u001f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/recommend/WinkMusicRecommender;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "coverBitmaps", "", "Lqqcircle/QQCircleSmartMatchMusic$MusicInfo;", "g", "(Ljava/util/ArrayList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "musicMIDs", "Lqqcircle/QQCircleSmartMatchMusic$MusicStuckPointInfo;", "f", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "isSuccess", "Lqqcircle/QQCircleSmartMatchMusic$SmartMatchMusicRsp;", "rsp", "c", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", QAdVrReportParams.ParamKey.MEDIA, "Lkotlin/Function1;", "Lcom/tencent/mobileqq/wink/editor/recommend/WinkMusicRecommender$ProgressState;", "Lkotlin/ParameterName;", "name", "state", "", "onStateChanged", "Lcom/tencent/mobileqq/wink/editor/recommend/WinkMusicRecommender$a;", "e", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "<init>", "()V", "a", "ProgressState", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMusicRecommender {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WinkMusicRecommender f321453a = new WinkMusicRecommender();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/recommend/WinkMusicRecommender$ProgressState;", "", "(Ljava/lang/String;I)V", "EXTRA_DONE", "FETCH_MUSIC_DONE", "FETCH_MUSIC_STUCK_DONE", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public enum ProgressState {
        EXTRA_DONE,
        FETCH_MUSIC_DONE,
        FETCH_MUSIC_STUCK_DONE
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R'\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eR\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014R\u001f\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0017\u0010\u0014\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/recommend/WinkMusicRecommender$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "coverBitmaps", "", "Lqqcircle/QQCircleSmartMatchMusic$MusicInfo;", "b", "Ljava/util/List;", "()Ljava/util/List;", "musicInfo", "Lqqcircle/QQCircleSmartMatchMusic$MusicStuckPointInfo;", "c", "musicStuckInfo", "<init>", "(Ljava/util/ArrayList;Ljava/util/List;Ljava/util/List;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final /* data */ class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ArrayList<byte[]> coverBitmaps;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<QQCircleSmartMatchMusic$MusicInfo> musicInfo;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final List<QQCircleSmartMatchMusic$MusicStuckPointInfo> musicStuckInfo;

        public a(@NotNull ArrayList<byte[]> coverBitmaps, @NotNull List<QQCircleSmartMatchMusic$MusicInfo> musicInfo, @Nullable List<QQCircleSmartMatchMusic$MusicStuckPointInfo> list) {
            Intrinsics.checkNotNullParameter(coverBitmaps, "coverBitmaps");
            Intrinsics.checkNotNullParameter(musicInfo, "musicInfo");
            this.coverBitmaps = coverBitmaps;
            this.musicInfo = musicInfo;
            this.musicStuckInfo = list;
        }

        @NotNull
        public final ArrayList<byte[]> a() {
            return this.coverBitmaps;
        }

        @NotNull
        public final List<QQCircleSmartMatchMusic$MusicInfo> b() {
            return this.musicInfo;
        }

        @Nullable
        public final List<QQCircleSmartMatchMusic$MusicStuckPointInfo> c() {
            return this.musicStuckInfo;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            if (Intrinsics.areEqual(this.coverBitmaps, aVar.coverBitmaps) && Intrinsics.areEqual(this.musicInfo, aVar.musicInfo) && Intrinsics.areEqual(this.musicStuckInfo, aVar.musicStuckInfo)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = ((this.coverBitmaps.hashCode() * 31) + this.musicInfo.hashCode()) * 31;
            List<QQCircleSmartMatchMusic$MusicStuckPointInfo> list = this.musicStuckInfo;
            if (list == null) {
                hashCode = 0;
            } else {
                hashCode = list.hashCode();
            }
            return hashCode2 + hashCode;
        }

        @NotNull
        public String toString() {
            Integer num;
            int size = this.coverBitmaps.size();
            int size2 = this.musicInfo.size();
            List<QQCircleSmartMatchMusic$MusicStuckPointInfo> list = this.musicStuckInfo;
            if (list != null) {
                num = Integer.valueOf(list.size());
            } else {
                num = null;
            }
            return "MusicRecommendData(coverBitmaps.size=" + size + ", musicInfo.size=" + size2 + ", musicStuckInfo.size=" + num + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\f\u001a\u00020\u000b2\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\b\u001a\n \u0001*\u0004\u0018\u00010\u00070\u00072\u000e\u0010\n\u001a\n \u0001*\u0004\u0018\u00010\t0\tH\n\u00a2\u0006\u0004\b\f\u0010\r"}, d2 = {"Lcom/tencent/biz/richframework/network/request/BaseRequest;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "", "isSuccess", "", "code", "", "msg", "Lqqcircle/QQCircleSmartMatchMusic$MusicStuckPointInfoRsp;", "rsp", "", "a", "(Lcom/tencent/biz/richframework/network/request/BaseRequest;ZJLjava/lang/String;Lqqcircle/QQCircleSmartMatchMusic$MusicStuckPointInfoRsp;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b<T> implements VSDispatchObserver.OnVSRspCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<List<QQCircleSmartMatchMusic$MusicStuckPointInfo>> f321457a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Continuation<? super List<QQCircleSmartMatchMusic$MusicStuckPointInfo>> continuation) {
            this.f321457a = continuation;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleSmartMatchMusic$MusicStuckPointInfoRsp qQCircleSmartMatchMusic$MusicStuckPointInfoRsp) {
            if (z16 && qQCircleSmartMatchMusic$MusicStuckPointInfoRsp != null) {
                Continuation<List<QQCircleSmartMatchMusic$MusicStuckPointInfo>> continuation = this.f321457a;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(qQCircleSmartMatchMusic$MusicStuckPointInfoRsp.stuckPointInfo.get()));
            } else {
                w53.b.c("WinkMusicRecommender", "requestMusicStuckPointInfo error: " + j3 + " " + str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\f\u001a\u00020\u000b2\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\b\u001a\n \u0001*\u0004\u0018\u00010\u00070\u00072\u000e\u0010\n\u001a\n \u0001*\u0004\u0018\u00010\t0\tH\n\u00a2\u0006\u0004\b\f\u0010\r"}, d2 = {"Lcom/tencent/biz/richframework/network/request/BaseRequest;", "kotlin.jvm.PlatformType", "<anonymous parameter 0>", "", "isSuccess", "", "<anonymous parameter 2>", "", "<anonymous parameter 3>", "Lqqcircle/QQCircleSmartMatchMusic$SmartMatchMusicRsp;", "rsp", "", "a", "(Lcom/tencent/biz/richframework/network/request/BaseRequest;ZJLjava/lang/String;Lqqcircle/QQCircleSmartMatchMusic$SmartMatchMusicRsp;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c<T> implements VSDispatchObserver.OnVSRspCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<List<QQCircleSmartMatchMusic$MusicInfo>> f321458a;

        /* JADX WARN: Multi-variable type inference failed */
        c(Continuation<? super List<QQCircleSmartMatchMusic$MusicInfo>> continuation) {
            this.f321458a = continuation;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleSmartMatchMusic$SmartMatchMusicRsp qQCircleSmartMatchMusic$SmartMatchMusicRsp) {
            Continuation<List<QQCircleSmartMatchMusic$MusicInfo>> continuation = this.f321458a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(WinkMusicRecommender.f321453a.c(z16, qQCircleSmartMatchMusic$SmartMatchMusicRsp)));
        }
    }

    WinkMusicRecommender() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<QQCircleSmartMatchMusic$MusicInfo> c(boolean isSuccess, QQCircleSmartMatchMusic$SmartMatchMusicRsp rsp) {
        if (isSuccess && rsp != null) {
            return rsp.musicListInfo.get();
        }
        w53.b.c("WinkMusicRecommender", "requestRecommendMusic error: ");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object f(List<String> list, Continuation<? super List<QQCircleSmartMatchMusic$MusicStuckPointInfo>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        if (list.isEmpty()) {
            w53.b.c("WinkMusicRecommender", "[requestMusicStuckPointInfo] musicMIDs is empty");
            safeContinuation.resumeWith(Result.m476constructorimpl(null));
        } else {
            WinkEditorMusicHelper.G(list, new b(safeContinuation));
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    private final Object g(ArrayList<byte[]> arrayList, Continuation<? super List<QQCircleSmartMatchMusic$MusicInfo>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        WinkEditorMusicHelper.H(arrayList, null, 1, null, 0, "", 4, true, new c(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0082 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object d(@NotNull List<? extends LocalMediaInfo> list, @NotNull Function1<? super ProgressState, Unit> function1, @NotNull Continuation<? super List<QQCircleSmartMatchMusic$MusicInfo>> continuation) {
        WinkMusicRecommender$recommendMusic$1 winkMusicRecommender$recommendMusic$1;
        Object obj;
        Object coroutine_suspended;
        int i3;
        WinkMusicRecommender winkMusicRecommender;
        Function1<? super ProgressState, Unit> function12;
        List list2;
        if (continuation instanceof WinkMusicRecommender$recommendMusic$1) {
            winkMusicRecommender$recommendMusic$1 = (WinkMusicRecommender$recommendMusic$1) continuation;
            int i16 = winkMusicRecommender$recommendMusic$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                winkMusicRecommender$recommendMusic$1.label = i16 - Integer.MIN_VALUE;
                obj = winkMusicRecommender$recommendMusic$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = winkMusicRecommender$recommendMusic$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            function12 = (Function1) winkMusicRecommender$recommendMusic$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            list2 = (List) obj;
                            function12.invoke(ProgressState.FETCH_MUSIC_DONE);
                            if (list2 != null) {
                                w53.b.c("WinkMusicRecommender", "[recommendMusic] musicInfo is null");
                                return null;
                            }
                            return list2;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    function1 = (Function1) winkMusicRecommender$recommendMusic$1.L$1;
                    winkMusicRecommender = (WinkMusicRecommender) winkMusicRecommender$recommendMusic$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    ExtractCoverHelper extractCoverHelper = ExtractCoverHelper.f320276a;
                    winkMusicRecommender$recommendMusic$1.L$0 = this;
                    winkMusicRecommender$recommendMusic$1.L$1 = function1;
                    winkMusicRecommender$recommendMusic$1.label = 1;
                    obj = extractCoverHelper.C(list, winkMusicRecommender$recommendMusic$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    winkMusicRecommender = this;
                }
                function1.invoke(ProgressState.EXTRA_DONE);
                winkMusicRecommender$recommendMusic$1.L$0 = function1;
                winkMusicRecommender$recommendMusic$1.L$1 = null;
                winkMusicRecommender$recommendMusic$1.label = 2;
                obj = winkMusicRecommender.g((ArrayList) obj, winkMusicRecommender$recommendMusic$1);
                if (obj != coroutine_suspended) {
                    return coroutine_suspended;
                }
                function12 = function1;
                list2 = (List) obj;
                function12.invoke(ProgressState.FETCH_MUSIC_DONE);
                if (list2 != null) {
                }
            }
        }
        winkMusicRecommender$recommendMusic$1 = new WinkMusicRecommender$recommendMusic$1(this, continuation);
        obj = winkMusicRecommender$recommendMusic$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = winkMusicRecommender$recommendMusic$1.label;
        if (i3 == 0) {
        }
        function1.invoke(ProgressState.EXTRA_DONE);
        winkMusicRecommender$recommendMusic$1.L$0 = function1;
        winkMusicRecommender$recommendMusic$1.L$1 = null;
        winkMusicRecommender$recommendMusic$1.label = 2;
        obj = winkMusicRecommender.g((ArrayList) obj, winkMusicRecommender$recommendMusic$1);
        if (obj != coroutine_suspended) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0033  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object e(@NotNull List<? extends LocalMediaInfo> list, @NotNull Function1<? super ProgressState, Unit> function1, @NotNull Continuation<? super a> continuation) {
        WinkMusicRecommender$recommendStuckMusic$1 winkMusicRecommender$recommendStuckMusic$1;
        Object coroutine_suspended;
        int i3;
        WinkMusicRecommender winkMusicRecommender;
        Object g16;
        Function1<? super ProgressState, Unit> function12;
        ArrayList<byte[]> arrayList;
        List list2;
        Function1<? super ProgressState, Unit> function13;
        List list3;
        List list4;
        if (continuation instanceof WinkMusicRecommender$recommendStuckMusic$1) {
            winkMusicRecommender$recommendStuckMusic$1 = (WinkMusicRecommender$recommendStuckMusic$1) continuation;
            int i16 = winkMusicRecommender$recommendStuckMusic$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                winkMusicRecommender$recommendStuckMusic$1.label = i16 - Integer.MIN_VALUE;
                Object obj = winkMusicRecommender$recommendStuckMusic$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = winkMusicRecommender$recommendStuckMusic$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                list3 = (List) winkMusicRecommender$recommendStuckMusic$1.L$2;
                                arrayList = (ArrayList) winkMusicRecommender$recommendStuckMusic$1.L$1;
                                function13 = (Function1) winkMusicRecommender$recommendStuckMusic$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                list4 = (List) obj;
                                function13.invoke(ProgressState.FETCH_MUSIC_STUCK_DONE);
                                ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestoneEnd(IPrefRecorder.MILESTONE_FETCH_MUSIC_STUCK_POINT);
                                if (list4 != null) {
                                    w53.b.c("WinkMusicRecommender", "[recommendStuckMusic] musicStuckInfo is null");
                                } else if (list4.isEmpty()) {
                                    w53.b.c("WinkMusicRecommender", "[recommendStuckMusic] musicStuckInfo is empty");
                                }
                                return new a(arrayList, list3, list4);
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ArrayList<byte[]> arrayList2 = (ArrayList) winkMusicRecommender$recommendStuckMusic$1.L$1;
                        Function1<? super ProgressState, Unit> function14 = (Function1) winkMusicRecommender$recommendStuckMusic$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        arrayList = arrayList2;
                        function12 = function14;
                        list2 = (List) obj;
                        function12.invoke(ProgressState.FETCH_MUSIC_DONE);
                        ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestoneEnd(IPrefRecorder.MILESTONE_FETCH_MUSIC);
                        if (list2 != null) {
                            w53.b.c("WinkMusicRecommender", "[recommendStuckMusic] musicInfo is null");
                            return null;
                        }
                        if (list2.isEmpty()) {
                            w53.b.c("WinkMusicRecommender", "[recommendStuckMusic] musicInfo is empty");
                            return null;
                        }
                        ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestone(IPrefRecorder.MILESTONE_FETCH_MUSIC_STUCK_POINT);
                        WinkMusicRecommender$recommendStuckMusic$musicStuckInfo$1 winkMusicRecommender$recommendStuckMusic$musicStuckInfo$1 = new WinkMusicRecommender$recommendStuckMusic$musicStuckInfo$1(list2, null);
                        winkMusicRecommender$recommendStuckMusic$1.L$0 = function12;
                        winkMusicRecommender$recommendStuckMusic$1.L$1 = arrayList;
                        winkMusicRecommender$recommendStuckMusic$1.L$2 = list2;
                        winkMusicRecommender$recommendStuckMusic$1.label = 3;
                        Object withTimeoutOrNull = TimeoutKt.withTimeoutOrNull(5000L, winkMusicRecommender$recommendStuckMusic$musicStuckInfo$1, winkMusicRecommender$recommendStuckMusic$1);
                        if (withTimeoutOrNull == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function13 = function12;
                        list3 = list2;
                        obj = withTimeoutOrNull;
                        list4 = (List) obj;
                        function13.invoke(ProgressState.FETCH_MUSIC_STUCK_DONE);
                        ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestoneEnd(IPrefRecorder.MILESTONE_FETCH_MUSIC_STUCK_POINT);
                        if (list4 != null) {
                        }
                        return new a(arrayList, list3, list4);
                    }
                    function1 = (Function1) winkMusicRecommender$recommendStuckMusic$1.L$1;
                    winkMusicRecommender = (WinkMusicRecommender) winkMusicRecommender$recommendStuckMusic$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestone(IPrefRecorder.MILESTONE_EXTRACT_COVER);
                    ExtractCoverHelper extractCoverHelper = ExtractCoverHelper.f320276a;
                    winkMusicRecommender$recommendStuckMusic$1.L$0 = this;
                    winkMusicRecommender$recommendStuckMusic$1.L$1 = function1;
                    winkMusicRecommender$recommendStuckMusic$1.label = 1;
                    obj = extractCoverHelper.C(list, winkMusicRecommender$recommendStuckMusic$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    winkMusicRecommender = this;
                }
                ArrayList<byte[]> arrayList3 = (ArrayList) obj;
                function1.invoke(ProgressState.EXTRA_DONE);
                ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestoneEnd(IPrefRecorder.MILESTONE_EXTRACT_COVER);
                ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestone(IPrefRecorder.MILESTONE_FETCH_MUSIC);
                winkMusicRecommender$recommendStuckMusic$1.L$0 = function1;
                winkMusicRecommender$recommendStuckMusic$1.L$1 = arrayList3;
                winkMusicRecommender$recommendStuckMusic$1.label = 2;
                g16 = winkMusicRecommender.g(arrayList3, winkMusicRecommender$recommendStuckMusic$1);
                if (g16 != coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = g16;
                function12 = function1;
                arrayList = arrayList3;
                list2 = (List) obj;
                function12.invoke(ProgressState.FETCH_MUSIC_DONE);
                ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestoneEnd(IPrefRecorder.MILESTONE_FETCH_MUSIC);
                if (list2 != null) {
                }
            }
        }
        winkMusicRecommender$recommendStuckMusic$1 = new WinkMusicRecommender$recommendStuckMusic$1(this, continuation);
        Object obj2 = winkMusicRecommender$recommendStuckMusic$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = winkMusicRecommender$recommendStuckMusic$1.label;
        if (i3 == 0) {
        }
        ArrayList<byte[]> arrayList32 = (ArrayList) obj2;
        function1.invoke(ProgressState.EXTRA_DONE);
        ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestoneEnd(IPrefRecorder.MILESTONE_EXTRACT_COVER);
        ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestone(IPrefRecorder.MILESTONE_FETCH_MUSIC);
        winkMusicRecommender$recommendStuckMusic$1.L$0 = function1;
        winkMusicRecommender$recommendStuckMusic$1.L$1 = arrayList32;
        winkMusicRecommender$recommendStuckMusic$1.label = 2;
        g16 = winkMusicRecommender.g(arrayList32, winkMusicRecommender$recommendStuckMusic$1);
        if (g16 != coroutine_suspended) {
        }
    }
}
