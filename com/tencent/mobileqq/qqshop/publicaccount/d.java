package com.tencent.mobileqq.qqshop.publicaccount;

import androidx.core.content.ContextCompat;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean;
import com.tencent.mobileqq.ecshop.conf.EcshopConfUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import ij2.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\t\u000fB\t\b\u0002\u00a2\u0006\u0004\b)\u0010*J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0011R\u001f\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00138\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001f\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00138\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017R\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0015\u001a\u0004\b\u001d\u0010\u0017R\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001c0\u00138\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001f\u0010\u0017R\u0016\u0010\"\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010!R\u0011\u0010%\u001a\u00020\u00148F\u00a2\u0006\u0006\u001a\u0004\b#\u0010$R\u0011\u0010(\u001a\u00020\u00198F\u00a2\u0006\u0006\u001a\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/d;", "", "Lij2/d$c;", "navInfo", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lij2/d$b;", "menuInfo", "l", "a", "Lij2/d$d;", "uiStyle", DomainData.DOMAIN_NAME, "o", "c", "b", "k", "", "d", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/qqshop/publicaccount/d$b;", "Landroidx/lifecycle/MutableLiveData;", "f", "()Landroidx/lifecycle/MutableLiveData;", "dailyTitleStyleLiveData", "Lcom/tencent/mobileqq/qqshop/publicaccount/d$a;", "e", "dailyMenuStyleLiveData", "", "i", "unreadDailyMsgCountLiveData", "j", "unreadPaMsgCountLiveData", "Z", "enableCoinsTab", h.F, "()Lcom/tencent/mobileqq/qqshop/publicaccount/d$b;", "defaultTitleStyle", "g", "()Lcom/tencent/mobileqq/qqshop/publicaccount/d$a;", "defaultMenuStyle", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f274576a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MutableLiveData<b> dailyTitleStyleLiveData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MutableLiveData<a> dailyMenuStyleLiveData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MutableLiveData<Integer> unreadDailyMsgCountLiveData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MutableLiveData<Integer> unreadPaMsgCountLiveData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static boolean enableCoinsTab;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0016\u0010\u0010R\u0017\u0010\u0019\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0014\u0010\f\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/d$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "e", "()Z", "isQuiStyle", "b", "I", "()I", "textNormalColor", "c", "textSelectColor", "d", "bgColor", "getPopBgColor", "popBgColor", "f", "isHidden", "<init>", "(ZIIIIZ)V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final /* data */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean isQuiStyle;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int textNormalColor;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int textSelectColor;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int bgColor;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int popBgColor;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final boolean isHidden;

        public a(boolean z16, int i3, int i16, int i17, int i18, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z17));
                return;
            }
            this.isQuiStyle = z16;
            this.textNormalColor = i3;
            this.textSelectColor = i16;
            this.bgColor = i17;
            this.popBgColor = i18;
            this.isHidden = z17;
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.bgColor;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.textNormalColor;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.textSelectColor;
        }

        public final boolean d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
            }
            return this.isHidden;
        }

        public final boolean e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return this.isQuiStyle;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            if (this.isQuiStyle == aVar.isQuiStyle && this.textNormalColor == aVar.textNormalColor && this.textSelectColor == aVar.textSelectColor && this.bgColor == aVar.bgColor && this.popBgColor == aVar.popBgColor && this.isHidden == aVar.isHidden) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v13 */
        /* JADX WARN: Type inference failed for: r0v17 */
        /* JADX WARN: Type inference failed for: r0v2, types: [int] */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
            }
            boolean z16 = this.isQuiStyle;
            int i3 = 1;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i16 = ((((((((r06 * 31) + this.textNormalColor) * 31) + this.textSelectColor) * 31) + this.bgColor) * 31) + this.popBgColor) * 31;
            boolean z17 = this.isHidden;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (String) iPatchRedirector.redirect((short) 15, (Object) this);
            }
            return "MenuStyle(isQuiStyle=" + this.isQuiStyle + ", textNormalColor=" + this.textNormalColor + ", textSelectColor=" + this.textSelectColor + ", bgColor=" + this.bgColor + ", popBgColor=" + this.popBgColor + ", isHidden=" + this.isHidden + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/d$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "c", "()Z", "isQuiStyle", "b", "I", "()I", "contentColor", "bgColor", "<init>", "(ZII)V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final /* data */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean isQuiStyle;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int contentColor;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int bgColor;

        public b(boolean z16, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            this.isQuiStyle = z16;
            this.contentColor = i3;
            this.bgColor = i16;
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.bgColor;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.contentColor;
        }

        public final boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return this.isQuiStyle;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (this.isQuiStyle == bVar.isQuiStyle && this.contentColor == bVar.contentColor && this.bgColor == bVar.bgColor) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v2, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            boolean z16 = this.isQuiStyle;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            return (((r06 * 31) + this.contentColor) * 31) + this.bgColor;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return "TitleStyle(isQuiStyle=" + this.isQuiStyle + ", contentColor=" + this.contentColor + ", bgColor=" + this.bgColor + ")";
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30982);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
            return;
        }
        f274576a = new d();
        dailyTitleStyleLiveData = new MutableLiveData<>();
        dailyMenuStyleLiveData = new MutableLiveData<>();
        unreadDailyMsgCountLiveData = new MutableLiveData<>();
        unreadPaMsgCountLiveData = new MutableLiveData<>();
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void l(d.MenuInfo menuInfo) {
        if (menuInfo == null) {
            return;
        }
        int textNormalColor = (int) menuInfo.getTextNormalColor();
        int textSelectColor = (int) menuInfo.getTextSelectColor();
        int bgColor = (int) menuInfo.getBgColor();
        dailyMenuStyleLiveData.postValue(new a(false, textNormalColor, textSelectColor, bgColor, bgColor, menuInfo.getIsHidden()));
    }

    private final void m(d.NavInfo navInfo) {
        if (navInfo == null) {
            return;
        }
        dailyTitleStyleLiveData.postValue(new b(false, (int) navInfo.getTextColor(), (int) navInfo.getBgColor()));
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            dailyTitleStyleLiveData.postValue(h());
            dailyMenuStyleLiveData.postValue(g());
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            com.tencent.mobileqq.qqshop.message.a.f274473a.a();
        }
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            com.tencent.mobileqq.qqshop.message.a.f274473a.c();
        }
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return enableCoinsTab;
    }

    @NotNull
    public final MutableLiveData<a> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return dailyMenuStyleLiveData;
    }

    @NotNull
    public final MutableLiveData<b> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return dailyTitleStyleLiveData;
    }

    @NotNull
    public final a g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new a(true, ContextCompat.getColor(MobileQQ.sMobileQQ, R.color.qui_common_text_primary), ContextCompat.getColor(MobileQQ.sMobileQQ, R.color.qui_common_icon_aio_toolbar_active), ContextCompat.getColor(MobileQQ.sMobileQQ, R.color.qui_common_bg_nav_bottom_aio), ContextCompat.getColor(MobileQQ.sMobileQQ, R.color.qui_common_bg_middle_light), false);
    }

    @NotNull
    public final b h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new b(true, ContextCompat.getColor(MobileQQ.sMobileQQ, R.color.qui_common_text_nav_secondary), ContextCompat.getColor(MobileQQ.sMobileQQ, R.color.qui_common_bg_nav_aio));
    }

    @NotNull
    public final MutableLiveData<Integer> i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return unreadDailyMsgCountLiveData;
    }

    @NotNull
    public final MutableLiveData<Integer> j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return unreadPaMsgCountLiveData;
    }

    public final void k() {
        EcshopConfBean.MsgTabPageConfig msgTabPageConfig;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        EcshopConfBean ecshopConfBean = EcshopConfUtil.getEcshopConfBean();
        String str = null;
        if (ecshopConfBean != null) {
            msgTabPageConfig = ecshopConfBean.msgTabPageConfig;
        } else {
            msgTabPageConfig = null;
        }
        boolean z17 = true;
        if (msgTabPageConfig != null && msgTabPageConfig.shouldEnableBenefitsCenterTab) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (msgTabPageConfig != null) {
                str = msgTabPageConfig.benefitsCenterTabExperimentName;
            }
            if (!x3.b.b(str)) {
                z17 = false;
            }
        }
        enableCoinsTab = z17;
    }

    public final void n(@NotNull d.UIStyle uiStyle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) uiStyle);
            return;
        }
        Intrinsics.checkNotNullParameter(uiStyle, "uiStyle");
        if (uiStyle.getIsCustomUI()) {
            m(uiStyle.getNavInfo());
            l(uiStyle.getMenuInfo());
        } else {
            dailyTitleStyleLiveData.postValue(h());
            dailyMenuStyleLiveData.postValue(g());
        }
    }

    public final void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        com.tencent.mobileqq.qqshop.message.a aVar = com.tencent.mobileqq.qqshop.message.a.f274473a;
        unreadPaMsgCountLiveData.postValue(Integer.valueOf(aVar.o()));
        unreadDailyMsgCountLiveData.postValue(Integer.valueOf(aVar.g()));
    }
}
