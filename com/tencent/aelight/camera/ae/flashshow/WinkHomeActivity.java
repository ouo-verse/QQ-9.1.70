package com.tencent.aelight.camera.ae.flashshow;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.aelight.camera.ae.flashshow.enhance.EnhanceHelper;
import com.tencent.aelight.camera.ae.flashshow.view.TabLayout;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicHelper;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.richframework.compat.RFWThemeUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.IQQWinkLaunchReporter;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.event.WinkFinishActivityEvent;
import com.tencent.mobileqq.wink.pager.FragmentPager;
import com.tencent.mobileqq.wink.picker.Config;
import com.tencent.mobileqq.wink.picker.QCircleInitBean;
import com.tencent.mobileqq.wink.picker.QZoneInitBean;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.mobileqq.wink.picker.flock.FlockMediaPickerFragment;
import com.tencent.mobileqq.wink.picker.qcircle.QCircleMediaPickerFragment;
import com.tencent.mobileqq.wink.picker.qzone.QZoneMediaPickerFragment;
import com.tencent.mobileqq.wink.qzone.templatelibrary.fragment.WinkQZoneTemplateLibMainFragment;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.mobileqq.winkpublish.report.WinkPublishReportQueue;
import com.tencent.mobileqq.winkreport.crashreport.WinkCrashReportParams;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.utils.WinkReportUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.peak.PeakConstants;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.QzoneIPCModule;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u0082\u00012\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002\u0083\u0001B\t\u00a2\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J4\u0010\u0014\u001a\u0004\u0018\u00010\u0013\"\f\b\u0000\u0010\r*\u00020\u000b*\u00020\f2\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J&\u0010\u0019\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\u001d\u0010\u001c\u001a\u00028\u0000\"\f\b\u0000\u0010\r*\u00020\u000b*\u00020\fH\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010 \u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002J*\u0010\"\u001a\u00020\u0004\"\f\b\u0000\u0010\r*\u00020\u000b*\u00020\f2\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0!H\u0002J\b\u0010$\u001a\u00020#H\u0002J\u0010\u0010&\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0015H\u0002J4\u0010'\u001a\u00020\u0011\"\f\b\u0000\u0010\r*\u00020\u000b*\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u000eH\u0002J\u0012\u0010)\u001a\u00020\u00152\b\u0010(\u001a\u0004\u0018\u00010\u0015H\u0002J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0015H\u0002J\u0010\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020+H\u0002J\u0010\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020#H\u0002J\b\u00100\u001a\u00020\u0004H\u0002J\u0010\u00102\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u0011H\u0002J\b\u00103\u001a\u00020\u0004H\u0002J\u0010\u00105\u001a\u00020\u00042\u0006\u00104\u001a\u00020#H\u0002J\u0012\u00107\u001a\u00020\u00152\b\b\u0001\u00106\u001a\u00020\u0011H\u0002J\b\u00108\u001a\u00020\u0004H\u0002J\b\u00109\u001a\u00020\u0004H\u0014J\u0018\u0010=\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\b2\u0006\u0010<\u001a\u00020;H\u0016J\u0012\u0010>\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010@\u001a\u00020?H\u0016J\u0012\u0010A\u001a\u00020#2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\u0012\u0010D\u001a\u00020\u00042\b\u0010C\u001a\u0004\u0018\u00010BH\u0016J\u0012\u0010F\u001a\u00020\u00042\b\u0010E\u001a\u0004\u0018\u00010+H\u0014J\b\u0010G\u001a\u00020\u0004H\u0014J\b\u0010H\u001a\u00020\u0004H\u0014J\u0010\u0010I\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\bH\u0014J\"\u0010M\u001a\u00020\u00042\u0006\u0010J\u001a\u00020\u00112\u0006\u0010K\u001a\u00020\u00112\b\u0010L\u001a\u0004\u0018\u00010+H\u0014J\b\u0010N\u001a\u00020#H\u0014J\b\u0010O\u001a\u00020\u0004H\u0016J\b\u0010P\u001a\u00020\u0004H\u0014J\u0012\u0010R\u001a\u00020\u00042\b\u0010Q\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010V\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030T0Sj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030T`UH\u0016R\u0014\u0010Z\u001a\u00020W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010^\u001a\u00020[8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\\\u0010]R6\u0010c\u001a\"\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010_j\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u0001``8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010f\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u001c\u0010j\u001a\b\u0012\u0002\b\u0003\u0018\u00010g8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010n\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u0018\u0010q\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010pR\u0018\u0010u\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010tR\u0018\u0010y\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010xR\u001a\u0010|\u001a\b\u0012\u0004\u0012\u00020\u00150!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bz\u0010{R\u0016\u0010\u007f\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b}\u0010~\u00a8\u0006\u0084\u0001"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/WinkHomeActivity;", "Lcom/tencent/mobileqq/activity/QPublicFragmentActivity;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", ICustomDataEditor.STRING_PARAM_3, "setSystemUI", "initReport", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "g3", "Landroidx/fragment/app/Fragment;", "Lcom/tencent/mobileqq/wink/pager/FragmentPager$d;", "T", "", "Lcom/tencent/mobileqq/wink/pager/b;", "pages", "", "initialPagePos", "Lcom/tencent/aelight/camera/ae/flashshow/view/TabLayout;", "h3", "", "switchType", "lastSelectedTabId", "currentSelectedTabId", "W2", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/fragment/WinkQZoneTemplateLibMainFragment;", "d3", "b3", "()Landroidx/fragment/app/Fragment;", "Lcom/tencent/mobileqq/wink/picker/QCircleInitBean;", "initBean", "i3", "", "T2", "", "Y2", "pageId", "l3", "Z2", "target", "c3", "u3", "Landroid/content/Intent;", "i", "e3", "isLightTheme", "v3", "r3", "index", "p3", "t3", "isInsideWink", ICustomDataEditor.NUMBER_PARAM_3, "id", "j3", "f3", "initRequestedOrientation", "outState", "Landroid/os/PersistableBundle;", "outPersistentState", "onSaveInstanceState", "onCreate", "Landroid/net/Uri;", "onProvideReferrer", "doOnCreate", "Landroid/content/res/Configuration;", "newConfig", "doOnConfigurationChanged", "intent", "doOnNewIntent", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "doOnSaveInstanceState", "requestCode", QzoneIPCModule.RESULT_CODE, "data", "doOnActivityResult", "onBackEvent", "dispatchOnBackPressed", "doOnDestroy", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/mobileqq/wink/context/p;", "a0", "Lcom/tencent/mobileqq/wink/context/p;", "winkCurrentContextBuilder", "Lb93/e;", "b0", "Lb93/e;", "winkFinishHelper", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "c0", "Ljava/util/HashMap;", "schemaData", "d0", "Z", "isAlbumEntrance", "Lcom/tencent/mobileqq/wink/pager/FragmentPager;", "e0", "Lcom/tencent/mobileqq/wink/pager/FragmentPager;", "fragmentPager", "Landroidx/viewpager2/widget/ViewPager2;", "f0", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager", "g0", "Lcom/tencent/aelight/camera/ae/flashshow/view/TabLayout;", "tabLayout", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/p;", "h0", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/p;", "pickerUIViewModel", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/u;", "i0", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/u;", "publishInfoViewModel", "j0", "Ljava/util/List;", "tabLayoutNoneBgPageIds", "k0", "Ljava/lang/String;", "traceId", "<init>", "()V", "l0", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WinkHomeActivity extends QPublicFragmentActivity implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: m0, reason: collision with root package name */
    private static final int f64033m0 = ViewExKt.d(56);

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private HashMap<String, String> schemaData;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private FragmentPager<?> fragmentPager;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private ViewPager2 viewPager;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private TabLayout tabLayout;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.wink.picker.core.viewmodel.p pickerUIViewModel;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.wink.picker.core.viewmodel.u publishInfoViewModel;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private final List<String> tabLayoutNoneBgPageIds;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private String traceId;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mobileqq.wink.context.p winkCurrentContextBuilder = new com.tencent.mobileqq.wink.context.p();

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private final b93.e winkFinishHelper = new b93.e();

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private boolean isAlbumEntrance = true;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\t\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/WinkHomeActivity$a;", "", "", "BOTTOM_TAB_HEIGHT_DP", "I", "a", "()I", "", "CAPTURE_PAGE_ID", "Ljava/lang/String;", "MEDIA_PICKER_PAGE_ID", "SAVED_PAGE_POS", "TAG", "TEMPLATE_PAGE_ID", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.aelight.camera.ae.flashshow.WinkHomeActivity$a, reason: from kotlin metadata */
    /* loaded from: classes32.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return WinkHomeActivity.f64033m0;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J.\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/WinkHomeActivity$b", "Lcom/tencent/aelight/camera/ae/flashshow/view/TabLayout$f;", "", "index", "", "switchType", "lastSelectedTabId", "currentSelectedTabId", "", "b", "", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class b implements TabLayout.f {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<com.tencent.mobileqq.wink.pager.b<T>> f64046b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ TabLayout f64047c;

        /* JADX WARN: Multi-variable type inference failed */
        b(List<? extends com.tencent.mobileqq.wink.pager.b<? extends T>> list, TabLayout tabLayout) {
            this.f64046b = list;
            this.f64047c = tabLayout;
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.view.TabLayout.f
        public boolean a(int index) {
            return true;
        }

        @Override // com.tencent.aelight.camera.ae.flashshow.view.TabLayout.f
        public void b(int index, String switchType, String lastSelectedTabId, String currentSelectedTabId) {
            Object orNull;
            String str;
            Object orNull2;
            ViewPager2 viewPager2 = WinkHomeActivity.this.viewPager;
            if (viewPager2 != null) {
                viewPager2.setCurrentItem(index, false);
            }
            List list = WinkHomeActivity.this.tabLayoutNoneBgPageIds;
            orNull = CollectionsKt___CollectionsKt.getOrNull(this.f64046b, index);
            com.tencent.mobileqq.wink.pager.b bVar = (com.tencent.mobileqq.wink.pager.b) orNull;
            if (bVar == null || (str = bVar.getPageId()) == null) {
                str = "";
            }
            if (list.contains(str)) {
                TabLayout tabLayout = WinkHomeActivity.this.tabLayout;
                if (tabLayout != null) {
                    tabLayout.setBackgroundColor(0);
                }
            } else {
                TabLayout tabLayout2 = WinkHomeActivity.this.tabLayout;
                if (tabLayout2 != null) {
                    tabLayout2.setBackgroundColor(ie0.a.f().g(this.f64047c.getContext(), R.color.qui_common_bg_bottom_light, 1000));
                }
            }
            boolean z16 = true;
            if (!QQTheme.isNowThemeIsNight()) {
                orNull2 = CollectionsKt___CollectionsKt.getOrNull(this.f64046b, index);
                com.tencent.mobileqq.wink.pager.b bVar2 = (com.tencent.mobileqq.wink.pager.b) orNull2;
                if (!(bVar2 != null && bVar2.getIsLightTheme())) {
                    z16 = false;
                }
            }
            WinkHomeActivity.this.v3(z16);
            WinkHomeActivity.this.W2(switchType, lastSelectedTabId, currentSelectedTabId);
            WinkHomeActivity.this.p3(index);
            this.f64047c.w(index, false);
        }
    }

    public WinkHomeActivity() {
        List<String> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf("CAPTURE_PAGE");
        this.tabLayoutNoneBgPageIds = mutableListOf;
        this.traceId = "";
    }

    private final <T extends Fragment & FragmentPager.d> void T2(List<com.tencent.mobileqq.wink.pager.b<T>> pages) {
        if (!getIntent().getBooleanExtra(QQWinkConstants.HOME_SHOW_CAPTURE_TAB, false)) {
            com.tencent.mobileqq.wink.pager.c.d(pages, "CAPTURE_PAGE");
        } else {
            bh bhVar = bh.f64208a;
            ViewPager2 viewPager2 = this.viewPager;
            Intrinsics.checkNotNull(viewPager2);
            bhVar.a(viewPager2);
        }
        if (!(this.isAlbumEntrance && getIntent().getBooleanExtra(QQWinkConstants.HOME_SHOW_PICKER_TAB, false))) {
            com.tencent.mobileqq.wink.pager.c.d(pages, "MEDIA_PICKER_PAGE");
        }
        if (getIntent().getBooleanExtra(QQWinkConstants.HOME_SHOW_TEMPLATE_TAB, false)) {
            return;
        }
        com.tencent.mobileqq.wink.pager.c.d(pages, "TEMPLATE_PAGE");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final boolean Y2() {
        return getIntent().getBooleanExtra(QQWinkConstants.HOME_SHOW_TEMPLATE_TAB, false) && com.tencent.mobileqq.wink.utils.ar.f326685a.c("ae_key_editor_need_show_template_tab_red_dot", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T extends Fragment & FragmentPager.d> T b3() {
        TabType tabType;
        Config copy;
        T t16;
        Serializable serializableExtra = getIntent().getSerializableExtra("QZONE_MEDIA_PICKER_CONFIG");
        Config config = serializableExtra instanceof Config ? (Config) serializableExtra : null;
        String stringExtra = getIntent().getStringExtra(QQWinkConstants.ENTRY_BUSINESS_NAME);
        if (stringExtra != null) {
            int hashCode = stringExtra.hashCode();
            if (hashCode != 67973745) {
                if (hashCode == 77564797 && stringExtra.equals("QZONE")) {
                    com.tencent.mobileqq.wink.picker.qzone.n.f325197a.i();
                    QZoneMediaPickerFragment.Companion companion = QZoneMediaPickerFragment.INSTANCE;
                    Serializable serializableExtra2 = getIntent().getSerializableExtra("WINK_MEDIA_PICKER_INIT_BEAN");
                    t16 = companion.a(config, serializableExtra2 instanceof QZoneInitBean ? (QZoneInitBean) serializableExtra2 : null);
                }
            } else if (stringExtra.equals("Flock")) {
                t16 = FlockMediaPickerFragment.INSTANCE.a(config);
            }
            Intrinsics.checkNotNull(t16, "null cannot be cast to non-null type T of com.tencent.aelight.camera.ae.flashshow.WinkHomeActivity.getMediaPickerFragment");
            return t16;
        }
        QCircleMediaPickerFragment qCircleMediaPickerFragment = new QCircleMediaPickerFragment();
        Serializable serializableExtra3 = getIntent().getSerializableExtra("WINK_MEDIA_PICKER_INIT_BEAN");
        QCircleInitBean qCircleInitBean = serializableExtra3 instanceof QCircleInitBean ? (QCircleInitBean) serializableExtra3 : null;
        if (qCircleInitBean == null) {
            qCircleInitBean = new QCircleInitBean(false, false, null, 7, null);
        }
        if (config == null || (tabType = config.getLocalMediaTabType()) == null) {
            tabType = TabType.ALL_MEDIA;
        }
        Map<String, String> b16 = com.tencent.mobileqq.wink.schema.d.f326305a.b(WinkContext.INSTANCE.d().p(QCircleScheme.AttrQQPublish.PICKER_CONFIG));
        if (b16 != null) {
            tabType = TabType.INSTANCE.a(b16.get("tabType"));
            qCircleInitBean.setShowVideoTemplateButton(false);
        }
        TabType tabType2 = tabType;
        i3(qCircleInitBean);
        if (config == null) {
            Config.Companion companion2 = Config.INSTANCE;
            config = new Config.a().a();
        }
        copy = r6.copy((r34 & 1) != 0 ? r6.localMediaTabType : tabType2, (r34 & 2) != 0 ? r6.initLocalMediaTab : null, (r34 & 4) != 0 ? r6.initLocalDbQueryType : null, (r34 & 8) != 0 ? r6.ZoneMediaTabType : null, (r34 & 16) != 0 ? r6.needDragSelect : false, (r34 & 32) != 0 ? r6.needScrollTimeline : false, (r34 & 64) != 0 ? r6.maxSelectMediaSize : 0, (r34 & 128) != 0 ? r6.startCountNum : 0, (r34 & 256) != 0 ? r6.alreadySelectedMediaPath : null, (r34 & 512) != 0 ? r6.alreadySelectedMedia : null, (r34 & 1024) != 0 ? r6.queryMediaFilter : null, (r34 & 2048) != 0 ? r6.selectMediaFilter : null, (r34 & 4096) != 0 ? r6.needShowExitDialog : false, (r34 & 8192) != 0 ? r6.firstIconCamera : false, (r34 & 16384) != 0 ? r6.businessRequestCode : 0, (r34 & 32768) != 0 ? config.from : null);
        Bundle bundle = new Bundle();
        bundle.putBoolean(QQWinkConstants.KEY_IS_PICKER_FIRST_PAGE, true);
        bundle.putSerializable("WINK_MEDIA_PICKER_CONFIG", copy);
        bundle.putSerializable("WINK_MEDIA_PICKER_INIT_BEAN", qCircleInitBean);
        qCircleMediaPickerFragment.setArguments(bundle);
        t16 = qCircleMediaPickerFragment;
        Intrinsics.checkNotNull(t16, "null cannot be cast to non-null type T of com.tencent.aelight.camera.ae.flashshow.WinkHomeActivity.getMediaPickerFragment");
        return t16;
    }

    private final String c3(String target) {
        if (Intrinsics.areEqual(target, "1")) {
            return "MEDIA_PICKER_PAGE";
        }
        if (Intrinsics.areEqual(target, "2")) {
            return "TEMPLATE_PAGE";
        }
        return "CAPTURE_PAGE";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkQZoneTemplateLibMainFragment d3() {
        WinkQZoneTemplateLibMainFragment winkQZoneTemplateLibMainFragment = new WinkQZoneTemplateLibMainFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("ARG_PADDING_BOTTOM", getIntent().getBooleanExtra("ARG_PADDING_BOTTOM", true));
        winkQZoneTemplateLibMainFragment.setArguments(bundle);
        return winkQZoneTemplateLibMainFragment;
    }

    private final void e3(Intent i3) {
        Serializable serializableExtra = i3.getSerializableExtra("key_attrs");
        if (serializableExtra instanceof Map) {
            Object obj = ((Map) serializableExtra).get("target");
            if (obj instanceof String) {
                u3(c3((String) obj));
            }
        }
    }

    private final void f3() {
        try {
            try {
                ms.a.f("WinkHomeActivity", "initAEKitReport-begin");
                Bundle extras = getIntent().getExtras();
                Intrinsics.checkNotNull(extras);
                int i3 = extras.getInt(AECameraConstants.VIDEO_STORY_FROM_TYPE, js.a.f410904d.b());
                String stringExtra = getIntent().getStringExtra(AECameraConstants.VIDEO_STORY_ACTIVITY_ID);
                js.a e16 = js.a.e(i3);
                Intrinsics.checkNotNullExpressionValue(e16, "parse(from)");
                if (e16.c()) {
                    AEBaseReportParam.U().O0(i3, stringExtra);
                }
                AEBaseReportParam.U().s1(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin());
                AEBaseReportParam.U().d1(true);
                AEBaseReportParam.U().g1();
                AEBaseReportParam.U().h1();
                AEBaseReportParam.U().E0(dr.c.b());
                AEBaseReportParam.U().c1(true);
            } catch (Exception e17) {
                ms.a.c("WinkHomeActivity", "initAEKitReport error " + e17);
            }
        } finally {
            ms.a.f("WinkHomeActivity", "initAEKitReport-end");
        }
    }

    private final void i3(QCircleInitBean initBean) {
        HashMap<String, String> hashMap = this.schemaData;
        String str = hashMap != null ? hashMap.get("template") : null;
        if ((str == null || str.length() == 0) || initBean == null) {
            return;
        }
        initBean.setShowVideoTemplateButton(false);
    }

    private final void initReport() {
        boolean isBlank;
        boolean isBlank2;
        String stringExtra = getIntent().getStringExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID);
        if (stringExtra == null) {
            stringExtra = "";
        }
        String stringExtra2 = getIntent().getStringExtra(QQWinkConstants.ENTRY_BUSINESS_NAME);
        String str = stringExtra2 != null ? stringExtra2 : "";
        isBlank = StringsKt__StringsJVMKt.isBlank(stringExtra);
        if (!isBlank) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank2) {
                WinkPublishReportQueue.INSTANCE.report(new WinkPublishQualityReportData.Builder().eventId(QCirclePublishQualityReporter.E_WINK_INDEX_ENTRY).traceId(stringExtra).ext1(String.valueOf(getIntent().getIntExtra(IProfileCardConst.KEY_FROM_TYPE, -1))).ext2("false").ext6(WinkReportUtils.isInMultiWindowMode(this)).retCode("0").getReportData(), str);
            }
        }
        WinkDTParamBuilder.setDtParams(getIntent());
        com.tencent.mobileqq.wink.utils.h.c(getIntent());
        r3();
        ab.c().a(this);
    }

    private final String j3(int id5) {
        String string = getResources().getString(id5);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(id)");
        return string;
    }

    private final boolean l3(String pageId) {
        if (Intrinsics.areEqual(pageId, "TEMPLATE_PAGE")) {
            return Y2();
        }
        return false;
    }

    private final void n3(boolean isInsideWink) {
        ((IQQFloatingWindowBroadcast) QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplication.getContext(), !isInsideWink, 51);
        ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplication.getContext(), 2, !isInsideWink);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p3(int index) {
        com.tencent.mobileqq.wink.pager.b<?> i3;
        TabLayout tabLayout = this.tabLayout;
        if (tabLayout != null) {
            FragmentPager<?> fragmentPager = this.fragmentPager;
            String pageId = (fragmentPager == null || (i3 = fragmentPager.i(index)) == null) ? null : i3.getPageId();
            if (Intrinsics.areEqual(pageId, "MEDIA_PICKER_PAGE")) {
                bh.f64208a.b(tabLayout);
            } else if (Intrinsics.areEqual(pageId, "TEMPLATE_PAGE")) {
                com.tencent.mobileqq.wink.utils.ar.f326685a.m("ae_key_editor_need_show_template_tab_red_dot", false);
            }
        }
    }

    private final void r3() {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this, QCircleDaTongConstant.PageId.BASE);
        VideoReport.setPageParams(this, new QCircleDTParamBuilder().buildPageParams("WinkHomeActivity", null));
        QLog.i("WinkHomeActivity", 1, "reportDaTongRegister  subPage: WinkHomeActivity");
    }

    private final void s3() {
        String traceId = WinkContext.INSTANCE.d().getTraceId();
        this.traceId = traceId;
        w53.b.a("WinkHomeActivity", "initTraceIdFromIntent:" + traceId);
    }

    private final void setSystemUI() {
        super.getWindow().addFlags(128);
        this.mNeedStatusTrans = true;
        this.mActNeedImmersive = false;
        SystemBarActivityModule.setImmersiveStatus(this);
        LiuHaiUtils.initLiuHaiProperty(this);
        LiuHaiUtils.enableNotch(this);
    }

    private final void t3() {
        Intent intent = new Intent();
        QLog.i("WinkHomeActivity", 1, "[sendMobileQQPeakCreate]");
        intent.setAction("publish_entrance_dialog_close");
        intent.setPackage(BaseApplication.getContext().getPackageName());
        sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u3(String pageId) {
        TabLayout tabLayout;
        FragmentPager<?> fragmentPager = this.fragmentPager;
        int j3 = fragmentPager != null ? fragmentPager.j(pageId) : 0;
        if (j3 < 0 || (tabLayout = this.tabLayout) == null) {
            return;
        }
        tabLayout.u(j3, true);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public void dispatchOnBackPressed() {
        super.dispatchOnBackPressed();
        HashMap<String, String> hashMap = this.schemaData;
        String str = hashMap != null ? hashMap.get("taskid") : null;
        if (str != null && com.tencent.mobileqq.wink.utils.t.f326727a.b(str)) {
            overridePendingTransition(R.anim.f154548b2, R.anim.f154480ae);
        } else {
            overridePendingTransition(R.anim.f154548b2, R.anim.f155066i1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QPublicFragmentActivity, mqq.app.AppActivity
    public void doOnActivityResult(int requestCode, int resultCode, Intent data) {
        FragmentPager<?> fragmentPager = this.fragmentPager;
        if (fragmentPager != null) {
            fragmentPager.l(requestCode, resultCode, data);
        }
    }

    @Override // com.tencent.mobileqq.activity.QPublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnConfigurationChanged(Configuration newConfig) {
        super.doOnConfigurationChanged(newConfig);
        ImmersiveUtils.resetDensity();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QPublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle savedInstanceState) {
        if (isInMultiWindow()) {
            w53.b.f("WinkHomeActivity", "isInMultiWindowMode = true");
            if (uq3.c.Y()) {
                Bundle extras = getIntent().getExtras();
                if (extras != null) {
                    ((IQQWinkLaunchReporter) QRoute.api(IQQWinkLaunchReporter.class)).reportOnClickBroken(extras.getString(PeakConstants.QCIRCLE_CLIENT_TRACEID), extras.getInt(IProfileCardConst.KEY_FROM_TYPE), "-100012", false);
                }
            } else {
                Bundle extras2 = getIntent().getExtras();
                if (extras2 != null) {
                    ((IQQWinkLaunchReporter) QRoute.api(IQQWinkLaunchReporter.class)).reportOnClickBroken(extras2.getString(PeakConstants.QCIRCLE_CLIENT_TRACEID), extras2.getInt(IProfileCardConst.KEY_FROM_TYPE), "-100012", true);
                }
                WinkCrashReportParams.clearAllParams();
                QQToast.makeText(this, HardCodeUtil.qqStr(R.string.y06), 0).show();
                finish();
                return false;
            }
        }
        setSystemUI();
        setContentView(R.layout.doy);
        setVolumeControlStream(3);
        tq.b.h().a();
        com.tencent.aelight.camera.aioeditor.capture.control.a.f66678b = false;
        sendBroadcast(new Intent(PeakConstants.AE_BROADCAST_ACTION_AE_OPEN_CAMERA), "com.tencent.msg.permission.pushnotify");
        this.schemaData = com.tencent.mobileqq.wink.schema.d.f326305a.e(getIntent());
        this.isAlbumEntrance = getIntent().getBooleanExtra("AECAMERA_TAB_ALBUM_ENTRANCE", true);
        g3(savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
        AEEditorMusicHelper.b(this);
        EnhanceHelper.getInstance().updateEnhanceConfigInSubThread();
        aq.d.f26717a.e();
        com.tencent.mobileqq.wink.picker.core.viewmodel.p pVar = this.pickerUIViewModel;
        if (pVar != null) {
            LiveData<Boolean> P1 = pVar.P1();
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.aelight.camera.ae.flashshow.WinkHomeActivity$doOnCreate$3$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code restructure failed: missing block: B:7:0x0013, code lost:
                
                    r0 = r3.this$0.fragmentPager;
                 */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke2(Boolean it) {
                    FragmentPager fragmentPager;
                    TabLayout tabLayout = WinkHomeActivity.this.tabLayout;
                    boolean z16 = false;
                    if (tabLayout != null && tabLayout.m() == 1) {
                        z16 = true;
                    }
                    if (z16 || fragmentPager == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    fragmentPager.q(it.booleanValue());
                }
            };
            P1.observe(this, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.bf
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkHomeActivity.U2(Function1.this, obj);
                }
            });
            LiveData<String> Q1 = pVar.Q1();
            final Function1<String, Unit> function12 = new Function1<String, Unit>() { // from class: com.tencent.aelight.camera.ae.flashshow.WinkHomeActivity$doOnCreate$3$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str) {
                    WinkHomeActivity.this.u3("CAPTURE_PAGE");
                }
            };
            Q1.observe(this, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.bg
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkHomeActivity.V2(Function1.this, obj);
                }
            });
        }
        com.tencent.mobileqq.wink.picker.core.viewmodel.u uVar = this.publishInfoViewModel;
        if (uVar != null) {
            uVar.M1();
        }
        initReport();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        n3(false);
        tq.b.h().s(true);
        tq.b.h().e();
        ab.c().b();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        v83.b.f441239a.b();
        sendBroadcast(new Intent(PeakConstants.AE_BROADCAST_ACTION_AE_CLOSE_CAMERA), "com.tencent.msg.permission.pushnotify");
        com.tencent.videocut.render.utils.b.f384205a.a();
        AlbumThumbManager.getInstance(this).clear();
        TabLayout tabLayout = this.tabLayout;
        if (tabLayout != null) {
            tabLayout.setTabSelectCallback(null);
        }
        FragmentPager<?> fragmentPager = this.fragmentPager;
        if (fragmentPager != null) {
            fragmentPager.n();
        }
        this.fragmentPager = null;
        AlbumThumbManager.getInstance(BaseApplication.context).clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QPublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        w53.b.f("WinkHomeActivity", "doOnNewIntent");
        super.doOnNewIntent(intent);
        if (intent != null) {
            getIntent().putExtras(intent);
            e3(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.doOnSaveInstanceState(outState);
        ViewPager2 viewPager2 = this.viewPager;
        outState.putInt("SAVED_PAGE_POS", viewPager2 != null ? viewPager2.getCurrentItem() : -1);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(WinkFinishActivityEvent.class);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.QPublicFragmentActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        FragmentPager<?> fragmentPager = this.fragmentPager;
        boolean z16 = false;
        if (fragmentPager != null && fragmentPager.m()) {
            z16 = true;
        }
        if (z16) {
            return true;
        }
        return super.onBackEvent();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        w53.b.f("WinkHomeActivity", "onCreate");
        ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).initialize();
        this.winkCurrentContextBuilder.a(savedInstanceState, getIntent());
        s3();
        this.pickerUIViewModel = com.tencent.mobileqq.wink.picker.core.viewmodel.q.a(this);
        this.publishInfoViewModel = com.tencent.mobileqq.wink.picker.core.viewmodel.q.b(this);
        f3();
        t3();
        super.onCreate(savedInstanceState);
        com.tencent.mobileqq.wink.picker.report.b bVar = com.tencent.mobileqq.wink.picker.report.b.f325261a;
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        bVar.e(intent);
        ImmersiveUtils.resetDensity();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.winkFinishHelper.b(this);
    }

    @Override // android.app.Activity
    public Uri onProvideReferrer() {
        return WinkContext.INSTANCE.k();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (!(event instanceof WinkFinishActivityEvent) || isFinishing()) {
            return;
        }
        WinkFinishActivityEvent winkFinishActivityEvent = (WinkFinishActivityEvent) event;
        if (this.winkFinishHelper.e(winkFinishActivityEvent, this.traceId)) {
            this.winkFinishHelper.a(this, winkFinishActivityEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.winkCurrentContextBuilder.a(null, getIntent());
        n3(true);
        this.winkFinishHelper.c();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        Intrinsics.checkNotNullParameter(outPersistentState, "outPersistentState");
        super.onSaveInstanceState(outState, outPersistentState);
        this.winkCurrentContextBuilder.c(outState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W2(String switchType, String lastSelectedTabId, String currentSelectedTabId) {
        if (switchType == null || switchType.length() == 0) {
            return;
        }
        WinkHomeActivity$dtReportTabSwitchType$getTabValue$1 winkHomeActivity$dtReportTabSwitchType$getTabValue$1 = new Function1<String, String>() { // from class: com.tencent.aelight.camera.ae.flashshow.WinkHomeActivity$dtReportTabSwitchType$getTabValue$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String str) {
                if (str != null) {
                    int hashCode = str.hashCode();
                    if (hashCode != -1329327308) {
                        if (hashCode != -1181169656) {
                            if (hashCode == 12980133 && str.equals("MEDIA_PICKER_PAGE")) {
                                return WinkDaTongReportConstant.ElementParamValue.BOTTOM_TAB_VALUE_ALBUM;
                            }
                        } else if (str.equals("CAPTURE_PAGE")) {
                            return WinkDaTongReportConstant.ElementParamValue.BOTTOM_TAB_VALUE_CAPTURE;
                        }
                    } else if (str.equals("TEMPLATE_PAGE")) {
                        return WinkDaTongReportConstant.ElementParamValue.BOTTOM_TAB_VALUE_LIBRARY;
                    }
                }
                return "";
            }
        };
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.BOTTOM_TAB_SWITCH_WAY, switchType);
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.BOTTOM_TAB_BEFORE_SWITCH, winkHomeActivity$dtReportTabSwitchType$getTabValue$1.invoke((WinkHomeActivity$dtReportTabSwitchType$getTabValue$1) lastSelectedTabId));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.BOTTOM_TAB_AFTER_SWITCH, winkHomeActivity$dtReportTabSwitchType$getTabValue$1.invoke((WinkHomeActivity$dtReportTabSwitchType$getTabValue$1) currentSelectedTabId));
        VideoReport.reportEvent(WinkDaTongReportConstant.EventId.EV_QZ_PIC_CHOOSE_BOTTOM_TAB_SWITCH, null, buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v3(boolean isLightTheme) {
        RFWThemeUtil.setStatusTextColor(!isLightTheme, getWindow());
        RFWThemeUtil.setNavigationBarColor(this, ContextCompat.getColor(this, isLightTheme ? R.color.f156601ag3 : R.color.f156602ag4));
    }

    private final <T extends Fragment & FragmentPager.d> int Z2(Bundle savedInstanceState, List<? extends com.tencent.mobileqq.wink.pager.b<? extends T>> pages) {
        int i3 = savedInstanceState != null ? savedInstanceState.getInt("SAVED_PAGE_POS") : -1;
        if (i3 >= 0 && i3 < pages.size()) {
            QLog.i("WinkHomeActivity", 1, "savedPagePos = " + i3);
            return i3;
        }
        int a16 = com.tencent.mobileqq.wink.pager.c.a(pages, c3(getIntent().getStringExtra("AECAMERA_TAB_SELECTED")));
        return a16 > -1 ? a16 : com.tencent.mobileqq.wink.pager.c.a(pages, "TEMPLATE_PAGE");
    }

    private final <T extends Fragment & FragmentPager.d> TabLayout h3(List<? extends com.tencent.mobileqq.wink.pager.b<? extends T>> pages, int initialPagePos) {
        int collectionSizeOrDefault;
        TabLayout tabLayout = (TabLayout) findViewById(R.id.s26);
        if (tabLayout == null) {
            return null;
        }
        if (pages.size() <= 1) {
            tabLayout.setVisibility(8);
        }
        tabLayout.setTabSelectCallback(new b(pages, tabLayout));
        List<? extends com.tencent.mobileqq.wink.pager.b<? extends T>> list = pages;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.wink.pager.b bVar = (com.tencent.mobileqq.wink.pager.b) it.next();
            arrayList.add(new TabLayout.h(bVar.getPageId(), bVar.getPageName(), l3(bVar.getPageId())));
        }
        tabLayout.setTabs(arrayList, initialPagePos);
        return tabLayout;
    }

    private final void g3(Bundle savedInstanceState) {
        List mutableListOf;
        com.tencent.mobileqq.wink.picker.core.viewmodel.p pVar;
        this.viewPager = (ViewPager2) findViewById(R.id.s4u);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(com.tencent.mobileqq.wink.pager.c.c("CAPTURE_PAGE", j3(R.string.y07), true, false, new Function0<WinkCaptureFragment>() { // from class: com.tencent.aelight.camera.ae.flashshow.WinkHomeActivity$initFragmentPager$pageHolders$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkCaptureFragment invoke() {
                return new WinkCaptureFragment(null, 1, null);
            }
        }, 8, null), com.tencent.mobileqq.wink.pager.c.c("MEDIA_PICKER_PAGE", j3(R.string.f169861y04), false, false, new Function0<Object>() { // from class: com.tencent.aelight.camera.ae.flashshow.WinkHomeActivity$initFragmentPager$pageHolders$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Fragment b36;
                b36 = WinkHomeActivity.this.b3();
                return b36;
            }
        }, 8, null), com.tencent.mobileqq.wink.pager.c.c("TEMPLATE_PAGE", j3(R.string.y_4), false, false, new Function0<WinkQZoneTemplateLibMainFragment>() { // from class: com.tencent.aelight.camera.ae.flashshow.WinkHomeActivity$initFragmentPager$pageHolders$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkQZoneTemplateLibMainFragment invoke() {
                WinkQZoneTemplateLibMainFragment d36;
                d36 = WinkHomeActivity.this.d3();
                return d36;
            }
        }, 8, null));
        T2(mutableListOf);
        if (mutableListOf.size() == 1 && (pVar = this.pickerUIViewModel) != null) {
            pVar.U1(false);
        }
        int Z2 = Z2(savedInstanceState, mutableListOf);
        this.tabLayout = h3(mutableListOf, Z2);
        FragmentPager.PageConfig pageConfig = new FragmentPager.PageConfig(false, 0, 0, mutableListOf.size(), false, Z2, 6, null);
        int i3 = mutableListOf.size() <= 1 ? 0 : f64033m0;
        ViewPager2 viewPager2 = this.viewPager;
        Intrinsics.checkNotNull(viewPager2);
        this.fragmentPager = new FragmentPager<>(this, viewPager2, pageConfig, this.tabLayout, mutableListOf, i3, new Function1<String, Unit>() { // from class: com.tencent.aelight.camera.ae.flashshow.WinkHomeActivity$initFragmentPager$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                WinkHomeActivity.this.u3(it);
            }
        });
    }

    @Override // com.tencent.mobileqq.activity.QPublicFragmentActivity
    protected void initRequestedOrientation() {
    }
}
