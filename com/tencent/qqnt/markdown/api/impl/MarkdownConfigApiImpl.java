package com.tencent.qqnt.markdown.api.impl;

import com.tencent.android.androidbypass.e;
import com.tencent.android.androidbypass.parser.api.b;
import com.tencent.biz.richframework.ext.RFWStringsKt;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.markdown.api.IMarkdownConfigApi;
import com.tencent.qqnt.markdown.whitelist.a;
import com.tencent.qqnt.markdown.whitelist.c;
import com.tencent.qqnt.markdown.whitelist.d;
import com.tencent.qqnt.markdown.whitelist.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\u000b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u001d\u0010\u000e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\f2\u0006\u0010\r\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fR$\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0010j\b\u0012\u0004\u0012\u00020\b`\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/markdown/api/impl/MarkdownConfigApiImpl;", "Lcom/tencent/qqnt/markdown/api/IMarkdownConfigApi;", "Lcom/tencent/qqnt/markdown/whitelist/a$a;", "info", "", "isVersionSupport", "Lcom/tencent/qqnt/markdown/whitelist/a;", "getWhiteListBean", "", "url", "enableBypassWhenNotHit", "isWhiteListScheme", "T", "wrappedListener", "getWhitelistedSchemeClickListener", "(Ljava/lang/Object;)Ljava/lang/Object;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "presetWhitelistSchemes", "Ljava/util/ArrayList;", "<init>", "()V", "Companion", "a", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class MarkdownConfigApiImpl implements IMarkdownConfigApi {
    static IPatchRedirector $redirector_ = null;

    @Deprecated
    @NotNull
    private static final String CONFIG_ID_102890 = "102890";

    @NotNull
    private static final a Companion;

    @Deprecated
    @NotNull
    private static final String KEY_MIN_VERSION = "min_version";

    @Deprecated
    @NotNull
    private static final String KEY_SCHEME = "scheme";

    @Deprecated
    @NotNull
    private static final String KEY_SCHEME_WHITE_INFO_LIST = "scheme_info_list";

    @Deprecated
    @NotNull
    public static final String KEY_SCHEME_WHITE_LIST = "schemes";

    @Deprecated
    @NotNull
    private static final String TAG = "MarkdownConfigApi";

    @NotNull
    private final ArrayList<String> presetWhitelistSchemes;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/markdown/api/impl/MarkdownConfigApiImpl$a;", "", "", "CONFIG_ID_102890", "Ljava/lang/String;", "KEY_MIN_VERSION", "KEY_SCHEME", "KEY_SCHEME_WHITE_INFO_LIST", "KEY_SCHEME_WHITE_LIST", "TAG", "<init>", "()V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31409);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            Companion = new a(null);
        }
    }

    public MarkdownConfigApiImpl() {
        ArrayList<String> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("mqqapi://guild/edit_channel_home", "mqqapi://guild/edit_guest_view", "mqqapi://guild/call_team", "mqqapi://guild/share_guild", "mqqapi://guild/copy_guild_number", "mqqapi://guild/generate_guild_qrcode", "mqqapi://guild/remove_channel", "mqqapi://guild/openProfileCard", "mqqapi://guild/open_guild_profile", "mqqapi://guild/mange_risk_member", "mqqapi://guild/invite_friends", "mqqapi://guild/setting_super_administrator", "mqqapi://guild/join_official_choiceness_guild", "mqqapi://guild/assistance", "mqqapi://guild/open_url", "mqqapi://guild/appointment_reminder", "mqqrouter://flash_transfer/");
            this.presetWhitelistSchemes = arrayListOf;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final com.tencent.qqnt.markdown.whitelist.a getWhiteListBean() {
        boolean z16;
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(CONFIG_ID_102890, "");
        if (loadAsString.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return new com.tencent.qqnt.markdown.whitelist.a(this.presetWhitelistSchemes, new ArrayList());
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(loadAsString);
            JSONArray optJSONArray = jSONObject.optJSONArray(KEY_SCHEME_WHITE_LIST);
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    arrayList.add(optJSONArray.getString(i3));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray(KEY_SCHEME_WHITE_INFO_LIST);
            if (optJSONArray2 != null) {
                int length2 = optJSONArray2.length();
                for (int i16 = 0; i16 < length2; i16++) {
                    JSONObject jSONObject2 = optJSONArray2.getJSONObject(i16);
                    String scheme = jSONObject2.getString("scheme");
                    String version = jSONObject2.getString(KEY_MIN_VERSION);
                    Intrinsics.checkNotNullExpressionValue(scheme, "scheme");
                    Intrinsics.checkNotNullExpressionValue(version, "version");
                    arrayList2.add(new a.C9650a(scheme, version));
                }
            }
        } catch (JSONException e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
        return new com.tencent.qqnt.markdown.whitelist.a(arrayList, arrayList2);
    }

    private final boolean isVersionSupport(a.C9650a info) {
        boolean z16;
        List split$default;
        List split$default2;
        int i3;
        int i16;
        if (info.b().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        String qqVersion = AppSetting.f99551k;
        QLog.d(TAG, 1, "isVersionSupport " + info.b() + " qq=" + qqVersion);
        Intrinsics.checkNotNullExpressionValue(qqVersion, "qqVersion");
        split$default = StringsKt__StringsKt.split$default((CharSequence) qqVersion, new char[]{'.'}, false, 0, 6, (Object) null);
        split$default2 = StringsKt__StringsKt.split$default((CharSequence) info.b(), new char[]{'.'}, false, 0, 6, (Object) null);
        int max = Math.max(split$default.size(), split$default2.size());
        for (int i17 = 0; i17 < max; i17++) {
            if (split$default.size() > i17) {
                i3 = RFWStringsKt.toIntOrDefault$default((String) split$default.get(i17), 0, 0, 2, null);
            } else {
                i3 = 0;
            }
            if (split$default2.size() > i17) {
                i16 = RFWStringsKt.toIntOrDefault$default((String) split$default2.get(i17), 0, 0, 2, null);
            } else {
                i16 = 0;
            }
            if (i3 != i16) {
                if (i3 > i16) {
                    return true;
                }
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.markdown.api.IMarkdownConfigApi
    public <T> T getWhitelistedSchemeClickListener(T wrappedListener) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (T) iPatchRedirector.redirect((short) 3, (Object) this, (Object) wrappedListener);
        }
        if (wrappedListener instanceof e) {
            obj = new c((e) wrappedListener);
        } else if (wrappedListener instanceof b) {
            obj = new f((b) wrappedListener);
        } else if (wrappedListener instanceof com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b) {
            obj = new d((com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b) wrappedListener);
        } else if (wrappedListener instanceof tt.a) {
            obj = new com.tencent.qqnt.markdown.whitelist.e((tt.a) wrappedListener);
        } else {
            return wrappedListener;
        }
        return obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004f, code lost:
    
        if (r0 != false) goto L22;
     */
    @Override // com.tencent.qqnt.markdown.api.IMarkdownConfigApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isWhiteListScheme(@Nullable String url, boolean enableBypassWhenNotHit) {
        boolean z16;
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean z17;
        boolean startsWith$default3;
        boolean z18;
        boolean startsWith$default4;
        boolean startsWith$default5;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z19 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, url, Boolean.valueOf(enableBypassWhenNotHit))).booleanValue();
        }
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, SchemaUtils.SCHEMA_MQQAPI, false, 2, null);
            if (!startsWith$default) {
                startsWith$default4 = StringsKt__StringsJVMKt.startsWith$default(url, "mqqguild", false, 2, null);
                if (!startsWith$default4) {
                    startsWith$default5 = StringsKt__StringsJVMKt.startsWith$default(url, "mqqrouter", false, 2, null);
                }
            }
            com.tencent.qqnt.markdown.whitelist.a whiteListBean = getWhiteListBean();
            List<String> b16 = whiteListBean.b();
            if (!enableBypassWhenNotHit || b16 != this.presetWhitelistSchemes) {
                List<String> list = b16;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(url, (String) it.next(), false, 2, null);
                        if (startsWith$default2) {
                            z17 = true;
                            break;
                        }
                    }
                }
                z17 = false;
                if (!z17) {
                    List<a.C9650a> a16 = whiteListBean.a();
                    if (!(a16 instanceof Collection) || !a16.isEmpty()) {
                        for (a.C9650a c9650a : a16) {
                            startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(url, c9650a.a(), false, 2, null);
                            if (startsWith$default3 && isVersionSupport(c9650a)) {
                                z18 = true;
                            } else {
                                z18 = false;
                            }
                            if (z18) {
                            }
                        }
                    }
                }
            }
            z19 = true;
            break;
        }
        if (!z19) {
            QLog.d(TAG, 1, "[isWhiteListScheme]|not match: " + url);
        }
        return z19;
    }
}
