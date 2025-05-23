package com.qzone.reborn.message.section;

import android.graphics.Rect;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.account.LoginData;
import com.qzone.personalize.model.CustomHighFiveData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.User;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0014J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0014J*\u0010\u0015\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\t2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0017R\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010$\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u001b\u0010*\u001a\u00020%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lcom/qzone/reborn/message/section/QZOldStylePassiveMsgCommentSection;", "Lcom/qzone/reborn/message/section/QZOldStylePassiveMsgBaseSection;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "", "G", UserInfo.SEX_FEMALE, "J", "M", "", "L", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "position", "", "", "payload", "N", tl.h.F, "Landroid/view/View;", "commentContainer", "Landroidx/recyclerview/widget/RecyclerView;", "i", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "commentInputContainer", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "commentInputText", "D", "highFivePromptText", "Loh/a;", "E", "Lkotlin/Lazy;", "K", "()Loh/a;", "commentAdapter", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZOldStylePassiveMsgCommentSection extends QZOldStylePassiveMsgBaseSection {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView commentInputText;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView highFivePromptText;

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy commentAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View commentContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View commentInputContainer;

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/qzone/reborn/message/section/QZOldStylePassiveMsgCommentSection$a", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a extends RecyclerView.ItemDecoration {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            if (QZOldStylePassiveMsgCommentSection.this.K().getNUM_BACKGOURND_ICON() <= 1) {
                super.getItemOffsets(outRect, view, parent, state);
            } else if (parent.getChildAdapterPosition(view) < QZOldStylePassiveMsgCommentSection.this.K().getNUM_BACKGOURND_ICON() - 1) {
                outRect.bottom = com.qzone.reborn.util.r.f59560a.e(1);
            }
        }
    }

    public QZOldStylePassiveMsgCommentSection() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<oh.a>() { // from class: com.qzone.reborn.message.section.QZOldStylePassiveMsgCommentSection$commentAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final oh.a invoke() {
                int L;
                L = QZOldStylePassiveMsgCommentSection.this.L();
                return new oh.a(L);
            }
        });
        this.commentAdapter = lazy;
    }

    private final void F(BusinessFeedData feedData) {
        if (com.qzone.reborn.message.data.f.f58260a.d(feedData)) {
            View view = this.commentInputContainer;
            if (view != null) {
                view.setVisibility(0);
            }
            User user = feedData.getUser();
            String str = user != null ? user.nickName : null;
            if (str == null) {
                str = "";
            }
            TextView textView = this.commentInputText;
            if (textView == null) {
                return;
            }
            textView.setText(com.qzone.util.l.a(R.string.m9w) + str + ":");
            return;
        }
        View view2 = this.commentInputContainer;
        if (view2 == null) {
            return;
        }
        view2.setVisibility(8);
    }

    private final void G(BusinessFeedData feedData) {
        K().q0(feedData, false);
        if (K().getNUM_BACKGOURND_ICON() == 0) {
            RecyclerView recyclerView = this.recyclerView;
            if (recyclerView == null) {
                return;
            }
            recyclerView.setVisibility(8);
            return;
        }
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 != null) {
            recyclerView2.setVisibility(0);
        }
        com.qzone.reborn.feedx.util.ag.f55738a.b(5, new Runnable() { // from class: com.qzone.reborn.message.section.f
            @Override // java.lang.Runnable
            public final void run() {
                QZOldStylePassiveMsgCommentSection.H(QZOldStylePassiveMsgCommentSection.this);
            }
        }, this.recyclerView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(QZOldStylePassiveMsgCommentSection this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.K().notifyDataSetChanged();
    }

    private final void J(BusinessFeedData feedData) {
        if (feedData.hasHighFive && feedData.getUser() != null) {
            TextView textView = this.highFivePromptText;
            if (textView != null) {
                textView.setVisibility(0);
            }
            String nickName = LoginData.getInstance().getNickName("");
            String str = feedData.getUser().nickName;
            CustomHighFiveData e16 = com.qzone.personalize.business.b.n().e(LoginData.getInstance().getUin());
            String str2 = e16 != null ? e16.strHighFiveText : null;
            if (!(!(str2 == null || str2.length() == 0))) {
                e16 = null;
            }
            String str3 = e16 != null ? e16.strHighFiveText : null;
            String string = p().getResources().getString(R.string.w_u, nickName, str3 != null ? str3 : "", str);
            Intrinsics.checkNotNullExpressionValue(string, "activity.resources.getSt\u2026 targetNick\n            )");
            TextView textView2 = this.highFivePromptText;
            if (textView2 != null) {
                textView2.setText(string);
            }
        } else {
            TextView textView3 = this.highFivePromptText;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
        }
        RecyclerView recyclerView = this.recyclerView;
        if (!(recyclerView != null && recyclerView.getVisibility() == 0)) {
            TextView textView4 = this.highFivePromptText;
            if (!(textView4 != null && textView4.getVisibility() == 0)) {
                View view = this.commentContainer;
                if (view == null) {
                    return;
                }
                view.setVisibility(8);
                return;
            }
        }
        View view2 = this.commentContainer;
        if (view2 == null) {
            return;
        }
        view2.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final oh.a K() {
        return (oh.a) this.commentAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int L() {
        gf.k kVar = (gf.k) q(gf.k.class);
        if (kVar != null) {
            return kVar.getPageType();
        }
        return 13;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void M() {
        dl.g w3 = w();
        if (w3 != null) {
            w3.u6((BusinessFeedData) this.mData, this.mPosition);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(QZOldStylePassiveMsgCommentSection this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.M();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.commentContainer = containerView.findViewById(R.id.mvv);
        this.recyclerView = (RecyclerView) containerView.findViewById(R.id.mru);
        this.commentInputContainer = containerView.findViewById(R.id.mrr);
        this.commentInputText = (TextView) containerView.findViewById(R.id.mrs);
        this.highFivePromptText = (TextView) containerView.findViewById(R.id.n8g);
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(containerView.getContext()));
        }
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 != null) {
            recyclerView2.setNestedScrollingEnabled(false);
        }
        K().r0(this.mPosition);
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(K());
        }
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 != null) {
            recyclerView4.addItemDecoration(new a());
        }
        View view = this.commentInputContainer;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.message.section.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    QZOldStylePassiveMsgCommentSection.O(QZOldStylePassiveMsgCommentSection.this, view2);
                }
            });
        }
        View view2 = this.commentInputContainer;
        if (view2 != null) {
            com.qzone.reborn.util.r rVar = com.qzone.reborn.util.r.f59560a;
            rVar.b(view2, rVar.e(8));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.nnb, R.id.nnc};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public void onBindData(BusinessFeedData data, int position, List<Object> payload) {
        if (data != null) {
            G(data);
            F(data);
            J(data);
        }
    }
}
