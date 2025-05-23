package com.tencent.mobileqq.teamworkforgroup;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.PersistOrReplaceTransaction;
import com.tencent.mobileqq.persistence.transaction.PersistTransaction;
import com.tencent.mobileqq.persistence.transaction.UpdateTransaction;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes18.dex */
public class f implements Manager {

    /* renamed from: d, reason: collision with root package name */
    AppInterface f292605d;

    /* renamed from: e, reason: collision with root package name */
    private EntityManager f292606e;

    /* renamed from: f, reason: collision with root package name */
    private ConcurrentHashMap<String, Entity> f292607f = new ConcurrentHashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f292608h = false;

    /* renamed from: i, reason: collision with root package name */
    private ConcurrentHashMap<String, Entity> f292609i = new ConcurrentHashMap<>();

    public f(AppInterface appInterface) {
        this.f292605d = appInterface;
        this.f292606e = appInterface.getEntityManagerFactory().createEntityManager();
    }

    public static String h(Context context, String str, String str2, String str3) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        if (!TextUtils.isEmpty(str)) {
            str2 = str2 + "_" + str;
        }
        return defaultSharedPreferences.getString(str2, str3);
    }

    private void j(List<GPadInfo> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<GPadInfo> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new PersistTransaction(it.next()));
        }
        this.f292606e.doMultiDBOperateByTransaction(arrayList);
    }

    private void k(List<GroupPadTemplateInfo> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<GroupPadTemplateInfo> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new PersistTransaction(it.next()));
        }
        this.f292606e.doMultiDBOperateByTransaction(arrayList);
    }

    public static void l(Context context, String str, String str2, String str3) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        if (!TextUtils.isEmpty(str)) {
            str2 = str2 + "_" + str;
        }
        edit.putString(str2, str3);
        edit.commit();
    }

    public void a(int i3, List<GPadInfo> list) {
        if (i3 == 2) {
            c();
        }
        if (list != null) {
            for (GPadInfo gPadInfo : list) {
                this.f292607f.put(((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).getNoParamUrl(gPadInfo.pad_url), gPadInfo);
            }
            j(list);
        }
    }

    public void b(List<GroupPadTemplateInfo> list) {
        if (this.f292609i != null) {
            d();
        }
        if (list != null && this.f292609i != null) {
            for (GroupPadTemplateInfo groupPadTemplateInfo : list) {
                this.f292609i.put(groupPadTemplateInfo.templateUrl, groupPadTemplateInfo);
            }
            k(list);
            o(list);
        }
    }

    public void c() {
        this.f292606e.drop(GPadInfo.class);
        this.f292607f.clear();
    }

    public void d() {
        this.f292606e.drop(GroupPadTemplateInfo.class);
        this.f292609i.clear();
    }

    public ConcurrentHashMap<String, Entity> e() {
        return this.f292607f;
    }

    public List<GPadInfo> f() {
        ArrayList arrayList = new ArrayList();
        ConcurrentHashMap<String, Entity> concurrentHashMap = this.f292607f;
        if (concurrentHashMap != null) {
            Iterator<Entity> it = concurrentHashMap.values().iterator();
            while (it.hasNext()) {
                arrayList.add((GPadInfo) it.next());
            }
        }
        return arrayList;
    }

    public List<GroupPadTemplateInfo> g() {
        ArrayList arrayList = new ArrayList();
        ConcurrentHashMap<String, Entity> concurrentHashMap = this.f292609i;
        if (concurrentHashMap != null) {
            Iterator<Entity> it = concurrentHashMap.values().iterator();
            while (it.hasNext()) {
                arrayList.add((GroupPadTemplateInfo) it.next());
            }
        }
        return arrayList;
    }

    public void i(long j3) {
        synchronized (this) {
            this.f292607f.clear();
            List<? extends Entity> query = this.f292606e.query(GPadInfo.class, false, "groupCode=?", new String[]{String.valueOf(j3)}, null, null, null, null);
            if (query != null && query.size() > 0) {
                Iterator<? extends Entity> it = query.iterator();
                while (it.hasNext()) {
                    GPadInfo gPadInfo = (GPadInfo) it.next();
                    this.f292607f.put(((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).getNoParamUrl(gPadInfo.pad_url), gPadInfo);
                }
            }
            this.f292609i.clear();
            List<? extends Entity> query2 = this.f292606e.query(GroupPadTemplateInfo.class, false, "groupCode=?", new String[]{"" + j3}, null, null, null, null);
            if (query2 != null && query2.size() > 0) {
                Iterator<? extends Entity> it5 = query2.iterator();
                while (it5.hasNext()) {
                    GroupPadTemplateInfo groupPadTemplateInfo = (GroupPadTemplateInfo) it5.next();
                    this.f292609i.put(groupPadTemplateInfo.templateUrl, groupPadTemplateInfo);
                }
            }
        }
    }

    public boolean m(Entity entity) {
        ArrayList arrayList = new ArrayList();
        if (entity.getStatus() == 1000) {
            arrayList.add(new PersistOrReplaceTransaction(entity));
            this.f292606e.doMultiDBOperateByTransaction(arrayList);
            if (entity.getStatus() != 1001) {
                return false;
            }
            return true;
        }
        if (entity.getStatus() != 1001 && entity.getStatus() != 1002) {
            return false;
        }
        UpdateTransaction updateTransaction = new UpdateTransaction(entity);
        arrayList.add(updateTransaction);
        this.f292606e.doMultiDBOperateByTransaction(arrayList);
        return updateTransaction.getResult().booleanValue();
    }

    public void n(GroupPadTemplateInfo groupPadTemplateInfo) {
        if (groupPadTemplateInfo != null && !TextUtils.isEmpty(groupPadTemplateInfo.templateUrl)) {
            this.f292609i.put(groupPadTemplateInfo.templateUrl, groupPadTemplateInfo);
            m(groupPadTemplateInfo);
        }
    }

    public void o(List<GroupPadTemplateInfo> list) {
        if (list != null) {
            Iterator<GroupPadTemplateInfo> it = list.iterator();
            while (it.hasNext()) {
                n(it.next());
            }
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        EntityManager entityManager = this.f292606e;
        if (entityManager != null && entityManager.isOpen()) {
            this.f292606e.close();
        }
        this.f292607f.clear();
    }
}
