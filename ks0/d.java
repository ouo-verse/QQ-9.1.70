package ks0;

import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.msglist.checkbox.GuildMultiMsgManager;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guildlive.aio.input.GuildLiveAioInputUIState;
import com.tencent.guildlive.utils.GuildLiveLogUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildLiveChannelApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import fo0.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016\u00a8\u0006\u001e"}, d2 = {"Lks0/d;", "Lpn0/a;", "Lfo0/e;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/aio/api/runtime/emitter/a;", "", "r", "isMultiSelectMode", "", "t", ReportConstant.COSTREPORT_PREFIX, "u", "p", "o", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "onBackEvent", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "<init>", "()V", "f", "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class d extends pn0.a<e, InputUIState> implements com.tencent.aio.api.runtime.emitter.a {
    /* JADX WARN: Multi-variable type inference failed */
    private final void o() {
        GuildMultiMsgManager.INSTANCE.a().n(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())), false);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.GuildMultiSelectModeChangeEvent("GLAioInputMSVM", false));
        t(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void p() {
        List<GuildMsgItem> g16 = GuildMultiMsgManager.INSTANCE.a().g(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())));
        if (g16.isEmpty()) {
            QQToast.makeText(((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity(), R.string.f139010a4, 0).show();
        } else {
            zp0.b.f452962a.t((com.tencent.aio.api.runtime.a) getMContext(), g16);
            o();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean r() {
        return GuildMultiMsgManager.INSTANCE.a().i(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void s() {
        updateUI(new GuildLiveAioInputUIState.MultiSelectCountChanged(GuildMultiMsgManager.INSTANCE.a().f(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())))));
    }

    private final void t(boolean isMultiSelectMode) {
        GuildLiveLogUtil.INSTANCE.e("GLAioInputMSVM", "[onMultiSelectModeChanged] isMultiSelectMode = " + isMultiSelectMode);
        ((IGuildLiveChannelApi) QRoute.api(IGuildLiveChannelApi.class)).updateMultiSelectState(isMultiSelectMode);
        updateUI(new GuildLiveAioInputUIState.GuildMultiSelectState(isMultiSelectMode));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void u() {
        if (zp0.b.f452962a.w((com.tencent.aio.api.runtime.a) getMContext(), TVKEventId.PLAYER_STATE_SEEK_COMPLETE)) {
            o();
        }
    }

    @Override // pn0.a
    public void j(@NotNull MsgIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof GuildMsgListIntent.GuildMultiSelectModeChangeEvent) {
            t(((GuildMsgListIntent.GuildMultiSelectModeChangeEvent) intent).getIsSelectMode());
        } else if (intent instanceof GuildMsgListIntent.GuildMultiSelectCountChangeEvent) {
            s();
        }
    }

    @Override // pn0.a
    @NotNull
    public List<String> m() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectModeChangeEvent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectCountChangeEvent.class).getQualifiedName()});
        return listOf;
    }

    @Override // com.tencent.aio.api.runtime.emitter.a
    public boolean onBackEvent() {
        if (r()) {
            o();
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pn0.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        ((com.tencent.aio.api.runtime.a) getMContext()).b().a(com.tencent.aio.api.runtime.emitter.a.class).c(this);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull e intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof e.j) {
            u();
        } else if (intent instanceof e.h) {
            p();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pn0.a, com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        if (r()) {
            o();
        }
        t(r());
        ((com.tencent.aio.api.runtime.a) getMContext()).b().a(com.tencent.aio.api.runtime.emitter.a.class).a(this);
    }
}
