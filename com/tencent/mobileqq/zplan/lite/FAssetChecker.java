package com.tencent.mobileqq.zplan.lite;

import com.tencent.ark.ark;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.photoplus.sticker.Sticker;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.io.File;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.io.FileTreeWalk;
import kotlin.io.FilesKt__FileTreeWalkKt;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/lite/FAssetChecker;", "", "", "path", "", "e", QzoneZipCacheHelper.DIR, "filename", "d", "unZipPath", "c", "b", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class FAssetChecker {

    /* renamed from: a, reason: collision with root package name */
    public static final FAssetChecker f333779a = new FAssetChecker();

    FAssetChecker() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e(String path) {
        FileTreeWalk walk$default;
        Sequence filter;
        Object first;
        String substringAfter;
        String substringBefore;
        boolean equals;
        File file = new File(path);
        if (!file.exists()) {
            QLog.i("FAssetChecker", 1, "verify fail. " + path + " not exist");
            return false;
        }
        if (file.isDirectory()) {
            try {
                walk$default = FilesKt__FileTreeWalkKt.walk$default(file, null, 1, null);
                filter = SequencesKt___SequencesKt.filter(walk$default.maxDepth(1), new Function1<File, Boolean>() { // from class: com.tencent.mobileqq.zplan.lite.FAssetChecker$verifyFasset$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(File it) {
                        boolean startsWith$default;
                        String extension;
                        Intrinsics.checkNotNullParameter(it, "it");
                        String name = it.getName();
                        Intrinsics.checkNotNullExpressionValue(name, "it.name");
                        boolean z16 = false;
                        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(name, "mainfest.md5-", false, 2, null);
                        if (startsWith$default) {
                            extension = FilesKt__UtilsKt.getExtension(it);
                            if (Intrinsics.areEqual(extension, ark.ARKMETADATA_JSON)) {
                                z16 = true;
                            }
                        }
                        return Boolean.valueOf(z16);
                    }
                });
                first = SequencesKt___SequencesKt.first(filter);
                String absolutePath = ((File) first).getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "f.walk().maxDepth(1).fil\u2026n\" }.first().absolutePath");
                String name = new File(absolutePath).getName();
                Intrinsics.checkNotNullExpressionValue(name, "File(verifyFilePath).name");
                substringAfter = StringsKt__StringsKt.substringAfter(name, "mainfest.md5-", "");
                substringBefore = StringsKt__StringsKt.substringBefore(substringAfter, Sticker.JSON_SUFFIX, "");
                String calcMd5 = FileUtils.calcMd5(absolutePath);
                equals = StringsKt__StringsJVMKt.equals(calcMd5, substringBefore, true);
                if (!equals) {
                    QLog.e("FAssetChecker", 1, "verify fail. md5 error. readMD5:" + calcMd5 + ", verifyFileMD5:" + substringBefore);
                    return false;
                }
                try {
                    JSONObject jSONObject = new JSONObject(FileUtils.readFileToString(new File(absolutePath)));
                    try {
                        String string = jSONObject.getString("version");
                        if (!Intrinsics.areEqual(string, "1.0")) {
                            QLog.e("FAssetChecker", 1, "verify fail. version mismatch, version:" + string);
                            return false;
                        }
                        JSONObject jSONObject2 = jSONObject.getJSONObject("fileMap");
                        Iterator keys = jSONObject2.keys();
                        Intrinsics.checkNotNullExpressionValue(keys, "fileMap.keys()");
                        while (keys.hasNext()) {
                            String file2 = (String) keys.next();
                            long j3 = jSONObject2.getJSONObject(file2).getLong("size");
                            Intrinsics.checkNotNullExpressionValue(file2, "file");
                            String d16 = d(path, file2);
                            File file3 = new File(d16);
                            if (file3.isDirectory()) {
                                QLog.e("FAssetChecker", 1, "verify fail. " + d16 + " is directory");
                                return false;
                            }
                            long length = file3.length();
                            if (j3 != length) {
                                QLog.e("FAssetChecker", 1, "verify fail. fileSize: " + length + ", verifySize:" + j3);
                                return false;
                            }
                        }
                        QLog.i("FAssetChecker", 1, "verify success. path:" + path);
                        return true;
                    } catch (Exception e16) {
                        QLog.e("FAssetChecker", 1, "verify fail. json error.", e16);
                        return false;
                    }
                } catch (Exception e17) {
                    QLog.e("FAssetChecker", 1, "verify fail. parse json file fail. error:" + e17);
                    return false;
                }
            } catch (Exception e18) {
                QLog.e("FAssetChecker", 1, "verify fail. no found verify file.", e18);
                return false;
            }
        }
        QLog.e("FAssetChecker", 1, "verify fail. " + path + " isn't directory");
        return false;
    }

    public final String b(String unZipPath) {
        Intrinsics.checkNotNullParameter(unZipPath, "unZipPath");
        return d(unZipPath, "verify");
    }

    public final boolean c(String unZipPath) {
        Intrinsics.checkNotNullParameter(unZipPath, "unZipPath");
        return new File(b(unZipPath)).exists();
    }

    public final String d(String dir, String filename) {
        boolean endsWith$default;
        Intrinsics.checkNotNullParameter(dir, "dir");
        Intrinsics.checkNotNullParameter(filename, "filename");
        endsWith$default = StringsKt__StringsKt.endsWith$default((CharSequence) dir, File.separatorChar, false, 2, (Object) null);
        if (endsWith$default) {
            return dir + filename;
        }
        return dir + File.separatorChar + filename;
    }
}
