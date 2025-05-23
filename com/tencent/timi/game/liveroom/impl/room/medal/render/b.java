package com.tencent.timi.game.liveroom.impl.room.medal.render;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.liveroom.impl.room.medal.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wj4.MedalDrawConfig;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J.\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0010\u0010\b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u001c\u0010\r\u001a\u00020\u000b2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0014\u0010\u000e\u001a\u00020\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/medal/render/b;", "Lcom/tencent/timi/game/liveroom/impl/room/medal/render/j;", "Lsr4/g;", "data", "Lcom/tencent/timi/game/liveroom/impl/room/medal/g;", "renderData", "Lcom/tencent/timi/game/liveroom/impl/room/medal/c$a;", "", "callback", "", DomainData.DOMAIN_NAME, "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "<init>", "()V", "b", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b extends j<sr4.g> {
    @Override // com.tencent.timi.game.liveroom.impl.room.medal.render.j
    @NotNull
    public Bitmap l(@NotNull com.tencent.timi.game.liveroom.impl.room.medal.g<?> data, @NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Object a16 = data.a();
        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.trpcprotocol.qlive.trpc_user_info_svr.user_medal.nano.MedalInfoNew");
        sr4.g gVar = (sr4.g) a16;
        wj4.b bVar = wj4.b.f445740a;
        MedalDrawConfig g16 = bVar.g();
        if (!TextUtils.isEmpty(gVar.f434408z)) {
            g16 = bVar.e();
        } else if (!TextUtils.isEmpty(gVar.f434407w)) {
            g16 = bVar.f();
        }
        int i3 = gVar.f434397m;
        String str = gVar.f434386b;
        Intrinsics.checkNotNullExpressionValue(str, "medalInfo.medalName");
        return bVar.a(bitmap, i3, str, g16);
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [T, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v16, types: [T, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v5, types: [T, java.lang.Object, java.lang.String] */
    @Override // com.tencent.timi.game.liveroom.impl.room.medal.a
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void d(@NotNull sr4.g data, @NotNull com.tencent.timi.game.liveroom.impl.room.medal.g<?> renderData, @NotNull c.a<?, CharSequence> callback) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(renderData, "renderData");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        if (!TextUtils.isEmpty(data.f434408z)) {
            ?? r56 = data.f434408z;
            Intrinsics.checkNotNullExpressionValue(r56, "data.diamondMedalBgImg");
            objectRef.element = r56;
            if (TextUtils.isEmpty((CharSequence) r56)) {
                objectRef.element = "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/zhibo/fangroup/qvideo_live_fangroup_medal_penguin_drillpenguin.png";
            }
        } else if (!TextUtils.isEmpty(data.f434407w)) {
            ?? r57 = data.f434407w;
            Intrinsics.checkNotNullExpressionValue(r57, "data.fansMedalBgImgStyle");
            objectRef.element = r57;
            if (TextUtils.isEmpty((CharSequence) r57)) {
                objectRef.element = "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/zhibo/fangroup/qvideo_live_fangroup_medal_penguin_new.png";
            }
        } else {
            ?? r58 = data.f434403s;
            Intrinsics.checkNotNullExpressionValue(r58, "data.medalBgImg");
            objectRef.element = r58;
            if (TextUtils.isEmpty((CharSequence) r58)) {
                objectRef.element = "https://nowpic.gtimg.com/feeds_pic/ajNVdqHZLLBbBqKhSdUoSUgeAB2fMribc3Sz0ibHLdfsIOhxnQE30UNQ/";
            }
        }
        QLog.i("FansMedalRender", 1, "render " + objectRef.element);
        if (TextUtils.isEmpty((CharSequence) objectRef.element)) {
            callback.a(renderData, "");
            return;
        }
        URLDrawable drawable = URLDrawable.getDrawable((String) objectRef.element, URLDrawable.URLDrawableOptions.obtain());
        if (drawable.getStatus() == 1) {
            h(renderData, drawable, callback);
        } else {
            drawable.setURLDrawableListener(new C9944b(objectRef, this, renderData, callback));
            drawable.startDownload(true);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\nH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/medal/render/b$b", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "", "onLoadSuccessed", "", "t", "onLoadFialed", "onLoadCanceled", "", "onLoadProgressed", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.liveroom.impl.room.medal.render.b$b, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C9944b implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<String> f378007d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f378008e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.tencent.timi.game.liveroom.impl.room.medal.g<?> f378009f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ c.a<?, CharSequence> f378010h;

        C9944b(Ref.ObjectRef<String> objectRef, b bVar, com.tencent.timi.game.liveroom.impl.room.medal.g<?> gVar, c.a<?, CharSequence> aVar) {
            this.f378007d = objectRef;
            this.f378008e = bVar;
            this.f378009f = gVar;
            this.f378010h = aVar;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(@Nullable URLDrawable urlDrawable) {
            QLog.i("FansMedalRender", 2, "load canceled,url=" + ((Object) this.f378007d.element));
            this.f378010h.a(this.f378009f, "");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(@Nullable URLDrawable urlDrawable, @Nullable Throwable t16) {
            QLog.i("FansMedalRender", 2, "load failed,url=" + ((Object) this.f378007d.element));
            this.f378010h.a(this.f378009f, "");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(@Nullable URLDrawable urlDrawable) {
            QLog.i("FansMedalRender", 2, "load success,url=" + ((Object) this.f378007d.element));
            this.f378008e.h(this.f378009f, urlDrawable, this.f378010h);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(@Nullable URLDrawable urlDrawable, int t16) {
        }
    }
}
