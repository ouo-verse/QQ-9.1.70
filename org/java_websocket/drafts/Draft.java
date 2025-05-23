package org.java_websocket.drafts;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.httpcore.HttpHeaders;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.enums.CloseHandshakeType;
import org.java_websocket.enums.HandshakeState;
import org.java_websocket.enums.Opcode;
import org.java_websocket.enums.Role;
import org.java_websocket.exceptions.IncompleteHandshakeException;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.framing.BinaryFrame;
import org.java_websocket.framing.ContinuousFrame;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.FramedataImpl1;
import org.java_websocket.framing.TextFrame;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.ClientHandshakeBuilder;
import org.java_websocket.handshake.HandshakeBuilder;
import org.java_websocket.handshake.HandshakeImpl1Client;
import org.java_websocket.handshake.HandshakeImpl1Server;
import org.java_websocket.handshake.Handshakedata;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.handshake.ServerHandshakeBuilder;
import org.java_websocket.util.Charsetfunctions;

/* compiled from: P */
/* loaded from: classes38.dex */
public abstract class Draft {
    protected Role role = null;
    protected Opcode continuousFrameType = null;

    public static ByteBuffer readLine(ByteBuffer byteBuffer) {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        byte b16 = 48;
        while (byteBuffer.hasRemaining()) {
            byte b17 = byteBuffer.get();
            allocate.put(b17);
            if (b16 == 13 && b17 == 10) {
                allocate.limit(allocate.position() - 2);
                allocate.position(0);
                return allocate;
            }
            b16 = b17;
        }
        byteBuffer.position(byteBuffer.position() - allocate.position());
        return null;
    }

    public static String readStringLine(ByteBuffer byteBuffer) {
        ByteBuffer readLine = readLine(byteBuffer);
        if (readLine == null) {
            return null;
        }
        return Charsetfunctions.stringAscii(readLine.array(), 0, readLine.limit());
    }

    public static HandshakeBuilder translateHandshakeHttp(ByteBuffer byteBuffer, Role role) throws InvalidHandshakeException {
        HandshakeBuilder translateHandshakeHttpServer;
        String readStringLine = readStringLine(byteBuffer);
        if (readStringLine != null) {
            String[] split = readStringLine.split(" ", 3);
            if (split.length == 3) {
                if (role == Role.CLIENT) {
                    translateHandshakeHttpServer = translateHandshakeHttpClient(split, readStringLine);
                } else {
                    translateHandshakeHttpServer = translateHandshakeHttpServer(split, readStringLine);
                }
                String readStringLine2 = readStringLine(byteBuffer);
                while (readStringLine2 != null && readStringLine2.length() > 0) {
                    String[] split2 = readStringLine2.split(":", 2);
                    if (split2.length == 2) {
                        if (translateHandshakeHttpServer.hasFieldValue(split2[0])) {
                            translateHandshakeHttpServer.put(split2[0], translateHandshakeHttpServer.getFieldValue(split2[0]) + "; " + split2[1].replaceFirst("^ +", ""));
                        } else {
                            translateHandshakeHttpServer.put(split2[0], split2[1].replaceFirst("^ +", ""));
                        }
                        readStringLine2 = readStringLine(byteBuffer);
                    } else {
                        throw new InvalidHandshakeException("not an http header");
                    }
                }
                if (readStringLine2 != null) {
                    return translateHandshakeHttpServer;
                }
                throw new IncompleteHandshakeException();
            }
            throw new InvalidHandshakeException();
        }
        throw new IncompleteHandshakeException(byteBuffer.capacity() + 128);
    }

    public abstract HandshakeState acceptHandshakeAsClient(ClientHandshake clientHandshake, ServerHandshake serverHandshake) throws InvalidHandshakeException;

    public abstract HandshakeState acceptHandshakeAsServer(ClientHandshake clientHandshake) throws InvalidHandshakeException;

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean basicAccept(Handshakedata handshakedata) {
        return handshakedata.getFieldValue(HttpHeaders.UPGRADE).equalsIgnoreCase("websocket") && handshakedata.getFieldValue("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade");
    }

    public List<Framedata> continuousFrame(Opcode opcode, ByteBuffer byteBuffer, boolean z16) {
        FramedataImpl1 textFrame;
        Opcode opcode2 = Opcode.BINARY;
        if (opcode != opcode2 && opcode != Opcode.TEXT) {
            throw new IllegalArgumentException("Only Opcode.BINARY or  Opcode.TEXT are allowed");
        }
        if (this.continuousFrameType != null) {
            textFrame = new ContinuousFrame();
        } else {
            this.continuousFrameType = opcode;
            if (opcode == opcode2) {
                textFrame = new BinaryFrame();
            } else {
                textFrame = opcode == Opcode.TEXT ? new TextFrame() : null;
            }
        }
        textFrame.setPayload(byteBuffer);
        textFrame.setFin(z16);
        try {
            textFrame.isValid();
            if (z16) {
                this.continuousFrameType = null;
            } else {
                this.continuousFrameType = opcode;
            }
            return Collections.singletonList(textFrame);
        } catch (InvalidDataException e16) {
            throw new IllegalArgumentException(e16);
        }
    }

    public abstract Draft copyInstance();

