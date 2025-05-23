package com.tencent.mobileqq.guild.feed.adapter;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.feed.util.bm;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: P */
/* loaded from: classes13.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private String f217963a;

    /* renamed from: b, reason: collision with root package name */
    private int f217964b;

    /* renamed from: c, reason: collision with root package name */
    private int f217965c;

    /* renamed from: d, reason: collision with root package name */
    private int f217966d;

    /* renamed from: e, reason: collision with root package name */
    private GProStImage f217967e;

    /* renamed from: f, reason: collision with root package name */
    private GProStVideo f217968f;

    /* renamed from: g, reason: collision with root package name */
    private int f217969g = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a implements Comparator<n> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(n nVar, n nVar2) {
            if (nVar.a() > nVar2.a()) {
                return 1;
            }
            return -1;
        }
    }

    private void i(GProStImage gProStImage) {
        this.f217967e = gProStImage;
    }

    private void j(GProStVideo gProStVideo) {
        this.f217968f = gProStVideo;
    }

    public static ArrayList<n> m(GProStFeed gProStFeed) {
        ArrayList<GProStImage> arrayList;
        ArrayList<n> arrayList2 = new ArrayList<>();
        if (gProStFeed != null && ((arrayList = gProStFeed.images) != null || gProStFeed.videos != null)) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                n n3 = n(arrayList.get(i3), gProStFeed);
                if (n3 != null) {
                    arrayList2.add(n3);
                }
            }
            ArrayList<GProStVideo> arrayList3 = gProStFeed.videos;
            for (int i16 = 0; i16 < arrayList3.size(); i16++) {
                n o16 = o(arrayList3.get(i16), gProStFeed);
                if (o16 != null) {
                    arrayList2.add(o16);
                }
            }
            Collections.sort(arrayList2, new a());
        }
        return arrayList2;
    }

    private static n n(GProStImage gProStImage, GProStFeed gProStFeed) {
        if (gProStImage == null) {
            return null;
        }
        n nVar = new n();
        nVar.h(bm.h(gProStImage));
        nVar.f(gProStImage.displayIndex);
        nVar.l(gProStImage.width);
        nVar.g(gProStImage.height);
        nVar.i(gProStImage);
        nVar.k(1);
        return nVar;
    }

    private static n o(GProStVideo gProStVideo, GProStFeed gProStFeed) {
        if (gProStVideo == null) {
            return null;
        }
        n nVar = new n();
        nVar.h(bm.h(gProStVideo.cover));
        nVar.f(gProStVideo.displayIndex);
        nVar.l(gProStVideo.width);
        nVar.g(gProStVideo.height);
        nVar.j(gProStVideo);
        nVar.k(2);
        return nVar;
    }

    public int a() {
        return this.f217964b;
    }

    public String b() {
        return this.f217963a;
    }

    public GProStImage c() {
        return this.f217967e;
    }

    public GProStVideo d() {
        return this.f217968f;
    }

    public int e() {
        return this.f217969g;
    }

    public void f(int i3) {
        this.f217964b = i3;
    }

    public void g(int i3) {
        this.f217966d = i3;
    }

    public void h(String str) {
        this.f217963a = str;
    }

    public void k(int i3) {
        this.f217969g = i3;
    }

    public void l(int i3) {
        this.f217965c = i3;
    }

    @NonNull
    public String toString() {
        return "MixedMediaData[ index: " + this.f217964b + ", picUrl: " + this.f217963a + ", width = " + this.f217965c + ", height = " + this.f217966d + ", type = " + this.f217969g + " ]";
    }
}
