package com.tencent.mobileqq.widget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ex;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mobileqq.viewmodel.QQSettingMeViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsJVMKt;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 F2\u00020\u0001:\u0001\u001bB)\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010A\u001a\u00020@\u0012\u0006\u0010C\u001a\u00020B\u0012\b\b\u0002\u0010\"\u001a\u00020\u0006\u00a2\u0006\u0004\bD\u0010EJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u0010\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J$\u0010\u0013\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\rH\u0002J \u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\rH\u0002J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0017\u0010\"\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010(\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\"\u0010/\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00105\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00102R\u0018\u00107\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00102R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/widget/WeatherSettingItem;", "", "", "p", "Lcom/tencent/mobileqq/activity/qqsettingme/bean/p;", "bean", "", "weatherAlarmCount", "v", HippyTKDListViewAdapter.X, "u", "", "permissionDenied", "", "curTemp", "isShowIcon", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "weaCode", NotificationCompat.CATEGORY_ALARM, ReportConstant.COSTREPORT_PREFIX, "iconUrl", "tempText", "areaText", DomainData.DOMAIN_NAME, "y", "w", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "b", "I", "getLayoutId", "()I", "layoutId", "Landroid/view/View;", "c", "Landroid/view/View;", "o", "()Landroid/view/View;", "root", "d", "Z", "r", "()Z", "t", "(Z)V", "isResume", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "temperature", "f", "temperatureNegative", "g", "weatherArea", "Lcom/tencent/image/URLImageView;", tl.h.F, "Lcom/tencent/image/URLImageView;", "weatherIcon", "Landroid/os/Handler;", "i", "Landroid/os/Handler;", "handler", "Lcom/tencent/mobileqq/viewmodel/QQSettingMeViewModel;", "viewModel", "Landroidx/lifecycle/LifecycleOwner;", "owner", "<init>", "(Landroid/app/Activity;Lcom/tencent/mobileqq/viewmodel/QQSettingMeViewModel;Landroidx/lifecycle/LifecycleOwner;I)V", "j", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ClickableViewAccessibility"})
/* loaded from: classes20.dex */
public final class WeatherSettingItem {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int layoutId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isResume;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView temperature;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView temperatureNegative;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView weatherArea;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private URLImageView weatherIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Handler handler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/widget/WeatherSettingItem$b", "Lcom/tencent/image/URLDrawableDownListener$Adapter;", "Landroid/view/View;", "view", "Lcom/tencent/image/URLDrawable;", "drawable", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "", "onLoadFailed", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b extends URLDrawableDownListener.Adapter {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f316571e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f316572f;

        b(String str, String str2) {
            this.f316571e = str;
            this.f316572f = str2;
        }

