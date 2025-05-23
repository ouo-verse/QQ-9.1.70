package com.tencent.mobileqq.weather.adapter;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsJVMKt;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/weather/adapter/l;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "url", "", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "weather", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/weather/data/j;", "data", "l", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "mTemperature", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "mWeatherImg", "G", "mTime", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class l extends RecyclerView.ViewHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private TextView mTemperature;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private ImageView mWeatherImg;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private TextView mTime;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
        }
    }

    private final void m() {
        TextView textView;
        if (com.tencent.mobileqq.weather.util.b.g() && (textView = this.mTemperature) != null) {
            textView.setTextColor(-1);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0083, code lost:
    
        if (r7 != null) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void n(String weather) {
        List listOfNotNull;
        CharSequence charSequence;
        String str;
        Integer intOrNull;
        Float floatOrNull;
        CharSequence text;
        String obj;
        if (!AppSetting.f99565y) {
            return;
        }
        boolean z16 = false;
        listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) new View[]{this.mTemperature, this.mTime, this.mWeatherImg});
        Iterator it = listOfNotNull.iterator();
        while (it.hasNext()) {
            ViewCompat.setImportantForAccessibility((View) it.next(), 2);
        }
        StringBuilder sb5 = new StringBuilder();
        TextView textView = this.mTime;
        if (textView != null) {
            charSequence = textView.getText();
        } else {
            charSequence = null;
        }
        String str2 = "";
        if (charSequence == null) {
            charSequence = "";
        }
        TextView textView2 = this.mTemperature;
        if (textView2 != null && (text = textView2.getText()) != null && (obj = text.toString()) != null) {
            str2 = obj;
        }
        sb5.append(((Object) charSequence) + "\uff0c" + weather);
        if (str2.length() > 0) {
            z16 = true;
        }
        if (z16) {
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str2);
            if (intOrNull == null) {
                floatOrNull = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(str2);
            }
            str = "\uff0c\u6e29\u5ea6\uff1a" + str2 + " \u6444\u6c0f\u5ea6";
            sb5.append(str);
            this.itemView.setContentDescription(sb5.toString());
        }
        str = "\uff0c" + str2;
        sb5.append(str);
        this.itemView.setContentDescription(sb5.toString());
    }

    private final void o(String url) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = ViewUtils.dip2px(40.0f);
        obtain.mRequestHeight = ViewUtils.dip2px(40.0f);
        obtain.mFailedDrawable = new ColorDrawable(0);
        obtain.mLoadingDrawable = new ColorDrawable(0);
        URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
        Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(url, options)");
        ImageView imageView = this.mWeatherImg;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public final void l(@NotNull com.tencent.mobileqq.weather.data.j data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        View view = this.itemView;
        this.mTemperature = (TextView) view.findViewById(R.id.uei);
        this.mWeatherImg = (ImageView) view.findViewById(R.id.uef);
        this.mTime = (TextView) view.findViewById(R.id.uej);
        TextView textView = this.mTemperature;
        if (textView != null) {
            textView.setText(data.c());
        }
        TextView textView2 = this.mTime;
        if (textView2 != null) {
            textView2.setText(data.d());
        }
        o(data.b());
        m();
        n(data.e());
    }
}
