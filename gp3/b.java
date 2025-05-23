package gp3;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.open.agent.datamodel.Friend;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {

    /* renamed from: f, reason: collision with root package name */
    protected static byte[] f403020f = new byte[1];

    /* renamed from: g, reason: collision with root package name */
    protected static b f403021g;

    /* renamed from: d, reason: collision with root package name */
    public int f403025d = -1;

    /* renamed from: e, reason: collision with root package name */
    public int f403026e = -1;

    /* renamed from: a, reason: collision with root package name */
    protected List<c> f403022a = new ArrayList(20);

    /* renamed from: c, reason: collision with root package name */
    protected List<String> f403024c = new ArrayList(20);

    /* renamed from: b, reason: collision with root package name */
    protected List<Friend> f403023b = new ArrayList(5);

    protected b() {
    }

    public static b g() {
        if (f403021g == null) {
            synchronized (f403020f) {
                if (f403021g == null) {
                    f403021g = new b();
                }
            }
        }
        return f403021g;
    }

    public List<Friend> a() {
        ArrayList arrayList = new ArrayList();
        Iterator<c> it = this.f403022a.iterator();
        while (it.hasNext()) {
            Iterator<Friend> it5 = it.next().f403030c.iterator();
            while (it5.hasNext()) {
                arrayList.add(it5.next());
            }
        }
        return arrayList;
    }

    public Friend b(String str) {
        Iterator<c> it = this.f403022a.iterator();
        while (it.hasNext()) {
            for (Friend friend : it.next().f403030c) {
                if (str.equals(friend.f340346d)) {
                    return friend;
                }
            }
        }
        return null;
    }

    public int c(int i3) {
        List<Friend> list = this.f403022a.get(i3).f403030c;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public List<Friend> d(int i3) {
        return this.f403022a.get(i3).f403030c;
    }

    public String e(int i3) {
        return this.f403022a.get(i3).f403029b;
    }

    public int f() {
        return this.f403022a.size();
    }

    public int h() {
        return this.f403023b.size();
    }

    public Friend i(int i3) {
        return this.f403023b.get(i3);
    }

    public List<String> j() {
        return this.f403024c;
    }

    public int k() {
        return this.f403024c.size();
    }

    public void l(List<c> list, int i3, int i16) {
        if (list.size() <= 0) {
            return;
        }
        this.f403025d = i3;
        this.f403026e = i16;
        this.f403022a.clear();
        this.f403023b.clear();
        this.f403024c.clear();
        String string = com.tencent.open.adapter.a.f().e().getResources().getString(R.string.f170760a50);
        for (c cVar : list) {
            if (string.equals(cVar.f403029b)) {
                this.f403023b.addAll(cVar.f403030c);
            } else {
                this.f403022a.add(cVar);
                List<Friend> list2 = cVar.f403030c;
                if (list2 != null) {
                    for (Friend friend : list2) {
                        String str = friend.f340348f;
                        if (str == null || "".equals(str)) {
                            str = friend.f340347e;
                        }
                        friend.E = ChnToSpell.d(str, 2);
                        friend.F = ChnToSpell.d(str, 1);
                    }
                }
            }
        }
    }

    public void m(String str) {
        if (!this.f403024c.contains(str)) {
            this.f403024c.add(str);
        }
    }

    public boolean n(String str) {
        return this.f403024c.contains(str);
    }

    public void o(String str) {
        if (this.f403024c.contains(str)) {
            this.f403024c.remove(str);
        }
    }
}
