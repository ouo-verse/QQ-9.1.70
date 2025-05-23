package com.tencent.qqnt.audio.tts.ui;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LoadingUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 =2\u00020\u0001:\u0001\u0012B'\b\u0007\u0012\u0006\u00107\u001a\u000206\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u000108\u0012\b\b\u0002\u0010:\u001a\u00020\u000b\u00a2\u0006\u0004\b;\u0010<J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J\u0006\u0010\u0013\u001a\u00020\u0003R\u0014\u0010\u0015\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0014R\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001bR.\u0010#\u001a\u0004\u0018\u00010\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\b8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R.\u0010'\u001a\u0004\u0018\u00010\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\b8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u001e\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R$\u0010/\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0014\u00102\u001a\u0002008BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u00101R\u0014\u00104\u001a\u0002008BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b3\u00101R\u0011\u00105\u001a\u0002008F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u00101\u00a8\u0006>"}, d2 = {"Lcom/tencent/qqnt/audio/tts/ui/TtsView;", "Landroid/widget/FrameLayout;", ParseCommon.CONTAINER, "", "d", tl.h.F, "i", "j", "Landroid/graphics/drawable/Drawable;", "drawable", "k", "", "id", "b", "", "sessionId", "Lcom/tencent/qqnt/audio/tts/ui/b;", "playData", "a", "l", "I", "ICON_WIDTH", "e", "J", "f", "Lcom/tencent/qqnt/audio/tts/ui/b;", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "iconView", "value", "Landroid/graphics/drawable/Drawable;", "getPlayingIconDrawable", "()Landroid/graphics/drawable/Drawable;", "setPlayingIconDrawable", "(Landroid/graphics/drawable/Drawable;)V", "playingIconDrawable", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getPauseIconDrawable", "setPauseIconDrawable", "pauseIconDrawable", "Landroid/view/View;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "c", "()Landroid/view/View;", "setLoadingView", "(Landroid/view/View;)V", "loadingView", "", "()Z", "isLoading", "g", "isWaiting", "isPlaying", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "D", "qq_audio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class TtsView extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private View loadingView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int ICON_WIDTH;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long sessionId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b playData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView iconView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable playingIconDrawable;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable pauseIconDrawable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/audio/tts/ui/TtsView$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq_audio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.audio.tts.ui.TtsView$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36504);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TtsView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            return;
        }
        iPatchRedirector.redirect((short) 13, (Object) this, (Object) context);
    }

    private final Drawable b(int id5) {
        Drawable mutate;
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), id5, null);
        if (drawable == null || (mutate = drawable.mutate()) == null) {
            return null;
        }
        mutate.setColorFilter(new PorterDuffColorFilter(getContext().getColor(R.color.qui_common_on_brand_primary), PorterDuff.Mode.SRC_IN));
        return mutate;
    }

    private final void d(FrameLayout container) {
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        int i3 = this.ICON_WIDTH;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i3);
        layoutParams.gravity = 17;
        Unit unit = Unit.INSTANCE;
        container.addView(imageView, layoutParams);
        this.iconView = imageView;
        Context context = getContext();
        int i16 = this.ICON_WIDTH;
        View loadingView = LoadingUtil.getLoadingView(context, i16, i16, 1);
        int i17 = this.ICON_WIDTH;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i17, i17);
        layoutParams2.gravity = 17;
        container.addView(loadingView, layoutParams2);
        this.loadingView = loadingView;
        if (loadingView != null) {
            loadingView.setVisibility(8);
        }
    }

    private final boolean e() {
        return e.INSTANCE.b().l(this.sessionId);
    }

    private final boolean g() {
        return e.INSTANCE.b().n(this.sessionId);
    }

    private final void h() {
        ImageView imageView = this.iconView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconView");
            imageView = null;
        }
        imageView.setVisibility(8);
        View view = this.loadingView;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private final void i() {
        if (this.pauseIconDrawable == null) {
            setPauseIconDrawable(b(R.drawable.qui_volume_plus));
        }
        k(this.pauseIconDrawable);
    }

    private final void j() {
        if (this.playingIconDrawable == null) {
            setPlayingIconDrawable(b(R.drawable.qui_play_filled));
        }
        k(this.playingIconDrawable);
    }

    private final void k(Drawable drawable) {
        ImageView imageView = this.iconView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconView");
            imageView = null;
        }
        imageView.setVisibility(0);
        View view = this.loadingView;
        if (view != null) {
            view.setVisibility(8);
        }
        ImageView imageView3 = this.iconView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconView");
        } else {
            imageView2 = imageView3;
        }
        if (drawable != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    @MainThread
    public final void a(long sessionId, @NotNull b playData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Long.valueOf(sessionId), playData);
            return;
        }
        Intrinsics.checkNotNullParameter(playData, "playData");
        if (QLog.isColorLevel()) {
            QLog.i("TtsView", 2, "[bindData] sessionId=" + sessionId + " data=" + playData);
        }
        this.sessionId = sessionId;
        this.playData = playData;
        l();
    }

    @Nullable
    public final View c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (View) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.loadingView;
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return e.INSTANCE.b().m(this.sessionId);
    }

    public final void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        QLog.i("TtsView", 1, "[updateUI] sessionId = " + this.sessionId + " isPlaying=" + f() + " isLoading = " + e() + " isWaiting = " + g());
        if (f()) {
            if (e()) {
                h();
                return;
            } else {
                i();
                return;
            }
        }
        if (g()) {
            h();
        } else {
            j();
        }
    }

    public final void setLoadingView(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
        } else {
            this.loadingView = view;
        }
    }

    public final void setPauseIconDrawable(@Nullable Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) drawable);
        } else {
            this.pauseIconDrawable = drawable;
            l();
        }
    }

    public final void setPlayingIconDrawable(@Nullable Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) drawable);
        } else {
            this.playingIconDrawable = drawable;
            l();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TtsView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            return;
        }
        iPatchRedirector.redirect((short) 12, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ TtsView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TtsView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.ICON_WIDTH = com.tencent.qqnt.util.view.b.f362999a.b(18);
            d(this);
        }
    }
}
