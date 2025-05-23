package com.tencent.mobileqq.troop.troopsetting.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopsetting.event.a;
import com.tencent.mobileqq.troop.troopsetting.modules.memberface.TroopMemberFaceUpdateSource;
import com.tencent.mobileqq.troop.troopsetting.vm.TroopSettingViewModel;
import com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.eu;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\"\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J6\u0010\u0018\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u001a\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/part/f;", "Lcom/tencent/mobileqq/troop/troopsetting/part/h;", "", QzoneIPCModule.RESULT_CODE, "", "M9", "Landroid/content/Intent;", "data", "Q9", "L9", "O9", "N9", "P9", "S9", "requestCode", "onActivityResult", "Lmqq/app/AppRuntime;", "appInterface", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "administrators", "K9", "<init>", "()V", "e", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class f extends h {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/part/f$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsetting.part.f$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60508);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void L9() {
        Object businessHandler = z9().getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopLuckyCharacterHandlerName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.troop.luckycharacter.api.ITroopLuckyCharacterHandler");
        com.tencent.mobileqq.troop.luckycharacter.api.a aVar = (com.tencent.mobileqq.troop.luckycharacter.api.a) businessHandler;
        TroopInfoData T2 = B9().T2();
        String str = T2.troopUin;
        if (str != null && !TextUtils.isEmpty(str)) {
            aVar.r0(T2.troopUin);
        }
    }

    private final void M9(int resultCode) {
        if (resultCode != -1) {
            return;
        }
        Intent m3 = BaseAIOUtils.m(new Intent(), null);
        Intrinsics.checkNotNullExpressionValue(m3, "setOpenAIOIntent(intent, null)");
        m3.putExtra("uin", B9().T2().troopUin);
        m3.putExtra("uinname", B9().S2().getTroopDisplayName());
        m3.putExtra("uintype", 1);
        QRoute.createNavigator(getActivity(), RouterConstants.UI_ROUTER_SPLASH).withAll(m3.getExtras()).withFlags(m3.getFlags()).request();
        getActivity().setResult(-1);
        com.tencent.mobileqq.troop.troopsetting.activity.a aVar = com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a;
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        aVar.h(activity);
    }

    private final void N9(int resultCode, Intent data) {
        if (resultCode == -1) {
            if (data != null && data.getExtras() != null) {
                Bundle extras = data.getExtras();
                Intrinsics.checkNotNull(extras);
                if (extras.getBoolean(AppConstants.Key.IS_NEED_FINISH)) {
                    Intent intent = new Intent();
                    intent.putExtra(AppConstants.Key.IS_NEED_FINISH, true);
                    getActivity().setResult(-1, intent);
                }
            }
            com.tencent.mobileqq.troop.troopsetting.activity.a aVar = com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a;
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            aVar.h(activity);
        }
    }

    private final void O9(int resultCode, Intent data) {
        QBaseActivity qBaseActivity;
        if (resultCode == -1 && data != null) {
            int i3 = 0;
            if (!NetworkUtil.isNetworkAvailable(getActivity())) {
                QQToast makeText = QQToast.makeText(getActivity(), 1, R.string.ci5, 0);
                Activity activity = getActivity();
                if (activity instanceof QBaseActivity) {
                    qBaseActivity = (QBaseActivity) activity;
                } else {
                    qBaseActivity = null;
                }
                if (qBaseActivity != null) {
                    i3 = qBaseActivity.getTitleBarHeight();
                }
                makeText.show(i3);
                return;
            }
            String stringExtra = data.getStringExtra("result");
            TroopInfo S2 = B9().S2();
            B9().T2();
            if (TextUtils.isEmpty(stringExtra)) {
                QQToast.makeText(getActivity(), 1, R.string.f235057am, 0).show();
                return;
            }
            if (stringExtra == null || stringExtra.length() == 0) {
                i3 = 1;
            }
            if (i3 == 0 && S2.getTroopUin() != null && !Intrinsics.areEqual(stringExtra, S2.troopname)) {
                ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).modifyGroupName(S2.troopuin, stringExtra, null, "TroopSettingActivityResultPart", null);
                if (S2.isNewTroop && S2.hasSetTroopHead()) {
                    B9().P3(true);
                }
                B9().d4(stringExtra);
                B9().m4();
            }
        }
    }

    private final void P9(int resultCode, Intent data) {
        String str;
        String[] strArr = new String[3];
        strArr[0] = B9().T2().troopUin;
        strArr[1] = eu.c(B9().T2());
        if (resultCode == -1) {
            str = "0";
        } else {
            str = "1";
        }
        strArr[2] = str;
        eu.g("Grp_share", "grpData_admin", "share_qq", 0, 0, strArr);
        if (resultCode != -1) {
            return;
        }
        ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).handleARKAppShareAction(z9(), getActivity(), data);
    }

    private final void Q9(int resultCode, Intent data) {
        if (resultCode == -1 && data != null) {
            boolean booleanExtra = data.getBooleanExtra(((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).getQzoneHelperQunPhotoDataHasChange(), true);
            if (QLog.isColorLevel()) {
                QLog.i("TroopSettingActivityResultPart", 2, "resultForRequestQzonePhoto|needRereshed = " + booleanExtra);
            }
            if (booleanExtra) {
                TroopSettingViewModel.y3(B9(), null, 1, null);
            }
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.part.d
            @Override // java.lang.Runnable
            public final void run() {
                f.R9(f.this);
            }
        }, 8, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(f this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            TroopInfoData T2 = this$0.B9().T2();
            T2.nUnreadMsgNum = ((ITroopSPUtilApi) QRoute.api(ITroopSPUtilApi.class)).groupGroupNewsInfo(this$0.z9().getCurrentAccountUin(), ITroopSPUtilApi.KEY_ALBUM_MESSAGE, T2.troopUin);
            if (QLog.isColorLevel()) {
                QLog.i("TroopSettingActivityResultPart", 2, "\u4ece\u7fa4\u7a7a\u95f4\u8fd4\u56de\uff0c\u66f4\u65b0\u7fa4\u7a7a\u95f4\u672a\u8bfb\u8ba1\u6570\uff0c troopuin = " + T2.troopUin + ", unreadmsgnum = " + T2.nUnreadMsgNum + ", newphotonum = " + T2.nNewPhotoNum);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopSettingActivityResultPart", 2, e16.toString());
            }
        }
    }

    private final void S9(final Intent data) {
        B9().u3();
        B9().b4(a.f.f301118a);
        if (data != null && data.getExtras() != null) {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.part.c
                @Override // java.lang.Runnable
                public final void run() {
                    f.T9(data, this);
                }
            }, 8, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(final Intent intent, final f this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            Bundle extras = intent.getExtras();
            Intrinsics.checkNotNull(extras);
            this$0.K9(this$0.z9(), this$0.B9().S2(), extras.getStringArrayList("param_admins"));
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("TroopSettingActivityResultPart", 2, e16, new Object[0]);
            }
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.part.e
            @Override // java.lang.Runnable
            public final void run() {
                f.U9(intent, this$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(Intent intent, f this$0) {
        ArrayList<String> arrayList;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Bundle extras = intent.getExtras();
        if (extras != null) {
            arrayList = extras.getStringArrayList("deleted_members");
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            this$0.B9().b4(a.h.f301120a);
            for (String str : arrayList) {
                CopyOnWriteArrayList<String> L2 = this$0.B9().L2();
                if (L2 != null) {
                    L2.remove(str);
                }
            }
        }
        this$0.B9().b4(new a.o(TroopMemberFaceUpdateSource.RESULT_CODE_TROOP_MANAGE));
    }

    public final void K9(@Nullable AppRuntime appInterface, @Nullable TroopInfo troopInfo, @Nullable ArrayList<String> administrators) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appInterface, troopInfo, administrators);
            return;
        }
        if (administrators != null && appInterface != null && troopInfo != null) {
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<String> it = administrators.iterator();
            while (it.hasNext()) {
                stringBuffer.append(it.next() + "|");
            }
            com.tencent.qqnt.inner.compator.troopinfo.d dVar = new com.tencent.qqnt.inner.compator.troopinfo.d();
            dVar.b(troopInfo);
            troopInfo.Administrator = stringBuffer.toString();
            dVar.a(troopInfo).c();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
        QLog.i("TroopSettingActivityResultPart", 2, "onActivityResult, requestCode = " + requestCode + ", resultCode = " + resultCode + ", data = " + data);
        if (requestCode != 1) {
            if (requestCode != 3) {
                if (requestCode != 16) {
                    if (requestCode != 19) {
                        if (requestCode != 145) {
                            if (requestCode != 5) {
                                if (requestCode != 6) {
                                    if (requestCode != 7) {
                                        if (requestCode != 8) {
                                            switch (requestCode) {
                                                case 10:
                                                    if (resultCode == -1 && data != null && data.getBooleanExtra("has_operation", false)) {
                                                        B9().L3(data);
                                                        return;
                                                    }
                                                    return;
                                                case 11:
                                                    ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).fetchTroopTags(B9().T2().troopUin, i.a(this), null);
                                                    return;
                                                case 12:
                                                    B9().j3(resultCode, data);
                                                    return;
                                                case 13:
                                                    N9(resultCode, data);
                                                    return;
                                                default:
                                                    return;
                                            }
                                        }
                                        S9(data);
                                        return;
                                    }
                                    Q9(resultCode, data);
                                    return;
                                }
                                M9(resultCode);
                                return;
                            }
                            if (resultCode == -1) {
                                getActivity().setResult(-1);
                                return;
                            }
                            return;
                        }
                        String[] strArr = new String[3];
                        strArr[0] = B9().T2().troopUin;
                        strArr[1] = eu.c(B9().T2());
                        if (resultCode == -1) {
                            str = "0";
                        } else {
                            str = "1";
                        }
                        strArr[2] = str;
                        eu.g("Grp_share", "grpData_admin", "share_qzone", 0, 0, strArr);
                        return;
                    }
                    L9();
                    return;
                }
                O9(resultCode, data);
                return;
            }
            P9(resultCode, data);
            return;
        }
        if (resultCode == -1 && data != null && data.getBooleanExtra("select_member_add_request_ok", false)) {
            B9().J3(true);
            boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qq_relation_troop_invite_refresh", false);
            QLog.i("TroopSettingActivityResultPart", 1, "[onActivityResult] switchOn:" + isSwitchOn);
            if (isSwitchOn) {
                B9().C3();
            }
        }
    }
}
