package org.apache.httpcore.config;

import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import org.apache.httpcore.Consts;
import org.apache.httpcore.annotation.Contract;
import org.apache.httpcore.annotation.ThreadingBehavior;
import org.apache.httpcore.util.Args;

/* compiled from: P */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes29.dex */
public class ConnectionConfig implements Cloneable {
    public static final ConnectionConfig DEFAULT = new Builder().build();
    private final int bufferSize;
    private final Charset charset;
    private final int fragmentSizeHint;
    private final CodingErrorAction malformedInputAction;
    private final MessageConstraints messageConstraints;
    private final CodingErrorAction unmappableInputAction;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class Builder {
        private int bufferSize;
        private Charset charset;
        private int fragmentSizeHint = -1;
        private CodingErrorAction malformedInputAction;
        private MessageConstraints messageConstraints;
        private CodingErrorAction unmappableInputAction;

        Builder() {
        }

        public ConnectionConfig build() {
            int i3;
            Charset charset = this.charset;
            if (charset == null && (this.malformedInputAction != null || this.unmappableInputAction != null)) {
                charset = Consts.ASCII;
            }
            Charset charset2 = charset;
            int i16 = this.bufferSize;
            if (i16 <= 0) {
                i16 = 8192;
            }
            int i17 = i16;
            int i18 = this.fragmentSizeHint;
            if (i18 >= 0) {
                i3 = i18;
            } else {
                i3 = i17;
            }
            return new ConnectionConfig(i17, i3, charset2, this.malformedInputAction, this.unmappableInputAction, this.messageConstraints);
        }

        public Builder setBufferSize(int i3) {
            this.bufferSize = i3;
            return this;
        }

        public Builder setCharset(Charset charset) {
            this.charset = charset;
            return this;
        }

        public Builder setFragmentSizeHint(int i3) {
            this.fragmentSizeHint = i3;
            return this;
        }

        public Builder setMalformedInputAction(CodingErrorAction codingErrorAction) {
            this.malformedInputAction = codingErrorAction;
            if (codingErrorAction != null && this.charset == null) {
                this.charset = Consts.ASCII;
            }
            return this;
        }

        public Builder setMessageConstraints(MessageConstraints messageConstraints) {
            this.messageConstraints = messageConstraints;
            return this;
        }

        public Builder setUnmappableInputAction(CodingErrorAction codingErrorAction) {
            this.unmappableInputAction = codingErrorAction;
            if (codingErrorAction != null && this.charset == null) {
                this.charset = Consts.ASCII;
            }
            return this;
        }
    }

    ConnectionConfig(int i3, int i16, Charset charset, CodingErrorAction codingErrorAction, CodingErrorAction codingErrorAction2, MessageConstraints messageConstraints) {
        this.bufferSize = i3;
        this.fragmentSizeHint = i16;
        this.charset = charset;
        this.malformedInputAction = codingErrorAction;
        this.unmappableInputAction = codingErrorAction2;
        this.messageConstraints = messageConstraints;
    }

    public static Builder copy(ConnectionConfig connectionConfig) {
        Args.notNull(connectionConfig, "Connection config");
        return new Builder().setBufferSize(connectionConfig.getBufferSize()).setCharset(connectionConfig.getCharset()).setFragmentSizeHint(connectionConfig.getFragmentSizeHint()).setMalformedInputAction(connectionConfig.getMalformedInputAction()).setUnmappableInputAction(connectionConfig.getUnmappableInputAction()).setMessageConstraints(connectionConfig.getMessageConstraints());
    }

    public static Builder custom() {
        return new Builder();
    }

    public int getBufferSize() {
        return this.bufferSize;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public int getFragmentSizeHint() {
        return this.fragmentSizeHint;
    }

    public CodingErrorAction getMalformedInputAction() {
        return this.malformedInputAction;
    }

    public MessageConstraints getMessageConstraints() {
        return this.messageConstraints;
    }

    public CodingErrorAction getUnmappableInputAction() {
        return this.unmappableInputAction;
    }

    public String toString() {
        return "[bufferSize=" + this.bufferSize + ", fragmentSizeHint=" + this.fragmentSizeHint + ", charset=" + this.charset + ", malformedInputAction=" + this.malformedInputAction + ", unmappableInputAction=" + this.unmappableInputAction + ", messageConstraints=" + this.messageConstraints + "]";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ConnectionConfig clone() throws CloneNotSupportedException {
        return (ConnectionConfig) super.clone();
    }
}
