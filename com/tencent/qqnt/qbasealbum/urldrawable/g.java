package com.tencent.qqnt.qbasealbum.urldrawable;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.tencent.image.ApngSoLoader;
import com.tencent.image.ProtocolDownloader;
import com.tencent.image.SharpSoLoader;
import com.tencent.image.URLDrawableParams;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0004\u001a\u00020\u0002H\u0014J\u001e\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/urldrawable/g;", "Lcom/tencent/image/URLDrawableParams;", "Landroid/graphics/drawable/Drawable;", "getDefaultLoadingDrawable", "getDefualtFailedDrawable", "", AudienceReportConst.PROTOCOL, "", "httpDownloadParams", "Lcom/tencent/image/ProtocolDownloader;", "doGetDownloader", "Lcom/tencent/image/ApngSoLoader;", "getApngSoLoader", "Lcom/tencent/image/SharpSoLoader;", "getSharpSoLoader", "doGetLocalFilePath", "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class g extends URLDrawableParams {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Context context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        this.mFadeInImage = false;
        this.mUseGifAnimation = false;
    }

    @Override // com.tencent.image.URLDrawableParams
    @Nullable
    protected ProtocolDownloader doGetDownloader(@Nullable String protocol2, @Nullable Object httpDownloadParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ProtocolDownloader) iPatchRedirector.redirect((short) 4, (Object) this, (Object) protocol2, httpDownloadParams);
        }
        if (!Intrinsics.areEqual("qbasealbumthumb", protocol2) && !Intrinsics.areEqual("qbasevideocover", protocol2)) {
            return null;
        }
        return new a();
    }

    @Override // com.tencent.image.URLDrawableParams
    @Nullable
    protected String doGetLocalFilePath(@Nullable String protocol2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) protocol2);
        }
        return protocol2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.image.URLDrawableParams
    @Nullable
    public ApngSoLoader getApngSoLoader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ApngSoLoader) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.image.URLDrawableParams
    @NotNull
    public Drawable getDefaultLoadingDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Drawable) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Drawable drawable = ContextCompat.getDrawable(this.context, R.drawable.f161260n62);
        Intrinsics.checkNotNull(drawable);
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.image.URLDrawableParams
    @NotNull
    public Drawable getDefualtFailedDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Drawable) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Drawable drawable = ContextCompat.getDrawable(this.context, R.drawable.f161259n61);
        Intrinsics.checkNotNull(drawable);
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.image.URLDrawableParams
    @Nullable
    public SharpSoLoader getSharpSoLoader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (SharpSoLoader) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return null;
    }
}
