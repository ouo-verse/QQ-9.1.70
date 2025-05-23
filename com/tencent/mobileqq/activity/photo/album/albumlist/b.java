package com.tencent.mobileqq.activity.photo.album.albumlist;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class b<O extends OtherCommonData> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public AbstractAlbumListFragment f184221a;

    /* renamed from: b, reason: collision with root package name */
    protected PhotoCommonBaseData<O> f184222b;

    /* renamed from: c, reason: collision with root package name */
    protected O f184223c;

    /* renamed from: d, reason: collision with root package name */
    protected com.tencent.mobileqq.activity.photo.album.albumlist.a f184224d;

    /* renamed from: e, reason: collision with root package name */
    public InterfaceC7191b f184225e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements OtherCommonData {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.photo.album.albumlist.b$b, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC7191b {
        String a();

        void b(int i3);

        List<QQAlbumInfo> c(List<QQAlbumInfo> list, List<QQAlbumInfo> list2, int i3);

        View getView(int i3, View view, ViewGroup viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public b(AbstractAlbumListFragment abstractAlbumListFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractAlbumListFragment);
            return;
        }
        this.f184225e = null;
        this.f184221a = abstractAlbumListFragment;
        PhotoCommonBaseData<O> photoCommonBaseData = (PhotoCommonBaseData<O>) PhotoCommonBaseData.getInstance(abstractAlbumListFragment.getActivity().getIntent().getBooleanExtra(PhotoCommonBaseData.NEED_NEW_PHOTO_COMMON_DATA, true));
        this.f184222b = photoCommonBaseData;
        this.f184223c = (O) photoCommonBaseData.bindCommonData((PhotoCommonBaseData<O>) e());
        abstractAlbumListFragment.getActivity().getIntent().putExtra(PhotoCommonBaseData.NEED_NEW_PHOTO_COMMON_DATA, false);
        this.f184222b.addHoldNember();
        this.f184224d = new com.tencent.mobileqq.activity.photo.album.albumlist.a();
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "AlbumListCustomization new\uff0cactivity = " + this.f184221a + ",PhotoCommonData = " + this.f184222b);
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "AlbumListCustomization close\uff0cactivity = " + this.f184221a + ",PhotoCommonData = " + this.f184222b);
        }
        this.f184222b.releaseCommonData();
    }

    protected OtherCommonData e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (OtherCommonData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new a();
    }

    public abstract void f(Intent intent);

    public abstract boolean g(QQAlbumInfo qQAlbumInfo, int i3, Intent intent);

    public abstract void h();
}
