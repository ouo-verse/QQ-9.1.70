package com.tencent.mobileqq.qqvideoedit.editor.background.border;

import androidx.annotation.ColorInt;
import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0005\"\u0004\b\u000e\u0010\u0007R\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u0010\u0010\u0005\"\u0004\b\u0011\u0010\u0007R\"\u0010\u0018\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0014\u001a\u0004\b\f\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/e;", "", "", "a", UserInfo.SEX_FEMALE, "()F", "f", "(F)V", "hLineLength", "b", "g", "hLineWidth", "c", "d", "i", "vLineLength", "e", "j", "vLineWidth", "", "I", "()I", h.F, "(I)V", "lineColor", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private float hLineLength;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private float hLineWidth;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private float vLineLength;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float vLineWidth;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @ColorInt
    private int lineColor = -16776961;

    /* renamed from: a, reason: from getter */
    public final float getHLineLength() {
        return this.hLineLength;
    }

    /* renamed from: b, reason: from getter */
    public final float getHLineWidth() {
        return this.hLineWidth;
    }

    /* renamed from: c, reason: from getter */
    public final int getLineColor() {
        return this.lineColor;
    }

    /* renamed from: d, reason: from getter */
    public final float getVLineLength() {
        return this.vLineLength;
    }

    /* renamed from: e, reason: from getter */
    public final float getVLineWidth() {
        return this.vLineWidth;
    }

    public final void f(float f16) {
        this.hLineLength = f16;
    }

    public final void g(float f16) {
        this.hLineWidth = f16;
    }

    public final void h(int i3) {
        this.lineColor = i3;
    }

    public final void i(float f16) {
        this.vLineLength = f16;
    }

    public final void j(float f16) {
        this.vLineWidth = f16;
    }
}
