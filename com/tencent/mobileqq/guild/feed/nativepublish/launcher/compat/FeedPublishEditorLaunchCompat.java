package com.tencent.mobileqq.guild.feed.nativepublish.launcher.compat;

import android.content.Intent;
import com.tencent.mobileqq.guild.feed.feedsquare.data.l;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedNativePublishInitBean;
import com.tencent.mobileqq.guild.feed.nativepublish.FeedEditorConfiguration;
import com.tencent.mobileqq.guild.ipc.methods.i;
import com.tencent.mobileqq.guild.util.y;
import com.tencent.qphone.base.util.QLog;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\f*\u0001\u0013\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJB\u0010\r\u001a6\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004j\u0002`\f2\u0006\u0010\u0003\u001a\u00020\u0002JF\u0010\u0010\u001a6\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004j\u0002`\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007J\u00b1\u0001\u0010\u0012\u001a6\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004j\u0002`\f*6\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004j\u0002`\f2:\u0010\u0011\u001a6\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004j\u0002`\fH\u0086\u0002R\u0014\u0010\u0016\u001a\u00020\u00138BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015RE\u0010\u0019\u001a6\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004j\u0002`\f8F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018RE\u0010\u001b\u001a6\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004j\u0002`\f8F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/launcher/compat/FeedPublishEditorLaunchCompat;", "", "", "tag", "Lkotlin/Function2;", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedNativePublishInitBean;", "Lkotlin/ParameterName;", "name", "bean", "Landroid/content/Intent;", "intent", "", "Lcom/tencent/mobileqq/guild/feed/nativepublish/launcher/compat/EditorLaunchCompatAction;", "f", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/l;", "channelInfo", "d", "continuationAction", "e", "com/tencent/mobileqq/guild/feed/nativepublish/launcher/compat/FeedPublishEditorLaunchCompat$c", "a", "()Lcom/tencent/mobileqq/guild/feed/nativepublish/launcher/compat/FeedPublishEditorLaunchCompat$c;", "supplementConfiguration", "c", "()Lkotlin/jvm/functions/Function2;", "unifiedSupplement", "b", "supplementEditFlagBySceneType", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedPublishEditorLaunchCompat {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final FeedPublishEditorLaunchCompat f222113a = new FeedPublishEditorLaunchCompat();

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u000026\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0001j\u0002`\tJ\u0019\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0002\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/feed/nativepublish/launcher/compat/FeedPublishEditorLaunchCompat$a", "Lkotlin/Function2;", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedNativePublishInitBean;", "Lkotlin/ParameterName;", "name", "bean", "Landroid/content/Intent;", "intent", "", "Lcom/tencent/mobileqq/guild/feed/nativepublish/launcher/compat/EditorLaunchCompatAction;", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements Function2<GuildFeedNativePublishInitBean, Intent, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ l f222114d;

        a(l lVar) {
            this.f222114d = lVar;
        }

        public void a(@NotNull GuildFeedNativePublishInitBean bean, @NotNull Intent intent) {
            int i3;
            Intrinsics.checkNotNullParameter(bean, "bean");
            Intrinsics.checkNotNullParameter(intent, "intent");
            l lVar = this.f222114d;
            if (lVar != null) {
                bean.setChannelId(lVar.getSectionInfo().getChannelId());
                bean.setChannelName(lVar.getSectionInfo().getName());
                if (bean.getBusinessType() != 7) {
                    int type = lVar.getSectionInfo().getType();
                    if (type != 2) {
                        if (type != 4) {
                            if (type != 5) {
                                i3 = 15;
                            }
                        } else {
                            i3 = 16;
                        }
                        bean.setBusinessType(i3);
                    }
                    i3 = 14;
                    bean.setBusinessType(i3);
                }
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(GuildFeedNativePublishInitBean guildFeedNativePublishInitBean, Intent intent) {
            a(guildFeedNativePublishInitBean, intent);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u000026\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0001j\u0002`\tJ\u0019\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0002\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/feed/nativepublish/launcher/compat/FeedPublishEditorLaunchCompat$b", "Lkotlin/Function2;", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedNativePublishInitBean;", "Lkotlin/ParameterName;", "name", "bean", "Landroid/content/Intent;", "intent", "", "Lcom/tencent/mobileqq/guild/feed/nativepublish/launcher/compat/EditorLaunchCompatAction;", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements Function2<GuildFeedNativePublishInitBean, Intent, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function2<GuildFeedNativePublishInitBean, Intent, Unit> f222115d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function2<GuildFeedNativePublishInitBean, Intent, Unit> f222116e;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function2<? super GuildFeedNativePublishInitBean, ? super Intent, Unit> function2, Function2<? super GuildFeedNativePublishInitBean, ? super Intent, Unit> function22) {
            this.f222115d = function2;
            this.f222116e = function22;
        }

        public void a(@NotNull GuildFeedNativePublishInitBean bean, @NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(bean, "bean");
            Intrinsics.checkNotNullParameter(intent, "intent");
            this.f222115d.invoke(bean, intent);
            this.f222116e.invoke(bean, intent);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(GuildFeedNativePublishInitBean guildFeedNativePublishInitBean, Intent intent) {
            a(guildFeedNativePublishInitBean, intent);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u000026\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0001j\u0002`\tJ\u0019\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0002\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/feed/nativepublish/launcher/compat/FeedPublishEditorLaunchCompat$c", "Lkotlin/Function2;", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedNativePublishInitBean;", "Lkotlin/ParameterName;", "name", "bean", "Landroid/content/Intent;", "intent", "", "Lcom/tencent/mobileqq/guild/feed/nativepublish/launcher/compat/EditorLaunchCompatAction;", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements Function2<GuildFeedNativePublishInitBean, Intent, Unit> {
        c() {
        }

        public void a(@NotNull GuildFeedNativePublishInitBean bean, @NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(bean, "bean");
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (bean.getBusinessType() == 7) {
                intent.putExtra("launch_config", new FeedEditorConfiguration(false, false, false, false, false, false, false, false, 240, null));
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(GuildFeedNativePublishInitBean guildFeedNativePublishInitBean, Intent intent) {
            a(guildFeedNativePublishInitBean, intent);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u000026\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0001j\u0002`\tJ\u0019\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0002\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/feed/nativepublish/launcher/compat/FeedPublishEditorLaunchCompat$d", "Lkotlin/Function2;", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedNativePublishInitBean;", "Lkotlin/ParameterName;", "name", "bean", "Landroid/content/Intent;", "intent", "", "Lcom/tencent/mobileqq/guild/feed/nativepublish/launcher/compat/EditorLaunchCompatAction;", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements Function2<GuildFeedNativePublishInitBean, Intent, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f222117d;

        d(String str) {
            this.f222117d = str;
        }

        public void a(@NotNull GuildFeedNativePublishInitBean bean, @NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(bean, "bean");
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (bean.getBusinessType() == 7) {
                return;
            }
            try {
                if (MobileQQ.sProcessId != 1) {
                    y.b(i.class, null, bean.getGuildId(), this.f222117d);
                } else {
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    String guildId = bean.getGuildId();
                    Intrinsics.checkNotNullExpressionValue(guildId, "bean.guildId");
                    com.tencent.mobileqq.guild.main.d.d(peekAppRuntime, guildId, this.f222117d);
                }
            } catch (Exception e16) {
                QLog.e("FeedPublishEditorLaunchCompat", 1, "trySetGuildAutoTop|" + e16);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(GuildFeedNativePublishInitBean guildFeedNativePublishInitBean, Intent intent) {
            a(guildFeedNativePublishInitBean, intent);
            return Unit.INSTANCE;
        }
    }

    FeedPublishEditorLaunchCompat() {
    }

    private final c a() {
        return new c();
    }

    @NotNull
    public final Function2<GuildFeedNativePublishInitBean, Intent, Unit> b() {
        return new Function2<GuildFeedNativePublishInitBean, Intent, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.launcher.compat.FeedPublishEditorLaunchCompat$supplementEditFlagBySceneType$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(GuildFeedNativePublishInitBean guildFeedNativePublishInitBean, Intent intent) {
                invoke2(guildFeedNativePublishInitBean, intent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GuildFeedNativePublishInitBean guildFeedNativePublishInitBean, @NotNull Intent intent) {
                Intrinsics.checkNotNullParameter(guildFeedNativePublishInitBean, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(intent, "intent");
                int intExtra = intent.getIntExtra("launch_scene_type", 0);
                if (intExtra != 2) {
                    if (intExtra == 3) {
                        intent.putExtra("launch_edit_flag", true);
                        intent.putExtra("launch_published_flag", false);
                        return;
                    } else if (intExtra != 4 && intExtra != 5) {
                        return;
                    }
                }
                intent.putExtra("launch_edit_flag", true);
                intent.putExtra("launch_published_flag", true);
            }
        };
    }

    @NotNull
    public final Function2<GuildFeedNativePublishInitBean, Intent, Unit> c() {
        return e(b(), a());
    }

    @Deprecated(message = "\u8986\u5199\u573a\u666f\u503c\u662f\u8986\u76d6\u4e0d\u5b8c\u6574\uff0c\u5e9f\u5f03\uff0c\u53d1\u5e03\u5668\u5185\u90e8\u5bf9\u573a\u666f\u503c\u7684\u4f9d\u8d56\u9700\u8981\u51cf\u5f31")
    @NotNull
    public final Function2<GuildFeedNativePublishInitBean, Intent, Unit> d(@Nullable l channelInfo) {
        return new a(channelInfo);
    }

    @NotNull
    public final Function2<GuildFeedNativePublishInitBean, Intent, Unit> e(@NotNull Function2<? super GuildFeedNativePublishInitBean, ? super Intent, Unit> function2, @NotNull Function2<? super GuildFeedNativePublishInitBean, ? super Intent, Unit> continuationAction) {
        Intrinsics.checkNotNullParameter(function2, "<this>");
        Intrinsics.checkNotNullParameter(continuationAction, "continuationAction");
        return new b(function2, continuationAction);
    }

    @NotNull
    public final Function2<GuildFeedNativePublishInitBean, Intent, Unit> f(@NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return new d(tag);
    }
}
