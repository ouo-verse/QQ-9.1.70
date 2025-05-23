package com.tencent.mobileqq.minigame.va.downloadui;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.minigame.va.MiniGameDownloadConstant;
import com.tencent.mobileqq.minigame.va.MiniGameDownloadDataWrapper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0006H\u0002J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0006H\u0003J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0006H\u0002J\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u001f\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00062\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0002\u0010\u001cJ\u0018\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0019H\u0016J\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0019H\u0016J\u000e\u0010#\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0006J\u0014\u0010&\u001a\u00020\u00102\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060'R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/minigame/va/downloadui/MiniGameDownloadingAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/minigame/va/downloadui/MiniGameDownloadingHolder;", "()V", "dataList", "", "Lcom/tencent/mobileqq/minigame/va/MiniGameDownloadDataWrapper;", "getDataList", "()Ljava/util/List;", "setDataList", "(Ljava/util/List;)V", "isInitData", "", "itemClickListener", "Lcom/tencent/mobileqq/minigame/va/downloadui/DownloadingItemClickListener;", "bindCover", "", "holder", "data", "bindProgress", "bindStatus", "deleteData", VirtualAppProxy.KEY_GAME_ID, "", "getItemCount", "", "insert", "index", "(Lcom/tencent/mobileqq/minigame/va/MiniGameDownloadDataWrapper;Ljava/lang/Integer;)V", "onBindViewHolder", "position", "onCreateViewHolder", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "viewType", "setItemClickListener", "updateData", "payload", "updateList", "", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameDownloadingAdapter extends RecyclerView.Adapter<MiniGameDownloadingHolder> {
    private List<MiniGameDownloadDataWrapper> dataList = new ArrayList();
    private boolean isInitData = true;
    private DownloadingItemClickListener itemClickListener;

    private final void bindCover(MiniGameDownloadingHolder holder, MiniGameDownloadDataWrapper data) {
        boolean startsWith$default;
        URLDrawable fileDrawable;
        if (TextUtils.isEmpty(data.getData().getGameIcon())) {
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = ViewUtils.dpToPx(68.0f);
        obtain.mRequestHeight = ViewUtils.dpToPx(68.0f);
        URLDrawable uRLDrawable = null;
        try {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(data.getData().getGameIcon(), "http", false, 2, null);
            if (startsWith$default) {
                fileDrawable = URLDrawable.getDrawable(data.getData().getGameIcon(), obtain);
            } else {
                fileDrawable = URLDrawable.getFileDrawable(data.getData().getGameIcon(), obtain);
            }
            uRLDrawable = fileDrawable;
        } catch (Exception e16) {
            QLog.e("MiniGameVADownloadingFragment", 1, "bindCover Exception", e16);
        }
        if (uRLDrawable == null) {
            return;
        }
        holder.getCoverView().setImageDrawable(uRLDrawable);
    }

    private final void bindProgress(MiniGameDownloadingHolder holder, MiniGameDownloadDataWrapper data) {
        holder.getProgressBar().setMax(100);
        holder.getProgressBar().setProgress(data.getProgress());
        holder.getProgressDescription().setText(data.getProgress() + "%");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001c, code lost:
    
        if (r0 != 7) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void bindStatus(MiniGameDownloadingHolder holder, MiniGameDownloadDataWrapper data) {
        int downloadStatus = data.getDownloadStatus();
        int i3 = R.drawable.f159955iq4;
        String str = "#878B99";
        if (downloadStatus != 0) {
            if (downloadStatus == 1) {
                holder.getProgressDescription().setText("\u7b49\u5f85\u4e2d");
            } else if (downloadStatus == 2) {
                bindProgress(holder, data);
                i3 = R.drawable.f159953iq2;
            } else if (downloadStatus != 4) {
                if (downloadStatus == 5) {
                    bindProgress(holder, data);
                } else if (downloadStatus == 6) {
                    holder.getProgressDescription().setText("\u4e0b\u8f7d\u5931\u8d25");
                    str = "#FF596A";
                    i3 = R.drawable.f159954iq3;
                }
            }
            holder.getProgressDescription().setTextColor(Color.parseColor(str));
            holder.getControllerView().setBackgroundResource(i3);
        }
        holder.getProgressDescription().setText("\u5df2\u6682\u505c");
        holder.getProgressDescription().setTextColor(Color.parseColor(str));
        holder.getControllerView().setBackgroundResource(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$4(MiniGameDownloadDataWrapper data, MiniGameDownloadingAdapter this$0, View view) {
        Map mapOf;
        Map mapOf2;
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (MiniGameDownloadConstant.isNeedDownloadAndInstall(data)) {
            DownloadingItemClickListener downloadingItemClickListener = this$0.itemClickListener;
            if (downloadingItemClickListener != null) {
                downloadingItemClickListener.onItemStartDownloadClick(data);
            }
            Pair[] pairArr = new Pair[2];
            String versionCode = data.getData().getVersionCode();
            pairArr[0] = TuplesKt.to("ext6", versionCode != null ? versionCode : "");
            pairArr[1] = TuplesKt.to("ext8", "0");
            mapOf2 = MapsKt__MapsKt.mapOf(pairArr);
            MiniAppUtils.reportMiniGameCenterDC00087("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9080", "908015", "929237", "20", data.getData().getGameId(), mapOf2);
            return;
        }
        DownloadingItemClickListener downloadingItemClickListener2 = this$0.itemClickListener;
        if (downloadingItemClickListener2 != null) {
            downloadingItemClickListener2.onItemPauseDownloadClick(data);
        }
        Pair[] pairArr2 = new Pair[2];
        String versionCode2 = data.getData().getVersionCode();
        pairArr2[0] = TuplesKt.to("ext6", versionCode2 != null ? versionCode2 : "");
        pairArr2[1] = TuplesKt.to("ext8", "1");
        mapOf = MapsKt__MapsKt.mapOf(pairArr2);
        MiniAppUtils.reportMiniGameCenterDC00087("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9080", "908015", "929237", "20", data.getData().getGameId(), mapOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$5(MiniGameDownloadingAdapter this$0, MiniGameDownloadDataWrapper data, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        DownloadingItemClickListener downloadingItemClickListener = this$0.itemClickListener;
        if (downloadingItemClickListener != null) {
            downloadingItemClickListener.onItemCancelDownloadClick(data);
        }
        MiniAppUtils.reportMiniGameCenterDC00087("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9080", "908015", "929238", "20", data.getData().getGameId(), null);
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

    protected final List<MiniGameDownloadDataWrapper> getDataList() {
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

    protected final void setDataList(List<MiniGameDownloadDataWrapper> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.dataList = list;
    }

    public final void setItemClickListener(DownloadingItemClickListener itemClickListener) {
        Intrinsics.checkNotNullParameter(itemClickListener, "itemClickListener");
        this.itemClickListener = itemClickListener;
    }

    public final void updateData(MiniGameDownloadDataWrapper payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        Iterator<MiniGameDownloadDataWrapper> it = this.dataList.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().getData().getGameId(), payload.getData().getGameId())) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 >= 0) {
            MiniGameDownloadDataWrapper miniGameDownloadDataWrapper = this.dataList.get(i3);
            miniGameDownloadDataWrapper.setProgress(payload.getProgress());
            miniGameDownloadDataWrapper.setDownloadStatus(payload.getDownloadStatus());
            notifyItemChanged(i3, payload);
        }
    }

    public final void updateList(List<MiniGameDownloadDataWrapper> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        this.dataList.clear();
        this.dataList.addAll(dataList);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MiniGameDownloadingHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (position >= this.dataList.size()) {
            return;
        }
        final MiniGameDownloadDataWrapper miniGameDownloadDataWrapper = this.dataList.get(position);
        bindCover(holder, miniGameDownloadDataWrapper);
        bindProgress(holder, miniGameDownloadDataWrapper);
        bindStatus(holder, miniGameDownloadDataWrapper);
        holder.getTitleView().setText(miniGameDownloadDataWrapper.getData().getGameName());
        holder.getControllerView().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.minigame.va.downloadui.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniGameDownloadingAdapter.onBindViewHolder$lambda$4(MiniGameDownloadDataWrapper.this, this, view);
            }
        });
        holder.getCancelView().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.minigame.va.downloadui.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniGameDownloadingAdapter.onBindViewHolder$lambda$5(MiniGameDownloadingAdapter.this, miniGameDownloadDataWrapper, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MiniGameDownloadingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.f167485dk4, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new MiniGameDownloadingHolder(view);
    }

    public static /* synthetic */ void insert$default(MiniGameDownloadingAdapter miniGameDownloadingAdapter, MiniGameDownloadDataWrapper miniGameDownloadDataWrapper, Integer num, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            num = null;
        }
        miniGameDownloadingAdapter.insert(miniGameDownloadDataWrapper, num);
    }
}
