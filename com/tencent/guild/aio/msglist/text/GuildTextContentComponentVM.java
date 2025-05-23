package com.tencent.guild.aio.msglist.text;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.aio.api.runtime.emitter.AIOServiceContact$IRecycleViewScrollCallBack;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.activity.GuildChatActivityAbility;
import com.tencent.guild.aio.msglist.holder.component.t;
import com.tencent.guild.aio.msglist.text.GuildTextContentComponentVM$scrollListener$2;
import com.tencent.guild.aio.msglist.text.GuildTextContentUIState;
import com.tencent.guild.aio.msglist.text.a;
import com.tencent.guild.api.emoji.ILottieEmoProxyApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u001a\u0018\u0000 '2\u00020\u0001:\u0001(B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\f\u00a2\u0006\u0004\b&\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u001b\u0010\u001f\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010%\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\u00a8\u0006)"}, d2 = {"Lcom/tencent/guild/aio/msglist/text/GuildTextContentComponentVM;", "Lcom/tencent/guild/aio/msglist/holder/component/t;", "Lcom/tencent/guild/aio/msglist/text/a$a;", "intent", "", "r", "Lol3/b;", "handleIntent", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/view/ViewGroup;", "d", "Landroid/view/ViewGroup;", "p", "()Landroid/view/ViewGroup;", "setBubbleParent", "(Landroid/view/ViewGroup;)V", "bubbleParent", "", "e", "Z", "alreadyRead", "f", "isLottiePause", "com/tencent/guild/aio/msglist/text/GuildTextContentComponentVM$scrollListener$2$a", h.F, "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/guild/aio/msglist/text/GuildTextContentComponentVM$scrollListener$2$a;", "scrollListener", "Lcom/tencent/mvi/base/route/a;", "i", "Lcom/tencent/mvi/base/route/a;", "getAction", "()Lcom/tencent/mvi/base/route/a;", "action", "<init>", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildTextContentComponentVM extends t {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ViewGroup bubbleParent;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean alreadyRead;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isLottiePause;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy scrollListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mvi.base.route.a action;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/msglist/text/GuildTextContentComponentVM$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            if (i3 instanceof GuildChatActivityAbility.PostThemeChangedIntent) {
                GuildTextContentComponentVM.this.updateUI(GuildTextContentUIState.PostThemeChangedState.f111910d);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    public GuildTextContentComponentVM(@NotNull ViewGroup bubbleParent) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(bubbleParent, "bubbleParent");
        this.bubbleParent = bubbleParent;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildTextContentComponentVM$scrollListener$2.a>() { // from class: com.tencent.guild.aio.msglist.text.GuildTextContentComponentVM$scrollListener$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/msglist/text/GuildTextContentComponentVM$scrollListener$2$a", "Lcom/tencent/aio/api/runtime/emitter/AIOServiceContact$IRecycleViewScrollCallBack;", "", "state", "", "onScrollStateChange", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes6.dex */
            public static final class a implements AIOServiceContact$IRecycleViewScrollCallBack {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ GuildTextContentComponentVM f111909d;

                a(GuildTextContentComponentVM guildTextContentComponentVM) {
                    this.f111909d = guildTextContentComponentVM;
                }

                @Override // com.tencent.aio.api.runtime.emitter.AIOServiceContact$IRecycleViewScrollCallBack
                public void onScrollStateChange(int state) {
                    boolean z16;
                    QLog.d("GuildTextContentComponentVM", 4, hashCode() + " onScrollStateChange state=" + state);
                    if (state == 0) {
                        QLog.d("GuildTextContentComponentVM", 4, hashCode() + " resumeAll");
                        ((ILottieEmoProxyApi) QRoute.api(ILottieEmoProxyApi.class)).resumeLottie(this.f111909d.getBubbleParent());
                        this.f111909d.isLottiePause = false;
                        return;
                    }
                    if (state == 1 || state == 2) {
                        z16 = this.f111909d.isLottiePause;
                        if (!z16) {
                            QLog.d("GuildTextContentComponentVM", 4, hashCode() + " pauseAll");
                            this.f111909d.isLottiePause = true;
                            ((ILottieEmoProxyApi) QRoute.api(ILottieEmoProxyApi.class)).pauseLottie(this.f111909d.getBubbleParent());
                        }
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(GuildTextContentComponentVM.this);
            }
        });
        this.scrollListener = lazy;
        this.action = new b();
    }

    private final GuildTextContentComponentVM$scrollListener$2.a q() {
        return (GuildTextContentComponentVM$scrollListener$2.a) this.scrollListener.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void r(a.C1206a intent) {
        QLog.i("GuildTextContentComponentVM", 1, "handleLottie ThreadName=" + Thread.currentThread().getName());
        Context context = ((com.tencent.aio.api.runtime.a) getMContext()).c().getContext();
        if (context != null) {
            BuildersKt__Builders_commonKt.launch$default(vmScope(), null, null, new GuildTextContentComponentVM$handleLottie$1(this, intent, context, null), 3, null);
        }
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.t, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void handleIntent(@NotNull ol3.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.C1206a) {
            r((a.C1206a) intent);
        } else {
            super.handleIntent(intent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        QLog.d("GuildTextContentComponentVM", 4, hashCode() + " doOnDestroy");
        ((com.tencent.aio.api.runtime.a) getMContext()).b().a(AIOServiceContact$IRecycleViewScrollCallBack.class).c(q());
    }

    @NotNull
    /* renamed from: p, reason: from getter */
    public final ViewGroup getBubbleParent() {
        return this.bubbleParent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        QLog.d("GuildTextContentComponentVM", 4, hashCode() + " onCreate");
        super.onCreate(context);
        ((com.tencent.aio.api.runtime.a) getMContext()).b().a(AIOServiceContact$IRecycleViewScrollCallBack.class).a(q());
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildChatActivityAbility.PostThemeChangedIntent.class).getQualifiedName(), this.action);
    }
}
