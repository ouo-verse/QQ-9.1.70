package com.tencent.mobileqq.mini.entry.newdesktop.part.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.PartLifecycleHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopSearchInfo;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\u0006\u0010\u0010\u001a\u00020\u0007J\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J&\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00072\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0007H\u0016J\u0006\u0010\u001e\u001a\u00020\u0014J\u0010\u0010\u001f\u001a\u00020\u00142\b\u0010 \u001a\u0004\u0018\u00010\u000eJ\u000e\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u0007J\u0006\u0010#\u001a\u00020\u0014R\u0014\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\b\n\u0000\u0012\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0002X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/MiniAppSearchAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/mini/entry/newdesktop/part/adapter/MiniAppSearchViewHolder;", "portHost", "Lcom/tencent/biz/richframework/PartLifecycleHost;", "(Lcom/tencent/biz/richframework/PartLifecycleHost;)V", "mColorType", "", "getMColorType$annotations", "()V", "mKeyIndex", "mMiniAppSearchViewHolder", "mPartHost", "mSearchData", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopSearchInfo;", "getItemCount", "getKeywordSize", "isNeedUpdateKeyword", "", "onBindViewHolder", "", "holder", "position", "payloads", "", "", "onCreateViewHolder", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "viewType", "resetKeywordIndex", "setData", "searchInfo", "setSearchBarColorType", "colorType", "updateKeyword", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppSearchAdapter extends RecyclerView.Adapter<MiniAppSearchViewHolder> {
    private static final String TAG = "MiniAppSearchAdapter";
    private int mColorType;
    private int mKeyIndex;
    private MiniAppSearchViewHolder mMiniAppSearchViewHolder;
    private PartLifecycleHost mPartHost;
    private DesktopSearchInfo mSearchData;

    public MiniAppSearchAdapter(PartLifecycleHost portHost) {
        Intrinsics.checkNotNullParameter(portHost, "portHost");
        this.mPartHost = portHost;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return 1;
    }

    public final int getKeywordSize() {
        DesktopSearchInfo desktopSearchInfo = this.mSearchData;
        if (desktopSearchInfo != null) {
            Intrinsics.checkNotNull(desktopSearchInfo);
            List<String> list = desktopSearchInfo.keyword;
            if (!(list == null || list.isEmpty())) {
                DesktopSearchInfo desktopSearchInfo2 = this.mSearchData;
                Intrinsics.checkNotNull(desktopSearchInfo2);
                return desktopSearchInfo2.keyword.size();
            }
        }
        return 0;
    }

    public final boolean isNeedUpdateKeyword() {
        DesktopSearchInfo desktopSearchInfo;
        if (this.mPartHost != null && this.mMiniAppSearchViewHolder != null && (desktopSearchInfo = this.mSearchData) != null) {
            Intrinsics.checkNotNull(desktopSearchInfo);
            List<String> list = desktopSearchInfo.keyword;
            if (!(list == null || list.isEmpty())) {
                return true;
            }
        }
        QLog.i(TAG, 1, "not need update search keyword!");
        return false;
    }

    public final void resetKeywordIndex() {
        int i3 = this.mKeyIndex;
        Intrinsics.checkNotNull(this.mSearchData);
        if (i3 < r1.keyword.size() - 1) {
            this.mKeyIndex++;
        } else {
            this.mKeyIndex = 0;
        }
    }

    public final void setData(DesktopSearchInfo searchInfo) {
        this.mSearchData = searchInfo;
        this.mKeyIndex = 0;
        notifyItemChanged(0);
    }

    public final void setSearchBarColorType(int colorType) {
        MiniAppSearchViewHolder miniAppSearchViewHolder = this.mMiniAppSearchViewHolder;
        if (miniAppSearchViewHolder != null) {
            miniAppSearchViewHolder.setSearchBarColorType(colorType);
        }
        this.mColorType = colorType;
    }

    public final void updateKeyword() {
        MiniAppSearchViewHolder miniAppSearchViewHolder = this.mMiniAppSearchViewHolder;
        Intrinsics.checkNotNull(miniAppSearchViewHolder);
        PartLifecycleHost partLifecycleHost = this.mPartHost;
        Intrinsics.checkNotNull(partLifecycleHost);
        DesktopSearchInfo desktopSearchInfo = this.mSearchData;
        Intrinsics.checkNotNull(desktopSearchInfo);
        String str = desktopSearchInfo.keyword.get(this.mKeyIndex);
        Intrinsics.checkNotNullExpressionValue(str, "mSearchData!!.keyword[mKeyIndex]");
        miniAppSearchViewHolder.updateSearchKeyword(partLifecycleHost, desktopSearchInfo, str);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(MiniAppSearchViewHolder miniAppSearchViewHolder, int i3, List list) {
        onBindViewHolder2(miniAppSearchViewHolder, i3, (List<Object>) list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MiniAppSearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.dik, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026er_layout, parent, false)");
        MiniAppSearchViewHolder miniAppSearchViewHolder = new MiniAppSearchViewHolder(inflate);
        this.mMiniAppSearchViewHolder = miniAppSearchViewHolder;
        miniAppSearchViewHolder.setSearchBarColorType(this.mColorType);
        MiniAppSearchViewHolder miniAppSearchViewHolder2 = this.mMiniAppSearchViewHolder;
        Intrinsics.checkNotNull(miniAppSearchViewHolder2);
        return miniAppSearchViewHolder2;
    }

    /* renamed from: onBindViewHolder, reason: avoid collision after fix types in other method */
    public void onBindViewHolder2(MiniAppSearchViewHolder holder, int position, List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        holder.bindView(this.mSearchData);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MiniAppSearchViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        MiniAppSearchViewHolder miniAppSearchViewHolder = this.mMiniAppSearchViewHolder;
        if (miniAppSearchViewHolder != null) {
            miniAppSearchViewHolder.bindView(this.mSearchData);
        }
    }

    private static /* synthetic */ void getMColorType$annotations() {
    }
}
