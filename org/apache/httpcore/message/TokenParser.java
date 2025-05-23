package org.apache.httpcore.message;

import java.util.BitSet;
import org.apache.httpcore.annotation.Contract;
import org.apache.httpcore.annotation.ThreadingBehavior;
import org.apache.httpcore.util.CharArrayBuffer;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes29.dex */
public class TokenParser {
    public static final char CR = '\r';
    public static final char DQUOTE = '\"';
    public static final char ESCAPE = '\\';
    public static final char HT = '\t';
    public static final TokenParser INSTANCE = new TokenParser();
    public static final char LF = '\n';
    public static final char SP = ' ';

    public static BitSet INIT_BITSET(int... iArr) {
        BitSet bitSet = new BitSet();
        for (int i3 : iArr) {
            bitSet.set(i3);
        }
        return bitSet;
    }

    public static boolean isWhitespace(char c16) {
        if (c16 != ' ' && c16 != '\t' && c16 != '\r' && c16 != '\n') {
            return false;
        }
        return true;
    }

    public void copyContent(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor, BitSet bitSet, StringBuilder sb5) {
        int pos = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        for (int pos2 = parserCursor.getPos(); pos2 < upperBound; pos2++) {
            char charAt = charArrayBuffer.charAt(pos2);
            if ((bitSet != null && bitSet.get(charAt)) || isWhitespace(charAt)) {
                break;
            }
            pos++;
            sb5.append(charAt);
        }
        parserCursor.updatePos(pos);
    }

    public void copyQuotedContent(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor, StringBuilder sb5) {
        if (parserCursor.atEnd()) {
            return;
        }
        int pos = parserCursor.getPos();
        int pos2 = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        if (charArrayBuffer.charAt(pos) != '\"') {
            return;
        }
        int i3 = pos + 1;
        int i16 = pos2 + 1;
        boolean z16 = false;
        while (true) {
            if (i16 >= upperBound) {
                break;
            }
            char charAt = charArrayBuffer.charAt(i16);
            if (z16) {
                if (charAt != '\"' && charAt != '\\') {
                    sb5.append('\\');
                }
                sb5.append(charAt);
                z16 = false;
            } else if (charAt == '\"') {
                i3++;
                break;
            } else if (charAt == '\\') {
                z16 = true;
            } else if (charAt != '\r' && charAt != '\n') {
                sb5.append(charAt);
            }
            i16++;
            i3++;
        }
        parserCursor.updatePos(i3);
    }

    public void copyUnquotedContent(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor, BitSet bitSet, StringBuilder sb5) {
        int pos = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        for (int pos2 = parserCursor.getPos(); pos2 < upperBound; pos2++) {
            char charAt = charArrayBuffer.charAt(pos2);
            if ((bitSet != null && bitSet.get(charAt)) || isWhitespace(charAt) || charAt == '\"') {
                break;
            }
            pos++;
            sb5.append(charAt);
        }
        parserCursor.updatePos(pos);
    }

    public String parseToken(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor, BitSet bitSet) {
        StringBuilder sb5 = new StringBuilder();
        loop0: while (true) {
            boolean z16 = false;
            while (!parserCursor.atEnd()) {
                char charAt = charArrayBuffer.charAt(parserCursor.getPos());
                if (bitSet != null && bitSet.get(charAt)) {
                    break loop0;
                }
                if (isWhitespace(charAt)) {
                    skipWhiteSpace(charArrayBuffer, parserCursor);
                    z16 = true;
                } else {
                    if (z16 && sb5.length() > 0) {
                        sb5.append(SP);
                    }
                    copyContent(charArrayBuffer, parserCursor, bitSet, sb5);
                }
            }
            break loop0;
        }
        return sb5.toString();
    }

    public String parseValue(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor, BitSet bitSet) {
        StringBuilder sb5 = new StringBuilder();
        loop0: while (true) {
            boolean z16 = false;
            while (!parserCursor.atEnd()) {
                char charAt = charArrayBuffer.charAt(parserCursor.getPos());
                if (bitSet != null && bitSet.get(charAt)) {
                    break loop0;
                }
                if (isWhitespace(charAt)) {
                    skipWhiteSpace(charArrayBuffer, parserCursor);
                    z16 = true;
                } else if (charAt == '\"') {
                    if (z16 && sb5.length() > 0) {
                        sb5.append(SP);
                    }
                    copyQuotedContent(charArrayBuffer, parserCursor, sb5);
                } else {
                    if (z16 && sb5.length() > 0) {
                        sb5.append(SP);
                    }
                    copyUnquotedContent(charArrayBuffer, parserCursor, bitSet, sb5);
                }
            }
            break loop0;
        }
        return sb5.toString();
    }

    public void skipWhiteSpace(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        int pos = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        for (int pos2 = parserCursor.getPos(); pos2 < upperBound && isWhitespace(charArrayBuffer.charAt(pos2)); pos2++) {
            pos++;
        }
        parserCursor.updatePos(pos);
    }
}
