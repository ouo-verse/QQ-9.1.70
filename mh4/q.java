package mh4;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.expand.hall.impl.view.ExpandHallGameAuthView;
import com.tencent.timi.game.expand.hall.impl.view.ExpandHallInfoView;
import com.tencent.timi.game.expand.hall.impl.view.ExpandHallRightDrawerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.wuji.WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0002R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lmh4/q;", "", "", "e", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "d", DomainData.DOMAIN_NAME, "", "j", "l", "k", "Lgh4/e;", "a", "Lgh4/e;", "mHall", "Landroid/view/ViewGroup;", "b", "Landroid/view/ViewGroup;", "mRootView", "Lcom/tencent/mobileqq/app/QBaseActivity;", "c", "Lcom/tencent/mobileqq/app/QBaseActivity;", "mContext", "Lcom/tencent/timi/game/expand/hall/impl/view/ExpandHallInfoView;", "Lcom/tencent/timi/game/expand/hall/impl/view/ExpandHallInfoView;", "mExpandHallInfoView", "Lcom/tencent/timi/game/expand/hall/impl/view/ExpandHallRightDrawerView;", "Lcom/tencent/timi/game/expand/hall/impl/view/ExpandHallRightDrawerView;", "mExpandHallRightDrawerView", "Lcom/tencent/timi/game/expand/hall/impl/view/ExpandHallGameAuthView;", "f", "Lcom/tencent/timi/game/expand/hall/impl/view/ExpandHallGameAuthView;", "mGameAuthView", "<init>", "(Lgh4/e;Landroid/view/ViewGroup;Lcom/tencent/mobileqq/app/QBaseActivity;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final gh4.e mHall;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup mRootView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QBaseActivity mContext;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ExpandHallInfoView mExpandHallInfoView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ExpandHallRightDrawerView mExpandHallRightDrawerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ExpandHallGameAuthView mGameAuthView;

    public q(@NotNull gh4.e mHall, @NotNull ViewGroup mRootView, @NotNull QBaseActivity mContext) {
        Intrinsics.checkNotNullParameter(mHall, "mHall");
        Intrinsics.checkNotNullParameter(mRootView, "mRootView");
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mHall = mHall;
        this.mRootView = mRootView;
        this.mContext = mContext;
    }

    private final void e() {
        if (this.mExpandHallInfoView != null) {
            return;
        }
        WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf m75 = this.mHall.m7();
        if (m75 == null) {
            if (com.tencent.timi.game.utils.n.f380308a.b(R.string.f23154725)) {
                QQToast.makeText(this.mContext, R.string.f23154725, 0).show();
                return;
            }
            return;
        }
        this.mExpandHallInfoView = new ExpandHallInfoView(this.mContext, null, 0, this.mHall.o1(), this.mHall.m0(), 6, null);
        this.mRootView.addView(this.mExpandHallInfoView, new RelativeLayout.LayoutParams(-1, -1));
        ExpandHallInfoView expandHallInfoView = this.mExpandHallInfoView;
        if (expandHallInfoView != null) {
            expandHallInfoView.v(this.mContext, m75);
        }
        ExpandHallInfoView expandHallInfoView2 = this.mExpandHallInfoView;
        if (expandHallInfoView2 != null) {
            expandHallInfoView2.setSmobaAuthClickListener(new View.OnClickListener() { // from class: mh4.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    q.f(q.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(q this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g();
        ExpandHallGameAuthView expandHallGameAuthView = this$0.mGameAuthView;
        if (expandHallGameAuthView != null) {
            expandHallGameAuthView.O();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void g() {
        if (this.mGameAuthView != null) {
            return;
        }
        this.mGameAuthView = new ExpandHallGameAuthView(this.mContext, null, 0, this.mHall.o1(), this.mHall.m0(), 6, null);
        this.mRootView.addView(this.mGameAuthView, new RelativeLayout.LayoutParams(-1, -1));
        ExpandHallGameAuthView expandHallGameAuthView = this.mGameAuthView;
        if (expandHallGameAuthView != null) {
            expandHallGameAuthView.M(this.mContext);
        }
        ExpandHallGameAuthView expandHallGameAuthView2 = this.mGameAuthView;
        if (expandHallGameAuthView2 != null) {
            expandHallGameAuthView2.setOnBackListener(new View.OnClickListener() { // from class: mh4.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    q.h(q.this, view);
                }
            });
        }
        ExpandHallGameAuthView expandHallGameAuthView3 = this.mGameAuthView;
        if (expandHallGameAuthView3 != null) {
            expandHallGameAuthView3.setOnCloseListener(new View.OnClickListener() { // from class: mh4.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    q.i(q.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(q this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ExpandHallGameAuthView expandHallGameAuthView = this$0.mGameAuthView;
        if (expandHallGameAuthView != null) {
            expandHallGameAuthView.H();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(q this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ExpandHallGameAuthView expandHallGameAuthView = this$0.mGameAuthView;
        if (expandHallGameAuthView != null) {
            expandHallGameAuthView.H();
        }
        ExpandHallInfoView expandHallInfoView = this$0.mExpandHallInfoView;
        if (expandHallInfoView != null) {
            expandHallInfoView.q();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void d() {
        if (this.mExpandHallRightDrawerView != null) {
            return;
        }
        this.mExpandHallRightDrawerView = new ExpandHallRightDrawerView(this.mContext, null, 0, this.mHall.O(), 6, null);
        this.mRootView.addView(this.mExpandHallRightDrawerView, new RelativeLayout.LayoutParams(-1, -1));
    }

    public final boolean j() {
        boolean z16;
        boolean z17;
        boolean z18;
        View.OnClickListener mOnBackListener;
        ExpandHallGameAuthView expandHallGameAuthView = this.mGameAuthView;
        if (expandHallGameAuthView != null && expandHallGameAuthView.getMState() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.timi.game.utils.l.i("ExpandHallFragment_", "smobaAuthViewShowing:" + z16);
        if (z16) {
            ExpandHallGameAuthView expandHallGameAuthView2 = this.mGameAuthView;
            if (expandHallGameAuthView2 != null && (mOnBackListener = expandHallGameAuthView2.getMOnBackListener()) != null) {
                mOnBackListener.onClick(null);
            }
            ExpandHallGameAuthView expandHallGameAuthView3 = this.mGameAuthView;
            if (expandHallGameAuthView3 != null) {
                expandHallGameAuthView3.H();
            }
            return true;
        }
        ExpandHallInfoView expandHallInfoView = this.mExpandHallInfoView;
        if (expandHallInfoView != null && expandHallInfoView.getMState() == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        com.tencent.timi.game.utils.l.i("ExpandHallFragment_", "expandHallInfoShowing:" + z17);
        if (z17) {
            ExpandHallInfoView expandHallInfoView2 = this.mExpandHallInfoView;
            if (expandHallInfoView2 != null) {
                expandHallInfoView2.q();
            }
            return true;
        }
        ExpandHallRightDrawerView expandHallRightDrawerView = this.mExpandHallRightDrawerView;
        if (expandHallRightDrawerView != null && expandHallRightDrawerView.getMState() == 1) {
            z18 = true;
        } else {
            z18 = false;
        }
        com.tencent.timi.game.utils.l.i("ExpandHallFragment_", "expandHallRightDrawerShowing:" + z18);
        if (!z18) {
            return false;
        }
        ExpandHallRightDrawerView expandHallRightDrawerView2 = this.mExpandHallRightDrawerView;
        if (expandHallRightDrawerView2 != null) {
            expandHallRightDrawerView2.r();
        }
        return true;
    }

    public final void k() {
        ExpandHallGameAuthView expandHallGameAuthView = this.mGameAuthView;
        if (expandHallGameAuthView != null) {
            expandHallGameAuthView.setOnBackListener(null);
        }
        ExpandHallGameAuthView expandHallGameAuthView2 = this.mGameAuthView;
        if (expandHallGameAuthView2 != null) {
            expandHallGameAuthView2.setOnCloseListener(null);
        }
        ExpandHallInfoView expandHallInfoView = this.mExpandHallInfoView;
        if (expandHallInfoView != null) {
            expandHallInfoView.setSmobaAuthClickListener(null);
        }
    }

    public final boolean l() {
        ExpandHallRightDrawerView expandHallRightDrawerView = this.mExpandHallRightDrawerView;
        if (expandHallRightDrawerView != null) {
            return expandHallRightDrawerView.A();
        }
        return false;
    }

    public final void m() {
        e();
        ExpandHallInfoView expandHallInfoView = this.mExpandHallInfoView;
        if (expandHallInfoView != null) {
            expandHallInfoView.D();
        }
    }

    public final void n() {
        ExpandHallRightDrawerView expandHallRightDrawerView = this.mExpandHallRightDrawerView;
        if (expandHallRightDrawerView != null) {
            expandHallRightDrawerView.B();
        }
    }
}
