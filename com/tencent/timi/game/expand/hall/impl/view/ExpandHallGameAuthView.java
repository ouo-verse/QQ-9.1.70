package com.tencent.timi.game.expand.hall.impl.view;

import ag4.i;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.ui.widget.e;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nr2.bf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameAuthOuterClass$AgreeGameAuthRsp;
import trpc.yes.common.GameAuthOuterClass$CancelGameAuthRsp;
import trpc.yes.common.GameAuthOuterClass$GetGameAuthRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u00019\u0018\u0000 \u00192\u00020\u0001:\u0001FB;\b\u0007\u0012\u0006\u0010>\u001a\u00020=\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010?\u0012\b\b\u0002\u0010A\u001a\u00020\r\u0012\b\b\u0002\u0010B\u001a\u00020\r\u0012\b\b\u0002\u0010C\u001a\u00020(\u00a2\u0006\u0004\bD\u0010EJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\b\u0010\t\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\rJ\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002R\u001c\u0010\u001e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0019\u0012\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010#\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010-\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010\u0019R\u0018\u0010/\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010.R\u0014\u00102\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u00101R\u0014\u00105\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u00104R\u001c\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0014068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u00107R\u0014\u0010;\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010:R\u0016\u0010<\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010&\u00a8\u0006G"}, d2 = {"Lcom/tencent/timi/game/expand/hall/impl/view/ExpandHallGameAuthView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/app/QBaseActivity;", "owner", "", "M", "Landroid/view/View$OnClickListener;", "listener", "setOnBackListener", "E", "setOnCloseListener", "O", "H", "", UserInfo.SEX_FEMALE, BdhLogUtil.LogTag.Tag_Conn, "Landroid/content/DialogInterface;", "dialogInterface", "D", HippyTKDListViewAdapter.X, "Ltrpc/yes/common/GameAuthOuterClass$GetGameAuthRsp;", "value", "G", "y", "P", "I", "L", "d", "getMState$annotations", "()V", "mState", "e", "Landroid/view/View$OnClickListener;", "mOnBackListener", "f", "mOnCloseListener", "", tl.h.F, "Z", "mAuthFlag", "Lgh4/d;", "i", "Lgh4/d;", "mReportHelper", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mYesGameId", "Lcom/tencent/mobileqq/app/QBaseActivity;", "mOwner", "Lnr2/bf;", "Lnr2/bf;", "binding", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "mCheckChangedListener", "Landroidx/lifecycle/Observer;", "Landroidx/lifecycle/Observer;", "authInfoObserver", "com/tencent/timi/game/expand/hall/impl/view/ExpandHallGameAuthView$b", "Lcom/tencent/timi/game/expand/hall/impl/view/ExpandHallGameAuthView$b;", "authCallback", "cancelSucceed", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "yesGameId", "reporterHelper", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IILgh4/d;)V", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class ExpandHallGameAuthView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private QBaseActivity mOwner;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final bf binding;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final CompoundButton.OnCheckedChangeListener mCheckChangedListener;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Observer<GameAuthOuterClass$GetGameAuthRsp> authInfoObserver;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final b authCallback;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean cancelSucceed;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mState;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View.OnClickListener mOnBackListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View.OnClickListener mOnCloseListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mAuthFlag;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final gh4.d mReportHelper;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int mYesGameId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/timi/game/expand/hall/impl/view/ExpandHallGameAuthView$b", "Lag4/i$b;", "Ltrpc/yes/common/GameAuthOuterClass$AgreeGameAuthRsp;", "", "result", "", "errorCode", "", "errorMsg", "rsp", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements i.b<GameAuthOuterClass$AgreeGameAuthRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f376969a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ExpandHallGameAuthView f376970b;

        b(Context context, ExpandHallGameAuthView expandHallGameAuthView) {
            this.f376969a = context;
            this.f376970b = expandHallGameAuthView;
        }

        @Override // ag4.i.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void i(boolean result, int errorCode, @Nullable String errorMsg, @Nullable GameAuthOuterClass$AgreeGameAuthRsp rsp) {
            wf4.a.f445618a.a(this.f376969a);
            com.tencent.timi.game.utils.l.i("ExpandHallSmobaAuthView_", "agree auth result=" + result + ", errorCode=" + errorCode + ", errorMsg=" + errorMsg);
            if (result) {
                QQToast.makeText(this.f376969a, R.string.f227906sa, 0).show();
                ((ag4.i) mm4.b.b(ag4.i.class)).I1(this.f376970b.mYesGameId, null);
            } else {
                QQToast.makeText(this.f376969a, R.string.f227896s_, 0).show();
                this.f376970b.binding.f421025h.setOnCheckedChangeListener(null);
                this.f376970b.binding.f421025h.setChecked(false);
                this.f376970b.binding.f421025h.setOnCheckedChangeListener(this.f376970b.mCheckChangedListener);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/timi/game/expand/hall/impl/view/ExpandHallGameAuthView$d", "Lag4/i$b;", "Ltrpc/yes/common/GameAuthOuterClass$CancelGameAuthRsp;", "", "result", "", "errorCode", "", "errorMsg", "rsp", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements i.b<GameAuthOuterClass$CancelGameAuthRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DialogInterface f376972a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ExpandHallGameAuthView f376973b;

        d(DialogInterface dialogInterface, ExpandHallGameAuthView expandHallGameAuthView) {
            this.f376972a = dialogInterface;
            this.f376973b = expandHallGameAuthView;
        }

        @Override // ag4.i.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void i(boolean result, int errorCode, @Nullable String errorMsg, @Nullable GameAuthOuterClass$CancelGameAuthRsp rsp) {
            wf4.a.f445618a.b(this.f376972a);
            com.tencent.timi.game.utils.l.i("ExpandHallSmobaAuthView_", "cancel auth result=" + result + ", errorCode=" + errorCode + ", errorMsg=" + errorMsg);
            if (result) {
                this.f376973b.cancelSucceed = true;
                QQToast.makeText(this.f376973b.getContext(), R.string.f227926sc, 0).show();
                ((ag4.i) mm4.b.b(ag4.i.class)).I1(this.f376973b.mYesGameId, null);
                this.f376972a.dismiss();
                return;
            }
            QQToast.makeText(this.f376973b.getContext(), R.string.f227916sb, 0).show();
            this.f376973b.binding.f421025h.setOnCheckedChangeListener(null);
            this.f376973b.binding.f421025h.setChecked(true);
            this.f376973b.binding.f421025h.setOnCheckedChangeListener(this.f376973b.mCheckChangedListener);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/expand/hall/impl/view/ExpandHallGameAuthView$e", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class e extends AnimatorListenerAdapter {
        e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            ExpandHallGameAuthView.this.L();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ExpandHallGameAuthView(@NotNull Context context) {
        this(context, null, 0, 0, null, 30, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(ExpandHallGameAuthView this$0, DialogInterface dialogInterface) {
        QBaseActivity qBaseActivity;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.cancelSucceed && (qBaseActivity = this$0.mOwner) != null) {
            this$0.x(qBaseActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(ExpandHallGameAuthView this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QBaseActivity qBaseActivity = this$0.mOwner;
        if (qBaseActivity != null) {
            this$0.x(qBaseActivity);
        }
    }

    private final void C() {
        ((ag4.i) mm4.b.b(ag4.i.class)).F3(this.mYesGameId, vf4.a.b(), Boolean.TRUE, new c(), null);
    }

    private final void D(DialogInterface dialogInterface) {
        wf4.a.f445618a.e(dialogInterface);
        ((ag4.i) mm4.b.b(ag4.i.class)).Z(this.mYesGameId, new d(dialogInterface, this));
    }

    private final void G(GameAuthOuterClass$GetGameAuthRsp value) {
        boolean z16;
        PBBoolField pBBoolField;
        if (value != null && (pBBoolField = value.is_auth) != null) {
            z16 = pBBoolField.get();
        } else {
            z16 = false;
        }
        this.mAuthFlag = z16;
        com.tencent.timi.game.utils.l.i("ExpandHallSmobaAuthView_", "handleGameAuthInfo value:" + value + ", mAuthFlag:" + z16);
        this.binding.f421025h.setOnCheckedChangeListener(null);
        this.binding.f421025h.setChecked(this.mAuthFlag);
        this.binding.f421025h.setOnCheckedChangeListener(this.mCheckChangedListener);
        if (value != null) {
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<String> it = value.auth_desc.get().iterator();
            while (it.hasNext()) {
                stringBuffer.append(it.next());
                stringBuffer.append("\n\n");
            }
            this.binding.f421019b.setText(stringBuffer.toString());
        }
    }

    private final void I() {
        post(new Runnable() { // from class: com.tencent.timi.game.expand.hall.impl.view.m
            @Override // java.lang.Runnable
            public final void run() {
                ExpandHallGameAuthView.J(ExpandHallGameAuthView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(final ExpandHallGameAuthView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final int height = this$0.binding.f421022e.getHeight();
        this$0.binding.f421022e.setTranslationY(0.0f);
        this$0.binding.f421022e.setVisibility(0);
        this$0.post(new Runnable() { // from class: com.tencent.timi.game.expand.hall.impl.view.d
            @Override // java.lang.Runnable
            public final void run() {
                ExpandHallGameAuthView.K(ExpandHallGameAuthView.this, height);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(ExpandHallGameAuthView this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this$0.binding.f421022e, "translationY", 0.0f, i3);
        ofFloat.setDuration(200L);
        ofFloat.addListener(new e());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this$0.binding.f421023f, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        ofFloat2.setDuration(200L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat);
        animatorSet.play(ofFloat2);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L() {
        setVisibility(8);
        this.mState = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(ExpandHallGameAuthView this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.timi.game.utils.l.i("ExpandHallSmobaAuthView_", "user clicked,isChecked=" + z16);
        if (z16) {
            this$0.C();
        } else {
            this$0.y();
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private final void P() {
        setVisibility(0);
        post(new Runnable() { // from class: com.tencent.timi.game.expand.hall.impl.view.b
            @Override // java.lang.Runnable
            public final void run() {
                ExpandHallGameAuthView.Q(ExpandHallGameAuthView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(final ExpandHallGameAuthView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final int height = this$0.binding.f421022e.getHeight();
        this$0.binding.f421022e.setTranslationY(height);
        this$0.binding.f421022e.setVisibility(0);
        this$0.post(new Runnable() { // from class: com.tencent.timi.game.expand.hall.impl.view.c
            @Override // java.lang.Runnable
            public final void run() {
                ExpandHallGameAuthView.R(ExpandHallGameAuthView.this, height);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(ExpandHallGameAuthView this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this$0.binding.f421022e, "translationY", i3, 0.0f);
        ofFloat.setDuration(200L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this$0.binding.f421023f, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat2.setDuration(200L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat);
        animatorSet.play(ofFloat2);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(ExpandHallGameAuthView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View.OnClickListener onClickListener = this$0.mOnBackListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(ExpandHallGameAuthView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View.OnClickListener onClickListener = this$0.mOnCloseListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(ExpandHallGameAuthView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View.OnClickListener onClickListener = this$0.mOnBackListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.timi.game.utils.l.i("ExpandHallSmobaAuthView_", "content clicked");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(ExpandHallGameAuthView this$0, GameAuthOuterClass$GetGameAuthRsp gameAuthOuterClass$GetGameAuthRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.G(gameAuthOuterClass$GetGameAuthRsp);
    }

    private final void x(QBaseActivity owner) {
        LiveData<GameAuthOuterClass$GetGameAuthRsp> G0 = ((ag4.i) mm4.b.b(ag4.i.class)).G0(this.mYesGameId);
        G0.observe(owner, this.authInfoObserver);
        G(G0.getValue());
    }

    private final void y() {
        if (hg4.c.f404865a.d(this.mYesGameId, false)) {
            QQToast.makeText(vf4.a.b(), "\u5df2\u7ecf\u5728\u8f66\u961f\u65f6\u65e0\u6cd5\u8fdb\u884c\u53d6\u6d88\u6388\u6743", 0).show();
            QBaseActivity qBaseActivity = this.mOwner;
            if (qBaseActivity != null) {
                x(qBaseActivity);
                return;
            }
            return;
        }
        this.cancelSucceed = false;
        String X0 = ((ag4.h) mm4.b.b(ag4.h.class)).X0(this.mYesGameId);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        new e.a(context).j("\u53d6\u6d88\u540e\u5c06\u65e0\u6cd5\u53c2\u4e0e\u5c55\u793a" + X0 + "\u6218\u7ee9\u53ca" + X0 + "\u7ec4\u961f\u6e38\u620f\uff0c\u662f\u5426\u53d6\u6d88").p("\u665a\u70b9\u518d\u8bf4").o(new DialogInterface.OnClickListener() { // from class: com.tencent.timi.game.expand.hall.impl.view.j
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ExpandHallGameAuthView.B(ExpandHallGameAuthView.this, dialogInterface, i3);
            }
        }).n("\u72e0\u5fc3\u53d6\u6d88").l(false).m(new DialogInterface.OnClickListener() { // from class: com.tencent.timi.game.expand.hall.impl.view.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ExpandHallGameAuthView.z(ExpandHallGameAuthView.this, dialogInterface, i3);
            }
        }).i(true).h(new DialogInterface.OnDismissListener() { // from class: com.tencent.timi.game.expand.hall.impl.view.l
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                ExpandHallGameAuthView.A(ExpandHallGameAuthView.this, dialogInterface);
            }
        }).c().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(ExpandHallGameAuthView this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(dialogInterface, "dialogInterface");
        this$0.D(dialogInterface);
    }

    @Nullable
    /* renamed from: E, reason: from getter */
    public final View.OnClickListener getMOnBackListener() {
        return this.mOnBackListener;
    }

    /* renamed from: F, reason: from getter */
    public final int getMState() {
        return this.mState;
    }

    public final void H() {
        if (this.mState == 2) {
            return;
        }
        this.mState = 2;
        I();
    }

    public final void M(@NotNull QBaseActivity owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.mOwner = owner;
        x(owner);
    }

    public final void O() {
        if (this.mState == 1) {
            return;
        }
        this.mState = 1;
        P();
    }

    public final void setOnBackListener(@Nullable View.OnClickListener listener) {
        this.mOnBackListener = listener;
    }

    public final void setOnCloseListener(@Nullable View.OnClickListener listener) {
        this.mOnCloseListener = listener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ExpandHallGameAuthView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, null, 28, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ExpandHallGameAuthView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, null, 24, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ExpandHallGameAuthView(Context context, AttributeSet attributeSet, int i3, int i16, gh4.d dVar, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16, (i17 & 16) != 0 ? new gh4.d(new ExpandHallLaunchParam()) : dVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ExpandHallGameAuthView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16, @NotNull gh4.d reporterHelper) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reporterHelper, "reporterHelper");
        this.mState = 2;
        this.mReportHelper = reporterHelper;
        this.mYesGameId = i16;
        bf f16 = bf.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        this.mCheckChangedListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.timi.game.expand.hall.impl.view.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                ExpandHallGameAuthView.N(ExpandHallGameAuthView.this, compoundButton, z16);
            }
        };
        this.authInfoObserver = new Observer() { // from class: com.tencent.timi.game.expand.hall.impl.view.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExpandHallGameAuthView.w(ExpandHallGameAuthView.this, (GameAuthOuterClass$GetGameAuthRsp) obj);
            }
        };
        this.authCallback = new b(context, this);
        setBackgroundResource(R.color.ajr);
        f16.f421020c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.expand.hall.impl.view.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExpandHallGameAuthView.n(ExpandHallGameAuthView.this, view);
            }
        });
        ImageView imageView = f16.f421021d;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.closeIconIgv");
        reporterHelper.a(imageView, reporterHelper.I());
        f16.f421021d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.expand.hall.impl.view.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExpandHallGameAuthView.o(ExpandHallGameAuthView.this, view);
            }
        });
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.expand.hall.impl.view.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExpandHallGameAuthView.p(ExpandHallGameAuthView.this, view);
            }
        });
        f16.f421022e.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.expand.hall.impl.view.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExpandHallGameAuthView.q(view);
            }
        });
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/timi/game/expand/hall/impl/view/ExpandHallGameAuthView$c", "Lag4/i$a;", "Ltrpc/yes/common/GameAuthOuterClass$AgreeGameAuthRsp;", "authInfo", "", "g", "f", "", "errorCode", "", "errorMsg", "d", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements i.a {
        c() {
        }

        @Override // ag4.i.a
        public void d(int errorCode, @Nullable String errorMsg) {
            ExpandHallGameAuthView.this.binding.f421025h.setOnCheckedChangeListener(null);
            ExpandHallGameAuthView.this.binding.f421025h.setChecked(false);
            ExpandHallGameAuthView.this.binding.f421025h.setOnCheckedChangeListener(ExpandHallGameAuthView.this.mCheckChangedListener);
            QQToast.makeText(ExpandHallGameAuthView.this.getContext(), R.string.f227896s_, 0).show();
        }

        @Override // ag4.i.a
        public void f() {
            ExpandHallGameAuthView.this.binding.f421025h.setOnCheckedChangeListener(null);
            ExpandHallGameAuthView.this.binding.f421025h.setChecked(false);
            ExpandHallGameAuthView.this.binding.f421025h.setOnCheckedChangeListener(ExpandHallGameAuthView.this.mCheckChangedListener);
        }

        @Override // ag4.i.a
        public void g(@NotNull GameAuthOuterClass$AgreeGameAuthRsp authInfo) {
            Intrinsics.checkNotNullParameter(authInfo, "authInfo");
            QQToast.makeText(ExpandHallGameAuthView.this.getContext(), R.string.f227906sa, 0).show();
            ExpandHallGameAuthView.this.binding.f421025h.setOnCheckedChangeListener(null);
            ExpandHallGameAuthView.this.binding.f421025h.setChecked(true);
            ExpandHallGameAuthView.this.binding.f421025h.setOnCheckedChangeListener(ExpandHallGameAuthView.this.mCheckChangedListener);
            ((ag4.i) mm4.b.b(ag4.i.class)).I1(ExpandHallGameAuthView.this.mYesGameId, null);
        }

        @Override // ag4.i.c
        public void c() {
        }
    }
}
