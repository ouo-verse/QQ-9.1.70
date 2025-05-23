package com.tencent.mobileqq.vas.troop.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.cachedrawable.dynamicdrawable.api.a;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k;
import com.tencent.cachedrawable.dynamicdrawable.d;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.troop.ITroopNickManager;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.TroopNickNameBusiness;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqnt.aio.nick.i;
import cooperation.qzone.QZoneClickReport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\"\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vas/troop/impl/TroopNickManagerImpl;", "Lcom/tencent/mobileqq/vas/troop/ITroopNickManager;", "", "scid", "Lcom/tencent/qqnt/aio/nick/i;", "drawInfo", "", NodeProps.MAX_WIDTH, "Lcom/tencent/qqnt/aio/nick/c;", "setCustomCloth", "<init>", "()V", "Companion", "a", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class TroopNickManagerImpl implements ITroopNickManager {
    private static final int MIN_HEIGHT_SIZE = ViewUtils.dip2px(10.0f);

    @Override // com.tencent.mobileqq.vas.troop.ITroopNickManager
    @Nullable
    public com.tencent.qqnt.aio.nick.c setCustomCloth(long scid, @NotNull i drawInfo, int maxWidth) {
        Intrinsics.checkNotNullParameter(drawInfo, "drawInfo");
        if (scid <= 0) {
            return null;
        }
        String path = ((TroopNickNameBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(TroopNickNameBusiness.class)).getSavePath((int) scid);
        a.C1005a a16 = com.tencent.cachedrawable.dynamicdrawable.api.a.a();
        Intrinsics.checkNotNullExpressionValue(path, "path");
        FastDynamicDrawable a17 = a16.d(path).c(com.tencent.cachedrawable.dynamicdrawable.decoder.b.f99048a).h(new Function1<k, Unit>() { // from class: com.tencent.mobileqq.vas.troop.impl.TroopNickManagerImpl$setCustomCloth$cacheDrawable$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(k kVar) {
                invoke2(kVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull k it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.H(false);
                it.y(10);
                it.F(QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO);
                it.I(false);
            }
        }).a();
        int height = drawInfo.a().height();
        int i3 = MIN_HEIGHT_SIZE;
        if (height >= i3) {
            i3 = drawInfo.a().height();
        }
        if (((int) drawInfo.b()) <= maxWidth) {
            maxWidth = (int) drawInfo.b();
        }
        if (maxWidth == 0) {
            return null;
        }
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        float f16 = 64;
        float f17 = f16 / i3;
        floatRef.element = f17;
        if (f17 < 1.0f) {
            f17 = 1.0f;
        }
        floatRef.element = f17;
        int i16 = (64 - i3) / 2;
        final Rect rect = new Rect(0, i16, ((int) (maxWidth * floatRef.element)) + 116, i16 + 64);
        a17.c0(new Function1<d, Unit>() { // from class: com.tencent.mobileqq.vas.troop.impl.TroopNickManagerImpl$setCustomCloth$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/vas/troop/impl/TroopNickManagerImpl$setCustomCloth$1$a", "Lcom/tencent/cachedrawable/dynamicdrawable/d$b;", "Landroid/graphics/Canvas;", PM.CANVAS, "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "a", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes20.dex */
            public static final class a implements d.b {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ Ref.FloatRef f311027a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ Rect f311028b;

                a(Ref.FloatRef floatRef, Rect rect) {
                    this.f311027a = floatRef;
                    this.f311028b = rect;
                }

                @Override // com.tencent.cachedrawable.dynamicdrawable.d.b
                public void a(@NotNull Canvas canvas, @NotNull Bitmap bitmap) {
                    Intrinsics.checkNotNullParameter(canvas, "canvas");
                    Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                    canvas.save();
                    float f16 = 1;
                    float f17 = this.f311027a.element;
                    canvas.scale(f16 / f17, f16 / f17);
                    byte[] ninePatchChunk = bitmap.getNinePatchChunk();
                    if (ninePatchChunk != null) {
                        NinePatch ninePatch = null;
                        if (NinePatch.isNinePatchChunk(ninePatchChunk)) {
                            ninePatch = new NinePatch(bitmap, ninePatchChunk, null);
                        }
                        if (ninePatch != null) {
                            ninePatch.draw(canvas, this.f311028b, new Paint());
                        }
                    }
                    canvas.restore();
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(d dVar) {
                invoke2(dVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull d it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.b(new a(Ref.FloatRef.this, rect));
            }
        });
        float width = rect.width();
        float f18 = floatRef.element;
        return new com.tencent.qqnt.aio.nick.c(((int) (width / f18)) + 1, Math.max(i3, (int) (f16 / f18)) + rect.top, (int) (116 / (2 * floatRef.element)), a17);
    }
}
