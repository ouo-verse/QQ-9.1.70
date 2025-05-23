package com.tencent.mobileqq.ar.ARPromotionMgr;

import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo;
import com.tencent.mobileqq.armap.h;
import com.tencent.mobileqq.armap.i;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a extends h.a {
    @Override // com.tencent.mobileqq.armap.h.a, com.tencent.mobileqq.armap.h.b
    public String b(i.a aVar) {
        Object obj = aVar.f199759h;
        if (!(obj instanceof PromotionConfigInfo.b)) {
            return null;
        }
        String str = ((PromotionConfigInfo.b) obj).f196906e;
        if (QQAudioHelper.j()) {
            QLog.w(f.f196950a, 1, "getUnzipDirPath, path[" + str + "]");
        }
        return str;
    }

    @Override // com.tencent.mobileqq.armap.h.a, com.tencent.mobileqq.armap.h.b
    public boolean c(i.a aVar, boolean z16) {
        return false;
    }

    @Override // com.tencent.mobileqq.armap.h.a, com.tencent.mobileqq.armap.h.b
    public boolean d(i.a aVar) {
        String str;
        Object obj = aVar.f199759h;
        if (!(obj instanceof PromotionConfigInfo.b)) {
            return false;
        }
        PromotionConfigInfo.b bVar = (PromotionConfigInfo.b) obj;
        bVar.f196916o = 0;
        boolean d16 = super.d(aVar);
        String str2 = "ARPromotionRDHandler, needDownload[" + d16 + "], zipItem[" + bVar;
        if (d16) {
            String d17 = com.tencent.mobileqq.precover.a.d("20180426_803_worldcupXXX", bVar.f196904c);
            if (!TextUtils.isEmpty(d17)) {
                File file = new File(d17);
                boolean exists = file.exists();
                str2 = str2 + "], prePath[" + d17 + "], exists[" + exists;
                if (exists) {
                    try {
                        str = com.tencent.qqprotect.singleupdate.a.d(file);
                    } catch (Exception unused) {
                        str = "Exception";
                    }
                    String str3 = str2 + "], preMd5[" + str;
                    if (TextUtils.equals(bVar.f196904c, str)) {
                        String str4 = str3 + HardCodeUtil.qqStr(R.string.jqy);
                        boolean copyFile = FileUtils.copyFile(d17, e(aVar));
                        boolean d18 = super.d(aVar);
                        str2 = str4 + ", copyFile[" + copyFile + "], reCheck[" + d18 + "]";
                        if (!d18) {
                            bVar.f196916o = 1;
                        }
                        d16 = d18;
                    } else {
                        str2 = str3 + HardCodeUtil.qqStr(R.string.jqx);
                    }
                }
            }
        }
        QLog.w(f.f196950a, 1, str2);
        return d16;
    }

    @Override // com.tencent.mobileqq.armap.h.a, com.tencent.mobileqq.armap.h.b
    public String e(i.a aVar) {
        Object obj = aVar.f199759h;
        if (!(obj instanceof PromotionConfigInfo.b)) {
            return null;
        }
        String str = ((PromotionConfigInfo.b) obj).f196905d;
        if (QQAudioHelper.j()) {
            QLog.w(f.f196950a, 1, "getDownloadPath, path[" + str + "]");
        }
        return str;
    }
}
