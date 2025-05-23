package com.tencent.mobileqq.troop.homework.notice.list;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.notice.HWNoticeCons$HWNoticeListType;
import com.tencent.mobileqq.troop.homework.notice.HWNoticeUtils;
import com.tencent.mobileqq.troop.homework.notice.list.HWNoticeListFragment;
import com.tencent.mobileqq.troop.homework.notice.list.event.a;
import com.tencent.mobileqq.troop.homework.notice.list.viewmodel.c;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0081\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u000b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001IB\u0007\u00a2\u0006\u0004\bG\u0010HJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u000f\u0010\f\u001a\u00020\u000bH\u0002\u00a2\u0006\u0004\b\f\u0010\rJ&\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0019H\u0016R\u0016\u0010\u001e\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u001b\u00103\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001b\u00108\u001a\u0002048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u00100\u001a\u0004\b6\u00107R\u001d\u0010<\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u00100\u001a\u0004\b:\u0010;R\u001b\u0010A\u001a\u00020=8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b>\u00100\u001a\u0004\b?\u0010@R\u001b\u0010F\u001a\u00020B8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bC\u00100\u001a\u0004\bD\u0010E\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/list/HWNoticeListFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "", "xh", "Lcom/tencent/mobileqq/troop/homework/notice/list/HWNoticeListFragment$a;", "status", "yh", "doLoadMore", "Lcom/tencent/mobileqq/troop/homework/notice/list/viewmodel/c;", "Dh", "com/tencent/mobileqq/troop/homework/notice/list/HWNoticeListFragment$b", "Fh", "()Lcom/tencent/mobileqq/troop/homework/notice/list/HWNoticeListFragment$b;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onLoadMoreStart", "", "hasMore", "onLoadMoreEnd", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroidx/recyclerview/widget/RecyclerView;", "D", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "E", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "concatAdapter", "Lcom/tencent/mobileqq/troop/homework/notice/list/adapter/a;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/troop/homework/notice/list/adapter/a;", "noticeListAdapter", "Lcom/tencent/mobileqq/troop/homework/notice/common/a;", "G", "Lcom/tencent/mobileqq/troop/homework/notice/common/a;", "loadMoreAdapter", "H", "Lkotlin/Lazy;", "Eh", "()Lcom/tencent/mobileqq/troop/homework/notice/list/viewmodel/c;", "viewModel", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "I", OcrConfig.CHINESE, "()Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "emptyView", "J", "Bh", "()Landroid/view/View;", "loadingView", "", "K", "Ch", "()Ljava/lang/String;", "troopUin", "Lcom/tencent/mobileqq/troop/homework/notice/HWNoticeCons$HWNoticeListType;", "L", "Ah", "()Lcom/tencent/mobileqq/troop/homework/notice/HWNoticeCons$HWNoticeListType;", "listType", "<init>", "()V", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWNoticeListFragment extends QPublicBaseFragment implements ILoadMoreProvider$LoadMoreListener {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private ViewGroup rootView;

    /* renamed from: D, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: E, reason: from kotlin metadata */
    private RFWConcatAdapter concatAdapter;

    /* renamed from: F, reason: from kotlin metadata */
    private com.tencent.mobileqq.troop.homework.notice.list.adapter.a noticeListAdapter;

    /* renamed from: G, reason: from kotlin metadata */
    private com.tencent.mobileqq.troop.homework.notice.common.a loadMoreAdapter;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy emptyView;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy loadingView;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy troopUin;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy listType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/list/HWNoticeListFragment$a;", "", "<init>", "()V", "a", "b", "c", "Lcom/tencent/mobileqq/troop/homework/notice/list/HWNoticeListFragment$a$a;", "Lcom/tencent/mobileqq/troop/homework/notice/list/HWNoticeListFragment$a$b;", "Lcom/tencent/mobileqq/troop/homework/notice/list/HWNoticeListFragment$a$c;", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static abstract class a {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/list/HWNoticeListFragment$a$a;", "Lcom/tencent/mobileqq/troop/homework/notice/list/HWNoticeListFragment$a;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.troop.homework.notice.list.HWNoticeListFragment$a$a, reason: collision with other inner class name */
        /* loaded from: classes19.dex */
        public static final class C8743a extends a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final C8743a f297254a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53345);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                } else {
                    f297254a = new C8743a();
                }
            }

            C8743a() {
                super(null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/list/HWNoticeListFragment$a$b;", "Lcom/tencent/mobileqq/troop/homework/notice/list/HWNoticeListFragment$a;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes19.dex */
        public static final class b extends a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final b f297255a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53348);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                } else {
                    f297255a = new b();
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

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/list/HWNoticeListFragment$a$c;", "Lcom/tencent/mobileqq/troop/homework/notice/list/HWNoticeListFragment$a;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes19.dex */
        public static final class c extends a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final c f297256a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53352);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                } else {
                    f297256a = new c();
                }
            }

            c() {
                super(null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/homework/notice/list/HWNoticeListFragment$b", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements ViewModelProvider.Factory {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HWNoticeListFragment.this);
            }
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (T) iPatchRedirector.redirect((short) 2, (Object) this, (Object) modelClass);
            }
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            T newInstance = modelClass.getConstructor(HWNoticeCons$HWNoticeListType.class, String.class).newInstance(HWNoticeListFragment.this.Ah(), HWNoticeListFragment.this.Ch());
            Intrinsics.checkNotNullExpressionValue(newInstance, "modelClass.getConstructo\u2026tance(listType, troopUin)");
            return newInstance;
        }
    }

    public HWNoticeListFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<c>() { // from class: com.tencent.mobileqq.troop.homework.notice.list.HWNoticeListFragment$viewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWNoticeListFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final c invoke() {
                c Dh;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (c) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                Dh = HWNoticeListFragment.this.Dh();
                return Dh;
            }
        });
        this.viewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<QUIEmptyState>() { // from class: com.tencent.mobileqq.troop.homework.notice.list.HWNoticeListFragment$emptyView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWNoticeListFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QUIEmptyState invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new QUIEmptyState.Builder(HWNoticeListFragment.this.getContext()).setImageType(8).setTitle("\u6682\u65e0\u901a\u77e5").setBackgroundColorType(2).build() : (QUIEmptyState) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.emptyView = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<View>() { // from class: com.tencent.mobileqq.troop.homework.notice.list.HWNoticeListFragment$loadingView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWNoticeListFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final View invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (View) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                Context context = HWNoticeListFragment.this.getContext();
                if (context != null) {
                    return HWNoticeUtils.f297171a.c(context);
                }
                return null;
            }
        });
        this.loadingView = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.troop.homework.notice.list.HWNoticeListFragment$troopUin$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWNoticeListFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                Bundle arguments = HWNoticeListFragment.this.getArguments();
                String string = arguments != null ? arguments.getString("TROOP_UIN", "0") : null;
                return string == null ? "0" : string;
            }
        });
        this.troopUin = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<HWNoticeCons$HWNoticeListType>() { // from class: com.tencent.mobileqq.troop.homework.notice.list.HWNoticeListFragment$listType$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWNoticeListFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HWNoticeCons$HWNoticeListType invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (HWNoticeCons$HWNoticeListType) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                Bundle arguments = HWNoticeListFragment.this.getArguments();
                HWNoticeCons$HWNoticeListType a16 = HWNoticeCons$HWNoticeListType.INSTANCE.a(arguments != null ? Integer.valueOf(arguments.getInt("LIST_TYPE", HWNoticeCons$HWNoticeListType.NOTICE_LIST_TYPE_ALL.getValue())) : null);
                return a16 == null ? HWNoticeCons$HWNoticeListType.NOTICE_LIST_TYPE_ALL : a16;
            }
        });
        this.listType = lazy5;
    }

    private final View Bh() {
        return (View) this.loadingView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String Ch() {
        return (String) this.troopUin.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c Dh() {
        ViewModel viewModel = new ViewModelProvider(this, Fh()).get(c.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026istViewModel::class.java)");
        return (c) viewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c Eh() {
        return (c) this.viewModel.getValue();
    }

    private final b Fh() {
        return new b();
    }

    private final void doLoadMore() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new HWNoticeListFragment$doLoadMore$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void xh() {
        com.tencent.mobileqq.troop.homework.notice.list.adapter.a aVar = new com.tencent.mobileqq.troop.homework.notice.list.adapter.a(getActivity(), Ch(), HWNoticeUtils.f297171a.f(Ch()), Ah());
        aVar.setHasStableIds(true);
        this.noticeListAdapter = aVar;
        com.tencent.mobileqq.troop.homework.notice.common.a aVar2 = new com.tencent.mobileqq.troop.homework.notice.common.a();
        aVar2.setHasStableIds(true);
        aVar2.registerLoadMoreListener(this);
        aVar2.setLoadState(false, true);
        this.loadMoreAdapter = aVar2;
        RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[2];
        com.tencent.mobileqq.troop.homework.notice.list.adapter.a aVar3 = this.noticeListAdapter;
        RFWConcatAdapter rFWConcatAdapter = null;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noticeListAdapter");
            aVar3 = null;
        }
        adapterArr[0] = aVar3;
        com.tencent.mobileqq.troop.homework.notice.common.a aVar4 = this.loadMoreAdapter;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
            aVar4 = null;
        }
        adapterArr[1] = aVar4;
        this.concatAdapter = new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr);
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        RFWConcatAdapter rFWConcatAdapter2 = this.concatAdapter;
        if (rFWConcatAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
        } else {
            rFWConcatAdapter = rFWConcatAdapter2;
        }
        recyclerView.setAdapter(rFWConcatAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void yh(a status) {
        if (status instanceof a.c) {
            View Bh = Bh();
            if (Bh != null) {
                Bh.setVisibility(0);
            }
            zh().setVisibility(8);
            return;
        }
        if (status instanceof a.C8743a) {
            View Bh2 = Bh();
            if (Bh2 != null) {
                Bh2.setVisibility(8);
            }
            zh().setVisibility(0);
            return;
        }
        if (status instanceof a.b) {
            View Bh3 = Bh();
            if (Bh3 != null) {
                Bh3.setVisibility(8);
            }
            zh().setVisibility(8);
        }
    }

    private final QUIEmptyState zh() {
        return (QUIEmptyState) this.emptyView.getValue();
    }

    @NotNull
    public final HWNoticeCons$HWNoticeListType Ah() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (HWNoticeCons$HWNoticeListType) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return (HWNoticeCons$HWNoticeListType) this.listType.getValue();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            inflate = (View) iPatchRedirector.redirect((short) 3, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            inflate = inflater.inflate(R.layout.i09, container, false);
            View findViewById = inflate.findViewById(R.id.i4m);
            RecyclerView recyclerView = (RecyclerView) findViewById;
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setOverScrollMode(2);
            recyclerView.setItemAnimator(null);
            recyclerView.setVisibility(8);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById<Recycl\u2026ity = View.GONE\n        }");
            this.recyclerView = recyclerView;
            zh().setVisibility(8);
            View Bh = Bh();
            if (Bh != null) {
                Bh.setVisibility(8);
            }
            View findViewById2 = inflate.findViewById(R.id.if5);
            ViewGroup viewGroup = (ViewGroup) findViewById2;
            viewGroup.addView(zh(), -1, -1);
            viewGroup.addView(Bh(), -1, -1);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById<ViewGr\u2026T\n            )\n        }");
            this.rootView = viewGroup;
            yh(a.c.f297256a);
            xh();
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, hasMore);
        }
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            doLoadMore();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        MutableLiveData<com.tencent.mobileqq.troop.homework.notice.list.event.a> obtainUiState = Eh().obtainUiState();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<com.tencent.mobileqq.troop.homework.notice.list.event.a, Unit> function1 = new Function1<com.tencent.mobileqq.troop.homework.notice.list.event.a, Unit>() { // from class: com.tencent.mobileqq.troop.homework.notice.list.HWNoticeListFragment$onViewCreated$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWNoticeListFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.homework.notice.list.event.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.homework.notice.list.event.a aVar) {
                RecyclerView recyclerView;
                com.tencent.mobileqq.troop.homework.notice.list.adapter.a aVar2;
                com.tencent.mobileqq.troop.homework.notice.common.a aVar3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) aVar);
                    return;
                }
                if (aVar instanceof a.b) {
                    a.b bVar = (a.b) aVar;
                    if (!bVar.a().isEmpty()) {
                        recyclerView = HWNoticeListFragment.this.recyclerView;
                        com.tencent.mobileqq.troop.homework.notice.common.a aVar4 = null;
                        if (recyclerView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                            recyclerView = null;
                        }
                        recyclerView.setVisibility(0);
                        aVar2 = HWNoticeListFragment.this.noticeListAdapter;
                        if (aVar2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("noticeListAdapter");
                            aVar2 = null;
                        }
                        aVar2.setItems(bVar.a());
                        aVar3 = HWNoticeListFragment.this.loadMoreAdapter;
                        if (aVar3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
                        } else {
                            aVar4 = aVar3;
                        }
                        aVar4.setLoadState(false, !bVar.b());
                        HWNoticeListFragment.this.yh(HWNoticeListFragment.a.b.f297255a);
                        return;
                    }
                    HWNoticeListFragment.this.yh(HWNoticeListFragment.a.C8743a.f297254a);
                    return;
                }
                if (aVar instanceof a.C8745a) {
                    HWNoticeListFragment.this.yh(HWNoticeListFragment.a.C8743a.f297254a);
                }
            }
        };
        obtainUiState.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.homework.notice.list.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HWNoticeListFragment.onViewCreated$lambda$2(Function1.this, obj);
            }
        });
        doLoadMore();
    }
}
