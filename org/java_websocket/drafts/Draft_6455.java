package org.java_websocket.drafts;

import com.tencent.mobileqq.wink.storage.kv.MaskType;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import okhttp3.internal.ws.WebSocketProtocol;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.enums.CloseHandshakeType;
import org.java_websocket.enums.HandshakeState;
import org.java_websocket.enums.Opcode;
import org.java_websocket.enums.ReadyState;
import org.java_websocket.enums.Role;
import org.java_websocket.exceptions.IncompleteException;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.exceptions.LimitExceededException;
import org.java_websocket.exceptions.NotSendableException;
import org.java_websocket.extensions.DefaultExtension;
import org.java_websocket.extensions.IExtension;
import org.java_websocket.framing.BinaryFrame;
import org.java_websocket.framing.CloseFrame;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.FramedataImpl1;
import org.java_websocket.framing.TextFrame;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.ClientHandshakeBuilder;
import org.java_websocket.handshake.HandshakeBuilder;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.handshake.ServerHandshakeBuilder;
import org.java_websocket.protocols.IProtocol;
import org.java_websocket.protocols.Protocol;
import org.java_websocket.util.Base64;
import org.java_websocket.util.Charsetfunctions;
import org.jf.dexlib2.analysis.RegisterType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* compiled from: P */
/* loaded from: classes38.dex */
public class Draft_6455 extends Draft {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String CONNECTION = "Connection";
    private static final String SEC_WEB_SOCKET_ACCEPT = "Sec-WebSocket-Accept";
    private static final String SEC_WEB_SOCKET_EXTENSIONS = "Sec-WebSocket-Extensions";
    private static final String SEC_WEB_SOCKET_KEY = "Sec-WebSocket-Key";
    private static final String SEC_WEB_SOCKET_PROTOCOL = "Sec-WebSocket-Protocol";
    private static final String UPGRADE = "Upgrade";
    private static final Logger log = LoggerFactory.getLogger((Class<?>) Draft_6455.class);
    private final List<ByteBuffer> byteBufferList;
    private Framedata currentContinuousFrame;
    private IExtension extension;
    private ByteBuffer incompleteframe;
    private List<IExtension> knownExtensions;
    private List<IProtocol> knownProtocols;
    private int maxFrameSize;

