package com.tencent.mobileqq.troop.announcement.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes19.dex */
public interface ITroopAnnouncementHelperApi extends QRouteApi {
    public static final String CONTROL_INFO = "controlInfo";
    public static final String CONTROL_INFO_COMPRESS = "compress";
    public static final String CONTROL_INFO_FILTER_ID = "filterID";
    public static final String CONTROL_INFO_SRC = "src";
    public static final String CONTROL_INFO_VAILD_TIME = "validTime";
    public static final String CONTROL_TYPE = "controlType";
    public static final int CONTROL_TYPE_VAILD_TIME_AND_FILTER = 1;
    public static final int IS_COMPRESSED = 1;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f293916a;

        /* renamed from: b, reason: collision with root package name */
        public String f293917b;

        /* renamed from: c, reason: collision with root package name */
        public String f293918c;

        /* renamed from: d, reason: collision with root package name */
        public String f293919d;

        /* renamed from: e, reason: collision with root package name */
        public String f293920e;

        /* renamed from: f, reason: collision with root package name */
        public int f293921f;

        /* renamed from: g, reason: collision with root package name */
        public long f293922g;

        /* renamed from: h, reason: collision with root package name */
        public int f293923h;

        /* renamed from: i, reason: collision with root package name */
        public byte[] f293924i;

        /* renamed from: j, reason: collision with root package name */
        public String f293925j;

        /* renamed from: k, reason: collision with root package name */
        public int f293926k;

        /* renamed from: l, reason: collision with root package name */
        public long f293927l;

        /* renamed from: m, reason: collision with root package name */
        public int f293928m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f293929n;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f293929n = false;
            }
        }
    }

    a decodeToFeedItem(String str, byte[] bArr, boolean z16);

    int getTroopIntroGapHour();
}
