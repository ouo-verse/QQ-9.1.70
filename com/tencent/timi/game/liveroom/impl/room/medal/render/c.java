package com.tencent.timi.game.liveroom.impl.room.medal.render;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import wj4.MedalDrawConfig;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\t\u001a\u00020\u00022\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/medal/render/c;", "Lcom/tencent/timi/game/liveroom/impl/room/medal/render/g;", "Lsr4/g;", "data", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "k", "Lcom/tencent/timi/game/liveroom/impl/room/medal/g;", "renderData", "i", "", "j", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class c extends g<sr4.g> {
    @Override // com.tencent.timi.game.liveroom.impl.room.medal.a
    @NotNull
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public sr4.g c(@NotNull com.tencent.timi.game.liveroom.impl.room.medal.g<?> renderData) {
        Intrinsics.checkNotNullParameter(renderData, "renderData");
        Object a16 = renderData.a();
        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.trpcprotocol.qlive.trpc_user_info_svr.user_medal.nano.MedalInfoNew");
        return (sr4.g) a16;
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.medal.render.g
    @NotNull
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public String f(@NotNull sr4.g data) {
        boolean isBlank;
        boolean isBlank2;
        Intrinsics.checkNotNullParameter(data, "data");
        String str = data.A;
        Intrinsics.checkNotNullExpressionValue(str, "data.diamondFloatBarBgImg");
        isBlank = StringsKt__StringsJVMKt.isBlank(str);
        if (!isBlank) {
            String str2 = data.f434408z;
            Intrinsics.checkNotNullExpressionValue(str2, "data.diamondMedalBgImg");
            return str2;
        }
        String str3 = data.f434407w;
        Intrinsics.checkNotNullExpressionValue(str3, "data.fansMedalBgImgStyle");
        isBlank2 = StringsKt__StringsJVMKt.isBlank(str3);
        if (!isBlank2) {
            String str4 = data.f434407w;
            Intrinsics.checkNotNullExpressionValue(str4, "data.fansMedalBgImgStyle");
            return str4;
        }
        String str5 = data.f434403s;
        Intrinsics.checkNotNullExpressionValue(str5, "data.medalBgImg");
        return str5;
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.medal.render.g
    @NotNull
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public Bitmap h(@NotNull sr4.g data, @NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        wj4.b bVar = wj4.b.f445740a;
        MedalDrawConfig g16 = bVar.g();
        if (!TextUtils.isEmpty(data.f434408z)) {
            g16 = bVar.e();
        } else if (!TextUtils.isEmpty(data.f434407w)) {
            g16 = bVar.f();
        }
        int i3 = data.f434397m;
        String str = data.f434386b;
        Intrinsics.checkNotNullExpressionValue(str, "medalInfo.medalName");
        return bVar.a(bitmap, i3, str, g16);
    }
}
