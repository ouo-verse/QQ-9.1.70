package dn4;

import ag4.h;
import com.tencent.timi.game.teamlist.presenter.TeamListFilterUnitAdapter;
import com.tencent.timi.game.utils.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigInfo;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigItem;
import trpc.yes.common.YoloRoomOuterClass$ListParam;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<String> f394318a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<TeamListFilterUnitAdapter> f394319b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<YoloRoomOuterClass$ListParam> f394320c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    private int f394321d;

    public c(int i3) {
        this.f394321d = i3;
        e();
    }

    private void e() {
        try {
            YesGameInfoOuterClass$GameConfigInfo l16 = ((h) mm4.b.b(h.class)).l1(this.f394321d);
            List<YesGameInfoOuterClass$GameConfigItem> list = l16.team_info.item_list.get();
            String str = l16.team_info.main_hue.get();
            String str2 = l16.team_info.text_sub_hue.get();
            String str3 = l16.team_info.selected_bg_hue.get();
            String str4 = l16.team_info.unselected_bg_hue.get();
            for (int i3 = 0; i3 < list.size(); i3++) {
                YesGameInfoOuterClass$GameConfigItem yesGameInfoOuterClass$GameConfigItem = list.get(i3);
                this.f394319b.add(new TeamListFilterUnitAdapter(yesGameInfoOuterClass$GameConfigItem, str, str2, str3, str4));
                this.f394318a.add(yesGameInfoOuterClass$GameConfigItem.title.get());
            }
        } catch (Exception unused) {
            l.e("TeamListFilterModel", "SmobaConfigItem \u521d\u59cb\u5316\u5f02\u5e38");
        }
    }

    public TeamListFilterUnitAdapter a(int i3) {
        return this.f394319b.get(i3);
    }

    public int b() {
        return this.f394319b.size();
    }

    public String c(int i3) {
        return this.f394318a.get(i3);
    }

    public int d() {
        return this.f394321d;
    }

    public List<YoloRoomOuterClass$ListParam> f() {
        this.f394320c.clear();
        Iterator<TeamListFilterUnitAdapter> it = this.f394319b.iterator();
        while (it.hasNext()) {
            this.f394320c.add(it.next().m0());
        }
        Iterator<YoloRoomOuterClass$ListParam> it5 = this.f394320c.iterator();
        while (it5.hasNext()) {
            YoloRoomOuterClass$ListParam next = it5.next();
            l.b("TeamListFilterModel", next.index.get() + "-index");
            Iterator<String> it6 = next.value.get().iterator();
            while (it6.hasNext()) {
                l.b("TeamListFilterModel", "  " + it6.next() + "-value");
            }
        }
        return this.f394320c;
    }

    public void g() {
        Iterator<TeamListFilterUnitAdapter> it = this.f394319b.iterator();
        while (it.hasNext()) {
            it.next().n0();
        }
    }
}
