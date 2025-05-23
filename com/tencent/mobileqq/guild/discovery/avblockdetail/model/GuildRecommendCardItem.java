package com.tencent.mobileqq.guild.discovery.avblockdetail.model;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendExtra;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendLabel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bK\b\u0086\b\u0018\u0000 q2\u00020\u00012\u00020\u0002:\u0001rB\u008b\u0002\u0012\b\b\u0002\u0010*\u001a\u00020\u000b\u0012\b\b\u0002\u0010+\u001a\u00020\u000b\u0012\u0006\u0010,\u001a\u00020\u000b\u0012\u0006\u0010-\u001a\u00020\u000b\u0012\b\u0010.\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010/\u001a\u00020\u0011\u0012\u0006\u00100\u001a\u00020\u000b\u0012\u0006\u00101\u001a\u00020\u000b\u0012\u0006\u00102\u001a\u00020\u000b\u0012\u0006\u00103\u001a\u00020\u000b\u0012\u0006\u00104\u001a\u00020\u0005\u0012\u0006\u00105\u001a\u00020\u0005\u0012\b\b\u0002\u00106\u001a\u00020\u0011\u0012\b\b\u0002\u00107\u001a\u00020\u000b\u0012\b\b\u0002\u00108\u001a\u00020\u0011\u0012\b\b\u0002\u00109\u001a\u00020\u000b\u0012\b\b\u0002\u0010:\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010;\u001a\b\u0012\u0004\u0012\u00020\u000b0\b\u0012\b\b\u0002\u0010<\u001a\u00020\u0011\u0012\b\b\u0002\u0010=\u001a\u00020\u0005\u0012\b\b\u0002\u0010>\u001a\u00020\u0011\u0012\u0016\b\u0002\u0010?\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00030\"\u0012\u0006\u0010@\u001a\u00020$\u0012\f\u0010A\u001a\b\u0012\u0004\u0012\u00020&0\b\u0012\u000e\b\u0002\u0010B\u001a\b\u0012\u0004\u0012\u00020(0\b\u00a2\u0006\u0004\bo\u0010pJ\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\t\u0010\f\u001a\u00020\u000bH\u00c6\u0003J\t\u0010\r\u001a\u00020\u000bH\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u000bH\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u000bH\u00c6\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0011H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u000bH\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u000bH\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u000bH\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u000bH\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0011H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u000bH\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0011H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u000bH\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u000bH\u00c6\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\bH\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0011H\u00c6\u0003J\t\u0010 \u001a\u00020\u0005H\u00c6\u0003J\t\u0010!\u001a\u00020\u0011H\u00c6\u0003J\u0017\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00030\"H\u00c6\u0003J\t\u0010%\u001a\u00020$H\u00c6\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\bH\u00c6\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\bH\u00c6\u0003J\u00a5\u0002\u0010C\u001a\u00020\u00002\b\b\u0002\u0010*\u001a\u00020\u000b2\b\b\u0002\u0010+\u001a\u00020\u000b2\b\b\u0002\u0010,\u001a\u00020\u000b2\b\b\u0002\u0010-\u001a\u00020\u000b2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010/\u001a\u00020\u00112\b\b\u0002\u00100\u001a\u00020\u000b2\b\b\u0002\u00101\u001a\u00020\u000b2\b\b\u0002\u00102\u001a\u00020\u000b2\b\b\u0002\u00103\u001a\u00020\u000b2\b\b\u0002\u00104\u001a\u00020\u00052\b\b\u0002\u00105\u001a\u00020\u00052\b\b\u0002\u00106\u001a\u00020\u00112\b\b\u0002\u00107\u001a\u00020\u000b2\b\b\u0002\u00108\u001a\u00020\u00112\b\b\u0002\u00109\u001a\u00020\u000b2\b\b\u0002\u0010:\u001a\u00020\u000b2\u000e\b\u0002\u0010;\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\b\b\u0002\u0010<\u001a\u00020\u00112\b\b\u0002\u0010=\u001a\u00020\u00052\b\b\u0002\u0010>\u001a\u00020\u00112\u0016\b\u0002\u0010?\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00030\"2\b\b\u0002\u0010@\u001a\u00020$2\u000e\b\u0002\u0010A\u001a\b\u0012\u0004\u0012\u00020&0\b2\u000e\b\u0002\u0010B\u001a\b\u0012\u0004\u0012\u00020(0\bH\u00c6\u0001J\t\u0010D\u001a\u00020\u000bH\u00d6\u0001J\t\u0010E\u001a\u00020\u0011H\u00d6\u0001R\u001a\u0010*\u001a\u00020\u000b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b*\u0010F\u001a\u0004\bG\u0010HR\u001a\u0010+\u001a\u00020\u000b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b+\u0010F\u001a\u0004\bI\u0010HR\u0017\u0010,\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b,\u0010F\u001a\u0004\bJ\u0010HR\u0017\u0010-\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b-\u0010F\u001a\u0004\bK\u0010HR\u0019\u0010.\u001a\u0004\u0018\u00010\u000b8\u0006\u00a2\u0006\f\n\u0004\b.\u0010F\u001a\u0004\bL\u0010HR\"\u0010/\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u0017\u00100\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b0\u0010F\u001a\u0004\bR\u0010HR\u0017\u00101\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b1\u0010F\u001a\u0004\bS\u0010HR\u0017\u00102\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b2\u0010F\u001a\u0004\bT\u0010HR\u0017\u00103\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b3\u0010F\u001a\u0004\bU\u0010HR\u0017\u00104\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b4\u0010V\u001a\u0004\bW\u0010XR\u0017\u00105\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b5\u0010V\u001a\u0004\b5\u0010XR\u0017\u00106\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b6\u0010M\u001a\u0004\bY\u0010OR\u0017\u00107\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b7\u0010F\u001a\u0004\bZ\u0010HR\u0017\u00108\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b8\u0010M\u001a\u0004\b[\u0010OR\u0017\u00109\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b9\u0010F\u001a\u0004\b\\\u0010HR\u0017\u0010:\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b:\u0010F\u001a\u0004\b]\u0010HR\u001d\u0010;\u001a\b\u0012\u0004\u0012\u00020\u000b0\b8\u0006\u00a2\u0006\f\n\u0004\b;\u0010^\u001a\u0004\b_\u0010`R\"\u0010<\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010M\u001a\u0004\ba\u0010O\"\u0004\bb\u0010QR\u0017\u0010=\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b=\u0010V\u001a\u0004\b=\u0010XR\"\u0010>\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010M\u001a\u0004\bc\u0010O\"\u0004\bd\u0010QR0\u0010?\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00030\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u0017\u0010@\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b@\u0010j\u001a\u0004\bk\u0010lR\u001d\u0010A\u001a\b\u0012\u0004\u0012\u00020&0\b8\u0006\u00a2\u0006\f\n\u0004\bA\u0010^\u001a\u0004\bm\u0010`R\u001d\u0010B\u001a\b\u0012\u0004\u0012\u00020(0\b8\u0006\u00a2\u0006\f\n\u0004\bB\u0010^\u001a\u0004\bn\u0010`\u00a8\u0006s"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/avblockdetail/model/GuildRecommendCardItem;", "Ljava/io/Serializable;", "Lcom/tencent/mobileqq/guild/discovery/avblockdetail/model/a;", "", "other", "", "equals", "newItem", "", "getDiffPayload", "areSameForUI", "", "component1", "component2", "component3", "component4", "component5", "", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "", "component22", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendExtra;", "component23", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMedalInfo;", "component24", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendLabel;", "component25", "itemId", "traceId", "curCategoryName", "guildId", "joinGuildSig", "joinGuildFlag", "guildName", "guildProfile", "guildIconUrl", "guildCoverUrl", "hasMedal", "isLeftItem", "channelStatus", "channelStatusText", "friendJoinedNum", "onlineNumberString", "topTagText", "wuJiTags", "itemCategoryPosition", "isShowInGuildRecommendTab", "configureChangeWidth", "dtParams", "recommendExtra", "medalInfoList", "tagList", "copy", "toString", "hashCode", "Ljava/lang/String;", "getItemId", "()Ljava/lang/String;", "getTraceId", "getCurCategoryName", "getGuildId", "getJoinGuildSig", "I", "getJoinGuildFlag", "()I", "setJoinGuildFlag", "(I)V", "getGuildName", "getGuildProfile", "getGuildIconUrl", "getGuildCoverUrl", "Z", "getHasMedal", "()Z", "getChannelStatus", "getChannelStatusText", "getFriendJoinedNum", "getOnlineNumberString", "getTopTagText", "Ljava/util/List;", "getWuJiTags", "()Ljava/util/List;", "getItemCategoryPosition", "setItemCategoryPosition", "getConfigureChangeWidth", "setConfigureChangeWidth", "Ljava/util/Map;", "getDtParams", "()Ljava/util/Map;", "setDtParams", "(Ljava/util/Map;)V", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendExtra;", "getRecommendExtra", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendExtra;", "getMedalInfoList", "getTagList", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;IZILjava/util/Map;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendExtra;Ljava/util/List;Ljava/util/List;)V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final /* data */ class GuildRecommendCardItem extends a implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int FLAG_JOIN_GUILD = 2;
    public static final int FLAG_UN_JOIN_GUILD = 1;
    private final int channelStatus;

    @NotNull
    private final String channelStatusText;
    private int configureChangeWidth;

    @NotNull
    private final String curCategoryName;

    @NotNull
    private Map<String, ? extends Object> dtParams;
    private final int friendJoinedNum;

    @NotNull
    private final String guildCoverUrl;

    @NotNull
    private final String guildIconUrl;

    @NotNull
    private final String guildId;

    @NotNull
    private final String guildName;

    @NotNull
    private final String guildProfile;
    private final boolean hasMedal;
    private final boolean isLeftItem;
    private final boolean isShowInGuildRecommendTab;
    private int itemCategoryPosition;

    @NotNull
    private final String itemId;
    private int joinGuildFlag;

    @Nullable
    private final String joinGuildSig;

    @NotNull
    private final List<IGProMedalInfo> medalInfoList;

    @NotNull
    private final String onlineNumberString;

    @NotNull
    private final IGProRecommendExtra recommendExtra;

    @NotNull
    private final List<IGProRecommendLabel> tagList;

    @NotNull
    private final String topTagText;

    @NotNull
    private final String traceId;

    @NotNull
    private final List<String> wuJiTags;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/avblockdetail/model/GuildRecommendCardItem$a;", "", "", "FLAG_JOIN_GUILD", "I", "FLAG_UN_JOIN_GUILD", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.discovery.avblockdetail.model.GuildRecommendCardItem$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }
    }

    public /* synthetic */ GuildRecommendCardItem(String str, String str2, String str3, String str4, String str5, int i3, String str6, String str7, String str8, String str9, boolean z16, boolean z17, int i16, String str10, int i17, String str11, String str12, List list, int i18, boolean z18, int i19, Map map, IGProRecommendExtra iGProRecommendExtra, List list2, List list3, int i26, DefaultConstructorMarker defaultConstructorMarker) {
        this((i26 & 1) != 0 ? "GuildRecommendCardItem" : str, (i26 & 2) != 0 ? "" : str2, str3, str4, str5, i3, str6, str7, str8, str9, z16, z17, (i26 & 4096) != 0 ? 0 : i16, (i26 & 8192) != 0 ? "" : str10, (i26 & 16384) != 0 ? 0 : i17, (32768 & i26) != 0 ? "" : str11, (65536 & i26) != 0 ? "" : str12, (131072 & i26) != 0 ? new ArrayList() : list, (262144 & i26) != 0 ? 0 : i18, (524288 & i26) != 0 ? false : z18, (1048576 & i26) != 0 ? 0 : i19, (2097152 & i26) != 0 ? new HashMap() : map, iGProRecommendExtra, list2, (i26 & 16777216) != 0 ? new ArrayList() : list3);
    }

    public final boolean areSameForUI(@Nullable Object other) {
        Class<?> cls;
        if (this == other) {
            return true;
        }
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(GuildRecommendCardItem.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.mobileqq.guild.discovery.avblockdetail.model.GuildRecommendCardItem");
        GuildRecommendCardItem guildRecommendCardItem = (GuildRecommendCardItem) other;
        if (!Intrinsics.areEqual(getItemId(), guildRecommendCardItem.getItemId()) || !Intrinsics.areEqual(this.curCategoryName, guildRecommendCardItem.curCategoryName) || !Intrinsics.areEqual(this.guildId, guildRecommendCardItem.guildId) || !Intrinsics.areEqual(this.joinGuildSig, guildRecommendCardItem.joinGuildSig) || this.joinGuildFlag != guildRecommendCardItem.joinGuildFlag || !Intrinsics.areEqual(this.guildName, guildRecommendCardItem.guildName) || !Intrinsics.areEqual(this.guildProfile, guildRecommendCardItem.guildProfile) || !Intrinsics.areEqual(this.guildIconUrl, guildRecommendCardItem.guildIconUrl) || this.channelStatus != guildRecommendCardItem.channelStatus || !Intrinsics.areEqual(this.channelStatusText, guildRecommendCardItem.channelStatusText) || this.friendJoinedNum != guildRecommendCardItem.friendJoinedNum || !Intrinsics.areEqual(this.wuJiTags, guildRecommendCardItem.wuJiTags) || this.itemCategoryPosition != guildRecommendCardItem.itemCategoryPosition || this.configureChangeWidth != guildRecommendCardItem.configureChangeWidth || !Intrinsics.areEqual(this.dtParams, guildRecommendCardItem.dtParams) || this.medalInfoList.size() != guildRecommendCardItem.medalInfoList.size()) {
            return false;
        }
        int size = this.medalInfoList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!Intrinsics.areEqual(this.medalInfoList.get(i3).getName(), guildRecommendCardItem.medalInfoList.get(i3).getName())) {
                return false;
            }
        }
        if (this.tagList.size() != guildRecommendCardItem.tagList.size()) {
            return false;
        }
        int size2 = this.tagList.size();
        for (int i16 = 0; i16 < size2; i16++) {
            IGProRecommendLabel iGProRecommendLabel = this.tagList.get(i16);
            IGProRecommendLabel iGProRecommendLabel2 = guildRecommendCardItem.tagList.get(i16);
            if (iGProRecommendLabel.getBussiLabelType() != iGProRecommendLabel2.getBussiLabelType() || !Intrinsics.areEqual(iGProRecommendLabel.getLabelName(), iGProRecommendLabel2.getLabelName())) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public final String component1() {
        return getItemId();
    }

    @NotNull
    /* renamed from: component10, reason: from getter */
    public final String getGuildCoverUrl() {
        return this.guildCoverUrl;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getHasMedal() {
        return this.hasMedal;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getIsLeftItem() {
        return this.isLeftItem;
    }

    /* renamed from: component13, reason: from getter */
    public final int getChannelStatus() {
        return this.channelStatus;
    }

    @NotNull
    /* renamed from: component14, reason: from getter */
    public final String getChannelStatusText() {
        return this.channelStatusText;
    }

    /* renamed from: component15, reason: from getter */
    public final int getFriendJoinedNum() {
        return this.friendJoinedNum;
    }

    @NotNull
    /* renamed from: component16, reason: from getter */
    public final String getOnlineNumberString() {
        return this.onlineNumberString;
    }

    @NotNull
    /* renamed from: component17, reason: from getter */
    public final String getTopTagText() {
        return this.topTagText;
    }

    @NotNull
    public final List<String> component18() {
        return this.wuJiTags;
    }

    /* renamed from: component19, reason: from getter */
    public final int getItemCategoryPosition() {
        return this.itemCategoryPosition;
    }

    @NotNull
    public final String component2() {
        return getTraceId();
    }

    /* renamed from: component20, reason: from getter */
    public final boolean getIsShowInGuildRecommendTab() {
        return this.isShowInGuildRecommendTab;
    }

    /* renamed from: component21, reason: from getter */
    public final int getConfigureChangeWidth() {
        return this.configureChangeWidth;
    }

    @NotNull
    public final Map<String, Object> component22() {
        return this.dtParams;
    }

    @NotNull
    /* renamed from: component23, reason: from getter */
    public final IGProRecommendExtra getRecommendExtra() {
        return this.recommendExtra;
    }

    @NotNull
    public final List<IGProMedalInfo> component24() {
        return this.medalInfoList;
    }

    @NotNull
    public final List<IGProRecommendLabel> component25() {
        return this.tagList;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getCurCategoryName() {
        return this.curCategoryName;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getJoinGuildSig() {
        return this.joinGuildSig;
    }

    /* renamed from: component6, reason: from getter */
    public final int getJoinGuildFlag() {
        return this.joinGuildFlag;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final String getGuildName() {
        return this.guildName;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final String getGuildProfile() {
        return this.guildProfile;
    }

    @NotNull
    /* renamed from: component9, reason: from getter */
    public final String getGuildIconUrl() {
        return this.guildIconUrl;
    }

    @NotNull
    public final GuildRecommendCardItem copy(@NotNull String itemId, @NotNull String traceId, @NotNull String curCategoryName, @NotNull String guildId, @Nullable String joinGuildSig, int joinGuildFlag, @NotNull String guildName, @NotNull String guildProfile, @NotNull String guildIconUrl, @NotNull String guildCoverUrl, boolean hasMedal, boolean isLeftItem, int channelStatus, @NotNull String channelStatusText, int friendJoinedNum, @NotNull String onlineNumberString, @NotNull String topTagText, @NotNull List<String> wuJiTags, int itemCategoryPosition, boolean isShowInGuildRecommendTab, int configureChangeWidth, @NotNull Map<String, ? extends Object> dtParams, @NotNull IGProRecommendExtra recommendExtra, @NotNull List<? extends IGProMedalInfo> medalInfoList, @NotNull List<? extends IGProRecommendLabel> tagList) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(curCategoryName, "curCategoryName");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(guildName, "guildName");
        Intrinsics.checkNotNullParameter(guildProfile, "guildProfile");
        Intrinsics.checkNotNullParameter(guildIconUrl, "guildIconUrl");
        Intrinsics.checkNotNullParameter(guildCoverUrl, "guildCoverUrl");
        Intrinsics.checkNotNullParameter(channelStatusText, "channelStatusText");
        Intrinsics.checkNotNullParameter(onlineNumberString, "onlineNumberString");
        Intrinsics.checkNotNullParameter(topTagText, "topTagText");
        Intrinsics.checkNotNullParameter(wuJiTags, "wuJiTags");
        Intrinsics.checkNotNullParameter(dtParams, "dtParams");
        Intrinsics.checkNotNullParameter(recommendExtra, "recommendExtra");
        Intrinsics.checkNotNullParameter(medalInfoList, "medalInfoList");
        Intrinsics.checkNotNullParameter(tagList, "tagList");
        return new GuildRecommendCardItem(itemId, traceId, curCategoryName, guildId, joinGuildSig, joinGuildFlag, guildName, guildProfile, guildIconUrl, guildCoverUrl, hasMedal, isLeftItem, channelStatus, channelStatusText, friendJoinedNum, onlineNumberString, topTagText, wuJiTags, itemCategoryPosition, isShowInGuildRecommendTab, configureChangeWidth, dtParams, recommendExtra, medalInfoList, tagList);
    }

    public boolean equals(@Nullable Object other) {
        if (other == INSTANCE) {
            return true;
        }
        if (!(other instanceof GuildRecommendCardItem)) {
            return false;
        }
        GuildRecommendCardItem guildRecommendCardItem = (GuildRecommendCardItem) other;
        if (Intrinsics.areEqual(this.curCategoryName, guildRecommendCardItem.curCategoryName) && Intrinsics.areEqual(this.guildId, guildRecommendCardItem.guildId) && this.joinGuildFlag == guildRecommendCardItem.joinGuildFlag && this.configureChangeWidth == guildRecommendCardItem.configureChangeWidth && this.channelStatus == guildRecommendCardItem.channelStatus) {
            return true;
        }
        return false;
    }

    public final int getChannelStatus() {
        return this.channelStatus;
    }

    @NotNull
    public final String getChannelStatusText() {
        return this.channelStatusText;
    }

    public final int getConfigureChangeWidth() {
        return this.configureChangeWidth;
    }

    @NotNull
    public final String getCurCategoryName() {
        return this.curCategoryName;
    }

    @Override // com.tencent.mobileqq.guild.discovery.avblockdetail.model.a
    @NotNull
    public List<Object> getDiffPayload(@NotNull a newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!(newItem instanceof GuildRecommendCardItem)) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        GuildRecommendCardItem guildRecommendCardItem = (GuildRecommendCardItem) newItem;
        if (this.joinGuildFlag != guildRecommendCardItem.joinGuildFlag) {
            arrayList.add(guildRecommendCardItem.guildId);
        }
        return arrayList;
    }

    @NotNull
    public final Map<String, Object> getDtParams() {
        return this.dtParams;
    }

    public final int getFriendJoinedNum() {
        return this.friendJoinedNum;
    }

    @NotNull
    public final String getGuildCoverUrl() {
        return this.guildCoverUrl;
    }

    @NotNull
    public final String getGuildIconUrl() {
        return this.guildIconUrl;
    }

    @NotNull
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    public final String getGuildName() {
        return this.guildName;
    }

    @NotNull
    public final String getGuildProfile() {
        return this.guildProfile;
    }

    public final boolean getHasMedal() {
        return this.hasMedal;
    }

    public final int getItemCategoryPosition() {
        return this.itemCategoryPosition;
    }

    @Override // com.tencent.mobileqq.guild.discovery.avblockdetail.model.a
    @NotNull
    public String getItemId() {
        return this.itemId;
    }

    public final int getJoinGuildFlag() {
        return this.joinGuildFlag;
    }

    @Nullable
    public final String getJoinGuildSig() {
        return this.joinGuildSig;
    }

    @NotNull
    public final List<IGProMedalInfo> getMedalInfoList() {
        return this.medalInfoList;
    }

    @NotNull
    public final String getOnlineNumberString() {
        return this.onlineNumberString;
    }

    @NotNull
    public final IGProRecommendExtra getRecommendExtra() {
        return this.recommendExtra;
    }

    @NotNull
    public final List<IGProRecommendLabel> getTagList() {
        return this.tagList;
    }

    @NotNull
    public final String getTopTagText() {
        return this.topTagText;
    }

    @Override // com.tencent.mobileqq.guild.discovery.avblockdetail.model.a
    @NotNull
    public String getTraceId() {
        return this.traceId;
    }

    @NotNull
    public final List<String> getWuJiTags() {
        return this.wuJiTags;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((getItemId().hashCode() * 31) + getTraceId().hashCode()) * 31) + this.curCategoryName.hashCode()) * 31) + this.guildId.hashCode()) * 31;
        String str = this.joinGuildSig;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int hashCode3 = (((((((((((hashCode2 + hashCode) * 31) + this.joinGuildFlag) * 31) + this.guildName.hashCode()) * 31) + this.guildProfile.hashCode()) * 31) + this.guildIconUrl.hashCode()) * 31) + this.guildCoverUrl.hashCode()) * 31;
        boolean z16 = this.hasMedal;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode3 + i16) * 31;
        boolean z17 = this.isLeftItem;
        int i18 = z17;
        if (z17 != 0) {
            i18 = 1;
        }
        int hashCode4 = (((((((((((((((i17 + i18) * 31) + this.channelStatus) * 31) + this.channelStatusText.hashCode()) * 31) + this.friendJoinedNum) * 31) + this.onlineNumberString.hashCode()) * 31) + this.topTagText.hashCode()) * 31) + this.wuJiTags.hashCode()) * 31) + this.itemCategoryPosition) * 31;
        boolean z18 = this.isShowInGuildRecommendTab;
        if (!z18) {
            i3 = z18 ? 1 : 0;
        }
        return ((((((((((hashCode4 + i3) * 31) + this.configureChangeWidth) * 31) + this.dtParams.hashCode()) * 31) + this.recommendExtra.hashCode()) * 31) + this.medalInfoList.hashCode()) * 31) + this.tagList.hashCode();
    }

    public final boolean isLeftItem() {
        return this.isLeftItem;
    }

    public final boolean isShowInGuildRecommendTab() {
        return this.isShowInGuildRecommendTab;
    }

    public final void setConfigureChangeWidth(int i3) {
        this.configureChangeWidth = i3;
    }

    public final void setDtParams(@NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.dtParams = map;
    }

    public final void setItemCategoryPosition(int i3) {
        this.itemCategoryPosition = i3;
    }

    public final void setJoinGuildFlag(int i3) {
        this.joinGuildFlag = i3;
    }

    @NotNull
    public String toString() {
        return "GuildRecommendCardItem(itemId=" + getItemId() + ", traceId=" + getTraceId() + ", curCategoryName=" + this.curCategoryName + ", guildId=" + this.guildId + ", joinGuildSig=" + this.joinGuildSig + ", joinGuildFlag=" + this.joinGuildFlag + ", guildName=" + this.guildName + ", guildProfile=" + this.guildProfile + ", guildIconUrl=" + this.guildIconUrl + ", guildCoverUrl=" + this.guildCoverUrl + ", hasMedal=" + this.hasMedal + ", isLeftItem=" + this.isLeftItem + ", channelStatus=" + this.channelStatus + ", channelStatusText=" + this.channelStatusText + ", friendJoinedNum=" + this.friendJoinedNum + ", onlineNumberString=" + this.onlineNumberString + ", topTagText=" + this.topTagText + ", wuJiTags=" + this.wuJiTags + ", itemCategoryPosition=" + this.itemCategoryPosition + ", isShowInGuildRecommendTab=" + this.isShowInGuildRecommendTab + ", configureChangeWidth=" + this.configureChangeWidth + ", dtParams=" + this.dtParams + ", recommendExtra=" + this.recommendExtra + ", medalInfoList=" + this.medalInfoList + ", tagList=" + this.tagList + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GuildRecommendCardItem(@NotNull String itemId, @NotNull String traceId, @NotNull String curCategoryName, @NotNull String guildId, @Nullable String str, int i3, @NotNull String guildName, @NotNull String guildProfile, @NotNull String guildIconUrl, @NotNull String guildCoverUrl, boolean z16, boolean z17, int i16, @NotNull String channelStatusText, int i17, @NotNull String onlineNumberString, @NotNull String topTagText, @NotNull List<String> wuJiTags, int i18, boolean z18, int i19, @NotNull Map<String, ? extends Object> dtParams, @NotNull IGProRecommendExtra recommendExtra, @NotNull List<? extends IGProMedalInfo> medalInfoList, @NotNull List<? extends IGProRecommendLabel> tagList) {
        super(null, null, null, 0, 0, 31, null);
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(curCategoryName, "curCategoryName");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(guildName, "guildName");
        Intrinsics.checkNotNullParameter(guildProfile, "guildProfile");
        Intrinsics.checkNotNullParameter(guildIconUrl, "guildIconUrl");
        Intrinsics.checkNotNullParameter(guildCoverUrl, "guildCoverUrl");
        Intrinsics.checkNotNullParameter(channelStatusText, "channelStatusText");
        Intrinsics.checkNotNullParameter(onlineNumberString, "onlineNumberString");
        Intrinsics.checkNotNullParameter(topTagText, "topTagText");
        Intrinsics.checkNotNullParameter(wuJiTags, "wuJiTags");
        Intrinsics.checkNotNullParameter(dtParams, "dtParams");
        Intrinsics.checkNotNullParameter(recommendExtra, "recommendExtra");
        Intrinsics.checkNotNullParameter(medalInfoList, "medalInfoList");
        Intrinsics.checkNotNullParameter(tagList, "tagList");
        this.itemId = itemId;
        this.traceId = traceId;
        this.curCategoryName = curCategoryName;
        this.guildId = guildId;
        this.joinGuildSig = str;
        this.joinGuildFlag = i3;
        this.guildName = guildName;
        this.guildProfile = guildProfile;
        this.guildIconUrl = guildIconUrl;
        this.guildCoverUrl = guildCoverUrl;
        this.hasMedal = z16;
        this.isLeftItem = z17;
        this.channelStatus = i16;
        this.channelStatusText = channelStatusText;
        this.friendJoinedNum = i17;
        this.onlineNumberString = onlineNumberString;
        this.topTagText = topTagText;
        this.wuJiTags = wuJiTags;
        this.itemCategoryPosition = i18;
        this.isShowInGuildRecommendTab = z18;
        this.configureChangeWidth = i19;
        this.dtParams = dtParams;
        this.recommendExtra = recommendExtra;
        this.medalInfoList = medalInfoList;
        this.tagList = tagList;
    }
}
