package com.tencent.thumbplayer.core.drm;

import android.media.DeniedByServerException;
import android.media.MediaDrm;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import android.media.ResourceBusyException;
import android.media.UnsupportedSchemeException;
import android.os.Build;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.thumbplayer.core.drm.ITPMediaDrm;
import com.tencent.thumbplayer.core.utils.TPNativeLog;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RequiresApi(api = 18)
/* loaded from: classes26.dex */
public class TPDirectMediaDrm implements ITPMediaDrm {
    private static final String TAG = "TPDirectMediaDrm";
    private MediaDrm mMediaDrm;
    private ITPMediaDrm.OnEventListener mOnEventListener;
    private ITPMediaDrm.OnExpirationUpdateListener mOnExpirationUpdateListener;
    private ITPMediaDrm.OnKeyStatusChangeListener mOnKeyStatusChangeListener;
    private boolean mReleased;

    public TPDirectMediaDrm(@NonNull UUID uuid) throws UnsupportedSchemeException {
        this.mReleased = false;
        try {
            this.mMediaDrm = new MediaDrm(uuid);
        } catch (UnsupportedSchemeException e16) {
            throw e16;
        } catch (Throwable th5) {
            this.mReleased = true;
            TPNativeLog.printLog(0, TAG, "new MediaDrm failed, e:" + th5);
        }
        TPNativeLog.printLog(2, TAG, "TPDirectMediaDrm constructor");
    }

    @Override // com.tencent.thumbplayer.core.drm.ITPMediaDrm
    public synchronized void close() {
        if (this.mReleased) {
            return;
        }
        this.mMediaDrm.setOnEventListener(null);
        this.mOnEventListener = null;
        int i3 = Build.VERSION.SDK_INT;
        this.mMediaDrm.setOnExpirationUpdateListener((MediaDrm.OnExpirationUpdateListener) null, (Handler) null);
        this.mOnExpirationUpdateListener = null;
        this.mMediaDrm.setOnKeyStatusChangeListener((MediaDrm.OnKeyStatusChangeListener) null, (Handler) null);
        this.mOnKeyStatusChangeListener = null;
        try {
            if (i3 >= 28) {
                this.mMediaDrm.close();
            } else {
                this.mMediaDrm.release();
            }
        } catch (Throwable th5) {
            TPNativeLog.printLog(0, TAG, th5.toString());
        }
        this.mMediaDrm = null;
        this.mReleased = true;
    }

    @Override // com.tencent.thumbplayer.core.drm.ITPMediaDrm
    public synchronized void closeSession(@NonNull byte[] bArr) {
        if (this.mReleased) {
            return;
        }
        try {
            this.mMediaDrm.closeSession(bArr);
        } catch (Throwable th5) {
            TPNativeLog.printLog(0, TAG, th5.toString());
            close();
        }
    }

    @Override // com.tencent.thumbplayer.core.drm.ITPMediaDrm
    @NonNull
    public synchronized MediaDrm.KeyRequest getKeyRequest(@NonNull byte[] bArr, @Nullable byte[] bArr2, @Nullable String str, int i3, @Nullable HashMap<String, String> hashMap) throws NotProvisionedException, TPMediaDrmFatalException {
        if (!this.mReleased) {
            try {
            } catch (MediaDrmException e16) {
                throw e16;
            } catch (Throwable th5) {
                TPNativeLog.printLog(0, TAG, th5.toString());
                close();
                throw new TPMediaDrmFatalException(th5.getMessage());
            }
        } else {
            throw new TPMediaDrmFatalException("released");
        }
        return this.mMediaDrm.getKeyRequest(bArr, bArr2, str, i3, hashMap);
    }

    @Override // com.tencent.thumbplayer.core.drm.ITPMediaDrm
    @NonNull
    public synchronized String getPropertyString(@NonNull String str) {
        if (this.mReleased) {
            return "";
        }
        try {
            return this.mMediaDrm.getPropertyString(str);
        } catch (Throwable th5) {
            TPNativeLog.printLog(0, TAG, th5.toString());
            close();
            return "";
        }
    }

    @Override // com.tencent.thumbplayer.core.drm.ITPMediaDrm
    public synchronized MediaDrm.ProvisionRequest getProvisionRequest() throws TPMediaDrmFatalException {
        if (!this.mReleased) {
            try {
            } catch (Throwable th5) {
                TPNativeLog.printLog(0, TAG, th5.toString());
                close();
                throw new TPMediaDrmFatalException(th5.getMessage());
            }
        } else {
            throw new TPMediaDrmFatalException("released");
        }
        return this.mMediaDrm.getProvisionRequest();
    }

    @Override // com.tencent.thumbplayer.core.drm.ITPMediaDrm
    @NonNull
    public synchronized byte[] openSession() throws NotProvisionedException, ResourceBusyException, TPMediaDrmFatalException {
        if (!this.mReleased) {
            try {
                try {
                } catch (Throwable th5) {
                    TPNativeLog.printLog(0, TAG, th5.toString());
                    close();
                    throw new TPMediaDrmFatalException(th5.getMessage());
                }
            } catch (MediaDrmException e16) {
                throw e16;
            }
        } else {
            throw new TPMediaDrmFatalException("released");
        }
        return this.mMediaDrm.openSession();
    }

