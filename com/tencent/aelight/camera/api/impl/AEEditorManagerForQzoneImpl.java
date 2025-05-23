package com.tencent.aelight.camera.api.impl;

import android.content.Context;
import android.os.Bundle;
import ar.f;
import com.tencent.aelight.camera.ae.camera.core.AEEditorManagerForQzone;
import com.tencent.aelight.camera.ae.d;
import com.tencent.aelight.camera.ae.play.AECoverSelectFragment;
import com.tencent.aelight.camera.ae.play.AEVideoPreviewFragment;
import com.tencent.aelight.camera.api.IAEEditorGenerateResultListener;
import com.tencent.aelight.camera.api.IAEEditorManagerForQzone;
import com.tencent.aelight.camera.api.IAEEditorUICallbackListener;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import gq.c;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEEditorManagerForQzoneImpl implements IAEEditorManagerForQzone {
    private ConcurrentHashMap<IAEEditorGenerateResultListener, a> mResultListenerMaps = new ConcurrentHashMap<>();
    private ConcurrentHashMap<IAEEditorUICallbackListener, b> mUICallbackMaps = new ConcurrentHashMap<>();

    /* compiled from: P */
    /* loaded from: classes32.dex */
    static class a implements IAEEditorGenerateResultListener {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<IAEEditorGenerateResultListener> f68983a;

        public a(IAEEditorGenerateResultListener iAEEditorGenerateResultListener) {
            this.f68983a = new WeakReference<>(iAEEditorGenerateResultListener);
        }

        @Override // com.tencent.aelight.camera.api.IAEEditorGenerateResultListener
        public void onAETavSessionExportCompleted(String str, LocalMediaInfo localMediaInfo) {
            WeakReference<IAEEditorGenerateResultListener> weakReference = this.f68983a;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f68983a.get().onAETavSessionExportCompleted(str, localMediaInfo);
        }

        @Override // com.tencent.aelight.camera.api.IAEEditorGenerateResultListener
        public void onAETavSessionExportError(String str, long j3, String str2) {
            WeakReference<IAEEditorGenerateResultListener> weakReference = this.f68983a;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f68983a.get().onAETavSessionExportError(str, j3, str2);
        }

        @Override // com.tencent.aelight.camera.api.IAEEditorGenerateResultListener
        public void onAETavSessionExporting(String str, float f16, LocalMediaInfo localMediaInfo, float f17) {
            WeakReference<IAEEditorGenerateResultListener> weakReference = this.f68983a;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f68983a.get().onAETavSessionExporting(str, f16, localMediaInfo, f17);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    static class b implements IAEEditorUICallbackListener {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<IAEEditorUICallbackListener> f68984a;

        public b(IAEEditorUICallbackListener iAEEditorUICallbackListener) {
            this.f68984a = new WeakReference<>(iAEEditorUICallbackListener);
        }

        @Override // com.tencent.aelight.camera.api.IAEEditorUICallbackListener
        public void deleteMedia(int i3) {
            WeakReference<IAEEditorUICallbackListener> weakReference = this.f68984a;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f68984a.get().deleteMedia(i3);
        }
    }

    @Override // com.tencent.aelight.camera.api.IAEEditorManagerForQzone
    public void addListener(IAEEditorGenerateResultListener iAEEditorGenerateResultListener) {
        a aVar = new a(iAEEditorGenerateResultListener);
        AEEditorManagerForQzone.getInstance().addListener(aVar);
        this.mResultListenerMaps.put(iAEEditorGenerateResultListener, aVar);
    }

    @Override // com.tencent.aelight.camera.api.IAEEditorManagerForQzone
    public void addUICallbackListener(IAEEditorUICallbackListener iAEEditorUICallbackListener) {
        b bVar = new b(iAEEditorUICallbackListener);
        AEEditorManagerForQzone.getInstance().addUICallbackListener(bVar);
        this.mUICallbackMaps.put(iAEEditorUICallbackListener, bVar);
    }

    @Override // com.tencent.aelight.camera.api.IAEEditorManagerForQzone
    public void cancelMission(String str) {
        AEEditorManagerForQzone.getInstance().cancelMission(str);
    }

    @Override // com.tencent.aelight.camera.api.IAEEditorManagerForQzone
    public void cancelQFSMission(String str) {
        AEEditorManagerForQzone.getInstance().cancelQFSMission(str);
    }

    @Override // com.tencent.aelight.camera.api.IAEEditorManagerForQzone
    public boolean checkAEResVersionOKForAEBasePackage() {
        return ((IAEResUtil) QRoute.api(IAEResUtil.class)).checkAEResVersionOK(AEResInfo.AE_RES_BASE_PACKAGE);
    }

    @Override // com.tencent.aelight.camera.api.IAEEditorManagerForQzone
    public void forceQFSMission(String str) {
        AEEditorManagerForQzone.getInstance().forceQFSMission(str);
    }

    @Override // com.tencent.aelight.camera.api.IAEEditorManagerForQzone
    public Class getAECoverSelectFragmentClass() {
        return AECoverSelectFragment.class;
    }

    @Override // com.tencent.aelight.camera.api.IAEEditorManagerForQzone
    public Class getAEVideoPreviewFragmentClass() {
        return AEVideoPreviewFragment.class;
    }

    @Override // com.tencent.aelight.camera.api.IAEEditorManagerForQzone
    public LocalMediaInfo getMissionInfo(String str) {
        return AEEditorManagerForQzone.getInstance().getMissionInfo(str);
    }

    @Override // com.tencent.aelight.camera.api.IAEEditorManagerForQzone
    public void init() {
        AEEditorManagerForQzone.getInstance().init();
    }

    @Override // com.tencent.aelight.camera.api.IAEEditorManagerForQzone
    public boolean isAEKitForQQInit() {
        return d.j();
    }

    @Override // com.tencent.aelight.camera.api.IAEEditorManagerForQzone
    public boolean isCameraResReady() {
        return c.e(QQWinkConstants.ENTRY_QQ_OTHER, false);
    }

    @Override // com.tencent.aelight.camera.api.IAEEditorManagerForQzone
    public void launchAEMutiCamera(Context context, Bundle bundle) {
        c.r(context, bundle);
    }

    @Override // com.tencent.aelight.camera.api.IAEEditorManagerForQzone
    public void removeCallbackListener(IAEEditorUICallbackListener iAEEditorUICallbackListener) {
        AEEditorManagerForQzone.getInstance().removeCallbackListener(iAEEditorUICallbackListener);
    }

    @Override // com.tencent.aelight.camera.api.IAEEditorManagerForQzone
    public void removeListener(IAEEditorGenerateResultListener iAEEditorGenerateResultListener) {
        if (this.mResultListenerMaps.get(iAEEditorGenerateResultListener) != null) {
            AEEditorManagerForQzone.getInstance().removeListener(this.mResultListenerMaps.get(iAEEditorGenerateResultListener));
            this.mResultListenerMaps.remove(iAEEditorGenerateResultListener);
        }
    }

    @Override // com.tencent.aelight.camera.api.IAEEditorManagerForQzone
    public void removeUICallbackListener(IAEEditorUICallbackListener iAEEditorUICallbackListener) {
        if (this.mUICallbackMaps.get(iAEEditorUICallbackListener) != null) {
            AEEditorManagerForQzone.getInstance().removeCallbackListener(this.mUICallbackMaps.get(iAEEditorUICallbackListener));
            this.mUICallbackMaps.remove(iAEEditorUICallbackListener);
        }
    }

    @Override // com.tencent.aelight.camera.api.IAEEditorManagerForQzone
    public void requestGenerateVideo(String str) {
        f.g().l(str);
    }

    @Override // com.tencent.aelight.camera.api.IAEEditorManagerForQzone
    public void retryMission(String str) {
        AEEditorManagerForQzone.getInstance().retryMission(str);
    }

    @Override // com.tencent.aelight.camera.api.IAEEditorManagerForQzone
    public void retryQFSMission(String str) {
        AEEditorManagerForQzone.getInstance().retryQFSMission(str);
    }

    @Override // com.tencent.aelight.camera.api.IAEEditorManagerForQzone
    public void saveMission(String str) {
        AEEditorManagerForQzone.getInstance().saveMission(str);
    }
}
