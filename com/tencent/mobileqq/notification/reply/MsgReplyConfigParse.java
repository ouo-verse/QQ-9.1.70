package com.tencent.mobileqq.notification.reply;

import com.tencent.ark.ark;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/notification/reply/MsgReplyConfigParse;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/notification/reply/a;", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "", "Lcom/tencent/mobileqq/notification/reply/b;", "f", "", "", "e", "b", "", "content", "d", DownloadInfo.spKey_Config, "", "c", "<init>", "()V", "a", "qq_notification_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class MsgReplyConfigParse extends BaseConfigParser<a> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/notification/reply/MsgReplyConfigParse$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq_notification_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.notification.reply.MsgReplyConfigParse$a, reason: from kotlin metadata */
    /* loaded from: classes8.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24471);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public MsgReplyConfigParse() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final List<Integer> e(JSONObject json) {
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = json.optJSONArray("chatTypeWhiteList");
        if (optJSONArray != null) {
            Intrinsics.checkNotNullExpressionValue(optJSONArray, "optJSONArray(\"chatTypeWhiteList\")");
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                int optInt = optJSONArray.optInt(i3, -1);
                if (optInt != -1) {
                    arrayList.add(Integer.valueOf(optInt));
                }
            }
        }
        return arrayList;
    }

    private final List<b> f(JSONObject json) {
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = json.optJSONArray("deviceBlackList");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    Intrinsics.checkNotNullExpressionValue(optJSONObject, "optJSONObject(i)");
                    String manufacturer = optJSONObject.optString("manufacturer", "");
                    String model = optJSONObject.optString("model", "");
                    int optInt = optJSONObject.optInt("apiLevel", 0);
                    Intrinsics.checkNotNullExpressionValue(manufacturer, "manufacturer");
                    Intrinsics.checkNotNullExpressionValue(model, "model");
                    arrayList.add(new b(manufacturer, model, optInt));
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a defaultConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return a.INSTANCE.a();
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
        QLog.i("MsgReply.ConfigParse", 1, "[doOnConfigUpdate] config=" + config);
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
        try {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            JSONObject jSONObject = new JSONObject(new String(content, UTF_8));
            a aVar = new a(jSONObject.optInt("minApiLevel", 0), f(jSONObject), e(jSONObject));
            QLog.i("MsgReply.ConfigParse", 1, "[parse] config=" + aVar);
            return aVar;
        } catch (Exception e16) {
            QLog.w("MsgReply.ConfigParse", 1, "[parse] error", e16);
            return a.INSTANCE.a();
        }
    }
}
