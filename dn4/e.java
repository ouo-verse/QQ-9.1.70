package dn4;

import androidx.annotation.Nullable;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.utils.l;
import java.util.ArrayList;
import java.util.List;
import trpc.yes.common.PremadesTeamServerOuterClass$SearchGamePremadesTeamRsp;
import trpc.yes.common.PremadesTeamServerOuterClass$YesGamePremadesTeamInfo;

/* compiled from: P */
/* loaded from: classes26.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public int f394330a;

    /* renamed from: e, reason: collision with root package name */
    private c f394334e;

    /* renamed from: b, reason: collision with root package name */
    private int f394331b = 0;

    /* renamed from: c, reason: collision with root package name */
    private boolean f394332c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f394333d = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f394335f = false;

    /* renamed from: g, reason: collision with root package name */
    public List<PremadesTeamServerOuterClass$YesGamePremadesTeamInfo> f394336g = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements pl4.d<PremadesTeamServerOuterClass$SearchGamePremadesTeamRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f394337a;

        a(b bVar) {
            this.f394337a = bVar;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable PremadesTeamServerOuterClass$SearchGamePremadesTeamRsp premadesTeamServerOuterClass$SearchGamePremadesTeamRsp, @Nullable FromServiceMsg fromServiceMsg) {
            e.this.f394333d = false;
            e.this.f394335f = false;
            this.f394337a.onDataSetChange();
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(PremadesTeamServerOuterClass$SearchGamePremadesTeamRsp premadesTeamServerOuterClass$SearchGamePremadesTeamRsp, FromServiceMsg fromServiceMsg) {
            e.this.f394333d = false;
            if (e.this.f394335f) {
                e.this.f394335f = false;
                e.this.f394336g.clear();
            }
            e.this.f394336g.addAll(premadesTeamServerOuterClass$SearchGamePremadesTeamRsp.list.get());
            e.this.f394330a = premadesTeamServerOuterClass$SearchGamePremadesTeamRsp.total.get();
            e.this.f394332c = !premadesTeamServerOuterClass$SearchGamePremadesTeamRsp.more.get();
            e.this.f394331b++;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\u603b\u8f66\u961f\u6570\u76ee\uff1a");
            sb5.append(e.this.f394330a);
            sb5.append(" \u662f\u5426\u52a0\u8f7d\u5b8c\u6210");
            sb5.append(e.this.f394332c);
            sb5.append(" \u5f53\u524d\u9875\u7801:");
            sb5.append(e.this.f394331b - 1);
            l.b("TeamListSlideModel", sb5.toString());
            this.f394337a.onDataSetChange();
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface b {
        void onDataSetChange();
    }

    public e(c cVar) {
        this.f394334e = cVar;
    }

    public void h(String str, int i3, int i16, b bVar) {
        l.i("TeamListSlideModel", "\u5f00\u59cb\u52a0\u8f7d\u4fa7\u8fb9\u680f\u6570\u636eoriginID:" + str + ", yesGameId:" + i16);
        if (!this.f394332c && !this.f394333d) {
            this.f394333d = true;
            en4.a.e(i16, str, i3, false, this.f394331b, this.f394334e.f(), new a(bVar));
        }
    }

    public void i(List<PremadesTeamServerOuterClass$YesGamePremadesTeamInfo> list, b bVar) {
        if (list != null) {
            this.f394336g.clear();
            this.f394336g.addAll(list);
            bVar.onDataSetChange();
        }
    }

    public void j() {
        this.f394331b = 0;
        this.f394335f = true;
        this.f394332c = false;
    }
}
