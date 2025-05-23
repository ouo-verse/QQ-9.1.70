package com.tencent.guild.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProContact;
import cr0.GuildActiveInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Service(process = {"all"})
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\bg\u0018\u0000 \u000e2\u00020\u0001:\u0002\u000f\u0010J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H&J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/guild/api/ILocalFocusService;", "Lmqq/app/api/IRuntimeService;", "", "reportAfterQQLogin", "reportAfterQQLoginBg", "reportAfterNTInit", "Lcr0/a;", "guildActiveInfo", "setActiveGuild", "channelActiveInfo", "setActiveChannel", "", "activeTab", "setActiveTab", "Companion", "a", "b", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public interface ILocalFocusService extends IRuntimeService {
    public static final int ACTIVIE_CHANNEL_ONESELF_TYPE = 2;
    public static final int ACTIVIE_CHANNEL_SPLASH = 1;
    public static final int ACTIVIE_GUILD_MF_TYPE = 1;
    public static final int ACTIVIE_GUILD_ONESELF_TYPE = 2;
    public static final int ACTIVIE_GUILD_RECENT_CHAT_TYPE = 3;
    public static final int ACTIVIE_NONE_TYPE = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f112476a;

    @NotNull
    public static final String INVALID_ID = "0";
    public static final int NOTIFY_FOCUS_ONGUILD = 2;
    public static final int NOTIFY_FOCUS_SESSION = 1;
    public static final int NOTIFY_TYPE_NONE = 0;
    public static final int SEL_TAB_CONVERSATION = 2;
    public static final int SEL_TAB_GUILD = 1;
    public static final int SEL_TAB_OTHER = 0;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/guild/api/ILocalFocusService$a;", "", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.api.ILocalFocusService$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f112476a = new Companion();

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0012\u001a\u0004\b\u0003\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/guild/api/ILocalFocusService$b;", "", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProContact;", "a", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProContact;", "b", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProContact;", "setConstant", "(Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProContact;)V", "constant", "", "Z", "c", "()Z", "setMsgTabFocus", "(Z)V", "msgTabFocus", "", "I", "()I", "activeStatus", "<init>", "(Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProContact;ZI)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private GProContact constant;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private boolean msgTabFocus;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int activeStatus;

        public b(@NotNull GProContact constant, boolean z16, int i3) {
            Intrinsics.checkNotNullParameter(constant, "constant");
            this.constant = constant;
            this.msgTabFocus = z16;
            this.activeStatus = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getActiveStatus() {
            return this.activeStatus;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final GProContact getConstant() {
            return this.constant;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getMsgTabFocus() {
            return this.msgTabFocus;
        }
    }

    void reportAfterNTInit();

    void reportAfterQQLogin();

    void reportAfterQQLoginBg();

    void setActiveChannel(@NotNull GuildActiveInfo channelActiveInfo);

    void setActiveGuild(@NotNull GuildActiveInfo guildActiveInfo);

    void setActiveTab(int activeTab);
}
