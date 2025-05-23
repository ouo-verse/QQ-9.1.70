package com.tencent.mobileqq.zootopia.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.sqshow.zootopia.data.ButtonStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButtonBannerStyle;", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButton;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "setCustomStatusStyle", "", "status", "Lcom/tencent/sqshow/zootopia/data/ButtonStatus;", "setLoadingStatusStyle", "setPauseStatusStyle", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ZootopiaDownloadButtonBannerStyle extends ZootopiaDownloadButton {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f329633a;

        static {
            int[] iArr = new int[ButtonStatus.values().length];
            try {
                iArr[ButtonStatus.WAITING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ButtonStatus.LOADED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ButtonStatus.INIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ButtonStatus.UPDATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f329633a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaDownloadButtonBannerStyle(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButton
    public void setCustomStatusStyle(ButtonStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        super.setCustomStatusStyle(status);
        int i3 = a.f329633a[status.ordinal()];
        if (i3 == 1) {
            s().setVisibility(8);
            k().setTextColor(getRootView().getResources().getColor(R.color.f7985q));
            g().setBackground(ResourcesCompat.getDrawable(getRootView().getResources(), R.drawable.gz4, null));
            return;
        }
        if (i3 == 2) {
            s().setVisibility(8);
            k().setTextColor(getRootView().getResources().getColor(R.color.f84772));
            k().setTypeface(Typeface.DEFAULT_BOLD, 1);
            g().setBackground(getLoadingBackground());
            return;
        }
        if (i3 != 3 && i3 != 4) {
            s().setVisibility(8);
            g().setBackground(getLoadingBackground());
            return;
        }
        s().setVisibility(0);
        g().setBackground(ResourcesCompat.getDrawable(getRootView().getResources(), R.drawable.f159840gz3, null));
        s().setTextColor(getRootView().getResources().getColor(R.color.f84671));
        k().setTextColor(getRootView().getResources().getColor(R.color.f84671));
        s().setTypeface(Typeface.DEFAULT_BOLD, 1);
        k().setTypeface(Typeface.DEFAULT_BOLD, 1);
        s().setPadding(0, -ViewUtils.dpToPx(2.0f), 0, 0);
        k().setIncludeFontPadding(false);
        s().setIncludeFontPadding(false);
    }

    @Override // com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButton
    public void setLoadingStatusStyle() {
        super.setLoadingStatusStyle();
        g().setBackground(getLoadingBackground());
        m().setPaintColor(getRootView().getResources().getColor(R.color.f84772));
        s().setTypeface(Typeface.DEFAULT_BOLD, 1);
        m().setBackground(null);
        m().setProgressDrawable(null);
    }

    @Override // com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButton
    public void setPauseStatusStyle() {
        super.setPauseStatusStyle();
        g().setBackground(getLoadingBackground());
        m().setVisibility(8);
        s().setTextColor(getRootView().getResources().getColor(R.color.f84772));
        k().setTextColor(getRootView().getResources().getColor(R.color.f84772));
        s().setTypeface(Typeface.DEFAULT_BOLD, 1);
        s().setPadding(0, -ViewUtils.dpToPx(2.0f), 0, 0);
        k().setTypeface(Typeface.DEFAULT_BOLD, 1);
        s().setIncludeFontPadding(false);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaDownloadButtonBannerStyle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaDownloadButtonBannerStyle(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
