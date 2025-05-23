package com.tencent.mobileqq.activity.aio.intimate.headerv2;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.intimate.header.IntimateHeaderCardUtil;
import com.tencent.mobileqq.activity.aio.intimate.reborn.model.DoLIAAnimViewEvent;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.utils.u;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.b;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 [2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0003\\]^B\u0007\u00a2\u0006\u0004\bY\u0010ZJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0010\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u0010\u001a\u00020\u00052\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rJ\u0006\u0010\u0011\u001a\u00020\u0005J\u001c\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u001c\u0010\u0019\u001a\u00020\u00052\n\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J*\u0010\u001d\u001a\u00020\u00052\n\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00142\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u0014H\u0016J-\u0010 \u001a\u00020\u00052\n\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010\u0014H\u0002\u00a2\u0006\u0004\b \u0010!J$\u0010%\u001a\u00020\u00052\n\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"H\u0002J5\u0010&\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\"2\n\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010\u0014H\u0002\u00a2\u0006\u0004\b&\u0010'J,\u0010+\u001a\u00020\u00072\n\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010(\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020)2\u0006\u0010\u0018\u001a\u00020\u0014H\u0002J$\u0010,\u001a\u00020\u00052\n\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u000eH\u0002J$\u0010-\u001a\u00020\u00072\n\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010(\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0014H\u0002J\u0018\u00100\u001a\u00020\u00052\u0006\u0010/\u001a\u00020.2\u0006\u0010\u000b\u001a\u00020\u0014H\u0002J4\u00103\u001a\u00020\u00052\n\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020)2\u0006\u00102\u001a\u000201H\u0002J\u001c\u00104\u001a\u00020\u00072\n\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010(\u001a\u00020\u000eH\u0002J\u0014\u00108\u001a\u0004\u0018\u0001072\b\u00106\u001a\u0004\u0018\u000105H\u0002J4\u00109\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u000e2\n\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010*\u001a\u00020)2\u0006\u00102\u001a\u000201H\u0002J\u001c\u0010:\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00142\n\u0010\u0017\u001a\u00060\u0002R\u00020\u0000H\u0002J\u0018\u0010;\u001a\u00020\u00052\u0006\u00102\u001a\u0002012\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010=\u001a\u0002052\u0006\u0010<\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\"H\u0002J\u0018\u0010A\u001a\u00020@2\u0006\u0010>\u001a\u0002052\u0006\u0010?\u001a\u000205H\u0002J\u0010\u0010B\u001a\u0002052\u0006\u0010$\u001a\u00020\"H\u0002J\u0018\u0010D\u001a\u0002052\u0006\u0010C\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"H\u0002R&\u0010I\u001a\u0012\u0012\u0004\u0012\u00020\u000e0Ej\b\u0012\u0004\u0012\u00020\u000e`F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR&\u0010K\u001a\u0012\u0012\u0004\u0012\u00020\n0Ej\b\u0012\u0004\u0012\u00020\n`F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010HR\u0016\u0010N\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010Q\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010U\u001a\u00020R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010X\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010W\u00a8\u0006_"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/headerv2/f;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/activity/aio/intimate/headerv2/f$b;", "Lcom/tencent/mobileqq/activity/aio/intimate/headerv2/f$c;", "listener", "", "R0", "", "friendUin", "Q0", "", "type", "S0", "", "Lf61/j;", "data", "setData", "V0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "N0", "holder", "position", "L0", "", "", "payloads", "M0", "getItemCount", "animationType", "r0", "(Lcom/tencent/mobileqq/activity/aio/intimate/headerv2/f$b;ILjava/lang/Integer;)V", "Landroid/content/res/ColorStateList;", "normalBgColor", NodeProps.BORDER_COLOR, "K0", "E0", "(ILandroid/content/res/ColorStateList;Lcom/tencent/mobileqq/activity/aio/intimate/headerv2/f$b;Ljava/lang/Integer;)V", "partnerEntryInfo", "Landroid/content/res/Resources;", DKConfiguration.Directory.RESOURCES, "F0", "A0", "I0", "Landroid/widget/ImageView;", "ivInteractive", "U0", "Landroid/content/Context;", "context", "T0", "C0", "Landroid/graphics/drawable/Drawable;", "drawable", "Landroid/graphics/Bitmap;", "v0", "s0", "u0", "O0", "id", "y0", "drawable1", "drawable2", "Landroid/graphics/drawable/LayerDrawable;", "z0", "w0", "backgroundColor", "x0", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "mData", BdhLogUtil.LogTag.Tag_Conn, "mCilckedEmojiList", "D", "J", "mSelectedType", "E", "Lcom/tencent/mobileqq/activity/aio/intimate/headerv2/f$c;", "mOnRecyclerViewInteractionListener", "Lcom/tencent/mobileqq/widget/annimation/scaleview/a;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/widget/annimation/scaleview/a;", "mQUIScaleUtil", "G", "Ljava/lang/String;", "mFriendUin", "<init>", "()V", "H", "a", "b", "c", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class f extends RecyclerView.Adapter<b> {
    private static final int I = ViewUtils.dpToPx(98.0f);
    private static final int J = ViewUtils.dpToPx(126.0f);
    private static final int K = ViewUtils.dpToPx(100.0f);
    private static final int L = ViewUtils.dpToPx(136.0f);
    private static final int M = ViewUtils.dpToPx(5.0f);
    private static final float N = ViewUtils.dpToPx(8.0f);

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private c mOnRecyclerViewInteractionListener;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private String mFriendUin;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<f61.j> mData = new ArrayList<>();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private ArrayList<Long> mCilckedEmojiList = new ArrayList<>();

    /* renamed from: D, reason: from kotlin metadata */
    private long mSelectedType = -1;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.widget.annimation.scaleview.a mQUIScaleUtil = new com.tencent.mobileqq.widget.annimation.scaleview.a();

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010&\u001a\u00020\u0011\u00a2\u0006\u0004\b'\u0010(R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015R\u0017\u0010\u001f\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010%\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/headerv2/f$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "getTvTitle", "()Landroid/widget/TextView;", "tvTitle", UserInfo.SEX_FEMALE, "r", "tvSubTitle", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "o", "()Landroid/widget/ImageView;", "ivInteractive", "Landroid/view/View;", "H", "Landroid/view/View;", "p", "()Landroid/view/View;", "layoutInteractive", "I", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "layoutRoot", "Landroidx/cardview/widget/CardView;", "J", "Landroidx/cardview/widget/CardView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroidx/cardview/widget/CardView;", "cardView", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "K", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "l", "()Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "avatarView", "view", "<init>", "(Lcom/tencent/mobileqq/activity/aio/intimate/headerv2/f;Landroid/view/View;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final TextView tvTitle;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final TextView tvSubTitle;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final ImageView ivInteractive;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final View layoutInteractive;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private final View layoutRoot;

        /* renamed from: J, reason: from kotlin metadata */
        @NotNull
        private final CardView cardView;

        /* renamed from: K, reason: from kotlin metadata */
        @NotNull
        private final QQProAvatarView avatarView;
        final /* synthetic */ f L;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull f fVar, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.L = fVar;
            View findViewById = this.itemView.findViewById(R.id.kbs);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.tv_title)");
            this.tvTitle = (TextView) findViewById;
            View findViewById2 = this.itemView.findViewById(R.id.f111586lm);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.tv_sub_title)");
            this.tvSubTitle = (TextView) findViewById2;
            View findViewById3 = this.itemView.findViewById(R.id.y4z);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.iv_interactive)");
            this.ivInteractive = (ImageView) findViewById3;
            View findViewById4 = this.itemView.findViewById(R.id.yel);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.layout_interactive)");
            this.layoutInteractive = findViewById4;
            View findViewById5 = this.itemView.findViewById(R.id.f166025e55);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.layout_root)");
            this.layoutRoot = findViewById5;
            View findViewById6 = this.itemView.findViewById(R.id.tor);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.cardview)");
            this.cardView = (CardView) findViewById6;
            View findViewById7 = this.itemView.findViewById(R.id.xps);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.\u2026.intimate_bind_head_view)");
            this.avatarView = (QQProAvatarView) findViewById7;
        }

        @NotNull
        public final TextView getTvTitle() {
            return this.tvTitle;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final QQProAvatarView getAvatarView() {
            return this.avatarView;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final CardView getCardView() {
            return this.cardView;
        }

        @NotNull
        /* renamed from: o, reason: from getter */
        public final ImageView getIvInteractive() {
            return this.ivInteractive;
        }

        @NotNull
        /* renamed from: p, reason: from getter */
        public final View getLayoutInteractive() {
            return this.layoutInteractive;
        }

        @NotNull
        /* renamed from: q, reason: from getter */
        public final View getLayoutRoot() {
            return this.layoutRoot;
        }

        @NotNull
        /* renamed from: r, reason: from getter */
        public final TextView getTvSubTitle() {
            return this.tvSubTitle;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/headerv2/f$c;", "", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLICK_TYPE, "", "position", "", "type", "", "a", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public interface c {
        void a(@NotNull String clickType, int position, long type);

        void b(long type);
    }

    private final void A0(final b holder, final int position, final f61.j partnerEntryInfo) {
        holder.getCardView().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.aio.intimate.headerv2.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.B0(f.this, position, partnerEntryInfo, holder, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(f this$0, int i3, f61.j partnerEntryInfo, b holder, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(partnerEntryInfo, "$partnerEntryInfo");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        if (!u.a().b()) {
            c cVar = this$0.mOnRecyclerViewInteractionListener;
            if (cVar != null) {
                cVar.a("CLICK_CARD", i3, partnerEntryInfo.getId());
            }
            int i16 = 0;
            int i17 = 0;
            for (Object obj : this$0.mData) {
                int i18 = i17 + 1;
                if (i17 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                if (((f61.j) obj).getId() == this$0.mSelectedType) {
                    i16 = i17;
                }
                i17 = i18;
            }
            this$0.mSelectedType = this$0.mData.get(i3).getId();
            this$0.notifyItemChanged(i16, 1);
            this$0.notifyItemChanged(holder.getAdapterPosition(), 2);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final String C0(b holder, final f61.j partnerEntryInfo) {
        final Context context;
        Resources resources = holder.getLayoutRoot().getResources();
        if (resources == null || (context = holder.getLayoutRoot().getContext()) == null) {
            return "2";
        }
        holder.getIvInteractive().setImageDrawable(resources.getDrawable(R.drawable.qui_message));
        holder.getTvSubTitle().setText(partnerEntryInfo.getInteractionEntryInfo().getClickIntro());
        holder.getLayoutInteractive().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.aio.intimate.headerv2.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.D0(f.this, context, partnerEntryInfo, view);
            }
        });
        return "2";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(f this$0, Context context, f61.j partnerEntryInfo, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(partnerEntryInfo, "$partnerEntryInfo");
        if (!u.a().b()) {
            this$0.O0(context, partnerEntryInfo.getId());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void E0(int position, ColorStateList borderColor, b holder, Integer animationType) {
        Resources resources = holder.getLayoutRoot().getResources();
        if (resources == null) {
            return;
        }
        if (QQTheme.isNowThemeIsNight()) {
            holder.getCardView().setBackground(z0(y0((int) this.mData.get(position).getId(), borderColor), w0(borderColor)));
        } else {
            holder.getCardView().setBackground(y0((int) this.mData.get(position).getId(), borderColor));
        }
        holder.getTvTitle().setTextColor(resources.getColorStateList(R.color.qui_common_text_allwhite_primary));
        holder.getTvSubTitle().setTextColor(resources.getColorStateList(R.color.qui_common_text_allwhite_primary));
        holder.getLayoutInteractive().setBackground(resources.getDrawable(R.drawable.qui_common_text_white_circle));
        holder.getLayoutInteractive().setElevation(ViewUtils.dpToPx(10.0f));
        CardView cardView = holder.getCardView();
        float f16 = N;
        cardView.setCardElevation(f16);
        ViewUtils.setViewSize(holder.getLayoutInteractive(), ViewUtils.dpToPx(44.0f), ViewUtils.dpToPx(44.0f));
        View view = holder.itemView;
        int i3 = K;
        int i16 = L;
        ViewUtils.setViewSize(view, i3, i16);
        ViewUtils.setMarginTop(holder.itemView, 0);
        ViewUtils.setViewSize(holder.getLayoutInteractive(), ViewUtils.dpToPx(44.0f), ViewUtils.dpToPx(44.0f));
        ViewUtils.setViewSize(holder.itemView, i3, i16);
        ViewUtils.setMarginTop(holder.itemView, 0);
        if (IntimateHeaderCardUtil.t() && animationType != null && animationType.intValue() == 2) {
            new com.tencent.mobileqq.widget.annimation.scaleview.a().e(holder.getLayoutInteractive()).d(1.0f, 1.1f, 1.0f, 1.1f).c(1).b(R.anim.f154985us, 3).f(null);
            new com.tencent.mobileqq.widget.annimation.scaleview.a().e(holder.getCardView()).d(1.0f, 1.05f, 1.0f, 1.05f).c(1).b(R.anim.f154985us, 3).f(null);
        }
        holder.getCardView().setCardElevation(f16);
        c cVar = this.mOnRecyclerViewInteractionListener;
        if (cVar != null) {
            cVar.b(this.mData.get(position).getId());
        }
        u0(position, holder);
    }

    private final String F0(b holder, final f61.j partnerEntryInfo, Resources resources, final int position) {
        holder.getCardView().setOnClickListener(null);
        holder.getTvSubTitle().setText(partnerEntryInfo.getInteractionEntryInfo().getDefaultInto());
        holder.getIvInteractive().setImageDrawable(resources.getDrawable(R.drawable.qui_add));
        holder.getLayoutInteractive().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.aio.intimate.headerv2.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.H0(f.this, position, partnerEntryInfo, view);
            }
        });
        return "3";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(f this$0, int i3, f61.j partnerEntryInfo, View view) {
        c cVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(partnerEntryInfo, "$partnerEntryInfo");
        if (!u.a().b() && (cVar = this$0.mOnRecyclerViewInteractionListener) != null) {
            cVar.a("CLICK_BIND", i3, partnerEntryInfo.getId());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final String I0(final b holder, final f61.j partnerEntryInfo, final int position) {
        final Context context;
        final Resources resources = holder.getLayoutRoot().getResources();
        if (resources == null || (context = holder.getLayoutRoot().getContext()) == null) {
            return "2";
        }
        U0(holder.getIvInteractive(), (int) partnerEntryInfo.getId());
        holder.getTvSubTitle().setText(partnerEntryInfo.getInteractionEntryInfo().getDefaultInto());
        holder.getLayoutInteractive().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.aio.intimate.headerv2.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.J0(f.this, position, partnerEntryInfo, holder, resources, context, view);
            }
        });
        return "1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(f this$0, int i3, f61.j partnerEntryInfo, b holder, Resources resources, Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(partnerEntryInfo, "$partnerEntryInfo");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(resources, "$resources");
        Intrinsics.checkNotNullParameter(context, "$context");
        if (!u.a().b()) {
            c cVar = this$0.mOnRecyclerViewInteractionListener;
            if (cVar != null) {
                cVar.a("CLICK_EMOJI", i3, partnerEntryInfo.getId());
            }
            if (!IntimateHeaderCardUtil.t()) {
                this$0.s0(i3, partnerEntryInfo, holder, resources, context);
            } else {
                this$0.mQUIScaleUtil.a();
                this$0.mQUIScaleUtil.e(null);
                this$0.T0(holder, i3, partnerEntryInfo, resources, context);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void K0(b holder, ColorStateList normalBgColor, ColorStateList borderColor) {
        Resources resources = holder.getLayoutRoot().getResources();
        if (resources == null) {
            return;
        }
        holder.getCardView().setBackground(x0(normalBgColor, borderColor));
        holder.getCardView().setCardElevation(0.0f);
        holder.getTvTitle().setTextColor(resources.getColorStateList(R.color.qui_common_text_primary));
        holder.getTvSubTitle().setTextColor(resources.getColorStateList(R.color.qui_common_text_secondary));
        holder.getLayoutInteractive().setBackground(resources.getDrawable(R.drawable.qui_common_fill_standard_primary_circle));
        holder.getLayoutInteractive().setElevation(0.0f);
        ViewUtils.setViewSize(holder.getLayoutInteractive(), ViewUtils.dpToPx(40.0f), ViewUtils.dpToPx(40.0f));
        ViewUtils.setViewSize(holder.itemView, I, J);
        ViewUtils.setMarginTop(holder.itemView, M);
    }

    private final void O0(Context context, long type) {
        Map mutableMapOf;
        String str;
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            return;
        }
        String str2 = this.mFriendUin;
        if (str2 != null) {
            String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.mFriendUin);
            com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            aVar.d(uid);
            String nameWithConfig = ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
            if (nameWithConfig == null) {
                str = str2;
            } else {
                str = nameWithConfig;
            }
            QRouteApi api = QRoute.api(IAIOStarterApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IAIOStarterApi::class.java)");
            IAIOStarterApi.a.c((IAIOStarterApi) api, context, 1, uid, str, null, 16, null);
        }
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("relationship_type", Long.valueOf(type)), TuplesKt.to("interaction_type", "2"));
        IntimateHeaderCardUtil.U("qq_clck", "pg_aio_swipleft", "em_bas_swipleft_card", new HashMap(mutableMapOf));
    }

    private final void T0(b holder, int position, f61.j partnerEntryInfo, Resources resources, Context context) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        he0.b.l(alphaAnimation, R.anim.f154985us);
        holder.getIvInteractive().startAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new e(holder, position, partnerEntryInfo, resources, context));
    }

    private final void U0(ImageView ivInteractive, int type) {
        if ((ivInteractive.getTag() instanceof Integer) && Intrinsics.areEqual(ivInteractive.getTag(), Integer.valueOf(type))) {
            return;
        }
        ivInteractive.setTag(Integer.valueOf(type));
        ivInteractive.setImageDrawable(IntimateHeaderCardUtil.D(type));
    }

    private final void r0(b holder, int position, Integer animationType) {
        String F0;
        Map mutableMapOf;
        if (!bl.b(this.mData) && position < this.mData.size()) {
            Resources resources = holder.getLayoutRoot().getResources();
            ColorStateList colorStateList = resources.getColorStateList(R.color.qui_common_border_allwhite_strong);
            Intrinsics.checkNotNullExpressionValue(colorStateList, "resources.getColorStateL\u2026n_border_allwhite_strong)");
            ColorStateList colorStateList2 = resources.getColorStateList(R.color.qui_common_fill_light_tertiary);
            Intrinsics.checkNotNullExpressionValue(colorStateList2, "resources.getColorStateL\u2026mmon_fill_light_tertiary)");
            if (position == 0) {
                f61.j jVar = this.mData.get(0);
                Intrinsics.checkNotNullExpressionValue(jVar, "mData[0]");
                f61.j jVar2 = jVar;
                if (this.mSelectedType == -1 && jVar2.getIsBind()) {
                    if (QQTheme.isNowThemeIsNight()) {
                        holder.getCardView().setBackground(z0(y0((int) jVar2.getId(), colorStateList), w0(colorStateList)));
                    } else {
                        holder.getCardView().setBackground(y0((int) jVar2.getId(), colorStateList));
                    }
                    ViewUtils.setViewSize(holder.itemView, K, L);
                    ViewUtils.setMarginTop(holder.itemView, 0);
                    this.mSelectedType = jVar2.getId();
                    holder.getCardView().setCardElevation(N);
                } else {
                    holder.getCardView().setBackground(x0(colorStateList2, colorStateList));
                }
            } else {
                holder.getCardView().setBackground(x0(colorStateList2, colorStateList));
            }
            if (this.mData.get(position).getId() == this.mSelectedType) {
                E0(position, colorStateList, holder, animationType);
            } else {
                K0(holder, colorStateList2, colorStateList);
            }
            f61.j partnerEntryInfo = this.mData.get(position);
            holder.getTvTitle().setText(partnerEntryInfo.getName());
            if (partnerEntryInfo.getIsBind()) {
                if (this.mCilckedEmojiList.contains(Long.valueOf(partnerEntryInfo.getId()))) {
                    Intrinsics.checkNotNullExpressionValue(partnerEntryInfo, "partnerEntryInfo");
                    F0 = C0(holder, partnerEntryInfo);
                } else {
                    Intrinsics.checkNotNullExpressionValue(partnerEntryInfo, "partnerEntryInfo");
                    F0 = I0(holder, partnerEntryInfo, position);
                }
                A0(holder, position, partnerEntryInfo);
            } else {
                Intrinsics.checkNotNullExpressionValue(partnerEntryInfo, "partnerEntryInfo");
                Intrinsics.checkNotNullExpressionValue(resources, "resources");
                F0 = F0(holder, partnerEntryInfo, resources, position);
            }
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("relationship_type", Long.valueOf(partnerEntryInfo.getId())), TuplesKt.to("interaction_type", F0));
            IntimateHeaderCardUtil.U("qq_imp", "pg_aio_swipleft", "em_bas_swipleft_card", new HashMap(mutableMapOf));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s0(int position, final f61.j partnerEntryInfo, b holder, Resources resources, final Context context) {
        Map mutableMapOf;
        holder.getIvInteractive().setImageDrawable(resources.getDrawable(R.drawable.qui_message));
        if (IntimateHeaderCardUtil.t()) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            he0.b.l(alphaAnimation, R.anim.f154985us);
            holder.getIvInteractive().startAnimation(alphaAnimation);
            new com.tencent.mobileqq.widget.annimation.scaleview.a().e(holder.getIvInteractive()).d(1.0f, 1.2f, 1.0f, 1.2f).c(1).b(R.anim.f154985us, 3).f(null);
        }
        holder.getTvSubTitle().setText(partnerEntryInfo.getInteractionEntryInfo().getClickIntro());
        this.mCilckedEmojiList.add(Long.valueOf(partnerEntryInfo.getId()));
        holder.getLayoutInteractive().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.aio.intimate.headerv2.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.t0(f.this, context, partnerEntryInfo, view);
            }
        });
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("relationship_type", Long.valueOf(partnerEntryInfo.getId())), TuplesKt.to("interaction_type", "2"));
        IntimateHeaderCardUtil.U("qq_imp", "pg_aio_swipleft", "em_bas_swipleft_card", new HashMap(mutableMapOf));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(f this$0, Context context, f61.j partnerEntryInfo, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(partnerEntryInfo, "$partnerEntryInfo");
        if (!u.a().b()) {
            this$0.O0(context, partnerEntryInfo.getId());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void u0(int position, b holder) {
        if (!IntimateHeaderCardUtil.t()) {
            return;
        }
        this.mQUIScaleUtil.a();
        f61.j jVar = this.mData.get(position);
        Intrinsics.checkNotNullExpressionValue(jVar, "mData[position]");
        f61.j jVar2 = jVar;
        if (jVar2.getStatus() != 2 && jVar2.getStatus() != 3) {
            return;
        }
        com.tencent.mobileqq.activity.aio.intimate.header.l lVar = com.tencent.mobileqq.activity.aio.intimate.header.l.f179061a;
        if (!lVar.e(jVar2.getId(), String.valueOf(this.mFriendUin))) {
            QLog.i("HeaderCardAdapter", 1, "doStartAnimation getIsNeedShowInterAni false " + jVar2.getId() + " uin " + this.mFriendUin);
            return;
        }
        if (this.mCilckedEmojiList.contains(Long.valueOf(jVar2.getId()))) {
            return;
        }
        this.mQUIScaleUtil.e(holder.getLayoutInteractive()).d(1.0f, 1.2f, 1.0f, 1.2f).c(1).b(R.anim.f154985us, 3).f(new d());
        lVar.k(jVar2.getId(), String.valueOf(this.mFriendUin), System.currentTimeMillis());
        QLog.i("HeaderCardAdapter", 1, "doStartAnimation setNeedShowInterAniShowTime " + jVar2.getId() + " uin " + this.mFriendUin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap v0(Drawable drawable) {
        BitmapDrawable bitmapDrawable;
        String str;
        Bitmap bitmap;
        if (drawable == null) {
            return null;
        }
        try {
        } catch (Exception e16) {
            QLog.e("HeaderCardAdapter", 1, "getBitmapFromDrawable " + e16);
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (drawable instanceof URLDrawable) {
            if (((URLDrawable) drawable).getCurrDrawable() instanceof URLDrawable) {
                return null;
            }
            return v0(((URLDrawable) drawable).getCurrDrawable());
        }
        if (drawable instanceof vw3.a) {
            Drawable mCurrDrawable = ((vw3.a) drawable).getMCurrDrawable();
            if (mCurrDrawable instanceof BitmapDrawable) {
                bitmapDrawable = (BitmapDrawable) mCurrDrawable;
            } else {
                bitmapDrawable = null;
            }
            if (bitmapDrawable != null && (bitmap = bitmapDrawable.getBitmap()) != null) {
                return bitmap;
            }
            Drawable mCurrDrawable2 = ((vw3.a) drawable).getMCurrDrawable();
            if (mCurrDrawable2 != null) {
                str = mCurrDrawable2.getClass().getName();
            } else {
                str = null;
            }
            QLog.e("HeaderCardAdapter", 1, "drawable.getCurrDrawable() is not BitmapDrawable, " + str);
            return null;
        }
        if (drawable instanceof RegionDrawable) {
            return ((RegionDrawable) drawable).getBitmap();
        }
        if (drawable instanceof SkinnableBitmapDrawable) {
            return ((SkinnableBitmapDrawable) drawable).getBitmap();
        }
        return null;
    }

    private final Drawable w0(ColorStateList borderColor) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        IntimateHeaderCardUtil intimateHeaderCardUtil = IntimateHeaderCardUtil.f178990a;
        gradientDrawable.setCornerRadius(intimateHeaderCardUtil.k());
        gradientDrawable.setStroke(intimateHeaderCardUtil.j(), borderColor);
        gradientDrawable.setColor(ColorStateList.valueOf(Color.parseColor("#99000000")));
        return gradientDrawable;
    }

    private final Drawable x0(ColorStateList backgroundColor, ColorStateList borderColor) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        IntimateHeaderCardUtil intimateHeaderCardUtil = IntimateHeaderCardUtil.f178990a;
        gradientDrawable.setCornerRadius(intimateHeaderCardUtil.k());
        gradientDrawable.setStroke(intimateHeaderCardUtil.j(), borderColor);
        gradientDrawable.setColor(backgroundColor);
        return gradientDrawable;
    }

    private final Drawable y0(int id5, ColorStateList borderColor) {
        Pair<Integer, Integer> E = IntimateHeaderCardUtil.E(id5);
        int intValue = E.getFirst().intValue();
        int intValue2 = E.getSecond().intValue();
        IntimateHeaderCardUtil intimateHeaderCardUtil = IntimateHeaderCardUtil.f178990a;
        GradientDrawable createGradientDrawable = ViewUtils.createGradientDrawable(intValue, null, intValue2, intimateHeaderCardUtil.l(), intimateHeaderCardUtil.k(), intimateHeaderCardUtil.j(), borderColor);
        Intrinsics.checkNotNullExpressionValue(createGradientDrawable, "createGradientDrawable(\n\u2026borderColor\n            )");
        return createGradientDrawable;
    }

    private final LayerDrawable z0(Drawable drawable1, Drawable drawable2) {
        return new LayerDrawable(new Drawable[]{drawable1, drawable2});
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: L0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull b holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        r0(holder, position, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: M0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull b holder, int position, @NotNull List<Object> payloads) {
        Integer num;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads);
            return;
        }
        Object obj = payloads.get(0);
        if (obj instanceof Integer) {
            num = (Integer) obj;
        } else {
            num = null;
        }
        r0(holder, position, num);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: N0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fda, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new b(this, view);
    }

    public final void Q0(@Nullable String friendUin) {
        this.mFriendUin = friendUin;
    }

    public final void R0(@NotNull c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mOnRecyclerViewInteractionListener = listener;
    }

    public final void S0(long type) {
        this.mSelectedType = type;
    }

    public final void V0() {
        this.mSelectedType = -1L;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mData.size();
    }

    public final void setData(@Nullable List<f61.j> data) {
        if (data != null) {
            if (!(!data.isEmpty())) {
                data = null;
            }
            if (data != null) {
                this.mData.clear();
                this.mData.addAll(data);
                notifyDataSetChanged();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/activity/aio/intimate/headerv2/f$d", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class d implements Animation.AnimationListener {
        d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            f.this.mQUIScaleUtil.f(this);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@Nullable Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/activity/aio/intimate/headerv2/f$e", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class e implements Animation.AnimationListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f179114e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f179115f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ f61.j f179116h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Resources f179117i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ Context f179118m;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/activity/aio/intimate/headerv2/f$e$a", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/b$a;", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/b;", "anim", "", "a", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes10.dex */
        public static final class a implements b.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f179119a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ f f179120b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f179121c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ f61.j f179122d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Resources f179123e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Context f179124f;

            a(b bVar, f fVar, int i3, f61.j jVar, Resources resources, Context context) {
                this.f179119a = bVar;
                this.f179120b = fVar;
                this.f179121c = i3;
                this.f179122d = jVar;
                this.f179123e = resources;
                this.f179124f = context;
            }

            @Override // com.tencent.qqnt.biz.lightbusiness.lightinteraction.b.a
            public void a(@NotNull com.tencent.qqnt.biz.lightbusiness.lightinteraction.b anim) {
                Intrinsics.checkNotNullParameter(anim, "anim");
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                he0.b.l(alphaAnimation, R.anim.f154985us);
                this.f179119a.getAvatarView().startAnimation(alphaAnimation);
            }

            @Override // com.tencent.qqnt.biz.lightbusiness.lightinteraction.b.a
            public void b(@NotNull com.tencent.qqnt.biz.lightbusiness.lightinteraction.b anim) {
                Intrinsics.checkNotNullParameter(anim, "anim");
                anim.setOnAnimActionListener(null);
                anim.b(null);
                anim.a(null);
                QLog.d("HeaderCardAdapter", 1, "[handleShowLightInterActionAnim] end to send msg");
                this.f179119a.getAvatarView().setVisibility(8);
                this.f179120b.s0(this.f179121c, this.f179122d, this.f179119a, this.f179123e, this.f179124f);
            }
        }

        e(b bVar, int i3, f61.j jVar, Resources resources, Context context) {
            this.f179114e = bVar;
            this.f179115f = i3;
            this.f179116h = jVar;
            this.f179117i = resources;
            this.f179118m = context;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            Bitmap v06 = f.this.v0(this.f179114e.getIvInteractive().getDrawable());
            if (v06 == null) {
                this.f179114e.getAvatarView().setVisibility(8);
                f.this.s0(this.f179115f, this.f179116h, this.f179114e, this.f179117i, this.f179118m);
            } else {
                this.f179114e.getAvatarView().x(1, f.this.mFriendUin, null);
                SimpleEventBus.getInstance().dispatchEvent(new DoLIAAnimViewEvent(this.f179114e.getAvatarView(), v06, new a(this.f179114e, f.this, this.f179115f, this.f179116h, this.f179117i, this.f179118m)));
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@Nullable Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
        }
    }
}
