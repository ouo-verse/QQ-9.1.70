package org.apache.httpcore.message;

import org.apache.httpcore.Header;
import org.apache.httpcore.HttpVersion;
import org.apache.httpcore.ParseException;
import org.apache.httpcore.ProtocolVersion;
import org.apache.httpcore.RequestLine;
import org.apache.httpcore.StatusLine;
import org.apache.httpcore.annotation.Contract;
import org.apache.httpcore.annotation.ThreadingBehavior;
import org.apache.httpcore.protocol.HTTP;
import org.apache.httpcore.util.Args;
import org.apache.httpcore.util.CharArrayBuffer;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes29.dex */
public class BasicLineParser implements LineParser {

    @Deprecated
    public static final BasicLineParser DEFAULT = new BasicLineParser();
    public static final BasicLineParser INSTANCE = new BasicLineParser();

    /* renamed from: protocol, reason: collision with root package name */
    protected final ProtocolVersion f423549protocol;

    public BasicLineParser(ProtocolVersion protocolVersion) {
        this.f423549protocol = protocolVersion == null ? HttpVersion.HTTP_1_1 : protocolVersion;
    }

    public static Header parseHeader(String str, LineParser lineParser) throws ParseException {
        Args.notNull(str, "Value");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        if (lineParser == null) {
            lineParser = INSTANCE;
        }
        return lineParser.parseHeader(charArrayBuffer);
    }

    public static ProtocolVersion parseProtocolVersion(String str, LineParser lineParser) throws ParseException {
        Args.notNull(str, "Value");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        ParserCursor parserCursor = new ParserCursor(0, str.length());
        if (lineParser == null) {
            lineParser = INSTANCE;
        }
        return lineParser.parseProtocolVersion(charArrayBuffer, parserCursor);
    }

    public static RequestLine parseRequestLine(String str, LineParser lineParser) throws ParseException {
        Args.notNull(str, "Value");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        ParserCursor parserCursor = new ParserCursor(0, str.length());
        if (lineParser == null) {
            lineParser = INSTANCE;
        }
        return lineParser.parseRequestLine(charArrayBuffer, parserCursor);
    }

    public static StatusLine parseStatusLine(String str, LineParser lineParser) throws ParseException {
        Args.notNull(str, "Value");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        ParserCursor parserCursor = new ParserCursor(0, str.length());
        if (lineParser == null) {
            lineParser = INSTANCE;
        }
        return lineParser.parseStatusLine(charArrayBuffer, parserCursor);
    }

    protected ProtocolVersion createProtocolVersion(int i3, int i16) {
        return this.f423549protocol.forVersion(i3, i16);
    }

    protected RequestLine createRequestLine(String str, String str2, ProtocolVersion protocolVersion) {
        return new BasicRequestLine(str, str2, protocolVersion);
    }

    protected StatusLine createStatusLine(ProtocolVersion protocolVersion, int i3, String str) {
        return new BasicStatusLine(protocolVersion, i3, str);
    }

    @Override // org.apache.httpcore.message.LineParser
    public boolean hasProtocolVersion(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        Args.notNull(charArrayBuffer, "Char array buffer");
        Args.notNull(parserCursor, "Parser cursor");
        int pos = parserCursor.getPos();
        String protocol2 = this.f423549protocol.getProtocol();
        int length = protocol2.length();
        boolean z16 = false;
        if (charArrayBuffer.length() < length + 4) {
            return false;
        }
        if (pos < 0) {
            pos = (charArrayBuffer.length() - 4) - length;
        } else if (pos == 0) {
            while (pos < charArrayBuffer.length() && HTTP.isWhitespace(charArrayBuffer.charAt(pos))) {
                pos++;
            }
        }
        int i3 = pos + length;
        if (i3 + 4 > charArrayBuffer.length()) {
            return false;
        }
        boolean z17 = true;
        for (int i16 = 0; z17 && i16 < length; i16++) {
            if (charArrayBuffer.charAt(pos + i16) == protocol2.charAt(i16)) {
                z17 = true;
            } else {
                z17 = false;
            }
        }
        if (z17) {
            if (charArrayBuffer.charAt(i3) == '/') {
                z16 = true;
            }
            return z16;
        }
        return z17;
    }

    protected void skipWhitespace(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        int pos = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        while (pos < upperBound && HTTP.isWhitespace(charArrayBuffer.charAt(pos))) {
            pos++;
        }
        parserCursor.updatePos(pos);
    }

    public BasicLineParser() {
        this(null);
    }

    @Override // org.apache.httpcore.message.LineParser
    public Header parseHeader(CharArrayBuffer charArrayBuffer) throws ParseException {
        return new BufferedHeader(charArrayBuffer);
    }

