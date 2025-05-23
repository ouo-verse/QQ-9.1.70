package com.tencent.mm.ui.widget.dialog;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mm.ui.widget.dialog.MMFilterDialog;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class MMFilterDialog extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public View f153069a;

    /* renamed from: b, reason: collision with root package name */
    public LinearLayout f153070b;

    /* renamed from: c, reason: collision with root package name */
    public LinearLayout f153071c;

    /* renamed from: d, reason: collision with root package name */
    public RecyclerView f153072d;

    /* renamed from: e, reason: collision with root package name */
    public DropdownAdapter f153073e;

    /* renamed from: f, reason: collision with root package name */
    public RecyclerView f153074f;

    /* renamed from: g, reason: collision with root package name */
    public FilterAdapter f153075g;

    /* renamed from: h, reason: collision with root package name */
    public LayoutStyle f153076h;

    /* renamed from: i, reason: collision with root package name */
    public SheetType f153077i;

    /* renamed from: j, reason: collision with root package name */
    public int f153078j;

    /* renamed from: k, reason: collision with root package name */
    public final List f153079k;

    /* renamed from: l, reason: collision with root package name */
    public Animation f153080l;

    /* renamed from: m, reason: collision with root package name */
    public Animation f153081m;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class ArrayFilterItem extends BaseFilterItem {

        /* renamed from: d, reason: collision with root package name */
        public final String[] f153085d;

        public ArrayFilterItem(@NonNull String[] strArr, int i3) {
            this(strArr, i3, strArr[i3]);
        }

        @Override // com.tencent.mm.ui.widget.dialog.MMFilterDialog.BaseFilterItem
        public int getChoiceCount() {
            return this.f153085d.length;
        }

        @Override // com.tencent.mm.ui.widget.dialog.MMFilterDialog.BaseFilterItem
        public CharSequence getTitleAt(int i3) {
            return this.f153085d[i3];
        }

        public ArrayFilterItem(@NonNull String[] strArr, int i3, @NonNull String str) {
            super(str, i3);
            this.f153085d = strArr;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class AutoDivideLayoutManager extends RecyclerView.LayoutManager {
        AutoDivideLayoutManager() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public RecyclerView.LayoutParams generateDefaultLayoutParams() {
            return new RecyclerView.LayoutParams(-2, -1);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
            if (getItemCount() == 0) {
                return;
            }
            detachAndScrapAttachedViews(recycler);
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            ArrayList arrayList = new ArrayList(getItemCount());
            Rect rect = new Rect();
            int i3 = 0;
            for (int i16 = 0; i16 < getItemCount(); i16++) {
                View viewForPosition = recycler.getViewForPosition(i16);
                calculateItemDecorationsForChild(viewForPosition, rect);
                i3 += rect.left + rect.right;
                arrayList.add(new Pair(viewForPosition, Integer.valueOf(rect.left + rect.right)));
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int max = Math.max(0, width - i3) / arrayList.size();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                measureChildWithMargins((View) pair.first, (width - max) - ((Integer) pair.second).intValue(), 0);
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) ((View) pair.first).getLayoutParams();
                addView((View) pair.first);
                int intValue = paddingLeft + ((Integer) pair.second).intValue() + max;
                layoutDecorated((View) pair.first, paddingLeft + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, paddingTop + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, intValue - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, (((getHeight() - getPaddingTop()) - getPaddingBottom()) + paddingTop) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                paddingLeft = intValue;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static abstract class BaseFilterItem {

        /* renamed from: a, reason: collision with root package name */
        public IUpdateViewRequest f153086a;

        /* renamed from: b, reason: collision with root package name */
        public CharSequence f153087b;

        /* renamed from: c, reason: collision with root package name */
        public int f153088c;

        public BaseFilterItem(@Nullable CharSequence charSequence, int i3) {
            this.f153087b = charSequence == null ? getTitleAt(i3) : charSequence;
            this.f153088c = i3;
        }

        public abstract int getChoiceCount();

        public CharSequence getDescAt(int i3) {
            return null;
        }

        public int getSelectedIndex() {
            return this.f153088c;
        }

        public abstract CharSequence getTitleAt(int i3);

        public boolean isCheckedAt(int i3) {
            if (this.f153088c == i3) {
                return true;
            }
            return false;
        }

        public boolean onItemClicked(int i3) {
            this.f153088c = i3;
            this.f153087b = getTitleAt(i3);
            updateView();
            return true;
        }

        public void setSelectedIndex(int i3) {
            this.f153088c = i3;
            this.f153087b = getTitleAt(i3);
        }

        public final void updateView() {
            IUpdateViewRequest iUpdateViewRequest = this.f153086a;
            if (iUpdateViewRequest != null) {
                iUpdateViewRequest.updateView(this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class DropdownAdapter extends RecyclerView.Adapter<ViewHolder> {

        /* renamed from: a, reason: collision with root package name */
        public BaseFilterItem f153089a;

        /* renamed from: b, reason: collision with root package name */
        public IOnItemClick f153090b;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static class ViewHolder extends RecyclerView.ViewHolder {

            /* renamed from: a, reason: collision with root package name */
            public final TextView f153091a;

            /* renamed from: b, reason: collision with root package name */
            public final TextView f153092b;

            /* renamed from: c, reason: collision with root package name */
            public final ImageView f153093c;

            public ViewHolder(@NonNull View view) {
                super(view);
                this.f153091a = (TextView) view.findViewById(R.id.dqd);
                this.f153092b = (TextView) view.findViewById(R.id.dpt);
                this.f153093c = (ImageView) view.findViewById(R.id.f82674hi);
            }
        }

        DropdownAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            BaseFilterItem baseFilterItem = this.f153089a;
            if (baseFilterItem == null) {
                return 0;
            }
            return baseFilterItem.getChoiceCount();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i3) {
            viewHolder.f153091a.setText(this.f153089a.getTitleAt(i3));
            CharSequence descAt = this.f153089a.getDescAt(i3);
            if (descAt != null) {
                viewHolder.f153092b.setVisibility(0);
                viewHolder.f153092b.setText(descAt);
            } else {
                viewHolder.f153092b.setVisibility(8);
            }
            if (this.f153089a.isCheckedAt(i3)) {
                viewHolder.f153093c.setVisibility(0);
            } else {
                viewHolder.f153093c.setVisibility(8);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f168300fk2, viewGroup, false);
            final ViewHolder viewHolder = new ViewHolder(inflate);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.dialog.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MMFilterDialog.DropdownAdapter.this.a(viewHolder, view);
                }
            });
            return viewHolder;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(ViewHolder viewHolder, View view) {
            IOnItemClick iOnItemClick;
            int adapterPosition = viewHolder.getAdapterPosition();
            if (adapterPosition == -1 || (iOnItemClick = this.f153090b) == null) {
                return;
            }
            iOnItemClick.onItemClicked(adapterPosition, this.f153089a);
        }

        public final void a(BaseFilterItem baseFilterItem) {
            this.f153089a = baseFilterItem;
            notifyDataSetChanged();
        }

        public final void a(IOnItemClick iOnItemClick) {
            this.f153090b = iOnItemClick;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class FilterAdapter extends RecyclerView.Adapter<ViewHolder> {

        /* renamed from: a, reason: collision with root package name */
        public IOnItemClick f153094a;

        /* renamed from: b, reason: collision with root package name */
        public final List f153095b;

        /* renamed from: c, reason: collision with root package name */
        public int f153096c = -1;

        /* renamed from: d, reason: collision with root package name */
        public SheetType f153097d;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public enum PayloadType {
            IsExpand,
            UpdateTitle
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static class ViewHolder extends RecyclerView.ViewHolder {

            /* renamed from: a, reason: collision with root package name */
            public final TextView f153099a;

            /* renamed from: b, reason: collision with root package name */
            public final WeImageView f153100b;

            public ViewHolder(@NonNull View view) {
                super(view);
                this.f153099a = (TextView) view.findViewById(R.id.jfb);
                this.f153100b = (WeImageView) view.findViewById(R.id.f164472yw);
            }
        }

        public FilterAdapter(List<BaseFilterItem> list, SheetType sheetType) {
            this.f153095b = list;
            this.f153097d = sheetType;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(ViewHolder viewHolder, View view) {
            IOnItemClick iOnItemClick;
            int adapterPosition = viewHolder.getAdapterPosition();
            if (adapterPosition != -1 && (iOnItemClick = this.f153094a) != null) {
                iOnItemClick.onItemClicked(adapterPosition, this.f153095b.get(adapterPosition));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f153095b.size();
        }

        public void setOnItemClicked(IOnItemClick iOnItemClick) {
            this.f153094a = iOnItemClick;
        }

        public void setSheetType(SheetType sheetType) {
            this.f153097d = sheetType;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ void onBindViewHolder(@NonNull ViewHolder viewHolder, int i3, @NonNull List list) {
            onBindViewHolder2(viewHolder, i3, (List<Object>) list);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
            final ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f168301fk3, viewGroup, false));
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.dialog.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MMFilterDialog.FilterAdapter.this.a(viewHolder, view);
                }
            });
            viewHolder.f153100b.setIconColor(viewHolder.f153100b.getContext().getColor(R.color.ark));
            return viewHolder;
        }

        /* renamed from: onBindViewHolder, reason: avoid collision after fix types in other method */
        public void onBindViewHolder2(@NonNull ViewHolder viewHolder, int i3, @NonNull List<Object> list) {
            if (list.isEmpty()) {
                onBindViewHolder(viewHolder, i3);
                return;
            }
            Iterator<Object> it = list.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                Object obj = pair.first;
                if (obj == PayloadType.IsExpand) {
                    boolean booleanValue = ((Boolean) pair.second).booleanValue();
                    if (booleanValue) {
                        this.f153096c = i3;
                    } else if (this.f153096c == i3) {
                        this.f153096c = -1;
                    }
                    ViewPropertyAnimator animate = viewHolder.f153100b.animate();
                    animate.cancel();
                    animate.rotation(booleanValue ? 270.0f : 90.0f);
                    animate.setDuration(300L);
                    animate.start();
                } else if (obj == PayloadType.UpdateTitle) {
                    viewHolder.f153099a.setText((String) pair.second);
                } else {
                    onBindViewHolder(viewHolder, i3);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i3) {
            viewHolder.f153099a.setText(((BaseFilterItem) this.f153095b.get(i3)).f153087b);
            viewHolder.f153100b.setRotation(i3 == this.f153096c ? 270.0f : 90.0f);
            SheetType sheetType = this.f153097d;
            if (sheetType == SheetType.Border) {
                viewHolder.itemView.setBackgroundResource(R.drawable.lvl);
            } else if (sheetType == SheetType.Grey) {
                viewHolder.itemView.setBackgroundResource(R.drawable.js8);
            } else {
                viewHolder.itemView.setBackground(null);
            }
        }
    }

    /* compiled from: P */
    @FunctionalInterface
    /* loaded from: classes9.dex */
    public interface IOnItemClick {
        void onItemClicked(int i3, Object obj);
    }

    /* compiled from: P */
    @FunctionalInterface
    /* loaded from: classes9.dex */
    public interface IUpdateViewRequest {
        void updateView(BaseFilterItem baseFilterItem);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public enum LayoutStyle {
        AlignLeft,
        DivideEqual
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public enum SheetType {
        Null,
        Grey,
        Border
    }

    public MMFilterDialog(Context context) {
        super(context);
        this.f153076h = LayoutStyle.DivideEqual;
        this.f153077i = SheetType.Grey;
        this.f153078j = -1;
        this.f153079k = new ArrayList();
        a(context, (AttributeSet) null);
    }

    public void addFilterItem(BaseFilterItem baseFilterItem) {
        baseFilterItem.f153086a = new b(this);
        this.f153079k.add(baseFilterItem);
        this.f153075g.notifyItemInserted(this.f153079k.size() - 1);
    }

    public void removeFilterItem(BaseFilterItem baseFilterItem) {
        int indexOf = this.f153079k.indexOf(baseFilterItem);
        if (indexOf >= 0) {
            ((BaseFilterItem) this.f153079k.remove(indexOf)).f153086a = null;
            this.f153075g.notifyItemRemoved(indexOf);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        this.f153071c.setBackgroundColor(i3);
        ((GradientDrawable) this.f153070b.getBackground()).setColor(i3);
    }

    public void setFilterItemList(List<BaseFilterItem> list) {
        Iterator it = this.f153079k.iterator();
        while (it.hasNext()) {
            ((BaseFilterItem) it.next()).f153086a = null;
        }
        this.f153079k.clear();
        this.f153079k.addAll(list);
        Iterator it5 = this.f153079k.iterator();
        while (it5.hasNext()) {
            ((BaseFilterItem) it5.next()).f153086a = new b(this);
        }
        this.f153075g.notifyDataSetChanged();
    }

    public void setLayoutStyle(LayoutStyle layoutStyle) {
        if (this.f153076h == layoutStyle) {
            return;
        }
        this.f153076h = layoutStyle;
        if (layoutStyle == LayoutStyle.AlignLeft) {
            this.f153074f.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        } else {
            this.f153074f.setLayoutManager(new AutoDivideLayoutManager());
        }
    }

    public void setSheetType(SheetType sheetType) {
        if (this.f153077i == sheetType) {
            return;
        }
        this.f153077i = sheetType;
        this.f153075g.setSheetType(sheetType);
        this.f153075g.notifyDataSetChanged();
    }

    public final void b(int i3, Object obj) {
        int i16 = this.f153078j;
        if (i16 == i3) {
            a();
            return;
        }
        if (i16 >= 0) {
            this.f153075g.notifyItemChanged(i16, new Pair(FilterAdapter.PayloadType.IsExpand, Boolean.FALSE));
        }
        this.f153075g.notifyItemChanged(i3, new Pair(FilterAdapter.PayloadType.IsExpand, Boolean.TRUE));
        this.f153078j = i3;
        this.f153073e.a((BaseFilterItem) obj);
        if (this.f153070b.getVisibility() != 0) {
            this.f153070b.setVisibility(0);
            this.f153070b.startAnimation(this.f153080l);
            if (this.f153069a.getVisibility() != 0) {
                this.f153069a.setVisibility(0);
                this.f153069a.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.f154554n8));
            }
        }
    }

    public final void a(Context context, AttributeSet attributeSet) {
        int dimensionPixelSize;
        View.inflate(getContext(), R.layout.f168299fk1, this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.lhp);
        this.f153074f = recyclerView;
        recyclerView.hasFixedSize();
        FilterAdapter filterAdapter = new FilterAdapter(this.f153079k, this.f153077i);
        this.f153075g = filterAdapter;
        filterAdapter.setOnItemClicked(new IOnItemClick() { // from class: com.tencent.mm.ui.widget.dialog.c
            @Override // com.tencent.mm.ui.widget.dialog.MMFilterDialog.IOnItemClick
            public final void onItemClicked(int i3, Object obj) {
                MMFilterDialog.this.b(i3, obj);
            }
        });
        this.f153074f.setAdapter(this.f153075g);
        if (this.f153076h == LayoutStyle.AlignLeft) {
            this.f153074f.setLayoutManager(new LinearLayoutManager(context, 0, false));
        } else {
            this.f153074f.setLayoutManager(new AutoDivideLayoutManager());
        }
        final int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.bj8);
        this.f153074f.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.tencent.mm.ui.widget.dialog.MMFilterDialog.1
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView2, @NonNull RecyclerView.State state) {
                super.getItemOffsets(rect, view, recyclerView2, state);
                if (recyclerView2.getChildLayoutPosition(view) != 0) {
                    if (MMFilterDialog.this.f153077i == SheetType.Border || MMFilterDialog.this.f153077i == SheetType.Grey) {
                        rect.left = dimensionPixelSize2;
                    }
                }
            }
        });
        this.f153069a = findViewById(R.id.a4f);
        this.f153071c = (LinearLayout) findViewById(R.id.t4f);
        this.f153070b = (LinearLayout) findViewById(R.id.f164985ui0);
        RecyclerView recyclerView2 = (RecyclerView) findViewById(R.id.f223803k);
        this.f153072d = recyclerView2;
        recyclerView2.setHasFixedSize(true);
        this.f153072d.setLayoutManager(new LinearLayoutManager(context));
        DropdownAdapter dropdownAdapter = new DropdownAdapter();
        this.f153073e = dropdownAdapter;
        dropdownAdapter.a(new IOnItemClick() { // from class: com.tencent.mm.ui.widget.dialog.d
            @Override // com.tencent.mm.ui.widget.dialog.MMFilterDialog.IOnItemClick
            public final void onItemClicked(int i3, Object obj) {
                MMFilterDialog.this.a(i3, obj);
            }
        });
        this.f153072d.setAdapter(this.f153073e);
        this.f153073e.notifyDataSetChanged();
        this.f153080l = AnimationUtils.loadAnimation(getContext(), R.anim.f154803s6);
        this.f153081m = AnimationUtils.loadAnimation(getContext(), R.anim.f154804s7);
        this.f153069a.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.dialog.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MMFilterDialog.this.a(view);
            }
        });
        if (attributeSet == null || (dimensionPixelSize = context.obtainStyledAttributes(attributeSet, com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable.MMFilterDialog).getDimensionPixelSize(com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable.MMFilterDialog_TabHeight, -1)) <= 0) {
            return;
        }
        this.f153074f.getLayoutParams().height = dimensionPixelSize;
        ViewGroup.LayoutParams layoutParams = this.f153072d.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = dimensionPixelSize;
        }
    }

    public MMFilterDialog(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f153076h = LayoutStyle.DivideEqual;
        this.f153077i = SheetType.Grey;
        this.f153078j = -1;
        this.f153079k = new ArrayList();
        a(context, attributeSet);
    }

    public MMFilterDialog(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f153076h = LayoutStyle.DivideEqual;
        this.f153077i = SheetType.Grey;
        this.f153078j = -1;
        this.f153079k = new ArrayList();
        a(context, attributeSet);
    }

    public MMFilterDialog(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.f153076h = LayoutStyle.DivideEqual;
        this.f153077i = SheetType.Grey;
        this.f153078j = -1;
        this.f153079k = new ArrayList();
        a(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        a();
    }

    public final void a() {
        int i3 = this.f153078j;
        if (i3 >= 0) {
            this.f153075g.notifyItemChanged(i3, new Pair(FilterAdapter.PayloadType.IsExpand, Boolean.FALSE));
        }
        this.f153078j = -1;
        if (this.f153070b.getVisibility() == 0) {
            this.f153069a.setVisibility(8);
            this.f153081m.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.mm.ui.widget.dialog.MMFilterDialog.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    MMFilterDialog.this.f153070b.setVisibility(8);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            this.f153070b.startAnimation(this.f153081m);
        }
    }

    public final void a(int i3, Object obj) {
        if (((BaseFilterItem) obj).onItemClicked(i3)) {
            a();
        }
    }

    public final void a(BaseFilterItem baseFilterItem) {
        int indexOf = this.f153079k.indexOf(baseFilterItem);
        if (indexOf >= 0) {
            this.f153075g.notifyItemChanged(indexOf, new Pair(FilterAdapter.PayloadType.UpdateTitle, baseFilterItem.f153087b));
        }
    }
}
