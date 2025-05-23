package com.tencent.timi.game.liveroom.impl.room.playtogether;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.timi.game.liveroom.impl.room.playtogether.presenter.AnchorPlayTogetherPresenter;
import com.tencent.timi.game.liveroom.impl.room.playtogether.widget.AnchorAccountBindView;
import com.tencent.timi.game.liveroom.impl.room.playtogether.widget.AnchorConditionOperationView;
import com.tencent.timi.game.ui.widget.BaseSlideUpDialog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ug4.a;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0001GB\u0019\b\u0016\u0012\u0006\u0010C\u001a\u00020\u000f\u0012\u0006\u00109\u001a\u000206\u00a2\u0006\u0004\bD\u0010EJ\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0003H\u0002J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0016\u0010!\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010\u001cR\u0016\u0010#\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001cR\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0016\u0010+\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010&R\u0016\u0010-\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010&R\u0016\u0010/\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010&R\u0016\u00101\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u0010\u001cR\u001e\u00105\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R&\u0010?\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020<0;0:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020@0:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010>\u00a8\u0006H"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/playtogether/AnchorPlayTogetherDialog;", "Lcom/tencent/timi/game/ui/widget/BaseSlideUpDialog;", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/t;", "", "index", "y0", "condition", "", "z0", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "dismiss", "dismissDialog", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/content/Context;", "x0", "r", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/widget/AnchorAccountBindView;", "T", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/widget/AnchorAccountBindView;", "anchorAccountBindView", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/widget/AnchorConditionOperationView;", "U", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/widget/AnchorConditionOperationView;", "conditionOperationView", "Landroid/widget/ImageView;", "V", "Landroid/widget/ImageView;", "condition1Iv", "W", "condition2Iv", "X", "condition3Iv", "Y", "condition4Iv", "Landroid/widget/FrameLayout;", "Z", "Landroid/widget/FrameLayout;", "condition1Ll", "a0", "condition2Ll", "b0", "condition3Ll", "c0", "condition4Ll", "d0", "containerFl", "e0", "dismissIv", "", "f0", "Ljava/util/List;", "conditionIvList", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/presenter/AnchorPlayTogetherPresenter;", "g0", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/presenter/AnchorPlayTogetherPresenter;", "presenter", "Landroidx/lifecycle/Observer;", "Lkotlin/Pair;", "", "h0", "Landroidx/lifecycle/Observer;", "accountInfoObserver", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/presenter/AnchorPlayTogetherPresenter$a;", "i0", "actionBtnObserver", "ctx", "<init>", "(Landroid/content/Context;Lcom/tencent/timi/game/liveroom/impl/room/playtogether/presenter/AnchorPlayTogetherPresenter;)V", "j0", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class AnchorPlayTogetherDialog extends BaseSlideUpDialog implements t {

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    private AnchorAccountBindView anchorAccountBindView;

    /* renamed from: U, reason: from kotlin metadata */
    private AnchorConditionOperationView conditionOperationView;

    /* renamed from: V, reason: from kotlin metadata */
    private ImageView condition1Iv;

    /* renamed from: W, reason: from kotlin metadata */
    private ImageView condition2Iv;

    /* renamed from: X, reason: from kotlin metadata */
    private ImageView condition3Iv;

    /* renamed from: Y, reason: from kotlin metadata */
    private ImageView condition4Iv;

    /* renamed from: Z, reason: from kotlin metadata */
    private FrameLayout condition1Ll;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private FrameLayout condition2Ll;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private FrameLayout condition3Ll;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private FrameLayout condition4Ll;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private FrameLayout containerFl;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private ImageView dismissIv;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<? extends ImageView> conditionIvList;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AnchorPlayTogetherPresenter presenter;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<Pair<String, String>> accountInfoObserver;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<AnchorPlayTogetherPresenter.a> actionBtnObserver;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/playtogether/AnchorPlayTogetherDialog$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/presenter/AnchorPlayTogetherPresenter;", "presenter", "", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.liveroom.impl.room.playtogether.AnchorPlayTogetherDialog$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull AnchorPlayTogetherPresenter presenter) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(presenter, "presenter");
            new AnchorPlayTogetherDialog(context, presenter).show();
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchorPlayTogetherDialog(@NotNull final Context ctx, @NotNull final AnchorPlayTogetherPresenter presenter) {
        super(ctx);
        List<? extends ImageView> listOf;
        List listOf2;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        this.accountInfoObserver = new Observer() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AnchorPlayTogetherDialog.u0(AnchorPlayTogetherDialog.this, (Pair) obj);
            }
        };
        this.actionBtnObserver = new Observer() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AnchorPlayTogetherDialog.w0(AnchorPlayTogetherDialog.this, (AnchorPlayTogetherPresenter.a) obj);
            }
        };
        this.presenter = presenter;
        final int i3 = 0;
        c0(false);
        setContentView(R.layout.hta);
        View findViewById = findViewById(R.id.f164315sn4);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.anchorAccountBindView)");
        this.anchorAccountBindView = (AnchorAccountBindView) findViewById;
        View findViewById2 = findViewById(R.id.u3o);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.conditionOperationView)");
        this.conditionOperationView = (AnchorConditionOperationView) findViewById2;
        View findViewById3 = findViewById(R.id.u3c);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.condition1Iv)");
        this.condition1Iv = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.u3f);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.condition2Iv)");
        this.condition2Iv = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.u3i);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.condition3Iv)");
        this.condition3Iv = (ImageView) findViewById5;
        View findViewById6 = findViewById(R.id.u3l);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.condition4Iv)");
        this.condition4Iv = (ImageView) findViewById6;
        View findViewById7 = findViewById(R.id.u3d);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.condition1Ll)");
        this.condition1Ll = (FrameLayout) findViewById7;
        View findViewById8 = findViewById(R.id.u3g);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.condition2Ll)");
        this.condition2Ll = (FrameLayout) findViewById8;
        View findViewById9 = findViewById(R.id.u3j);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.condition3Ll)");
        this.condition3Ll = (FrameLayout) findViewById9;
        View findViewById10 = findViewById(R.id.u3m);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.condition4Ll)");
        this.condition4Ll = (FrameLayout) findViewById10;
        View findViewById11 = findViewById(R.id.u65);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.containerFl)");
        this.containerFl = (FrameLayout) findViewById11;
        View findViewById12 = findViewById(R.id.f164994uj1);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(R.id.dismissIv)");
        this.dismissIv = (ImageView) findViewById12;
        ImageView[] imageViewArr = new ImageView[4];
        ImageView imageView = this.condition1Iv;
        AnchorAccountBindView anchorAccountBindView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("condition1Iv");
            imageView = null;
        }
        imageViewArr[0] = imageView;
        ImageView imageView2 = this.condition2Iv;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("condition2Iv");
            imageView2 = null;
        }
        imageViewArr[1] = imageView2;
        ImageView imageView3 = this.condition3Iv;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("condition3Iv");
            imageView3 = null;
        }
        imageViewArr[2] = imageView3;
        ImageView imageView4 = this.condition4Iv;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("condition4Iv");
            imageView4 = null;
        }
        imageViewArr[3] = imageView4;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) imageViewArr);
        this.conditionIvList = listOf;
        FrameLayout[] frameLayoutArr = new FrameLayout[4];
        FrameLayout frameLayout = this.condition1Ll;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("condition1Ll");
            frameLayout = null;
        }
        frameLayoutArr[0] = frameLayout;
        FrameLayout frameLayout2 = this.condition2Ll;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("condition2Ll");
            frameLayout2 = null;
        }
        frameLayoutArr[1] = frameLayout2;
        FrameLayout frameLayout3 = this.condition3Ll;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("condition3Ll");
            frameLayout3 = null;
        }
        frameLayoutArr[2] = frameLayout3;
        FrameLayout frameLayout4 = this.condition4Ll;
        if (frameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("condition4Ll");
            frameLayout4 = null;
        }
        frameLayoutArr[3] = frameLayout4;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) frameLayoutArr);
        FrameLayout frameLayout5 = this.containerFl;
        if (frameLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerFl");
            frameLayout5 = null;
        }
        e0(frameLayout5);
        z0(presenter.getMCurCondition());
        presenter.K(this);
        FrameLayout frameLayout6 = this.containerFl;
        if (frameLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerFl");
            frameLayout6 = null;
        }
        frameLayout6.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorPlayTogetherDialog.p0(AnchorPlayTogetherDialog.this, view);
            }
        });
        ImageView imageView5 = this.dismissIv;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dismissIv");
            imageView5 = null;
        }
        imageView5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorPlayTogetherDialog.q0(AnchorPlayTogetherDialog.this, view);
            }
        });
        for (Object obj : listOf2) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            ((FrameLayout) obj).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AnchorPlayTogetherDialog.r0(AnchorPlayTogetherDialog.this, i3, presenter, view);
                }
            });
            i3 = i16;
        }
        r();
        presenter.O(presenter.x(), true);
        AnchorAccountBindView anchorAccountBindView2 = this.anchorAccountBindView;
        if (anchorAccountBindView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anchorAccountBindView");
        } else {
            anchorAccountBindView = anchorAccountBindView2;
        }
        anchorAccountBindView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorPlayTogetherDialog.s0(AnchorPlayTogetherPresenter.this, ctx, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(AnchorPlayTogetherDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(AnchorPlayTogetherDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(AnchorPlayTogetherDialog this$0, int i3, AnchorPlayTogetherPresenter presenter, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(presenter, "$presenter");
        int y06 = this$0.y0(i3);
        if (!presenter.E()) {
            if (y06 == 5) {
                presenter.y(this$0.x0());
            } else {
                presenter.N(y06);
            }
        } else {
            presenter.O(y06, true);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(AnchorPlayTogetherPresenter presenter, Context ctx, final AnchorPlayTogetherDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(presenter, "$presenter");
        Intrinsics.checkNotNullParameter(ctx, "$ctx");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        presenter.m(ctx, new Function0<Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.AnchorPlayTogetherDialog$4$1
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
                AnchorPlayTogetherDialog.this.dismiss();
            }
        });
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(AnchorPlayTogetherDialog this$0, Pair pair) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (pair == null) {
            return;
        }
        AnchorAccountBindView anchorAccountBindView = this$0.anchorAccountBindView;
        if (anchorAccountBindView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anchorAccountBindView");
            anchorAccountBindView = null;
        }
        anchorAccountBindView.setRoleAccountInfo((String) pair.getSecond(), (String) pair.getFirst(), new Function0<Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.AnchorPlayTogetherDialog$accountInfoObserver$1$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(AnchorPlayTogetherDialog this$0, AnchorPlayTogetherPresenter.a aVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (aVar == null) {
            return;
        }
        AnchorConditionOperationView anchorConditionOperationView = this$0.conditionOperationView;
        if (anchorConditionOperationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("conditionOperationView");
            anchorConditionOperationView = null;
        }
        anchorConditionOperationView.e(aVar, this$0.presenter);
    }

    private final int y0(int index) {
        if (index != 0) {
            if (index != 1) {
                if (index == 2) {
                    return 2;
                }
                return 5;
            }
            return 3;
        }
        return 4;
    }

    private final void z0(int condition) {
        Object orNull;
        Object orNull2;
        Object orNull3;
        Object orNull4;
        List<? extends ImageView> list = this.conditionIvList;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((ImageView) it.next()).setVisibility(8);
            }
        }
        ImageView imageView = null;
        if (condition != 2) {
            if (condition != 3) {
                if (condition != 4) {
                    List<? extends ImageView> list2 = this.conditionIvList;
                    if (list2 != null) {
                        orNull4 = CollectionsKt___CollectionsKt.getOrNull(list2, 3);
                        imageView = (ImageView) orNull4;
                    }
                    if (imageView != null) {
                        imageView.setVisibility(0);
                        return;
                    }
                    return;
                }
                List<? extends ImageView> list3 = this.conditionIvList;
                if (list3 != null) {
                    orNull3 = CollectionsKt___CollectionsKt.getOrNull(list3, 0);
                    imageView = (ImageView) orNull3;
                }
                if (imageView != null) {
                    imageView.setVisibility(0);
                    return;
                }
                return;
            }
            List<? extends ImageView> list4 = this.conditionIvList;
            if (list4 != null) {
                orNull2 = CollectionsKt___CollectionsKt.getOrNull(list4, 1);
                imageView = (ImageView) orNull2;
            }
            if (imageView != null) {
                imageView.setVisibility(0);
                return;
            }
            return;
        }
        List<? extends ImageView> list5 = this.conditionIvList;
        if (list5 != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(list5, 2);
            imageView = (ImageView) orNull;
        }
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.playtogether.t
    public void A(int condition) {
        z0(condition);
    }

    @Override // com.tencent.timi.game.ui.widget.BaseSlideUpDialog, com.tencent.timi.game.ui.widget.b, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        LiveData<AnchorPlayTogetherPresenter.a> s16;
        LiveData<Pair<String, String>> r16;
        super.dismiss();
        AnchorPlayTogetherPresenter anchorPlayTogetherPresenter = this.presenter;
        if (anchorPlayTogetherPresenter != null) {
            anchorPlayTogetherPresenter.K(null);
        }
        AnchorPlayTogetherPresenter anchorPlayTogetherPresenter2 = this.presenter;
        if (anchorPlayTogetherPresenter2 != null && (r16 = anchorPlayTogetherPresenter2.r()) != null) {
            r16.removeObserver(this.accountInfoObserver);
        }
        AnchorPlayTogetherPresenter anchorPlayTogetherPresenter3 = this.presenter;
        if (anchorPlayTogetherPresenter3 != null && (s16 = anchorPlayTogetherPresenter3.s()) != null) {
            s16.removeObserver(this.actionBtnObserver);
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.playtogether.t
    public void dismissDialog() {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.ui.widget.BaseSlideUpDialog, com.tencent.timi.game.ui.widget.j, android.app.Dialog
    public void onCreate(@Nullable Bundle savedInstanceState) {
        AnchorAccountBindView anchorAccountBindView;
        Map mutableMapOf;
        LiveData<AnchorPlayTogetherPresenter.a> s16;
        LiveData<Pair<String, String>> r16;
        mm4.a b16 = mm4.b.b(ug4.a.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(ILiveReportService::class.java)");
        ug4.a aVar = (ug4.a) b16;
        AnchorAccountBindView anchorAccountBindView2 = this.anchorAccountBindView;
        if (anchorAccountBindView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("anchorAccountBindView");
            anchorAccountBindView = null;
        } else {
            anchorAccountBindView = anchorAccountBindView2;
        }
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zengzhi_moduleid", "em_qqlive_palysetting"));
        a.C11346a.a(aVar, anchorAccountBindView, false, null, "em_qqlive_play_changecharacter", mutableMapOf, 6, null);
        PageInfo pageInfo = VideoReport.getPageInfo(null);
        if (pageInfo != null) {
            VideoReport.setLogicParent(findViewById(android.R.id.content), pageInfo.getPageView());
        }
        AnchorPlayTogetherPresenter anchorPlayTogetherPresenter = this.presenter;
        if (anchorPlayTogetherPresenter != null && (r16 = anchorPlayTogetherPresenter.r()) != null) {
            r16.observeForever(this.accountInfoObserver);
        }
        AnchorPlayTogetherPresenter anchorPlayTogetherPresenter2 = this.presenter;
        if (anchorPlayTogetherPresenter2 != null && (s16 = anchorPlayTogetherPresenter2.s()) != null) {
            s16.observeForever(this.actionBtnObserver);
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.playtogether.t
    public void r() {
        AnchorConditionOperationView anchorConditionOperationView;
        Map mutableMapOf;
        mm4.a b16 = mm4.b.b(ug4.a.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(ILiveReportService::class.java)");
        ug4.a aVar = (ug4.a) b16;
        AnchorConditionOperationView anchorConditionOperationView2 = this.conditionOperationView;
        Integer num = null;
        if (anchorConditionOperationView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("conditionOperationView");
            anchorConditionOperationView = null;
        } else {
            anchorConditionOperationView = anchorConditionOperationView2;
        }
        Pair[] pairArr = new Pair[2];
        AnchorPlayTogetherPresenter anchorPlayTogetherPresenter = this.presenter;
        if (anchorPlayTogetherPresenter != null) {
            num = Integer.valueOf(anchorPlayTogetherPresenter.getMCurCondition());
        }
        pairArr[0] = TuplesKt.to(String.valueOf(num), "qqlive_play_teamrequire");
        pairArr[1] = TuplesKt.to("zengzhi_moduleid", "em_qqlive_play_entrance");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        a.C11346a.a(aVar, anchorConditionOperationView, false, null, "em_qqlive_play_entergame", mutableMapOf, 6, null);
    }

    @NotNull
    public Context x0() {
        Context context = this.G;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return context;
    }
}
