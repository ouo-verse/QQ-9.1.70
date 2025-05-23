package com.tencent.guild.aio.background;

import android.view.View;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.background.GuildFullBackgroundMviIntent;
import com.tencent.guild.aio.background.GuildFullBackgroundUIState;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007*\u0001\u001a\b\u0007\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR(\u0010!\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0012\u0004\u0012\u00020\u001a0\u001e0\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u0018\u00a8\u0006&"}, d2 = {"Lcom/tencent/guild/aio/background/c;", "Lcom/tencent/aio/base/mvvm/b;", "Lcom/tencent/guild/aio/background/GuildFullBackgroundMviIntent;", "Lcom/tencent/guild/aio/background/GuildFullBackgroundUIState;", "", DomainData.DOMAIN_NAME, "o", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "E", "", "stop", "l", "Landroid/view/View;", "view", "toRemove", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "", "d", "Ljava/util/List;", "mViewTypeList", "com/tencent/guild/aio/background/c$b", "e", "Lcom/tencent/guild/aio/background/c$b;", "mAction", "Lkotlin/Pair;", "", "f", "messageList", "<init>", "()V", h.F, "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes6.dex */
public final class c extends com.tencent.aio.base.mvvm.b<GuildFullBackgroundMviIntent, GuildFullBackgroundUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Integer> mViewTypeList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Pair<String, b>> messageList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/background/c$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            c.this.E(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    public c() {
        List<Integer> listOf;
        List<Pair<String, b>> listOf2;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(1);
        this.mViewTypeList = listOf;
        b bVar = new b();
        this.mAction = bVar;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(Reflection.getOrCreateKotlinClass(GuildFullBackgroundMviIntent.GuildUpdateAIOBackground.class).getQualifiedName(), bVar), new Pair(Reflection.getOrCreateKotlinClass(GuildFullBackgroundMviIntent.GuildAIOBackgroundPlayEvent.class).getQualifiedName(), bVar)});
        this.messageList = listOf2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent intent) {
        if (intent instanceof GuildFullBackgroundMviIntent.GuildUpdateAIOBackground) {
            GuildFullBackgroundMviIntent.GuildUpdateAIOBackground guildUpdateAIOBackground = (GuildFullBackgroundMviIntent.GuildUpdateAIOBackground) intent;
            m(guildUpdateAIOBackground.getView(), guildUpdateAIOBackground.getToRemove());
        } else if (intent instanceof GuildFullBackgroundMviIntent.GuildAIOBackgroundPlayEvent) {
            l(((GuildFullBackgroundMviIntent.GuildAIOBackgroundPlayEvent) intent).getStop());
        }
    }

    private final void l(boolean stop) {
        updateUI(new GuildFullBackgroundUIState.GuildUpdateAIOBackgroundPlayEvent(stop));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void m(View view, boolean toRemove) {
        if (!(view instanceof d)) {
            QLog.i("GuildFullBackgroundVM", 1, "[handleUpdateAIOBackground]: view is not instance of IAIOBackgroudnView");
            return;
        }
        int type = ((d) view).type();
        if (this.mViewTypeList.contains(Integer.valueOf(type))) {
            QLog.i("GuildFullBackgroundVM", 1, "[handleUpdateAIOBackground]: update fullbackgroundView, current viewType is " + type);
            updateUI(new GuildFullBackgroundUIState.GuildUpdateAIOBackgroundView(view, toRemove));
            return;
        }
        QLog.i("GuildFullBackgroundVM", 1, "[handleUpdateAIOBackground]: remove fullbackgroundView, current viewType is " + type);
        updateUI(GuildFullBackgroundUIState.GuildRemoveAIOBackgroundView.f110074d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void n() {
        Iterator<T> it = this.messageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().d((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void o() {
        Iterator<T> it = this.messageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().b((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        o();
    }

    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        n();
    }
}
