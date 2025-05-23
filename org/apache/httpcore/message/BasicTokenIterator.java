package org.apache.httpcore.message;

import java.util.NoSuchElementException;
import org.apache.httpcore.HeaderIterator;
import org.apache.httpcore.ParseException;
import org.apache.httpcore.TokenIterator;
import org.apache.httpcore.util.Args;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BasicTokenIterator implements TokenIterator {
    public static final String HTTP_SEPARATORS = " ,;=()<>@:\\\"/[]?{}\t";
    protected String currentHeader;
    protected String currentToken;
    protected final HeaderIterator headerIt;
    protected int searchPos = findNext(-1);

    public BasicTokenIterator(HeaderIterator headerIterator) {
        this.headerIt = (HeaderIterator) Args.notNull(headerIterator, "Header iterator");
    }

    protected String createToken(String str, int i3, int i16) {
        return str.substring(i3, i16);
    }

    protected int findNext(int i3) throws ParseException {
        int findTokenSeparator;
        if (i3 < 0) {
            if (!this.headerIt.hasNext()) {
                return -1;
            }
            this.currentHeader = this.headerIt.nextHeader().getValue();
            findTokenSeparator = 0;
        } else {
            findTokenSeparator = findTokenSeparator(i3);
        }
        int findTokenStart = findTokenStart(findTokenSeparator);
        if (findTokenStart < 0) {
            this.currentToken = null;
            return -1;
        }
        int findTokenEnd = findTokenEnd(findTokenStart);
        this.currentToken = createToken(this.currentHeader, findTokenStart, findTokenEnd);
        return findTokenEnd;
    }

    protected int findTokenEnd(int i3) {
        Args.notNegative(i3, "Search position");
        int length = this.currentHeader.length();
        do {
            i3++;
            if (i3 >= length) {
                break;
            }
        } while (isTokenChar(this.currentHeader.charAt(i3)));
        return i3;
    }

    protected int findTokenSeparator(int i3) {
        int notNegative = Args.notNegative(i3, "Search position");
        int length = this.currentHeader.length();
        boolean z16 = false;
        while (!z16 && notNegative < length) {
            char charAt = this.currentHeader.charAt(notNegative);
            if (isTokenSeparator(charAt)) {
                z16 = true;
            } else if (isWhitespace(charAt)) {
                notNegative++;
            } else {
                if (isTokenChar(charAt)) {
                    throw new ParseException("Tokens without separator (pos " + notNegative + "): " + this.currentHeader);
                }
                throw new ParseException("Invalid character after token (pos " + notNegative + "): " + this.currentHeader);
            }
        }
        return notNegative;
    }

    protected int findTokenStart(int i3) {
        int notNegative = Args.notNegative(i3, "Search position");
        boolean z16 = false;
        while (!z16) {
            String str = this.currentHeader;
            if (str == null) {
                break;
            }
            int length = str.length();
            while (!z16 && notNegative < length) {
                char charAt = this.currentHeader.charAt(notNegative);
                if (!isTokenSeparator(charAt) && !isWhitespace(charAt)) {
                    if (isTokenChar(this.currentHeader.charAt(notNegative))) {
                        z16 = true;
                    } else {
                        throw new ParseException("Invalid character before token (pos " + notNegative + "): " + this.currentHeader);
                    }
                } else {
                    notNegative++;
                }
            }
            if (!z16) {
                if (this.headerIt.hasNext()) {
                    this.currentHeader = this.headerIt.nextHeader().getValue();
                    notNegative = 0;
                } else {
                    this.currentHeader = null;
                }
            }
        }
        if (!z16) {
            return -1;
        }
        return notNegative;
    }

    @Override // org.apache.httpcore.TokenIterator, java.util.Iterator
    public boolean hasNext() {
        if (this.currentToken != null) {
            return true;
        }
        return false;
    }

    protected boolean isHttpSeparator(char c16) {
        if (" ,;=()<>@:\\\"/[]?{}\t".indexOf(c16) >= 0) {
            return true;
        }
        return false;
    }

    protected boolean isTokenChar(char c16) {
        if (Character.isLetterOrDigit(c16)) {
            return true;
        }
        if (!Character.isISOControl(c16) && !isHttpSeparator(c16)) {
            return true;
        }
        return false;
    }

    protected boolean isTokenSeparator(char c16) {
        if (c16 == ',') {
            return true;
        }
        return false;
    }

    protected boolean isWhitespace(char c16) {
        if (c16 != '\t' && !Character.isSpaceChar(c16)) {
            return false;
        }
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() throws NoSuchElementException, ParseException {
        return nextToken();
    }

    @Override // org.apache.httpcore.TokenIterator
    public String nextToken() throws NoSuchElementException, ParseException {
        String str = this.currentToken;
        if (str != null) {
            this.searchPos = findNext(this.searchPos);
            return str;
        }
        throw new NoSuchElementException("Iteration already finished.");
    }

    @Override // java.util.Iterator
    public final void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Removing tokens is not supported.");
    }
}
