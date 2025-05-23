package com.tencent.mobileqq.wink.editor.subtitle.source;

import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.editor.subtitle.SubtitlesMapKey;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\b\u0018\u0000 L2\u00020\u0001:\u0001MBY\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0018\u001a\u00020\f\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\bJ\u0010KJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\t\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u000b\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\r\u001a\u00020\fH\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u000eH\u00c6\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003Je\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\f2\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0010H\u00c6\u0001J\t\u0010\u001c\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u001d\u001a\u00020\fH\u00d6\u0001J\u0013\u0010 \u001a\u00020\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u00d6\u0003R\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\u0013\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010\u0014\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010$\u001a\u0004\b'\u0010&R\u0017\u0010\u0015\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010$\u001a\u0004\b(\u0010&R\u0017\u0010\u0016\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010$\u001a\u0004\b)\u0010&R\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010!\u001a\u0004\b*\u0010#\"\u0004\b+\u0010,R\"\u0010\u0018\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u0010\u0019\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R6\u0010?\u001a\u0016\u0012\u0004\u0012\u00020=\u0018\u00010<j\n\u0012\u0004\u0012\u00020=\u0018\u0001`>8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010E\u001a\u0004\u0018\u00010\u00048F@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010!\u001a\u0004\bF\u0010#\"\u0004\bG\u0010,R\u0011\u0010I\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\bH\u0010#\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/subtitle/source/Subtitle;", "Ljava/io/Serializable;", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/SubtitleLine;", "toSubtitleLine", "", "component1", "", "component2", "component3", "component4", "component5", "component6", "", "component7", "", "component8", "Lcom/tencent/mobileqq/wink/editor/subtitle/SubtitlesMapKey;", "component9", "line", "absStartTimeUs", "durationUs", "startTimeUs", "endTimeUs", CanvasView.ACTION_TRANSLATE, "id", "needUpdateTranslate", "belongToVideoPath", "copy", "toString", "hashCode", "", "other", "equals", "Ljava/lang/String;", "getLine", "()Ljava/lang/String;", "J", "getAbsStartTimeUs", "()J", "getDurationUs", "getStartTimeUs", "getEndTimeUs", "getTranslate", "setTranslate", "(Ljava/lang/String;)V", "I", "getId", "()I", "setId", "(I)V", "Z", "getNeedUpdateTranslate", "()Z", "setNeedUpdateTranslate", "(Z)V", "Lcom/tencent/mobileqq/wink/editor/subtitle/SubtitlesMapKey;", "getBelongToVideoPath", "()Lcom/tencent/mobileqq/wink/editor/subtitle/SubtitlesMapKey;", "setBelongToVideoPath", "(Lcom/tencent/mobileqq/wink/editor/subtitle/SubtitlesMapKey;)V", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/SubtitleLineText;", "Lkotlin/collections/ArrayList;", "lines", "Ljava/util/ArrayList;", "getLines", "()Ljava/util/ArrayList;", "setLines", "(Ljava/util/ArrayList;)V", "editContent", "getEditContent", "setEditContent", "getNnTranslate", "nnTranslate", "<init>", "(Ljava/lang/String;JJJJLjava/lang/String;IZLcom/tencent/mobileqq/wink/editor/subtitle/SubtitlesMapKey;)V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final /* data */ class Subtitle implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    private static int f322253d = (int) (System.currentTimeMillis() % (-1666967296));

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Subtitle f322254e = new Subtitle("", -1, -1, -1, -1, null, 0, false, null, 480, null);
    private static final long serialVersionUID = -6166483373518147209L;
    private final long absStartTimeUs;

    @Nullable
    private SubtitlesMapKey belongToVideoPath;
    private final long durationUs;

    @Nullable
    private String editContent;
    private final long endTimeUs;
    private int id;

    @NotNull
    private final String line;

    @Nullable
    private ArrayList<SubtitleLineText> lines;
    private boolean needUpdateTranslate;
    private final long startTimeUs;

    @NotNull
    private String translate;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028F@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/subtitle/source/Subtitle$a;", "", "", "autoincrementID", "I", "a", "()I", "setAutoincrementID", "(I)V", "", "serialVersionUID", "J", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.subtitle.source.Subtitle$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            Subtitle.f322253d++;
            return Subtitle.f322253d;
        }

        Companion() {
        }
    }

    public Subtitle(@NotNull String line, long j3, long j16, long j17, long j18, @NotNull String translate, int i3, boolean z16, @Nullable SubtitlesMapKey subtitlesMapKey) {
        Intrinsics.checkNotNullParameter(line, "line");
        Intrinsics.checkNotNullParameter(translate, "translate");
        this.line = line;
        this.absStartTimeUs = j3;
        this.durationUs = j16;
        this.startTimeUs = j17;
        this.endTimeUs = j18;
        this.translate = translate;
        this.id = i3;
        this.needUpdateTranslate = z16;
        this.belongToVideoPath = subtitlesMapKey;
        this.lines = new ArrayList<>();
    }

    public static /* synthetic */ Subtitle copy$default(Subtitle subtitle, String str, long j3, long j16, long j17, long j18, String str2, int i3, boolean z16, SubtitlesMapKey subtitlesMapKey, int i16, Object obj) {
        String str3;
        long j19;
        long j26;
        long j27;
        long j28;
        String str4;
        int i17;
        boolean z17;
        SubtitlesMapKey subtitlesMapKey2;
        if ((i16 & 1) != 0) {
            str3 = subtitle.line;
        } else {
            str3 = str;
        }
        if ((i16 & 2) != 0) {
            j19 = subtitle.absStartTimeUs;
        } else {
            j19 = j3;
        }
        if ((i16 & 4) != 0) {
            j26 = subtitle.durationUs;
        } else {
            j26 = j16;
        }
        if ((i16 & 8) != 0) {
            j27 = subtitle.startTimeUs;
        } else {
            j27 = j17;
        }
        if ((i16 & 16) != 0) {
            j28 = subtitle.endTimeUs;
        } else {
            j28 = j18;
        }
        if ((i16 & 32) != 0) {
            str4 = subtitle.translate;
        } else {
            str4 = str2;
        }
        if ((i16 & 64) != 0) {
            i17 = subtitle.id;
        } else {
            i17 = i3;
        }
        if ((i16 & 128) != 0) {
            z17 = subtitle.needUpdateTranslate;
        } else {
            z17 = z16;
        }
        if ((i16 & 256) != 0) {
            subtitlesMapKey2 = subtitle.belongToVideoPath;
        } else {
            subtitlesMapKey2 = subtitlesMapKey;
        }
        return subtitle.copy(str3, j19, j26, j27, j28, str4, i17, z17, subtitlesMapKey2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getLine() {
        return this.line;
    }

    /* renamed from: component2, reason: from getter */
    public final long getAbsStartTimeUs() {
        return this.absStartTimeUs;
    }

    /* renamed from: component3, reason: from getter */
    public final long getDurationUs() {
        return this.durationUs;
    }

    /* renamed from: component4, reason: from getter */
    public final long getStartTimeUs() {
        return this.startTimeUs;
    }

    /* renamed from: component5, reason: from getter */
    public final long getEndTimeUs() {
        return this.endTimeUs;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getTranslate() {
        return this.translate;
    }

    /* renamed from: component7, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getNeedUpdateTranslate() {
        return this.needUpdateTranslate;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final SubtitlesMapKey getBelongToVideoPath() {
        return this.belongToVideoPath;
    }

    @NotNull
    public final Subtitle copy(@NotNull String line, long absStartTimeUs, long durationUs, long startTimeUs, long endTimeUs, @NotNull String translate, int id5, boolean needUpdateTranslate, @Nullable SubtitlesMapKey belongToVideoPath) {
        Intrinsics.checkNotNullParameter(line, "line");
        Intrinsics.checkNotNullParameter(translate, "translate");
        return new Subtitle(line, absStartTimeUs, durationUs, startTimeUs, endTimeUs, translate, id5, needUpdateTranslate, belongToVideoPath);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Subtitle)) {
            return false;
        }
        Subtitle subtitle = (Subtitle) other;
        if (Intrinsics.areEqual(this.line, subtitle.line) && this.absStartTimeUs == subtitle.absStartTimeUs && this.durationUs == subtitle.durationUs && this.startTimeUs == subtitle.startTimeUs && this.endTimeUs == subtitle.endTimeUs && Intrinsics.areEqual(this.translate, subtitle.translate) && this.id == subtitle.id && this.needUpdateTranslate == subtitle.needUpdateTranslate && Intrinsics.areEqual(this.belongToVideoPath, subtitle.belongToVideoPath)) {
            return true;
        }
        return false;
    }

    public final long getAbsStartTimeUs() {
        return this.absStartTimeUs;
    }

    @Nullable
    public final SubtitlesMapKey getBelongToVideoPath() {
        return this.belongToVideoPath;
    }

    public final long getDurationUs() {
        return this.durationUs;
    }

    @Nullable
    public final String getEditContent() {
        String str = this.editContent;
        if (str == null) {
            return this.line;
        }
        return str;
    }

    public final long getEndTimeUs() {
        return this.endTimeUs;
    }

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final String getLine() {
        return this.line;
    }

    @Nullable
    public final ArrayList<SubtitleLineText> getLines() {
        return this.lines;
    }

    public final boolean getNeedUpdateTranslate() {
        return this.needUpdateTranslate;
    }

    @NotNull
    public final String getNnTranslate() {
        String str = this.translate;
        if (str == null) {
            return "";
        }
        Intrinsics.checkNotNull(str);
        return str;
    }

    public final long getStartTimeUs() {
        return this.startTimeUs;
    }

    @NotNull
    public final String getTranslate() {
        return this.translate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((((((((this.line.hashCode() * 31) + androidx.fragment.app.a.a(this.absStartTimeUs)) * 31) + androidx.fragment.app.a.a(this.durationUs)) * 31) + androidx.fragment.app.a.a(this.startTimeUs)) * 31) + androidx.fragment.app.a.a(this.endTimeUs)) * 31) + this.translate.hashCode()) * 31) + this.id) * 31;
        boolean z16 = this.needUpdateTranslate;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode2 + i3) * 31;
        SubtitlesMapKey subtitlesMapKey = this.belongToVideoPath;
        if (subtitlesMapKey == null) {
            hashCode = 0;
        } else {
            hashCode = subtitlesMapKey.hashCode();
        }
        return i16 + hashCode;
    }

    public final void setBelongToVideoPath(@Nullable SubtitlesMapKey subtitlesMapKey) {
        this.belongToVideoPath = subtitlesMapKey;
    }

    public final void setEditContent(@Nullable String str) {
        this.editContent = str;
    }

    public final void setId(int i3) {
        this.id = i3;
    }

    public final void setLines(@Nullable ArrayList<SubtitleLineText> arrayList) {
        this.lines = arrayList;
    }

    public final void setNeedUpdateTranslate(boolean z16) {
        this.needUpdateTranslate = z16;
    }

    public final void setTranslate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.translate = str;
    }

    @NotNull
    public String toString() {
        return "Subtitle(line=" + this.line + ", absStartTimeUs=" + this.absStartTimeUs + ", durationUs=" + this.durationUs + ", startTimeUs=" + this.startTimeUs + ", endTimeUs=" + this.endTimeUs + ", translate=" + this.translate + ", id=" + this.id + ", needUpdateTranslate=" + this.needUpdateTranslate + ", belongToVideoPath=" + this.belongToVideoPath + ")";
    }

    @NotNull
    public final SubtitleLine toSubtitleLine() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SubtitleLineText(this.line));
        double d16 = 1000;
        SubtitleLine subtitleLine = new SubtitleLine(arrayList, ((this.startTimeUs / d16) / d16) + ReportConstant.COSTREPORT_PREFIX, ((this.endTimeUs / d16) / d16) + ReportConstant.COSTREPORT_PREFIX);
        subtitleLine.setTranslateLine(this.translate);
        return subtitleLine;
    }

    public /* synthetic */ Subtitle(String str, long j3, long j16, long j17, long j18, String str2, int i3, boolean z16, SubtitlesMapKey subtitlesMapKey, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j3, j16, j17, j18, (i16 & 32) != 0 ? "" : str2, (i16 & 64) != 0 ? INSTANCE.a() : i3, (i16 & 128) != 0 ? true : z16, (i16 & 256) != 0 ? null : subtitlesMapKey);
    }
}
