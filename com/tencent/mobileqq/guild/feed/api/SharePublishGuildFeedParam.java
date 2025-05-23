package com.tencent.mobileqq.guild.feed.api;

import android.os.Bundle;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import cooperation.qzone.QZoneRequestEncoder;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00182\u00020\u0001:\u0007\u0019\u001a\u001b\u001c\u001d\u001e\u001fB\t\b\u0004\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&R#\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u0082\u0001\u0006 !\"#$%\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/SharePublishGuildFeedParam;", "Ljava/io/Serializable;", "", AppConstants.Key.COLUMN_IS_VALID, "Lorg/json/JSONObject;", "transformRichContentJson", "", "", "extMap", "Ljava/util/Map;", "getExtMap", "()Ljava/util/Map;", "Lcom/tencent/mobileqq/guild/feed/api/FeedEditorLaunchOptionModel;", "editorLaunchOption", "Lcom/tencent/mobileqq/guild/feed/api/FeedEditorLaunchOptionModel;", "getEditorLaunchOption", "()Lcom/tencent/mobileqq/guild/feed/api/FeedEditorLaunchOptionModel;", "isShowDefaultShareResultToast", "Z", "()Z", "setShowDefaultShareResultToast", "(Z)V", "<init>", "()V", "Companion", "a", "LinkTypeParam", "PhotoTypeParam", "QCircleTypeParam", "TextTypeParam", "ThirdVideoParam", "VideoTypeParam", "Lcom/tencent/mobileqq/guild/feed/api/SharePublishGuildFeedParam$LinkTypeParam;", "Lcom/tencent/mobileqq/guild/feed/api/SharePublishGuildFeedParam$PhotoTypeParam;", "Lcom/tencent/mobileqq/guild/feed/api/SharePublishGuildFeedParam$QCircleTypeParam;", "Lcom/tencent/mobileqq/guild/feed/api/SharePublishGuildFeedParam$TextTypeParam;", "Lcom/tencent/mobileqq/guild/feed/api/SharePublishGuildFeedParam$ThirdVideoParam;", "Lcom/tencent/mobileqq/guild/feed/api/SharePublishGuildFeedParam$VideoTypeParam;", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class SharePublishGuildFeedParam implements Serializable {
    private static final long serialVersionUID = 1;

    @NotNull
    private final FeedEditorLaunchOptionModel editorLaunchOption;

    @NotNull
    private final Map<String, Serializable> extMap;
    private boolean isShowDefaultShareResultToast;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\r\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB'\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\t\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0006H\u00c6\u0003J1\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u0006H\u00c6\u0001J\t\u0010\u0010\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0011H\u00d6\u0001J\u0013\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u00d6\u0003R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\f\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u0019\u0010\u0018R\u0017\u0010\r\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\u000e\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/SharePublishGuildFeedParam$LinkTypeParam;", "Lcom/tencent/mobileqq/guild/feed/api/SharePublishGuildFeedParam;", "", AppConstants.Key.COLUMN_IS_VALID, "Lorg/json/JSONObject;", "transformRichContentJson", "", "component1", "component2", "component3", "component4", "url", "imageUrl", "title", "desc", "copy", "toString", "", "hashCode", "", "other", "equals", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "getImageUrl", "getTitle", "getDesc", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final /* data */ class LinkTypeParam extends SharePublishGuildFeedParam {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private static final long serialVersionUID = 1;

        @NotNull
        private final String desc;

        @NotNull
        private final String imageUrl;

        @NotNull
        private final String title;

        @NotNull
        private final String url;

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/SharePublishGuildFeedParam$LinkTypeParam$a;", "", "Landroid/os/Bundle;", "bundle", "Lcom/tencent/mobileqq/guild/feed/api/SharePublishGuildFeedParam$LinkTypeParam;", "a", "", "serialVersionUID", "J", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.feed.api.SharePublishGuildFeedParam$LinkTypeParam$a, reason: from kotlin metadata */
        /* loaded from: classes13.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            @Nullable
            public final LinkTypeParam a(@NotNull Bundle bundle) {
                Intrinsics.checkNotNullParameter(bundle, "bundle");
                String string = bundle.getString("detail_url");
                if (string == null) {
                    return null;
                }
                Intrinsics.checkNotNullExpressionValue(string, "getString(AppConstants.K\u2026_URL) ?: return@with null");
                String string2 = bundle.getString("image_url");
                String str = "";
                if (string2 == null) {
                    string2 = "";
                }
                Intrinsics.checkNotNullExpressionValue(string2, "getString(AppConstants.K\u2026HARE_REQ_IMAGE_URL) ?: \"\"");
                String string3 = bundle.getString("title");
                if (string3 == null) {
                    string3 = "";
                }
                Intrinsics.checkNotNullExpressionValue(string3, "getString(AppConstants.Key.SHARE_REQ_TITLE) ?: \"\"");
                String string4 = bundle.getString("desc");
                if (string4 != null) {
                    str = string4;
                }
                Intrinsics.checkNotNullExpressionValue(str, "getString(AppConstants.Key.SHARE_REQ_DESC) ?: \"\"");
                return new LinkTypeParam(string, string2, string3, str);
            }

            Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LinkTypeParam(@NotNull String url, @NotNull String imageUrl, @NotNull String title, @NotNull String desc) {
            super(null);
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(desc, "desc");
            this.url = url;
            this.imageUrl = imageUrl;
            this.title = title;
            this.desc = desc;
        }

        public static /* synthetic */ LinkTypeParam copy$default(LinkTypeParam linkTypeParam, String str, String str2, String str3, String str4, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = linkTypeParam.url;
            }
            if ((i3 & 2) != 0) {
                str2 = linkTypeParam.imageUrl;
            }
            if ((i3 & 4) != 0) {
                str3 = linkTypeParam.title;
            }
            if ((i3 & 8) != 0) {
                str4 = linkTypeParam.desc;
            }
            return linkTypeParam.copy(str, str2, str3, str4);
        }

        @JvmStatic
        @Nullable
        public static final LinkTypeParam fromBundle(@NotNull Bundle bundle) {
            return INSTANCE.a(bundle);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getImageUrl() {
            return this.imageUrl;
        }

        @NotNull
        /* renamed from: component3, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        /* renamed from: component4, reason: from getter */
        public final String getDesc() {
            return this.desc;
        }

        @NotNull
        public final LinkTypeParam copy(@NotNull String url, @NotNull String imageUrl, @NotNull String title, @NotNull String desc) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(desc, "desc");
            return new LinkTypeParam(url, imageUrl, title, desc);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LinkTypeParam)) {
                return false;
            }
            LinkTypeParam linkTypeParam = (LinkTypeParam) other;
            if (Intrinsics.areEqual(this.url, linkTypeParam.url) && Intrinsics.areEqual(this.imageUrl, linkTypeParam.imageUrl) && Intrinsics.areEqual(this.title, linkTypeParam.title) && Intrinsics.areEqual(this.desc, linkTypeParam.desc)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getDesc() {
            return this.desc;
        }

        @NotNull
        public final String getImageUrl() {
            return this.imageUrl;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            return (((((this.url.hashCode() * 31) + this.imageUrl.hashCode()) * 31) + this.title.hashCode()) * 31) + this.desc.hashCode();
        }

        @Override // com.tencent.mobileqq.guild.feed.api.SharePublishGuildFeedParam
        public boolean isValid() {
            if (this.url.length() > 0) {
                return true;
            }
            return false;
        }

        @NotNull
        public String toString() {
            return "LinkTypeParam(url=" + this.url + ", imageUrl=" + this.imageUrl + ", title=" + this.title + ", desc=" + this.desc + ')';
        }

        @Override // com.tencent.mobileqq.guild.feed.api.SharePublishGuildFeedParam
        @NotNull
        public JSONObject transformRichContentJson() {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("type", 3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("url", this.url);
            jSONObject4.put("displayText", this.title);
            jSONObject4.put("type", 6);
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("image_url", this.imageUrl);
            jSONObject5.put("title", this.title);
            jSONObject5.put("abstract", this.desc);
            jSONObject5.put("redirect_url", this.url);
            Unit unit = Unit.INSTANCE;
            jSONObject4.put("third_share_info", jSONObject5);
            jSONObject3.put("url_content", jSONObject4);
            jSONArray.mo162put(jSONObject3);
            jSONObject2.put("contents", jSONArray);
            jSONObject.put("contents", jSONObject2);
            return jSONObject;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\n\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u0006H\u00c6\u0001J\t\u0010\n\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u00d6\u0003R\u0017\u0010\b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/SharePublishGuildFeedParam$PhotoTypeParam;", "Lcom/tencent/mobileqq/guild/feed/api/SharePublishGuildFeedParam;", "", AppConstants.Key.COLUMN_IS_VALID, "Lorg/json/JSONObject;", "transformRichContentJson", "", "component1", "picUrl", "copy", "toString", "", "hashCode", "", "other", "equals", "Ljava/lang/String;", "getPicUrl", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion", "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final /* data */ class PhotoTypeParam extends SharePublishGuildFeedParam {
        private static final long serialVersionUID = 1;

        @NotNull
        private final String picUrl;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PhotoTypeParam(@NotNull String picUrl) {
            super(null);
            Intrinsics.checkNotNullParameter(picUrl, "picUrl");
            this.picUrl = picUrl;
        }

        public static /* synthetic */ PhotoTypeParam copy$default(PhotoTypeParam photoTypeParam, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = photoTypeParam.picUrl;
            }
            return photoTypeParam.copy(str);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getPicUrl() {
            return this.picUrl;
        }

        @NotNull
        public final PhotoTypeParam copy(@NotNull String picUrl) {
            Intrinsics.checkNotNullParameter(picUrl, "picUrl");
            return new PhotoTypeParam(picUrl);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof PhotoTypeParam) && Intrinsics.areEqual(this.picUrl, ((PhotoTypeParam) other).picUrl)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getPicUrl() {
            return this.picUrl;
        }

        public int hashCode() {
            return this.picUrl.hashCode();
        }

        @Override // com.tencent.mobileqq.guild.feed.api.SharePublishGuildFeedParam
        public boolean isValid() {
            if (this.picUrl.length() > 0) {
                return true;
            }
            return false;
        }

        @NotNull
        public String toString() {
            return "PhotoTypeParam(picUrl=" + this.picUrl + ')';
        }

        @Override // com.tencent.mobileqq.guild.feed.api.SharePublishGuildFeedParam
        @NotNull
        public JSONObject transformRichContentJson() {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("picUrl", this.picUrl);
            jSONArray.mo162put(jSONObject2);
            Unit unit = Unit.INSTANCE;
            jSONObject.put("images", jSONArray);
            return jSONObject;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\r\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB'\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\t\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0006H\u00c6\u0003J1\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u0006H\u00c6\u0001J\t\u0010\u0010\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0011H\u00d6\u0001J\u0013\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u00d6\u0003R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\f\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u0019\u0010\u0018R\u0017\u0010\r\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\u000e\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/SharePublishGuildFeedParam$QCircleTypeParam;", "Lcom/tencent/mobileqq/guild/feed/api/SharePublishGuildFeedParam;", "", AppConstants.Key.COLUMN_IS_VALID, "Lorg/json/JSONObject;", "transformRichContentJson", "", "component1", "component2", "component3", "component4", "displayText", "coverUrl", WadlProxyConsts.KEY_JUMP_URL, "pcJumpUrl", "copy", "toString", "", "hashCode", "", "other", "equals", "Ljava/lang/String;", "getDisplayText", "()Ljava/lang/String;", "getCoverUrl", "getJumpUrl", "getPcJumpUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final /* data */ class QCircleTypeParam extends SharePublishGuildFeedParam {
        private static final long serialVersionUID = 1;

        @NotNull
        private final String coverUrl;

        @NotNull
        private final String displayText;

        @NotNull
        private final String jumpUrl;

        @NotNull
        private final String pcJumpUrl;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public QCircleTypeParam(@NotNull String displayText, @NotNull String coverUrl, @NotNull String jumpUrl, @NotNull String pcJumpUrl) {
            super(null);
            Intrinsics.checkNotNullParameter(displayText, "displayText");
            Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
            Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
            Intrinsics.checkNotNullParameter(pcJumpUrl, "pcJumpUrl");
            this.displayText = displayText;
            this.coverUrl = coverUrl;
            this.jumpUrl = jumpUrl;
            this.pcJumpUrl = pcJumpUrl;
        }

        public static /* synthetic */ QCircleTypeParam copy$default(QCircleTypeParam qCircleTypeParam, String str, String str2, String str3, String str4, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = qCircleTypeParam.displayText;
            }
            if ((i3 & 2) != 0) {
                str2 = qCircleTypeParam.coverUrl;
            }
            if ((i3 & 4) != 0) {
                str3 = qCircleTypeParam.jumpUrl;
            }
            if ((i3 & 8) != 0) {
                str4 = qCircleTypeParam.pcJumpUrl;
            }
            return qCircleTypeParam.copy(str, str2, str3, str4);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getDisplayText() {
            return this.displayText;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getCoverUrl() {
            return this.coverUrl;
        }

        @NotNull
        /* renamed from: component3, reason: from getter */
        public final String getJumpUrl() {
            return this.jumpUrl;
        }

        @NotNull
        /* renamed from: component4, reason: from getter */
        public final String getPcJumpUrl() {
            return this.pcJumpUrl;
        }

        @NotNull
        public final QCircleTypeParam copy(@NotNull String displayText, @NotNull String coverUrl, @NotNull String jumpUrl, @NotNull String pcJumpUrl) {
            Intrinsics.checkNotNullParameter(displayText, "displayText");
            Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
            Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
            Intrinsics.checkNotNullParameter(pcJumpUrl, "pcJumpUrl");
            return new QCircleTypeParam(displayText, coverUrl, jumpUrl, pcJumpUrl);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof QCircleTypeParam)) {
                return false;
            }
            QCircleTypeParam qCircleTypeParam = (QCircleTypeParam) other;
            if (Intrinsics.areEqual(this.displayText, qCircleTypeParam.displayText) && Intrinsics.areEqual(this.coverUrl, qCircleTypeParam.coverUrl) && Intrinsics.areEqual(this.jumpUrl, qCircleTypeParam.jumpUrl) && Intrinsics.areEqual(this.pcJumpUrl, qCircleTypeParam.pcJumpUrl)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getCoverUrl() {
            return this.coverUrl;
        }

        @NotNull
        public final String getDisplayText() {
            return this.displayText;
        }

        @NotNull
        public final String getJumpUrl() {
            return this.jumpUrl;
        }

        @NotNull
        public final String getPcJumpUrl() {
            return this.pcJumpUrl;
        }

        public int hashCode() {
            return (((((this.displayText.hashCode() * 31) + this.coverUrl.hashCode()) * 31) + this.jumpUrl.hashCode()) * 31) + this.pcJumpUrl.hashCode();
        }

        @Override // com.tencent.mobileqq.guild.feed.api.SharePublishGuildFeedParam
        public boolean isValid() {
            boolean z16;
            boolean z17;
            if (this.jumpUrl.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (this.pcJumpUrl.length() > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    return true;
                }
            }
            return false;
        }

        @NotNull
        public String toString() {
            return "QCircleTypeParam(displayText=" + this.displayText + ", coverUrl=" + this.coverUrl + ", jumpUrl=" + this.jumpUrl + ", pcJumpUrl=" + this.pcJumpUrl + ')';
        }

        @Override // com.tencent.mobileqq.guild.feed.api.SharePublishGuildFeedParam
        @NotNull
        public JSONObject transformRichContentJson() {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("type", 3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("url", this.pcJumpUrl);
            jSONObject4.put("displayText", this.displayText);
            jSONObject4.put("type", 7);
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("cover", this.coverUrl);
            jSONObject5.put("pc_jump_url", this.pcJumpUrl);
            jSONObject5.put("jump_url", this.jumpUrl);
            Unit unit = Unit.INSTANCE;
            jSONObject4.put("third_video_info", jSONObject5);
            jSONObject3.put("url_content", jSONObject4);
            jSONArray.mo162put(jSONObject3);
            jSONObject2.put("contents", jSONArray);
            jSONObject.put("contents", jSONObject2);
            return jSONObject;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\n\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u0006H\u00c6\u0001J\t\u0010\n\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u00d6\u0003R\u0017\u0010\b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/SharePublishGuildFeedParam$TextTypeParam;", "Lcom/tencent/mobileqq/guild/feed/api/SharePublishGuildFeedParam;", "", AppConstants.Key.COLUMN_IS_VALID, "Lorg/json/JSONObject;", "transformRichContentJson", "", "component1", "text", "copy", "toString", "", "hashCode", "", "other", "equals", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion", "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final /* data */ class TextTypeParam extends SharePublishGuildFeedParam {
        private static final long serialVersionUID = 1;

        @NotNull
        private final String text;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TextTypeParam(@NotNull String text) {
            super(null);
            Intrinsics.checkNotNullParameter(text, "text");
            this.text = text;
        }

        public static /* synthetic */ TextTypeParam copy$default(TextTypeParam textTypeParam, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = textTypeParam.text;
            }
            return textTypeParam.copy(str);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getText() {
            return this.text;
        }

        @NotNull
        public final TextTypeParam copy(@NotNull String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            return new TextTypeParam(text);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof TextTypeParam) && Intrinsics.areEqual(this.text, ((TextTypeParam) other).text)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getText() {
            return this.text;
        }

        public int hashCode() {
            return this.text.hashCode();
        }

        @Override // com.tencent.mobileqq.guild.feed.api.SharePublishGuildFeedParam
        public boolean isValid() {
            if (this.text.length() > 0) {
                return true;
            }
            return false;
        }

        @NotNull
        public String toString() {
            return "TextTypeParam(text=" + this.text + ')';
        }

        @Override // com.tencent.mobileqq.guild.feed.api.SharePublishGuildFeedParam
        @NotNull
        public JSONObject transformRichContentJson() {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("type", 1);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("text", this.text);
            Unit unit = Unit.INSTANCE;
            jSONObject3.put("text_content", jSONObject4);
            jSONArray.mo162put(jSONObject3);
            jSONObject2.put("contents", jSONArray);
            jSONObject.put("contents", jSONObject2);
            return jSONObject;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0011\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001'B7\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\f\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\t\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u000b\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\r\u001a\u00020\fH\u00c6\u0003JE\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\fH\u00c6\u0001J\t\u0010\u0015\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\fH\u00d6\u0001J\u0013\u0010\u0019\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u000f\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001d\u0010\u001cR\u0017\u0010\u0010\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR\u0017\u0010\u0011\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u001a\u001a\u0004\b\u001f\u0010\u001cR\u0017\u0010\u0012\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u001a\u001a\u0004\b \u0010\u001cR\u0017\u0010\u0013\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b\"\u0010#\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/SharePublishGuildFeedParam$ThirdVideoParam;", "Lcom/tencent/mobileqq/guild/feed/api/SharePublishGuildFeedParam;", "", AppConstants.Key.COLUMN_IS_VALID, "Lorg/json/JSONObject;", "transformRichContentJson", "", "component1", "component2", "component3", "component4", "component5", "", "component6", "cover", "title", "desc", "pcJumpUrl", WadlProxyConsts.KEY_JUMP_URL, "urlType", "copy", "toString", "hashCode", "", "other", "equals", "Ljava/lang/String;", QZoneRequestEncoder.KEY_COVER_REQ, "()Ljava/lang/String;", "getTitle", "getDesc", "getPcJumpUrl", "getJumpUrl", "I", "getUrlType", "()I", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "Companion", "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final /* data */ class ThirdVideoParam extends SharePublishGuildFeedParam {
        private static final long serialVersionUID = 1;

        @NotNull
        private final String cover;

        @NotNull
        private final String desc;

        @NotNull
        private final String jumpUrl;

        @NotNull
        private final String pcJumpUrl;

        @NotNull
        private final String title;
        private final int urlType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ThirdVideoParam(@NotNull String cover, @NotNull String title, @NotNull String desc, @NotNull String pcJumpUrl, @NotNull String jumpUrl, int i3) {
            super(null);
            Intrinsics.checkNotNullParameter(cover, "cover");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(desc, "desc");
            Intrinsics.checkNotNullParameter(pcJumpUrl, "pcJumpUrl");
            Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
            this.cover = cover;
            this.title = title;
            this.desc = desc;
            this.pcJumpUrl = pcJumpUrl;
            this.jumpUrl = jumpUrl;
            this.urlType = i3;
        }

        public static /* synthetic */ ThirdVideoParam copy$default(ThirdVideoParam thirdVideoParam, String str, String str2, String str3, String str4, String str5, int i3, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                str = thirdVideoParam.cover;
            }
            if ((i16 & 2) != 0) {
                str2 = thirdVideoParam.title;
            }
            String str6 = str2;
            if ((i16 & 4) != 0) {
                str3 = thirdVideoParam.desc;
            }
            String str7 = str3;
            if ((i16 & 8) != 0) {
                str4 = thirdVideoParam.pcJumpUrl;
            }
            String str8 = str4;
            if ((i16 & 16) != 0) {
                str5 = thirdVideoParam.jumpUrl;
            }
            String str9 = str5;
            if ((i16 & 32) != 0) {
                i3 = thirdVideoParam.urlType;
            }
            return thirdVideoParam.copy(str, str6, str7, str8, str9, i3);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getCover() {
            return this.cover;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        /* renamed from: component3, reason: from getter */
        public final String getDesc() {
            return this.desc;
        }

        @NotNull
        /* renamed from: component4, reason: from getter */
        public final String getPcJumpUrl() {
            return this.pcJumpUrl;
        }

        @NotNull
        /* renamed from: component5, reason: from getter */
        public final String getJumpUrl() {
            return this.jumpUrl;
        }

        /* renamed from: component6, reason: from getter */
        public final int getUrlType() {
            return this.urlType;
        }

        @NotNull
        public final ThirdVideoParam copy(@NotNull String cover, @NotNull String title, @NotNull String desc, @NotNull String pcJumpUrl, @NotNull String jumpUrl, int urlType) {
            Intrinsics.checkNotNullParameter(cover, "cover");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(desc, "desc");
            Intrinsics.checkNotNullParameter(pcJumpUrl, "pcJumpUrl");
            Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
            return new ThirdVideoParam(cover, title, desc, pcJumpUrl, jumpUrl, urlType);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ThirdVideoParam)) {
                return false;
            }
            ThirdVideoParam thirdVideoParam = (ThirdVideoParam) other;
            if (Intrinsics.areEqual(this.cover, thirdVideoParam.cover) && Intrinsics.areEqual(this.title, thirdVideoParam.title) && Intrinsics.areEqual(this.desc, thirdVideoParam.desc) && Intrinsics.areEqual(this.pcJumpUrl, thirdVideoParam.pcJumpUrl) && Intrinsics.areEqual(this.jumpUrl, thirdVideoParam.jumpUrl) && this.urlType == thirdVideoParam.urlType) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getCover() {
            return this.cover;
        }

        @NotNull
        public final String getDesc() {
            return this.desc;
        }

        @NotNull
        public final String getJumpUrl() {
            return this.jumpUrl;
        }

        @NotNull
        public final String getPcJumpUrl() {
            return this.pcJumpUrl;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        public final int getUrlType() {
            return this.urlType;
        }

        public int hashCode() {
            return (((((((((this.cover.hashCode() * 31) + this.title.hashCode()) * 31) + this.desc.hashCode()) * 31) + this.pcJumpUrl.hashCode()) * 31) + this.jumpUrl.hashCode()) * 31) + this.urlType;
        }

        @Override // com.tencent.mobileqq.guild.feed.api.SharePublishGuildFeedParam
        public boolean isValid() {
            boolean z16;
            boolean z17;
            if (this.pcJumpUrl.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (this.jumpUrl.length() > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    return true;
                }
            }
            return false;
        }

        @NotNull
        public String toString() {
            return "ThirdVideoParam(cover=" + this.cover + ", title=" + this.title + ", desc=" + this.desc + ", pcJumpUrl=" + this.pcJumpUrl + ", jumpUrl=" + this.jumpUrl + ", urlType=" + this.urlType + ')';
        }

        @Override // com.tencent.mobileqq.guild.feed.api.SharePublishGuildFeedParam
        @NotNull
        public JSONObject transformRichContentJson() {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("type", 3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("url", this.pcJumpUrl);
            jSONObject4.put("displayText", this.title);
            jSONObject4.put("type", this.urlType);
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("cover", this.cover);
            jSONObject5.put("pc_jump_url", this.pcJumpUrl);
            jSONObject5.put("jump_url", this.jumpUrl);
            Unit unit = Unit.INSTANCE;
            jSONObject4.put("third_video_info", jSONObject5);
            jSONObject3.put("url_content", jSONObject4);
            jSONArray.mo162put(jSONObject3);
            jSONObject2.put("contents", jSONArray);
            jSONObject.put("contents", jSONObject2);
            return jSONObject;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0006H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u0006H\u00c6\u0001J\t\u0010\f\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u000e\u001a\u00020\rH\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003R\u0017\u0010\t\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\n\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/SharePublishGuildFeedParam$VideoTypeParam;", "Lcom/tencent/mobileqq/guild/feed/api/SharePublishGuildFeedParam;", "", AppConstants.Key.COLUMN_IS_VALID, "Lorg/json/JSONObject;", "transformRichContentJson", "", "component1", "component2", "coverUrl", "playUrl", "copy", "toString", "", "hashCode", "", "other", "equals", "Ljava/lang/String;", "getCoverUrl", "()Ljava/lang/String;", "getPlayUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final /* data */ class VideoTypeParam extends SharePublishGuildFeedParam {
        private static final long serialVersionUID = 1;

        @NotNull
        private final String coverUrl;

        @NotNull
        private final String playUrl;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VideoTypeParam(@NotNull String coverUrl, @NotNull String playUrl) {
            super(null);
            Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
            Intrinsics.checkNotNullParameter(playUrl, "playUrl");
            this.coverUrl = coverUrl;
            this.playUrl = playUrl;
        }

        public static /* synthetic */ VideoTypeParam copy$default(VideoTypeParam videoTypeParam, String str, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = videoTypeParam.coverUrl;
            }
            if ((i3 & 2) != 0) {
                str2 = videoTypeParam.playUrl;
            }
            return videoTypeParam.copy(str, str2);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getCoverUrl() {
            return this.coverUrl;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getPlayUrl() {
            return this.playUrl;
        }

        @NotNull
        public final VideoTypeParam copy(@NotNull String coverUrl, @NotNull String playUrl) {
            Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
            Intrinsics.checkNotNullParameter(playUrl, "playUrl");
            return new VideoTypeParam(coverUrl, playUrl);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VideoTypeParam)) {
                return false;
            }
            VideoTypeParam videoTypeParam = (VideoTypeParam) other;
            if (Intrinsics.areEqual(this.coverUrl, videoTypeParam.coverUrl) && Intrinsics.areEqual(this.playUrl, videoTypeParam.playUrl)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getCoverUrl() {
            return this.coverUrl;
        }

        @NotNull
        public final String getPlayUrl() {
            return this.playUrl;
        }

        public int hashCode() {
            return (this.coverUrl.hashCode() * 31) + this.playUrl.hashCode();
        }

        @Override // com.tencent.mobileqq.guild.feed.api.SharePublishGuildFeedParam
        public boolean isValid() {
            if (this.playUrl.length() > 0) {
                return true;
            }
            return false;
        }

        @NotNull
        public String toString() {
            return "VideoTypeParam(coverUrl=" + this.coverUrl + ", playUrl=" + this.playUrl + ')';
        }

        @Override // com.tencent.mobileqq.guild.feed.api.SharePublishGuildFeedParam
        @NotNull
        public JSONObject transformRichContentJson() {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("playUrl", this.playUrl);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("picUrl", this.coverUrl);
            Unit unit = Unit.INSTANCE;
            jSONObject2.put("cover", jSONObject3);
            jSONArray.mo162put(jSONObject2);
            jSONObject.put("videos", jSONArray);
            return jSONObject;
        }
    }

    public /* synthetic */ SharePublishGuildFeedParam(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public final FeedEditorLaunchOptionModel getEditorLaunchOption() {
        return this.editorLaunchOption;
    }

    @NotNull
    public final Map<String, Serializable> getExtMap() {
        return this.extMap;
    }

    /* renamed from: isShowDefaultShareResultToast, reason: from getter */
    public final boolean getIsShowDefaultShareResultToast() {
        return this.isShowDefaultShareResultToast;
    }

    public abstract boolean isValid();

    public final void setShowDefaultShareResultToast(boolean z16) {
        this.isShowDefaultShareResultToast = z16;
    }

    @Nullable
    public abstract JSONObject transformRichContentJson();

    SharePublishGuildFeedParam() {
        this.extMap = new HashMap();
        FeedEditorLaunchOptionModel feedEditorLaunchOptionModel = new FeedEditorLaunchOptionModel(false, 0, 0, 7, null);
        Boolean bool = Boolean.FALSE;
        feedEditorLaunchOptionModel.setShowPostSuccessToast(bool);
        feedEditorLaunchOptionModel.setShowPostFailToast(bool);
        this.editorLaunchOption = feedEditorLaunchOptionModel;
        this.isShowDefaultShareResultToast = true;
    }
}
