package com.tencent.biz.richframework.part.block.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.PartLifecycleCallbacks;
import com.tencent.biz.richframework.part.b;
import com.tencent.biz.richframework.part.utils.ArrayUtils;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class BaseListViewAdapter<E> extends RecyclerView.Adapter implements PartLifecycleCallbacks {
    private static final String TAG = "BaseListViewAdapter";
    protected List<E> mDataList = new ArrayList();
    protected AsyncListDiffer<E> mDiffer;
    private Handler mMainHandler;
    protected RecyclerView mRecyclerView;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class BaseVH extends RecyclerView.ViewHolder {
        public BaseVH(View view) {
            super(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface OnItemClickListener {
        void onItemClick(View view, Object obj, Object obj2);
    }

    public BaseListViewAdapter() {
        if (getDiffCallBack() != null) {
            this.mDiffer = new AsyncListDiffer<>(new AdapterListUpdateCallback(this), new AsyncDifferConfig.Builder(getDiffCallBack()).setBackgroundThreadExecutor(new Executor() { // from class: com.tencent.biz.richframework.part.block.base.BaseListViewAdapter.1
                @Override // java.util.concurrent.Executor
                public void execute(Runnable runnable) {
                    RFWThreadManager.getInstance().execOnAsyncDisplayThread(runnable);
                }
            }).build());
        }
    }

    public void addAll(E[] eArr) {
        if (eArr == null) {
            return;
        }
        int size = this.mDataList.size();
        this.mDataList.addAll(Arrays.asList(eArr));
        notifyItemRangeInserted(size, eArr.length);
    }

    public void addData(E e16, int i3) {
        this.mDataList.add(i3, e16);
    }

    public void clearData() {
        this.mDataList.clear();
    }

    public void delete(int i3) {
        if (i3 < this.mDataList.size()) {
            this.mDataList.remove(i3);
        }
    }

    public List<E> getDataList() {
        AsyncListDiffer<E> asyncListDiffer = this.mDiffer;
        if (asyncListDiffer != null) {
            return asyncListDiffer.getCurrentList();
        }
        return this.mDataList;
    }

    public int getDataNumber() {
        return this.mDataList.size();
    }

    protected DiffUtil.ItemCallback<E> getDiffCallBack() {
        return null;
    }

    public E getItem(int i3) {
        AsyncListDiffer<E> asyncListDiffer = this.mDiffer;
        if (asyncListDiffer != null) {
            return asyncListDiffer.getCurrentList().get(i3);
        }
        List<E> list = this.mDataList;
        if (list != null && !ArrayUtils.isOutOfArrayIndex(i3, list)) {
            return this.mDataList.get(i3);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        AsyncListDiffer<E> asyncListDiffer = this.mDiffer;
        if (asyncListDiffer != null) {
            return asyncListDiffer.getCurrentList().size();
        }
        return this.mDataList.size();
    }

    public Handler getMainHandler() {
        if (this.mMainHandler == null) {
            this.mMainHandler = new Handler(Looper.getMainLooper());
        }
        return this.mMainHandler;
    }

    public RecyclerView getRecyclerView() {
        return this.mRecyclerView;
    }

    public void insertData(List<E> list, int i3) {
        if (list == null) {
            return;
        }
        this.mDataList.clear();
        this.mDataList.addAll(list);
        notifyItemRangeInserted(i3, list.size());
    }

    protected boolean isItemEqual(E e16, E e17) {
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.mRecyclerView = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        getMainHandler().removeCallbacksAndMessages(null);
    }

    public /* synthetic */ void onPartDestroy(Activity activity) {
        b.b(this, activity);
    }

    public /* synthetic */ void onPartPause(Activity activity) {
        b.c(this, activity);
    }

    public /* synthetic */ void onPartResume(Activity activity) {
        b.d(this, activity);
    }

    public /* synthetic */ void onPartSaveInstanceState(Activity activity, Bundle bundle) {
        b.e(this, activity, bundle);
    }

    public /* synthetic */ void onPartStart(Activity activity) {
        b.f(this, activity);
    }

    public /* synthetic */ void onPartStop(Activity activity) {
        b.g(this, activity);
    }

    public void setDatas(List<E> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        if (this.mDiffer != null) {
            submitList(list);
        } else {
            setDatasDefault(list);
        }
    }

    public void setDatasDefault(@NonNull List<E> list) {
        this.mDataList.clear();
        if (list == null) {
            notifyDataSetChanged();
        } else {
            this.mDataList.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void submitList(List<E> list) {
        AsyncListDiffer<E> asyncListDiffer = this.mDiffer;
        if (asyncListDiffer != null) {
            asyncListDiffer.submitList(new ArrayList(list));
        }
    }

    public void updateData(E e16, int i3) {
        if (e16 != null && i3 < this.mDataList.size()) {
            this.mDataList.set(i3, e16);
        }
    }

    public E addData(E e16) {
        if (e16 == null) {
            return null;
        }
        for (E e17 : this.mDataList) {
            if (e17 == e16) {
                return e17;
            }
            if (isItemEqual(e17, e16)) {
                copyItem(e17, e16);
                return e17;
            }
        }
        if (!this.mDataList.add(e16)) {
            return null;
        }
        return this.mDataList.get(r5.size() - 1);
    }

    public void submitList(List<E> list, Runnable runnable) {
        AsyncListDiffer<E> asyncListDiffer = this.mDiffer;
        if (asyncListDiffer != null) {
            asyncListDiffer.submitList(new ArrayList(list), runnable);
        }
    }

    public void addAll(List<E> list) {
        if (list == null) {
            return;
        }
        int size = this.mDataList.size();
        this.mDataList.addAll(list);
        notifyItemRangeInserted(size, list.size());
    }

    protected void copyItem(E e16, E e17) {
    }

    public void onActivityResult(int i3, int i16, Intent intent) {
    }
}
