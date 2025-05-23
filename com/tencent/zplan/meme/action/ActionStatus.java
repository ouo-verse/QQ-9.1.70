package com.tencent.zplan.meme.action;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\nH\u0016\u0082\u0001\u0007\f\r\u000e\u000f\u0010\u0011\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/zplan/meme/action/ActionStatus;", "", "()V", "isEndState", "", "needRetry", "toInt", "", "toReportErrorCode", "toString", "", "Companion", "Lcom/tencent/zplan/meme/action/UNKNOWN;", "Lcom/tencent/zplan/meme/action/INIT;", "Lcom/tencent/zplan/meme/action/START;", "Lcom/tencent/zplan/meme/action/COMPLETE;", "Lcom/tencent/zplan/meme/action/SUB_COMPLETE;", "Lcom/tencent/zplan/meme/action/INTERRUPT;", "Lcom/tencent/zplan/meme/action/ExtendActionStatus;", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public abstract class ActionStatus {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int INT_COMPLETE = 2;
    public static final int INT_ERROR_ACTION_JSON_OUT_DATE = 17;
    public static final int INT_ERROR_ACTION_PANEL_RES_MISS = 7;
    public static final int INT_ERROR_ACTION_RES_MISS = 6;
    public static final int INT_ERROR_APNG_ENCODE_FAIL = 13;
    public static final int INT_ERROR_APNG_ENV_INIT_FAIL = 12;
    public static final int INT_ERROR_APPEARANCEKEY_CHANGE = 28;
    public static final int INT_ERROR_BUILD_ACTION_JS = 10;
    public static final int INT_ERROR_COVER_ENCODE_FAIL = 31;
    public static final int INT_ERROR_ENCODER_OOM = 30;
    public static final int INT_ERROR_ENCODE_NO_FRAME = 19;
    public static final int INT_ERROR_ENGINE_DESTROYED = 18;
    public static final int INT_ERROR_ENGINE_DISCONNECT = 21;
    public static final int INT_ERROR_ENGINE_INIT_FAIL = 20;
    public static final int INT_ERROR_ENGINE_PAUSED = 23;
    public static final int INT_ERROR_ENGINE_RECORD_FAIL = 22;
    public static final int INT_ERROR_FORCE_STOPPED = 32;
    public static final int INT_ERROR_GIF_ENCODE_FAIL = 14;
    public static final int INT_ERROR_JS_CALLBACK_ACTION_FAIL = 5;
    public static final int INT_ERROR_MP4_ENCODE_FAIL = 29;
    public static final int INT_ERROR_RECORD_FRAME_EXCEED = 15;
    public static final int INT_ERROR_RECORD_FRAME_OOM = 16;
    public static final int INT_ERROR_SCRIPT_MISS = 8;
    public static final int INT_ERROR_SHARPP_ENCODE_FAIL = 25;
    public static final int INT_ERROR_SURFACE_NOT_READY = 9;
    public static final int INT_ERROR_TIME_OUT = 11;
    public static final int INT_FRAME_INCORRECT = 26;
    public static final int INT_INIT = 0;
    public static final int INT_INTERRUPT = 3;
    public static final int INT_RECORD_COMPLETE = 4;
    public static final int INT_RESULT_INVALID = 27;
    public static final int INT_START = 1;
    public static final int INT_SUB_COMPLETE = 24;
    public static final int INT_UNKNOWN = -1;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\n\u0010&\u001a\u00020'*\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/tencent/zplan/meme/action/ActionStatus$Companion;", "", "()V", "INT_COMPLETE", "", "INT_ERROR_ACTION_JSON_OUT_DATE", "INT_ERROR_ACTION_PANEL_RES_MISS", "INT_ERROR_ACTION_RES_MISS", "INT_ERROR_APNG_ENCODE_FAIL", "INT_ERROR_APNG_ENV_INIT_FAIL", "INT_ERROR_APPEARANCEKEY_CHANGE", "INT_ERROR_BUILD_ACTION_JS", "INT_ERROR_COVER_ENCODE_FAIL", "INT_ERROR_ENCODER_OOM", "INT_ERROR_ENCODE_NO_FRAME", "INT_ERROR_ENGINE_DESTROYED", "INT_ERROR_ENGINE_DISCONNECT", "INT_ERROR_ENGINE_INIT_FAIL", "INT_ERROR_ENGINE_PAUSED", "INT_ERROR_ENGINE_RECORD_FAIL", "INT_ERROR_FORCE_STOPPED", "INT_ERROR_GIF_ENCODE_FAIL", "INT_ERROR_JS_CALLBACK_ACTION_FAIL", "INT_ERROR_MP4_ENCODE_FAIL", "INT_ERROR_RECORD_FRAME_EXCEED", "INT_ERROR_RECORD_FRAME_OOM", "INT_ERROR_SCRIPT_MISS", "INT_ERROR_SHARPP_ENCODE_FAIL", "INT_ERROR_SURFACE_NOT_READY", "INT_ERROR_TIME_OUT", "INT_FRAME_INCORRECT", "INT_INIT", "INT_INTERRUPT", "INT_RECORD_COMPLETE", "INT_RESULT_INVALID", "INT_START", "INT_SUB_COMPLETE", "INT_UNKNOWN", "toActionStatus", "Lcom/tencent/zplan/meme/action/ActionStatus;", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final ActionStatus toActionStatus(int i3) {
            switch (i3) {
                case 0:
                    return INIT.INSTANCE;
                case 1:
                    return START.INSTANCE;
                case 2:
                    return COMPLETE.INSTANCE;
                case 3:
                    return INTERRUPT.INSTANCE;
                case 4:
                    return RECORD_COMPLETE.INSTANCE;
                case 5:
                    return ERROR_JS_CALLBACK_ACTION_FAIL.INSTANCE;
                case 6:
                    return ERROR_ACTION_RES_MISS.INSTANCE;
                case 7:
                    return ERROR_ACTION_PANEL_RES_MISS.INSTANCE;
                case 8:
                    return ERROR_SCRIPT_MISS.INSTANCE;
                case 9:
                    return ERROR_SURFACE_NOT_READY.INSTANCE;
                case 10:
                    return ERROR_BUILD_ACTION_JS.INSTANCE;
                case 11:
                    return ERROR_TIME_OUT.INSTANCE;
                case 12:
                    return ERROR_APNG_ENV_INIT_FAIL.INSTANCE;
                case 13:
                    return ERROR_APNG_ENCODE_FAIL.INSTANCE;
                case 14:
                    return ERROR_GIF_ENCODE_FAIL.INSTANCE;
                case 15:
                    return ERROR_RECORD_FRAME_EXCEED.INSTANCE;
                case 16:
                    return ERROR_RECORD_FRAME_OOM.INSTANCE;
                case 17:
                    return ERROR_ACTION_JSON_OUT_DATE.INSTANCE;
                case 18:
                    return ERROR_ENGINE_DESTROYED.INSTANCE;
                case 19:
                    return ERROR_ENCODE_NO_FRAME.INSTANCE;
                case 20:
                    return ERROR_ENGINE_INIT_FAIL.INSTANCE;
                case 21:
                    return ERROR_ENGINE_DISCONNECT.INSTANCE;
                case 22:
                    return ERROR_ENGINE_RECORD_FAIL.INSTANCE;
                case 23:
                    return ERROR_ENGINE_PAUSED.INSTANCE;
                case 24:
                    return SUB_COMPLETE.INSTANCE;
                case 25:
                    return ERROR_SHARPP_ENCODE_FAIL.INSTANCE;
                case 26:
                    return ERROR_FRAME_INCORRECT.INSTANCE;
                case 27:
                    return ERROR_RESULT_INVALID.INSTANCE;
                case 28:
                    return ERROR_APPEARANCEKEY_CHANGE.INSTANCE;
                case 29:
                default:
                    return UNKNOWN.INSTANCE;
                case 30:
                    return ERROR_ENCODER_OOM.INSTANCE;
                case 31:
                    return ERROR_COVER_ENCODE_FAIL.INSTANCE;
                case 32:
                    return ERROR_FORCE_STOPPED.INSTANCE;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    ActionStatus() {
    }

    public boolean isEndState() {
        return true;
    }

    public boolean needRetry() {
        return false;
    }

    public abstract int toInt();

    public int toReportErrorCode() {
        return 0;
    }

    @NotNull
    public String toString() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "this::class.java.simpleName");
        return simpleName;
    }

    public /* synthetic */ ActionStatus(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
