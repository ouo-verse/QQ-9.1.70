package com.tencent.av;

import com.tencent.avcore.engine.dav.DavClosedReason;
import com.tencent.avcore.engine.dav.DavRejectReason;
import com.tencent.avcore.util.AVConstants;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;

/* compiled from: P */
/* loaded from: classes3.dex */
public class q extends com.tencent.av.app.f implements AVConstants, DavClosedReason, DavRejectReason {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f74190a = true;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f74191b = false;

    /* renamed from: c, reason: collision with root package name */
    public static String f74192c = "qua_report_current";

    /* renamed from: d, reason: collision with root package name */
    public static String f74193d = "qua_report_exception";

    /* renamed from: e, reason: collision with root package name */
    public static int f74194e = 10;

    /* renamed from: f, reason: collision with root package name */
    public static String f74195f = "qav_score_sender_uin";

    /* renamed from: g, reason: collision with root package name */
    public static String f74196g = "qav_score_room_id";

    /* renamed from: h, reason: collision with root package name */
    public static String f74197h = "qav_peer_uin_or_troop";

    /* renamed from: i, reason: collision with root package name */
    public static String f74198i = "qav_score_begintime";

    /* renamed from: j, reason: collision with root package name */
    public static String f74199j = "qav_score_endtime";

    /* renamed from: k, reason: collision with root package name */
    public static String f74200k = "qav_ip";

    /* renamed from: l, reason: collision with root package name */
    public static String f74201l = "qav_business_type";

    /* renamed from: m, reason: collision with root package name */
    public static String f74202m = "qav_business_flag";

    /* renamed from: n, reason: collision with root package name */
    public static int f74203n = 36;

    /* renamed from: o, reason: collision with root package name */
    public static int f74204o = 20;

    /* renamed from: p, reason: collision with root package name */
    public static int f74205p = 24;

    /* renamed from: q, reason: collision with root package name */
    public static final boolean f74206q;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static String f74207a = "0";
    }

    static {
        boolean z16;
        if (!DeviceInfoMonitor.getModel().equalsIgnoreCase("OXF-AN10") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("OXF-AN00") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("OXP-AN00") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("MI 9 SE") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("Mi 10") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("PBAM00") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("PACM00") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("ART-AL00x") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("YAL-AL50") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("SPN-AL00") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("RMX2111") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("JEF-AN00") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("YAL-AL00") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("PDVM00") && !DeviceInfoMonitor.getModel().equalsIgnoreCase("ONEPLUS A6000")) {
            z16 = false;
        } else {
            z16 = true;
        }
        f74206q = z16;
    }
}
