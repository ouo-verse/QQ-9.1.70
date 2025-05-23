package com.tencent.mobileqq.troop.troopsetting.bizconfig;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.troopsetting.modules.gameinfo.model.TroopGameInfoData;
import com.tencent.mobileqq.troop.troopsetting.modules.gameinfo.ui.TroopGameInfoFragment;
import com.tencent.mobileqq.troop.troopsetting.vm.TroopSettingViewModel;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001 B#\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/bizconfig/f;", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b;", "Lcom/tencent/mobileqq/widget/listitem/x$c;", "", "Z", "", "X", "c0", "d0", "Y", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "r", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "getAdapter", "()Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Lcom/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel;", "getViewModel", "()Lcom/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel;", "viewModel", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;Lcom/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel;)V", "t", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class f extends x<x.b, x.c> {
    static IPatchRedirector $redirector_;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Context context;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final QUIListItemAdapter adapter;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TroopSettingViewModel viewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/bizconfig/f$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsetting.bizconfig.f$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60078);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public f(@Nullable Context context, @Nullable QUIListItemAdapter qUIListItemAdapter, @NotNull TroopSettingViewModel viewModel) {
        super(new x.b.d((context == null || (r1 = context.getResources()) == null || (r1 = r1.getString(R.string.f23341777)) == null) ? "" : r1), new x.c.g("", false, false, 6, null));
        Resources resources;
        String string;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, qUIListItemAdapter, viewModel);
            return;
        }
        this.context = context;
        this.adapter = qUIListItemAdapter;
        this.viewModel = viewModel;
        Z();
    }

    private final boolean X() {
        boolean z16;
        if (this.viewModel.S2().groupExt.gangUpId > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        boolean studyModeSwitch = ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
        boolean isHomeworkTroop = this.viewModel.S2().isHomeworkTroop();
        QLog.i("GameInfoConfigItem", 2, "[gangUpSwitchEnable] studyMode:" + studyModeSwitch + ", homeworkTroop:" + isHomeworkTroop);
        if (!studyModeSwitch && !isHomeworkTroop) {
            return true;
        }
        return false;
    }

    private final void Z() {
        x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.bizconfig.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.a0(f.this, view);
            }
        });
        w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troop.troopsetting.bizconfig.e
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                f.b0(view);
            }
        });
        d0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(f this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.c0();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        com.tencent.mobileqq.troop.troopsetting.activity.c.a(it);
    }

    private final void c0() {
        TroopInfo S2 = this.viewModel.S2();
        Context context = this.context;
        if (S2.troopuin != null && context != null) {
            TroopGameInfoFragment.INSTANCE.a(context, TroopGameInfoData.INSTANCE.a(S2));
        }
    }

    public final void Y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else if (getIsVisible()) {
            c0();
        }
    }

    public final void d0() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        boolean X = X();
        boolean isTroopGameCardEnabledV2 = this.viewModel.S2().isTroopGameCardEnabledV2();
        if (!X && !isTroopGameCardEnabledV2) {
            z16 = false;
        } else {
            z16 = true;
        }
        QLog.i("GameInfoConfigItem", 2, "[refreshGameInfoDisplayItem] isGangUpEnable: " + X + ", isGameCardEnable: " + isTroopGameCardEnabledV2);
        QUIListItemAdapter qUIListItemAdapter = this.adapter;
        if (qUIListItemAdapter != null) {
            qUIListItemAdapter.m0(this, z16);
        }
    }
}
