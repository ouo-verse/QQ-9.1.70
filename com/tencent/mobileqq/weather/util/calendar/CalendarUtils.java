package com.tencent.mobileqq.weather.util.calendar;

import android.content.ContentUris;
import android.content.ContentValues;
import android.net.Uri;
import android.provider.CalendarContract;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.weather.util.calendar.CalendarUtils;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmeterqui.question.time.TuxTimeView;
import com.tencent.util.DBBuildUtil;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0016\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0018\u0010\u0013\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0010\u001a\u00020\u000fR$\u0010\u001a\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/weather/util/calendar/CalendarUtils;", "", "Lcom/tencent/mobileqq/weather/util/calendar/RemindEntity;", "remindEntity", "", "g", "entity", "", h.F, "", "time", "", "f", "Lcom/tencent/mtt/hippy/common/HippyMap;", "data", "Lcom/tencent/mobileqq/weather/util/calendar/CalendarUtils$a;", "callBack", "c", "Lorg/json/JSONObject;", "d", "b", "Lcom/tencent/mobileqq/weather/util/calendar/CalendarUtils$a;", "e", "()Lcom/tencent/mobileqq/weather/util/calendar/CalendarUtils$a;", "setMCallBack", "(Lcom/tencent/mobileqq/weather/util/calendar/CalendarUtils$a;)V", "mCallBack", "<init>", "()V", "a", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class CalendarUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final CalendarUtils f313630a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static a mCallBack;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/weather/util/calendar/CalendarUtils$a;", "", "", "result", "", "callback", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public interface a {
        void callback(int result);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43856);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f313630a = new CalendarUtils();
        }
    }

    CalendarUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean f(long time) {
        EntityManager createEntityManager = DBBuildUtil.getDefaultEntityManagerFactoryBuilder(null).build().createEntityManager();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(time);
        if (DBMethodProxy.find(createEntityManager, (Class<? extends Entity>) RemindEntity.class, sb5.toString()) != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int g(RemindEntity remindEntity) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("dtstart", Long.valueOf(remindEntity.remindTime));
            contentValues.put("dtend", Long.valueOf(remindEntity.remindTime + 3600000));
            contentValues.put("calendar_id", (Integer) 1);
            contentValues.put("title", remindEntity.title);
            contentValues.put("eventTimezone", TimeZone.getDefault().getID());
            contentValues.put("description", remindEntity.jumpUrl);
            MobileQQ sMobileQQ = MobileQQ.sMobileQQ;
            Intrinsics.checkNotNullExpressionValue(sMobileQQ, "sMobileQQ");
            Uri insert = sMobileQQ.getContentResolver().insert(CalendarContract.Events.CONTENT_URI, contentValues);
            if (insert == null) {
                QLog.e("QQWeather.CalendarUtils", 1, "event add to calendar error");
                return -1;
            }
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("event_id", Long.valueOf(ContentUris.parseId(insert)));
            contentValues2.put(TuxTimeView.TUX_TIME_STYLE_MINUTES, (Integer) 0);
            contentValues2.put("method", (Integer) 1);
            if (sMobileQQ.getContentResolver().insert(CalendarContract.Reminders.CONTENT_URI, contentValues2) == null) {
                QLog.e("QQWeather.CalendarUtils", 1, "alarm add to calendar error");
                return -1;
            }
            h(remindEntity);
            return 0;
        } catch (Exception e16) {
            QLog.e("QQWeather.CalendarUtils", 1, "add remind error :" + e16);
            return -1;
        }
    }

    private final void h(RemindEntity entity) {
        DBBuildUtil.getDefaultEntityManagerFactoryBuilder(null).build().createEntityManager().persist(entity);
    }

    public final void c(@NotNull HippyMap data, @NotNull a callBack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) data, (Object) callBack);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        mCallBack = callBack;
        final HippyArray array = data.getArray("remindTimeIntervals");
        if (array != null && array.size() != 0) {
            final String string = data.getString("remindText");
            final String str = "";
            if (string == null) {
                string = "";
            }
            String string2 = data.getString(WadlProxyConsts.KEY_JUMP_URL);
            if (string2 != null) {
                str = string2;
            }
            ThreadManagerV2.excute(new Runnable(string, str) { // from class: com.tencent.mobileqq.weather.util.calendar.CalendarUtils$addRemindInfoToCalendar$runnable$1
                static IPatchRedirector $redirector_;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f313633e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f313634f;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f313633e = string;
                    this.f313634f = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, HippyArray.this, string, str);
                    }
                }

                /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
                
                    r3 = r5.g(new com.tencent.mobileqq.weather.util.calendar.RemindEntity(r3, r9.f313633e, r9.f313634f));
                 */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    boolean f16;
                    int g16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        int size = HippyArray.this.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            long j3 = HippyArray.this.getLong(i3) * 1000;
                            CalendarUtils calendarUtils = CalendarUtils.f313630a;
                            f16 = calendarUtils.f(j3);
                            if (!f16 && g16 != 0) {
                                CalendarUtils.a e16 = calendarUtils.e();
                                if (e16 != null) {
                                    e16.callback(g16);
                                    return;
                                }
                                return;
                            }
                        }
                        CalendarUtils.a e17 = CalendarUtils.f313630a.e();
                        if (e17 != null) {
                            e17.callback(0);
                        }
                    } catch (Throwable th5) {
                        QLog.e("QQWeather.CalendarUtils", 1, " addRemindInfoToCalendar error: " + th5);
                        CalendarUtils.a e18 = CalendarUtils.f313630a.e();
                        if (e18 != null) {
                            e18.callback(-1);
                        }
                    }
                }
            }, 16, null, true);
            return;
        }
        a aVar = mCallBack;
        if (aVar != null) {
            aVar.callback(-3);
        }
    }

    public final void d(@Nullable JSONObject data, @NotNull a callBack) {
        final JSONArray jSONArray;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) data, (Object) callBack);
            return;
        }
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        mCallBack = callBack;
        if (data != null) {
            jSONArray = data.getJSONArray("remindTimeIntervals");
        } else {
            jSONArray = null;
        }
        if (jSONArray != null && jSONArray.length() != 0) {
            final String optString = data.optString("remindText");
            final String optString2 = data.optString(WadlProxyConsts.KEY_JUMP_URL);
            ThreadManagerV2.excute(new Runnable(optString, optString2) { // from class: com.tencent.mobileqq.weather.util.calendar.CalendarUtils$addRemindInfoToCalendar$runnable$2
                static IPatchRedirector $redirector_;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f313636e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f313637f;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f313636e = optString;
                    this.f313637f = optString2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, JSONArray.this, optString, optString2);
                    }
                }

                /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
                
                    r3 = r5.g(new com.tencent.mobileqq.weather.util.calendar.RemindEntity(r3, r9.f313636e, r9.f313637f));
                 */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    boolean f16;
                    int g16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        int length = JSONArray.this.length();
                        for (int i3 = 0; i3 < length; i3++) {
                            long j3 = JSONArray.this.getLong(i3) * 1000;
                            CalendarUtils calendarUtils = CalendarUtils.f313630a;
                            f16 = calendarUtils.f(j3);
                            if (!f16 && g16 != 0) {
                                CalendarUtils.a e16 = calendarUtils.e();
                                if (e16 != null) {
                                    e16.callback(g16);
                                    return;
                                }
                                return;
                            }
                        }
                        CalendarUtils.a e17 = CalendarUtils.f313630a.e();
                        if (e17 != null) {
                            e17.callback(0);
                        }
                    } catch (Throwable th5) {
                        QLog.e("QQWeather.CalendarUtils", 1, " addRemindInfoToCalendar error: " + th5);
                        CalendarUtils.a e18 = CalendarUtils.f313630a.e();
                        if (e18 != null) {
                            e18.callback(-1);
                        }
                    }
                }
            }, 16, null, true);
        } else {
            a aVar = mCallBack;
            if (aVar != null) {
                aVar.callback(-3);
            }
        }
    }

    @Nullable
    public final a e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return mCallBack;
    }
}
