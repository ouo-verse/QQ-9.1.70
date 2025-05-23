package f72;

import com.tencent.qqnt.kernel.nativeinterface.ScanQrRspInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J$\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\f"}, d2 = {"Lf72/a;", "", "", "result", "", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/ScanQrRspInfo;", "info", "", "a", "jmpUrl", "b", "qqlogin-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public interface a {
    void a(int result, @Nullable String errMsg, @Nullable ScanQrRspInfo info);

    void b(int result, @Nullable String errMsg, @Nullable String jmpUrl);
}
