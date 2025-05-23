package org.apache.httpcore;

import java.io.Serializable;
import org.apache.httpcore.annotation.Contract;
import org.apache.httpcore.annotation.ThreadingBehavior;
import org.apache.httpcore.util.Args;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes29.dex */
public class ProtocolVersion implements Serializable, Cloneable {
    private static final long serialVersionUID = 8950662842175091068L;
    protected final int major;
    protected final int minor;

    /* renamed from: protocol, reason: collision with root package name */
    protected final String f423543protocol;

    public ProtocolVersion(String str, int i3, int i16) {
        this.f423543protocol = (String) Args.notNull(str, "Protocol name");
        this.major = Args.notNegative(i3, "Protocol major version");
        this.minor = Args.notNegative(i16, "Protocol minor version");
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int compareToVersion(ProtocolVersion protocolVersion) {
        Args.notNull(protocolVersion, "Protocol version");
        Args.check(this.f423543protocol.equals(protocolVersion.f423543protocol), "Versions for different protocols cannot be compared: %s %s", this, protocolVersion);
        int major = getMajor() - protocolVersion.getMajor();
        if (major == 0) {
            return getMinor() - protocolVersion.getMinor();
        }
        return major;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProtocolVersion)) {
            return false;
        }
        ProtocolVersion protocolVersion = (ProtocolVersion) obj;
        if (this.f423543protocol.equals(protocolVersion.f423543protocol) && this.major == protocolVersion.major && this.minor == protocolVersion.minor) {
            return true;
        }
        return false;
    }

    public ProtocolVersion forVersion(int i3, int i16) {
        if (i3 == this.major && i16 == this.minor) {
            return this;
        }
        return new ProtocolVersion(this.f423543protocol, i3, i16);
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public final String getProtocol() {
        return this.f423543protocol;
    }

    public final boolean greaterEquals(ProtocolVersion protocolVersion) {
        if (isComparable(protocolVersion) && compareToVersion(protocolVersion) >= 0) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.f423543protocol.hashCode() ^ (this.major * 100000)) ^ this.minor;
    }

    public boolean isComparable(ProtocolVersion protocolVersion) {
        if (protocolVersion != null && this.f423543protocol.equals(protocolVersion.f423543protocol)) {
            return true;
        }
        return false;
    }

    public final boolean lessEquals(ProtocolVersion protocolVersion) {
        if (isComparable(protocolVersion) && compareToVersion(protocolVersion) <= 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.f423543protocol + '/' + Integer.toString(this.major) + '.' + Integer.toString(this.minor);
    }
}
