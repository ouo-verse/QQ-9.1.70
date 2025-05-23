package com.tencent.mobileqq.zootopia.download;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Looper;
import android.os.StatFs;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.z1.download.FileDownloadParams;
import com.tencent.mobileqq.zootopia.download.data.ZootopiaDownloadData;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\n\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0014\u0010\u000b\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000f\u001a\u00020\u0002J\u0016\u0010\u0011\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002J\u001e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0014J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u0014J)\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00052\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\u0004\b\u001f\u0010 J\u000e\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\u0002R\u0014\u0010%\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/v;", "", "", "fullDownloadUrl", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "forceSwitchDownloadThread", "Lkotlin/Function0;", "", "runner", "o", DomainData.DOMAIN_NAME, "mapId", "needSeparator", "g", "c", "projectName", "j", "fileUrl", "i", "Lcom/tencent/mobileqq/z1/download/a;", "data", "f", "e", "Ljava/io/File;", "d", "k", "Lcom/tencent/mobileqq/zootopia/download/data/ZootopiaDownloadData;", "isDownloadSuccess", "", ImageTaskConst.FAIL_CODE, "l", "(Lcom/tencent/mobileqq/zootopia/download/data/ZootopiaDownloadData;ZLjava/lang/Integer;)V", "filePath", "", "b", "Ljava/lang/String;", "downloadFolderPath", "I", "notifyId", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class v {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String downloadFolderPath;

    /* renamed from: a, reason: collision with root package name */
    public static final v f328299a = new v();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int notifyId = 529;

    static {
        String path;
        BaseApplication context = BaseApplication.getContext();
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir == null || (path = externalFilesDir.getPath()) == null) {
            path = context.getFilesDir().getPath();
        }
        downloadFolderPath = path + File.separator + "zootopia_download";
    }

    v() {
    }

    private final String m(String fullDownloadUrl) {
        boolean endsWith$default;
        String substringAfterLast$default;
        boolean contains$default;
        String substringAfterLast$default2;
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(fullDownloadUrl, QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, false, 2, null);
        if (endsWith$default) {
            fullDownloadUrl = StringsKt__StringsKt.substringBeforeLast$default(fullDownloadUrl, QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, (String) null, 2, (Object) null);
        }
        substringAfterLast$default = StringsKt__StringsKt.substringAfterLast$default(fullDownloadUrl, ".", (String) null, 2, (Object) null);
        String separator = File.separator;
        Intrinsics.checkNotNullExpressionValue(separator, "separator");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) substringAfterLast$default, (CharSequence) separator, false, 2, (Object) null);
        if (contains$default) {
            Intrinsics.checkNotNullExpressionValue(separator, "separator");
            substringAfterLast$default2 = StringsKt__StringsKt.substringAfterLast$default(fullDownloadUrl, separator, (String) null, 2, (Object) null);
            return substringAfterLast$default2;
        }
        return "." + substringAfterLast$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Function0 runner) {
        Intrinsics.checkNotNullParameter(runner, "$runner");
        runner.invoke();
    }

    public final long b(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        File file = new File(filePath);
        if (!(!file.exists() ? file.mkdirs() : true)) {
            return -1L;
        }
        StatFs statFs = new StatFs(filePath);
        return statFs.getBlockSize() * statFs.getAvailableBlocks();
    }

    public final String c() {
        return downloadFolderPath + File.separator;
    }

    public final File d(FileDownloadParams data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new File(f(data) + File.separator + e(data));
    }

    public final String e(FileDownloadParams data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (!TextUtils.isEmpty(data.getFileName())) {
            String fileName = data.getFileName();
            return fileName == null ? "" : fileName;
        }
        String encodeHexStr = MD5Utils.encodeHexStr(data.getUrl());
        return encodeHexStr == null ? data.getUrl() : encodeHexStr;
    }

    public final String f(FileDownloadParams data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (!TextUtils.isEmpty(data.getFilePath())) {
            String filePath = data.getFilePath();
            return filePath == null ? "" : filePath;
        }
        return downloadFolderPath + File.separator + data.getCategory();
    }

    public final String g(String mapId, boolean needSeparator) {
        Intrinsics.checkNotNullParameter(mapId, "mapId");
        String str = downloadFolderPath;
        String str2 = File.separator;
        return str + str2 + mapId + (needSeparator ? str2 : "");
    }

    public final String i(String mapId, String fileUrl, String projectName) {
        boolean endsWith$default;
        boolean contains$default;
        Intrinsics.checkNotNullParameter(mapId, "mapId");
        Intrinsics.checkNotNullParameter(fileUrl, "fileUrl");
        Intrinsics.checkNotNullParameter(projectName, "projectName");
        String str = mapId + ".zip";
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(fileUrl, ".zip", false, 2, null);
        if (endsWith$default) {
            return str;
        }
        String m3 = m(fileUrl);
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) m3, (CharSequence) ".", false, 2, (Object) null);
        if (!contains$default) {
            return m3;
        }
        return projectName + m3;
    }

    public final String j(String mapId, String projectName) {
        Intrinsics.checkNotNullParameter(mapId, "mapId");
        Intrinsics.checkNotNullParameter(projectName, "projectName");
        return g(mapId, true) + projectName + ".pak";
    }

    public final String k(FileDownloadParams data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (TextUtils.isEmpty(data.getFilePath()) || TextUtils.isEmpty(data.getFileName())) {
            return null;
        }
        return data.getFilePath() + File.separator + data.getFileName();
    }

    public final void l(ZootopiaDownloadData data, boolean isDownloadSuccess, Integer failCode) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(data, "data");
        NotificationCompat.Builder builder = new NotificationCompat.Builder(BaseApplication.getContext());
        BaseApplication baseApplication = BaseApplication.context;
        Intent intent = new Intent();
        intent.putExtra("zootopia_id", data.getSummaryData().getId());
        intent.putExtra("zootopia_result", isDownloadSuccess);
        intent.putExtra("zootopia_op_type", isDownloadSuccess ? 2 : 1);
        intent.setAction("zootopia_download_receiver");
        Unit unit = Unit.INSTANCE;
        PendingIntent broadcast = PendingIntent.getBroadcast(baseApplication, 0, intent, 201326592);
        String str3 = "\u3010" + data.getSummaryData().getTitle() + "\u3011";
        if (isDownloadSuccess) {
            str2 = "\u4e0b\u8f7d\u5b8c\u6210,\u70b9\u51fb\u524d\u5f80\u65b0\u4e50\u56ed\u63a2\u7d22\u5427>>";
        } else {
            if ((failCode == null || failCode.intValue() != -2) && (failCode == null || failCode.intValue() != -5)) {
                str = "\u4e0b\u8f7d\u5931\u8d25";
            } else {
                str = "\u89e3\u538b\u5931\u8d25";
            }
            str2 = str + ",\u67e5\u770b\u8be6\u60c5>>";
        }
        builder.setTicker("\u4e50\u56ed");
        builder.setWhen(System.currentTimeMillis());
        builder.setDefaults(1);
        builder.setContentTitle(str3);
        builder.setContentText(str2);
        builder.setContentIntent(broadcast);
        builder.setSmallIcon(R.drawable.b8g);
        Notification build = builder.build();
        build.flags = 16;
        QQNotificationManager.addChannelIfNeed(build, QQNotificationManager.CHANNEL_ID_OTHER);
        QQNotificationManager qQNotificationManager = QQNotificationManager.getInstance();
        int i3 = notifyId;
        notifyId = i3 + 1;
        qQNotificationManager.notify("ZootopiaNotify", i3, build);
    }

    public final void n(Function0<Unit> runner) {
        Intrinsics.checkNotNullParameter(runner, "runner");
        o(false, runner);
    }

    public final void o(boolean forceSwitchDownloadThread, final Function0<Unit> runner) {
        Intrinsics.checkNotNullParameter(runner, "runner");
        if (!forceSwitchDownloadThread && !Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            runner.invoke();
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zootopia.download.u
                @Override // java.lang.Runnable
                public final void run() {
                    v.p(Function0.this);
                }
            }, 32, null, false);
        }
    }

    public static /* synthetic */ String h(v vVar, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return vVar.g(str, z16);
    }
}
