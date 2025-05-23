package com.tencent.state.square;

import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J \u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00030\bj\b\u0012\u0004\u0012\u00020\u0003`\t2\u0006\u0010\n\u001a\u00020\u0005H&J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H&JD\u0010\u000f\u001a\u00020\u00102:\u0010\u0011\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00100\u0012H&J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003H&\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/state/square/IZipUtils;", "", "findFileInDirectory", "", "directory", "Ljava/io/File;", WadlProxyConsts.PARAM_FILENAME, "getZipFileList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "zipFile", "isDirectoryExists", "", "pattern", "path", IECSearchBar.METHOD_SET_CALLBACK, "", "cb", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "file", "folderPath", "unZip", "", "zipFilePath", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public interface IZipUtils {
    @Nullable
    String findFileInDirectory(@NotNull File directory, @NotNull String fileName);

    @NotNull
    ArrayList<String> getZipFileList(@NotNull File zipFile);

    boolean isDirectoryExists(@NotNull String pattern, @NotNull String path);

    void setCallback(@NotNull Function2<? super File, ? super String, Unit> cb5);

    int unZip(@NotNull String zipFilePath, @NotNull String folderPath);
}
