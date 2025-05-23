package com.tencent.mobileqq.guild.temp.api.impl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.guild.temp.api.IBubbleTextViewFactoryApi;
import com.tencent.mobileqq.guild.widget.GuildLiveChannelETTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/temp/api/impl/BubbleTextViewFactoryApiImpl;", "Lcom/tencent/mobileqq/guild/temp/api/IBubbleTextViewFactoryApi;", "Landroid/content/Context;", "context", "Landroid/widget/TextView;", "createGuildETTextView", "createGuildEmoETTextView", "Ls02/a;", "createGuildLiveETTextView", "<init>", "()V", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class BubbleTextViewFactoryApiImpl implements IBubbleTextViewFactoryApi {
    @Override // com.tencent.mobileqq.guild.temp.api.IBubbleTextViewFactoryApi
    public TextView createGuildETTextView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ETTextView(context);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IBubbleTextViewFactoryApi
    public TextView createGuildEmoETTextView(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ETTextView(context) { // from class: com.tencent.mobileqq.guild.temp.api.impl.BubbleTextViewFactoryApiImpl$createGuildEmoETTextView$1
            @Override // com.tencent.mobileqq.widget.AnimationTextView, android.widget.TextView, android.view.View, android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(Drawable drawable) {
                Intrinsics.checkNotNullParameter(drawable, "drawable");
                invalidate();
            }
        };
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IBubbleTextViewFactoryApi
    public s02.a createGuildLiveETTextView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new GuildLiveChannelETTextView(context);
    }
}
