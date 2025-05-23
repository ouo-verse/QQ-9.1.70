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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0006J\u0011\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J-\u0010\f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\t\u0010\u0016\u001a\u00020\u0015H\u00d6\u0001R\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/state/square/avatar/filament/Actors;", "", HippyPagerPageChangeListener.IDLE, "", "Lcom/tencent/state/square/avatar/filament/Actor;", "click", "(Ljava/util/List;Ljava/util/List;)V", "getClick", "()Ljava/util/List;", "getIdle", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "setFullPath", "", "preFix", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class Actors {

    @SerializedName("click")
    private final List<Actor> click;

    @SerializedName(HippyPagerPageChangeListener.IDLE)
    private final List<Actor> idle;

    public Actors(List<Actor> list, List<Actor> list2) {
        this.idle = list;
        this.click = list2;
    }

    public final List<Actor> component1() {
        return this.idle;
    }

    public final List<Actor> component2() {
        return this.click;
    }

    public final Actors copy(List<Actor> idle, List<Actor> click) {
        return new Actors(idle, click);
    }

    public final List<Actor> getClick() {
        return this.click;
    }

    public final List<Actor> getIdle() {
        return this.idle;
    }

    public int hashCode() {
        List<Actor> list = this.idle;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        List<Actor> list2 = this.click;
        return hashCode + (list2 != null ? list2.hashCode() : 0);
    }

    public final void setFullPath(String preFix) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        Intrinsics.checkNotNullParameter(preFix, "preFix");
        List<Actor> list = this.idle;
        if (list != null) {
            List<Actor> list2 = list;
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault2);
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                ((Actor) it.next()).setFullPath(preFix);
                arrayList.add(Unit.INSTANCE);
            }
        }
        List<Actor> list3 = this.click;
        if (list3 != null) {
            List<Actor> list4 = list3;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it5 = list4.iterator();
            while (it5.hasNext()) {
                ((Actor) it5.next()).setFullPath(preFix);
                arrayList2.add(Unit.INSTANCE);
            }
        }
    }

    public String toString() {
        return "Actors(idle=" + this.idle + ", click=" + this.click + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Actors)) {
            return false;
        }
        Actors actors = (Actors) other;
        return Intrinsics.areEqual(this.idle, actors.idle) && Intrinsics.areEqual(this.click, actors.click);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Actors copy$default(Actors actors, List list, List list2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = actors.idle;
        }
        if ((i3 & 2) != 0) {
            list2 = actors.click;
        }
        return actors.copy(list, list2);
    }
}
