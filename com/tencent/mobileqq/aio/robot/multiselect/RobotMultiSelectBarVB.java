package com.tencent.mobileqq.aio.robot.multiselect;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
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
import com.tencent.mobileqq.aio.robot.multiselect.RobotMultiSelectUIState;
import com.tencent.mobileqq.aio.robot.multiselect.c;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
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
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 O2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005:\u0001PB\u0007\u00a2\u0006\u0004\bM\u0010NJ\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J\"\u0010\u0011\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\bH\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J(\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\bH\u0002J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\bH\u0002J\b\u0010\u001f\u001a\u00020\u0006H\u0016J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010!\u001a\u00020 H\u0016J\u0014\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030#H\u0016J\u0010\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0003H\u0016J\u0010\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0014H\u0016J\b\u0010)\u001a\u00020\bH\u0016J\b\u0010*\u001a\u00020\u0006H\u0016R\u0014\u0010-\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010/\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0014\u00101\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010,R\u001b\u00107\u001a\u0002028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001b\u0010<\u001a\u0002088BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u00104\u001a\u0004\b:\u0010;R\u001b\u0010?\u001a\u0002028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u00104\u001a\u0004\b>\u00106R\u001b\u0010C\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b@\u00104\u001a\u0004\bA\u0010BR\u001b\u0010F\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bD\u00104\u001a\u0004\bE\u0010BR\u001b\u0010I\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bG\u00104\u001a\u0004\bH\u0010BR\u001b\u0010L\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bJ\u00104\u001a\u0004\bK\u0010B\u00a8\u0006Q"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/multiselect/RobotMultiSelectBarVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/mobileqq/aio/robot/multiselect/c;", "Lcom/tencent/mobileqq/aio/robot/multiselect/RobotMultiSelectUIState;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/aio/input/multiselect/a;", "", "C1", "", "iconType", AdMetricTag.Report.TYPE, "B1", "Landroid/view/ViewGroup;", "parentView", "Lcom/tencent/mobileqq/aio/robot/multiselect/SelectBarItem;", "barItem", "iconIndex", ICustomDataEditor.NUMBER_PARAM_1, "Landroid/content/Context;", "context", "Landroid/view/View;", "r1", "iconId", "drawableId", "stringId", "clkListener", "p1", "count", "E1", "type", Constants.BASE_IN_PLUGIN_ID, "bindViewAndData", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "q1", "state", "A1", "v", NodeProps.ON_CLICK, "N", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "I", "MULTI_BUTTON_BAR_HEIGHT", "e", "TOUCH_BAR_HEIGHT", "f", "OPERATION_HEIGHT", "Landroid/widget/LinearLayout;", h.F, "Lkotlin/Lazy;", "v1", "()Landroid/widget/LinearLayout;", "mMultiButtonBar", "Lcom/tencent/qqnt/aio/widget/SelectTouchBarView;", "i", "z1", "()Lcom/tencent/qqnt/aio/widget/SelectTouchBarView;", "mTouchBar", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "x1", "mOperationLayout", BdhLogUtil.LogTag.Tag_Conn, "w1", "()Lcom/tencent/mobileqq/aio/robot/multiselect/SelectBarItem;", "mMultiForwardBtn", "D", ICustomDataEditor.STRING_PARAM_1, "mDeleteBtn", "E", "u1", "mFavBtn", UserInfo.SEX_FEMALE, "y1", "mReportBtn", "<init>", "()V", "G", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class RobotMultiSelectBarVB extends com.tencent.aio.base.mvvm.a<c, RobotMultiSelectUIState> implements View.OnClickListener, com.tencent.mobileqq.aio.input.multiselect.a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy mMultiForwardBtn;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy mDeleteBtn;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy mFavBtn;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy mReportBtn;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int MULTI_BUTTON_BAR_HEIGHT;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int TOUCH_BAR_HEIGHT;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int OPERATION_HEIGHT;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mMultiButtonBar;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mTouchBar;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mOperationLayout;

    public RobotMultiSelectBarVB() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        int dip2px = ViewUtils.dip2px(123.0f);
        this.MULTI_BUTTON_BAR_HEIGHT = dip2px;
        int dip2px2 = ViewUtils.dip2px(60.0f);
        this.TOUCH_BAR_HEIGHT = dip2px2;
        this.OPERATION_HEIGHT = dip2px - dip2px2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.aio.robot.multiselect.RobotMultiSelectBarVB$mMultiButtonBar$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LinearLayout invoke() {
                int i3;
                SelectTouchBarView z16;
                LinearLayout x16;
                LinearLayout linearLayout = new LinearLayout(RobotMultiSelectBarVB.this.getMContext());
                RobotMultiSelectBarVB robotMultiSelectBarVB = RobotMultiSelectBarVB.this;
                linearLayout.setOrientation(1);
                i3 = robotMultiSelectBarVB.MULTI_BUTTON_BAR_HEIGHT;
                linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, i3));
                z16 = robotMultiSelectBarVB.z1();
                linearLayout.addView(z16);
                x16 = robotMultiSelectBarVB.x1();
                linearLayout.addView(x16);
                return linearLayout;
            }
        });
        this.mMultiButtonBar = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new RobotMultiSelectBarVB$mTouchBar$2(this));
        this.mTouchBar = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.aio.robot.multiselect.RobotMultiSelectBarVB$mOperationLayout$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LinearLayout invoke() {
                int i3;
                SelectBarItem w16;
                SelectBarItem u16;
                SelectBarItem s16;
                SelectBarItem y16;
                View r16;
                LinearLayout linearLayout = new LinearLayout(RobotMultiSelectBarVB.this.getMContext());
                RobotMultiSelectBarVB robotMultiSelectBarVB = RobotMultiSelectBarVB.this;
                linearLayout.setOrientation(0);
                i3 = robotMultiSelectBarVB.OPERATION_HEIGHT;
                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, i3));
                linearLayout.setPadding(0, ViewUtils.dip2px(8.0f), 0, 0);
                linearLayout.setGravity(48);
                linearLayout.setBackgroundColor(linearLayout.getResources().getColor(R.color.emoview_aio_emoji_bkg));
                w16 = robotMultiSelectBarVB.w1();
                RobotMultiSelectBarVB.o1(robotMultiSelectBarVB, linearLayout, w16, 0, 4, null);
                robotMultiSelectBarVB.B1(1, 1);
                u16 = robotMultiSelectBarVB.u1();
                RobotMultiSelectBarVB.o1(robotMultiSelectBarVB, linearLayout, u16, 0, 4, null);
                robotMultiSelectBarVB.B1(2, 1);
                s16 = robotMultiSelectBarVB.s1();
                RobotMultiSelectBarVB.o1(robotMultiSelectBarVB, linearLayout, s16, 0, 4, null);
                robotMultiSelectBarVB.B1(3, 1);
                y16 = robotMultiSelectBarVB.y1();
                RobotMultiSelectBarVB.o1(robotMultiSelectBarVB, linearLayout, y16, 0, 4, null);
                robotMultiSelectBarVB.B1(4, 1);
                Context context = linearLayout.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                r16 = robotMultiSelectBarVB.r1(context);
                linearLayout.addView(r16);
                linearLayout.setOnClickListener(robotMultiSelectBarVB);
                return linearLayout;
            }
        });
        this.mOperationLayout = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<SelectBarItem>() { // from class: com.tencent.mobileqq.aio.robot.multiselect.RobotMultiSelectBarVB$mMultiForwardBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SelectBarItem invoke() {
                SelectBarItem p16;
                RobotMultiSelectBarVB robotMultiSelectBarVB = RobotMultiSelectBarVB.this;
                p16 = robotMultiSelectBarVB.p1(R.id.awa, R.drawable.qui_share_light, R.string.f227426r0, robotMultiSelectBarVB);
                return p16;
            }
        });
        this.mMultiForwardBtn = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<SelectBarItem>() { // from class: com.tencent.mobileqq.aio.robot.multiselect.RobotMultiSelectBarVB$mDeleteBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SelectBarItem invoke() {
                SelectBarItem p16;
                RobotMultiSelectBarVB robotMultiSelectBarVB = RobotMultiSelectBarVB.this;
                p16 = robotMultiSelectBarVB.p1(R.id.aw9, R.drawable.qui_delete_light, R.string.f207525a9, robotMultiSelectBarVB);
                return p16;
            }
        });
        this.mDeleteBtn = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<SelectBarItem>() { // from class: com.tencent.mobileqq.aio.robot.multiselect.RobotMultiSelectBarVB$mFavBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SelectBarItem invoke() {
                SelectBarItem p16;
                RobotMultiSelectBarVB robotMultiSelectBarVB = RobotMultiSelectBarVB.this;
                p16 = robotMultiSelectBarVB.p1(R.id.aw_, R.drawable.qui_collection_light, R.string.f207585ae, robotMultiSelectBarVB);
                return p16;
            }
        });
        this.mFavBtn = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<SelectBarItem>() { // from class: com.tencent.mobileqq.aio.robot.multiselect.RobotMultiSelectBarVB$mReportBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SelectBarItem invoke() {
                SelectBarItem p16;
                RobotMultiSelectBarVB robotMultiSelectBarVB = RobotMultiSelectBarVB.this;
                p16 = robotMultiSelectBarVB.p1(R.id.f83254j2, R.drawable.qui_complaint_light, R.string.f223046f6, robotMultiSelectBarVB);
                return p16;
            }
        });
        this.mReportBtn = lazy7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B1(int iconType, int reportType) {
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

    private final void C1() {
        z1().f();
        w1().getImageView().setImageDrawable(ContextCompat.getDrawable(getMContext(), R.drawable.qui_share_light));
        s1().getImageView().setImageDrawable(ContextCompat.getDrawable(getMContext(), R.drawable.qui_delete_light));
        u1().getImageView().setImageDrawable(ContextCompat.getDrawable(getMContext(), R.drawable.qui_collection_light));
        y1().getImageView().setImageDrawable(ContextCompat.getDrawable(getMContext(), R.drawable.qui_complaint_light));
    }

    private final void D1(int type) {
        int i3;
        int i16;
        ViewGroup.LayoutParams layoutParams;
        if (type == 2) {
            int childCount = x1().getChildCount();
            for (int i17 = 0; i17 < childCount; i17++) {
                View childAt = x1().getChildAt(i17);
                if (!Intrinsics.areEqual(childAt, s1()) && childAt != null) {
                    childAt.setVisibility(8);
                }
            }
            SelectBarItem s16 = s1();
            ViewGroup.LayoutParams layoutParams2 = s16.getLayoutParams();
            if (!(layoutParams2 instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams2 = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
            if (marginLayoutParams != null) {
                MarginLayoutParamsCompat.setMarginStart(marginLayoutParams, 0);
                layoutParams = marginLayoutParams;
            } else {
                ViewGroup.LayoutParams layoutParams3 = s16.getLayoutParams();
                if (layoutParams3 != null) {
                    i3 = layoutParams3.width;
                } else {
                    i3 = 0;
                }
                ViewGroup.LayoutParams layoutParams4 = s16.getLayoutParams();
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
            s16.setLayoutParams(layoutParams);
        }
    }

    private final void E1(int count) {
        boolean z16 = true;
        if (count > 0) {
            z1().setVisibility(0);
            TextView textView = (TextView) z1().findViewById(R.id.l9j);
            if (textView != null) {
                textView.setText(getMContext().getResources().getString(R.string.f211635lc, Integer.valueOf(count)));
            }
            z1().g();
            z1().C = count;
            com.tencent.mobileqq.aio.utils.b.f194119a.p("em_bas_aio_multi_selection_selector");
        } else {
            z1().setVisibility(4);
            z1().C = 0;
            com.tencent.mobileqq.aio.utils.b.f194119a.s("em_bas_aio_multi_selection_selector");
        }
        if (count <= 0) {
            z16 = false;
        }
        w1().setClickEnable(z16);
        s1().setClickEnable(z16);
        u1().setClickEnable(z16);
        y1().setClickEnable(z16);
    }

    private final void n1(ViewGroup parentView, SelectBarItem barItem, int iconIndex) {
        Context context = parentView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parentView.context");
        View r16 = r1(context);
        if (iconIndex >= 0) {
            int i3 = iconIndex * 2;
            parentView.addView(r16, i3);
            parentView.addView(barItem, i3 + 1);
        } else {
            parentView.addView(r16);
            parentView.addView(barItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void o1(RobotMultiSelectBarVB robotMultiSelectBarVB, ViewGroup viewGroup, SelectBarItem selectBarItem, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = -1;
        }
        robotMultiSelectBarVB.n1(viewGroup, selectBarItem, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SelectBarItem p1(int iconId, int drawableId, int stringId, View.OnClickListener clkListener) {
        SelectBarItem selectBarItem = new SelectBarItem(getMContext(), null, 0, 6, null);
        selectBarItem.setId(iconId);
        selectBarItem.setImage(drawableId);
        String string = selectBarItem.getResources().getString(stringId);
        Intrinsics.checkNotNullExpressionValue(string, "item.resources.getString(stringId)");
        selectBarItem.setOnClickListener(clkListener);
        selectBarItem.setContentDescription(string);
        return selectBarItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View r1(Context context) {
        View view = new View(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, 0);
        layoutParams.weight = 1.0f;
        view.setLayoutParams(layoutParams);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SelectBarItem s1() {
        return (SelectBarItem) this.mDeleteBtn.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SelectBarItem u1() {
        return (SelectBarItem) this.mFavBtn.getValue();
    }

    private final LinearLayout v1() {
        return (LinearLayout) this.mMultiButtonBar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SelectBarItem w1() {
        return (SelectBarItem) this.mMultiForwardBtn.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinearLayout x1() {
        return (LinearLayout) this.mOperationLayout.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SelectBarItem y1() {
        return (SelectBarItem) this.mReportBtn.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SelectTouchBarView z1() {
        return (SelectTouchBarView) this.mTouchBar.getValue();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: A1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull RobotMultiSelectUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof RobotMultiSelectUIState.UpdateSelectCount) {
            E1(((RobotMultiSelectUIState.UpdateSelectCount) state).getCount());
        } else if (state instanceof RobotMultiSelectUIState.UpdateOperation) {
            D1(((RobotMultiSelectUIState.UpdateOperation) state).getType());
        } else if (state instanceof RobotMultiSelectUIState.SetTouchBarVisibility) {
            z1().setVisibility(((RobotMultiSelectUIState.SetTouchBarVisibility) state).getVisibility());
        }
    }

    @Override // com.tencent.mobileqq.aio.input.multiselect.a
    public int N() {
        int[] iArr = new int[2];
        z1().getLocationInWindow(iArr);
        View findViewById = z1().findViewById(R.id.l9i);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mTouchBar.findViewById(R\u2026_to_bottom_btn_container)");
        return iArr[1] + (((RelativeLayout) findViewById).getHeight() / 2);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        if (com.tencent.qqnt.aio.utils.multiForward.a.f352306a.b()) {
            x1().setBackground(ContextCompat.getDrawable(getMContext(), R.drawable.qui_common_bg_nav_bottom_aio_bg));
        } else {
            x1().setBackgroundColor(getMContext().getColor(R.color.emoview_aio_emoji_bkg));
        }
        C1();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        int id5 = v3.getId();
        if (id5 == R.id.awa) {
            sendIntent(c.d.f193576d);
            B1(1, 3);
        } else if (id5 == R.id.aw9) {
            sendIntent(c.a.f193573d);
            B1(3, 3);
        } else if (id5 == R.id.aw_) {
            sendIntent(c.b.f193574d);
            B1(2, 3);
        } else if (id5 == R.id.f83254j2) {
            sendIntent(c.C7356c.f193575d);
            B1(4, 3);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        return v1();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        super.onDestroy();
        B1(1, 2);
        B1(3, 2);
        B1(2, 2);
        SelectTouchBarView z16 = z1();
        if (z16.C != 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("selection_bars_number", Integer.valueOf(z16.C));
            com.tencent.mobileqq.aio.utils.b.t("em_bas_aio_multi_selection_selector", hashMap);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: q1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<c, RobotMultiSelectUIState> createVM() {
        return new b(this);
    }
}
