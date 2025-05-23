package com.tencent.ecommerce.biz.common;

import android.content.Context;
import android.widget.BaseAdapter;
import androidx.lifecycle.ViewModel;
import ck0.Category;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u0014\u0012\u0006\u0010\"\u001a\u00028\u0000\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0016\u0010\u000e\u001a\u00020\r2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bR&\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u000fj\b\u0012\u0004\u0012\u00020\u0007`\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\"\u001a\u00028\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/ecommerce/biz/common/a;", "Landroidx/lifecycle/ViewModel;", "T", "Landroid/widget/BaseAdapter;", "", "getCount", "position", "Lck0/b;", "b", "", "getItemId", "", "categoryList", "", "setData", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "categoryDataList", "Landroid/content/Context;", "e", "Landroid/content/Context;", "a", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "context", "f", "Landroidx/lifecycle/ViewModel;", "c", "()Landroidx/lifecycle/ViewModel;", "setViewModel", "(Landroidx/lifecycle/ViewModel;)V", "viewModel", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/ViewModel;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public abstract class a<T extends ViewModel> extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ArrayList<Category> categoryDataList = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Context context;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private T viewModel;

    public a(Context context, T t16) {
        this.context = context;
        this.viewModel = t16;
    }

    /* renamed from: a, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Category getItem(int position) {
        if (position < this.categoryDataList.size()) {
            return this.categoryDataList.get(position);
        }
        return null;
    }

    public final T c() {
        return this.viewModel;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.categoryDataList.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    public final void setData(List<Category> categoryList) {
        this.categoryDataList.clear();
        if (categoryList != null) {
            List<Category> list = categoryList;
            if (!list.isEmpty()) {
                this.categoryDataList.addAll(list);
            }
        }
        notifyDataSetChanged();
    }
}
