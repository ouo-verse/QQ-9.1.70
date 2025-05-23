package com.tencent.mobileqq.aio.input.simpleui;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.aio.data.AIOContact;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.input.base.mvicompat.e;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.input.base.panelcontainer.keyboard.KeyboardMsgIntent;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.event.InputSimpleEventIntent;
import com.tencent.mobileqq.aio.event.LifeCycleEvent;
import com.tencent.mobileqq.aio.event.ThemeEvent;
import com.tencent.mobileqq.aio.event.c;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent;
import com.tencent.mobileqq.aio.input.fullscreen.e;
import com.tencent.mobileqq.aio.input.gag.InputGagMsgIntent;
import com.tencent.mobileqq.aio.input.gag.a;
import com.tencent.mobileqq.aio.input.simpleui.InputSimpleUIMsgIntent;
import com.tencent.mobileqq.aio.input.simpleui.InputSimpleUIState;
import com.tencent.mobileqq.aio.input.simpleui.d;
import com.tencent.mobileqq.aio.input.simpleui.e;
import com.tencent.mobileqq.aio.lateinit.aioreserve1.AIOReserve1CreateModelIntent;
import com.tencent.mobileqq.aio.reserve1.image.AIOFastImageMsgIntent;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.g;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IAudioRecordTouchEventApi;
import com.tencent.qqnt.aio.shortcutbar.j;
import com.tencent.qqnt.emotion.data.msg.EmotionPanelEvent;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.qqnt.pluspanel.data.msg.PlusPanelEvent;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0081\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0006*\u0003QUX\b\u0007\u0018\u0000 H2\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\u0002`\u00062\u00020\u0007:\u0001\\B\u000f\u0012\u0006\u0010A\u001a\u00020\u0005\u00a2\u0006\u0004\b[\u0010@J\u0012\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u001a\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\bH\u0002J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\bH\u0002J\u001a\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\bH\u0002J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\bH\u0002J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0017H\u0002J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0019H\u0002J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u001bH\u0002J\u0010\u0010 \u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\bH\u0002J\u0010\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\u001bH\u0002J\b\u0010%\u001a\u00020$H\u0002J\b\u0010&\u001a\u00020$H\u0002J\b\u0010'\u001a\u00020\nH\u0002J\u0010\u0010)\u001a\u00020\n2\u0006\u0010(\u001a\u00020\bH\u0002J\b\u0010*\u001a\u00020\nH\u0002J\u0018\u0010.\u001a\u00020\n2\u0006\u0010+\u001a\u00020\b2\u0006\u0010-\u001a\u00020,H\u0002J\u0010\u00100\u001a\u00020\n2\u0006\u0010/\u001a\u00020\bH\u0002J\u0010\u00102\u001a\u00020\n2\u0006\u00101\u001a\u00020\bH\u0002J\u0018\u00105\u001a\u00020\n2\u0006\u00103\u001a\u00020\u00042\u0006\u00104\u001a\u00020\bH\u0016J\b\u00106\u001a\u00020\nH\u0016J\u000e\u00109\u001a\b\u0012\u0004\u0012\u00020807H\u0016J\u0010\u0010:\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0002H\u0016R\"\u0010A\u001a\u00020\u00058\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010ER\u0016\u0010I\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010K\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010JR\u0016\u0010L\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010ER\u0016\u0010M\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010ER\u0016\u0010O\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010ER\u0018\u0010P\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010JR\u0014\u0010T\u001a\u00020Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010W\u001a\u00020U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010VR\u0014\u0010Z\u001a\u00020X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u0010Y\u00a8\u0006]"}, d2 = {"Lcom/tencent/mobileqq/aio/input/simpleui/c;", "Lcom/tencent/input/base/mvicompat/e;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVMDelegate;", "Lcom/tencent/mvi/base/route/g;", "", "isSimpleUI", "", "E", "Lcom/tencent/mobileqq/aio/input/simpleui/d$g;", "intent", "v", "newPressToSpeakState", "needShowKeyboardWhenExitSpeakState", "g", "f", "i", "w", "Lcom/tencent/mobileqq/aio/input/simpleui/d$e;", "u", "Lcom/tencent/mobileqq/aio/input/simpleui/d$d;", "t", "Lcom/tencent/mobileqq/aio/input/simpleui/d$a;", "o", "Lcom/tencent/mvi/base/route/MsgIntent;", "event", "l", DomainData.DOMAIN_NAME, "isGagMode", "r", "msgIntent", "Lcom/tencent/mvi/base/route/k;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/aio/event/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", BdhLogUtil.LogTag.Tag_Conn, "isFullScreenMode", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "showPanel", "", "panelId", "B", "showKeyboard", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "needChangePtt", "H", "context", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, HippyTKDListViewAdapter.X, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Ljava/lang/Class;", "Lcom/tencent/mobileqq/aio/input/simpleui/d;", "d0", ReportConstant.COSTREPORT_PREFIX, "d", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "k", "()Lcom/tencent/mobileqq/aio/input/adorn/c;", "G", "(Lcom/tencent/mobileqq/aio/input/adorn/c;)V", "mHost", "e", "Lcom/tencent/aio/api/runtime/a;", "mContext", "Z", "mIsPanelShow", h.F, "I", "mPanelId", "Ljava/lang/Boolean;", "mIsPressToSpeakMode", "mIsInFullScreenMode", "mIsInGagMode", "D", "mIsInSimpleUIMode", "mUpdateSimpleUIHintWhenExitFullScreenMode", "com/tencent/mobileqq/aio/input/simpleui/c$c", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/aio/input/simpleui/c$c;", "mAction", "com/tencent/mobileqq/aio/input/simpleui/c$d", "Lcom/tencent/mobileqq/aio/input/simpleui/c$d;", "mActionR", "com/tencent/mobileqq/aio/input/simpleui/c$e", "Lcom/tencent/mobileqq/aio/input/simpleui/c$e;", "mTempViewFetcher", "<init>", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class c implements com.tencent.input.base.mvicompat.e<at.a, InputUIState, com.tencent.aio.api.runtime.a, com.tencent.mobileqq.aio.input.adorn.c>, g {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mIsInGagMode;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mIsInSimpleUIMode;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Boolean mUpdateSimpleUIHintWhenExitFullScreenMode;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final C7286c mAction;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final d mActionR;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final e mTempViewFetcher;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.aio.input.adorn.c mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mIsPanelShow;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mPanelId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Boolean mIsPressToSpeakMode;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mIsInFullScreenMode;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/aio/input/simpleui/c$a;", "", "", "NEED_CHANGE_PTT_CONFIG_KEY", "Ljava/lang/String;", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.simpleui.c$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\b\u001a\u00020\u00072\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00022\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0002H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/aio/input/simpleui/c$b", "Lcom/tencent/qqnt/aio/shortcutbar/j;", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "", "c", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b extends j {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f189908d;

        b(boolean z16) {
            this.f189908d = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, c.this, Boolean.valueOf(z16));
            }
        }

        @Override // com.tencent.qqnt.aio.shortcutbar.j
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                super.b();
                c.this.i(true, this.f189908d);
            }
        }

        @Override // com.tencent.qqnt.aio.shortcutbar.j
        public void c(@Nullable List<String> permissions, @Nullable List<Integer> results) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) permissions, (Object) results);
            } else {
                super.c(permissions, results);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/input/simpleui/c$c", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.simpleui.c$c, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C7286c implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        C7286c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                c.this.l(i3);
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/input/simpleui/c$d", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class d implements com.tencent.mvi.base.route.b {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public k call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (k) iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            }
            Intrinsics.checkNotNullParameter(i3, "i");
            return c.this.m(i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/aio/input/simpleui/c$e", "", "Landroid/view/View;", "a", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class e {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Nullable
        public final View a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            e.a aVar = new e.a(null, 1, null);
            c.this.getMHost().fetchVBState(aVar);
            return aVar.a();
        }

        @Nullable
        public final View b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (View) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            e.b bVar = new e.b(null, 1, null);
            c.this.getMHost().fetchVBState(bVar);
            return bVar.a();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56996);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c(@NotNull com.tencent.mobileqq.aio.input.adorn.c mHost) {
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mHost);
            return;
        }
        this.mHost = mHost;
        this.mAction = new C7286c();
        this.mActionR = new d();
        this.mTempViewFetcher = new e();
    }

    private final void A(boolean showKeyboard) {
        if (showKeyboard) {
            this.mIsPanelShow = false;
            H(!FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("aio_input_need_change_ptt_9020_119433947", true));
        }
    }

    private final void B(boolean showPanel, int panelId) {
        this.mIsPanelShow = showPanel;
        if (showPanel) {
            this.mPanelId = panelId;
            if (panelId != 1001) {
                if (panelId == 1006) {
                    K(new InputSimpleUIState.UpdateFunBtnState(true));
                }
            } else {
                K(new InputSimpleUIState.UpdateFunBtnState(false, 1, null));
            }
        }
        H(true);
    }

    private final void C() {
        boolean isNowSimpleUI = QQTheme.isNowSimpleUI();
        if (!isNowSimpleUI) {
            K(new InputSimpleUIState.ModeCompatState(this.mIsInFullScreenMode, this.mIsInGagMode, new InputSimpleUIState.ModeCompatState.a(false, false)));
        }
        if (this.mIsInFullScreenMode) {
            this.mUpdateSimpleUIHintWhenExitFullScreenMode = Boolean.valueOf(isNowSimpleUI);
        } else {
            E(isNowSimpleUI);
        }
    }

    private final void E(boolean isSimpleUI) {
        e.a aVar;
        boolean z16;
        a.C7269a c7269a;
        boolean z17;
        this.mIsInSimpleUIMode = isSimpleUI;
        K(new InputSimpleUIState.UpdateSimpleUIState(isSimpleUI));
        if (isSimpleUI) {
            com.tencent.aio.api.runtime.a aVar2 = this.mContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                aVar2 = null;
            }
            com.tencent.mvi.base.route.j e16 = aVar2.e();
            k k3 = e16.k(FullScreenMsgIntent.GetFullScreenMode.f189578d);
            if (k3 instanceof e.a) {
                aVar = (e.a) k3;
            } else {
                aVar = null;
            }
            if (aVar != null) {
                z16 = aVar.a();
            } else {
                z16 = false;
            }
            this.mIsInFullScreenMode = z16;
            k k16 = e16.k(InputGagMsgIntent.GetGagMode.f189666d);
            if (k16 instanceof a.C7269a) {
                c7269a = (a.C7269a) k16;
            } else {
                c7269a = null;
            }
            if (c7269a != null) {
                z17 = c7269a.a();
            } else {
                z17 = false;
            }
            this.mIsInGagMode = z17;
            K(new InputSimpleUIState.ModeCompatState(this.mIsInFullScreenMode, z17, new InputSimpleUIState.ModeCompatState.a(false, false, 2, null)));
        }
    }

    static /* synthetic */ void F(c cVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = QQTheme.isNowSimpleUI();
        }
        cVar.E(z16);
    }

    private final void H(boolean needChangePtt) {
        boolean z16;
        boolean z17;
        boolean z18 = this.mIsPanelShow;
        boolean z19 = true;
        if (z18 && this.mPanelId == 1000) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z18 && this.mPanelId == 1001) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z18 || this.mPanelId != 1006) {
            z19 = false;
        }
        K(new InputSimpleUIState.UpdateIconState(z16, z17, z19, needChangePtt));
    }

    private final void f(boolean needShowKeyboardWhenExitSpeakState) {
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        FragmentActivity fragmentActivity = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        Fragment c16 = aVar.c();
        if (c16 != null) {
            fragmentActivity = c16.requireActivity();
        }
        FragmentActivity fragmentActivity2 = fragmentActivity;
        if (fragmentActivity2 == null) {
            QLog.e("InputSimpleUIVMDelegate", 1, "[checkPermissionBeforePressToSpeak]: activity is null");
        } else if (fragmentActivity2.checkSelfPermission(QQPermissionConstants.Permission.RECORD_AUDIO) != 0) {
            com.tencent.mobileqq.aio.shortcurtbar.permission.a.f193758a.a(fragmentActivity2, "ptt", new String[]{QQPermissionConstants.Permission.RECORD_AUDIO}, 2, new b(needShowKeyboardWhenExitSpeakState));
        } else {
            i(true, needShowKeyboardWhenExitSpeakState);
        }
    }

    private final void g(boolean newPressToSpeakState, boolean needShowKeyboardWhenExitSpeakState) {
        if (Intrinsics.areEqual(Boolean.valueOf(newPressToSpeakState), this.mIsPressToSpeakMode)) {
            return;
        }
        if (newPressToSpeakState) {
            f(needShowKeyboardWhenExitSpeakState);
        } else {
            i(false, needShowKeyboardWhenExitSpeakState);
        }
    }

    static /* synthetic */ void h(c cVar, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z17 = false;
        }
        cVar.g(z16, z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(boolean newPressToSpeakState, boolean needShowKeyboardWhenExitSpeakState) {
        K(new InputSimpleUIState.ModeCompatState(this.mIsInFullScreenMode, this.mIsInGagMode, new InputSimpleUIState.ModeCompatState.a(newPressToSpeakState, needShowKeyboardWhenExitSpeakState)));
    }

    static /* synthetic */ void j(c cVar, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z17 = false;
        }
        cVar.i(z16, z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(MsgIntent event) {
        if (event instanceof LifeCycleEvent.OnPause) {
            try {
                ((IAudioRecordTouchEventApi) QRoute.api(IAudioRecordTouchEventApi.class)).setPauseEvent();
            } catch (Exception unused) {
            }
        } else if (event instanceof ThemeEvent.PostThemeChanged) {
            C();
        } else if (this.mIsInSimpleUIMode) {
            n(event);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final k m(MsgIntent msgIntent) {
        if (msgIntent instanceof InputSimpleEventIntent.OnGetEmoIconViewIntent) {
            return p();
        }
        if (msgIntent instanceof InputSimpleEventIntent.OnGetShortCutLayoutViewIntent) {
            return q();
        }
        return new c.a();
    }

    private final void n(MsgIntent intent) {
        if (intent instanceof FullScreenMsgIntent.OnFullScreenModeChanged) {
            y(((FullScreenMsgIntent.OnFullScreenModeChanged) intent).a());
            return;
        }
        if (intent instanceof InputEditTextMsgIntent.EditTextChangedMsgIntent) {
            z();
            return;
        }
        if (intent instanceof PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) {
            PanelContainerMsgIntent.OnPanelStateChangedMsgIntent onPanelStateChangedMsgIntent = (PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) intent;
            B(onPanelStateChangedMsgIntent.b(), onPanelStateChangedMsgIntent.a());
            return;
        }
        if (intent instanceof KeyboardMsgIntent.OnKeyboardStateChanged) {
            A(((KeyboardMsgIntent.OnKeyboardStateChanged) intent).b());
            return;
        }
        if (intent instanceof PlusPanelEvent.FetchPlusPanelAppList) {
            K(InputSimpleUIState.UpdateSimplePlusRedDot.f189890d);
            return;
        }
        if (intent instanceof EmotionPanelEvent.FetchEmotionRedDot) {
            K(InputSimpleUIState.UpdateSimpleEmoRedDot.f189889d);
            return;
        }
        if (intent instanceof AIOMsgSendEvent.MsgOnClickReplyEvent) {
            h(this, false, false, 2, null);
        } else if (intent instanceof PanelContainerMsgIntent.ShowPanelMsgIntent) {
            h(this, false, false, 2, null);
        } else if (intent instanceof InputGagMsgIntent.OnInputGagModeChanged) {
            r(((InputGagMsgIntent.OnInputGagModeChanged) intent).a());
        }
    }

    private final void o(d.a intent) {
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar != null) {
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                aVar = null;
            }
            intent.b(aVar);
        }
    }

    private final com.tencent.mobileqq.aio.event.c p() {
        View a16 = this.mTempViewFetcher.a();
        if (a16 != null) {
            return new c.b(a16);
        }
        return new c.a();
    }

    private final com.tencent.mobileqq.aio.event.c q() {
        View b16 = this.mTempViewFetcher.b();
        if (b16 != null) {
            return new c.C7243c(b16);
        }
        return new c.a();
    }

    private final void r(boolean isGagMode) {
        this.mIsInGagMode = isGagMode;
        K(new InputSimpleUIState.ModeCompatState(this.mIsInFullScreenMode, isGagMode, new InputSimpleUIState.ModeCompatState.a(Intrinsics.areEqual(this.mIsPressToSpeakMode, Boolean.TRUE), false)));
    }

    private final void t(d.C7287d intent) {
        com.tencent.aio.api.runtime.a aVar = null;
        if (intent.a()) {
            com.tencent.aio.api.runtime.a aVar2 = this.mContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                aVar = aVar2;
            }
            aVar.e().h(new InputEditTextMsgIntent.ShowKeyboardMsgIntent(0L));
            return;
        }
        com.tencent.aio.api.runtime.a aVar3 = this.mContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            aVar = aVar3;
        }
        aVar.e().h(new PanelContainerMsgIntent.ShowPanelMsgIntent("InputSimpleUIVMDelegate", 1001, false, 0, 12, null));
    }

    private final void u(d.e intent) {
        QLog.i("InputSimpleUIVMDelegate", 1, "[handleOnFunBtnClick]: selected is " + intent.a());
        com.tencent.aio.api.runtime.a aVar = null;
        if (intent.a()) {
            com.tencent.aio.api.runtime.a aVar2 = this.mContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                aVar = aVar2;
            }
            aVar.e().h(new InputEditTextMsgIntent.ShowKeyboardMsgIntent(0L));
            return;
        }
        com.tencent.aio.api.runtime.a aVar3 = this.mContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            aVar = aVar3;
        }
        aVar.e().h(new PanelContainerMsgIntent.ShowPanelMsgIntent("InputSimpleUIVMDelegate", 1006, false, 0, 12, null));
    }

    private final void v(d.g intent) {
        if (this.mIsInFullScreenMode) {
            QLog.e("InputSimpleUIVMDelegate", 1, "[pttBtnClick] in fullscreen input mode now!");
            return;
        }
        boolean z16 = !intent.a();
        if (z16) {
            com.tencent.aio.api.runtime.a aVar = this.mContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                aVar = null;
            }
            aVar.e().h(new PanelContainerMsgIntent.HideAllPanelAndKeyboardMsgIntent("InputSimpleUIVMDelegate", false, 2, null));
        }
        g(z16, true);
    }

    private final void w(boolean newPressToSpeakState) {
        this.mIsPressToSpeakMode = Boolean.valueOf(newPressToSpeakState);
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        aVar.e().h(new InputSimpleUIMsgIntent.OnPressToSpeakModeChange(newPressToSpeakState));
    }

    private final void y(boolean isFullScreenMode) {
        this.mIsInFullScreenMode = isFullScreenMode;
        if (isFullScreenMode) {
            j(this, false, false, 2, null);
        } else {
            K(new InputSimpleUIState.ModeCompatState(false, this.mIsInGagMode, new InputSimpleUIState.ModeCompatState.a(Intrinsics.areEqual(this.mIsPressToSpeakMode, Boolean.TRUE), false, 2, null)));
        }
        Boolean bool = this.mUpdateSimpleUIHintWhenExitFullScreenMode;
        if (bool != null) {
            Intrinsics.checkNotNull(bool);
            boolean booleanValue = bool.booleanValue();
            this.mIsInSimpleUIMode = booleanValue;
            this.mUpdateSimpleUIHintWhenExitFullScreenMode = null;
            K(new InputSimpleUIState.UpdateSimpleUIState(booleanValue));
        }
    }

    private final void z() {
        e.a aVar;
        boolean z16;
        com.tencent.aio.api.runtime.a aVar2 = this.mContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar2 = null;
        }
        k k3 = aVar2.e().k(FullScreenMsgIntent.GetFullScreenMode.f189578d);
        if (k3 instanceof e.a) {
            aVar = (e.a) k3;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            z16 = aVar.a();
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.i("InputSimpleUIVMDelegate", 1, "[onInputChange]: is full screen mode now");
        } else {
            K(new InputSimpleUIState.UpdateFunBtnState(false, 1, null));
        }
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull com.tencent.mobileqq.aio.input.adorn.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
        } else {
            Intrinsics.checkNotNullParameter(cVar, "<set-?>");
            this.mHost = cVar;
        }
    }

    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public void K(@NotNull InputUIState inputUIState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) inputUIState);
        } else {
            e.a.b(this, inputUIState);
        }
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull at.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar);
        } else {
            e.a.a(this, aVar);
        }
    }

    @Override // com.tencent.input.base.mvicompat.e
    @NotNull
    public Class<? extends at.a> d0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Class) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return com.tencent.mobileqq.aio.input.simpleui.d.class;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Set) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.ThemeEvent.PostThemeChanged");
        hashSet.add("com.tencent.mobileqq.aio.event.LifeCycleEvent.OnPause");
        hashSet.add("com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent.OnFullScreenModeChanged");
        hashSet.add("com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent.EditTextChangedMsgIntent");
        hashSet.add("com.tencent.input.base.panelcontainer.PanelContainerMsgIntent.OnPanelStateChangedMsgIntent");
        hashSet.add("com.tencent.input.base.panelcontainer.keyboard.KeyboardMsgIntent.OnKeyboardStateChanged");
        hashSet.add("com.tencent.qqnt.pluspanel.data.msg.PlusPanelEvent.FetchPlusPanelAppList");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgSendEvent.MsgOnClickReplyEvent");
        hashSet.add("com.tencent.input.base.panelcontainer.PanelContainerMsgIntent.ShowPanelMsgIntent");
        hashSet.add("com.tencent.mobileqq.aio.input.gag.InputGagMsgIntent.OnInputGagModeChanged");
        hashSet.add("com.tencent.qqnt.emotion.data.msg.EmotionPanelEvent.FetchEmotionRedDot");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Set) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.InputSimpleEventIntent.OnGetEmoIconViewIntent");
        hashSet.add("com.tencent.mobileqq.aio.event.InputSimpleEventIntent.OnGetShortCutLayoutViewIntent");
        return hashSet;
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.aio.input.adorn.c getMHost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.input.adorn.c) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mHost;
    }

    @Override // com.tencent.input.base.mvicompat.f
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        aVar.e().i(this, this.mAction);
        com.tencent.aio.api.runtime.a aVar2 = this.mContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar2 = null;
        }
        aVar2.e().e(this);
        this.mIsPanelShow = false;
        this.mIsPressToSpeakMode = null;
        this.mIsInGagMode = false;
        this.mPanelId = 0;
    }

    @Override // com.tencent.input.base.mvicompat.e
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void J(@NotNull at.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        com.tencent.aio.api.runtime.a aVar = null;
        if (intent instanceof d.c) {
            F(this, false, 1, null);
            return;
        }
        if (intent instanceof d.g) {
            v((d.g) intent);
            return;
        }
        if (intent instanceof d.C7287d) {
            t((d.C7287d) intent);
            return;
        }
        if (intent instanceof d.e) {
            u((d.e) intent);
            return;
        }
        if (intent instanceof d.b) {
            com.tencent.aio.api.runtime.a aVar2 = this.mContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                aVar = aVar2;
            }
            AIOContact c16 = aVar.g().r().c();
            d.b bVar = (d.b) intent;
            bVar.c(c16.e());
            bVar.d(c16.j());
            return;
        }
        if (intent instanceof d.i) {
            com.tencent.aio.api.runtime.a aVar3 = this.mContext;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                aVar = aVar3;
            }
            aVar.e().h(new AIOReserve1CreateModelIntent("fast_image", AIOFastImageMsgIntent.QueryFastImageIntent.f193262d));
            return;
        }
        if (intent instanceof d.h) {
            com.tencent.aio.api.runtime.a aVar4 = this.mContext;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                aVar = aVar4;
            }
            aVar.e().h(new AIOReserve1CreateModelIntent("fast_image", AIOFastImageMsgIntent.RemoveFastImageIntent.f193263d));
            return;
        }
        if (intent instanceof d.a) {
            o((d.a) intent);
        } else if (intent instanceof d.f) {
            w(((d.f) intent).a());
        }
    }

    @Override // com.tencent.input.base.mvicompat.f
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void b(@NotNull com.tencent.aio.api.runtime.a context, boolean reuse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, Boolean.valueOf(reuse));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = context;
        com.tencent.aio.api.runtime.a aVar = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        context.e().f(this, this.mAction);
        com.tencent.aio.api.runtime.a aVar2 = this.mContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            aVar = aVar2;
        }
        aVar.e().l(this, this.mActionR);
    }
}
