package com.tencent.mobileqq.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.api.IDrawerApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.DrawerUtils;
import com.tencent.mobileqq.utils.ex;
import com.tencent.mobileqq.viewmodel.QQSettingMeViewModel;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010!\u001a\u00020 \u0012\b\b\u0002\u0010\"\u001a\u00020\t\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/widget/NormalSettingItem;", "Lcom/tencent/mobileqq/widget/b;", "Lcom/tencent/mobileqq/activity/qqsettingme/bean/m;", "bean", "", HippyTKDListViewAdapter.X, "w", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "", "res", "v", ReportConstant.COSTREPORT_PREFIX, "Landroid/view/View$OnClickListener;", "listener", "u", "Landroid/view/View;", "Landroid/view/MotionEvent;", "event", "c", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "settingTxRedTouch", "Lcom/tencent/mobileqq/tianshu/ui/TianshuRedTouch;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/tianshu/ui/TianshuRedTouch;", "redBadge", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/viewmodel/QQSettingMeViewModel;", "viewModel", "Landroidx/lifecycle/LifecycleOwner;", "owner", "layoutId", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/viewmodel/QQSettingMeViewModel;Landroidx/lifecycle/LifecycleOwner;I)V", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class NormalSettingItem extends b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final TianshuRedTouch redBadge;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RedTouch settingTxRedTouch;

    public /* synthetic */ NormalSettingItem(Context context, QQSettingMeViewModel qQSettingMeViewModel, LifecycleOwner lifecycleOwner, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, qQSettingMeViewModel, lifecycleOwner, (i16 & 8) != 0 ? R.layout.qq_setting_me_setting_item_v9 : i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void o() {
        getRlRoot().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.widget.ac
            @Override // java.lang.Runnable
            public final void run() {
                NormalSettingItem.p(NormalSettingItem.this);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(NormalSettingItem this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VideoReport.reportEvent("imp", this$0.getRlRoot(), null);
    }

    private final void q() {
        VideoReport.setElementId(getRlRoot(), "em_bas_settings");
        VideoReport.setElementClickPolicy(getRlRoot(), ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(getRlRoot(), ExposurePolicy.REPORT_NONE);
        VideoReport.setEventDynamicParams(getRlRoot(), new IDynamicParams() { // from class: com.tencent.mobileqq.widget.ad
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map r16;
                r16 = NormalSettingItem.r(NormalSettingItem.this, str);
                return r16;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public static final Map r(NormalSettingItem this$0, String str) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HashMap hashMap = new HashMap();
        boolean b16 = this$0.getTvRedDot().b();
        TianshuRedTouch.Companion companion = TianshuRedTouch.INSTANCE;
        ?? r06 = b16;
        if (companion.j()) {
            if (!b16 && !companion.c(this$0.redBadge)) {
                z16 = false;
            } else {
                z16 = true;
            }
            r06 = z16;
        }
        hashMap.put("is_red_tips_em", Integer.valueOf((int) r06));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(NormalSettingItem this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(com.tencent.mobileqq.activity.qqsettingme.bean.m bean) {
        if (TianshuRedTouch.INSTANCE.j()) {
            BusinessInfoCheckUpdate.AppInfo appInfo = bean.f184924a;
            if (appInfo != null) {
                this.redBadge.n0(appInfo.path.get());
                return;
            }
            return;
        }
        if (bean.f184925b) {
            this.redBadge.n0(bean.f184924a.path.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(com.tencent.mobileqq.activity.qqsettingme.bean.m bean) {
        boolean z16 = bean.f184925b;
        getTvRedDot().c(bean.f184925b);
        if (!z16 && (bean.f184926c || bean.f184927d)) {
            getTvRedDot().c(true);
            z16 = true;
        }
        if (!z16) {
            this.settingTxRedTouch.parseRedTouchOnlyRedPoint(bean.f184924a);
        }
        String e16 = ex.e(R.string.r2z);
        if (z16) {
            e16 = e16 + "\u6709\u7ea2\u70b9";
        }
        AccessibilityUtil.c(getRlRoot(), e16, Button.class.getName());
    }

    @Override // com.tencent.mobileqq.widget.b
    public void c(@NotNull View v3, @NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(event, "event");
        super.c(v3, event);
        if (event.getAction() == 1 && ((IDrawerApi) QRoute.api(IDrawerApi.class)).currentIsV3()) {
            VideoReport.reportEvent("clck", getRlRoot(), null);
        }
        this.redBadge.x();
    }

    public final void s() {
        getRlRoot().post(new Runnable() { // from class: com.tencent.mobileqq.widget.ab
            @Override // java.lang.Runnable
            public final void run() {
                NormalSettingItem.t(NormalSettingItem.this);
            }
        });
    }

    public final void u(@NotNull View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        getRlRoot().setOnClickListener(listener);
    }

    public final void v(int res) {
        DrawerUtils.l(getIvIcon(), res, false, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NormalSettingItem(@NotNull Context context, @NotNull QQSettingMeViewModel viewModel, @NotNull LifecycleOwner owner, int i3) {
        super(context, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(owner, "owner");
        DrawerUtils.l(getIvIcon(), R.drawable.qui_setting, false, 4, null);
        String e16 = ex.e(R.string.r2z);
        AccessibilityUtil.c(getRlRoot(), e16, Button.class.getName());
        getTvSetting().setText(e16);
        RedTouch redTouch = new RedTouch(context, getTvRedDot());
        this.settingTxRedTouch = redTouch;
        TianshuRedTouch tianshuRedTouch = new TianshuRedTouch(context, getTvRedDot());
        this.redBadge = tianshuRedTouch;
        if (TianshuRedTouch.INSTANCE.j()) {
            tianshuRedTouch.t();
        } else {
            redTouch.applyTo();
        }
        MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.m> mutableLiveData = viewModel.U;
        final Function1<com.tencent.mobileqq.activity.qqsettingme.bean.m, Unit> function1 = new Function1<com.tencent.mobileqq.activity.qqsettingme.bean.m, Unit>() { // from class: com.tencent.mobileqq.widget.NormalSettingItem.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.activity.qqsettingme.bean.m mVar) {
                invoke2(mVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.activity.qqsettingme.bean.m it) {
                if (TianshuRedTouch.INSTANCE.j()) {
                    NormalSettingItem normalSettingItem = NormalSettingItem.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    normalSettingItem.w(it);
                } else {
                    NormalSettingItem normalSettingItem2 = NormalSettingItem.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    normalSettingItem2.x(it);
                }
            }
        };
        mutableLiveData.observe(owner, new Observer() { // from class: com.tencent.mobileqq.widget.aa
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NormalSettingItem.l(Function1.this, obj);
            }
        });
        q();
    }
}
