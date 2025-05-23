package com.tencent.mobileqq.vas.social.config;

import com.tencent.biz.common.util.ZipUtils;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.state.square.IZipUtils;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ \u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0016JD\u0010\u0010\u001a\u00020\u000e2:\u0010\u000f\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tH\u0016J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0006H\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/vas/social/config/w;", "Lcom/tencent/biz/common/util/ZipUtils;", "Lcom/tencent/state/square/IZipUtils;", "Ljava/io/File;", "zipFile", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getZipFileList", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "file", "folderPath", "", "cb", IECSearchBar.METHOD_SET_CALLBACK, "zipFilePath", "", "unZip", "pattern", "path", "", "isDirectoryExists", "directory", WadlProxyConsts.PARAM_FILENAME, "findFileInDirectory", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class w extends ZipUtils implements IZipUtils {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function2 cb5, File file, String str) {
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        cb5.invoke(file, str);
    }

    @Override // com.tencent.state.square.IZipUtils
    public String findFileInDirectory(File directory, String fileName) {
        File[] listFiles;
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        if (directory.isDirectory() && (listFiles = directory.listFiles()) != null) {
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    Intrinsics.checkNotNullExpressionValue(file, "file");
                    String findFileInDirectory = findFileInDirectory(file, fileName);
                    if (findFileInDirectory != null) {
                        return findFileInDirectory;
                    }
                } else if (Intrinsics.areEqual(file.getName(), fileName)) {
                    return file.getAbsolutePath();
                }
            }
        }
        return null;
    }

    @Override // com.tencent.state.square.IZipUtils
    public ArrayList<String> getZipFileList(File zipFile) {
        Intrinsics.checkNotNullParameter(zipFile, "zipFile");
        try {
            ArrayList<String> entriesNames = ZipUtils.getEntriesNames(zipFile);
            Intrinsics.checkNotNullExpressionValue(entriesNames, "{\n            getEntriesNames(zipFile)\n        }");
            return entriesNames;
        } catch (Throwable unused) {
            return new ArrayList<>();
        }
    }

    @Override // com.tencent.state.square.IZipUtils
    public boolean isDirectoryExists(String pattern, String path) {
        File[] listFiles;
        int indexOf$default;
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Intrinsics.checkNotNullParameter(path, "path");
        File file = new File(path);
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    String name = file2.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "file.name");
                    indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) name, pattern, 0, false, 6, (Object) null);
                    if (indexOf$default != -1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.tencent.state.square.IZipUtils
    public void setCallback(final Function2<? super File, ? super String, Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        ZipUtils.setUnzipCallback(new ZipUtils.UnzipCallback() { // from class: com.tencent.mobileqq.vas.social.config.v
            @Override // com.tencent.biz.common.util.ZipUtils.UnzipCallback
            public final void onFileUnzip(File file, String str) {
                w.b(Function2.this, file, str);
            }
        });
    }

    @Override // com.tencent.state.square.IZipUtils
    public int unZip(String zipFilePath, String folderPath) {
        Intrinsics.checkNotNullParameter(zipFilePath, "zipFilePath");
        Intrinsics.checkNotNullParameter(folderPath, "folderPath");
        if (new File(folderPath).exists()) {
            return 0;
        }
        return ZipUtils.unZipFolder(zipFilePath, folderPath);
    }
}
