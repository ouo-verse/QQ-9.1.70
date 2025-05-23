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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b!\u0018\u0000 12\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b/\u00100J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J!\u0010\t\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\t\u0010\nJ!\u0010\f\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u000b2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u000e\u001a\u00020\u0000J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0002J\u0006\u0010\u0017\u001a\u00020\u0011J\u0006\u0010\u0018\u001a\u00020\u0011J\u0006\u0010\u0019\u001a\u00020\u0011J\u0006\u0010\u001a\u001a\u00020\u0011J\u0006\u0010\u001b\u001a\u00020\u0011J\u0006\u0010\u001c\u001a\u00020\u0011J\u0006\u0010\u001d\u001a\u00020\u0011J\u0006\u0010\u001e\u001a\u00020\u0011J\u0006\u0010\u001f\u001a\u00020\u0000J\u0006\u0010 \u001a\u00020\u0000J\u0006\u0010!\u001a\u00020\u0000J\u000e\u0010#\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u000bJ\u000e\u0010%\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u0007J\u000e\u0010'\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u0007R\"\u0010.\u001a\u00020\u00078\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-\u00a8\u00062"}, d2 = {"Lcom/tencent/kuikly/core/views/ai;", "Lcom/tencent/kuikly/core/base/Attr;", "", "text", "B", "", "size", "", "scaleFontSizeEnable", "k", "(FLjava/lang/Boolean;)Lcom/tencent/kuikly/core/views/ai;", "", "l", "(ILjava/lang/Boolean;)Lcom/tencent/kuikly/core/views/ai;", "o", "Lcom/tencent/kuikly/core/base/h;", "color", "", "i", UserInfo.SEX_FEMALE, "v", "placeholder", "u", ReportConstant.COSTREPORT_PREFIX, "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "w", "y", HippyTKDListViewAdapter.X, BdhLogUtil.LogTag.Tag_Conn, "D", "E", "maxLength", "t", WSPublicAccReport.SOP_NAME_FOCUS, tl.h.F, "editable", "j", "a", "Z", "p", "()Z", "setAutofocus$core_release", "(Z)V", "autofocus", "<init>", "()V", "b", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ai extends Attr {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean autofocus;

    public final void A() {
        with("returnKeyType", "send");
    }

    public final ai B(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        with("text", text);
        return this;
    }

    public final ai C() {
        with("textAlign", "center");
        return this;
    }

    public final ai D() {
        with("textAlign", "left");
        return this;
    }

    public final ai E() {
        with("textAlign", "right");
        return this;
    }

    public final void F(com.tencent.kuikly.core.base.h color) {
        Intrinsics.checkNotNullParameter(color, "color");
        with("tintColor", color.toString());
    }

    public final void h(boolean focus) {
        this.autofocus = focus;
    }

    public final void i(com.tencent.kuikly.core.base.h color) {
        Intrinsics.checkNotNullParameter(color, "color");
        with("color", color.toString());
    }

    public final void j(boolean editable) {
        with("editable", Integer.valueOf(com.tencent.kuikly.core.base.d.b(editable)));
    }

    public final ai k(float size, Boolean scaleFontSizeEnable) {
        with("fontSize", Float.valueOf(FontModule.INSTANCE.a(size, scaleFontSizeEnable)));
        return this;
    }

    public final ai o() {
        with("fontWeight", IndividuationPlugin.Business_Profilecard);
        return this;
    }

    /* renamed from: p, reason: from getter */
    public final boolean getAutofocus() {
        return this.autofocus;
    }

    public final void q() {
        with("keyboardType", "email");
    }

    public final void r() {
        with("keyboardType", "number");
    }

    public final void s() {
        with("keyboardType", NotificationActivity.PASSWORD);
    }

    public final void t(int maxLength) {
        with("maxTextLength", Integer.valueOf(maxLength));
    }

    public final void u(String placeholder) {
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        with("placeholder", placeholder);
    }

    public final void v(com.tencent.kuikly.core.base.h color) {
        Intrinsics.checkNotNullParameter(color, "color");
        with("placeholderColor", color.toString());
    }

    public final void w() {
        with("returnKeyType", "done");
    }

    public final void x() {
        with("returnKeyType", ResourceAttributes.TelemetrySdkLanguageValues.GO);
    }

    public final void y() {
        with("returnKeyType", "next");
    }

    public final void z() {
        with("returnKeyType", "search");
    }

    public final ai l(int size, Boolean scaleFontSizeEnable) {
        return k(size, scaleFontSizeEnable);
    }

    public static /* synthetic */ ai m(ai aiVar, float f16, Boolean bool, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            bool = null;
        }
        return aiVar.k(f16, bool);
    }

    public static /* synthetic */ ai n(ai aiVar, int i3, Boolean bool, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            bool = null;
        }
        return aiVar.l(i3, bool);
    }
}
