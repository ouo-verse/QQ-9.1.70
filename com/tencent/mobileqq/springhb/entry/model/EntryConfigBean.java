package com.tencent.mobileqq.springhb.entry.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class EntryConfigBean implements Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "SpringHb_EntryConfig";

    @NotNull
    public List<BaseActivityData> activities;

    @NotNull
    public CommonData commonData;
    public List<Integer> delayList;

    @Nullable
    public DragonCardConfigData dragonCardConfigData;

    @Nullable
    public HtmlOfflineCheckConfig htmlOfflineCheckConfig;

    @NotNull
    public List<MsgTabBannerData> msgTabBanners;
    public int peakVersion;

    @Nullable
    public PendantData redDotPendantData;
    public int taskId;
    public int version;

    public EntryConfigBean() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.version = 0;
        this.taskId = 0;
        this.peakVersion = 0;
        this.delayList = new ArrayList();
        this.commonData = CommonData.newEmpty();
        this.msgTabBanners = new ArrayList();
        this.activities = new ArrayList();
    }

    private int a(int i3, List<Integer> list) {
        if (list != null && list.size() > 0) {
            return list.get(Math.abs(i3) % list.size()).intValue() * 1000;
        }
        return 0;
    }

    private void b(JSONArray jSONArray) {
        BaseActivityData preGrabActivityData;
        if (jSONArray != null) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                Object opt = jSONArray.opt(i3);
                if (opt instanceof JSONObject) {
                    JSONObject jSONObject = (JSONObject) opt;
                    int optInt = jSONObject.optInt("Type");
                    if (optInt != 1) {
                        if (optInt != 2) {
                            preGrabActivityData = null;
                        } else {
                            preGrabActivityData = new OnGrabActivityData();
                        }
                    } else {
                        preGrabActivityData = new PreGrabActivityData();
                    }
                    if (preGrabActivityData != null) {
                        preGrabActivityData.parseJson(jSONObject);
                        this.activities.add(preGrabActivityData);
                    }
                }
            }
        }
    }

    private void c(JSONArray jSONArray) {
        if (jSONArray != null) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                Object opt = jSONArray.opt(i3);
                if (opt instanceof JSONObject) {
                    MsgTabBannerData msgTabBannerData = new MsgTabBannerData();
                    msgTabBannerData.parseJson((JSONObject) opt);
                    this.msgTabBanners.add(msgTabBannerData);
                }
            }
        }
    }

    private void d() {
        Collections.sort(this.activities, com.tencent.mobileqq.springhb.b.f288967a);
        Iterator<BaseActivityData> it = this.activities.iterator();
        BaseActivityData baseActivityData = null;
        while (it.hasNext()) {
            BaseActivityData next = it.next();
            if (!com.tencent.mobileqq.springhb.b.e(next.getConfigTime())) {
                it.remove();
                QLog.d(TAG, 1, String.format("validateActivityList time invalid remove. %s time=%s", next, next.getConfigTime()));
            } else {
                if (baseActivityData != null) {
                    next.configTimeInfo = com.tencent.mobileqq.springhb.b.f(baseActivityData.configTimeInfo, next.configTimeInfo);
                    if (!com.tencent.mobileqq.springhb.b.e(next.getConfigTime())) {
                        it.remove();
                        QLog.d(TAG, 1, String.format("validateActivityList time invalid after valid cross over remove. %s", next));
                    }
                }
                next.validate();
                baseActivityData = next;
            }
        }
    }

    private void e() {
        Collections.sort(this.msgTabBanners, com.tencent.mobileqq.springhb.b.f288967a);
        Iterator<MsgTabBannerData> it = this.msgTabBanners.iterator();
        MsgTabBannerData msgTabBannerData = null;
        while (it.hasNext()) {
            MsgTabBannerData next = it.next();
            if (!com.tencent.mobileqq.springhb.b.e(next.getConfigTime())) {
                it.remove();
                QLog.d(TAG, 1, String.format("validatePopBannerList time invalid remove. %s", next));
            } else {
                if (msgTabBannerData != null) {
                    next.configTimeInfo = com.tencent.mobileqq.springhb.b.f(msgTabBannerData.configTimeInfo, next.configTimeInfo);
                    if (!com.tencent.mobileqq.springhb.b.e(next.getConfigTime())) {
                        it.remove();
                        QLog.d(TAG, 1, String.format("validatePopBannerList time invalid after valid cross over remove. %s", next));
                    }
                }
                msgTabBannerData = next;
            }
        }
    }

    public String getSimpleStringActivities() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        Iterator<BaseActivityData> it = this.activities.iterator();
        while (it.hasNext()) {
            sb5.append(it.next().toSimpleString());
            sb5.append("|");
        }
        return sb5.toString();
    }

    public String getSimpleStringMsgTabBanners() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        Iterator<MsgTabBannerData> it = this.msgTabBanners.iterator();
        while (it.hasNext()) {
            sb5.append(it.next().toSimpleString());
            sb5.append("|");
        }
        return sb5.toString();
    }

    public void parseJson(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSONObject);
            return;
        }
        if (jSONObject == null) {
            return;
        }
        try {
            this.commonData.parseJson(jSONObject.optJSONObject("Common"));
            PendantData parseJson = PendantData.parseJson(jSONObject.optJSONObject("CollectStarPendant"));
            if (parseJson != null) {
                parseJson.isRedDotPendant = true;
                this.redDotPendantData = parseJson;
            }
            b(jSONObject.optJSONArray("ActivityList"));
            c(jSONObject.optJSONArray("MsgTabBannerList"));
            JSONObject optJSONObject = jSONObject.optJSONObject("htmloffline_check_configs");
            if (optJSONObject != null) {
                HtmlOfflineCheckConfig htmlOfflineCheckConfig = new HtmlOfflineCheckConfig();
                this.htmlOfflineCheckConfig = htmlOfflineCheckConfig;
                htmlOfflineCheckConfig.parseJson(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("DragonGooseConfig");
            if (optJSONObject2 != null) {
                DragonCardConfigData dragonCardConfigData = new DragonCardConfigData();
                this.dragonCardConfigData = dragonCardConfigData;
                dragonCardConfigData.parseJson(optJSONObject2);
            }
        } catch (Throwable th5) {
            QLog.d(TAG, 1, th5.getMessage(), th5);
        }
    }

    public void preHandleConfigs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        int i3 = 0;
        QLog.d(TAG, 1, String.format("preHandleConfigs pVer=%d delayList=%s", Integer.valueOf(this.peakVersion), Arrays.toString(this.delayList.toArray())));
        Collections.sort(this.msgTabBanners, com.tencent.mobileqq.springhb.b.f288967a);
        Collections.sort(this.activities, com.tencent.mobileqq.springhb.b.f288967a);
        int i16 = 0;
        for (MsgTabBannerData msgTabBannerData : this.msgTabBanners) {
            if (msgTabBannerData.staggerPeakSwitch) {
                int i17 = i16 + 1;
                int a16 = a(i16, this.delayList);
                long j3 = a16;
                if (msgTabBannerData.getTaskTime().begin + j3 < msgTabBannerData.getTaskTime().end) {
                    msgTabBannerData.peakDelayMs = a16;
                    msgTabBannerData.getTaskTime().begin += j3;
                }
                i16 = i17;
            }
        }
        for (BaseActivityData baseActivityData : this.activities) {
            if (baseActivityData.staggerPeakSwitch) {
                int i18 = i3 + 1;
                int a17 = a(i3, this.delayList);
                long j16 = a17;
                if (baseActivityData.getTaskTime().begin + j16 < baseActivityData.getTaskTime().end) {
                    baseActivityData.peakDelayMs = a17;
                    if (baseActivityData.scheduleTaskAfterPeak()) {
                        baseActivityData.getTaskTime().begin += j16;
                        baseActivityData.updatePeakDelay(a17);
                    }
                }
                i3 = i18;
            }
        }
    }

    public String toSimpleString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("EntryConfigBean{version=");
        sb5.append(this.version);
        sb5.append(", peakVersion=");
        sb5.append(this.peakVersion);
        sb5.append(", taskId=");
        sb5.append(this.taskId);
        sb5.append(", delayList=");
        sb5.append(Arrays.toString(this.delayList.toArray()));
        sb5.append(", \ncommonData=");
        sb5.append(this.commonData.toSimpleString());
        sb5.append(", \nmsgTabBanners=");
        sb5.append(getSimpleStringMsgTabBanners());
        sb5.append(", \nactivities=");
        sb5.append(getSimpleStringActivities());
        sb5.append(", \nhtmlOfflineCheckConfig=");
        Object obj = this.htmlOfflineCheckConfig;
        if (obj == null) {
            obj = "null";
        }
        sb5.append(obj);
        sb5.append('}');
        return sb5.toString();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("EntryConfigBean{version=");
        sb5.append(this.version);
        sb5.append(", peakVersion=");
        sb5.append(this.peakVersion);
        sb5.append(", taskId=");
        sb5.append(this.taskId);
        sb5.append(", delayList=");
        sb5.append(Arrays.toString(this.delayList.toArray()));
        sb5.append(", \ncommonData=");
        sb5.append(this.commonData);
        sb5.append(", \nmsgTabBanners=");
        sb5.append(Arrays.toString(this.msgTabBanners.toArray()));
        sb5.append(", \nactivities=");
        sb5.append(Arrays.toString(this.activities.toArray()));
        sb5.append(", \nhtmlOfflineCheckConfig=");
        Object obj = this.htmlOfflineCheckConfig;
        if (obj == null) {
            obj = "null";
        }
        sb5.append(obj);
        sb5.append('}');
        return sb5.toString();
    }

    public void validate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            e();
            d();
        }
    }
}
