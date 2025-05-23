package com.tencent.mobileqq.wink.aiavatar.mainpage.view;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import com.tencent.mobileqq.wink.aiavatar.mainpage.view.WinkAIAvatarStyleListFragment;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment;
import com.tencent.videocut.utils.LiveDataExtKt;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import o53.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ,2\u00020\u0001:\u0004-./0B\u0007\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0006\u0010\u000f\u001a\u00020\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010%\u001a\b\u0018\u00010\"R\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/mainpage/view/WinkAIAvatarStyleListFragment;", "Landroidx/fragment/app/Fragment;", "", "th", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "sh", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "onDestroyView", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", BdhLogUtil.LogTag.Tag_Conn, "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "category", "", "D", "Ljava/lang/Integer;", "targetGroupPosition", "E", "targetItemPosition", "Landroidx/recyclerview/widget/RecyclerView;", UserInfo.SEX_FEMALE, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerview", "Lcom/tencent/mobileqq/wink/aiavatar/mainpage/view/WinkAIAvatarStyleListFragment$c;", "G", "Lcom/tencent/mobileqq/wink/aiavatar/mainpage/view/WinkAIAvatarStyleListFragment$c;", "adapter", "Landroidx/recyclerview/widget/LinearLayoutManager;", "H", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "<init>", "()V", "J", "a", "b", "c", "d", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkAIAvatarStyleListFragment extends ReportAndroidXFragment {

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private MetaCategory category;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Integer targetGroupPosition;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Integer targetItemPosition;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private RecyclerView recyclerview;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private c adapter;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private LinearLayoutManager layoutManager;

    @NotNull
    public Map<Integer, View> I = new LinkedHashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/mainpage/view/WinkAIAvatarStyleListFragment$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            ViewGroup.LayoutParams layoutParams = itemView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = ImmersiveUtils.dpToPx(18.0f);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/mainpage/view/WinkAIAvatarStyleListFragment$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "subCategory", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/mobileqq/wink/aiavatar/mainpage/view/WinkAIAvatarStyleListFragment;Landroid/view/View;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public final class b extends RecyclerView.ViewHolder {
        final /* synthetic */ WinkAIAvatarStyleListFragment E;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull WinkAIAvatarStyleListFragment winkAIAvatarStyleListFragment, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.E = winkAIAvatarStyleListFragment;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(b this$0, WinkAIAvatarStyleListFragment this$1, MetaCategory metaCategory) {
            WinkAIAvatarGroupLayout winkAIAvatarGroupLayout;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            View view = this$0.itemView;
            String str = null;
            if (view instanceof WinkAIAvatarGroupLayout) {
                winkAIAvatarGroupLayout = (WinkAIAvatarGroupLayout) view;
            } else {
                winkAIAvatarGroupLayout = null;
            }
            if (winkAIAvatarGroupLayout != null) {
                MetaCategory metaCategory2 = this$1.category;
                if (metaCategory2 != null) {
                    str = metaCategory2.f30532id;
                }
                winkAIAvatarGroupLayout.e(str, metaCategory);
            }
        }

        public final void m(@Nullable final MetaCategory subCategory) {
            if (subCategory != null) {
                final WinkAIAvatarStyleListFragment winkAIAvatarStyleListFragment = this.E;
                ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: o53.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkAIAvatarStyleListFragment.b.n(WinkAIAvatarStyleListFragment.b.this, winkAIAvatarStyleListFragment, subCategory);
                    }
                });
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0006\u0010\u0011\u001a\u00020\u000eR\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/mainpage/view/WinkAIAvatarStyleListFragment$c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "category", "", "j0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "onCreateViewHolder", "getItemCount", "holder", "position", "", "onBindViewHolder", "getItemViewType", "k0", "Landroidx/lifecycle/LifecycleOwner;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroidx/lifecycle/MutableLiveData;", "Landroid/view/View;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "targetItemView", "<init>", "(Lcom/tencent/mobileqq/wink/aiavatar/mainpage/view/WinkAIAvatarStyleListFragment;Landroidx/lifecycle/LifecycleOwner;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public final class c extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* renamed from: C, reason: from kotlin metadata */
        @NotNull
        private MutableLiveData<View> targetItemView;
        final /* synthetic */ WinkAIAvatarStyleListFragment D;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final LifecycleOwner lifecycleOwner;

        public c(@NotNull WinkAIAvatarStyleListFragment winkAIAvatarStyleListFragment, LifecycleOwner lifecycleOwner) {
            Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
            this.D = winkAIAvatarStyleListFragment;
            this.lifecycleOwner = lifecycleOwner;
            this.targetItemView = new MutableLiveData<>();
        }

        private final int j0(MetaCategory category) {
            ArrayList<MetaMaterial> arrayList;
            MetaMaterial metaMaterial;
            if (category == null || (arrayList = category.materials) == null || (metaMaterial = arrayList.get(0)) == null || !com.tencent.mobileqq.wink.editor.c.Z0(metaMaterial)) {
                return 3;
            }
            return 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void l0(WinkAIAvatarStyleListFragment this$0, View view) {
            WinkAIAvatarGroupLayout winkAIAvatarGroupLayout;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (view instanceof WinkAIAvatarGroupLayout) {
                winkAIAvatarGroupLayout = (WinkAIAvatarGroupLayout) view;
            } else {
                winkAIAvatarGroupLayout = null;
            }
            if (winkAIAvatarGroupLayout != null) {
                winkAIAvatarGroupLayout.i(this$0.targetItemPosition);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            int i3;
            ArrayList<MetaCategory> arrayList;
            MetaCategory metaCategory = this.D.category;
            if (metaCategory != null && (arrayList = metaCategory.subCategories) != null) {
                i3 = arrayList.size();
            } else {
                i3 = 0;
            }
            return i3 + 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            boolean z16;
            boolean z17;
            MetaCategory metaCategory;
            ArrayList<MetaCategory> arrayList;
            ArrayList<MetaCategory> arrayList2;
            ArrayList<MetaCategory> arrayList3;
            MetaCategory metaCategory2 = this.D.category;
            if (metaCategory2 != null && (arrayList3 = metaCategory2.subCategories) != null && arrayList3.size() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                MetaCategory metaCategory3 = this.D.category;
                if (metaCategory3 != null && (arrayList2 = metaCategory3.subCategories) != null && position == arrayList2.size()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    MetaCategory metaCategory4 = this.D.category;
                    String str = null;
                    if (metaCategory4 != null && (arrayList = metaCategory4.subCategories) != null) {
                        metaCategory = arrayList.get(position);
                    } else {
                        metaCategory = null;
                    }
                    if (metaCategory != null) {
                        str = com.tencent.mobileqq.wink.editor.b.f(metaCategory, NotifyMsgApiImpl.KEY_GROUP_TYPE);
                    }
                    if (Intrinsics.areEqual(str, "horizontalBanner")) {
                        return 1;
                    }
                    if (Intrinsics.areEqual(str, "horizontal")) {
                        return 0;
                    }
                    return j0(metaCategory);
                }
                return 4;
            }
            return 4;
        }

        public final void k0() {
            WinkAIAvatarGroupLayout winkAIAvatarGroupLayout;
            if (this.targetItemView.getValue() != null) {
                View value = this.targetItemView.getValue();
                if (value instanceof WinkAIAvatarGroupLayout) {
                    winkAIAvatarGroupLayout = (WinkAIAvatarGroupLayout) value;
                } else {
                    winkAIAvatarGroupLayout = null;
                }
                if (winkAIAvatarGroupLayout != null) {
                    winkAIAvatarGroupLayout.i(this.D.targetItemPosition);
                    return;
                }
                return;
            }
            MutableLiveData<View> mutableLiveData = this.targetItemView;
            LifecycleOwner lifecycleOwner = this.lifecycleOwner;
            final WinkAIAvatarStyleListFragment winkAIAvatarStyleListFragment = this.D;
            LiveDataExtKt.a(mutableLiveData, lifecycleOwner, new Observer() { // from class: o53.g
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkAIAvatarStyleListFragment.c.l0(WinkAIAvatarStyleListFragment.this, (View) obj);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
            b bVar;
            ArrayList<MetaCategory> arrayList;
            Integer num;
            Intrinsics.checkNotNullParameter(holder, "holder");
            if (this.D.targetGroupPosition != null && (num = this.D.targetGroupPosition) != null && position == num.intValue()) {
                this.targetItemView.postValue(holder.itemView);
            }
            MetaCategory metaCategory = null;
            if (holder instanceof b) {
                bVar = (b) holder;
            } else {
                bVar = null;
            }
            if (bVar != null) {
                MetaCategory metaCategory2 = this.D.category;
                if (metaCategory2 != null && (arrayList = metaCategory2.subCategories) != null) {
                    metaCategory = arrayList.get(position);
                }
                bVar.m(metaCategory);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            View itemView;
            Intrinsics.checkNotNullParameter(parent, "parent");
            if (viewType == 4) {
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.i4t, parent, false);
            } else {
                Context context = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "parent.context");
                itemView = new WinkAIAvatarGroupLayout(context, viewType);
            }
            itemView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
            if (viewType == 4) {
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                return new a(itemView);
            }
            WinkAIAvatarStyleListFragment winkAIAvatarStyleListFragment = this.D;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            return new b(winkAIAvatarStyleListFragment, itemView);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J/\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\fR\u0014\u0010\u0012\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\fR\u0014\u0010\u0013\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\fR\u0014\u0010\u0014\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/mainpage/view/WinkAIAvatarStyleListFragment$d;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "category", "", "targetGroupPosition", "targetItemPosition", "Lcom/tencent/mobileqq/wink/aiavatar/mainpage/view/WinkAIAvatarStyleListFragment;", "a", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/tencent/mobileqq/wink/aiavatar/mainpage/view/WinkAIAvatarStyleListFragment;", "", "ARG_CATEGORY", "Ljava/lang/String;", "ARG_TARGET_GROUP_POSITION", "ARG_TARGET_ITEM_POSITION", "SUBCATEGORY_GROUP_HORIZONTAL", "SUBCATEGORY_GROUP_HORIZONTAL_BANNER", "SUBCATEGORY_GROUP_TYPE", "SUBCATEGORY_GROUP_VERTICAL", "SUBCATEGORY_ID_ALL_AVATAR", "TAG", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.aiavatar.mainpage.view.WinkAIAvatarStyleListFragment$d, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final WinkAIAvatarStyleListFragment a(@Nullable MetaCategory category, @Nullable Integer targetGroupPosition, @Nullable Integer targetItemPosition) {
            int i3;
            WinkAIAvatarStyleListFragment winkAIAvatarStyleListFragment = new WinkAIAvatarStyleListFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("category", category);
            int i16 = -1;
            if (targetGroupPosition != null) {
                i3 = targetGroupPosition.intValue();
            } else {
                i3 = -1;
            }
            bundle.putInt("target_group_position", i3);
            if (targetItemPosition != null) {
                i16 = targetItemPosition.intValue();
            }
            bundle.putInt("target_item_position", i16);
            winkAIAvatarStyleListFragment.setArguments(bundle);
            return winkAIAvatarStyleListFragment;
        }

        Companion() {
        }
    }

    private final void th() {
        RecyclerView.Adapter adapter;
        h hVar = h.f422138a;
        if (hVar.z(getActivity()) || hVar.w(getActivity())) {
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
            c cVar = new c(this, viewLifecycleOwner);
            this.adapter = cVar;
            RecyclerView recyclerView = this.recyclerview;
            if (recyclerView != null) {
                recyclerView.setAdapter(cVar);
            }
        }
        RecyclerView recyclerView2 = this.recyclerview;
        if (recyclerView2 != null && (adapter = recyclerView2.getAdapter()) != null) {
            adapter.notifyDataSetChanged();
        }
        RecyclerView recyclerView3 = this.recyclerview;
        if (recyclerView3 != null) {
            recyclerView3.invalidate();
        }
        RecyclerView recyclerView4 = this.recyclerview;
        if (recyclerView4 != null) {
            recyclerView4.requestLayout();
        }
    }

    public void _$_clearFindViewByIdCache() {
        this.I.clear();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        th();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        MetaCategory metaCategory;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            Serializable serializable = arguments.getSerializable("category");
            if (serializable instanceof MetaCategory) {
                metaCategory = (MetaCategory) serializable;
            } else {
                metaCategory = null;
            }
            this.category = metaCategory;
            this.targetGroupPosition = Integer.valueOf(arguments.getInt("target_group_position"));
            this.targetItemPosition = Integer.valueOf(arguments.getInt("target_item_position"));
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.i4v, container, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        RecyclerView recyclerView = this.recyclerview;
        if (recyclerView != null) {
            recyclerView.setAdapter(null);
        }
        RecyclerView recyclerView2 = this.recyclerview;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(null);
        }
        this.recyclerview = null;
        _$_clearFindViewByIdCache();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        DefaultItemAnimator defaultItemAnimator;
        Intrinsics.checkNotNullParameter(view, "view");
        this.recyclerview = (RecyclerView) view.findViewById(R.id.f122507e5);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 1, false);
        this.layoutManager = linearLayoutManager;
        RecyclerView recyclerView = this.recyclerview;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        RecyclerView recyclerView2 = this.recyclerview;
        SimpleItemAnimator simpleItemAnimator = null;
        if (recyclerView2 != null) {
            recyclerView2.setItemAnimator(null);
        }
        RecyclerView recyclerView3 = this.recyclerview;
        if (recyclerView3 != null) {
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
            c cVar = new c(this, viewLifecycleOwner);
            this.adapter = cVar;
            recyclerView3.setAdapter(cVar);
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
        }
    }

    public final void sh() {
        Integer num = this.targetGroupPosition;
        if (num != null) {
            int intValue = num.intValue();
            RecyclerView recyclerView = this.recyclerview;
            if (recyclerView != null) {
                recyclerView.scrollToPosition(intValue);
            }
            c cVar = this.adapter;
            if (cVar != null) {
                cVar.k0();
            }
        }
    }
}
