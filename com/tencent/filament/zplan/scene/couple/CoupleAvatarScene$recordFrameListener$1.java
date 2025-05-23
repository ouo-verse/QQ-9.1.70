package com.tencent.filament.zplan.scene.couple;

import com.tencent.filament.zplan.app.impl.FilamentNativeAppV2305;
import com.tencent.filament.zplan.d;
import com.tencent.filament.zplan.scene.couple.config.SceneConfig;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import dl0.c;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/filament/zplan/scene/couple/CoupleAvatarScene$recordFrameListener$1", "Lcom/tencent/filament/zplan/d;", "", "pixels", "", "width", "height", "", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class CoupleAvatarScene$recordFrameListener$1 implements d {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CoupleAvatarScene f105918a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ WeakReference f105919b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CoupleAvatarScene$recordFrameListener$1(CoupleAvatarScene coupleAvatarScene, WeakReference weakReference) {
        this.f105918a = coupleAvatarScene;
        this.f105919b = weakReference;
    }

    @Override // com.tencent.filament.zplan.d
    public void a(@Nullable byte[] pixels, int width, int height) {
        SceneConfig sceneConfig;
        Integer num;
        boolean z16;
        boolean z17;
        sceneConfig = this.f105918a.sceneConfig;
        if (sceneConfig != null) {
            num = Integer.valueOf(sceneConfig.getSceneId());
        } else {
            num = null;
        }
        FLog fLog = FLog.INSTANCE;
        fLog.i("CoupleAvatarScene", "onRecordFrame, width:" + width + ", height:" + height + ", sceneId:" + num);
        FilamentNativeAppV2305 filamentNativeAppV2305 = (FilamentNativeAppV2305) this.f105919b.get();
        if (filamentNativeAppV2305 != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(WadlProxyConsts.SCENE_ID, num);
            z16 = this.f105918a.hasDownloadFromNet;
            jSONObject.put("hasNetProcess", z16);
            z17 = this.f105918a.hasPaused;
            jSONObject.put("hasPaused", z17);
            Unit unit = Unit.INSTANCE;
            filamentNativeAppV2305.dispatchEvent(null, "onFirstFrameRenderEnd", jSONObject.toString());
        }
        if ((pixels == null || pixels.length != 0) && width != 0 && height != 0) {
            c cVar = (c) fl0.a.f399763a.a(c.class);
            if (cVar == null) {
                fLog.e("CoupleAvatarScene", "fileProxy is null");
                return;
            }
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new CoupleAvatarScene$recordFrameListener$1$onRecordFrame$2(this, pixels, width, height, cVar.b() + "/ZPlanNative/FirstFrameImage/image_" + String.valueOf(System.nanoTime()) + ".png", num, null), 3, null);
        }
    }
}
