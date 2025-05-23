package com.tencent.mm.ui.widget.edittext;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper;
import com.tencent.mobileqq.R;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyHolder> {

    /* renamed from: a, reason: collision with root package name */
    public SelectableEditTextHelper.SelectionInfo f153234a;

    /* renamed from: b, reason: collision with root package name */
    public SelectableEditTextHelper.OnMenuCallback f153235b;
    public List<SelectableEditTextHelper.MenuItem> mData;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class MyHolder extends RecyclerView.ViewHolder {

        /* renamed from: a, reason: collision with root package name */
        public TextView f153237a;

        public MyHolder(View view) {
            super(view);
            TextView textView = (TextView) view.findViewById(R.id.f166239z41);
            this.f153237a = textView;
            textView.setTextSize(1, 14.0f);
        }
    }

    public MyRecycleViewAdapter(List<SelectableEditTextHelper.MenuItem> list, SelectableEditTextHelper.OnMenuCallback onMenuCallback, SelectableEditTextHelper.SelectionInfo selectionInfo) {
        this.mData = list;
        this.f153235b = onMenuCallback;
        this.f153234a = selectionInfo;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mData.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MyHolder myHolder, int i3) {
        SelectableEditTextHelper.MenuItem menuItem = this.mData.get(i3);
        myHolder.f153237a.setText(menuItem.name);
        myHolder.f153237a.setTag(menuItem);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MyHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fep, viewGroup, false);
        MyHolder myHolder = new MyHolder(inflate);
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.edittext.MyRecycleViewAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                if (view != null || (view.getTag() instanceof SelectableEditTextHelper.MenuItem)) {
                    SelectableEditTextHelper.MenuItem menuItem = (SelectableEditTextHelper.MenuItem) view.getTag();
                    if (!TextUtils.isEmpty(MyRecycleViewAdapter.this.f153234a.mSelectionContent)) {
                        str = MyRecycleViewAdapter.this.f153234a.mSelectionContent;
                    } else {
                        str = "";
                    }
                    MyRecycleViewAdapter.this.f153235b.onMenuItemClicked(view, menuItem, str);
                }
            }
        });
        return myHolder;
    }
}
