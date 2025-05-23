package fg3;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import fg3.FaceItemData;
import fg3.b;
import fg3.f;
import fg3.j;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0006\u0010\u0004\u001a\u00020\u0003J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0016R2\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0011j\b\u0012\u0004\u0012\u00020\u0005`\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010!\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001c\u00a8\u0006&"}, d2 = {"Lfg3/d;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lfg3/c;", "", "j0", "Lfg3/l;", "l0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "n0", "holder", "position", "", "m0", "getItemCount", "getItemViewType", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "i0", "()Ljava/util/ArrayList;", "setDataList", "(Ljava/util/ArrayList;)V", "dataList", "Lfg3/x;", BdhLogUtil.LogTag.Tag_Conn, "Lfg3/x;", "k0", "()Lfg3/x;", "o0", "(Lfg3/x;)V", "listener", "D", "innerListener", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d extends RecyclerView.Adapter<c> {

    /* renamed from: C, reason: from kotlin metadata */
    private x listener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ArrayList<FaceItemData> dataList = new ArrayList<>();

    /* renamed from: D, reason: from kotlin metadata */
    private final x innerListener = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"fg3/d$a", "Lfg3/x;", "Lfg3/l;", "faceItemData", "", "index", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a implements x {
        a() {
        }

        @Override // fg3.x
        public void a(FaceItemData faceItemData, int index) {
            Intrinsics.checkNotNullParameter(faceItemData, "faceItemData");
            x listener = d.this.getListener();
            if (listener != null) {
                listener.a(faceItemData, d.this.i0().indexOf(faceItemData));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.dataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.dataList.get(position).getType();
    }

    public final ArrayList<FaceItemData> i0() {
        return this.dataList;
    }

    public final int j0() {
        ArrayList<FaceItemData> arrayList = this.dataList;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((FaceItemData) obj).getFace() != null) {
                arrayList2.add(obj);
            }
        }
        return arrayList2.size();
    }

    /* renamed from: k0, reason: from getter */
    public final x getListener() {
        return this.listener;
    }

    public final FaceItemData l0() {
        Object obj;
        Iterator<T> it = this.dataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            FaceItemData faceItemData = (FaceItemData) obj;
            if (faceItemData.getIsSelected() && faceItemData.getType() == FaceItemData.INSTANCE.d()) {
                break;
            }
        }
        return (FaceItemData) obj;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(c holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        FaceItemData faceItemData = this.dataList.get(position);
        Intrinsics.checkNotNullExpressionValue(faceItemData, "dataList[position]");
        holder.m(faceItemData, position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(ViewGroup parent, int viewType) {
        c a16;
        Intrinsics.checkNotNullParameter(parent, "parent");
        FaceItemData.Companion companion = FaceItemData.INSTANCE;
        if (viewType == companion.b()) {
            b.Companion companion2 = b.INSTANCE;
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            a16 = companion2.a(context, parent);
        } else if (viewType == companion.d()) {
            j.Companion companion3 = j.INSTANCE;
            Context context2 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "parent.context");
            a16 = companion3.a(context2, parent);
        } else {
            f.Companion companion4 = f.INSTANCE;
            Context context3 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "parent.context");
            a16 = companion4.a(context3, parent);
        }
        ViewGroup.LayoutParams layoutParams = a16.itemView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = ViewUtils.dip2px(94.0f);
        }
        a16.n(this.innerListener);
        return a16;
    }

    public final void o0(x xVar) {
        this.listener = xVar;
    }
}
