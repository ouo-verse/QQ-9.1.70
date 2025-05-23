package com.tencent.aelight.camera.aioeditor.capture.data;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.m;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes32.dex */
public class g implements IEventReceiver {
    public QIMFilterCategoryItem C;

    /* renamed from: f, reason: collision with root package name */
    HashMap<String, LockedCategory> f66736f;

    /* renamed from: h, reason: collision with root package name */
    m.a f66737h;

    /* renamed from: d, reason: collision with root package name */
    volatile boolean f66734d = false;

    /* renamed from: e, reason: collision with root package name */
    boolean f66735e = true;

    /* renamed from: m, reason: collision with root package name */
    int f66739m = -1;

    /* renamed from: i, reason: collision with root package name */
    AppInterface f66738i = fr.b.a();

    public LockedCategory a(String str) {
        return this.f66736f.get(str);
    }

    public boolean b(String str, Context context) {
        if (!c(str)) {
            return false;
        }
        String str2 = a(str).f66693f;
        if (TextUtils.isEmpty(str2)) {
            QLog.e("ComboLockManager", 1, "empty jump url");
            str2 = "https://ti.qq.com/unlocked/index.html?_wv=536870912&id=" + str;
        }
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str2);
        intent.putExtra("k_f_id", str);
        context.startActivity(intent);
        if (!QLog.isColorLevel()) {
            return true;
        }
        QLog.i("ComboLockManager", 2, "handleLockItemClick id " + str);
        return true;
    }

    public boolean c(String str) {
        LockedCategory lockedCategory;
        boolean z16;
        QIMFilterCategoryItem qIMFilterCategoryItem;
        HashMap<String, LockedCategory> hashMap = this.f66736f;
        boolean z17 = false;
        int i3 = 0;
        z17 = false;
        z17 = false;
        if (hashMap == null) {
            lockedCategory = null;
            z16 = false;
            i3 = -1;
        } else {
            lockedCategory = hashMap.get(str);
            if (lockedCategory == null) {
                z16 = false;
            } else if (!lockedCategory.f66691d) {
                z16 = false;
                i3 = 1;
            } else if (lockedCategory.a()) {
                z16 = false;
                i3 = 2;
            } else {
                int i16 = lockedCategory.f66696m;
                if (i16 == 2) {
                    if (!this.f66734d || ((qIMFilterCategoryItem = this.C) != null && qIMFilterCategoryItem.f66697d.equals(str))) {
                        z17 = true;
                    }
                } else if (i16 == 1) {
                    if (!lockedCategory.C) {
                        lockedCategory.f66691d = ea.q2(BaseApplicationImpl.getApplication(), str);
                        lockedCategory.C = true;
                    }
                    z17 = lockedCategory.f66691d;
                }
                z16 = z17;
                i3 = 3;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("ComboLockManager", 2, "is locke " + str + " code" + i3);
            if (i3 == 3) {
                QLog.i("ComboLockManager", 2, "islock result" + z16 + " type " + lockedCategory.f66696m + " mHaveSendStory " + this.f66734d);
            }
        }
        return z16;
    }

    public void e(int i3) {
        this.f66739m = i3;
    }

    public void f(String str) {
        LockedCategory lockedCategory = this.f66736f.get(str);
        if (lockedCategory != null) {
            lockedCategory.f66691d = false;
        }
    }

    public void g(m.a aVar) {
        if (this.f66737h == aVar) {
            if (QLog.isColorLevel()) {
                QLog.i("ComboLockManager", 2, "same data");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ComboLockManager", 2, "updateConfigData isfrist " + this.f66735e + " sendStory " + this.f66734d);
        }
        if (this.f66735e) {
            this.f66735e = false;
            if (QLog.isColorLevel()) {
                QLog.i("ComboLockManager", 2, "updateConfigData first card.snedSrory " + this.f66734d);
            }
        }
        HashMap<String, LockedCategory> hashMap = aVar.f66508c;
        this.f66736f = hashMap;
        this.f66737h = aVar;
        Iterator<String> it = hashMap.keySet().iterator();
        while (it.hasNext()) {
            LockedCategory lockedCategory = this.f66736f.get(it.next());
            lockedCategory.f66691d = c(lockedCategory.f66692e);
            if (QLog.isColorLevel()) {
                QLog.i("ComboLockManager", 2, "updateConfigData " + lockedCategory + " lock " + lockedCategory.f66691d);
            }
        }
    }

    @Override // com.tribe.async.dispatch.IEventReceiver
    public boolean isValidate() {
        return true;
    }

    public void d() {
    }
}
