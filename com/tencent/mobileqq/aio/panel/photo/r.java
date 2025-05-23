package com.tencent.mobileqq.aio.panel.photo;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010/\u001a\u00020.\u00a2\u0006\u0004\b0\u00101R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010)\u001a\u00020\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010-\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010\u0014\u001a\u0004\b+\u0010\u0016\"\u0004\b,\u0010\u0018\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/aio/panel/photo/r;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "E", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "r", "()Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", ReportConstant.COSTREPORT_PREFIX, "(Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;)V", "mediaInfo", "Lcom/tencent/image/URLImageView;", UserInfo.SEX_FEMALE, "Lcom/tencent/image/URLImageView;", "o", "()Lcom/tencent/image/URLImageView;", "setMImageView", "(Lcom/tencent/image/URLImageView;)V", "mImageView", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "p", "()Landroid/widget/ImageView;", "setMMask", "(Landroid/widget/ImageView;)V", "mMask", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroid/widget/TextView;", "setMVideoDuration", "(Landroid/widget/TextView;)V", "mVideoDuration", "Landroid/widget/CheckBox;", "I", "Landroid/widget/CheckBox;", "l", "()Landroid/widget/CheckBox;", "setMCheckBox", "(Landroid/widget/CheckBox;)V", "mCheckBox", "J", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setMEditFlag", "mEditFlag", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class r extends RecyclerView.ViewHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    public LocalMediaInfo mediaInfo;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private URLImageView mImageView;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private ImageView mMask;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private TextView mVideoDuration;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private CheckBox mCheckBox;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private ImageView mEditFlag;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
            return;
        }
        View findViewById = itemView.findViewById(R.id.f165862dq3);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.item_image)");
        this.mImageView = (URLImageView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.f165863dq4);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.item_image_mask)");
        this.mMask = (ImageView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.drh);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.item_video_duration)");
        this.mVideoDuration = (TextView) findViewById3;
        View findViewById4 = itemView.findViewById(R.id.dpo);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.item_checkbox)");
        this.mCheckBox = (CheckBox) findViewById4;
        View findViewById5 = itemView.findViewById(R.id.xtb);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.item_edit_flag)");
        this.mEditFlag = (ImageView) findViewById5;
    }

    @NotNull
    public final CheckBox l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (CheckBox) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.mCheckBox;
    }

    @NotNull
    public final ImageView m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (ImageView) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.mEditFlag;
    }

    @NotNull
    public final URLImageView o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (URLImageView) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mImageView;
    }

    @NotNull
    public final ImageView p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ImageView) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mMask;
    }

    @NotNull
    public final TextView q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (TextView) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mVideoDuration;
    }

    @NotNull
    public final LocalMediaInfo r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LocalMediaInfo) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        LocalMediaInfo localMediaInfo = this.mediaInfo;
        if (localMediaInfo != null) {
            return localMediaInfo;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mediaInfo");
        return null;
    }

    public final void s(@NotNull LocalMediaInfo localMediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) localMediaInfo);
        } else {
            Intrinsics.checkNotNullParameter(localMediaInfo, "<set-?>");
            this.mediaInfo = localMediaInfo;
        }
    }
}
