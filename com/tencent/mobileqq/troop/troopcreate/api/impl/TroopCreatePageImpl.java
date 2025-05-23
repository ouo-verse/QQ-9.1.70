package com.tencent.mobileqq.troop.troopcreate.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.parser.av;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.api.ITroopCreateInfoService;
import com.tencent.mobileqq.troop.data.TroopCreateInfo;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreatePage;
import com.tencent.mobileqq.troop.troopcreate.classify.TroopCreateClassifyDetailFragment;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcreate/api/impl/TroopCreatePageImpl;", "Lcom/tencent/mobileqq/troop/troopcreate/api/ITroopCreatePage;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "categoryId", "", "openNewCategoryPage", "launchCreatePage", "fromGuildId", "Lcom/tencent/mobileqq/troop/troopcreate/api/ITroopCreatePage$a;", "callback", "launchCreatePageFromGuild", "openCreateTroopByCategoryPage", "openCreateTroopByCategoryPageFromSetting", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/parser/av;", "getTroopCreateJumpParser", "", "isNewCreateTroopExperiment", "getExperimentResultAndReport", "<init>", "()V", "Companion", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopCreatePageImpl implements ITroopCreatePage {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String EXP_GRP_CREATE_PROCESS = "exp_grp_create_process_v2";

    @NotNull
    private static final String EXP_GRP_CREATE_PROCESS_B = "exp_grp_create_process_v2_B";

    @NotNull
    private static final String TAG = "TroopCreatePageImpl";

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcreate/api/impl/TroopCreatePageImpl$a;", "", "", "EXP_GRP_CREATE_PROCESS", "Ljava/lang/String;", "EXP_GRP_CREATE_PROCESS_B", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopcreate.api.impl.TroopCreatePageImpl$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57468);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopCreatePageImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void launchCreatePageFromGuild$lambda$0(ITroopCreatePage.a aVar, String troopUin, boolean z16) {
        if (aVar != null) {
            Intrinsics.checkNotNullExpressionValue(troopUin, "troopUin");
            aVar.a(troopUin, z16);
        }
    }

    private final void openNewCategoryPage(Activity activity, String categoryId) {
        activity.overridePendingTransition(R.anim.f154454a3, R.anim.f154458a7);
        Intent intent = new Intent();
        if (!TextUtils.isEmpty(categoryId)) {
            intent.putExtra("fromSetting", true);
            intent.putExtra("categoryId", categoryId);
        }
        QPublicFragmentActivity.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) TroopCreateClassifyDetailFragment.class, 11);
    }

    @Override // com.tencent.mobileqq.troop.troopcreate.api.ITroopCreatePage
    public boolean getExperimentResultAndReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(EXP_GRP_CREATE_PROCESS);
        Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance().getExpEntity(EXP_GRP_CREATE_PROCESS)");
        expEntity.reportExpExposure();
        return expEntity.isExperiment(EXP_GRP_CREATE_PROCESS_B);
    }

    @Override // com.tencent.mobileqq.troop.troopcreate.api.ITroopCreatePage
    @NotNull
    public Class<? extends av> getTroopCreateJumpParser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Class) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return com.tencent.mobileqq.troop.troopcreate.jump.b.class;
    }

    @Override // com.tencent.mobileqq.troop.troopcreate.api.ITroopCreatePage
    public boolean isNewCreateTroopExperiment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(EXP_GRP_CREATE_PROCESS);
        Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance().getExpEntity(EXP_GRP_CREATE_PROCESS)");
        return expEntity.isExperiment(EXP_GRP_CREATE_PROCESS_B);
    }

    @Override // com.tencent.mobileqq.troop.troopcreate.api.ITroopCreatePage
    public void launchCreatePage(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ITroopCreateInfoService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026va, ProcessConstant.MAIN)");
        QLog.i(TAG, 1, "launchCreatePage, createScene=default");
        ((ITroopCreateInfoService) runtimeService).getTroopCreateInfo().setCreateScene("");
        com.tencent.mobileqq.troop.createNewTroop.g.c(activity, null);
    }

    @Override // com.tencent.mobileqq.troop.troopcreate.api.ITroopCreatePage
    public void launchCreatePageFromGuild(@NotNull Activity activity, @Nullable String fromGuildId, @Nullable final ITroopCreatePage.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, activity, fromGuildId, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ITroopCreateInfoService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026ssConstant.MAIN\n        )");
        QLog.i(TAG, 1, "launchCreatePage, createScene=guild, fromGuildId=" + fromGuildId);
        ((ITroopCreateInfoService) runtimeService).getTroopCreateInfo().setCreateScene("guild", fromGuildId, new TroopCreateInfo.b() { // from class: com.tencent.mobileqq.troop.troopcreate.api.impl.a
            @Override // com.tencent.mobileqq.troop.data.TroopCreateInfo.b
            public final void a(String str, boolean z16) {
                TroopCreatePageImpl.launchCreatePageFromGuild$lambda$0(ITroopCreatePage.a.this, str, z16);
            }
        });
        Bundle bundle = new Bundle();
        bundle.putString("createScene", "guild");
        bundle.putString("sceneTargetId", fromGuildId);
        com.tencent.mobileqq.troop.createNewTroop.g.c(activity, bundle);
    }

    @Override // com.tencent.mobileqq.troop.troopcreate.api.ITroopCreatePage
    public void openCreateTroopByCategoryPage(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        QLog.i(TAG, 1, "[openCreateTroopByCategoryPage] start");
        openNewCategoryPage(activity, "");
    }

    @Override // com.tencent.mobileqq.troop.troopcreate.api.ITroopCreatePage
    public void openCreateTroopByCategoryPageFromSetting(@NotNull Activity activity, @NotNull String categoryId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity, (Object) categoryId);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        openNewCategoryPage(activity, categoryId);
    }
}
