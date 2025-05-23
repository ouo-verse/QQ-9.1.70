package com.tencent.gdtad.basics.motivevideo;

import android.text.TextUtils;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.util.GdtUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.regex.Pattern;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes6.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f108950a = Pattern.compile("/*(\\w+)/*(\\w+)/*(\\w+)/*");

    public static String a(GdtMotiveVideoModel gdtMotiveVideoModel) {
        String qqStr;
        BaseApplication context = BaseApplication.getContext();
        String qqStr2 = HardCodeUtil.qqStr(R.string.f172055n13);
        GdtMotiveVideoPageData gdtMotiveVideoPageData = gdtMotiveVideoModel.getGdtMotiveVideoPageData();
        qq_ad_get.QQAdGetRsp.AdInfo adInfo = gdtMotiveVideoModel.getAdInfo();
        if (adInfo != null) {
            if (adInfo.ext.is_app_preorder.get()) {
                qqStr2 = HardCodeUtil.qqStr(R.string.f1377807s);
            } else if (!adInfo.display_info.button_info.get().isEmpty()) {
                qqStr2 = adInfo.display_info.button_info.get(0).txt.get();
                String str = adInfo.app_info.app_package_name.get();
                if (!TextUtils.isEmpty(qqStr2)) {
                    if (b(gdtMotiveVideoModel) && GdtUtil.isAppInstall(context, str)) {
                        if (gdtMotiveVideoPageData.isStyleC()) {
                            qqStr = HardCodeUtil.qqStr(R.string.n0y);
                        } else {
                            qqStr = HardCodeUtil.qqStr(R.string.n0z);
                        }
                        qqStr2 = qqStr;
                    }
                } else if (b(gdtMotiveVideoModel)) {
                    if (GdtUtil.isAppInstall(context, str)) {
                        qqStr = HardCodeUtil.qqStr(R.string.f172053n10);
                    } else {
                        qqStr = HardCodeUtil.qqStr(R.string.f172054n12);
                    }
                    qqStr2 = qqStr;
                } else {
                    qqStr2 = HardCodeUtil.qqStr(R.string.f172056n14);
                }
            }
        }
        GdtLog.i("GdtMvElementsHelper", "getContentStr:" + qqStr2);
        return qqStr2;
    }

    public static boolean b(GdtMotiveVideoModel gdtMotiveVideoModel) {
        int i3 = gdtMotiveVideoModel.getGdtMotiveVideoPageData().productType;
        if (i3 != 12 && i3 != 19) {
            return false;
        }
        return true;
    }
}
