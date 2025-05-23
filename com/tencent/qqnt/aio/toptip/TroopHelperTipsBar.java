package com.tencent.qqnt.aio.toptip;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TroopHelperTipsBar extends com.tencent.qqnt.aio.toptips.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final View.OnClickListener f352161d;

    /* renamed from: e, reason: collision with root package name */
    private final View.OnClickListener f352162e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.qqnt.aio.toptips.c f352163f;

    /* renamed from: h, reason: collision with root package name */
    private String f352164h;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopHelperTipsBar.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (TroopHelperTipsBar.this.isShowing()) {
                QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                TroopHelperTipsBar troopHelperTipsBar = TroopHelperTipsBar.this;
                troopHelperTipsBar.v(troopHelperTipsBar.f352164h);
                TroopHelperTipsBar.this.f352163f.h(TroopHelperTipsBar.this);
                String str2 = TroopHelperTipsBar.this.f352164h;
                if (qQAppInterface.getTroopMask(TroopHelperTipsBar.this.f352164h) == GroupMsgMask.SHIELD) {
                    str = "1";
                } else {
                    str = "0";
                }
                ReportController.o(qQAppInterface, "dc00899", "Grp_msg", "", "aio-topbar", "Clk_close", 0, 0, str2, str, "", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopHelperTipsBar.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                TroopHelperTipsBar.this.f352163f.h(TroopHelperTipsBar.this);
                ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).setGroupMsgMask(TroopHelperTipsBar.this.f352164h, GroupMsgMask.RECEIVE, null, null);
                QQToast.makeText(view.getContext(), 5, R.string.d0h, 0).show();
                ReportController.o(qQAppInterface, "P_CliOper", "Grp_msg", "", "AIOchat", "Clk_setmsg", 0, 0, TroopHelperTipsBar.this.f352164h, "", "", "");
                String str2 = TroopHelperTipsBar.this.f352164h;
                if (qQAppInterface.getTroopMask(TroopHelperTipsBar.this.f352164h) == GroupMsgMask.SHIELD) {
                    str = "1";
                } else {
                    str = "0";
                }
                ReportController.o(qQAppInterface, "dc00899", "Grp_msg", "", "aio-topbar", "Clk_confirm", 0, 0, str2, str, "", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public TroopHelperTipsBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f352161d = new a();
            this.f352162e = new b();
        }
    }

    private void r(String str) {
        String valueOf;
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        if (from.decodeBool("tag_troop_ignore_tip_v2_" + str, false)) {
            return;
        }
        String decodeString = from.decodeString("tag_troop_aio_enter_times_" + str, "");
        if (!TextUtils.isEmpty(decodeString)) {
            valueOf = decodeString + ";" + (NetConnInfoCenter.getServerTimeMillis() / 1000);
        } else {
            valueOf = String.valueOf(NetConnInfoCenter.getServerTimeMillis() / 1000);
        }
        from.encodeString("tag_troop_aio_enter_times_" + str, valueOf).commitAsync();
        if (QLog.isColorLevel()) {
            QLog.d("TroopAssistTipsBar", 2, "addTroopAssistTipTime time=" + valueOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str) {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").removeKey("tag_troop_aio_enter_times_" + str).commitAsync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean t(String str) {
        String[] split;
        int length;
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        if (u(from, str)) {
            if (QLog.isDevelopLevel()) {
                QLog.d("TroopAssistTipsBar", 4, "getTroopAssistTipInRange hadShowTips");
            }
            return false;
        }
        if (from.decodeBool("tag_troop_ignore_tip_v2_" + str, false)) {
            return false;
        }
        String decodeString = from.decodeString("tag_troop_aio_enter_times_" + str, "");
        if (!TextUtils.isEmpty(decodeString) && (length = (split = decodeString.split(";")).length) >= 2) {
            try {
                if ((NetConnInfoCenter.getServerTimeMillis() / 1000) - Long.parseLong(split[length - 2]) < 7200) {
                    return true;
                }
            } catch (NumberFormatException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopAssistantManager", 2, QLog.getStackTraceString(e16));
                }
            }
        }
        return false;
    }

    private boolean u(MMKVOptionEntity mMKVOptionEntity, String str) {
        return mMKVOptionEntity.decodeBool(QMMKVFile.getKeyWithUin("tag_troop_aio_assist_tips_show", str), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(String str) {
        if (!TextUtils.isEmpty(str)) {
            QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeBool("tag_troop_ignore_tip_v2_" + str, true).commitAsync();
            if (QLog.isColorLevel()) {
                QLog.d("TroopAssistTipsBar", 2, "setTroopIgnoreTip key=", "tag_troop_ignore_tip_v2_" + str);
            }
        }
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    @Nullable
    public View a(@NonNull Object... objArr) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (View) iPatchRedirector.redirect((short) 8, (Object) this, (Object) objArr);
        }
        FragmentActivity activity = this.f352163f.a().c().getActivity();
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        String string = activity.getString(R.string.f173237i94);
        GroupMsgMask troopMask = qQAppInterface.getTroopMask(this.f352164h);
        GroupMsgMask groupMsgMask = GroupMsgMask.SHIELD;
        if (troopMask == groupMsgMask) {
            string = activity.getString(R.string.i95);
        }
        View Y = ChatActivityUtils.Y(activity, string, this.f352162e, this.f352161d);
        ReportController.o(qQAppInterface, "P_CliOper", "Grp_msg", "", "AIOchat", "exp_setmsg", 0, 0, this.f352164h, "", "", "");
        String str2 = this.f352164h;
        if (qQAppInterface.getTroopMask(str2) == groupMsgMask) {
            str = "1";
        } else {
            str = "0";
        }
        ReportController.o(qQAppInterface, "dc00899", "Grp_msg", "", "aio-topbar", "exp_topbar", 0, 0, str2, str, "", "");
        return Y;
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    @Nullable
    public int[] b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (int[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    public void g(@NonNull com.tencent.qqnt.aio.toptips.c cVar, int i3, @NonNull Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, cVar, Integer.valueOf(i3), objArr);
            return;
        }
        if (cVar.a().g().r().c().e() == 2 && i3 == 1005) {
            this.f352163f = cVar;
            String j3 = cVar.a().g().r().c().j();
            this.f352164h = j3;
            r(j3);
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.qqnt.aio.toptip.TroopHelperTipsBar.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopHelperTipsBar.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                    if (qQAppInterface.getTroopMask(TroopHelperTipsBar.this.f352164h) != GroupMsgMask.ASSISTANT && qQAppInterface.getTroopMask(TroopHelperTipsBar.this.f352164h) != GroupMsgMask.SHIELD) {
                        return;
                    }
                    TroopHelperTipsBar troopHelperTipsBar = TroopHelperTipsBar.this;
                    if (!troopHelperTipsBar.t(troopHelperTipsBar.f352164h)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("TroopAssistTipsBar", 2, "getTroopAssistTipInRange false, return ");
                        }
                    } else if (TroopHelperTipsBar.this.f352163f.e(TroopHelperTipsBar.this)) {
                        TroopHelperTipsBar troopHelperTipsBar2 = TroopHelperTipsBar.this;
                        troopHelperTipsBar2.s(troopHelperTipsBar2.f352164h);
                        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeBool(QMMKVFile.getKeyWithUin("tag_troop_aio_assist_tips_show", TroopHelperTipsBar.this.f352164h), true);
                        ReportController.o(qQAppInterface, "CliOper", "", "", "Grp_helper", "Aio_grp_banner", 0, 0, "", "", "", "");
                    }
                }
            }, 8, null, true);
        }
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    public int getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return 109;
    }

    public boolean isShowing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (109 == this.f352163f.b()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    public int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 11;
    }
}
