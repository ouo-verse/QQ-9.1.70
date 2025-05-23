package com.tencent.qqnt.pluspanel.config;

import android.text.TextUtils;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 $2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J,\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R3\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0011j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R3\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0011j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0017\u0010\u0015R3\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0011j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0019\u0010\u0015RS\u0010\u001c\u001a>\u0012\u0004\u0012\u00020\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00060\rj\b\u0012\u0004\u0012\u00020\u0006`\u000e0\u0011j\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00060\rj\b\u0012\u0004\u0012\u00020\u0006`\u000e`\u00128\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u001b\u0010\u0015RS\u0010\u001e\u001a>\u0012\u0004\u0012\u00020\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00060\rj\b\u0012\u0004\u0012\u00020\u0006`\u000e0\u0011j\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00060\rj\b\u0012\u0004\u0012\u00020\u0006`\u000e`\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0014\u001a\u0004\b\u001d\u0010\u0015RS\u0010!\u001a>\u0012\u0004\u0012\u00020\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00060\rj\b\u0012\u0004\u0012\u00020\u0006`\u000e0\u0011j\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00060\rj\b\u0012\u0004\u0012\u00020\u0006`\u000e`\u00128\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0014\u001a\u0004\b \u0010\u0015\u00a8\u0006%"}, d2 = {"Lcom/tencent/qqnt/pluspanel/config/c;", "Lcom/tencent/freesia/IConfigData;", "", "configOrder", "", "j", "", "platform", "", h.F, "Lorg/json/JSONObject;", "jsonObject", "key", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "a", "i", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "d", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "normalOrder", "e", "simpleOrder", "f", "studyOrder", "c", "normalChild", "b", "conciseChild", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g", "teenagerChild", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "plus_panel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class c implements IConfigData {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Integer, Integer> normalOrder;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Integer, Integer> simpleOrder;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Integer, Integer> studyOrder;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Integer, ArrayList<Integer>> normalChild;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Integer, ArrayList<Integer>> conciseChild;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Integer, ArrayList<Integer>> teenagerChild;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0004\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/pluspanel/config/c$a;", "", "", "KEY_APPID", "Ljava/lang/String;", "KEY_CONCISE_CHILD_LIST", "KEY_NORMAL_CHILD_LIST", "KEY_NORMAL_ORDER", "KEY_PLATFORM", "KEY_SIMPLE_ORDER", "KEY_STUDY_ORDER", "KEY_TEENAGER_CHILD_LIST", "", "PLATFORM_ALL", "I", "PLATFORM_ANDROID_FLAG", "TAG", "<init>", "()V", "plus_panel_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.pluspanel.config.c$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37318);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.normalOrder = new HashMap<>();
        this.simpleOrder = new HashMap<>();
        this.studyOrder = new HashMap<>();
        this.normalChild = new HashMap<>();
        this.conciseChild = new HashMap<>();
        this.teenagerChild = new HashMap<>();
    }

    private final ArrayList<Integer> a(JSONObject jsonObject, String key) {
        try {
            JSONArray optJSONArray = jsonObject.optJSONArray(key);
            ArrayList<Integer> arrayList = new ArrayList<>();
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    String item = optJSONArray.optString(i3);
                    if (!TextUtils.isEmpty(item)) {
                        Intrinsics.checkNotNullExpressionValue(item, "item");
                        arrayList.add(Integer.valueOf(Integer.parseInt(item)));
                    }
                }
            }
            return arrayList;
        } catch (Exception e16) {
            QLog.i("AppOrderBean", 1, "[getChildList]: " + e16);
            return null;
        }
    }

    private final boolean h(int platform) {
        if ((platform & 1) == 0) {
            return true;
        }
        return false;
    }

    private final void j(String configOrder) {
        ArrayList<Integer> a16;
        ArrayList<Integer> a17;
        ArrayList<Integer> a18;
        try {
            JSONArray jSONArray = new JSONArray(configOrder);
            if (jSONArray.length() <= 0) {
                return;
            }
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    String appIdStr = optJSONObject.optString("appid");
                    Intrinsics.checkNotNullExpressionValue(appIdStr, "appIdStr");
                    int parseInt = Integer.parseInt(appIdStr);
                    if (!h(optJSONObject.optInt("platform", 15))) {
                        if (optJSONObject.has("order")) {
                            this.normalOrder.put(Integer.valueOf(parseInt), Integer.valueOf(optJSONObject.optInt("order")));
                        }
                        if (optJSONObject.has("conciseOrder")) {
                            this.simpleOrder.put(Integer.valueOf(parseInt), Integer.valueOf(optJSONObject.optInt("conciseOrder")));
                        }
                        if (optJSONObject.has("teenagerOrder")) {
                            this.studyOrder.put(Integer.valueOf(parseInt), Integer.valueOf(optJSONObject.optInt("teenagerOrder")));
                        }
                        if (optJSONObject.has("normalChild") && (a18 = a(optJSONObject, "normalChild")) != null) {
                            this.normalChild.put(Integer.valueOf(parseInt), a18);
                        }
                        if (optJSONObject.has("conciseChild") && (a17 = a(optJSONObject, "conciseChild")) != null) {
                            this.conciseChild.put(Integer.valueOf(parseInt), a17);
                        }
                        if (optJSONObject.has("teenagerChild") && (a16 = a(optJSONObject, "teenagerChild")) != null) {
                            this.teenagerChild.put(Integer.valueOf(parseInt), a16);
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            QLog.i("AppOrderBean", 1, "[parseAppOrder]: " + th5);
        }
    }

    @NotNull
    public final HashMap<Integer, ArrayList<Integer>> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (HashMap) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.conciseChild;
    }

    @NotNull
    public final HashMap<Integer, ArrayList<Integer>> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (HashMap) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.normalChild;
    }

    @NotNull
    public final HashMap<Integer, Integer> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (HashMap) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.normalOrder;
    }

    @NotNull
    public final HashMap<Integer, Integer> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (HashMap) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.simpleOrder;
    }

    @NotNull
    public final HashMap<Integer, Integer> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (HashMap) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.studyOrder;
    }

    @NotNull
    public final HashMap<Integer, ArrayList<Integer>> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (HashMap) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.teenagerChild;
    }

    public final void i(@NotNull String configOrder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) configOrder);
            return;
        }
        Intrinsics.checkNotNullParameter(configOrder, "configOrder");
        if (!TextUtils.isEmpty(configOrder)) {
            j(configOrder);
        }
    }
}
