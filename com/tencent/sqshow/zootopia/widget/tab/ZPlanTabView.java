package com.tencent.sqshow.zootopia.widget.tab;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewpager.widget.ViewPager;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.usercenter.friend.data.FollowStateChangedEvent;
import com.tencent.sqshow.zootopia.utils.q;
import com.tencent.sqshow.zootopia.widget.tab.ZPlanTabTitleData;
import com.tencent.sqshow.zootopia.widget.tab.ZPlanTabView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000\u00b8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010!\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0005\u0086\u0001\u0087\u0001\u001aB\u0015\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001B!\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0083\u0001\u00a2\u0006\u0006\b\u0081\u0001\u0010\u0085\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0006\u0010\u0015\u001a\u00020\u0004J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0014J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0018H\u0004J\u0010\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u0006\u0010\u001e\u001a\u00020\u0004J \u0010!\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0004J\u0010\u0010$\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\"J\u0014\u0010'\u001a\u00020\u00042\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00180%J\u0006\u0010(\u001a\u00020\u0004J\u000e\u0010)\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000eJ\u0016\u0010)\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u0012J \u0010,\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u0012H\u0004J\u0010\u0010.\u001a\u00020-2\u0006\u0010\u0017\u001a\u00020\u000eH\u0004J\u000e\u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020/J\u000e\u00103\u001a\u00020\u00042\u0006\u00100\u001a\u000202J\u0010\u00106\u001a\u00020\u00122\u0006\u00105\u001a\u000204H\u0016J\u0010\u00107\u001a\u00020\u00122\u0006\u00105\u001a\u000204H\u0016J\b\u00108\u001a\u00020\u0004H\u0014J\b\u00109\u001a\u00020\u0004H\u0014J\u0012\u0010;\u001a\u00020\u00042\b\u0010:\u001a\u0004\u0018\u00010\u0003H\u0016J(\u0010?\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030=\u0018\u00010<j\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030=\u0018\u0001`>H\u0016R\u0014\u0010B\u001a\u00020@8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\n\u0010AR\u0014\u0010E\u001a\u00020\u000e8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010F\u001a\u00020\u000e8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\r\u0010DR\u0014\u0010G\u001a\u00020\u000e8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b.\u0010DR\u0014\u0010H\u001a\u00020\u000e8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0015\u0010DR\u0014\u0010I\u001a\u00020\u000e8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b(\u0010DR\u0014\u0010K\u001a\u00020\u000e8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bJ\u0010DR\u0014\u0010M\u001a\u00020\u000e8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bL\u0010DR\u0018\u0010P\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010R\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010DR\u0016\u0010T\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010DR\u0016\u0010V\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010DR\u001c\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00180W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010XR\u0016\u0010[\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010DR\u0016\u0010]\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010DR\u0016\u0010_\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010DR\u0016\u0010a\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010DR\"\u0010h\u001a\u00020\u00128\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u0018\u0010k\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010m\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010cR\u0016\u0010q\u001a\u00020n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010pR\"\u0010y\u001a\u00020r8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bs\u0010t\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\u0018\u0010|\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010{R\u0015\u0010\u0080\u0001\u001a\u00020}8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b~\u0010\u007f\u00a8\u0006\u0088\u0001"}, d2 = {"Lcom/tencent/sqshow/zootopia/widget/tab/ZPlanTabView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "l", "Landroid/content/Context;", "context", "j", "k", "d", "Landroid/graphics/Canvas;", PM.CANVAS, "f", "", "g", "currentPos", "r", "", "isAdd", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "i", "onDraw", "position", "Lcom/tencent/sqshow/zootopia/widget/tab/ZPlanTabTitleData;", "titleData", "c", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "setViewPager", "setNeedTabCount", "Landroid/view/View;", "tab", "o", "Lcom/tencent/sqshow/zootopia/widget/tab/ZPlanTabView$b;", "onCurrentTabClickListener", "setOnCurrentTabClickListener", "", "titleList", "setTabData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setCurrentPosition", "animUnderline", "fromUserClick", DomainData.DOMAIN_NAME, "", h.F, "Lcom/tencent/sqshow/zootopia/widget/tab/ZPlanTabView$c;", "listener", "setTabChangeListener", "Lcom/tencent/sqshow/zootopia/widget/tab/ZPlanTabView$a;", "setInterceptListener", "Landroid/view/MotionEvent;", "ev", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "onTouchEvent", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "", "Ljava/lang/String;", "TAG", "e", "I", "MIN_MARGIN_HORIZONTAL", "UNDERLINE_MARGIN_TOP", "UNDERLINE_HEIGHT", "UNDERLINE_MARGIN", "ANIMATION_DURATION", BdhLogUtil.LogTag.Tag_Conn, "TAB_TEXT_SIZE", "D", "TAB_MARK_SIZE", "E", "Landroid/widget/LinearLayout;", "mTabContainer", UserInfo.SEX_FEMALE, "mTabCount", "G", "mCurrentPosition", "H", "mPrePosition", "", "Ljava/util/List;", "mTabTexts", "J", "mCheckedTextColor", "K", "mUncheckedTextColor", "L", "mMinTabMargin", "M", "mAnimationStartX", "N", "Z", "getMIsAnim", "()Z", "setMIsAnim", "(Z)V", "mIsAnim", "P", "Landroidx/viewpager/widget/ViewPager;", "mViewPager", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "needTabCount", "Landroid/graphics/Paint;", BdhLogUtil.LogTag.Tag_Req, "Landroid/graphics/Paint;", "mPaint", "Landroid/graphics/RectF;", ExifInterface.LATITUDE_SOUTH, "Landroid/graphics/RectF;", "getMRect", "()Landroid/graphics/RectF;", "setMRect", "(Landroid/graphics/RectF;)V", "mRect", "T", "Lcom/tencent/sqshow/zootopia/widget/tab/ZPlanTabView$b;", "mOnCurrentTabClickListener", "Lid3/d;", "U", "Lid3/d;", "dtReporter", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanTabView extends LinearLayout implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    private final int TAB_TEXT_SIZE;

    /* renamed from: D, reason: from kotlin metadata */
    private final int TAB_MARK_SIZE;

    /* renamed from: E, reason: from kotlin metadata */
    private LinearLayout mTabContainer;

    /* renamed from: F, reason: from kotlin metadata */
    private int mTabCount;

    /* renamed from: G, reason: from kotlin metadata */
    private int mCurrentPosition;

    /* renamed from: H, reason: from kotlin metadata */
    private int mPrePosition;

    /* renamed from: I, reason: from kotlin metadata */
    private List<ZPlanTabTitleData> mTabTexts;

    /* renamed from: J, reason: from kotlin metadata */
    private int mCheckedTextColor;

    /* renamed from: K, reason: from kotlin metadata */
    private int mUncheckedTextColor;

    /* renamed from: L, reason: from kotlin metadata */
    private int mMinTabMargin;

    /* renamed from: M, reason: from kotlin metadata */
    private int mAnimationStartX;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean mIsAnim;

    /* renamed from: P, reason: from kotlin metadata */
    private ViewPager mViewPager;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean needTabCount;

    /* renamed from: R, reason: from kotlin metadata */
    private Paint mPaint;

    /* renamed from: S, reason: from kotlin metadata */
    private RectF mRect;

    /* renamed from: T, reason: from kotlin metadata */
    private b mOnCurrentTabClickListener;

    /* renamed from: U, reason: from kotlin metadata */
    private final id3.d dtReporter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String TAG;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int MIN_MARGIN_HORIZONTAL;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int UNDERLINE_MARGIN_TOP;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int UNDERLINE_HEIGHT;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int UNDERLINE_MARGIN;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int ANIMATION_DURATION;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/sqshow/zootopia/widget/tab/ZPlanTabView$a;", "", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface a {
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/sqshow/zootopia/widget/tab/ZPlanTabView$b;", "", "", "current", "Landroid/view/View;", "tab", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface b {
        void a(int current, View tab);
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/sqshow/zootopia/widget/tab/ZPlanTabView$c;", "", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface c {
    }

    public ZPlanTabView(Context context) {
        super(context);
        this.TAG = "QUIPageTabBar";
        this.MIN_MARGIN_HORIZONTAL = 21;
        this.UNDERLINE_MARGIN_TOP = 5;
        this.UNDERLINE_HEIGHT = 2;
        this.UNDERLINE_MARGIN = 13;
        this.ANIMATION_DURATION = 200;
        this.TAB_TEXT_SIZE = 16;
        this.TAB_MARK_SIZE = 10;
        this.mTabTexts = new ArrayList();
        this.mPaint = new Paint();
        this.mRect = new RectF();
        this.dtReporter = new id3.d(null, 1, null);
        i();
    }

    private final void d() {
        int i3 = this.mPrePosition;
        int i16 = this.mCurrentPosition;
        if (i3 != i16) {
            int i17 = h(i3)[0];
            final int i18 = h(this.mCurrentPosition)[0];
            ValueAnimator ofInt = ValueAnimator.ofInt(i17, i18);
            ofInt.setDuration(this.ANIMATION_DURATION);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: vc4.j
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ZPlanTabView.e(ZPlanTabView.this, i18, valueAnimator);
                }
            });
            ofInt.start();
            this.mIsAnim = true;
            return;
        }
        this.mAnimationStartX = h(i16)[0];
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(ZPlanTabView this$0, int i3, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        this$0.mAnimationStartX = intValue;
        if (intValue == i3) {
            this$0.mIsAnim = false;
        }
        this$0.invalidate();
    }

    private final void f(Canvas canvas) {
        int i3;
        int[] h16 = h(this.mCurrentPosition);
        int i16 = h16[2];
        int i17 = h16[0];
        int i18 = i16 - i17;
        if (this.mIsAnim && (i3 = this.mAnimationStartX) > 0) {
            i17 = i3;
        }
        this.mRect.set(i17, h16[1], i18 + i17, h16[3]);
        canvas.drawRect(this.mRect, this.mPaint);
    }

    private final int g() {
        return h(this.mCurrentPosition)[0];
    }

    private final void j(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        this.mTabContainer = linearLayout;
        linearLayout.setOrientation(0);
        LinearLayout linearLayout2 = this.mTabContainer;
        if (linearLayout2 != null) {
            linearLayout2.setBackgroundColor(0);
        }
        addView(this.mTabContainer, new LinearLayout.LayoutParams(-1, -1));
    }

    private final void k() {
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setTextSize(ViewUtils.dip2px(this.TAB_TEXT_SIZE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(ZPlanTabTitleData titleData, ZPlanTabView this$0, View tab, int i3, View view) {
        Unit unit;
        b bVar;
        Intrinsics.checkNotNullParameter(titleData, "$titleData");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tab, "$tab");
        HashMap hashMap = new HashMap();
        hashMap.put("zplan_tab_id", titleData.getId());
        hashMap.put("zplan_tab_name", titleData.getTitle());
        this$0.dtReporter.c("clck", tab, hashMap);
        int i16 = this$0.mCurrentPosition;
        if (i16 == i3 && i16 >= 0 && (bVar = this$0.mOnCurrentTabClickListener) != null && bVar != null) {
            bVar.a(i3, tab);
        }
        ViewPager viewPager = this$0.mViewPager;
        if (viewPager != null) {
            viewPager.setCurrentItem(i3, false);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this$0.n(i3, true, true);
        }
    }

    private final void q(boolean isAdd) {
        LinearLayout linearLayout = this.mTabContainer;
        int childCount = linearLayout != null ? linearLayout.getChildCount() : 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            LinearLayout linearLayout2 = this.mTabContainer;
            View childAt = linearLayout2 != null ? linearLayout2.getChildAt(i3) : null;
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.RelativeLayout");
            View childAt2 = ((RelativeLayout) childAt).getChildAt(1);
            Intrinsics.checkNotNull(childAt2, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) childAt2;
            Object tag = textView.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Int");
            if (((Integer) tag).intValue() == 1) {
                int parseInt = Integer.parseInt(textView.getText().toString());
                textView.setText(String.valueOf(isAdd ? parseInt + 1 : parseInt - 1));
            }
        }
    }

    private final void r(int currentPos) {
        LinearLayout linearLayout = this.mTabContainer;
        int childCount = linearLayout != null ? linearLayout.getChildCount() : 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            LinearLayout linearLayout2 = this.mTabContainer;
            View childAt = linearLayout2 != null ? linearLayout2.getChildAt(i3) : null;
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.RelativeLayout");
            RelativeLayout relativeLayout = (RelativeLayout) childAt;
            View childAt2 = relativeLayout.getChildAt(0);
            Intrinsics.checkNotNull(childAt2, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) childAt2;
            View childAt3 = relativeLayout.getChildAt(1);
            Intrinsics.checkNotNull(childAt3, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView2 = (TextView) childAt3;
            if (i3 == currentPos) {
                textView.setTextColor(this.mCheckedTextColor);
                textView.setTypeface(Typeface.defaultFromStyle(1));
                textView2.setTextColor(this.mCheckedTextColor);
            } else {
                textView.setTypeface(Typeface.defaultFromStyle(0));
                textView.setTextColor(this.mUncheckedTextColor);
                textView2.setTextColor(this.mUncheckedTextColor);
            }
        }
    }

    protected final void c(int position, ZPlanTabTitleData titleData) {
        Typeface defaultFromStyle;
        int i3;
        int i16;
        Intrinsics.checkNotNullParameter(titleData, "titleData");
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        TextView textView = new TextView(getContext());
        textView.setFocusable(true);
        textView.setText(titleData.getTitle());
        textView.setTextSize(this.TAB_TEXT_SIZE);
        if (position == this.mCurrentPosition) {
            defaultFromStyle = Typeface.defaultFromStyle(1);
        } else {
            defaultFromStyle = Typeface.defaultFromStyle(0);
        }
        textView.setTypeface(defaultFromStyle);
        if (position == this.mCurrentPosition) {
            i3 = this.mCheckedTextColor;
        } else {
            i3 = this.mUncheckedTextColor;
        }
        textView.setTextColor(i3);
        textView.setGravity(17);
        textView.setPadding(0, 0, 0, 0);
        textView.setSingleLine();
        textView.setTag(Integer.valueOf(position));
        textView.setId(R.id.r8n);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        relativeLayout.addView(textView, layoutParams);
        TextView textView2 = new TextView(getContext());
        textView2.setText(titleData.getMark());
        textView2.setTextSize(this.TAB_MARK_SIZE);
        if (position == this.mCurrentPosition) {
            i16 = this.mCheckedTextColor;
        } else {
            i16 = this.mUncheckedTextColor;
        }
        textView2.setTextColor(i16);
        textView2.setGravity(17);
        textView2.setPadding(0, 0, 0, 0);
        textView2.setSingleLine();
        textView2.setTag(titleData.getId());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(6, R.id.r8n);
        layoutParams2.addRule(17, R.id.r8n);
        layoutParams2.setMarginStart(ViewUtils.dpToPx(4.0f));
        relativeLayout.addView(textView2, layoutParams2);
        o(position, relativeLayout, titleData);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams3.gravity = 17;
        layoutParams3.weight = 1.0f;
        LinearLayout linearLayout = this.mTabContainer;
        if (linearLayout != null) {
            linearLayout.addView(relativeLayout, position, layoutParams3);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("zplan_tab_id", titleData.getId());
        hashMap.put("zplan_tab_name", titleData.getTitle());
        id3.d.i(this.dtReporter, relativeLayout, "em_zplan_tab_btn", hashMap, true, true, null, false, false, 224, null);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(FollowStateChangedEvent.class);
        return arrayList;
    }

    protected final int[] h(int position) {
        LinearLayout linearLayout = this.mTabContainer;
        Intrinsics.checkNotNull(linearLayout);
        View childAt = linearLayout.getChildAt(position);
        childAt.getWidth();
        int height = getHeight();
        return new int[]{childAt.getLeft() + ViewUtils.dpToPx(this.UNDERLINE_MARGIN), height - ViewUtils.dpToPx(this.UNDERLINE_HEIGHT), childAt.getRight() - ViewUtils.dpToPx(this.UNDERLINE_MARGIN), height};
    }

    public final void m() {
        if (this.mTabTexts.size() == 0) {
            QLog.e(this.TAG, 1, "tabTexts is empty!");
            return;
        }
        LinearLayout linearLayout = this.mTabContainer;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        int size = this.mTabTexts.size();
        this.mTabCount = size;
        for (int i3 = 0; i3 < size; i3++) {
            c(i3, this.mTabTexts.get(i3));
        }
    }

    protected final void o(final int position, final View tab, final ZPlanTabTitleData titleData) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        Intrinsics.checkNotNullParameter(titleData, "titleData");
        tab.setOnClickListener(new View.OnClickListener() { // from class: vc4.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanTabView.p(ZPlanTabTitleData.this, this, tab, position, view);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (isInEditMode() || this.mTabCount == 0) {
            return;
        }
        LinearLayout linearLayout = this.mTabContainer;
        if ((linearLayout != null ? linearLayout.getChildAt(this.mCurrentPosition) : null) != null) {
            this.mPaint.setColor(q.a(R.color.b9l));
            f(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        int action = ev5.getAction();
        if (action == 0 || action != 1) {
        }
        return super.onInterceptTouchEvent(ev5);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (this.needTabCount && (event instanceof FollowStateChangedEvent)) {
            FollowStateChangedEvent followStateChangedEvent = (FollowStateChangedEvent) event;
            if (followStateChangedEvent.getRelationInfo().f434796e != 1 && followStateChangedEvent.getRelationInfo().f434796e != 3) {
                q(false);
            } else {
                q(true);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        if (ev5.getAction() != 1) {
        }
        return super.onTouchEvent(ev5);
    }

    public final void setCurrentPosition(int position) {
        setCurrentPosition(position, false);
    }

    public final void setInterceptListener(a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public final void setOnCurrentTabClickListener(b onCurrentTabClickListener) {
        this.mOnCurrentTabClickListener = onCurrentTabClickListener;
    }

    public final void setTabChangeListener(c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public final void setTabData(List<? extends ZPlanTabTitleData> titleList) {
        Intrinsics.checkNotNullParameter(titleList, "titleList");
        if (titleList.isEmpty()) {
            return;
        }
        this.mTabTexts.clear();
        this.mTabTexts.addAll(titleList);
        m();
    }

    public final void i() {
        setWillNotDraw(false);
        l();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        j(context);
        k();
    }

    public final void setCurrentPosition(int position, boolean animUnderline) {
        n(position, animUnderline, false);
    }

    public final void setNeedTabCount() {
        this.needTabCount = true;
    }

    protected final void n(int position, boolean animUnderline, boolean fromUserClick) {
        if (position >= 0 && position < this.mTabCount) {
            int i3 = this.mCurrentPosition;
            if (i3 == position || i3 < 0) {
                return;
            }
            this.mPrePosition = i3;
            this.mCurrentPosition = position;
            r(position);
            if (animUnderline) {
                d();
                return;
            }
            LinearLayout linearLayout = this.mTabContainer;
            if ((linearLayout != null ? linearLayout.getChildAt(this.mCurrentPosition) : null) != null) {
                this.mAnimationStartX = g();
            }
            invalidate();
            return;
        }
        QLog.e(this.TAG, 1, "illegal position!");
        throw new IllegalArgumentException(" illegal position, please check!");
    }

    private final void l() {
        this.mCheckedTextColor = q.a(R.color.b9l);
        this.mUncheckedTextColor = q.a(R.color.black);
        this.mMinTabMargin = ViewUtils.dip2px(this.MIN_MARGIN_HORIZONTAL);
    }

    public final void setViewPager(ViewPager viewPager) {
        if (viewPager == null) {
            return;
        }
        if (viewPager.getAdapter() != null) {
            this.mViewPager = viewPager;
            viewPager.addOnPageChangeListener(new d());
            m();
            return;
        }
        QLog.e(this.TAG, 1, "ViewPager does not have adapter instance.");
        throw new IllegalStateException("ViewPager does not have adapter instance.");
    }

    public ZPlanTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = "QUIPageTabBar";
        this.MIN_MARGIN_HORIZONTAL = 21;
        this.UNDERLINE_MARGIN_TOP = 5;
        this.UNDERLINE_HEIGHT = 2;
        this.UNDERLINE_MARGIN = 13;
        this.ANIMATION_DURATION = 200;
        this.TAB_TEXT_SIZE = 16;
        this.TAB_MARK_SIZE = 10;
        this.mTabTexts = new ArrayList();
        this.mPaint = new Paint();
        this.mRect = new RectF();
        this.dtReporter = new id3.d(null, 1, null);
        i();
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/widget/tab/ZPlanTabView$d", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements ViewPager.OnPageChangeListener {
        d() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            ZPlanTabView.this.n(position, true, true);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }
    }
}
