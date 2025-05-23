package com.tencent.mobileqq.qqnt.videoplay.api.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqnt.videoplay.api.component.BaseVideoView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u000e\u0010\u000fB'\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u000e\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qqnt/videoplay/api/view/PreviewVideoView;", "Landroid/widget/RelativeLayout;", "Landroid/graphics/drawable/Drawable;", "drawable", "", "setCoverImage", "Lcom/tencent/mobileqq/qqnt/videoplay/api/component/BaseVideoView;", "d", "Lcom/tencent/mobileqq/qqnt/videoplay/api/component/BaseVideoView;", "videoView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "videoplay_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class PreviewVideoView extends RelativeLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BaseVideoView videoView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewVideoView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
    }

    public final void setCoverImage(@NotNull Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) drawable);
            return;
        }
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        BaseVideoView baseVideoView = this.videoView;
        if (baseVideoView != null) {
            baseVideoView.setCoverImage(drawable);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewVideoView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
