package org.java_websocket.extensions;

import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.framing.Framedata;

/* compiled from: P */
/* loaded from: classes38.dex */
public interface IExtension {
    boolean acceptProvidedExtensionAsClient(String str);

    boolean acceptProvidedExtensionAsServer(String str);

    IExtension copyInstance();

    void decodeFrame(Framedata framedata) throws InvalidDataException;

    void encodeFrame(Framedata framedata);

    String getProvidedExtensionAsClient();

    String getProvidedExtensionAsServer();

    void isFrameValid(Framedata framedata) throws InvalidDataException;

    void reset();

    String toString();
}
