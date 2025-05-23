package com.tencent.mobileqq.setting.utils;

import android.app.Activity;
import android.content.DialogInterface;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.setting.utils.q;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.util.Pair;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u001e\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/setting/utils/q;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lkotlin/Function0;", "", "refreshSubAccount", "Lcom/tencent/mobileqq/app/BaseMessageObserver;", "a", "<init>", "()V", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public static final q f286771a = new q();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/setting/utils/q$a", "Lcom/tencent/mobileqq/app/bs;", "", "isSuccess", "", "subUin", "Lcom/tencent/mobileqq/subaccount/logic/a;", "data", "", "onPushSubAccountMsg", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a extends bs {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f286772d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f286773e;

        a(Activity activity, Function0<Unit> function0) {
            this.f286772d = activity;
            this.f286773e = function0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final void b(ISubAccountControlService subControl, Pair pair, DialogInterface dialogInterface, int i3) {
            Intrinsics.checkNotNullParameter(subControl, "$subControl");
            String str = (String) pair.first;
            S s16 = pair.second;
            Intrinsics.checkNotNullExpressionValue(s16, "p.second");
            subControl.cancelHintDialog(str, ((Number) s16).intValue(), true);
        }

        @Override // com.tencent.mobileqq.app.bs
        public void onPushSubAccountMsg(boolean isSuccess, String subUin, com.tencent.mobileqq.subaccount.logic.a data) {
            Intrinsics.checkNotNullParameter(subUin, "subUin");
            Intrinsics.checkNotNullParameter(data, "data");
            Activity activity = this.f286772d;
            QBaseActivity qBaseActivity = activity instanceof QBaseActivity ? (QBaseActivity) activity : null;
            if (qBaseActivity == null || qBaseActivity.isFinishing()) {
                return;
            }
            this.f286773e.invoke();
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
            if (appInterface == null) {
                return;
            }
            IRuntimeService runtimeService = appInterface.getRuntimeService(ISubAccountControlService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026nt.MAIN\n                )");
            final ISubAccountControlService iSubAccountControlService = (ISubAccountControlService) runtimeService;
            if (data.f291121a == 1) {
                if (qBaseActivity.isResume() && ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).needShowHintDialog(appInterface, ISubAccountControlService.UIN_ALL)) {
                    ArrayList<Pair<String, Integer>> popWaittingHintPair = iSubAccountControlService.popWaittingHintPair(ISubAccountControlService.UIN_ALL);
                    int size = popWaittingHintPair.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        final Pair<String, Integer> pair = popWaittingHintPair.get(i3);
                        iSubAccountControlService.showHintDialog(appInterface, qBaseActivity, pair, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.setting.utils.p
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i16) {
                                q.a.b(ISubAccountControlService.this, pair, dialogInterface, i16);
                            }
                        });
                    }
                    return;
                }
                return;
            }
            if (qBaseActivity.isResume()) {
                iSubAccountControlService.cancelHintDialog(subUin, 1, true);
            }
        }
    }

    q() {
    }

    public final BaseMessageObserver a(Activity activity, Function0<Unit> refreshSubAccount) {
        Intrinsics.checkNotNullParameter(refreshSubAccount, "refreshSubAccount");
        return new a(activity, refreshSubAccount);
    }
}
