package com.tencent.icgame.game.utils;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\"\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0002J$\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005J\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/icgame/game/utils/c;", "", "", "avatarSize", "defaultId", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "b", "Landroid/view/View;", "view", "c", "", PhotoCategorySummaryInfo.AVATAR_URL, "Landroid/widget/ImageView;", "imageView", "option", "", "d", "Lcom/tencent/image/URLDrawable;", "a", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f116096a = new c();

    c() {
    }

    @Nullable
    public final URLDrawable a(@Nullable String avatarUrl, @Nullable URLDrawable.URLDrawableOptions option) {
        try {
            return ((bv0.a) qx0.a.b(bv0.a.class)).m(avatarUrl, option);
        } catch (IllegalArgumentException e16) {
            g.d("DrawableUtil", "acquireDrawable error " + e16);
            return null;
        }
    }

    @Nullable
    public final URLDrawable.URLDrawableOptions b(int avatarSize, int defaultId) {
        Drawable b16 = cy0.b.b(defaultId);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = b16;
        obtain.mFailedDrawable = b16;
        obtain.mRequestWidth = avatarSize;
        obtain.mRequestHeight = avatarSize;
        return obtain;
    }

    @Nullable
    public final URLDrawable.URLDrawableOptions c(int avatarSize, @Nullable View view, int defaultId) {
        Drawable colorDrawable;
        Resources resources;
        if (defaultId != 0) {
            if (view != null && (resources = view.getResources()) != null) {
                colorDrawable = resources.getDrawable(defaultId);
            } else {
                colorDrawable = null;
            }
        } else {
            colorDrawable = new ColorDrawable(0);
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = colorDrawable;
        obtain.mFailedDrawable = colorDrawable;
        obtain.mRequestWidth = avatarSize;
        obtain.mRequestHeight = avatarSize;
        return obtain;
    }

    public final void d(@Nullable String avatarUrl, @Nullable ImageView imageView, @Nullable URLDrawable.URLDrawableOptions option) {
        try {
            URLDrawable m3 = ((bv0.a) qx0.a.b(bv0.a.class)).m(avatarUrl, option);
            long currentTimeMillis = System.currentTimeMillis();
            if (m3 != null) {
                m3.setURLDrawableListener(new a(currentTimeMillis, avatarUrl));
            }
            if (imageView != null) {
                imageView.setImageDrawable(m3);
            }
        } catch (IllegalArgumentException e16) {
            g.d("DrawableUtil", "setImageDrawable error " + e16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\nH\u0016R\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0012"}, d2 = {"com/tencent/icgame/game/utils/c$a", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "p0", "", "p1", "", "onLoadProgressed", "onLoadSuccessed", "onLoadCanceled", "", "onLoadFialed", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "d", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "getMAegisLog", "()Lcom/tencent/icgame/common/api/IAegisLogApi;", "mAegisLog", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class a implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final IAegisLogApi mAegisLog;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f116098e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f116099f;

        a(long j3, String str) {
            this.f116098e = j3;
            this.f116099f = str;
            QRouteApi api = QRoute.api(IAegisLogApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
            this.mAegisLog = (IAegisLogApi) api;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(@Nullable URLDrawable p06) {
            long currentTimeMillis = System.currentTimeMillis() - this.f116098e;
            this.mAegisLog.e("DrawableUtil", 1, "setImageDrawable onLoadCanceled url=" + this.f116099f + ",timelong=" + currentTimeMillis);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(@Nullable URLDrawable p06, @Nullable Throwable p16) {
            long currentTimeMillis = System.currentTimeMillis() - this.f116098e;
            this.mAegisLog.e("DrawableUtil", 1, "setImageDrawable onLoadFialed url=" + this.f116099f + ",timelong=" + currentTimeMillis);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(@Nullable URLDrawable p06) {
            long currentTimeMillis = System.currentTimeMillis() - this.f116098e;
            this.mAegisLog.i("DrawableUtil", 1, "setImageDrawable onLoadSuccessed url=" + this.f116099f + ",timelong=" + currentTimeMillis);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(@Nullable URLDrawable p06, int p16) {
        }
    }
}
