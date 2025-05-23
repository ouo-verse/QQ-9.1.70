package com.tencent.mobileqq.cardcontainer.config;

import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.cardcontainer.config.a;
import com.tencent.mobileqq.cardcontainer.data.CardType;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\b\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0012\u0010\u0012\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/config/CardContainerConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/cardcontainer/config/a;", "", "str", "f", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "Lcom/tencent/mobileqq/cardcontainer/config/a$a;", "builder", "", "e", "g", "b", "", "content", "d", DownloadInfo.spKey_Config, "c", "<init>", "()V", "a", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class CardContainerConfigParser extends BaseConfigParser<a> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/config/CardContainerConfigParser$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.cardcontainer.config.CardContainerConfigParser$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39813);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public CardContainerConfigParser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void e(JSONObject json, a.C7444a builder) {
        try {
            JSONArray optJSONArray = json.optJSONArray("businessBlacklist");
            if (optJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    String optString = optJSONArray.optString(i3);
                    if (optString != null) {
                        Intrinsics.checkNotNullExpressionValue(optString, "optString(i)");
                        arrayList.add(optString);
                    } else {
                        QLog.w("CardContainer.ConfigParser", 1, "[parseConfig] invalid businessBlacklist item, index:" + i3);
                    }
                }
                builder.b(arrayList);
            }
        } catch (Exception e16) {
            QLog.w("CardContainer.ConfigParser", 1, "[parseBusinessBlacklist] error: " + e16);
        }
    }

    private final a f(String str) {
        a.C7444a c7444a = new a.C7444a();
        JSONObject jSONObject = new JSONObject(str);
        c7444a.c(jSONObject.optBoolean("mainSwitch", true));
        e(jSONObject, c7444a);
        g(jSONObject, c7444a);
        return c7444a.a();
    }

    private final void g(JSONObject json, a.C7444a builder) {
        try {
            JSONArray optJSONArray = json.optJSONArray("cardTypeBlacklist");
            if (optJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    String optString = optJSONArray.optString(i3);
                    if (optString != null) {
                        Intrinsics.checkNotNullExpressionValue(optString, "optString(i)");
                        CardType a16 = CardType.INSTANCE.a(optString);
                        if (a16 != CardType.Unknown) {
                            arrayList.add(a16);
                        } else {
                            QLog.w("CardContainer.ConfigParser", 1, "[parseConfig] invalid cardTypeBlacklist item: " + optString);
                        }
                    } else {
                        QLog.w("CardContainer.ConfigParser", 1, "[parseConfig] invalid cardTypeBlacklist item, index:" + i3);
                    }
                }
                builder.d(arrayList);
            }
        } catch (Exception e16) {
            QLog.w("CardContainer.ConfigParser", 1, "[parseViewTypeBlacklist] error: " + e16);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a defaultConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(@Nullable a config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) config);
            return;
        }
        super.doOnConfigUpdate(config);
        if (QLog.isColorLevel()) {
            QLog.i("CardContainer.ConfigParser", 1, "[doOnConfigUpdate] config=" + config);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public a parse(@NotNull byte[] content) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) content);
        }
        Intrinsics.checkNotNullParameter(content, "content");
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        String str = new String(content, UTF_8);
        if (TextUtils.isEmpty(str)) {
            QLog.w("CardContainer.ConfigParser", 1, "[parse] empty content");
            return defaultConfig();
        }
        try {
            return f(str);
        } catch (Throwable th5) {
            QLog.e("CardContainer.ConfigParser", 1, "[parse] exception: " + th5);
            return defaultConfig();
        }
    }
}
