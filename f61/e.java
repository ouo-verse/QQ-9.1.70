package f61;

import java.util.ArrayList;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4$LoveAchievementInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4$LoveAchievementItem;

/* compiled from: P */
/* loaded from: classes10.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public int f397908a;

    /* renamed from: b, reason: collision with root package name */
    public int f397909b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<a> f397910c;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f397911a;

        /* renamed from: b, reason: collision with root package name */
        public String f397912b;

        /* renamed from: c, reason: collision with root package name */
        public int f397913c;

        public static a a(oidb_0xcf4$LoveAchievementItem oidb_0xcf4_loveachievementitem) {
            if (oidb_0xcf4_loveachievementitem != null && oidb_0xcf4_loveachievementitem.has()) {
                a aVar = new a();
                if (oidb_0xcf4_loveachievementitem.uint32_achievement_id.has()) {
                    aVar.f397911a = oidb_0xcf4_loveachievementitem.uint32_achievement_id.get();
                }
                if (oidb_0xcf4_loveachievementitem.str_achievement_backurl.has()) {
                    aVar.f397912b = oidb_0xcf4_loveachievementitem.str_achievement_backurl.get();
                }
                if (oidb_0xcf4_loveachievementitem.clockState.has()) {
                    aVar.f397913c = oidb_0xcf4_loveachievementitem.clockState.get();
                }
                return aVar;
            }
            return null;
        }

        public String toString() {
            return "LoveAchievementItem{id=" + this.f397911a + ", backUrl=" + this.f397912b + ", clockStatus=" + this.f397913c + '}';
        }
    }

    public static e a(oidb_0xcf4$LoveAchievementInfo oidb_0xcf4_loveachievementinfo) {
        if (oidb_0xcf4_loveachievementinfo == null) {
            return null;
        }
        e eVar = new e();
        if (oidb_0xcf4_loveachievementinfo.uint32_total_count.has()) {
            eVar.f397908a = oidb_0xcf4_loveachievementinfo.uint32_total_count.get();
        }
        if (oidb_0xcf4_loveachievementinfo.uint32_completed_count.has()) {
            eVar.f397909b = oidb_0xcf4_loveachievementinfo.uint32_completed_count.get();
        }
        if (oidb_0xcf4_loveachievementinfo.rpt_life_ach_item.has()) {
            for (oidb_0xcf4$LoveAchievementItem oidb_0xcf4_loveachievementitem : oidb_0xcf4_loveachievementinfo.rpt_life_ach_item.get()) {
                a a16 = a.a(oidb_0xcf4_loveachievementitem);
                if (oidb_0xcf4_loveachievementitem != null) {
                    if (eVar.f397910c == null) {
                        eVar.f397910c = new ArrayList<>();
                    }
                    eVar.f397910c.add(a16);
                }
            }
        }
        return eVar;
    }

    public String toString() {
        return "LoveAchievementInfo{totalCount=" + this.f397908a + ", completedCount=" + this.f397909b + ", achievements=" + this.f397910c + '}';
    }
}
