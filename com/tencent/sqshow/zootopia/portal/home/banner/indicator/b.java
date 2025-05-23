package com.tencent.sqshow.zootopia.portal.home.banner.indicator;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b<\u0010=R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0014\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b&\u0010\bR\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\"\u0010-\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u0004\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\"\u00103\u001a\u00020.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010/\u001a\u0004\b\u0003\u00100\"\u0004\b1\u00102R\"\u00105\u001a\u00020.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010/\u001a\u0004\b\n\u00100\"\u0004\b4\u00102R\"\u0010;\u001a\u0002068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u00107\u001a\u0004\b\"\u00108\"\u0004\b9\u0010:\u00a8\u0006>"}, d2 = {"Lcom/tencent/sqshow/zootopia/portal/home/banner/indicator/b;", "", "", "a", "I", "f", "()I", "t", "(I)V", "indicatorSize", "b", "c", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "currentPosition", "Lcom/tencent/sqshow/zootopia/portal/home/banner/indicator/Direction;", "Lcom/tencent/sqshow/zootopia/portal/home/banner/indicator/Direction;", "d", "()Lcom/tencent/sqshow/zootopia/portal/home/banner/indicator/Direction;", "r", "(Lcom/tencent/sqshow/zootopia/portal/home/banner/indicator/Direction;)V", LayoutAttrDefine.Gravity.Gravity, "g", "u", "indicatorSpace", "e", "j", HippyTKDListViewAdapter.X, "normalWidth", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "selectedWidth", "i", "w", "normalColor", h.F, "k", "y", "selectedColor", ReportConstant.COSTREPORT_PREFIX, "height", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "selectedDrawableRes", DomainData.DOMAIN_NAME, "B", "unSelectedDrawableRes", "", "Z", "()Z", "o", "(Z)V", "attachToBanner", "p", "autoHideWhenSingle", "Lcom/tencent/sqshow/zootopia/portal/home/banner/indicator/c;", "Lcom/tencent/sqshow/zootopia/portal/home/banner/indicator/c;", "()Lcom/tencent/sqshow/zootopia/portal/home/banner/indicator/c;", "v", "(Lcom/tencent/sqshow/zootopia/portal/home/banner/indicator/c;)V", "margins", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int indicatorSize;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int currentPosition;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Direction gravity = Direction.CENTER;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int indicatorSpace;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int normalWidth;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int selectedWidth;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int normalColor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int selectedColor;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int height;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int selectedDrawableRes;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int unSelectedDrawableRes;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean attachToBanner;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean autoHideWhenSingle;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private c margins;

    public b() {
        ra4.a aVar = ra4.a.f431010a;
        this.indicatorSpace = aVar.e();
        this.normalWidth = aVar.c();
        this.selectedWidth = aVar.d();
        this.normalColor = -1996488705;
        this.selectedColor = -1;
        this.height = aVar.a();
        this.selectedDrawableRes = -1;
        this.unSelectedDrawableRes = -1;
        this.attachToBanner = true;
        this.margins = new c();
    }

    public final void A(int i3) {
        this.selectedWidth = i3;
    }

    public final void B(int i3) {
        this.unSelectedDrawableRes = i3;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getAttachToBanner() {
        return this.attachToBanner;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getAutoHideWhenSingle() {
        return this.autoHideWhenSingle;
    }

    /* renamed from: c, reason: from getter */
    public final int getCurrentPosition() {
        return this.currentPosition;
    }

    /* renamed from: d, reason: from getter */
    public final Direction getGravity() {
        return this.gravity;
    }

    /* renamed from: e, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: f, reason: from getter */
    public final int getIndicatorSize() {
        return this.indicatorSize;
    }

    /* renamed from: g, reason: from getter */
    public final int getIndicatorSpace() {
        return this.indicatorSpace;
    }

    /* renamed from: h, reason: from getter */
    public final c getMargins() {
        return this.margins;
    }

    /* renamed from: i, reason: from getter */
    public final int getNormalColor() {
        return this.normalColor;
    }

    /* renamed from: j, reason: from getter */
    public final int getNormalWidth() {
        return this.normalWidth;
    }

    /* renamed from: k, reason: from getter */
    public final int getSelectedColor() {
        return this.selectedColor;
    }

    /* renamed from: l, reason: from getter */
    public final int getSelectedDrawableRes() {
        return this.selectedDrawableRes;
    }

    /* renamed from: m, reason: from getter */
    public final int getSelectedWidth() {
        return this.selectedWidth;
    }

    /* renamed from: n, reason: from getter */
    public final int getUnSelectedDrawableRes() {
        return this.unSelectedDrawableRes;
    }

    public final void o(boolean z16) {
        this.attachToBanner = z16;
    }

    public final void p(boolean z16) {
        this.autoHideWhenSingle = z16;
    }

    public final void q(int i3) {
        this.currentPosition = i3;
    }

    public final void r(Direction direction) {
        Intrinsics.checkNotNullParameter(direction, "<set-?>");
        this.gravity = direction;
    }

    public final void s(int i3) {
        this.height = i3;
    }

    public final void t(int i3) {
        this.indicatorSize = i3;
    }

    public final void u(int i3) {
        this.indicatorSpace = i3;
    }

    public final void v(c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<set-?>");
        this.margins = cVar;
    }

    public final void w(int i3) {
        this.normalColor = i3;
    }

    public final void x(int i3) {
        this.normalWidth = i3;
    }

    public final void y(int i3) {
        this.selectedColor = i3;
    }

    public final void z(int i3) {
        this.selectedDrawableRes = i3;
    }
}
