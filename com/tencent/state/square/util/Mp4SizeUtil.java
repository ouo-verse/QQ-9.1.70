package com.tencent.state.square.util;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/state/square/util/Mp4SizeUtil;", "", "()V", "VIDEO_SIZE_PROTECT", "", "formatSize", "originSize", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final class Mp4SizeUtil {

    @NotNull
    public static final Mp4SizeUtil INSTANCE = new Mp4SizeUtil();
    public static final int VIDEO_SIZE_PROTECT = 16;

    Mp4SizeUtil() {
    }

    public final int formatSize(int originSize) {
        return ((int) Math.ceil((originSize * 1.0f) / 16)) * 16;
    }
}
