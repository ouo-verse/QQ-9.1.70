package com.tencent.mobileqq.activity.aio.pluspanel;

import android.text.TextUtils;
import java.io.Serializable;

/* loaded from: classes10.dex */
public abstract class PlusPanelAppInfo implements Serializable, Comparable<PlusPanelAppInfo> {
    static final long serialVersionUID = 1;
    public String action;
    public String actionType;
    public int appid;
    public boolean canRemove;
    public String enName;
    public int enableC2C;
    public int enableGroup;
    public int groupType;
    public boolean guildLiveChannel;
    public String hashVal;
    public String iconPress;
    public String iconUrl;
    public String iconYouth;
    public boolean isGray;
    public String minVersion;
    public String name;
    public boolean redPoint;
    public String simpleDayPressUrl;
    public String simpleDayUrl;
    public String simpleNightPressUrl;
    public String simpleNightUrl;
    public int sort;
    public int uinType;
    public String url;

    public abstract int defaultDrawableID();

    public abstract int getAppID();

    public String getAppName() {
        if (!TextUtils.isEmpty(this.name)) {
            return this.name;
        }
        return getTitle();
    }

    public int getManageConfigID() {
        return 0;
    }

    public int getRedDotID() {
        return 0;
    }

    public abstract String getTitle();

    public void init() {
        this.appid = 0;
        this.enableC2C = 0;
        this.enableGroup = 0;
        this.sort = 0;
        this.groupType = 0;
        this.uinType = 0;
        this.name = "";
        this.enName = "";
        this.url = "";
        this.iconUrl = "";
        this.iconPress = "";
        this.simpleDayUrl = "";
        this.simpleDayPressUrl = "";
        this.simpleNightUrl = "";
        this.simpleNightPressUrl = "";
        this.iconYouth = "";
        this.actionType = "";
        this.action = "";
        this.hashVal = "";
        this.minVersion = "";
        this.isGray = false;
        this.canRemove = false;
    }

    protected boolean isC2C() {
        if (this.uinType == 0) {
            return true;
        }
        return false;
    }

    protected boolean isDiscussion() {
        if (this.uinType == 3000) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isGuild() {
        if (this.uinType == 10014) {
            return true;
        }
        return false;
    }

    protected boolean isGuildLiveChannel() {
        return this.guildLiveChannel;
    }

    protected boolean isTroop() {
        if (this.uinType == 1) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Comparable
    public int compareTo(PlusPanelAppInfo plusPanelAppInfo) {
        if (plusPanelAppInfo != null) {
            return this.sort - plusPanelAppInfo.sort;
        }
        return 0;
    }

    protected void onChatPieLifeCycle(int i3) {
    }
}
