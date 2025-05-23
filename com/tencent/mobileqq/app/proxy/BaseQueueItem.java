package com.tencent.mobileqq.app.proxy;

import android.content.ContentValues;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class BaseQueueItem {
    static IPatchRedirector $redirector_ = null;
    public static final int QUEUE_ITEM_ACTION_DELETE = 5;
    public static final int QUEUE_ITEM_ACTION_DELETE_WITH_CLAUSE = 6;
    public static final int QUEUE_ITEM_ACTION_INSERT = 3;
    public static final int QUEUE_ITEM_ACTION_UPDATE = 4;
    public static final int QUEUE_MESSAGE_ACTION_DELETE = 2;
    public static final int QUEUE_MESSAGE_ACTION_INSERT = 0;
    public static final int QUEUE_MESSAGE_ACTION_UPDATE = 1;
    public int action;
    public String frindUin;
    public Entity item;
    ProxyListener listener;
    public String tableName;
    public int type;
    public ContentValues value;
    public String[] whereArgs;
    public String whereClause;

    public BaseQueueItem(String str, int i3, String str2, Entity entity, int i16, ProxyListener proxyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), str2, entity, Integer.valueOf(i16), proxyListener);
            return;
        }
        this.frindUin = str;
        this.type = i3;
        this.tableName = str2;
        this.item = entity;
        this.action = i16;
        this.listener = proxyListener;
    }

    public BaseQueueItem(String str, int i3, String str2, ContentValues contentValues, String str3, String[] strArr, int i16, ProxyListener proxyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), str2, contentValues, str3, strArr, Integer.valueOf(i16), proxyListener);
            return;
        }
        this.frindUin = str;
        this.type = i3;
        this.tableName = str2;
        this.whereClause = str3;
        this.whereArgs = strArr;
        this.value = contentValues;
        this.action = i16;
        this.listener = proxyListener;
    }
}
