package com.tencent.mobileqq.guild.feed.feedsquare.adapter;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.DiffUtil;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedSquareFeedPayloadType;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCustomManageTag;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelSign;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.raft.codegenmeta.utils.Constants;
import java.util.Arrays;
import java.util.EnumMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SpreadBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013JO\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022.\u0010\b\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060\u0005\"\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0017J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016R\u0018\u0010\u0011\u001a\u00060\u000fR\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0010\u00a8\u0006\u0019\u00b2\u0006\u0018\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00158\nX\u008a\u0084\u0002"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/GuildFeedSquareItemDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/h;", "oldItem", "newItem", "", "Lkotlin/Function1;", "", "property", "", "e", "(Lcom/tencent/mobileqq/guild/feed/feedsquare/data/h;Lcom/tencent/mobileqq/guild/feed/feedsquare/data/h;[Lkotlin/jvm/functions/Function1;)Z", "b", "a", "c", "Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/GuildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/GuildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper;", Constants.Service.PROPERTIES, "<init>", "()V", "GuildFeedSquareItemPropertyWrapper", "Ljava/util/EnumMap;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedSquareFeedPayloadType;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/i;", "payloadMap", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class GuildFeedSquareItemDiffCallback extends DiffUtil.ItemCallback<com.tencent.mobileqq.guild.feed.feedsquare.data.h> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildFeedSquareItemPropertyWrapper properties = new GuildFeedSquareItemPropertyWrapper();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\b\u0012\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\"\u0010#R)\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002j\u0002`\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR)\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002j\u0002`\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0006\u001a\u0004\b\n\u0010\bR)\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002j\u0002`\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\bR)\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002j\u0002`\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\bR/\u0010\u0017\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002j\u0002`\u00040\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R/\u0010\u001a\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002j\u0002`\u00040\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R)\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002j\u0002`\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001c\u0010\bR/\u0010\u001f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002j\u0002`\u00040\u00128\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u0005\u0010\u0016R/\u0010!\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002j\u0002`\u00040\u00128\u0006\u00a2\u0006\f\n\u0004\b \u0010\u0014\u001a\u0004\b\f\u0010\u0016\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/GuildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper;", "", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/h;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/GuildFeedSquareFeedItemDataProperty;", "a", "Lkotlin/jvm/functions/Function1;", "b", "()Lkotlin/jvm/functions/Function1;", "iddProperty", "getTaskProgressProperty", "taskProgressProperty", "c", "getNextSystemPromptProperty", "nextSystemPromptProperty", "d", "getPreviousSystemPromptProperty", "previousSystemPromptProperty", "", "e", "[Lkotlin/jvm/functions/Function1;", "getBottomContentsProperties", "()[Lkotlin/jvm/functions/Function1;", "bottomContentsProperties", "f", "getModifyAndInteractionTimeProperties", "modifyAndInteractionTimeProperties", "g", "getChannelSignProperty", "channelSignProperty", tl.h.F, "allContentProperties", "i", "unknownPayloadProperties", "<init>", "(Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/GuildFeedSquareItemDiffCallback;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public final class GuildFeedSquareItemPropertyWrapper {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function1<com.tencent.mobileqq.guild.feed.feedsquare.data.h, Object> iddProperty;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function1<com.tencent.mobileqq.guild.feed.feedsquare.data.h, Object> taskProgressProperty;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function1<com.tencent.mobileqq.guild.feed.feedsquare.data.h, Object> nextSystemPromptProperty;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function1<com.tencent.mobileqq.guild.feed.feedsquare.data.h, Object> previousSystemPromptProperty;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function1<com.tencent.mobileqq.guild.feed.feedsquare.data.h, Object>[] bottomContentsProperties;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function1<com.tencent.mobileqq.guild.feed.feedsquare.data.h, Object>[] modifyAndInteractionTimeProperties;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function1<com.tencent.mobileqq.guild.feed.feedsquare.data.h, Object> channelSignProperty;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function1<com.tencent.mobileqq.guild.feed.feedsquare.data.h, Object>[] allContentProperties;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function1<com.tencent.mobileqq.guild.feed.feedsquare.data.h, Object>[] unknownPayloadProperties;

        public GuildFeedSquareItemPropertyWrapper() {
            GuildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper$iddProperty$1 guildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper$iddProperty$1 = new Function1<com.tencent.mobileqq.guild.feed.feedsquare.data.h, String>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.adapter.GuildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper$iddProperty$1
                @Override // kotlin.jvm.functions.Function1
                public final String invoke(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.data.h it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.getBlockData().b().idd;
                }
            };
            this.iddProperty = guildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper$iddProperty$1;
            GuildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper$taskProgressProperty$1 guildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper$taskProgressProperty$1 = new Function1<com.tencent.mobileqq.guild.feed.feedsquare.data.h, GuildTaskProgressState>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.adapter.GuildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper$taskProgressProperty$1
                @Override // kotlin.jvm.functions.Function1
                public final GuildTaskProgressState invoke(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.data.h it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return it.getBlockData().p();
                }
            };
            this.taskProgressProperty = guildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper$taskProgressProperty$1;
            GuildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper$nextSystemPromptProperty$1 guildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper$nextSystemPromptProperty$1 = new Function1<com.tencent.mobileqq.guild.feed.feedsquare.data.h, Function0<? extends Boolean>>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.adapter.GuildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper$nextSystemPromptProperty$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Function0<Boolean> invoke(@NotNull final com.tencent.mobileqq.guild.feed.feedsquare.data.h it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new Function0<Boolean>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.adapter.GuildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper$nextSystemPromptProperty$1.1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final Boolean invoke() {
                            return Boolean.valueOf(com.tencent.mobileqq.guild.feed.feedsquare.data.h.this.getBlockData().q());
                        }
                    };
                }
            };
            this.nextSystemPromptProperty = guildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper$nextSystemPromptProperty$1;
            GuildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper$previousSystemPromptProperty$1 guildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper$previousSystemPromptProperty$1 = new Function1<com.tencent.mobileqq.guild.feed.feedsquare.data.h, Function0<? extends Boolean>>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.adapter.GuildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper$previousSystemPromptProperty$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Function0<Boolean> invoke(@NotNull final com.tencent.mobileqq.guild.feed.feedsquare.data.h it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new Function0<Boolean>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.adapter.GuildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper$previousSystemPromptProperty$1.1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final Boolean invoke() {
                            return Boolean.valueOf(com.tencent.mobileqq.guild.feed.feedsquare.data.h.this.getBlockData().r());
                        }
                    };
                }
            };
            this.previousSystemPromptProperty = guildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper$previousSystemPromptProperty$1;
            Function1<com.tencent.mobileqq.guild.feed.feedsquare.data.h, Object>[] function1Arr = {new Function1<com.tencent.mobileqq.guild.feed.feedsquare.data.h, Object>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.adapter.GuildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper$bottomContentsProperties$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Object invoke(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.data.h it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Integer.valueOf(it.getBlockData().b().totalLike.likeCount);
                }
            }, new Function1<com.tencent.mobileqq.guild.feed.feedsquare.data.h, Object>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.adapter.GuildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper$bottomContentsProperties$2
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Object invoke(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.data.h it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(it.getBlockData().b().totalLike.isClicked);
                }
            }, new Function1<com.tencent.mobileqq.guild.feed.feedsquare.data.h, Object>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.adapter.GuildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper$bottomContentsProperties$3
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Object invoke(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.data.h it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Integer.valueOf(it.getBlockData().b().share.sharedCount);
                }
            }, new Function1<com.tencent.mobileqq.guild.feed.feedsquare.data.h, Object>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.adapter.GuildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper$bottomContentsProperties$4
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Object invoke(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.data.h it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Integer.valueOf(it.getBlockData().b().commentCount);
                }
            }};
            this.bottomContentsProperties = function1Arr;
            Function1<com.tencent.mobileqq.guild.feed.feedsquare.data.h, Object>[] function1Arr2 = {new Function1<com.tencent.mobileqq.guild.feed.feedsquare.data.h, Object>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.adapter.GuildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper$modifyAndInteractionTimeProperties$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Object invoke(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.data.h it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    String str = it.getBlockData().b().poster.nick;
                    return str == null ? "" : str;
                }
            }, new Function1<com.tencent.mobileqq.guild.feed.feedsquare.data.h, Object>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.adapter.GuildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper$modifyAndInteractionTimeProperties$2
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Object invoke(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.data.h it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    GProCustomManageTag gProCustomManageTag = it.getBlockData().b().poster.manageTag;
                    String str = gProCustomManageTag != null ? gProCustomManageTag.tagName : null;
                    return str == null ? "" : str;
                }
            }, new Function1<com.tencent.mobileqq.guild.feed.feedsquare.data.h, Object>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.adapter.GuildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper$modifyAndInteractionTimeProperties$3
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Object invoke(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.data.h it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    GProCustomManageTag gProCustomManageTag = it.getBlockData().b().poster.manageTag;
                    return Integer.valueOf(gProCustomManageTag != null ? gProCustomManageTag.color : 0);
                }
            }, new Function1<com.tencent.mobileqq.guild.feed.feedsquare.data.h, Object>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.adapter.GuildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper$modifyAndInteractionTimeProperties$4
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Object invoke(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.data.h it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Long.valueOf(it.getBlockData().b().latestInteraction.timestamp);
                }
            }, new Function1<com.tencent.mobileqq.guild.feed.feedsquare.data.h, Object>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.adapter.GuildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper$modifyAndInteractionTimeProperties$5
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Object invoke(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.data.h it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Long.valueOf(it.getBlockData().b().createTime);
                }
            }, new Function1<com.tencent.mobileqq.guild.feed.feedsquare.data.h, Object>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.adapter.GuildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper$modifyAndInteractionTimeProperties$6
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Object invoke(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.data.h it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Long.valueOf(it.getBlockData().b().meta.lastModifiedTime);
                }
            }, new Function1<com.tencent.mobileqq.guild.feed.feedsquare.data.h, Object>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.adapter.GuildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper$modifyAndInteractionTimeProperties$7
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Object invoke(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.data.h it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(it.getBlockData().b().channelTopInfo.isTop);
                }
            }};
            this.modifyAndInteractionTimeProperties = function1Arr2;
            GuildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper$channelSignProperty$1 guildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper$channelSignProperty$1 = new Function1<com.tencent.mobileqq.guild.feed.feedsquare.data.h, a<com.tencent.mobileqq.guild.feed.feedsquare.data.h>>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.adapter.GuildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper$channelSignProperty$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final a<com.tencent.mobileqq.guild.feed.feedsquare.data.h> invoke(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.data.h it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return new a<>(it, new Function2<com.tencent.mobileqq.guild.feed.feedsquare.data.h, com.tencent.mobileqq.guild.feed.feedsquare.data.h, Boolean>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.adapter.GuildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper$channelSignProperty$1.1
                        /* JADX WARN: Code restructure failed: missing block: B:41:0x0081, code lost:
                        
                            if (kotlin.jvm.internal.Intrinsics.areEqual(r5, r0) != false) goto L52;
                         */
                        @Override // kotlin.jvm.functions.Function2
                        @NotNull
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Boolean invoke(@Nullable com.tencent.mobileqq.guild.feed.feedsquare.data.h hVar, @Nullable com.tencent.mobileqq.guild.feed.feedsquare.data.h hVar2) {
                            boolean z16;
                            GProStChannelSign gProStChannelSign;
                            GProStChannelSign gProStChannelSign2;
                            GProStChannelSign gProStChannelSign3;
                            GProStChannelSign gProStChannelSign4;
                            ij1.g blockData;
                            GProStFeed b16;
                            ij1.g blockData2;
                            GProStFeed b17;
                            Long l3 = null;
                            GProStChannelInfo gProStChannelInfo = (hVar == null || (blockData2 = hVar.getBlockData()) == null || (b17 = blockData2.b()) == null) ? null : b17.channelInfo;
                            GProStChannelInfo gProStChannelInfo2 = (hVar2 == null || (blockData = hVar2.getBlockData()) == null || (b16 = blockData.b()) == null) ? null : b16.channelInfo;
                            if (!Intrinsics.areEqual(gProStChannelInfo, gProStChannelInfo2)) {
                                if (Intrinsics.areEqual(gProStChannelInfo != null ? gProStChannelInfo.guildName : null, gProStChannelInfo2 != null ? gProStChannelInfo2.guildName : null)) {
                                    if (Intrinsics.areEqual((gProStChannelInfo == null || (gProStChannelSign4 = gProStChannelInfo.sign) == null) ? null : Long.valueOf(gProStChannelSign4.guildId), (gProStChannelInfo2 == null || (gProStChannelSign3 = gProStChannelInfo2.sign) == null) ? null : Long.valueOf(gProStChannelSign3.guildId))) {
                                        Long valueOf = (gProStChannelInfo == null || (gProStChannelSign2 = gProStChannelInfo.sign) == null) ? null : Long.valueOf(gProStChannelSign2.channelId);
                                        if (gProStChannelInfo2 != null && (gProStChannelSign = gProStChannelInfo2.sign) != null) {
                                            l3 = Long.valueOf(gProStChannelSign.channelId);
                                        }
                                    }
                                }
                                z16 = false;
                                return Boolean.valueOf(z16);
                            }
                            z16 = true;
                            return Boolean.valueOf(z16);
                        }
                    });
                }
            };
            this.channelSignProperty = guildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper$channelSignProperty$1;
            SpreadBuilder spreadBuilder = new SpreadBuilder(7);
            spreadBuilder.add(guildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper$iddProperty$1);
            spreadBuilder.add(guildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper$taskProgressProperty$1);
            spreadBuilder.add(guildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper$nextSystemPromptProperty$1);
            spreadBuilder.add(guildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper$previousSystemPromptProperty$1);
            spreadBuilder.addSpread(function1Arr);
            spreadBuilder.addSpread(function1Arr2);
            spreadBuilder.add(guildFeedSquareItemDiffCallback$GuildFeedSquareItemPropertyWrapper$channelSignProperty$1);
            Function1<com.tencent.mobileqq.guild.feed.feedsquare.data.h, Object>[] function1Arr3 = (Function1[]) spreadBuilder.toArray(new Function1[spreadBuilder.size()]);
            this.allContentProperties = function1Arr3;
            this.unknownPayloadProperties = function1Arr3;
        }

        @NotNull
        public final Function1<com.tencent.mobileqq.guild.feed.feedsquare.data.h, Object>[] a() {
            return this.allContentProperties;
        }

        @NotNull
        public final Function1<com.tencent.mobileqq.guild.feed.feedsquare.data.h, Object> b() {
            return this.iddProperty;
        }

        @NotNull
        public final Function1<com.tencent.mobileqq.guild.feed.feedsquare.data.h, Object>[] c() {
            return this.unknownPayloadProperties;
        }
    }

    private static final EnumMap<GuildFeedSquareFeedPayloadType, com.tencent.mobileqq.guild.feed.feedsquare.data.i> d(Lazy<? extends EnumMap<GuildFeedSquareFeedPayloadType, com.tencent.mobileqq.guild.feed.feedsquare.data.i>> lazy) {
        return lazy.getValue();
    }

    private final boolean e(com.tencent.mobileqq.guild.feed.feedsquare.data.h oldItem, com.tencent.mobileqq.guild.feed.feedsquare.data.h newItem, Function1<? super com.tencent.mobileqq.guild.feed.feedsquare.data.h, ? extends Object>... property) {
        for (Function1<? super com.tencent.mobileqq.guild.feed.feedsquare.data.h, ? extends Object> function1 : property) {
            if (!Intrinsics.areEqual(function1.invoke(oldItem), function1.invoke(newItem))) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    @SuppressLint({"DiffUtilEquals"})
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean areContentsTheSame(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.data.h oldItem, @NotNull com.tencent.mobileqq.guild.feed.feedsquare.data.h newItem) {
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        Function1<com.tencent.mobileqq.guild.feed.feedsquare.data.h, Object>[] a16 = this.properties.a();
        return e(oldItem, newItem, (Function1[]) Arrays.copyOf(a16, a16.length));
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean areItemsTheSame(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.data.h oldItem, @NotNull com.tencent.mobileqq.guild.feed.feedsquare.data.h newItem) {
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return e(oldItem, newItem, this.properties.b());
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    @Nullable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Object getChangePayload(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.data.h oldItem, @NotNull com.tencent.mobileqq.guild.feed.feedsquare.data.h newItem) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<EnumMap<GuildFeedSquareFeedPayloadType, com.tencent.mobileqq.guild.feed.feedsquare.data.i>>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.adapter.GuildFeedSquareItemDiffCallback$getChangePayload$payloadMap$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final EnumMap<GuildFeedSquareFeedPayloadType, com.tencent.mobileqq.guild.feed.feedsquare.data.i> invoke() {
                Ref.BooleanRef.this.element = true;
                return new EnumMap<>(GuildFeedSquareFeedPayloadType.class);
            }
        });
        Function1<com.tencent.mobileqq.guild.feed.feedsquare.data.h, Object>[] c16 = this.properties.c();
        if (!e(oldItem, newItem, (Function1[]) Arrays.copyOf(c16, c16.length)) || !booleanRef.element) {
            return null;
        }
        return d(lazy);
    }
}
