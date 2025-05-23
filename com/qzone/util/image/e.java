package com.qzone.util.image;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.weiyun.transmission.db.JobDbManager;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.model.GpsInfo4LocalImage;
import cooperation.qzone.util.RecentPhotoManger;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f59820a = {"DISTINCT _data", "latitude", "longitude", JobDbManager.COL_UP_MIME_TYPE, "_size", "_id"};

    /* renamed from: b, reason: collision with root package name */
    private static String[] f59821b = {"_id", "_data", "duration", "date_added", "date_modified", JobDbManager.COL_UP_MIME_TYPE, "_size", "width", "height"};

    private static long a() {
        return LocalMultiProcConfig.getLong("MediaStoreImgUtil.photo_camera_take_lasttime", 0L);
    }

    public static List<ImageInfo> b(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        long max = Math.max(a(), currentTimeMillis - 60000);
        if (context != null) {
            return d(context, 20480, 0L, max, currentTimeMillis, 2);
        }
        return null;
    }

    private static Cursor c(Context context, int i3, long j3, long j16) {
        try {
            return ContactsMonitor.query(context.getContentResolver(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, f59820a, "_size>=" + i3 + " and date_modified>=" + (j3 / 1000) + " and date_modified <= " + (j16 / 1000), null, "date_modified DESC");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void e(long j3) {
        LocalMultiProcConfig.putLong("MediaStoreImgUtil.photo_camera_take_lasttime", j3);
    }

    public static ArrayList<ImageInfo> d(Context context, int i3, long j3, long j16, long j17, int i16) {
        ArrayList<ImageInfo> arrayList;
        Cursor c16;
        int i17;
        int i18;
        int i19;
        Cursor cursor = null;
        ArrayList<ImageInfo> arrayList2 = null;
        cursor = null;
        try {
            try {
                c16 = c(context, i3, j16, j17);
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                try {
                    int count = c16.getCount();
                    if (count > 0) {
                        arrayList = new ArrayList<>(count);
                        try {
                            int columnIndexOrThrow = c16.getColumnIndexOrThrow("_data");
                            int columnIndexOrThrow2 = c16.getColumnIndexOrThrow("latitude");
                            int columnIndexOrThrow3 = c16.getColumnIndexOrThrow("longitude");
                            int columnIndexOrThrow4 = c16.getColumnIndexOrThrow("_id");
                            int columnIndexOrThrow5 = c16.getColumnIndexOrThrow(JobDbManager.COL_UP_MIME_TYPE);
                            int columnIndexOrThrow6 = c16.getColumnIndexOrThrow("_size");
                            List arrayList3 = new ArrayList();
                            if (i16 == 0) {
                                arrayList3 = RecentPhotoManger.getRecentPhotoBlackListPath(RecentPhotoManger.KEY_BANNER_RECENT_PHOTO_BLACKLIST);
                            } else if (i16 == 1) {
                                arrayList3 = RecentPhotoManger.getRecentPhotoBlackListPath(RecentPhotoManger.KEY_PERSONAL_ALBUM_RECENT_PHOTO_BLACKLIST);
                            } else if (i16 == 2) {
                                arrayList3 = RecentPhotoManger.getRecentPhotoBlackListPath(RecentPhotoManger.KEY_SHUOSHUO_RECENT_PHOTO_BLACKLIST);
                            }
                            long currentTimeMillis = System.currentTimeMillis();
                            while (c16.moveToNext()) {
                                String string = c16.getString(columnIndexOrThrow);
                                float f16 = c16.getFloat(columnIndexOrThrow2);
                                float f17 = c16.getFloat(columnIndexOrThrow3);
                                int i26 = c16.getInt(columnIndexOrThrow4);
                                String string2 = c16.getString(columnIndexOrThrow5);
                                long j18 = c16.getLong(columnIndexOrThrow6);
                                if (j3 != 0) {
                                    i17 = columnIndexOrThrow;
                                    if ("image/gif".equals(string2) && j18 >= j3) {
                                        columnIndexOrThrow = i17;
                                    }
                                } else {
                                    i17 = columnIndexOrThrow;
                                }
                                if (string != null) {
                                    ImageInfo create = ImageInfo.create(string);
                                    if (create != null) {
                                        i18 = columnIndexOrThrow3;
                                        i19 = columnIndexOrThrow4;
                                        if (create.mModifiedDate <= currentTimeMillis && !arrayList3.contains(string)) {
                                            if (f16 != 0.0f && f17 != 0.0f) {
                                                create.mGpsInfo = new GpsInfo4LocalImage(f16, f17);
                                            }
                                            if (i26 != 0) {
                                                create.photoId = i26;
                                            }
                                            create.mimeType = string2;
                                            arrayList.add(create);
                                        }
                                    } else {
                                        columnIndexOrThrow = i17;
                                    }
                                } else {
                                    i18 = columnIndexOrThrow3;
                                    i19 = columnIndexOrThrow4;
                                }
                                columnIndexOrThrow = i17;
                                columnIndexOrThrow3 = i18;
                                columnIndexOrThrow4 = i19;
                            }
                            arrayList2 = arrayList;
                        } catch (Exception e16) {
                            e = e16;
                            cursor = c16;
                            e.printStackTrace();
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e17) {
                                    e17.printStackTrace();
                                }
                            }
                            return arrayList;
                        }
                    }
                    try {
                        c16.close();
                        return arrayList2;
                    } catch (Exception e18) {
                        e18.printStackTrace();
                        return arrayList2;
                    }
                } catch (Exception e19) {
                    e = e19;
                    arrayList = null;
                }
            } catch (Throwable th6) {
                th = th6;
                cursor = c16;
                Throwable th7 = th;
                if (cursor != null) {
                    try {
                        cursor.close();
                        throw th7;
                    } catch (Exception e26) {
                        e26.printStackTrace();
                        throw th7;
                    }
                }
                throw th7;
            }
        } catch (Exception e27) {
            e = e27;
            arrayList = null;
        }
    }
}
