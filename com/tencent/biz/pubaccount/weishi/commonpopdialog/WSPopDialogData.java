package com.tencent.biz.pubaccount.weishi.commonpopdialog;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/commonpopdialog/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "intervalDays", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "tipsText", "style", "<init>", "(ILjava/lang/String;I)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.biz.pubaccount.weishi.commonpopdialog.a, reason: from toString */
/* loaded from: classes32.dex */
public final /* data */ class WSPopDialogData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int intervalDays;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String tipsText;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int style;

    public WSPopDialogData(int i3, String tipsText, int i16) {
        Intrinsics.checkNotNullParameter(tipsText, "tipsText");
        this.intervalDays = i3;
        this.tipsText = tipsText;
        this.style = i16;
    }

    /* renamed from: a, reason: from getter */
    public final int getIntervalDays() {
        return this.intervalDays;
    }

    /* renamed from: b, reason: from getter */
    public final int getStyle() {
        return this.style;
    }

    /* renamed from: c, reason: from getter */
    public final String getTipsText() {
        return this.tipsText;
    }

    public int hashCode() {
        return (((this.intervalDays * 31) + this.tipsText.hashCode()) * 31) + this.style;
    }

    public String toString() {
        return "WSPopDialogData(intervalDays=" + this.intervalDays + ", tipsText=" + this.tipsText + ", style=" + this.style + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WSPopDialogData)) {
            return false;
        }
        WSPopDialogData wSPopDialogData = (WSPopDialogData) other;
        return this.intervalDays == wSPopDialogData.intervalDays && Intrinsics.areEqual(this.tipsText, wSPopDialogData.tipsText) && this.style == wSPopDialogData.style;
    }
}
