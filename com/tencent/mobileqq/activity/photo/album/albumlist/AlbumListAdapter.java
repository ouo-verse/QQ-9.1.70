package com.tencent.mobileqq.activity.photo.album.albumlist;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.album.QAlbumBaseUtil;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.albumlist.b;
import com.tencent.mobileqq.activity.photo.album.querymedia.MediaQueryHelper;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import com.tencent.weiyun.transmission.db.JobDbManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.slf4j.Logger;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AlbumListAdapter extends BaseAdapter {
    static IPatchRedirector $redirector_;
    static final ColorDrawable H;
    static final String[] I;
    static final String J;
    static final String[] K;
    static final String[] L;
    static String[] M;
    private List<QQAlbumInfo> C;
    private QQAlbumInfo D;
    private QQAlbumInfo E;
    private List<QQAlbumInfo> F;
    private boolean G;

    /* renamed from: d, reason: collision with root package name */
    b.InterfaceC7191b f184213d;

    /* renamed from: e, reason: collision with root package name */
    Resources f184214e;

    /* renamed from: f, reason: collision with root package name */
    public int f184215f;

    /* renamed from: h, reason: collision with root package name */
    public int f184216h;

    /* renamed from: i, reason: collision with root package name */
    Drawable.ConstantState f184217i;

    /* renamed from: m, reason: collision with root package name */
    Handler f184218m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13888);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
            return;
        }
        H = new ColorDrawable(-2141891243);
        I = new String[]{"bucket_id", "bucket_display_name", "_id", "date_modified", "_data", "orientation", JobDbManager.COL_UP_MIME_TYPE, "width", "height"};
        J = "_size>0 and ( _size < " + QAlbumBaseUtil.CONFIG_LIMIT_MAX_IMAGE_FILE_SIZE + " )  and (width>= 240 or width IS NULL) and (height>= 240 or height IS NULL )  and height  * 1.0 / width>= 0.45 and height  * 1.0 / width<= 2.2 and (" + JobDbManager.COL_UP_MIME_TYPE + "='image/jpeg' or (" + JobDbManager.COL_UP_MIME_TYPE + "='*/*' and " + InputMethodUtil.SOUGOU_URI_DISPLAYNAME + " LIKE'%.jpg%' )  or (" + JobDbManager.COL_UP_MIME_TYPE + "='*/*' and " + InputMethodUtil.SOUGOU_URI_DISPLAYNAME + " LIKE'%.jpeg%' )  or (" + JobDbManager.COL_UP_MIME_TYPE + "='*/*' and " + InputMethodUtil.SOUGOU_URI_DISPLAYNAME + " LIKE'%.bmp%' )  or (" + JobDbManager.COL_UP_MIME_TYPE + "='*/*' and " + InputMethodUtil.SOUGOU_URI_DISPLAYNAME + " LIKE'%.png%' )  or " + JobDbManager.COL_UP_MIME_TYPE + " LIKE'%bmp%' or " + JobDbManager.COL_UP_MIME_TYPE + " LIKE'%" + MimeHelper.IMAGE_SUBTYPE_BITMAP + "%' or " + JobDbManager.COL_UP_MIME_TYPE + "='image/png'";
        K = new String[]{"_id", "_data", "duration", "date_modified", JobDbManager.COL_UP_MIME_TYPE, "_size"};
        L = new String[]{"bucket_id", "bucket_display_name", "_id", "date_modified", "_data", JobDbManager.COL_UP_MIME_TYPE, "width", "height"};
        M = new String[]{"_id", "_data", JobDbManager.COL_UP_MIME_TYPE, "date_modified", "orientation", "_size", "width"};
    }

    public AlbumListAdapter(AbstractAlbumListFragment abstractAlbumListFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractAlbumListFragment);
            return;
        }
        this.f184218m = new Handler();
        this.C = new ArrayList();
        this.G = false;
        this.f184213d = abstractAlbumListFragment.E.f184225e;
        Resources resources = abstractAlbumListFragment.getResources();
        this.f184214e = resources;
        this.f184217i = resources.getDrawable(R.drawable.common_blue_bottom_dialog_checked_icon).getConstantState();
        int dimensionPixelSize = this.f184214e.getDimensionPixelSize(R.dimen.f158292cc);
        this.f184215f = dimensionPixelSize;
        this.f184216h = dimensionPixelSize;
    }

    public static String c(String str) {
        int lastIndexOf;
        if (str == null || (lastIndexOf = str.lastIndexOf("/")) < 0) {
            return null;
        }
        return str.substring(0, lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (!lowerCase.equalsIgnoreCase("camera") && !lowerCase.equalsIgnoreCase("100media")) {
            return false;
        }
        return true;
    }

    private boolean f(String str, int i3, int i16) {
        MediaMetadataRetriever mediaMetadataRetriever = null;
        try {
            MediaMetadataRetriever mediaMetadataRetriever2 = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever2.setDataSource(str);
                if (Integer.parseInt(mediaMetadataRetriever2.extractMetadata(18)) <= 0) {
                    mediaMetadataRetriever2.release();
                    return false;
                }
                if (Integer.parseInt(mediaMetadataRetriever2.extractMetadata(19)) <= 0) {
                    mediaMetadataRetriever2.release();
                    return false;
                }
                mediaMetadataRetriever2.release();
                return true;
            } catch (Exception unused) {
                mediaMetadataRetriever = mediaMetadataRetriever2;
                if (mediaMetadataRetriever != null) {
                    mediaMetadataRetriever.release();
                    return true;
                }
                return true;
            } catch (Throwable th5) {
                th = th5;
                mediaMetadataRetriever = mediaMetadataRetriever2;
                if (mediaMetadataRetriever != null) {
                    mediaMetadataRetriever.release();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<QQAlbumInfo> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (List) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<QQAlbumInfo> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        QQAlbumInfo qQAlbumInfo = this.D;
        if (qQAlbumInfo != null) {
            arrayList.add(qQAlbumInfo);
        }
        QQAlbumInfo qQAlbumInfo2 = this.E;
        if (qQAlbumInfo2 != null) {
            arrayList.add(qQAlbumInfo2);
        }
        List<QQAlbumInfo> list = this.F;
        if (list != null) {
            arrayList.addAll(list);
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public QQAlbumInfo getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (QQAlbumInfo) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        return this.C.get(i3);
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else if (Looper.myLooper() == Looper.getMainLooper()) {
            k();
        } else {
            this.f184218m.post(new Runnable() { // from class: com.tencent.mobileqq.activity.photo.album.albumlist.AlbumListAdapter.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AlbumListAdapter.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        AlbumListAdapter.this.k();
                    }
                }
            });
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.C.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
        }
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, i3)).intValue();
        }
        return QAlbumUtil.getMediaType(this.C.get(i3).mCoverInfo);
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            view2 = (View) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), view, viewGroup);
        } else {
            view2 = this.f184213d.getView(i3, view, viewGroup);
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return QAlbumUtil.MEDIA_TYPE_MAPS.size();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x011a A[Catch: Exception -> 0x019e, all -> 0x01a0, TryCatch #0 {all -> 0x01a0, blocks: (B:19:0x0053, B:21:0x0058, B:22:0x00a1, B:24:0x00a7, B:27:0x00c2, B:30:0x00d3, B:35:0x0112, B:37:0x011a, B:38:0x012f, B:40:0x0137, B:42:0x0164, B:43:0x0169, B:49:0x0122, B:50:0x00e8, B:53:0x010c, B:60:0x0179, B:61:0x017d, B:63:0x0183, B:66:0x0193), top: B:18:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0137 A[Catch: Exception -> 0x019e, all -> 0x01a0, TryCatch #0 {all -> 0x01a0, blocks: (B:19:0x0053, B:21:0x0058, B:22:0x00a1, B:24:0x00a7, B:27:0x00c2, B:30:0x00d3, B:35:0x0112, B:37:0x011a, B:38:0x012f, B:40:0x0137, B:42:0x0164, B:43:0x0169, B:49:0x0122, B:50:0x00e8, B:53:0x010c, B:60:0x0179, B:61:0x017d, B:63:0x0183, B:66:0x0193), top: B:18:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0122 A[Catch: Exception -> 0x019e, all -> 0x01a0, TryCatch #0 {all -> 0x01a0, blocks: (B:19:0x0053, B:21:0x0058, B:22:0x00a1, B:24:0x00a7, B:27:0x00c2, B:30:0x00d3, B:35:0x0112, B:37:0x011a, B:38:0x012f, B:40:0x0137, B:42:0x0164, B:43:0x0169, B:49:0x0122, B:50:0x00e8, B:53:0x010c, B:60:0x0179, B:61:0x017d, B:63:0x0183, B:66:0x0193), top: B:18:0x0053 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<QQAlbumInfo> h(Context context, int i3) {
        LinkedList<QQAlbumInfo> linkedList;
        Uri build;
        Cursor query;
        int i16;
        int i17;
        int i18;
        Integer num;
        int i19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (List) iPatchRedirector.redirect((short) 13, (Object) this, (Object) context, i3);
        }
        Cursor cursor = null;
        try {
            try {
                if (i3 < 0) {
                    build = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else {
                    Uri.Builder buildUpon = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.buildUpon();
                    buildUpon.appendQueryParameter("limit", String.valueOf(i3));
                    build = buildUpon.build();
                }
                query = ContactsMonitor.query(context.getContentResolver(), build, I, this.f184213d.a(), null, "date_modified DESC");
            } catch (Throwable th5) {
                th = th5;
            }
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
            } catch (Exception e17) {
                e = e17;
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
                int columnIndex8 = query.getColumnIndex("width");
                int columnIndex9 = query.getColumnIndex("height");
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                while (query.moveToNext()) {
                    String string = query.getString(columnIndex);
                    String string2 = query.getString(columnIndex2);
                    String string3 = query.getString(columnIndex3);
                    int i26 = columnIndex;
                    long j3 = query.getLong(columnIndex4);
                    if (TextUtils.isEmpty(string2)) {
                        string2 = Logger.ROOT_LOGGER_NAME;
                    }
                    int i27 = columnIndex2;
                    String str = string2;
                    if (TextUtils.isEmpty(string)) {
                        columnIndex = i26;
                        columnIndex2 = i27;
                    } else {
                        int i28 = query.getInt(columnIndex8);
                        int i29 = query.getInt(columnIndex9);
                        int i36 = columnIndex3;
                        if (i28 > 0 && i29 > 0) {
                            i16 = columnIndex4;
                            i17 = columnIndex8;
                            i18 = 1;
                            num = (Integer) hashMap.get(string);
                            if (num != null) {
                                hashMap.put(string, Integer.valueOf(i18));
                            } else {
                                hashMap.put(string, Integer.valueOf(num.intValue() + 1));
                            }
                            if (((QQAlbumInfo) hashMap2.get(string)) != null) {
                                QQAlbumInfo qQAlbumInfo = new QQAlbumInfo();
                                qQAlbumInfo.name = str;
                                qQAlbumInfo.f203112id = string;
                                qQAlbumInfo.coverDate = j3;
                                LocalMediaInfo localMediaInfo = qQAlbumInfo.mCoverInfo;
                                localMediaInfo.path = string3;
                                i19 = columnIndex9;
                                localMediaInfo._id = query.getLong(columnIndex5);
                                localMediaInfo.modifiedDate = j3;
                                localMediaInfo.orientation = query.getInt(columnIndex6);
                                String string4 = query.getString(columnIndex7);
                                localMediaInfo.mMimeType = string4;
                                if ("*/*".equals(string4)) {
                                    localMediaInfo.mMimeType = "image";
                                }
                                hashMap2.put(string, qQAlbumInfo);
                                linkedList.add(qQAlbumInfo);
                            } else {
                                i19 = columnIndex9;
                            }
                            columnIndex = i26;
                            columnIndex2 = i27;
                            columnIndex9 = i19;
                            columnIndex4 = i16;
                            columnIndex3 = i36;
                            columnIndex8 = i17;
                        }
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        i16 = columnIndex4;
                        options.inJustDecodeBounds = true;
                        i17 = columnIndex8;
                        int[] iArr = new int[2];
                        QAlbumBaseUtil.getWHByPath(string3, options, iArr);
                        if (iArr[0] > 0) {
                            i18 = 1;
                            if (iArr[1] <= 0) {
                            }
                            num = (Integer) hashMap.get(string);
                            if (num != null) {
                            }
                            if (((QQAlbumInfo) hashMap2.get(string)) != null) {
                            }
                            columnIndex = i26;
                            columnIndex2 = i27;
                            columnIndex9 = i19;
                            columnIndex4 = i16;
                            columnIndex3 = i36;
                            columnIndex8 = i17;
                        }
                        columnIndex = i26;
                        columnIndex2 = i27;
                        columnIndex4 = i16;
                        columnIndex3 = i36;
                        columnIndex8 = i17;
                    }
                }
                for (QQAlbumInfo qQAlbumInfo2 : linkedList) {
                    Integer num2 = (Integer) hashMap.get(qQAlbumInfo2.f203112id);
                    if (num2 != null) {
                        qQAlbumInfo2.mMediaFileCount = num2.intValue();
                    }
                }
                query.close();
            } catch (Exception e18) {
                e = e18;
                cursor = query;
                if (QLog.isColorLevel()) {
                    QLog.d("QQAlbum", 2, "queryImageBuckets(), query failed", e);
                }
                if (cursor != null) {
                    cursor.close();
                }
                return linkedList;
            }
            return linkedList;
        } catch (Throwable th6) {
            th = th6;
            cursor = query;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public QQAlbumInfo i(AbstractAlbumListFragment abstractAlbumListFragment, QQAlbumInfo qQAlbumInfo, boolean z16, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (QQAlbumInfo) iPatchRedirector.redirect((short) 15, this, abstractAlbumListFragment, qQAlbumInfo, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
        }
        if (qQAlbumInfo == null) {
            qQAlbumInfo = new QQAlbumInfo();
        }
        abstractAlbumListFragment.E.f184222b.createFilterListener();
        MediaQueryHelper build = new MediaQueryHelper.Builder().setEachCount(3).needImage(z16).needVideo(z17).setListener(abstractAlbumListFragment.E.f184222b.filterListener).build(abstractAlbumListFragment.getActivity());
        while (!build.mTraversalDone && build.mediaList.isEmpty()) {
            build.queryNext();
        }
        if (!build.mediaList.isEmpty()) {
            LocalMediaInfo localMediaInfo = build.mediaList.get(0);
            qQAlbumInfo.mCoverInfo = localMediaInfo;
            qQAlbumInfo.coverDate = localMediaInfo.modifiedDate;
        }
        if (z18) {
            build.upDateCount();
            qQAlbumInfo.mMediaFileCount = build.cursorsCount;
        }
        build.close();
        return qQAlbumInfo;
    }

    public List<QQAlbumInfo> j(Context context, int i3, MediaFileFilter mediaFileFilter) {
        LinkedList<QQAlbumInfo> linkedList;
        Uri build;
        Cursor query;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (List) iPatchRedirector.redirect((short) 14, this, context, Integer.valueOf(i3), mediaFileFilter);
        }
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
                query = ContactsMonitor.query(context.getContentResolver(), build, L, "_size>0 and mime_type='video/mp4'", null, "date_modified DESC");
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
                } catch (Throwable th5) {
                    th = th5;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Exception e17) {
                e = e17;
                linkedList = null;
            }
            try {
                int columnIndex = query.getColumnIndex("bucket_id");
                int columnIndex2 = query.getColumnIndex("_id");
                int columnIndex3 = query.getColumnIndex("bucket_display_name");
                int columnIndex4 = query.getColumnIndex("_data");
                int columnIndex5 = query.getColumnIndex("date_modified");
                int columnIndex6 = query.getColumnIndex(JobDbManager.COL_UP_MIME_TYPE);
                int columnIndex7 = query.getColumnIndex("width");
                int columnIndex8 = query.getColumnIndex("height");
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                while (query.moveToNext()) {
                    String string = query.getString(columnIndex);
                    String string2 = query.getString(columnIndex3);
                    long j3 = query.getLong(columnIndex5);
                    if (TextUtils.isEmpty(string2)) {
                        string2 = Logger.ROOT_LOGGER_NAME;
                    }
                    int i17 = columnIndex;
                    String str = string2;
                    if (TextUtils.isEmpty(string)) {
                        columnIndex = i17;
                    } else {
                        int i18 = columnIndex3;
                        int i19 = query.getInt(columnIndex7);
                        int i26 = columnIndex5;
                        int i27 = query.getInt(columnIndex8);
                        int i28 = columnIndex7;
                        String string3 = query.getString(columnIndex4);
                        if ((i19 <= 0 || i27 <= 0) && !f(string3, i19, i27)) {
                            columnIndex = i17;
                            columnIndex3 = i18;
                            columnIndex5 = i26;
                        } else {
                            Integer num = (Integer) hashMap.get(string);
                            if (num == null) {
                                hashMap.put(string, 1);
                            } else {
                                hashMap.put(string, Integer.valueOf(num.intValue() + 1));
                            }
                            if (((QQAlbumInfo) hashMap2.get(string)) == null) {
                                QQAlbumInfo qQAlbumInfo = new QQAlbumInfo();
                                qQAlbumInfo.name = str;
                                qQAlbumInfo.f203112id = string;
                                qQAlbumInfo.coverDate = j3;
                                LocalMediaInfo localMediaInfo = qQAlbumInfo.mCoverInfo;
                                localMediaInfo.path = string3;
                                i16 = columnIndex6;
                                localMediaInfo._id = query.getLong(columnIndex2);
                                localMediaInfo.modifiedDate = j3;
                                localMediaInfo.mMimeType = query.getString(i16);
                                hashMap2.put(string, qQAlbumInfo);
                                linkedList.add(qQAlbumInfo);
                            } else {
                                i16 = columnIndex6;
                            }
                            columnIndex = i17;
                            columnIndex3 = i18;
                            columnIndex5 = i26;
                            columnIndex6 = i16;
                        }
                        columnIndex7 = i28;
                    }
                }
                for (QQAlbumInfo qQAlbumInfo2 : linkedList) {
                    Integer num2 = (Integer) hashMap.get(qQAlbumInfo2.f203112id);
                    if (num2 != null) {
                        qQAlbumInfo2.mMediaFileCount = num2.intValue();
                    }
                }
                query.close();
            } catch (Exception e18) {
                e = e18;
                cursor = query;
                if (QLog.isColorLevel()) {
                    QLog.d("QQAlbum", 2, "queryVideoBuckets(), query failed", e);
                }
                if (cursor != null) {
                    cursor.close();
                }
                return linkedList;
            }
            return linkedList;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.C.clear();
        this.C.addAll(b());
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(List<QQAlbumInfo> list) {
        this.F = list;
    }

    public void m(QQAlbumInfo qQAlbumInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) qQAlbumInfo);
        } else {
            this.D = qQAlbumInfo;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(QQAlbumInfo qQAlbumInfo) {
        this.E = qQAlbumInfo;
    }
}
