package org.java_websocket.framing;

import org.java_websocket.enums.Opcode;
import org.java_websocket.exceptions.InvalidDataException;

/* compiled from: P */
/* loaded from: classes38.dex */
public abstract class DataFrame extends FramedataImpl1 {
    public DataFrame(Opcode opcode) {
        super(opcode);
    }

    @Override // org.java_websocket.framing.FramedataImpl1
    public void isValid() throws InvalidDataException {
    }
}
