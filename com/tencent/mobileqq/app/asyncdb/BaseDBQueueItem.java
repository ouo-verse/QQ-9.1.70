package com.tencent.mobileqq.app.asyncdb;

import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class BaseDBQueueItem {
    static IPatchRedirector $redirector_ = null;
    public static final int QUEUE_ACTION_DELETE = 2;
    public static final int QUEUE_ACTION_INSERT = 0;
    public static final int QUEUE_ACTION_UPDATE = 1;
    public static final int QUEUE_NOTIFY_ATONCE = 1;
    public static final int QUEUE_NOTIFY_DEFAULT = 0;
    public static final int QUEUE_NOTIFY_DELAY = 2;
    public int action;
    public Entity item;
    ProxyListener listener;
    public int notify;

    public BaseDBQueueItem(Entity entity, int i3, int i16, ProxyListener proxyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, entity, Integer.valueOf(i3), Integer.valueOf(i16), proxyListener);
            return;
        }
        this.item = entity;
        this.action = i3;
        this.notify = i16;
        this.listener = proxyListener;
    }
}
