package com.tencent.aelight.camera.ae.album.logic;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.album.adapter.AEAlbumListAdapter;
import com.tencent.aelight.camera.ae.album.fragment.AEAbstractAlbumListFragment;
import com.tencent.aelight.camera.ae.album.logic.a;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumBaseUtil;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.bm;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEAlbumListLogicBase<K extends AEAbstractAlbumListFragment> extends a<K> implements a.InterfaceC0532a {

    /* renamed from: f, reason: collision with root package name */
    protected AEAlbumListAdapter f62069f;

    /* JADX INFO: Access modifiers changed from: protected */
    public AEAlbumListLogicBase(K k3) {
        super(k3);
        this.f62118d = this;
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.a.InterfaceC0532a
    public String a() {
        MediaFileFilter mediaFileFilter = this.f62116b.filter;
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

    @Override // com.tencent.aelight.camera.ae.album.logic.a.InterfaceC0532a
    public void b(int i3) {
        boolean z16;
        List<QQAlbumInfo> list;
        final AEAlbumListAdapter k3 = k();
        final MediaFileFilter mediaFileFilter = this.f62116b.filter;
        int i16 = 0;
        List<QQAlbumInfo> list2 = null;
        if (mediaFileFilter == null || !mediaFileFilter.showImage()) {
            z16 = false;
            list = null;
        } else {
            bm.a();
            list = k3.l(this.f62115a.get().getActivity(), i3);
            z16 = (i3 == -1 || list == null || list.size() != i3) ? false : true;
            bm.b("PEAK", "queryImageBuckets");
        }
        if (mediaFileFilter != null && mediaFileFilter.showVideo()) {
            bm.a();
            list2 = k3.p(this.f62115a.get().getActivity(), i3, mediaFileFilter);
            if (i3 != -1 && list2 != null && list2.size() == i3) {
                z16 = true;
            }
            bm.b("PEAK", "queryVideoBuckets");
        }
        bm.a();
        List<QQAlbumInfo> c16 = this.f62118d.c(list, list2, i3);
        if (c16 != null) {
            for (int i17 = 1; i17 < c16.size(); i17++) {
                i16 += c16.get(i17).mMediaFileCount;
            }
            bm.b("PEAK", "compact(" + (c16.size() - 1) + "," + i16 + ")");
            k3.g(c16);
            if (i3 != -1) {
                if (z16) {
                    ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.album.logic.AEAlbumListLogicBase.2
                        @Override // java.lang.Runnable
                        public void run() {
                            bm.a();
                            k3.j();
                            bm.b("PEAK", "queryAllAlbumList");
                        }
                    });
                    return;
                } else {
                    ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.album.logic.AEAlbumListLogicBase.3
                        @Override // java.lang.Runnable
                        public void run() {
                            bm.a();
                            k3.h(k3.n(AEAlbumListLogicBase.this.f62115a.get().getActivity(), Integer.MAX_VALUE, -1, mediaFileFilter, -1, false, null));
                            bm.b("PEAK", "queryRecentBucket");
                            bm.a();
                            MediaFileFilter mediaFileFilter2 = mediaFileFilter;
                            if (mediaFileFilter2 != null && mediaFileFilter2.showVideo()) {
                                QQAlbumInfo k16 = k3.k(AEAlbumListLogicBase.this.f62115a.get().getActivity());
                                k3.i(k16);
                                if (QLog.isColorLevel()) {
                                    QLog.d("QQAlbum", 2, "queryAlbumList() run postVideoAlbum()\uff0c videoAlbumInfo.count=" + k16.mMediaFileCount);
                                }
                            }
                            bm.b("PEAK", "queryVideoBucket");
                        }
                    });
                    return;
                }
            }
            return;
        }
        bm.b("PEAK", "compact: medias ==null");
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x013b, code lost:
    
        if ((r1 != null ? r1.getMediaScannerInfosCount() : 0) > 0) goto L62;
     */
    @Override // com.tencent.aelight.camera.ae.album.logic.a.InterfaceC0532a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<QQAlbumInfo> c(List<QQAlbumInfo> list, List<QQAlbumInfo> list2, int i3) {
        boolean z16;
        boolean z17;
        QQAlbumInfo qQAlbumInfo;
        int i16;
        QQAlbumInfo qQAlbumInfo2;
        if (this.f62115a.get() == null || this.f62115a.get().getActivity() == null) {
            return null;
        }
        boolean z18 = false;
        if (list == null && list2 == null) {
            list = null;
        } else if (list == null) {
            list = list2;
        } else if (list2 != null) {
            for (QQAlbumInfo qQAlbumInfo3 : list2) {
                Iterator<QQAlbumInfo> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z16 = false;
                        break;
                    }
                    QQAlbumInfo next = it.next();
                    if (next.f203112id.equals(qQAlbumInfo3.f203112id)) {
                        next.mMediaFileCount += qQAlbumInfo3.mMediaFileCount;
                        z16 = true;
                        break;
                    }
                }
                if (!z16) {
                    Iterator<QQAlbumInfo> it5 = list.iterator();
                    int i17 = 0;
                    while (true) {
                        if (!it5.hasNext()) {
                            z17 = false;
                            break;
                        }
                        if (qQAlbumInfo3.coverDate > it5.next().coverDate) {
                            list.add(i17, qQAlbumInfo3);
                            z17 = true;
                            break;
                        }
                        i17++;
                    }
                    if (!z17) {
                        list.add(qQAlbumInfo3);
                    }
                }
            }
        }
        bm.a();
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            for (int i18 = 0; i18 < size; i18++) {
                QQAlbumInfo qQAlbumInfo4 = list.get(i18);
                if (i18 != 0 && AEAlbumListAdapter.f(qQAlbumInfo4.name)) {
                    list.remove(qQAlbumInfo4);
                    list.add(0, qQAlbumInfo4);
                }
            }
            if (i3 == -1) {
                qQAlbumInfo = k().n(this.f62115a.get().getActivity(), 210, -1, this.f62116b.filter, -1, false, null);
            } else {
                qQAlbumInfo = new QQAlbumInfo();
                qQAlbumInfo.f203112id = QAlbumCustomAlbumConstants.RECENT_ALBUM_ID;
                qQAlbumInfo.name = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
                qQAlbumInfo.mCoverInfo = new LocalMediaInfo();
            }
            list.add(0, qQAlbumInfo);
            MediaFileFilter mediaFileFilter = this.f62116b.filter;
            if (mediaFileFilter != null && mediaFileFilter.showVideo()) {
                Cursor query = ContactsMonitor.query(this.f62115a.get().getActivity().getContentResolver(), MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_size>0 ", null, null);
                if (query != null) {
                    i16 = query.getCount();
                    query.close();
                } else {
                    i16 = 0;
                }
                if (i16 <= 0) {
                    MediaScanner mediaScanner = MediaScanner.getInstance(BaseApplication.getContext());
                }
                z18 = true;
                k().f62008i = z18;
                if (z18) {
                    if (i3 == -1) {
                        qQAlbumInfo2 = k().k(this.f62115a.get().getActivity());
                    } else {
                        qQAlbumInfo2 = new QQAlbumInfo();
                        qQAlbumInfo2.f203112id = QAlbumCustomAlbumConstants.VIDEO_ALBUM_ID;
                        qQAlbumInfo2.name = QAlbumCustomAlbumConstants.VIDEO_ALBUM_NAME;
                        qQAlbumInfo2.mCoverInfo = new LocalMediaInfo();
                    }
                    list.add(1, qQAlbumInfo2);
                }
            }
        }
        bm.b("PEAK", "compact.queryRecentBucket");
        return list;
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.a
    public void f(Intent intent) {
        HashMap<String, LocalMediaInfo> hashMap = (HashMap) intent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
        if (hashMap != null) {
            HashMap<String, LocalMediaInfo> hashMap2 = this.f62116b.selectedMediaInfoHashMap;
            if (hashMap2 != null && !hashMap2.isEmpty()) {
                this.f62116b.selectedMediaInfoHashMap.putAll(hashMap);
            } else {
                this.f62116b.selectedMediaInfoHashMap = hashMap;
            }
        }
        this.f62116b.albumId = intent.getStringExtra(QAlbumConstants.ALBUM_ID);
        this.f62116b.albumName = intent.getStringExtra(QAlbumConstants.ALBUM_NAME);
        PhotoCommonBaseData photoCommonBaseData = this.f62116b;
        if (photoCommonBaseData.albumId == null) {
            photoCommonBaseData.albumId = QAlbumCustomAlbumConstants.RECENT_ALBUM_ID;
            photoCommonBaseData.albumName = null;
        } else {
            ms.a.f("AEAlbumListLogicBase", "passed in albumId=" + this.f62116b.albumId + ", albumName=" + this.f62116b.albumName);
        }
        this.f62116b.showMediaType = intent.getIntExtra(QAlbumConstants.PHOTOLIST_KEY_SHOW_MEDIA, 1);
        PhotoCommonBaseData photoCommonBaseData2 = this.f62116b;
        photoCommonBaseData2.filter = MediaFileFilter.getFilter(photoCommonBaseData2.showMediaType);
        this.f62069f = j();
        this.f62115a.get().f62017i = this.f62069f;
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.album.logic.AEAlbumListLogicBase.1
            @Override // java.lang.Runnable
            public void run() {
                bm.a();
                AEAlbumListLogicBase.this.f62118d.b(100);
                bm.b("PEAK", "queryAlbumList");
            }
        });
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.a
    public boolean g(QQAlbumInfo qQAlbumInfo, int i3, Intent intent) {
        intent.putExtra(QAlbumConstants.ALBUM_ID, qQAlbumInfo.f203112id);
        intent.putExtra(QAlbumConstants.ALBUM_NAME, qQAlbumInfo.name);
        intent.putExtra(QAlbumConstants.ALBUM_ENTER_DIRECTLY, false);
        XListView xListView = this.f62115a.get().f62018m;
        intent.putExtra(QAlbumConstants.PHOTO_SELECTION_INDEX, xListView.getFirstVisiblePosition());
        View childAt = xListView.getChildAt(0);
        int top = childAt != null ? childAt.getTop() : 0;
        intent.putExtra(QAlbumConstants.PHOTO_SELECTION_Y, top);
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "save Scroll Position,index:" + xListView.getFirstVisiblePosition() + " top:" + top);
        }
        return i(intent, qQAlbumInfo);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00c8, code lost:
    
        if (r10.equals(r4.getURL()) != false) goto L24;
     */
    @Override // com.tencent.aelight.camera.ae.album.logic.a.InterfaceC0532a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View getView(int i3, View view, ViewGroup viewGroup) {
        TextView textView;
        URL generateAlbumThumbURL;
        URLDrawable uRLDrawable;
        Drawable drawable;
        Resources resources = this.f62115a.get().getResources();
        AEAlbumListAdapter k3 = k();
        if (view == null) {
            view = this.f62115a.get().getActivity().getLayoutInflater().inflate(R.layout.ar9, (ViewGroup) null);
            textView = (TextView) view;
        } else {
            textView = (TextView) view;
        }
        QQAlbumInfo item = k3.getItem(i3);
        view.setContentDescription(item.name + "\uff0c" + item.mMediaFileCount + "\u5f20\u7167\u7247");
        String str = item.name;
        if (item.mMediaFileCount > 0) {
            str = item.name + String.format(" (%d)", Integer.valueOf(item.mMediaFileCount));
        }
        textView.setText(str);
        Drawable drawable2 = textView.getCompoundDrawables()[0];
        if (k3.getItemViewType(i3) == 1) {
            LocalMediaInfo localMediaInfo = item.mCoverInfo;
            if (localMediaInfo.isSystemMeidaStore) {
                generateAlbumThumbURL = QAlbumUtil.generateAlbumThumbURL(localMediaInfo, "VIDEO");
            } else {
                generateAlbumThumbURL = QAlbumUtil.generateAlbumThumbURL(localMediaInfo, "APP_VIDEO");
            }
        } else {
            generateAlbumThumbURL = QAlbumUtil.generateAlbumThumbURL(item.mCoverInfo);
        }
        LocalMediaInfo localMediaInfo2 = item.mCoverInfo;
        localMediaInfo2.thumbHeight = 200;
        localMediaInfo2.thumbWidth = 200;
        if (drawable2 != null && URLDrawable.class.isInstance(drawable2)) {
            uRLDrawable = (URLDrawable) drawable2;
        }
        uRLDrawable = null;
        if (uRLDrawable == null) {
            ColorDrawable colorDrawable = AEAlbumListAdapter.F;
            uRLDrawable = URLDrawableHelper.getDrawable(generateAlbumThumbURL, colorDrawable, colorDrawable);
            uRLDrawable.setTag(item.mCoverInfo);
            uRLDrawable.setBounds(0, 0, k3.f62006f, k3.f62007h);
        }
        String str2 = item.f203112id;
        if (str2 == null || !str2.equals(this.f62116b.albumId)) {
            drawable = null;
        } else {
            drawable = k3.C.newDrawable(resources);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        textView.setCompoundDrawables(uRLDrawable, null, drawable, null);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i(Intent intent, QQAlbumInfo qQAlbumInfo) {
        String stringExtra = intent.getStringExtra(QAlbumConstants.ALBUM_NAME);
        String stringExtra2 = intent.getStringExtra(QAlbumConstants.ALBUM_ID);
        if (!l(((stringExtra == null || stringExtra.equals(this.f62116b.albumName)) && (stringExtra2 == null || stringExtra2.equals(this.f62116b.albumId))) ? false : true, qQAlbumInfo)) {
            return false;
        }
        PhotoCommonBaseData photoCommonBaseData = this.f62116b;
        photoCommonBaseData.albumName = stringExtra;
        photoCommonBaseData.albumId = stringExtra2;
        return true;
    }

    protected AEAlbumListAdapter j() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AEAlbumListAdapter k() {
        return this.f62069f;
    }

    boolean l(boolean z16, QQAlbumInfo qQAlbumInfo) {
        throw null;
    }

    @Override // com.tencent.aelight.camera.ae.album.logic.a.InterfaceC0532a
    public List<LocalMediaInfo> d(Context context, int i3, int i16, MediaFileFilter mediaFileFilter, int i17, boolean z16, ArrayList<String> arrayList) {
        return QAlbumBaseUtil.queryRecentImages(context, i17, i16, mediaFileFilter, z16, i3, arrayList, false);
    }
}
