package androidx.media;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.media.MediaSessionManager;

/* compiled from: P */
@RequiresApi(21)
/* loaded from: classes.dex */
class MediaSessionManagerImplApi21 extends MediaSessionManagerImplBase {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MediaSessionManagerImplApi21(Context context) {
        super(context);
        this.mContext = context;
    }

    private boolean hasMediaControlPermission(@NonNull MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl) {
        if (getContext().checkPermission("android.permission.MEDIA_CONTENT_CONTROL", remoteUserInfoImpl.getPid(), remoteUserInfoImpl.getUid()) == 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.media.MediaSessionManagerImplBase, androidx.media.MediaSessionManager.MediaSessionManagerImpl
    public boolean isTrustedForMediaControl(@NonNull MediaSessionManager.RemoteUserInfoImpl remoteUserInfoImpl) {
        if (!hasMediaControlPermission(remoteUserInfoImpl) && !super.isTrustedForMediaControl(remoteUserInfoImpl)) {
            return false;
        }
        return true;
    }
}
