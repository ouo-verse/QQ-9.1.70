package com.tencent.timi.game.expand.hall.impl.view;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.expand.hall.impl.presenter.OnlineUserViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.YesUserRankingOuterClass$UserRanking;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB%\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/timi/game/expand/hall/impl/view/OnlineUserDialog;", "Lcom/tencent/timi/game/ui/widget/l;", "Landroid/view/View;", "Y", "e0", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Lcom/tencent/mobileqq/app/QBaseActivity;", "J", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "K", "roomId", "", "Ltrpc/yes/common/YesUserRankingOuterClass$UserRanking;", "L", "Ljava/util/List;", "userRankingList", "Lcom/tencent/timi/game/expand/hall/impl/view/OnlineUserView;", "M", "Lcom/tencent/timi/game/expand/hall/impl/view/OnlineUserView;", "onlineUserView", "N", "Landroid/view/View;", "shadowView", "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;JLjava/util/List;)V", "P", "Companion", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class OnlineUserDialog extends com.tencent.timi.game.ui.widget.l {

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final QBaseActivity activity;

    /* renamed from: K, reason: from kotlin metadata */
    private final long roomId;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final List<YesUserRankingOuterClass$UserRanking> userRankingList;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final OnlineUserView onlineUserView;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final View shadowView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/timi/game/expand/hall/impl/view/OnlineUserDialog$Companion;", "", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "roomId", "Lcom/tencent/timi/game/expand/hall/impl/presenter/OnlineUserViewModel;", "viewModel", "", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull final QBaseActivity activity, final long roomId, @NotNull OnlineUserViewModel viewModel) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(viewModel, "viewModel");
            wf4.a.f445618a.c(activity);
            viewModel.g(new Function1<List<? extends YesUserRankingOuterClass$UserRanking>, Unit>() { // from class: com.tencent.timi.game.expand.hall.impl.view.OnlineUserDialog$Companion$showDialog$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends YesUserRankingOuterClass$UserRanking> list) {
                    invoke2((List<YesUserRankingOuterClass$UserRanking>) list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable List<YesUserRankingOuterClass$UserRanking> list) {
                    if (list == null) {
                        wf4.a.f445618a.a(QBaseActivity.this);
                    } else {
                        new OnlineUserDialog(QBaseActivity.this, roomId, list).show();
                        wf4.a.f445618a.a(QBaseActivity.this);
                    }
                }
            });
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnlineUserDialog(@NotNull QBaseActivity activity, long j3, @NotNull List<YesUserRankingOuterClass$UserRanking> userRankingList) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(userRankingList, "userRankingList");
        this.activity = activity;
        this.roomId = j3;
        this.userRankingList = userRankingList;
        OnlineUserView onlineUserView = new OnlineUserView(activity, null, 0, 6, null);
        this.onlineUserView = onlineUserView;
        View view = new View(activity);
        view.setBackgroundResource(R.color.f156809bx);
        view.setAlpha(0.0f);
        this.shadowView = view;
        FrameLayout frameLayout = new FrameLayout(activity);
        frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(onlineUserView, new FrameLayout.LayoutParams(-1, -1));
        onlineUserView.setVisibility(4);
        setContentView(frameLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(OnlineUserDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.timi.game.ui.widget.s
    @NotNull
    public View Y() {
        return this.onlineUserView;
    }

    @Override // com.tencent.timi.game.ui.widget.s
    @NotNull
    /* renamed from: e0, reason: from getter */
    public View getShadowView() {
        return this.shadowView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.ui.widget.s, com.tencent.timi.game.ui.widget.j, android.app.Dialog
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.onlineUserView.a(this.userRankingList);
        this.onlineUserView.setUserClickListener(new Function1<CommonOuterClass$QQUserId, Unit>() { // from class: com.tencent.timi.game.expand.hall.impl.view.OnlineUserDialog$onCreate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
                invoke2(commonOuterClass$QQUserId);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull CommonOuterClass$QQUserId it) {
                QBaseActivity qBaseActivity;
                long j3;
                Intrinsics.checkNotNullParameter(it, "it");
                OnlineUserDialog.this.dismiss();
                th4.k kVar = th4.k.f436355a;
                qBaseActivity = OnlineUserDialog.this.activity;
                j3 = OnlineUserDialog.this.roomId;
                kVar.e(qBaseActivity, it, j3);
            }
        });
        this.onlineUserView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.expand.hall.impl.view.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OnlineUserDialog.m0(OnlineUserDialog.this, view);
            }
        });
        VideoReport.setLogicParent(findViewById(android.R.id.content), VideoReport.getPageInfo(null).getPageView());
    }
}
