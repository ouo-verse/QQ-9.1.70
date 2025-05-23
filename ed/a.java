package ed;

import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J \u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H&J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0007H&J \u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\tH&J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000bH&J \u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\rH&J-\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\n\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Led/a;", "", "", "mainKey", "secondKey", RemoteHandleConst.PARAM_DEFAULT_VALUE, "a", "", "b", "", "getConfig", "", "c", "", "d", "T", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public interface a {
    String a(String mainKey, String secondKey, String defaultValue);

    boolean b(String mainKey, String secondKey, boolean defaultValue);

    long c(String mainKey, String secondKey, long defaultValue);

    float d(String mainKey, String secondKey, float defaultValue);

    int getConfig(String mainKey, String secondKey, int defaultValue);

    <T> T getConfig(String mainKey, String secondKey, T defaultValue);
}
