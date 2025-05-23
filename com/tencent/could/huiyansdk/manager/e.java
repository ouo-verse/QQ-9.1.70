package com.tencent.could.huiyansdk.manager;

import android.graphics.ColorMatrixColorFilter;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.NonNull;
import com.tencent.could.aicamare.CameraHolder;
import com.tencent.could.huiyansdk.api.HuiYanExtraCallBack;
import com.tencent.could.huiyansdk.api.HuiYanSdkImp;
import com.tencent.could.huiyansdk.entity.CameraRiskChangeInfo;
import com.tencent.could.huiyansdk.entity.RiskDemoImage;
import com.tencent.could.huiyansdk.enums.RiskCameraType;
import com.tencent.could.huiyansdk.manager.f;
import com.tencent.could.huiyansdk.manager.k;
import com.tencent.could.huiyansdk.utils.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.ByteArrayOutputStream;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e extends Handler {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f100162a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(f fVar, Looper looper) {
        super(looper);
        this.f100162a = fVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fVar, (Object) looper);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(@NonNull Message message) {
        int i3;
        byte[] bArr;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            return;
        }
        super.handleMessage(message);
        int i16 = message.what;
        int i17 = 0;
        if (i16 != 1000) {
            if (i16 != 1500) {
                if (i16 != 2000) {
                    k.a.f100197a.a(2, "CameraRiskManager", "other info:");
                    return;
                } else {
                    Log.e("CameraRiskManager", "get dayle time!");
                    this.f100162a.f100164b = true;
                    return;
                }
            }
            f fVar = this.f100162a;
            int i18 = fVar.f100179q;
            ColorMatrixColorFilter[] colorMatrixColorFilterArr = fVar.f100178p;
            if (i18 >= colorMatrixColorFilterArr.length) {
                fVar.f100179q = 0;
            }
            ColorMatrixColorFilter colorMatrixColorFilter = colorMatrixColorFilterArr[fVar.f100179q];
            f.b bVar = fVar.f100175m;
            if (bVar != null) {
                com.tencent.could.huiyansdk.fragments.i iVar = (com.tencent.could.huiyansdk.fragments.i) bVar;
                iVar.f100096a.a((Runnable) new com.tencent.could.huiyansdk.fragments.h(iVar, colorMatrixColorFilter));
            }
            f fVar2 = this.f100162a;
            fVar2.f100179q++;
            if (fVar2.f100169g != null) {
                Message obtainMessage = this.f100162a.f100169g.obtainMessage();
                obtainMessage.what = 1500;
                this.f100162a.f100169g.sendMessageDelayed(obtainMessage, 500L);
                return;
            }
            k.a.f100197a.a(2, "CameraRiskManager", "handler is null!");
            return;
        }
        Log.d("CameraRiskManager", "get camera frame");
        byte[] bArr2 = (byte[]) message.obj;
        if (this.f100162a.f100165c) {
            b.a.f100299a.a(bArr2);
            return;
        }
        f fVar3 = this.f100162a;
        int i19 = fVar3.f100166d;
        int i26 = fVar3.f100167e;
        byte[] a16 = b.a.f100299a.a();
        if (a16 == null) {
            a16 = new byte[((i19 * i26) * 3) / 2];
        }
        int i27 = i19 - 1;
        int i28 = 0;
        for (int i29 = i27; i29 >= 0; i29--) {
            int i36 = ((i26 - 1) * i19) + (i29 * 2);
            int i37 = 0;
            while (i37 < i26) {
                a16[i28] = bArr2[i36 - ((i37 * i19) + i29)];
                i37++;
                i28++;
            }
        }
        int i38 = i19 * i26;
        int i39 = i38;
        while (i27 > 0) {
            int i46 = i26 / 2;
            int i47 = ((i46 - 1) * i19) + (i27 * 2) + i38;
            for (int i48 = 0; i48 < i46; i48++) {
                int i49 = i39 + 1;
                int i56 = (i48 * i19) + i27;
                a16[i39] = bArr2[(i47 - 2) - (i56 - 1)];
                i39 = i49 + 1;
                a16[i49] = bArr2[i47 - i56];
            }
            i27 -= 2;
        }
        long currentTimeMillis = System.currentTimeMillis();
        f fVar4 = this.f100162a;
        int i57 = fVar4.f100167e;
        int i58 = i57 / 2;
        int i59 = fVar4.f100166d;
        int i65 = i59 / 2;
        try {
            int i66 = ((i57 / 2) * i59) / 2;
            byte[] bArr3 = new byte[(i66 * 3) / 2];
            int i67 = 0;
            int i68 = 0;
            while (i67 < i59) {
                while (i17 < i57) {
                    bArr3[i68] = a16[(i67 * i57) + i17];
                    i68++;
                    i17 += 2;
                }
                i67 += 2;
                i17 = 0;
            }
            int i69 = i57 * i59;
            int i75 = i66;
            int i76 = 0;
            while (i76 < i59 / 2) {
                int i77 = i75;
                for (int i78 = 0; i78 < i57; i78 += 4) {
                    int i79 = i69 + (i76 * i57) + i78;
                    bArr3[i77] = a16[i79];
                    bArr3[i77 + 1] = a16[i79 + 1];
                    i77 += 2;
                }
                i76 += 2;
                i75 = i77;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new YuvImage(bArr3, 17, i58, i65, null).compressToJpeg(new Rect(0, 0, i58, i65), 95, byteArrayOutputStream);
            bArr = byteArrayOutputStream.toByteArray();
            i3 = 2;
        } catch (Exception e16) {
            i3 = 2;
            k.a.f100197a.a(2, "CameraRiskManager", "get jpg info failed! " + e16.getLocalizedMessage());
            bArr = null;
        }
        if (bArr != null) {
            str = Base64.encodeToString(bArr, i3);
            Log.d("CameraRiskManager", "get jpg info tmpRiskCameraType:" + this.f100162a.f100171i + " useTime: " + (System.currentTimeMillis() - currentTimeMillis) + " allJpg size:" + str.length());
        } else {
            str = "";
        }
        RiskDemoImage riskDemoImage = new RiskDemoImage();
        riskDemoImage.setImage(str);
        riskDemoImage.setTimestamp(System.currentTimeMillis());
        f fVar5 = this.f100162a;
        fVar5.f100174l.put(fVar5.f100171i, riskDemoImage);
        com.tencent.could.huiyansdk.utils.b bVar2 = b.a.f100299a;
        bVar2.a(bArr2);
        bVar2.a(a16);
        CameraRiskChangeInfo a17 = this.f100162a.a();
        CameraHolder cameraHolder = this.f100162a.f100170h.get();
        if (a17 == null) {
            this.f100162a.f100164b = false;
            this.f100162a.f100165c = true;
            k kVar = k.a.f100197a;
            kVar.a(1, "CameraRiskManager", "cameraRiskChangeInfo is null and end all work!");
            CameraRiskChangeInfo cameraRiskChangeInfo = new CameraRiskChangeInfo();
            cameraRiskChangeInfo.setZoomValue(0);
            cameraRiskChangeInfo.setWhiteBalance("auto");
            cameraRiskChangeInfo.setExposure(0.0f);
            this.f100162a.a(cameraHolder, cameraRiskChangeInfo);
            HuiYanExtraCallBack extraCallBack = HuiYanSdkImp.getInstance().getExtraCallBack();
            if (extraCallBack != null) {
                f fVar6 = this.f100162a;
                extraCallBack.onCameraRiskData(fVar6.f100174l, fVar6.f100173k);
            } else {
                kVar.a(2, "CameraRiskManager", "extraCallBack is null!");
            }
            f fVar7 = this.f100162a;
            f.b bVar3 = fVar7.f100175m;
            if (bVar3 != null) {
                ((com.tencent.could.huiyansdk.fragments.i) bVar3).a(fVar7.f100173k);
            }
            if (this.f100162a.f100173k == 2) {
                this.f100162a.f100169g.removeMessages(1500);
                f fVar8 = this.f100162a;
                f.b bVar4 = fVar8.f100175m;
                if (bVar4 != null) {
                    com.tencent.could.huiyansdk.fragments.i iVar2 = (com.tencent.could.huiyansdk.fragments.i) bVar4;
                    iVar2.f100096a.a((Runnable) new com.tencent.could.huiyansdk.fragments.h(iVar2, fVar8.f100177o));
                }
            }
            f fVar9 = this.f100162a;
            Map<RiskCameraType, RiskDemoImage> map = fVar9.f100174l;
            if (map != null) {
                map.clear();
            }
            fVar9.f100173k = 0;
            fVar9.f100164b = false;
            fVar9.f100165c = false;
            fVar9.f100172j = 0;
            fVar9.f100174l.clear();
            return;
        }
        Log.e("CameraRiskManager", "change cameraRiskChangeInfo and want delay");
        this.f100162a.a(cameraHolder, a17);
        if (this.f100162a.f100169g != null) {
            Message obtainMessage2 = this.f100162a.f100169g.obtainMessage();
            obtainMessage2.what = 2000;
            this.f100162a.f100169g.sendMessageDelayed(obtainMessage2, a17.getDelay());
            return;
        }
        Log.e("CameraRiskManager", "handler is null!");
        f fVar10 = this.f100162a;
        f.b bVar5 = fVar10.f100175m;
        if (bVar5 != null) {
            ((com.tencent.could.huiyansdk.fragments.i) bVar5).a(fVar10.f100173k);
        }
    }
}
