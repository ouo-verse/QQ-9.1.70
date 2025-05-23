package com.tencent.mobileqq.widget;

import android.app.Activity;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.IQCircleService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.DrawerUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ex;
import com.tencent.mobileqq.vas.theme.NightModeLogic;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 72\u00020\u00012\u00020\u0002:\u00018B+\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u00103\u001a\u000202\u0012\b\b\u0002\u00104\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0017\u00a2\u0006\u0004\b5\u00106J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\u0005J\u0006\u0010\u000f\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\u0005J\u0012\u0010\u0012\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0011H\u0016R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0018R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R(\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001b\u0010-\u001a\u00020(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/widget/NightModeSettingItem;", "Lcom/tencent/mobileqq/widget/b;", "Landroid/view/View$OnClickListener;", "", "percent", "", "B", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "status", BdhLogUtil.LogTag.Tag_Conn, "v", "r", "y", HippyTKDListViewAdapter.X, ReportConstant.COSTREPORT_PREFIX, "onPostThemeChanged", "Landroid/view/View;", NodeProps.ON_CLICK, "Landroid/app/Activity;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "Z", "isSettingV3", "Landroidx/lifecycle/MutableLiveData;", "D", "Landroidx/lifecycle/MutableLiveData;", "nightModeStatus", "Ljava/util/concurrent/atomic/AtomicBoolean;", "E", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInit", UserInfo.SEX_FEMALE, "t", "()Landroidx/lifecycle/MutableLiveData;", "setNightModeDownloadProgress", "(Landroidx/lifecycle/MutableLiveData;)V", "nightModeDownloadProgress", "Lcom/tencent/mobileqq/vas/theme/NightModeLogic;", "G", "Lkotlin/Lazy;", "u", "()Lcom/tencent/mobileqq/vas/theme/NightModeLogic;", "nightModeLogic", "Lcom/tencent/mobileqq/vas/theme/NightModeLogic$NightModeCallback;", "H", "Lcom/tencent/mobileqq/vas/theme/NightModeLogic$NightModeCallback;", "callback", "Landroidx/lifecycle/LifecycleOwner;", "owner", "layoutId", "<init>", "(Landroid/app/Activity;Landroidx/lifecycle/LifecycleOwner;IZ)V", "I", "a", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class NightModeSettingItem extends com.tencent.mobileqq.widget.b implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private final boolean isSettingV3;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Integer> nightModeStatus;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private AtomicBoolean isInit;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Integer> nightModeDownloadProgress;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy nightModeLogic;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final NightModeLogic.NightModeCallback callback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Activity activity;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/widget/NightModeSettingItem$b", "Lcom/tencent/mobileqq/vas/theme/NightModeLogic$NightModeCallback;", "Landroid/os/Bundle;", "result", "", "onRespError", "onRespComplete", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements NightModeLogic.NightModeCallback {
        b() {
        }

        @Override // com.tencent.mobileqq.vas.theme.NightModeLogic.NightModeCallback
        public void onRespComplete(@NotNull Bundle result) {
            Intrinsics.checkNotNullParameter(result, "result");
            int i3 = result.getInt("start_status");
            if (i3 == 1) {
                NightModeSettingItem.this.A();
                return;
            }
            if (i3 == 2) {
                NightModeSettingItem.this.A();
            } else if (i3 == 3) {
                NightModeSettingItem.this.t().setValue(Integer.valueOf(result.getInt("percent")));
            }
        }

        @Override // com.tencent.mobileqq.vas.theme.NightModeLogic.NightModeCallback
        public void onRespError(@NotNull Bundle result) {
            Intrinsics.checkNotNullParameter(result, "result");
            NightModeSettingItem.this.A();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/widget/NightModeSettingItem$c", "Li71/a;", "", "a", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c implements i71.a {
        c() {
        }

        @Override // i71.a
        public void a() {
            NightModeSettingItem.this.q();
        }
    }

    public /* synthetic */ NightModeSettingItem(Activity activity, LifecycleOwner lifecycleOwner, int i3, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, lifecycleOwner, (i16 & 4) != 0 ? R.layout.qq_setting_me_setting_item_v9 : i3, (i16 & 8) != 0 ? false : z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A() {
        int nightModeStatus = u().getNightModeStatus();
        Integer value = this.nightModeStatus.getValue();
        if (value == null || value.intValue() != nightModeStatus) {
            this.nightModeStatus.setValue(Integer.valueOf(nightModeStatus));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void B(int percent) {
        if (!(getIvIcon().getDrawable() instanceof Animatable)) {
            Drawable c16 = ex.c(R.drawable.ait);
            getIvIcon().setImageDrawable(c16);
            if (c16 instanceof Animatable) {
                ((Animatable) c16).start();
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(percent);
        sb5.append('%');
        getTvSetting().setText(sb5.toString());
        if (QLog.isDevelopLevel()) {
            QLog.d("NightModeSettingItem", 4, "NIGHTMODE_ACTION_DOWNLOADING: " + percent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(int status) {
        String e16;
        String str = null;
        if (status != 1) {
            if (status != 2) {
                e16 = null;
            } else {
                if (this.isSettingV3) {
                    DrawerUtils.l(getIvIcon(), R.drawable.qui_night_mode_light, false, 4, null);
                } else {
                    DrawerUtils.l(getIvIcon(), R.drawable.qui_night_mode, false, 4, null);
                }
                str = ex.e(R.string.fsj);
                e16 = ex.e(R.string.r2i);
            }
        } else {
            if (this.isSettingV3) {
                DrawerUtils.l(getIvIcon(), R.drawable.qui_day_mode_light, false, 4, null);
            } else {
                DrawerUtils.l(getIvIcon(), R.drawable.qui_day_mode, false, 4, null);
            }
            str = ex.e(R.string.f2042052_);
            e16 = ex.e(R.string.f213835r_);
        }
        if (str != null) {
            if (AppSetting.f99565y) {
                AccessibilityUtil.c(getRlRoot(), e16, Button.class.getName());
            }
            getTvSetting().setText(str);
            getRlRoot().setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(NightModeSettingItem this$0, Integer integer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (integer != null && integer.intValue() == 0) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(integer, "integer");
        this$0.B(integer.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        String str;
        if (QQTheme.isNowThemeIsNight()) {
            str = "0";
        } else {
            str = "1";
        }
        ReportController.o(null, "dc00898", "", "", "0x800C0D3", "0x800C0D3", 0, 0, str, "", "", "");
        VideoReport.reportEvent("clck", getRlRoot(), null);
        u().startNightMode(this.activity);
        getRlRoot().setOnClickListener(null);
        getRlRoot().setClickable(false);
        ((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).setIsToCloseDrawer(0);
        ((IQCircleService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQCircleService.class, "all")).downloadSkinPackage("https://downv6.qq.com/video_story/qcircle/skin/debug/darkmode-v241225144809.skin");
    }

    private final void r() {
        VideoReport.reportEvent("imp", getRlRoot(), null);
    }

    private final NightModeLogic u() {
        return (NightModeLogic) this.nightModeLogic.getValue();
    }

    private final void v() {
        VideoReport.setElementId(getRlRoot(), "em_bas_time_state");
        VideoReport.setElementClickPolicy(getRlRoot(), ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(getRlRoot(), ExposurePolicy.REPORT_NONE);
        VideoReport.setEventDynamicParams(getRlRoot(), new IDynamicParams() { // from class: com.tencent.mobileqq.widget.z
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map w3;
                w3 = NightModeSettingItem.w(NightModeSettingItem.this, str);
                return w3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map w(NightModeSettingItem this$0, String str) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HashMap hashMap = new HashMap();
        Integer value = this$0.nightModeStatus.getValue();
        int i3 = 1;
        if (value != null && value.intValue() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i3 = 2;
        }
        hashMap.put("time_state", Integer.valueOf(i3));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(NightModeSettingItem this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.r();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (!((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).userSetThemeAction(this.activity, new c())) {
            q();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    public final void onPostThemeChanged() {
        u().onPostThemeChanged();
    }

    public final void s() {
        u().registerModeCallbacks(this.callback, false);
        u().onAccountChanged(MobileQQ.sMobileQQ.peekAppRuntime());
        u().registerModeCallbacks(this.callback, true);
    }

    @NotNull
    public final MutableLiveData<Integer> t() {
        return this.nightModeDownloadProgress;
    }

    public final void x() {
        u().registerModeCallbacks(this.callback, false);
        u().destroy();
    }

    public final void y() {
        if (this.isInit.compareAndSet(false, true)) {
            u().registerModeCallbacks(this.callback, true);
        }
        A();
        getRlRoot().post(new Runnable() { // from class: com.tencent.mobileqq.widget.y
            @Override // java.lang.Runnable
            public final void run() {
                NightModeSettingItem.z(NightModeSettingItem.this);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NightModeSettingItem(@NotNull Activity activity, @NotNull LifecycleOwner owner, int i3, boolean z16) {
        super(activity, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.activity = activity;
        this.isSettingV3 = z16;
        this.nightModeStatus = new MutableLiveData<>();
        this.isInit = new AtomicBoolean(false);
        this.nightModeDownloadProgress = new MutableLiveData<>();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<NightModeLogic>() { // from class: com.tencent.mobileqq.widget.NightModeSettingItem$nightModeLogic$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final NightModeLogic invoke() {
                return new NightModeLogic(MobileQQ.sMobileQQ.peekAppRuntime());
            }
        });
        this.nightModeLogic = lazy;
        C(2);
        MutableLiveData<Integer> mutableLiveData = this.nightModeStatus;
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.widget.NightModeSettingItem.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer status) {
                NightModeSettingItem nightModeSettingItem = NightModeSettingItem.this;
                Intrinsics.checkNotNullExpressionValue(status, "status");
                nightModeSettingItem.C(status.intValue());
            }
        };
        mutableLiveData.observe(owner, new Observer() { // from class: com.tencent.mobileqq.widget.w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NightModeSettingItem.l(Function1.this, obj);
            }
        });
        this.nightModeDownloadProgress.observe(owner, new Observer() { // from class: com.tencent.mobileqq.widget.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                NightModeSettingItem.m(NightModeSettingItem.this, (Integer) obj);
            }
        });
        v();
        this.callback = new b();
    }
}
