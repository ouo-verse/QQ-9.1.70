package kotlin.time;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.tuxmeterqui.question.time.TuxTimeView;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.comparisons.ComparisonsKt___ComparisonsJvmKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsKt;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@SinceKotlin(version = "1.6")
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087@\u0018\u0000 \u00a4\u00012\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u00a4\u0001B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J%\u0010D\u001a\u00020\u00002\u0006\u0010E\u001a\u00020\u00032\u0006\u0010F\u001a\u00020\u0003H\u0002\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bG\u0010HJ\u001b\u0010I\u001a\u00020\t2\u0006\u0010J\u001a\u00020\u0000H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\bK\u0010LJ\u001e\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u000fH\u0086\u0002\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bO\u0010PJ\u001e\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\tH\u0086\u0002\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bO\u0010QJ\u001b\u0010M\u001a\u00020\u000f2\u0006\u0010J\u001a\u00020\u0000H\u0086\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\bR\u0010SJ\u001a\u0010T\u001a\u00020U2\b\u0010J\u001a\u0004\u0018\u00010VH\u00d6\u0003\u00a2\u0006\u0004\bW\u0010XJ\u0010\u0010Y\u001a\u00020\tH\u00d6\u0001\u00a2\u0006\u0004\bZ\u0010\rJ\r\u0010[\u001a\u00020U\u00a2\u0006\u0004\b\\\u0010]J\u000f\u0010^\u001a\u00020UH\u0002\u00a2\u0006\u0004\b_\u0010]J\u000f\u0010`\u001a\u00020UH\u0002\u00a2\u0006\u0004\ba\u0010]J\r\u0010b\u001a\u00020U\u00a2\u0006\u0004\bc\u0010]J\r\u0010d\u001a\u00020U\u00a2\u0006\u0004\be\u0010]J\r\u0010f\u001a\u00020U\u00a2\u0006\u0004\bg\u0010]J\u001b\u0010h\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0000H\u0086\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\bi\u0010jJ\u001b\u0010k\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\u0000H\u0086\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\bl\u0010jJ\u001e\u0010m\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u000fH\u0086\u0002\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bn\u0010PJ\u001e\u0010m\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\tH\u0086\u0002\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\bn\u0010QJ\u009d\u0001\u0010o\u001a\u0002Hp\"\u0004\b\u0000\u0010p2u\u0010q\u001aq\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(u\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(v\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(w\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(x\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(y\u0012\u0004\u0012\u0002Hp0rH\u0086\b\u00f8\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0004\bz\u0010{J\u0088\u0001\u0010o\u001a\u0002Hp\"\u0004\b\u0000\u0010p2`\u0010q\u001a\\\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(v\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(w\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(x\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(y\u0012\u0004\u0012\u0002Hp0|H\u0086\b\u00f8\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0004\bz\u0010}Js\u0010o\u001a\u0002Hp\"\u0004\b\u0000\u0010p2K\u0010q\u001aG\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(w\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(x\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(y\u0012\u0004\u0012\u0002Hp0~H\u0086\b\u00f8\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0004\bz\u0010\u007fJ`\u0010o\u001a\u0002Hp\"\u0004\b\u0000\u0010p27\u0010q\u001a3\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(x\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\bs\u0012\b\bt\u0012\u0004\b\b(y\u0012\u0004\u0012\u0002Hp0\u0080\u0001H\u0086\b\u00f8\u0001\u0002\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0005\bz\u0010\u0081\u0001J\u0019\u0010\u0082\u0001\u001a\u00020\u000f2\u0007\u0010\u0083\u0001\u001a\u00020=\u00a2\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u0019\u0010\u0086\u0001\u001a\u00020\t2\u0007\u0010\u0083\u0001\u001a\u00020=\u00a2\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\u0011\u0010\u0089\u0001\u001a\u00030\u008a\u0001\u00a2\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u0019\u0010\u008d\u0001\u001a\u00020\u00032\u0007\u0010\u0083\u0001\u001a\u00020=\u00a2\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\u0011\u0010\u0090\u0001\u001a\u00020\u0003H\u0007\u00a2\u0006\u0005\b\u0091\u0001\u0010\u0005J\u0011\u0010\u0092\u0001\u001a\u00020\u0003H\u0007\u00a2\u0006\u0005\b\u0093\u0001\u0010\u0005J\u0013\u0010\u0094\u0001\u001a\u00030\u008a\u0001H\u0016\u00a2\u0006\u0006\b\u0095\u0001\u0010\u008c\u0001J%\u0010\u0094\u0001\u001a\u00030\u008a\u00012\u0007\u0010\u0083\u0001\u001a\u00020=2\t\b\u0002\u0010\u0096\u0001\u001a\u00020\t\u00a2\u0006\u0006\b\u0095\u0001\u0010\u0097\u0001J\u0018\u0010\u0098\u0001\u001a\u00020\u0000H\u0086\u0002\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0005\b\u0099\u0001\u0010\u0005JK\u0010\u009a\u0001\u001a\u00030\u009b\u0001*\b0\u009c\u0001j\u0003`\u009d\u00012\u0007\u0010\u009e\u0001\u001a\u00020\t2\u0007\u0010\u009f\u0001\u001a\u00020\t2\u0007\u0010\u00a0\u0001\u001a\u00020\t2\b\u0010\u0083\u0001\u001a\u00030\u008a\u00012\u0007\u0010\u00a1\u0001\u001a\u00020UH\u0002\u00a2\u0006\u0006\b\u00a2\u0001\u0010\u00a3\u0001R\u0017\u0010\u0006\u001a\u00020\u00008F\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u001a\u0010\b\u001a\u00020\t8@X\u0081\u0004\u00a2\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000f8FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000f8FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000f8FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u000f8FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\u0012R\u001a\u0010\u001c\u001a\u00020\u000f8FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\u0012R\u001a\u0010\u001f\u001a\u00020\u000f8FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\u0012R\u001a\u0010\"\u001a\u00020\u000f8FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\u0012R\u0011\u0010%\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b&\u0010\u0005R\u0011\u0010'\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b(\u0010\u0005R\u0011\u0010)\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b*\u0010\u0005R\u0011\u0010+\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b,\u0010\u0005R\u0011\u0010-\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b.\u0010\u0005R\u0011\u0010/\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b0\u0010\u0005R\u0011\u00101\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b2\u0010\u0005R\u001a\u00103\u001a\u00020\t8@X\u0081\u0004\u00a2\u0006\f\u0012\u0004\b4\u0010\u000b\u001a\u0004\b5\u0010\rR\u001a\u00106\u001a\u00020\t8@X\u0081\u0004\u00a2\u0006\f\u0012\u0004\b7\u0010\u000b\u001a\u0004\b8\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u00109\u001a\u00020\t8@X\u0081\u0004\u00a2\u0006\f\u0012\u0004\b:\u0010\u000b\u001a\u0004\b;\u0010\rR\u0014\u0010<\u001a\u00020=8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b>\u0010?R\u0015\u0010@\u001a\u00020\t8\u00c2\u0002X\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bA\u0010\rR\u0014\u0010B\u001a\u00020\u00038BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bC\u0010\u0005\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u00f8\u0001\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b\u009920\u0001\u00a8\u0006\u00a5\u0001"}, d2 = {"Lkotlin/time/Duration;", "", "rawValue", "", "constructor-impl", "(J)J", "absoluteValue", "getAbsoluteValue-UwyO8pc", "hoursComponent", "", "getHoursComponent$annotations", "()V", "getHoursComponent-impl", "(J)I", "inDays", "", "getInDays$annotations", "getInDays-impl", "(J)D", "inHours", "getInHours$annotations", "getInHours-impl", "inMicroseconds", "getInMicroseconds$annotations", "getInMicroseconds-impl", "inMilliseconds", "getInMilliseconds$annotations", "getInMilliseconds-impl", "inMinutes", "getInMinutes$annotations", "getInMinutes-impl", "inNanoseconds", "getInNanoseconds$annotations", "getInNanoseconds-impl", "inSeconds", "getInSeconds$annotations", "getInSeconds-impl", "inWholeDays", "getInWholeDays-impl", "inWholeHours", "getInWholeHours-impl", "inWholeMicroseconds", "getInWholeMicroseconds-impl", "inWholeMilliseconds", "getInWholeMilliseconds-impl", "inWholeMinutes", "getInWholeMinutes-impl", "inWholeNanoseconds", "getInWholeNanoseconds-impl", "inWholeSeconds", "getInWholeSeconds-impl", "minutesComponent", "getMinutesComponent$annotations", "getMinutesComponent-impl", "nanosecondsComponent", "getNanosecondsComponent$annotations", "getNanosecondsComponent-impl", "secondsComponent", "getSecondsComponent$annotations", "getSecondsComponent-impl", "storageUnit", "Lkotlin/time/DurationUnit;", "getStorageUnit-impl", "(J)Lkotlin/time/DurationUnit;", "unitDiscriminator", "getUnitDiscriminator-impl", "value", "getValue-impl", "addValuesMixedRanges", "thisMillis", "otherNanos", "addValuesMixedRanges-UwyO8pc", "(JJJ)J", "compareTo", "other", "compareTo-LRDsOJo", "(JJ)I", "div", "scale", "div-UwyO8pc", "(JD)J", "(JI)J", "div-LRDsOJo", "(JJ)D", "equals", "", "", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "isFinite", "isFinite-impl", "(J)Z", "isInMillis", "isInMillis-impl", "isInNanos", "isInNanos-impl", "isInfinite", "isInfinite-impl", "isNegative", "isNegative-impl", "isPositive", "isPositive-impl", "minus", "minus-LRDsOJo", "(JJ)J", QCircleDaTongConstant.ElementParamValue.PLUS, "plus-LRDsOJo", Element.ELEMENT_NAME_TIMES, "times-UwyO8pc", "toComponents", "T", "action", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "days", "hours", TuxTimeView.TUX_TIME_STYLE_MINUTES, "seconds", "nanoseconds", "toComponents-impl", "(JLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "Lkotlin/Function4;", "(JLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lkotlin/Function3;", "(JLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlin/Function2;", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "toDouble", "unit", "toDouble-impl", "(JLkotlin/time/DurationUnit;)D", "toInt", "toInt-impl", "(JLkotlin/time/DurationUnit;)I", "toIsoString", "", "toIsoString-impl", "(J)Ljava/lang/String;", "toLong", "toLong-impl", "(JLkotlin/time/DurationUnit;)J", "toLongMilliseconds", "toLongMilliseconds-impl", "toLongNanoseconds", "toLongNanoseconds-impl", "toString", "toString-impl", "decimals", "(JLkotlin/time/DurationUnit;I)Ljava/lang/String;", "unaryMinus", "unaryMinus-UwyO8pc", "appendFractional", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "whole", "fractional", "fractionalSize", "isoZeroes", "appendFractional-impl", "(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
@JvmInline
@WasExperimental(markerClass = {ExperimentalTime.class})
/* loaded from: classes28.dex */
public final class Duration implements Comparable<Duration> {
    private final long rawValue;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final long ZERO = m1826constructorimpl(0);
    private static final long INFINITE = DurationKt.access$durationOfMillis(DurationKt.MAX_MILLIS);
    private static final long NEG_INFINITE = DurationKt.access$durationOfMillis(-4611686018427387903L);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-H\u0007J\u001d\u0010\f\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b/\u0010\u0011J\u001d\u0010\f\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b/\u0010\u0014J\u001d\u0010\f\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b/\u0010\u0017J\u001d\u0010\u0018\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b0\u0010\u0011J\u001d\u0010\u0018\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b0\u0010\u0014J\u001d\u0010\u0018\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b0\u0010\u0017J\u001d\u0010\u001b\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b1\u0010\u0011J\u001d\u0010\u001b\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b1\u0010\u0014J\u001d\u0010\u001b\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b1\u0010\u0017J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b2\u0010\u0011J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b2\u0010\u0014J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b2\u0010\u0017J\u001d\u0010!\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b3\u0010\u0011J\u001d\u0010!\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b3\u0010\u0014J\u001d\u0010!\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b3\u0010\u0017J\u001d\u0010$\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b4\u0010\u0011J\u001d\u0010$\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b4\u0010\u0014J\u001d\u0010$\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b4\u0010\u0017J\u001b\u00105\u001a\u00020\u00042\u0006\u0010+\u001a\u000206\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b7\u00108J\u001b\u00109\u001a\u00020\u00042\u0006\u0010+\u001a\u000206\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b:\u00108J\u001b\u0010;\u001a\u0004\u0018\u00010\u00042\u0006\u0010+\u001a\u000206\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0002\b<J\u001b\u0010=\u001a\u0004\u0018\u00010\u00042\u0006\u0010+\u001a\u000206\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0002\b>J\u001d\u0010'\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\rH\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b?\u0010\u0011J\u001d\u0010'\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0012H\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b?\u0010\u0014J\u001d\u0010'\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0015H\u0007\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b?\u0010\u0017R\u0019\u0010\u0003\u001a\u00020\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004X\u0080\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R%\u0010\f\u001a\u00020\u0004*\u00020\r8\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R%\u0010\f\u001a\u00020\u0004*\u00020\u00128\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\b\u000e\u0010\u0013\u001a\u0004\b\u0010\u0010\u0014R%\u0010\f\u001a\u00020\u0004*\u00020\u00158\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\b\u000e\u0010\u0016\u001a\u0004\b\u0010\u0010\u0017R%\u0010\u0018\u001a\u00020\u0004*\u00020\r8\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011R%\u0010\u0018\u001a\u00020\u0004*\u00020\u00128\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0014R%\u0010\u0018\u001a\u00020\u0004*\u00020\u00158\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0017R%\u0010\u001b\u001a\u00020\u0004*\u00020\r8\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u0011R%\u0010\u001b\u001a\u00020\u0004*\u00020\u00128\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u0014R%\u0010\u001b\u001a\u00020\u0004*\u00020\u00158\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0017R%\u0010\u001e\u001a\u00020\u0004*\u00020\r8\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\b\u001f\u0010\u000f\u001a\u0004\b \u0010\u0011R%\u0010\u001e\u001a\u00020\u0004*\u00020\u00128\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\b\u001f\u0010\u0013\u001a\u0004\b \u0010\u0014R%\u0010\u001e\u001a\u00020\u0004*\u00020\u00158\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u0017R%\u0010!\u001a\u00020\u0004*\u00020\r8\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\b\"\u0010\u000f\u001a\u0004\b#\u0010\u0011R%\u0010!\u001a\u00020\u0004*\u00020\u00128\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\b\"\u0010\u0013\u001a\u0004\b#\u0010\u0014R%\u0010!\u001a\u00020\u0004*\u00020\u00158\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\b\"\u0010\u0016\u001a\u0004\b#\u0010\u0017R%\u0010$\u001a\u00020\u0004*\u00020\r8\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\b%\u0010\u000f\u001a\u0004\b&\u0010\u0011R%\u0010$\u001a\u00020\u0004*\u00020\u00128\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\b%\u0010\u0013\u001a\u0004\b&\u0010\u0014R%\u0010$\u001a\u00020\u0004*\u00020\u00158\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\b%\u0010\u0016\u001a\u0004\b&\u0010\u0017R%\u0010'\u001a\u00020\u0004*\u00020\r8\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\b(\u0010\u000f\u001a\u0004\b)\u0010\u0011R%\u0010'\u001a\u00020\u0004*\u00020\u00128\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\b(\u0010\u0013\u001a\u0004\b)\u0010\u0014R%\u0010'\u001a\u00020\u0004*\u00020\u00158\u00c6\u0002X\u0087\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\u0012\u0004\b(\u0010\u0016\u001a\u0004\b)\u0010\u0017\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006@"}, d2 = {"Lkotlin/time/Duration$Companion;", "", "()V", "INFINITE", "Lkotlin/time/Duration;", "getINFINITE-UwyO8pc", "()J", "J", "NEG_INFINITE", "getNEG_INFINITE-UwyO8pc$kotlin_stdlib", "ZERO", "getZERO-UwyO8pc", "days", "", "getDays-UwyO8pc$annotations", "(D)V", "getDays-UwyO8pc", "(D)J", "", "(I)V", "(I)J", "", "(J)V", "(J)J", "hours", "getHours-UwyO8pc$annotations", "getHours-UwyO8pc", "microseconds", "getMicroseconds-UwyO8pc$annotations", "getMicroseconds-UwyO8pc", "milliseconds", "getMilliseconds-UwyO8pc$annotations", "getMilliseconds-UwyO8pc", TuxTimeView.TUX_TIME_STYLE_MINUTES, "getMinutes-UwyO8pc$annotations", "getMinutes-UwyO8pc", "nanoseconds", "getNanoseconds-UwyO8pc$annotations", "getNanoseconds-UwyO8pc", "seconds", "getSeconds-UwyO8pc$annotations", "getSeconds-UwyO8pc", "convert", "value", "sourceUnit", "Lkotlin/time/DurationUnit;", "targetUnit", "days-UwyO8pc", "hours-UwyO8pc", "microseconds-UwyO8pc", "milliseconds-UwyO8pc", "minutes-UwyO8pc", "nanoseconds-UwyO8pc", "parse", "", "parse-UwyO8pc", "(Ljava/lang/String;)J", "parseIsoString", "parseIsoString-UwyO8pc", "parseIsoStringOrNull", "parseIsoStringOrNull-FghU774", "parseOrNull", "parseOrNull-FghU774", "seconds-UwyO8pc", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getDays-UwyO8pc, reason: not valid java name */
        private final long m1882getDaysUwyO8pc(int i3) {
            return DurationKt.toDuration(i3, DurationUnit.DAYS);
        }

        @InlineOnly
        /* renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1884getDaysUwyO8pc$annotations(double d16) {
        }

        /* renamed from: getHours-UwyO8pc, reason: not valid java name */
        private final long m1888getHoursUwyO8pc(int i3) {
            return DurationKt.toDuration(i3, DurationUnit.HOURS);
        }

        @InlineOnly
        /* renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1890getHoursUwyO8pc$annotations(double d16) {
        }

        /* renamed from: getMicroseconds-UwyO8pc, reason: not valid java name */
        private final long m1894getMicrosecondsUwyO8pc(int i3) {
            return DurationKt.toDuration(i3, DurationUnit.MICROSECONDS);
        }

        @InlineOnly
        /* renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1896getMicrosecondsUwyO8pc$annotations(double d16) {
        }

        /* renamed from: getMilliseconds-UwyO8pc, reason: not valid java name */
        private final long m1900getMillisecondsUwyO8pc(int i3) {
            return DurationKt.toDuration(i3, DurationUnit.MILLISECONDS);
        }

        @InlineOnly
        /* renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1902getMillisecondsUwyO8pc$annotations(double d16) {
        }

        /* renamed from: getMinutes-UwyO8pc, reason: not valid java name */
        private final long m1906getMinutesUwyO8pc(int i3) {
            return DurationKt.toDuration(i3, DurationUnit.MINUTES);
        }

        @InlineOnly
        /* renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1908getMinutesUwyO8pc$annotations(double d16) {
        }

        /* renamed from: getNanoseconds-UwyO8pc, reason: not valid java name */
        private final long m1912getNanosecondsUwyO8pc(int i3) {
            return DurationKt.toDuration(i3, DurationUnit.NANOSECONDS);
        }

        @InlineOnly
        /* renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1914getNanosecondsUwyO8pc$annotations(double d16) {
        }

        /* renamed from: getSeconds-UwyO8pc, reason: not valid java name */
        private final long m1918getSecondsUwyO8pc(int i3) {
            return DurationKt.toDuration(i3, DurationUnit.SECONDS);
        }

        @InlineOnly
        /* renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1920getSecondsUwyO8pc$annotations(double d16) {
        }

        @ExperimentalTime
        public final double convert(double value, @NotNull DurationUnit sourceUnit, @NotNull DurationUnit targetUnit) {
            Intrinsics.checkNotNullParameter(sourceUnit, "sourceUnit");
            Intrinsics.checkNotNullParameter(targetUnit, "targetUnit");
            return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(value, sourceUnit, targetUnit);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: days-UwyO8pc, reason: not valid java name */
        public final long m1924daysUwyO8pc(int value) {
            return DurationKt.toDuration(value, DurationUnit.DAYS);
        }

        /* renamed from: getINFINITE-UwyO8pc, reason: not valid java name */
        public final long m1926getINFINITEUwyO8pc() {
            return Duration.INFINITE;
        }

        /* renamed from: getNEG_INFINITE-UwyO8pc$kotlin_stdlib, reason: not valid java name */
        public final long m1927getNEG_INFINITEUwyO8pc$kotlin_stdlib() {
            return Duration.NEG_INFINITE;
        }

        /* renamed from: getZERO-UwyO8pc, reason: not valid java name */
        public final long m1928getZEROUwyO8pc() {
            return Duration.ZERO;
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: hours-UwyO8pc, reason: not valid java name */
        public final long m1930hoursUwyO8pc(int value) {
            return DurationKt.toDuration(value, DurationUnit.HOURS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: microseconds-UwyO8pc, reason: not valid java name */
        public final long m1933microsecondsUwyO8pc(int value) {
            return DurationKt.toDuration(value, DurationUnit.MICROSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: milliseconds-UwyO8pc, reason: not valid java name */
        public final long m1936millisecondsUwyO8pc(int value) {
            return DurationKt.toDuration(value, DurationUnit.MILLISECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: minutes-UwyO8pc, reason: not valid java name */
        public final long m1939minutesUwyO8pc(int value) {
            return DurationKt.toDuration(value, DurationUnit.MINUTES);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: nanoseconds-UwyO8pc, reason: not valid java name */
        public final long m1942nanosecondsUwyO8pc(int value) {
            return DurationKt.toDuration(value, DurationUnit.NANOSECONDS);
        }

        /* renamed from: parse-UwyO8pc, reason: not valid java name */
        public final long m1944parseUwyO8pc(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                return DurationKt.access$parseDuration(value, false);
            } catch (IllegalArgumentException e16) {
                throw new IllegalArgumentException("Invalid duration string format: '" + value + "'.", e16);
            }
        }

        /* renamed from: parseIsoString-UwyO8pc, reason: not valid java name */
        public final long m1945parseIsoStringUwyO8pc(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                return DurationKt.access$parseDuration(value, true);
            } catch (IllegalArgumentException e16) {
                throw new IllegalArgumentException("Invalid ISO duration string format: '" + value + "'.", e16);
            }
        }

        @Nullable
        /* renamed from: parseIsoStringOrNull-FghU774, reason: not valid java name */
        public final Duration m1946parseIsoStringOrNullFghU774(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                return Duration.m1824boximpl(DurationKt.access$parseDuration(value, true));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        @Nullable
        /* renamed from: parseOrNull-FghU774, reason: not valid java name */
        public final Duration m1947parseOrNullFghU774(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                return Duration.m1824boximpl(DurationKt.access$parseDuration(value, false));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Int.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: seconds-UwyO8pc, reason: not valid java name */
        public final long m1949secondsUwyO8pc(int value) {
            return DurationKt.toDuration(value, DurationUnit.SECONDS);
        }

        Companion() {
        }

        /* renamed from: getDays-UwyO8pc, reason: not valid java name */
        private final long m1883getDaysUwyO8pc(long j3) {
            return DurationKt.toDuration(j3, DurationUnit.DAYS);
        }

        @InlineOnly
        /* renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1885getDaysUwyO8pc$annotations(int i3) {
        }

        /* renamed from: getHours-UwyO8pc, reason: not valid java name */
        private final long m1889getHoursUwyO8pc(long j3) {
            return DurationKt.toDuration(j3, DurationUnit.HOURS);
        }

        @InlineOnly
        /* renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1891getHoursUwyO8pc$annotations(int i3) {
        }

        /* renamed from: getMicroseconds-UwyO8pc, reason: not valid java name */
        private final long m1895getMicrosecondsUwyO8pc(long j3) {
            return DurationKt.toDuration(j3, DurationUnit.MICROSECONDS);
        }

        @InlineOnly
        /* renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1897getMicrosecondsUwyO8pc$annotations(int i3) {
        }

        /* renamed from: getMilliseconds-UwyO8pc, reason: not valid java name */
        private final long m1901getMillisecondsUwyO8pc(long j3) {
            return DurationKt.toDuration(j3, DurationUnit.MILLISECONDS);
        }

        @InlineOnly
        /* renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1903getMillisecondsUwyO8pc$annotations(int i3) {
        }

        /* renamed from: getMinutes-UwyO8pc, reason: not valid java name */
        private final long m1907getMinutesUwyO8pc(long j3) {
            return DurationKt.toDuration(j3, DurationUnit.MINUTES);
        }

        @InlineOnly
        /* renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1909getMinutesUwyO8pc$annotations(int i3) {
        }

        /* renamed from: getNanoseconds-UwyO8pc, reason: not valid java name */
        private final long m1913getNanosecondsUwyO8pc(long j3) {
            return DurationKt.toDuration(j3, DurationUnit.NANOSECONDS);
        }

        @InlineOnly
        /* renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1915getNanosecondsUwyO8pc$annotations(int i3) {
        }

        /* renamed from: getSeconds-UwyO8pc, reason: not valid java name */
        private final long m1919getSecondsUwyO8pc(long j3) {
            return DurationKt.toDuration(j3, DurationUnit.SECONDS);
        }

        @InlineOnly
        /* renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1921getSecondsUwyO8pc$annotations(int i3) {
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: days-UwyO8pc, reason: not valid java name */
        public final long m1925daysUwyO8pc(long value) {
            return DurationKt.toDuration(value, DurationUnit.DAYS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: hours-UwyO8pc, reason: not valid java name */
        public final long m1931hoursUwyO8pc(long value) {
            return DurationKt.toDuration(value, DurationUnit.HOURS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: microseconds-UwyO8pc, reason: not valid java name */
        public final long m1934microsecondsUwyO8pc(long value) {
            return DurationKt.toDuration(value, DurationUnit.MICROSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: milliseconds-UwyO8pc, reason: not valid java name */
        public final long m1937millisecondsUwyO8pc(long value) {
            return DurationKt.toDuration(value, DurationUnit.MILLISECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: minutes-UwyO8pc, reason: not valid java name */
        public final long m1940minutesUwyO8pc(long value) {
            return DurationKt.toDuration(value, DurationUnit.MINUTES);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: nanoseconds-UwyO8pc, reason: not valid java name */
        public final long m1943nanosecondsUwyO8pc(long value) {
            return DurationKt.toDuration(value, DurationUnit.NANOSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Long.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: seconds-UwyO8pc, reason: not valid java name */
        public final long m1950secondsUwyO8pc(long value) {
            return DurationKt.toDuration(value, DurationUnit.SECONDS);
        }

        /* renamed from: getDays-UwyO8pc, reason: not valid java name */
        private final long m1881getDaysUwyO8pc(double d16) {
            return DurationKt.toDuration(d16, DurationUnit.DAYS);
        }

        @InlineOnly
        /* renamed from: getDays-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1886getDaysUwyO8pc$annotations(long j3) {
        }

        /* renamed from: getHours-UwyO8pc, reason: not valid java name */
        private final long m1887getHoursUwyO8pc(double d16) {
            return DurationKt.toDuration(d16, DurationUnit.HOURS);
        }

        @InlineOnly
        /* renamed from: getHours-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1892getHoursUwyO8pc$annotations(long j3) {
        }

        /* renamed from: getMicroseconds-UwyO8pc, reason: not valid java name */
        private final long m1893getMicrosecondsUwyO8pc(double d16) {
            return DurationKt.toDuration(d16, DurationUnit.MICROSECONDS);
        }

        @InlineOnly
        /* renamed from: getMicroseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1898getMicrosecondsUwyO8pc$annotations(long j3) {
        }

        /* renamed from: getMilliseconds-UwyO8pc, reason: not valid java name */
        private final long m1899getMillisecondsUwyO8pc(double d16) {
            return DurationKt.toDuration(d16, DurationUnit.MILLISECONDS);
        }

        @InlineOnly
        /* renamed from: getMilliseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1904getMillisecondsUwyO8pc$annotations(long j3) {
        }

        /* renamed from: getMinutes-UwyO8pc, reason: not valid java name */
        private final long m1905getMinutesUwyO8pc(double d16) {
            return DurationKt.toDuration(d16, DurationUnit.MINUTES);
        }

        @InlineOnly
        /* renamed from: getMinutes-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1910getMinutesUwyO8pc$annotations(long j3) {
        }

        /* renamed from: getNanoseconds-UwyO8pc, reason: not valid java name */
        private final long m1911getNanosecondsUwyO8pc(double d16) {
            return DurationKt.toDuration(d16, DurationUnit.NANOSECONDS);
        }

        @InlineOnly
        /* renamed from: getNanoseconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1916getNanosecondsUwyO8pc$annotations(long j3) {
        }

        /* renamed from: getSeconds-UwyO8pc, reason: not valid java name */
        private final long m1917getSecondsUwyO8pc(double d16) {
            return DurationKt.toDuration(d16, DurationUnit.SECONDS);
        }

        @InlineOnly
        /* renamed from: getSeconds-UwyO8pc$annotations, reason: not valid java name */
        public static /* synthetic */ void m1922getSecondsUwyO8pc$annotations(long j3) {
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.days", imports = {"kotlin.time.Duration.Companion.days"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: days-UwyO8pc, reason: not valid java name */
        public final long m1923daysUwyO8pc(double value) {
            return DurationKt.toDuration(value, DurationUnit.DAYS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: hours-UwyO8pc, reason: not valid java name */
        public final long m1929hoursUwyO8pc(double value) {
            return DurationKt.toDuration(value, DurationUnit.HOURS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: microseconds-UwyO8pc, reason: not valid java name */
        public final long m1932microsecondsUwyO8pc(double value) {
            return DurationKt.toDuration(value, DurationUnit.MICROSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: milliseconds-UwyO8pc, reason: not valid java name */
        public final long m1935millisecondsUwyO8pc(double value) {
            return DurationKt.toDuration(value, DurationUnit.MILLISECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: minutes-UwyO8pc, reason: not valid java name */
        public final long m1938minutesUwyO8pc(double value) {
            return DurationKt.toDuration(value, DurationUnit.MINUTES);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: nanoseconds-UwyO8pc, reason: not valid java name */
        public final long m1941nanosecondsUwyO8pc(double value) {
            return DurationKt.toDuration(value, DurationUnit.NANOSECONDS);
        }

        @SinceKotlin(version = "1.5")
        @Deprecated(message = "Use 'Double.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(expression = "value.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
        @DeprecatedSinceKotlin(warningSince = "1.6")
        @ExperimentalTime
        /* renamed from: seconds-UwyO8pc, reason: not valid java name */
        public final long m1948secondsUwyO8pc(double value) {
            return DurationKt.toDuration(value, DurationUnit.SECONDS);
        }
    }

    /* synthetic */ Duration(long j3) {
        this.rawValue = j3;
    }

    /* renamed from: addValuesMixedRanges-UwyO8pc, reason: not valid java name */
    private static final long m1822addValuesMixedRangesUwyO8pc(long j3, long j16, long j17) {
        long coerceIn;
        long access$nanosToMillis = DurationKt.access$nanosToMillis(j17);
        long j18 = j16 + access$nanosToMillis;
        if (!new LongRange(-4611686018426L, 4611686018426L).contains(j18)) {
            coerceIn = RangesKt___RangesKt.coerceIn(j18, -4611686018427387903L, DurationKt.MAX_MILLIS);
            return DurationKt.access$durationOfMillis(coerceIn);
        }
        return DurationKt.access$durationOfNanos(DurationKt.access$millisToNanos(j18) + (j17 - DurationKt.access$millisToNanos(access$nanosToMillis)));
    }

    /* renamed from: appendFractional-impl, reason: not valid java name */
    private static final void m1823appendFractionalimpl(long j3, StringBuilder sb5, int i3, int i16, int i17, String str, boolean z16) {
        String padStart;
        boolean z17;
        sb5.append(i3);
        if (i16 != 0) {
            sb5.append('.');
            padStart = StringsKt__StringsKt.padStart(String.valueOf(i16), i17, '0');
            int i18 = -1;
            int length = padStart.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i19 = length - 1;
                    if (padStart.charAt(length) != '0') {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        i18 = length;
                        break;
                    } else if (i19 < 0) {
                        break;
                    } else {
                        length = i19;
                    }
                }
            }
            int i26 = i18 + 1;
            if (!z16 && i26 < 3) {
                sb5.append((CharSequence) padStart, 0, i26);
                Intrinsics.checkNotNullExpressionValue(sb5, "this.append(value, startIndex, endIndex)");
            } else {
                sb5.append((CharSequence) padStart, 0, ((i26 + 2) / 3) * 3);
                Intrinsics.checkNotNullExpressionValue(sb5, "this.append(value, startIndex, endIndex)");
            }
        }
        sb5.append(str);
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Duration m1824boximpl(long j3) {
        return new Duration(j3);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m1826constructorimpl(long j3) {
        if (DurationJvmKt.getDurationAssertionsEnabled()) {
            if (m1857isInNanosimpl(j3)) {
                if (!new LongRange(-4611686018426999999L, DurationKt.MAX_NANOS).contains(m1853getValueimpl(j3))) {
                    throw new AssertionError(m1853getValueimpl(j3) + " ns is out of nanoseconds range");
                }
            } else if (new LongRange(-4611686018427387903L, DurationKt.MAX_MILLIS).contains(m1853getValueimpl(j3))) {
                if (new LongRange(-4611686018426L, 4611686018426L).contains(m1853getValueimpl(j3))) {
                    throw new AssertionError(m1853getValueimpl(j3) + " ms is denormalized");
                }
            } else {
                throw new AssertionError(m1853getValueimpl(j3) + " ms is out of milliseconds range");
            }
        }
        return j3;
    }

    /* renamed from: div-LRDsOJo, reason: not valid java name */
    public static final double m1827divLRDsOJo(long j3, long j16) {
        Comparable maxOf;
        maxOf = ComparisonsKt___ComparisonsJvmKt.maxOf(m1851getStorageUnitimpl(j3), m1851getStorageUnitimpl(j16));
        DurationUnit durationUnit = (DurationUnit) maxOf;
        return m1869toDoubleimpl(j3, durationUnit) / m1869toDoubleimpl(j16, durationUnit);
    }

    /* renamed from: div-UwyO8pc, reason: not valid java name */
    public static final long m1829divUwyO8pc(long j3, int i3) {
        int sign;
        if (i3 == 0) {
            if (m1860isPositiveimpl(j3)) {
                return INFINITE;
            }
            if (m1859isNegativeimpl(j3)) {
                return NEG_INFINITE;
            }
            throw new IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
        }
        if (m1857isInNanosimpl(j3)) {
            return DurationKt.access$durationOfNanos(m1853getValueimpl(j3) / i3);
        }
        if (m1858isInfiniteimpl(j3)) {
            sign = MathKt__MathJVMKt.getSign(i3);
            return m1864timesUwyO8pc(j3, sign);
        }
        long j16 = i3;
        long m1853getValueimpl = m1853getValueimpl(j3) / j16;
        if (new LongRange(-4611686018426L, 4611686018426L).contains(m1853getValueimpl)) {
            return DurationKt.access$durationOfNanos(DurationKt.access$millisToNanos(m1853getValueimpl) + (DurationKt.access$millisToNanos(m1853getValueimpl(j3) - (m1853getValueimpl * j16)) / j16));
        }
        return DurationKt.access$durationOfMillis(m1853getValueimpl);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1830equalsimpl(long j3, Object obj) {
        if (!(obj instanceof Duration) || j3 != ((Duration) obj).getRawValue()) {
            return false;
        }
        return true;
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1831equalsimpl0(long j3, long j16) {
        if (j3 == j16) {
            return true;
        }
        return false;
    }

    /* renamed from: getAbsoluteValue-UwyO8pc, reason: not valid java name */
    public static final long m1832getAbsoluteValueUwyO8pc(long j3) {
        if (m1859isNegativeimpl(j3)) {
            return m1878unaryMinusUwyO8pc(j3);
        }
        return j3;
    }

    /* renamed from: getHoursComponent-impl, reason: not valid java name */
    public static final int m1833getHoursComponentimpl(long j3) {
        if (m1858isInfiniteimpl(j3)) {
            return 0;
        }
        return (int) (m1842getInWholeHoursimpl(j3) % 24);
    }

    /* renamed from: getInDays-impl, reason: not valid java name */
    public static final double m1834getInDaysimpl(long j3) {
        return m1869toDoubleimpl(j3, DurationUnit.DAYS);
    }

    /* renamed from: getInHours-impl, reason: not valid java name */
    public static final double m1835getInHoursimpl(long j3) {
        return m1869toDoubleimpl(j3, DurationUnit.HOURS);
    }

    /* renamed from: getInMicroseconds-impl, reason: not valid java name */
    public static final double m1836getInMicrosecondsimpl(long j3) {
        return m1869toDoubleimpl(j3, DurationUnit.MICROSECONDS);
    }

    /* renamed from: getInMilliseconds-impl, reason: not valid java name */
    public static final double m1837getInMillisecondsimpl(long j3) {
        return m1869toDoubleimpl(j3, DurationUnit.MILLISECONDS);
    }

    /* renamed from: getInMinutes-impl, reason: not valid java name */
    public static final double m1838getInMinutesimpl(long j3) {
        return m1869toDoubleimpl(j3, DurationUnit.MINUTES);
    }

    /* renamed from: getInNanoseconds-impl, reason: not valid java name */
    public static final double m1839getInNanosecondsimpl(long j3) {
        return m1869toDoubleimpl(j3, DurationUnit.NANOSECONDS);
    }

    /* renamed from: getInSeconds-impl, reason: not valid java name */
    public static final double m1840getInSecondsimpl(long j3) {
        return m1869toDoubleimpl(j3, DurationUnit.SECONDS);
    }

    /* renamed from: getInWholeDays-impl, reason: not valid java name */
    public static final long m1841getInWholeDaysimpl(long j3) {
        return m1872toLongimpl(j3, DurationUnit.DAYS);
    }

    /* renamed from: getInWholeHours-impl, reason: not valid java name */
    public static final long m1842getInWholeHoursimpl(long j3) {
        return m1872toLongimpl(j3, DurationUnit.HOURS);
    }

    /* renamed from: getInWholeMicroseconds-impl, reason: not valid java name */
    public static final long m1843getInWholeMicrosecondsimpl(long j3) {
        return m1872toLongimpl(j3, DurationUnit.MICROSECONDS);
    }

    /* renamed from: getInWholeMilliseconds-impl, reason: not valid java name */
    public static final long m1844getInWholeMillisecondsimpl(long j3) {
        if (m1856isInMillisimpl(j3) && m1855isFiniteimpl(j3)) {
            return m1853getValueimpl(j3);
        }
        return m1872toLongimpl(j3, DurationUnit.MILLISECONDS);
    }

    /* renamed from: getInWholeMinutes-impl, reason: not valid java name */
    public static final long m1845getInWholeMinutesimpl(long j3) {
        return m1872toLongimpl(j3, DurationUnit.MINUTES);
    }

    /* renamed from: getInWholeNanoseconds-impl, reason: not valid java name */
    public static final long m1846getInWholeNanosecondsimpl(long j3) {
        long m1853getValueimpl = m1853getValueimpl(j3);
        if (!m1857isInNanosimpl(j3)) {
            if (m1853getValueimpl > 9223372036854L) {
                return Long.MAX_VALUE;
            }
            if (m1853getValueimpl < -9223372036854L) {
                return Long.MIN_VALUE;
            }
            return DurationKt.access$millisToNanos(m1853getValueimpl);
        }
        return m1853getValueimpl;
    }

    /* renamed from: getInWholeSeconds-impl, reason: not valid java name */
    public static final long m1847getInWholeSecondsimpl(long j3) {
        return m1872toLongimpl(j3, DurationUnit.SECONDS);
    }

    /* renamed from: getMinutesComponent-impl, reason: not valid java name */
    public static final int m1848getMinutesComponentimpl(long j3) {
        if (m1858isInfiniteimpl(j3)) {
            return 0;
        }
        return (int) (m1845getInWholeMinutesimpl(j3) % 60);
    }

    /* renamed from: getNanosecondsComponent-impl, reason: not valid java name */
    public static final int m1849getNanosecondsComponentimpl(long j3) {
        long m1853getValueimpl;
        if (m1858isInfiniteimpl(j3)) {
            return 0;
        }
        if (m1856isInMillisimpl(j3)) {
            m1853getValueimpl = DurationKt.access$millisToNanos(m1853getValueimpl(j3) % 1000);
        } else {
            m1853getValueimpl = m1853getValueimpl(j3) % 1000000000;
        }
        return (int) m1853getValueimpl;
    }

    /* renamed from: getSecondsComponent-impl, reason: not valid java name */
    public static final int m1850getSecondsComponentimpl(long j3) {
        if (m1858isInfiniteimpl(j3)) {
            return 0;
        }
        return (int) (m1847getInWholeSecondsimpl(j3) % 60);
    }

    /* renamed from: getStorageUnit-impl, reason: not valid java name */
    private static final DurationUnit m1851getStorageUnitimpl(long j3) {
        if (m1857isInNanosimpl(j3)) {
            return DurationUnit.NANOSECONDS;
        }
        return DurationUnit.MILLISECONDS;
    }

    /* renamed from: getUnitDiscriminator-impl, reason: not valid java name */
    private static final int m1852getUnitDiscriminatorimpl(long j3) {
        return ((int) j3) & 1;
    }

    /* renamed from: getValue-impl, reason: not valid java name */
    private static final long m1853getValueimpl(long j3) {
        return j3 >> 1;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1854hashCodeimpl(long j3) {
        return (int) (j3 ^ (j3 >>> 32));
    }

    /* renamed from: isFinite-impl, reason: not valid java name */
    public static final boolean m1855isFiniteimpl(long j3) {
        return !m1858isInfiniteimpl(j3);
    }

    /* renamed from: isInMillis-impl, reason: not valid java name */
    private static final boolean m1856isInMillisimpl(long j3) {
        if ((((int) j3) & 1) == 1) {
            return true;
        }
        return false;
    }

    /* renamed from: isInNanos-impl, reason: not valid java name */
    private static final boolean m1857isInNanosimpl(long j3) {
        if ((((int) j3) & 1) == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: isInfinite-impl, reason: not valid java name */
    public static final boolean m1858isInfiniteimpl(long j3) {
        if (j3 != INFINITE && j3 != NEG_INFINITE) {
            return false;
        }
        return true;
    }

    /* renamed from: isNegative-impl, reason: not valid java name */
    public static final boolean m1859isNegativeimpl(long j3) {
        if (j3 < 0) {
            return true;
        }
        return false;
    }

    /* renamed from: isPositive-impl, reason: not valid java name */
    public static final boolean m1860isPositiveimpl(long j3) {
        if (j3 > 0) {
            return true;
        }
        return false;
    }

    /* renamed from: minus-LRDsOJo, reason: not valid java name */
    public static final long m1861minusLRDsOJo(long j3, long j16) {
        return m1862plusLRDsOJo(j3, m1878unaryMinusUwyO8pc(j16));
    }

    /* renamed from: plus-LRDsOJo, reason: not valid java name */
    public static final long m1862plusLRDsOJo(long j3, long j16) {
        if (m1858isInfiniteimpl(j3)) {
            if (!m1855isFiniteimpl(j16) && (j16 ^ j3) < 0) {
                throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
            }
            return j3;
        }
        if (m1858isInfiniteimpl(j16)) {
            return j16;
        }
        if ((((int) j3) & 1) == (((int) j16) & 1)) {
            long m1853getValueimpl = m1853getValueimpl(j3) + m1853getValueimpl(j16);
            if (m1857isInNanosimpl(j3)) {
                return DurationKt.access$durationOfNanosNormalized(m1853getValueimpl);
            }
            return DurationKt.access$durationOfMillisNormalized(m1853getValueimpl);
        }
        if (m1856isInMillisimpl(j3)) {
            return m1822addValuesMixedRangesUwyO8pc(j3, m1853getValueimpl(j3), m1853getValueimpl(j16));
        }
        return m1822addValuesMixedRangesUwyO8pc(j3, m1853getValueimpl(j16), m1853getValueimpl(j3));
    }

    /* renamed from: times-UwyO8pc, reason: not valid java name */
    public static final long m1864timesUwyO8pc(long j3, int i3) {
        int sign;
        int sign2;
        long coerceIn;
        int sign3;
        int sign4;
        long coerceIn2;
        if (m1858isInfiniteimpl(j3)) {
            if (i3 != 0) {
                return i3 > 0 ? j3 : m1878unaryMinusUwyO8pc(j3);
            }
            throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
        }
        if (i3 == 0) {
            return ZERO;
        }
        long m1853getValueimpl = m1853getValueimpl(j3);
        long j16 = i3;
        long j17 = m1853getValueimpl * j16;
        if (!m1857isInNanosimpl(j3)) {
            if (j17 / j16 != m1853getValueimpl) {
                sign = MathKt__MathJVMKt.getSign(m1853getValueimpl);
                sign2 = MathKt__MathJVMKt.getSign(i3);
                return sign * sign2 > 0 ? INFINITE : NEG_INFINITE;
            }
            coerceIn = RangesKt___RangesKt.coerceIn(j17, (ClosedRange<Long>) new LongRange(-4611686018427387903L, DurationKt.MAX_MILLIS));
            return DurationKt.access$durationOfMillis(coerceIn);
        }
        if (new LongRange(-2147483647L, TTL.MAX_VALUE).contains(m1853getValueimpl)) {
            return DurationKt.access$durationOfNanos(j17);
        }
        if (j17 / j16 == m1853getValueimpl) {
            return DurationKt.access$durationOfNanosNormalized(j17);
        }
        long access$nanosToMillis = DurationKt.access$nanosToMillis(m1853getValueimpl);
        long j18 = access$nanosToMillis * j16;
        long access$nanosToMillis2 = DurationKt.access$nanosToMillis((m1853getValueimpl - DurationKt.access$millisToNanos(access$nanosToMillis)) * j16) + j18;
        if (j18 / j16 != access$nanosToMillis || (access$nanosToMillis2 ^ j18) < 0) {
            sign3 = MathKt__MathJVMKt.getSign(m1853getValueimpl);
            sign4 = MathKt__MathJVMKt.getSign(i3);
            return sign3 * sign4 > 0 ? INFINITE : NEG_INFINITE;
        }
        coerceIn2 = RangesKt___RangesKt.coerceIn(access$nanosToMillis2, (ClosedRange<Long>) new LongRange(-4611686018427387903L, DurationKt.MAX_MILLIS));
        return DurationKt.access$durationOfMillis(coerceIn2);
    }

    /* renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m1868toComponentsimpl(long j3, @NotNull Function5<? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Long.valueOf(m1841getInWholeDaysimpl(j3)), Integer.valueOf(m1833getHoursComponentimpl(j3)), Integer.valueOf(m1848getMinutesComponentimpl(j3)), Integer.valueOf(m1850getSecondsComponentimpl(j3)), Integer.valueOf(m1849getNanosecondsComponentimpl(j3)));
    }

    /* renamed from: toDouble-impl, reason: not valid java name */
    public static final double m1869toDoubleimpl(long j3, @NotNull DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j3 == INFINITE) {
            return Double.POSITIVE_INFINITY;
        }
        if (j3 == NEG_INFINITE) {
            return Double.NEGATIVE_INFINITY;
        }
        return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(m1853getValueimpl(j3), m1851getStorageUnitimpl(j3), unit);
    }

    /* renamed from: toInt-impl, reason: not valid java name */
    public static final int m1870toIntimpl(long j3, @NotNull DurationUnit unit) {
        long coerceIn;
        Intrinsics.checkNotNullParameter(unit, "unit");
        coerceIn = RangesKt___RangesKt.coerceIn(m1872toLongimpl(j3, unit), WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, TTL.MAX_VALUE);
        return (int) coerceIn;
    }

    @NotNull
    /* renamed from: toIsoString-impl, reason: not valid java name */
    public static final String m1871toIsoStringimpl(long j3) {
        boolean z16;
        boolean z17;
        StringBuilder sb5 = new StringBuilder();
        if (m1859isNegativeimpl(j3)) {
            sb5.append('-');
        }
        sb5.append("PT");
        long m1832getAbsoluteValueUwyO8pc = m1832getAbsoluteValueUwyO8pc(j3);
        long m1842getInWholeHoursimpl = m1842getInWholeHoursimpl(m1832getAbsoluteValueUwyO8pc);
        int m1848getMinutesComponentimpl = m1848getMinutesComponentimpl(m1832getAbsoluteValueUwyO8pc);
        int m1850getSecondsComponentimpl = m1850getSecondsComponentimpl(m1832getAbsoluteValueUwyO8pc);
        int m1849getNanosecondsComponentimpl = m1849getNanosecondsComponentimpl(m1832getAbsoluteValueUwyO8pc);
        if (m1858isInfiniteimpl(j3)) {
            m1842getInWholeHoursimpl = 9999999999999L;
        }
        boolean z18 = true;
        if (m1842getInWholeHoursimpl != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (m1850getSecondsComponentimpl == 0 && m1849getNanosecondsComponentimpl == 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (m1848getMinutesComponentimpl == 0 && (!z17 || !z16)) {
            z18 = false;
        }
        if (z16) {
            sb5.append(m1842getInWholeHoursimpl);
            sb5.append('H');
        }
        if (z18) {
            sb5.append(m1848getMinutesComponentimpl);
            sb5.append('M');
        }
        if (z17 || (!z16 && !z18)) {
            m1823appendFractionalimpl(j3, sb5, m1850getSecondsComponentimpl, m1849getNanosecondsComponentimpl, 9, ExifInterface.LATITUDE_SOUTH, true);
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
        return sb6;
    }

    /* renamed from: toLong-impl, reason: not valid java name */
    public static final long m1872toLongimpl(long j3, @NotNull DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j3 == INFINITE) {
            return Long.MAX_VALUE;
        }
        if (j3 == NEG_INFINITE) {
            return Long.MIN_VALUE;
        }
        return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(m1853getValueimpl(j3), m1851getStorageUnitimpl(j3), unit);
    }

    @Deprecated(message = "Use inWholeMilliseconds property instead.", replaceWith = @ReplaceWith(expression = "this.inWholeMilliseconds", imports = {}))
    @ExperimentalTime
    /* renamed from: toLongMilliseconds-impl, reason: not valid java name */
    public static final long m1873toLongMillisecondsimpl(long j3) {
        return m1844getInWholeMillisecondsimpl(j3);
    }

    @Deprecated(message = "Use inWholeNanoseconds property instead.", replaceWith = @ReplaceWith(expression = "this.inWholeNanoseconds", imports = {}))
    @ExperimentalTime
    /* renamed from: toLongNanoseconds-impl, reason: not valid java name */
    public static final long m1874toLongNanosecondsimpl(long j3) {
        return m1846getInWholeNanosecondsimpl(j3);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1875toStringimpl(long j3) {
        if (j3 == 0) {
            return "0s";
        }
        if (j3 == INFINITE) {
            return "Infinity";
        }
        if (j3 == NEG_INFINITE) {
            return "-Infinity";
        }
        boolean m1859isNegativeimpl = m1859isNegativeimpl(j3);
        StringBuilder sb5 = new StringBuilder();
        if (m1859isNegativeimpl) {
            sb5.append('-');
        }
        long m1832getAbsoluteValueUwyO8pc = m1832getAbsoluteValueUwyO8pc(j3);
        long m1841getInWholeDaysimpl = m1841getInWholeDaysimpl(m1832getAbsoluteValueUwyO8pc);
        int m1833getHoursComponentimpl = m1833getHoursComponentimpl(m1832getAbsoluteValueUwyO8pc);
        int m1848getMinutesComponentimpl = m1848getMinutesComponentimpl(m1832getAbsoluteValueUwyO8pc);
        int m1850getSecondsComponentimpl = m1850getSecondsComponentimpl(m1832getAbsoluteValueUwyO8pc);
        int m1849getNanosecondsComponentimpl = m1849getNanosecondsComponentimpl(m1832getAbsoluteValueUwyO8pc);
        int i3 = 0;
        boolean z16 = m1841getInWholeDaysimpl != 0;
        boolean z17 = m1833getHoursComponentimpl != 0;
        boolean z18 = m1848getMinutesComponentimpl != 0;
        boolean z19 = (m1850getSecondsComponentimpl == 0 && m1849getNanosecondsComponentimpl == 0) ? false : true;
        if (z16) {
            sb5.append(m1841getInWholeDaysimpl);
            sb5.append('d');
            i3 = 1;
        }
        if (z17 || (z16 && (z18 || z19))) {
            int i16 = i3 + 1;
            if (i3 > 0) {
                sb5.append(TokenParser.SP);
            }
            sb5.append(m1833getHoursComponentimpl);
            sb5.append('h');
            i3 = i16;
        }
        if (z18 || (z19 && (z17 || z16))) {
            int i17 = i3 + 1;
            if (i3 > 0) {
                sb5.append(TokenParser.SP);
            }
            sb5.append(m1848getMinutesComponentimpl);
            sb5.append('m');
            i3 = i17;
        }
        if (z19) {
            int i18 = i3 + 1;
            if (i3 > 0) {
                sb5.append(TokenParser.SP);
            }
            if (m1850getSecondsComponentimpl != 0 || z16 || z17 || z18) {
                m1823appendFractionalimpl(j3, sb5, m1850getSecondsComponentimpl, m1849getNanosecondsComponentimpl, 9, ReportConstant.COSTREPORT_PREFIX, false);
            } else if (m1849getNanosecondsComponentimpl >= 1000000) {
                m1823appendFractionalimpl(j3, sb5, m1849getNanosecondsComponentimpl / 1000000, m1849getNanosecondsComponentimpl % 1000000, 6, "ms", false);
            } else if (m1849getNanosecondsComponentimpl >= 1000) {
                m1823appendFractionalimpl(j3, sb5, m1849getNanosecondsComponentimpl / 1000, m1849getNanosecondsComponentimpl % 1000, 3, "us", false);
            } else {
                sb5.append(m1849getNanosecondsComponentimpl);
                sb5.append("ns");
            }
            i3 = i18;
        }
        if (m1859isNegativeimpl && i3 > 1) {
            sb5.insert(1, '(').append(')');
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
        return sb6;
    }

    /* renamed from: toString-impl$default, reason: not valid java name */
    public static /* synthetic */ String m1877toStringimpl$default(long j3, DurationUnit durationUnit, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        return m1876toStringimpl(j3, durationUnit, i3);
    }

    /* renamed from: unaryMinus-UwyO8pc, reason: not valid java name */
    public static final long m1878unaryMinusUwyO8pc(long j3) {
        return DurationKt.access$durationOf(-m1853getValueimpl(j3), ((int) j3) & 1);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Duration duration) {
        return m1879compareToLRDsOJo(duration.getRawValue());
    }

    /* renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public int m1879compareToLRDsOJo(long j3) {
        return m1825compareToLRDsOJo(this.rawValue, j3);
    }

    public boolean equals(Object obj) {
        return m1830equalsimpl(this.rawValue, obj);
    }

    public int hashCode() {
        return m1854hashCodeimpl(this.rawValue);
    }

    @NotNull
    public String toString() {
        return m1875toStringimpl(this.rawValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getRawValue() {
        return this.rawValue;
    }

    /* renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public static int m1825compareToLRDsOJo(long j3, long j16) {
        long j17 = j3 ^ j16;
        if (j17 < 0 || (((int) j17) & 1) == 0) {
            return Intrinsics.compare(j3, j16);
        }
        int i3 = (((int) j3) & 1) - (((int) j16) & 1);
        return m1859isNegativeimpl(j3) ? -i3 : i3;
    }

    /* renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m1867toComponentsimpl(long j3, @NotNull Function4<? super Long, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Long.valueOf(m1842getInWholeHoursimpl(j3)), Integer.valueOf(m1848getMinutesComponentimpl(j3)), Integer.valueOf(m1850getSecondsComponentimpl(j3)), Integer.valueOf(m1849getNanosecondsComponentimpl(j3)));
    }

    /* renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m1866toComponentsimpl(long j3, @NotNull Function3<? super Long, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Long.valueOf(m1845getInWholeMinutesimpl(j3)), Integer.valueOf(m1850getSecondsComponentimpl(j3)), Integer.valueOf(m1849getNanosecondsComponentimpl(j3)));
    }

    /* renamed from: toComponents-impl, reason: not valid java name */
    public static final <T> T m1865toComponentsimpl(long j3, @NotNull Function2<? super Long, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Long.valueOf(m1847getInWholeSecondsimpl(j3)), Integer.valueOf(m1849getNanosecondsComponentimpl(j3)));
    }

    /* renamed from: div-UwyO8pc, reason: not valid java name */
    public static final long m1828divUwyO8pc(long j3, double d16) {
        int roundToInt;
        roundToInt = MathKt__MathJVMKt.roundToInt(d16);
        if ((((double) roundToInt) == d16) && roundToInt != 0) {
            return m1829divUwyO8pc(j3, roundToInt);
        }
        DurationUnit m1851getStorageUnitimpl = m1851getStorageUnitimpl(j3);
        return DurationKt.toDuration(m1869toDoubleimpl(j3, m1851getStorageUnitimpl) / d16, m1851getStorageUnitimpl);
    }

    @PublishedApi
    public static /* synthetic */ void getHoursComponent$annotations() {
    }

    @Deprecated(message = "Use inWholeDays property instead or convert toDouble(DAYS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.DAYS)", imports = {}))
    @ExperimentalTime
    public static /* synthetic */ void getInDays$annotations() {
    }

    @Deprecated(message = "Use inWholeHours property instead or convert toDouble(HOURS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.HOURS)", imports = {}))
    @ExperimentalTime
    public static /* synthetic */ void getInHours$annotations() {
    }

    @Deprecated(message = "Use inWholeMicroseconds property instead or convert toDouble(MICROSECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MICROSECONDS)", imports = {}))
    @ExperimentalTime
    public static /* synthetic */ void getInMicroseconds$annotations() {
    }

    @Deprecated(message = "Use inWholeMilliseconds property instead or convert toDouble(MILLISECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MILLISECONDS)", imports = {}))
    @ExperimentalTime
    public static /* synthetic */ void getInMilliseconds$annotations() {
    }

    @Deprecated(message = "Use inWholeMinutes property instead or convert toDouble(MINUTES) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MINUTES)", imports = {}))
    @ExperimentalTime
    public static /* synthetic */ void getInMinutes$annotations() {
    }

    @Deprecated(message = "Use inWholeNanoseconds property instead or convert toDouble(NANOSECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.NANOSECONDS)", imports = {}))
    @ExperimentalTime
    public static /* synthetic */ void getInNanoseconds$annotations() {
    }

    @Deprecated(message = "Use inWholeSeconds property instead or convert toDouble(SECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.SECONDS)", imports = {}))
    @ExperimentalTime
    public static /* synthetic */ void getInSeconds$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getMinutesComponent$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getNanosecondsComponent$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getSecondsComponent$annotations() {
    }

    /* renamed from: times-UwyO8pc, reason: not valid java name */
    public static final long m1863timesUwyO8pc(long j3, double d16) {
        int roundToInt;
        roundToInt = MathKt__MathJVMKt.roundToInt(d16);
        if (((double) roundToInt) == d16) {
            return m1864timesUwyO8pc(j3, roundToInt);
        }
        DurationUnit m1851getStorageUnitimpl = m1851getStorageUnitimpl(j3);
        return DurationKt.toDuration(m1869toDoubleimpl(j3, m1851getStorageUnitimpl) * d16, m1851getStorageUnitimpl);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static final String m1876toStringimpl(long j3, @NotNull DurationUnit unit, int i3) {
        int coerceAtMost;
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (i3 >= 0) {
            double m1869toDoubleimpl = m1869toDoubleimpl(j3, unit);
            if (Double.isInfinite(m1869toDoubleimpl)) {
                return String.valueOf(m1869toDoubleimpl);
            }
            StringBuilder sb5 = new StringBuilder();
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(i3, 12);
            sb5.append(DurationJvmKt.formatToExactDecimals(m1869toDoubleimpl, coerceAtMost));
            sb5.append(DurationUnitKt__DurationUnitKt.shortName(unit));
            return sb5.toString();
        }
        throw new IllegalArgumentException(("decimals must be not negative, but was " + i3).toString());
    }
}
