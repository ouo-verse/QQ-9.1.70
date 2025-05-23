package com.tencent.state.square.avatar.filament;

import com.google.gson.annotations.SerializedName;
import com.tencent.mtt.hippy.views.hippypager.HippyPagerPageChangeListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0006J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J+\u0010\f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\t\u0010\u0016\u001a\u00020\u0015H\u00d6\u0001R\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/state/square/avatar/filament/Animations;", "", HippyPagerPageChangeListener.IDLE, "", "Lcom/tencent/state/square/avatar/filament/Animation;", "click", "(Ljava/util/List;Ljava/util/List;)V", "getClick", "()Ljava/util/List;", "getIdle", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "setFullPath", "", "preFix", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class Animations {

    @SerializedName("click")
    private final List<Animation> click;

    @SerializedName(HippyPagerPageChangeListener.IDLE)
    private final List<Animation> idle;

    public Animations(List<Animation> idle, List<Animation> list) {
        Intrinsics.checkNotNullParameter(idle, "idle");
        this.idle = idle;
        this.click = list;
    }

    public final List<Animation> component1() {
        return this.idle;
    }

    public final List<Animation> component2() {
        return this.click;
    }

    public final Animations copy(List<Animation> idle, List<Animation> click) {
        Intrinsics.checkNotNullParameter(idle, "idle");
        return new Animations(idle, click);
    }

    public final List<Animation> getClick() {
        return this.click;
    }

    public final List<Animation> getIdle() {
        return this.idle;
    }

    public int hashCode() {
        List<Animation> list = this.idle;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        List<Animation> list2 = this.click;
        return hashCode + (list2 != null ? list2.hashCode() : 0);
    }

    public final void setFullPath(String preFix) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        Intrinsics.checkNotNullParameter(preFix, "preFix");
        List<Animation> list = this.idle;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((Animation) it.next()).setFullPath(preFix);
            arrayList.add(Unit.INSTANCE);
        }
        List<Animation> list2 = this.click;
        if (list2 != null) {
            List<Animation> list3 = list2;
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
            Iterator<T> it5 = list3.iterator();
            while (it5.hasNext()) {
                ((Animation) it5.next()).setFullPath(preFix);
                arrayList2.add(Unit.INSTANCE);
            }
        }
    }

    public String toString() {
        return "Animations(idle=" + this.idle + ", click=" + this.click + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Animations)) {
            return false;
        }
        Animations animations = (Animations) other;
        return Intrinsics.areEqual(this.idle, animations.idle) && Intrinsics.areEqual(this.click, animations.click);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Animations copy$default(Animations animations, List list, List list2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = animations.idle;
        }
        if ((i3 & 2) != 0) {
            list2 = animations.click;
        }
        return animations.copy(list, list2);
    }
}
