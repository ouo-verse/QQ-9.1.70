package com.tencent.mobileqq.guild.data;

import android.os.Bundle;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqnt.kernelpublic.nativeinterface.XmlElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001f\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001d\u001a\u0004\b\u000e\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/data/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "guildId", "b", "channelId", "e", "senderId", "", "d", "Ljava/lang/Long;", "()Ljava/lang/Long;", "msgId", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/XmlElement;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/XmlElement;", "f", "()Lcom/tencent/qqnt/kernelpublic/nativeinterface/XmlElement;", "xmlElement", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "()Landroid/os/Bundle;", QQBrowserActivity.APP_PARAM, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/tencent/qqnt/kernelpublic/nativeinterface/XmlElement;Landroid/os/Bundle;)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.data.b, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class GuildCommonGrayTipsParseParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String channelId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String senderId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Long msgId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final XmlElement xmlElement;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Bundle extraParams;

    public GuildCommonGrayTipsParseParams(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Long l3, @Nullable XmlElement xmlElement, @NotNull Bundle extraParams) {
        Intrinsics.checkNotNullParameter(extraParams, "extraParams");
        this.guildId = str;
        this.channelId = str2;
        this.senderId = str3;
        this.msgId = l3;
        this.xmlElement = xmlElement;
        this.extraParams = extraParams;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final Bundle getExtraParams() {
        return this.extraParams;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final Long getMsgId() {
        return this.msgId;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getSenderId() {
        return this.senderId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildCommonGrayTipsParseParams)) {
            return false;
        }
        GuildCommonGrayTipsParseParams guildCommonGrayTipsParseParams = (GuildCommonGrayTipsParseParams) other;
        if (Intrinsics.areEqual(this.guildId, guildCommonGrayTipsParseParams.guildId) && Intrinsics.areEqual(this.channelId, guildCommonGrayTipsParseParams.channelId) && Intrinsics.areEqual(this.senderId, guildCommonGrayTipsParseParams.senderId) && Intrinsics.areEqual(this.msgId, guildCommonGrayTipsParseParams.msgId) && Intrinsics.areEqual(this.xmlElement, guildCommonGrayTipsParseParams.xmlElement) && Intrinsics.areEqual(this.extraParams, guildCommonGrayTipsParseParams.extraParams)) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final XmlElement getXmlElement() {
        return this.xmlElement;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        String str = this.guildId;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        String str2 = this.channelId;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str3 = this.senderId;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        Long l3 = this.msgId;
        if (l3 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = l3.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        XmlElement xmlElement = this.xmlElement;
        if (xmlElement != null) {
            i3 = xmlElement.hashCode();
        }
        return ((i19 + i3) * 31) + this.extraParams.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildCommonGrayTipsParseParams(guildId=" + this.guildId + ", channelId=" + this.channelId + ", senderId=" + this.senderId + ", msgId=" + this.msgId + ", xmlElement=" + this.xmlElement + ", extraParams=" + this.extraParams + ')';
    }
}