    /* renamed from: protocol, reason: collision with root package name */
    private IProtocol f423601protocol;
    private final Random reuseableRandom;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class TranslatedPayloadMetaData {
        private int payloadLength;
        private int realPackageSize;

        TranslatedPayloadMetaData(int i3, int i16) {
            this.payloadLength = i3;
            this.realPackageSize = i16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getPayloadLength() {
            return this.payloadLength;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getRealPackageSize() {
            return this.realPackageSize;
        }
    }

    public Draft_6455() {
        this((List<IExtension>) Collections.emptyList());
    }

    private void addToBufferList(ByteBuffer byteBuffer) {
        synchronized (this.byteBufferList) {
            this.byteBufferList.add(byteBuffer);
        }
    }

    private void checkBufferLimit() throws LimitExceededException {
        long byteBufferListSize = getByteBufferListSize();
        if (byteBufferListSize <= this.maxFrameSize) {
            return;
        }
        clearBufferList();
        log.trace("Payload limit reached. Allowed: {} Current: {}", Integer.valueOf(this.maxFrameSize), Long.valueOf(byteBufferListSize));
        throw new LimitExceededException(this.maxFrameSize);
    }

    private void clearBufferList() {
        synchronized (this.byteBufferList) {
            this.byteBufferList.clear();
        }
    }

    private HandshakeState containsRequestedProtocol(String str) {
        for (IProtocol iProtocol : this.knownProtocols) {
            if (iProtocol.acceptProvidedProtocol(str)) {
                this.f423601protocol = iProtocol;
                log.trace("acceptHandshake - Matching protocol found: {}", iProtocol);
                return HandshakeState.MATCHED;
            }
        }
        return HandshakeState.NOT_MATCHED;
    }

    private ByteBuffer createByteBufferFromFramedata(Framedata framedata) {
        ByteBuffer payloadData = framedata.getPayloadData();
        int i3 = 0;
        boolean z16 = this.role == Role.CLIENT;
        int sizeBytes = getSizeBytes(payloadData);
        ByteBuffer allocate = ByteBuffer.allocate((sizeBytes > 1 ? sizeBytes + 1 : sizeBytes) + 1 + (z16 ? 4 : 0) + payloadData.remaining());
        allocate.put((byte) (((byte) (framedata.isFin() ? -128 : 0)) | fromOpcode(framedata.getOpcode())));
        byte[] byteArray = toByteArray(payloadData.remaining(), sizeBytes);
        if (sizeBytes == 1) {
            allocate.put((byte) (byteArray[0] | getMaskByte(z16)));
        } else if (sizeBytes == 2) {
            allocate.put((byte) (getMaskByte(z16) | 126));
            allocate.put(byteArray);
        } else if (sizeBytes == 8) {
            allocate.put((byte) (getMaskByte(z16) | Byte.MAX_VALUE));
            allocate.put(byteArray);
        } else {
            throw new IllegalStateException("Size representation not supported/specified");
        }
        if (z16) {
            ByteBuffer allocate2 = ByteBuffer.allocate(4);
            allocate2.putInt(this.reuseableRandom.nextInt());
            allocate.put(allocate2.array());
            while (payloadData.hasRemaining()) {
                allocate.put((byte) (payloadData.get() ^ allocate2.get(i3 % 4)));
                i3++;
            }
        } else {
            allocate.put(payloadData);
            payloadData.flip();
        }
        allocate.flip();
        return allocate;
    }

    private byte fromOpcode(Opcode opcode) {
        if (opcode == Opcode.CONTINUOUS) {
            return (byte) 0;
        }
        if (opcode == Opcode.TEXT) {
            return (byte) 1;
        }
        if (opcode == Opcode.BINARY) {
            return (byte) 2;
        }
        if (opcode == Opcode.CLOSING) {
            return (byte) 8;
        }
        if (opcode == Opcode.PING) {
            return (byte) 9;
        }
        if (opcode == Opcode.PONG) {
            return (byte) 10;
        }
        throw new IllegalArgumentException("Don't know how to handle " + opcode.toString());
    }

    private String generateFinalKey(String str) {
        try {
            return Base64.encodeBytes(MessageDigest.getInstance("SHA1").digest((str.trim() + WebSocketProtocol.ACCEPT_MAGIC).getBytes()));
        } catch (NoSuchAlgorithmException e16) {
            throw new IllegalStateException(e16);
        }
    }

    private long getByteBufferListSize() {
        long j3;
        synchronized (this.byteBufferList) {
            j3 = 0;
            while (this.byteBufferList.iterator().hasNext()) {
                j3 += r1.next().limit();
            }
        }
        return j3;
    }

    private byte getMaskByte(boolean z16) {
        if (z16) {
            return Byte.MIN_VALUE;
        }
        return (byte) 0;
    }

    private ByteBuffer getPayloadFromByteBufferList() throws LimitExceededException {
        ByteBuffer allocate;
        synchronized (this.byteBufferList) {
            long j3 = 0;
            while (this.byteBufferList.iterator().hasNext()) {
                j3 += r1.next().limit();
            }
            checkBufferLimit();
            allocate = ByteBuffer.allocate((int) j3);
            Iterator<ByteBuffer> it = this.byteBufferList.iterator();
            while (it.hasNext()) {
                allocate.put(it.next());
            }
        }
        allocate.flip();
        return allocate;
    }

    private String getServerTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(calendar.getTime());
    }

    private int getSizeBytes(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= 125) {
            return 1;
        }
        return byteBuffer.remaining() <= 65535 ? 2 : 8;
    }

    private void logRuntimeException(WebSocketImpl webSocketImpl, RuntimeException runtimeException) {
        log.error("Runtime exception during onWebsocketMessage", (Throwable) runtimeException);
        webSocketImpl.getWebSocketListener().onWebsocketError(webSocketImpl, runtimeException);
    }

    private void processFrameBinary(WebSocketImpl webSocketImpl, Framedata framedata) {
        try {
            webSocketImpl.getWebSocketListener().onWebsocketMessage(webSocketImpl, framedata.getPayloadData());
        } catch (RuntimeException e16) {
            logRuntimeException(webSocketImpl, e16);
        }
    }

