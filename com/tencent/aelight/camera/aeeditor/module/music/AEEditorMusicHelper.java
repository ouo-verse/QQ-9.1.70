package com.tencent.aelight.camera.aeeditor.module.music;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.biz.videostory.video.FrameVideoHelper;
import com.tencent.mobileqq.activity.PreloadWebService;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qcircle.tavcut.session.TAVCutVideoSession;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEEditorMusicHelper {

    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicHelper$2, reason: invalid class name */
    /* loaded from: classes32.dex */
    class AnonymousClass2 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TAVCutVideoSession f66219d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f66220e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f66221f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f66222h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ long f66223i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ FrameVideoHelper.a f66224m;

        @Override // java.lang.Runnable
        public void run() {
            long j3;
            Throwable th5;
            ArrayList<FrameVideoHelper.FrameBuffer> arrayList = new ArrayList<>();
            long j16 = 0;
            try {
                TAVCutVideoSession tAVCutVideoSession = this.f66219d;
                if (tAVCutVideoSession == null) {
                    return;
                }
                List<Bitmap> multiVideoFrame = tAVCutVideoSession.getMultiVideoFrame(this.f66220e, (int) this.f66221f);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Iterator<Bitmap> it = multiVideoFrame.iterator();
                j3 = 0;
                while (true) {
                    try {
                        if (!it.hasNext()) {
                            break;
                        }
                        Bitmap next = it.next();
                        if (next != null) {
                            next.compress(Bitmap.CompressFormat.JPEG, (int) this.f66222h, byteArrayOutputStream);
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            j16 += byteArray.length;
                            if (j16 >= this.f66223i) {
                                ms.a.f("AEEditorMusicHelper", "[extractMultiCutFrameForSmartMusic] out of limit readBytes:" + j16 + ", frameCount:" + arrayList.size());
                                break;
                            }
                            j3 += byteArray.length;
                            arrayList.add(new FrameVideoHelper.FrameBuffer(byteArray));
                            byteArrayOutputStream.reset();
                        }
                    } catch (Throwable th6) {
                        th5 = th6;
                        ms.a.d("AEEditorMusicHelper", "FrameVideoHelper.start(), error=", th5);
                        FrameVideoHelper.a aVar = this.f66224m;
                        if (aVar != null) {
                            aVar.a(false, arrayList, j3);
                            return;
                        }
                        return;
                    }
                }
                FrameVideoHelper.a aVar2 = this.f66224m;
                if (aVar2 != null) {
                    aVar2.a(true, arrayList, j3);
                }
            } catch (Throwable th7) {
                j3 = 0;
                th5 = th7;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class MusicDownloadRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private AppRuntime f66225d;

        /* renamed from: e, reason: collision with root package name */
        private String f66226e;

        /* renamed from: f, reason: collision with root package name */
        private String f66227f;

        /* renamed from: h, reason: collision with root package name */
        private WeakReference<b> f66228h;

        @Override // java.lang.Runnable
        public void run() {
            AEEditorMusicHelper.a(this.f66225d, null, this.f66226e, this.f66227f, this.f66228h.get());
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface b {
        void a(AEEditorMusicAdapter$AEEditorMusicInfo aEEditorMusicAdapter$AEEditorMusicInfo, int i3);

        void b(AEEditorMusicAdapter$AEEditorMusicInfo aEEditorMusicAdapter$AEEditorMusicInfo, boolean z16, String str);
    }

    public static void a(AppRuntime appRuntime, AEEditorMusicAdapter$AEEditorMusicInfo aEEditorMusicAdapter$AEEditorMusicInfo, String str, String str2, b bVar) {
        ms.a.f("AEEditorMusicHelper", "[downloadMusic], url=" + str + ", localPath=" + str2);
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mReqUrl = str;
        httpNetReq.mHttpMethod = 0;
        httpNetReq.mOutPath = str2;
        httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
        httpNetReq.mExcuteTimeLimit = 30000L;
        httpNetReq.mCallback = new a(bVar, aEEditorMusicAdapter$AEEditorMusicInfo, str2);
        try {
            ((IHttpEngineService) appRuntime.getRuntimeService(IHttpEngineService.class, "all")).sendReq(httpNetReq);
        } catch (Exception e16) {
            ms.a.c("AEEditorMusicHelper", "[downloadMusic], error=" + e16);
        }
    }

    public static void b(Context context) {
        ms.a.f("AEEditorMusicHelper", "[preLoadWebView]");
        try {
            context.startService(new Intent(context, (Class<?>) PreloadWebService.class));
        } catch (Throwable th5) {
            ms.a.d("AEEditorMusicHelper", "[preLoadWebView], error=", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements INetEngineListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f66229d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f66230e;

        a(b bVar, AEEditorMusicAdapter$AEEditorMusicInfo aEEditorMusicAdapter$AEEditorMusicInfo, String str) {
            this.f66229d = bVar;
            this.f66230e = str;
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
            b bVar = this.f66229d;
            if (bVar != null) {
                bVar.a(null, (int) ((((float) j3) * 100.0f) / ((float) j16)));
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            boolean z16 = netResp != null && netResp.mResult == 0;
            ms.a.f("AEEditorMusicHelper", "[downloadMusic], onResp, succeeded=" + z16);
            b bVar = this.f66229d;
            if (bVar != null) {
                bVar.b(null, z16, this.f66230e);
            }
            if (netResp == null) {
                return;
            }
            com.tencent.aelight.camera.ae.report.b.b();
            throw null;
        }
    }
}
