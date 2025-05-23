package com.tencent.mobileqq.msfcore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface MSFKernelBridge {
    public static final IPatchRedirector $redirector_ = null;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static final class CppProxy implements MSFKernelBridge {
        static final /* synthetic */ boolean $assertionsDisabled;
        static IPatchRedirector $redirector_;
        private final AtomicBoolean destroyed;
        private final long nativeRef;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7495);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 44)) {
                redirector.redirect((short) 44);
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

        @Nullable
        public static native MSFKernelBridge create(@Nullable UpperBridges upperBridges, boolean z16);

        @Nullable
        public static native MSFKernelBridge getInstance();

        private native void nativeDestroy(long j3);

        private native void native_appDidEnterBackground(long j3);

        private native void native_appWillEnterForeground(long j3);

        private native void native_clearHistorySigns(long j3);

        private native void native_clearSign(long j3, String str);

        private native void native_connect(long j3);

        private native int native_currentConnType(long j3);

        private native long native_currentRtt(long j3);

        private native String native_currentSSOAddr(long j3);

        private native String native_currentSSOIP(long j3);

        private native void native_disconnect(long j3);

        private native int native_getApnState(long j3);

        private native String native_getClientIP(long j3);

        private native long native_getConnSeq(long j3);

        private native int native_getConnectState(long j3);

        private native int native_getCurrentUsedIPType(long j3);

        private native int native_getIPStackType(long j3);

        private native MSFConfigBridge native_getMSFConfigBridge(long j3);

        private native int native_getNextPacketSeq(long j3);

        private native int native_getServerTimeDiff(long j3);

        private native void native_initMSFCore(long j3, int i3, String str, String str2, MSFGeneralConfig mSFGeneralConfig);

        private native boolean native_isBadNetwork(long j3);

        private native boolean native_isConnected(long j3);

        private native boolean native_isConnecting(long j3);

        private native boolean native_isPullIpOver(long j3);

        private native void native_notifyLoginSuccess(long j3, String str, int i3, String str2, byte[] bArr, byte[] bArr2, byte[] bArr3);

        private native void native_notifyLogout(long j3);

        private native void native_notifyNetworkInfo(long j3, int i3, int i16, MSFExternNetworkInfo mSFExternNetworkInfo);

        private native void native_notifyRefreshSign(long j3, String str, int i3, String str2, byte[] bArr, byte[] bArr2, byte[] bArr3);

        private native long native_recvQueueSize(long j3);

        private native void native_sendMSFPingCheck(long j3, int i3);

        private native int native_sendPacket(long j3, MSFRequestAdapter mSFRequestAdapter);

        private native long native_sendQueueSize(long j3);

        private native boolean native_setCertificateData(long j3, String str);

        private native void native_setLightQuicLogListener(long j3, int i3);

        private native void native_setLogLevel(long j3, int i3);

        private native void native_setMSFReportSampleRate(long j3, HashMap<String, Integer> hashMap);

        private native void native_setMSFWhiteList(long j3, int i3, ArrayList<String> arrayList);

        private native void native_setQimei36(long j3, String str);

        private native void native_setSSOTestEnv(long j3, String str, int i3, String str2);

        private native void native_updateSidewayNetId(long j3, long j16);

        public void _djinni_private_destroy() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.mobileqq.msfcore.MSFKernelBridge
        public void appDidEnterBackground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
                iPatchRedirector.redirect((short) 32, (Object) this);
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_appDidEnterBackground(this.nativeRef);
            }
        }

        @Override // com.tencent.mobileqq.msfcore.MSFKernelBridge
        public void appWillEnterForeground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
                iPatchRedirector.redirect((short) 31, (Object) this);
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_appWillEnterForeground(this.nativeRef);
            }
        }

        @Override // com.tencent.mobileqq.msfcore.MSFKernelBridge
        public void clearHistorySigns() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                iPatchRedirector.redirect((short) 16, (Object) this);
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_clearHistorySigns(this.nativeRef);
            }
        }

        @Override // com.tencent.mobileqq.msfcore.MSFKernelBridge
        public void clearSign(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_clearSign(this.nativeRef, str);
            }
        }

        @Override // com.tencent.mobileqq.msfcore.MSFKernelBridge
        public void connect() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_connect(this.nativeRef);
            }
        }

        @Override // com.tencent.mobileqq.msfcore.MSFKernelBridge
        public int currentConnType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
                return ((Integer) iPatchRedirector.redirect((short) 41, (Object) this)).intValue();
            }
            if (!$assertionsDisabled && this.destroyed.get()) {
                throw new AssertionError("trying to use a destroyed object");
            }
            return native_currentConnType(this.nativeRef);
        }

        @Override // com.tencent.mobileqq.msfcore.MSFKernelBridge
        public long currentRtt() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
                return ((Long) iPatchRedirector.redirect((short) 38, (Object) this)).longValue();
            }
            if (!$assertionsDisabled && this.destroyed.get()) {
                throw new AssertionError("trying to use a destroyed object");
            }
            return native_currentRtt(this.nativeRef);
        }

        @Override // com.tencent.mobileqq.msfcore.MSFKernelBridge
        public String currentSSOAddr() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
                return (String) iPatchRedirector.redirect((short) 26, (Object) this);
            }
            if (!$assertionsDisabled && this.destroyed.get()) {
                throw new AssertionError("trying to use a destroyed object");
            }
            return native_currentSSOAddr(this.nativeRef);
        }

        @Override // com.tencent.mobileqq.msfcore.MSFKernelBridge
        public String currentSSOIP() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                return (String) iPatchRedirector.redirect((short) 25, (Object) this);
            }
            if (!$assertionsDisabled && this.destroyed.get()) {
                throw new AssertionError("trying to use a destroyed object");
            }
            return native_currentSSOIP(this.nativeRef);
        }

        @Override // com.tencent.mobileqq.msfcore.MSFKernelBridge
        public void disconnect() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this);
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_disconnect(this.nativeRef);
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

        @Override // com.tencent.mobileqq.msfcore.MSFKernelBridge
        public int getApnState() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
            }
            if (!$assertionsDisabled && this.destroyed.get()) {
                throw new AssertionError("trying to use a destroyed object");
            }
            return native_getApnState(this.nativeRef);
        }

        @Override // com.tencent.mobileqq.msfcore.MSFKernelBridge
        public String getClientIP() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                return (String) iPatchRedirector.redirect((short) 22, (Object) this);
            }
            if (!$assertionsDisabled && this.destroyed.get()) {
                throw new AssertionError("trying to use a destroyed object");
            }
            return native_getClientIP(this.nativeRef);
        }

        @Override // com.tencent.mobileqq.msfcore.MSFKernelBridge
        public long getConnSeq() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
                return ((Long) iPatchRedirector.redirect((short) 34, (Object) this)).longValue();
            }
            if (!$assertionsDisabled && this.destroyed.get()) {
                throw new AssertionError("trying to use a destroyed object");
            }
            return native_getConnSeq(this.nativeRef);
        }

        @Override // com.tencent.mobileqq.msfcore.MSFKernelBridge
        public int getConnectState() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
            }
            if (!$assertionsDisabled && this.destroyed.get()) {
                throw new AssertionError("trying to use a destroyed object");
            }
            return native_getConnectState(this.nativeRef);
        }

        @Override // com.tencent.mobileqq.msfcore.MSFKernelBridge
        public int getCurrentUsedIPType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
            }
            if (!$assertionsDisabled && this.destroyed.get()) {
                throw new AssertionError("trying to use a destroyed object");
            }
            return native_getCurrentUsedIPType(this.nativeRef);
        }

        @Override // com.tencent.mobileqq.msfcore.MSFKernelBridge
        public int getIPStackType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
            }
            if (!$assertionsDisabled && this.destroyed.get()) {
                throw new AssertionError("trying to use a destroyed object");
            }
            return native_getIPStackType(this.nativeRef);
        }

        @Override // com.tencent.mobileqq.msfcore.MSFKernelBridge
        public MSFConfigBridge getMSFConfigBridge() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
                return (MSFConfigBridge) iPatchRedirector.redirect((short) 36, (Object) this);
            }
            if (!$assertionsDisabled && this.destroyed.get()) {
                throw new AssertionError("trying to use a destroyed object");
            }
            return native_getMSFConfigBridge(this.nativeRef);
        }

        @Override // com.tencent.mobileqq.msfcore.MSFKernelBridge
        public int getNextPacketSeq() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
            }
            if (!$assertionsDisabled && this.destroyed.get()) {
                throw new AssertionError("trying to use a destroyed object");
            }
            return native_getNextPacketSeq(this.nativeRef);
        }

        @Override // com.tencent.mobileqq.msfcore.MSFKernelBridge
        public int getServerTimeDiff() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
            }
            if (!$assertionsDisabled && this.destroyed.get()) {
                throw new AssertionError("trying to use a destroyed object");
            }
            return native_getServerTimeDiff(this.nativeRef);
        }

        @Override // com.tencent.mobileqq.msfcore.MSFKernelBridge
        public void initMSFCore(int i3, String str, String str2, MSFGeneralConfig mSFGeneralConfig) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), str, str2, mSFGeneralConfig);
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_initMSFCore(this.nativeRef, i3, str, str2, mSFGeneralConfig);
            }
        }

        @Override // com.tencent.mobileqq.msfcore.MSFKernelBridge
        public boolean isBadNetwork() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
            }
            if (!$assertionsDisabled && this.destroyed.get()) {
                throw new AssertionError("trying to use a destroyed object");
            }
            return native_isBadNetwork(this.nativeRef);
        }

        @Override // com.tencent.mobileqq.msfcore.MSFKernelBridge
        public boolean isConnected() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
            }
            if (!$assertionsDisabled && this.destroyed.get()) {
                throw new AssertionError("trying to use a destroyed object");
            }
            return native_isConnected(this.nativeRef);
        }

        @Override // com.tencent.mobileqq.msfcore.MSFKernelBridge
        public boolean isConnecting() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
            }
            if (!$assertionsDisabled && this.destroyed.get()) {
                throw new AssertionError("trying to use a destroyed object");
            }
            return native_isConnecting(this.nativeRef);
        }

        @Override // com.tencent.mobileqq.msfcore.MSFKernelBridge
        public boolean isPullIpOver() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
            }
            if (!$assertionsDisabled && this.destroyed.get()) {
                throw new AssertionError("trying to use a destroyed object");
            }
            return native_isPullIpOver(this.nativeRef);
        }

        @Override // com.tencent.mobileqq.msfcore.MSFKernelBridge
        public void notifyLoginSuccess(String str, int i3, String str2, byte[] bArr, byte[] bArr2, byte[] bArr3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, this, str, Integer.valueOf(i3), str2, bArr, bArr2, bArr3);
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_notifyLoginSuccess(this.nativeRef, str, i3, str2, bArr, bArr2, bArr3);
            }
        }

        @Override // com.tencent.mobileqq.msfcore.MSFKernelBridge
        public void notifyLogout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, (Object) this);
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_notifyLogout(this.nativeRef);
            }
        }

        @Override // com.tencent.mobileqq.msfcore.MSFKernelBridge
        public void notifyNetworkInfo(int i3, int i16, MSFExternNetworkInfo mSFExternNetworkInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
                iPatchRedirector.redirect((short) 33, this, Integer.valueOf(i3), Integer.valueOf(i16), mSFExternNetworkInfo);
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_notifyNetworkInfo(this.nativeRef, i3, i16, mSFExternNetworkInfo);
            }
        }

        @Override // com.tencent.mobileqq.msfcore.MSFKernelBridge
        public void notifyRefreshSign(String str, int i3, String str2, byte[] bArr, byte[] bArr2, byte[] bArr3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, this, str, Integer.valueOf(i3), str2, bArr, bArr2, bArr3);
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_notifyRefreshSign(this.nativeRef, str, i3, str2, bArr, bArr2, bArr3);
            }
        }

        @Override // com.tencent.mobileqq.msfcore.MSFKernelBridge
        public long recvQueueSize() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
                return ((Long) iPatchRedirector.redirect((short) 40, (Object) this)).longValue();
            }
            if (!$assertionsDisabled && this.destroyed.get()) {
                throw new AssertionError("trying to use a destroyed object");
            }
            return native_recvQueueSize(this.nativeRef);
        }

        @Override // com.tencent.mobileqq.msfcore.MSFKernelBridge
        public void sendMSFPingCheck(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
                iPatchRedirector.redirect((short) 43, (Object) this, i3);
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_sendMSFPingCheck(this.nativeRef, i3);
            }
        }

        @Override // com.tencent.mobileqq.msfcore.MSFKernelBridge
        public int sendPacket(MSFRequestAdapter mSFRequestAdapter) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) mSFRequestAdapter)).intValue();
            }
            if (!$assertionsDisabled && this.destroyed.get()) {
                throw new AssertionError("trying to use a destroyed object");
            }
            return native_sendPacket(this.nativeRef, mSFRequestAdapter);
        }

        @Override // com.tencent.mobileqq.msfcore.MSFKernelBridge
        public long sendQueueSize() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
                return ((Long) iPatchRedirector.redirect((short) 39, (Object) this)).longValue();
            }
            if (!$assertionsDisabled && this.destroyed.get()) {
                throw new AssertionError("trying to use a destroyed object");
            }
            return native_sendQueueSize(this.nativeRef);
        }

        @Override // com.tencent.mobileqq.msfcore.MSFKernelBridge
        public boolean setCertificateData(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
                return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this, (Object) str)).booleanValue();
            }
            if (!$assertionsDisabled && this.destroyed.get()) {
                throw new AssertionError("trying to use a destroyed object");
            }
            return native_setCertificateData(this.nativeRef, str);
        }

        @Override // com.tencent.mobileqq.msfcore.MSFKernelBridge
        public void setLightQuicLogListener(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
                iPatchRedirector.redirect((short) 42, (Object) this, i3);
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_setLightQuicLogListener(this.nativeRef, i3);
            }
        }

        @Override // com.tencent.mobileqq.msfcore.MSFKernelBridge
        public void setLogLevel(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_setLogLevel(this.nativeRef, i3);
            }
        }

        @Override // com.tencent.mobileqq.msfcore.MSFKernelBridge
        public void setMSFReportSampleRate(HashMap<String, Integer> hashMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
                iPatchRedirector.redirect((short) 29, (Object) this, (Object) hashMap);
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_setMSFReportSampleRate(this.nativeRef, hashMap);
            }
        }

        @Override // com.tencent.mobileqq.msfcore.MSFKernelBridge
        public void setMSFWhiteList(int i3, ArrayList<String> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
                iPatchRedirector.redirect((short) 28, (Object) this, i3, (Object) arrayList);
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_setMSFWhiteList(this.nativeRef, i3, arrayList);
            }
        }

        @Override // com.tencent.mobileqq.msfcore.MSFKernelBridge
        public void setQimei36(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
                iPatchRedirector.redirect((short) 27, (Object) this, (Object) str);
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_setQimei36(this.nativeRef, str);
            }
        }

        @Override // com.tencent.mobileqq.msfcore.MSFKernelBridge
        public void setSSOTestEnv(String str, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
                iPatchRedirector.redirect((short) 30, this, str, Integer.valueOf(i3), str2);
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_setSSOTestEnv(this.nativeRef, str, i3, str2);
            }
        }

        @Override // com.tencent.mobileqq.msfcore.MSFKernelBridge
        public void updateSidewayNetId(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
                iPatchRedirector.redirect((short) 37, (Object) this, j3);
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_updateSidewayNetId(this.nativeRef, j3);
            }
        }
    }

    void appDidEnterBackground();

    void appWillEnterForeground();

    void clearHistorySigns();

    void clearSign(@NonNull String str);

    void connect();

    int currentConnType();

    long currentRtt();

    @NonNull
    String currentSSOAddr();

    @NonNull
    String currentSSOIP();

    void disconnect();

    int getApnState();

    @NonNull
    String getClientIP();

    long getConnSeq();

    int getConnectState();

    int getCurrentUsedIPType();

    int getIPStackType();

    @Nullable
    MSFConfigBridge getMSFConfigBridge();

    int getNextPacketSeq();

    int getServerTimeDiff();

    void initMSFCore(int i3, @NonNull String str, @NonNull String str2, @NonNull MSFGeneralConfig mSFGeneralConfig);

    boolean isBadNetwork();

    boolean isConnected();

    boolean isConnecting();

    boolean isPullIpOver();

    void notifyLoginSuccess(@NonNull String str, int i3, @NonNull String str2, @NonNull byte[] bArr, @NonNull byte[] bArr2, @NonNull byte[] bArr3);

    void notifyLogout();

    void notifyNetworkInfo(int i3, int i16, @NonNull MSFExternNetworkInfo mSFExternNetworkInfo);

    void notifyRefreshSign(@NonNull String str, int i3, @NonNull String str2, @NonNull byte[] bArr, @NonNull byte[] bArr2, @NonNull byte[] bArr3);

    long recvQueueSize();

    void sendMSFPingCheck(int i3);

    int sendPacket(@NonNull MSFRequestAdapter mSFRequestAdapter);

    long sendQueueSize();

    boolean setCertificateData(@NonNull String str);

    void setLightQuicLogListener(int i3);

    void setLogLevel(int i3);

    void setMSFReportSampleRate(@NonNull HashMap<String, Integer> hashMap);

    void setMSFWhiteList(int i3, @NonNull ArrayList<String> arrayList);

    void setQimei36(@NonNull String str);

    void setSSOTestEnv(@NonNull String str, int i3, @NonNull String str2);

    void updateSidewayNetId(long j3);
}
