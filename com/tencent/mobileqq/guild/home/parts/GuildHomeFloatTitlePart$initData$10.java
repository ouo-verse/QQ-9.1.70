package com.tencent.mobileqq.guild.home.parts;

import android.graphics.Bitmap;
import com.tencent.mobileqq.guild.home.views.title.GuildHomeFloatTitleLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class GuildHomeFloatTitlePart$initData$10 extends Lambda implements Function1<Bitmap, Unit> {
    final /* synthetic */ GuildHomeFloatTitlePart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildHomeFloatTitlePart$initData$10(GuildHomeFloatTitlePart guildHomeFloatTitlePart) {
        super(1);
        this.this$0 = guildHomeFloatTitlePart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildHomeFloatTitlePart this$0, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildHomeFloatTitleLayout guildHomeFloatTitleLayout = this$0.headTitleAboveList;
        if (guildHomeFloatTitleLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headTitleAboveList");
            guildHomeFloatTitleLayout = null;
        }
        guildHomeFloatTitleLayout.w(bitmap);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
        invoke2(bitmap);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final Bitmap bitmap) {
        GuildHomeFloatTitleLayout guildHomeFloatTitleLayout = this.this$0.headTitleAboveList;
        if (guildHomeFloatTitleLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("headTitleAboveList");
            guildHomeFloatTitleLayout = null;
        }
        final GuildHomeFloatTitlePart guildHomeFloatTitlePart = this.this$0;
        guildHomeFloatTitleLayout.post(new Runnable() { // from class: com.tencent.mobileqq.guild.home.parts.ad
            @Override // java.lang.Runnable
            public final void run() {
                GuildHomeFloatTitlePart$initData$10.b(GuildHomeFloatTitlePart.this, bitmap);
            }
        });
    }
}
