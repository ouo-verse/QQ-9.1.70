package com.tencent.aelight.camera.ae.album.logic;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.tencent.aelight.camera.ae.album.data.AEAlbumLogicData;
import com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.photolist.e;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class c<K extends AEAbstractPhotoListFragment> implements MediaScanner.OnMediaScannerListener {
    protected static volatile c E;

    /* renamed from: d, reason: collision with root package name */
    protected long f62121d;

    /* renamed from: e, reason: collision with root package name */
    public WeakReference<K> f62122e;

    /* renamed from: f, reason: collision with root package name */
    public PhotoCommonBaseData<OtherCommonData> f62123f;

    /* renamed from: h, reason: collision with root package name */
    public e f62124h;

    /* renamed from: i, reason: collision with root package name */
    public final AEAlbumLogicData f62125i = new AEAlbumLogicData();

    /* renamed from: m, reason: collision with root package name */
    public InterfaceC0533c f62126m = null;
    public a C = null;
    public b D = null;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface a {
        void a(int i3, AEAbstractPhotoListFragment.g gVar, AEAbstractPhotoListFragment.f fVar);

        void b(int i3, AEAbstractPhotoListFragment.g gVar, AEAbstractPhotoListFragment.f fVar);

        View c();

        View d();

        View f();

        void g(int i3, AEAbstractPhotoListFragment.g gVar, AEAbstractPhotoListFragment.f fVar);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface b {
        void e(View view, int i3, CheckBox checkBox);
    }

    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.ae.album.logic.c$c, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public interface InterfaceC0533c {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(K k3) {
        this.f62122e = new WeakReference<>(k3);
        PhotoCommonBaseData<OtherCommonData> a16 = vp.a.a();
        this.f62123f = a16;
        a16.addHoldNember();
        this.f62124h = new e();
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "PhotoListLogic new\uff0cfragment = " + k3 + ",PhotoCommonData = " + this.f62123f);
        }
        this.f62121d = System.currentTimeMillis();
    }

    public abstract void A(int i3, boolean z16);

    public abstract void B(int i3);

    public abstract void C(float f16);

    public abstract void D(View view);

    public abstract void E(View view);

    public abstract void F();

    public abstract void G(List<LocalMediaInfo> list);

    public abstract void H(ArrayList<LocalMediaInfo> arrayList, boolean z16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void I();

    public void h() {
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "PhotoListLogic close\uff0cfragment = " + this.f62122e.get() + ",PhotoCommonData = " + this.f62123f);
        }
        this.f62123f.releaseCommonData();
        E = null;
    }

    public abstract void i();

    public abstract void j();

    public abstract void k(Intent intent);

    public abstract List<LocalMediaInfo> l(boolean z16);

    public abstract void m(Message message);

    public abstract void n(Intent intent);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int o(LocalMediaInfo localMediaInfo);

    public abstract boolean p();

    public abstract void r();

    public abstract void s(View view);

    public abstract void t(View view, Bundle bundle, int i3, Intent intent);

    public abstract void u(float f16);

    public abstract void v(View view);

    public abstract void w(View view);

    public abstract void x();

    public abstract void y(CompoundButton compoundButton, boolean z16);

    public abstract boolean z(List<LocalMediaInfo> list, boolean z16);

    public void q(boolean z16) {
    }
}
