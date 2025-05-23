package org.java_websocket.framing;

import java.nio.ByteBuffer;
import org.java_websocket.enums.Opcode;

/* compiled from: P */
/* loaded from: classes38.dex */
public interface Framedata {
    void append(Framedata framedata);

    Opcode getOpcode();

    ByteBuffer getPayloadData();

    boolean getTransfereMasked();

    boolean isFin();

    boolean isRSV1();

    boolean isRSV2();

    boolean isRSV3();
}
