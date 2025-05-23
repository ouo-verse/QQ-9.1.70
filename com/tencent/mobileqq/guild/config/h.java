package com.tencent.mobileqq.guild.config;

import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0016\u0018\u0000 \u00172\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0003\u0010\b\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/config/h;", "Lcom/tencent/freesia/IConfigData;", "", "d", "I", "getGuildGrayEnterChannelTimes", "()I", "b", "(I)V", "guildGrayEnterChannelTimes", "e", "getGuildGraySentMessagesNums", "c", "guildGraySentMessagesNums", "f", "getGuildGrayChannelStayTimes", "a", "guildGrayChannelStayTimes", tl.h.F, "getGuildGrayUserDailyTriggerTimes", "guildGrayUserDailyTriggerTimes", "<init>", "()V", "i", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class h implements IConfigData {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int guildGrayEnterChannelTimes = 5;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int guildGraySentMessagesNums = 3;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int guildGrayChannelStayTimes = 600000;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int guildGrayUserDailyTriggerTimes = 3;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/config/h$a;", "", "", "content", "Lcom/tencent/mobileqq/guild/config/h;", "a", "GUILD_GRAY_CHANNEL_STAY_TIMES", "Ljava/lang/String;", "GUILD_GRAY_ENTER_CHANNEL_TIMES", "GUILD_GRAY_SENT_MESSAGES_NUMS", "GUILD_GRAY_USER_DAILY_TRIGGER_TIMES", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.config.h$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final h a(@Nullable String content) {
            boolean z16;
            QLog.i("Guild.config.GuildPositiveFeedbackGrayConfig", 4, "parse GuildPositiveFeedbackGrayConfig content:" + content);
            h hVar = new h();
            if (content != null && content.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return hVar;
            }
            try {
                JSONObject jSONObject = new JSONObject(content);
                if (jSONObject.has("guildGrayEnterChannelTimes")) {
                    hVar.b(jSONObject.optInt("guildGrayEnterChannelTimes"));
                }
                if (jSONObject.has("guildGrayEnterChannelTimes")) {
                    hVar.c(jSONObject.optInt("guildGraySentMessagesNums"));
                }
                if (jSONObject.has("guildGrayEnterChannelTimes")) {
                    hVar.a(jSONObject.optInt("guildGrayChannelStayTimes") * 60 * 1000);
                }
                if (jSONObject.has("guildGrayUserDailyTriggerTimes")) {
                    hVar.d(jSONObject.optInt("guildGrayUserDailyTriggerTimes"));
                }
            } catch (JSONException e16) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "error parse GuildPositiveFeedbackGrayConfig content:" + content;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.config.GuildPositiveFeedbackGrayConfig", 1, (String) it.next(), e16);
                }
            }
            return hVar;
        }

        Companion() {
        }
    }

    public final void a(int i3) {
        this.guildGrayChannelStayTimes = i3;
    }

    public final void b(int i3) {
        this.guildGrayEnterChannelTimes = i3;
    }

    public final void c(int i3) {
        this.guildGraySentMessagesNums = i3;
    }

    public final void d(int i3) {
        this.guildGrayUserDailyTriggerTimes = i3;
    }
}
