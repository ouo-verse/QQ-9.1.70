package com.tencent.mobileqq.wink.magicstudio.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioPrompt;
import com.tencent.mobileqq.wink.magicstudio.view.TagAdapter;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B*\u0012!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000b0\r\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0016R/\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000b0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R6\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/view/TagAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/wink/magicstudio/view/TagAdapter$TagItem;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "getItemCount", "holder", "position", "", "i0", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", com.tencent.luggage.wxa.c8.c.G, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function1;", "onItemClicked", "", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPrompt;", "value", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "getTags", "()Ljava/util/List;", "k0", "(Ljava/util/List;)V", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "<init>", "(Lkotlin/jvm/functions/Function1;)V", "TagItem", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class TagAdapter extends RecyclerView.Adapter<TagItem> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private List<MagicStudioPrompt> tags;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<Integer, Unit> onItemClicked;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J1\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\bR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0018\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/view/TagAdapter$TagItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPrompt;", "prompt", "", "isClick", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "adapterPos", "onItemClicked", DomainData.DOMAIN_NAME, "Landroid/view/View;", "E", "Landroid/view/View;", "v", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "p", "()Landroid/widget/TextView;", "tagName", "<init>", "(Landroid/view/View;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class TagItem extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final View v;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final Lazy tagName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TagItem(@NotNull View v3) {
            super(v3);
            Lazy lazy;
            Intrinsics.checkNotNullParameter(v3, "v");
            this.v = v3;
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.wink.magicstudio.view.TagAdapter$TagItem$tagName$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final TextView invoke() {
                    View view;
                    view = TagAdapter.TagItem.this.v;
                    return (TextView) view.findViewById(R.id.f920756w);
                }
            });
            this.tagName = lazy;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void o(Function1 onItemClicked, TagItem this$0, MagicStudioPrompt prompt, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(onItemClicked, "$onItemClicked");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(prompt, "$prompt");
            onItemClicked.invoke(Integer.valueOf(this$0.getAdapterPosition()));
            this$0.q(prompt, true);
            EventCollector.getInstance().onViewClicked(view);
        }

        private final TextView p() {
            Object value = this.tagName.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-tagName>(...)");
            return (TextView) value;
        }

        private final void q(MagicStudioPrompt prompt, boolean isClick) {
            Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
            VideoReport.setElementId(this.v, WinkDaTongReportConstant.ElementParamKey.EM_XSJ_REC_WORDS);
            Intrinsics.checkNotNullExpressionValue(params, "params");
            params.put("xsj_item_name", prompt.getPrompt());
            params.put("xsj_eid", WinkDaTongReportConstant.ElementParamKey.EM_XSJ_REC_WORDS);
            params.put("dt_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_MAIGC_STUDIO_PAGE);
            params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_MAIGC_STUDIO_PAGE);
            if (isClick) {
                VideoReport.reportEvent("ev_xsj_abnormal_clck", this.v, params);
            } else {
                VideoReport.reportEvent("ev_xsj_abnormal_imp", this.v, params);
            }
        }

        public final void n(@NotNull final MagicStudioPrompt prompt, @NotNull final Function1<? super Integer, Unit> onItemClicked) {
            Intrinsics.checkNotNullParameter(prompt, "prompt");
            Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
            p().setText(prompt.getPrompt());
            p().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.magicstudio.view.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TagAdapter.TagItem.o(Function1.this, this, prompt, view);
                }
            });
            q(prompt, false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TagAdapter(@NotNull Function1<? super Integer, Unit> onItemClicked) {
        List<MagicStudioPrompt> emptyList;
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        this.onItemClicked = onItemClicked;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.tags = emptyList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.tags.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull TagItem holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.n(this.tags.get(position), this.onItemClicked);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public TagItem onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.f167580du1, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026ompt_item, parent, false)");
        return new TagItem(inflate);
    }

    public final void k0(@NotNull List<MagicStudioPrompt> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.tags = value;
        notifyDataSetChanged();
    }
}
