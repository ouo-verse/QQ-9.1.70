package com.tencent.mobileqq.profilesetting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.weishi.api.IWSMinePanel;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.gamecenter.api.IGameCenterAuthApi;
import com.tencent.mobileqq.mini.servlet.MiniAppSetGameBoxOptionsServlet;
import com.tencent.mobileqq.minigame.api.IMiniGameVAUtilsApi;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.api.IProfileGameCardApi;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.profilecard.base.config.ProfileConfig;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardBlacklistReportConst;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.PrivacyTextUtils;
import com.tencent.mobileqq.profilesetting.api.IProfileSettingApi;
import com.tencent.mobileqq.profilesetting.f;
import com.tencent.mobileqq.profilesetting.w;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.ActionSheetWithTick;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.trpcprotocol.gamecenter.QqCardSvrPB$GetSwitchRsp;
import com.tencent.trpcprotocol.gamecenter.QqCardSvrPB$SetSwitchRsp;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class InterestSwitchEditActivity extends IphoneTitleBarActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: l0, reason: collision with root package name */
    public static final HashMap<String, Integer> f260946l0;

    /* renamed from: m0, reason: collision with root package name */
    private static final int[] f260947m0;

    /* renamed from: n0, reason: collision with root package name */
    private static final int[] f260948n0;

    /* renamed from: a0, reason: collision with root package name */
    private RecyclerView f260949a0;

    /* renamed from: b0, reason: collision with root package name */
    private com.tencent.mobileqq.profilesetting.f f260950b0;

    /* renamed from: c0, reason: collision with root package name */
    private CardSettingHandler f260951c0;

    /* renamed from: d0, reason: collision with root package name */
    private Card f260952d0;

    /* renamed from: e0, reason: collision with root package name */
    private ProfileConfig f260953e0;

    /* renamed from: f0, reason: collision with root package name */
    private ArrayList<u> f260954f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f260955g0;

    /* renamed from: h0, reason: collision with root package name */
    public com.tencent.mobileqq.troop.troopgame.api.b f260956h0;

    /* renamed from: i0, reason: collision with root package name */
    private com.tencent.mobileqq.profilesetting.a f260957i0;

    /* renamed from: j0, reason: collision with root package name */
    private f.a f260958j0;

    /* renamed from: k0, reason: collision with root package name */
    private LinearLayoutManager f260959k0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) InterestSwitchEditActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class b extends com.tencent.mobileqq.troop.troopgame.api.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) InterestSwitchEditActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.troopgame.api.b
        protected void onGetGameInfoCardSwitch(boolean z16, String str, QqCardSvrPB$GetSwitchRsp qqCardSvrPB$GetSwitchRsp) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, qqCardSvrPB$GetSwitchRsp);
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onGetGameInfoCardSwitch isSuccess uin=");
            sb5.append(str);
            sb5.append(",switchStatus=");
            if (qqCardSvrPB$GetSwitchRsp != null) {
                i3 = qqCardSvrPB$GetSwitchRsp.status.get();
            } else {
                i3 = -1;
            }
            sb5.append(i3);
            QLog.d("InterestSwitchEditActivity", 1, sb5.toString());
            if (!TextUtils.equals(InterestSwitchEditActivity.this.app.getCurrentAccountUin(), str)) {
                return;
            }
            if (!z16) {
                QQToast.makeText(InterestSwitchEditActivity.this, HardCodeUtil.qqStr(R.string.ng5), 0).show(InterestSwitchEditActivity.this.getTitleBarHeight());
                return;
            }
            String rangeString = ((IGameCenterAuthApi) QRoute.api(IGameCenterAuthApi.class)).getRangeString(MobileQQ.sMobileQQ, qqCardSvrPB$GetSwitchRsp.status.get());
            u c16 = w.INSTANCE.c(47196, InterestSwitchEditActivity.this.f260954f0);
            HashMap<String, Integer> hashMap = InterestSwitchEditActivity.f260946l0;
            if (hashMap.containsKey(rangeString)) {
                c16.o(hashMap.get(rangeString).intValue());
            } else {
                c16.o(3);
            }
            InterestSwitchEditActivity.this.d3();
        }

        @Override // com.tencent.mobileqq.troop.troopgame.api.b
        protected void onSetMyGameInfoCardSwitch(boolean z16, QqCardSvrPB$SetSwitchRsp qqCardSvrPB$SetSwitchRsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), qqCardSvrPB$SetSwitchRsp);
                return;
            }
            QLog.i("InterestSwitchEditActivity", 2, "onSetMyGameInfoCardSwitch isSuccess=" + z16 + ",status=" + qqCardSvrPB$SetSwitchRsp.status.get());
            String rangeString = ((IGameCenterAuthApi) QRoute.api(IGameCenterAuthApi.class)).getRangeString(MobileQQ.sMobileQQ, qqCardSvrPB$SetSwitchRsp.status.get());
            u c16 = w.INSTANCE.c(47196, InterestSwitchEditActivity.this.f260954f0);
            HashMap<String, Integer> hashMap = InterestSwitchEditActivity.f260946l0;
            if (hashMap.containsKey(rangeString)) {
                c16.o(hashMap.get(rangeString).intValue());
            } else {
                c16.o(3);
            }
            InterestSwitchEditActivity.this.d3();
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class c extends com.tencent.mobileqq.profilesetting.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) InterestSwitchEditActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.profilesetting.a
        public void onGetCardDisplaySetting(boolean z16, String str, Card card) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, card);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("InterestSwitchEditActivity", 2, "onGetCardDisplaySetting isSuccess=" + z16 + " uin=" + str);
            }
            if (!TextUtils.equals(InterestSwitchEditActivity.this.app.getCurrentAccountUin(), str)) {
                return;
            }
            if (z16) {
                InterestSwitchEditActivity interestSwitchEditActivity = InterestSwitchEditActivity.this;
                if (card == null) {
                    card = interestSwitchEditActivity.f260952d0;
                }
                interestSwitchEditActivity.f260952d0 = card;
                w.Companion companion = w.INSTANCE;
                InterestSwitchEditActivity interestSwitchEditActivity2 = InterestSwitchEditActivity.this;
                companion.i(interestSwitchEditActivity2.app, interestSwitchEditActivity2.f260952d0, InterestSwitchEditActivity.this.f260953e0, InterestSwitchEditActivity.this.f260954f0);
                InterestSwitchEditActivity.this.d3();
                return;
            }
            QQToast.makeText(InterestSwitchEditActivity.this, HardCodeUtil.qqStr(R.string.ng5), 0).show(InterestSwitchEditActivity.this.getTitleBarHeight());
        }

        @Override // com.tencent.mobileqq.profilesetting.a
        public void onSetCardDisplaySetting(boolean z16, String str, Card card, ArrayList<ReqSetSettingItem> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, card, arrayList);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("InterestSwitchEditActivity", 2, "onSetCardDisplaySetting isSuccess=" + z16 + " uin=" + str);
            }
            if (!TextUtils.equals(InterestSwitchEditActivity.this.app.getCurrentAccountUin(), str)) {
                return;
            }
            if (!z16) {
                QQToast.makeText(BaseApplicationImpl.sApplication, R.string.f180343at, 0).show(InterestSwitchEditActivity.this.getTitleBarHeight());
                if (arrayList != null) {
                    Iterator<ReqSetSettingItem> it = arrayList.iterator();
                    while (it.hasNext()) {
                        ReqSetSettingItem next = it.next();
                        w.INSTANCE.c(next.a(), InterestSwitchEditActivity.this.f260954f0).o(next.b());
                    }
                }
            }
            InterestSwitchEditActivity.this.d3();
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class d implements f.a {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) InterestSwitchEditActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.profilesetting.f.a
        public void a(@NotNull View view, u uVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                InterestSwitchEditActivity.this.e3(uVar);
                int c16 = uVar.c();
                if (c16 == 47187) {
                    InterestSwitchEditActivity.this.l3(uVar);
                    return;
                } else if (c16 != 47196) {
                    InterestSwitchEditActivity.this.j3(uVar);
                    return;
                } else {
                    ((IProfileGameCardApi) QRoute.api(IProfileGameCardApi.class)).showGameInfoActionSheet(InterestSwitchEditActivity.this.f260955g0, uVar);
                    return;
                }
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) uVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v10 */
        /* JADX WARN: Type inference failed for: r4v4, types: [int] */
        /* JADX WARN: Type inference failed for: r4v9 */
        @Override // com.tencent.mobileqq.profilesetting.f.a
        public void b(@NotNull View view, @Nullable u uVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) uVar);
                return;
            }
            if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                QQToast.makeText(BaseApplicationImpl.sApplication, R.string.f171137ci2, 0).show(InterestSwitchEditActivity.this.getTitleBarHeight());
                return;
            }
            if (uVar != null) {
                boolean f16 = uVar.f();
                ?? r46 = f16;
                if (w.INSTANCE.o(uVar.c())) {
                    r46 = !f16;
                }
                if (uVar.c() == 42340 && r46 == 1 && QQPlayerService.s0()) {
                    QQPlayerService.m1(BaseApplication.getContext());
                }
                InterestSwitchEditActivity.this.i3(uVar, r46);
                InterestSwitchEditActivity.this.c3(uVar);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class e extends LinearLayoutManager {
        static IPatchRedirector $redirector_;

        e(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) InterestSwitchEditActivity.this, (Object) context);
            }
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class f implements ActionSheetWithTick.d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ u f260965a;

        f(u uVar) {
            this.f260965a = uVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) InterestSwitchEditActivity.this, (Object) uVar);
            }
        }

        @Override // com.tencent.mobileqq.widget.ActionSheetWithTick.d
        public void onCancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.widget.ActionSheetWithTick.d
        public void onSelected(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                int Y2 = InterestSwitchEditActivity.this.Y2(i3);
                if (this.f260965a.a() != Y2) {
                    InterestSwitchEditActivity.this.g3(Y2, this.f260965a);
                    if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                        InterestSwitchEditActivity.this.i3(this.f260965a, Y2);
                        return;
                    } else {
                        QQToast.makeText(BaseApplicationImpl.sApplication, R.string.f171137ci2, 0).show(InterestSwitchEditActivity.this.getTitleBarHeight());
                        return;
                    }
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class g implements ActionSheetWithTick.d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ u f260967a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ActionSheetWithTick f260968b;

        g(u uVar, ActionSheetWithTick actionSheetWithTick) {
            this.f260967a = uVar;
            this.f260968b = actionSheetWithTick;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, InterestSwitchEditActivity.this, uVar, actionSheetWithTick);
            }
        }

        @Override // com.tencent.mobileqq.widget.ActionSheetWithTick.d
        public void onCancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.widget.ActionSheetWithTick.d
        public void onSelected(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            int b36 = InterestSwitchEditActivity.this.b3(i3);
            int e16 = this.f260967a.e();
            if (e16 != b36) {
                if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                    QQToast.makeText(BaseApplicationImpl.sApplication, R.string.f171137ci2, 0).show(InterestSwitchEditActivity.this.getTitleBarHeight());
                    return;
                } else if (e16 == 3 || (e16 == 4 && b36 != 3)) {
                    InterestSwitchEditActivity.this.n3(this.f260967a, b36);
                } else {
                    InterestSwitchEditActivity.this.i3(this.f260967a, b36);
                }
            }
            this.f260968b.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class h implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ u f260970d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f260971e;

        h(u uVar, int i3) {
            this.f260970d = uVar;
            this.f260971e = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, InterestSwitchEditActivity.this, uVar, Integer.valueOf(i3));
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                InterestSwitchEditActivity.this.i3(this.f260970d, this.f260971e);
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74213);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
            return;
        }
        f260946l0 = new LinkedHashMap<String, Integer>() { // from class: com.tencent.mobileqq.profilesetting.InterestSwitchEditActivity.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                    return;
                }
                put(PrivacyTextUtils.DESCRIPTION_VISIBLE_STATE_ALL, 1);
                put("\u4ec5\u81ea\u5df1\u53ef\u89c1", 2);
                put(PrivacyTextUtils.DESCRIPTION_VISIBLE_STATE_ALL_NOT, 3);
            }
        };
        f260947m0 = new int[]{1, 2, 3};
        f260948n0 = new int[]{0, 1, 2};
    }

    public InterestSwitchEditActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f260953e0 = null;
        this.f260954f0 = new ArrayList<>();
        this.f260955g0 = false;
        this.f260956h0 = new b();
        this.f260957i0 = new c();
        this.f260958j0 = new d();
        this.f260959k0 = new e(this);
    }

    public static Intent V2(Context context) {
        return new Intent(context, (Class<?>) InterestSwitchEditActivity.class);
    }

    private int W2(u uVar) {
        if (uVar == null) {
            return -1;
        }
        switch (uVar.c()) {
            case 40272:
                return 6;
            case 41607:
                return 11;
            case IProfileSettingApi.FIELD_PRIVACY_CONSTELLATION /* 41609 */:
                return 3;
            case 41610:
                return 2;
            case 41611:
                return 1;
            case 41613:
                return 8;
            case 41614:
                return 7;
            case 41618:
                return 5;
            case 41619:
                return 4;
            case 41622:
                return 9;
            case 41623:
                return 10;
            default:
                return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Y2(int i3) {
        if (i3 < 0 || i3 >= f260948n0.length) {
            i3 = 0;
        }
        return f260948n0[i3];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c3(u uVar) {
        String str;
        int i3;
        int i16;
        String str2;
        int i17;
        String str3;
        switch (uVar.c()) {
            case ProfileContants.FIELD_PERSONALITY_LABEL_SWITCH /* 42128 */:
                QQAppInterface qQAppInterface = this.app;
                if (uVar.f()) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                ReportController.o(qQAppInterface, "dc00898", "", "", "0X8008407", "0X8008407", i3, 0, "", "", "", "");
                return;
            case ProfileContants.FIELD_EXTEND_FRIEND_SWITCH /* 42172 */:
                if (uVar.f()) {
                    ReportController.o(this.app, "dc00898", "", "", "0X80092ED", "0X80092ED", 0, 0, "", "", "", "");
                    return;
                } else {
                    ReportController.o(this.app, "dc00898", "", "", "0X80092EE", "0X80092EE", 0, 0, "", "", "", "");
                    return;
                }
            case ProfileContants.FIELD_MUSICBOX_SWITCH /* 42340 */:
                QQAppInterface qQAppInterface2 = this.app;
                if (uVar.f()) {
                    i16 = 1;
                } else {
                    i16 = 2;
                }
                ReportController.o(qQAppInterface2, "dc00898", "", "", "0X800A7DA", QQPermissionConstants.Business.SCENE.QQ_VIP, i16, 0, "", "", "", "");
                return;
            case ProfileContants.FIELD_STICKY_NOTE_SWITCH /* 42356 */:
                ReportController.o(this.app, "dc00898", "", "", "0X800AB37", "0X800AB37", 0, 0, "", "", "", "");
                return;
            case ProfileContants.FIELD_WEISHI_SWITCH /* 42377 */:
                ((IWSMinePanel) QRoute.api(IWSMinePanel.class)).reportProfileSettingBtnClick(uVar.f());
                return;
            case 42425:
                if (!uVar.f()) {
                    ReportController.o(this.app, "dc00898", "", "", "0X800B479", "0X800B479", 0, 0, "", "", "", "");
                    return;
                }
                return;
            case ProfileContants.FIELD_DRESSUP_SWITCH /* 47177 */:
                if (uVar.f()) {
                    str2 = "0X800C4BD";
                } else {
                    str2 = "0X800C4BE";
                }
                String str4 = str2;
                QQAppInterface qQAppInterface3 = this.app;
                if (uVar.f()) {
                    i17 = 1;
                } else {
                    i17 = 2;
                }
                ReportController.o(qQAppInterface3, "dc00898", "", "", str4, str4, i17, 0, "", "", "", "");
                return;
            case ProfileContants.FIELD_QQCARD_SWITCH /* 47180 */:
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (uVar.f()) {
                        str = "open";
                    } else {
                        str = "close";
                    }
                    jSONObject.putOpt(ProfileCardBlacklistReportConst.ELEM_PARAM_SWITCH_STATUS, str);
                    MobileReportManager.getInstance().reportAction("qqcard_switch", "4", "data_card", "set_page", "set_list", 102, 1, System.currentTimeMillis(), jSONObject.toString());
                    return;
                } catch (JSONException e16) {
                    QLog.e("InterestSwitchEditActivity", 1, e16.getCause(), new Object[0]);
                    return;
                }
            case ProfileContants.FIELD_Q_CUB_SWITCH /* 47184 */:
                HashMap hashMap = new HashMap();
                hashMap.put("op_type", "click");
                hashMap.put(MiniAppSetGameBoxOptionsServlet.KEY_RESULT, Integer.valueOf(uVar.h()));
                VideoReport.reportEvent("ev_bas_data_card_set_switch", hashMap);
                return;
            case ProfileContants.FIELD_META_FARM_SWITCH /* 47201 */:
                HashMap hashMap2 = new HashMap();
                if (uVar.f()) {
                    str3 = "1";
                } else {
                    str3 = "0";
                }
                hashMap2.put("ext49", str3);
                ((IMiniGameVAUtilsApi) QRoute.api(IMiniGameVAUtilsApi.class)).reportMiniGameCenterDC00087("5", "9529", "9740", "974001", "989666", "20", "", hashMap2);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e3(u uVar) {
        switch (uVar.c()) {
            case 40272:
                ReportController.o(this.app, "dc00898", "", "", "0X800B1D0", "0X800B1D0", 0, 0, "", "", "", "");
                return;
            case 41607:
                ReportController.o(this.app, "dc00898", "", "", "0X800B1CD", "0X800B1CD", 0, 0, "", "", "", "");
                return;
            case IProfileSettingApi.FIELD_PRIVACY_CONSTELLATION /* 41609 */:
                ReportController.o(this.app, "dc00898", "", "", "0X800B1D6", "0X800B1D6", 0, 0, "", "", "", "");
                return;
            case 41610:
                ReportController.o(this.app, "dc00898", "", "", "0X800B1D5", "0X800B1D5", 0, 0, "", "", "", "");
                return;
            case 41611:
                ReportController.o(this.app, "dc00898", "", "", "0X800B1CC", "0X800B1CC", 0, 0, "", "", "", "");
                return;
            case 41613:
                ReportController.o(this.app, "dc00898", "", "", "0X800B1D2", "0X800B1D2", 0, 0, "", "", "", "");
                return;
            case 41614:
                ReportController.o(this.app, "dc00898", "", "", "0X800B1D1", "0X800B1D1", 0, 0, "", "", "", "");
                return;
            case 41618:
                ReportController.o(this.app, "dc00898", "", "", "0X800B1CF", "0X800B1CF", 0, 0, "", "", "", "");
                return;
            case 41619:
                ReportController.o(this.app, "dc00898", "", "", "0X800B1CE", "0X800B1CE", 0, 0, "", "", "", "");
                return;
            case 41622:
                ReportController.o(this.app, "dc00898", "", "", "0X800B1D3", "0X800B1D3", 0, 0, "", "", "", "");
                return;
            case 41623:
                ReportController.o(this.app, "dc00898", "", "", "0X800B1D4", "0X800B1D4", 0, 0, "", "", "", "");
                return;
            default:
                return;
        }
    }

    private void f3() {
        ArrayList<u> arrayList = this.f260954f0;
        if (arrayList != null) {
            w.Companion companion = w.INSTANCE;
            u c16 = companion.c(47196, arrayList);
            int j3 = companion.j(47196, this.f260952d0, this.app);
            if (c16 != null) {
                QQAppInterface qQAppInterface = this.app;
                int i3 = 1;
                if (j3 != 1) {
                    i3 = 2;
                }
                ReportController.o(qQAppInterface, "dc00898", "", "", "0X800B5F0", "0X800B5F0", i3, 0, "", "", "", "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g3(int i3, u uVar) {
        int W2 = W2(uVar);
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ReportController.o(this.app, "dc00898", "", "", "0X800B1D8", "0X800B1D8", W2, 0, "", "", "", "");
                    return;
                }
                return;
            }
            ReportController.o(this.app, "dc00898", "", "", "0X800B1D9", "0X800B1D9", W2, 0, "", "", "", "");
            return;
        }
        ReportController.o(this.app, "dc00898", "", "", "0X800B1D7", "0X800B1D7", W2, 0, "", "", "", "");
    }

    private void h3() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Iterator<u> it = this.f260954f0.iterator();
        while (it.hasNext()) {
            u next = it.next();
            if (next.c() != -1) {
                arrayList.add(Integer.valueOf(next.c()));
            }
        }
        this.f260951c0.H2(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i3(u uVar, int i3) {
        if (uVar != null && uVar.c() == 47201 && i3 == 0) {
            i3 = 2;
        }
        if (uVar != null && uVar.c() != -1) {
            ArrayList<ReqSetSettingItem> arrayList = new ArrayList<>();
            arrayList.add(new ReqSetSettingItem(uVar.c(), uVar.h(), i3));
            uVar.o(i3);
            uVar.m(true);
            this.f260951c0.I2(arrayList);
        }
    }

    private void initDtReport() {
        VideoReport.addToDetectionWhitelist(this);
        VideoReport.setPageId(this.titleRoot, "pg_user_profile_set");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j3(u uVar) {
        ActionSheetWithTick X = ActionSheetWithTick.X(this, this.f260955g0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(getString(R.string.f175802zj));
        arrayList.add(getString(R.string.f17601304));
        arrayList.add(getString(R.string.f17602305));
        X.a0(arrayList);
        X.c0(uVar.a());
        X.d0(true);
        X.b0(new f(uVar));
        if (!isFinishing()) {
            X.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l3(u uVar) {
        ActionSheetWithTick X = ActionSheetWithTick.X(this, this.f260955g0);
        X.a0(new ArrayList(f260946l0.keySet()));
        X.c0(Z2(uVar.e()));
        X.d0(true);
        X.b0(new g(uVar, X));
        if (!isFinishing()) {
            X.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n3(u uVar, int i3) {
        DialogUtil.createCustomDialog(getActivity(), 0, getString(R.string.f175602z0), getString(R.string.f175592yz), getString(R.string.f175652z5), getString(R.string.f175662z6), new h(uVar, i3), new a()).show();
    }

    public int Z2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, i3)).intValue();
        }
        int i16 = 0;
        while (true) {
            int[] iArr = f260947m0;
            if (i16 < iArr.length) {
                if (iArr[i16] == i3) {
                    return i16;
                }
                i16++;
            } else {
                return iArr[iArr.length - 1];
            }
        }
    }

    public int b3(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, i3)).intValue();
        }
        if (i3 < 0 || i3 >= f260948n0.length) {
            i3 = 0;
        }
        return f260947m0[i3];
    }

    public void d3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.profilesetting.InterestSwitchEditActivity.6
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) InterestSwitchEditActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        InterestSwitchEditActivity.this.f260950b0.setData(InterestSwitchEditActivity.this.f260954f0);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle)).booleanValue();
        }
        this.mNeedStatusTrans = !isInMultiWindow();
        super.doOnCreate(bundle);
        this.mNeedStatusTrans = true;
        super.setContentView(R.layout.azu);
        this.app.addObserver(this.f260957i0);
        this.app.addObserver(this.f260956h0);
        setTitle(getString(R.string.d26));
        this.f260949a0 = (RecyclerView) findViewById(R.id.f164589t55);
        this.f260950b0 = new com.tencent.mobileqq.profilesetting.f(this, this.f260958j0);
        this.f260949a0.setLayoutManager(this.f260959k0);
        this.f260949a0.setAdapter(this.f260950b0);
        ProfileConfig profileConfig = new ProfileConfig(this.app);
        this.f260953e0 = profileConfig;
        ((IWSMinePanel) QRoute.api(IWSMinePanel.class)).reportProfileSettingExposure(profileConfig.isSwitchEnable(11));
        this.f260952d0 = ((FriendsManager) this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).q(this.app.getCurrentUin());
        this.f260954f0.clear();
        w.Companion companion = w.INSTANCE;
        companion.i(this.app, this.f260952d0, this.f260953e0, this.f260954f0);
        ((IProfileGameCardApi) QRoute.api(IProfileGameCardApi.class)).onInterestSwitchEditActivityCreate(this);
        f3();
        boolean m3 = companion.m(this.f260954f0);
        this.f260951c0 = (CardSettingHandler) this.app.getBusinessHandler(BusinessHandlerFactory.CARD_SETTING_HANDLER);
        if (m3) {
            if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                QQToast.makeText(BaseApplicationImpl.sApplication, R.string.f171137ci2, 0).show(getTitleBarHeight());
            } else {
                h3();
            }
        }
        this.f260955g0 = ThemeUtil.isNowThemeIsNight(this.app, false, null);
        d3();
        ((IProfileGameCardApi) QRoute.api(IProfileGameCardApi.class)).getAuthFromServer();
        if (QLog.isColorLevel()) {
            QLog.i("InterestSwitchEditActivity", 2, String.format("doOnCreate needReq=%s items=%s", Boolean.valueOf(m3), this.f260954f0));
        }
        initDtReport();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.doOnDestroy();
        ProfileConfig profileConfig = this.f260953e0;
        if (profileConfig != null) {
            profileConfig.destroy();
            this.f260953e0 = null;
        }
        ((IProfileGameCardApi) QRoute.api(IProfileGameCardApi.class)).onInterestSwitchEditActivityDestroy();
        this.app.removeObserver(this.f260957i0);
        this.app.removeObserver(this.f260956h0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.doOnPause();
            ((IWSMinePanel) QRoute.api(IWSMinePanel.class)).reportProfileSettingPageVisitExit();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.doOnResume();
            ((IWSMinePanel) QRoute.api(IWSMinePanel.class)).reportProfileSettingPageVisitEnter();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        Intent intent = new Intent();
        w.Companion companion = w.INSTANCE;
        intent.putExtra(IProfileCardConst.PARAM_SWITCHES_CHANGED, Boolean.valueOf(companion.l(this.f260954f0)));
        u c16 = companion.c(ProfileContants.FIELD_WEISHI_SWITCH, this.f260954f0);
        if (c16 != null && c16.b() && c16.f()) {
            intent.putExtra("key_weishi_switch", true);
        }
        u c17 = companion.c(ProfileContants.FIELD_PERSONALITY_LABEL_SWITCH, this.f260954f0);
        if (c17 != null && c17.b()) {
            intent.putExtra("key_personality_label_switch", c17.f());
        }
        setResult(-1, intent);
        super.finish();
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity
    public void showStatusBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else if (!isInMultiWindow()) {
            super.showStatusBar();
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return true;
    }
}
