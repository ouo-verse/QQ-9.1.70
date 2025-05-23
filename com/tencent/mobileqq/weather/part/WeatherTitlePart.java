package com.tencent.mobileqq.weather.part;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.image.URLDrawable;
import com.tencent.jungle.weather.proto.WeatherInfo$Weather;
import com.tencent.jungle.weather.proto.WeatherReportStore$WeatherInfo;
import com.tencent.jungle.weather.proto.weather$Config;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.weather.event.WeatherRequestAdCodeEvent;
import com.tencent.mobileqq.weather.event.WeatherTitleBgChangeEvent;
import com.tencent.mobileqq.weather.event.WeatherViewPageSelectChangeEvent;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.UiThreadUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 V2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001WB\u0007\u00a2\u0006\u0004\bT\u0010UJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\r\u001a\u00020\u00042\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\b\u0010\u0011\u001a\u00020\u000bH\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u001c\u0010\u0018\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\"\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030 0\u001fj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030 `!H\u0016R\u0016\u0010%\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010+\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010(R\u0018\u0010/\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010(R\u0018\u00101\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010(R\u0018\u00103\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010(R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010A\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010>R\u0018\u0010C\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u00106R\u0018\u0010D\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010(R$\u0010G\u001a\u0012\u0012\u0004\u0012\u00020&0\u001fj\b\u0012\u0004\u0012\u00020&`!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010FR8\u0010M\u001a&\u0012\f\u0012\n I*\u0004\u0018\u00010\u000b0\u000b I*\u0012\u0012\f\u0012\n I*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010J0H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010LR#\u0010S\u001a\n I*\u0004\u0018\u00010N0N8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\u00a8\u0006X"}, d2 = {"Lcom/tencent/mobileqq/weather/part/WeatherTitlePart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "S9", "X9", "", "hasPermission", "oa", "", "", "warningCityIndexList", "qa", "isTransParent", "pa", "Z9", "W9", "", "getLogTag", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "d", "I", "mPagePos", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "mExitImage", "f", "mShareImage", tl.h.F, "mSettingImage", "i", "mLocationImage", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mSelectPoint", BdhLogUtil.LogTag.Tag_Conn, "mTitleLayoutBg", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "mLocationText", "Landroidx/constraintlayout/widget/ConstraintLayout;", "E", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mTitleLayout", "Landroid/widget/LinearLayout;", UserInfo.SEX_FEMALE, "Landroid/widget/LinearLayout;", "mTitleSelectLayout", "G", "mPermissionTipLayout", "H", "mPermissionTipGetLocation", "mPermissionTipClose", "J", "Ljava/util/ArrayList;", "mSelectImgList", "", "kotlin.jvm.PlatformType", "", "K", "Ljava/util/Set;", "mRedWarningHasShownIndexList", "Lcom/tencent/mobileqq/weather/mvvm/e;", "L", "Lkotlin/Lazy;", "V9", "()Lcom/tencent/mobileqq/weather/mvvm/e;", "mTitleViewModel", "<init>", "()V", "M", "a", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class WeatherTitlePart extends Part implements SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final List<String> N;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private ImageView mTitleLayoutBg;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private TextView mLocationText;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ConstraintLayout mTitleLayout;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private LinearLayout mTitleSelectLayout;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private LinearLayout mPermissionTipLayout;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private TextView mPermissionTipGetLocation;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private ImageView mPermissionTipClose;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<ImageView> mSelectImgList;

    /* renamed from: K, reason: from kotlin metadata */
    private final Set<Integer> mRedWarningHasShownIndexList;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy mTitleViewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private volatile int mPagePos;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mExitImage;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mShareImage;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mSettingImage;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mLocationImage;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mSelectPoint;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/weather/part/WeatherTitlePart$a;", "", "", "", "ADAPTION_DEVICE_LIST", "Ljava/util/List;", "AD_CODE_KEY", "Ljava/lang/String;", "SLIDE_KEY", "TAG", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.weather.part.WeatherTitlePart$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
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
        List<String> mutableListOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43536);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        INSTANCE = new Companion(null);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf("ANA-AN00", "ANA-TN00");
        N = mutableListOf;
    }

    public WeatherTitlePart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mSelectImgList = new ArrayList<>();
        this.mRedWarningHasShownIndexList = Collections.synchronizedSet(new HashSet());
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.weather.mvvm.e>() { // from class: com.tencent.mobileqq.weather.part.WeatherTitlePart$mTitleViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WeatherTitlePart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.weather.mvvm.e invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.weather.mvvm.e) WeatherTitlePart.this.getViewModel(com.tencent.mobileqq.weather.mvvm.e.class) : (com.tencent.mobileqq.weather.mvvm.e) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.mTitleViewModel = lazy;
    }

    private final void S9() {
        if (this.mPagePos != 0) {
            return;
        }
        boolean f16 = com.tencent.mobileqq.weather.util.b.f(getActivity(), QQPermissionConstants.Business.SCENE.WEATHER_H5);
        QLog.d("WeatherTitlePart", 1, "hasPermission:", Boolean.valueOf(f16));
        oa(f16);
        if (f16) {
            X9();
            return;
        }
        LinearLayout linearLayout = this.mPermissionTipLayout;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        com.tencent.mobileqq.weather.util.report.l.f313686a.e();
        TextView textView = this.mPermissionTipGetLocation;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.weather.part.al
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WeatherTitlePart.T9(view);
                }
            });
        }
        ImageView imageView = this.mPermissionTipClose;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.weather.part.am
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WeatherTitlePart.U9(WeatherTitlePart.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        SimpleEventBus.getInstance().dispatchEvent(new WeatherRequestAdCodeEvent(0));
        com.tencent.mobileqq.weather.util.report.l.f313686a.d();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(WeatherTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LinearLayout linearLayout = this$0.mPermissionTipLayout;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        com.tencent.mobileqq.weather.util.report.l.f313686a.c();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final com.tencent.mobileqq.weather.mvvm.e V9() {
        return (com.tencent.mobileqq.weather.mvvm.e) this.mTitleViewModel.getValue();
    }

    private final int W9() {
        Float f16 = com.tencent.mobileqq.weather.data.f.f313296a.g().get(Integer.valueOf(this.mPagePos));
        if (f16 == null) {
            f16 = Float.valueOf(0.0f);
        }
        if (f16.floatValue() >= 0.5f) {
            return 1;
        }
        return 0;
    }

    private final void X9() {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.weather.part.ah
            @Override // java.lang.Runnable
            public final void run() {
                WeatherTitlePart.Y9(WeatherTitlePart.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(WeatherTitlePart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LinearLayout linearLayout = this$0.mPermissionTipLayout;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    private final boolean Z9() {
        String model = DeviceInfoMonitor.getModel();
        Iterator<T> it = N.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual((String) it.next(), model)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ca(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ea(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ga(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ha(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ia(WeatherTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getActivity().finish();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ja(Context context, WeatherTitlePart this$0, View view) {
        Integer num;
        PBUInt32Field pBUInt32Field;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.weather.util.g gVar = com.tencent.mobileqq.weather.util.g.f313646a;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        WeatherInfo$Weather value = this$0.V9().S1().getValue();
        if (value != null && (pBUInt32Field = value.adcode) != null) {
            num = Integer.valueOf(pBUInt32Field.get());
        } else {
            num = null;
        }
        gVar.O(context, "https://weather.mp.qq.com/page/poster?_wv=2&&_wwv=4&adcode=" + num + "&slide=" + this$0.W9());
        com.tencent.mobileqq.weather.util.report.r.f313695a.f();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void la(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.mobileqq.weather.util.g gVar = com.tencent.mobileqq.weather.util.g.f313646a;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        gVar.O(context, "https://weather.mp.qq.com/page/warn?_wwv=4");
        com.tencent.mobileqq.weather.util.report.r.f313695a.e();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ma(Context context, WeatherTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.weather.util.g gVar = com.tencent.mobileqq.weather.util.g.f313646a;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        gVar.O(context, "https://weather.mp.qq.com/page/addCity?_wv=16777219&adcode=" + ((Object) this$0.V9().N1().getValue()));
        com.tencent.mobileqq.weather.util.report.r.f313695a.d(this$0.mPagePos);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void na(Context context, WeatherTitlePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.weather.util.g gVar = com.tencent.mobileqq.weather.util.g.f313646a;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        gVar.O(context, "https://weather.mp.qq.com/page/addCity?_wv=16777219&adcode=" + ((Object) this$0.V9().N1().getValue()));
        com.tencent.mobileqq.weather.util.report.r.f313695a.d(this$0.mPagePos);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void oa(boolean hasPermission) {
        Drawable drawable;
        if (this.mSelectImgList.isEmpty()) {
            return;
        }
        ImageView imageView = this.mSelectImgList.get(0);
        Intrinsics.checkNotNullExpressionValue(imageView, "mSelectImgList[0]");
        ImageView imageView2 = imageView;
        if (hasPermission) {
            drawable = getContext().getResources().getDrawable(R.drawable.niz, null);
        } else {
            drawable = getContext().getResources().getDrawable(R.drawable.l0_, null);
        }
        if (drawable != null) {
            imageView2.setImageDrawable(drawable);
        }
        if (hasPermission) {
            com.tencent.qqnt.base.utils.c cVar = com.tencent.qqnt.base.utils.c.f353052a;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(cVar.b(8), cVar.b(8));
            layoutParams.topMargin = cVar.b(2);
            imageView2.setLayoutParams(layoutParams);
        } else {
            com.tencent.qqnt.base.utils.c cVar2 = com.tencent.qqnt.base.utils.c.f353052a;
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(cVar2.b(6), cVar2.b(6));
            layoutParams2.topMargin = cVar2.b(3);
            imageView2.setLayoutParams(layoutParams2);
        }
        imageView2.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pa(boolean isTransParent) {
        String str;
        WeatherReportStore$WeatherInfo weatherReportStore$WeatherInfo;
        PBEnumField pBEnumField;
        PBStringField pBStringField;
        if (isTransParent) {
            ImageView imageView = this.mTitleLayoutBg;
            if (imageView != null) {
                imageView.setImageDrawable(new ColorDrawable(0));
                return;
            }
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        obtain.mLoadingDrawable = gradientDrawable;
        obtain.mFailedDrawable = gradientDrawable;
        try {
            weather$Config value = V9().M1().getValue();
            Integer num = null;
            if (value != null && (pBStringField = value.navigationPicPath) != null) {
                str = pBStringField.get();
            } else {
                str = null;
            }
            String valueOf = String.valueOf(str);
            if (TextUtils.isEmpty(valueOf)) {
                com.tencent.mobileqq.weather.util.g gVar = com.tencent.mobileqq.weather.util.g.f313646a;
                WeatherInfo$Weather value2 = V9().S1().getValue();
                if (value2 != null && (weatherReportStore$WeatherInfo = value2.weather_info) != null && (pBEnumField = weatherReportStore$WeatherInfo.concrete_type) != null) {
                    num = Integer.valueOf(pBEnumField.get());
                }
                valueOf = gVar.w(num, gVar.E(V9().S1().getValue()));
            }
            URLDrawable drawable = URLDrawable.getDrawable(valueOf, obtain);
            Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(titleBgUrl, options)");
            ImageView imageView2 = this.mTitleLayoutBg;
            if (imageView2 != null) {
                imageView2.setImageDrawable(drawable);
            }
        } catch (Exception e16) {
            QLog.e("WeatherTitlePart", 1, "updateTitleBg error:", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void qa(List<Integer> warningCityIndexList) {
        if (warningCityIndexList == null) {
            return;
        }
        Iterator<ImageView> it = this.mSelectImgList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            int i16 = i3 + 1;
            ImageView next = it.next();
            if (i3 != 0) {
                if (warningCityIndexList.contains(Integer.valueOf(i3)) && !this.mRedWarningHasShownIndexList.contains(Integer.valueOf(i3))) {
                    next.setImageDrawable(getContext().getResources().getDrawable(R.drawable.l0a, null));
                } else {
                    next.setImageDrawable(getContext().getResources().getDrawable(R.drawable.l0_, null));
                }
            }
            i3 = i16;
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(WeatherTitleBgChangeEvent.class, WeatherViewPageSelectChangeEvent.class, WeatherRequestAdCodeEvent.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 7, (Object) this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "WeatherTitlePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.mTitleLayout = (ConstraintLayout) rootView.findViewById(R.id.f121707bz);
        this.mTitleLayoutBg = (ImageView) rootView.findViewById(R.id.f121727c1);
        this.mLocationText = (TextView) rootView.findViewById(R.id.f121757c4);
        this.mLocationImage = (ImageView) rootView.findViewById(R.id.f121747c3);
        this.mSelectPoint = (ImageView) rootView.findViewById(R.id.f121767c5);
        this.mSettingImage = (ImageView) rootView.findViewById(R.id.f121787c7);
        this.mShareImage = (ImageView) rootView.findViewById(R.id.f121797c8);
        this.mExitImage = (ImageView) rootView.findViewById(R.id.f121717c0);
        this.mTitleSelectLayout = (LinearLayout) rootView.findViewById(R.id.f121777c6);
        this.mPermissionTipLayout = (LinearLayout) rootView.findViewById(R.id.f121357b1);
        this.mPermissionTipGetLocation = (TextView) rootView.findViewById(R.id.f121367b2);
        this.mPermissionTipClose = (ImageView) rootView.findViewById(R.id.f121347b0);
        ImageView imageView = this.mSelectPoint;
        if (imageView != null) {
            this.mSelectImgList.add(imageView);
        }
        final Context context = getContext();
        ViewGroup.LayoutParams layoutParams = null;
        Drawable drawable = context.getResources().getDrawable(R.drawable.l0_, null);
        com.tencent.qqnt.base.utils.c cVar = com.tencent.qqnt.base.utils.c.f353052a;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(cVar.b(6), cVar.b(6));
        layoutParams2.leftMargin = cVar.b(3);
        layoutParams2.topMargin = cVar.b(3);
        for (int i3 = 0; i3 < 9; i3++) {
            ImageView imageView2 = new ImageView(context);
            imageView2.setImageDrawable(drawable);
            LinearLayout linearLayout = this.mTitleSelectLayout;
            if (linearLayout != null) {
                linearLayout.addView(imageView2, layoutParams2);
            }
            this.mSelectImgList.add(imageView2);
        }
        ConstraintLayout constraintLayout = this.mTitleLayout;
        if (constraintLayout != null) {
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.weather.part.an
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WeatherTitlePart.aa(view);
                }
            });
        }
        ImageView imageView3 = this.mExitImage;
        if (imageView3 != null) {
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.weather.part.aq
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WeatherTitlePart.ia(WeatherTitlePart.this, view);
                }
            });
        }
        ImageView imageView4 = this.mShareImage;
        if (imageView4 != null) {
            imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.weather.part.ar
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WeatherTitlePart.ja(context, this, view);
                }
            });
        }
        ImageView imageView5 = this.mSettingImage;
        if (imageView5 != null) {
            imageView5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.weather.part.as
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WeatherTitlePart.la(context, view);
                }
            });
        }
        ImageView imageView6 = this.mLocationImage;
        if (imageView6 != null) {
            imageView6.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.weather.part.at
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WeatherTitlePart.ma(context, this, view);
                }
            });
        }
        TextView textView = this.mLocationText;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.weather.part.au
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WeatherTitlePart.na(context, this, view);
                }
            });
        }
        TextView textView2 = this.mLocationText;
        if (textView2 != null) {
            textView2.setText(com.tencent.mobileqq.weather.data.f.f313296a.j());
        }
        S9();
        final com.tencent.mobileqq.weather.mvvm.e V9 = V9();
        MutableLiveData<WeatherInfo$Weather> S1 = V9.S1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<WeatherInfo$Weather, Unit> function1 = new Function1<WeatherInfo$Weather, Unit>(V9) { // from class: com.tencent.mobileqq.weather.part.WeatherTitlePart$onInitView$8$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ com.tencent.mobileqq.weather.mvvm.e $this_with;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_with = V9;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WeatherTitlePart.this, (Object) V9);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WeatherInfo$Weather weatherInfo$Weather) {
                invoke2(weatherInfo$Weather);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(WeatherInfo$Weather it) {
                TextView textView3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                textView3 = WeatherTitlePart.this.mLocationText;
                if (textView3 != null) {
                    com.tencent.mobileqq.weather.util.g gVar = com.tencent.mobileqq.weather.util.g.f313646a;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    textView3.setText(gVar.v(it));
                }
                Boolean value = this.$this_with.Q1().getValue();
                if (value != null) {
                    WeatherTitlePart.this.pa(value.booleanValue());
                }
            }
        };
        S1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.weather.part.av
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WeatherTitlePart.ea(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> P1 = V9.P1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.weather.part.WeatherTitlePart$onInitView$8$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WeatherTitlePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                ImageView imageView7;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                imageView7 = WeatherTitlePart.this.mSelectPoint;
                if (imageView7 == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                imageView7.setVisibility(it.booleanValue() ? 0 : 8);
            }
        };
        P1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.weather.part.ai
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WeatherTitlePart.ga(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> Q1 = V9.Q1();
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.weather.part.WeatherTitlePart$onInitView$8$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WeatherTitlePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                WeatherTitlePart weatherTitlePart = WeatherTitlePart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                weatherTitlePart.pa(it.booleanValue());
            }
        };
        Q1.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.weather.part.aj
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WeatherTitlePart.ha(Function1.this, obj);
            }
        });
        MutableLiveData<Integer> L1 = V9.L1();
        LifecycleOwner lifecycleOwner4 = getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function14 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.weather.part.WeatherTitlePart$onInitView$8$4
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WeatherTitlePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer it) {
                ArrayList arrayList;
                ArrayList arrayList2;
                int coerceAtMost;
                ArrayList arrayList3;
                ArrayList arrayList4;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                arrayList = WeatherTitlePart.this.mSelectImgList;
                int size = arrayList.size();
                for (int i16 = 0; i16 < size; i16++) {
                    arrayList4 = WeatherTitlePart.this.mSelectImgList;
                    ((ImageView) arrayList4.get(i16)).setVisibility(8);
                }
                arrayList2 = WeatherTitlePart.this.mSelectImgList;
                int size2 = arrayList2.size();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(size2, it.intValue());
                for (int i17 = 0; i17 < coerceAtMost; i17++) {
                    arrayList3 = WeatherTitlePart.this.mSelectImgList;
                    ((ImageView) arrayList3.get(i17)).setVisibility(0);
                }
            }
        };
        L1.observe(lifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.weather.part.ak
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WeatherTitlePart.ba(Function1.this, obj);
            }
        });
        MutableLiveData<Integer> O1 = V9.O1();
        LifecycleOwner lifecycleOwner5 = getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function15 = new Function1<Integer, Unit>(V9) { // from class: com.tencent.mobileqq.weather.part.WeatherTitlePart$onInitView$8$5
            static IPatchRedirector $redirector_;
            final /* synthetic */ com.tencent.mobileqq.weather.mvvm.e $this_with;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$this_with = V9;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WeatherTitlePart.this, (Object) V9);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                ArrayList arrayList;
                ArrayList arrayList2;
                ArrayList arrayList3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) num);
                    return;
                }
                arrayList = WeatherTitlePart.this.mSelectImgList;
                int size = arrayList.size();
                for (int i16 = 0; i16 < size; i16++) {
                    Integer value = this.$this_with.O1().getValue();
                    if (value != null && i16 == value.intValue()) {
                        arrayList3 = WeatherTitlePart.this.mSelectImgList;
                        ((ImageView) arrayList3.get(i16)).setAlpha(1.0f);
                    } else {
                        arrayList2 = WeatherTitlePart.this.mSelectImgList;
                        ((ImageView) arrayList2.get(i16)).setAlpha(0.4f);
                    }
                }
            }
        };
        O1.observe(lifecycleOwner5, new Observer() { // from class: com.tencent.mobileqq.weather.part.ao
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WeatherTitlePart.ca(Function1.this, obj);
            }
        });
        MutableLiveData<List<Integer>> R1 = V9.R1();
        LifecycleOwner lifecycleOwner6 = getPartHost().getLifecycleOwner();
        final Function1<List<? extends Integer>, Unit> function16 = new Function1<List<? extends Integer>, Unit>() { // from class: com.tencent.mobileqq.weather.part.WeatherTitlePart$onInitView$8$6
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WeatherTitlePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends Integer> list) {
                invoke2((List<Integer>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable List<Integer> list) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    WeatherTitlePart.this.qa(list);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) list);
                }
            }
        };
        R1.observe(lifecycleOwner6, new Observer() { // from class: com.tencent.mobileqq.weather.part.ap
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WeatherTitlePart.da(Function1.this, obj);
            }
        });
        if (Z9()) {
            ConstraintLayout constraintLayout2 = this.mTitleLayout;
            if (constraintLayout2 != null) {
                layoutParams = constraintLayout2.getLayoutParams();
            }
            if (layoutParams != null) {
                layoutParams.height = com.tencent.qqnt.base.utils.c.f353052a.b(90);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) savedInstanceState);
        } else {
            super.onPartCreate(activity, savedInstanceState);
            SimpleEventBus.getInstance().registerReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) event);
            return;
        }
        if (event instanceof WeatherTitleBgChangeEvent) {
            V9().Q1().postValue(Boolean.valueOf(((WeatherTitleBgChangeEvent) event).getNeedTransBg()));
            return;
        }
        if (event instanceof WeatherViewPageSelectChangeEvent) {
            this.mPagePos = ((WeatherViewPageSelectChangeEvent) event).getPagePosition();
            this.mRedWarningHasShownIndexList.add(Integer.valueOf(this.mPagePos));
        } else if ((event instanceof WeatherRequestAdCodeEvent) && ((WeatherRequestAdCodeEvent) event).getPermissionState() == 1) {
            X9();
            oa(true);
        }
    }
}
