package com.tencent.mobileqq.qqshop.message.datasource;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.api.QQWinkTempConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.kernel.nativeinterface.ArkElement;
import com.tencent.xweb.FileReaderHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0004*\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/qqshop/message/datasource/a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/ArkElement;", DTConstants.TAG.ELEMENT, "Lorg/json/JSONObject;", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "o", "c", "j", "", "a", "", "k", "d", "Lorg/json/JSONArray;", "l", "e", h.F, "g", "i", "b", DomainData.DOMAIN_NAME, "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f274479a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30053);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            f274479a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final JSONObject f(ArkElement element) {
        JSONObject o16 = o(element.bytesData);
        if (o16 != null) {
            return o16.optJSONObject(PublicAccountMessageUtilImpl.META_NAME);
        }
        return null;
    }

    private final JSONObject m(ArkElement element) {
        JSONObject o16 = o(element.bytesData);
        if (o16 != null) {
            return o16.optJSONObject("sourceAd");
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0013 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014 A[Catch: JSONException -> 0x000e, TRY_LEAVE, TryCatch #0 {JSONException -> 0x000e, blocks: (B:15:0x0005, B:7:0x0014), top: B:14:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final JSONObject o(String str) {
        boolean z16;
        if (str != null) {
            try {
                if (str.length() != 0) {
                    z16 = false;
                    if (!z16) {
                        return null;
                    }
                    return new JSONObject(str);
                }
            } catch (JSONException e16) {
                QLog.e("ArkElementDataSource", 1, e16, new Object[0]);
                return null;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    public final int a(@NotNull ArkElement element) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) element)).intValue();
        }
        Intrinsics.checkNotNullParameter(element, "element");
        JSONObject m3 = m(element);
        if (m3 != null) {
            return m3.optInt("action_type");
        }
        return 0;
    }

    @Nullable
    public final String b(@NotNull ArkElement element) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this, (Object) element);
        }
        Intrinsics.checkNotNullParameter(element, "element");
        JSONObject c16 = c(element);
        if (c16 != null && (optJSONObject = c16.optJSONObject(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO)) != null && (optJSONObject2 = optJSONObject.optJSONObject("trace_info")) != null) {
            return optJSONObject2.optString("aid");
        }
        return null;
    }

    @Nullable
    public final JSONObject c(@NotNull ArkElement element) {
        JSONObject optJSONObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (JSONObject) iPatchRedirector.redirect((short) 2, (Object) this, (Object) element);
        }
        Intrinsics.checkNotNullParameter(element, "element");
        JSONObject f16 = f(element);
        if (f16 != null && (optJSONObject = f16.optJSONObject("gdt")) != null) {
            return optJSONObject.optJSONObject("adInfo");
        }
        return null;
    }

    public final int d(@NotNull ArkElement element) {
        JSONObject optJSONObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) element)).intValue();
        }
        Intrinsics.checkNotNullParameter(element, "element");
        JSONObject f16 = f(element);
        if (f16 != null && (optJSONObject = f16.optJSONObject("gdt")) != null) {
            return optJSONObject.optInt("isShowArk");
        }
        return 0;
    }

    @Nullable
    public final String e(@NotNull ArkElement element) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) element);
        }
        Intrinsics.checkNotNullParameter(element, "element");
        JSONObject f16 = f(element);
        if (f16 != null && (optJSONObject = f16.optJSONObject("gdt")) != null && (optJSONObject2 = optJSONObject.optJSONObject("nativeMessage")) != null) {
            return optJSONObject2.optString("mainTitle");
        }
        return null;
    }

    @Nullable
    public final String g(@NotNull ArkElement element) {
        String str;
        boolean z16;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, (Object) element);
        }
        Intrinsics.checkNotNullParameter(element, "element");
        JSONObject c16 = c(element);
        if (c16 != null && (optJSONObject2 = c16.optJSONObject("dest_info")) != null) {
            str = optJSONObject2.optString("landing_page");
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            return str;
        }
        JSONObject f16 = f(element);
        if (f16 == null || (optJSONObject = f16.optJSONObject("floorData")) == null) {
            return null;
        }
        return optJSONObject.optString("url");
    }

    @Nullable
    public final String h(@NotNull ArkElement element) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, (Object) element);
        }
        Intrinsics.checkNotNullParameter(element, "element");
        JSONObject o16 = o(element.bytesData);
        if (o16 != null) {
            return o16.optString("prompt");
        }
        return null;
    }

    @Nullable
    public final String i(@NotNull ArkElement element) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this, (Object) element);
        }
        Intrinsics.checkNotNullParameter(element, "element");
        JSONObject c16 = c(element);
        if (c16 != null && (optJSONObject = c16.optJSONObject("display_info")) != null && (optJSONObject2 = optJSONObject.optJSONObject("basic_info")) != null) {
            return optJSONObject2.optString(FileReaderHelper.TXT_EXT);
        }
        return null;
    }

    @Nullable
    public final JSONObject j(@NotNull ArkElement element) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (JSONObject) iPatchRedirector.redirect((short) 3, (Object) this, (Object) element);
        }
        Intrinsics.checkNotNullParameter(element, "element");
        JSONObject m3 = m(element);
        if (m3 != null) {
            str = m3.optString("qgg_ext");
        } else {
            str = null;
        }
        if (str == null) {
            return null;
        }
        return o(str);
    }

    public final boolean k(@NotNull ArkElement element) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) element)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(element, "element");
        JSONObject f16 = f(element);
        if (f16 != null && (optJSONObject = f16.optJSONObject("gdt")) != null && (optJSONObject2 = optJSONObject.optJSONObject("extParams")) != null) {
            return optJSONObject2.optBoolean("is_report_click");
        }
        return false;
    }

    @Nullable
    public final JSONArray l(@NotNull ArkElement element) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (JSONArray) iPatchRedirector.redirect((short) 7, (Object) this, (Object) element);
        }
        Intrinsics.checkNotNullParameter(element, "element");
        JSONObject f16 = f(element);
        if (f16 != null && (optJSONObject = f16.optJSONObject("gdt")) != null && (optJSONObject2 = optJSONObject.optJSONObject("nativeMessage")) != null) {
            return optJSONObject2.optJSONArray("banners");
        }
        return null;
    }

    @Nullable
    public final String n(@NotNull ArkElement element) {
        boolean z16;
        String str;
        int indexOf$default;
        boolean contains$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this, (Object) element);
        }
        Intrinsics.checkNotNullParameter(element, "element");
        String g16 = g(element);
        if (g16 != null && g16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        Object[] array = new Regex(ContainerUtils.FIELD_DELIMITER).split(g16, 0).toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr = (String[]) array;
        int length = strArr.length;
        int i3 = 0;
        while (true) {
            if (i3 < length) {
                String str2 = strArr[i3];
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) "ad_id=", false, 2, (Object) null);
                if (contains$default) {
                    str = str2;
                    break;
                }
                i3++;
            } else {
                str = null;
                break;
            }
        }
        if (str != null) {
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, "ad_id=", 0, false, 6, (Object) null);
            String substring = str.substring(indexOf$default + 6);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            return substring;
        }
        return null;
    }
}
