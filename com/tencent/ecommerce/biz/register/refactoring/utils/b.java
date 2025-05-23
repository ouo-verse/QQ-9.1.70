package com.tencent.ecommerce.biz.register.refactoring.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.biz.register.refactoring.fragment.ECommerceRegisterIntroFragment;
import com.tencent.ecommerce.biz.register.refactoring.repo.ECommerceRegisterRepo;
import com.tencent.ecommerce.biz.router.ECScheme;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ0\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005J\u001e\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/biz/register/refactoring/utils/b;", "", "", "jumpScheme", "callbackId", "", "data", "", "a", "", "role", "deliverProductCallbackId", "c", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class b {

    /* renamed from: a */
    public static final b f104104a = new b();

    b() {
    }

    public final void a(String jumpScheme, String callbackId, Map<String, String> data) {
        Map mutableMapOf;
        if (TextUtils.isEmpty(jumpScheme)) {
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("scheme_callback_id", callbackId));
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (data != null) {
                linkedHashMap.putAll(data);
            }
            yi0.a.t(Uri.parse(String.valueOf(5)), mutableMapOf, linkedHashMap, null, 8, null);
            return;
        }
        IECSchemeCallback b16 = ug0.a.b(callbackId);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        if (data != null) {
            linkedHashMap2.putAll(data);
        }
        ECScheme.c(jumpScheme, b16, linkedHashMap2);
        ECommerceRegisterRepo.f104099a.a();
    }

    public final void c(int role, String jumpScheme, String deliverProductCallbackId) {
        String str;
        Map mutableMapOf;
        if (role == ECommerceRegisterIntroFragment.RoleType.ROLE_TYPE_OLD_MCN.ordinal() || role == ECommerceRegisterIntroFragment.RoleType.ROLE_TYPE_NEW_MCN.ordinal()) {
            str = "1";
        } else {
            str = "0";
        }
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("jump_scheme", jumpScheme), TuplesKt.to("scheme_callback_id", deliverProductCallbackId), TuplesKt.to("is_mcn", str), TuplesKt.to("is_trans_activity", "1"));
        yi0.a.t(Uri.parse(String.valueOf(48)), mutableMapOf, null, null, 12, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void b(b bVar, String str, String str2, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        bVar.a(str, str2, map);
    }
}
