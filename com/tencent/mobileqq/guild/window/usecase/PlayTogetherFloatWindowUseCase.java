package com.tencent.mobileqq.guild.window.usecase;

import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.mobileqq.guild.media.core.data.r;
import com.tencent.mobileqq.guild.media.thirdapp.container.RemoteRenderHelper;
import com.tencent.mobileqq.guild.media.thirdapp.container.report.GuildMediaWebJsReportTask;
import com.tencent.mobileqq.guild.media.thirdapp.container.webview.GuildMediaWebIPCServer;
import com.tencent.mobileqq.guild.u;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.window.GuildPlayTogetherFloatWrapper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyAppInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProLobbyStateInfo;
import com.tencent.mobileqq.remoteweb.RemoteWebRenderIPCServer;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 92\u00020\u0001:\u0001:B\u001f\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u00104\u001a\u000203\u0012\u0006\u00106\u001a\u000205\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\u001a\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J\u0006\u0010\u0014\u001a\u00020\u0002J\u0006\u0010\u0015\u001a\u00020\u0002J0\u0010\u001c\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001d\u001a\u00020\fH\u0014J \u0010 \u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\fH\u0016R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/guild/window/usecase/PlayTogetherFloatWindowUseCase;", "Lcom/tencent/mobileqq/guild/window/usecase/e;", "", "b0", "", "isVisible", "g0", "e0", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProLobbyStateInfo;", "appRoomStatusInfo", "d0", "m0", "", "webPageId", "Landroid/view/Surface;", "surface", "i0", "Landroid/view/ViewGroup;", "customView", "L", "l0", "a0", "guildId", "channelId", "Lcom/tencent/mobileqq/guild/media/core/data/f;", "localUserInfo", "Lcom/tencent/mobileqq/guild/media/core/data/r;", "userInfoList", "j", "v", "roomId", "reason", "i", "Landroid/widget/TextView;", DomainData.DOMAIN_NAME, "Landroid/widget/TextView;", "mPlayStatusTv", "o", "Landroid/view/ViewGroup;", "mPlayStatusWrapper", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/RemoteRenderHelper;", "p", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/RemoteRenderHelper;", "remoteRenderHelper", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljava/lang/String;", "r", "Z", "isDestroy", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "Lcom/tencent/mobileqq/guild/window/GuildPlayTogetherFloatWrapper;", "wrapper", "<init>", "(Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;Lcom/tencent/mobileqq/guild/window/GuildPlayTogetherFloatWrapper;)V", ReportConstant.COSTREPORT_PREFIX, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class PlayTogetherFloatWindowUseCase extends e {

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private TextView mPlayStatusTv;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mPlayStatusWrapper;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RemoteRenderHelper remoteRenderHelper;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String webPageId;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private boolean isDestroy;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayTogetherFloatWindowUseCase(@NotNull IGProGuildInfo guildInfo, @NotNull IGProChannelInfo channelInfo, @NotNull GuildPlayTogetherFloatWrapper wrapper) {
        super(guildInfo, channelInfo, wrapper);
        Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        Intrinsics.checkNotNullParameter(wrapper, "wrapper");
        this.remoteRenderHelper = new RemoteRenderHelper(0, 0, 3, null);
        this.webPageId = "";
    }

    private final void b0() {
        Logger.f235387a.d().d("QGMC.MediaThirdApp.PlayFloatWindowUseCase", 1, "destroyReaderView webPageId " + this.webPageId);
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.window.usecase.j
            @Override // java.lang.Runnable
            public final void run() {
                PlayTogetherFloatWindowUseCase.c0(PlayTogetherFloatWindowUseCase.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(PlayTogetherFloatWindowUseCase this$0) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.webPageId.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            RemoteWebRenderIPCServer.k0(RemoteWebRenderIPCServer.INSTANCE.a(), this$0.webPageId, null, 0, 0, null, 28, null);
            this$0.webPageId = "";
            this$0.remoteRenderHelper.h();
        }
    }

    private final boolean d0(IGProLobbyStateInfo appRoomStatusInfo) {
        int i3;
        if (appRoomStatusInfo != null) {
            i3 = appRoomStatusInfo.getLobbyRoomStatus();
        } else {
            i3 = 0;
        }
        if (i3 != 0 && i3 != 1) {
            return false;
        }
        return true;
    }

    private final void e0(final boolean isVisible) {
        Logger.f235387a.d().d("QGMC.MediaThirdApp.PlayFloatWindowUseCase", 1, "notifyFloatWindowVisible webPageId " + this.webPageId + ", isVisible " + isVisible);
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.window.usecase.i
            @Override // java.lang.Runnable
            public final void run() {
                PlayTogetherFloatWindowUseCase.f0(PlayTogetherFloatWindowUseCase.this, isVisible);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(PlayTogetherFloatWindowUseCase this$0, boolean z16) {
        boolean z17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.webPageId.length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            GuildMediaWebJsReportTask webJsReportTask = com.tencent.mobileqq.guild.media.core.j.a().d0().getWebJsReportTask();
            if (webJsReportTask != null) {
                webJsReportTask.m(z16);
            }
            GuildMediaWebIPCServer.INSTANCE.a().m(z16);
        }
    }

    private final void g0(final boolean isVisible) {
        Logger.f235387a.d().d("QGMC.MediaThirdApp.PlayFloatWindowUseCase", 1, "notifyVisibility webPageId " + this.webPageId + ", isVisible " + isVisible);
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.window.usecase.m
            @Override // java.lang.Runnable
            public final void run() {
                PlayTogetherFloatWindowUseCase.h0(PlayTogetherFloatWindowUseCase.this, isVisible);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(PlayTogetherFloatWindowUseCase this$0, boolean z16) {
        boolean z17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.webPageId.length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            RemoteWebRenderIPCServer.INSTANCE.a().U(this$0.webPageId, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0(String webPageId, Surface surface) {
        RemoteWebRenderIPCServer.k0(RemoteWebRenderIPCServer.INSTANCE.a(), webPageId, surface, 0, 0, new EIPCResultCallback() { // from class: com.tencent.mobileqq.guild.window.usecase.k
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                PlayTogetherFloatWindowUseCase.j0(PlayTogetherFloatWindowUseCase.this, eIPCResult);
            }
        }, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(final PlayTogetherFloatWindowUseCase this$0, final EIPCResult eIPCResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.f235387a.d().d("QGMC.MediaThirdApp.PlayFloatWindowUseCase", 1, "switchSurface result " + eIPCResult.code + ", error: " + eIPCResult.f396321e);
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.window.usecase.l
            @Override // java.lang.Runnable
            public final void run() {
                PlayTogetherFloatWindowUseCase.k0(EIPCResult.this, this$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(EIPCResult eIPCResult, PlayTogetherFloatWindowUseCase this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (eIPCResult.isSuccess()) {
            this$0.g0(false);
        } else {
            this$0.b0();
        }
    }

    private final void m0() {
        boolean z16;
        String E1 = com.tencent.mobileqq.guild.media.core.j.a().d0().E1();
        this.webPageId = E1;
        if (E1.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        GuildMediaWebIPCServer.INSTANCE.a().i(this.webPageId, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.window.usecase.PlayTogetherFloatWindowUseCase$updateSurface$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z17) {
                RemoteRenderHelper remoteRenderHelper;
                Logger.f235387a.d().d("QGMC.MediaThirdApp.PlayFloatWindowUseCase", 1, "checkIfAttach result " + z17);
                if (z17) {
                    PlayTogetherFloatWindowUseCase playTogetherFloatWindowUseCase = PlayTogetherFloatWindowUseCase.this;
                    String str = playTogetherFloatWindowUseCase.webPageId;
                    remoteRenderHelper = PlayTogetherFloatWindowUseCase.this.remoteRenderHelper;
                    playTogetherFloatWindowUseCase.i0(str, remoteRenderHelper.k());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.window.usecase.e
    public void L(@NotNull ViewGroup customView) {
        Intrinsics.checkNotNullParameter(customView, "customView");
        Logger.f235387a.d().i("QGMC.MediaThirdApp.PlayFloatWindowUseCase", 1, "setupView");
        super.L(customView);
        View findViewById = customView.findViewById(R.id.f25700bj);
        Intrinsics.checkNotNullExpressionValue(findViewById, "customView.findViewById(\u2026.play_together_status_tv)");
        this.mPlayStatusTv = (TextView) findViewById;
        View findViewById2 = customView.findViewById(R.id.f25710bk);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "customView.findViewById(\u2026_together_status_wrapper)");
        this.mPlayStatusWrapper = (ViewGroup) findViewById2;
        m0();
        l0();
        e0(true);
    }

    public final void a0() {
        if (this.isDestroy) {
            return;
        }
        Logger.f235387a.d().d("QGMC.MediaThirdApp.PlayFloatWindowUseCase", 1, "[destroy] ");
        this.isDestroy = true;
        e0(false);
        b0();
    }

    @Override // com.tencent.mobileqq.guild.window.usecase.g
    public void i(@NotNull String guildId, @NotNull String roomId, @NotNull String reason) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        Intrinsics.checkNotNullParameter(reason, "reason");
        super.i(guildId, roomId, reason);
        Logger.f235387a.d().d("QGMC.MediaThirdApp.PlayFloatWindowUseCase", 1, "onExit");
        a0();
    }

    @Override // com.tencent.mobileqq.guild.window.usecase.e, com.tencent.mobileqq.guild.window.usecase.g
    public void j(@Nullable String guildId, @Nullable String channelId, @Nullable com.tencent.mobileqq.guild.media.core.data.f localUserInfo, @Nullable r userInfoList) {
        String str;
        if (userInfoList == null) {
            return;
        }
        IGProLobbyAppInfo thirdAppInfo = com.tencent.mobileqq.guild.media.core.j.a().d0().getThirdAppInfo();
        if (thirdAppInfo != null) {
            str = thirdAppInfo.getIconUrl();
        } else {
            str = null;
        }
        if (com.tencent.mobileqq.guild.media.core.m.a(com.tencent.mobileqq.guild.media.core.j.c())) {
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("QGMC.MediaThirdApp.PlayFloatWindowUseCase", "[onTRTCUserVoiceVolumeUpdate] disableVoiceAnim");
            }
            u.q(str, x(), true);
            return;
        }
        super.j(guildId, channelId, localUserInfo, userInfoList);
        List<p> list = userInfoList.f228125a;
        Intrinsics.checkNotNullExpressionValue(list, "userInfoList.anchors");
        Iterator<T> it = list.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            if (((p) it.next()).f228101i) {
                z16 = true;
            }
        }
        if (!z16) {
            if (!TextUtils.isEmpty(str)) {
                u.q(str, x(), true);
                return;
            }
            Logger logger2 = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("iconUrl is empty");
            Iterator<T> it5 = bVar.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e("QGMC.MediaThirdApp.PlayFloatWindowUseCase", 1, (String) it5.next(), null);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.view.ViewGroup] */
    public final void l0() {
        int i3;
        int i16;
        int i17;
        IGProLobbyStateInfo lobbyRoomInfo = com.tencent.mobileqq.guild.media.core.j.a().d0().getLobbyRoomInfo();
        if (lobbyRoomInfo != null) {
            i3 = lobbyRoomInfo.getLobbyRoomStatus();
        } else {
            i3 = 0;
        }
        if (lobbyRoomInfo != null) {
            i16 = lobbyRoomInfo.getLobbyRoomCurrUserNum();
        } else {
            i16 = 0;
        }
        if (lobbyRoomInfo != null) {
            i17 = lobbyRoomInfo.getLobbyRoomCapacity();
        } else {
            i17 = 0;
        }
        Logger.f235387a.d().i("QGMC.MediaThirdApp.PlayFloatWindowUseCase", 1, "updateRoomState roomState: " + i3 + " | currentNum: " + i16 + " | this.currentNum: " + i16 + " | maxNum: " + i17);
        TextView textView = null;
        if (d0(lobbyRoomInfo)) {
            ViewGroup viewGroup = this.mPlayStatusWrapper;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayStatusWrapper");
                viewGroup = null;
            }
            viewGroup.setVisibility(0);
            TextView textView2 = this.mPlayStatusTv;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayStatusTv");
            } else {
                textView = textView2;
            }
            textView.setText("\u7ec4\u961f\u4e2d");
            return;
        }
        ?? r06 = this.mPlayStatusWrapper;
        if (r06 == 0) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayStatusWrapper");
        } else {
            textView = r06;
        }
        textView.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.guild.window.usecase.e
    @NotNull
    protected String v() {
        String str;
        IGProLobbyAppInfo thirdAppInfo = com.tencent.mobileqq.guild.media.core.j.a().d0().getThirdAppInfo();
        if (thirdAppInfo != null) {
            str = thirdAppInfo.getIconUrl();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }
}
