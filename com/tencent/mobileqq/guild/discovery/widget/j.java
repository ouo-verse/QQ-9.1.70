package com.tencent.mobileqq.guild.discovery.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import fh1.AvatarInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 )2\u00020\u0001:\u0001\bB\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u00a2\u0006\u0004\b'\u0010(J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0014\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010&\u001a\u00020\u001f8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/widget/j;", "Landroid/widget/BaseAdapter;", "Landroid/content/Context;", "context", "", "position", "count", "Landroid/view/View;", "a", "", "Lfh1/a;", "data", "", "c", "getCount", "b", "", "getItemId", "convertView", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "getView", "d", "I", "avatarSize", "e", "itemOffset", "", "f", "Ljava/util/List;", "avatarList", "", tl.h.F, "Ljava/lang/String;", "getGuildId$qqguild_impl_release", "()Ljava/lang/String;", "setGuildId$qqguild_impl_release", "(Ljava/lang/String;)V", "guildId", "<init>", "(II)V", "i", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class j extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int avatarSize;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int itemOffset;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<AvatarInfo> avatarList = new ArrayList();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String guildId = "";

    public j(int i3, int i16) {
        this.avatarSize = i3;
        this.itemOffset = i16;
    }

    private final View a(Context context, int position, int count) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.f96, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026l_user_avatar_item, null)");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (position > 0) {
            layoutParams.setMarginStart(-this.itemOffset);
        }
        inflate.setLayoutParams(layoutParams);
        inflate.setElevation(count - position);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.a2o);
        ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
        int i3 = this.avatarSize;
        layoutParams2.width = i3;
        layoutParams2.height = i3;
        imageView.setLayoutParams(layoutParams2);
        inflate.setTag(new a(inflate, this.guildId));
        return inflate;
    }

    @Override // android.widget.Adapter
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AvatarInfo getItem(int position) {
        return this.avatarList.get(position);
    }

    public final void c(@NotNull List<AvatarInfo> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.avatarList.clear();
        this.avatarList.addAll(data);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.avatarList.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    @NotNull
    public View getView(int position, @Nullable View convertView, @NotNull ViewGroup parent) {
        View view;
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (parent.getContext() != null) {
            if (convertView == null) {
                Context context = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "parent.context");
                view = a(context, position, this.avatarList.size());
            } else {
                view = convertView;
            }
            Object tag = view.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.guild.discovery.widget.AvatarViewHolder");
            AvatarInfo avatarInfo = this.avatarList.get(position);
            Intrinsics.checkNotNull(avatarInfo, "null cannot be cast to non-null type com.tencent.mobileqq.guild.discovery.common.model.AvatarInfo");
            ((a) tag).a(avatarInfo);
            EventCollector.getInstance().onListGetView(position, convertView, parent, getItemId(position));
            return view;
        }
        throw new IllegalArgumentException("Guild.discovery.mine.SmallUserAvatarListAdapter, getView but context is null");
    }
}
