package com.tencent.qq.minibox.ui.view.indicator;

import androidx.annotation.ColorInt;
import com.tencent.ditto.shell.LayoutAttrDefine;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 72\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b5\u00106R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\n\u0010\bR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u001e\u0010\bR\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b \u0010\bR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\"\u0010,\u001a\u00020%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u00104\u001a\u00020-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103\u00a8\u00068"}, d2 = {"Lcom/tencent/qq/minibox/ui/view/indicator/a;", "", "", "a", "I", "b", "()I", "i", "(I)V", "indicatorSize", h.F, "currentPosition", "Lcom/tencent/qq/minibox/ui/view/indicator/Direction;", "c", "Lcom/tencent/qq/minibox/ui/view/indicator/Direction;", "getGravity", "()Lcom/tencent/qq/minibox/ui/view/indicator/Direction;", "setGravity", "(Lcom/tencent/qq/minibox/ui/view/indicator/Direction;)V", LayoutAttrDefine.Gravity.Gravity, "d", "setIndicatorSpace", "indicatorSpace", "e", "setNormalWidth", "normalWidth", "f", "g", "setSelectedWidth", "selectedWidth", "setNormalColor", "normalColor", "setSelectedColor", "selectedColor", "getHeight", "setHeight", "height", "", "j", "Z", "getAttachToBanner", "()Z", "setAttachToBanner", "(Z)V", "attachToBanner", "Lcom/tencent/qq/minibox/ui/view/indicator/b;", "k", "Lcom/tencent/qq/minibox/ui/view/indicator/b;", "getMargins", "()Lcom/tencent/qq/minibox/ui/view/indicator/b;", "setMargins", "(Lcom/tencent/qq/minibox/ui/view/indicator/b;)V", "margins", "<init>", "()V", "l", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int indicatorSize;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int currentPosition;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Direction gravity = Direction.CENTER;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int indicatorSpace;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int normalWidth;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int selectedWidth;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @ColorInt
    private int normalColor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @ColorInt
    private int selectedColor;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int height;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean attachToBanner;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private b margins;

    public a() {
        Companion.C9356a c9356a = Companion.C9356a.f344736a;
        this.indicatorSpace = c9356a.e();
        this.normalWidth = c9356a.c();
        this.selectedWidth = c9356a.d();
        this.normalColor = -7829368;
        this.selectedColor = -1;
        this.height = c9356a.a();
        this.attachToBanner = true;
        this.margins = new b();
    }

    /* renamed from: a, reason: from getter */
    public final int getCurrentPosition() {
        return this.currentPosition;
    }

    /* renamed from: b, reason: from getter */
    public final int getIndicatorSize() {
        return this.indicatorSize;
    }

    /* renamed from: c, reason: from getter */
    public final int getIndicatorSpace() {
        return this.indicatorSpace;
    }

    /* renamed from: d, reason: from getter */
    public final int getNormalColor() {
        return this.normalColor;
    }

    /* renamed from: e, reason: from getter */
    public final int getNormalWidth() {
        return this.normalWidth;
    }

    /* renamed from: f, reason: from getter */
    public final int getSelectedColor() {
        return this.selectedColor;
    }

    /* renamed from: g, reason: from getter */
    public final int getSelectedWidth() {
        return this.selectedWidth;
    }

    public final void h(int i3) {
        this.currentPosition = i3;
    }

    public final void i(int i3) {
        this.indicatorSize = i3;
    }
}
