package com.tencent.mobileqq.troop.homework.notice.list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.notice.HWNoticeCons$HWNoticeListType;
import com.tencent.mobileqq.troop.homework.notice.HWNoticeCons$HWNoticeRoleType;
import com.tencent.mobileqq.troop.homework.notice.HWNoticeUtils;
import com.tencent.mobileqq.troop.homework.notice.publish.HWNoticePublishFragment;
import com.tencent.mobileqq.troop.utils.h;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\n\u0018\u0000 32\u00020\u0001:\u00017B\u0007\u00a2\u0006\u0004\b5\u00106J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0014J&\u0010\u0016\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014J\u001a\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\b\u0010\u001b\u001a\u00020\bH\u0016R\u001b\u0010 \u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R$\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u00040)j\b\u0012\u0004\u0012\u00020\u0004`*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020\f0.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/list/HWNoticeListBaseFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Lcom/tencent/mobileqq/troop/homework/notice/HWNoticeCons$HWNoticeListType;", "type", "Lcom/tencent/mobileqq/troop/homework/notice/list/HWNoticeListFragment;", "sh", "", "initUI", "", "isPageIn", "pageType", "wh", "", "th", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onDestroyView", "useQUISecNavBar", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "uh", "()Ljava/lang/String;", "troopUin", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "D", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "tabBar", "Landroidx/viewpager2/widget/ViewPager2;", "E", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", UserInfo.SEX_FEMALE, "Ljava/util/ArrayList;", "fragments", "", "G", "Ljava/util/List;", "tabNames", "H", "I", "curTabIndex", "<init>", "()V", "Companion", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWNoticeListBaseFragment extends QIphoneTitleBarFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy troopUin;

    /* renamed from: D, reason: from kotlin metadata */
    private QUIPageTabBar tabBar;

    /* renamed from: E, reason: from kotlin metadata */
    private ViewPager2 viewPager;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<HWNoticeListFragment> fragments;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final List<String> tabNames;

    /* renamed from: H, reason: from kotlin metadata */
    private int curTabIndex;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/list/HWNoticeListBaseFragment$Companion;", "", "", "troopUin", "", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
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
            intent.addFlags(268435456);
            intent.putExtra("TROOP_UIN", troopUin);
            QPublicFragmentActivity.b.b(BaseApplication.context, intent, QPublicFragmentActivity.class, HWNoticeListBaseFragment.class);
            HWNoticeUtils.a(troopUin, true, HWNoticeListBaseFragment$Companion$openPage$1.INSTANCE);
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
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f297248a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f297249b;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53101);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[HWNoticeCons$HWNoticeRoleType.values().length];
            try {
                iArr[HWNoticeCons$HWNoticeRoleType.ROLE_TYPE_TEACHER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HWNoticeCons$HWNoticeRoleType.ROLE_TYPE_PARENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HWNoticeCons$HWNoticeRoleType.ROLE_TYPE_ADMIN_OR_OWNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f297248a = iArr;
            int[] iArr2 = new int[HWNoticeCons$HWNoticeListType.values().length];
            try {
                iArr2[HWNoticeCons$HWNoticeListType.NOTICE_LIST_TYPE_ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[HWNoticeCons$HWNoticeListType.NOTICE_LIST_TYPE_NO_CONFIRM.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[HWNoticeCons$HWNoticeListType.NOTICE_LIST_TYPE_MY_PUBLISH.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            f297249b = iArr2;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/troop/homework/notice/list/HWNoticeListBaseFragment$b", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "", "getItemCount", "position", "Landroidx/fragment/app/Fragment;", "createFragment", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends FragmentStateAdapter {
        static IPatchRedirector $redirector_;

        b() {
            super(HWNoticeListBaseFragment.this);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HWNoticeListBaseFragment.this);
            }
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        @NotNull
        public Fragment createFragment(int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Fragment) iPatchRedirector.redirect((short) 3, (Object) this, position);
            }
            Object obj = HWNoticeListBaseFragment.this.fragments.get(position);
            HWNoticeListBaseFragment hWNoticeListBaseFragment = HWNoticeListBaseFragment.this;
            Bundle arguments = ((HWNoticeListFragment) obj).getArguments();
            if (arguments == null) {
                arguments = new Bundle();
            }
            Intrinsics.checkNotNullExpressionValue(arguments, "it.arguments ?: Bundle()");
            arguments.putAll(hWNoticeListBaseFragment.getArguments());
            Intrinsics.checkNotNullExpressionValue(obj, "fragments[position].also\u2026uments)\n                }");
            return (Fragment) obj;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return HWNoticeListBaseFragment.this.fragments.size();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u001a\u0010\n\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001a\u0010\r\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\t\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/troop/homework/notice/list/HWNoticeListBaseFragment$c", "Lcom/tencent/biz/qui/quisecnavbar/a;", "Landroid/view/View;", "view", "", "a", "", "I", "getDrawable", "()I", "drawable", "b", "d", "drawableInTransparent", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HWNoticeListBaseFragment.this);
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
            HWNoticePublishFragment.Companion companion = HWNoticePublishFragment.INSTANCE;
            String troopUin = HWNoticeListBaseFragment.this.uh();
            Intrinsics.checkNotNullExpressionValue(troopUin, "troopUin");
            companion.a(troopUin);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53115);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public HWNoticeListBaseFragment() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.troop.homework.notice.list.HWNoticeListBaseFragment$troopUin$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWNoticeListBaseFragment.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    String string;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    Bundle arguments = HWNoticeListBaseFragment.this.getArguments();
                    return (arguments == null || (string = arguments.getString("TROOP_UIN")) == null) ? "0" : string;
                }
            });
            this.troopUin = lazy;
            this.fragments = new ArrayList<>();
            this.tabNames = new ArrayList();
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final void initUI() {
        String string;
        String str;
        String string2;
        String str2;
        HWNoticeUtils hWNoticeUtils = HWNoticeUtils.f297171a;
        String troopUin = uh();
        Intrinsics.checkNotNullExpressionValue(troopUin, "troopUin");
        HWNoticeCons$HWNoticeRoleType f16 = hWNoticeUtils.f(troopUin);
        int i3 = a.f297248a[f16.ordinal()];
        String str3 = "";
        QUIPageTabBar qUIPageTabBar = null;
        if (i3 != 1) {
            if (i3 == 2 || i3 == 3) {
                ArrayList<HWNoticeListFragment> arrayList = this.fragments;
                HWNoticeCons$HWNoticeRoleType hWNoticeCons$HWNoticeRoleType = HWNoticeCons$HWNoticeRoleType.ROLE_TYPE_ADMIN_OR_OWNER;
                if (f16 == hWNoticeCons$HWNoticeRoleType) {
                    arrayList.add(sh(HWNoticeCons$HWNoticeListType.NOTICE_LIST_TYPE_MY_PUBLISH));
                }
                arrayList.add(sh(HWNoticeCons$HWNoticeListType.NOTICE_LIST_TYPE_NO_CONFIRM));
                arrayList.add(sh(HWNoticeCons$HWNoticeListType.NOTICE_LIST_TYPE_ALL));
                List<String> list = this.tabNames;
                if (f16 == hWNoticeCons$HWNoticeRoleType) {
                    Context context = getContext();
                    if (context == null || (str2 = context.getString(R.string.f2340278u)) == null) {
                        str2 = "";
                    }
                    Intrinsics.checkNotNullExpressionValue(str2, "context?.getString(R.str\u2026ist_tab_my_publish) ?: \"\"");
                    list.add(str2);
                }
                List<String> list2 = this.tabNames;
                Context context2 = getContext();
                if (context2 == null || (str = context2.getString(R.string.f2340378v)) == null) {
                    str = "";
                }
                Intrinsics.checkNotNullExpressionValue(str, "context?.getString(R.str\u2026st_tab_unconfirmed) ?: \"\"");
                list2.add(str);
                List<String> list3 = this.tabNames;
                Context context3 = getContext();
                if (context3 != null && (string2 = context3.getString(R.string.f2340178t)) != null) {
                    str3 = string2;
                }
                Intrinsics.checkNotNullExpressionValue(str3, "context?.getString(R.str\u2026otice_list_tab_all) ?: \"\"");
                list3.add(str3);
            }
        } else {
            this.fragments.add(sh(HWNoticeCons$HWNoticeListType.NOTICE_LIST_TYPE_MY_PUBLISH));
            List<String> list4 = this.tabNames;
            Context context4 = getContext();
            if (context4 != null && (string = context4.getString(R.string.f2340278u)) != null) {
                str3 = string;
            }
            list4.add(str3);
            QUIPageTabBar qUIPageTabBar2 = this.tabBar;
            if (qUIPageTabBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabBar");
                qUIPageTabBar2 = null;
            }
            qUIPageTabBar2.setVisibility(8);
        }
        QUIPageTabBar qUIPageTabBar3 = this.tabBar;
        if (qUIPageTabBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabBar");
            qUIPageTabBar3 = null;
        }
        Object[] array = this.tabNames.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        qUIPageTabBar3.setTabData((String[]) array);
        ViewPager2 viewPager2 = this.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        viewPager2.setAdapter(new b());
        QUIPageTabBar qUIPageTabBar4 = this.tabBar;
        if (qUIPageTabBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabBar");
            qUIPageTabBar4 = null;
        }
        ViewPager2 viewPager22 = this.viewPager;
        if (viewPager22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager22 = null;
        }
        qUIPageTabBar4.bindViewPager2(viewPager22);
        QUIPageTabBar qUIPageTabBar5 = this.tabBar;
        if (qUIPageTabBar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabBar");
        } else {
            qUIPageTabBar = qUIPageTabBar5;
        }
        qUIPageTabBar.setTabChangeListener(new QUIPageTabBar.i() { // from class: com.tencent.mobileqq.troop.homework.notice.list.a
            @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar.i
            public final void I0(int i16, boolean z16) {
                HWNoticeListBaseFragment.vh(HWNoticeListBaseFragment.this, i16, z16);
            }
        });
        if (this.fragments.size() > 0) {
            wh(true, this.fragments.get(0).Ah());
        }
    }

    private final HWNoticeListFragment sh(HWNoticeCons$HWNoticeListType type) {
        Bundle bundle = new Bundle();
        bundle.putInt("LIST_TYPE", type.getValue());
        HWNoticeListFragment hWNoticeListFragment = new HWNoticeListFragment();
        hWNoticeListFragment.setArguments(bundle);
        return hWNoticeListFragment;
    }

    private final String th(HWNoticeCons$HWNoticeListType type) {
        int i3 = a.f297249b[type.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    return "3";
                }
                throw new NoWhenBranchMatchedException();
            }
            return "2";
        }
        return "1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String uh() {
        return (String) this.troopUin.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vh(HWNoticeListBaseFragment this$0, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.wh(false, this$0.fragments.get(this$0.curTabIndex).Ah());
        this$0.curTabIndex = i3;
        this$0.wh(true, this$0.fragments.get(i3).Ah());
    }

    private final void wh(boolean isPageIn, HWNoticeCons$HWNoticeListType pageType) {
        HashMap<String, Object> hashMapOf;
        View view;
        Window window;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(MiniAppPlugin.ATTR_PAGE_TYPE, th(pageType)), TuplesKt.to("group_id", uh()));
        com.tencent.mobileqq.troop.homework.notice.report.a aVar = com.tencent.mobileqq.troop.homework.notice.report.a.f297331a;
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            view = window.getDecorView();
        } else {
            view = null;
        }
        aVar.g(view, "pg_group_notice_list", isPageIn, hashMapOf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, inflater, container, savedInstanceState);
            return;
        }
        View findViewById = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.j_7);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewById(R.id.tab_bar)");
        this.tabBar = (QUIPageTabBar) findViewById;
        View findViewById2 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.kwk);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContentView.findViewById(R.id.view_pager)");
        this.viewPager = (ViewPager2) findViewById2;
        initUI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.i08;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onDestroyView();
        if (this.fragments.size() > 0) {
            wh(false, this.fragments.get(this.curTabIndex).Ah());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Context context = getContext();
        if (context == null || (str = context.getString(R.string.f2339878q)) == null) {
            str = "";
        }
        setTitle(str);
        HWNoticeUtils hWNoticeUtils = HWNoticeUtils.f297171a;
        String troopUin = uh();
        Intrinsics.checkNotNullExpressionValue(troopUin, "troopUin");
        if (hWNoticeUtils.f(troopUin) != HWNoticeCons$HWNoticeRoleType.ROLE_TYPE_PARENT) {
            this.quiSecNavBar.setRightType(2);
            c cVar = new c();
            this.quiSecNavBar.d(cVar);
            View h16 = this.quiSecNavBar.h(cVar);
            if (h16 != null) {
                com.tencent.mobileqq.troop.homework.notice.report.a aVar = com.tencent.mobileqq.troop.homework.notice.report.a.f297331a;
                h.a.m(aVar, h16, "em_group_publish_btn", ExposurePolicy.REPORT_NONE, null, null, null, 56, null);
                aVar.f(h16);
            }
        }
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return true;
    }
}
