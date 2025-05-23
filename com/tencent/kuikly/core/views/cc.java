package com.tencent.kuikly.core.views;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.module.FontModule;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001d\u0018\u0000 52\u00020\u0001:\u0001,B\u0007\u00a2\u0006\u0004\b3\u00104J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J!\u0010\f\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\f\u0010\rJ!\u0010\u000f\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000e2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\u0000J\u0006\u0010\u0012\u001a\u00020\u0000J\u0006\u0010\u0013\u001a\u00020\u0000J\u0006\u0010\u0014\u001a\u00020\u0000J\u0006\u0010\u0015\u001a\u00020\u0000J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0002J\u000e\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u000eJ\u0006\u0010 \u001a\u00020\u0000J\u0006\u0010!\u001a\u00020\u0019J\u0006\u0010\"\u001a\u00020\u0019J\u0006\u0010#\u001a\u00020\u0019J\u0006\u0010$\u001a\u00020\u0019J\u0006\u0010%\u001a\u00020\u0019J\u0006\u0010&\u001a\u00020\u0019J\u0006\u0010'\u001a\u00020\u0019J\u000e\u0010)\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\nJ\u000e\u0010+\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\nR\"\u00102\u001a\u00020\n8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101\u00a8\u00066"}, d2 = {"Lcom/tencent/kuikly/core/views/cc;", "Lcom/tencent/kuikly/core/base/Attr;", "", "text", "D", "Lcom/tencent/kuikly/core/views/al;", "spans", "r", "", "size", "", "scaleFontSizeEnable", "k", "(FLjava/lang/Boolean;)Lcom/tencent/kuikly/core/views/cc;", "", "l", "(ILjava/lang/Boolean;)Lcom/tencent/kuikly/core/views/cc;", "p", "o", "E", UserInfo.SEX_FEMALE, "G", "Lcom/tencent/kuikly/core/base/h;", "color", "i", "", "H", HippyTKDListViewAdapter.X, "placeholder", "w", "maxLength", "v", "u", "t", ReportConstant.COSTREPORT_PREFIX, "B", BdhLogUtil.LogTag.Tag_Conn, "y", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, WSPublicAccReport.SOP_NAME_FOCUS, tl.h.F, "editable", "j", "a", "Z", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Z", "setAutofocus$core_release", "(Z)V", "autofocus", "<init>", "()V", "b", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class cc extends Attr {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean autofocus;

    public final void A() {
        with("returnKeyType", "next");
    }

    public final void B() {
        with("returnKeyType", "search");
    }

    public final void C() {
        with("returnKeyType", "send");
    }

    public final cc D(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        with("text", text);
        return this;
    }

    public final cc E() {
        with("textAlign", "center");
        return this;
    }

    public final cc F() {
        with("textAlign", "left");
        return this;
    }

    public final cc G() {
        with("textAlign", "right");
        return this;
    }

    public final void H(com.tencent.kuikly.core.base.h color) {
        Intrinsics.checkNotNullParameter(color, "color");
        with("tintColor", color.toString());
    }

    public final void h(boolean focus) {
        this.autofocus = focus;
    }

    public final cc i(com.tencent.kuikly.core.base.h color) {
        Intrinsics.checkNotNullParameter(color, "color");
        with("color", color.toString());
        return this;
    }

    public final void j(boolean editable) {
        with("editable", Integer.valueOf(com.tencent.kuikly.core.base.d.b(editable)));
    }

    public final cc k(float size, Boolean scaleFontSizeEnable) {
        with("fontSize", Float.valueOf(FontModule.INSTANCE.a(size, scaleFontSizeEnable)));
        return this;
    }

    public final cc o() {
        with("fontWeight", "500");
        return this;
    }

    public final cc p() {
        with("fontWeight", IndividuationPlugin.Business_Pendant);
        return this;
    }

    /* renamed from: q, reason: from getter */
    public final boolean getAutofocus() {
        return this.autofocus;
    }

    public final cc r(al spans) {
        Intrinsics.checkNotNullParameter(spans, "spans");
        with("values", spans.b().toString());
        return this;
    }

    public final void s() {
        with("keyboardType", "email");
    }

    public final void t() {
        with("keyboardType", "number");
    }

    public final cc u() {
        with("keyboardType", NotificationActivity.PASSWORD);
        return this;
    }

    public final void v(int maxLength) {
        with("maxTextLength", Integer.valueOf(maxLength));
    }

    public final cc w(String placeholder) {
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        with("placeholder", placeholder);
        return this;
    }

    public final cc x(com.tencent.kuikly.core.base.h color) {
        Intrinsics.checkNotNullParameter(color, "color");
        with("placeholderColor", color.toString());
        return this;
    }

    public final void y() {
        with("returnKeyType", "done");
    }

    public final void z() {
        with("returnKeyType", ResourceAttributes.TelemetrySdkLanguageValues.GO);
    }

    public final cc l(int size, Boolean scaleFontSizeEnable) {
        return k(size, scaleFontSizeEnable);
    }

    public static /* synthetic */ cc m(cc ccVar, float f16, Boolean bool, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            bool = null;
        }
        return ccVar.k(f16, bool);
    }

    public static /* synthetic */ cc n(cc ccVar, int i3, Boolean bool, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            bool = null;
        }
        return ccVar.l(i3, bool);
    }
}
