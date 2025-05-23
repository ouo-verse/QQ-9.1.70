package com.tencent.thumbplayer.core.drm;

import android.media.MediaDrmException;
import android.media.UnsupportedSchemeException;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.tencent.thumbplayer.core.drm.reuse.TPReuseMediaDrm;
import com.tencent.thumbplayer.core.utils.TPNativeLog;
import java.util.UUID;

@RequiresApi(api = 18)
/* loaded from: classes26.dex */
public final class TPMediaDrmPool {
    private static final String TAG = "TPMediaDrmManager";
    private static final TPMediaDrmPool sInstance = new TPMediaDrmPool();
    private boolean mIsMediaDrmReuse = false;

    TPMediaDrmPool() {
    }

    public static TPMediaDrmPool getInstance() {
        return sInstance;
    }

    @NonNull
    public ITPMediaDrm createTPDirectMediaDrm(@NonNull UUID uuid) throws UnsupportedSchemeException {
        return new TPDirectMediaDrm(uuid);
    }

    @NonNull
    public ITPMediaDrm createTPMediaDrm(@NonNull UUID uuid) throws UnsupportedSchemeException {
        if (this.mIsMediaDrmReuse) {
            try {
                return new TPReuseMediaDrm(uuid);
            } catch (MediaDrmException | TPMediaDrmFatalException e16) {
                TPNativeLog.printLog(0, TAG, "reset error:" + e16);
            }
        }
        return new TPDirectMediaDrm(uuid);
    }

    public void preload() {
        TPReuseMediaDrm.preloadAsync();
    }

    public void setMediaDrmReuseEnable(boolean z16) {
        this.mIsMediaDrmReuse = z16;
        if (z16) {
            preload();
        }
    }
}
