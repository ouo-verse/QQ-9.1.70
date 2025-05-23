package com.tencent.mobileqq.ark.api.silk;

import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ark;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.ark.api.silk.SilkAudioPlayer;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class ArkSilkAudioPlayerWrapper implements SilkAudioPlayer.b {

    /* renamed from: i, reason: collision with root package name */
    public static final Map<Integer, String> f199144i;

    /* renamed from: d, reason: collision with root package name */
    protected SilkAudioPlayer f199145d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f199146e = false;

    /* renamed from: f, reason: collision with root package name */
    private final String f199147f;

    /* renamed from: h, reason: collision with root package name */
    private ark.VariantWrapper f199148h;

    static {
        HashMap hashMap = new HashMap();
        f199144i = hashMap;
        hashMap.put(0, "\u5f00\u59cb");
        hashMap.put(1, "\u52a0\u8f7d\u4e2d");
        hashMap.put(2, "\u52a0\u8f7d\u5b8c\u6210");
        hashMap.put(3, "\u64ad\u653e\u72b6\u6001");
        hashMap.put(4, "\u4e2d\u65ad\u72b6\u6001");
        hashMap.put(5, "\u505c\u6b62\u72b6\u6001");
        hashMap.put(6, "\u5f02\u5e38");
    }

    public ArkSilkAudioPlayerWrapper(String str) {
        this.f199147f = str;
    }

    public boolean a() {
        return this.f199146e;
    }

    @Override // com.tencent.mobileqq.ark.api.silk.SilkAudioPlayer.b
    public void a1(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("ArkSilkAudioPlayerWrapper", 2, String.format("onFocusChanged focused=%s", Boolean.valueOf(z16)));
        }
        if (!z16) {
            f(5);
            d();
        }
    }

    public void b(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("ArkSilkAudioPlayerWrapper", 2, "play");
        }
        if (TextUtils.isEmpty(str)) {
            QLog.w("ArkSilkAudioPlayerWrapper", 1, "play but url is empty");
            f(6);
        } else {
            if (this.f199145d == null) {
                this.f199145d = new SilkAudioPlayer(this);
            }
            this.f199145d.f(str);
            this.f199146e = true;
        }
    }

    public void c(ark.VariantWrapper variantWrapper) {
        this.f199148h = variantWrapper;
    }

    public void d() {
        if (QLog.isColorLevel()) {
            QLog.d("ArkSilkAudioPlayerWrapper", 2, "stop");
        }
        SilkAudioPlayer silkAudioPlayer = this.f199145d;
        if (silkAudioPlayer != null) {
            silkAudioPlayer.i();
            this.f199146e = false;
        }
        ark.VariantWrapper variantWrapper = this.f199148h;
        if (variantWrapper != null) {
            variantWrapper.Reset();
            this.f199148h = null;
        }
    }

    public void e(int i3) {
        ark.VariantWrapper variantWrapper = this.f199148h;
        if (variantWrapper == null) {
            return;
        }
        try {
            ark.VariantWrapper Create = variantWrapper.Create();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("state", i3);
            jSONObject.put("info", f199144i.get(Integer.valueOf(i3)));
            Create.SetTableAsJsonString(jSONObject.toString());
            ark.VariantWrapper Create2 = this.f199148h.Create();
            this.f199148h.InvokeDefault(new ark.VariantWrapper[]{Create}, Create2);
            Create.Reset();
            Create2.Reset();
            if (i3 == 6 || i3 == 5) {
                this.f199148h.Reset();
                this.f199148h = null;
            }
        } catch (Exception e16) {
            QLog.e("ArkSilkAudioPlayerWrapper", 1, "syncSilkAudioPlayerForArkStatus Error" + e16);
        }
    }

    public void f(final int i3) {
        ArkDispatchTask.getInstance().post(this.f199147f, new Runnable() { // from class: com.tencent.mobileqq.ark.api.silk.ArkSilkAudioPlayerWrapper.1
            @Override // java.lang.Runnable
            public void run() {
                ArkSilkAudioPlayerWrapper.this.e(i3);
            }
        });
    }

    @Override // com.tencent.mobileqq.ark.api.silk.SilkAudioPlayer.b
    public void onDownloadFailed(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("ArkSilkAudioPlayerWrapper", 2, String.format("onDownloadFailed errCode=%s", Integer.valueOf(i3)));
        }
        f(6);
        d();
    }

    @Override // com.tencent.mobileqq.ark.api.silk.SilkAudioPlayer.b
    public void onDownloadFinish(File file) {
        if (QLog.isColorLevel()) {
            QLog.d("ArkSilkAudioPlayerWrapper", 2, String.format("onDownloadFinish path=%s", file.getAbsoluteFile()));
        }
        f(2);
    }

    @Override // com.tencent.mobileqq.ark.api.silk.SilkAudioPlayer.b
    public void onDownloadStart() {
        if (QLog.isColorLevel()) {
            QLog.d("ArkSilkAudioPlayerWrapper", 2, "onDownloadStart");
        }
        f(1);
    }

    @Override // com.tencent.mobileqq.ark.api.silk.SilkAudioPlayer.b
    public void onError() {
        f(6);
    }

    @Override // com.tencent.mobileqq.ark.api.silk.SilkAudioPlayer.b
    public void onPlayStart() {
        if (QLog.isColorLevel()) {
            QLog.d("ArkSilkAudioPlayerWrapper", 2, HippyQQPagView.EventName.ON_PLAY_START);
        }
        f(0);
    }

    @Override // com.tencent.mobileqq.ark.api.silk.SilkAudioPlayer.b
    public void s1() {
        if (QLog.isColorLevel()) {
            QLog.d("ArkSilkAudioPlayerWrapper", 2, "onPlaying");
        }
        f(3);
    }

    @Override // com.tencent.mobileqq.utils.VoicePlayer.a
    public void u4(int i3, String str, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d("ArkSilkAudioPlayerWrapper", 2, String.format("playerCompletion path=%s", str));
        }
        f(5);
        ArkDispatchTask.getInstance().post(this.f199147f, new Runnable() { // from class: com.tencent.mobileqq.ark.api.silk.ArkSilkAudioPlayerWrapper.2
            @Override // java.lang.Runnable
            public void run() {
                ArkSilkAudioPlayerWrapper.this.d();
            }
        });
    }

    @Override // com.tencent.mobileqq.utils.VoicePlayer.a
    public void c5(String str, int i3, int i16) {
    }

    @Override // com.tencent.mobileqq.utils.VoicePlayer.a
    public void ic(String str, int i3, int i16) {
    }
}
