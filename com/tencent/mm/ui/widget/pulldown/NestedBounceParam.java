package com.tencent.mm.ui.widget.pulldown;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.luggage.wxa.r0.a;
import com.tencent.luggage.wxa.r0.b;
import com.tencent.luggage.wxa.r0.c;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b=\u0010>J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\"\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0018\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\"\u0010\u001c\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013R\"\u0010 \u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\"\u0010$\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u000f\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R\u0017\u0010*\u001a\u00020%8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0017\u00100\u001a\u00020+8\u0006\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0017\u00105\u001a\u0002018\u0006\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b\u0004\u00104R\"\u00109\u001a\u0002068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<\u00a8\u0006?"}, d2 = {"Lcom/tencent/mm/ui/widget/pulldown/NestedBounceParam;", "", "Lcom/tencent/mm/ui/widget/pulldown/IOverScroll;", "getOverScrollMode", "getHorizontalScrollMode", "", "a", UserInfo.SEX_FEMALE, "getDecelerateRatio", "()F", "setDecelerateRatio", "(F)V", "decelerateRatio", "", "b", "I", "getMaxSpringDuration", "()I", "setMaxSpringDuration", "(I)V", "maxSpringDuration", "c", "getMinSpringDuration", "setMinSpringDuration", "minSpringDuration", "d", "getMinDampingFactor", "setMinDampingFactor", "minDampingFactor", "e", "getMaxDampingFactor", "setMaxDampingFactor", "maxDampingFactor", "f", "getCurMode", "setCurMode", "curMode", "Lcom/tencent/luggage/wxa/r0/b;", "g", "Lcom/tencent/luggage/wxa/r0/b;", "getOverScrollMode1", "()Lcom/tencent/luggage/wxa/r0/b;", "overScrollMode1", "Lcom/tencent/luggage/wxa/r0/c;", h.F, "Lcom/tencent/luggage/wxa/r0/c;", "getOverScrollMode2", "()Lcom/tencent/luggage/wxa/r0/c;", "overScrollMode2", "Lcom/tencent/luggage/wxa/r0/a;", "i", "Lcom/tencent/luggage/wxa/r0/a;", "()Lcom/tencent/luggage/wxa/r0/a;", "horizontalScrollMode", "", "j", "Z", "isPullDownDebugOpen", "()Z", "setPullDownDebugOpen", "(Z)V", "<init>", "()V", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class NestedBounceParam {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static int curMode;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public static boolean isPullDownDebugOpen;

    @NotNull
    public static final NestedBounceParam INSTANCE = new NestedBounceParam();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static float decelerateRatio = 1.0f;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static int maxSpringDuration = 800;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static int minSpringDuration = 400;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static int minDampingFactor = 1;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static int maxDampingFactor = 8;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final b overScrollMode1 = new b();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static final c overScrollMode2 = new c();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public static final a horizontalScrollMode = new a();

    NestedBounceParam() {
    }

    public final int getCurMode() {
        return curMode;
    }

    public final float getDecelerateRatio() {
        return decelerateRatio;
    }

    @NotNull
    public final a getHorizontalScrollMode() {
        return horizontalScrollMode;
    }

    public final int getMaxDampingFactor() {
        return maxDampingFactor;
    }

    public final int getMaxSpringDuration() {
        return maxSpringDuration;
    }

    public final int getMinDampingFactor() {
        return minDampingFactor;
    }

    public final int getMinSpringDuration() {
        return minSpringDuration;
    }

    @NotNull
    public final IOverScroll getOverScrollMode() {
        if (curMode == 1) {
            return overScrollMode2;
        }
        return overScrollMode1;
    }

    @NotNull
    public final b getOverScrollMode1() {
        return overScrollMode1;
    }

    @NotNull
    public final c getOverScrollMode2() {
        return overScrollMode2;
    }

    public final boolean isPullDownDebugOpen() {
        return isPullDownDebugOpen;
    }

    public final void setCurMode(int i3) {
        curMode = i3;
    }

    public final void setDecelerateRatio(float f16) {
        decelerateRatio = f16;
    }

    public final void setMaxDampingFactor(int i3) {
        maxDampingFactor = i3;
    }

    public final void setMaxSpringDuration(int i3) {
        maxSpringDuration = i3;
    }

    public final void setMinDampingFactor(int i3) {
        minDampingFactor = i3;
    }

    public final void setMinSpringDuration(int i3) {
        minSpringDuration = i3;
    }

    public final void setPullDownDebugOpen(boolean z16) {
        isPullDownDebugOpen = z16;
    }

    @NotNull
    /* renamed from: getHorizontalScrollMode, reason: collision with other method in class */
    public final IOverScroll m165getHorizontalScrollMode() {
        return horizontalScrollMode;
    }
}
