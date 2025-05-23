package com.tencent.guild.aio.panel.photo;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.aio.part.root.panel.mvx.intent.PanelStatusIntent;
import com.tencent.guild.aio.event.GuildMsgSendEvent;
import com.tencent.guild.aio.panel.photo.GuildPhotoPanelMsgIntent;
import com.tencent.guild.aio.panel.photo.GuildPhotoPanelUIState;
import com.tencent.guild.aio.panel.photo.c;
import com.tencent.guild.aio.panel.photo.e;
import com.tencent.guild.aio.reserve2.busi.animate.GuildPhotoPanelDragAnimateEvent;
import com.tencent.guild.aio.util.PostUtilKt;
import com.tencent.guild.aio.util.ex.FromScene;
import com.tencent.guild.api.media.album.AlbumResult;
import com.tencent.guild.api.media.album.GuildAIOMediasRepository;
import com.tencent.guild.api.media.album.GuildPickPhotoResult;
import com.tencent.guild.api.media.album.INTGuildAlbumApi;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.media.pic.api.IGuildPicAIO;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0097\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u0001F\u0018\u0000 \u001a2\u00020\u0001:\u0001+B\u000f\u0012\u0006\u0010/\u001a\u00020*\u00a2\u0006\u0004\bI\u0010JJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0016\u0010\u000b\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0006\u0010\u001a\u001a\u00020\u0002J\u000e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u001bJ\u000e\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0010J\u000e\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\tJ\u0006\u0010#\u001a\u00020\"J\u0006\u0010$\u001a\u00020 J\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0%J\u0014\u0010)\u001a\u00020\u00022\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00170'R\u0017\u0010/\u001a\u00020*8\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0017\u00105\u001a\u0002008\u0006\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0017\u0010:\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00170;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010E\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010DR\u0014\u0010H\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010G\u00a8\u0006K"}, d2 = {"Lcom/tencent/guild/aio/panel/photo/GuildPhotoPanelVM;", "", "", "i", "Lcom/tencent/guild/aio/panel/photo/c$d;", "intent", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "Lcom/tencent/guild/api/media/album/e;", "tag", "y", "w", HippyTKDListViewAdapter.X, "Lcom/tencent/guild/aio/panel/photo/c$b;", "t", "Lcom/tencent/mvi/base/route/MsgIntent;", "message", "u", "Lcom/tencent/mvi/base/route/k;", "v", "Landroidx/lifecycle/LifecycleOwner;", "k", "Lcom/tencent/guild/aio/panel/photo/GuildPhotoPanelUIState;", "state", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, tl.h.F, "Lol3/b;", "o", "event", DomainData.DOMAIN_NAME, "info", "", "g", "", "f", ReportConstant.COSTREPORT_PREFIX, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/Observer;", "observer", "p", "Lcom/tencent/aio/part/root/panel/mvx/config/c;", "a", "Lcom/tencent/aio/part/root/panel/mvx/config/c;", "getPanelParam", "()Lcom/tencent/aio/part/root/panel/mvx/config/c;", "panelParam", "Lcom/tencent/guild/api/media/album/GuildAIOMediasRepository;", "b", "Lcom/tencent/guild/api/media/album/GuildAIOMediasRepository;", "l", "()Lcom/tencent/guild/api/media/album/GuildAIOMediasRepository;", "repository", "c", "J", "getSizeLimit", "()J", "sizeLimit", "Landroidx/lifecycle/MutableLiveData;", "d", "Landroidx/lifecycle/MutableLiveData;", "mUiState", "Lkotlinx/coroutines/CoroutineScope;", "e", "Lkotlinx/coroutines/CoroutineScope;", "dataUpdateCoroutine", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "com/tencent/guild/aio/panel/photo/GuildPhotoPanelVM$b", "Lcom/tencent/guild/aio/panel/photo/GuildPhotoPanelVM$b;", "mAction1", "<init>", "(Lcom/tencent/aio/part/root/panel/mvx/config/c;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildPhotoPanelVM {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.part.root.panel.mvx.config.c panelParam;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildAIOMediasRepository repository;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long sizeLimit;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<GuildPhotoPanelUIState> mUiState;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CoroutineScope dataUpdateCoroutine;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction1;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"", "Lcom/tencent/guild/api/media/album/e;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.guild.aio.panel.photo.GuildPhotoPanelVM$1", f = "GuildPhotoPanelVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.guild.aio.panel.photo.GuildPhotoPanelVM$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<List<? extends com.tencent.guild.api.media.album.e>, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                GuildPhotoPanelVM guildPhotoPanelVM = GuildPhotoPanelVM.this;
                guildPhotoPanelVM.z(new GuildPhotoPanelUIState.RefreshUI(null, guildPhotoPanelVM.getRepository().getMQuality(), 1, null));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull List<? extends com.tencent.guild.api.media.album.e> list, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/panel/photo/GuildPhotoPanelVM$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            GuildPhotoPanelVM.this.n(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    public GuildPhotoPanelVM(@NotNull com.tencent.aio.part.root.panel.mvx.config.c panelParam) {
        Intrinsics.checkNotNullParameter(panelParam, "panelParam");
        this.panelParam = panelParam;
        this.sizeLimit = ((IGuildPicAIO) QRoute.api(IGuildPicAIO.class)).getGroupPicSizeLimit();
        this.mUiState = new MutableLiveData<>();
        this.dataUpdateCoroutine = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        com.tencent.aio.api.runtime.a a16 = panelParam.a();
        this.mAIOContext = a16;
        b bVar = new b();
        this.mAction1 = bVar;
        k v3 = v(GuildPhotoPanelMsgIntent.SelectMediaRepositoryGet.f112040d);
        Intrinsics.checkNotNull(v3, "null cannot be cast to non-null type com.tencent.guild.aio.panel.photo.GuildPhotoPanelMsgResult.SelectMediaRepositoryResult");
        GuildAIOMediasRepository repo = ((e.a) v3).getRepo();
        this.repository = repo;
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(repo.f(), new AnonymousClass1(null)), Dispatchers.getMain()), this.dataUpdateCoroutine);
        j e16 = a16.e();
        String qualifiedName = Reflection.getOrCreateKotlinClass(PanelStatusIntent.PanelStatusChangeIntent.class).getQualifiedName();
        LifecycleOwner d16 = a16.d();
        Intrinsics.checkNotNullExpressionValue(d16, "mAIOContext.lifecycleOwner");
        e16.c(qualifiedName, bVar, d16);
    }

    private final void i() {
        boolean z16;
        FragmentActivity activity = this.panelParam.a().c().getActivity();
        if (activity == null) {
            return;
        }
        INTGuildAlbumApi iNTGuildAlbumApi = (INTGuildAlbumApi) QRoute.api(INTGuildAlbumApi.class);
        ts.a f16 = this.panelParam.a().f();
        Intrinsics.checkNotNullExpressionValue(f16, "panelParam.mAIOContext.activityResultLauncher");
        List<com.tencent.guild.api.media.album.e> m3 = m();
        String b16 = com.tencent.guild.aio.util.a.b(this.panelParam.b());
        String g16 = com.tencent.guild.aio.util.a.g(this.panelParam.b());
        HashMap<String, String> g17 = this.repository.g();
        if (com.tencent.guild.aio.util.ex.a.d(this.panelParam.a()) == FromScene.DIRECT.ordinal()) {
            z16 = true;
        } else {
            z16 = false;
        }
        iNTGuildAlbumApi.openNewAlbumFromPhotoPanel(activity, f16, m3, b16, g16, null, g17, z16, true, new Function1<AlbumResult, Unit>() { // from class: com.tencent.guild.aio.panel.photo.GuildPhotoPanelVM$enterAlbum$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AlbumResult albumResult) {
                invoke2(albumResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull AlbumResult ret) {
                Intrinsics.checkNotNullParameter(ret, "ret");
                GuildPhotoPanelVM.this.getRepository().x(ret);
            }
        });
    }

    private final void j(c.d intent) {
        int collectionSizeOrDefault;
        INTGuildAlbumApi iNTGuildAlbumApi = (INTGuildAlbumApi) QRoute.api(INTGuildAlbumApi.class);
        ts.a f16 = this.panelParam.a().f();
        Intrinsics.checkNotNullExpressionValue(f16, "panelParam.mAIOContext.activityResultLauncher");
        List<com.tencent.guild.api.media.album.e> i3 = this.repository.i();
        List<com.tencent.guild.api.media.album.e> m3 = m();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(m3, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = m3.iterator();
        while (it.hasNext()) {
            arrayList.add(((com.tencent.guild.api.media.album.e) it.next()).getPath());
        }
        iNTGuildAlbumApi.photoPanelItemClick(f16, i3, arrayList, intent.getInfo().getPath(), com.tencent.guild.aio.util.a.b(this.panelParam.b()), com.tencent.guild.aio.util.a.g(this.panelParam.b()), null, null, new Function1<AlbumResult, Unit>() { // from class: com.tencent.guild.aio.panel.photo.GuildPhotoPanelVM$enterItemPreview$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AlbumResult albumResult) {
                invoke2(albumResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull AlbumResult ret) {
                Intrinsics.checkNotNullParameter(ret, "ret");
                GuildPhotoPanelVM.this.getRepository().x(ret);
            }
        });
    }

    private final LifecycleOwner k() {
        LifecycleOwner d16 = this.panelParam.a().d();
        Intrinsics.checkNotNullExpressionValue(d16, "panelParam.mAIOContext.lifecycleOwner");
        return d16;
    }

    private final void q() {
        final boolean z16;
        if (com.tencent.guild.aio.util.ex.a.d(this.panelParam.a()) != FromScene.DIRECT.ordinal()) {
            z16 = true;
        } else {
            z16 = false;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.guild.aio.panel.photo.g
            @Override // java.lang.Runnable
            public final void run() {
                GuildPhotoPanelVM.r(z16, this);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(boolean z16, GuildPhotoPanelVM this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((INTGuildAlbumApi) QRoute.api(INTGuildAlbumApi.class)).queryMediaTaskNew(z16, new GuildPhotoPanelVM$queryMediaTask$1$1(this$0));
    }

    private final void t(c.b intent) {
        u(new GuildPhotoPanelDragAnimateEvent.AnimateEvent(intent.getShow(), intent.getRatio()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(MsgIntent message) {
        this.panelParam.a().e().h(message);
    }

    private final k v(MsgIntent message) {
        return this.panelParam.a().e().k(message);
    }

    private final void w() {
        List<GuildPickPhotoResult> h16 = this.repository.h();
        if (h16.isEmpty()) {
            return;
        }
        if (com.tencent.guild.aio.util.ex.a.k(this.panelParam.a())) {
            QQToast.makeText(BaseApplication.getContext(), R.string.f156871ld, 0).show();
        } else {
            u(new GuildMsgSendEvent.MediaSendEvent(h16, true, false));
            this.repository.e();
        }
    }

    private final void x(com.tencent.guild.api.media.album.e tag) {
        this.repository.t(tag);
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.d.f261782e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "GuildPhotoPanelVM_sendSingleMediaInfo", Boolean.FALSE, null, null, new GuildPhotoPanelVM$sendSingleMediaInfo$1(this, tag, null), 12, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(final List<? extends com.tencent.guild.api.media.album.e> tag) {
        PostUtilKt.b(new Function0<Unit>() { // from class: com.tencent.guild.aio.panel.photo.GuildPhotoPanelVM$setLocalMediaList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                GuildPhotoPanelVM.this.getRepository().y(tag);
                GuildPhotoPanelVM guildPhotoPanelVM = GuildPhotoPanelVM.this;
                guildPhotoPanelVM.z(new GuildPhotoPanelUIState.RefreshUI(tag, guildPhotoPanelVM.getRepository().getMQuality()));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(final GuildPhotoPanelUIState state) {
        PostUtilKt.b(new Function0<Unit>() { // from class: com.tencent.guild.aio.panel.photo.GuildPhotoPanelVM$updateUI$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MutableLiveData mutableLiveData;
                mutableLiveData = GuildPhotoPanelVM.this.mUiState;
                mutableLiveData.setValue(state);
            }
        });
    }

    public final long f() {
        Iterator<T> it = m().iterator();
        long j3 = 0;
        while (it.hasNext()) {
            j3 += ((com.tencent.guild.api.media.album.e) it.next()).getFileSize();
        }
        return j3;
    }

    public final boolean g(@NotNull com.tencent.guild.api.media.album.e info) {
        Object first;
        int i3;
        Intrinsics.checkNotNullParameter(info, "info");
        if (!m().isEmpty()) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) m());
            if (((com.tencent.guild.api.media.album.e) first).getType() != info.getType()) {
                return false;
            }
            if (info.getType() == com.tencent.guild.api.media.album.c.b()) {
                i3 = 1;
            } else {
                i3 = 9;
            }
            if (m().size() < i3) {
                return true;
            }
            return false;
        }
        return true;
    }

    public final void h() {
        CoroutineScopeKt.cancel$default(this.dataUpdateCoroutine, null, 1, null);
        this.mAIOContext.e().b(Reflection.getOrCreateKotlinClass(PanelStatusIntent.PanelStatusChangeIntent.class).getQualifiedName(), this.mAction1);
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final GuildAIOMediasRepository getRepository() {
        return this.repository;
    }

    @NotNull
    public final List<com.tencent.guild.api.media.album.e> m() {
        return this.repository.k();
    }

    public final void n(@NotNull MsgIntent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof PanelStatusIntent.PanelStatusChangeIntent) {
            u(new GuildPhotoPanelDragAnimateEvent.AnimateEvent(false, 0.0f));
        }
    }

    public final void o(@NotNull ol3.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof c.f) {
            q();
            return;
        }
        if (intent instanceof c.a) {
            this.repository.d(((c.a) intent).getInfo());
            return;
        }
        if (intent instanceof c.g) {
            this.repository.t(((c.g) intent).getInfo());
            return;
        }
        if (intent instanceof c.h) {
            w();
            return;
        }
        if (intent instanceof c.e) {
            this.repository.v(((c.e) intent).getCom.tencent.hippy.qq.adapter.image.CustomImageProps.QUALITY java.lang.String());
            return;
        }
        if (intent instanceof c.i) {
            x(((c.i) intent).getInfo());
            return;
        }
        if (intent instanceof c.b) {
            t((c.b) intent);
        } else if (intent instanceof c.C1208c) {
            i();
        } else if (intent instanceof c.d) {
            j((c.d) intent);
        }
    }

    public final void p(@NotNull Observer<GuildPhotoPanelUIState> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mUiState.observe(k(), observer);
    }

    public final boolean s() {
        Object obj;
        boolean z16;
        Iterator<T> it = m().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                com.tencent.guild.api.media.album.e eVar = (com.tencent.guild.api.media.album.e) obj;
                if (eVar.getType() == com.tencent.guild.api.media.album.c.a() && eVar.getFileSize() > this.sizeLimit) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (obj != null) {
            return true;
        }
        return false;
    }
}
