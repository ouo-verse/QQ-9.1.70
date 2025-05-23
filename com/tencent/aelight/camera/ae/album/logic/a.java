package com.tencent.aelight.camera.ae.album.logic;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.aelight.camera.ae.album.fragment.AEAbstractAlbumListFragment;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class a<K extends AEAbstractAlbumListFragment> {

    /* renamed from: e, reason: collision with root package name */
    public static volatile a f62114e;

    /* renamed from: a, reason: collision with root package name */
    public WeakReference<K> f62115a;

    /* renamed from: b, reason: collision with root package name */
    protected PhotoCommonBaseData f62116b;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.mobileqq.activity.photo.album.albumlist.a f62117c;

    /* renamed from: d, reason: collision with root package name */
    public InterfaceC0532a f62118d = null;

    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.ae.album.logic.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public interface InterfaceC0532a {
        String a();

        void b(int i3);

        List<QQAlbumInfo> c(List<QQAlbumInfo> list, List<QQAlbumInfo> list2, int i3);

        List<LocalMediaInfo> d(Context context, int i3, int i16, MediaFileFilter mediaFileFilter, int i17, boolean z16, ArrayList<String> arrayList);

        View getView(int i3, View view, ViewGroup viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(K k3) {
        this.f62115a = new WeakReference<>(k3);
        PhotoCommonBaseData a16 = vp.a.a();
        this.f62116b = a16;
        a16.addHoldNember();
        this.f62117c = new com.tencent.mobileqq.activity.photo.album.albumlist.a();
        if (QLog.isColorLevel()) {
            QLog.d("AlbumListActivity", 2, "AlbumListLogic new\uff0cactivity = " + this.f62115a + ",PhotoCommonData = " + this.f62116b);
        }
    }

    public void e() {
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "AlbumListLogic new\uff0cfragment = " + this.f62115a.get() + ",PhotoCommonData = " + this.f62116b);
        }
        this.f62116b.releaseCommonData();
        f62114e = null;
    }

    public abstract void f(Intent intent);

    public abstract boolean g(QQAlbumInfo qQAlbumInfo, int i3, Intent intent);

    public abstract void h();
}
