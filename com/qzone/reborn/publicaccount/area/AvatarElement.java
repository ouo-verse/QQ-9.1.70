package com.qzone.reborn.publicaccount.area;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.proavatar.QQProAvatarDrawable;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bR\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/qzone/reborn/publicaccount/area/AvatarElement;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "", "isMulti", "", "a", "", "uin", "setUin", "d", "Landroid/content/Context;", "mContext", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "mAvatarView", "<init>", "(Landroid/content/Context;Z)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class AvatarElement extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Context mContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView mAvatarView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarElement(Context context, boolean z16) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        a(context, z16);
    }

    private final void a(Context context, boolean isMulti) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.cnh, this);
        View findViewById = findViewById(R.id.f19084q);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.avatar_img)");
        this.mAvatarView = (ImageView) findViewById;
        if (isMulti) {
            ((ImageView) findViewById(R.id.f19054n)).setVisibility(0);
            ImageView imageView = this.mAvatarView;
            ImageView imageView2 = null;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAvatarView");
                imageView = null;
            }
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.height = ViewUtils.dpToPx(22.0f);
            layoutParams.width = ViewUtils.dpToPx(22.0f);
            ImageView imageView3 = this.mAvatarView;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAvatarView");
            } else {
                imageView2 = imageView3;
            }
            imageView2.setLayoutParams(layoutParams);
        }
    }

    public final void setUin(String uin) {
        QQProAvatarDrawable qQProAvatarDrawable = new QQProAvatarDrawable();
        Context context = this.mContext;
        ImageView imageView = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        qQProAvatarDrawable.q(context, 1, uin);
        ImageView imageView2 = this.mAvatarView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatarView");
        } else {
            imageView = imageView2;
        }
        imageView.setImageDrawable(qQProAvatarDrawable);
    }
}
