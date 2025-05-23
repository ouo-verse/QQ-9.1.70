package com.tencent.mobileqq.troop.flame.api.impl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.flame.api.ITroopFlameApi;
import com.tencent.mobileqq.troop.flame.detail.TroopFlameDetailFragment;
import com.tencent.mobileqq.troop.flame.detail.schema.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.graytips.action.k;
import com.tencent.qqnt.graytips.action.l;
import com.tencent.qqnt.graytips.api.INtGrayTipApi;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import com.tencent.qqnt.kernel.nativeinterface.GroupExt;
import com.tencent.qqnt.kernel.nativeinterface.GroupExtFlameData;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopFlameApiImpl implements ITroopFlameApi {
    static IPatchRedirector $redirector_ = null;
    public static final String FLAME_SURPRISE_SHOWN_CACHE_KEY = "flame_level_%s";
    public static final int NOT_INIT = -1;
    private static final String TAG = "TroopFlameApiImpl";

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements com.tencent.mobileqq.data.troop.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f296044a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f296045b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f296046c;

        a(int i3, String str, int i16) {
            this.f296044a = i3;
            this.f296045b = str;
            this.f296046c = i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopFlameApiImpl.this, Integer.valueOf(i3), str, Integer.valueOf(i16));
            }
        }

        @Override // com.tencent.mobileqq.data.troop.a
        public void a(TroopInfo troopInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopInfo);
            } else if (troopInfo == null || !troopInfo.isOwner() || this.f296044a != 0) {
                TroopFlameApiImpl.this.addFlameGrayTips(this.f296045b, this.f296046c);
            } else {
                TroopFlameApiImpl.this.addFlameSwitchSettingGrayTips(this.f296045b, troopInfo.isTroopGuildSwitchOpen());
            }
        }
    }

    public TroopFlameApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFlameGrayTips(String str, int i3) {
        String grayTipsSchema = getGrayTipsSchema(str);
        LocalGrayTip m3 = new LocalGrayTip.LocalGrayTipBuilder(str, 2, 19273L, 1, true, true, null).g(HardCodeUtil.qqStr(R.string.f2330876a), 1).h(HardCodeUtil.qqStr(R.string.f23305768), new k(grayTipsSchema), 3).c(getGrayTipsIcon(i3), new k(grayTipsSchema), "").m();
        QLog.i(TAG, 1, "[addLocalTroopFlameGrayTip] ready to add. troopUin:" + str + ", level: " + i3);
        ((INtGrayTipApi) QRoute.api(INtGrayTipApi.class)).addLocalGrayTip(MobileQQ.sMobileQQ.peekAppRuntime(), m3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFlameSwitchSettingGrayTips(String str, boolean z16) {
        LocalGrayTip m3 = new LocalGrayTip.LocalGrayTipBuilder(str, 2, 19273L, 1, true, true, null).g(HardCodeUtil.qqStr(R.string.f2331276e), 1).h(HardCodeUtil.qqStr(R.string.f2331176d), new l(str), 3).m();
        QLog.i(TAG, 1, "[addFlameSwitchGuideGrayTips] ready to add. troopUin:" + str + ", isTroopGuildSwitchOpen: " + z16);
        ((INtGrayTipApi) QRoute.api(INtGrayTipApi.class)).addLocalGrayTip(MobileQQ.sMobileQQ.peekAppRuntime(), m3, null);
    }

    private String getGrayTipsIcon(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    QLog.w(TAG, 1, "[getGrayTipsUIData] failed. flameLevel is invalid: " + i3);
                    return "";
                }
                return "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/qecommerce_group_flame_icon_v3.png";
            }
            return "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/qecommerce_group_flame_icon_v2.png";
        }
        return "https://qq-ecommerce.cdn-go.cn/url/latest/defaultmode/9035/group_flame/qecommerce_group_flame_icon_v1.png";
    }

    @NonNull
    private String getGrayTipsSchema(@NonNull String str) {
        return String.format(Locale.getDefault(), "mqqapi://group/troop_flame_details?troop_uin=%s&src_type=internal&version=1", str);
    }

    @Override // com.tencent.mobileqq.troop.flame.api.ITroopFlameApi
    public void addLocalTroopFlameGrayTip(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!TextUtils.isEmpty(str) && peekAppRuntime != null) {
            ((ITroopInfoService) peekAppRuntime.getRuntimeService(ITroopInfoService.class, "")).asyncGetTroopInfo(str, new a(i3, str, i16));
            return;
        }
        QLog.e(TAG, 1, "[addLocalTroopFlameGrayTip] troopUin = " + str + ", app = " + peekAppRuntime);
    }

    @Override // com.tencent.mobileqq.troop.flame.api.ITroopFlameApi
    public void cacheFlameDataHasShow(TroopInfo troopInfo) {
        GroupExt groupExt;
        GroupExtFlameData groupExtFlameData;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) troopInfo);
            return;
        }
        if (troopInfo != null && !TextUtils.isEmpty(troopInfo.troopuin) && (groupExt = troopInfo.groupExt) != null && (groupExtFlameData = groupExt.groupExtFlameData) != null && groupExtFlameData.version > 0) {
            com.tencent.mobileqq.troop.config.a aVar = com.tencent.mobileqq.troop.config.a.f294689a;
            if (aVar.i(String.format(FLAME_SURPRISE_SHOWN_CACHE_KEY, troopInfo.troopuin), -1, true) == -1) {
                aVar.u(String.format(FLAME_SURPRISE_SHOWN_CACHE_KEY, troopInfo.troopuin), groupExtFlameData.state, true);
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.flame.api.ITroopFlameApi
    public Drawable createTroopFlameDrawable(Context context, ITroopFlameApi.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Drawable) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) aVar);
        }
        return new com.tencent.mobileqq.troop.flame.detail.view.a(context, aVar.f296040a, aVar.f296041b, aVar.f296042c);
    }

    @Override // com.tencent.mobileqq.troop.flame.api.ITroopFlameApi
    public ITroopFlameApi.a getFlameViewDataFromPB(GroupExtFlameData groupExtFlameData) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ITroopFlameApi.a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) groupExtFlameData);
        }
        ITroopFlameApi.a aVar = new ITroopFlameApi.a();
        if (groupExtFlameData.switchState == 1 && (i3 = groupExtFlameData.state) != 0) {
            if (groupExtFlameData.isDisplayDayNum && i3 != 999) {
                int size = groupExtFlameData.dayNums.size();
                int i16 = groupExtFlameData.state;
                if (size < i16) {
                    aVar.f296043d = false;
                    return aVar;
                }
                if (i16 >= 0 && i16 < groupExtFlameData.dayNums.size()) {
                    aVar.f296041b = groupExtFlameData.dayNums.get(groupExtFlameData.state).intValue();
                }
            }
            aVar.f296040a = groupExtFlameData.state;
            aVar.f296042c = groupExtFlameData.isDisplayDayNum;
            return aVar;
        }
        aVar.f296043d = false;
        return aVar;
    }

    @Override // com.tencent.mobileqq.troop.flame.api.ITroopFlameApi
    public Class<?> getParserClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Class) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return b.class;
    }

    @Override // com.tencent.mobileqq.troop.flame.api.ITroopFlameApi
    public void showTroopFlameDetailDialog(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) str);
        } else {
            TroopFlameDetailFragment.sh(context, str);
        }
    }
}
