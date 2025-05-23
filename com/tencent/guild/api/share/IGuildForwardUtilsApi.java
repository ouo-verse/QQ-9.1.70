package com.tencent.guild.api.share;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 \u000b2\u00020\u0001:\u0001\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/guild/api/share/IGuildForwardUtilsApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Intent;", "intent", "", "forwardType", "", "forwardToGuild", "Landroid/os/Bundle;", "data", "checkTextExceedLimit", "Companion", "a", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IGuildForwardUtilsApi extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f112636a;

    @NotNull
    public static final String EXTRA_GUILD_CHANNEL_ID = "extra.GUILD_CHANNEL_ID";

    @NotNull
    public static final String EXTRA_GUILD_CHAT_TYPE = "extra.GUILD_CHAT_TYPE";

    @NotNull
    public static final String EXTRA_GUILD_ID = "extra.GUILD_ID";

    @NotNull
    public static final String EXTRA_GUILD_SHOW_TOAST = "extra.GUILD_SHOW_TOAST";

    @NotNull
    public static final String EXTRA_MSG_ID = "extra.MSG_ID";
    public static final int TYPE_PHOTO = 2;
    public static final int TYPE_TEXT = 1;
    public static final int TYPE_VIDEO = 3;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/guild/api/share/IGuildForwardUtilsApi$a;", "", "<init>", "()V", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.api.share.IGuildForwardUtilsApi$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f112636a = new Companion();

        Companion() {
        }
    }

    boolean checkTextExceedLimit(@Nullable Bundle data);

    boolean forwardToGuild(@NotNull Intent intent, int forwardType);
}
