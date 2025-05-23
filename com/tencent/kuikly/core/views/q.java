package com.tencent.kuikly.core.views;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b/\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b:\u0010;J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J+\u0010\u000f\u001a\u00020\u00042#\u0010\u000e\u001a\u001f\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020\u00040\nj\u0002`\f\u00a2\u0006\u0002\b\rJ+\u0010\u0010\u001a\u00020\u00042#\u0010\u000e\u001a\u001f\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020\u00040\nj\u0002`\f\u00a2\u0006\u0002\b\rJ+\u0010\u0011\u001a\u00020\u00042#\u0010\u000e\u001a\u001f\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020\u00040\nj\u0002`\f\u00a2\u0006\u0002\b\rR+\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00028@@@X\u0080\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R+\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00028@@@X\u0080\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R+\u0010#\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00068@@@X\u0080\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R+\u0010'\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00068@@@X\u0080\u008e\u0002\u00a2\u0006\u0012\n\u0004\b$\u0010\u0014\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R+\u0010+\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00068@@@X\u0080\u008e\u0002\u00a2\u0006\u0012\n\u0004\b(\u0010\u0014\u001a\u0004\b)\u0010 \"\u0004\b*\u0010\"RC\u00102\u001a#\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nj\u0004\u0018\u0001`\f\u00a2\u0006\u0002\b\r8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101RC\u00106\u001a#\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nj\u0004\u0018\u0001`\f\u00a2\u0006\u0002\b\r8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010-\u001a\u0004\b4\u0010/\"\u0004\b5\u00101RC\u00109\u001a#\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nj\u0004\u0018\u0001`\f\u00a2\u0006\u0002\b\r8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010-\u001a\u0004\b7\u0010/\"\u0004\b8\u00101\u00a8\u0006<"}, d2 = {"Lcom/tencent/kuikly/core/views/q;", "Lcom/tencent/kuikly/core/base/k;", "", "value", "", tl.h.F, "", "imageSrc", "i", "k", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/base/ViewContainer;", "Lcom/tencent/kuikly/core/base/ViewBuilder;", "Lkotlin/ExtensionFunctionType;", "creator", "j", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "<set-?>", "a", "Lkotlin/properties/ReadWriteProperty;", DomainData.DOMAIN_NAME, "()Z", "v", "(Z)V", "checked", "b", ReportConstant.COSTREPORT_PREFIX, "setDisable$core_release", "disable", "c", "o", "()Ljava/lang/String;", "w", "(Ljava/lang/String;)V", "checkedImageSrc", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, HippyTKDListViewAdapter.X, "defaultImageSrc", "e", "t", "setDisableImageSrc$core_release", "disableImageSrc", "f", "Lkotlin/jvm/functions/Function1;", "p", "()Lkotlin/jvm/functions/Function1;", "setCheckedViewCreator$core_release", "(Lkotlin/jvm/functions/Function1;)V", "checkedViewCreator", "g", "r", "setDefaultViewCreator$core_release", "defaultViewCreator", "u", "setDisableViewCreator$core_release", "disableViewCreator", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class q extends com.tencent.kuikly.core.base.k {

    /* renamed from: i, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f118508i = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(q.class, "checked", "getChecked$core_release()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(q.class, "disable", "getDisable$core_release()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(q.class, "checkedImageSrc", "getCheckedImageSrc$core_release()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(q.class, "defaultImageSrc", "getDefaultImageSrc$core_release()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(q.class, "disableImageSrc", "getDisableImageSrc$core_release()Ljava/lang/String;", 0))};

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty checked;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty disable;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty checkedImageSrc;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty defaultImageSrc;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty disableImageSrc;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Function1<? super ViewContainer<?, ?>, Unit> checkedViewCreator;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private Function1<? super ViewContainer<?, ?>, Unit> defaultViewCreator;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Function1<? super ViewContainer<?, ?>, Unit> disableViewCreator;

    public q() {
        Boolean bool = Boolean.FALSE;
        this.checked = c01.c.a(bool);
        this.disable = c01.c.a(bool);
        this.checkedImageSrc = c01.c.a("");
        this.defaultImageSrc = c01.c.a("");
        this.disableImageSrc = c01.c.a("");
    }

    public final void h(boolean value) {
        v(value);
    }

    public final void i(String imageSrc) {
        Intrinsics.checkNotNullParameter(imageSrc, "imageSrc");
        w(imageSrc);
    }

    public final void j(Function1<? super ViewContainer<?, ?>, Unit> creator) {
        Intrinsics.checkNotNullParameter(creator, "creator");
        this.checkedViewCreator = creator;
    }

    public final void k(String imageSrc) {
        Intrinsics.checkNotNullParameter(imageSrc, "imageSrc");
        x(imageSrc);
    }

    public final void l(Function1<? super ViewContainer<?, ?>, Unit> creator) {
        Intrinsics.checkNotNullParameter(creator, "creator");
        this.defaultViewCreator = creator;
    }

    public final void m(Function1<? super ViewContainer<?, ?>, Unit> creator) {
        Intrinsics.checkNotNullParameter(creator, "creator");
        this.disableViewCreator = creator;
    }

    public final boolean n() {
        return ((Boolean) this.checked.getValue(this, f118508i[0])).booleanValue();
    }

    public final String o() {
        return (String) this.checkedImageSrc.getValue(this, f118508i[2]);
    }

    public final Function1<ViewContainer<?, ?>, Unit> p() {
        return this.checkedViewCreator;
    }

    public final String q() {
        return (String) this.defaultImageSrc.getValue(this, f118508i[3]);
    }

    public final Function1<ViewContainer<?, ?>, Unit> r() {
        return this.defaultViewCreator;
    }

    public final boolean s() {
        return ((Boolean) this.disable.getValue(this, f118508i[1])).booleanValue();
    }

    public final String t() {
        return (String) this.disableImageSrc.getValue(this, f118508i[4]);
    }

    public final Function1<ViewContainer<?, ?>, Unit> u() {
        return this.disableViewCreator;
    }

    public final void v(boolean z16) {
        this.checked.setValue(this, f118508i[0], Boolean.valueOf(z16));
    }

    public final void w(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.checkedImageSrc.setValue(this, f118508i[2], str);
    }

    public final void x(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.defaultImageSrc.setValue(this, f118508i[3], str);
    }
}
