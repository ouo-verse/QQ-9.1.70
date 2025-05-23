package ez;

import UserGrowth.stFeedOpInfo;
import UserGrowth.stGetFeedIconOpRsp;
import UserGrowth.stSimpleMetaFeed;
import com.google.gson.Gson;
import com.tencent.biz.pubaccount.weishi.net.l;
import com.tencent.biz.pubaccount.weishi.report.g;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class e {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class a implements com.tencent.biz.pubaccount.weishi.net.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f397444a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ j f397445b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f397446c;

        a(long j3, j jVar, b bVar) {
            this.f397444a = j3;
            this.f397445b = jVar;
            this.f397446c = bVar;
        }

        @Override // com.tencent.biz.pubaccount.weishi.net.c
        public void a(l lVar) {
            int i3;
            long currentTimeMillis = System.currentTimeMillis() - this.f397444a;
            x.i("WSWidgetDataManager", "[onTaskResponse] success:" + lVar.d());
            if (lVar.d() && (lVar.f80999l instanceof stGetFeedIconOpRsp)) {
                g.d().p(currentTimeMillis, lVar.f80994g, "", false);
                stGetFeedIconOpRsp stgetfeediconoprsp = (stGetFeedIconOpRsp) lVar.f80999l;
                stFeedOpInfo stfeedopinfo = stgetfeediconoprsp.opInfo;
                com.tencent.biz.pubaccount.weishi.net.d dVar = lVar.f81000m;
                if (dVar != null && (i3 = stfeedopinfo.iconType) != 255 && i3 != 0) {
                    com.tencent.biz.pubaccount.weishi.report.c.b().d(stfeedopinfo.traceId, dVar.f80962a);
                }
                this.f397445b.e().opInfo = stfeedopinfo;
                x.i("WSWidgetDataManager", "[onTaskResponse] " + stfeedopinfo.toString());
                this.f397445b.r(e.this.b(stgetfeediconoprsp));
                b bVar = this.f397446c;
                if (bVar != null) {
                    bVar.a(this.f397445b);
                    return;
                }
                return;
            }
            g.d().r(currentTimeMillis, lVar.f80994g, lVar.f80991d, lVar.f80990c);
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public interface b {
        void a(j jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private static final e f397448a = new e();
    }

    e() {
    }

    public static e c() {
        return c.f397448a;
    }

    private com.tencent.biz.pubaccount.weishi.net.c f(j jVar, b bVar) {
        return new a(System.currentTimeMillis(), jVar, bVar);
    }

    private boolean g(j jVar) {
        stFeedOpInfo stfeedopinfo;
        stSimpleMetaFeed e16 = jVar.e();
        return (e16 == null || (stfeedopinfo = e16.opInfo) == null || stfeedopinfo.iconType != 255) && jVar.f() == null;
    }

    public static stFeedOpInfo i(stSimpleMetaFeed stsimplemetafeed) {
        stFeedOpInfo stfeedopinfo = stsimplemetafeed.opInfo;
        if (stfeedopinfo == null) {
            stfeedopinfo = new stFeedOpInfo();
        }
        stfeedopinfo.videoType = stsimplemetafeed.video_type;
        stfeedopinfo.feedId = stsimplemetafeed.f25129id;
        return stfeedopinfo;
    }

    public void e(int i3, List<j> list, b bVar) {
        x.i("WSWidgetDataManager", "[getRichOpInfo] position:" + i3);
        if (i3 >= 0 && i3 <= list.size()) {
            j jVar = list.get(i3);
            if (g(jVar)) {
                List<j> h16 = h(list, Math.max(i3 - 10, 0), Math.max(i3, 0));
                List<j> h17 = h(list, Math.min(i3 + 1, list.size() - 1), Math.min(i3 + 10, list.size() - 1));
                stFeedOpInfo stfeedopinfo = jVar.e().opInfo;
                stfeedopinfo.isRequesting = 1;
                x.i("WSWidgetDataManager", "getRichOpInfo current" + stfeedopinfo.toString());
                x.i("WSWidgetDataManager", "preList------------------------");
                ArrayList<stFeedOpInfo> d16 = d(h16);
                x.i("WSWidgetDataManager", "postList-----------------------");
                ArrayList<stFeedOpInfo> d17 = d(h17);
                x.i("WSWidgetDataManager", "endList-----------------------");
                com.tencent.biz.pubaccount.weishi.net.g.b().g(new l(new i10.e(stfeedopinfo, d16, d17), null, f(jVar, bVar), 4018));
                return;
            }
            return;
        }
        x.i("WSWidgetDataManager", "[getRichOpInfo] position exception");
    }

    private ArrayList<stFeedOpInfo> d(List<j> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<stFeedOpInfo> arrayList = new ArrayList<>();
        Iterator<j> it = list.iterator();
        while (it.hasNext()) {
            stFeedOpInfo stfeedopinfo = it.next().e().opInfo;
            x.i("WSWidgetDataManager", "[getOpInfoList]" + stfeedopinfo.toString());
            arrayList.add(stfeedopinfo);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ez.a b(stGetFeedIconOpRsp stgetfeediconoprsp) {
        if (stgetfeediconoprsp == null) {
            return null;
        }
        x.b("WSWidgetDataManager", "convertRichWidgetData:" + new Gson().toJson(stgetfeediconoprsp));
        int i3 = stgetfeediconoprsp.opInfo.iconType;
        if (i3 == 3) {
            return new ez.b(stgetfeediconoprsp.businessIcon, stgetfeediconoprsp.feedIconOpConf, 3);
        }
        if (i3 == 1) {
            return new ez.c(stgetfeediconoprsp.shootIconInfo);
        }
        return null;
    }

    private List<j> h(List<j> list, int i3, int i16) {
        if (i3 > i16) {
            return null;
        }
        return list.subList(i3, i16);
    }
}
