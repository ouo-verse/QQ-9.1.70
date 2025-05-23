package com.tencent.guild.aio.article.msglist.holder.factory;

import android.util.SparseArray;
import android.view.View;
import com.tencent.guild.aio.article.msglist.holder.component.GuildArticleGrayTipsContentComponent;
import com.tencent.guild.aio.article.msglist.holder.component.GuildMainMsgEmptyComponent;
import com.tencent.guild.aio.article.msglist.holder.provider.GuildArticleMsgItemComponentProvider;
import com.tencent.guild.aio.msglist.ark.GuildArkComponent;
import com.tencent.guild.aio.msglist.file.GuildFileContentComponent;
import com.tencent.guild.aio.msglist.giphy.GuildGiphyContentComponent;
import com.tencent.guild.aio.msglist.holder.component.a;
import com.tencent.guild.aio.msglist.holder.component.mix.GuildMixPicBubbleComponent;
import com.tencent.guild.aio.msglist.holder.component.v;
import com.tencent.guild.aio.msglist.holder.config.BubbleMsgItemVBArgs;
import com.tencent.guild.aio.msglist.holder.config.GuildItemViewHolderDelegate;
import com.tencent.guild.aio.msglist.holder.config.b;
import com.tencent.guild.aio.msglist.holder.config.c;
import com.tencent.guild.aio.msglist.holder.config.d;
import com.tencent.guild.aio.msglist.holder.state.MsgListItemState;
import com.tencent.guild.aio.msglist.markdown.GuildMarkDownContentComponent;
import com.tencent.guild.aio.msglist.marketface.GuildMarketFaceComponent;
import com.tencent.guild.aio.msglist.pic.GuildPicContentComponent;
import com.tencent.guild.aio.msglist.text.GuildTextContentComponent;
import com.tencent.guild.aio.msglist.unsupport.GuildUnsupportedMsgContentComponent;
import com.tencent.guild.aio.msglist.video.GuildVideoContentComponent;
import com.tencent.guild.aio.msglist.wallet.GuildWalletComponent;
import com.tencent.guild.aio.msglist.wallet.GuildWalletUnSupportComponent;
import eq0.e;
import eq0.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/guild/aio/article/msglist/holder/factory/GuildArticleItemViewHolderFactoryProvider;", "Lcom/tencent/guild/aio/msglist/holder/config/c;", "", "viewType", "Lcom/tencent/guild/aio/msglist/holder/component/v;", "a", "Landroid/util/SparseArray;", "b", "Landroid/util/SparseArray;", "mItemViewHolderFactoryArray", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildArticleItemViewHolderFactoryProvider implements c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildArticleItemViewHolderFactoryProvider f109998a = new GuildArticleItemViewHolderFactoryProvider();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final SparseArray<v> mItemViewHolderFactoryArray;

    static {
        SparseArray<v> sparseArray = new SparseArray<>();
        GuildItemViewHolderDelegate guildItemViewHolderDelegate = new GuildItemViewHolderDelegate();
        guildItemViewHolderDelegate.f(new Function1<View, d>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$text$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final d invoke(@NotNull final View root) {
                Intrinsics.checkNotNullParameter(root, "root");
                return new GuildArticleMsgItemComponentProvider(root, null, null, null, new Function1<View, a>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$text$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GuildTextContentComponent(root);
                    }
                }, null, null, null, null, null, null, 2030, null);
            }
        });
        guildItemViewHolderDelegate.c(new Function1<BubbleMsgItemVBArgs, com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState>>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$text$1$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> invoke(@NotNull BubbleMsgItemVBArgs it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new com.tencent.guild.aio.article.msglist.holder.a(it.getTemplateView(), it.getComponentProvider(), it.getFactoryProvider(), it.getViewType());
            }
        });
        b bVar = new b(guildItemViewHolderDelegate);
        sparseArray.put(7, bVar);
        sparseArray.put(6, bVar);
        GuildItemViewHolderDelegate guildItemViewHolderDelegate2 = new GuildItemViewHolderDelegate();
        guildItemViewHolderDelegate2.f(new Function1<View, d>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$pic$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final d invoke(@NotNull final View root) {
                Intrinsics.checkNotNullParameter(root, "root");
                return new GuildArticleMsgItemComponentProvider(root, null, null, null, new Function1<View, a>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$pic$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GuildPicContentComponent(root);
                    }
                }, null, null, null, null, null, null, 2030, null);
            }
        });
        guildItemViewHolderDelegate2.c(new Function1<BubbleMsgItemVBArgs, com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState>>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$pic$1$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> invoke(@NotNull BubbleMsgItemVBArgs it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new com.tencent.guild.aio.article.msglist.holder.a(it.getTemplateView(), it.getComponentProvider(), it.getFactoryProvider(), it.getViewType());
            }
        });
        b bVar2 = new b(guildItemViewHolderDelegate2);
        sparseArray.put(5, bVar2);
        sparseArray.put(4, bVar2);
        GuildItemViewHolderDelegate guildItemViewHolderDelegate3 = new GuildItemViewHolderDelegate();
        guildItemViewHolderDelegate3.f(new Function1<View, d>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$mix$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final d invoke(@NotNull View root) {
                Intrinsics.checkNotNullParameter(root, "root");
                return new GuildArticleMsgItemComponentProvider(root, null, null, null, null, null, null, null, null, null, null, 2046, null);
            }
        });
        guildItemViewHolderDelegate3.c(new Function1<BubbleMsgItemVBArgs, com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState>>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$mix$1$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> invoke(@NotNull BubbleMsgItemVBArgs it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new com.tencent.guild.aio.article.msglist.holder.a(it.getTemplateView(), it.getComponentProvider(), it.getFactoryProvider(), it.getViewType());
            }
        });
        b bVar3 = new b(guildItemViewHolderDelegate3);
        sparseArray.put(3, bVar3);
        sparseArray.put(2, bVar3);
        sparseArray.put(60, bVar3);
        sparseArray.put(61, bVar3);
        sparseArray.put(62, bVar3);
        sparseArray.put(63, bVar3);
        GuildItemViewHolderDelegate guildItemViewHolderDelegate4 = new GuildItemViewHolderDelegate();
        guildItemViewHolderDelegate4.f(new Function1<View, d>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$video$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final d invoke(@NotNull final View root) {
                Intrinsics.checkNotNullParameter(root, "root");
                return new GuildArticleMsgItemComponentProvider(root, null, null, null, new Function1<View, a>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$video$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GuildVideoContentComponent(root);
                    }
                }, null, null, null, null, null, null, 2030, null);
            }
        });
        guildItemViewHolderDelegate4.c(new Function1<BubbleMsgItemVBArgs, com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState>>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$video$1$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> invoke(@NotNull BubbleMsgItemVBArgs it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new com.tencent.guild.aio.article.msglist.holder.a(it.getTemplateView(), it.getComponentProvider(), it.getFactoryProvider(), it.getViewType());
            }
        });
        b bVar4 = new b(guildItemViewHolderDelegate4);
        sparseArray.put(11, bVar4);
        sparseArray.put(10, bVar4);
        GuildItemViewHolderDelegate guildItemViewHolderDelegate5 = new GuildItemViewHolderDelegate();
        guildItemViewHolderDelegate5.f(new Function1<View, d>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$file$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final d invoke(@NotNull final View root) {
                Intrinsics.checkNotNullParameter(root, "root");
                return new GuildArticleMsgItemComponentProvider(root, null, null, null, new Function1<View, a>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$file$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GuildFileContentComponent(root);
                    }
                }, null, null, null, null, null, null, 2030, null);
            }
        });
        guildItemViewHolderDelegate5.c(new Function1<BubbleMsgItemVBArgs, com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState>>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$file$1$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> invoke(@NotNull BubbleMsgItemVBArgs it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new com.tencent.guild.aio.article.msglist.holder.a(it.getTemplateView(), it.getComponentProvider(), it.getFactoryProvider(), it.getViewType());
            }
        });
        guildItemViewHolderDelegate5.d(new Function0<com.tencent.aio.api.list.b<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState>>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$file$1$3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.aio.api.list.b<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> invoke() {
                return new com.tencent.guild.aio.msglist.holder.b();
            }
        });
        b bVar5 = new b(guildItemViewHolderDelegate5);
        sparseArray.put(9, bVar5);
        sparseArray.put(8, bVar5);
        GuildItemViewHolderDelegate guildItemViewHolderDelegate6 = new GuildItemViewHolderDelegate();
        guildItemViewHolderDelegate6.f(new Function1<View, d>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$giphy$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final d invoke(@NotNull final View root) {
                Intrinsics.checkNotNullParameter(root, "root");
                return new GuildArticleMsgItemComponentProvider(root, null, null, null, new Function1<View, a>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$giphy$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GuildGiphyContentComponent(root);
                    }
                }, null, null, null, null, null, null, 2030, null);
            }
        });
        guildItemViewHolderDelegate6.c(new Function1<BubbleMsgItemVBArgs, com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState>>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$giphy$1$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> invoke(@NotNull BubbleMsgItemVBArgs it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new com.tencent.guild.aio.article.msglist.holder.a(it.getTemplateView(), it.getComponentProvider(), it.getFactoryProvider(), it.getViewType());
            }
        });
        b bVar6 = new b(guildItemViewHolderDelegate6);
        sparseArray.put(22, bVar6);
        sparseArray.put(21, bVar6);
        GuildItemViewHolderDelegate guildItemViewHolderDelegate7 = new GuildItemViewHolderDelegate();
        guildItemViewHolderDelegate7.f(new Function1<View, d>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$replySelf$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final d invoke(@NotNull final View root) {
                Intrinsics.checkNotNullParameter(root, "root");
                return new GuildArticleMsgItemComponentProvider(root, null, null, null, new Function1<View, a>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$replySelf$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GuildTextContentComponent(root);
                    }
                }, null, null, null, null, null, null, 2030, null);
            }
        });
        guildItemViewHolderDelegate7.c(new Function1<BubbleMsgItemVBArgs, com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState>>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$replySelf$1$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> invoke(@NotNull BubbleMsgItemVBArgs it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new com.tencent.guild.aio.article.msglist.holder.a(it.getTemplateView(), it.getComponentProvider(), it.getFactoryProvider(), it.getViewType());
            }
        });
        sparseArray.put(24, new b(guildItemViewHolderDelegate7));
        GuildItemViewHolderDelegate guildItemViewHolderDelegate8 = new GuildItemViewHolderDelegate();
        guildItemViewHolderDelegate8.f(new Function1<View, d>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$replyFriend$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final d invoke(@NotNull final View root) {
                Intrinsics.checkNotNullParameter(root, "root");
                return new GuildArticleMsgItemComponentProvider(root, null, null, null, new Function1<View, a>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$replyFriend$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GuildMixPicBubbleComponent(root);
                    }
                }, null, null, null, null, null, null, 2030, null);
            }
        });
        guildItemViewHolderDelegate8.c(new Function1<BubbleMsgItemVBArgs, com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState>>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$replyFriend$1$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> invoke(@NotNull BubbleMsgItemVBArgs it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new com.tencent.guild.aio.article.msglist.holder.a(it.getTemplateView(), it.getComponentProvider(), it.getFactoryProvider(), it.getViewType());
            }
        });
        sparseArray.put(23, new b(guildItemViewHolderDelegate8));
        GuildItemViewHolderDelegate guildItemViewHolderDelegate9 = new GuildItemViewHolderDelegate();
        guildItemViewHolderDelegate9.f(new Function1<View, d>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$markdown$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final d invoke(@NotNull final View root) {
                Intrinsics.checkNotNullParameter(root, "root");
                return new GuildArticleMsgItemComponentProvider(root, null, null, null, new Function1<View, a>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$markdown$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GuildMarkDownContentComponent(root);
                    }
                }, null, null, null, null, null, null, 2030, null);
            }
        });
        guildItemViewHolderDelegate9.c(new Function1<BubbleMsgItemVBArgs, com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState>>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$markdown$1$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> invoke(@NotNull BubbleMsgItemVBArgs it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new com.tencent.guild.aio.article.msglist.holder.a(it.getTemplateView(), it.getComponentProvider(), it.getFactoryProvider(), it.getViewType());
            }
        });
        b bVar7 = new b(guildItemViewHolderDelegate9);
        sparseArray.put(26, bVar7);
        sparseArray.put(25, bVar7);
        GuildItemViewHolderDelegate guildItemViewHolderDelegate10 = new GuildItemViewHolderDelegate();
        guildItemViewHolderDelegate10.f(new Function1<View, d>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$ark$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final d invoke(@NotNull final View root) {
                Intrinsics.checkNotNullParameter(root, "root");
                return new GuildArticleMsgItemComponentProvider(root, null, null, null, new Function1<View, a>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$ark$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GuildArkComponent(root);
                    }
                }, null, null, null, null, null, null, 2030, null);
            }
        });
        guildItemViewHolderDelegate10.c(new Function1<BubbleMsgItemVBArgs, com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState>>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$ark$1$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> invoke(@NotNull BubbleMsgItemVBArgs it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new com.tencent.guild.aio.article.msglist.holder.a(it.getTemplateView(), it.getComponentProvider(), it.getFactoryProvider(), it.getViewType());
            }
        });
        b bVar8 = new b(guildItemViewHolderDelegate10);
        sparseArray.put(34, bVar8);
        sparseArray.put(35, bVar8);
        GuildItemViewHolderDelegate guildItemViewHolderDelegate11 = new GuildItemViewHolderDelegate();
        guildItemViewHolderDelegate11.f(new Function1<View, d>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$marketFace$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final d invoke(@NotNull final View root) {
                Intrinsics.checkNotNullParameter(root, "root");
                return new GuildArticleMsgItemComponentProvider(root, null, null, null, new Function1<View, a>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$marketFace$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GuildMarketFaceComponent(root);
                    }
                }, null, null, null, null, null, null, 2030, null);
            }
        });
        guildItemViewHolderDelegate11.c(new Function1<BubbleMsgItemVBArgs, com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState>>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$marketFace$1$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> invoke(@NotNull BubbleMsgItemVBArgs it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new com.tencent.guild.aio.article.msglist.holder.a(it.getTemplateView(), it.getComponentProvider(), it.getFactoryProvider(), it.getViewType());
            }
        });
        b bVar9 = new b(guildItemViewHolderDelegate11);
        sparseArray.put(37, bVar9);
        sparseArray.put(36, bVar9);
        GuildItemViewHolderDelegate guildItemViewHolderDelegate12 = new GuildItemViewHolderDelegate();
        guildItemViewHolderDelegate12.f(new Function1<View, d>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$walletUnSupport$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final d invoke(@NotNull final View root) {
                Intrinsics.checkNotNullParameter(root, "root");
                return new GuildArticleMsgItemComponentProvider(root, null, null, null, new Function1<View, a>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$walletUnSupport$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GuildWalletUnSupportComponent(root);
                    }
                }, null, null, null, null, null, null, 2030, null);
            }
        });
        guildItemViewHolderDelegate12.c(new Function1<BubbleMsgItemVBArgs, com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState>>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$walletUnSupport$1$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> invoke(@NotNull BubbleMsgItemVBArgs it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new com.tencent.guild.aio.article.msglist.holder.a(it.getTemplateView(), it.getComponentProvider(), it.getFactoryProvider(), it.getViewType());
            }
        });
        b bVar10 = new b(guildItemViewHolderDelegate12);
        sparseArray.put(45, bVar10);
        sparseArray.put(44, bVar10);
        GuildItemViewHolderDelegate guildItemViewHolderDelegate13 = new GuildItemViewHolderDelegate();
        guildItemViewHolderDelegate13.g(new Function0<g>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$1$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final g invoke() {
                return new eq0.c();
            }
        });
        guildItemViewHolderDelegate13.f(new Function1<View, d>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$1$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final d invoke(@NotNull final View root) {
                Intrinsics.checkNotNullParameter(root, "root");
                return new GuildArticleMsgItemComponentProvider(root, null, null, null, new Function1<View, a>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$1$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GuildArticleGrayTipsContentComponent(root);
                    }
                }, null, null, null, null, new Function1<View, a>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$1$2.2
                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return null;
                    }
                }, null, 1518, null);
            }
        });
        guildItemViewHolderDelegate13.c(new Function1<BubbleMsgItemVBArgs, com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState>>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$1$3
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> invoke(@NotNull BubbleMsgItemVBArgs it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new com.tencent.guild.aio.article.msglist.holder.a(it.getTemplateView(), it.getComponentProvider(), it.getFactoryProvider(), it.getViewType());
            }
        });
        Unit unit = Unit.INSTANCE;
        sparseArray.put(50, new b(guildItemViewHolderDelegate13));
        GuildItemViewHolderDelegate guildItemViewHolderDelegate14 = new GuildItemViewHolderDelegate();
        guildItemViewHolderDelegate14.f(new Function1<View, d>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$empty$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final d invoke(@NotNull final View root) {
                Intrinsics.checkNotNullParameter(root, "root");
                return new GuildArticleMsgItemComponentProvider(root, new Function1<View, a>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$empty$1$1.1
                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return null;
                    }
                }, new Function1<View, a>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$empty$1$1.2
                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return null;
                    }
                }, new Function1<View, a>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$empty$1$1.3
                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return null;
                    }
                }, new Function1<View, a>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$empty$1$1.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GuildMainMsgEmptyComponent(root);
                    }
                }, new Function1<View, a>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$empty$1$1.5
                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return null;
                    }
                }, new Function1<View, a>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$empty$1$1.6
                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return null;
                    }
                }, null, new Function1<View, a>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$empty$1$1.7
                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return null;
                    }
                }, new Function1<View, a>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$empty$1$1.8
                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return null;
                    }
                }, new Function1<View, a>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$empty$1$1.9
                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return null;
                    }
                }, 128, null);
            }
        });
        guildItemViewHolderDelegate14.g(new Function0<g>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$empty$1$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final g invoke() {
                return new kn0.a();
            }
        });
        guildItemViewHolderDelegate14.c(new Function1<BubbleMsgItemVBArgs, com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState>>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$empty$1$3
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> invoke(@NotNull BubbleMsgItemVBArgs it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new jn0.a(it.getTemplateView(), it.getComponentProvider(), it.getFactoryProvider(), it.getViewType());
            }
        });
        guildItemViewHolderDelegate14.d(new Function0<com.tencent.aio.api.list.b<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState>>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$empty$1$4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.aio.api.list.b<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> invoke() {
                return new jn0.b();
            }
        });
        sparseArray.put(40, new b(guildItemViewHolderDelegate14));
        GuildItemViewHolderDelegate guildItemViewHolderDelegate15 = new GuildItemViewHolderDelegate();
        guildItemViewHolderDelegate15.f(new Function1<View, d>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$replyCount$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final d invoke(@NotNull final View root) {
                Intrinsics.checkNotNullParameter(root, "root");
                return new GuildArticleMsgItemComponentProvider(root, new Function1<View, a>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$replyCount$1$1.1
                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return null;
                    }
                }, new Function1<View, a>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$replyCount$1$1.2
                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return null;
                    }
                }, new Function1<View, a>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$replyCount$1$1.3
                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return null;
                    }
                }, new Function1<View, a>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$replyCount$1$1.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new com.tencent.guild.aio.article.msglist.holder.component.b(root);
                    }
                }, new Function1<View, a>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$replyCount$1$1.5
                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return null;
                    }
                }, new Function1<View, a>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$replyCount$1$1.6
                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return null;
                    }
                }, null, new Function1<View, a>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$replyCount$1$1.7
                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return null;
                    }
                }, new Function1<View, a>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$replyCount$1$1.8
                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return null;
                    }
                }, new Function1<View, a>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$replyCount$1$1.9
                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return null;
                    }
                }, 128, null);
            }
        });
        guildItemViewHolderDelegate15.g(new Function0<g>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$replyCount$1$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final g invoke() {
                return new kn0.b();
            }
        });
        guildItemViewHolderDelegate15.c(new Function1<BubbleMsgItemVBArgs, com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState>>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$replyCount$1$3
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> invoke(@NotNull BubbleMsgItemVBArgs it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new jn0.c(it.getTemplateView(), it.getComponentProvider(), it.getFactoryProvider(), it.getViewType());
            }
        });
        guildItemViewHolderDelegate15.d(new Function0<com.tencent.aio.api.list.b<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState>>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$replyCount$1$4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.aio.api.list.b<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> invoke() {
                return new jn0.d();
            }
        });
        sparseArray.put(41, new b(guildItemViewHolderDelegate15));
        GuildItemViewHolderDelegate guildItemViewHolderDelegate16 = new GuildItemViewHolderDelegate();
        guildItemViewHolderDelegate16.f(new Function1<View, d>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$wallet$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final d invoke(@NotNull final View root) {
                Intrinsics.checkNotNullParameter(root, "root");
                return new GuildArticleMsgItemComponentProvider(root, null, null, null, new Function1<View, a>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$wallet$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GuildWalletComponent(root);
                    }
                }, null, null, null, null, null, null, 2030, null);
            }
        });
        guildItemViewHolderDelegate16.c(new Function1<BubbleMsgItemVBArgs, com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState>>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$wallet$1$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> invoke(@NotNull BubbleMsgItemVBArgs it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new com.tencent.guild.aio.article.msglist.holder.a(it.getTemplateView(), it.getComponentProvider(), it.getFactoryProvider(), it.getViewType());
            }
        });
        b bVar11 = new b(guildItemViewHolderDelegate16);
        sparseArray.put(43, bVar11);
        sparseArray.put(42, bVar11);
        mItemViewHolderFactoryArray = sparseArray;
    }

    GuildArticleItemViewHolderFactoryProvider() {
    }

    @Override // com.tencent.guild.aio.msglist.holder.config.c
    @NotNull
    public v a(int viewType) {
        v vVar = mItemViewHolderFactoryArray.get(viewType);
        if (vVar == null) {
            GuildItemViewHolderDelegate guildItemViewHolderDelegate = new GuildItemViewHolderDelegate();
            guildItemViewHolderDelegate.f(new Function1<View, d>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$getItemViewHolderFactory$1$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final d invoke(@NotNull final View root) {
                    Intrinsics.checkNotNullParameter(root, "root");
                    return new GuildArticleMsgItemComponentProvider(root, null, null, null, new Function1<View, a>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$getItemViewHolderFactory$1$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        @Nullable
                        public final a invoke(@NotNull View it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            return new GuildUnsupportedMsgContentComponent(root);
                        }
                    }, null, null, null, null, null, null, 2030, null);
                }
            });
            guildItemViewHolderDelegate.g(new Function0<g>() { // from class: com.tencent.guild.aio.article.msglist.holder.factory.GuildArticleItemViewHolderFactoryProvider$getItemViewHolderFactory$1$2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final g invoke() {
                    return new e();
                }
            });
            return new b(guildItemViewHolderDelegate);
        }
        return vVar;
    }
}
