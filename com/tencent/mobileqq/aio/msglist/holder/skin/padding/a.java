package com.tencent.mobileqq.aio.msglist.holder.skin.padding;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.aio.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001:\u0003\u0004\u0007\bB\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/skin/padding/a;", "", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "a", "<init>", "()V", "b", "c", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004R\u0011\u0010\t\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u000b\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0011\u0010\r\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0011\u0010\u000f\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/skin/padding/a$a;", "", "", "e", "", "needCheck", "f", "d", "()I", "displayWidth", "c", "densityDpi", "a", "aioOtherSpaceValue", "b", "bubbleMaxWidth", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.skin.padding.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static final class C7329a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final C7329a f192417a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48963);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 8)) {
                redirector.redirect((short) 8);
            } else {
                f192417a = new C7329a();
            }
        }

        C7329a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private final int e() {
            float fontScale = FontSettingManager.getFontScale();
            if (fontScale > 0.0f) {
                return d() - ((int) ((ViewUtils.f352270a.b(108) / fontScale) / fontScale));
            }
            return d() - ViewUtils.f352270a.b(108);
        }

        public static /* synthetic */ int g(C7329a c7329a, boolean z16, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                z16 = false;
            }
            return c7329a.f(z16);
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return 108;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return e();
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return BaseApplication.context.getResources().getDisplayMetrics().densityDpi;
        }

        public final int d() {
            int coerceAtMost;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            com.tencent.mobileqq.aio.utils.e eVar = com.tencent.mobileqq.aio.utils.e.f194142a;
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(eVar.f(), eVar.e());
            return coerceAtMost;
        }

        public final int f(boolean needCheck) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, needCheck)).intValue();
            }
            float fontScale = FontSettingManager.getFontScale();
            if (fontScale > 0.0f) {
                if (needCheck) {
                    ViewUtils viewUtils = ViewUtils.f352270a;
                    return com.tencent.mobileqq.aio.utils.e.f194142a.d() - ((int) Math.max((viewUtils.b(108) / fontScale) / fontScale, viewUtils.b(83)));
                }
                return com.tencent.mobileqq.aio.utils.e.f194142a.d() - ((int) ((ViewUtils.f352270a.b(108) / fontScale) / fontScale));
            }
            return com.tencent.mobileqq.aio.utils.e.f194142a.d() - ViewUtils.f352270a.b(108);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0005R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\n\u0010\u0005R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\u0007\u0010\u0005R\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\f\u0010\u0005R\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u000e\u0010\u0005\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/skin/padding/a$b;", "", "", "b", "I", "()I", "BUBBLE_PADDING_ALIGN_HEAD_NOT_TOKEN", "c", "a", "BUBBLE_PADDING_ALIGN_ERROR_NOT_TOKEN", "d", "BUBBLE_PADDING_TOP_NOT_TOKEN", "e", "BUBBLE_PADDING_BOTTOM_NOT_TOKEN", "f", "TEXT_PADDING_WITH_BUBBLE_HOR_BORDER_NOT_TOKEN", "g", "TEXT_PADDING_WITH_BUBBLE_VEC_BORDER_NOT_TOKEN", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f192418a;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private static final int BUBBLE_PADDING_ALIGN_HEAD_NOT_TOKEN;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private static final int BUBBLE_PADDING_ALIGN_ERROR_NOT_TOKEN;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private static final int BUBBLE_PADDING_TOP_NOT_TOKEN;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private static final int BUBBLE_PADDING_BOTTOM_NOT_TOKEN;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private static final int TEXT_PADDING_WITH_BUBBLE_HOR_BORDER_NOT_TOKEN;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private static final int TEXT_PADDING_WITH_BUBBLE_VEC_BORDER_NOT_TOKEN;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48965);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 8)) {
                redirector.redirect((short) 8);
                return;
            }
            f192418a = new b();
            BUBBLE_PADDING_ALIGN_HEAD_NOT_TOKEN = BaseApplication.context.getResources().getDimensionPixelSize(R.dimen.bz6);
            BUBBLE_PADDING_ALIGN_ERROR_NOT_TOKEN = BaseApplication.context.getResources().getDimensionPixelSize(R.dimen.f158198bz3);
            BUBBLE_PADDING_TOP_NOT_TOKEN = BaseApplication.context.getResources().getDimensionPixelSize(R.dimen.bza);
            BUBBLE_PADDING_BOTTOM_NOT_TOKEN = BaseApplication.context.getResources().getDimensionPixelSize(R.dimen.bz9);
            TEXT_PADDING_WITH_BUBBLE_HOR_BORDER_NOT_TOKEN = BaseApplication.context.getResources().getDimensionPixelSize(R.dimen.f159588df1);
            TEXT_PADDING_WITH_BUBBLE_VEC_BORDER_NOT_TOKEN = BaseApplication.context.getResources().getDimensionPixelSize(R.dimen.f159589df2);
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return BUBBLE_PADDING_ALIGN_ERROR_NOT_TOKEN;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return BUBBLE_PADDING_ALIGN_HEAD_NOT_TOKEN;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return BUBBLE_PADDING_BOTTOM_NOT_TOKEN;
        }

        public final int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return BUBBLE_PADDING_TOP_NOT_TOKEN;
        }

        public final int e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return TEXT_PADDING_WITH_BUBBLE_HOR_BORDER_NOT_TOKEN;
        }

        public final int f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            return TEXT_PADDING_WITH_BUBBLE_VEC_BORDER_NOT_TOKEN;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0005R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\n\u0010\u0005R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\u0007\u0010\u0005R\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\f\u0010\u0005\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/skin/padding/a$c;", "", "", "b", "I", "()I", "BUBBLE_PADDING_ALIGN_HEAD_WITH_TOKEN", "c", "a", "BUBBLE_PADDING_ALIGN_ERROR_WITH_TOKEN", "d", "BUBBLE_PADDING_TOP_WITH_TOKEN", "e", "BUBBLE_PADDING_BOTTOM_WITH_TOKEN", "f", "TEXT_PADDING_WITH_BUBBLE_BORDER_WITH_TOKEN", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final c f192425a;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private static final int BUBBLE_PADDING_ALIGN_HEAD_WITH_TOKEN;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private static final int BUBBLE_PADDING_ALIGN_ERROR_WITH_TOKEN;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private static final int BUBBLE_PADDING_TOP_WITH_TOKEN;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private static final int BUBBLE_PADDING_BOTTOM_WITH_TOKEN;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private static final int TEXT_PADDING_WITH_BUBBLE_BORDER_WITH_TOKEN;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48966);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 7)) {
                redirector.redirect((short) 7);
                return;
            }
            f192425a = new c();
            BUBBLE_PADDING_ALIGN_HEAD_WITH_TOKEN = BaseApplication.context.getResources().getDimensionPixelSize(R.dimen.bz8);
            BUBBLE_PADDING_ALIGN_ERROR_WITH_TOKEN = BaseApplication.context.getResources().getDimensionPixelSize(R.dimen.bz5);
            BUBBLE_PADDING_TOP_WITH_TOKEN = BaseApplication.context.getResources().getDimensionPixelSize(R.dimen.bzb);
            BUBBLE_PADDING_BOTTOM_WITH_TOKEN = BaseApplication.context.getResources().getDimensionPixelSize(R.dimen.bz_);
            TEXT_PADDING_WITH_BUBBLE_BORDER_WITH_TOKEN = BaseApplication.context.getResources().getDimensionPixelSize(R.dimen.f159587df0);
        }

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return BUBBLE_PADDING_ALIGN_ERROR_WITH_TOKEN;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return BUBBLE_PADDING_ALIGN_HEAD_WITH_TOKEN;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return BUBBLE_PADDING_BOTTOM_WITH_TOKEN;
        }

        public final int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return BUBBLE_PADDING_TOP_WITH_TOKEN;
        }

        public final int e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return TEXT_PADDING_WITH_BUBBLE_BORDER_WITH_TOKEN;
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public abstract a a(@NotNull AIOMsgItem msgItem);
}
