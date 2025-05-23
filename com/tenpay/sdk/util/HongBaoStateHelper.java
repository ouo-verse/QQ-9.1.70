package com.tenpay.sdk.util;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.qwallet.db.HbStateEntity;
import com.tencent.qqnt.qwallet.db.QWalletDBManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0007J\u0016\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tenpay/sdk/util/HongBaoStateHelper;", "", "()V", "DATE_FORMAT", "", "TAG", "TEXT_EXPIRED", "TEXT_GRABBED_BY_ME", "TEXT_GRABBED_OUT", "extractFromHbData", "", "grabRsp", "Lorg/json/JSONObject;", "getStateKey", "listId", "getStateText", "setStateByGrayBar", "isSelf", "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class HongBaoStateHelper {

    @NotNull
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @NotNull
    public static final HongBaoStateHelper INSTANCE = new HongBaoStateHelper();

    @NotNull
    private static final String TAG = "HongBaoStateHelper";

    @NotNull
    private static final String TEXT_EXPIRED = "\u5df2\u8fc7\u671f";

    @NotNull
    private static final String TEXT_GRABBED_BY_ME = "\u5df2\u9886\u53d6";

    @NotNull
    private static final String TEXT_GRABBED_OUT = "\u5df2\u88ab\u9886\u5b8c";

    HongBaoStateHelper() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x00c6, code lost:
    
        if (r15 == 2) goto L37;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v4, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.lang.String] */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void extractFromHbData(@NotNull JSONObject grabRsp) {
        String str;
        int i3;
        boolean z16;
        boolean isBlank;
        Date parse;
        long time;
        boolean isBlank2;
        Function0<Unit> a16;
        boolean z17;
        Intrinsics.checkNotNullParameter(grabRsp, "grabRsp");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        String str2 = "";
        objectRef.element = "";
        JSONObject optJSONObject = grabRsp.optJSONObject("send_object");
        boolean z18 = false;
        if (optJSONObject == null) {
            str = "";
            i3 = -1;
        } else {
            str = optJSONObject.optString("invalid_time");
            Intrinsics.checkNotNullExpressionValue(str, "it.optString(\"invalid_time\")");
            int optInt = optJSONObject.optInt("state", -1);
            T optString = optJSONObject.optString("listid");
            if (optString.length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                optString = optJSONObject.optString("send_listid");
            }
            Intrinsics.checkNotNullExpressionValue(optString, "it.optString(\"listid\").i\u2026ptString(\"send_listid\") }");
            objectRef.element = optString;
            i3 = optInt;
        }
        if (((CharSequence) objectRef.element).length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.d(TAG, 1, "extractFromHbData: empty listid");
            return;
        }
        int optInt2 = grabRsp.optInt("state", -1);
        QLog.d(TAG, 1, " state " + optInt2 + ", listid " + objectRef.element + ", sendState " + i3 + ", invalidTime " + ((Object) str));
        if (optInt2 != -1) {
            if (optInt2 != 0 && optInt2 != 1) {
                if (optInt2 != 2) {
                    if (optInt2 != 3 && optInt2 != 4) {
                        if (optInt2 != 6) {
                            if (optInt2 != 14) {
                                switch (optInt2) {
                                }
                                isBlank = StringsKt__StringsJVMKt.isBlank(str);
                                if (!isBlank) {
                                    try {
                                        parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(str);
                                    } catch (ParseException e16) {
                                        QLog.d(TAG, 1, ": fail to convert time string " + ((Object) str) + "  to date", e16);
                                    }
                                    if (parse != null) {
                                        if (str2.length() == 0) {
                                            z18 = true;
                                        }
                                        if (z18 && Calendar.getInstance().getTime().compareTo(parse) > 0) {
                                            str2 = TEXT_EXPIRED;
                                        }
                                        time = parse.getTime();
                                        QWalletDBManager.f361825a.h(new HbStateEntity((String) objectRef.element, com.tencent.mobileqq.base.a.c(), time, optInt2, i3, str2));
                                        isBlank2 = StringsKt__StringsJVMKt.isBlank(str2);
                                        if ((!isBlank2) && (a16 = vk2.a.f441761a.a()) != null) {
                                            a16.invoke();
                                            return;
                                        }
                                        return;
                                    }
                                }
                                time = 0;
                                QWalletDBManager.f361825a.h(new HbStateEntity((String) objectRef.element, com.tencent.mobileqq.base.a.c(), time, optInt2, i3, str2));
                                isBlank2 = StringsKt__StringsJVMKt.isBlank(str2);
                                if (!isBlank2) {
                                    return;
                                } else {
                                    return;
                                }
                            }
                        }
                    }
                }
                str2 = TEXT_GRABBED_OUT;
                isBlank = StringsKt__StringsJVMKt.isBlank(str);
                if (!isBlank) {
                }
                time = 0;
                QWalletDBManager.f361825a.h(new HbStateEntity((String) objectRef.element, com.tencent.mobileqq.base.a.c(), time, optInt2, i3, str2));
                isBlank2 = StringsKt__StringsJVMKt.isBlank(str2);
                if (!isBlank2) {
                }
            }
            str2 = TEXT_GRABBED_BY_ME;
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
            }
            time = 0;
            QWalletDBManager.f361825a.h(new HbStateEntity((String) objectRef.element, com.tencent.mobileqq.base.a.c(), time, optInt2, i3, str2));
            isBlank2 = StringsKt__StringsJVMKt.isBlank(str2);
            if (!isBlank2) {
            }
        }
        str2 = TEXT_EXPIRED;
        isBlank = StringsKt__StringsJVMKt.isBlank(str);
        if (!isBlank) {
        }
        time = 0;
        QWalletDBManager.f361825a.h(new HbStateEntity((String) objectRef.element, com.tencent.mobileqq.base.a.c(), time, optInt2, i3, str2));
        isBlank2 = StringsKt__StringsJVMKt.isBlank(str2);
        if (!isBlank2) {
        }
    }

    private final String getStateKey(String listId) {
        return "hb_state_text_" + listId + "_" + com.tencent.mobileqq.base.a.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setStateByGrayBar$lambda$3(String stateText, String listId) {
        Intrinsics.checkNotNullParameter(stateText, "$stateText");
        Intrinsics.checkNotNullParameter(listId, "$listId");
        QWalletDBManager.f361825a.B(stateText, listId);
    }

    @Deprecated(message = "MMKV\u5b58\u50a8\u7ea2\u5305\u72b6\u6001\u5df2\u5e9f\u5f03")
    @NotNull
    public final String getStateText(@NotNull String listId) {
        Intrinsics.checkNotNullParameter(listId, "listId");
        return com.tencent.mobileqq.qwallet.utils.g.i(getStateKey(listId));
    }

    public final void setStateByGrayBar(@NotNull final String listId, boolean isSelf) {
        boolean isBlank;
        final String str;
        Intrinsics.checkNotNullParameter(listId, "listId");
        isBlank = StringsKt__StringsJVMKt.isBlank(getStateText(listId));
        if (!isBlank) {
            return;
        }
        if (isSelf) {
            str = TEXT_GRABBED_BY_ME;
        } else {
            str = TEXT_GRABBED_OUT;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tenpay.sdk.util.g
            @Override // java.lang.Runnable
            public final void run() {
                HongBaoStateHelper.setStateByGrayBar$lambda$3(str, listId);
            }
        }, 32, null, true);
    }
}
