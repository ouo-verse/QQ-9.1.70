package com.tencent.mobileqq.vas.novelspecies.data;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001e2\u00020\u0001:\u0002\u0003\u000bB\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0003\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000b\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0019\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0018\u0010\u0016\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/vas/novelspecies/data/a;", "", "", "a", "I", "d", "()I", "setScore", "(I)V", LocalPhotoFaceInfo.SCORE, "", "b", "J", "()J", "setCoin", "(J)V", "coin", "Lcom/tencent/mobileqq/vas/novelspecies/data/a$b;", "c", "Lcom/tencent/mobileqq/vas/novelspecies/data/a$b;", "()Lcom/tencent/mobileqq/vas/novelspecies/data/a$b;", "setDefaultWidgetData", "(Lcom/tencent/mobileqq/vas/novelspecies/data/a$b;)V", "defaultWidgetData", "setLastWidgetData", "lastWidgetData", "Lcom/tencent/mobileqq/vas/novelspecies/data/WidgetPB$SsoGetWidgetNotifyInfoRsp;", "data", "<init>", "(Lcom/tencent/mobileqq/vas/novelspecies/data/WidgetPB$SsoGetWidgetNotifyInfoRsp;)V", "e", "vas-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int score;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long coin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private b defaultWidgetData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private b lastWidgetData;

    public a(@NotNull WidgetPB$SsoGetWidgetNotifyInfoRsp data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.defaultWidgetData = new b();
        this.lastWidgetData = new b();
        this.score = data.score.get();
        this.coin = data.coin.get();
        WidgetPB$WidgetNotifyInfo widgetPB$WidgetNotifyInfo = data.default_info;
        Intrinsics.checkNotNullExpressionValue(widgetPB$WidgetNotifyInfo, "data.default_info");
        this.defaultWidgetData = new b(widgetPB$WidgetNotifyInfo);
        WidgetPB$WidgetNotifyInfo widgetPB$WidgetNotifyInfo2 = data.last_info;
        Intrinsics.checkNotNullExpressionValue(widgetPB$WidgetNotifyInfo2, "data.last_info");
        this.lastWidgetData = new b(widgetPB$WidgetNotifyInfo2);
    }

    /* renamed from: a, reason: from getter */
    public final long getCoin() {
        return this.coin;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final b getDefaultWidgetData() {
        return this.defaultWidgetData;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final b getLastWidgetData() {
        return this.lastWidgetData;
    }

    /* renamed from: d, reason: from getter */
    public final int getScore() {
        return this.score;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b-\u0010.B\u0011\b\u0016\u0012\u0006\u00100\u001a\u00020/\u00a2\u0006\u0004\b-\u00101J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\"\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000bR\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0007\u001a\u0004\b\u0015\u0010\t\"\u0004\b\u0016\u0010\u000bR\"\u0010\u001a\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0007\u001a\u0004\b\u0014\u0010\t\"\u0004\b\u0019\u0010\u000bR\"\u0010\u001c\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0007\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u001b\u0010\u000bR\"\u0010\u001f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u001d\u0010\t\"\u0004\b\u001e\u0010\u000bR\"\u0010%\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010!\u001a\u0004\b\u0018\u0010\"\"\u0004\b#\u0010$R\"\u0010,\u001a\u00020&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/vas/novelspecies/data/a$b;", "", "", "isBig", "", "b", "a", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "setLargeBgUrl", "(Ljava/lang/String;)V", "largeBgUrl", "getLargeBgPath", "j", "largeBgPath", "c", "g", "setMiniBgUrl", "miniBgUrl", "d", "getMiniBgPath", "k", "miniBgPath", "e", "setElementUrl", "elementUrl", "i", "elementPath", h.F, "setMsg", "msg", "", "J", "()J", "setExpiredTimestamp", "(J)V", "expiredTimestamp", "", "I", "getType", "()I", "setType", "(I)V", "type", "<init>", "()V", "Lcom/tencent/mobileqq/vas/novelspecies/data/WidgetPB$WidgetNotifyInfo;", "data", "(Lcom/tencent/mobileqq/vas/novelspecies/data/WidgetPB$WidgetNotifyInfo;)V", "vas-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String largeBgUrl;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String largeBgPath;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String miniBgUrl;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String miniBgPath;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String elementUrl;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String elementPath;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String msg;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private long expiredTimestamp;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private int type;

        public b() {
            this.largeBgUrl = "";
            this.largeBgPath = "";
            this.miniBgUrl = "";
            this.miniBgPath = "";
            this.elementUrl = "";
            this.elementPath = "";
            this.msg = "";
        }

        @NotNull
        public final String a(boolean isBig) {
            if (isBig) {
                return this.largeBgPath;
            }
            return this.miniBgPath;
        }

        @NotNull
        public final String b(boolean isBig) {
            if (isBig) {
                return this.largeBgUrl;
            }
            return this.miniBgUrl;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getElementPath() {
            return this.elementPath;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getElementUrl() {
            return this.elementUrl;
        }

        /* renamed from: e, reason: from getter */
        public final long getExpiredTimestamp() {
            return this.expiredTimestamp;
        }

        @NotNull
        /* renamed from: f, reason: from getter */
        public final String getLargeBgUrl() {
            return this.largeBgUrl;
        }

        @NotNull
        /* renamed from: g, reason: from getter */
        public final String getMiniBgUrl() {
            return this.miniBgUrl;
        }

        @NotNull
        /* renamed from: h, reason: from getter */
        public final String getMsg() {
            return this.msg;
        }

        public final void i(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.elementPath = str;
        }

        public final void j(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.largeBgPath = str;
        }

        public final void k(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.miniBgPath = str;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public b(@NotNull WidgetPB$WidgetNotifyInfo data) {
            this();
            Intrinsics.checkNotNullParameter(data, "data");
            String str = data.big_background_pic.get();
            Intrinsics.checkNotNullExpressionValue(str, "data.big_background_pic.get()");
            this.largeBgUrl = str;
            String str2 = data.small_background_pic.get();
            Intrinsics.checkNotNullExpressionValue(str2, "data.small_background_pic.get()");
            this.miniBgUrl = str2;
            String str3 = data.element_pic.get();
            Intrinsics.checkNotNullExpressionValue(str3, "data.element_pic.get()");
            this.elementUrl = str3;
            String str4 = data.f310081msg.get();
            Intrinsics.checkNotNullExpressionValue(str4, "data.msg.get()");
            this.msg = str4;
            this.expiredTimestamp = System.currentTimeMillis() + (data.expire_timestamp.get() * 1000);
            this.type = data.type.get();
        }
    }
}
