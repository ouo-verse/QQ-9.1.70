package com.tencent.mobileqq.guild.channel.managev2.container;

import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.base.repository.AccountChangedNotifier;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingBaseVM;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingMsgIntent;
import com.tencent.mobileqq.guild.channel.managev2.ChannelSettingMviContext;
import com.tencent.mobileqq.guild.channel.managev2.container.ChannelSettingBaseContainerVM;
import com.tencent.mobileqq.guild.channel.managev2.utils.ChannelSettingUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.dx;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\b\b\u0016\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\u000f\u0010\t\u001a\u00020\bH\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016R\u001b\u0010\u0015\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\nR\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/managev2/container/ChannelSettingBaseContainerVM;", "Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingBaseVM;", "Lcom/tencent/mobileqq/guild/base/repository/a;", "", HippyTKDListViewAdapter.X, "y", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "com/tencent/mobileqq/guild/channel/managev2/container/ChannelSettingBaseContainerVM$b", "v", "()Lcom/tencent/mobileqq/guild/channel/managev2/container/ChannelSettingBaseContainerVM$b;", "Lcom/tencent/mobileqq/guild/channel/managev2/ChannelSettingMviContext;", "context", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "account", "onAccountChanged", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "e", "Lkotlin/Lazy;", "w", "gProObserver", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "f", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gProService", "<init>", "()V", tl.h.F, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public class ChannelSettingBaseContainerVM extends ChannelSettingBaseVM implements com.tencent.mobileqq.guild.base.repository.a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy gProObserver;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private IGPSService gProService;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\t\u001a\u00020\u0004H\u0014J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0014J\u001c\u0010\r\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014J\"\u0010\u0010\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000eH\u0014\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/guild/channel/managev2/container/ChannelSettingBaseContainerVM$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "channelUin", "", "onChannelInfoUpdated", "guildId", "onChannelListUpdated", "onDestoryGuild", "onGuildListUpdated", "onGuildInfoUpdated", "Lcom/tencent/mobileqq/qqguildsdk/data/dx;", QCircleDaTongConstant.ElementParamValue.PERMISSION, "onGuildPermissionChanged", "Ljava/util/HashSet;", "channelIds", "onChannelPermissionChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelInfoUpdated(@Nullable String channelUin) {
            if (Intrinsics.areEqual(channelUin, ((ChannelSettingMviContext) ChannelSettingBaseContainerVM.this.getMContext()).getParams().getChannelId())) {
                ChannelSettingBaseContainerVM.this.x();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelListUpdated(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            if (Intrinsics.areEqual(guildId, ((ChannelSettingMviContext) ChannelSettingBaseContainerVM.this.getMContext()).getParams().getGuildId())) {
                ChannelSettingBaseContainerVM.this.x();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelPermissionChanged(@Nullable String guildId, @Nullable HashSet<String> channelIds) {
            if (Intrinsics.areEqual(guildId, ((ChannelSettingMviContext) ChannelSettingBaseContainerVM.this.getMContext()).getParams().getGuildId()) && channelIds != null && channelIds.contains(((ChannelSettingMviContext) ChannelSettingBaseContainerVM.this.getMContext()).getParams().getChannelId())) {
                ChannelSettingBaseContainerVM.this.z();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDestoryGuild(@Nullable String guildId) {
            if (Intrinsics.areEqual(guildId, ((ChannelSettingMviContext) ChannelSettingBaseContainerVM.this.getMContext()).getParams().getGuildId())) {
                ChannelSettingBaseContainerVM.this.y();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(@Nullable String guildId) {
            if (Intrinsics.areEqual(guildId, ((ChannelSettingMviContext) ChannelSettingBaseContainerVM.this.getMContext()).getParams().getGuildId())) {
                ChannelSettingBaseContainerVM.this.y();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildListUpdated() {
            ChannelSettingBaseContainerVM.this.y();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildPermissionChanged(@Nullable String guildId, @Nullable dx permission) {
            if (Intrinsics.areEqual(guildId, ((ChannelSettingMviContext) ChannelSettingBaseContainerVM.this.getMContext()).getParams().getGuildId())) {
                ChannelSettingBaseContainerVM.this.z();
            }
        }
    }

    public ChannelSettingBaseContainerVM() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.mobileqq.guild.channel.managev2.container.ChannelSettingBaseContainerVM$gProObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ChannelSettingBaseContainerVM.b invoke() {
                ChannelSettingBaseContainerVM.b v3;
                v3 = ChannelSettingBaseContainerVM.this.v();
                return v3;
            }
        });
        this.gProObserver = lazy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void t() {
        if (ChannelSettingUtils.d(((ChannelSettingMviContext) getMContext()).getParams().getChannelInfo())) {
            kotlin.Function0.b(100, new Runnable() { // from class: com.tencent.mobileqq.guild.channel.managev2.container.g
                @Override // java.lang.Runnable
                public final void run() {
                    ChannelSettingBaseContainerVM.u(ChannelSettingBaseContainerVM.this);
                }
            });
            return;
        }
        FragmentActivity activity = ((ChannelSettingMviContext) getMContext()).c().getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void u(ChannelSettingBaseContainerVM this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = ((ChannelSettingMviContext) this$0.getMContext()).c().getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b v() {
        return new b();
    }

    private final b w() {
        return (b) this.gProObserver.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void x() {
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        IGProChannelInfo channelInfo = ((IGPSService) S0).getChannelInfo(((ChannelSettingMviContext) getMContext()).getParams().getChannelId());
        if (channelInfo == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "channelInfoChange, new is null! " + ((ChannelSettingMviContext) getMContext()).getParams().getGuildId() + " " + ((ChannelSettingMviContext) getMContext()).getParams().getChannelId();
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.mnr.ChannelSettingContainerVM", 1, (String) it.next(), null);
            }
            t();
            return;
        }
        Logger logger2 = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger2.d().d("Guild.mnr.ChannelSettingContainerVM", 1, "handleChannelInfoChange " + channelInfo);
        }
        ((ChannelSettingMviContext) getMContext()).getParams().setChannelInfo(channelInfo);
        ((ChannelSettingMviContext) getMContext()).e().h(new ChannelSettingMsgIntent.ChannelInfoChange(channelInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void y() {
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        IGProGuildInfo guildInfo = ((IGPSService) S0).getGuildInfo(((ChannelSettingMviContext) getMContext()).getParams().getGuildId());
        if (guildInfo == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "guildInfoChange, new is null! " + ((ChannelSettingMviContext) getMContext()).getParams().getGuildId() + " " + ((ChannelSettingMviContext) getMContext()).getParams().getChannelId();
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.mnr.ChannelSettingContainerVM", 1, (String) it.next(), null);
            }
            t();
            return;
        }
        Logger logger2 = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger2.d().d("Guild.mnr.ChannelSettingContainerVM", 1, "handleGuildInfoChange " + guildInfo);
        }
        ((ChannelSettingMviContext) getMContext()).getParams().setGuildInfo(guildInfo);
        ((ChannelSettingMviContext) getMContext()).e().h(new ChannelSettingMsgIntent.ChannelInfoChange(((ChannelSettingMviContext) getMContext()).getParams().getChannelInfo()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void z() {
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        dx channelPermission = ((IGPSService) S0).getChannelPermission(((ChannelSettingMviContext) getMContext()).getParams().getGuildId(), ((ChannelSettingMviContext) getMContext()).getParams().getChannelId());
        Intrinsics.checkNotNullExpressionValue(channelPermission, "IGPSService::class.get()\u2026Context.params.channelId)");
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("Guild.mnr.ChannelSettingContainerVM", 1, "handlePermissionChange " + channelPermission);
        }
        ((ChannelSettingMviContext) getMContext()).e().h(new ChannelSettingMsgIntent.PermissionChange(channelPermission));
    }

    @Override // com.tencent.mobileqq.guild.channel.managev2.ChannelSettingBaseVM, com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: m */
    public void onCreate(@NotNull final ChannelSettingMviContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        IGPSService iGPSService = (IGPSService) S0;
        this.gProService = iGPSService;
        if (iGPSService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gProService");
            iGPSService = null;
        }
        iGPSService.addObserver(w());
        AccountChangedNotifier.f214789d.a(this);
        z();
        context.c().getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.tencent.mobileqq.guild.channel.managev2.container.ChannelSettingBaseContainerVM$onCreate$1

            /* compiled from: P */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes12.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f215147a;

                static {
                    int[] iArr = new int[Lifecycle.Event.values().length];
                    try {
                        iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f215147a = iArr;
                }
            }

            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                Logger logger = Logger.f235387a;
                if (QLog.isDevelopLevel()) {
                    Log.d("Guild.mnr.ChannelSettingContainerVM", "onStateChanged " + event);
                }
                int i3 = a.f215147a[event.ordinal()];
                if (i3 == 1) {
                    ChannelSettingBaseContainerVM.this.x();
                } else if (i3 == 2) {
                    context.c().getLifecycle().removeObserver(this);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        IGPSService iGPSService = this.gProService;
        IGPSService iGPSService2 = null;
        if (iGPSService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gProService");
            iGPSService = null;
        }
        iGPSService.deleteObserver(w());
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        IGPSService iGPSService3 = (IGPSService) S0;
        this.gProService = iGPSService3;
        if (iGPSService3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gProService");
        } else {
            iGPSService2 = iGPSService3;
        }
        iGPSService2.addObserver(w());
    }

    @Override // com.tencent.mobileqq.guild.channel.managev2.ChannelSettingBaseVM, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.mnr.ChannelSettingContainerVM", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        IGPSService iGPSService = this.gProService;
        if (iGPSService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gProService");
            iGPSService = null;
        }
        iGPSService.deleteObserver(w());
        AccountChangedNotifier.f214789d.d(this);
    }
}
