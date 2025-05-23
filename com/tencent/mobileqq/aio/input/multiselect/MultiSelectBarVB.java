package com.tencent.mobileqq.aio.input.multiselect;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.input.multiselect.MultiSelectUIState;
import com.tencent.mobileqq.aio.input.multiselect.d;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.nearbypro.profile.avatar.MyNearbyProBizScene;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.widget.SelectTouchBarView;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u0000 N2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005:\u0001OB\u0007\u00a2\u0006\u0004\bL\u0010MJ\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0002J\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0012H\u0002J\"\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\n2\b\b\u0002\u0010\u001c\u001a\u00020\u0012H\u0002J\u0010\u0010 \u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J \u0010$\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u0004H\u0002J\u0010\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0012H\u0002J\u0010\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0012H\u0002R\u0014\u0010+\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010-\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u001b\u00103\u001a\u00020.8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001b\u00108\u001a\u0002048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u00100\u001a\u0004\b6\u00107R\u001b\u0010;\u001a\u00020.8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u00100\u001a\u0004\b:\u00102R\u001b\u0010?\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b<\u00100\u001a\u0004\b=\u0010>R\u001b\u0010B\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b@\u00100\u001a\u0004\bA\u0010>R\u001b\u0010E\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bC\u00100\u001a\u0004\bD\u0010>R\u001b\u0010H\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bF\u00100\u001a\u0004\bG\u0010>R\u001b\u0010K\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bI\u00100\u001a\u0004\bJ\u0010>\u00a8\u0006P"}, d2 = {"Lcom/tencent/mobileqq/aio/input/multiselect/MultiSelectBarVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/mobileqq/aio/input/multiselect/d;", "Lcom/tencent/mobileqq/aio/input/multiselect/MultiSelectUIState;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/aio/input/multiselect/a;", "", "bindViewAndData", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "o1", "state", "z1", "v", NodeProps.ON_CLICK, "", "N", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "B1", "iconType", AdMetricTag.Report.TYPE, "A1", "Landroid/view/ViewGroup;", "parentView", "iconView", "iconIndex", "l1", "Landroid/content/Context;", "context", "p1", "iconId", "drawableId", "clkListener", ICustomDataEditor.NUMBER_PARAM_1, "count", Constants.BASE_IN_PLUGIN_ID, "type", "C1", "d", "I", "mIconSize", "e", "mIconPaddingSize", "Landroid/widget/LinearLayout;", "f", "Lkotlin/Lazy;", "v1", "()Landroid/widget/LinearLayout;", "mMultiButtonBar", "Lcom/tencent/qqnt/aio/widget/SelectTouchBarView;", h.F, "y1", "()Lcom/tencent/qqnt/aio/widget/SelectTouchBarView;", "mTouchBar", "i", "x1", "mOperationLayout", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "w1", "()Landroid/view/View;", "mMultiForwardBtn", BdhLogUtil.LogTag.Tag_Conn, "q1", "mDeleteBtn", "D", "u1", "mMoreBtn", "E", "r1", "mFavBtn", UserInfo.SEX_FEMALE, ICustomDataEditor.STRING_PARAM_1, "mLongShotBtn", "<init>", "()V", "G", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class MultiSelectBarVB extends com.tencent.aio.base.mvvm.a<d, MultiSelectUIState> implements View.OnClickListener, a {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy mDeleteBtn;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy mMoreBtn;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy mFavBtn;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy mLongShotBtn;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int mIconSize;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int mIconPaddingSize;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mMultiButtonBar;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mTouchBar;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mOperationLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mMultiForwardBtn;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/input/multiselect/MultiSelectBarVB$a;", "", "", "AI_SUMMARY", "I", MyNearbyProBizScene.CLICK, "DELETE", "ENDIMP", "FAVORITE", "IMP", "LONG_SHOT", "MORE", "MULTI_FORWARD", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.multiselect.MultiSelectBarVB$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56342);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public MultiSelectBarVB() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mIconSize = ViewUtils.dip2px(24.0f);
        this.mIconPaddingSize = ViewUtils.dpToPx(12.0f);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.aio.input.multiselect.MultiSelectBarVB$mMultiButtonBar$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MultiSelectBarVB.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LinearLayout invoke() {
                SelectTouchBarView y16;
                LinearLayout x16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (LinearLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                LinearLayout linearLayout = new LinearLayout(MultiSelectBarVB.this.getMContext());
                MultiSelectBarVB multiSelectBarVB = MultiSelectBarVB.this;
                linearLayout.setOrientation(1);
                linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, ViewUtils.dip2px(120.0f)));
                y16 = multiSelectBarVB.y1();
                linearLayout.addView(y16);
                x16 = multiSelectBarVB.x1();
                linearLayout.addView(x16);
                return linearLayout;
            }
        });
        this.mMultiButtonBar = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new MultiSelectBarVB$mTouchBar$2(this));
        this.mTouchBar = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.aio.input.multiselect.MultiSelectBarVB$mOperationLayout$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MultiSelectBarVB.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LinearLayout invoke() {
                View w16;
                View w17;
                View r16;
                View r17;
                View s16;
                View s17;
                View q16;
                View q17;
                View u16;
                View u17;
                View p16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (LinearLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                LinearLayout linearLayout = new LinearLayout(MultiSelectBarVB.this.getMContext());
                MultiSelectBarVB multiSelectBarVB = MultiSelectBarVB.this;
                linearLayout.setOrientation(0);
                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, ViewUtils.dip2px(60.0f)));
                linearLayout.setBackgroundColor(linearLayout.getResources().getColor(R.color.emoview_aio_emoji_bkg));
                w16 = multiSelectBarVB.w1();
                MultiSelectBarVB.m1(multiSelectBarVB, linearLayout, w16, 0, 4, null);
                w17 = multiSelectBarVB.w1();
                w17.setContentDescription(linearLayout.getResources().getString(R.string.f207635aj));
                multiSelectBarVB.A1(1, 1);
                r16 = multiSelectBarVB.r1();
                MultiSelectBarVB.m1(multiSelectBarVB, linearLayout, r16, 0, 4, null);
                r17 = multiSelectBarVB.r1();
                r17.setContentDescription(linearLayout.getResources().getString(R.string.f207585ae));
                multiSelectBarVB.A1(2, 1);
                s16 = multiSelectBarVB.s1();
                MultiSelectBarVB.m1(multiSelectBarVB, linearLayout, s16, 0, 4, null);
                s17 = multiSelectBarVB.s1();
                s17.setContentDescription(linearLayout.getResources().getString(R.string.f207445a1));
                multiSelectBarVB.A1(3, 1);
                q16 = multiSelectBarVB.q1();
                MultiSelectBarVB.m1(multiSelectBarVB, linearLayout, q16, 0, 4, null);
                q17 = multiSelectBarVB.q1();
                q17.setContentDescription(linearLayout.getResources().getString(R.string.f207525a9));
                multiSelectBarVB.A1(4, 1);
                u16 = multiSelectBarVB.u1();
                MultiSelectBarVB.m1(multiSelectBarVB, linearLayout, u16, 0, 4, null);
                u17 = multiSelectBarVB.u1();
                u17.setContentDescription(linearLayout.getResources().getString(R.string.f207745au));
                multiSelectBarVB.A1(5, 1);
                Context context = linearLayout.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                p16 = multiSelectBarVB.p1(context);
                linearLayout.addView(p16);
                linearLayout.setOnClickListener(multiSelectBarVB);
                return linearLayout;
            }
        });
        this.mOperationLayout = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.aio.input.multiselect.MultiSelectBarVB$mMultiForwardBtn$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MultiSelectBarVB.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                View n16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (View) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                MultiSelectBarVB multiSelectBarVB = MultiSelectBarVB.this;
                n16 = multiSelectBarVB.n1(R.id.awa, R.drawable.qui_share_light, multiSelectBarVB);
                return n16;
            }
        });
        this.mMultiForwardBtn = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.aio.input.multiselect.MultiSelectBarVB$mDeleteBtn$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MultiSelectBarVB.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                View n16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (View) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                MultiSelectBarVB multiSelectBarVB = MultiSelectBarVB.this;
                n16 = multiSelectBarVB.n1(R.id.aw9, R.drawable.qui_delete_light, multiSelectBarVB);
                return n16;
            }
        });
        this.mDeleteBtn = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.aio.input.multiselect.MultiSelectBarVB$mMoreBtn$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MultiSelectBarVB.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                View n16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (View) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                MultiSelectBarVB multiSelectBarVB = MultiSelectBarVB.this;
                n16 = multiSelectBarVB.n1(R.id.awc, R.drawable.qui_more_light, multiSelectBarVB);
                return n16;
            }
        });
        this.mMoreBtn = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.aio.input.multiselect.MultiSelectBarVB$mFavBtn$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MultiSelectBarVB.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                View n16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (View) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                MultiSelectBarVB multiSelectBarVB = MultiSelectBarVB.this;
                n16 = multiSelectBarVB.n1(R.id.aw_, R.drawable.qui_collection_light, multiSelectBarVB);
                return n16;
            }
        });
        this.mFavBtn = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.aio.input.multiselect.MultiSelectBarVB$mLongShotBtn$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MultiSelectBarVB.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                View n16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (View) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                MultiSelectBarVB multiSelectBarVB = MultiSelectBarVB.this;
                n16 = multiSelectBarVB.n1(R.id.awb, R.drawable.qui_long_screenshot_light, multiSelectBarVB);
                return n16;
            }
        });
        this.mLongShotBtn = lazy8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A1(int iconType, int reportType) {
        HashMap hashMap = new HashMap();
        hashMap.put("select_multiple_operation_items", Integer.valueOf(iconType));
        if (reportType != 1) {
            if (reportType != 2) {
                if (reportType == 3) {
                    com.tencent.mobileqq.aio.utils.b.l("em_bas_aio_multi_selection_operation", hashMap);
                    return;
                }
                return;
            }
            com.tencent.mobileqq.aio.utils.b.t("em_bas_aio_multi_selection_operation", hashMap);
            return;
        }
        com.tencent.mobileqq.aio.utils.b.q("em_bas_aio_multi_selection_operation", hashMap);
    }

    private final void B1() {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        y1().f();
        View w16 = w1();
        Intrinsics.checkNotNull(w16, "null cannot be cast to non-null type android.view.ViewGroup");
        View childAt = ((ViewGroup) w16).getChildAt(0);
        ImageView imageView5 = null;
        if (childAt instanceof ImageView) {
            imageView = (ImageView) childAt;
        } else {
            imageView = null;
        }
        if (imageView != null) {
            imageView.setImageDrawable(ContextCompat.getDrawable(getMContext(), R.drawable.qui_share_light));
        }
        View q16 = q1();
        Intrinsics.checkNotNull(q16, "null cannot be cast to non-null type android.view.ViewGroup");
        View childAt2 = ((ViewGroup) q16).getChildAt(0);
        if (childAt2 instanceof ImageView) {
            imageView2 = (ImageView) childAt2;
        } else {
            imageView2 = null;
        }
        if (imageView2 != null) {
            imageView2.setImageDrawable(ContextCompat.getDrawable(getMContext(), R.drawable.qui_delete_light));
        }
        View u16 = u1();
        Intrinsics.checkNotNull(u16, "null cannot be cast to non-null type android.view.ViewGroup");
        View childAt3 = ((ViewGroup) u16).getChildAt(0);
        if (childAt3 instanceof ImageView) {
            imageView3 = (ImageView) childAt3;
        } else {
            imageView3 = null;
        }
        if (imageView3 != null) {
            imageView3.setImageDrawable(ContextCompat.getDrawable(getMContext(), R.drawable.qui_more_light));
        }
        View r16 = r1();
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type android.view.ViewGroup");
        View childAt4 = ((ViewGroup) r16).getChildAt(0);
        if (childAt4 instanceof ImageView) {
            imageView4 = (ImageView) childAt4;
        } else {
            imageView4 = null;
        }
        if (imageView4 != null) {
            imageView4.setImageDrawable(ContextCompat.getDrawable(getMContext(), R.drawable.qui_collection_light));
        }
        View s16 = s1();
        Intrinsics.checkNotNull(s16, "null cannot be cast to non-null type android.view.ViewGroup");
        View childAt5 = ((ViewGroup) s16).getChildAt(0);
        if (childAt5 instanceof ImageView) {
            imageView5 = (ImageView) childAt5;
        }
        if (imageView5 != null) {
            imageView5.setImageDrawable(ContextCompat.getDrawable(getMContext(), R.drawable.qui_long_screenshot_light));
        }
    }

    private final void C1(int type) {
        int i3;
        int i16;
        ViewGroup.LayoutParams layoutParams;
        if (type == 2) {
            int childCount = x1().getChildCount();
            for (int i17 = 0; i17 < childCount; i17++) {
                View childAt = x1().getChildAt(i17);
                if (!Intrinsics.areEqual(childAt, q1()) && childAt != null) {
                    childAt.setVisibility(8);
                }
            }
            x1().setGravity(17);
            View q16 = q1();
            ViewGroup.LayoutParams layoutParams2 = q16.getLayoutParams();
            if (!(layoutParams2 instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams2 = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
            if (marginLayoutParams != null) {
                MarginLayoutParamsCompat.setMarginStart(marginLayoutParams, 0);
                layoutParams = marginLayoutParams;
            } else {
                ViewGroup.LayoutParams layoutParams3 = q16.getLayoutParams();
                if (layoutParams3 != null) {
                    i3 = layoutParams3.width;
                } else {
                    i3 = 0;
                }
                ViewGroup.LayoutParams layoutParams4 = q16.getLayoutParams();
                if (layoutParams4 != null) {
                    i16 = layoutParams4.height;
                } else {
                    i16 = 0;
                }
                Object[] objArr = {new ViewGroup.LayoutParams(i3, i16)};
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(objArr[0].getClass());
                Object[] array = arrayList.toArray(new Class[0]);
                if (array != null) {
                    Class[] clsArr = (Class[]) array;
                    Constructor it = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    it.setAccessible(true);
                    Object newInstance = it.newInstance(Arrays.copyOf(objArr, 1));
                    MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) newInstance, 0);
                    layoutParams = (ViewGroup.LayoutParams) newInstance;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            q16.setLayoutParams(layoutParams);
        }
    }

    private final void D1(int count) {
        if (count > 0) {
            y1().setVisibility(0);
            TextView textView = (TextView) y1().findViewById(R.id.l9j);
            if (textView != null) {
                textView.setText(getMContext().getResources().getString(R.string.f211635lc, Integer.valueOf(count)));
            }
            y1().g();
            y1().C = count;
            com.tencent.mobileqq.aio.utils.b.f194119a.p("em_bas_aio_multi_selection_selector");
            return;
        }
        y1().setVisibility(4);
        y1().C = 0;
        com.tencent.mobileqq.aio.utils.b.f194119a.s("em_bas_aio_multi_selection_selector");
    }

    private final void l1(ViewGroup parentView, View iconView, int iconIndex) {
        if (iconIndex >= 0) {
            Context context = iconView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "iconView.context");
            int i3 = iconIndex * 2;
            parentView.addView(p1(context), i3);
            parentView.addView(iconView, i3 + 1);
            return;
        }
        Context context2 = iconView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "iconView.context");
        parentView.addView(p1(context2));
        parentView.addView(iconView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void m1(MultiSelectBarVB multiSelectBarVB, ViewGroup viewGroup, View view, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = -1;
        }
        multiSelectBarVB.l1(viewGroup, view, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View n1(int iconId, int drawableId, View.OnClickListener clkListener) {
        ImageView imageView = new ImageView(getMContext());
        int i3 = this.mIconSize;
        imageView.setLayoutParams(new LinearLayout.LayoutParams(i3, i3));
        imageView.setImageResource(drawableId);
        FrameLayout frameLayout = new FrameLayout(getMContext());
        frameLayout.setId(iconId);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        frameLayout.setLayoutParams(layoutParams);
        int i16 = this.mIconPaddingSize;
        frameLayout.setPadding(i16, i16, i16, i16);
        frameLayout.addView(imageView);
        frameLayout.setOnClickListener(clkListener);
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View p1(Context context) {
        View view = new View(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, 0);
        layoutParams.weight = 1.0f;
        view.setLayoutParams(layoutParams);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View q1() {
        return (View) this.mDeleteBtn.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View r1() {
        return (View) this.mFavBtn.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View s1() {
        return (View) this.mLongShotBtn.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View u1() {
        return (View) this.mMoreBtn.getValue();
    }

    private final LinearLayout v1() {
        return (LinearLayout) this.mMultiButtonBar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View w1() {
        return (View) this.mMultiForwardBtn.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinearLayout x1() {
        return (LinearLayout) this.mOperationLayout.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SelectTouchBarView y1() {
        return (SelectTouchBarView) this.mTouchBar.getValue();
    }

    @Override // com.tencent.mobileqq.aio.input.multiselect.a
    public int N() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        int[] iArr = new int[2];
        y1().getLocationInWindow(iArr);
        View findViewById = y1().findViewById(R.id.l9i);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mTouchBar.findViewById(c\u2026_to_bottom_btn_container)");
        return iArr[1] + (((RelativeLayout) findViewById).getHeight() / 2);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.bindViewAndData();
        if (com.tencent.qqnt.aio.utils.multiForward.a.f352306a.b()) {
            x1().setBackground(ContextCompat.getDrawable(getMContext(), R.drawable.qui_common_bg_nav_bottom_aio_bg));
        } else {
            x1().setBackgroundColor(getMContext().getColor(R.color.emoview_aio_emoji_bkg));
        }
        B1();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: o1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<d, MultiSelectUIState> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.aio.base.mvvm.b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new c(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) v3);
        } else {
            Intrinsics.checkNotNullParameter(v3, "v");
            int id5 = v3.getId();
            if (id5 == R.id.awa) {
                sendIntent(d.C7277d.f189774d);
                A1(1, 3);
            } else if (id5 == R.id.awb) {
                sendIntent(d.a.f189771d);
                A1(3, 3);
            } else if (id5 == R.id.aw9) {
                sendIntent(d.b.f189772d);
                A1(4, 3);
            } else if (id5 == R.id.aw_) {
                sendIntent(d.c.f189773d);
                A1(2, 3);
            } else if (id5 == R.id.awc) {
                sendIntent(d.e.f189775d);
                A1(5, 3);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        return v1();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onDestroy();
        A1(1, 2);
        A1(3, 2);
        A1(4, 2);
        A1(2, 2);
        A1(5, 2);
        SelectTouchBarView y16 = y1();
        if (y16.C != 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("selection_bars_number", Integer.valueOf(y16.C));
            com.tencent.mobileqq.aio.utils.b.t("em_bas_aio_multi_selection_selector", hashMap);
        }
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: z1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull MultiSelectUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof MultiSelectUIState.UpdateSelectCount) {
            D1(((MultiSelectUIState.UpdateSelectCount) state).a());
        } else if (state instanceof MultiSelectUIState.UpdateOperation) {
            C1(((MultiSelectUIState.UpdateOperation) state).a());
        } else if (state instanceof MultiSelectUIState.SetTouchBarVisibility) {
            y1().setVisibility(((MultiSelectUIState.SetTouchBarVisibility) state).a());
        }
    }
}
