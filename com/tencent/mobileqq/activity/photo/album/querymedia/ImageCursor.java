package com.tencent.mobileqq.activity.photo.album.querymedia;

import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.album.QAlbumBaseUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ImageCursor extends ICursor {
    static IPatchRedirector $redirector_;
    private static final String[] IMAGE_COLUMS;
    private static final int INDEX_LATITUDE;
    private static final int INDEX_LONGITUDE;
    private static final int INDEX_ORIENTATION;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27951);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        IMAGE_COLUMS = new String[]{"orientation", "latitude", "longitude"};
        int i3 = ICursor.SUB_START_INDEX;
        INDEX_ORIENTATION = i3;
        INDEX_LATITUDE = i3 + 1;
        INDEX_LONGITUDE = i3 + 2;
    }

    public ImageCursor(Context context, String str) {
        super(context, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) str);
        }
    }

    private void updateMimeType(LocalMediaInfo localMediaInfo) {
        if ("*/*".equals(localMediaInfo.mMimeType) || "image/*".equals(localMediaInfo.mMimeType)) {
            if (!localMediaInfo.path.contains(".jpg") && !localMediaInfo.path.contains(".jpeg")) {
                if (localMediaInfo.path.contains(QzoneEmotionUtils.SIGN_ICON_URL_END)) {
                    localMediaInfo.mMimeType = "image/gif";
                    return;
                } else if (localMediaInfo.path.contains(".bmp")) {
                    localMediaInfo.mMimeType = MimeHelper.IMAGE_BMP;
                    return;
                } else {
                    if (localMediaInfo.path.contains(".png")) {
                        localMediaInfo.mMimeType = "image/png";
                        return;
                    }
                    return;
                }
            }
            localMediaInfo.mMimeType = "image/jpeg";
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.querymedia.ICursor
    Cursor createCursor(Context context) {
        return ContactsMonitor.query(context.getContentResolver(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, (String[]) this.mColums.toArray(new String[0]), this.mSelector, null, ICursor.ORDER_BY_DATE_MODIFIED);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.photo.album.querymedia.ICursor
    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            super.init();
            this.mColums.addAll(Arrays.asList(IMAGE_COLUMS));
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
        Cursor cursor = this.mCursor;
        if (cursor != null && !cursor.isClosed()) {
            makeMediaInfo.mMediaType = 0;
            makeMediaInfo.orientation = this.mCursor.getInt(INDEX_ORIENTATION);
            makeMediaInfo.latitude = this.mCursor.getInt(INDEX_LATITUDE);
            makeMediaInfo.longitude = this.mCursor.getInt(INDEX_LONGITUDE);
        }
        updateMimeType(makeMediaInfo);
        if (makeMediaInfo.mediaWidth <= 0 || makeMediaInfo.mediaHeight <= 0) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            int[] iArr = new int[2];
            QAlbumBaseUtil.getWHByPath(makeMediaInfo.path, options, iArr);
            int i3 = iArr[0];
            makeMediaInfo.mediaWidth = i3;
            int i16 = iArr[1];
            makeMediaInfo.mediaHeight = i16;
            if ((i3 <= 0 || i16 <= 0) && QLog.isColorLevel()) {
                QLog.i("QQAlbum", 2, "image no size " + makeMediaInfo.path);
            }
        }
        return makeMediaInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.photo.album.querymedia.ICursor
    public boolean needMediaInfo(LocalMediaInfo localMediaInfo) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) localMediaInfo)).booleanValue();
        }
        if (super.needMediaInfo(localMediaInfo) && (str = localMediaInfo.mMimeType) != null) {
            return str.contains("image");
        }
        return false;
    }
}
