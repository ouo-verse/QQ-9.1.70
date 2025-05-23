package com.tencent.sqshow.zootopia.widget.tab;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewpager.widget.ViewPager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitleWithLineHint;
import com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitleWithLineHint.a;
import com.tencent.sqshow.zootopia.widget.tab.BaseViewPagerTitleWithLineHint.c;
import com.tencent.sqshow.zootopia.widget.tab.BaseZPlanTabTitleData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import t74.u;
import tl.h;
import vc4.i;
import vc4.l;

@Metadata(d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002\u0087\u0001\b&\u0018\u0000 j*\b\b\u0000\u0010\u0002*\u00020\u0001*\u0004\b\u0001\u0010\u0003*\u000e\b\u0002\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00010\u0004*\b\b\u0003\u0010\u0007*\u00020\u00062\u00020\b2\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\t:\u0004=@\u0096\u0001B.\b\u0007\u0012\b\u0010\u0090\u0001\u001a\u00030\u008f\u0001\u0012\f\b\u0002\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0091\u0001\u0012\t\b\u0002\u0010\u0093\u0001\u001a\u00020\u0010\u00a2\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\nH\u0002J/\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00028\u00022\u0006\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\rH\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\"\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001cH\u0002J\"\u0010 \u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001cH\u0002J\u0010\u0010!\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0018\u0010$\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u0010H\u0002J\b\u0010&\u001a\u00020%H$J\u0017\u0010'\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0002H$\u00a2\u0006\u0004\b'\u0010(J/\u0010)\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00028\u00022\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00028\u0000H&\u00a2\u0006\u0004\b)\u0010*J\u001f\u0010,\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00028\u00002\u0006\u0010+\u001a\u00020\u001cH&\u00a2\u0006\u0004\b,\u0010-J'\u0010.\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00028\u0002H&\u00a2\u0006\u0004\b.\u0010/J\u0017\u0010\u0005\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0005\u00100J\b\u00101\u001a\u00020\nH\u0014J\u0018\u00105\u001a\u00020\n2\u0006\u00103\u001a\u0002022\b\b\u0002\u00104\u001a\u00020\u0010J\u0010\u00108\u001a\u00020\n2\b\u00107\u001a\u0004\u0018\u000106J\u001e\u0010;\u001a\u00020\n2\f\u0010:\u001a\b\u0012\u0004\u0012\u00028\u0002092\u0006\u0010\u001b\u001a\u00020\u0010H\u0016J\u0010\u0010=\u001a\u00020\n2\u0006\u0010<\u001a\u00020\u0010H\u0016J\u0010\u0010@\u001a\u00020\n2\u0006\u0010?\u001a\u00020>H\u0016J\u0017\u0010B\u001a\u00020\n2\u0006\u0010A\u001a\u00028\u0003H\u0016\u00a2\u0006\u0004\bB\u0010CJ\b\u0010E\u001a\u00020DH\u0016R\u0014\u0010H\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010K\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u001a\u0010O\u001a\b\u0012\u0004\u0012\u00028\u00000L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR \u0010U\u001a\b\u0012\u0004\u0012\u00028\u00020P8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR\u0018\u0010X\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010Z\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010YR\"\u0010_\u001a\u00020\u00108\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010Y\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\"\u0010a\u001a\u00020\u00108\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010Y\u001a\u0004\b`\u0010\\\"\u0004\b\u0003\u0010^R\"\u0010h\u001a\u00020b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b \u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\"\u0010k\u001a\u00020b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bc\u0010c\u001a\u0004\bi\u0010e\"\u0004\bj\u0010gR\"\u0010o\u001a\u00020\u00108\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bl\u0010Y\u001a\u0004\bm\u0010\\\"\u0004\bn\u0010^R\"\u0010r\u001a\u00020\u00108\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010Y\u001a\u0004\bp\u0010\\\"\u0004\bq\u0010^R\"\u0010u\u001a\u00020\u00108\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bY\u0010Y\u001a\u0004\bs\u0010\\\"\u0004\bt\u0010^R\"\u0010x\u001a\u00020\u00108\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010Y\u001a\u0004\bv\u0010\\\"\u0004\bw\u0010^R\"\u0010{\u001a\u00020\u00108\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010Y\u001a\u0004\by\u0010\\\"\u0004\bz\u0010^R\"\u0010}\u001a\u00020\u00108\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010Y\u001a\u0004\b|\u0010\\\"\u0004\b\u0007\u0010^R\u0016\u0010\u007f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010~R\u001c\u0010\u0081\u0001\u001a\t\u0012\u0005\u0012\u00030\u0080\u00010L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bf\u0010NR\u001a\u0010\u0083\u0001\u001a\u0004\u0018\u00018\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bn\u0010\u0082\u0001R\u001a\u0010\u0085\u0001\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bq\u0010\u0084\u0001R\u0017\u0010\u0086\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010YR/\u0010\u0089\u0001\u001a\u001b\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0087\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bw\u0010\u0088\u0001R)\u00107\u001a\u0004\u0018\u0001068\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0017\n\u0005\b\u0003\u0010\u008a\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001\u00a8\u0006\u0097\u0001"}, d2 = {"Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitleWithLineHint;", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitleWithLineHint$a;", "V", "T", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseZPlanTabTitleData;", "D", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitleWithLineHint$c;", "L", "Landroid/widget/FrameLayout;", "Lvc4/i;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, HippyTKDListViewAdapter.X, "Landroid/widget/LinearLayout;", "titleContainer", "y", "", "position", "Landroid/graphics/Rect;", "w", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "index", "data", "holder", ParseCommon.CONTAINER, "k", "(ILcom/tencent/sqshow/zootopia/widget/tab/BaseZPlanTabTitleData;Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitleWithLineHint$a;Landroid/widget/LinearLayout;)V", "selectedPos", "", "withAnim", "formUserSelected", "J", "E", "H", "end", "indicatorWidth", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "W", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Lcom/tencent/sqshow/zootopia/widget/tab/BaseZPlanTabTitleData;)Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitleWithLineHint$a;", "B", "(ILcom/tencent/sqshow/zootopia/widget/tab/BaseZPlanTabTitleData;Landroid/widget/LinearLayout;Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitleWithLineHint$a;)V", "selected", "K", "(Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitleWithLineHint$a;Z)V", BdhLogUtil.LogTag.Tag_Conn, "(Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitleWithLineHint$a;ILcom/tencent/sqshow/zootopia/widget/tab/BaseZPlanTabTitleData;)V", "(Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitleWithLineHint$a;)V", DomainData.DOMAIN_NAME, "Landroid/widget/HorizontalScrollView;", "view", "selfLeftMarin", "p", "Landroidx/lifecycle/LifecycleOwner;", "owner", "o", "", "titleList", "setTitleData", "pageIndex", "a", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "b", "l", "setTitleListener", "(Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitleWithLineHint$c;)V", "Landroid/view/View;", "getView", "d", "Landroid/widget/LinearLayout;", "mTitleContainer", "e", "Landroid/view/View;", "mIndicatorView", "Ljava/util/LinkedList;", "f", "Ljava/util/LinkedList;", "mTitleItemHolderPool", "Ljava/util/ArrayList;", h.F, "Ljava/util/ArrayList;", "t", "()Ljava/util/ArrayList;", "mTitleData", "i", "Landroidx/viewpager/widget/ViewPager;", "mViewPager", "I", "mSelectedPos", "r", "()I", "M", "(I)V", "mSelectedTxtColor", "u", "mUnselectedTxtColor", "", UserInfo.SEX_FEMALE, ReportConstant.COSTREPORT_PREFIX, "()F", "N", "(F)V", "mSelectedTxtSize", "v", "U", "mUnselectedTxtSize", "G", "getMUnderLineColor", "P", "mUnderLineColor", "getMUnderLineHeight", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mUnderLineHeight", "getMUnderLineLeftMargin", BdhLogUtil.LogTag.Tag_Req, "mUnderLineLeftMargin", "getMUnderLineRightMargin", ExifInterface.LATITUDE_SOUTH, "mUnderLineRightMargin", "getMUnderLineBottomMargin", "O", "mUnderLineBottomMargin", "getMIndicatorResId", "mIndicatorResId", "Z", "mUnderLineAnimating", "Landroid/animation/ValueAnimator;", "mWaitingAnim", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitleWithLineHint$c;", "mTitleListener", "Landroid/widget/HorizontalScrollView;", "mParentScrollView", "mSelfLeftMarin", "com/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitleWithLineHint$d", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitleWithLineHint$d;", "mPageChangeListener", "Landroidx/lifecycle/LifecycleOwner;", "getOwner", "()Landroidx/lifecycle/LifecycleOwner;", "setOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "c", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public abstract class BaseViewPagerTitleWithLineHint<V extends a, T, D extends BaseZPlanTabTitleData<T>, L extends c> extends FrameLayout implements i<T, D, L> {

    /* renamed from: C, reason: from kotlin metadata */
    private int mSelectedTxtColor;

    /* renamed from: D, reason: from kotlin metadata */
    private int mUnselectedTxtColor;

    /* renamed from: E, reason: from kotlin metadata */
    private float mSelectedTxtSize;

    /* renamed from: F, reason: from kotlin metadata */
    private float mUnselectedTxtSize;

    /* renamed from: G, reason: from kotlin metadata */
    private int mUnderLineColor;

    /* renamed from: H, reason: from kotlin metadata */
    private int mUnderLineHeight;

    /* renamed from: I, reason: from kotlin metadata */
    private int mUnderLineLeftMargin;

    /* renamed from: J, reason: from kotlin metadata */
    private int mUnderLineRightMargin;

    /* renamed from: K, reason: from kotlin metadata */
    private int mUnderLineBottomMargin;

    /* renamed from: L, reason: from kotlin metadata */
    private int mIndicatorResId;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean mUnderLineAnimating;

    /* renamed from: N, reason: from kotlin metadata */
    private final LinkedList<ValueAnimator> mWaitingAnim;

    /* renamed from: P, reason: from kotlin metadata */
    private L mTitleListener;

    /* renamed from: Q, reason: from kotlin metadata */
    private HorizontalScrollView mParentScrollView;

    /* renamed from: R, reason: from kotlin metadata */
    private int mSelfLeftMarin;

    /* renamed from: S, reason: from kotlin metadata */
    private final d mPageChangeListener;

    /* renamed from: T, reason: from kotlin metadata */
    private LifecycleOwner owner;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final LinearLayout mTitleContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final View mIndicatorView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final LinkedList<V> mTitleItemHolderPool;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<D> mTitleData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ViewPager mViewPager;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mSelectedPos;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitleWithLineHint$a;", "", "Landroid/view/View;", "a", "Landroid/view/View;", "()Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "<init>", "(Landroid/view/View;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final View rootView;

        public a(View rootView) {
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            this.rootView = rootView;
        }

        /* renamed from: a, reason: from getter */
        public final View getRootView() {
            return this.rootView;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitleWithLineHint$c;", "Lvc4/l;", "", "withAnim", "", "start", "end", "", "duration", "", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface c extends l {
        void b(boolean withAnim, int start, int end, long duration);
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitleWithLineHint$e", "Loc4/a;", "", "e", "Landroid/animation/Animator;", "animation", "onAnimationStart", "onAnimationCancel", "onAnimationEnd", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e extends oc4.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BaseViewPagerTitleWithLineHint<V, T, D, L> f373476d;

        e(BaseViewPagerTitleWithLineHint<V, T, D, L> baseViewPagerTitleWithLineHint) {
            this.f373476d = baseViewPagerTitleWithLineHint;
        }

        private final void e() {
            String W = this.f373476d.W();
            int size = ((BaseViewPagerTitleWithLineHint) this.f373476d).mWaitingAnim.size();
            ViewGroup.LayoutParams layoutParams = ((BaseViewPagerTitleWithLineHint) this.f373476d).mIndicatorView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            QLog.i(W, 1, "singleAnimEnd, waiting size:" + size + ", final pos." + ((FrameLayout.LayoutParams) layoutParams).leftMargin);
            ((BaseViewPagerTitleWithLineHint) this.f373476d).mUnderLineAnimating = false;
            ValueAnimator valueAnimator = (ValueAnimator) ((BaseViewPagerTitleWithLineHint) this.f373476d).mWaitingAnim.pollLast();
            if (valueAnimator != null) {
                valueAnimator.start();
            }
        }

        @Override // oc4.a, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            e();
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            e();
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            ((BaseViewPagerTitleWithLineHint) this.f373476d).mUnderLineAnimating = true;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseViewPagerTitleWithLineHint(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void A() {
        n();
        y(this.mTitleContainer);
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(int selectedPos, final boolean withAnim, boolean formUserSelected) {
        ViewPager viewPager = this.mViewPager;
        Integer valueOf = viewPager != null ? Integer.valueOf(viewPager.getCurrentItem()) : null;
        QLog.i(W(), 1, "pageSelected selectedPos:" + selectedPos + ", currentPage:" + valueOf + ", mSelectedPos:" + this.mSelectedPos);
        if (this.mSelectedPos == selectedPos && valueOf != null && selectedPos == valueOf.intValue()) {
            QLog.i(W(), 1, "pageSelected mSelectedPos == selectedPos, do nothing");
            return;
        }
        this.mSelectedPos = selectedPos;
        J(selectedPos, withAnim, formUserSelected);
        post(new Runnable() { // from class: vc4.e
            @Override // java.lang.Runnable
            public final void run() {
                BaseViewPagerTitleWithLineHint.G(BaseViewPagerTitleWithLineHint.this, withAnim);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(BaseViewPagerTitleWithLineHint this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.H(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(int i3, int i16, int i17, int i18, int i19, int i26, BaseViewPagerTitleWithLineHint this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (i3 + ((i16 - i3) * floatValue)), (int) (i17 + ((i18 - i17) * floatValue)));
        layoutParams.gravity = 80;
        layoutParams.leftMargin = (int) (i19 + ((i26 - i19) * floatValue));
        layoutParams.bottomMargin = this$0.mUnderLineBottomMargin;
        this$0.mIndicatorView.setLayoutParams(layoutParams);
        this$0.mIndicatorView.requestLayout();
    }

    private final void J(int selectedPos, boolean withAnim, boolean formUserSelected) {
        Iterator<V> it = this.mTitleItemHolderPool.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            int i16 = i3 + 1;
            V next = it.next();
            boolean z16 = i3 == selectedPos;
            if (formUserSelected && z16) {
                D(next);
            }
            K(next, z16);
            i3 = i16;
        }
        ViewPager viewPager = this.mViewPager;
        if (viewPager != null) {
            viewPager.setCurrentItem(selectedPos, withAnim);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(BaseViewPagerTitleWithLineHint this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.H(false);
    }

    private final void k(final int index, final D data, final V holder, LinearLayout container) {
        boolean z16 = index == this.mSelectedPos;
        holder.getRootView().setOnClickListener(new View.OnClickListener() { // from class: vc4.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseViewPagerTitleWithLineHint.l(BaseViewPagerTitleWithLineHint.this, index, holder, data, view);
            }
        });
        K(holder, z16);
        B(index, data, container, holder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(BaseViewPagerTitleWithLineHint this$0, int i3, a holder, BaseZPlanTabTitleData data, View view) {
        L l3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(data, "$data");
        boolean b16 = com.tencent.sqshow.zootopia.utils.h.b(this$0.W() + "-" + i3);
        if (i3 >= this$0.mTitleData.size()) {
            QLog.e(this$0.W(), 1, "BAD index. {index=" + i3 + ", mTitleData=" + this$0.mTitleData);
            return;
        }
        if (b16 && (l3 = this$0.mTitleListener) != null) {
            l3.a(i3);
        }
        QLog.i(this$0.W(), 1, "isDouble:" + b16 + " mUnderLineAnimating:" + this$0.mUnderLineAnimating);
        if (this$0.mUnderLineAnimating) {
            return;
        }
        this$0.C(holder, i3, data);
        F(this$0, i3, true, false, 4, null);
    }

    private final void m(int end, int indicatorWidth) {
        HorizontalScrollView horizontalScrollView = this.mParentScrollView;
        if (horizontalScrollView == null) {
            return;
        }
        horizontalScrollView.smoothScrollTo((int) (((end + this.mSelfLeftMarin) - (u.INSTANCE.c(getContext()) * 0.5f)) + (indicatorWidth / 2)), 0);
    }

    private final Rect w(int position) {
        View childAt = this.mTitleContainer.getChildAt(position);
        if (childAt == null) {
            return null;
        }
        int width = (childAt.getWidth() - this.mUnderLineLeftMargin) - this.mUnderLineRightMargin;
        Rect rect = new Rect();
        rect.left = childAt.getLeft() + this.mUnderLineLeftMargin;
        int bottom = childAt.getBottom();
        int i3 = this.mUnderLineHeight;
        int i16 = bottom - i3;
        rect.top = i16;
        rect.right = rect.left + width;
        rect.bottom = i16 + i3;
        return rect;
    }

    private final void x() {
        this.mIndicatorView.setBackgroundResource(this.mIndicatorResId);
        addView(this.mIndicatorView, new FrameLayout.LayoutParams(0, 0));
    }

    private final void z() {
        this.mTitleContainer.removeAllViews();
        this.mTitleItemHolderPool.clear();
        Iterator<D> it = this.mTitleData.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            D next = it.next();
            V q16 = q(next);
            k(i3, next, q16, this.mTitleContainer);
            this.mTitleItemHolderPool.add(q16);
            i3++;
        }
    }

    public abstract void B(int index, D data, LinearLayout container, V holder);

    public abstract void C(V holder, int index, D data);

    public void D(V holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    public abstract void K(V holder, boolean selected);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void L(int i3) {
        this.mIndicatorResId = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void M(int i3) {
        this.mSelectedTxtColor = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void N(float f16) {
        this.mSelectedTxtSize = f16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void O(int i3) {
        this.mUnderLineBottomMargin = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void P(int i3) {
        this.mUnderLineColor = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Q(int i3) {
        this.mUnderLineHeight = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void R(int i3) {
        this.mUnderLineLeftMargin = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void S(int i3) {
        this.mUnderLineRightMargin = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void T(int i3) {
        this.mUnselectedTxtColor = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void U(float f16) {
        this.mUnselectedTxtSize = f16;
    }

    protected abstract String W();

    @Override // vc4.i
    public void a(int pageIndex) {
        QLog.i(W(), 1, "pageSelected pageIndex:" + pageIndex);
        F(this, pageIndex, false, false, 4, null);
    }

    @Override // vc4.i
    public void b(ViewPager viewPager) {
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        this.mViewPager = viewPager;
        viewPager.removeOnPageChangeListener(this.mPageChangeListener);
        viewPager.addOnPageChangeListener(this.mPageChangeListener);
        F(this, this.mSelectedPos, false, false, 4, null);
    }

    public final void o(LifecycleOwner owner) {
        this.owner = owner;
    }

    public final void p(HorizontalScrollView view, int selfLeftMarin) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.mParentScrollView = view;
        this.mSelfLeftMarin = selfLeftMarin;
    }

    protected abstract V q(D data);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: r, reason: from getter */
    public final int getMSelectedTxtColor() {
        return this.mSelectedTxtColor;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: s, reason: from getter */
    public final float getMSelectedTxtSize() {
        return this.mSelectedTxtSize;
    }

    @Override // vc4.i
    public void setTitleData(List<? extends D> titleList, int selectedPos) {
        Intrinsics.checkNotNullParameter(titleList, "titleList");
        QLog.i(W(), 1, "setTitleData titleList:" + titleList + ", selectedPos:" + selectedPos);
        this.mTitleData.clear();
        this.mTitleData.addAll(titleList);
        z();
        F(this, selectedPos, false, false, 4, null);
        post(new Runnable() { // from class: vc4.c
            @Override // java.lang.Runnable
            public final void run() {
                BaseViewPagerTitleWithLineHint.V(BaseViewPagerTitleWithLineHint.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ArrayList<D> t() {
        return this.mTitleData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: u, reason: from getter */
    public final int getMUnselectedTxtColor() {
        return this.mUnselectedTxtColor;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: v, reason: from getter */
    public final float getMUnselectedTxtSize() {
        return this.mUnselectedTxtSize;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseViewPagerTitleWithLineHint(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void y(LinearLayout titleContainer) {
        titleContainer.setOrientation(0);
        addView(titleContainer, new FrameLayout.LayoutParams(-2, -2));
    }

    public void setTitleListener(L l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        this.mTitleListener = l3;
    }

    public /* synthetic */ BaseViewPagerTitleWithLineHint(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    private final void H(boolean withAnim) {
        long j3;
        int i3;
        Rect w3 = w(this.mSelectedPos);
        if (w3 == null) {
            return;
        }
        final int width = w3.width();
        final int height = w3.height();
        final int width2 = this.mIndicatorView.getWidth();
        final int height2 = this.mIndicatorView.getHeight();
        ViewGroup.LayoutParams layoutParams = this.mIndicatorView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        final int i16 = ((FrameLayout.LayoutParams) layoutParams).leftMargin;
        final int i17 = w3.left;
        QLog.i("BaseViewPagerTitleWithLineHint_", 1, "targetWidth:" + width + " currentWidth:" + width2 + ",targetHeight:" + height + " currentHeight:" + height2 + ",targetLeft:" + i17 + ", currentLeft:" + i16);
        if (withAnim) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(150L);
            j3 = 150;
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: vc4.d
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BaseViewPagerTitleWithLineHint.I(width2, width, height2, height, i16, i17, this, valueAnimator);
                }
            });
            ofFloat.addListener(new e(this));
            if (this.mUnderLineAnimating) {
                QLog.i(W(), 1, "refreshIndicator anim is doing, append anim to list");
                this.mWaitingAnim.push(ofFloat);
            } else {
                ofFloat.start();
            }
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(w3.width(), w3.height());
            layoutParams2.gravity = 80;
            layoutParams2.bottomMargin = this.mUnderLineBottomMargin;
            layoutParams2.leftMargin = i17;
            this.mIndicatorView.setLayoutParams(layoutParams2);
            this.mIndicatorView.requestLayout();
            j3 = 0;
        }
        L l3 = this.mTitleListener;
        if (l3 != null) {
            i3 = i17;
            l3.b(withAnim, i16, i17, j3);
        } else {
            i3 = i17;
        }
        m(i3, w3.width());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseViewPagerTitleWithLineHint(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mTitleContainer = new LinearLayout(context);
        this.mIndicatorView = new View(context);
        this.mTitleItemHolderPool = new LinkedList<>();
        this.mTitleData = new ArrayList<>();
        this.mSelectedTxtColor = -16777216;
        this.mUnselectedTxtColor = Color.parseColor("#999999");
        this.mSelectedTxtSize = 17.0f;
        this.mUnselectedTxtSize = 15.0f;
        this.mUnderLineColor = Color.parseColor("#0099FF");
        this.mUnderLineHeight = com.tencent.sqshow.zootopia.utils.i.a(2.5f);
        this.mUnderLineLeftMargin = com.tencent.sqshow.zootopia.utils.i.b(0);
        this.mUnderLineRightMargin = com.tencent.sqshow.zootopia.utils.i.b(0);
        this.mUnderLineBottomMargin = com.tencent.sqshow.zootopia.utils.i.b(0);
        this.mIndicatorResId = R.drawable.hy7;
        this.mWaitingAnim = new LinkedList<>();
        this.mPageChangeListener = new d(this);
        A();
    }

    static /* synthetic */ void F(BaseViewPagerTitleWithLineHint baseViewPagerTitleWithLineHint, int i3, boolean z16, boolean z17, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 4) != 0) {
                z17 = false;
            }
            baseViewPagerTitleWithLineHint.E(i3, z16, z17);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pageSelected");
    }

    @Override // vc4.i
    public View getView() {
        return this;
    }

    protected void n() {
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/widget/tab/BaseViewPagerTitleWithLineHint$d", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements ViewPager.OnPageChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BaseViewPagerTitleWithLineHint<V, T, D, L> f373475d;

        d(BaseViewPagerTitleWithLineHint<V, T, D, L> baseViewPagerTitleWithLineHint) {
            this.f373475d = baseViewPagerTitleWithLineHint;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            QLog.i(this.f373475d.W(), 1, "onPageSelected position:" + position);
            this.f373475d.E(position, true, true);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }
    }
}
