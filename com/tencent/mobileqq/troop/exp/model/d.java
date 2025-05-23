package com.tencent.mobileqq.troop.exp.model;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.adapter.RecommendTroopAdapter;
import com.tencent.util.URLUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/troop/exp/model/d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/content/Context;", "context", "", "headUrl", "Landroid/graphics/drawable/Drawable;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, LayoutAttrDefine.CLICK_URI, "", DomainData.DOMAIN_NAME, "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "l", "()Landroid/widget/ImageView;", "setBannerImg", "(Landroid/widget/ImageView;)V", "bannerImg", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class d extends RecyclerView.ViewHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private ImageView bannerImg;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            return;
        }
        View findViewById = view.findViewById(R.id.t66);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.bgImage)");
        this.bannerImg = (ImageView) findViewById;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Drawable m(Context context, String headUrl) {
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mFailedDrawable = colorDrawable;
        obtain.mLoadingDrawable = colorDrawable;
        ColorDrawable colorDrawable2 = colorDrawable;
        if (URLUtil.isValidUrl(headUrl)) {
            URLDrawable drawable = URLDrawable.getDrawable(headUrl, obtain);
            drawable.setDecodeHandler(RecommendTroopAdapter.f293757m);
            int status = drawable.getStatus();
            colorDrawable2 = drawable;
            if (status != 1) {
                int status2 = drawable.getStatus();
                colorDrawable2 = drawable;
                if (status2 != 0) {
                    drawable.restartDownload();
                    colorDrawable2 = drawable;
                }
            }
        }
        return colorDrawable2;
    }

    @NotNull
    public final ImageView l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ImageView) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.bannerImg;
    }

    public final void n(@NotNull Context context, @NotNull String uri) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) uri);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.bannerImg.setImageDrawable(m(context, uri));
    }
}
