package com.tencent.ams.dynamicwidget;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.core.mosaic.DKMosaicEngine;
import com.tencent.ams.dsdk.event.DKMethodHandler;
import com.tencent.ams.dsdk.fodder.TemplateManager;
import com.tencent.ams.dsdk.utils.DynamicUtils;
import com.tencent.ams.dynamicwidget.BaseDynamicView;
import com.tencent.ams.dynamicwidget.d;
import com.tencent.ams.dynamicwidget.data.AdInfo;
import com.tencent.ams.dynamicwidget.landingpage.DefaultLandingPageView;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.hippo.quickjs.android.JSValue;
import com.tencent.ams.mosaic.i;
import com.tencent.ams.mosaic.jsengine.a;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b'\u0018\u0000 m2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u00029:J\b\u0010\u0006\u001a\u00020\u0005H\u0002J&\u0010\f\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0012\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\u0006\u0010\u0016\u001a\u00020\u0005J\b\u0010\u0017\u001a\u00020\u0005H\u0014J\u0010\u0010\u001a\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\b\u0010\u001b\u001a\u00020\u0005H\u0014J\b\u0010\u001c\u001a\u00020\u0007H\u0016J5\u0010%\u001a\u00020$2\f\u0010\u001e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00072\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0096\u0002J$\u0010)\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\"2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020'0&J \u0010,\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u0007J\u001c\u0010/\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010\u00072\b\u0010#\u001a\u0004\u0018\u00010.H\u0016J\u0012\u00100\u001a\u00020$2\b\u0010-\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u00102\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u000eH\u0016J!\u00105\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u000e2\b\u00104\u001a\u0004\u0018\u000103H\u0016\u00a2\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b7\u00108J\u001c\u00109\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J&\u0010:\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0016R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010A\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010@R\u0018\u0010C\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010BR\u0014\u0010E\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010DR\u0016\u0010H\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010K\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR*\u0010M\u001a\u00020$2\u0006\u0010L\u001a\u00020$8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010G\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001b\u0010T\u001a\u00020\u000e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010Q\u001a\u0004\bR\u0010SR\"\u0010W\u001a\u00020$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010G\u001a\u0004\bU\u0010N\"\u0004\bV\u0010PR\u0014\u0010[\u001a\u00020X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010^\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010`\u001a\u0004\u0018\u00010\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b_\u0010BR\u0016\u0010d\u001a\u0004\u0018\u00010a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0014\u0010h\u001a\u00020e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0017\u0010l\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\bi\u0010D\u001a\u0004\bj\u0010k\u00a8\u0006n"}, d2 = {"Lcom/tencent/ams/dynamicwidget/BaseDynamicView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/ams/mosaic/i;", "Lcom/tencent/ams/dsdk/event/DKMethodHandler;", "Lcom/tencent/ams/dynamicwidget/e;", "", "D", "", "moduleId", "Lcom/tencent/ams/dynamicwidget/data/AdInfo;", "ad", "errorMsg", "w", "E", "", "exposureArea", "e", "Lcom/tencent/ams/mosaic/g;", "event", "onEvent", "f", h.F, "t", NodeProps.ON_ATTACHED_TO_WINDOW, "Landroid/view/View;", "view", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, NodeProps.ON_DETACHED_FROM_WINDOW, "getModuleId", "Lcom/tencent/ams/dsdk/core/DKEngine;", "dkEngine", "methodName", "Lorg/json/JSONObject;", "params", "Lcom/tencent/ams/dsdk/event/DKMethodHandler$Callback;", "callback", "", "invoke", "", "", "resultMap", BdhLogUtil.LogTag.Tag_Conn, "errorCode", "message", "B", "templateId", "Lcom/tencent/ams/dynamicwidget/BaseDynamicView$b;", "r", ReportConstant.COSTREPORT_PREFIX, "eventId", "u", "", "timeCost", "v", "(ILjava/lang/Long;)V", "y", "()Ljava/lang/Integer;", "a", "b", "Lcom/tencent/ams/dsdk/core/mosaic/DKMosaicEngine;", "d", "Lcom/tencent/ams/dsdk/core/mosaic/DKMosaicEngine;", "dynamicEngine", "Lcom/tencent/ams/mosaic/h;", "Lcom/tencent/ams/mosaic/h;", "mosaicEventCenter", "Lcom/tencent/ams/dsdk/event/DKMethodHandler;", "commonMethodHandler", "Ljava/lang/String;", "hashCode", "i", "Z", "isViewAttached", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "realView", "value", "isDarkMode", "()Z", "setDarkMode", "(Z)V", "Lkotlin/Lazy;", HippyTKDListViewAdapter.X, "()I", "chid", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "setRenderSuccess", "isRenderSuccess", "Landroid/os/Handler;", UserInfo.SEX_FEMALE, "Landroid/os/Handler;", "mHandler", "G", "Lcom/tencent/ams/dynamicwidget/data/AdInfo;", "adInfo", "H", "methodHandler", "Lcom/tencent/ams/dynamicwidget/d$a;", "I", "Lcom/tencent/ams/dynamicwidget/d$a;", "eventListener", "Lcom/tencent/ams/dynamicwidget/f;", "J", "Lcom/tencent/ams/dynamicwidget/f;", "engineHelper", "K", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Ljava/lang/String;", "tag", "L", "lib_release"}, k = 1, mv = {1, 4, 0})
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public abstract class BaseDynamicView extends FrameLayout implements i, DKMethodHandler, e {
    static IPatchRedirector $redirector_;

    /* renamed from: L, reason: from kotlin metadata */
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isDarkMode;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy chid;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isRenderSuccess;

    /* renamed from: F, reason: from kotlin metadata */
    private final Handler mHandler;

    /* renamed from: G, reason: from kotlin metadata */
    private final AdInfo adInfo;

    /* renamed from: H, reason: from kotlin metadata */
    private final DKMethodHandler methodHandler;

    /* renamed from: I, reason: from kotlin metadata */
    private final d.a eventListener;

    /* renamed from: J, reason: from kotlin metadata */
    private final f engineHelper;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final String tag;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private DKMosaicEngine dynamicEngine;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.ams.mosaic.h mosaicEventCenter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private DKMethodHandler commonMethodHandler;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final String hashCode;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isViewAttached;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View realView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ams/dynamicwidget/BaseDynamicView$a;", "", "", "CREATE_VIEW_ERROR_INVALID_ORDER_INFO", "I", "RENDER_TIMEOUT", "<init>", "()V", "lib_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.ams.dynamicwidget.BaseDynamicView$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/ams/dynamicwidget/BaseDynamicView$b;", "", "", "result", "", "onFinish", "lib_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public interface b {
        void onFinish(boolean result);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"com/tencent/ams/dynamicwidget/BaseDynamicView$invoke$1$1", "Lcom/tencent/ams/dynamicwidget/BaseDynamicView$b;", "", "result", "", "onFinish", "lib_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class c implements b {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ DKMethodHandler.Callback f70132b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map f70133c;

        c(DKMethodHandler.Callback callback, Map map) {
            this.f70132b = callback;
            this.f70133c = map;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, BaseDynamicView.this, callback, map);
            }
        }

        @Override // com.tencent.ams.dynamicwidget.BaseDynamicView.b
        public void onFinish(boolean result) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, result);
            } else if (result) {
                BaseDynamicView.this.C(this.f70132b, this.f70133c);
            } else {
                BaseDynamicView.this.B(this.f70132b, -3, "delete template failed");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ams/dynamicwidget/BaseDynamicView$d", "Lcom/tencent/ams/mosaic/jsengine/a$b;", "Lcom/tencent/ams/hippo/quickjs/android/JSFunction;", "p0", "Lcom/tencent/ams/hippo/quickjs/android/JSValue;", "p1", "", "onSuccess", "onFail", "lib_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class d implements a.b {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) BaseDynamicView.this);
            }
        }

        @Override // com.tencent.ams.mosaic.jsengine.a.b
        public void onFail(@Nullable JSFunction p06) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) p06);
            } else {
                com.tencent.ams.dynamicwidget.utils.b.f70218a.c(BaseDynamicView.this.z(), "call onThemeChanged failure");
            }
        }

        @Override // com.tencent.ams.mosaic.jsengine.a.b
        public void onSuccess(@Nullable JSFunction p06, @Nullable JSValue p16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) p06, (Object) p16);
            } else {
                com.tencent.ams.dynamicwidget.utils.b.f70218a.c(BaseDynamicView.this.z(), "call onThemeChanged success");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14903);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 40)) {
            redirector.redirect((short) 40);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    private final void D() {
        com.tencent.ams.dynamicwidget.utils.b.f70218a.c(this.tag, "removeTimeoutMessage");
        this.mHandler.removeMessages(1001);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E() {
        com.tencent.ams.mosaic.jsengine.a jsEngine;
        View view = this.realView;
        if (view instanceof DefaultLandingPageView) {
            if (view != null) {
                ((DefaultLandingPageView) view).setDarkMode(this.isDarkMode);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.tencent.ams.dynamicwidget.landingpage.DefaultLandingPageView");
        }
        DKMosaicEngine dKMosaicEngine = this.dynamicEngine;
        if (dKMosaicEngine != null && (jsEngine = dKMosaicEngine.getJsEngine()) != null) {
            jsEngine.n("onThemeChanged", new Boolean[]{Boolean.valueOf(this.isDarkMode)}, new d());
        }
    }

    private final void w(String moduleId, AdInfo ad5, String errorMsg) {
        com.tencent.ams.dynamicwidget.utils.b.f70218a.c(this.tag, '[' + this.hashCode + "] fireJsRuntimeError, moduleId: " + moduleId + ", errorMsg: " + errorMsg);
        if (!this.isRenderSuccess) {
            D();
        }
        b(moduleId, ad5, errorMsg);
    }

    public final boolean A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.isRenderSuccess;
    }

    public final void B(@Nullable DKMethodHandler.Callback callback, int errorCode, @NotNull String message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, callback, Integer.valueOf(errorCode), message);
            return;
        }
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (callback != null) {
            callback.onFailure(errorCode, message);
        }
        com.tencent.ams.dynamicwidget.utils.b.f70218a.d(this.tag, "js invoke failed  errorCode:" + errorCode + ", message: " + message);
    }

    public final void C(@Nullable DKMethodHandler.Callback callback, @NotNull Map<String, ? extends Object> resultMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) callback, (Object) resultMap);
            return;
        }
        Intrinsics.checkParameterIsNotNull(resultMap, "resultMap");
        if (callback != null) {
            callback.onResult(resultMap);
        }
        com.tencent.ams.dynamicwidget.utils.b.f70218a.c(this.tag, "js invoke success  resultMap:" + resultMap);
    }

    @Override // com.tencent.ams.dynamicwidget.e
    public void a(@Nullable String moduleId, @Nullable AdInfo ad5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) moduleId, (Object) ad5);
            return;
        }
        d.a aVar = this.eventListener;
        if (aVar != null) {
            aVar.a(moduleId, ad5);
        }
        com.tencent.ams.dynamicwidget.d.f70187b.g(moduleId, ad5);
    }

    @Override // com.tencent.ams.dynamicwidget.e
    public void b(@Nullable String moduleId, @Nullable AdInfo ad5, @Nullable String errorMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, moduleId, ad5, errorMsg);
            return;
        }
        d.a aVar = this.eventListener;
        if (aVar != null) {
            aVar.b(moduleId, ad5, errorMsg);
        }
        com.tencent.ams.dynamicwidget.d.f70187b.f(moduleId, ad5, errorMsg);
    }

    @Override // com.tencent.ams.dynamicwidget.e
    public void e(int exposureArea) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, exposureArea);
            return;
        }
        com.tencent.ams.dynamicwidget.utils.b.f70218a.c(this.tag, '[' + this.hashCode + "] onOriginalExposure, exposureArea:" + exposureArea);
    }

    @Override // com.tencent.ams.dynamicwidget.e
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        }
    }

    @Override // com.tencent.ams.dsdk.event.DKMethodHandler
    @NotNull
    public String getModuleId() {
        String moduleId;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        DKMethodHandler dKMethodHandler = this.methodHandler;
        if (dKMethodHandler == null || (moduleId = dKMethodHandler.getModuleId()) == null) {
            return "";
        }
        return moduleId;
    }

    @Override // com.tencent.ams.dynamicwidget.e
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        }
    }

    @Override // com.tencent.ams.dsdk.event.DKMethodHandler
    public boolean invoke(@Nullable DKEngine<?> dkEngine, @Nullable String methodName, @Nullable JSONObject params, @Nullable DKMethodHandler.Callback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, this, dkEngine, methodName, params, callback)).booleanValue();
        }
        if (TextUtils.isEmpty(methodName)) {
            return false;
        }
        HashMap hashMap = new HashMap();
        if (Intrinsics.areEqual(methodName, "deleteTemplate")) {
            if (params != null) {
                r(params.optString("templateId"), new c(callback, hashMap));
            } else {
                B(callback, -1, "invalid params");
            }
            return true;
        }
        if (Intrinsics.areEqual(methodName, "reportDp3")) {
            if (params != null) {
                HashMap hashMap2 = new HashMap();
                Iterator keys = params.keys();
                Intrinsics.checkExpressionValueIsNotNull(keys, "it.keys()");
                while (keys.hasNext()) {
                    String key = (String) keys.next();
                    Intrinsics.checkExpressionValueIsNotNull(key, "key");
                    String optString = params.optString(key);
                    Intrinsics.checkExpressionValueIsNotNull(optString, "it.optString(key)");
                    hashMap2.put(key, optString);
                }
                g e16 = com.tencent.ams.dynamicwidget.c.f70185s.e();
                if (e16 != null) {
                    e16.a(hashMap2);
                    C(callback, hashMap);
                } else {
                    B(callback, -3, "report dp3 failed");
                }
            } else {
                B(callback, -1, "invalid params");
            }
            return true;
        }
        DKMethodHandler dKMethodHandler = this.methodHandler;
        if (dKMethodHandler == null) {
            return false;
        }
        return dKMethodHandler.invoke(dkEngine, methodName, params, callback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        super.onAttachedToWindow();
        com.tencent.ams.dynamicwidget.utils.b.f70218a.c(this.tag, '[' + this.hashCode + "] onAttachedToWindow");
        this.isViewAttached = true;
        q(this.realView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        super.onDetachedFromWindow();
        com.tencent.ams.dynamicwidget.utils.b.f70218a.c(this.tag, '[' + this.hashCode + "] onDetachedFromWindow");
        throw null;
    }

    @Override // com.tencent.ams.mosaic.i
    public void onEvent(@Nullable com.tencent.ams.mosaic.g event) {
        String a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) event);
            return;
        }
        if (event != null && (a16 = event.a()) != null) {
            switch (a16.hashCode()) {
                case -306313744:
                    if (!a16.equals("onInjectPropFailed")) {
                        return;
                    }
                    break;
                case 1019279067:
                    if (!a16.equals("onCallJsFunctionFailed")) {
                        return;
                    }
                    break;
                case 1128837086:
                    if (!a16.equals("onJsEvaluateFailed")) {
                        return;
                    }
                    break;
                case 1210758280:
                    if (a16.equals("onVideoSwitchToSmallScreen")) {
                        h();
                        return;
                    }
                    return;
                case 1962972407:
                    if (!a16.equals("onJsEngineInitFailed")) {
                        return;
                    }
                    break;
                case 1978731750:
                    if (a16.equals("onVideoSwitchToFullscreen")) {
                        f();
                        return;
                    }
                    return;
                default:
                    return;
            }
            w(this.engineHelper.getModuleId(), this.adInfo, event.b());
        }
    }

    public final void q(@Nullable final View view) {
        ViewParent viewParent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) view);
            return;
        }
        if (view != null) {
            viewParent = view.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent != null) {
            com.tencent.ams.dynamicwidget.utils.b.f70218a.d(this.tag, '[' + this.hashCode + "] attachRealView: attached");
            return;
        }
        DynamicUtils.runOnUiThread(new Runnable(view) { // from class: com.tencent.ams.dynamicwidget.BaseDynamicView$attachRealView$1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ View f70130d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f70130d = view;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) BaseDynamicView.this, (Object) view);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                String str;
                boolean z16;
                String str2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this);
                    return;
                }
                View view2 = this.f70130d;
                if (view2 != null) {
                    BaseDynamicView.this.realView = view2;
                    BaseDynamicView.this.E();
                    z16 = BaseDynamicView.this.isViewAttached;
                    if (z16) {
                        BaseDynamicView.this.addView(view2, new FrameLayout.LayoutParams(-1, -1));
                        com.tencent.ams.dynamicwidget.utils.b bVar = com.tencent.ams.dynamicwidget.utils.b.f70218a;
                        String z17 = BaseDynamicView.this.z();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append('[');
                        str2 = BaseDynamicView.this.hashCode;
                        sb5.append(str2);
                        sb5.append("] attachRealView success");
                        bVar.c(z17, sb5.toString());
                        return;
                    }
                    return;
                }
                BaseDynamicView baseDynamicView = BaseDynamicView.this;
                com.tencent.ams.dynamicwidget.utils.b bVar2 = com.tencent.ams.dynamicwidget.utils.b.f70218a;
                String z18 = baseDynamicView.z();
                StringBuilder sb6 = new StringBuilder();
                sb6.append('[');
                str = baseDynamicView.hashCode;
                sb6.append(str);
                sb6.append("] attachRealView: realView is null");
                bVar2.d(z18, sb6.toString());
            }
        });
    }

    public void r(@Nullable final String templateId, @Nullable final b callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) templateId, (Object) callback);
            return;
        }
        com.tencent.ams.dynamicwidget.utils.b.f70218a.c(this.tag, "deleteTemplate - templateId: " + templateId);
        com.tencent.ams.dynamicwidget.utils.c.f70219a.a(new Runnable(templateId, callback) { // from class: com.tencent.ams.dynamicwidget.BaseDynamicView$deleteTemplate$1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f70137d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ BaseDynamicView.b f70138e;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f70137d = templateId;
                this.f70138e = callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, BaseDynamicView.this, templateId, callback);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this);
                    return;
                }
                boolean s16 = BaseDynamicView.this.s(this.f70137d);
                BaseDynamicView.b bVar = this.f70138e;
                if (bVar != null) {
                    bVar.onFinish(s16);
                }
            }
        });
    }

    public boolean s(@Nullable String templateId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, (Object) templateId)).booleanValue();
        }
        com.tencent.ams.dynamicwidget.utils.b.f70218a.c(this.tag, "deleteTemplateSync - templateId: " + templateId);
        if (templateId != null) {
            return TemplateManager.getInstance().deleteTemplate(null, templateId);
        }
        return false;
    }

    public final void setDarkMode(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            this.isDarkMode = z16;
            E();
        }
    }

    public final void setRenderSuccess(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.isRenderSuccess = z16;
        }
    }

    public final void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        com.tencent.ams.dynamicwidget.utils.b.f70218a.c(this.tag, '[' + this.hashCode + "] destroyEngine");
        com.tencent.ams.dynamicwidget.utils.d.f70220a.h(new Runnable() { // from class: com.tencent.ams.dynamicwidget.BaseDynamicView$destroyEngine$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) BaseDynamicView.this);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                String str;
                DKMosaicEngine dKMosaicEngine;
                com.tencent.ams.mosaic.h hVar;
                String str2;
                String str3;
                DKMethodHandler dKMethodHandler;
                String str4;
                DKMethodHandler dKMethodHandler2;
                String str5;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this);
                    return;
                }
                com.tencent.ams.dynamicwidget.utils.b bVar = com.tencent.ams.dynamicwidget.utils.b.f70218a;
                String z16 = BaseDynamicView.this.z();
                StringBuilder sb5 = new StringBuilder();
                sb5.append('[');
                str = BaseDynamicView.this.hashCode;
                sb5.append(str);
                sb5.append("] destroyEngine: start");
                bVar.c(z16, sb5.toString());
                dKMosaicEngine = BaseDynamicView.this.dynamicEngine;
                if (dKMosaicEngine != null) {
                    dKMosaicEngine.onDestroy();
                    String z17 = BaseDynamicView.this.z();
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append('[');
                    str3 = BaseDynamicView.this.hashCode;
                    sb6.append(str3);
                    sb6.append("] destroyEngine: unregister methodHandler");
                    bVar.c(z17, sb6.toString());
                    dKMethodHandler = BaseDynamicView.this.methodHandler;
                    dKMosaicEngine.unregisterMethodHandler(dKMethodHandler);
                    String z18 = BaseDynamicView.this.z();
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append('[');
                    str4 = BaseDynamicView.this.hashCode;
                    sb7.append(str4);
                    sb7.append("] destroyEngine: unregister commonMethodHandler");
                    bVar.c(z18, sb7.toString());
                    dKMethodHandler2 = BaseDynamicView.this.commonMethodHandler;
                    dKMosaicEngine.unregisterMethodHandler(dKMethodHandler2);
                    String z19 = BaseDynamicView.this.z();
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append('[');
                    str5 = BaseDynamicView.this.hashCode;
                    sb8.append(str5);
                    sb8.append("] destroyEngine unregisterMethodHandler finish");
                    bVar.c(z19, sb8.toString());
                }
                hVar = BaseDynamicView.this.mosaicEventCenter;
                if (hVar != null) {
                    hVar.e(BaseDynamicView.this);
                }
                String z26 = BaseDynamicView.this.z();
                StringBuilder sb9 = new StringBuilder();
                sb9.append('[');
                str2 = BaseDynamicView.this.hashCode;
                sb9.append(str2);
                sb9.append("] destroyEngine: unregisterHandler end");
                bVar.c(z26, sb9.toString());
            }
        }, 1000L);
    }

    public void u(int eventId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, eventId);
        } else {
            v(eventId, null);
        }
    }

    public void v(int eventId, @Nullable Long timeCost) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, eventId, (Object) timeCost);
            return;
        }
        this.adInfo.getClickReqType();
        y();
        this.adInfo.getAid();
        this.adInfo.getLinkEventTraceId();
        this.adInfo.getConvViewId();
        this.adInfo.getUxinfo();
        this.adInfo.getDestUrlReflectionId();
        throw null;
    }

    public final int x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return ((Number) this.chid.getValue()).intValue();
    }

    @Nullable
    public final Integer y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (Integer) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return null;
    }

    @NotNull
    public final String z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (String) iPatchRedirector.redirect((short) 37, (Object) this);
        }
        return this.tag;
    }
}
