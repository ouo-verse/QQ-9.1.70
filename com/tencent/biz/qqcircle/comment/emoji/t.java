package com.tencent.biz.qqcircle.comment.emoji;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.comment.af;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StReply;
import feedcloud.FeedCloudMeta$StUser;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0010\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003()*B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0014\u0010\u000b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\tJ\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fJ\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\u0010\u0010\u001a\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006+"}, d2 = {"Lcom/tencent/biz/qqcircle/comment/emoji/t;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/biz/qqcircle/comment/emoji/t$c;", "", "reply", "", "isClick", "", "j0", "", "stickersList", "setData", "Lo20/d;", "reportBean", "o0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "m0", "holder", "position", "k0", "getItemCount", "Lcom/tencent/biz/qqcircle/comment/emoji/t$b;", "listener", "n0", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "mReplyList", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/qqcircle/comment/emoji/t$b;", "mOnItemClickListener", "D", "Lo20/d;", "mReportBean", "<init>", "()V", "E", "a", "b", "c", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class t extends RecyclerView.Adapter<c> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private b mOnItemClickListener;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private o20.d mReportBean;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> mReplyList = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/biz/qqcircle/comment/emoji/t$b;", "", "", "reply", "", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public interface b {
        void a(@NotNull String reply);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/biz/qqcircle/comment/emoji/t$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/biz/qqcircle/widgets/QCircleAsyncTextView;", "E", "Lcom/tencent/biz/qqcircle/widgets/QCircleAsyncTextView;", "l", "()Lcom/tencent/biz/qqcircle/widgets/QCircleAsyncTextView;", "mTv", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final QCircleAsyncTextView mTv;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View findViewById = view.findViewById(R.id.f353811p);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.q\u2026omment_fast_at_item_text)");
            this.mTv = (QCircleAsyncTextView) findViewById;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final QCircleAsyncTextView getMTv() {
            return this.mTv;
        }
    }

    private final void j0(String reply, boolean isClick) {
        String str;
        String str2;
        String str3;
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        PBStringField pBStringField;
        FeedCloudMeta$StComment feedCloudMeta$StComment;
        FeedCloudMeta$StUser feedCloudMeta$StUser2;
        PBStringField pBStringField2;
        PBStringField pBStringField3;
        Map<String, Object> map = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_QUICK_PCG_BUTTON);
        o20.d dVar = this.mReportBean;
        if (dVar != null) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = dVar.f421797e;
            String str4 = null;
            if (feedCloudMeta$StFeed != null && (pBStringField3 = feedCloudMeta$StFeed.f398449id) != null) {
                str2 = pBStringField3.get();
            } else {
                str2 = null;
            }
            map.put("xsj_feed_id", str2);
            FeedCloudMeta$StComment feedCloudMeta$StComment2 = dVar.f421798f;
            if (feedCloudMeta$StComment2 != null && (pBStringField2 = feedCloudMeta$StComment2.f398447id) != null) {
                str3 = pBStringField2.get();
            } else {
                str3 = null;
            }
            map.put(QCircleDaTongConstant.ElementParamKey.XSJ_CMT_ID, str3);
            map.put("xsj_custom_pgid", dVar.a());
            FeedCloudMeta$StReply feedCloudMeta$StReply = dVar.f421799g;
            if (feedCloudMeta$StReply != null ? !(feedCloudMeta$StReply == null || (feedCloudMeta$StUser = feedCloudMeta$StReply.postUser) == null || (pBStringField = feedCloudMeta$StUser.f398463id) == null) : !((feedCloudMeta$StComment = dVar.f421798f) == null || (feedCloudMeta$StUser2 = feedCloudMeta$StComment.postUser) == null || (pBStringField = feedCloudMeta$StUser2.f398463id) == null)) {
                str4 = pBStringField.get();
            }
            map.put("xsj_target_qq", str4);
            map.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_CMT_CONTENT_FROM_AI, Integer.valueOf(dVar.f421802j));
        }
        map.put("xsj_item_name", reply);
        if (isClick) {
            str = "ev_xsj_abnormal_clck";
        } else {
            str = "ev_xsj_abnormal_imp";
        }
        VideoReport.reportEvent(str, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(t this$0, String reply, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reply, "$reply");
        this$0.j0(reply, true);
        b bVar = this$0.mOnItemClickListener;
        if (bVar != null) {
            bVar.a(reply);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.mReplyList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull c holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final String str = this.mReplyList.get(position);
        holder.getMTv().setText(str);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.comment.emoji.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                t.l0(t.this, str, view);
            }
        };
        holder.itemView.setOnClickListener(onClickListener);
        holder.getMTv().setOnClickListener(onClickListener);
        j0(str, false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.g9c, parent, false);
        itemView.setBackground(af.j(R.color.qui_common_bg_middle_light, R.color.qui_common_text_secondary));
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new c(itemView);
    }

    public final void n0(@Nullable b listener) {
        this.mOnItemClickListener = listener;
    }

    public final void o0(@NotNull o20.d reportBean) {
        Intrinsics.checkNotNullParameter(reportBean, "reportBean");
        this.mReportBean = reportBean;
    }

    public final void setData(@NotNull List<String> stickersList) {
        Intrinsics.checkNotNullParameter(stickersList, "stickersList");
        this.mReplyList.clear();
        this.mReplyList.addAll(stickersList);
        notifyDataSetChanged();
    }
}