    private void processFrameClosing(WebSocketImpl webSocketImpl, Framedata framedata) {
        int i3;
        String str;
        if (framedata instanceof CloseFrame) {
            CloseFrame closeFrame = (CloseFrame) framedata;
            i3 = closeFrame.getCloseCode();
            str = closeFrame.getMessage();
        } else {
            i3 = 1005;
            str = "";
        }
        if (webSocketImpl.getReadyState() == ReadyState.CLOSING) {
            webSocketImpl.closeConnection(i3, str, true);
        } else if (getCloseHandshakeType() == CloseHandshakeType.TWOWAY) {
            webSocketImpl.close(i3, str, true);
        } else {
            webSocketImpl.flushAndClose(i3, str, false);
        }
    }

    private void processFrameContinuousAndNonFin(WebSocketImpl webSocketImpl, Framedata framedata, Opcode opcode) throws InvalidDataException {
        Opcode opcode2 = Opcode.CONTINUOUS;
        if (opcode != opcode2) {
            processFrameIsNotFin(framedata);
        } else if (framedata.isFin()) {
            processFrameIsFin(webSocketImpl, framedata);
        } else if (this.currentContinuousFrame == null) {
            log.error("Protocol error: Continuous frame sequence was not started.");
            throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
        }
        if (opcode == Opcode.TEXT && !Charsetfunctions.isValidUTF8(framedata.getPayloadData())) {
            log.error("Protocol error: Payload is not UTF8");
            throw new InvalidDataException(1007);
        }
        if (opcode != opcode2 || this.currentContinuousFrame == null) {
            return;
        }
        addToBufferList(framedata.getPayloadData());
    }

    private void processFrameIsFin(WebSocketImpl webSocketImpl, Framedata framedata) throws InvalidDataException {
        if (this.currentContinuousFrame != null) {
            addToBufferList(framedata.getPayloadData());
            checkBufferLimit();
            if (this.currentContinuousFrame.getOpcode() == Opcode.TEXT) {
                ((FramedataImpl1) this.currentContinuousFrame).setPayload(getPayloadFromByteBufferList());
                ((FramedataImpl1) this.currentContinuousFrame).isValid();
                try {
                    webSocketImpl.getWebSocketListener().onWebsocketMessage(webSocketImpl, Charsetfunctions.stringUtf8(this.currentContinuousFrame.getPayloadData()));
                } catch (RuntimeException e16) {
                    logRuntimeException(webSocketImpl, e16);
                }
            } else if (this.currentContinuousFrame.getOpcode() == Opcode.BINARY) {
                ((FramedataImpl1) this.currentContinuousFrame).setPayload(getPayloadFromByteBufferList());
                ((FramedataImpl1) this.currentContinuousFrame).isValid();
                try {
                    webSocketImpl.getWebSocketListener().onWebsocketMessage(webSocketImpl, this.currentContinuousFrame.getPayloadData());
                } catch (RuntimeException e17) {
                    logRuntimeException(webSocketImpl, e17);
                }
            }
            this.currentContinuousFrame = null;
            clearBufferList();
            return;
        }
        log.trace("Protocol error: Previous continuous frame sequence not completed.");
        throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
    }

    private void processFrameIsNotFin(Framedata framedata) throws InvalidDataException {
        if (this.currentContinuousFrame == null) {
            this.currentContinuousFrame = framedata;
            addToBufferList(framedata.getPayloadData());
            checkBufferLimit();
            return;
        }
        log.trace("Protocol error: Previous continuous frame sequence not completed.");
        throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
    }

    private void processFrameText(WebSocketImpl webSocketImpl, Framedata framedata) throws InvalidDataException {
        try {
            webSocketImpl.getWebSocketListener().onWebsocketMessage(webSocketImpl, Charsetfunctions.stringUtf8(framedata.getPayloadData()));
        } catch (RuntimeException e16) {
            logRuntimeException(webSocketImpl, e16);
        }
    }

    private byte[] toByteArray(long j3, int i3) {
        byte[] bArr = new byte[i3];
        int i16 = (i3 * 8) - 8;
        for (int i17 = 0; i17 < i3; i17++) {
            bArr[i17] = (byte) (j3 >>> (i16 - (i17 * 8)));
        }
        return bArr;
    }

