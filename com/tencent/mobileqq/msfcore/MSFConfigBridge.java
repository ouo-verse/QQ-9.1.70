package com.tencent.mobileqq.msfcore;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface MSFConfigBridge {

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static final class CppProxy implements MSFConfigBridge {
        static final /* synthetic */ boolean $assertionsDisabled;
        static IPatchRedirector $redirector_;
        private final AtomicBoolean destroyed;
        private final long nativeRef;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7093);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 17)) {
                redirector.redirect((short) 17);
            } else {
                $assertionsDisabled = true;
            }
        }

        CppProxy(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, j3);
                return;
            }
            this.destroyed = new AtomicBoolean(false);
            if (j3 != 0) {
                this.nativeRef = j3;
                return;
            }
            throw new RuntimeException("nativeRef is zero");
        }

        private native void nativeDestroy(long j3);

        private native void native_setMSFCoreModifyConfig(long j3, MSFModifyConfig mSFModifyConfig);

        private native void native_setMSFDualEngineConfig(long j3, MSFDualEngineConfig mSFDualEngineConfig);

        private native void native_setMSFGeneralConfig(long j3, MSFGeneralConfig mSFGeneralConfig);

        private native void native_setMSFMultiTcpConfig(long j3, MSFMultiTcpConfig mSFMultiTcpConfig);

        private native void native_setMSFNetworkConfig(long j3, MSFNetworkConfig mSFNetworkConfig);

        private native void native_setMSFPacketCombineConfig(long j3, MSFPacketCombineConfig mSFPacketCombineConfig);

        private native void native_setMSFPkgCompressConfig(long j3, MSFPkgCompressConfig mSFPkgCompressConfig);

        private native void native_setMSFPkgStatisticsConfig(long j3, MSFPkgStatisticsConfig mSFPkgStatisticsConfig);

        private native void native_setMSFQuicEngineConfig(long j3, MSFQuicEngineConfig mSFQuicEngineConfig);

        private native void native_setMSFSSIDConfig(long j3, MSFSSIDConfig mSFSSIDConfig);

        private native void native_setMSFSideWayHttpConfig(long j3, MSFSideWayHttpConfig mSFSideWayHttpConfig);

        private native void native_setMSFSideWayUdpConfig(long j3, MSFSideWayUdpConfig mSFSideWayUdpConfig);

        private native void native_setMSFTcpEngineConfig(long j3, MSFTcpEngineConfig mSFTcpEngineConfig);

        public void _djinni_private_destroy() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        protected void finalize() throws Throwable {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                _djinni_private_destroy();
                super.finalize();
            }
        }

        @Override // com.tencent.mobileqq.msfcore.MSFConfigBridge
        public void setMSFCoreModifyConfig(MSFModifyConfig mSFModifyConfig) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, (Object) mSFModifyConfig);
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_setMSFCoreModifyConfig(this.nativeRef, mSFModifyConfig);
            }
        }

        @Override // com.tencent.mobileqq.msfcore.MSFConfigBridge
        public void setMSFDualEngineConfig(MSFDualEngineConfig mSFDualEngineConfig) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                iPatchRedirector.redirect((short) 16, (Object) this, (Object) mSFDualEngineConfig);
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_setMSFDualEngineConfig(this.nativeRef, mSFDualEngineConfig);
            }
        }

        @Override // com.tencent.mobileqq.msfcore.MSFConfigBridge
        public void setMSFGeneralConfig(MSFGeneralConfig mSFGeneralConfig) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) mSFGeneralConfig);
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_setMSFGeneralConfig(this.nativeRef, mSFGeneralConfig);
            }
        }

        @Override // com.tencent.mobileqq.msfcore.MSFConfigBridge
        public void setMSFMultiTcpConfig(MSFMultiTcpConfig mSFMultiTcpConfig) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) mSFMultiTcpConfig);
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_setMSFMultiTcpConfig(this.nativeRef, mSFMultiTcpConfig);
            }
        }

        @Override // com.tencent.mobileqq.msfcore.MSFConfigBridge
        public void setMSFNetworkConfig(MSFNetworkConfig mSFNetworkConfig) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this, (Object) mSFNetworkConfig);
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_setMSFNetworkConfig(this.nativeRef, mSFNetworkConfig);
            }
        }

        @Override // com.tencent.mobileqq.msfcore.MSFConfigBridge
        public void setMSFPacketCombineConfig(MSFPacketCombineConfig mSFPacketCombineConfig) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) mSFPacketCombineConfig);
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_setMSFPacketCombineConfig(this.nativeRef, mSFPacketCombineConfig);
            }
        }

        @Override // com.tencent.mobileqq.msfcore.MSFConfigBridge
        public void setMSFPkgCompressConfig(MSFPkgCompressConfig mSFPkgCompressConfig) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this, (Object) mSFPkgCompressConfig);
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_setMSFPkgCompressConfig(this.nativeRef, mSFPkgCompressConfig);
            }
        }

        @Override // com.tencent.mobileqq.msfcore.MSFConfigBridge
        public void setMSFPkgStatisticsConfig(MSFPkgStatisticsConfig mSFPkgStatisticsConfig) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) mSFPkgStatisticsConfig);
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_setMSFPkgStatisticsConfig(this.nativeRef, mSFPkgStatisticsConfig);
            }
        }

        @Override // com.tencent.mobileqq.msfcore.MSFConfigBridge
        public void setMSFQuicEngineConfig(MSFQuicEngineConfig mSFQuicEngineConfig) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, (Object) this, (Object) mSFQuicEngineConfig);
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_setMSFQuicEngineConfig(this.nativeRef, mSFQuicEngineConfig);
            }
        }

        @Override // com.tencent.mobileqq.msfcore.MSFConfigBridge
        public void setMSFSSIDConfig(MSFSSIDConfig mSFSSIDConfig) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this, (Object) mSFSSIDConfig);
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_setMSFSSIDConfig(this.nativeRef, mSFSSIDConfig);
            }
        }

        @Override // com.tencent.mobileqq.msfcore.MSFConfigBridge
        public void setMSFSideWayHttpConfig(MSFSideWayHttpConfig mSFSideWayHttpConfig) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) mSFSideWayHttpConfig);
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_setMSFSideWayHttpConfig(this.nativeRef, mSFSideWayHttpConfig);
            }
        }

        @Override // com.tencent.mobileqq.msfcore.MSFConfigBridge
        public void setMSFSideWayUdpConfig(MSFSideWayUdpConfig mSFSideWayUdpConfig) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) mSFSideWayUdpConfig);
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_setMSFSideWayUdpConfig(this.nativeRef, mSFSideWayUdpConfig);
            }
        }

        @Override // com.tencent.mobileqq.msfcore.MSFConfigBridge
        public void setMSFTcpEngineConfig(MSFTcpEngineConfig mSFTcpEngineConfig) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) mSFTcpEngineConfig);
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_setMSFTcpEngineConfig(this.nativeRef, mSFTcpEngineConfig);
            }
        }
    }

    void setMSFCoreModifyConfig(@NonNull MSFModifyConfig mSFModifyConfig);

    void setMSFDualEngineConfig(@NonNull MSFDualEngineConfig mSFDualEngineConfig);

    void setMSFGeneralConfig(@NonNull MSFGeneralConfig mSFGeneralConfig);

    void setMSFMultiTcpConfig(@NonNull MSFMultiTcpConfig mSFMultiTcpConfig);

    void setMSFNetworkConfig(@NonNull MSFNetworkConfig mSFNetworkConfig);

    void setMSFPacketCombineConfig(@NonNull MSFPacketCombineConfig mSFPacketCombineConfig);

    void setMSFPkgCompressConfig(@NonNull MSFPkgCompressConfig mSFPkgCompressConfig);

    void setMSFPkgStatisticsConfig(@NonNull MSFPkgStatisticsConfig mSFPkgStatisticsConfig);

    void setMSFQuicEngineConfig(@NonNull MSFQuicEngineConfig mSFQuicEngineConfig);

    void setMSFSSIDConfig(@NonNull MSFSSIDConfig mSFSSIDConfig);

    void setMSFSideWayHttpConfig(@NonNull MSFSideWayHttpConfig mSFSideWayHttpConfig);

    void setMSFSideWayUdpConfig(@NonNull MSFSideWayUdpConfig mSFSideWayUdpConfig);

    void setMSFTcpEngineConfig(@NonNull MSFTcpEngineConfig mSFTcpEngineConfig);
}
