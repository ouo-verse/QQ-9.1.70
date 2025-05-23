package com.tencent.mobileqq.minorsmode.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.minorsmode.MinorsModeKnowType;
import com.tencent.mobileqq.minorsmode.api.IMinorsModeApi;
import com.tencent.mobileqq.minorsmode.fragment.KidModeAdvanceSettingFragment;
import com.tencent.mobileqq.minorsmode.fragment.MinorsModeKnowFragment;
import com.tencent.mobileqq.minorsmode.fragment.StudyModeCloseFragment;
import com.tencent.mobileqq.minorsmode.fragment.StudyModeOpenFragment;
import com.tencent.mobileqq.minorsmode.fragment.StudyPwdVerifyFragment;
import com.tencent.mobileqq.studymode.KidModeServlet;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchServer;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J'\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016\u00a2\u0006\u0002\u0010\u0011J \u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J'\u0010\u0016\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010H\u0016\u00a2\u0006\u0002\u0010\u0017J \u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J \u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J'\u0010\u001c\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010H\u0016\u00a2\u0006\u0002\u0010\u001d\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/minorsmode/api/impl/MinorsModeApiImpl;", "Lcom/tencent/mobileqq/minorsmode/api/IMinorsModeApi;", "()V", "bizNotify", "", "type", "Lcom/tencent/mobileqq/minorsmode/MinorsModeKnowType;", "isStudyPwdVerifyFragment", "", "fragment", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "startKidModeAdvanceSettingFragment", "context", "Landroid/content/Context;", "showCompletedBtn", "src", "", "(Landroid/content/Context;ZLjava/lang/Integer;)V", "startKidModeAdvanceSettingFragmentForResult", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "requestCode", "startMinorsModeKnowFragment", "(Landroid/content/Context;Lcom/tencent/mobileqq/minorsmode/MinorsModeKnowType;Ljava/lang/Integer;)V", "startStudyModeCloseFragmentForResult", "intent", "Landroid/content/Intent;", "startStudyModeOpenFragmentForResult", "startStudyPwdVerifyFragment", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/Integer;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MinorsModeApiImpl implements IMinorsModeApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f247116a;

        static {
            int[] iArr = new int[MinorsModeKnowType.values().length];
            try {
                iArr[MinorsModeKnowType.OPEN_BY_SYSTEM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MinorsModeKnowType.CLOSE_BY_SYSTEM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MinorsModeKnowType.CLOSE_BY_SYSTEM_TO_ELDER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MinorsModeKnowType.OPEN_BY_SYSTEM_FROM_ELDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MinorsModeKnowType.CHECK_CLOSE_BY_SYSTEM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f247116a = iArr;
        }
    }

    private final void bizNotify(MinorsModeKnowType type) {
        IRedTouchServer iRedTouchServer;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (peekAppRuntime instanceof QQAppInterface) && StudyModeManager.l() == 0) {
            KidModeServlet.m((QQAppInterface) peekAppRuntime);
        }
        int i3 = a.f247116a[type.ordinal()];
        if (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4 || i3 == 5) {
            StudyModeManager.C(StudyModeManager.t());
            AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime2 == null || (iRedTouchServer = (IRedTouchServer) peekAppRuntime2.getRuntimeService(IRedTouchServer.class, "")) == null) {
                return;
            }
            iRedTouchServer.sendRedpointReq(true, false, 7);
        }
    }

    @Override // com.tencent.mobileqq.minorsmode.api.IMinorsModeApi
    public boolean isStudyPwdVerifyFragment(QIphoneTitleBarFragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        return fragment instanceof StudyPwdVerifyFragment;
    }

    @Override // com.tencent.mobileqq.minorsmode.api.IMinorsModeApi
    public void startKidModeAdvanceSettingFragment(Context context, boolean showCompletedBtn, Integer src) {
        Unit unit;
        Intrinsics.checkNotNullParameter(context, "context");
        if (src != null) {
            KidModeAdvanceSettingFragment.Wh(context, showCompletedBtn, src.intValue());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            KidModeAdvanceSettingFragment.Vh(context, showCompletedBtn);
        }
    }

    @Override // com.tencent.mobileqq.minorsmode.api.IMinorsModeApi
    public void startKidModeAdvanceSettingFragmentForResult(Activity activity, boolean showCompletedBtn, int requestCode) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        KidModeAdvanceSettingFragment.Xh(activity, showCompletedBtn, requestCode);
    }

    @Override // com.tencent.mobileqq.minorsmode.api.IMinorsModeApi
    public void startMinorsModeKnowFragment(Context context, MinorsModeKnowType type, Integer requestCode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(type, "type");
        bizNotify(type);
        Intent intent = new Intent();
        intent.putExtra("KEY_MINORS_MODE_TYPE", type);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        } else if (requestCode != null) {
            requestCode.intValue();
            QPublicFragmentActivity.startForResult((Activity) context, intent, (Class<? extends QPublicBaseFragment>) MinorsModeKnowFragment.class, requestCode.intValue());
            return;
        }
        QPublicFragmentActivity.start(context, intent, MinorsModeKnowFragment.class);
    }

    @Override // com.tencent.mobileqq.minorsmode.api.IMinorsModeApi
    public void startStudyModeCloseFragmentForResult(Activity activity, Intent intent, int requestCode) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(intent, "intent");
        QPublicFragmentActivity.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) StudyModeCloseFragment.class, 4);
    }

    @Override // com.tencent.mobileqq.minorsmode.api.IMinorsModeApi
    public void startStudyModeOpenFragmentForResult(Activity activity, Intent intent, int requestCode) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(intent, "intent");
        QPublicFragmentActivity.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) StudyModeOpenFragment.class, 4);
    }

    @Override // com.tencent.mobileqq.minorsmode.api.IMinorsModeApi
    public void startStudyPwdVerifyFragment(Context context, Intent intent, Integer requestCode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if ((context instanceof Activity) && requestCode != null) {
            QPublicFragmentActivity.startForResult((Activity) context, intent, (Class<? extends QPublicBaseFragment>) StudyPwdVerifyFragment.class, requestCode.intValue());
        } else {
            QPublicFragmentActivity.start(context, intent, StudyPwdVerifyFragment.class);
        }
    }
}
