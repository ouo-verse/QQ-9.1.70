package com.tencent.avbiz;

import com.tencent.avbiz.Constants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class AVBizPriorityManager {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "AVBizPriorityManager";
    private static volatile AVBizPriorityManager sInstance;
    private final HashMap<String, AVBusiness> mBusinessMap;
    private final HashMap<Long, AVBusiness> mFocusBusinessMap;
    private final HashMap<Long, TreeSet<AVBusiness>> mPriorityPQMap;

    /* loaded from: classes3.dex */
    class a implements Comparator<AVBusiness> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AVBizPriorityManager.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(AVBusiness aVBusiness, AVBusiness aVBusiness2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVBusiness, (Object) aVBusiness2)).intValue();
            }
            if (aVBusiness.equals(aVBusiness2)) {
                return 0;
            }
            if (aVBusiness.comparePriority(aVBusiness2)) {
                return -1;
            }
            return 1;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37799);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            sInstance = null;
        }
    }

    AVBizPriorityManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        HashMap<Long, TreeSet<AVBusiness>> hashMap = new HashMap<>();
        this.mPriorityPQMap = hashMap;
        this.mFocusBusinessMap = new HashMap<>();
        this.mBusinessMap = new HashMap<>();
        a aVar = new a();
        hashMap.put(1L, new TreeSet<>(aVar));
        hashMap.put(2L, new TreeSet<>(aVar));
    }

    private HashMap<Long, AVBusiness> competeFocus(Set<AVBusiness> set) {
        HashMap<Long, AVBusiness> hashMap = new HashMap<>();
        while (!set.isEmpty()) {
            Iterator<AVBusiness> it = set.iterator();
            while (true) {
                if (it.hasNext()) {
                    AVBusiness next = it.next();
                    Iterator<Long> it5 = AVBizUtils.convertToList(next.getRequestType()).iterator();
                    boolean z16 = true;
                    while (it5.hasNext()) {
                        Iterator<AVBusiness> it6 = this.mPriorityPQMap.get(Long.valueOf(it5.next().longValue())).iterator();
                        while (true) {
                            if (!it6.hasNext()) {
                                break;
                            }
                            AVBusiness next2 = it6.next();
                            if (set.contains(next2)) {
                                if (!next2.equals(next)) {
                                    z16 = false;
                                }
                            }
                        }
                        if (!z16) {
                            break;
                        }
                    }
                    if (z16) {
                        Iterator<Long> it7 = AVBizUtils.convertToList(next.getRequestType()).iterator();
                        while (it7.hasNext()) {
                            long longValue = it7.next().longValue();
                            hashMap.put(Long.valueOf(longValue), next);
                            set.removeAll(new HashSet(this.mPriorityPQMap.get(Long.valueOf(longValue))));
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    private void dequeue(AVBusiness aVBusiness) {
        Iterator<Long> it = AVBizUtils.convertToList(aVBusiness.getRequestType()).iterator();
        while (it.hasNext()) {
            this.mPriorityPQMap.get(Long.valueOf(it.next().longValue())).remove(aVBusiness);
        }
    }

    private void enqueue(AVBusiness aVBusiness) {
        Iterator<Long> it = AVBizUtils.convertToList(aVBusiness.getRequestType()).iterator();
        while (it.hasNext()) {
            this.mPriorityPQMap.get(Long.valueOf(it.next().longValue())).add(aVBusiness);
        }
    }

    public static AVBizPriorityManager getInstance() {
        if (sInstance == null) {
            synchronized (AVBizPriorityManager.class) {
                if (sInstance == null) {
                    sInstance = new AVBizPriorityManager();
                }
            }
        }
        return sInstance;
    }

    private void onFocusChange(AVBusiness aVBusiness, boolean z16) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet(this.mBusinessMap.values());
        Iterator<Long> it = AVBizUtils.convertToList(aVBusiness.getRequestType()).iterator();
        while (it.hasNext()) {
            long longValue = it.next().longValue();
            if (z16) {
                this.mFocusBusinessMap.remove(Long.valueOf(longValue));
            } else {
                if (this.mFocusBusinessMap.containsKey(Long.valueOf(longValue))) {
                    hashSet.add(this.mFocusBusinessMap.get(Long.valueOf(longValue)));
                }
                this.mFocusBusinessMap.put(Long.valueOf(longValue), aVBusiness);
                hashSet2.removeAll(new HashSet(this.mPriorityPQMap.get(Long.valueOf(longValue))));
            }
        }
        long j3 = 3;
        if (!z16) {
            j3 = 3 ^ aVBusiness.getRequestType();
        }
        updateFocusMap(j3, hashSet2, hashSet);
    }

    private void updateFocusMap(long j3, Set<AVBusiness> set, Set<AVBusiness> set2) {
        HashMap<Long, AVBusiness> competeFocus = competeFocus(set);
        HashSet<AVBusiness> hashSet = new HashSet();
        Iterator<Long> it = AVBizUtils.convertToList(j3).iterator();
        while (it.hasNext()) {
            long longValue = it.next().longValue();
            AVBusiness aVBusiness = competeFocus.get(Long.valueOf(longValue));
            AVBusiness aVBusiness2 = this.mFocusBusinessMap.get(Long.valueOf(longValue));
            if (aVBusiness == null) {
                if (aVBusiness2 != null) {
                    set2.add(aVBusiness2);
                    this.mFocusBusinessMap.remove(Long.valueOf(longValue));
                }
            } else {
                if (aVBusiness2 != null) {
                    set2.add(aVBusiness2);
                }
                hashSet.add(aVBusiness);
                this.mFocusBusinessMap.put(Long.valueOf(longValue), aVBusiness);
            }
        }
        for (AVBusiness aVBusiness3 : set2) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "loss focus[" + aVBusiness3.getName() + "]");
            }
            aVBusiness3.lossFocus();
        }
        for (AVBusiness aVBusiness4 : hashSet) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "gain focus[" + aVBusiness4.getName() + "]");
            }
            aVBusiness4.gainFocus();
        }
    }

    public synchronized void abandonAVFocus(String str) {
        String name;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        if (!AVBizUtils.isValid(str)) {
            QLog.e(TAG, 1, "abandonAVFocus invalid business name[" + str + "]");
            return;
        }
        if (!this.mBusinessMap.containsKey(str)) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "abandonAVFocus, business[" + str + "] never request, no need to abandon");
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "abandonAVFocus, name[" + str + "]");
        }
        AVBusiness aVBusiness = this.mBusinessMap.get(str);
        this.mBusinessMap.remove(str);
        dequeue(aVBusiness);
        Iterator<Long> it = AVBizUtils.convertToList(aVBusiness.getRequestType()).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            long longValue = it.next().longValue();
            AVBusiness aVBusiness2 = this.mFocusBusinessMap.get(Long.valueOf(longValue));
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("abandonAVFocus name[");
                sb5.append(str);
                sb5.append("], focusBusiness[");
                if (aVBusiness2 == null) {
                    name = "null";
                } else {
                    name = aVBusiness2.getName();
                }
                sb5.append(name);
                sb5.append("], type[");
                sb5.append(longValue);
                sb5.append("]");
                QLog.i(TAG, 2, sb5.toString());
            }
            if (aVBusiness.equals(aVBusiness2)) {
                onFocusChange(aVBusiness, true);
                break;
            }
        }
        b.b(aVBusiness);
    }

    public synchronized String checkAVFocus(String str) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        if (!AVBizUtils.isValid(str)) {
            QLog.e(TAG, 1, "checkAVFocus invalid business name[" + str + "]");
            return Constants.Result.UNKNOWN_BUSINESS;
        }
        if (this.mBusinessMap.containsKey(str)) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "checkAVFocus in queue, name[" + str + "]");
            }
            AVBusiness aVBusiness = this.mBusinessMap.get(str);
            Iterator<Long> it = AVBizUtils.convertToList(aVBusiness.getRequestType()).iterator();
            if (it.hasNext()) {
                AVBusiness aVBusiness2 = this.mFocusBusinessMap.get(Long.valueOf(it.next().longValue()));
                if (aVBusiness2 != null && !aVBusiness2.equals(aVBusiness)) {
                    return aVBusiness2.getName();
                }
                return "true";
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "checkAVFocus, name[" + str + "]");
        }
        AVBusiness aVBusiness3 = new AVBusiness(str, "");
        Iterator<Long> it5 = AVBizUtils.convertToList(aVBusiness3.getRequestType()).iterator();
        while (it5.hasNext()) {
            long longValue = it5.next().longValue();
            AVBusiness aVBusiness4 = this.mFocusBusinessMap.get(Long.valueOf(longValue));
            if (aVBusiness4 != null && aVBusiness4.comparePriority(aVBusiness3)) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "name[" + str + "], focusBusiness[" + aVBusiness4.getName() + "], checkAVFocus[false], type[" + longValue + "]");
                }
                return aVBusiness4.getName();
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("name[");
                sb5.append(str);
                sb5.append("], focusBusiness[");
                if (aVBusiness4 != null) {
                    str2 = aVBusiness4.getName();
                } else {
                    str2 = "null";
                }
                sb5.append(str2);
                sb5.append("], checkAVFocus[");
                sb5.append(true);
                sb5.append("], type[");
                sb5.append(longValue);
                sb5.append("]");
                QLog.i(TAG, 2, sb5.toString());
            }
        }
        return "true";
    }

    public synchronized HashMap<Long, String> getFocusBusiness() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (HashMap) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        HashMap<Long, String> hashMap = new HashMap<>();
        Iterator<Long> it = this.mFocusBusinessMap.keySet().iterator();
        while (it.hasNext()) {
            long longValue = it.next().longValue();
            hashMap.put(Long.valueOf(longValue), this.mFocusBusinessMap.get(Long.valueOf(longValue)).getName());
        }
        return hashMap;
    }

    public synchronized HashSet<String> getInQueueBusiness() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (HashSet) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new HashSet<>(this.mBusinessMap.keySet());
    }

    public synchronized String requestAVFocus(String str, String str2) {
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
        }
        if (!AVBizUtils.isValid(str)) {
            QLog.e(TAG, 1, "requestAVFocus invalid business name[" + str + "]");
            return Constants.Result.UNKNOWN_BUSINESS;
        }
        if (this.mBusinessMap.containsKey(str)) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "requestAVFocus repeat, name[" + str + "], processName[" + str2 + "]");
            }
            AVBusiness aVBusiness = this.mBusinessMap.get(str);
            Iterator<Long> it = AVBizUtils.convertToList(aVBusiness.getRequestType()).iterator();
            if (it.hasNext()) {
                AVBusiness aVBusiness2 = this.mFocusBusinessMap.get(Long.valueOf(it.next().longValue()));
                if (aVBusiness2 != null && !aVBusiness2.equals(aVBusiness)) {
                    return aVBusiness2.getName();
                }
                return "true";
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "requestAVFocus, name[" + str + "], processName[" + str2 + "]");
        }
        AVBusiness aVBusiness3 = new AVBusiness(str, str2);
        this.mBusinessMap.put(str, aVBusiness3);
        enqueue(aVBusiness3);
        Iterator<Long> it5 = AVBizUtils.convertToList(aVBusiness3.getRequestType()).iterator();
        while (it5.hasNext()) {
            long longValue = it5.next().longValue();
            AVBusiness aVBusiness4 = this.mFocusBusinessMap.get(Long.valueOf(longValue));
            if (aVBusiness4 != null && aVBusiness4.comparePriority(aVBusiness3)) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "name[" + str + "], focusBusiness[" + aVBusiness4.getName() + "], requestAVFocus[false], type[" + longValue + "]");
                }
                return aVBusiness4.getName();
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("name[");
                sb5.append(str);
                sb5.append("], focusBusiness[");
                if (aVBusiness4 != null) {
                    str3 = aVBusiness4.getName();
                } else {
                    str3 = "null";
                }
                sb5.append(str3);
                sb5.append("], requestAVFocus[");
                sb5.append(true);
                sb5.append("], type[");
                sb5.append(longValue);
                sb5.append("]");
                QLog.i(TAG, 2, sb5.toString());
            }
        }
        onFocusChange(aVBusiness3, false);
        b.d(aVBusiness3);
        return "true";
    }
}
