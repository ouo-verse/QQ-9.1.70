package com.tencent.freesia;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface UnitedConfigBridge {
    public static final IPatchRedirector $redirector_ = null;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static final class CppProxy implements UnitedConfigBridge {
        public static final /* synthetic */ boolean $assertionsDisabled;
        static IPatchRedirector $redirector_;
        private final AtomicBoolean destroyed;
        private final long nativeRef;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10391);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
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
        public static native UnitedConfigBridge create(@Nullable UpperBridges upperBridges, @NonNull ArrayList<String> arrayList, @NonNull CommandType commandType, @NonNull Extend extend, @NonNull ExtraInitInfo extraInitInfo);

        @Nullable
        public static native UnitedConfigBridge getInstance();

        private native void nativeDestroy(long j3);

        private native void native_clearInvalidData(long j3);

        private native void native_evictCache(long j3);

        private native void native_fetchAll(long j3, String str, boolean z16);

        private native void native_fetchConfig(long j3, String str, ArrayList<String> arrayList, boolean z16);

        private native void native_fetchNoLogin(long j3, boolean z16);

        private native void native_fetchSwitch(long j3, String str, ArrayList<String> arrayList, boolean z16);

        private native String native_getConfigKey(long j3, String str, String str2, boolean z16);

        private native int native_getConfigVersion(long j3, String str, String str2);

        private native ArrayList<String> native_getGroups(long j3, String str, String str2);

        private native String native_getResourcePath(long j3, String str, String str2);

        private native int native_getUpdateInterval(long j3);

        private native boolean native_isAccountIsolate(long j3);

        private native boolean native_isCdn(long j3, String str, String str2);

        private native boolean native_isConfigHasCache(long j3, String str, String str2);

        private native boolean native_isFetchMute(long j3, long j16);

        private native boolean native_isIncFetchEnable(long j3, String str);

        private native boolean native_isSwitchOn(long j3, String str, String str2, boolean z16);

        private native IConfigData native_loadConfig(long j3, String str, String str2);

        private native IConfigData native_loadConfigCache(long j3, String str, String str2);

        private native IConfigData native_loadLargeConfig(long j3, String str, String str2);

        private native byte[] native_loadLargeRawConfig(long j3, String str, String str2, byte[] bArr);

        private native byte[] native_loadRawConfig(long j3, String str, String str2, byte[] bArr);

        private native void native_onAppForeground(long j3);

        private native void native_removeLocal(long j3, String str, String str2);

        private native void native_setEnv(long j3, boolean z16);

        private native void native_setIncFetch(long j3, boolean z16);

        public void _djinni_private_destroy() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.freesia.UnitedConfigBridge
        public void clearInvalidData() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                iPatchRedirector.redirect((short) 24, (Object) this);
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_clearInvalidData(this.nativeRef);
            }
        }

        @Override // com.tencent.freesia.UnitedConfigBridge
        public void evictCache() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                iPatchRedirector.redirect((short) 23, (Object) this);
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_evictCache(this.nativeRef);
            }
        }

        @Override // com.tencent.freesia.UnitedConfigBridge
        public void fetchAll(String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, str, Boolean.valueOf(z16));
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_fetchAll(this.nativeRef, str, z16);
            }
        }

        @Override // com.tencent.freesia.UnitedConfigBridge
        public void fetchConfig(String str, ArrayList<String> arrayList, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, str, arrayList, Boolean.valueOf(z16));
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_fetchConfig(this.nativeRef, str, arrayList, z16);
            }
        }

        @Override // com.tencent.freesia.UnitedConfigBridge
        public void fetchNoLogin(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, z16);
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_fetchNoLogin(this.nativeRef, z16);
            }
        }

        @Override // com.tencent.freesia.UnitedConfigBridge
        public void fetchSwitch(String str, ArrayList<String> arrayList, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, this, str, arrayList, Boolean.valueOf(z16));
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_fetchSwitch(this.nativeRef, str, arrayList, z16);
            }
        }

        public void finalize() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                _djinni_private_destroy();
                super.finalize();
            }
        }

        @Override // com.tencent.freesia.UnitedConfigBridge
        public String getConfigKey(String str, String str2, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (String) iPatchRedirector.redirect((short) 18, this, str, str2, Boolean.valueOf(z16));
            }
            if (!$assertionsDisabled && this.destroyed.get()) {
                throw new AssertionError("trying to use a destroyed object");
            }
            return native_getConfigKey(this.nativeRef, str, str2, z16);
        }

        @Override // com.tencent.freesia.UnitedConfigBridge
        public int getConfigVersion(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str, (Object) str2)).intValue();
            }
            if (!$assertionsDisabled && this.destroyed.get()) {
                throw new AssertionError("trying to use a destroyed object");
            }
            return native_getConfigVersion(this.nativeRef, str, str2);
        }

        @Override // com.tencent.freesia.UnitedConfigBridge
        public ArrayList<String> getGroups(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (ArrayList) iPatchRedirector.redirect((short) 16, (Object) this, (Object) str, (Object) str2);
            }
            if (!$assertionsDisabled && this.destroyed.get()) {
                throw new AssertionError("trying to use a destroyed object");
            }
            return native_getGroups(this.nativeRef, str, str2);
        }

        @Override // com.tencent.freesia.UnitedConfigBridge
        public String getResourcePath(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return (String) iPatchRedirector.redirect((short) 21, (Object) this, (Object) str, (Object) str2);
            }
            if (!$assertionsDisabled && this.destroyed.get()) {
                throw new AssertionError("trying to use a destroyed object");
            }
            return native_getResourcePath(this.nativeRef, str, str2);
        }

        @Override // com.tencent.freesia.UnitedConfigBridge
        public int getUpdateInterval() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
            }
            if (!$assertionsDisabled && this.destroyed.get()) {
                throw new AssertionError("trying to use a destroyed object");
            }
            return native_getUpdateInterval(this.nativeRef);
        }

        @Override // com.tencent.freesia.UnitedConfigBridge
        public boolean isAccountIsolate() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
                return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
            }
            if (!$assertionsDisabled && this.destroyed.get()) {
                throw new AssertionError("trying to use a destroyed object");
            }
            return native_isAccountIsolate(this.nativeRef);
        }

        @Override // com.tencent.freesia.UnitedConfigBridge
        public boolean isCdn(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) str, (Object) str2)).booleanValue();
            }
            if (!$assertionsDisabled && this.destroyed.get()) {
                throw new AssertionError("trying to use a destroyed object");
            }
            return native_isCdn(this.nativeRef, str, str2);
        }

        @Override // com.tencent.freesia.UnitedConfigBridge
        public boolean isConfigHasCache(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) str, (Object) str2)).booleanValue();
            }
            if (!$assertionsDisabled && this.destroyed.get()) {
                throw new AssertionError("trying to use a destroyed object");
            }
            return native_isConfigHasCache(this.nativeRef, str, str2);
        }

        @Override // com.tencent.freesia.UnitedConfigBridge
        public boolean isFetchMute(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
                return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this, j3)).booleanValue();
            }
            if (!$assertionsDisabled && this.destroyed.get()) {
                throw new AssertionError("trying to use a destroyed object");
            }
            return native_isFetchMute(this.nativeRef, j3);
        }

        @Override // com.tencent.freesia.UnitedConfigBridge
        public boolean isIncFetchEnable(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
                return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this, (Object) str)).booleanValue();
            }
            if (!$assertionsDisabled && this.destroyed.get()) {
                throw new AssertionError("trying to use a destroyed object");
            }
            return native_isIncFetchEnable(this.nativeRef, str);
        }

        @Override // com.tencent.freesia.UnitedConfigBridge
        public boolean isSwitchOn(String str, String str2, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return ((Boolean) iPatchRedirector.redirect((short) 15, this, str, str2, Boolean.valueOf(z16))).booleanValue();
            }
            if (!$assertionsDisabled && this.destroyed.get()) {
                throw new AssertionError("trying to use a destroyed object");
            }
            return native_isSwitchOn(this.nativeRef, str, str2, z16);
        }

        @Override // com.tencent.freesia.UnitedConfigBridge
        public IConfigData loadConfig(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (IConfigData) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) str2);
            }
            if (!$assertionsDisabled && this.destroyed.get()) {
                throw new AssertionError("trying to use a destroyed object");
            }
            return native_loadConfig(this.nativeRef, str, str2);
        }

        @Override // com.tencent.freesia.UnitedConfigBridge
        public IConfigData loadConfigCache(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (IConfigData) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, (Object) str2);
            }
            if (!$assertionsDisabled && this.destroyed.get()) {
                throw new AssertionError("trying to use a destroyed object");
            }
            return native_loadConfigCache(this.nativeRef, str, str2);
        }

        @Override // com.tencent.freesia.UnitedConfigBridge
        public IConfigData loadLargeConfig(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (IConfigData) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, (Object) str2);
            }
            if (!$assertionsDisabled && this.destroyed.get()) {
                throw new AssertionError("trying to use a destroyed object");
            }
            return native_loadLargeConfig(this.nativeRef, str, str2);
        }

        @Override // com.tencent.freesia.UnitedConfigBridge
        public byte[] loadLargeRawConfig(String str, String str2, byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (byte[]) iPatchRedirector.redirect((short) 14, this, str, str2, bArr);
            }
            if (!$assertionsDisabled && this.destroyed.get()) {
                throw new AssertionError("trying to use a destroyed object");
            }
            return native_loadLargeRawConfig(this.nativeRef, str, str2, bArr);
        }

        @Override // com.tencent.freesia.UnitedConfigBridge
        public byte[] loadRawConfig(String str, String str2, byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (byte[]) iPatchRedirector.redirect((short) 13, this, str, str2, bArr);
            }
            if (!$assertionsDisabled && this.destroyed.get()) {
                throw new AssertionError("trying to use a destroyed object");
            }
            return native_loadRawConfig(this.nativeRef, str, str2, bArr);
        }

        @Override // com.tencent.freesia.UnitedConfigBridge
        public void onAppForeground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
                iPatchRedirector.redirect((short) 28, (Object) this);
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_onAppForeground(this.nativeRef);
            }
        }

        @Override // com.tencent.freesia.UnitedConfigBridge
        public void removeLocal(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                iPatchRedirector.redirect((short) 22, (Object) this, (Object) str, (Object) str2);
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_removeLocal(this.nativeRef, str, str2);
            }
        }

        @Override // com.tencent.freesia.UnitedConfigBridge
        public void setEnv(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, z16);
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_setEnv(this.nativeRef, z16);
            }
        }

        @Override // com.tencent.freesia.UnitedConfigBridge
        public void setIncFetch(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
                iPatchRedirector.redirect((short) 29, (Object) this, z16);
            } else {
                if (!$assertionsDisabled && this.destroyed.get()) {
                    throw new AssertionError("trying to use a destroyed object");
                }
                native_setIncFetch(this.nativeRef, z16);
            }
        }
    }

    void clearInvalidData();

    void evictCache();

    void fetchAll(@NonNull String str, boolean z16);

    void fetchConfig(@NonNull String str, @NonNull ArrayList<String> arrayList, boolean z16);

    void fetchNoLogin(boolean z16);

    void fetchSwitch(@NonNull String str, @NonNull ArrayList<String> arrayList, boolean z16);

    @NonNull
    String getConfigKey(@NonNull String str, @NonNull String str2, boolean z16);

    int getConfigVersion(@NonNull String str, @NonNull String str2);

    @NonNull
    ArrayList<String> getGroups(@NonNull String str, @NonNull String str2);

    @NonNull
    String getResourcePath(@NonNull String str, @NonNull String str2);

    int getUpdateInterval();

    boolean isAccountIsolate();

    boolean isCdn(@NonNull String str, @NonNull String str2);

    boolean isConfigHasCache(@NonNull String str, @NonNull String str2);

    boolean isFetchMute(long j3);

    boolean isIncFetchEnable(@NonNull String str);

    boolean isSwitchOn(@NonNull String str, @NonNull String str2, boolean z16);

    @Nullable
    IConfigData loadConfig(@NonNull String str, @NonNull String str2);

    @Nullable
    IConfigData loadConfigCache(@NonNull String str, @NonNull String str2);

    @Nullable
    IConfigData loadLargeConfig(@NonNull String str, @NonNull String str2);

    @NonNull
    byte[] loadLargeRawConfig(@NonNull String str, @NonNull String str2, @NonNull byte[] bArr);

    @NonNull
    byte[] loadRawConfig(@NonNull String str, @NonNull String str2, @NonNull byte[] bArr);

    void onAppForeground();

    void removeLocal(@NonNull String str, @NonNull String str2);

    void setEnv(boolean z16);

    void setIncFetch(boolean z16);
}
