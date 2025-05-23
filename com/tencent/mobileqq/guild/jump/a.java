package com.tencent.mobileqq.guild.jump;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import com.tencent.avbiz.Constants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.util.aa;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.qphone.base.util.QLog;
import dq1.k;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/jump/a;", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static String f226399b = "";

    /* renamed from: c, reason: collision with root package name */
    private static int f226400c;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000bH\u0007J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J\b\u0010\u0013\u001a\u00020\u0010H\u0007J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\u0015\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/jump/a$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "param", "", "d", "", "c", "f", "", "openChannelId", "a", "sourceKey", tl.h.F, "", "channelPageSourceType", "g", "b", "e", "TAG", "Ljava/lang/String;", "mChannelPageSourceType", "I", "mSourceKey", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.jump.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean a(String openChannelId) {
            GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
            if (!TextUtils.equals(gLiveChannelCore.s().getChannelId(), openChannelId)) {
                LiveData<Boolean> D = gLiveChannelCore.t().D();
                Intrinsics.checkNotNullExpressionValue(D, "uiData.selfIsAnchorLiving");
                Object b16 = e12.d.b(D, Boolean.FALSE);
                Intrinsics.checkNotNullExpressionValue(b16, "uiData.selfIsAnchorLiving.getNonNull(false)");
                if (((Boolean) b16).booleanValue() && gLiveChannelCore.r().d()) {
                    aa.a(R.string.f148520zt);
                    return true;
                }
                return false;
            }
            return false;
        }

        private final boolean c(JumpGuildParam param) {
            int D = ch.D(param.getChannelId());
            if (D != 2) {
                if (D == 5) {
                    String channelId = param.getChannelId();
                    Intrinsics.checkNotNullExpressionValue(channelId, "param.channelId");
                    if (a(channelId)) {
                        return true;
                    }
                    int g16 = com.tencent.mobileqq.guild.util.h.g(Constants.Business.QQ_GUILD_LIVE_VIEWER);
                    if (g16 != 0) {
                        QLog.i("Guild.jump.GuildChannelJumpManager", 1, "handleBusinessLoginFilter: checkAvFocusState.");
                        aa.a(g16);
                        return true;
                    }
                    com.tencent.mobileqq.guild.util.h.j(1, Constants.Business.QQ_GUILD_LIVE_VIEWER);
                    return false;
                }
                return false;
            }
            String channelId2 = param.getChannelId();
            Intrinsics.checkNotNullExpressionValue(channelId2, "param.channelId");
            return a(channelId2);
        }

        private final void d(Context context, JumpGuildParam param) {
            param.getExtras().putString("param_first_show_text", HardCodeUtil.qqStr(R.string.f143530mb));
            QLog.i("Guild.jump.GuildChannelJumpManager", 1, "openChannel fetchChannelInfoAnyway is null guildId: " + param.guildId + " channelId: " + param.getChannelId());
            d12.a.d(context, param);
        }

        private final void f(Context context, JumpGuildParam param) {
            if (param.getJoinInfoParam().isValid()) {
                param.getJoinInfoParam().saveTo(param.extras);
            }
            if (param.getDetailPageJumpInfo() != null) {
                JumpGuildParam.ChannelDetailPageJumpInfo detailPageJumpInfo = param.getDetailPageJumpInfo();
                Intrinsics.checkNotNull(detailPageJumpInfo);
                detailPageJumpInfo.saveTo(param.extras);
            }
            String str = param.guildId;
            Intrinsics.checkNotNullExpressionValue(str, "param.guildId");
            String channelId = param.getChannelId();
            Intrinsics.checkNotNullExpressionValue(channelId, "param.channelId");
            k.b(str, channelId, param.extras).jump(context);
        }

        @JvmStatic
        public final int b() {
            return a.f226400c;
        }

        @JvmStatic
        public final void e(@NotNull Context context, @NotNull JumpGuildParam param) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(param, "param");
            QLog.i("Guild.jump.GuildChannelJumpManager", 1, "openChannel: mChannelPageSourceType: " + a.f226400c + " , param= " + param);
            IGProChannelInfo B = ch.B(param.getChannelId());
            if (B == null) {
                d(context, param);
                return;
            }
            if (c(param)) {
                QLog.d("Guild.jump.GuildChannelJumpManager", 1, "handleBusinessLoginFilter filtered!");
            } else if (B.getType() == 11) {
                d(context, param);
            } else {
                f(context, param);
            }
        }

        @JvmStatic
        public final void g(@NotNull String sourceKey, int channelPageSourceType) {
            Intrinsics.checkNotNullParameter(sourceKey, "sourceKey");
            QLog.i("Guild.jump.GuildChannelJumpManager", 1, "setChannelPageSourceType: sourceKey" + sourceKey + " channelPageSourceType:" + channelPageSourceType);
            if (!TextUtils.isEmpty(sourceKey)) {
                a.f226399b = sourceKey;
                a.f226400c = channelPageSourceType;
            }
        }

        @JvmStatic
        public final void h(@NotNull String sourceKey) {
            Intrinsics.checkNotNullParameter(sourceKey, "sourceKey");
            QLog.i("Guild.jump.GuildChannelJumpManager", 1, "unSetChannelPageSourceType: " + sourceKey);
            if (!TextUtils.isEmpty(sourceKey) && Intrinsics.areEqual(a.f226399b, sourceKey)) {
                a.f226399b = "";
                a.f226400c = 0;
            }
        }

        Companion() {
        }
    }

    @JvmStatic
    public static final int e() {
        return INSTANCE.b();
    }

    @JvmStatic
    public static final void f(@NotNull String str, int i3) {
        INSTANCE.g(str, i3);
    }

    @JvmStatic
    public static final void g(@NotNull String str) {
        INSTANCE.h(str);
    }
}
