package com.tencent.icgame.liveroom.impl.room.live.widget;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.game.api.live.LiveRoomExtraInfo;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.eh;
import com.tencent.richframework.thread.RFWThreadManager;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u001c\u0018\u0000 \u00052\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b:\u0010;J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J\u0006\u0010\u0011\u001a\u00020\u0007J\u0006\u0010\u0012\u001a\u00020\u0007J\u0006\u0010\u0013\u001a\u00020\u0007R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\"\u0010'\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010)\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\u001e\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001d\u00106\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u00103\u001a\u0004\b4\u00105R\u0016\u00108\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010\u001eR\u0016\u00109\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001e\u00a8\u0006<"}, d2 = {"Lcom/tencent/icgame/liveroom/impl/room/live/widget/RoomCoverCtrl;", "", "Lcom/tencent/icgame/game/api/live/LiveRoomExtraInfo;", "extraInfo", "", "j", "coverUrl", "", "i", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "g", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/graphics/drawable/Drawable;", "l", "msg", "o", "p", "v", DomainData.DOMAIN_NAME, "Landroid/widget/ImageView;", "a", "Landroid/widget/ImageView;", "coverImage", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "b", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "log", "", "c", "Z", "showCover", "", "d", "J", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()J", "u", "(J)V", "roomId", "e", "isFirstRoom", "()Z", "t", "(Z)V", "f", "Lcom/tencent/icgame/game/api/live/LiveRoomExtraInfo;", "getExtraInfo", "()Lcom/tencent/icgame/game/api/live/LiveRoomExtraInfo;", ReportConstant.COSTREPORT_PREFIX, "(Lcom/tencent/icgame/game/api/live/LiveRoomExtraInfo;)V", "Lkotlin/Lazy;", "k", "()Landroid/graphics/drawable/Drawable;", "defaultDrawable", h.F, "hideCoverImg", "firstShowCover", "<init>", "(Landroid/widget/ImageView;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class RoomCoverCtrl {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView coverImage;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi log;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean showCover;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstRoom;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LiveRoomExtraInfo extraInfo;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy defaultDrawable;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean hideCoverImg;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean firstShowCover;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/icgame/liveroom/impl/room/live/widget/RoomCoverCtrl$b", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "", "onLoadSuccessed", "", "e", "onLoadFialed", "onLoadCanceled", "", "i", "onLoadProgressed", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class b implements URLDrawable.URLDrawableListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f116142e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ URLDrawable f116143f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Drawable f116144h;

        b(long j3, URLDrawable uRLDrawable, Drawable drawable) {
            this.f116142e = j3;
            this.f116143f = uRLDrawable;
            this.f116144h = drawable;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(@NotNull URLDrawable urlDrawable) {
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(@NotNull URLDrawable urlDrawable, @NotNull Throwable e16) {
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            Intrinsics.checkNotNullParameter(e16, "e");
            RoomCoverCtrl.this.log.e("ICGameRoomCoverCtrl", "roomId " + RoomCoverCtrl.this.getRoomId() + ", onLoadFailed, error " + e16);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(@NotNull URLDrawable urlDrawable, int i3) {
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(@NotNull URLDrawable urlDrawable) {
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            RoomCoverCtrl.this.o("load succeed, cost " + (System.currentTimeMillis() - this.f116142e));
            if (this.f116143f.getCurrDrawable() instanceof RegionDrawable) {
                RoomCoverCtrl.this.coverImage.setImageDrawable(this.f116144h);
                RoomCoverCtrl roomCoverCtrl = RoomCoverCtrl.this;
                Drawable currDrawable = this.f116143f.getCurrDrawable();
                Intrinsics.checkNotNull(currDrawable, "null cannot be cast to non-null type com.tencent.image.RegionDrawable");
                Bitmap bitmap = ((RegionDrawable) currDrawable).getBitmap();
                Intrinsics.checkNotNullExpressionValue(bitmap, "drawable.currDrawable as RegionDrawable).bitmap");
                roomCoverCtrl.g(bitmap);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/icgame/liveroom/impl/room/live/widget/RoomCoverCtrl$c", "Lcom/tencent/image/URLDrawable$DownloadListener;", "", "onFileDownloadStarted", "", "size", "onFileDownloadSucceed", "", "p0", "onFileDownloadFailed", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class c implements URLDrawable.DownloadListener {
        c() {
        }

        @Override // com.tencent.image.URLDrawable.DownloadListener
        public void onFileDownloadFailed(int p06) {
            RoomCoverCtrl.this.o("onFileDownloadFailed");
        }

        @Override // com.tencent.image.URLDrawable.DownloadListener
        public void onFileDownloadStarted() {
            RoomCoverCtrl.this.o("onFileDownloadStarted");
        }

        @Override // com.tencent.image.URLDrawable.DownloadListener
        public void onFileDownloadSucceed(long size) {
            RoomCoverCtrl.this.o("onFileDownloadSucceed");
        }
    }

    public RoomCoverCtrl(@NotNull ImageView coverImage) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(coverImage, "coverImage");
        this.coverImage = coverImage;
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.log = (IAegisLogApi) api;
        this.showCover = true;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Drawable>() { // from class: com.tencent.icgame.liveroom.impl.room.live.widget.RoomCoverCtrl$defaultDrawable$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Drawable invoke() {
                return ContextCompat.getDrawable(RoomCoverCtrl.this.coverImage.getContext(), R.drawable.noq);
            }
        });
        this.defaultDrawable = lazy;
        this.firstShowCover = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(final Bitmap bitmap) {
        o("doBlur, hideCoverImg " + this.hideCoverImg);
        if (this.hideCoverImg) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        RFWThreadManager.getInstance().execOnAsyncDisplayThread(new Runnable() { // from class: com.tencent.icgame.liveroom.impl.room.live.widget.f
            @Override // java.lang.Runnable
            public final void run() {
                RoomCoverCtrl.h(RoomCoverCtrl.this, currentTimeMillis, bitmap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(RoomCoverCtrl this$0, long j3, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bitmap, "$bitmap");
        this$0.o("wait doBlur cost " + (System.currentTimeMillis() - j3));
        try {
            long currentTimeMillis = System.currentTimeMillis();
            Bitmap tempBitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);
            eh.a(tempBitmap, 16);
            Intrinsics.checkNotNullExpressionValue(tempBitmap, "tempBitmap");
            this$0.q(tempBitmap);
            this$0.o("doBlur done cost " + (System.currentTimeMillis() - currentTimeMillis));
        } catch (IllegalStateException e16) {
            this$0.log.e("ICGameRoomCoverCtrl", "roomId " + this$0.roomId + ", doBlur fail " + e16.getMessage());
            this$0.q(bitmap);
        }
    }

    private final void i(String coverUrl) {
        Drawable l3 = l();
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestHeight = ViewUtils.getScreenHeight() / 4;
        obtain.mRequestWidth = ViewUtils.getScreenWidth() / 4;
        obtain.mLoadingDrawable = l3;
        obtain.mFailedDrawable = k();
        URLDrawable drawable = URLDrawable.getDrawable(coverUrl, obtain);
        if (drawable.getStatus() == 1) {
            o("drawable.status == URLDrawable.SUCCEED");
            Drawable currDrawable = drawable.getCurrDrawable();
            Intrinsics.checkNotNull(currDrawable, "null cannot be cast to non-null type com.tencent.image.RegionDrawable");
            Bitmap bitmap = ((RegionDrawable) currDrawable).getBitmap();
            Intrinsics.checkNotNullExpressionValue(bitmap, "drawable.currDrawable as RegionDrawable).bitmap");
            g(bitmap);
            return;
        }
        this.coverImage.setImageDrawable(drawable);
        long currentTimeMillis = System.currentTimeMillis();
        o("drawable.startDownload()");
        drawable.setURLDrawableListener(new b(currentTimeMillis, drawable, l3));
        drawable.setDownloadListener(new c());
        drawable.startDownload();
    }

    private final String j(LiveRoomExtraInfo extraInfo) {
        String str;
        String str2;
        boolean z16;
        boolean z17;
        if (extraInfo == null) {
            return null;
        }
        Bundle bundle = extraInfo.E;
        if (bundle != null) {
            str = bundle.getString("coverurl");
        } else {
            str = null;
        }
        Bundle bundle2 = extraInfo.E;
        if (bundle2 != null) {
            str2 = bundle2.getString("ext_cover_url");
        } else {
            str2 = null;
        }
        boolean z18 = false;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            if (str2 != null && str2.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                str = str2;
            } else {
                str = null;
            }
        }
        if (str == null || str.length() == 0) {
            z18 = true;
        }
        if (z18) {
            return null;
        }
        return URLDecoder.decode(str, StandardCharsets.UTF_8.name());
    }

    private final Drawable k() {
        return (Drawable) this.defaultDrawable.getValue();
    }

    private final Drawable l() {
        if (this.isFirstRoom && this.firstShowCover) {
            return new ColorDrawable(0);
        }
        return k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(String msg2) {
        this.log.i("ICGameRoomCoverCtrl", "roomId " + this.roomId + " " + msg2);
    }

    private final void q(final Bitmap bitmap) {
        this.coverImage.post(new Runnable() { // from class: com.tencent.icgame.liveroom.impl.room.live.widget.g
            @Override // java.lang.Runnable
            public final void run() {
                RoomCoverCtrl.r(RoomCoverCtrl.this, bitmap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(RoomCoverCtrl this$0, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bitmap, "$bitmap");
        this$0.o("setCoverImage done, hideCoverImg " + this$0.hideCoverImg);
        if (!this$0.hideCoverImg) {
            this$0.coverImage.setImageBitmap(bitmap);
            this$0.coverImage.setVisibility(0);
        }
    }

    /* renamed from: m, reason: from getter */
    public final long getRoomId() {
        return this.roomId;
    }

    public final void n() {
        o("hideCoverImg call");
        this.hideCoverImg = true;
        this.coverImage.setVisibility(8);
    }

    public final void p() {
        o("resetHideCoverImg");
        this.hideCoverImg = false;
    }

    public final void s(@Nullable LiveRoomExtraInfo liveRoomExtraInfo) {
        this.extraInfo = liveRoomExtraInfo;
    }

    public final void t(boolean z16) {
        this.isFirstRoom = z16;
    }

    public final void u(long j3) {
        this.roomId = j3;
    }

    public final void v() {
        boolean z16;
        if (!this.showCover) {
            o("showCover switch off, return");
            return;
        }
        String j3 = j(this.extraInfo);
        o("showCoverImg, weakNetwork false, isFirstRoom " + this.isFirstRoom + ", coverUrl " + j3);
        if (j3 != null && j3.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            this.coverImage.setImageDrawable(k());
            this.coverImage.setVisibility(0);
        } else {
            i(j3);
        }
        this.firstShowCover = false;
    }
}
