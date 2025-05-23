package com.tencent.biz.pubaccount.weishi.verticalvideo;

import UserGrowth.stCollection;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private final String f82171a;

    /* renamed from: b, reason: collision with root package name */
    private final String f82172b;

    /* renamed from: h, reason: collision with root package name */
    private int f82178h;

    /* renamed from: i, reason: collision with root package name */
    private int f82179i;

    /* renamed from: j, reason: collision with root package name */
    private int f82180j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f82181k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f82182l;

    /* renamed from: m, reason: collision with root package name */
    private stCollection f82183m;

    /* renamed from: n, reason: collision with root package name */
    private Bundle f82184n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f82185o;

    /* renamed from: q, reason: collision with root package name */
    private int f82187q;

    /* renamed from: r, reason: collision with root package name */
    private String f82188r;

    /* renamed from: s, reason: collision with root package name */
    private String f82189s;

    /* renamed from: t, reason: collision with root package name */
    private View f82190t;

    /* renamed from: u, reason: collision with root package name */
    private int f82191u;

    /* renamed from: v, reason: collision with root package name */
    private WSAutoShowCommentParams f82192v;

    /* renamed from: w, reason: collision with root package name */
    private List<stSimpleMetaFeed> f82193w;

    /* renamed from: x, reason: collision with root package name */
    private Context f82194x;

    /* renamed from: y, reason: collision with root package name */
    private BaseFragment f82195y;

    /* renamed from: c, reason: collision with root package name */
    private String f82173c = "";

    /* renamed from: d, reason: collision with root package name */
    private String f82174d = "";

    /* renamed from: e, reason: collision with root package name */
    private String f82175e = "";

    /* renamed from: f, reason: collision with root package name */
    private String f82176f = "";

    /* renamed from: g, reason: collision with root package name */
    private String f82177g = "";

    /* renamed from: p, reason: collision with root package name */
    private boolean f82186p = false;

    public k(String str, String str2) {
        this.f82171a = str;
        this.f82172b = str2;
    }

    public k A(boolean z16) {
        this.f82186p = z16;
        return this;
    }

    public k B(boolean z16) {
        this.f82181k = z16;
        return this;
    }

    public k C(View view) {
        this.f82190t = view;
        return this;
    }

    public k D(String str) {
        this.f82176f = str;
        return this;
    }

    public k E(Context context) {
        this.f82194x = context;
        return this;
    }

    public k F(Bundle bundle) {
        this.f82184n = bundle;
        return this;
    }

    public k G(String str) {
        this.f82174d = str;
        return this;
    }

    public k H(int i3) {
        this.f82180j = i3;
        return this;
    }

    public k I(String str) {
        this.f82177g = str;
        return this;
    }

    public k J(List<stSimpleMetaFeed> list) {
        this.f82193w = list;
        return this;
    }

    public k K(BaseFragment baseFragment) {
        this.f82195y = baseFragment;
        return this;
    }

    public k L(boolean z16) {
        this.f82182l = z16;
        return this;
    }

    public k M(int i3) {
        this.f82178h = i3;
        return this;
    }

    public k N(boolean z16) {
        this.f82185o = z16;
        return this;
    }

    public k O(int i3) {
        this.f82191u = i3;
        return this;
    }

    public k P(String str) {
        this.f82175e = str;
        return this;
    }

    public k Q(int i3) {
        this.f82187q = i3;
        return this;
    }

    public k R(String str) {
        this.f82188r = str;
        return this;
    }

    public k S(int i3) {
        this.f82179i = i3;
        return this;
    }

    public k T(String str) {
        this.f82189s = str;
        return this;
    }

    public k U(String str) {
        this.f82173c = str;
        return this;
    }

    public Intent V() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("key_from", l());
        bundle.putString("key_play_scene", r());
        bundle.putString("key_sub_tab_id", u());
        bundle.putString("key_fall_list_feed_id", g());
        bundle.putString("key_page_session", o());
        bundle.putString("key_collection_id", d());
        bundle.putString("key_feed_id", i());
        List<stSimpleMetaFeed> j3 = j();
        if (j3 != null && j3.size() > 0) {
            bundle.putSerializable("key_feed_list", new ArrayList(j3));
        }
        bundle.putInt("key_feed_position", m());
        bundle.putInt("key_fall_list_index", h());
        bundle.putLong("key_start_time", SystemClock.uptimeMillis());
        bundle.putBoolean("key_cal_delta_time", x());
        bundle.putSerializable("key_collection", c());
        bundle.putSerializable("auto_show_panel", Boolean.valueOf(v()));
        if (f() != null) {
            bundle.putAll(f());
        }
        bundle.putBoolean("key_is_show_open_ws_dialog", y());
        bundle.putInt(MiniAppPlugin.ATTR_PAGE_TYPE, p());
        bundle.putString("person_id", q());
        bundle.putString("share_data_key", t());
        bundle.putSerializable("auto_show_comment_params", a());
        intent.putExtras(bundle);
        return intent;
    }

    public WSAutoShowCommentParams a() {
        return this.f82192v;
    }

    public View b() {
        return this.f82190t;
    }

    public stCollection c() {
        return this.f82183m;
    }

    public String d() {
        return this.f82176f;
    }

    public Context e() {
        return this.f82194x;
    }

    public Bundle f() {
        return this.f82184n;
    }

    public String g() {
        return this.f82174d;
    }

    public int h() {
        return this.f82180j;
    }

    public String i() {
        return this.f82177g;
    }

    public List<stSimpleMetaFeed> j() {
        return this.f82193w;
    }

    public BaseFragment k() {
        return this.f82195y;
    }

    public String l() {
        return this.f82171a;
    }

    public int m() {
        return this.f82178h;
    }

    public int n() {
        return this.f82191u;
    }

    public String o() {
        return this.f82175e;
    }

    public int p() {
        return this.f82187q;
    }

    public String q() {
        return this.f82188r;
    }

    public String r() {
        return this.f82172b;
    }

    public int s() {
        return this.f82179i;
    }

    public String t() {
        return this.f82189s;
    }

    public String toString() {
        return "WSVerticalPageOpenParams{from='" + this.f82171a + "', playScene='" + this.f82172b + "', subTabId='" + this.f82173c + "', needScrollToPosition=" + this.f82178h + ", clearTop=" + this.f82181k + ", isNeedCalcDeltaTime=" + this.f82182l + ", collection=" + this.f82183m + ", collectionId=" + this.f82176f + ", feeds=" + this.f82193w + ", context=" + this.f82194x + ", extBundle=" + this.f82184n + '}';
    }

    public String u() {
        return this.f82173c;
    }

    public boolean v() {
        return this.f82186p;
    }

    public boolean w() {
        return this.f82181k;
    }

    public boolean x() {
        return this.f82182l;
    }

    public boolean y() {
        return this.f82185o;
    }

    public k z(WSAutoShowCommentParams wSAutoShowCommentParams) {
        this.f82192v = wSAutoShowCommentParams;
        return this;
    }

    public k(Context context, String str, String str2) {
        this.f82194x = context;
        this.f82171a = str;
        this.f82172b = str2;
    }
}
