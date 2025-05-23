package com.tencent.mobileqq.qqexpand.manager;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.util.MqqWeakReferenceHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ExtendFriendSearchHistoryManager implements Handler.Callback {
    private static final Object C = new Object();

    /* renamed from: d, reason: collision with root package name */
    private int f263890d;

    /* renamed from: e, reason: collision with root package name */
    WeakReference<BaseQQAppInterface> f263891e;

    /* renamed from: f, reason: collision with root package name */
    WeakReference<a> f263892f;

    /* renamed from: i, reason: collision with root package name */
    private boolean f263894i;

    /* renamed from: h, reason: collision with root package name */
    List<String> f263893h = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    private MqqWeakReferenceHandler f263895m = new MqqWeakReferenceHandler(ThreadManagerV2.getFileThreadLooper(), this);

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
        void Db();
    }

    public ExtendFriendSearchHistoryManager(BaseQQAppInterface baseQQAppInterface, int i3) {
        this.f263891e = new WeakReference<>(baseQQAppInterface);
        this.f263890d = i3;
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.manager.ExtendFriendSearchHistoryManager.1
            @Override // java.lang.Runnable
            public void run() {
                ExtendFriendSearchHistoryManager.this.e();
            }
        }, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        List list;
        WeakReference<a> weakReference;
        BaseQQAppInterface baseQQAppInterface = this.f263891e.get();
        if (baseQQAppInterface == null) {
            return;
        }
        boolean z16 = false;
        Object readObject = FileUtils.readObject(String.format("%s_%s_%s", "extend_frd_search_history", Integer.valueOf(this.f263890d), baseQQAppInterface.getCurrentAccountUin()));
        if (this.f263894i) {
            return;
        }
        if (readObject != null && (readObject instanceof List)) {
            list = (List) readObject;
        } else {
            list = null;
        }
        if (list == null) {
            list = new ArrayList();
        }
        synchronized (C) {
            if (!this.f263894i) {
                this.f263893h.addAll(list);
                while (this.f263893h.size() > 10) {
                    List<String> list2 = this.f263893h;
                    list2.remove(list2.size() - 1);
                }
                this.f263894i = true;
                z16 = true;
            }
        }
        if (z16 && (weakReference = this.f263892f) != null && weakReference.get() != null) {
            this.f263892f.get().Db();
        }
    }

    private void f() {
        BaseQQAppInterface baseQQAppInterface = this.f263891e.get();
        if (baseQQAppInterface == null) {
            return;
        }
        FileUtils.writeObject(String.format("%s_%s_%s", "extend_frd_search_history", Integer.valueOf(this.f263890d), baseQQAppInterface.getCurrentAccountUin()), this.f263893h);
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!this.f263894i) {
            e();
        }
        synchronized (C) {
            if (this.f263893h.contains(str)) {
                this.f263893h.remove(str);
            }
            this.f263893h.add(0, str);
            if (this.f263893h.size() > 10) {
                this.f263893h.remove(r4.size() - 1);
            }
        }
        WeakReference<a> weakReference = this.f263892f;
        if (weakReference != null && weakReference.get() != null) {
            this.f263892f.get().Db();
        }
        if (!this.f263895m.hasMessages(0)) {
            this.f263895m.sendEmptyMessageDelayed(0, 300L);
        }
    }

    public void c() {
        synchronized (C) {
            this.f263893h.clear();
            this.f263894i = true;
        }
        WeakReference<a> weakReference = this.f263892f;
        if (weakReference != null && weakReference.get() != null) {
            this.f263892f.get().Db();
        }
        if (!this.f263895m.hasMessages(0)) {
            this.f263895m.sendEmptyMessageDelayed(0, 300L);
        }
    }

    public List<String> d() {
        return this.f263893h;
    }

    public void g(a aVar) {
        if (aVar != null) {
            this.f263892f = new WeakReference<>(aVar);
        } else {
            this.f263892f = null;
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            f();
            return false;
        }
        return false;
    }
}
