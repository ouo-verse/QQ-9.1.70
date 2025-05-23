package com.tencent.mobileqq.guild.discovery.publicaccount;

import android.util.Pair;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discoveryv2.content.base.f;
import com.tencent.mobileqq.guild.discoveryv2.content.part.MVPFeedsPart;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qh1.MVPFeedsUIState;
import tl.h;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\f\u001a\u00020\t\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR#\u0010\u0013\u001a\n \u000e*\u0004\u0018\u00010\r0\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/publicaccount/PublicAccountMiscPart;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/part/MVPFeedsPart;", "", "E9", "", "action", "", "args", "handleBroadcastMessage", "", "e", "Z", "isOpenFirstCard", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "f", "Lkotlin/Lazy;", "C9", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/view/ViewTreeObserver$OnDrawListener;", h.F, "Landroid/view/ViewTreeObserver$OnDrawListener;", "observer", "<init>", "(Z)V", "i", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class PublicAccountMiscPart extends MVPFeedsPart {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isOpenFirstCard;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy recyclerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewTreeObserver.OnDrawListener observer;

    public PublicAccountMiscPart(boolean z16) {
        Lazy lazy;
        this.isOpenFirstCard = z16;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RecyclerView>() { // from class: com.tencent.mobileqq.guild.discovery.publicaccount.PublicAccountMiscPart$recyclerView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RecyclerView invoke() {
                return (RecyclerView) PublicAccountMiscPart.this.getPartRootView().findViewById(R.id.uiw);
            }
        });
        this.recyclerView = lazy;
        this.observer = new ViewTreeObserver.OnDrawListener() { // from class: com.tencent.mobileqq.guild.discovery.publicaccount.f
            @Override // android.view.ViewTreeObserver.OnDrawListener
            public final void onDraw() {
                PublicAccountMiscPart.D9(PublicAccountMiscPart.this);
            }
        };
    }

    private final RecyclerView C9() {
        return (RecyclerView) this.recyclerView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D9(PublicAccountMiscPart this$0) {
        Object m476constructorimpl;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            Result.Companion companion = Result.INSTANCE;
            this$0.E9();
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            QLog.e("PublicAccountMiscPart", 1, "tryJumpFirstFeed error", m479exceptionOrNullimpl);
        }
    }

    private final void E9() {
        RFWConcatAdapter rFWConcatAdapter;
        RecyclerView.ViewHolder findViewHolderForLayoutPosition;
        if (this.isOpenFirstCard) {
            RecyclerView.Adapter adapter = C9().getAdapter();
            if (adapter instanceof RFWConcatAdapter) {
                rFWConcatAdapter = (RFWConcatAdapter) adapter;
            } else {
                rFWConcatAdapter = null;
            }
            if (rFWConcatAdapter == null) {
                return;
            }
            Pair<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>, Integer> wrappedAdapterAndPosition = rFWConcatAdapter.getWrappedAdapterAndPosition(0);
            Intrinsics.checkNotNullExpressionValue(wrappedAdapterAndPosition, "getWrappedAdapterAndPosition(0)");
            if ((((RecyclerView.Adapter) wrappedAdapterAndPosition.first) instanceof com.tencent.mobileqq.guild.discoveryv2.content.base.f) || (findViewHolderForLayoutPosition = C9().findViewHolderForLayoutPosition(0)) == null || (findViewHolderForLayoutPosition instanceof f.b)) {
                return;
            }
            if (!findViewHolderForLayoutPosition.itemView.hasOnClickListeners()) {
                QLog.e("PublicAccountMiscPart", 1, "tryJumpFirstFeed firstView has no click listener " + findViewHolderForLayoutPosition);
                return;
            }
            QLog.i("PublicAccountMiscPart", 1, "tryJumpFirstFeed performClick " + findViewHolderForLayoutPosition);
            VideoReport.traverseExposure();
            VideoReport.setElementParam(findViewHolderForLayoutPosition.itemView, "sgrp_jump_type", 1);
            findViewHolderForLayoutPosition.itemView.performClick();
            VideoReport.removeElementParam(findViewHolderForLayoutPosition.itemView, "sgrp_jump_type");
            C9().post(new Runnable() { // from class: com.tencent.mobileqq.guild.discovery.publicaccount.g
                @Override // java.lang.Runnable
                public final void run() {
                    PublicAccountMiscPart.F9(PublicAccountMiscPart.this);
                }
            });
            this.isOpenFirstCard = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(PublicAccountMiscPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.C9().getViewTreeObserver().removeOnDrawListener(this$0.observer);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        if (!Intrinsics.areEqual(action, "message_data_changed_render_on_screen") || !(args instanceof MVPFeedsUIState) || !this.isOpenFirstCard || ((MVPFeedsUIState) args).getListState().getSource() != 2) {
            return;
        }
        C9().getViewTreeObserver().addOnDrawListener(this.observer);
    }
}
