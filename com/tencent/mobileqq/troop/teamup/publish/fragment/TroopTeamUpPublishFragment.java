package com.tencent.mobileqq.troop.teamup.publish.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.core.view.WindowCompat;
import com.google.gson.Gson;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.theme.a;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.HWMediaSelectPart;
import com.tencent.mobileqq.troop.teamup.publish.part.TroopTeamUpPublishEditPart;
import com.tencent.mobileqq.troop.teamup.publish.part.TroopTeamUpPublishMediaInputButtonsPart;
import com.tencent.mobileqq.troop.teamup.publish.part.TroopTeamUpPublishNavigationPart;
import com.tencent.mobileqq.troop.teamup.publish.part.TroopTeamUpPublishPublishingPart;
import com.tencent.mobileqq.troop.teamup.publish.part.TroopTeamUpPublishSettingPart;
import com.tencent.mobileqq.troop.teamup.publish.part.TroopTeamUpPublishUpdateUiPart;
import com.tencent.mobileqq.troop.teamup.publish.part.j;
import com.tencent.mobileqq.troop.teamup.publish.view.TroopTeamUpPublishLayout;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpTemplate;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0013\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/publish/fragment/TroopTeamUpPublishFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "initWindowStyleAndAnimation", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Lcom/tencent/mobileqq/troop/teamup/publish/view/TroopTeamUpPublishLayout;", "ph", "Landroid/content/Intent;", "intent", "onNewIntent", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopTeamUpPublishFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: C */
    @NotNull
    public static final Companion INSTANCE;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J0\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\bR\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/publish/fragment/TroopTeamUpPublishFragment$a;", "", "", "troopUin", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpTemplate;", "template", "Landroid/content/Context;", "context", "", "requestCode", "", "a", "ARG_TEMPLATE_JSON_STRING", "Ljava/lang/String;", "REQUEST_CODE_PUBLISH", "I", "RESULT_IS_PUBLISHED_BOOL", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.teamup.publish.fragment.TroopTeamUpPublishFragment$a */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        public static /* synthetic */ void b(Companion companion, String str, TeamUpTemplate teamUpTemplate, Context context, int i3, int i16, Object obj) {
            if ((i16 & 2) != 0) {
                teamUpTemplate = null;
            }
            if ((i16 & 4) != 0) {
                context = null;
            }
            if ((i16 & 8) != 0) {
                i3 = 1;
            }
            companion.a(str, teamUpTemplate, context, i3);
        }

        public final void a(@NotNull String troopUin, @Nullable TeamUpTemplate template, @Nullable Context context, int requestCode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, troopUin, template, context, Integer.valueOf(requestCode));
                return;
            }
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            Intent intent = new Intent();
            intent.putExtra("template_json_string", new Gson().toJson(template));
            intent.putExtra("troop_uin", troopUin);
            if (context == null) {
                context = BaseApplication.context;
            }
            QPublicFragmentActivity.b.f(context, intent, QPublicFragmentActivity.class, TroopTeamUpPublishFragment.class, requestCode);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56058);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopTeamUpPublishFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new TroopTeamUpPublishNavigationPart(), new TroopTeamUpPublishEditPart(), new TroopTeamUpPublishSettingPart(), new TroopTeamUpPublishUpdateUiPart(), new TroopTeamUpPublishPublishingPart(), new HWMediaSelectPart(HWMediaSelectPart.SourceType.TROOP_INVITE_TEAM), new TroopTeamUpPublishMediaInputButtonsPart(), new j());
            return mutableListOf;
        }
        return (List) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@Nullable Activity r46) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) r46);
            return;
        }
        super.initWindowStyleAndAnimation(r46);
        if (!(r46 instanceof QBaseActivity)) {
            return;
        }
        QBaseActivity qBaseActivity = (QBaseActivity) r46;
        SystemBarActivityModule.setImmersiveStatus(qBaseActivity, 0);
        a.d(qBaseActivity.getWindow());
        WindowCompat.setDecorFitsSystemWindows(qBaseActivity.getWindow(), false);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(@Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent);
            return;
        }
        PartManager partManager = this.mPartManager;
        if (partManager != null) {
            partManager.onNewIntent(intent);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    /* renamed from: ph */
    public TroopTeamUpPublishLayout onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup r85, @Nullable Bundle r95) {
        TroopTeamUpPublishLayout troopTeamUpPublishLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            troopTeamUpPublishLayout = (TroopTeamUpPublishLayout) iPatchRedirector.redirect((short) 4, this, inflater, r85, r95);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            Context context = inflater.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "inflater.context");
            troopTeamUpPublishLayout = new TroopTeamUpPublishLayout(context, null, 0, 6, null);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, troopTeamUpPublishLayout);
        return troopTeamUpPublishLayout;
    }
}
