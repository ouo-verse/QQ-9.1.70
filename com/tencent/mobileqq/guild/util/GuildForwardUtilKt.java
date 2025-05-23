package com.tencent.mobileqq.guild.util;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.feed.api.SharePublishGuildFeedParam;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001a\f\u0010\u0007\u001a\u0004\u0018\u00010\u0006*\u00020\u0005\u001a\u0012\u0010\u000b\u001a\u00020\n*\u00020\b2\u0006\u0010\t\u001a\u00020\u0006\u001a\f\u0010\f\u001a\u0004\u0018\u00010\u0006*\u00020\u0005\u001a\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u0006*\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u0005\u001a\u000e\u0010\u0010\u001a\u00020\u000f*\u0004\u0018\u00010\u000fH\u0002\u001a\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000f*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000fH\u0002\u001a\f\u0010\u0014\u001a\u00020\u0013*\u00020\u0003H\u0002\"-\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00160\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\";\u0010\u001f\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u001c0\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\u00a8\u0006 "}, d2 = {"Lorg/json/JSONObject;", "Lcom/tencent/mobileqq/guild/util/bn;", "keys", "Lcom/tencent/mobileqq/guild/feed/api/SharePublishGuildFeedParam$LinkTypeParam;", "e", "Landroid/os/Bundle;", "Lcom/tencent/mobileqq/guild/feed/api/SharePublishGuildFeedParam;", tl.h.F, "Landroid/content/Intent;", "param", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g", "bundle", "i", "", "d", "defaultKey", DomainData.DOMAIN_NAME, "", "k", "", "", "a", "Lkotlin/Lazy;", "f", "()Ljava/util/Map;", "ARK2LINK_TEMPLATE", "Lkotlin/Function2;", "b", "l", "SPECIAL_ARK2LINK_TEMPLATE", "qqguild-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildForwardUtilKt {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Lazy f235341a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Lazy f235342b;

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Map<String, ? extends KeyForLinkParam[]>>() { // from class: com.tencent.mobileqq.guild.util.GuildForwardUtilKt$ARK2LINK_TEMPLATE$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<String, ? extends KeyForLinkParam[]> invoke() {
                Map<String, ? extends KeyForLinkParam[]> mapOf;
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("news", new KeyForLinkParam[]{new KeyForLinkParam(WadlProxyConsts.KEY_JUMP_URL, "preview", "title", "desc")}), TuplesKt.to("music", new KeyForLinkParam[]{new KeyForLinkParam(WadlProxyConsts.KEY_JUMP_URL, "preview", "title", "desc")}), TuplesKt.to("eventshare", new KeyForLinkParam[]{new KeyForLinkParam(WadlProxyConsts.KEY_JUMP_URL, "preview", "title", "desc")}), TuplesKt.to("video", new KeyForLinkParam[]{new KeyForLinkParam(WadlProxyConsts.KEY_JUMP_URL, "preview", "title", "desc")}), TuplesKt.to("miniapp", new KeyForLinkParam[]{new KeyForLinkParam(WadlProxyConsts.KEY_JUMP_URL, "preview", "title", "desc")}), TuplesKt.to("contact", new KeyForLinkParam[]{new KeyForLinkParam(WadlProxyConsts.KEY_JUMP_URL, "avatar", "nickname", "contact"), new KeyForLinkParam(WadlProxyConsts.KEY_JUMP_URL, "preview", "title", "desc")}), TuplesKt.to("detail_1", new KeyForLinkParam[]{new KeyForLinkParam("url", "preview", "title", "desc")}), TuplesKt.to("feed", new KeyForLinkParam[]{new KeyForLinkParam(WadlProxyConsts.KEY_JUMP_URL, "cover", "title", "tagName"), new KeyForLinkParam(WadlProxyConsts.KEY_JUMP_URL, "cover", "content", "tagName")}));
                return mapOf;
            }
        });
        f235341a = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Map<String, ? extends Function2<? super JSONObject, ? super Bundle, ? extends SharePublishGuildFeedParam>>>() { // from class: com.tencent.mobileqq.guild.util.GuildForwardUtilKt$SPECIAL_ARK2LINK_TEMPLATE$2

            @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0096\u0002\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/util/GuildForwardUtilKt$SPECIAL_ARK2LINK_TEMPLATE$2$a", "Lkotlin/Function2;", "Lorg/json/JSONObject;", "Landroid/os/Bundle;", "Lcom/tencent/mobileqq/guild/feed/api/SharePublishGuildFeedParam;", "jsonData", "bundle", "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes14.dex */
            public static final class a implements Function2<JSONObject, Bundle, SharePublishGuildFeedParam> {
                a() {
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public SharePublishGuildFeedParam invoke(@NotNull JSONObject jsonData, @NotNull Bundle bundle) {
                    SharePublishGuildFeedParam.LinkTypeParam e16;
                    String n3;
                    boolean z16;
                    JSONObject optJSONObject;
                    JSONArray optJSONArray;
                    JSONObject optJSONObject2;
                    JSONObject optJSONObject3;
                    String optString;
                    String d16;
                    String d17;
                    JSONObject optJSONObject4;
                    Intrinsics.checkNotNullParameter(jsonData, "jsonData");
                    Intrinsics.checkNotNullParameter(bundle, "bundle");
                    if (!jsonData.has(CGNonAgeReport.EVENT_CHANNEL) || !jsonData.has("feed")) {
                        e16 = GuildForwardUtilKt.e(jsonData, new KeyForLinkParam("jump_url", "url", "title", "desc"));
                        return e16;
                    }
                    n3 = GuildForwardUtilKt.n(jsonData, "jump_url");
                    boolean z17 = true;
                    if (n3 != null && n3.length() != 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    String str = null;
                    if (z16 || (optJSONObject = jsonData.optJSONObject("feed")) == null) {
                        return null;
                    }
                    if (optJSONObject.has("images")) {
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("images");
                        if (optJSONArray2 != null && (optJSONObject4 = optJSONArray2.optJSONObject(0)) != null) {
                            optString = optJSONObject4.optString("pic_url");
                        }
                        optString = null;
                    } else {
                        if (optJSONObject.has("videos") && (optJSONArray = optJSONObject.optJSONArray("videos")) != null && (optJSONObject2 = optJSONArray.optJSONObject(0)) != null && (optJSONObject3 = optJSONObject2.optJSONObject("cover")) != null) {
                            optString = optJSONObject3.optString("pic_url");
                        }
                        optString = null;
                    }
                    if (optString != null && optString.length() != 0) {
                        z17 = false;
                    }
                    if (z17) {
                        JSONObject optJSONObject5 = jsonData.optJSONObject(CGNonAgeReport.EVENT_CHANNEL);
                        if (optJSONObject5 != null) {
                            str = optJSONObject5.optString("guild_icon");
                        }
                        optString = str;
                    }
                    String title = bundle.getString("forward_ark_app_prompt", "");
                    String desc = bundle.getString(AppConstants.Key.FORWARD_ARK_APP_DESC, "");
                    d16 = GuildForwardUtilKt.d(n3);
                    d17 = GuildForwardUtilKt.d(optString);
                    Intrinsics.checkNotNullExpressionValue(title, "title");
                    Intrinsics.checkNotNullExpressionValue(desc, "desc");
                    return new SharePublishGuildFeedParam.LinkTypeParam(d16, d17, title, desc);
                }
            }

            @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0096\u0002\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/util/GuildForwardUtilKt$SPECIAL_ARK2LINK_TEMPLATE$2$b", "Lkotlin/Function2;", "Lorg/json/JSONObject;", "Landroid/os/Bundle;", "Lcom/tencent/mobileqq/guild/feed/api/SharePublishGuildFeedParam;", "jsonData", "bundle", "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes14.dex */
            public static final class b implements Function2<JSONObject, Bundle, SharePublishGuildFeedParam> {
                b() {
                }

                @Override // kotlin.jvm.functions.Function2
                @Nullable
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public SharePublishGuildFeedParam invoke(@NotNull JSONObject jsonData, @NotNull Bundle bundle) {
                    boolean z16;
                    String d16;
                    String d17;
                    Intrinsics.checkNotNullParameter(jsonData, "jsonData");
                    Intrinsics.checkNotNullParameter(bundle, "bundle");
                    String string = bundle.getString(AppConstants.Key.FORWARD_ARK_H5_FROM_JS, "");
                    if (string != null && string.length() != 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (z16) {
                        return null;
                    }
                    String optString = jsonData.optString("appicon");
                    String title = bundle.getString("forward_ark_app_prompt", "");
                    String desc = bundle.getString(AppConstants.Key.FORWARD_ARK_APP_DESC, "");
                    d16 = GuildForwardUtilKt.d(string);
                    d17 = GuildForwardUtilKt.d(optString);
                    Intrinsics.checkNotNullExpressionValue(title, "title");
                    Intrinsics.checkNotNullExpressionValue(desc, "desc");
                    return new SharePublishGuildFeedParam.LinkTypeParam(d16, d17, title, desc);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<String, ? extends Function2<? super JSONObject, ? super Bundle, ? extends SharePublishGuildFeedParam>> invoke() {
                Map<String, ? extends Function2<? super JSONObject, ? super Bundle, ? extends SharePublishGuildFeedParam>> mapOf;
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("detail", new a()), TuplesKt.to("gamesharetuwen", new b()));
                return mapOf;
            }
        });
        f235342b = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006f, code lost:
    
        if (r0 == true) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000f, code lost:
    
        r2 = kotlin.text.StringsKt___StringsKt.take(r7, 8);
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String d(String str) {
        String str2;
        String str3;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean startsWith$default3;
        boolean startsWith$default4;
        String take;
        CharSequence trim;
        if (str != null) {
            trim = StringsKt__StringsKt.trim((CharSequence) str);
            str2 = trim.toString();
        } else {
            str2 = null;
        }
        if (str != null && take != null) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            str3 = take.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(str3, "this as java.lang.String).toLowerCase(locale)");
        } else {
            str3 = null;
        }
        if (!TextUtils.isEmpty(str3)) {
            boolean z19 = true;
            if (str3 != null) {
                startsWith$default4 = StringsKt__StringsJVMKt.startsWith$default(str3, SchemaUtils.SCHEMA_MQQAPI, false, 2, null);
                if (startsWith$default4) {
                    z16 = true;
                    if (!z16) {
                        if (str3 != null) {
                            startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(str3, "mqq", false, 2, null);
                            if (startsWith$default3) {
                                z17 = true;
                                if (!z17) {
                                    if (str3 != null) {
                                        startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(str3, "http://", false, 2, null);
                                        if (startsWith$default2) {
                                            z18 = true;
                                            if (!z18) {
                                                if (str3 != null) {
                                                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str3, "https://", false, 2, null);
                                                }
                                                z19 = false;
                                                if (!z19) {
                                                    return "https://" + str2;
                                                }
                                            }
                                        }
                                    }
                                    z18 = false;
                                    if (!z18) {
                                    }
                                }
                            }
                        }
                        z17 = false;
                        if (!z17) {
                        }
                    }
                }
            }
            z16 = false;
            if (!z16) {
            }
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SharePublishGuildFeedParam.LinkTypeParam e(JSONObject jSONObject, KeyForLinkParam keyForLinkParam) {
        String str;
        boolean z16;
        String n3 = n(jSONObject, keyForLinkParam.getJumpUrlKey());
        if (n3 != null) {
            str = d(n3);
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        String d16 = d(jSONObject.optString(keyForLinkParam.getPreviewKey()));
        String optString = jSONObject.optString(keyForLinkParam.getTitleKey());
        Intrinsics.checkNotNullExpressionValue(optString, "optString(keys.titleKey)");
        String optString2 = jSONObject.optString(keyForLinkParam.getDescKey());
        Intrinsics.checkNotNullExpressionValue(optString2, "optString(keys.descKey)");
        return new SharePublishGuildFeedParam.LinkTypeParam(str, d16, optString, optString2);
    }

    private static final Map<String, KeyForLinkParam[]> f() {
        return (Map) f235341a.getValue();
    }

    @Nullable
    public static final SharePublishGuildFeedParam g(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        String string = bundle.getString("forward_ark_app_meta", "");
        Intrinsics.checkNotNullExpressionValue(string, "getString(AppConstants.K\u2026FORWARD_ARK_APP_META, \"\")");
        if (TextUtils.isEmpty(string)) {
            QLog.e("GuildForwardUtil", 1, "empty meta info");
            return null;
        }
        return i(new JSONObject(string), bundle);
    }

    @Nullable
    public static final SharePublishGuildFeedParam h(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Serializable serializable = bundle.getSerializable(AppConstants.Key.GUILD_SHARE_PUBLISH_FEED_PARAM);
        if (serializable instanceof SharePublishGuildFeedParam) {
            return (SharePublishGuildFeedParam) serializable;
        }
        return null;
    }

    @Nullable
    public static final SharePublishGuildFeedParam i(@NotNull JSONObject jSONObject, @NotNull Bundle bundle) {
        SharePublishGuildFeedParam invoke;
        int i3;
        boolean z16;
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Iterator keys = jSONObject.keys();
        Intrinsics.checkNotNull(keys, "null cannot be cast to non-null type kotlin.collections.Iterator<kotlin.String>");
        JSONObject jSONObject2 = null;
        while (keys.hasNext()) {
            String str = (String) keys.next();
            JSONObject optJSONObject = jSONObject.optJSONObject(str);
            if (optJSONObject != null) {
                KeyForLinkParam[] keyForLinkParamArr = f().get(str);
                boolean z17 = true;
                if (keyForLinkParamArr != null) {
                    if (keyForLinkParamArr.length == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        z17 = false;
                    }
                }
                if (!z17) {
                    SharePublishGuildFeedParam.LinkTypeParam linkTypeParam = null;
                    for (KeyForLinkParam keyForLinkParam : keyForLinkParamArr) {
                        SharePublishGuildFeedParam.LinkTypeParam e16 = e(optJSONObject, keyForLinkParam);
                        if (e16 != null) {
                            int k3 = k(e16);
                            if (linkTypeParam != null) {
                                i3 = k(linkTypeParam);
                            } else {
                                i3 = 0;
                            }
                            if (k3 > i3) {
                                linkTypeParam = e16;
                            }
                        }
                    }
                    if (linkTypeParam != null) {
                        return linkTypeParam;
                    }
                }
                Function2<JSONObject, Bundle, SharePublishGuildFeedParam> function2 = l().get(str);
                if (function2 != null && (invoke = function2.invoke(optJSONObject, bundle)) != null) {
                    return invoke;
                }
                jSONObject2 = optJSONObject;
            }
        }
        if (jSONObject2 == null) {
            return null;
        }
        return e(jSONObject2, new KeyForLinkParam(WadlProxyConsts.KEY_JUMP_URL, "preview", "title", "desc"));
    }

    public static /* synthetic */ SharePublishGuildFeedParam j(JSONObject jSONObject, Bundle EMPTY, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            EMPTY = Bundle.EMPTY;
            Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
        }
        return i(jSONObject, EMPTY);
    }

    private static final int k(SharePublishGuildFeedParam.LinkTypeParam linkTypeParam) {
        int i3;
        boolean z16;
        boolean z17;
        boolean z18 = false;
        if (linkTypeParam.getUrl().length() > 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (linkTypeParam.getImageUrl().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i3++;
        }
        if (linkTypeParam.getTitle().length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            i3++;
        }
        if (linkTypeParam.getDesc().length() > 0) {
            z18 = true;
        }
        if (z18) {
            return i3 + 1;
        }
        return i3;
    }

    private static final Map<String, Function2<JSONObject, Bundle, SharePublishGuildFeedParam>> l() {
        return (Map) f235342b.getValue();
    }

    public static final void m(@NotNull Intent intent, @NotNull SharePublishGuildFeedParam param) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        Intrinsics.checkNotNullParameter(param, "param");
        intent.putExtra(AppConstants.Key.GUILD_SHARE_PUBLISH_FEED_PARAM, param);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String n(JSONObject jSONObject, String str) {
        boolean z16;
        String url = jSONObject.optString(str);
        Intrinsics.checkNotNullExpressionValue(url, "url");
        if (url.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return url;
        }
        String[] strArr = {WadlProxyConsts.KEY_JUMP_URL, "jumpURL", "jump_url", "url", "qqdocurl"};
        for (int i3 = 0; i3 < 5; i3++) {
            String optString = jSONObject.optString(strArr[i3]);
            if (!TextUtils.isEmpty(optString)) {
                return optString;
            }
        }
        return null;
    }
}
