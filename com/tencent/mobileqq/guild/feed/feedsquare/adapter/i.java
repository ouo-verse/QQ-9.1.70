package com.tencent.mobileqq.guild.feed.feedsquare.adapter;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import ij1.GuildFeedsHeaderData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\"#B\u0019\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0016J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\u0014\u001a\u00020\u00112\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/i;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/i$b;", "Ltj1/a;", "", "position", "getItemViewType", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "Lij1/d;", "getData", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "k0", "getItemCount", "holder", "", "j0", "data", "l0", "Landroidx/fragment/app/FragmentManager;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Landroid/os/Bundle;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/os/Bundle;", "extras", "D", "Landroidx/lifecycle/MutableLiveData;", "<init>", "(Landroidx/fragment/app/FragmentManager;Landroid/os/Bundle;)V", "E", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class i extends RecyclerView.Adapter<b> implements tj1.a {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private final Bundle extras;

    /* renamed from: D, reason: from kotlin metadata */
    private MutableLiveData<UIStateData<GuildFeedsHeaderData>> data;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FragmentManager fragmentManager;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/i$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/adapter/i$c", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements View.OnAttachStateChangeListener {
        c() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@Nullable View v3) {
            QLog.i("GuildFeedSquareHeaderAdapter", 1, "[onCreateViewHolder]register IFeedsHeaderDataSource");
            RFWIocAbilityProvider.g().registerIoc(v3, i.this, tj1.a.class);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@Nullable View v3) {
            QLog.i("GuildFeedSquareHeaderAdapter", 1, "[onCreateViewHolder]unregister IFeedsHeaderDataSource");
            RFWIocAbilityProvider.g().unregisterSingleIoc(v3, tj1.a.class);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007\u00b8\u0006\u0000"}, d2 = {"androidx/core/view/ViewKt$doOnAttach$1", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "view", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "core-ktx_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements View.OnAttachStateChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f218725d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ i f218726e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ FrameLayout f218727f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Fragment f218728h;

        public d(View view, i iVar, FrameLayout frameLayout, Fragment fragment) {
            this.f218725d = view;
            this.f218726e = iVar;
            this.f218727f = frameLayout;
            this.f218728h = fragment;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.f218725d.removeOnAttachStateChangeListener(this);
            if (this.f218726e.fragmentManager.findFragmentById(this.f218727f.getId()) == null) {
                try {
                    this.f218726e.fragmentManager.beginTransaction().replace(this.f218727f.getId(), this.f218728h).commitNowAllowingStateLoss();
                } catch (Exception e16) {
                    QLog.e("GuildFeedSquareHeaderAdapter", 1, "launch fail: " + e16);
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    public i(@NotNull FragmentManager fragmentManager, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        this.fragmentManager = fragmentManager;
        this.extras = bundle;
    }

    @Override // tj1.a
    @NotNull
    public MutableLiveData<UIStateData<GuildFeedsHeaderData>> getData() {
        MutableLiveData<UIStateData<GuildFeedsHeaderData>> mutableLiveData = this.data;
        if (mutableLiveData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
            return null;
        }
        return mutableLiveData;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        MutableLiveData<UIStateData<GuildFeedsHeaderData>> mutableLiveData = this.data;
        if (mutableLiveData != null) {
            GuildFeedsHeaderData guildFeedsHeaderData = null;
            if (mutableLiveData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("data");
                mutableLiveData = null;
            }
            UIStateData<GuildFeedsHeaderData> value = mutableLiveData.getValue();
            if (value != null) {
                guildFeedsHeaderData = value.getData();
            }
            if (guildFeedsHeaderData != null) {
                return 1;
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return 18;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull b holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Fragment createFeedTopFragment = ((IGuildFeedLauncherApi) QRoute.api(IGuildFeedLauncherApi.class)).createFeedTopFragment(this.extras);
        FrameLayout frameLayout = new FrameLayout(parent.getContext());
        frameLayout.setId(R.id.wf7);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        frameLayout.addOnAttachStateChangeListener(new c());
        if (ViewCompat.isAttachedToWindow(frameLayout)) {
            if (this.fragmentManager.findFragmentById(frameLayout.getId()) == null) {
                try {
                    this.fragmentManager.beginTransaction().replace(frameLayout.getId(), createFeedTopFragment).commitNowAllowingStateLoss();
                } catch (Exception e16) {
                    QLog.e("GuildFeedSquareHeaderAdapter", 1, "launch fail: " + e16);
                }
            }
        } else {
            frameLayout.addOnAttachStateChangeListener(new d(frameLayout, this, frameLayout, createFeedTopFragment));
        }
        return new b(frameLayout);
    }

    public final void l0(@NotNull MutableLiveData<UIStateData<GuildFeedsHeaderData>> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        notifyDataSetChanged();
    }
}
