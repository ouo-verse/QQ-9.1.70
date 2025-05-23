package com.tencent.guildlive.aio.factory;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import at.d;
import at.e;
import com.tencent.aio.api.factory.f;
import com.tencent.aio.api.factory.g;
import com.tencent.aio.api.factory.j;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.aio.base.mvi.part.Reserve2UIState;
import com.tencent.aio.base.mvi.part.TopTipViewState;
import com.tencent.guild.aio.util.m;
import com.tencent.guild.api.appsetting.IAppSetting;
import com.tencent.guild.api.msg.service.ChannelAIOMsgService;
import com.tencent.guildlive.aio.excellentdetail.GuildLiveAnnounceDetailVHFactoryProvider;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mvi.base.mvi.MviUIState;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/guildlive/aio/factory/b;", "Lcom/tencent/aio/api/factory/g;", "Lcom/tencent/guild/api/msg/service/ChannelAIOMsgService;", "b", "Lzn0/a;", "c", "Lcom/tencent/aio/api/factory/f;", "buildBusinessLevel", "Lcom/tencent/guildlive/aio/factory/GuildLiveAnnounceDetailHelperProvider;", "d", "Lcom/tencent/aio/api/factory/j;", "buildMsgLevel", "Lcom/tencent/aio/api/factory/e;", "buildReserve2Level", "Lkq0/a;", "e", "", "isDebugModel", "Lcom/tencent/guild/aio/util/m;", "a", "<init>", "()V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b implements g {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004*\u0002\u0000\u0004\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"com/tencent/guildlive/aio/factory/b$a", "Lcom/tencent/aio/api/factory/f;", "Lds0/c;", "i", "com/tencent/guildlive/aio/factory/b$a$a", h.F, "()Lcom/tencent/guildlive/aio/factory/b$a$a;", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a implements f {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/guildlive/aio/factory/b$a$a", "Lcom/tencent/aio/base/mvvm/a;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.guildlive.aio.factory.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C1222a extends com.tencent.aio.base.mvvm.a<at.a, InputUIState> {
            C1222a() {
            }

            @Override // com.tencent.mvi.mvvm.b
            @NotNull
            public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
                Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
                return new View(createViewParams.a());
            }
        }

        a() {
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

        @Override // com.tencent.aio.api.factory.f
        @NotNull
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public C1222a buildInputVB() {
            return new C1222a();
        }

        @Override // com.tencent.aio.api.factory.f
        @NotNull
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public ds0.c buildTitleVB() {
            return new ds0.c();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/guildlive/aio/factory/b$b", "Lcom/tencent/aio/api/factory/j;", "Lcom/tencent/guild/aio/msglist/holder/c;", h.F, "Lcom/tencent/guildlive/aio/excellentdetail/msglist/a;", "i", "", "j", "Landroid/content/Context;", "context", "", "e", "c", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guildlive.aio.factory.b$b, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1223b implements j {
        C1223b() {
        }

        @Override // com.tencent.aio.api.factory.j
        @Nullable
        public com.tencent.aio.base.mvvm.a<Object, Object> a() {
            return j.a.b(this);
        }

        @Override // com.tencent.aio.api.factory.j
        public int c(@NotNull Context context) {
            Integer num;
            int i3;
            Intrinsics.checkNotNullParameter(context, "context");
            Resources resources = context.getResources();
            Integer num2 = null;
            if (resources != null) {
                num = Integer.valueOf(resources.getIdentifier("status_bar_height", "dimen", "android"));
            } else {
                num = null;
            }
            if (num != null && num.intValue() > 0) {
                Resources resources2 = context.getResources();
                if (resources2 != null) {
                    num2 = Integer.valueOf(resources2.getDimensionPixelSize(num.intValue()));
                }
                Intrinsics.checkNotNull(num2);
                i3 = num2.intValue();
            } else {
                i3 = 0;
            }
            return ViewUtils.dip2px(49.0f) + i3;
        }

        @Override // com.tencent.aio.api.factory.j
        @Nullable
        public com.tencent.aio.base.mvvm.a<Object, Object> d() {
            return j.a.a(this);
        }

        @Override // com.tencent.aio.api.factory.j
        public int e(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return 0;
        }

        @Override // com.tencent.aio.api.factory.j
        public /* bridge */ /* synthetic */ com.tencent.aio.api.refreshLoad.e f() {
            return (com.tencent.aio.api.refreshLoad.e) j();
        }

        @Override // com.tencent.aio.api.factory.h
        @Nullable
        public com.tencent.aio.api.b getLayoutDelegate() {
            return j.a.e(this);
        }

        @Override // com.tencent.aio.api.factory.j
        @NotNull
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public com.tencent.guild.aio.msglist.holder.c b() {
            return new com.tencent.guild.aio.msglist.holder.c(GuildLiveAnnounceDetailVHFactoryProvider.f112684a);
        }

        @Override // com.tencent.aio.api.factory.j
        @NotNull
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public com.tencent.guildlive.aio.excellentdetail.msglist.a getViewBinder() {
            return new com.tencent.guildlive.aio.excellentdetail.msglist.a();
        }

        @Nullable
        public Void j() {
            return null;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guildlive/aio/factory/b$c", "Lcom/tencent/aio/api/factory/e;", "Lcom/tencent/aio/base/mvvm/a;", "Lat/d;", "Lcom/tencent/aio/base/mvi/part/Reserve2UIState;", "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c implements com.tencent.aio.api.factory.e {
        c() {
        }

        @Override // com.tencent.aio.api.factory.e
        @NotNull
        public com.tencent.aio.base.mvvm.a<? extends d, ? extends Reserve2UIState> a() {
            return new os0.a(null, Boolean.TRUE, 1, 0 == true ? 1 : 0);
        }
    }

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public m buildAIOLogger() {
        return new m();
    }

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ChannelAIOMsgService buildAIOMsgService() {
        return ChannelAIOMsgService.f112613a;
    }

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    public f buildBusinessLevel() {
        return new a();
    }

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    public com.tencent.aio.api.factory.a buildFullBackgroundLevel() {
        return g.a.c(this);
    }

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    public j buildMsgLevel() {
        return new C1223b();
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
    @NotNull
    public com.tencent.aio.api.factory.e buildReserve2Level() {
        return new c();
    }

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public zn0.a buildActivityJumpService() {
        return zn0.a.f452788a;
    }

    @Override // com.tencent.aio.api.help.c
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public GuildLiveAnnounceDetailHelperProvider buildHelperProvider() {
        return new GuildLiveAnnounceDetailHelperProvider();
    }

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public kq0.a getPanelFactory() {
        return new kq0.a();
    }

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    public dt.b getBottomDialogFactory() {
        return g.a.g(this);
    }

    @Override // com.tencent.aio.api.factory.g
    public boolean isDebugModel() {
        return ((IAppSetting) QRoute.api(IAppSetting.class)).debug();
    }
}
