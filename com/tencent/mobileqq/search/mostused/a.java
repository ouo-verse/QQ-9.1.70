package com.tencent.mobileqq.search.mostused;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.search.model.y;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    private static Object f283559e = new Object();

    /* renamed from: f, reason: collision with root package name */
    private static final Comparator<c> f283560f = new C8539a();

    /* renamed from: g, reason: collision with root package name */
    private static final Comparator<MostUsedSearch> f283561g = new b();

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<MostUsedSearch> f283562a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private Lock f283563b = new ReentrantLock();

    /* renamed from: c, reason: collision with root package name */
    private boolean f283564c = false;

    /* renamed from: d, reason: collision with root package name */
    private String f283565d;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.search.mostused.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    class C8539a implements Comparator<c> {
        C8539a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            int signum = Long.signum(cVar2.f283568c - cVar.f283568c);
            if (signum == 0) {
                return Long.signum(cVar2.f283566a.timeStamp - cVar.f283566a.timeStamp);
            }
            return signum;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements Comparator<MostUsedSearch> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(MostUsedSearch mostUsedSearch, MostUsedSearch mostUsedSearch2) {
            return Long.signum(mostUsedSearch2.latestUsedTime - mostUsedSearch.latestUsedTime);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        public MostUsedSearchItem f283566a;

        /* renamed from: b, reason: collision with root package name */
        public y f283567b;

        /* renamed from: c, reason: collision with root package name */
        public int f283568c = 0;

        /* renamed from: d, reason: collision with root package name */
        public boolean f283569d = false;

        public c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str) {
        this.f283565d = str;
    }

    private void c(String str) {
        this.f283563b.lock();
        try {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(str.getBytes(), 0)));
                ArrayList<MostUsedSearch> arrayList = this.f283562a;
                if (arrayList != null) {
                    arrayList.clear();
                }
                this.f283562a = (ArrayList) objectInputStream.readObject();
                i(this.f283562a, 1000, NetConnInfoCenter.getServerTimeMillis() - 604800000);
            } catch (IOException e16) {
                QLog.e("MostUsedCahce", 2, " fromSerialsString IOException : " + e16.toString());
            } catch (ClassNotFoundException e17) {
                QLog.e("MostUsedCahce", 2, " fromSerialsString ClassNotFoundException : " + e17.toString());
            } catch (IllegalArgumentException e18) {
                QLog.e("MostUsedCahce", 2, " fromSerialsString IllegalArgumentException : " + e18.toString());
            }
        } finally {
            this.f283563b.unlock();
        }
    }

    public static int d(String str, String str2) {
        String lowerCase = str.toLowerCase();
        String lowerCase2 = str2.toLowerCase();
        int indexOf = lowerCase2.indexOf(lowerCase);
        int length = lowerCase.length();
        int length2 = lowerCase2.length();
        if (indexOf == 0) {
            if (length == length2) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    public static ArrayList<c> h(ArrayList<c> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            QLog.d("MostUsedCahcesortAndDuplicate", 2, "sortAndDuplicate begin: size: " + arrayList.size());
            Collections.sort(arrayList, f283560f);
            ArrayList<c> arrayList2 = new ArrayList<>();
            HashMap hashMap = new HashMap();
            Iterator<c> it = arrayList.iterator();
            while (it.hasNext()) {
                c next = it.next();
                MostUsedSearchItem mostUsedSearchItem = next.f283566a;
                int i3 = (mostUsedSearchItem.identifyType * 100) + mostUsedSearchItem.businessType;
                if (hashMap.containsKey(Integer.valueOf(i3))) {
                    HashMap hashMap2 = (HashMap) hashMap.get(Integer.valueOf(i3));
                    if (hashMap2.containsKey(next.f283566a.identify)) {
                        QLog.d("MostUsedCahce", 2, "more high level exsit " + next.f283566a.identify);
                    } else {
                        hashMap2.put(next.f283566a.identify, next);
                    }
                } else {
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put(next.f283566a.identify, next);
                    hashMap.put(Integer.valueOf(i3), hashMap3);
                }
            }
            if (hashMap.values() != null && hashMap.values().size() > 0) {
                for (HashMap hashMap4 : hashMap.values()) {
                    if (hashMap4 != null && hashMap4.values() != null && hashMap4.values().size() > 0) {
                        Iterator it5 = hashMap4.values().iterator();
                        while (it5.hasNext()) {
                            arrayList2.add((c) it5.next());
                        }
                    }
                }
            }
            Collections.sort(arrayList2, f283560f);
            QLog.d("MostUsedCahcesortAndDuplicate", 2, "sortAndDuplicate sorted: size: " + arrayList2.size());
            return arrayList2;
        }
        return arrayList;
    }

    public static void i(ArrayList<MostUsedSearch> arrayList, int i3, long j3) {
        if (arrayList != null && arrayList.size() != 0) {
            Collections.sort(arrayList, f283561g);
            for (int size = arrayList.size() - 1; size >= 0; size += -1) {
                MostUsedSearch mostUsedSearch = arrayList.get(size);
                if (mostUsedSearch == null || mostUsedSearch.latestUsedTime < j3 || size >= i3) {
                    arrayList.remove(size);
                    QLog.d("MostUsedCahce", 2, "list  remove " + size);
                } else {
                    return;
                }
            }
        }
    }

    private String j() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f283563b.lock();
        try {
            try {
                try {
                    new ObjectOutputStream(byteArrayOutputStream).writeObject(this.f283562a);
                    return new String(Base64.encode(byteArrayOutputStream.toByteArray(), 0));
                } catch (IOException e16) {
                    QLog.e("MostUsedCahce", 2, " toSerialsString IOException: " + e16.toString());
                    this.f283563b.unlock();
                    return null;
                } catch (OutOfMemoryError e17) {
                    QLog.e("MostUsedCahce", 2, " toSerialsString OutOfMemoryException : " + e17.toString());
                    this.f283563b.unlock();
                    return null;
                }
            } catch (IllegalArgumentException e18) {
                QLog.e("MostUsedCahce", 2, " toSerialsString IllegalArgumentException : " + e18.toString());
                this.f283563b.unlock();
                return null;
            }
        } finally {
            this.f283563b.unlock();
        }
    }

    public boolean a(QQAppInterface qQAppInterface, MostUsedSearchItem mostUsedSearchItem) {
        if (!this.f283564c) {
            e(qQAppInterface);
        }
        boolean z16 = false;
        if (mostUsedSearchItem == null || TextUtils.isEmpty(mostUsedSearchItem.searchKey)) {
            return false;
        }
        this.f283563b.lock();
        int i3 = 0;
        while (true) {
            try {
                if (i3 >= this.f283562a.size()) {
                    break;
                }
                MostUsedSearch mostUsedSearch = this.f283562a.get(i3);
                if (mostUsedSearchItem.searchKey.equals(mostUsedSearch.orgKey)) {
                    int i16 = 0;
                    int i17 = 0;
                    long j3 = 0;
                    while (true) {
                        if (i16 < mostUsedSearch.items.size()) {
                            MostUsedSearchItem mostUsedSearchItem2 = mostUsedSearch.items.get(i16);
                            if (j3 == 0) {
                                j3 = mostUsedSearchItem2.timeStamp;
                            } else {
                                long j16 = mostUsedSearchItem2.timeStamp;
                                if (j3 > j16) {
                                    i17 = i16;
                                    j3 = j16;
                                }
                            }
                            if (MostUsedSearchItem.isSameIdentityItem(mostUsedSearchItem2, mostUsedSearchItem)) {
                                mostUsedSearchItem2.timeStamp = mostUsedSearchItem.timeStamp;
                                break;
                            }
                            i16++;
                        } else {
                            z16 = true;
                            break;
                        }
                    }
                    if (z16) {
                        if (mostUsedSearch.items.size() > 2) {
                            mostUsedSearch.items.remove(i17);
                        }
                        mostUsedSearch.items.add(mostUsedSearchItem);
                        mostUsedSearch.latestUsedTime = mostUsedSearchItem.timeStamp;
                    }
                    z16 = true;
                } else {
                    i3++;
                }
            } finally {
                this.f283563b.unlock();
            }
        }
        if (!z16) {
            MostUsedSearch mostUsedSearch2 = new MostUsedSearch();
            mostUsedSearch2.orgKey = mostUsedSearchItem.searchKey;
            mostUsedSearch2.items.add(mostUsedSearchItem);
            mostUsedSearch2.latestUsedTime = mostUsedSearchItem.timeStamp;
            this.f283562a.add(mostUsedSearch2);
        }
        i(this.f283562a, 1000, NetConnInfoCenter.getServerTimeMillis() - 604800000);
        return true;
    }

    public void b() {
        this.f283563b.lock();
        try {
            ArrayList<MostUsedSearch> arrayList = this.f283562a;
            if (arrayList != null) {
                arrayList.clear();
            }
            this.f283563b.unlock();
            synchronized (f283559e) {
                this.f283564c = false;
            }
            QLog.d("MostUsedCahce", 2, "list  clear ");
        } catch (Throwable th5) {
            this.f283563b.unlock();
            throw th5;
        }
    }

    public void e(QQAppInterface qQAppInterface) {
        synchronized (f283559e) {
            if (this.f283564c) {
                return;
            }
            this.f283564c = true;
            if (TextUtils.isEmpty(this.f283565d)) {
                QLog.e("MostUsedCahce", 2, "mCacheName  null");
                return;
            }
            QLog.d("MostUsedCahce", 2, "list  init");
            String string = PreferenceManager.getDefaultSharedPreferences(qQAppInterface.getApp().getBaseContext()).getString("MostUsed" + this.f283565d + qQAppInterface.getCurrentAccountUin(), "");
            if (!TextUtils.isEmpty(string)) {
                c(string);
            }
        }
    }

    public ArrayList<c> f(QQAppInterface qQAppInterface, String str) {
        if (!this.f283564c) {
            e(qQAppInterface);
        }
        ArrayList<c> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(str.trim())) {
            return arrayList;
        }
        this.f283563b.lock();
        for (int i3 = 0; i3 < this.f283562a.size(); i3++) {
            try {
                MostUsedSearch mostUsedSearch = this.f283562a.get(i3);
                int d16 = d(str, mostUsedSearch.orgKey);
                if (d16 != 0) {
                    for (int i16 = 0; i16 < mostUsedSearch.items.size(); i16++) {
                        MostUsedSearchItem mostUsedSearchItem = mostUsedSearch.items.get(i16);
                        if (mostUsedSearchItem.timeStamp < NetConnInfoCenter.getServerTimeMillis() - 604800000 && mostUsedSearchItem.businessType != 2) {
                            QLog.d("MostUsedCahce", 2, "key:", str + "temp timeStamp over time:", Long.valueOf(mostUsedSearchItem.timeStamp), " busType:", Integer.valueOf(mostUsedSearchItem.businessType));
                        }
                        c cVar = new c();
                        cVar.f283569d = false;
                        cVar.f283566a = new MostUsedSearchItem(mostUsedSearchItem);
                        cVar.f283568c = d16;
                        arrayList.add(cVar);
                    }
                }
            } catch (Throwable th5) {
                this.f283563b.unlock();
                throw th5;
            }
        }
        this.f283563b.unlock();
        ArrayList<c> h16 = h(arrayList);
        if (h16 == null) {
            QLog.e("MostUsedCahce", 2, "sorted size  is NULL ");
        } else {
            QLog.i("MostUsedCahce", 2, "Result size  is " + h16.size());
        }
        return h16;
    }

    public void g(QQAppInterface qQAppInterface) {
        if (TextUtils.isEmpty(this.f283565d)) {
            return;
        }
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getApplication()).edit();
        String str = "MostUsed" + this.f283565d + qQAppInterface.getCurrentAccountUin();
        if (!this.f283564c) {
            e(qQAppInterface);
        }
        String j3 = j();
        if (TextUtils.isEmpty(j3)) {
            return;
        }
        edit.putString(str, j3);
        edit.apply();
    }
}
