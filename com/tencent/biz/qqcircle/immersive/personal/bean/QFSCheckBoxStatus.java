package com.tencent.biz.qqcircle.immersive.personal.bean;

import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0012\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b\u0011\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\"\u0010\u001a\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0016\u001a\u0004\b\u0010\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/bean/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "c", "()Z", "setNeedShow", "(Z)V", "needShow", "b", "e", NodeProps.ENABLED, "d", "g", "selected", "I", "()I", "f", "(I)V", "index", "<init>", "(ZZZI)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.biz.qqcircle.immersive.personal.bean.a, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class QFSCheckBoxStatus {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean needShow;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean enabled;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean selected;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int index;

    public QFSCheckBoxStatus() {
        this(false, false, false, 0, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* renamed from: b, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getNeedShow() {
        return this.needShow;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    public final void e(boolean z16) {
        this.enabled = z16;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QFSCheckBoxStatus)) {
            return false;
        }
        QFSCheckBoxStatus qFSCheckBoxStatus = (QFSCheckBoxStatus) other;
        if (this.needShow == qFSCheckBoxStatus.needShow && this.enabled == qFSCheckBoxStatus.enabled && this.selected == qFSCheckBoxStatus.selected && this.index == qFSCheckBoxStatus.index) {
            return true;
        }
        return false;
    }

    public final void f(int i3) {
        this.index = i3;
    }

    public final void g(boolean z16) {
        this.selected = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public int hashCode() {
        boolean z16 = this.needShow;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        ?? r26 = this.enabled;
        int i17 = r26;
        if (r26 != 0) {
            i17 = 1;
        }
        int i18 = (i16 + i17) * 31;
        boolean z17 = this.selected;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return ((i18 + i3) * 31) + this.index;
    }

    @NotNull
    public String toString() {
        return "QFSCheckBoxStatus(needShow=" + this.needShow + ", enabled=" + this.enabled + ", selected=" + this.selected + ", index=" + this.index + ")";
    }

    public QFSCheckBoxStatus(boolean z16, boolean z17, boolean z18, int i3) {
        this.needShow = z16;
        this.enabled = z17;
        this.selected = z18;
        this.index = i3;
    }

    public /* synthetic */ QFSCheckBoxStatus(boolean z16, boolean z17, boolean z18, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? false : z16, (i16 & 2) != 0 ? true : z17, (i16 & 4) != 0 ? false : z18, (i16 & 8) != 0 ? -1 : i3);
    }
}