    public abstract ByteBuffer createBinaryFrame(Framedata framedata);

    public abstract List<Framedata> createFrames(String str, boolean z16);

    public abstract List<Framedata> createFrames(ByteBuffer byteBuffer, boolean z16);

    @Deprecated
    public List<ByteBuffer> createHandshake(Handshakedata handshakedata, Role role) {
        return createHandshake(handshakedata);
    }

    public abstract CloseHandshakeType getCloseHandshakeType();

    public Role getRole() {
        return this.role;
    }

    public abstract ClientHandshakeBuilder postProcessHandshakeRequestAsClient(ClientHandshakeBuilder clientHandshakeBuilder) throws InvalidHandshakeException;

    public abstract HandshakeBuilder postProcessHandshakeResponseAsServer(ClientHandshake clientHandshake, ServerHandshakeBuilder serverHandshakeBuilder) throws InvalidHandshakeException;

    public abstract void processFrame(WebSocketImpl webSocketImpl, Framedata framedata) throws InvalidDataException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public int readVersion(Handshakedata handshakedata) {
        String fieldValue = handshakedata.getFieldValue("Sec-WebSocket-Version");
        if (fieldValue.length() > 0) {
            try {
                return new Integer(fieldValue.trim()).intValue();
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }

    public abstract void reset();

    public void setParseMode(Role role) {
        this.role = role;
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public abstract List<Framedata> translateFrame(ByteBuffer byteBuffer) throws InvalidDataException;

    public Handshakedata translateHandshake(ByteBuffer byteBuffer) throws InvalidHandshakeException {
        return translateHandshakeHttp(byteBuffer, this.role);
    }

    private static HandshakeBuilder translateHandshakeHttpClient(String[] strArr, String str) throws InvalidHandshakeException {
        if ("101".equals(strArr[1])) {
            if ("HTTP/1.1".equalsIgnoreCase(strArr[0])) {
                HandshakeImpl1Server handshakeImpl1Server = new HandshakeImpl1Server();
                handshakeImpl1Server.setHttpStatus(Short.parseShort(strArr[1]));
                handshakeImpl1Server.setHttpStatusMessage(strArr[2]);
                return handshakeImpl1Server;
            }
            throw new InvalidHandshakeException(String.format("Invalid status line received: %s Status line: %s", strArr[0], str));
        }
        throw new InvalidHandshakeException(String.format("Invalid status code received: %s Status line: %s", strArr[1], str));
    }

    private static HandshakeBuilder translateHandshakeHttpServer(String[] strArr, String str) throws InvalidHandshakeException {
        if ("GET".equalsIgnoreCase(strArr[0])) {
            if ("HTTP/1.1".equalsIgnoreCase(strArr[2])) {
                HandshakeImpl1Client handshakeImpl1Client = new HandshakeImpl1Client();
                handshakeImpl1Client.setResourceDescriptor(strArr[1]);
                return handshakeImpl1Client;
            }
            throw new InvalidHandshakeException(String.format("Invalid status line received: %s Status line: %s", strArr[2], str));
        }
        throw new InvalidHandshakeException(String.format("Invalid request method received: %s Status line: %s", strArr[0], str));
    }

    public List<ByteBuffer> createHandshake(Handshakedata handshakedata) {
        return createHandshake(handshakedata, true);
    }

    @Deprecated
    public List<ByteBuffer> createHandshake(Handshakedata handshakedata, Role role, boolean z16) {
        return createHandshake(handshakedata, z16);
    }

    public int checkAlloc(int i3) throws InvalidDataException {
        if (i3 >= 0) {
            return i3;
        }
        throw new InvalidDataException(1002, "Negative count");
    }

    public List<ByteBuffer> createHandshake(Handshakedata handshakedata, boolean z16) {
        StringBuilder sb5 = new StringBuilder(100);
        if (handshakedata instanceof ClientHandshake) {
            sb5.append("GET ");
            sb5.append(((ClientHandshake) handshakedata).getResourceDescriptor());
            sb5.append(" HTTP/1.1");
        } else if (handshakedata instanceof ServerHandshake) {
            sb5.append("HTTP/1.1 101 ");
            sb5.append(((ServerHandshake) handshakedata).getHttpStatusMessage());
        } else {
            throw new IllegalArgumentException("unknown role");
        }
        sb5.append("\r\n");
        Iterator<String> iterateHttpFields = handshakedata.iterateHttpFields();
        while (iterateHttpFields.hasNext()) {
            String next = iterateHttpFields.next();
            String fieldValue = handshakedata.getFieldValue(next);
            sb5.append(next);
            sb5.append(MsgSummary.STR_COLON);
            sb5.append(fieldValue);
            sb5.append("\r\n");
        }
        sb5.append("\r\n");
        byte[] asciiBytes = Charsetfunctions.asciiBytes(sb5.toString());
        byte[] content = z16 ? handshakedata.getContent() : null;
        ByteBuffer allocate = ByteBuffer.allocate((content == null ? 0 : content.length) + asciiBytes.length);
        allocate.put(asciiBytes);
        if (content != null) {
            allocate.put(content);
        }
        allocate.flip();
        return Collections.singletonList(allocate);
    }
}
