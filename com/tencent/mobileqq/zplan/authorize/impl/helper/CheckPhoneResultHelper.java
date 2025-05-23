package com.tencent.mobileqq.zplan.authorize.impl.helper;

import android.content.Context;
import android.content.DialogInterface;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.ICommonApi;
import com.tencent.mobileqq.zootopia.api.f;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.authorize.impl.manager.CheckPhoneManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.state.report.SquareReportConst;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ,\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0002J<\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0002J\"\u0010\u0014\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u001a\u0010\u0016\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0002J:\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001a2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/zplan/authorize/impl/helper/CheckPhoneResultHelper;", "", "Landroid/content/Context;", "context", "", "title", "Lkotlin/Function1;", "", "", "onDialogClickCallback", "j", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "", "reason", "l", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "dialog", "Lid3/d;", "reportHelper", "g", "Landroid/content/DialogInterface;", h.F, "i", "f", WadlProxyConsts.SCENE_ID, "Lcom/tencent/mobileqq/zplan/authorize/impl/manager/CheckPhoneManager$EntryType;", "entryType", "e", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class CheckPhoneResultHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final CheckPhoneResultHelper f331480a = new CheckPhoneResultHelper();

    CheckPhoneResultHelper() {
    }

    private final boolean f(int reason) {
        return ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getBoolean("key_has_show_gray_dialog" + reason, false);
    }

    private final void h(DialogInterface dialog, id3.d reportHelper) {
        if (dialog instanceof QQCustomDialog) {
            ViewGroup rootView = ((QQCustomDialog) dialog).getRootView();
            Intrinsics.checkNotNullExpressionValue(rootView, "dialog.rootView");
            reportHelper.c("pgout", rootView, new LinkedHashMap());
        }
    }

    private final void i(int reason) {
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setBoolean("key_has_show_gray_dialog" + reason, true);
    }

    private final void j(Context context, String title, final Function1<? super Boolean, Unit> onDialogClickCallback) {
        com.tencent.mobileqq.zootopia.api.f dialogHandler = ((ICommonApi) QRoute.api(ICommonApi.class)).getDialogHandler();
        String string = context.getString(R.string.f169771xi3);
        String string2 = context.getString(R.string.f169770xi2);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026mmon_dialog_tips_confirm)");
        f.a.a(dialogHandler, string, title, "", string2, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zplan.authorize.impl.helper.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                CheckPhoneResultHelper.k(Function1.this, dialogInterface, i3);
            }
        }, null, null, 64, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Function1 onDialogClickCallback, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(onDialogClickCallback, "$onDialogClickCallback");
        onDialogClickCallback.invoke(Boolean.FALSE);
        dialogInterface.dismiss();
    }

    private final void l(Context context, final ZootopiaSource source, String title, final int reason, final Function1<? super Boolean, Unit> onDialogClickCallback) {
        if (f(reason)) {
            QLog.i("CheckPhoneResultHelper", 1, "showGrayForbiddenDialog :: gray dialog has showed , just enter");
            onDialogClickCallback.invoke(Boolean.TRUE);
            return;
        }
        final id3.d dVar = new id3.d(null, 1, null);
        QLog.i("CheckPhoneResultHelper", 1, "showGrayForbiddenDialog :: gray dialog never show , just show dialog");
        com.tencent.mobileqq.zootopia.api.f dialogHandler = ((ICommonApi) QRoute.api(ICommonApi.class)).getDialogHandler();
        String string = context.getString(R.string.f169771xi3);
        String string2 = context.getString(R.string.f169768xi0);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(com.te\u2026R.string.zootopia_cancel)");
        String string3 = context.getString(R.string.xkd);
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(com.te\u2026l.R.string.zootopia_sure)");
        dialogHandler.a(string, title, string2, string3, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zplan.authorize.impl.helper.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                CheckPhoneResultHelper.m(Function1.this, reason, dVar, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zplan.authorize.impl.helper.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                CheckPhoneResultHelper.n(Function1.this, dVar, dialogInterface, i3);
            }
        }, new Function1<QQCustomDialog, Unit>() { // from class: com.tencent.mobileqq.zplan.authorize.impl.helper.CheckPhoneResultHelper$showGrayForbiddenDialog$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQCustomDialog qQCustomDialog) {
                invoke2(qQCustomDialog);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QQCustomDialog qQCustomDialog) {
                CheckPhoneResultHelper.f331480a.g(qQCustomDialog, ZootopiaSource.this, dVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Function1 onDialogClickCallback, int i3, id3.d reportHelper, DialogInterface dialogInterface, int i16) {
        Intrinsics.checkNotNullParameter(onDialogClickCallback, "$onDialogClickCallback");
        Intrinsics.checkNotNullParameter(reportHelper, "$reportHelper");
        onDialogClickCallback.invoke(Boolean.TRUE);
        dialogInterface.dismiss();
        CheckPhoneResultHelper checkPhoneResultHelper = f331480a;
        checkPhoneResultHelper.i(i3);
        checkPhoneResultHelper.h(dialogInterface, reportHelper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Function1 onDialogClickCallback, id3.d reportHelper, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(onDialogClickCallback, "$onDialogClickCallback");
        Intrinsics.checkNotNullParameter(reportHelper, "$reportHelper");
        onDialogClickCallback.invoke(Boolean.FALSE);
        dialogInterface.dismiss();
        f331480a.h(dialogInterface, reportHelper);
    }

    public final void e(Context context, ZootopiaSource source, int sceneId, CheckPhoneManager.EntryType entryType, Function1<? super Boolean, Unit> onDialogClickCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(entryType, "entryType");
        Intrinsics.checkNotNullParameter(onDialogClickCallback, "onDialogClickCallback");
        CheckPhoneManager checkPhoneManager = CheckPhoneManager.f331491a;
        gw4.b j3 = checkPhoneManager.j(checkPhoneManager.k(sceneId, entryType));
        if (j3 == null) {
            String string = context.getString(R.string.f169772xi4);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026_common_has_no_authorize)");
            j(context, string, onDialogClickCallback);
            return;
        }
        gw4.f fVar = j3.f403460b;
        int i3 = fVar.f403471b;
        if (i3 == 0) {
            String str = fVar.f403472c;
            if (str == null || str.length() == 0) {
                String string2 = context.getString(R.string.f169772xi4);
                Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026_common_has_no_authorize)");
                j(context, string2, onDialogClickCallback);
                return;
            } else {
                String str2 = j3.f403460b.f403472c;
                Intrinsics.checkNotNullExpressionValue(str2, "checkEntranceResult.commonResult.toastMessage");
                j(context, str2, onDialogClickCallback);
                return;
            }
        }
        if (i3 == 2) {
            String str3 = fVar.f403472c;
            if (str3 == null || str3.length() == 0) {
                String string3 = context.getString(R.string.xi5);
                Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026on_has_no_authorize_gray)");
                l(context, source, string3, j3.f403460b.f403473d, onDialogClickCallback);
                return;
            } else {
                String str4 = j3.f403460b.f403472c;
                Intrinsics.checkNotNullExpressionValue(str4, "checkEntranceResult.commonResult.toastMessage");
                l(context, source, str4, j3.f403460b.f403473d, onDialogClickCallback);
                return;
            }
        }
        QLog.e("CheckPhoneResultHelper", 1, "handleCheckFailed :: some error happened");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(QQCustomDialog dialog, ZootopiaSource source, id3.d reportHelper) {
        if (dialog != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ah.b(source));
            ViewGroup rootView = dialog.getRootView();
            Intrinsics.checkNotNullExpressionValue(rootView, "it.rootView");
            reportHelper.j(dialog, rootView, "pg_zplan_greylist_win", hashMap);
            ViewGroup rootView2 = dialog.getRootView();
            Intrinsics.checkNotNullExpressionValue(rootView2, "it.rootView");
            reportHelper.c("pgin", rootView2, new LinkedHashMap());
            TextView btnLeft = dialog.getBtnLeft();
            Intrinsics.checkNotNullExpressionValue(btnLeft, "it.btnLeft");
            id3.d.i(reportHelper, btnLeft, "em_zplan_greylist_win_close", new HashMap(), true, true, null, false, false, 224, null);
            TextView btnight = dialog.getBtnight();
            Intrinsics.checkNotNullExpressionValue(btnight, "it.btnight");
            id3.d.i(reportHelper, btnight, "em_zplan_greylist_win_confirm", new HashMap(), true, true, null, false, false, 224, null);
        }
    }
}
