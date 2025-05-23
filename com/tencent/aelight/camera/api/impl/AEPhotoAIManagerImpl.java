package com.tencent.aelight.camera.api.impl;

import com.tencent.aelight.camera.aeeditor.manage.AEEditorResourceDownloader;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager;
import com.tencent.aelight.camera.api.IAEPhotoAIManager;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import ps.b;

/* loaded from: classes32.dex */
public class AEPhotoAIManagerImpl implements IAEPhotoAIManager {
    private static final String TAG = "AEPhotoAIManagerImpl";

    @Override // com.tencent.aelight.camera.api.IAEPhotoAIManager
    public void downloadPhotoAIRes() {
        AEEditorResourceManager.J().t();
    }

    @Override // com.tencent.aelight.camera.api.IAEPhotoAIManager
    public b getPhotoAIResult(String str) {
        return new b();
    }

    @Override // com.tencent.aelight.camera.api.IAEPhotoAIManager
    public boolean isPhotoAIResExist() {
        return AEEditorResourceManager.J().S();
    }

    protected static String parseLutBylutPath(String str) {
        if (str == null) {
            return null;
        }
        String str2 = str.split("\\.")[0];
        String K = AEEditorResourceManager.J().K(str2);
        ms.a.f(TAG, "parseLutBySceneLabel--select lut=" + str2 + ", path=" + K);
        if (K == null || !new File(K).exists()) {
            ms.a.f(TAG, "parseLutBySceneLabel--used lut not exists, id=" + str2);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            boolean[] zArr = new boolean[1];
            AEEditorResourceManager.J().d(str2, new a(zArr, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e16) {
                e16.printStackTrace();
            }
            if (zArr[0]) {
                ms.a.f(TAG, "parseLutBySceneLabel--download SUCCESS");
            } else {
                ms.a.f(TAG, "parseLutBySceneLabel--download FAIL");
                return null;
            }
        }
        return K;
    }

    /* loaded from: classes32.dex */
    class a implements AEEditorResourceDownloader.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean[] f68985a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f68986b;

        a(boolean[] zArr, CountDownLatch countDownLatch) {
            this.f68985a = zArr;
            this.f68986b = countDownLatch;
        }

        @Override // com.tencent.aelight.camera.aeeditor.manage.AEEditorResourceDownloader.c
        public void onDownloadFinish(boolean z16) {
            this.f68985a[0] = z16;
            this.f68986b.countDown();
        }

        @Override // com.tencent.aelight.camera.aeeditor.manage.AEEditorResourceDownloader.c
        public void onProgressUpdate(int i3) {
        }
    }
}
