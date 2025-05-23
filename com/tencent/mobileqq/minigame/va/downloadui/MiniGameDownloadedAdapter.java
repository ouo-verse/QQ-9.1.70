package com.tencent.mobileqq.minigame.va.downloadui;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.minigame.utils.MiniGameDownloadUtil;
import com.tencent.mobileqq.minigame.va.MiniGameDownloadDataWrapper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\nH\u0002J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\nH\u0002J\u0018\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\nH\u0002J\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u001f\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\n2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0002\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001bH\u0016J\u0018\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001bH\u0016J\u000e\u0010%\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J\u0014\u0010+\u001a\u00020\u00122\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0,R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/minigame/va/downloadui/MiniGameDownloadedAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/minigame/va/downloadui/MiniGameDownloadedHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "dataList", "", "Lcom/tencent/mobileqq/minigame/va/MiniGameDownloadDataWrapper;", "getDataList", "()Ljava/util/List;", "setDataList", "(Ljava/util/List;)V", "itemClickListener", "Lcom/tencent/mobileqq/minigame/va/downloadui/DownloadedItemClickListener;", "bindController", "", "holder", "data", "bindCover", "bindOccupiedSpace", "deleteData", VirtualAppProxy.KEY_GAME_ID, "", "getItemCount", "", "insert", "index", "(Lcom/tencent/mobileqq/minigame/va/MiniGameDownloadDataWrapper;Ljava/lang/Integer;)V", "onBindViewHolder", "position", "onCreateViewHolder", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "viewType", "setOnItemClickListener", "showOccupySpaceSize", "txv", "Landroid/widget/TextView;", "occupiedSize", "", "updateList", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameDownloadedAdapter extends RecyclerView.Adapter<MiniGameDownloadedHolder> {
    private final Context context;
    private List<MiniGameDownloadDataWrapper> dataList;
    private DownloadedItemClickListener itemClickListener;

    public MiniGameDownloadedAdapter(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.dataList = new ArrayList();
    }

    private final void bindController(MiniGameDownloadedHolder holder, final MiniGameDownloadDataWrapper data) {
        holder.getControllerView().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.minigame.va.downloadui.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniGameDownloadedAdapter.bindController$lambda$3(MiniGameDownloadedAdapter.this, data, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindController$lambda$3(MiniGameDownloadedAdapter this$0, MiniGameDownloadDataWrapper data, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        DownloadedItemClickListener downloadedItemClickListener = this$0.itemClickListener;
        if (downloadedItemClickListener != null) {
            downloadedItemClickListener.onOpenMiniGameClick(data);
        }
    }

    private final void bindCover(MiniGameDownloadedHolder holder, MiniGameDownloadDataWrapper data) {
        boolean startsWith$default;
        URLDrawable fileDrawable;
        if (TextUtils.isEmpty(data.getData().getGameIcon())) {
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = ViewUtils.dpToPx(68.0f);
        obtain.mRequestHeight = ViewUtils.dpToPx(68.0f);
        try {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(data.getData().getGameIcon(), "http", false, 2, null);
            if (startsWith$default) {
                fileDrawable = URLDrawable.getDrawable(data.getData().getGameIcon(), obtain);
                Intrinsics.checkNotNullExpressionValue(fileDrawable, "{\n                URLDra\u2026n, options)\n            }");
            } else {
                fileDrawable = URLDrawable.getFileDrawable(data.getData().getGameIcon(), obtain);
                Intrinsics.checkNotNullExpressionValue(fileDrawable, "{\n                URLDra\u2026n, options)\n            }");
            }
            holder.getCoverView().setImageDrawable(fileDrawable);
        } catch (Exception e16) {
            QLog.e("MiniGameVADownloadedFragment", 1, e16, new Object[0]);
        }
    }

    private final void bindOccupiedSpace(MiniGameDownloadedHolder holder, MiniGameDownloadDataWrapper data) {
        showOccupySpaceSize(holder.getOccupySpaceTxv(), data.getData().getSize());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1(MiniGameDownloadedAdapter this$0, MiniGameDownloadDataWrapper data, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        DownloadedItemClickListener downloadedItemClickListener = this$0.itemClickListener;
        if (downloadedItemClickListener != null) {
            downloadedItemClickListener.onItemDeleteClick(data);
        }
    }

    private final void showOccupySpaceSize(TextView txv, long occupiedSize) {
        txv.setText(MiniGameDownloadUtil.INSTANCE.getShowStr(occupiedSize));
    }

    public final void deleteData(String gameId) {
        Intrinsics.checkNotNullParameter(gameId, "gameId");
        Iterator<MiniGameDownloadDataWrapper> it = this.dataList.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().getData().getGameId(), gameId)) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 >= 0) {
            this.dataList.remove(i3);
            notifyItemRemoved(i3);
        }
    }

    public final Context getContext() {
        return this.context;
    }

    public final List<MiniGameDownloadDataWrapper> getDataList() {
        return this.dataList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.dataList.size();
    }

    public final void insert(MiniGameDownloadDataWrapper data, Integer index) {
        Intrinsics.checkNotNullParameter(data, "data");
        int size = this.dataList.size();
        if (index != null) {
            this.dataList.add(index.intValue(), data);
            notifyItemInserted(index.intValue());
        } else {
            this.dataList.add(data);
            notifyItemInserted(size);
        }
    }

    public final void setDataList(List<MiniGameDownloadDataWrapper> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.dataList = list;
    }

    public final void setOnItemClickListener(DownloadedItemClickListener itemClickListener) {
        Intrinsics.checkNotNullParameter(itemClickListener, "itemClickListener");
        this.itemClickListener = itemClickListener;
    }

    public final void updateList(List<MiniGameDownloadDataWrapper> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        this.dataList.clear();
        this.dataList.addAll(dataList);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MiniGameDownloadedHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (position >= this.dataList.size()) {
            return;
        }
        final MiniGameDownloadDataWrapper miniGameDownloadDataWrapper = this.dataList.get(position);
        bindCover(holder, miniGameDownloadDataWrapper);
        bindController(holder, miniGameDownloadDataWrapper);
        bindOccupiedSpace(holder, miniGameDownloadDataWrapper);
        holder.getTitleView().setText(miniGameDownloadDataWrapper.getData().getGameName());
        holder.getDeleteView().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.minigame.va.downloadui.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniGameDownloadedAdapter.onBindViewHolder$lambda$1(MiniGameDownloadedAdapter.this, miniGameDownloadDataWrapper, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MiniGameDownloadedHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.f167484dk3, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new MiniGameDownloadedHolder(view);
    }

    public static /* synthetic */ void insert$default(MiniGameDownloadedAdapter miniGameDownloadedAdapter, MiniGameDownloadDataWrapper miniGameDownloadDataWrapper, Integer num, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            num = null;
        }
        miniGameDownloadedAdapter.insert(miniGameDownloadDataWrapper, num);
    }
}
