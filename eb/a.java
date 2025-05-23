package eb;

import cooperation.qzone.cache.QZoneFilePath;
import java.io.File;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\u00a8\u0006\f"}, d2 = {"Leb/a;", "", "", "b", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "DOWNLOAD_STRATEGY_ROOT_PATH", "c", "PUBLISHX_TEMP_FILE_ROOT_PATH", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f396056a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String DOWNLOAD_STRATEGY_ROOT_PATH;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final String PUBLISHX_TEMP_FILE_ROOT_PATH;

    static {
        String str = QZoneFilePath.ROOT_QZONE_PATH;
        String str2 = File.separator;
        DOWNLOAD_STRATEGY_ROOT_PATH = str + str2 + "qzone_albumx" + str2;
        PUBLISHX_TEMP_FILE_ROOT_PATH = str + str2 + "publishx" + str2;
    }

    a() {
    }

    public final String a() {
        return DOWNLOAD_STRATEGY_ROOT_PATH;
    }

    public final String b() {
        return PUBLISHX_TEMP_FILE_ROOT_PATH;
    }
}
