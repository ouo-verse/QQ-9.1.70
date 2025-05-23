package com.tencent.mobileqq.troop.troopsquare;

import NearbyGroup.Color;
import NearbyGroup.GroupLabel;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.adapter.RecommendTroopAdapter;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.troopjoin.api.ITroopJoinApi;
import com.tencent.mobileqq.troop.troopsquare.TroopSquareRecommendAdapter;
import com.tencent.mobileqq.troop.troopsquare.common.c;
import com.tencent.mobileqq.troop.utils.aq;
import com.tencent.mobileqq.troop.utils.h;
import com.tencent.mobileqq.troop.utils.j;
import com.tencent.mobileqq.troop.widget.TroopActiveLayout;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.TriggerRunnerKt;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.nativeinterface.GroupSquareColor;
import com.tencent.qqnt.kernel.nativeinterface.GroupSquareGroupInfoItem;
import com.tencent.qqnt.kernel.nativeinterface.GroupSquareLabel;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001<B7\u0012\u0006\u0010#\u001a\u00020\u001d\u0012\u0006\u0010(\u001a\u00020\n\u0012\u0014\b\u0002\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020*0)\u0012\b\b\u0002\u00104\u001a\u00020\u0019\u00a2\u0006\u0004\b:\u0010;J\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u001c\u0010\f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u001c\u0010\u0010\u001a\u00020\u00062\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\nH\u0016J$\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00192\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0003J\u0010\u0010\u001c\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u0019J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\nH\u0016R\u0017\u0010#\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010(\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R#\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020*0)8\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0017\u00104\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\"\u00109\u001a\u0010\u0012\f\u0012\n 6*\u0004\u0018\u00010\u00040\u0004058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/TroopSquareRecommendAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/troop/troopsquare/TroopSquareRecommendAdapter$ViewHolder;", "", "Lcom/tencent/mobileqq/troop/troopsquare/data/a;", "data", "", "p0", "Landroid/view/ViewGroup;", "viewGroup", "", "viewType", "o0", "getItemCount", "viewHolder", "position", "n0", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSquareGroupInfoItem;", "troop", "Ljava/util/ArrayList;", "LNearbyGroup/GroupLabel;", "Lkotlin/collections/ArrayList;", "q0", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSquareLabel;", "labels", "", "l0", "troopUin", "r0", "", "getItemId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "J", "getGroupCode", "()J", "groupCode", BdhLogUtil.LogTag.Tag_Conn, "I", "m0", "()I", "joinTroopSubSource", "", "", "D", "Ljava/util/Map;", "k0", "()Ljava/util/Map;", "exReportMap", "E", "Ljava/lang/String;", "j0", "()Ljava/lang/String;", "elementId", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", UserInfo.SEX_FEMALE, "Landroidx/recyclerview/widget/AsyncListDiffer;", "differ", "<init>", "(JILjava/util/Map;Ljava/lang/String;)V", "ViewHolder", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSquareRecommendAdapter extends RecyclerView.Adapter<ViewHolder> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private final int joinTroopSubSource;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Map<String, Object> exReportMap;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final String elementId;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final AsyncListDiffer<com.tencent.mobileqq.troop.troopsquare.data.a> differ;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final long groupCode;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u00a2\u0006\u0004\b]\u0010^J@\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0016\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bJ\u001f\u0010\u000f\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0011\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010'\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010/\u001a\u00020(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00107\u001a\u0002008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010?\u001a\u0002088\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010G\u001a\u00020@8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010K\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010\"\u001a\u0004\bI\u0010$\"\u0004\bJ\u0010&R\"\u0010O\u001a\u0002008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bL\u00102\u001a\u0004\bM\u00104\"\u0004\bN\u00106R$\u0010V\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\\u00a8\u0006_"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/TroopSquareRecommendAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "position", "", "", "recommendParams", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", HippyTKDListViewAdapter.X, "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSquareGroupInfoItem;", "troopItem", "", "B", "y", "(Ljava/lang/Integer;Lcom/tencent/qqnt/kernel/nativeinterface/GroupSquareGroupInfoItem;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/view/View;", "E", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "itemView", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "u", "()Landroid/widget/ImageView;", "setIvHead", "(Landroid/widget/ImageView;)V", "ivHead", "Lcom/tencent/widget/SingleLineTextView;", "G", "Lcom/tencent/widget/SingleLineTextView;", "w", "()Lcom/tencent/widget/SingleLineTextView;", "setTvTitle", "(Lcom/tencent/widget/SingleLineTextView;)V", "tvTitle", "Landroid/widget/Button;", "H", "Landroid/widget/Button;", "r", "()Landroid/widget/Button;", "setBtnJoin", "(Landroid/widget/Button;)V", "btnJoin", "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", "v", "()Landroid/widget/TextView;", "setTvJoinState", "(Landroid/widget/TextView;)V", "tvJoinState", "Lcom/tencent/mobileqq/troop/widget/TroopActiveLayout;", "J", "Lcom/tencent/mobileqq/troop/widget/TroopActiveLayout;", "p", "()Lcom/tencent/mobileqq/troop/widget/TroopActiveLayout;", "setBarActive", "(Lcom/tencent/mobileqq/troop/widget/TroopActiveLayout;)V", "barActive", "Lcom/tencent/mobileqq/troop/widget/TroopLabelLayout;", "K", "Lcom/tencent/mobileqq/troop/widget/TroopLabelLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/mobileqq/troop/widget/TroopLabelLayout;", "setBarLabel", "(Lcom/tencent/mobileqq/troop/widget/TroopLabelLayout;)V", "barLabel", "L", ReportConstant.COSTREPORT_PREFIX, "setFtvDesc", "ftvDesc", "M", "t", "setGameLabel", "gameLabel", "N", "Ljava/lang/Integer;", "getPositionInList", "()Ljava/lang/Integer;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/Integer;)V", "positionInList", "P", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSquareGroupInfoItem;", "getTroopItem", "()Lcom/tencent/qqnt/kernel/nativeinterface/GroupSquareGroupInfoItem;", BdhLogUtil.LogTag.Tag_Conn, "(Lcom/tencent/qqnt/kernel/nativeinterface/GroupSquareGroupInfoItem;)V", "<init>", "(Lcom/tencent/mobileqq/troop/troopsquare/TroopSquareRecommendAdapter;Landroid/view/View;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final View itemView;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private ImageView ivHead;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private SingleLineTextView tvTitle;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private Button btnJoin;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private TextView tvJoinState;

        /* renamed from: J, reason: from kotlin metadata */
        @NotNull
        private TroopActiveLayout barActive;

        /* renamed from: K, reason: from kotlin metadata */
        @NotNull
        private TroopLabelLayout barLabel;

        /* renamed from: L, reason: from kotlin metadata */
        @NotNull
        private SingleLineTextView ftvDesc;

        /* renamed from: M, reason: from kotlin metadata */
        @NotNull
        private TextView gameLabel;

        /* renamed from: N, reason: from kotlin metadata */
        @Nullable
        private Integer positionInList;

        /* renamed from: P, reason: from kotlin metadata */
        @Nullable
        private GroupSquareGroupInfoItem troopItem;
        final /* synthetic */ TroopSquareRecommendAdapter Q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull final TroopSquareRecommendAdapter troopSquareRecommendAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.Q = troopSquareRecommendAdapter;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopSquareRecommendAdapter, (Object) itemView);
                return;
            }
            this.itemView = itemView;
            View findViewById = this.itemView.findViewById(R.id.lol);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.iv_troop_head)");
            this.ivHead = (ImageView) findViewById;
            View findViewById2 = this.itemView.findViewById(R.id.meg);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.tv_troop_name)");
            this.tvTitle = (SingleLineTextView) findViewById2;
            View findViewById3 = this.itemView.findViewById(R.id.lax);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.btn_join_troop)");
            this.btnJoin = (Button) findViewById3;
            View findViewById4 = this.itemView.findViewById(R.id.f95475f3);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.text_join_state)");
            this.tvJoinState = (TextView) findViewById4;
            View findViewById5 = this.itemView.findViewById(R.id.l_v);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.bar_active)");
            this.barActive = (TroopActiveLayout) findViewById5;
            View findViewById6 = this.itemView.findViewById(R.id.l_w);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.bar_label)");
            this.barLabel = (TroopLabelLayout) findViewById6;
            View findViewById7 = this.itemView.findViewById(R.id.f167042k73);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.id.tv_desc)");
            this.ftvDesc = (SingleLineTextView) findViewById7;
            View findViewById8 = this.itemView.findViewById(R.id.vjb);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "itemView.findViewById(R.id.game_label)");
            this.gameLabel = (TextView) findViewById8;
            View itemView2 = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
            TriggerRunnerKt.c(itemView2, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsquare.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TroopSquareRecommendAdapter.ViewHolder.n(TroopSquareRecommendAdapter.ViewHolder.this, troopSquareRecommendAdapter, view);
                }
            }, 1, null);
            TriggerRunnerKt.c(this.btnJoin, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsquare.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TroopSquareRecommendAdapter.ViewHolder.o(TroopSquareRecommendAdapter.ViewHolder.this, troopSquareRecommendAdapter, view);
                }
            }, 1, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(ViewHolder this$0, TroopSquareRecommendAdapter this$1, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            GroupSquareGroupInfoItem groupSquareGroupInfoItem = this$0.troopItem;
            if (groupSquareGroupInfoItem != null) {
                ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).openTroopInfoActivity(view.getContext(), aq.e(String.valueOf(groupSquareGroupInfoItem.groupCode), groupSquareGroupInfoItem.joinGroupAuth, this$1.m0(), ""), 2);
                GroupSquareGroupInfoItem groupSquareGroupInfoItem2 = this$0.troopItem;
                if (groupSquareGroupInfoItem2 != null) {
                    this$0.y(this$0.positionInList, groupSquareGroupInfoItem2);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void o(ViewHolder this$0, TroopSquareRecommendAdapter this$1, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            GroupSquareGroupInfoItem groupSquareGroupInfoItem = this$0.troopItem;
            if (groupSquareGroupInfoItem != null) {
                String valueOf = String.valueOf(groupSquareGroupInfoItem.groupCode);
                String str = groupSquareGroupInfoItem.joinGroupAuth;
                Intrinsics.checkNotNullExpressionValue(str, "data.joinGroupAuth");
                com.tencent.mobileqq.troop.troopjoin.a aVar = new com.tencent.mobileqq.troop.troopjoin.a(valueOf, str, this$1.m0(), false, null, true, 24, null);
                ITroopJoinApi iTroopJoinApi = (ITroopJoinApi) QRoute.api(ITroopJoinApi.class);
                Context context = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "it.context");
                iTroopJoinApi.tryLaunchJoinTroop(context, aVar, false, TroopSquareRecommendAdapter$ViewHolder$2$1.INSTANCE);
                GroupSquareGroupInfoItem groupSquareGroupInfoItem2 = this$0.troopItem;
                if (groupSquareGroupInfoItem2 != null) {
                    this$0.z(this$0.positionInList, groupSquareGroupInfoItem2);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        private final HashMap<String, Object> x(int position, Map<String, String> recommendParams) {
            HashMap<String, Object> hashMapOf;
            Pair[] pairArr = new Pair[4];
            pairArr[0] = TuplesKt.to("item_index", Integer.valueOf(position));
            pairArr[1] = TuplesKt.to("main_group_id", Long.valueOf(((com.tencent.mobileqq.troop.troopsquare.data.a) this.Q.differ.getCurrentList().get(position)).a()));
            String str = recommendParams.get("rrid");
            String str2 = "";
            if (str == null) {
                str = "";
            }
            pairArr[2] = TuplesKt.to("group_recall_id", str);
            String str3 = recommendParams.get("trace_id");
            if (str3 != null) {
                str2 = str3;
            }
            pairArr[3] = TuplesKt.to("group_recall_trace_id", str2);
            hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
            hashMapOf.putAll(this.Q.k0());
            return hashMapOf;
        }

        public final void A(@Nullable Integer num) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                iPatchRedirector.redirect((short) 20, (Object) this, (Object) num);
            } else {
                this.positionInList = num;
            }
        }

        public final void B(int position, @NotNull GroupSquareGroupInfoItem troopItem) {
            Activity activity;
            Window window;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                iPatchRedirector.redirect((short) 23, (Object) this, position, (Object) troopItem);
                return;
            }
            Intrinsics.checkNotNullParameter(troopItem, "troopItem");
            Map<String, String> a16 = j.a(troopItem.recomTrace);
            Intrinsics.checkNotNullExpressionValue(a16, "parseRecommendTrace(troopItem.recomTrace)");
            Context context = this.itemView.getContext();
            View view = null;
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            if (activity != null && (window = activity.getWindow()) != null) {
                view = window.getDecorView();
            }
            c cVar = c.f301578a;
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            String j06 = this.Q.j0();
            HashMap<String, Object> x16 = x(position, a16);
            ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
            View view2 = view;
            h.a.b(cVar, itemView, j06, x16, exposurePolicy, null, view2, 16, null);
            h.a.b(cVar, this.btnJoin, "em_group_join", x(position, a16), exposurePolicy, null, view2, 16, null);
            View itemView2 = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
            cVar.g(itemView2);
            cVar.g(this.btnJoin);
        }

        public final void C(@Nullable GroupSquareGroupInfoItem groupSquareGroupInfoItem) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                iPatchRedirector.redirect((short) 22, (Object) this, (Object) groupSquareGroupInfoItem);
            } else {
                this.troopItem = groupSquareGroupInfoItem;
            }
        }

        @NotNull
        public final TroopActiveLayout p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (TroopActiveLayout) iPatchRedirector.redirect((short) 11, (Object) this);
            }
            return this.barActive;
        }

        @NotNull
        public final TroopLabelLayout q() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (TroopLabelLayout) iPatchRedirector.redirect((short) 13, (Object) this);
            }
            return this.barLabel;
        }

        @NotNull
        public final Button r() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Button) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.btnJoin;
        }

        @NotNull
        public final SingleLineTextView s() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (SingleLineTextView) iPatchRedirector.redirect((short) 15, (Object) this);
            }
            return this.ftvDesc;
        }

        @NotNull
        public final TextView t() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (TextView) iPatchRedirector.redirect((short) 17, (Object) this);
            }
            return this.gameLabel;
        }

        @NotNull
        public final ImageView u() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ImageView) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.ivHead;
        }

        @NotNull
        public final TextView v() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (TextView) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return this.tvJoinState;
        }

        @NotNull
        public final SingleLineTextView w() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (SingleLineTextView) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.tvTitle;
        }

        public final void y(@Nullable Integer position, @NotNull GroupSquareGroupInfoItem troopItem) {
            Activity activity;
            Window window;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                iPatchRedirector.redirect((short) 24, (Object) this, (Object) position, (Object) troopItem);
                return;
            }
            Intrinsics.checkNotNullParameter(troopItem, "troopItem");
            Map<String, String> a16 = j.a(troopItem.recomTrace);
            Intrinsics.checkNotNullExpressionValue(a16, "parseRecommendTrace(troopItem.recomTrace)");
            Context context = this.itemView.getContext();
            View view = null;
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            if (activity != null && (window = activity.getWindow()) != null) {
                view = window.getDecorView();
            }
            View view2 = view;
            if (position != null) {
                position.intValue();
                c cVar = c.f301578a;
                View itemView = this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                h.a.b(cVar, itemView, this.Q.j0(), x(position.intValue(), a16), ExposurePolicy.REPORT_NONE, null, view2, 16, null);
                View itemView2 = this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
                h.a.f(cVar, itemView2, null, null, null, 14, null);
            }
        }

        public final void z(@Nullable Integer position, @NotNull GroupSquareGroupInfoItem troopItem) {
            Activity activity;
            Window window;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                iPatchRedirector.redirect((short) 25, (Object) this, (Object) position, (Object) troopItem);
                return;
            }
            Intrinsics.checkNotNullParameter(troopItem, "troopItem");
            Map<String, String> a16 = j.a(troopItem.recomTrace);
            Intrinsics.checkNotNullExpressionValue(a16, "parseRecommendTrace(troopItem.recomTrace)");
            Context context = this.itemView.getContext();
            View view = null;
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            if (activity != null && (window = activity.getWindow()) != null) {
                view = window.getDecorView();
            }
            View view2 = view;
            if (position != null) {
                position.intValue();
                c cVar = c.f301578a;
                h.a.b(cVar, this.btnJoin, "em_group_join", x(position.intValue(), a16), ExposurePolicy.REPORT_NONE, null, view2, 16, null);
                h.a.f(cVar, this.btnJoin, null, null, null, 14, null);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/troopsquare/TroopSquareRecommendAdapter$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/mobileqq/troop/troopsquare/data/a;", "p0", "p1", "", "b", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a extends DiffUtil.ItemCallback<com.tencent.mobileqq.troop.troopsquare.data.a> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull com.tencent.mobileqq.troop.troopsquare.data.a p06, @NotNull com.tencent.mobileqq.troop.troopsquare.data.a p16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) p06, (Object) p16)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(p06, "p0");
            Intrinsics.checkNotNullParameter(p16, "p1");
            return Intrinsics.areEqual(p06, p16);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull com.tencent.mobileqq.troop.troopsquare.data.a p06, @NotNull com.tencent.mobileqq.troop.troopsquare.data.a p16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) p06, (Object) p16)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(p06, "p0");
            Intrinsics.checkNotNullParameter(p16, "p1");
            if (p06.c().groupCode == p16.c().groupCode) {
                return true;
            }
            return false;
        }
    }

    public /* synthetic */ TroopSquareRecommendAdapter(long j3, int i3, Map map, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, i3, (i16 & 4) != 0 ? new HashMap() : map, (i16 & 8) != 0 ? "em_group_square" : str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Integer.valueOf(i3), map, str, Integer.valueOf(i16), defaultConstructorMarker);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.differ.getCurrentList().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, (Object) this, position)).longValue();
        }
        return position;
    }

    @NotNull
    public final String j0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.elementId;
    }

    @NotNull
    public final Map<String, Object> k0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Map) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.exReportMap;
    }

    @Nullable
    public final String l0(@NotNull List<GroupSquareLabel> labels) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this, (Object) labels);
        }
        Intrinsics.checkNotNullParameter(labels, "labels");
        for (GroupSquareLabel groupSquareLabel : labels) {
            if (groupSquareLabel.labelType == 300) {
                return groupSquareLabel.icon;
            }
        }
        return null;
    }

    public final int m0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.joinTroopSubSource;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) viewHolder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        com.tencent.mobileqq.troop.troopsquare.data.a aVar = this.differ.getCurrentList().get(position);
        GroupSquareGroupInfoItem c16 = aVar.c();
        viewHolder.B(position, c16);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.business.BaseQQAppInterface");
        BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
        viewHolder.C(c16);
        viewHolder.u().setImageDrawable(FaceDrawable.getFaceDrawable(baseQQAppInterface, 4, String.valueOf(c16.groupCode)));
        viewHolder.w().setText(c16.groupName);
        viewHolder.w().setContentDescription(c16.groupName);
        viewHolder.A(Integer.valueOf(position));
        viewHolder.p().setVisibility(8);
        viewHolder.q().setMaxLabelCount(4);
        viewHolder.w().setVisibility(0);
        ArrayList<GroupLabel> q06 = q0(c16);
        boolean z16 = true;
        if (q06 != null && q06.size() > 0) {
            viewHolder.q().setVisibility(0);
            viewHolder.q().setLabelType(1);
            viewHolder.q().setAutoCreateDistanceTextView(true);
            viewHolder.q().setIsInCompleteDrawOutSide(true);
            viewHolder.q().h(q06);
        } else {
            viewHolder.q().setVisibility(8);
        }
        if (!aVar.d() && !aVar.b()) {
            viewHolder.r().setVisibility(0);
            viewHolder.v().setVisibility(4);
            viewHolder.r().setEnabled(true);
            viewHolder.r().setTextColor(viewHolder.r().getResources().getColorStateList(R.color.qui_common_text_primary));
            viewHolder.r().setText(R.string.fvi);
            if (SimpleUIUtil.isNowElderMode()) {
                viewHolder.r().setMinWidth(ViewUtils.dip2px(44.0f));
                viewHolder.r().setMinHeight(ViewUtils.dip2px(44.0f));
                viewHolder.r().setTextSize(1, 18.0f);
            }
        } else {
            viewHolder.r().setVisibility(4);
            viewHolder.v().setVisibility(0);
            if (aVar.b()) {
                viewHolder.v().setText(R.string.fvj);
            } else {
                viewHolder.v().setText(R.string.fvk);
            }
        }
        if (TextUtils.isEmpty(c16.memo)) {
            viewHolder.s().setText("");
            if (com.tencent.mobileqq.troop.exp.a.f295373a.c()) {
                viewHolder.s().setVisibility(8);
            }
        } else {
            viewHolder.s().setVisibility(0);
            viewHolder.s().setText(new QQText(c16.memo, 11, 16));
        }
        if (com.tencent.mobileqq.troop.exp.a.f295373a.c()) {
            Iterator<GroupSquareLabel> it = c16.labels.iterator();
            while (true) {
                if (it.hasNext()) {
                    GroupSquareLabel next = it.next();
                    if (next.labelType == 300) {
                        viewHolder.t().setText(next.name);
                        ColorDrawable colorDrawable = new ColorDrawable(viewHolder.t().getContext().getColor(R.color.cac));
                        if (ThemeUtil.isNowThemeIsNight(baseQQAppInterface, false, null)) {
                            colorDrawable.setAlpha(63);
                        } else {
                            colorDrawable.setAlpha(25);
                        }
                        viewHolder.t().setBackground(colorDrawable);
                        ArrayList<GroupSquareLabel> arrayList = c16.labels;
                        Intrinsics.checkNotNullExpressionValue(arrayList, "troopItem.labels");
                        if (!TextUtils.isEmpty(l0(arrayList))) {
                            Context context = viewHolder.t().getContext();
                            ArrayList<GroupSquareLabel> arrayList2 = c16.labels;
                            Intrinsics.checkNotNullExpressionValue(arrayList2, "troopItem.labels");
                            Drawable k3 = RecommendTroopAdapter.k(context, l0(arrayList2));
                            int c17 = x.c(viewHolder.t().getContext(), 10.0f);
                            k3.setBounds(0, 0, c17, c17);
                            viewHolder.t().setCompoundDrawablePadding(x.c(viewHolder.t().getContext(), 2.0f));
                            viewHolder.t().setCompoundDrawables(k3, null, null, null);
                        }
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            if (z16) {
                viewHolder.t().setVisibility(0);
            } else {
                viewHolder.t().setVisibility(8);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ViewHolder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) viewGroup, viewType);
        }
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.i16, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new ViewHolder(this, itemView);
    }

    public final void p0(@NotNull List<com.tencent.mobileqq.troop.troopsquare.data.a> data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) data);
        } else {
            Intrinsics.checkNotNullParameter(data, "data");
            this.differ.submitList(data);
        }
    }

    @Nullable
    public final ArrayList<GroupLabel> q0(@Nullable GroupSquareGroupInfoItem troop) {
        ArrayList<GroupSquareLabel> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (ArrayList) iPatchRedirector.redirect((short) 11, (Object) this, (Object) troop);
        }
        ArrayList<GroupLabel> arrayList2 = null;
        if (troop == null || (arrayList = troop.labels) == null) {
            return null;
        }
        if (arrayList.size() > 0) {
            arrayList2 = new ArrayList<>();
            Iterator<GroupSquareLabel> it = troop.labels.iterator();
            while (it.hasNext()) {
                GroupSquareLabel next = it.next();
                GroupLabel groupLabel = new GroupLabel();
                Color color = new Color();
                GroupSquareColor groupSquareColor = next.edgingColor;
                color.R = groupSquareColor.red;
                color.G = groupSquareColor.green;
                color.B = groupSquareColor.blue;
                groupLabel.edging_color = color;
                Color color2 = new Color();
                GroupSquareColor groupSquareColor2 = next.textColor;
                color2.R = groupSquareColor2.red;
                color2.G = groupSquareColor2.green;
                color2.B = groupSquareColor2.blue;
                groupLabel.text_color = color2;
                groupLabel.strWording = next.name;
                int i3 = next.labelType;
                groupLabel.type = i3;
                if (i3 != 300) {
                    arrayList2.add(groupLabel);
                }
            }
        }
        return arrayList2;
    }

    public final void r0(@Nullable String troopUin) {
        boolean z16;
        Long longOrNull;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) troopUin);
            return;
        }
        if (troopUin != null && troopUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        List<com.tencent.mobileqq.troop.troopsquare.data.a> currentList = this.differ.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "differ.currentList");
        Iterator<com.tencent.mobileqq.troop.troopsquare.data.a> it = currentList.iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                long a16 = it.next().a();
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
                if (longOrNull != null && a16 == longOrNull.longValue()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 > -1) {
            this.differ.getCurrentList().get(i3).e(true);
            notifyItemChanged(i3);
        }
    }

    public TroopSquareRecommendAdapter(long j3, int i3, @NotNull Map<String, Object> exReportMap, @NotNull String elementId) {
        Intrinsics.checkNotNullParameter(exReportMap, "exReportMap");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Integer.valueOf(i3), exReportMap, elementId);
            return;
        }
        this.groupCode = j3;
        this.joinTroopSubSource = i3;
        this.exReportMap = exReportMap;
        this.elementId = elementId;
        this.differ = new AsyncListDiffer<>(this, new a());
    }
}
