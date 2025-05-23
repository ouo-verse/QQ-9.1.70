package a9;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.qzone.reborn.configx.g;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.mobileqq.transfile.BasePicDownloadProcessor;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\n\u00a8\u0006\u000e"}, d2 = {"La9/a;", "", "", "b", "", "inputFilePath", "a", "path", "c", "", "Ljava/util/Map;", "convertImagePathMap", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f25720a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, String> convertImagePathMap = new LinkedHashMap();

    a() {
    }

    private final boolean b() {
        boolean q16 = g.f53821a.j().q();
        QLog.w("QZPublishX_QZPublishXImageFormatConvertManager", 1, "enableSwitch, switch: " + q16);
        return q16;
    }

    public final String a(String inputFilePath) {
        boolean endsWith$default;
        boolean endsWith$default2;
        if (!b() || TextUtils.isEmpty(inputFilePath)) {
            return null;
        }
        Intrinsics.checkNotNull(inputFilePath);
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(inputFilePath, QzoneEmotionUtils.SIGN_ICON_URL_END, false, 2, null);
        if (endsWith$default) {
            return null;
        }
        File file = new File(inputFilePath);
        if (com.tencent.qzone.avif.a.a(file)) {
            Bitmap a16 = com.tencent.qzone.image.api.a.c().a(file, file.getPath(), 0, 0);
            String originalFileName = file.getName();
            Intrinsics.checkNotNullExpressionValue(originalFileName, "originalFileName");
            endsWith$default2 = StringsKt__StringsJVMKt.endsWith$default(originalFileName, BasePicDownloadProcessor.AVIF_FILE_SUFFIX, false, 2, null);
            if (endsWith$default2) {
                Intrinsics.checkNotNullExpressionValue(originalFileName, "originalFileName");
                originalFileName = originalFileName.substring(0, originalFileName.length() - 5);
                Intrinsics.checkNotNullExpressionValue(originalFileName, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            }
            eb.a aVar = eb.a.f396056a;
            String b16 = aVar.b();
            String str = b16 + (originalFileName + ".jpeg");
            RFWFileUtils.createFileIfNotExits(aVar.b() + ".nomedia");
            if (com.qzone.util.image.c.V(a16, str, Bitmap.CompressFormat.JPEG, 90, true)) {
                Intrinsics.checkNotNull(str);
                QLog.w("QZPublishX_QZPublishXImageFormatConvertManager", 1, "convertAvifToJpeg success | inputFilePath = " + inputFilePath + " | newFilePath = " + str + " | exists = " + new File(str).exists());
                convertImagePathMap.put(str, inputFilePath);
                return str;
            }
            QLog.e("QZPublishX_QZPublishXImageFormatConvertManager", 1, "convertAvifToJpeg return false");
        }
        return null;
    }

    public final String c(String path) {
        if (!b() || TextUtils.isEmpty(path)) {
            return null;
        }
        Map<String, String> map = convertImagePathMap;
        if (!map.containsKey(path)) {
            return null;
        }
        String str = (String) TypeIntrinsics.asMutableMap(map).remove(path);
        File file = str != null ? new File(str) : null;
        QLog.w("QZPublishX_QZPublishXImageFormatConvertManager", 1, "removeFormatConvertImageFile  | convertFile:" + path + " | originPath:" + str);
        boolean z16 = false;
        if (file != null && !file.exists()) {
            z16 = true;
        }
        if (z16) {
            QLog.e("QZPublishX_QZPublishXImageFormatConvertManager", 1, "removeFormatConvertImageFile, originFile no exists");
            return null;
        }
        Intrinsics.checkNotNull(path);
        File file2 = new File(path);
        if (file2.exists()) {
            if (file2.delete()) {
                QLog.w("QZPublishX_QZPublishXImageFormatConvertManager", 1, "removeFormatConvertImageFile, delete success, convertFile: " + path);
            } else {
                QLog.e("QZPublishX_QZPublishXImageFormatConvertManager", 1, "removeFormatConvertImageFile, failed to delete convertFile: " + path);
            }
        }
        return str;
    }
}
