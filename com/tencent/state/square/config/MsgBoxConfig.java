package com.tencent.state.square.config;

import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/state/square/config/MsgBoxConfig;", "", "()V", "readedMsgValidDay", "", "getReadedMsgValidDay", "()J", "setReadedMsgValidDay", "(J)V", "toString", "", "Companion", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final class MsgBoxConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final long DEFAULT_READ_MSG_VALID_DAY = 259200;
    private static final String KEY_READ_MSG_VALID_DAY = "ReadedMsgValidDay";
    private static final String TAG = "SquareMsgBoxConfig";
    private long readedMsgValidDay = 259200;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/state/square/config/MsgBoxConfig$Companion;", "", "()V", "DEFAULT_READ_MSG_VALID_DAY", "", "KEY_READ_MSG_VALID_DAY", "", "TAG", "parseConfig", "Lcom/tencent/state/square/config/MsgBoxConfig;", "str", "square_base_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes26.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final MsgBoxConfig parseConfig(@NotNull String str) {
            boolean z16;
            Intrinsics.checkNotNullParameter(str, "str");
            if (SquareBase.INSTANCE.getConfig().isDebug() && SquareBaseKt.getSquareLog().isColorLevel()) {
                SquareBaseKt.getSquareLog().d(MsgBoxConfig.TAG, "parseConfig, str=" + str);
            }
            if (str.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return new MsgBoxConfig();
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                MsgBoxConfig msgBoxConfig = new MsgBoxConfig();
                msgBoxConfig.setReadedMsgValidDay(jSONObject.optLong(MsgBoxConfig.KEY_READ_MSG_VALID_DAY, 259200L));
                SquareBaseKt.getSquareLog().d(MsgBoxConfig.TAG, "parseConfig:" + msgBoxConfig);
                return msgBoxConfig;
            } catch (Throwable th5) {
                SquareBaseKt.getSquareLog().e(MsgBoxConfig.TAG, "parseConfig err.", th5);
                return new MsgBoxConfig();
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final long getReadedMsgValidDay() {
        return this.readedMsgValidDay;
    }

    public final void setReadedMsgValidDay(long j3) {
        this.readedMsgValidDay = j3;
    }

    @NotNull
    public String toString() {
        return "validDay:" + this.readedMsgValidDay;
    }
}
