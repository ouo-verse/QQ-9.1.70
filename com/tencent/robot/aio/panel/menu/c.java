package com.tencent.robot.aio.panel.menu;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pic.api.IPicAIOApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatureInfo;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatureType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 12\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003234B\u0007\u00a2\u0006\u0004\b/\u00100J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\u0010\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eH\u0007J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\tH\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J&\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R&\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u001fj\b\u0012\u0004\u0012\u00020\u0004` 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R*\u0010.\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-\u00a8\u00065"}, d2 = {"Lcom/tencent/robot/aio/panel/menu/c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/robot/aio/panel/menu/c$c;", "holder", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotFeatureInfo;", "data", "", "k0", "v0", "", "position", "n0", "", "x0", "", "list", "t0", "Lcom/tencent/robot/aio/panel/menu/c$b;", "listener", "u0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "q0", "getItemCount", "o0", "", "", "payloads", "p0", "r0", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "mItemList", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/robot/aio/panel/menu/c$b;", "mMenuListener", "value", "D", "I", "m0", "()I", "s0", "(I)V", "loadingPosition", "<init>", "()V", "E", "a", "b", "c", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c extends RecyclerView.Adapter<C9765c> {

    @NotNull
    private static final Object F = new Object();

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private b mMenuListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<CommonBotFeatureInfo> mItemList = new ArrayList<>();

    /* renamed from: D, reason: from kotlin metadata */
    private int loadingPosition = -1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/robot/aio/panel/menu/c$b;", "", "", "position", "Lcom/tencent/qqnt/kernel/nativeinterface/CommonBotFeatureInfo;", "data", "", "d", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public interface b {
        void d(int position, @NotNull CommonBotFeatureInfo data);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\r\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/robot/aio/panel/menu/c$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "iconRes", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "icon", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "l", "()Landroid/widget/TextView;", "title", "G", "getArrow", "arrow", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.aio.panel.menu.c$c, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C9765c extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final ImageView icon;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final TextView title;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final ImageView arrow;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C9765c(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.eq5);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.menu_icon)");
            this.icon = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.z4p);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.menu_text)");
            this.title = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.z3i);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.menu_arrow)");
            this.arrow = (ImageView) findViewById3;
        }

        private final void m(@DrawableRes int iconRes) {
            if (iconRes != 0) {
                this.arrow.setImageDrawable(BaseImageUtil.maskDrawableByColor(ResourcesCompat.getDrawable(this.itemView.getResources(), iconRes, null), this.itemView.getContext().getColor(R.color.qui_common_icon_tertiary)));
                this.arrow.setVisibility(0);
            } else {
                this.arrow.setImageDrawable(null);
                this.arrow.setVisibility(8);
            }
        }

        @NotNull
        public final ImageView getIcon() {
            return this.icon;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final TextView getTitle() {
            return this.title;
        }

        public final void o() {
            m(R.drawable.qui_chevron_right);
        }

        public final void p() {
            m(R.drawable.guild_black_loading_anim);
        }

        public final void q() {
            this.arrow.setImageDrawable(null);
            this.arrow.setVisibility(8);
        }
    }

    private final void k0(C9765c holder, CommonBotFeatureInfo data) {
        boolean z16;
        holder.getTitle().setText(data.name);
        final String str = data.icon;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            holder.getIcon().setVisibility(0);
            IPicAIOApi iPicAIOApi = (IPicAIOApi) QRoute.api(IPicAIOApi.class);
            Option requestWidth = Option.obtain().setUrl(str).setTargetView(holder.getIcon()).setRequestHeight(ViewUtils.dpToPx(22.0f)).setRequestWidth(ViewUtils.dpToPx(22.0f));
            Intrinsics.checkNotNullExpressionValue(requestWidth, "obtain().setUrl(iconUrl)\u2026dpToPx(ICON_REQ_SIZE_DP))");
            iPicAIOApi.loadPic(requestWidth, new IPicLoadStateListener() { // from class: com.tencent.robot.aio.panel.menu.b
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(LoadState loadState, Option option) {
                    c.l0(str, loadState, option);
                }
            });
            return;
        }
        holder.getIcon().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(String str, LoadState loadState, Option option) {
        if (loadState.isFinishError()) {
            QLog.e("RobotMenuAdapter", 1, "[onStateChange]: load pic " + str + " failed");
        }
    }

    private final void n0(int position, C9765c holder, CommonBotFeatureInfo data) {
        boolean z16;
        View view = holder.itemView;
        int i3 = this.loadingPosition;
        if (position != i3 && i3 != -1) {
            z16 = false;
        } else {
            z16 = true;
        }
        view.setEnabled(z16);
        if (position == this.loadingPosition) {
            holder.p();
        } else if (x0(data)) {
            holder.o();
        } else {
            holder.q();
        }
    }

    private final void v0(final C9765c holder, final CommonBotFeatureInfo data) {
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.aio.panel.menu.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.w0(c.this, holder, data, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(c this$0, C9765c holder, CommonBotFeatureInfo data, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(data, "$data");
        b bVar = this$0.mMenuListener;
        if (bVar != null) {
            bVar.d(holder.getAdapterPosition(), data);
        }
        HashMap hashMap = new HashMap();
        String str = data.name;
        Intrinsics.checkNotNullExpressionValue(str, "data.name");
        hashMap.put(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, str);
        VideoReport.reportEvent("dt_clck", holder.itemView, hashMap);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean x0(CommonBotFeatureInfo data) {
        if (data.type != CommonBotFeatureType.H5.ordinal() && data.type != CommonBotFeatureType.MINIAPP.ordinal()) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mItemList.size();
    }

    /* renamed from: m0, reason: from getter */
    public final int getLoadingPosition() {
        return this.loadingPosition;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull C9765c holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        CommonBotFeatureInfo commonBotFeatureInfo = this.mItemList.get(position);
        Intrinsics.checkNotNullExpressionValue(commonBotFeatureInfo, "mItemList[position]");
        CommonBotFeatureInfo commonBotFeatureInfo2 = commonBotFeatureInfo;
        n0(position, holder, commonBotFeatureInfo2);
        k0(holder, commonBotFeatureInfo2);
        v0(holder, commonBotFeatureInfo2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull C9765c holder, int position, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (payloads.contains(F)) {
            CommonBotFeatureInfo commonBotFeatureInfo = this.mItemList.get(position);
            Intrinsics.checkNotNullExpressionValue(commonBotFeatureInfo, "mItemList[position]");
            n0(position, holder, commonBotFeatureInfo);
            return;
        }
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public C9765c onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.ho7, parent, false);
        VideoReport.setElementExposePolicy(itemView, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(itemView, ClickPolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(itemView, EndExposurePolicy.REPORT_NONE);
        VideoReport.setElementId(itemView, "em_bas_aio_shortcut_menu");
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new C9765c(itemView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(@NotNull C9765c holder) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        if (holder.getAdapterPosition() == -1) {
            return;
        }
        View view = holder.itemView;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, holder.getTitle().getText()));
        VideoReport.reportEvent("dt_imp", view, mapOf);
    }

    public final void s0(int i3) {
        this.loadingPosition = i3;
        notifyItemRangeChanged(0, getItemCount(), F);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void t0(@NotNull List<CommonBotFeatureInfo> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.mItemList.clear();
        this.mItemList.addAll(list);
        notifyDataSetChanged();
    }

    public final void u0(@NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mMenuListener = listener;
    }
}
