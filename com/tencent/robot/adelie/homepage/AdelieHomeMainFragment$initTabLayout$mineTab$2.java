package com.tencent.robot.adelie.homepage;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.robot.adelie.homepage.mine.AdelieHomeMineFragment;
import com.tencent.robot.adelie.homepage.mine.AdelieHomeMineKuiklyFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "fragment", "Landroidx/fragment/app/Fragment;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class AdelieHomeMainFragment$initTabLayout$mineTab$2 extends Lambda implements Function1<Fragment, Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ AdelieHomeMainFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdelieHomeMainFragment$initTabLayout$mineTab$2(AdelieHomeMainFragment adelieHomeMainFragment, Context context) {
        super(1);
        this.this$0 = adelieHomeMainFragment;
        this.$context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Fragment fragment, View view) {
        View view2;
        Intrinsics.checkNotNullParameter(view, "$view");
        if (fragment instanceof AdelieHomeMineFragment) {
            view2 = ((AdelieHomeMineFragment) fragment).getRootView();
        } else if (fragment instanceof AdelieHomeMineKuiklyFragment) {
            view2 = ((AdelieHomeMineKuiklyFragment) fragment).ph();
        } else {
            view2 = null;
        }
        if (view2 != null) {
            VideoReport.setPageId(view2, "pg_bas_creative_center");
            VideoReport.setLogicParent(view, view2);
            VideoReport.reportEvent("imp", view, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Fragment fragment, View view) {
        View view2;
        Intrinsics.checkNotNullParameter(view, "$view");
        if (fragment instanceof AdelieHomeMineFragment) {
            view2 = ((AdelieHomeMineFragment) fragment).getRootView();
        } else if (fragment instanceof AdelieHomeMineKuiklyFragment) {
            view2 = ((AdelieHomeMineKuiklyFragment) fragment).ph();
        } else {
            view2 = null;
        }
        if (view2 != null) {
            VideoReport.setPageId(view2, "pg_bas_creative_center");
            VideoReport.setLogicParent(view, view2);
            VideoReport.reportEvent("imp", view, null);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Fragment fragment) {
        invoke2(fragment);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable final Fragment fragment) {
        com.tencent.biz.qui.quisecnavbar.a aVar;
        com.tencent.biz.qui.quisecnavbar.a aVar2;
        com.tencent.biz.qui.quisecnavbar.a aVar3;
        TextView textView;
        TextView textView2;
        final View h16;
        final View h17;
        QUISecNavBar qUISecNavBar;
        this.this$0.isMore = false;
        AdelieHomeMainFragment.ci(this.this$0, false, 1, null);
        QUISecNavBar qUISecNavBar2 = this.this$0.quiSecNavBar;
        if (qUISecNavBar2 != null) {
            qUISecNavBar2.setRightIconLayoutVisible(true);
        }
        aVar = this.this$0.searchIcon;
        if (aVar != null && (qUISecNavBar = this.this$0.quiSecNavBar) != null) {
            qUISecNavBar.setRightIconVisible(aVar, false);
        }
        aVar2 = this.this$0.theMoreOrSettingIcon;
        if (aVar2 != null) {
            AdelieHomeMainFragment adelieHomeMainFragment = this.this$0;
            QUISecNavBar qUISecNavBar3 = adelieHomeMainFragment.quiSecNavBar;
            if (qUISecNavBar3 != null) {
                qUISecNavBar3.setRightIconRes(aVar2, R.drawable.qui_setting_icon_white);
            }
            QUISecNavBar qUISecNavBar4 = adelieHomeMainFragment.quiSecNavBar;
            if (qUISecNavBar4 != null && (h17 = qUISecNavBar4.h(aVar2)) != null) {
                h17.postDelayed(new Runnable() { // from class: com.tencent.robot.adelie.homepage.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        AdelieHomeMainFragment$initTabLayout$mineTab$2.c(Fragment.this, h17);
                    }
                }, 500L);
            }
        }
        aVar3 = this.this$0.robotIcon;
        if (aVar3 != null) {
            AdelieHomeMainFragment adelieHomeMainFragment2 = this.this$0;
            QUISecNavBar qUISecNavBar5 = adelieHomeMainFragment2.quiSecNavBar;
            if (qUISecNavBar5 != null) {
                qUISecNavBar5.setRightIconVisible(aVar3, true);
            }
            QUISecNavBar qUISecNavBar6 = adelieHomeMainFragment2.quiSecNavBar;
            if (qUISecNavBar6 != null && (h16 = qUISecNavBar6.h(aVar3)) != null) {
                h16.postDelayed(new Runnable() { // from class: com.tencent.robot.adelie.homepage.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        AdelieHomeMainFragment$initTabLayout$mineTab$2.d(Fragment.this, h16);
                    }
                }, 500L);
            }
        }
        textView = this.this$0.titleView;
        if (textView != null) {
            textView.setText(this.$context.getString(R.string.f159021r7));
        }
        textView2 = this.this$0.subTitleView;
        if (textView2 == null) {
            return;
        }
        textView2.setVisibility(8);
    }
}
