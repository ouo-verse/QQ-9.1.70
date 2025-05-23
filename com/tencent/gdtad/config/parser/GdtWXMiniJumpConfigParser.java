package com.tencent.gdtad.config.parser;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.gdtad.config.data.GdtWXMiniJumpConfig;
import com.tencent.gdtad.config.data.n;
import com.tencent.kuikly.core.render.android.css.ktx.b;
import com.tencent.mobileqq.kandian.base.report.ReadInJoyMMapKvStorage;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/gdtad/config/parser/GdtWXMiniJumpConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/gdtad/config/data/GdtWXMiniJumpConfig;", "c", "", "content", "d", "<init>", "()V", "a", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GdtWXMiniJumpConfigParser extends BaseConfigParser<GdtWXMiniJumpConfig> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Lazy<GdtWXMiniJumpConfig> f109159e;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u001b\u0010\b\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000bR\u0014\u0010\u0013\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0014\u0010\u0014\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000bR\u0014\u0010\u0015\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000bR\u0014\u0010\u0016\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000bR\u0014\u0010\u0017\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u000bR\u0014\u0010\u0018\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u000b\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/gdtad/config/parser/GdtWXMiniJumpConfigParser$a;", "", "Lcom/tencent/gdtad/config/data/GdtWXMiniJumpConfig;", "c", "defaultConfig$delegate", "Lkotlin/Lazy;", "b", "()Lcom/tencent/gdtad/config/data/GdtWXMiniJumpConfig;", "defaultConfig", "", "CONFIG_KEY_AD_POS_JUMP_CONFIG", "Ljava/lang/String;", "CONFIG_KEY_APP_INFO_ERROR_MESSAGE", "CONFIG_KEY_AUTH_REJECT_MESSAGE", "CONFIG_KEY_ERROR_CODE_BLACKLIST", "CONFIG_KEY_GLOBAL", "CONFIG_KEY_INSIDE_APP_WHITELIST", "CONFIG_KEY_JUMP_TYPE", "CONFIG_KEY_LOAD_ERROR_MESSAGE", "CONFIG_KEY_OUTSIDE_APP_WHITELIST", "CONFIG_KEY_POS_ID_LIST", "CONFIG_KEY_TEENAGER_ERROR_MESSAGE", "CONFIG_KEY_UPLOAD_AUTH_STATUS", "GDT_WX_MINI_JUMP_CONFIG_ID", "TAG", "<init>", "()V", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.gdtad.config.parser.GdtWXMiniJumpConfigParser$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final GdtWXMiniJumpConfig b() {
            return (GdtWXMiniJumpConfig) GdtWXMiniJumpConfigParser.f109159e.getValue();
        }

        @Nullable
        public final GdtWXMiniJumpConfig c() {
            IUnitedConfigManager iUnitedConfigManager = (IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class);
            if (iUnitedConfigManager.isSwitchOn("105814", true)) {
                GdtWXMiniJumpConfig gdtWXMiniJumpConfig = (GdtWXMiniJumpConfig) iUnitedConfigManager.loadConfig("105814");
                if (gdtWXMiniJumpConfig == null) {
                    return GdtWXMiniJumpConfigParser.INSTANCE.b();
                }
                return gdtWXMiniJumpConfig;
            }
            return null;
        }

        Companion() {
        }
    }

    static {
        Lazy<GdtWXMiniJumpConfig> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GdtWXMiniJumpConfig>() { // from class: com.tencent.gdtad.config.parser.GdtWXMiniJumpConfigParser$Companion$defaultConfig$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GdtWXMiniJumpConfig invoke() {
                Set emptySet;
                List emptyList;
                List emptyList2;
                Set emptySet2;
                emptySet = SetsKt__SetsKt.emptySet();
                int value = GdtWXMiniJumpConfig.Companion.QQMCJumpType.INVALID.getValue();
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                n nVar = new n(emptySet, value, emptyList, emptyList2, false);
                emptySet2 = SetsKt__SetsKt.emptySet();
                return new GdtWXMiniJumpConfig(nVar, emptySet2, false, "\u6388\u6743\u4e2d\u65ad\uff0c\u8bf7\u91cd\u65b0\u5c1d\u8bd5", "\u52a0\u8f7d\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", "\u9752\u5c11\u5e74\u6a21\u5f0f\u4e0b\u8be5\u5185\u5bb9\u4e0d\u53ef\u8bbf\u95ee", "\u6682\u4e0d\u652f\u6301\u6253\u5f00\u8be5\u5c0f\u7a0b\u5e8f");
            }
        });
        f109159e = lazy;
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public GdtWXMiniJumpConfig defaultConfig() {
        return INSTANCE.b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0089, code lost:
    
        if (r6 == null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00a6, code lost:
    
        if (r6 == null) goto L18;
     */
    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GdtWXMiniJumpConfig parse(@NotNull byte[] content) {
        Object m476constructorimpl;
        List<Object> emptyList;
        List<Object> emptyList2;
        Intrinsics.checkNotNullParameter(content, "content");
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        String str = new String(content, UTF_8);
        if (QLog.isColorLevel()) {
            QLog.i("GdtWXMiniJumpConfigParser", 2, "parse content: " + str);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("jump_config");
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            JSONArray jSONArray = jSONObject2.getJSONArray("pos_id_list");
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                String string = jSONArray.getString(i3);
                Intrinsics.checkNotNullExpressionValue(string, "array.getString(i)");
                linkedHashSet.add(string);
            }
            int optInt = jSONObject2.optInt("jump_type", GdtWXMiniJumpConfig.Companion.QQMCJumpType.INVALID.getValue());
            JSONArray optJSONArray = jSONObject2.optJSONArray("inside_app_whitelist");
            if (optJSONArray != null) {
                Intrinsics.checkNotNullExpressionValue(optJSONArray, "optJSONArray(CONFIG_KEY_INSIDE_APP_WHITELIST)");
                emptyList = b.F(optJSONArray);
            }
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            List<Object> list = emptyList;
            Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
            JSONArray optJSONArray2 = jSONObject2.optJSONArray("outside_app_whitelist");
            if (optJSONArray2 != null) {
                Intrinsics.checkNotNullExpressionValue(optJSONArray2, "optJSONArray(CONFIG_KEY_OUTSIDE_APP_WHITELIST)");
                emptyList2 = b.F(optJSONArray2);
            }
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            List<Object> list2 = emptyList2;
            Intrinsics.checkNotNull(list2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
            n nVar = new n(linkedHashSet, optInt, list, list2, jSONObject2.optBoolean(ReadInJoyMMapKvStorage.NAME_DEFAULT, false));
            boolean optBoolean = jSONObject.optBoolean("upload_auth_status", false);
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            JSONArray jSONArray2 = jSONObject.getJSONArray("error_code_blacklist");
            int length2 = jSONArray2.length();
            for (int i16 = 0; i16 < length2; i16++) {
                String string2 = jSONArray2.getString(i16);
                Intrinsics.checkNotNullExpressionValue(string2, "it.getString(i)");
                linkedHashSet2.add(string2);
            }
            String authRejectMsg = jSONObject.optString("auth_reject_message", "\u6388\u6743\u4e2d\u65ad\uff0c\u8bf7\u91cd\u65b0\u5c1d\u8bd5");
            String loadErrorMsg = jSONObject.optString("load_error_message", "\u52a0\u8f7d\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
            String teenagerErrorMsg = jSONObject.optString("teenager_error_message", "\u9752\u5c11\u5e74\u6a21\u5f0f\u4e0b\u8be5\u5185\u5bb9\u4e0d\u53ef\u8bbf\u95ee");
            String appInfoErrorMsg = jSONObject.optString("app_info_error_message", "\u6682\u4e0d\u652f\u6301\u6253\u5f00\u8be5\u5c0f\u7a0b\u5e8f");
            Intrinsics.checkNotNullExpressionValue(authRejectMsg, "authRejectMsg");
            Intrinsics.checkNotNullExpressionValue(loadErrorMsg, "loadErrorMsg");
            Intrinsics.checkNotNullExpressionValue(teenagerErrorMsg, "teenagerErrorMsg");
            Intrinsics.checkNotNullExpressionValue(appInfoErrorMsg, "appInfoErrorMsg");
            m476constructorimpl = Result.m476constructorimpl(new GdtWXMiniJumpConfig(nVar, linkedHashSet2, optBoolean, authRejectMsg, loadErrorMsg, teenagerErrorMsg, appInfoErrorMsg));
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            QLog.e("GdtWXMiniJumpConfigParser", 2, m479exceptionOrNullimpl, new Object[0]);
        }
        if (Result.m479exceptionOrNullimpl(m476constructorimpl) != null) {
            m476constructorimpl = defaultConfig();
        }
        return (GdtWXMiniJumpConfig) m476constructorimpl;
    }
}
