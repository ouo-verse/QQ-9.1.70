package com.tencent.mobileqq.troop.troopcard.reborn.essence;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.troopcard.reborn.essence.TroopEssenceFileTabFragment;
import com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel;
import com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopFileViewModel;
import com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopInfoCardEssenceViewModel;
import com.tencent.mobileqq.troop.troopcard.utils.TroopCardDtHelper;
import com.tencent.mobileqq.utils.TriggerRunnerKt;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.am;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.util.LoadingUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 +2\u00020\u0001:\u0004,-./B\u0007\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\f\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0016J\u001a\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceFileTabFragment;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceTabBaseFragment;", "", "initViewModel", "Dh", "Hh", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "ph", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopFileViewModel;", "D", "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopFileViewModel;", "viewModel", "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopInfoCardEssenceViewModel;", "E", "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopInfoCardEssenceViewModel;", "troopInfoCardEssenceViewModel", "Landroid/widget/LinearLayout;", UserInfo.SEX_FEMALE, "Landroid/widget/LinearLayout;", "loadMoreView", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "loadMoreText", "", "H", "Ljava/lang/String;", WadlProxyConsts.KEY_JUMP_URL, "", "I", "Z", "isInitialized", "Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceFileTabFragment$b;", "J", "Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceFileTabFragment$b;", "adapter", "<init>", "()V", "K", "a", "b", "c", "d", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopEssenceFileTabFragment extends TroopEssenceTabBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: D, reason: from kotlin metadata */
    private TroopFileViewModel viewModel;

    /* renamed from: E, reason: from kotlin metadata */
    private TroopInfoCardEssenceViewModel troopInfoCardEssenceViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    private LinearLayout loadMoreView;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView loadMoreText;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String jumpUrl;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isInitialized;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final b adapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceFileTabFragment$a;", "", "", "isInitialized", "Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceFileTabFragment;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopcard.reborn.essence.TroopEssenceFileTabFragment$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final TroopEssenceFileTabFragment a(boolean isInitialized) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TroopEssenceFileTabFragment) iPatchRedirector.redirect((short) 2, (Object) this, isInitialized);
            }
            TroopEssenceFileTabFragment troopEssenceFileTabFragment = new TroopEssenceFileTabFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("isInitialized", isInitialized);
            troopEssenceFileTabFragment.setArguments(bundle);
            return troopEssenceFileTabFragment;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0017\b\u0002\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0014\u0010\u0011\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0006\u0010\u0012\u001a\u00020\u000bR\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\"\u0010 \u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u001c0\u001c0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceFileTabFragment$b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceFileTabFragment$d;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "getItemCount", "holder", "position", "", "i0", "getItemViewType", "", "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/h;", "fileList", "l0", "k0", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "showFooter", "com/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceFileTabFragment$b$b", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceFileTabFragment$b$b;", "diffCallback", "Landroidx/recyclerview/widget/AsyncListDiffer;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceFileTabFragment$c;", "kotlin.jvm.PlatformType", "D", "Landroidx/recyclerview/widget/AsyncListDiffer;", "diff", "<init>", "()V", "E", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends RecyclerView.Adapter<d> {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        /* renamed from: C, reason: from kotlin metadata */
        @NotNull
        private final C8789b diffCallback;

        /* renamed from: D, reason: from kotlin metadata */
        @NotNull
        private final AsyncListDiffer<c> diff;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private boolean showFooter;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceFileTabFragment$b$a;", "", "", "FILE_ITEM_TYPE", "I", "LOADING_ITEM_TYPE", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.troop.troopcard.reborn.essence.TroopEssenceFileTabFragment$b$a, reason: from kotlin metadata */
        /* loaded from: classes19.dex */
        public static final class Companion {
            static IPatchRedirector $redirector_;

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
            }

            Companion() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                    return;
                }
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceFileTabFragment$b$b", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceFileTabFragment$c;", "oldItem", "newItem", "", "b", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.troop.troopcard.reborn.essence.TroopEssenceFileTabFragment$b$b, reason: collision with other inner class name */
        /* loaded from: classes19.dex */
        public static final class C8789b extends DiffUtil.ItemCallback<c> {
            static IPatchRedirector $redirector_;

            C8789b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean areContentsTheSame(@NotNull c oldItem, @NotNull c newItem) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) oldItem, (Object) newItem)).booleanValue();
                }
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                if ((oldItem instanceof c.a) && (newItem instanceof c.a) && ((c.a) oldItem).a() == ((c.a) newItem).a()) {
                    return true;
                }
                return false;
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public boolean areItemsTheSame(@NotNull c oldItem, @NotNull c newItem) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) oldItem, (Object) newItem)).booleanValue();
                }
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                if (Intrinsics.areEqual(oldItem, newItem)) {
                    return true;
                }
                if ((oldItem instanceof c.a) && (newItem instanceof c.a) && Intrinsics.areEqual(((c.a) oldItem).b(), ((c.a) newItem).b())) {
                    return true;
                }
                return false;
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57006);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 8)) {
                redirector.redirect((short) 8);
            } else {
                INSTANCE = new Companion(null);
            }
        }

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            C8789b c8789b = new C8789b();
            this.diffCallback = c8789b;
            this.diff = new AsyncListDiffer<>(this, c8789b);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.diff.getCurrentList().size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, position)).intValue();
            }
            c cVar = this.diff.getCurrentList().get(position);
            if (Intrinsics.areEqual(cVar, c.b.f299505a)) {
                return 1;
            }
            if (cVar instanceof c.a) {
                return 0;
            }
            throw new NoWhenBranchMatchedException();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: i0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull d holder, int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) holder, position);
                return;
            }
            Intrinsics.checkNotNullParameter(holder, "holder");
            c cVar = this.diff.getCurrentList().get(position);
            if ((holder instanceof d.a) && (cVar instanceof c.a)) {
                ((d.a) holder).o((c.a) cVar);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public d onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (d) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parent, viewType);
            }
            Intrinsics.checkNotNullParameter(parent, "parent");
            if (viewType == 1) {
                View loadingView = LoadingUtil.getLoadingView(parent.getContext(), ViewUtils.dip2px(20.0f), ViewUtils.dip2px(20.0f), 2);
                LinearLayout linearLayout = new LinearLayout(parent.getContext());
                linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                linearLayout.setGravity(1);
                linearLayout.addView(loadingView);
                return new d.b(linearLayout);
            }
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.h5x, parent, false);
            Intrinsics.checkNotNullExpressionValue(view, "view");
            am.b(view);
            return new d.a(view);
        }

        public final void k0() {
            List<c> mutableList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
                return;
            }
            if (this.showFooter) {
                return;
            }
            AsyncListDiffer<c> asyncListDiffer = this.diff;
            List<c> currentList = asyncListDiffer.getCurrentList();
            Intrinsics.checkNotNullExpressionValue(currentList, "diff.currentList");
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) currentList);
            mutableList.add(c.b.f299505a);
            asyncListDiffer.submitList(mutableList);
            this.showFooter = true;
        }

        public final void l0(@NotNull List<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.h> fileList) {
            int collectionSizeOrDefault;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) fileList);
                return;
            }
            Intrinsics.checkNotNullParameter(fileList, "fileList");
            AsyncListDiffer<c> asyncListDiffer = this.diff;
            List<com.tencent.mobileqq.troop.troopcard.reborn.uimodel.h> list = fileList;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            int i3 = 0;
            for (Object obj : list) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                com.tencent.mobileqq.troop.troopcard.reborn.uimodel.h hVar = (com.tencent.mobileqq.troop.troopcard.reborn.uimodel.h) obj;
                boolean z16 = true;
                if (i3 == fileList.size() - 1) {
                    z16 = false;
                }
                arrayList.add(new c.a(hVar, z16));
                i3 = i16;
            }
            asyncListDiffer.submitList(arrayList);
            this.showFooter = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceFileTabFragment$c;", "", "<init>", "()V", "a", "b", "Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceFileTabFragment$c$a;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceFileTabFragment$c$b;", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static abstract class c {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceFileTabFragment$c$a;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceFileTabFragment$c;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/h;", "a", "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/h;", "b", "()Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/h;", "troopFileUIModel", "", "Z", "()Z", "showDivider", "<init>", "(Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/h;Z)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes19.dex */
        public static final class a extends c {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final com.tencent.mobileqq.troop.troopcard.reborn.uimodel.h troopFileUIModel;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            private final boolean showDivider;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@NotNull com.tencent.mobileqq.troop.troopcard.reborn.uimodel.h troopFileUIModel, boolean z16) {
                super(null);
                Intrinsics.checkNotNullParameter(troopFileUIModel, "troopFileUIModel");
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, troopFileUIModel, Boolean.valueOf(z16));
                } else {
                    this.troopFileUIModel = troopFileUIModel;
                    this.showDivider = z16;
                }
            }

            public final boolean a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
                }
                return this.showDivider;
            }

            @NotNull
            public final com.tencent.mobileqq.troop.troopcard.reborn.uimodel.h b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (com.tencent.mobileqq.troop.troopcard.reborn.uimodel.h) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return this.troopFileUIModel;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceFileTabFragment$c$b;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceFileTabFragment$c;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes19.dex */
        public static final class b extends c {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final b f299505a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57009);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                } else {
                    f299505a = new b();
                }
            }

            b() {
                super(null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\u0006\u0007B\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0001\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceFileTabFragment$d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "a", "b", "Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceFileTabFragment$d$a;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceFileTabFragment$d$b;", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static abstract class d extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010!\u001a\u00020\u001d\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\t\u001a\n \u0014*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\n \u0014*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u001c\u0010\u001a\u001a\n \u0014*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0016R\u001c\u0010\u001c\u001a\n \u0014*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0016R\u001c\u0010 \u001a\n \u0014*\u0004\u0018\u00010\u001d0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceFileTabFragment$d$a;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceFileTabFragment$d;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/h;", "fileUIModel", "", ReportConstant.COSTREPORT_PREFIX, "Landroid/widget/TextView;", "textView", "", WadlProxyConsts.PARAM_FILENAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, WadlProxyConsts.KEY_JUMP_URL, "r", "Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceFileTabFragment$c$a;", "fileItemData", "o", "Lcom/tencent/mobileqq/filemanager/widget/AsyncImageView;", "E", "Lcom/tencent/mobileqq/filemanager/widget/AsyncImageView;", "fileThumbnail", "kotlin.jvm.PlatformType", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "G", "fileTime", "H", "fileSize", "I", "fileOwner", "Landroid/view/View;", "J", "Landroid/view/View;", "divide", "itemView", "<init>", "(Landroid/view/View;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes19.dex */
        public static final class a extends d {
            static IPatchRedirector $redirector_;

            /* renamed from: E, reason: from kotlin metadata */
            @NotNull
            private final AsyncImageView fileThumbnail;

            /* renamed from: F, reason: from kotlin metadata */
            private final TextView fileName;

            /* renamed from: G, reason: from kotlin metadata */
            private final TextView fileTime;

            /* renamed from: H, reason: from kotlin metadata */
            private final TextView fileSize;

            /* renamed from: I, reason: from kotlin metadata */
            private final TextView fileOwner;

            /* renamed from: J, reason: from kotlin metadata */
            private final View divide;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceFileTabFragment$d$a$a", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "", "onPreDraw", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
            /* renamed from: com.tencent.mobileqq.troop.troopcard.reborn.essence.TroopEssenceFileTabFragment$d$a$a, reason: collision with other inner class name */
            /* loaded from: classes19.dex */
            public static final class ViewTreeObserverOnPreDrawListenerC8790a implements ViewTreeObserver.OnPreDrawListener {
                static IPatchRedirector $redirector_;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ com.tencent.mobileqq.troop.troopcard.reborn.uimodel.h f299507e;

                ViewTreeObserverOnPreDrawListenerC8790a(com.tencent.mobileqq.troop.troopcard.reborn.uimodel.h hVar) {
                    this.f299507e = hVar;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) hVar);
                    }
                }

                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                    }
                    a.this.fileName.getViewTreeObserver().removeOnPreDrawListener(this);
                    TextView textView = a.this.fileName;
                    a aVar = a.this;
                    TextView fileName = aVar.fileName;
                    Intrinsics.checkNotNullExpressionValue(fileName, "fileName");
                    textView.setText(aVar.q(fileName, this.f299507e.a()));
                    return true;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@NotNull View itemView) {
                super(itemView, null);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
                    return;
                }
                View findViewById = itemView.findViewById(R.id.v5h);
                Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.file_thumbnail)");
                this.fileThumbnail = (AsyncImageView) findViewById;
                this.fileName = (TextView) itemView.findViewById(R.id.c_x);
                this.fileTime = (TextView) itemView.findViewById(R.id.v5i);
                this.fileSize = (TextView) itemView.findViewById(R.id.f165204ca0);
                this.fileOwner = (TextView) itemView.findViewById(R.id.v5b);
                this.divide = itemView.findViewById(R.id.f164999bn3);
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Code restructure failed: missing block: B:4:0x0033, code lost:
            
                if (r0.isMember() == true) goto L8;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public static final void p(c.a fileItemData, a this$0, View view) {
                boolean z16;
                EventCollector.getInstance().onViewClickedBefore(view);
                Intrinsics.checkNotNullParameter(fileItemData, "$fileItemData");
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(String.valueOf(fileItemData.b().h()));
                if (troopInfoFromCache != null) {
                    z16 = true;
                }
                z16 = false;
                if (z16) {
                    this$0.r(fileItemData.b().f());
                } else {
                    QQToast.makeText(this$0.itemView.getContext(), R.string.f2329075t, 0).show();
                }
                EventCollector.getInstance().onViewClicked(view);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final String q(TextView textView, String fileName) {
                int lastIndexOf$default;
                float width = textView.getWidth();
                if (width < textView.getPaint().measureText(fileName)) {
                    lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) fileName, ".", 0, false, 6, (Object) null);
                    if (lastIndexOf$default == -1) {
                        return fileName;
                    }
                    String substring = fileName.substring(0, lastIndexOf$default);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    String substring2 = fileName.substring(lastIndexOf$default, fileName.length());
                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    String str = "... " + substring2;
                    float measureText = textView.getPaint().measureText(substring);
                    float measureText2 = textView.getPaint().measureText(str);
                    if (measureText2 > width) {
                        return fileName;
                    }
                    while (width - measureText < measureText2) {
                        substring = substring.substring(0, substring.length() - 1);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                        measureText = textView.getPaint().measureText(substring);
                    }
                    return substring + str;
                }
                return fileName;
            }

            private final void r(String jumpUrl) {
                if (!TextUtils.isEmpty(jumpUrl)) {
                    Context context = this.itemView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                    ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, RouterConstants.UI_ROUTE_BROWSER);
                    Intent intent = new Intent();
                    intent.putExtra("url", jumpUrl);
                    intent.putExtra("webStyle", "noBottomBar");
                    intent.putExtra("startOpenPageTime", System.currentTimeMillis());
                    activityURIRequest.extra().putAll(intent.getExtras());
                    activityURIRequest.setRequestCode(20008);
                    if (context instanceof Activity) {
                        QRoute.startUri(activityURIRequest, (o) null);
                    }
                }
            }

            private final void s(com.tencent.mobileqq.troop.troopcard.reborn.uimodel.h fileUIModel) {
                int o06 = ah.o0(fileUIModel.a());
                ah.M1(this.fileThumbnail, fileUIModel.d(), o06);
                if (o06 == 0 || o06 == 2) {
                    this.fileThumbnail.setUrlIconAsyncImage(fileUIModel.d());
                }
            }

            public final void o(@NotNull final c.a fileItemData) {
                int i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) fileItemData);
                    return;
                }
                Intrinsics.checkNotNullParameter(fileItemData, "fileItemData");
                com.tencent.mobileqq.troop.troopcard.reborn.uimodel.h b16 = fileItemData.b();
                s(b16);
                if (this.fileName.getWidth() == 0) {
                    this.fileName.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserverOnPreDrawListenerC8790a(b16));
                } else {
                    TextView fileName = this.fileName;
                    Intrinsics.checkNotNullExpressionValue(fileName, "fileName");
                    fileName.setText(q(fileName, b16.a()));
                }
                this.fileTime.setText(com.tencent.mobileqq.troop.troopcard.utils.c.f299954a.a(b16.g()));
                this.fileSize.setText(q.g(b16.c()));
                TextView textView = this.fileOwner;
                textView.setText(textView.getContext().getResources().getString(R.string.f203314zv) + b16.b());
                View divide = this.divide;
                Intrinsics.checkNotNullExpressionValue(divide, "divide");
                if (fileItemData.a()) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                divide.setVisibility(i3);
                this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.essence.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TroopEssenceFileTabFragment.d.a.p(TroopEssenceFileTabFragment.c.a.this, this, view);
                    }
                });
                TroopCardDtHelper.k(this.itemView, fileItemData.b().e(), 1);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceFileTabFragment$d$b;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceFileTabFragment$d;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes19.dex */
        public static final class b extends d {
            static IPatchRedirector $redirector_;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(@NotNull View itemView) {
                super(itemView, null);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
                }
            }
        }

        public /* synthetic */ d(View view, DefaultConstructorMarker defaultConstructorMarker) {
            this(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) defaultConstructorMarker);
        }

        d(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57019);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopEssenceFileTabFragment() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.jumpUrl = "";
        Bundle arguments = getArguments();
        if (arguments != null) {
            z16 = arguments.getBoolean("isInitialized");
        } else {
            z16 = false;
        }
        this.isInitialized = z16;
        this.adapter = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Dh() {
        TroopInfoCardEssenceViewModel troopInfoCardEssenceViewModel = this.troopInfoCardEssenceViewModel;
        if (troopInfoCardEssenceViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopInfoCardEssenceViewModel");
            troopInfoCardEssenceViewModel = null;
        }
        troopInfoCardEssenceViewModel.T1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(TroopEssenceFileTabFragment this$0, TroopBasicInfoViewModel troopBasicInfoViewModel, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (TextUtils.isEmpty(this$0.jumpUrl)) {
            QLog.e("TroopEssenceFileTabFragment", 1, "jumpUrl is empty");
        } else if (troopBasicInfoViewModel.Q2()) {
            Intent intent = new Intent(this$0.requireContext(), (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", this$0.jumpUrl);
            this$0.requireContext().startActivity(intent);
        } else {
            QQToast.makeText(this$0.requireContext(), R.string.f2329075t, 0).show();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Hh() {
        TroopInfoCardEssenceViewModel troopInfoCardEssenceViewModel = this.troopInfoCardEssenceViewModel;
        if (troopInfoCardEssenceViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopInfoCardEssenceViewModel");
            troopInfoCardEssenceViewModel = null;
        }
        troopInfoCardEssenceViewModel.g2();
    }

    private final void initViewModel() {
        TextView textView;
        ViewModel viewModel = getViewModel(TroopFileViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(TroopFileViewModel::class.java)");
        this.viewModel = (TroopFileViewModel) viewModel;
        ViewModel viewModel2 = getViewModel(TroopInfoCardEssenceViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(TroopInfoCa\u2026nceViewModel::class.java)");
        this.troopInfoCardEssenceViewModel = (TroopInfoCardEssenceViewModel) viewModel2;
        final TroopBasicInfoViewModel troopBasicInfoViewModel = (TroopBasicInfoViewModel) getViewModel(TroopBasicInfoViewModel.class);
        try {
            TroopFileViewModel troopFileViewModel = this.viewModel;
            if (troopFileViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                troopFileViewModel = null;
            }
            troopFileViewModel.U1(Long.parseLong(troopBasicInfoViewModel.K2()), 1);
        } catch (NumberFormatException e16) {
            QLog.e("TroopEssenceFileTabFragment", 1, "parse troopUin(" + troopBasicInfoViewModel.K2() + ") to long err", e16);
            Dh();
        }
        TroopFileViewModel troopFileViewModel2 = this.viewModel;
        if (troopFileViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            troopFileViewModel2 = null;
        }
        LiveData<TroopFileViewModel.b> T1 = troopFileViewModel2.T1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<TroopFileViewModel.b, Unit> function1 = new Function1<TroopFileViewModel.b, Unit>() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.essence.TroopEssenceFileTabFragment$initViewModel$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopEssenceFileTabFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TroopFileViewModel.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TroopFileViewModel.b bVar) {
                TroopEssenceFileTabFragment.b bVar2;
                TroopFileViewModel troopFileViewModel3;
                LinearLayout linearLayout;
                TroopInfoCardEssenceViewModel troopInfoCardEssenceViewModel;
                TroopEssenceFileTabFragment.b bVar3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
                    return;
                }
                if (Intrinsics.areEqual(bVar, TroopFileViewModel.b.C8798b.f299829a)) {
                    bVar3 = TroopEssenceFileTabFragment.this.adapter;
                    bVar3.k0();
                    return;
                }
                if (bVar instanceof TroopFileViewModel.b.c) {
                    TroopFileViewModel.b.c cVar = (TroopFileViewModel.b.c) bVar;
                    TroopInfoCardEssenceViewModel troopInfoCardEssenceViewModel2 = null;
                    if (cVar.a().isEmpty()) {
                        TroopEssenceFileTabFragment.this.Dh();
                    } else {
                        bVar2 = TroopEssenceFileTabFragment.this.adapter;
                        bVar2.l0(cVar.a());
                        TroopEssenceFileTabFragment.this.Hh();
                        TroopEssenceFileTabFragment.this.jumpUrl = cVar.a().get(0).f();
                        troopFileViewModel3 = TroopEssenceFileTabFragment.this.viewModel;
                        if (troopFileViewModel3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                            troopFileViewModel3 = null;
                        }
                        if (!troopFileViewModel3.W1()) {
                            linearLayout = TroopEssenceFileTabFragment.this.loadMoreView;
                            if (linearLayout == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("loadMoreView");
                                linearLayout = null;
                            }
                            linearLayout.setVisibility(0);
                        }
                    }
                    troopInfoCardEssenceViewModel = TroopEssenceFileTabFragment.this.troopInfoCardEssenceViewModel;
                    if (troopInfoCardEssenceViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("troopInfoCardEssenceViewModel");
                    } else {
                        troopInfoCardEssenceViewModel2 = troopInfoCardEssenceViewModel;
                    }
                    troopInfoCardEssenceViewModel2.a2();
                    return;
                }
                if (bVar instanceof TroopFileViewModel.b.a) {
                    if (((TroopFileViewModel.b.a) bVar).a().isEmpty()) {
                        TroopEssenceFileTabFragment.this.Dh();
                    } else {
                        QQToast.makeText(TroopEssenceFileTabFragment.this.requireContext(), 1, R.string.f2328975s).show();
                    }
                }
            }
        };
        T1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.essence.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopEssenceFileTabFragment.Eh(Function1.this, obj);
            }
        });
        LiveData<Boolean> u26 = troopBasicInfoViewModel.u2();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.essence.TroopEssenceFileTabFragment$initViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopEssenceFileTabFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean isNeedShow) {
                boolean z16;
                TroopFileViewModel troopFileViewModel3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) isNeedShow);
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(isNeedShow, "isNeedShow");
                if (isNeedShow.booleanValue()) {
                    z16 = TroopEssenceFileTabFragment.this.isInitialized;
                    if (z16) {
                        troopFileViewModel3 = TroopEssenceFileTabFragment.this.viewModel;
                        if (troopFileViewModel3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                            troopFileViewModel3 = null;
                        }
                        troopFileViewModel3.X1();
                    }
                }
            }
        };
        u26.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.essence.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopEssenceFileTabFragment.Fh(Function1.this, obj);
            }
        });
        TextView textView2 = this.loadMoreText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreText");
            textView = null;
        } else {
            textView = textView2;
        }
        TriggerRunnerKt.c(textView, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.essence.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopEssenceFileTabFragment.Gh(TroopEssenceFileTabFragment.this, troopBasicInfoViewModel, view);
            }
        }, 1, null);
    }

    @Override // com.tencent.mobileqq.troop.troopcard.reborn.essence.TroopEssenceTabBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View findViewById = view.findViewById(R.id.eey);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.load_more_layout)");
        this.loadMoreView = (LinearLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.yrv);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.load_more_layout_text)");
        this.loadMoreText = (TextView) findViewById2;
        LinearLayout linearLayout = this.loadMoreView;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreView");
            linearLayout = null;
        }
        linearLayout.setVisibility(8);
        Bundle arguments = getArguments();
        if (arguments != null) {
            z16 = arguments.getBoolean("isInitialized");
        } else {
            z16 = false;
        }
        this.isInitialized = z16;
        initViewModel();
    }

    @Override // com.tencent.mobileqq.troop.troopcard.reborn.essence.TroopEssenceTabBaseFragment
    @NotNull
    public RecyclerView.Adapter<?> ph() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RecyclerView.Adapter) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.adapter;
    }
}
