package com.tencent.kuikly.core.views;

import com.tencent.kuikly.core.base.AbstractBaseView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b+\u0010,J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J+\u0010\u000e\u001a\u00020\u00042#\u0010\r\u001a\u001f\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\n\u0012\u0004\u0012\u00020\u00040\tj\u0002`\u000b\u00a2\u0006\u0002\b\fR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001b\u001a\u00020\u00068\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aRC\u0010\"\u001a#\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tj\u0004\u0018\u0001`\u000b\u00a2\u0006\u0002\b\f8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010*\u001a\u00020#8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/kuikly/core/views/ca;", "Lcom/tencent/kuikly/core/views/ao;", "Lcom/tencent/kuikly/core/views/bn;", "scrollParams", "", DomainData.DOMAIN_NAME, "", "index", tl.h.F, "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/base/ViewContainer;", "Lcom/tencent/kuikly/core/base/ViewBuilder;", "Lkotlin/ExtensionFunctionType;", "creator", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "Lcom/tencent/kuikly/core/views/bn;", "k", "()Lcom/tencent/kuikly/core/views/bn;", "setScrollParams$core_release", "(Lcom/tencent/kuikly/core/views/bn;)V", "b", "I", "j", "()I", "setInitIndex$core_release", "(I)V", "initIndex", "c", "Lkotlin/jvm/functions/Function1;", "i", "()Lkotlin/jvm/functions/Function1;", "setIndicatorCreator$core_release", "(Lkotlin/jvm/functions/Function1;)V", "indicatorCreator", "", "d", "Z", "l", "()Z", "setTabAlignCenter$core_release", "(Z)V", "tabAlignCenter", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ca extends ao {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private ScrollParams scrollParams;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int initIndex;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Function1<? super ViewContainer<?, ?>, Unit> indicatorCreator;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean tabAlignCenter;

    public final void h(int index) {
        this.initIndex = index;
    }

    public final Function1<ViewContainer<?, ?>, Unit> i() {
        return this.indicatorCreator;
    }

    /* renamed from: j, reason: from getter */
    public final int getInitIndex() {
        return this.initIndex;
    }

    /* renamed from: k, reason: from getter */
    public final ScrollParams getScrollParams() {
        return this.scrollParams;
    }

    /* renamed from: l, reason: from getter */
    public final boolean getTabAlignCenter() {
        return this.tabAlignCenter;
    }

    public final void m(Function1<? super ViewContainer<?, ?>, Unit> creator) {
        Intrinsics.checkNotNullParameter(creator, "creator");
        this.indicatorCreator = creator;
    }

    public final void n(ScrollParams scrollParams) {
        Intrinsics.checkNotNullParameter(scrollParams, "scrollParams");
        this.scrollParams = scrollParams;
        AbstractBaseView<?, ?> view = view();
        TabsView tabsView = view instanceof TabsView ? (TabsView) view : null;
        if (tabsView != null) {
            tabsView.m();
        }
    }
}
