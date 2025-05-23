package com.tencent.mobileqq.activity.photo.album;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.albumlist.AlbumListAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes10.dex */
public class NewAlbumListAdapter extends AlbumListAdapter {
    static IPatchRedirector $redirector_;
    public long N;
    public QQAlbumInfo P;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        int f184173a;

        /* renamed from: b, reason: collision with root package name */
        int f184174b;

        /* renamed from: c, reason: collision with root package name */
        int f184175c;

        /* renamed from: d, reason: collision with root package name */
        int f184176d;

        /* renamed from: e, reason: collision with root package name */
        int f184177e;

        /* renamed from: f, reason: collision with root package name */
        int f184178f;

        /* renamed from: g, reason: collision with root package name */
        int f184179g;

        /* renamed from: h, reason: collision with root package name */
        int f184180h;

        /* renamed from: i, reason: collision with root package name */
        int f184181i;

        /* renamed from: j, reason: collision with root package name */
        int f184182j;

        /* renamed from: k, reason: collision with root package name */
        int f184183k;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f184173a = 0;
            this.f184174b = 0;
            this.f184175c = 0;
            this.f184176d = 0;
            this.f184177e = 0;
            this.f184178f = 0;
            this.f184179g = 0;
            this.f184180h = 0;
            this.f184181i = 0;
            this.f184182j = 0;
            this.f184183k = 0;
        }
    }

    public NewAlbumListAdapter(AlbumListFragment albumListFragment) {
        super(albumListFragment);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) albumListFragment);
        }
    }

    public static void p(a aVar, String str, QQAlbumInfo qQAlbumInfo) {
        String str2 = qQAlbumInfo.name;
        if (str2.equals("qq_screenshot")) {
            aVar.f184174b += qQAlbumInfo.mMediaFileCount;
            return;
        }
        if (!str.contains("screenshot") && !str.contains("\u622a\u5c4f") && !str.contains("\u622a\u56fe") && !str.equals("screen_cap") && !str.equals("ScreenCapture")) {
            if (!str2.contains("camera") && !str2.equals("dcim") && !str2.equals("100MEDIA") && !str2.equals("100ANDRO") && !str2.contains("\u76f8\u673a") && !str2.contains("\u7167\u7247") && !str2.contains("\u76f8\u7247")) {
                if (com.tencent.mobileqq.statistics.i.a(str)) {
                    aVar.f184176d += qQAlbumInfo.mMediaFileCount;
                    return;
                } else {
                    aVar.f184177e += qQAlbumInfo.mMediaFileCount;
                    return;
                }
            }
            aVar.f184173a += qQAlbumInfo.mMediaFileCount;
            return;
        }
        aVar.f184175c += qQAlbumInfo.mMediaFileCount;
    }

    public static void q(a aVar, String str, QQAlbumInfo qQAlbumInfo) {
        String str2 = qQAlbumInfo.name;
        if (str.contains("/qq_collection/")) {
            aVar.f184178f += qQAlbumInfo.mMediaFileCount;
            return;
        }
        if (!str2.equals("qq_images") && !str.contains("/mobileqq/photo") && !str.contains("/mobileqq/diskcache")) {
            if (str2.equals("qqfile_recv")) {
                aVar.f184180h += qQAlbumInfo.mMediaFileCount;
                return;
            }
            if (str2.equals("qq_favorite")) {
                aVar.f184182j += qQAlbumInfo.mMediaFileCount;
                return;
            }
            if (str.contains("/zebra/cache")) {
                aVar.f184181i++;
                return;
            }
            if (!str2.equals("weixin") && !str2.equals("wechat") && !str2.equals("micromsg")) {
                if (com.tencent.mobileqq.statistics.i.a(str)) {
                    aVar.f184176d += qQAlbumInfo.mMediaFileCount;
                    return;
                } else {
                    aVar.f184177e += qQAlbumInfo.mMediaFileCount;
                    return;
                }
            }
            aVar.f184183k += qQAlbumInfo.mMediaFileCount;
            return;
        }
        aVar.f184179g += qQAlbumInfo.mMediaFileCount;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.photo.album.albumlist.AlbumListAdapter
    public List<QQAlbumInfo> b() {
        QQAlbumInfo qQAlbumInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        List<QQAlbumInfo> b16 = super.b();
        if (b16 != null && (qQAlbumInfo = this.P) != null) {
            b16.add(0, qQAlbumInfo);
        }
        return b16;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.albumlist.AlbumListAdapter
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.k();
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.photo.album.NewAlbumListAdapter.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NewAlbumListAdapter.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    LocalMediaInfo localMediaInfo;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    a aVar = new a();
                    List a16 = NewAlbumListAdapter.this.a();
                    ArrayList<QQAlbumInfo> arrayList = new ArrayList(a16.size());
                    arrayList.addAll(a16);
                    for (QQAlbumInfo qQAlbumInfo : arrayList) {
                        if (qQAlbumInfo != null && (localMediaInfo = qQAlbumInfo.mCoverInfo) != null) {
                            String c16 = AlbumListAdapter.c(localMediaInfo.path);
                            String str = qQAlbumInfo.name;
                            if (c16 != null && str != null && !str.equals("\u6700\u8fd1\u7167\u7247") && !str.equals("\u7a7a\u95f4\u7167\u7247")) {
                                String lowerCase = c16.toLowerCase(Locale.US);
                                if (lowerCase.contains("/tencent/")) {
                                    NewAlbumListAdapter.q(aVar, lowerCase, qQAlbumInfo);
                                } else {
                                    NewAlbumListAdapter.p(aVar, lowerCase, qQAlbumInfo);
                                }
                            }
                        }
                    }
                    j.n(aVar.f184173a, aVar.f184174b, aVar.f184175c, aVar.f184176d, aVar.f184177e, aVar.f184178f, aVar.f184179g, aVar.f184180h, aVar.f184181i, aVar.f184182j, aVar.f184183k);
                }
            }, 2, null, false);
        }
    }

    public void r(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
            return;
        }
        if (j3 == 0) {
            return;
        }
        this.N = j3;
        QQAlbumInfo qQAlbumInfo = new QQAlbumInfo();
        qQAlbumInfo.f203112id = "qzone_album";
        qQAlbumInfo.name = "\u7a7a\u95f4\u76f8\u518c";
        qQAlbumInfo.mMediaFileCount = (int) this.N;
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 1, "setQzoneAlbumNum " + j3);
        }
        this.P = qQAlbumInfo;
    }
}
