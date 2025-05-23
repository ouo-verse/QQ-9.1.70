package com.tencent.qqnt.pluspanel.config;

import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.AutoStartMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00172\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R3\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007`\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR'\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u000ej\b\u0012\u0004\u0012\u00020\u0007`\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/pluspanel/config/a;", "Lcom/tencent/freesia/IConfigData;", "", "configStr", "", "c", "Ljava/util/HashMap;", "Lcom/tencent/qqnt/pluspanel/config/b;", "Lkotlin/collections/HashMap;", "d", "Ljava/util/HashMap;", "a", "()Ljava/util/HashMap;", "appConfigMap", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "b", "()Ljava/util/ArrayList;", "appInfoList", "<init>", "()V", "f", "plus_panel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a implements IConfigData {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, b> appConfigMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<b> appInfoList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/pluspanel/config/a$a;", "", "", AutoStartMonitor.AutoStartBean.KEY_ACTION, "Ljava/lang/String;", "KEY_ACTION_TYPE", "KEY_APPID", "KEY_DYNAMIC", "KEY_ENABLE", "KEY_ICON_CONCISE_NORMAL", "KEY_ICON_NORMAL", "KEY_ICON_VIP", "KEY_REDDOT_ID", "KEY_TITLE", "KEY_VERSION", "TAG", "<init>", "()V", "plus_panel_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.pluspanel.config.a$a, reason: collision with other inner class name and from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37297);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.appConfigMap = new HashMap<>();
            this.appInfoList = new ArrayList<>();
        }
    }

    @NotNull
    public final HashMap<String, b> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (HashMap) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.appConfigMap;
    }

    @NotNull
    public final ArrayList<b> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.appInfoList;
    }

    public final void c(@NotNull String configStr) {
        String str = "";
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) configStr);
            return;
        }
        Intrinsics.checkNotNullParameter(configStr, "configStr");
        try {
            JSONArray jSONArray = new JSONArray(configStr);
            int length = jSONArray.length();
            int i3 = 0;
            while (i3 < length) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                String optString = jSONObject.optString("appid", str);
                Intrinsics.checkNotNullExpressionValue(optString, "appConfig.optString(KEY_APPID, \"\")");
                String optString2 = jSONObject.optString("title", str);
                Intrinsics.checkNotNullExpressionValue(optString2, "appConfig.optString(KEY_TITLE, \"\")");
                String optString3 = jSONObject.optString("actionType", str);
                Intrinsics.checkNotNullExpressionValue(optString3, "appConfig.optString(KEY_ACTION_TYPE, \"\")");
                String optString4 = jSONObject.optString("action", str);
                Intrinsics.checkNotNullExpressionValue(optString4, "appConfig.optString(KEY_ACTION, \"\")");
                String optString5 = jSONObject.optString("iconNormal", str);
                Intrinsics.checkNotNullExpressionValue(optString5, "appConfig.optString(KEY_ICON_NORMAL, \"\")");
                String optString6 = jSONObject.optString("iconConciseNormal", str);
                Intrinsics.checkNotNullExpressionValue(optString6, "appConfig.optString(KEY_ICON_CONCISE_NORMAL, \"\")");
                String optString7 = jSONObject.optString("iconVip", str);
                Intrinsics.checkNotNullExpressionValue(optString7, "appConfig.optString(KEY_ICON_VIP, \"\")");
                int i16 = length;
                int optInt = jSONObject.optInt("enable", 0);
                String optString8 = jSONObject.optString("redDotID", str);
                Intrinsics.checkNotNullExpressionValue(optString8, "appConfig.optString(KEY_REDDOT_ID, \"\")");
                b bVar = new b(optString, optString2, optString3, optString4, optString5, optString6, optString7, optInt, optString8, 0, null, null, null, jSONObject.optInt("version", 0), 7168, null);
                this.appConfigMap.put(bVar.j(), bVar);
                this.appInfoList.add(bVar);
                i3++;
                length = i16;
                str = str;
            }
            QLog.i("AppInfoBean", 1, "[parse]: config list size is " + this.appInfoList.size());
        } catch (Exception e16) {
            QLog.i("AppInfoBean", 1, "[parse]: " + e16);
        }
    }
}
