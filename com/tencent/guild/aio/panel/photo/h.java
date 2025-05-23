package com.tencent.guild.aio.panel.photo;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00107\u001a\u000206\u00a2\u0006\u0004\b8\u00109R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001d\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R$\u0010%\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010-\u001a\u00020&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00105\u001a\u00020.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104\u00a8\u0006:"}, d2 = {"Lcom/tencent/guild/aio/panel/photo/h;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/guild/api/media/album/e;", "E", "Lcom/tencent/guild/api/media/album/e;", ReportConstant.COSTREPORT_PREFIX, "()Lcom/tencent/guild/api/media/album/e;", "u", "(Lcom/tencent/guild/api/media/album/e;)V", "mediaInfo", "Lcom/tencent/image/URLImageView;", UserInfo.SEX_FEMALE, "Lcom/tencent/image/URLImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/image/URLImageView;", "setMImageView", "(Lcom/tencent/image/URLImageView;)V", "mImageView", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "r", "()Landroid/widget/ImageView;", "setMVideoMask", "(Landroid/widget/ImageView;)V", "mVideoMask", "H", "o", "setMMask", "mMask", "Lcom/tencent/image/URLDrawable;", "I", "Lcom/tencent/image/URLDrawable;", "p", "()Lcom/tencent/image/URLDrawable;", "t", "(Lcom/tencent/image/URLDrawable;)V", "mURLDrawable", "Landroid/widget/TextView;", "J", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroid/widget/TextView;", "setMVideoDuration", "(Landroid/widget/TextView;)V", "mVideoDuration", "Landroid/widget/CheckBox;", "K", "Landroid/widget/CheckBox;", "l", "()Landroid/widget/CheckBox;", "setMCheckBox", "(Landroid/widget/CheckBox;)V", "mCheckBox", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class h extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    public com.tencent.guild.api.media.album.e mediaInfo;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private URLImageView mImageView;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private ImageView mVideoMask;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private ImageView mMask;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private URLDrawable mURLDrawable;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private TextView mVideoDuration;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private CheckBox mCheckBox;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        View findViewById = itemView.findViewById(R.id.f165862dq3);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.item_image)");
        this.mImageView = (URLImageView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.dri);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.item_video_mask)");
        this.mVideoMask = (ImageView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.f165863dq4);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.item_image_mask)");
        this.mMask = (ImageView) findViewById3;
        View findViewById4 = itemView.findViewById(R.id.drh);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.item_video_duration)");
        this.mVideoDuration = (TextView) findViewById4;
        View findViewById5 = itemView.findViewById(R.id.dpo);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.item_checkbox)");
        this.mCheckBox = (CheckBox) findViewById5;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final CheckBox getMCheckBox() {
        return this.mCheckBox;
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final URLImageView getMImageView() {
        return this.mImageView;
    }

    @NotNull
    /* renamed from: o, reason: from getter */
    public final ImageView getMMask() {
        return this.mMask;
    }

    @Nullable
    /* renamed from: p, reason: from getter */
    public final URLDrawable getMURLDrawable() {
        return this.mURLDrawable;
    }

    @NotNull
    /* renamed from: q, reason: from getter */
    public final TextView getMVideoDuration() {
        return this.mVideoDuration;
    }

    @NotNull
    /* renamed from: r, reason: from getter */
    public final ImageView getMVideoMask() {
        return this.mVideoMask;
    }

    @NotNull
    public final com.tencent.guild.api.media.album.e s() {
        com.tencent.guild.api.media.album.e eVar = this.mediaInfo;
        if (eVar != null) {
            return eVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mediaInfo");
        return null;
    }

    public final void t(@Nullable URLDrawable uRLDrawable) {
        this.mURLDrawable = uRLDrawable;
    }

    public final void u(@NotNull com.tencent.guild.api.media.album.e eVar) {
        Intrinsics.checkNotNullParameter(eVar, "<set-?>");
        this.mediaInfo = eVar;
    }
}
