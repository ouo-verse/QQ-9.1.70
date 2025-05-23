package com.tencent.mobileqq.wink.utils;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/wink/utils/ab;", "", "Ljava/io/File;", "a", "", WadlProxyConsts.PARAM_FILENAME, "b", "Ljava/lang/String;", "PATH_TEXT_STICKER_CONFIG", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ab {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ab f326657a = new ab();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String PATH_TEXT_STICKER_CONFIG = u53.f.f438388a + File.separator + "uin_files";

    ab() {
    }

    private final File a() throws IOException {
        String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        File createDirectory = FileUtils.createDirectory(PATH_TEXT_STICKER_CONFIG + File.separator + account);
        Intrinsics.checkNotNullExpressionValue(createDirectory, "createDirectory(PATH_TEX\u2026G + File.separator + uin)");
        return createDirectory;
    }

    @NotNull
    public final String b(@NotNull String fileName) throws IOException {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        return a().getPath() + File.separator + fileName;
    }
}
