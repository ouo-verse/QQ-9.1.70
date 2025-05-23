package com.tencent.guild.api.emoji.impl;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.guild.api.emoji.IGuildTextViewFactoryApi;
import com.tencent.mobileqq.guild.temp.api.IBubbleTextViewFactoryApi;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/guild/api/emoji/impl/GuildTextViewFactoryApiImpl;", "Lcom/tencent/guild/api/emoji/IGuildTextViewFactoryApi;", "Landroid/content/Context;", "context", "Landroid/widget/TextView;", "createGuildETTextView", "createGuildEmoETTextView", "Lgr0/a;", "createGuildLiveETTextView", "<init>", "()V", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildTextViewFactoryApiImpl implements IGuildTextViewFactoryApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/guild/api/emoji/impl/GuildTextViewFactoryApiImpl$a", "Lgr0/a;", "Landroid/widget/TextView;", "d", "Landroid/view/View$OnClickListener;", "clickListener", "", "setNickClickListener", "", "nickName", "setNickName", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a implements gr0.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ s02.a f112511a;

        a(s02.a aVar) {
            this.f112511a = aVar;
        }

        @Override // gr0.a
        @NotNull
        public TextView d() {
            return this.f112511a.d();
        }

        @Override // gr0.a
        public void setNickClickListener(@Nullable View.OnClickListener clickListener) {
            this.f112511a.setNickClickListener(clickListener);
        }

        @Override // gr0.a
        public void setNickName(@NotNull String nickName) {
            Intrinsics.checkNotNullParameter(nickName, "nickName");
            this.f112511a.setNickName(nickName);
        }
    }

    @Override // com.tencent.guild.api.emoji.IGuildTextViewFactoryApi
    @NotNull
    public TextView createGuildETTextView(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ((IBubbleTextViewFactoryApi) QRoute.api(IBubbleTextViewFactoryApi.class)).createGuildETTextView(context);
    }

    @Override // com.tencent.guild.api.emoji.IGuildTextViewFactoryApi
    @NotNull
    public TextView createGuildEmoETTextView(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ((IBubbleTextViewFactoryApi) QRoute.api(IBubbleTextViewFactoryApi.class)).createGuildEmoETTextView(context);
    }

    @Override // com.tencent.guild.api.emoji.IGuildTextViewFactoryApi
    @NotNull
    public gr0.a createGuildLiveETTextView(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new a(((IBubbleTextViewFactoryApi) QRoute.api(IBubbleTextViewFactoryApi.class)).createGuildLiveETTextView(context));
    }
}
