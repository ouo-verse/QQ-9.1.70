package com.tencent.guild.aio.component.album;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.base.route.msg.PanelMsg;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.part.root.panel.mvx.intent.PanelStatusIntent;
import com.tencent.aio.part.root.panel.mvx.result.a;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.component.album.GuildAioAlbumUIState;
import com.tencent.guild.aio.component.album.a;
import com.tencent.guild.aio.panel.photo.GuildPhotoPanelMsgIntent;
import com.tencent.guild.api.media.album.INTGuildAlbumApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildInfoUtilsApi;
import com.tencent.mobileqq.guild.util.qqui.g;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\t*\u0001\u0014\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0002H\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/guild/aio/component/album/GuildAioAlbumViewModel;", "Lcom/tencent/aio/base/mvvm/b;", "Lcom/tencent/guild/aio/component/album/a;", "Lcom/tencent/guild/aio/component/album/GuildAioAlbumUIState;", "", "size", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, DomainData.DOMAIN_NAME, "o", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aio/part/root/panel/mvx/intent/PanelStatusIntent$PanelStatusChangeIntent;", "intent", "r", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "p", "com/tencent/guild/aio/component/album/GuildAioAlbumViewModel$b", "d", "Lcom/tencent/guild/aio/component/album/GuildAioAlbumViewModel$b;", "mAction1", "<init>", "()V", "e", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildAioAlbumViewModel extends com.tencent.aio.base.mvvm.b<a, GuildAioAlbumUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction1 = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/component/album/GuildAioAlbumViewModel$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            if (i3 instanceof PanelStatusIntent.PanelStatusChangeIntent) {
                GuildAioAlbumViewModel.this.r((PanelStatusIntent.PanelStatusChangeIntent) i3);
            } else if (i3 instanceof GuildPhotoPanelMsgIntent.SelectMediaChanged) {
                GuildAioAlbumViewModel.this.q(((GuildPhotoPanelMsgIntent.SelectMediaChanged) i3).a().size());
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean m() {
        k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(PanelMsg.IsShowingPanelOrKeyboard.f69199d);
        Intrinsics.checkNotNull(k3, "null cannot be cast to non-null type com.tencent.aio.part.root.panel.mvx.result.PanelMsgResult.IsPanelShowResult");
        a.C0653a c0653a = (a.C0653a) k3;
        QLog.d("GuildAioEmojiViewModel", 4, "res: " + c0653a.a() + ", isKeyboardShow: " + c0653a.b());
        Integer a16 = c0653a.a();
        if (a16 != null && a16.intValue() == 1003) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void n() {
        FragmentActivity activity;
        Fragment c16 = ((com.tencent.aio.api.runtime.a) getMContext()).c();
        if (c16 != null && (activity = c16.getActivity()) != null) {
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            String g17 = com.tencent.guild.aio.util.a.g(g16);
            if (fo0.b.c((com.tencent.aio.api.runtime.a) getMContext())) {
                QLog.i("GuildFileAppInfo", 1, "checkIsGuestInputModeAndPopTip");
                return;
            }
            if (!((IGuildInfoUtilsApi) QRoute.api(IGuildInfoUtilsApi.class)).isSafetySwitchOpen(g17, 8)) {
                g.c(0, R.string.f155071gi);
            } else if (m()) {
                ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelMsg.HideAllPanelAndKeyboard("GuildAioAlbumViewModel", false, 2, null));
            } else {
                ((INTGuildAlbumApi) QRoute.api(INTGuildAlbumApi.class)).checkAIOAlbumPermission(activity, new Function0<Unit>() { // from class: com.tencent.guild.aio.component.album.GuildAioAlbumViewModel$handleAlbumToggle$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ((com.tencent.aio.api.runtime.a) GuildAioAlbumViewModel.this.getMContext()).e().h(new PanelMsg.ShowPanel("GuildAioPlusViewModel", 1003, false, 4, null));
                    }
                });
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void o() {
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        updateUI(new GuildAioAlbumUIState.AlbumSafetySwitch(((IGuildInfoUtilsApi) QRoute.api(IGuildInfoUtilsApi.class)).isSafetySwitchOpen(com.tencent.guild.aio.util.a.g(g16), 8)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(int size) {
        updateUI(new GuildAioAlbumUIState.AlbumNumState(size));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(PanelStatusIntent.PanelStatusChangeIntent intent) {
        boolean z16;
        Integer a16 = intent.a();
        if (a16 != null && a16.intValue() == 1003) {
            z16 = true;
        } else {
            z16 = false;
        }
        updateUI(new GuildAioAlbumUIState.AlbumPanelState(z16));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(PanelStatusIntent.PanelStatusChangeIntent.class).getQualifiedName(), this.mAction1);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildPhotoPanelMsgIntent.SelectMediaChanged.class).getQualifiedName(), this.mAction1);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.C1179a) {
            n();
        } else if (intent instanceof a.b) {
            o();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(PanelStatusIntent.PanelStatusChangeIntent.class).getQualifiedName(), this.mAction1);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildPhotoPanelMsgIntent.SelectMediaChanged.class).getQualifiedName(), this.mAction1);
    }
}
