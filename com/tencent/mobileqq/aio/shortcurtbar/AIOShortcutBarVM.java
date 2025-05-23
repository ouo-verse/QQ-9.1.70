package com.tencent.mobileqq.aio.shortcurtbar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.part.root.panel.mvx.intent.PanelStatusIntent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.aio.api.IQQTabApi;
import com.tencent.mobileqq.aio.background.FullBackgroundMviIntent;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.AnonymousChatEvent;
import com.tencent.mobileqq.aio.event.InputEvent;
import com.tencent.mobileqq.aio.event.LongShotMsgIntent;
import com.tencent.mobileqq.aio.event.PhotoPanelEvent;
import com.tencent.mobileqq.aio.event.ShortCutBarEvent;
import com.tencent.mobileqq.aio.event.ThemeEvent;
import com.tencent.mobileqq.aio.input.blockstate.TroopBlockStateChange;
import com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent;
import com.tencent.mobileqq.aio.input.fullscreen.e;
import com.tencent.mobileqq.aio.input.gag.InputGagMsgIntent;
import com.tencent.mobileqq.aio.lateinit.aioreserve1.AIOReserve1CreateModelIntent;
import com.tencent.mobileqq.aio.reserve1.image.AIOFastImageMsgIntent;
import com.tencent.mobileqq.aio.shortcurtbar.AIOShortcutBarUIState;
import com.tencent.mobileqq.aio.shortcurtbar.a;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.aio.utils.am;
import com.tencent.mobileqq.album.api.IAlbumApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IGameMsgApi;
import com.tencent.qqnt.aio.adapter.api.IReportControllerApi;
import com.tencent.qqnt.aio.background.AIOBackgroundMsgIntent;
import com.tencent.qqnt.aio.shortcutbar.j;
import com.tencent.qqnt.camera.api.ICameraAPI;
import com.tencent.qqnt.camera.data.CameraReq;
import com.tencent.qqnt.emotion.data.msg.EmotionPanelEvent;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.qqnt.kernel.nativeinterface.GroupAnonymousInfo;
import com.tencent.qqnt.mycomputer.api.IMyComputerHelpApi;
import com.tencent.qqnt.photopanel.api.IPhotoPanelApi;
import com.tencent.qqnt.pluspanel.data.msg.PlusPanelEvent;
import com.tencent.qqnt.qbasealbum.event.OpenHalfAlbumEvent;
import com.tencent.qqnt.qbasealbum.model.AlbumResult;
import com.tencent.qqnt.qbasealbum.model.Config;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.model.TabType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0085\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001N\b\u0007\u0018\u0000 )2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0001WB\u0007\u00a2\u0006\u0004\bU\u0010VJ\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\nH\u0002J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\nH\u0002J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\nH\u0002J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\nH\u0002J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u001a\u001a\u00020\u0013H\u0002J\u0018\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\nH\u0002J\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\nH\u0002J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u001e\u001a\u00020\bH\u0002J\b\u0010\u001f\u001a\u00020\nH\u0002J.\u0010'\u001a\u00020\b2\u0006\u0010!\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010&\u001a\u00020%H\u0002J\u0010\u0010)\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u0013H\u0002J\b\u0010*\u001a\u00020\nH\u0002J\u0010\u0010-\u001a\u00020\b2\u0006\u0010,\u001a\u00020+H\u0016J\b\u0010.\u001a\u00020\bH\u0016J\u0010\u0010/\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0012\u00101\u001a\u00020\b2\b\u00100\u001a\u0004\u0018\u00010\u0005H\u0016J$\u00105\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050302j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000503`4H\u0016RC\u0010<\u001a*\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"06j\u0014\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"`78BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u001b\u0010@\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u00109\u001a\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010E\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010BR\u0016\u0010G\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010BR\u0016\u0010I\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010HR\u0016\u0010J\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010BR\u0018\u0010M\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010LR\u0014\u0010Q\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010PR&\u0010T\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020N0R0\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010S\u00a8\u0006X"}, d2 = {"Lcom/tencent/mobileqq/aio/shortcurtbar/AIOShortcutBarVM;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lcom/tencent/mobileqq/aio/shortcurtbar/a;", "Lcom/tencent/mobileqq/aio/shortcurtbar/AIOShortcutBarUIState;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "E", "", "isFullScreenMode", "u", "isGagMode", "y", "needTransparentBg", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, ViewStickEventHelper.IS_SHOW, "J", "", "panelId", "isSelect", HippyTKDListViewAdapter.X, "D", "w", "G", ReportConstant.COSTREPORT_PREFIX, "L", "t", "v", "K", "B", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "", "permissionList", "Lcom/tencent/qqnt/aio/shortcutbar/j;", "listener", "p", "tag", "H", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "e", "Lkotlin/Lazy;", "r", "()Ljava/util/HashMap;", "mPermissionMap", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Z", "mNavBarSwitch", h.F, "Z", "mIsPlusPanelSelect", "i", "mIsFullScreenMode", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isPhotoPanelActive", "I", "mLastClickPanelId", "mFirstOpenEmojiPanel", "Lcom/tencent/mobileqq/aio/api/IQQTabApi$a;", "Lcom/tencent/mobileqq/aio/api/IQQTabApi$a;", "mAlbumEntity", "com/tencent/mobileqq/aio/shortcurtbar/AIOShortcutBarVM$e", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/aio/shortcurtbar/AIOShortcutBarVM$e;", "mAction1", "Lkotlin/Pair;", "Ljava/util/List;", "mMessageList", "<init>", "()V", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes11.dex */
public final class AIOShortcutBarVM extends com.tencent.qqnt.aio.baseVM.a<a, AIOShortcutBarUIState> implements SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final boolean I;

    /* renamed from: C, reason: from kotlin metadata */
    private int mLastClickPanelId;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mFirstOpenEmojiPanel;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private IQQTabApi.a mAlbumEntity;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final e mAction1;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final List<Pair<String, e>> mMessageList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mPermissionMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mNavBarSwitch;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mIsPlusPanelSelect;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mIsFullScreenMode;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isPhotoPanelActive;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/aio/shortcurtbar/AIOShortcutBarVM$a;", "", "", "REPORT_ACTION_CLICK_AUDIO_PANEL", "Ljava/lang/String;", "REPORT_ACTION_CLICK_EMOTICON_PANEL", "REPORT_ACTION_CLICK_HONGBAO_PANEL", "REPORT_ACTION_CLICK_PHOTOLIST_PANEL", "REPORT_ACTION_CLICK_PTV_PANEL", "REPORT_ACTION_CLICK_PULS_PANEL", "TAG", "", "enableDelayOpenEmojiPanel", "Z", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.shortcurtbar.AIOShortcutBarVM$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J,\u0010\t\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00042\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/aio/shortcurtbar/AIOShortcutBarVM$b", "Lcom/tencent/qqnt/aio/shortcutbar/j;", "", "b", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "c", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b extends j {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOShortcutBarVM.this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qqnt.aio.shortcutbar.j
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QLog.i("AIOShortcutBarVM", 1, "[handleIconClick]: dataline panel file, onAllGranted");
            IMyComputerHelpApi iMyComputerHelpApi = (IMyComputerHelpApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMyComputerHelpApi.class);
            FragmentActivity requireActivity = ((com.tencent.aio.api.runtime.a) AIOShortcutBarVM.this.getMContext()).c().requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "mContext.fragment.requireActivity()");
            iMyComputerHelpApi.myComputerOpenFileSelector(requireActivity, ((com.tencent.aio.api.runtime.a) AIOShortcutBarVM.this.getMContext()).g().r().c().j());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qqnt.aio.shortcutbar.j
        public void c(@Nullable List<String> permissions, @Nullable List<Integer> results) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) permissions, (Object) results);
                return;
            }
            QLog.i("AIOShortcutBarVM", 1, "[handleIconClick]: dataline panel file, onDenied");
            IMyComputerHelpApi iMyComputerHelpApi = (IMyComputerHelpApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMyComputerHelpApi.class);
            FragmentActivity requireActivity = ((com.tencent.aio.api.runtime.a) AIOShortcutBarVM.this.getMContext()).c().requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "mContext.fragment.requireActivity()");
            iMyComputerHelpApi.myComputerOpenFileSelector(requireActivity, ((com.tencent.aio.api.runtime.a) AIOShortcutBarVM.this.getMContext()).g().r().c().j());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/aio/shortcurtbar/AIOShortcutBarVM$c", "Lcom/tencent/qqnt/aio/shortcutbar/j;", "", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c extends j {
        static IPatchRedirector $redirector_;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f193741c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AIOShortcutBarVM f193742d;

        c(int i3, AIOShortcutBarVM aIOShortcutBarVM) {
            this.f193741c = i3;
            this.f193742d = aIOShortcutBarVM;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) aIOShortcutBarVM);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qqnt.aio.shortcutbar.j
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QLog.i("AIOShortcutBarVM", 1, "[handleIconClick]: show panel after checkPermission, panelId is " + this.f193741c);
            int i3 = this.f193741c;
            if (i3 == 1003) {
                this.f193742d.G(i3);
            } else {
                ((com.tencent.aio.api.runtime.a) this.f193742d.getMContext()).e().h(new PanelContainerMsgIntent.ShowPanelMsgIntent("AIOShortcutBarVM", this.f193741c, false, 0, 12, null));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/aio/shortcurtbar/AIOShortcutBarVM$d", "Lcom/tencent/qqnt/aio/shortcutbar/j;", "", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class d extends j {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f193744d;

        d(boolean z16) {
            this.f193744d = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AIOShortcutBarVM.this, Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.qqnt.aio.shortcutbar.j
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                AIOShortcutBarVM.this.D(this.f193744d);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/shortcurtbar/AIOShortcutBarVM$e", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class e implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOShortcutBarVM.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                AIOShortcutBarVM.this.E(i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/aio/shortcurtbar/AIOShortcutBarVM$f", "Law3/a;", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class f implements aw3.a {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOShortcutBarVM.this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64967);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
            I = FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("aio_enable_delay_open_emoji_panel_9015", true);
        }
    }

    public AIOShortcutBarVM() {
        Lazy lazy;
        Lazy lazy2;
        List<Pair<String, e>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(AIOShortcutBarVM$mPermissionMap$2.INSTANCE);
            this.mPermissionMap = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(AIOShortcutBarVM$mNavBarSwitch$2.INSTANCE);
            this.mNavBarSwitch = lazy2;
            this.mFirstOpenEmojiPanel = true;
            e eVar = new e();
            this.mAction1 = eVar;
            com.tencent.qqnt.aio.utils.j jVar = com.tencent.qqnt.aio.utils.j.f352301a;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(jVar.a(Reflection.getOrCreateKotlinClass(PanelContainerMsgIntent.OnPanelStateChangedMsgIntent.class)), eVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(PanelStatusIntent.PanelStatusChangeIntent.class)), eVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.MultiSelectModeChangeEvent.class)), eVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(TroopBlockStateChange.class)), eVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.LongShotModeChangeEvent.class)), eVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(InputEvent.AIOShortcutBarHide.class)), eVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(InputEvent.AIOShortcutBarShow.class)), eVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(PhotoPanelEvent.SelectMediaChanged.class)), eVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(ThemeEvent.PostThemeChanged.class)), eVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(ShortCutBarEvent.SetShortcutInterceptListener.class)), eVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(ShortCutBarEvent.SetShortcutPanelClickListener.class)), eVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AnonymousChatEvent.SwitchAnonymousChatEvent.class)), eVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(PlusPanelEvent.FetchPlusPanelAppList.class)), eVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(FullScreenMsgIntent.OnFullScreenModeChanged.class)), eVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(PhotoPanelEvent.PhotoPanelActive.class)), eVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(InputGagMsgIntent.OnInputGagModeChanged.class)), eVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(EmotionPanelEvent.FetchEmotionRedDot.class)), eVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOBackgroundMsgIntent.ImmersiveChangeMsg.class)), eVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(FullBackgroundMviIntent.UpdateAIOBackground.class)), eVar)});
            this.mMessageList = listOf;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void A(boolean needTransparentBg) {
        int e16 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e();
        boolean isNowSimpleUI = QQTheme.isNowSimpleUI();
        QLog.i("AIOShortcutBarVM", 1, "[handlePostThemeChange]: simpleUI= " + isNowSimpleUI + ", chatType= " + e16);
        if ((e16 == 1 || e16 == 2) && !com.tencent.mobileqq.aio.msglist.holder.component.multifoward.b.f191309a.j((com.tencent.aio.api.runtime.a) getMContext()) && !am.f194110a.j((com.tencent.aio.api.runtime.a) getMContext()) && !C()) {
            J(!isNowSimpleUI);
        }
        updateUI(new AIOShortcutBarUIState.PostThemeChanged(needTransparentBg));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean B() {
        Boolean bool;
        e.b bVar = (e.b) ((com.tencent.aio.api.runtime.a) getMContext()).e().k(FullScreenMsgIntent.GetInputConsumeSelectPhotoOperate.f189580d);
        if (bVar != null) {
            bool = Boolean.valueOf(bVar.a());
        } else {
            bool = null;
        }
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean C() {
        e.a aVar;
        k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(FullScreenMsgIntent.GetFullScreenMode.f189578d);
        if (k3 instanceof e.a) {
            aVar = (e.a) k3;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return aVar.a();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void D(boolean isSelect) {
        int i3;
        boolean z16;
        TabType tabType;
        if (this.mIsFullScreenMode) {
            return;
        }
        if (this.isPhotoPanelActive) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PhotoPanelEvent.PhotoIconLongClick(isSelect));
            return;
        }
        int e16 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e();
        com.tencent.qqnt.qbasealbum.a aVar = com.tencent.qqnt.qbasealbum.a.f360732a;
        Context requireContext = ((com.tencent.aio.api.runtime.a) getMContext()).c().requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "mContext.fragment.requireContext()");
        Config.Companion companion = Config.INSTANCE;
        Config.a aVar2 = new Config.a();
        boolean z17 = false;
        aVar2.j(false);
        if (e16 == 8) {
            i3 = 50;
        } else {
            i3 = 20;
        }
        aVar2.g(i3);
        if (e16 != 8) {
            z16 = true;
        } else {
            z16 = false;
        }
        aVar2.m(z16);
        if (((IAlbumApi) QRoute.api(IAlbumApi.class)).needToBlockVideo(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e())) {
            tabType = TabType.TAB_IMAGE;
        } else {
            tabType = TabType.TAB_MEDIA;
        }
        aVar2.f(tabType);
        aVar2.h(4);
        aVar2.e(e16);
        if (e16 == 1) {
            z17 = true;
        }
        aVar2.d(z17);
        Unit unit = Unit.INSTANCE;
        Intent e17 = com.tencent.qqnt.qbasealbum.a.e(aVar, requireContext, aVar2.a(), null, null, null, 28, null);
        e17.putExtra("album_open_id", ((com.tencent.aio.api.runtime.a) getMContext()).hashCode());
        e17.putExtra("show_album_mode_tips", true);
        ((IPhotoPanelApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IPhotoPanelApi.class)).fillIntentForJumpAlbum(e17, (com.tencent.aio.api.runtime.a) getMContext());
        ((com.tencent.aio.api.runtime.a) getMContext()).f().a(e17, new ActivityResultCallback() { // from class: com.tencent.mobileqq.aio.shortcurtbar.c
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                AIOShortcutBarVM.F(AIOShortcutBarVM.this, (ActivityResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void E(MsgIntent intent) {
        if (intent instanceof PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) {
            PanelContainerMsgIntent.OnPanelStateChangedMsgIntent onPanelStateChangedMsgIntent = (PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) intent;
            updateUI(new AIOShortcutBarUIState.UpdateIconSelectUIState(onPanelStateChangedMsgIntent.b(), onPanelStateChangedMsgIntent.a()));
            return;
        }
        if (intent instanceof PanelStatusIntent.PanelStatusChangeIntent) {
            PanelStatusIntent.PanelStatusChangeIntent panelStatusChangeIntent = (PanelStatusIntent.PanelStatusChangeIntent) intent;
            updateUI(new AIOShortcutBarUIState.UpdateIconSelect(panelStatusChangeIntent.a(), panelStatusChangeIntent.b()));
            return;
        }
        if (intent instanceof AIOMsgListEvent.MultiSelectModeChangeEvent) {
            J(!((AIOMsgListEvent.MultiSelectModeChangeEvent) intent).b());
            return;
        }
        if (intent instanceof TroopBlockStateChange) {
            J(!com.tencent.mobileqq.aio.input.blockstate.b.a((TroopBlockStateChange) intent));
            return;
        }
        if (intent instanceof AIOMsgListEvent.LongShotModeChangeEvent) {
            updateUI(new AIOShortcutBarUIState.ShotShortcutBar(((AIOMsgListEvent.LongShotModeChangeEvent) intent).b()));
            return;
        }
        if (intent instanceof InputEvent.AIOShortcutBarHide) {
            J(false);
            return;
        }
        if (intent instanceof InputEvent.AIOShortcutBarShow) {
            J(true);
            return;
        }
        if (intent instanceof PhotoPanelEvent.SelectMediaChanged) {
            updateUI(new AIOShortcutBarUIState.PhotoPanelMediaSelected(((PhotoPanelEvent.SelectMediaChanged) intent).a().size()));
            return;
        }
        if (intent instanceof ThemeEvent.PostThemeChanged) {
            A(AIOUtil.f194084a.D((com.tencent.aio.api.runtime.a) getMContext()));
            return;
        }
        if (intent instanceof AIOBackgroundMsgIntent.ImmersiveChangeMsg) {
            A(true);
            return;
        }
        if (intent instanceof ShortCutBarEvent.SetShortcutInterceptListener) {
            updateUI(new AIOShortcutBarUIState.SetInterceptListener(((ShortCutBarEvent.SetShortcutInterceptListener) intent).a()));
            return;
        }
        if (intent instanceof ShortCutBarEvent.SetShortcutPanelClickListener) {
            updateUI(new AIOShortcutBarUIState.SetPanelClickListener(((ShortCutBarEvent.SetShortcutPanelClickListener) intent).a()));
            return;
        }
        if (intent instanceof AnonymousChatEvent.SwitchAnonymousChatEvent) {
            GroupAnonymousInfo a16 = ((AnonymousChatEvent.SwitchAnonymousChatEvent) intent).a();
            if (a16 != null) {
                updateUI(new AIOShortcutBarUIState.UpdatePanelIcon(a16.isAnonymousChat, AIOUtil.f194084a.D((com.tencent.aio.api.runtime.a) getMContext())));
                return;
            }
            return;
        }
        if (intent instanceof PlusPanelEvent.FetchPlusPanelAppList) {
            updateUI(AIOShortcutBarUIState.FetchPlusIconRedDot.f193714d);
            return;
        }
        if (intent instanceof EmotionPanelEvent.FetchEmotionRedDot) {
            updateUI(AIOShortcutBarUIState.FetchEmoIconRedDot.f193713d);
            return;
        }
        if (intent instanceof FullScreenMsgIntent.OnFullScreenModeChanged) {
            u(((FullScreenMsgIntent.OnFullScreenModeChanged) intent).a());
            return;
        }
        if (intent instanceof PhotoPanelEvent.PhotoPanelActive) {
            this.isPhotoPanelActive = ((PhotoPanelEvent.PhotoPanelActive) intent).a();
            return;
        }
        if (intent instanceof InputGagMsgIntent.OnInputGagModeChanged) {
            y(((InputGagMsgIntent.OnInputGagModeChanged) intent).a());
        } else if ((intent instanceof FullBackgroundMviIntent.UpdateAIOBackground) && q()) {
            A(AIOUtil.f194084a.D((com.tencent.aio.api.runtime.a) getMContext()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void F(AIOShortcutBarVM this$0, ActivityResult activityResult) {
        AlbumResult albumResult;
        List<LocalMediaInfo> e16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (activityResult.getResultCode() != -1) {
            return;
        }
        Intent data = activityResult.getData();
        if (data != null) {
            albumResult = (AlbumResult) data.getParcelableExtra("ALBUM_RESULT");
        } else {
            albumResult = null;
        }
        if (albumResult != null && (e16 = albumResult.e()) != null) {
            ((com.tencent.aio.api.runtime.a) this$0.getMContext()).e().h(new PanelContainerMsgIntent.HideAllPanelAndKeyboardMsgIntent("AIOShortcutBarVM", false, 2, null));
            Iterator<LocalMediaInfo> it = e16.iterator();
            while (it.hasNext()) {
                BuildersKt__Builders_commonKt.launch$default(this$0.vmScope(), null, null, new AIOShortcutBarVM$jumpToAlbum$1$1(this$0, it.next(), albumResult, null), 3, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void G(int panelId) {
        if (this.mAlbumEntity == null) {
            this.mAlbumEntity = ((IQQTabApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQTabApi.class)).getExpEntity("exp_QQ_aio_photo_choose", true);
        }
        if (FastClickUtils.isFastDoubleClick("openAlbum", 70L)) {
            QLog.i("AIOShortcutBarVM", 1, "isFastDoubleClick open album");
            return;
        }
        com.tencent.qqnt.qbasealbum.utils.a aVar = com.tencent.qqnt.qbasealbum.utils.a.f361642a;
        if (aVar.c() && aVar.a() == 2) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelContainerMsgIntent.ShowPanelMsgIntent("AIOShortcutBarVM", panelId, false, 0, 12, null));
        } else {
            D(true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void H(int tag) {
        String str;
        if (!((com.tencent.aio.api.runtime.a) getMContext()).g().l().getBoolean("key_is_scale_chat")) {
            return;
        }
        switch (tag) {
            case 1000:
                str = "0X800C299";
                break;
            case 1001:
                str = "0X800C29D";
                break;
            case 1002:
                str = "0X800C29E";
                break;
            case 1003:
                str = "0X800C29A";
                break;
            case 1004:
                str = "0X800C29C";
                break;
            case 1005:
                str = "0X800C29B";
                break;
            default:
                return;
        }
        String str2 = str;
        ((IReportControllerApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IReportControllerApi.class)).reportWith898(null, "", "", str2, str2, 0, 0, "", String.valueOf(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e()), "", "");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void J(boolean isShow) {
        int e16 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e();
        QLog.i("AIOShortcutBarVM", 1, "[setVisibility]: isShow= " + isShow + ", chatType= " + e16);
        if (isShow) {
            if (com.tencent.mobileqq.aio.utils.f.f194152a.b(e16)) {
                updateUI(new AIOShortcutBarUIState.SetVisibility(8));
                return;
            } else {
                updateUI(new AIOShortcutBarUIState.SetVisibility(0));
                return;
            }
        }
        updateUI(new AIOShortcutBarUIState.SetVisibility(8));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void K() {
        if (com.tencent.mobileqq.aio.panel.c.f193019a.a((com.tencent.aio.api.runtime.a) getMContext())) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelContainerMsgIntent.HideAllPanelAndKeyboardMsgIntent("AIOShortcutBarVM", false));
        }
        ((ICameraAPI) QRoute.api(ICameraAPI.class)).startCameraAndCallback((com.tencent.aio.api.runtime.a) getMContext(), new CameraReq(null, 1, null), new f());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void L(int panelId, boolean isSelect) {
        if (panelId == 1006) {
            this.mIsPlusPanelSelect = !isSelect;
        } else if (this.mIsPlusPanelSelect) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(PlusPanelEvent.RemovePanelEvent.f360443d);
        }
    }

    private final void p(Activity activity, int panelId, List<String> permissionList, j listener) {
        String str;
        Iterator<T> it = permissionList.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            if (activity.checkSelfPermission((String) it.next()) != 0) {
                z16 = true;
            }
        }
        if (!z16) {
            listener.b();
            return;
        }
        if (panelId != 1000) {
            if (panelId != 1003) {
                if (panelId != 1005) {
                    str = "";
                } else {
                    str = "camera";
                }
            } else {
                str = "album";
            }
        } else {
            str = "ptt";
        }
        String str2 = str;
        com.tencent.mobileqq.aio.shortcurtbar.permission.a aVar = com.tencent.mobileqq.aio.shortcurtbar.permission.a.f193758a;
        Object[] array = permissionList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        aVar.a(activity, str2, (String[]) array, 2, listener);
    }

    private final boolean q() {
        return ((Boolean) this.mNavBarSwitch.getValue()).booleanValue();
    }

    private final HashMap<Integer, List<String>> r() {
        return (HashMap) this.mPermissionMap.getValue();
    }

    private final int s() {
        if (this.mFirstOpenEmojiPanel && I) {
            return 60;
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void t(int panelId, boolean isSelect) {
        if (QLog.isColorLevel()) {
            QLog.i("AIOShortcutBarVM", 2, "panelId: " + panelId + ", isSelect: " + isSelect);
        }
        if (panelId == 1006 && !isSelect) {
            QLog.i("AIOShortcutBarVM", 1, "from aio short cut bar");
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOReserve1CreateModelIntent("fast_image", AIOFastImageMsgIntent.QueryFastImageIntent.f193262d));
        } else {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOReserve1CreateModelIntent("fast_image", AIOFastImageMsgIntent.RemoveFastImageIntent.f193263d));
        }
    }

    private final void u(boolean isFullScreenMode) {
        J(!isFullScreenMode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void v(int panelId) {
        if (panelId == 1006) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(PlusPanelEvent.RemoveIceBreakHotPicEvent.f360442d);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void w(int panelId, boolean isSelect) {
        if (panelId == this.mLastClickPanelId && FastClickUtils.isFastDoubleClick("AIOShortcutBarVM")) {
            return;
        }
        this.mLastClickPanelId = panelId;
        H(panelId);
        L(panelId, isSelect);
        t(panelId, isSelect);
        v(panelId);
        if (isSelect) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelContainerMsgIntent.HideAllPanelAndKeyboardMsgIntent("AIOShortcutBarVM", false, 2, null));
            QLog.i("AIOShortcutBarVM", 1, "[handleIconClick]: is aleady select");
            return;
        }
        if (panelId == 1005) {
            K();
            QLog.i("AIOShortcutBarVM", 1, "[handleIconClick]: startCameraActivity");
            return;
        }
        if (panelId == 1013) {
            IGameMsgApi iGameMsgApi = (IGameMsgApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IGameMsgApi.class);
            FragmentActivity requireActivity = ((com.tencent.aio.api.runtime.a) getMContext()).c().requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "mContext.fragment.requireActivity()");
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            iGameMsgApi.startGameTeaming(requireActivity, g16);
            QLog.i("AIOShortcutBarVM", 1, "[handleIconClick]: game teaming");
            return;
        }
        if (panelId == 1003 && B()) {
            QLog.i("AIOShortcutBarVM", 1, "[handleIconClick]: selectPhotoOperate is consumed");
            return;
        }
        if (panelId == 1015) {
            QLog.i("AIOShortcutBarVM", 1, "[handleIconClick]: dataline panel file, panelId is " + panelId);
            FragmentActivity requireActivity2 = ((com.tencent.aio.api.runtime.a) getMContext()).c().requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity2, "mContext.fragment.requireActivity()");
            List<String> list = r().get(Integer.valueOf(panelId));
            Intrinsics.checkNotNull(list);
            p(requireActivity2, panelId, list, new b());
            return;
        }
        if (!r().containsKey(Integer.valueOf(panelId))) {
            if (panelId == 1001) {
                int s16 = s();
                this.mFirstOpenEmojiPanel = false;
                ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelContainerMsgIntent.ShowPanelMsgIntent("AIOShortcutBarVM", panelId, false, s16, 4, null));
            } else {
                ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelContainerMsgIntent.ShowPanelMsgIntent("AIOShortcutBarVM", panelId, false, 0, 12, null));
            }
            QLog.i("AIOShortcutBarVM", 1, "[handleIconClick]: show panel, panelId is " + panelId);
            return;
        }
        QLog.i("AIOShortcutBarVM", 1, "[handleIconClick]: checkPermission, panelId is " + panelId);
        FragmentActivity requireActivity3 = ((com.tencent.aio.api.runtime.a) getMContext()).c().requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity3, "mContext.fragment.requireActivity()");
        List<String> list2 = r().get(Integer.valueOf(panelId));
        Intrinsics.checkNotNull(list2);
        p(requireActivity3, panelId, list2, new c(panelId, this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void x(int panelId, boolean isSelect) {
        if (panelId != 1003) {
            return;
        }
        if (!r().containsKey(Integer.valueOf(panelId))) {
            D(isSelect);
            return;
        }
        FragmentActivity requireActivity = ((com.tencent.aio.api.runtime.a) getMContext()).c().requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "mContext.fragment.requireActivity()");
        List<String> list = r().get(Integer.valueOf(panelId));
        Intrinsics.checkNotNull(list);
        p(requireActivity, panelId, list, new d(isSelect));
    }

    private final void y(boolean isGagMode) {
        updateUI(new AIOShortcutBarUIState.IconEnableState(!isGagMode));
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ArrayList) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(OpenHalfAlbumEvent.class);
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onDestroy();
        Iterator<T> it = this.mMessageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().b((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
        this.mIsPlusPanelSelect = false;
        this.mLastClickPanelId = 0;
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) event);
        } else if ((event instanceof OpenHalfAlbumEvent) && ((OpenHalfAlbumEvent) event).getOpenId() == ((com.tencent.aio.api.runtime.a) getMContext()).hashCode()) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelContainerMsgIntent.ShowPanelMsgIntent("AIOShortcutBarVM", 1003, false, 0, 12, null));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.C7358a) {
            a.C7358a c7358a = (a.C7358a) intent;
            w(c7358a.a(), c7358a.b());
            return;
        }
        if (intent instanceof a.c) {
            a.c cVar = (a.c) intent;
            x(cVar.a(), cVar.b());
            return;
        }
        if (intent instanceof a.b) {
            AIOContact c16 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c();
            a.b bVar = (a.b) intent;
            bVar.d(c16.e());
            bVar.f(c16.j());
            bVar.e(AIOUtil.f194084a.D((com.tencent.aio.api.runtime.a) getMContext()));
            return;
        }
        if (intent instanceof a.d) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new LongShotMsgIntent.GetShortcutBarBitmap(((a.d) intent).a()));
        } else if (intent instanceof a.e) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new FullBackgroundMviIntent.UpdateNavigationBg(((a.e) intent).a()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        Iterator<T> it = this.mMessageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().d((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
        this.isPhotoPanelActive = false;
        SimpleEventBus.getInstance().registerReceiver(this);
    }
}
