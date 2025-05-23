package com.tencent.biz.qqcircle.immersive.utils;

import android.text.TextUtils;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.biz.richframework.video.rfw.RFWVideoUtils;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.report.RFWVideoUrlBean;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    private List<String> f90241a;

    /* renamed from: b, reason: collision with root package name */
    private int f90242b = 0;

    /* renamed from: c, reason: collision with root package name */
    private String f90243c;

    private List<String> b(List<RFWVideoUrlBean> list, String str, String str2) {
        String str3;
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        String fileIdWithTapPosition = RFWVideoUtils.getFileIdWithTapPosition(str, str2);
        for (RFWVideoUrlBean rFWVideoUrlBean : list) {
            if (rFWVideoUrlBean == null || (str3 = rFWVideoUrlBean.mUrl) == null) {
                str3 = null;
            }
            String fileIdWithTapPosition2 = RFWVideoUtils.getFileIdWithTapPosition(str3, str2);
            if (str3 != null && str3.contains(".mp4") && !fileIdWithTapPosition2.contains(".f0") && !TextUtils.equals(fileIdWithTapPosition, fileIdWithTapPosition2)) {
                arrayList.add(str3);
            }
        }
        return arrayList;
    }

    private boolean c(String str, int i3) {
        if (i3 != 14010017 && i3 != 14020004) {
            return false;
        }
        String urlHost = RFWVideoUtils.getUrlHost(str);
        if (!urlHost.contains("v.kdsvp.qq.com") && !urlHost.contains("shortv.cdp.qq.com")) {
            return false;
        }
        return true;
    }

    public String a(RFWPlayerOptions rFWPlayerOptions, int i3) {
        if (!uq3.c.S6() || !c(rFWPlayerOptions.getPlayUrl(), i3)) {
            return "";
        }
        if (!TextUtils.isEmpty(this.f90243c) && !TextUtils.equals(this.f90243c, rFWPlayerOptions.getFileId())) {
            d();
        }
        int i16 = this.f90242b;
        if (i16 >= 3) {
            return "";
        }
        if (i16 == 0) {
            this.f90243c = rFWPlayerOptions.getFileId();
            this.f90241a = b(rFWPlayerOptions.getVecUrlBean(), rFWPlayerOptions.getRealPlayUrl(), rFWPlayerOptions.getPlayVid());
        }
        String str = (String) RFSafeListUtils.get(this.f90241a, this.f90242b);
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        this.f90242b++;
        return str;
    }

    public void d() {
        if (!uq3.c.S6()) {
            return;
        }
        this.f90243c = "";
        this.f90242b = 0;
        List<String> list = this.f90241a;
        if (list != null) {
            list.clear();
        }
    }
}
