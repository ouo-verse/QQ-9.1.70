package com.tencent.mobileqq.zplan.aio.panel.page;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b&\u0018\u0000 72\u00020\u0001:\u0003\u0007\u000e\u0015B\u0007\u00a2\u0006\u0004\b=\u0010>J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR+\u0010 \u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00148F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\t\u0010\u001d\u001a\u0004\b\u001e\u0010\u0018\"\u0004\b\u001f\u0010\u001aR(\u0010)\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R(\u0010+\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010$\u001a\u0004\b#\u0010&\"\u0004\b*\u0010(R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020-0,8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010.R\u0014\u00103\u001a\u0002008&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b1\u00102R\u0014\u00106\u001a\u00020\u00068gX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b4\u00105R\u0014\u00108\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b7\u00105R\u0014\u0010:\u001a\u00020\u00068&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b9\u00105R\u0014\u0010<\u001a\u0002008&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b;\u00102\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/page/Page;", "Lcom/tencent/mobileqq/zplan/aio/panel/page/g;", "Lcom/tencent/mobileqq/zplan/aio/panel/page/Page$b;", "selectFunction", "Lcom/tencent/mobileqq/zplan/aio/panel/page/Page$c;", "j", "", "a", "Ljava/lang/Integer;", "d", "()Ljava/lang/Integer;", "p", "(Ljava/lang/Integer;)V", "lastSelected", "b", "Lcom/tencent/mobileqq/zplan/aio/panel/page/Page$b;", "i", "()Lcom/tencent/mobileqq/zplan/aio/panel/page/Page$b;", ReportConstant.COSTREPORT_PREFIX, "(Lcom/tencent/mobileqq/zplan/aio/panel/page/Page$b;)V", "", "c", "Z", "o", "()Z", "u", "(Z)V", "isTabSelected", "<set-?>", "Lkotlin/properties/ReadWriteProperty;", DomainData.DOMAIN_NAME, "t", "isTabExposed", "Lkotlin/Function0;", "", "e", "Lkotlin/jvm/functions/Function0;", "f", "()Lkotlin/jvm/functions/Function0;", "r", "(Lkotlin/jvm/functions/Function0;)V", "onTabExposed", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "onTabClicked", "", "Lcom/tencent/mobileqq/zplan/aio/panel/item/b;", "()Ljava/util/List;", "items", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/lang/String;", "tabName", "l", "()I", "tabIconResInt", "g", "pageType", "k", "sortKey", tl.h.F, "reportTabName", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public abstract class Page implements g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Integer lastSelected;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private b selectFunction;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isTabSelected;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty isTabExposed;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Function0<Unit> onTabExposed;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Function0<Unit> onTabClicked;

    /* renamed from: h, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f331231h = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(Page.class, "isTabExposed", "isTabExposed()Z", 0))};

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/page/Page$b;", "", "", "position", "", "T", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface b {
        void T(int position);
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/zplan/aio/panel/page/Page$d", "Lcom/tencent/mobileqq/zplan/aio/panel/page/Page$c;", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements c {
        d() {
        }

        @Override // com.tencent.mobileqq.zplan.aio.panel.page.Page.c
        public void b(int i3) {
            c.a.a(this, i3);
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J+\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0014\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "Lkotlin/reflect/KProperty;", "property", "oldValue", "newValue", "", "afterChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e extends ObservableProperty<Boolean> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Page f331238b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Object obj, Page page) {
            super(obj);
            this.f331238b = page;
        }

        @Override // kotlin.properties.ObservableProperty
        protected void afterChange(KProperty<?> property, Boolean oldValue, Boolean newValue) {
            Intrinsics.checkNotNullParameter(property, "property");
            boolean booleanValue = newValue.booleanValue();
            if (oldValue.booleanValue() || !booleanValue) {
                return;
            }
            this.f331238b.f().invoke();
        }
    }

    public Page() {
        Delegates delegates = Delegates.INSTANCE;
        this.isTabExposed = new e(Boolean.FALSE, this);
        this.onTabExposed = new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aio.panel.page.Page$onTabExposed$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
        this.onTabClicked = new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aio.panel.page.Page$onTabClicked$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
    }

    public List<com.tencent.mobileqq.zplan.aio.panel.item.b> c() {
        List<com.tencent.mobileqq.zplan.aio.panel.item.b> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    /* renamed from: d, reason: from getter */
    public final Integer getLastSelected() {
        return this.lastSelected;
    }

    public final Function0<Unit> e() {
        return this.onTabClicked;
    }

    public final Function0<Unit> f() {
        return this.onTabExposed;
    }

    public int g() {
        return 0;
    }

    public abstract String h();

    /* renamed from: i, reason: from getter */
    public final b getSelectFunction() {
        return this.selectFunction;
    }

    public c j(b selectFunction) {
        Intrinsics.checkNotNullParameter(selectFunction, "selectFunction");
        return new d();
    }

    public abstract int k();

    public abstract int l();

    public abstract String m();

    public final boolean n() {
        return ((Boolean) this.isTabExposed.getValue(this, f331231h[0])).booleanValue();
    }

    /* renamed from: o, reason: from getter */
    public final boolean getIsTabSelected() {
        return this.isTabSelected;
    }

    public final void p(Integer num) {
        this.lastSelected = num;
    }

    public final void q(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onTabClicked = function0;
    }

    public final void r(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onTabExposed = function0;
    }

    public final void s(b bVar) {
        this.selectFunction = bVar;
    }

    public final void t(boolean z16) {
        this.isTabExposed.setValue(this, f331231h[0], Boolean.valueOf(z16));
    }

    public final void u(boolean z16) {
        this.isTabSelected = z16;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/page/Page$c;", "", "", "position", "", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface c {
        void b(int position);

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes35.dex */
        public static final class a {
            public static void a(c cVar, int i3) {
            }
        }
    }
}
