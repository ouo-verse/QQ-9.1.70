package com.tencent.mobileqq.zootopia.download.ui.downloading;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.falco.utils.UIUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.z1.download.diffpatch.ZPlanMapDiffPatchInfo;
import com.tencent.mobileqq.zootopia.space.j;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.mapstatus.MapStatus;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\n\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002$%B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0003J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0017H\u0016J&\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00172\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001cH\u0016R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/ui/downloading/e;", "Lcom/tencent/mobileqq/zootopia/download/ui/a;", "Lcom/tencent/mobileqq/zootopia/download/ui/downloading/e$b;", "holder", "Lcom/tencent/mobileqq/zootopia/download/ui/d;", "data", "", "u0", "w0", "s0", "t0", "E0", "v0", "", "", "", "y0", "x0", "Lcom/tencent/mobileqq/zootopia/download/ui/downloading/b;", "itemClickListener", "F0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "D0", "position", "z0", "", "payloads", "A0", "E", "Lcom/tencent/mobileqq/zootopia/download/ui/downloading/b;", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class e extends com.tencent.mobileqq.zootopia.download.ui.a<b> {

    /* renamed from: E, reason: from kotlin metadata */
    private com.tencent.mobileqq.zootopia.download.ui.downloading.b itemClickListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010'\u001a\u00020&\u00a2\u0006\u0004\b(\u0010)R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\fR\u0017\u0010\u0019\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\fR\u0017\u0010\u001f\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\"\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\u001eR\u0017\u0010%\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/ui/downloading/e$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "l", "()Landroid/widget/ImageView;", "iconTypeView", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/TextView;", "typeTextView", "Landroid/widget/ProgressBar;", "G", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "progressBar", "H", "getProgressDescription", "progressDescription", "I", "getTitleView", "titleView", "Landroid/widget/Button;", "J", "Landroid/widget/Button;", "getControllerView", "()Landroid/widget/Button;", "controllerView", "K", "getCancelView", "cancelView", "L", "getCoverView", "coverView", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final ImageView iconTypeView;

        /* renamed from: F, reason: from kotlin metadata */
        private final TextView typeTextView;

        /* renamed from: G, reason: from kotlin metadata */
        private final ProgressBar progressBar;

        /* renamed from: H, reason: from kotlin metadata */
        private final TextView progressDescription;

        /* renamed from: I, reason: from kotlin metadata */
        private final TextView titleView;

        /* renamed from: J, reason: from kotlin metadata */
        private final Button controllerView;

        /* renamed from: K, reason: from kotlin metadata */
        private final Button cancelView;

        /* renamed from: L, reason: from kotlin metadata */
        private final ImageView coverView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            com.tencent.mobileqq.zootopia.download.ui.a.INSTANCE.a(itemView);
            View findViewById = itemView.findViewById(R.id.f163420q13);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.icon_type)");
            this.iconTypeView = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.quy);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.type)");
            this.typeTextView = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.qeb);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.progressbar)");
            this.progressBar = (ProgressBar) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.qe7);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.progress_des)");
            this.progressDescription = (TextView) findViewById4;
            View findViewById5 = itemView.findViewById(R.id.qr6);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.title)");
            this.titleView = (TextView) findViewById5;
            View findViewById6 = itemView.findViewById(R.id.pmm);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.controller)");
            this.controllerView = (Button) findViewById6;
            View findViewById7 = itemView.findViewById(R.id.f163325pi4);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.id.cancel)");
            this.cancelView = (Button) findViewById7;
            View findViewById8 = itemView.findViewById(R.id.pms);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "itemView.findViewById(R.id.cover)");
            this.coverView = (ImageView) findViewById8;
        }

        public final Button getCancelView() {
            return this.cancelView;
        }

        public final Button getControllerView() {
            return this.controllerView;
        }

        public final ImageView getCoverView() {
            return this.coverView;
        }

        public final ProgressBar getProgressBar() {
            return this.progressBar;
        }

        public final TextView getProgressDescription() {
            return this.progressDescription;
        }

        public final TextView getTitleView() {
            return this.titleView;
        }

        /* renamed from: l, reason: from getter */
        public final ImageView getIconTypeView() {
            return this.iconTypeView;
        }

        /* renamed from: m, reason: from getter */
        public final TextView getTypeTextView() {
            return this.typeTextView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(e this$0, b holder, com.tencent.mobileqq.zootopia.download.ui.d data, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.getReportHelper().c("clck", holder.getControllerView(), this$0.x0(data));
        if (data.getCom.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy.KEY_DOWNLOAD_STATUS java.lang.String() != 4 && data.getCom.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy.KEY_DOWNLOAD_STATUS java.lang.String() != 6 && data.getCom.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy.KEY_DOWNLOAD_STATUS java.lang.String() != 8) {
            com.tencent.mobileqq.zootopia.download.ui.downloading.b bVar = this$0.itemClickListener;
            if (bVar != null) {
                bVar.c(data);
                return;
            }
            return;
        }
        com.tencent.mobileqq.zootopia.download.ui.downloading.b bVar2 = this$0.itemClickListener;
        if (bVar2 != null) {
            bVar2.a(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(e this$0, b holder, com.tencent.mobileqq.zootopia.download.ui.d data, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.getReportHelper().c("clck", holder.getCancelView(), this$0.y0(data));
        com.tencent.mobileqq.zootopia.download.ui.downloading.b bVar = this$0.itemClickListener;
        if (bVar != null) {
            bVar.b(data);
        }
    }

    private final void E0(b holder) {
        holder.getProgressBar().setMax(100);
        holder.getProgressBar().setProgress(100);
        holder.getProgressDescription().setText("\u89e3\u538b\u4e2d");
    }

    private final void s0(b holder, com.tencent.mobileqq.zootopia.download.ui.d data) {
        if (TextUtils.isEmpty(data.getData().getSummaryData().getCover())) {
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = UIUtil.dp2px(holder.getCoverView().getContext(), 75.0f);
        obtain.mRequestHeight = UIUtil.dp2px(holder.getCoverView().getContext(), 96.0f);
        holder.getCoverView().setImageDrawable(URLDrawable.getDrawable(data.getData().getSummaryData().getCover(), obtain));
    }

    private final void t0(b holder, com.tencent.mobileqq.zootopia.download.ui.d data) {
        String str;
        pv4.e diffPatchInfo;
        holder.getProgressBar().setMax(100);
        holder.getProgressBar().setProgress((int) (100 * data.getProgress()));
        long size = data.getData().getResData().getSize();
        ZPlanMapDiffPatchInfo diffPatchInfo2 = data.getData().getResData().getDiffPatchInfo();
        long j3 = (diffPatchInfo2 == null || (diffPatchInfo = diffPatchInfo2.diffPatchInfo()) == null) ? 0L : diffPatchInfo.f427590b;
        if (j3 > 0 && ZPlanMapDiffPatchInfo.INSTANCE.a()) {
            size = j3;
        }
        long progress = ((float) size) * data.getProgress();
        TextView progressDescription = holder.getProgressDescription();
        j jVar = j.f329276a;
        String e16 = jVar.e(progress);
        String e17 = jVar.e(size);
        Integer realTimeSpeed = data.getRealTimeSpeed();
        if ((realTimeSpeed != null ? realTimeSpeed.intValue() : 0) > 0) {
            str = "(" + t74.a.b(data.getRealTimeSpeed() != null ? r9.intValue() : 0L, true) + "/s)";
        } else {
            str = "";
        }
        progressDescription.setText(e16 + "/" + e17 + str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
    
        if (r0 != 8) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void v0(b holder, com.tencent.mobileqq.zootopia.download.ui.d data) {
        int i3;
        String str;
        int i16 = data.getCom.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy.KEY_DOWNLOAD_STATUS java.lang.String();
        String str2 = "#878B99";
        if (i16 == 1) {
            holder.getProgressDescription().setText("\u7b49\u5f85\u4e2d");
        } else {
            if (i16 != 2) {
                if (i16 != 4) {
                    if (i16 == 6) {
                        if (data.getData().getResData().getCompleteTime() == 0) {
                            if (data.getStatus() == MapStatus.MAP_STATUS_DEPRESS_FAILED) {
                                str = "\u89e3\u538b\u5931\u8d25";
                            } else {
                                str = "\u4e0b\u8f7d\u5931\u8d25";
                            }
                        } else {
                            str = "\u66f4\u65b0\u5931\u8d25";
                        }
                        holder.getProgressDescription().setText(str);
                        str2 = "#FF596A";
                        i3 = R.drawable.icc;
                        holder.getProgressDescription().setTextColor(Color.parseColor(str2));
                        holder.getControllerView().setBackgroundResource(i3);
                    }
                }
                holder.getProgressDescription().setText("\u5df2\u6682\u505c");
                i3 = R.drawable.icd;
                holder.getProgressDescription().setTextColor(Color.parseColor(str2));
                holder.getControllerView().setBackgroundResource(i3);
            }
            t0(holder, data);
        }
        i3 = R.drawable.icb;
        holder.getProgressDescription().setTextColor(Color.parseColor(str2));
        holder.getControllerView().setBackgroundResource(i3);
    }

    private final void w0(b holder, com.tencent.mobileqq.zootopia.download.ui.d data) {
        holder.getTypeTextView().setText(data.getData().getSummaryData().getTypeName());
        if (TextUtils.isEmpty(data.getData().getSummaryData().getTypeIcon())) {
            return;
        }
        holder.getIconTypeView().setImageDrawable(URLDrawable.getDrawable(data.getData().getSummaryData().getTypeIcon(), (URLDrawable.URLDrawableOptions) null));
    }

    private final Map<String, Object> x0(com.tencent.mobileqq.zootopia.download.ui.d data) {
        int i3;
        Map<String, Object> y06 = y0(data);
        int i16 = data.getCom.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy.KEY_DOWNLOAD_STATUS java.lang.String();
        if (i16 != 4) {
            if (i16 == 6) {
                i3 = 2;
            } else if (i16 != 8) {
                i3 = 1;
            }
            y06.put("zplan_map_download_btnstatus", Integer.valueOf(i3));
            return y06;
        }
        i3 = 0;
        y06.put("zplan_map_download_btnstatus", Integer.valueOf(i3));
        return y06;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: A0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b holder, int position, List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (payloads.isEmpty()) {
            onBindViewHolder(holder, position);
            return;
        }
        Object obj = payloads.get(0);
        DownloadingPayloadData downloadingPayloadData = obj instanceof DownloadingPayloadData ? (DownloadingPayloadData) obj : null;
        if (downloadingPayloadData != null && position < getDataList().size()) {
            com.tencent.mobileqq.zootopia.download.ui.d dVar = getDataList().get(position);
            if (downloadingPayloadData.getProgress() != null && !Intrinsics.areEqual(downloadingPayloadData.getProgress(), 1.0f)) {
                t0(holder, dVar);
            }
            if (downloadingPayloadData.getDownloadStatus() != null) {
                v0(holder, dVar);
            }
            Integer downloadStatus = downloadingPayloadData.getDownloadStatus();
            if (downloadStatus != null && downloadStatus.intValue() == 3 && Intrinsics.areEqual(downloadingPayloadData.getProgress(), 1.0f)) {
                E0(holder);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: D0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.d7x, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new b(view);
    }

    public final void F0(com.tencent.mobileqq.zootopia.download.ui.downloading.b itemClickListener) {
        Intrinsics.checkNotNullParameter(itemClickListener, "itemClickListener");
        this.itemClickListener = itemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: z0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(final b holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (position >= getDataList().size()) {
            return;
        }
        final com.tencent.mobileqq.zootopia.download.ui.d dVar = getDataList().get(position);
        s0(holder, dVar);
        t0(holder, dVar);
        v0(holder, dVar);
        w0(holder, dVar);
        holder.getTitleView().setText(dVar.getData().getSummaryData().getTitle());
        holder.getControllerView().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.download.ui.downloading.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.B0(e.this, holder, dVar, view);
            }
        });
        holder.getCancelView().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.download.ui.downloading.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.C0(e.this, holder, dVar, view);
            }
        });
        u0(holder, dVar);
    }

    private final Map<String, Object> y0(com.tencent.mobileqq.zootopia.download.ui.d data) {
        Map<String, Object> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("zplan_map_id", Integer.valueOf(data.getData().getResData().getId())), new Pair("zplan_module_id", "em_zplan_playground_download_downloading_map"));
        return mutableMapOf;
    }

    private final void u0(b holder, com.tencent.mobileqq.zootopia.download.ui.d data) {
        id3.d reportHelper = getReportHelper();
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        id3.d.h(reportHelper, view, "em_zplan_playground_download_downloading_map", y0(data), false, false, null, 56, null);
        id3.d.i(getReportHelper(), holder.getControllerView(), "em_zplan_playground_download_downloading_map_status", x0(data), false, false, null, false, false, 240, null);
        id3.d.i(getReportHelper(), holder.getCancelView(), "em_zplan_playground_download_downloading_map_cancel", y0(data), false, false, null, false, false, 240, null);
    }
}
