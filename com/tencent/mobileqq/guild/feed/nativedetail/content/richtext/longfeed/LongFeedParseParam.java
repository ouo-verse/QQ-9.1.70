package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedPublishInfo;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.TextViewContainer;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.parser.IParseRichTextConfig;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProElem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0004\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020#0\"\u0012\b\b\u0002\u0010,\u001a\u00020)\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010-\u00a2\u0006\u0004\b1\u00102J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001f\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001c\u001a\u0004\b\n\u0010\u001dR\u0019\u0010!\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b\u0017\u0010 R\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010,\u001a\u00020)8\u0006\u00a2\u0006\f\n\u0004\b&\u0010*\u001a\u0004\b$\u0010+R\u0019\u00100\u001a\u0004\u0018\u00010-8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010.\u001a\u0004\b\u0011\u0010/\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/richtextspan/TextViewContainer;", "a", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/richtextspan/TextViewContainer;", h.F, "()Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/richtextspan/TextViewContainer;", "textViewContainer", "Lmqq/util/WeakReference;", "Landroidx/lifecycle/LifecycleOwner;", "b", "Lmqq/util/WeakReference;", "e", "()Lmqq/util/WeakReference;", "lifecycleOwner", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "c", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "d", "()Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "joinInfoParam", "I", "()I", "businessType", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "immersiveSource", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProElem;", "f", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;", "g", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;", "textParseConfig", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/LongFeedParseSceneType;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/LongFeedParseSceneType;", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/LongFeedParseSceneType;", "sceneType", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedPublishInfo;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedPublishInfo;", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedPublishInfo;", "feedPublishInfo", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/richtextspan/TextViewContainer;Lmqq/util/WeakReference;Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;ILjava/lang/Integer;Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/parser/IParseRichTextConfig;Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/LongFeedParseSceneType;Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedPublishInfo;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.a, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class LongFeedParseParam {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final TextViewContainer textViewContainer;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final WeakReference<LifecycleOwner> lifecycleOwner;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final JumpGuildParam.JoinInfoParam joinInfoParam;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int businessType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Integer immersiveSource;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final IParseRichTextConfig<GProElem> textParseConfig;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final LongFeedParseSceneType sceneType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final GuildFeedPublishInfo feedPublishInfo;

    public LongFeedParseParam(@NotNull TextViewContainer textViewContainer, @Nullable WeakReference<LifecycleOwner> weakReference, @Nullable JumpGuildParam.JoinInfoParam joinInfoParam, int i3, @Nullable Integer num, @NotNull IParseRichTextConfig<GProElem> textParseConfig, @NotNull LongFeedParseSceneType sceneType, @Nullable GuildFeedPublishInfo guildFeedPublishInfo) {
        Intrinsics.checkNotNullParameter(textViewContainer, "textViewContainer");
        Intrinsics.checkNotNullParameter(textParseConfig, "textParseConfig");
        Intrinsics.checkNotNullParameter(sceneType, "sceneType");
        this.textViewContainer = textViewContainer;
        this.lifecycleOwner = weakReference;
        this.joinInfoParam = joinInfoParam;
        this.businessType = i3;
        this.immersiveSource = num;
        this.textParseConfig = textParseConfig;
        this.sceneType = sceneType;
        this.feedPublishInfo = guildFeedPublishInfo;
    }

    /* renamed from: a, reason: from getter */
    public final int getBusinessType() {
        return this.businessType;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final GuildFeedPublishInfo getFeedPublishInfo() {
        return this.feedPublishInfo;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final Integer getImmersiveSource() {
        return this.immersiveSource;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final JumpGuildParam.JoinInfoParam getJoinInfoParam() {
        return this.joinInfoParam;
    }

    @Nullable
    public final WeakReference<LifecycleOwner> e() {
        return this.lifecycleOwner;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LongFeedParseParam)) {
            return false;
        }
        LongFeedParseParam longFeedParseParam = (LongFeedParseParam) other;
        if (Intrinsics.areEqual(this.textViewContainer, longFeedParseParam.textViewContainer) && Intrinsics.areEqual(this.lifecycleOwner, longFeedParseParam.lifecycleOwner) && Intrinsics.areEqual(this.joinInfoParam, longFeedParseParam.joinInfoParam) && this.businessType == longFeedParseParam.businessType && Intrinsics.areEqual(this.immersiveSource, longFeedParseParam.immersiveSource) && Intrinsics.areEqual(this.textParseConfig, longFeedParseParam.textParseConfig) && this.sceneType == longFeedParseParam.sceneType && Intrinsics.areEqual(this.feedPublishInfo, longFeedParseParam.feedPublishInfo)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final LongFeedParseSceneType getSceneType() {
        return this.sceneType;
    }

    @NotNull
    public final IParseRichTextConfig<GProElem> g() {
        return this.textParseConfig;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final TextViewContainer getTextViewContainer() {
        return this.textViewContainer;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4 = this.textViewContainer.hashCode() * 31;
        WeakReference<LifecycleOwner> weakReference = this.lifecycleOwner;
        int i3 = 0;
        if (weakReference == null) {
            hashCode = 0;
        } else {
            hashCode = weakReference.hashCode();
        }
        int i16 = (hashCode4 + hashCode) * 31;
        JumpGuildParam.JoinInfoParam joinInfoParam = this.joinInfoParam;
        if (joinInfoParam == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = joinInfoParam.hashCode();
        }
        int i17 = (((i16 + hashCode2) * 31) + this.businessType) * 31;
        Integer num = this.immersiveSource;
        if (num == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = num.hashCode();
        }
        int hashCode5 = (((((i17 + hashCode3) * 31) + this.textParseConfig.hashCode()) * 31) + this.sceneType.hashCode()) * 31;
        GuildFeedPublishInfo guildFeedPublishInfo = this.feedPublishInfo;
        if (guildFeedPublishInfo != null) {
            i3 = guildFeedPublishInfo.hashCode();
        }
        return hashCode5 + i3;
    }

    @NotNull
    public String toString() {
        return "LongFeedParseParam(textViewContainer=" + this.textViewContainer + ", lifecycleOwner=" + this.lifecycleOwner + ", joinInfoParam=" + this.joinInfoParam + ", businessType=" + this.businessType + ", immersiveSource=" + this.immersiveSource + ", textParseConfig=" + this.textParseConfig + ", sceneType=" + this.sceneType + ", feedPublishInfo=" + this.feedPublishInfo + ")";
    }

    public /* synthetic */ LongFeedParseParam(TextViewContainer textViewContainer, WeakReference weakReference, JumpGuildParam.JoinInfoParam joinInfoParam, int i3, Integer num, IParseRichTextConfig iParseRichTextConfig, LongFeedParseSceneType longFeedParseSceneType, GuildFeedPublishInfo guildFeedPublishInfo, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(textViewContainer, weakReference, (i16 & 4) != 0 ? null : joinInfoParam, (i16 & 8) != 0 ? 0 : i3, (i16 & 16) != 0 ? null : num, iParseRichTextConfig, (i16 & 64) != 0 ? LongFeedParseSceneType.FEED_DETAIL : longFeedParseSceneType, (i16 & 128) != 0 ? null : guildFeedPublishInfo);
    }
}
