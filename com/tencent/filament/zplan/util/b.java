package com.tencent.filament.zplan.util;

import com.tencent.filament.zplan.avatar.model.Float4;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J&\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/filament/zplan/util/b;", "", "", "colorValue", "Lcom/tencent/filament/zplan/avatar/model/Float4;", "a", "r", "g", "b", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f106240a = new b();

    b() {
    }

    @NotNull
    public final Float4 a(long colorValue) {
        return new Float4((float) (((16711680 & colorValue) >> 16) / 255.0d), (float) (((65280 & colorValue) >> 8) / 255.0d), (float) ((255 & colorValue) / 255.0d), (float) (((colorValue & 4278190080L) >> 24) / 255.0d));
    }

    public final long b(long r16, long g16, long b16, long a16) {
        return ((r16 << 16) & 16711680) | ((a16 << 24) & 4278190080L) | ((g16 << 8) & 65280) | (255 & b16);
    }
}
