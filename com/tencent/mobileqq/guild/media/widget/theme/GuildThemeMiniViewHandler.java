package com.tencent.mobileqq.guild.media.widget.theme;

import android.content.Context;
import android.content.DialogInterface;
import androidx.annotation.StringRes;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.media.core.notify.ScreenShareActionEvent;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.mini.api.IContainerViewCallback;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameRoomStateInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSpeakModeCfg;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u0016B\u0015\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\u0012\u0010\u000e\u001a\u00020\u00052\b\b\u0001\u0010\r\u001a\u00020\u0002H\u0002J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fR\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/theme/GuildThemeMiniViewHandler;", "Lcom/tencent/mobileqq/mini/api/IContainerViewCallback;", "", "type", "Lkotlin/Function0;", "", "handler", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", tl.h.F, "r", "l", "j", "alertStringRes", ReportConstant.COSTREPORT_PREFIX, "", "jsonString", "onMiniViewResult", "actionValue", "i", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/guild/media/widget/theme/GuildMediaThemeChooseDialog;", "a", "Lmqq/util/WeakReference;", "dialog", "<init>", "(Lmqq/util/WeakReference;)V", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildThemeMiniViewHandler implements IContainerViewCallback {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<GuildMediaThemeChooseDialog> dialog;

    public GuildThemeMiniViewHandler(@NotNull WeakReference<GuildMediaThemeChooseDialog> dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        this.dialog = dialog;
    }

    private final boolean h() {
        com.tencent.mobileqq.guild.media.thirdapp.g gVar = com.tencent.mobileqq.guild.media.thirdapp.g.f229539a;
        int d16 = gVar.d();
        boolean z16 = false;
        if (d16 != -2) {
            if (d16 != -1) {
                if (d16 == 0) {
                    z16 = true;
                }
            } else {
                r();
            }
        } else {
            gVar.e();
        }
        Logger.f235387a.d().d("QGMC.PlayTogetherMiniAppPlugin", 1, "checkUserCanStartThirdApp permission " + z16);
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        Context context;
        IGProVoiceSpeakModeCfg voiceSpeakModeCfg;
        if (FastClickUtils.isFastDoubleClick("QGMC.GuildThemeMiniViewHandler")) {
            return;
        }
        com.tencent.mobileqq.guild.media.core.data.p h16 = com.tencent.mobileqq.guild.media.core.j.c().getUserInfoList().h();
        if (h16 != null) {
            if (Intrinsics.areEqual(com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo().f228093a, h16.f228093a)) {
                s(R.string.f1496812y);
            } else {
                s(R.string.f1496712x);
            }
            GuildMediaThemeChooseDialog guildMediaThemeChooseDialog = this.dialog.get();
            if (guildMediaThemeChooseDialog != null) {
                guildMediaThemeChooseDialog.dismissAllowingStateLoss();
                return;
            }
            return;
        }
        IGProChannelInfo channelInfo = com.tencent.mobileqq.guild.media.core.j.a().getChannelInfo();
        boolean z16 = false;
        if (channelInfo != null && (voiceSpeakModeCfg = channelInfo.getVoiceSpeakModeCfg()) != null && voiceSpeakModeCfg.getSpeakMode() == 2) {
            z16 = true;
        }
        if (z16) {
            GuildMediaThemeChooseDialog guildMediaThemeChooseDialog2 = this.dialog.get();
            if (guildMediaThemeChooseDialog2 != null) {
                context = guildMediaThemeChooseDialog2.getContext();
            } else {
                context = null;
            }
            DialogUtil.createCustomDialog(context, 230, (String) null, HardCodeUtil.qqStr(R.string.f14970130), HardCodeUtil.qqStr(R.string.f146610un), (String) null, (DialogInterface.OnClickListener) null, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.widget.theme.g
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GuildThemeMiniViewHandler.k(dialogInterface, i3);
                }
            }).show();
            GuildMediaThemeChooseDialog guildMediaThemeChooseDialog3 = this.dialog.get();
            if (guildMediaThemeChooseDialog3 != null) {
                guildMediaThemeChooseDialog3.dismissAllowingStateLoss();
                return;
            }
            return;
        }
        QLog.i("QGMC.GuildThemeMiniViewHandler", 1, "[onGameIconClicked] ");
        com.tencent.mobileqq.guild.media.core.j.a().d(2);
        GuildMediaThemeChooseDialog guildMediaThemeChooseDialog4 = this.dialog.get();
        if (guildMediaThemeChooseDialog4 != null) {
            guildMediaThemeChooseDialog4.dismissAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        if (FastClickUtils.isFastDoubleClick("QGMC.GuildThemeMiniViewHandler")) {
            return;
        }
        com.tencent.mobileqq.guild.media.core.l c16 = com.tencent.mobileqq.guild.media.core.j.c();
        int n3 = com.tencent.mobileqq.guild.media.core.m.n(c16);
        QLog.i("QGMC.GuildThemeMiniViewHandler", 1, "[onScreenShareClicked] current type: " + n3);
        if (n3 != 0 && n3 != 1) {
            com.tencent.mobileqq.guild.media.core.j.a().W().e(true);
            com.tencent.mobileqq.guild.media.core.j.a().d(1);
            GuildMediaThemeChooseDialog guildMediaThemeChooseDialog = this.dialog.get();
            if (guildMediaThemeChooseDialog != null) {
                guildMediaThemeChooseDialog.dismissAllowingStateLoss();
                return;
            }
            return;
        }
        com.tencent.mobileqq.guild.media.core.data.p h16 = c16.getUserInfoList().h();
        if (h16 == null) {
            com.tencent.mobileqq.guild.media.core.j.d().i(new ScreenShareActionEvent(true));
        } else if (Intrinsics.areEqual(h16.f228093a, c16.getSelfUserInfo().f228093a)) {
            s(R.string.f1500013t);
        } else {
            s(R.string.f1496712x);
        }
        GuildMediaThemeChooseDialog guildMediaThemeChooseDialog2 = this.dialog.get();
        if (guildMediaThemeChooseDialog2 != null) {
            guildMediaThemeChooseDialog2.dismissAllowingStateLoss();
        }
    }

    private final void m(int type, final Function0<Unit> handler) {
        if (com.tencent.mobileqq.guild.util.o.c("QGMC.GuildThemeMiniViewHandler")) {
            return;
        }
        Integer value = com.tencent.mobileqq.guild.media.core.j.c().T().getValue();
        Context context = null;
        if (value != null && value.intValue() == 2 && type != 2) {
            if (com.tencent.mobileqq.guild.media.core.j.c().o()) {
                IGProVoiceSmobaGameRoomStateInfo roomInfo = com.tencent.mobileqq.guild.media.core.j.c().n().getRoomInfo();
                Intrinsics.checkNotNull(roomInfo);
                if (roomInfo.getRoomState() == 3) {
                    BaseApplication baseApplication = BaseApplication.context;
                    QQToast.makeText(baseApplication, baseApplication.getString(R.string.f140000cs), 0).show();
                    return;
                }
            }
            QLog.i("QGMC.GuildThemeMiniViewHandler", 1, "[preProcessClick] show game dialog");
            GuildMediaThemeChooseDialog guildMediaThemeChooseDialog = this.dialog.get();
            if (guildMediaThemeChooseDialog != null) {
                context = guildMediaThemeChooseDialog.getContext();
            }
            DialogUtil.createCustomDialog(context, 230, null, BaseApplication.getContext().getString(R.string.f14936123), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.widget.theme.c
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GuildThemeMiniViewHandler.n(Function0.this, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.widget.theme.d
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GuildThemeMiniViewHandler.o(dialogInterface, i3);
                }
            }).show();
            return;
        }
        Integer value2 = com.tencent.mobileqq.guild.media.core.j.c().T().getValue();
        if (value2 != null && value2.intValue() == 6) {
            if (!h()) {
                QLog.i("QGMC.GuildThemeMiniViewHandler", 1, "[preProcessClick] block with lobby close check.");
                return;
            }
            QLog.i("QGMC.GuildThemeMiniViewHandler", 1, "[preProcessClick] show lobby third app dialog");
            GuildMediaThemeChooseDialog guildMediaThemeChooseDialog2 = this.dialog.get();
            if (guildMediaThemeChooseDialog2 != null) {
                context = guildMediaThemeChooseDialog2.getContext();
            }
            DialogUtil.createCustomDialog(context, 230, (String) null, BaseApplication.getContext().getText(R.string.f1499413n), BaseApplication.getContext().getString(R.string.f140850f3), BaseApplication.getContext().getString(R.string.f1499613p), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.widget.theme.e
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GuildThemeMiniViewHandler.p(Function0.this, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.widget.theme.f
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GuildThemeMiniViewHandler.q(dialogInterface, i3);
                }
            }).show();
            return;
        }
        handler.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Function0 handler, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(handler, "$handler");
        handler.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Function0 handler, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(handler, "$handler");
        handler.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final void r() {
        QLog.e("QGMC.GuildThemeMiniViewHandler", 1, "[preProcessClick] no activity permission.");
        QQToast.makeText(BaseApplication.getContext(), 0, R.string.f1496612w, 0).show();
    }

    private final void s(@StringRes int alertStringRes) {
        Context context;
        Context context2;
        if (this.dialog.get() != null) {
            GuildMediaThemeChooseDialog guildMediaThemeChooseDialog = this.dialog.get();
            String str = null;
            if (guildMediaThemeChooseDialog != null) {
                context = guildMediaThemeChooseDialog.getContext();
            } else {
                context = null;
            }
            GuildMediaThemeChooseDialog guildMediaThemeChooseDialog2 = this.dialog.get();
            if (guildMediaThemeChooseDialog2 != null && (context2 = guildMediaThemeChooseDialog2.getContext()) != null) {
                str = context2.getString(alertStringRes);
            }
            QQToast.makeText(context, str, 0).show();
        }
    }

    public final void i(@Nullable String actionValue) {
        QLog.i("QGMC.GuildThemeMiniViewHandler", 1, "[handleMiniActionCallback] value: " + actionValue);
        if (Intrinsics.areEqual(actionValue, "share")) {
            m(3, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.theme.GuildThemeMiniViewHandler$handleMiniTogetherAction$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    GuildThemeMiniViewHandler.this.l();
                }
            });
        } else if (Intrinsics.areEqual(actionValue, "game")) {
            m(2, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.theme.GuildThemeMiniViewHandler$handleMiniTogetherAction$2
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    GuildThemeMiniViewHandler.this.j();
                }
            });
        }
        GuildMediaThemeChooseDialog guildMediaThemeChooseDialog = this.dialog.get();
        if (guildMediaThemeChooseDialog != null) {
            guildMediaThemeChooseDialog.dismissAllowingStateLoss();
        }
    }

    @Override // com.tencent.mobileqq.mini.api.IContainerViewCallback
    public void onMiniViewResult(@Nullable String jsonString) {
        QLog.i("QGMC.GuildThemeMiniViewHandler", 1, "[onMiniViewResult] result: " + jsonString);
    }
}
