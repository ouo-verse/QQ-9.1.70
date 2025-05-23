package com.tencent.youtu.sdkkitframework.common;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class OperateInfoManager {
    static IPatchRedirector $redirector_;
    private static OperateInfoManager instance;
    private Map<String, Object> catchError;
    private List<Long> useTimes;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11374);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            instance = new OperateInfoManager();
        }
    }

    OperateInfoManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.catchError = new HashMap();
            this.useTimes = new ArrayList();
        }
    }

    public static OperateInfoManager getInstance() {
        return instance;
    }

    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        Map<String, Object> map = this.catchError;
        if (map != null) {
            map.clear();
        }
        List<Long> list = this.useTimes;
        if (list != null) {
            list.clear();
        }
    }

    public String conservationVideoErrorData(String str, Integer num) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) num);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("event_id", "conservation_video_message");
        hashMap.put("info", str);
        if (num.intValue() == 400104) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        hashMap.put("value", Integer.valueOf(i3));
        hashMap.put("Done", 1);
        return new JSONObject(hashMap).toString();
    }

    public String makeCatchErrorData() {
        ArrayList arrayList;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.catchError == null) {
            this.catchError = new HashMap();
        }
        if (this.catchError.containsKey("info")) {
            arrayList = (ArrayList) this.catchError.get("info");
        } else {
            arrayList = new ArrayList();
        }
        this.catchError.put("info", arrayList.toString());
        Map<String, Object> map = this.catchError;
        if (arrayList.size() == 0) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        map.put("value", Integer.valueOf(i3));
        this.catchError.put("event_id", "YTCatchError");
        this.catchError.put("Done", 1);
        JSONObject jSONObject = new JSONObject(this.catchError);
        this.catchError.clear();
        return jSONObject.toString();
    }

    public String makePackUseTime() {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("event_id", "MakePackUseTime");
        hashMap.put("Done", 1);
        hashMap.put("info", "");
        List<Long> list = this.useTimes;
        if (list != null) {
            Iterator<Long> it = list.iterator();
            j3 = 0;
            while (it.hasNext()) {
                j3 += it.next().longValue();
            }
            this.useTimes.clear();
        } else {
            j3 = 0;
        }
        if (j3 == 0) {
            return null;
        }
        hashMap.put("value", Long.valueOf(j3));
        return new JSONObject(hashMap).toString();
    }

    public void setCatchErrorData(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        if (!this.catchError.containsKey("info")) {
            this.catchError.put("info", new ArrayList());
        }
        ((ArrayList) this.catchError.get("info")).add(str);
    }

    public void setPackUseTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, j3);
        } else {
            this.useTimes.add(Long.valueOf(j3));
        }
    }
}
