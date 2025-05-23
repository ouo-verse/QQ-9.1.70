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
import com.tencent.mtt.hippy.dom.node.NodeProps;
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
@Metadata(d1 = {"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00b8\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0004\u00b8\u0001\u00b9\u0001B!\u0012\b\u0010\u00b3\u0001\u001a\u00030\u00b2\u0001\u0012\f\b\u0002\u0010\u00b5\u0001\u001a\u0005\u0018\u00010\u00b4\u0001\u00a2\u0006\u0006\b\u00b6\u0001\u0010\u00b7\u0001J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\t\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J(\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0002J(\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0002J\u0018\u0010\t\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\fH\u0002J(\u0010\t\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0002J\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\bJ\u0012\u0010\u001c\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001d\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\bH\u0016J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\bH\u0016J\u0010\u0010!\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\bH\u0016J\u0014\u0010\"\u001a\u00020\b*\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0012\u0010#\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001e\u0010'\u001a\u00020\b2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\b2\u0006\u0010$\u001a\u00020\fH\u0014J\u0010\u0010)\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u0006H\u0016J\u000e\u0010*\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0006J(\u0010-\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020\fH\u0016J \u0010-\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010.\u001a\u00020\fH\u0016J(\u0010/\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020\fH\u0016J \u0010/\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010.\u001a\u00020\fH\u0016J\u0018\u00100\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010,\u001a\u00020\fH\u0016J\u0010\u00100\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\nH\u0016J0\u00105\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u00101\u001a\u00020\f2\u0006\u00102\u001a\u00020\f2\u0006\u00103\u001a\u00020\f2\u0006\u00104\u001a\u00020\fH\u0016J8\u00105\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u00101\u001a\u00020\f2\u0006\u00102\u001a\u00020\f2\u0006\u00103\u001a\u00020\f2\u0006\u00104\u001a\u00020\f2\u0006\u0010,\u001a\u00020\fH\u0016J0\u0010:\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u00106\u001a\u00020\f2\u0006\u00107\u001a\u00020\f2\u0006\u00109\u001a\u0002082\u0006\u0010,\u001a\u00020\fH\u0016J0\u0010\t\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u00106\u001a\u00020\f2\u0006\u00107\u001a\u00020\f2\u0006\u00109\u001a\u0002082\u0006\u0010,\u001a\u00020\fH\u0014J*\u0010\t\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u00104\u001a\u00020\f2\u0006\u0010,\u001a\u00020\f2\b\u00109\u001a\u0004\u0018\u000108H\u0014J(\u0010:\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u00106\u001a\u00020\f2\u0006\u00107\u001a\u00020\f2\u0006\u00109\u001a\u000208H\u0016J\b\u0010;\u001a\u00020\fH\u0016J(\u0010?\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020<2\u0006\u00109\u001a\u00020\bH\u0016J \u0010@\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020<H\u0016J\u001a\u0010B\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010A\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\u00112\u0006\u0010A\u001a\u00020\fH\u0004J\u0012\u0010C\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010D\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010E\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010F\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0010\u0010G\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016J \u0010J\u001a\u00020\b2\u0006\u0010H\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010I\u001a\u00020\fH\u0016J \u0010K\u001a\u00020\f2\u0006\u0010H\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010I\u001a\u00020\fH\u0016J \u0010L\u001a\u00020<2\u0006\u0010H\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010I\u001a\u00020\fH\u0016J \u0010M\u001a\u00020\f2\u0006\u0010H\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010I\u001a\u00020\fH\u0016J \u0010N\u001a\u00020\u00112\u0006\u0010H\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010A\u001a\u00020\fH\u0016J\u0018\u0010O\u001a\u00020\b2\u0006\u0010H\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0018\u0010P\u001a\u00020\u00112\u0006\u0010H\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\nH\u0016R\"\u0010V\u001a\u00020\b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0014\u0010Y\u001a\u00020W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010XR\u0018\u0010\\\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010[R\u0018\u0010_\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u001c\u0010d\u001a\u00020\f8\u0002@\u0002X\u0083\u000e\u00a2\u0006\f\n\u0004\b`\u0010a\u0012\u0004\bb\u0010cR\u0016\u0010f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010aR\u0018\u0010i\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010hR\"\u0010o\u001a\u00020\f8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bj\u0010a\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR$\u0010w\u001a\u0004\u0018\u00010p8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR \u0010}\u001a\b\u0012\u0004\u0012\u00020\u001a0x8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\by\u0010z\u001a\u0004\b{\u0010|R\u001b\u0010\u0083\u0001\u001a\u00020~8\u0006\u00a2\u0006\u000f\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0016\u0010\u0085\u0001\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0084\u0001\u0010aR\u0018\u0010\u0087\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0086\u0001\u0010QR\u0018\u0010\u0089\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0088\u0001\u0010QR\u0018\u0010\u008b\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008a\u0001\u0010QR\u0018\u0010\u008d\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008c\u0001\u0010aR,\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u008e\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u008f\u0001\u0010\u0090\u0001\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001\"\u0006\b\u0093\u0001\u0010\u0094\u0001R&\u0010\u0097\u0001\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0096\u0001\u0010Q\u001a\u0005\b\u0097\u0001\u0010S\"\u0005\b\u0098\u0001\u0010UR&\u0010\u009a\u0001\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0099\u0001\u0010Q\u001a\u0005\b\u009a\u0001\u0010S\"\u0005\b\u009b\u0001\u0010UR\u0017\u0010\u009c\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010aR\u0018\u0010\u009e\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u009d\u0001\u0010aR\u0018\u0010\u00a2\u0001\u001a\u00030\u009f\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a0\u0001\u0010\u00a1\u0001R&\u0010\u00a6\u0001\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u00a3\u0001\u0010a\u001a\u0005\b\u00a4\u0001\u0010l\"\u0005\b\u00a5\u0001\u0010nR&\u0010\u00a8\u0001\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u00a7\u0001\u0010Q\u001a\u0005\b\u00a8\u0001\u0010S\"\u0005\b\u00a9\u0001\u0010UR \u0010\u00ad\u0001\u001a\t\u0018\u00010\u00aa\u0001R\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ab\u0001\u0010\u00ac\u0001R&\u0010\u00b1\u0001\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u00ae\u0001\u0010a\u001a\u0005\b\u00af\u0001\u0010l\"\u0005\b\u00b0\u0001\u0010n\u00a8\u0006\u00ba\u0001"}, d2 = {"Lcom/tencent/mm/ui/widget/pulldown/NestedBounceView;", "Landroid/widget/FrameLayout;", "Landroidx/core/view/NestedScrollingParent2;", "Lcom/tencent/mm/ui/widget/pulldown/IBounceCommon;", "Lcom/tencent/mm/ui/widget/pulldown/IOverScroll;", "Lcom/tencent/mm/ui/widget/pulldown/IOverScrollCallback;", "Landroid/view/MotionEvent;", "ev", "", "a", "Landroid/view/View;", "target", "", "diff", "b", "Landroid/widget/OverScroller;", "overScroller", "", "child", Element.ELEMENT_NAME_DISTANCE, "minOffset", "maxOffset", "c", "newOffset", "enable", "setBounce", "Lcom/tencent/mm/ui/widget/pulldown/IBounceView$BounceOffsetChangedListener;", "bounceOffsetChangedListener", "addBounceOffsetChangedListener", "removeBounceOffsetChangedListener", "enableStart2End", "enableEnd2Start", "disallowIntercept", "requestDisallowInterceptTouchEvent", "contains", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "deltaY", "isAtStart", "isAtEnd", "checkScrollDirectionMatchEdge", "event", "onTouchEvent", "dispatchDownEventManually", "axes", "type", "onStartNestedScroll", "nestedScrollAxes", "onNestedScrollAccepted", "onStopNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScroll", "dx", "dy", "", "consumed", "onNestedPreScroll", "getNestedScrollAxes", "", "velocityX", "velocityY", "onNestedFling", "onNestedPreFling", "offset", "setOffset", "getOffset", "getMaxOffset", "getMinOffset", "stopSpringBack", "springBack", "overScroll", "scrollDirection", "canScroll", "getMaxFlingOffset", "getDampingFactor", "getMinFlingVelocity", "onOffsetChanged", "onSpringBack", "onStopSpringingBack", "Z", "getMIsEnabled", "()Z", "setMIsEnabled", "(Z)V", "mIsEnabled", "Landroid/view/animation/Interpolator;", "Landroid/view/animation/Interpolator;", "mSpringBackInterpolator", "Landroid/animation/ValueAnimator;", "Landroid/animation/ValueAnimator;", "mSpringBackAnimator", "d", "Landroid/widget/OverScroller;", "mOverScroller", "e", "I", "getMDirectionToEnd$annotations", "()V", "mDirectionToEnd", "f", "mDirectionToStart", "g", "Landroid/view/View;", "mCurNestedChild", h.F, "getMPullDownEnableFlag", "()I", "setMPullDownEnableFlag", "(I)V", "mPullDownEnableFlag", "Lcom/tencent/mm/ui/widget/pulldown/ICustomNestedChild;", "i", "Lcom/tencent/mm/ui/widget/pulldown/ICustomNestedChild;", "getCustomNestedChild", "()Lcom/tencent/mm/ui/widget/pulldown/ICustomNestedChild;", "setCustomNestedChild", "(Lcom/tencent/mm/ui/widget/pulldown/ICustomNestedChild;)V", "customNestedChild", "Ljava/util/LinkedList;", "j", "Ljava/util/LinkedList;", "getMBounceOffsetChangedListeners", "()Ljava/util/LinkedList;", "mBounceOffsetChangedListeners", "Lcom/tencent/mm/ui/widget/pulldown/SimpleOverScrollCallback;", "k", "Lcom/tencent/mm/ui/widget/pulldown/SimpleOverScrollCallback;", "getMOverscrollListener", "()Lcom/tencent/mm/ui/widget/pulldown/SimpleOverScrollCallback;", "mOverscrollListener", "l", "mTouchSlop", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mOverScrolling", BdhLogUtil.LogTag.Tag_Conn, "mIsScrolling", "D", "mDownEventCaptured", "E", "mLastY", "Landroid/widget/ScrollView;", UserInfo.SEX_FEMALE, "Landroid/widget/ScrollView;", "getMCompatScrollViewChild", "()Landroid/widget/ScrollView;", "setMCompatScrollViewChild", "(Landroid/widget/ScrollView;)V", "mCompatScrollViewChild", "G", "isAtStartWhenIntercept", "setAtStartWhenIntercept", "H", "isAtEndWhenIntercept", "setAtEndWhenIntercept", "mLastXForCheckScrolling", "J", "mLastYForCheckScrolling", "Landroidx/core/view/NestedScrollingParentHelper;", "K", "Landroidx/core/view/NestedScrollingParentHelper;", "mParentHelper", "L", "getLastType", "setLastType", "lastType", "M", "isFlinging", "setFlinging", "Lcom/tencent/mm/ui/widget/pulldown/NestedBounceView$FlingRunnable;", "N", "Lcom/tencent/mm/ui/widget/pulldown/NestedBounceView$FlingRunnable;", "mFlingRunnable", "O", "getLastOffset", "setLastOffset", "lastOffset", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", "FlingRunnable", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public class NestedBounceView extends FrameLayout implements NestedScrollingParent2, IBounceCommon, IOverScroll, IOverScrollCallback {
    public static final int FLAG_END_2_START = 2;
    public static final int FLAG_START_2_END = 1;

    @NotNull
    public static final String TAG = "PullDownParentView";

    /* renamed from: C, reason: from kotlin metadata */
    public boolean mIsScrolling;

    /* renamed from: D, reason: from kotlin metadata */
    public boolean mDownEventCaptured;

    /* renamed from: E, reason: from kotlin metadata */
    public int mLastY;

    /* renamed from: F, reason: from kotlin metadata */
    public ScrollView mCompatScrollViewChild;

    /* renamed from: G, reason: from kotlin metadata */
    public boolean isAtStartWhenIntercept;

    /* renamed from: H, reason: from kotlin metadata */
    public boolean isAtEndWhenIntercept;

    /* renamed from: I, reason: from kotlin metadata */
    public int mLastXForCheckScrolling;

    /* renamed from: J, reason: from kotlin metadata */
    public int mLastYForCheckScrolling;

    /* renamed from: K, reason: from kotlin metadata */
    public final NestedScrollingParentHelper mParentHelper;

    /* renamed from: L, reason: from kotlin metadata */
    public int lastType;

    /* renamed from: M, reason: from kotlin metadata */
    public boolean isFlinging;

    /* renamed from: N, reason: from kotlin metadata */
    public FlingRunnable mFlingRunnable;

    /* renamed from: O, reason: from kotlin metadata */
    public int lastOffset;

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
    public final SimpleOverScrollCallback mOverscrollListener;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final int mTouchSlop;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public boolean mOverScrolling;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0004\u001a\u00020\u0002R\u0017\u0010\n\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mm/ui/widget/pulldown/NestedBounceView$FlingRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "start", "Landroid/widget/OverScroller;", "a", "Landroid/widget/OverScroller;", "getMScroller", "()Landroid/widget/OverScroller;", "mScroller", "Landroid/view/View;", "b", "Landroid/view/View;", "getTarget", "()Landroid/view/View;", "target", "", "c", "I", "mLastFlingY", "<init>", "(Lcom/tencent/mm/ui/widget/pulldown/NestedBounceView;Landroid/widget/OverScroller;Landroid/view/View;)V", "weui-native-android-lib_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public final class FlingRunnable implements Runnable {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final OverScroller mScroller;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final View target;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public int mLastFlingY;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ NestedBounceView f153776d;

        public FlingRunnable(@NotNull NestedBounceView nestedBounceView, @NotNull OverScroller mScroller, View target) {
            Intrinsics.checkNotNullParameter(mScroller, "mScroller");
            Intrinsics.checkNotNullParameter(target, "target");
            this.f153776d = nestedBounceView;
            this.mScroller = mScroller;
            this.target = target;
            this.mLastFlingY = mScroller.getCurrY();
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
            int currY = overScroller.getCurrY();
            int i3 = currY - this.mLastFlingY;
            View view = this.target;
            if ((view instanceof AbsListView) || (view instanceof ScrollView)) {
                if (NestedBounceParam.INSTANCE.isPullDownDebugOpen()) {
                    Log.i(NestedBounceView.TAG, "[fling] hasMore:" + computeScrollOffset + " velocity:" + overScroller.getCurrVelocity() + " delta:" + i3 + " mLastFlingY:" + this.mLastFlingY + " y:" + currY + " isAtStart:" + WeUIBounceCommonKt.isAtStart(this.target) + " isAtEnd:" + WeUIBounceCommonKt.isAtEnd(this.target));
                }
                if (computeScrollOffset) {
                    if (i3 < 0 && WeUIBounceCommonKt.isAtStart(this.target)) {
                        this.f153776d.a(this.target, i3, 1, new int[2]);
                    } else if (i3 > 0 && WeUIBounceCommonKt.isAtEnd(this.target)) {
                        this.f153776d.a(this.target, i3, 1, new int[2]);
                    }
                    this.mLastFlingY = currY;
                    this.f153776d.postOnAnimation(this);
                    return;
                }
                this.f153776d.onStopNestedScroll(this.target, 1);
            }
        }

        public final void start() {
            this.mLastFlingY = this.mScroller.getCurrY();
            this.f153776d.postOnAnimation(this);
        }
    }

    public /* synthetic */ NestedBounceView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    private final int c(View child, int distance, int minOffset, int maxOffset) {
        return a(child, getOffset(child) - distance, minOffset, maxOffset);
    }

    public final boolean a(MotionEvent ev5) {
        if (this.mIsScrolling) {
            this.mLastYForCheckScrolling = ev5 != null ? (int) ev5.getY() : 0;
            return this.mIsScrolling;
        }
        Integer valueOf = ev5 != null ? Integer.valueOf(ev5.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            this.mLastXForCheckScrolling = (int) ev5.getX();
            this.mLastYForCheckScrolling = (int) ev5.getY();
            return false;
        }
        if (valueOf == null || valueOf.intValue() != 2) {
            return false;
        }
        int x16 = (int) ev5.getX();
        int y16 = (int) ev5.getY();
        int i3 = x16 - this.mLastXForCheckScrolling;
        int i16 = y16 - this.mLastYForCheckScrolling;
        return Math.abs(i16) > this.mTouchSlop && Math.abs(i16) > Math.abs(i3);
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IBounceCommon
    public void addBounceOffsetChangedListener(@Nullable IBounceView.BounceOffsetChangedListener bounceOffsetChangedListener) {
        if (bounceOffsetChangedListener != null && !this.mBounceOffsetChangedListeners.contains(bounceOffsetChangedListener)) {
            this.mBounceOffsetChangedListeners.add(bounceOffsetChangedListener);
        }
    }

    public final int b(View target, int diff) {
        int offset = getOffset(target);
        int i3 = offset - diff;
        if (offset != 0) {
            return (offset < 0) != (i3 < 0) ? (i3 <= 0 || !this.isAtStartWhenIntercept) ? (i3 >= 0 || !this.isAtEndWhenIntercept) ? offset + 0 : diff : diff : diff;
        }
        if (i3 > 0 && this.isAtStartWhenIntercept) {
            return diff;
        }
        if (i3 >= 0 || !this.isAtEndWhenIntercept) {
            return 0;
        }
        return diff;
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IOverScrollCallback
    public boolean canScroll(@NotNull IOverScroll overScroll, @NotNull View child, int scrollDirection) {
        Intrinsics.checkNotNullParameter(overScroll, "overScroll");
        Intrinsics.checkNotNullParameter(child, "child");
        return this.mOverscrollListener.canScroll(overScroll, child, scrollDirection);
    }

    public final boolean checkScrollDirectionMatchEdge(int deltaY, boolean isAtStart, boolean isAtEnd) {
        if ((deltaY > 0 && isAtStart) || (deltaY < 0 && isAtEnd)) {
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

    public final int getLastOffset() {
        return this.lastOffset;
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
    public final SimpleOverScrollCallback getMOverscrollListener() {
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
        return NestedBounceParam.INSTANCE.getOverScrollMode().getMaxOffset(child);
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IOverScrollCallback
    public int getMinFlingVelocity(@NotNull IOverScroll overScroll, @NotNull View child, int scrollDirection) {
        Intrinsics.checkNotNullParameter(overScroll, "overScroll");
        Intrinsics.checkNotNullParameter(child, "child");
        return this.mOverscrollListener.getMinFlingVelocity(overScroll, child, scrollDirection);
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IOverScroll
    public int getMinOffset(@Nullable View child) {
        return NestedBounceParam.INSTANCE.getOverScrollMode().getMinOffset(child);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IOverScroll
    public int getOffset(@Nullable View child) {
        return NestedBounceParam.INSTANCE.getOverScrollMode().getOffset(child);
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

    /* JADX WARN: Code restructure failed: missing block: B:121:0x0082, code lost:
    
        if (r0 == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x006a, code lost:
    
        if (r0 != false) goto L67;
     */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01ec  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(@Nullable MotionEvent ev5) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        int i3;
        boolean z36;
        boolean z37;
        boolean z38;
        View view = this.mCurNestedChild;
        boolean z39 = true;
        int i16 = 0;
        if (!(view instanceof AbsListView) && !(view instanceof ScrollView)) {
            z16 = false;
        } else {
            z16 = true;
        }
        ScrollView scrollView = this.mCompatScrollViewChild;
        if (scrollView != null && view == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z16 && !z17) {
            z18 = false;
        } else {
            z18 = true;
        }
        ICustomNestedChild iCustomNestedChild = this.customNestedChild;
        if (iCustomNestedChild != null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (this.mIsEnabled && (z18 || z19)) {
            Integer num = null;
            if (z18) {
                if (!z16) {
                    if (z17) {
                        if (scrollView != null && contains(scrollView, ev5)) {
                            z37 = true;
                        } else {
                            z37 = false;
                        }
                        if (z37) {
                            ScrollView scrollView2 = this.mCompatScrollViewChild;
                            if (scrollView2 != null && scrollView2.getVisibility() == 0) {
                                z38 = true;
                            } else {
                                z38 = false;
                            }
                            if (z38) {
                                view = this.mCompatScrollViewChild;
                            }
                        }
                    }
                    view = null;
                }
                if (view != null) {
                    z26 = WeUIBounceCommonKt.isAtStart(view);
                } else {
                    z26 = false;
                }
                if (view != null) {
                    z27 = WeUIBounceCommonKt.isAtEnd(view);
                } else {
                    z27 = false;
                }
                if (z26) {
                }
                z28 = false;
            } else {
                if (iCustomNestedChild != null) {
                    z26 = iCustomNestedChild.isAtStart();
                } else {
                    z26 = false;
                }
                ICustomNestedChild iCustomNestedChild2 = this.customNestedChild;
                if (iCustomNestedChild2 != null) {
                    z27 = iCustomNestedChild2.isAtEnd();
                } else {
                    z27 = false;
                }
                if (!z26) {
                }
                z28 = true;
            }
            this.mIsScrolling = a(ev5);
            NestedBounceParam nestedBounceParam = NestedBounceParam.INSTANCE;
            if (nestedBounceParam.isPullDownDebugOpen()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[onInterceptTouchEvent] action:");
                if (ev5 != null) {
                    i3 = ev5.getAction();
                } else {
                    i3 = -1;
                }
                sb5.append(MotionEvent.actionToString(i3));
                sb5.append(" isAtStart:");
                sb5.append(z26);
                sb5.append(" isAtEnd:");
                sb5.append(z27);
                sb5.append(" isScrollOver:");
                sb5.append(z28);
                sb5.append(" mIsScrolling:");
                sb5.append(this.mIsScrolling);
                sb5.append(" hasCompactView:");
                sb5.append(z18);
                sb5.append(" isCompactView:");
                sb5.append(z16);
                sb5.append(" isCompactScrollView:");
                sb5.append(z17);
                sb5.append(" mCurNestedChild!=null\uff1a");
                if (this.mCurNestedChild != null) {
                    z36 = true;
                } else {
                    z36 = false;
                }
                sb5.append(z36);
                Log.i(TAG, sb5.toString());
            }
            if (z28) {
                if (ev5 != null) {
                    num = Integer.valueOf(ev5.getAction());
                }
                if (num != null && num.intValue() == 0) {
                    this.mOverScrolling = false;
                    this.mDownEventCaptured = true;
                } else {
                    if (num != null && num.intValue() == 2) {
                        if (this.mOverScrolling) {
                            if (nestedBounceParam.isPullDownDebugOpen()) {
                                Log.i(TAG, "[onInterceptTouchEvent] return true when move and overscroll");
                            }
                        } else if (!this.mDownEventCaptured) {
                            this.mOverScrolling = false;
                            this.mDownEventCaptured = true;
                        } else {
                            int y16 = (int) ev5.getY();
                            int i17 = y16 - this.mLastY;
                            if (this.mIsScrolling && checkScrollDirectionMatchEdge(i17, z26, z27) && a(i17)) {
                                z29 = true;
                            } else {
                                z29 = false;
                            }
                            if (nestedBounceParam.isPullDownDebugOpen()) {
                                Log.i(TAG, "[onInterceptTouchEvent] move res:" + z29 + " dy:" + i17 + " mLast:" + this.mLastY + " currentY:" + y16);
                            }
                            if (z29) {
                                this.mLastY = y16;
                                this.mOverScrolling = true;
                                this.mDownEventCaptured = false;
                                this.isAtStartWhenIntercept = z26;
                                this.isAtEndWhenIntercept = z27;
                            }
                            z39 = z29;
                        }
                        if (ev5 != null) {
                            i16 = (int) ev5.getY();
                        }
                        this.mLastY = i16;
                        if (nestedBounceParam.isPullDownDebugOpen()) {
                            Log.i(TAG, "[onInterceptTouchEvent] return res:" + z39 + " mOverScrolling :" + this.mOverScrolling + " mLastY:" + this.mLastY);
                        }
                        return z39;
                    }
                    if ((num == null || num.intValue() != 3) && (num == null || num.intValue() != 1)) {
                        z39 = false;
                    }
                    if (z39) {
                        this.mOverScrolling = false;
                        this.mDownEventCaptured = false;
                        this.mIsScrolling = false;
                        if (nestedBounceParam.isPullDownDebugOpen()) {
                            Log.i(TAG, "[onInterceptTouchEvent] return false when cancel and action up");
                        }
                    } else {
                        z39 = this.mOverScrolling;
                        if (ev5 != null) {
                        }
                        this.mLastY = i16;
                        if (nestedBounceParam.isPullDownDebugOpen()) {
                        }
                        return z39;
                    }
                }
                z39 = false;
                if (ev5 != null) {
                }
                this.mLastY = i16;
                if (nestedBounceParam.isPullDownDebugOpen()) {
                }
                return z39;
            }
            if (ev5 != null) {
                i16 = (int) ev5.getY();
            }
            this.mLastY = i16;
        }
        return super.onInterceptTouchEvent(ev5);
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
        try {
            OverScroller overScroller = this.mOverScroller;
            if (overScroller != null) {
                overScroller.fling(0, 0, 0, (int) velocityY, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        } catch (Throwable th5) {
            Log.e(TAG, "onNestedPreFling err e:" + th5);
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
        int i3 = consumed[1];
        int a16 = a(target, dx5, dy5, consumed, type);
        consumed[1] = a16;
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
        return (axes & 2) != 0;
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
                sb5.append(" velocity:");
                sb5.append(overScroller != null ? Float.valueOf(overScroller.getCurrVelocity()) : null);
                sb5.append(" delta:");
                sb5.append((overScroller != null ? overScroller.getCurrY() : 0) - (overScroller != null ? overScroller.getStartY() : 0));
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

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0053, code lost:
    
        if (r1 != 3) goto L52;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        View view;
        View view2;
        Intrinsics.checkNotNullParameter(event, "event");
        NestedBounceParam nestedBounceParam = NestedBounceParam.INSTANCE;
        if (nestedBounceParam.isPullDownDebugOpen()) {
            Log.i(TAG, "[onTouchEvent] action:" + MotionEvent.actionToString(event.getAction()));
        }
        if (event.getAction() == 0 && event.getEdgeFlags() != 0) {
            if (nestedBounceParam.isPullDownDebugOpen()) {
                Log.i(TAG, "[onTouchEvent] return false when MotionEvent.ACTION_DOWN && event.edgeFlags != 0");
            }
            return false;
        }
        int action = event.getAction();
        if (action != 1) {
            if (action == 2) {
                if (this.mOverScrolling) {
                    if (!this.mDownEventCaptured) {
                        this.mLastY = (int) event.getY();
                        this.mDownEventCaptured = true;
                        stopSpringBack(this);
                        OverScroller overScroller = this.mOverScroller;
                        if (overScroller != null) {
                            overScroller.forceFinished(true);
                        }
                        if (nestedBounceParam.isPullDownDebugOpen()) {
                            Log.i(TAG, "[onTouchEvent] return true in ACTION_MOVE when mDownEventCaptured == false");
                        }
                        return true;
                    }
                    int y16 = this.mLastY - ((int) event.getY());
                    this.mLastY = (int) event.getY();
                    ICustomNestedChild iCustomNestedChild = this.customNestedChild;
                    if (iCustomNestedChild == null || (view2 = iCustomNestedChild.customView()) == null) {
                        view2 = this;
                    }
                    int b16 = b(view2, y16);
                    if (b16 != y16) {
                        dispatchDownEventManually(event);
                    }
                    int a16 = b16 - a(view2, 0, b16, new int[2], 0);
                    if (a16 != 0) {
                        a(view2, a16, 0, new int[2]);
                    }
                    if (nestedBounceParam.isPullDownDebugOpen()) {
                        Log.i(TAG, "[onTouchEvent] real diff:" + b16 + " left diff:" + a16);
                    }
                    return true;
                }
            }
            return super.onTouchEvent(event);
        }
        this.mDownEventCaptured = false;
        this.mOverScrolling = false;
        this.mIsScrolling = false;
        ICustomNestedChild iCustomNestedChild2 = this.customNestedChild;
        if (iCustomNestedChild2 == null || (view = iCustomNestedChild2.customView()) == null) {
            view = this;
        }
        onStopNestedScroll(view, 0);
        return super.onTouchEvent(event);
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

    public final void setLastOffset(int i3) {
        this.lastOffset = i3;
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

    public final void setMPullDownEnableFlag(int i3) {
        this.mPullDownEnableFlag = i3;
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IOverScroll
    public void setOffset(@Nullable View child, int offset) {
        String str;
        int i3;
        NestedBounceParam nestedBounceParam = NestedBounceParam.INSTANCE;
        if (nestedBounceParam.isPullDownDebugOpen()) {
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
        nestedBounceParam.getOverScrollMode().setOffset(child, offset);
        b(offset);
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IOverScroll
    public void springBack(@NotNull final View child) {
        Boolean bool;
        boolean z16;
        Intrinsics.checkNotNullParameter(child, "child");
        int offset = getOffset(child);
        ValueAnimator valueAnimator = this.mSpringBackAnimator;
        if (valueAnimator != null) {
            bool = Boolean.valueOf(valueAnimator.isRunning());
        } else {
            bool = null;
        }
        if (NestedBounceParam.INSTANCE.isPullDownDebugOpen()) {
            Log.d(TAG, "sooontest springBack child:" + child.getClass().getSimpleName() + '@' + child.hashCode() + " startOffset:" + offset + " isRunning:" + bool);
        }
        if (offset == 0 || onSpringBack(this, child)) {
            return;
        }
        if (this.mSpringBackAnimator == null) {
            this.mSpringBackAnimator = ValueAnimator.ofInt(new int[0]);
        }
        ValueAnimator valueAnimator2 = this.mSpringBackAnimator;
        if (valueAnimator2 != null && valueAnimator2.isStarted()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        ValueAnimator valueAnimator3 = this.mSpringBackAnimator;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator4 = this.mSpringBackAnimator;
        if (valueAnimator4 != null) {
            valueAnimator4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mm.ui.widget.pulldown.NestedBounceView$springBack$1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(@NotNull ValueAnimator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    Object animatedValue = animation.getAnimatedValue();
                    Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
                    NestedBounceView.this.setOffset(child, ((Integer) animatedValue).intValue());
                }
            });
        }
        float abs = ((Math.abs(offset) * 1.0f) / getMaxOffset(child)) * r2.getMaxSpringDuration();
        ValueAnimator valueAnimator5 = this.mSpringBackAnimator;
        if (valueAnimator5 != null) {
            valueAnimator5.setDuration(Math.max((int) abs, r2.getMinSpringDuration()));
        }
        ValueAnimator valueAnimator6 = this.mSpringBackAnimator;
        if (valueAnimator6 != null) {
            valueAnimator6.setInterpolator(this.mSpringBackInterpolator);
        }
        ValueAnimator valueAnimator7 = this.mSpringBackAnimator;
        if (valueAnimator7 != null) {
            valueAnimator7.setIntValues(offset, 0);
        }
        ValueAnimator valueAnimator8 = this.mSpringBackAnimator;
        if (valueAnimator8 != null) {
            valueAnimator8.start();
        }
    }

    @Override // com.tencent.mm.ui.widget.pulldown.IOverScroll
    public void stopSpringBack(@NotNull View child) {
        ValueAnimator valueAnimator;
        Intrinsics.checkNotNullParameter(child, "child");
        ValueAnimator valueAnimator2 = this.mSpringBackAnimator;
        if (valueAnimator2 != null) {
            Boolean valueOf = Boolean.valueOf(valueAnimator2.isRunning());
            if (NestedBounceParam.INSTANCE.isPullDownDebugOpen()) {
                Log.d(TAG, "stopSpringBack isSpringRunning:" + valueOf);
            }
            if (Intrinsics.areEqual(valueOf, Boolean.TRUE) && (valueAnimator = this.mSpringBackAnimator) != null) {
                valueAnimator.cancel();
            }
        }
        this.mOverscrollListener.onStopSpringingBack(this, child);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedBounceView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mIsEnabled = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.NestedBounceView);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026yleable.NestedBounceView)");
        this.mIsEnabled = obtainStyledAttributes.getBoolean(R.styleable.NestedBounceView_isBounceEnable, true);
        obtainStyledAttributes.recycle();
        this.mSpringBackInterpolator = new DecelerateInterpolator(NestedBounceParam.INSTANCE.getDecelerateRatio());
        this.mPullDownEnableFlag = 3;
        this.mBounceOffsetChangedListeners = new LinkedList();
        this.mOverscrollListener = new SimpleOverScrollCallback();
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mParentHelper = new NestedScrollingParentHelper(this);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(@NotNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        Intrinsics.checkNotNullParameter(target, "target");
        a(target, dyUnconsumed, type, (int[]) null);
    }

    private final int b(View child, int distance, int minOffset, int maxOffset) {
        return a(child, getOffset(child) - a(child, distance), minOffset, maxOffset);
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

    public final void b(int offset) {
        if (offset != 0 && this.lastOffset == 0) {
            int i3 = offset > 0 ? 1 : 0;
            Iterator it = this.mBounceOffsetChangedListeners.iterator();
            while (it.hasNext()) {
                ((IBounceView.BounceOffsetChangedListener) it.next()).onBounceStart(i3);
            }
        }
        this.lastOffset = offset;
        Iterator it5 = this.mBounceOffsetChangedListeners.iterator();
        while (it5.hasNext()) {
            ((IBounceView.BounceOffsetChangedListener) it5.next()).onBounceOffsetChanged(offset);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(@NotNull View child, @NotNull View target, int nestedScrollAxes) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        onNestedScrollAccepted(child, target, nestedScrollAxes, 0);
    }

    public boolean a(int deltaY) {
        if (deltaY <= 0 || (this.mPullDownEnableFlag & 1) == 0) {
            return deltaY < 0 && (this.mPullDownEnableFlag & 2) != 0;
        }
        return true;
    }

    private final void a(OverScroller overScroller, View target) {
        if (this.mFlingRunnable == null) {
            this.mFlingRunnable = new FlingRunnable(this, overScroller, target);
        }
        FlingRunnable flingRunnable = this.mFlingRunnable;
        if (flingRunnable != null) {
            flingRunnable.start();
        }
    }

    public int a(View target, int dx5, int dy5, int[] consumed, int type) {
        int offset;
        int i3;
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        SimpleOverScrollCallback simpleOverScrollCallback = this.mOverscrollListener;
        if (dy5 != 0) {
            if (dy5 < 0) {
                if (!simpleOverScrollCallback.canScroll(this, this, this.mDirectionToEnd)) {
                    return 0;
                }
                i3 = getOffset(target);
                offset = 0;
            } else {
                if (!simpleOverScrollCallback.canScroll(this, this, this.mDirectionToStart)) {
                    return 0;
                }
                offset = getOffset(target);
                i3 = 0;
            }
            if (i3 < offset) {
                return c(target, dy5, i3, offset);
            }
        }
        return 0;
    }

    private final int a(View child, int distance) {
        float dampingFactor = getDampingFactor(this, child, distance > 0 ? this.mDirectionToStart : this.mDirectionToEnd);
        if (dampingFactor == 0.0f) {
            dampingFactor = 1.0f;
        }
        return (int) ((distance / dampingFactor) + 0.5f);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(@NotNull View target) {
        Intrinsics.checkNotNullParameter(target, "target");
        onStopNestedScroll(target, 0);
    }

    private final int a(View child, int newOffset, int minOffset, int maxOffset) {
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

    @IOverScrollCallback.ScrollDirection
    private static /* synthetic */ void getMDirectionToEnd$annotations() {
    }

    public void a(View target, int dyUnconsumed, int type, int[] consumed) {
        Intrinsics.checkNotNullParameter(target, "target");
        NestedBounceParam nestedBounceParam = NestedBounceParam.INSTANCE;
        if (nestedBounceParam.isPullDownDebugOpen()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[onNestedScrollInternal] dyUnconsumed:");
            sb5.append(dyUnconsumed);
            sb5.append(", type:");
            sb5.append(type);
            sb5.append(", consumed:");
            sb5.append(consumed != null ? ArraysKt___ArraysJvmKt.asList(consumed) : null);
            Log.i(TAG, sb5.toString());
        }
        this.isFlinging = false;
        SimpleOverScrollCallback simpleOverScrollCallback = this.mOverscrollListener;
        if (dyUnconsumed != 0) {
            requestDisallowInterceptTouchEvent(true);
        }
        if (dyUnconsumed < 0) {
            if (simpleOverScrollCallback.canScroll(this, target, this.mDirectionToEnd)) {
                if (type == 0) {
                    b(target, dyUnconsumed, 0, getMaxOffset(target));
                    return;
                }
                OverScroller overScroller = this.mOverScroller;
                Boolean valueOf = overScroller != null ? Boolean.valueOf(overScroller.computeScrollOffset()) : null;
                Float valueOf2 = overScroller != null ? Float.valueOf(overScroller.getCurrVelocity()) : null;
                int maxFlingOffset = simpleOverScrollCallback.getMaxFlingOffset(this, target, this.mDirectionToEnd);
                int offset = getOffset(target);
                int abs = Math.abs(simpleOverScrollCallback.getMinFlingVelocity(this, target, this.mDirectionToEnd));
                if (overScroller != null && overScroller.computeScrollOffset() && Math.abs(overScroller.getCurrVelocity()) >= abs && offset < maxFlingOffset) {
                    b(target, dyUnconsumed, offset, simpleOverScrollCallback.getMaxFlingOffset(this, target, this.mDirectionToEnd));
                    return;
                }
                if (nestedBounceParam.isPullDownDebugOpen()) {
                    Log.i(TAG, "[stopNestedScroll] when reach edge distanceUnconsumed:" + dyUnconsumed + " computeScrollOffset:" + valueOf + " curVelocity:" + valueOf2 + " minFlingVelocity:" + abs + " curOffset:" + offset + " maxFlingOffset:" + maxFlingOffset);
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
        if (dyUnconsumed <= 0 || !simpleOverScrollCallback.canScroll(this, target, this.mDirectionToStart)) {
            return;
        }
        if (type == 0) {
            b(target, dyUnconsumed, getMinOffset(target), 0);
            return;
        }
        OverScroller overScroller2 = this.mOverScroller;
        if (overScroller2 != null && overScroller2.computeScrollOffset() && Math.abs(overScroller2.getCurrVelocity()) >= Math.abs(simpleOverScrollCallback.getMinFlingVelocity(this, target, this.mDirectionToStart)) && getOffset(target) > simpleOverScrollCallback.getMaxFlingOffset(this, target, this.mDirectionToStart)) {
            b(target, dyUnconsumed, simpleOverScrollCallback.getMaxFlingOffset(this, target, this.mDirectionToStart), getOffset(target));
            return;
        }
        if (nestedBounceParam.isPullDownDebugOpen()) {
            Log.i(TAG, "[stopNestedScroll] when reach edge distanceUnconsumed:" + dyUnconsumed);
        }
        ViewCompat.stopNestedScroll(target, 1);
        if (overScroller2 != null) {
            overScroller2.forceFinished(true);
        }
    }
}
