package com.tencent.qqguild.directmessage.aio;

import android.content.Context;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import com.tencent.aio.api.factory.f;
import com.tencent.aio.api.factory.g;
import com.tencent.aio.api.factory.j;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo;
import com.tencent.guild.aio.background.GuildFullBackgroundVB;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListDataVB;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListDataVM;
import com.tencent.guild.aio.factory.business.holder.msglist.data.guild.GuildMsgListRepo;
import com.tencent.guild.aio.util.ex.FromScene;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqguild.directmessage.aio.a;
import com.tencent.qqguild.directmessage.aio.helper.GuildDirectHelperProvider;
import com.tencent.qqguild.directmessage.aio.input.container.InputContainerViewBinder;
import com.tencent.qqguild.directmessage.aio.repository.RobotMsgListRepoDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/a;", "Lcom/tencent/aio/api/factory/g;", "Lcom/tencent/aio/api/factory/f;", "buildBusinessLevel", "Lcom/tencent/aio/api/factory/j;", "buildMsgLevel", "Lcom/tencent/aio/part/root/panel/mvx/config/a;", "getPanelFactory", "", "isDebugModel", "Lcom/tencent/aio/msgservice/a;", "buildAIOMsgService", "Lys/a;", "buildActivityJumpService", "Lcom/tencent/qqguild/directmessage/aio/helper/GuildDirectHelperProvider;", "b", "Lcom/tencent/aio/api/factory/e;", "buildReserve2Level", "Ldt/b;", "getBottomDialogFactory", "Lcom/tencent/aio/api/factory/a;", "buildFullBackgroundLevel", "Lcom/tencent/guild/aio/factory/a;", "d", "Lcom/tencent/guild/aio/factory/a;", "defaultFactory", "e", "Lcom/tencent/aio/api/factory/j;", "msgLevel", "<init>", "()V", "f", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a implements g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.guild.aio.factory.a defaultFactory;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private j msgLevel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqguild/directmessage/aio/a$b", "Lcom/tencent/aio/api/factory/f;", "Lcom/tencent/qqguild/directmessage/aio/input/container/InputContainerViewBinder;", h.F, "Lcom/tencent/qqguild/directmessage/aio/title/e;", "i", "Ltq0/e;", "j", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements f {
        b() {
        }

        @Override // com.tencent.aio.api.factory.f
        @Nullable
        public com.tencent.aio.base.mvvm.a<Object, Object> buildBottomBarVB() {
            return f.a.a(this);
        }

        @Override // com.tencent.aio.api.factory.f
        @Nullable
        public List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> buildBusinessVB() {
            return f.a.b(this);
        }

        @Override // com.tencent.aio.api.factory.f
        @Nullable
        public com.tencent.aio.base.mvvm.a<Object, Object> buildShortcutBarVB() {
            return f.a.d(this);
        }

        @Override // com.tencent.aio.api.factory.h
        @Nullable
        public com.tencent.aio.api.b getLayoutDelegate() {
            return f.a.g(this);
        }

        @Override // com.tencent.aio.api.factory.f
        @NotNull
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public InputContainerViewBinder buildInputVB() {
            return new InputContainerViewBinder();
        }

        @Override // com.tencent.aio.api.factory.f
        @NotNull
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public com.tencent.qqguild.directmessage.aio.title.e buildTitleVB() {
            return new com.tencent.qqguild.directmessage.aio.title.e();
        }

        @Override // com.tencent.aio.api.factory.f
        @NotNull
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public tq0.e buildTopTipVB() {
            return new tq0.e();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqguild/directmessage/aio/a$c", "Lcom/tencent/aio/api/factory/a;", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class c implements com.tencent.aio.api.factory.a {
        c() {
        }

        @Override // com.tencent.aio.api.factory.a
        @NotNull
        public com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> a() {
            return new GuildFullBackgroundVB(false, 1, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000=\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001b\u0010\u0004\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0002H\u0096\u0001J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J\u001b\u0010\u0007\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0002H\u0096\u0001J\u0011\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0096\u0001J\u0011\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0096\u0001J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096\u0001J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016\u00a8\u0006\u0013"}, d2 = {"com/tencent/qqguild/directmessage/aio/a$d", "Lcom/tencent/aio/api/factory/j;", "Lcom/tencent/aio/base/mvvm/a;", "", "d", "Lcom/tencent/aio/api/refreshLoad/e;", "f", "a", "Landroid/content/Context;", "context", "", "e", "c", "Lcom/tencent/aio/api/b;", "getLayoutDelegate", "Lcom/tencent/guild/aio/factory/business/holder/msglist/GuildMsgListDataVB;", "l", "Lcom/tencent/guild/aio/msglist/holder/c;", "k", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class d implements j {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ j f345000a;

        d(a aVar) {
            this.f345000a = aVar.msgLevel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final com.tencent.aio.base.mvvm.b m() {
            return new GuildMsgListDataVM(new GuildMsgListDataVM.c() { // from class: com.tencent.qqguild.directmessage.aio.c
                @Override // com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListDataVM.c
                public final MsgListRepo a(com.tencent.aio.api.runtime.a aVar, CoroutineScope coroutineScope) {
                    MsgListRepo n3;
                    n3 = a.d.n(aVar, coroutineScope);
                    return n3;
                }
            }, new GuildMsgListDataVM.a() { // from class: com.tencent.qqguild.directmessage.aio.d
                @Override // com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListDataVM.a
                public final Bundle a(com.tencent.aio.api.runtime.a aVar) {
                    Bundle o16;
                    o16 = a.d.o(aVar);
                    return o16;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final MsgListRepo n(com.tencent.aio.api.runtime.a aioContext, CoroutineScope coroutineScope) {
            com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.f aVar;
            Intrinsics.checkNotNullParameter(aioContext, "aioContext");
            Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
            GuildMsgListRepo guildMsgListRepo = new GuildMsgListRepo(aioContext, coroutineScope);
            if (com.tencent.guild.aio.util.ex.a.i(aioContext)) {
                aVar = new RobotMsgListRepoDelegate(guildMsgListRepo);
            } else {
                aVar = new com.tencent.qqguild.directmessage.aio.repository.a(guildMsgListRepo);
            }
            guildMsgListRepo.Y(aVar);
            return guildMsgListRepo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Bundle o(com.tencent.aio.api.runtime.a aioContext) {
            FromScene fromScene;
            Intrinsics.checkNotNullParameter(aioContext, "aioContext");
            Pair[] pairArr = new Pair[1];
            if (com.tencent.guild.aio.util.ex.a.a(aioContext)) {
                fromScene = FromScene.JUBAO;
            } else {
                fromScene = FromScene.DIRECT;
            }
            pairArr[0] = TuplesKt.to("AIOParam_FromScene", Integer.valueOf(fromScene.ordinal()));
            return BundleKt.bundleOf(pairArr);
        }

        @Override // com.tencent.aio.api.factory.j
        @Nullable
        public com.tencent.aio.base.mvvm.a<Object, Object> a() {
            return this.f345000a.a();
        }

        @Override // com.tencent.aio.api.factory.j
        public int c(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return this.f345000a.c(context);
        }

        @Override // com.tencent.aio.api.factory.j
        @Nullable
        public com.tencent.aio.base.mvvm.a<Object, Object> d() {
            return this.f345000a.d();
        }

        @Override // com.tencent.aio.api.factory.j
        public int e(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return this.f345000a.e(context);
        }

        @Override // com.tencent.aio.api.factory.j
        @Nullable
        public com.tencent.aio.api.refreshLoad.e f() {
            return this.f345000a.f();
        }

        @Override // com.tencent.aio.api.factory.h
        @Nullable
        public com.tencent.aio.api.b getLayoutDelegate() {
            return this.f345000a.getLayoutDelegate();
        }

        @Override // com.tencent.aio.api.factory.j
        @NotNull
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public com.tencent.guild.aio.msglist.holder.c b() {
            return new com.tencent.guild.aio.msglist.holder.c(GuildDirectItemViewHolderFactoryProvider.f344995a);
        }

        @Override // com.tencent.aio.api.factory.j
        @NotNull
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public GuildMsgListDataVB g() {
            return new GuildMsgListDataVB(new GuildMsgListDataVB.b() { // from class: com.tencent.qqguild.directmessage.aio.b
                @Override // com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListDataVB.b
                public final com.tencent.aio.base.mvvm.b provide() {
                    com.tencent.aio.base.mvvm.b m3;
                    m3 = a.d.m();
                    return m3;
                }
            });
        }
    }

    public a() {
        com.tencent.guild.aio.factory.a aVar = new com.tencent.guild.aio.factory.a();
        this.defaultFactory = aVar;
        this.msgLevel = aVar.buildMsgLevel();
    }

    @Override // com.tencent.aio.api.help.c
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public GuildDirectHelperProvider buildHelperProvider() {
        return new GuildDirectHelperProvider();
    }

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    public com.tencent.aio.base.log.f buildAIOLogger() {
        return g.a.a(this);
    }

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    public com.tencent.aio.msgservice.a buildAIOMsgService() {
        return this.defaultFactory.buildAIOMsgService();
    }

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    public ys.a buildActivityJumpService() {
        return this.defaultFactory.buildActivityJumpService();
    }

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    public f buildBusinessLevel() {
        return new b();
    }

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    public com.tencent.aio.api.factory.a buildFullBackgroundLevel() {
        return new c();
    }

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    public j buildMsgLevel() {
        return new d(this);
    }

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    public com.tencent.aio.api.factory.c buildPanelArea() {
        return g.a.d(this);
    }

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    public com.tencent.aio.api.factory.d buildReserve1Level() {
        return g.a.e(this);
    }

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    public com.tencent.aio.api.factory.e buildReserve2Level() {
        return this.defaultFactory.buildReserve2Level();
    }

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    public dt.b getBottomDialogFactory() {
        return this.defaultFactory.getBottomDialogFactory();
    }

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    public com.tencent.aio.part.root.panel.mvx.config.a getPanelFactory() {
        return new e();
    }

    @Override // com.tencent.aio.api.factory.g
    public boolean isDebugModel() {
        return this.defaultFactory.isDebugModel();
    }
}
