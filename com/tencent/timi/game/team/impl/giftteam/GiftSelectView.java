package com.tencent.timi.game.team.impl.giftteam;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.common.screen.ScreenUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.team.impl.giftteam.GiftSelectItemView;
import com.tencent.timi.game.team.impl.giftteam.GiftSelectView;
import com.tencent.timi.game.ui.ViewWrapper;
import com.tencent.timi.game.utils.b;
import com.tencent.timi.game.utils.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nr2.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import um4.k;
import yn4.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 I2\u00020\u00012\u00020\u0002:\u0003JKLB'\b\u0007\u0012\u0006\u0010C\u001a\u00020B\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010D\u0012\b\b\u0002\u0010F\u001a\u00020)\u00a2\u0006\u0004\bG\u0010HJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u000e\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0011J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0015\u001a\u00020\u0003H\u0016R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR$\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u001dj\b\u0012\u0004\u0012\u00020\u0013`\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R$\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\"0\u001dj\b\u0012\u0004\u0012\u00020\"`\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010 R\u0018\u0010'\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010(\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010&R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010/R\u0016\u00104\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010/R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R \u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0>0=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010@\u00a8\u0006M"}, d2 = {"Lcom/tencent/timi/game/team/impl/giftteam/GiftSelectView;", "Landroid/widget/LinearLayout;", "", "", "v", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "k", "j", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "w", "Landroid/view/View;", "targetView", "l", "", "color", "r", "Lcom/tencent/timi/game/team/impl/giftteam/GiftSelectView$c;", "setListener", "Lcom/tencent/timi/game/team/impl/giftteam/GiftSelectView$b;", "p", "o", "Lnr2/s;", "d", "Lnr2/s;", "binding", "e", "Lcom/tencent/timi/game/team/impl/giftteam/GiftSelectView$c;", "mListener", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "f", "Ljava/util/ArrayList;", "giftData", "Lcom/tencent/timi/game/team/impl/giftteam/GiftSelectItemView;", tl.h.F, "mSubViewsPool", "i", "Lcom/tencent/timi/game/team/impl/giftteam/GiftSelectItemView;", "mLastSelectedView", "mCurrentSelectedView", "", BdhLogUtil.LogTag.Tag_Conn, "I", "mCurrentSelectedIndex", "", "D", "Z", "doingAnim", "E", "lastIsDoingAnim", UserInfo.SEX_FEMALE, "currentIsDoingAnim", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "G", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "mCheckChangedListener", "Lcom/tencent/timi/game/ui/ViewWrapper;", "H", "Lcom/tencent/timi/game/ui/ViewWrapper;", "giftAreaWrapper", "Landroidx/lifecycle/Observer;", "", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "Landroidx/lifecycle/Observer;", "mObserver", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "J", "a", "b", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class GiftSelectView extends LinearLayout {
    private static final int K = ((b.a(114) + b.a(12)) + b.a(14)) + b.a(5);

    /* renamed from: C, reason: from kotlin metadata */
    private int mCurrentSelectedIndex;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean doingAnim;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean lastIsDoingAnim;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean currentIsDoingAnim;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final CompoundButton.OnCheckedChangeListener mCheckChangedListener;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final ViewWrapper giftAreaWrapper;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Observer<List<com.tencent.mobileqq.qqgift.data.service.d>> mObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final s binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c mListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<GiftServerDataEx> giftData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<GiftSelectItemView> mSubViewsPool;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GiftSelectItemView mLastSelectedView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GiftSelectItemView mCurrentSelectedView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0004\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001d\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u0010\u0010\u0013\"\u0004\b\u0017\u0010\u0015\u00a8\u0006\""}, d2 = {"Lcom/tencent/timi/game/team/impl/giftteam/GiftSelectView$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "a", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "()Lcom/tencent/mobileqq/qqgift/data/service/d;", "setData", "(Lcom/tencent/mobileqq/qqgift/data/service/d;)V", "data", "b", "I", "getState", "()I", "setState", "(I)V", "state", "c", "Z", "getWithAnim", "()Z", "setWithAnim", "(Z)V", "withAnim", "d", "selectCount", "<init>", "(Lcom/tencent/mobileqq/qqgift/data/service/d;IZI)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.team.impl.giftteam.GiftSelectView$b, reason: from toString */
    /* loaded from: classes26.dex */
    public static final /* data */ class GiftServerDataEx {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private com.tencent.mobileqq.qqgift.data.service.d data;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private int state;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean withAnim;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private int selectCount;

        public GiftServerDataEx() {
            this(null, 0, false, 0, 15, null);
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final com.tencent.mobileqq.qqgift.data.service.d getData() {
            return this.data;
        }

        /* renamed from: b, reason: from getter */
        public final int getSelectCount() {
            return this.selectCount;
        }

        public final void c(int i3) {
            this.selectCount = i3;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GiftServerDataEx)) {
                return false;
            }
            GiftServerDataEx giftServerDataEx = (GiftServerDataEx) other;
            if (Intrinsics.areEqual(this.data, giftServerDataEx.data) && this.state == giftServerDataEx.state && this.withAnim == giftServerDataEx.withAnim && this.selectCount == giftServerDataEx.selectCount) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((this.data.hashCode() * 31) + this.state) * 31;
            boolean z16 = this.withAnim;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return ((hashCode + i3) * 31) + this.selectCount;
        }

        @NotNull
        public String toString() {
            return "GiftServerDataEx(data=" + this.data + ", state=" + this.state + ", withAnim=" + this.withAnim + ", selectCount=" + this.selectCount + ")";
        }

        public GiftServerDataEx(@NotNull com.tencent.mobileqq.qqgift.data.service.d data, int i3, boolean z16, int i16) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
            this.state = i3;
            this.withAnim = z16;
            this.selectCount = i16;
        }

        public /* synthetic */ GiftServerDataEx(com.tencent.mobileqq.qqgift.data.service.d dVar, int i3, boolean z16, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this((i17 & 1) != 0 ? new com.tencent.mobileqq.qqgift.data.service.d() : dVar, (i17 & 2) != 0 ? 0 : i3, (i17 & 4) != 0 ? false : z16, (i17 & 8) != 0 ? 0 : i16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/timi/game/team/impl/giftteam/GiftSelectView$c;", "", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface c {
        void a();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/team/impl/giftteam/GiftSelectView$f", "Lcom/tencent/timi/game/team/impl/giftteam/GiftSelectItemView$a;", "", "newNum", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class f implements GiftSelectItemView.a {
        f() {
        }

        @Override // com.tencent.timi.game.team.impl.giftteam.GiftSelectItemView.a
        public void a(int newNum) {
            GiftSelectView.this.v();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GiftSelectView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void j() {
        ViewWrapper viewWrapper = this.giftAreaWrapper;
        int i3 = K;
        viewWrapper.setHeight(i3);
        this.binding.f421115b.setVisibility(0);
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.giftAreaWrapper, "height", i3, 0);
        ofInt.setDuration(200L);
        ofInt.addListener(new d());
        ofInt.start();
    }

    private final void k() {
        this.giftAreaWrapper.setHeight(0);
        this.binding.f421115b.setVisibility(0);
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.giftAreaWrapper, "height", 0, K);
        ofInt.setDuration(200L);
        ofInt.addListener(new e());
        ofInt.start();
    }

    private final void l(View targetView) {
        int left = targetView.getLeft();
        int right = targetView.getRight();
        int scrollX = this.binding.f421117d.getScrollX();
        int appScreenWidth = ScreenUtils.getAppScreenWidth();
        int i3 = appScreenWidth + scrollX;
        l.i("GiftSelectView_", "autoScroll left:" + left + ", right:" + right + ", scrollX:" + scrollX + ", screenWidth:" + appScreenWidth);
        int a16 = b.a(16);
        if (right > i3) {
            this.binding.f421117d.smoothScrollBy((right - i3) + a16, 0);
            l.i("GiftSelectView_", "autoScroll right");
        } else if (left < scrollX) {
            this.binding.f421117d.smoothScrollBy(-((scrollX - left) + a16), 0);
            l.i("GiftSelectView_", "autoScroll left");
        } else {
            l.i("GiftSelectView_", "autoScroll needn't scroll");
        }
    }

    private final void m() {
        int a16;
        this.binding.f421116c.removeAllViews();
        Iterator<GiftServerDataEx> it = this.giftData.iterator();
        final int i3 = 0;
        while (it.hasNext()) {
            int i16 = i3 + 1;
            GiftServerDataEx next = it.next();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (i3 == 0) {
                a16 = b.a(16);
            } else {
                a16 = b.a(10);
            }
            layoutParams.leftMargin = a16;
            if (i3 == this.giftData.size() - 1) {
                layoutParams.rightMargin = b.a(16);
            }
            GiftSelectItemView giftSelectItemView = this.mSubViewsPool.get(i3);
            Intrinsics.checkNotNullExpressionValue(giftSelectItemView, "mSubViewsPool[index]");
            final GiftSelectItemView giftSelectItemView2 = giftSelectItemView;
            giftSelectItemView2.setData(next);
            if (i3 == 0) {
                GiftSelectItemView.setState$default(giftSelectItemView2, 2, false, null, 4, null);
                this.mLastSelectedView = giftSelectItemView2;
                this.mCurrentSelectedView = giftSelectItemView2;
                this.mCurrentSelectedIndex = 0;
            } else {
                GiftSelectItemView.setState$default(giftSelectItemView2, 1, false, null, 4, null);
            }
            giftSelectItemView2.setNumChangeListener(new f());
            giftSelectItemView2.setOnClickListener(new View.OnClickListener() { // from class: um4.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GiftSelectView.n(GiftSelectView.this, giftSelectItemView2, i3, view);
                }
            });
            this.binding.f421116c.addView(giftSelectItemView2, layoutParams);
            i3 = i16;
        }
        v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(GiftSelectView this$0, GiftSelectItemView itemView, int i3, View view) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(itemView, "$itemView");
        this$0.l(itemView);
        if (this$0.mCurrentSelectedIndex == i3) {
            l.e("GiftSelectView_", "repeated click");
        } else if (this$0.doingAnim) {
            l.e("GiftSelectView_", " click when anim not finish");
        } else {
            this$0.mCurrentSelectedIndex = i3;
            this$0.mCurrentSelectedView = itemView;
            this$0.currentIsDoingAnim = true;
            if (itemView != null) {
                itemView.setState(2, true, new g());
            }
            GiftSelectItemView giftSelectItemView = this$0.mLastSelectedView;
            if (giftSelectItemView != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            this$0.lastIsDoingAnim = z16;
            if (giftSelectItemView != null) {
                giftSelectItemView.setState(1, true, new h());
            }
            this$0.mLastSelectedView = this$0.mCurrentSelectedView;
            this$0.v();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void q() {
        com.tencent.timi.game.ui.widget.f.c("\u6ca1\u6709\u793c\u7269\u53ef\u4f9b\u9009\u62e9");
        this.binding.f421121h.setOnCheckedChangeListener(null);
        this.binding.f421121h.setChecked(false);
        this.binding.f421121h.setOnCheckedChangeListener(this.mCheckChangedListener);
    }

    private final void s() {
        if (this.mSubViewsPool.size() >= this.giftData.size()) {
            return;
        }
        int size = this.giftData.size();
        while (this.mSubViewsPool.size() < size) {
            ArrayList<GiftSelectItemView> arrayList = this.mSubViewsPool;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            arrayList.add(new GiftSelectItemView(context, null, 0, 6, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(GiftSelectView this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        l.h("GiftSelectView_", 1, "user clicked,isChecked=" + z16);
        this$0.binding.f421121h.setClickable(false);
        if (z16) {
            if (this$0.giftData.isEmpty()) {
                l.e("GiftSelectView_", "giftData isEmpty");
                this$0.q();
                this$0.binding.f421121h.setClickable(true);
            } else {
                this$0.k();
                this$0.v();
            }
        } else {
            this$0.j();
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(GiftSelectView this$0, List list) {
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (list != null) {
            this$0.giftData.clear();
            Iterator it = list.iterator();
            int i16 = 0;
            while (it.hasNext()) {
                int i17 = i16 + 1;
                com.tencent.mobileqq.qqgift.data.service.d dVar = (com.tencent.mobileqq.qqgift.data.service.d) it.next();
                ArrayList<GiftServerDataEx> arrayList = this$0.giftData;
                if (i16 == 0) {
                    i3 = 2;
                } else {
                    i3 = 1;
                }
                arrayList.add(new GiftServerDataEx(dVar, i3, false, 1, 4, null));
                i16 = i17;
            }
            this$0.s();
            this$0.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v() {
        GiftServerDataEx p16 = p();
        if (p16 == null) {
            this.binding.f421120g.setVisibility(4);
            return;
        }
        this.binding.f421120g.setVisibility(0);
        this.binding.f421123j.setText(p16.getData().f264876e);
        this.binding.f421118e.setText(String.valueOf(p16.getSelectCount()));
        this.binding.f421119f.setText(String.valueOf(p16.getSelectCount() * p16.getData().f264878f));
        this.binding.f421120g.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        boolean z16;
        if (!this.lastIsDoingAnim && !this.currentIsDoingAnim) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.doingAnim = z16;
    }

    public void o() {
        Iterator<GiftSelectItemView> it = this.mSubViewsPool.iterator();
        while (it.hasNext()) {
            it.next().h();
        }
        k.f439239a.b().removeObserver(this.mObserver);
    }

    @Nullable
    public final GiftServerDataEx p() {
        if (!this.binding.f421121h.isChecked()) {
            l.k("GiftSelectView_", 1, "getCurrentSelectedGiftData switchBtn is disable!");
            return null;
        }
        int size = this.giftData.size();
        int i3 = this.mCurrentSelectedIndex;
        if (size <= i3) {
            return null;
        }
        return this.giftData.get(i3);
    }

    public final void r(@NotNull String color) {
        Intrinsics.checkNotNullParameter(color, "color");
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.lrb, null);
        if (a.a(color)) {
            PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(Color.parseColor(color), PorterDuff.Mode.SRC);
            if (drawable != null) {
                drawable.setColorFilter(porterDuffColorFilter);
            }
        }
        Drawable drawable2 = ResourcesCompat.getDrawable(getResources(), R.drawable.lr_, null);
        stateListDrawable.addState(new int[]{android.R.attr.state_checked}, drawable);
        stateListDrawable.addState(new int[0], drawable2);
        this.binding.f421121h.setTrackDrawable(stateListDrawable);
    }

    public final void setListener(@NotNull c l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        this.mListener = l3;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GiftSelectView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GiftSelectView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GiftSelectView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        s f16 = s.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        this.giftData = new ArrayList<>();
        this.mSubViewsPool = new ArrayList<>();
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: um4.e
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                GiftSelectView.t(GiftSelectView.this, compoundButton, z16);
            }
        };
        this.mCheckChangedListener = onCheckedChangeListener;
        Observer<List<com.tencent.mobileqq.qqgift.data.service.d>> observer = new Observer() { // from class: um4.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GiftSelectView.u(GiftSelectView.this, (List) obj);
            }
        };
        this.mObserver = observer;
        setOrientation(1);
        LinearLayout linearLayout = f16.f421115b;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.giftArea");
        this.giftAreaWrapper = new ViewWrapper(linearLayout);
        f16.f421121h.setChecked(false);
        f16.f421121h.setOnCheckedChangeListener(onCheckedChangeListener);
        new LinearLayoutManager(context).setOrientation(0);
        k.f439239a.b().observeForever(observer);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/timi/game/team/impl/giftteam/GiftSelectView$d", "Lcom/tencent/mobileqq/widget/f;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d extends com.tencent.mobileqq.widget.f {
        d() {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            GiftSelectView.this.binding.f421115b.setVisibility(8);
            GiftSelectView.this.binding.f421121h.setClickable(true);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/timi/game/team/impl/giftteam/GiftSelectView$e", "Lcom/tencent/mobileqq/widget/f;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class e extends com.tencent.mobileqq.widget.f {
        e() {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            GiftSelectView.this.binding.f421121h.setClickable(true);
            c cVar = GiftSelectView.this.mListener;
            if (cVar != null) {
                cVar.a();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/timi/game/team/impl/giftteam/GiftSelectView$g", "Lcom/tencent/mobileqq/widget/f;", "Landroid/animation/Animator;", "animation", "", "onAnimationCancel", "onAnimationRepeat", "onAnimationEnd", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class g extends com.tencent.mobileqq.widget.f {
        g() {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            GiftSelectView.this.currentIsDoingAnim = false;
            GiftSelectView.this.w();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/timi/game/team/impl/giftteam/GiftSelectView$h", "Lcom/tencent/mobileqq/widget/f;", "Landroid/animation/Animator;", "animation", "", "onAnimationCancel", "onAnimationRepeat", "onAnimationEnd", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class h extends com.tencent.mobileqq.widget.f {
        h() {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            GiftSelectView.this.lastIsDoingAnim = false;
            GiftSelectView.this.w();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
        }
    }
}
