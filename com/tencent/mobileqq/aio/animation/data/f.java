package com.tencent.mobileqq.aio.animation.data;

import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u0000 \f2\u00020\u0001:\u0002\f\tJ2\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H&J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\r\u001a\u00020\u0000H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/data/f;", "", "Lcom/tencent/mobileqq/aio/animation/data/f$b;", "values", "", "width", "height", "containerWidth", "containerHeight", "b", "", "duration", "a", "clone", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public interface f {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/data/f$a;", "", "Lcom/tencent/mobileqq/aio/animation/data/f$b;", "b", "Lcom/tencent/mobileqq/aio/animation/data/f$b;", "getEND", "()Lcom/tencent/mobileqq/aio/animation/data/f$b;", "END", "<init>", "()V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.animation.data.f$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f188062a;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final b END;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29760);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f188062a = new Companion();
                END = new b();
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b>\u0010?R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0014\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0017\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\"\u0010\u001a\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\"\u0010\u001e\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u001c\u0010\u0011\"\u0004\b\u001d\u0010\u0013R\"\u0010!\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013R\"\u0010#\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b\u0003\u0010\u0011\"\u0004\b\"\u0010\u0013R\"\u0010*\u001a\u00020$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b%\u0010'\"\u0004\b(\u0010)R\"\u00101\u001a\u00020+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b\u001b\u0010.\"\u0004\b/\u00100R$\u00107\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u00103\u001a\u0004\b,\u00104\"\u0004\b5\u00106R$\u0010=\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u00109\u001a\u0004\b\n\u0010:\"\u0004\b;\u0010<\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/data/f$b;", "", "", "a", "I", "k", "()I", "setX", "(I)V", HippyTKDListViewAdapter.X, "b", "l", "setY", "y", "", "c", UserInfo.SEX_FEMALE, "()F", "setRotate", "(F)V", CanvasView.ACTION_ROTATE, "d", "setRotateX", "rotateX", "e", "setRotateY", "rotateY", "f", "g", "setScaleX", BasicAnimation.KeyPath.SCALE_X, tl.h.F, "setScaleY", BasicAnimation.KeyPath.SCALE_Y, "setAlpha", com.tencent.luggage.wxa.c8.c.f123400v, "", "i", "J", "()J", "o", "(J)V", "startTime", "", "j", "Z", "()Z", DomainData.DOMAIN_NAME, "(Z)V", "running", "Landroid/view/View;", "Landroid/view/View;", "()Landroid/view/View;", "p", "(Landroid/view/View;)V", "view", "Lcom/tencent/mobileqq/aio/animation/data/f;", "Lcom/tencent/mobileqq/aio/animation/data/f;", "()Lcom/tencent/mobileqq/aio/animation/data/f;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/mobileqq/aio/animation/data/f;)V", "path", "<init>", "()V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int x;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int y;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private float rotate;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private float rotateX;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private float rotateY;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private float scaleX;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private float scaleY;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private float alpha;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private long startTime;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        private boolean running;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private View view;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private f path;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.scaleX = 1.0f;
            this.scaleY = 1.0f;
            this.alpha = 1.0f;
        }

        public final float a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                return ((Float) iPatchRedirector.redirect((short) 22, (Object) this)).floatValue();
            }
            return this.alpha;
        }

        @Nullable
        public final f b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
                return (f) iPatchRedirector.redirect((short) 30, (Object) this);
            }
            return this.path;
        }

        public final float c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Float) iPatchRedirector.redirect((short) 10, (Object) this)).floatValue();
            }
            return this.rotate;
        }

        public final float d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Float) iPatchRedirector.redirect((short) 12, (Object) this)).floatValue();
            }
            return this.rotateX;
        }

        public final float e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Float) iPatchRedirector.redirect((short) 14, (Object) this)).floatValue();
            }
            return this.rotateY;
        }

        public final boolean f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
                return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
            }
            return this.running;
        }

        public final float g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return ((Float) iPatchRedirector.redirect((short) 16, (Object) this)).floatValue();
            }
            return this.scaleX;
        }

        public final float h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return ((Float) iPatchRedirector.redirect((short) 18, (Object) this)).floatValue();
            }
            return this.scaleY;
        }

        public final long i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                return ((Long) iPatchRedirector.redirect((short) 24, (Object) this)).longValue();
            }
            return this.startTime;
        }

        @Nullable
        public final View j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
                return (View) iPatchRedirector.redirect((short) 28, (Object) this);
            }
            return this.view;
        }

        public final int k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.x;
        }

        public final int l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return this.y;
        }

        public final void m(@Nullable f fVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
                iPatchRedirector.redirect((short) 31, (Object) this, (Object) fVar);
            } else {
                this.path = fVar;
            }
        }

        public final void n(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
                iPatchRedirector.redirect((short) 27, (Object) this, z16);
            } else {
                this.running = z16;
            }
        }

        public final void o(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                iPatchRedirector.redirect((short) 25, (Object) this, j3);
            } else {
                this.startTime = j3;
            }
        }

        public final void p(@Nullable View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
                iPatchRedirector.redirect((short) 29, (Object) this, (Object) view);
            } else {
                this.view = view;
            }
        }
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(29768), (Class<?>) f.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.f188062a;
        }
    }

    int a(long duration, @Nullable b values);

    int b(@Nullable b values, int width, int height, int containerWidth, int containerHeight);

    @NotNull
    f clone();
}
