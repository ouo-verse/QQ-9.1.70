package dx3;

import com.tencent.qqnt.kernel.nativeinterface.IGetLoginRecordFromWTCallback;
import com.tencent.qqnt.kernel.nativeinterface.WTLoginRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH&\u00a8\u0006\u0010"}, d2 = {"Ldx3/d;", "", "", "a", "", "uin", "", "appid", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetLoginRecordFromWTCallback;", "cb", "", "getWTLoginRecord", "deleteWTLoginRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/WTLoginRecord;", "loginRecord", "addWTLoginRecordFromNT", "kernel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface d {
    boolean a();

    void addWTLoginRecordFromNT(@NotNull WTLoginRecord loginRecord);

    void deleteWTLoginRecord(long uin, int appid);

    void getWTLoginRecord(long uin, int appid, @NotNull IGetLoginRecordFromWTCallback cb5);
}
