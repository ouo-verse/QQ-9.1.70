package com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.MessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u0000 12\u00020\u0001:\u0001\u000bBi\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u0012\u0006\u0010\u001f\u001a\u00020\u0004\u0012\u0006\u0010!\u001a\u00020\u0004\u0012\u0006\u0010$\u001a\u00020\u0004\u0012\u0006\u0010&\u001a\u00020\u0004\u0012\u0006\u0010'\u001a\u00020\u0004\u0012\u0006\u0010(\u001a\u00020\u0010\u0012\b\b\u0002\u0010)\u001a\u00020\u0004\u0012\u0006\u0010.\u001a\u00020*\u00a2\u0006\u0004\b/\u00100J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001d\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u001c\u0010\u000eR\u0017\u0010\u001f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\f\u001a\u0004\b\u001e\u0010\u000eR\u0017\u0010!\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\f\u001a\u0004\b \u0010\u000eR\u0017\u0010$\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\f\u001a\u0004\b#\u0010\u000eR\u0017\u0010&\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b%\u0010\f\u001a\u0004\b\u000b\u0010\u000eR\u0017\u0010'\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b \u0010\f\u001a\u0004\b\u001b\u0010\u000eR\u0017\u0010(\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\"\u0010\u0013R\u0017\u0010)\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\u0016\u0010\u000eR\u0017\u0010.\u001a\u00020*8\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b%\u0010-\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/b;", "", "Lorg/json/JSONObject;", "k", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "id", "", "J", "getReceiveUin", "()J", "receiveUin", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/c;", "c", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/c;", "j", "()Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/c;", "type", "d", "e", "moduleIconUrl", "f", "platformName", "i", "title", "g", "getBrief", "brief", h.F, "content", WadlProxyConsts.KEY_JUMP_URL, "receiveTimestamp", "imageUrl", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/MessageStyle;", "l", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/MessageStyle;", "()Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/MessageStyle;", "style", "<init>", "(Ljava/lang/String;JLcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/c;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/MessageStyle;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.b, reason: from toString */
/* loaded from: classes16.dex */
public final /* data */ class MessageItem {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long receiveUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final MessageType type;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String moduleIconUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String platformName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String title;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String brief;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String content;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String jumpUrl;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private final long receiveTimestamp;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String imageUrl;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final MessageStyle style;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/b$a;", "", "Lorg/json/JSONObject;", "data", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/b;", "a", "<init>", "()V", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.b$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MessageItem a(@NotNull JSONObject data) {
            Intrinsics.checkNotNullParameter(data, "data");
            String optString = data.optString("id");
            Intrinsics.checkNotNullExpressionValue(optString, "optString(\"id\")");
            long optLong = data.optLong("receiveUin");
            MessageType.Companion companion = MessageType.INSTANCE;
            JSONObject optJSONObject = data.optJSONObject("type");
            if (optJSONObject == null) {
                optJSONObject = d.a().c();
            } else {
                Intrinsics.checkNotNullExpressionValue(optJSONObject, "optJSONObject(\"type\") ?:\u2026SSAGE_TYPE.toJSONObject()");
            }
            MessageType a16 = companion.a(optJSONObject);
            String optString2 = data.optString("moduleIconUrl");
            Intrinsics.checkNotNullExpressionValue(optString2, "optString(\"moduleIconUrl\")");
            String optString3 = data.optString("platformName");
            Intrinsics.checkNotNullExpressionValue(optString3, "optString(\"platformName\")");
            String optString4 = data.optString("title");
            Intrinsics.checkNotNullExpressionValue(optString4, "optString(\"title\")");
            String optString5 = data.optString("brief");
            Intrinsics.checkNotNullExpressionValue(optString5, "optString(\"brief\")");
            String optString6 = data.optString("content");
            Intrinsics.checkNotNullExpressionValue(optString6, "optString(\"content\")");
            String optString7 = data.optString(WadlProxyConsts.KEY_JUMP_URL);
            Intrinsics.checkNotNullExpressionValue(optString7, "optString(\"jumpUrl\")");
            long optLong2 = data.optLong("receiveTimestamp");
            String optString8 = data.optString("imageUrl");
            Intrinsics.checkNotNullExpressionValue(optString8, "optString(\"imageUrl\")");
            return new MessageItem(optString, optLong, a16, optString2, optString3, optString4, optString5, optString6, optString7, optLong2, optString8, MessageStyle.values()[data.optInt("styleOrdinal")]);
        }

        Companion() {
        }
    }

    public MessageItem(@NotNull String id5, long j3, @NotNull MessageType type, @NotNull String moduleIconUrl, @NotNull String platformName, @NotNull String title, @NotNull String brief, @NotNull String content, @NotNull String jumpUrl, long j16, @NotNull String imageUrl, @NotNull MessageStyle style) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(moduleIconUrl, "moduleIconUrl");
        Intrinsics.checkNotNullParameter(platformName, "platformName");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(brief, "brief");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(style, "style");
        this.id = id5;
        this.receiveUin = j3;
        this.type = type;
        this.moduleIconUrl = moduleIconUrl;
        this.platformName = platformName;
        this.title = title;
        this.brief = brief;
        this.content = content;
        this.jumpUrl = jumpUrl;
        this.receiveTimestamp = j16;
        this.imageUrl = imageUrl;
        this.style = style;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getModuleIconUrl() {
        return this.moduleIconUrl;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageItem)) {
            return false;
        }
        MessageItem messageItem = (MessageItem) other;
        if (Intrinsics.areEqual(this.id, messageItem.id) && this.receiveUin == messageItem.receiveUin && Intrinsics.areEqual(this.type, messageItem.type) && Intrinsics.areEqual(this.moduleIconUrl, messageItem.moduleIconUrl) && Intrinsics.areEqual(this.platformName, messageItem.platformName) && Intrinsics.areEqual(this.title, messageItem.title) && Intrinsics.areEqual(this.brief, messageItem.brief) && Intrinsics.areEqual(this.content, messageItem.content) && Intrinsics.areEqual(this.jumpUrl, messageItem.jumpUrl) && this.receiveTimestamp == messageItem.receiveTimestamp && Intrinsics.areEqual(this.imageUrl, messageItem.imageUrl) && this.style == messageItem.style) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getPlatformName() {
        return this.platformName;
    }

    /* renamed from: g, reason: from getter */
    public final long getReceiveTimestamp() {
        return this.receiveTimestamp;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final MessageStyle getStyle() {
        return this.style;
    }

    public int hashCode() {
        return (((((((((((((((((((((this.id.hashCode() * 31) + androidx.fragment.app.a.a(this.receiveUin)) * 31) + this.type.hashCode()) * 31) + this.moduleIconUrl.hashCode()) * 31) + this.platformName.hashCode()) * 31) + this.title.hashCode()) * 31) + this.brief.hashCode()) * 31) + this.content.hashCode()) * 31) + this.jumpUrl.hashCode()) * 31) + androidx.fragment.app.a.a(this.receiveTimestamp)) * 31) + this.imageUrl.hashCode()) * 31) + this.style.hashCode();
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final MessageType getType() {
        return this.type;
    }

    @NotNull
    public final JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.id);
        jSONObject.put("receiveUin", this.receiveUin);
        jSONObject.put("type", this.type.c());
        jSONObject.put("moduleIconUrl", this.moduleIconUrl);
        jSONObject.put("platformName", this.platformName);
        jSONObject.put("title", this.title);
        jSONObject.put("brief", this.brief);
        jSONObject.put("content", this.content);
        jSONObject.put(WadlProxyConsts.KEY_JUMP_URL, this.jumpUrl);
        jSONObject.put("receiveTimestamp", this.receiveTimestamp);
        jSONObject.put("imageUrl", this.imageUrl);
        jSONObject.put("styleOrdinal", this.style.ordinal());
        return jSONObject;
    }

    @NotNull
    public String toString() {
        return "MessageItem(id=" + this.id + ", receiveUin=" + this.receiveUin + ", type=" + this.type + ", moduleIconUrl=" + this.moduleIconUrl + ", platformName=" + this.platformName + ", title=" + this.title + ", brief=" + this.brief + ", content=" + this.content + ", jumpUrl=" + this.jumpUrl + ", receiveTimestamp=" + this.receiveTimestamp + ", imageUrl=" + this.imageUrl + ", style=" + this.style + ')';
    }
}
