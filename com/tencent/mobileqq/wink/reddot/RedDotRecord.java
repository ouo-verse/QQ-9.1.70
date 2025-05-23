package com.tencent.mobileqq.wink.reddot;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.google.gson.annotations.Expose;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0001+B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u000e\u00a2\u0006\u0004\b'\u0010(B\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b'\u0010)J$\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00002\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0002J\u0014\u0010\n\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00000\bJ\u001a\u0010\u000b\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\t\u0010\u0012\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u000eH\u00c6\u0003J\u001d\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u000eH\u00c6\u0001J\t\u0010\u0017\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u000eH\u00d6\u0001J\u0013\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u00d6\u0003R\u001a\u0010\u0014\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0015\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010 \u001a\u0004\b!\u0010\"R \u0010#\u001a\b\u0012\u0004\u0012\u00020\u00000\b8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00000\b8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010$\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/wink/reddot/RedDotRecord;", "Landroid/os/Parcelable;", Node.CHILDREN_ATTR, "Lkotlin/Function1;", "", "", "action", "removeChild", "", "childrens", "addChilds", "notifyParents", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "writeToParcel", "describeContents", "component1", "component2", "id", "redDotVersion", "copy", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "I", "getRedDotVersion", "()I", "parents", "Ljava/util/List;", "getParents", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;I)V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final /* data */ class RedDotRecord implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Expose(deserialize = false, serialize = false)
    @NotNull
    private List<RedDotRecord> childrens;

    @Expose
    @NotNull
    private final String id;

    @Expose(deserialize = false, serialize = false)
    @NotNull
    private final List<RedDotRecord> parents;

    @Expose
    private final int redDotVersion;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/reddot/RedDotRecord$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/wink/reddot/RedDotRecord;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/wink/reddot/RedDotRecord;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.reddot.RedDotRecord$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion implements Parcelable.Creator<RedDotRecord> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RedDotRecord createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new RedDotRecord(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RedDotRecord[] newArray(int size) {
            return new RedDotRecord[size];
        }

        Companion() {
        }
    }

    public RedDotRecord(@NotNull String id5, int i3) {
        Intrinsics.checkNotNullParameter(id5, "id");
        this.id = id5;
        this.redDotVersion = i3;
        this.parents = new ArrayList();
        this.childrens = new ArrayList();
    }

    public static /* synthetic */ RedDotRecord copy$default(RedDotRecord redDotRecord, String str, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = redDotRecord.id;
        }
        if ((i16 & 2) != 0) {
            i3 = redDotRecord.redDotVersion;
        }
        return redDotRecord.copy(str, i3);
    }

    private final void removeChild(RedDotRecord children, Function1<? super String, Unit> action) {
        this.childrens.remove(children);
        if (this.childrens.isEmpty()) {
            action.invoke(this.id);
        }
    }

    public final void addChilds(@NotNull List<RedDotRecord> childrens) {
        Intrinsics.checkNotNullParameter(childrens, "childrens");
        this.childrens.clear();
        this.childrens.addAll(childrens);
        Iterator<T> it = this.childrens.iterator();
        while (it.hasNext()) {
            ((RedDotRecord) it.next()).parents.add(this);
        }
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final int getRedDotVersion() {
        return this.redDotVersion;
    }

    @NotNull
    public final RedDotRecord copy(@NotNull String id5, int redDotVersion) {
        Intrinsics.checkNotNullParameter(id5, "id");
        return new RedDotRecord(id5, redDotVersion);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RedDotRecord)) {
            return false;
        }
        RedDotRecord redDotRecord = (RedDotRecord) other;
        if (Intrinsics.areEqual(this.id, redDotRecord.id) && this.redDotVersion == redDotRecord.redDotVersion) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final List<RedDotRecord> getParents() {
        return this.parents;
    }

    public final int getRedDotVersion() {
        return this.redDotVersion;
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.redDotVersion;
    }

    public final void notifyParents(@NotNull Function1<? super String, Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        Iterator<T> it = this.parents.iterator();
        while (it.hasNext()) {
            ((RedDotRecord) it.next()).removeChild(this, action);
        }
    }

    @NotNull
    public String toString() {
        return "RedDotRecord(id=" + this.id + ", redDotVersion=" + this.redDotVersion + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeInt(this.redDotVersion);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RedDotRecord(@NotNull Parcel parcel) {
        this(r0 == null ? "" : r0, parcel.readInt());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
    }
}
