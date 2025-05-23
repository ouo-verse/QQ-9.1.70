package com.tencent.kuikly.core.render.android.expand.module;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002H&\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/module/s;", "", "", "height", "", "duration", "curveType", "", "a", "(ILjava/lang/Float;Ljava/lang/Integer;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public interface s {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ void a(s sVar, int i3, Float f16, Integer num, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    f16 = null;
                }
                if ((i16 & 4) != 0) {
                    num = null;
                }
                sVar.a(i3, f16, num);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onHeightChanged");
        }
    }

    void a(int height, @Nullable Float duration, @Nullable Integer curveType);
}
