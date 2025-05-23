package com.tencent.mobileqq.config.avatar;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.square.detail.DetailMeFragmentConfig;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0014\u0018\u0000 .2\u00020\u0001:\u0001!B\t\b\u0002\u00a2\u0006\u0004\b,\u0010-J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J$\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007H\u0002J4\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\"\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007H\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\tH\u0002JR\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u000526\u0010\u0018\u001a2\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\f0\u00122\b\b\u0002\u0010\u0019\u001a\u00020\u0005H\u0002J\u000e\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001bJP\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u000526\u0010\u0018\u001a2\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\f0\u00122\b\b\u0002\u0010\u0019\u001a\u00020\u0005J\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002J\u0018\u0010 \u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005R\u0016\u0010#\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R2\u0010+\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010*\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/config/avatar/AvatarViewConfig;", "", "Lcom/tencent/mobileqq/config/avatar/h;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/config/avatar/b;", "Lkotlin/collections/HashMap;", "l", "Lorg/json/JSONObject;", "jsonObjet", "configMap", "", "k", "jsonObject", "Lcom/tencent/mobileqq/config/avatar/i;", DomainData.DOMAIN_NAME, DetailMeFragmentConfig.CURRENT_STATUS_ID, "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "imageUrl", "color", "callback", "subIndex", "d", "", "forceLoad", "j", tl.h.F, "g", "f", "a", "Z", "mConfigLoaded", "b", "Lorg/json/JSONObject;", "mConfigJson", "c", "Lcom/tencent/mobileqq/config/avatar/h;", "mBaseConfig", "Ljava/util/HashMap;", "mAvatarConfigMap", "<init>", "()V", "e", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AvatarViewConfig {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final Lazy<AvatarViewConfig> f202357f;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private volatile boolean mConfigLoaded;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private JSONObject mConfigJson;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BaseConfigItem mBaseConfig;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashMap<Integer, AvatarConfigItem> mAvatarConfigMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0014\u0010\u0010\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0014\u0010\u0011\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\nR\u0014\u0010\u0012\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\nR\u0014\u0010\u0013\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\nR\u0014\u0010\u0014\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\nR\u0014\u0010\u0015\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\nR\u0014\u0010\u0016\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\n\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/config/avatar/AvatarViewConfig$a;", "", "Lcom/tencent/mobileqq/config/avatar/AvatarViewConfig;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/config/avatar/AvatarViewConfig;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "JSON_KEY_ACTION_ID", "Ljava/lang/String;", "JSON_KEY_ACTION_MD5", "JSON_KEY_ACTION_URL", "JSON_KEY_AVATAR", "JSON_KEY_BASE", "JSON_KEY_NORMAL_BG_COLOR", "JSON_KEY_NORMAL_BG_URL", "JSON_KEY_POSTER_STATUS_TEXT_COLOR", "JSON_KEY_POSTER_TEXT", "JSON_KEY_STATUS_ID", "JSON_KEY_SUB_CONFIG_DATA", "JSON_KEY_TOFU_BACKGROUND", "TAG", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.config.avatar.AvatarViewConfig$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AvatarViewConfig a() {
            return (AvatarViewConfig) AvatarViewConfig.f202357f.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<AvatarViewConfig> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<AvatarViewConfig>() { // from class: com.tencent.mobileqq.config.avatar.AvatarViewConfig$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AvatarViewConfig invoke() {
                return new AvatarViewConfig(null);
            }
        });
        f202357f = lazy;
    }

    public /* synthetic */ AvatarViewConfig(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX WARN: Type inference failed for: r1v14, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v5, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v7, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v8, types: [T, java.lang.String] */
    private final void d(int statusId, final Function2<? super String, ? super String, Unit> callback, int subIndex) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = "";
        if (this.mAvatarConfigMap.containsKey(Integer.valueOf(statusId))) {
            AvatarConfigItem avatarConfigItem = this.mAvatarConfigMap.get(Integer.valueOf(statusId));
            Intrinsics.checkNotNull(avatarConfigItem);
            objectRef.element = avatarConfigItem.getDefaultData().getNormalBgUrl();
            objectRef2.element = avatarConfigItem.getDefaultData().getNormalBgColor();
            if (subIndex >= 0 && avatarConfigItem.b() != null && subIndex < avatarConfigItem.b().size()) {
                objectRef.element = avatarConfigItem.b().get(subIndex).getNormalBgUrl();
                objectRef2.element = avatarConfigItem.b().get(subIndex).getNormalBgColor();
            }
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.config.avatar.f
            @Override // java.lang.Runnable
            public final void run() {
                AvatarViewConfig.e(Function2.this, objectRef, objectRef2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Function2 callback, Ref.ObjectRef bgUrl, Ref.ObjectRef bgColor) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(bgUrl, "$bgUrl");
        Intrinsics.checkNotNullParameter(bgColor, "$bgColor");
        callback.invoke(bgUrl.element, bgColor.element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(AvatarViewConfig this$0, int i3, Function2 callback, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        this$0.j(false);
        this$0.d(i3, callback, i16);
    }

    private final void k(JSONObject jsonObjet, HashMap<Integer, AvatarConfigItem> configMap) {
        ArrayList arrayList;
        try {
            int optInt = jsonObjet.optInt(ProfileCardDtReportUtil.STATUS_ID);
            ConfigData n3 = n(jsonObjet);
            if (n3 == null) {
                QLog.e("AvatarViewConfig", 1, "parseAvatarConfigItem default data empty, status is " + optInt);
                return;
            }
            JSONArray optJSONArray = jsonObjet.optJSONArray("sub_action_items");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                arrayList = new ArrayList();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject jSONObject = optJSONArray.getJSONObject(i3);
                    Intrinsics.checkNotNullExpressionValue(jSONObject, "this.getJSONObject(i)");
                    ConfigData n16 = n(jSONObject);
                    if (n16 == null) {
                        QLog.e("AvatarViewConfig", 1, "[parseAvatarConfigItem]: parseSubConfig emptyData, statusId is " + optInt + ", subIndex is " + i3);
                    } else {
                        QLog.i("AvatarViewConfig", 1, "[parseAvatarConfigItem]: parseSubConfig is " + n16);
                        arrayList.add(n16);
                    }
                }
            } else {
                arrayList = null;
            }
            AvatarConfigItem avatarConfigItem = new AvatarConfigItem(optInt, n3, arrayList);
            if (!configMap.containsKey(Integer.valueOf(optInt))) {
                configMap.put(Integer.valueOf(optInt), avatarConfigItem);
            }
        } catch (Exception e16) {
            QLog.e("AvatarViewConfig", 1, "[parseAvatarConfigItem]: " + e16);
        }
    }

    private final HashMap<Integer, AvatarConfigItem> l() {
        HashMap<Integer, AvatarConfigItem> hashMap = new HashMap<>();
        try {
            JSONObject jSONObject = this.mConfigJson;
            Intrinsics.checkNotNull(jSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("avatar_view");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "getJSONObject(i)");
                    k(jSONObject2, hashMap);
                }
            }
        } catch (Exception e16) {
            QLog.e("AvatarViewConfig", 1, "[parseAvatarConfigMap]: " + e16);
        }
        return hashMap;
    }

    private final BaseConfigItem m() {
        boolean z16;
        try {
            JSONObject jSONObject = this.mConfigJson;
            Intrinsics.checkNotNull(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("base_v2");
            if (optJSONObject != null) {
                String baseActionUrl = optJSONObject.optString("action_res_url");
                String baseActionMd5 = optJSONObject.optString("action_res_md5");
                Intrinsics.checkNotNullExpressionValue(baseActionMd5, "baseActionMd5");
                boolean z17 = false;
                if (baseActionMd5.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    Intrinsics.checkNotNullExpressionValue(baseActionUrl, "baseActionUrl");
                    if (baseActionUrl.length() == 0) {
                        z17 = true;
                    }
                    if (!z17) {
                        return new BaseConfigItem(baseActionUrl, baseActionMd5);
                    }
                }
                QLog.i("AvatarViewConfig", 1, "[parseBaseConfigItem]: empty, url is " + baseActionUrl + ", md5 is " + baseActionMd5);
                return null;
            }
        } catch (Exception e16) {
            QLog.e("AvatarViewConfig", 1, "[parseBaseConfigItem]: " + e16);
        }
        return null;
    }

    private final ConfigData n(JSONObject jsonObject) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        int optInt = jsonObject.optInt("action_id");
        String actionUrl = jsonObject.optString("action_res_url");
        String actionMd5 = jsonObject.optString("action_res_md5");
        String normalBgUrl = jsonObject.optString("normal_background");
        String normalBgColor = jsonObject.optString("normal_bg_color");
        String tofuBackground = jsonObject.optString("tofu_background");
        String posterText = jsonObject.optString("poster_text");
        String posterStatusTextColor = jsonObject.optString("poster_status_text_color");
        Intrinsics.checkNotNullExpressionValue(actionUrl, "actionUrl");
        boolean z26 = true;
        if (actionUrl.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            Intrinsics.checkNotNullExpressionValue(actionMd5, "actionMd5");
            if (actionMd5.length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                Intrinsics.checkNotNullExpressionValue(normalBgUrl, "normalBgUrl");
                if (normalBgUrl.length() == 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (!z18) {
                    Intrinsics.checkNotNullExpressionValue(normalBgColor, "normalBgColor");
                    if (normalBgColor.length() == 0) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if (!z19) {
                        Intrinsics.checkNotNullExpressionValue(tofuBackground, "tofuBackground");
                        if (tofuBackground.length() != 0) {
                            z26 = false;
                        }
                        if (!z26) {
                            Intrinsics.checkNotNullExpressionValue(posterText, "posterText");
                            Intrinsics.checkNotNullExpressionValue(posterStatusTextColor, "posterStatusTextColor");
                            return new ConfigData(optInt, actionUrl, actionMd5, normalBgUrl, normalBgColor, tofuBackground, posterText, posterStatusTextColor);
                        }
                        return null;
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    @Nullable
    public final ConfigData f(int statusId, int subIndex) {
        if (!this.mConfigLoaded) {
            j(false);
        }
        AvatarConfigItem avatarConfigItem = this.mAvatarConfigMap.get(Integer.valueOf(statusId));
        if (avatarConfigItem != null) {
            if (subIndex >= 0 && avatarConfigItem.b() != null && subIndex < avatarConfigItem.b().size()) {
                return avatarConfigItem.b().get(subIndex);
            }
            return avatarConfigItem.getDefaultData();
        }
        return null;
    }

    @Nullable
    public final BaseConfigItem g() {
        if (!this.mConfigLoaded) {
            j(false);
        }
        return this.mBaseConfig;
    }

    public final void h(final int statusId, @NotNull final Function2<? super String, ? super String, Unit> callback, final int subIndex) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.mConfigLoaded) {
            d(statusId, callback, subIndex);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.config.avatar.e
                @Override // java.lang.Runnable
                public final void run() {
                    AvatarViewConfig.i(AvatarViewConfig.this, statusId, callback, subIndex);
                }
            }, 64, null, true);
        }
    }

    public final synchronized void j(boolean forceLoad) {
        if (this.mConfigLoaded && !forceLoad) {
            return;
        }
        try {
            this.mConfigJson = new JSONObject(AvatarViewConfigLoader.INSTANCE.a().m());
            this.mBaseConfig = m();
            this.mAvatarConfigMap = l();
            QLog.i("AvatarViewConfig", 1, "loadConfig");
        } catch (Exception e16) {
            QLog.e("AvatarViewConfig", 1, "[loadConfig]: " + e16);
        }
        this.mConfigLoaded = true;
    }

    AvatarViewConfig() {
        this.mAvatarConfigMap = new HashMap<>();
    }
}
