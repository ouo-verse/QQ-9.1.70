package com.tencent.mobileqq.weather.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000eR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u000eR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u000eR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0014\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/weather/adapter/j;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "url", "", "o", "festivalIconUrl", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/weather/data/h;", "data", "l", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "mWeekDesc", UserInfo.SEX_FEMALE, "mDateDesc", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "mWeatherImg", "H", "mWeatherDesc", "I", "mFirstTemp", "J", "mSecondTemp", "K", "mFestivalImg", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class j extends RecyclerView.ViewHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private TextView mWeekDesc;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private TextView mDateDesc;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private ImageView mWeatherImg;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private TextView mWeatherDesc;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private TextView mFirstTemp;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private TextView mSecondTemp;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private ImageView mFestivalImg;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
        }
    }

    private final void m() {
        if (com.tencent.mobileqq.weather.util.b.g()) {
            TextView textView = this.mWeekDesc;
            if (textView != null) {
                textView.setTextColor(-1);
            }
            TextView textView2 = this.mWeatherDesc;
            if (textView2 != null) {
                textView2.setTextColor(-1);
            }
            TextView textView3 = this.mFirstTemp;
            if (textView3 != null) {
                textView3.setTextColor(-1);
            }
        }
    }

    private final void n(String festivalIconUrl) {
        boolean z16;
        if (festivalIconUrl.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ImageView imageView = this.mFestivalImg;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestWidth = ViewUtils.dip2px(40.0f);
            obtain.mRequestHeight = ViewUtils.dip2px(40.0f);
            URLDrawable drawable = URLDrawable.getDrawable(festivalIconUrl, obtain);
            Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(festivalIconUrl, options)");
            ImageView imageView2 = this.mFestivalImg;
            if (imageView2 != null) {
                imageView2.setImageDrawable(drawable);
                return;
            }
            return;
        }
        ImageView imageView3 = this.mFestivalImg;
        if (imageView3 != null) {
            imageView3.setVisibility(8);
        }
    }

    private final void o(String url) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = ViewUtils.dip2px(40.0f);
        obtain.mRequestHeight = ViewUtils.dip2px(40.0f);
        URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
        Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(url, options)");
        ImageView imageView = this.mWeatherImg;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public final void l(@NotNull com.tencent.mobileqq.weather.data.h data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        View view = this.itemView;
        this.mWeekDesc = (TextView) view.findViewById(R.id.uek);
        this.mDateDesc = (TextView) view.findViewById(R.id.uec);
        this.mWeatherImg = (ImageView) view.findViewById(R.id.uef);
        this.mWeatherDesc = (TextView) view.findViewById(R.id.ued);
        this.mFirstTemp = (TextView) view.findViewById(R.id.uee);
        this.mSecondTemp = (TextView) view.findViewById(R.id.ueh);
        this.mFestivalImg = (ImageView) view.findViewById(R.id.v4u);
        TextView textView = this.mWeekDesc;
        if (textView != null) {
            textView.setText(data.b());
        }
        TextView textView2 = this.mDateDesc;
        if (textView2 != null) {
            textView2.setText(data.a());
        }
        TextView textView3 = this.mWeatherDesc;
        if (textView3 != null) {
            textView3.setText(data.g());
        }
        TextView textView4 = this.mFirstTemp;
        if (textView4 != null) {
            textView4.setText(data.d());
        }
        TextView textView5 = this.mSecondTemp;
        if (textView5 != null) {
            textView5.setText(data.f());
        }
        o(data.e());
        n(data.c());
        m();
    }
}
