package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProUnionResult extends Serializable {
    byte[] getFeedCookie();

    boolean getFeedIsEnd();

    long getFeedTotal();

    ArrayList<IGProGuildFeedSearchRes> getGuildFeeds();

    ArrayList<IGProGuildMsgSearchRes> getGuildMsgs();

    byte[] getMsgCookie();

    boolean getMsgIsEnd();

    long getMsgTotal();

    String toString();
}
