package com.tencent.mobileqq.zplan.utils;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010\f\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nJ\"\u0010\r\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bJ\"\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\u000eJ\u0010\u0010\u0010\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0013\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00152\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\nJ\u0018\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\nJE\u0010!\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u000e2#\u0010 \u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f0\u001bJ;\u0010\"\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\n2#\u0010 \u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f0\u001b\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/v;", "", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "redDotAppInfo", "Lorg/json/JSONObject;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedDisplayInfo;", "displayInfo", "", "type", "", "default", "k", "i", "", "j", "e", "", DomainData.DOMAIN_NAME, "f", "key", "", tl.h.F, "g", "appSet", "path", "delay", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "appInfo", "", "block", "c", "b", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public static final v f335848a = new v();

    v() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(int i3, String path, Function1 block) {
        Intrinsics.checkNotNullParameter(path, "$path");
        Intrinsics.checkNotNullParameter(block, "$block");
        f335848a.b(i3, path, block);
    }

    private final JSONObject m(BusinessInfoCheckUpdate.AppInfo redDotAppInfo) {
        if (redDotAppInfo == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(redDotAppInfo.buffer.get());
            QLog.i("RedDotUtil", 1, "getSquareEntryRedPointExtra: buffer=" + jSONObject);
            String optString = jSONObject.optString("ad_id");
            JSONObject optJSONObject = jSONObject.optJSONObject("param");
            if (optJSONObject != null) {
                return optJSONObject.optJSONObject(optString);
            }
            return null;
        } catch (JSONException e16) {
            QLog.e("RedDotUtil", 1, "getSquareEntryRedPointExtra error: buffer=" + redDotAppInfo.buffer.get() + ", message=" + e16.getMessage());
            return null;
        }
    }

    public final void b(int appSet, String path, Function1<? super BusinessInfoCheckUpdate.AppInfo, Unit> block) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(block, "block");
        AppRuntime d16 = bb.f335811a.d();
        IRedTouchManager iRedTouchManager = d16 != null ? (IRedTouchManager) d16.getRuntimeService(IRedTouchManager.class, "") : null;
        block.invoke(iRedTouchManager != null ? iRedTouchManager.getAppInfo(appSet, path) : null);
    }

    public final void c(final int appSet, final String path, long delay, final Function1<? super BusinessInfoCheckUpdate.AppInfo, Unit> block) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(block, "block");
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.zplan.utils.u
            @Override // java.lang.Runnable
            public final void run() {
                v.d(appSet, path, block);
            }
        }, 16, null, false, delay);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0011 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0012 A[Catch: all -> 0x0025, TRY_LEAVE, TryCatch #0 {all -> 0x0025, blocks: (B:12:0x0005, B:14:0x0009, B:7:0x0012), top: B:11:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String e(BusinessInfoCheckUpdate.AppInfo redDotAppInfo) {
        String str;
        if (redDotAppInfo != null) {
            try {
                PBStringField pBStringField = redDotAppInfo.buffer;
                if (pBStringField != null) {
                    str = pBStringField.get();
                    if (str != null) {
                        return "-1";
                    }
                    String optString = new JSONObject(str).optString("ad_id", "-1");
                    Intrinsics.checkNotNullExpressionValue(optString, "bufferObj.optString(KEY_\u2026D, TIANSHU_AD_ID_DEFAULT)");
                    return optString;
                }
            } catch (Throwable unused) {
                return "-1";
            }
        }
        str = null;
        if (str != null) {
        }
    }

    public final long g(BusinessInfoCheckUpdate.AppInfo redDotAppInfo, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        JSONObject m3 = m(redDotAppInfo);
        if (m3 != null) {
            return m3.optLong(key);
        }
        return 0L;
    }

    public final List<Long> h(BusinessInfoCheckUpdate.AppInfo redDotAppInfo, String key) {
        List<Long> emptyList;
        Intrinsics.checkNotNullParameter(key, "key");
        JSONObject m3 = m(redDotAppInfo);
        JSONArray optJSONArray = m3 != null ? m3.optJSONArray(key) : null;
        if (optJSONArray == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            long optLong = optJSONArray.optLong(i3, -1L);
            if (optLong != -1) {
                arrayList.add(Long.valueOf(optLong));
            }
        }
        return arrayList;
    }

    public final String k(BusinessInfoCheckUpdate.RedDisplayInfo displayInfo, int type, String r95) {
        PBRepeatMessageField<BusinessInfoCheckUpdate.RedTypeInfo> pBRepeatMessageField;
        PBStringField pBStringField;
        Intrinsics.checkNotNullParameter(r95, "default");
        if (displayInfo == null || (pBRepeatMessageField = displayInfo.red_type_info) == null) {
            return r95;
        }
        int size = pBRepeatMessageField.size();
        if (QLog.isColorLevel()) {
            QLog.d("RedDotUtil", 1, "getExtendContentStr, size:" + size);
        }
        if (size <= 0) {
            return r95;
        }
        for (int i3 = 0; i3 < size; i3++) {
            try {
                if (pBRepeatMessageField.get(i3).red_type.get() == type) {
                    if (QLog.isColorLevel()) {
                        BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = pBRepeatMessageField.get(i3);
                        QLog.d("RedDotUtil", 1, "getExtendContentStr: " + type + ", " + ((redTypeInfo == null || (pBStringField = redTypeInfo.red_content) == null) ? null : pBStringField.get()));
                    }
                    String str = pBRepeatMessageField.get(i3).red_content.get();
                    Intrinsics.checkNotNullExpressionValue(str, "repeatValues[i].red_content.get()");
                    return str;
                }
            } catch (Throwable th5) {
                QLog.e("RedDotUtil", 1, "getExtendContentStr err.", th5);
            }
        }
        return r95;
    }

    public final boolean n(BusinessInfoCheckUpdate.AppInfo redDotAppInfo) {
        BusinessInfoCheckUpdate.RedDisplayInfo redDisplayInfo;
        PBUInt32Field pBUInt32Field;
        int i3 = (redDotAppInfo == null || (pBUInt32Field = redDotAppInfo.type) == null) ? -1 : pBUInt32Field.get();
        if (i3 == 0 || i3 == 18 || i3 == 22) {
            return i((redDotAppInfo == null || (redDisplayInfo = redDotAppInfo.red_display_info) == null) ? null : redDisplayInfo.get(), 24, 0) == 1;
        }
        return false;
    }

    public final int f(BusinessInfoCheckUpdate.AppInfo redDotAppInfo) {
        PBUInt32Field pBUInt32Field;
        int i3 = (redDotAppInfo == null || (pBUInt32Field = redDotAppInfo.type) == null) ? -1 : pBUInt32Field.get();
        if (i3 == 0 || i3 == 18 || i3 == 22) {
            return i3;
        }
        return -1;
    }

    public static /* synthetic */ String l(v vVar, BusinessInfoCheckUpdate.RedDisplayInfo redDisplayInfo, int i3, String str, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            str = "";
        }
        return vVar.k(redDisplayInfo, i3, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000c, code lost:
    
        r7 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r7);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int i(BusinessInfoCheckUpdate.RedDisplayInfo displayInfo, int type, int r95) {
        Integer intOrNull;
        try {
            String l3 = l(this, displayInfo, type, null, 4, null);
            return (l3 == null || intOrNull == null) ? r95 : intOrNull.intValue();
        } catch (Throwable th5) {
            QLog.e("RedDotUtil", 1, "getExtendContentInt err. " + th5.getMessage());
            return r95;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000c, code lost:
    
        r7 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r7);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long j(BusinessInfoCheckUpdate.RedDisplayInfo displayInfo, int type, long r95) {
        Long longOrNull;
        try {
            String l3 = l(this, displayInfo, type, null, 4, null);
            return (l3 == null || longOrNull == null) ? r95 : longOrNull.longValue();
        } catch (Throwable th5) {
            QLog.e("RedDotUtil", 1, "getExtendContentLong err. " + th5.getMessage());
            return r95;
        }
    }
}
