package com.tencent.mobileqq.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes10.dex */
public class PAMessage implements Serializable {
    private static final long serialVersionUID = 243242567575L;
    public String grayTips;
    public ArrayList<Item> items;
    public long mMsgId;
    public String moreText;

    /* renamed from: msg, reason: collision with root package name */
    public String f203110msg;
    public long sendTime;
    public int type;

    /* loaded from: classes10.dex */
    public static class Item implements Serializable {
        private static final long serialVersionUID = 3414344565L;
        public String a_actionData;
        public String a_rankListUrl;
        public String actionData;
        public String actionUrl;
        public String androidUrl;
        public String cover;
        public String desc;
        public List<String> digestList;
        public long flag;
        public String i_actionData;
        public String i_rankListUrl;
        public String icon;
        public String iconsString;
        public String iosUrl;
        public String isAd;
        public int mVideoFlag;
        public String nativeJumpString;
        public String nowTime;
        public String oneWeather;
        public String rankListDownload;
        public String rankListName;
        public String rankListSchema;
        public String senderEmail;
        public String senderName;
        public String source;
        public long time;
        public String title;
        public String twoWeather;
        public String type;
        public String url;
        public String weaArea;
        public String weaExposeUrl;
        public String weaJumpUrl;
        public String weaTemper;
        public String weather;
        public boolean needLogin = false;
        public long appId = 0;
    }
}
