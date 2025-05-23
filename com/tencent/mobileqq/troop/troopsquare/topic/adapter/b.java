package com.tencent.mobileqq.troop.troopsquare.topic.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopsquare.common.c;
import com.tencent.mobileqq.troop.troopsquare.topic.adapter.b;
import com.tencent.mobileqq.troop.utils.h;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.GroupSquareBannerItem;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001eB\u001b\u0012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000b0\u0010\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001c\u0010\u0007\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u001c\u0010\f\u001a\u00020\u000b2\n\u0010\t\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007R#\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000b0\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R&\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0017j\b\u0012\u0004\u0012\u00020\r`\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/topic/adapter/b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/troop/troopsquare/topic/adapter/b$a;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "k0", "getItemCount", "holder", "position", "", "j0", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSquareBannerItem;", "info", "l0", "Lkotlin/Function1;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function1;", "i0", "()Lkotlin/jvm/functions/Function1;", "onSearchClick", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "topicInfoList", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b extends RecyclerView.Adapter<a> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private ArrayList<GroupSquareBannerItem> topicInfoList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<String, Unit> onSearchClick;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u001c\u0010\u0014\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/topic/adapter/b$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSquareBannerItem;", "data", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "topicCover", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "topicTitle", "G", "topicSummary", "Landroid/view/View;", "kotlin.jvm.PlatformType", "H", "Landroid/view/View;", "searchIcon", "itemView", "<init>", "(Lcom/tencent/mobileqq/troop/troopsquare/topic/adapter/b;Landroid/view/View;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public final class a extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final ImageView topicCover;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final TextView topicTitle;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final TextView topicSummary;

        /* renamed from: H, reason: from kotlin metadata */
        private final View searchIcon;
        final /* synthetic */ b I;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull b bVar, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.I = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar, (Object) itemView);
                return;
            }
            View findViewById = itemView.findViewById(R.id.f1038761s);
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.ImageView");
            this.topicCover = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.f1039361y);
            Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
            this.topicTitle = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.f1038861t);
            Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
            this.topicSummary = (TextView) findViewById3;
            this.searchIcon = itemView.findViewById(R.id.f1039261x);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(b this$0, GroupSquareBannerItem data, a this$1, View view) {
            HashMap hashMapOf;
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(data, "$data");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Function1<String, Unit> i06 = this$0.i0();
            String str = data.title;
            Intrinsics.checkNotNullExpressionValue(str, "data.title");
            i06.invoke(str);
            c cVar = c.f301578a;
            View searchIcon = this$1.searchIcon;
            Intrinsics.checkNotNullExpressionValue(searchIcon, "searchIcon");
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("query", data.title));
            h.a.f(cVar, searchIcon, "em_group_search_box", hashMapOf, null, 8, null);
            EventCollector.getInstance().onViewClicked(view);
        }

        public final void m(@NotNull final GroupSquareBannerItem data) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            String str = data.shortCover;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                this.topicCover.setImageResource(R.drawable.qui_common_border_standard_bg);
            } else {
                this.topicCover.setImageDrawable(URLDrawable.getDrawable(data.shortCover, URLDrawable.URLDrawableOptions.obtain()));
            }
            this.topicTitle.setText(data.title);
            this.topicSummary.setText(data.summary);
            View view = this.searchIcon;
            final b bVar = this.I;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsquare.topic.adapter.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    b.a.n(b.this, data, this, view2);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(@NotNull Function1<? super String, Unit> onSearchClick) {
        Intrinsics.checkNotNullParameter(onSearchClick, "onSearchClick");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) onSearchClick);
        } else {
            this.onSearchClick = onSearchClick;
            this.topicInfoList = new ArrayList<>();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.topicInfoList.size();
    }

    @NotNull
    public final Function1<String, Unit> i0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Function1) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.onSearchClick;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull a holder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        GroupSquareBannerItem groupSquareBannerItem = this.topicInfoList.get(position);
        Intrinsics.checkNotNullExpressionValue(groupSquareBannerItem, "topicInfoList[position]");
        holder.m(groupSquareBannerItem);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.i19, parent, false);
        itemView.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.qui_common_fill_light_primary));
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new a(this, itemView);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void l0(@NotNull GroupSquareBannerItem info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) info);
            return;
        }
        Intrinsics.checkNotNullParameter(info, "info");
        this.topicInfoList.clear();
        this.topicInfoList.add(info);
        notifyDataSetChanged();
    }
}
