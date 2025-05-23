package mqq.util;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lmqq/util/MqqConfigUtil;", "", "()V", "CONFIG_DIR_ROOT", "", "getConfigFile", "Ljava/io/File;", WadlProxyConsts.PARAM_FILENAME, "mqq_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class MqqConfigUtil {

    @NotNull
    private static final String CONFIG_DIR_ROOT = "mqqconfig";

    @NotNull
    public static final MqqConfigUtil INSTANCE = new MqqConfigUtil();

    MqqConfigUtil() {
    }

    @NotNull
    public final File getConfigFile(@NotNull String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        return new File(BaseApplication.getContext().getFilesDir(), "mqqconfig/" + fileName);
    }
}
