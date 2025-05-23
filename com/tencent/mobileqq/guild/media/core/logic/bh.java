package com.tencent.mobileqq.guild.media.core.logic;

import android.util.Log;
import com.hihonor.honorid.core.data.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVRoomCtrlOptInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserAVRspInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.fc;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.er;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001/B\u000f\u0012\u0006\u0010+\u001a\u00020(\u00a2\u0006\u0004\b,\u0010-J<\u0010\r\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0018H\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\\\u0010$\u001a\u00020\u00122\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t26\u0010#\u001a2\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00120\u001eJ^\u0010%\u001a\u00020\u00122\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t28\u0010#\u001a4\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001eJ\b\u0010&\u001a\u00020\u0012H\u0016J\b\u0010'\u001a\u00020\u0012H\u0016R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/bh;", "Lcom/tencent/mobileqq/guild/media/core/g;", "Lcom/tencent/mobileqq/guild/media/core/logic/h;", "", "result", "", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProUserAVRspInfo;", "rspInfo", "", "checkMic", "checkScreen", "checkCamera", "e0", "b0", "a0", "d0", "c0", "", "f0", UserInfo.USERSTATE, "U", "Luh2/b;", "W", "", "j0", "i0", "X", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/fc;", "Y", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "retCode", "retMsg", "callback", BdhLogUtil.LogTag.Tag_Req, "l0", "E0", "u", "Lcom/tencent/mobileqq/guild/media/core/f;", "e", "Lcom/tencent/mobileqq/guild/media/core/f;", "mediaChannelCore", "<init>", "(Lcom/tencent/mobileqq/guild/media/core/f;)V", "f", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class bh extends h {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.f mediaChannelCore;

    public bh(@NotNull com.tencent.mobileqq.guild.media.core.f mediaChannelCore) {
        Intrinsics.checkNotNullParameter(mediaChannelCore, "mediaChannelCore");
        this.mediaChannelCore = mediaChannelCore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(bh this$0, Function2 function2, int i3, String errMsg, IGProUserAVRspInfo iGProUserAVRspInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f0(i3, errMsg, iGProUserAVRspInfo);
        if (function2 != null) {
            Integer valueOf = Integer.valueOf(i3);
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            function2.invoke(valueOf, errMsg);
        }
    }

    public static /* synthetic */ void S(bh bhVar, boolean z16, boolean z17, boolean z18, Function2 function2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        if ((i3 & 2) != 0) {
            z17 = false;
        }
        if ((i3 & 4) != 0) {
            z18 = false;
        }
        bhVar.R(z16, z17, z18, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(bh this$0, boolean z16, boolean z17, boolean z18, Function2 callback, int i3, String errMsg, IGProUserAVRspInfo iGProUserAVRspInfo) {
        int i16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (this$0.e0(i3, errMsg, iGProUserAVRspInfo, z16, z17, z18)) {
            i16 = 0;
        } else {
            i16 = -1;
        }
        Integer valueOf = Integer.valueOf(i16);
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        callback.invoke(valueOf, errMsg);
    }

    private final boolean U(int userState) {
        if (userState != 4 && userState != 3 && userState != 7) {
            return false;
        }
        return true;
    }

    private final uh2.b W() {
        AppInterface l3 = com.tencent.mobileqq.guild.util.ch.l();
        Intrinsics.checkNotNullExpressionValue(l3, "appInterface()");
        IRuntimeService runtimeService = l3.getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IG\u2026va, ProcessConstant.MAIN)");
        return (uh2.b) runtimeService;
    }

    private final long X() {
        try {
            String selfTinyId = ((IGPSService) com.tencent.mobileqq.guild.util.ch.R0(IGPSService.class)).getSelfTinyId();
            Intrinsics.checkNotNullExpressionValue(selfTinyId, "gpsService.selfTinyId");
            return Long.parseLong(selfTinyId);
        } catch (Exception unused) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("getSelfTinyId: parse long error!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.Core.MediaChannelStageHelper", 1, (String) it.next(), null);
            }
            return 0L;
        }
    }

    private final fc Y() {
        fc fcVar = new fc();
        fcVar.a().e(j0());
        fcVar.a().d(i0());
        fcVar.g(X());
        return fcVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x006f, code lost:
    
        if (r6.getDevOpt().getMicOpt() == 12) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean a0(IGProUserAVRspInfo rspInfo) {
        boolean z16;
        boolean z17;
        boolean z18 = false;
        if (rspInfo.getRoomDevOpts() != null && (!r0.isEmpty())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ArrayList<IGProAVRoomCtrlOptInfo> roomDevOpts = rspInfo.getRoomDevOpts();
            Intrinsics.checkNotNullExpressionValue(roomDevOpts, "rspInfo.roomDevOpts");
            if (!(roomDevOpts instanceof Collection) || !roomDevOpts.isEmpty()) {
                for (IGProAVRoomCtrlOptInfo iGProAVRoomCtrlOptInfo : roomDevOpts) {
                    if (iGProAVRoomCtrlOptInfo.getIsCurrentRoom() && (iGProAVRoomCtrlOptInfo.getDevOpt().getMicOpt() == 12 || iGProAVRoomCtrlOptInfo.getDevOpt().getMicOpt() == 15)) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        z18 = true;
                        break;
                    }
                }
            }
        } else if (U(rspInfo.getUserState())) {
        }
        Logger.f235387a.d().i("QGMC.Core.MediaChannelStageHelper", 1, "handleCheckStageMicState: result[" + z18 + "]");
        return z18;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0063, code lost:
    
        if (r6.getDevOpt().getMicOpt() == 12) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean b0(IGProUserAVRspInfo rspInfo) {
        boolean z16;
        boolean z17;
        boolean z18 = false;
        if (rspInfo.getRoomDevOpts() != null && (!r0.isEmpty())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ArrayList<IGProAVRoomCtrlOptInfo> roomDevOpts = rspInfo.getRoomDevOpts();
            Intrinsics.checkNotNullExpressionValue(roomDevOpts, "rspInfo.roomDevOpts");
            if (!(roomDevOpts instanceof Collection) || !roomDevOpts.isEmpty()) {
                for (IGProAVRoomCtrlOptInfo iGProAVRoomCtrlOptInfo : roomDevOpts) {
                    if (iGProAVRoomCtrlOptInfo.getIsCurrentRoom() && iGProAVRoomCtrlOptInfo.getDevOpt().getMicOpt() == 12) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        z18 = true;
                        break;
                    }
                }
            }
        } else if (U(rspInfo.getUserState())) {
        }
        Logger.f235387a.d().i("QGMC.Core.MediaChannelStageHelper", 1, "handleQueryStageMicState: result[" + z18 + "]");
        return z18;
    }

    private final boolean c0(IGProUserAVRspInfo rspInfo) {
        boolean z16;
        if (U(rspInfo.getUserState()) && rspInfo.getDevOpt().getCameraOpt() == 12) {
            z16 = true;
        } else {
            z16 = false;
        }
        Logger.f235387a.d().i("QGMC.Core.MediaChannelStageHelper", 1, "handleStageMicState: result[" + z16 + "]");
        return z16;
    }

    private final boolean d0(IGProUserAVRspInfo rspInfo) {
        boolean z16;
        if (U(rspInfo.getUserState()) && rspInfo.getDevOpt().getScreenOpt() == 12) {
            z16 = true;
        } else {
            z16 = false;
        }
        Logger.f235387a.d().i("QGMC.Core.MediaChannelStageHelper", 1, "handleStageMicState: result[" + z16 + "]");
        return z16;
    }

    private final boolean e0(int result, String errMsg, IGProUserAVRspInfo rspInfo, boolean checkMic, boolean checkScreen, boolean checkCamera) {
        if (result == 0 && rspInfo != null) {
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("QGMC.Core.MediaChannelStageHelper", "onCheckAVState: rspInfo[" + rspInfo.getTrtcKey() + "]");
            }
            Logger.f235387a.d().i("QGMC.Core.MediaChannelStageHelper", 1, "onCheckAVState: rspInfo[" + rspInfo.getUserState() + ", " + rspInfo.getDevOpt().getMicOpt() + ", " + rspInfo.getDevOpt().getScreenOpt() + ", " + rspInfo.getDevOpt().getCameraOpt() + "]");
            MediaChannelMultiRoomHelper.Y0(this.mediaChannelCore.P(), rspInfo, false, 2, null);
            if (checkMic) {
                return a0(rspInfo);
            }
            if (checkScreen) {
                return d0(rspInfo);
            }
            if (!checkCamera) {
                return false;
            }
            return c0(rspInfo);
        }
        Logger logger2 = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str = "onCheckAVState: result[" + result + "] errMsg[" + errMsg + "]";
        if (str instanceof String) {
            bVar.a().add(str);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("QGMC.Core.MediaChannelStageHelper", 1, (String) it.next(), null);
        }
        return false;
    }

    private final void f0(int result, String errMsg, IGProUserAVRspInfo rspInfo) {
        boolean z16;
        String str = null;
        if (result == 0 && rspInfo != null) {
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("QGMC.Core.MediaChannelStageHelper", "onQueryAVState: rspInfo[" + rspInfo.getTrtcKey() + "]");
            }
            Logger.f235387a.d().i("QGMC.Core.MediaChannelStageHelper", 1, "onQueryAVState: rspInfo[" + rspInfo.getUserState() + ", " + rspInfo.getDevOpt().getMicOpt() + ", " + rspInfo.getDevOpt().getScreenOpt() + ", " + rspInfo.getDevOpt().getCameraOpt() + "]");
            this.mediaChannelCore.P().X0(rspInfo, true);
            z16 = b0(rspInfo);
        } else {
            Logger logger2 = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "onQueryAVState: result[" + result + "] errMsg[" + errMsg + "]";
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.Core.MediaChannelStageHelper", 1, (String) it.next(), null);
            }
            z16 = false;
        }
        Logger.f235387a.d().i("QGMC.Core.MediaChannelStageHelper", 1, "onQueryAVState, setAvRoomMicrophone " + z16);
        this.mediaChannelCore.J().g(z16);
        com.tencent.mobileqq.guild.media.core.notify.p eventBus = this.mediaChannelCore.getEventBus();
        if (rspInfo != null) {
            str = rspInfo.getTipMsg();
        }
        eventBus.i(new com.tencent.mobileqq.guild.media.core.notify.h(str));
    }

    private final long i0() {
        try {
            return Long.parseLong(this.mediaChannelCore.E());
        } catch (Exception unused) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("parseChannelId: parse long error!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.Core.MediaChannelStageHelper", 1, (String) it.next(), null);
            }
            return 0L;
        }
    }

    private final long j0() {
        try {
            return Long.parseLong(this.mediaChannelCore.getGuildID());
        } catch (Exception unused) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("parseGuildId: parse long error!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.Core.MediaChannelStageHelper", 1, (String) it.next(), null);
            }
            return 0L;
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void E0() {
        super.E0();
        if (this.mediaChannelCore.C().getSelfTalkPermission()) {
            l0(true, false, false, null);
        }
    }

    public final void R(final boolean checkMic, final boolean checkScreen, final boolean checkCamera, @NotNull final Function2<? super Integer, ? super String, Unit> callback) {
        int i3;
        int i16;
        Intrinsics.checkNotNullParameter(callback, "callback");
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str = "checkStageState: channelId[" + com.tencent.mobileqq.guild.media.core.m.b(this.mediaChannelCore.v0()) + "] checkMic[" + checkMic + "] checkScreen[" + checkScreen + "] checkCamera[" + checkCamera + "]";
        if (str instanceof String) {
            bVar.a().add(str);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("QGMC.Core.MediaChannelStageHelper", 1, (String) it.next(), null);
        }
        fc Y = Y();
        com.tencent.mobileqq.qqguildsdk.data.genc.l b16 = Y.b();
        int i17 = 12;
        if (checkMic) {
            i3 = 12;
        } else {
            i3 = 0;
        }
        b16.e(i3);
        com.tencent.mobileqq.qqguildsdk.data.genc.l b17 = Y.b();
        if (checkScreen) {
            i16 = 12;
        } else {
            i16 = 0;
        }
        b17.f(i16);
        com.tencent.mobileqq.qqguildsdk.data.genc.l b18 = Y.b();
        if (!checkCamera) {
            i17 = 0;
        }
        b18.d(i17);
        W().checkAVState(Y, new er() { // from class: com.tencent.mobileqq.guild.media.core.logic.bf
            @Override // wh2.er
            public final void a(int i18, String str2, IGProUserAVRspInfo iGProUserAVRspInfo) {
                bh.T(bh.this, checkMic, checkScreen, checkCamera, callback, i18, str2, iGProUserAVRspInfo);
            }
        });
    }

    public final void l0(boolean checkMic, boolean checkScreen, boolean checkCamera, @Nullable final Function2<? super Integer, ? super String, Unit> callback) {
        int i3;
        int i16;
        Logger.f235387a.d().i("QGMC.Core.MediaChannelStageHelper", 1, "queryStageState: channelId[" + com.tencent.mobileqq.guild.media.core.m.b(this.mediaChannelCore.v0()) + "] checkMic[" + checkMic + "] checkScreen[" + checkScreen + "] checkCamera[" + checkCamera + "]");
        fc Y = Y();
        com.tencent.mobileqq.qqguildsdk.data.genc.l b16 = Y.b();
        int i17 = 12;
        if (checkMic) {
            i3 = 12;
        } else {
            i3 = 0;
        }
        b16.e(i3);
        com.tencent.mobileqq.qqguildsdk.data.genc.l b17 = Y.b();
        if (checkScreen) {
            i16 = 12;
        } else {
            i16 = 0;
        }
        b17.f(i16);
        com.tencent.mobileqq.qqguildsdk.data.genc.l b18 = Y.b();
        if (!checkCamera) {
            i17 = 0;
        }
        b18.d(i17);
        W().queryAVState(Y, new er() { // from class: com.tencent.mobileqq.guild.media.core.logic.bg
            @Override // wh2.er
            public final void a(int i18, String str, IGProUserAVRspInfo iGProUserAVRspInfo) {
                bh.F0(bh.this, callback, i18, str, iGProUserAVRspInfo);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void u() {
        super.u();
    }
}
