package org.apache.httpcore.message;

import kotlin.text.Typography;

/* loaded from: classes29.dex */
public class ParserCursor {
    private final int lowerBound;
    private int pos;
    private final int upperBound;

    public ParserCursor(int i3, int i16) {
        if (i3 >= 0) {
            if (i3 <= i16) {
                this.lowerBound = i3;
                this.upperBound = i16;
                this.pos = i3;
                return;
            }
            throw new IndexOutOfBoundsException("Lower bound cannot be greater then upper bound");
        }
        throw new IndexOutOfBoundsException("Lower bound cannot be negative");
    }

    public boolean atEnd() {
        if (this.pos >= this.upperBound) {
            return true;
        }
        return false;
    }

    public int getLowerBound() {
        return this.lowerBound;
    }

    public int getPos() {
        return this.pos;
    }

    public int getUpperBound() {
        return this.upperBound;
    }

    public String toString() {
        return '[' + Integer.toString(this.lowerBound) + Typography.greater + Integer.toString(this.pos) + Typography.greater + Integer.toString(this.upperBound) + ']';
    }

    public void updatePos(int i3) {
        if (i3 >= this.lowerBound) {
            if (i3 <= this.upperBound) {
                this.pos = i3;
                return;
            }
            throw new IndexOutOfBoundsException("pos: " + i3 + " > upperBound: " + this.upperBound);
        }
        throw new IndexOutOfBoundsException("pos: " + i3 + " < lowerBound: " + this.lowerBound);
    }
}
