package com.tencent.qqnt.qbasealbum.share;

import android.graphics.Rect;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.qqnt.qbasealbum.model.PreviewInitBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b0\u00101J\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\u000b\u001a\u00020\u0005J\u001c\u0010\r\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\f0\u0004J\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\fJ\u0006\u0010\u0010\u001a\u00020\fJ\u0010\u0010\u0013\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0005J\u0006\u0010\u0016\u001a\u00020\u0005R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0019R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001dR\u0016\u0010\u0014\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010&\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R.\u0010/\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010'8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.\u00a8\u00062"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/share/a;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroidx/lifecycle/Observer;", "", "observer", "", "Q1", "isRaw", "W1", "O1", "", "P1", "comment", "R1", "L1", "Landroid/graphics/Rect;", CanvasView.ACTION_RECT, "S1", "flashPicChecked", "T1", "M1", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "_comment", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", BdhLogUtil.LogTag.Tag_Conn, "_isQualityRaw", "D", "isQualityRaw", "E", "Z", UserInfo.SEX_FEMALE, "Landroid/graphics/Rect;", "entranceRect", "Lcom/tencent/qqnt/qbasealbum/model/PreviewInitBean;", "value", "G", "Lcom/tencent/qqnt/qbasealbum/model/PreviewInitBean;", "N1", "()Lcom/tencent/qqnt/qbasealbum/model/PreviewInitBean;", "U1", "(Lcom/tencent/qqnt/qbasealbum/model/PreviewInitBean;)V", "previewBean", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a extends ViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _isQualityRaw;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> isQualityRaw;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean flashPicChecked;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Rect entranceRect;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private PreviewInitBean previewBean;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> _comment;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<String> comment;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        this._comment = mutableLiveData;
        this.comment = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        this._isQualityRaw = mutableLiveData2;
        this.isQualityRaw = mutableLiveData2;
    }

    @NotNull
    public final String L1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        String value = this.comment.getValue();
        if (value == null) {
            return "";
        }
        return value;
    }

    public final boolean M1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.flashPicChecked;
    }

    @Nullable
    public final PreviewInitBean N1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (PreviewInitBean) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.previewBean;
    }

    public final boolean O1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        Boolean value = this.isQualityRaw.getValue();
        if (value == null) {
            return false;
        }
        return value.booleanValue();
    }

    public final void P1(@NotNull LifecycleOwner lifecycleOwner, @NotNull Observer<String> observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) lifecycleOwner, (Object) observer);
            return;
        }
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.comment.observe(lifecycleOwner, observer);
    }

    public final void Q1(@NotNull LifecycleOwner lifecycleOwner, @NotNull Observer<Boolean> observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) lifecycleOwner, (Object) observer);
            return;
        }
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.isQualityRaw.observe(lifecycleOwner, observer);
    }

    public final void R1(@NotNull String comment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) comment);
        } else {
            Intrinsics.checkNotNullParameter(comment, "comment");
            this._comment.postValue(comment);
        }
    }

    public final void S1(@Nullable Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) rect);
        } else {
            this.entranceRect = rect;
        }
    }

    public final void T1(boolean flashPicChecked) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, flashPicChecked);
        } else {
            this.flashPicChecked = flashPicChecked;
        }
    }

    public final void U1(@Nullable PreviewInitBean previewInitBean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) previewInitBean);
        } else {
            this.previewBean = previewInitBean;
        }
    }

    public final void W1(boolean isRaw) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, isRaw);
        } else {
            this._isQualityRaw.postValue(Boolean.valueOf(isRaw));
        }
    }
}
