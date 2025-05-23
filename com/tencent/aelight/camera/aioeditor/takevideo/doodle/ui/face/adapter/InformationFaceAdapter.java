package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tencent.aelight.camera.aioeditor.capture.paster.QIMInformationPasterManager;
import com.tencent.aelight.camera.aioeditor.capture.util.f;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMCommonLoadingView;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicActivity;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.FaceListPage;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.b;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IOldHttpEngineProcessor;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import hr.d;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;

/* compiled from: P */
/* loaded from: classes32.dex */
public class InformationFaceAdapter extends com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.b<hr.d> implements View.OnClickListener {

    /* renamed from: m, reason: collision with root package name */
    private b.a<String, Drawable> f68518m;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class DownloadProgressCallback implements QIMInformationPasterManager.b {

        /* renamed from: a, reason: collision with root package name */
        private QIMCommonLoadingView f68520a;

        /* renamed from: b, reason: collision with root package name */
        private Boolean f68521b;

        DownloadProgressCallback(QIMCommonLoadingView qIMCommonLoadingView, ImageView imageView) {
            this.f68520a = qIMCommonLoadingView;
            this.f68521b = (Boolean) imageView.getTag(R.id.jai);
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.paster.QIMInformationPasterManager.b
        public void b(final boolean z16, String str, final d.c cVar) {
            if (QLog.isColorLevel()) {
                QLog.d("InformationFaceAdapter", 2, "isSuccess:" + z16);
            }
            this.f68520a.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.DownloadProgressCallback.2
                @Override // java.lang.Runnable
                public void run() {
                    DownloadProgressCallback.this.f68520a.setVisibility(8);
                    if (z16) {
                        DownloadProgressCallback downloadProgressCallback = DownloadProgressCallback.this;
                        InformationFaceAdapter.this.j(downloadProgressCallback.f68521b, cVar);
                    } else {
                        QQToast.makeText(DownloadProgressCallback.this.f68520a.getContext(), 0, HardCodeUtil.qqStr(R.string.f172109nf3), 0).show();
                    }
                    DownloadProgressCallback.this.e();
                }
            });
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.paster.QIMInformationPasterManager.b
        public void a(float f16, String str, int i3) {
            final int i16 = (int) f16;
            this.f68520a.post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.DownloadProgressCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    DownloadProgressCallback.this.f68520a.setVisibility(0);
                    DownloadProgressCallback.this.f68520a.setProgress(i16);
                    if (QLog.isColorLevel()) {
                        QLog.d("InformationFaceAdapter", 2, "progress:" + i16);
                    }
                }
            });
        }

        public void e() {
            this.f68520a = null;
            this.f68521b = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private static class InformationItemLayout extends LinearLayout {
        private com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.b C;

        /* renamed from: d, reason: collision with root package name */
        private int f68528d;

        /* renamed from: e, reason: collision with root package name */
        private int f68529e;

        /* renamed from: f, reason: collision with root package name */
        private float f68530f;

        /* renamed from: h, reason: collision with root package name */
        private int f68531h;

        /* renamed from: i, reason: collision with root package name */
        private View.OnClickListener f68532i;

        /* renamed from: m, reason: collision with root package name */
        private Context f68533m;

        public InformationItemLayout(Context context, int i3, int i16, float f16, View.OnClickListener onClickListener, com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.b bVar) {
            super(context);
            this.f68533m = context;
            this.f68532i = onClickListener;
            this.f68528d = i3;
            this.f68529e = i16;
            this.f68530f = f16;
            this.C = bVar;
            int a16 = zr.a.a(getContext(), 6.0f);
            int i17 = this.f68528d;
            int i18 = this.f68529e;
            this.f68531h = (i17 - (((i18 - 1) * 2) * a16)) / i18;
            d();
        }

        private URLDrawable c(d.c cVar) throws MalformedURLException {
            String b16 = com.tencent.aelight.camera.aioeditor.capture.util.c.b();
            String str = cVar.f406024c + "_static.png";
            File file = new File(b16);
            if (file.exists()) {
                if (!file.isDirectory()) {
                    file.delete();
                }
            } else {
                file.mkdirs();
            }
            File file2 = new File(file, str);
            if (QLog.isColorLevel()) {
                QLog.d("InformationFaceAdapter", 2, "static file name:" + file2.getAbsolutePath());
            }
            URL url = new URL(cVar.f406027f);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.Recycle();
            Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
            obtain.mFailedDrawable = drawable;
            obtain.mLoadingDrawable = drawable;
            return URLDrawable.getDrawable(url, obtain);
        }

        private void d() {
            setOrientation(0);
            setGravity(17);
            int a16 = zr.a.a(getContext(), 12.0f);
            int i3 = (int) ((this.f68531h - (a16 * 2)) * this.f68530f);
            for (int i16 = 0; i16 < this.f68529e; i16++) {
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.b6t, (ViewGroup) null);
                int i17 = this.f68531h;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i17, i17);
                if (i16 == 0) {
                    layoutParams.setMargins(0, a16, a16 / 2, 0);
                } else if (this.f68529e - 1 == i16) {
                    layoutParams.setMargins(a16 / 2, a16, 0, 0);
                } else {
                    int i18 = a16 / 2;
                    layoutParams.setMargins(i18, a16, i18, 0);
                }
                inflate.setLayoutParams(layoutParams);
                ((ImageView) inflate.findViewById(R.id.dlw)).setPadding(i3, i3, i3, i3);
                addView(inflate);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x00ea  */
        /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void b(d.c cVar, URLImageView uRLImageView, QIMCommonLoadingView qIMCommonLoadingView, ProgressBar progressBar, final b bVar, final boolean z16, com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.b bVar2) throws MalformedURLException {
            boolean z17;
            String b16 = com.tencent.aelight.camera.aioeditor.capture.util.c.b();
            String str = cVar.f406024c + "_dynamic.png";
            File file = new File(b16);
            if (file.exists()) {
                if (!file.isDirectory()) {
                    file.delete();
                }
            } else {
                file.mkdirs();
            }
            final File file2 = new File(file, str);
            if (QLog.isColorLevel()) {
                QLog.d("InformationFaceAdapter", 2, "apng file name:" + file2.getAbsolutePath());
            }
            final String absolutePath = file2.getAbsolutePath();
            if (file2.exists()) {
                try {
                    z17 = ApngDrawable.isApngFile(file2);
                    try {
                        if (z17) {
                            try {
                                URLDrawable apngDrawable = VasApngUtil.getApngDrawable(BaseApplicationImpl.sApplication.getRuntime(), file2.getAbsolutePath(), "-Dynamic-", com.tencent.mobileqq.urldrawable.b.f306350a, new int[]{13}, "-Dynamic-", null);
                                if (apngDrawable != null) {
                                    if (apngDrawable.getStatus() != 1) {
                                        apngDrawable.restartDownload();
                                    }
                                    if (apngDrawable.getStatus() == 1) {
                                        bVar.onLoadSuccessed(uRLImageView, apngDrawable);
                                    }
                                    if (!z16) {
                                        apngDrawable = null;
                                    }
                                    uRLImageView.setImageDrawable(apngDrawable);
                                }
                            } catch (IOException e16) {
                                e = e16;
                                e.printStackTrace();
                                if (z17) {
                                }
                            }
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.d("InformationFaceAdapter", 2, "apng invalid file:" + file2.getAbsolutePath());
                            }
                            file2.delete();
                        }
                    } catch (IOException e17) {
                        e = e17;
                    }
                } catch (IOException e18) {
                    e = e18;
                    z17 = false;
                }
            } else {
                z17 = false;
            }
            if (z17) {
                final WeakReference weakReference = new WeakReference(uRLImageView);
                final WeakReference weakReference2 = new WeakReference(qIMCommonLoadingView);
                final mqq.util.WeakReference weakReference3 = new mqq.util.WeakReference(progressBar);
                new WeakReference(bVar2);
                String str2 = cVar.f406026e;
                HttpNetReq httpNetReq = new HttpNetReq();
                httpNetReq.mCallback = new INetEngineListener() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.InformationItemLayout.1
                    @Override // com.tencent.mobileqq.transfile.INetEngineListener
                    public void onResp(NetResp netResp) {
                        String str3 = ((d.c) netResp.mReq.getUserData()).f406029h;
                        if (QLog.isColorLevel()) {
                            QLog.d("InformationFaceAdapter", 2, "onResp ,url is :" + str3 + " http status:" + netResp.mHttpCode);
                        }
                        final boolean z18 = false;
                        if (netResp.mHttpCode == 200 && file2.exists()) {
                            try {
                                if (ApngDrawable.isApngFile(file2)) {
                                    z18 = true;
                                } else {
                                    file2.delete();
                                    if (QLog.isColorLevel()) {
                                        QLog.d("InformationFaceAdapter", 2, "onResp ,valid apng file");
                                    }
                                }
                            } catch (IOException e19) {
                                e19.printStackTrace();
                            }
                        }
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.InformationItemLayout.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                QIMCommonLoadingView qIMCommonLoadingView2 = (QIMCommonLoadingView) weakReference2.get();
                                ImageView imageView = (ImageView) weakReference.get();
                                if (qIMCommonLoadingView2 != null && imageView != null) {
                                    qIMCommonLoadingView2.setVisibility(8);
                                    imageView.setVisibility(0);
                                    if (z18) {
                                        URLDrawable apngDrawable2 = VasApngUtil.getApngDrawable(BaseApplicationImpl.sApplication.getRuntime(), absolutePath, "-Dynamic-", null, new int[]{13}, "-Dynamic-", null);
                                        if (apngDrawable2 != null) {
                                            imageView.setImageDrawable(z16 ? apngDrawable2 : null);
                                            imageView.setTag(R.id.jai, Boolean.TRUE);
                                            if (apngDrawable2.getStatus() != 1) {
                                                apngDrawable2.restartDownload();
                                            }
                                            if (apngDrawable2.getStatus() == 1) {
                                                bVar.onLoadSuccessed(imageView, apngDrawable2);
                                            }
                                            if (!z16) {
                                                apngDrawable2 = null;
                                            }
                                            imageView.setImageDrawable(apngDrawable2);
                                            return;
                                        }
                                        return;
                                    }
                                    imageView.setImageDrawable(com.tencent.mobileqq.urldrawable.b.f306350a);
                                    return;
                                }
                                QLog.d("InformationFaceAdapter", 1, "onResp() weak reference view is recycle");
                            }
                        });
                    }

                    @Override // com.tencent.mobileqq.transfile.INetEngineListener
                    public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
                        final int i3 = (int) ((j3 * 100) / j16);
                        if (QLog.isColorLevel()) {
                            QLog.d("InformationFaceAdapter", 2, "apng percent:" + i3);
                        }
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.InformationItemLayout.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                QIMCommonLoadingView qIMCommonLoadingView2 = (QIMCommonLoadingView) weakReference2.get();
                                ProgressBar progressBar2 = (ProgressBar) weakReference3.get();
                                ImageView imageView = (ImageView) weakReference.get();
                                if (qIMCommonLoadingView2 != null && progressBar2 != null && imageView != null) {
                                    if (qIMCommonLoadingView2.getVisibility() == 8) {
                                        progressBar2.setVisibility(8);
                                        qIMCommonLoadingView2.setProgress(0L);
                                        qIMCommonLoadingView2.setVisibility(0);
                                        imageView.setVisibility(8);
                                    }
                                    qIMCommonLoadingView2.setProgress(i3);
                                    return;
                                }
                                QLog.d("InformationFaceAdapter", 1, "onUpdateProgeress() weak reference view is recycle");
                            }
                        });
                    }
                };
                httpNetReq.mReqUrl = str2;
                if (QLog.isColorLevel()) {
                    QLog.d("InformationFaceAdapter", 2, "apng url:" + str2);
                }
                httpNetReq.mHttpMethod = 0;
                httpNetReq.mOutPath = file2.getAbsolutePath();
                httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
                httpNetReq.setUserData(cVar);
                ((IOldHttpEngineProcessor) QRoute.api(IOldHttpEngineProcessor.class)).sendReq(httpNetReq);
            }
        }

        private void e(int i3) {
            for (int i16 = 0; i16 < i3 && i16 < getChildCount(); i16++) {
                getChildAt(i16).setVisibility(0);
            }
            while (i3 < this.f68529e && i3 < getChildCount()) {
                getChildAt(i3).setVisibility(4);
                i3++;
            }
        }

        public void a(hr.d dVar, int i3, int i16, boolean z16) throws MalformedURLException {
            String d16;
            int i17 = this.f68529e;
            int i18 = i3 * i17;
            int b16 = i3 == i16 + (-1) ? dVar.b() : i18 + i17;
            e(b16 - i18);
            for (int i19 = i18; i19 < b16; i19++) {
                View childAt = getChildAt(i19 - i18);
                View findViewById = childAt.findViewById(R.id.dly);
                URLImageView uRLImageView = (URLImageView) childAt.findViewById(R.id.dlw);
                ProgressBar progressBar = (ProgressBar) childAt.findViewById(R.id.dlx);
                QIMCommonLoadingView qIMCommonLoadingView = (QIMCommonLoadingView) childAt.findViewById(R.id.dlv);
                if (this.f68533m instanceof EditPicActivity) {
                    d16 = dVar.i(i19);
                } else {
                    d16 = dVar.d(i19);
                }
                if (d16 == null) {
                    hd0.c.i("InformationFaceAdapter", "FacePackage's thumbUri is empty , pkg : %s", dVar.toString());
                } else {
                    findViewById.setOnClickListener(this.f68532i);
                    uRLImageView.setTag(R.id.f166944jb1, Integer.valueOf(i19));
                    if (!z16) {
                        progressBar.setVisibility(4);
                        uRLImageView.setImageDrawable(null);
                    } else {
                        uRLImageView.setTag(R.id.jb9, d16);
                        uRLImageView.setTag(R.id.jai, Boolean.FALSE);
                        progressBar.setVisibility(0);
                        b bVar = new b(d16, uRLImageView, progressBar);
                        uRLImageView.setURLDrawableDownListener(bVar);
                        if (this.f68533m instanceof EditPicActivity) {
                            URLDrawable c16 = c(dVar.f406011n.get(i19));
                            if (c16 != null) {
                                if (c16.getStatus() != 1) {
                                    c16.restartDownload();
                                }
                                if (c16.getStatus() == 1) {
                                    bVar.onLoadSuccessed(uRLImageView, c16);
                                }
                                uRLImageView.setImageDrawable(z16 ? c16 : null);
                            }
                        } else {
                            b(dVar.f406011n.get(i19), uRLImageView, qIMCommonLoadingView, progressBar, bVar, z16, this.C);
                        }
                    }
                }
            }
        }
    }

    public InformationFaceAdapter(Context context, FaceListPage faceListPage) {
        super(context, faceListPage);
        this.f68518m = new b.a<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Drawable drawable, String str, String str2, int i3) {
        vr.a aVar = new vr.a(((hr.d) this.f68564e).f405989b, str2, drawable, i3);
        f.a a16 = f.a();
        this.f68565f.d(aVar, a16.f67202a, a16.f67203b, (float) ((hr.d) this.f68564e).f405998k, str, null);
    }

    private void i(d.c cVar) {
        String str;
        int i3;
        String str2;
        String c16 = com.tencent.aelight.camera.aioeditor.capture.util.c.c(cVar);
        if (this.f68563d instanceof EditPicActivity) {
            str = ".bpng";
            i3 = 0;
        } else {
            str = ".apng";
            i3 = 1;
        }
        if (cVar.f406025d == 8) {
            int i16 = Calendar.getInstance().get(7) - 1;
            str2 = c16 + File.separator + (i16 != 0 ? i16 : 7) + str;
        } else {
            str2 = c16 + File.separator + "city" + str;
        }
        Drawable c17 = this.f68518m.c(str2);
        if (c17 == null) {
            if (i3 != 1) {
                Bitmap decodeFile = BitmapFactory.decodeFile(str2);
                if (decodeFile == null) {
                    if (QLog.isColorLevel()) {
                        QLog.e("InformationFaceAdapter", 2, "InformationFaceAdapter decodeFile path:" + str2 + ",bitmap is null");
                    }
                    k(str2);
                    return;
                }
                decodeFile.setDensity(this.f68563d.getResources().getDisplayMetrics().densityDpi);
                c17 = new BitmapDrawable(this.f68563d.getResources(), decodeFile);
            } else {
                URLDrawable apngDrawable = VasApngUtil.getApngDrawable(BaseApplicationImpl.sApplication.getRuntime(), str2, "-Dynamic-", null, new int[]{13}, "-Dynamic-", null);
                if (apngDrawable != null) {
                    int status = apngDrawable.getStatus();
                    if (status != 1) {
                        if (QLog.isColorLevel()) {
                            QLog.e("InformationFaceAdapter", 2, "urlDrawable is not  SUCCESSED :" + status);
                        }
                        if (status == 2) {
                            apngDrawable.restartDownload();
                        } else {
                            apngDrawable.startDownload();
                        }
                        apngDrawable.setURLDrawableListener(new a(str2, cVar));
                    } else {
                        c17 = apngDrawable;
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d("InformationFaceAdapter", 2, "urlDrawable apng error");
                }
            }
            if (c17 != null) {
                this.f68518m.a(str2, c17);
            }
        } else {
            this.f68518m.b();
        }
        if (c17 != null) {
            c17.setBounds(0, 0, c17.getIntrinsicWidth(), c17.getIntrinsicHeight());
            h(c17, str2, cVar.f406024c, i3);
        } else {
            hd0.c.g("InformationFaceAdapter", "can create drawable from path:" + str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(final String str) {
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                FileUtils.delete(new File(str).getParentFile().getParentFile().getPath(), false);
            }
        });
        QQToast.makeText(this.f68563d, 0, HardCodeUtil.qqStr(R.string.f172110nf4), 0).show();
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        InformationItemLayout informationItemLayout;
        View view2;
        if (this.f68564e == 0) {
            view2 = view;
        } else {
            if (view == null) {
                informationItemLayout = new InformationItemLayout(this.f68563d, viewGroup.getWidth(), ((hr.d) this.f68564e).a(), ((hr.d) this.f68564e).c(), this, this);
            } else {
                informationItemLayout = (InformationItemLayout) view;
            }
            try {
                informationItemLayout.a((hr.d) this.f68564e, i3, getCount(), a());
                view2 = informationItemLayout;
            } catch (MalformedURLException e16) {
                e16.printStackTrace();
                view2 = informationItemLayout;
            }
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.dlw);
        QIMCommonLoadingView qIMCommonLoadingView = (QIMCommonLoadingView) view.findViewById(R.id.dlv);
        int intValue = ((Integer) imageView.getTag(R.id.f166944jb1)).intValue();
        d.c cVar = ((hr.d) this.f68564e).f406011n.get(intValue);
        Boolean bool = (Boolean) imageView.getTag(R.id.jai);
        QIMInformationPasterManager qIMInformationPasterManager = (QIMInformationPasterManager) fr.f.d().g(12);
        if (qIMInformationPasterManager.k(cVar)) {
            j(bool, cVar);
        } else if (NetworkUtil.isNetworkAvailable(view.getContext())) {
            qIMInformationPasterManager.n(((hr.d) this.f68564e).f406011n.get(intValue), new DownloadProgressCallback(qIMCommonLoadingView, imageView));
        } else {
            QQToast.makeText(view.getContext(), 0, HardCodeUtil.qqStr(R.string.nf6), 0).show();
        }
        id0.a.m((Activity) view.getContext(), "sticker_element", ((hr.d) this.f68564e).f405988a, cVar.f406023b);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class b implements URLDrawableDownListener {

        /* renamed from: d, reason: collision with root package name */
        private final String f68547d;

        /* renamed from: e, reason: collision with root package name */
        private final WeakReference<ImageView> f68548e;

        /* renamed from: f, reason: collision with root package name */
        private final WeakReference<ProgressBar> f68549f;

        public b(String str, ImageView imageView, ProgressBar progressBar) {
            this.f68547d = str;
            this.f68548e = new WeakReference<>(imageView);
            this.f68549f = new WeakReference<>(progressBar);
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadCancelled(View view, URLDrawable uRLDrawable) {
            hd0.c.a("InformationFaceAdapter", "onLoadCanceled,url:" + this.f68547d);
            ImageView imageView = this.f68548e.get();
            ProgressBar progressBar = this.f68549f.get();
            if (imageView != null && progressBar != null && a(imageView)) {
                progressBar.setVisibility(4);
                imageView.setTag(R.id.jai, Boolean.FALSE);
            } else {
                hd0.c.a("InformationFaceAdapter", "onLoadCanceled error.");
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadFailed(View view, URLDrawable uRLDrawable, Throwable th5) {
            hd0.c.a("InformationFaceAdapter", "onLoadFialed,url:" + this.f68547d);
            ImageView imageView = this.f68548e.get();
            ProgressBar progressBar = this.f68549f.get();
            if (imageView != null && progressBar != null && a(imageView)) {
                progressBar.setVisibility(0);
                imageView.setTag(R.id.jai, Boolean.FALSE);
            } else {
                hd0.c.a("InformationFaceAdapter", "onLoadFialed error.");
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadProgressed(View view, URLDrawable uRLDrawable, int i3) {
            hd0.c.a("InformationFaceAdapter", "onLoadProgressed,url:" + this.f68547d);
            ImageView imageView = this.f68548e.get();
            ProgressBar progressBar = this.f68549f.get();
            if (imageView != null && progressBar != null && a(imageView)) {
                progressBar.setVisibility(0);
                imageView.setTag(R.id.jai, Boolean.FALSE);
            } else {
                hd0.c.a("InformationFaceAdapter", "onLoadProgressed error.");
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadSuccessed(View view, URLDrawable uRLDrawable) {
            hd0.c.a("InformationFaceAdapter", "onLoadSuccessed,url:" + this.f68547d);
            ImageView imageView = this.f68548e.get();
            ProgressBar progressBar = this.f68549f.get();
            if (imageView != null && progressBar != null && a(imageView)) {
                progressBar.setVisibility(4);
                imageView.setTag(R.id.jai, Boolean.TRUE);
            } else {
                hd0.c.a("InformationFaceAdapter", "onLoadSuccessed error.");
            }
        }

        private boolean a(ImageView imageView) {
            String str = (String) imageView.getTag(R.id.jb9);
            return !TextUtils.isEmpty(str) && str.equals(this.f68547d);
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadInterrupted(View view, URLDrawable uRLDrawable, InterruptedException interruptedException) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Boolean bool, d.c cVar) {
        if (bool == null || !bool.booleanValue()) {
            return;
        }
        int i3 = cVar.f406025d;
        if (i3 == 8) {
            i(cVar);
            return;
        }
        if (hr.c.e(i3) && "default".equals(((hr.d) this.f68564e).f406013p)) {
            QQToast.makeText(BaseApplication.getContext(), R.string.f211605l_, 0).show();
            return;
        }
        float f16 = (float) ((hr.d) this.f68564e).f405998k;
        f.a a16 = f.a();
        this.f68565f.a(cVar, null, a16.f67202a, a16.f67203b, f16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f68544d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ d.c f68545e;

        a(String str, d.c cVar) {
            this.f68544d = str;
            this.f68545e = cVar;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            hd0.c.a("InformationFaceAdapter", "applyNormalPaster onLoadFialed path:" + this.f68544d);
            InformationFaceAdapter.this.k(this.f68544d);
            uRLDrawable.setURLDrawableListener(null);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            hd0.c.a("InformationFaceAdapter", "applyNormalPaster onLoadSuccessed path:" + this.f68544d);
            uRLDrawable.setBounds(0, 0, uRLDrawable.getIntrinsicWidth(), uRLDrawable.getIntrinsicHeight());
            InformationFaceAdapter.this.f68518m.a(this.f68544d, uRLDrawable);
            InformationFaceAdapter.this.h(uRLDrawable, this.f68544d, this.f68545e.f406024c, 1);
            uRLDrawable.setURLDrawableListener(null);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }
}
