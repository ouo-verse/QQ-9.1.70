package com.tencent.mobileqq.wink.editor.effect.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000eR\"\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0017\u0010\u000eR\"\u0010\u001a\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b\u0019\u0010\u000e\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/effect/model/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "g", "(I)V", "effectItemClickNum", "d", "i", "effectItemLongClickNum", "c", "e", "j", "effectUndoClickNum", h.F, "effectItemEditNum", "f", "effectCatClickNum", "<init>", "(IIIII)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.editor.effect.model.a, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class WinkEffectOpReportData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int effectItemClickNum;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int effectItemLongClickNum;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int effectUndoClickNum;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int effectItemEditNum;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private int effectCatClickNum;

    public WinkEffectOpReportData() {
        this(0, 0, 0, 0, 0, 31, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getEffectCatClickNum() {
        return this.effectCatClickNum;
    }

    /* renamed from: b, reason: from getter */
    public final int getEffectItemClickNum() {
        return this.effectItemClickNum;
    }

    /* renamed from: c, reason: from getter */
    public final int getEffectItemEditNum() {
        return this.effectItemEditNum;
    }

    /* renamed from: d, reason: from getter */
    public final int getEffectItemLongClickNum() {
        return this.effectItemLongClickNum;
    }

    /* renamed from: e, reason: from getter */
    public final int getEffectUndoClickNum() {
        return this.effectUndoClickNum;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WinkEffectOpReportData)) {
            return false;
        }
        WinkEffectOpReportData winkEffectOpReportData = (WinkEffectOpReportData) other;
        if (this.effectItemClickNum == winkEffectOpReportData.effectItemClickNum && this.effectItemLongClickNum == winkEffectOpReportData.effectItemLongClickNum && this.effectUndoClickNum == winkEffectOpReportData.effectUndoClickNum && this.effectItemEditNum == winkEffectOpReportData.effectItemEditNum && this.effectCatClickNum == winkEffectOpReportData.effectCatClickNum) {
            return true;
        }
        return false;
    }

    public final void f(int i3) {
        this.effectCatClickNum = i3;
    }

    public final void g(int i3) {
        this.effectItemClickNum = i3;
    }

    public final void h(int i3) {
        this.effectItemEditNum = i3;
    }

    public int hashCode() {
        return (((((((this.effectItemClickNum * 31) + this.effectItemLongClickNum) * 31) + this.effectUndoClickNum) * 31) + this.effectItemEditNum) * 31) + this.effectCatClickNum;
    }

    public final void i(int i3) {
        this.effectItemLongClickNum = i3;
    }

    public final void j(int i3) {
        this.effectUndoClickNum = i3;
    }

    @NotNull
    public String toString() {
        return "WinkEffectOpReportData(effectItemClickNum=" + this.effectItemClickNum + ", effectItemLongClickNum=" + this.effectItemLongClickNum + ", effectUndoClickNum=" + this.effectUndoClickNum + ", effectItemEditNum=" + this.effectItemEditNum + ", effectCatClickNum=" + this.effectCatClickNum + ")";
    }

    public WinkEffectOpReportData(int i3, int i16, int i17, int i18, int i19) {
        this.effectItemClickNum = i3;
        this.effectItemLongClickNum = i16;
        this.effectUndoClickNum = i17;
        this.effectItemEditNum = i18;
        this.effectCatClickNum = i19;
    }

    public /* synthetic */ WinkEffectOpReportData(int i3, int i16, int i17, int i18, int i19, int i26, DefaultConstructorMarker defaultConstructorMarker) {
        this((i26 & 1) != 0 ? 0 : i3, (i26 & 2) != 0 ? 0 : i16, (i26 & 4) != 0 ? 0 : i17, (i26 & 8) != 0 ? 0 : i18, (i26 & 16) != 0 ? 0 : i19);
    }
}
