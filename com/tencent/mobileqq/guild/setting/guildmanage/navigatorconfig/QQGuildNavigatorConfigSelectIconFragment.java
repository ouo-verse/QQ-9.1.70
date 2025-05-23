package com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon;
import com.tencent.mobileqq.guild.widget.RecyclerViewWithHeaderFooter;
import com.tencent.mobileqq.utils.ViewUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0012\u001a\u00020\nH\u0014J&\u0010\u0019\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0014R#\u0010 \u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010%\u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/QQGuildNavigatorConfigSelectIconFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTitleBarFragment;", "", "setStatusBar", "initUI", "", "isEnable", "Mh", "Lcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/ConfigIconItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "index", "Lh", "", "iconId", "", "Jh", "(Ljava/lang/Long;)Ljava/lang/String;", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "Lcom/tencent/mobileqq/guild/widget/RecyclerViewWithHeaderFooter;", "kotlin.jvm.PlatformType", "T", "Lkotlin/Lazy;", "Kh", "()Lcom/tencent/mobileqq/guild/widget/RecyclerViewWithHeaderFooter;", "rvIcons", "Lcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/ConfigIconAdapter;", "U", "Ih", "()Lcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/ConfigIconAdapter;", "adapter", "<init>", "()V", "V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class QQGuildNavigatorConfigSelectIconFragment extends QQGuildTitleBarFragment {

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final Lazy rvIcons;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final Lazy adapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ_\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00108\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00108\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00108\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/QQGuildNavigatorConfigSelectIconFragment$a;", "", "Lcom/tencent/mobileqq/app/QBaseFragment;", "fragment", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/ConfigIconItem;", "Lkotlin/collections/ArrayList;", "themeIcons", "blackThemeIcons", "", "inputIconId", "", "reqCode", "", "a", "(Lcom/tencent/mobileqq/app/QBaseFragment;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/Long;I)V", "", "KEY_BLACK_THEME_ICONS", "Ljava/lang/String;", "KEY_INPUT_ICON_ID", "KEY_THEME_ICONS", "RES_KEY_ICON_ID", "RES_KEY_ICON_URI", "nullIconId", "J", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigSelectIconFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull QBaseFragment fragment, @NotNull ArrayList<ConfigIconItem> themeIcons, @Nullable ArrayList<ConfigIconItem> blackThemeIcons, @Nullable Long inputIconId, int reqCode) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(themeIcons, "themeIcons");
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("themeIcons", themeIcons);
            bundle.putSerializable("blackThemeIcons", blackThemeIcons);
            if (inputIconId != null) {
                inputIconId.longValue();
                bundle.putLong("inputIconId", inputIconId.longValue());
            }
            intent.putExtras(bundle);
            QPublicFragmentActivity.b.g(fragment, intent, QPublicFragmentActivity.class, QQGuildNavigatorConfigSelectIconFragment.class, reqCode);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/navigatorconfig/QQGuildNavigatorConfigSelectIconFragment$b", "Lcom/tencent/mobileqq/guild/widget/GuildDefaultThemeNavBarCommon$a;", "Landroid/view/View;", "v", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "onItemSelect", "", "onItemLongClick", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements GuildDefaultThemeNavBarCommon.a {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon.a
        public boolean onItemLongClick(@Nullable View v3, int item) {
            return false;
        }

        @Override // com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon.a
        public void onItemSelect(@Nullable View v3, int item) {
            if (item != 1) {
                if (item == 2) {
                    if (QQGuildNavigatorConfigSelectIconFragment.this.Ih().l0() != null) {
                        Pair<Integer, ConfigIconItem> l06 = QQGuildNavigatorConfigSelectIconFragment.this.Ih().l0();
                        Intrinsics.checkNotNull(l06);
                        ConfigIconItem second = l06.getSecond();
                        Intent intent = new Intent();
                        intent.putExtra("resIconId", second.getId());
                        intent.putExtra("resIconUri", second.getIcon());
                        FragmentActivity activity = QQGuildNavigatorConfigSelectIconFragment.this.getActivity();
                        if (activity != null) {
                            activity.setResult(-1, intent);
                        }
                    }
                    FragmentActivity activity2 = QQGuildNavigatorConfigSelectIconFragment.this.getActivity();
                    if (activity2 != null) {
                        activity2.finish();
                        return;
                    }
                    return;
                }
                return;
            }
            FragmentActivity activity3 = QQGuildNavigatorConfigSelectIconFragment.this.getActivity();
            if (activity3 != null) {
                activity3.setResult(0);
            }
            FragmentActivity activity4 = QQGuildNavigatorConfigSelectIconFragment.this.getActivity();
            if (activity4 != null) {
                activity4.finish();
            }
        }
    }

    public QQGuildNavigatorConfigSelectIconFragment() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RecyclerViewWithHeaderFooter>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigSelectIconFragment$rvIcons$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RecyclerViewWithHeaderFooter invoke() {
                View view;
                view = ((QQGuildCustomTitleBarFragment) QQGuildNavigatorConfigSelectIconFragment.this).P;
                return (RecyclerViewWithHeaderFooter) view.findViewById(R.id.f790248n);
            }
        });
        this.rvIcons = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ConfigIconAdapter>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.QQGuildNavigatorConfigSelectIconFragment$adapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ConfigIconAdapter invoke() {
                LayoutInflater layoutInflater = QQGuildNavigatorConfigSelectIconFragment.this.getLayoutInflater();
                Intrinsics.checkNotNullExpressionValue(layoutInflater, "layoutInflater");
                return new ConfigIconAdapter(layoutInflater);
            }
        });
        this.adapter = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConfigIconAdapter Ih() {
        return (ConfigIconAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String Jh(Long iconId) {
        Serializable serializable;
        ArrayList arrayList;
        ConfigIconItem configIconItem;
        Object obj;
        boolean z16;
        int collectionSizeOrDefault;
        if (iconId == null) {
            return null;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            serializable = arguments.getSerializable("blackThemeIcons");
        } else {
            serializable = null;
        }
        ArrayList arrayList2 = (ArrayList) serializable;
        if (arrayList2 != null) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
            arrayList = new ArrayList(collectionSizeOrDefault);
            for (Object obj2 : arrayList2) {
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.ConfigIconItem");
                arrayList.add((ConfigIconItem) obj2);
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((ConfigIconItem) obj).getId() == iconId.longValue()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            configIconItem = (ConfigIconItem) obj;
        } else {
            configIconItem = null;
        }
        if (configIconItem == null) {
            return null;
        }
        return configIconItem.getIcon();
    }

    private final RecyclerViewWithHeaderFooter Kh() {
        return (RecyclerViewWithHeaderFooter) this.rvIcons.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Lh(ConfigIconItem item, int index) {
        Ih().m0(TuplesKt.to(Integer.valueOf(index), item));
        item.setCheck(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Mh(boolean isEnable) {
        if (isEnable) {
            this.J.h().setEnabled(true);
            this.J.h().setAlpha(1.0f);
        } else {
            this.J.h().setEnabled(false);
            this.J.h().setAlpha(0.3f);
        }
    }

    private final void initUI() {
        Object obj;
        List list;
        int collectionSizeOrDefault;
        this.J.a();
        this.J.setTitle(getString(R.string.f1509816g));
        this.J.setRightText(R.string.h3s);
        this.J.setOnItemSelectListener(new b());
        Ih().k0(new QQGuildNavigatorConfigSelectIconFragment$initUI$2(this));
        RecyclerViewWithHeaderFooter Kh = Kh();
        FrameLayout frameLayout = new FrameLayout(Kh().getContext());
        frameLayout.addView(new View(frameLayout.getContext()), -1, ViewUtils.dip2px(31.0f));
        Kh.C(frameLayout);
        Kh().setLayoutManager(new GridLayoutManager(requireContext(), 4, 1, false));
        Kh().setAdapter(Ih());
        Bundle arguments = getArguments();
        Long l3 = null;
        if (arguments != null) {
            obj = arguments.get("themeIcons");
        } else {
            obj = null;
        }
        ArrayList arrayList = (ArrayList) obj;
        if (arrayList != null) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (Object obj2 : arrayList) {
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.tencent.mobileqq.guild.setting.guildmanage.navigatorconfig.ConfigIconItem");
                arrayList2.add((ConfigIconItem) obj2);
            }
            list = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
        } else {
            list = null;
        }
        if (list == null) {
            list = new ArrayList();
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            l3 = Long.valueOf(arguments2.getLong("inputIconId", -9999999L));
        }
        if (l3 != null && l3.longValue() != -9999999) {
            int i3 = 0;
            for (Object obj3 : list) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                ConfigIconItem configIconItem = (ConfigIconItem) obj3;
                if (configIconItem.getId() == l3.longValue()) {
                    Lh(configIconItem, i3);
                } else {
                    configIconItem.setCheck(false);
                }
                i3 = i16;
            }
        }
        Ih().submitList(list);
        Mh(false);
    }

    private final void setStatusBar() {
        QQGuildUIUtil.L(getActivity(), getResources().getColor(R.color.qui_common_bg_bottom_light));
        boolean z16 = !GuildThemeManager.f235286a.b();
        Window window = requireActivity().getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "requireActivity().window");
        GuildThemeManager.i(z16, window);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        setStatusBar();
        initUI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f168139f11;
    }
}
