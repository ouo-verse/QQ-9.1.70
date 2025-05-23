package com.tencent.mobileqq.guild.discoveryv2.parts;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.discoveryv2.widget.GuildDiscoveryTabBar;
import com.tencent.mobileqq.guild.widget.ClippableConstraintLayout;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/parts/k;", "Lcom/tencent/biz/richframework/part/Part;", "com/tencent/mobileqq/guild/discoveryv2/parts/k$b", "A9", "()Lcom/tencent/mobileqq/guild/discoveryv2/parts/k$b;", "Landroid/view/View;", "view", "", "B9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lcom/tencent/mobileqq/guild/widget/ClippableConstraintLayout;", "d", "Lcom/tencent/mobileqq/guild/widget/ClippableConstraintLayout;", "rootLayout", "Lcom/tencent/mobileqq/guild/discoveryv2/widget/GuildDiscoveryTabBar;", "e", "Lcom/tencent/mobileqq/guild/discoveryv2/widget/GuildDiscoveryTabBar;", "viewTab", "f", "Lcom/tencent/mobileqq/guild/discoveryv2/parts/k$b;", "touchEventListener", "<init>", "()V", tl.h.F, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class k extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ClippableConstraintLayout rootLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private GuildDiscoveryTabBar viewTab;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b touchEventListener = A9();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/parts/k$b", "Lcom/tencent/mobileqq/guild/widget/ClippableConstraintLayout$b;", "Landroid/view/MotionEvent;", "ev", "", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "onDispatchTouchEvent", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements ClippableConstraintLayout.b {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.widget.ClippableConstraintLayout.b
        public void onDispatchTouchEvent(@Nullable MotionEvent ev5) {
            Integer num;
            if (ev5 != null) {
                num = Integer.valueOf(ev5.getAction());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == 1) {
                ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).setDrawerFrameEnable(true);
            }
        }

        @Override // com.tencent.mobileqq.guild.widget.ClippableConstraintLayout.b
        public void onInterceptTouchEvent(@Nullable MotionEvent ev5) {
            Integer num;
            GuildDiscoveryTabBar guildDiscoveryTabBar = null;
            if (ev5 != null) {
                num = Integer.valueOf(ev5.getAction());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == 0) {
                k kVar = k.this;
                GuildDiscoveryTabBar guildDiscoveryTabBar2 = kVar.viewTab;
                if (guildDiscoveryTabBar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewTab");
                    guildDiscoveryTabBar2 = null;
                }
                int B9 = kVar.B9(guildDiscoveryTabBar2);
                GuildDiscoveryTabBar guildDiscoveryTabBar3 = k.this.viewTab;
                if (guildDiscoveryTabBar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewTab");
                    guildDiscoveryTabBar3 = null;
                }
                if (ev5.getY() > guildDiscoveryTabBar3.getMeasuredHeight() + B9) {
                    GuildDiscoveryTabBar guildDiscoveryTabBar4 = k.this.viewTab;
                    if (guildDiscoveryTabBar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewTab");
                    } else {
                        guildDiscoveryTabBar = guildDiscoveryTabBar4;
                    }
                    if (guildDiscoveryTabBar.getCurrentPosition() == 0) {
                        ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).setDrawerFrameEnable(true);
                        return;
                    } else {
                        ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).setDrawerFrameEnable(false);
                        return;
                    }
                }
                if (ev5.getY() > B9) {
                    GuildDiscoveryTabBar guildDiscoveryTabBar5 = k.this.viewTab;
                    if (guildDiscoveryTabBar5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewTab");
                    } else {
                        guildDiscoveryTabBar = guildDiscoveryTabBar5;
                    }
                    if (guildDiscoveryTabBar.getScrollX() == 0) {
                        ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).setDrawerFrameEnable(true);
                        return;
                    } else {
                        ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).setDrawerFrameEnable(false);
                        return;
                    }
                }
                ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).setDrawerFrameEnable(true);
                return;
            }
            if (num != null && num.intValue() == 1) {
                ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).setDrawerFrameEnable(true);
            }
        }
    }

    private final b A9() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int B9(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        ClippableConstraintLayout clippableConstraintLayout = this.rootLayout;
        if (clippableConstraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
            clippableConstraintLayout = null;
        }
        clippableConstraintLayout.getLocationOnScreen(iArr2);
        return iArr[1] - iArr2[1];
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.rootLayout = (ClippableConstraintLayout) rootView;
        View findViewById = rootView.findViewById(R.id.x1n);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.guild_tab)");
        this.viewTab = (GuildDiscoveryTabBar) findViewById;
        ClippableConstraintLayout clippableConstraintLayout = this.rootLayout;
        if (clippableConstraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
            clippableConstraintLayout = null;
        }
        clippableConstraintLayout.setTouchEventListener(this.touchEventListener);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        ClippableConstraintLayout clippableConstraintLayout = this.rootLayout;
        if (clippableConstraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootLayout");
            clippableConstraintLayout = null;
        }
        clippableConstraintLayout.setTouchEventListener(null);
    }
}
