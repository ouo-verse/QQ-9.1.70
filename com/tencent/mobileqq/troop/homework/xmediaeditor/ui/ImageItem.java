package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.ams.mosaic.jsengine.component.ComponentFactory;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.image.URLDrawable;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopHWApi;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.g;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.b;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.eu;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.qbasealbum.model.AlbumResult;
import com.tencent.util.InputMethodUtil;
import com.tribe.async.reactive.SimpleObserver;
import com.tribe.async.reactive.Stream;
import cooperation.troop_homework.TroopHomeworkHelper;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ImageItem extends com.tencent.mobileqq.troop.homework.xmediaeditor.ui.d<e, com.tencent.mobileqq.troop.homework.xmediaeditor.model.b> {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    protected ColorDrawable f297437f;

    /* renamed from: h, reason: collision with root package name */
    protected Map<ImageInfo, Stream<ImageInfo>> f297438h;

    /* renamed from: i, reason: collision with root package name */
    protected String f297439i;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f297440m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements IPicLoadStateListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ImageItem.this);
            }
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) loadState, (Object) option);
            } else if (!loadState.isFinishSuccess()) {
                QLog.e("ImageItem", 1, "QQPicLoader load error");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b extends SimpleObserver<ImageInfo> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageInfo f297443a;

        b(ImageInfo imageInfo) {
            this.f297443a = imageInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ImageItem.this, (Object) imageInfo);
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
                QLog.d("ImageItem", 2, "ImageItem onNext. info position=", Integer.valueOf(imageInfo.f297409a), ", old status=", Integer.valueOf(imageInfo.f297417d), ", result=", imageInfo);
            }
            imageInfo.f297417d = 3;
            imageInfo.f297370o = 100;
            ImageItem.this.f297438h.remove(imageInfo);
            XMediaEditor xMediaEditor = ImageItem.this.f297478d;
            if (xMediaEditor != null) {
                RecyclerView.ViewHolder findViewHolderForLayoutPosition = xMediaEditor.findViewHolderForLayoutPosition(this.f297443a.f297409a);
                if (findViewHolderForLayoutPosition instanceof e) {
                    e eVar = (e) findViewHolderForLayoutPosition;
                    if (QLog.isColorLevel()) {
                        QLog.d("ImageItem", 2, "ImageItem onNext. info hash=", Integer.valueOf(imageInfo.hashCode()), ", result hash=", Integer.valueOf(imageInfo.hashCode()), ", info position=", Integer.valueOf(imageInfo.f297409a), ", result position=", Integer.valueOf(imageInfo.f297409a), ", vh position=", Integer.valueOf(eVar.f297481d.f297409a), ",vh hash=", Integer.valueOf(eVar.hashCode()));
                    }
                    if (imageInfo.f297366k.equals(eVar.C.getTag())) {
                        eVar.C.setVisibility(0);
                        eVar.C.setDrawStatus(1);
                        eVar.C.setAnimProgress(imageInfo.f297370o, imageInfo.f297366k);
                    }
                    ImageItem.this.f297479e.e(eVar, true);
                }
            }
            eu.j("hw_entry_upload", "upload_image", "1", "", String.valueOf(SystemClock.elapsedRealtime() - imageInfo.f297372q), "");
            ImageItem.this.A(0, false);
            com.tencent.mobileqq.troop.homework.utils.a.b(0, "\u4e0a\u4f20\u56fe\u7247\u6210\u529f", imageInfo);
        }

        @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
        public void onError(@NonNull Error error) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) error);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ImageItem", 2, "ImageItem onError: ", error.getMessage(), ", info position =", Integer.valueOf(this.f297443a.f297409a), ", info hash=", Integer.valueOf(this.f297443a.hashCode()), ", info old status=", Integer.valueOf(this.f297443a.f297417d));
            }
            ImageInfo imageInfo = this.f297443a;
            imageInfo.f297417d = 2;
            ImageItem.this.f297438h.remove(imageInfo);
            QLog.d("ImageItem", 1, error, new Object[0]);
            String message = error.getMessage();
            XMediaEditor xMediaEditor = ImageItem.this.f297478d;
            if (xMediaEditor != null) {
                RecyclerView.ViewHolder findViewHolderForLayoutPosition = xMediaEditor.findViewHolderForLayoutPosition(this.f297443a.f297409a);
                if (findViewHolderForLayoutPosition instanceof e) {
                    e eVar = (e) findViewHolderForLayoutPosition;
                    if (this.f297443a.f297366k.equals(eVar.C.getTag())) {
                        ((ImageItem) ((com.tencent.mobileqq.troop.homework.xmediaeditor.a) ImageItem.this.f297478d.getAdapter()).f297359e.a(1)).a(eVar, this.f297443a, 0);
                    }
                }
            }
            if (!message.startsWith("c_")) {
                eu.j("hw_entry_upload", "upload_image", "2", message, String.valueOf(SystemClock.elapsedRealtime() - this.f297443a.f297372q), "");
            }
            if (this.f297443a.f297366k.equals(ImageItem.this.f297439i)) {
                ImageItem.this.A(0, false);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ XMediaEditor f297445d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f297446e;

        c(XMediaEditor xMediaEditor, List list) {
            this.f297445d = xMediaEditor;
            this.f297446e = list;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ImageItem.this, xMediaEditor, list);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                this.f297445d.D(this.f297446e);
                dialogInterface.dismiss();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ImageItem.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                dialogInterface.dismiss();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class e extends b.a<com.tencent.mobileqq.troop.homework.xmediaeditor.model.b> {
        static IPatchRedirector $redirector_;
        public MessageProgressView C;
        public View D;

        /* renamed from: e, reason: collision with root package name */
        public URLDrawable f297449e;

        /* renamed from: f, reason: collision with root package name */
        public RoundCornerImageView f297450f;

        /* renamed from: h, reason: collision with root package name */
        public ImageView f297451h;

        /* renamed from: i, reason: collision with root package name */
        public ImageView f297452i;

        /* renamed from: m, reason: collision with root package name */
        public ImageView f297453m;

        /* compiled from: P */
        /* loaded from: classes19.dex */
        class a implements MessageProgressView.a {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
                }
            }

            @Override // com.tencent.mobileqq.widget.MessageProgressView.a
            public void a(String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                } else {
                    e.this.b();
                }
            }
        }

        public e(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
                return;
            }
            this.D = view.findViewById(R.id.d6y);
            RoundCornerImageView roundCornerImageView = (RoundCornerImageView) view.findViewById(R.id.f165700d70);
            this.f297450f = roundCornerImageView;
            roundCornerImageView.f94496f = 1;
            roundCornerImageView.setCorner(10);
            this.f297452i = (ImageView) view.findViewById(R.id.f165703d73);
            this.f297453m = (ImageView) view.findViewById(R.id.f165701d71);
            this.f297451h = (ImageView) view.findViewById(R.id.d6z);
            MessageProgressView messageProgressView = (MessageProgressView) view.findViewById(R.id.f165702d72);
            this.C = messageProgressView;
            messageProgressView.setRadius(10.0f, false);
            this.C.setShowCorner(false);
            this.C.setDisplayInTextView(ViewUtils.dpToPx(17.0f), -1);
            this.C.setAnimRunnableListener(new a());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.C.setVisibility(4);
                this.f297452i.setVisibility(4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final List<com.tencent.mobileqq.troop.homework.xmediaeditor.model.b> f297455a;

        /* renamed from: b, reason: collision with root package name */
        final int f297456b;

        f(List<com.tencent.mobileqq.troop.homework.xmediaeditor.model.b> list, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ImageItem.this, list, Integer.valueOf(i3));
            } else {
                this.f297455a = list;
                this.f297456b = i3;
            }
        }
    }

    public ImageItem(XMediaEditor xMediaEditor) {
        super(xMediaEditor);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) xMediaEditor);
        } else {
            this.f297437f = new ColorDrawable(Color.parseColor("#DEDEDE"));
        }
    }

    public static void B(View view, int i3, int i16) {
        if (view != null && i3 > 0 && i16 > 0) {
            int paddingLeft = view.getPaddingLeft() + view.getPaddingRight() + i3;
            int paddingTop = view.getPaddingTop() + view.getPaddingBottom() + i16;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams.width != paddingLeft || layoutParams.height != paddingTop) {
                    layoutParams.width = paddingLeft;
                    layoutParams.height = paddingTop;
                    view.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            view.setLayoutParams(new ViewGroup.LayoutParams(paddingLeft, paddingTop));
        }
    }

    public static int[] p(int i3, int i16, int i17, int i18, int i19) {
        int[] iArr = {i18, i19};
        if (i18 > 0 && i19 > 0) {
            if (i18 > i17) {
                iArr[0] = i3;
                iArr[1] = (int) (((i3 * 1.0f) * i19) / i18);
            } else if (Math.min(i18, i19) < i16) {
                if (i18 <= i19) {
                    iArr[0] = i16;
                    iArr[1] = (int) (((i16 * 1.0f) * i19) / i18);
                } else {
                    iArr[0] = (int) (((i16 * 1.0f) * i18) / i19);
                    iArr[1] = i16;
                }
            }
        } else {
            iArr[0] = i3;
            iArr[1] = (int) ((i3 * 9) / 16.0f);
            if (QLog.isColorLevel()) {
                QLog.d("ImageItem", 2, "calculateMaxMinImageSize doudi. maxWidth=", Integer.valueOf(iArr[0]), ", height=", Integer.valueOf(iArr[1]));
            }
        }
        return iArr;
    }

    private f s(Intent intent, String str) {
        boolean z16;
        g imageInfo;
        int i3;
        ArrayList arrayList = new ArrayList();
        if (intent == null) {
            QLog.e("ImageItem", 1, "Intent is null!");
            return new f(arrayList, 0);
        }
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        if (stringArrayListExtra != null && !stringArrayListExtra.isEmpty()) {
            HashMap hashMap = (HashMap) intent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
            if (QLog.isColorLevel()) {
                if (hashMap != null) {
                    i3 = hashMap.size();
                } else {
                    i3 = 0;
                }
                QLog.d("ImageItem", 1, "Selected pic or video! size = " + i3);
            }
            Iterator<String> it = stringArrayListExtra.iterator();
            int i16 = 0;
            while (it.hasNext()) {
                String next = it.next();
                if (hashMap != null && QAlbumUtil.getMediaType((LocalMediaInfo) hashMap.get(next)) == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    imageInfo = new VideoInfo(next, str);
                } else {
                    imageInfo = new ImageInfo(next, str);
                }
                if (z16) {
                    i16++;
                }
                arrayList.add(imageInfo);
            }
            return new f(arrayList, i16);
        }
        QLog.e("ImageItem", 1, "Selected list empty!");
        return new f(arrayList, 0);
    }

    private f t(Intent intent, String str) {
        AlbumResult albumResult;
        g imageInfo;
        ArrayList arrayList = new ArrayList();
        if (intent != null) {
            albumResult = (AlbumResult) intent.getParcelableExtra("ALBUM_RESULT");
        } else {
            albumResult = null;
        }
        if (albumResult == null) {
            return new f(arrayList, 0);
        }
        List<com.tencent.qqnt.qbasealbum.model.LocalMediaInfo> e16 = albumResult.e();
        if (e16 != null && !e16.isEmpty()) {
            int i3 = 0;
            for (com.tencent.qqnt.qbasealbum.model.LocalMediaInfo localMediaInfo : e16) {
                boolean z16 = true;
                if (QAlbumUtil.getMediaType(localMediaInfo.getPath()) != 1) {
                    z16 = false;
                }
                if (z16) {
                    i3++;
                    imageInfo = new VideoInfo(localMediaInfo.getPath(), str);
                } else {
                    imageInfo = new ImageInfo(localMediaInfo.getPath(), str);
                }
                arrayList.add(imageInfo);
            }
            return new f(arrayList, i3);
        }
        return new f(arrayList, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(ImageInfo imageInfo, boolean z16) {
        imageInfo.f297369n = this.f297478d.getWidth();
        if (this.f297478d.w() > 0) {
            imageInfo.f297369n -= this.f297478d.w() * 2;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ImageItem", 2, "onItemAdded. editor getWidth result: ", Integer.valueOf(imageInfo.f297369n));
        }
        if (z16) {
            this.f297478d.getAdapter().notifyDataSetChanged();
        }
        if (this.f297478d.x() == 0 && imageInfo.m()) {
            q(imageInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void A(int i3, boolean z16) {
        ImageInfo next;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        Iterator<ImageInfo> it = this.f297438h.keySet().iterator();
        if (QLog.isColorLevel()) {
            QLog.d("ImageItem", 2, "scheduleStream. hasNext=", Boolean.valueOf(it.hasNext()));
        }
        if (!z16) {
            if (it.hasNext()) {
                next = it.next();
                if (next != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ImageItem", 2, "scheduleStream. next info position=", Integer.valueOf(next.f297409a), ", type=", Integer.valueOf(next.c()), ", hash=", Integer.valueOf(next.hashCode()));
                    }
                    Stream<ImageInfo> stream = this.f297438h.get(next);
                    if (stream != null) {
                        if (QLog.isColorLevel()) {
                            QLog.d("ImageItem", 2, "scheduleStream. fire stream. info hash=", Integer.valueOf(next.hashCode()));
                        }
                        this.f297439i = next.f297366k;
                        this.f297440m = true;
                        next.f297372q = SystemClock.elapsedRealtime();
                        stream.subscribe(r(next));
                        return;
                    }
                    return;
                }
                this.f297439i = null;
                this.f297440m = false;
                return;
            }
            next = null;
            if (next != null) {
            }
        }
        while (it.hasNext()) {
            next = it.next();
            if (next.f297417d != 2) {
                break;
            }
        }
        next = null;
        if (next != null) {
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a
    public void c(com.tencent.mobileqq.troop.homework.xmediaeditor.model.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
            return;
        }
        int width = this.f297478d.getWidth();
        if (width <= 0) {
            if (QLog.isColorLevel()) {
                QLog.d("ImageItem", 2, "onItemAdded. editor getWidth fail result: ", Integer.valueOf(width));
            }
            ThreadManager.getUIHandler().postDelayed(new Runnable(bVar) { // from class: com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ com.tencent.mobileqq.troop.homework.xmediaeditor.model.b f297441d;

                {
                    this.f297441d = bVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ImageItem.this, (Object) bVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        ImageItem.this.y((ImageInfo) this.f297441d, true);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }, 50L);
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("ImageItem", 2, "onItemAdded. editor getWidth result without post: ", Integer.valueOf(width));
            }
            y((ImageInfo) bVar, false);
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a
    public void d(com.tencent.mobileqq.troop.homework.xmediaeditor.model.b bVar) {
        Stream<ImageInfo> stream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
            return;
        }
        ImageInfo imageInfo = (ImageInfo) bVar;
        Map<ImageInfo, Stream<ImageInfo>> map = this.f297438h;
        if (map != null && !map.isEmpty() && (stream = this.f297438h.get(imageInfo)) != null) {
            stream.cancel();
        }
        ConcurrentHashMap<String, TroopHomeworkHelper.UploadFileTask> concurrentHashMap = imageInfo.f297371p;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
        URL url = imageInfo.f297365j;
        if (url != null) {
            URLDrawable.removeMemoryCacheByUrl(url.toString());
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        Map<ImageInfo, Stream<ImageInfo>> map = this.f297438h;
        if (map != null && !map.isEmpty()) {
            for (ImageInfo imageInfo : this.f297438h.keySet()) {
                Stream<ImageInfo> stream = this.f297438h.get(imageInfo);
                if (stream != null) {
                    stream.cancel();
                }
                z(imageInfo);
            }
            this.f297438h.clear();
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.ui.d
    public void m(com.tencent.mobileqq.troop.homework.xmediaeditor.model.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) bVar);
            return;
        }
        ImageInfo imageInfo = (ImageInfo) bVar;
        if (imageInfo.m()) {
            q(imageInfo);
        }
    }

    protected <VH extends e, INFO extends ImageInfo> void o(VH vh5, INFO info, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, vh5, info, Integer.valueOf(i3));
            return;
        }
        if (i3 != 0) {
            vh5.f297451h.setVisibility(4);
            vh5.f297452i.setVisibility(4);
            vh5.C.setVisibility(4);
            return;
        }
        vh5.f297451h.setVisibility(0);
        int i16 = info.f297417d;
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 == 3 && info.f297370o == 100) {
                    vh5.b();
                    return;
                }
                return;
            }
            vh5.C.setVisibility(4);
            vh5.f297452i.setVisibility(0);
            return;
        }
        vh5.C.setVisibility(0);
        vh5.C.setDrawStatus(1);
        vh5.C.setAnimProgress(info.f297370o, info.f297366k);
        vh5.f297452i.setVisibility(4);
    }

    protected void q(ImageInfo imageInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) imageInfo);
            return;
        }
        if (this.f297438h == null) {
            this.f297438h = new LinkedHashMap();
        }
        Stream<ImageInfo> g16 = imageInfo.g(this.f297478d);
        if (!this.f297438h.containsKey(imageInfo)) {
            this.f297438h.put(imageInfo, g16);
        }
        if (TextUtils.isEmpty(this.f297439i)) {
            this.f297439i = imageInfo.f297366k;
            this.f297440m = true;
            imageInfo.f297372q = SystemClock.elapsedRealtime();
            g16.subscribe(r(imageInfo));
        }
    }

    protected SimpleObserver<ImageInfo> r(ImageInfo imageInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (SimpleObserver) iPatchRedirector.redirect((short) 10, (Object) this, (Object) imageInfo);
        }
        return new b(imageInfo);
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(e eVar, com.tencent.mobileqq.troop.homework.xmediaeditor.model.b bVar, int i3) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, eVar, bVar, Integer.valueOf(i3));
            return;
        }
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[3];
            if (bVar instanceof VideoInfo) {
                str = ComponentFactory.ComponentType.VIDEO;
            } else {
                str = "Image";
            }
            objArr[0] = str;
            objArr[1] = " onBindViewHolder. vh hash=";
            objArr[2] = Integer.valueOf(eVar.hashCode());
            QLog.d("ImageItem", 2, objArr);
        }
        ImageInfo imageInfo = (ImageInfo) bVar;
        if (imageInfo.f297369n <= 0) {
            if (QLog.isColorLevel()) {
                QLog.d("ImageItem", 2, "onBindViewHolder maxWidth fail. return");
                return;
            }
            return;
        }
        eVar.C.setTag(imageInfo.f297366k);
        if (QLog.isColorLevel()) {
            Object[] objArr2 = new Object[14];
            objArr2[0] = "onBindViewHolder. VHHash=";
            objArr2[1] = eVar;
            objArr2[2] = ", infoHash=";
            objArr2[3] = Integer.valueOf(imageInfo.hashCode());
            objArr2[4] = ", progressKey=";
            objArr2[5] = imageInfo.f297366k;
            objArr2[6] = ", infoPosition=";
            objArr2[7] = Integer.valueOf(imageInfo.f297409a);
            objArr2[8] = ", info URL=";
            Object obj = imageInfo.f297365j;
            Object obj2 = "null";
            if (obj == null) {
                obj = "null";
            }
            objArr2[9] = obj;
            objArr2[10] = ", vh URL=";
            URLDrawable uRLDrawable = eVar.f297449e;
            if (uRLDrawable != null) {
                obj2 = uRLDrawable.getURL();
            }
            objArr2[11] = obj2;
            objArr2[12] = ", showType=";
            objArr2[13] = Integer.valueOf(i3);
            QLog.d("ImageItem", 2, objArr2);
        }
        int[] p16 = p(imageInfo.f297369n, 200, 300, imageInfo.f297367l, imageInfo.f297368m);
        if (QLog.isColorLevel()) {
            QLog.d("ImageItem", 2, "onBindViewHolder calculateMaxWidth. infoMaxWidth=", Integer.valueOf(imageInfo.f297369n), ", infoWidth=", Integer.valueOf(imageInfo.f297367l), ", infoHeight=", Integer.valueOf(imageInfo.f297368m), ", dstWidth=", Integer.valueOf(p16[0]), ", dstHeight=", Integer.valueOf(p16[1]));
        }
        B(eVar.D, p16[0], p16[1]);
        o(eVar, imageInfo, i3);
        if (imageInfo.f297365j != null && imageInfo.f297417d != -2147483645) {
            Option requestHeight = Option.obtain().setTargetView(eVar.f297450f).setRequestWidth(p16[0]).setRequestHeight(p16[1]);
            if ("file".equals(imageInfo.f297365j.getProtocol())) {
                requestHeight.setLocalPath(imageInfo.f297365j.getPath());
            } else {
                requestHeight.setUrl(imageInfo.f297365j.toString());
            }
            QQPicLoader.f201806a.e(requestHeight, new a());
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public e b(ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (e) iPatchRedirector.redirect((short) 7, (Object) this, (Object) viewGroup);
        }
        e eVar = new e(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.aik, viewGroup, false));
        if (QLog.isColorLevel()) {
            QLog.d("ImageItem", 2, "Image onCreateViewHolder. vh hash=", Integer.valueOf(eVar.hashCode()));
        }
        l(eVar.f297450f, eVar);
        l(eVar.f297451h, eVar);
        l(eVar.f297452i, eVar);
        if (this.f297478d.w() != 0) {
            eVar.itemView.setPadding(this.f297478d.w(), 0, this.f297478d.w(), 0);
        }
        return eVar;
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void e(View view, e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) eVar);
            return;
        }
        ImageInfo imageInfo = (ImageInfo) eVar.f297481d;
        int id5 = view.getId();
        if (id5 == R.id.d6z) {
            this.f297479e.b(eVar);
            return;
        }
        if (id5 == R.id.f165703d73) {
            if (imageInfo.f297417d == 2) {
                eVar.f297452i.setVisibility(4);
                m(imageInfo);
                return;
            }
            return;
        }
        if (id5 == R.id.f165700d70) {
            InputMethodUtil.hide((Activity) this.f297478d.getContext());
            if (QLog.isColorLevel()) {
                QLog.d("ImageItem", 2, "onItemViewClick preview. info position=", Integer.valueOf(imageInfo.f297409a), ", path=", imageInfo.f297361f);
            }
            ((ITroopHWApi) QRoute.api(ITroopHWApi.class)).showOnePicture((Activity) view.getContext(), imageInfo.k());
        }
    }

    public boolean x(XMediaEditor xMediaEditor, Intent intent, boolean z16, String str) {
        List<com.tencent.mobileqq.troop.homework.xmediaeditor.model.b> list;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, this, xMediaEditor, intent, Boolean.valueOf(z16), str)).booleanValue();
        }
        if (!((IHWTroopUIApi) QRoute.api(IHWTroopUIApi.class)).isSwitchOn()) {
            f s16 = s(intent, str);
            list = s16.f297455a;
            i3 = s16.f297456b;
        } else {
            f t16 = t(intent, str);
            list = t16.f297455a;
            i3 = t16.f297456b;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ImageItem", 2, "video selected! size = ", Integer.valueOf(i3), ". pic selected! size = ", Integer.valueOf(list.size() - i3));
        }
        Context context = xMediaEditor.getContext();
        if (!NetworkUtil.isNetSupport(context)) {
            if (QLog.isColorLevel()) {
                QLog.d("ImageItem", 2, "no network toast from select media");
            }
            QQToast.makeText(context, R.string.f171375ei3, 0).show();
            return z16;
        }
        if (i3 > 0 && !NetworkUtil.isWifiConnected(context)) {
            if (QLog.isColorLevel()) {
                QLog.d("ImageItem", 2, "no wifi. hasShownNetworkTip=", Boolean.valueOf(z16));
            }
            if (!z16) {
                DialogUtil.createCustomDialog(context, 230, xMediaEditor.getResources().getString(R.string.dfp), xMediaEditor.getResources().getString(R.string.dfm), R.string.d_2, R.string.d_d, new c(xMediaEditor, list), new d()).show();
                return true;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ImageItem", 2, "insertEditItemList.");
        }
        xMediaEditor.D(list);
        return z16;
    }

    public void z(ImageInfo imageInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) imageInfo);
            return;
        }
        try {
            if (imageInfo == null) {
                QLog.i("ImageItem", 1, "[releaseAnimRunnable] info = null");
                return;
            }
            RecyclerView.ViewHolder findViewHolderForLayoutPosition = this.f297478d.findViewHolderForLayoutPosition(imageInfo.f297409a);
            if (findViewHolderForLayoutPosition instanceof e) {
                ((e) findViewHolderForLayoutPosition).C.q(imageInfo.f297366k);
            }
        } catch (Exception e16) {
            QLog.e("ImageItem", 1, "[releaseAnimRunnable] info = " + imageInfo + ", exception = " + e16);
        }
    }
}
