package defpackage;

import com.tencent.mobileqq.activity.qcircle.utils.g;
import com.tencent.mobileqq.perf.report.a;
import com.tencent.mobileqq.zootopia.ipc.f;
import com.tencent.qphone.base.util.QLog;
import k74.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u0002H\u0016R\u0016\u0010\u0011\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0001\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0016\u0010\b\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0010R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0010\u00a8\u0006\u001a"}, d2 = {"LUEBuglyInfoRecorder;", "Lc;", "", "i", "", "sceneType", "onAvatarSceneEnter", "onAvatarSceneExit", "mapId", "", "mapName", "f", "onSmallHomeExit", "g", h.F, "b", "Ljava/lang/String;", "currentSceneType", "", "Z", "isSmallHomeRunning", "d", "isFront", "e", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class UEBuglyInfoRecorder implements c {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean isSmallHomeRunning;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static boolean isFront;

    /* renamed from: a, reason: collision with root package name */
    public static final UEBuglyInfoRecorder f25109a = new UEBuglyInfoRecorder();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static String currentSceneType = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static String mapId = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static String mapName = "";

    UEBuglyInfoRecorder() {
    }

    private final void i() {
        g.e(new Function0<Unit>() { // from class: UEBuglyInfoRecorder$updateBuglyInfo$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String str;
                String str2;
                String str3;
                boolean z16;
                boolean z17;
                try {
                    str = UEBuglyInfoRecorder.mapId;
                    str2 = UEBuglyInfoRecorder.mapName;
                    str3 = UEBuglyInfoRecorder.currentSceneType;
                    z16 = UEBuglyInfoRecorder.isSmallHomeRunning;
                    boolean isFloat = ((f) i.INSTANCE.a(f.class)).isFloat();
                    z17 = UEBuglyInfoRecorder.isFront;
                    String str4 = "mapId:" + str + ", mapName:" + str2 + ", sceneType:" + str3 + ", isSmallHomeRunning:" + z16 + ", isFloat:" + isFloat + ", isFront:" + z17;
                    QLog.i("UEBuglyInfoRecorder", 1, "updateBuglyInfo buglyInfo:" + str4);
                    a.f258013b = str4;
                } catch (Exception e16) {
                    QLog.e("UEBuglyInfoRecorder", 1, "updateBuglyInfo exception :: ", e16);
                }
            }
        });
    }

    public void f(int mapId2, String mapName2) {
        Intrinsics.checkNotNullParameter(mapName2, "mapName");
        QLog.i("UEBuglyInfoRecorder", 1, "onSmallHomeEnter mapId:" + mapId2);
        isSmallHomeRunning = true;
        onAvatarSceneEnter(7);
        mapId = String.valueOf(mapId2);
        mapName = mapName2;
        i();
    }

    public void h() {
        QLog.i("UEBuglyInfoRecorder", 1, "onUEActivityResume");
        isFront = true;
        i();
    }

    @Override // defpackage.c
    public void onAvatarSceneEnter(int sceneType) {
        QLog.i("UEBuglyInfoRecorder", 1, "onAvatarSceneEnter sceneType:" + sceneType);
        currentSceneType = String.valueOf(sceneType);
        i();
    }

    @Override // defpackage.c
    public void onAvatarSceneExit(int sceneType) {
        QLog.i("UEBuglyInfoRecorder", 1, "onAvatarSceneExit sceneType:" + sceneType);
        if (Intrinsics.areEqual(String.valueOf(sceneType), currentSceneType)) {
            if (sceneType == 7) {
                if (!((f) i.INSTANCE.a(f.class)).isFloat()) {
                    currentSceneType = "";
                }
            } else {
                currentSceneType = "";
            }
            i();
        }
    }

    public void g() {
        QLog.i("UEBuglyInfoRecorder", 1, "onUEActivityPause");
        isFront = false;
        i();
    }

    @Override // defpackage.c
    public void onSmallHomeExit() {
        QLog.i("UEBuglyInfoRecorder", 1, "onSmallHomeExit");
        isSmallHomeRunning = false;
        isFront = false;
        mapId = "";
        mapName = "";
        if (Intrinsics.areEqual(currentSceneType, "7")) {
            currentSceneType = "";
        }
        i();
    }
}
