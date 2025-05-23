package com.qzone.reborn.widget;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u0003\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/qzone/reborn/widget/a;", "", "", "a", "I", "b", "()I", "d", "(I)V", "skinMode", "", "Z", "()Z", "c", "(Z)V", "pressable", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int skinMode = 1000;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean pressable = true;

    /* renamed from: a, reason: from getter */
    public final boolean getPressable() {
        return this.pressable;
    }

    /* renamed from: b, reason: from getter */
    public final int getSkinMode() {
        return this.skinMode;
    }

    public final void c(boolean z16) {
        this.pressable = z16;
    }

    public final void d(int i3) {
        this.skinMode = i3;
    }
}
