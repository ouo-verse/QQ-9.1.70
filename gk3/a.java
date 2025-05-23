package gk3;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.zootopia.api.e;
import kotlin.Metadata;
import lv4.d;
import lv4.h;
import lv4.l;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J4\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&J4\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0007H&J\"\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00022\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0007H&J\"\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00022\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0007H&J\b\u0010\u0014\u001a\u00020\u0002H&J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0002H&J\u0018\u0010\u0019\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H&J\u0012\u0010\u001b\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u0002H&\u00a8\u0006\u001c"}, d2 = {"Lgk3/a;", "Lvb3/b;", "", "openId", "componentId", "", "roomType", "Lcom/tencent/mobileqq/zootopia/api/e;", "Llv4/b;", "callback", "", "P0", "uniqueRoomId", "Llv4/h;", "e", "roomId", "Llv4/l;", "K0", "Llv4/d;", "O", "N0", "Lhk3/b;", "g", "Lgk3/c;", "listener", BdhLogUtil.LogTag.Tag_Conn, "from", "L0", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public interface a extends vb3.b {
    void C(String roomId, c listener);

    void K0(String roomId, e<l> callback);

    void L0(String from);

    String N0();

    void O(String roomId, e<d> callback);

    void P0(String openId, String componentId, int roomType, e<lv4.b> callback);

    void e(String uniqueRoomId, String openId, String componentId, e<h> callback);

    hk3.b g(String roomId);
}
