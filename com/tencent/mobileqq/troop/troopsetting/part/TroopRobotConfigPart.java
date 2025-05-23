package com.tencent.mobileqq.troop.troopsetting.part;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.robot.api.IRobotUtilApi;
import com.tencent.mobileqq.troop.troopsetting.vm.TroopSettingViewModel;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.robot.api.IRobotDiscoveryApi;
import com.tencent.robot.troop.discovery.LaunchSourceType;
import com.tencent.robot.troop.discovery.TroopRobotDiscoveryLaunchArgs;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J(\u0010\n\u001a\u00020\u00022\u001e\u0010\t\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u0001`\bH\u0002J\u0006\u0010\u000b\u001a\u00020\u0002R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR'\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00108FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/part/TroopRobotConfigPart;", "", "", "j", "l", "k", "Ljava/util/ArrayList;", "Lbt2/d;", "Lkotlin/collections/ArrayList;", "robotInfoList", "e", "g", "Lcom/tencent/mobileqq/troop/troopsetting/part/h;", "a", "Lcom/tencent/mobileqq/troop/troopsetting/part/h;", "mDelegatePart", "Lcom/tencent/mobileqq/troop/troopsetting/customconfig/a;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "b", "Lkotlin/Lazy;", "f", "()Lcom/tencent/mobileqq/troop/troopsetting/customconfig/a;", DownloadInfo.spKey_Config, "", "c", "Z", "mBeRobotItemRedShowRed", "<init>", "(Lcom/tencent/mobileqq/troop/troopsetting/part/h;)V", "d", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopRobotConfigPart {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final h mDelegatePart;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy config;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean mBeRobotItemRedShowRed;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/part/TroopRobotConfigPart$a;", "", "", "MAX_ROBOT_COUNT_SHOWN", "I", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsetting.part.TroopRobotConfigPart$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60505);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopRobotConfigPart(@NotNull h mDelegatePart) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(mDelegatePart, "mDelegatePart");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mDelegatePart);
            return;
        }
        this.mDelegatePart = mDelegatePart;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.troop.troopsetting.customconfig.a<x.b.d, x.c.g>>() { // from class: com.tencent.mobileqq.troop.troopsetting.part.TroopRobotConfigPart$config$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopRobotConfigPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.troop.troopsetting.customconfig.a<x.b.d, x.c.g> invoke() {
                h hVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (com.tencent.mobileqq.troop.troopsetting.customconfig.a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                hVar = TroopRobotConfigPart.this.mDelegatePart;
                String string = hVar.getContext().getString(R.string.i8v);
                Intrinsics.checkNotNullExpressionValue(string, "mDelegatePart.context.ge\u2026api.R.string.troop_robot)");
                return new com.tencent.mobileqq.troop.troopsetting.customconfig.a<>(new x.b.d(string), new x.c.g("", false, false, 6, null));
            }
        });
        this.config = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(ArrayList<bt2.d> robotInfoList) {
        boolean z16;
        String str;
        int coerceAtMost;
        h hVar = this.mDelegatePart;
        x.c.g O = f().O();
        boolean z17 = true;
        if (robotInfoList != null && !robotInfoList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            str = HardCodeUtil.qqStr(R.string.cjr);
            Intrinsics.checkNotNullExpressionValue(str, "qqStr(com.tencent.mobile\u2026op.api.R.string.no_robot)");
        } else {
            str = "";
        }
        O.h(str);
        hVar.D9(f());
        LinearLayout V = f().V();
        if (V != null) {
            V.removeAllViews();
        }
        if (robotInfoList != null && !robotInfoList.isEmpty()) {
            z17 = false;
        }
        if (z17) {
            return;
        }
        Context context = hVar.getContext();
        AppInterface z95 = hVar.z9();
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(3, robotInfoList.size());
        for (int i3 = 0; i3 < coerceAtMost; i3++) {
            bt2.d dVar = robotInfoList.get(i3);
            if (dVar != null) {
                String valueOf = String.valueOf(dVar.b());
                Drawable defaultFaceDrawable140_140 = BaseImageUtil.getDefaultFaceDrawable140_140();
                FaceDrawable faceDrawableFrom = FaceDrawable.getFaceDrawableFrom(z95, 1, valueOf, 3, defaultFaceDrawable140_140, defaultFaceDrawable140_140, 4);
                ThemeImageView themeImageView = new ThemeImageView(context);
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.auq);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                layoutParams.leftMargin = context.getResources().getDimensionPixelSize(R.dimen.aur);
                if (dVar.c()) {
                    faceDrawableFrom.setAlpha(50);
                }
                themeImageView.setTag(dVar);
                themeImageView.setLayoutParams(layoutParams);
                themeImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                themeImageView.setBackground(faceDrawableFrom);
                LinearLayout V2 = f().V();
                if (V2 != null) {
                    V2.addView(themeImageView);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(TroopRobotConfigPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.k();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(AppInterface app, View it) {
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(it, "it");
        ReportController.o(app, "dc00898", "", "", "", "0X8009F9B", 0, 0, "", "", "", "");
    }

    private final void j() {
        LifecycleOwner lifecycleOwner = this.mDelegatePart.getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "mDelegatePart.partHost.hostLifecycleOwner");
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner);
        TroopSettingViewModel B9 = this.mDelegatePart.B9();
        BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new TroopRobotConfigPart$initObserver$1(B9, this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new TroopRobotConfigPart$initObserver$2(B9, this, null), 3, null);
    }

    private final void k() {
        h hVar = this.mDelegatePart;
        AppInterface z95 = hVar.z9();
        TroopSettingViewModel B9 = hVar.B9();
        if (this.mBeRobotItemRedShowRed) {
            ((IRobotUtilApi) QRoute.api(IRobotUtilApi.class)).setRobotItemRedShowed(z95, false);
            f().O().g(false);
            hVar.D9(f());
            if (QLog.isColorLevel()) {
                QLog.d("TroopManageGroupPart", 2, "setRobotItemRedDotShowed");
            }
        }
        ReportController.o(z95, "dc00898", "", "", "", "0X8009F9C", 0, 0, "", "", "", "");
        ((IRobotDiscoveryApi) QRoute.api(IRobotDiscoveryApi.class)).launchTroopRobotDiscoveryPage(new TroopRobotDiscoveryLaunchArgs(hVar.getActivity(), B9.T2().troopUin, LaunchSourceType.TROOP_SETTING));
    }

    private final void l() {
        f().p(((IRobotUtilApi) QRoute.api(IRobotUtilApi.class)).canInviteRobotInGroup(MobileQQ.sMobileQQ.peekAppRuntime(), this.mDelegatePart.B9().T2().troopUin));
    }

    @NotNull
    public final com.tencent.mobileqq.troop.troopsetting.customconfig.a<x.b.d, x.c.g> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.troop.troopsetting.customconfig.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return (com.tencent.mobileqq.troop.troopsetting.customconfig.a) this.config.getValue();
    }

    public final void g() {
        boolean robotItemRedShowed;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        h hVar = this.mDelegatePart;
        final AppInterface z95 = hVar.z9();
        com.tencent.mobileqq.troop.troopsetting.customconfig.a<x.b.d, x.c.g> f16 = f();
        Context context = hVar.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "part.context");
        f16.W(context);
        f16.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopRobotConfigPart.h(TroopRobotConfigPart.this, view);
            }
        });
        f16.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troop.troopsetting.part.b
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                TroopRobotConfigPart.i(AppInterface.this, view);
            }
        });
        if (!((IRobotUtilApi) QRoute.api(IRobotUtilApi.class)).getBeAllMemberShowRed(z95) && !hVar.B9().T2().isOwnerOrAdim()) {
            robotItemRedShowed = false;
        } else {
            robotItemRedShowed = ((IRobotUtilApi) QRoute.api(IRobotUtilApi.class)).getRobotItemRedShowed(z95);
        }
        this.mBeRobotItemRedShowRed = robotItemRedShowed;
        f().O().g(this.mBeRobotItemRedShowRed);
        l();
        j();
    }
}
