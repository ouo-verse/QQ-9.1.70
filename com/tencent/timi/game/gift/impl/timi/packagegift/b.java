package com.tencent.timi.game.gift.impl.timi.packagegift;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mt3.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J4\u0010\b\u001a\u00020\u00072,\u0010\u0006\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003j\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005`\u0005J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH\u0016J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\tH\u0016RF\u0010\u0014\u001a2\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00050\u0003j\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005`\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/timi/game/gift/impl/timi/packagegift/b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/timi/game/gift/impl/timi/packagegift/b$a;", "Ljava/util/ArrayList;", "Lmt3/g;", "Lkotlin/collections/ArrayList;", "lsData", "", "k0", "", "getItemCount", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "j0", "holder", "position", "i0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "pageList", "<init>", "()V", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b extends RecyclerView.Adapter<a> {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<ArrayList<g>> pageList = new ArrayList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u001a\u0010\f\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007J\u0018\u0010\u000f\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\rR6\u0010\u0018\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0010j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/timi/game/gift/impl/timi/packagegift/b$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "index", "Landroid/view/ViewGroup;", "l", "pageItemV", "", "url", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "name", DomainData.DOMAIN_NAME, "", "endTs", "o", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "E", "Ljava/util/ArrayList;", "getPageItems", "()Ljava/util/ArrayList;", "setPageItems", "(Ljava/util/ArrayList;)V", "pageItems", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private ArrayList<ViewGroup> pageItems;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            ArrayList<ViewGroup> arrayList = new ArrayList<>();
            this.pageItems = arrayList;
            arrayList.add(itemView.findViewById(R.id.voc));
            this.pageItems.add(itemView.findViewById(R.id.vod));
            this.pageItems.add(itemView.findViewById(R.id.voe));
            this.pageItems.add(itemView.findViewById(R.id.vof));
        }

        @Nullable
        public final ViewGroup l(int index) {
            if (index >= 0 && index < this.pageItems.size()) {
                return this.pageItems.get(index);
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:6:0x000e A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:8:0x000f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void m(@Nullable ViewGroup pageItemV, @Nullable String url) {
            boolean z16;
            ImageView imageView;
            boolean isBlank;
            if (url != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(url);
                if (!isBlank) {
                    z16 = false;
                    if (!z16) {
                        return;
                    }
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    if (url == null) {
                        url = "";
                    }
                    URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
                    if (pageItemV != null) {
                        imageView = (ImageView) pageItemV.findViewById(R.id.voa);
                    } else {
                        imageView = null;
                    }
                    if (imageView != null) {
                        imageView.setImageDrawable(drawable);
                        return;
                    }
                    return;
                }
            }
            z16 = true;
            if (!z16) {
            }
        }

        public final void n(@Nullable ViewGroup pageItemV, @Nullable String name) {
            TextView textView;
            if (pageItemV != null) {
                textView = (TextView) pageItemV.findViewById(R.id.vol);
            } else {
                textView = null;
            }
            if (textView != null) {
                textView.setText(name);
            }
        }

        public final void o(@Nullable ViewGroup pageItemV, long endTs) {
            TextView textView;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd HH:mm");
            if (pageItemV != null) {
                textView = (TextView) pageItemV.findViewById(R.id.voy);
            } else {
                textView = null;
            }
            if (textView != null) {
                textView.setText(simpleDateFormat.format(new Date(endTs * 1000)) + "\u8fc7\u671f");
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.pageList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull a holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (position < this.pageList.size()) {
            ArrayList<g> arrayList = this.pageList.get(position);
            Intrinsics.checkNotNullExpressionValue(arrayList, "pageList[position]");
            ArrayList<g> arrayList2 = arrayList;
            int size = arrayList2.size();
            for (int i3 = 0; i3 < size; i3++) {
                g gVar = arrayList2.get(i3);
                Intrinsics.checkNotNullExpressionValue(gVar, "dataList[i]");
                g gVar2 = gVar;
                String valueOf = String.valueOf(gVar2.f417576b);
                if (gVar2.f417576b > 999) {
                    valueOf = "999+";
                }
                ViewGroup l3 = holder.l(i3);
                if (l3 != null) {
                    l3.setVisibility(0);
                }
                holder.m(holder.l(i3), gVar2.f417575a.f417573f);
                holder.n(holder.l(i3), gVar2.f417575a.f417572e + " x" + valueOf);
                holder.o(holder.l(i3), gVar2.f417575a.f417571d);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.haj, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new a(view);
    }

    public final void k0(@NotNull ArrayList<ArrayList<g>> lsData) {
        Intrinsics.checkNotNullParameter(lsData, "lsData");
        this.pageList = new ArrayList<>(lsData);
        notifyDataSetChanged();
    }
}
