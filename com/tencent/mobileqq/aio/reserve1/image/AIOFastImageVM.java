package com.tencent.mobileqq.aio.reserve1.image;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import at.d;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.base.mvi.part.Reserve1UIState;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.reserve1.image.AIOFastImageMsgIntent;
import com.tencent.mobileqq.aio.reserve1.image.AIOFastImageUIState;
import com.tencent.mobileqq.aio.reserve1.image.a;
import com.tencent.mobileqq.album.api.IAlbumApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.j;
import com.tencent.qqnt.photopanel.api.IPhotoPanelApi;
import com.tencent.qqnt.qbasealbum.model.AlbumResult;
import com.tencent.qqnt.qbasealbum.model.Config;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.model.PreviewInitBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b*\u0001\u0019\b\u0007\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001%B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0016\u0010\f\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\nH\u0002J\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0006H\u0016R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR&\u0010!\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00190\u001d0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/image/AIOFastImageVM;", "Lcom/tencent/qqnt/aio/lazy/lazyInit/b;", "Lat/d;", "Lcom/tencent/aio/base/mvi/part/Reserve1UIState;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "E", "p", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "imageList", "r", "recentImage", ReportConstant.COSTREPORT_PREFIX, "Landroid/content/Intent;", "result", "u", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", "initMsgIntent", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "com/tencent/mobileqq/aio/reserve1/image/AIOFastImageVM$b", "f", "Lcom/tencent/mobileqq/aio/reserve1/image/AIOFastImageVM$b;", "mAction", "Lkotlin/Pair;", "", h.F, "Ljava/util/List;", "mMsgList", "<init>", "(Lcom/tencent/mvi/base/route/MsgIntent;)V", "i", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes11.dex */
public final class AIOFastImageVM extends com.tencent.qqnt.aio.lazy.lazyInit.b<d, Reserve1UIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Pair<String, b>> mMsgList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/image/AIOFastImageVM$a;", "", "", "CACHE_IMAGE", "Ljava/lang/String;", "", "PIC_TIME_INTERVAL", "I", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.reserve1.image.AIOFastImageVM$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/reserve1/image/AIOFastImageVM$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOFastImageVM.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                AIOFastImageVM.this.E(i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return a.C9235a.a(this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64713);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOFastImageVM(@NotNull MsgIntent initMsgIntent) {
        super(initMsgIntent);
        List<Pair<String, b>> listOf;
        Intrinsics.checkNotNullParameter(initMsgIntent, "initMsgIntent");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) initMsgIntent);
            return;
        }
        b bVar = new b();
        this.mAction = bVar;
        j jVar = j.f352301a;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOFastImageMsgIntent.QueryFastImageIntent.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOFastImageMsgIntent.RemoveFastImageIntent.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOFastImageMsgIntent.OnPanelStateChangedMsgIntent.class)), bVar)});
        this.mMsgList = listOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent intent) {
        if (QLog.isColorLevel()) {
            QLog.i("fast_image  AIOFastImageVM", 2, "intent: " + intent);
        }
        if (intent instanceof AIOFastImageMsgIntent.QueryFastImageIntent) {
            p();
            return;
        }
        if (intent instanceof AIOFastImageMsgIntent.RemoveFastImageIntent) {
            updateUI(AIOFastImageUIState.RemoveFastImage.f193264d);
        } else if ((intent instanceof AIOFastImageMsgIntent.OnPanelStateChangedMsgIntent) && !((AIOFastImageMsgIntent.OnPanelStateChangedMsgIntent) intent).a()) {
            QLog.i("fast_image  AIOFastImageVM", 1, "panel is closed");
            updateUI(AIOFastImageUIState.RemoveFastImage.f193264d);
        }
    }

    private final void p() {
        QRouteApi api = QRoute.api(IAlbumApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAlbumApi::class.java)");
        IAlbumApi.a.a((IAlbumApi) api, vmScope(), null, new Function1<List<? extends LocalMediaInfo>, Unit>() { // from class: com.tencent.mobileqq.aio.reserve1.image.AIOFastImageVM$getRecentImage$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOFastImageVM.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends LocalMediaInfo> list) {
                invoke2((List<LocalMediaInfo>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<LocalMediaInfo> it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                } else {
                    Intrinsics.checkNotNullParameter(it, "it");
                    AIOFastImageVM.this.r(it);
                }
            }
        }, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(List<LocalMediaInfo> imageList) {
        boolean contains$default;
        if (imageList.isEmpty()) {
            return;
        }
        LocalMediaInfo localMediaInfo = imageList.get(0);
        if (!com.tencent.qqnt.qbasealbum.ktx.b.n(localMediaInfo)) {
            if (QLog.isColorLevel()) {
                QLog.i("fast_image  AIOFastImageVM", 1, "recent is not image");
                return;
            }
            return;
        }
        if (System.currentTimeMillis() - (localMediaInfo.getAddedDate() * 1000) > 120000) {
            QLog.i("fast_image  AIOFastImageVM", 1, "spentTime > PIC_TIME_INTERVAL");
            return;
        }
        String path = localMediaInfo.getPath();
        if (path != null) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) path, (CharSequence) "/tencent/zebra/cache/", false, 2, (Object) null);
            if (contains$default) {
                QLog.d("fast_image  AIOFastImageVM", 1, "queryFastImage has cached");
                return;
            }
            AlbumMMKVUtil albumMMKVUtil = AlbumMMKVUtil.f193278a;
            if (Intrinsics.areEqual(path, albumMMKVUtil.b())) {
                if (QLog.isColorLevel()) {
                    QLog.i("fast_image  AIOFastImageVM", 2, "queryFastImage has showed");
                    return;
                }
                return;
            }
            albumMMKVUtil.c(path);
        }
        updateUI(new AIOFastImageUIState.ShowFastImage(((IAlbumApi) QRoute.api(IAlbumApi.class)).generateAlbumThumbURL(localMediaInfo), localMediaInfo));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void s(LocalMediaInfo recentImage) {
        boolean z16;
        boolean z17;
        ArrayList<LocalMediaInfo> arrayListOf;
        ArrayList<LocalMediaInfo> arrayListOf2;
        int e16 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e();
        com.tencent.qqnt.qbasealbum.a aVar = com.tencent.qqnt.qbasealbum.a.f360732a;
        Context requireContext = ((com.tencent.aio.api.runtime.a) getMContext()).c().requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "mContext.fragment.requireContext()");
        Config.Companion companion = Config.INSTANCE;
        Config.a aVar2 = new Config.a();
        aVar2.e(e16);
        if (e16 == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        aVar2.d(z16);
        if (e16 != 8) {
            z17 = true;
        } else {
            z17 = false;
        }
        aVar2.m(z17);
        Unit unit = Unit.INSTANCE;
        Config a16 = aVar2.a();
        PreviewInitBean.Companion companion2 = PreviewInitBean.INSTANCE;
        PreviewInitBean.a aVar3 = new PreviewInitBean.a();
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(recentImage);
        aVar3.b(arrayListOf);
        aVar3.d(recentImage.getIndex());
        arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(recentImage);
        aVar3.e(arrayListOf2);
        aVar3.c("FAST_IMAGE");
        Intent g16 = com.tencent.qqnt.qbasealbum.a.g(aVar, requireContext, a16, aVar3.a(), null, 8, null);
        ((IPhotoPanelApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IPhotoPanelApi.class)).fillIntentForJumpPreview(g16, (com.tencent.aio.api.runtime.a) getMContext());
        ((com.tencent.aio.api.runtime.a) getMContext()).f().a(g16, new ActivityResultCallback() { // from class: com.tencent.mobileqq.aio.reserve1.image.c
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                AIOFastImageVM.t(AIOFastImageVM.this, (ActivityResult) obj);
            }
        });
        updateUI(AIOFastImageUIState.RemoveFastImage.f193264d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(AIOFastImageVM this$0, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (activityResult.getResultCode() != -1) {
            return;
        }
        this$0.u(activityResult.getData());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void u(Intent result) {
        final AlbumResult albumResult;
        List<LocalMediaInfo> e16;
        List listOf;
        if (result != null) {
            albumResult = (AlbumResult) result.getParcelableExtra("ALBUM_RESULT");
        } else {
            albumResult = null;
        }
        if (albumResult != null && (e16 = albumResult.e()) != null) {
            ox3.a.c("fast_image  AIOFastImageVM", new Function0<String>() { // from class: com.tencent.mobileqq.aio.reserve1.image.AIOFastImageVM$onAlbumResult$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AlbumResult.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "needSend: " + AlbumResult.this.b();
                }
            });
            if (albumResult.b() && (!e16.isEmpty())) {
                com.tencent.mvi.base.route.j e17 = ((com.tencent.aio.api.runtime.a) getMContext()).e();
                listOf = CollectionsKt__CollectionsJVMKt.listOf(com.tencent.mobileqq.album.media.b.c(e16.get(0), null, null, 3, null));
                e17.h(new AIOMsgSendEvent.SendAlbumMediaEvent(listOf, albumResult.g(), albumResult.f()));
                ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelContainerMsgIntent.HideAllPanelAndKeyboardMsgIntent("AIOBubbleMsgItemVM", false, 2, null));
            }
        }
    }

    @Override // com.tencent.qqnt.aio.lazy.lazyInit.b
    public void l(@NotNull MsgIntent initMsgIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) initMsgIntent);
        } else {
            Intrinsics.checkNotNullParameter(initMsgIntent, "initMsgIntent");
            E(initMsgIntent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onDestroy();
        Iterator<T> it = this.mMsgList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().b((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull d intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.C7349a) {
            s(((a.C7349a) intent).a());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        Iterator<T> it = this.mMsgList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().d((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
    }
}
