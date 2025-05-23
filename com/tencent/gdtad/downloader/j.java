package com.tencent.gdtad.downloader;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.open.base.MD5Utils;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b.\u0010/J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0013\u001a\u00020\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000bJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u000bJ\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u000bJ%\u0010\u001e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001b\u001a\u00020\u000b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ#\u0010 \u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u000b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001c\u00a2\u0006\u0004\b \u0010!J\u001a\u0010$\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\"j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`#J\u001a\u0010%\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\"j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`#J\u000e\u0010&\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010(\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u000bJ\u0010\u0010)\u001a\u00020\u00192\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010*\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u0002R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00060"}, d2 = {"Lcom/tencent/gdtad/downloader/j;", "Lcom/tencent/gdtad/downloader/w;", "Lcom/tencent/open/downloadnew/DownloadInfo;", "downloadInfo", "", "isInit", "Landroid/content/ContentValues;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/database/Cursor;", "dbCursor", "r", "", "columnId", "", DomainData.DOMAIN_NAME, "", "o", "p", "v", "e", "g", "downloadUrl", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "url", "k", "", "j", "where", "", "whereValue", "l", "(Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/open/downloadnew/DownloadInfo;", "i", "(Ljava/lang/String;[Ljava/lang/String;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", ReportConstant.COSTREPORT_PREFIX, "t", "w", "isAutoPause", "y", HippyTKDListViewAdapter.X, "u", tl.h.F, "[Ljava/lang/String;", "DOWNLOAD_COLUMNS", "<init>", "()V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class j extends w {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final j f109185f = new j();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String[] DOWNLOAD_COLUMNS = {"appId", "downloadUrl", "infoKey", "via", "name", "iconUrl", "packageName", "versionCode", "totalSize", "downloadSize", "status", "savePath", "source", DKEngine.GlobalKey.NET_WORK_TYPE, WadlProxyConsts.CREATE_TIME, "downloadProgress", WadlProxyConsts.CHANNEL, WadlProxyConsts.FLAGS, WadlProxyConsts.EXTRA_DATA, "adId", "posId", "traceId", "isAutoInstall", "isAutoPause", WadlProxyConsts.LAST_UPDATE_TIME, "injectTraceIdOffset", "isTraceIdInjected", VirtualAppProxy.KEY_DOWNLOAD_SCENE};

    j() {
        super("download");
    }

    private final int n(Cursor dbCursor, String columnId) {
        int columnIndex = dbCursor.getColumnIndex(columnId);
        if (columnIndex < 0) {
            return 0;
        }
        return dbCursor.getInt(columnIndex);
    }

    private final long o(Cursor dbCursor, String columnId) {
        int columnIndex = dbCursor.getColumnIndex(columnId);
        if (columnIndex < 0) {
            return 0L;
        }
        return dbCursor.getLong(columnIndex);
    }

    private final String p(Cursor dbCursor, String columnId) {
        int columnIndex = dbCursor.getColumnIndex(columnId);
        if (columnIndex < 0) {
            return "";
        }
        String string = dbCursor.getString(columnIndex);
        Intrinsics.checkNotNullExpressionValue(string, "dbCursor.getString(columnIndex)");
        return string;
    }

    private final ContentValues q(DownloadInfo downloadInfo, boolean isInit) {
        String str;
        ContentValues contentValues = new ContentValues();
        contentValues.put("downloadSize", Long.valueOf(downloadInfo.V));
        contentValues.put("status", Integer.valueOf(downloadInfo.f()));
        contentValues.put(WadlProxyConsts.LAST_UPDATE_TIME, Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
        contentValues.put("savePath", downloadInfo.L);
        contentValues.put("totalSize", Long.valueOf(downloadInfo.f341180b0));
        contentValues.put("downloadProgress", Integer.valueOf(downloadInfo.Q));
        contentValues.put(DKEngine.GlobalKey.NET_WORK_TYPE, Integer.valueOf(HttpUtil.getNetWorkType()));
        contentValues.put("injectTraceIdOffset", Long.valueOf(downloadInfo.f341204t0));
        String str2 = "0";
        if (!downloadInfo.f341205u0) {
            str = "0";
        } else {
            str = "1";
        }
        contentValues.put("isTraceIdInjected", str);
        if (!isInit) {
            return contentValues;
        }
        contentValues.put("appId", downloadInfo.f341184e);
        contentValues.put("downloadUrl", downloadInfo.f341186f);
        contentValues.put("infoKey", MD5Utils.toMD5(downloadInfo.f341186f));
        contentValues.put("via", downloadInfo.C);
        contentValues.put("iconUrl", downloadInfo.Y);
        contentValues.put("packageName", downloadInfo.f341189h);
        contentValues.put("versionCode", Integer.valueOf(downloadInfo.I));
        contentValues.put("source", downloadInfo.M);
        contentValues.put(DKEngine.GlobalKey.NET_WORK_TYPE, Integer.valueOf(HttpUtil.getNetWorkType()));
        contentValues.put(WadlProxyConsts.CREATE_TIME, Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
        contentValues.put("name", downloadInfo.f341191i);
        contentValues.put("posId", downloadInfo.f341195l0);
        contentValues.put("traceId", downloadInfo.f341193j0);
        contentValues.put("adId", downloadInfo.f341194k0);
        if (downloadInfo.T) {
            str2 = "1";
        }
        contentValues.put("isAutoInstall", str2);
        contentValues.put("isAutoPause", "1");
        contentValues.put(VirtualAppProxy.KEY_DOWNLOAD_SCENE, Integer.valueOf(downloadInfo.f341206v0));
        return contentValues;
    }

    private final DownloadInfo r(Cursor dbCursor) {
        DownloadInfo downloadInfo = new DownloadInfo();
        downloadInfo.f341186f = p(dbCursor, "downloadUrl");
        downloadInfo.L = p(dbCursor, "savePath");
        downloadInfo.V = o(dbCursor, "downloadSize");
        downloadInfo.k(n(dbCursor, "status"));
        downloadInfo.M = p(dbCursor, "source");
        downloadInfo.f341184e = p(dbCursor, "appId");
        downloadInfo.C = p(dbCursor, "via");
        downloadInfo.f341189h = p(dbCursor, "packageName");
        downloadInfo.f341191i = p(dbCursor, "name");
        downloadInfo.Q = n(dbCursor, "downloadProgress");
        downloadInfo.K = n(dbCursor, DKEngine.GlobalKey.NET_WORK_TYPE);
        downloadInfo.f341195l0 = p(dbCursor, "posId");
        downloadInfo.f341193j0 = p(dbCursor, "traceId");
        downloadInfo.f341194k0 = p(dbCursor, "adId");
        downloadInfo.f341206v0 = n(dbCursor, VirtualAppProxy.KEY_DOWNLOAD_SCENE);
        downloadInfo.D = o(dbCursor, WadlProxyConsts.CREATE_TIME);
        downloadInfo.f341196m = String.valueOf(o(dbCursor, WadlProxyConsts.CREATE_TIME));
        downloadInfo.T = TextUtils.equals(p(dbCursor, "isAutoInstall"), "1");
        if (v(downloadInfo)) {
            downloadInfo.Q = 0;
            downloadInfo.k(1);
        }
        downloadInfo.f341204t0 = o(dbCursor, "injectTraceIdOffset");
        downloadInfo.f341205u0 = TextUtils.equals(p(dbCursor, "isTraceIdInjected"), "1");
        if (NetConnInfoCenter.getServerTimeMillis() - o(dbCursor, WadlProxyConsts.LAST_UPDATE_TIME) > 8000 && downloadInfo.f() == 2) {
            downloadInfo.k(3);
        }
        return downloadInfo;
    }

    private final boolean v(DownloadInfo downloadInfo) {
        if (!new File(downloadInfo.L).exists() && downloadInfo.Q == 100 && downloadInfo.f() == 4) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.gdtad.downloader.w
    @NotNull
    public String e() {
        return "appId TEXT NOT NULL, infoKey TEXT NOT NULL, downloadUrl TEXT NOT NULL, via TEXT, name TEXT, iconUrl TEXT, packageName TEXT, versionCode INTEGER, totalSize INTEGER, downloadSize INTEGER, status INTEGER ,networkType INTEGER ,savePath TEXT,source TEXT,createTime LONG, downloadProgress INTEGER, channel TEXT, flags INTEGER, extraData TEXT, posId TEXT, adId TEXT, traceId TEXT, isAutoInstall TEXT, isAutoPause TEXT, injectTraceIdOffset LONG, isTraceIdInjected TEXT, downloadScene INTEGER, lastUpdateTime LONG, ";
    }

    @Override // com.tencent.gdtad.downloader.w
    @NotNull
    public String g() {
        return "downloadUrl";
    }

    public final void i(@NotNull String where, @NotNull String[] whereValue) {
        Intrinsics.checkNotNullParameter(where, "where");
        Intrinsics.checkNotNullParameter(whereValue, "whereValue");
        SQLiteDatabase readableDatabase = getReadableDatabase();
        if (readableDatabase == null) {
            return;
        }
        try {
            readableDatabase.delete(getCom.tencent.qqmini.sdk.plugins.ReportPlugin.KEY_TABLE_NAME java.lang.String(), where, whereValue);
        } finally {
            try {
            } finally {
            }
        }
    }

    public final void j(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        String md5 = MD5Utils.toMD5(url);
        Intrinsics.checkNotNullExpressionValue(md5, "toMD5(url)");
        i("infoKey=?", new String[]{md5});
    }

    @Nullable
    public final DownloadInfo k(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        String md5 = MD5Utils.toMD5(url);
        Intrinsics.checkNotNullExpressionValue(md5, "toMD5(url)");
        return l("infoKey=?", new String[]{md5});
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x007b, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0078, code lost:
    
        if (r9 == null) goto L13;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final DownloadInfo l(@NotNull String where, @NotNull String[] whereValue) {
        Intrinsics.checkNotNullParameter(where, "where");
        Intrinsics.checkNotNullParameter(whereValue, "whereValue");
        SQLiteDatabase readableDatabase = getReadableDatabase();
        Cursor cursor = null;
        if (readableDatabase == null) {
            return null;
        }
        DownloadInfo downloadInfo = new DownloadInfo();
        try {
            cursor = readableDatabase.query(getCom.tencent.qqmini.sdk.plugins.ReportPlugin.KEY_TABLE_NAME java.lang.String(), DOWNLOAD_COLUMNS, where, whereValue, null, null, null);
            if (cursor != null && cursor.moveToNext()) {
                downloadInfo = r(cursor);
            }
        } catch (Throwable th5) {
            try {
                QLog.e("DownloadDbHelper", 1, "execQueryDownloadInfo " + getCom.tencent.qqmini.sdk.plugins.ReportPlugin.KEY_TABLE_NAME java.lang.String() + "where =" + where + " exception:" + th5.getMessage());
            } finally {
                if (cursor != null) {
                    k.f109187a.a(cursor);
                }
                k.f109187a.a(readableDatabase);
            }
        }
    }

    public final boolean m(@NotNull String downloadUrl) {
        Intrinsics.checkNotNullParameter(downloadUrl, "downloadUrl");
        String md5 = MD5Utils.toMD5(downloadUrl);
        Intrinsics.checkNotNullExpressionValue(md5, "toMD5(downloadUrl)");
        return d("infoKey=?", new String[]{md5}, "infoKey");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0085, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0082, code lost:
    
        if (r9 == null) goto L17;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ArrayList<DownloadInfo> s() {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        Cursor cursor = null;
        if (readableDatabase == null) {
            return null;
        }
        ArrayList<DownloadInfo> arrayList = new ArrayList<>();
        try {
            cursor = readableDatabase.query(getCom.tencent.qqmini.sdk.plugins.ReportPlugin.KEY_TABLE_NAME java.lang.String(), DOWNLOAD_COLUMNS, "status!=?", new String[]{"4"}, null, null, WadlProxyConsts.LAST_UPDATE_TIME);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    if (!Intrinsics.areEqual(p(cursor, "isAutoPause"), "0")) {
                        arrayList.add(r(cursor));
                    }
                }
            }
        } catch (Throwable th5) {
            try {
                QLog.e("DownloadDbHelper", 1, "execQueryByState " + getCom.tencent.qqmini.sdk.plugins.ReportPlugin.KEY_TABLE_NAME java.lang.String() + " exception:" + th5.getMessage());
            } finally {
                if (cursor != null) {
                    k.f109187a.a(cursor);
                }
                k.f109187a.a(readableDatabase);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0074, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0071, code lost:
    
        if (r9 == null) goto L14;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ArrayList<DownloadInfo> t() {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        Cursor cursor = null;
        if (readableDatabase == null) {
            return null;
        }
        ArrayList<DownloadInfo> arrayList = new ArrayList<>();
        try {
            cursor = readableDatabase.query(getCom.tencent.qqmini.sdk.plugins.ReportPlugin.KEY_TABLE_NAME java.lang.String(), DOWNLOAD_COLUMNS, "status=?", new String[]{"2"}, null, null, WadlProxyConsts.LAST_UPDATE_TIME);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    arrayList.add(r(cursor));
                }
            }
        } catch (Throwable th5) {
            try {
                QLog.e("DownloadDbHelper", 1, "execQueryByState " + getCom.tencent.qqmini.sdk.plugins.ReportPlugin.KEY_TABLE_NAME java.lang.String() + " exception:" + th5.getMessage());
            } finally {
                if (cursor != null) {
                    k.f109187a.a(cursor);
                }
                k.f109187a.a(readableDatabase);
            }
        }
    }

    public final synchronized void u(@NotNull DownloadInfo downloadInfo) {
        Intrinsics.checkNotNullParameter(downloadInfo, "downloadInfo");
        String url = downloadInfo.f341186f;
        if (!TextUtils.isEmpty(url)) {
            Intrinsics.checkNotNullExpressionValue(url, "url");
            if (!m(url)) {
                b(q(downloadInfo, true));
            }
        }
    }

    public final synchronized void w(@NotNull DownloadInfo downloadInfo) {
        Intrinsics.checkNotNullParameter(downloadInfo, "downloadInfo");
        String url = downloadInfo.f341186f;
        if (!TextUtils.isEmpty(url)) {
            Intrinsics.checkNotNullExpressionValue(url, "url");
            if (m(url)) {
                c("infoKey=?", new String[]{MD5Utils.toMD5(url)}, q(downloadInfo, false));
            }
        }
    }

    public final synchronized void x(@Nullable DownloadInfo downloadInfo) {
        String str;
        String str2;
        String str3;
        String str4 = null;
        if (downloadInfo != null) {
            try {
                str = downloadInfo.f341186f;
            } catch (Throwable th5) {
                throw th5;
            }
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str) && str != null && m(str)) {
            ContentValues contentValues = new ContentValues();
            if (downloadInfo != null) {
                str2 = downloadInfo.f341195l0;
            } else {
                str2 = null;
            }
            contentValues.put("posId", str2);
            if (downloadInfo != null) {
                str3 = downloadInfo.f341194k0;
            } else {
                str3 = null;
            }
            contentValues.put("adId", str3);
            if (downloadInfo != null) {
                str4 = downloadInfo.f341193j0;
            }
            contentValues.put("traceId", str4);
            c("infoKey=?", new String[]{MD5Utils.toMD5(str)}, contentValues);
        }
    }

    public final synchronized void y(@NotNull DownloadInfo downloadInfo, @NotNull String isAutoPause) {
        Intrinsics.checkNotNullParameter(downloadInfo, "downloadInfo");
        Intrinsics.checkNotNullParameter(isAutoPause, "isAutoPause");
        String url = downloadInfo.f341186f;
        if (!TextUtils.isEmpty(url)) {
            Intrinsics.checkNotNullExpressionValue(url, "url");
            if (m(url)) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("isAutoPause", isAutoPause);
                contentValues.put("posId", downloadInfo.f341195l0);
                c("infoKey=?", new String[]{MD5Utils.toMD5(url)}, contentValues);
            }
        }
    }
}
