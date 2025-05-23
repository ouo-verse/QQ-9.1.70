package com.tencent.mobileqq.graytip;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.s;
import com.tencent.mobileqq.data.GrayTipsMessageConstants$HighlightItem;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.youtu.sdkkitframework.common.ErrorCode;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: P */
/* loaded from: classes12.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: x, reason: collision with root package name */
    public static final int[] f213676x;

    /* renamed from: y, reason: collision with root package name */
    private static b f213677y;

    /* renamed from: a, reason: collision with root package name */
    protected boolean f213678a;

    /* renamed from: b, reason: collision with root package name */
    protected boolean f213679b;

    /* renamed from: c, reason: collision with root package name */
    protected boolean f213680c;

    /* renamed from: d, reason: collision with root package name */
    public String f213681d;

    /* renamed from: e, reason: collision with root package name */
    public String f213682e;

    /* renamed from: f, reason: collision with root package name */
    public String f213683f;

    /* renamed from: g, reason: collision with root package name */
    public int f213684g;

    /* renamed from: h, reason: collision with root package name */
    public int f213685h;

    /* renamed from: i, reason: collision with root package name */
    public long f213686i;

    /* renamed from: j, reason: collision with root package name */
    public int f213687j;

    /* renamed from: k, reason: collision with root package name */
    public final Bundle f213688k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f213689l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f213690m;

    /* renamed from: n, reason: collision with root package name */
    public int f213691n;

    /* renamed from: o, reason: collision with root package name */
    public int[] f213692o;

    /* renamed from: p, reason: collision with root package name */
    public String f213693p;

    /* renamed from: q, reason: collision with root package name */
    private ArrayList<GrayTipsMessageConstants$HighlightItem> f213694q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f213695r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f213696s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f213697t;

    /* renamed from: u, reason: collision with root package name */
    private final Object f213698u;

    /* renamed from: v, reason: collision with root package name */
    private ConcurrentHashMap<String, String> f213699v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f213700w;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.graytip.g.b
        public boolean a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, i3)).booleanValue();
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface b {
        boolean a(int i3);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39817);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        s.a();
        f213676x = new int[]{1, IjkMediaPlayer.OnNativeInvokeListener.CTRL_WILL_TCP_OPEN, FileMsg.TRANSFILE_TYPE_MULTIMSG, 135176, 1376257, ErrorCode.YT_SDK_NETWORK_ERROR, 2097154, 2097155, 2097156, 1245186, 1245187, 65560, 2359297, 65560, 655362, 2424833, 2490369, 2555907, 1179651, 2686977, 2621441, 2359298, ErrorCode.YT_SDK_JSON_PARAM_ERROR, 2555906, ErrorCode.YT_SDK_JSON_PARAM_ERROR, 3211265, 135178, 135179, 655378, 655379, 655369, 655376, 3276801, 3276802, 655377, 1179653, 3342339, 135180, 135181, 655381, 131080, 131081, 655383, 655392, 131082, 655384, 655385, 2359299, 2359300, 3276804, 131090, 131091, 655393, 131083, 655397, 131084, 131085, 131092, 131087, 131086, 131088, 2, 656395, 459802, 459803, 3, 459817, 656396, 656398, 131093, 656397, ErrorCode.YT_SDK_VERIFY_SCORE_FAILED, ErrorCode.YT_SDK_VERIFY_NET_RET_FAILED, ErrorCode.YT_SDK_VERIFY_TIMEOUT, 4194308};
        f213677y = new a();
    }

    public g(String str, String str2, String str3, int i3, int i16, int i17, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Long.valueOf(j3));
            return;
        }
        this.f213678a = true;
        this.f213679b = true;
        this.f213680c = true;
        this.f213688k = new Bundle();
        this.f213689l = true;
        this.f213695r = true;
        this.f213696s = false;
        this.f213697t = false;
        this.f213698u = new Object();
        this.f213699v = new ConcurrentHashMap<>();
        this.f213700w = false;
        this.f213681d = str;
        this.f213682e = str2;
        this.f213683f = str3;
        this.f213684g = i3;
        this.f213687j = i16;
        this.f213685h = i17;
        this.f213686i = j3;
        l();
    }

    private boolean h(int i3) {
        if (i3 == 1 || i3 == 3 || i3 == 2 || i3 == 21 || i3 == 15 || i3 == 16 || i3 == 20 || i3 == 23 || i3 == 24 || i3 == 14 || i3 == 13 || i3 == 29 || i3 == 30 || i3 == 32 || i3 == 44 || i3 == 45 || i3 == 52 || i3 == 53 || i3 == 54 || i3 == 61 || i3 == 58 || i3 == 62 || i3 == 63 || i3 == 38 || i3 == 69 || i3 == 70) {
            return true;
        }
        return false;
    }

    private boolean i(int i3) {
        if (i3 != 39 && i3 != 40 && i3 != 11 && i3 != 36 && i3 != 67) {
            return false;
        }
        return true;
    }

    public static void j(b bVar) {
        f213677y = bVar;
    }

    private void l() {
        int i3 = this.f213687j;
        if (i3 == -5020) {
            this.f213678a = false;
            return;
        }
        if (i3 == -5021) {
            this.f213680c = false;
            return;
        }
        if (i3 == -5022) {
            this.f213678a = false;
            this.f213679b = false;
        } else if (i3 == -5023) {
            this.f213678a = false;
            this.f213680c = false;
        } else if (!f213677y.a(i3)) {
            this.f213687j = MessageRecord.MSG_TYPE_UNITE_GRAY_NORMAL;
        }
    }

    public void a(GrayTipsMessageConstants$HighlightItem grayTipsMessageConstants$HighlightItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) grayTipsMessageConstants$HighlightItem);
            return;
        }
        synchronized (this.f213698u) {
            ArrayList<GrayTipsMessageConstants$HighlightItem> arrayList = this.f213694q;
            if (arrayList != null) {
                arrayList.add(grayTipsMessageConstants$HighlightItem);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x012f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [int] */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(int i3, int i16, Bundle bundle) {
        String string;
        int i17;
        String string2;
        String string3;
        Bitmap bitmap;
        String str;
        String str2;
        String str3;
        ?? r132;
        long parseLong;
        String string4;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), bundle);
            return;
        }
        if (i3 >= i16) {
            if (QLog.isColorLevel()) {
                QLog.e("UniteGrayTipParam", 2, "revoke msg UniteGrayTipParam addHightlightItem start >= end error,start=", Integer.valueOf(i3), ",end=", Integer.valueOf(i16));
                return;
            }
            return;
        }
        String str4 = null;
        if (bundle == null) {
            string = null;
            string2 = null;
            string3 = null;
            bitmap = null;
            i17 = -1;
        } else {
            int i18 = bundle.getInt("key_action");
            string = bundle.getString("textColor");
            i17 = i18;
            string2 = bundle.getString("image_resource");
            string3 = bundle.getString("image_alt");
            bitmap = (Bitmap) bundle.getParcelable("image_bitmap");
        }
        if (bundle != null) {
            if (i17 != 28 && i17 != 5) {
                if (h(i17)) {
                    String string5 = bundle.getString("key_action_DATA");
                    str2 = bundle.getString("key_a_action_DATA");
                    str3 = "";
                    r132 = 0;
                    str = string5;
                } else {
                    if (i17 == 19) {
                        string4 = bundle.getString("troop_mem_uin");
                        str = null;
                        str2 = null;
                        str3 = "";
                        z16 = false;
                    } else if (i17 != 33 && i17 != 42) {
                        if (i(i17)) {
                            str = bundle.getString("key_action_DATA");
                            str2 = null;
                            str3 = "";
                            r132 = 0;
                        } else if (i17 == 43) {
                            str3 = bundle.getString("remark");
                            str = null;
                            str2 = null;
                            r132 = 0;
                        }
                    } else {
                        String string6 = bundle.getString("key_action_DATA");
                        String string7 = bundle.getString("key_a_action_DATA");
                        string4 = bundle.getString("troop_mem_uin");
                        str = string6;
                        str3 = "";
                        z16 = false;
                        str2 = string7;
                    }
                    str4 = string4;
                    r132 = z16;
                }
            } else {
                String string8 = bundle.getString("troop_mem_uin");
                r132 = bundle.getBoolean("need_update_nick");
                str = null;
                str2 = null;
                str3 = "";
                str4 = string8;
            }
            if (this.f213694q == null) {
                this.f213694q = new ArrayList<>();
            }
            if (TextUtils.isEmpty(str4)) {
                try {
                    parseLong = Long.parseLong(str4);
                } catch (NumberFormatException unused) {
                    if (QLog.isColorLevel()) {
                        QLog.e("UniteGrayTipParam", 2, "getHightlightMsgText ==>NumberFormatException");
                        return;
                    }
                    return;
                }
            } else {
                parseLong = 0;
            }
            long j3 = parseLong;
            if (TextUtils.isEmpty(string)) {
                string = "#FF4D94FF";
            }
            a(new GrayTipsMessageConstants$HighlightItem(i3, i16, j3, r132, i17, str, str2, string2, string3, Color.parseColor(string), str3, 0, bitmap));
        }
        str = null;
        str2 = null;
        str3 = "";
        r132 = 0;
        if (this.f213694q == null) {
        }
        if (TextUtils.isEmpty(str4)) {
        }
        long j36 = parseLong;
        if (TextUtils.isEmpty(string)) {
        }
        a(new GrayTipsMessageConstants$HighlightItem(i3, i16, j36, r132, i17, str, str2, string2, string3, Color.parseColor(string), str3, 0, bitmap));
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        boolean a16 = f213677y.a(this.f213687j);
        boolean z16 = false;
        for (int i3 : f213676x) {
            if (i3 == this.f213685h) {
                z16 = true;
            }
        }
        if (!a16 || !z16) {
            return false;
        }
        return true;
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        synchronized (this.f213698u) {
            ArrayList<GrayTipsMessageConstants$HighlightItem> arrayList = this.f213694q;
            if (arrayList != null) {
                arrayList.clear();
            }
        }
    }

    public ArrayList<GrayTipsMessageConstants$HighlightItem> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ArrayList) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f213694q;
    }

    public ArrayList<GrayTipsMessageConstants$HighlightItem> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ArrayList) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        synchronized (this.f213698u) {
            if (this.f213694q == null) {
                return null;
            }
            return new ArrayList<>(this.f213694q);
        }
    }

    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.f213700w;
    }

    public void k(ArrayList<GrayTipsMessageConstants$HighlightItem> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) arrayList);
            return;
        }
        synchronized (this.f213698u) {
            if (arrayList != null) {
                ArrayList<GrayTipsMessageConstants$HighlightItem> arrayList2 = new ArrayList<>();
                this.f213694q = arrayList2;
                arrayList2.addAll(arrayList);
            } else {
                this.f213694q = null;
            }
        }
    }
}
