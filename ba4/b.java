package ba4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.view.color.list.CircleColorView;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import n74.da;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 ,2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003-./B\u0015\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u00a2\u0006\u0004\b+\u0010#J \u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0014\u0010\r\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bJ\u0014\u0010\u000e\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bJ\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J&\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J\u0018\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u001a\u001a\u00020\u0007H\u0016J\u000e\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001bR(\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010*\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)\u00a8\u00060"}, d2 = {"Lba4/b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lba4/b$c;", "Lba4/c;", "itemData", "Landroid/view/View;", "view", "", "position", "", "j0", "", "data", "p0", "o0", "q0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "n0", "holder", "", "", "payloads", "l0", "k0", "getItemCount", "Lba4/b$b;", "onItemSelectedListener", "r0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", BdhLogUtil.LogTag.Tag_Conn, "Lba4/b$b;", "getItemClick", "()Lba4/b$b;", "setItemClick", "(Lba4/b$b;)V", "itemClick", "<init>", "D", "a", "b", "c", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class b extends RecyclerView.Adapter<c> {

    /* renamed from: C, reason: from kotlin metadata */
    private InterfaceC0116b itemClick;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private List<ColorData> data;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\n"}, d2 = {"Lba4/b$b;", "", "Lba4/c;", "colorData", "Landroid/view/View;", "view", "", "position", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ba4.b$b, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public interface InterfaceC0116b {
        void a(ColorData colorData, View view, int position);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lba4/b$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Ln74/da;", "E", "Ln74/da;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ln74/da;", "binding", "Lcom/tencent/sqshow/zootopia/nativeui/view/color/list/CircleColorView;", UserInfo.SEX_FEMALE, "Lcom/tencent/sqshow/zootopia/nativeui/view/color/list/CircleColorView;", "o", "()Lcom/tencent/sqshow/zootopia/nativeui/view/color/list/CircleColorView;", "colorView", "Landroid/view/View;", "G", "Landroid/view/View;", "l", "()Landroid/view/View;", "bgView", "<init>", "(Ln74/da;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class c extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final da binding;

        /* renamed from: F, reason: from kotlin metadata */
        private final CircleColorView colorView;

        /* renamed from: G, reason: from kotlin metadata */
        private final View bgView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(da binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
            CircleColorView circleColorView = binding.f419198c;
            Intrinsics.checkNotNullExpressionValue(circleColorView, "binding.colorView");
            this.colorView = circleColorView;
            View view = binding.f419200e;
            Intrinsics.checkNotNullExpressionValue(view, "binding.selectBg");
            this.bgView = view;
        }

        /* renamed from: l, reason: from getter */
        public final View getBgView() {
            return this.bgView;
        }

        /* renamed from: m, reason: from getter */
        public final da getBinding() {
            return this.binding;
        }

        /* renamed from: o, reason: from getter */
        public final CircleColorView getColorView() {
            return this.colorView;
        }
    }

    public b(List<ColorData> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }

    private final void j0(ColorData itemData, View view, int position) {
        InterfaceC0116b interfaceC0116b = this.itemClick;
        if (interfaceC0116b != null) {
            interfaceC0116b.a(itemData, view, position);
        }
        int size = this.data.size();
        int i3 = 0;
        while (true) {
            boolean z16 = true;
            if (i3 < size) {
                ColorData colorData = this.data.get(i3);
                if (i3 != position) {
                    z16 = false;
                }
                colorData.e(z16);
                i3++;
            } else {
                QLog.d("AvatarPickColorAdapter_", 1, "click Item => " + position);
                notifyItemRangeChanged(0, this.data.size(), "updateBg");
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(b this$0, int i3, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ColorData colorData = this$0.data.get(i3);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.j0(colorData, it, i3);
    }

    public final List<ColorData> getData() {
        return this.data;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(c holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(c holder, final int position, List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.onBindViewHolder(holder, position, payloads);
        if (this.data.size() <= position) {
            return;
        }
        ColorData colorData = this.data.get(position);
        if (payloads.isEmpty()) {
            if (colorData.getColorIndex() == 1) {
                holder.getColorView().setGradientColor(colorData.getGradientColor());
            } else if (colorData.getColorIndex() == 2) {
                holder.getColorView().setHueColor(colorData.getGradientColor());
            } else {
                holder.getColorView().setSingleColor(colorData.getSingleColor());
            }
            holder.getBinding().getRoot().setOnClickListener(new View.OnClickListener() { // from class: ba4.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    b.m0(b.this, position, view);
                }
            });
        }
        if (payloads.size() == 1 && (Intrinsics.areEqual(TypeIntrinsics.asMutableList(payloads).get(0), "updateSelectedItemColor") || Intrinsics.areEqual(TypeIntrinsics.asMutableList(payloads).get(0), "updateColor"))) {
            holder.getColorView().setSingleColor(colorData.getSingleColor());
        }
        holder.getBgView().setVisibility(colorData.getIsSelected() ? 0 : 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        da g16 = da.g(LayoutInflater.from(parent.getContext()));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(parent.context))");
        return new c(g16);
    }

    public final void o0(List<ColorData> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        notifyItemRangeChanged(0, data.size(), "updateColor");
    }

    public final void p0(List<ColorData> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        notifyItemRangeChanged(0, data.size(), "updateBg");
    }

    public final void q0(ColorData itemData) {
        List mutableList;
        List<ColorData> list;
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        int size = this.data.size();
        if (size >= 0) {
            int i3 = 0;
            while (!this.data.get(i3).getIsSelected()) {
                if (i3 == size) {
                    return;
                } else {
                    i3++;
                }
            }
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.data);
            mutableList.set(i3, itemData);
            list = CollectionsKt___CollectionsKt.toList(mutableList);
            this.data = list;
            notifyItemRangeChanged(i3, 1, "updateSelectedItemColor");
        }
    }

    public final void r0(InterfaceC0116b onItemSelectedListener) {
        Intrinsics.checkNotNullParameter(onItemSelectedListener, "onItemSelectedListener");
        this.itemClick = onItemSelectedListener;
    }
}
