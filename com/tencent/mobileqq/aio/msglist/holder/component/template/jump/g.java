package com.tencent.mobileqq.aio.msglist.holder.component.template.jump;

import com.tencent.mobileqq.aio.msg.TemplateMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.template.common.m;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u0006H\u0002J\u001a\u0010\u0016\u001a\u00020\u0006*\u00020\u00022\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006R\u0017\u0010\u001d\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/jump/g;", "", "Lorg/json/JSONObject;", "metaJson", "", "e", "", "originUrl", "b", h.F, "c", "defaultToast", "d", "i", "targetVersion", "", "a", "(Ljava/lang/String;)Ljava/lang/Integer;", "version", "", "k", "keyList", "j", "f", "g", "Lcom/tencent/mobileqq/aio/msg/TemplateMsgItem;", "Lcom/tencent/mobileqq/aio/msg/TemplateMsgItem;", "getMsgItem", "()Lcom/tencent/mobileqq/aio/msg/TemplateMsgItem;", "msgItem", "<init>", "(Lcom/tencent/mobileqq/aio/msg/TemplateMsgItem;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final List<String> f191952c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final List<String> f191953d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final String f191954e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final List<String> f191955f;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TemplateMsgItem msgItem;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/template/jump/g$a;", "", "", "DEFAULT_TOAST_STRING_FOR_HIGH_VERSION", "Ljava/lang/String;", "DEFAULT_TOAST_STRING_FOR_LOW_VERSION", "", "KEYS_OLD_HIGH_URL", "Ljava/util/List;", "KEYS_OLD_TOAST", "KEYS_OLD_VERSION", "KEY_LEGACY_TOAST", "KEY_LEGACY_URL", "KEY_LEGACY_VERSION", "KEY_OLD_LOW_URL", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.template.jump.g$a, reason: from kotlin metadata */
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
        List<String> listOf;
        List<String> listOf2;
        List<String> listOf3;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63497);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        INSTANCE = new Companion(null);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"highJumpURL", "highJumpUrl"});
        f191952c = listOf;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"jumpURLToastText", "jumpUrlToastText"});
        f191953d = listOf2;
        f191954e = "jumpUrlBak";
        listOf3 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"jumpURLVersion", "jumpUrlVersion"});
        f191955f = listOf3;
    }

    public g(@NotNull TemplateMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgItem);
        } else {
            this.msgItem = msgItem;
        }
    }

    private final Integer a(String targetVersion) {
        String currentVersion = com.tencent.qqnt.util.b.f362976b.getSubVersion();
        Intrinsics.checkNotNullExpressionValue(currentVersion, "currentVersion");
        List<Integer> k3 = k(currentVersion);
        if (k3 == null) {
            QLog.e("TemMsg.Url", 1, "illegal current version:" + currentVersion);
            return null;
        }
        List<Integer> k16 = k(targetVersion);
        if (k16 == null) {
            QLog.e("TemMsg.Url", 1, "illegal current version:" + targetVersion);
            return null;
        }
        for (int i3 = 0; i3 < 3; i3++) {
            if (k3.get(i3).intValue() > k16.get(i3).intValue()) {
                return 1;
            }
            if (k3.get(i3).intValue() < k16.get(i3).intValue()) {
                return -1;
            }
        }
        return 0;
    }

    private final String b(String originUrl, JSONObject metaJson) {
        if (f(metaJson)) {
            if (h()) {
                return originUrl;
            }
            String j3 = j(metaJson, f191952c);
            QLog.d("TemMsg.Url", 1, "use oldHighUrl");
            return j3;
        }
        return originUrl;
    }

    private final String c(String originUrl, JSONObject metaJson) {
        if (e(metaJson)) {
            QLog.d("TemMsg.Url", 1, "haveLegacyVersion");
            String optString = metaJson.optString("legacyUrl");
            Intrinsics.checkNotNullExpressionValue(optString, "metaJson.optString(KEY_LEGACY_URL)");
            return optString;
        }
        if (f(metaJson) && h()) {
            QLog.d("TemMsg.Url", 1, "haveOldLegacyVersion and shouldHaveUrlBak");
            String lowUrl = metaJson.optString(f191954e);
            Intrinsics.checkNotNullExpressionValue(lowUrl, "lowUrl");
            return lowUrl;
        }
        return originUrl;
    }

    private final String d(JSONObject metaJson, String defaultToast) {
        boolean z16;
        ArrayList arrayList = new ArrayList();
        arrayList.add("legacyToast");
        arrayList.addAll(f191953d);
        Unit unit = Unit.INSTANCE;
        String j3 = j(metaJson, arrayList);
        if (j3.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return j3;
        }
        return defaultToast;
    }

    private final boolean e(JSONObject metaJson) {
        return metaJson.has("legacyVersion");
    }

    private final boolean f(JSONObject metaJson) {
        Iterator<String> it = f191955f.iterator();
        while (it.hasNext()) {
            if (metaJson.has(it.next())) {
                return true;
            }
        }
        return false;
    }

    private final boolean h() {
        String str;
        com.tencent.mobileqq.aio.msg.template.d n26 = this.msgItem.n2();
        if (n26 != null) {
            str = n26.a();
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual(str, "com.tencent.video.lua") && !Intrinsics.areEqual(str, "com.tencent.contact.lua")) {
            return false;
        }
        return true;
    }

    private final String i(String originUrl, JSONObject metaJson) {
        boolean z16;
        ArrayList arrayList = new ArrayList();
        arrayList.add("legacyVersion");
        arrayList.addAll(f191955f);
        Unit unit = Unit.INSTANCE;
        String j3 = j(metaJson, arrayList);
        boolean z17 = false;
        if (j3.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.d("TemMsg.Url", 1, "targetVersion is empty, use origin url");
            return originUrl;
        }
        Integer a16 = a(j3);
        if (a16 != null) {
            int intValue = a16.intValue();
            String b16 = b(originUrl, metaJson);
            if (intValue >= 0) {
                if (b16.length() == 0) {
                    z17 = true;
                }
                if (z17) {
                    QQToastUtil.showQQToast(-1, d(metaJson, "\u6682\u4e0d\u652f\u6301\u8df3\u8f6c"));
                }
                return b16;
            }
            String c16 = c(originUrl, metaJson);
            if (c16.length() == 0) {
                z17 = true;
            }
            if (z17) {
                QQToastUtil.showQQToast(-1, d(metaJson, "\u8bf7\u5347\u7ea7QQ\u7248\u672c"));
            }
            return c16;
        }
        QLog.e("TemMsg.Url", 1, "illegal version:" + j3);
        return originUrl;
    }

    private final String j(JSONObject jSONObject, List<String> list) {
        boolean z16;
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String optString = jSONObject.optString(it.next());
            Intrinsics.checkNotNullExpressionValue(optString, "this.optString(key)");
            if (optString.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return optString;
            }
        }
        return "";
    }

    private final List<Integer> k(String version) {
        List split$default;
        int collectionSizeOrDefault;
        Integer intOrNull;
        boolean z16;
        split$default = StringsKt__StringsKt.split$default((CharSequence) version, new char[]{'.'}, false, 0, 6, (Object) null);
        if (split$default.size() != 3) {
            return null;
        }
        List list = split$default;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull((String) it.next());
            if (intOrNull != null) {
                if (intOrNull.intValue() >= 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    intOrNull = null;
                }
                if (intOrNull != null) {
                    arrayList.add(Integer.valueOf(intOrNull.intValue()));
                }
            }
            return null;
        }
        return arrayList;
    }

    @NotNull
    public final String g(@NotNull String originUrl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) originUrl);
        }
        Intrinsics.checkNotNullParameter(originUrl, "originUrl");
        String e16 = m.f191935a.e(this.msgItem.n2());
        try {
            return i(originUrl, new JSONObject(e16));
        } catch (Exception e17) {
            QLog.e("TemMsg.Url", 1, "selectUrlByVersion got error metaJson:" + e17 + "," + e16);
            return "";
        }
    }
}
