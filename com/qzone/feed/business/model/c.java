package com.qzone.feed.business.model;

import com.qzone.common.account.LoginData;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.protocol.request.QZoneRecomRecportRequest;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.ui.AbsFeedView;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c implements IQZoneServiceListener {

    /* renamed from: m, reason: collision with root package name */
    private static c f47144m = new c();

    /* renamed from: d, reason: collision with root package name */
    private BusinessFeedData f47145d = null;

    /* renamed from: e, reason: collision with root package name */
    private long f47146e = -1;

    /* renamed from: f, reason: collision with root package name */
    public String f47147f = null;

    /* renamed from: h, reason: collision with root package name */
    private boolean f47148h = false;

    /* renamed from: i, reason: collision with root package name */
    private int f47149i = -1;

    c() {
    }

    public static c d() {
        return f47144m;
    }

    public boolean a() {
        return !this.f47148h;
    }

    public long b() {
        return this.f47146e;
    }

    public int c() {
        return this.f47149i;
    }

    public void f(int i3, String str, ArrayList<String> arrayList, int i16) {
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QZoneRecomRecportRequest(LoginData.getInstance().getUin(), 1, (short) i16, 0, i3, str, arrayList), null, this, -1));
    }

    public void g(boolean z16, AbsFeedView absFeedView, String str, int i3) {
        if (this.f47148h) {
            this.f47148h = false;
            if (z16) {
                BusinessFeedData businessFeedData = this.f47145d;
                if (businessFeedData != null && businessFeedData.getRecommItem() != null) {
                    this.f47145d.getRecommItem().isFriend = true;
                }
                if (i3 == 37678) {
                    com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().updateCardAddFriendItemState(absFeedView, str);
                } else {
                    com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().updateRecommenAddFriendItemState(absFeedView, str);
                }
            }
        }
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        int i3 = qZoneTask.mType;
    }

    public void e(BusinessFeedData businessFeedData, long j3, int i3) {
        this.f47148h = true;
        this.f47145d = businessFeedData;
        this.f47146e = j3;
        this.f47149i = i3;
    }
}
