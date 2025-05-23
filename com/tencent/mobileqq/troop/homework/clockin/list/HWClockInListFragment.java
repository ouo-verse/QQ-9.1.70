package com.tencent.mobileqq.troop.homework.clockin.list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
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
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.clockin.list.HWClockInListFragment;
import com.tencent.mobileqq.troop.homework.clockin.list.vm.HWClockInListViewModel;
import com.tencent.mobileqq.troop.homework.clockin.list.vm.a;
import com.tencent.mobileqq.troop.homework.clockin.template.HWClockInTemplateFragment;
import com.tencent.mobileqq.troop.homework.common.HWViewModelsExtKt$hwViewModels$2;
import com.tencent.mobileqq.troop.homework.common.HWViewModelsExtKt$hwViewModels$3;
import com.tencent.mobileqq.troop.homework.common.HWViewModelsExtKt$hwViewModels$4;
import com.tencent.mobileqq.troop.homework.notice.HWNoticeCons$HWNoticeRoleType;
import com.tencent.mobileqq.troop.homework.notice.HWNoticeUtils;
import com.tencent.mobileqq.troop.utils.h;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 G2\u00020\u00012\u00020\u0002:\u0002HIB\u0007\u00a2\u0006\u0004\bE\u0010FJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0014J&\u0010\u0016\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014J\u001a\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u001bH\u0016R\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u001b\u00107\u001a\u0002028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001d\u0010;\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u00104\u001a\u0004\b9\u0010:R\u001b\u0010@\u001a\u00020<8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u00104\u001a\u0004\b>\u0010?R\u001b\u0010D\u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bA\u00104\u001a\u0004\bB\u0010C\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/list/HWClockInListFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "", "initReport", "wh", "Ch", "doLoadMore", "Lcom/tencent/mobileqq/troop/homework/clockin/list/HWClockInListFragment$b;", "status", "xh", "", "title", "Eh", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onLoadMoreStart", "", "hasMore", "onLoadMoreEnd", "useQUISecNavBar", "Landroidx/recyclerview/widget/RecyclerView;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "D", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/mobileqq/troop/homework/clockin/list/adapter/a;", "E", "Lcom/tencent/mobileqq/troop/homework/clockin/list/adapter/a;", "listAdapter", "Lcom/tencent/mobileqq/troop/homework/notice/common/a;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/troop/homework/notice/common/a;", "loadMoreAdapter", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "G", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "concatAdapter", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "H", "Lkotlin/Lazy;", "yh", "()Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "emptyView", "I", OcrConfig.CHINESE, "()Landroid/view/View;", "loadingView", "Lcom/tencent/mobileqq/troop/homework/clockin/list/vm/HWClockInListViewModel;", "J", "Ah", "()Lcom/tencent/mobileqq/troop/homework/clockin/list/vm/HWClockInListViewModel;", "viewModel", "K", "Bh", "()Z", "isTeacher", "<init>", "()V", "L", "a", "b", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWClockInListFragment extends QIphoneTitleBarFragment implements ILoadMoreProvider$LoadMoreListener {
    static IPatchRedirector $redirector_;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: D, reason: from kotlin metadata */
    private ViewGroup rootView;

    /* renamed from: E, reason: from kotlin metadata */
    private com.tencent.mobileqq.troop.homework.clockin.list.adapter.a listAdapter;

    /* renamed from: F, reason: from kotlin metadata */
    private com.tencent.mobileqq.troop.homework.notice.common.a loadMoreAdapter;

    /* renamed from: G, reason: from kotlin metadata */
    private RFWConcatAdapter concatAdapter;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy emptyView;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy loadingView;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy isTeacher;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/list/HWClockInListFragment$a;", "", "", "troopUin", "", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.clockin.list.HWClockInListFragment$a, reason: from kotlin metadata */
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

        @JvmStatic
        public final void a(@NotNull String troopUin) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopUin);
                return;
            }
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            Intent intent = new Intent();
            intent.putExtra("troop_uin", troopUin);
            intent.addFlags(268435456);
            QPublicFragmentActivity.b.b(BaseApplication.context, intent, QPublicFragmentActivity.class, HWClockInListFragment.class);
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
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/list/HWClockInListFragment$b;", "", "<init>", "()V", "a", "b", "c", "Lcom/tencent/mobileqq/troop/homework/clockin/list/HWClockInListFragment$b$a;", "Lcom/tencent/mobileqq/troop/homework/clockin/list/HWClockInListFragment$b$b;", "Lcom/tencent/mobileqq/troop/homework/clockin/list/HWClockInListFragment$b$c;", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static abstract class b {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/list/HWClockInListFragment$b$a;", "Lcom/tencent/mobileqq/troop/homework/clockin/list/HWClockInListFragment$b;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes19.dex */
        public static final class a extends b {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final a f296436a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42889);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                } else {
                    f296436a = new a();
                }
            }

            a() {
                super(null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/list/HWClockInListFragment$b$b;", "Lcom/tencent/mobileqq/troop/homework/clockin/list/HWClockInListFragment$b;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.troop.homework.clockin.list.HWClockInListFragment$b$b, reason: collision with other inner class name */
        /* loaded from: classes19.dex */
        public static final class C8710b extends b {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final C8710b f296437a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42892);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                } else {
                    f296437a = new C8710b();
                }
            }

            C8710b() {
                super(null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/list/HWClockInListFragment$b$c;", "Lcom/tencent/mobileqq/troop/homework/clockin/list/HWClockInListFragment$b;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes19.dex */
        public static final class c extends b {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final c f296438a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42909);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                } else {
                    f296438a = new c();
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

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u001a\u0010\n\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001a\u0010\r\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\t\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/troop/homework/clockin/list/HWClockInListFragment$c", "Lcom/tencent/biz/qui/quisecnavbar/a;", "Landroid/view/View;", "view", "", "a", "", "I", "getDrawable", "()I", "drawable", "b", "d", "drawableInTransparent", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c extends com.tencent.biz.qui.quisecnavbar.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int drawable;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int drawableInTransparent;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HWClockInListFragment.this);
            } else {
                this.drawable = R.drawable.qui_troop_homework_edit_icon_selector;
                this.drawableInTransparent = R.drawable.qui_edit;
            }
        }

        @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
        public void a(@Nullable View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
                return;
            }
            if (view != null) {
                h.a.f(com.tencent.mobileqq.troop.homework.clockin.report.a.f296532a, view, "em_group_publish_btn", null, null, 12, null);
            }
            HWClockInTemplateFragment.INSTANCE.a(HWClockInListFragment.this.Ah().Q1());
        }

        @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
        public int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.drawableInTransparent;
        }

        @Override // com.tencent.biz.qui.quisecnavbar.b
        public int getDrawable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.drawable;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42961);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public HWClockInListFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<QUIEmptyState>() { // from class: com.tencent.mobileqq.troop.homework.clockin.list.HWClockInListFragment$emptyView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWClockInListFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QUIEmptyState invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (QUIEmptyState) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(HWClockInListFragment.this.getContext()).setImageType(16);
                String string = BaseApplication.getContext().getString(R.string.f2339678o);
                Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(R\u2026work_clock_in_no_publish)");
                return imageType.setTitle(string).setBackgroundColorType(2).build();
            }
        });
        this.emptyView = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<View>() { // from class: com.tencent.mobileqq.troop.homework.clockin.list.HWClockInListFragment$loadingView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWClockInListFragment.this);
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
                Context context = HWClockInListFragment.this.getContext();
                if (context != null) {
                    return HWNoticeUtils.f297171a.c(context);
                }
                return null;
            }
        });
        this.loadingView = lazy2;
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(HWClockInListViewModel.class), new HWViewModelsExtKt$hwViewModels$3(new HWViewModelsExtKt$hwViewModels$2(this)), new HWViewModelsExtKt$hwViewModels$4(this));
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.troop.homework.clockin.list.HWClockInListFragment$isTeacher$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWClockInListFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    return Boolean.valueOf(HWNoticeUtils.f297171a.f(HWClockInListFragment.this.Ah().Q1()) == HWNoticeCons$HWNoticeRoleType.ROLE_TYPE_TEACHER);
                }
                return (Boolean) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.isTeacher = lazy3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HWClockInListViewModel Ah() {
        return (HWClockInListViewModel) this.viewModel.getValue();
    }

    private final boolean Bh() {
        return ((Boolean) this.isTeacher.getValue()).booleanValue();
    }

    private final void Ch() {
        MutableLiveData<com.tencent.mobileqq.troop.homework.clockin.list.vm.a> obtainUiState = Ah().obtainUiState();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<com.tencent.mobileqq.troop.homework.clockin.list.vm.a, Unit> function1 = new Function1<com.tencent.mobileqq.troop.homework.clockin.list.vm.a, Unit>() { // from class: com.tencent.mobileqq.troop.homework.clockin.list.HWClockInListFragment$observeUiState$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) HWClockInListFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.homework.clockin.list.vm.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.homework.clockin.list.vm.a aVar) {
                RecyclerView recyclerView;
                com.tencent.mobileqq.troop.homework.clockin.list.adapter.a aVar2;
                com.tencent.mobileqq.troop.homework.notice.common.a aVar3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
                    return;
                }
                if (aVar instanceof a.C8712a) {
                    a.C8712a c8712a = (a.C8712a) aVar;
                    if (!c8712a.a().isEmpty()) {
                        recyclerView = HWClockInListFragment.this.recyclerView;
                        com.tencent.mobileqq.troop.homework.notice.common.a aVar4 = null;
                        if (recyclerView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                            recyclerView = null;
                        }
                        recyclerView.setVisibility(0);
                        aVar2 = HWClockInListFragment.this.listAdapter;
                        if (aVar2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
                            aVar2 = null;
                        }
                        aVar2.setItems(c8712a.a());
                        aVar3 = HWClockInListFragment.this.loadMoreAdapter;
                        if (aVar3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
                        } else {
                            aVar4 = aVar3;
                        }
                        aVar4.setLoadState(false, !c8712a.b());
                        HWClockInListFragment.this.xh(HWClockInListFragment.b.C8710b.f296437a);
                        return;
                    }
                    HWClockInListFragment.this.xh(HWClockInListFragment.b.a.f296436a);
                    return;
                }
                if (aVar instanceof a.b) {
                    String a16 = new com.tencent.mobileqq.troop.homework.clockin.a().a(((a.b) aVar).a());
                    HWClockInListFragment hWClockInListFragment = HWClockInListFragment.this;
                    if (a16 == null) {
                        a16 = "\u6682\u65e0\u6253\u5361\u4efb\u52a1";
                    }
                    hWClockInListFragment.Eh(a16);
                    HWClockInListFragment.this.xh(HWClockInListFragment.b.a.f296436a);
                }
            }
        };
        obtainUiState.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.homework.clockin.list.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HWClockInListFragment.Dh(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Eh(String title) {
        yh().setTitle(title);
    }

    private final void doLoadMore() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new HWClockInListFragment$doLoadMore$1(this, null), 3, null);
    }

    private final void initReport() {
        HashMap hashMapOf;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        com.tencent.mobileqq.troop.homework.clockin.report.a aVar = com.tencent.mobileqq.troop.homework.clockin.report.a.f296532a;
        int i3 = 2;
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("group_id", Ah().Q1());
        if (Bh()) {
            i3 = 1;
        }
        pairArr[1] = TuplesKt.to(MiniAppPlugin.ATTR_PAGE_TYPE, Integer.valueOf(i3));
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        h.a.d(aVar, activity, "pg_group_clock_in_list", hashMapOf, false, 8, null);
    }

    private final void wh() {
        com.tencent.mobileqq.troop.homework.clockin.list.adapter.a aVar = new com.tencent.mobileqq.troop.homework.clockin.list.adapter.a(Ah().Q1());
        aVar.setHasStableIds(true);
        this.listAdapter = aVar;
        com.tencent.mobileqq.troop.homework.notice.common.a aVar2 = new com.tencent.mobileqq.troop.homework.notice.common.a();
        aVar2.setHasStableIds(true);
        aVar2.registerLoadMoreListener(this);
        aVar2.setLoadState(false, true);
        this.loadMoreAdapter = aVar2;
        RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[2];
        com.tencent.mobileqq.troop.homework.clockin.list.adapter.a aVar3 = this.listAdapter;
        RFWConcatAdapter rFWConcatAdapter = null;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
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
    public final void xh(b status) {
        if (status instanceof b.c) {
            View zh5 = zh();
            if (zh5 != null) {
                zh5.setVisibility(0);
            }
            yh().setVisibility(8);
            return;
        }
        if (status instanceof b.a) {
            View zh6 = zh();
            if (zh6 != null) {
                zh6.setVisibility(8);
            }
            yh().setVisibility(0);
            return;
        }
        if (status instanceof b.C8710b) {
            View zh7 = zh();
            if (zh7 != null) {
                zh7.setVisibility(8);
            }
            yh().setVisibility(8);
        }
    }

    private final QUIEmptyState yh() {
        return (QUIEmptyState) this.emptyView.getValue();
    }

    private final View zh() {
        return (View) this.loadingView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, inflater, container, savedInstanceState);
            return;
        }
        super.doOnCreateView(inflater, container, savedInstanceState);
        setTitle("\u6253\u5361\u4efb\u52a1");
        if (Bh()) {
            this.quiSecNavBar.setRightType(2);
            this.quiSecNavBar.d(new c());
        }
        View findViewById = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.i4m);
        RecyclerView recyclerView = (RecyclerView) findViewById;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setOverScrollMode(2);
        recyclerView.setItemAnimator(null);
        recyclerView.setVisibility(8);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewByI\u2026ity = View.GONE\n        }");
        this.recyclerView = recyclerView;
        yh().setVisibility(8);
        View zh5 = zh();
        if (zh5 != null) {
            zh5.setVisibility(8);
        }
        View findViewById2 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.if5);
        ViewGroup viewGroup = (ViewGroup) findViewById2;
        viewGroup.addView(yh(), -1, -1);
        viewGroup.addView(zh(), -1, -1);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContentView.findViewByI\u2026T\n            )\n        }");
        this.rootView = viewGroup;
        xh(b.c.f296438a);
        wh();
        initReport();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.f168603g03;
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
        doLoadMore();
        Ch();
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return true;
    }
}
