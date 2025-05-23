package com.tencent.mobileqq.guild.media.widget.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.widget.GuildMicSequenceDialogFragment;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001&B;\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\"\u0010\"\u001a\u001e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001e0\u001dj\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001e`\u001f\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0016\u0010\u0012\u001a\u00020\f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fR\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR0\u0010\"\u001a\u001e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001e0\u001dj\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001e`\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/adapter/a;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/tencent/mobileqq/guild/media/widget/adapter/e;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "position", "getItemViewType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "onCreateViewHolder", "holder", "", "onBindViewHolder", "onViewDetachedFromWindow", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", "userList", "updateList", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "Lcom/tencent/mobileqq/guild/media/widget/GuildMicSequenceDialogFragment;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/media/widget/GuildMicSequenceDialogFragment;", "fragment", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "D", "Ljava/util/HashMap;", "mPageParam", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/guild/media/widget/GuildMicSequenceDialogFragment;Ljava/util/HashMap;)V", "E", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a extends ListAdapter<MicSequenceData, RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final GuildMicSequenceDialogFragment fragment;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final HashMap<String, Object> mPageParam;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull String guildId, @NotNull GuildMicSequenceDialogFragment fragment, @NotNull HashMap<String, Object> mPageParam) {
        super(new b());
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(mPageParam, "mPageParam");
        this.guildId = guildId;
        this.fragment = fragment;
        this.mPageParam = mPageParam;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (getItem(position).getSeq() != 1) {
            return 1;
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof TopOnMicViewHolder) {
            MicSequenceData item = getItem(position);
            Intrinsics.checkNotNullExpressionValue(item, "getItem(position)");
            ((TopOnMicViewHolder) holder).r(item, this.guildId);
        } else if (holder instanceof NormalMicSequenceViewHolder) {
            MicSequenceData item2 = getItem(position);
            Intrinsics.checkNotNullExpressionValue(item2, "getItem(position)");
            ((NormalMicSequenceViewHolder) holder).n(item2, this.guildId);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 0) {
            if (viewType == 1) {
                View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.ezv, parent, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026ence_item, parent, false)");
                return new NormalMicSequenceViewHolder(inflate, this.fragment, this.mPageParam);
            }
            throw new Exception(" unknown type " + viewType);
        }
        View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.ezw, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   \u2026_item_top, parent, false)");
        return new TopOnMicViewHolder(inflate2, this.fragment, this.mPageParam);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewDetachedFromWindow(holder);
        if (holder instanceof TopOnMicViewHolder) {
            ((TopOnMicViewHolder) holder).resetStatusAndAnim();
        }
    }

    public final void updateList(@Nullable List<? extends IGProUserInfo> userList) {
        ArrayList arrayList = new ArrayList();
        if (userList != null && (!userList.isEmpty())) {
            int i3 = 0;
            for (IGProUserInfo iGProUserInfo : userList) {
                int i16 = i3 + 1;
                String tinyId = iGProUserInfo.getTinyId();
                Intrinsics.checkNotNullExpressionValue(tinyId, "info.tinyId");
                String d06 = ch.d0(iGProUserInfo);
                Intrinsics.checkNotNullExpressionValue(d06, "getUserShowName(info)");
                String avatarMeta = iGProUserInfo.getAvatarMeta();
                Intrinsics.checkNotNullExpressionValue(avatarMeta, "info.avatarMeta");
                arrayList.add(i3, new MicSequenceData(tinyId, d06, i16, 0, avatarMeta, iGProUserInfo.getGender()));
                i3 = i16;
            }
        }
        submitList(arrayList);
    }
}
