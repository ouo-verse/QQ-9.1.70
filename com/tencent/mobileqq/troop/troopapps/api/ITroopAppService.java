package com.tencent.mobileqq.troop.troopapps.api;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.troopapps.data.TroopAppInfo;
import java.util.ArrayList;
import java.util.List;
import mqq.app.api.IRuntimeService;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Service(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopAppService extends IRuntimeService {
    public static final String KEY_ALL_APP_STRING = "appinfo_all_app_string";
    public static final String KEY_APPID_CLICK_DATE = "appid_click_date";
    public static final String KEY_APPID_CLICK_NUM = "appid_click_num";
    public static final String KEY_APPINFO_DATE = "appinfo_date";
    public static final String KEY_APP_CONFIG_PREFIX = "KEY_APP_CONFIG_PREFIX";
    public static final String KEY_APP_LIST_TIME_STAMP = "KEY_APP_LIST_TIME_STAMP";
    public static final int READ_TYPE_DETAIL = 2;
    public static final int READ_TYPE_HASH = 1;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        public static a[] f299360b;

        /* renamed from: a, reason: collision with root package name */
        public String f299361a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29078);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 4)) {
                redirector.redirect((short) 4);
            } else {
                f299360b = new a[]{new a("BulkChatMessageConfig")};
            }
        }

        public a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            } else {
                this.f299361a = str;
            }
        }

        public final JSONObject a(String str) {
            JSONObject jSONObject;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (JSONObject) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
                jSONObject = new JSONObject();
            }
            return b(jSONObject);
        }

        public JSONObject b(JSONObject jSONObject) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (JSONObject) iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSONObject);
            }
            return jSONObject;
        }
    }

    void addReportClick(int i3, boolean z16, String str);

    void addTroopApp(ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2);

    void addTroopAppInfo(Long l3, TroopAppInfo troopAppInfo);

    void addTroopAppInfos(ArrayList<TroopAIOAppInfo> arrayList, int i3);

    void clearLocalTroopAppRedPoint(int i3);

    void clearTroopAppRedPoint(int i3, int i16);

    void clearTroopAppRedPoints();

    void clickReport();

    boolean ensureAppInfoExist(TroopAIOAppInfo troopAIOAppInfo);

    JSONObject getAppConfig(String str);

    TroopAIOAppInfo getAppInfo(int i3, int i16);

    boolean getAppListChangedFromWebOperate(int i3);

    int getAppListTimestamp(int i3);

    List<TroopAIOAppInfo> getCopyAppInfos(List<TroopAIOAppInfo> list);

    boolean getProfileAppListChangedFromWebOperate(String str);

    List<TroopAIOAppInfo> getTroopAppList(boolean z16, int i3);

    List<TroopAIOAppInfo> getTroopAppList(boolean z16, TroopInfo troopInfo);

    byte[] getTroopAppListData(String str);

    ArrayList<Long> getTroopCardAppIdListCache(String str);

    ArrayList<TroopAppInfo> getTroopCardAppInfosCache(ArrayList<Long> arrayList);

    boolean isCheckedUpdateAfterLogined(int i3);

    boolean makeAppidsInOrder(List<Integer> list, int i3);

    boolean needRequestDetail(TroopAIOAppInfo troopAIOAppInfo);

    void removeTroopAppByAppid(int i3, int i16);

    void saveAppListTimestamp(int i3, int i16);

    void setAppListChangedFromWebOperate(boolean z16);

    void setCheckedUpdateAfterLogined(boolean z16, int i3);

    void setProfileAppListChangedFromWebOperate(boolean z16, String str);

    void setTroopAppListData(String str, byte[] bArr);

    void setTroopCardAppListCache(String str, ArrayList<Long> arrayList);

    void sortTroopAppList(ArrayList<Integer> arrayList);

    void tryParseAppConfig(JSONObject jSONObject);

    void update0xca02Info(String str);

    void updateAppInfoCalendarDay(int i3);
}
