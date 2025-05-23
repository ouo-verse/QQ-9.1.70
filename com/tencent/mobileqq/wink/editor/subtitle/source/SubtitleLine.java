package com.tencent.mobileqq.wink.editor.subtitle.source;

import androidx.annotation.Keep;
import com.tencent.mobileqq.wink.editor.subtitle.SubtitlesMapKey;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\tJ\u001d\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005H\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J?\u0010$\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010(\u001a\u00020)H\u00d6\u0001J\t\u0010*\u001a\u00020\u0007H\u00d6\u0001J\u0016\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020/R\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011R.\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R\u001a\u0010\u001e\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/subtitle/source/SubtitleLine;", "", "lines", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/SubtitleLineText;", "Lkotlin/collections/ArrayList;", "start_time", "", "end_time", "(Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)V", "durationUs", "", "getDurationUs", "()J", "endTimeUs", "getEndTimeUs", "getEnd_time", "()Ljava/lang/String;", "setEnd_time", "(Ljava/lang/String;)V", "line", "getLine", "getLines", "()Ljava/util/ArrayList;", "setLines", "(Ljava/util/ArrayList;)V", "startTimeUs", "getStartTimeUs", "getStart_time", "setStart_time", "translateLine", "getTranslateLine", "setTranslateLine", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "toSubtitle", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/Subtitle;", "absStartTimeUs", "belongToVideoPath", "Lcom/tencent/mobileqq/wink/editor/subtitle/SubtitlesMapKey;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final /* data */ class SubtitleLine {

    @Nullable
    private String end_time;

    @Nullable
    private ArrayList<SubtitleLineText> lines;

    @Nullable
    private String start_time;

    @NotNull
    private String translateLine;

    public SubtitleLine() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SubtitleLine copy$default(SubtitleLine subtitleLine, ArrayList arrayList, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            arrayList = subtitleLine.lines;
        }
        if ((i3 & 2) != 0) {
            str = subtitleLine.start_time;
        }
        if ((i3 & 4) != 0) {
            str2 = subtitleLine.end_time;
        }
        return subtitleLine.copy(arrayList, str, str2);
    }

    private final long getDurationUs() {
        return getEndTimeUs() - getStartTimeUs();
    }

    @Nullable
    public final ArrayList<SubtitleLineText> component1() {
        return this.lines;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getStart_time() {
        return this.start_time;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getEnd_time() {
        return this.end_time;
    }

    @NotNull
    public final SubtitleLine copy(@Nullable ArrayList<SubtitleLineText> lines, @Nullable String start_time, @Nullable String end_time) {
        return new SubtitleLine(lines, start_time, end_time);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubtitleLine)) {
            return false;
        }
        SubtitleLine subtitleLine = (SubtitleLine) other;
        if (Intrinsics.areEqual(this.lines, subtitleLine.lines) && Intrinsics.areEqual(this.start_time, subtitleLine.start_time) && Intrinsics.areEqual(this.end_time, subtitleLine.end_time)) {
            return true;
        }
        return false;
    }

    public final long getEndTimeUs() {
        String str = this.end_time;
        if (str == null) {
            return 0L;
        }
        try {
            String substring = str.substring(0, str.length() - 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            double d16 = 1000;
            return (long) (Double.parseDouble(substring) * d16 * d16);
        } catch (Throwable th5) {
            w53.b.c("subtitle_bean", "parse end time fail: " + th5);
            return 0L;
        }
    }

    @Nullable
    public final String getEnd_time() {
        return this.end_time;
    }

    @NotNull
    public final String getLine() {
        ArrayList<SubtitleLineText> arrayList = this.lines;
        if (arrayList == null || arrayList.isEmpty()) {
            return "";
        }
        return arrayList.get(0).getNnText();
    }

    @Nullable
    public final ArrayList<SubtitleLineText> getLines() {
        return this.lines;
    }

    public final long getStartTimeUs() {
        String str = this.start_time;
        if (str == null) {
            return 0L;
        }
        try {
            String substring = str.substring(0, str.length() - 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            double d16 = 1000;
            return (long) (Double.parseDouble(substring) * d16 * d16);
        } catch (Throwable th5) {
            w53.b.c("subtitle_bean", "parse start time fail: " + th5);
            return 0L;
        }
    }

    @Nullable
    public final String getStart_time() {
        return this.start_time;
    }

    @NotNull
    public final String getTranslateLine() {
        return this.translateLine;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        ArrayList<SubtitleLineText> arrayList = this.lines;
        int i3 = 0;
        if (arrayList == null) {
            hashCode = 0;
        } else {
            hashCode = arrayList.hashCode();
        }
        int i16 = hashCode * 31;
        String str = this.start_time;
        if (str == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str2 = this.end_time;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return i17 + i3;
    }

    public final void setEnd_time(@Nullable String str) {
        this.end_time = str;
    }

    public final void setLines(@Nullable ArrayList<SubtitleLineText> arrayList) {
        this.lines = arrayList;
    }

    public final void setStart_time(@Nullable String str) {
        this.start_time = str;
    }

    public final void setTranslateLine(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.translateLine = str;
    }

    @NotNull
    public String toString() {
        return "SubtitleLine(lines=" + this.lines + ", start_time=" + this.start_time + ", end_time=" + this.end_time + ")";
    }

    @NotNull
    public final Subtitle toSubtitle(long absStartTimeUs, @NotNull SubtitlesMapKey belongToVideoPath) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(belongToVideoPath, "belongToVideoPath");
        String line = getLine();
        long durationUs = getDurationUs();
        long startTimeUs = getStartTimeUs();
        long endTimeUs = getEndTimeUs();
        String str = this.translateLine;
        isBlank = StringsKt__StringsJVMKt.isBlank(str);
        Subtitle subtitle = new Subtitle(line, absStartTimeUs, durationUs, startTimeUs, endTimeUs, str, 0, !isBlank, belongToVideoPath, 64, null);
        subtitle.setLines(this.lines);
        return subtitle;
    }

    public SubtitleLine(@Nullable ArrayList<SubtitleLineText> arrayList, @Nullable String str, @Nullable String str2) {
        this.lines = arrayList;
        this.start_time = str;
        this.end_time = str2;
        this.translateLine = "";
    }

    public /* synthetic */ SubtitleLine(ArrayList arrayList, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : arrayList, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : str2);
    }
}
