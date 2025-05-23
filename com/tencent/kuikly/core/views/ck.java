package com.tencent.kuikly.core.views;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.kuikly.core.base.AbstractBaseView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.FloatCompanionObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b/\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bC\u0010DJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002J,\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u0002J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013J(\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0016R\"\u0010\u001e\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010%\u001a\u00020\b8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010)\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u0019\u001a\u0004\b'\u0010\u001b\"\u0004\b(\u0010\u001dR\"\u0010-\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010\u0019\u001a\u0004\b+\u0010\u001b\"\u0004\b,\u0010\u001dR\"\u00101\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010\u0019\u001a\u0004\b/\u0010\u001b\"\u0004\b0\u0010\u001dR\"\u00105\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010\u0019\u001a\u0004\b3\u0010\u001b\"\u0004\b4\u0010\u001dR\"\u00109\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010\u0019\u001a\u0004\b7\u0010\u001b\"\u0004\b8\u0010\u001dR\"\u0010<\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0019\u001a\u0004\b:\u0010\u001b\"\u0004\b;\u0010\u001dR\"\u0010B\u001a\u00020\u00138\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010A\u00a8\u0006E"}, d2 = {"Lcom/tencent/kuikly/core/views/ck;", "Lcom/tencent/kuikly/core/views/ao;", "", "width", "", "w", "height", "v", "", "count", tl.h.F, "spacing", "t", "u", "top", "left", "bottom", "right", "i", "", "plainLayoutMode", "r", "Lcom/tencent/kuikly/core/base/m;", "padding", "a", UserInfo.SEX_FEMALE, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()F", "setListWidth$core_release", "(F)V", "listWidth", "b", "I", "j", "()I", "setColumnCount$core_release", "(I)V", "columnCount", "c", "p", "setLineSpacing$core_release", "lineSpacing", "d", "o", "setItemSpacing$core_release", "itemSpacing", "e", "l", "setContentPaddingLeft$core_release", "contentPaddingLeft", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setContentPaddingRight$core_release", "contentPaddingRight", "g", "k", "setContentPaddingBottom$core_release", "contentPaddingBottom", DomainData.DOMAIN_NAME, "setContentPaddingTop$core_release", "contentPaddingTop", "Z", ReportConstant.COSTREPORT_PREFIX, "()Z", "setPlainLayoutMode$core_release", "(Z)V", "isPlainLayoutMode", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ck extends ao {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private float listWidth;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int columnCount = 1;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private float lineSpacing;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float itemSpacing;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float contentPaddingLeft;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float contentPaddingRight;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private float contentPaddingBottom;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float contentPaddingTop;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isPlainLayoutMode;

    public final void h(int count) {
        if (this.columnCount == count || count <= 0) {
            return;
        }
        this.columnCount = count;
        AbstractBaseView<?, ?> view = view();
        cm cmVar = view instanceof cm ? (cm) view : null;
        if (cmVar != null) {
            cmVar.j();
        }
    }

    public final void i(float top, float left, float bottom, float right) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        boolean z16 = true;
        if (!(Float.isNaN(top) || Float.isNaN(Float.NaN) ? Float.isNaN(top) && Float.isNaN(Float.NaN) : Math.abs(Float.NaN - top) < 1.0E-5f)) {
            this.contentPaddingTop = top;
        }
        if (!(Float.isNaN(left) || Float.isNaN(Float.NaN) ? Float.isNaN(left) && Float.isNaN(Float.NaN) : Math.abs(Float.NaN - left) < 1.0E-5f)) {
            this.contentPaddingLeft = left;
        }
        if (!(Float.isNaN(bottom) || Float.isNaN(Float.NaN) ? Float.isNaN(bottom) && Float.isNaN(Float.NaN) : Math.abs(Float.NaN - bottom) < 1.0E-5f)) {
            this.contentPaddingBottom = bottom;
        }
        if (Float.isNaN(right) || Float.isNaN(Float.NaN) ? !Float.isNaN(right) || !Float.isNaN(Float.NaN) : Math.abs(Float.NaN - right) >= 1.0E-5f) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        this.contentPaddingRight = right;
    }

    /* renamed from: j, reason: from getter */
    public final int getColumnCount() {
        return this.columnCount;
    }

    /* renamed from: k, reason: from getter */
    public final float getContentPaddingBottom() {
        return this.contentPaddingBottom;
    }

    /* renamed from: l, reason: from getter */
    public final float getContentPaddingLeft() {
        return this.contentPaddingLeft;
    }

    /* renamed from: m, reason: from getter */
    public final float getContentPaddingRight() {
        return this.contentPaddingRight;
    }

    /* renamed from: n, reason: from getter */
    public final float getContentPaddingTop() {
        return this.contentPaddingTop;
    }

    /* renamed from: o, reason: from getter */
    public final float getItemSpacing() {
        return this.itemSpacing;
    }

    /* renamed from: p, reason: from getter */
    public final float getLineSpacing() {
        return this.lineSpacing;
    }

    /* renamed from: q, reason: from getter */
    public final float getListWidth() {
        return this.listWidth;
    }

    public final void r(boolean plainLayoutMode) {
        this.isPlainLayoutMode = plainLayoutMode;
    }

    /* renamed from: s, reason: from getter */
    public final boolean getIsPlainLayoutMode() {
        return this.isPlainLayoutMode;
    }

    public final void t(float spacing) {
        this.itemSpacing = spacing;
    }

    public final void u(float spacing) {
        this.lineSpacing = spacing;
    }

    public final void v(float height) {
        this.listWidth = height;
        mo141height(height);
    }

    public final void w(float width) {
        this.listWidth = width;
        mo153width(width);
    }

    @Override // com.tencent.kuikly.core.base.m, com.tencent.kuikly.core.base.attr.a
    public com.tencent.kuikly.core.base.m padding(float top, float left, float bottom, float right) {
        i(top, left, bottom, right);
        return this;
    }
}
