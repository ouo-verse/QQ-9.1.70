package com.tencent.aelight.camera.aioeditor.shortvideo;

import android.content.Context;
import com.tencent.mobileqq.videocodec.audio.AudioCapture;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.voicechanger.common.audio.VoiceTextRecognizer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    private static String f67596c = "wx7d02f7e92ea2884d";

    /* renamed from: a, reason: collision with root package name */
    private boolean f67597a;

    /* renamed from: b, reason: collision with root package name */
    private AudioCapture f67598b;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements VoiceTextRecognizer.VRErrorListener {
        a() {
        }

        @Override // com.tencent.ttpic.voicechanger.common.audio.VoiceTextRecognizer.VRErrorListener
        public void onError(int i3) {
            if (QLog.isColorLevel()) {
                QLog.e("ShortVideoVoiceRecognizer", 1, "VoiceTextRecognizer error! errorCode = " + i3);
            }
        }
    }

    public void a() {
        if (this.f67597a) {
            this.f67597a = false;
            this.f67598b.L(false);
            this.f67598b.C();
            VoiceTextRecognizer.getInstance().destroy();
        }
    }

    public void c(Context context, AudioCapture audioCapture) {
        this.f67597a = true;
        this.f67598b = audioCapture;
        VoiceTextRecognizer.setWxVoiceRecognizerAppid(f67596c);
        VoiceTextRecognizer.getInstance().init(context, false);
        VoiceTextRecognizer.getInstance().setVRErrorListener(new a());
        VoiceTextRecognizer.getInstance().start();
        audioCapture.L(true);
        audioCapture.D();
    }

    public void b(byte[] bArr, int i3, int i16) {
        ByteArrayOutputStream byteArrayOutputStream;
        if (!this.f67597a || i16 <= 0) {
            return;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, 0, i16);
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(Math.max((int) Math.ceil((i16 * 16000) / this.f67598b.z()), 1));
        try {
            byteArrayOutputStream = byteArrayOutputStream2;
            try {
                new md0.b(byteArrayInputStream, byteArrayOutputStream2, this.f67598b.z(), 16000, 2, 2, 1, i16, 0.0d, 0, true);
            } catch (Exception e16) {
                e = e16;
                e.printStackTrace();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                VoiceTextRecognizer.getInstance().recognizeFromPCMBuffer(byteArray, byteArray.length);
                byteArrayInputStream.close();
                byteArrayOutputStream.close();
            }
        } catch (Exception e17) {
            e = e17;
            byteArrayOutputStream = byteArrayOutputStream2;
        }
        byte[] byteArray2 = byteArrayOutputStream.toByteArray();
        VoiceTextRecognizer.getInstance().recognizeFromPCMBuffer(byteArray2, byteArray2.length);
        try {
            byteArrayInputStream.close();
            byteArrayOutputStream.close();
        } catch (Exception e18) {
            e18.printStackTrace();
        }
    }
}
