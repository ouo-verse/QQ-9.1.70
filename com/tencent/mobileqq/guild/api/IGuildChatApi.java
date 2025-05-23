package com.tencent.mobileqq.guild.api;

import android.content.Context;
import com.tencent.mobileqq.guild.s;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/api/IGuildChatApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "chatsListPart", "Lcom/tencent/mobileqq/guild/s;", "getGuildConversationSummaryHelper", "", "highLightText", "", "isContainHighLight", "Landroid/content/Context;", "context", "", "openGuildHelper", "Companion", "a", "qqchat_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGuildChatApi extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f214347a;

    @NotNull
    public static final String REGEX_HIGH_LIGHT = "\\[.*\\]";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/api/IGuildChatApi$a;", "", "<init>", "()V", "qqchat_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.api.IGuildChatApi$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f214347a = new Companion();

        Companion() {
        }
    }

    @NotNull
    s getGuildConversationSummaryHelper(@NotNull Object chatsListPart);

    boolean isContainHighLight(@NotNull String highLightText);

    void openGuildHelper(@NotNull Context context);
}
