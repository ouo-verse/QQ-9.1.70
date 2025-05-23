package com.qzone.publish.ui.model;

import com.qzone.common.friend.business.model.Friend;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.model.BusinessAlbumInfo;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private String f51965a;

    /* renamed from: b, reason: collision with root package name */
    private String f51966b;

    /* renamed from: c, reason: collision with root package name */
    private String f51967c;

    /* renamed from: d, reason: collision with root package name */
    private List<String> f51968d;

    /* renamed from: e, reason: collision with root package name */
    private BusinessAlbumInfo f51969e;

    /* renamed from: f, reason: collision with root package name */
    private HashMap<String, LocalMediaInfo> f51970f;

    /* renamed from: g, reason: collision with root package name */
    private HashMap<String, ShuoshuoVideoInfo> f51971g;

    /* renamed from: h, reason: collision with root package name */
    private HashMap<String, ShuoshuoVideoInfo> f51972h;

    /* renamed from: i, reason: collision with root package name */
    private List<Friend> f51973i;

    /* renamed from: j, reason: collision with root package name */
    private LbsDataV2.PoiInfo f51974j;

    public BusinessAlbumInfo a() {
        return this.f51969e;
    }

    public List<Friend> b() {
        return this.f51973i;
    }

    public String c() {
        return this.f51965a;
    }

    public String d() {
        return this.f51966b;
    }

    public LbsDataV2.PoiInfo e() {
        return this.f51974j;
    }

    public HashMap<String, ShuoshuoVideoInfo> f() {
        return this.f51972h;
    }

    public List<String> g() {
        return this.f51968d;
    }

    public HashMap<String, LocalMediaInfo> h() {
        return this.f51970f;
    }

    public HashMap<String, ShuoshuoVideoInfo> i() {
        return this.f51971g;
    }

    public void j(BusinessAlbumInfo businessAlbumInfo) {
        this.f51969e = businessAlbumInfo;
    }

    public void k(List<Friend> list) {
        this.f51973i = list;
    }

    public void l(String str) {
        this.f51965a = str;
    }

    public void m(LbsDataV2.PoiInfo poiInfo) {
        this.f51974j = poiInfo;
    }

    public void n(HashMap<String, ShuoshuoVideoInfo> hashMap) {
        this.f51972h = hashMap;
    }

    public void o(List<String> list) {
        this.f51968d = list;
    }

    public void p(HashMap<String, LocalMediaInfo> hashMap) {
        this.f51970f = hashMap;
    }

    public void q(HashMap<String, ShuoshuoVideoInfo> hashMap) {
        this.f51971g = hashMap;
    }

    public void r(String str) {
        this.f51966b = str;
    }

    public void s(String str) {
        this.f51967c = str;
    }
}
