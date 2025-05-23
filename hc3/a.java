package hc3;

import com.tencent.mobileqq.zootopia.ipc.handle_ipc.HandlerIPCImpl;
import com.tencent.mobileqq.zplan.ipc.annotation.ServletImpl;
import kotlin.Metadata;
import org.json.JSONObject;
import vb3.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lhc3/a;", "Lvb3/b;", "Lorg/json/JSONObject;", "data", "", "toMain", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
@ServletImpl(impl = HandlerIPCImpl.class)
/* loaded from: classes38.dex */
public interface a extends b {
    boolean toMain(JSONObject data);
}
