package org.java_websocket.framing;

import org.java_websocket.enums.Opcode;

/* loaded from: classes38.dex */
public class PingFrame extends ControlFrame {
    public PingFrame() {
        super(Opcode.PING);
    }
}
