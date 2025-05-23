package com.tencent.mobileqq.activity.photo.album.querymedia;

import android.content.Context;
import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes10.dex */
public class VideoCursor extends ICursor {
    static IPatchRedirector $redirector_;
    private static final int INDEX_DURATION;
    private static final String[] VIDEO_COLUMS;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28013);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            VIDEO_COLUMS = new String[]{"duration"};
            INDEX_DURATION = ICursor.SUB_START_INDEX;
        }
    }

    public VideoCursor(Context context, String str) {
        super(context, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) str);
        }
    }

    private boolean checkVideoInfoData(LocalMediaInfo localMediaInfo) {
        if (!TextUtils.isEmpty(localMediaInfo.mMimeType) && localMediaInfo.mMimeType.contains("video/mp4") && (localMediaInfo.mDuration == 0 || localMediaInfo.mediaHeight <= 0 || localMediaInfo.mediaWidth <= 0)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.querymedia.ICursor
    Cursor createCursor(Context context) {
        return ContactsMonitor.query(context.getContentResolver(), MediaStore.Video.Media.EXTERNAL_CONTENT_URI, (String[]) this.mColums.toArray(new String[0]), this.mSelector, null, ICursor.ORDER_BY_DATE_MODIFIED);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void fixVideoInfo(LocalMediaInfo localMediaInfo) {
        MediaMetadataRetriever mediaMetadataRetriever;
        Exception e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) localMediaInfo);
            return;
        }
        if (localMediaInfo != null && localMediaInfo.mMediaType == 1 && checkVideoInfoData(localMediaInfo)) {
            MediaMetadataRetriever mediaMetadataRetriever2 = null;
            try {
                mediaMetadataRetriever = new MediaMetadataRetriever();
            } catch (Exception e17) {
                mediaMetadataRetriever = null;
                e16 = e17;
            } catch (Throwable th5) {
                th = th5;
                if (mediaMetadataRetriever2 != null) {
                }
                throw th;
            }
            try {
                try {
                    mediaMetadataRetriever.setDataSource(localMediaInfo.path);
                    if (localMediaInfo.mDuration == 0) {
                        localMediaInfo.mDuration = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
                    }
                    if (localMediaInfo.mediaHeight <= 0) {
                        localMediaInfo.mediaHeight = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                    }
                    if (localMediaInfo.mediaWidth <= 0) {
                        localMediaInfo.mediaWidth = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                    }
                } catch (Throwable th6) {
                    th = th6;
                    mediaMetadataRetriever2 = mediaMetadataRetriever;
                    if (mediaMetadataRetriever2 != null) {
                        mediaMetadataRetriever2.release();
                    }
                    throw th;
                }
            } catch (Exception e18) {
                e16 = e18;
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.i("QQAlbum", 2, "get mmr failed:" + localMediaInfo.path);
                }
                if (mediaMetadataRetriever == null) {
                    return;
                }
                mediaMetadataRetriever.release();
            }
            mediaMetadataRetriever.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.photo.album.querymedia.ICursor
    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            super.init();
            this.mColums.addAll(Arrays.asList(VIDEO_COLUMS));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.photo.album.querymedia.ICursor
    public LocalMediaInfo makeMediaInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LocalMediaInfo) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        LocalMediaInfo makeMediaInfo = super.makeMediaInfo();
        makeMediaInfo.mMediaType = 1;
        Cursor cursor = this.mCursor;
        if (cursor != null && !cursor.isClosed()) {
            makeMediaInfo.mDuration = this.mCursor.getInt(INDEX_DURATION);
        }
        fixVideoInfo(makeMediaInfo);
        return makeMediaInfo;
    }
}