    @Override // com.tencent.thumbplayer.core.drm.ITPMediaDrm
    @Nullable
    public synchronized byte[] provideKeyResponse(@NonNull byte[] bArr, @NonNull byte[] bArr2) throws NotProvisionedException, DeniedByServerException, TPMediaDrmFatalException {
        if (!this.mReleased) {
            try {
                try {
                } catch (Throwable th5) {
                    TPNativeLog.printLog(0, TAG, th5.toString());
                    close();
                    throw new TPMediaDrmFatalException(th5.getMessage());
                }
            } catch (MediaDrmException e16) {
                throw e16;
            }
        } else {
            throw new TPMediaDrmFatalException("released");
        }
        return this.mMediaDrm.provideKeyResponse(bArr, bArr2);
    }

    @Override // com.tencent.thumbplayer.core.drm.ITPMediaDrm
    public synchronized void provideProvisionResponse(@NonNull byte[] bArr) throws DeniedByServerException {
        if (this.mReleased) {
            return;
        }
        try {
            try {
                this.mMediaDrm.provideProvisionResponse(bArr);
            } catch (MediaDrmException e16) {
                throw e16;
            }
        } catch (Throwable th5) {
            TPNativeLog.printLog(0, TAG, th5.toString());
            close();
        }
    }

    @Override // com.tencent.thumbplayer.core.drm.ITPMediaDrm
    @NonNull
    public synchronized HashMap<String, String> queryKeyStatus(@NonNull byte[] bArr) {
        if (this.mReleased) {
            return new HashMap<>();
        }
        try {
            return this.mMediaDrm.queryKeyStatus(bArr);
        } catch (Throwable th5) {
            TPNativeLog.printLog(0, TAG, th5.toString());
            close();
            return new HashMap<>();
        }
    }

    @Override // com.tencent.thumbplayer.core.drm.ITPMediaDrm
    public synchronized void removeKeys(@NonNull byte[] bArr) {
        if (this.mReleased) {
            return;
        }
        try {
            this.mMediaDrm.removeKeys(bArr);
        } catch (Throwable th5) {
            TPNativeLog.printLog(0, TAG, th5.toString());
            close();
        }
    }

    @Override // com.tencent.thumbplayer.core.drm.ITPMediaDrm
    public synchronized void restoreKeys(@NonNull byte[] bArr, @NonNull byte[] bArr2) {
        if (this.mReleased) {
            return;
        }
        try {
            this.mMediaDrm.restoreKeys(bArr, bArr2);
        } catch (Throwable th5) {
            TPNativeLog.printLog(0, TAG, th5.toString());
            close();
        }
    }

    @Override // com.tencent.thumbplayer.core.drm.ITPMediaDrm
    @RequiresApi(api = 23)
    public synchronized void setOnExpirationUpdateListener(@Nullable ITPMediaDrm.OnExpirationUpdateListener onExpirationUpdateListener, @Nullable Handler handler) {
        if (this.mReleased) {
            return;
        }
        this.mOnExpirationUpdateListener = onExpirationUpdateListener;
        this.mMediaDrm.setOnExpirationUpdateListener(new MediaDrm.OnExpirationUpdateListener() { // from class: com.tencent.thumbplayer.core.drm.TPDirectMediaDrm.2
            @Override // android.media.MediaDrm.OnExpirationUpdateListener
            public void onExpirationUpdate(@NonNull MediaDrm mediaDrm, @NonNull byte[] bArr, long j3) {
                ITPMediaDrm.OnExpirationUpdateListener onExpirationUpdateListener2 = TPDirectMediaDrm.this.mOnExpirationUpdateListener;
                if (onExpirationUpdateListener2 != null) {
                    onExpirationUpdateListener2.onExpirationUpdate(TPDirectMediaDrm.this, bArr, j3);
                }
            }
        }, handler);
    }

    @Override // com.tencent.thumbplayer.core.drm.ITPMediaDrm
    @RequiresApi(api = 23)
    public synchronized void setOnKeyStatusChangeListener(@Nullable ITPMediaDrm.OnKeyStatusChangeListener onKeyStatusChangeListener, @Nullable Handler handler) {
        if (this.mReleased) {
            return;
        }
        this.mOnKeyStatusChangeListener = onKeyStatusChangeListener;
        this.mMediaDrm.setOnKeyStatusChangeListener(new MediaDrm.OnKeyStatusChangeListener() { // from class: com.tencent.thumbplayer.core.drm.TPDirectMediaDrm.1
            @Override // android.media.MediaDrm.OnKeyStatusChangeListener
            public void onKeyStatusChange(@NonNull MediaDrm mediaDrm, @NonNull byte[] bArr, @NonNull List<MediaDrm.KeyStatus> list, boolean z16) {
                ITPMediaDrm.OnKeyStatusChangeListener onKeyStatusChangeListener2 = TPDirectMediaDrm.this.mOnKeyStatusChangeListener;
                if (onKeyStatusChangeListener2 != null) {
                    onKeyStatusChangeListener2.onKeyStatusChange(TPDirectMediaDrm.this, bArr, list, z16);
                }
            }
        }, handler);
    }

    @Override // com.tencent.thumbplayer.core.drm.ITPMediaDrm
    public synchronized void setPropertyString(@NonNull String str, @NonNull String str2) {
        if (this.mReleased) {
            return;
        }
        try {
            this.mMediaDrm.setPropertyString(str, str2);
        } catch (Throwable th5) {
            TPNativeLog.printLog(0, TAG, th5.toString());
            close();
        }
    }
}
