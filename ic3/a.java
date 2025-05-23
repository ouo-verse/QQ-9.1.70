package ic3;

import com.tencent.mobileqq.zootopia.loadingid.ModLoadingIdServiceImpl;
import com.tencent.mobileqq.zplan.ipc.annotation.ServletImpl;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\t"}, d2 = {"Lic3/a;", "", "", "mapId", "", "getLoadingId", "", "modExit", "modLoadFinish", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
@ServletImpl(impl = ModLoadingIdServiceImpl.class)
/* loaded from: classes38.dex */
public interface a {
    String getLoadingId(int mapId);

    void modExit(int mapId);

    void modLoadFinish(int mapId);
}
