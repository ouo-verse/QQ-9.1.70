package com.tencent.biz.qqstory.takevideo.slideshow;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import com.tencent.aelight.camera.qqstory.api.IAELaunchMusicConfigManager;
import com.tencent.aelight.camera.qqstory.api.IQQStoryFlowManager;
import com.tencent.aelight.camera.qqstory.api.IQimMusicPlayer;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.takevideo.slideshow.core.SlideShowProcessor;
import com.tencent.biz.qqstory.takevideo.slideshow.core.VideoMerger;
import com.tencent.biz.qqstory.takevideo.slideshow.f;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.light.LightConstants;

/* loaded from: classes5.dex */
public class SlideShowPhotoListManager implements SlideShowProcessor.d, VideoMerger.b {

    /* renamed from: n, reason: collision with root package name */
    private static SlideShowPhotoListManager f94312n;

    /* renamed from: e, reason: collision with root package name */
    private int f94317e;

    /* renamed from: g, reason: collision with root package name */
    protected SlideShowProcessor f94319g;

    /* renamed from: i, reason: collision with root package name */
    private i f94321i;

    /* renamed from: j, reason: collision with root package name */
    long f94322j;

    /* renamed from: l, reason: collision with root package name */
    protected b f94324l;

    /* renamed from: a, reason: collision with root package name */
    private int f94313a = 20999;

    /* renamed from: b, reason: collision with root package name */
    private List<SlideItemInfo> f94314b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    private List<LocalMediaInfo> f94315c = new CopyOnWriteArrayList();

    /* renamed from: d, reason: collision with root package name */
    private List<SlideItemInfo> f94316d = new CopyOnWriteArrayList();

    /* renamed from: f, reason: collision with root package name */
    private int f94318f = 21;

    /* renamed from: k, reason: collision with root package name */
    protected List<WeakReference<Activity>> f94323k = new CopyOnWriteArrayList();

    /* renamed from: m, reason: collision with root package name */
    qs.e f94325m = new a();

    /* renamed from: h, reason: collision with root package name */
    protected Handler f94320h = new Handler(Looper.getMainLooper());

    /* loaded from: classes5.dex */
    public interface b {
        void a();
    }

    public SlideShowPhotoListManager() {
        SlideShowProcessor slideShowProcessor = new SlideShowProcessor();
        this.f94319g = slideShowProcessor;
        slideShowProcessor.f();
        if (QLog.isColorLevel()) {
            QLog.e("SlideShowPhotoListManager", 2, "SlideShowPhotoListManager create, ", new Exception());
        }
    }

