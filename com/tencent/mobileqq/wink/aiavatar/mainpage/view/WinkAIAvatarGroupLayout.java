package com.tencent.mobileqq.wink.aiavatar.mainpage.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.aiavatar.base.WinkAIAvatarUtils;
import com.tencent.mobileqq.wink.aiavatar.mainpage.view.WinkAIAvatarGroupLayout;
import com.tencent.mobileqq.wink.editor.c;
import com.tencent.mobileqq.wink.view.WinkRoundedCornerImageView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 -2\u00020\u0001:\u0004./0\u0010B\u0017\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u0005J\u0019\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\u0002R\u0014\u0010\u0012\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u0011R\u0016\u0010&\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010\u0011R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/mainpage/view/WinkAIAvatarGroupLayout;", "Landroid/widget/RelativeLayout;", "", h.F, "k", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "category", "j", "", "parentCategoryId", "e", "", "targetItemPosition", "i", "(Ljava/lang/Integer;)V", "g", "d", "I", NotifyMsgApiImpl.KEY_GROUP_TYPE, "Landroid/widget/TextView;", "Landroid/widget/TextView;", "groupName", "f", "Landroid/widget/RelativeLayout;", "groupIcon", "iconText", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerview", "Lcom/tencent/mobileqq/wink/aiavatar/mainpage/view/WinkAIAvatarGroupLayout$a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/wink/aiavatar/mainpage/view/WinkAIAvatarGroupLayout$a;", "adapter", BdhLogUtil.LogTag.Tag_Conn, "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "D", "orientation", "E", "gridSpanCount", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;I)V", "H", "a", "b", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkAIAvatarGroupLayout extends RelativeLayout {

    @NotNull
    private static final Set<String> I;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private MetaCategory category;

    /* renamed from: D, reason: from kotlin metadata */
    private int orientation;

    /* renamed from: E, reason: from kotlin metadata */
    private int gridSpanCount;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private String parentCategoryId;

    @NotNull
    public Map<Integer, View> G;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int groupType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView groupName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RelativeLayout groupIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView iconText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView recyclerview;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a adapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/mainpage/view/WinkAIAvatarGroupLayout$a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/wink/aiavatar/mainpage/view/WinkAIAvatarGroupLayout$b;", "", "viewType", "i0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "k0", "getItemCount", "holder", "position", "", "j0", "getItemViewType", "l0", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "category", "m0", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "parentCategoryId", BdhLogUtil.LogTag.Tag_Conn, "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "D", "I", NotifyMsgApiImpl.KEY_GROUP_TYPE, "<init>", "(Ljava/lang/String;Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;I)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a extends RecyclerView.Adapter<b> {

        /* renamed from: C, reason: from kotlin metadata */
        @Nullable
        private MetaCategory category;

        /* renamed from: D, reason: from kotlin metadata */
        private final int groupType;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String parentCategoryId;

        public a(@NotNull String parentCategoryId, @Nullable MetaCategory metaCategory, int i3) {
            Intrinsics.checkNotNullParameter(parentCategoryId, "parentCategoryId");
            this.parentCategoryId = parentCategoryId;
            this.category = metaCategory;
            this.groupType = i3;
        }

        private final int i0(int viewType) {
            if (viewType == 0) {
                return R.layout.i4n;
            }
            if (viewType != 1) {
                if (viewType == 2) {
                    return R.layout.i4n;
                }
                if (viewType != 3) {
                    return viewType != 4 ? R.layout.i4n : R.layout.i4n;
                }
            }
            return R.layout.i4i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            ArrayList<MetaMaterial> arrayList;
            MetaCategory metaCategory = this.category;
            if (metaCategory != null && (arrayList = metaCategory.materials) != null) {
                return arrayList.size();
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            boolean z16;
            ArrayList<MetaMaterial> arrayList;
            MetaMaterial metaMaterial;
            MetaCategory metaCategory = this.category;
            if (metaCategory != null && (arrayList = metaCategory.materials) != null && (metaMaterial = arrayList.get(position)) != null) {
                z16 = c.Z0(metaMaterial);
            } else {
                z16 = false;
            }
            int i3 = this.groupType;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        return 0;
                    }
                    return 1;
                }
                if (position == 0) {
                    return 4;
                }
                return 5;
            }
            if (!z16) {
                return 2;
            }
            return 3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull b holder, int position) {
            String str;
            ArrayList<MetaMaterial> arrayList;
            MetaMaterial metaMaterial;
            Intrinsics.checkNotNullParameter(holder, "holder");
            holder.o(this.category, position);
            MetaCategory metaCategory = this.category;
            String str2 = null;
            if (metaCategory != null && (arrayList = metaCategory.materials) != null && (metaMaterial = arrayList.get(position)) != null) {
                str = metaMaterial.f30533id;
            } else {
                str = null;
            }
            String str3 = "";
            if (str == null) {
                str = "";
            }
            MetaCategory metaCategory2 = this.category;
            if (metaCategory2 != null) {
                str2 = metaCategory2.name;
            }
            if (str2 != null) {
                str3 = str2;
            }
            String str4 = this.parentCategoryId + "_" + str3 + "_" + position;
            com.tencent.mobileqq.wink.aiavatar.base.a aVar = com.tencent.mobileqq.wink.aiavatar.base.a.f317690a;
            View view = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
            aVar.l(view, str, str3, str4);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: k0, reason: merged with bridge method [inline-methods] */
        public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View itemView = LayoutInflater.from(parent.getContext()).inflate(i0(viewType), parent, false);
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            return new b(itemView, viewType);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: l0, reason: merged with bridge method [inline-methods] */
        public void onViewRecycled(@NotNull b holder) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            super.onViewRecycled(holder);
            holder.t(null);
        }

        public final void m0(@Nullable MetaCategory category) {
            if (category != null) {
                this.category = category;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\f\u0010\b\u001a\u00020\u0007*\u00020\u0006H\u0002J\f\u0010\t\u001a\u00020\u0007*\u00020\u0006H\u0002J\u001c\u0010\r\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010\u0011\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u0002R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010 R$\u0010)\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/mainpage/view/WinkAIAvatarGroupLayout$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "viewType", "", ReportConstant.COSTREPORT_PREFIX, "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "Landroid/widget/ImageView;", "view", "url", "u", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "category", "position", "o", "E", "I", "getViewType", "()I", "Lcom/tencent/mobileqq/wink/view/WinkRoundedCornerImageView;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/wink/view/WinkRoundedCornerImageView;", "coverView", "G", "secondCoverView", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "nameTextView", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "Landroid/graphics/drawable/Drawable;", "J", "Landroid/graphics/drawable/Drawable;", "getApngDrawable", "()Landroid/graphics/drawable/Drawable;", "t", "(Landroid/graphics/drawable/Drawable;)V", "apngDrawable", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;I)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final int viewType;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final WinkRoundedCornerImageView coverView;

        /* renamed from: G, reason: from kotlin metadata */
        @Nullable
        private final WinkRoundedCornerImageView secondCoverView;

        /* renamed from: H, reason: from kotlin metadata */
        @Nullable
        private final TextView nameTextView;

        /* renamed from: I, reason: from kotlin metadata */
        @Nullable
        private MetaMaterial material;

        /* renamed from: J, reason: from kotlin metadata */
        @Nullable
        private Drawable apngDrawable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View itemView, int i3) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.viewType = i3;
            View findViewById = itemView.findViewById(R.id.f122487e3);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026ink_ai_avatar_item_cover)");
            this.coverView = (WinkRoundedCornerImageView) findViewById;
            this.secondCoverView = (WinkRoundedCornerImageView) itemView.findViewById(R.id.f122517e6);
            this.nameTextView = (TextView) itemView.findViewById(R.id.f122497e4);
            s(i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void p(b this$0, MetaCategory metaCategory, View view) {
            String str;
            String str2;
            boolean z16;
            WinkRoundedCornerImageView[] winkRoundedCornerImageViewArr;
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            MetaMaterial metaMaterial = this$0.material;
            if (metaMaterial != null) {
                String str3 = null;
                if (metaCategory != null) {
                    str = metaCategory.name;
                } else {
                    str = null;
                }
                String str4 = "";
                if (str == null) {
                    str = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str, "category?.name ?: \"\"");
                }
                MetaMaterial finalMaterial = metaMaterial.copy();
                Intrinsics.checkNotNullExpressionValue(finalMaterial, "bind$lambda$6$lambda$5$lambda$3");
                if (metaCategory != null) {
                    str2 = metaCategory.f30532id;
                } else {
                    str2 = null;
                }
                if (str2 == null) {
                    str2 = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str2, "category?.id ?: \"\"");
                }
                c.o1(finalMaterial, str2);
                WinkAIAvatarUtils winkAIAvatarUtils = WinkAIAvatarUtils.f317678a;
                String j3 = winkAIAvatarUtils.j(metaMaterial);
                if (j3.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    if (metaCategory != null) {
                        str3 = metaCategory.f30532id;
                    }
                    if (str3 != null) {
                        Intrinsics.checkNotNullExpressionValue(str3, "category?.id ?: \"\"");
                        str4 = str3;
                    }
                    j3 = str4;
                }
                winkAIAvatarUtils.z(finalMaterial, j3);
                WinkRoundedCornerImageView winkRoundedCornerImageView = this$0.secondCoverView;
                if (winkRoundedCornerImageView != null) {
                    winkRoundedCornerImageViewArr = new WinkRoundedCornerImageView[]{this$0.coverView, winkRoundedCornerImageView};
                } else {
                    winkRoundedCornerImageViewArr = new WinkRoundedCornerImageView[]{this$0.coverView};
                }
                Context context = this$0.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                Intrinsics.checkNotNullExpressionValue(finalMaterial, "finalMaterial");
                winkAIAvatarUtils.s(context, finalMaterial, winkRoundedCornerImageViewArr, "0");
                com.tencent.mobileqq.wink.aiavatar.base.a aVar = com.tencent.mobileqq.wink.aiavatar.base.a.f317690a;
                View itemView = this$0.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                String str5 = finalMaterial.f30533id;
                Intrinsics.checkNotNullExpressionValue(str5, "finalMaterial.id");
                aVar.k(itemView, str5, str);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        private final String q(MetaMaterial metaMaterial) {
            String str;
            boolean z16;
            if (this.viewType == 4) {
                str = c.w0(metaMaterial, "first_dynamic_cover_url");
            } else {
                str = "";
            }
            if (str.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return c.w0(metaMaterial, "first_cover_url");
            }
            return str;
        }

        private final String r(MetaMaterial metaMaterial) {
            return c.w0(metaMaterial, "second_cover_url");
        }

        private final void s(int viewType) {
            if (viewType != 2) {
                if (viewType != 3) {
                    if (viewType != 4) {
                        if (viewType == 5) {
                            ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
                            o53.h hVar = o53.h.f422138a;
                            layoutParams.width = hVar.r(this.itemView.getContext());
                            layoutParams.height = hVar.q(this.itemView.getContext());
                            this.itemView.setLayoutParams(layoutParams);
                            return;
                        }
                        return;
                    }
                    ViewGroup.LayoutParams layoutParams2 = this.itemView.getLayoutParams();
                    o53.h hVar2 = o53.h.f422138a;
                    layoutParams2.width = hVar2.d(this.itemView.getContext());
                    layoutParams2.height = hVar2.c(this.itemView.getContext());
                    this.itemView.setLayoutParams(layoutParams2);
                    return;
                }
                ViewGroup.LayoutParams layoutParams3 = this.itemView.getLayoutParams();
                o53.h hVar3 = o53.h.f422138a;
                layoutParams3.width = hVar3.g(this.itemView.getContext());
                layoutParams3.height = hVar3.f(this.itemView.getContext());
                this.itemView.setLayoutParams(layoutParams3);
                return;
            }
            ViewGroup.LayoutParams layoutParams4 = this.itemView.getLayoutParams();
            o53.h hVar4 = o53.h.f422138a;
            int i3 = hVar4.i(this.itemView.getContext());
            layoutParams4.width = i3;
            layoutParams4.height = hVar4.h(this.itemView.getContext());
            this.coverView.getLayoutParams().width = i3;
            this.coverView.getLayoutParams().height = i3;
            this.itemView.setLayoutParams(layoutParams4);
        }

        private final void u(final ImageView view, final String url) {
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: o53.c
                @Override // java.lang.Runnable
                public final void run() {
                    WinkAIAvatarGroupLayout.b.v(view, url, this);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void v(ImageView imageView, String str, final b this$0) {
            boolean z16;
            boolean z17;
            int dpToPx;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (imageView != null) {
                if (str != null && str.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    WinkRoundedCornerImageView winkRoundedCornerImageView = this$0.secondCoverView;
                    if (winkRoundedCornerImageView != null && winkRoundedCornerImageView.getVisibility() == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        dpToPx = ImmersiveUtils.dpToPx(178.0f);
                    } else {
                        dpToPx = ImmersiveUtils.dpToPx(325.0f);
                    }
                    final Option url = Option.obtain().setTargetView(imageView).setRequestWidth(dpToPx).setRequestHeight(dpToPx).setUrl(str);
                    url.setLoadingDrawable(new ColorDrawable(0));
                    url.setFailedDrawable(new ColorDrawable(0));
                    Set set = WinkAIAvatarGroupLayout.I;
                    String MODEL = DeviceInfoMonitor.getModel();
                    Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                    String upperCase = MODEL.toUpperCase();
                    Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase()");
                    if (set.contains(upperCase)) {
                        url.setPreferDecoder(com.tencent.qqnt.emotion.pic.libra.d.class);
                    } else {
                        url.setPreferDecoder(z01.b.class);
                    }
                    QQPicLoader.f201806a.d().loadImage(url, new IPicLoadStateListener() { // from class: o53.d
                        @Override // com.tencent.libra.listener.IPicLoadStateListener
                        public final void onStateChange(LoadState loadState, Option option) {
                            WinkAIAvatarGroupLayout.b.w(WinkAIAvatarGroupLayout.b.this, url, loadState, option);
                        }
                    });
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void w(b this$0, Option option, LoadState loadState, Option option2) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (loadState.isFinishSuccess()) {
                if (option2.getAnimatable() instanceof com.tencent.qqnt.emotion.pic.libra.b) {
                    Animatable animatable = option.getAnimatable();
                    Intrinsics.checkNotNull(animatable, "null cannot be cast to non-null type com.tencent.qqnt.emotion.pic.libra.ApngDrawable");
                    com.tencent.qqnt.emotion.pic.libra.b bVar = (com.tencent.qqnt.emotion.pic.libra.b) animatable;
                    this$0.apngDrawable = bVar;
                    Intrinsics.checkNotNull(bVar, "null cannot be cast to non-null type com.tencent.qqnt.emotion.pic.libra.ApngDrawable");
                    bVar.start();
                    return;
                }
                if (option.getAnimatable() instanceof z01.a) {
                    Animatable animatable2 = option.getAnimatable();
                    Intrinsics.checkNotNull(animatable2, "null cannot be cast to non-null type com.tencent.libra.extension.apng.APNGDrawable");
                    z01.a aVar = (z01.a) animatable2;
                    this$0.apngDrawable = aVar;
                    Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.libra.extension.apng.APNGDrawable");
                    aVar.start();
                    return;
                }
                return;
            }
            if (loadState == LoadState.STATE_DOWNLOAD_FAILED || loadState == LoadState.STATE_DECODE_FAILED) {
                QLog.e("WinkAIAvatarGroupLayout", 1, "updateImageView state:" + loadState + "  listenerOption:" + option2);
            }
        }

        public final void o(@Nullable final MetaCategory category, int position) {
            MetaMaterial metaMaterial;
            String str;
            String str2;
            ArrayList<MetaMaterial> arrayList;
            String str3 = null;
            if (category != null && (arrayList = category.materials) != null) {
                metaMaterial = arrayList.get(position);
            } else {
                metaMaterial = null;
            }
            this.material = metaMaterial;
            TextView textView = this.nameTextView;
            if (textView != null) {
                if (metaMaterial != null) {
                    str2 = c.a0(metaMaterial);
                } else {
                    str2 = null;
                }
                textView.setText(str2);
            }
            WinkRoundedCornerImageView winkRoundedCornerImageView = this.coverView;
            MetaMaterial metaMaterial2 = this.material;
            if (metaMaterial2 != null) {
                str = q(metaMaterial2);
            } else {
                str = null;
            }
            u(winkRoundedCornerImageView, str);
            WinkRoundedCornerImageView winkRoundedCornerImageView2 = this.secondCoverView;
            if (winkRoundedCornerImageView2 != null) {
                MetaMaterial metaMaterial3 = this.material;
                if (metaMaterial3 != null) {
                    str3 = r(metaMaterial3);
                }
                u(winkRoundedCornerImageView2, str3);
            }
            this.coverView.setTransitionName("previewFirst");
            WinkRoundedCornerImageView winkRoundedCornerImageView3 = this.secondCoverView;
            if (winkRoundedCornerImageView3 != null) {
                winkRoundedCornerImageView3.setTransitionName("previewSecond");
            }
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: o53.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkAIAvatarGroupLayout.b.p(WinkAIAvatarGroupLayout.b.this, category, view);
                }
            });
        }

        public final void t(@Nullable Drawable drawable) {
            this.apngDrawable = drawable;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/mainpage/view/WinkAIAvatarGroupLayout$d;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "", "d", "I", "orientation", "<init>", "(I)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int orientation;

        public d(int i3) {
            this.orientation = i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            if (this.orientation == 0) {
                if (parent.getChildAdapterPosition(view) == 0) {
                    outRect.left = ImmersiveUtils.dpToPx(16.0f);
                } else {
                    outRect.left = ImmersiveUtils.dpToPx(3.0f);
                }
            } else {
                outRect.left = ImmersiveUtils.dpToPx(3.0f);
            }
            outRect.right = ImmersiveUtils.dpToPx(3.0f);
            outRect.bottom = ImmersiveUtils.dpToPx(10.0f);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/wink/aiavatar/mainpage/view/WinkAIAvatarGroupLayout$e", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", "position", "getSpanSize", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e extends GridLayoutManager.SpanSizeLookup {
        e() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int position) {
            if (WinkAIAvatarGroupLayout.this.groupType == 1 && position == 0) {
                return WinkAIAvatarGroupLayout.this.gridSpanCount;
            }
            return 1;
        }
    }

    static {
        Set<String> of5;
        of5 = SetsKt__SetsKt.setOf((Object[]) new String[]{"FRD-L19", "FRD-L14", "FRD-L04", "FRD-AL00", "FRD-TL00", "FRD-AL10", "FRD-L09", "FRD-L02", "FRD-L19", "FRD-L14", "FRD-DL00", "BKL-AL20", "BKL-L04", "BKL-L09", "BKL-AL00"});
        I = of5;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkAIAvatarGroupLayout(@NotNull Context context, int i3) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.G = new LinkedHashMap();
        this.groupType = i3;
        this.orientation = 1;
        this.gridSpanCount = 1;
        this.parentCategoryId = "";
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(WinkAIAvatarGroupLayout this$0, MetaCategory category) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(category, "$category");
        TextView textView = this$0.groupName;
        if (textView != null) {
            textView.setText(category.name);
        }
        this$0.j(category);
    }

    private final void h() {
        ViewGroup.LayoutParams layoutParams;
        DefaultItemAnimator defaultItemAnimator;
        ViewGroup.LayoutParams layoutParams2;
        int i3 = 1;
        LayoutInflater.from(getContext()).inflate(R.layout.i4l, (ViewGroup) this, true);
        this.groupName = (TextView) findViewById(R.id.f122457e0);
        this.groupIcon = (RelativeLayout) findViewById(R.id.f122437dy);
        this.iconText = (TextView) findViewById(R.id.f122447dz);
        this.recyclerview = (RecyclerView) findViewById(R.id.f122467e1);
        int i16 = this.groupType;
        SimpleItemAnimator simpleItemAnimator = null;
        if (i16 != 0 && i16 != 1) {
            int dpToPx = ViewUtils.dpToPx(13.0f);
            setPadding(dpToPx, 0, dpToPx, 0);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.f122477e2);
            if (linearLayout != null) {
                layoutParams2 = linearLayout.getLayoutParams();
            } else {
                layoutParams2 = null;
            }
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) layoutParams2;
            layoutParams3.setMarginStart(ViewUtils.dpToPx(3.0f));
            linearLayout.setLayoutParams(layoutParams3);
        } else {
            LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.f122477e2);
            if (linearLayout2 != null) {
                layoutParams = linearLayout2.getLayoutParams();
            } else {
                layoutParams = null;
            }
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams;
            layoutParams4.setMarginStart(ViewUtils.dpToPx(16.0f));
            linearLayout2.setLayoutParams(layoutParams4);
            i3 = 0;
        }
        this.orientation = i3;
        k();
        RecyclerView recyclerView = this.recyclerview;
        if (recyclerView != null) {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), this.gridSpanCount, this.orientation, false);
            gridLayoutManager.setSpanSizeLookup(new e());
            recyclerView.setLayoutManager(gridLayoutManager);
        }
        RecyclerView recyclerView2 = this.recyclerview;
        if (recyclerView2 != null) {
            recyclerView2.setItemAnimator(null);
        }
        RecyclerView recyclerView3 = this.recyclerview;
        if (recyclerView3 != null) {
            a aVar = new a(this.parentCategoryId, null, this.groupType);
            this.adapter = aVar;
            recyclerView3.setAdapter(aVar);
            RecyclerView.ItemAnimator itemAnimator = recyclerView3.getItemAnimator();
            if (itemAnimator instanceof DefaultItemAnimator) {
                defaultItemAnimator = (DefaultItemAnimator) itemAnimator;
            } else {
                defaultItemAnimator = null;
            }
            if (defaultItemAnimator != null) {
                defaultItemAnimator.setSupportsChangeAnimations(false);
            }
            RecyclerView.ItemAnimator itemAnimator2 = recyclerView3.getItemAnimator();
            if (itemAnimator2 instanceof SimpleItemAnimator) {
                simpleItemAnimator = (SimpleItemAnimator) itemAnimator2;
            }
            if (simpleItemAnimator != null) {
                simpleItemAnimator.setSupportsChangeAnimations(false);
            }
            RecyclerView.ItemAnimator itemAnimator3 = recyclerView3.getItemAnimator();
            if (itemAnimator3 != null) {
                itemAnimator3.setChangeDuration(0L);
            }
            recyclerView3.addItemDecoration(new d(this.orientation));
        }
    }

    private final void j(MetaCategory category) {
        boolean z16;
        if (category.materials.size() <= 0) {
            return;
        }
        String f16 = com.tencent.mobileqq.wink.editor.b.f(category, "hotTextContent");
        if (f16.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            TextView textView = this.iconText;
            if (textView != null) {
                textView.setText(f16);
            }
            RelativeLayout relativeLayout = this.groupIcon;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
        }
        a aVar = this.adapter;
        if (aVar != null) {
            aVar.m0(category);
        }
        a aVar2 = this.adapter;
        if (aVar2 != null) {
            aVar2.notifyDataSetChanged();
        }
    }

    private final void k() {
        int i3;
        int i16 = this.groupType;
        if (i16 != 2 && i16 != 0) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        this.gridSpanCount = i3;
        o53.h hVar = o53.h.f422138a;
        if (hVar.z(getContext()) && hVar.y()) {
            int i17 = this.groupType;
            if (i17 == 2 || i17 == 3) {
                this.gridSpanCount *= 2;
            }
        }
    }

    public final void e(@Nullable String parentCategoryId, @NotNull final MetaCategory category) {
        Intrinsics.checkNotNullParameter(category, "category");
        w53.b.f("WinkAIAvatarGroupLayout", "[bindData] ==> " + category.materials.size());
        if (parentCategoryId == null) {
            parentCategoryId = "";
        }
        this.parentCategoryId = parentCategoryId;
        this.category = category;
        post(new Runnable() { // from class: o53.a
            @Override // java.lang.Runnable
            public final void run() {
                WinkAIAvatarGroupLayout.f(WinkAIAvatarGroupLayout.this, category);
            }
        });
    }

    public final void g() {
        RecyclerView recyclerView = this.recyclerview;
        if (recyclerView != null) {
            recyclerView.setNestedScrollingEnabled(false);
        }
    }

    public final void i(@Nullable Integer targetItemPosition) {
        if (targetItemPosition != null) {
            int intValue = targetItemPosition.intValue();
            RecyclerView recyclerView = this.recyclerview;
            if (recyclerView != null) {
                recyclerView.scrollToPosition(intValue);
            }
        }
    }
}
