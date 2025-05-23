package com.tencent.mobileqq.zplan.bubble;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.falco.utils.UIUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.bubble.c;
import com.tencent.mobileqq.zplan.minihome.CreateMiniHomeFragment;
import com.tencent.mobileqq.zplan.minihome.api.IMiniHomeHelper;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import mqq.app.MobileQQ;
import yi3.ZPlanMiniHomeGuidanceBubbleInfo;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB'\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0016\u0010\u0011\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010\"\u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010%\u001a\u00020#8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010$R\u0014\u0010&\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/zplan/bubble/ZPlanMiniHomeGuidanceBubbleViewController;", "Lcom/tencent/mobileqq/zplan/bubble/c;", "Lyi3/b;", "j", "Lyi3/e;", "newBubbleInfo", "", "b", "", "onCreate", "onShow", "onHide", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/widget/FrameLayout;", "newParent", "a", "Landroid/widget/FrameLayout;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "I", "parentWidthPx", "c", "parentHeightPx", "d", "Lyi3/b;", "bubbleInfo", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "bubbleView", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "k", "()Landroid/content/Context;", "context", "Landroid/graphics/Rect;", "()Landroid/graphics/Rect;", "globalVisibleRect", "isClickable", "()Z", "<init>", "(Landroid/widget/FrameLayout;IILyi3/b;)V", "f", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanMiniHomeGuidanceBubbleViewController implements c<ZPlanMiniHomeGuidanceBubbleInfo> {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: g, reason: collision with root package name */
    private static final ReadWriteProperty<Object, Long> f331992g;

    /* renamed from: h, reason: collision with root package name */
    private static final ReadWriteProperty<Object, Long> f331993h;

    /* renamed from: i, reason: collision with root package name */
    private static final ReadWriteProperty<Object, Integer> f331994i;

    /* renamed from: j, reason: collision with root package name */
    private static final ReadWriteProperty<Object, Boolean> f331995j;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private FrameLayout parent;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int parentWidthPx;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int parentHeightPx;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ZPlanMiniHomeGuidanceBubbleInfo bubbleInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView bubbleView;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\t\u001a\u00020\bR+\u0010\u0011\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00028F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R+\u0010\u0015\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00028F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R+\u0010\u001c\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u00168F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR+\u0010\"\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00068F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/zplan/bubble/ZPlanMiniHomeGuidanceBubbleViewController$a;", "", "", "uin", "", "source", "", "a", "", "j", "<set-?>", "mmkvNextShowAtMillis$delegate", "Lkotlin/properties/ReadWriteProperty;", "d", "()J", tl.h.F, "(J)V", "mmkvNextShowAtMillis", "mmkvDurationMillis$delegate", "b", "f", "mmkvDurationMillis", "", "mmkvRestShowTimes$delegate", "e", "()I", "i", "(I)V", "mmkvRestShowTimes", "mmkvForceShow$delegate", "c", "()Z", "g", "(Z)V", "mmkvForceShow", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.bubble.ZPlanMiniHomeGuidanceBubbleViewController$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ KProperty<Object>[] f332001a = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(Companion.class, "mmkvNextShowAtMillis", "getMmkvNextShowAtMillis()J", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Companion.class, "mmkvDurationMillis", "getMmkvDurationMillis()J", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Companion.class, "mmkvRestShowTimes", "getMmkvRestShowTimes()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Companion.class, "mmkvForceShow", "getMmkvForceShow()Z", 0))};

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(long uin, String source) {
            QQAppInterface l3 = bb.f335811a.l();
            Long valueOf = l3 != null ? Long.valueOf(l3.getLongAccountUin()) : null;
            if (valueOf == null) {
                QLog.e("ZPlanMiniHomeGuidanceBubbleViewController", 1, "askShow longAccountUin == null");
                return false;
            }
            if (uin != valueOf.longValue() && uin != 0) {
                QLog.e("ZPlanMiniHomeGuidanceBubbleViewController", 1, "askShow uin != curUin \u5ba2\u6001 return.");
                return false;
            }
            if (!Intrinsics.areEqual(source, ZootopiaSource.SUB_SOURCE_PROFILE_OWNER)) {
                QLog.e("ZPlanMiniHomeGuidanceBubbleViewController", 1, "\u4ec5\u9650\u4e3b\u6001\u8d44\u6599\u9875");
                return false;
            }
            if (((IMiniHomeHelper) QRoute.api(IMiniHomeHelper.class)).getZPlanMiniHomeSettingSwitch(valueOf.longValue())) {
                QLog.i("ZPlanMiniHomeGuidanceBubbleViewController", 2, "askShow \u8ff7\u4f60\u5c0f\u7a9d\u5df2\u5f00\u542f");
                return false;
            }
            if (c()) {
                return true;
            }
            if (!((IZPlanApi) QRoute.api(IZPlanApi.class)).miniHomeQQMCSwitchOn()) {
                QLog.e("ZPlanMiniHomeGuidanceBubbleViewController", 1, "askShow enableMiniHomeQQMC false.");
                return false;
            }
            if (!((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).enableZPlanNativeAppFilament(2)) {
                QLog.e("ZPlanMiniHomeGuidanceBubbleViewController", 1, "askShow enableFilament false.");
                return false;
            }
            int e16 = e();
            if (e16 <= 0) {
                QLog.i("ZPlanMiniHomeGuidanceBubbleViewController", 2, "askShow \u5269\u4f59\u5c55\u793a\u6b21\u6570\u4e0d\u8db3 restShowTimes == " + e16);
                return false;
            }
            long d16 = d();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < d16) {
                QLog.i("ZPlanMiniHomeGuidanceBubbleViewController", 2, "askShow \u4e0b\u6b21\u5c55\u793a\u65f6\u523b\u672a\u5230 nowMillis == " + currentTimeMillis + " > nextShowAtMillis == " + d16);
                return false;
            }
            long b16 = b();
            QLog.i("ZPlanMiniHomeGuidanceBubbleViewController", 1, "askShow \u5c55\u793a\u6210\u529f " + e16 + " " + currentTimeMillis + " " + b16 + " " + d16);
            i(e16 - 1);
            h(currentTimeMillis + b16);
            return true;
        }

        public final long b() {
            return ((Number) ZPlanMiniHomeGuidanceBubbleViewController.f331993h.getValue(this, f332001a[1])).longValue();
        }

        public final boolean c() {
            return ((Boolean) ZPlanMiniHomeGuidanceBubbleViewController.f331995j.getValue(this, f332001a[3])).booleanValue();
        }

        public final long d() {
            return ((Number) ZPlanMiniHomeGuidanceBubbleViewController.f331992g.getValue(this, f332001a[0])).longValue();
        }

        public final int e() {
            return ((Number) ZPlanMiniHomeGuidanceBubbleViewController.f331994i.getValue(this, f332001a[2])).intValue();
        }

        public final void f(long j3) {
            ZPlanMiniHomeGuidanceBubbleViewController.f331993h.setValue(this, f332001a[1], Long.valueOf(j3));
        }

        public final void g(boolean z16) {
            ZPlanMiniHomeGuidanceBubbleViewController.f331995j.setValue(this, f332001a[3], Boolean.valueOf(z16));
        }

        public final void h(long j3) {
            ZPlanMiniHomeGuidanceBubbleViewController.f331992g.setValue(this, f332001a[0], Long.valueOf(j3));
        }

        public final void i(int i3) {
            ZPlanMiniHomeGuidanceBubbleViewController.f331994i.setValue(this, f332001a[2], Integer.valueOf(i3));
        }

        Companion() {
        }

        public final void j() {
            i(3);
            f(604800000L);
            h(System.currentTimeMillis() + 86400000);
        }
    }

    static {
        QRouteApi api = QRoute.api(IZPlanMMKVApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanMMKVApi::class.java)");
        f331992g = t74.i.d((IZPlanMMKVApi) api, new Function0<String>() { // from class: com.tencent.mobileqq.zplan.bubble.ZPlanMiniHomeGuidanceBubbleViewController$Companion$mmkvNextShowAtMillis$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "ZPLAN_ZPlanMiniHomeGuidanceBubbleViewController_nextShowAtMillis_" + bb.f335811a.e();
            }
        }, 0L);
        QRouteApi api2 = QRoute.api(IZPlanMMKVApi.class);
        Intrinsics.checkNotNullExpressionValue(api2, "api(IZPlanMMKVApi::class.java)");
        f331993h = t74.i.d((IZPlanMMKVApi) api2, new Function0<String>() { // from class: com.tencent.mobileqq.zplan.bubble.ZPlanMiniHomeGuidanceBubbleViewController$Companion$mmkvDurationMillis$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "ZPLAN_ZPlanMiniHomeGuidanceBubbleViewController_durationMillis_" + bb.f335811a.e();
            }
        }, 604800000L);
        QRouteApi api3 = QRoute.api(IZPlanMMKVApi.class);
        Intrinsics.checkNotNullExpressionValue(api3, "api(IZPlanMMKVApi::class.java)");
        f331994i = t74.i.c((IZPlanMMKVApi) api3, new Function0<String>() { // from class: com.tencent.mobileqq.zplan.bubble.ZPlanMiniHomeGuidanceBubbleViewController$Companion$mmkvRestShowTimes$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "ZPLAN_ZPlanMiniHomeGuidanceBubbleViewController_restShowTimes_" + bb.f335811a.e();
            }
        }, 0);
        QRouteApi api4 = QRoute.api(IZPlanMMKVApi.class);
        Intrinsics.checkNotNullExpressionValue(api4, "api(IZPlanMMKVApi::class.java)");
        f331995j = t74.i.f((IZPlanMMKVApi) api4, new Function0<String>() { // from class: com.tencent.mobileqq.zplan.bubble.ZPlanMiniHomeGuidanceBubbleViewController$Companion$mmkvForceShow$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "ZPLAN_ZPlanMiniHomeGuidanceBubbleViewController_forceShow";
            }
        }, false);
    }

    public ZPlanMiniHomeGuidanceBubbleViewController(FrameLayout parent, int i3, int i16, ZPlanMiniHomeGuidanceBubbleInfo bubbleInfo) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(bubbleInfo, "bubbleInfo");
        this.parent = parent;
        this.parentWidthPx = i3;
        this.parentHeightPx = i16;
        this.bubbleInfo = bubbleInfo;
    }

    private final Context k() {
        return this.parent.getContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(ZPlanMiniHomeGuidanceBubbleViewController this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent();
        intent.putExtra("uin", MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin());
        QPublicFragmentActivity.start(this$0.k(), intent, CreateMiniHomeFragment.class);
    }

    @Override // com.tencent.mobileqq.zplan.bubble.c
    public void a(FrameLayout newParent) {
        Intrinsics.checkNotNullParameter(newParent, "newParent");
        FrameLayout frameLayout = this.parent;
        if (Intrinsics.areEqual(frameLayout, newParent)) {
            return;
        }
        TextView textView = this.bubbleView;
        if (textView != null) {
            frameLayout.removeView(textView);
            newParent.addView(textView);
        }
        this.parent = newParent;
    }

    @Override // com.tencent.mobileqq.zplan.bubble.c
    public boolean b(yi3.e newBubbleInfo) {
        Intrinsics.checkNotNullParameter(newBubbleInfo, "newBubbleInfo");
        if (!(newBubbleInfo instanceof ZPlanMiniHomeGuidanceBubbleInfo)) {
            return false;
        }
        this.bubbleInfo = (ZPlanMiniHomeGuidanceBubbleInfo) newBubbleInfo;
        return true;
    }

    @Override // com.tencent.mobileqq.zplan.bubble.c
    public Rect d() {
        Rect rect = new Rect();
        TextView textView = this.bubbleView;
        if (textView != null) {
            textView.getGlobalVisibleRect(rect);
        }
        return rect;
    }

    @Override // com.tencent.mobileqq.zplan.bubble.c
    /* renamed from: isClickable */
    public boolean getIsClickable() {
        return true;
    }

    @Override // com.tencent.mobileqq.zplan.bubble.c
    /* renamed from: j, reason: from getter and merged with bridge method [inline-methods] */
    public ZPlanMiniHomeGuidanceBubbleInfo getBubbleInfo() {
        return this.bubbleInfo;
    }

    @Override // com.tencent.mobileqq.zplan.bubble.c
    public void onCreate() {
        TextView textView = new TextView(k());
        textView.setBackground(AppCompatResources.getDrawable(k(), R.drawable.skin_aio_friend_bubble_nor));
        textView.setTextSize(1, 11.0f);
        textView.setTextColor(QQTheme.isNowThemeIsNight() ? -1 : -16777216);
        textView.setTextAlignment(4);
        textView.setGravity(17);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.bubble.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanMiniHomeGuidanceBubbleViewController.l(ZPlanMiniHomeGuidanceBubbleViewController.this, view);
            }
        });
        this.parent.addView(textView);
        this.bubbleView = textView;
    }

    @Override // com.tencent.mobileqq.zplan.bubble.c
    public void onDestroy() {
        this.parent.removeView(this.bubbleView);
        this.bubbleView = null;
    }

    @Override // com.tencent.mobileqq.zplan.bubble.c
    public void onHide() {
        TextView textView = this.bubbleView;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.zplan.bubble.c
    public void onShow() {
        TextView textView = this.bubbleView;
        if (textView == null) {
            return;
        }
        textView.setText("\u8bd5\u8bd5\u5f00\u542f\u8ff7\u4f60\u7a9d\u5427");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(UIUtil.dp2px(k(), 137.5f), UIUtil.dp2px(k(), 32.66f));
        layoutParams.gravity = 5;
        layoutParams.setMarginEnd((int) (this.parentWidthPx * 0.04f));
        layoutParams.topMargin = (int) (this.parentHeightPx * 0.5f);
        textView.setLayoutParams(layoutParams);
        textView.setVisibility(0);
    }

    @Override // com.tencent.mobileqq.zplan.bubble.c
    public void setOnClickListener(View.OnClickListener onClickListener) {
        c.a.a(this, onClickListener);
    }
}
