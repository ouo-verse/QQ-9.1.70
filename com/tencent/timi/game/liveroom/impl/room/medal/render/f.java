package com.tencent.timi.game.liveroom.impl.room.medal.render;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.Size;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.liveroom.impl.room.medal.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J.\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0010\u0010\b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u001c\u0010\r\u001a\u00020\u000b2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0014\u0010\u000e\u001a\u00020\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/medal/render/f;", "Lcom/tencent/timi/game/liveroom/impl/room/medal/render/j;", "Lsr4/g;", "data", "Lcom/tencent/timi/game/liveroom/impl/room/medal/g;", "renderData", "Lcom/tencent/timi/game/liveroom/impl/room/medal/c$a;", "", "callback", "", DomainData.DOMAIN_NAME, "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/util/Size;", "b", "Landroid/util/Size;", "tranSize", "<init>", "()V", "c", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class f extends j<sr4.g> {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Size tranSize;

    @Override // com.tencent.timi.game.liveroom.impl.room.medal.render.j
    @NotNull
    public Bitmap l(@NotNull com.tencent.timi.game.liveroom.impl.room.medal.g<?> renderData, @NotNull Bitmap bitmap) {
        int c16;
        int c17;
        Intrinsics.checkNotNullParameter(renderData, "renderData");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Object a16 = renderData.a();
        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.trpcprotocol.qlive.trpc_user_info_svr.user_medal.nano.MedalInfoNew");
        sr4.g gVar = (sr4.g) a16;
        try {
            Matrix matrix = new Matrix();
            Size size = this.tranSize;
            if (size != null) {
                c16 = size.getWidth();
            } else {
                c16 = x.c(MobileQQ.sMobileQQ, 32.0f);
            }
            float width = (c16 * 1.0f) / bitmap.getWidth();
            Size size2 = this.tranSize;
            if (size2 != null) {
                c17 = size2.getHeight();
            } else {
                c17 = x.c(MobileQQ.sMobileQQ, 16.0f);
            }
            matrix.postScale(width, (c17 * 1.0f) / bitmap.getHeight());
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            if (!createBitmap.isMutable()) {
                createBitmap = createBitmap.copy(Bitmap.Config.ARGB_8888, true);
                QLog.e("QQLiveUrlUserLevelRender", 1, "createFansMedalBitmap Copy to create bitmap.");
            }
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setTextSize(x.j(MobileQQ.sMobileQQ, 10.0f) * 1.0f);
            paint.setColor(-1);
            paint.setTypeface(com.tencent.timi.game.liveroom.impl.util.c.h(com.tencent.timi.game.liveroom.impl.util.c.f378976a, "https://dlied5v6.qq.com/now/qq-live/fonts/EurostileNextPro-SemiBold\u7684.ttf", null, 2, null));
            int i3 = gVar.f434397m;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(i3);
            String sb6 = sb5.toString();
            float width2 = (createBitmap.getWidth() * 0.38f) + (((createBitmap.getWidth() * 0.6f) - paint.measureText(sb6)) / 2.0f);
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            float height = createBitmap.getHeight() - fontMetrics.descent;
            float f16 = fontMetrics.ascent;
            canvas.drawText(sb6, width2, ((height + f16) / 2.0f) - f16, paint);
            bitmap = createBitmap;
        } catch (IllegalStateException unused) {
        }
        Intrinsics.checkNotNull(bitmap);
        return bitmap;
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.medal.a
    @NotNull
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public sr4.g c(@NotNull com.tencent.timi.game.liveroom.impl.room.medal.g<?> renderData) {
        Intrinsics.checkNotNullParameter(renderData, "renderData");
        Object a16 = renderData.a();
        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.trpcprotocol.qlive.trpc_user_info_svr.user_medal.nano.MedalInfoNew");
        return (sr4.g) a16;
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.medal.a
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void d(@NotNull sr4.g data, @NotNull com.tencent.timi.game.liveroom.impl.room.medal.g<?> renderData, @NotNull c.a<?, CharSequence> callback) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(renderData, "renderData");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String str = data.f434387c;
        QLog.i("QQLiveUrlUserLevelRender", 1, "render " + str);
        if (TextUtils.isEmpty(str)) {
            callback.a(renderData, "");
            return;
        }
        try {
            URLDrawable drawable = URLDrawable.getDrawable(str, URLDrawable.URLDrawableOptions.obtain());
            boolean z16 = false;
            if (drawable != null && drawable.getStatus() == 1) {
                z16 = true;
            }
            if (z16) {
                h(renderData, drawable, callback);
                return;
            }
            if (drawable != null) {
                drawable.setURLDrawableListener(new b(str, this, renderData, callback));
            }
            drawable.startDownload(true);
        } catch (IllegalArgumentException unused) {
            callback.a(renderData, "");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\nH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/medal/render/f$b", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "", "onLoadSuccessed", "", "t", "onLoadFialed", "onLoadCanceled", "", "onLoadProgressed", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f378016d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ f f378017e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.tencent.timi.game.liveroom.impl.room.medal.g<?> f378018f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ c.a<?, CharSequence> f378019h;

        b(String str, f fVar, com.tencent.timi.game.liveroom.impl.room.medal.g<?> gVar, c.a<?, CharSequence> aVar) {
            this.f378016d = str;
            this.f378017e = fVar;
            this.f378018f = gVar;
            this.f378019h = aVar;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(@Nullable URLDrawable urlDrawable) {
            QLog.i("QQLiveUrlUserLevelRender", 2, "load canceled,url=" + this.f378016d);
            this.f378019h.a(this.f378018f, "");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(@Nullable URLDrawable urlDrawable, @Nullable Throwable t16) {
            QLog.i("QQLiveUrlUserLevelRender", 2, "load failed,url=" + this.f378016d);
            this.f378019h.a(this.f378018f, "");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(@Nullable URLDrawable urlDrawable) {
            QLog.i("QQLiveUrlUserLevelRender", 2, "load success,url=" + this.f378016d);
            this.f378017e.h(this.f378018f, urlDrawable, this.f378019h);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(@Nullable URLDrawable urlDrawable, int t16) {
        }
    }
}
