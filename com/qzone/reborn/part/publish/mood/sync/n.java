package com.qzone.reborn.part.publish.mood.sync;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.DateUtils;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes37.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private HashMap<Integer, String> f58729a;

    /* renamed from: b, reason: collision with root package name */
    private HashMap<Integer, String> f58730b;

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<Integer> f58731c;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<Integer> f58732d;

    /* renamed from: e, reason: collision with root package name */
    private a f58733e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f58734f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f58735g;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface a {
        void a(int i3, String str);

        void b(int i3, String str);
    }

    public n() {
        k();
        j();
    }

    private void j() {
        this.f58729a = new HashMap<>();
        this.f58730b = new HashMap<>();
    }

    private void k() {
        this.f58731c = new ArrayList<>();
        this.f58732d = new ArrayList<>();
    }

    private boolean l() {
        long f16 = uq3.k.a().f("publish_page_sync_qfs_preview_bubble", 0L);
        boolean isSameDay = DateUtils.isSameDay(System.currentTimeMillis(), f16);
        boolean c16 = gd.a.f401926a.c("KEY_OPEN_QZONE_BUBBLE_TEST", false);
        RFWLog.i("QZonePublishSyncQFSBubbleManager", RFWLog.USR, "is same day " + isSameDay + " preview bubble last show time is " + f16 + " current time is " + System.currentTimeMillis() + " debug switch is " + c16);
        return !isSameDay || c16;
    }

    private boolean m() {
        long f16 = uq3.k.a().f("publish_page_sync_qfs_switch_bubble", 0L);
        boolean isSameWeek = DateUtils.isSameWeek(System.currentTimeMillis(), f16);
        boolean c16 = gd.a.f401926a.c("KEY_OPEN_QZONE_BUBBLE_TEST", false);
        RFWLog.i("QZonePublishSyncQFSBubbleManager", RFWLog.USR, "is same week " + isSameWeek + " switch bubble last show time is " + f16 + " current time is " + System.currentTimeMillis() + " debug switch is " + c16);
        return !isSameWeek || c16;
    }

    public static boolean n() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PUBLISH_MOOD, QzoneConfig.SECONDARY_KEY_PUBLISH_PAGE_IF_SHOW_SYNC_QCIRCLE_BUBBLE, 1) == 1;
    }

    private boolean o(ArrayList<Integer> arrayList) {
        return (!arrayList.isEmpty() && n() && l()) ? false : true;
    }

    private boolean p(ArrayList<Integer> arrayList) {
        return (!arrayList.isEmpty() && n() && m()) ? false : true;
    }

    public void a(int i3, String str) {
        ArrayList<Integer> arrayList;
        if (this.f58729a == null || (arrayList = this.f58731c) == null) {
            return;
        }
        arrayList.add(Integer.valueOf(i3));
        this.f58729a.put(Integer.valueOf(i3), str);
    }

    public void b(int i3, String str) {
        ArrayList<Integer> arrayList;
        if (this.f58730b == null || (arrayList = this.f58732d) == null) {
            return;
        }
        arrayList.add(Integer.valueOf(i3));
        this.f58730b.put(Integer.valueOf(i3), str);
    }

    public void c() {
        ArrayList<Integer> arrayList;
        if (this.f58729a == null || (arrayList = this.f58731c) == null) {
            return;
        }
        arrayList.clear();
        this.f58729a.clear();
    }

    public void d() {
        ArrayList<Integer> arrayList;
        if (this.f58730b == null || (arrayList = this.f58732d) == null) {
            return;
        }
        arrayList.clear();
        this.f58730b.clear();
    }

    public void e() {
        ArrayList<Integer> arrayList = this.f58731c;
        if (arrayList == null || this.f58729a == null) {
            return;
        }
        if (this.f58733e == null) {
            RFWLog.e("QZonePublishSyncQFSBubbleManager", RFWLog.USR, "bubble listener is null");
            return;
        }
        if (this.f58734f) {
            RFWLog.i("QZonePublishSyncQFSBubbleManager", RFWLog.USR, "has show preview bubble, return");
            return;
        }
        if (o(arrayList)) {
            this.f58733e.b(0, "");
            RFWLog.i("QZonePublishSyncQFSBubbleManager", RFWLog.USR, "preview list is empty or switch is close " + n() + " " + l());
            return;
        }
        if (this.f58731c.isEmpty()) {
            this.f58733e.b(0, "");
            return;
        }
        int intValue = this.f58731c.get(0).intValue();
        for (int i3 = 0; i3 < this.f58731c.size(); i3++) {
            if (intValue > this.f58731c.get(i3).intValue()) {
                intValue = this.f58731c.get(i3).intValue();
            }
        }
        this.f58734f = true;
        uq3.k.a().n("publish_page_sync_qfs_preview_bubble", System.currentTimeMillis());
        this.f58733e.b(intValue, this.f58729a.get(Integer.valueOf(intValue)));
    }

    public void f() {
        ArrayList<Integer> arrayList = this.f58732d;
        if (arrayList == null || this.f58730b == null) {
            return;
        }
        if (this.f58733e == null) {
            RFWLog.e("QZonePublishSyncQFSBubbleManager", RFWLog.USR, "bubble listener is null");
            return;
        }
        if (this.f58735g) {
            RFWLog.i("QZonePublishSyncQFSBubbleManager", RFWLog.USR, "has show switch bubble, return");
            return;
        }
        if (p(arrayList)) {
            this.f58733e.a(0, "");
            RFWLog.i("QZonePublishSyncQFSBubbleManager", RFWLog.USR, "switch list is empty or switch is close");
            return;
        }
        if (this.f58732d.isEmpty()) {
            this.f58733e.a(0, "");
            return;
        }
        int intValue = this.f58732d.get(0).intValue();
        for (int i3 = 0; i3 < this.f58732d.size(); i3++) {
            if (intValue > this.f58732d.get(i3).intValue()) {
                intValue = this.f58732d.get(i3).intValue();
            }
        }
        this.f58735g = true;
        uq3.k.a().n("publish_page_sync_qfs_switch_bubble", System.currentTimeMillis());
        this.f58733e.a(intValue, this.f58730b.get(Integer.valueOf(intValue)));
    }

    public String g() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PUBLISH_MOOD, QzoneConfig.SECONDARY_KEY_PUBLISH_PAGE_SYNC_QCIRCLE_MEMORY_SWITCH_BUBBLE_TEXT, QzoneConfig.DEFAULT_KEY_PUBLISH_PAGE_SYNC_QCIRCLE_MEMORY_SWITCH_BUBBLE_TEXT);
    }

    public String h() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PUBLISH_MOOD, QzoneConfig.SECONDARY_KEY_PUBLISH_PAGE_SYNC_QCIRCLE_PREVIEW_BUBBLE_TEXT, QzoneConfig.DEFAULT_KEY_PUBLISH_PAGE_SYNC_QCIRCLE_PREVIEW_BUBBLE_TEXT);
    }

    public String i() {
        return com.dataline.util.j.d(QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PUBLISH_MOOD, QzoneConfig.SECONDARY_KEY_PUBLISH_PAGE_SYNC_QCIRCLE_SWITCH_BUBBLE_TEXT, QzoneConfig.DEFAULT_KEY_PUBLISH_PAGE_SYNC_QCIRCLE_SWITCH_BUBBLE_TEXT));
    }

    public void q(a aVar) {
        this.f58733e = aVar;
    }
}
