package pbandk;

/* loaded from: classes34.dex */
public final class InvalidProtocolBufferException extends RuntimeException {
    public static final a Companion = new a();

    /* loaded from: classes34.dex */
    public static final class a {
        public final InvalidProtocolBufferException a() {
            return new InvalidProtocolBufferException("Encountered a malformed varint.");
        }

        public final InvalidProtocolBufferException b() {
            return new InvalidProtocolBufferException("Encountered an embedded string or message which claimed to have negative size.");
        }

        public final InvalidProtocolBufferException c() {
            return new InvalidProtocolBufferException("While parsing a protocol message, the input ended unexpectedly in the middle of a field. This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    public InvalidProtocolBufferException(String str) {
        super(str);
    }

    public InvalidProtocolBufferException(Throwable th5) {
        super("unable to read message", th5);
    }
}
