package com.tencent.state.square;

import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J \u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\tj\b\u0012\u0004\u0012\u00020\u0004`\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0016JD\u0010\u0010\u001a\u00020\u00112:\u0010\u0012\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00110\u0013H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/state/square/DefaultZipUtils;", "Lcom/tencent/state/square/IZipUtils;", "()V", "findFileInDirectory", "", "directory", "Ljava/io/File;", WadlProxyConsts.PARAM_FILENAME, "getZipFileList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "zipFile", "isDirectoryExists", "", "pattern", "path", IECSearchBar.METHOD_SET_CALLBACK, "", "cb", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "file", "folderPath", "unZip", "", "zipFilePath", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public class DefaultZipUtils implements IZipUtils {
    @Override // com.tencent.state.square.IZipUtils
    @Nullable
    public String findFileInDirectory(@NotNull File directory, @NotNull String fileName) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        return null;
    }

    @Override // com.tencent.state.square.IZipUtils
    @NotNull
    public ArrayList<String> getZipFileList(@NotNull File zipFile) {
        Intrinsics.checkNotNullParameter(zipFile, "zipFile");
        return new ArrayList<>();
    }

    @Override // com.tencent.state.square.IZipUtils
    public boolean isDirectoryExists(@NotNull String pattern, @NotNull String path) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Intrinsics.checkNotNullParameter(path, "path");
        return false;
    }

    @Override // com.tencent.state.square.IZipUtils
    public void setCallback(@NotNull Function2<? super File, ? super String, Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
    }

    @Override // com.tencent.state.square.IZipUtils
    public int unZip(@NotNull String zipFilePath, @NotNull String folderPath) {
        Intrinsics.checkNotNullParameter(zipFilePath, "zipFilePath");
        Intrinsics.checkNotNullParameter(folderPath, "folderPath");
        return 0;
    }
}
