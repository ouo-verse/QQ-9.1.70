package com.tencent.filament.zplan.view.controller;

import android.graphics.Bitmap;
import com.tencent.filament.zplan.listener.GYScreenShotListener;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.zplan.meme.encoder.a;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/filament/zplan/view/controller/GYFZPlanController$takeScreenShot$1$result$1", "Lcom/tencent/filament/zplan/listener/GYScreenShotListener;", "onScreenShot", "", "pixels", "", "width", "", "height", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class GYFZPlanController$takeScreenShot$1$result$1 implements GYScreenShotListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ GYFZPlanController$takeScreenShot$1 f106341a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GYFZPlanController$takeScreenShot$1$result$1(GYFZPlanController$takeScreenShot$1 gYFZPlanController$takeScreenShot$1) {
        this.f106341a = gYFZPlanController$takeScreenShot$1;
    }

    @Override // com.tencent.filament.zplan.listener.GYScreenShotListener
    public void onScreenShot(@Nullable byte[] pixels, int width, int height) {
        Bitmap bitmap;
        FLog.INSTANCE.i("GYFZPlanController", "instance callback");
        if (pixels != null) {
            bitmap = a.Companion.b(com.tencent.zplan.meme.encoder.a.INSTANCE, pixels, width, height, null, 4, null);
        } else {
            bitmap = null;
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new GYFZPlanController$takeScreenShot$1$result$1$onScreenShot$1(this, pixels, width, height, bitmap, null), 3, null);
    }
}
