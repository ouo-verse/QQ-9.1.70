package com.qzone.feed.business.service;

import android.os.Handler;
import com.qzone.adapter.feedcomponent.k;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.event.Observable;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class a extends Observable implements IQZoneServiceListener {

    /* renamed from: d, reason: collision with root package name */
    public int f47216d;

    /* renamed from: e, reason: collision with root package name */
    protected final String f47217e;

    public a() {
        this("Feed");
    }

    public static int C(int i3) {
        if (i3 == 0) {
            return 1;
        }
        int i16 = 2;
        if (i3 != 1) {
            if (i3 == 2) {
                return 4;
            }
            i16 = 3;
            if (i3 != 3) {
                if (i3 != 4) {
                    return 0;
                }
                return 7;
            }
        }
        return i16;
    }

    public abstract List<BusinessFeedData> D();

    public abstract com.qzone.proxy.feedcomponent.manager.d E();

    public k F() {
        return null;
    }

    public abstract boolean H();

    public abstract void I(Handler handler);

    public abstract void J(Handler handler);

    public abstract void L(Handler handler, String str);

    public a(String str) {
        super(str);
        this.f47217e = getClass().getSimpleName();
    }

    public void G(BusinessFeedData businessFeedData) {
    }

    public void K() {
    }
}
