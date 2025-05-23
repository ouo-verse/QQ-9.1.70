package com.tencent.mobileqq.wink.index;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.aelight.camera.api.IQQWinkFragmentLoader;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.biz.richframework.compat.CompatPublicFragment;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.mobileqq.wink.QQWinkConfig;
import com.tencent.mobileqq.wink.QQWinkConfigKt;
import com.tencent.mobileqq.wink.QQWinkPage;
import com.tencent.mobileqq.wink.QQWinkPageSwitchEvent;
import com.tencent.mobileqq.wink.aigc.newtest.WinkMaliFragment;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.mobileqq.wink.api.IWinkProfileThemeHelp;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.context.p;
import com.tencent.mobileqq.wink.event.WinkFinishActivityEvent;
import com.tencent.mobileqq.wink.index.PageTabLayout;
import com.tencent.mobileqq.wink.index.QQWinkIndexActivity;
import com.tencent.mobileqq.wink.inspirationlibrary.WinkInspirationMainFragment;
import com.tencent.mobileqq.wink.live.WinkLiveCameraFragment;
import com.tencent.mobileqq.wink.pager.FragmentPager;
import com.tencent.mobileqq.wink.picker.Config;
import com.tencent.mobileqq.wink.picker.core.viewmodel.q;
import com.tencent.mobileqq.wink.picker.core.viewmodel.u;
import com.tencent.mobileqq.wink.picker.qcircle.QCircleMediaPickerFragment;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.mobileqq.winkpublish.report.WinkPublishReportQueue;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.utils.WinkReportUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 j2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001kB\u0007\u00a2\u0006\u0004\bh\u0010iJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\nH\u0014J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u0010\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u000eH\u0014J\b\u0010\u0017\u001a\u00020\u000eH\u0014J\u0012\u0010\u001a\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0014J\u0012\u0010\u001b\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J\"\u0010 \u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010!\u001a\u00020\u000eH\u0014J\b\u0010\"\u001a\u00020\u0012H\u0014J\b\u0010#\u001a\u00020\u000eH\u0016J\u0012\u0010%\u001a\u00020\u000e2\b\u0010$\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010)\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030'0&j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030'`(H\u0016J\b\u0010*\u001a\u00020\u000eH\u0016J\b\u0010+\u001a\u00020\u000eH\u0002J\b\u0010,\u001a\u00020\u000eH\u0002J\u0016\u00100\u001a\u00020\u000e2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020.0-H\u0002J\u001e\u00102\u001a\u00020\u000e2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020.0-2\u0006\u00101\u001a\u00020\u001cH\u0002J\b\u00103\u001a\u00020\u000eH\u0002J\u0010\u00105\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\u001cH\u0002J\n\u00107\u001a\u0004\u0018\u000106H\u0002J\b\u00108\u001a\u00020\u000eH\u0002J\b\u00109\u001a\u00020\u000eH\u0002J\b\u0010:\u001a\u00020\u000eH\u0002J\b\u0010;\u001a\u00020\u000eH\u0002R\u0014\u0010?\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010N\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u001b\u0010T\u001a\u00020O8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\u001b\u0010Y\u001a\u00020U8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bV\u0010Q\u001a\u0004\bW\u0010XR\u001b\u0010^\u001a\u00020Z8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b[\u0010Q\u001a\u0004\b\\\u0010]R\u0014\u0010b\u001a\u00020_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u001b\u0010g\u001a\u00020c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bd\u0010Q\u001a\u0004\be\u0010f\u00a8\u0006l"}, d2 = {"Lcom/tencent/mobileqq/wink/index/QQWinkIndexActivity;", "Lcom/tencent/mobileqq/activity/QPublicFragmentActivity;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/content/res/Resources;", "getResources", "", "name", "", "getSystemService", "Landroid/os/Bundle;", "outState", "Landroid/os/PersistableBundle;", "outPersistentState", "", "onSaveInstanceState", Constants.FILE_INSTANCE_STATE, "onCreate", "", "doOnCreate", "Landroid/net/Uri;", "onProvideReferrer", "doOnResume", "doOnPause", "Landroid/content/Intent;", "intent", "doOnNewIntent", "doOnSaveInstanceState", "", "requestCode", QzoneIPCModule.RESULT_CODE, "data", "doOnActivityResult", "doOnDestroy", "onBackEvent", "dispatchOnBackPressed", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "onPostThemeChanged", "initConfig", "initView", "", "Lcom/tencent/mobileqq/wink/QQWinkPage;", "indexPages", "Y2", "initPageIndex", "W2", "T2", "contentResId", "c3", "Lcom/tencent/biz/richframework/compat/CompatPublicFragment;", "N2", "setSystemUI", "initReport", "Z2", "b3", "Lcom/tencent/mobileqq/wink/context/p;", "a0", "Lcom/tencent/mobileqq/wink/context/p;", "winkCurrentContextBuilder", "Lcom/tencent/mobileqq/wink/QQWinkConfig;", "b0", "Lcom/tencent/mobileqq/wink/QQWinkConfig;", "winkConfig", "Landroidx/viewpager2/widget/ViewPager2;", "c0", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager", "Lcom/tencent/mobileqq/wink/index/PageTabLayout;", "d0", "Lcom/tencent/mobileqq/wink/index/PageTabLayout;", "tabLayout", "e0", "I", "bottomPadding", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/p;", "f0", "Lkotlin/Lazy;", "Q2", "()Lcom/tencent/mobileqq/wink/picker/core/viewmodel/p;", "pickerUIViewModel", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/u;", "g0", "R2", "()Lcom/tencent/mobileqq/wink/picker/core/viewmodel/u;", "publishInfoViewModel", "Lcom/tencent/mobileqq/wink/picker/qcircle/viewmodel/a;", "h0", "P2", "()Lcom/tencent/mobileqq/wink/picker/qcircle/viewmodel/a;", "mediaPickerTipsViewModel", "Lb93/e;", "i0", "Lb93/e;", "winkFinishHelper", "Lh93/a;", "j0", "S2", "()Lh93/a;", "winkProfileTheme", "<init>", "()V", "k0", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QQWinkIndexActivity extends QPublicFragmentActivity implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final p winkCurrentContextBuilder = new p();

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private QQWinkConfig winkConfig;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private ViewPager2 viewPager;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private PageTabLayout tabLayout;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private int bottomPadding;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy pickerUIViewModel;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy publishInfoViewModel;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mediaPickerTipsViewModel;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b93.e winkFinishHelper;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy winkProfileTheme;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/index/QQWinkIndexActivity$b", "Lcom/tencent/mobileqq/wink/index/PageTabLayout$b;", "", "index", "", "f", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements PageTabLayout.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<QQWinkPage> f322921b;

        /* JADX WARN: Multi-variable type inference failed */
        b(List<? extends QQWinkPage> list) {
            this.f322921b = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b() {
            v83.b.f441239a.i();
        }

        @Override // com.tencent.mobileqq.wink.index.PageTabLayout.b
        public void f(int index) {
            Object orNull;
            ViewPager2 viewPager2 = QQWinkIndexActivity.this.viewPager;
            PageTabLayout pageTabLayout = null;
            if (viewPager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                viewPager2 = null;
            }
            viewPager2.setCurrentItem(index, false);
            orNull = CollectionsKt___CollectionsKt.getOrNull(this.f322921b, index);
            QQWinkPage qQWinkPage = (QQWinkPage) orNull;
            if (qQWinkPage != null) {
                QQWinkIndexActivity qQWinkIndexActivity = QQWinkIndexActivity.this;
                if (qQWinkPage != QQWinkPage.MediaPicker) {
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.index.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            QQWinkIndexActivity.b.b();
                        }
                    }, 128, null, false);
                }
                j jVar = j.f322939a;
                PageTabLayout pageTabLayout2 = qQWinkIndexActivity.tabLayout;
                if (pageTabLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
                } else {
                    pageTabLayout = pageTabLayout2;
                }
                jVar.a(pageTabLayout, QQWinkPageManager.f322925a.a().get(qQWinkPage));
            }
        }
    }

    public QQWinkIndexActivity() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.wink.picker.core.viewmodel.p>() { // from class: com.tencent.mobileqq.wink.index.QQWinkIndexActivity$pickerUIViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.wink.picker.core.viewmodel.p invoke() {
                return q.a(QQWinkIndexActivity.this);
            }
        });
        this.pickerUIViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<u>() { // from class: com.tencent.mobileqq.wink.index.QQWinkIndexActivity$publishInfoViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final u invoke() {
                return q.b(QQWinkIndexActivity.this);
            }
        });
        this.publishInfoViewModel = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.wink.picker.qcircle.viewmodel.a>() { // from class: com.tencent.mobileqq.wink.index.QQWinkIndexActivity$mediaPickerTipsViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.wink.picker.qcircle.viewmodel.a invoke() {
                return com.tencent.mobileqq.wink.picker.qcircle.c.f324971a.a(QQWinkIndexActivity.this);
            }
        });
        this.mediaPickerTipsViewModel = lazy3;
        this.winkFinishHelper = new b93.e();
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<h93.a>() { // from class: com.tencent.mobileqq.wink.index.QQWinkIndexActivity$winkProfileTheme$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final h93.a invoke() {
                return ((IWinkProfileThemeHelp) QRoute.api(IWinkProfileThemeHelp.class)).getWinkProfileTheme(QQWinkIndexActivity.this, true);
            }
        });
        this.winkProfileTheme = lazy4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final CompatPublicFragment N2() {
        Long l3;
        ViewPager2 viewPager2 = this.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        RecyclerView.Adapter adapter = viewPager2.getAdapter();
        if (adapter != null) {
            ViewPager2 viewPager22 = this.viewPager;
            if (viewPager22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                viewPager22 = null;
            }
            l3 = Long.valueOf(adapter.getItemId(viewPager22.getCurrentItem()));
        } else {
            l3 = null;
        }
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag("f" + l3);
        if (!(findFragmentByTag instanceof CompatPublicFragment)) {
            return null;
        }
        return (CompatPublicFragment) findFragmentByTag;
    }

    private final com.tencent.mobileqq.wink.picker.qcircle.viewmodel.a P2() {
        return (com.tencent.mobileqq.wink.picker.qcircle.viewmodel.a) this.mediaPickerTipsViewModel.getValue();
    }

    private final com.tencent.mobileqq.wink.picker.core.viewmodel.p Q2() {
        return (com.tencent.mobileqq.wink.picker.core.viewmodel.p) this.pickerUIViewModel.getValue();
    }

    private final u R2() {
        return (u) this.publishInfoViewModel.getValue();
    }

    private final h93.a S2() {
        return (h93.a) this.winkProfileTheme.getValue();
    }

    private final void T2() {
        QQWinkConfig qQWinkConfig = this.winkConfig;
        if (qQWinkConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkConfig");
            qQWinkConfig = null;
        }
        if (qQWinkConfig.g().contains(QQWinkPage.Inspiration)) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.index.e
                @Override // java.lang.Runnable
                public final void run() {
                    QQWinkIndexActivity.U2(QQWinkIndexActivity.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U2(final QQWinkIndexActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            LiveData<Integer> O1 = this$0.P2().O1();
            final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.wink.index.QQWinkIndexActivity$initInspirationTipsBubble$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke2(num);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Integer it) {
                    QQWinkIndexActivity qQWinkIndexActivity = QQWinkIndexActivity.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    qQWinkIndexActivity.c3(it.intValue());
                }
            };
            O1.observe(this$0, new Observer() { // from class: com.tencent.mobileqq.wink.index.f
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QQWinkIndexActivity.V2(Function1.this, obj);
                }
            });
        } catch (Throwable th5) {
            w53.b.e("QQWinkIndexActivity", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void W2(List<? extends QQWinkPage> indexPages, int initPageIndex) {
        View findViewById = findViewById(R.id.f915855k);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tabLayout)");
        this.tabLayout = (PageTabLayout) findViewById;
        PageTabLayout pageTabLayout = null;
        if (indexPages.size() == 1) {
            PageTabLayout pageTabLayout2 = this.tabLayout;
            if (pageTabLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            } else {
                pageTabLayout = pageTabLayout2;
            }
            pageTabLayout.setVisibility(8);
            return;
        }
        PageTabLayout pageTabLayout3 = this.tabLayout;
        if (pageTabLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            pageTabLayout3 = null;
        }
        pageTabLayout3.setTabSelectCallback(new b(indexPages));
        PageTabLayout pageTabLayout4 = this.tabLayout;
        if (pageTabLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        } else {
            pageTabLayout = pageTabLayout4;
        }
        pageTabLayout.setPages(indexPages, initPageIndex);
    }

    private final void Y2(List<? extends QQWinkPage> indexPages) {
        View findViewById = findViewById(R.id.kvx);
        ViewPager2 viewPager2 = (ViewPager2) findViewById;
        viewPager2.setOrientation(0);
        viewPager2.setUserInputEnabled(false);
        viewPager2.setAdapter(new c(indexPages));
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<ViewPager2>\u2026}\n            }\n        }");
        this.viewPager = viewPager2;
    }

    private final void Z2() {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this, QCircleDaTongConstant.PageId.BASE);
        VideoReport.setPageParams(this, new QCircleDTParamBuilder().buildPageParams("QQWinkIndexActivity", null));
        QLog.i("QQWinkIndexActivity", 1, "reportDaTongRegister subPage: QQWinkIndexActivity");
    }

    private final void b3() {
        Intent intent = new Intent();
        w53.b.f("QQWinkIndexActivity", "[sendMobileQQPeakCreate]");
        intent.setAction("publish_entrance_dialog_close");
        intent.setPackage(BaseApplication.getContext().getPackageName());
        sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c3(int contentResId) {
        PageTabLayout pageTabLayout = this.tabLayout;
        if (pageTabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            pageTabLayout = null;
        }
        View i3 = pageTabLayout.i(QQWinkPage.Inspiration);
        if (i3 == null) {
            return;
        }
        com.tencent.mobileqq.widget.tip.a S = QUIDefaultBubbleTip.r(this).o0(getString(contentResId)).R(0).m0(3).k0(0).S(i3);
        S.s0();
        VideoReport.setElementId(S.v(), WinkDaTongReportConstant.ElementId.EM_XSJ_BUBBLE_BUTTON);
        HashMap hashMap = new HashMap();
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_BUBBLE_TRIGGER_TYPE, "2");
        VideoReport.setPageParams(S.v(), new WinkDTParamBuilder().buildPageParams(hashMap, WinkContext.INSTANCE.d().getDtParams().c()));
        P2().Q1();
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00cb, code lost:
    
        if (r1 == null) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void initConfig() {
        QQWinkConfig qQWinkConfig;
        QQWinkConfig qQWinkConfig2;
        boolean isCameraResReady;
        List mutableList;
        QQWinkPage qQWinkPage;
        Object first;
        boolean z16;
        Parcelable parcelableExtra = getIntent().getParcelableExtra("key_qq_wink_config");
        Object obj = null;
        if (parcelableExtra instanceof QQWinkConfig) {
            qQWinkConfig = (QQWinkConfig) parcelableExtra;
        } else {
            qQWinkConfig = null;
        }
        if (qQWinkConfig != null) {
            if (getIntent().getBooleanExtra(QQWinkConstants.IS_CAMERA_RES_READY, false)) {
                w53.b.f("QQWinkIndexActivity", "[launch] isCameraResReady");
                isCameraResReady = true;
            } else {
                isCameraResReady = ((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isCameraResReady();
                w53.b.f("QQWinkIndexActivity", "[launch] isCameraResReady=" + isCameraResReady);
            }
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) qQWinkConfig.g());
            if (!isCameraResReady || !QzoneConfig.isShowWinkTemplateLibrary()) {
                mutableList.remove(QQWinkPage.Inspiration);
            }
            if (!isCameraResReady) {
                mutableList.remove(QQWinkPage.TextVideo);
            }
            QQWinkPageManager qQWinkPageManager = QQWinkPageManager.f322925a;
            if (qQWinkPageManager.b(this)) {
                mutableList.remove(QQWinkPage.Live);
            }
            if (qQWinkPageManager.c()) {
                mutableList.remove(QQWinkPage.MagicStudio);
            }
            if (qQWinkPageManager.d()) {
                mutableList.remove(QQWinkPage.MemoryAlbum);
            }
            Iterator it = mutableList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((QQWinkPage) next) == qQWinkConfig.getInitPage()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    obj = next;
                    break;
                }
            }
            QQWinkPage qQWinkPage2 = (QQWinkPage) obj;
            if (qQWinkPage2 == null) {
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) mutableList);
                qQWinkPage = (QQWinkPage) first;
            } else {
                qQWinkPage = qQWinkPage2;
            }
            qQWinkConfig2 = QQWinkConfig.b(qQWinkConfig, mutableList, qQWinkPage, null, null, 12, null);
        }
        qQWinkConfig2 = new QQWinkConfig(null, null, null, null, 15, null);
        this.winkConfig = qQWinkConfig2;
        w53.b.f("QQWinkIndexActivity", "[initConfig] " + qQWinkConfig2);
    }

    private final void initReport() {
        boolean isBlank;
        boolean isBlank2;
        String stringExtra = getIntent().getStringExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID);
        String str = "";
        if (stringExtra == null) {
            stringExtra = "";
        }
        String stringExtra2 = getIntent().getStringExtra(QQWinkConstants.ENTRY_BUSINESS_NAME);
        if (stringExtra2 != null) {
            str = stringExtra2;
        }
        isBlank = StringsKt__StringsJVMKt.isBlank(stringExtra);
        if (!isBlank) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank2) {
                WinkPublishReportQueue.INSTANCE.report(new WinkPublishQualityReportData.Builder().eventId(QCirclePublishQualityReporter.E_WINK_INDEX_ENTRY).traceId(stringExtra).ext1(String.valueOf(getIntent().getIntExtra(IProfileCardConst.KEY_FROM_TYPE, -1))).ext2("true").ext6(WinkReportUtils.isInMultiWindowMode(this)).retCode("0").getReportData(), str);
            }
        }
        WinkDTParamBuilder.setDtParams(getIntent());
        com.tencent.mobileqq.wink.utils.h.c(getIntent());
        Z2();
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x008a, code lost:
    
        if (r0 == (-1)) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void initView() {
        QQWinkConfig qQWinkConfig;
        this.bottomPadding = getResources().getDimensionPixelSize(R.dimen.de6);
        List<QQWinkPage> a16 = QQWinkConfigKt.a();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = a16.iterator();
        while (true) {
            qQWinkConfig = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            QQWinkPage qQWinkPage = (QQWinkPage) next;
            QQWinkConfig qQWinkConfig2 = this.winkConfig;
            if (qQWinkConfig2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkConfig");
            } else {
                qQWinkConfig = qQWinkConfig2;
            }
            if (qQWinkConfig.g().contains(qQWinkPage)) {
                arrayList.add(next);
            }
        }
        int i3 = 0;
        if (arrayList.size() == 1) {
            Q2().U1(false);
        }
        QQWinkConfig qQWinkConfig3 = this.winkConfig;
        if (qQWinkConfig3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkConfig");
            qQWinkConfig3 = null;
        }
        int indexOf = arrayList.indexOf(qQWinkConfig3.getInitPage());
        if (indexOf == -1) {
            List<QQWinkPage> b16 = QQWinkConfigKt.b();
            QQWinkConfig qQWinkConfig4 = this.winkConfig;
            if (qQWinkConfig4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkConfig");
            } else {
                qQWinkConfig = qQWinkConfig4;
            }
            if (b16.indexOf(qQWinkConfig.getInitPage()) != -1) {
                indexOf = arrayList.indexOf(QQWinkPage.Inspiration);
            } else {
                indexOf = arrayList.indexOf(QQWinkPage.MediaPicker);
            }
        }
        i3 = indexOf;
        Y2(arrayList);
        W2(arrayList, i3);
    }

    private final void setSystemUI() {
        super.getWindow().addFlags(128);
        this.mNeedStatusTrans = true;
        this.mActNeedImmersive = false;
        SystemBarActivityModule.setImmersiveStatus(this);
        LiuHaiUtils.initLiuHaiProperty(this);
        LiuHaiUtils.enableNotch(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public void dispatchOnBackPressed() {
        super.dispatchOnBackPressed();
        overridePendingTransition(0, R.anim.f155066i1);
    }

    @Override // com.tencent.mobileqq.activity.QPublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QPublicFragmentActivity, mqq.app.AppActivity
    public void doOnActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        CompatPublicFragment N2 = N2();
        if (N2 != null) {
            N2.onActivityResult(requestCode, resultCode, data);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QPublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(@Nullable Bundle savedInstanceState) {
        setSystemUI();
        setContentView(R.layout.h7n);
        initConfig();
        initView();
        T2();
        com.tencent.mobileqq.wink.picker.report.b bVar = com.tencent.mobileqq.wink.picker.report.b.f325261a;
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        bVar.e(intent);
        LiveData<Boolean> P1 = Q2().P1();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.index.QQWinkIndexActivity$doOnCreate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                PageTabLayout pageTabLayout = QQWinkIndexActivity.this.tabLayout;
                if (pageTabLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
                    pageTabLayout = null;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                pageTabLayout.setVisibility(it.booleanValue() ? 0 : 4);
            }
        };
        P1.observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.index.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQWinkIndexActivity.M2(Function1.this, obj);
            }
        });
        R2().M1();
        SimpleEventBus.getInstance().registerReceiver(this);
        initReport();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        try {
            ViewPager2 viewPager2 = this.viewPager;
            if (viewPager2 != null) {
                if (viewPager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewPager");
                    viewPager2 = null;
                }
                viewPager2.setAdapter(null);
            }
        } catch (Exception unused) {
        }
        v83.b.f441239a.b();
        com.tencent.videocut.render.utils.b.f384205a.a();
        AlbumThumbManager.getInstance(this).clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QPublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(@Nullable Intent intent) {
        super.doOnNewIntent(intent);
        CompatPublicFragment N2 = N2();
        if (N2 != null) {
            N2.onNewIntent(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        super.doOnPause();
        this.winkFinishHelper.b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        this.winkCurrentContextBuilder.a(null, getIntent());
        this.winkFinishHelper.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnSaveInstanceState(@Nullable Bundle outState) {
        super.doOnSaveInstanceState(outState);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QQWinkPageSwitchEvent.class, WinkFinishActivityEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    @NotNull
    public Resources getResources() {
        h93.a S2 = S2();
        Resources resources = super.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "super.getResources()");
        return S2.b(resources);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    @Nullable
    public Object getSystemService(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (Intrinsics.areEqual("layout_inflater", name)) {
            Object systemService = super.getSystemService(name);
            if (systemService instanceof LayoutInflater) {
                return S2().a((LayoutInflater) systemService);
            }
        }
        return super.getSystemService(name);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QPublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        CompatPublicFragment N2 = N2();
        boolean z16 = false;
        if (N2 != null && N2.onBackEvent()) {
            z16 = true;
        }
        if (z16) {
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.activity.QPublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).initialize();
        this.winkCurrentContextBuilder.a(savedInstanceState, getIntent());
        b3();
        super.onCreate(savedInstanceState);
    }

    @Override // com.tencent.mobileqq.activity.QPublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, com.tencent.mobileqq.app.ISkinCallback, com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPostThemeChanged() {
        View decorView;
        super.onPostThemeChanged();
        w53.b.f("QQWinkIndexActivity", "[onPostThemeChanged]");
        Window window = getWindow();
        if (window != null && (decorView = window.getDecorView()) != null) {
            decorView.invalidate();
        }
    }

    @Override // android.app.Activity
    @NotNull
    public Uri onProvideReferrer() {
        return WinkContext.INSTANCE.k();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof QQWinkPageSwitchEvent) {
            PageTabLayout pageTabLayout = this.tabLayout;
            if (pageTabLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
                pageTabLayout = null;
            }
            pageTabLayout.p(((QQWinkPageSwitchEvent) event).getTargetPage());
            return;
        }
        if ((event instanceof WinkFinishActivityEvent) && !isFinishing()) {
            this.winkFinishHelper.a(this, (WinkFinishActivityEvent) event);
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle outState, @NotNull PersistableBundle outPersistentState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        Intrinsics.checkNotNullParameter(outPersistentState, "outPersistentState");
        super.onSaveInstanceState(outState, outPersistentState);
        this.winkCurrentContextBuilder.c(outState);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/index/QQWinkIndexActivity$c", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "", "getItemCount", "position", "Landroidx/fragment/app/Fragment;", "createFragment", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c extends FragmentStateAdapter {
        final /* synthetic */ List<QQWinkPage> C;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes21.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f322923a;

            static {
                int[] iArr = new int[QQWinkPage.values().length];
                try {
                    iArr[QQWinkPage.Capture.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[QQWinkPage.MediaPicker.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[QQWinkPage.Inspiration.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[QQWinkPage.Live.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[QQWinkPage.AIGC_TEST.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                f322923a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(List<? extends QQWinkPage> list) {
            super(QQWinkIndexActivity.this);
            this.C = list;
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        @NotNull
        public Fragment createFragment(int position) {
            Fragment captureFragment;
            int i3 = a.f322923a[this.C.get(position).ordinal()];
            if (i3 != 1) {
                QQWinkConfig qQWinkConfig = null;
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                captureFragment = new QCircleMediaPickerFragment();
                            } else {
                                captureFragment = new WinkMaliFragment();
                            }
                        } else {
                            captureFragment = new WinkLiveCameraFragment();
                        }
                    } else {
                        WinkInspirationMainFragment.Companion companion = WinkInspirationMainFragment.INSTANCE;
                        QQWinkConfig qQWinkConfig2 = QQWinkIndexActivity.this.winkConfig;
                        if (qQWinkConfig2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("winkConfig");
                        } else {
                            qQWinkConfig = qQWinkConfig2;
                        }
                        captureFragment = companion.a(qQWinkConfig);
                    }
                } else {
                    QCircleMediaPickerFragment.Companion companion2 = QCircleMediaPickerFragment.INSTANCE;
                    QQWinkConfig qQWinkConfig3 = QQWinkIndexActivity.this.winkConfig;
                    if (qQWinkConfig3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("winkConfig");
                        qQWinkConfig3 = null;
                    }
                    Config mediaPickerConfig = qQWinkConfig3.getMediaPickerConfig();
                    QQWinkConfig qQWinkConfig4 = QQWinkIndexActivity.this.winkConfig;
                    if (qQWinkConfig4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("winkConfig");
                    } else {
                        qQWinkConfig = qQWinkConfig4;
                    }
                    captureFragment = companion2.a(mediaPickerConfig, qQWinkConfig.getMediaPickerInitBean());
                }
            } else {
                captureFragment = ((IQQWinkFragmentLoader) QRoute.api(IQQWinkFragmentLoader.class)).getCaptureFragment();
            }
            if (captureFragment instanceof FragmentPager.d) {
                ((FragmentPager.d) captureFragment).P6(new b(QQWinkIndexActivity.this));
            }
            return captureFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            return this.C.size();
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/index/QQWinkIndexActivity$c$b", "Lcom/tencent/mobileqq/wink/pager/FragmentPager$b;", "", "c", "", "pageId", "b", "", NodeProps.VISIBLE, "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes21.dex */
        public static final class b implements FragmentPager.b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ QQWinkIndexActivity f322924a;

            b(QQWinkIndexActivity qQWinkIndexActivity) {
                this.f322924a = qQWinkIndexActivity;
            }

            @Override // com.tencent.mobileqq.wink.pager.FragmentPager.b
            public void a(boolean visible) {
                int i3;
                PageTabLayout pageTabLayout = this.f322924a.tabLayout;
                PageTabLayout pageTabLayout2 = null;
                if (pageTabLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
                    pageTabLayout = null;
                }
                if (pageTabLayout.getVisibility() != 8) {
                    PageTabLayout pageTabLayout3 = this.f322924a.tabLayout;
                    if (pageTabLayout3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
                    } else {
                        pageTabLayout2 = pageTabLayout3;
                    }
                    if (visible) {
                        i3 = 0;
                    } else {
                        i3 = 4;
                    }
                    pageTabLayout2.setVisibility(i3);
                }
            }

            @Override // com.tencent.mobileqq.wink.pager.FragmentPager.b
            public void b(@NotNull String pageId) {
                Intrinsics.checkNotNullParameter(pageId, "pageId");
            }

            @Override // com.tencent.mobileqq.wink.pager.FragmentPager.b
            public void c() {
            }
        }
    }
}
