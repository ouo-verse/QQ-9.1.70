package com.tencent.kuikly.core.render.android.expand.component.blur;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\u0002J\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002J\u0016\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002R\u0014\u0010\u0010\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/blur/m;", "", "", "value", "c", "", "a", "width", "height", "Lkotlin/Pair;", "d", "measuredWidth", "measuredHeight", "", "b", UserInfo.SEX_FEMALE, "scaleFactor", "<init>", "(F)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
final class m {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final float scaleFactor;

    public m(float f16) {
        this.scaleFactor = f16;
    }

    private final int a(float value) {
        return (int) Math.ceil(value / this.scaleFactor);
    }

    private final int c(int value) {
        int i3 = value % 64;
        if (i3 != 0) {
            return (value - i3) + 64;
        }
        return value;
    }

    public final boolean b(int measuredWidth, int measuredHeight) {
        if (a(measuredHeight) != 0 && a(measuredWidth) != 0) {
            return false;
        }
        return true;
    }

    @NotNull
    public final Pair<Integer, Integer> d(int width, int height) {
        return new Pair<>(Integer.valueOf(c(a(width))), Integer.valueOf((int) Math.ceil(height / (r3 / r0))));
    }
}
