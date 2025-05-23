package com.tencent.mobileqq.activity.aio.helper;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.troop.troopcard.api.ITroopGameCardUtilsApi;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.utils.eu;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqnt.aio.helper.cw;
import com.tencent.qqnt.event.TroopNotificationEvent;
import com.tencent.qqnt.kernel.nativeinterface.ChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.MsgTypeFilter;
import com.tencent.qqnt.kernel.nativeinterface.QueryMsgsParams;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@AIOCacheMarket(level = 1)
/* loaded from: classes10.dex */
public class ao implements com.tencent.aio.main.businesshelper.h, com.tencent.mvi.base.route.g, LifecycleOwner {

    /* renamed from: d, reason: collision with root package name */
    protected com.tencent.aio.api.runtime.a f178790d;

    /* renamed from: e, reason: collision with root package name */
    protected QQAppInterface f178791e;

    /* renamed from: f, reason: collision with root package name */
    protected Dialog f178792f;

    /* renamed from: h, reason: collision with root package name */
    protected View f178793h;

    /* renamed from: i, reason: collision with root package name */
    protected String f178794i = "";

    /* renamed from: m, reason: collision with root package name */
    protected boolean f178795m = true;
    private boolean C = false;
    private final LifecycleRegistry D = new LifecycleRegistry(this);
    protected Handler E = new a(Looper.getMainLooper());
    private com.tencent.mvi.base.route.a F = new b();

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                ao.this.E();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NonNull MsgIntent msgIntent) {
            ao.this.s(msgIntent);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ao.this.f178792f.dismiss();
            eu.g("Grp_AIO", "AIO_clk", "game_tips_clk_off", 0, 0, ao.this.f178794i);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ao.this.f178792f.dismiss();
            if (!ao.this.v()) {
                ao aoVar = ao.this;
                if (aoVar.f178794i != null) {
                    aoVar.A();
                    eu.g("Grp_AIO", "AIO_clk", "game_tips_clk_on", 0, 0, ao.this.f178794i);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class e implements com.tencent.qqnt.troop.e {
        e() {
        }

        @Override // com.tencent.qqnt.troop.e
        public void onResult(boolean z16, int i3, @NonNull String str) {
            Context context;
            if (!z16) {
                QLog.e("TroopGameGuideHelper", 1, "[modifyTroopGameCardSwitch] errCode:" + i3 + ", errMsg:" + str);
                com.tencent.aio.api.runtime.a aVar = ao.this.f178790d;
                if (aVar != null) {
                    context = aVar.c().getContext();
                } else {
                    context = null;
                }
                if (context != null) {
                    QQToast.makeText(context, 1, HardCodeUtil.qqStr(R.string.f180243aj), 0).show();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).modifyGameCardSwitch(this.f178794i, 1, true, this, new e());
    }

    private void B() {
        if (this.f178795m) {
            o();
            this.f178795m = false;
        }
    }

    private static void C(QQAppInterface qQAppInterface, String str) {
        if (qQAppInterface == null) {
            return;
        }
        QMMKV.from(qQAppInterface.getApplicationContext(), "common_mmkv_configurations").encodeBool("SP_GAME_GUIDE_" + qQAppInterface.getCurrentAccountUin() + "_" + str, false).commitAsync();
    }

    private static void D(QQAppInterface qQAppInterface, String str) {
        if (qQAppInterface == null) {
            return;
        }
        QMMKV.from(qQAppInterface.getApplicationContext(), "common_mmkv_configurations").encodeBool("SP_GAME_GUIDE_" + qQAppInterface.getCurrentAccountUin() + "_" + str, true).commitAsync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        com.tencent.aio.api.runtime.a aVar;
        if (!TextUtils.isEmpty(this.f178794i) && (aVar = this.f178790d) != null && aVar.c() != null && this.f178790d.c().getActivity() != null && this.f178790d.d() != null && this.f178790d.d().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) && !this.C && !t(this.f178791e, this.f178794i)) {
            Dialog dialog = this.f178792f;
            if (dialog != null && dialog.isShowing()) {
                return;
            }
            if (this.f178792f == null) {
                this.f178792f = new ReportDialog(this.f178790d.c().getActivity(), R.style.qZoneInputDialog);
            }
            if (this.f178793h == null && !u()) {
                return;
            }
            this.f178792f.setContentView(this.f178793h);
            this.f178792f.setCanceledOnTouchOutside(false);
            this.f178792f.show();
            D(this.f178791e, this.f178794i);
            eu.g("Grp_AIO", "AIO_exp", "game_tips_exp", 0, 0, this.f178794i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void x(int i3, String str, ArrayList<MsgRecord> arrayList) {
        int size;
        if (this.f178791e == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("checkGameLinkProcedure result:");
            sb5.append(i3);
            sb5.append(", errMsg: ");
            sb5.append(str);
            sb5.append(", msgListSize:");
            if (arrayList == null) {
                size = 0;
            } else {
                size = arrayList.size();
            }
            sb5.append(size);
            QLog.d("TroopGameGuideHelper", 2, sb5.toString());
        }
        if (i3 == 0 && !bl.b(arrayList)) {
            Iterator<MsgRecord> it = arrayList.iterator();
            while (it.hasNext()) {
                MsgRecord next = it.next();
                if (next != null && next.getMsgType() == 11 && w(r(next))) {
                    this.E.sendEmptyMessage(1);
                    return;
                }
            }
        }
    }

    private void m(int i3) {
        QLog.d("TroopGameGuideHelper", 1, "checkMessageHasGameLinkAndShow count:" + i3 + ", queryMsgsWithFilterEx msgid:0");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MsgTypeFilter(11, new ArrayList()));
        ((IMsgService) QRoute.api(IMsgService.class)).queryMsgsWithFilterEx(0L, 0L, 0L, new QueryMsgsParams(new ChatInfo(2, this.f178794i), arrayList, new ArrayList(), 0L, 0L, i3, false, true), new IMsgOperateCallback() { // from class: com.tencent.mobileqq.activity.aio.helper.al
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i16, String str, ArrayList arrayList2) {
                ao.this.y(i16, str, arrayList2);
            }
        });
    }

    private ArkAppMessage r(MsgRecord msgRecord) {
        Object firstOrNull;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull(msgRecord.getElements(), new Function1() { // from class: com.tencent.mobileqq.activity.aio.helper.an
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Boolean z16;
                z16 = ao.z((MsgElement) obj);
                return z16;
            }
        });
        MsgElement msgElement = (MsgElement) firstOrNull;
        if (msgElement != null && msgElement.getArkElement() != null) {
            ArkAppMessage arkAppMessage = new ArkAppMessage();
            arkAppMessage.fromAppXml(msgElement.getArkElement().getBytesData());
            return arkAppMessage;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(MsgIntent msgIntent) {
        if (msgIntent instanceof TroopNotificationEvent.OnShowEvent) {
            this.C = true;
            p();
        }
    }

    private static boolean t(QQAppInterface qQAppInterface, String str) {
        if (qQAppInterface == null) {
            return true;
        }
        return QMMKV.from(qQAppInterface.getApplicationContext(), "common_mmkv_configurations").decodeBool("SP_GAME_GUIDE_" + qQAppInterface.getCurrentAccountUin() + "_" + str, false);
    }

    private boolean u() {
        try {
            String e16 = com.tencent.mobileqq.troop.troopgame.c.e();
            if (TextUtils.isEmpty(e16)) {
                return false;
            }
            Bitmap imageBitmap = ((ITroopGameCardUtilsApi) QRoute.api(ITroopGameCardUtilsApi.class)).getImageBitmap(e16 + "aio_game_popup_bg.png");
            Bitmap imageBitmap2 = ((ITroopGameCardUtilsApi) QRoute.api(ITroopGameCardUtilsApi.class)).getImageBitmap(e16 + "aio_game_popup_close_btn.png");
            if (imageBitmap != null && imageBitmap2 != null) {
                View inflate = LayoutInflater.from(this.f178790d.c().getContext()).inflate(R.layout.e56, (ViewGroup) null);
                this.f178793h = inflate;
                ((ImageView) inflate.findViewById(R.id.f101845wa)).setImageBitmap(imageBitmap);
                ImageView imageView = (ImageView) this.f178793h.findViewById(R.id.f101805w7);
                imageView.setImageBitmap(imageBitmap2);
                imageView.setOnClickListener(new c());
                this.f178793h.findViewById(R.id.f101835w_).setOnClickListener(new d());
                return true;
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean v() {
        if (this.f178791e != null && this.f178790d != null) {
            return false;
        }
        return true;
    }

    private boolean w(ArkAppMessage arkAppMessage) {
        String str;
        if (arkAppMessage == null) {
            return false;
        }
        String str2 = "";
        if (TextUtils.isEmpty(arkAppMessage.appId)) {
            str = "";
        } else {
            str = arkAppMessage.appId;
        }
        if (!TextUtils.isEmpty(arkAppMessage.appName)) {
            str2 = arkAppMessage.appName;
        }
        if (!str.equals(QZoneShareManager.GLORY_OF_KINGS) && !str2.equals("com.tencent.gamecenter.teamshare") && !str2.equals("com.tencent.gamecenter.gameshare_sgame")) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopGameGuideHelper", 2, "isGameLink = true.");
        }
        this.E.sendEmptyMessage(1);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(final int i3, final String str, final ArrayList arrayList) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.helper.am
            @Override // java.lang.Runnable
            public final void run() {
                ao.this.x(i3, str, arrayList);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean z(MsgElement msgElement) {
        boolean z16;
        if (msgElement.getElementType() == 10) {
            z16 = true;
        } else {
            z16 = false;
        }
        return Boolean.valueOf(z16);
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.C;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NonNull
    public Lifecycle getLifecycle() {
        return this.D;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.qqnt.event.TroopNotificationEvent.OnShowEvent");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        return new HashSet();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NonNull
    public String getTag() {
        return "TroopGameGuideHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NonNull
    public int[] interestedIn() {
        return new int[]{3};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        try {
            if (v()) {
                return;
            }
            if (StudyModeManager.t()) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide studymode = true.");
                    return;
                }
                return;
            }
            com.tencent.mobileqq.troop.troopgame.a aVar = (com.tencent.mobileqq.troop.troopgame.a) com.tencent.mobileqq.config.am.s().x(695);
            if (aVar == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide empty configData");
                    return;
                }
                return;
            }
            QQAppInterface qQAppInterface = this.f178791e;
            if (qQAppInterface == null) {
                return;
            }
            TroopInfo B = ((TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).B(this.f178794i);
            if (B == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide troopinfo=null");
                    return;
                }
                return;
            }
            if (!B.isOwnerOrAdmin(this.f178791e.getCurrentUin())) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide isOwnerOrAdmin = false.");
                    return;
                }
                return;
            }
            if (B.isHomeworkTroop()) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide homeworktroop");
                    return;
                }
                return;
            }
            if (B.isTroopGameCardEnabled()) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide isTroopGameCardEnabled = true.");
                    return;
                }
                return;
            }
            if (t(this.f178791e, this.f178794i)) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide hasShownGameGuide = true.");
                    return;
                }
                return;
            }
            if (QZoneShareManager.GLORY_OF_KINGS.equals(String.valueOf(B.hlGuildAppid))) {
                this.E.sendEmptyMessage(1);
                if (QLog.isColorLevel()) {
                    QLog.d("TroopGameGuideHelper", 2, "asyncCheckShouldShowGameGuide hlGuildAppid = game.");
                    return;
                }
                return;
            }
            int a16 = aVar.a();
            if (QLog.isColorLevel()) {
                QLog.d("TroopGameGuideHelper", 2, "asyncCheckShouldShowGameGuide getNumOfMsgToCheck = " + a16);
            }
            if (a16 > 0) {
                m(a16);
            }
        } catch (Exception e16) {
            QLog.e("TroopGameGuideHelper", 1, "asyncCheckShouldShowGameGuide exception: " + e16.getMessage());
        }
    }

    public void o() {
        if (QLog.isColorLevel()) {
            QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide");
        }
        com.tencent.aio.api.runtime.a aVar = this.f178790d;
        if (aVar != null && this.f178791e != null) {
            if (aVar.g() == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide AioParam = null");
                    return;
                }
                return;
            } else {
                this.f178794i = this.f178790d.g().r().c().j();
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.helper.ak
                    @Override // java.lang.Runnable
                    public final void run() {
                        ao.this.j();
                    }
                }, 16, null, true);
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopGameGuideHelper", 2, "checkShouldShowGameGuide mAIOContext = null");
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NonNull com.tencent.aio.main.businesshelper.b bVar) {
        this.f178795m = true;
        this.f178790d = bVar.a();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            this.f178791e = (QQAppInterface) peekAppRuntime;
        }
        this.f178790d.e().f(this, this.F);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        q();
        this.f178791e = null;
        this.f178790d.e().i(this, this.F);
        this.f178790d = null;
        this.f178792f = null;
        this.f178793h = null;
        this.f178794i = "";
        this.f178795m = true;
        this.C = false;
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int i3) {
        if (i3 == 3) {
            B();
        } else if (i3 == 0) {
            this.D.setCurrentState(Lifecycle.State.CREATED);
        } else if (i3 == 12) {
            this.D.setCurrentState(Lifecycle.State.DESTROYED);
        }
    }

    public void p() {
        Dialog dialog = this.f178792f;
        if (dialog != null && dialog.isShowing() && this.f178791e != null && !TextUtils.isEmpty(this.f178794i)) {
            C(this.f178791e, this.f178794i);
        }
        q();
    }

    public void q() {
        Dialog dialog = this.f178792f;
        if (dialog != null && dialog.isShowing()) {
            this.f178792f.dismiss();
        }
    }
}
