package pp1;

import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBusinessInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBusinessNode;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProChannelMemberInfos;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildThemeInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRealTimeChannel;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRealTimeLiveChannel;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRealTimeVoiceChannel;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRoomInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUser;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUserAVInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUserDevState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J \u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0016"}, d2 = {"Lpp1/h;", "", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProRealTimeLiveChannel;", "liveInfo", "", "guildId", "channelId", "Lpp1/g;", "e", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProRoomInfo;", "roomInfo", "b", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProRealTimeVoiceChannel;", "audioInfo", "d", "Lpp1/e;", "a", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProRealTimeChannel;", "info", "c", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f426934a = new h();

    h() {
    }

    private final GuildAVAudioInactiveUIData a(GProRealTimeVoiceChannel audioInfo, String guildId, String channelId) {
        int i3;
        String str;
        GProChannelMemberInfos gProChannelMemberInfos = audioInfo.memberInfos;
        String str2 = null;
        if (gProChannelMemberInfos.isActive) {
            return null;
        }
        ArrayList<GProGuildThemeInfo> arrayList = gProChannelMemberInfos.channelConfig.themeList;
        Intrinsics.checkNotNullExpressionValue(arrayList, "audioInfo.memberInfos.channelConfig.themeList");
        Iterator<T> it = arrayList.iterator();
        int i16 = 1;
        loop0: while (true) {
            i3 = i16;
            while (it.hasNext()) {
                i16 = ((GProGuildThemeInfo) it.next()).themeType;
                if (i16 == 2 || i16 == 7 || i16 == 6 || i16 == 4) {
                }
            }
            break loop0;
        }
        IGProChannelInfo B = ch.B(channelId);
        if (B != null) {
            str2 = B.getChannelName();
        }
        if (str2 == null) {
            str = "";
        } else {
            str = str2;
        }
        String sessionId = audioInfo.memberInfos.channelConfig.themeInfo.sessionId;
        Intrinsics.checkNotNullExpressionValue(sessionId, "sessionId");
        return new GuildAVAudioInactiveUIData(channelId, guildId, str, sessionId, i3);
    }

    private final String b(GProRoomInfo roomInfo) {
        String str;
        boolean z16;
        boolean isBlank;
        HashMap<String, String> hashMap = roomInfo.roomIcons;
        Object obj = null;
        String str2 = "";
        if (hashMap != null) {
            String str3 = hashMap.get("1:1");
            if (str3 == null) {
                str3 = "";
            }
            str = str3;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Collection<String> values = roomInfo.roomIcons.values();
            Intrinsics.checkNotNullExpressionValue(values, "roomInfo.roomIcons.values");
            Iterator<T> it = values.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                String it5 = (String) next;
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                isBlank = StringsKt__StringsJVMKt.isBlank(it5);
                if (!isBlank) {
                    obj = next;
                    break;
                }
            }
            String str4 = (String) obj;
            if (str4 != null) {
                str2 = str4;
            }
            Intrinsics.checkNotNullExpressionValue(str2, "roomInfo.roomIcons.value\u2026{ it.isNotBlank() } ?: \"\"");
            return str2;
        }
        return str;
    }

    private final g d(GProRealTimeVoiceChannel audioInfo, String guildId, String channelId) {
        String str;
        boolean isBlank;
        String str2;
        boolean isBlank2;
        String str3;
        String str4;
        boolean z16;
        GProUserAVInfo gProUserAVInfo;
        GProUserDevState gProUserDevState;
        GuildAVAudioInactiveUIData a16 = a(audioInfo, guildId, channelId);
        if (a16 != null) {
            return a16;
        }
        ArrayList<GProUser> arrayList = new ArrayList();
        ArrayList<GProUser> arrayList2 = audioInfo.memberInfos.memberList;
        boolean z17 = false;
        if (arrayList2 != null) {
            for (GProUser user : arrayList2) {
                if (user.voiceInfo != null) {
                    GProBusinessInfo gProBusinessInfo = user.businessInfo;
                    if (gProBusinessInfo != null && (gProUserAVInfo = gProBusinessInfo.userAVInfo) != null && (gProUserDevState = gProUserAVInfo.userDevState) != null && gProUserDevState.micState == 2) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        Intrinsics.checkNotNullExpressionValue(user, "user");
                        arrayList.add(user);
                    }
                }
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (GProUser gProUser : arrayList) {
            String valueOf = String.valueOf(gProUser.tinyId);
            String str5 = gProUser.avatarMeta;
            Intrinsics.checkNotNullExpressionValue(str5, "it.avatarMeta");
            arrayList3.add(new GuildAVAudioOnlineMicUser(valueOf, str5, true));
        }
        ArrayList<GProGuildThemeInfo> arrayList4 = audioInfo.memberInfos.channelConfig.themeList;
        Intrinsics.checkNotNullExpressionValue(arrayList4, "audioInfo.memberInfos.channelConfig.themeList");
        Iterator<T> it = arrayList4.iterator();
        while (true) {
            String str6 = null;
            if (it.hasNext()) {
                GProGuildThemeInfo gProGuildThemeInfo = (GProGuildThemeInfo) it.next();
                int i3 = gProGuildThemeInfo.themeType;
                if (i3 != 4) {
                    if (i3 != 6) {
                        if (i3 == 7) {
                            ArrayList<GProBusinessNode> arrayList5 = audioInfo.memberInfos.channelConfig.businessList;
                            Intrinsics.checkNotNullExpressionValue(arrayList5, "audioInfo.memberInfos.channelConfig.businessList");
                            for (GProBusinessNode gProBusinessNode : arrayList5) {
                                if (gProBusinessNode.nodeType == 2) {
                                    String str7 = gProBusinessNode.screenShareInfo.screenPic;
                                    if (str7.length() == 0) {
                                        z17 = true;
                                    }
                                    if (z17) {
                                        str7 = "https://downv6.qq.com/innovate/guild/cover_info/active_channel_screen.png";
                                    }
                                    IGProChannelInfo B = ch.B(channelId);
                                    if (B != null) {
                                        str6 = B.getChannelName();
                                    }
                                    if (str6 == null) {
                                        str4 = "";
                                    } else {
                                        Intrinsics.checkNotNullExpressionValue(str6, "QQGuildUtil.getChannelIn\u2026nelId)?.channelName ?: \"\"");
                                        str4 = str6;
                                    }
                                    String themeName = gProGuildThemeInfo.themeName;
                                    GProChannelMemberInfos gProChannelMemberInfos = audioInfo.memberInfos;
                                    int i16 = gProChannelMemberInfos.noMemberMaxLimit;
                                    int i17 = gProChannelMemberInfos.channelMemberMax;
                                    int i18 = gProChannelMemberInfos.channelMemberCount;
                                    String sessionId = gProChannelMemberInfos.channelConfig.themeInfo.sessionId;
                                    Intrinsics.checkNotNullExpressionValue(str7, "ifEmpty { SCREEN_SHARE_DEFAULT_BG }");
                                    Intrinsics.checkNotNullExpressionValue(themeName, "themeName");
                                    Intrinsics.checkNotNullExpressionValue(sessionId, "sessionId");
                                    return new GuildAVAudioActiveScreenUIData(guildId, channelId, str4, str7, themeName, i16, i17, i18, sessionId, 7);
                                }
                            }
                        }
                    } else {
                        String str8 = gProGuildThemeInfo.themeBgImg;
                        isBlank2 = StringsKt__StringsJVMKt.isBlank(str8);
                        if (isBlank2) {
                            str8 = gProGuildThemeInfo.themeIcon;
                        }
                        IGProChannelInfo B2 = ch.B(channelId);
                        if (B2 != null) {
                            str6 = B2.getChannelName();
                        }
                        if (str6 == null) {
                            str3 = "";
                        } else {
                            Intrinsics.checkNotNullExpressionValue(str6, "QQGuildUtil.getChannelIn\u2026nelId)?.channelName ?: \"\"");
                            str3 = str6;
                        }
                        String themeName2 = gProGuildThemeInfo.themeName;
                        GProChannelMemberInfos gProChannelMemberInfos2 = audioInfo.memberInfos;
                        int i19 = gProChannelMemberInfos2.noMemberMaxLimit;
                        int i26 = gProChannelMemberInfos2.channelMemberMax;
                        int i27 = gProChannelMemberInfos2.channelMemberCount;
                        String sessionId2 = gProChannelMemberInfos2.channelConfig.themeInfo.sessionId;
                        Intrinsics.checkNotNullExpressionValue(str8, "ifBlank { theme.themeIcon }");
                        Intrinsics.checkNotNullExpressionValue(themeName2, "themeName");
                        Intrinsics.checkNotNullExpressionValue(sessionId2, "sessionId");
                        return new GuildAVAudioActiveLobbyUIData(guildId, channelId, str3, str8, arrayList3, themeName2, i19, i26, i27, sessionId2, 6);
                    }
                } else {
                    String str9 = gProGuildThemeInfo.themeBgImg;
                    isBlank = StringsKt__StringsJVMKt.isBlank(str9);
                    if (isBlank) {
                        str9 = gProGuildThemeInfo.themeIcon;
                    }
                    IGProChannelInfo B3 = ch.B(channelId);
                    if (B3 != null) {
                        str6 = B3.getChannelName();
                    }
                    if (str6 == null) {
                        str2 = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(str6, "QQGuildUtil.getChannelIn\u2026nelId)?.channelName ?: \"\"");
                        str2 = str6;
                    }
                    String themeName3 = gProGuildThemeInfo.themeName;
                    GProChannelMemberInfos gProChannelMemberInfos3 = audioInfo.memberInfos;
                    int i28 = gProChannelMemberInfos3.noMemberMaxLimit;
                    int i29 = gProChannelMemberInfos3.channelMemberMax;
                    int i36 = gProChannelMemberInfos3.channelMemberCount;
                    String sessionId3 = gProChannelMemberInfos3.channelConfig.themeInfo.sessionId;
                    Intrinsics.checkNotNullExpressionValue(str9, "ifBlank { theme.themeIcon }");
                    Intrinsics.checkNotNullExpressionValue(themeName3, "themeName");
                    Intrinsics.checkNotNullExpressionValue(sessionId3, "sessionId");
                    return new GuildAVAudioActiveListenUIData(guildId, channelId, str2, str9, arrayList3, themeName3, i28, i29, i36, sessionId3, 4);
                }
            } else {
                IGProChannelInfo B4 = ch.B(channelId);
                if (B4 != null) {
                    str6 = B4.getChannelName();
                }
                if (str6 == null) {
                    str = "";
                } else {
                    str = str6;
                }
                GProChannelMemberInfos gProChannelMemberInfos4 = audioInfo.memberInfos;
                int i37 = gProChannelMemberInfos4.noMemberMaxLimit;
                int i38 = gProChannelMemberInfos4.channelMemberMax;
                int i39 = gProChannelMemberInfos4.channelMemberCount;
                String sessionId4 = gProChannelMemberInfos4.channelConfig.themeInfo.sessionId;
                Intrinsics.checkNotNullExpressionValue(sessionId4, "sessionId");
                return new GuildAVAudioActiveNormalUIData(channelId, guildId, str, arrayList3, i37, i38, i39, sessionId4, 1);
            }
        }
    }

    private final g e(GProRealTimeLiveChannel liveInfo, String guildId, String channelId) {
        String str;
        boolean z16;
        String str2 = "";
        String str3 = null;
        if (liveInfo.roomInfo.isActive) {
            IGProChannelInfo B = ch.B(channelId);
            if (B != null) {
                str3 = B.getChannelName();
            }
            if (str3 == null) {
                str = "";
            } else {
                str = str3;
            }
            GProRoomInfo gProRoomInfo = liveInfo.roomInfo.roomInfo;
            Intrinsics.checkNotNullExpressionValue(gProRoomInfo, "liveInfo.roomInfo.roomInfo");
            String b16 = b(gProRoomInfo);
            if (b16.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                b16 = "https://downv6.qq.com/innovate/guild/cover_info/active_channel_live.png";
            }
            return new GuildAVLiveActiveData(guildId, channelId, str, b16, null, String.valueOf(liveInfo.roomInfo.roomInfo.roomId), 16, null);
        }
        IGProChannelInfo B2 = ch.B(channelId);
        if (B2 != null) {
            str3 = B2.getChannelName();
        }
        if (str3 != null) {
            str2 = str3;
        }
        return new k(guildId, channelId, str2, String.valueOf(liveInfo.roomInfo.roomInfo.roomId));
    }

    @Nullable
    public final g c(@NotNull GProRealTimeChannel info, @NotNull String guildId) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        int i3 = info.channelType;
        if (i3 != 2) {
            if (i3 != 5) {
                return null;
            }
            GProRealTimeLiveChannel gProRealTimeLiveChannel = info.liveChannel;
            Intrinsics.checkNotNullExpressionValue(gProRealTimeLiveChannel, "info.liveChannel");
            String str = info.channelId;
            Intrinsics.checkNotNullExpressionValue(str, "info.channelId");
            return e(gProRealTimeLiveChannel, guildId, str);
        }
        GProRealTimeVoiceChannel gProRealTimeVoiceChannel = info.voiceChannel;
        Intrinsics.checkNotNullExpressionValue(gProRealTimeVoiceChannel, "info.voiceChannel");
        String str2 = info.channelId;
        Intrinsics.checkNotNullExpressionValue(str2, "info.channelId");
        return d(gProRealTimeVoiceChannel, guildId, str2);
    }
}
