package com.tencent.mobileqq.activity.aio.tips;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.aio.notification.AIONotificationBusiId;
import com.tencent.mobileqq.aio.notification.IAIONotificationUIModel;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.x.q;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IMobileReportManager;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.search.SearchConstants;
import com.tencent.mobileqq.vas.toggle.UnitedProxy;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class UpgradeBigTroopNtTipsBar extends com.tencent.qqnt.aio.toptips.a implements View.OnClickListener, com.tencent.mobileqq.aio.notification.e {

    /* renamed from: i, reason: collision with root package name */
    public static final String f180076i = BigTroopExpiredNtTipsBar.E;

    /* renamed from: m, reason: collision with root package name */
    private static final UnitedProxy f180077m = ar.a("shouyouye", "2024-04-10", "vas_troop_upgrade_url_config");

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.qqnt.aio.toptips.c f180078d;

    /* renamed from: e, reason: collision with root package name */
    private String f180079e;

    /* renamed from: f, reason: collision with root package name */
    boolean f180080f = false;

    /* renamed from: h, reason: collision with root package name */
    private String f180081h;

    private void r(Context context) {
        if (context == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("UpgradeBigTroopNtTipsBar", 2, "click tips, jump");
        }
        String t16 = t();
        try {
            if (t16.contains("groupId=%s")) {
                t16 = t16.replace("groupId=%s", "groupId=" + this.f180079e);
            }
            if (t16.contains("from=%s")) {
                t16 = t16.replace("from=%s", "from=aio");
            }
        } catch (Exception e16) {
            QLog.e("UpgradeBigTroopNtTipsBar", 1, "contentClick format exception", e16);
        }
        if (!t16.startsWith("http") && !t16.startsWith(q.f250389u)) {
            ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openSchema(context, t16);
        } else {
            Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", t16);
            intent.putExtra("hide_operation_bar", true);
            if (context instanceof Application) {
                intent.setFlags(268435456);
            }
            context.startActivity(intent);
        }
        TroopManager troopManager = (TroopManager) MobileQQ.sMobileQQ.peekAppRuntime().getManager(QQManagerFactory.TROOP_MANAGER);
        if (TextUtils.isEmpty(this.f180081h)) {
            troopManager.C0(this.f180079e, 3);
        } else {
            troopManager.B0(this.f180079e, 3, this.f180081h);
        }
        com.tencent.qqnt.aio.toptips.c cVar = this.f180078d;
        if (cVar != null) {
            cVar.h(this);
        }
        if (TextUtils.isEmpty(this.f180081h)) {
            w(102, TroopAvatarWallPreviewActivity.PUBLIC_ACCOUNT_IMAGE_SID);
        } else {
            w(102, this.f180081h);
        }
        ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00899", "Grp_up", "", "Grp_AIO", "clk", 0, 0, this.f180079e, "", "", "");
    }

    private String s() {
        if (TextUtils.isEmpty(this.f180081h)) {
            return "\u672c\u7fa4\u5df2\u6ee1500\u4eba\uff0c\u5feb\u5347\u7ea7\u4e3a2000\u4eba\u7fa4\u5427\uff01";
        }
        return "\u7fa4\u4eba\u6570\u5373\u5c06\u8fbe\u5230\u4e0a\u9650\uff0c\u7acb\u5373\u5347\u7ea7\u7fa4\u804a\uff01";
    }

    public static String t() {
        return BigTroopExpiredNtTipsBar.D();
    }

    private boolean u(String str) {
        if (VasNormalToggle.UPGRADE_BIG_TROOP_FEATURE.getJson().optInt("" + str, 0) != 1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit v(IAIONotificationUIModel iAIONotificationUIModel, Integer num) {
        r(Foreground.getTopActivity());
        return null;
    }

    private void w(int i3, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("guide_type", str);
            ((IMobileReportManager) QRoute.api(IMobileReportManager.class)).reportAction(SearchConstants.PLATFORM, "aio_group", "\u8d85\u5927\u7fa4\u5f15\u5bfc\u5c0f\u6a2a\u6761", "", "guide_tips", "", "4", i3, 0, 0, "", jSONObject.toString(), "");
        } catch (Exception e16) {
            QLog.e("UpgradeBigTroopNtTipsBar", 1, "exception happened: " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(TroopManager troopManager, TroopInfo troopInfo) {
        if (!this.f180080f && troopManager.s().f402022d && troopInfo != null && troopInfo.isTroopOwner(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin())) {
            if (VasNormalToggle.UPGRADE_BIG_TROOP_FEATURE.isEnable(true)) {
                if (u("1") && y(troopInfo, troopManager, 150, 500, "500")) {
                    return;
                }
                if (u("2") && y(troopInfo, troopManager, 400, 1000, "1000")) {
                    return;
                }
                if (u("3") && y(troopInfo, troopManager, 900, 2000, TroopAvatarWallPreviewActivity.PUBLIC_ACCOUNT_IMAGE_SID)) {
                    return;
                }
                if (u("4") && y(troopInfo, troopManager, FSUploadConst.ERR_FILE_NOT_EXIST, 3000, QzoneConfig.DefaultValue.DEFAULT_GIF_ANTISHAKE_MAX_FRAME_SHOOTTIME)) {
                    return;
                }
            }
            int L = troopManager.L(this.f180079e);
            if (L < 3 && troopInfo.wMemberMax < 2000 && troopInfo.wMemberNum >= 500 && this.f180078d.e(this)) {
                this.f180080f = true;
                troopManager.C0(this.f180079e, L + 1);
                w(101, TroopAvatarWallPreviewActivity.PUBLIC_ACCOUNT_IMAGE_SID);
                ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00899", "Grp_up", "", "Grp_AIO", "exp", 0, 0, this.f180079e, "", "", "");
            }
        }
    }

    private boolean y(TroopInfo troopInfo, TroopManager troopManager, int i3, int i16, String str) {
        if (troopInfo.wMemberNum >= i3 && troopInfo.wMemberMax < i16) {
            int K = troopManager.K(this.f180079e, str);
            if (K < 3) {
                this.f180081h = str;
                if (this.f180078d.e(this)) {
                    this.f180080f = true;
                    troopManager.B0(this.f180079e, K + 1, str);
                    w(101, this.f180081h);
                    ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00899", "Grp_up", "", "Grp_AIO", "exp", 0, 0, this.f180079e, "", "", "");
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    @Nullable
    public View a(@NonNull Object... objArr) {
        View inflate = LayoutInflater.from(BaseApplication.context).inflate(R.layout.f167636ch, (ViewGroup) null);
        String s16 = s();
        if (!TextUtils.isEmpty(s16)) {
            ((TextView) inflate.findViewById(R.id.f164238o6)).setText(s16);
        }
        inflate.setOnClickListener(this);
        return inflate;
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    @Nullable
    public int[] b() {
        return new int[0];
    }

    @Override // com.tencent.mobileqq.aio.notification.e
    @NonNull
    public IAIONotificationUIModel e() {
        return new IAIONotificationUIModel.b(AIONotificationBusiId.UPGRADE_BIG_TROOP, s(), IAIONotificationUIModel.ActionIcon.ARROW, "", 0, new Function2() { // from class: com.tencent.mobileqq.activity.aio.tips.h
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit v3;
                v3 = UpgradeBigTroopNtTipsBar.this.v((IAIONotificationUIModel) obj, (Integer) obj2);
                return v3;
            }
        });
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    public void g(@NonNull final com.tencent.qqnt.aio.toptips.c cVar, int i3, @NonNull Object... objArr) {
        if (i3 == 1005) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.tips.UpgradeBigTroopNtTipsBar.1
                @Override // java.lang.Runnable
                public void run() {
                    UpgradeBigTroopNtTipsBar.this.f180078d = cVar;
                    UpgradeBigTroopNtTipsBar.this.f180079e = cVar.a().g().r().c().j();
                    final TroopManager troopManager = (TroopManager) MobileQQ.sMobileQQ.peekAppRuntime().getManager(QQManagerFactory.TROOP_MANAGER);
                    final TroopInfo k3 = troopManager.k(UpgradeBigTroopNtTipsBar.this.f180079e);
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.tips.UpgradeBigTroopNtTipsBar.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            UpgradeBigTroopNtTipsBar.this.x(troopManager, k3);
                        }
                    });
                }
            }, 16, null, false);
        }
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    public int getType() {
        return 111;
    }

    @Override // com.tencent.mobileqq.aio.notification.d
    @NonNull
    public List<AIONotificationBusiId> h() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(AIONotificationBusiId.UPGRADE_BIG_TROOP);
        return arrayList;
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    public int j() {
        return 13;
    }

    @Override // com.tencent.mobileqq.aio.notification.d
    public void m(@NonNull com.tencent.mobileqq.aio.notification.c cVar, int i3, @NonNull Object... objArr) {
        g((com.tencent.qqnt.aio.toptips.c) cVar, i3, objArr);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f164226nu) {
            r(view.getContext());
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
