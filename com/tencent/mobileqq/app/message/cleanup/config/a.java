package com.tencent.mobileqq.app.message.cleanup.config;

import android.text.TextUtils;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.app.message.filescan.d;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001f\u0018\u0000 *2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b(\u0010)JR\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u000228\u0010\t\u001a4\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u0005j\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\b`\u0007H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0016RS\u0010\u0016\u001a>\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\b0\u0005j\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\b`\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015RS\u0010\u0018\u001a>\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\b0\u0005j\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\b`\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0012\u0010\u0015RS\u0010\u001b\u001a>\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\b0\u0005j\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\b`\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015RS\u0010\u001d\u001a>\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\b0\u0005j\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\b`\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0013\u001a\u0004\b\u001c\u0010\u0015RS\u0010\u001e\u001a>\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\b0\u0005j\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\b`\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015RS\u0010 \u001a>\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\b0\u0005j\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\b`\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\"\u0010'\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/app/message/cleanup/config/a;", "Lcom/tencent/freesia/IConfigData;", "", "content", "key", "Ljava/util/HashMap;", "Ljava/util/ArrayList;", "Lkotlin/collections/HashMap;", "Lkotlin/collections/ArrayList;", "whiteListMap", "", "j", "", "i", "originDir", "a", h.F, "toString", "d", "Ljava/util/HashMap;", "g", "()Ljava/util/HashMap;", "whiteList", "e", "deleteWhiteList", "f", "c", "deleteList", "getRecoveryList", "recoveryList", "reportChildBusinessList", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "reportAllChildFileList", BdhLogUtil.LogTag.Tag_Conn, "I", "b", "()I", "setCleanRestartInterval", "(I)V", "cleanRestartInterval", "<init>", "()V", "D", "storage-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a implements IConfigData {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private int cleanRestartInterval;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, ArrayList<String>> whiteList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, ArrayList<String>> deleteWhiteList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, ArrayList<String>> deleteList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, ArrayList<String>> recoveryList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, ArrayList<String>> reportChildBusinessList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, ArrayList<String>> reportAllChildFileList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/app/message/cleanup/config/a$a;", "", "", "CONFIG_ID", "Ljava/lang/String;", "CONFIG_PLACE_HOLDER_DATA_PATH", "CONFIG_PLACE_HOLDER_EXTERNAL_PATH", "CONFIG_PLACE_HOLDER_UIN", "KEY_CLEAN_RESTART_INTERVAL", "KEY_CONFIG_DELETE_LIST", "KEY_CONFIG_DELETE_WHITE_LIST", "KEY_CONFIG_RECOVERY_LIST", "KEY_CONFIG_REPORT_ALL_CHILD_FILE_LIST", "KEY_CONFIG_REPORT_CHILD_BUSINESS_LIST", "KEY_CONFIG_WHITE_LIST", "TAG", "<init>", "()V", "storage-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.app.message.cleanup.config.a$a, reason: collision with other inner class name and from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35465);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.whiteList = new HashMap<>();
        this.deleteWhiteList = new HashMap<>();
        this.deleteList = new HashMap<>();
        this.recoveryList = new HashMap<>();
        this.reportChildBusinessList = new HashMap<>();
        this.reportAllChildFileList = new HashMap<>();
        this.cleanRestartInterval = -1;
    }

    private final String a(String originDir) {
        boolean contains$default;
        boolean contains$default2;
        boolean contains$default3;
        String replace$default;
        String replace$default2;
        String str;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) originDir, (CharSequence) "$uin", false, 2, (Object) null);
        if (contains$default) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str = peekAppRuntime.getCurrentAccountUin();
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                Intrinsics.checkNotNull(str);
                originDir = StringsKt__StringsJVMKt.replace$default(originDir, "$uin", str, false, 4, (Object) null);
            }
        }
        String str2 = originDir;
        contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) "$dataPath", false, 2, (Object) null);
        if (contains$default2) {
            replace$default2 = StringsKt__StringsJVMKt.replace$default(str2, "$dataPath", d.f195978a.a(), false, 4, (Object) null);
            return replace$default2;
        }
        contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) "$externalPath", false, 2, (Object) null);
        if (contains$default3) {
            replace$default = StringsKt__StringsJVMKt.replace$default(str2, "$externalPath", d.f195978a.d(), false, 4, (Object) null);
            return replace$default;
        }
        return str2;
    }

    private final int i(String content) {
        try {
            return new JSONObject(content).optInt("clean_restart_interval", -1);
        } catch (JSONException e16) {
            QLog.e("CleanUpConfigBean", 1, e16, new Object[0]);
            return -1;
        }
    }

    private final void j(String content, String key, HashMap<String, ArrayList<String>> whiteListMap) {
        try {
            JSONObject optJSONObject = new JSONObject(content).optJSONObject(key);
            if (optJSONObject != null) {
                Iterator keys = optJSONObject.keys();
                Intrinsics.checkNotNullExpressionValue(keys, "keys()");
                while (keys.hasNext()) {
                    String key2 = (String) keys.next();
                    JSONArray optJSONArray = optJSONObject.optJSONArray(key2);
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        int length = optJSONArray.length();
                        for (int i3 = 0; i3 < length; i3++) {
                            String string = optJSONArray.getString(i3);
                            Intrinsics.checkNotNullExpressionValue(string, "configDirList.getString(index)");
                            String a16 = a(string);
                            if (!TextUtils.isEmpty(a16)) {
                                if (!whiteListMap.containsKey(key2)) {
                                    Intrinsics.checkNotNullExpressionValue(key2, "key");
                                    whiteListMap.put(key2, new ArrayList<>());
                                }
                                ArrayList<String> arrayList = whiteListMap.get(key2);
                                Intrinsics.checkNotNull(arrayList);
                                arrayList.add(a16);
                            }
                        }
                    }
                }
            }
        } catch (JSONException e16) {
            QLog.e("CleanUpConfigBean", 1, e16, new Object[0]);
        }
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.cleanRestartInterval;
    }

    @NotNull
    public final HashMap<String, ArrayList<String>> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (HashMap) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.deleteList;
    }

    @NotNull
    public final HashMap<String, ArrayList<String>> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (HashMap) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.deleteWhiteList;
    }

    @NotNull
    public final HashMap<String, ArrayList<String>> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (HashMap) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.reportAllChildFileList;
    }

    @NotNull
    public final HashMap<String, ArrayList<String>> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (HashMap) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.reportChildBusinessList;
    }

    @NotNull
    public final HashMap<String, ArrayList<String>> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (HashMap) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.whiteList;
    }

    @NotNull
    public final a h(@NotNull String content) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (a) iPatchRedirector.redirect((short) 10, (Object) this, (Object) content);
        }
        Intrinsics.checkNotNullParameter(content, "content");
        QLog.d("CleanUpConfigBean", 1, "configs parse\uff1a" + content);
        if (TextUtils.isEmpty(content)) {
            return this;
        }
        j(content, MobileQQ.PREF_WHITE_LIST_KEY, this.whiteList);
        j(content, "delete_white_list", this.deleteWhiteList);
        j(content, "delete_list", this.deleteList);
        j(content, "recovery_list", this.recoveryList);
        j(content, "report_child_business_list", this.reportChildBusinessList);
        j(content, "report_all_child_file_list", this.reportAllChildFileList);
        this.cleanRestartInterval = i(content);
        return this;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "CleanUpConfigBean(whiteList=" + this.whiteList + ", deleteWhiteList=" + this.deleteWhiteList + ')';
    }
}
