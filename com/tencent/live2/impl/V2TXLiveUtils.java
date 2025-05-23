package com.tencent.live2.impl;

import android.text.TextUtils;
import android.util.Base64;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.live2.V2TXLiveDef;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.qid.QidPagView;
import com.tencent.qqlive.tvkplayer.tools.config.TVKConfigSystem;

/* compiled from: P */
/* loaded from: classes7.dex */
public class V2TXLiveUtils {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "V2TXLiveUtils";
    public static final String TRTC_ADDRESS1;
    public static final String TRTC_ADDRESS2;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.live2.impl.V2TXLiveUtils$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f119785a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16435);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[V2TXLiveDef.V2TXLiveVideoResolution.values().length];
            f119785a = iArr;
            try {
                iArr[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution160x160.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f119785a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution270x270.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f119785a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution480x480.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f119785a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution320x240.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f119785a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution480x360.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f119785a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution640x480.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f119785a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution320x180.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f119785a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution480x270.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f119785a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution640x360.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f119785a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution960x540.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f119785a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution1280x720.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f119785a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution1920x1080.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f119786a;

        /* renamed from: b, reason: collision with root package name */
        public int f119787b;

        public a(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.f119786a = i3;
                this.f119787b = i16;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16470);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            TRTC_ADDRESS1 = new String(Base64.decode("cm9vbTovL2Nsb3VkLnRlbmNlbnQuY29tL3J0Yw==", 0));
            TRTC_ADDRESS2 = new String(Base64.decode("cm9vbTovL3J0Yy50ZW5jZW50LmNvbQ==", 0));
        }
    }

    public V2TXLiveUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static a getBitrateByResolution(V2TXLiveDef.V2TXLiveVideoResolution v2TXLiveVideoResolution) {
        int i3 = 900;
        int i16 = 600;
        switch (AnonymousClass1.f119785a[v2TXLiveVideoResolution.ordinal()]) {
            case 1:
                i16 = 100;
                i3 = 150;
                break;
            case 2:
                i16 = 200;
                i3 = 300;
                break;
            case 3:
                i3 = 525;
                i16 = 350;
                break;
            case 4:
                i3 = QidPagView.DESIGN_PAG_WIDTH;
                i16 = 250;
                break;
            case 5:
                i3 = 600;
                i16 = 400;
                break;
            case 6:
                break;
            case 7:
                i3 = 400;
                i16 = 250;
                break;
            case 8:
                i3 = 550;
                i16 = 350;
                break;
            case 9:
                i16 = 500;
                break;
            case 10:
            default:
                i16 = 800;
                i3 = 1500;
                break;
            case 11:
                i16 = 1000;
                i3 = TVKConfigSystem.REQUEST_ONLINE_CONFIG_MIN_INTERVAL_SEC;
                break;
            case 12:
                i16 = 2500;
                i3 = 3000;
                break;
        }
        return new a(i16, i3);
    }

    public static V2TXLiveDef.V2TXLiveMode parseLiveMode(String str) {
        if (!str.startsWith("trtc://") && !str.startsWith(TRTC_ADDRESS1) && !str.startsWith(TRTC_ADDRESS2)) {
            TXCLog.i(TAG, "parseLiveMode: rtmp.");
            return V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTMP;
        }
        TXCLog.i(TAG, "parseLiveMode: rtc.");
        return V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTC;
    }

    public static String removeURLSensitiveInfo(String str) {
        int indexOf;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            String[] strArr = {"roomsig", "privatemapkey", "usersig"};
            for (int i3 = 0; i3 < 3; i3++) {
                if (str.contains(strArr[i3]) && (indexOf = str.indexOf(strArr[i3])) != -1) {
                    int indexOf2 = str.indexOf(ContainerUtils.FIELD_DELIMITER, indexOf);
                    if (indexOf2 == -1) {
                        str = str.substring(0, indexOf);
                    } else {
                        str = str.substring(0, indexOf) + str.substring(indexOf2);
                    }
                }
            }
        } catch (Exception e16) {
            TXCLog.e(TAG, "remove url sensitive info failed.", e16);
        }
        return str;
    }
}
