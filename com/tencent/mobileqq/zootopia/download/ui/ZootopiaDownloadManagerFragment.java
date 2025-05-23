package com.tencent.mobileqq.zootopia.download.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCaller;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.viewpager.widget.ViewPager;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager;
import com.tencent.mobileqq.zootopia.download.ui.ZootopiaDownloadManagerFragment;
import com.tencent.mobileqq.zootopia.download.ui.downloaded.ZootopiaDownloadedFragment;
import com.tencent.mobileqq.zootopia.download.ui.downloading.ZootopiaDownloadingFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.sqshow.fragment.ZootopiaBaseFragment;
import com.tencent.sqshow.zootopia.ZootopiaActivity;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.state.report.SquareReportConst;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.os.MqqHandler;
import pb3.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u0001<\u0018\u0000 K2\u00020\u0001:\u0001LB\u0007\u00a2\u0006\u0004\bI\u0010JJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J&\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0018H\u0002J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0002J\b\u0010\u001d\u001a\u00020\u0004H\u0002J\b\u0010\u001e\u001a\u00020\u0004H\u0002J\b\u0010\u001f\u001a\u00020\u0004H\u0002J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H\u0002J\b\u0010#\u001a\u00020\u0004H\u0002J\b\u0010$\u001a\u00020\u0004H\u0002J\b\u0010%\u001a\u00020\u0004H\u0002R\u0016\u0010(\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001b\u0010.\u001a\u00020)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001b\u00103\u001a\u00020/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u0010+\u001a\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010?\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u001b\u0010D\u001a\u00020@8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bA\u0010+\u001a\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010G\u00a8\u0006M"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/ui/ZootopiaDownloadManagerFragment;", "Lcom/tencent/sqshow/fragment/ZootopiaBaseFragment;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onActivityCreated", "onStart", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "", "getSubSource", "onResume", "onDestroyView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "onBackPressedEvent", "Landroid/widget/TextView;", "onSelected", "onUnSelected", "init", "initViewPager", "toDownloadingPage", "toDownloadedPage", "initDownloadingCount", "", "count", "setDownloadingCount", "toPage", "ci", "setGestureLayout", "N", "Z", "isSetGestureLayout", "Lcom/tencent/mobileqq/zootopia/download/ui/downloading/ZootopiaDownloadingFragment;", "P", "Lkotlin/Lazy;", "Vh", "()Lcom/tencent/mobileqq/zootopia/download/ui/downloading/ZootopiaDownloadingFragment;", "downloadingFragment", "Lcom/tencent/mobileqq/zootopia/download/ui/downloaded/ZootopiaDownloadedFragment;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Uh", "()Lcom/tencent/mobileqq/zootopia/download/ui/downloaded/ZootopiaDownloadedFragment;", "downloadedFragment", "Lcom/tencent/mobileqq/zootopia/download/ui/n;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/zootopia/download/ui/n;", "pagerAdapter", "Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;", "topGestureLayout", "com/tencent/mobileqq/zootopia/download/ui/ZootopiaDownloadManagerFragment$c", "T", "Lcom/tencent/mobileqq/zootopia/download/ui/ZootopiaDownloadManagerFragment$c;", "managerListener", "Lcom/tencent/mobileqq/zootopia/download/ui/ZootopiaDownloadViewModel;", "U", "Wh", "()Lcom/tencent/mobileqq/zootopia/download/ui/ZootopiaDownloadViewModel;", "viewModel", "Lfi3/p;", "V", "Lfi3/p;", "binding", "<init>", "()V", "W", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaDownloadManagerFragment extends ZootopiaBaseFragment {

    /* renamed from: W, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static boolean X;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean isSetGestureLayout;

    /* renamed from: P, reason: from kotlin metadata */
    private final Lazy downloadingFragment;

    /* renamed from: Q, reason: from kotlin metadata */
    private final Lazy downloadedFragment;

    /* renamed from: R, reason: from kotlin metadata */
    private n pagerAdapter;

    /* renamed from: S, reason: from kotlin metadata */
    private TopGestureLayout topGestureLayout;

    /* renamed from: T, reason: from kotlin metadata */
    private final c managerListener;

    /* renamed from: U, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: V, reason: from kotlin metadata */
    private fi3.p binding;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ5\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/ui/ZootopiaDownloadManagerFragment$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "", "defaultTab", "", "cleanCacheMapId", "", "b", "(Landroid/content/Context;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;Ljava/lang/Integer;Ljava/lang/String;)V", "", "isShowing", "Z", "a", "()Z", "setShowing", "(Z)V", "DOWNLOADED_POSITION", "I", "DOWNLOADING_POSITION", "DOWNLOAD_TAB_KEY", "Ljava/lang/String;", "EXTRA_CLEAN_CACHE_MAP", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.download.ui.ZootopiaDownloadManagerFragment$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return ZootopiaDownloadManagerFragment.X;
        }

        public final void b(Context context, ZootopiaSource source, Integer defaultTab, String cleanCacheMapId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(source, "source");
            ZootopiaActivity.Companion companion = ZootopiaActivity.INSTANCE;
            Bundle bundle = new Bundle();
            if (defaultTab != null) {
                bundle.putInt("tab", defaultTab.intValue());
            }
            if (cleanCacheMapId != null) {
                bundle.putString("clean_cache_map_id", cleanCacheMapId);
            }
            Unit unit = Unit.INSTANCE;
            ZootopiaActivity.Companion.c(companion, context, ZootopiaDownloadManagerFragment.class, source, bundle, false, 16, null);
        }

        Companion() {
        }

        public static /* synthetic */ void c(Companion companion, Context context, ZootopiaSource zootopiaSource, Integer num, String str, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                num = null;
            }
            if ((i3 & 8) != 0) {
                str = null;
            }
            companion.b(context, zootopiaSource, num, str);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zootopia/download/ui/ZootopiaDownloadManagerFragment$c", "Lpb3/a;", "", "curCount", "", "onDownloadCountChanged", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements pb3.a {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(ZootopiaDownloadManagerFragment this$0, int i3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.setDownloadingCount(i3);
        }

        @Override // pb3.a
        public void onDownloadCountChanged(final int curCount) {
            MqqHandler uIHandler = ThreadManager.getUIHandler();
            final ZootopiaDownloadManagerFragment zootopiaDownloadManagerFragment = ZootopiaDownloadManagerFragment.this;
            uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.download.ui.l
                @Override // java.lang.Runnable
                public final void run() {
                    ZootopiaDownloadManagerFragment.c.b(ZootopiaDownloadManagerFragment.this, curCount);
                }
            });
        }

        @Override // pb3.a
        public void onDownloadingCountChanged(int i3) {
            a.C10996a.b(this, i3);
        }

        @Override // pb3.a
        public void onTaskDelete(String str) {
            a.C10996a.c(this, str);
        }
    }

    public ZootopiaDownloadManagerFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZootopiaDownloadingFragment>() { // from class: com.tencent.mobileqq.zootopia.download.ui.ZootopiaDownloadManagerFragment$downloadingFragment$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZootopiaDownloadingFragment invoke() {
                ZootopiaSource Ch;
                ZootopiaDownloadingFragment zootopiaDownloadingFragment = new ZootopiaDownloadingFragment();
                Ch = ZootopiaDownloadManagerFragment.this.Ch();
                zootopiaDownloadingFragment.sh(Ch);
                return zootopiaDownloadingFragment;
            }
        });
        this.downloadingFragment = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ZootopiaDownloadedFragment>() { // from class: com.tencent.mobileqq.zootopia.download.ui.ZootopiaDownloadManagerFragment$downloadedFragment$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZootopiaDownloadedFragment invoke() {
                ZootopiaSource Ch;
                ZootopiaDownloadedFragment zootopiaDownloadedFragment = new ZootopiaDownloadedFragment();
                Ch = ZootopiaDownloadManagerFragment.this.Ch();
                zootopiaDownloadedFragment.wh(Ch);
                return zootopiaDownloadedFragment;
            }
        });
        this.downloadedFragment = lazy2;
        this.managerListener = new c();
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<ZootopiaDownloadViewModel>() { // from class: com.tencent.mobileqq.zootopia.download.ui.ZootopiaDownloadManagerFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZootopiaDownloadViewModel invoke() {
                ViewModel viewModel = com.tencent.mobileqq.mvvm.h.a(ZootopiaDownloadManagerFragment.this.getQBaseActivity()).get(ZootopiaDownloadViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ofViewModelProvider(qBas\u2026oadViewModel::class.java)");
                return (ZootopiaDownloadViewModel) viewModel;
            }
        });
        this.viewModel = lazy3;
    }

    private final ZootopiaDownloadedFragment Uh() {
        return (ZootopiaDownloadedFragment) this.downloadedFragment.getValue();
    }

    private final ZootopiaDownloadingFragment Vh() {
        return (ZootopiaDownloadingFragment) this.downloadingFragment.getValue();
    }

    private final ZootopiaDownloadViewModel Wh() {
        return (ZootopiaDownloadViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xh(ZootopiaDownloadManagerFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yh(ZootopiaDownloadManagerFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.toDownloadingPage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zh(ZootopiaDownloadManagerFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.toDownloadedPage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ai(ZootopiaDownloadManagerFragment this$0, String mapId) {
        n nVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mapId, "$mapId");
        n nVar2 = this$0.pagerAdapter;
        ActivityResultCaller item = (1 >= (nVar2 != null ? nVar2.getF373114d() : 0) || (nVar = this$0.pagerAdapter) == null) ? null : nVar.getItem(1);
        ZootopiaDownloadedFragment zootopiaDownloadedFragment = item instanceof ZootopiaDownloadedFragment ? (ZootopiaDownloadedFragment) item : null;
        if (zootopiaDownloadedFragment != null) {
            zootopiaDownloadedFragment.qh(mapId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bi(ZootopiaDownloadManagerFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setGestureLayout();
    }

    private final void ci() {
        ZootopiaDownloadManager.f327992a.W(new ZootopiaDownloadManagerFragment$queryDataToPage$1(this));
    }

    private final void init() {
        fi3.p pVar = this.binding;
        if (pVar == null) {
            return;
        }
        pVar.f399316b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.download.ui.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZootopiaDownloadManagerFragment.Xh(ZootopiaDownloadManagerFragment.this, view);
            }
        });
        pVar.f399319e.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.download.ui.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZootopiaDownloadManagerFragment.Yh(ZootopiaDownloadManagerFragment.this, view);
            }
        });
        pVar.f399318d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.download.ui.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZootopiaDownloadManagerFragment.Zh(ZootopiaDownloadManagerFragment.this, view);
            }
        });
        initViewPager();
        toPage();
        initDownloadingCount();
        Wh().queryDownloadData();
    }

    private final void initDownloadingCount() {
        ZootopiaDownloadManager zootopiaDownloadManager = ZootopiaDownloadManager.f327992a;
        setDownloadingCount(zootopiaDownloadManager.X());
        zootopiaDownloadManager.H(this.managerListener);
    }

    private final void initViewPager() {
        ViewPager viewPager;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        n nVar = new n(childFragmentManager);
        this.pagerAdapter = nVar;
        nVar.addFragment(Vh());
        n nVar2 = this.pagerAdapter;
        if (nVar2 != null) {
            nVar2.addFragment(Uh());
        }
        fi3.p pVar = this.binding;
        if (pVar == null || (viewPager = pVar.f399317c) == null) {
            return;
        }
        viewPager.addOnPageChangeListener(new b());
        viewPager.setAdapter(this.pagerAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSelected(TextView view) {
        view.setTextColor(getResources().getColor(R.color.f8216c));
        view.setBackgroundResource(R.drawable.gzf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onUnSelected(TextView view) {
        view.setTextColor(getResources().getColor(R.color.f8226d));
        view.setBackgroundResource(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDownloadingCount(int count) {
        fi3.p pVar = this.binding;
        if (pVar == null) {
            return;
        }
        if (count == 0) {
            pVar.f399320f.setVisibility(4);
        } else {
            pVar.f399320f.setVisibility(0);
            pVar.f399320f.setText(String.valueOf(count));
        }
    }

    private final void setGestureLayout() {
        TopGestureLayout topGestureLayout;
        ViewPager viewPager;
        Window window;
        if (this.isSetGestureLayout) {
            return;
        }
        this.isSetGestureLayout = true;
        FragmentActivity activity = getActivity();
        View decorView = (activity == null || (window = activity.getWindow()) == null) ? null : window.getDecorView();
        ViewGroup viewGroup = decorView instanceof ViewGroup ? (ViewGroup) decorView : null;
        if (viewGroup == null) {
            return;
        }
        View childAt = viewGroup.getChildAt(0);
        TopGestureLayout topGestureLayout2 = childAt instanceof TopGestureLayout ? (TopGestureLayout) childAt : null;
        if (topGestureLayout2 == null) {
            return;
        }
        this.topGestureLayout = topGestureLayout2;
        fi3.p pVar = this.binding;
        if (!((pVar == null || (viewPager = pVar.f399317c) == null || viewPager.getCurrentItem() != 1) ? false : true) || (topGestureLayout = this.topGestureLayout) == null) {
            return;
        }
        topGestureLayout.setInterceptTouchFlag(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toDownloadedPage() {
        fi3.p pVar = this.binding;
        ViewPager viewPager = pVar != null ? pVar.f399317c : null;
        if (viewPager == null) {
            return;
        }
        viewPager.setCurrentItem(1);
    }

    private final void toDownloadingPage() {
        fi3.p pVar = this.binding;
        ViewPager viewPager = pVar != null ? pVar.f399317c : null;
        if (viewPager == null) {
            return;
        }
        viewPager.setCurrentItem(0);
    }

    private final void toPage() {
        Intent intent;
        FragmentActivity activity = getActivity();
        Integer valueOf = (activity == null || (intent = activity.getIntent()) == null) ? null : Integer.valueOf(intent.getIntExtra("tab", -1));
        if (valueOf != null && valueOf.intValue() == 0) {
            fi3.p pVar = this.binding;
            if (pVar != null) {
                TextView textView = pVar.f399319e;
                Intrinsics.checkNotNullExpressionValue(textView, "it.downloading");
                onSelected(textView);
                TextView textView2 = pVar.f399318d;
                Intrinsics.checkNotNullExpressionValue(textView2, "it.downloaded");
                onUnSelected(textView2);
                return;
            }
            return;
        }
        if (valueOf != null && valueOf.intValue() == 1) {
            toDownloadedPage();
        } else {
            ci();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment
    public String getSubSource() {
        return ZootopiaSource.SUB_SOURCE_DOWNLOAD;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        Intent intent;
        final String stringExtra;
        fi3.p pVar;
        ViewPager viewPager;
        super.onActivityCreated(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (stringExtra = intent.getStringExtra("clean_cache_map_id")) == null || TextUtils.isEmpty(stringExtra) || (pVar = this.binding) == null || (viewPager = pVar.f399317c) == null) {
            return;
        }
        viewPager.post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.download.ui.k
            @Override // java.lang.Runnable
            public final void run() {
                ZootopiaDownloadManagerFragment.ai(ZootopiaDownloadManagerFragment.this, stringExtra);
            }
        });
    }

    @Override // com.tencent.mobileqq.zootopia.api.b
    public boolean onBackPressedEvent() {
        return false;
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.tencent.mobileqq.zootopia.helper.d.f328319a.i(3);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        fi3.p g16 = fi3.p.g(inflater, container, false);
        id3.d dVar = new id3.d(null, 1, null);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        RelativeLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "root");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ah.b(Ch())));
        dVar.j(requireActivity, root, "pg_zplan_playground_download", mutableMapOf);
        TextView textView = g16.f399319e;
        Intrinsics.checkNotNullExpressionValue(textView, "this.downloading");
        id3.d.h(dVar, textView, "em_zplan_playground_download_downloading_tab", new LinkedHashMap(), false, false, null, 56, null);
        TextView textView2 = g16.f399318d;
        Intrinsics.checkNotNullExpressionValue(textView2, "this.downloaded");
        id3.d.h(dVar, textView2, "em_zplan_playground_download_complete_tab", new LinkedHashMap(), false, false, null, 56, null);
        this.binding = g16;
        return g16.getRoot();
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ZootopiaDownloadManager.f327992a.E0(this.managerListener);
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        QLog.i("ZootopiaBaseFragment", 1, this + " onPause");
        X = false;
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QLog.i("ZootopiaBaseFragment", 1, this + " onResume");
        X = true;
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.download.ui.j
            @Override // java.lang.Runnable
            public final void run() {
                ZootopiaDownloadManagerFragment.bi(ZootopiaDownloadManagerFragment.this);
            }
        });
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (!cu.g() && !cu.f()) {
            requireActivity().getWindow().getDecorView().setSystemUiVisibility(9216);
        } else {
            ImmersiveUtils.setStatusBarDarkMode(requireActivity().getWindow(), true);
        }
        init();
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.binding = null;
        super.onDestroy();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zootopia/download/ui/ZootopiaDownloadManagerFragment$b", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "", "p0", "", "p1", "p2", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "position", "onPageSelected", "onPageScrollStateChanged", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements ViewPager.OnPageChangeListener {
        b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            fi3.p pVar = ZootopiaDownloadManagerFragment.this.binding;
            if (pVar != null) {
                ZootopiaDownloadManagerFragment zootopiaDownloadManagerFragment = ZootopiaDownloadManagerFragment.this;
                if (position != 0) {
                    TopGestureLayout topGestureLayout = zootopiaDownloadManagerFragment.topGestureLayout;
                    if (topGestureLayout != null) {
                        topGestureLayout.setInterceptTouchFlag(false);
                    }
                    TextView textView = pVar.f399318d;
                    Intrinsics.checkNotNullExpressionValue(textView, "it.downloaded");
                    zootopiaDownloadManagerFragment.onSelected(textView);
                    TextView textView2 = pVar.f399319e;
                    Intrinsics.checkNotNullExpressionValue(textView2, "it.downloading");
                    zootopiaDownloadManagerFragment.onUnSelected(textView2);
                    return;
                }
                TextView textView3 = pVar.f399319e;
                Intrinsics.checkNotNullExpressionValue(textView3, "it.downloading");
                zootopiaDownloadManagerFragment.onSelected(textView3);
                TextView textView4 = pVar.f399318d;
                Intrinsics.checkNotNullExpressionValue(textView4, "it.downloaded");
                zootopiaDownloadManagerFragment.onUnSelected(textView4);
                TopGestureLayout topGestureLayout2 = zootopiaDownloadManagerFragment.topGestureLayout;
                if (topGestureLayout2 != null) {
                    topGestureLayout2.setInterceptTouchFlag(true);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int p06) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int p06, float p16, int p26) {
        }
    }
}
