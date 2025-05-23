package com.tencent.filament.zplan.avatar;

import androidx.annotation.Keep;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.cookie.ClientCookie;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/filament/zplan/avatar/ClearOptions;", "", "clearColor", "", QCircleLpReportDc05507.KEY_CLEAR, "", ClientCookie.DISCARD_ATTR, "([FZZ)V", "getClear", "()Z", "setClear", "(Z)V", "getClearColor", "()[F", "setClearColor", "([F)V", "getDiscard", "setDiscard", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class ClearOptions {
    private boolean clear;

    @NotNull
    private float[] clearColor;
    private boolean discard;

    public ClearOptions() {
        this(null, false, false, 7, null);
    }

    public final boolean getClear() {
        return this.clear;
    }

    @NotNull
    public final float[] getClearColor() {
        return this.clearColor;
    }

    public final boolean getDiscard() {
        return this.discard;
    }

    public final void setClear(boolean z16) {
        this.clear = z16;
    }

    public final void setClearColor(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<set-?>");
        this.clearColor = fArr;
    }

    public final void setDiscard(boolean z16) {
        this.discard = z16;
    }

    public ClearOptions(@NotNull float[] clearColor, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(clearColor, "clearColor");
        this.clearColor = clearColor;
        this.clear = z16;
        this.discard = z17;
    }

    public /* synthetic */ ClearOptions(float[] fArr, boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new float[]{0.0f, 0.0f, 0.0f, 0.0f} : fArr, (i3 & 2) != 0 ? true : z16, (i3 & 4) != 0 ? true : z17);
    }
}
