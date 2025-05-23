package com.tencent.robot.adelie.homepage.ugc.view;

import android.content.Context;
import android.graphics.Bitmap;
import com.google.gson.Gson;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qcircle.weishi.module.publisher.entity.TemplateBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.adelie.homepage.utils.AdelieAvatarUgcDebugUtil;
import d24.UgcAdelieAvatarTemplateData;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J \u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004J \u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004Jc\u0010 \u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00042!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\f0\u001bJ\u0016\u0010\"\u001a\u00020\f2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0004\u00a8\u0006%"}, d2 = {"Lcom/tencent/robot/adelie/homepage/ugc/view/AdelieUgcUtil;", "", "Ld24/l;", "data", "", "templateDirAbsolutePath", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/io/File;", "srcFile", "parentPath", "Ljava/util/zip/ZipOutputStream;", "zos", "", DomainData.DOMAIN_NAME, "k", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "tmpFileName", "cacheDirName", "e", "tmpDirAbsolutePath", "l", "Landroid/content/Context;", "context", "referImageUrl", "originGeneratedImageUrl", "generatedImageUrl", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "zipFilePath", "callback", "f", "folderToZip", "o", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieUgcUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AdelieUgcUtil f366571a = new AdelieUgcUtil();

    AdelieUgcUtil() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(UgcAdelieAvatarTemplateData data, File templateDir, Function2 fileCallback) {
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(templateDir, "$templateDir");
        Intrinsics.checkNotNullParameter(fileCallback, "$fileCallback");
        AdelieUgcUtil adelieUgcUtil = f366571a;
        String absolutePath = templateDir.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "templateDir.absolutePath");
        adelieUgcUtil.m(data, absolutePath);
        fileCallback.invoke(0, Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(File templateDir, Function2 fileCallback, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(templateDir, "$templateDir");
        Intrinsics.checkNotNullParameter(fileCallback, "$fileCallback");
        if (loadState == LoadState.STATE_SUCCESS) {
            QLog.i("AdelieUgcImageViewModel", 1, "load refer image success");
            AdelieUgcUtil adelieUgcUtil = f366571a;
            Bitmap resultBitMap = option.getResultBitMap();
            Intrinsics.checkNotNullExpressionValue(resultBitMap, "option.resultBitMap");
            String absolutePath = templateDir.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "templateDir.absolutePath");
            adelieUgcUtil.l(resultBitMap, "pad.png", absolutePath);
            fileCallback.invoke(1, Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(File templateDir, Function2 fileCallback, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(templateDir, "$templateDir");
        Intrinsics.checkNotNullParameter(fileCallback, "$fileCallback");
        if (loadState == LoadState.STATE_SUCCESS) {
            QLog.i("AdelieUgcImageViewModel", 1, "load refer image success");
            AdelieUgcUtil adelieUgcUtil = f366571a;
            Bitmap resultBitMap = option.getResultBitMap();
            Intrinsics.checkNotNullExpressionValue(resultBitMap, "option.resultBitMap");
            String absolutePath = templateDir.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "templateDir.absolutePath");
            adelieUgcUtil.l(resultBitMap, "result_origin.png", absolutePath);
            fileCallback.invoke(2, Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(File templateDir, Function2 fileCallback, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(templateDir, "$templateDir");
        Intrinsics.checkNotNullParameter(fileCallback, "$fileCallback");
        if (loadState == LoadState.STATE_SUCCESS) {
            QLog.i("AdelieUgcImageViewModel", 1, "load refer image success");
            AdelieUgcUtil adelieUgcUtil = f366571a;
            Bitmap resultBitMap = option.getResultBitMap();
            Intrinsics.checkNotNullExpressionValue(resultBitMap, "option.resultBitMap");
            String absolutePath = templateDir.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "templateDir.absolutePath");
            adelieUgcUtil.l(resultBitMap, "cover.png", absolutePath);
            fileCallback.invoke(3, Boolean.TRUE);
        }
    }

    private final String k() {
        String format = new SimpleDateFormat("_yyyy_MM_dd_HH_mm_ss", Locale.getDefault()).format(new Date());
        Intrinsics.checkNotNullExpressionValue(format, "sdf.format(Date())");
        return format;
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0051: MOVE (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:82), block:B:28:0x0051 */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String m(UgcAdelieAvatarTemplateData data, String templateDirAbsolutePath) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        File file = new File(templateDirAbsolutePath, TemplateBean.TEMPLATE_JSON);
        if (file.exists()) {
            file.delete();
        }
        String absolutePath = file.getAbsolutePath();
        FileOutputStream fileOutputStream3 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Exception e16) {
                e = e16;
                fileOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (fileOutputStream3 != null) {
                }
                throw th;
            }
            try {
                String json = new Gson().toJson(data);
                Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(data)");
                byte[] bytes = json.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                fileOutputStream.write(bytes);
                fileOutputStream.flush();
                fileOutputStream.close();
                try {
                    fileOutputStream.close();
                } catch (IOException e17) {
                    QLog.d("UgcUtil", 2, e17.getMessage());
                }
                return absolutePath;
            } catch (Exception e18) {
                e = e18;
                QLog.d("UgcUtil", 2, e.getMessage());
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e19) {
                        QLog.d("UgcUtil", 2, e19.getMessage());
                    }
                }
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            fileOutputStream3 = fileOutputStream2;
            if (fileOutputStream3 != null) {
                try {
                    fileOutputStream3.close();
                } catch (IOException e26) {
                    QLog.d("UgcUtil", 2, e26.getMessage());
                }
            }
            throw th;
        }
    }

    private final void n(File srcFile, String parentPath, ZipOutputStream zos) {
        String str;
        if (srcFile.isDirectory()) {
            File[] listFiles = srcFile.listFiles();
            Intrinsics.checkNotNullExpressionValue(listFiles, "srcFile.listFiles()");
            for (File file : listFiles) {
                if (file.isFile()) {
                    str = parentPath;
                } else {
                    str = parentPath + "/" + file.getName();
                }
                Intrinsics.checkNotNullExpressionValue(file, "file");
                n(file, str, zos);
            }
            return;
        }
        FileInputStream fileInputStream = new FileInputStream(srcFile);
        zos.putNextEntry(new ZipEntry(parentPath + "/" + srcFile.getName()));
        byte[] bArr = new byte[1024];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read > 0) {
                zos.write(bArr, 0, read);
            } else {
                zos.closeEntry();
                fileInputStream.close();
                return;
            }
        }
    }

    @Nullable
    public final String e(@NotNull Bitmap bitmap, @NotNull String tmpFileName, @NotNull String cacheDirName) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(tmpFileName, "tmpFileName");
        Intrinsics.checkNotNullParameter(cacheDirName, "cacheDirName");
        File file = new File(VFSAssistantUtils.getSDKPrivatePath(new File(AppConstants.SDCARD_PATH, cacheDirName).getAbsolutePath()));
        if (!file.exists() && !file.mkdirs()) {
            QLog.e("UgcUtil", 1, "mkdir failed " + file.getAbsolutePath());
            return null;
        }
        if (!file.canWrite()) {
            return null;
        }
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "tmpDir.absolutePath");
        return l(bitmap, tmpFileName, absolutePath);
    }

    public final void f(@Nullable final Context context, @Nullable String referImageUrl, @Nullable String originGeneratedImageUrl, @Nullable String generatedImageUrl, @NotNull final UgcAdelieAvatarTemplateData data, @NotNull String cacheDirName, @NotNull final Function1<? super String, Unit> callback) {
        final List mutableListOf;
        boolean z16;
        boolean z17;
        boolean contains$default;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(cacheDirName, "cacheDirName");
        Intrinsics.checkNotNullParameter(callback, "callback");
        File file = new File(AppConstants.SDCARD_PATH, cacheDirName);
        final File file2 = new File(VFSAssistantUtils.getSDKPrivatePath(file.getAbsolutePath()));
        boolean z18 = true;
        if (!file2.exists() && !file2.mkdirs()) {
            QLog.e("UgcUtil", 1, "mkdir failed " + file2.getAbsolutePath());
            return;
        }
        if (!file2.canWrite()) {
            QLog.e("UgcUtil", 1, "dir can not write file. " + file2.getAbsolutePath());
            return;
        }
        String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        final File file3 = new File(VFSAssistantUtils.getSDKPrivatePath(new File(file.getAbsolutePath(), "ugc_template_" + currentUin + "_" + k()).getAbsolutePath()));
        if (!file3.exists() && !file3.mkdirs()) {
            QLog.e("UgcUtil", 1, "mkdir failed " + file3.getAbsolutePath());
            return;
        }
        final String str = file3.getAbsolutePath() + ".zip";
        Boolean bool = Boolean.TRUE;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(bool, bool, bool, bool);
        final Function2<Integer, Boolean, Unit> function2 = new Function2<Integer, Boolean, Unit>() { // from class: com.tencent.robot.adelie.homepage.ugc.view.AdelieUgcUtil$generateUgcTemplateResource$fileCallback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Boolean bool2) {
                invoke(num.intValue(), bool2.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, boolean z19) {
                mutableListOf.set(i3, Boolean.valueOf(z19));
                if (mutableListOf.contains(Boolean.FALSE)) {
                    return;
                }
                AdelieUgcUtil.f366571a.o(file3, str);
                Context context2 = context;
                if (context2 != null) {
                    AdelieAvatarUgcDebugUtil adelieAvatarUgcDebugUtil = AdelieAvatarUgcDebugUtil.f366632a;
                    String absolutePath = file2.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath, "tmpDir.absolutePath");
                    adelieAvatarUgcDebugUtil.e(context2, absolutePath, str);
                }
                callback.invoke(str);
            }
        };
        Boolean bool2 = Boolean.FALSE;
        mutableListOf.set(0, bool2);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.homepage.ugc.view.r
            @Override // java.lang.Runnable
            public final void run() {
                AdelieUgcUtil.g(UgcAdelieAvatarTemplateData.this, file3, function2);
            }
        }, 64, null, false);
        if (referImageUrl != null && referImageUrl.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            mutableListOf.set(1, bool2);
            QQPicLoader qQPicLoader = QQPicLoader.f201806a;
            Option url = Option.obtain().setUrl(referImageUrl);
            Intrinsics.checkNotNullExpressionValue(url, "obtain().setUrl(referImageUrl)");
            qQPicLoader.e(url, new IPicLoadStateListener() { // from class: com.tencent.robot.adelie.homepage.ugc.view.s
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(LoadState loadState, Option option) {
                    AdelieUgcUtil.h(file3, function2, loadState, option);
                }
            });
        }
        if (originGeneratedImageUrl != null && originGeneratedImageUrl.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (!z17) {
            mutableListOf.set(2, bool2);
            QQPicLoader qQPicLoader2 = QQPicLoader.f201806a;
            Option url2 = Option.obtain().setUrl(originGeneratedImageUrl);
            Intrinsics.checkNotNullExpressionValue(url2, "obtain().setUrl(originGeneratedImageUrl)");
            qQPicLoader2.e(url2, new IPicLoadStateListener() { // from class: com.tencent.robot.adelie.homepage.ugc.view.t
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(LoadState loadState, Option option) {
                    AdelieUgcUtil.i(file3, function2, loadState, option);
                }
            });
        }
        if (generatedImageUrl != null && generatedImageUrl.length() != 0) {
            z18 = false;
        }
        if (!z18) {
            mutableListOf.set(3, bool2);
            Option fileOption = Option.obtain();
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) generatedImageUrl, (CharSequence) "http", false, 2, (Object) null);
            if (contains$default) {
                fileOption.setUrl(generatedImageUrl);
            } else {
                fileOption.setLocalPath(generatedImageUrl);
            }
            QQPicLoader qQPicLoader3 = QQPicLoader.f201806a;
            Intrinsics.checkNotNullExpressionValue(fileOption, "fileOption");
            qQPicLoader3.e(fileOption, new IPicLoadStateListener() { // from class: com.tencent.robot.adelie.homepage.ugc.view.u
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(LoadState loadState, Option option) {
                    AdelieUgcUtil.j(file3, function2, loadState, option);
                }
            });
        }
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0067: MOVE (r8 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:104), block:B:28:0x0067 */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String l(@NotNull Bitmap bitmap, @NotNull String tmpFileName, @NotNull String tmpDirAbsolutePath) {
        BufferedOutputStream bufferedOutputStream;
        OutputStream outputStream;
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(tmpFileName, "tmpFileName");
        Intrinsics.checkNotNullParameter(tmpDirAbsolutePath, "tmpDirAbsolutePath");
        File file = new File(tmpDirAbsolutePath, tmpFileName);
        if (file.exists()) {
            file.delete();
        }
        String absolutePath = file.getAbsolutePath();
        OutputStream outputStream2 = null;
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            } catch (Exception e16) {
                e = e16;
                bufferedOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (outputStream2 != null) {
                }
                throw th;
            }
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, bufferedOutputStream);
                bufferedOutputStream.flush();
                try {
                    bufferedOutputStream.close();
                } catch (IOException e17) {
                    QLog.d("UgcUtil", 2, e17.getMessage());
                }
                return absolutePath;
            } catch (Exception e18) {
                e = e18;
                QLog.d("UgcUtil", 2, e.getMessage());
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e19) {
                        QLog.d("UgcUtil", 2, e19.getMessage());
                    }
                }
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            outputStream2 = outputStream;
            if (outputStream2 != null) {
                try {
                    outputStream2.close();
                } catch (IOException e26) {
                    QLog.d("UgcUtil", 2, e26.getMessage());
                }
            }
            throw th;
        }
    }

    public final void o(@NotNull File folderToZip, @NotNull String zipFilePath) {
        Intrinsics.checkNotNullParameter(folderToZip, "folderToZip");
        Intrinsics.checkNotNullParameter(zipFilePath, "zipFilePath");
        FileOutputStream fileOutputStream = new FileOutputStream(zipFilePath);
        ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
        String name = folderToZip.getName();
        Intrinsics.checkNotNullExpressionValue(name, "folderToZip.name");
        n(folderToZip, name, zipOutputStream);
        zipOutputStream.close();
        fileOutputStream.close();
    }
}
