package com.tencent.qqnt.pluspanel.logic;

import android.content.Context;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.aio.data.AIOSession;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.aio.event.AnonymousChatEvent;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOJumpAction;
import com.tencent.qqnt.aio.api.IAIOContactApi;
import com.tencent.qqnt.kernel.api.IUixConvertAdapterApi;
import com.tencent.qqnt.kernel.nativeinterface.GroupAnonymousInfo;
import com.tencent.qqnt.pluspanel.data.PlusPanelUiState;
import com.tencent.qqnt.pluspanel.data.e;
import com.tencent.qqnt.pluspanel.data.msg.PlusPanelEvent;
import com.tencent.qqnt.pluspanel.processor.AudioCallOnClickProcessor;
import com.tencent.qqnt.pluspanel.processor.BusinessCardOnClickProcessor;
import com.tencent.qqnt.pluspanel.processor.CommonWebOnClickProcessor;
import com.tencent.qqnt.pluspanel.processor.FavoriteOnClickProcessor;
import com.tencent.qqnt.pluspanel.processor.FileOnClickProcessor;
import com.tencent.qqnt.pluspanel.processor.GiftOnClickProcessor;
import com.tencent.qqnt.pluspanel.processor.GroupPublicClassOnClickProcessor;
import com.tencent.qqnt.pluspanel.processor.GroupVideoChatOnClickProcessor;
import com.tencent.qqnt.pluspanel.processor.ListenTogetherOnClickProcessor;
import com.tencent.qqnt.pluspanel.processor.PictureOnClickProcessor;
import com.tencent.qqnt.pluspanel.processor.PlayTogetherOnClickProcessor;
import com.tencent.qqnt.pluspanel.processor.RobotPttOnClickProcessor;
import com.tencent.qqnt.pluspanel.processor.ShareScreenOnClickProcessor;
import com.tencent.qqnt.pluspanel.processor.TencentDocsOnClickProcessor;
import com.tencent.qqnt.pluspanel.processor.TroopVoteOnClickProcessor;
import com.tencent.qqnt.pluspanel.processor.VideoCallOnClickProcessor;
import com.tencent.qqnt.pluspanel.processor.ac;
import com.tencent.qqnt.pluspanel.processor.ae;
import com.tencent.qqnt.pluspanel.processor.af;
import com.tencent.qqnt.pluspanel.processor.j;
import com.tencent.qqnt.pluspanel.processor.k;
import com.tencent.qqnt.pluspanel.processor.l;
import com.tencent.qqnt.pluspanel.processor.o;
import com.tencent.qqnt.pluspanel.processor.p;
import com.tencent.qqnt.pluspanel.processor.r;
import com.tencent.qqnt.pluspanel.processor.s;
import com.tencent.qqnt.pluspanel.processor.t;
import com.tencent.qqnt.pluspanel.processor.u;
import com.tencent.qqnt.pluspanel.processor.v;
import com.tencent.robot.aio.pluspanel.processor.RobotPictureOnClickProcessor;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0083\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u00016\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001@B\u0007\u00a2\u0006\u0004\b>\u0010?J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u0012H\u0002J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0012H\u0002J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0012H\u0002J \u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0012H\u0002J\u0016\u0010%\u001a\u00020\u00042\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\n0#H\u0002J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&H\u0016J\b\u0010)\u001a\u00020\u0004H\u0007J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0002H\u0016J\b\u0010+\u001a\u00020\u0004H\u0016R2\u00101\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020-0,j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020-`.8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R(\u0010=\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u0002060:0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<\u00a8\u0006A"}, d2 = {"Lcom/tencent/qqnt/pluspanel/logic/e;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lcom/tencent/qqnt/pluspanel/data/e;", "Lcom/tencent/qqnt/pluspanel/data/PlusPanelUiState;", "", HippyTKDListViewAdapter.X, "p", "D", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/qqnt/pluspanel/data/a;", "appData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "o", "u", "v", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "t", "r", "", "appId", "url", "B", BdhLogUtil.LogTag.Tag_Conn, "origUrl", "Lcom/tencent/aio/data/AIOSession;", "sessionInfo", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "E", "redDotId", DomainData.DOMAIN_NAME, "", "appDataByPage", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", "y", "w", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Ljava/util/HashMap;", "Lcom/tencent/qqnt/pluspanel/logic/b;", "Lkotlin/collections/HashMap;", "e", "Ljava/util/HashMap;", "onClickProcessor", "Lcom/tencent/qqnt/pluspanel/data/repository/c;", "f", "Lcom/tencent/qqnt/pluspanel/data/repository/c;", "mRepository", "com/tencent/qqnt/pluspanel/logic/e$b", h.F, "Lcom/tencent/qqnt/pluspanel/logic/e$b;", "mAction", "Lkotlin/Pair;", "i", "Ljava/util/List;", "mMsgList", "<init>", "()V", "a", "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class e extends com.tencent.qqnt.aio.baseVM.a<com.tencent.qqnt.pluspanel.data.e, PlusPanelUiState> {
    static IPatchRedirector $redirector_;
    private static HashMap C;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @QAutoInject(configPath = "AutoInjectYml/Business/PlusPanel/Inject_OnClickProcessor.yml", version = 1)
    @NotNull
    private HashMap<String, com.tencent.qqnt.pluspanel.logic.b> onClickProcessor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.qqnt.pluspanel.data.repository.c mRepository;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Pair<String, b>> mMsgList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/pluspanel/logic/e$a;", "", "", "RED_POINT_COMMON_CLICK_REPORT", "I", "RED_POINT_COMMON_EXPOSE_REPORT", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.pluspanel.logic.e$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/pluspanel/logic/e$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                e.this.E(i3);
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44327);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        HashMap hashMap = new HashMap();
        C = hashMap;
        hashMap.put("1300000005", com.tencent.robot.aio.pluspanel.processor.a.class);
        C.put("1300000004", RobotPictureOnClickProcessor.class);
        C.put("102686667", p.class);
        C.put("1200000012", af.class);
        C.put("1106551782", CommonWebOnClickProcessor.class);
        C.put("100729587", CommonWebOnClickProcessor.class);
        C.put("102007304", CommonWebOnClickProcessor.class);
        C.put("1200000005", com.tencent.qqnt.pluspanel.processor.e.class);
        C.put("1200000004", com.tencent.qqnt.pluspanel.processor.h.class);
        C.put("1101487426", com.tencent.qqnt.pluspanel.processor.d.class);
        C.put("1200000006", GiftOnClickProcessor.class);
        C.put("101846357", j.class);
        C.put("1104536706", TroopVoteOnClickProcessor.class);
        C.put("1104864062", s.class);
        C.put("101847385", GroupPublicClassOnClickProcessor.class);
        C.put("100719166", GroupVideoChatOnClickProcessor.class);
        C.put("101458937", TencentDocsOnClickProcessor.class);
        C.put("1104788679", BusinessCardOnClickProcessor.class);
        C.put("1108481457", CommonWebOnClickProcessor.class);
        C.put("101850591", ShareScreenOnClickProcessor.class);
        C.put("101761547", ListenTogetherOnClickProcessor.class);
        C.put("1104639410", FavoriteOnClickProcessor.class);
        C.put("1104864068", o.class);
        C.put("1104874204", GiftOnClickProcessor.class);
        C.put("1104864066", FileOnClickProcessor.class);
        C.put("1107930043", k.class);
        C.put("1106658188", VideoCallOnClickProcessor.class);
        C.put("1104651886", AudioCallOnClickProcessor.class);
        C.put("1200000003", ac.class);
        C.put("1104864054", PictureOnClickProcessor.class);
        C.put("102078357", u.class);
        C.put("1300000003", t.class);
        C.put("1300000002", x24.a.class);
        C.put("1300000001", RobotPttOnClickProcessor.class);
        C.put("102115711", m20.a.class);
        C.put("220", l.class);
        C.put("219", s.class);
        C.put("218", ac.class);
        C.put("217", PictureOnClickProcessor.class);
        C.put(ThemeReporter.FROM_DIR_COVER, TencentDocsOnClickProcessor.class);
        C.put(ThemeReporter.FROM_NIGHT_ROAMING, GiftOnClickProcessor.class);
        C.put(ThemeReporter.FROM_SIMPLE_INIT, BusinessCardOnClickProcessor.class);
        C.put(ThemeReporter.FROM_SIMPLE, ae.class);
        C.put(ThemeReporter.FROM_PUSH, PlayTogetherOnClickProcessor.class);
        C.put(ThemeReporter.FROM_UPDATE, FavoriteOnClickProcessor.class);
        C.put("221", ShareScreenOnClickProcessor.class);
        C.put(ThemeReporter.FROM_SERVER_SET_THEME, ListenTogetherOnClickProcessor.class);
        C.put(ThemeReporter.FROM_INIT_THEME, FileOnClickProcessor.class);
        C.put(ThemeReporter.FROM_ENGINE, o.class);
        C.put(ThemeReporter.FROM_AUTH, k.class);
        C.put(ThemeReporter.FROM_WEEKLOOP, r.class);
        C.put(ThemeReporter.FROM_NIGHT, VideoCallOnClickProcessor.class);
        C.put(ThemeReporter.FROM_DIY, AudioCallOnClickProcessor.class);
        C.put("1000000000", v.class);
        INSTANCE = new Companion(null);
    }

    public e() {
        List<Pair<String, b>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.onClickProcessor = new HashMap<>();
        b bVar = new b();
        this.mAction = bVar;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(Reflection.getOrCreateKotlinClass(AnonymousChatEvent.SwitchAnonymousChatEvent.class).getQualifiedName(), bVar), new Pair(Reflection.getOrCreateKotlinClass(PlusPanelEvent.UpdatePlusPanel.class).getQualifiedName(), bVar)});
        this.mMsgList = listOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void A(com.tencent.qqnt.pluspanel.data.a appData) {
        n(String.valueOf(appData.g()));
        com.tencent.qqnt.pluspanel.logic.b bVar = this.onClickProcessor.get(String.valueOf(appData.c()));
        if (bVar != null) {
            bVar.a(appData, (com.tencent.aio.api.runtime.a) getMContext());
        } else {
            o(appData);
        }
    }

    private final boolean B(int appId, String url) {
        String replace$default;
        String replace$default2;
        String replace$default3;
        if (TextUtils.isEmpty(url)) {
            QLog.i("PlusPanelVM", 1, "[openMiniApp] url is empty, appId=" + appId);
            return false;
        }
        IAIOJumpAction iAIOJumpAction = (IAIOJumpAction) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOJumpAction.class);
        if (iAIOJumpAction.isMiniAppUrl(url)) {
            replace$default = StringsKt__StringsJVMKt.replace$default(url, "$UIN$", t(), false, 4, (Object) null);
            replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "$GCODE$", r(), false, 4, (Object) null);
            replace$default3 = StringsKt__StringsJVMKt.replace$default(replace$default2, "$APPID$", String.valueOf(appId), false, 4, (Object) null);
            QLog.i("PlusPanelVM", 1, "[openMiniApp] open mini app, appId=" + appId + " url=" + url);
            return iAIOJumpAction.openMiniApp(q(), replace$default3);
        }
        QLog.i("PlusPanelVM", 1, "[openMiniApp] invalid url, appId=" + appId + " url=" + url);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean C(int appId, String url) {
        if (TextUtils.isEmpty(url)) {
            QLog.i("PlusPanelVM", 1, "[openWebView] empty url, appId=" + appId);
            return false;
        }
        String s16 = s(appId, url, ((com.tencent.aio.api.runtime.a) getMContext()).g().r());
        try {
            if (TextUtils.equals(new URI(s16).getScheme(), SchemaUtils.SCHEMA_MQQAPI)) {
                if (((IAIOJumpAction) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOJumpAction.class)).doUrlAction(q(), s16)) {
                    return true;
                }
                QLog.i("PlusPanelVM", 1, "[openWebView] failed to open as mqqapi, appId=" + appId + " url=" + s16);
                return false;
            }
        } catch (URISyntaxException e16) {
            QLog.i("PlusPanelVM", 1, "[openWebView] exc=" + e16);
        }
        ((IAIOJumpAction) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOJumpAction.class)).openBrowser(q(), s16);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void D() {
        Context context = ((com.tencent.aio.api.runtime.a) getMContext()).c().getContext();
        if (context == null) {
            context = MobileQQ.sMobileQQ;
        }
        com.tencent.qqnt.pluspanel.data.repository.c cVar = this.mRepository;
        Integer num = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRepository");
            cVar = null;
        }
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ArrayList<com.tencent.qqnt.pluspanel.data.a> a16 = cVar.a(context);
        if (QLog.isColorLevel()) {
            if (a16 != null) {
                num = Integer.valueOf(a16.size());
            }
            QLog.i("PlusPanelVM", 1, "update: appList.size = " + num);
        }
        if (!a16.isEmpty()) {
            updateUI(new PlusPanelUiState.FetchCompleted(a16, z()));
        } else {
            updateUI(new PlusPanelUiState.FetchFailed("empty list"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent intent) {
        if (intent instanceof AnonymousChatEvent.SwitchAnonymousChatEvent) {
            if (QLog.isColorLevel()) {
                QLog.i("PlusPanelVM", 2, "intent: " + ((AnonymousChatEvent.SwitchAnonymousChatEvent) intent).a());
            }
            AnonymousChatEvent.SwitchAnonymousChatEvent switchAnonymousChatEvent = (AnonymousChatEvent.SwitchAnonymousChatEvent) intent;
            if (switchAnonymousChatEvent.a() == null) {
                return;
            }
            GroupAnonymousInfo a16 = switchAnonymousChatEvent.a();
            Intrinsics.checkNotNull(a16);
            updateUI(new PlusPanelUiState.UpdateAnonymousPanel(a16.isAnonymousChat));
            return;
        }
        if (intent instanceof PlusPanelEvent.UpdatePlusPanel) {
            if (QLog.isColorLevel()) {
                QLog.i("PlusPanelVM", 2, "handleAction UpdatePlusPanel");
            }
            D();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void m(List<com.tencent.qqnt.pluspanel.data.a> appDataByPage) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.i("PlusPanelVM", 2, "dealPageExpose size: " + appDataByPage.size());
        }
        String j3 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j();
        int e16 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e();
        for (com.tencent.qqnt.pluspanel.data.a aVar : appDataByPage) {
            String g16 = aVar.g();
            if (g16 != null && g16.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                com.tencent.qqnt.aio.utils.ae.f352281b.a(30, j3, e16, String.valueOf(aVar.g()));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void n(String redDotId) {
        if (QLog.isColorLevel()) {
            QLog.i("PlusPanelVM", 2, "dealRedDotClick redDotId: " + redDotId);
        }
        com.tencent.qqnt.aio.utils.ae.f352281b.a(31, ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e(), redDotId);
    }

    private final void o(com.tencent.qqnt.pluspanel.data.a appData) {
        if (!TextUtils.isEmpty(appData.b()) && !TextUtils.isEmpty(appData.a())) {
            u(appData);
            return;
        }
        if (!TextUtils.isEmpty(appData.k())) {
            v(appData);
            return;
        }
        QLog.w("PlusPanelVM", 1, "[doDefaultAction] app data could not be handled, appId=" + appData.c());
    }

    private final void p() {
        HashMap<String, com.tencent.qqnt.pluspanel.logic.b> hashMap = this.onClickProcessor;
        if (hashMap == null || hashMap.isEmpty()) {
            y();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Context q() {
        Context requireContext = ((com.tencent.aio.api.runtime.a) getMContext()).c().requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "this.mContext.fragment.requireContext()");
        return requireContext;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String r() {
        try {
            return String.valueOf(((IUixConvertAdapterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IUixConvertAdapterApi.class)).getUinFromUid(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j()));
        } catch (Exception e16) {
            QLog.i("PlusPanelVM", 1, "[getFriendUin] exc=" + e16);
            return "0";
        }
    }

    private final String s(int appId, String origUrl, AIOSession sessionInfo) {
        String replace$default;
        String replace$default2;
        String replace$default3;
        String replace$default4;
        if (!TextUtils.isEmpty(origUrl)) {
            replace$default = StringsKt__StringsJVMKt.replace$default(origUrl, "$UIN$", t(), false, 4, (Object) null);
            replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "$GCODE$", r(), false, 4, (Object) null);
            replace$default3 = StringsKt__StringsJVMKt.replace$default(replace$default2, "$APPID$", String.valueOf(appId), false, 4, (Object) null);
            if (com.tencent.qqnt.pluspanel.utils.a.INSTANCE.H() != appId) {
                return replace$default3;
            }
            int e16 = sessionInfo.c().e();
            int i3 = 1;
            if (e16 != 1) {
                i3 = 2;
                if (e16 != 2 && e16 != 3) {
                    i3 = 0;
                }
            }
            replace$default4 = StringsKt__StringsJVMKt.replace$default(replace$default3, "$GTYPE$", String.valueOf(i3), false, 4, (Object) null);
            return replace$default4;
        }
        return origUrl;
    }

    private final String t() {
        String currentUin = MobileQQ.sMobileQQ.waitAppRuntime().getCurrentUin();
        Intrinsics.checkNotNullExpressionValue(currentUin, "sMobileQQ.waitAppRuntime().currentUin");
        return currentUin;
    }

    private final void u(com.tencent.qqnt.pluspanel.data.a appData) {
        if (!TextUtils.isEmpty(appData.b()) && !TextUtils.isEmpty(appData.a())) {
            if (Intrinsics.areEqual("miniapp", appData.b())) {
                int c16 = appData.c();
                String a16 = appData.a();
                Intrinsics.checkNotNull(a16);
                if (!B(c16, a16)) {
                    QLog.w("PlusPanelVM", 1, "[doDefaultAction] invalid mini app action, appId=" + appData.c() + " actionType=" + appData.b() + " action=" + appData.a());
                    return;
                }
                return;
            }
            if (Intrinsics.areEqual("web", appData.b())) {
                int c17 = appData.c();
                String a17 = appData.a();
                Intrinsics.checkNotNull(a17);
                if (!C(c17, a17)) {
                    QLog.w("PlusPanelVM", 1, "[doDefaultAction] invalid web action, appId=" + appData.c() + " actionType=" + appData.b() + " action=" + appData.a());
                    return;
                }
                return;
            }
            QLog.w("PlusPanelVM", 1, "[doDefaultAction] action could not be handled, appId=" + appData.c() + " actionType=" + appData.b() + " action=" + appData.a());
            return;
        }
        QLog.w("PlusPanelVM", 1, "[doDefaultAction] invalid action, appId=" + appData.c() + " actionType=" + appData.b() + " action=" + appData.a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void v(com.tencent.qqnt.pluspanel.data.a appData) {
        try {
            Object newInstance = Class.forName("com.tencent.qqnt.pluspanel.processor.CommonWebOnClickProcessor").newInstance();
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.qqnt.pluspanel.logic.IOnClickProcessor");
            ((com.tencent.qqnt.pluspanel.logic.b) newInstance).a(appData, (com.tencent.aio.api.runtime.a) getMContext());
            QLog.i("PlusPanelVM", 1, "[handleAppUrlByCommonProcessor] on click, appId=" + appData.c() + " url=" + appData.k());
        } catch (Exception e16) {
            QLog.i("PlusPanelVM", 1, "[handleAppUrlByCommonProcessor] exception is " + e16 + ", appId=" + appData.c() + " url=" + appData.k());
            if (com.tencent.qqnt.util.b.f362976b.isPublicVersion()) {
            } else {
                throw e16;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void x() {
        AIOSession r16 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r();
        com.tencent.qqnt.pluspanel.data.repository.c cVar = new com.tencent.qqnt.pluspanel.data.repository.c(r16.c().j(), r16.c().e());
        this.mRepository = cVar;
        cVar.c();
        p();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean z() {
        return ((IAIOContactApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOContactApi.class)).isRobot(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onDestroy();
        Iterator<T> it = this.mMsgList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().b((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.qqnt.pluspanel.data.e intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof e.a) {
            x();
            if (QLog.isColorLevel()) {
                QLog.i("PlusPanelVM", 1, "handleIntent FetchDataIntent");
            }
            D();
            return;
        }
        if (intent instanceof e.b) {
            A(((e.b) intent).a());
            return;
        }
        if (intent instanceof e.d) {
            x();
            if (QLog.isColorLevel()) {
                QLog.i("PlusPanelVM", 1, "handleIntent ReloadPanel");
            }
            D();
            return;
        }
        if (intent instanceof e.c) {
            m(((e.c) intent).a());
        }
    }

    @QAutoInitMethod
    public final void y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            com.tencent.mobileqq.qroute.utils.b.b(C, this.onClickProcessor);
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
        Iterator<T> it = this.mMsgList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().d((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
    }
}
