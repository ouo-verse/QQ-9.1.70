package com.tencent.qqnt.qbasealbum.customization.preview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bH\u0010IJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\n\u001a\u00020\tH&R$\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0013\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017R$\u0010\"\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u001a\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR$\u0010%\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u0013\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u0017R$\u0010(\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\u0013\u001a\u0004\b)\u0010\u0015\"\u0004\b*\u0010\u0017R$\u0010,\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00103\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u00109\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010\u0013\u001a\u0004\b:\u0010\u0015\"\u0004\b;\u0010\u0017R$\u0010<\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010\f\u001a\u0004\b=\u0010\u000e\"\u0004\b>\u0010\u0010R$\u0010?\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010\f\u001a\u0004\b@\u0010\u000e\"\u0004\bA\u0010\u0010R$\u0010B\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010\u0013\u001a\u0004\bC\u0010\u0015\"\u0004\bD\u0010\u0017R$\u0010E\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010\u001a\u001a\u0004\bF\u0010\u001c\"\u0004\bG\u0010\u001e\u00a8\u0006J"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/customization/preview/a;", "", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "getTitleView", "getBottomView", "", "needGestureUp", "bottomRootView", "Landroid/view/View;", "getBottomRootView", "()Landroid/view/View;", "setBottomRootView", "(Landroid/view/View;)V", "Landroid/widget/TextView;", "magicStickBtn", "Landroid/widget/TextView;", "getMagicStickBtn", "()Landroid/widget/TextView;", "setMagicStickBtn", "(Landroid/widget/TextView;)V", "Landroid/widget/CheckBox;", "flashPicCb", "Landroid/widget/CheckBox;", "getFlashPicCb", "()Landroid/widget/CheckBox;", "setFlashPicCb", "(Landroid/widget/CheckBox;)V", "flashPicTv", "getFlashPicTv", "setFlashPicTv", "qualityCb", "getQualityCb", "setQualityCb", "qualityTv", "getQualityTv", "setQualityTv", "qualitySize", "getQualitySize", "setQualitySize", "Landroid/widget/Button;", "sendBtn", "Landroid/widget/Button;", "getSendBtn", "()Landroid/widget/Button;", "setSendBtn", "(Landroid/widget/Button;)V", "Landroidx/recyclerview/widget/RecyclerView;", "selectListView", "Landroidx/recyclerview/widget/RecyclerView;", "getSelectListView", "()Landroidx/recyclerview/widget/RecyclerView;", "setSelectListView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "commentTv", "getCommentTv", "setCommentTv", "topRootView", "getTopRootView", "setTopRootView", "backBtn", "getBackBtn", "setBackBtn", "titleTv", "getTitleTv", "setTitleTv", "selectedBox", "getSelectedBox", "setSelectedBox", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    @Nullable
    private View backBtn;

    @Nullable
    private View bottomRootView;

    @Nullable
    private TextView commentTv;

    @Nullable
    private CheckBox flashPicCb;

    @Nullable
    private TextView flashPicTv;

    @Nullable
    private TextView magicStickBtn;

    @Nullable
    private CheckBox qualityCb;

    @Nullable
    private TextView qualitySize;

    @Nullable
    private TextView qualityTv;

    @Nullable
    private RecyclerView selectListView;

    @Nullable
    private CheckBox selectedBox;

    @Nullable
    private Button sendBtn;

    @Nullable
    private TextView titleTv;

    @Nullable
    private View topRootView;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final View getBackBtn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (View) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.backBtn;
    }

    @Nullable
    public final View getBottomRootView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.bottomRootView;
    }

    @Nullable
    public abstract View getBottomView(@NotNull Context context, @NotNull ViewGroup parent);

    @Nullable
    public final TextView getCommentTv() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (TextView) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.commentTv;
    }

    @Nullable
    public final CheckBox getFlashPicCb() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (CheckBox) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.flashPicCb;
    }

    @Nullable
    public final TextView getFlashPicTv() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (TextView) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.flashPicTv;
    }

    @Nullable
    public final TextView getMagicStickBtn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TextView) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.magicStickBtn;
    }

    @Nullable
    public final CheckBox getQualityCb() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (CheckBox) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.qualityCb;
    }

    @Nullable
    public final TextView getQualitySize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (TextView) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.qualitySize;
    }

    @Nullable
    public final TextView getQualityTv() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (TextView) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.qualityTv;
    }

    @Nullable
    public final RecyclerView getSelectListView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (RecyclerView) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.selectListView;
    }

    @Nullable
    public final CheckBox getSelectedBox() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (CheckBox) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return this.selectedBox;
    }

    @Nullable
    public final Button getSendBtn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Button) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.sendBtn;
    }

    @Nullable
    public final TextView getTitleTv() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (TextView) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return this.titleTv;
    }

    @Nullable
    public abstract View getTitleView(@NotNull Context context, @NotNull ViewGroup parent);

    @Nullable
    public final View getTopRootView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (View) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.topRootView;
    }

    public abstract boolean needGestureUp();

    public final void setBackBtn(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) view);
        } else {
            this.backBtn = view;
        }
    }

    public final void setBottomRootView(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else {
            this.bottomRootView = view;
        }
    }

    public final void setCommentTv(@Nullable TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) textView);
        } else {
            this.commentTv = textView;
        }
    }

    public final void setFlashPicCb(@Nullable CheckBox checkBox) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) checkBox);
        } else {
            this.flashPicCb = checkBox;
        }
    }

    public final void setFlashPicTv(@Nullable TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) textView);
        } else {
            this.flashPicTv = textView;
        }
    }

    public final void setMagicStickBtn(@Nullable TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) textView);
        } else {
            this.magicStickBtn = textView;
        }
    }

    public final void setQualityCb(@Nullable CheckBox checkBox) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) checkBox);
        } else {
            this.qualityCb = checkBox;
        }
    }

    public final void setQualitySize(@Nullable TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) textView);
        } else {
            this.qualitySize = textView;
        }
    }

    public final void setQualityTv(@Nullable TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) textView);
        } else {
            this.qualityTv = textView;
        }
    }

    public final void setSelectListView(@Nullable RecyclerView recyclerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) recyclerView);
        } else {
            this.selectListView = recyclerView;
        }
    }

    public final void setSelectedBox(@Nullable CheckBox checkBox) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) checkBox);
        } else {
            this.selectedBox = checkBox;
        }
    }

    public final void setSendBtn(@Nullable Button button) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) button);
        } else {
            this.sendBtn = button;
        }
    }

    public final void setTitleTv(@Nullable TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) textView);
        } else {
            this.titleTv = textView;
        }
    }

    public final void setTopRootView(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) view);
        } else {
            this.topRootView = view;
        }
    }
}
