package com.tencent.mobileqq.guild.api;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&J@\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/api/IGuildWebApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "addGuildSecurityParams", "", "intent", "Landroid/content/Intent;", "linkSenderUin", "", "guildId", "openWebUrlOnlyForGuild", "context", "Landroid/content/Context;", "url", "intentExtras", "Landroid/os/Bundle;", "urlSenderUin", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGuildWebApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class a {
        public static /* synthetic */ void a(IGuildWebApi iGuildWebApi, Context context, String str, Bundle bundle, String str2, String str3, int i3, Object obj) {
            String str4;
            String str5;
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    bundle = null;
                }
                Bundle bundle2 = bundle;
                if ((i3 & 8) != 0) {
                    str4 = "";
                } else {
                    str4 = str2;
                }
                if ((i3 & 16) != 0) {
                    str5 = "";
                } else {
                    str5 = str3;
                }
                iGuildWebApi.openWebUrlOnlyForGuild(context, str, bundle2, str4, str5);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openWebUrlOnlyForGuild");
        }
    }

    void addGuildSecurityParams(@NotNull Intent intent, @Nullable String linkSenderUin, @Nullable String guildId);

    void openWebUrlOnlyForGuild(@Nullable Context context, @Nullable String url, @Nullable Bundle intentExtras, @Nullable String urlSenderUin, @Nullable String guildId);
}
