package np0;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.input.GuildAioDefaultInputUIState;
import com.tencent.guild.aio.input.GuildPermissionsChange;
import com.tencent.guild.aio.input.GuildPermissionsChangeWrapperMsgIntent;
import com.tencent.guild.aio.msglist.checkbox.GuildMultiMsgManager;
import com.tencent.mobileqq.guild.api.IGuildMuteApi;
import com.tencent.mobileqq.guild.util.speaklimitstatus.GuildSpeakLimitStatus;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import fo0.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010 \u00a8\u0006&"}, d2 = {"Lnp0/c;", "Lpn0/a;", "Lfo0/e;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "r", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "j", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "f", "Z", "isSelectMode", "", h.F, "I", "permissions", "Le12/a;", "", "i", "Le12/a;", "mMuteTimeLiveData", "Landroidx/lifecycle/Observer;", "Landroidx/lifecycle/Observer;", "mMuteTimeObserver", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c extends pn0.a<e, GuildAioDefaultInputUIState> {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isSelectMode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int permissions;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private e12.a<Long> mMuteTimeLiveData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Observer<Long> mMuteTimeObserver;

    /* JADX WARN: Multi-variable type inference failed */
    private final void p() {
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        String g17 = com.tencent.guild.aio.util.a.g(g16);
        AIOParam g18 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g18, "mContext.aioParam");
        String muteText = ((IGuildMuteApi) QRoute.api(IGuildMuteApi.class)).getMuteFormatHintTextInChannel(g17, com.tencent.guild.aio.util.a.b(g18));
        boolean L = GuildSpeakLimitStatus.INSTANCE.L(this.permissions);
        int i3 = this.permissions;
        Intrinsics.checkNotNullExpressionValue(muteText, "muteText");
        updateUI(new GuildAioDefaultInputUIState.GuildUpdateMuteChange(i3, muteText, this.isSelectMode, L));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void q() {
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        this.isSelectMode = GuildMultiMsgManager.INSTANCE.a().i(new GuildMultiMsgManager.d(com.tencent.guild.aio.util.a.b(g16), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())));
        AIOParam g17 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g17, "mContext.aioParam");
        String g18 = com.tencent.guild.aio.util.a.g(g17);
        AIOParam g19 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g19, "mContext.aioParam");
        this.permissions = fo0.h.a(g18, com.tencent.guild.aio.util.a.b(g19));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void r() {
        QLog.i("GuildAioInput.MuteVM", 1, "[initMuteTimeObserver] ");
        this.mMuteTimeObserver = new Observer() { // from class: np0.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                c.s(c.this, (Long) obj);
            }
        };
        IGuildMuteApi iGuildMuteApi = (IGuildMuteApi) QRoute.api(IGuildMuteApi.class);
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        e12.a<Long> selfGuildMuteLiveData = iGuildMuteApi.getSelfGuildMuteLiveData(com.tencent.guild.aio.util.a.g(g16));
        Intrinsics.checkNotNullExpressionValue(selfGuildMuteLiveData, "api(IGuildMuteApi::class\u2026xt.aioParam.getGuildId())");
        this.mMuteTimeLiveData = selfGuildMuteLiveData;
        Observer<Long> observer = null;
        if (selfGuildMuteLiveData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMuteTimeLiveData");
            selfGuildMuteLiveData = null;
        }
        LifecycleOwner d16 = ((com.tencent.aio.api.runtime.a) getMContext()).d();
        Observer<Long> observer2 = this.mMuteTimeObserver;
        if (observer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMuteTimeObserver");
        } else {
            observer = observer2;
        }
        selfGuildMuteLiveData.observe(d16, observer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void s(c this$0, Long l3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) this$0.getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        String g17 = com.tencent.guild.aio.util.a.g(g16);
        AIOParam g18 = ((com.tencent.aio.api.runtime.a) this$0.getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g18, "mContext.aioParam");
        GuildPermissionsChange guildPermissionsChange = new GuildPermissionsChange(fo0.h.a(g17, com.tencent.guild.aio.util.a.b(g18)));
        QLog.i("GuildAioInput.MuteVM", 1, "[handleIntent] permissions = " + guildPermissionsChange.getPermissions());
        ((com.tencent.aio.api.runtime.a) this$0.getMContext()).e().h(guildPermissionsChange);
    }

    @Override // pn0.a
    public void j(@NotNull MsgIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof GuildPermissionsChangeWrapperMsgIntent) {
            this.permissions = ((GuildPermissionsChangeWrapperMsgIntent) intent).getPermissions();
            p();
        } else if (intent instanceof GuildMsgListIntent.GuildMultiSelectModeChangeEvent) {
            this.isSelectMode = ((GuildMsgListIntent.GuildMultiSelectModeChangeEvent) intent).getIsSelectMode();
            p();
        }
    }

    @Override // pn0.a
    @NotNull
    public List<String> m() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{Reflection.getOrCreateKotlinClass(GuildPermissionsChangeWrapperMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectModeChangeEvent.class).getQualifiedName()});
        return listOf;
    }

    @Override // pn0.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        if (this.mMuteTimeLiveData != null) {
            QLog.i("GuildAioInput.MuteVM", 1, "[onDestroy] removeObserver");
            e12.a<Long> aVar = this.mMuteTimeLiveData;
            Observer<Long> observer = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMuteTimeLiveData");
                aVar = null;
            }
            Observer<Long> observer2 = this.mMuteTimeObserver;
            if (observer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMuteTimeObserver");
            } else {
                observer = observer2;
            }
            aVar.removeObserver(observer);
        }
    }

    @Override // pn0.a, com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        q();
        super.onCreate(context);
        r();
    }
}
