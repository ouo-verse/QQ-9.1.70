package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010%\u001a\u00020$\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0011\u0010#\u001a\u00020\u00138F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/view/HWPlayerSeekBar;", "Landroid/widget/RelativeLayout;", "", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "", "b", "max", "", "setMax", "progress", HippyQQPagView.FunctionName.SET_PROGRESS, "", "isPlaying", "c", "d", "I", "paddingHor", "e", "paddingVer", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "playIconView", "Landroid/widget/TextView;", h.F, "Landroid/widget/TextView;", "progressText", "i", "maxText", "Landroid/widget/SeekBar;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/SeekBar;", "seekBar", "a", "()Landroid/widget/ImageView;", "playStatusIcon", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWPlayerSeekBar extends RelativeLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int paddingHor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int paddingVer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageView playIconView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView progressText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView maxText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private SeekBar seekBar;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HWPlayerSeekBar(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
    }

    private final String b(int timeStamp) {
        String valueOf;
        String format;
        int i3 = timeStamp / 1000;
        int i16 = i3 / 60;
        int i17 = i3 % 60;
        if (i16 < 10) {
            valueOf = "0" + i16;
        } else {
            valueOf = String.valueOf(i16);
        }
        if (i17 < 10) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            format = String.format("%s:0%s", Arrays.copyOf(new Object[]{valueOf, Integer.valueOf(i17)}, 2));
        } else {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            format = String.format("%s:%s", Arrays.copyOf(new Object[]{valueOf, Integer.valueOf(i17)}, 2));
        }
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    @NotNull
    public final ImageView a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ImageView) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.playIconView;
    }

    public final void c(boolean isPlaying) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, isPlaying);
            return;
        }
        ImageView imageView = this.playIconView;
        if (isPlaying) {
            i3 = R.drawable.qui_pause_filled;
        } else {
            i3 = R.drawable.qui_play_filled;
        }
        imageView.setImageResource(i3);
    }

    public final void setMax(int max) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, max);
            return;
        }
        if (this.seekBar.getMax() != max) {
            this.seekBar.setMax(max);
        }
        String b16 = b(max);
        if (!Intrinsics.areEqual(b16, this.maxText.getText().toString())) {
            this.maxText.setText(b16);
        }
    }

    public final void setProgress(int progress) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, progress);
            return;
        }
        this.seekBar.setProgress(progress);
        String b16 = b(progress);
        if (!Intrinsics.areEqual(b16, this.progressText.getText().toString())) {
            this.progressText.setText(b16);
        }
    }

    public /* synthetic */ HWPlayerSeekBar(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HWPlayerSeekBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        int dip2px = ViewUtils.dip2px(16.0f);
        this.paddingHor = dip2px;
        int dip2px2 = ViewUtils.dip2px(11.0f);
        this.paddingVer = dip2px2;
        View.inflate(context, R.layout.fzg, this);
        setPadding(dip2px, dip2px2, dip2px, dip2px2);
        setBackgroundResource(R.drawable.f161556kd0);
        View findViewById = findViewById(R.id.f66353ae);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qui_play_status_icon_view)");
        this.playIconView = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.f66343ad);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qui_play_progress_tex)");
        this.progressText = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.f66323ab);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qui_play_duration_tex)");
        this.maxText = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.f66433am);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.qui_seek_bar)");
        SeekBar seekBar = (SeekBar) findViewById4;
        this.seekBar = seekBar;
        seekBar.setEnabled(false);
    }
}
