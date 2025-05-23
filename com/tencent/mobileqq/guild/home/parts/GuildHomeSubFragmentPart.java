package com.tencent.mobileqq.guild.home.parts;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.component.GuildQUIPageTabBar;
import com.tencent.mobileqq.guild.config.GuildArgusPreloadConfigParser;
import com.tencent.mobileqq.guild.event.GuildFeedManagePermissionChangeEvent;
import com.tencent.mobileqq.guild.event.GuildHomeTabChangeEvent;
import com.tencent.mobileqq.guild.home.parts.GuildHomeSubFragmentPart;
import com.tencent.mobileqq.guild.home.subhome.c;
import com.tencent.mobileqq.guild.home.views.GuildHomeSubFragmentContentLayout;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.Cdo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelIdList;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJumpToCategoryInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qzone.QzoneIPCModule;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.api.IRuntimeService;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0091\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\t*\u0001Y\u0018\u0000 _2\u00020\u0001:\u0001`B\u0007\u00a2\u0006\u0004\b]\u0010^J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0006\u001a\u00020\u0004J\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\"\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0016\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\u0004J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0012\u0010\u001c\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u001f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010 \u001a\u00020\u0004H\u0002J\b\u0010!\u001a\u00020\u0004H\u0002J\b\u0010\"\u001a\u00020\u0004H\u0002J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0018\u0010&\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u0014H\u0002J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'H\u0002J\b\u0010*\u001a\u00020\u0004H\u0002J\b\u0010+\u001a\u00020\u0004H\u0002J\u0010\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,H\u0002J\b\u0010/\u001a\u00020\u0004H\u0002J\b\u00100\u001a\u00020\u0014H\u0002R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u001a\u0010@\u001a\b\u0012\u0004\u0012\u00020'0=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010F\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010I\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010K\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010BR\u0016\u0010N\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u001b\u0010S\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u0018\u0010W\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010X\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010HR\u0014\u0010\\\u001a\u00020Y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010[\u00a8\u0006a"}, d2 = {"Lcom/tencent/mobileqq/guild/home/parts/GuildHomeSubFragmentPart;", "Lcom/tencent/mobileqq/guild/home/parts/a;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", LocaleUtils.L_JAPANESE, "Lcom/tencent/mobileqq/webview/swift/WebViewFragment;", "ma", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "", "categoryId", "", "smoothScroll", "Ja", "La", "Ba", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "onPartDestroy", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "va", "Da", "Ka", "za", "index", "isClick", "Ca", "Lcom/tencent/mobileqq/guild/home/subhome/c$b;", "currentTabData", "la", "initData", "Ma", "", "realNameAuthUrl", "Ga", "Ea", "Aa", "Lcom/tencent/mobileqq/guild/home/views/GuildHomeSubFragmentContentLayout;", "e", "Lcom/tencent/mobileqq/guild/home/views/GuildHomeSubFragmentContentLayout;", "contentLayout", "Lcom/tencent/mobileqq/guild/home/subhome/c;", "f", "Lcom/tencent/mobileqq/guild/home/subhome/c;", "tabViewPager2Adapter", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", tl.h.F, "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "reportTask", "", "i", "Ljava/util/List;", "dataList", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "currentOrientation", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/home/subhome/c$b;", "currentSubTab", "D", "Z", "needLocated", "E", "manageIndex", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "currentGuildId", "G", "Lkotlin/Lazy;", "na", "()I", "realNameAuthThreshold", "Lis1/f;", "H", "Lis1/f;", "realNameAuthListener", "isRealNameAuthShowed", "com/tencent/mobileqq/guild/home/parts/GuildHomeSubFragmentPart$b", "J", "Lcom/tencent/mobileqq/guild/home/parts/GuildHomeSubFragmentPart$b;", "fragmentLifecycleCallbacks", "<init>", "()V", "K", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeSubFragmentPart extends a {

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static boolean L;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private c.GuildHomeSubTabData currentSubTab;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy realNameAuthThreshold;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private is1.f realNameAuthListener;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isRealNameAuthShowed;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final b fragmentLifecycleCallbacks;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private GuildHomeSubFragmentContentLayout contentLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.guild.home.subhome.c tabViewPager2Adapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private IPerformanceReportTask reportTask;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int currentOrientation;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<c.GuildHomeSubTabData> dataList = new ArrayList();

    /* renamed from: D, reason: from kotlin metadata */
    private boolean needLocated = true;

    /* renamed from: E, reason: from kotlin metadata */
    private int manageIndex = -1;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private String currentGuildId = "";

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0002R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/home/parts/GuildHomeSubFragmentPart$a;", "", "Landroidx/viewpager2/widget/ViewPager2;", "", "radio", "", "a", "", "logTagListForDebug", "Z", "getLogTagListForDebug", "()Z", "c", "(Z)V", "", "CACHE_TABS_COUNT", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.home.parts.GuildHomeSubFragmentPart$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void a(ViewPager2 viewPager2, float f16) {
            try {
                Field declaredField = ViewPager2.class.getDeclaredField("mRecyclerView");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(viewPager2);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
                RecyclerView recyclerView = (RecyclerView) obj;
                Field declaredField2 = RecyclerView.class.getDeclaredField("mTouchSlop");
                declaredField2.setAccessible(true);
                Intrinsics.checkNotNull(declaredField2.get(recyclerView), "null cannot be cast to non-null type kotlin.Int");
                declaredField2.set(recyclerView, Integer.valueOf((int) (((Integer) r1).intValue() * f16)));
            } catch (RuntimeException e16) {
                com.tencent.mobileqq.guild.util.s.e("Guild.NewHome.subFrag.GuildHomeSubFragmentPart", "reduceDragSlop", e16);
            }
        }

        static /* synthetic */ void b(Companion companion, ViewPager2 viewPager2, float f16, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                f16 = 3.5f;
            }
            companion.a(viewPager2, f16);
        }

        public final void c(boolean z16) {
            GuildHomeSubFragmentPart.L = z16;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/home/parts/GuildHomeSubFragmentPart$b", "Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;", "Landroidx/fragment/app/FragmentManager;", "fm", "Landroidx/fragment/app/Fragment;", "f", "", "onFragmentResumed", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends FragmentManager.FragmentLifecycleCallbacks {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentResumed(@NotNull FragmentManager fm5, @NotNull Fragment f16) {
            com.tencent.mobileqq.guild.homev2.fragments.tabs.fragments.b bVar;
            Unit unit;
            View c65;
            Intrinsics.checkNotNullParameter(fm5, "fm");
            Intrinsics.checkNotNullParameter(f16, "f");
            super.onFragmentResumed(fm5, f16);
            int i3 = GuildHomeSubFragmentPart.this.manageIndex;
            GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout = GuildHomeSubFragmentPart.this.contentLayout;
            GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout2 = null;
            if (guildHomeSubFragmentContentLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
                guildHomeSubFragmentContentLayout = null;
            }
            if (i3 != guildHomeSubFragmentContentLayout.i().getCurrentItem()) {
                GuildHomeSubFragmentPart guildHomeSubFragmentPart = GuildHomeSubFragmentPart.this;
                GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout3 = guildHomeSubFragmentPart.contentLayout;
                if (guildHomeSubFragmentContentLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
                    guildHomeSubFragmentContentLayout3 = null;
                }
                guildHomeSubFragmentPart.manageIndex = guildHomeSubFragmentContentLayout3.i().getCurrentItem();
                GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout4 = GuildHomeSubFragmentPart.this.contentLayout;
                if (guildHomeSubFragmentContentLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
                    guildHomeSubFragmentContentLayout4 = null;
                }
                guildHomeSubFragmentContentLayout4.g().removeAllViews();
                if (f16 instanceof com.tencent.mobileqq.guild.homev2.fragments.tabs.fragments.b) {
                    bVar = (com.tencent.mobileqq.guild.homev2.fragments.tabs.fragments.b) f16;
                } else {
                    bVar = null;
                }
                if (bVar != null && (c65 = bVar.c6()) != null) {
                    GuildHomeSubFragmentPart guildHomeSubFragmentPart2 = GuildHomeSubFragmentPart.this;
                    GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout5 = guildHomeSubFragmentPart2.contentLayout;
                    if (guildHomeSubFragmentContentLayout5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
                        guildHomeSubFragmentContentLayout5 = null;
                    }
                    guildHomeSubFragmentContentLayout5.g().setMinimumWidth(ViewUtils.dpToPx(24.0f));
                    GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout6 = guildHomeSubFragmentPart2.contentLayout;
                    if (guildHomeSubFragmentContentLayout6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
                        guildHomeSubFragmentContentLayout6 = null;
                    }
                    guildHomeSubFragmentContentLayout6.g().addView(c65);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout7 = GuildHomeSubFragmentPart.this.contentLayout;
                    if (guildHomeSubFragmentContentLayout7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
                    } else {
                        guildHomeSubFragmentContentLayout2 = guildHomeSubFragmentContentLayout7;
                    }
                    guildHomeSubFragmentContentLayout2.g().setMinimumWidth(0);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/home/parts/GuildHomeSubFragmentPart$c", "Lis1/f;", "", "status", "", "onStatusChange", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements is1.f {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(int i3, GuildHomeSubFragmentPart this$0) {
            boolean z16;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (1 == i3) {
                z16 = true;
            } else {
                z16 = false;
            }
            String g16 = is1.a.g();
            Logger logger = Logger.f235387a;
            if (QLog.isDebugVersion()) {
                logger.d().d("Guild.NewHome.subFrag.GuildHomeSubFragmentPart", 1, "updateGotoAuthVisibility latest status:" + i3 + " realNameVerifyUrl:" + g16);
            }
            if (z16 && !TextUtils.isEmpty(g16)) {
                this$0.Ga(g16);
                return;
            }
            if (this$0.isRealNameAuthShowed && i3 == 2) {
                GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout = this$0.contentLayout;
                if (guildHomeSubFragmentContentLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
                    guildHomeSubFragmentContentLayout = null;
                }
                guildHomeSubFragmentContentLayout.k();
                this$0.isRealNameAuthShowed = false;
            }
        }

        @Override // is1.f
        public void onStatusChange(final int status) {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final GuildHomeSubFragmentPart guildHomeSubFragmentPart = GuildHomeSubFragmentPart.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.home.parts.cd
                @Override // java.lang.Runnable
                public final void run() {
                    GuildHomeSubFragmentPart.c.b(status, guildHomeSubFragmentPart);
                }
            });
        }
    }

    public GuildHomeSubFragmentPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.home.parts.GuildHomeSubFragmentPart$realNameAuthThreshold$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(com.tencent.mobileqq.guild.util.bs.e());
            }
        });
        this.realNameAuthThreshold = lazy;
        this.fragmentLifecycleCallbacks = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Aa() {
        boolean z16;
        boolean z17;
        Bundle bundle = z9().C;
        if (bundle != null && bundle.getBoolean("guild_is_need_jump_main_tab", false)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        String str = z9().f227658h;
        if (!GuildMainFrameUtils.q(str)) {
            IGProChannelInfo B = com.tencent.mobileqq.guild.util.ch.B(str);
            if (B != null && 7 == B.getType()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                return true;
            }
        }
        return false;
    }

    private final void Ca(int index, boolean isClick) {
        Object orNull;
        long j3;
        boolean z16;
        Iterator<c.GuildHomeSubTabData> it = this.dataList.iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                long categoryId = it.next().getCategoryId();
                c.GuildHomeSubTabData guildHomeSubTabData = this.currentSubTab;
                if (guildHomeSubTabData != null) {
                    j3 = guildHomeSubTabData.getCategoryId();
                } else {
                    j3 = 0;
                }
                if (categoryId == j3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.dataList, index);
        c.GuildHomeSubTabData guildHomeSubTabData2 = (c.GuildHomeSubTabData) orNull;
        this.currentSubTab = guildHomeSubTabData2;
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("Guild.NewHome.subFrag.GuildHomeSubFragmentPart", 1, "onTabChanged index:" + index + " isClick:" + isClick + " " + guildHomeSubTabData2);
        }
        E9().getGuildSubTabPageViewModel().U1(index, i3, isClick);
        if (guildHomeSubTabData2 != null) {
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            String str = z9().f227656e;
            Intrinsics.checkNotNullExpressionValue(str, "facadeArgsData.guildId");
            GuildHomeTabChangeEvent guildHomeTabChangeEvent = new GuildHomeTabChangeEvent(str, guildHomeSubTabData2.getCategoryId(), guildHomeSubTabData2.getType(), index, isClick);
            guildHomeTabChangeEvent.mHashCode = getContext().hashCode();
            simpleEventBus.dispatchEvent(guildHomeTabChangeEvent);
            la(guildHomeSubTabData2);
        }
    }

    private final void Da() {
        Fragment hostFragment = getHostFragment();
        Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
        IPerformanceReportTask iPerformanceReportTask = this.reportTask;
        com.tencent.mobileqq.guild.home.subhome.c cVar = null;
        if (iPerformanceReportTask == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reportTask");
            iPerformanceReportTask = null;
        }
        this.tabViewPager2Adapter = new com.tencent.mobileqq.guild.home.subhome.c(hostFragment, iPerformanceReportTask);
        GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout = this.contentLayout;
        if (guildHomeSubFragmentContentLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            guildHomeSubFragmentContentLayout = null;
        }
        ViewPager2 i3 = guildHomeSubFragmentContentLayout.i();
        com.tencent.mobileqq.guild.home.subhome.c cVar2 = this.tabViewPager2Adapter;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabViewPager2Adapter");
        } else {
            cVar = cVar2;
        }
        i3.setAdapter(cVar);
    }

    private final void Ea() {
        Context context = getContext();
        if (context != null) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230, (String) null, "\u524d\u5f80\u9891\u9053\u8bbe\u7f6e-\u8fd0\u8425\u4e2d\u5fc3\u8fdb\u884c\u4eba\u8138\u5b9e\u540d\u8ba4\u8bc1\uff0c\u53ef\u4ee5\u63d0\u5347\u9891\u9053\u4eba\u6570\u4e0a\u9650\u3002", (String) null, context.getString(R.string.f146610un), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.home.parts.bm
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GuildHomeSubFragmentPart.Fa(dialogInterface, i3);
                }
            }, (DialogInterface.OnClickListener) null);
            Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026s() }, null\n            )");
            createCustomDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fa(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ga(final String realNameAuthUrl) {
        Map emptyMap;
        if (this.isRealNameAuthShowed) {
            return;
        }
        this.isRealNameAuthShowed = true;
        GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout = this.contentLayout;
        if (guildHomeSubFragmentContentLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            guildHomeSubFragmentContentLayout = null;
        }
        View m3 = guildHomeSubFragmentContentLayout.m();
        m3.setVisibility(0);
        ImageView imageView = (ImageView) m3.findViewById(R.id.sxt);
        if (imageView != null) {
            GuildUIUtils.d(imageView, R.drawable.qui_info_filled, Integer.valueOf(R.color.qui_button_bg_primary_default));
        }
        final TextView textView = (TextView) m3.findViewById(R.id.vqu);
        if (textView != null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            com.tencent.mobileqq.guild.util.ch.W0(textView, "em_sgrp_realname_authentication", emptyMap);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.home.parts.bv
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildHomeSubFragmentPart.Ha(textView, this, realNameAuthUrl, view);
                }
            });
        }
        final ImageView imageView2 = (ImageView) m3.findViewById(R.id.sxs);
        if (imageView2 != null) {
            com.tencent.mobileqq.guild.util.ch.Y0(imageView2, "em_sgrp_realname_authentication_close", ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_NONE);
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.home.parts.bl
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildHomeSubFragmentPart.Ia(imageView2, this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ha(TextView this_apply, GuildHomeSubFragmentPart this$0, String realNameAuthUrl, View view) {
        QBaseActivity x95;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(realNameAuthUrl, "$realNameAuthUrl");
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard") && (x95 = this$0.x9()) != null) {
            com.tencent.mobileqq.guild.util.ch.i1(x95, realNameAuthUrl);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ia(ImageView this_apply, GuildHomeSubFragmentPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
            this$0.Ea();
            com.tencent.mobileqq.guild.util.bw bwVar = com.tencent.mobileqq.guild.util.bw.f235485a;
            String str = this$0.z9().f227656e;
            if (str == null) {
                str = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str, "facadeArgsData.guildId ?: \"\"");
            }
            bwVar.k1(str, true);
            GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout = this$0.contentLayout;
            if (guildHomeSubFragmentContentLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
                guildHomeSubFragmentContentLayout = null;
            }
            guildHomeSubFragmentContentLayout.k();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ka() {
        long j3;
        IGProJumpToCategoryInfo jumpToCategory = ((IGPSService) com.tencent.mobileqq.guild.util.ch.S0(IGPSService.class, "")).getJumpToCategory(z9().f227656e);
        if (jumpToCategory != null) {
            j3 = jumpToCategory.getCategoryId();
        } else {
            j3 = 0;
        }
        Logger.f235387a.d().d("Guild.NewHome.subFrag.GuildHomeSubFragmentPart", 1, "[switchToDefaultTab] defaultSettingCategoryId:" + j3);
        if (za(j3)) {
            La();
        } else {
            Ja(j3, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ma() {
        boolean z16;
        boolean z17;
        IGProGuildInfo value = E9().getGuildHomeTitleViewModel().e2().getValue();
        if (value == null) {
            Logger logger = Logger.f235387a;
            if (QLog.isDebugVersion()) {
                logger.d().d("Guild.NewHome.subFrag.GuildHomeSubFragmentPart", 1, "updateGotoAuthVisibility guildInfo is null");
                return;
            }
            return;
        }
        boolean z18 = false;
        if (2 == value.getUserType()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return;
        }
        com.tencent.mobileqq.guild.util.bw bwVar = com.tencent.mobileqq.guild.util.bw.f235485a;
        String str = z9().f227656e;
        if (str == null) {
            str = "";
        }
        if (bwVar.D(str)) {
            Logger logger2 = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger2.d().d("Guild.NewHome.subFrag.GuildHomeSubFragmentPart", 1, "updateGotoAuthVisibility not need show again");
                return;
            }
            return;
        }
        Integer value2 = E9().getGuildHomePermissionViewModel().d2().getValue();
        if (value2 == null) {
            Logger logger3 = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger3.d().d("Guild.NewHome.subFrag.GuildHomeSubFragmentPart", 1, "updateGotoAuthVisibility totalMemberCnt is null");
                return;
            }
            return;
        }
        int intValue = value2.intValue();
        if (intValue >= na()) {
            z17 = true;
        } else {
            z17 = false;
        }
        Logger logger4 = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger4.d().d("Guild.NewHome.subFrag.GuildHomeSubFragmentPart", 1, "updateGotoAuthVisibility totalMemberCnt:" + intValue + ", realNameAuthThreshold:" + na());
        }
        if (!z17) {
            if (QLog.isDebugVersion()) {
                logger4.d().d("Guild.NewHome.subFrag.GuildHomeSubFragmentPart", 1, "updateGotoAuthVisibility is not more than threshold");
                return;
            }
            return;
        }
        Cdo I = com.tencent.mobileqq.guild.util.ch.I();
        if (I == null) {
            if (QLog.isColorLevel()) {
                logger4.d().d("Guild.NewHome.subFrag.GuildHomeSubFragmentPart", 1, "updateGotoAuthVisibility faceAuthInfo is null");
                return;
            }
            return;
        }
        if (1 == I.a()) {
            z18 = true;
        }
        if (!z18) {
            if (QLog.isColorLevel()) {
                logger4.d().d("Guild.NewHome.subFrag.GuildHomeSubFragmentPart", 1, "updateGotoAuthVisibility is not need verify");
            }
        } else {
            if (QLog.isDebugVersion()) {
                logger4.d().d("Guild.NewHome.subFrag.GuildHomeSubFragmentPart", 1, "updateGotoAuthVisibility register listener and refresh");
            }
            c cVar = new c();
            this.realNameAuthListener = cVar;
            is1.a.d(cVar);
            is1.a.j();
        }
    }

    private final void initData() {
        String str = z9().f227656e;
        Intrinsics.checkNotNullExpressionValue(str, "facadeArgsData.guildId");
        this.currentGuildId = str;
        LiveData<List<c.GuildHomeSubTabData>> R1 = E9().getGuildSubTabPageViewModel().R1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<List<? extends c.GuildHomeSubTabData>, Unit> function1 = new Function1<List<? extends c.GuildHomeSubTabData>, Unit>() { // from class: com.tencent.mobileqq.guild.home.parts.GuildHomeSubFragmentPart$initData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends c.GuildHomeSubTabData> list) {
                invoke2((List<c.GuildHomeSubTabData>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<c.GuildHomeSubTabData> tabList) {
                List list;
                List list2;
                c.GuildHomeSubTabData guildHomeSubTabData;
                boolean z16;
                com.tencent.mobileqq.guild.home.subhome.c cVar;
                int collectionSizeOrDefault;
                boolean z17;
                List list3;
                boolean Aa;
                GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout;
                boolean z18;
                boolean z19;
                Logger logger = Logger.f235387a;
                GuildHomeSubFragmentPart guildHomeSubFragmentPart = GuildHomeSubFragmentPart.this;
                if (QLog.isDebugVersion()) {
                    Logger.a d16 = logger.d();
                    z19 = guildHomeSubFragmentPart.needLocated;
                    d16.d("Guild.NewHome.subFrag.GuildHomeSubFragmentPart", 1, "tabDataListLiveData " + z19 + " " + tabList);
                }
                list = GuildHomeSubFragmentPart.this.dataList;
                list.clear();
                list2 = GuildHomeSubFragmentPart.this.dataList;
                Intrinsics.checkNotNullExpressionValue(tabList, "tabList");
                list2.addAll(tabList);
                guildHomeSubTabData = GuildHomeSubFragmentPart.this.currentSubTab;
                if (guildHomeSubTabData != null) {
                    List<c.GuildHomeSubTabData> list4 = tabList;
                    if (!(list4 instanceof Collection) || !list4.isEmpty()) {
                        Iterator<T> it = list4.iterator();
                        while (it.hasNext()) {
                            if (((c.GuildHomeSubTabData) it.next()).getCategoryId() == guildHomeSubTabData.getCategoryId()) {
                                z18 = true;
                                break;
                            }
                        }
                    }
                    z18 = false;
                    z16 = !z18;
                } else {
                    z16 = false;
                }
                GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout2 = GuildHomeSubFragmentPart.this.contentLayout;
                if (guildHomeSubFragmentContentLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
                    guildHomeSubFragmentContentLayout2 = null;
                }
                guildHomeSubFragmentContentLayout2.setDataList(tabList);
                cVar = GuildHomeSubFragmentPart.this.tabViewPager2Adapter;
                if (cVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tabViewPager2Adapter");
                    cVar = null;
                }
                cVar.setItems(tabList);
                GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout3 = GuildHomeSubFragmentPart.this.contentLayout;
                if (guildHomeSubFragmentContentLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
                    guildHomeSubFragmentContentLayout3 = null;
                }
                GuildQUIPageTabBar j3 = guildHomeSubFragmentContentLayout3.j();
                List<c.GuildHomeSubTabData> list5 = tabList;
                GuildHomeSubFragmentPart guildHomeSubFragmentPart2 = GuildHomeSubFragmentPart.this;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list5, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                for (c.GuildHomeSubTabData guildHomeSubTabData2 : list5) {
                    String name = guildHomeSubTabData2.getName();
                    GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout4 = guildHomeSubFragmentPart2.contentLayout;
                    if (guildHomeSubFragmentContentLayout4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
                        guildHomeSubFragmentContentLayout4 = null;
                    }
                    Context context = guildHomeSubFragmentContentLayout4.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "contentLayout.context");
                    arrayList.add(new GuildQUIPageTabBar.GuildQUIPagerTabData(name, guildHomeSubTabData2.c(context)));
                }
                j3.setTabData(arrayList);
                z17 = GuildHomeSubFragmentPart.this.needLocated;
                if (!z17 || !(!r3.isEmpty())) {
                    if (z16) {
                        Logger.f235387a.d().d("Guild.NewHome.subFrag.GuildHomeSubFragmentPart", 1, "[initData] switchToDefaultSettingTab");
                        GuildHomeSubFragmentPart.this.Ka();
                        return;
                    }
                    return;
                }
                GuildHomeSubFragmentPart.this.needLocated = false;
                list3 = GuildHomeSubFragmentPart.this.dataList;
                GuildHomeSubFragmentPart guildHomeSubFragmentPart3 = GuildHomeSubFragmentPart.this;
                Iterator it5 = list3.iterator();
                int i3 = 0;
                while (true) {
                    if (!it5.hasNext()) {
                        i3 = -1;
                        break;
                    } else if (((c.GuildHomeSubTabData) it5.next()).getCategoryId() == guildHomeSubFragmentPart3.z9().f227657f) {
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i3 >= 0) {
                    GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout5 = GuildHomeSubFragmentPart.this.contentLayout;
                    if (guildHomeSubFragmentContentLayout5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
                        guildHomeSubFragmentContentLayout = null;
                    } else {
                        guildHomeSubFragmentContentLayout = guildHomeSubFragmentContentLayout5;
                    }
                    guildHomeSubFragmentContentLayout.i().setCurrentItem(i3, false);
                    return;
                }
                Aa = GuildHomeSubFragmentPart.this.Aa();
                if (!Aa) {
                    GuildHomeSubFragmentPart.this.Ka();
                } else {
                    GuildHomeSubFragmentPart.this.La();
                }
            }
        };
        R1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.home.parts.bk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeSubFragmentPart.oa(Function1.this, obj);
            }
        });
        LiveData<ef1.a<Boolean>> T = E9().T();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final GuildHomeSubFragmentPart$initData$2 guildHomeSubFragmentPart$initData$2 = new GuildHomeSubFragmentPart$initData$2(this);
        T.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.guild.home.parts.bn
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeSubFragmentPart.pa(Function1.this, obj);
            }
        });
        LiveData<Boolean> b26 = E9().getGuildHomePermissionViewModel().b2();
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final GuildHomeSubFragmentPart$initData$3 guildHomeSubFragmentPart$initData$3 = new GuildHomeSubFragmentPart$initData$3(this);
        b26.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.guild.home.parts.bo
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeSubFragmentPart.qa(Function1.this, obj);
            }
        });
        LiveData<Boolean> c26 = E9().getGuildHomePermissionViewModel().c2();
        LifecycleOwner lifecycleOwner4 = getPartHost().getLifecycleOwner();
        final GuildHomeSubFragmentPart$initData$4 guildHomeSubFragmentPart$initData$4 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.home.parts.GuildHomeSubFragmentPart$initData$4
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                Logger.f235387a.d().i("Guild.NewHome.subFrag.GuildHomeSubFragmentPart", 1, "manager permission=" + it);
                SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                simpleEventBus.dispatchEvent(new GuildFeedManagePermissionChangeEvent(it.booleanValue()));
            }
        };
        c26.observe(lifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.guild.home.parts.bp
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeSubFragmentPart.ra(Function1.this, obj);
            }
        });
        LiveData<IGProGuildInfo> e26 = E9().getGuildHomeTitleViewModel().e2();
        LifecycleOwner lifecycleOwner5 = getPartHost().getLifecycleOwner();
        final GuildHomeSubFragmentPart$initData$5 guildHomeSubFragmentPart$initData$5 = new GuildHomeSubFragmentPart$initData$5(this);
        e26.observe(lifecycleOwner5, new Observer() { // from class: com.tencent.mobileqq.guild.home.parts.bq
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeSubFragmentPart.sa(Function1.this, obj);
            }
        });
        LiveData<Integer> d26 = E9().getGuildHomePermissionViewModel().d2();
        LifecycleOwner lifecycleOwner6 = getPartHost().getLifecycleOwner();
        final GuildHomeSubFragmentPart$initData$6 guildHomeSubFragmentPart$initData$6 = new GuildHomeSubFragmentPart$initData$6(this);
        d26.observe(lifecycleOwner6, new Observer() { // from class: com.tencent.mobileqq.guild.home.parts.br
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeSubFragmentPart.ta(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> S1 = E9().getGuildNetViewModel().S1();
        LifecycleOwner lifecycleOwner7 = getPartHost().getLifecycleOwner();
        final GuildHomeSubFragmentPart$initData$7 guildHomeSubFragmentPart$initData$7 = new GuildHomeSubFragmentPart$initData$7(this);
        S1.observe(lifecycleOwner7, new Observer() { // from class: com.tencent.mobileqq.guild.home.parts.bs
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeSubFragmentPart.ua(Function1.this, obj);
            }
        });
    }

    private final void la(c.GuildHomeSubTabData currentTabData) {
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("Guild.NewHome.subFrag.GuildHomeSubFragmentPart", 1, "cacheMoreTabIfNeed currentTabData:" + currentTabData);
        }
        if (currentTabData.getType() != 6 || !GuildArgusPreloadConfigParser.INSTANCE.a().getCacheMoreTab()) {
            return;
        }
        GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout = this.contentLayout;
        GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout2 = null;
        if (guildHomeSubFragmentContentLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            guildHomeSubFragmentContentLayout = null;
        }
        if (guildHomeSubFragmentContentLayout.i().getOffscreenPageLimit() == 10) {
            return;
        }
        Fragment hostFragment = getHostFragment();
        boolean z16 = false;
        if (hostFragment != null && hostFragment.isResumed()) {
            z16 = true;
        }
        if (z16) {
            logger.d().c("Guild.NewHome.subFrag.GuildHomeSubFragmentPart", 1, "hit cacheMoreTabIfNeed");
            GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout3 = this.contentLayout;
            if (guildHomeSubFragmentContentLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            } else {
                guildHomeSubFragmentContentLayout2 = guildHomeSubFragmentContentLayout3;
            }
            guildHomeSubFragmentContentLayout2.i().setOffscreenPageLimit(10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int na() {
        return ((Number) this.realNameAuthThreshold.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ra(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ta(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ua(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void va() {
        Da();
        Companion companion = INSTANCE;
        GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout = this.contentLayout;
        GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout2 = null;
        if (guildHomeSubFragmentContentLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            guildHomeSubFragmentContentLayout = null;
        }
        Companion.b(companion, guildHomeSubFragmentContentLayout.i(), 0.0f, 1, null);
        GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout3 = this.contentLayout;
        if (guildHomeSubFragmentContentLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            guildHomeSubFragmentContentLayout3 = null;
        }
        GuildQUIPageTabBar j3 = guildHomeSubFragmentContentLayout3.j();
        GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout4 = this.contentLayout;
        if (guildHomeSubFragmentContentLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            guildHomeSubFragmentContentLayout4 = null;
        }
        j3.bindViewPager2(guildHomeSubFragmentContentLayout4.i());
        GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout5 = this.contentLayout;
        if (guildHomeSubFragmentContentLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            guildHomeSubFragmentContentLayout5 = null;
        }
        guildHomeSubFragmentContentLayout5.j().setDataSetChangeListener(new GuildQUIPageTabBar.c() { // from class: com.tencent.mobileqq.guild.home.parts.bt
            @Override // com.tencent.mobileqq.guild.component.GuildQUIPageTabBar.c
            public final void onChanged() {
                GuildHomeSubFragmentPart.wa(GuildHomeSubFragmentPart.this);
            }
        });
        GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout6 = this.contentLayout;
        if (guildHomeSubFragmentContentLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
        } else {
            guildHomeSubFragmentContentLayout2 = guildHomeSubFragmentContentLayout6;
        }
        guildHomeSubFragmentContentLayout2.j().setTabChangeListener(new QUIPageTabBar.i() { // from class: com.tencent.mobileqq.guild.home.parts.bu
            @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar.i
            public final void I0(int i3, boolean z16) {
                GuildHomeSubFragmentPart.xa(GuildHomeSubFragmentPart.this, i3, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wa(GuildHomeSubFragmentPart this$0) {
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i3 = 0;
        for (Object obj : this$0.dataList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            c.GuildHomeSubTabData guildHomeSubTabData = (c.GuildHomeSubTabData) obj;
            GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout = this$0.contentLayout;
            if (guildHomeSubFragmentContentLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
                guildHomeSubFragmentContentLayout = null;
            }
            View e16 = guildHomeSubFragmentContentLayout.j().e(i3);
            if (e16 != null) {
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("sgrp_tab_zone_name", guildHomeSubTabData.getCategoryName()));
                int i17 = guildHomeSubTabData.getExtra().getInt("EXTRA_CATEGORY_ACTIVE_NUM", -1);
                if (i17 >= 0) {
                    mutableMapOf.put("sgrp_tab_event_status", Integer.valueOf(Math.min(i17, 1)));
                }
                Unit unit = Unit.INSTANCE;
                com.tencent.mobileqq.guild.util.ch.W0(e16, "em_sgrp_tab_zone", mutableMapOf);
            }
            i3 = i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xa(GuildHomeSubFragmentPart this$0, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ca(i3, z16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean za(long categoryId) {
        boolean z16;
        IRuntimeService S0 = com.tencent.mobileqq.guild.util.ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        String str = z9().f227656e;
        Intrinsics.checkNotNullExpressionValue(str, "facadeArgsData.guildId");
        ArrayList<IGProCategoryChannelIdList> categoryChannelIdList = ((IGPSService) S0).getCategoryChannelIdList(Util.toLongOrDefault(str, 0L));
        IGProCategoryChannelIdList iGProCategoryChannelIdList = null;
        if (categoryChannelIdList != null) {
            Iterator<T> it = categoryChannelIdList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((IGProCategoryChannelIdList) next).getCategoryType() == 2) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    iGProCategoryChannelIdList = next;
                    break;
                }
            }
            iGProCategoryChannelIdList = iGProCategoryChannelIdList;
        }
        if (iGProCategoryChannelIdList != null && iGProCategoryChannelIdList.getCategoryId() == categoryId) {
            return true;
        }
        return false;
    }

    public final void Ba() {
        Logger.f235387a.d().i("Guild.NewHome.subFrag.GuildHomeSubFragmentPart", 1, "setupBehavior");
        GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout = this.contentLayout;
        if (guildHomeSubFragmentContentLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            guildHomeSubFragmentContentLayout = null;
        }
        guildHomeSubFragmentContentLayout.setupBehavior(A9());
    }

    public final void Ja(long categoryId, boolean smoothScroll) {
        boolean z16;
        Iterator<c.GuildHomeSubTabData> it = this.dataList.iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                if (it.next().getCategoryId() == categoryId) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 < 0) {
            Logger.f235387a.d().w("Guild.NewHome.subFrag.GuildHomeSubFragmentPart", 1, "switchTabChange error, categoryId not find");
            return;
        }
        GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout = this.contentLayout;
        GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout2 = null;
        if (guildHomeSubFragmentContentLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            guildHomeSubFragmentContentLayout = null;
        }
        guildHomeSubFragmentContentLayout.j().scrollToChild(i3);
        GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout3 = this.contentLayout;
        if (guildHomeSubFragmentContentLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
        } else {
            guildHomeSubFragmentContentLayout2 = guildHomeSubFragmentContentLayout3;
        }
        guildHomeSubFragmentContentLayout2.i().setCurrentItem(i3, smoothScroll);
    }

    public final void La() {
        Object obj;
        boolean z16;
        Iterator<T> it = this.dataList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (1 == ((c.GuildHomeSubTabData) obj).getType()) {
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
        c.GuildHomeSubTabData guildHomeSubTabData = (c.GuildHomeSubTabData) obj;
        if (guildHomeSubTabData == null) {
            Logger.f235387a.d().w("Guild.NewHome.subFrag.GuildHomeSubFragmentPart", 1, "[switchToMainTab] main page is null");
        } else {
            Logger.f235387a.d().d("Guild.NewHome.subFrag.GuildHomeSubFragmentPart", 1, "[switchToMainTab]");
            Ja(guildHomeSubTabData.getCategoryId(), false);
        }
    }

    public final void ja() {
        if (!Intrinsics.areEqual(this.currentGuildId, z9().f227656e)) {
            this.needLocated = true;
            String str = z9().f227656e;
            Intrinsics.checkNotNullExpressionValue(str, "facadeArgsData.guildId");
            this.currentGuildId = str;
        }
        com.tencent.mobileqq.guild.home.viewmodels.e guildSubTabPageViewModel = E9().getGuildSubTabPageViewModel();
        String str2 = z9().f227656e;
        Intrinsics.checkNotNullExpressionValue(str2, "facadeArgsData.guildId");
        guildSubTabPageViewModel.T1(str2);
    }

    @Nullable
    public final WebViewFragment ma() {
        com.tencent.mobileqq.guild.home.subhome.c cVar = this.tabViewPager2Adapter;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabViewPager2Adapter");
            cVar = null;
        }
        GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout = this.contentLayout;
        if (guildHomeSubFragmentContentLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            guildHomeSubFragmentContentLayout = null;
        }
        long itemId = cVar.getItemId(guildHomeSubFragmentContentLayout.i().getCurrentItem());
        com.tencent.mobileqq.guild.home.subhome.c cVar2 = this.tabViewPager2Adapter;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabViewPager2Adapter");
            cVar2 = null;
        }
        Fragment findFragmentByTag = cVar2.getChildFragmentManager().findFragmentByTag("f" + itemId);
        if (!(findFragmentByTag instanceof WebViewFragment)) {
            return null;
        }
        return (WebViewFragment) findFragmentByTag;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        com.tencent.mobileqq.guild.home.subhome.c cVar = this.tabViewPager2Adapter;
        com.tencent.mobileqq.guild.home.subhome.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabViewPager2Adapter");
            cVar = null;
        }
        GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout = this.contentLayout;
        if (guildHomeSubFragmentContentLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            guildHomeSubFragmentContentLayout = null;
        }
        long itemId = cVar.getItemId(guildHomeSubFragmentContentLayout.i().getCurrentItem());
        com.tencent.mobileqq.guild.home.subhome.c cVar3 = this.tabViewPager2Adapter;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabViewPager2Adapter");
        } else {
            cVar2 = cVar3;
        }
        Fragment findFragmentByTag = cVar2.getChildFragmentManager().findFragmentByTag("f" + itemId);
        if (findFragmentByTag != null) {
            findFragmentByTag.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@NotNull Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.NewHome.subFrag.GuildHomeSubFragmentPart", 1, "onConfigurationChanged orientation:" + configuration.orientation);
        }
        super.onConfigurationChanged(configuration);
        int i3 = configuration.orientation;
        if (i3 != this.currentOrientation) {
            this.currentOrientation = i3;
            GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout = this.contentLayout;
            GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout2 = null;
            if (guildHomeSubFragmentContentLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
                guildHomeSubFragmentContentLayout = null;
            }
            int currentItem = guildHomeSubFragmentContentLayout.i().getCurrentItem();
            GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout3 = this.contentLayout;
            if (guildHomeSubFragmentContentLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
                guildHomeSubFragmentContentLayout3 = null;
            }
            ViewPager2 i16 = guildHomeSubFragmentContentLayout3.i();
            int i17 = currentItem - 1;
            if (i17 <= 0) {
                i17 = 0;
            }
            i16.setCurrentItem(i17, false);
            GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout4 = this.contentLayout;
            if (guildHomeSubFragmentContentLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            } else {
                guildHomeSubFragmentContentLayout2 = guildHomeSubFragmentContentLayout4;
            }
            guildHomeSubFragmentContentLayout2.i().setCurrentItem(currentItem, false);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        IPerformanceReportTask stageCode = C9().b().duplicate("guild_id").setStageCode("stage_tab");
        this.reportTask = stageCode;
        cp1.d dVar = cp1.d.f391542a;
        if (stageCode == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reportTask");
            stageCode = null;
        }
        dVar.a(stageCode);
        View findViewById = rootView.findViewById(R.id.b9w);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.content_layout)");
        this.contentLayout = (GuildHomeSubFragmentContentLayout) findViewById;
        IPerformanceReportTask iPerformanceReportTask = this.reportTask;
        if (iPerformanceReportTask == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reportTask");
            iPerformanceReportTask = null;
        }
        GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout = this.contentLayout;
        if (guildHomeSubFragmentContentLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            guildHomeSubFragmentContentLayout = null;
        }
        qw1.b.k(iPerformanceReportTask, guildHomeSubFragmentContentLayout.j(), null, 2, null);
        va();
        initData();
    }

    @Override // com.tencent.mobileqq.guild.home.parts.a, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        FragmentManager childFragmentManager;
        super.onPartCreate(activity, savedInstanceState);
        Fragment hostFragment = getHostFragment();
        if (hostFragment != null && (childFragmentManager = hostFragment.getChildFragmentManager()) != null) {
            childFragmentManager.registerFragmentLifecycleCallbacks(this.fragmentLifecycleCallbacks, false);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        FragmentManager childFragmentManager;
        is1.f fVar = this.realNameAuthListener;
        if (fVar != null) {
            is1.a.f(fVar);
        }
        Fragment hostFragment = getHostFragment();
        if (hostFragment != null && (childFragmentManager = hostFragment.getChildFragmentManager()) != null) {
            childFragmentManager.unregisterFragmentLifecycleCallbacks(this.fragmentLifecycleCallbacks);
        }
        super.onPartDestroy(activity);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        if (this.dataList.isEmpty()) {
            return;
        }
        GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout = this.contentLayout;
        if (guildHomeSubFragmentContentLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            guildHomeSubFragmentContentLayout = null;
        }
        Ca(guildHomeSubFragmentContentLayout.j().getCurrentPosition(), false);
    }
}
