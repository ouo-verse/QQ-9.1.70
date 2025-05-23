package com.tencent.mobileqq.wink.editor.sticker.selector.adapter;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.view.selector.WinkPickerView;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0005B\u0019\u0012\u0006\u0010\u0014\u001a\u00020\u001f\u0012\b\b\u0002\u0010.\u001a\u00020-\u00a2\u0006\u0004\b/\u00100J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016J\u0016\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\u0004J\u0006\u0010\u001b\u001a\u00020\u0004J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u001e\u001a\u00020\u001dR\u0017\u0010\u0014\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0017\u0010#R\u0014\u0010%\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010#R\u0016\u0010&\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010#R\u0016\u0010'\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010#R\u0016\u0010(\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010#R\u0016\u0010)\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010#R\u0016\u0010*\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010#R\u0016\u0010+\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010#R\u0016\u0010,\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010#\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/selector/adapter/a;", "Lcom/tencent/mobileqq/wink/view/selector/WinkPickerView$e;", "Lcom/tencent/mobileqq/wink/editor/sticker/selector/adapter/WinkStickerTimeColumnType;", "columnType", "", "a", "o", "f", "row", "", "p", "k", "g", h.F, "i", "l", "getColumnCount", "column", "getRowCount", "getText", "type", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "b", "j", "e", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "c", "Ljava/util/Calendar;", "d", "Lcom/tencent/mobileqq/wink/editor/sticker/selector/adapter/WinkStickerTimeDateType;", "Lcom/tencent/mobileqq/wink/editor/sticker/selector/adapter/WinkStickerTimeDateType;", "getType", "()Lcom/tencent/mobileqq/wink/editor/sticker/selector/adapter/WinkStickerTimeDateType;", "I", "startYear", "endYear", "currentYearIndex", "currentMonthIndex", "currentDayIndex", "currentHourIndex", "currentMinuteIndex", "currentSecondIndex", "currentWeekIndex", "", "currentTimeMilli", "<init>", "(Lcom/tencent/mobileqq/wink/editor/sticker/selector/adapter/WinkStickerTimeDateType;J)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a implements WinkPickerView.e {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WinkStickerTimeDateType type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int startYear;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int endYear;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int currentYearIndex;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int currentMonthIndex;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int currentDayIndex;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int currentHourIndex;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int currentMinuteIndex;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int currentSecondIndex;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int currentWeekIndex;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/selector/adapter/a$a;", "", "", "row", "", "a", "AFTER_YEAR_COUNT", "I", "COLUMN_HOUR_COUNT", "COLUMN_MINUTE_COUNT", "COLUMN_MONTH_COUNT", "COLUMN_SECOND_COUNT", "COLUMN_WEEK_COUNT", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.sticker.selector.adapter.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String a(int row) {
            switch (row) {
                case 0:
                default:
                    return "\u661f\u671f\u65e5";
                case 1:
                    return "\u661f\u671f\u4e00";
                case 2:
                    return "\u661f\u671f\u4e8c";
                case 3:
                    return "\u661f\u671f\u4e09";
                case 4:
                    return "\u661f\u671f\u56db";
                case 5:
                    return "\u661f\u671f\u4e94";
                case 6:
                    return "\u661f\u671f\u516d";
            }
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f321771a;

        static {
            int[] iArr = new int[WinkStickerTimeColumnType.values().length];
            try {
                iArr[WinkStickerTimeColumnType.TypeYear.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WinkStickerTimeColumnType.TypeMonth.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WinkStickerTimeColumnType.TypeDay.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[WinkStickerTimeColumnType.TypeHour.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[WinkStickerTimeColumnType.TypeMinute.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[WinkStickerTimeColumnType.TypeSecond.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[WinkStickerTimeColumnType.TypeWeek.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f321771a = iArr;
        }
    }

    public a(@NotNull WinkStickerTimeDateType type, long j3) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.startYear = 1971;
        Calendar calendar = Calendar.getInstance();
        calendar.add(1, 10);
        calendar.set(calendar.get(1), calendar.getActualMaximum(2), calendar.getActualMaximum(5), calendar.getActualMaximum(11), calendar.getActualMaximum(12), calendar.getActualMaximum(13));
        calendar.set(14, calendar.getActualMaximum(14));
        this.endYear = calendar.get(1);
        if (j3 < calendar.getTimeInMillis()) {
            calendar.setTimeInMillis(j3);
        }
        this.currentYearIndex = calendar.get(1) - 1971;
        this.currentMonthIndex = calendar.get(2);
        this.currentDayIndex = calendar.get(5) - 1;
        this.currentHourIndex = calendar.get(11);
        this.currentMinuteIndex = calendar.get(12);
        this.currentSecondIndex = calendar.get(13);
        this.currentWeekIndex = calendar.get(7) - 1;
    }

    private final int a(WinkStickerTimeColumnType columnType) {
        int columnCount = this.type.getColumnCount();
        for (int i3 = 0; i3 < columnCount; i3++) {
            if (this.type.getColumnType(i3) == columnType) {
                return i3;
            }
        }
        return -1;
    }

    private final int f() {
        return d().getActualMaximum(5);
    }

    private final String g(int row) {
        return (row + 1) + "\u65e5";
    }

    private final String h(int row) {
        if (row < 10) {
            return "0" + row;
        }
        return String.valueOf(row);
    }

    private final String i(int row) {
        if (row < 10) {
            return "0" + row;
        }
        return String.valueOf(row);
    }

    private final String k(int row) {
        return (row + 1) + "\u6708";
    }

    private final String l(int row) {
        if (row < 10) {
            return "0" + row;
        }
        return String.valueOf(row);
    }

    private final int o() {
        return (this.endYear - this.startYear) + 1;
    }

    private final String p(int row) {
        return (this.startYear + row) + "\u5e74";
    }

    @NotNull
    public final WinkStickerTimeColumnType b(int column) {
        return this.type.getColumnType(column);
    }

    public final int c(int column) {
        switch (b.f321771a[b(column).ordinal()]) {
            case 1:
                return this.currentYearIndex;
            case 2:
                return this.currentMonthIndex;
            case 3:
                return this.currentDayIndex;
            case 4:
                return this.currentHourIndex;
            case 5:
                return this.currentMinuteIndex;
            case 6:
                return this.currentSecondIndex;
            case 7:
                return this.currentWeekIndex;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public final Calendar d() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(this.currentYearIndex + this.startYear, this.currentMonthIndex, this.currentDayIndex + 1, this.currentHourIndex, this.currentMinuteIndex, this.currentSecondIndex);
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance().apply {\n  \u2026condIndex\n        )\n    }");
        return calendar;
    }

    public final int e() {
        return a(WinkStickerTimeColumnType.TypeDay);
    }

    @Override // com.tencent.mobileqq.wink.view.selector.WinkPickerView.e
    public int getColumnCount() {
        return this.type.getColumnCount();
    }

    @Override // com.tencent.mobileqq.wink.view.selector.WinkPickerView.e
    public int getRowCount(int column) {
        switch (b.f321771a[b(column).ordinal()]) {
            case 1:
                return o();
            case 2:
                return 12;
            case 3:
                return f();
            case 4:
                return 24;
            case 5:
            case 6:
                return 60;
            case 7:
                return 7;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.tencent.mobileqq.wink.view.selector.WinkPickerView.e
    @NotNull
    public String getText(int column, int row) {
        switch (b.f321771a[b(column).ordinal()]) {
            case 1:
                return p(row);
            case 2:
                return k(row);
            case 3:
                return g(row);
            case 4:
                return h(row);
            case 5:
                return i(row);
            case 6:
                return l(row);
            case 7:
                return INSTANCE.a(row);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final int j() {
        return a(WinkStickerTimeColumnType.TypeMonth);
    }

    public final int m() {
        return a(WinkStickerTimeColumnType.TypeWeek);
    }

    public final int n() {
        return a(WinkStickerTimeColumnType.TypeYear);
    }

    public final void q(@NotNull WinkStickerTimeColumnType type, int row) {
        int coerceIn;
        int coerceIn2;
        int coerceIn3;
        int coerceIn4;
        int coerceIn5;
        int coerceIn6;
        int coerceIn7;
        int coerceIn8;
        int coerceIn9;
        Intrinsics.checkNotNullParameter(type, "type");
        switch (b.f321771a[type.ordinal()]) {
            case 1:
                coerceIn = RangesKt___RangesKt.coerceIn(row, 0, o() - 1);
                this.currentYearIndex = coerceIn;
                Calendar calendar = Calendar.getInstance();
                calendar.set(this.currentYearIndex + this.startYear, this.currentMonthIndex, 1);
                coerceIn2 = RangesKt___RangesKt.coerceIn(this.currentDayIndex, 0, calendar.getActualMaximum(5) - 1);
                this.currentDayIndex = coerceIn2;
                calendar.set(5, coerceIn2 + 1);
                this.currentWeekIndex = calendar.get(7) - 1;
                break;
            case 2:
                coerceIn3 = RangesKt___RangesKt.coerceIn(row, 0, 11);
                this.currentMonthIndex = coerceIn3;
                Calendar calendar2 = Calendar.getInstance();
                calendar2.set(this.currentYearIndex + this.startYear, this.currentMonthIndex, 1);
                coerceIn4 = RangesKt___RangesKt.coerceIn(this.currentDayIndex, 0, calendar2.getActualMaximum(5) - 1);
                this.currentDayIndex = coerceIn4;
                calendar2.set(5, coerceIn4 + 1);
                this.currentWeekIndex = calendar2.get(7) - 1;
                break;
            case 3:
                Calendar calendar3 = Calendar.getInstance();
                calendar3.set(this.currentYearIndex + this.startYear, this.currentMonthIndex, row + 1);
                coerceIn5 = RangesKt___RangesKt.coerceIn(row, 0, calendar3.getActualMaximum(5) - 1);
                this.currentDayIndex = coerceIn5;
                this.currentWeekIndex = calendar3.get(7) - 1;
                break;
            case 4:
                coerceIn6 = RangesKt___RangesKt.coerceIn(row, 0, 23);
                this.currentHourIndex = coerceIn6;
                break;
            case 5:
                coerceIn7 = RangesKt___RangesKt.coerceIn(row, 0, 59);
                this.currentMinuteIndex = coerceIn7;
                break;
            case 6:
                coerceIn8 = RangesKt___RangesKt.coerceIn(row, 0, 59);
                this.currentSecondIndex = coerceIn8;
                break;
            case 7:
                Calendar calendar4 = Calendar.getInstance();
                calendar4.set(this.currentYearIndex + this.startYear, this.currentMonthIndex, this.currentDayIndex + 1);
                calendar4.set(7, row + 1);
                int actualMaximum = calendar4.getActualMaximum(5);
                this.currentWeekIndex = row;
                this.currentYearIndex = calendar4.get(1) - this.startYear;
                this.currentMonthIndex = calendar4.get(2);
                coerceIn9 = RangesKt___RangesKt.coerceIn(calendar4.get(5) - 1, 0, actualMaximum - 1);
                this.currentDayIndex = coerceIn9;
                break;
        }
        w53.b.f("WinkStickerTimeDateAdapter", "updateSelectTypeAndRow: timeInMillis = " + d().getTimeInMillis() + ".");
    }
}
