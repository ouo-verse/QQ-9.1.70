package com.tencent.aelight.camera.aioeditor.capture.control;

import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.m;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.view.LbsFilterStatusManager;
import com.tencent.aelight.camera.aioeditor.capture.data.d;
import com.tencent.aelight.camera.aioeditor.capture.music.QIMMusicConfigManager;
import com.tencent.aelight.camera.aioeditor.capture.paster.PasterDataManager;
import com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.LinearGroup;
import com.tencent.mobileqq.app.automator.ParallGroup;
import com.tencent.mobileqq.app.automator.b;
import com.tencent.mobileqq.richmedia.g;
import common.config.service.QzoneConfig;
import fr.f;

/* compiled from: P */
/* loaded from: classes32.dex */
public class CaptureAsyncStepFactory {

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class CaptureLinearGroup extends LinearGroup {
        @Override // com.tencent.mobileqq.app.automator.StepGroup
        public AsyncStep g() {
            int i3 = this.f195315f;
            String[] strArr = this.f195316h;
            if (i3 >= strArr.length) {
                return null;
            }
            this.f195313d[i3] = CaptureAsyncStepFactory.a(this.mAutomator, strArr[i3]);
            AsyncStep[] asyncStepArr = this.f195313d;
            int i16 = this.f195315f;
            AsyncStep asyncStep = asyncStepArr[i16];
            asyncStep.mParams = this.mParams;
            this.f195315f = i16 + 1;
            return asyncStep;
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class CaptureParallGroup extends ParallGroup {
        @Override // com.tencent.mobileqq.app.automator.StepGroup
        public AsyncStep g() {
            int i3 = this.f195315f;
            String[] strArr = this.f195316h;
            if (i3 >= strArr.length) {
                return null;
            }
            this.f195313d[i3] = CaptureAsyncStepFactory.a(this.mAutomator, strArr[i3]);
            AsyncStep[] asyncStepArr = this.f195313d;
            int i16 = this.f195315f;
            AsyncStep asyncStep = asyncStepArr[i16];
            asyncStep.mParams = this.mParams;
            this.f195315f = i16 + 1;
            return asyncStep;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static AsyncStep a(b bVar, String str) {
        AsyncStep asyncStep;
        if (str != null) {
            str = str.trim();
        }
        if (TextUtils.isEmpty(str)) {
            ms.a.c("CaptureAsyncStepFactory", "step is empty");
            return new AsyncStep();
        }
        int i3 = -1;
        if (str.startsWith("{")) {
            CaptureLinearGroup captureLinearGroup = new CaptureLinearGroup();
            captureLinearGroup.f195314e = str;
            asyncStep = captureLinearGroup;
        } else if (str.startsWith("[")) {
            CaptureParallGroup captureParallGroup = new CaptureParallGroup();
            captureParallGroup.f195314e = str;
            asyncStep = captureParallGroup;
        } else {
            i3 = Integer.parseInt(str);
            switch (i3) {
                case 1000:
                    asyncStep = new AsyncStep() { // from class: com.tencent.aelight.camera.aioeditor.capture.control.CaptureAsyncStep$BindRichMediaClient
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.tencent.mobileqq.app.automator.AsyncStep
                        public int doStep() {
                            g.b().a(BaseApplicationImpl.sApplication);
                            return 7;
                        }
                    };
                    break;
                case 1001:
                    asyncStep = new CaptureAsyncStep$BindTroopMemberClient();
                    break;
                case 1002:
                    asyncStep = new AsyncStep() { // from class: com.tencent.aelight.camera.aioeditor.capture.control.CaptureAsyncStep$LoadQzoneConfig
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.tencent.mobileqq.app.automator.AsyncStep
                        public int doStep() {
                            QzoneConfig.getInstance().loadAllConfigs();
                            return 7;
                        }
                    };
                    break;
                case 1003:
                    asyncStep = new AsyncStep() { // from class: com.tencent.aelight.camera.aioeditor.capture.control.CaptureAsyncStep$InitTemplate
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.tencent.mobileqq.app.automator.AsyncStep
                        public int doStep() {
                            ((QIMPtvTemplateManager) f.c(3)).h();
                            QIMPtvTemplateManager.R = ((Integer) this.mParams[1]).intValue();
                            return 7;
                        }
                    };
                    break;
                case 1004:
                    asyncStep = new AsyncStep() { // from class: com.tencent.aelight.camera.aioeditor.capture.control.CaptureAsyncStep$InitCombo
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.tencent.mobileqq.app.automator.AsyncStep
                        public int doStep() {
                            LbsFilterStatusManager.h(fr.b.a());
                            d dVar = (d) f.c(5);
                            dVar.h();
                            dVar.I(false);
                            Object obj = this.mParams[0];
                            if (obj == null || !(obj instanceof m.c)) {
                                return 7;
                            }
                            ((m.c) obj).C2(false);
                            return 7;
                        }
                    };
                    break;
                case 1005:
                    asyncStep = new AsyncStep() { // from class: com.tencent.aelight.camera.aioeditor.capture.control.CaptureAsyncStep$InitPaster
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.tencent.mobileqq.app.automator.AsyncStep
                        public int doStep() {
                            LbsFilterStatusManager.h(fr.b.a());
                            PasterDataManager pasterDataManager = (PasterDataManager) f.d().g(4);
                            pasterDataManager.h();
                            pasterDataManager.m();
                            return 7;
                        }
                    };
                    break;
                case 1006:
                    asyncStep = new AsyncStep() { // from class: com.tencent.aelight.camera.aioeditor.capture.control.CaptureAsyncStep$InitMusic
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.tencent.mobileqq.app.automator.AsyncStep
                        public int doStep() {
                            com.tencent.aelight.camera.aioeditor.capture.music.g gVar = (com.tencent.aelight.camera.aioeditor.capture.music.g) f.d().g(8);
                            if (gVar != null) {
                                gVar.i();
                            }
                            ((QIMMusicConfigManager) f.c(2)).h();
                            return 7;
                        }
                    };
                    break;
                case 1007:
                    asyncStep = new AsyncStep() { // from class: com.tencent.aelight.camera.aioeditor.capture.control.CaptureAsyncStep$OnShowOther
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.tencent.mobileqq.app.automator.AsyncStep
                        public int doStep() {
                            com.tencent.aelight.camera.aioeditor.d dVar = (com.tencent.aelight.camera.aioeditor.d) f.c(13);
                            dVar.f(0);
                            dVar.p(2);
                            return 7;
                        }
                    };
                    break;
                case 1008:
                    asyncStep = new GetAllFullMusicInfoTask();
                    break;
                case 1009:
                    asyncStep = new UpdateAllFullMusicInfoTask();
                    break;
                case 1010:
                    asyncStep = new AsyncStep() { // from class: com.tencent.aelight.camera.aioeditor.capture.control.CaptureAsyncStep$InitLoadSegmentSo
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.tencent.mobileqq.app.automator.AsyncStep
                        public int doStep() {
                            try {
                                ms.a.c("IAutomator", "[InitLoadSegmentSo] isOK:false");
                                return 7;
                            } catch (Exception unused) {
                                ms.a.c("IAutomator", "[InitLoadSegmentSo] failed");
                                return 7;
                            }
                        }
                    };
                    break;
                default:
                    asyncStep = new AsyncStep();
                    break;
            }
        }
        asyncStep.mAutomator = bVar;
        asyncStep.mStepId = i3;
        if (i3 >= 0) {
            asyncStep.mName = asyncStep.getClass().getSimpleName();
        } else {
            asyncStep.mName = str;
        }
        return asyncStep;
    }
}
