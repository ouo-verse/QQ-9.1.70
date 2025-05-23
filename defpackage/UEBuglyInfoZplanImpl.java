package defpackage;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"LUEBuglyInfoZplanImpl;", "Lc;", "", "sceneType", "", "onAvatarSceneEnter", "onAvatarSceneExit", "mapId", "", "mapName", "onSmallHomeEnter", "onSmallHomeExit", "onUEActivityPause", "onUEActivityResume", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class UEBuglyInfoZplanImpl implements c {
    private static final String TAG = "UEBuglyInfoZplanImpl";

    @Override // defpackage.c
    public void onAvatarSceneEnter(int sceneType) {
        QLog.i(TAG, 1, "onAvatarSceneEnter sceneType:" + sceneType);
        UEBuglyInfoRecorder.f25109a.onAvatarSceneEnter(sceneType);
    }

    @Override // defpackage.c
    public void onAvatarSceneExit(int sceneType) {
        QLog.i(TAG, 1, "onAvatarSceneExit sceneType:" + sceneType);
        UEBuglyInfoRecorder.f25109a.onAvatarSceneExit(sceneType);
    }

    public void onSmallHomeEnter(int mapId, String mapName) {
        Intrinsics.checkNotNullParameter(mapName, "mapName");
        QLog.i(TAG, 1, "onSmallHomeEnter mapId:" + mapId);
        UEBuglyInfoRecorder.f25109a.f(mapId, mapName);
    }

    @Override // defpackage.c
    public void onSmallHomeExit() {
        QLog.i(TAG, 1, "onSmallHomeExit");
        UEBuglyInfoRecorder.f25109a.onSmallHomeExit();
    }

    public void onUEActivityPause() {
        QLog.i(TAG, 1, "onUEActivityPause");
        UEBuglyInfoRecorder.f25109a.g();
    }

    public void onUEActivityResume() {
        QLog.i(TAG, 1, "onUEActivityResume");
        UEBuglyInfoRecorder.f25109a.h();
    }
}
