package com.tencent.mobileqq.zplan.drawable;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Process;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.map.geolocation.TencentLocation;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00032\u00020\u00012\u00020\u0002:\u0002\u0004\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/zplan/drawable/ZPlanAnimationDrawable;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Animatable;", "d", "a", "DecodeWorker", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ZPlanAnimationDrawable extends Drawable implements Animatable {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zplan/drawable/ZPlanAnimationDrawable$DecodeWorker;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "", "d", "I", AIInput.KEY_FRAME, "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    private final class DecodeWorker implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int frame;
        final /* synthetic */ ZPlanAnimationDrawable this$0;

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            Bitmap b16 = ZPlanAnimationDrawable.b(null, false, this.frame);
            if (b16 == null) {
                return;
            }
            if (ZPlanAnimationDrawable.a(null, this.frame)) {
                synchronized (ZPlanAnimationDrawable.d(null)) {
                    ZPlanAnimationDrawable.f(null, this.frame);
                    ZPlanAnimationDrawable.e(null, b16);
                    Unit unit = Unit.INSTANCE;
                }
                throw null;
            }
            throw null;
        }
    }

    public static final /* synthetic */ boolean a(ZPlanAnimationDrawable zPlanAnimationDrawable, int i3) {
        throw null;
    }

    public static final /* synthetic */ Bitmap b(ZPlanAnimationDrawable zPlanAnimationDrawable, boolean z16, int i3) {
        throw null;
    }

    public static final /* synthetic */ Object d(ZPlanAnimationDrawable zPlanAnimationDrawable) {
        throw null;
    }

    public static final /* synthetic */ void e(ZPlanAnimationDrawable zPlanAnimationDrawable, Bitmap bitmap) {
        throw null;
    }

    public static final /* synthetic */ void f(ZPlanAnimationDrawable zPlanAnimationDrawable, int i3) {
        throw null;
    }
}
