package com.tencent.timi.game.expand.hall.impl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.lifecycle.Observer;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.timi.game.expand.hall.impl.presenter.OnlineUserViewModel;
import com.tencent.timi.game.userinfo.api.view.AvatarRoundImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.YesUserRankingOuterClass$UserRanking;
import ug4.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0013\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/timi/game/expand/hall/impl/view/OnlineUserHeaderView;", "Landroid/widget/LinearLayout;", "", "e", "", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "userIdList", "f", "Lcom/tencent/timi/game/expand/hall/impl/presenter/OnlineUserViewModel;", "viewModel", "setOnlineUserViewModel", "", "Lcom/tencent/timi/game/userinfo/api/view/AvatarRoundImageView;", "d", "Ljava/util/List;", "onlineAvatarIvList", "Lcom/tencent/image/URLImageView;", "Lcom/tencent/image/URLImageView;", "moreIv", "Lcom/tencent/timi/game/expand/hall/impl/presenter/OnlineUserViewModel;", "mViewModel", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class OnlineUserHeaderView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<AvatarRoundImageView> onlineAvatarIvList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final URLImageView moreIv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private OnlineUserViewModel mViewModel;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OnlineUserHeaderView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    private final void e() {
        gh4.e I0;
        QBaseActivity qBaseActivity;
        OnlineUserViewModel onlineUserViewModel = this.mViewModel;
        if (onlineUserViewModel != null && (I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0()) != null) {
            Context context = getContext();
            if (context instanceof QBaseActivity) {
                qBaseActivity = (QBaseActivity) context;
            } else {
                qBaseActivity = null;
            }
            if (qBaseActivity == null) {
                return;
            }
            OnlineUserDialog.INSTANCE.a(qBaseActivity, I0.ue(), onlineUserViewModel);
        }
    }

    private final void f(final List<CommonOuterClass$QQUserId> userIdList) {
        final int i3 = 0;
        for (Object obj : this.onlineAvatarIvList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            AvatarRoundImageView avatarRoundImageView = (AvatarRoundImageView) obj;
            if (i3 >= userIdList.size()) {
                avatarRoundImageView.setVisibility(8);
                avatarRoundImageView.setOnClickListener(null);
                return;
            }
            avatarRoundImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.expand.hall.impl.view.ac
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OnlineUserHeaderView.g(OnlineUserHeaderView.this, view);
                }
            });
            mm4.a b16 = mm4.b.b(ug4.b.class);
            Intrinsics.checkNotNullExpressionValue(b16, "getService(IReportService::class.java)");
            b.a.a((ug4.b) b16, avatarRoundImageView, false, null, "em_yes_listarea_user_head", th4.h.b(), 6, null);
            avatarRoundImageView.setVisibility(0);
            avatarRoundImageView.setUserId(userIdList.get(i3));
            VideoReport.setEventDynamicParams(avatarRoundImageView, new IDynamicParams() { // from class: com.tencent.timi.game.expand.hall.impl.view.ad
                @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
                public final Map getDynamicParams(String str) {
                    Map h16;
                    h16 = OnlineUserHeaderView.h(userIdList, i3, str);
                    return h16;
                }
            });
            i3 = i16;
        }
        VideoReport.traverseExposure();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(OnlineUserHeaderView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.e();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map h(List userIdList, int i3, String str) {
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(userIdList, "$userIdList");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("yes_to_uid", String.valueOf(((CommonOuterClass$QQUserId) userIdList.get(i3)).uid.get())));
        mutableMapOf.putAll(th4.h.a());
        return mutableMapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(OnlineUserHeaderView this$0, List list) {
        List take;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (list != null) {
            take = CollectionsKt___CollectionsKt.take(list, 3);
            List list2 = take;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((YesUserRankingOuterClass$UserRanking) it.next()).UInfo.get());
            }
            this$0.f(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(OnlineUserHeaderView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.e();
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void setOnlineUserViewModel(@NotNull OnlineUserViewModel viewModel) {
        QBaseActivity qBaseActivity;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.mViewModel = viewModel;
        Context context = getContext();
        if (context instanceof QBaseActivity) {
            qBaseActivity = (QBaseActivity) context;
        } else {
            qBaseActivity = null;
        }
        if (qBaseActivity != null) {
            viewModel.h().observe(qBaseActivity, new Observer() { // from class: com.tencent.timi.game.expand.hall.impl.view.aa
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    OnlineUserHeaderView.i(OnlineUserHeaderView.this, (List) obj);
                }
            });
        }
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.expand.hall.impl.view.ab
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OnlineUserHeaderView.j(OnlineUserHeaderView.this, view);
            }
        });
        mm4.a b16 = mm4.b.b(ug4.b.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(IReportService::class.java)");
        b.a.a((ug4.b) b16, this, false, null, "em_yes_listarea_entrance", th4.h.b(), 6, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OnlineUserHeaderView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ OnlineUserHeaderView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OnlineUserHeaderView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        ArrayList arrayList = new ArrayList();
        int i16 = 0;
        for (int i17 = 0; i17 < 3; i17++) {
            arrayList.add(new AvatarRoundImageView(getContext()));
        }
        this.onlineAvatarIvList = arrayList;
        this.moreIv = new URLImageView(getContext());
        setOrientation(0);
        for (Object obj : arrayList) {
            int i18 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            View view = (AvatarRoundImageView) obj;
            view.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(fh4.b.b(21), fh4.b.b(21));
            layoutParams.rightMargin = fh4.b.b(3);
            Unit unit = Unit.INSTANCE;
            addView(view, layoutParams);
            mm4.a b16 = mm4.b.b(ug4.b.class);
            Intrinsics.checkNotNullExpressionValue(b16, "getService(IReportService::class.java)");
            b.a.a((ug4.b) b16, view, false, null, "em_yes_listarea_user_head", null, 20, null);
            i16 = i18;
        }
        addView(this.moreIv, new LinearLayout.LayoutParams(fh4.b.b(21), fh4.b.b(21)));
        sh4.d.c(this.moreIv, sh4.a.f433815a.a(9));
        mm4.a b17 = mm4.b.b(ug4.b.class);
        Intrinsics.checkNotNullExpressionValue(b17, "getService(IReportService::class.java)");
        b.a.c((ug4.b) b17, this.moreIv, false, null, "em_yes_listarea_entrance", th4.h.b(), 6, null);
    }
}
