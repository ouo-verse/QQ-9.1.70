package com.tencent.filament.zplan.avatar;

import com.tencent.ark.ark;
import com.tencent.filament.zplan.engine.js.FilamentFileUtil;
import com.tencent.filament.zplan.util.Result;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.filament.zplanservice.verify.FilamentVerificationHelper;
import com.tencent.filament.zplanservice.verify.ResourceCheckAlgorithmSelect;
import cooperation.photoplus.sticker.Sticker;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.io.File;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002J\u0016\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rR\u0014\u0010\u0012\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/filament/zplan/avatar/FAssetChecker;", "", "", QzoneZipCacheHelper.DIR, "url", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "urlTemplate", "", "d", "path", "b", "Lcom/tencent/filament/zplan/util/c;", "c", "Lcom/tencent/filament/zplanservice/verify/ResourceCheckAlgorithmSelect;", "algorithmSelect", "Lcom/tencent/filament/zplan/avatar/AvatarCheckResult;", "a", "Z", "enableCppDownload", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class FAssetChecker {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final boolean enableCppDownload;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final FAssetChecker f105632b = new FAssetChecker();

    static {
        boolean g16 = FilamentFeatureUtil.f106409g.g();
        FLog.INSTANCE.i("FAssetChecker", "enableCppDownload:" + g16);
        enableCppDownload = g16;
    }

    FAssetChecker() {
    }

    @NotNull
    public final AvatarCheckResult a(@NotNull String url, @NotNull FilamentUrlTemplate urlTemplate, @NotNull ResourceCheckAlgorithmSelect algorithmSelect) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(urlTemplate, "urlTemplate");
        Intrinsics.checkNotNullParameter(algorithmSelect, "algorithmSelect");
        if (enableCppDownload) {
            FLog.INSTANCE.i("FAssetChecker", "checkResourceWithUrl return default. enableCppDownload:1");
            return AvatarCheckResult.INSTANCE.a();
        }
        String N0 = ZPlanAvatarResourceHelper.f105660o.N0(url, urlTemplate);
        if (N0 != null) {
            long currentTimeMillis = System.currentTimeMillis();
            return AvatarCheckResult.INSTANCE.b(url, N0, FilamentVerificationHelper.f106448a.a(N0, algorithmSelect), System.currentTimeMillis() - currentTimeMillis);
        }
        return AvatarCheckResult.INSTANCE.a();
    }

    public final boolean b(@NotNull String path) {
        Sequence filter;
        Object firstOrNull;
        String substringAfter;
        String substringBefore;
        boolean equals;
        Intrinsics.checkNotNullParameter(path, "path");
        File file = new File(path);
        FilamentFileUtil filamentFileUtil = FilamentFileUtil.INSTANCE;
        if (filamentFileUtil.isDirectory(file)) {
            filter = SequencesKt___SequencesKt.filter(FilesKt.walk$default(file, null, 1, null).maxDepth(1), new Function1<File, Boolean>() { // from class: com.tencent.filament.zplan.avatar.FAssetChecker$passMd5Verify$verifyFile$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(File file2) {
                    return Boolean.valueOf(invoke2(file2));
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2(@NotNull File it) {
                    boolean startsWith$default;
                    String extension;
                    Intrinsics.checkNotNullParameter(it, "it");
                    String name = it.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "it.name");
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(name, "mainfest.md5-", false, 2, null);
                    if (!startsWith$default) {
                        return false;
                    }
                    extension = FilesKt__UtilsKt.getExtension(it);
                    return Intrinsics.areEqual(extension, ark.ARKMETADATA_JSON);
                }
            });
            firstOrNull = SequencesKt___SequencesKt.firstOrNull(filter);
            File file2 = (File) firstOrNull;
            if (file2 == null) {
                FLog.INSTANCE.e("FAssetChecker", "verifyMd5 fail. no found verify file.");
                return false;
            }
            String verifyFilePath = file2.getAbsolutePath();
            String name = new File(verifyFilePath).getName();
            Intrinsics.checkNotNullExpressionValue(name, "File(verifyFilePath).name");
            substringAfter = StringsKt__StringsKt.substringAfter(name, "mainfest.md5-", "");
            substringBefore = StringsKt__StringsKt.substringBefore(substringAfter, Sticker.JSON_SUFFIX, "");
            Intrinsics.checkNotNullExpressionValue(verifyFilePath, "verifyFilePath");
            String md5File = filamentFileUtil.md5File(verifyFilePath);
            if (md5File != null) {
                equals = StringsKt__StringsJVMKt.equals(md5File, substringBefore, true);
                if (!equals) {
                    FLog.INSTANCE.e("FAssetChecker", "verifyMd5 fail. md5 error. readMD5:" + md5File + ", verifyFileMD5:" + substringBefore);
                    return false;
                }
                String readFileContent = filamentFileUtil.readFileContent(verifyFilePath);
                if (readFileContent == null) {
                    FLog.INSTANCE.e("FAssetChecker", "verifyMd5 fail. read md5File fail.");
                    return false;
                }
                try {
                    JSONObject jSONObject = new JSONObject(readFileContent);
                    try {
                        String string = jSONObject.getString("version");
                        if (!Intrinsics.areEqual(string, "1.0")) {
                            FLog.INSTANCE.e("FAssetChecker", "verifyMd5 fail. version mismatch, version:" + string);
                            return false;
                        }
                        JSONObject jSONObject2 = jSONObject.getJSONObject("fileMap");
                        Iterator keys = jSONObject2.keys();
                        Intrinsics.checkNotNullExpressionValue(keys, "fileMap.keys()");
                        while (keys.hasNext()) {
                            String file3 = (String) keys.next();
                            String string2 = jSONObject2.getJSONObject(file3).getString("md5");
                            FilamentFileUtil filamentFileUtil2 = FilamentFileUtil.INSTANCE;
                            Intrinsics.checkNotNullExpressionValue(file3, "file");
                            String pathAppend = filamentFileUtil2.pathAppend(path, file3);
                            if (new File(pathAppend).isDirectory()) {
                                FLog.INSTANCE.e("FAssetChecker", "verifyMd5 fail. " + pathAppend + " is directory");
                                return false;
                            }
                            String md5File2 = filamentFileUtil2.md5File(pathAppend);
                            if (md5File2 == null) {
                                FLog.INSTANCE.e("FAssetChecker", "verifyMd5 fail. calculate childFile md5 fail.");
                                return false;
                            }
                            if (!Intrinsics.areEqual(md5File2, string2)) {
                                FLog.INSTANCE.e("FAssetChecker", "verifyMd5 fail. fileMd5: " + md5File2 + ", verifyMd5:" + string2);
                                return false;
                            }
                        }
                        FLog.INSTANCE.i("FAssetChecker", "verifyMd5 success. path:" + path);
                        return true;
                    } catch (Exception e16) {
                        FLog.INSTANCE.e("FAssetChecker", "verifyMd5 fail. json error.", e16);
                        return false;
                    }
                } catch (Exception e17) {
                    FLog.INSTANCE.e("FAssetChecker", "verifyMd5 fail. parse json file fail. error:" + e17);
                    return false;
                }
            }
            FLog.INSTANCE.e("FAssetChecker", "verifyMd5 fail. calculate verifyFile md5 fail.");
            return false;
        }
        FLog.INSTANCE.i("FAssetChecker", "verifyMd5 fail. " + path + " isn't directory");
        return false;
    }

    @NotNull
    public final Result c(@NotNull String dir, @NotNull String url) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        Intrinsics.checkNotNullParameter(url, "url");
        if (!FilamentFileUtil.INSTANCE.isDirectory(new File(dir))) {
            FLog.INSTANCE.i("FAssetChecker", "verifyFace fail. " + dir + " isn't directory, url:" + url);
            return new Result(FaceVerificationCode.NOT_DIRECTORY.getCode(), dir + " isn't directory");
        }
        JSONObject u16 = FilamentFeatureUtil.f106409g.u();
        if (u16 == null) {
            FLog.INSTANCE.i("FAssetChecker", "pass face verification. verifyJson is null. dir:" + dir + ", url:" + url);
            return new Result(FaceVerificationCode.NO_CONFIG.getCode(), "verifyJson is null");
        }
        JSONObject optJSONObject = u16.optJSONObject(url);
        if (optJSONObject == null) {
            FLog.INSTANCE.i("FAssetChecker", "pass face verification. not found verify config for " + url + ". dir:" + dir);
            return new Result(FaceVerificationCode.NO_URL_CONFIG.getCode(), "not found verify config");
        }
        Iterator keys = optJSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "fileMap.keys()");
        while (keys.hasNext()) {
            String file = (String) keys.next();
            long optLong = optJSONObject.optLong(file);
            FilamentFileUtil filamentFileUtil = FilamentFileUtil.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(file, "file");
            File file2 = new File(filamentFileUtil.pathAppend(dir, file));
            if (!file2.exists()) {
                FLog.INSTANCE.e("FAssetChecker", "verifyFace fail. not found " + file + ", dir:" + dir + ", url:" + url);
                return new Result(FaceVerificationCode.NOT_FOUND_FILE.getCode(), "not found " + file);
            }
            if (file2.isDirectory()) {
                FLog.INSTANCE.e("FAssetChecker", "verifyFace fail. " + file + " is directory. dir:" + dir + ", url:" + url);
                return new Result(FaceVerificationCode.NOT_DIRECTORY_FOR_FILE.getCode(), file + " is directory");
            }
            long length = file2.length();
            if (length != optLong) {
                FLog.INSTANCE.e("FAssetChecker", "verifyFace fail. size mismatched, file:" + file + ", fileSize: " + length + ", verifyMd5:" + optLong + ", dir:" + dir + ", url:" + url);
                return new Result(FaceVerificationCode.SIZE_MISMATCHED.getCode(), "size mismatched, file:" + file + ", fileSize: " + length + ", verifyMd5:" + optLong);
            }
        }
        FLog.INSTANCE.i("FAssetChecker", "pass face verification. dir:" + dir + ", url:" + url);
        return new Result(FaceVerificationCode.SUCCESS.getCode(), "success");
    }

    public final boolean d(@NotNull String dir, @NotNull String url, @NotNull FilamentUrlTemplate urlTemplate) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(urlTemplate, "urlTemplate");
        if (!ZPlanAvatarResourceHelper.f105660o.u0(url, urlTemplate)) {
            return new File(dir).exists();
        }
        String[] list = new File(dir).list();
        if (list == null) {
            FLog.INSTANCE.i("FAssetChecker", "verifyResourceExist fail. childFilenameList is null. url: " + url);
            return false;
        }
        String c16 = com.tencent.filament.zplanservice.util.c.c(url);
        for (String childFilename : list) {
            Intrinsics.checkNotNullExpressionValue(childFilename, "childFilename");
            if (Intrinsics.areEqual(com.tencent.filament.zplanservice.util.c.c(childFilename), c16)) {
                return true;
            }
        }
        return false;
    }
}
