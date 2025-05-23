package com.tencent.biz.qqcircle.manager;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.utils.bh;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private final int f91574a;

    /* renamed from: c, reason: collision with root package name */
    private int f91576c;

    /* renamed from: d, reason: collision with root package name */
    private List<QQCircleDitto$StItemInfo> f91577d;

    /* renamed from: e, reason: collision with root package name */
    private final List<QQCircleDitto$StItemInfo> f91578e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private final List<QQCircleDitto$StItemInfo> f91579f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    private final List<QQCircleDitto$StItemInfo> f91580g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private final List<QQCircleDitto$StItemInfo> f91581h = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private boolean f91575b = false;

    public j(int i3, int i16) {
        this.f91574a = i3;
        this.f91576c = i16;
    }

    private ArrayList<QQCircleDitto$StItemInfo> a() {
        ArrayList<QQCircleDitto$StItemInfo> arrayList = new ArrayList<>();
        for (QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo : this.f91578e) {
            if (!this.f91581h.contains(qQCircleDitto$StItemInfo)) {
                arrayList.add(qQCircleDitto$StItemInfo);
            }
        }
        return arrayList;
    }

    private boolean c(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo) {
        boolean z16 = false;
        if (qQCircleDitto$StItemInfo == null) {
            return false;
        }
        int i3 = qQCircleDitto$StItemInfo.buttonInfo.buttonValue.get();
        if (i3 == 1 || i3 == 3) {
            z16 = true;
        }
        QLog.d("QFSLayerFeedPYMKUserListManager", 4, "[isValidUser] isFollow: " + z16);
        return !this.f91578e.contains(qQCircleDitto$StItemInfo);
    }

    public static boolean e(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo, int i3) {
        if (qQCircleDitto$StItemInfo == null) {
            return false;
        }
        boolean equals = TextUtils.equals("1", bh.d(qQCircleDitto$StItemInfo.busiInfo.get(), "is_friend"));
        if (i3 == 504 && com.tencent.biz.qqcircle.immersive.tab.c.f90017a.a()) {
            return !equals;
        }
        if (equals) {
            return false;
        }
        int i16 = qQCircleDitto$StItemInfo.buttonInfo.buttonValue.get();
        if (i16 != 3 && i16 != 1) {
            return false;
        }
        return true;
    }

    public List<QQCircleDitto$StItemInfo> b() {
        this.f91579f.clear();
        ArrayList<QQCircleDitto$StItemInfo> a16 = a();
        if (!this.f91575b && this.f91578e.size() >= this.f91574a) {
            if (a16.size() < this.f91574a - this.f91581h.size()) {
                return this.f91579f;
            }
            this.f91579f.addAll(this.f91581h);
            this.f91579f.addAll(a16.subList(0, this.f91574a - this.f91581h.size()));
            this.f91581h.clear();
            return this.f91579f;
        }
        return this.f91579f;
    }

    public void d() {
        this.f91580g.clear();
        this.f91575b = false;
    }

    public void f(List<QQCircleDitto$StItemInfo> list) {
        this.f91577d = list;
        this.f91578e.clear();
        for (QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo : list) {
            if (c(qQCircleDitto$StItemInfo)) {
                this.f91578e.add(qQCircleDitto$StItemInfo);
            }
        }
    }

    public void g(boolean z16) {
        if (z16) {
            for (QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo : this.f91579f) {
                if (!e(qQCircleDitto$StItemInfo, this.f91576c)) {
                    this.f91580g.add(qQCircleDitto$StItemInfo);
                } else {
                    this.f91581h.add(qQCircleDitto$StItemInfo);
                }
            }
        } else {
            this.f91580g.addAll(this.f91579f);
        }
        this.f91578e.removeAll(this.f91580g);
        List<QQCircleDitto$StItemInfo> list = this.f91577d;
        if (list != null) {
            list.removeAll(this.f91580g);
        }
        if (this.f91578e.size() < this.f91574a) {
            this.f91575b = true;
        }
    }
}
