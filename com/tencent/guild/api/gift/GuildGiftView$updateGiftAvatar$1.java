package com.tencent.guild.api.gift;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "drawable", "Landroid/graphics/drawable/Drawable;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class GuildGiftView$updateGiftAvatar$1 extends Lambda implements Function1<Drawable, Unit> {
    final /* synthetic */ String $tinyId;
    final /* synthetic */ String $url;
    final /* synthetic */ GuildGiftView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildGiftView$updateGiftAvatar$1(GuildGiftView guildGiftView, String str, String str2) {
        super(1);
        this.this$0 = guildGiftView;
        this.$tinyId = str;
        this.$url = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Drawable drawable, final GuildGiftView this$0, String tinyId, final String str) {
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tinyId, "$tinyId");
        Bitmap drawableToBitmap = BaseImageUtil.drawableToBitmap(drawable);
        str2 = this$0.sendUin;
        if (Intrinsics.areEqual(str2, tinyId)) {
            this$0.pagHeadPagView.setSendIconBm(drawableToBitmap);
        }
        str3 = this$0.receiveUin;
        if (Intrinsics.areEqual(str3, tinyId)) {
            this$0.pagHeadPagView.setRecIconBm(drawableToBitmap);
        }
        this$0.post(new Runnable() { // from class: com.tencent.guild.api.gift.h
            @Override // java.lang.Runnable
            public final void run() {
                GuildGiftView$updateGiftAvatar$1.d(str, this$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(String str, GuildGiftView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("GuildGiftView", 2, "updateAvatar " + str);
        this$0.pagHeadPagView.u();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable) {
        invoke2(drawable);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable final Drawable drawable) {
        final GuildGiftView guildGiftView = this.this$0;
        final String str = this.$tinyId;
        final String str2 = this.$url;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.guild.api.gift.g
            @Override // java.lang.Runnable
            public final void run() {
                GuildGiftView$updateGiftAvatar$1.c(drawable, guildGiftView, str, str2);
            }
        }, 16, null, false);
    }
}
