package kotlin.time;

import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@SinceKotlin(version = "1.3")
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0015\u0010\u0002\u001a\u00020\u0003H&\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u001b\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0003H\u0096\u0002\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0003H\u0096\u0002\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000e\u0010\f\u0082\u0002\b\n\u0002\b!\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lkotlin/time/TimeMark;", "", "elapsedNow", "Lkotlin/time/Duration;", "elapsedNow-UwyO8pc", "()J", "hasNotPassedNow", "", "hasPassedNow", "minus", "duration", "minus-LRDsOJo", "(J)Lkotlin/time/TimeMark;", QCircleDaTongConstant.ElementParamValue.PLUS, "plus-LRDsOJo", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalTime
/* loaded from: classes28.dex */
public interface TimeMark {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static final class DefaultImpls {
        public static boolean hasNotPassedNow(@NotNull TimeMark timeMark) {
            return Duration.m1859isNegativeimpl(timeMark.mo1818elapsedNowUwyO8pc());
        }

        public static boolean hasPassedNow(@NotNull TimeMark timeMark) {
            return !Duration.m1859isNegativeimpl(timeMark.mo1818elapsedNowUwyO8pc());
        }

        @NotNull
        /* renamed from: minus-LRDsOJo, reason: not valid java name */
        public static TimeMark m1961minusLRDsOJo(@NotNull TimeMark timeMark, long j3) {
            return timeMark.mo1820plusLRDsOJo(Duration.m1878unaryMinusUwyO8pc(j3));
        }

        @NotNull
        /* renamed from: plus-LRDsOJo, reason: not valid java name */
        public static TimeMark m1962plusLRDsOJo(@NotNull TimeMark timeMark, long j3) {
            return new AdjustedTimeMark(timeMark, j3, null);
        }
    }

    /* renamed from: elapsedNow-UwyO8pc */
    long mo1818elapsedNowUwyO8pc();

    boolean hasNotPassedNow();

    boolean hasPassedNow();

    @NotNull
    /* renamed from: minus-LRDsOJo */
    TimeMark mo1819minusLRDsOJo(long duration);

    @NotNull
    /* renamed from: plus-LRDsOJo */
    TimeMark mo1820plusLRDsOJo(long duration);
}
