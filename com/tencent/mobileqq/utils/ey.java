package com.tencent.mobileqq.utils;

import com.tencent.qphone.base.util.QLog;
import com.wx.voice.vad.Utils;
import com.wx.voice.vad.WXVad;
import com.wx.voice.vad.WXVadData;
import com.wx.voice.vad.WXVadParam;
import com.wx.voice.vad.WXVadSeg;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ey {

    /* renamed from: a, reason: collision with root package name */
    private WXVad f307759a;

    /* renamed from: b, reason: collision with root package name */
    private AtomicBoolean f307760b = new AtomicBoolean();

    /* renamed from: c, reason: collision with root package name */
    public boolean f307761c = false;

    static {
        System.loadLibrary("wx-asr-vad");
    }

    private WXVadParam a() {
        WXVadParam wXVadParam = new WXVadParam();
        wXVadParam.mode = 1;
        wXVadParam.sample_rate = 16000;
        wXVadParam.opt_spk_time = 3000;
        wXVadParam.offline_min_spk_time = 80;
        wXVadParam.offline_max_spk_time = 50000;
        wXVadParam.offline_min_nspk_time = 50;
        wXVadParam.offline_min_process_time = 10000;
        wXVadParam.offline_remove_sil = true;
        wXVadParam.offline_padding_btime = 100;
        wXVadParam.offline_padding_etime = 150;
        wXVadParam.offline_min_sil_time = 600;
        wXVadParam.offline_rtcmode = 3;
        return wXVadParam;
    }

    public void b() {
        WXVad wXVad = new WXVad();
        this.f307759a = wXVad;
        if (1 == wXVad.Init(a())) {
            if (QLog.isColorLevel()) {
                QLog.d("VadHelper", 2, "WXVad Error reading configure");
                return;
            }
            return;
        }
        this.f307761c = false;
    }

    public void c() {
        WXVad wXVad = this.f307759a;
        if (wXVad != null) {
            wXVad.Release();
        }
    }

    public List<WXVadSeg> d(String str) {
        FileInputStream fileInputStream;
        Exception e16;
        FileInputStream fileInputStream2 = null;
        if (this.f307760b.get() || this.f307761c) {
            return null;
        }
        this.f307760b.set(true);
        ArrayList arrayList = new ArrayList();
        File file = new File(str);
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Exception e17) {
                fileInputStream = null;
                e16 = e17;
            } catch (Throwable th5) {
                th = th5;
                try {
                    fileInputStream2.close();
                } catch (Exception e18) {
                    e18.printStackTrace();
                }
                throw th;
            }
            try {
                try {
                    long length = file.length();
                    long j3 = 0;
                    fileInputStream.skip(j3);
                    byte[] bArr = new byte[(int) (length - j3)];
                    fileInputStream.read(bArr);
                    WXVadData OfflineProcess = this.f307759a.OfflineProcess(Utils.toShortArray(bArr), r1.length);
                    if (OfflineProcess.RET_STATE != 1) {
                        arrayList.addAll(OfflineProcess.offline_odata);
                    }
                    this.f307759a.Reset();
                    this.f307760b.set(false);
                    fileInputStream.close();
                } catch (Throwable th6) {
                    th = th6;
                    fileInputStream2 = fileInputStream;
                    fileInputStream2.close();
                    throw th;
                }
            } catch (Exception e19) {
                e16 = e19;
                e16.printStackTrace();
                this.f307760b.set(false);
                fileInputStream.close();
                return arrayList;
            }
        } catch (Exception e26) {
            e26.printStackTrace();
        }
        return arrayList;
    }
}
