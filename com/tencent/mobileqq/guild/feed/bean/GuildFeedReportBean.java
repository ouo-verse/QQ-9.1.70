package com.tencent.mobileqq.guild.feed.bean;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* compiled from: P */
@Keep
/* loaded from: classes13.dex */
public class GuildFeedReportBean implements Serializable {

    @SerializedName("reportList")
    private List<ReportBean> reportList;

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class ReportBean implements Serializable {

        @SerializedName("event")
        private String event;

        @SerializedName("params")
        private Map<String, String> params;

        @SerializedName("taskName")
        private String taskName;

        public String getEvent() {
            return this.event;
        }

        public Map<String, String> getParams() {
            return this.params;
        }

        public String getTaskName() {
            return this.taskName;
        }

        public void setEvent(String str) {
            this.event = str;
        }

        public void setParams(Map<String, String> map) {
            this.params = map;
        }

        public void setTaskName(String str) {
            this.taskName = str;
        }

        public String toString() {
            return "ReportBean{taskName='" + this.taskName + "', event='" + this.event + "', params=" + this.params + '}';
        }
    }

    public List<ReportBean> getReportList() {
        return this.reportList;
    }

    public void setReportList(List<ReportBean> list) {
        this.reportList = list;
    }

    public String toString() {
        return "GuildFeedReportBean{reportList=" + this.reportList + '}';
    }
}
