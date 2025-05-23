package com.tencent.mobileqq.onlinestatus.view.zplan;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.onlinestatus.model.AvatarStatusViewScene;
import com.tencent.mobileqq.onlinestatus.view.zplan.AvatarStatusView;
import com.tencent.mobileqq.qqfeatureswitch.FeatureSwitch;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.zplan.api.impl.ZPlanApiImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 \u00182\u00020\u0001:\u0002\f\u000bB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001c\u0010\u0005\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J$\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0002`\bH\u0002J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0007R2\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0002`\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR0\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0002`\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\rR$\u0010\u0016\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0019\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusViewLoadStrategy;", "", "Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusView$e;", "local", "remote", "d", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/onlinestatus/model/AvatarStatusViewScene;", "Lkotlin/collections/HashMap;", "c", "scene", "b", "a", "Ljava/util/HashMap;", "remoteOptions", "localOptions", "", "Ljava/lang/Boolean;", "getShowPreview", "()Ljava/lang/Boolean;", "f", "(Ljava/lang/Boolean;)V", "showPreview", "getShowFilament", "e", "showFilament", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class AvatarStatusViewLoadStrategy {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final Lazy<AvatarStatusViewLoadStrategy> f256812f;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private HashMap<AvatarStatusViewScene, AvatarStatusView.ShowStrategy> remoteOptions;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<AvatarStatusViewScene, AvatarStatusView.ShowStrategy> localOptions = new HashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Boolean showPreview;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Boolean showFilament;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusViewLoadStrategy$a;", "", "Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusViewLoadStrategy;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusViewLoadStrategy;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "SWITCH_NAME", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.onlinestatus.view.zplan.AvatarStatusViewLoadStrategy$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AvatarStatusViewLoadStrategy a() {
            return (AvatarStatusViewLoadStrategy) AvatarStatusViewLoadStrategy.f256812f.getValue();
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J4\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\"\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007J*\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u00072\u0006\u0010\u000f\u001a\u00020\u0002R0\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b`\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusViewLoadStrategy$b;", "", "Lorg/json/JSONObject;", "scenes", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/onlinestatus/model/AvatarStatusViewScene;", "Lcom/tencent/mobileqq/onlinestatus/view/zplan/AvatarStatusView$e;", "Lkotlin/collections/HashMap;", "options", "", "d", "", "text", "c", "a", "switchJSON", "b", "Ljava/util/HashMap;", "SCENE_KEY_MAP", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f256817a = new b();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final HashMap<AvatarStatusViewScene, String> SCENE_KEY_MAP;

        static {
            HashMap<AvatarStatusViewScene, String> hashMap = new HashMap<>();
            hashMap.put(AvatarStatusViewScene.ONLINE_STATUS_PANEL, "online_status_panel");
            hashMap.put(AvatarStatusViewScene.ONLINE_STATUS_AGGREGATION_PANEL, "online_status_aggregation_panel");
            hashMap.put(AvatarStatusViewScene.AIO_MSG_FLOW, "aio_msg_flow");
            hashMap.put(AvatarStatusViewScene.POPUP_WINDOW, "popup_window");
            hashMap.put(AvatarStatusViewScene.TEST_PAGE, "test_page");
            SCENE_KEY_MAP = hashMap;
        }

        b() {
        }

        private final AvatarStatusView.ShowStrategy c(String text) {
            boolean z16;
            List split$default;
            CharSequence trim;
            boolean z17 = false;
            try {
                split$default = StringsKt__StringsKt.split$default((CharSequence) text, new String[]{"|"}, false, 0, 6, (Object) null);
                Iterator it = split$default.iterator();
                boolean z18 = false;
                while (it.hasNext()) {
                    try {
                        trim = StringsKt__StringsKt.trim((CharSequence) it.next());
                        String obj = trim.toString();
                        if (Intrinsics.areEqual(obj, ZPlanApiImpl.FILAMENT_TAG)) {
                            z18 = true;
                        } else if (Intrinsics.areEqual(obj, "preview")) {
                            z17 = true;
                        }
                    } catch (Exception e16) {
                        e = e16;
                        boolean z19 = z18;
                        z16 = z17;
                        z17 = z19;
                        QLog.i("AvatarStatusView.LoadStrategy", 1, "[parseOption] exception=" + e);
                        return new AvatarStatusView.ShowStrategy(z17, z16);
                    }
                }
                return new AvatarStatusView.ShowStrategy(z17, z18);
            } catch (Exception e17) {
                e = e17;
                z16 = false;
            }
        }

        private final void d(JSONObject scenes, HashMap<AvatarStatusViewScene, AvatarStatusView.ShowStrategy> options) {
            for (Map.Entry<AvatarStatusViewScene, String> entry : SCENE_KEY_MAP.entrySet()) {
                if (!scenes.has(entry.getValue())) {
                    QLog.i("AvatarStatusView.LoadStrategy", 1, "[parseScene] '" + entry.getKey() + "' not configured");
                } else {
                    AvatarStatusViewScene key = entry.getKey();
                    Intrinsics.checkNotNullExpressionValue(key, "entry.key");
                    String optString = scenes.optString(entry.getValue());
                    Intrinsics.checkNotNullExpressionValue(optString, "scenes.optString(entry.value)");
                    AvatarStatusView.ShowStrategy c16 = c(optString);
                    if (QLog.isColorLevel()) {
                        QLog.i("AvatarStatusView.LoadStrategy", 1, "[parseScene] '" + entry.getKey() + "'->" + c16);
                    }
                    options.put(key, c16);
                }
            }
        }

        @NotNull
        public final HashMap<AvatarStatusViewScene, AvatarStatusView.ShowStrategy> a() {
            HashMap<AvatarStatusViewScene, AvatarStatusView.ShowStrategy> hashMap = new HashMap<>();
            Iterator<Map.Entry<AvatarStatusViewScene, String>> it = SCENE_KEY_MAP.entrySet().iterator();
            while (it.hasNext()) {
                AvatarStatusViewScene key = it.next().getKey();
                Intrinsics.checkNotNullExpressionValue(key, "entry.key");
                hashMap.put(key, new AvatarStatusView.ShowStrategy(false, false));
            }
            return hashMap;
        }

        @NotNull
        public final HashMap<AvatarStatusViewScene, AvatarStatusView.ShowStrategy> b(@NotNull JSONObject switchJSON) {
            Intrinsics.checkNotNullParameter(switchJSON, "switchJSON");
            HashMap<AvatarStatusViewScene, AvatarStatusView.ShowStrategy> hashMap = new HashMap<>();
            try {
                JSONObject optJSONObject = switchJSON.optJSONObject("scenes");
                if (optJSONObject != null) {
                    d(optJSONObject, hashMap);
                } else {
                    QLog.i("AvatarStatusView.LoadStrategy", 1, "[parseConfig] scenes is empty");
                }
            } catch (Exception e16) {
                QLog.i("AvatarStatusView.LoadStrategy", 1, "[parseConfig] exception=" + e16);
            }
            return hashMap;
        }
    }

    static {
        Lazy<AvatarStatusViewLoadStrategy> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AvatarStatusViewLoadStrategy>() { // from class: com.tencent.mobileqq.onlinestatus.view.zplan.AvatarStatusViewLoadStrategy$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AvatarStatusViewLoadStrategy invoke() {
                return new AvatarStatusViewLoadStrategy();
            }
        });
        f256812f = lazy;
    }

    private final HashMap<AvatarStatusViewScene, AvatarStatusView.ShowStrategy> c() {
        IFeatureRuntimeService iFeatureRuntimeService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            iFeatureRuntimeService = (IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all");
        } else {
            iFeatureRuntimeService = null;
        }
        if (iFeatureRuntimeService == null) {
            QLog.i("AvatarStatusView.LoadStrategy", 1, "[initOptions] runtime service is null");
            return new HashMap<>();
        }
        FeatureSwitch featureSwitch = iFeatureRuntimeService.getFeatureSwitch("avatar_status_view_strategy_8928");
        if (featureSwitch != null && featureSwitch.mSwitchEnable) {
            JSONObject jSONObject = iFeatureRuntimeService.getJSONObject("avatar_status_view_strategy_8928", null);
            if (jSONObject == null) {
                QLog.i("AvatarStatusView.LoadStrategy", 1, "[initOptions] switch is on, but no detail config");
                return new HashMap<>();
            }
            return b.f256817a.b(jSONObject);
        }
        QLog.i("AvatarStatusView.LoadStrategy", 1, "[initOptions] switch is off, use disable config");
        return b.f256817a.a();
    }

    private final AvatarStatusView.ShowStrategy d(AvatarStatusView.ShowStrategy local, AvatarStatusView.ShowStrategy remote) {
        boolean z16;
        boolean z17 = true;
        if (local != null && remote != null) {
            if (local.getShowPreview() && remote.getShowPreview()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!local.getShowFilament() || !remote.getShowFilament()) {
                z17 = false;
            }
            return new AvatarStatusView.ShowStrategy(z16, z17);
        }
        if (remote != null) {
            return remote;
        }
        if (local == null) {
            return new AvatarStatusView.ShowStrategy(true, true);
        }
        return local;
    }

    @NotNull
    public final AvatarStatusView.ShowStrategy b(@NotNull AvatarStatusViewScene scene) {
        boolean z16;
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (this.remoteOptions == null) {
            this.remoteOptions = c();
        }
        Boolean bool = this.showPreview;
        boolean z17 = true;
        if (bool == null && this.showFilament == null) {
            HashMap<AvatarStatusViewScene, AvatarStatusView.ShowStrategy> hashMap = this.remoteOptions;
            if (hashMap == null) {
                Intrinsics.throwUninitializedPropertyAccessException("remoteOptions");
                hashMap = null;
            }
            AvatarStatusView.ShowStrategy d16 = d(this.localOptions.get(scene), hashMap.get(scene));
            if (QLog.isColorLevel()) {
                QLog.i("AvatarStatusView.LoadStrategy", 1, "[getStrategy] scene=" + scene + " strategy=" + d16);
            }
            return d16;
        }
        if (bool != null) {
            z16 = bool.booleanValue();
        } else {
            z16 = true;
        }
        Boolean bool2 = this.showFilament;
        if (bool2 != null) {
            z17 = bool2.booleanValue();
        }
        return new AvatarStatusView.ShowStrategy(z16, z17);
    }

    public final void e(@Nullable Boolean bool) {
        this.showFilament = bool;
    }

    public final void f(@Nullable Boolean bool) {
        this.showPreview = bool;
    }
}
