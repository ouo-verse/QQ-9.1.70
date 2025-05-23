package com.tencent.mobileqq.activity.photo.album.querymedia;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.weiyun.transmission.db.JobDbManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class ICursor {
    static IPatchRedirector $redirector_ = null;
    protected static final String[] BASE_COLUMS;
    private static final int INDEX_DATA_PATH = 1;
    private static final int INDEX_DATE_ADDED = 3;
    private static final int INDEX_DATE_MODIFIED = 4;
    private static final int INDEX_HEIGHT;
    private static final int INDEX_ID = 0;
    private static final int INDEX_MIME_TYPE = 2;
    private static final int INDEX_SIZE = 5;
    private static final int INDEX_WIDTH;
    public static final String ORDER_BY_DATE_MODIFIED = "date_modified DESC, date_added DESC";
    protected static final int SUB_START_INDEX;
    protected static final String[] WIDTH_HEIGHT_COLUMS;
    String mAlbumId;
    protected ArrayList<String> mColums;
    protected Cursor mCursor;
    FilterListener mListener;
    protected String mSelector;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface FilterListener {
        boolean needMediaInfo(LocalMediaInfo localMediaInfo);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27944);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        String[] strArr = {"_id", "_data", JobDbManager.COL_UP_MIME_TYPE, "date_added", "date_modified", "_size"};
        BASE_COLUMS = strArr;
        String[] strArr2 = {"width", "height"};
        WIDTH_HEIGHT_COLUMS = strArr2;
        SUB_START_INDEX = strArr.length + strArr2.length;
        INDEX_WIDTH = 6;
        INDEX_HEIGHT = 7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ICursor(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) str);
            return;
        }
        this.mSelector = "";
        this.mAlbumId = str;
        if (str != null && !str.equals("") && !str.equals(QAlbumCustomAlbumConstants.RECENT_ALBUM_ID) && !str.equals(QAlbumCustomAlbumConstants.VIDEO_ALBUM_ID)) {
            this.mSelector = "bucket_id='" + str + "'";
        }
        init();
        try {
            this.mCursor = createCursor(context.getApplicationContext());
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("QQAlbum", 2, "createCursor error:" + e16.getMessage());
            }
            this.mCursor = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void close() {
        Cursor cursor = this.mCursor;
        if (cursor != null && !cursor.isClosed()) {
            this.mCursor.close();
        }
    }

    abstract Cursor createCursor(Context context);

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCount() {
        Cursor cursor = this.mCursor;
        if (cursor != null && !cursor.isClosed()) {
            return this.mCursor.getCount();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        this.mColums = arrayList;
        arrayList.addAll(Arrays.asList(BASE_COLUMS));
        this.mColums.addAll(Arrays.asList(WIDTH_HEIGHT_COLUMS));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LocalMediaInfo makeMediaInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LocalMediaInfo) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        Cursor cursor = this.mCursor;
        if (cursor != null && !cursor.isClosed()) {
            localMediaInfo._id = this.mCursor.getLong(0);
            localMediaInfo.path = this.mCursor.getString(1);
            localMediaInfo.mMimeType = this.mCursor.getString(2);
            localMediaInfo.addedDate = this.mCursor.getLong(3);
            localMediaInfo.modifiedDate = this.mCursor.getLong(4);
            localMediaInfo.fileSize = this.mCursor.getLong(5);
            localMediaInfo.mediaWidth = this.mCursor.getInt(INDEX_WIDTH);
            localMediaInfo.mediaHeight = this.mCursor.getInt(INDEX_HEIGHT);
        }
        return localMediaInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean moveToPosition(int i3) {
        Cursor cursor = this.mCursor;
        if (cursor != null && !cursor.isClosed()) {
            return this.mCursor.moveToPosition(i3);
        }
        return false;
    }

    public boolean needMedia(LocalMediaInfo localMediaInfo) {
        FilterListener filterListener;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) localMediaInfo)).booleanValue();
        }
        if (localMediaInfo == null) {
            return false;
        }
        boolean needMediaInfo = needMediaInfo(localMediaInfo);
        if (needMediaInfo && (filterListener = this.mListener) != null) {
            return filterListener.needMediaInfo(localMediaInfo);
        }
        return needMediaInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean needMediaInfo(LocalMediaInfo localMediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) localMediaInfo)).booleanValue();
        }
        String str = localMediaInfo.path;
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            return true;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("file not exists:");
            if (str == null) {
                str = "null";
            }
            sb5.append(str);
            QLog.i("QQAlbum", 2, sb5.toString());
            return false;
        }
        return false;
    }

    public void setListener(FilterListener filterListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) filterListener);
        } else {
            this.mListener = filterListener;
        }
    }
}
