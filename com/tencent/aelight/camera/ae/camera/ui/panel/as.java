package com.tencent.aelight.camera.ae.camera.ui.panel;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0018\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\t0\b\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0010\u0012\b\b\u0002\u0010 \u001a\u00020\u0002\u00a2\u0006\u0004\b!\u0010\"R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R)\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\t0\b8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006R\u0017\u0010\u001b\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001aR\u0017\u0010\u001e\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001d\u0010\u0013R\u0017\u0010 \u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\u00a8\u0006#"}, d2 = {"Lcom/tencent/aelight/camera/ae/camera/ui/panel/as;", "", "", "a", "I", "c", "()I", "panelBgRes", "", "Lkotlin/Pair;", "", "b", "[Lkotlin/Pair;", "e", "()[Lkotlin/Pair;", "tabs", "", "Z", "d", "()Z", "showTabBarDivider", "itemHighlightColor", "itemNormalColor", "Lcom/tencent/aelight/camera/ae/control/b;", "f", "Lcom/tencent/aelight/camera/ae/control/b;", "()Lcom/tencent/aelight/camera/ae/control/b;", "templateManager", "g", "getDtReport", "dtReport", tl.h.F, "unusableToastTextId", "<init>", "(I[Lkotlin/Pair;ZIILcom/tencent/aelight/camera/ae/control/b;ZI)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class as {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int panelBgRes;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Pair<String, Integer>[] tabs;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean showTabBarDivider;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int itemHighlightColor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int itemNormalColor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.aelight.camera.ae.control.b templateManager;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final boolean dtReport;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int unusableToastTextId;

    public as(int i3, Pair<String, Integer>[] tabs, boolean z16, int i16, int i17, com.tencent.aelight.camera.ae.control.b templateManager, boolean z17, int i18) {
        Intrinsics.checkNotNullParameter(tabs, "tabs");
        Intrinsics.checkNotNullParameter(templateManager, "templateManager");
        this.panelBgRes = i3;
        this.tabs = tabs;
        this.showTabBarDivider = z16;
        this.itemHighlightColor = i16;
        this.itemNormalColor = i17;
        this.templateManager = templateManager;
        this.dtReport = z17;
        this.unusableToastTextId = i18;
    }

    /* renamed from: a, reason: from getter */
    public final int getItemHighlightColor() {
        return this.itemHighlightColor;
    }

    /* renamed from: b, reason: from getter */
    public final int getItemNormalColor() {
        return this.itemNormalColor;
    }

    /* renamed from: c, reason: from getter */
    public final int getPanelBgRes() {
        return this.panelBgRes;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getShowTabBarDivider() {
        return this.showTabBarDivider;
    }

    public final Pair<String, Integer>[] e() {
        return this.tabs;
    }

    /* renamed from: f, reason: from getter */
    public final com.tencent.aelight.camera.ae.control.b getTemplateManager() {
        return this.templateManager;
    }

    /* renamed from: g, reason: from getter */
    public final int getUnusableToastTextId() {
        return this.unusableToastTextId;
    }
}
