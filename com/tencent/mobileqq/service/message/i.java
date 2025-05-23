package com.tencent.mobileqq.service.message;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes18.dex */
public class i {
    static IPatchRedirector $redirector_;
    public static String A;
    public static String B;
    public static String C;
    public static String D;
    public static String E;
    public static String F;

    /* renamed from: a, reason: collision with root package name */
    public static String f286258a;

    /* renamed from: b, reason: collision with root package name */
    public static String f286259b;

    /* renamed from: c, reason: collision with root package name */
    public static String f286260c;

    /* renamed from: d, reason: collision with root package name */
    public static String f286261d;

    /* renamed from: e, reason: collision with root package name */
    public static String f286262e;

    /* renamed from: f, reason: collision with root package name */
    public static String f286263f;

    /* renamed from: g, reason: collision with root package name */
    public static String f286264g;

    /* renamed from: h, reason: collision with root package name */
    public static String f286265h;

    /* renamed from: i, reason: collision with root package name */
    public static String f286266i;

    /* renamed from: j, reason: collision with root package name */
    public static String f286267j;

    /* renamed from: k, reason: collision with root package name */
    public static String f286268k;

    /* renamed from: l, reason: collision with root package name */
    public static String f286269l;

    /* renamed from: m, reason: collision with root package name */
    public static String f286270m;

    /* renamed from: n, reason: collision with root package name */
    public static String f286271n;

    /* renamed from: o, reason: collision with root package name */
    public static String f286272o;

    /* renamed from: p, reason: collision with root package name */
    public static String f286273p;

    /* renamed from: q, reason: collision with root package name */
    public static String f286274q;

    /* renamed from: r, reason: collision with root package name */
    public static String f286275r;

    /* renamed from: s, reason: collision with root package name */
    public static String f286276s;

    /* renamed from: t, reason: collision with root package name */
    public static String f286277t;

    /* renamed from: u, reason: collision with root package name */
    public static String f286278u;

    /* renamed from: v, reason: collision with root package name */
    public static String f286279v;

    /* renamed from: w, reason: collision with root package name */
    public static String f286280w;

    /* renamed from: x, reason: collision with root package name */
    public static String f286281x;

    /* renamed from: y, reason: collision with root package name */
    public static String f286282y;

    /* renamed from: z, reason: collision with root package name */
    public static String f286283z;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40674);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f286258a = "key_recv_queue_wait_length";
        f286259b = "key_add_queue_time";
        f286260c = "holiday_active_flag";
        f286261d = "ark_at_babyq_flag";
        f286262e = "ark_show_as_sdk_flag";
        f286263f = "ark_babyq_gray_tip_flag";
        f286264g = "ark_babyq_report_recv_flag";
        f286265h = "is_redbag_video";
        f286266i = "troop_at_info_list";
        f286267j = "disc_at_info_list";
        f286268k = "at_info";
        f286269l = "is_troop";
        f286270m = "pic_sync_story";
        f286271n = "video_sync_story";
        f286272o = "is_sync_qzone";
        f286273p = "batch_id_qzone";
        f286274q = "album_id_qzone";
        f286275r = "aio_send_qzone_pic_flag";
        f286276s = "aio_send_qzone_pic_url";
        f286277t = "aio_send_qzone_pic_size";
        f286278u = "aio_light_video_read_flag";
        f286279v = "ark_msg_process_state";
        f286280w = "ark_msg_open_sdk_share_error_code";
        f286281x = "ark_msg_open_sdk_share_wording";
        f286282y = "ark_msg_open_sdk_share_info";
        f286283z = "service_msg_type";
        A = "service_msg_remind_type";
        B = "service_msg_name";
        C = "key_send_raw_video";
        D = "QQClubComm.getNewFlag";
        E = "key_troop_important_msg_type";
        F = "key_troop_important_msg_enum";
    }
}
