package com.tencent.mobileqq.zplan.avatar.impl.scene;

import com.tencent.mobileqq.zootopia.scene.data.SceneInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import xe3.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016R!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/impl/scene/UESceneEnterRecorder;", "Lxe3/a;", "Lcom/tencent/mobileqq/zootopia/scene/data/c;", "sceneInfo", "", "rootScene", "", "F0", "k0", "Q0", "Ljava/util/LinkedList;", "c", "Lkotlin/Lazy;", "U0", "()Ljava/util/LinkedList;", "mEnterSceneInfoList", "d", "Lcom/tencent/mobileqq/zootopia/scene/data/c;", "mLastEnterSceneInfo", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class UESceneEnterRecorder implements a {

    /* renamed from: b, reason: collision with root package name */
    public static final UESceneEnterRecorder f331958b = new UESceneEnterRecorder();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Lazy mEnterSceneInfoList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static SceneInfo mLastEnterSceneInfo;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LinkedList<SceneInfo>>() { // from class: com.tencent.mobileqq.zplan.avatar.impl.scene.UESceneEnterRecorder$mEnterSceneInfoList$2
            @Override // kotlin.jvm.functions.Function0
            public final LinkedList<SceneInfo> invoke() {
                return new LinkedList<>();
            }
        });
        mEnterSceneInfoList = lazy;
        mLastEnterSceneInfo = SceneInfo.INSTANCE.c();
    }

    UESceneEnterRecorder() {
    }

    private final LinkedList<SceneInfo> U0() {
        return (LinkedList) mEnterSceneInfoList.getValue();
    }

    @Override // xe3.a
    public synchronized void F0(SceneInfo sceneInfo, boolean rootScene) {
        Intrinsics.checkNotNullParameter(sceneInfo, "sceneInfo");
        QLog.i("UESceneEnterRecorder_", 1, "enterAvatarSceneHappened rootScene:" + rootScene + ", sceneInfo:" + sceneInfo);
        if (rootScene) {
            U0().clear();
            U0().add(sceneInfo);
        } else {
            SceneInfo peekLast = U0().peekLast();
            if (peekLast == null) {
                U0().add(sceneInfo);
            } else if (peekLast.m(sceneInfo)) {
                QLog.i("UESceneEnterRecorder_", 1, "enterAvatarSceneHappened is same with last:" + sceneInfo);
            } else {
                U0().add(sceneInfo);
            }
        }
        mLastEnterSceneInfo = sceneInfo;
        QLog.i("UESceneEnterRecorder_", 1, "enterAvatarSceneHappened after.List:" + U0());
    }

    @Override // xe3.a
    public SceneInfo Q0() {
        return mLastEnterSceneInfo;
    }

    @Override // xe3.a
    public void k0(SceneInfo sceneInfo) {
        Intrinsics.checkNotNullParameter(sceneInfo, "sceneInfo");
        SceneInfo peekLast = U0().peekLast();
        if (peekLast != null && peekLast.m(sceneInfo)) {
            U0().pollLast();
            QLog.i("UESceneEnterRecorder_", 1, "exitAvatarSceneHappened pollLast:" + peekLast);
        } else {
            QLog.w("UESceneEnterRecorder_", 1, "exitAvatarSceneHappened last is not target!sceneInfo:" + sceneInfo + ", last:" + peekLast);
        }
        QLog.i("UESceneEnterRecorder_", 1, "exitAvatarSceneHappened after.List:" + U0());
    }
}
