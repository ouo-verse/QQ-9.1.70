package com.tencent.mobileqq.guild.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.guild.api.IGuildWebApi;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J:\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/GuildWebApiImpl;", "Lcom/tencent/mobileqq/guild/api/IGuildWebApi;", "Landroid/content/Context;", "context", "", "url", "Landroid/os/Bundle;", "intentExtras", "urlSenderUin", "guildId", "", "openWebUrlOnlyForGuild", "Landroid/content/Intent;", "intent", "linkSenderUin", "addGuildSecurityParams", "<init>", "()V", "Companion", "a", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class GuildWebApiImpl implements IGuildWebApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String GUILD_URL_SOURCE = "mqq.pindao";
    private static final String TAG = "GuildWebApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J@\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0007J(\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0007R\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/GuildWebApiImpl$a;", "", "Landroid/content/Context;", "context", "", "url", "Landroid/os/Bundle;", "intentExtraParams", "linkSenderUin", "guildId", "", "b", "Landroid/content/Intent;", "intent", "a", "GUILD_URL_SOURCE", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.api.impl.GuildWebApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(Intent intent, String linkSenderUin, String guildId) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            intent.putExtra("key_url_source", GuildWebApiImpl.GUILD_URL_SOURCE);
            intent.putExtra("friendUin", linkSenderUin);
            intent.putExtra("friend_uin", guildId);
        }

        Companion() {
        }

        @JvmStatic
        public final void b(Context context, String url, Bundle intentExtraParams, String linkSenderUin, String guildId) {
            if (context == null) {
                context = BaseApplication.getContext();
            }
            Intent intent = new Intent(context, (Class<?>) QQBrowserDelegationActivity.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            if (intentExtraParams != null) {
                intent.putExtras(intentExtraParams);
            }
            if (!(url == null || url.length() == 0)) {
                intent.putExtra("url", url);
            }
            a(intent, linkSenderUin, guildId);
            if (context != null) {
                context.startActivity(intent);
            }
        }

        public static /* synthetic */ void c(Companion companion, Context context, String str, Bundle bundle, String str2, String str3, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                bundle = null;
            }
            companion.b(context, str, bundle, (i3 & 8) != 0 ? "" : str2, (i3 & 16) != 0 ? "" : str3);
        }
    }

    @JvmStatic
    public static final void addGuildSecurityParamsInner(Intent intent, String str, String str2) {
        INSTANCE.a(intent, str, str2);
    }

    @JvmStatic
    public static final void guildOpenWebUrlOnly(Context context, String str, Bundle bundle, String str2, String str3) {
        INSTANCE.b(context, str, bundle, str2, str3);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildWebApi
    public void addGuildSecurityParams(Intent intent, String linkSenderUin, String guildId) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        INSTANCE.a(intent, linkSenderUin, guildId);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildWebApi
    public void openWebUrlOnlyForGuild(Context context, String url, Bundle intentExtras, String urlSenderUin, String guildId) {
        INSTANCE.b(context, url, intentExtras, urlSenderUin, guildId);
    }
}
