package org.tencwebrtc;

import android.support.annotation.Nullable;
import org.tencwebrtc.PeerConnection;

/* loaded from: classes29.dex */
public final class PeerConnectionDependencies {
    private final PeerConnection.Observer observer;
    private final SSLCertificateVerifier sslCertificateVerifier;

    /* loaded from: classes29.dex */
    public static class Builder {
        private PeerConnection.Observer observer;
        private SSLCertificateVerifier sslCertificateVerifier;

        public PeerConnectionDependencies createPeerConnectionDependencies() {
            return new PeerConnectionDependencies(this.observer, this.sslCertificateVerifier);
        }

        public Builder setSSLCertificateVerifier(SSLCertificateVerifier sSLCertificateVerifier) {
            this.sslCertificateVerifier = sSLCertificateVerifier;
            return this;
        }

        Builder(PeerConnection.Observer observer) {
            this.observer = observer;
        }
    }

    public static Builder builder(PeerConnection.Observer observer) {
        return new Builder(observer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PeerConnection.Observer getObserver() {
        return this.observer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public SSLCertificateVerifier getSSLCertificateVerifier() {
        return this.sslCertificateVerifier;
    }

    PeerConnectionDependencies(PeerConnection.Observer observer, SSLCertificateVerifier sSLCertificateVerifier) {
        this.observer = observer;
        this.sslCertificateVerifier = sSLCertificateVerifier;
    }
}
