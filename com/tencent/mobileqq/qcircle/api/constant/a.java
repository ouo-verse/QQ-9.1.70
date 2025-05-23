package com.tencent.mobileqq.qcircle.api.constant;

import android.view.ViewConfiguration;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.vfs.IVFSAssistantApi;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import java.io.File;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static int f261576a = 300;

    /* renamed from: b, reason: collision with root package name */
    public static int f261577b = 50;

    /* renamed from: c, reason: collision with root package name */
    public static int f261578c = ViewConfiguration.getLongPressTimeout();

    /* renamed from: d, reason: collision with root package name */
    private static final String f261579d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f261580e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f261581f;

    /* renamed from: g, reason: collision with root package name */
    public static final String f261582g;

    /* renamed from: h, reason: collision with root package name */
    public static final String f261583h;

    /* renamed from: i, reason: collision with root package name */
    public static final String f261584i;

    /* renamed from: j, reason: collision with root package name */
    public static final String f261585j;

    /* renamed from: k, reason: collision with root package name */
    public static final String f261586k;

    /* renamed from: l, reason: collision with root package name */
    public static final String f261587l;

    /* renamed from: m, reason: collision with root package name */
    public static String f261588m;

    /* renamed from: n, reason: collision with root package name */
    public static String f261589n;

    /* renamed from: o, reason: collision with root package name */
    public static String f261590o;

    static {
        String sDKPrivatePath = ((IVFSAssistantApi) QRoute.api(IVFSAssistantApi.class)).getSDKPrivatePath("qcircle/");
        f261579d = sDKPrivatePath;
        String str = sDKPrivatePath + ProtocolDownloaderConstants.FILE_PREFIX;
        f261580e = str;
        String str2 = str + "download/";
        f261581f = str2;
        String str3 = str2 + "base/";
        f261582g = str3;
        f261583h = str3 + "qcircle_rerank/";
        f261584i = str3 + "qcircle_tedgers/";
        f261585j = str3 + "qcircle_tedgers_v2/";
        f261586k = str + "qcircle_emoji/";
        StringBuilder sb5 = new StringBuilder();
        sb5.append(AppConstants.SDCARD_PATH);
        sb5.append("qzone");
        String str4 = File.separator;
        sb5.append(str4);
        sb5.append("thumbs");
        sb5.append(str4);
        f261587l = VFSAssistantUtils.getSDKPrivatePath(sb5.toString());
        f261588m = "video";
        f261589n = "pic";
        f261590o = "do_not_show_publish_progress";
    }
}
