package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem;
import com.tencent.mobileqq.utils.eu;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import com.tribe.async.reactive.SimpleObserver;
import com.tribe.async.reactive.Stream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e extends ImageItem {
    static IPatchRedirector $redirector_;
    protected Map<VideoInfo, Stream<VideoInfo>> C;
    protected String D;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a extends SimpleObserver<ImageInfo> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageInfo f297485a;

        a(ImageInfo imageInfo) {
            this.f297485a = imageInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this, (Object) imageInfo);
            }
        }

        @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(ImageInfo imageInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) imageInfo);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("VideoItem", 2, "VideoItem onNext. info position=", Integer.valueOf(imageInfo.f297409a), ", old status=", Integer.valueOf(imageInfo.f297417d), ", result=", imageInfo);
            }
            imageInfo.f297417d = 3;
            imageInfo.f297370o = 100;
            e.this.f297438h.remove(imageInfo);
            XMediaEditor xMediaEditor = e.this.f297478d;
            if (xMediaEditor != null) {
                RecyclerView.ViewHolder findViewHolderForLayoutPosition = xMediaEditor.findViewHolderForLayoutPosition(imageInfo.f297409a);
                if (findViewHolderForLayoutPosition instanceof c) {
                    c cVar = (c) findViewHolderForLayoutPosition;
                    if (QLog.isColorLevel()) {
                        QLog.d("VideoItem", 2, "video onNext. info hash=", Integer.valueOf(imageInfo.hashCode()), ", result hash=", Integer.valueOf(imageInfo.hashCode()), ", info position=", Integer.valueOf(imageInfo.f297409a), ", result position=", Integer.valueOf(imageInfo.f297409a), ", vh position=", Integer.valueOf(cVar.f297481d.f297409a), ",vh hash=", Integer.valueOf(cVar.hashCode()));
                    }
                    if (imageInfo.f297366k.equals(cVar.C.getTag())) {
                        cVar.C.setVisibility(0);
                        cVar.C.setDrawStatus(1);
                        cVar.C.setAnimProgress(imageInfo.f297370o, imageInfo.f297366k);
                    }
                    e.this.f297479e.e(cVar, true);
                }
            }
            eu.j("hw_entry_upload", "upload_video", "1", "", String.valueOf(SystemClock.elapsedRealtime() - imageInfo.f297372q), "");
            e.this.A(0, false);
            com.tencent.mobileqq.troop.homework.utils.a.b(0, "\u4e0a\u4f20\u89c6\u9891\u6210\u529f", imageInfo);
        }

        @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
        public void onError(@NonNull Error error) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) error);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("VideoItem", 2, "VideoItem onError. info position=", Integer.valueOf(this.f297485a.f297409a), ", info old status=", Integer.valueOf(this.f297485a.f297417d));
            }
            ImageInfo imageInfo = this.f297485a;
            imageInfo.f297417d = 2;
            e.this.f297438h.remove(imageInfo);
            QLog.d("VideoItem", 1, error, new Object[0]);
            String message = error.getMessage();
            XMediaEditor xMediaEditor = e.this.f297478d;
            if (xMediaEditor != null) {
                RecyclerView.ViewHolder findViewHolderForLayoutPosition = xMediaEditor.findViewHolderForLayoutPosition(this.f297485a.f297409a);
                if (findViewHolderForLayoutPosition instanceof c) {
                    c cVar = (c) findViewHolderForLayoutPosition;
                    if (this.f297485a.f297366k.equals(cVar.C.getTag())) {
                        ((e) ((com.tencent.mobileqq.troop.homework.xmediaeditor.a) e.this.f297478d.getAdapter()).f297359e.a(2)).a(cVar, this.f297485a, 0);
                        if ("200".equals(message)) {
                            QLog.d("VideoItem", 1, "VideoItem onError. upload size exceed.");
                            QQToast.makeText(e.this.f297478d.getContext(), HardCodeUtil.qqStr(R.string.v4o), 0).show();
                            e.this.f297479e.b(cVar);
                        }
                    }
                }
            }
            if (!message.startsWith("c_")) {
                eu.j("hw_entry_upload", "upload_video", "2", message, String.valueOf(SystemClock.elapsedRealtime() - this.f297485a.f297372q), "");
            }
            if (this.f297485a.f297366k.equals(e.this.f297439i)) {
                e.this.A(0, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b extends SimpleObserver<VideoInfo> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ VideoInfo f297487a;

        b(VideoInfo videoInfo) {
            this.f297487a = videoInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this, (Object) videoInfo);
            }
        }

        @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(VideoInfo videoInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) videoInfo);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("VideoItem", 2, "VideoItem GeneratePoster onNext. info position=", Integer.valueOf(videoInfo.f297409a), ", old status=", Integer.valueOf(videoInfo.f297417d));
            }
            e.this.C.remove(videoInfo);
            e.this.A(1, false);
        }

        @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
        public void onError(@NonNull Error error) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) error);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("VideoItem", 2, "VideoItem GeneratePoster onError. info position=", Integer.valueOf(this.f297487a.f297409a), ", old status=", Integer.valueOf(this.f297487a.f297417d));
            }
            VideoInfo videoInfo = this.f297487a;
            videoInfo.f297417d = 2;
            e.this.C.remove(videoInfo);
            QLog.d("VideoItem", 1, error, new Object[0]);
            String message = error.getMessage();
            XMediaEditor xMediaEditor = e.this.f297478d;
            if (xMediaEditor != null) {
                RecyclerView.ViewHolder findViewHolderForLayoutPosition = xMediaEditor.findViewHolderForLayoutPosition(this.f297487a.f297409a);
                if (findViewHolderForLayoutPosition instanceof c) {
                    c cVar = (c) findViewHolderForLayoutPosition;
                    if (this.f297487a.f297366k.equals(cVar.C.getTag())) {
                        ((e) ((com.tencent.mobileqq.troop.homework.xmediaeditor.a) e.this.f297478d.getAdapter()).f297359e.a(2)).a(cVar, this.f297487a, 0);
                    }
                }
            }
            if (!message.startsWith("c_")) {
                eu.j("hw_entry_upload", "upload_video", "2", message, String.valueOf(SystemClock.elapsedRealtime() - this.f297487a.f297372q), "");
            }
            if (this.f297487a.f297366k.equals(e.this.f297439i)) {
                e.this.A(1, false);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class c extends ImageItem.e {
        static IPatchRedirector $redirector_;

        public c(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem.e
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            this.C.setVisibility(4);
            this.f297453m.setVisibility(0);
            this.f297452i.setVisibility(4);
        }
    }

    public e(XMediaEditor xMediaEditor) {
        super(xMediaEditor);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) xMediaEditor);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem
    public void A(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (i3 == 0) {
            super.A(i3, z16);
            return;
        }
        if (i3 == 1) {
            Iterator<VideoInfo> it = this.C.keySet().iterator();
            if (QLog.isColorLevel()) {
                QLog.d("VideoItem", 2, "scheduleStream for poster. hasNext=", Boolean.valueOf(it.hasNext()));
            }
            if (it.hasNext()) {
                VideoInfo next = it.next();
                if (QLog.isColorLevel()) {
                    QLog.d("VideoItem", 2, "scheduleStream for poster. next info position=", Integer.valueOf(next.f297409a), ", type=", Integer.valueOf(next.c()), ", hash=", Integer.valueOf(next.hashCode()));
                }
                Stream<VideoInfo> stream = this.C.get(next);
                if (stream != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("VideoItem", 2, "scheduleStream for poster. fire stream. info hash=", Integer.valueOf(next.hashCode()));
                    }
                    this.D = next.f297366k;
                    next.f297372q = SystemClock.elapsedRealtime();
                    stream.subscribe(D(next));
                    return;
                }
                return;
            }
            this.D = null;
            if (QLog.isColorLevel()) {
                QLog.d("VideoItem", 2, "scheduleStream for poster. no poster stream. mHasStartUploading=", Boolean.valueOf(this.f297440m));
            }
            if (!this.f297440m) {
                A(0, true);
            }
        }
    }

    public void C(VideoInfo videoInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) videoInfo);
            return;
        }
        if (this.f297478d.x() == 0) {
            this.f297478d.requestFocus();
        }
        QBaseActivity qBaseActivity = (QBaseActivity) this.f297478d.getContext();
        Intent intent = new Intent();
        intent.putExtra("file_send_path", videoInfo.r());
        intent.putExtra(ShortVideoConstants.VIDEO_PLAY_CALLER, 4);
        intent.putExtra(ShortVideoConstants.MESSAGE_CLICK_START, System.currentTimeMillis());
        RouteUtils.startActivity(qBaseActivity, intent, "/business/shortvideoplay");
        Intent intent2 = new Intent();
        intent2.setAction("com.tencent.mobileqq.troop.homework.xmediaeditor.ui.action_play_video");
        intent2.setPackage(qBaseActivity.getPackageName());
        qBaseActivity.sendBroadcast(intent2);
    }

    protected SimpleObserver<VideoInfo> D(VideoInfo videoInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (SimpleObserver) iPatchRedirector.redirect((short) 8, (Object) this, (Object) videoInfo);
        }
        return new b(videoInfo);
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public c b(ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (c) iPatchRedirector.redirect((short) 4, (Object) this, (Object) viewGroup);
        }
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.aik, viewGroup, false);
        c cVar = new c(inflate);
        if (QLog.isColorLevel()) {
            QLog.d("VideoItem", 2, "Video onCreateViewHolder. vh hash=", Integer.valueOf(cVar.hashCode()));
        }
        l(cVar.f297450f, cVar);
        l(cVar.f297451h, cVar);
        l(cVar.f297452i, cVar);
        l(cVar.f297453m, cVar);
        if (this.f297478d.w() != 0) {
            inflate.setPadding(this.f297478d.w(), 0, this.f297478d.w(), 0);
        }
        return cVar;
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem, com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a
    public void d(com.tencent.mobileqq.troop.homework.xmediaeditor.model.b bVar) {
        Stream<VideoInfo> stream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bVar);
            return;
        }
        super.d(bVar);
        VideoInfo videoInfo = (VideoInfo) bVar;
        Map<VideoInfo, Stream<VideoInfo>> map = this.C;
        if (map != null && !map.isEmpty() && (stream = this.C.get(videoInfo)) != null) {
            stream.cancel();
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem, com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.j();
        Map<VideoInfo, Stream<VideoInfo>> map = this.C;
        if (map != null && !map.isEmpty()) {
            for (VideoInfo videoInfo : this.C.keySet()) {
                Stream<VideoInfo> stream = this.C.get(videoInfo);
                if (stream != null) {
                    stream.cancel();
                }
                z(videoInfo);
            }
            this.C.clear();
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem
    protected void o(ImageItem.e eVar, ImageInfo imageInfo, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, eVar, imageInfo, Integer.valueOf(i3));
            return;
        }
        if (i3 != 0) {
            eVar.f297451h.setVisibility(4);
            eVar.f297453m.setVisibility(0);
            eVar.f297452i.setVisibility(4);
            eVar.C.setVisibility(4);
            return;
        }
        eVar.f297451h.setVisibility(0);
        int i16 = imageInfo.f297417d;
        if (i16 != 2) {
            if (i16 != 3) {
                switch (i16) {
                    case Integer.MIN_VALUE:
                    case -2147483647:
                    case -2147483646:
                    case -2147483645:
                        eVar.C.setVisibility(0);
                        eVar.C.setDrawStatus(1);
                        eVar.C.setAnimProgress(imageInfo.f297370o, imageInfo.f297366k);
                        eVar.f297452i.setVisibility(4);
                        eVar.f297453m.setVisibility(4);
                        return;
                    default:
                        return;
                }
            }
            if (imageInfo.f297370o == 100) {
                eVar.b();
                return;
            }
            return;
        }
        eVar.C.setVisibility(4);
        eVar.f297452i.setVisibility(0);
        eVar.f297453m.setVisibility(4);
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem
    protected void q(ImageInfo imageInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) imageInfo);
            return;
        }
        VideoInfo videoInfo = (VideoInfo) imageInfo;
        if (this.f297438h == null) {
            this.f297438h = new LinkedHashMap();
        }
        if (this.C == null) {
            this.C = new LinkedHashMap();
        }
        Stream<VideoInfo> p16 = videoInfo.p(this.f297478d);
        if (p16 != null && !this.C.containsKey(videoInfo)) {
            this.C.put(videoInfo, p16);
        }
        Stream<ImageInfo> g16 = videoInfo.g(this.f297478d);
        if (!this.f297438h.containsKey(videoInfo)) {
            this.f297438h.put(videoInfo, g16);
        }
        if (p16 != null) {
            if (TextUtils.isEmpty(this.D)) {
                this.D = videoInfo.f297366k;
                videoInfo.f297372q = SystemClock.elapsedRealtime();
                p16.subscribe(D(videoInfo));
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(this.f297439i)) {
            this.f297439i = videoInfo.f297366k;
            this.f297440m = true;
            videoInfo.f297372q = SystemClock.elapsedRealtime();
            g16.subscribe(r(videoInfo));
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem
    protected SimpleObserver<ImageInfo> r(ImageInfo imageInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (SimpleObserver) iPatchRedirector.redirect((short) 7, (Object) this, (Object) imageInfo);
        }
        return new a(imageInfo);
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem, com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a
    /* renamed from: w */
    public void e(View view, ImageItem.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) eVar);
            return;
        }
        VideoInfo videoInfo = (VideoInfo) eVar.f297481d;
        int id5 = view.getId();
        if (id5 == R.id.d6z) {
            this.f297479e.b(eVar);
            return;
        }
        if (id5 == R.id.f165703d73) {
            if (videoInfo.f297417d == 2) {
                eVar.f297452i.setVisibility(4);
                m(videoInfo);
                return;
            }
            return;
        }
        if (id5 == R.id.f165701d71 || id5 == R.id.f165700d70) {
            InputMethodUtil.hide((Activity) this.f297478d.getContext());
            if (QLog.isColorLevel()) {
                QLog.d("VideoItem", 2, "onItemViewClick preview. info position=", Integer.valueOf(videoInfo.f297409a), ", path=", videoInfo.f297390t);
            }
            C(videoInfo);
        }
    }
}
