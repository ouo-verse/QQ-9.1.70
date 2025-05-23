package com.tencent.intimate_space.impl;

import android.app.Activity;
import android.content.Context;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.UiThread;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.filament.zplan.app.api.IFilamentNativeAppV2305;
import com.tencent.filament.zplan.manager.FilamentRenderFactory;
import com.tencent.filament.zplanservice.channel.SceneEventConfig;
import com.tencent.filament.zplanservice.channel.f;
import com.tencent.filament.zplanservice.feature.FilamentFeatureUtil;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.filament.zplanservice.pbjava.EmptyMessageChannel$SceneEmptyMessage;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.zplan.zplantracing.b;
import dl0.d;
import dl0.g;
import dl0.k;
import i01.c;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008b\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005*\u00018\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001\u001bB\u000f\u0012\u0006\u0010=\u001a\u00020<\u00a2\u0006\u0004\b>\u0010?J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\u0012\u0010\n\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u001c\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0002JI\u0010\u0016\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b2+\u0010\u0015\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010j\u0004\u0018\u0001`\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0014J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\bH\u0016R;\u0010\u001e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010j\u0004\u0018\u0001`\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR4\u0010#\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0018\u0012\u0016\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0010j\u0002` 0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u00101R&\u00107\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020504038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u0010\"R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:\u00a8\u0006A"}, d2 = {"Lcom/tencent/intimate_space/impl/IntimateSpaceFilamentView;", "Landroid/widget/FrameLayout;", "Li01/c;", "", "p", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "", "propValue", "t", "", "method", "param", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", NodeProps.ON_ATTACHED_TO_WINDOW, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "propKey", "", "b", "d", "Lkotlin/jvm/functions/Function1;", "ktvCallback", "", "Lcom/tencent/intimate_space/impl/PropCallStyle;", "e", "Ljava/util/Map;", "ktvPropMap", "", "f", "J", WadlProxyConsts.SCENE_ID, "Lcom/tencent/filament/zplan/app/api/IFilamentNativeAppV2305;", h.F, "Lcom/tencent/filament/zplan/app/api/IFilamentNativeAppV2305;", "nativeApp", "Landroid/view/View;", "i", "Landroid/view/View;", "filamentTextureView", "Lcom/tencent/zplan/zplantracing/b;", "Lcom/tencent/zplan/zplantracing/b;", "rootSpan", "", "Ljava/lang/Class;", "Lcom/tencent/filament/zplanservice/pbjava/EmptyMessageChannel$SceneEmptyMessage;", BdhLogUtil.LogTag.Tag_Conn, "handlerEventMap", "com/tencent/intimate_space/impl/IntimateSpaceFilamentView$c", "D", "Lcom/tencent/intimate_space/impl/IntimateSpaceFilamentView$c;", "sceneHandler", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "E", "intimate_space_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class IntimateSpaceFilamentView extends FrameLayout implements i01.c {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Map<String, Class<EmptyMessageChannel$SceneEmptyMessage>> handlerEventMap;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final c sceneHandler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> ktvCallback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Function1<Object, Object>> ktvPropMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long sceneId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IFilamentNativeAppV2305 nativeApp;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View filamentTextureView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b rootSpan;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/intimate_space/impl/IntimateSpaceFilamentView$a", "Lsk0/b;", "Lcom/tencent/zplan/zplantracing/c;", "spanContext", "", "type", "data", "", "handleEvent", "intimate_space_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class a implements sk0.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) IntimateSpaceFilamentView.this);
            }
        }

        @Override // sk0.b
        public void handleEvent(@Nullable com.tencent.zplan.zplantracing.c spanContext, @NotNull String type, @Nullable String data) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, spanContext, type, data);
                return;
            }
            Intrinsics.checkNotNullParameter(type, "type");
            FLog.INSTANCE.d("IntimateSpaceFilamentView", "onEvent, type: " + type + ", eventData: " + data);
            if (data != null && data.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return;
            }
            IntimateSpaceFilamentView.this.sceneId = new JSONObject(data).optLong(WadlProxyConsts.SCENE_ID);
            f.f106360b.c(IntimateSpaceFilamentView.this.sceneId, new SceneEventConfig(IntimateSpaceFilamentView.this.sceneHandler, IntimateSpaceFilamentView.this.handlerEventMap));
            IntimateSpaceFilamentView intimateSpaceFilamentView = IntimateSpaceFilamentView.this;
            intimateSpaceFilamentView.m("setSceneId", Long.valueOf(intimateSpaceFilamentView.sceneId));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/intimate_space/impl/IntimateSpaceFilamentView$b;", "", "", "KEY_METHOD_NAME", "Ljava/lang/String;", "KEY_METHOD_PARAM", "METHOD_ON_PAUSE", "METHOD_ON_RESUME", "METHOD_SET_CALLBACK", "NOTIFY_SCENE_READY", "SCENE_READY", "SET_SCENE_ID", "TAG", "VIEW_NAME", "<init>", "()V", "intimate_space_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.intimate_space.impl.IntimateSpaceFilamentView$b, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
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
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002O\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0001j\u0002`\u000bJ%\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00022\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\t\u001a\u00020\bH\u0096\u0002\u00a8\u0006\r"}, d2 = {"com/tencent/intimate_space/impl/IntimateSpaceFilamentView$c", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", AdMetricTag.EVENT_NAME, "Lcom/tencent/mobileqq/pb/MessageMicro;", "pbField", "Lcom/tencent/filament/zplanservice/channel/a;", "callbackN2C", "", "Lcom/tencent/filament/zplanservice/channel/SceneHandler;", "a", "intimate_space_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class c implements Function3<String, MessageMicro<?>, com.tencent.filament.zplanservice.channel.a, Unit> {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) IntimateSpaceFilamentView.this);
            }
        }

        public void a(@NotNull String eventName, @NotNull MessageMicro<?> pbField, @NotNull com.tencent.filament.zplanservice.channel.a callbackN2C) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, eventName, pbField, callbackN2C);
                return;
            }
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            Intrinsics.checkNotNullParameter(pbField, "pbField");
            Intrinsics.checkNotNullParameter(callbackN2C, "callbackN2C");
            if (Intrinsics.areEqual(eventName, "IntimateSpace.HasBeenReady")) {
                IntimateSpaceFilamentView.this.p();
            }
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(String str, MessageMicro<?> messageMicro, com.tencent.filament.zplanservice.channel.a aVar) {
            a(str, messageMicro, aVar);
            return Unit.INSTANCE;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27646);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntimateSpaceFilamentView(@NotNull Context context) {
        super(context);
        Map<String, Function1<Object, Object>> mapOf;
        Map<String, Class<EmptyMessageChannel$SceneEmptyMessage>> mutableMapOf;
        com.tencent.zplan.zplantracing.c cVar;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(IECSearchBar.METHOD_SET_CALLBACK, new IntimateSpaceFilamentView$ktvPropMap$1(this)));
            this.ktvPropMap = mapOf;
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("IntimateSpace.HasBeenReady", EmptyMessageChannel$SceneEmptyMessage.class));
            this.handlerEventMap = mutableMapOf;
            this.sceneHandler = new c();
            FilamentUrlTemplate F = FilamentFeatureUtil.f106409g.F();
            fl0.a aVar = fl0.a.f399763a;
            IFilamentNativeAppV2305 c16 = FilamentRenderFactory.f105773b.c(new sk0.a(F, true, context, 30, (k) aVar.a(k.class), (d) aVar.a(d.class), (g) aVar.a(g.class)));
            this.nativeApp = c16;
            if (c16 != null) {
                b bVar = this.rootSpan;
                if (bVar != null) {
                    cVar = bVar.c();
                } else {
                    cVar = null;
                }
                c16.startWithEntry(cVar, "bundle/scenes/intimate_space/main.js");
            }
            IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
            if (iFilamentNativeAppV2305 != null) {
                iFilamentNativeAppV2305.addEventListener("IntimateSpaceScene.setSceneId", new a());
                return;
            }
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object m(String method, Object param) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("methodName", method);
            if (param != null) {
                jSONObject.put("methodParam", param);
            }
            Function1<Object, Unit> function1 = this.ktvCallback;
            if (function1 != null) {
                function1.invoke(jSONObject.toString());
                return null;
            }
            return null;
        } catch (JSONException e16) {
            FLog fLog = FLog.INSTANCE;
            String message = e16.getMessage();
            if (message == null) {
                message = "";
            }
            fLog.w("IntimateSpaceFilamentView", message);
            return null;
        }
    }

    private final void o() {
        TextureView view;
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null && (view = iFilamentNativeAppV2305.getView()) != null) {
            this.filamentTextureView = view;
            addView(this.filamentTextureView, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        m("notifySceneReady", null);
    }

    private final void q() {
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            iFilamentNativeAppV2305.pause();
        }
    }

    private final void r() {
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 != null) {
            iFilamentNativeAppV2305.resume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object t(Object propValue) {
        Intrinsics.checkNotNull(propValue, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'result')] kotlin.Any?, kotlin.Unit>{ com.tencent.kuikly.core.render.android.export.IKuiklyRenderModuleExportKt.KuiklyRenderCallback }");
        this.ktvCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
        return Boolean.TRUE;
    }

    @Override // i01.c
    public boolean b(@NotNull String propKey, @NotNull Object propValue) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) propKey, propValue)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        Function1<Object, Object> function1 = this.ktvPropMap.get(propKey);
        Boolean bool = null;
        if (function1 != null) {
            obj = function1.invoke(propValue);
        } else {
            obj = null;
        }
        if (obj instanceof Boolean) {
            bool = (Boolean) obj;
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return c.a.p(this, propKey, propValue);
    }

    @Override // i01.a
    @Nullable
    public Object call(@NotNull String str, @Nullable Object obj, @Nullable Function1<Object, Unit> function1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? c.a.a(this, str, obj, function1) : iPatchRedirector.redirect((short) 6, this, str, obj, function1);
    }

    @Override // i01.c
    public void e(@NotNull ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) viewGroup);
        } else {
            c.a.l(this, viewGroup);
        }
    }

    @Override // i01.c
    @NotNull
    public View f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (View) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return c.a.r(this);
    }

    @Override // i01.c, i01.a
    @Nullable
    public Activity getActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Activity) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return c.a.e(this);
    }

    @Override // i01.c, i01.a
    @Nullable
    /* renamed from: getKuiklyRenderContext */
    public com.tencent.kuikly.core.render.android.a get_kuiklyRenderContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.kuikly.core.render.android.a) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return c.a.f(this);
    }

    @Override // i01.c
    @UiThread
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            c.a.n(this);
        }
    }

    @Override // i01.c
    /* renamed from: k */
    public boolean getReusable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return c.a.g(this);
    }

    @Override // i01.c
    public void n(@NotNull ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) viewGroup);
        } else {
            c.a.i(this, viewGroup);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onAttachedToWindow();
            o();
        }
    }

    @Override // i01.a
    @UiThread
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            c.a.j(this);
        }
    }

    @Override // i01.c, i01.a
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        c.a.k(this);
        IFilamentNativeAppV2305 iFilamentNativeAppV2305 = this.nativeApp;
        if (iFilamentNativeAppV2305 == null) {
            return;
        }
        if (iFilamentNativeAppV2305 != null) {
            iFilamentNativeAppV2305.destroy();
        }
        this.nativeApp = null;
        View view = this.filamentTextureView;
        if (view != null) {
            removeView(view);
        }
        this.filamentTextureView = null;
    }

    @Override // i01.c
    @UiThread
    public boolean s(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str)).booleanValue();
        }
        return c.a.m(this, str);
    }

    @Override // i01.c, i01.a
    public void setKuiklyRenderContext(@Nullable com.tencent.kuikly.core.render.android.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) aVar);
        } else {
            c.a.o(this, aVar);
        }
    }

    @Override // i01.c
    @UiThread
    public void setShadow(@NotNull i01.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) bVar);
        } else {
            c.a.q(this, bVar);
        }
    }

    @Override // i01.c, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, this, method, params, callback);
        }
        Intrinsics.checkNotNullParameter(method, "method");
        if (Intrinsics.areEqual(method, "onResume")) {
            r();
            return Unit.INSTANCE;
        }
        if (!Intrinsics.areEqual(method, MiniSDKConst.NOTIFY_EVENT_ONPAUSE)) {
            return c.a.b(this, method, params, callback);
        }
        q();
        return Unit.INSTANCE;
    }
}
