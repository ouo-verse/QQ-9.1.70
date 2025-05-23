package com.tencent.mobileqq.ecshop.view.adcard.gift;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/ecshop/view/adcard/gift/a;", "", "Lorg/json/JSONObject;", "adInfoJson", "", "b", "", "a", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f203960a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29299);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f203960a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final int b(JSONObject adInfoJson) {
        JSONArray optJSONArray;
        int i3 = 1;
        try {
            JSONObject optJSONObject = adInfoJson.optJSONObject("ext");
            if (optJSONObject == null || (optJSONArray = optJSONObject.optJSONArray("exp_map")) == null) {
                return -1;
            }
            int length = optJSONArray.length();
            for (int i16 = 0; i16 < length; i16++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i16);
                int optInt = optJSONObject2.optInt("key");
                String optString = optJSONObject2.optString("value");
                if (optInt == 102632) {
                    if (!Intrinsics.areEqual("1", optString)) {
                        if (Intrinsics.areEqual("2", optString)) {
                            i3 = 2;
                        } else {
                            i3 = -1;
                        }
                    }
                    return i3;
                }
            }
            return -1;
        } catch (Exception e16) {
            QLog.e("GiftBoxEffectWorker", 1, e16, new Object[0]);
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002a A[Catch: Exception -> 0x0024, TRY_LEAVE, TryCatch #0 {Exception -> 0x0024, blocks: (B:21:0x001b, B:13:0x002a), top: B:20:0x001b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int a(@Nullable String adInfoJson) {
        boolean isBlank;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) adInfoJson)).intValue();
        }
        if (adInfoJson != null) {
            try {
                isBlank = StringsKt__StringsJVMKt.isBlank(adInfoJson);
                if (!isBlank) {
                    z16 = false;
                    if (!z16) {
                        return -1;
                    }
                    return b(new JSONObject(adInfoJson));
                }
            } catch (Exception e16) {
                QLog.e("GiftBoxEffectWorker", 1, e16, new Object[0]);
                return -1;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }
}
