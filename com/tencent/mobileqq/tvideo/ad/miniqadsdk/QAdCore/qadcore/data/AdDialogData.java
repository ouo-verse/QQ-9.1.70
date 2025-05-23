package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.data;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes19.dex */
public class AdDialogData {

    /* renamed from: a, reason: collision with root package name */
    private Drawable f303865a;

    /* renamed from: b, reason: collision with root package name */
    private String f303866b;

    /* renamed from: c, reason: collision with root package name */
    private String f303867c;

    /* renamed from: d, reason: collision with root package name */
    private String f303868d;

    /* renamed from: e, reason: collision with root package name */
    private int f303869e = -1;

    /* renamed from: f, reason: collision with root package name */
    private int f303870f = -1;

    /* renamed from: g, reason: collision with root package name */
    private DialogInterface.OnClickListener f303871g;

    /* renamed from: h, reason: collision with root package name */
    private DialogInterface.OnClickListener f303872h;

    /* renamed from: i, reason: collision with root package name */
    private DialogInterface.OnCancelListener f303873i;

    /* renamed from: j, reason: collision with root package name */
    private DialogInterface.OnShowListener f303874j;

    /* renamed from: k, reason: collision with root package name */
    private DialogInterface.OnDismissListener f303875k;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class Builder implements Serializable {
        private final AdDialogData mAdDialogData = new AdDialogData();

        public AdDialogData build() {
            return this.mAdDialogData;
        }

        public Builder setCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.mAdDialogData.f303873i = onCancelListener;
            return this;
        }

        public Builder setIconDrawable(Drawable drawable) {
            this.mAdDialogData.f303865a = drawable;
            return this;
        }

        public Builder setMessage(String str) {
            this.mAdDialogData.f303866b = str;
            return this;
        }

        public Builder setNegativeColorId(int i3) {
            this.mAdDialogData.f303870f = i3;
            return this;
        }

        public Builder setNegativeListener(DialogInterface.OnClickListener onClickListener) {
            this.mAdDialogData.f303872h = onClickListener;
            return this;
        }

        public Builder setNegativeText(String str) {
            this.mAdDialogData.f303868d = str;
            return this;
        }

        public Builder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.mAdDialogData.f303875k = onDismissListener;
            return this;
        }

        public Builder setOnShowListener(DialogInterface.OnShowListener onShowListener) {
            this.mAdDialogData.f303874j = onShowListener;
            return this;
        }

        public Builder setPositiveColorId(int i3) {
            this.mAdDialogData.f303869e = i3;
            return this;
        }

        public Builder setPositiveListener(DialogInterface.OnClickListener onClickListener) {
            this.mAdDialogData.f303871g = onClickListener;
            return this;
        }

        public Builder setPositiveText(String str) {
            this.mAdDialogData.f303867c = str;
            return this;
        }
    }

    public DialogInterface.OnCancelListener l() {
        return this.f303873i;
    }

    public String m() {
        return this.f303866b;
    }

    public DialogInterface.OnClickListener n() {
        return this.f303872h;
    }

    public String o() {
        return this.f303868d;
    }

    public DialogInterface.OnDismissListener p() {
        return this.f303875k;
    }

    public DialogInterface.OnShowListener q() {
        return this.f303874j;
    }

    public DialogInterface.OnClickListener r() {
        return this.f303871g;
    }

    public String s() {
        return this.f303867c;
    }
}
