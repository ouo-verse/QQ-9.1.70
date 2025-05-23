package com.tencent.mobileqq.qqlive.widget.resolution;

import com.tencent.ams.xsad.rewarded.dynamic.method.RewardAdMethodHandler;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqecommerce.biz.eventbus.IQQEcommerceEventBus;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk;
import com.tencent.mobileqq.qqlive.api.av.LiveMediaConfigManager;
import com.tencent.mobileqq.qqlive.api.av.ResolutionLevelType;
import com.tencent.mobileqq.qqlive.widget.resolution.ResolutionSettingDialog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0002\t\u0010BF\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00040\f\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR/\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00040\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0017R\u0014\u0010\u001f\u001a\u00020\u001d8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u001e\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/resolution/ResolutionSettingDialog;", "", "", "d", "", "f", "e", "", "Lcom/tencent/mobileqq/qqlive/api/av/ResolutionLevelType;", "a", "Ljava/util/List;", "resolutionLevels", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "resolutionLevel", "b", "Lkotlin/jvm/functions/Function1;", "onChanged", "Lkotlin/Function0;", "c", "Lkotlin/jvm/functions/Function0;", RewardAdMethodHandler.RewardAdEvent.ON_CLOSE_CLICKED, "Ljava/lang/String;", ZPlanPublishSource.FROM_SCHEME, "Lcom/tencent/mobileqq/qqecommerce/biz/eventbus/IQQEcommerceEventBus$a;", "Lcom/tencent/mobileqq/qqecommerce/biz/eventbus/IQQEcommerceEventBus$a;", "eventObserver", "resolution", "", "()I", "contentHeight", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "g", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class ResolutionSettingDialog {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<ResolutionLevelType> resolutionLevels;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<ResolutionLevelType, Unit> onChanged;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> onCloseClicked;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String scheme;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IQQEcommerceEventBus.a eventObserver;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String resolution;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/resolution/ResolutionSettingDialog$a;", "", "", "KTV_ACTION_CLOSE", "Ljava/lang/String;", "KTV_ACTION_SELECT", "KTV_CALLBACK", "KTV_PAGE_NAME", "KTV_PARAM_RESOLUTION", "TAG", "<init>", "()V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.widget.resolution.ResolutionSettingDialog$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0010\u0010\u0011J4\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005`\u0006H\u0016R\"\u0010\u000e\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/resolution/ResolutionSettingDialog$b;", "Lcom/tencent/mobileqq/qqecommerce/biz/eventbus/IQQEcommerceEventBus$a;", "", "event", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "data", "", "a", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/qqlive/widget/resolution/ResolutionSettingDialog;", "kotlin.jvm.PlatformType", "Lmqq/util/WeakReference;", "dialogRef", "settingDialog", "<init>", "(Lcom/tencent/mobileqq/qqlive/widget/resolution/ResolutionSettingDialog;)V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements IQQEcommerceEventBus.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<ResolutionSettingDialog> dialogRef;

        public b(@NotNull ResolutionSettingDialog settingDialog) {
            Intrinsics.checkNotNullParameter(settingDialog, "settingDialog");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) settingDialog);
            } else {
                this.dialogRef = new WeakReference<>(settingDialog);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(b this$0) {
            Function0 function0;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ResolutionSettingDialog resolutionSettingDialog = this$0.dialogRef.get();
            if (resolutionSettingDialog != null && (function0 = resolutionSettingDialog.onCloseClicked) != null) {
                function0.invoke();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(b this$0, ResolutionLevelType it) {
            Function1 function1;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(it, "$it");
            ResolutionSettingDialog resolutionSettingDialog = this$0.dialogRef.get();
            if (resolutionSettingDialog != null && (function1 = resolutionSettingDialog.onChanged) != null) {
                function1.invoke(it);
            }
        }

        @Override // com.tencent.mobileqq.qqecommerce.biz.eventbus.IQQEcommerceEventBus.a
        public void a(@NotNull String event, @NotNull HashMap<String, Object> data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) event, (Object) data);
                return;
            }
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(data, "data");
            try {
                Object obj = data.get("KEY_JSON");
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                JSONObject jSONObject = new JSONObject((String) obj);
                String optString = jSONObject.optString("action");
                if (Intrinsics.areEqual(optString, "close")) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.widget.resolution.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            ResolutionSettingDialog.b.d(ResolutionSettingDialog.b.this);
                        }
                    });
                } else if (Intrinsics.areEqual(optString, "select")) {
                    ResolutionLevelType.Companion companion = ResolutionLevelType.INSTANCE;
                    String optString2 = jSONObject.optString("resolution");
                    Intrinsics.checkNotNullExpressionValue(optString2, "params.optString(KTV_PARAM_RESOLUTION)");
                    final ResolutionLevelType byTerm = companion.getByTerm(optString2);
                    if (byTerm != null) {
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.widget.resolution.b
                            @Override // java.lang.Runnable
                            public final void run() {
                                ResolutionSettingDialog.b.e(ResolutionSettingDialog.b.this, byTerm);
                            }
                        });
                    }
                }
            } catch (Exception e16) {
                AegisLogger.Companion companion2 = AegisLogger.INSTANCE;
                String obj2 = data.toString();
                Intrinsics.checkNotNullExpressionValue(obj2, "data.toString()");
                companion2.e("Open_Live|ResolutionSettingDialog", "observeEvent", obj2, e16);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37985);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ResolutionSettingDialog(@NotNull List<? extends ResolutionLevelType> resolutionLevels, @NotNull Function1<? super ResolutionLevelType, Unit> onChanged, @NotNull Function0<Unit> onCloseClicked) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(resolutionLevels, "resolutionLevels");
        Intrinsics.checkNotNullParameter(onChanged, "onChanged");
        Intrinsics.checkNotNullParameter(onCloseClicked, "onCloseClicked");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, resolutionLevels, onChanged, onCloseClicked);
            return;
        }
        this.resolutionLevels = resolutionLevels;
        this.onChanged = onChanged;
        this.onCloseClicked = onCloseClicked;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("&resolutions=");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(resolutionLevels, ",", null, null, 0, null, AnonymousClass1.INSTANCE, 30, null);
        sb5.append(URLEncoder.encode(joinToString$default, "UTF-8"));
        String sb6 = sb5.toString();
        this.resolution = sb6;
        this.scheme = "mqqapi://ecommerce/open?target=52&channel=8&page_name=anchor_resolution_setting" + sb6 + ("&is_debug_mode=0") + ("&height=" + c() + "&showCloseBtn=0&modal_mode=1");
        b bVar = new b(this);
        this.eventObserver = bVar;
        ((IQQEcommerceEventBus) QRoute.api(IQQEcommerceEventBus.class)).observeEvent("resSettingCallback", bVar);
    }

    private final int c() {
        float b16;
        int roundToInt;
        b16 = c.b(DisplayUtil.dip2px(BaseApplication.context, 406.0f));
        roundToInt = MathKt__MathJVMKt.roundToInt(b16 - 20.0f);
        return roundToInt;
    }

    private final String d() {
        boolean z16;
        Iterator<ResolutionLevelType> it = this.resolutionLevels.iterator();
        int i3 = 0;
        int i16 = 0;
        while (true) {
            if (it.hasNext()) {
                if (it.next().getCode() == LiveMediaConfigManager.INSTANCE.getResolutionLevelTypeCache(ResolutionLevelType.UHD).getCode()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
                i16++;
            } else {
                i16 = -1;
                break;
            }
        }
        if (i16 >= 0) {
            i3 = i16;
        }
        return "&selectedIndex=" + i3;
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            ((IQQEcommerceEventBus) QRoute.api(IQQEcommerceEventBus.class)).releaseObserver(this.eventObserver);
        }
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).handleScheme(this.scheme + d(), null);
    }
}
