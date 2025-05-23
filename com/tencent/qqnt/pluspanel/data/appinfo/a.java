package com.tencent.qqnt.pluspanel.data.appinfo;

import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.pluspanel.utils.a;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/pluspanel/data/appinfo/a;", "", "", "uinType", "appId", "Lcom/tencent/qqnt/pluspanel/data/appinfo/PlusPanelAppInfo;", "b", "a", "Landroid/util/SparseArray;", "Landroid/util/SparseArray;", "appIdMaps", "<init>", "()V", "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SparseArray<PlusPanelAppInfo> appIdMaps;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.appIdMaps = new SparseArray<>();
        }
    }

    private final PlusPanelAppInfo b(int uinType, int appId) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        boolean z36;
        boolean z37;
        boolean z38;
        boolean z39;
        boolean z46;
        boolean z47;
        boolean z48;
        boolean z49;
        boolean z55;
        boolean z56;
        boolean z57;
        boolean z58;
        boolean z59;
        a.Companion companion = com.tencent.qqnt.pluspanel.utils.a.INSTANCE;
        boolean z65 = false;
        if (appId == companion.z() || appId == companion.f0()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return new PicAppInfo(uinType);
        }
        if (appId == companion.G() || appId == companion.j0()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return new ShootAppInfo(uinType);
        }
        if (appId == companion.E() || appId == companion.V()) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            return new RedPacketAppInfo(uinType);
        }
        if (appId == companion.u0()) {
            return new GroupVideoChatAppInfo(uinType);
        }
        if (appId == companion.Z()) {
            return new MoreTroopAppInfo(uinType);
        }
        if (appId == companion.c()) {
            return new AnonymousChatAppInfo(uinType);
        }
        if (appId == companion.c0() || appId == companion.x()) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z19) {
            return new AudioCallAppInfo(uinType);
        }
        if (appId == companion.y() || appId == companion.e0()) {
            z26 = true;
        } else {
            z26 = false;
        }
        if (z26) {
            return new VideoCallAppInfo(uinType);
        }
        if (appId == companion.F() || appId == companion.d0()) {
            z27 = true;
        } else {
            z27 = false;
        }
        if (z27) {
            return new ShareScreenAppInfo(uinType);
        }
        if (appId == companion.t() || appId == companion.X()) {
            z28 = true;
        } else {
            z28 = false;
        }
        if (z28) {
            return new ListenTogetherAppInfo(uinType);
        }
        if (appId == companion.w0()) {
            return new WatchTogetherAppInfo(uinType);
        }
        if (appId == companion.l0()) {
            return new SingTogetherAppInfo(uinType);
        }
        if (appId == companion.l() || appId == companion.b0()) {
            z29 = true;
        } else {
            z29 = false;
        }
        if (z29) {
            return new BusinessCardAppInfo(uinType);
        }
        if (appId == companion.o0()) {
            return new TroopActivityAppInfo(uinType);
        }
        if (appId == companion.n0()) {
            return new TroopTouPiaoAppInfo(uinType);
        }
        if (appId == companion.p() || appId == companion.M()) {
            z36 = true;
        } else {
            z36 = false;
        }
        if (z36) {
            return new FavoriteAppInfo(uinType);
        }
        if (appId == companion.i0()) {
            return new DoodleAppInfo(uinType);
        }
        if (appId == companion.h()) {
            return new AVGameAppInfo(uinType);
        }
        if (appId == companion.A()) {
            return new PokeAppInfo(uinType);
        }
        if (appId == companion.w() || appId == companion.a0()) {
            z37 = true;
        } else {
            z37 = false;
        }
        if (z37) {
            return new MusicShareAppInfo(uinType);
        }
        if (appId == companion.s() || appId == companion.q0()) {
            z38 = true;
        } else {
            z38 = false;
        }
        if (z38) {
            return new HotPicAppInfo(uinType);
        }
        if (appId == companion.Y() || appId == companion.u()) {
            z39 = true;
        } else {
            z39 = false;
        }
        if (z39) {
            return new LocationAppInfo(uinType);
        }
        if (appId == companion.Q() || appId == companion.q()) {
            z46 = true;
        } else {
            z46 = false;
        }
        if (z46) {
            return new FileAppInfo(uinType);
        }
        if (appId == companion.g0()) {
            return new PlayTogetherAppInfo(uinType);
        }
        if (appId == companion.J()) {
            return new TransferAppInfo(uinType);
        }
        if (appId == companion.L() || appId == companion.m()) {
            z47 = true;
        } else {
            z47 = false;
        }
        if (z47) {
            return new CMShowAppInfo(uinType);
        }
        if (appId == companion.r() || appId == companion.R()) {
            z48 = true;
        } else {
            z48 = false;
        }
        if (z48) {
            return new GiftAppInfo(uinType);
        }
        if (appId == companion.I()) {
            return new TroopTencentDocsAppInfo(uinType);
        }
        if (appId == companion.m0()) {
            return new TencentDocsAppInfo(uinType);
        }
        if (appId == companion.N()) {
            return new CollectMoneyAppInfo(uinType);
        }
        if (appId == companion.a()) {
            return new AAShouKuanAppInfo(uinType);
        }
        if (appId == companion.e()) {
            return new AnonymousChatSettingAppInfo(uinType);
        }
        if (appId == companion.d()) {
            return new AnonymousGiftAppInfo(uinType);
        }
        if (appId == companion.j() || appId == companion.f()) {
            z49 = true;
        } else {
            z49 = false;
        }
        if (z49) {
            return new ArkAppManagerAppInfo(uinType);
        }
        if (appId == companion.g()) {
            return new AskAnonymouslyAppInfo(uinType);
        }
        if (appId == companion.k() || appId == companion.h()) {
            z55 = true;
        } else {
            z55 = false;
        }
        if (z55) {
            return new AVGameAppInfo(uinType);
        }
        if (appId == companion.i()) {
            return new BulkSendMsgAppInfo(uinType);
        }
        if (appId == companion.P()) {
            return new ExitAnonymousChatAppInfo(uinType);
        }
        if (appId == companion.v0()) {
            return new GroupPublicClassChatAppInfo(uinType);
        }
        if (appId == 1104445552) {
            return new HomeWorkAppInfo(uinType);
        }
        if (appId == companion.v()) {
            return new MiniAppInfo(uinType);
        }
        if (appId == companion.h0()) {
            return new PublicAccountVoiceAppInfo(uinType);
        }
        if (appId == companion.B()) {
            return new QavWTAppInfo(uinType);
        }
        if (appId == companion.D() || appId == companion.s0()) {
            z56 = true;
        } else {
            z56 = false;
        }
        if (z56) {
            return new ReceiptMsgAppInfo(uinType);
        }
        if (appId == companion.k0()) {
            return new ShortVideoAppInfo(uinType);
        }
        if (appId == companion.S()) {
            return new TroopCollectFormAppInfo(uinType);
        }
        if (appId == companion.n() || appId == companion.O()) {
            z57 = true;
        } else {
            z57 = false;
        }
        if (z57) {
            return new TroopDingYueAppInfo(uinType);
        }
        if (appId == companion.p0()) {
            return new TroopEffectPicAppInfo(uinType);
        }
        if (appId == companion.r0()) {
            return new TroopGuildDaKaAppInfo(uinType);
        }
        if (appId == companion.W() || appId == companion.K()) {
            z58 = true;
        } else {
            z58 = false;
        }
        if (z58 || appId == companion.t0()) {
            z59 = true;
        } else {
            z59 = false;
        }
        if (z59 || appId == companion.U()) {
            z65 = true;
        }
        if (z65) {
            return new CommonWebAppInfo(uinType);
        }
        if (appId == companion.C()) {
            return new QCircleAppInfo(uinType);
        }
        if (appId == 1300000001) {
            return new RobotPttAppInfo(uinType);
        }
        if (appId == 1300000002) {
            return new RobotStoryAppInfo(uinType);
        }
        if (appId == 1300000003) {
            return new RobotCommunicationShareAppInfo(uinType);
        }
        if (appId == 1300000004) {
            return new RobotImageAppInfo(uinType);
        }
        if (appId == 1300000005) {
            return new RobotCameraAppInfo(uinType);
        }
        if (appId == 102686667) {
            return new MoreAppInfo(uinType);
        }
        return new CommonWebAppInfo(uinType);
    }

    @Nullable
    public PlusPanelAppInfo a(int uinType, int appId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (PlusPanelAppInfo) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(uinType), Integer.valueOf(appId));
        }
        PlusPanelAppInfo plusPanelAppInfo = this.appIdMaps.get(appId);
        if (plusPanelAppInfo == null) {
            plusPanelAppInfo = b(uinType, appId);
            this.appIdMaps.append(appId, plusPanelAppInfo);
        }
        plusPanelAppInfo.setUinType(uinType);
        plusPanelAppInfo.setAppid(appId);
        return plusPanelAppInfo;
    }
}
