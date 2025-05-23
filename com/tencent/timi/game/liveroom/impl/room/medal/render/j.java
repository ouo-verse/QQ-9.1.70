package com.tencent.timi.game.liveroom.impl.room.medal.render;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.timi.game.liveroom.impl.room.medal.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J.\u0010\n\u001a\u00020\t2\u0010\u0010\u0005\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\u00042\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0002J0\u0010\r\u001a\u00020\t2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0010\u0010\u0005\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\u0004H\u0004J\u001c\u0010\u0010\u001a\u00020\u000e2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0014\u0010\u0012\u001a\u00020\u00032\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/medal/render/j;", "I", "Lcom/tencent/timi/game/liveroom/impl/room/medal/a;", "", "Lcom/tencent/timi/game/liveroom/impl/room/medal/c$a;", "callback", "Lcom/tencent/timi/game/liveroom/impl/room/medal/g;", "data", "renderResult", "", "j", "Lcom/tencent/image/URLDrawable;", "urlDrawable", tl.h.F, "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "l", "renderData", "g", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public abstract class j<I> extends com.tencent.timi.game.liveroom.impl.room.medal.a<I, CharSequence> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(URLDrawable uRLDrawable, j this$0, com.tencent.timi.game.liveroom.impl.room.medal.g data, c.a callback) {
        Bitmap bitmap;
        Drawable currDrawable;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (uRLDrawable != null && (currDrawable = uRLDrawable.getCurrDrawable()) != null) {
            bitmap = com.tencent.timi.game.liveroom.impl.room.medal.b.a(currDrawable);
        } else {
            bitmap = null;
        }
        if (bitmap != null) {
            Bitmap l3 = this$0.l(data, bitmap);
            SpannableString spannableString = new SpannableString(" ");
            spannableString.setSpan(new xn4.a(l3, 0, 0, 6, null), 0, 1, 33);
            this$0.j(callback, data, spannableString);
            return;
        }
        this$0.j(callback, data, "");
    }

    private final void j(final c.a<?, CharSequence> callback, final com.tencent.timi.game.liveroom.impl.room.medal.g<?> data, final CharSequence renderResult) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.medal.render.i
            @Override // java.lang.Runnable
            public final void run() {
                j.k(c.a.this, data, renderResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(c.a callback, com.tencent.timi.game.liveroom.impl.room.medal.g data, CharSequence renderResult) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(renderResult, "$renderResult");
        callback.a(data, renderResult);
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.medal.a
    @NotNull
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public CharSequence b(@NotNull com.tencent.timi.game.liveroom.impl.room.medal.g<?> renderData) {
        Intrinsics.checkNotNullParameter(renderData, "renderData");
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h(@NotNull final com.tencent.timi.game.liveroom.impl.room.medal.g<?> data, @Nullable final URLDrawable urlDrawable, @NotNull final c.a<?, CharSequence> callback) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.medal.render.h
            @Override // java.lang.Runnable
            public final void run() {
                j.i(URLDrawable.this, this, data, callback);
            }
        }, 16, null, true);
    }

    @NotNull
    public Bitmap l(@NotNull com.tencent.timi.game.liveroom.impl.room.medal.g<?> data, @NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        return bitmap;
    }
}
