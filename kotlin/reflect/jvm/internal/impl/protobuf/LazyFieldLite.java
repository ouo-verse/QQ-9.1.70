package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LazyFieldLite {
    private ByteString bytes;
    private ExtensionRegistryLite extensionRegistry;
    private volatile boolean isDirty;
    protected volatile MessageLite value;

    protected void ensureInitialized(MessageLite messageLite) {
        if (this.value != null) {
            return;
        }
        synchronized (this) {
            if (this.value != null) {
                return;
            }
            try {
                if (this.bytes != null) {
                    this.value = messageLite.getParserForType().parseFrom(this.bytes, this.extensionRegistry);
                } else {
                    this.value = messageLite;
                }
            } catch (IOException unused) {
            }
        }
    }

    public int getSerializedSize() {
        if (this.isDirty) {
            return this.value.getSerializedSize();
        }
        return this.bytes.size();
    }

    public MessageLite getValue(MessageLite messageLite) {
        ensureInitialized(messageLite);
        return this.value;
    }

    public MessageLite setValue(MessageLite messageLite) {
        MessageLite messageLite2 = this.value;
        this.value = messageLite;
        this.bytes = null;
        this.isDirty = true;
        return messageLite2;
    }
}
