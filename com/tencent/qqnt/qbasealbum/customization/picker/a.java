package com.tencent.qqnt.qbasealbum.customization.picker;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bH\u0010IJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J(\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H&J \u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH&R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010(\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010\"\u001a\u0004\b/\u0010$\"\u0004\b0\u0010&R$\u00102\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u00108\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010\"\u001a\u0004\b9\u0010$\"\u0004\b:\u0010&R$\u0010<\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010B\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010\"\u001a\u0004\bC\u0010$\"\u0004\bD\u0010&R$\u0010E\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010\"\u001a\u0004\bF\u0010$\"\u0004\bG\u0010&\u00a8\u0006J"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/customization/picker/a;", "", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "getTitleView", "getBottomView", "", "spanCount", "holderGap", "Lcom/tencent/qqnt/qbasealbum/base/view/e;", "createPickerHolder", "holder", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "mediaInfo", "", "bindPickerHolder", "Landroid/widget/FrameLayout;", "titleCloseBtn", "Landroid/widget/FrameLayout;", "getTitleCloseBtn", "()Landroid/widget/FrameLayout;", "setTitleCloseBtn", "(Landroid/widget/FrameLayout;)V", "titleAlbumContainer", "Landroid/view/View;", "getTitleAlbumContainer", "()Landroid/view/View;", "setTitleAlbumContainer", "(Landroid/view/View;)V", "Landroid/widget/TextView;", "titleAlbumName", "Landroid/widget/TextView;", "getTitleAlbumName", "()Landroid/widget/TextView;", "setTitleAlbumName", "(Landroid/widget/TextView;)V", "Landroid/widget/ImageView;", "titleAlbumIcon", "Landroid/widget/ImageView;", "getTitleAlbumIcon", "()Landroid/widget/ImageView;", "setTitleAlbumIcon", "(Landroid/widget/ImageView;)V", "previewBtn", "getPreviewBtn", "setPreviewBtn", "Landroid/widget/Button;", "sendBtn", "Landroid/widget/Button;", "getSendBtn", "()Landroid/widget/Button;", "setSendBtn", "(Landroid/widget/Button;)V", "magicBtn", "getMagicBtn", "setMagicBtn", "Landroid/widget/CheckBox;", "qualityCb", "Landroid/widget/CheckBox;", "getQualityCb", "()Landroid/widget/CheckBox;", "setQualityCb", "(Landroid/widget/CheckBox;)V", "mediaSizeTv", "getMediaSizeTv", "setMediaSizeTv", "qualityTv", "getQualityTv", "setQualityTv", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    @Nullable
    private TextView magicBtn;

    @Nullable
    private TextView mediaSizeTv;

    @Nullable
    private TextView previewBtn;

    @Nullable
    private CheckBox qualityCb;

    @Nullable
    private TextView qualityTv;

    @Nullable
    private Button sendBtn;

    @Nullable
    private View titleAlbumContainer;

    @Nullable
    private ImageView titleAlbumIcon;

    @Nullable
    private TextView titleAlbumName;

    @Nullable
    private FrameLayout titleCloseBtn;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract void bindPickerHolder(@NotNull Context context, @NotNull com.tencent.qqnt.qbasealbum.base.view.e holder, @NotNull LocalMediaInfo mediaInfo);

    @NotNull
    public abstract com.tencent.qqnt.qbasealbum.base.view.e createPickerHolder(@NotNull Context context, int spanCount, int holderGap, @NotNull ViewGroup parent);

    @Nullable
    public abstract View getBottomView(@NotNull Context context, @NotNull ViewGroup parent);

    @Nullable
    public final TextView getMagicBtn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (TextView) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.magicBtn;
    }

    @Nullable
    public final TextView getMediaSizeTv() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (TextView) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.mediaSizeTv;
    }

    @Nullable
    public final TextView getPreviewBtn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (TextView) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.previewBtn;
    }

    @Nullable
    public final CheckBox getQualityCb() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (CheckBox) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.qualityCb;
    }

    @Nullable
    public final TextView getQualityTv() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (TextView) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.qualityTv;
    }

    @Nullable
    public final Button getSendBtn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Button) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.sendBtn;
    }

    @Nullable
    public final View getTitleAlbumContainer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.titleAlbumContainer;
    }

    @Nullable
    public final ImageView getTitleAlbumIcon() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ImageView) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.titleAlbumIcon;
    }

    @Nullable
    public final TextView getTitleAlbumName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (TextView) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.titleAlbumName;
    }

    @Nullable
    public final FrameLayout getTitleCloseBtn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.titleCloseBtn;
    }

    @Nullable
    public abstract View getTitleView(@NotNull Context context, @NotNull ViewGroup parent);

    public final void setMagicBtn(@Nullable TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) textView);
        } else {
            this.magicBtn = textView;
        }
    }

    public final void setMediaSizeTv(@Nullable TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) textView);
        } else {
            this.mediaSizeTv = textView;
        }
    }

    public final void setPreviewBtn(@Nullable TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) textView);
        } else {
            this.previewBtn = textView;
        }
    }

    public final void setQualityCb(@Nullable CheckBox checkBox) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) checkBox);
        } else {
            this.qualityCb = checkBox;
        }
    }

    public final void setQualityTv(@Nullable TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) textView);
        } else {
            this.qualityTv = textView;
        }
    }

    public final void setSendBtn(@Nullable Button button) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) button);
        } else {
            this.sendBtn = button;
        }
    }

    public final void setTitleAlbumContainer(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            this.titleAlbumContainer = view;
        }
    }

    public final void setTitleAlbumIcon(@Nullable ImageView imageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) imageView);
        } else {
            this.titleAlbumIcon = imageView;
        }
    }

    public final void setTitleAlbumName(@Nullable TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) textView);
        } else {
            this.titleAlbumName = textView;
        }
    }

    public final void setTitleCloseBtn(@Nullable FrameLayout frameLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) frameLayout);
        } else {
            this.titleCloseBtn = frameLayout;
        }
    }
}
