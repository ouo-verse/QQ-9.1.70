package com.tencent.guild.aio.component.slowmode;

import android.content.res.Resources;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.guild.aio.component.slowmode.GuildSlowModeUIState;
import com.tencent.guild.aio.component.slowmode.a;
import com.tencent.guild.aio.input.realinput.s;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 B2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001CB\u000f\u0012\u0006\u0010,\u001a\u00020'\u00a2\u0006\u0004\b@\u0010AJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016J\u0016\u0010 \u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u001f0\u001eH\u0016J\u0014\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030!H\u0016J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0003H\u0016J\b\u0010%\u001a\u00020\u0006H\u0016J\u0006\u0010&\u001a\u00020\u0006R\u0017\u0010,\u001a\u00020'8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>\u00a8\u0006D"}, d2 = {"Lcom/tencent/guild/aio/component/slowmode/c;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/guild/aio/component/slowmode/a;", "Lcom/tencent/guild/aio/component/slowmode/GuildSlowModeUIState;", "Lcom/tencent/qqnt/msg/data/b;", "limitInfoData", "", "f1", "", ViewStickEventHelper.IS_SHOW, "g1", "k1", "Lcom/tencent/guild/aio/component/slowmode/f;", "uiData", "o1", "", "tip", "j1", "d1", "", "millisRemain", ICustomDataEditor.NUMBER_PARAM_1, "", "time", "i1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "bindViewAndData", "", "Ljava/lang/Class;", "getObserverStates", "Lcom/tencent/aio/base/mvvm/b;", "e1", "state", "h1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "m1", "Lcom/tencent/guild/aio/component/slowmode/SlowModeAIOType;", "d", "Lcom/tencent/guild/aio/component/slowmode/SlowModeAIOType;", "getType", "()Lcom/tencent/guild/aio/component/slowmode/SlowModeAIOType;", "type", "Landroid/widget/LinearLayout;", "e", "Landroid/widget/LinearLayout;", "mSlowModeLl", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "slowModeTipTv", "Landroid/content/res/Resources;", h.F, "Landroid/content/res/Resources;", DKConfiguration.Directory.RESOURCES, "Landroid/os/CountDownTimer;", "i", "Landroid/os/CountDownTimer;", "slowModeTimer", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "mIsFirstShow", "<init>", "(Lcom/tencent/guild/aio/component/slowmode/SlowModeAIOType;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c extends com.tencent.aio.base.mvvm.a<a, GuildSlowModeUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SlowModeAIOType type;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mSlowModeLl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView slowModeTipTv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Resources resources;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CountDownTimer slowModeTimer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mIsFirstShow;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f110345a;

        static {
            int[] iArr = new int[SlowModeTipType.values().length];
            try {
                iArr[SlowModeTipType.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SlowModeTipType.DETAIL_HOUR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SlowModeTipType.DETAIL_SECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SlowModeTipType.DETAIL_MINUTE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SlowModeTipType.DETAIL_MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f110345a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/guild/aio/component/slowmode/c$c", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "", AdCommonMethodHandler.AdCommonEvent.ON_TICK, "onFinish", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.component.slowmode.c$c, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class CountDownTimerC1183c extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f110346a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        CountDownTimerC1183c(long j3, c cVar) {
            super(j3, 1000L);
            this.f110346a = cVar;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            this.f110346a.m1();
            this.f110346a.sendIntent(new a.d(false));
            this.f110346a.sendIntent(new a.e(true));
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            int i3;
            if (millisUntilFinished % 1000 == 0) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            int i16 = (((int) millisUntilFinished) / 1000) + i3;
            if (i16 > 1) {
                this.f110346a.i1(i16 - 1);
            } else {
                onFinish();
            }
        }
    }

    public c(@NotNull SlowModeAIOType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.mIsFirstShow = true;
    }

    private final void d1() {
        CountDownTimer countDownTimer = this.slowModeTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.slowModeTimer = null;
    }

    private final void f1(com.tencent.qqnt.msg.data.b limitInfoData) {
        sendIntent(new a.C1182a(limitInfoData));
    }

    private final void g1(boolean isShow) {
        int i3;
        if (this.type == SlowModeAIOType.ARTICLE && this.mIsFirstShow && isShow) {
            k1();
            return;
        }
        LinearLayout linearLayout = this.mSlowModeLl;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSlowModeLl");
            linearLayout = null;
        }
        if (isShow) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        linearLayout.setVisibility(i3);
        LinearLayout linearLayout3 = this.mSlowModeLl;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSlowModeLl");
            linearLayout3 = null;
        }
        linearLayout3.setBackgroundResource(s.f111173a.a());
        LinearLayout linearLayout4 = this.mSlowModeLl;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSlowModeLl");
        } else {
            linearLayout2 = linearLayout4;
        }
        linearLayout2.setPadding(ViewUtils.dpToPx(19.333f), 0, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i1(int time) {
        String format;
        int i3 = time / 3600;
        int i16 = (time % 3600) / 60;
        int i17 = time % 60;
        Resources resources = null;
        if (i3 > 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Resources resources2 = this.resources;
            if (resources2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DKConfiguration.Directory.RESOURCES);
            } else {
                resources = resources2;
            }
            String string = resources.getString(R.string.f156861lc);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.\u2026mode_countdown_tip_hours)");
            format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17)}, 3));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        } else {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            Resources resources3 = this.resources;
            if (resources3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DKConfiguration.Directory.RESOURCES);
            } else {
                resources = resources3;
            }
            String string2 = resources.getString(R.string.f156851lb);
            Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(com.\u2026_slow_mode_countdown_tip)");
            format = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(i16), Integer.valueOf(i17)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        }
        j1(format);
    }

    private final void j1(String tip) {
        TextView textView = this.slowModeTipTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("slowModeTipTv");
            textView = null;
        }
        textView.setText(tip);
    }

    private final void k1() {
        LinearLayout linearLayout = this.mSlowModeLl;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSlowModeLl");
            linearLayout = null;
        }
        linearLayout.post(new Runnable() { // from class: com.tencent.guild.aio.component.slowmode.b
            @Override // java.lang.Runnable
            public final void run() {
                c.l1(c.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l1(c this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LinearLayout linearLayout = this$0.mSlowModeLl;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSlowModeLl");
            linearLayout = null;
        }
        linearLayout.setAlpha(0.0f);
        LinearLayout linearLayout3 = this$0.mSlowModeLl;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSlowModeLl");
            linearLayout3 = null;
        }
        linearLayout3.setVisibility(0);
        LinearLayout linearLayout4 = this$0.mSlowModeLl;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSlowModeLl");
            linearLayout4 = null;
        }
        int measuredHeight = linearLayout4.getMeasuredHeight();
        if (measuredHeight <= 0) {
            LinearLayout linearLayout5 = this$0.mSlowModeLl;
            if (linearLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSlowModeLl");
                linearLayout5 = null;
            }
            measuredHeight = Utils.n(25.667f, linearLayout5.getResources());
        }
        LinearLayout linearLayout6 = this$0.mSlowModeLl;
        if (linearLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSlowModeLl");
            linearLayout6 = null;
        }
        linearLayout6.setTranslationY(measuredHeight);
        LinearLayout linearLayout7 = this$0.mSlowModeLl;
        if (linearLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSlowModeLl");
        } else {
            linearLayout2 = linearLayout7;
        }
        linearLayout2.animate().translationYBy(-measuredHeight).alphaBy(1.0f).setDuration(500L).start();
        this$0.mIsFirstShow = false;
    }

    private final void n1(long millisRemain) {
        d1();
        CountDownTimerC1183c countDownTimerC1183c = new CountDownTimerC1183c(millisRemain, this);
        this.slowModeTimer = countDownTimerC1183c;
        countDownTimerC1183c.start();
    }

    private final void o1(SlowModeUIData uiData) {
        String string;
        TextView textView = this.slowModeTipTv;
        Resources resources = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("slowModeTipTv");
            textView = null;
        }
        int i3 = b.f110345a[uiData.getType().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                            Resources resources2 = this.resources;
                            if (resources2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException(DKConfiguration.Directory.RESOURCES);
                            } else {
                                resources = resources2;
                            }
                            String string2 = resources.getString(R.string.f156931lj);
                            Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(com.\u2026ld_slow_mode_tip_minutes)");
                            string = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(uiData.getCycle()), Integer.valueOf(uiData.getCount())}, 2));
                            Intrinsics.checkNotNullExpressionValue(string, "format(format, *args)");
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    } else {
                        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                        Resources resources3 = this.resources;
                        if (resources3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(DKConfiguration.Directory.RESOURCES);
                        } else {
                            resources = resources3;
                        }
                        String string3 = resources.getString(R.string.f156921li);
                        Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(com.\u2026ild_slow_mode_tip_minute)");
                        string = String.format(string3, Arrays.copyOf(new Object[]{Integer.valueOf(uiData.getCount())}, 1));
                        Intrinsics.checkNotNullExpressionValue(string, "format(format, *args)");
                    }
                } else {
                    StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                    Resources resources4 = this.resources;
                    if (resources4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(DKConfiguration.Directory.RESOURCES);
                    } else {
                        resources = resources4;
                    }
                    String string4 = resources.getString(R.string.f156941lk);
                    Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(com.\u2026ld_slow_mode_tip_seconds)");
                    string = String.format(string4, Arrays.copyOf(new Object[]{Integer.valueOf(uiData.getCycle()), Integer.valueOf(uiData.getCount())}, 2));
                    Intrinsics.checkNotNullExpressionValue(string, "format(format, *args)");
                }
            } else {
                StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
                Resources resources5 = this.resources;
                if (resources5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(DKConfiguration.Directory.RESOURCES);
                } else {
                    resources = resources5;
                }
                String string5 = resources.getString(R.string.f156911lh);
                Intrinsics.checkNotNullExpressionValue(string5, "resources.getString(com.\u2026uild_slow_mode_tip_hours)");
                string = String.format(string5, Arrays.copyOf(new Object[]{Integer.valueOf(uiData.getCycle()), Integer.valueOf(uiData.getCount())}, 2));
                Intrinsics.checkNotNullExpressionValue(string, "format(format, *args)");
            }
        } else {
            Resources resources6 = this.resources;
            if (resources6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DKConfiguration.Directory.RESOURCES);
            } else {
                resources = resources6;
            }
            string = resources.getString(R.string.f156881le);
        }
        textView.setText(string);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        sendIntent(a.b.f110334d);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: e1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<a, GuildSlowModeUIState> createVM() {
        return new GuildSlowModeViewModel();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends GuildSlowModeUIState>> getObserverStates() {
        return CollectionsKt.listOf((Object[]) new Class[]{GuildSlowModeUIState.GuildFreqLimitInfo.class, GuildSlowModeUIState.SlowModeTipVisible.class, GuildSlowModeUIState.UpdateSlowModeTipText.class, GuildSlowModeUIState.CancelTimer.class, GuildSlowModeUIState.StartTimer.class});
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: h1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GuildSlowModeUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildSlowModeUIState.GuildFreqLimitInfo) {
            f1(((GuildSlowModeUIState.GuildFreqLimitInfo) state).getLimitInfoData());
            return;
        }
        if (state instanceof GuildSlowModeUIState.SlowModeTipVisible) {
            g1(((GuildSlowModeUIState.SlowModeTipVisible) state).getCom.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper.IS_SHOW java.lang.String());
            return;
        }
        if (state instanceof GuildSlowModeUIState.UpdateSlowModeTipText) {
            o1(((GuildSlowModeUIState.UpdateSlowModeTipText) state).getUiData());
        } else if (state instanceof GuildSlowModeUIState.CancelTimer) {
            d1();
        } else if (state instanceof GuildSlowModeUIState.StartTimer) {
            n1(((GuildSlowModeUIState.StartTimer) state).getMillisRemain());
        }
    }

    public final void m1() {
        sendIntent(a.c.f110335d);
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        Resources resources = createViewParams.a().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "createViewParams.context.resources");
        this.resources = resources;
        FrameLayout frameLayout = new FrameLayout(createViewParams.a());
        LinearLayout linearLayout = null;
        View inflate = LayoutInflater.from(createViewParams.a()).inflate(R.layout.ef7, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout2 = (LinearLayout) inflate;
        this.mSlowModeLl = linearLayout2;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSlowModeLl");
            linearLayout2 = null;
        }
        View findViewById = linearLayout2.findViewById(R.id.sik);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mSlowModeLl.findViewById\u2026o_input_slow_mode_tip_tv)");
        this.slowModeTipTv = (TextView) findViewById;
        LinearLayout linearLayout3 = this.mSlowModeLl;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSlowModeLl");
            linearLayout3 = null;
        }
        linearLayout3.findViewById(R.id.sij);
        LinearLayout linearLayout4 = this.mSlowModeLl;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSlowModeLl");
        } else {
            linearLayout = linearLayout4;
        }
        frameLayout.addView(linearLayout, com.tencent.aio.base.tool.b.f69219a.a(createViewParams.a(), -1, 25));
        return frameLayout;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        super.onDestroy();
        d1();
    }
}
