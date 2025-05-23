package com.tencent.mobileqq.flock.feedlist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.flock.feedlist.adapter.e;
import com.tencent.mobileqq.flock.ktx.i;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.topicaggregation.bean.FlockTopicAggregationInitBean;
import com.tencent.mobileqq.topicaggregation.bean.TopicAggregationSource;
import com.tencent.mobileqq.widget.RoundFrameLayout;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001c\u0010\u0007\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\u000b\u001a\u00020\n2\n\u0010\b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0005H\u0016R(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/flock/feedlist/adapter/e;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/flock/feedlist/adapter/e$a;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "holder", "position", "", "i0", "getItemCount", "", "getItemId", "", "Lcom/tencent/mobileqq/flock/feedlist/bean/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "getHotTagInfo", "()Ljava/util/List;", "k0", "(Ljava/util/List;)V", "hotTagInfo", "<init>", "()V", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class e extends RecyclerView.Adapter<a> {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<com.tencent.mobileqq.flock.feedlist.bean.a> hotTagInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/flock/feedlist/adapter/e$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/flock/feedlist/bean/a;", "data", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/mobileqq/flock/feedlist/adapter/e;Landroid/view/View;)V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public final class a extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;
        final /* synthetic */ e E;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull e eVar, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.E = eVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) eVar, (Object) itemView);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(a this$0, com.tencent.mobileqq.flock.feedlist.bean.a data, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(data, "$data");
            com.tencent.mobileqq.flock.a aVar = com.tencent.mobileqq.flock.a.f209993a;
            Context context = this$0.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
            aVar.j(context, new FlockTopicAggregationInitBean(data.a().f27973a, TopicAggregationSource.RECOMMEND_HOT_TOPIC));
            EventCollector.getInstance().onViewClicked(view);
        }

        public final void m(@NotNull final com.tencent.mobileqq.flock.feedlist.bean.a data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            RoundFrameLayout roundFrameLayout = (RoundFrameLayout) this.itemView.findViewById(R.id.xbr);
            roundFrameLayout.setRadius(i.b(8));
            roundFrameLayout.setCorners(3);
            ImageView imageView = (ImageView) this.itemView.findViewById(R.id.xbq);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            com.tencent.mobileqq.flock.picloader.a.a().c(Option.obtain().setUrl(data.a().f27975c).setRequestWidth(imageView.getLayoutParams().width).setRequestHeight(imageView.getLayoutParams().height).setTargetView(imageView).setLoadingDrawableId(R.drawable.asd).setFailedDrawableId(R.drawable.asd));
            ((TextView) this.itemView.findViewById(R.id.xbv)).setText(data.a().f27974b);
            ((TextView) this.itemView.findViewById(R.id.xbt)).setText(data.a().f27977e + "\u4e2a\u6d3b\u52a8");
            ((TextView) this.itemView.findViewById(R.id.xbu)).setText(data.a().f27976d + "\u4eba\u53c2\u4e0e");
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.flock.feedlist.adapter.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.a.n(e.a.this, data, view);
                }
            });
            VideoReport.setElementId(this.itemView, "em_bas_hot_topic");
            View view = this.itemView;
            HashMap hashMap = new HashMap();
            hashMap.put("topic_name", data.a().f27974b);
            hashMap.put("topic_sub_activity_number", String.valueOf(data.a().f27977e));
            hashMap.put("topic_participants", String.valueOf(data.a().f27976d));
            VideoReport.setElementParams(view, hashMap);
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.hotTagInfo = new ArrayList();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.hotTagInfo.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this, position)).longValue();
        }
        return position;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull a holder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) holder, position);
        } else {
            Intrinsics.checkNotNullParameter(holder, "holder");
            holder.m(this.hotTagInfo.get(position));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.e8n, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new a(this, view);
    }

    public final void k0(@NotNull List<com.tencent.mobileqq.flock.feedlist.bean.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
        } else {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.hotTagInfo = list;
        }
    }
}
