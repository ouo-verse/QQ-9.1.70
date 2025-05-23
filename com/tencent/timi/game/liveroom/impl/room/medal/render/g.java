package com.tencent.timi.game.liveroom.impl.room.medal.render;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.liveroom.impl.room.medal.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 \u001d*\u0004\b\u0000\u0010\u00012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ7\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00028\u00002\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\u0012\u0010\b\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u000fH\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0012J2\u0010\u0015\u001a\u00020\t2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0012\u0010\b\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007H\u0004J\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00132\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/medal/render/g;", "I", "Lcom/tencent/timi/game/liveroom/impl/room/medal/a;", "Landroid/graphics/drawable/Drawable;", "data", "Lcom/tencent/timi/game/liveroom/impl/room/medal/g;", "renderData", "Lcom/tencent/timi/game/liveroom/impl/room/medal/c$a;", "callback", "", "d", "(Ljava/lang/Object;Lcom/tencent/timi/game/liveroom/impl/room/medal/g;Lcom/tencent/timi/game/liveroom/impl/room/medal/c$a;)V", "", "f", "(Ljava/lang/Object;)Ljava/lang/String;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, tl.h.F, "(Ljava/lang/Object;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "g", "e", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "b", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "urlDrawableListener", "<init>", "()V", "c", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public abstract class g<I> extends com.tencent.timi.game.liveroom.impl.room.medal.a<I, Drawable> {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private URLDrawable.URLDrawableListener urlDrawableListener;

    @Override // com.tencent.timi.game.liveroom.impl.room.medal.a
    public void d(I data, @NotNull com.tencent.timi.game.liveroom.impl.room.medal.g<?> renderData, @NotNull c.a<?, Drawable> callback) {
        Intrinsics.checkNotNullParameter(renderData, "renderData");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String f16 = f(data);
        QLog.i("UrlDrawableRender", 1, "url=" + f16);
        if (TextUtils.isEmpty(f16)) {
            callback.a(renderData, null);
            return;
        }
        URLDrawable drawable = URLDrawable.getDrawable(f16, URLDrawable.URLDrawableOptions.obtain());
        if (drawable.getStatus() == 1) {
            g(renderData, drawable, callback);
            return;
        }
        b bVar = new b(f16, this, renderData, callback);
        this.urlDrawableListener = bVar;
        drawable.setURLDrawableListener(bVar);
        drawable.startDownload(true);
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.medal.a
    @Nullable
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public URLDrawable b(@NotNull com.tencent.timi.game.liveroom.impl.room.medal.g<?> renderData) {
        Intrinsics.checkNotNullParameter(renderData, "renderData");
        return null;
    }

    @NotNull
    public abstract String f(I data);

    protected final void g(@NotNull com.tencent.timi.game.liveroom.impl.room.medal.g<?> renderData, @Nullable URLDrawable urlDrawable, @NotNull c.a<?, Drawable> callback) {
        Bitmap bitmap;
        Drawable currDrawable;
        Intrinsics.checkNotNullParameter(renderData, "renderData");
        Intrinsics.checkNotNullParameter(callback, "callback");
        I c16 = c(renderData);
        if (urlDrawable != null && (currDrawable = urlDrawable.getCurrDrawable()) != null) {
            bitmap = com.tencent.timi.game.liveroom.impl.room.medal.b.a(currDrawable);
        } else {
            bitmap = null;
        }
        if (bitmap != null) {
            Bitmap h16 = h(c16, bitmap);
            if (Intrinsics.areEqual(h16, bitmap)) {
                callback.a(renderData, urlDrawable);
                return;
            } else {
                callback.a(renderData, new BitmapDrawable(MobileQQ.sMobileQQ.getResources(), h16));
                return;
            }
        }
        callback.a(renderData, null);
    }

    @NotNull
    public abstract Bitmap h(I data, @NotNull Bitmap bitmap);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\nH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/medal/render/g$b", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "", "onLoadSuccessed", "", "t", "onLoadFialed", "onLoadCanceled", "", "onLoadProgressed", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f378022d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ g<I> f378023e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.tencent.timi.game.liveroom.impl.room.medal.g<?> f378024f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ c.a<?, Drawable> f378025h;

        b(String str, g<I> gVar, com.tencent.timi.game.liveroom.impl.room.medal.g<?> gVar2, c.a<?, Drawable> aVar) {
            this.f378022d = str;
            this.f378023e = gVar;
            this.f378024f = gVar2;
            this.f378025h = aVar;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(@Nullable URLDrawable urlDrawable) {
            QLog.i("UrlDrawableRender", 2, "load canceled,url=" + this.f378022d);
            this.f378025h.a(this.f378024f, null);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(@Nullable URLDrawable urlDrawable, @Nullable Throwable t16) {
            QLog.i("UrlDrawableRender", 2, "load failed,url=" + this.f378022d);
            this.f378025h.a(this.f378024f, null);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(@Nullable URLDrawable urlDrawable) {
            QLog.i("UrlDrawableRender", 2, "load success,url=" + this.f378022d);
            this.f378023e.g(this.f378024f, urlDrawable, this.f378025h);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(@Nullable URLDrawable urlDrawable, int t16) {
        }
    }
}
