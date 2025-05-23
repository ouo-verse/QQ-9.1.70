package com.huawei.hms.common.internal;

import java.util.ArrayList;
import java.util.ListIterator;

/* compiled from: P */
/* loaded from: classes2.dex */
public class BindResolveClients {

    /* renamed from: b, reason: collision with root package name */
    private static final Object f36851b = new Object();

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<ResolveClientBean> f36852a;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final BindResolveClients f36853a = new BindResolveClients();
    }

    public static BindResolveClients getInstance() {
        return b.f36853a;
    }

    public boolean isClientRegistered(ResolveClientBean resolveClientBean) {
        boolean contains;
        synchronized (f36851b) {
            contains = this.f36852a.contains(resolveClientBean);
        }
        return contains;
    }

    public void notifyClientReconnect() {
        synchronized (f36851b) {
            ListIterator<ResolveClientBean> listIterator = this.f36852a.listIterator();
            while (listIterator.hasNext()) {
                listIterator.next().clientReconnect();
            }
            this.f36852a.clear();
        }
    }

    public void register(ResolveClientBean resolveClientBean) {
        if (resolveClientBean == null) {
            return;
        }
        synchronized (f36851b) {
            if (!this.f36852a.contains(resolveClientBean)) {
                this.f36852a.add(resolveClientBean);
            }
        }
    }

    public void unRegister(ResolveClientBean resolveClientBean) {
        if (resolveClientBean == null) {
            return;
        }
        synchronized (f36851b) {
            if (this.f36852a.contains(resolveClientBean)) {
                ListIterator<ResolveClientBean> listIterator = this.f36852a.listIterator();
                while (true) {
                    if (!listIterator.hasNext()) {
                        break;
                    } else if (resolveClientBean.equals(listIterator.next())) {
                        listIterator.remove();
                        break;
                    }
                }
            }
        }
    }

    public void unRegisterAll() {
        synchronized (f36851b) {
            this.f36852a.clear();
        }
    }

    BindResolveClients() {
        this.f36852a = new ArrayList<>();
    }
}
