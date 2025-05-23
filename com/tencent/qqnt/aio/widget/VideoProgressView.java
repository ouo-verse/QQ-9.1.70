package com.tencent.qqnt.aio.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.core.view.ViewCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.bs;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.RefreshProgressRunnable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aB\u001d\b\u0016\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b\u0019\u0010\u001dB%\b\u0016\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b\u0019\u0010 J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u000f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006!"}, d2 = {"Lcom/tencent/qqnt/aio/widget/VideoProgressView;", "Lcom/tencent/mobileqq/widget/MessageProgressView;", "", "key", "", "percent", "", "setVideoCompressPercent", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "t", ReportConstant.COSTREPORT_PREFIX, "L0", UserInfo.SEX_FEMALE, "mVideoCompressPercent", "", "M0", "Z", "isVideoCompressStatus", "()Z", "setVideoCompressStatus", "(Z)V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class VideoProgressView extends MessageProgressView {
    static IPatchRedirector $redirector_;

    /* renamed from: L0, reason: from kotlin metadata */
    private float mVideoCompressPercent;

    /* renamed from: M0, reason: from kotlin metadata */
    private boolean isVideoCompressStatus;

    public VideoProgressView(@Nullable Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.isVideoCompressStatus = true;
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        }
    }

    private final void setVideoCompressPercent(String key, float percent) {
        boolean z16;
        double d16 = percent;
        boolean z17 = false;
        if (0.0d <= d16 && d16 <= 1.0d) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.mVideoCompressPercent = percent;
            if (percent < 1.0f) {
                z17 = true;
            }
            this.isVideoCompressStatus = z17;
        }
        if (this.f315822e == 1) {
            RefreshProgressRunnable b16 = bs.c().b(key);
            if (b16 == null) {
                RefreshProgressRunnable refreshProgressRunnable = new RefreshProgressRunnable(this, key, this.f315824f);
                bs.c().a(key, refreshProgressRunnable);
                ViewCompat.postOnAnimation(this, refreshProgressRunnable);
                return;
            }
            b16.a(this, this.f315824f);
        }
    }

    @Override // com.tencent.mobileqq.widget.MessageProgressView, android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int i3 = this.f315822e;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    r();
                    j(canvas, this.D0);
                    return;
                }
                return;
            }
            r();
            k(canvas);
            return;
        }
        r();
        d(canvas);
        if (this.isVideoCompressStatus) {
            f(canvas, this.mVideoCompressPercent);
        } else {
            e(canvas);
        }
        String str = this.f315827h;
        if (str != null) {
            i(canvas, str);
        } else {
            h(canvas);
        }
        c(canvas);
        m(canvas);
    }

    public final void s(@NotNull String key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) key);
        } else {
            Intrinsics.checkNotNullParameter(key, "key");
            setVideoCompressPercent(key, 0.0f);
        }
    }

    public final void setVideoCompressStatus(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            this.isVideoCompressStatus = z16;
        }
    }

    public final void t(@NotNull String key, float percent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, key, Float.valueOf(percent));
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        double d16 = percent;
        if (0.0d > d16 || d16 > 1.0d) {
            z16 = false;
        }
        if (z16 && percent > this.mVideoCompressPercent) {
            setVideoCompressPercent(key, percent);
        }
    }

    public VideoProgressView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.isVideoCompressStatus = true;
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public VideoProgressView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            this.isVideoCompressStatus = true;
        } else {
            iPatchRedirector.redirect((short) 5, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
