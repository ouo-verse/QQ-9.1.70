package com.tencent.kuikly.core.views;

import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b7\u00108J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J+\u0010\u000b\u001a\u00020\u00042#\u0010\n\u001a\u001f\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\u00040\u0006j\u0002`\b\u00a2\u0006\u0002\b\tR+\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00028@@@X\u0080\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012RC\u0010\u0019\u001a#\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006j\u0004\u0018\u0001`\b\u00a2\u0006\u0002\b\t8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018RC\u0010\u001d\u001a#\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006j\u0004\u0018\u0001`\b\u00a2\u0006\u0002\b\t8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R+\u0010$\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\u001e8@@@X\u0080\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R+\u0010(\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\u001e8@@@X\u0080\u008e\u0002\u00a2\u0006\u0012\n\u0004\b%\u0010\u000e\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#Ra\u00101\u001a\u001d\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00040\u0006j\u0002`+\u00a2\u0006\u0002\b\t0)2!\u0010\f\u001a\u001d\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00040\u0006j\u0002`+\u00a2\u0006\u0002\b\t0)8@@@X\u0080\u008e\u0002\u00a2\u0006\u0012\n\u0004\b,\u0010\u000e\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00106\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u0010\u0010\"\u0004\b5\u0010\u0012\u00a8\u00069"}, d2 = {"Lcom/tencent/kuikly/core/views/j;", "Lcom/tencent/kuikly/core/base/m;", "", "showAlert", "", ReportConstant.COSTREPORT_PREFIX, "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/base/ViewContainer;", "Lcom/tencent/kuikly/core/base/ViewBuilder;", "Lkotlin/ExtensionFunctionType;", "viewCreator", tl.h.F, "<set-?>", "a", "Lkotlin/properties/ReadWriteProperty;", DomainData.DOMAIN_NAME, "()Z", "r", "(Z)V", "b", "Lkotlin/jvm/functions/Function1;", "k", "()Lkotlin/jvm/functions/Function1;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Lkotlin/jvm/functions/Function1;)V", "contentViewCreator", "c", "j", "p", "backgroundViewCreator", "", "d", "o", "()Ljava/lang/String;", "setTitle$core_release", "(Ljava/lang/String;)V", "title", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setMessage$core_release", "message", "Lcom/tencent/kuikly/core/reactive/collection/c;", "Lcom/tencent/kuikly/core/views/ce;", "Lcom/tencent/kuikly/core/views/ActionButtonTitleAttr;", "f", "i", "()Lcom/tencent/kuikly/core/reactive/collection/c;", "setActionButtonsAttrs$core_release", "(Lcom/tencent/kuikly/core/reactive/collection/c;)V", "actionButtonsAttrs", "g", "Z", "l", "setInWindow$core_release", "inWindow", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class j extends com.tencent.kuikly.core.base.m {

    /* renamed from: h, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f118494h = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(j.class, "showAlert", "getShowAlert$core_release()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(j.class, "title", "getTitle$core_release()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(j.class, "message", "getMessage$core_release()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(j.class, "actionButtonsAttrs", "getActionButtonsAttrs$core_release()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0))};

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Function1<? super ViewContainer<?, ?>, Unit> contentViewCreator;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Function1<? super ViewContainer<?, ?>, Unit> backgroundViewCreator;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean inWindow;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty showAlert = c01.c.a(Boolean.FALSE);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty title = c01.c.a("");

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty message = c01.c.a("");

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty actionButtonsAttrs = c01.c.b();

    public final void h(Function1<? super ViewContainer<?, ?>, Unit> viewCreator) {
        Intrinsics.checkNotNullParameter(viewCreator, "viewCreator");
        this.contentViewCreator = viewCreator;
    }

    public final com.tencent.kuikly.core.reactive.collection.c<Function1<ce, Unit>> i() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.actionButtonsAttrs.getValue(this, f118494h[3]);
    }

    public final Function1<ViewContainer<?, ?>, Unit> j() {
        return this.backgroundViewCreator;
    }

    public final Function1<ViewContainer<?, ?>, Unit> k() {
        return this.contentViewCreator;
    }

    /* renamed from: l, reason: from getter */
    public final boolean getInWindow() {
        return this.inWindow;
    }

    public final String m() {
        return (String) this.message.getValue(this, f118494h[2]);
    }

    public final boolean n() {
        return ((Boolean) this.showAlert.getValue(this, f118494h[0])).booleanValue();
    }

    public final String o() {
        return (String) this.title.getValue(this, f118494h[1]);
    }

    public final void p(Function1<? super ViewContainer<?, ?>, Unit> function1) {
        this.backgroundViewCreator = function1;
    }

    public final void q(Function1<? super ViewContainer<?, ?>, Unit> function1) {
        this.contentViewCreator = function1;
    }

    public final void r(boolean z16) {
        this.showAlert.setValue(this, f118494h[0], Boolean.valueOf(z16));
    }

    public final void s(boolean showAlert) {
        r(showAlert);
    }
}
