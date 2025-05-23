package com.tencent.mobileqq.troop.appscenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.qui.quisecnavbar.f;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.appscenter.adapter.n;
import com.tencent.mobileqq.troop.appscenter.adapter.q;
import com.tencent.mobileqq.troop.appscenter.data.e;
import com.tencent.mobileqq.troop.appscenter.mvi.TroopAppsViewModel;
import com.tencent.mobileqq.troop.appscenter.mvi.b;
import com.tencent.mobileqq.troop.shortcut.repo.TroopShortcutSettingCache;
import com.tencent.mobileqq.troop.troopapps.event.BackToAIO;
import com.tencent.mobileqq.troop.troopapps.event.CancelBindGuildEvent;
import com.tencent.mobileqq.troop.troopapps.event.CloseAIO;
import com.tencent.mobileqq.troop.troopapps.event.CloseFrame;
import com.tencent.mobileqq.troop.troopapps.event.RefreshData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqnt.kernel.nativeinterface.AppDetail;
import com.tencent.qqnt.kernel.nativeinterface.ClassRankList;
import com.tencent.qqnt.kernel.nativeinterface.RankList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 h2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001iB\u0007\u00a2\u0006\u0004\bf\u0010gJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\u0012\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0015H\u0002J\u001e\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00152\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J \u0010#\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00122\u0006\u0010\"\u001a\u00020!H\u0002J\b\u0010$\u001a\u00020\u0012H\u0014J\b\u0010&\u001a\u00020%H\u0016J\u0012\u0010(\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010)\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010'\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010*\u001a\u00020\u0006H\u0016J\b\u0010+\u001a\u00020\u0006H\u0014J\u0010\u0010,\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0012\u0010.\u001a\u00020\u00062\b\u0010-\u001a\u0004\u0018\u00010\u0003H\u0016J$\u00102\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0003000/j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000300`1H\u0016J\b\u00103\u001a\u00020\u0006H\u0016J\u0010\u00106\u001a\u00020\u00062\u0006\u00105\u001a\u000204H\u0016J\u0012\u00109\u001a\u00020\u00062\b\u00108\u001a\u0004\u0018\u000107H\u0016R\u001b\u0010>\u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001b\u0010A\u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b?\u0010;\u001a\u0004\b@\u0010=R\u001b\u0010E\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bB\u0010;\u001a\u0004\bC\u0010DR\u001b\u0010I\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bF\u0010;\u001a\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010W\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010Y\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bX\u0010VR\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010_\u001a\u00020Q8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b^\u0010SR\u0016\u0010c\u001a\u00020`8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010e\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010R\u00a8\u0006j"}, d2 = {"Lcom/tencent/mobileqq/troop/appscenter/TroopAppsFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/view/View;", "view", "", "initUI", "initListener", "Ih", "Mh", "initData", "Lcom/tencent/mobileqq/troop/appscenter/mvi/TroopAppsViewModel;", "Kh", "Landroid/os/Bundle;", "outState", "doOnSaveInstanceState", "removeFragmentState", "", "openPageType", "Oh", "Lcom/tencent/mobileqq/troop/appscenter/data/e;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Rh", "rankAppsData", "Sh", "", "", "rankList", "Gh", "Landroid/widget/LinearLayout;", "linearLayout", "newSize", "Landroid/content/Context;", "context", "Fh", "getContentLayoutId", "", "useQUISecNavBar", Constants.FILE_INSTANCE_STATE, "onCreate", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onFragmentViewDestroyed", "onSaveInstanceState", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "onResume", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "Jh", "()Ljava/lang/String;", "troopUin", "D", "getFrom", "from", "E", "getPageType", "()I", "pageType", UserInfo.SEX_FEMALE, "Lh", "()Lcom/tencent/mobileqq/troop/appscenter/mvi/TroopAppsViewModel;", "vm", "G", "Z", "isFirstRequest", "Lcom/tencent/mobileqq/troop/appscenter/adapter/n;", "H", "Lcom/tencent/mobileqq/troop/appscenter/adapter/n;", "adapter", "Landroidx/recyclerview/widget/RecyclerView;", "I", "Landroidx/recyclerview/widget/RecyclerView;", "newAppsListRecyclerView", "J", "Landroid/widget/LinearLayout;", "tabPanel", "K", "tabContainer", "Lcom/google/android/material/appbar/AppBarLayout;", "L", "Lcom/google/android/material/appbar/AppBarLayout;", "appBarLayout", "M", "rankAppRecyclerview", "Lcom/tencent/mobileqq/troop/appscenter/adapter/q;", "N", "Lcom/tencent/mobileqq/troop/appscenter/adapter/q;", "troopRankAppsListAdapter", "P", "selectedPosition", "<init>", "()V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopAppsFragment extends QIphoneTitleBarFragment implements SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy troopUin;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy from;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy pageType;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy vm;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isFirstRequest;

    /* renamed from: H, reason: from kotlin metadata */
    private n adapter;

    /* renamed from: I, reason: from kotlin metadata */
    private RecyclerView newAppsListRecyclerView;

    /* renamed from: J, reason: from kotlin metadata */
    private LinearLayout tabPanel;

    /* renamed from: K, reason: from kotlin metadata */
    private LinearLayout tabContainer;

    /* renamed from: L, reason: from kotlin metadata */
    private AppBarLayout appBarLayout;

    /* renamed from: M, reason: from kotlin metadata */
    private RecyclerView rankAppRecyclerview;

    /* renamed from: N, reason: from kotlin metadata */
    private q troopRankAppsListAdapter;

    /* renamed from: P, reason: from kotlin metadata */
    private int selectedPosition;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/troop/appscenter/TroopAppsFragment$a;", "", "Landroid/content/Context;", "context", "", "troopUin", "", "pageType", "", "a", "KEY_FROM", "Ljava/lang/String;", "KEY_PAGE_TYPE", "KEY_TROOP_UIN", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.appscenter.TroopAppsFragment$a, reason: from kotlin metadata */
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

        public final void a(@NotNull Context context, @NotNull String troopUin, int pageType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, context, troopUin, Integer.valueOf(pageType));
                return;
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            Intent intent = new Intent();
            intent.putExtra("troopUin", troopUin);
            intent.putExtra("from", "setting_page");
            intent.putExtra("pageType", pageType);
            QPublicFragmentActivity.start(context, intent, TroopAppsFragment.class);
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/appscenter/TroopAppsFragment$b", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements ViewModelProvider.Factory {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAppsFragment.this);
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
            T newInstance = modelClass.getConstructor(String.class).newInstance(TroopAppsFragment.this.Jh());
            Intrinsics.checkNotNullExpressionValue(newInstance, "modelClass.getConstructo\u2026va).newInstance(troopUin)");
            return newInstance;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J(\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00020\tj\b\u0012\u0004\u0012\u00020\u0002`\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\rH\u0016\u00a8\u0006\u0017"}, d2 = {"com/tencent/mobileqq/troop/appscenter/TroopAppsFragment$c", "Lds2/a;", "Lcom/tencent/qqnt/kernel/nativeinterface/AppDetail;", "detail", "", "a", "", "source", "f", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "remainApp", "g", "", "isEdit", "c", "b", "e", "fromPosition", "toPosition", h.F, "isChecked", "d", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c implements ds2.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAppsFragment.this);
            }
        }

        @Override // ds2.a
        public void a(@NotNull AppDetail detail) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) detail);
                return;
            }
            Intrinsics.checkNotNullParameter(detail, "detail");
            QBaseActivity qBaseActivity = TroopAppsFragment.this.getQBaseActivity();
            if (qBaseActivity != null) {
                TroopAppsFragment.this.Lh().C2(qBaseActivity, detail);
            }
        }

        @Override // ds2.a
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
                return;
            }
            Context context = TroopAppsFragment.this.getContext();
            if (context != null) {
                TroopAppsFragment.this.Lh().D2(context);
            }
        }

        @Override // ds2.a
        public void c(boolean isEdit) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, isEdit);
                return;
            }
            Context context = TroopAppsFragment.this.getContext();
            if (context != null) {
                TroopAppsFragment troopAppsFragment = TroopAppsFragment.this;
                TroopAppsViewModel Lh = troopAppsFragment.Lh();
                n nVar = troopAppsFragment.adapter;
                if (nVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    nVar = null;
                }
                Lh.B2(context, isEdit, new ArrayList<>(nVar.getItems()));
            }
        }

        @Override // ds2.a
        public void d(boolean isChecked) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, isChecked);
            } else {
                TroopAppsFragment.this.Lh().L2(isChecked);
            }
        }

        @Override // ds2.a
        public void e(@NotNull AppDetail detail) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) detail);
                return;
            }
            Intrinsics.checkNotNullParameter(detail, "detail");
            Context context = TroopAppsFragment.this.getContext();
            if (context != null) {
                TroopAppsFragment.this.Lh().F2(context, detail);
            }
        }

        @Override // ds2.a
        public void f(@NotNull AppDetail detail, int source) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) detail, source);
                return;
            }
            Intrinsics.checkNotNullParameter(detail, "detail");
            QBaseActivity qBaseActivity = TroopAppsFragment.this.getQBaseActivity();
            if (qBaseActivity != null) {
                TroopAppsFragment troopAppsFragment = TroopAppsFragment.this;
                n nVar = null;
                if (detail.type == 3) {
                    TroopAppsViewModel Lh = troopAppsFragment.Lh();
                    n nVar2 = troopAppsFragment.adapter;
                    if (nVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    } else {
                        nVar = nVar2;
                    }
                    Lh.h2(qBaseActivity, detail, new ArrayList<>(nVar.getItems()), source);
                    return;
                }
                TroopAppsViewModel Lh2 = troopAppsFragment.Lh();
                n nVar3 = troopAppsFragment.adapter;
                if (nVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                } else {
                    nVar = nVar3;
                }
                Lh2.x2(qBaseActivity, detail, new ArrayList<>(nVar.getItems()), source);
            }
        }

        @Override // ds2.a
        public void g(@NotNull AppDetail detail, @NotNull ArrayList<AppDetail> remainApp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) detail, (Object) remainApp);
                return;
            }
            Intrinsics.checkNotNullParameter(detail, "detail");
            Intrinsics.checkNotNullParameter(remainApp, "remainApp");
            QBaseActivity qBaseActivity = TroopAppsFragment.this.getQBaseActivity();
            if (qBaseActivity != null) {
                TroopAppsFragment troopAppsFragment = TroopAppsFragment.this;
                TroopAppsViewModel Lh = troopAppsFragment.Lh();
                n nVar = troopAppsFragment.adapter;
                if (nVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    nVar = null;
                }
                Lh.z2(qBaseActivity, detail, new ArrayList<>(nVar.getItems()), remainApp);
            }
        }

        @Override // ds2.a
        public void h(int fromPosition, int toPosition) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                TroopAppsViewModel Lh = TroopAppsFragment.this.Lh();
                n nVar = TroopAppsFragment.this.adapter;
                if (nVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    nVar = null;
                }
                Lh.E2(fromPosition, toPosition, new ArrayList<>(nVar.getItems()));
                return;
            }
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(fromPosition), Integer.valueOf(toPosition));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/troop/appscenter/TroopAppsFragment$d", "Lcom/tencent/biz/qui/quisecnavbar/a;", "Landroid/view/View;", "view", "", "a", "", "b", "", "getDrawable", "()I", "drawable", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class d extends com.tencent.biz.qui.quisecnavbar.a {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QUISecNavBar f294342b;

        d(QUISecNavBar qUISecNavBar) {
            this.f294342b = qUISecNavBar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAppsFragment.this, (Object) qUISecNavBar);
            }
        }

        @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
        public void a(@Nullable View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
                return;
            }
            FragmentActivity activity = TroopAppsFragment.this.getActivity();
            if (activity != null) {
                TroopAppsFragment troopAppsFragment = TroopAppsFragment.this;
                QUISecNavBar qUISecNavBar = this.f294342b;
                TroopAppsViewModel Lh = troopAppsFragment.Lh();
                String troopUin = troopAppsFragment.Jh();
                Intrinsics.checkNotNullExpressionValue(troopUin, "troopUin");
                Lh.t2(Long.parseLong(troopUin), qUISecNavBar.getContext(), activity);
            }
            VideoReport.setElementId(TroopAppsFragment.this.quiSecNavBar, "em_group_search_icon");
            VideoReport.setElementExposePolicy(TroopAppsFragment.this.quiSecNavBar, ExposurePolicy.REPORT_NONE);
            VideoReport.reportEvent("dt_clck", TroopAppsFragment.this.quiSecNavBar, null);
        }

        @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
        @NotNull
        public String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return "\u641c\u7d22";
        }

        @Override // com.tencent.biz.qui.quisecnavbar.b
        public int getDrawable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return R.drawable.qui_search;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24609);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopAppsFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.troop.appscenter.TroopAppsFragment$troopUin$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopAppsFragment.this);
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
                    Bundle arguments = TroopAppsFragment.this.getArguments();
                    return (arguments == null || (string = arguments.getString("troopUin")) == null) ? "" : string;
                }
            });
            this.troopUin = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.troop.appscenter.TroopAppsFragment$from$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopAppsFragment.this);
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
                    Bundle arguments = TroopAppsFragment.this.getArguments();
                    return (arguments == null || (string = arguments.getString("from")) == null) ? "" : string;
                }
            });
            this.from = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.troop.appscenter.TroopAppsFragment$pageType$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopAppsFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Integer invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Integer) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    Bundle arguments = TroopAppsFragment.this.getArguments();
                    return Integer.valueOf(arguments != null ? arguments.getInt("pageType", 2) : 2);
                }
            });
            this.pageType = lazy3;
            lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<TroopAppsViewModel>() { // from class: com.tencent.mobileqq.troop.appscenter.TroopAppsFragment$vm$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopAppsFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final TroopAppsViewModel invoke() {
                    TroopAppsViewModel Kh;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (TroopAppsViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    Kh = TroopAppsFragment.this.Kh();
                    return Kh;
                }
            });
            this.vm = lazy4;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final void Fh(LinearLayout linearLayout, int newSize, Context context) {
        int childCount = linearLayout.getChildCount();
        LayoutInflater from = LayoutInflater.from(context);
        if (newSize > childCount) {
            while (childCount < newSize) {
                linearLayout.addView(from.inflate(R.layout.g1h, (ViewGroup) linearLayout, false));
                childCount++;
            }
        } else if (newSize < childCount) {
            linearLayout.removeViews(newSize, childCount - newSize);
        }
    }

    private final void Gh(final e rankAppsData, List<String> rankList) {
        final int i3 = 0;
        if (this.selectedPosition >= rankAppsData.c().get(0).classRankList.size()) {
            this.selectedPosition = 0;
        }
        if (rankAppsData.c().get(0).classRankList.get(this.selectedPosition) != null) {
            Sh(rankAppsData);
        }
        LinearLayout linearLayout = this.tabPanel;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabPanel");
            linearLayout = null;
        }
        if (rankList.size() != linearLayout.getChildCount()) {
            LinearLayout linearLayout2 = this.tabPanel;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabPanel");
                linearLayout2 = null;
            }
            int size = rankList.size();
            LinearLayout linearLayout3 = this.tabPanel;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabPanel");
                linearLayout3 = null;
            }
            Context context = linearLayout3.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "tabPanel.context");
            Fh(linearLayout2, size, context);
        }
        for (String str : rankList) {
            int i16 = i3 + 1;
            LinearLayout linearLayout4 = this.tabPanel;
            if (linearLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabPanel");
                linearLayout4 = null;
            }
            final TextView textView = (TextView) linearLayout4.getChildAt(i3).findViewById(R.id.su5);
            textView.setText(str);
            if (i3 == this.selectedPosition) {
                textView.setTextColor(Color.parseColor("#0099FF"));
                textView.setBackgroundResource(R.drawable.kco);
            } else {
                textView.setTextColor(textView.getContext().getResources().getColorStateList(R.color.qui_common_text_secondary, null));
                textView.setBackgroundResource(R.drawable.kcn);
            }
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.appscenter.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TroopAppsFragment.Hh(TroopAppsFragment.this, i3, textView, rankAppsData, view);
                }
            });
            i3 = i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(TroopAppsFragment this$0, int i3, TextView textView, e rankAppsData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(rankAppsData, "$rankAppsData");
        if (this$0.selectedPosition != i3) {
            LinearLayout linearLayout = this$0.tabPanel;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabPanel");
                linearLayout = null;
            }
            TextView textView2 = (TextView) linearLayout.getChildAt(this$0.selectedPosition).findViewById(R.id.su5);
            textView2.setBackgroundResource(R.drawable.kcn);
            textView2.setTextColor(textView.getContext().getResources().getColorStateList(R.color.qui_common_text_secondary, null));
            this$0.selectedPosition = i3;
            textView.setBackgroundResource(R.drawable.kco);
            textView.setTextColor(Color.parseColor("#0099FF"));
        }
        this$0.Sh(rankAppsData);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ih() {
        Collection collection;
        TroopAppsViewModel Lh = Lh();
        n nVar = this.adapter;
        ArrayList<com.tencent.mobileqq.troop.appscenter.data.a> arrayList = null;
        if (nVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            nVar = null;
        }
        List<com.tencent.mobileqq.troop.appscenter.data.a> items = nVar.getItems();
        if (items != null) {
            collection = CollectionsKt___CollectionsKt.toCollection(items, new ArrayList());
            arrayList = (ArrayList) collection;
        }
        Lh.l2(arrayList);
        Lh().w2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String Jh() {
        return (String) this.troopUin.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopAppsViewModel Kh() {
        ViewModel viewModel = new ViewModelProvider(this, new b()).get(TroopAppsViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "private fun getVM(): Tro\u2026lass.java\n        )\n    }");
        return (TroopAppsViewModel) viewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopAppsViewModel Lh() {
        return (TroopAppsViewModel) this.vm.getValue();
    }

    private final void Mh() {
        MutableLiveData<com.tencent.mobileqq.troop.appscenter.mvi.b> obtainUiState = Lh().obtainUiState();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<com.tencent.mobileqq.troop.appscenter.mvi.b, Unit> function1 = new Function1<com.tencent.mobileqq.troop.appscenter.mvi.b, Unit>() { // from class: com.tencent.mobileqq.troop.appscenter.TroopAppsFragment$initObserver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAppsFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.appscenter.mvi.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.troop.appscenter.mvi.b bVar) {
                ArrayList<RankList> c16;
                Object firstOrNull;
                ArrayList<RankList> c17;
                Object firstOrNull2;
                ArrayList<ClassRankList> arrayList;
                int i3;
                boolean z16;
                ArrayList<RankList> c18;
                Object firstOrNull3;
                RankList rankList;
                RecyclerView recyclerView;
                RecyclerView recyclerView2;
                RecyclerView recyclerView3;
                RecyclerView recyclerView4;
                ArrayList<RankList> c19;
                Object firstOrNull4;
                Long longOrNull;
                int collectionSizeOrDefault;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
                    return;
                }
                ArrayList<ClassRankList> arrayList2 = null;
                n nVar = null;
                r4 = null;
                r4 = null;
                ArrayList<ClassRankList> arrayList3 = null;
                r4 = null;
                r4 = null;
                r4 = null;
                ClassRankList classRankList = null;
                n nVar2 = null;
                arrayList2 = null;
                arrayList2 = null;
                if (bVar instanceof b.C8674b) {
                    TroopShortcutSettingCache a16 = TroopShortcutSettingCache.INSTANCE.a();
                    String troopUin = TroopAppsFragment.this.Jh();
                    Intrinsics.checkNotNullExpressionValue(troopUin, "troopUin");
                    longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
                    if (a16.f(longOrNull != null ? longOrNull.longValue() : 0L)) {
                        TroopInfo r26 = TroopAppsFragment.this.Lh().r2();
                        boolean z17 = r26 != null && r26.isOwnerOrAdmin();
                        n nVar3 = TroopAppsFragment.this.adapter;
                        if (nVar3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adapter");
                            nVar3 = null;
                        }
                        n nVar4 = TroopAppsFragment.this.adapter;
                        if (nVar4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        } else {
                            nVar = nVar4;
                        }
                        List<com.tencent.mobileqq.troop.appscenter.data.a> items = nVar.getItems();
                        Intrinsics.checkNotNullExpressionValue(items, "adapter.items");
                        List<com.tencent.mobileqq.troop.appscenter.data.a> list = items;
                        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                        ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault);
                        for (com.tencent.mobileqq.troop.appscenter.data.a aVar : list) {
                            if (aVar instanceof com.tencent.mobileqq.troop.appscenter.data.b ? true : aVar instanceof com.tencent.mobileqq.troop.appscenter.data.c) {
                                if ((!((b.C8674b) bVar).b() || z17) != false) {
                                    aVar = new com.tencent.mobileqq.troop.appscenter.data.b(true, !r7.a(), z17, aVar.a());
                                } else {
                                    aVar = new com.tencent.mobileqq.troop.appscenter.data.c("\u60f3\u8981\u5feb\u6377\u4f7f\u7528\u7fa4\u5e94\u7528\uff0c\u53ef\u8054\u7cfb\u7fa4\u4e3b/\u7ba1\u7406\u5458\u5f00\u542f\u5feb\u6377\u680f\u5c55\u793a\u54e6\uff5e", aVar.a());
                                }
                            }
                            arrayList4.add(aVar);
                        }
                        nVar3.setItems(arrayList4);
                        return;
                    }
                    return;
                }
                if (bVar instanceof b.a) {
                    z16 = TroopAppsFragment.this.isFirstRequest;
                    if (!z16) {
                        e b16 = ((b.a) bVar).b();
                        if (b16 == null || (c19 = b16.c()) == null) {
                            rankList = null;
                        } else {
                            firstOrNull4 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) c19);
                            rankList = (RankList) firstOrNull4;
                        }
                        if (rankList == null) {
                            recyclerView3 = TroopAppsFragment.this.newAppsListRecyclerView;
                            if (recyclerView3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("newAppsListRecyclerView");
                                recyclerView3 = null;
                            }
                            ViewGroup.LayoutParams layoutParams = recyclerView3.getLayoutParams();
                            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.LayoutParams");
                            AppBarLayout.LayoutParams layoutParams2 = (AppBarLayout.LayoutParams) layoutParams;
                            recyclerView4 = TroopAppsFragment.this.newAppsListRecyclerView;
                            if (recyclerView4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("newAppsListRecyclerView");
                                recyclerView4 = null;
                            }
                            recyclerView4.setMinimumHeight(ViewUtils.getScreenHeight() - f.g());
                            layoutParams2.g(3);
                            ((LinearLayout.LayoutParams) layoutParams2).bottomMargin = 0;
                        } else {
                            recyclerView = TroopAppsFragment.this.newAppsListRecyclerView;
                            if (recyclerView == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("newAppsListRecyclerView");
                                recyclerView = null;
                            }
                            ViewGroup.LayoutParams layoutParams3 = recyclerView.getLayoutParams();
                            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.LayoutParams");
                            AppBarLayout.LayoutParams layoutParams4 = (AppBarLayout.LayoutParams) layoutParams3;
                            recyclerView2 = TroopAppsFragment.this.newAppsListRecyclerView;
                            if (recyclerView2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("newAppsListRecyclerView");
                                recyclerView2 = null;
                            }
                            recyclerView2.setMinimumHeight(0);
                            layoutParams4.g(1);
                            ((LinearLayout.LayoutParams) layoutParams4).bottomMargin = ViewUtils.dpToPx(16.0f);
                        }
                    }
                    TroopAppsFragment.this.isFirstRequest = true;
                    n nVar5 = TroopAppsFragment.this.adapter;
                    if (nVar5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        nVar5 = null;
                    }
                    b.a aVar2 = (b.a) bVar;
                    nVar5.setItems(aVar2.a());
                    e b17 = aVar2.b();
                    if (b17 != null && (c18 = b17.c()) != null) {
                        firstOrNull3 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) c18);
                        RankList rankList2 = (RankList) firstOrNull3;
                        if (rankList2 != null) {
                            arrayList3 = rankList2.getClassRankList();
                        }
                    }
                    if (arrayList3 != null) {
                        TroopAppsFragment.this.Rh(aVar2.b());
                        return;
                    }
                    return;
                }
                if (bVar instanceof b.c) {
                    n nVar6 = TroopAppsFragment.this.adapter;
                    if (nVar6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        nVar6 = null;
                    }
                    b.c cVar = (b.c) bVar;
                    nVar6.setItems(cVar.a());
                    n nVar7 = TroopAppsFragment.this.adapter;
                    if (nVar7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        nVar7 = null;
                    }
                    nVar7.notifyDataSetChanged();
                    e b18 = cVar.b();
                    if (b18 != null && (c17 = b18.c()) != null) {
                        firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) c17);
                        RankList rankList3 = (RankList) firstOrNull2;
                        if (rankList3 != null && (arrayList = rankList3.classRankList) != null) {
                            i3 = TroopAppsFragment.this.selectedPosition;
                            classRankList = arrayList.get(i3);
                        }
                    }
                    if (classRankList != null) {
                        TroopAppsFragment.this.Sh(cVar.b());
                        return;
                    }
                    return;
                }
                if (bVar instanceof b.e) {
                    n nVar8 = TroopAppsFragment.this.adapter;
                    if (nVar8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        nVar8 = null;
                    }
                    nVar8.setItems(((b.e) bVar).a());
                    n nVar9 = TroopAppsFragment.this.adapter;
                    if (nVar9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    } else {
                        nVar2 = nVar9;
                    }
                    nVar2.notifyDataSetChanged();
                    return;
                }
                if (bVar instanceof b.d) {
                    b.d dVar = (b.d) bVar;
                    e a17 = dVar.a();
                    if (a17 != null && (c16 = a17.c()) != null) {
                        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) c16);
                        RankList rankList4 = (RankList) firstOrNull;
                        if (rankList4 != null) {
                            arrayList2 = rankList4.getClassRankList();
                        }
                    }
                    if (arrayList2 != null) {
                        TroopAppsFragment.this.Rh(dVar.a());
                    }
                }
            }
        };
        obtainUiState.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.appscenter.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopAppsFragment.Nh(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Oh(int openPageType) {
        HashMap hashMapOf;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        View view = ((QIphoneTitleBarFragment) this).mContentView;
        if (openPageType != 2) {
            view = activity.getWindow().getDecorView();
            VideoReport.addToDetectionWhitelist(activity);
        }
        this.quiSecNavBar.post(new Runnable() { // from class: com.tencent.mobileqq.troop.appscenter.c
            @Override // java.lang.Runnable
            public final void run() {
                TroopAppsFragment.Ph(TroopAppsFragment.this);
            }
        });
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("group_id", Jh()), TuplesKt.to("open_page_type", Integer.valueOf(openPageType)));
        VideoReport.setPageId(view, "pg_group_app_list");
        VideoReport.setPageParams(view, new PageParams(hashMapOf));
        VideoReport.ignorePageInOutEvent(view, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(TroopAppsFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VideoReport.setElementId(this$0.quiSecNavBar, "em_group_search_icon");
        VideoReport.setElementExposePolicy(this$0.quiSecNavBar, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(this$0.quiSecNavBar, ClickPolicy.REPORT_NONE);
        VideoReport.setLogicParent(this$0.quiSecNavBar, ((QIphoneTitleBarFragment) this$0).mContentView);
        VideoReport.reportEvent("dt_imp", this$0.quiSecNavBar, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat Qh(View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(insets, "insets.getInsets(WindowI\u2026Compat.Type.systemBars())");
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), insets.bottom);
        return WindowInsetsCompat.CONSUMED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Rh(e item) {
        ArrayList arrayList = new ArrayList();
        ArrayList<ClassRankList> classRankList = item.c().get(0).getClassRankList();
        Intrinsics.checkNotNullExpressionValue(classRankList, "item.rankList[0].getClassRankList()");
        Iterator<T> it = classRankList.iterator();
        while (it.hasNext()) {
            String str = ((ClassRankList) it.next()).msgClass.name;
            Intrinsics.checkNotNullExpressionValue(str, "its.msgClass.name");
            arrayList.add(str);
        }
        Gh(item, arrayList);
        LinearLayout linearLayout = this.tabContainer;
        RecyclerView recyclerView = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabContainer");
            linearLayout = null;
        }
        linearLayout.setVisibility(0);
        RecyclerView recyclerView2 = this.rankAppRecyclerview;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rankAppRecyclerview");
        } else {
            recyclerView = recyclerView2;
        }
        recyclerView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Sh(e rankAppsData) {
        ClassRankList classRankList = rankAppsData.c().get(0).classRankList.get(this.selectedPosition);
        q qVar = this.troopRankAppsListAdapter;
        q qVar2 = null;
        if (qVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopRankAppsListAdapter");
            qVar = null;
        }
        ArrayList<AppDetail> arrayList = classRankList.classApps;
        Intrinsics.checkNotNullExpressionValue(arrayList, "classRank.classApps");
        String str = classRankList.msgClass.name;
        Intrinsics.checkNotNullExpressionValue(str, "classRank.msgClass.name");
        qVar.r0(arrayList, str, rankAppsData.d(), rankAppsData.a());
        q qVar3 = this.troopRankAppsListAdapter;
        if (qVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopRankAppsListAdapter");
        } else {
            qVar2 = qVar3;
        }
        qVar2.notifyDataSetChanged();
    }

    private final void doOnSaveInstanceState(Bundle outState) {
        removeFragmentState(outState);
        if (outState != null) {
            removeFragmentState(outState.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getFrom() {
        return (String) this.from.getValue();
    }

    private final int getPageType() {
        return ((Number) this.pageType.getValue()).intValue();
    }

    private final void initData() {
        Context context = getContext();
        if (context != null) {
            Lh().v2(context);
        }
        QLog.i("TroopAppsCenter.TroopAppsFragment", 1, "isFragmentAdded = " + isAdded() + ", isFragmentStateSaved = " + isStateSaved());
    }

    private final void initListener() {
        c cVar = new c();
        this.troopRankAppsListAdapter = new q(cVar);
        RecyclerView recyclerView = this.rankAppRecyclerview;
        n nVar = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rankAppRecyclerview");
            recyclerView = null;
        }
        recyclerView.setItemAnimator(null);
        RecyclerView recyclerView2 = this.rankAppRecyclerview;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rankAppRecyclerview");
            recyclerView2 = null;
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView recyclerView3 = this.rankAppRecyclerview;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rankAppRecyclerview");
            recyclerView3 = null;
        }
        q qVar = this.troopRankAppsListAdapter;
        if (qVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopRankAppsListAdapter");
            qVar = null;
        }
        recyclerView3.setAdapter(qVar);
        this.adapter = new n(cVar);
        RecyclerView recyclerView4 = this.newAppsListRecyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newAppsListRecyclerView");
            recyclerView4 = null;
        }
        recyclerView4.setItemAnimator(null);
        n nVar2 = this.adapter;
        if (nVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            nVar = nVar2;
        }
        recyclerView4.setAdapter(nVar);
        recyclerView4.setLayoutManager(new LinearLayoutManager(getQBaseActivity()));
    }

    private final void initUI(View view) {
        View findViewById = view.findViewById(R.id.f101225um);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.troop_apps_recycler_view)");
        this.newAppsListRecyclerView = (RecyclerView) findViewById;
        View findViewById2 = view.findViewById(R.id.f101165ug);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.troop_app_tab_panel)");
        this.tabPanel = (LinearLayout) findViewById2;
        View findViewById3 = view.findViewById(R.id.f101115ub);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.t\u2026op_app_rank_recyclerview)");
        this.rankAppRecyclerview = (RecyclerView) findViewById3;
        View findViewById4 = view.findViewById(R.id.j_a);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.tab_container)");
        this.tabContainer = (LinearLayout) findViewById4;
        View findViewById5 = view.findViewById(R.id.sqk);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.app_bar_layout)");
        this.appBarLayout = (AppBarLayout) findViewById5;
        QUISecNavBar qUISecNavBar = this.quiSecNavBar;
        TroopInfo r26 = Lh().r2();
        boolean z16 = false;
        if (r26 != null && r26.isOwnerOrAdmin()) {
            z16 = true;
        }
        if (z16) {
            qUISecNavBar.d(new d(qUISecNavBar));
        }
        qUISecNavBar.setOnBaseTitleBarClickListener(new Function2<View, BaseAction, Unit>() { // from class: com.tencent.mobileqq.troop.appscenter.TroopAppsFragment$initUI$1$2
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes19.dex */
            public /* synthetic */ class a {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f294343a;

                static {
                    IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24586);
                    $redirector_ = redirector;
                    if (redirector != null && redirector.hasPatch((short) 1)) {
                        redirector.redirect((short) 1);
                        return;
                    }
                    int[] iArr = new int[BaseAction.values().length];
                    try {
                        iArr[BaseAction.ACTION_LEFT_BUTTON.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    f294343a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAppsFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view2, BaseAction baseAction) {
                invoke2(view2, baseAction);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View v3, @NotNull BaseAction action) {
                String from;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3, (Object) action);
                    return;
                }
                Intrinsics.checkNotNullParameter(v3, "v");
                Intrinsics.checkNotNullParameter(action, "action");
                if (a.f294343a[action.ordinal()] == 1) {
                    from = TroopAppsFragment.this.getFrom();
                    Intrinsics.checkNotNullExpressionValue(from, "from");
                    if (from.length() == 0) {
                        SimpleEventBus.getInstance().dispatchEvent(CloseFrame.INSTANCE);
                        TroopAppsFragment.this.Ih();
                    } else {
                        FragmentActivity activity = TroopAppsFragment.this.getActivity();
                        if (activity != null) {
                            activity.finish();
                        }
                    }
                }
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(((QIphoneTitleBarFragment) this).mContentView, new OnApplyWindowInsetsListener() { // from class: com.tencent.mobileqq.troop.appscenter.b
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                WindowInsetsCompat Qh;
                Qh = TroopAppsFragment.Qh(view2, windowInsetsCompat);
                return Qh;
            }
        });
    }

    private final void removeFragmentState(Bundle outState) {
        if (outState != null) {
            outState.remove("android:viewHierarchyState");
            outState.remove("android:fragments");
            outState.remove("android:support:fragments");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.fzf;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ArrayList) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(CancelBindGuildEvent.class);
        arrayList.add(RefreshData.class);
        arrayList.add(BackToAIO.class);
        arrayList.add(CloseAIO.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) activity);
        } else {
            if (!(activity instanceof QBaseActivity)) {
                return;
            }
            com.tencent.mobileqq.theme.a.d(((QBaseActivity) activity).getWindow());
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        n nVar;
        Context context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) newConfig);
            return;
        }
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        if (Lh() != null && (nVar = this.adapter) != null) {
            n nVar2 = null;
            if (nVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                nVar = null;
            }
            Intrinsics.checkNotNullExpressionValue(nVar.getItems(), "adapter.items");
            if ((!r6.isEmpty()) && (context = getContext()) != null) {
                TroopAppsViewModel Lh = Lh();
                n nVar3 = this.adapter;
                if (nVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                } else {
                    nVar2 = nVar3;
                }
                Lh.Q2(context, new ArrayList<>(nVar2.getItems()));
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) savedInstanceState);
        } else {
            super.onCreate(savedInstanceState);
            SimpleEventBus.getInstance().registerReceiver(this);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onDestroy();
        Lh().w2();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onFragmentViewDestroyed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            ((QIphoneTitleBarFragment) this).mContentView = null;
            super.onFragmentViewDestroyed();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) event);
            return;
        }
        if (event instanceof CancelBindGuildEvent) {
            TroopAppsViewModel Lh = Lh();
            Context context = getContext();
            n nVar = this.adapter;
            if (nVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                nVar = null;
            }
            Lh.n2(context, new ArrayList<>(nVar.getItems()));
            return;
        }
        if (!(event instanceof RefreshData)) {
            if (event instanceof BackToAIO) {
                Ih();
            } else if (event instanceof CloseAIO) {
                SimpleEventBus.getInstance().unRegisterReceiver(this);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Context context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.onResume();
        if (Lh() != null && this.isFirstRequest && (context = getContext()) != null) {
            TroopAppsViewModel Lh = Lh();
            n nVar = this.adapter;
            if (nVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                nVar = null;
            }
            Lh.S2(context, new ArrayList<>(nVar.getItems()));
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle outState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) outState);
            return;
        }
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        doOnSaveInstanceState(outState);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setTitle("\u7fa4\u5e94\u7528\u4e2d\u5fc3");
        initUI(view);
        initListener();
        Mh();
        initData();
        Oh(getPageType());
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }
}
