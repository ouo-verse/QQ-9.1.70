package org.java_websocket.framing;

import org.java_websocket.enums.Opcode;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;

/* compiled from: P */
/* loaded from: classes38.dex */
public abstract class ControlFrame extends FramedataImpl1 {
    public ControlFrame(Opcode opcode) {
        super(opcode);
    }

    @Override // org.java_websocket.framing.FramedataImpl1
    public void isValid() throws InvalidDataException {
        if (isFin()) {
            if (!isRSV1()) {
                if (!isRSV2()) {
                    if (isRSV3()) {
                        throw new InvalidFrameException("Control frame cant have rsv3==true set");
                    }
                    return;
                }
                throw new InvalidFrameException("Control frame cant have rsv2==true set");
            }
            throw new InvalidFrameException("Control frame cant have rsv1==true set");
        }
        throw new InvalidFrameException("Control frame cant have fin==false set");
    }
}
