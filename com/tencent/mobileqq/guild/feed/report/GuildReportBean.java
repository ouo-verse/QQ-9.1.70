package com.tencent.mobileqq.guild.feed.report;

import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildReportBean implements Serializable {
    public static final String TAG = "GuildReportBean";
    private static final long serialVersionUID = 2688137205670436632L;
    private String mDtFromPageId;
    private String mDtPageId;
    private int mFromPageId;
    private int mPageId;

    public GuildReportBean() {
        this.mPageId = -1;
    }

    public static int getParentPageId(String str, GuildReportBean guildReportBean) {
        if (guildReportBean != null) {
            QLog.d(str, 1, ":getParentPageId value:" + guildReportBean.getPageId());
            return guildReportBean.getFromPageId();
        }
        QLog.d(str, 1, ":getParentPageId return invalid value:0");
        return 0;
    }

    public static GuildReportBean getReportBean(String str, GuildReportBean guildReportBean) {
        if (guildReportBean == null) {
            if (((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isDebugVersion()) {
                QLog.d(TAG, 1, str + ":getReportBean is empty");
            } else {
                return new GuildReportBean();
            }
        }
        return guildReportBean;
    }

    public static boolean isContentDetailPage(int i3) {
        return true;
    }

    public static boolean isFeedDetailPage(int i3) {
        return true;
    }

    public static GuildReportBean setReportBean(String str, GuildReportBean guildReportBean) {
        if (guildReportBean == null) {
            QLog.d(TAG, 1, str + ":setReportBean input is null");
            return null;
        }
        return guildReportBean.m186clone();
    }

    public void assembleFromReportData(GuildReportBean guildReportBean) {
        this.mFromPageId = guildReportBean.mPageId;
    }

    public String getDtFromPageId() {
        return this.mDtFromPageId;
    }

    public String getDtPageId() {
        return this.mDtPageId;
    }

    public int getFromPageId() {
        return this.mFromPageId;
    }

    public int getPageId() {
        return this.mPageId;
    }

    public GuildReportBean setDtFromPageId(String str) {
        this.mDtFromPageId = str;
        return this;
    }

    public GuildReportBean setDtPageId(String str) {
        this.mDtPageId = str;
        return this;
    }

    public GuildReportBean setFromPageId(int i3) {
        this.mFromPageId = i3;
        return this;
    }

    public GuildReportBean setPageId(int i3) {
        this.mPageId = i3;
        return this;
    }

    public static int getPageId(String str, GuildReportBean guildReportBean) {
        if (guildReportBean != null) {
            QLog.d(str, 1, ":getPageId value:" + guildReportBean.getPageId());
            return guildReportBean.getPageId();
        }
        QLog.d(str, 1, ":getPageId return invalid value:-1");
        return -1;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public GuildReportBean m186clone() {
        GuildReportBean guildReportBean = new GuildReportBean();
        guildReportBean.mFromPageId = this.mFromPageId;
        guildReportBean.mPageId = this.mPageId;
        guildReportBean.mDtPageId = this.mDtPageId;
        guildReportBean.mDtFromPageId = this.mDtFromPageId;
        return guildReportBean;
    }

    public GuildReportBean(int i3) {
        this.mPageId = i3;
    }
}
