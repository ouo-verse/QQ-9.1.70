package com.tencent.ecommerce.biz.consumer;

import androidx.annotation.Keep;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u00041234B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u001a\u0010\u001f\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\u000eR\u001a\u0010\"\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\u001a\u0010%\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\f\"\u0004\b'\u0010\u000eR\u001a\u0010(\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100\u00a8\u00065"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;", "", "()V", "authorUin", "", "getAuthorUin", "()Ljava/lang/String;", "setAuthorUin", "(Ljava/lang/String;)V", "businessId", "", "getBusinessId", "()I", "setBusinessId", "(I)V", "businessScene", "getBusinessScene", "setBusinessScene", "contentId", "getContentId", "setContentId", "contentScene", "getContentScene", "setContentScene", "isContinuation", "", "()Z", "setContinuation", "(Z)V", "isTopViewPreload", "setTopViewPreload", "pageId", "getPageId", "setPageId", "sealTransfer", "getSealTransfer", "setSealTransfer", GetAdInfoRequest.SOURCE_FROM, "getSourceFrom", "setSourceFrom", "traceId", "getTraceId", "setTraceId", "video", "Lcom/tencent/ecommerce/biz/consumer/ECContentInfo$VideoInfo;", "getVideo", "()Lcom/tencent/ecommerce/biz/consumer/ECContentInfo$VideoInfo;", "setVideo", "(Lcom/tencent/ecommerce/biz/consumer/ECContentInfo$VideoInfo;)V", "Builder", "ECBusinessID", "ECContentScene", "VideoInfo", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class ECContentInfo {

    @NotNull
    private transient String authorUin;
    private transient int businessId;

    @NotNull
    private String businessScene;

    @NotNull
    private String contentId;
    private transient int contentScene;
    private boolean isContinuation;
    private boolean isTopViewPreload;
    private int pageId;

    @NotNull
    private String sealTransfer;
    private int sourceFrom;

    @NotNull
    private String traceId;

    @Nullable
    private VideoInfo video;

    /* compiled from: P */
    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0006\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000bJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0014J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u000bJ\u0010\u0010\u0019\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u000bJ\u0010\u0010\u001d\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/ECContentInfo$Builder;", "", "()V", "data", "Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;", "build", "setAuthorUin", "authorUin", "", "setBusinessId", "businessId", "", "setBusinessScene", "businessScene", "setContentId", "contentId", "setContentScene", "contentScene", "setIsContinuation", "isFromContinuation", "", "setIsTopViewPreload", "isTopViewPreload", "setPageId", "pageId", "setSealTransfer", "sealTransfer", "setSourceFrom", GetAdInfoRequest.SOURCE_FROM, "setTraceId", "traceId", "setVideoIndex", "index", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public static final class Builder {
        private final ECContentInfo data = new ECContentInfo(null);

        @NotNull
        /* renamed from: build, reason: from getter */
        public final ECContentInfo getData() {
            return this.data;
        }

        @NotNull
        public final Builder setAuthorUin(@Nullable String authorUin) {
            ECContentInfo eCContentInfo = this.data;
            if (authorUin == null) {
                authorUin = "";
            }
            eCContentInfo.setAuthorUin(authorUin);
            return this;
        }

        @NotNull
        public final Builder setBusinessId(int businessId) {
            this.data.setBusinessId(businessId);
            return this;
        }

        @NotNull
        public final Builder setBusinessScene(@Nullable String businessScene) {
            ECContentInfo eCContentInfo = this.data;
            if (businessScene == null) {
                businessScene = "";
            }
            eCContentInfo.setBusinessScene(businessScene);
            return this;
        }

        @NotNull
        public final Builder setContentId(@Nullable String contentId) {
            ECContentInfo eCContentInfo = this.data;
            if (contentId == null) {
                contentId = "";
            }
            eCContentInfo.setContentId(contentId);
            return this;
        }

        @NotNull
        public final Builder setContentScene(int contentScene) {
            this.data.setContentScene(contentScene);
            return this;
        }

        @NotNull
        public final Builder setIsContinuation(boolean isFromContinuation) {
            this.data.setContinuation(isFromContinuation);
            return this;
        }

        @NotNull
        public final Builder setIsTopViewPreload(boolean isTopViewPreload) {
            this.data.setTopViewPreload(isTopViewPreload);
            return this;
        }

        @NotNull
        public final Builder setPageId(int pageId) {
            this.data.setPageId(pageId);
            return this;
        }

        @NotNull
        public final Builder setSealTransfer(@Nullable String sealTransfer) {
            ECContentInfo eCContentInfo = this.data;
            if (sealTransfer == null) {
                sealTransfer = "";
            }
            eCContentInfo.setSealTransfer(sealTransfer);
            return this;
        }

        @NotNull
        public final Builder setSourceFrom(int sourceFrom) {
            this.data.setSourceFrom(sourceFrom);
            return this;
        }

        @NotNull
        public final Builder setTraceId(@Nullable String traceId) {
            ECContentInfo eCContentInfo = this.data;
            if (traceId == null) {
                traceId = "";
            }
            eCContentInfo.setTraceId(traceId);
            return this;
        }

        @NotNull
        public final Builder setVideoIndex(int index) {
            this.data.setVideo(new VideoInfo(index));
            return this;
        }
    }

    /* compiled from: P */
    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/ECContentInfo$ECBusinessID;", "", "()V", QQWinkConstants.ENTRY_BUSINESS_KANDIAN, "", "LITTLE_WORLD", "UNKNOWN", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public static final class ECBusinessID {

        @NotNull
        public static final ECBusinessID INSTANCE = new ECBusinessID();
        public static final int KANDIAN = 1;
        public static final int LITTLE_WORLD = 2;
        public static final int UNKNOWN = 0;

        ECBusinessID() {
        }
    }

    /* compiled from: P */
    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/ECContentInfo$ECContentScene;", "", "()V", "ARTICLE", "", "COMMENT", "PICS", "SCENE_GAME_TAB", "SCENE_SEARCH", "SCENE_SHARE_PAGE", "TOP_VIEW", "UNKNOWN", "VIDEO", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public static final class ECContentScene {
        public static final int ARTICLE = 1;
        public static final int COMMENT = 4;

        @NotNull
        public static final ECContentScene INSTANCE = new ECContentScene();
        public static final int PICS = 3;
        public static final int SCENE_GAME_TAB = 7;
        public static final int SCENE_SEARCH = 6;
        public static final int SCENE_SHARE_PAGE = 5;
        public static final int TOP_VIEW = 8;
        public static final int UNKNOWN = 0;
        public static final int VIDEO = 2;

        ECContentScene() {
        }
    }

    /* compiled from: P */
    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/ECContentInfo$VideoInfo;", "", "index", "", "(I)V", "getIndex", "()I", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public static final class VideoInfo {
        private final int index;

        public VideoInfo(int i3) {
            this.index = i3;
        }

        public final int getIndex() {
            return this.index;
        }
    }

    ECContentInfo() {
        this.businessScene = "";
        this.contentId = "";
        this.authorUin = "";
        this.sealTransfer = "";
        this.traceId = "";
        this.pageId = -1;
        this.sourceFrom = -1;
    }

    @NotNull
    public final String getAuthorUin() {
        return this.authorUin;
    }

    public final int getBusinessId() {
        return this.businessId;
    }

    @NotNull
    public final String getBusinessScene() {
        return this.businessScene;
    }

    @NotNull
    public final String getContentId() {
        return this.contentId;
    }

    public final int getContentScene() {
        return this.contentScene;
    }

    public final int getPageId() {
        return this.pageId;
    }

    @NotNull
    public final String getSealTransfer() {
        return this.sealTransfer;
    }

    public final int getSourceFrom() {
        return this.sourceFrom;
    }

    @NotNull
    public final String getTraceId() {
        return this.traceId;
    }

    @Nullable
    public final VideoInfo getVideo() {
        return this.video;
    }

    /* renamed from: isContinuation, reason: from getter */
    public final boolean getIsContinuation() {
        return this.isContinuation;
    }

    /* renamed from: isTopViewPreload, reason: from getter */
    public final boolean getIsTopViewPreload() {
        return this.isTopViewPreload;
    }

    public final void setAuthorUin(@NotNull String str) {
        this.authorUin = str;
    }

    public final void setBusinessId(int i3) {
        this.businessId = i3;
    }

    public final void setBusinessScene(@NotNull String str) {
        this.businessScene = str;
    }

    public final void setContentId(@NotNull String str) {
        this.contentId = str;
    }

    public final void setContentScene(int i3) {
        this.contentScene = i3;
    }

    public final void setContinuation(boolean z16) {
        this.isContinuation = z16;
    }

    public final void setPageId(int i3) {
        this.pageId = i3;
    }

    public final void setSealTransfer(@NotNull String str) {
        this.sealTransfer = str;
    }

    public final void setSourceFrom(int i3) {
        this.sourceFrom = i3;
    }

    public final void setTopViewPreload(boolean z16) {
        this.isTopViewPreload = z16;
    }

    public final void setTraceId(@NotNull String str) {
        this.traceId = str;
    }

    public final void setVideo(@Nullable VideoInfo videoInfo) {
        this.video = videoInfo;
    }

    public /* synthetic */ ECContentInfo(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
