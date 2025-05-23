package com.tencent.sqshow.zootopia.nativeui.view.detail.recommend;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.nativeui.ue.u;
import com.tencent.sqshow.zootopia.nativeui.view.detail.recommend.IStateChangeListener;
import com.tencent.sqshow.zootopia.utils.aa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k94.DialogCustomData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n74.br;
import uv4.az;
import uv4.bk;

@Metadata(d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 Y2\u00020\u0001:\u0001ZB'\b\u0007\u0012\u0006\u0010S\u001a\u00020R\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010T\u0012\b\b\u0002\u0010V\u001a\u00020\t\u00a2\u0006\u0004\bW\u0010XJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0003J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013H\u0002J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0005H\u0002J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0005H\u0002J\b\u0010\u001e\u001a\u00020\u0002H\u0002J\b\u0010\u001f\u001a\u00020\u0002H\u0002J\u000e\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 J\u0012\u0010&\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010)\u001a\u00020\u00022\b\u0010(\u001a\u0004\u0018\u00010'J\u000e\u0010+\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020*J\u0014\u0010/\u001a\u00020\u00022\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0,J\u000e\u00100\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u00101\u001a\u00020\u0002J\u0006\u00102\u001a\u00020\u0002R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u00109\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010G\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010FR\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020*0H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010IR\u0018\u0010L\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010KR\u001c\u0010M\u001a\b\u0012\u0004\u0012\u00020-0,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010IR\u0014\u0010Q\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010P\u00a8\u0006["}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/detail/recommend/PortalStoreAvatarRecommendFloatView;", "Landroid/widget/FrameLayout;", "", "t", "", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "spanCount", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "w", HippyTKDListViewAdapter.X, "Loc4/a;", "listener", "l", "k", "Lcom/tencent/sqshow/zootopia/nativeui/view/detail/recommend/IStateChangeListener$State;", "state", "o", "oldState", "newState", DomainData.DOMAIN_NAME, "Landroid/view/View;", "view", "id", "D", "E", "B", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "p", "Landroid/view/MotionEvent;", "event", "", "dispatchTouchEvent", "Luv4/az;", "storeItem", "setCurrentClickStoreItem", "Lcom/tencent/sqshow/zootopia/nativeui/view/detail/recommend/IStateChangeListener;", "j", "", "Luv4/bk;", "storeItemList", "setRecommendStoreItemList", "setState", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", "Ln74/br;", "d", "Ln74/br;", "mBinding", "e", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "mChannel", "Le94/a;", "f", "Le94/a;", "mAdapter", "Landroid/view/GestureDetector;", tl.h.F, "Landroid/view/GestureDetector;", "mGestureDetector", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "i", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "mGestureListener", "Lcom/tencent/sqshow/zootopia/nativeui/view/detail/recommend/IStateChangeListener$State;", "mState", "", "Ljava/util/List;", "mStateChangeListeners", "Luv4/az;", "mCurrentClickStoreItem", "mRecommendStoreItemList", "Lid3/d;", UserInfo.SEX_FEMALE, "Lid3/d;", "dtReporter", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "G", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PortalStoreAvatarRecommendFloatView extends FrameLayout {
    private static final int H;
    private static final int I;
    private static final int J;
    private static final int K;
    private static final int L;
    private static final int M;
    private static final int N;

    /* renamed from: C, reason: from kotlin metadata */
    private final List<IStateChangeListener> mStateChangeListeners;

    /* renamed from: D, reason: from kotlin metadata */
    private az mCurrentClickStoreItem;

    /* renamed from: E, reason: from kotlin metadata */
    private List<bk> mRecommendStoreItemList;

    /* renamed from: F, reason: from kotlin metadata */
    private final id3.d dtReporter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final br mBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.sqshow.zootopia.nativeui.data.j mChannel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private e94.a mAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private GestureDetector mGestureDetector;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private GestureDetector.SimpleOnGestureListener mGestureListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private IStateChangeListener.State mState;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f371709a;

        static {
            int[] iArr = new int[IStateChangeListener.State.values().length];
            try {
                iArr[IStateChangeListener.State.FOLD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IStateChangeListener.State.EXPAND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f371709a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/detail/recommend/PortalStoreAvatarRecommendFloatView$c", "Loc4/a;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c extends oc4.a {
        c() {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            PortalStoreAvatarRecommendFloatView.this.mBinding.f418902f.setVisibility(0);
            PortalStoreAvatarRecommendFloatView.this.mBinding.f418898b.setVisibility(8);
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/detail/recommend/PortalStoreAvatarRecommendFloatView$e", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e1", "e2", "", "velocityX", "velocityY", "", "onFling", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e extends GestureDetector.SimpleOnGestureListener {
        e() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent e16, MotionEvent e26, float velocityX, float velocityY) {
            if (Math.abs(velocityY) > Math.abs(velocityX)) {
                return super.onFling(e16, e26, velocityX, velocityY);
            }
            if (velocityX > PortalStoreAvatarRecommendFloatView.J) {
                PortalStoreAvatarRecommendFloatView.this.x();
            } else if (velocityX < (-PortalStoreAvatarRecommendFloatView.J)) {
                PortalStoreAvatarRecommendFloatView.this.w();
            }
            return super.onFling(e16, e26, velocityX, velocityY);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/detail/recommend/PortalStoreAvatarRecommendFloatView$f", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "", "itemPosition", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "getItemOffsets", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class f extends RecyclerView.ItemDecoration {
        f() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(parent, "parent");
            if (itemPosition % 2 == 0) {
                outRect.right = PortalStoreAvatarRecommendFloatView.I;
            } else {
                outRect.left = PortalStoreAvatarRecommendFloatView.I;
            }
            outRect.top = PortalStoreAvatarRecommendFloatView.H;
        }
    }

    static {
        int b16 = com.tencent.sqshow.zootopia.utils.i.b(6);
        H = b16;
        I = b16 / 2;
        J = com.tencent.sqshow.zootopia.utils.i.b(400);
        K = com.tencent.sqshow.zootopia.utils.i.b(158);
        L = com.tencent.sqshow.zootopia.utils.i.b(92);
        M = com.tencent.sqshow.zootopia.utils.i.b(114);
        N = com.tencent.sqshow.zootopia.utils.i.b(99);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PortalStoreAvatarRecommendFloatView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void A() {
        Unit unit;
        az azVar = this.mCurrentClickStoreItem;
        if (azVar != null) {
            this.mBinding.f418904h.setText(azVar.f440277d);
            this.mBinding.f418899c.setVisibility(0);
            this.mBinding.f418900d.setVisibility(0);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.mBinding.f418904h.setText(getContext().getString(R.string.xsq));
            this.mBinding.f418900d.setVisibility(8);
        }
    }

    private final void B() {
        this.dtReporter.d("ev_zplan_clothes_recommend_card_imp", m());
    }

    private final void C() {
        this.dtReporter.d("ev_zplan_clothes_recommend_card_imp_end", m());
    }

    private final void D(View view, String id5) {
        y94.a reporter;
        ZplanViewReportHelper mReporter;
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
        if (jVar == null || (reporter = jVar.getReporter()) == null || (mReporter = reporter.getMReporter()) == null) {
            return;
        }
        mReporter.g(view, id5, (r16 & 4) != 0 ? null : m(), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }

    private final void E(View view, String id5) {
        y94.a reporter;
        ZplanViewReportHelper mReporter;
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
        if (jVar == null || (reporter = jVar.getReporter()) == null || (mReporter = reporter.getMReporter()) == null) {
            return;
        }
        ZplanViewReportHelper.j(mReporter, view, id5, m(), false, null, 16, null);
    }

    private final void k(oc4.a listener) {
        AnimatorSet animatorSet = new AnimatorSet();
        if (listener != null) {
            animatorSet.addListener(listener);
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mBinding.f418898b, "translationX", K, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mBinding.f418898b, BasicAnimation.KeyPath.SCALE_X, 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mBinding.f418898b, BasicAnimation.KeyPath.SCALE_Y, 0.0f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mBinding.f418898b, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        animatorSet.play(ofFloat);
        animatorSet.play(ofFloat2);
        animatorSet.play(ofFloat3);
        animatorSet.play(ofFloat4);
        animatorSet.setDuration(100L);
        animatorSet.start();
    }

    private final void l(oc4.a listener) {
        AnimatorSet animatorSet = new AnimatorSet();
        if (listener != null) {
            animatorSet.addListener(listener);
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mBinding.f418898b, "translationX", 0.0f, K);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mBinding.f418898b, BasicAnimation.KeyPath.SCALE_X, 1.0f, 0.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mBinding.f418898b, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 0.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mBinding.f418898b, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        animatorSet.play(ofFloat);
        animatorSet.play(ofFloat2);
        animatorSet.play(ofFloat3);
        animatorSet.play(ofFloat4);
        animatorSet.setDuration(100L);
        animatorSet.start();
    }

    private final Map<String, Object> m() {
        Object obj;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("zplan_mall_type", "");
        az azVar = this.mCurrentClickStoreItem;
        if (azVar == null) {
            obj = "";
        } else {
            obj = Integer.valueOf(azVar.f440275b);
        }
        linkedHashMap.put("zplan_item_id", obj);
        linkedHashMap.put("zplan_item_source", 2);
        az azVar2 = this.mCurrentClickStoreItem;
        String str = azVar2 != null ? azVar2.f440286m : null;
        if (str == null) {
            str = "";
        }
        linkedHashMap.put("zplan_bottom_content", str);
        az azVar3 = this.mCurrentClickStoreItem;
        String str2 = azVar3 != null ? azVar3.f440283j : null;
        linkedHashMap.put("zplan_corner_label", str2 != null ? str2 : "");
        linkedHashMap.put("zplan_is_pre_download", 0);
        return linkedHashMap;
    }

    private final void n(IStateChangeListener.State oldState, IStateChangeListener.State newState) {
        Iterator<T> it = this.mStateChangeListeners.iterator();
        while (it.hasNext()) {
            ((IStateChangeListener) it.next()).a(oldState, newState);
        }
    }

    private final void o(IStateChangeListener.State state) {
        int i3 = b.f371709a[state.ordinal()];
        if (i3 == 1) {
            l(new c());
        } else {
            if (i3 != 2) {
                return;
            }
            this.mBinding.f418902f.setVisibility(8);
            this.mBinding.f418898b.setVisibility(0);
            k(new d());
        }
    }

    private final void q() {
        this.mGestureListener = new e();
        this.mGestureDetector = new GestureDetector(getContext(), this.mGestureListener);
        setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.detail.recommend.j
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean r16;
                r16 = PortalStoreAvatarRecommendFloatView.r(view, motionEvent);
                return r16;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean r(View view, MotionEvent motionEvent) {
        return true;
    }

    private final void s(int spanCount) {
        RecyclerView recyclerView = this.mBinding.f418901e;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "mBinding.recommendRecyclerView");
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), spanCount);
        gridLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(this.mAdapter);
        recyclerView.addItemDecoration(new f());
    }

    private final void t() {
        RelativeLayout relativeLayout = this.mBinding.f418905i;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "mBinding.recommendTitleContainer");
        aa.d(relativeLayout, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.detail.recommend.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PortalStoreAvatarRecommendFloatView.u(PortalStoreAvatarRecommendFloatView.this, view);
            }
        });
        FrameLayout frameLayout = this.mBinding.f418902f;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "mBinding.recommendSibebarContainer");
        aa.d(frameLayout, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.detail.recommend.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PortalStoreAvatarRecommendFloatView.v(PortalStoreAvatarRecommendFloatView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(PortalStoreAvatarRecommendFloatView this$0, View view) {
        com.tencent.sqshow.zootopia.nativeui.data.j jVar;
        ga4.g a16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mCurrentClickStoreItem == null || (jVar = this$0.mChannel) == null || !u.a.a(jVar.getUeStatusController(), false, 1, null)) {
            return;
        }
        ga4.j jVar2 = ga4.j.f401682a;
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        a16 = jVar2.a(3, jVar, context, (r22 & 8) != 0 ? new DialogCustomData(null, null, null, null, null, 0, 63, null) : new DialogCustomData(this$0.mCurrentClickStoreItem, null, null, null, null, 0, 62, null), (r22 & 16) != 0 ? false : false);
        a16.show();
        ZplanViewReportHelper mReporter = jVar.getReporter().getMReporter();
        RelativeLayout relativeLayout = this$0.mBinding.f418905i;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "mBinding.recommendTitleContainer");
        mReporter.e(relativeLayout, "em_zplan_item_detail_recom", this$0.m());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(PortalStoreAvatarRecommendFloatView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setState(IStateChangeListener.State.EXPAND);
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = this$0.mChannel;
        if (jVar != null && u.a.a(jVar.getUeStatusController(), false, 1, null)) {
            ZplanViewReportHelper mReporter = jVar.getReporter().getMReporter();
            RelativeLayout relativeLayout = this$0.mBinding.f418905i;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "mBinding.recommendTitleContainer");
            mReporter.e(relativeLayout, "em_zplan_recom_sidebar", this$0.m());
            RelativeLayout relativeLayout2 = this$0.mBinding.f418905i;
            Intrinsics.checkNotNullExpressionValue(relativeLayout2, "mBinding.recommendTitleContainer");
            this$0.D(relativeLayout2, "em_zplan_item_detail_recom");
            FrameLayout frameLayout = this$0.mBinding.f418902f;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "mBinding.recommendSibebarContainer");
            this$0.E(frameLayout, "em_zplan_recom_sidebar");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent event) {
        GestureDetector gestureDetector = this.mGestureDetector;
        if (gestureDetector != null) {
            gestureDetector.onTouchEvent(event);
        }
        return super.dispatchTouchEvent(event);
    }

    public final void j(IStateChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.mStateChangeListeners.contains(listener)) {
            return;
        }
        this.mStateChangeListeners.add(listener);
    }

    public final void p(com.tencent.sqshow.zootopia.nativeui.data.j channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.mChannel = channel;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        e94.b bVar = new e94.b(context, channel.getOrientationMode());
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.mAdapter = new e94.a(context2, channel, bVar);
        s(bVar.getCom.google.android.exoplayer2.text.ttml.TtmlNode.TAG_SPAN java.lang.String());
    }

    public final void setCurrentClickStoreItem(az storeItem) {
        this.mCurrentClickStoreItem = storeItem;
        A();
    }

    public final void setRecommendStoreItemList(List<bk> storeItemList) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        int collectionSizeOrDefault3;
        Intrinsics.checkNotNullParameter(storeItemList, "storeItemList");
        List<bk> list = this.mRecommendStoreItemList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((bk) it.next()).f440366b);
        }
        List<bk> list2 = storeItemList;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it5 = list2.iterator();
        while (it5.hasNext()) {
            arrayList2.add(((bk) it5.next()).f440366b);
        }
        if (r94.b.E(arrayList, arrayList2)) {
            collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault3);
            Iterator<T> it6 = list2.iterator();
            while (it6.hasNext()) {
                arrayList3.add(((bk) it6.next()).f440366b);
            }
            QLog.i("AvatarRecommendFloatView", 1, "setRecommendStoreItemList isSameIdList, list=" + r94.b.p(arrayList3));
            return;
        }
        IStateChangeListener.State state = this.mState;
        IStateChangeListener.State state2 = IStateChangeListener.State.EXPAND;
        if (state == state2) {
            C();
        }
        this.mRecommendStoreItemList = storeItemList;
        e94.a aVar = this.mAdapter;
        if (aVar != null) {
            aVar.l0(storeItemList);
        }
        if (this.mState == state2) {
            B();
        }
    }

    public final void setState(IStateChangeListener.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        IStateChangeListener.State state2 = this.mState;
        if (state2 == state) {
            return;
        }
        o(state);
        this.mState = state;
        n(state2, state);
    }

    public final void y() {
        if (this.mState == IStateChangeListener.State.EXPAND) {
            RelativeLayout relativeLayout = this.mBinding.f418905i;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "mBinding.recommendTitleContainer");
            E(relativeLayout, "em_zplan_item_detail_recom");
        } else {
            FrameLayout frameLayout = this.mBinding.f418902f;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "mBinding.recommendSibebarContainer");
            E(frameLayout, "em_zplan_recom_sidebar");
        }
    }

    public final void z() {
        if (this.mState == IStateChangeListener.State.EXPAND) {
            RelativeLayout relativeLayout = this.mBinding.f418905i;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "mBinding.recommendTitleContainer");
            D(relativeLayout, "em_zplan_item_detail_recom");
        } else {
            FrameLayout frameLayout = this.mBinding.f418902f;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "mBinding.recommendSibebarContainer");
            D(frameLayout, "em_zplan_recom_sidebar");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PortalStoreAvatarRecommendFloatView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        QLog.i("AvatarRecommendFloatView", 1, "detect gesture, onFlingLeft");
        setState(IStateChangeListener.State.EXPAND);
        RelativeLayout relativeLayout = this.mBinding.f418905i;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "mBinding.recommendTitleContainer");
        D(relativeLayout, "em_zplan_item_detail_recom");
        FrameLayout frameLayout = this.mBinding.f418902f;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "mBinding.recommendSibebarContainer");
        E(frameLayout, "em_zplan_recom_sidebar");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x() {
        QLog.i("AvatarRecommendFloatView", 1, "detect gesture, onFlingRight");
        setState(IStateChangeListener.State.FOLD);
        FrameLayout frameLayout = this.mBinding.f418902f;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "mBinding.recommendSibebarContainer");
        D(frameLayout, "em_zplan_recom_sidebar");
        RelativeLayout relativeLayout = this.mBinding.f418905i;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "mBinding.recommendTitleContainer");
        E(relativeLayout, "em_zplan_item_detail_recom");
    }

    public /* synthetic */ PortalStoreAvatarRecommendFloatView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortalStoreAvatarRecommendFloatView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        List<bk> emptyList;
        Intrinsics.checkNotNullParameter(context, "context");
        this.mState = IStateChangeListener.State.EXPAND;
        this.mStateChangeListeners = new ArrayList();
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.mRecommendStoreItemList = emptyList;
        this.dtReporter = new id3.d(null, 1, null);
        br f16 = br.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.mBinding = f16;
        t();
        q();
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/detail/recommend/PortalStoreAvatarRecommendFloatView$d", "Loc4/a;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d extends oc4.a {
        d() {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
        }
    }
}
