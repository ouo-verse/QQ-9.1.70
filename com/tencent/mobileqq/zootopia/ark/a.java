package com.tencent.mobileqq.zootopia.ark;

import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0016\u0018\u0000 \u00112\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0012\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\f\u001a\u0004\b\u0003\u0010\r\"\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ark/a;", "", "", "a", "I", "c", "()I", "f", "(I)V", "source", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "guildId", "d", "channelId", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public class a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int source;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String guildId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String channelId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J)\u0010\b\u001a\u00020\u0007\"\b\b\u0000\u0010\u0003*\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00028\u0000\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000bR\u0014\u0010\u0014\u001a\u00020\u00138\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00138\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u000b\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ark/a$a;", "", "Lcom/tencent/mobileqq/zootopia/ark/a;", "T", "", "jsonStr", "paramObject", "", "a", "(Ljava/lang/String;Lcom/tencent/mobileqq/zootopia/ark/a;)Z", "KEY_BILL_NUM_LONG", "Ljava/lang/String;", "KEY_CHANNEL_ID_STRING", "KEY_EXPIRED_MSG_STRING", "KEY_GUILD_ID_STRING", "KEY_OWNER_UIN_LONG", "KEY_SOURCE_INT", "KEY_STATUS_INT", "KEY_TARGET_UIN_LONG", "", "SOURCE_C2C", "I", "SOURCE_CHANNEL", "TAG", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.ark.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <T extends a> boolean a(String jsonStr, T paramObject) {
            Intrinsics.checkNotNullParameter(paramObject, "paramObject");
            if (jsonStr == null) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(jsonStr);
                paramObject.f(jSONObject.optInt("source", 0));
                paramObject.d(jSONObject.optString("channelID", null));
                paramObject.e(jSONObject.optString("guildID", null));
                if (paramObject instanceof b) {
                    ((b) paramObject).h(jSONObject.optLong(IProfileProtocolConst.PARAM_TARGET_UIN, 0L));
                } else if (paramObject instanceof e) {
                    ((e) paramObject).h(jSONObject.optString("expiredMsg", null));
                } else if (paramObject instanceof c) {
                    ((c) paramObject).h(jSONObject.optLong("billNum", 0L));
                } else if (paramObject instanceof d) {
                    ((d) paramObject).k(jSONObject.optInt("status"));
                    ((d) paramObject).i(jSONObject.optLong("billNum", 0L));
                    d dVar = (d) paramObject;
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    dVar.j(jSONObject.optLong("ownerUin", peekAppRuntime != null ? peekAppRuntime.getLongAccountUin() : 0L));
                } else {
                    QLog.e("ArkParams", 1, "parseParams else");
                    return false;
                }
                return true;
            } catch (Throwable th5) {
                QLog.e("ArkParams", 1, "parseParams err.", th5);
                return false;
            }
        }

        Companion() {
        }
    }

    /* renamed from: a, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    /* renamed from: b, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    /* renamed from: c, reason: from getter */
    public final int getSource() {
        return this.source;
    }

    public final void d(String str) {
        this.channelId = str;
    }

    public final void e(String str) {
        this.guildId = str;
    }

    public final void f(int i3) {
        this.source = i3;
    }
}
