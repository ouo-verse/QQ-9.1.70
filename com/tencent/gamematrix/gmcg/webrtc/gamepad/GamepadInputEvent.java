package com.tencent.gamematrix.gmcg.webrtc.gamepad;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GamepadInputEvent {
    public static final int mMsgTypeForCloud = 111;
    public final int mMsgType = 93;
    public final int mDataType = 257;
    public int mInputEventType = 0;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface DataType {
        public static final int GAMEPAD_DATA = 257;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface InputEventType {
        public static final int KEY_EVENT = 1;
        public static final int MOTION_EVENT = 2;
        public static final int NONE = 0;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes6.dex */
    public @interface MsgType {
        public static final int SDK_CLOUDGAME_DATA = 93;
    }
}
