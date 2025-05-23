package com.tencent.aelight.camera.ae.album.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.aelight.camera.ae.album.fragment.AEAbstractAlbumListFragment;
import com.tencent.aelight.camera.ae.album.logic.a;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.MediaScannerInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.album.QAlbumBaseUtil;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import com.tencent.weiyun.transmission.db.JobDbManager;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEAlbumListAdapter extends BaseAdapter {
    public static final ColorDrawable F = new ColorDrawable(-2141891243);
    static final String[] G = {"bucket_id", "bucket_display_name", "MAX(_id) as _id", "date_modified", "_data", "orientation", JobDbManager.COL_UP_MIME_TYPE, "COUNT(_data) as count"};
    static final String H = "_size>0 and ( _size < " + QAlbumBaseUtil.CONFIG_LIMIT_MAX_IMAGE_FILE_SIZE + " )  and (width>= 240 or width IS NULL) and (height>= 240 or height IS NULL )  and height  * 1.0 / width>= 0.45 and height  * 1.0 / width<= 2.2 and (" + JobDbManager.COL_UP_MIME_TYPE + "='image/jpeg' or (" + JobDbManager.COL_UP_MIME_TYPE + "='*/*' and " + InputMethodUtil.SOUGOU_URI_DISPLAYNAME + " LIKE'%.jpg%' )  or (" + JobDbManager.COL_UP_MIME_TYPE + "='*/*' and " + InputMethodUtil.SOUGOU_URI_DISPLAYNAME + " LIKE'%.jpeg%' )  or (" + JobDbManager.COL_UP_MIME_TYPE + "='*/*' and " + InputMethodUtil.SOUGOU_URI_DISPLAYNAME + " LIKE'%.bmp%' )  or (" + JobDbManager.COL_UP_MIME_TYPE + "='*/*' and " + InputMethodUtil.SOUGOU_URI_DISPLAYNAME + " LIKE'%.png%' )  or " + JobDbManager.COL_UP_MIME_TYPE + " LIKE'%bmp%' or " + JobDbManager.COL_UP_MIME_TYPE + " LIKE'%" + MimeHelper.IMAGE_SUBTYPE_BITMAP + "%' or " + JobDbManager.COL_UP_MIME_TYPE + "='image/png'";
    static String[] I = {"_id", "_data", JobDbManager.COL_UP_MIME_TYPE, "date_modified", "orientation", "_size", "width"};
    static final String[] J = {"_id", "_data", "duration", "date_modified", JobDbManager.COL_UP_MIME_TYPE, "_size"};
    static final String[] K = {"bucket_id", "bucket_display_name", "MAX(_id) as _id", "date_modified", "_data", JobDbManager.COL_UP_MIME_TYPE, "COUNT(_data) as count"};
    public Drawable.ConstantState C;

    /* renamed from: d, reason: collision with root package name */
    a.InterfaceC0532a f62004d;

    /* renamed from: e, reason: collision with root package name */
    public Resources f62005e;

    /* renamed from: f, reason: collision with root package name */
    public int f62006f;

    /* renamed from: h, reason: collision with root package name */
    public int f62007h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f62008i;

    /* renamed from: m, reason: collision with root package name */
    List<QQAlbumInfo> f62009m = new ArrayList();
    Handler D = new Handler();
    private boolean E = false;

    public AEAlbumListAdapter(AEAbstractAlbumListFragment aEAbstractAlbumListFragment) {
        this.f62004d = aEAbstractAlbumListFragment.f62014e.f62118d;
        Resources resources = aEAbstractAlbumListFragment.getResources();
        this.f62005e = resources;
        this.C = resources.getDrawable(R.drawable.common_blue_bottom_dialog_checked_icon).getConstantState();
        int dimensionPixelSize = this.f62005e.getDimensionPixelSize(R.dimen.f158292cc);
        this.f62006f = dimensionPixelSize;
        this.f62007h = dimensionPixelSize;
    }

    protected void a(QQAlbumInfo qQAlbumInfo) {
        throw null;
    }

    void b(QQAlbumInfo qQAlbumInfo) {
        List<QQAlbumInfo> list = this.f62009m;
        if (list == null) {
            return;
        }
        if (list.isEmpty()) {
            this.f62009m.add(qQAlbumInfo);
        } else if (this.f62009m.get(0).f203112id.equals(QAlbumCustomAlbumConstants.RECENT_ALBUM_ID)) {
            this.f62009m.set(0, qQAlbumInfo);
        }
        a(qQAlbumInfo);
        notifyDataSetChanged();
    }

    void c(QQAlbumInfo qQAlbumInfo) {
        List<QQAlbumInfo> list = this.f62009m;
        if (list == null) {
            return;
        }
        if (list.size() < 2) {
            this.f62009m.add(qQAlbumInfo);
        } else {
            boolean z16 = false;
            int i3 = 0;
            while (true) {
                if (i3 >= this.f62009m.size()) {
                    break;
                }
                if (this.f62009m.get(i3).f203112id.equals(QAlbumCustomAlbumConstants.VIDEO_ALBUM_ID)) {
                    z16 = true;
                    break;
                }
                i3++;
            }
            if (z16) {
                if (qQAlbumInfo.mMediaFileCount > 0) {
                    this.f62009m.set(i3, qQAlbumInfo);
                } else {
                    this.f62009m.remove(i3);
                }
            } else if (qQAlbumInfo.mMediaFileCount > 0) {
                this.f62009m.add(1, qQAlbumInfo);
            }
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public QQAlbumInfo getItem(int i3) {
        return this.f62009m.get(i3);
    }

    public void g(final List<QQAlbumInfo> list) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            setData(list);
        } else {
            this.D.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.album.adapter.AEAlbumListAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    AEAlbumListAdapter.this.setData(list);
                }
            });
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f62009m.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        return QAlbumUtil.getMediaType(this.f62009m.get(i3).mCoverInfo);
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2 = this.f62004d.getView(i3, view, viewGroup);
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return QAlbumUtil.MEDIA_TYPE_MAPS.size();
    }

    public void h(final QQAlbumInfo qQAlbumInfo) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b(qQAlbumInfo);
        } else {
            this.D.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.album.adapter.AEAlbumListAdapter.2
                @Override // java.lang.Runnable
                public void run() {
                    AEAlbumListAdapter.this.b(qQAlbumInfo);
                }
            });
        }
    }

    public void i(final QQAlbumInfo qQAlbumInfo) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            c(qQAlbumInfo);
        } else {
            this.D.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.album.adapter.AEAlbumListAdapter.3
                @Override // java.lang.Runnable
                public void run() {
                    AEAlbumListAdapter.this.c(qQAlbumInfo);
                }
            });
        }
    }

    public void j() {
        this.f62004d.b(-1);
    }

    public QQAlbumInfo k(Context context) {
        QQAlbumInfo qQAlbumInfo = new QQAlbumInfo();
        qQAlbumInfo.f203112id = QAlbumCustomAlbumConstants.VIDEO_ALBUM_ID;
        qQAlbumInfo.name = QAlbumCustomAlbumConstants.VIDEO_ALBUM_NAME;
        qQAlbumInfo.mMediaFileCount = 0;
        Cursor cursor = null;
        cursor = null;
        try {
            try {
                Cursor query = ContactsMonitor.query(context.getContentResolver(), MediaStore.Video.Media.EXTERNAL_CONTENT_URI, J, "_size>0) GROUP BY (_data", null, "_id DESC");
                try {
                    MediaFileFilter filter = MediaFileFilter.getFilter(2);
                    List<LocalMediaInfo> e16 = filter != null ? e(query, -1, filter) : null;
                    ArrayList<MediaScannerInfo> mediaScannerInfos = MediaScanner.getInstance(BaseApplication.getContext()).getMediaScannerInfos(false, -1);
                    if (e16 != null && !e16.isEmpty()) {
                        qQAlbumInfo.mMediaFileCount += e16.size();
                        qQAlbumInfo.mCoverInfo = e16.get(0);
                    }
                    if (mediaScannerInfos != null && !mediaScannerInfos.isEmpty()) {
                        qQAlbumInfo.mMediaFileCount += mediaScannerInfos.size();
                        MediaScannerInfo mediaScannerInfo = mediaScannerInfos.get(0);
                        LocalMediaInfo localMediaInfo = qQAlbumInfo.mCoverInfo;
                        if (localMediaInfo == null || localMediaInfo.modifiedDate < mediaScannerInfo.modifiedDate) {
                            LocalMediaInfo localMediaInfo2 = new LocalMediaInfo();
                            qQAlbumInfo.mCoverInfo = localMediaInfo2;
                            localMediaInfo2._id = mediaScannerInfo.f183982id;
                            localMediaInfo2.mDuration = mediaScannerInfo.duration;
                            localMediaInfo2.fileSize = mediaScannerInfo.fileSize;
                            localMediaInfo2.path = mediaScannerInfo.path;
                            localMediaInfo2.modifiedDate = mediaScannerInfo.modifiedDate;
                            localMediaInfo2.mMimeType = mediaScannerInfo.mimeType;
                            localMediaInfo2.isSystemMeidaStore = false;
                        }
                    }
                    if (query != null) {
                        query.close();
                    }
                } catch (Exception e17) {
                    e = e17;
                    cursor = query;
                    if (QLog.isColorLevel()) {
                        QLog.e("AlbumListAdapter", 2, e.getMessage(), e);
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return qQAlbumInfo;
                } catch (Throwable th5) {
                    th = th5;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e18) {
            e = e18;
        }
        return qQAlbumInfo;
    }

    void setData(List<QQAlbumInfo> list) {
        this.f62009m.clear();
        if (list != null) {
            this.f62009m.addAll(list);
        }
        notifyDataSetChanged();
    }

    QQAlbumInfo m(Context context, int i3, int i16, MediaFileFilter mediaFileFilter, int i17, boolean z16, ArrayList<String> arrayList) {
        List<LocalMediaInfo> queryRecentVideos;
        QQAlbumInfo qQAlbumInfo = new QQAlbumInfo();
        qQAlbumInfo.f203112id = QAlbumCustomAlbumConstants.RECENT_ALBUM_ID;
        qQAlbumInfo.name = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
        List<LocalMediaInfo> d16 = this.f62004d.d(context, i3, i16, mediaFileFilter, i17, z16, arrayList);
        if (d16 != null && d16.size() > 0) {
            qQAlbumInfo.mCoverInfo = d16.get(0);
            qQAlbumInfo.mMediaFileCount = d16.size();
        }
        if (qQAlbumInfo.mMediaFileCount >= i16 || (queryRecentVideos = QAlbumBaseUtil.queryRecentVideos(context, 0, i16, mediaFileFilter, -1L)) == null) {
            return qQAlbumInfo;
        }
        if (qQAlbumInfo.mMediaFileCount == 0 && queryRecentVideos.size() > 0) {
            qQAlbumInfo.mCoverInfo = queryRecentVideos.get(0);
        }
        if (qQAlbumInfo.mMediaFileCount + queryRecentVideos.size() <= i16) {
            qQAlbumInfo.mMediaFileCount += queryRecentVideos.size();
        } else {
            qQAlbumInfo.mMediaFileCount = i16;
        }
        return qQAlbumInfo;
    }

    QQAlbumInfo o(Context context, int i3, int i16, MediaFileFilter mediaFileFilter) {
        Uri uri;
        if (i16 > 0) {
            QQAlbumInfo qQAlbumInfo = new QQAlbumInfo();
            qQAlbumInfo.f203112id = QAlbumCustomAlbumConstants.RECENT_ALBUM_ID;
            qQAlbumInfo.name = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
            Cursor cursor = null;
            List<LocalMediaInfo> e16 = null;
            cursor = null;
            try {
                try {
                    if (i16 > 0) {
                        Uri.Builder buildUpon = MediaStore.Video.Media.EXTERNAL_CONTENT_URI.buildUpon();
                        buildUpon.appendQueryParameter("limit", String.valueOf(i16));
                        uri = buildUpon.build();
                    } else {
                        uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    }
                    Cursor query = ContactsMonitor.query(context.getContentResolver(), uri, J, "_size>0) GROUP BY (_data", null, "_id DESC");
                    if (mediaFileFilter != null) {
                        try {
                            e16 = e(query, i16, mediaFileFilter);
                        } catch (Exception e17) {
                            cursor = query;
                            e = e17;
                            if (QLog.isColorLevel()) {
                                QLog.e("AlbumListAdapter", 2, e.getMessage(), e);
                            }
                            if (cursor != null) {
                                cursor.close();
                            }
                            return qQAlbumInfo;
                        } catch (Throwable th5) {
                            cursor = query;
                            th = th5;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    }
                    if (e16 != null && !e16.isEmpty()) {
                        int size = e16.size();
                        qQAlbumInfo.mMediaFileCount = size;
                        if (size > 0) {
                            qQAlbumInfo.mCoverInfo = e16.get(0);
                        }
                    }
                    if (query != null) {
                        query.close();
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Exception e18) {
                e = e18;
            }
            return qQAlbumInfo;
        }
        throw new IllegalArgumentException("limit must be great than 0");
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00f6 A[Catch: all -> 0x0106, TRY_LEAVE, TryCatch #2 {all -> 0x0106, blocks: (B:9:0x0024, B:44:0x00f0, B:46:0x00f6), top: B:8:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<QQAlbumInfo> l(Context context, int i3) {
        LinkedList linkedList;
        Uri build;
        Cursor query;
        Cursor cursor = null;
        try {
            if (i3 < 0) {
                build = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else {
                Uri.Builder buildUpon = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.buildUpon();
                buildUpon.appendQueryParameter("limit", String.valueOf(i3));
                build = buildUpon.build();
            }
        } catch (Exception e16) {
            e = e16;
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            try {
                query = ContactsMonitor.query(context.getContentResolver(), build, G, this.f62004d.a(), null, "date_modified DESC");
            } catch (Exception e17) {
                e = e17;
                linkedList = null;
                if (QLog.isColorLevel()) {
                }
                if (cursor != null) {
                }
                return linkedList;
            }
            if (query == null) {
                if (query != null) {
                    query.close();
                }
                return null;
            }
            try {
                try {
                    linkedList = new LinkedList();
                } catch (Throwable th6) {
                    th = th6;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Exception e18) {
                e = e18;
                linkedList = null;
            }
            try {
                int columnIndex = query.getColumnIndex("bucket_id");
                int columnIndex2 = query.getColumnIndex("bucket_display_name");
                int columnIndex3 = query.getColumnIndex("_data");
                int columnIndex4 = query.getColumnIndex("date_modified");
                int columnIndex5 = query.getColumnIndex("_id");
                int columnIndex6 = query.getColumnIndex("orientation");
                int columnIndex7 = query.getColumnIndex(JobDbManager.COL_UP_MIME_TYPE);
                int columnIndex8 = query.getColumnIndex("count");
                while (query.moveToNext()) {
                    String string = query.getString(columnIndex);
                    String string2 = query.getString(columnIndex2);
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                        String string3 = query.getString(columnIndex3);
                        long j3 = query.getLong(columnIndex4);
                        int i16 = columnIndex;
                        QQAlbumInfo qQAlbumInfo = new QQAlbumInfo();
                        qQAlbumInfo.name = string2;
                        qQAlbumInfo.f203112id = string;
                        qQAlbumInfo.coverDate = j3;
                        LocalMediaInfo localMediaInfo = qQAlbumInfo.mCoverInfo;
                        localMediaInfo.path = string3;
                        localMediaInfo._id = query.getLong(columnIndex5);
                        localMediaInfo.modifiedDate = j3;
                        localMediaInfo.orientation = query.getInt(columnIndex6);
                        String string4 = query.getString(columnIndex7);
                        localMediaInfo.mMimeType = string4;
                        if ("*/*".equals(string4)) {
                            localMediaInfo.mMimeType = "image";
                        }
                        qQAlbumInfo.mMediaFileCount = query.getInt(columnIndex8);
                        linkedList.add(qQAlbumInfo);
                        columnIndex = i16;
                    }
                }
                query.close();
            } catch (Exception e19) {
                e = e19;
                cursor = query;
                if (QLog.isColorLevel()) {
                    QLog.d("SelectPhotoTrace", 2, "queryImageBuckets(), query failed", e);
                }
                if (cursor != null) {
                    cursor.close();
                }
                return linkedList;
            }
            return linkedList;
        } catch (Throwable th7) {
            th = th7;
        }
    }

    public List<QQAlbumInfo> p(Context context, int i3, MediaFileFilter mediaFileFilter) {
        LinkedList linkedList;
        Uri build;
        Cursor query;
        Cursor cursor = null;
        try {
            try {
                if (i3 < 0) {
                    build = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else {
                    Uri.Builder buildUpon = MediaStore.Video.Media.EXTERNAL_CONTENT_URI.buildUpon();
                    buildUpon.appendQueryParameter("limit", String.valueOf(i3));
                    build = buildUpon.build();
                }
                query = ContactsMonitor.query(context.getContentResolver(), build, K, "_size>0 and mime_type='video/mp4') GROUP BY (1", null, "date_modified DESC");
            } catch (Exception e16) {
                e = e16;
                linkedList = null;
            }
            if (query == null) {
                if (query != null) {
                    query.close();
                }
                return null;
            }
            try {
                try {
                    linkedList = new LinkedList();
                    try {
                        int columnIndex = query.getColumnIndex("bucket_id");
                        int columnIndex2 = query.getColumnIndex("_id");
                        int columnIndex3 = query.getColumnIndex("bucket_display_name");
                        int columnIndex4 = query.getColumnIndex("_data");
                        int columnIndex5 = query.getColumnIndex("date_modified");
                        int columnIndex6 = query.getColumnIndex(JobDbManager.COL_UP_MIME_TYPE);
                        int columnIndex7 = query.getColumnIndex("count");
                        while (query.moveToNext()) {
                            String string = query.getString(columnIndex);
                            String string2 = query.getString(columnIndex3);
                            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                                long j3 = query.getLong(columnIndex5);
                                QQAlbumInfo qQAlbumInfo = new QQAlbumInfo();
                                qQAlbumInfo.name = string2;
                                qQAlbumInfo.f203112id = string;
                                qQAlbumInfo.coverDate = j3;
                                LocalMediaInfo localMediaInfo = qQAlbumInfo.mCoverInfo;
                                localMediaInfo.path = query.getString(columnIndex4);
                                localMediaInfo._id = query.getLong(columnIndex2);
                                localMediaInfo.modifiedDate = j3;
                                localMediaInfo.mMimeType = query.getString(columnIndex6);
                                qQAlbumInfo.mMediaFileCount = query.getInt(columnIndex7);
                                linkedList.add(qQAlbumInfo);
                            }
                        }
                        query.close();
                    } catch (Exception e17) {
                        e = e17;
                        cursor = query;
                        if (QLog.isColorLevel()) {
                            QLog.d("SelectPhotoTrace", 2, "queryVideoBuckets(), query failed", e);
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        return linkedList;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Exception e18) {
                e = e18;
                linkedList = null;
            }
            return linkedList;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static boolean f(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.equalsIgnoreCase("camera") || lowerCase.equalsIgnoreCase("100media");
    }

    public QQAlbumInfo n(Context context, int i3, int i16, MediaFileFilter mediaFileFilter, int i17, boolean z16, ArrayList<String> arrayList) {
        if (mediaFileFilter == null) {
            return null;
        }
        if (mediaFileFilter.showImage()) {
            return m(context, i3, i16, mediaFileFilter, i17, z16, arrayList);
        }
        return o(context, i3, i16, mediaFileFilter);
    }

    List<LocalMediaInfo> e(Cursor cursor, int i3, MediaFileFilter mediaFileFilter) {
        int i16;
        int i17;
        if (cursor.getCount() <= 0) {
            return null;
        }
        int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_id");
        int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("_data");
        int columnIndexOrThrow3 = cursor.getColumnIndexOrThrow("date_modified");
        int columnIndexOrThrow4 = cursor.getColumnIndexOrThrow("duration");
        int columnIndexOrThrow5 = cursor.getColumnIndexOrThrow(JobDbManager.COL_UP_MIME_TYPE);
        int columnIndexOrThrow6 = cursor.getColumnIndexOrThrow("_size");
        ArrayList arrayList = new ArrayList();
        int i18 = 0;
        while (cursor.moveToNext()) {
            String string = cursor.getString(columnIndexOrThrow5);
            if (mediaFileFilter != null && mediaFileFilter.filter(string)) {
                if (QLog.isColorLevel()) {
                    QLog.i("AlbumListAdapter", 2, "Filter mime type:" + string);
                }
            } else {
                String string2 = cursor.getString(columnIndexOrThrow2);
                if (!TextUtils.isEmpty(string2) && new File(string2).exists()) {
                    long j3 = cursor.getLong(columnIndexOrThrow3);
                    LocalMediaInfo localMediaInfo = new LocalMediaInfo();
                    i16 = columnIndexOrThrow2;
                    i17 = columnIndexOrThrow3;
                    localMediaInfo._id = cursor.getLong(columnIndexOrThrow);
                    localMediaInfo.path = string2;
                    localMediaInfo.mMimeType = string;
                    localMediaInfo.modifiedDate = j3;
                    localMediaInfo.mDuration = cursor.getLong(columnIndexOrThrow4);
                    localMediaInfo.fileSize = cursor.getLong(columnIndexOrThrow6);
                    arrayList.add(localMediaInfo);
                    i18++;
                    if (i3 > 0 && i18 >= i3) {
                        break;
                    }
                    columnIndexOrThrow2 = i16;
                    columnIndexOrThrow3 = i17;
                }
            }
            i16 = columnIndexOrThrow2;
            i17 = columnIndexOrThrow3;
            columnIndexOrThrow2 = i16;
            columnIndexOrThrow3 = i17;
        }
        return arrayList;
    }
}