    private void d(final Context context, final String str) {
        Handler handler = this.f94320h;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager.2
            @Override // java.lang.Runnable
            public void run() {
                QQToast.makeText(context, str, 0).show();
            }
        });
    }

    private void g(List<SlideItemInfo> list) {
        long j3 = 0;
        if (list != null) {
            if (QLog.isColorLevel()) {
                QLog.d("SlideShowPhotoListManager", 2, "convertToVideo size : " + list.size());
            }
            for (SlideItemInfo slideItemInfo : list) {
                if (slideItemInfo != null) {
                    j3 += slideItemInfo.a();
                }
            }
        }
        if (j3 > this.f94313a && n().m() != 22) {
            if (QLog.isColorLevel()) {
                QLog.d("SlideShowPhotoListManager", 2, "Duration too max: convertToVideo totalDuration=" + j3);
                return;
            }
            return;
        }
        if (list != null) {
            h(list);
        } else if (QLog.isColorLevel()) {
            QLog.d("SlideShowPhotoListManager", 2, "newInfoList is null");
        }
    }

    private void h(@NonNull List<SlideItemInfo> list) {
        if (this.f94319g != null) {
            TransitionHandler transitionHandler = (TransitionHandler) QQStoryContext.a().getBusinessHandler(PeakAppInterface.H);
            for (SlideItemInfo slideItemInfo : list) {
                if (slideItemInfo != null && !TextUtils.isEmpty(slideItemInfo.f94291i)) {
                    if (QLog.isColorLevel()) {
                        QLog.i("SlideShowPhotoListManager", 2, "convertToVideo path = " + slideItemInfo.f94291i);
                    }
                    long a16 = slideItemInfo.a();
                    if (a16 > this.f94313a - 2000) {
                        if (QLog.isColorLevel()) {
                            QLog.d("SlideShowPhotoListManager", 2, "Duration too max: convertToVideoInternal durationValid=" + a16);
                        }
                        slideItemInfo.N = false;
                    } else {
                        boolean z16 = slideItemInfo.N;
                        slideItemInfo.N = false;
                        if (!transitionHandler.F2(slideItemInfo.f94291i)) {
                            if (!this.f94319g.e(slideItemInfo.f94291i)) {
                                this.f94319g.b(slideItemInfo, this);
                            } else {
                                if (QLog.isColorLevel()) {
                                    QLog.i("SlideShowPhotoListManager", 2, "[hasAlreadyRunning=true]convertToVideo path = " + slideItemInfo.f94291i);
                                }
                                if (z16 && slideItemInfo.f94290h == 1) {
                                    this.f94319g.i(slideItemInfo.f94291i);
                                    LocalMediaInfo D2 = transitionHandler.D2(slideItemInfo.f94291i);
                                    if (D2 != null) {
                                        q.d(D2.path);
                                        transitionHandler.G2(slideItemInfo.f94291i);
                                    }
                                    this.f94319g.b(slideItemInfo, this);
                                }
                            }
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.i("SlideShowPhotoListManager", 2, "[hasCachedMediaInfo=true]convertToVideo path = " + slideItemInfo.f94291i);
                            }
                            if (z16 && slideItemInfo.f94290h == 1) {
                                LocalMediaInfo D22 = transitionHandler.D2(slideItemInfo.f94291i);
                                if (D22 != null) {
                                    q.d(D22.path);
                                }
                                transitionHandler.G2(slideItemInfo.f94291i);
                                this.f94319g.b(slideItemInfo, this);
                            }
                        }
                    }
                } else if (slideItemInfo != null) {
                    slideItemInfo.N = false;
                }
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("SlideShowPhotoListManager", 2, "combine video mConvertProcessor is null");
        }
    }

    private void j(Activity activity, List<String> list, b bVar, int i3) {
        int i16;
        String str;
        SlideItemInfo slideItemInfo;
        SlideItemInfo slideItemInfo2 = o().get(0);
        if (slideItemInfo2.f94290h == 0) {
            this.f94324l = bVar;
            int i17 = this.f94317e;
            if ((i17 == 13 || i17 == 11 || i17 == 12 || this.f94318f == 22) && ((activity instanceof NewPhotoListActivity) || (activity instanceof NewPhotoPreviewActivity))) {
                z();
            }
            i iVar = this.f94321i;
            if (iVar != null) {
                iVar.h();
            }
            if (this.f94314b.size() > 0 && (slideItemInfo = this.f94314b.get(0)) != null) {
                int i18 = slideItemInfo.f94288e;
                str = slideItemInfo.f94289f;
                i16 = i18;
            } else {
                i16 = -1;
                str = "";
            }
            this.f94319g.c(this.f94314b, this, activity, this.f94320h, i3, i16, str);
            return;
        }
        ((IQQStoryFlowManager) QRoute.api(IQQStoryFlowManager.class)).startEditVideoActivity(activity, slideItemInfo2.f94291i, slideItemInfo2.f94287d, (int) slideItemInfo2.D, (int) slideItemInfo2.E, 120, 10023, 0, "", "", false, 11, 14, null);
    }

    public static SlideShowPhotoListManager n() {
        if (f94312n == null) {
            f94312n = new SlideShowPhotoListManager();
        }
        return f94312n;
    }

    private boolean r(Activity activity) {
        if (activity == null || activity.getIntent() == null || activity.getIntent().getIntExtra("edit_video_type", 10002) != 10023) {
            return false;
        }
        return true;
    }

    private boolean x(List<SlideItemInfo> list, List<SlideItemInfo> list2) {
        if (list != list2 && list != null && list2 != null) {
            if (list.size() != list2.size()) {
                return true;
            }
            HashSet hashSet = new HashSet();
            Iterator<SlideItemInfo> it = list.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next().f94291i);
            }
            if (hashSet.size() != list2.size()) {
                return true;
            }
            Iterator<SlideItemInfo> it5 = list2.iterator();
            while (it5.hasNext()) {
                if (!hashSet.contains(it5.next().f94291i)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void y(Context context, List<SlideItemInfo> list) {
        List<f.a> b16;
        MusicItemInfo musicItemById;
        if (list != null && list.size() > 0 && list.get(0) != null && (b16 = f.a(context).b(list.get(0).M)) != null && b16.size() > 0 && (musicItemById = ((IAELaunchMusicConfigManager) QRoute.api(IAELaunchMusicConfigManager.class)).getMusicItemById(b16.get(0).f94400a, b16.get(0).f94401b)) != null && !((IQimMusicPlayer) QRoute.api(IQimMusicPlayer.class)).checkMusicCanPlay(musicItemById)) {
            ((IQimMusicPlayer) QRoute.api(IQimMusicPlayer.class)).requestDownLoadMusicInfo(musicItemById, this.f94325m);
            if (QLog.isColorLevel()) {
                QLog.d("SlideShowPhotoListManager", 2, "SlideShowPhotoListManager preloadMusic mItemId=" + musicItemById.mItemId);
            }
        }
    }

    public void A(int i3) {
        this.f94317e = i3;
    }

    public void B(int i3) {
        this.f94318f = i3;
    }

    public void C(List<SlideItemInfo> list) {
        this.f94314b.clear();
        this.f94314b.addAll(list);
    }

    public void D(List<SlideItemInfo> list) {
        this.f94316d.clear();
        this.f94316d.addAll(list);
    }

    public void E(int i3) {
        this.f94313a = i3;
    }

    public void F(i iVar) {
        this.f94321i = iVar;
    }

    public void G() {
        SlideShowProcessor slideShowProcessor = this.f94319g;
        if (slideShowProcessor != null) {
            slideShowProcessor.h();
        }
        i iVar = this.f94321i;
        if (iVar != null) {
            iVar.d();
        }
    }

    public void H() {
        G();
        TransitionHandler transitionHandler = (TransitionHandler) QQStoryContext.a().getBusinessHandler(PeakAppInterface.H);
        if (transitionHandler != null) {
            transitionHandler.clear();
        }
        this.f94314b.clear();
        this.f94315c.clear();
        SlideShowProcessor.d();
    }

    @Override // com.tencent.biz.qqstory.takevideo.slideshow.core.VideoMerger.b
    public void a() {
        i iVar = this.f94321i;
        if (iVar != null) {
            iVar.d();
        }
        b bVar = this.f94324l;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // com.tencent.biz.qqstory.takevideo.slideshow.core.VideoMerger.b
    public void b(boolean z16) {
        i iVar = this.f94321i;
        if (iVar != null) {
            iVar.c();
        }
    }

    @Override // com.tencent.biz.qqstory.takevideo.slideshow.core.SlideShowProcessor.d
    public void c(d dVar) {
        AppInterface a16 = QQStoryContext.a();
        int i3 = dVar.f94392b;
        if (i3 == 0) {
            String str = dVar.f94393c;
            LocalMediaInfo localMediaInfo = new LocalMediaInfo();
            localMediaInfo.path = dVar.f94394d;
            localMediaInfo.mMimeType = "video";
            localMediaInfo.mAudioPath = dVar.f94396f;
            localMediaInfo.mHasAudioTrack = dVar.f94397g;
            localMediaInfo.mSampleRate = dVar.f94398h;
            try {
                MediaScanner.getInstance(BaseApplication.getContext()).buildAndUpdateVideo(localMediaInfo);
            } catch (Throwable th5) {
                th5.printStackTrace();
                QLog.e("SlideShowPhotoListManager", 1, "pic2video err", th5);
            }
            TransitionHandler transitionHandler = (TransitionHandler) a16.getBusinessHandler(PeakAppInterface.H);
            transitionHandler.H2(str, localMediaInfo);
            if (transitionHandler.E2() == null) {
                transitionHandler.I2(dVar.f94395e);
            }
            if (QLog.isColorLevel()) {
                QLog.e("SlideShowPhotoListManager", 2, "onImage2VideoResult RESULT_SUCC  hasAudioTrack:" + localMediaInfo.mHasAudioTrack);
            }
        } else if (i3 == 2) {
            if (QLog.isColorLevel()) {
                QLog.i("SlideShowPhotoListManager", 2, "onImage2VideoResult cancel" + dVar);
            }
            id0.a.i("actAlbumResult", dVar.f94392b + "");
        } else if (i3 == 5) {
            if (QLog.isColorLevel()) {
                QLog.e("SlideShowPhotoListManager", 2, "onImage2VideoResult fail load");
            }
            id0.a.i("actAlbumResult", dVar.f94392b + "");
            d(a16.getApp(), HardCodeUtil.qqStr(R.string.f172724tl3));
        } else if (i3 == 8) {
            if (QLog.isColorLevel()) {
                QLog.d("SlideShowPhotoListManager", 2, "result audio fail");
            }
            id0.a.i("actAlbumResult", dVar.f94392b + "");
            d(a16.getApp(), HardCodeUtil.qqStr(R.string.f172723tl2));
            SlideShowProcessor slideShowProcessor = this.f94319g;
            if (slideShowProcessor != null) {
                slideShowProcessor.h();
            }
            i iVar = this.f94321i;
            if (iVar != null) {
                iVar.d();
            }
        } else {
            id0.a.i("actAlbumResult", dVar.f94392b + "");
        }
        if (QLog.isColorLevel()) {
            QLog.e("SlideShowPhotoListManager", 2, "onImage2VideoResult " + dVar);
        }
    }

    public void e(Activity activity) {
        this.f94323k.add(new WeakReference<>(activity));
    }

    protected void f() {
        boolean z16;
        TransitionHandler transitionHandler = (TransitionHandler) QQStoryContext.a().getBusinessHandler(PeakAppInterface.H);
        Iterator<SlideItemInfo> it = this.f94314b.iterator();
        while (true) {
            if (it.hasNext()) {
                SlideItemInfo next = it.next();
                if (next != null && transitionHandler.D2(next.f94291i) == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("SlideShowPhotoListManager", 2, "checkIsNeedRetrySendConvert allFinish=false picInfo.mPath =" + next.f94291i);
                    }
                    z16 = false;
                }
            } else {
                z16 = true;
                break;
            }
        }
        if (!z16) {
            if (QLog.isColorLevel()) {
                QLog.d("SlideShowPhotoListManager", 2, "checkIsNeedRetrySendConvert allFinish=false send convert request...");
            }
            g(this.f94314b);
        }
    }

    public void i(Activity activity, b bVar, int i3) {
        int i16;
        String str;
        SlideItemInfo slideItemInfo;
        int i17;
        String str2;
        int i18;
        String str3;
        String str4;
        Bundle bundle;
        int i19;
        boolean z16;
        int i26;
        List<String> b16 = h.b(o());
        if (activity != null && b16 != null && !b16.isEmpty()) {
            boolean z17 = activity instanceof NewPhotoListActivity;
            if (r(activity)) {
                j(activity, b16, bVar, i3);
                return;
            }
            if (b16.size() == 1 && this.f94318f != 22) {
                SlideItemInfo slideItemInfo2 = o().get(0);
                this.f94319g.i(slideItemInfo2.f94291i);
                if (activity.getIntent() != null) {
                    i18 = activity.getIntent().getIntExtra("entrance_type", 99);
                } else {
                    i18 = 99;
                }
                int i27 = slideItemInfo2.f94290h;
                if (i27 == 0) {
                    Intent startEditPic = ((IAELaunchEditPic) QRoute.api(IAELaunchEditPic.class)).startEditPic(activity, slideItemInfo2.f94291i, true, true, true, true, true, false, false, false, 2, i18, 0, false, null);
                    startEditPic.putExtra(ShortVideoConstants.MEDIA_INFO, (Parcelable) slideItemInfo2.f94287d);
                    startEditPic.putExtra("extra_edit_video_from", 2);
                    activity.startActivityForResult(startEditPic, 10002);
                    id0.a.n("video_edit", "edit_local", 0, 0, (!z17 ? 1 : 0) + "");
                    return;
                }
                if (i27 == 1) {
                    id0.a.n("video_edit", "edit_local", 0, 1, (!z17 ? 1 : 0) + "");
                    Intent intent = activity.getIntent();
                    if (intent != null) {
                        int intExtra = intent.getIntExtra("shareGroupType", 0);
                        String stringExtra = intent.getStringExtra("shareGroupId");
                        String stringExtra2 = intent.getStringExtra("shareGroupName");
                        boolean booleanExtra = intent.getBooleanExtra("ignorePersonalPublish", false);
                        intent.putExtra("extra_edit_video_from", 3);
                        bundle = intent.getBundleExtra("state");
                        i19 = intExtra;
                        str3 = stringExtra;
                        str4 = stringExtra2;
                        z16 = booleanExtra;
                    } else {
                        str3 = null;
                        str4 = null;
                        bundle = null;
                        i19 = 0;
                        z16 = false;
                    }
                    if (n().m() == 22) {
                        i26 = 10001;
                    } else {
                        i26 = 10002;
                    }
                    ((IQQStoryFlowManager) QRoute.api(IQQStoryFlowManager.class)).startEditVideoActivity(activity, slideItemInfo2.f94291i, slideItemInfo2.f94287d, (int) slideItemInfo2.D, (int) slideItemInfo2.E, i18, i26, i19, str3, str4, z16, 3, 2, bundle);
                    return;
                }
                return;
            }
            this.f94324l = bVar;
            int i28 = this.f94317e;
            if ((i28 == 13 || i28 == 11 || i28 == 12 || this.f94318f == 22) && (z17 || (activity instanceof NewPhotoPreviewActivity))) {
                z();
            }
            int i29 = 0;
            for (SlideItemInfo slideItemInfo3 : this.f94314b) {
                if (slideItemInfo3 != null && slideItemInfo3.f94290h == 1) {
                    i29++;
                }
            }
            int size = this.f94314b.size() - i29;
            i iVar = this.f94321i;
            if (iVar != null) {
                iVar.h();
                this.f94322j = System.currentTimeMillis();
                if (this.f94317e == 11) {
                    i17 = 0;
                } else {
                    i17 = 1;
                }
                String[] strArr = new String[4];
                if (z17) {
                    str2 = "0";
                } else {
                    str2 = "1";
                }
                strArr[0] = str2;
                strArr[1] = this.f94314b.size() + "";
                strArr[2] = size + "";
                strArr[3] = i29 + "";
                id0.a.n("pic_choose_slides", "clk_create", i17, 0, strArr);
            }
            y(activity, this.f94314b);
            f();
            if (this.f94314b.size() > 0 && (slideItemInfo = this.f94314b.get(0)) != null) {
                int i36 = slideItemInfo.f94288e;
                str = slideItemInfo.f94289f;
                i16 = i36;
            } else {
                i16 = -1;
                str = "";
            }
            this.f94319g.c(this.f94314b, this, activity, this.f94320h, i3, i16, str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SlideShowPhotoListManager", 2, "activity == null || imgPathList == null");
        }
    }

    public List<LocalMediaInfo> k() {
        return this.f94315c;
    }

    public int l() {
        return this.f94317e;
    }

    public int m() {
        return this.f94318f;
    }

    public List<SlideItemInfo> o() {
        return this.f94314b;
    }

    public List<SlideItemInfo> p() {
        return this.f94316d;
    }

    public boolean q() {
        return x(this.f94316d, this.f94314b);
    }

    public void s() {
        String str;
        String str2;
        Iterator<SlideItemInfo> it;
        List<SlideItemInfo> o16 = n().o();
        String str3 = "\n";
        String str4 = " isOperateClip : ";
        String str5 = " mDuration : ";
        String str6 = " endTime : ";
        String str7 = "SlideShowPhotoListManager";
        if (QLog.isColorLevel()) {
            String str8 = "before : \n";
            for (int i3 = 0; i3 < o16.size(); i3++) {
                str8 = str8 + " path : " + o16.get(i3).f94291i + " startTime : " + o16.get(i3).D + " endTime : " + o16.get(i3).E + " mDuration : " + o16.get(i3).C + " isOperateClip : " + o16.get(i3).N + "\n";
            }
            QLog.d("SlideShowPhotoListManager", 2, str8);
        }
        Iterator<SlideItemInfo> it5 = o16.iterator();
        int i16 = 0;
        while (it5.hasNext()) {
            i16 = (int) (i16 + it5.next().C);
        }
        if (i16 <= this.f94313a + LightConstants.ErrorCode.SDK_VERSION_NOT_SUPPORT) {
            if (QLog.isColorLevel()) {
                QLog.d("SlideShowPhotoListManager", 2, "totalDuration : " + i16);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<SlideItemInfo> it6 = o16.iterator();
        while (it6.hasNext()) {
            SlideItemInfo next = it6.next();
            if (next.f94290h == 1) {
                int i17 = 0;
                while (true) {
                    if (i17 < arrayList.size()) {
                        it = it6;
                        str2 = str7;
                        if (next.C < ((SlideItemInfo) arrayList.get(i17)).C) {
                            arrayList.add(i17, next);
                            break;
                        } else {
                            i17++;
                            it6 = it;
                            str7 = str2;
                        }
                    } else {
                        str2 = str7;
                        it = it6;
                        break;
                    }
                }
                if (i17 == arrayList.size()) {
                    arrayList.add(next);
                }
            } else {
                str2 = str7;
                it = it6;
            }
            it6 = it;
            str7 = str2;
        }
        String str9 = str7;
        if (arrayList.size() == 0) {
            return;
        }
        int size = ((this.f94313a + LightConstants.ErrorCode.SDK_VERSION_NOT_SUPPORT) - ((o16.size() - arrayList.size()) * 2000)) - (arrayList.size() * 2000);
        if (QLog.isColorLevel()) {
            str = str9;
            QLog.d(str, 2, "leftTime : " + size + "   videoCount : " + arrayList.size());
        } else {
            str = str9;
        }
        Iterator it7 = arrayList.iterator();
        int i18 = 0;
        while (it7.hasNext()) {
            i18 = (int) (i18 + ((SlideItemInfo) it7.next()).C);
            str3 = str3;
            str4 = str4;
        }
        String str10 = str3;
        String str11 = str4;
        int size2 = i18 - (arrayList.size() * 2000);
        int i19 = 0;
        while (i19 < arrayList.size()) {
            SlideItemInfo slideItemInfo = (SlideItemInfo) arrayList.get(i19);
            long j3 = ((int) (((((float) slideItemInfo.C) - 2000.0f) / size2) * size)) + 2000;
            String str12 = str5;
            String str13 = str6;
            if (Math.abs(j3 - slideItemInfo.E) > 50 || Math.abs(slideItemInfo.D) > 50) {
                slideItemInfo.N = true;
                slideItemInfo.P = true;
            }
            slideItemInfo.E = j3;
            slideItemInfo.D = 0L;
            slideItemInfo.K = 0;
            slideItemInfo.L = 0;
            slideItemInfo.J = 0;
            if (QLog.isColorLevel()) {
                QLog.d(str, 2, "eachTime <= info.mDuration, i : " + i19 + "  leftTime : " + size + "  mDuration : " + slideItemInfo.C);
            }
            i19++;
            str5 = str12;
            str6 = str13;
        }
        String str14 = str5;
        String str15 = str6;
        if (QLog.isColorLevel()) {
            String str16 = "after : \n";
            for (int i26 = 0; i26 < o16.size(); i26++) {
                str16 = str16 + " path : " + o16.get(i26).f94291i + " startTime : " + o16.get(i26).D + str15 + o16.get(i26).E + str14 + o16.get(i26).C + str11 + o16.get(i26).N + str10;
            }
            QLog.d(str, 2, str16);
        }
        this.f94321i.j();
        G();
        g(o16);
        this.f94321i.g();
    }

    public void t(Intent intent, Map<String, LocalMediaInfo> map) {
        boolean z16;
        if (intent != null && map != null) {
            boolean z17 = false;
            int intExtra = intent.getIntExtra("video_index", 0);
            int intExtra2 = intent.getIntExtra("start_index", 0);
            int intExtra3 = intent.getIntExtra("end_index", 0);
            int intExtra4 = intent.getIntExtra("scroll_x", 0);
            int intExtra5 = intent.getIntExtra("start_time", 0);
            int intExtra6 = intent.getIntExtra("end_time", 0);
            List<SlideItemInfo> list = this.f94314b;
            if (list != null && list.size() > intExtra) {
                SlideItemInfo slideItemInfo = this.f94314b.get(intExtra);
                slideItemInfo.K = intExtra2;
                slideItemInfo.L = intExtra3;
                slideItemInfo.J = intExtra4;
                long j3 = intExtra5;
                if (Math.abs(j3 - slideItemInfo.D) >= 50) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                boolean z18 = z16 | false;
                long j16 = intExtra6;
                if (Math.abs(j16 - slideItemInfo.E) >= 50) {
                    z17 = true;
                }
                boolean z19 = z17 | z18;
                if (QLog.isColorLevel()) {
                    QLog.d("SlideShowPhotoListManager", 2, "isOperateClip : " + z19 + "  startTime : " + intExtra5 + "  slideInfo.startTime : " + slideItemInfo.D + " endTime : " + intExtra6 + "  slideInfo.endTime : " + slideItemInfo.E);
                }
                if (z19) {
                    slideItemInfo.N = z19;
                    slideItemInfo.D = j3;
                    slideItemInfo.E = j16;
                }
            }
        }
    }

    public void u(List<String> list, HashMap<String, LocalMediaInfo> hashMap) {
        v(list, hashMap, true);
    }

    public void v(List<String> list, HashMap<String, LocalMediaInfo> hashMap, boolean z16) {
        boolean z17;
        if (QLog.isColorLevel()) {
            if (list != null && hashMap != null) {
                QLog.e("SlideShowPhotoListManager", 2, "onItemsSelectChanged selectedPhotoList = " + list.size() + " mediaMap=" + hashMap.size());
            } else {
                QLog.e("SlideShowPhotoListManager", 2, "onItemsSelectChanged selectedPhotoList = " + list + " mediaMap=" + hashMap);
            }
        }
        if (list != null && hashMap != null) {
            for (LocalMediaInfo localMediaInfo : this.f94315c) {
                Iterator<String> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().equals(localMediaInfo.path)) {
                            z17 = true;
                            break;
                        }
                    } else {
                        z17 = false;
                        break;
                    }
                }
                if (z17) {
                    localMediaInfo.selectStatus = 1;
                } else {
                    localMediaInfo.selectStatus = 2;
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f94314b);
            this.f94314b.clear();
            if (hashMap.size() > 0) {
                this.f94314b.addAll(h.a(list, hashMap, arrayList));
            }
            arrayList.clear();
            i iVar = this.f94321i;
            if (iVar != null) {
                iVar.j();
            }
            if (z16) {
                g(this.f94314b);
            }
        }
    }

    public void w() {
        if (QLog.isColorLevel()) {
            QLog.i("SlideShowPhotoListManager", 2, "onResume");
        }
    }

    public void z() {
        Iterator<WeakReference<Activity>> it = this.f94323k.iterator();
        while (it.hasNext()) {
            Activity activity = it.next().get();
            if (activity != null && activity.getClass().getName().contains("EditVideoActivity")) {
                activity.finish();
                this.f94323k.remove(activity);
            }
        }
    }

    /* loaded from: classes5.dex */
    class a extends qs.e {
        a() {
        }

        @Override // qs.e
        public void c(String str, boolean z16, int i3) {
            if (QLog.isColorLevel()) {
                QLog.d("SlideShowPhotoListManager", 2, "SlideShowPhotoListManager onFinish key=" + str + " result=" + z16);
            }
        }

        @Override // qs.e
        public void b(String str) {
        }

        @Override // qs.e
        public void d(int i3) {
        }

        @Override // qs.e
        public void e(String str, int i3) {
        }

        @Override // qs.e
        public void f(String str, boolean z16) {
        }
    }
}
