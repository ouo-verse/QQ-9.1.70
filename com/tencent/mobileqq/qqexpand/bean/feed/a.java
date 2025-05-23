package com.tencent.mobileqq.qqexpand.bean.feed;

import android.text.TextUtils;
import androidx.room.util.TableInfo;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public List<C8312a> f263474a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f263475b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f263476c;

    /* renamed from: d, reason: collision with root package name */
    public int f263477d;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqexpand.bean.feed.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static class C8312a {

        /* renamed from: a, reason: collision with root package name */
        public List<b> f263478a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public long f263479b;

        /* renamed from: c, reason: collision with root package name */
        public int f263480c;

        /* renamed from: d, reason: collision with root package name */
        public byte[] f263481d;

        /* renamed from: e, reason: collision with root package name */
        public String f263482e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f263483f;

        /* renamed from: g, reason: collision with root package name */
        public int f263484g;

        /* renamed from: h, reason: collision with root package name */
        public int f263485h;

        public boolean equals(Object obj) {
            String str;
            if (obj == null || !(obj instanceof C8312a) || (str = ((C8312a) obj).f263482e) == null || !this.f263482e.equals(str)) {
                return false;
            }
            return true;
        }

        public String toString() {
            return "mUpdateTime" + ContainerUtils.KEY_VALUE_DELIMITER + this.f263479b + " mUpdateTime" + ContainerUtils.KEY_VALUE_DELIMITER + this.f263479b + " mSearchKey" + ContainerUtils.KEY_VALUE_DELIMITER + this.f263482e + " mLoadOver" + ContainerUtils.KEY_VALUE_DELIMITER + this.f263483f + " mCurPos" + ContainerUtils.KEY_VALUE_DELIMITER + this.f263484g + " mOffset" + ContainerUtils.KEY_VALUE_DELIMITER + this.f263485h + " size" + ContainerUtils.KEY_VALUE_DELIMITER + this.f263478a.size();
        }
    }

    private int a() {
        List<C8312a> list = this.f263474a;
        int i3 = 0;
        if (list != null) {
            Iterator<C8312a> it = list.iterator();
            while (it.hasNext()) {
                i3 += it.next().f263478a.size();
            }
        }
        return i3;
    }

    private void e() {
        if (this.f263474a != null) {
            long currentTimeMillis = System.currentTimeMillis();
            for (int size = this.f263474a.size() - 1; size >= 0; size--) {
                if (Math.abs(currentTimeMillis - this.f263474a.get(size).f263479b) > 60000) {
                    this.f263474a.remove(size);
                }
            }
        }
    }

    public void b(C8312a c8312a, boolean z16, boolean z17, int i3) {
        this.f263475b = z16;
        this.f263476c = z17;
        this.f263477d = i3;
        e();
        if (this.f263474a == null) {
            this.f263474a = new ArrayList();
        }
        this.f263474a.remove(c8312a);
        if (c8312a != null && c8312a.f263478a.size() != 0) {
            this.f263474a.add(0, c8312a);
            while (a() > 500 && this.f263474a.size() > 1) {
                List<C8312a> list = this.f263474a;
                list.remove(list.size() - 1);
            }
        }
    }

    public C8312a c(String str) {
        C8312a c8312a;
        if (!TextUtils.isEmpty(str) && this.f263474a != null) {
            for (int i3 = 0; i3 < this.f263474a.size(); i3++) {
                if (str.equals(this.f263474a.get(i3).f263482e)) {
                    c8312a = this.f263474a.get(i3);
                    this.f263474a.remove(i3);
                    break;
                }
            }
        }
        c8312a = null;
        if (c8312a != null) {
            this.f263474a.add(0, c8312a);
        }
        return c8312a;
    }

    public C8312a d() {
        List<C8312a> list = this.f263474a;
        if (list != null && list.size() > 0) {
            return this.f263474a.get(0);
        }
        return null;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder(1024);
        sb5.append("mProfileComplete");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(this.f263475b);
        sb5.append(" ");
        sb5.append("mProfileComplete");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(this.f263475b);
        sb5.append(" ");
        sb5.append("mShowCard");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(this.f263476c);
        sb5.append(" ");
        sb5.append("mMaxLikeCount");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(this.f263477d);
        sb5.append(" ");
        sb5.append("mTags");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(" [");
        if (this.f263474a != null) {
            for (int i3 = 0; i3 < this.f263474a.size(); i3++) {
                C8312a c8312a = this.f263474a.get(i3);
                sb5.append("\n");
                sb5.append(TableInfo.Index.DEFAULT_PREFIX);
                sb5.append(i3);
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(c8312a.toString());
            }
        }
        sb5.append("]");
        return sb5.toString();
    }
}
