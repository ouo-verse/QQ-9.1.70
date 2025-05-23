package com.tencent.guild.aio.panel.photo;

import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.guild.aio.panel.photo.GuildPhotoPanelAdapter$Companion$defaultDrawable$1;
import com.tencent.guild.aio.panel.photo.c;
import com.tencent.guild.api.media.album.INTGuildAlbumApi;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URL;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import vn0.y;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/guild/aio/panel/photo/GuildPhotoPanelAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/guild/aio/panel/photo/h;", "Lcom/tencent/guild/aio/panel/photo/c;", "intent", "", "q0", "", com.tencent.luggage.wxa.c8.c.G, "Lcom/tencent/guild/api/media/album/e;", "l0", "Lcom/tencent/guild/api/media/album/INTGuildAlbumApi;", "k0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "p0", "holder", "position", "m0", "getItemViewType", "getItemCount", "Lcom/tencent/guild/aio/panel/photo/GuildPhotoPanelVM;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/guild/aio/panel/photo/GuildPhotoPanelVM;", "getViewModel", "()Lcom/tencent/guild/aio/panel/photo/GuildPhotoPanelVM;", "viewModel", "<init>", "(Lcom/tencent/guild/aio/panel/photo/GuildPhotoPanelVM;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildPhotoPanelAdapter extends RecyclerView.Adapter<h> {

    @NotNull
    private static final Function3<Integer, Integer, Integer, ColorDrawable> D = new Function3<Integer, Integer, Integer, GuildPhotoPanelAdapter$Companion$defaultDrawable$1.a>() { // from class: com.tencent.guild.aio.panel.photo.GuildPhotoPanelAdapter$Companion$defaultDrawable$1

        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/guild/aio/panel/photo/GuildPhotoPanelAdapter$Companion$defaultDrawable$1$a", "Landroid/graphics/drawable/ColorDrawable;", "", "getIntrinsicWidth", "getIntrinsicHeight", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes6.dex */
        public static final class a extends ColorDrawable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f112037a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f112038b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(int i3, int i16, int i17) {
                super(i3);
                this.f112037a = i16;
                this.f112038b = i17;
            }

            @Override // android.graphics.drawable.Drawable
            public int getIntrinsicHeight() {
                return this.f112038b;
            }

            @Override // android.graphics.drawable.Drawable
            public int getIntrinsicWidth() {
                return this.f112037a;
            }
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ a invoke(Integer num, Integer num2, Integer num3) {
            return invoke(num.intValue(), num2.intValue(), num3.intValue());
        }

        @NotNull
        public final a invoke(int i3, int i16, int i17) {
            return new a(i17, i3, i16);
        }
    };

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildPhotoPanelVM viewModel;

    public GuildPhotoPanelAdapter(@NotNull GuildPhotoPanelVM viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.viewModel = viewModel;
    }

    private final INTGuildAlbumApi k0() {
        QRouteApi api = QRoute.api(INTGuildAlbumApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(INTGuildAlbumApi::class.java)");
        return (INTGuildAlbumApi) api;
    }

    private final com.tencent.guild.api.media.album.e l0(int pos) {
        return this.viewModel.getRepository().i().get(pos);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(GuildPhotoPanelAdapter this$0, com.tencent.guild.api.media.album.e mediaInfo, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mediaInfo, "$mediaInfo");
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.CheckBox");
        if (!((CheckBox) view).isChecked()) {
            this$0.q0(new c.g(mediaInfo));
        } else if (this$0.viewModel.g(mediaInfo)) {
            this$0.q0(new c.a(mediaInfo));
        }
        this$0.notifyDataSetChanged();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(boolean z16, GuildPhotoPanelAdapter this$0, com.tencent.guild.api.media.album.e mediaInfo, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mediaInfo, "$mediaInfo");
        if (z16) {
            this$0.q0(new c.d(mediaInfo));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void q0(c intent) {
        this.viewModel.o(intent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.viewModel.getRepository().i().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return l0(position).getType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull h holder, int position) {
        boolean z16;
        String str;
        Intrinsics.checkNotNullParameter(holder, "holder");
        final com.tencent.guild.api.media.album.e l06 = l0(position);
        holder.u(l06);
        URLImageView mImageView = holder.getMImageView();
        URL generateAlbumThumbURL = k0().generateAlbumThumbURL(l06);
        URLDrawable mURLDrawable = holder.getMURLDrawable();
        if (mURLDrawable == null || !Intrinsics.areEqual(mURLDrawable.getURL(), generateAlbumThumbURL)) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Function3<Integer, Integer, Integer, ColorDrawable> function3 = D;
            obtain.mLoadingDrawable = function3.invoke(Integer.valueOf(l06.e()), Integer.valueOf(l06.b()), 278921216);
            obtain.mFailedDrawable = function3.invoke(Integer.valueOf(l06.e()), Integer.valueOf(l06.b()), -16777216);
            URLDrawable drawable = URLDrawable.getDrawable(generateAlbumThumbURL, obtain);
            drawable.setTag(l06.d());
            mImageView.setImageDrawable(drawable);
            holder.t(drawable);
        }
        int itemViewType = getItemViewType(position);
        if (itemViewType == com.tencent.guild.api.media.album.c.a()) {
            holder.getMVideoMask().setVisibility(4);
            holder.getMVideoDuration().setVisibility(4);
        } else if (itemViewType == com.tencent.guild.api.media.album.c.b()) {
            holder.getMVideoMask().setVisibility(0);
            TextView mVideoDuration = holder.getMVideoDuration();
            mVideoDuration.setVisibility(0);
            mVideoDuration.setText(k0().formatTimeToString(l06.getVideoDuration()));
        } else {
            holder.getMVideoMask().setVisibility(4);
            holder.getMVideoDuration().setVisibility(4);
        }
        List<com.tencent.guild.api.media.album.e> m3 = this.viewModel.m();
        final boolean g16 = this.viewModel.g(l06);
        CheckBox mCheckBox = holder.getMCheckBox();
        if (m3.contains(l06)) {
            z16 = true;
        } else {
            z16 = false;
        }
        mCheckBox.setChecked(z16);
        if (mCheckBox.isChecked()) {
            str = String.valueOf(m3.indexOf(l06) + 1);
        } else {
            str = "";
        }
        mCheckBox.setText(str);
        mCheckBox.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.panel.photo.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildPhotoPanelAdapter.n0(GuildPhotoPanelAdapter.this, l06, view);
            }
        });
        ImageView mMask = holder.getMMask();
        if (holder.getMCheckBox().isChecked()) {
            mMask.setBackgroundColor(855638016);
            mMask.setVisibility(0);
        } else if (!g16) {
            mMask.setBackgroundColor(-855638017);
            mMask.setVisibility(0);
        } else {
            mMask.setVisibility(8);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.panel.photo.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildPhotoPanelAdapter.o0(g16, this, l06, view);
            }
        });
        View view = holder.itemView;
        view.setTranslationY(0.0f);
        view.setTranslationY(0.0f);
        view.setAlpha(1.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setOutlineProvider(null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public h onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        y g16 = y.g(LayoutInflater.from(parent.getContext()));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(parent.context))");
        RelativeLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "itemView.root");
        return new h(root);
    }
}
