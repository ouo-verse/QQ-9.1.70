package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.TroopFansEntryConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupExt;
import java.util.ArrayList;

/* loaded from: classes19.dex */
public class FansBeatRankProcessor extends com.tencent.mobileqq.troop.shortcutbar.c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private QQAppInterface f298652a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.mobileqq.troop.shortcutbar.a f298653b;

    /* renamed from: c, reason: collision with root package name */
    private String f298654c;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.a f298655d;

    /* renamed from: e, reason: collision with root package name */
    com.tencent.mobileqq.troop.api.observer.f f298656e;

    /* renamed from: f, reason: collision with root package name */
    com.tencent.mobileqq.troop.api.observer.e f298657f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public static class BeatRankShortcurBarInfo extends ShortcutBarInfo {
        static IPatchRedirector $redirector_;

        BeatRankShortcurBarInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo
        public int getPriority() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return 2;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
    }

    /* loaded from: classes19.dex */
    class a extends com.tencent.mobileqq.troop.api.observer.f {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FansBeatRankProcessor.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.f
        protected void c(boolean z16, String str, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, Long.valueOf(j3));
            } else if (z16 && !TextUtils.isEmpty(str) && TextUtils.equals(str, FansBeatRankProcessor.this.f298654c)) {
                FansBeatRankProcessor.this.j();
            }
        }
    }

    /* loaded from: classes19.dex */
    class b extends com.tencent.mobileqq.troop.api.observer.e {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FansBeatRankProcessor.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onGetTroopInfoExtComplete(boolean z16, String str, GroupExt groupExt) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, groupExt);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("FansBeatRankProcessor", 2, "onGetTroopInfoExtComplete,", Boolean.valueOf(z16), " troopUin=", str);
            }
            if (z16 && !TextUtils.isEmpty(str) && TextUtils.equals(FansBeatRankProcessor.this.f298654c, str) && com.tencent.mobileqq.troop.utils.b.a(FansBeatRankProcessor.this.f298652a, str, groupExt)) {
                FansBeatRankProcessor.this.j();
            }
        }
    }

    public FansBeatRankProcessor(com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.a aVar, com.tencent.mobileqq.troop.shortcutbar.a aVar2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) aVar2);
            return;
        }
        this.f298655d = aVar;
        this.f298652a = (QQAppInterface) aVar.d();
        this.f298653b = aVar2;
        try {
            this.f298654c = this.f298655d.f();
        } catch (Exception e16) {
            QLog.e("FansBeatRankProcessor", 2, "mTroopUin init error: ", e16);
        }
        this.f298656e = new a();
        this.f298657f = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        TroopInfo B = ((TroopManager) this.f298652a.getManager(QQManagerFactory.TROOP_MANAGER)).B(this.f298654c);
        boolean z16 = false;
        if (B != null && B.isFansTroop()) {
            if (B.getFansTroopStarId() != 0) {
                z16 = true;
            }
            l(z16);
            return;
        }
        l(false);
    }

    private void k(ArrayList<ShortcutBarInfo> arrayList) {
        com.tencent.mobileqq.troop.shortcutbar.a aVar = this.f298653b;
        if (aVar != null) {
            aVar.h(4, arrayList);
        }
    }

    private void l(boolean z16) {
        if (!z16) {
            k(null);
            return;
        }
        BeatRankShortcurBarInfo beatRankShortcurBarInfo = new BeatRankShortcurBarInfo();
        beatRankShortcurBarInfo.setIconUrl("https://static-res.qq.com/static-res/clivia/heart_icon.png");
        beatRankShortcurBarInfo.setMsgSummary("\u6253\u699c");
        beatRankShortcurBarInfo.setShowFrame(0);
        beatRankShortcurBarInfo.setShowDel(false);
        ArrayList<ShortcutBarInfo> arrayList = new ArrayList<>();
        arrayList.add(beatRankShortcurBarInfo);
        k(arrayList);
        ReportController.o(this.f298652a, "dc00898", "", "", "0X800B584", "0X800B584", 0, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.c
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        TroopFansEntryConfig troopFansEntryConfig = (TroopFansEntryConfig) am.s().x(701);
        if (troopFansEntryConfig != null && troopFansEntryConfig.isGroupEntranceSwitchOn()) {
            this.f298652a.addObserver(this.f298656e);
            this.f298652a.addObserver(this.f298657f);
            j();
        }
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.c
    public void b(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, obj);
            return;
        }
        if (obj instanceof BeatRankShortcurBarInfo) {
            if (QLog.isColorLevel()) {
                QLog.i("FansBeatRankProcessor", 2, NodeProps.ON_CLICK);
            }
            if (StudyModeManager.t()) {
                QQToast.makeText(BaseApplicationImpl.sApplication, HardCodeUtil.qqStr(R.string.f2068459e), 0).show();
                return;
            }
            ReportController.o(this.f298652a, "dc00898", "", "", "0X800B585", "0X800B585", 0, 0, "", "", "", "");
            TroopInfo B = ((TroopManager) this.f298652a.getManager(QQManagerFactory.TROOP_MANAGER)).B(this.f298654c);
            if (B != null) {
                com.tencent.mobileqq.troop.utils.b.c(this.f298655d.e(), this.f298654c, B.getFansTroopStarId());
            } else if (QLog.isColorLevel()) {
                QLog.i("FansBeatRankProcessor", 2, "onClick: TroopInfo null");
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.b
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f298652a.removeObserver(this.f298656e);
            this.f298652a.removeObserver(this.f298657f);
        }
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.b
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.shortcutbar.c
    public void e(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, obj);
        }
    }
}
