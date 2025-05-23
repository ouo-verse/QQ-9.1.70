package com.tencent.mobileqq.mini.entry.expDesktop.part.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.SubPageMiniAppViewHolder;
import com.tencent.mobileqq.mini.entry.expDesktop.utils.MiniAppExpDesktopNotifyUtil;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0005\b\u0016\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\u0018\u0010\u0018\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u0005J6\u0010\u001c\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u001e2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0002X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/MiniAppExpDesktopSubAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/viewHolder/SubPageMiniAppViewHolder;", "()V", "mHostScene", "", "mMiniAppItems", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopAppInfo;", "Lkotlin/collections/ArrayList;", "mModuleType", "", "mSubPageMiniAppViewHolder", "mVia", "getItemCount", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "onViewDetachedFromWindow", "holder", "removeDeleteMiniAppItem", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "appId", "setData", "miniAppItems", "", "via", "hostScene", "moduleType", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public class MiniAppExpDesktopSubAdapter extends RecyclerView.Adapter<SubPageMiniAppViewHolder> {
    private static final int HIDE_PERSONAL_MODULE = 0;
    private static final int SHOW_PERSONAL_MODULE = 1;
    private static final String TAG = "MiniAppExpDesktopSubAdapter";
    private SubPageMiniAppViewHolder mSubPageMiniAppViewHolder;
    private ArrayList<DesktopAppInfo> mMiniAppItems = new ArrayList<>();
    private String mVia = "";
    private String mHostScene = "";
    private int mModuleType = 1;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.mMiniAppItems.isEmpty() ^ true ? 1 : 0;
    }

    public final void removeDeleteMiniAppItem(RecyclerView recyclerView, String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Iterator<DesktopAppInfo> it = this.mMiniAppItems.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "mMiniAppItems.iterator()");
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DesktopAppInfo next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
            if (next.mMiniAppInfo.appId.equals(appId)) {
                it.remove();
                QLog.i(TAG, 1, "remove mCurrentDeleteAppId:" + appId);
                break;
            }
        }
        MiniAppExpDesktopNotifyUtil.INSTANCE.safeNotifyDataSetChanged(recyclerView, this);
        QLog.i(TAG, 1, "removeDeleteMiniAppItem mCurrentDeleteAppId:" + appId);
    }

    public final void setData(RecyclerView recyclerView, List<DesktopAppInfo> miniAppItems, String via, String hostScene, int moduleType) {
        Intrinsics.checkNotNullParameter(miniAppItems, "miniAppItems");
        Intrinsics.checkNotNullParameter(via, "via");
        Intrinsics.checkNotNullParameter(hostScene, "hostScene");
        this.mMiniAppItems = (ArrayList) miniAppItems;
        this.mVia = via;
        this.mHostScene = hostScene;
        this.mModuleType = moduleType;
        MiniAppExpDesktopNotifyUtil.INSTANCE.safeNotifyDataSetChanged(recyclerView, this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(SubPageMiniAppViewHolder viewHolder, int position) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        SubPageMiniAppViewHolder subPageMiniAppViewHolder = this.mSubPageMiniAppViewHolder;
        if (subPageMiniAppViewHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSubPageMiniAppViewHolder");
            subPageMiniAppViewHolder = null;
        }
        subPageMiniAppViewHolder.bindView(this.mMiniAppItems, this.mVia, this.mHostScene, this.mModuleType);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SubPageMiniAppViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.diq, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026er_layout, parent, false)");
        SubPageMiniAppViewHolder subPageMiniAppViewHolder = new SubPageMiniAppViewHolder(inflate);
        this.mSubPageMiniAppViewHolder = subPageMiniAppViewHolder;
        return subPageMiniAppViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(SubPageMiniAppViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewDetachedFromWindow((MiniAppExpDesktopSubAdapter) holder);
        SubPageMiniAppViewHolder subPageMiniAppViewHolder = this.mSubPageMiniAppViewHolder;
        if (subPageMiniAppViewHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSubPageMiniAppViewHolder");
            subPageMiniAppViewHolder = null;
        }
        subPageMiniAppViewHolder.getMExpoReportHelper().stopValidExpoReport(false);
    }
}
