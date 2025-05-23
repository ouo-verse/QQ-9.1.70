package com.tencent.mobileqq.onlinestatus.model;

import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.DebugKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u0000 \r2\u00020\u0001:\u0001\tB%\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cB\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001b\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002J\b\u0010\n\u001a\u00020\u0004H\u0016R\"\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0014\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/model/f;", "", "", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "", "f", "b", "value", "", "a", "toString", "", "Z", "d", "()Z", tl.h.F, "(Z)V", "grayWhiteSwitch", "c", "g", "autoWhiteSwitch", "I", "e", "()I", "i", "(I)V", "panelSwitch", "<init>", "(ZZI)V", "qqonlinestatus-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean grayWhiteSwitch;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean autoWhiteSwitch;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int panelSwitch;

    public f() {
        this(false, false, 0, 7, null);
    }

    private final String f(int r26) {
        if (r26 != 0) {
            if (r26 != 1) {
                if (r26 != 3) {
                    return "unknown";
                }
                return "on";
            }
            return DebugKt.DEBUG_PROPERTY_VALUE_OFF;
        }
        return "not set";
    }

    public final void a(int value) {
        this.panelSwitch = value & 3;
        if ((value & 4) != 0) {
            this.autoWhiteSwitch = true;
        }
        if ((value & 8) != 0) {
            this.grayWhiteSwitch = true;
        }
    }

    public final int b() {
        int i3 = this.panelSwitch;
        int i16 = 0;
        if (i3 != 0) {
            i16 = 0 + (i3 & 3);
        }
        if (this.autoWhiteSwitch) {
            i16 += 4;
        }
        if (this.grayWhiteSwitch) {
            return i16 + 8;
        }
        return i16;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getAutoWhiteSwitch() {
        return this.autoWhiteSwitch;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getGrayWhiteSwitch() {
        return this.grayWhiteSwitch;
    }

    /* renamed from: e, reason: from getter */
    public final int getPanelSwitch() {
        return this.panelSwitch;
    }

    public final void g(boolean z16) {
        this.autoWhiteSwitch = z16;
    }

    public final void h(boolean z16) {
        this.grayWhiteSwitch = z16;
    }

    public final void i(int i3) {
        this.panelSwitch = i3;
    }

    @NotNull
    public String toString() {
        return "{gray:" + this.grayWhiteSwitch + ",autoWhite:" + this.autoWhiteSwitch + ",panel:" + f(this.panelSwitch) + '}';
    }

    public f(boolean z16, boolean z17, int i3) {
        this.grayWhiteSwitch = z16;
        this.autoWhiteSwitch = z17;
        this.panelSwitch = i3;
    }

    public /* synthetic */ f(boolean z16, boolean z17, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? false : z16, (i16 & 2) != 0 ? false : z17, (i16 & 4) != 0 ? 0 : i3);
    }

    public f(int i3) {
        this(false, false, 0, 7, null);
        a(i3);
    }
}
