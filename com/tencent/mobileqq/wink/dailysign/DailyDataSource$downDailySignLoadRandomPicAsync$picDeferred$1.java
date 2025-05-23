package com.tencent.mobileqq.wink.dailysign;

import android.os.SystemClock;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.dailysign.DailyDataSource$downDailySignLoadRandomPicAsync$picDeferred$1", f = "DailyDataSource.kt", i = {1}, l = {108, 115}, m = "invokeSuspend", n = {"start"}, s = {"J$0"})
/* loaded from: classes21.dex */
public final class DailyDataSource$downDailySignLoadRandomPicAsync$picDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DailySignConfig $dailySignConfig;
    long J$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DailyDataSource$downDailySignLoadRandomPicAsync$picDeferred$1(DailySignConfig dailySignConfig, Continuation<? super DailyDataSource$downDailySignLoadRandomPicAsync$picDeferred$1> continuation) {
        super(2, continuation);
        this.$dailySignConfig = dailySignConfig;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DailyDataSource$downDailySignLoadRandomPicAsync$picDeferred$1(this.$dailySignConfig, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ee A[Catch: IllegalStateException -> 0x0022, TRY_LEAVE, TryCatch #0 {IllegalStateException -> 0x0022, blocks: (B:7:0x0010, B:8:0x00c7, B:11:0x00d7, B:14:0x00e9, B:20:0x00ee, B:21:0x00dc, B:22:0x00ce, B:25:0x001e, B:26:0x0033, B:29:0x003d, B:31:0x0043, B:33:0x0047, B:35:0x004f, B:37:0x005a, B:43:0x0067, B:45:0x0081, B:46:0x008b, B:47:0x00b3, B:49:0x00b4, B:54:0x00f9, B:55:0x0106, B:56:0x003a, B:58:0x0028), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00dc A[Catch: IllegalStateException -> 0x0022, TryCatch #0 {IllegalStateException -> 0x0022, blocks: (B:7:0x0010, B:8:0x00c7, B:11:0x00d7, B:14:0x00e9, B:20:0x00ee, B:21:0x00dc, B:22:0x00ce, B:25:0x001e, B:26:0x0033, B:29:0x003d, B:31:0x0043, B:33:0x0047, B:35:0x004f, B:37:0x005a, B:43:0x0067, B:45:0x0081, B:46:0x008b, B:47:0x00b3, B:49:0x00b4, B:54:0x00f9, B:55:0x0106, B:56:0x003a, B:58:0x0028), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ce A[Catch: IllegalStateException -> 0x0022, TryCatch #0 {IllegalStateException -> 0x0022, blocks: (B:7:0x0010, B:8:0x00c7, B:11:0x00d7, B:14:0x00e9, B:20:0x00ee, B:21:0x00dc, B:22:0x00ce, B:25:0x001e, B:26:0x0033, B:29:0x003d, B:31:0x0043, B:33:0x0047, B:35:0x004f, B:37:0x005a, B:43:0x0067, B:45:0x0081, B:46:0x008b, B:47:0x00b3, B:49:0x00b4, B:54:0x00f9, B:55:0x0106, B:56:0x003a, B:58:0x0028), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0067 A[Catch: IllegalStateException -> 0x0022, TryCatch #0 {IllegalStateException -> 0x0022, blocks: (B:7:0x0010, B:8:0x00c7, B:11:0x00d7, B:14:0x00e9, B:20:0x00ee, B:21:0x00dc, B:22:0x00ce, B:25:0x001e, B:26:0x0033, B:29:0x003d, B:31:0x0043, B:33:0x0047, B:35:0x004f, B:37:0x005a, B:43:0x0067, B:45:0x0081, B:46:0x008b, B:47:0x00b3, B:49:0x00b4, B:54:0x00f9, B:55:0x0106, B:56:0x003a, B:58:0x0028), top: B:2:0x0008 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        List<String> list;
        long j3;
        boolean z16;
        DailySignConfig dailySignConfig;
        DailySignConfig dailySignConfig2;
        DailySignConfig dailySignConfig3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        j3 = this.J$0;
                        ResultKt.throwOnFailure(obj);
                        Pair pair = (Pair) obj;
                        dailySignConfig = this.$dailySignConfig;
                        if (dailySignConfig == null) {
                            dailySignConfig.setMediaPath((List) pair.getFirst());
                        }
                        dailySignConfig2 = this.$dailySignConfig;
                        if (dailySignConfig2 == null) {
                            dailySignConfig2.setBackGroundPicIndex(((Number) pair.getSecond()).intValue());
                        }
                        dailySignConfig3 = this.$dailySignConfig;
                        if (dailySignConfig3 == null) {
                            dailySignConfig3.setLoadPicTime(SystemClock.elapsedRealtime() - j3);
                        }
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                DailyDataSource dailyDataSource = DailyDataSource.f318060a;
                this.label = 1;
                obj = dailyDataSource.i(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            List<MetaMaterial> list2 = (List) obj;
            DailySignConfig dailySignConfig4 = this.$dailySignConfig;
            if (dailySignConfig4 != null) {
                dailySignConfig4.setBackGroundPic(list2);
            }
            if (!list2.isEmpty()) {
                DailySignConfig dailySignConfig5 = this.$dailySignConfig;
                if (dailySignConfig5 != null) {
                    list = dailySignConfig5.getOriginMediaPath();
                } else {
                    list = null;
                }
                if (list != null) {
                    List<String> originMediaPath = this.$dailySignConfig.getOriginMediaPath();
                    if (originMediaPath != null && !originMediaPath.isEmpty()) {
                        z16 = false;
                        if (z16) {
                            List<String> originMediaPath2 = this.$dailySignConfig.getOriginMediaPath();
                            Intrinsics.checkNotNull(originMediaPath2);
                            if (new File(originMediaPath2.get(0)).exists()) {
                                DailySignConfig dailySignConfig6 = this.$dailySignConfig;
                                dailySignConfig6.setMediaPath(dailySignConfig6.getOriginMediaPath());
                                return Unit.INSTANCE;
                            }
                            throw new ResLoadException(1, new Exception("templateConfig.mediaPath " + this.$dailySignConfig.getMediaPath() + " not exist"));
                        }
                    }
                    z16 = true;
                    if (z16) {
                    }
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                DailyDataSource dailyDataSource2 = DailyDataSource.f318060a;
                this.J$0 = elapsedRealtime;
                this.label = 2;
                obj = dailyDataSource2.f(list2, -1, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                j3 = elapsedRealtime;
                Pair pair2 = (Pair) obj;
                dailySignConfig = this.$dailySignConfig;
                if (dailySignConfig == null) {
                }
                dailySignConfig2 = this.$dailySignConfig;
                if (dailySignConfig2 == null) {
                }
                dailySignConfig3 = this.$dailySignConfig;
                if (dailySignConfig3 == null) {
                }
                return Unit.INSTANCE;
            }
            throw new ResLoadException(1, new Exception("allBackgroundPic empty"));
        } catch (IllegalStateException e16) {
            w53.b.c("DailySignDataSource", "allBackgroundPic error");
            throw new ResLoadException(1, e16);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DailyDataSource$downDailySignLoadRandomPicAsync$picDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
