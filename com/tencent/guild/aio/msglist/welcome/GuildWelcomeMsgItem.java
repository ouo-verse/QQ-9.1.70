package com.tencent.guild.aio.msglist.welcome;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import com.tencent.guild.aio.util.l;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001HB)\u0012\u0006\u0010E\u001a\u00020D\u0012\u0006\u0010'\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010/\u001a\u00020\u001f\u00a2\u0006\u0004\bF\u0010GJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J8\u0010\f\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0002J\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0002J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0015H\u0016J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u0018H\u0016J\u0010\u0010!\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u0018H\u0016J\b\u0010\"\u001a\u00020\u001fH\u0016J\u0006\u0010#\u001a\u00020\u0006J\u0006\u0010$\u001a\u00020\u0006J\u0006\u0010%\u001a\u00020\u0004J\u0006\u0010&\u001a\u00020\u000bR\"\u0010'\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010(\u001a\u0004\b-\u0010*\"\u0004\b.\u0010,R\"\u0010/\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00105\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010;\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010(\u001a\u0004\b<\u0010*\"\u0004\b=\u0010,R\"\u0010>\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u00106\u001a\u0004\b?\u00108\"\u0004\b@\u0010:R\"\u0010A\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010(\u001a\u0004\bB\u0010*\"\u0004\bC\u0010,\u00a8\u0006I"}, d2 = {"Lcom/tencent/guild/aio/msglist/welcome/GuildWelcomeMsgItem;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "", "w", "", "homePageId", "guildCreator", "selfTid", "channelCreator", "", HippyTKDListViewAdapter.X, "guildId", "Lmqq/app/AppRuntime;", "app", "t", "", "channelInfoList", "u", "r", "", "channelType", "v", "Lcom/tencent/aio/data/msglist/a;", "cloneNewInstance", "", "getMsgId", "getMsgSeq", "getViewType", "target", "", "isSameContent", "isSameItem", "isSelf", "getSummaryMsg", "getTitle", "getTips", "init", "channelId", "Ljava/lang/String;", "getChannelId", "()Ljava/lang/String;", "setChannelId", "(Ljava/lang/String;)V", "getGuildId", "setGuildId", "showBottomLine", "Z", "getShowBottomLine", "()Z", "setShowBottomLine", "(Z)V", "welcomeType", "I", "getWelcomeType", "()I", "setWelcomeType", "(I)V", "showMsg", "getShowMsg", "setShowMsg", "iconResId", "getIconResId", "setIconResId", "titleText", "getTitleText", "setTitleText", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;Ljava/lang/String;Ljava/lang/String;Z)V", "WelcomeType", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildWelcomeMsgItem extends GuildMsgItem {

    @NotNull
    private String channelId;

    @NotNull
    private String guildId;
    private int iconResId;
    private boolean showBottomLine;

    @NotNull
    private String showMsg;

    @NotNull
    private String titleText;
    private int welcomeType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/guild/aio/msglist/welcome/GuildWelcomeMsgItem$WelcomeType;", "", "(Ljava/lang/String;I)V", "CREATE_GUILD", "CREATE_CHANNEL", "JOIN_GUILD", "JOIN_CHANNEL", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public enum WelcomeType {
        CREATE_GUILD,
        CREATE_CHANNEL,
        JOIN_GUILD,
        JOIN_CHANNEL
    }

    public /* synthetic */ GuildWelcomeMsgItem(MsgRecord msgRecord, String str, String str2, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(msgRecord, str, str2, (i3 & 8) != 0 ? false : z16);
    }

    private final IGProChannelInfo r(List<? extends IGProChannelInfo> channelInfoList) {
        Object minWithOrNull;
        ArrayList arrayList = new ArrayList();
        for (Object obj : channelInfoList) {
            IGProChannelInfo iGProChannelInfo = (IGProChannelInfo) obj;
            boolean z16 = true;
            if (iGProChannelInfo.getType() != 1 && (iGProChannelInfo.getType() != 6 || (((int) iGProChannelInfo.getApplicationId()) != 1000001 && ((int) iGProChannelInfo.getApplicationId()) != 1000137))) {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        final GuildWelcomeMsgItem$getFirstCreatedTextAbilityChannel$2 guildWelcomeMsgItem$getFirstCreatedTextAbilityChannel$2 = new Function2<IGProChannelInfo, IGProChannelInfo, Integer>() { // from class: com.tencent.guild.aio.msglist.welcome.GuildWelcomeMsgItem$getFirstCreatedTextAbilityChannel$2
            @Override // kotlin.jvm.functions.Function2
            @NotNull
            public final Integer invoke(IGProChannelInfo iGProChannelInfo2, IGProChannelInfo iGProChannelInfo3) {
                if (iGProChannelInfo2 != null && iGProChannelInfo3 != null) {
                    return Integer.valueOf(Intrinsics.compare(iGProChannelInfo2.getCreateTime(), iGProChannelInfo3.getCreateTime()));
                }
                return 0;
            }
        };
        minWithOrNull = CollectionsKt___CollectionsKt.minWithOrNull(arrayList, new Comparator() { // from class: com.tencent.guild.aio.msglist.welcome.d
            @Override // java.util.Comparator
            public final int compare(Object obj2, Object obj3) {
                int s16;
                s16 = GuildWelcomeMsgItem.s(Function2.this, obj2, obj3);
                return s16;
            }
        });
        return (IGProChannelInfo) minWithOrNull;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int s(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    private final IGProChannelInfo t(String guildId, AppRuntime app) {
        List<IGProChannelInfo> channelList = ((IGPSService) app.getRuntimeService(IGPSService.class, "")).getChannelList(guildId);
        Intrinsics.checkNotNullExpressionValue(channelList, "app.getRuntimeService(IG\u2026 .getChannelList(guildId)");
        if (channelList.size() == 0) {
            QLog.e(GuildMsgItem.TAG, 2, "getHomePageChannel: list = " + channelList, "guildId = " + guildId);
            return null;
        }
        return u(channelList);
    }

    private final IGProChannelInfo u(List<? extends IGProChannelInfo> channelInfoList) {
        return r(channelInfoList);
    }

    private final void v(int channelType) {
        int i3;
        if (1 == channelType) {
            i3 = R.drawable.guild_channel_text_chat_p;
        } else {
            i3 = R.drawable.guild_channel_app_p;
        }
        this.iconResId = i3;
    }

    private final CharSequence w(IGProChannelInfo channelInfo) {
        boolean z16;
        boolean z17;
        boolean z18;
        String str;
        int i3 = this.welcomeType;
        if (i3 == WelcomeType.CREATE_GUILD.ordinal() || i3 == WelcomeType.CREATE_CHANNEL.ordinal()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || i3 == WelcomeType.JOIN_GUILD.ordinal()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 || i3 == WelcomeType.JOIN_CHANNEL.ordinal()) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            if (channelInfo != null) {
                str = channelInfo.getChannelName();
            } else {
                str = null;
            }
            if (str == null) {
                str = l.b(l.f112411a, R.string.f142300j0, null, 2, null).toString();
            }
            String obj = l.b(l.f112411a, R.string.f158531pv, null, 2, null).toString();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) obj).append((CharSequence) " ").append((CharSequence) str);
            spannableStringBuilder.setSpan(new StyleSpan(1), 0, spannableStringBuilder.length(), 18);
            String spannableStringBuilder2 = spannableStringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(spannableStringBuilder2, "spanBuilder.toString()");
            this.titleText = spannableStringBuilder2;
            return spannableStringBuilder;
        }
        return "";
    }

    private final void x(String homePageId, IGProChannelInfo channelInfo, String guildCreator, String selfTid, String channelCreator) {
        WelcomeType welcomeType;
        int ordinal;
        WelcomeType welcomeType2;
        if (TextUtils.equals(homePageId, channelInfo.getChannelUin())) {
            if (TextUtils.equals(guildCreator, selfTid)) {
                welcomeType2 = WelcomeType.CREATE_GUILD;
            } else {
                welcomeType2 = WelcomeType.JOIN_GUILD;
            }
            ordinal = welcomeType2.ordinal();
        } else {
            if (TextUtils.equals(channelCreator, selfTid)) {
                welcomeType = WelcomeType.CREATE_CHANNEL;
            } else {
                welcomeType = WelcomeType.JOIN_CHANNEL;
            }
            ordinal = welcomeType.ordinal();
        }
        this.welcomeType = ordinal;
    }

    @Override // com.tencent.guild.api.data.msglist.GuildMsgItem, com.tencent.aio.data.msglist.a
    @NotNull
    public com.tencent.aio.data.msglist.a cloneNewInstance() {
        GuildWelcomeMsgItem guildWelcomeMsgItem = new GuildWelcomeMsgItem(getMsgRecord(), this.channelId, this.guildId, this.showBottomLine);
        guildWelcomeMsgItem.init();
        return guildWelcomeMsgItem;
    }

    @NotNull
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    public final String getGuildId() {
        return this.guildId;
    }

    public final int getIconResId() {
        return this.iconResId;
    }

    @Override // com.tencent.guild.api.data.msglist.GuildMsgItem, com.tencent.aio.data.msglist.a
    public long getMsgId() {
        return getMsgRecord().msgId;
    }

    @Override // com.tencent.guild.api.data.msglist.GuildMsgItem, com.tencent.aio.data.msglist.a
    public long getMsgSeq() {
        return 0L;
    }

    public final boolean getShowBottomLine() {
        return this.showBottomLine;
    }

    @NotNull
    public final String getShowMsg() {
        return this.showMsg;
    }

    @NotNull
    public final String getSummaryMsg() {
        return this.showMsg;
    }

    @NotNull
    public final CharSequence getTips() {
        int i3 = this.welcomeType;
        if (i3 == WelcomeType.CREATE_GUILD.ordinal()) {
            CharSequence text = MobileQQ.sMobileQQ.getResources().getText(R.string.f142950kr);
            Intrinsics.checkNotNullExpressionValue(text, "sMobileQQ.resources.getT\u2026guild_create_server_tips)");
            return text;
        }
        if (i3 == WelcomeType.CREATE_CHANNEL.ordinal()) {
            CharSequence text2 = MobileQQ.sMobileQQ.getResources().getText(R.string.f142840kg);
            Intrinsics.checkNotNullExpressionValue(text2, "sMobileQQ.resources.getT\u2026ate_channel_success_tips)");
            return text2;
        }
        if (i3 == WelcomeType.JOIN_GUILD.ordinal()) {
            CharSequence text3 = MobileQQ.sMobileQQ.getResources().getText(R.string.f147130w2);
            Intrinsics.checkNotNullExpressionValue(text3, "sMobileQQ.resources.getT\u2026oin_server_success_title)");
            return text3;
        }
        if (i3 == WelcomeType.JOIN_CHANNEL.ordinal()) {
            CharSequence text4 = MobileQQ.sMobileQQ.getResources().getText(R.string.f146960vl);
            Intrinsics.checkNotNullExpressionValue(text4, "sMobileQQ.resources.getT\u2026oin_channel_success_tips)");
            return text4;
        }
        return "";
    }

    @NotNull
    /* renamed from: getTitle, reason: from getter */
    public final String getTitleText() {
        return this.titleText;
    }

    @NotNull
    public final String getTitleText() {
        return this.titleText;
    }

    @Override // com.tencent.guild.api.data.msglist.GuildMsgItem, com.tencent.aio.data.msglist.a
    public int getViewType() {
        return 71;
    }

    public final int getWelcomeType() {
        return this.welcomeType;
    }

    public final void init() {
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        String str2 = "";
        IGProChannelInfo channelInfo = ((IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "")).getChannelInfo(this.channelId);
        if (channelInfo == null) {
            QLog.e(GuildMsgItem.TAG, 1, "init, channelInfo == null");
            return;
        }
        IGProGuildInfo guildInfo = ((IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "")).getGuildInfo(channelInfo.getGuildId());
        String guildId = channelInfo.getGuildId();
        Intrinsics.checkNotNullExpressionValue(guildId, "channelInfo.guildId");
        IGProChannelInfo t16 = t(guildId, peekAppRuntime);
        String selfTinyId = ((IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
        if (guildInfo == null) {
            str = "";
        } else {
            str = guildInfo.getCreatorId();
        }
        String creatorId = channelInfo.getCreatorId();
        if (t16 != null) {
            str2 = t16.getChannelUin();
        }
        x(str2, channelInfo, str, selfTinyId, creatorId);
        String string = MobileQQ.sMobileQQ.getResources().getString(R.string.f142280iy);
        Intrinsics.checkNotNullExpressionValue(string, "sMobileQQ.resources.getS\u2026uild_channel_welcome_msg)");
        this.showMsg = string;
        w(channelInfo);
        v(channelInfo.getType());
    }

    @Override // com.tencent.guild.api.data.msglist.GuildMsgItem, com.tencent.aio.data.msglist.a
    public boolean isSameContent(@NotNull com.tencent.aio.data.msglist.a target) {
        Intrinsics.checkNotNullParameter(target, "target");
        if (target instanceof GuildWelcomeMsgItem) {
            GuildWelcomeMsgItem guildWelcomeMsgItem = (GuildWelcomeMsgItem) target;
            if (Intrinsics.areEqual(this.channelId, guildWelcomeMsgItem.channelId) && this.welcomeType == guildWelcomeMsgItem.welcomeType && this.iconResId == guildWelcomeMsgItem.iconResId && this.showBottomLine == guildWelcomeMsgItem.showBottomLine && Intrinsics.areEqual(this.titleText, guildWelcomeMsgItem.titleText)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.guild.api.data.msglist.GuildMsgItem, com.tencent.aio.data.msglist.a
    public boolean isSameItem(@NotNull com.tencent.aio.data.msglist.a target) {
        Intrinsics.checkNotNullParameter(target, "target");
        if (target instanceof GuildWelcomeMsgItem) {
            GuildWelcomeMsgItem guildWelcomeMsgItem = (GuildWelcomeMsgItem) target;
            if (Intrinsics.areEqual(this.channelId, guildWelcomeMsgItem.channelId) && Intrinsics.areEqual(this.titleText, guildWelcomeMsgItem.titleText) && hashCode() == target.hashCode()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.guild.api.data.msglist.GuildMsgItem, com.tencent.aio.data.msglist.a
    public boolean isSelf() {
        return false;
    }

    public final void setChannelId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.channelId = str;
    }

    public final void setGuildId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.guildId = str;
    }

    public final void setIconResId(int i3) {
        this.iconResId = i3;
    }

    public final void setShowBottomLine(boolean z16) {
        this.showBottomLine = z16;
    }

    public final void setShowMsg(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.showMsg = str;
    }

    public final void setTitleText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.titleText = str;
    }

    public final void setWelcomeType(int i3) {
        this.welcomeType = i3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildWelcomeMsgItem(@NotNull MsgRecord msgRecord, @NotNull String channelId, @NotNull String guildId, boolean z16) {
        super(msgRecord);
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.channelId = channelId;
        this.guildId = guildId;
        this.showBottomLine = z16;
        this.showMsg = "";
        this.iconResId = R.drawable.guild_channel_text_chat_p;
        this.titleText = "";
        init();
    }
}
