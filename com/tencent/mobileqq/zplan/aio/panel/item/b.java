package com.tencent.mobileqq.zplan.aio.panel.item;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000f\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b8\u00109J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016R+\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR+\u0010\u0011\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0016\u001a\u00020\u00138&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00178&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001d\u001a\u00020\u00038&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR\u0014\u0010\u001e\u001a\u00020\u00038&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\rR\u0014\u0010\"\u001a\u00020\u001f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010!R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010%R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010%R\u0014\u0010*\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010\rR\u0016\u0010-\u001a\u0004\u0018\u00010+8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010,R\u001c\u00100\u001a\u00020\u00038&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b.\u0010\r\"\u0004\b/\u0010\u000fR\u0014\u00102\u001a\u00020\u00038&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b1\u0010\rR\u0014\u00105\u001a\u00020+8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b3\u00104R\u0014\u00107\u001a\u00020+8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b6\u00104\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/item/b;", "", "Lkotlinx/coroutines/Deferred;", "", "t", "", DomainData.DOMAIN_NAME, "needLoad", "o", "<set-?>", "a", "Lkotlin/properties/ReadWriteProperty;", "isExposed", "()Z", "p", "(Z)V", "b", "isLoading", "r", "", "k", "()Ljava/lang/String;", "text", "Lcom/tencent/mobileqq/zplan/aio/panel/item/a;", "g", "()Lcom/tencent/mobileqq/zplan/aio/panel/item/a;", "identifying", "j", ReportConstant.COSTREPORT_PREFIX, "selected", "canSelected", "Lkotlinx/coroutines/CoroutineScope;", "i", "()Lkotlinx/coroutines/CoroutineScope;", "scope", "Landroid/graphics/drawable/Drawable;", "l", "()Lkotlinx/coroutines/Deferred;", "thumbnailJob", "d", "contentLoadingJob", "c", "clipToOutline", "", "()Ljava/lang/Integer;", "backgroundColor", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "has", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isNeedPay", h.F, "()I", "price", "f", "id", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public abstract class b {

    /* renamed from: c, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f331175c = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(b.class, "isExposed", "isExposed()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(b.class, "isLoading", "isLoading()Z", 0))};

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty isExposed;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty isLoading;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J+\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0014\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "Lkotlin/reflect/KProperty;", "property", "oldValue", "newValue", "", "afterChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a extends ObservableProperty<Boolean> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f331178b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Object obj, b bVar) {
            super(obj);
            this.f331178b = bVar;
        }

        @Override // kotlin.properties.ObservableProperty
        protected void afterChange(KProperty<?> property, Boolean oldValue, Boolean newValue) {
            Intrinsics.checkNotNullParameter(property, "property");
            boolean booleanValue = newValue.booleanValue();
            if (oldValue.booleanValue() || !booleanValue) {
                return;
            }
            this.f331178b.n();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J+\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0014\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "Lkotlin/reflect/KProperty;", "property", "oldValue", "newValue", "", "afterChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.aio.panel.item.b$b, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    public static final class C9143b extends ObservableProperty<Boolean> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f331179b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C9143b(Object obj, b bVar) {
            super(obj);
            this.f331179b = bVar;
        }

        @Override // kotlin.properties.ObservableProperty
        protected void afterChange(KProperty<?> property, Boolean oldValue, Boolean newValue) {
            Intrinsics.checkNotNullParameter(property, "property");
            boolean booleanValue = newValue.booleanValue();
            boolean booleanValue2 = oldValue.booleanValue();
            if (!booleanValue2 && booleanValue) {
                this.f331179b.o(true);
            } else {
                if (!booleanValue2 || booleanValue) {
                    return;
                }
                this.f331179b.o(false);
            }
        }
    }

    public b() {
        Delegates delegates = Delegates.INSTANCE;
        Boolean bool = Boolean.FALSE;
        this.isExposed = new a(bool, this);
        this.isLoading = new C9143b(bool, this);
    }

    public abstract boolean b();

    public boolean c() {
        return true;
    }

    public abstract Deferred<Boolean> d();

    public abstract boolean e();

    public abstract int f();

    public abstract Identifying g();

    public abstract int h();

    public abstract CoroutineScope i();

    public abstract boolean j();

    public abstract String k();

    public abstract Deferred<Drawable> l();

    public abstract boolean m();

    public final void p(boolean z16) {
        this.isExposed.setValue(this, f331175c[0], Boolean.valueOf(z16));
    }

    public abstract void q(boolean z16);

    public final void r(boolean z16) {
        this.isLoading.setValue(this, f331175c[1], Boolean.valueOf(z16));
    }

    public abstract void s(boolean z16);

    public abstract Deferred<Boolean> t();

    public Integer a() {
        return Integer.valueOf(Color.rgb(245, 245, 245));
    }

    public void n() {
    }

    public void o(boolean needLoad) {
    }
}
