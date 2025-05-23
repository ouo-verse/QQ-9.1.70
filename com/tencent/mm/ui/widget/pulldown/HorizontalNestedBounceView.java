package com.tencent.mm.ui.widget.pulldown;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.math.MathUtils;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.heytap.databaseengine.apiv3.data.Element;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.luggage.wxa.standalone_open_runtime_sdk.R;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.ui.widget.pulldown.IBounceView;
import com.tencent.mm.ui.widget.pulldown.IOverScrollCallback;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00ab\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0004\u00ab\u0001\u00ac\u0001B!\u0012\b\u0010\u00a6\u0001\u001a\u00030\u00a5\u0001\u0012\f\b\u0002\u0010\u00a8\u0001\u001a\u0005\u0018\u00010\u00a7\u0001\u00a2\u0006\u0006\b\u00a9\u0001\u0010\u00aa\u0001J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J(\u0010\u0011\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0002J(\u0010\u0012\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0002J\u0018\u0010\u000b\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J(\u0010\u000b\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0002J\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0014J\u0012\u0010\u0019\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001a\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0014H\u0016J\u0014\u0010!\u001a\u00020\u0014*\u00020\b2\b\u0010 \u001a\u0004\u0018\u00010\u001fJ\u001e\u0010%\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u0014J\u000e\u0010&\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001fJ(\u0010)\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\rH\u0016J \u0010)\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010*\u001a\u00020\rH\u0016J(\u0010+\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\rH\u0016J \u0010+\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010*\u001a\u00020\rH\u0016J\u0018\u0010,\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010(\u001a\u00020\rH\u0016J\u0010\u0010,\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J0\u00101\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\r2\u0006\u00100\u001a\u00020\rH\u0016J8\u00101\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\r2\u0006\u00100\u001a\u00020\r2\u0006\u0010(\u001a\u00020\rH\u0016J0\u00106\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u00102\u001a\u00020\r2\u0006\u00103\u001a\u00020\r2\u0006\u00105\u001a\u0002042\u0006\u0010(\u001a\u00020\rH\u0016J0\u0010\u000b\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u00102\u001a\u00020\r2\u0006\u00103\u001a\u00020\r2\u0006\u00105\u001a\u0002042\u0006\u0010(\u001a\u00020\rH\u0014J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010/\u001a\u00020\r2\u0006\u0010(\u001a\u00020\r2\b\u00105\u001a\u0004\u0018\u000104H\u0014J(\u00106\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u00102\u001a\u00020\r2\u0006\u00103\u001a\u00020\r2\u0006\u00105\u001a\u000204H\u0016J\b\u00107\u001a\u00020\rH\u0016J(\u0010;\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\b2\u0006\u00109\u001a\u0002082\u0006\u0010:\u001a\u0002082\u0006\u00105\u001a\u00020\u0014H\u0016J \u0010<\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\b2\u0006\u00109\u001a\u0002082\u0006\u0010:\u001a\u000208H\u0016J\u001a\u0010>\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010=\u001a\u00020\rH\u0016J\u0012\u0010?\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010@\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010A\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010B\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\bH\u0016J\u0010\u0010C\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\bH\u0016J \u0010F\u001a\u00020\u00142\u0006\u0010D\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\b2\u0006\u0010E\u001a\u00020\rH\u0016J \u0010G\u001a\u00020\r2\u0006\u0010D\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\b2\u0006\u0010E\u001a\u00020\rH\u0016J \u0010H\u001a\u0002082\u0006\u0010D\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\b2\u0006\u0010E\u001a\u00020\rH\u0016J \u0010I\u001a\u00020\r2\u0006\u0010D\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\b2\u0006\u0010E\u001a\u00020\rH\u0016J \u0010J\u001a\u00020\n2\u0006\u0010D\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\b2\u0006\u0010=\u001a\u00020\rH\u0016J\u0018\u0010K\u001a\u00020\u00142\u0006\u0010D\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010L\u001a\u00020\n2\u0006\u0010D\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\bH\u0016R\"\u0010R\u001a\u00020\u00148\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u0014\u0010U\u001a\u00020S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010TR\u0018\u0010X\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010WR\u0018\u0010[\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u001c\u0010`\u001a\u00020\r8\u0002@\u0002X\u0083\u000e\u00a2\u0006\f\n\u0004\b\\\u0010]\u0012\u0004\b^\u0010_R\u0016\u0010b\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010]R\u0018\u0010e\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010dR\"\u0010k\u001a\u00020\r8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bf\u0010]\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR$\u0010s\u001a\u0004\u0018\u00010l8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bm\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR \u0010y\u001a\b\u0012\u0004\u0012\u00020\u00170t8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bu\u0010v\u001a\u0004\bw\u0010xR$\u0010\u0081\u0001\u001a\u00020z8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0013\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R\u001c\u0010\u0086\u0001\u001a\u00020\u00048\u0006\u00a2\u0006\u0010\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0016\u0010\u0088\u0001\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0087\u0001\u0010]R,\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u008a\u0001\u0010\u008b\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R&\u0010\u0092\u0001\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0091\u0001\u0010M\u001a\u0005\b\u0092\u0001\u0010O\"\u0005\b\u0093\u0001\u0010QR&\u0010\u0095\u0001\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0094\u0001\u0010M\u001a\u0005\b\u0095\u0001\u0010O\"\u0005\b\u0096\u0001\u0010QR\u0018\u0010\u009a\u0001\u001a\u00030\u0097\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001R&\u0010\u009e\u0001\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u009b\u0001\u0010]\u001a\u0005\b\u009c\u0001\u0010h\"\u0005\b\u009d\u0001\u0010jR&\u0010\u00a0\u0001\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u009f\u0001\u0010M\u001a\u0005\b\u00a0\u0001\u0010O\"\u0005\b\u00a1\u0001\u0010QR\u001f\u0010\u00a4\u0001\u001a\t\u0018\u00010\u00a2\u0001R\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b]\u0010\u00a3\u0001\u00a8\u0006\u00ad\u0001"}, d2 = {"Lcom/tencent/mm/ui/widget/pulldown/HorizontalNestedBounceView;", "Landroid/widget/FrameLayout;", "Landroidx/core/view/NestedScrollingParent2;", "Lcom/tencent/mm/ui/widget/pulldown/IBounceCommon;", "Lcom/tencent/mm/ui/widget/pulldown/IOverScroll;", "Lcom/tencent/mm/ui/widget/pulldown/IOverScrollCallback;", "Landroid/widget/OverScroller;", "overScroller", "Landroid/view/View;", "target", "", "a", "child", "", Element.ELEMENT_NAME_DISTANCE, "minOffset", "maxOffset", "c", "b", "newOffset", "", "enable", "setBounce", "Lcom/tencent/mm/ui/widget/pulldown/IBounceView$BounceOffsetChangedListener;", "bounceOffsetChangedListener", "addBounceOffsetChangedListener", "removeBounceOffsetChangedListener", "enableStart2End", "enableEnd2Start", "disallowIntercept", "requestDisallowInterceptTouchEvent", "Landroid/view/MotionEvent;", "ev", "contains", "deltaX", "isAtStart", "isAtEnd", "checkScrollDirectionMatchEdge", "dispatchDownEventManually", "axes", "type", "onStartNestedScroll", "nestedScrollAxes", "onNestedScrollAccepted", "onStopNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScroll", "dx", "dy", "", "consumed", "onNestedPreScroll", "getNestedScrollAxes", "", "velocityX", "velocityY", "onNestedFling", "onNestedPreFling", "offset", "setOffset", "getOffset", "getMaxOffset", "getMinOffset", "stopSpringBack", "springBack", "overScroll", "scrollDirection", "canScroll", "getMaxFlingOffset", "getDampingFactor", "getMinFlingVelocity", "onOffsetChanged", "onSpringBack", "onStopSpringingBack", "Z", "getMIsEnabled", "()Z", "setMIsEnabled", "(Z)V", "mIsEnabled", "Landroid/view/animation/Interpolator;", "Landroid/view/animation/Interpolator;", "mSpringBackInterpolator", "Landroid/animation/ValueAnimator;", "Landroid/animation/ValueAnimator;", "mSpringBackAnimator", "d", "Landroid/widget/OverScroller;", "mOverScroller", "e", "I", "getMDirectionToEnd$annotations", "()V", "mDirectionToEnd", "f", "mDirectionToStart", "g", "Landroid/view/View;", "mCurNestedChild", h.F, "getMPullDownEnableFlag", "()I", "setMPullDownEnableFlag", "(I)V", "mPullDownEnableFlag", "Lcom/tencent/mm/ui/widget/pulldown/ICustomNestedChild;", "i", "Lcom/tencent/mm/ui/widget/pulldown/ICustomNestedChild;", "getCustomNestedChild", "()Lcom/tencent/mm/ui/widget/pulldown/ICustomNestedChild;", "setCustomNestedChild", "(Lcom/tencent/mm/ui/widget/pulldown/ICustomNestedChild;)V", "customNestedChild", "Ljava/util/LinkedList;", "j", "Ljava/util/LinkedList;", "getMBounceOffsetChangedListeners", "()Ljava/util/LinkedList;", "mBounceOffsetChangedListeners", "Lcom/tencent/mm/ui/widget/pulldown/HorizontalOverScrollCallback;", "k", "Lcom/tencent/mm/ui/widget/pulldown/HorizontalOverScrollCallback;", "getMOverscrollListener", "()Lcom/tencent/mm/ui/widget/pulldown/HorizontalOverScrollCallback;", "setMOverscrollListener", "(Lcom/tencent/mm/ui/widget/pulldown/HorizontalOverScrollCallback;)V", "mOverscrollListener", "l", "Lcom/tencent/mm/ui/widget/pulldown/IOverScroll;", "getScrollMode", "()Lcom/tencent/mm/ui/widget/pulldown/IOverScroll;", "scrollMode", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mTouchSlop", "Landroid/widget/ScrollView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ScrollView;", "getMCompatScrollViewChild", "()Landroid/widget/ScrollView;", "setMCompatScrollViewChild", "(Landroid/widget/ScrollView;)V", "mCompatScrollViewChild", "D", "isAtStartWhenIntercept", "setAtStartWhenIntercept", "E", "isAtEndWhenIntercept", "setAtEndWhenIntercept", "Landroidx/core/view/NestedScrollingParentHelper;", UserInfo.SEX_FEMALE, "Landroidx/core/view/NestedScrollingParentHelper;", "mParentHelper", "G", "getLastType", "setLastType", "lastType", "H", "isFlinging", "setFlinging", "Lcom/tencent/mm/ui/widget/pulldown/HorizontalNestedBounceView$FlingRunnable;", "Lcom/tencent/mm/ui/widget/pulldown/HorizontalNestedBounceView$FlingRunnable;", "mFlingRunnable", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "FlingRunnable", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public class HorizontalNestedBounceView extends FrameLayout implements NestedScrollingParent2, IBounceCommon, IOverScroll, IOverScrollCallback {
    public static final int FLAG_END_2_START = 2;
    public static final int FLAG_START_2_END = 1;

    @NotNull
    public static final String TAG = "HorizontalPullView";

    /* renamed from: C, reason: from kotlin metadata */
    public ScrollView mCompatScrollViewChild;

    /* renamed from: D, reason: from kotlin metadata */
    public boolean isAtStartWhenIntercept;

    /* renamed from: E, reason: from kotlin metadata */
    public boolean isAtEndWhenIntercept;

    /* renamed from: F, reason: from kotlin metadata */
    public final NestedScrollingParentHelper mParentHelper;

    /* renamed from: G, reason: from kotlin metadata */
    public int lastType;

    /* renamed from: H, reason: from kotlin metadata */
    public boolean isFlinging;

    /* renamed from: I, reason: from kotlin metadata */
    public FlingRunnable mFlingRunnable;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public boolean mIsEnabled;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Interpolator mSpringBackInterpolator;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public ValueAnimator mSpringBackAnimator;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public OverScroller mOverScroller;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public int mDirectionToEnd;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public int mDirectionToStart;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public View mCurNestedChild;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public int mPullDownEnableFlag;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public ICustomNestedChild customNestedChild;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final LinkedList mBounceOffsetChangedListeners;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public HorizontalOverScrollCallback mOverscrollListener;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final IOverScroll scrollMode;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public final int mTouchSlop;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0004\u001a\u00020\u0002R\u0017\u0010\n\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mm/ui/widget/pulldown/HorizontalNestedBounceView$FlingRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "start", "Landroid/widget/OverScroller;", "a", "Landroid/widget/OverScroller;", "getMScroller", "()Landroid/widget/OverScroller;", "mScroller", "Landroid/view/View;", "b", "Landroid/view/View;", "getTarget", "()Landroid/view/View;", "target", "", "c", "I", "mLastFlingX", "<init>", "(Lcom/tencent/mm/ui/widget/pulldown/HorizontalNestedBounceView;Landroid/widget/OverScroller;Landroid/view/View;)V", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public final class FlingRunnable implements Runnable {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final OverScroller mScroller;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final View target;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public int mLastFlingX;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ HorizontalNestedBounceView f153716d;

        public FlingRunnable(@NotNull HorizontalNestedBounceView horizontalNestedBounceView, @NotNull OverScroller mScroller, View target) {
            Intrinsics.checkNotNullParameter(mScroller, "mScroller");
            Intrinsics.checkNotNullParameter(target, "target");
            this.f153716d = horizontalNestedBounceView;
            this.mScroller = mScroller;
            this.target = target;
            this.mLastFlingX = mScroller.getCurrX();
        }

        @NotNull
        public final OverScroller getMScroller() {
            return this.mScroller;
        }

        @NotNull
        public final View getTarget() {
            return this.target;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller = this.mScroller;
            boolean computeScrollOffset = overScroller.computeScrollOffset();
            int currX = overScroller.getCurrX();
            int i3 = currX - this.mLastFlingX;
            View view = this.target;
            if ((view instanceof AbsListView) || (view instanceof ScrollView)) {
                if (NestedBounceParam.INSTANCE.isPullDownDebugOpen()) {
                    Log.i(HorizontalNestedBounceView.TAG, "[fling] hasMore:" + computeScrollOffset + " velocity:" + overScroller.getCurrVelocity() + " delta:" + i3 + " mLastFlingX:" + this.mLastFlingX + " x:" + currX + " isAtStart:" + WeUIBounceCommonKt.isAtStart(this.target) + " isAtEnd:" + WeUIBounceCommonKt.isAtEnd(this.target));
                }
                if (computeScrollOffset) {
                    if (i3 < 0 && WeUIBounceCommonKt.isAtStart(this.target)) {
                        this.f153716d.a(this.target, i3, 1, new int[2]);
                    } else if (i3 > 0 && WeUIBounceCommonKt.isAtEnd(this.target)) {
                        this.f153716d.a(this.target, i3, 1, new int[2]);
                    }
                    this.mLastFlingX = currX;
                    this.f153716d.postOnAnimation(this);
                    return;
                }
                this.f153716d.onStopNestedScroll(this.target, 1);
            }
        }

        public final void start() {
            this.mLastFlingX = this.mScroller.getCurrX();
            this.f153716d.postOnAnimation(this);
        }
    }

    public /* synthetic */ HorizontalNestedBounceView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    public final void a(OverScroller overScroller, View target) {
        if (this.mFlingRunnable == null) {
            this.mFlingRunnable = new FlingRunnable(this, overScroller, target);
        }
        FlingRunnable flingRunnable = this.mFlingRunnable;
        if (flingRunnable != null) {
            flingRunnable.start();
        }
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IBounceCommon
    public void addBounceOffsetChangedListener(@Nullable IBounceView.BounceOffsetChangedListener bounceOffsetChangedListener) {
        if (bounceOffsetChangedListener != null && !this.mBounceOffsetChangedListeners.contains(bounceOffsetChangedListener)) {
            this.mBounceOffsetChangedListeners.add(bounceOffsetChangedListener);
        }
    }

    public final int b(View child, int distance, int minOffset, int maxOffset) {
        return a(child, getOffset(child) - a(child, distance), minOffset, maxOffset);
    }

    public final int c(View child, int distance, int minOffset, int maxOffset) {
        return a(child, getOffset(child) - distance, minOffset, maxOffset);
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IOverScrollCallback
    public boolean canScroll(@NotNull IOverScroll overScroll, @NotNull View child, int scrollDirection) {
        Intrinsics.checkNotNullParameter(overScroll, "overScroll");
        Intrinsics.checkNotNullParameter(child, "child");
        return this.mOverscrollListener.canScroll(overScroll, child, scrollDirection);
    }

    public final boolean checkScrollDirectionMatchEdge(int deltaX, boolean isAtStart, boolean isAtEnd) {
        if ((deltaX > 0 && isAtStart) || (deltaX < 0 && isAtEnd)) {
            return true;
        }
        return false;
    }

    public final boolean contains(@NotNull View view, @Nullable MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (motionEvent != null) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            boolean contains = rect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
            if (contains) {
                if (NestedBounceParam.INSTANCE.isPullDownDebugOpen()) {
                    Log.d(TAG, "contains() called with:actualPosition=" + rect + " containRes = " + contains + " ev = " + motionEvent + TokenParser.SP);
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public final void dispatchDownEventManually(@NotNull MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        int action = ev5.getAction();
        ev5.setAction(0);
        dispatchTouchEvent(ev5);
        ev5.setAction(action);
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IBounceCommon
    public void enableEnd2Start(boolean enable) {
        int i3;
        if (enable) {
            i3 = this.mPullDownEnableFlag | 2;
        } else {
            i3 = this.mPullDownEnableFlag & (-3);
        }
        this.mPullDownEnableFlag = i3;
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IBounceCommon
    public void enableStart2End(boolean enable) {
        int i3;
        if (enable) {
            i3 = this.mPullDownEnableFlag | 1;
        } else {
            i3 = this.mPullDownEnableFlag & (-2);
        }
        this.mPullDownEnableFlag = i3;
    }

    @Nullable
    public final ICustomNestedChild getCustomNestedChild() {
        return this.customNestedChild;
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IOverScrollCallback
    public float getDampingFactor(@NotNull IOverScroll overScroll, @NotNull View child, int scrollDirection) {
        Intrinsics.checkNotNullParameter(overScroll, "overScroll");
        Intrinsics.checkNotNullParameter(child, "child");
        return this.mOverscrollListener.getDampingFactor(overScroll, child, scrollDirection);
    }

    public final int getLastType() {
        return this.lastType;
    }

    @NotNull
    public final LinkedList<IBounceView.BounceOffsetChangedListener> getMBounceOffsetChangedListeners() {
        return this.mBounceOffsetChangedListeners;
    }

    @Nullable
    public final ScrollView getMCompatScrollViewChild() {
        return this.mCompatScrollViewChild;
    }

    public final boolean getMIsEnabled() {
        return this.mIsEnabled;
    }

    @NotNull
    public final HorizontalOverScrollCallback getMOverscrollListener() {
        return this.mOverscrollListener;
    }

    public final int getMPullDownEnableFlag() {
        return this.mPullDownEnableFlag;
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IOverScrollCallback
    public int getMaxFlingOffset(@NotNull IOverScroll overScroll, @NotNull View child, int scrollDirection) {
        Intrinsics.checkNotNullParameter(overScroll, "overScroll");
        Intrinsics.checkNotNullParameter(child, "child");
        return this.mOverscrollListener.getMaxFlingOffset(overScroll, child, scrollDirection);
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IOverScroll
    public int getMaxOffset(@Nullable View child) {
        return this.scrollMode.getMaxOffset(child);
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IOverScrollCallback
    public int getMinFlingVelocity(@NotNull IOverScroll overScroll, @NotNull View child, int scrollDirection) {
        Intrinsics.checkNotNullParameter(overScroll, "overScroll");
        Intrinsics.checkNotNullParameter(child, "child");
        return this.mOverscrollListener.getMinFlingVelocity(overScroll, child, scrollDirection);
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IOverScroll
    public int getMinOffset(@Nullable View child) {
        return this.scrollMode.getMinOffset(child);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IOverScroll
    public int getOffset(@Nullable View child) {
        return this.scrollMode.getOffset(child);
    }

    @NotNull
    public final IOverScroll getScrollMode() {
        return this.scrollMode;
    }

    /* renamed from: isAtEndWhenIntercept, reason: from getter */
    public final boolean getIsAtEndWhenIntercept() {
        return this.isAtEndWhenIntercept;
    }

    /* renamed from: isAtStartWhenIntercept, reason: from getter */
    public final boolean getIsAtStartWhenIntercept() {
        return this.isAtStartWhenIntercept;
    }

    /* renamed from: isFlinging, reason: from getter */
    public final boolean getIsFlinging() {
        return this.isFlinging;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NotNull View target, float velocityX, float velocityY, boolean consumed) {
        Intrinsics.checkNotNullParameter(target, "target");
        if (NestedBounceParam.INSTANCE.isPullDownDebugOpen()) {
            Log.i(TAG, "[onNestedFling] velocityX:" + velocityX + " velocityY:" + velocityY + " consumed:" + consumed);
        }
        return super.onNestedFling(target, velocityX, velocityY, consumed);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NotNull View target, float velocityX, float velocityY) {
        Intrinsics.checkNotNullParameter(target, "target");
        if (NestedBounceParam.INSTANCE.isPullDownDebugOpen()) {
            Log.i(TAG, "[onNestedPreFling] velocityX:" + velocityX + " velocityY:" + velocityY + " velocityY:" + velocityY);
        }
        if (this.mOverScroller == null) {
            this.mOverScroller = new OverScroller(getContext());
        }
        OverScroller overScroller = this.mOverScroller;
        if (overScroller != null) {
            overScroller.fling(0, 0, (int) velocityX, 0, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        this.isFlinging = true;
        return super.onNestedPreFling(target, velocityX, velocityY);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(@NotNull View target, int dx5, int dy5, @NotNull int[] consumed, int type) {
        List asList;
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        stopSpringBack(target);
        int i3 = consumed[0];
        int a16 = a(target, dx5, dy5, consumed, type);
        consumed[0] = a16;
        if (NestedBounceParam.INSTANCE.isPullDownDebugOpen()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[onNestedPreScroll]target:");
            sb5.append(target.getClass().getName());
            sb5.append(", dx:");
            sb5.append(dx5);
            sb5.append(", dy:");
            sb5.append(dy5);
            sb5.append(", consumed: ");
            asList = ArraysKt___ArraysJvmKt.asList(consumed);
            sb5.append(asList);
            sb5.append(", type: ");
            sb5.append(type);
            sb5.append(" comsumedBefore:");
            sb5.append(i3);
            sb5.append(" comsumedAfter:");
            sb5.append(a16);
            Log.i(TAG, sb5.toString());
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(@NotNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        Intrinsics.checkNotNullParameter(target, "target");
        onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(@NotNull View child, @NotNull View target, int axes, int type) {
        OverScroller overScroller;
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        this.mParentHelper.onNestedScrollAccepted(child, target, axes, type);
        if (NestedBounceParam.INSTANCE.isPullDownDebugOpen()) {
            Log.i(TAG, "[onNestedScrollAccepted] target:" + target + " enable:" + target.isNestedScrollingEnabled() + " axes:" + axes + " type:" + type);
        }
        this.mCurNestedChild = target;
        if (type == 0) {
            stopSpringBack(child);
        }
        if (type == 0 && (overScroller = this.mOverScroller) != null) {
            overScroller.forceFinished(true);
        }
        if ((axes & 2) != 0) {
            this.mDirectionToEnd = 2;
            this.mDirectionToStart = 1;
        } else {
            this.mDirectionToEnd = 8;
            this.mDirectionToStart = 4;
        }
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IOverScrollCallback
    public void onOffsetChanged(@NotNull IOverScroll overScroll, @NotNull View child, int offset) {
        Intrinsics.checkNotNullParameter(overScroll, "overScroll");
        Intrinsics.checkNotNullParameter(child, "child");
        this.mOverscrollListener.onOffsetChanged(overScroll, child, offset);
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IOverScrollCallback
    public boolean onSpringBack(@NotNull IOverScroll overScroll, @NotNull View child) {
        Intrinsics.checkNotNullParameter(overScroll, "overScroll");
        Intrinsics.checkNotNullParameter(child, "child");
        return this.mOverscrollListener.onSpringBack(overScroll, child);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(@NotNull View child, @NotNull View target, int axes, int type) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        if (NestedBounceParam.INSTANCE.isPullDownDebugOpen()) {
            Log.i(TAG, "[onStartNestedScroll] target:" + target.getClass().getName() + " enable:" + this.mIsEnabled + " axes:" + axes + " type:" + type + " isAtStart:" + WeUIBounceCommonKt.isAtStart(child) + " isAtEnd:" + WeUIBounceCommonKt.isAtEnd(child));
        }
        if (!this.mIsEnabled) {
            return false;
        }
        this.lastType = type;
        this.isFlinging = false;
        return (axes & 1) != 0;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(@NotNull View target, int type) {
        Intrinsics.checkNotNullParameter(target, "target");
        NestedBounceParam nestedBounceParam = NestedBounceParam.INSTANCE;
        if (nestedBounceParam.isPullDownDebugOpen()) {
            Log.i(TAG, "[onStopNestedScroll] target:" + target.getClass().getName() + '@' + target.hashCode() + " type:" + type + " lastType:" + this.lastType + " curOffset:" + getOffset(target) + " isFling:" + this.isFlinging + TokenParser.SP);
        }
        this.mParentHelper.onStopNestedScroll(target, type);
        OverScroller overScroller = this.mOverScroller;
        if (type == 0) {
            if (nestedBounceParam.isPullDownDebugOpen()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[onStopNestedScroll] mOverScroller:");
                sb5.append(overScroller != null ? Boolean.valueOf(overScroller.computeScrollOffset()) : null);
                sb5.append(" velocitX:");
                sb5.append(overScroller != null ? Float.valueOf(overScroller.getCurrVelocity()) : null);
                sb5.append(" delta:");
                sb5.append((overScroller != null ? overScroller.getCurrX() : 0) - (overScroller != null ? overScroller.getStartX() : 0));
                Log.i(TAG, sb5.toString());
            }
            if (getOffset(target) != 0) {
                if (overScroller == null) {
                    springBack(target);
                } else if (!overScroller.computeScrollOffset()) {
                    springBack(target);
                } else if (this.isFlinging) {
                    springBack(target);
                }
            } else if (this.isFlinging && overScroller != null && overScroller.computeScrollOffset()) {
                if (nestedBounceParam.isPullDownDebugOpen()) {
                    Log.i(TAG, "compact fling");
                }
                a(overScroller, target);
            }
        } else if (getOffset(target) != 0) {
            springBack(target);
        }
        this.mCurNestedChild = null;
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IOverScrollCallback
    public void onStopSpringingBack(@NotNull IOverScroll overScroll, @NotNull View child) {
        Intrinsics.checkNotNullParameter(overScroll, "overScroll");
        Intrinsics.checkNotNullParameter(child, "child");
        this.mOverscrollListener.onStopSpringingBack(overScroll, child);
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IBounceCommon
    public void removeBounceOffsetChangedListener(@Nullable IBounceView.BounceOffsetChangedListener bounceOffsetChangedListener) {
        if (bounceOffsetChangedListener != null) {
            this.mBounceOffsetChangedListeners.remove(bounceOffsetChangedListener);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
        if (NestedBounceParam.INSTANCE.isPullDownDebugOpen()) {
            Log.d(TAG, "requestDisallowInterceptTouchEvent() called with: disallowIntercept = " + disallowIntercept);
        }
    }

    public final void setAtEndWhenIntercept(boolean z16) {
        this.isAtEndWhenIntercept = z16;
    }

    public final void setAtStartWhenIntercept(boolean z16) {
        this.isAtStartWhenIntercept = z16;
    }

    public final void setBounce(boolean enable) {
        this.mIsEnabled = enable;
    }

    public final void setCustomNestedChild(@Nullable ICustomNestedChild iCustomNestedChild) {
        this.customNestedChild = iCustomNestedChild;
    }

    public final void setFlinging(boolean z16) {
        this.isFlinging = z16;
    }

    public final void setLastType(int i3) {
        this.lastType = i3;
    }

    public final void setMCompatScrollViewChild(@Nullable ScrollView scrollView) {
        this.mCompatScrollViewChild = scrollView;
    }

    public final void setMIsEnabled(boolean z16) {
        this.mIsEnabled = z16;
    }

    public final void setMOverscrollListener(@NotNull HorizontalOverScrollCallback horizontalOverScrollCallback) {
        Intrinsics.checkNotNullParameter(horizontalOverScrollCallback, "<set-?>");
        this.mOverscrollListener = horizontalOverScrollCallback;
    }

    public final void setMPullDownEnableFlag(int i3) {
        this.mPullDownEnableFlag = i3;
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IOverScroll
    public void setOffset(@Nullable View child, int offset) {
        String str;
        int i3;
        if (NestedBounceParam.INSTANCE.isPullDownDebugOpen()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[setOffset] offset:");
            sb5.append(offset);
            sb5.append(" child:");
            if (child != null) {
                str = child.getClass().getSimpleName();
            } else {
                str = null;
            }
            sb5.append(str);
            sb5.append('@');
            if (child != null) {
                i3 = child.hashCode();
            } else {
                i3 = 0;
            }
            sb5.append(i3);
            sb5.append('}');
            Log.i(TAG, sb5.toString());
        }
        this.scrollMode.setOffset(child, offset);
        Iterator it = this.mBounceOffsetChangedListeners.iterator();
        while (it.hasNext()) {
            ((IBounceView.BounceOffsetChangedListener) it.next()).onBounceOffsetChanged(offset);
        }
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IOverScroll
    public void springBack(@NotNull final View child) {
        boolean z16;
        Intrinsics.checkNotNullParameter(child, "child");
        if (NestedBounceParam.INSTANCE.isPullDownDebugOpen()) {
            Log.d(TAG, "springBack child:" + child.getClass().getSimpleName() + '@' + child.hashCode());
        }
        int offset = getOffset(child);
        if (offset == 0 || onSpringBack(this, child)) {
            return;
        }
        if (this.mSpringBackAnimator == null) {
            this.mSpringBackAnimator = ValueAnimator.ofInt(new int[0]);
        }
        ValueAnimator valueAnimator = this.mSpringBackAnimator;
        if (valueAnimator != null && valueAnimator.isStarted()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        ValueAnimator valueAnimator2 = this.mSpringBackAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator3 = this.mSpringBackAnimator;
        if (valueAnimator3 != null) {
            valueAnimator3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mm.ui.widget.pulldown.HorizontalNestedBounceView$springBack$1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(@NotNull ValueAnimator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    Object animatedValue = animation.getAnimatedValue();
                    Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
                    HorizontalNestedBounceView.this.setOffset(child, ((Integer) animatedValue).intValue());
                }
            });
        }
        float abs = ((Math.abs(offset) * 1.0f) / getMaxOffset(child)) * r0.getMaxSpringDuration();
        ValueAnimator valueAnimator4 = this.mSpringBackAnimator;
        if (valueAnimator4 != null) {
            valueAnimator4.setDuration(Math.max((int) abs, r0.getMinSpringDuration()));
        }
        ValueAnimator valueAnimator5 = this.mSpringBackAnimator;
        if (valueAnimator5 != null) {
            valueAnimator5.setInterpolator(this.mSpringBackInterpolator);
        }
        ValueAnimator valueAnimator6 = this.mSpringBackAnimator;
        if (valueAnimator6 != null) {
            valueAnimator6.setIntValues(offset, 0);
        }
        ValueAnimator valueAnimator7 = this.mSpringBackAnimator;
        if (valueAnimator7 != null) {
            valueAnimator7.start();
        }
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IOverScroll
    public void stopSpringBack(@NotNull View child) {
        ValueAnimator valueAnimator;
        Intrinsics.checkNotNullParameter(child, "child");
        ValueAnimator valueAnimator2 = this.mSpringBackAnimator;
        if (valueAnimator2 != null) {
            boolean z16 = true;
            if (!valueAnimator2.isRunning()) {
                z16 = false;
            }
            if (z16 && (valueAnimator = this.mSpringBackAnimator) != null) {
                valueAnimator.cancel();
            }
        }
        this.mOverscrollListener.onStopSpringingBack(this, child);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizontalNestedBounceView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mIsEnabled = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.NestedBounceView);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026yleable.NestedBounceView)");
        this.mIsEnabled = obtainStyledAttributes.getBoolean(R.styleable.NestedBounceView_isBounceEnable, true);
        obtainStyledAttributes.recycle();
        NestedBounceParam nestedBounceParam = NestedBounceParam.INSTANCE;
        this.mSpringBackInterpolator = new DecelerateInterpolator(nestedBounceParam.getDecelerateRatio());
        this.mPullDownEnableFlag = 3;
        this.mBounceOffsetChangedListeners = new LinkedList();
        this.mOverscrollListener = new HorizontalOverScrollCallback();
        this.scrollMode = nestedBounceParam.m165getHorizontalScrollMode();
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mParentHelper = new NestedScrollingParentHelper(this);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(@NotNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        Intrinsics.checkNotNullParameter(target, "target");
        a(target, dxUnconsumed, type, (int[]) null);
    }

    public int a(View target, int dx5, int dy5, int[] consumed, int type) {
        int offset;
        int i3;
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        HorizontalOverScrollCallback horizontalOverScrollCallback = this.mOverscrollListener;
        if (dx5 != 0) {
            if (dx5 < 0) {
                if (!horizontalOverScrollCallback.canScroll(this, this, this.mDirectionToEnd)) {
                    return 0;
                }
                i3 = getOffset(target);
                offset = 0;
            } else {
                if (!horizontalOverScrollCallback.canScroll(this, this, this.mDirectionToStart)) {
                    return 0;
                }
                offset = getOffset(target);
                i3 = 0;
            }
            if (i3 < offset) {
                return c(target, dx5, i3, offset);
            }
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(@NotNull View child, @NotNull View target, int nestedScrollAxes) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        return onStartNestedScroll(child, target, nestedScrollAxes, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(@NotNull View target, int dx5, int dy5, @NotNull int[] consumed) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        onNestedPreScroll(target, dx5, dy5, consumed, 0);
    }

    public final int a(View child, int distance) {
        float dampingFactor = getDampingFactor(this, child, distance > 0 ? this.mDirectionToStart : this.mDirectionToEnd);
        if (dampingFactor == 0.0f) {
            dampingFactor = 1.0f;
        }
        return (int) ((distance / dampingFactor) + 0.5f);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(@NotNull View child, @NotNull View target, int nestedScrollAxes) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        onNestedScrollAccepted(child, target, nestedScrollAxes, 0);
    }

    public final int a(View child, int newOffset, int minOffset, int maxOffset) {
        int offset = getOffset(child);
        int i3 = 0;
        if ((minOffset <= offset && offset <= maxOffset) && offset != (newOffset = MathUtils.clamp(newOffset, minOffset, maxOffset))) {
            setOffset(child, newOffset);
            i3 = offset - newOffset;
        }
        if (NestedBounceParam.INSTANCE.isPullDownDebugOpen()) {
            Log.i(TAG, "[computerOffset] newOffset:" + newOffset + " curOffset" + offset + " consumed:" + i3 + " minOffset:" + minOffset + " maxOffset:" + maxOffset);
        }
        return i3;
    }

    public void a(View target, int dxUnconsumed, int type, int[] consumed) {
        Intrinsics.checkNotNullParameter(target, "target");
        NestedBounceParam nestedBounceParam = NestedBounceParam.INSTANCE;
        if (nestedBounceParam.isPullDownDebugOpen()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[onNestedScrollInternal] dxUnconsumed:");
            sb5.append(dxUnconsumed);
            sb5.append(", type:");
            sb5.append(type);
            sb5.append(", consumed:");
            sb5.append(consumed != null ? ArraysKt___ArraysJvmKt.asList(consumed) : null);
            Log.i(TAG, sb5.toString());
        }
        this.isFlinging = false;
        HorizontalOverScrollCallback horizontalOverScrollCallback = this.mOverscrollListener;
        if (dxUnconsumed != 0) {
            requestDisallowInterceptTouchEvent(true);
        }
        if (dxUnconsumed < 0) {
            if (horizontalOverScrollCallback.canScroll(this, target, this.mDirectionToEnd)) {
                if (type == 0) {
                    b(target, dxUnconsumed, 0, getMaxOffset(target));
                    return;
                }
                OverScroller overScroller = this.mOverScroller;
                Boolean valueOf = overScroller != null ? Boolean.valueOf(overScroller.computeScrollOffset()) : null;
                Float valueOf2 = overScroller != null ? Float.valueOf(overScroller.getCurrVelocity()) : null;
                int maxFlingOffset = horizontalOverScrollCallback.getMaxFlingOffset(this, target, this.mDirectionToEnd);
                int offset = getOffset(target);
                int abs = Math.abs(horizontalOverScrollCallback.getMinFlingVelocity(this, target, this.mDirectionToEnd));
                if (overScroller != null && overScroller.computeScrollOffset() && Math.abs(overScroller.getCurrVelocity()) >= abs && offset < maxFlingOffset) {
                    b(target, dxUnconsumed, offset, horizontalOverScrollCallback.getMaxFlingOffset(this, target, this.mDirectionToEnd));
                    return;
                }
                if (nestedBounceParam.isPullDownDebugOpen()) {
                    Log.i(TAG, "[stopNestedScroll] when reach edge distanceUnconsumed:" + dxUnconsumed + " computeScrollOffset:" + valueOf + " curVelocity:" + valueOf2 + " minFlingVelocity:" + abs + " curOffset:" + offset + " maxFlingOffset:" + maxFlingOffset);
                }
                ViewCompat.stopNestedScroll(target, 1);
                if (overScroller != null) {
                    overScroller.forceFinished(true);
                    return;
                }
                return;
            }
            return;
        }
        if (dxUnconsumed <= 0 || !horizontalOverScrollCallback.canScroll(this, target, this.mDirectionToStart)) {
            return;
        }
        if (type == 0) {
            b(target, dxUnconsumed, getMinOffset(target), 0);
            return;
        }
        OverScroller overScroller2 = this.mOverScroller;
        if (overScroller2 != null && overScroller2.computeScrollOffset() && Math.abs(overScroller2.getCurrVelocity()) >= Math.abs(horizontalOverScrollCallback.getMinFlingVelocity(this, target, this.mDirectionToStart)) && getOffset(target) > horizontalOverScrollCallback.getMaxFlingOffset(this, target, this.mDirectionToStart)) {
            b(target, dxUnconsumed, horizontalOverScrollCallback.getMaxFlingOffset(this, target, this.mDirectionToStart), getOffset(target));
            return;
        }
        if (nestedBounceParam.isPullDownDebugOpen()) {
            Log.i(TAG, "[stopNestedScroll] when reach edge distanceUnconsumed:" + dxUnconsumed);
        }
        ViewCompat.stopNestedScroll(target, 1);
        if (overScroller2 != null) {
            overScroller2.forceFinished(true);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(@NotNull View target) {
        Intrinsics.checkNotNullParameter(target, "target");
        onStopNestedScroll(target, 0);
    }

    @IOverScrollCallback.ScrollDirection
    private static /* synthetic */ void getMDirectionToEnd$annotations() {
    }
}
