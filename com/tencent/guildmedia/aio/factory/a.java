package com.tencent.guildmedia.aio.factory;

import android.content.Context;
import android.util.SparseArray;
import at.e;
import com.tencent.aio.api.factory.f;
import com.tencent.aio.api.factory.g;
import com.tencent.aio.api.factory.j;
import com.tencent.aio.api.help.d;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.aio.base.mvi.part.TitleUIState;
import com.tencent.aio.base.mvi.part.TopTipViewState;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB;
import com.tencent.guild.aio.component.combinestyle.af;
import com.tencent.guild.aio.msglist.holder.c;
import com.tencent.guild.api.appsetting.IAppSetting;
import com.tencent.guild.api.msg.service.ChannelAIOMsgService;
import com.tencent.guildmedia.aio.input.GuildMediaAioInputContainerVB;
import com.tencent.guildmedia.aio.msglist.GuildMediaItemViewHolderFactoryProvider;
import com.tencent.guildmedia.aio.msglist.list.GuildMediaMsgListDataVB;
import com.tencent.guildmedia.utils.GuildMediaLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.mvi.MviUIState;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u000e\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020 0\u001f\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016R\u001f\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00188\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/guildmedia/aio/factory/a;", "Lcom/tencent/aio/api/factory/g;", "Lcom/tencent/aio/msgservice/a;", "buildAIOMsgService", "Lys/a;", "buildActivityJumpService", "Lcom/tencent/aio/api/help/d;", "buildHelperProvider", "Lcom/tencent/aio/api/factory/j;", "buildMsgLevel", "Lcom/tencent/aio/api/factory/d;", "buildReserve1Level", "Lcom/tencent/aio/api/factory/f;", "buildBusinessLevel", "Lcom/tencent/aio/api/factory/e;", "buildReserve2Level", "Ldt/b;", "getBottomDialogFactory", "Lcom/tencent/aio/part/root/panel/mvx/config/a;", "getPanelFactory", "", "isDebugModel", "Lcom/tencent/aio/base/log/f;", "buildAIOLogger", "Ljava/lang/ref/WeakReference;", "Let0/a;", "d", "Ljava/lang/ref/WeakReference;", "a", "()Ljava/lang/ref/WeakReference;", "aioListenerRef", "Landroid/util/SparseArray;", "Lcom/tencent/guild/aio/component/combinestyle/af;", "e", "Landroid/util/SparseArray;", "b", "()Landroid/util/SparseArray;", "components", "<init>", "(Ljava/lang/ref/WeakReference;Landroid/util/SparseArray;)V", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a implements g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<et0.a> aioListenerRef;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SparseArray<af> components;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guildmedia/aio/factory/a$a", "Lcom/tencent/aio/api/factory/f;", "Lcom/tencent/aio/base/mvvm/a;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "buildInputVB", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guildmedia.aio.factory.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1230a implements f {
        C1230a() {
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
        @NotNull
        public com.tencent.aio.base.mvvm.a<? extends at.a, ? extends InputUIState> buildInputVB() {
            return new GuildMediaAioInputContainerVB(a.this.a());
        }

        @Override // com.tencent.aio.api.factory.f
        @Nullable
        public com.tencent.aio.base.mvvm.a<Object, Object> buildShortcutBarVB() {
            return f.a.d(this);
        }

        @Override // com.tencent.aio.api.factory.f
        @Nullable
        public com.tencent.aio.base.mvvm.a<Object, ? extends TitleUIState> buildTitleVB() {
            return f.a.e(this);
        }

        @Override // com.tencent.aio.api.factory.f
        @Nullable
        public com.tencent.aio.base.mvvm.a<? extends e, ? extends TopTipViewState> buildTopTipVB() {
            return f.a.f(this);
        }

        @Override // com.tencent.aio.api.factory.h
        @Nullable
        public com.tencent.aio.api.b getLayoutDelegate() {
            return f.a.g(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0005\u0012\u0006\b\u0001\u0012\u00020\u00060\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/guildmedia/aio/factory/a$b", "Lcom/tencent/aio/api/factory/j;", "Lcom/tencent/aio/api/list/h;", h.F, "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/AbsMsgListVB;", "Lat/b;", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", "g", "Lcom/tencent/aio/api/refreshLoad/e;", "f", "Lcom/tencent/aio/api/b;", "getLayoutDelegate", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements j {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildMediaMsgListDataVB f112999b;

        b(GuildMediaMsgListDataVB guildMediaMsgListDataVB) {
            this.f112999b = guildMediaMsgListDataVB;
        }

        @Override // com.tencent.aio.api.factory.j
        @Nullable
        public com.tencent.aio.base.mvvm.a<Object, Object> a() {
            return j.a.b(this);
        }

        @Override // com.tencent.aio.api.factory.j
        public int c(@NotNull Context context) {
            return j.a.d(this, context);
        }

        @Override // com.tencent.aio.api.factory.j
        @Nullable
        public com.tencent.aio.base.mvvm.a<Object, Object> d() {
            return j.a.a(this);
        }

        @Override // com.tencent.aio.api.factory.j
        public int e(@NotNull Context context) {
            return j.a.c(this, context);
        }

        @Override // com.tencent.aio.api.factory.j
        @NotNull
        public com.tencent.aio.api.refreshLoad.e f() {
            return com.tencent.guild.aio.factory.e.f110654a;
        }

        @Override // com.tencent.aio.api.factory.j
        @NotNull
        /* renamed from: g */
        public AbsMsgListVB<? extends at.b, ? extends MsgListUiState> getViewBinder() {
            return this.f112999b;
        }

        @Override // com.tencent.aio.api.factory.h
        @NotNull
        public com.tencent.aio.api.b getLayoutDelegate() {
            return new com.tencent.guildmedia.aio.msglist.a(this.f112999b, a.this.a().get());
        }

        @Override // com.tencent.aio.api.factory.j
        @NotNull
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public com.tencent.aio.api.list.h b() {
            GuildMediaItemViewHolderFactoryProvider guildMediaItemViewHolderFactoryProvider = GuildMediaItemViewHolderFactoryProvider.f113065a;
            guildMediaItemViewHolderFactoryProvider.f(a.this.b());
            return new c(guildMediaItemViewHolderFactoryProvider);
        }
    }

    public a(@NotNull WeakReference<et0.a> aioListenerRef, @NotNull SparseArray<af> components) {
        Intrinsics.checkNotNullParameter(aioListenerRef, "aioListenerRef");
        Intrinsics.checkNotNullParameter(components, "components");
        this.aioListenerRef = aioListenerRef;
        this.components = components;
    }

    @NotNull
    public final WeakReference<et0.a> a() {
        return this.aioListenerRef;
    }

    @NotNull
    public final SparseArray<af> b() {
        return this.components;
    }

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    public com.tencent.aio.base.log.f buildAIOLogger() {
        return new GuildMediaLogUtil();
    }

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    public com.tencent.aio.msgservice.a buildAIOMsgService() {
        return ChannelAIOMsgService.f112613a;
    }

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    public ys.a buildActivityJumpService() {
        return zn0.a.f452788a;
    }

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    public f buildBusinessLevel() {
        return new C1230a();
    }

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    public com.tencent.aio.api.factory.a buildFullBackgroundLevel() {
        return g.a.c(this);
    }

    @Override // com.tencent.aio.api.help.c
    @NotNull
    public d buildHelperProvider() {
        return new GuildMediaHelperProvider();
    }

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    public j buildMsgLevel() {
        return new b(new GuildMediaMsgListDataVB(this.aioListenerRef.get()));
    }

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    public com.tencent.aio.api.factory.c buildPanelArea() {
        return g.a.d(this);
    }

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    public com.tencent.aio.api.factory.d buildReserve1Level() {
        return null;
    }

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    public com.tencent.aio.api.factory.e buildReserve2Level() {
        return null;
    }

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    public dt.b getBottomDialogFactory() {
        return null;
    }

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    public com.tencent.aio.part.root.panel.mvx.config.a getPanelFactory() {
        return new bt0.a();
    }

    @Override // com.tencent.aio.api.factory.g
    public boolean isDebugModel() {
        return ((IAppSetting) QRoute.api(IAppSetting.class)).debug();
    }
}
