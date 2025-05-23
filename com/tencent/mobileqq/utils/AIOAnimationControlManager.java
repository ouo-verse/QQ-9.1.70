package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForTroopEffectPic;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite;
import com.tencent.mobileqq.troop.data.TroopGiftBagInfo;
import com.tencent.mobileqq.troopgift.TroopGiftAnimationController;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.troopgift.TroopGiftData;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.manager.Manager;
import tencent.im.oidb.cmd0x962.oidb_0x962$FinishInfo;
import tencent.im.oidb.cmd0x962.oidb_0x962$RspBody;
import xk2.a;

/* compiled from: P */
/* loaded from: classes20.dex */
public class AIOAnimationControlManager extends Observable implements Manager {
    public static final String R = String.valueOf(10000L);
    public static int S = 9;
    public static volatile boolean T = false;
    TroopGiftAnimationController D;
    a61.c E;
    Activity F;
    String G;
    Handler H;
    public i I;
    AppInterface K;

    /* renamed from: e, reason: collision with root package name */
    private long f306805e;

    /* renamed from: f, reason: collision with root package name */
    private int f306806f;

    /* renamed from: h, reason: collision with root package name */
    private SharedPreferences f306807h;

    /* renamed from: d, reason: collision with root package name */
    public int f306804d = 1;

    /* renamed from: i, reason: collision with root package name */
    private boolean f306808i = false;

