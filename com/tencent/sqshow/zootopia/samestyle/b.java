package com.tencent.sqshow.zootopia.samestyle;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.google.protobuf.nano.MessageNano;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.ICommonApi;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001b\u0010\u0006\u001a\u00020\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u001b\u0010\f\u001a\u00020\t2\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\tJ\u0081\u0001\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0012j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001`\u00132&\u0010\u0014\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u00132\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ3\u0010\u001e\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001e\u0010\u001fJ(\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010 2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010 J\u001c\u0010$\u001a\u00020\t2\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010 \u00a8\u0006'"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/b;", "", "", "g", "", "entrySource", "e", "(Ljava/lang/Integer;)Ljava/lang/String;", "originalDataContentType", "", "isFromMixAR", "d", tl.h.F, "(Ljava/lang/Integer;)Z", "Landroid/os/Bundle;", "bundle", "needAutoPublish", "a", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "originalHashMap", "isDressAutoPublish", "sameStyleId", "sameStyleContentType", "publishBackScheme", "c", "(Ljava/util/HashMap;Ljava/lang/Integer;ZIILjava/lang/String;)Ljava/util/HashMap;", "Landroid/content/Intent;", "intent", "arEntrySource", "b", "(Landroid/content/Intent;Ljava/lang/Integer;II)Ljava/lang/String;", "", "paramMap", "f", "shareExtMap", "i", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f372897a = new b();

    b() {
    }

    private final int d(int originalDataContentType, boolean isFromMixAR) {
        if (!isFromMixAR) {
            if (originalDataContentType != 4) {
                if (originalDataContentType == 5) {
                    return 1;
                }
                return originalDataContentType;
            }
            return 0;
        }
        return originalDataContentType;
    }

    private final String e(@SameStyleEntrySource Integer entrySource) {
        if (entrySource != null && entrySource.intValue() == 1) {
            return "xsj_outer_camera_zplan_2";
        }
        if (entrySource != null && entrySource.intValue() == 2) {
            return "xsj_outer_camera_zplan_2";
        }
        if (entrySource != null && entrySource.intValue() == 3) {
            return "";
        }
        if (entrySource != null && entrySource.intValue() == 4) {
            return "xsj_outer_camera_zplan_chuanda_3";
        }
        if ((entrySource != null && entrySource.intValue() == 5) || (entrySource != null && entrySource.intValue() == 6)) {
            return "xsj_outer_camera_zplan_chuanda_4";
        }
        if (entrySource == null || entrySource.intValue() != 7) {
            return "";
        }
        return "xsj_outer_camera_zplan_chuanda_5";
    }

    private final String g() {
        QRouteApi api = QRoute.api(ISchemeApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ISchemeApi::class.java)");
        return ISchemeApi.b.a((ISchemeApi) api, ZootopiaSource.INSTANCE.g(), null, 2, null);
    }

    public final Bundle a(Bundle bundle, boolean needAutoPublish) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        bundle.putBoolean("zplan_auto_publish", needAutoPublish);
        return bundle;
    }

    public final Map<String, Object> f(Map<String, ? extends Object> paramMap) {
        boolean contains$default;
        HashMap hashMap = new HashMap();
        if (paramMap != null && (r9 = paramMap.entrySet().iterator()) != null) {
            for (Map.Entry<String, ? extends Object> entry : paramMap.entrySet()) {
                if ((Intrinsics.areEqual(entry.getKey(), QCircleScheme.AttrQQPublish.BUSINESS_USER_DATA) || Intrinsics.areEqual(entry.getKey(), QCircleScheme.AttrQQPublish.BUSINESS_RETURN_SCHEME)) && (entry.getValue() instanceof String)) {
                    Object value = entry.getValue();
                    Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.String");
                    String str = (String) value;
                    ISchemeApi.Companion companion = ISchemeApi.INSTANCE;
                    boolean z16 = false;
                    if (!Intrinsics.areEqual(str, companion.a(str))) {
                        contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) ":", false, 2, (Object) null);
                        if (!contains$default) {
                            z16 = true;
                        }
                    }
                    String key = entry.getKey();
                    if (!z16) {
                        str = companion.b(str);
                    }
                    hashMap.put(key, str);
                } else {
                    hashMap.put(entry.getKey(), entry.getValue());
                }
            }
        }
        return hashMap;
    }

    public final HashMap<String, Object> c(HashMap<String, Object> originalHashMap, @SameStyleEntrySource Integer entrySource, boolean isDressAutoPublish, int sameStyleId, int sameStyleContentType, String publishBackScheme) {
        if (originalHashMap == null) {
            originalHashMap = new HashMap<>();
        }
        String e16 = e(entrySource);
        if (!TextUtils.isEmpty(e16)) {
            originalHashMap.put("taskid", e16);
        }
        StringBuilder sb5 = new StringBuilder("appendPublishParamsToShareMap, entrySource= " + entrySource + ", taskId= " + e16 + ", sameStyleId= " + sameStyleId + ", sameStyleContentType= " + sameStyleContentType + ", publishBackScheme= " + publishBackScheme);
        if (isDressAutoPublish) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("zplan_auto_publish", true);
            String b16 = com.tencent.sqshow.zootopia.utils.ab.INSTANCE.b();
            int selfGender = ((ICommonApi) QRoute.api(ICommonApi.class)).getSelfGender();
            List<pu4.o> selfClothesIdList = ((ICommonApi) QRoute.api(ICommonApi.class)).getSelfClothesIdList();
            pu4.m mVar = new pu4.m();
            List<pu4.o> list = selfClothesIdList;
            if (!list.isEmpty()) {
                Object[] array = list.toArray(new pu4.o[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                mVar.f427495c = (pu4.o[]) array;
            }
            mVar.f427497e = selfGender;
            mVar.f427493a = sameStyleId;
            mVar.f427496d = b16;
            b bVar = f372897a;
            mVar.f427494b = bVar.d(sameStyleContentType, bVar.h(entrySource));
            bundle.putString("zplan_publish_data", Base64.encodeToString(MessageNano.toByteArray(mVar), 2));
            sb5.append(", OutfitWorksExtInfo= " + mVar);
            originalHashMap.put(QCircleScheme.AttrQQPublish.BUSINESS_USER_DATA, xb4.b.f447772a.h(bundle));
            if (publishBackScheme == null) {
                publishBackScheme = g();
            }
            originalHashMap.put(QCircleScheme.AttrQQPublish.BUSINESS_RETURN_SCHEME, ISchemeApi.INSTANCE.b(publishBackScheme));
            originalHashMap.put(QCircleScheme.AttrQQPublish.SUPER_QQ_SHOW_IS_DRESS_OUTFIT, 1);
        }
        QLog.i("ZPlanSameStyle_SameStyleShareLogic", 1, sb5.toString());
        return originalHashMap;
    }

    private final boolean h(@SameStyleEntrySource Integer entrySource) {
        return (entrySource != null && entrySource.intValue() == 2) || (entrySource != null && entrySource.intValue() == 6);
    }

    public final boolean i(Map<String, ? extends Object> shareExtMap) {
        Object obj = shareExtMap != null ? shareExtMap.get(QCircleScheme.AttrQQPublish.BUSINESS_USER_DATA) : null;
        String str = obj instanceof String ? (String) obj : null;
        if (!TextUtils.isEmpty(str)) {
            Bundle n3 = xb4.b.f447772a.n(str);
            if (n3 != null && n3.getBoolean("zplan_auto_publish")) {
                return true;
            }
        }
        return false;
    }

    public final String b(Intent intent, @SameStyleEntrySource Integer arEntrySource, int sameStyleId, int sameStyleContentType) {
        boolean z16 = false;
        if (intent != null && intent.getBooleanExtra("zplan_auto_publish", false)) {
            z16 = true;
        }
        HashMap<String, Object> c16 = c(null, arEntrySource, z16, sameStyleId, sameStyleContentType, intent != null ? intent.getStringExtra("zplan_publish_back_scheme") : null);
        StringBuilder sb5 = new StringBuilder();
        for (Map.Entry<String, Object> entry : c16.entrySet()) {
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append(entry.getKey());
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(entry.getValue());
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "stringBuilder.toString()");
        return sb6;
    }
}
