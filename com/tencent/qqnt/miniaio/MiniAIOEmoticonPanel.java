package com.tencent.qqnt.miniaio;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.emotion.SystemAndEmojiPanel;
import com.tencent.qqnt.emotion.info.SystemAndEmojiEmotionInfo;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0016\u0012\u0006\u0010 \u001a\u00020\u001b\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0016J$\u0010\u0014\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0015\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\u0017\u0010\u001a\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR#\u0010%\u001a\n \"*\u0004\u0018\u00010!0!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010#\u001a\u0004\b\u0013\u0010$R\u001b\u0010(\u001a\u00020\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010#\u001a\u0004\b\u001c\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/qqnt/miniaio/MiniAIOEmoticonPanel;", "Lcom/tencent/qqnt/b;", "Lcom/tencent/qqnt/miniaio/c;", "Lcom/tencent/qqnt/emotion/SystemAndEmojiPanel;", "f", "", "inputContent", "", "a", "e0", "delete", "Lcom/tencent/qqnt/emotion/info/SystemAndEmojiEmotionInfo;", "info", "f0", "", "h0", "oldInfo", "newInfo", "Landroid/graphics/drawable/Drawable;", "d", "g0", "i0", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "c", "()Landroid/view/ViewGroup;", "mContainerView", "Lcom/tencent/qqnt/miniaio/d;", "e", "Lcom/tencent/qqnt/miniaio/d;", "getMCallback", "()Lcom/tencent/qqnt/miniaio/d;", "mCallback", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "()Landroid/content/Context;", "mContext", h.F, "()Lcom/tencent/qqnt/emotion/SystemAndEmojiPanel;", "mEmotionPanel", "<init>", "(Landroid/view/ViewGroup;Lcom/tencent/qqnt/miniaio/d;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class MiniAIOEmoticonPanel implements com.tencent.qqnt.b, c {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup mContainerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d mCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mContext;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mEmotionPanel;

    public MiniAIOEmoticonPanel(@NotNull ViewGroup mContainerView, @NotNull d mCallback) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(mContainerView, "mContainerView");
        Intrinsics.checkNotNullParameter(mCallback, "mCallback");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mContainerView, (Object) mCallback);
            return;
        }
        this.mContainerView = mContainerView;
        this.mCallback = mCallback;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Context>() { // from class: com.tencent.qqnt.miniaio.MiniAIOEmoticonPanel$mContext$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MiniAIOEmoticonPanel.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Context invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? MiniAIOEmoticonPanel.this.c().getContext() : (Context) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.mContext = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<SystemAndEmojiPanel>() { // from class: com.tencent.qqnt.miniaio.MiniAIOEmoticonPanel$mEmotionPanel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MiniAIOEmoticonPanel.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SystemAndEmojiPanel invoke() {
                Context mContext;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (SystemAndEmojiPanel) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                mContext = MiniAIOEmoticonPanel.this.d();
                Intrinsics.checkNotNullExpressionValue(mContext, "mContext");
                SystemAndEmojiPanel systemAndEmojiPanel = new SystemAndEmojiPanel(mContext);
                systemAndEmojiPanel.f(MiniAIOEmoticonPanel.this);
                systemAndEmojiPanel.e();
                return systemAndEmojiPanel;
            }
        });
        this.mEmotionPanel = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Context d() {
        return (Context) this.mContext.getValue();
    }

    private final SystemAndEmojiPanel e() {
        return (SystemAndEmojiPanel) this.mEmotionPanel.getValue();
    }

    @Override // com.tencent.qqnt.miniaio.c
    public void a(@NotNull CharSequence inputContent) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) inputContent);
            return;
        }
        Intrinsics.checkNotNullParameter(inputContent, "inputContent");
        SystemAndEmojiPanel e16 = e();
        if (inputContent.length() > 0) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        e16.setOperationVisibility(i3);
    }

    @NotNull
    public final ViewGroup c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ViewGroup) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mContainerView;
    }

    @Override // com.tencent.qqnt.b
    public void delete() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.mCallback.delete();
        }
    }

    @Override // com.tencent.qqnt.b
    public void e0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.mCallback.e0();
        }
    }

    @Override // com.tencent.qqnt.miniaio.c
    @NotNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public SystemAndEmojiPanel getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SystemAndEmojiPanel) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return e();
    }

    @Override // com.tencent.qqnt.b
    public void f0(@NotNull SystemAndEmojiEmotionInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) info);
        } else {
            Intrinsics.checkNotNullParameter(info, "info");
            this.mCallback.oa(info.c(), info.getCode());
        }
    }

    @Override // com.tencent.qqnt.b
    public void g0(@Nullable SystemAndEmojiEmotionInfo oldInfo, @NotNull SystemAndEmojiEmotionInfo newInfo, @Nullable Drawable d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, oldInfo, newInfo, d16);
        } else {
            Intrinsics.checkNotNullParameter(newInfo, "newInfo");
        }
    }

    @Override // com.tencent.qqnt.b
    public boolean h0(@NotNull SystemAndEmojiEmotionInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) info)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(info, "info");
        return true;
    }

    @Override // com.tencent.qqnt.b
    public void i0(@Nullable SystemAndEmojiEmotionInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) info);
        }
    }
}
