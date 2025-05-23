package mp0;

import android.view.View;
import com.tencent.guild.aio.input.GuildAioDefaultInputUIState;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.util.speaklimitstatus.GuildSpeakLimitStatus;
import com.tencent.mobileqq.guild.widget.GuildGuestBottomLayout;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import mp0.e;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0014\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u0016\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00140\u0013H\u0016R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lmp0/g;", "Lcom/tencent/aio/base/mvvm/a;", "Lmp0/e;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "", "permissions", "", "isJuBao", "", "g1", "e1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "c1", "state", "d1", "", "Ljava/lang/Class;", "getObserverStates", "Lcom/tencent/mobileqq/guild/widget/GuildGuestBottomLayout;", "d", "Lcom/tencent/mobileqq/guild/widget/GuildGuestBottomLayout;", "root", "<init>", "()V", "e", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class g extends com.tencent.aio.base.mvvm.a<e, GuildAioDefaultInputUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private GuildGuestBottomLayout root;

    private final void e1() {
        GuildGuestBottomLayout guildGuestBottomLayout = this.root;
        if (guildGuestBottomLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            guildGuestBottomLayout = null;
        }
        guildGuestBottomLayout.setJoinButtonClickListener(new View.OnClickListener() { // from class: mp0.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.f1(g.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(g this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("GuildAioInput.GuestView", 1, "addBtn onClicked");
        this$0.sendIntent(new e.a(this$0.getMContext()));
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        GuildGuestBottomLayout guildGuestBottomLayout = this$0.root;
        if (guildGuestBottomLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            guildGuestBottomLayout = null;
        }
        iGuildDTReportApi.setElementClickParams(guildGuestBottomLayout.a(), "em_sgrp_join_channel_subchannel", null);
        GuildGuestBottomLayout guildGuestBottomLayout2 = this$0.root;
        if (guildGuestBottomLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            guildGuestBottomLayout2 = null;
        }
        VideoReport.reportEvent("dt_clck", guildGuestBottomLayout2.a(), null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void g1(int permissions, boolean isJuBao) {
        int i3 = 8;
        GuildGuestBottomLayout guildGuestBottomLayout = null;
        if (isJuBao) {
            GuildGuestBottomLayout guildGuestBottomLayout2 = this.root;
            if (guildGuestBottomLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("root");
            } else {
                guildGuestBottomLayout = guildGuestBottomLayout2;
            }
            guildGuestBottomLayout.setVisibility(8);
            return;
        }
        boolean P = GuildSpeakLimitStatus.INSTANCE.P(permissions);
        GuildGuestBottomLayout guildGuestBottomLayout3 = this.root;
        if (guildGuestBottomLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
        } else {
            guildGuestBottomLayout = guildGuestBottomLayout3;
        }
        if (P) {
            i3 = 0;
        }
        guildGuestBottomLayout.setVisibility(i3);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<e, GuildAioDefaultInputUIState> getViewModel() {
        return new i();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GuildAioDefaultInputUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildAioDefaultInputUIState.GuildHandlerPermissionsChange) {
            GuildAioDefaultInputUIState.GuildHandlerPermissionsChange guildHandlerPermissionsChange = (GuildAioDefaultInputUIState.GuildHandlerPermissionsChange) state;
            g1(guildHandlerPermissionsChange.getPermissions(), guildHandlerPermissionsChange.getNeedHide());
        } else if (state instanceof GuildAioDefaultInputUIState.StyleUpdateEvent) {
            boolean isDarkMode = ((GuildAioDefaultInputUIState.StyleUpdateEvent) state).getIsDarkMode();
            GuildGuestBottomLayout guildGuestBottomLayout = this.root;
            if (guildGuestBottomLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("root");
                guildGuestBottomLayout = null;
            }
            guildGuestBottomLayout.setColorMode(isDarkMode ? 1 : 0);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends GuildAioDefaultInputUIState>> getObserverStates() {
        List<Class<? extends GuildAioDefaultInputUIState>> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(GuildAioDefaultInputUIState.GuildHandlerPermissionsChange.class);
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        GuildGuestBottomLayout guildGuestBottomLayout = new GuildGuestBottomLayout(createViewParams.a());
        this.root = guildGuestBottomLayout;
        guildGuestBottomLayout.setVisibility(8);
        e1();
        GuildGuestBottomLayout guildGuestBottomLayout2 = this.root;
        if (guildGuestBottomLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            return null;
        }
        return guildGuestBottomLayout2;
    }
}
