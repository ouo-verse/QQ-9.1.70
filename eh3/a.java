package eh3;

import com.tencent.mobileqq.zplan.api.IZplanHandleApi;
import com.tencent.mobileqq.zplan.dresskey.impl.DressInfoIPCImpl;
import com.tencent.mobileqq.zplan.ipc.annotation.ServletImpl;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\t"}, d2 = {"Leh3/a;", "", "", "scene", "", IZplanHandleApi.METHOD_REFRESH_DRESS_INFO, "Leh3/b;", "callback", "getDefaultAvatarCharacter", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
@ServletImpl(impl = DressInfoIPCImpl.class)
/* loaded from: classes38.dex */
public interface a {
    void getDefaultAvatarCharacter(b callback);

    void refreshDressInfo(String scene);
}
