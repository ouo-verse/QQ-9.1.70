package com.tencent.mobileqq.onlinestatus;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.DropTransaction;
import com.tencent.mobileqq.persistence.transaction.PersistOrReplaceTransaction;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class AutoReplyManagerImpl implements com.tencent.mobileqq.onlinestatus.manager.b {

    /* renamed from: d, reason: collision with root package name */
    private EntityManager f255289d;

    /* renamed from: e, reason: collision with root package name */
    private Object f255290e = new Object();

    /* renamed from: f, reason: collision with root package name */
    private List<AutoReplyText> f255291f;

    public AutoReplyManagerImpl(AppInterface appInterface) {
        this.f255289d = appInterface.getEntityManagerFactory().createEntityManager();
        C();
    }

    private void C() {
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.AutoReplyManagerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (AutoReplyManagerImpl.this.f255290e) {
                    if (AutoReplyManagerImpl.this.f255291f == null) {
                        List<? extends Entity> query = AutoReplyManagerImpl.this.f255289d.query(AutoReplyText.class);
                        if (query != null && query.size() > 0) {
                            if (AutoReplyManagerImpl.this.f255291f == null) {
                                AutoReplyManagerImpl.this.f255291f = new ArrayList();
                            } else {
                                AutoReplyManagerImpl.this.f255291f.clear();
                            }
                            AutoReplyManagerImpl.this.f255291f.addAll(query);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("AutoReplyManager", 2, String.format("initAutoReplyListCache, textList: %s", query));
                        }
                    } else if (QLog.isColorLevel()) {
                        QLog.d("AutoReplyManager", 2, "initAutoReplyListCache, but it had init");
                    }
                }
            }
        });
    }

    public List<AutoReplyText> B() {
        List<AutoReplyText> list = this.f255291f;
        if (list != null && list.size() > 0) {
            return new ArrayList(this.f255291f);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new AutoReplyText(HardCodeUtil.qqStr(R.string.juc), 0));
        arrayList.add(new AutoReplyText(HardCodeUtil.qqStr(R.string.jub), 1));
        arrayList.add(new AutoReplyText(HardCodeUtil.qqStr(R.string.ju_), 2));
        arrayList.add(new AutoReplyText(HardCodeUtil.qqStr(R.string.jua), Integer.MAX_VALUE));
        ((AutoReplyText) arrayList.get(0)).mCheckFlag = 1;
        if (QLog.isColorLevel()) {
            QLog.d("AutoReplyManager", 2, "getAutoReplyCache, buffList == null");
        }
        C();
        return arrayList;
    }

    @Override // com.tencent.mobileqq.onlinestatus.manager.b
    public AutoReplyText a() {
        List<AutoReplyText> B = B();
        AutoReplyText autoReplyText = null;
        for (AutoReplyText autoReplyText2 : B) {
            if (autoReplyText2.isChecked()) {
                autoReplyText = autoReplyText2;
            }
        }
        if (autoReplyText == null) {
            autoReplyText = B.get(0);
            QLog.d("AutoReplyManager", 1, "getCurrentAutoReplyText is null, default check index 0");
        }
        if (QLog.isColorLevel()) {
            QLog.d("AutoReplyManager", 2, "getCurrentAutoReplyText: " + autoReplyText);
        }
        return autoReplyText;
    }

    @Override // com.tencent.mobileqq.onlinestatus.manager.b
    public void e(List<AutoReplyText> list, int i3) {
        if (list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(new DropTransaction((Class<? extends Entity>) AutoReplyText.class));
            for (AutoReplyText autoReplyText : list) {
                if (autoReplyText.getTextId() == i3) {
                    autoReplyText.mCheckFlag = 1;
                } else {
                    autoReplyText.mCheckFlag = 0;
                }
                arrayList.add(new PersistOrReplaceTransaction(autoReplyText));
            }
            this.f255289d.doMultiDBOperateByTransaction(arrayList);
            if (QLog.isColorLevel()) {
                QLog.d("AutoReplyManager", 2, String.format("updateAutoReplyListCache, textList: %s, selectId: %s", list, Integer.valueOf(i3)));
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.d("AutoReplyManager", 1, "updateAutoReplyList, exception: ", e16);
        }
        synchronized (this.f255290e) {
            List<AutoReplyText> list2 = this.f255291f;
            if (list2 == null) {
                this.f255291f = new ArrayList();
            } else {
                list2.clear();
            }
            this.f255291f.addAll(list);
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.manager.j
    public void onDestroy() {
        if (QLog.isColorLevel()) {
            QLog.d("AutoReplyManager", 2, "AutoReplyManager onDestroy");
        }
        this.f255289d.close();
    }
}
