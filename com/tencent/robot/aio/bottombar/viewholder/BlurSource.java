package com.tencent.robot.aio.bottombar.viewholder;

import android.view.View;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u0012\u001a\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R+\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u00148\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\t\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/robot/aio/bottombar/viewholder/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "c", "()Z", "show", "Landroid/view/View;", "b", "Landroid/view/View;", "()Landroid/view/View;", "bgView", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "bgList", "<init>", "(ZLandroid/view/View;Ljava/util/ArrayList;)V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.aio.bottombar.viewholder.a, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class BlurSource {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean show;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final View bgView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final ArrayList<Object> bgList;

    public BlurSource(boolean z16, @Nullable View view, @Nullable ArrayList<Object> arrayList) {
        this.show = z16;
        this.bgView = view;
        this.bgList = arrayList;
    }

    @Nullable
    public final ArrayList<Object> a() {
        return this.bgList;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final View getBgView() {
        return this.bgView;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getShow() {
        return this.show;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BlurSource)) {
            return false;
        }
        BlurSource blurSource = (BlurSource) other;
        if (this.show == blurSource.show && Intrinsics.areEqual(this.bgView, blurSource.bgView) && Intrinsics.areEqual(this.bgList, blurSource.bgList)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        int hashCode;
        boolean z16 = this.show;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        View view = this.bgView;
        int i16 = 0;
        if (view == null) {
            hashCode = 0;
        } else {
            hashCode = view.hashCode();
        }
        int i17 = (i3 + hashCode) * 31;
        ArrayList<Object> arrayList = this.bgList;
        if (arrayList != null) {
            i16 = arrayList.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        return "BlurSource(show=" + this.show + ", bgView=" + this.bgView + ", bgList=" + this.bgList + ")";
    }
}
