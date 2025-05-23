package dn4;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.utils.l;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import mqq.util.WeakReference;
import trpc.yes.common.PremadesTeamServerOuterClass$SearchGamePremadesTeamRsp;
import trpc.yes.common.PremadesTeamServerOuterClass$YesGamePremadesTeamInfo;

/* compiled from: P */
/* loaded from: classes26.dex */
public class d {

    /* renamed from: f, reason: collision with root package name */
    public static String f394322f = "";

    /* renamed from: a, reason: collision with root package name */
    public int f394323a;

    /* renamed from: b, reason: collision with root package name */
    public int f394324b = 5;

    /* renamed from: c, reason: collision with root package name */
    public Vector<PremadesTeamServerOuterClass$YesGamePremadesTeamInfo> f394325c = new Vector<>();

    /* renamed from: d, reason: collision with root package name */
    public boolean f394326d = false;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f394327e = false;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface a {
        void onDataSetChange();
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    static class b implements pl4.d<PremadesTeamServerOuterClass$SearchGamePremadesTeamRsp> {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<d> f394328a;

        /* renamed from: b, reason: collision with root package name */
        private WeakReference<a> f394329b;

        public b(d dVar, a aVar) {
            this.f394328a = new WeakReference<>(dVar);
            this.f394329b = new WeakReference<>(aVar);
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable @org.jetbrains.annotations.Nullable PremadesTeamServerOuterClass$SearchGamePremadesTeamRsp premadesTeamServerOuterClass$SearchGamePremadesTeamRsp, @Nullable @org.jetbrains.annotations.Nullable FromServiceMsg fromServiceMsg) {
            d dVar = this.f394328a.get();
            if (dVar != null) {
                dVar.f394327e = false;
                l.b("TeamListModel", "\u9996\u9875\u6570\u636e\u52a0\u8f7d\u5931\u8d25");
                gn4.b.a("TeamListModel", i16, i17, str, str2);
            }
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(PremadesTeamServerOuterClass$SearchGamePremadesTeamRsp premadesTeamServerOuterClass$SearchGamePremadesTeamRsp, FromServiceMsg fromServiceMsg) {
            d dVar = this.f394328a.get();
            a aVar = this.f394329b.get();
            if (dVar != null && aVar != null) {
                dVar.f394325c.clear();
                dVar.f394325c.addAll(premadesTeamServerOuterClass$SearchGamePremadesTeamRsp.list.get());
                dVar.f394323a = premadesTeamServerOuterClass$SearchGamePremadesTeamRsp.total.get();
                dVar.f394324b = premadesTeamServerOuterClass$SearchGamePremadesTeamRsp.refresh_interval.get();
                dVar.f394326d = premadesTeamServerOuterClass$SearchGamePremadesTeamRsp.more.get();
                aVar.onDataSetChange();
                dVar.f394327e = false;
                l.b("TeamListModel", "\u9996\u9875\u6570\u636e\u52a0\u8f7d\u5b8c\u6210");
            }
        }
    }

    public synchronized void b(List<PremadesTeamServerOuterClass$YesGamePremadesTeamInfo> list, a aVar) {
        if (this.f394327e) {
            return;
        }
        HashSet hashSet = new HashSet();
        for (PremadesTeamServerOuterClass$YesGamePremadesTeamInfo premadesTeamServerOuterClass$YesGamePremadesTeamInfo : list) {
            for (int i3 = 0; i3 < this.f394325c.size(); i3++) {
                if (this.f394325c.get(i3).f437250id == premadesTeamServerOuterClass$YesGamePremadesTeamInfo.f437250id) {
                    if (premadesTeamServerOuterClass$YesGamePremadesTeamInfo.status.get() != 1) {
                        hashSet.add(Integer.valueOf(i3));
                    } else {
                        this.f394325c.set(i3, premadesTeamServerOuterClass$YesGamePremadesTeamInfo);
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            this.f394325c.remove((Integer) it.next());
        }
        aVar.onDataSetChange();
    }

    public synchronized void c(String str, int i3, int i16, a aVar) {
        if (!this.f394327e && !TextUtils.isEmpty(str) && aVar.toString().equals(f394322f)) {
            this.f394327e = true;
            l.i("TeamListModel", "\u5f00\u59cb\u52a0\u8f7d\u9996\u9875\u6570\u636eoriginID:" + str);
            en4.a.e(i16, str, i3, true, 0, null, new b(this, aVar));
        }
    }
}
