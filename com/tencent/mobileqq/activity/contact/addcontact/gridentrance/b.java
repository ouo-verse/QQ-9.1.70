package com.tencent.mobileqq.activity.contact.addcontact.gridentrance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.contact.addcontact.face2face.Face2FaceAddContactFragment;
import com.tencent.mobileqq.activity.phone.DenyRunnable;
import com.tencent.mobileqq.activity.phone.PhoneMatchActivity;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.flock.api.FlockConstants$FlockListScene;
import com.tencent.mobileqq.flock.api.IFlockLauncher;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyRouter;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0007J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0007J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J \u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0007J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/gridentrance/b;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "", "b", "", "newFromSource", "e", tl.h.F, "Landroid/view/View;", "itemView", "g", "i", "f", "", "autoReqLocation", "d", "k", "j", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f181153a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50382);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f181153a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void b(@NotNull final Activity activity, @NotNull final QQAppInterface app) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(app, "app");
        IRuntimeService runtimeService = app.getRuntimeService(IPhoneContactService.class);
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IP\u2026ntactService::class.java)");
        final IPhoneContactService iPhoneContactService = (IPhoneContactService) runtimeService;
        int selfBindState = iPhoneContactService.getSelfBindState();
        if (QLog.isColorLevel()) {
            QLog.d("AddContactEntryClickDelegate", 2, "onClick ADD_PHONE_CONTACTS_ID selfBindState=" + selfBindState);
        }
        switch (selfBindState) {
            case 0:
            case 1:
            case 3:
            case 5:
            case 6:
            case 7:
                Intent intent = new Intent(activity, (Class<?>) PhoneMatchActivity.class);
                intent.putExtra("kSrouce", 14);
                activity.startActivity(intent);
                break;
            case 2:
            case 4:
            case 8:
            case 9:
                PermissionChecker.e(activity, new Runnable() { // from class: com.tencent.mobileqq.activity.contact.addcontact.gridentrance.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.c(activity, app, iPhoneContactService);
                    }
                }, new DenyRunnable(activity, 2));
                break;
        }
        ReportController.o(app, "CliOper", "", "", "0X800474A", "0X800474A", 0, 0, "", "", "", "");
        ReportController.o(app, "dc00898", "", "", "0X80068A6", "0X80068A6", 0, 0, "", "", "", "");
        if (selfBindState == 1 || selfBindState == 5) {
            ReportController.o(app, "dc00898", "", "", "0X80068A7", "0X80068A7", 0, 0, "", "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Activity activity, QQAppInterface app, IPhoneContactService phoneContactService) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(phoneContactService, "$phoneContactService");
        ContactBindedActivity.T2(activity, app, 222, phoneContactService.generateRandomList());
    }

    @JvmStatic
    public static final void d(@NotNull Activity activity, @NotNull QQAppInterface app, boolean autoReqLocation) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(app, "app");
        activity.startActivity(new Intent(activity, (Class<?>) ConditionSearchFriendActivity.class).putExtra("from", "addcontacts").putExtra("key_first_req_location", autoReqLocation));
        ReportController.o(app, "CliOper", "", "", "0X8004240", "0X8004240", 0, 0, "", "", "", "");
    }

    @JvmStatic
    public static final void e(@NotNull Activity activity, @NotNull QQAppInterface app, int newFromSource) {
        int i3;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(app, "app");
        Intent intent = new Intent(activity, (Class<?>) CreateFaceToFaceDiscussionActivity.class);
        if (newFromSource != 1) {
            if (newFromSource != 2) {
                i3 = 7;
            } else {
                i3 = 4;
            }
        } else {
            i3 = 5;
        }
        intent.putExtra("create_source", i3);
        activity.startActivity(intent);
        ReportController.o(app, "CliOper", "", "", "0X800776D", "0X800776D", 0, 0, "", "", "", "");
    }

    @JvmStatic
    public static final void f(@NotNull Activity activity, @NotNull QQAppInterface app) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(app, "app");
        String str = "https://ti.qq.com/growreg/index.html?_bid=3381&_wv=2&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=0085f5&_nav_anim=true&_wwv=128&adtag=add_contact";
        String B = ea.B(app.getApp(), app.getCurrentAccountUin(), AppConstants.Preferences.REGISTER_INVITATION_SP_ENTRY, "https://ti.qq.com/growreg/index.html?_bid=3381&_wv=2&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=0085f5&_nav_anim=true&_wwv=128&adtag=add_contact");
        if (!TextUtils.isEmpty(B)) {
            str = B;
        }
        Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str);
        activity.startActivity(intent);
        ReportController.o(app, "dc00898", "", "", "0X80096F8", "0X80096F8", 0, 0, "", "", "", "");
    }

    @JvmStatic
    public static final void g(@NotNull Activity activity, @NotNull QQAppInterface app, @NotNull View itemView) {
        HashMap hashMapOf;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).enterMatchPage(activity, app, com.tencent.mobileqq.matchfriend.data.a.a().e(3));
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("search_people_entrance_id", Integer.valueOf(((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).getAddContactEntryDTID())));
        VideoReport.reportEvent("dt_clck", itemView, hashMapOf);
    }

    @JvmStatic
    public static final void h(@NotNull Activity activity, @NotNull QQAppInterface app) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(app, "app");
        Bundle bundle = new Bundle();
        bundle.putString("page_name", "nearbypro_main");
        bundle.putString(KuiklyLaunchParams.PARAM_CUSTOM_BACK_PRESSED, "1");
        ((IQQKuiklyRouter) QRoute.api(IQQKuiklyRouter.class)).launchKuiklyPage(activity, bundle);
        ReportController.r(app, "CliOper", "", "", "0X8004FA1", "0X8004FA1", 0, 0, "", "", "", "");
    }

    @JvmStatic
    public static final void i(@NotNull Activity activity, @NotNull QQAppInterface app) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(app, "app");
        Intent intent = new Intent();
        intent.putExtra("from", "AddContactsActivity");
        intent.setFlags(67108864);
        intent.putExtra("fromPicQRDecode", true);
        RouteUtils.startActivity(activity, intent, "/qrscan/scanner");
        ReportController.o(app, "dc00898", "", "", "0X800760C", "0X800760C", 0, 0, "", "", "", "");
    }

    @JvmStatic
    public static final void j(@NotNull Activity activity) {
        List<y45.b> emptyList;
        Intrinsics.checkNotNullParameter(activity, "activity");
        IFlockLauncher iFlockLauncher = (IFlockLauncher) QRoute.api(IFlockLauncher.class);
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        iFlockLauncher.launchSearchRecomFeedListPage(activity, emptyList, FlockConstants$FlockListScene.ACTIVITY);
    }

    @JvmStatic
    public static final void k(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Face2FaceAddContactFragment.Oh(activity, new Intent());
        com.tencent.mobileqq.activity.contact.addcontact.face2face.c.b("0X800AB5E", "", "", "");
    }
}
