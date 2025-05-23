package com.tencent.sqshow.zootopia.friendsdressup.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.apiv3.data.Element;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.av.business.manager.magicface.MagicfaceDataPendantJason;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u0081\u00012\u00020\u0001:\u0004\u0082\u0001\u0083\u0001B(\b\u0007\u0012\u0006\u0010{\u001a\u00020z\u0012\n\b\u0002\u0010}\u001a\u0004\u0018\u00010|\u0012\b\b\u0002\u0010~\u001a\u00020\r\u00a2\u0006\u0005\b\u007f\u0010\u0080\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J$\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u0007H\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002JI\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00020\u00162\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001bH\u0002J\u001a\u0010 \u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00132\b\b\u0002\u0010\u001f\u001a\u00020\u0007H\u0002J\u0010\u0010!\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0013H\u0002J\u000e\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"J\u0016\u0010)\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'J0\u0010/\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\rH\u0014J\u0010\u00101\u001a\u00020\u00072\u0006\u00100\u001a\u00020\nH\u0016J\u0012\u00103\u001a\u00020\u00072\b\u00102\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u00104\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u000e\u00106\u001a\u00020\u00022\u0006\u00105\u001a\u00020\rJ\b\u00107\u001a\u00020\u0002H\u0014R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010;\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010:R\u0016\u0010=\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010:R\u0016\u0010?\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010:R\u0016\u0010A\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010:R\u0016\u0010C\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010:R#\u0010J\u001a\n E*\u0004\u0018\u00010D0D8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u001b\u0010N\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bK\u0010G\u001a\u0004\bL\u0010MR$\u0010V\u001a\u0004\u0018\u00010O8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0016\u0010X\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010WR$\u0010\\\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00050Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010^\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010:R\u0016\u0010_\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010:R\u0016\u0010a\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010:R\u0016\u0010c\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010:R\u0016\u0010e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010WR\u0016\u0010h\u001a\u00020f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010`R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010o\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010nR\"\u0010u\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bp\u0010n\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u0014\u0010y\u001a\u00020v8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bw\u0010x\u00a8\u0006\u0084\u0001"}, d2 = {"Lcom/tencent/sqshow/zootopia/friendsdressup/widget/RollingFrameViewGroup;", "Landroid/widget/FrameLayout;", "", HippyTKDListViewAdapter.X, "w", "Landroid/view/View;", "p", "", DomainData.DOMAIN_NAME, "o", "Landroid/view/MotionEvent;", "event", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "curPos", "scrollLeft", MagicfaceDataPendantJason.BELONG_TO_BOTH, "B", "y", "", "start", "end", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "invoke", "Lkotlin/Function0;", "complete", "l", Element.ELEMENT_NAME_DISTANCE, "notify", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/sqshow/zootopia/friendsdressup/widget/e;", "rollingFrameScrollListener", "setRollingFrameScrollListener", "Lcom/tencent/sqshow/zootopia/friendsdressup/widget/RollingFrameViewGroup$a;", "adapter", "Lcom/tencent/sqshow/zootopia/friendsdressup/widget/c;", "scrollListener", "setAdapter", "changed", "left", "top", "right", "bottom", "onLayout", "e", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "ev", "dispatchTouchEvent", "onTouchEvent", "position", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, NodeProps.ON_DETACHED_FROM_WINDOW, "d", "Lcom/tencent/sqshow/zootopia/friendsdressup/widget/e;", UserInfo.SEX_FEMALE, "scrollDistance", "f", "lastTouchX", h.F, "lastTouchY", "i", "initialTouchX", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "initialTouchY", "Landroid/view/ViewConfiguration;", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "t", "()Landroid/view/ViewConfiguration;", "viewConfig", "D", ReportConstant.COSTREPORT_PREFIX, "()I", "touchSlop", "Landroid/animation/ValueAnimator;", "E", "Landroid/animation/ValueAnimator;", "r", "()Landroid/animation/ValueAnimator;", "setMoveAnimator", "(Landroid/animation/ValueAnimator;)V", "moveAnimator", "I", "mScrollPointerId", "", "G", "Ljava/util/Map;", "rollingChildren", "H", "maxScrollDistance", "firstInitDetail", "J", "secondInitDetail", "K", "thirdInitDetail", "L", "curPosition", "", "M", "changeTime", "N", "Lcom/tencent/sqshow/zootopia/friendsdressup/widget/RollingFrameViewGroup$a;", "P", "Lcom/tencent/sqshow/zootopia/friendsdressup/widget/c;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Z", "firstInitSet", BdhLogUtil.LogTag.Tag_Req, "getIgnoreTouch", "()Z", "setIgnoreTouch", "(Z)V", "ignoreTouch", "Lcom/tencent/sqshow/zootopia/friendsdressup/widget/a;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/sqshow/zootopia/friendsdressup/widget/a;", "scrollInterpolator", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "T", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class RollingFrameViewGroup extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy viewConfig;

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy touchSlop;

    /* renamed from: E, reason: from kotlin metadata */
    private ValueAnimator moveAnimator;

    /* renamed from: F, reason: from kotlin metadata */
    private int mScrollPointerId;

    /* renamed from: G, reason: from kotlin metadata */
    private Map<Integer, View> rollingChildren;

    /* renamed from: H, reason: from kotlin metadata */
    private float maxScrollDistance;

    /* renamed from: I, reason: from kotlin metadata */
    private float firstInitDetail;

    /* renamed from: J, reason: from kotlin metadata */
    private float secondInitDetail;

    /* renamed from: K, reason: from kotlin metadata */
    private float thirdInitDetail;

    /* renamed from: L, reason: from kotlin metadata */
    private int curPosition;

    /* renamed from: M, reason: from kotlin metadata */
    private long changeTime;

    /* renamed from: N, reason: from kotlin metadata */
    private a adapter;

    /* renamed from: P, reason: from kotlin metadata */
    private com.tencent.sqshow.zootopia.friendsdressup.widget.c scrollListener;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean firstInitSet;

    /* renamed from: R, reason: from kotlin metadata */
    private boolean ignoreTouch;

    /* renamed from: S, reason: from kotlin metadata */
    private final com.tencent.sqshow.zootopia.friendsdressup.widget.a scrollInterpolator;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private e rollingFrameScrollListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float scrollDistance;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float lastTouchX;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float lastTouchY;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float initialTouchX;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float initialTouchY;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH&J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0006H&J\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004R\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/sqshow/zootopia/friendsdressup/widget/RollingFrameViewGroup$a;", "", "Lcom/tencent/sqshow/zootopia/friendsdressup/widget/RollingFrameViewGroup;", VipFunCallConstants.KEY_GROUP, "", "a", "", "b", "Landroid/view/ViewGroup;", "viewGroup", "Landroid/view/View;", "f", "view", "position", "e", "d", "c", "Lcom/tencent/sqshow/zootopia/friendsdressup/widget/RollingFrameViewGroup;", "rollingFrameViewGroup", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private RollingFrameViewGroup rollingFrameViewGroup;

        public final void a(RollingFrameViewGroup group) {
            Intrinsics.checkNotNullParameter(group, "group");
            this.rollingFrameViewGroup = group;
        }

        public abstract int b();

        public final void c() {
            RollingFrameViewGroup rollingFrameViewGroup = this.rollingFrameViewGroup;
            if (rollingFrameViewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rollingFrameViewGroup");
                rollingFrameViewGroup = null;
            }
            rollingFrameViewGroup.w();
        }

        public final void d() {
            RollingFrameViewGroup rollingFrameViewGroup = this.rollingFrameViewGroup;
            if (rollingFrameViewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rollingFrameViewGroup");
                rollingFrameViewGroup = null;
            }
            rollingFrameViewGroup.x();
        }

        public abstract void e(View view, int position);

        public abstract View f(ViewGroup viewGroup);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RollingFrameViewGroup(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void B(int curPos, boolean scrollLeft, boolean both) {
        com.tencent.sqshow.zootopia.friendsdressup.a.b("DrawerFrameViewGroup", " curPos " + curPos + "  scrollLeft " + scrollLeft + " curPosition " + this.curPosition + "  both " + both);
        a aVar = null;
        if (both) {
            int i3 = this.curPosition + 1;
            a aVar2 = this.adapter;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                aVar2 = null;
            }
            if (i3 < aVar2.b()) {
                a aVar3 = this.adapter;
                if (aVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    aVar3 = null;
                }
                View view = this.rollingChildren.get(2);
                Intrinsics.checkNotNull(view);
                aVar3.e(view, this.curPosition + 1);
            }
            if (this.curPosition - 1 >= 0) {
                a aVar4 = this.adapter;
                if (aVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                } else {
                    aVar = aVar4;
                }
                View view2 = this.rollingChildren.get(0);
                Intrinsics.checkNotNull(view2);
                aVar.e(view2, this.curPosition - 1);
                return;
            }
            return;
        }
        com.tencent.sqshow.zootopia.friendsdressup.widget.c cVar = this.scrollListener;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollListener");
            cVar = null;
        }
        cVar.a(this.curPosition);
        if (scrollLeft) {
            int i16 = this.curPosition + 1;
            a aVar5 = this.adapter;
            if (aVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                aVar5 = null;
            }
            if (i16 < aVar5.b()) {
                a aVar6 = this.adapter;
                if (aVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                } else {
                    aVar = aVar6;
                }
                View view3 = this.rollingChildren.get(2);
                Intrinsics.checkNotNull(view3);
                aVar.e(view3, this.curPosition + 1);
                return;
            }
            return;
        }
        if (this.curPosition - 1 >= 0) {
            a aVar7 = this.adapter;
            if (aVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                aVar = aVar7;
            }
            View view4 = this.rollingChildren.get(0);
            Intrinsics.checkNotNull(view4);
            aVar.e(view4, this.curPosition - 1);
        }
    }

    private final void l(float start, float end, final Function1<? super Float, Unit> invoke, Function0<Unit> complete) {
        ValueAnimator valueAnimator = this.moveAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (start == end) {
            invoke.invoke(Float.valueOf(end));
            complete.invoke();
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(start, end);
        this.moveAnimator = ofFloat;
        Intrinsics.checkNotNull(ofFloat);
        ofFloat.setInterpolator(this.scrollInterpolator);
        ValueAnimator valueAnimator2 = this.moveAnimator;
        Intrinsics.checkNotNull(valueAnimator2);
        valueAnimator2.setDuration((((float) this.changeTime) * Math.abs(end - start)) / this.maxScrollDistance);
        ValueAnimator valueAnimator3 = this.moveAnimator;
        Intrinsics.checkNotNull(valueAnimator3);
        valueAnimator3.addListener(new c(complete, invoke, end));
        ValueAnimator valueAnimator4 = this.moveAnimator;
        Intrinsics.checkNotNull(valueAnimator4);
        valueAnimator4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.sqshow.zootopia.friendsdressup.widget.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator5) {
                RollingFrameViewGroup.m(Function1.this, valueAnimator5);
            }
        });
        ValueAnimator valueAnimator5 = this.moveAnimator;
        Intrinsics.checkNotNull(valueAnimator5);
        valueAnimator5.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Function1 invoke, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(invoke, "$invoke");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        invoke.invoke((Float) animatedValue);
    }

    private final boolean n() {
        int i3 = this.curPosition + 1;
        a aVar = this.adapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            aVar = null;
        }
        return i3 < aVar.b();
    }

    private final boolean o() {
        return this.curPosition > 0;
    }

    private final View p() {
        a aVar = this.adapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            aVar = null;
        }
        View f16 = aVar.f(this);
        addView(f16);
        ViewGroup.LayoutParams layoutParams = f16.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        return f16;
    }

    private final void q(MotionEvent event) {
        com.tencent.sqshow.zootopia.friendsdressup.a.b("DrawerFrameViewGroup", "actionUp " + this.scrollDistance + " maxScrollDistance " + this.maxScrollDistance + " curPostion " + this.curPosition);
        float f16 = this.scrollDistance;
        if (f16 == 0.0f) {
            com.tencent.sqshow.zootopia.friendsdressup.a.b("DrawerFrameViewGroup", " ignore up");
            return;
        }
        if (f16 < 0.0f && !o()) {
            com.tencent.sqshow.zootopia.friendsdressup.a.b("DrawerFrameViewGroup", " ignore up");
            this.scrollDistance = 0.0f;
            return;
        }
        if (this.scrollDistance > 0.0f && !n()) {
            com.tencent.sqshow.zootopia.friendsdressup.a.b("DrawerFrameViewGroup", " ignore up");
            this.scrollDistance = 0.0f;
            return;
        }
        float abs = Math.abs(this.scrollDistance);
        float f17 = this.maxScrollDistance;
        if (abs > f17) {
            float f18 = this.scrollDistance;
            this.scrollDistance = (f17 * f18) / Math.abs(f18);
        }
        float abs2 = Math.abs(this.scrollDistance);
        float f19 = this.maxScrollDistance;
        if (abs2 <= f19) {
            float f26 = this.scrollDistance;
            float abs3 = (f19 * f26) / Math.abs(f26);
            com.tencent.sqshow.zootopia.friendsdressup.a.b("DrawerFrameViewGroup", " dest " + abs3);
            l(this.scrollDistance, abs3, new Function1<Float, Unit>() { // from class: com.tencent.sqshow.zootopia.friendsdressup.widget.RollingFrameViewGroup$dealActionUp$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Float f27) {
                    invoke(f27.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(float f27) {
                    com.tencent.sqshow.zootopia.friendsdressup.a.b("DrawerFrameViewGroup", "anim callBack " + f27);
                    RollingFrameViewGroup.v(RollingFrameViewGroup.this, f27, false, 2, null);
                }
            }, new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.friendsdressup.widget.RollingFrameViewGroup$dealActionUp$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    float f27;
                    float f28;
                    float f29;
                    Map map;
                    Map map2;
                    Map map3;
                    Map map4;
                    Map map5;
                    Map map6;
                    int i3;
                    int i16;
                    e eVar;
                    int i17;
                    Map map7;
                    Map map8;
                    Map map9;
                    Map map10;
                    Map map11;
                    Map map12;
                    int i18;
                    int i19;
                    e eVar2;
                    int i26;
                    f27 = RollingFrameViewGroup.this.scrollDistance;
                    com.tencent.sqshow.zootopia.friendsdressup.a.b("DrawerFrameViewGroup", "anim complete " + f27);
                    f28 = RollingFrameViewGroup.this.scrollDistance;
                    if (f28 > 0.0f) {
                        map7 = RollingFrameViewGroup.this.rollingChildren;
                        View view = (View) map7.get(0);
                        map8 = RollingFrameViewGroup.this.rollingChildren;
                        map9 = RollingFrameViewGroup.this.rollingChildren;
                        map8.put(0, map9.get(1));
                        map10 = RollingFrameViewGroup.this.rollingChildren;
                        map11 = RollingFrameViewGroup.this.rollingChildren;
                        map10.put(1, map11.get(2));
                        map12 = RollingFrameViewGroup.this.rollingChildren;
                        map12.put(2, view);
                        RollingFrameViewGroup rollingFrameViewGroup = RollingFrameViewGroup.this;
                        i18 = rollingFrameViewGroup.curPosition;
                        rollingFrameViewGroup.curPosition = i18 + 1;
                        i19 = rollingFrameViewGroup.curPosition;
                        RollingFrameViewGroup.C(rollingFrameViewGroup, i19, true, false, 4, null);
                        eVar2 = RollingFrameViewGroup.this.rollingFrameScrollListener;
                        if (eVar2 != null) {
                            i26 = RollingFrameViewGroup.this.curPosition;
                            eVar2.a(i26);
                        }
                        RollingFrameViewGroup.this.y();
                        return;
                    }
                    f29 = RollingFrameViewGroup.this.scrollDistance;
                    if (f29 < 0.0f) {
                        map = RollingFrameViewGroup.this.rollingChildren;
                        View view2 = (View) map.get(0);
                        map2 = RollingFrameViewGroup.this.rollingChildren;
                        map3 = RollingFrameViewGroup.this.rollingChildren;
                        map2.put(0, map3.get(2));
                        map4 = RollingFrameViewGroup.this.rollingChildren;
                        map5 = RollingFrameViewGroup.this.rollingChildren;
                        map4.put(2, map5.get(1));
                        map6 = RollingFrameViewGroup.this.rollingChildren;
                        map6.put(1, view2);
                        RollingFrameViewGroup rollingFrameViewGroup2 = RollingFrameViewGroup.this;
                        i3 = rollingFrameViewGroup2.curPosition;
                        rollingFrameViewGroup2.curPosition = i3 - 1;
                        i16 = rollingFrameViewGroup2.curPosition;
                        RollingFrameViewGroup.C(rollingFrameViewGroup2, i16, false, false, 4, null);
                        eVar = RollingFrameViewGroup.this.rollingFrameScrollListener;
                        if (eVar != null) {
                            i17 = RollingFrameViewGroup.this.curPosition;
                            eVar.a(i17);
                        }
                        RollingFrameViewGroup.this.y();
                    }
                }
            });
        }
        this.scrollDistance = 0.0f;
    }

    private final int s() {
        return ((Number) this.touchSlop.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewConfiguration t() {
        return (ViewConfiguration) this.viewConfig.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(float distance, boolean notify) {
        com.tencent.sqshow.zootopia.friendsdressup.a.b("DrawerFrameViewGroup", "moveChild distance " + distance + " notify " + notify);
        this.scrollDistance = distance;
        float f16 = distance / this.maxScrollDistance;
        View view = this.rollingChildren.get(0);
        if (view != null) {
            view.setTranslationX(this.firstInitDetail - distance);
            if (distance > 0.0f) {
                view.setAlpha(0.0f);
            }
            if (distance < 0.0f) {
                view.setAlpha(Math.abs(f16));
            }
        }
        View view2 = this.rollingChildren.get(1);
        Intrinsics.checkNotNull(view2);
        View view3 = view2;
        float translationX = view3.getTranslationX();
        view3.setTranslationX(this.secondInitDetail - distance);
        view3.setAlpha(1.0f - Math.abs(f16));
        com.tencent.sqshow.zootopia.friendsdressup.a.a("DrawerFrameViewGroup", " moveChild[1] " + translationX + "  secondInitDetail " + this.secondInitDetail + "  newTranslationX " + view3.getTranslationX());
        float translationX2 = view3.getTranslationX() - translationX;
        View view4 = this.rollingChildren.get(2);
        if (view4 != null) {
            view4.setTranslationX(this.thirdInitDetail - distance);
            if (distance > 0.0f) {
                view4.setAlpha(Math.abs(f16));
            }
            if (distance < 0.0f) {
                view4.setAlpha(0.0f);
            }
        }
        if (notify) {
            float f17 = translationX2 / this.maxScrollDistance;
            com.tencent.sqshow.zootopia.friendsdressup.a.a("DrawerFrameViewGroup", "callack  distance " + distance + "  detailX " + translationX2 + "  percent " + f17);
            com.tencent.sqshow.zootopia.friendsdressup.widget.c cVar = this.scrollListener;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scrollListener");
                cVar = null;
            }
            cVar.b(distance, translationX2, f17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        int i3 = this.curPosition + 1;
        a aVar = this.adapter;
        a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            aVar = null;
        }
        if (i3 < aVar.b()) {
            a aVar3 = this.adapter;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                aVar3 = null;
            }
            View view = this.rollingChildren.get(2);
            Intrinsics.checkNotNull(view);
            aVar3.e(view, this.curPosition + 1);
        }
        if (this.curPosition - 1 >= 0) {
            a aVar4 = this.adapter;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                aVar2 = aVar4;
            }
            View view2 = this.rollingChildren.get(0);
            Intrinsics.checkNotNull(view2);
            aVar2.e(view2, this.curPosition - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x() {
        removeAllViews();
        this.rollingChildren.clear();
        this.rollingChildren.put(0, p());
        this.rollingChildren.put(1, p());
        this.rollingChildren.put(2, p());
        this.firstInitSet = true;
        a aVar = this.adapter;
        a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            aVar = null;
        }
        if (aVar.b() > 0) {
            a aVar3 = this.adapter;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                aVar3 = null;
            }
            View view = this.rollingChildren.get(1);
            Intrinsics.checkNotNull(view);
            aVar3.e(view, 0);
        }
        a aVar4 = this.adapter;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            aVar4 = null;
        }
        if (aVar4.b() > 1) {
            a aVar5 = this.adapter;
            if (aVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                aVar2 = aVar5;
            }
            View view2 = this.rollingChildren.get(2);
            Intrinsics.checkNotNull(view2);
            View view3 = view2;
            view3.setAlpha(0.0f);
            aVar2.e(view3, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y() {
        com.tencent.sqshow.zootopia.friendsdressup.a.b("DrawerFrameViewGroup", "reset");
        View view = this.rollingChildren.get(0);
        if (view != null) {
            view.setTranslationX(this.firstInitDetail);
        }
        View view2 = this.rollingChildren.get(1);
        if (view2 != null) {
            view2.setTranslationX(0.0f);
        }
        View view3 = this.rollingChildren.get(2);
        if (view3 != null) {
            view3.setTranslationX(this.thirdInitDetail);
        }
        View view4 = this.rollingChildren.get(1);
        if (view4 != null) {
            view4.bringToFront();
        }
        View view5 = this.rollingChildren.get(0);
        if (view5 != null) {
            view5.setAlpha(0.0f);
        }
        View view6 = this.rollingChildren.get(2);
        if (view6 != null) {
            view6.setAlpha(0.0f);
        }
        this.scrollDistance = 0.0f;
    }

    private final void z(float distance) {
        com.tencent.sqshow.zootopia.friendsdressup.a.b("DrawerFrameViewGroup", "scrollFrame  distance " + distance + " scrollDistance " + this.scrollDistance + " maxScrollDistance " + this.maxScrollDistance + "   postion " + this.curPosition);
        if (distance < 0.0f && !o()) {
            com.tencent.sqshow.zootopia.friendsdressup.a.b("DrawerFrameViewGroup", " \u4e0d\u80fd\u5411\u53f3\u6ed1\u52a8");
            return;
        }
        if (distance > 0.0f && !n()) {
            com.tencent.sqshow.zootopia.friendsdressup.a.b("DrawerFrameViewGroup", " \u4e0d\u80fd\u5411\u5de6\u6ed1\u52a8");
            return;
        }
        float f16 = this.scrollDistance + distance;
        this.scrollDistance = f16;
        float abs = Math.abs(f16);
        float f17 = this.maxScrollDistance;
        if (abs > f17) {
            this.scrollDistance = f17 * (this.scrollDistance > 0.0f ? 1 : -1);
        }
        com.tencent.sqshow.zootopia.friendsdressup.a.b("DrawerFrameViewGroup", " \u6ed1\u52a8 " + this.scrollDistance + " ");
        v(this, this.scrollDistance, false, 2, null);
    }

    public final void A(int position) {
        com.tencent.sqshow.zootopia.friendsdressup.a.b("DrawerFrameViewGroup", " scrollToPosition curPosition " + this.curPosition + "   dest " + position);
        if (this.curPosition == position) {
            return;
        }
        int i3 = position + 1;
        a aVar = this.adapter;
        a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            aVar = null;
        }
        if (i3 > aVar.b()) {
            int i16 = this.curPosition;
            a aVar3 = this.adapter;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                aVar2 = aVar3;
            }
            com.tencent.sqshow.zootopia.friendsdressup.a.b("DrawerFrameViewGroup", " scrollToPosition error curPosition " + i16 + "   dest " + position + " totalCount " + aVar2.b());
            return;
        }
        int i17 = this.curPosition;
        if (i17 > position) {
            View view = this.rollingChildren.get(0);
            if (view != null) {
                a aVar4 = this.adapter;
                if (aVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                } else {
                    aVar2 = aVar4;
                }
                aVar2.e(view, position);
            }
            this.curPosition = position;
            l(0.0f, -this.maxScrollDistance, new Function1<Float, Unit>() { // from class: com.tencent.sqshow.zootopia.friendsdressup.widget.RollingFrameViewGroup$scrollToPosition$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Float f16) {
                    invoke(f16.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(float f16) {
                    RollingFrameViewGroup.this.u(f16, false);
                }
            }, new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.friendsdressup.widget.RollingFrameViewGroup$scrollToPosition$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Map map;
                    Map map2;
                    Map map3;
                    Map map4;
                    Map map5;
                    Map map6;
                    int i18;
                    map = RollingFrameViewGroup.this.rollingChildren;
                    View view2 = (View) map.get(0);
                    map2 = RollingFrameViewGroup.this.rollingChildren;
                    map3 = RollingFrameViewGroup.this.rollingChildren;
                    map2.put(0, map3.get(2));
                    map4 = RollingFrameViewGroup.this.rollingChildren;
                    map5 = RollingFrameViewGroup.this.rollingChildren;
                    map4.put(2, map5.get(1));
                    map6 = RollingFrameViewGroup.this.rollingChildren;
                    map6.put(1, view2);
                    RollingFrameViewGroup rollingFrameViewGroup = RollingFrameViewGroup.this;
                    i18 = rollingFrameViewGroup.curPosition;
                    RollingFrameViewGroup.C(rollingFrameViewGroup, i18, false, true, 2, null);
                    RollingFrameViewGroup.this.y();
                }
            });
            return;
        }
        if (i17 < position) {
            View view2 = this.rollingChildren.get(2);
            if (view2 != null) {
                a aVar5 = this.adapter;
                if (aVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                } else {
                    aVar2 = aVar5;
                }
                aVar2.e(view2, position);
            }
            this.curPosition = position;
            l(0.0f, this.maxScrollDistance, new Function1<Float, Unit>() { // from class: com.tencent.sqshow.zootopia.friendsdressup.widget.RollingFrameViewGroup$scrollToPosition$5
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Float f16) {
                    invoke(f16.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(float f16) {
                    RollingFrameViewGroup.this.u(f16, false);
                }
            }, new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.friendsdressup.widget.RollingFrameViewGroup$scrollToPosition$6
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Map map;
                    Map map2;
                    Map map3;
                    Map map4;
                    Map map5;
                    Map map6;
                    int i18;
                    map = RollingFrameViewGroup.this.rollingChildren;
                    View view3 = (View) map.get(0);
                    map2 = RollingFrameViewGroup.this.rollingChildren;
                    map3 = RollingFrameViewGroup.this.rollingChildren;
                    map2.put(0, map3.get(1));
                    map4 = RollingFrameViewGroup.this.rollingChildren;
                    map5 = RollingFrameViewGroup.this.rollingChildren;
                    map4.put(1, map5.get(2));
                    map6 = RollingFrameViewGroup.this.rollingChildren;
                    map6.put(2, view3);
                    RollingFrameViewGroup rollingFrameViewGroup = RollingFrameViewGroup.this;
                    i18 = rollingFrameViewGroup.curPosition;
                    RollingFrameViewGroup.C(rollingFrameViewGroup, i18, false, true, 2, null);
                    RollingFrameViewGroup.this.y();
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000f, code lost:
    
        if (r0.isRunning() == true) goto L11;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent ev5) {
        boolean z16;
        if (this.ignoreTouch) {
            return false;
        }
        ValueAnimator valueAnimator = this.moveAnimator;
        if (valueAnimator != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            return false;
        }
        return super.dispatchTouchEvent(ev5);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.moveAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent e16) {
        Intrinsics.checkNotNullParameter(e16, "e");
        int actionMasked = e16.getActionMasked();
        int actionIndex = e16.getActionIndex();
        if (actionMasked != 0) {
            if (actionMasked == 2) {
                int findPointerIndex = e16.findPointerIndex(this.mScrollPointerId);
                if (findPointerIndex < 0) {
                    return false;
                }
                float x16 = e16.getX(findPointerIndex) + 0.5f;
                float y16 = e16.getY(findPointerIndex) + 0.5f;
                float abs = Math.abs(x16 - this.lastTouchX);
                float abs2 = Math.abs(y16 - this.initialTouchY);
                if (abs > s() && abs * 0.5f > abs2) {
                    return n() || o();
                }
            } else if (actionMasked != 5) {
                if (actionMasked == 6 && e16.getPointerId(actionIndex) == this.mScrollPointerId) {
                    int i3 = actionIndex != 0 ? 0 : 1;
                    this.mScrollPointerId = e16.getPointerId(i3);
                    this.lastTouchX = e16.getX(i3) + 0.5f;
                    float y17 = e16.getY(i3) + 0.5f;
                    this.lastTouchY = y17;
                    this.initialTouchX = this.lastTouchX;
                    this.initialTouchY = y17;
                }
            } else {
                this.mScrollPointerId = e16.getPointerId(actionIndex);
                this.lastTouchX = e16.getX(actionIndex) + 0.5f;
                float y18 = e16.getY(actionIndex) + 0.5f;
                this.lastTouchY = y18;
                this.initialTouchX = this.lastTouchX;
                this.initialTouchY = y18;
            }
        } else {
            this.mScrollPointerId = e16.getPointerId(0);
            this.lastTouchX = e16.getX(actionIndex) + 0.5f;
            float y19 = e16.getY(actionIndex) + 0.5f;
            this.lastTouchY = y19;
            this.initialTouchX = this.lastTouchX;
            this.initialTouchY = y19;
            this.scrollDistance = 0.0f;
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        float paddingLeft = (((right - left) - getPaddingLeft()) - getPaddingRight()) / 4;
        this.maxScrollDistance = paddingLeft;
        this.firstInitDetail = -paddingLeft;
        this.thirdInitDetail = paddingLeft;
        if (this.firstInitSet) {
            View view = this.rollingChildren.get(0);
            if (view != null) {
                view.setTranslationX(this.firstInitDetail);
            }
            View view2 = this.rollingChildren.get(2);
            if (view2 != null) {
                view2.setTranslationX(this.thirdInitDetail);
            }
            this.firstInitSet = false;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int actionMasked = event.getActionMasked();
        int actionIndex = event.getActionIndex();
        if (!o() && !n()) {
            return false;
        }
        if (actionMasked == 0) {
            this.mScrollPointerId = event.getPointerId(0);
            this.lastTouchX = event.getX(actionIndex) + 0.5f;
            float y16 = event.getY(actionIndex) + 0.5f;
            this.lastTouchY = y16;
            this.initialTouchX = this.lastTouchX;
            this.initialTouchY = y16;
            ValueAnimator valueAnimator = this.moveAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                return false;
            }
            this.scrollDistance = 0.0f;
            return true;
        }
        if (actionMasked == 1) {
            q(event);
            return true;
        }
        if (actionMasked == 2) {
            int findPointerIndex = event.findPointerIndex(this.mScrollPointerId);
            if (findPointerIndex < 0) {
                return false;
            }
            float x16 = event.getX(findPointerIndex) + 0.5f;
            event.getY(findPointerIndex);
            float f16 = this.lastTouchX - x16;
            if ((f16 == 0.0f ? 1 : 0) == 0) {
                z(f16);
                this.lastTouchX = x16;
            }
            return true;
        }
        if (actionMasked == 5) {
            this.mScrollPointerId = event.getPointerId(actionIndex);
            this.lastTouchX = event.getX(actionIndex) + 0.5f;
            float y17 = event.getY(actionIndex) + 0.5f;
            this.lastTouchY = y17;
            this.initialTouchX = this.lastTouchX;
            this.initialTouchY = y17;
            return true;
        }
        if (actionMasked != 6) {
            return false;
        }
        int actionIndex2 = event.getActionIndex();
        if (event.getPointerId(actionIndex2) == this.mScrollPointerId) {
            int i3 = actionIndex2 == 0 ? 1 : 0;
            this.mScrollPointerId = event.getPointerId(i3);
            this.lastTouchX = event.getX(i3) + 0.5f;
            float y18 = event.getY(i3) + 0.5f;
            this.lastTouchY = y18;
            this.initialTouchX = this.lastTouchX;
            this.initialTouchY = y18;
        }
        return true;
    }

    /* renamed from: r, reason: from getter */
    public final ValueAnimator getMoveAnimator() {
        return this.moveAnimator;
    }

    public final void setAdapter(a adapter, com.tencent.sqshow.zootopia.friendsdressup.widget.c scrollListener) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(scrollListener, "scrollListener");
        this.scrollListener = scrollListener;
        adapter.a(this);
        this.adapter = adapter;
        x();
    }

    public final void setIgnoreTouch(boolean z16) {
        this.ignoreTouch = z16;
    }

    public final void setMoveAnimator(ValueAnimator valueAnimator) {
        this.moveAnimator = valueAnimator;
    }

    public final void setRollingFrameScrollListener(e rollingFrameScrollListener) {
        Intrinsics.checkNotNullParameter(rollingFrameScrollListener, "rollingFrameScrollListener");
        this.rollingFrameScrollListener = rollingFrameScrollListener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RollingFrameViewGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ RollingFrameViewGroup(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RollingFrameViewGroup(final Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ViewConfiguration>() { // from class: com.tencent.sqshow.zootopia.friendsdressup.widget.RollingFrameViewGroup$viewConfig$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewConfiguration invoke() {
                return ViewConfiguration.get(context);
            }
        });
        this.viewConfig = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.sqshow.zootopia.friendsdressup.widget.RollingFrameViewGroup$touchSlop$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                ViewConfiguration t16;
                t16 = RollingFrameViewGroup.this.t();
                return Integer.valueOf(t16.getScaledTouchSlop());
            }
        });
        this.touchSlop = lazy2;
        this.mScrollPointerId = -1;
        this.rollingChildren = new LinkedHashMap();
        this.changeTime = 100L;
        this.firstInitSet = true;
        this.scrollInterpolator = new com.tencent.sqshow.zootopia.friendsdressup.widget.a(0.165f, 0.84f, 0.44f, 1.0f);
        setClipToPadding(false);
        setClipChildren(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void v(RollingFrameViewGroup rollingFrameViewGroup, float f16, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        rollingFrameViewGroup.u(f16, z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void C(RollingFrameViewGroup rollingFrameViewGroup, int i3, boolean z16, boolean z17, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            z16 = true;
        }
        if ((i16 & 4) != 0) {
            z17 = false;
        }
        rollingFrameViewGroup.B(i3, z16, z17);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/friendsdressup/widget/RollingFrameViewGroup$c", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f370640d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function1<Float, Unit> f370641e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ float f370642f;

        /* JADX WARN: Multi-variable type inference failed */
        c(Function0<Unit> function0, Function1<? super Float, Unit> function1, float f16) {
            this.f370640d = function0;
            this.f370641e = function1;
            this.f370642f = f16;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            com.tencent.sqshow.zootopia.friendsdressup.a.a("DrawerFrameViewGroup", "animation Cancel invoke");
            this.f370641e.invoke(Float.valueOf(this.f370642f));
            this.f370640d.invoke();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            this.f370640d.invoke();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }
    }
}
