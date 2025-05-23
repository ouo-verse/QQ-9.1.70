package pp0;

import com.tencent.aio.data.AIOParam;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.input.GuildAioDefaultInputUIState;
import com.tencent.guild.aio.input.GuildPermissionsChangeWrapperMsgIntent;
import com.tencent.guild.aio.input.readonly.GuildAioInputReadOnlyUIState;
import com.tencent.guild.aio.msglist.checkbox.GuildMultiMsgManager;
import com.tencent.mobileqq.guild.util.speaklimitstatus.GuildSpeakLimitStatus;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
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
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u000e\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016R\u0016\u0010\u0019\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lpp0/b;", "Lpn0/a;", "Lfo0/e;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "", "o", "", "newPermissions", "r", "", "newIsMultiSelectMode", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "guildId", "p", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "j", "f", "Z", "isMultiSelectMode", h.F, "I", "permissions", "<init>", "()V", "i", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b extends pn0.a<e, GuildAioDefaultInputUIState> {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isMultiSelectMode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int permissions;

    /* JADX WARN: Multi-variable type inference failed */
    private final void o() {
        QLog.d("GuildAioInput.ReadOnlyVM", 1, "init");
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        q(GuildMultiMsgManager.INSTANCE.a().i(new GuildMultiMsgManager.d(com.tencent.guild.aio.util.a.b(g16), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext()))));
        AIOParam g17 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g17, "mContext.aioParam");
        String g18 = com.tencent.guild.aio.util.a.g(g17);
        AIOParam g19 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g19, "mContext.aioParam");
        r(fo0.h.a(g18, com.tencent.guild.aio.util.a.b(g19)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean p(String guildId) {
        if (!this.isMultiSelectMode) {
            GuildSpeakLimitStatus.Companion companion = GuildSpeakLimitStatus.INSTANCE;
            int i3 = this.permissions;
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (companion.n(i3, guildId, com.tencent.guild.aio.util.a.d(g16))) {
                return true;
            }
        }
        return false;
    }

    private final void q(boolean newIsMultiSelectMode) {
        this.isMultiSelectMode = newIsMultiSelectMode;
    }

    private final void r(int newPermissions) {
        this.permissions = newPermissions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pn0.a
    public void j(@NotNull MsgIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (QLog.isColorLevel()) {
            QLog.d("GuildAioInput.ReadOnlyVM", 1, "handleIntentAction " + intent);
        }
        if (intent instanceof GuildPermissionsChangeWrapperMsgIntent) {
            r(((GuildPermissionsChangeWrapperMsgIntent) intent).getPermissions());
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            updateUI(new GuildAioInputReadOnlyUIState.ShowReadOnlyView(p(com.tencent.guild.aio.util.a.g(g16)), this.permissions));
            return;
        }
        if (intent instanceof GuildMsgListIntent.GuildMultiSelectModeChangeEvent) {
            q(((GuildMsgListIntent.GuildMultiSelectModeChangeEvent) intent).getIsSelectMode());
            AIOParam g17 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g17, "mContext.aioParam");
            updateUI(new GuildAioInputReadOnlyUIState.ShowReadOnlyView(p(com.tencent.guild.aio.util.a.g(g17)), this.permissions));
        }
    }

    @Override // pn0.a
    @NotNull
    public List<String> m() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{Reflection.getOrCreateKotlinClass(GuildPermissionsChangeWrapperMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectModeChangeEvent.class).getQualifiedName()});
        return listOf;
    }

    @Override // pn0.a, com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        o();
        super.onCreate(context);
    }
}
