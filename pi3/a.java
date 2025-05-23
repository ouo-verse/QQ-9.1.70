package pi3;

import com.tencent.mobileqq.zplan.ipc.annotation.ServletImpl;
import com.tencent.mobileqq.zplan.meme.ipc.ZPlanMemeIPCImpl;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\b"}, d2 = {"Lpi3/a;", "", "", "jsonParams", "", "appearanceKeyChangeFromEngine", "avatarSceneParams", "notifyEnterAvatarScene", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
@ServletImpl(impl = ZPlanMemeIPCImpl.class)
/* loaded from: classes36.dex */
public interface a {
    void appearanceKeyChangeFromEngine(String jsonParams);

    void notifyEnterAvatarScene(String avatarSceneParams);
}
