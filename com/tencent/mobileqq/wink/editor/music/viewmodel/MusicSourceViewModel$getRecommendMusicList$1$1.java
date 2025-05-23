package com.tencent.mobileqq.wink.editor.music.viewmodel;

import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper;
import com.tencent.mobileqq.wink.editor.music.ax;
import com.tencent.mobileqq.wink.editor.music.vo.MusicListData;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleSmartMatchMusic$MusicInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$getRecommendMusicList$1$1", f = "MusicSourceViewModel.kt", i = {}, l = {508}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class MusicSourceViewModel$getRecommendMusicList$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $needLyrics;
    final /* synthetic */ List<QQCircleSmartMatchMusic$MusicInfo> $stMusicList;
    final /* synthetic */ List<WinkEditorMusicInfo> $tongKuanMusic;
    int label;
    final /* synthetic */ MusicSourceViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$getRecommendMusicList$1$1$1", f = "MusicSourceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$getRecommendMusicList$1$1$1, reason: invalid class name */
    /* loaded from: classes21.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MusicSourceViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MusicSourceViewModel musicSourceViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = musicSourceViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            CountDownLatch countDownLatch;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                countDownLatch = this.this$0.musicLatch;
                countDownLatch.await();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MusicSourceViewModel$getRecommendMusicList$1$1(MusicSourceViewModel musicSourceViewModel, List<QQCircleSmartMatchMusic$MusicInfo> list, boolean z16, List<? extends WinkEditorMusicInfo> list2, Continuation<? super MusicSourceViewModel$getRecommendMusicList$1$1> continuation) {
        super(2, continuation);
        this.this$0 = musicSourceViewModel;
        this.$stMusicList = list;
        this.$needLyrics = z16;
        this.$tongKuanMusic = list2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MusicSourceViewModel$getRecommendMusicList$1$1(this.this$0, this.$stMusicList, this.$needLyrics, this.$tongKuanMusic, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0068  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        boolean z16;
        List<QQCircleSmartMatchMusic$MusicInfo> list;
        MusicListData musicListData;
        List<? extends WinkEditorMusicInfo> D3;
        MusicListData musicListData2;
        boolean z17;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            if (this.this$0.getNeedAutoMusic()) {
                z16 = this.this$0.isNeedWaitMusicJudge;
                if (z16) {
                    w53.b.f("MusicSourceViewModel", "wait oriBgm judge");
                    CoroutineDispatcher io5 = Dispatchers.getIO();
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
                    this.label = 1;
                    if (BuildersKt.withContext(io5, anonymousClass1, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            list = this.$stMusicList;
            if (list != null) {
                if (!this.$needLyrics) {
                    this.this$0.c3(list);
                }
                List<WinkEditorMusicInfo> finalMusicList = WinkEditorMusicHelper.x(WinkEditorMusicHelper.j(WinkEditorMusicHelper.l(this.$stMusicList), "FAKE_CATEGORY_RECOMMEND_ID", "\u63a8\u8350"), this.$tongKuanMusic);
                musicListData = this.this$0.musicListData;
                List<WinkEditorMusicInfo> p16 = musicListData.p();
                if (p16.isEmpty()) {
                    w53.b.f("MusicSourceViewModel", "[getRecommendMusicList] currentRecommendList is empty");
                    p16 = WinkEditorMusicInfo.a("FAKE_CATEGORY_RECOMMEND_ID");
                    Intrinsics.checkNotNullExpressionValue(p16, "assembleDefaultList(Wink\u2026KE_CATEGORY_RECOMMEND_ID)");
                }
                MusicSourceViewModel musicSourceViewModel = this.this$0;
                Intrinsics.checkNotNullExpressionValue(finalMusicList, "finalMusicList");
                D3 = musicSourceViewModel.D3(finalMusicList, p16);
                ax.f320778e.e();
                musicListData2 = this.this$0.musicListData;
                musicListData2.y(D3);
            }
            return Unit.INSTANCE;
        }
        z17 = this.this$0.oriHasBgm;
        w53.b.f("MusicSourceViewModel", "wait oriBgm " + z17);
        list = this.$stMusicList;
        if (list != null) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MusicSourceViewModel$getRecommendMusicList$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
