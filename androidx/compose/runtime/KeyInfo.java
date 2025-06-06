package androidx.compose.runtime;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B1\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\bR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Landroidx/compose/runtime/KeyInfo;", "", "key", "", "objectKey", "location", "nodes", "index", "(ILjava/lang/Object;III)V", "getIndex", "()I", "getKey", "getLocation", "getNodes", "getObjectKey", "()Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class KeyInfo {
    private final int index;
    private final int key;
    private final int location;
    private final int nodes;
    private final Object objectKey;

    public KeyInfo(int i3, Object obj, int i16, int i17, int i18) {
        this.key = i3;
        this.objectKey = obj;
        this.location = i16;
        this.nodes = i17;
        this.index = i18;
    }

    public final int getIndex() {
        return this.index;
    }

    public final int getKey() {
        return this.key;
    }

    public final int getLocation() {
        return this.location;
    }

    public final int getNodes() {
        return this.nodes;
    }

    public final Object getObjectKey() {
        return this.objectKey;
    }
}
