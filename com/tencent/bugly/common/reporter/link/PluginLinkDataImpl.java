package com.tencent.bugly.common.reporter.link;

import android.text.TextUtils;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.bugly.common.trace.TraceGenerator;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import com.tencent.rmonitor.common.logger.Logger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class PluginLinkDataImpl implements PluginLinkData {
    protected static final int CACHE_SIZE_AFTER_SHRINK = 375;
    protected static final int LIMIT_SIZE_AFTER_SHRINK = 100;
    protected static final int MAX_CACHE_SIZE = 500;
    private static final String TAG = "RMonitor_link";
    private final LinkedList<LinkData> currentLaunchCache = new LinkedList<>();
    private LinkDataDBCacheMng dbCacheMng;

    private void assembleLinkages(JSONObject jSONObject, List<LinkData> list) {
        try {
            HashSet hashSet = new HashSet(5);
            Iterator<LinkData> it = list.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next().getKey());
            }
            JSONArray jSONArray = new JSONArray();
            Iterator it5 = hashSet.iterator();
            while (it5.hasNext()) {
                jSONArray.mo162put((String) it5.next());
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(ReportDataBuilder.KEY_ATTRIBUTES);
            if (optJSONObject == null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(ReportDataBuilder.KEY_LINKAGE, jSONArray);
                jSONObject.put(ReportDataBuilder.KEY_ATTRIBUTES, jSONObject2);
                return;
            }
            optJSONObject.put(ReportDataBuilder.KEY_LINKAGE, jSONArray);
        } catch (Throwable th5) {
            Logger.f365497g.d(TAG, "collect plugin link data fail for " + th5.getMessage());
        }
    }

    private List<LinkData> getDesiredLinkData(LinkData linkData, List<String> list) {
        if (isCurrentLaunchData(linkData)) {
            return getDesiredLinkDataInner(linkData, list, this.currentLaunchCache);
        }
        return getDesiredLinkDataInner(linkData, list, loadFromDB(linkData.launchID, linkData.processLaunchID));
    }

    private List<LinkData> getDesiredLinkDataInner(LinkData linkData, List<String> list, List<LinkData> list2) {
        String key;
        ArrayList arrayList = null;
        if (list2 != null && !list2.isEmpty()) {
            for (LinkData linkData2 : list2) {
                if (linkData2 == null) {
                    key = "";
                } else {
                    key = linkData2.getKey();
                }
                if (list.contains(key) && linkData.isDesiredLinkage(linkData2)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(linkData2);
                }
            }
        }
        return arrayList;
    }

    private boolean isCurrentLaunchData(@NotNull LinkData linkData) {
        return TextUtils.equals(linkData.processLaunchID, TraceGenerator.getProcessLaunchId());
    }

    private List<LinkData> loadFromDB(String str, String str2) {
        LinkDataDBCacheMng linkDataDBCacheMng = this.dbCacheMng;
        if (linkDataDBCacheMng != null) {
            return linkDataDBCacheMng.loadFromDB(str, str2);
        }
        return null;
    }

    private void saveToDB(LinkData linkData) {
        LinkDataDBCacheMng linkDataDBCacheMng = this.dbCacheMng;
        if (linkDataDBCacheMng != null) {
            linkDataDBCacheMng.saveToDB(linkData);
        }
    }

    private void shrinkCache() {
        if (this.currentLaunchCache.size() < 500) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long j3 = 60 + currentTimeMillis;
        shrinkCache(currentTimeMillis - 3600, j3, 500);
        if (this.currentLaunchCache.size() > 375) {
            shrinkCache(currentTimeMillis - JoinTimeType.THIRTY_MINUTES, j3, 100);
        }
    }

    @Override // com.tencent.bugly.common.reporter.link.PluginLinkData
    public void collectPluginLinkData(JSONObject jSONObject, List<String> list) {
        LinkData fromJson;
        List<LinkData> desiredLinkData;
        if (jSONObject != null && list != null && !list.isEmpty() && (fromJson = LinkData.fromJson(jSONObject)) != null && (desiredLinkData = getDesiredLinkData(fromJson, list)) != null && !desiredLinkData.isEmpty()) {
            assembleLinkages(jSONObject, desiredLinkData);
        }
    }

    @Override // com.tencent.bugly.common.reporter.link.PluginLinkData
    public LinkDataDBCacheMng getLinkDataDBCacheMng() {
        return this.dbCacheMng;
    }

    @Override // com.tencent.bugly.common.reporter.link.PluginLinkData
    public LinkData getRecentLinkDataFromCurrentLaunch(String str, String str2, long j3) {
        Iterator<LinkData> it = this.currentLaunchCache.iterator();
        long j16 = Long.MAX_VALUE;
        LinkData linkData = null;
        while (it.hasNext()) {
            LinkData next = it.next();
            if (TextUtils.equals(str, next.baseType) && TextUtils.equals(str2, next.subType)) {
                long abs = Math.abs(next.eventTimeInMS - j3);
                if (abs < j16) {
                    linkData = next;
                    j16 = abs;
                }
            }
        }
        return linkData;
    }

    @Override // com.tencent.bugly.common.reporter.link.PluginLinkData
    public void recordPluginLinkData(JSONObject jSONObject) {
        LinkData fromJson;
        if (jSONObject != null && (fromJson = LinkData.fromJson(jSONObject)) != null && !fromJson.isInvalid() && !this.currentLaunchCache.contains(fromJson)) {
            this.currentLaunchCache.add(fromJson);
            shrinkCache();
            saveToDB(fromJson);
        }
    }

    @Override // com.tencent.bugly.common.reporter.link.PluginLinkData
    public void setLinkDataDBCacheMng(LinkDataDBCacheMng linkDataDBCacheMng) {
        this.dbCacheMng = linkDataDBCacheMng;
    }

    private void shrinkCache(long j3, long j16, int i3) {
        int i16 = 0;
        for (int size = this.currentLaunchCache.size() - 1; size >= 0; size--) {
            LinkData linkData = this.currentLaunchCache.get(size);
            if (i16 >= i3) {
                this.currentLaunchCache.remove(linkData);
            } else {
                long j17 = linkData.eventTime;
                if (j3 > j17 || j17 > j16) {
                    this.currentLaunchCache.remove(linkData);
                } else {
                    i16++;
                }
            }
        }
    }
}
