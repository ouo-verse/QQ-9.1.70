package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProGuildSearchUnionResult extends Serializable {
    byte[] getFeedCookie();

    ArrayList<IGProGuildSearchFeedGroupInfo> getFeedGroupList();

    boolean getFeedIsEnd();

    long getFeedTotal();

    ArrayList<IGProGuildSearchMsgGroupInfo> getGroupList();

    ArrayList<IGProGuildSearchGuildFeed> getGuildFeeds();

    ArrayList<IGProGuildSearchGuildMsg> getGuildMsgs();

    String getGuildName();

    String getGuildNumber();

    byte[] getMsgCookie();

    boolean getMsgIsEnd();

    long getMsgTotal();

    String toString();
}
