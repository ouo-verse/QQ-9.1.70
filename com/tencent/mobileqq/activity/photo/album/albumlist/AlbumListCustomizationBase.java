package com.tencent.mobileqq.activity.photo.album.albumlist;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.albumlist.b;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.bm;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AlbumListCustomizationBase<O extends OtherCommonData> extends b<O> implements b.InterfaceC7191b {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    protected Activity f184219f;

    /* renamed from: g, reason: collision with root package name */
    protected AlbumListAdapter f184220g;

    /* JADX INFO: Access modifiers changed from: protected */
    public AlbumListCustomizationBase(AbstractAlbumListFragment abstractAlbumListFragment) {
        super(abstractAlbumListFragment);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractAlbumListFragment);
        } else {
            this.f184219f = abstractAlbumListFragment.getActivity();
            this.f184225e = this;
        }
    }

    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        MediaFileFilter mediaFileFilter = this.f184222b.filter;
        boolean z16 = mediaFileFilter.needHeif;
        boolean z17 = mediaFileFilter.needWebp;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("_size>0 and (mime_type='image/jpeg' or mime_type='image/gif' or (mime_type='*/*' and _display_name LIKE'%.jpg%' )  or (mime_type='*/*' and _display_name LIKE'%.jpeg%' )  or (mime_type='*/*' and _display_name LIKE'%.gif%' )  or (mime_type='*/*' and _display_name LIKE'%.bmp%' )  or (mime_type='*/*' and _display_name LIKE'%.png%' )  or mime_type LIKE'%bmp%' or mime_type LIKE'%bitmap%' or mime_type='image/png'");
        if (z16) {
            stringBuffer.append(" or mime_type='image/heif' or mime_type='image/heic'");
        }
        if (z17) {
            stringBuffer.append(" or mime_type='image/webp'");
        }
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

    @Override // com.tencent.mobileqq.activity.photo.album.albumlist.b.InterfaceC7191b
    public void b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        m();
        n();
        if (i3 != -1) {
            if (((Boolean) r(i3).first).booleanValue()) {
                r(-1);
                return;
            }
            return;
        }
        r(-1);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.albumlist.b.InterfaceC7191b
    public List<QQAlbumInfo> c(List<QQAlbumInfo> list, List<QQAlbumInfo> list2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (List) iPatchRedirector.redirect((short) 14, this, list, list2, Integer.valueOf(i3));
        }
        AbstractAlbumListFragment abstractAlbumListFragment = this.f184221a;
        if (abstractAlbumListFragment == null || abstractAlbumListFragment.getActivity() == null) {
            return null;
        }
        if (list == null && list2 == null) {
            list = null;
        } else if (list == null) {
            list = list2;
        } else if (list2 != null) {
            list = q(list, list2);
        }
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            for (int i16 = 0; i16 < size; i16++) {
                QQAlbumInfo qQAlbumInfo = list.get(i16);
                if (i16 != 0 && AlbumListAdapter.e(qQAlbumInfo.name)) {
                    list.remove(qQAlbumInfo);
                    list.add(0, qQAlbumInfo);
                }
            }
        }
        return list;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.albumlist.b
    public void f(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        HashMap<String, LocalMediaInfo> hashMap = (HashMap) intent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
        if (hashMap != null) {
            HashMap<String, LocalMediaInfo> hashMap2 = this.f184222b.selectedMediaInfoHashMap;
            if (hashMap2 != null && !hashMap2.isEmpty()) {
                this.f184222b.selectedMediaInfoHashMap.putAll(hashMap);
            } else {
                this.f184222b.selectedMediaInfoHashMap = hashMap;
            }
        }
        AlbumListAdapter j3 = j();
        this.f184220g = j3;
        this.f184221a.D = j3;
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.activity.photo.album.albumlist.AlbumListCustomizationBase.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AlbumListCustomizationBase.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                bm.a();
                AlbumListCustomizationBase.this.f184225e.b(-1);
                bm.b("QQAlbum", "queryAlbumList");
            }
        });
    }

    @Override // com.tencent.mobileqq.activity.photo.album.albumlist.b
    public boolean g(QQAlbumInfo qQAlbumInfo, int i3, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, qQAlbumInfo, Integer.valueOf(i3), intent)).booleanValue();
        }
        intent.putExtra(QAlbumConstants.ALBUM_ID, qQAlbumInfo.f203112id);
        intent.putExtra(QAlbumConstants.ALBUM_NAME, qQAlbumInfo.name);
        intent.putExtra(QAlbumConstants.ALBUM_ENTER_DIRECTLY, false);
        XListView xListView = this.f184221a.H;
        intent.putExtra(QAlbumConstants.PHOTO_SELECTION_INDEX, xListView.getFirstVisiblePosition());
        View childAt = xListView.getChildAt(0);
        if (childAt != null) {
            i16 = childAt.getTop();
        }
        intent.putExtra(QAlbumConstants.PHOTO_SELECTION_Y, i16);
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "save Scroll Position,index:" + xListView.getFirstVisiblePosition() + " top:" + i16);
        }
        return i(intent, qQAlbumInfo);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00bd, code lost:
    
        if (r9.equals(r1.getURL()) != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i3, View view, ViewGroup viewGroup) {
        TextView textView;
        URLDrawable uRLDrawable;
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), view, viewGroup);
        }
        Resources resources = this.f184221a.getResources();
        AlbumListAdapter l3 = l();
        if (view == null) {
            view = this.f184219f.getLayoutInflater().inflate(R.layout.ar9, (ViewGroup) null);
            textView = (TextView) view;
        } else {
            textView = (TextView) view;
        }
        QQAlbumInfo item = l3.getItem(i3);
        view.setContentDescription(item.name + "\uff0c" + item.mMediaFileCount + "\u5f20\u7167\u7247");
        String str = item.name;
        if (item.mMediaFileCount > 0) {
            str = item.name + String.format(" (%d)", Integer.valueOf(item.mMediaFileCount));
        }
        textView.setText(str);
        Drawable drawable2 = textView.getCompoundDrawables()[0];
        URL k3 = k(i3, l3, item);
        LocalMediaInfo localMediaInfo = item.mCoverInfo;
        localMediaInfo.thumbHeight = 200;
        localMediaInfo.thumbWidth = 200;
        if (drawable2 != null && URLDrawable.class.isInstance(drawable2)) {
            uRLDrawable = (URLDrawable) drawable2;
        }
        uRLDrawable = null;
        if (uRLDrawable == null) {
            ColorDrawable colorDrawable = AlbumListAdapter.H;
            uRLDrawable = URLDrawableHelper.getDrawable(k3, colorDrawable, colorDrawable);
            uRLDrawable.setTag(item.mCoverInfo);
            uRLDrawable.setBounds(0, 0, l3.f184215f, l3.f184216h);
        }
        String str2 = item.f203112id;
        if (str2 != null && str2.equals(this.f184222b.albumId)) {
            drawable = l3.f184217i.newDrawable(resources);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        } else {
            drawable = null;
        }
        textView.setCompoundDrawables(uRLDrawable, null, drawable, null);
        return view;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.albumlist.b
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        }
    }

    public boolean i(Intent intent, QQAlbumInfo qQAlbumInfo) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent, (Object) qQAlbumInfo)).booleanValue();
        }
        String stringExtra = intent.getStringExtra(QAlbumConstants.ALBUM_NAME);
        String stringExtra2 = intent.getStringExtra(QAlbumConstants.ALBUM_ID);
        if ((stringExtra != null && !stringExtra.equals(this.f184222b.albumName)) || (stringExtra2 != null && !stringExtra2.equals(this.f184222b.albumId))) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!o(z16, qQAlbumInfo)) {
            return false;
        }
        PhotoCommonBaseData<O> photoCommonBaseData = this.f184222b;
        photoCommonBaseData.albumName = stringExtra;
        photoCommonBaseData.albumId = stringExtra2;
        return true;
    }

    protected AlbumListAdapter j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (AlbumListAdapter) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return new AlbumListAdapter(this.f184221a);
    }

    public URL k(int i3, AlbumListAdapter albumListAdapter, QQAlbumInfo qQAlbumInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (URL) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), albumListAdapter, qQAlbumInfo);
        }
        if (albumListAdapter.getItemViewType(i3) == 1) {
            LocalMediaInfo localMediaInfo = qQAlbumInfo.mCoverInfo;
            if (localMediaInfo.isSystemMeidaStore) {
                return QAlbumUtil.generateAlbumThumbURL(localMediaInfo, "VIDEO");
            }
            return QAlbumUtil.generateAlbumThumbURL(localMediaInfo, "APP_VIDEO");
        }
        return QAlbumUtil.generateAlbumThumbURL(qQAlbumInfo.mCoverInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AlbumListAdapter l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (AlbumListAdapter) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.f184220g;
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        QQAlbumInfo qQAlbumInfo = new QQAlbumInfo();
        qQAlbumInfo.f203112id = QAlbumCustomAlbumConstants.RECENT_ALBUM_ID;
        qQAlbumInfo.name = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
        PhotoCommonBaseData<O> photoCommonBaseData = this.f184222b;
        LocalMediaInfo localMediaInfo = photoCommonBaseData.firstRecentInfo;
        if (localMediaInfo != null) {
            qQAlbumInfo.mMediaFileCount = photoCommonBaseData.recentCount;
            qQAlbumInfo.mCoverInfo = localMediaInfo;
            qQAlbumInfo.coverDate = localMediaInfo.modifiedDate;
        } else {
            qQAlbumInfo = l().i(this.f184221a, qQAlbumInfo, true, true, true);
            PhotoCommonBaseData<O> photoCommonBaseData2 = this.f184222b;
            photoCommonBaseData2.recentCount = qQAlbumInfo.mMediaFileCount;
            photoCommonBaseData2.firstRecentInfo = qQAlbumInfo.mCoverInfo;
        }
        this.f184220g.m(qQAlbumInfo);
    }

    public QQAlbumInfo n() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (QQAlbumInfo) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        QQAlbumInfo qQAlbumInfo = new QQAlbumInfo();
        qQAlbumInfo.f203112id = QAlbumCustomAlbumConstants.VIDEO_ALBUM_ID;
        qQAlbumInfo.name = QAlbumCustomAlbumConstants.VIDEO_ALBUM_NAME;
        this.f184220g.n(qQAlbumInfo);
        if (this.f184222b.videoCount < 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        QQAlbumInfo i3 = l().i(this.f184221a, qQAlbumInfo, false, true, z16);
        if (!z16) {
            i3.mMediaFileCount = this.f184222b.videoCount;
        }
        this.f184222b.firstVideoInfo = i3.mCoverInfo;
        this.f184220g.n(i3);
        bm.b("QQAlbum", "compact.LocalVideoAlbumInfo");
        return i3;
    }

    public boolean o(boolean z16, QQAlbumInfo qQAlbumInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), qQAlbumInfo)).booleanValue();
        }
        return z16;
    }

    public Pair<Boolean, List<QQAlbumInfo>> p(int i3) {
        List<QQAlbumInfo> list;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Pair) iPatchRedirector.redirect((short) 11, (Object) this, i3);
        }
        AlbumListAdapter l3 = l();
        MediaFileFilter mediaFileFilter = this.f184222b.filter;
        List<QQAlbumInfo> list2 = null;
        int i16 = 0;
        if (mediaFileFilter != null && mediaFileFilter.showImage()) {
            bm.a();
            list = l3.h(this.f184219f, i3);
            if (i3 != -1 && list != null && list.size() == i3) {
                z16 = true;
            } else {
                z16 = false;
            }
            bm.b("QQAlbum", "queryImageBuckets");
        } else {
            list = null;
            z16 = false;
        }
        if (mediaFileFilter != null && mediaFileFilter.showVideo()) {
            bm.a();
            list2 = l3.j(this.f184219f, i3, mediaFileFilter);
            if (i3 != -1 && list2 != null && list2.size() == i3) {
                z16 = true;
            }
            bm.b("QQAlbum", "queryVideoBuckets");
        }
        bm.a();
        List<QQAlbumInfo> c16 = this.f184225e.c(list, list2, i3);
        if (c16 != null) {
            for (int i17 = 1; i17 < c16.size(); i17++) {
                i16 += c16.get(i17).mMediaFileCount;
            }
            bm.b("QQAlbum", "compact(" + (c16.size() - 1) + "," + i16 + ")");
        } else {
            bm.b("QQAlbum", "compact: medias ==null");
        }
        return new Pair<>(Boolean.valueOf(z16), c16);
    }

    public List<QQAlbumInfo> q(List<QQAlbumInfo> list, List<QQAlbumInfo> list2) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (List) iPatchRedirector.redirect((short) 15, (Object) this, (Object) list, (Object) list2);
        }
        for (QQAlbumInfo qQAlbumInfo : list2) {
            Iterator<QQAlbumInfo> it = list.iterator();
            while (true) {
                z16 = true;
                if (it.hasNext()) {
                    QQAlbumInfo next = it.next();
                    if (next.f203112id.equals(qQAlbumInfo.f203112id)) {
                        next.mMediaFileCount += qQAlbumInfo.mMediaFileCount;
                        z17 = true;
                        break;
                    }
                } else {
                    z17 = false;
                    break;
                }
            }
            if (!z17) {
                Iterator<QQAlbumInfo> it5 = list.iterator();
                int i3 = 0;
                while (true) {
                    if (it5.hasNext()) {
                        if (qQAlbumInfo.coverDate > it5.next().coverDate) {
                            list.add(i3, qQAlbumInfo);
                            break;
                        }
                        i3++;
                    } else {
                        z16 = false;
                        break;
                    }
                }
                if (!z16) {
                    list.add(qQAlbumInfo);
                }
            }
        }
        return list;
    }

    public Pair<Boolean, List<QQAlbumInfo>> r(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Pair) iPatchRedirector.redirect((short) 10, (Object) this, i3);
        }
        AlbumListAdapter l3 = l();
        bm.a();
        Pair<Boolean, List<QQAlbumInfo>> p16 = p(i3);
        List<QQAlbumInfo> list = (List) p16.second;
        bm.b("QQAlbum", "queryAllAlbumList");
        l3.l(list);
        l3.g();
        return p16;
    }
}
