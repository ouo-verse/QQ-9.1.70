package com.tencent.mobileqq.guild.main.announcement.detail.aio;

import android.content.Context;
import android.content.res.Resources;
import at.e;
import com.tencent.aio.api.factory.f;
import com.tencent.aio.api.factory.g;
import com.tencent.aio.api.factory.j;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.aio.base.mvi.part.TitleUIState;
import com.tencent.aio.base.mvi.part.TopTipViewState;
import com.tencent.guild.aio.background.GuildFullBackgroundVB;
import com.tencent.mobileqq.R;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.util.AppSetting;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import wq1.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/main/announcement/detail/aio/a;", "Lcom/tencent/aio/api/factory/g;", "Lcom/tencent/aio/msgservice/a;", "buildAIOMsgService", "Lys/a;", "buildActivityJumpService", "Lcom/tencent/aio/api/factory/f;", "buildBusinessLevel", "Lcom/tencent/mobileqq/guild/main/announcement/detail/aio/GuildAnnouncementHelperProvider;", "a", "Lcom/tencent/aio/api/factory/j;", "buildMsgLevel", "Lcom/tencent/aio/api/factory/d;", "buildReserve1Level", "Lcom/tencent/aio/api/factory/e;", "buildReserve2Level", "Ldt/b;", "getBottomDialogFactory", "Lcom/tencent/aio/part/root/panel/mvx/config/a;", "getPanelFactory", "", "isDebugModel", "Lcom/tencent/aio/api/factory/a;", "buildFullBackgroundLevel", "Lcom/tencent/guild/aio/factory/a;", "d", "Lcom/tencent/guild/aio/factory/a;", "defaultFactory", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a implements g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.guild.aio.factory.a defaultFactory = new com.tencent.guild.aio.factory.a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u0002H\u0016J\u0018\u0010\b\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0006\u0012\u0006\b\u0001\u0012\u00020\u00070\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/main/announcement/detail/aio/a$a", "Lcom/tencent/aio/api/factory/f;", "Lcom/tencent/aio/base/mvvm/a;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "buildInputVB", "", "Lcom/tencent/aio/base/mvi/part/TitleUIState;", "buildTitleVB", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.main.announcement.detail.aio.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static final class C7818a implements f {
        C7818a() {
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
            return new d();
        }

        @Override // com.tencent.aio.api.factory.f
        @Nullable
        public com.tencent.aio.base.mvvm.a<Object, Object> buildShortcutBarVB() {
            return f.a.d(this);
        }

        @Override // com.tencent.aio.api.factory.f
        @NotNull
        public com.tencent.aio.base.mvvm.a<Object, ? extends TitleUIState> buildTitleVB() {
            return new wq1.g();
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
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u00040\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/main/announcement/detail/aio/a$b", "Lcom/tencent/aio/api/factory/a;", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements com.tencent.aio.api.factory.a {
        b() {
        }

        @Override // com.tencent.aio.api.factory.a
        @NotNull
        public com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> a() {
            return new GuildFullBackgroundVB(true);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/guild/main/announcement/detail/aio/a$c", "Lcom/tencent/aio/api/factory/j;", "Lcom/tencent/guild/aio/msglist/holder/c;", h.F, "Lwq1/e;", "i", "Lcom/tencent/aio/api/refreshLoad/e;", "f", "Landroid/content/Context;", "context", "", "c", "e", "a", "Lwq1/e;", "viewBinder", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements j {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final wq1.e viewBinder = new wq1.e();

        c() {
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
            int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.f158988ci3);
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
            return dimensionPixelOffset + i3;
        }

        @Override // com.tencent.aio.api.factory.j
        @Nullable
        public com.tencent.aio.base.mvvm.a<Object, Object> d() {
            return j.a.a(this);
        }

        @Override // com.tencent.aio.api.factory.j
        public int e(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return context.getResources().getDimensionPixelOffset(R.dimen.f158987ci2);
        }

        @Override // com.tencent.aio.api.factory.j
        @Nullable
        public com.tencent.aio.api.refreshLoad.e f() {
            return null;
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
            return new com.tencent.guild.aio.msglist.holder.c(null, 1, 0 == true ? 1 : 0);
        }

        @Override // com.tencent.aio.api.factory.j
        @NotNull
        /* renamed from: i, reason: from getter and merged with bridge method [inline-methods] */
        public wq1.e g() {
            return this.viewBinder;
        }
    }

    @Override // com.tencent.aio.api.help.c
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GuildAnnouncementHelperProvider buildHelperProvider() {
        return new GuildAnnouncementHelperProvider();
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
        return new C7818a();
    }

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    public com.tencent.aio.api.factory.a buildFullBackgroundLevel() {
        return new b();
    }

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    public j buildMsgLevel() {
        return new c();
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
        return this.defaultFactory.getBottomDialogFactory();
    }

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    public com.tencent.aio.part.root.panel.mvx.config.a getPanelFactory() {
        return this.defaultFactory.getPanelFactory();
    }

    @Override // com.tencent.aio.api.factory.g
    public boolean isDebugModel() {
        return AppSetting.isDebugVersion();
    }
}
