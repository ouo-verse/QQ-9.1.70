package com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow;

import com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow.QFSBottomConfigRecycleAdapter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\n\u001a\u00020\u0004R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/configguidefollow/i;", "", "Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/configguidefollow/QFSBottomConfigRecycleAdapter$ShowScene;", "showScene", "", "a", "", "feedId", "", "c", "b", "Ljava/lang/String;", "curFeedId", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f90684a = new i();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String curFeedId;

    i() {
    }

    public final boolean a(@NotNull QFSBottomConfigRecycleAdapter.ShowScene showScene) {
        Intrinsics.checkNotNullParameter(showScene, "showScene");
        if (showScene == QFSBottomConfigRecycleAdapter.ShowScene.SCENE_FOLLOW_AUTHOR) {
            return true;
        }
        return false;
    }

    public final boolean b() {
        boolean z16;
        String str = curFeedId;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        return !z16;
    }

    public final void c(@Nullable String feedId) {
        curFeedId = feedId;
        QLog.i("QFSFeedBottomPYMLSceneManager", 1, "saveFollowAuthorScene, curFeedId:" + feedId);
    }
}
