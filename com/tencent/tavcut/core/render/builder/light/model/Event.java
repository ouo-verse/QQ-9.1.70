package com.tencent.tavcut.core.render.builder.light.model;

import com.tencent.autotemplate.TAVRhythmAutomaticTemplate;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\nJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003Ji\u0010\u0018\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/tavcut/core/render/builder/light/model/Event;", "", TAVRhythmAutomaticTemplate.DefaultTrail, "", "", TAVRhythmAutomaticTemplate.HighlightValueTrail, TAVRhythmAutomaticTemplate.DrumTrail, TAVRhythmAutomaticTemplate.SlowRhythmTrail, TAVRhythmAutomaticTemplate.StartValueTrail, "ParagraphTrail", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getDefalutTrail", "()Ljava/util/List;", "getDrumTrail", "getHighlightValueTrail", "getParagraphTrail", "getSlowRhythmTrail", "getStartValueTrail", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final /* data */ class Event {

    @NotNull
    private final List<Integer> DefalutTrail;

    @NotNull
    private final List<Integer> DrumTrail;

    @NotNull
    private final List<Integer> HighlightValueTrail;

    @NotNull
    private final List<Integer> ParagraphTrail;

    @NotNull
    private final List<Integer> SlowRhythmTrail;

    @NotNull
    private final List<Integer> StartValueTrail;

    public Event() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ Event copy$default(Event event, List list, List list2, List list3, List list4, List list5, List list6, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = event.DefalutTrail;
        }
        if ((i3 & 2) != 0) {
            list2 = event.HighlightValueTrail;
        }
        List list7 = list2;
        if ((i3 & 4) != 0) {
            list3 = event.DrumTrail;
        }
        List list8 = list3;
        if ((i3 & 8) != 0) {
            list4 = event.SlowRhythmTrail;
        }
        List list9 = list4;
        if ((i3 & 16) != 0) {
            list5 = event.StartValueTrail;
        }
        List list10 = list5;
        if ((i3 & 32) != 0) {
            list6 = event.ParagraphTrail;
        }
        return event.copy(list, list7, list8, list9, list10, list6);
    }

    @NotNull
    public final List<Integer> component1() {
        return this.DefalutTrail;
    }

    @NotNull
    public final List<Integer> component2() {
        return this.HighlightValueTrail;
    }

    @NotNull
    public final List<Integer> component3() {
        return this.DrumTrail;
    }

    @NotNull
    public final List<Integer> component4() {
        return this.SlowRhythmTrail;
    }

    @NotNull
    public final List<Integer> component5() {
        return this.StartValueTrail;
    }

    @NotNull
    public final List<Integer> component6() {
        return this.ParagraphTrail;
    }

    @NotNull
    public final Event copy(@NotNull List<Integer> DefalutTrail, @NotNull List<Integer> HighlightValueTrail, @NotNull List<Integer> DrumTrail, @NotNull List<Integer> SlowRhythmTrail, @NotNull List<Integer> StartValueTrail, @NotNull List<Integer> ParagraphTrail) {
        Intrinsics.checkParameterIsNotNull(DefalutTrail, "DefalutTrail");
        Intrinsics.checkParameterIsNotNull(HighlightValueTrail, "HighlightValueTrail");
        Intrinsics.checkParameterIsNotNull(DrumTrail, "DrumTrail");
        Intrinsics.checkParameterIsNotNull(SlowRhythmTrail, "SlowRhythmTrail");
        Intrinsics.checkParameterIsNotNull(StartValueTrail, "StartValueTrail");
        Intrinsics.checkParameterIsNotNull(ParagraphTrail, "ParagraphTrail");
        return new Event(DefalutTrail, HighlightValueTrail, DrumTrail, SlowRhythmTrail, StartValueTrail, ParagraphTrail);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof Event) {
                Event event = (Event) other;
                if (!Intrinsics.areEqual(this.DefalutTrail, event.DefalutTrail) || !Intrinsics.areEqual(this.HighlightValueTrail, event.HighlightValueTrail) || !Intrinsics.areEqual(this.DrumTrail, event.DrumTrail) || !Intrinsics.areEqual(this.SlowRhythmTrail, event.SlowRhythmTrail) || !Intrinsics.areEqual(this.StartValueTrail, event.StartValueTrail) || !Intrinsics.areEqual(this.ParagraphTrail, event.ParagraphTrail)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final List<Integer> getDefalutTrail() {
        return this.DefalutTrail;
    }

    @NotNull
    public final List<Integer> getDrumTrail() {
        return this.DrumTrail;
    }

    @NotNull
    public final List<Integer> getHighlightValueTrail() {
        return this.HighlightValueTrail;
    }

    @NotNull
    public final List<Integer> getParagraphTrail() {
        return this.ParagraphTrail;
    }

    @NotNull
    public final List<Integer> getSlowRhythmTrail() {
        return this.SlowRhythmTrail;
    }

    @NotNull
    public final List<Integer> getStartValueTrail() {
        return this.StartValueTrail;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        List<Integer> list = this.DefalutTrail;
        int i26 = 0;
        if (list != null) {
            i3 = list.hashCode();
        } else {
            i3 = 0;
        }
        int i27 = i3 * 31;
        List<Integer> list2 = this.HighlightValueTrail;
        if (list2 != null) {
            i16 = list2.hashCode();
        } else {
            i16 = 0;
        }
        int i28 = (i27 + i16) * 31;
        List<Integer> list3 = this.DrumTrail;
        if (list3 != null) {
            i17 = list3.hashCode();
        } else {
            i17 = 0;
        }
        int i29 = (i28 + i17) * 31;
        List<Integer> list4 = this.SlowRhythmTrail;
        if (list4 != null) {
            i18 = list4.hashCode();
        } else {
            i18 = 0;
        }
        int i36 = (i29 + i18) * 31;
        List<Integer> list5 = this.StartValueTrail;
        if (list5 != null) {
            i19 = list5.hashCode();
        } else {
            i19 = 0;
        }
        int i37 = (i36 + i19) * 31;
        List<Integer> list6 = this.ParagraphTrail;
        if (list6 != null) {
            i26 = list6.hashCode();
        }
        return i37 + i26;
    }

    @NotNull
    public String toString() {
        return "Event(DefalutTrail=" + this.DefalutTrail + ", HighlightValueTrail=" + this.HighlightValueTrail + ", DrumTrail=" + this.DrumTrail + ", SlowRhythmTrail=" + this.SlowRhythmTrail + ", StartValueTrail=" + this.StartValueTrail + ", ParagraphTrail=" + this.ParagraphTrail + ")";
    }

    public Event(@NotNull List<Integer> DefalutTrail, @NotNull List<Integer> HighlightValueTrail, @NotNull List<Integer> DrumTrail, @NotNull List<Integer> SlowRhythmTrail, @NotNull List<Integer> StartValueTrail, @NotNull List<Integer> ParagraphTrail) {
        Intrinsics.checkParameterIsNotNull(DefalutTrail, "DefalutTrail");
        Intrinsics.checkParameterIsNotNull(HighlightValueTrail, "HighlightValueTrail");
        Intrinsics.checkParameterIsNotNull(DrumTrail, "DrumTrail");
        Intrinsics.checkParameterIsNotNull(SlowRhythmTrail, "SlowRhythmTrail");
        Intrinsics.checkParameterIsNotNull(StartValueTrail, "StartValueTrail");
        Intrinsics.checkParameterIsNotNull(ParagraphTrail, "ParagraphTrail");
        this.DefalutTrail = DefalutTrail;
        this.HighlightValueTrail = HighlightValueTrail;
        this.DrumTrail = DrumTrail;
        this.SlowRhythmTrail = SlowRhythmTrail;
        this.StartValueTrail = StartValueTrail;
        this.ParagraphTrail = ParagraphTrail;
    }

    public /* synthetic */ Event(List list, List list2, List list3, List list4, List list5, List list6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i3 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2, (i3 & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list3, (i3 & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list4, (i3 & 16) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list5, (i3 & 32) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list6);
    }
}