    @Override // org.apache.httpcore.message.LineParser
    public ProtocolVersion parseProtocolVersion(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) throws ParseException {
        Args.notNull(charArrayBuffer, "Char array buffer");
        Args.notNull(parserCursor, "Parser cursor");
        String protocol2 = this.f423549protocol.getProtocol();
        int length = protocol2.length();
        int pos = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        skipWhitespace(charArrayBuffer, parserCursor);
        int pos2 = parserCursor.getPos();
        int i3 = pos2 + length;
        if (i3 + 4 > upperBound) {
            throw new ParseException("Not a valid protocol version: " + charArrayBuffer.substring(pos, upperBound));
        }
        boolean z16 = true;
        for (int i16 = 0; z16 && i16 < length; i16++) {
            z16 = charArrayBuffer.charAt(pos2 + i16) == protocol2.charAt(i16);
        }
        if (z16) {
            z16 = charArrayBuffer.charAt(i3) == '/';
        }
        if (z16) {
            int i17 = pos2 + length + 1;
            int indexOf = charArrayBuffer.indexOf(46, i17, upperBound);
            if (indexOf != -1) {
                try {
                    int parseInt = Integer.parseInt(charArrayBuffer.substringTrimmed(i17, indexOf));
                    int i18 = indexOf + 1;
                    int indexOf2 = charArrayBuffer.indexOf(32, i18, upperBound);
                    if (indexOf2 == -1) {
                        indexOf2 = upperBound;
                    }
                    try {
                        int parseInt2 = Integer.parseInt(charArrayBuffer.substringTrimmed(i18, indexOf2));
                        parserCursor.updatePos(indexOf2);
                        return createProtocolVersion(parseInt, parseInt2);
                    } catch (NumberFormatException unused) {
                        throw new ParseException("Invalid protocol minor version number: " + charArrayBuffer.substring(pos, upperBound));
                    }
                } catch (NumberFormatException unused2) {
                    throw new ParseException("Invalid protocol major version number: " + charArrayBuffer.substring(pos, upperBound));
                }
            }
            throw new ParseException("Invalid protocol version number: " + charArrayBuffer.substring(pos, upperBound));
        }
        throw new ParseException("Not a valid protocol version: " + charArrayBuffer.substring(pos, upperBound));
    }

    @Override // org.apache.httpcore.message.LineParser
    public RequestLine parseRequestLine(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) throws ParseException {
        Args.notNull(charArrayBuffer, "Char array buffer");
        Args.notNull(parserCursor, "Parser cursor");
        int pos = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        try {
            skipWhitespace(charArrayBuffer, parserCursor);
            int pos2 = parserCursor.getPos();
            int indexOf = charArrayBuffer.indexOf(32, pos2, upperBound);
            if (indexOf >= 0) {
                String substringTrimmed = charArrayBuffer.substringTrimmed(pos2, indexOf);
                parserCursor.updatePos(indexOf);
                skipWhitespace(charArrayBuffer, parserCursor);
                int pos3 = parserCursor.getPos();
                int indexOf2 = charArrayBuffer.indexOf(32, pos3, upperBound);
                if (indexOf2 >= 0) {
                    String substringTrimmed2 = charArrayBuffer.substringTrimmed(pos3, indexOf2);
                    parserCursor.updatePos(indexOf2);
                    ProtocolVersion parseProtocolVersion = parseProtocolVersion(charArrayBuffer, parserCursor);
                    skipWhitespace(charArrayBuffer, parserCursor);
                    if (parserCursor.atEnd()) {
                        return createRequestLine(substringTrimmed, substringTrimmed2, parseProtocolVersion);
                    }
                    throw new ParseException("Invalid request line: " + charArrayBuffer.substring(pos, upperBound));
                }
                throw new ParseException("Invalid request line: " + charArrayBuffer.substring(pos, upperBound));
            }
            throw new ParseException("Invalid request line: " + charArrayBuffer.substring(pos, upperBound));
        } catch (IndexOutOfBoundsException unused) {
            throw new ParseException("Invalid request line: " + charArrayBuffer.substring(pos, upperBound));
        }
    }

    @Override // org.apache.httpcore.message.LineParser
    public StatusLine parseStatusLine(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) throws ParseException {
        Args.notNull(charArrayBuffer, "Char array buffer");
        Args.notNull(parserCursor, "Parser cursor");
        int pos = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        try {
            ProtocolVersion parseProtocolVersion = parseProtocolVersion(charArrayBuffer, parserCursor);
            skipWhitespace(charArrayBuffer, parserCursor);
            int pos2 = parserCursor.getPos();
            int indexOf = charArrayBuffer.indexOf(32, pos2, upperBound);
            if (indexOf < 0) {
                indexOf = upperBound;
            }
            String substringTrimmed = charArrayBuffer.substringTrimmed(pos2, indexOf);
            for (int i3 = 0; i3 < substringTrimmed.length(); i3++) {
                if (!Character.isDigit(substringTrimmed.charAt(i3))) {
                    throw new ParseException("Status line contains invalid status code: " + charArrayBuffer.substring(pos, upperBound));
                }
            }
            try {
                return createStatusLine(parseProtocolVersion, Integer.parseInt(substringTrimmed), indexOf < upperBound ? charArrayBuffer.substringTrimmed(indexOf, upperBound) : "");
            } catch (NumberFormatException unused) {
                throw new ParseException("Status line contains invalid status code: " + charArrayBuffer.substring(pos, upperBound));
            }
        } catch (IndexOutOfBoundsException unused2) {
            throw new ParseException("Invalid status line: " + charArrayBuffer.substring(pos, upperBound));
        }
    }
}
