package com.tencent.mobileqq.widget.dialog;

import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/widget/dialog/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "closeBtnDp", "b", "c", "contentMarginCloseBtnDp", "closeBtnRes", "<init>", "(III)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.widget.dialog.b, reason: from toString */
/* loaded from: classes20.dex */
public final /* data */ class AdvertiseDialogParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int closeBtnDp;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int contentMarginCloseBtnDp;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int closeBtnRes;

    public AdvertiseDialogParams() {
        this(0, 0, 0, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getCloseBtnDp() {
        return this.closeBtnDp;
    }

    /* renamed from: b, reason: from getter */
    public final int getCloseBtnRes() {
        return this.closeBtnRes;
    }

    /* renamed from: c, reason: from getter */
    public final int getContentMarginCloseBtnDp() {
        return this.contentMarginCloseBtnDp;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdvertiseDialogParams)) {
            return false;
        }
        AdvertiseDialogParams advertiseDialogParams = (AdvertiseDialogParams) other;
        if (this.closeBtnDp == advertiseDialogParams.closeBtnDp && this.contentMarginCloseBtnDp == advertiseDialogParams.contentMarginCloseBtnDp && this.closeBtnRes == advertiseDialogParams.closeBtnRes) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.closeBtnDp * 31) + this.contentMarginCloseBtnDp) * 31) + this.closeBtnRes;
    }

    @NotNull
    public String toString() {
        return "AdvertiseDialogParams(closeBtnDp=" + this.closeBtnDp + ", contentMarginCloseBtnDp=" + this.contentMarginCloseBtnDp + ", closeBtnRes=" + this.closeBtnRes + ')';
    }

    public AdvertiseDialogParams(int i3, int i16, int i17) {
        this.closeBtnDp = i3;
        this.contentMarginCloseBtnDp = i16;
        this.closeBtnRes = i17;
    }

    public /* synthetic */ AdvertiseDialogParams(int i3, int i16, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? 44 : i3, (i18 & 2) != 0 ? 20 : i16, (i18 & 4) != 0 ? R.drawable.qui_close_circle : i17);
    }
}
