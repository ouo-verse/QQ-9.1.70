package com.tencent.mobileqq.gamecenter.ui;

import android.graphics.Rect;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b3\u0018\u0000 A2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\bF\u0010GJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0018\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\u0002R>\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001`\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u001b\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001f\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\"\u0010%\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010)\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010 \u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R\"\u0010,\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b*\u0010\u0018\"\u0004\b+\u0010\u001aR\"\u0010/\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b-\u0010\u0018\"\u0004\b.\u0010\u001aR\"\u00102\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b0\u0010\u0018\"\u0004\b1\u0010\u001aR\"\u00105\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010\u0016\u001a\u0004\b4\u0010\u0018\"\u0004\b3\u0010\u001aR\"\u00108\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010 \u001a\u0004\b7\u0010\"\"\u0004\b6\u0010$R\"\u0010<\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010 \u001a\u0004\b:\u0010\"\"\u0004\b;\u0010$R\"\u0010>\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010 \u001a\u0004\b=\u0010\"\"\u0004\b9\u0010$R\"\u0010C\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010?\u001a\u0004\b\u001c\u0010@\"\u0004\bA\u0010BR\"\u0010E\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010?\u001a\u0004\b&\u0010@\"\u0004\bD\u0010B\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/ui/aa;", "", "", tl.h.F, "f", "g", "", "screenWidth", "screenHeight", "Landroid/graphics/Rect;", "b", "a", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "Ljava/util/LinkedHashMap;", "d", "()Ljava/util/LinkedHashMap;", "r", "(Ljava/util/LinkedHashMap;)V", "rawParams", "", UserInfo.SEX_FEMALE, "getPercentWidth", "()F", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(F)V", "percentWidth", "c", "getPercentHeight", "p", "percentHeight", "I", "getMinWidth", "()I", DomainData.DOMAIN_NAME, "(I)V", NodeProps.MIN_WIDTH, "e", "getMinHeight", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, NodeProps.MIN_HEIGHT, "getLeft", "l", "left", "getRight", "t", "right", "getTop", "v", "top", "i", "getBottom", "bottom", "j", "getDragable", "dragable", "k", "getSingleton", "u", "singleton", "getKeepOnAioDestroy", "keepOnAioDestroy", "Ljava/lang/String;", "()Ljava/lang/String;", "o", "(Ljava/lang/String;)V", "packageName", ReportConstant.COSTREPORT_PREFIX, "recordKey", "<init>", "()V", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class aa {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private float percentWidth;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private float percentHeight;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int minWidth;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int minHeight;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int dragable;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int singleton;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private int keepOnAioDestroy;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinkedHashMap<String, Object> rawParams = new LinkedHashMap<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float left = -1.0f;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private float right = -1.0f;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float top = -1.0f;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float bottom = -1.0f;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String packageName = "";

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String recordKey = "";

    public final boolean a() {
        if (this.percentWidth <= 0.0f && this.minWidth <= 0) {
            return false;
        }
        if (this.percentHeight <= 0.0f && this.minHeight <= 0) {
            return false;
        }
        return true;
    }

    @Nullable
    public final Rect b(int screenWidth, int screenHeight) {
        int coerceAtLeast;
        int coerceAtLeast2;
        int i3;
        int i16;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(ab.b(this.percentWidth, screenWidth), this.minWidth);
        coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(ab.a(this.percentHeight, screenHeight), this.minHeight);
        float f16 = this.left;
        if (f16 >= 0.0f) {
            i3 = ab.b(f16, screenWidth);
        } else {
            float f17 = this.right;
            if (f17 >= 0.0f) {
                i3 = (screenWidth - ab.b(f17, screenWidth)) - coerceAtLeast;
            } else {
                i3 = (screenWidth - coerceAtLeast) / 2;
            }
        }
        float f18 = this.top;
        if (f18 >= 0.0f) {
            i16 = ab.a(f18, screenHeight);
        } else {
            float f19 = this.bottom;
            if (f19 >= 0.0f) {
                i16 = (screenHeight - ab.a(f19, screenHeight)) - coerceAtLeast2;
            } else {
                i16 = (screenHeight - coerceAtLeast2) / 2;
            }
        }
        if (coerceAtLeast > 0 && coerceAtLeast2 > 0 && i3 >= 0 && i16 >= 0) {
            return new Rect(i3, i16, coerceAtLeast + i3, coerceAtLeast2 + i16);
        }
        return null;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    @NotNull
    public final LinkedHashMap<String, Object> d() {
        return this.rawParams;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getRecordKey() {
        return this.recordKey;
    }

    public final boolean f() {
        if (this.dragable == 1) {
            return true;
        }
        return false;
    }

    public final boolean g() {
        if (this.keepOnAioDestroy == 1) {
            return true;
        }
        return false;
    }

    public final boolean h() {
        if (this.singleton == 1) {
            return true;
        }
        return false;
    }

    public final void i(float f16) {
        this.bottom = f16;
    }

    public final void j(int i3) {
        this.dragable = i3;
    }

    public final void k(int i3) {
        this.keepOnAioDestroy = i3;
    }

    public final void l(float f16) {
        this.left = f16;
    }

    public final void m(int i3) {
        this.minHeight = i3;
    }

    public final void n(int i3) {
        this.minWidth = i3;
    }

    public final void o(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.packageName = str;
    }

    public final void p(float f16) {
        this.percentHeight = f16;
    }

    public final void q(float f16) {
        this.percentWidth = f16;
    }

    public final void r(@NotNull LinkedHashMap<String, Object> linkedHashMap) {
        Intrinsics.checkNotNullParameter(linkedHashMap, "<set-?>");
        this.rawParams = linkedHashMap;
    }

    public final void s(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.recordKey = str;
    }

    public final void t(float f16) {
        this.right = f16;
    }

    public final void u(int i3) {
        this.singleton = i3;
    }

    public final void v(float f16) {
        this.top = f16;
    }
}
