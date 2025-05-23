package com.tencent.qqnt.miniaio;

import android.content.Context;
import com.tencent.aio.api.factory.f;
import com.tencent.aio.api.factory.j;
import com.tencent.aio.base.mvi.part.TopTipViewState;
import com.tencent.mobileqq.aio.AIOFactory;
import com.tencent.mobileqq.aio.factory.AIOMsgAdornApiImpl;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqnt.miniaio.title.MiniAIOTitleVB;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/miniaio/MiniaioFactory;", "Lcom/tencent/mobileqq/aio/AIOFactory;", "Lcom/tencent/aio/api/factory/f;", "buildBusinessLevel", "Lcom/tencent/aio/api/factory/j;", "buildMsgLevel", "Landroid/content/Context;", "context", "", "d", "Lcom/tencent/aio/api/factory/d;", "buildReserve1Level", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class MiniaioFactory extends AIOFactory {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/miniaio/MiniaioFactory$a", "Lcom/tencent/aio/api/factory/f;", "Lcom/tencent/mobileqq/aio/input/inputbar/a;", "Lcom/tencent/qqnt/miniaio/input/viewbinding/a;", h.F, "Lcom/tencent/qqnt/miniaio/title/MiniAIOTitleVB;", "i", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class a implements f {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.aio.api.factory.f
        @Nullable
        public com.tencent.aio.base.mvvm.a<Object, Object> buildBottomBarVB() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return f.a.a(this);
        }

        @Override // com.tencent.aio.api.factory.f
        @Nullable
        public List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> buildBusinessVB() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (List) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return f.a.b(this);
        }

        @Override // com.tencent.aio.api.factory.f
        @Nullable
        public com.tencent.aio.base.mvvm.a<Object, Object> buildShortcutBarVB() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return f.a.d(this);
        }

        @Override // com.tencent.aio.api.factory.f
        @Nullable
        public com.tencent.aio.base.mvvm.a<? extends at.e, ? extends TopTipViewState> buildTopTipVB() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (com.tencent.aio.base.mvvm.a) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return f.a.f(this);
        }

        @Override // com.tencent.aio.api.factory.h
        @Nullable
        public com.tencent.aio.api.b getLayoutDelegate() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (com.tencent.aio.api.b) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return f.a.g(this);
        }

        @Override // com.tencent.aio.api.factory.f
        @NotNull
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public com.tencent.mobileqq.aio.input.inputbar.a<com.tencent.qqnt.miniaio.input.viewbinding.a> buildInputVB() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.mobileqq.aio.input.inputbar.a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new com.tencent.mobileqq.aio.input.inputbar.a<>(new com.tencent.mobileqq.aio.factory.inputadorn.e());
        }

        @Override // com.tencent.aio.api.factory.f
        @NotNull
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public MiniAIOTitleVB buildTitleVB() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (MiniAIOTitleVB) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return new MiniAIOTitleVB();
        }
    }

    public MiniaioFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.aio.AIOFactory, com.tencent.aio.api.factory.g
    @NotNull
    public f buildBusinessLevel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (f) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new a();
    }

    @Override // com.tencent.mobileqq.aio.AIOFactory, com.tencent.aio.api.factory.g
    @NotNull
    public j buildMsgLevel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (j) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new AIOMsgAdornApiImpl(null, null, null, new MiniaioFactory$buildMsgLevel$1(this), null, 23, null);
    }

    @Override // com.tencent.mobileqq.aio.AIOFactory, com.tencent.aio.api.factory.g
    @Nullable
    public com.tencent.aio.api.factory.d buildReserve1Level() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.aio.api.factory.d) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return null;
    }

    public final int d(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context)).intValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return AIOUtil.f194084a.m(context, false, true);
    }
}
