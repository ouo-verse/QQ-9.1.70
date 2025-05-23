package com.tencent.mobileqq.vip;

import android.content.Context;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.api.IVasManager;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface IGameCardManager extends IVasManager {
    public static final String AIO = "qunliao";
    public static final String CARD = "ziliaoka";
    public static final String DRAWER = "choutiye";
    public static final int EXT_ICON = 2;
    public static final int ICON = 1;
    public static final String LIST = "list";
    public static final String OWNER = "owner";
    public static final int QQSETTING_ICON_HEIGHT = 15;
    public static final int QQSETTING_ICON_MARGIN = 5;
    public static final int QQSETTING_ICON_WIDTH = 47;
    public static final String VISITOR = "visitor";

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f312733a;

        /* renamed from: b, reason: collision with root package name */
        public String f312734b;

        /* renamed from: c, reason: collision with root package name */
        public long f312735c;

        /* renamed from: d, reason: collision with root package name */
        public int f312736d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f312737e;

        /* renamed from: f, reason: collision with root package name */
        public int f312738f;

        public a(long j3, int i3, boolean z16, int i16) {
            this("", j3, i3, z16, i16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16));
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "GameCardInfo{uin='" + this.f312734b + "', gameAppId=" + this.f312735c + ", dan=" + this.f312736d + ", danSwitch=" + this.f312737e + ", gameCardId=" + this.f312738f + '}';
        }

        public a(String str, long j3, int i3, boolean z16, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Long.valueOf(j3), Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16));
                return;
            }
            this.f312734b = str;
            this.f312735c = j3;
            this.f312736d = i3;
            this.f312737e = z16;
            this.f312738f = i16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface b {
        void a(URLDrawable uRLDrawable);

        void b(URLDrawable uRLDrawable);

        void c(URLDrawable uRLDrawable);

        void d(URLDrawable uRLDrawable);
    }

    boolean checkGameCardAble(boolean z16, int i3);

    String getCardResPath(int i3, int i16);

    URLDrawable getGameCardDrawable(boolean z16, a aVar, b bVar);

    void gotoGameIconSetWeb(Context context, String str, boolean z16, int i3);

    void gotoKingIconSetWeb(Context context);

    boolean isSelf(String str);
}
