package com.tencent.biz.qqcircle.immersive.views.mixfeed;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private int f90910a;

    /* renamed from: c, reason: collision with root package name */
    private List<QQCircleDitto$StItemInfo> f90912c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private List<QQCircleDitto$StItemInfo> f90913d = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private int f90911b = 0;

    public c(int i3) {
        this.f90910a = i3;
    }

    public List<QQCircleDitto$StItemInfo> a() {
        if (this.f90912c == null) {
            QLog.e("QFSMixFeedHotTopicListManager", 1, "[getShowList] mAllInfoList is null");
            return new ArrayList();
        }
        this.f90913d.clear();
        if (this.f90911b + this.f90910a <= this.f90912c.size()) {
            List<QQCircleDitto$StItemInfo> list = this.f90913d;
            List<QQCircleDitto$StItemInfo> list2 = this.f90912c;
            int i3 = this.f90911b;
            list.addAll(list2.subList(i3, this.f90910a + i3));
            this.f90911b += this.f90910a;
        } else {
            int size = this.f90912c.size();
            int i16 = this.f90911b;
            int i17 = size - i16;
            this.f90913d.addAll(this.f90912c.subList(i16, i16 + i17));
            int i18 = this.f90910a - i17;
            if (this.f90912c.size() >= i18 && i18 >= 0) {
                this.f90913d.addAll(this.f90912c.subList(0, i18));
            }
            this.f90911b = i18;
        }
        return this.f90913d;
    }

    public void b() {
        this.f90911b = 0;
    }

    public void c(List<QQCircleDitto$StItemInfo> list) {
        this.f90912c = list;
    }
}
