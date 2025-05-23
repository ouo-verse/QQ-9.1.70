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
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b@\u0010AJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J)\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\b\"\u00020\u0006\u00a2\u0006\u0004\b\n\u0010\u000bJ+\u0010\u0011\u001a\u00020\u00042#\u0010\u0010\u001a\u001f\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u00040\fj\u0002`\u000e\u00a2\u0006\u0002\b\u000fJ+\u0010\u0012\u001a\u00020\u00042#\u0010\u0010\u001a\u001f\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u00040\fj\u0002`\u000e\u00a2\u0006\u0002\b\u000fJ\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0002R+\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00028@@@X\u0080\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bRC\u0010#\u001a#\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u0004\u0018\u00010\fj\u0004\u0018\u0001`\u000e\u00a2\u0006\u0002\b\u000f8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"RC\u0010'\u001a#\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\r\u0012\u0004\u0012\u00020\u0004\u0018\u00010\fj\u0004\u0018\u0001`\u000e\u00a2\u0006\u0002\b\u000f8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u001e\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R+\u0010-\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00068@@@X\u0080\u008e\u0002\u00a2\u0006\u0012\n\u0004\b(\u0010\u0017\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,Ra\u00106\u001a\u001d\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00040\fj\u0002`0\u00a2\u0006\u0002\b\u000f0.2!\u0010\u0015\u001a\u001d\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00040\fj\u0002`0\u00a2\u0006\u0002\b\u000f0.8@@@X\u0080\u008e\u0002\u00a2\u0006\u0012\n\u0004\b1\u0010\u0017\u001a\u0004\b2\u00103\"\u0004\b4\u00105R7\u0010:\u001a\u0017\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00040\fj\u0002`0\u00a2\u0006\u0002\b\u000f8\u0000@\u0000X\u0080.\u00a2\u0006\u0012\n\u0004\b7\u0010\u001e\u001a\u0004\b8\u0010 \"\u0004\b9\u0010\"R\"\u0010?\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010\u0019\"\u0004\b>\u0010\u001b\u00a8\u0006B"}, d2 = {"Lcom/tencent/kuikly/core/views/ActionSheetAttr;", "Lcom/tencent/kuikly/core/base/m;", "", "showAlert", "", "w", "", "cancelButtonTitle", "", "buttonTitles", tl.h.F, "(Ljava/lang/String;[Ljava/lang/String;)V", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/base/ViewContainer;", "Lcom/tencent/kuikly/core/base/ViewBuilder;", "Lkotlin/ExtensionFunctionType;", "viewCreator", "j", "i", "window", "r", "<set-?>", "a", "Lkotlin/properties/ReadWriteProperty;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Z", "v", "(Z)V", "showActionSheet", "b", "Lkotlin/jvm/functions/Function1;", DomainData.DOMAIN_NAME, "()Lkotlin/jvm/functions/Function1;", "u", "(Lkotlin/jvm/functions/Function1;)V", "contentViewCreator", "c", "l", ReportConstant.COSTREPORT_PREFIX, "backgroundViewCreator", "d", "o", "()Ljava/lang/String;", "setDescriptionOfActions$core_release", "(Ljava/lang/String;)V", "descriptionOfActions", "Lcom/tencent/kuikly/core/reactive/collection/c;", "Lcom/tencent/kuikly/core/views/ce;", "Lcom/tencent/kuikly/core/views/ActionButtonTitleAttr;", "e", "k", "()Lcom/tencent/kuikly/core/reactive/collection/c;", "setActionButtonsAttrs$core_release", "(Lcom/tencent/kuikly/core/reactive/collection/c;)V", "actionButtonsAttrs", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "t", "cancelButtonAttr", "g", "Z", "p", "setInWindow$core_release", "inWindow", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ActionSheetAttr extends com.tencent.kuikly.core.base.m {

    /* renamed from: h, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f118268h = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(ActionSheetAttr.class, "showActionSheet", "getShowActionSheet$core_release()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ActionSheetAttr.class, "descriptionOfActions", "getDescriptionOfActions$core_release()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(ActionSheetAttr.class, "actionButtonsAttrs", "getActionButtonsAttrs$core_release()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0))};

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Function1<? super ViewContainer<?, ?>, Unit> contentViewCreator;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Function1<? super ViewContainer<?, ?>, Unit> backgroundViewCreator;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public Function1<? super ce, Unit> cancelButtonAttr;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean inWindow;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty showActionSheet = c01.c.a(Boolean.FALSE);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty descriptionOfActions = c01.c.a("");

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty actionButtonsAttrs = c01.c.b();

    public final void h(final String cancelButtonTitle, String... buttonTitles) {
        Intrinsics.checkNotNullParameter(cancelButtonTitle, "cancelButtonTitle");
        Intrinsics.checkNotNullParameter(buttonTitles, "buttonTitles");
        t(new Function1<ce, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetAttr$actionButtons$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ce ceVar) {
                invoke2(ceVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ce ceVar) {
                Intrinsics.checkNotNullParameter(ceVar, "$this$null");
                ceVar.text(cancelButtonTitle);
            }
        });
        k().clear();
        for (final String str : buttonTitles) {
            k().add(new Function1<ce, Unit>() { // from class: com.tencent.kuikly.core.views.ActionSheetAttr$actionButtons$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ce ceVar) {
                    invoke2(ceVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ce add) {
                    Intrinsics.checkNotNullParameter(add, "$this$add");
                    add.text(str);
                }
            });
        }
    }

    public final void i(Function1<? super ViewContainer<?, ?>, Unit> viewCreator) {
        Intrinsics.checkNotNullParameter(viewCreator, "viewCreator");
        this.backgroundViewCreator = viewCreator;
    }

    public final void j(Function1<? super ViewContainer<?, ?>, Unit> viewCreator) {
        Intrinsics.checkNotNullParameter(viewCreator, "viewCreator");
        this.contentViewCreator = viewCreator;
    }

    public final com.tencent.kuikly.core.reactive.collection.c<Function1<ce, Unit>> k() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.actionButtonsAttrs.getValue(this, f118268h[2]);
    }

    public final Function1<ViewContainer<?, ?>, Unit> l() {
        return this.backgroundViewCreator;
    }

    public final Function1<ce, Unit> m() {
        Function1 function1 = this.cancelButtonAttr;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cancelButtonAttr");
        return null;
    }

    public final Function1<ViewContainer<?, ?>, Unit> n() {
        return this.contentViewCreator;
    }

    public final String o() {
        return (String) this.descriptionOfActions.getValue(this, f118268h[1]);
    }

    /* renamed from: p, reason: from getter */
    public final boolean getInWindow() {
        return this.inWindow;
    }

    public final boolean q() {
        return ((Boolean) this.showActionSheet.getValue(this, f118268h[0])).booleanValue();
    }

    public final void r(boolean window) {
        this.inWindow = window;
    }

    public final void s(Function1<? super ViewContainer<?, ?>, Unit> function1) {
        this.backgroundViewCreator = function1;
    }

    public final void t(Function1<? super ce, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.cancelButtonAttr = function1;
    }

    public final void u(Function1<? super ViewContainer<?, ?>, Unit> function1) {
        this.contentViewCreator = function1;
    }

    public final void v(boolean z16) {
        this.showActionSheet.setValue(this, f118268h[0], Boolean.valueOf(z16));
    }

    public final void w(boolean showAlert) {
        v(showAlert);
    }
}
