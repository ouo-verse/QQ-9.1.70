package com.tencent.mobileqq.weather.chat;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.ad.report.api.ISsoPushReportApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ILaunchTroopSysMsgUIUtilApi;
import com.tencent.mobileqq.weather.hippy.QQWeatherModule;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.kernel.nativeinterface.ArkElement;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\"\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u000e\u0010\u000f\u001a\u0004\u0018\u00010\u000e*\u00020\tH\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0010*\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/weather/chat/f;", "", "", "action", "", "hasUnreadMsg", "", "c", "eventCode", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/mobileqq/ad/report/a;", "g", "f", "Lcom/tencent/qqnt/kernel/nativeinterface/ArkElement;", "b", "Lorg/json/JSONObject;", "e", "k", h.F, "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "j", "i", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f313270a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19815);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f313270a = new f();
        }
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final ArkElement b(MsgRecord msgRecord) {
        Object obj;
        boolean z16;
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "this.elements");
        Iterator<T> it = arrayList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((MsgElement) obj).arkElement != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        MsgElement msgElement = (MsgElement) obj;
        if (msgElement == null) {
            return null;
        }
        return msgElement.arkElement;
    }

    private final void c(final String action, final boolean hasUnreadMsg) {
        ((IMsgService) QRoute.api(IMsgService.class)).getLatestDbMsgs(new Contact(1, "u_vmmIQZ3yUOpBlO2DISdO2g", ""), 1, new IMsgOperateCallback() { // from class: com.tencent.mobileqq.weather.chat.e
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList) {
                f.d(action, hasUnreadMsg, i3, str, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(String action, boolean z16, int i3, String str, ArrayList msgList) {
        MsgRecord msgRecord;
        Intrinsics.checkNotNullParameter(action, "$action");
        try {
            Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
            if (!msgList.isEmpty()) {
                msgRecord = (MsgRecord) msgList.get(0);
            } else {
                msgRecord = null;
            }
            ((ISsoPushReportApi) QRoute.api(ISsoPushReportApi.class)).report(f313270a.g(action, msgRecord, z16));
        } catch (Exception e16) {
            QLog.e("WeatherAccountMsgReportHelper", 1, "getLastMsgAndReport error:", e16);
        }
    }

    private final JSONObject e(MsgRecord msgRecord) {
        JSONObject k3;
        ArkElement b16 = b(msgRecord);
        if (b16 == null || (k3 = k(b16.bytesData)) == null) {
            return null;
        }
        return k3.optJSONObject(PublicAccountMessageUtilImpl.META_NAME);
    }

    private final String f(MsgRecord msgRecord) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONObject optJSONObject4;
        if (msgRecord == null) {
            QLog.e("WeatherAccountMsgReportHelper", 1, "getPushTypeFromMsg: msgRecord is null");
            return "0";
        }
        try {
            JSONObject e16 = e(msgRecord);
            if (e16 == null || (optJSONObject = e16.optJSONObject("weather")) == null || (optJSONObject2 = optJSONObject.optJSONObject("waterfall_ark")) == null || (optJSONObject3 = optJSONObject2.optJSONObject(PublicAccountMessageUtilImpl.META_NAME)) == null || (optJSONObject4 = optJSONObject3.optJSONObject("qq_weather")) == null) {
                return "0";
            }
            String optString = optJSONObject4.optString(ILaunchTroopSysMsgUIUtilApi.KEY_PUSH_TYPE, "0");
            Intrinsics.checkNotNullExpressionValue(optString, "it.optString(\"push_type\", msgType)");
            return optString;
        } catch (Throwable th5) {
            QLog.d("WeatherAccountMsgReportHelper", 1, th5, new Object[0]);
            return "0";
        }
    }

    private final com.tencent.mobileqq.ad.report.a g(String eventCode, MsgRecord msgRecord, boolean hasUnreadMsg) {
        String str;
        com.tencent.mobileqq.ad.report.a aVar = new com.tencent.mobileqq.ad.report.a(1, QQWeatherModule.NAME, eventCode);
        if (hasUnreadMsg) {
            str = "1";
        } else {
            str = "0";
        }
        aVar.f186921m = str;
        aVar.f186922n = f(msgRecord);
        return aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0013 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014 A[Catch: JSONException -> 0x000e, TRY_LEAVE, TryCatch #0 {JSONException -> 0x000e, blocks: (B:15:0x0005, B:7:0x0014), top: B:14:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final JSONObject k(String str) {
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
                QLog.e("WeatherAccountMsgReportHelper", 1, e16, new Object[0]);
                return null;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    public final void h(@NotNull MsgRecord msgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgRecord);
            return;
        }
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        QLog.d("WeatherAccountMsgReportHelper", 1, "reportMsgArrived");
        ((ISsoPushReportApi) QRoute.api(ISsoPushReportApi.class)).report(g("new_folder_weather_arrive", msgRecord, true));
    }

    public final void i(boolean hasUnreadMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, hasUnreadMsg);
        } else {
            QLog.d("WeatherAccountMsgReportHelper", 1, "reportMsgClick");
            c("new_folder_weather_click", hasUnreadMsg);
        }
    }

    public final void j(@NotNull g item) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.x().b() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("WeatherAccountMsgReportHelper", 1, "reportMsgExpo hasUnreadInfo:" + z16);
        c("new_folder_weather_expose", z16);
    }
}
