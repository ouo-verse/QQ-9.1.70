package com.tencent.state.square.data;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/state/square/data/ShareType;", "", "()V", "CONTENT_PLATFORM_LITTLE_WORD", "", "CONTENT_PLATFORM_QQ", "CONTENT_PLATFORM_QZONE", "CONTENT_PLATFORM_WECHAT", "CONTENT_PLATFORM_WECHAT_FRIEND", "OPERATION_SAVE", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final class ShareType {
    public static final int CONTENT_PLATFORM_LITTLE_WORD = 4;
    public static final int CONTENT_PLATFORM_QQ = 0;
    public static final int CONTENT_PLATFORM_QZONE = 1;
    public static final int CONTENT_PLATFORM_WECHAT = 2;
    public static final int CONTENT_PLATFORM_WECHAT_FRIEND = 3;

    @NotNull
    public static final ShareType INSTANCE = new ShareType();
    public static final int OPERATION_SAVE = 1;

    ShareType() {
    }
}
