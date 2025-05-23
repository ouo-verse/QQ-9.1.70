package com.qzone.album.business.photolist.ui.menu;

import android.app.Activity;
import android.content.Context;
import com.qzone.adapter.feedcomponent.s;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.AlbumDataOutShare;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.common.activities.base.BaseActivity;
import java.util.ArrayList;
import k4.g;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private g f43713a;

    public void a() {
        g gVar = this.f43713a;
        if (gVar != null) {
            gVar.x();
        }
    }

    public void b() {
        g gVar = this.f43713a;
        if (gVar != null) {
            gVar.E(true);
        }
    }

    public boolean c() {
        g gVar = this.f43713a;
        if (gVar != null) {
            return gVar.G();
        }
        return false;
    }

    public boolean d() {
        g gVar = this.f43713a;
        if (gVar != null) {
            return gVar.H();
        }
        return false;
    }

    public void e(s sVar) {
        g gVar = this.f43713a;
        if (gVar != null) {
            gVar.K(sVar);
        }
    }

    public void g(boolean z16) {
        g gVar = this.f43713a;
        if (gVar != null) {
            gVar.X(z16);
        }
    }

    public void h(String str) {
        g gVar = this.f43713a;
        if (gVar != null) {
            gVar.b0(str);
        }
    }

    public void i(String str) {
        g gVar = this.f43713a;
        if (gVar != null) {
            gVar.c0(str);
        }
    }

    public void j(AlbumCacheData albumCacheData) {
        g gVar = this.f43713a;
        if (gVar != null) {
            gVar.f0(albumCacheData);
        }
    }

    public void f(Context context, Activity activity, int i3, int i16, String str, AlbumDataOutShare albumDataOutShare, AlbumCacheData albumCacheData, ArrayList<PhotoCacheData> arrayList, boolean z16) {
        g gVar = this.f43713a;
        if (gVar == null) {
            g gVar2 = new g(context, (BaseActivity) activity, i3, i16, str, albumCacheData);
            this.f43713a = gVar2;
            if (z16) {
                gVar2.Z(1);
            }
            this.f43713a.Y(arrayList);
        } else if (arrayList != null && gVar.O(arrayList.size())) {
            this.f43713a.Y(arrayList);
            this.f43713a.L(true);
        } else {
            this.f43713a.L(false);
        }
        this.f43713a.a0(albumDataOutShare);
    }
}
