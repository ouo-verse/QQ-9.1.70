package org.apache.commons.lang;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.lang.text.StrBuilder;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class CharRange implements Serializable {
    private static final long serialVersionUID = 8270183163158333422L;
    private final char end;
    private transient String iToString;
    private final boolean negated;
    private final char start;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private static class CharacterIterator implements Iterator {
        private char current;
        private boolean hasNext;
        private final CharRange range;

        private void prepareNext() {
            if (this.range.negated) {
                char c16 = this.current;
                if (c16 == '\uffff') {
                    this.hasNext = false;
                    return;
                }
                if (c16 + 1 == this.range.start) {
                    if (this.range.end == '\uffff') {
                        this.hasNext = false;
                        return;
                    } else {
                        this.current = (char) (this.range.end + 1);
                        return;
                    }
                }
                this.current = (char) (this.current + 1);
                return;
            }
            if (this.current < this.range.end) {
                this.current = (char) (this.current + 1);
            } else {
                this.hasNext = false;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.hasNext;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.hasNext) {
                char c16 = this.current;
                prepareNext();
                return new Character(c16);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        CharacterIterator(CharRange charRange) {
            this.range = charRange;
            this.hasNext = true;
            if (charRange.negated) {
                if (charRange.start == 0) {
                    if (charRange.end != '\uffff') {
                        this.current = (char) (charRange.end + 1);
                        return;
                    } else {
                        this.hasNext = false;
                        return;
                    }
                }
                this.current = (char) 0;
                return;
            }
            this.current = charRange.start;
        }
    }

    public CharRange(char c16) {
        this(c16, c16, false);
    }

    public static CharRange is(char c16) {
        return new CharRange(c16, c16, false);
    }

    public static CharRange isIn(char c16, char c17) {
        return new CharRange(c16, c17, false);
    }

    public static CharRange isNot(char c16) {
        return new CharRange(c16, c16, true);
    }

    public static CharRange isNotIn(char c16, char c17) {
        return new CharRange(c16, c17, true);
    }

    public boolean contains(char c16) {
        return (c16 >= this.start && c16 <= this.end) != this.negated;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CharRange)) {
            return false;
        }
        CharRange charRange = (CharRange) obj;
        if (this.start == charRange.start && this.end == charRange.end && this.negated == charRange.negated) {
            return true;
        }
        return false;
    }

    public char getEnd() {
        return this.end;
    }

    public char getStart() {
        return this.start;
    }

    public int hashCode() {
        return this.start + 'S' + (this.end * 7) + (this.negated ? 1 : 0);
    }

    public boolean isNegated() {
        return this.negated;
    }

    public Iterator iterator() {
        return new CharacterIterator();
    }

    public String toString() {
        if (this.iToString == null) {
            StrBuilder strBuilder = new StrBuilder(4);
            if (isNegated()) {
                strBuilder.append('^');
            }
            strBuilder.append(this.start);
            if (this.start != this.end) {
                strBuilder.append('-');
                strBuilder.append(this.end);
            }
            this.iToString = strBuilder.toString();
        }
        return this.iToString;
    }

    public CharRange(char c16, boolean z16) {
        this(c16, c16, z16);
    }

    public boolean contains(CharRange charRange) {
        if (charRange != null) {
            return this.negated ? charRange.negated ? this.start >= charRange.start && this.end <= charRange.end : charRange.end < this.start || charRange.start > this.end : charRange.negated ? this.start == 0 && this.end == '\uffff' : this.start <= charRange.start && this.end >= charRange.end;
        }
        throw new IllegalArgumentException("The Range must not be null");
    }

    public CharRange(char c16, char c17) {
        this(c16, c17, false);
    }

    public CharRange(char c16, char c17, boolean z16) {
        if (c16 > c17) {
            c17 = c16;
            c16 = c17;
        }
        this.start = c16;
        this.end = c17;
        this.negated = z16;
    }
}
