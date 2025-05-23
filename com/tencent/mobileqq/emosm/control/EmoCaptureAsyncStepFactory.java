package com.tencent.mobileqq.emosm.control;

import android.text.TextUtils;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend;

/* compiled from: P */
/* loaded from: classes6.dex */
public class EmoCaptureAsyncStepFactory {

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class CaptureEmoLinearGroup extends EmoLinearGroup {
        @Override // com.tencent.mobileqq.emosm.control.EmoStepGroup
        public EmoAsyncStep n() {
            int i3 = this.I;
            String[] strArr = this.J;
            if (i3 < strArr.length) {
                this.G[i3] = EmoCaptureAsyncStepFactory.a(this.f204260h, strArr[i3]);
                EmoAsyncStep[] emoAsyncStepArr = this.G;
                int i16 = this.I;
                EmoAsyncStep emoAsyncStep = emoAsyncStepArr[i16];
                emoAsyncStep.E = this.E;
                this.I = i16 + 1;
                return emoAsyncStep;
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class CaptureEmoParallGroup extends EmoParallGroup {
        @Override // com.tencent.mobileqq.emosm.control.EmoStepGroup
        public EmoAsyncStep n() {
            int i3 = this.I;
            String[] strArr = this.J;
            if (i3 < strArr.length) {
                this.G[i3] = EmoCaptureAsyncStepFactory.a(this.f204260h, strArr[i3]);
                EmoAsyncStep[] emoAsyncStepArr = this.G;
                int i16 = this.I;
                EmoAsyncStep emoAsyncStep = emoAsyncStepArr[i16];
                emoAsyncStep.E = this.E;
                this.I = i16 + 1;
                return emoAsyncStep;
            }
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.tencent.mobileqq.emosm.control.EmoAsyncStep] */
    public static EmoAsyncStep a(EmoAutomator emoAutomator, String str) {
        EmoStepGroup emoStepGroup;
        if (str != null) {
            str = str.trim();
        }
        if (!TextUtils.isEmpty(str)) {
            int i3 = -1;
            if (str.startsWith("{")) {
                EmoStepGroup captureEmoLinearGroup = new CaptureEmoLinearGroup();
                captureEmoLinearGroup.H = str;
                emoStepGroup = captureEmoLinearGroup;
            } else if (str.startsWith("[")) {
                EmoStepGroup captureEmoParallGroup = new CaptureEmoParallGroup();
                captureEmoParallGroup.H = str;
                emoStepGroup = captureEmoParallGroup;
            } else {
                i3 = Integer.parseInt(str);
                if (i3 != 1000) {
                    emoStepGroup = new EmoAsyncStep();
                } else {
                    emoStepGroup = new CameraEmoAllSend();
                }
            }
            emoStepGroup.f204260h = emoAutomator;
            emoStepGroup.f204261i = i3;
            if (i3 >= 0) {
                emoStepGroup.f204262m = emoStepGroup.getClass().getSimpleName();
            } else {
                emoStepGroup.f204262m = str;
            }
            return emoStepGroup;
        }
        throw new RuntimeException("createStepGroup: " + str);
    }
}
