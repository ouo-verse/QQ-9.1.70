package com.tencent.mobileqq.guild.share;

import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildMiniAppShareData {
    public String channelId;
    public String channelName;
    public int channelType;
    public String creatorId;
    public String creatorName;
    public int fetchShareInfoErrorCode;
    public String fetchShareInfoErrorMessage;
    public IGProSecurityResult fetchShareInfoErrorWhat;
    public String guildAvatarUrl;
    public String guildId;
    public String guildName;
    public String guildProfile;
    public String invitorName;
    public boolean isGuest;
    public String selfTinyId;
    public a shareUrlInfo;

    public GuildMiniAppShareData(IGProGuildInfo iGProGuildInfo, IGProChannelInfo iGProChannelInfo) {
        this.guildId = iGProGuildInfo.getGuildID();
        this.creatorId = iGProGuildInfo.getCreatorId();
        this.guildName = iGProGuildInfo.getGuildName();
        this.guildAvatarUrl = iGProGuildInfo.getAvatarUrl(0);
        this.guildProfile = "\u6765\u81ea\uff1a" + this.guildName;
        this.channelId = iGProChannelInfo.getChannelUin();
        this.channelName = iGProChannelInfo.getChannelName();
        this.channelType = iGProChannelInfo.getType();
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f234947a;

        /* renamed from: b, reason: collision with root package name */
        public final String f234948b;

        /* renamed from: c, reason: collision with root package name */
        public String f234949c;

        /* renamed from: d, reason: collision with root package name */
        public String f234950d;

        public a(String str, String str2) {
            this.f234947a = str;
            this.f234948b = str2;
        }

        public a(String str, String str2, String str3, String str4) {
            this(str, str2);
            this.f234949c = str3;
            this.f234950d = str4;
        }
    }
}
