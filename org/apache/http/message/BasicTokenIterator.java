package org.apache.http.message;

import java.util.NoSuchElementException;
import org.apache.http.HeaderIterator;
import org.apache.http.ParseException;
import org.apache.http.TokenIterator;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public class BasicTokenIterator implements TokenIterator {
    public static final String HTTP_SEPARATORS = " ,;=()<>@:\\\"/[]?{}\t";
    protected String currentHeader;
    protected String currentToken;
    protected final HeaderIterator headerIt;
    protected int searchPos;

    public BasicTokenIterator(HeaderIterator headerIterator) {
        throw new RuntimeException("Stub!");
    }

    protected String createToken(String str, int i3, int i16) {
        throw new RuntimeException("Stub!");
    }

    protected int findNext(int i3) throws ParseException {
        throw new RuntimeException("Stub!");
    }

    protected int findTokenEnd(int i3) {
        throw new RuntimeException("Stub!");
    }

    protected int findTokenSeparator(int i3) {
        throw new RuntimeException("Stub!");
    }

    protected int findTokenStart(int i3) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.TokenIterator, java.util.Iterator
    public boolean hasNext() {
        throw new RuntimeException("Stub!");
    }

    protected boolean isHttpSeparator(char c16) {
        throw new RuntimeException("Stub!");
    }

    protected boolean isTokenChar(char c16) {
        throw new RuntimeException("Stub!");
    }

    protected boolean isTokenSeparator(char c16) {
        throw new RuntimeException("Stub!");
    }

    protected boolean isWhitespace(char c16) {
        throw new RuntimeException("Stub!");
    }

    @Override // java.util.Iterator
    public final Object next() throws NoSuchElementException, ParseException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.TokenIterator
    public String nextToken() throws NoSuchElementException, ParseException {
        throw new RuntimeException("Stub!");
    }

    @Override // java.util.Iterator
    public final void remove() throws UnsupportedOperationException {
        throw new RuntimeException("Stub!");
    }
}