        @Override // com.tencent.image.URLDrawableDownListener.Adapter, com.tencent.image.URLDrawableDownListener
        public void onLoadFailed(@NotNull View view, @Nullable URLDrawable drawable, @Nullable Throwable cause) {
            Intrinsics.checkNotNullParameter(view, "view");
            TextView textView = WeatherSettingItem.this.temperature;
            if (textView != null) {
                textView.setText(this.f316571e);
            }
            TextView textView2 = WeatherSettingItem.this.weatherArea;
            if (textView2 != null) {
                textView2.setText(this.f316572f);
            }
            URLImageView uRLImageView = WeatherSettingItem.this.weatherIcon;
            if (uRLImageView != null) {
                uRLImageView.setVisibility(8);
            }
            TextView textView3 = WeatherSettingItem.this.temperature;
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
            QLog.e("WeatherSettingItem", 1, "weatherIcon onLoadFailed: ", cause);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/widget/WeatherSettingItem$c", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c extends Handler {
        c() {
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (msg2.what == 1) {
                Object obj = msg2.obj;
                if (obj instanceof com.tencent.mobileqq.activity.qqsettingme.bean.p) {
                    WeatherSettingItem weatherSettingItem = WeatherSettingItem.this;
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeWeatherBean");
                    weatherSettingItem.v((com.tencent.mobileqq.activity.qqsettingme.bean.p) obj, msg2.arg1);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/widget/WeatherSettingItem$d", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class d implements Animation.AnimationListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.activity.qqsettingme.bean.p f316575e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f316576f;

        d(com.tencent.mobileqq.activity.qqsettingme.bean.p pVar, int i3) {
            this.f316575e = pVar;
            this.f316576f = i3;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            WeatherSettingItem.this.getRoot().setVisibility(4);
            Message message = new Message();
            message.what = 1;
            message.obj = this.f316575e;
            message.arg1 = this.f316576f + 1;
            WeatherSettingItem.this.handler.sendMessage(message);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            WeatherSettingItem.this.getRoot().setVisibility(0);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/widget/WeatherSettingItem$e", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class e implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.activity.qqsettingme.bean.p f316577d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ WeatherSettingItem f316578e;

        e(com.tencent.mobileqq.activity.qqsettingme.bean.p pVar, WeatherSettingItem weatherSettingItem) {
            this.f316577d = pVar;
            this.f316578e = weatherSettingItem;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            Message message = new Message();
            message.what = 1;
            message.obj = this.f316577d;
            message.arg1 = 0;
            this.f316578e.handler.sendMessage(message);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    public WeatherSettingItem(@NotNull Activity activity, @NotNull QQSettingMeViewModel viewModel, @NotNull LifecycleOwner owner, int i3) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.activity = activity;
        this.layoutId = i3;
        View inflate = LayoutInflater.from(activity).inflate(i3, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(activity)\n        .inflate(layoutId, null)");
        this.root = inflate;
        this.handler = new c();
        this.temperature = (TextView) inflate.findViewById(R.id.uob);
        this.temperatureNegative = (TextView) inflate.findViewById(R.id.uod);
        this.weatherArea = (TextView) inflate.findViewById(R.id.uo9);
        URLImageView uRLImageView = (URLImageView) inflate.findViewById(R.id.uo_);
        this.weatherIcon = uRLImageView;
        if (uRLImageView != null) {
            uRLImageView.setColorFilter(ContextCompat.getColor(activity, R.color.qui_common_icon_primary));
        }
        TextView textView = this.weatherArea;
        if (textView != null) {
            textView.setTextColor(ex.b(R.color.qui_common_text_primary));
        }
        ColorStateList b16 = ex.b(R.color.qui_common_icon_primary);
        TextView textView2 = this.temperature;
        if (textView2 != null) {
            textView2.setTextColor(b16);
        }
        TextView textView3 = this.temperatureNegative;
        if (textView3 != null) {
            textView3.setTextColor(b16);
        }
        inflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.widget.bu
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean d16;
                d16 = WeatherSettingItem.d(view, motionEvent);
                return d16;
            }
        });
        MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.p> mutableLiveData = viewModel.S;
        final Function1<com.tencent.mobileqq.activity.qqsettingme.bean.p, Unit> function1 = new Function1<com.tencent.mobileqq.activity.qqsettingme.bean.p, Unit>() { // from class: com.tencent.mobileqq.widget.WeatherSettingItem.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.activity.qqsettingme.bean.p pVar) {
                invoke2(pVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.activity.qqsettingme.bean.p it) {
                if (WeatherSettingItem.this.getIsResume()) {
                    WeatherSettingItem weatherSettingItem = WeatherSettingItem.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    weatherSettingItem.y(it);
                } else {
                    WeatherSettingItem weatherSettingItem2 = WeatherSettingItem.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    weatherSettingItem2.w(it);
                }
            }
        };
        mutableLiveData.observe(owner, new Observer() { // from class: com.tencent.mobileqq.widget.bv
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WeatherSettingItem.e(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> mutableLiveData2 = viewModel.T;
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.widget.WeatherSettingItem.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                WeatherSettingItem.this.getRoot().setVisibility(8);
            }
        };
        mutableLiveData2.observe(owner, new Observer() { // from class: com.tencent.mobileqq.widget.bw
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WeatherSettingItem.f(Function1.this, obj);
            }
        });
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setAlpha(0.5f);
            view.invalidate();
            return false;
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            view.setAlpha(1.0f);
            view.invalidate();
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void n(String iconUrl, String tempText, String areaText) {
        URLImageView uRLImageView;
        b bVar = new b(tempText, areaText);
        try {
            URL url = new URL(iconUrl);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            ColorDrawable colorDrawable = new ColorDrawable(0);
            obtain.mLoadingDrawable = colorDrawable;
            obtain.mFailedDrawable = colorDrawable;
            obtain.mUseApngImage = true;
            URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
            if (drawable != null && drawable.getStatus() == 2) {
                drawable.restartDownload();
            }
            if (drawable != null && drawable.getStatus() == 1) {
                bVar.onLoadSuccessed(this.weatherIcon, drawable);
            } else {
                URLImageView uRLImageView2 = this.weatherIcon;
                if (uRLImageView2 != null) {
                    uRLImageView2.setURLDrawableDownListener(bVar);
                }
            }
            if (drawable != null && (uRLImageView = this.weatherIcon) != null) {
                uRLImageView.setImageDrawable(drawable);
            }
        } catch (MalformedURLException e16) {
            QLog.e("WeatherSettingItem", 1, "QQWeather showIcon: ", e16);
        }
    }

    private final void p() {
        VideoReport.setElementId(this.root, "em_drawer_weather");
        VideoReport.setElementClickPolicy(this.root, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(this.root, ExposurePolicy.REPORT_FIRST);
    }

    private final void q(boolean permissionDenied, String curTemp, boolean isShowIcon) {
        if (TextUtils.isEmpty(curTemp)) {
            return;
        }
        if (!permissionDenied && curTemp.charAt(0) == '-' && !isShowIcon) {
            String substring = curTemp.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            TextView textView = this.temperatureNegative;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = this.temperatureNegative;
            if (textView2 != null) {
                textView2.setText("-");
            }
            TextView textView3 = this.temperature;
            if (textView3 != null) {
                textView3.setText(substring);
                return;
            }
            return;
        }
        TextView textView4 = this.temperatureNegative;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00f9, code lost:
    
        if (r5 != null) goto L72;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void s(boolean permissionDenied, String weaCode, String alarm) {
        CharSequence charSequence;
        boolean z16;
        Integer intOrNull;
        Float floatOrNull;
        CharSequence text;
        String obj;
        if (!AppSetting.f99565y) {
            return;
        }
        TextView textView = this.weatherArea;
        if (textView != null) {
            ViewCompat.setImportantForAccessibility(textView, 2);
        }
        StringBuilder sb5 = new StringBuilder();
        if (permissionDenied) {
            sb5.append("\u5f53\u5730\u5929\u6c14 \u672a\u542f\u7528");
        } else if (weaCode != null) {
            TextView textView2 = this.weatherArea;
            if (textView2 != null) {
                charSequence = textView2.getText();
            } else {
                charSequence = null;
            }
            String str = "";
            if (charSequence == null) {
                charSequence = "";
            }
            sb5.append(charSequence);
            sb5.append(", ");
            switch (weaCode.hashCode()) {
                case 49587:
                    if (weaCode.equals(ThemeReporter.FROM_DIY)) {
                        sb5.append("\u6674");
                        break;
                    }
                    sb5.append("\u672a\u77e5");
                    break;
                case 49588:
                    if (weaCode.equals(ThemeReporter.FROM_NIGHT)) {
                        sb5.append("\u591a\u4e91");
                        break;
                    }
                    sb5.append("\u672a\u77e5");
                    break;
                case 49589:
                    if (weaCode.equals(ThemeReporter.FROM_WEEKLOOP)) {
                        sb5.append("\u9634");
                        break;
                    }
                    sb5.append("\u672a\u77e5");
                    break;
                case 49590:
                    if (weaCode.equals(ThemeReporter.FROM_AUTH)) {
                        sb5.append("\u96e8");
                        break;
                    }
                    sb5.append("\u672a\u77e5");
                    break;
                case 49591:
                    if (weaCode.equals(ThemeReporter.FROM_ENGINE)) {
                        sb5.append("\u96ea");
                        break;
                    }
                    sb5.append("\u672a\u77e5");
                    break;
                case 49592:
                    if (weaCode.equals(ThemeReporter.FROM_INIT_THEME)) {
                        sb5.append("\u96fe");
                        break;
                    }
                    sb5.append("\u672a\u77e5");
                    break;
                case 49593:
                    if (weaCode.equals(ThemeReporter.FROM_SERVER_SET_THEME)) {
                        sb5.append("\u6c99\u5c18");
                        break;
                    }
                    sb5.append("\u672a\u77e5");
                    break;
                case 49594:
                    if (weaCode.equals(ThemeReporter.FROM_UPDATE)) {
                        sb5.append("\u973e");
                        break;
                    }
                    sb5.append("\u672a\u77e5");
                    break;
                default:
                    sb5.append("\u672a\u77e5");
                    break;
            }
            TextView textView3 = this.temperature;
            if (textView3 != null && (text = textView3.getText()) != null && (obj = text.toString()) != null) {
                str = obj;
            }
            if (str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
                if (intOrNull == null) {
                    floatOrNull = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(str);
                }
                sb5.append("\uff0c\u6e29\u5ea6\uff1a" + str + " \u6444\u6c0f\u5ea6");
            }
            sb5.append(", " + alarm);
        }
        AccessibilityUtil.c(this.root, sb5, Button.class.getName());
    }

    private final void u(com.tencent.mobileqq.activity.qqsettingme.bean.p bean, int weatherAlarmCount) {
        AlphaAnimation a16 = com.tencent.mobileqq.activity.qqsettingme.utils.c.a(0.0f, 1.0f);
        AlphaAnimation a17 = com.tencent.mobileqq.activity.qqsettingme.utils.c.a(1.0f, 0.0f);
        a17.setStartOffset(2500L);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(a16);
        animationSet.addAnimation(a17);
        animationSet.setAnimationListener(new d(bean, weatherAlarmCount));
        this.root.startAnimation(animationSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(com.tencent.mobileqq.activity.qqsettingme.bean.p bean, int weatherAlarmCount) {
        URLImageView uRLImageView = this.weatherIcon;
        if (uRLImageView != null) {
            uRLImageView.clearColorFilter();
        }
        if (weatherAlarmCount >= bean.f184949j.size()) {
            x(bean);
            this.root.startAnimation(com.tencent.mobileqq.activity.qqsettingme.utils.c.a(0.0f, 1.0f));
            return;
        }
        com.tencent.mobileqq.activity.qqsettingme.bo boVar = bean.f184949j.get(weatherAlarmCount);
        String str = boVar.f184978a;
        Intrinsics.checkNotNullExpressionValue(str, "info.icon");
        String str2 = bean.f184940a;
        Intrinsics.checkNotNullExpressionValue(str2, "bean.curTemp");
        String str3 = bean.f184941b;
        Intrinsics.checkNotNullExpressionValue(str3, "bean.curAreaInfo");
        n(str, str2, str3);
        TextView textView = this.weatherArea;
        if (textView != null) {
            textView.setText(boVar.f184979b);
        }
        TextView textView2 = this.weatherArea;
        if (textView2 != null) {
            textView2.setTextColor(com.tencent.mobileqq.activity.qqsettingme.utils.c.c(boVar.f184980c, -16777216));
        }
        u(bean, weatherAlarmCount);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(com.tencent.mobileqq.activity.qqsettingme.bean.p bean) {
        this.handler.removeMessages(1);
        x(bean);
    }

    private final void x(com.tencent.mobileqq.activity.qqsettingme.bean.p bean) {
        boolean z16;
        String str;
        TextView textView;
        CharSequence charSequence;
        TextView textView2;
        if (bean.f184946g == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        Resources resources = this.root.getResources();
        if (resources != null) {
            int color = resources.getColor(R.color.qui_common_text_primary);
            TextView textView3 = this.weatherArea;
            if (textView3 != null) {
                textView3.setTextColor(color);
            }
        }
        if (z16) {
            URLImageView uRLImageView = this.weatherIcon;
            if (uRLImageView != null) {
                uRLImageView.setVisibility(0);
            }
            TextView textView4 = this.temperature;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
            String str2 = bean.f184947h;
            Intrinsics.checkNotNullExpressionValue(str2, "bean.upText");
            String str3 = bean.f184940a;
            Intrinsics.checkNotNullExpressionValue(str3, "bean.curTemp");
            String str4 = bean.f184941b;
            Intrinsics.checkNotNullExpressionValue(str4, "bean.curAreaInfo");
            n(str2, str3, str4);
            URLImageView uRLImageView2 = this.weatherIcon;
            if (uRLImageView2 != null) {
                uRLImageView2.setColorFilter(ContextCompat.getColor(this.activity, R.color.qui_common_icon_primary));
            }
        } else {
            URLImageView uRLImageView3 = this.weatherIcon;
            if (uRLImageView3 != null) {
                uRLImageView3.setVisibility(8);
            }
            TextView textView5 = this.temperature;
            if (textView5 != null) {
                textView5.setVisibility(0);
            }
        }
        if (!TextUtils.isEmpty(bean.f184948i) && !TextUtils.isEmpty(bean.f184941b) && !TextUtils.isEmpty(bean.f184947h)) {
            this.root.setVisibility(0);
            TextView textView6 = this.weatherArea;
            if (textView6 != null) {
                textView6.setVisibility(0);
            }
            this.root.setClickable(true);
            CharSequence charSequence2 = null;
            if (!z16) {
                TextView textView7 = this.temperature;
                if (textView7 != null) {
                    charSequence = textView7.getText();
                } else {
                    charSequence = null;
                }
                if (!Intrinsics.areEqual(charSequence, bean.f184947h) && (textView2 = this.temperature) != null) {
                    textView2.setText(bean.f184947h);
                }
            }
            TextView textView8 = this.weatherArea;
            if (textView8 != null) {
                charSequence2 = textView8.getText();
            }
            if (!Intrinsics.areEqual(charSequence2, bean.f184948i) && (textView = this.weatherArea) != null) {
                textView.setText(bean.f184948i);
            }
            try {
                str = URLEncoder.encode(bean.f184941b, "utf-8");
                Intrinsics.checkNotNullExpressionValue(str, "{\n                URLEnc\u2026o, \"utf-8\")\n            }");
            } catch (Exception unused) {
                str = bean.f184941b;
                Intrinsics.checkNotNullExpressionValue(str, "{\n                bean.curAreaInfo\n            }");
            }
            TextView textView9 = this.weatherArea;
            if (textView9 != null) {
                textView9.setTag("&city=" + str + "&adcode=" + bean.f184942c);
            }
            boolean z17 = bean.f184945f;
            String str5 = bean.f184940a;
            Intrinsics.checkNotNullExpressionValue(str5, "bean.curTemp");
            q(z17, str5, z16);
        }
        s(bean.f184945f, bean.f184943d, com.tencent.mobileqq.activity.qqsettingme.utils.c.b(bean.f184949j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(com.tencent.mobileqq.activity.qqsettingme.bean.p bean) {
        if (QLog.isColorLevel()) {
            QLog.d("WeatherSettingItem", 2, "updateWeatherView cur_temp:", bean.f184940a, ",cur_areainfo:", bean.f184941b, ",cur_adcode:", Integer.valueOf(bean.f184942c), ",o_wea_code:", bean.f184943d, ",show_flag:", Boolean.valueOf(bean.f184944e), ",up_type:", Integer.valueOf(bean.f184946g), ",up_text:", bean.f184947h, ",down_text:", bean.f184948i);
        }
        if (!bean.f184944e) {
            this.root.setVisibility(8);
            this.root.setClickable(false);
            TextView textView = this.weatherArea;
            if (textView != null) {
                textView.setVisibility(4);
            }
            URLImageView uRLImageView = this.weatherIcon;
            if (uRLImageView != null) {
                uRLImageView.setVisibility(8);
                return;
            }
            return;
        }
        if (bean.f184949j.size() > 0) {
            x(bean);
            AlphaAnimation a16 = com.tencent.mobileqq.activity.qqsettingme.utils.c.a(1.0f, 0.0f);
            a16.setStartOffset(2000L);
            a16.setAnimationListener(new e(bean, this));
            this.root.startAnimation(a16);
            return;
        }
        x(bean);
    }

    @NotNull
    /* renamed from: o, reason: from getter */
    public final View getRoot() {
        return this.root;
    }

    /* renamed from: r, reason: from getter */
    public final boolean getIsResume() {
        return this.isResume;
    }

    public final void t(boolean z16) {
        this.isResume = z16;
    }

    public /* synthetic */ WeatherSettingItem(Activity activity, QQSettingMeViewModel qQSettingMeViewModel, LifecycleOwner lifecycleOwner, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, qQSettingMeViewModel, lifecycleOwner, (i16 & 8) != 0 ? R.layout.qq_setting_me_weather_setting_item_v9 : i3);
    }
}
