package com.qzone.detail.ui.component;

import android.content.Context;
import android.util.SparseArray;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    private static c f47059c;

    /* renamed from: a, reason: collision with root package name */
    private SparseArray<s6.a> f47060a = new SparseArray<>(0);

    /* renamed from: b, reason: collision with root package name */
    private Context f47061b;

    public c() {
        this.f47061b = null;
        FeedGlobalEnv.g();
        this.f47061b = FeedGlobalEnv.getApplication();
        d();
        c();
    }

    public static c a() {
        if (f47059c == null) {
            synchronized (c.class) {
                f47059c = new c();
            }
        }
        return f47059c;
    }

    private void d() {
        com.qzone.adapter.feedcomponent.j.T(this.f47061b, "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_feed_res.zip");
    }

    public s6.a b(int i3) {
        return this.f47060a.get(i3);
    }

    public void c() {
        if (this.f47060a == null) {
            this.f47060a = new SparseArray<>(0);
        }
        if (this.f47060a.size() > 0) {
            return;
        }
        this.f47060a.put(0, new s6.a(R.color.ajr, "", 0, "", 4));
        this.f47060a.put(40, new s6.a(R.drawable.qzone_more_menu_delete, this.f47061b.getResources().getString(R.string.g_d), 40, "", 0));
        this.f47060a.put(39, new s6.a(R.drawable.qzone_more_menu_download, this.f47061b.getResources().getString(R.string.g_y), 39, "", 0));
        this.f47060a.put(94, new s6.a(R.drawable.qzone_detail_panel_edit, this.f47061b.getResources().getString(R.string.g_f), 94, "", 0));
        this.f47060a.put(2, new s6.a(R.drawable.qzone_detail_panel_qq, this.f47061b.getResources().getString(R.string.g_n), 2, "", 0));
        this.f47060a.put(9, new s6.a(R.drawable.cco, this.f47061b.getResources().getString(R.string.g_p), 9, "", 0));
        this.f47060a.put(10, new s6.a(R.drawable.cci, this.f47061b.getResources().getString(R.string.g_q), 10, "", 0));
        this.f47060a.put(91, new s6.a(R.drawable.qzone_detail_panel_evernote, this.f47061b.getResources().getString(R.string.g_l), 91, "", 0));
        this.f47060a.put(6, new s6.a(R.drawable.qzone_detail_panel_faved, this.f47061b.getResources().getString(R.string.g_i), 6, "", 0));
        this.f47060a.put(84, new s6.a(R.drawable.qzone_detail_panel_unfav, this.f47061b.getResources().getString(R.string.ga6), 84, "", 0));
        this.f47060a.put(11, new s6.a(R.drawable.qzone_detail_panel_report, this.f47061b.getResources().getString(R.string.g_x), 11, "", 0));
        this.f47060a.put(92, new s6.a(R.drawable.qzone_detail_panel_send_msg, this.f47061b.getResources().getString(R.string.gh_), 92, "", 0));
        this.f47060a.put(32, new s6.a(R.drawable.qzone_detail_panel_unsubscribe, this.f47061b.getResources().getString(R.string.ga7), 32, "", 0));
        this.f47060a.put(3, new s6.a(R.drawable.qzone_icon_action_sheet_qzone, this.f47061b.getResources().getString(R.string.g_o), 3, "", 0));
        this.f47060a.put(141, new s6.a(R.drawable.qzone_detail_panel_hide, this.f47061b.getResources().getString(R.string.g_t), 141, "", 0));
        this.f47060a.put(86, new s6.a(R.drawable.qzone_detail_panel_hide, this.f47061b.getResources().getString(R.string.g_s), 86, "", 0));
        this.f47060a.put(87, new s6.a(R.drawable.qzone_detail_panel_subscribe, this.f47061b.getResources().getString(R.string.g_j), 87, "", 0));
        this.f47060a.put(96, new s6.a(R.drawable.qzone_detail_panel_top, this.f47061b.getResources().getString(R.string.f172985ga4), 96, "", 0));
        this.f47060a.put(97, new s6.a(R.drawable.qzone_detail_panel_untop, this.f47061b.getResources().getString(R.string.ga8), 97, "", 0));
        this.f47060a.put(44, new s6.a(R.drawable.qzone_detail_panel_notinterested, this.f47061b.getResources().getString(R.string.ga5), 44, "", 0));
        this.f47060a.put(98, new s6.a(R.drawable.qzone_detail_panel_set_card, this.f47061b.getResources().getString(R.string.g_z), 98, "", 0));
        this.f47060a.put(99, new s6.a(R.drawable.qzone_detail_panel_set_card, com.qzone.util.l.a(R.string.mgm), 99, "", 0));
        this.f47060a.put(102, new s6.a(R.drawable.qzone_detail_panel_faved, this.f47061b.getResources().getString(R.string.g_h), 102, "", 0));
        this.f47060a.put(103, new s6.a(R.drawable.qzone_detail_panel_faved, this.f47061b.getResources().getString(R.string.g_g), 103, "", 0));
        this.f47060a.put(95, new s6.a(R.drawable.qzone_detail_panel_set_private, this.f47061b.getResources().getString(R.string.gfl), 95, "", 0));
    }
}
