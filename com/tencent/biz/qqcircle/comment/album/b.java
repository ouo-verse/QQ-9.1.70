package com.tencent.biz.qqcircle.comment.album;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qqcircle.comment.album.b;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.qbasealbum.albumlist.viewmodel.AlbumListViewModel;
import com.tencent.qqnt.qbasealbum.utils.UriUtil;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 !2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\"#B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001f\u0010 J\u0016\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003J\u001c\u0010\f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001c\u0010\u000f\u001a\u00020\u00062\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006$"}, d2 = {"Lcom/tencent/biz/qqcircle/comment/album/b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/biz/qqcircle/comment/album/b$a;", "", "Lcom/tencent/qqnt/qbasealbum/model/b;", "list", "", "p0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "o0", "holder", "position", "n0", "getItemCount", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/qbasealbum/albumlist/viewmodel/AlbumListViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/qbasealbum/albumlist/viewmodel/AlbumListViewModel;", "mAlbumListViewModel", "D", "I", "lastSelectPosition", "E", "Ljava/util/List;", "mAlbumList", "<init>", "(Landroid/content/Context;Lcom/tencent/qqnt/qbasealbum/albumlist/viewmodel/AlbumListViewModel;)V", UserInfo.SEX_FEMALE, "a", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class b extends RecyclerView.Adapter<a> {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final ColorDrawable G = new ColorDrawable(-2141891243);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private AlbumListViewModel mAlbumListViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private int lastSelectPosition;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private List<com.tencent.qqnt.qbasealbum.model.b> mAlbumList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/biz/qqcircle/comment/album/b$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/qqnt/qbasealbum/model/b;", "info", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "", "position", "o", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/biz/qqcircle/comment/album/b;Landroid/view/View;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public final class a extends RecyclerView.ViewHolder {
        final /* synthetic */ b E;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull b bVar, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.E = bVar;
        }

        private final void m(com.tencent.qqnt.qbasealbum.model.b info) {
            String str;
            boolean equals$default;
            String str2;
            ImageView albumCover = (ImageView) this.itemView.findViewById(R.id.f164257p5);
            ImageView albumSelectedArrow = (ImageView) this.itemView.findViewById(R.id.slc);
            info.c().setThumbWidth(300);
            info.c().setThumbHeight(300);
            if (Intrinsics.areEqual("qzone_album", info.b())) {
                albumCover.setImageResource(R.drawable.ol5);
                Intrinsics.checkNotNullExpressionValue(albumSelectedArrow, "albumSelectedArrow");
                com.tencent.qqnt.qbasealbum.ktx.d.e(albumSelectedArrow, R.drawable.f161269ol4);
                albumSelectedArrow.setVisibility(0);
                return;
            }
            UriUtil uriUtil = UriUtil.f361640a;
            Intrinsics.checkNotNullExpressionValue(albumCover, "albumCover");
            Option e16 = uriUtil.e(albumCover, info.c());
            Companion companion = b.INSTANCE;
            e16.setLoadingDrawable(companion.a());
            e16.setFailedDrawable(companion.a());
            QCircleFeedPicLoader.g().loadImage(e16);
            Intrinsics.checkNotNullExpressionValue(albumSelectedArrow, "albumSelectedArrow");
            com.tencent.qqnt.qbasealbum.ktx.d.e(albumSelectedArrow, R.drawable.qui_tick_brand_standard);
            if (this.E.mAlbumListViewModel.W1().getValue() != null) {
                com.tencent.qqnt.qbasealbum.model.b value = this.E.mAlbumListViewModel.W1().getValue();
                if (value != null) {
                    str2 = value.b();
                } else {
                    str2 = null;
                }
                str = String.valueOf(str2);
            } else {
                str = "";
            }
            if (info.b() != null) {
                equals$default = StringsKt__StringsJVMKt.equals$default(info.b(), str, false, 2, null);
                if (equals$default) {
                    albumSelectedArrow.setVisibility(0);
                    return;
                }
            }
            albumSelectedArrow.setVisibility(8);
        }

        private final void n(com.tencent.qqnt.qbasealbum.model.b info) {
            String str;
            ((TextView) this.itemView.findViewById(R.id.album_item_title)).setText(info.f());
            TextView textView = (TextView) this.itemView.findViewById(R.id.sl9);
            if (info.d() > 0) {
                str = "(" + info.d() + ")";
            } else {
                str = "";
            }
            textView.setText(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void p(b this$0, com.tencent.qqnt.qbasealbum.model.b info, int i3, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(info, "$info");
            if (this$0.mAlbumListViewModel.S1(info.b())) {
                this$0.mAlbumListViewModel.Q1();
            } else {
                this$0.mAlbumListViewModel.a2(info);
                this$0.mAlbumListViewModel.Q1();
                this$0.notifyItemChanged(i3);
                this$0.notifyItemChanged(this$0.lastSelectPosition);
                this$0.lastSelectPosition = i3;
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        public final void o(final int position) {
            List list;
            final com.tencent.qqnt.qbasealbum.model.b bVar;
            if (!com.tencent.qqnt.qbasealbum.utils.b.f361643a.a(position, this.E.mAlbumList) && (list = this.E.mAlbumList) != null && (bVar = (com.tencent.qqnt.qbasealbum.model.b) list.get(position)) != null) {
                n(bVar);
                m(bVar);
                View view = this.itemView;
                final b bVar2 = this.E;
                view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.comment.album.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        b.a.p(b.this, bVar, position, view2);
                    }
                });
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/biz/qqcircle/comment/album/b$b;", "", "Landroid/graphics/drawable/ColorDrawable;", "COLOR_DRAWABLE", "Landroid/graphics/drawable/ColorDrawable;", "a", "()Landroid/graphics/drawable/ColorDrawable;", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.comment.album.b$b, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ColorDrawable a() {
            return b.G;
        }

        Companion() {
        }
    }

    public b(@NotNull Context context, @NotNull AlbumListViewModel mAlbumListViewModel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mAlbumListViewModel, "mAlbumListViewModel");
        this.context = context;
        this.mAlbumListViewModel = mAlbumListViewModel;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        List<com.tencent.qqnt.qbasealbum.model.b> list = this.mAlbumList;
        if (list == null) {
            return 0;
        }
        Intrinsics.checkNotNull(list);
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull a holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.o(position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.g7w, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026ew_layout, parent, false)");
        return new a(this, inflate);
    }

    public final void p0(@Nullable List<com.tencent.qqnt.qbasealbum.model.b> list) {
        int i3;
        this.mAlbumList = list;
        Object obj = null;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (Intrinsics.areEqual(((com.tencent.qqnt.qbasealbum.model.b) next).b(), com.tencent.qqnt.qbasealbum.model.a.f361348a.a())) {
                    obj = next;
                    break;
                }
            }
            obj = (com.tencent.qqnt.qbasealbum.model.b) obj;
        }
        if (obj != null) {
            i3 = list.indexOf(obj);
        } else {
            i3 = 0;
        }
        this.lastSelectPosition = i3;
        notifyDataSetChanged();
    }
}
