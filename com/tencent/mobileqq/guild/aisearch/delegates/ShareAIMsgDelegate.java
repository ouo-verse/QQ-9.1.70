package com.tencent.mobileqq.guild.aisearch.delegates;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.aisearch.models.a;
import com.tencent.mobileqq.guild.aisearch.msgholder.ShareAIMsgHolder;
import com.tencent.mobileqq.guild.discoveryv2.share.picture.GuildSearchLLMChatPictureGenerator;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0015\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015\u00a2\u0006\u0004\b\u0019\u0010\u001aJ&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0014J&\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006H\u0014R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/delegates/ShareAIMsgDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Lcom/tencent/mobileqq/guild/aisearch/models/a$d;", "Lcom/tencent/mobileqq/guild/aisearch/models/a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "o", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/mobileqq/guild/aisearch/msgholder/ShareAIMsgHolder;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "holder", "", "payloads", "", "p", "Lcom/tencent/mobileqq/guild/discoveryv2/share/picture/GuildSearchLLMChatPictureGenerator$b;", "d", "Lcom/tencent/mobileqq/guild/discoveryv2/share/picture/GuildSearchLLMChatPictureGenerator$b;", "sharePictureCloneableAdapter", "<init>", "(Lcom/tencent/mobileqq/guild/discoveryv2/share/picture/GuildSearchLLMChatPictureGenerator$b;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class ShareAIMsgDelegate extends AbsListItemAdapterDelegate<a.d, a, RecyclerView.ViewHolder> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildSearchLLMChatPictureGenerator.b<RecyclerView.ViewHolder> sharePictureCloneableAdapter;

    public ShareAIMsgDelegate(@NotNull GuildSearchLLMChatPictureGenerator.b<RecyclerView.ViewHolder> sharePictureCloneableAdapter) {
        Intrinsics.checkNotNullParameter(sharePictureCloneableAdapter, "sharePictureCloneableAdapter");
        this.sharePictureCloneableAdapter = sharePictureCloneableAdapter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull a item, @NotNull List<a> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof a.d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull a.d item, @NotNull RecyclerView.ViewHolder holder, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        ((ShareAIMsgHolder) holder).o();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public ShareAIMsgHolder d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.f8m, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new ShareAIMsgHolder(view, this.sharePictureCloneableAdapter);
    }
}