    private TranslatedPayloadMetaData translateSingleFramePayloadLength(ByteBuffer byteBuffer, Opcode opcode, int i3, int i16, int i17) throws InvalidFrameException, IncompleteException, LimitExceededException {
        int i18;
        int i19;
        if (opcode != Opcode.PING && opcode != Opcode.PONG && opcode != Opcode.CLOSING) {
            if (i3 == 126) {
                i18 = i17 + 2;
                translateSingleFrameCheckPacketSize(i16, i18);
                i19 = new BigInteger(new byte[]{0, byteBuffer.get(), byteBuffer.get()}).intValue();
            } else {
                i18 = i17 + 8;
                translateSingleFrameCheckPacketSize(i16, i18);
                byte[] bArr = new byte[8];
                for (int i26 = 0; i26 < 8; i26++) {
                    bArr[i26] = byteBuffer.get();
                }
                long longValue = new BigInteger(bArr).longValue();
                translateSingleFrameCheckLengthLimit(longValue);
                i19 = (int) longValue;
            }
            return new TranslatedPayloadMetaData(i19, i18);
        }
        log.trace("Invalid frame: more than 125 octets");
        throw new InvalidFrameException("more than 125 octets");
    }

    @Override // org.java_websocket.drafts.Draft
    public HandshakeState acceptHandshakeAsClient(ClientHandshake clientHandshake, ServerHandshake serverHandshake) throws InvalidHandshakeException {
        if (!basicAccept(serverHandshake)) {
            log.trace("acceptHandshakeAsClient - Missing/wrong upgrade or connection in handshake.");
            return HandshakeState.NOT_MATCHED;
        }
        if (clientHandshake.hasFieldValue(SEC_WEB_SOCKET_KEY) && serverHandshake.hasFieldValue(SEC_WEB_SOCKET_ACCEPT)) {
            if (!generateFinalKey(clientHandshake.getFieldValue(SEC_WEB_SOCKET_KEY)).equals(serverHandshake.getFieldValue(SEC_WEB_SOCKET_ACCEPT))) {
                log.trace("acceptHandshakeAsClient - Wrong key for Sec-WebSocket-Key.");
                return HandshakeState.NOT_MATCHED;
            }
            HandshakeState handshakeState = HandshakeState.NOT_MATCHED;
            String fieldValue = serverHandshake.getFieldValue(SEC_WEB_SOCKET_EXTENSIONS);
            Iterator<IExtension> it = this.knownExtensions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                IExtension next = it.next();
                if (next.acceptProvidedExtensionAsClient(fieldValue)) {
                    this.extension = next;
                    handshakeState = HandshakeState.MATCHED;
                    log.trace("acceptHandshakeAsClient - Matching extension found: {}", next);
                    break;
                }
            }
            HandshakeState containsRequestedProtocol = containsRequestedProtocol(serverHandshake.getFieldValue(SEC_WEB_SOCKET_PROTOCOL));
            HandshakeState handshakeState2 = HandshakeState.MATCHED;
            if (containsRequestedProtocol == handshakeState2 && handshakeState == handshakeState2) {
                return handshakeState2;
            }
            log.trace("acceptHandshakeAsClient - No matching extension or protocol found.");
            return HandshakeState.NOT_MATCHED;
        }
        log.trace("acceptHandshakeAsClient - Missing Sec-WebSocket-Key or Sec-WebSocket-Accept");
        return HandshakeState.NOT_MATCHED;
    }

    @Override // org.java_websocket.drafts.Draft
    public HandshakeState acceptHandshakeAsServer(ClientHandshake clientHandshake) throws InvalidHandshakeException {
        if (readVersion(clientHandshake) != 13) {
            log.trace("acceptHandshakeAsServer - Wrong websocket version.");
            return HandshakeState.NOT_MATCHED;
        }
        HandshakeState handshakeState = HandshakeState.NOT_MATCHED;
        String fieldValue = clientHandshake.getFieldValue(SEC_WEB_SOCKET_EXTENSIONS);
        Iterator<IExtension> it = this.knownExtensions.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            IExtension next = it.next();
            if (next.acceptProvidedExtensionAsServer(fieldValue)) {
                this.extension = next;
                handshakeState = HandshakeState.MATCHED;
                log.trace("acceptHandshakeAsServer - Matching extension found: {}", next);
                break;
            }
        }
        HandshakeState containsRequestedProtocol = containsRequestedProtocol(clientHandshake.getFieldValue(SEC_WEB_SOCKET_PROTOCOL));
        HandshakeState handshakeState2 = HandshakeState.MATCHED;
        if (containsRequestedProtocol == handshakeState2 && handshakeState == handshakeState2) {
            return handshakeState2;
        }
        log.trace("acceptHandshakeAsServer - No matching extension or protocol found.");
        return HandshakeState.NOT_MATCHED;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft copyInstance() {
        ArrayList arrayList = new ArrayList();
        Iterator<IExtension> it = getKnownExtensions().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().copyInstance());
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<IProtocol> it5 = getKnownProtocols().iterator();
        while (it5.hasNext()) {
            arrayList2.add(it5.next().copyInstance());
        }
        return new Draft_6455(arrayList, arrayList2, this.maxFrameSize);
    }

    @Override // org.java_websocket.drafts.Draft
    public ByteBuffer createBinaryFrame(Framedata framedata) {
        String str;
        getExtension().encodeFrame(framedata);
        Logger logger = log;
        if (logger.isTraceEnabled()) {
            Integer valueOf = Integer.valueOf(framedata.getPayloadData().remaining());
            if (framedata.getPayloadData().remaining() > 1000) {
                str = "too big to display";
            } else {
                str = new String(framedata.getPayloadData().array());
            }
            logger.trace("afterEnconding({}): {}", valueOf, str);
        }
        return createByteBufferFromFramedata(framedata);
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> createFrames(ByteBuffer byteBuffer, boolean z16) {
        BinaryFrame binaryFrame = new BinaryFrame();
        binaryFrame.setPayload(byteBuffer);
        binaryFrame.setTransferemasked(z16);
        try {
            binaryFrame.isValid();
            return Collections.singletonList(binaryFrame);
        } catch (InvalidDataException e16) {
            throw new NotSendableException(e16);
        }
    }

    @Override // org.java_websocket.drafts.Draft
    public CloseHandshakeType getCloseHandshakeType() {
        return CloseHandshakeType.TWOWAY;
    }

    public IExtension getExtension() {
        return this.extension;
    }

    public List<IExtension> getKnownExtensions() {
        return this.knownExtensions;
    }

    public List<IProtocol> getKnownProtocols() {
        return this.knownProtocols;
    }

    public int getMaxFrameSize() {
        return this.maxFrameSize;
    }

    public IProtocol getProtocol() {
        return this.f423601protocol;
    }

    public int hashCode() {
        IExtension iExtension = this.extension;
        int hashCode = (iExtension != null ? iExtension.hashCode() : 0) * 31;
        IProtocol iProtocol = this.f423601protocol;
        int hashCode2 = (hashCode + (iProtocol != null ? iProtocol.hashCode() : 0)) * 31;
        int i3 = this.maxFrameSize;
        return hashCode2 + (i3 ^ (i3 >>> 32));
    }

    @Override // org.java_websocket.drafts.Draft
    public ClientHandshakeBuilder postProcessHandshakeRequestAsClient(ClientHandshakeBuilder clientHandshakeBuilder) {
        clientHandshakeBuilder.put("Upgrade", "websocket");
        clientHandshakeBuilder.put("Connection", "Upgrade");
        byte[] bArr = new byte[16];
        this.reuseableRandom.nextBytes(bArr);
        clientHandshakeBuilder.put(SEC_WEB_SOCKET_KEY, Base64.encodeBytes(bArr));
        clientHandshakeBuilder.put("Sec-WebSocket-Version", "13");
        StringBuilder sb5 = new StringBuilder();
        for (IExtension iExtension : this.knownExtensions) {
            if (iExtension.getProvidedExtensionAsClient() != null && iExtension.getProvidedExtensionAsClient().length() != 0) {
                if (sb5.length() > 0) {
                    sb5.append(", ");
                }
                sb5.append(iExtension.getProvidedExtensionAsClient());
            }
        }
        if (sb5.length() != 0) {
            clientHandshakeBuilder.put(SEC_WEB_SOCKET_EXTENSIONS, sb5.toString());
        }
        StringBuilder sb6 = new StringBuilder();
        for (IProtocol iProtocol : this.knownProtocols) {
            if (iProtocol.getProvidedProtocol().length() != 0) {
                if (sb6.length() > 0) {
                    sb6.append(", ");
                }
                sb6.append(iProtocol.getProvidedProtocol());
            }
        }
        if (sb6.length() != 0) {
            clientHandshakeBuilder.put(SEC_WEB_SOCKET_PROTOCOL, sb6.toString());
        }
        return clientHandshakeBuilder;
    }

    @Override // org.java_websocket.drafts.Draft
    public HandshakeBuilder postProcessHandshakeResponseAsServer(ClientHandshake clientHandshake, ServerHandshakeBuilder serverHandshakeBuilder) throws InvalidHandshakeException {
        serverHandshakeBuilder.put("Upgrade", "websocket");
        serverHandshakeBuilder.put("Connection", clientHandshake.getFieldValue("Connection"));
        String fieldValue = clientHandshake.getFieldValue(SEC_WEB_SOCKET_KEY);
        if (fieldValue != null) {
            serverHandshakeBuilder.put(SEC_WEB_SOCKET_ACCEPT, generateFinalKey(fieldValue));
            if (getExtension().getProvidedExtensionAsServer().length() != 0) {
                serverHandshakeBuilder.put(SEC_WEB_SOCKET_EXTENSIONS, getExtension().getProvidedExtensionAsServer());
            }
            if (getProtocol() != null && getProtocol().getProvidedProtocol().length() != 0) {
                serverHandshakeBuilder.put(SEC_WEB_SOCKET_PROTOCOL, getProtocol().getProvidedProtocol());
            }
            serverHandshakeBuilder.setHttpStatusMessage("Web Socket Protocol Handshake");
            serverHandshakeBuilder.put("Server", "TooTallNate Java-WebSocket");
            serverHandshakeBuilder.put("Date", getServerTime());
            return serverHandshakeBuilder;
        }
        throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
    }

    @Override // org.java_websocket.drafts.Draft
    public void processFrame(WebSocketImpl webSocketImpl, Framedata framedata) throws InvalidDataException {
        Opcode opcode = framedata.getOpcode();
        if (opcode == Opcode.CLOSING) {
            processFrameClosing(webSocketImpl, framedata);
            return;
        }
        if (opcode == Opcode.PING) {
            webSocketImpl.getWebSocketListener().onWebsocketPing(webSocketImpl, framedata);
            return;
        }
        if (opcode == Opcode.PONG) {
            webSocketImpl.updateLastPong();
            webSocketImpl.getWebSocketListener().onWebsocketPong(webSocketImpl, framedata);
            return;
        }
        if (framedata.isFin() && opcode != Opcode.CONTINUOUS) {
            if (this.currentContinuousFrame == null) {
                if (opcode == Opcode.TEXT) {
                    processFrameText(webSocketImpl, framedata);
                    return;
                } else if (opcode == Opcode.BINARY) {
                    processFrameBinary(webSocketImpl, framedata);
                    return;
                } else {
                    log.error("non control or continious frame expected");
                    throw new InvalidDataException(1002, "non control or continious frame expected");
                }
            }
            log.error("Protocol error: Continuous frame sequence not completed.");
            throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
        }
        processFrameContinuousAndNonFin(webSocketImpl, framedata, opcode);
    }

    @Override // org.java_websocket.drafts.Draft
    public String toString() {
        String draft = super.toString();
        if (getExtension() != null) {
            draft = draft + " extension: " + getExtension().toString();
        }
        if (getProtocol() != null) {
            draft = draft + " protocol: " + getProtocol().toString();
        }
        return draft + " max frame size: " + this.maxFrameSize;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> translateFrame(ByteBuffer byteBuffer) throws InvalidDataException {
        LinkedList linkedList;
        while (true) {
            linkedList = new LinkedList();
            if (this.incompleteframe == null) {
                break;
            }
            try {
                byteBuffer.mark();
                int remaining = byteBuffer.remaining();
                int remaining2 = this.incompleteframe.remaining();
                if (remaining2 > remaining) {
                    this.incompleteframe.put(byteBuffer.array(), byteBuffer.position(), remaining);
                    byteBuffer.position(byteBuffer.position() + remaining);
                    return Collections.emptyList();
                }
                this.incompleteframe.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                byteBuffer.position(byteBuffer.position() + remaining2);
                linkedList.add(translateSingleFrame((ByteBuffer) this.incompleteframe.duplicate().position(0)));
                this.incompleteframe = null;
            } catch (IncompleteException e16) {
                ByteBuffer allocate = ByteBuffer.allocate(checkAlloc(e16.getPreferredSize()));
                this.incompleteframe.rewind();
                allocate.put(this.incompleteframe);
                this.incompleteframe = allocate;
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(translateSingleFrame(byteBuffer));
            } catch (IncompleteException e17) {
                byteBuffer.reset();
                ByteBuffer allocate2 = ByteBuffer.allocate(checkAlloc(e17.getPreferredSize()));
                this.incompleteframe = allocate2;
                allocate2.put(byteBuffer);
            }
        }
        return linkedList;
    }

    public Draft_6455(IExtension iExtension) {
        this((List<IExtension>) Collections.singletonList(iExtension));
    }

    @Override // org.java_websocket.drafts.Draft
    public void reset() {
        this.incompleteframe = null;
        IExtension iExtension = this.extension;
        if (iExtension != null) {
            iExtension.reset();
        }
        this.extension = new DefaultExtension();
        this.f423601protocol = null;
    }

    public Draft_6455(List<IExtension> list) {
        this(list, (List<IProtocol>) Collections.singletonList(new Protocol("")));
    }

    private Framedata translateSingleFrame(ByteBuffer byteBuffer) throws IncompleteException, InvalidDataException {
        String str;
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i3 = 2;
            translateSingleFrameCheckPacketSize(remaining, 2);
            byte b16 = byteBuffer.get();
            boolean z16 = (b16 >> 8) != 0;
            boolean z17 = (b16 & MaskType.MASK_TYPE_EXTERNAL) != 0;
            boolean z18 = (b16 & 32) != 0;
            boolean z19 = (b16 & RegisterType.UNINIT_REF) != 0;
            byte b17 = byteBuffer.get();
            boolean z26 = (b17 & Byte.MIN_VALUE) != 0;
            int i16 = (byte) (b17 & Byte.MAX_VALUE);
            Opcode opcode = toOpcode((byte) (b16 & RegisterType.DOUBLE_HI));
            if (i16 < 0 || i16 > 125) {
                TranslatedPayloadMetaData translateSingleFramePayloadLength = translateSingleFramePayloadLength(byteBuffer, opcode, i16, remaining, 2);
                i16 = translateSingleFramePayloadLength.getPayloadLength();
                i3 = translateSingleFramePayloadLength.getRealPackageSize();
            }
            translateSingleFrameCheckLengthLimit(i16);
            translateSingleFrameCheckPacketSize(remaining, i3 + (z26 ? 4 : 0) + i16);
            ByteBuffer allocate = ByteBuffer.allocate(checkAlloc(i16));
            if (z26) {
                byte[] bArr = new byte[4];
                byteBuffer.get(bArr);
                for (int i17 = 0; i17 < i16; i17++) {
                    allocate.put((byte) (byteBuffer.get() ^ bArr[i17 % 4]));
                }
            } else {
                allocate.put(byteBuffer.array(), byteBuffer.position(), allocate.limit());
                byteBuffer.position(byteBuffer.position() + allocate.limit());
            }
            FramedataImpl1 framedataImpl1 = FramedataImpl1.get(opcode);
            framedataImpl1.setFin(z16);
            framedataImpl1.setRSV1(z17);
            framedataImpl1.setRSV2(z18);
            framedataImpl1.setRSV3(z19);
            allocate.flip();
            framedataImpl1.setPayload(allocate);
            getExtension().isFrameValid(framedataImpl1);
            getExtension().decodeFrame(framedataImpl1);
            Logger logger = log;
            if (logger.isTraceEnabled()) {
                Integer valueOf = Integer.valueOf(framedataImpl1.getPayloadData().remaining());
                if (framedataImpl1.getPayloadData().remaining() > 1000) {
                    str = "too big to display";
                } else {
                    str = new String(framedataImpl1.getPayloadData().array());
                }
                logger.trace("afterDecoding({}): {}", valueOf, str);
            }
            framedataImpl1.isValid();
            return framedataImpl1;
        }
        throw new IllegalArgumentException();
    }

    public Draft_6455(List<IExtension> list, List<IProtocol> list2) {
        this(list, list2, Integer.MAX_VALUE);
    }

    private void translateSingleFrameCheckPacketSize(int i3, int i16) throws IncompleteException {
        if (i3 >= i16) {
            return;
        }
        log.trace("Incomplete frame: maxpacketsize < realpacketsize");
        throw new IncompleteException(i16);
    }

    public Draft_6455(List<IExtension> list, int i3) {
        this(list, Collections.singletonList(new Protocol("")), i3);
    }

    public Draft_6455(List<IExtension> list, List<IProtocol> list2, int i3) {
        this.extension = new DefaultExtension();
        this.reuseableRandom = new Random();
        if (list != null && list2 != null && i3 >= 1) {
            this.knownExtensions = new ArrayList(list.size());
            this.knownProtocols = new ArrayList(list2.size());
            this.byteBufferList = new ArrayList();
            Iterator<IExtension> it = list.iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                if (it.next().getClass().equals(DefaultExtension.class)) {
                    z16 = true;
                }
            }
            this.knownExtensions.addAll(list);
            if (!z16) {
                List<IExtension> list3 = this.knownExtensions;
                list3.add(list3.size(), this.extension);
            }
            this.knownProtocols.addAll(list2);
            this.maxFrameSize = i3;
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> createFrames(String str, boolean z16) {
        TextFrame textFrame = new TextFrame();
        textFrame.setPayload(ByteBuffer.wrap(Charsetfunctions.utf8Bytes(str)));
        textFrame.setTransferemasked(z16);
        try {
            textFrame.isValid();
            return Collections.singletonList(textFrame);
        } catch (InvalidDataException e16) {
            throw new NotSendableException(e16);
        }
    }

    private void translateSingleFrameCheckLengthLimit(long j3) throws LimitExceededException {
        if (j3 <= TTL.MAX_VALUE) {
            int i3 = this.maxFrameSize;
            if (j3 > i3) {
                log.trace("Payload limit reached. Allowed: {} Current: {}", Integer.valueOf(i3), Long.valueOf(j3));
                throw new LimitExceededException("Payload limit reached.", this.maxFrameSize);
            }
            if (j3 >= 0) {
                return;
            }
            log.trace("Limit underflow: Payloadsize is to little...");
            throw new LimitExceededException("Payloadsize is to little...");
        }
        log.trace("Limit exedeed: Payloadsize is to big...");
        throw new LimitExceededException("Payloadsize is to big...");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Draft_6455 draft_6455 = (Draft_6455) obj;
        if (this.maxFrameSize != draft_6455.getMaxFrameSize()) {
            return false;
        }
        IExtension iExtension = this.extension;
        if (iExtension == null ? draft_6455.getExtension() != null : !iExtension.equals(draft_6455.getExtension())) {
            return false;
        }
        IProtocol iProtocol = this.f423601protocol;
        IProtocol protocol2 = draft_6455.getProtocol();
        if (iProtocol != null) {
            return iProtocol.equals(protocol2);
        }
        return protocol2 == null;
    }

    private Opcode toOpcode(byte b16) throws InvalidFrameException {
        if (b16 == 0) {
            return Opcode.CONTINUOUS;
        }
        if (b16 == 1) {
            return Opcode.TEXT;
        }
        if (b16 != 2) {
            switch (b16) {
                case 8:
                    return Opcode.CLOSING;
                case 9:
                    return Opcode.PING;
                case 10:
                    return Opcode.PONG;
                default:
                    throw new InvalidFrameException("Unknown opcode " + ((int) b16));
            }
        }
        return Opcode.BINARY;
    }
}
