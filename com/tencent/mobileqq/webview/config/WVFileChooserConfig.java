package com.tencent.mobileqq.webview.config;

import android.text.TextUtils;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0006R\u001b\u0010\u000f\u001a\u00020\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR2\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0010j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/webview/config/WVFileChooserConfig;", "Lcom/tencent/freesia/IConfigData;", "Lorg/json/JSONObject;", "jsonObj", "", "a", "", "toString", "ext", "b", "", "d", "Lkotlin/Lazy;", "c", "()Z", "switchOn", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "e", "Ljava/util/HashMap;", "ext2MimeTypes", "<init>", "()V", "f", "webview_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class WVFileChooserConfig implements IConfigData {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy switchOn;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private HashMap<String, String> ext2MimeTypes;

    public WVFileChooserConfig() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.webview.config.WVFileChooserConfig$switchOn$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("webview_filechooser_type_extension", true));
            }
        });
        this.switchOn = lazy;
        this.ext2MimeTypes = new HashMap<>();
    }

    public final void a(JSONObject jsonObj) {
        Object m476constructorimpl;
        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
        if (QLog.isColorLevel()) {
            QLog.d("WVFileChooserConfig", 2, "from json:" + jsonObj);
        }
        JSONArray optJSONArray = jsonObj.optJSONArray("ext2MimeTypes");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return;
        }
        int length = optJSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Object obj = optJSONArray.get(i3);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
                JSONObject jSONObject = (JSONObject) obj;
                String key = (String) jSONObject.keys().next();
                Object obj2 = jSONObject.get(key);
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                String str = (String) obj2;
                if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(str)) {
                    HashMap<String, String> hashMap = this.ext2MimeTypes;
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    String lowerCase = key.toLowerCase();
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
                    String lowerCase2 = str.toLowerCase();
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase()");
                    hashMap.put(lowerCase, lowerCase2);
                }
                m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            if (!Result.m483isSuccessimpl(m476constructorimpl)) {
                QLog.w("WVFileChooserConfig", 1, "parse error for " + optJSONArray.get(i3));
            }
        }
    }

    public final String b(String ext) {
        Intrinsics.checkNotNullParameter(ext, "ext");
        HashMap<String, String> hashMap = this.ext2MimeTypes;
        String lowerCase = ext.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        return hashMap.get(lowerCase);
    }

    public final boolean c() {
        return ((Boolean) this.switchOn.getValue()).booleanValue();
    }

    public String toString() {
        return "switchOn=" + c() + " types=" + this.ext2MimeTypes;
    }
}
