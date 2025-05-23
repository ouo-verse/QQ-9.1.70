package com.tencent.timi.game.liveroom.impl.room.playtogether;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.timi.game.liveroom.impl.room.gameinfo.LiveGameInfoTextView;
import com.tencent.timi.game.liveroom.impl.room.playtogether.presenter.BasePlayTogetherJoinPresenter;
import com.tencent.timi.game.ui.widget.BaseSlideUpDialog;
import com.tencent.timi.game.userinfo.api.view.AvatarRoundImageView;
import com.tencent.timi.game.widget.MediumBoldTextView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.PremadesTeamServerOuterClass$AnchorGameInfo;
import trpc.yes.common.YoloTeamOuterClass$YoloLiveTeamInfo;
import trpc.yes.common.YoloTeamOuterClass$YoloTeamPlayerInfo;
import ug4.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 |2\u00020\u00012\u00020\u0002:\u0001}B\u0017\u0012\u0006\u0010y\u001a\u00020x\u0012\u0006\u0010(\u001a\u00020\u001e\u00a2\u0006\u0004\bz\u0010{J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\"\u0010\u000f\u001a\u00020\u00052\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bH\u0002J\"\u0010\u0010\u001a\u00020\u00052\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bH\u0002J&\u0010\u0015\u001a\u00020\u00052\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\fH\u0002J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0003H\u0002J\u0012\u0010\u001b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002J\u0012\u0010\u001d\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0016H\u0002J\f\u0010\u001f\u001a\u00020\u0005*\u00020\u001eH\u0002J\u0012\u0010\"\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010 H\u0014J\b\u0010#\u001a\u00020\u0005H\u0016J\b\u0010$\u001a\u00020\u0005H\u0016J\b\u0010%\u001a\u00020\u0005H\u0016R\u0018\u0010(\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00130\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00130\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u0016\u00100\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010/R\u0016\u00104\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010/R\u0016\u00106\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010/R\u0016\u00108\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010/R\u0016\u0010:\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010/R\u0016\u0010<\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010/R\u0016\u0010>\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010/R\u0016\u0010@\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010/R\u0016\u0010B\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010/R\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010I\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010O\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010HR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010U\u001a\u00020J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010LR\u0016\u0010\u001a\u001a\u00020V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010^\u001a\u00020P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010RR\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010d\u001a\u00020_8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010aR\u0016\u0010f\u001a\u00020C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010ER\u0016\u0010h\u001a\u00020_8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010aR\u0016\u0010j\u001a\u00020P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010RR\u001c\u0010n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070k8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u001a\u0010p\u001a\b\u0012\u0004\u0012\u00020\u00070k8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bo\u0010mR\u001a\u0010s\u001a\b\u0012\u0004\u0012\u00020q0k8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\br\u0010mR\u001a\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00160k8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bt\u0010mR,\u0010w\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0k8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bv\u0010m\u00a8\u0006~"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/playtogether/s;", "Lcom/tencent/timi/game/ui/widget/BaseSlideUpDialog;", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/u;", "", "isNotGamingYet", "", "R0", "", "condition", "P0", "(Ljava/lang/Integer;)V", "Lkotlin/Pair;", "", "Ltrpc/yes/common/YoloTeamOuterClass$YoloTeamPlayerInfo;", "pair", "T0", "Q0", "", "teamUserInfoList", "Lcom/tencent/timi/game/userinfo/api/view/AvatarRoundImageView;", "memberIvListView", "S0", "", "H0", "I0", "Landroid/widget/ImageView;", "anchorIv", "K0", "fansText", "L0", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/presenter/BasePlayTogetherJoinPresenter;", "D0", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "dismiss", "dismissDialog", "showDialog", "T", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/presenter/BasePlayTogetherJoinPresenter;", "presenter", "U", "Ljava/util/List;", "memberIvList", "V", "otherMemberIvList", "W", "Lcom/tencent/timi/game/userinfo/api/view/AvatarRoundImageView;", "member1Iv", "X", "member2Iv", "Y", "member3Iv", "Z", "member4Iv", "a0", "member5Iv", "b0", "otherMember1Iv", "c0", "otherMember2Iv", "d0", "otherMember3Iv", "e0", "otherMember4Iv", "f0", "otherMember5Iv", "Landroid/widget/FrameLayout;", "g0", "Landroid/widget/FrameLayout;", "containerFl", "h0", "Landroid/widget/ImageView;", "cancelIv", "Lcom/tencent/timi/game/widget/MediumBoldTextView;", "i0", "Lcom/tencent/timi/game/widget/MediumBoldTextView;", "joinBtn", "j0", "accountSwitchIv", "Landroid/widget/TextView;", "k0", "Landroid/widget/TextView;", "accountInfoTv", "l0", "titleTv", "Lcom/tencent/mobileqq/widget/RoundImageView;", "m0", "Lcom/tencent/mobileqq/widget/RoundImageView;", "Lcom/tencent/timi/game/liveroom/impl/room/gameinfo/LiveGameInfoTextView;", "n0", "Lcom/tencent/timi/game/liveroom/impl/room/gameinfo/LiveGameInfoTextView;", "entranceTitle", "o0", "teamDetailTv", "Landroid/widget/LinearLayout;", "p0", "Landroid/widget/LinearLayout;", "memberTotalContainer", "q0", "canNotJoinContainer", "r0", "anchorInfoContainer", "s0", "otherMemberContainer", "t0", "fansTitle", "Landroidx/lifecycle/Observer;", "u0", "Landroidx/lifecycle/Observer;", "joinConditionObserver", "v0", "statusObserver", "", "w0", "teamDetailObserver", "x0", "accountInfoObserver", "y0", "teamUserInfoListObserver", "Landroid/content/Context;", "ctx", "<init>", "(Landroid/content/Context;Lcom/tencent/timi/game/liveroom/impl/room/playtogether/presenter/BasePlayTogetherJoinPresenter;)V", "z0", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class s extends BaseSlideUpDialog implements u {

    /* renamed from: z0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private BasePlayTogetherJoinPresenter presenter;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final List<AvatarRoundImageView> memberIvList;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final List<AvatarRoundImageView> otherMemberIvList;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private AvatarRoundImageView member1Iv;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private AvatarRoundImageView member2Iv;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private AvatarRoundImageView member3Iv;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private AvatarRoundImageView member4Iv;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AvatarRoundImageView member5Iv;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AvatarRoundImageView otherMember1Iv;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AvatarRoundImageView otherMember2Iv;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AvatarRoundImageView otherMember3Iv;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AvatarRoundImageView otherMember4Iv;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AvatarRoundImageView otherMember5Iv;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private FrameLayout containerFl;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageView cancelIv;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MediumBoldTextView joinBtn;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageView accountSwitchIv;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView accountInfoTv;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MediumBoldTextView titleTv;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RoundImageView anchorIv;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LiveGameInfoTextView entranceTitle;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView teamDetailTv;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinearLayout memberTotalContainer;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinearLayout canNotJoinContainer;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private FrameLayout anchorInfoContainer;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinearLayout otherMemberContainer;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView fansTitle;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<Integer> joinConditionObserver;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<Integer> statusObserver;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<CharSequence> teamDetailObserver;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<String> accountInfoObserver;

    /* renamed from: y0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<Pair<Integer, List<YoloTeamOuterClass$YoloTeamPlayerInfo>>> teamUserInfoListObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bR\u0014\u0010\f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/playtogether/s$a;", "", "Landroid/content/Context;", "ctx", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/presenter/BasePlayTogetherJoinPresenter;", "presenter", "", "dialogOpenFlag", "Lpf4/b;", "playTogetherPanelListener", "", "a", "CREATE_TYPE_TEAM", "I", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.liveroom.impl.room.playtogether.s$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context ctx, @Nullable BasePlayTogetherJoinPresenter presenter, int dialogOpenFlag, @Nullable pf4.b playTogetherPanelListener) {
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            if (presenter != null) {
                presenter.V(new s(ctx, presenter));
                presenter.h(dialogOpenFlag);
                presenter.R(playTogetherPanelListener);
            }
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(@NotNull final Context ctx, @NotNull final BasePlayTogetherJoinPresenter presenter) {
        super(ctx);
        List<AvatarRoundImageView> listOf;
        List<AvatarRoundImageView> listOf2;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        this.presenter = presenter;
        setContentView(R.layout.htg);
        View findViewById = findViewById(R.id.z18);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.member1Iv)");
        this.member1Iv = (AvatarRoundImageView) findViewById;
        View findViewById2 = findViewById(R.id.z19);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.member2Iv)");
        this.member2Iv = (AvatarRoundImageView) findViewById2;
        View findViewById3 = findViewById(R.id.z1_);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.member3Iv)");
        this.member3Iv = (AvatarRoundImageView) findViewById3;
        View findViewById4 = findViewById(R.id.z1a);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.member4Iv)");
        this.member4Iv = (AvatarRoundImageView) findViewById4;
        View findViewById5 = findViewById(R.id.z1b);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.member5Iv)");
        this.member5Iv = (AvatarRoundImageView) findViewById5;
        View findViewById6 = findViewById(R.id.f216101h);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.otherMember1Iv)");
        this.otherMember1Iv = (AvatarRoundImageView) findViewById6;
        View findViewById7 = findViewById(R.id.f216201i);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.otherMember2Iv)");
        this.otherMember2Iv = (AvatarRoundImageView) findViewById7;
        View findViewById8 = findViewById(R.id.f216301j);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.otherMember3Iv)");
        this.otherMember3Iv = (AvatarRoundImageView) findViewById8;
        View findViewById9 = findViewById(R.id.f216401k);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.otherMember4Iv)");
        this.otherMember4Iv = (AvatarRoundImageView) findViewById9;
        View findViewById10 = findViewById(R.id.f216501l);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.otherMember5Iv)");
        this.otherMember5Iv = (AvatarRoundImageView) findViewById10;
        View findViewById11 = findViewById(R.id.u65);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.containerFl)");
        this.containerFl = (FrameLayout) findViewById11;
        View findViewById12 = findViewById(R.id.tld);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(R.id.cancelIv)");
        this.cancelIv = (ImageView) findViewById12;
        View findViewById13 = findViewById(R.id.y_w);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "findViewById(R.id.joinBtn)");
        this.joinBtn = (MediumBoldTextView) findViewById13;
        View findViewById14 = findViewById(R.id.s7w);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "findViewById(R.id.accountSwitchIv)");
        this.accountSwitchIv = (ImageView) findViewById14;
        View findViewById15 = findViewById(R.id.s7t);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "findViewById(R.id.accountInfoTv)");
        this.accountInfoTv = (TextView) findViewById15;
        View findViewById16 = findViewById(R.id.f98175md);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "findViewById(R.id.titleTv)");
        this.titleTv = (MediumBoldTextView) findViewById16;
        View findViewById17 = findViewById(R.id.snd);
        Intrinsics.checkNotNullExpressionValue(findViewById17, "findViewById(R.id.anchorIv)");
        this.anchorIv = (RoundImageView) findViewById17;
        View findViewById18 = findViewById(R.id.uvz);
        Intrinsics.checkNotNullExpressionValue(findViewById18, "findViewById(R.id.entranceTitle)");
        this.entranceTitle = (LiveGameInfoTextView) findViewById18;
        View findViewById19 = findViewById(R.id.f926758i);
        Intrinsics.checkNotNullExpressionValue(findViewById19, "findViewById(R.id.teamDetailTv)");
        this.teamDetailTv = (TextView) findViewById19;
        View findViewById20 = findViewById(R.id.z1f);
        Intrinsics.checkNotNullExpressionValue(findViewById20, "findViewById(R.id.memberTotalContainer)");
        this.memberTotalContainer = (LinearLayout) findViewById20;
        View findViewById21 = findViewById(R.id.tlb);
        Intrinsics.checkNotNullExpressionValue(findViewById21, "findViewById(R.id.canNotJoinContainer)");
        this.canNotJoinContainer = (LinearLayout) findViewById21;
        View findViewById22 = findViewById(R.id.snb);
        Intrinsics.checkNotNullExpressionValue(findViewById22, "findViewById(R.id.anchorInfoContainer)");
        this.anchorInfoContainer = (FrameLayout) findViewById22;
        View findViewById23 = findViewById(R.id.f216601m);
        Intrinsics.checkNotNullExpressionValue(findViewById23, "findViewById(R.id.otherMemberContainer)");
        this.otherMemberContainer = (LinearLayout) findViewById23;
        View findViewById24 = findViewById(R.id.f165132v01);
        Intrinsics.checkNotNullExpressionValue(findViewById24, "findViewById(R.id.fansTitle)");
        this.fansTitle = (TextView) findViewById24;
        c0(false);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new AvatarRoundImageView[]{this.member1Iv, this.member2Iv, this.member3Iv, this.member4Iv, this.member5Iv});
        this.memberIvList = listOf;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new AvatarRoundImageView[]{this.otherMember1Iv, this.otherMember2Iv, this.otherMember3Iv, this.otherMember4Iv, this.otherMember5Iv});
        this.otherMemberIvList = listOf2;
        e0(this.containerFl);
        this.containerFl.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                s.x0(s.this, view);
            }
        });
        this.cancelIv.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                s.y0(s.this, view);
            }
        });
        this.joinBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                s.z0(BasePlayTogetherJoinPresenter.this, ctx, view);
            }
        });
        this.accountSwitchIv.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                s.A0(BasePlayTogetherJoinPresenter.this, this, view);
            }
        });
        this.accountInfoTv.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                s.B0(BasePlayTogetherJoinPresenter.this, this, view);
            }
        });
        this.joinConditionObserver = new Observer() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                s.J0(s.this, (Integer) obj);
            }
        };
        this.statusObserver = new Observer() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                s.M0(s.this, presenter, (Integer) obj);
            }
        };
        this.teamDetailObserver = new Observer() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                s.N0(s.this, (CharSequence) obj);
            }
        };
        this.accountInfoObserver = new Observer() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                s.C0(s.this, (String) obj);
            }
        };
        this.teamUserInfoListObserver = new Observer() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                s.O0(s.this, (Pair) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(BasePlayTogetherJoinPresenter presenter, s this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(presenter, "$presenter");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.G;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        presenter.g(context);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(BasePlayTogetherJoinPresenter presenter, s this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(presenter, "$presenter");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.G;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        presenter.g(context);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(s this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (str == null) {
            return;
        }
        this$0.accountInfoTv.setText(str);
    }

    private final void D0(final BasePlayTogetherJoinPresenter basePlayTogetherJoinPresenter) {
        Map mutableMapOf;
        Map mutableMapOf2;
        mm4.a b16 = mm4.b.b(ug4.a.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(ILiveReportService::class.java)");
        a.C11346a.a((ug4.a) b16, this.cancelIv, false, null, "em_qqlive_play_detailclose", null, 22, null);
        VideoReport.setEventDynamicParams(this.cancelIv, new IDynamicParams() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.g
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map E0;
                E0 = s.E0(BasePlayTogetherJoinPresenter.this, str);
                return E0;
            }
        });
        mm4.a b17 = mm4.b.b(ug4.a.class);
        Intrinsics.checkNotNullExpressionValue(b17, "getService(ILiveReportService::class.java)");
        TextView textView = this.accountInfoTv;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zengzhi_moduleid", "em_qqlive_play_entrance"));
        a.C11346a.a((ug4.a) b17, textView, false, null, "em_qqlive_play_changecharacter", mutableMapOf, 6, null);
        mm4.a b18 = mm4.b.b(ug4.a.class);
        Intrinsics.checkNotNullExpressionValue(b18, "getService(ILiveReportService::class.java)");
        ug4.a aVar = (ug4.a) b18;
        MediumBoldTextView mediumBoldTextView = this.joinBtn;
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zengzhi_moduleid", "em_qqlive_play_entrance"));
        a.C11346a.a(aVar, mediumBoldTextView, false, null, "em_qqlive_play_entergame", mutableMapOf2, 6, null);
        mm4.a b19 = mm4.b.b(ug4.a.class);
        Intrinsics.checkNotNullExpressionValue(b19, "getService(ILiveReportService::class.java)");
        a.C11346a.a((ug4.a) b19, this.joinBtn, false, null, "em_qqlive_play_detailsure", null, 22, null);
        VideoReport.setEventDynamicParams(this.joinBtn, new IDynamicParams() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.j
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map F0;
                F0 = s.F0(BasePlayTogetherJoinPresenter.this, str);
                return F0;
            }
        });
        PageInfo pageInfo = VideoReport.getPageInfo(null);
        if (pageInfo != null) {
            VideoReport.setLogicParent(findViewById(android.R.id.content), pageInfo.getPageView());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map E0(BasePlayTogetherJoinPresenter this_bindReport, String str) {
        Object obj;
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(this_bindReport, "$this_bindReport");
        Pair[] pairArr = new Pair[6];
        pairArr[0] = TuplesKt.to("zengzhi_moduleid", "em_qqlive_play_entrance");
        pairArr[1] = TuplesKt.to("qqlive_play_comingway", this_bindReport.z());
        String str2 = "1";
        if (this_bindReport.I()) {
            obj = "1";
        } else {
            obj = "0";
        }
        pairArr[2] = TuplesKt.to("qqlive_play_teamstatus", obj);
        if (this_bindReport.N()) {
            str2 = "0";
        }
        pairArr[3] = TuplesKt.to("qqlive_team_seat", str2);
        pairArr[4] = TuplesKt.to("qqlive_play_gamemode", this_bindReport.A());
        pairArr[5] = TuplesKt.to("qqlive_play_teamrequire", String.valueOf(this_bindReport.getJoinCondition()));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        return mutableMapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map F0(BasePlayTogetherJoinPresenter this_bindReport, String str) {
        Object obj;
        Object obj2;
        Object obj3;
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(this_bindReport, "$this_bindReport");
        Pair[] pairArr = new Pair[8];
        String str2 = "1";
        if (this_bindReport.N()) {
            obj = "1";
        } else {
            obj = "0";
        }
        pairArr[0] = TuplesKt.to("qqlive_play_detailstatus", obj);
        if (this_bindReport.H()) {
            obj2 = "1";
        } else {
            obj2 = "0";
        }
        pairArr[1] = TuplesKt.to("qqlive_follow_status", obj2);
        pairArr[2] = TuplesKt.to("qqlive_play_comingway", this_bindReport.z());
        if (this_bindReport.I()) {
            obj3 = "1";
        } else {
            obj3 = "0";
        }
        pairArr[3] = TuplesKt.to("qqlive_play_teamstatus", obj3);
        if (this_bindReport.N()) {
            str2 = "0";
        }
        pairArr[4] = TuplesKt.to("qqlive_team_seat", str2);
        pairArr[5] = TuplesKt.to("qqlive_play_gamemode", this_bindReport.A());
        pairArr[6] = TuplesKt.to("qqlive_play_teamrequire", String.valueOf(this_bindReport.getJoinCondition()));
        pairArr[7] = TuplesKt.to("zengzhi_moduleid", "em_qqlive_play_entrance");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        return mutableMapOf;
    }

    private final String H0() {
        long j3;
        kf4.b e16;
        if (I0()) {
            si4.a l26 = ((ni4.a) mm4.b.b(ni4.a.class)).l2();
            if (l26 == null || (e16 = l26.e()) == null) {
                return null;
            }
            return e16.f412314c;
        }
        BasePlayTogetherJoinPresenter basePlayTogetherJoinPresenter = this.presenter;
        if (basePlayTogetherJoinPresenter != null) {
            j3 = basePlayTogetherJoinPresenter.B();
        } else {
            j3 = 0;
        }
        jg4.h n3 = ((jg4.b) mm4.b.b(jg4.b.class)).n(j3);
        if (n3 == null) {
            return null;
        }
        return n3.f409909c;
    }

    private final boolean I0() {
        if (this.presenter instanceof com.tencent.timi.game.liveroom.impl.room.playtogether.presenter.g) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(s this$0, Integer num) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.P0(num);
    }

    private final void K0(ImageView anchorIv) {
        if (anchorIv != null) {
            com.tencent.timi.game.utils.d dVar = com.tencent.timi.game.utils.d.f380295a;
            dVar.d(H0(), anchorIv, dVar.c(anchorIv.getMeasuredWidth(), anchorIv, R.drawable.ovu));
        }
    }

    private final void L0(String fansText) {
        if (TextUtils.isEmpty(fansText)) {
            this.fansTitle.setVisibility(8);
        } else {
            this.fansTitle.setVisibility(0);
            this.fansTitle.setText(fansText);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(s this$0, BasePlayTogetherJoinPresenter presenter, Integer num) {
        String str;
        List<String> list;
        PBStringField pBStringField;
        PBRepeatField<String> pBRepeatField;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(presenter, "$presenter");
        this$0.P0(Integer.valueOf(presenter.getJoinCondition()));
        boolean z16 = true;
        if (num != null && num.intValue() == 1 && presenter.getJoinCondition() != 5) {
            z16 = false;
        }
        this$0.R0(z16);
        MediumBoldTextView mediumBoldTextView = this$0.titleTv;
        if (z16) {
            str = "\u6682\u4e0d\u53ef\u52a0\u5165\u4e3b\u64ad\u961f\u4f0d";
        } else if (presenter.I()) {
            str = "\u4e3b\u64ad\u672c\u5c40\u5df2\u53d1\u8f66";
        } else {
            str = "\u4e3b\u64ad\u6b63\u5728\u7b49\u5f85\u961f\u53cb";
        }
        mediumBoldTextView.setText(str);
        this$0.K0(this$0.anchorIv);
        LiveGameInfoTextView liveGameInfoTextView = this$0.entranceTitle;
        PremadesTeamServerOuterClass$AnchorGameInfo anchorGameInfo = presenter.getAnchorGameInfo();
        String str2 = null;
        if (anchorGameInfo != null && (pBRepeatField = anchorGameInfo.new_title) != null) {
            list = pBRepeatField.get();
        } else {
            list = null;
        }
        liveGameInfoTextView.setData(list);
        PremadesTeamServerOuterClass$AnchorGameInfo anchorGameInfo2 = presenter.getAnchorGameInfo();
        if (anchorGameInfo2 != null && (pBStringField = anchorGameInfo2.fans_data) != null) {
            str2 = pBStringField.get();
        }
        this$0.L0(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(s this$0, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (charSequence == null) {
            return;
        }
        this$0.teamDetailTv.setText(charSequence);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(s this$0, Pair pair) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (pair == null) {
            return;
        }
        this$0.T0(pair);
    }

    private final void P0(Integer condition) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        String str;
        BasePlayTogetherJoinPresenter basePlayTogetherJoinPresenter = this.presenter;
        boolean z26 = true;
        if (basePlayTogetherJoinPresenter != null && basePlayTogetherJoinPresenter.K()) {
            z16 = true;
        } else {
            z16 = false;
        }
        String str2 = "\u8fdb\u5165\u6e38\u620f";
        if (z16) {
            this.joinBtn.setText("\u8fdb\u5165\u6e38\u620f");
            return;
        }
        BasePlayTogetherJoinPresenter basePlayTogetherJoinPresenter2 = this.presenter;
        if (basePlayTogetherJoinPresenter2 != null && basePlayTogetherJoinPresenter2.I()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            BasePlayTogetherJoinPresenter basePlayTogetherJoinPresenter3 = this.presenter;
            if (basePlayTogetherJoinPresenter3 != null && basePlayTogetherJoinPresenter3.N()) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (!z18) {
                BasePlayTogetherJoinPresenter basePlayTogetherJoinPresenter4 = this.presenter;
                if (basePlayTogetherJoinPresenter4 != null && basePlayTogetherJoinPresenter4.getJoinCondition() == 5) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                if (!z19) {
                    MediumBoldTextView mediumBoldTextView = this.joinBtn;
                    if (condition != null && condition.intValue() == 2) {
                        BasePlayTogetherJoinPresenter basePlayTogetherJoinPresenter5 = this.presenter;
                        if (basePlayTogetherJoinPresenter5 == null || !basePlayTogetherJoinPresenter5.H()) {
                            z26 = false;
                        }
                        if (z26) {
                            str = "\u5df2\u5173\u6ce8\uff0c\u76f4\u63a5\u52a0\u5165";
                        } else {
                            str = "\u5173\u6ce8\u540e\u52a0\u5165";
                        }
                        str2 = str;
                    } else if (condition != null && condition.intValue() == 3) {
                        str2 = "\u8bc4\u8bba\u540e\u52a0\u5165";
                    }
                    mediumBoldTextView.setText(str2);
                    return;
                }
            }
        }
        this.joinBtn.setText("\u544a\u8bc9\u4e3b\u64ad, \u60f3\u73a9\u4e0b\u4e00\u5c40");
    }

    private final void Q0(Pair<Integer, ? extends List<YoloTeamOuterClass$YoloTeamPlayerInfo>> pair) {
        if (pair.getFirst().intValue() == 1) {
            this.otherMemberContainer.setVisibility(8);
        } else {
            this.otherMemberContainer.setVisibility(0);
        }
    }

    private final void R0(boolean isNotGamingYet) {
        if (isNotGamingYet) {
            this.memberTotalContainer.setVisibility(8);
            this.canNotJoinContainer.setVisibility(0);
            this.anchorInfoContainer.setVisibility(0);
            this.teamDetailTv.setVisibility(8);
            return;
        }
        this.memberTotalContainer.setVisibility(0);
        this.canNotJoinContainer.setVisibility(8);
        this.anchorInfoContainer.setVisibility(8);
        this.teamDetailTv.setVisibility(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void S0(List<YoloTeamOuterClass$YoloTeamPlayerInfo> teamUserInfoList, List<? extends AvatarRoundImageView> memberIvListView) {
        YoloTeamOuterClass$YoloTeamPlayerInfo yoloTeamOuterClass$YoloTeamPlayerInfo;
        boolean z16;
        boolean z17;
        int i3;
        String str;
        Object orNull;
        int i16 = 0;
        for (Object obj : memberIvListView) {
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            AvatarRoundImageView avatarRoundImageView = (AvatarRoundImageView) obj;
            if (teamUserInfoList != null) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(teamUserInfoList, i16);
                yoloTeamOuterClass$YoloTeamPlayerInfo = (YoloTeamOuterClass$YoloTeamPlayerInfo) orNull;
            } else {
                yoloTeamOuterClass$YoloTeamPlayerInfo = null;
            }
            if (yoloTeamOuterClass$YoloTeamPlayerInfo == null) {
                avatarRoundImageView.setVisibility(8);
            } else {
                avatarRoundImageView.setVisibility(0);
                if (yoloTeamOuterClass$YoloTeamPlayerInfo.status.get() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                BasePlayTogetherJoinPresenter basePlayTogetherJoinPresenter = this.presenter;
                if (basePlayTogetherJoinPresenter != null) {
                    long j3 = yoloTeamOuterClass$YoloTeamPlayerInfo.user_id.uid.get();
                    Long p16 = basePlayTogetherJoinPresenter.p();
                    if (p16 != null && j3 == p16.longValue()) {
                        z17 = true;
                        if (!z17) {
                            avatarRoundImageView.setNeedDrawExtraIcon(true);
                            avatarRoundImageView.setExtraIcon(yn4.c.b(R.drawable.ovo));
                        } else {
                            avatarRoundImageView.setNeedDrawExtraIcon(false);
                        }
                        if (!TextUtils.isEmpty(yoloTeamOuterClass$YoloTeamPlayerInfo.show_info.show_avatar_url.get())) {
                            avatarRoundImageView.setAvatarDrawable(yn4.c.b(R.drawable.ovp));
                        } else {
                            avatarRoundImageView.setAvatarUrl(yoloTeamOuterClass$YoloTeamPlayerInfo.show_info.show_avatar_url.get());
                        }
                        avatarRoundImageView.setNeedDrawSex(!z16);
                        i3 = yoloTeamOuterClass$YoloTeamPlayerInfo.show_info.gender.get();
                        if (i3 == 1) {
                            if (i3 != 2) {
                                str = "";
                            } else {
                                str = "\u5973";
                            }
                        } else {
                            str = "\u7537";
                        }
                        avatarRoundImageView.setSexIcon(str);
                    }
                }
                z17 = false;
                if (!z17) {
                }
                if (!TextUtils.isEmpty(yoloTeamOuterClass$YoloTeamPlayerInfo.show_info.show_avatar_url.get())) {
                }
                avatarRoundImageView.setNeedDrawSex(!z16);
                i3 = yoloTeamOuterClass$YoloTeamPlayerInfo.show_info.gender.get();
                if (i3 == 1) {
                }
                avatarRoundImageView.setSexIcon(str);
            }
            i16 = i17;
        }
    }

    private final void T0(Pair<Integer, ? extends List<YoloTeamOuterClass$YoloTeamPlayerInfo>> pair) {
        Q0(pair);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (YoloTeamOuterClass$YoloTeamPlayerInfo yoloTeamOuterClass$YoloTeamPlayerInfo : pair.getSecond()) {
            List list = (List) linkedHashMap.get(Integer.valueOf(yoloTeamOuterClass$YoloTeamPlayerInfo.camp_id.get()));
            if (list == null) {
                list = new ArrayList();
            }
            list.add(yoloTeamOuterClass$YoloTeamPlayerInfo);
            linkedHashMap.put(Integer.valueOf(yoloTeamOuterClass$YoloTeamPlayerInfo.camp_id.get()), list);
        }
        int i3 = 0;
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (i3 <= 1) {
                if (i3 == 0) {
                    S0((List) linkedHashMap.get(entry.getKey()), this.memberIvList);
                } else if (i3 == 1) {
                    S0((List) linkedHashMap.get(entry.getKey()), this.otherMemberIvList);
                }
                i3++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(s this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(s this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(BasePlayTogetherJoinPresenter presenter, Context ctx, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(presenter, "$presenter");
        Intrinsics.checkNotNullParameter(ctx, "$ctx");
        if (!com.tencent.timi.game.utils.o.a()) {
            presenter.j(ctx);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.timi.game.ui.widget.BaseSlideUpDialog, com.tencent.timi.game.ui.widget.b, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        LiveData<Pair<Integer, List<YoloTeamOuterClass$YoloTeamPlayerInfo>>> F;
        LiveData<CharSequence> D;
        LiveData<String> n3;
        LiveData<Integer> C;
        LiveData<Integer> w3;
        super.dismiss();
        BasePlayTogetherJoinPresenter basePlayTogetherJoinPresenter = this.presenter;
        if (basePlayTogetherJoinPresenter != null && (w3 = basePlayTogetherJoinPresenter.w()) != null) {
            w3.removeObserver(this.joinConditionObserver);
        }
        BasePlayTogetherJoinPresenter basePlayTogetherJoinPresenter2 = this.presenter;
        if (basePlayTogetherJoinPresenter2 != null && (C = basePlayTogetherJoinPresenter2.C()) != null) {
            C.removeObserver(this.statusObserver);
        }
        BasePlayTogetherJoinPresenter basePlayTogetherJoinPresenter3 = this.presenter;
        if (basePlayTogetherJoinPresenter3 != null && (n3 = basePlayTogetherJoinPresenter3.n()) != null) {
            n3.removeObserver(this.accountInfoObserver);
        }
        BasePlayTogetherJoinPresenter basePlayTogetherJoinPresenter4 = this.presenter;
        if (basePlayTogetherJoinPresenter4 != null && (D = basePlayTogetherJoinPresenter4.D()) != null) {
            D.removeObserver(this.teamDetailObserver);
        }
        BasePlayTogetherJoinPresenter basePlayTogetherJoinPresenter5 = this.presenter;
        if (basePlayTogetherJoinPresenter5 != null && (F = basePlayTogetherJoinPresenter5.F()) != null) {
            F.removeObserver(this.teamUserInfoListObserver);
        }
        BasePlayTogetherJoinPresenter basePlayTogetherJoinPresenter6 = this.presenter;
        if (basePlayTogetherJoinPresenter6 != null) {
            basePlayTogetherJoinPresenter6.V(null);
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.playtogether.u
    public void dismissDialog() {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.ui.widget.BaseSlideUpDialog, com.tencent.timi.game.ui.widget.j, android.app.Dialog
    public void onCreate(@Nullable Bundle savedInstanceState) {
        YoloTeamOuterClass$YoloLiveTeamInfo yoloTeamOuterClass$YoloLiveTeamInfo;
        List<String> list;
        PremadesTeamServerOuterClass$AnchorGameInfo anchorGameInfo;
        PBStringField pBStringField;
        PremadesTeamServerOuterClass$AnchorGameInfo anchorGameInfo2;
        PBRepeatField<String> pBRepeatField;
        LiveData<Pair<Integer, List<YoloTeamOuterClass$YoloTeamPlayerInfo>>> F;
        LiveData<CharSequence> D;
        LiveData<String> n3;
        LiveData<Integer> C;
        LiveData<Integer> w3;
        super.onCreate(savedInstanceState);
        BasePlayTogetherJoinPresenter basePlayTogetherJoinPresenter = this.presenter;
        if (basePlayTogetherJoinPresenter != null) {
            D0(basePlayTogetherJoinPresenter);
        }
        BasePlayTogetherJoinPresenter basePlayTogetherJoinPresenter2 = this.presenter;
        if (basePlayTogetherJoinPresenter2 != null && (w3 = basePlayTogetherJoinPresenter2.w()) != null) {
            w3.observeForever(this.joinConditionObserver);
        }
        BasePlayTogetherJoinPresenter basePlayTogetherJoinPresenter3 = this.presenter;
        if (basePlayTogetherJoinPresenter3 != null && (C = basePlayTogetherJoinPresenter3.C()) != null) {
            C.observeForever(this.statusObserver);
        }
        BasePlayTogetherJoinPresenter basePlayTogetherJoinPresenter4 = this.presenter;
        if (basePlayTogetherJoinPresenter4 != null && (n3 = basePlayTogetherJoinPresenter4.n()) != null) {
            n3.observeForever(this.accountInfoObserver);
        }
        BasePlayTogetherJoinPresenter basePlayTogetherJoinPresenter5 = this.presenter;
        if (basePlayTogetherJoinPresenter5 != null && (D = basePlayTogetherJoinPresenter5.D()) != null) {
            D.observeForever(this.teamDetailObserver);
        }
        BasePlayTogetherJoinPresenter basePlayTogetherJoinPresenter6 = this.presenter;
        if (basePlayTogetherJoinPresenter6 != null && (F = basePlayTogetherJoinPresenter6.F()) != null) {
            F.observeForever(this.teamUserInfoListObserver);
        }
        BasePlayTogetherJoinPresenter basePlayTogetherJoinPresenter7 = this.presenter;
        if (basePlayTogetherJoinPresenter7 != null) {
            basePlayTogetherJoinPresenter7.V(this);
        }
        BasePlayTogetherJoinPresenter basePlayTogetherJoinPresenter8 = this.presenter;
        String str = null;
        if (basePlayTogetherJoinPresenter8 != null) {
            yoloTeamOuterClass$YoloLiveTeamInfo = basePlayTogetherJoinPresenter8.getTeamInfo();
        } else {
            yoloTeamOuterClass$YoloLiveTeamInfo = null;
        }
        if (yoloTeamOuterClass$YoloLiveTeamInfo == null) {
            this.joinBtn.setText("\u544a\u8bc9\u4e3b\u64ad, \u60f3\u73a9\u4e0b\u4e00\u5c40");
            R0(true);
            this.titleTv.setText("\u6682\u4e0d\u53ef\u52a0\u5165\u4e3b\u64ad\u961f\u4f0d");
            K0(this.anchorIv);
            LiveGameInfoTextView liveGameInfoTextView = this.entranceTitle;
            BasePlayTogetherJoinPresenter basePlayTogetherJoinPresenter9 = this.presenter;
            if (basePlayTogetherJoinPresenter9 != null && (anchorGameInfo2 = basePlayTogetherJoinPresenter9.getAnchorGameInfo()) != null && (pBRepeatField = anchorGameInfo2.new_title) != null) {
                list = pBRepeatField.get();
            } else {
                list = null;
            }
            liveGameInfoTextView.setData(list);
            BasePlayTogetherJoinPresenter basePlayTogetherJoinPresenter10 = this.presenter;
            if (basePlayTogetherJoinPresenter10 != null && (anchorGameInfo = basePlayTogetherJoinPresenter10.getAnchorGameInfo()) != null && (pBStringField = anchorGameInfo.fans_data) != null) {
                str = pBStringField.get();
            }
            L0(str);
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.playtogether.u
    public void showDialog() {
        show();
    }
}
