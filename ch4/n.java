package ch4;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import ch4.a;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u00a2\u0006\u0004\b$\u0010%J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0007H\u0016J&\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR$\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u001fj\b\u0012\u0004\u0012\u00020\u0003` 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lch4/n;", "Landroid/widget/BaseAdapter;", "", "", "tagList", "", "setData", "", "getCount", "position", "", "getItem", "", "getItemId", "Landroid/view/View;", "convertView", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "getView", "Landroid/content/Context;", "d", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lch4/a;", "e", "Lch4/a;", "getAction", "()Lch4/a;", "action", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "f", "Ljava/util/ArrayList;", "mDataList", "<init>", "(Landroid/content/Context;Lch4/a;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class n extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a action;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<String> mDataList;

    public n(@NotNull Context context, @NotNull a action) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(action, "action");
        this.context = context;
        this.action = action;
        this.mDataList = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void b(Ref.ObjectRef itemView, n this$0, View view) {
        String str;
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(itemView, "$itemView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CharSequence text = ((nr2.v) itemView.element).f421145b.getText();
        if (text != null) {
            str = text.toString();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            a.C0193a.a(this$0.action, str, false, 2, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mDataList.size();
    }

    @Override // android.widget.Adapter
    @NotNull
    public Object getItem(int position) {
        String str = this.mDataList.get(position);
        Intrinsics.checkNotNullExpressionValue(str, "mDataList[position]");
        return str;
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v19, types: [nr2.v, T] */
    @Override // android.widget.Adapter
    @Nullable
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {
        FrameLayout root;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (objectRef.element == 0) {
            objectRef.element = nr2.v.g(LayoutInflater.from(this.context));
        }
        T t16 = objectRef.element;
        if (t16 == 0) {
            root = null;
        } else {
            ((nr2.v) t16).f421145b.setText(this.mDataList.get(position));
            ((nr2.v) objectRef.element).f421145b.setContentDescription(this.mDataList.get(position));
            ((nr2.v) objectRef.element).f421145b.setTextColor(Color.parseColor("#03081A"));
            Button button = ((nr2.v) objectRef.element).f421145b;
            Intrinsics.checkNotNullExpressionValue(button, "itemView.tagBtn");
            fh4.g.f(button, fh4.b.b(12), fh4.c.a("#F5F6FA"));
            ((nr2.v) objectRef.element).f421145b.setOnClickListener(new View.OnClickListener() { // from class: ch4.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    n.b(Ref.ObjectRef.this, this, view);
                }
            });
            root = ((nr2.v) objectRef.element).getRoot();
        }
        EventCollector.getInstance().onListGetView(position, convertView, parent, getItemId(position));
        return root;
    }

    public final void setData(@NotNull List<String> tagList) {
        Intrinsics.checkNotNullParameter(tagList, "tagList");
        this.mDataList.clear();
        this.mDataList.addAll(tagList);
    }
}
