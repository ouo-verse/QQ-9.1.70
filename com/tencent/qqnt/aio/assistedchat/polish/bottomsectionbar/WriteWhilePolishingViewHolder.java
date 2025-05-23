package com.tencent.qqnt.aio.assistedchat.polish.bottomsectionbar;

import android.graphics.drawable.Drawable;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieDrawable;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqnt.aio.utils.l;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 '2\u00020\u0001:\u0002()B\u0017\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0002R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u00188FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\"\u001a\u00020\u001e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010!\u00a8\u0006*"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/polish/bottomsectionbar/WriteWhilePolishingViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "p", "", "content", "", "suffixLength", "r", ReportConstant.COSTREPORT_PREFIX, "Lp81/c;", "E", "Lp81/c;", "l", "()Lp81/c;", "binding", "Lcom/airbnb/lottie/LottieDrawable;", UserInfo.SEX_FEMALE, "Lcom/airbnb/lottie/LottieDrawable;", "getLottieDrawable", "()Lcom/airbnb/lottie/LottieDrawable;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Lcom/airbnb/lottie/LottieDrawable;)V", "lottieDrawable", "Landroid/graphics/drawable/Drawable;", "G", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/graphics/drawable/Drawable;", "defaultIconDrawable", "Lcom/tencent/qqnt/aio/assistedchat/polish/b;", "H", "o", "()Lcom/tencent/qqnt/aio/assistedchat/polish/b;", "loadingHelper", "", "enableAIOBlur", "<init>", "(ZLp81/c;)V", "I", "a", "b", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class WriteWhilePolishingViewHolder extends RecyclerView.ViewHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final p81.c binding;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private LottieDrawable lottieDrawable;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy defaultIconDrawable;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy loadingHelper;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/polish/bottomsectionbar/WriteWhilePolishingViewHolder$a;", "", "", "LOTTIE_PATH", "Ljava/lang/String;", "TAG", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.assistedchat.polish.bottomsectionbar.WriteWhilePolishingViewHolder$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\r\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\"\u0010\u0011\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/polish/bottomsectionbar/WriteWhilePolishingViewHolder$b;", "Lcom/tencent/mobileqq/onlinestatus/utils/LottieHelper$d;", "Lcom/airbnb/lottie/LottieDrawable;", "drawable", "", "onLoad", "", "a", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "tag", "Lmqq/util/WeakReference;", "Lcom/tencent/qqnt/aio/assistedchat/polish/bottomsectionbar/WriteWhilePolishingViewHolder;", "kotlin.jvm.PlatformType", "b", "Lmqq/util/WeakReference;", "weakRef", "holder", "<init>", "(Ljava/lang/String;Lcom/tencent/qqnt/aio/assistedchat/polish/bottomsectionbar/WriteWhilePolishingViewHolder;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements LottieHelper.d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String tag;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<WriteWhilePolishingViewHolder> weakRef;

        public b(@NotNull String tag, @NotNull WriteWhilePolishingViewHolder holder) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(holder, "holder");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) tag, (Object) holder);
            } else {
                this.tag = tag;
                this.weakRef = new WeakReference<>(holder);
            }
        }

        @Override // com.tencent.mobileqq.onlinestatus.utils.LottieHelper.d
        public void onLoad(@Nullable LottieDrawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) drawable);
                return;
            }
            WriteWhilePolishingViewHolder writeWhilePolishingViewHolder = this.weakRef.get();
            if (writeWhilePolishingViewHolder == null) {
                return;
            }
            if (drawable == null) {
                QLog.i(this.tag, 1, "onLoad lottie is null.");
                writeWhilePolishingViewHolder.l().f425718b.setImageDrawable(writeWhilePolishingViewHolder.m());
            } else {
                writeWhilePolishingViewHolder.o().d(drawable, ContextCompat.getColor(writeWhilePolishingViewHolder.l().getRoot().getContext(), R.color.qui_common_icon_primary));
                writeWhilePolishingViewHolder.l().f425718b.setImageDrawable(drawable);
                drawable.start();
                writeWhilePolishingViewHolder.q(drawable);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59919);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WriteWhilePolishingViewHolder(final boolean z16, @NotNull p81.c binding) {
        super(binding.getRoot());
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(binding, "binding");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), binding);
            return;
        }
        this.binding = binding;
        int b16 = l.b(5);
        AIOUtil.f194084a.e(binding.f425720d, b16, b16, b16, b16);
        TextView textView = binding.f425720d;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.rightBtn");
        xu3.b.b(textView);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Drawable>() { // from class: com.tencent.qqnt.aio.assistedchat.polish.bottomsectionbar.WriteWhilePolishingViewHolder$defaultIconDrawable$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WriteWhilePolishingViewHolder.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Drawable invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? ContextCompat.getDrawable(WriteWhilePolishingViewHolder.this.l().getRoot().getContext(), R.drawable.qui_assisted_chat_bottom_bar) : (Drawable) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.defaultIconDrawable = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.qqnt.aio.assistedchat.polish.b>(z16) { // from class: com.tencent.qqnt.aio.assistedchat.polish.bottomsectionbar.WriteWhilePolishingViewHolder$loadingHelper$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ boolean $enableAIOBlur;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$enableAIOBlur = z16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, z16);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.qqnt.aio.assistedchat.polish.b invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new com.tencent.qqnt.aio.assistedchat.polish.b(this.$enableAIOBlur) : (com.tencent.qqnt.aio.assistedchat.polish.b) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.loadingHelper = lazy2;
    }

    private final void p() {
        if (!o().b()) {
            this.binding.f425718b.setImageDrawable(m());
            return;
        }
        LottieDrawable lottieDrawable = this.lottieDrawable;
        if (lottieDrawable != null) {
            this.binding.f425718b.setImageDrawable(lottieDrawable);
            lottieDrawable.start();
        } else {
            LottieHelper.b(this.binding.getRoot().getContext(), "assisted_chat/polish.json", "", 0, 0, -1, new b("WriteWhilePolishingViewHolder", this));
        }
    }

    @NotNull
    public final p81.c l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (p81.c) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.binding;
    }

    @Nullable
    public final Drawable m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Drawable) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return (Drawable) this.defaultIconDrawable.getValue();
    }

    @NotNull
    public final com.tencent.qqnt.aio.assistedchat.polish.b o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.qqnt.aio.assistedchat.polish.b) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return (com.tencent.qqnt.aio.assistedchat.polish.b) this.loadingHelper.getValue();
    }

    public final void q(@Nullable LottieDrawable lottieDrawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) lottieDrawable);
        } else {
            this.lottieDrawable = lottieDrawable;
        }
    }

    public final void r(@NotNull CharSequence content, int suffixLength) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) content, suffixLength);
            return;
        }
        Intrinsics.checkNotNullParameter(content, "content");
        p();
        if (suffixLength > 0) {
            content = content.subSequence(0, content.length() - suffixLength);
        }
        TextView textView = this.binding.f425719c;
        StringBuilder sb5 = new StringBuilder(content);
        sb5.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
        textView.setText(sb5);
    }

    public final void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        LottieDrawable lottieDrawable = this.lottieDrawable;
        if (lottieDrawable != null) {
            lottieDrawable.stop();
        }
        this.binding.f425718b.setImageDrawable(m());
    }
}
