package org.apache.httpcore.config;

import org.apache.httpcore.util.Args;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MessageConstraints implements Cloneable {
    public static final MessageConstraints DEFAULT = new Builder().build();
    private final int maxHeaderCount;
    private final int maxLineLength;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class Builder {
        private int maxLineLength = -1;
        private int maxHeaderCount = -1;

        Builder() {
        }

        public MessageConstraints build() {
            return new MessageConstraints(this.maxLineLength, this.maxHeaderCount);
        }

        public Builder setMaxHeaderCount(int i3) {
            this.maxHeaderCount = i3;
            return this;
        }

        public Builder setMaxLineLength(int i3) {
            this.maxLineLength = i3;
            return this;
        }
    }

    MessageConstraints(int i3, int i16) {
        this.maxLineLength = i3;
        this.maxHeaderCount = i16;
    }

    public static Builder copy(MessageConstraints messageConstraints) {
        Args.notNull(messageConstraints, "Message constraints");
        return new Builder().setMaxHeaderCount(messageConstraints.getMaxHeaderCount()).setMaxLineLength(messageConstraints.getMaxLineLength());
    }

    public static Builder custom() {
        return new Builder();
    }

    public static MessageConstraints lineLen(int i3) {
        return new MessageConstraints(Args.notNegative(i3, "Max line length"), -1);
    }

    public int getMaxHeaderCount() {
        return this.maxHeaderCount;
    }

    public int getMaxLineLength() {
        return this.maxLineLength;
    }

    public String toString() {
        return "[maxLineLength=" + this.maxLineLength + ", maxHeaderCount=" + this.maxHeaderCount + "]";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MessageConstraints clone() throws CloneNotSupportedException {
        return (MessageConstraints) super.clone();
    }
}
