package com.tencent.guild.aio.component.publisher;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.component.publisher.GuildPostMediaUIState;
import com.tencent.guild.aio.component.publisher.a;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.input.GuildPermissionsChangeWrapperMsgIntent;
import com.tencent.guild.aio.panel.photo.GuildPhotoPanelMsgIntent;
import com.tencent.guild.aio.panel.photo.e;
import com.tencent.guild.api.input.INTPostMediaRecyclerViewApi;
import com.tencent.guild.api.media.album.GuildAIOMediasRepository;
import com.tencent.mobileqq.guild.util.speaklimitstatus.GuildSpeakLimitStatus;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.j;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007*\u0002!%\u0018\u0000 /2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00010B\u0007\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\u0006\u0010\r\u001a\u00020\u0006J\u0014\u0010\u0011\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R(\u0010,\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010*\u0012\u0004\u0012\u00020!0)0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010+\u00a8\u00061"}, d2 = {"Lcom/tencent/guild/aio/component/publisher/GuildPostMediaViewModel;", "Lcom/tencent/aio/base/mvvm/b;", "Lcom/tencent/guild/aio/component/publisher/a;", "Lcom/tencent/guild/aio/component/publisher/GuildPostMediaUIState;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "E", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "o", "", "Lcom/tencent/guild/api/media/album/e;", "list", "p", DomainData.DOMAIN_NAME, "Lcom/tencent/guild/api/media/album/GuildAIOMediasRepository;", "d", "Lcom/tencent/guild/api/media/album/GuildAIOMediasRepository;", "l", "()Lcom/tencent/guild/api/media/album/GuildAIOMediasRepository;", "repo", "", "e", "Z", "isSelectMode", "", "f", "I", "permissions", "com/tencent/guild/aio/component/publisher/GuildPostMediaViewModel$b", h.F, "Lcom/tencent/guild/aio/component/publisher/GuildPostMediaViewModel$b;", "mAction", "com/tencent/guild/aio/component/publisher/GuildPostMediaViewModel$c", "i", "Lcom/tencent/guild/aio/component/publisher/GuildPostMediaViewModel$c;", "mActionR", "Lkotlin/Pair;", "", "Ljava/util/List;", "messageList", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildPostMediaViewModel extends com.tencent.aio.base.mvvm.b<a, GuildPostMediaUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildAIOMediasRepository repo = new GuildAIOMediasRepository();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isSelectMode;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int permissions;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mActionR;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Pair<String, b>> messageList;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/component/publisher/GuildPostMediaViewModel$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            GuildPostMediaViewModel.this.E(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/component/publisher/GuildPostMediaViewModel$c", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/guild/aio/panel/photo/e$a;", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c implements com.tencent.mvi.base.route.b {
        c() {
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e.a call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            return new e.a(GuildPostMediaViewModel.this.getRepo());
        }
    }

    public GuildPostMediaViewModel() {
        List<Pair<String, b>> listOf;
        b bVar = new b();
        this.mAction = bVar;
        this.mActionR = new c();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(Reflection.getOrCreateKotlinClass(GuildPermissionsChangeWrapperMsgIntent.class).getQualifiedName(), bVar), new Pair(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectModeChangeEvent.class).getQualifiedName(), bVar)});
        this.messageList = listOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent intent) {
        if (intent instanceof GuildPermissionsChangeWrapperMsgIntent) {
            this.permissions = ((GuildPermissionsChangeWrapperMsgIntent) intent).getPermissions();
            m();
        } else if (intent instanceof GuildMsgListIntent.GuildMultiSelectModeChangeEvent) {
            this.isSelectMode = ((GuildMsgListIntent.GuildMultiSelectModeChangeEvent) intent).getIsSelectMode();
            m();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void m() {
        if (!this.isSelectMode) {
            GuildSpeakLimitStatus.Companion companion = GuildSpeakLimitStatus.INSTANCE;
            int i3 = this.permissions;
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (companion.d(i3, com.tencent.guild.aio.util.a.g(g16))) {
                updateUI(new GuildPostMediaUIState.RefreshPostMedia(this.repo.k()));
                return;
            }
        }
        updateUI(new GuildPostMediaUIState.HidePostMedia());
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final GuildAIOMediasRepository getRepo() {
        return this.repo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.C1181a) {
            INTPostMediaRecyclerViewApi a16 = d.a();
            RecyclerView.Adapter<?> a17 = ((a.C1181a) intent).a();
            GuildAIOMediasRepository guildAIOMediasRepository = this.repo;
            ts.a f16 = ((com.tencent.aio.api.runtime.a) getMContext()).f();
            Intrinsics.checkNotNullExpressionValue(f16, "mContext.activityResultLauncher");
            a16.initPostMediaAdapter(a17, guildAIOMediasRepository, f16);
        }
    }

    public final void o() {
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(this.repo.f(), new GuildPostMediaViewModel$registerDataChangeFlow$1(this, null)), Dispatchers.getMain()), vmScope());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        j e16 = ((com.tencent.aio.api.runtime.a) getMContext()).e();
        if (e16 != null) {
            e16.a(Reflection.getOrCreateKotlinClass(GuildPhotoPanelMsgIntent.SelectMediaRepositoryGet.class).getQualifiedName());
        }
        QLog.i("GuildPostMediaViewModel", 4, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void p(@NotNull List<? extends com.tencent.guild.api.media.album.e> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildPhotoPanelMsgIntent.SelectMediaChanged(list));
        if (!this.isSelectMode) {
            GuildSpeakLimitStatus.Companion companion = GuildSpeakLimitStatus.INSTANCE;
            int i3 = this.permissions;
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (companion.d(i3, com.tencent.guild.aio.util.a.g(g16))) {
                updateUI(new GuildPostMediaUIState.RefreshPostMedia(list));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        o();
        Iterator<T> it = this.messageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().d((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
        j e16 = context.e();
        if (e16 != null) {
            e16.j(Reflection.getOrCreateKotlinClass(GuildPhotoPanelMsgIntent.SelectMediaRepositoryGet.class).getQualifiedName(), this.mActionR);
        }
        context.e().h(new GuildPhotoPanelMsgIntent.SelectMediaRepositoryPost(this.repo));
        QLog.i("GuildPostMediaViewModel", 4, "onCreate");
    }
}
