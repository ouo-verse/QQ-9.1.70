package com.tencent.mobileqq.vas.pendant;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.image.AbsAsyncDrawable;
import com.tencent.mobileqq.vas.image.ILoaderSucessCallback;
import com.tencent.mobileqq.vas.image.c;
import com.tencent.mobileqq.vas.pendant.api.IPendantManager;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001c\u0010\u0005\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u0018\u001a\u0012\u0012\u0002\b\u0003 \u0015*\b\u0012\u0002\b\u0003\u0018\u00010\u00140\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/vas/pendant/RecentPendantDrawable;", "Lcom/tencent/mobileqq/vas/image/c;", "Lkotlin/Function1;", "", "block", "setLoadedListener", "", "isLoadSucess", "Lcom/tencent/mobileqq/vas/image/ILoaderSucessCallback;", "callback", "doLoadTask", "Landroid/graphics/Canvas;", PM.CANVAS, "draw", "", "d", "I", "y", "()I", "id", "Lcom/tencent/mobileqq/vas/updatesystem/business/QQVasUpdateBusiness;", "kotlin.jvm.PlatformType", "e", "Lcom/tencent/mobileqq/vas/updatesystem/business/QQVasUpdateBusiness;", "business", "<init>", "(I)V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class RecentPendantDrawable extends c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int id;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final QQVasUpdateBusiness<?> business = ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance((Long) 4L);

    public RecentPendantDrawable(int i3) {
        this.id = i3;
        setTargetDrawableBuild(new Function0<Drawable>() { // from class: com.tencent.mobileqq.vas.pendant.RecentPendantDrawable.1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Drawable invoke() {
                return ((IPendantManager) QRoute.api(IPendantManager.class)).getPendantDrawable(RecentPendantDrawable.this.getId());
            }
        });
        AbsAsyncDrawable.load$default(this, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(RecentPendantDrawable this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AbsAsyncDrawable.load$default(this$0, false, 1, null);
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
    public void doLoadTask(@NotNull ILoaderSucessCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        QQVasUpdateBusiness<?> qQVasUpdateBusiness = this.business;
        qQVasUpdateBusiness.addDownLoadListener(qQVasUpdateBusiness.getScid(this.id), new Runnable() { // from class: com.tencent.mobileqq.vas.pendant.a
            @Override // java.lang.Runnable
            public final void run() {
                RecentPendantDrawable.x(RecentPendantDrawable.this);
            }
        });
        this.business.startDownload(this.id);
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable, android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Drawable currentDrawable = getCurrentDrawable();
        if (currentDrawable == null) {
            return;
        }
        int intrinsicWidth = currentDrawable.getIntrinsicWidth();
        int intrinsicHeight = currentDrawable.getIntrinsicHeight();
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        int i3 = height / 9;
        int i16 = (width - ((intrinsicWidth * height) / intrinsicHeight)) / 2;
        setBounds(i16, -i3, width - i16, height - i3);
        super.draw(canvas);
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
    public boolean isLoadSucess() {
        if (!this.business.isFileExists(this.id)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.vas.image.c
    public void setLoadedListener(@NotNull Function1<? super c, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
    }

    /* renamed from: y, reason: from getter */
    public final int getId() {
        return this.id;
    }
}
