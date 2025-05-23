package com.tencent.biz.pubaccount.weishi.verticalvideo.utils;

import UserGrowth.stFloatingLayerCardStyle;
import UserGrowth.stSimpleMetaFeed;
import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.player.WSVideoPreDownloadManager;
import com.tencent.biz.pubaccount.weishi.player.l;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.util.p;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.q;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.j;
import com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes32.dex */
public class e {

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements View.OnLayoutChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RecyclerView f82337d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TextView f82338e;

        a(RecyclerView recyclerView, TextView textView) {
            this.f82337d = recyclerView;
            this.f82338e = textView;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            this.f82337d.removeOnLayoutChangeListener(this);
            int height = (int) ((((int) (this.f82337d.getHeight() * 0.3f)) - this.f82338e.getPaddingTop()) - this.f82338e.getTextSize());
            TextView textView = this.f82338e;
            textView.setPadding(textView.getPaddingLeft(), this.f82338e.getPaddingTop(), this.f82338e.getPaddingRight(), height);
        }
    }

    private static void a(List<WSVideoPreDownloadManager.c> list, List<j> list2, int i3) {
        if (list2.size() <= i3 || i3 < 0) {
            return;
        }
        j jVar = list2.get(i3);
        if (jVar.e() instanceof stSimpleMetaFeed) {
            list.add(d(jVar.e()));
        }
    }

    public static WSVideoPreDownloadManager.c d(stSimpleMetaFeed stsimplemetafeed) {
        WSVideoPreDownloadManager.c cVar = new WSVideoPreDownloadManager.c(x10.a.i(stsimplemetafeed, com.tencent.biz.pubaccount.weishi.video.specurl.d.f82378a.c(stsimplemetafeed.video_spec_urls)), stsimplemetafeed.video.duration, x10.a.e(stsimplemetafeed, r0), stsimplemetafeed.gdt_ad_type == 1);
        cVar.f81110a = stsimplemetafeed.f25129id;
        cVar.f81112c = stsimplemetafeed.feed_desc;
        cVar.f81117h = p(stsimplemetafeed);
        return cVar;
    }

    private static int f(stSimpleMetaFeed stsimplemetafeed) {
        stFloatingLayerCardStyle stfloatinglayercardstyle = stsimplemetafeed.floatingLayerCardStyle;
        if (stfloatinglayercardstyle == null || stfloatinglayercardstyle.cardType != 4) {
            return 3;
        }
        return q.b(stsimplemetafeed) ? 5 : 4;
    }

    public static TextView g(RecyclerView recyclerView, Context context) {
        TextView textView = (TextView) LayoutInflater.from(context).inflate(R.layout.fwt, (ViewGroup) null);
        recyclerView.addOnLayoutChangeListener(new a(recyclerView, textView));
        return textView;
    }

    public static int h(String str) {
        return (TextUtils.equals(str, "follow_tab") || TextUtils.equals(str, "friend_feed")) ? 0 : 1;
    }

    public static String i(String str) {
        int random = (int) ((Math.random() * 899) + 100);
        return p.k() + "_" + str + "_" + System.currentTimeMillis() + "_" + random;
    }

    public static String j(String str) {
        if (TextUtils.equals(str, "aio_home_page")) {
            return "recommend_tab";
        }
        if (TextUtils.equals(str, "trends")) {
            return "trends_ws";
        }
        return "vertical_page";
    }

    public static int l(String str) {
        if (TextUtils.equals(str, "trends")) {
            return 6;
        }
        if (TextUtils.equals(str, "aio_home_page")) {
            return 12;
        }
        return TextUtils.equals(str, "qqchat") ? 10007 : 2;
    }

    public static List<l> n(List<j> list, int i3) {
        stSimpleMetaFeed e16;
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > i3) {
            while (i3 < list.size()) {
                j jVar = list.get(i3);
                if (jVar != null && (e16 = jVar.e()) != null) {
                    arrayList.add(x10.a.a(e16));
                }
                i3++;
            }
        }
        return arrayList;
    }

    public static List<WSVideoPreDownloadManager.c> o(List<j> list, int i3, boolean z16) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(list);
        if (z16) {
            int i16 = i3 + 1;
            for (int i17 = i16; i17 < i16 + 3; i17++) {
                a(arrayList, arrayList2, i17);
            }
        } else {
            int i18 = i3 - 1;
            for (int i19 = i18; i19 > i18 - 3; i19--) {
                a(arrayList, arrayList2, i19);
            }
        }
        return arrayList;
    }

    public static boolean p(stSimpleMetaFeed stsimplemetafeed) {
        if (stsimplemetafeed.gdt_ad_type == 1) {
            return "1".equals(com.tencent.biz.pubaccount.weishi.verticalvideo.gdt.a.f(new GdtAd(com.tencent.biz.pubaccount.weishi.verticalvideo.gdt.a.d(stsimplemetafeed)), 119700));
        }
        return false;
    }

    public static void q(String str, List<j> list) {
        if (QLog.isColorLevel()) {
            if (list == null) {
                x.f("FEED_TITLE", str + " itemList is null!");
                return;
            }
            for (j jVar : list) {
                if (jVar.e() instanceof stSimpleMetaFeed) {
                    x.i("FEED_TITLE", str + " title:" + jVar.e().feed_desc);
                }
            }
            x.b("FEED_TITLE", str + " feedListSize:" + list.size());
        }
    }

    public static List<j> c(List<stSimpleMetaFeed> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (stSimpleMetaFeed stsimplemetafeed : list) {
            j jVar = new j();
            jVar.p(stsimplemetafeed);
            arrayList.add(jVar);
        }
        return arrayList;
    }

    public static Map<String, String> k(Map<String, String> map, au auVar) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.putAll(com.tencent.biz.pubaccount.weishi.verticalvideo.onemore.b.c(m(auVar)));
        return map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static stSimpleMetaFeed m(au auVar) {
        T t16;
        if (auVar == null || (t16 = auVar.f82129f) == 0) {
            return null;
        }
        return ((j) t16).e();
    }

    public static boolean b(Set<String> set, int i3, l lVar) {
        if (i3 == 1) {
            if (TextUtils.isEmpty(lVar.f81166a)) {
                return false;
            }
            set.add(lVar.f81166a);
            return false;
        }
        if (!set.contains(lVar.f81166a)) {
            x.f("WSVerticalUtils", "[checkNoStartedVideo] title:" + lVar.f81175j);
            return true;
        }
        set.remove(lVar.f81166a);
        return false;
    }

    public static int e(j jVar) {
        stSimpleMetaFeed e16;
        stFloatingLayerCardStyle stfloatinglayercardstyle;
        if (jVar == null || jVar.e() == null || (stfloatinglayercardstyle = (e16 = jVar.e()).floatingLayerCardStyle) == null) {
            return 3;
        }
        int i3 = stfloatinglayercardstyle.cardType;
        if (i3 == 1002 || i3 == 2 || i3 == 4) {
            return i3 == 4 ? f(e16) : i3;
        }
        return 3;
    }

    public static void r(Activity activity, ViewGroup viewGroup) {
        if (activity == null || viewGroup == null) {
            return;
        }
        viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getPaddingTop() + ba.q(activity), viewGroup.getPaddingRight(), viewGroup.getPaddingBottom());
    }
}
