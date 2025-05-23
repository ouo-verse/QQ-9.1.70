package com.tencent.state.square.media;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/state/square/media/SquareRenderErrorCode;", "", "()V", "ERROR_CODE_FRAME_AVAILABLE_RENDER", "", "ERROR_CODE_PREPARE_GL_RENDER", "ERROR_CODE_PREPARE_GL_RENDER_FAILED", "ERROR_CODE_PREPARE_GL_TEXTURE_RENDER_NULL", "ERROR_CODE_RENDER_IS_DESTROYING", "ERROR_PREPARE_BUT_DISPLAY_RENDER_NOT_NULL", "square_media_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareRenderErrorCode {
    public static final int ERROR_CODE_FRAME_AVAILABLE_RENDER = -1;
    public static final int ERROR_CODE_PREPARE_GL_RENDER = -2;
    public static final int ERROR_CODE_PREPARE_GL_RENDER_FAILED = -6;
    public static final int ERROR_CODE_PREPARE_GL_TEXTURE_RENDER_NULL = -4;
    public static final int ERROR_CODE_RENDER_IS_DESTROYING = -5;
    public static final int ERROR_PREPARE_BUT_DISPLAY_RENDER_NOT_NULL = -3;
    public static final SquareRenderErrorCode INSTANCE = new SquareRenderErrorCode();

    SquareRenderErrorCode() {
    }
}
