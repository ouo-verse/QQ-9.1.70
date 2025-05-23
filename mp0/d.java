package mp0;

import android.app.Activity;
import android.content.Context;
import com.tencent.aio.data.AIOParam;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.input.GuildAioDefaultInputUIState;
import com.tencent.guild.aio.input.GuildPermissionsChangeWrapperMsgIntent;
import com.tencent.guild.aio.msglist.checkbox.GuildMultiMsgManager;
import com.tencent.guild.api.channel.IGuildChannelApi;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.speaklimitstatus.GuildSpeakLimitStatus;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mp0.a;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0002H\u0016R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lmp0/d;", "Lpn0/a;", "Lmp0/a;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/content/Context;", "context", "", "o", "Lcom/tencent/aio/api/runtime/a;", "onCreate", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "j", "p", "", "f", "I", "permissions", "<init>", "()V", tl.h.F, "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class d extends pn0.a<a, GuildAioDefaultInputUIState> {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int permissions;

    private final void o(Context context) {
        Activity activity;
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null) {
            String faceAuthVerifyUrl = ((IGuildChannelApi) QRoute.api(IGuildChannelApi.class)).getFaceAuthVerifyUrl();
            QLog.e("GuildAioInputGuestFaceAuthVM", 1, "handleAuthJumpClick verifyUrl=" + faceAuthVerifyUrl);
            ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).startH5Activity(activity, faceAuthVerifyUrl);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean q() {
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        return GuildMultiMsgManager.INSTANCE.a().i(new GuildMultiMsgManager.d(com.tencent.guild.aio.util.a.b(g16), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean r() {
        return ((IGuildChannelApi) QRoute.api(IGuildChannelApi.class)).isInLiveChannel(((com.tencent.aio.api.runtime.a) getMContext()).g().n());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pn0.a
    public void j(@NotNull MsgIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        boolean z16 = true;
        boolean z17 = false;
        if (intent instanceof GuildPermissionsChangeWrapperMsgIntent) {
            int permissions = ((GuildPermissionsChangeWrapperMsgIntent) intent).getPermissions();
            this.permissions = permissions;
            GuildSpeakLimitStatus.Companion companion = GuildSpeakLimitStatus.INSTANCE;
            if (!companion.L(permissions) || q()) {
                z16 = false;
            }
            if (!companion.r(this.permissions) || (r() && !companion.O(this.permissions))) {
                z17 = z16;
            }
            updateUI(new GuildAioDefaultInputUIState.GuildGuestAuthTipVisibleChange(z17, com.tencent.guild.aio.util.ex.a.a((com.tencent.aio.api.runtime.a) getMContext())));
            return;
        }
        if (intent instanceof GuildMsgListIntent.GuildMultiSelectModeChangeEvent) {
            GuildSpeakLimitStatus.Companion companion2 = GuildSpeakLimitStatus.INSTANCE;
            if (!companion2.L(this.permissions) || q()) {
                z16 = false;
            }
            if (!companion2.r(this.permissions) || (r() && !companion2.O(this.permissions))) {
                z17 = z16;
            }
            updateUI(new GuildAioDefaultInputUIState.GuildGuestAuthTipVisibleChange(z17, com.tencent.guild.aio.util.ex.a.a((com.tencent.aio.api.runtime.a) getMContext())));
        }
    }

    @Override // pn0.a
    @NotNull
    public List<String> m() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{Reflection.getOrCreateKotlinClass(GuildPermissionsChangeWrapperMsgIntent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectModeChangeEvent.class).getQualifiedName()});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.C10798a) {
            o(((a.C10798a) intent).getContext());
        }
    }

    @Override // pn0.a, com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        updateUI(new GuildAioDefaultInputUIState.StyleUpdateEvent(r()));
    }
}
