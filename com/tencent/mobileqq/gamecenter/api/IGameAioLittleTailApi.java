package com.tencent.mobileqq.gamecenter.api;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0002\u000b\fJ\b\u0010\u0003\u001a\u00020\u0002H&J\"\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/api/IGameAioLittleTailApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "preloadLittleTailConfig", "", "appId", "", "appType", "msgTimestamp", "Lcom/tencent/mobileqq/gamecenter/api/IGameAioLittleTailApi$a;", "queryGamePicLittleTailInfo", "JumpType", "a", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGameAioLittleTailApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/api/IGameAioLittleTailApi$JumpType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "SCHEMA", "HTTP", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public enum JumpType {
        SCHEMA(1),
        HTTP(2);

        private final int type;

        JumpType(int i3) {
            this.type = i3;
        }

        public final int getType() {
            return this.type;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010 \u001a\u00020\u0002\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0015\u0010\u0010R\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0018\u0010\u0010R\u0017\u0010\u001d\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u001b\u001a\u0004\b\u0017\u0010\u001cR\u0017\u0010\u001e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010 \u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u000f\u001a\u0004\b\u001f\u0010\u0010\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/api/IGameAioLittleTailApi$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "()J", "appId", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "appName", "c", "g", "text", "d", "iconUrl", "e", "f", WadlProxyConsts.KEY_JUMP_URL, "Lcom/tencent/mobileqq/gamecenter/api/IGameAioLittleTailApi$JumpType;", "Lcom/tencent/mobileqq/gamecenter/api/IGameAioLittleTailApi$JumpType;", "()Lcom/tencent/mobileqq/gamecenter/api/IGameAioLittleTailApi$JumpType;", "jumpType", "bgColor", tl.h.F, "textColor", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/gamecenter/api/IGameAioLittleTailApi$JumpType;Ljava/lang/String;Ljava/lang/String;)V", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.gamecenter.api.IGameAioLittleTailApi$a, reason: from toString */
    /* loaded from: classes12.dex */
    public static final /* data */ class LittleTailInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final long appId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String appName;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String text;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String iconUrl;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String jumpUrl;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final JumpType jumpType;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String bgColor;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String textColor;

        public LittleTailInfo(long j3, @NotNull String appName, @NotNull String text, @NotNull String iconUrl, @NotNull String jumpUrl, @NotNull JumpType jumpType, @NotNull String bgColor, @NotNull String textColor) {
            Intrinsics.checkNotNullParameter(appName, "appName");
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
            Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
            Intrinsics.checkNotNullParameter(jumpType, "jumpType");
            Intrinsics.checkNotNullParameter(bgColor, "bgColor");
            Intrinsics.checkNotNullParameter(textColor, "textColor");
            this.appId = j3;
            this.appName = appName;
            this.text = text;
            this.iconUrl = iconUrl;
            this.jumpUrl = jumpUrl;
            this.jumpType = jumpType;
            this.bgColor = bgColor;
            this.textColor = textColor;
        }

        /* renamed from: a, reason: from getter */
        public final long getAppId() {
            return this.appId;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getAppName() {
            return this.appName;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getBgColor() {
            return this.bgColor;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getIconUrl() {
            return this.iconUrl;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final JumpType getJumpType() {
            return this.jumpType;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LittleTailInfo)) {
                return false;
            }
            LittleTailInfo littleTailInfo = (LittleTailInfo) other;
            if (this.appId == littleTailInfo.appId && Intrinsics.areEqual(this.appName, littleTailInfo.appName) && Intrinsics.areEqual(this.text, littleTailInfo.text) && Intrinsics.areEqual(this.iconUrl, littleTailInfo.iconUrl) && Intrinsics.areEqual(this.jumpUrl, littleTailInfo.jumpUrl) && this.jumpType == littleTailInfo.jumpType && Intrinsics.areEqual(this.bgColor, littleTailInfo.bgColor) && Intrinsics.areEqual(this.textColor, littleTailInfo.textColor)) {
                return true;
            }
            return false;
        }

        @NotNull
        /* renamed from: f, reason: from getter */
        public final String getJumpUrl() {
            return this.jumpUrl;
        }

        @NotNull
        /* renamed from: g, reason: from getter */
        public final String getText() {
            return this.text;
        }

        @NotNull
        /* renamed from: h, reason: from getter */
        public final String getTextColor() {
            return this.textColor;
        }

        public int hashCode() {
            return (((((((((((((androidx.fragment.app.a.a(this.appId) * 31) + this.appName.hashCode()) * 31) + this.text.hashCode()) * 31) + this.iconUrl.hashCode()) * 31) + this.jumpUrl.hashCode()) * 31) + this.jumpType.hashCode()) * 31) + this.bgColor.hashCode()) * 31) + this.textColor.hashCode();
        }

        @NotNull
        public String toString() {
            return "LittleTailInfo(appId=" + this.appId + ", appName=" + this.appName + ", text=" + this.text + ", iconUrl=" + this.iconUrl + ", jumpUrl=" + this.jumpUrl + ", jumpType=" + this.jumpType + ", bgColor=" + this.bgColor + ", textColor=" + this.textColor + ')';
        }
    }

    void preloadLittleTailConfig();

    @Nullable
    LittleTailInfo queryGamePicLittleTailInfo(long appId, int appType, long msgTimestamp);
}
