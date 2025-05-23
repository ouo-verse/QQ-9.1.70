package com.tencent.qqguild.directmessage.aio;

import android.util.SparseArray;
import android.view.View;
import com.tencent.guild.aio.msglist.ark.GuildArkComponent;
import com.tencent.guild.aio.msglist.file.GuildFileContentComponent;
import com.tencent.guild.aio.msglist.giphy.GuildGiphyContentComponent;
import com.tencent.guild.aio.msglist.graytips.common.GuildCommonGrayTipsComponent;
import com.tencent.guild.aio.msglist.graytips.special.revoke.GuildRevokeGrayTipsComponent;
import com.tencent.guild.aio.msglist.holder.component.GuildMsgItemComponentProvider;
import com.tencent.guild.aio.msglist.holder.component.mix.GuildMixPicBubbleComponent;
import com.tencent.guild.aio.msglist.holder.component.mix.GuildMixVideoBubbleComponent;
import com.tencent.guild.aio.msglist.holder.component.v;
import com.tencent.guild.aio.msglist.holder.config.BubbleMsgItemVBArgs;
import com.tencent.guild.aio.msglist.holder.config.GuildItemViewHolderDelegate;
import com.tencent.guild.aio.msglist.holder.state.MsgListItemState;
import com.tencent.guild.aio.msglist.markdown.GuildMarkDownContentComponent;
import com.tencent.guild.aio.msglist.marketface.GuildMarketFaceComponent;
import com.tencent.guild.aio.msglist.pic.GuildPicContentComponent;
import com.tencent.guild.aio.msglist.reply.GuildReplyComponent;
import com.tencent.guild.aio.msglist.text.GuildTextContentComponent;
import com.tencent.guild.aio.msglist.unsupport.GuildUnsupportedMsgContentComponent;
import com.tencent.guild.aio.msglist.video.GuildVideoContentComponent;
import com.tencent.guild.aio.msglist.wallet.GuildWalletComponent;
import com.tencent.guild.aio.msglist.wallet.GuildWalletUnSupportComponent;
import com.tencent.guild.aio.msglist.welcome.GuildDirectWelcomeRobotComponent;
import com.tencent.qqguild.directmessage.aio.graytips.local.robotblack.GuildBlackRobotGrayTipsComponent;
import com.tencent.qqguild.directmessage.aio.graytips.local.robotmsglimit.GuildRobotMsgLimitGrayTipsComponent;
import cooperation.qzone.util.WnsError;
import eq0.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/GuildDirectItemViewHolderFactoryProvider;", "Lcom/tencent/guild/aio/msglist/holder/config/c;", "", "viewType", "Lcom/tencent/guild/aio/msglist/holder/component/v;", "a", "Landroid/util/SparseArray;", "b", "Landroid/util/SparseArray;", "mItemViewHolderFactoryArray", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class GuildDirectItemViewHolderFactoryProvider implements com.tencent.guild.aio.msglist.holder.config.c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildDirectItemViewHolderFactoryProvider f344995a = new GuildDirectItemViewHolderFactoryProvider();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final SparseArray<v> mItemViewHolderFactoryArray;

    static {
        SparseArray<v> sparseArray = new SparseArray<>();
        GuildItemViewHolderDelegate guildItemViewHolderDelegate = new GuildItemViewHolderDelegate();
        guildItemViewHolderDelegate.f(new Function1<View, com.tencent.guild.aio.msglist.holder.config.d>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$text$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.guild.aio.msglist.holder.config.d invoke(@NotNull final View root) {
                Intrinsics.checkNotNullParameter(root, "root");
                return new GuildMsgItemComponentProvider(root, null, null, null, new Function1<View, com.tencent.guild.aio.msglist.holder.component.a>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$text$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final com.tencent.guild.aio.msglist.holder.component.a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GuildTextContentComponent(root);
                    }
                }, null, null, null, null, null, null, 2030, null);
            }
        });
        com.tencent.guild.aio.msglist.holder.config.b bVar = new com.tencent.guild.aio.msglist.holder.config.b(guildItemViewHolderDelegate);
        sparseArray.put(7, bVar);
        sparseArray.put(6, bVar);
        GuildItemViewHolderDelegate guildItemViewHolderDelegate2 = new GuildItemViewHolderDelegate();
        guildItemViewHolderDelegate2.f(new Function1<View, com.tencent.guild.aio.msglist.holder.config.d>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$pic$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.guild.aio.msglist.holder.config.d invoke(@NotNull final View root) {
                Intrinsics.checkNotNullParameter(root, "root");
                return new GuildMsgItemComponentProvider(root, null, null, null, new Function1<View, com.tencent.guild.aio.msglist.holder.component.a>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$pic$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final com.tencent.guild.aio.msglist.holder.component.a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GuildPicContentComponent(root);
                    }
                }, null, null, null, null, null, null, 2030, null);
            }
        });
        guildItemViewHolderDelegate2.c(new Function1<BubbleMsgItemVBArgs, com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState>>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$pic$1$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> invoke(@NotNull BubbleMsgItemVBArgs it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new com.tencent.guild.aio.msglist.pic.a(it.getTemplateView(), it.getComponentProvider(), it.getFactoryProvider(), it.getViewType());
            }
        });
        com.tencent.guild.aio.msglist.holder.config.b bVar2 = new com.tencent.guild.aio.msglist.holder.config.b(guildItemViewHolderDelegate2);
        sparseArray.put(5, bVar2);
        sparseArray.put(4, bVar2);
        com.tencent.guild.aio.msglist.holder.config.b bVar3 = new com.tencent.guild.aio.msglist.holder.config.b(new GuildItemViewHolderDelegate());
        sparseArray.put(3, bVar3);
        sparseArray.put(2, bVar3);
        GuildItemViewHolderDelegate guildItemViewHolderDelegate3 = new GuildItemViewHolderDelegate();
        guildItemViewHolderDelegate3.f(new Function1<View, com.tencent.guild.aio.msglist.holder.config.d>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$mixPic$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.guild.aio.msglist.holder.config.d invoke(@NotNull final View root) {
                Intrinsics.checkNotNullParameter(root, "root");
                return new GuildMsgItemComponentProvider(root, null, null, null, new Function1<View, com.tencent.guild.aio.msglist.holder.component.a>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$mixPic$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final com.tencent.guild.aio.msglist.holder.component.a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GuildMixPicBubbleComponent(root);
                    }
                }, null, null, null, null, null, null, 2030, null);
            }
        });
        com.tencent.guild.aio.msglist.holder.config.b bVar4 = new com.tencent.guild.aio.msglist.holder.config.b(guildItemViewHolderDelegate3);
        sparseArray.put(60, bVar4);
        sparseArray.put(61, bVar4);
        GuildItemViewHolderDelegate guildItemViewHolderDelegate4 = new GuildItemViewHolderDelegate();
        guildItemViewHolderDelegate4.f(new Function1<View, com.tencent.guild.aio.msglist.holder.config.d>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$mixVideo$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.guild.aio.msglist.holder.config.d invoke(@NotNull final View root) {
                Intrinsics.checkNotNullParameter(root, "root");
                return new GuildMsgItemComponentProvider(root, null, null, null, new Function1<View, com.tencent.guild.aio.msglist.holder.component.a>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$mixVideo$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final com.tencent.guild.aio.msglist.holder.component.a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GuildMixVideoBubbleComponent(root);
                    }
                }, null, null, null, null, null, null, 2030, null);
            }
        });
        com.tencent.guild.aio.msglist.holder.config.b bVar5 = new com.tencent.guild.aio.msglist.holder.config.b(guildItemViewHolderDelegate4);
        sparseArray.put(62, bVar5);
        sparseArray.put(63, bVar5);
        GuildItemViewHolderDelegate guildItemViewHolderDelegate5 = new GuildItemViewHolderDelegate();
        guildItemViewHolderDelegate5.f(new Function1<View, com.tencent.guild.aio.msglist.holder.config.d>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$video$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.guild.aio.msglist.holder.config.d invoke(@NotNull final View root) {
                Intrinsics.checkNotNullParameter(root, "root");
                return new GuildMsgItemComponentProvider(root, null, null, null, new Function1<View, com.tencent.guild.aio.msglist.holder.component.a>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$video$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final com.tencent.guild.aio.msglist.holder.component.a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GuildVideoContentComponent(root);
                    }
                }, null, null, null, null, null, null, 2030, null);
            }
        });
        guildItemViewHolderDelegate5.c(new Function1<BubbleMsgItemVBArgs, com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState>>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$video$1$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> invoke(@NotNull BubbleMsgItemVBArgs it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new com.tencent.guild.aio.msglist.video.b(it.getTemplateView(), it.getComponentProvider(), it.getFactoryProvider(), it.getViewType());
            }
        });
        com.tencent.guild.aio.msglist.holder.config.b bVar6 = new com.tencent.guild.aio.msglist.holder.config.b(guildItemViewHolderDelegate5);
        sparseArray.put(11, bVar6);
        sparseArray.put(10, bVar6);
        GuildItemViewHolderDelegate guildItemViewHolderDelegate6 = new GuildItemViewHolderDelegate();
        guildItemViewHolderDelegate6.f(new Function1<View, com.tencent.guild.aio.msglist.holder.config.d>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$file$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.guild.aio.msglist.holder.config.d invoke(@NotNull final View root) {
                Intrinsics.checkNotNullParameter(root, "root");
                return new GuildMsgItemComponentProvider(root, null, null, null, new Function1<View, com.tencent.guild.aio.msglist.holder.component.a>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$file$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final com.tencent.guild.aio.msglist.holder.component.a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GuildFileContentComponent(root);
                    }
                }, null, null, null, null, null, null, 2030, null);
            }
        });
        guildItemViewHolderDelegate6.d(new Function0<com.tencent.aio.api.list.b<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState>>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$file$1$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.aio.api.list.b<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> invoke() {
                return new com.tencent.guild.aio.msglist.holder.b();
            }
        });
        guildItemViewHolderDelegate6.c(new Function1<BubbleMsgItemVBArgs, com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState>>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$file$1$3
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> invoke(@NotNull BubbleMsgItemVBArgs it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new com.tencent.guild.aio.msglist.file.b(it.getTemplateView(), it.getComponentProvider(), it.getFactoryProvider(), it.getViewType());
            }
        });
        com.tencent.guild.aio.msglist.holder.config.b bVar7 = new com.tencent.guild.aio.msglist.holder.config.b(guildItemViewHolderDelegate6);
        sparseArray.put(9, bVar7);
        sparseArray.put(8, bVar7);
        GuildItemViewHolderDelegate guildItemViewHolderDelegate7 = new GuildItemViewHolderDelegate();
        guildItemViewHolderDelegate7.g(new Function0<g>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$1$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final g invoke() {
                return new eq0.e();
            }
        });
        guildItemViewHolderDelegate7.f(new Function1<View, com.tencent.guild.aio.msglist.holder.config.d>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$1$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.guild.aio.msglist.holder.config.d invoke(@NotNull final View root) {
                Intrinsics.checkNotNullParameter(root, "root");
                return new GuildMsgItemComponentProvider(root, null, null, null, new Function1<View, com.tencent.guild.aio.msglist.holder.component.a>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$1$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final com.tencent.guild.aio.msglist.holder.component.a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GuildCommonGrayTipsComponent(root);
                    }
                }, null, null, null, null, null, null, 2030, null);
            }
        });
        guildItemViewHolderDelegate7.c(new Function1<BubbleMsgItemVBArgs, com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState>>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$1$3
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> invoke(@NotNull BubbleMsgItemVBArgs it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new xp0.a(it.getTemplateView(), it.getComponentProvider(), it.getFactoryProvider(), it.getViewType());
            }
        });
        Unit unit = Unit.INSTANCE;
        sparseArray.put(56, new com.tencent.guild.aio.msglist.holder.config.b(guildItemViewHolderDelegate7));
        GuildItemViewHolderDelegate guildItemViewHolderDelegate8 = new GuildItemViewHolderDelegate();
        guildItemViewHolderDelegate8.f(new Function1<View, com.tencent.guild.aio.msglist.holder.config.d>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$giphy$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.guild.aio.msglist.holder.config.d invoke(@NotNull final View root) {
                Intrinsics.checkNotNullParameter(root, "root");
                return new GuildMsgItemComponentProvider(root, null, null, null, new Function1<View, com.tencent.guild.aio.msglist.holder.component.a>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$giphy$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final com.tencent.guild.aio.msglist.holder.component.a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GuildGiphyContentComponent(root);
                    }
                }, null, null, null, null, null, null, 2030, null);
            }
        });
        guildItemViewHolderDelegate8.c(new Function1<BubbleMsgItemVBArgs, com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState>>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$giphy$1$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> invoke(@NotNull BubbleMsgItemVBArgs it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new com.tencent.guild.aio.msglist.giphy.a(it.getTemplateView(), it.getComponentProvider(), it.getFactoryProvider(), it.getViewType());
            }
        });
        com.tencent.guild.aio.msglist.holder.config.b bVar8 = new com.tencent.guild.aio.msglist.holder.config.b(guildItemViewHolderDelegate8);
        sparseArray.put(22, bVar8);
        sparseArray.put(21, bVar8);
        GuildItemViewHolderDelegate guildItemViewHolderDelegate9 = new GuildItemViewHolderDelegate();
        guildItemViewHolderDelegate9.f(new Function1<View, com.tencent.guild.aio.msglist.holder.config.d>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$reply$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.guild.aio.msglist.holder.config.d invoke(@NotNull final View root) {
                Intrinsics.checkNotNullParameter(root, "root");
                return new GuildMsgItemComponentProvider(root, null, null, null, new Function1<View, com.tencent.guild.aio.msglist.holder.component.a>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$reply$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final com.tencent.guild.aio.msglist.holder.component.a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GuildTextContentComponent(root);
                    }
                }, null, null, new Function1<View, com.tencent.guild.aio.msglist.holder.component.a>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$reply$1$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final com.tencent.guild.aio.msglist.holder.component.a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GuildReplyComponent(root);
                    }
                }, null, null, null, WnsError.WNS_CODE_LOGIN_3GSVR_BUSY, null);
            }
        });
        guildItemViewHolderDelegate9.c(new Function1<BubbleMsgItemVBArgs, com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState>>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$reply$1$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> invoke(@NotNull BubbleMsgItemVBArgs it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new com.tencent.guild.aio.msglist.reply.d(it.getTemplateView(), it.getComponentProvider(), it.getFactoryProvider(), it.getViewType());
            }
        });
        guildItemViewHolderDelegate9.d(new Function0<com.tencent.aio.api.list.b<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState>>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$reply$1$3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.aio.api.list.b<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> invoke() {
                return new com.tencent.guild.aio.msglist.reply.b();
            }
        });
        com.tencent.guild.aio.msglist.holder.config.b bVar9 = new com.tencent.guild.aio.msglist.holder.config.b(guildItemViewHolderDelegate9);
        sparseArray.put(24, bVar9);
        sparseArray.put(23, bVar9);
        GuildItemViewHolderDelegate guildItemViewHolderDelegate10 = new GuildItemViewHolderDelegate();
        guildItemViewHolderDelegate10.f(new Function1<View, com.tencent.guild.aio.msglist.holder.config.d>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$markdown$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.guild.aio.msglist.holder.config.d invoke(@NotNull final View root) {
                Intrinsics.checkNotNullParameter(root, "root");
                return new GuildMsgItemComponentProvider(root, null, null, null, new Function1<View, com.tencent.guild.aio.msglist.holder.component.a>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$markdown$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final com.tencent.guild.aio.msglist.holder.component.a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GuildMarkDownContentComponent(root);
                    }
                }, null, null, null, null, null, null, 2030, null);
            }
        });
        com.tencent.guild.aio.msglist.holder.config.b bVar10 = new com.tencent.guild.aio.msglist.holder.config.b(guildItemViewHolderDelegate10);
        sparseArray.put(26, bVar10);
        sparseArray.put(25, bVar10);
        GuildItemViewHolderDelegate guildItemViewHolderDelegate11 = new GuildItemViewHolderDelegate();
        guildItemViewHolderDelegate11.f(new Function1<View, com.tencent.guild.aio.msglist.holder.config.d>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$ark$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.guild.aio.msglist.holder.config.d invoke(@NotNull final View root) {
                Intrinsics.checkNotNullParameter(root, "root");
                return new GuildMsgItemComponentProvider(root, null, null, null, new Function1<View, com.tencent.guild.aio.msglist.holder.component.a>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$ark$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final com.tencent.guild.aio.msglist.holder.component.a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GuildArkComponent(root);
                    }
                }, null, null, null, null, null, null, 2030, null);
            }
        });
        com.tencent.guild.aio.msglist.holder.config.b bVar11 = new com.tencent.guild.aio.msglist.holder.config.b(guildItemViewHolderDelegate11);
        sparseArray.put(34, bVar11);
        sparseArray.put(35, bVar11);
        GuildItemViewHolderDelegate guildItemViewHolderDelegate12 = new GuildItemViewHolderDelegate();
        guildItemViewHolderDelegate12.f(new Function1<View, com.tencent.guild.aio.msglist.holder.config.d>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$marketFace$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.guild.aio.msglist.holder.config.d invoke(@NotNull final View root) {
                Intrinsics.checkNotNullParameter(root, "root");
                return new GuildMsgItemComponentProvider(root, null, null, null, new Function1<View, com.tencent.guild.aio.msglist.holder.component.a>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$marketFace$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final com.tencent.guild.aio.msglist.holder.component.a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GuildMarketFaceComponent(root);
                    }
                }, null, null, null, null, null, null, 2030, null);
            }
        });
        com.tencent.guild.aio.msglist.holder.config.b bVar12 = new com.tencent.guild.aio.msglist.holder.config.b(guildItemViewHolderDelegate12);
        sparseArray.put(37, bVar12);
        sparseArray.put(36, bVar12);
        GuildItemViewHolderDelegate guildItemViewHolderDelegate13 = new GuildItemViewHolderDelegate();
        guildItemViewHolderDelegate13.f(new Function1<View, com.tencent.guild.aio.msglist.holder.config.d>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$welcomeMsg$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.guild.aio.msglist.holder.config.d invoke(@NotNull final View root) {
                Intrinsics.checkNotNullParameter(root, "root");
                return new GuildMsgItemComponentProvider(root, new Function1<View, com.tencent.guild.aio.msglist.holder.component.a>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$welcomeMsg$1$1.1
                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final com.tencent.guild.aio.msglist.holder.component.a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return null;
                    }
                }, new Function1<View, com.tencent.guild.aio.msglist.holder.component.a>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$welcomeMsg$1$1.2
                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final com.tencent.guild.aio.msglist.holder.component.a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return null;
                    }
                }, new Function1<View, com.tencent.guild.aio.msglist.holder.component.a>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$welcomeMsg$1$1.3
                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final com.tencent.guild.aio.msglist.holder.component.a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return null;
                    }
                }, new Function1<View, com.tencent.guild.aio.msglist.holder.component.a>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$welcomeMsg$1$1.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final com.tencent.guild.aio.msglist.holder.component.a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GuildDirectWelcomeRobotComponent(root);
                    }
                }, new Function1<View, com.tencent.guild.aio.msglist.holder.component.a>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$welcomeMsg$1$1.5
                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final com.tencent.guild.aio.msglist.holder.component.a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return null;
                    }
                }, new Function1<View, com.tencent.guild.aio.msglist.holder.component.a>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$welcomeMsg$1$1.6
                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final com.tencent.guild.aio.msglist.holder.component.a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return null;
                    }
                }, new Function1<View, com.tencent.guild.aio.msglist.holder.component.a>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$welcomeMsg$1$1.7
                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final com.tencent.guild.aio.msglist.holder.component.a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return null;
                    }
                }, new Function1<View, com.tencent.guild.aio.msglist.holder.component.a>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$welcomeMsg$1$1.8
                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final com.tencent.guild.aio.msglist.holder.component.a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return null;
                    }
                }, new Function1<View, com.tencent.guild.aio.msglist.holder.component.a>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$welcomeMsg$1$1.9
                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final com.tencent.guild.aio.msglist.holder.component.a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return null;
                    }
                }, new Function1<View, com.tencent.guild.aio.msglist.holder.component.a>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$welcomeMsg$1$1.10
                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final com.tencent.guild.aio.msglist.holder.component.a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return null;
                    }
                });
            }
        });
        guildItemViewHolderDelegate13.g(new Function0<g>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$welcomeMsg$1$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final g invoke() {
                return new eq0.d();
            }
        });
        sparseArray.put(71, new com.tencent.guild.aio.msglist.holder.config.b(guildItemViewHolderDelegate13));
        GuildItemViewHolderDelegate guildItemViewHolderDelegate14 = new GuildItemViewHolderDelegate();
        guildItemViewHolderDelegate14.g(new Function0<g>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$wallet$1$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final g invoke() {
                return new com.tencent.guild.aio.msglist.wallet.c();
            }
        });
        guildItemViewHolderDelegate14.f(new Function1<View, com.tencent.guild.aio.msglist.holder.config.d>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$wallet$1$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.guild.aio.msglist.holder.config.d invoke(@NotNull final View root) {
                Intrinsics.checkNotNullParameter(root, "root");
                return new GuildMsgItemComponentProvider(root, null, null, null, new Function1<View, com.tencent.guild.aio.msglist.holder.component.a>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$wallet$1$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final com.tencent.guild.aio.msglist.holder.component.a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GuildWalletComponent(root);
                    }
                }, null, null, null, null, null, null, 2030, null);
            }
        });
        com.tencent.guild.aio.msglist.holder.config.b bVar13 = new com.tencent.guild.aio.msglist.holder.config.b(guildItemViewHolderDelegate14);
        sparseArray.put(43, bVar13);
        sparseArray.put(42, bVar13);
        GuildItemViewHolderDelegate guildItemViewHolderDelegate15 = new GuildItemViewHolderDelegate();
        guildItemViewHolderDelegate15.g(new Function0<g>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$2$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final g invoke() {
                return new eq0.e();
            }
        });
        guildItemViewHolderDelegate15.f(new Function1<View, com.tencent.guild.aio.msglist.holder.config.d>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$2$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.guild.aio.msglist.holder.config.d invoke(@NotNull final View root) {
                Intrinsics.checkNotNullParameter(root, "root");
                return new GuildMsgItemComponentProvider(root, null, null, null, new Function1<View, com.tencent.guild.aio.msglist.holder.component.a>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$2$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final com.tencent.guild.aio.msglist.holder.component.a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GuildRevokeGrayTipsComponent(root);
                    }
                }, null, null, null, null, null, null, 2030, null);
            }
        });
        guildItemViewHolderDelegate15.c(new Function1<BubbleMsgItemVBArgs, com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState>>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$2$3
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> invoke(@NotNull BubbleMsgItemVBArgs it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new xp0.a(it.getTemplateView(), it.getComponentProvider(), it.getFactoryProvider(), it.getViewType());
            }
        });
        sparseArray.put(50, new com.tencent.guild.aio.msglist.holder.config.b(guildItemViewHolderDelegate15));
        GuildItemViewHolderDelegate guildItemViewHolderDelegate16 = new GuildItemViewHolderDelegate();
        guildItemViewHolderDelegate16.g(new Function0<g>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$3$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final g invoke() {
                return new eq0.e();
            }
        });
        guildItemViewHolderDelegate16.f(new Function1<View, com.tencent.guild.aio.msglist.holder.config.d>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$3$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.guild.aio.msglist.holder.config.d invoke(@NotNull final View root) {
                Intrinsics.checkNotNullParameter(root, "root");
                return new GuildMsgItemComponentProvider(root, null, null, null, new Function1<View, com.tencent.guild.aio.msglist.holder.component.a>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$3$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final com.tencent.guild.aio.msglist.holder.component.a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GuildRobotMsgLimitGrayTipsComponent(root);
                    }
                }, null, null, null, null, null, null, 2030, null);
            }
        });
        guildItemViewHolderDelegate16.c(new Function1<BubbleMsgItemVBArgs, com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState>>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$3$3
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> invoke(@NotNull BubbleMsgItemVBArgs it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new xp0.a(it.getTemplateView(), it.getComponentProvider(), it.getFactoryProvider(), it.getViewType());
            }
        });
        sparseArray.put(54, new com.tencent.guild.aio.msglist.holder.config.b(guildItemViewHolderDelegate16));
        GuildItemViewHolderDelegate guildItemViewHolderDelegate17 = new GuildItemViewHolderDelegate();
        guildItemViewHolderDelegate17.g(new Function0<g>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$4$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final g invoke() {
                return new eq0.e();
            }
        });
        guildItemViewHolderDelegate17.f(new Function1<View, com.tencent.guild.aio.msglist.holder.config.d>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$4$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.guild.aio.msglist.holder.config.d invoke(@NotNull final View root) {
                Intrinsics.checkNotNullParameter(root, "root");
                return new GuildMsgItemComponentProvider(root, null, null, null, new Function1<View, com.tencent.guild.aio.msglist.holder.component.a>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$4$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final com.tencent.guild.aio.msglist.holder.component.a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GuildBlackRobotGrayTipsComponent(root);
                    }
                }, null, null, null, null, null, null, 2030, null);
            }
        });
        guildItemViewHolderDelegate17.c(new Function1<BubbleMsgItemVBArgs, com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState>>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$4$3
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> invoke(@NotNull BubbleMsgItemVBArgs it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new xp0.a(it.getTemplateView(), it.getComponentProvider(), it.getFactoryProvider(), it.getViewType());
            }
        });
        sparseArray.put(55, new com.tencent.guild.aio.msglist.holder.config.b(guildItemViewHolderDelegate17));
        GuildItemViewHolderDelegate guildItemViewHolderDelegate18 = new GuildItemViewHolderDelegate();
        guildItemViewHolderDelegate18.f(new Function1<View, com.tencent.guild.aio.msglist.holder.config.d>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$walletUnSupport$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final com.tencent.guild.aio.msglist.holder.config.d invoke(@NotNull final View root) {
                Intrinsics.checkNotNullParameter(root, "root");
                return new GuildMsgItemComponentProvider(root, null, null, null, new Function1<View, com.tencent.guild.aio.msglist.holder.component.a>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$mItemViewHolderFactoryArray$1$walletUnSupport$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final com.tencent.guild.aio.msglist.holder.component.a invoke(@NotNull View it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new GuildWalletUnSupportComponent(root);
                    }
                }, null, null, null, null, null, null, 2030, null);
            }
        });
        com.tencent.guild.aio.msglist.holder.config.b bVar14 = new com.tencent.guild.aio.msglist.holder.config.b(guildItemViewHolderDelegate18);
        sparseArray.put(45, bVar14);
        sparseArray.put(44, bVar14);
        mItemViewHolderFactoryArray = sparseArray;
    }

    GuildDirectItemViewHolderFactoryProvider() {
    }

    @Override // com.tencent.guild.aio.msglist.holder.config.c
    @NotNull
    public v a(int viewType) {
        v vVar = mItemViewHolderFactoryArray.get(viewType);
        if (vVar == null) {
            GuildItemViewHolderDelegate guildItemViewHolderDelegate = new GuildItemViewHolderDelegate();
            guildItemViewHolderDelegate.f(new Function1<View, com.tencent.guild.aio.msglist.holder.config.d>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$getItemViewHolderFactory$1$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final com.tencent.guild.aio.msglist.holder.config.d invoke(@NotNull final View root) {
                    Intrinsics.checkNotNullParameter(root, "root");
                    return new GuildMsgItemComponentProvider(root, null, null, null, new Function1<View, com.tencent.guild.aio.msglist.holder.component.a>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$getItemViewHolderFactory$1$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        @Nullable
                        public final com.tencent.guild.aio.msglist.holder.component.a invoke(@NotNull View it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            return new GuildUnsupportedMsgContentComponent(root);
                        }
                    }, null, null, null, null, null, null, 2030, null);
                }
            });
            guildItemViewHolderDelegate.g(new Function0<g>() { // from class: com.tencent.qqguild.directmessage.aio.GuildDirectItemViewHolderFactoryProvider$getItemViewHolderFactory$1$2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final g invoke() {
                    return new eq0.e();
                }
            });
            return new com.tencent.guild.aio.msglist.holder.config.b(guildItemViewHolderDelegate);
        }
        return vVar;
    }
}
