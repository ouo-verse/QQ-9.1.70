package com.tencent.biz.qqstory.base;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.i;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.persistence.EntityManager;
import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b implements Manager, xc0.a {

    /* renamed from: d, reason: collision with root package name */
    AppInterface f93987d;

    /* renamed from: e, reason: collision with root package name */
    SharedPreferences f93988e;

    /* renamed from: f, reason: collision with root package name */
    public EntityManager f93989f;

    /* renamed from: h, reason: collision with root package name */
    public QQStoryContext f93990h;

    /* renamed from: i, reason: collision with root package name */
    public ConcurrentHashMap<String, SoftReference<Bitmap>> f93991i = new ConcurrentHashMap<>();

    /* renamed from: m, reason: collision with root package name */
    public SoftReference<View> f93992m = new SoftReference<>(null);

    public b(AppInterface appInterface) {
        this.f93988e = null;
        this.f93987d = appInterface;
        this.f93988e = appInterface.getApp().getSharedPreferences("QQStory_Config_SP_" + appInterface.getAccount(), 4);
        this.f93989f = appInterface.getEntityManagerFactory().createEntityManager();
        QQStoryContext qQStoryContext = new QQStoryContext();
        this.f93990h = qQStoryContext;
        qQStoryContext.j();
        b();
    }

    public static String a() {
        return HardCodeUtil.qqStr(R.string.r7v);
    }

    public static boolean c() {
        return true;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        this.f93989f.close();
        i.d().b();
    }

    public void b() {
    }
}