    /* renamed from: m, reason: collision with root package name */
    HashMap<String, Integer> f306809m = new HashMap<>();
    HashMap<String, List<h>> C = new HashMap<>();
    protected HashMap<String, List<MessageForDeliverGiftTips>> J = new HashMap<>();
    public volatile boolean L = true;
    public Comparator<h> M = new b();
    com.tencent.mobileqq.vip.f N = new com.tencent.mobileqq.vip.f() { // from class: com.tencent.mobileqq.utils.AIOAnimationControlManager.4
        @Override // com.tencent.mobileqq.vip.f
        public void onDone(com.tencent.mobileqq.vip.g gVar) {
            int i3;
            String str;
            int i16;
            f fVar = new f();
            Bundle h16 = gVar.h();
            String string = h16.getString("GiftAnimationId");
            String string2 = h16.getString("TroopUin");
            int i17 = h16.getInt("GiftAnimationType");
            boolean z16 = h16.getBoolean("GiftIsInteract");
            fVar.f306839b = true;
            fVar.f306838a = string;
            g.a().setChanged();
            g.a().notifyObservers(fVar);
            if (QLog.isColorLevel()) {
                QLog.d("AIOAnimationControlManager", 2, "onDone Id=" + string + " task:" + gVar);
            }
            ReportController.o(null, "P_CliOper", "P_CliOper", "", "troop_gift_animation", "download", 0, gVar.f313006d, string, "", "", "");
            int i18 = 0;
            if (gVar.f313006d == 0) {
                File file = new File(com.tencent.mobileqq.troop.utils.am.b(string, i17, z16));
                try {
                    if (file.exists()) {
                        String replace = file.getAbsolutePath().replace(".zip", "_tmp");
                        FileUtils.uncompressZip(file.getAbsolutePath(), replace, false);
                        com.tencent.mobileqq.troop.utils.am.r(file, replace);
                    }
                    AIOAnimationControlManager.this.f306809m.put(string, 3);
                    ReportController.o(null, "P_CliOper", "Grp_flower", "", "grp_aio", "anime_suc", 1, 0, string2, "", "", "");
                } catch (Exception e16) {
                    e16.printStackTrace();
                    return;
                } finally {
                    file.delete();
                }
            } else {
                AIOAnimationControlManager.this.f306809m.put(string, 4);
                int systemNetwork = NetworkUtil.getSystemNetwork(AIOAnimationControlManager.this.K.getApplication());
                if (systemNetwork == 1) {
                    i3 = 2;
                } else {
                    i3 = 2;
                    if (systemNetwork == 2) {
                        i18 = 3;
                    } else if (systemNetwork == 3) {
                        i18 = 2;
                    } else if (systemNetwork == 4) {
                        i18 = 1;
                    } else {
                        i18 = 4;
                    }
                }
                if (AIOAnimationControlManager.this.E != null) {
                    str = "0";
                } else {
                    str = "1";
                }
                String str2 = str;
                if (com.tencent.biz.anonymous.a.h().d(string2)) {
                    i16 = i3;
                } else {
                    i16 = 1;
                }
                ReportController.o(null, "P_CliOper", "Grp_flower", "", "grp_aio", "anime_fail", i16, 0, string2, string + "", str2, i18 + "");
            }
            AIOAnimationControlManager aIOAnimationControlManager = AIOAnimationControlManager.this;
            if ((aIOAnimationControlManager.E != null || aIOAnimationControlManager.F != null) && !AIOAnimationControlManager.R.equals(aIOAnimationControlManager.G)) {
                AIOAnimationControlManager.this.H.post(new Runnable() { // from class: com.tencent.mobileqq.utils.AIOAnimationControlManager.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AIOAnimationControlManager aIOAnimationControlManager2 = AIOAnimationControlManager.this;
                        if (aIOAnimationControlManager2.f306804d == 3) {
                            aIOAnimationControlManager2.f306804d = 1;
                        }
                        aIOAnimationControlManager2.A();
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public boolean onStart(com.tencent.mobileqq.vip.g gVar) {
            String string = gVar.h().getString("GiftAnimationId");
            f fVar = new f();
            fVar.f306839b = false;
            fVar.f306838a = string;
            g.a().setChanged();
            g.a().notifyObservers(fVar);
            return super.onStart(gVar);
        }
    };
    TroopGiftAnimationController.d P = new a();
    FrameSprite.a Q = new FrameSprite.a() { // from class: com.tencent.mobileqq.utils.AIOAnimationControlManager.11
        @Override // com.tencent.mobileqq.surfaceviewaction.gl.FrameSprite.a
        public void a() {
            String str;
            AIOAnimationControlManager aIOAnimationControlManager = AIOAnimationControlManager.this;
            aIOAnimationControlManager.f306804d = 1;
            if (aIOAnimationControlManager.E == null && aIOAnimationControlManager.F == null && !AIOAnimationControlManager.R.equals(aIOAnimationControlManager.G)) {
                return;
            }
            AIOAnimationControlManager aIOAnimationControlManager2 = AIOAnimationControlManager.this;
            a61.c cVar = aIOAnimationControlManager2.E;
            if (cVar != null) {
                str = cVar.f25589n.f179557e;
            } else {
                str = aIOAnimationControlManager2.G;
            }
            List<h> list = aIOAnimationControlManager2.C.get(str);
            if (!com.tencent.mobileqq.troop.utils.am.p(list) && list != null) {
                synchronized (list) {
                    h remove = list.remove(0);
                    if (remove instanceof MessageForDeliverGiftTips) {
                        MessageForDeliverGiftTips messageForDeliverGiftTips = (MessageForDeliverGiftTips) remove;
                        String i3 = com.tencent.mobileqq.troop.utils.am.i(messageForDeliverGiftTips);
                        messageForDeliverGiftTips.hasFetchButFailed = false;
                        if (QLog.isColorLevel()) {
                            QLog.d("AIOAnimationControlManager", 2, "onMagicPlayEnd id:" + i3);
                        }
                        i iVar = AIOAnimationControlManager.this.I;
                        if (iVar != null) {
                            iVar.a(str, i3);
                        }
                    }
                    if (list.size() != 0) {
                        Collections.sort(list, AIOAnimationControlManager.this.M);
                        AIOAnimationControlManager.this.H.post(new Runnable() { // from class: com.tencent.mobileqq.utils.AIOAnimationControlManager.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AIOAnimationControlManager aIOAnimationControlManager3 = AIOAnimationControlManager.this;
                                aIOAnimationControlManager3.B(aIOAnimationControlManager3.f306808i);
                            }
                        });
                    } else {
                        AIOAnimationControlManager.this.D.v(null);
                        AIOAnimationControlManager.this.f306808i = false;
                        Integer G = ChatActivityUtils.G(str, AIOAnimationControlManager.this.K.getCurrentAccountUin());
                        if (AIOAnimationControlManager.T && G != null && -1 == G.intValue() && AIOAnimationControlManager.this.E != null) {
                            AIOAnimationControlManager.T = false;
                        }
                    }
                }
            }
        }
    };

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.utils.AIOAnimationControlManager$12, reason: invalid class name */
    /* loaded from: classes20.dex */
    class AnonymousClass12 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AIOAnimationControlManager f306812d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f306813e;

        @Override // java.lang.Runnable
        public void run() {
            this.f306812d.B(this.f306813e);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements TroopGiftAnimationController.d {
        a() {
        }

        @Override // com.tencent.mobileqq.troopgift.TroopGiftAnimationController.d
        public void a() {
            AIOAnimationControlManager.this.D();
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements Comparator<h> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(h hVar, h hVar2) {
            long shmsgseq;
            long shmsgseq2;
            if ((hVar instanceof MessageForDeliverGiftTips) && (hVar2 instanceof MessageForDeliverGiftTips)) {
                MessageForDeliverGiftTips messageForDeliverGiftTips = (MessageForDeliverGiftTips) hVar;
                MessageForDeliverGiftTips messageForDeliverGiftTips2 = (MessageForDeliverGiftTips) hVar2;
                if (messageForDeliverGiftTips.isToAll() && messageForDeliverGiftTips2.isToAll()) {
                    shmsgseq = messageForDeliverGiftTips.time;
                    shmsgseq2 = messageForDeliverGiftTips2.time;
                } else {
                    if (messageForDeliverGiftTips.isToAll()) {
                        return -1;
                    }
                    if (messageForDeliverGiftTips2.isToAll()) {
                        return 1;
                    }
                    if (messageForDeliverGiftTips.receiverUin == AIOAnimationControlManager.this.K.getLongAccountUin() && messageForDeliverGiftTips2.receiverUin == AIOAnimationControlManager.this.K.getLongAccountUin()) {
                        shmsgseq = messageForDeliverGiftTips.time;
                        shmsgseq2 = messageForDeliverGiftTips2.time;
                    } else {
                        if (messageForDeliverGiftTips.receiverUin == AIOAnimationControlManager.this.K.getLongAccountUin()) {
                            return -1;
                        }
                        if (messageForDeliverGiftTips2.receiverUin == AIOAnimationControlManager.this.K.getLongAccountUin()) {
                            return 1;
                        }
                        shmsgseq = messageForDeliverGiftTips.time;
                        shmsgseq2 = messageForDeliverGiftTips2.time;
                    }
                }
            } else {
                shmsgseq = hVar.getShmsgseq();
                shmsgseq2 = hVar2.getShmsgseq();
            }
            return (int) (shmsgseq - shmsgseq2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class c extends com.tencent.mobileqq.troop.utils.ak {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f306832a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AIOAnimationControlManager f306833b;
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class d implements FrameSprite.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f306834a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AIOAnimationControlManager f306835b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class e implements a.InterfaceC11553a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f306836a;

        e(boolean z16) {
            this.f306836a = z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public String f306838a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f306839b;
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class g extends Observable {

        /* renamed from: a, reason: collision with root package name */
        private static g f306840a;

        g() {
        }

        public static g a() {
            if (f306840a == null) {
                synchronized (g.class) {
                    if (f306840a == null) {
                        f306840a = new g();
                    }
                }
            }
            return f306840a;
        }

        @Override // java.util.Observable
        public void setChanged() {
            super.setChanged();
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface h {
        String getFriendUin();

        int getLimitType();

        long getShmsgseq();
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface i {
        void a(String str, String str2);
    }

    public AIOAnimationControlManager(AppInterface appInterface) {
        this.K = null;
        this.K = appInterface;
        w(appInterface);
        this.H = new Handler(Looper.getMainLooper());
        VasCommonReporter.getHistoryFeature().setValue1("aio_animation_control_manager").setValue2("new manager").report(true);
    }

    private void F(String str, String str2) {
        String str3;
        List<h> list = this.C.get(str);
        if (str2 != null && list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                h hVar = list.get(i3);
                if (hVar instanceof MessageForDeliverGiftTips) {
                    str3 = com.tencent.mobileqq.troop.utils.am.i((MessageForDeliverGiftTips) hVar);
                } else if (!(hVar instanceof MessageForTroopEffectPic)) {
                    str3 = "";
                } else {
                    str3 = ((MessageForTroopEffectPic) hVar).effectId + "";
                }
                if (str2.equals(str3)) {
                    list.remove(i3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(h hVar) {
        List<h> list = this.C.get(hVar.getFriendUin());
        if (list == null) {
            list = new ArrayList<>();
            this.C.put(hVar.getFriendUin(), list);
        }
        synchronized (list) {
            list.add(hVar);
            int limitType = hVar.getLimitType();
            int i3 = -1;
            int i16 = 0;
            for (int i17 = 0; i17 < list.size(); i17++) {
                h hVar2 = list.get(i17);
                if (hVar2 != null && hVar2.getLimitType() == limitType) {
                    if (i3 == -1) {
                        i3 = i17;
                    }
                    i16++;
                }
            }
            if (i16 > t(limitType)) {
                list.remove(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void k() {
        int i3;
        boolean z16;
        File file = new File(AppConstants.SDCARD_GIFT_SAVE);
        if (!file.exists()) {
            file.mkdirs();
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (int i16 = 0; i16 < listFiles.length; i16++) {
                if (listFiles[i16].exists() && listFiles[i16].isDirectory()) {
                    String name = listFiles[i16].getName();
                    if (listFiles[i16].getName().endsWith("_HD")) {
                        name = name.substring(0, name.length() - 3);
                    } else {
                        i3 = 1;
                        if (listFiles[i16].getName().endsWith("_V")) {
                            name = name.substring(0, name.length() - 2);
                            z16 = false;
                        } else if (listFiles[i16].getName().endsWith("_NEW")) {
                            name = name.substring(0, name.length() - 4);
                            z16 = true;
                        }
                        if (!com.tencent.mobileqq.troop.utils.am.o(name, i3, z16)) {
                            this.f306809m.put(name, 3);
                            if (QLog.isColorLevel()) {
                                QLog.d("AIOAnimationControlManager", 2, "Package Downloaded:" + listFiles[i16].getName());
                            }
                        } else {
                            FileUtils.deleteDirectory(listFiles[i16].getAbsolutePath());
                        }
                    }
                    z16 = false;
                    i3 = 0;
                    if (!com.tencent.mobileqq.troop.utils.am.o(name, i3, z16)) {
                    }
                }
            }
        }
    }

    private void q(String str, MessageForDeliverGiftTips messageForDeliverGiftTips) {
        if (!this.f306809m.containsKey(str) || this.f306809m.get(str).intValue() == 4) {
            File file = new File(com.tencent.mobileqq.troop.utils.am.b(str, messageForDeliverGiftTips.animationType, messageForDeliverGiftTips.isInteract()));
            Bundle bundle = new Bundle();
            bundle.putString("GiftAnimationId", str);
            bundle.putString("TroopUin", messageForDeliverGiftTips.frienduin);
            bundle.putInt("GiftAnimationType", messageForDeliverGiftTips.animationType);
            bundle.putBoolean("GiftIsInteract", messageForDeliverGiftTips.isInteract());
            com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g(com.tencent.mobileqq.troop.utils.am.a(messageForDeliverGiftTips), file);
            gVar.f313008f = 2;
            if (messageForDeliverGiftTips instanceof MessageForTroopGift) {
                ((MessageForTroopGift) messageForDeliverGiftTips).isLoading = true;
            }
            s().startDownload(gVar, this.N, bundle);
            if (QLog.isColorLevel()) {
                QLog.d("AIOAnimationControlManager", 2, "start Download PackageId:" + com.tencent.mobileqq.troop.utils.am.i(messageForDeliverGiftTips));
            }
            this.f306809m.put(str, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String u(String str, String str2) {
        TroopMemberInfo troopMemberInfoSync = ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberInfoSync(str, str2, null, "AIOAnimationControlManager");
        if (troopMemberInfoSync != null) {
            return troopMemberInfoSync.nickInfo.getShowName();
        }
        return "";
    }

    private void w(AppInterface appInterface) {
        if (appInterface != null && (appInterface instanceof BrowserAppInterface)) {
            k();
        } else {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.utils.AIOAnimationControlManager.1
                @Override // java.lang.Runnable
                public void run() {
                    AIOAnimationControlManager.this.k();
                    try {
                        AIOAnimationControlManager.this.l();
                    } catch (Exception e16) {
                        QLog.e("AIOAnimationControlManager", 1, "checkPicEffectPackageIdState failed!", e16);
                    }
                }
            }, 8, null, true);
        }
    }

    public void A() {
        B(false);
    }

    public void B(final boolean z16) {
        String str;
        int i3;
        String str2;
        QQAppInterface qQAppInterface;
        int i16;
        boolean z17;
        com.tencent.mobileqq.troop.data.u uVar;
        if (this.E == null && this.F == null && !R.equals(this.G)) {
            return;
        }
        VasCommonReporter.getHistoryFeature().setValue1("aio_animation_control_manager").setValue2(QZoneJsConstants.METHOD_PLAYGIFT).report(false);
        this.f306808i = z16;
        if (R.equals(this.G)) {
            str = this.G;
        } else if (this.E != null && ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).judgeBaseChatPieIsGuildChatPie(this.E)) {
            str = this.E.f25589n.f179559f;
        } else {
            a61.c cVar = this.E;
            if (cVar != null) {
                str = cVar.f25589n.f179557e;
            } else {
                str = this.G;
            }
        }
        final String str3 = str;
        List<MessageForDeliverGiftTips> list = this.J.get(str3);
        List<h> list2 = this.C.get(str3);
        if ((x() || !com.tencent.mobileqq.troop.utils.am.p(list)) && this.D != null && !com.tencent.mobileqq.troop.utils.am.p(list2) && (i3 = this.f306804d) != 2 && i3 != 3) {
            this.f306804d = 2;
            h hVar = list2.get(0);
            if (hVar instanceof MessageForDeliverGiftTips) {
                final MessageForDeliverGiftTips messageForDeliverGiftTips = (MessageForDeliverGiftTips) hVar;
                if (messageForDeliverGiftTips.isToAll() && !messageForDeliverGiftTips.hasFetchButFailed) {
                    TroopGiftBagInfo e16 = ((com.tencent.mobileqq.troop.utils.al) this.K.getManager(QQManagerFactory.TROOP_GIFT_MANAGER)).e(str3, messageForDeliverGiftTips.bagId, new com.tencent.mobileqq.troop.utils.ak() { // from class: com.tencent.mobileqq.utils.AIOAnimationControlManager.7
                        @Override // com.tencent.mobileqq.troop.utils.ak
                        public void a(int i17, String str4) {
                            MessageForDeliverGiftTips messageForDeliverGiftTips2 = messageForDeliverGiftTips;
                            messageForDeliverGiftTips2.hasFetchButFailed = true;
                            messageForDeliverGiftTips2.showButton = true;
                            AIOAnimationControlManager aIOAnimationControlManager = AIOAnimationControlManager.this;
                            AppInterface appInterface = aIOAnimationControlManager.K;
                            if (appInterface instanceof QQAppInterface) {
                                messageForDeliverGiftTips2.senderName = aIOAnimationControlManager.u(str3, "" + messageForDeliverGiftTips.senderUin);
                            } else if (appInterface instanceof VideoAppInterface) {
                                messageForDeliverGiftTips2.senderName = ((VideoAppInterface) appInterface).G(1, str3, messageForDeliverGiftTips.senderUin + "");
                            } else {
                                messageForDeliverGiftTips2.senderName = null;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.i(LogTag.TAG_TROOP_SEND_GIFT, 2, "playGiftBigAnimation getGrabBagInfo onError. errorCode:" + i17 + " errorMsg:" + str4);
                            }
                            AIOAnimationControlManager.this.H.post(new Runnable() { // from class: com.tencent.mobileqq.utils.AIOAnimationControlManager.7.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                                    AIOAnimationControlManager aIOAnimationControlManager2 = AIOAnimationControlManager.this;
                                    aIOAnimationControlManager2.f306804d = 1;
                                    aIOAnimationControlManager2.B(z16);
                                }
                            });
                        }

                        @Override // com.tencent.mobileqq.troop.utils.ak
                        public void d(TroopGiftBagInfo troopGiftBagInfo) {
                            if (troopGiftBagInfo.myGrabResult == null) {
                                MessageForDeliverGiftTips messageForDeliverGiftTips2 = messageForDeliverGiftTips;
                                messageForDeliverGiftTips2.hasFetchButFailed = true;
                                messageForDeliverGiftTips2.showButton = true;
                                AIOAnimationControlManager aIOAnimationControlManager = AIOAnimationControlManager.this;
                                AppInterface appInterface = aIOAnimationControlManager.K;
                                if (appInterface instanceof QQAppInterface) {
                                    messageForDeliverGiftTips2.senderName = aIOAnimationControlManager.u(str3, "" + messageForDeliverGiftTips.senderUin);
                                } else if (appInterface instanceof VideoAppInterface) {
                                    messageForDeliverGiftTips2.senderName = ((VideoAppInterface) appInterface).G(1, str3, messageForDeliverGiftTips.senderUin + "");
                                } else {
                                    messageForDeliverGiftTips2.senderName = null;
                                }
                            }
                            AIOAnimationControlManager.this.H.post(new Runnable() { // from class: com.tencent.mobileqq.utils.AIOAnimationControlManager.7.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                                    AIOAnimationControlManager aIOAnimationControlManager2 = AIOAnimationControlManager.this;
                                    aIOAnimationControlManager2.f306804d = 1;
                                    aIOAnimationControlManager2.B(z16);
                                }
                            });
                        }
                    });
                    if (e16 == null) {
                        this.f306804d = 1;
                        return;
                    }
                    if (e16.hasGrab() && (uVar = e16.myGrabResult) != null) {
                        messageForDeliverGiftTips.showButton = false;
                        messageForDeliverGiftTips.resultText = uVar.f294997e;
                        messageForDeliverGiftTips.resultType = 0;
                    } else {
                        com.tencent.mobileqq.troop.data.u uVar2 = e16.myGrabResult;
                        if (uVar2 != null) {
                            messageForDeliverGiftTips.showButton = false;
                            messageForDeliverGiftTips.resultText = uVar2.f294997e;
                            messageForDeliverGiftTips.resultType = 1;
                        } else {
                            messageForDeliverGiftTips.showButton = true;
                        }
                    }
                    if (this.K instanceof QQAppInterface) {
                        messageForDeliverGiftTips.senderName = u(str3, "" + messageForDeliverGiftTips.senderUin);
                    }
                }
                String i17 = com.tencent.mobileqq.troop.utils.am.i(messageForDeliverGiftTips);
                if (this.f306809m.containsKey(i17) && this.f306809m.get(i17).intValue() == 3) {
                    this.D.v(this.Q);
                    if (QLog.isColorLevel()) {
                        QLog.d("AIOAnimationControlManager", 2, "Playing! playMaigface id:" + com.tencent.mobileqq.troop.utils.am.i(messageForDeliverGiftTips));
                    }
                    if (bt2.a.a().c()) {
                        bt2.a.a().h();
                    }
                    if (!TextUtils.isEmpty(messageForDeliverGiftTips.interactId)) {
                        list2.remove(messageForDeliverGiftTips);
                        return;
                    }
                    a61.c cVar2 = this.E;
                    if (cVar2 != null) {
                        str2 = "0";
                    } else {
                        str2 = "1";
                    }
                    String str4 = str2;
                    if (cVar2 != null) {
                        qQAppInterface = cVar2.f25577b;
                    } else {
                        qQAppInterface = null;
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("");
                    AppInterface appInterface = this.K;
                    sb5.append(com.tencent.av.utils.az.a(appInterface, appInterface.getCurrentAccountUin(), str3));
                    ReportController.o(qQAppInterface, "P_CliOper", "Grp_flower", "", "cartoon", "show", 0, 0, str3, i17, str4, sb5.toString());
                    if (QLog.isColorLevel()) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("Check isLimitGiftAnim: isEnterAIO:");
                        sb6.append(z16);
                        sb6.append(", isToMeGift:");
                        if (messageForDeliverGiftTips.receiverUin != this.K.getLongAccountUin()) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        sb6.append(z17);
                        sb6.append(", count:");
                        sb6.append(this.f306806f);
                        sb6.append(", time:");
                        sb6.append(this.f306805e);
                        i16 = 2;
                        QLog.d("AIOAnimationControlManager", 2, sb6.toString());
                    } else {
                        i16 = 2;
                    }
                    if (z16 && messageForDeliverGiftTips.receiverUin != this.K.getLongAccountUin() && z(true)) {
                        AppInterface appInterface2 = this.K;
                        if (appInterface2 instanceof QQAppInterface) {
                            QQAppInterface qQAppInterface2 = (QQAppInterface) appInterface2;
                            for (RecentUser recentUser : qQAppInterface2.getProxyManager().m().getRecentList(false)) {
                                if (recentUser.msgType == 8) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("AIOAnimationControlManager", i16, "limitGiftAnim setRead RecentUser:" + recentUser);
                                    }
                                    qQAppInterface2.getMessageFacade().G1().h0(recentUser.uin, recentUser.getType(), true, false);
                                }
                            }
                            return;
                        }
                        return;
                    }
                    this.D.t(messageForDeliverGiftTips);
                    this.D.f302757m = this.P;
                    return;
                }
                if (this.f306809m.containsKey(i17) && this.f306809m.get(i17).intValue() == 4) {
                    F(str3, i17);
                    this.f306804d = 1;
                    B(z16);
                    return;
                }
                this.f306804d = 3;
                return;
            }
            if (hVar instanceof xk2.a) {
                xk2.a aVar = (xk2.a) hVar;
                this.D.w(aVar);
                aVar.a(this.E, new e(z16));
                list2.remove(hVar);
                return;
            }
            boolean z18 = hVar instanceof MessageForTroopEffectPic;
        }
    }

    public void C() {
        g.a().deleteObservers();
        this.F = null;
        this.C.remove(this.G);
        this.J.remove(this.G);
        this.D = null;
        this.f306804d = 1;
    }

    public void D() {
        String str;
        if (QLog.isColorLevel()) {
            QLog.d("AIOAnimationControlManager", 2, "releaseAnimationList");
        }
        a61.c cVar = this.E;
        if (cVar != null) {
            str = cVar.f25589n.f179557e;
        } else {
            str = this.G;
        }
        this.C.remove(str);
        this.J.remove(str);
        TroopGiftAnimationController troopGiftAnimationController = this.D;
        if (troopGiftAnimationController != null) {
            troopGiftAnimationController.s();
            this.f306804d = 1;
        }
    }

    public void E(String str) {
        List<h> remove = this.C.remove(str);
        if (remove != null) {
            remove.clear();
        }
        List<MessageForDeliverGiftTips> remove2 = this.J.remove(str);
        if (remove2 != null) {
            remove2.clear();
        }
    }

    public void G(a61.c cVar) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAnimationControlManager", 2, "set TroopChatPie ,troopUin:" + cVar.f25589n.f179557e);
        }
    }

    public void H(Activity activity) {
        if (this.D == null) {
            this.D = new TroopGiftAnimationController(null, activity, this.K);
        }
        this.D.u(4);
        this.F = this.D.o();
        this.G = R;
    }

    public boolean I(MessageForDeliverGiftTips messageForDeliverGiftTips) {
        if (!y()) {
            return false;
        }
        D();
        if (!n(messageForDeliverGiftTips)) {
            return false;
        }
        A();
        return true;
    }

    public void h(Observer observer) {
        g.a().addObserver(observer);
    }

    public boolean i(final MessageForDeliverGiftTips messageForDeliverGiftTips, final boolean z16) {
        if (messageForDeliverGiftTips == null || !com.tencent.mobileqq.troop.utils.am.m(messageForDeliverGiftTips)) {
            return false;
        }
        g(messageForDeliverGiftTips);
        if (messageForDeliverGiftTips.interactState == 2) {
            A();
            return true;
        }
        ((com.tencent.mobileqq.troop.utils.al) this.K.getManager(QQManagerFactory.TROOP_GIFT_MANAGER)).a(messageForDeliverGiftTips.frienduin, messageForDeliverGiftTips.interactId, messageForDeliverGiftTips.giftId, new com.tencent.mobileqq.troop.utils.ak() { // from class: com.tencent.mobileqq.utils.AIOAnimationControlManager.2
            @Override // com.tencent.mobileqq.troop.utils.ak
            public void i(int i3, oidb_0x962$RspBody oidb_0x962_rspbody) {
                if (i3 == 0) {
                    messageForDeliverGiftTips.interactState = oidb_0x962_rspbody.uint32_play_state.get();
                    if (QLog.isColorLevel()) {
                        QLog.d("AIOAnimationControlManager", 2, "checkInteract interactId: " + messageForDeliverGiftTips.interactId + ", interactState: " + messageForDeliverGiftTips.interactState);
                    }
                    messageForDeliverGiftTips.alreadyPlayMicroseconds = oidb_0x962_rspbody.uint64_already_pay_microseconds.get();
                    messageForDeliverGiftTips.playTotalMicroseconds = oidb_0x962_rspbody.uint64_play_total_microseconds.get();
                    if (messageForDeliverGiftTips.interactState == 2 && oidb_0x962_rspbody.msg_finish_info.has()) {
                        oidb_0x962$FinishInfo oidb_0x962_finishinfo = oidb_0x962_rspbody.msg_finish_info.get();
                        messageForDeliverGiftTips.interactText = oidb_0x962_finishinfo.bytes_text.get().toStringUtf8();
                        messageForDeliverGiftTips.participateNum = oidb_0x962_finishinfo.uint32_participate_num.get();
                        messageForDeliverGiftTips.interactFirstUin = oidb_0x962_finishinfo.uint64_first_uin.get();
                        messageForDeliverGiftTips.interactFirstNickname = oidb_0x962_finishinfo.bytes_first_nick_name.get().toStringUtf8();
                        messageForDeliverGiftTips.interacEndtUrl = oidb_0x962_finishinfo.bytes_url.get().toStringUtf8();
                    } else {
                        List<MessageForDeliverGiftTips> list = AIOAnimationControlManager.this.J.get(messageForDeliverGiftTips.frienduin);
                        if (list == null) {
                            list = new ArrayList<>();
                            AIOAnimationControlManager.this.J.put(messageForDeliverGiftTips.frienduin, list);
                        }
                        List<MessageForDeliverGiftTips> list2 = list;
                        synchronized (list2) {
                            if (!list2.contains(messageForDeliverGiftTips)) {
                                list2.add(messageForDeliverGiftTips);
                                if (list2.size() > 5) {
                                    list2.remove(0);
                                }
                            }
                        }
                        List<h> list3 = AIOAnimationControlManager.this.C.get(messageForDeliverGiftTips.frienduin);
                        if (list3 != null) {
                            synchronized (list3) {
                                list3.remove(messageForDeliverGiftTips);
                            }
                        }
                        if (z16) {
                            AIOAnimationControlManager.this.setChanged();
                            AIOAnimationControlManager.this.notifyObservers(messageForDeliverGiftTips);
                        }
                    }
                    AIOAnimationControlManager.this.K.getEntityManagerFactory().createEntityManager().update(messageForDeliverGiftTips);
                } else if (QLog.isColorLevel()) {
                    QLog.e("AIOAnimationControlManager", 2, "checkInteract errorCode: " + i3);
                }
                AIOAnimationControlManager.this.H.post(new Runnable() { // from class: com.tencent.mobileqq.utils.AIOAnimationControlManager.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AIOAnimationControlManager aIOAnimationControlManager = AIOAnimationControlManager.this;
                        if (aIOAnimationControlManager.f306804d == 3) {
                            aIOAnimationControlManager.f306804d = 1;
                        }
                        aIOAnimationControlManager.A();
                    }
                });
            }
        });
        return true;
    }

    public boolean j(h hVar, boolean z16) {
        if (hVar == null) {
            return false;
        }
        if ((hVar instanceof MessageForDeliverGiftTips) && !com.tencent.mobileqq.troop.utils.am.m((MessageForDeliverGiftTips) hVar)) {
            return false;
        }
        g(hVar);
        if (z16) {
            setChanged();
            notifyObservers(hVar);
            return true;
        }
        return true;
    }

    protected void l() {
        File[] listFiles;
        File parentFile = new File(com.tencent.mobileqq.troop.utils.am.k(0)).getParentFile();
        if (parentFile.exists() && (listFiles = parentFile.listFiles()) != null) {
            for (int i3 = 0; i3 < listFiles.length; i3++) {
                if (listFiles[i3].exists()) {
                    String name = listFiles[i3].getName();
                    try {
                        String substring = name.substring(0, name.indexOf(".mp4"));
                        if (com.tencent.mobileqq.troop.utils.am.q(Integer.parseInt(substring))) {
                            this.f306809m.put(substring, 3);
                        } else {
                            listFiles[i3].delete();
                        }
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("AIOAnimationControlManager", 2, "checkPicEffectPackageIdState: " + QLog.getStackTraceString(e16));
                        }
                    }
                }
            }
        }
    }

    public void m(Observer observer) {
        g.a().deleteObserver(observer);
    }

    public boolean n(MessageForDeliverGiftTips messageForDeliverGiftTips) {
        int i3;
        if (!com.tencent.mobileqq.troop.utils.am.m(messageForDeliverGiftTips)) {
            return false;
        }
        String i16 = com.tencent.mobileqq.troop.utils.am.i(messageForDeliverGiftTips);
        if (this.f306809m.containsKey(i16) && this.f306809m.get(i16).intValue() == 3) {
            if (!com.tencent.mobileqq.troop.utils.am.o(i16, messageForDeliverGiftTips.animationType, messageForDeliverGiftTips.isInteract())) {
                this.f306809m.remove(i16);
                FileUtils.deleteDirectory(com.tencent.mobileqq.troop.utils.am.d(messageForDeliverGiftTips));
                q(i16, messageForDeliverGiftTips);
                i3 = 2;
            } else {
                i3 = 3;
            }
        } else {
            q(i16, messageForDeliverGiftTips);
            i3 = 4;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AIOAnimationControlManager", 2, "giftRealAnimationId:" + com.tencent.mobileqq.troop.utils.am.i(messageForDeliverGiftTips) + ",state:" + i3);
        }
        if (y() && i3 != 3) {
            return false;
        }
        if (messageForDeliverGiftTips.isInteract()) {
            return i(messageForDeliverGiftTips, false);
        }
        return j(messageForDeliverGiftTips, false);
    }

    public void o(String str) {
        BaseActivity baseActivity;
        ChatFragment chatFragment;
        final TroopGiftData troopGiftData = new TroopGiftData();
        TroopGiftData.GiftDataBean giftDataBean = new TroopGiftData.GiftDataBean();
        troopGiftData.giftData = giftDataBean;
        giftDataBean.dataForClient = (TroopGiftData.GiftDataBean.DataForClientBean) new Gson().fromJson(str, TroopGiftData.GiftDataBean.DataForClientBean.class);
        if (r() == null && (baseActivity = BaseActivity.sTopActivity) != null && (chatFragment = baseActivity.getChatFragment()) != null) {
            G(chatFragment.qh());
        }
        this.K.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.utils.AIOAnimationControlManager.5
            @Override // java.lang.Runnable
            public void run() {
                AIOAnimationControlManager.this.g(troopGiftData);
                AIOAnimationControlManager.this.A();
            }
        });
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        g.a().deleteObservers();
        if (this.K != null && QLog.isColorLevel()) {
            QLog.d("AIOAnimationControlManager", 2, "clear History. uin:" + this.K.getAccount() + " app=" + String.valueOf(this.K));
        }
        this.E = null;
        this.F = null;
        this.H = null;
    }

    public void p(int i3, String str, MessageForTroopEffectPic messageForTroopEffectPic) {
        String str2 = "" + i3;
        if (!this.f306809m.containsKey("" + i3) || this.f306809m.get(str2).intValue() == 4) {
            File file = new File(com.tencent.mobileqq.troop.utils.am.k(i3));
            Bundle bundle = new Bundle();
            bundle.putString("GiftAnimationId", str2);
            bundle.putString("TroopUin", str);
            com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g(com.tencent.mobileqq.troop.utils.am.l(i3), file);
            gVar.f313008f = 2;
            s().startDownload(gVar, this.N, bundle);
            this.f306809m.put(str2, 2);
        }
    }

    public a61.c r() {
        return this.E;
    }

    public com.tencent.mobileqq.vip.h s() {
        return ((DownloaderFactory) this.K.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).u(1);
    }

    public int t(int i3) {
        if (i3 == 0) {
            return 5;
        }
        return 0;
    }

    public long[] v(String str) {
        List<h> list = this.C.get(str);
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (h hVar : list) {
                if (hVar instanceof MessageForDeliverGiftTips) {
                    arrayList.add(Long.valueOf(((MessageForDeliverGiftTips) hVar).getId()));
                }
            }
        }
        long[] jArr = new long[arrayList.size()];
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            jArr[i3] = ((Long) arrayList.get(i3)).longValue();
        }
        return jArr;
    }

    public boolean x() {
        int i3 = this.f306804d;
        if (i3 == 1 || i3 == 4) {
            return true;
        }
        return false;
    }

    protected boolean y() {
        return R.equals(this.G);
    }

    public boolean z(boolean z16) {
        SharedPreferences sharedPreferences;
        boolean z17 = true;
        if (this.f306805e == 0) {
            if (z16) {
                this.f306805e = System.currentTimeMillis();
                this.f306806f = 1;
            }
        } else if (System.currentTimeMillis() - this.f306805e < 3600000) {
            SharedPreferences sharedPreferences2 = this.f306807h;
            if (sharedPreferences2 != null) {
                S = sharedPreferences2.getInt("AIOAnimationControlManager_limit_gif_count_MAX", S);
            } else {
                S = 0;
            }
            int i3 = this.f306806f;
            if (i3 >= S) {
                this.f306804d = 4;
                sharedPreferences = this.f306807h;
                if (sharedPreferences != null && z16) {
                    sharedPreferences.edit().putLong("AIOAnimationControlManager_limit_gif_time", this.f306805e).apply();
                    this.f306807h.edit().putInt("AIOAnimationControlManager_limit_gif_count", this.f306806f).apply();
                }
                return z17;
            }
            if (z16) {
                this.f306806f = i3 + 1;
            }
        } else if (z16) {
            this.f306805e = System.currentTimeMillis();
            this.f306806f = 1;
        }
        z17 = false;
        sharedPreferences = this.f306807h;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("AIOAnimationControlManager_limit_gif_time", this.f306805e).apply();
            this.f306807h.edit().putInt("AIOAnimationControlManager_limit_gif_count", this.f306806f).apply();
        }
        return z17;
    }
}
