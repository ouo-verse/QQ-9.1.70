package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.CompoundButtonCompat;

/* compiled from: P */
/* loaded from: classes.dex */
class AppCompatCompoundButtonHelper {
    private ColorStateList mButtonTintList = null;
    private PorterDuff.Mode mButtonTintMode = null;
    private boolean mHasButtonTint = false;
    private boolean mHasButtonTintMode = false;
    private boolean mSkipNextApply;

    @NonNull
    private final CompoundButton mView;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatCompoundButtonHelper(@NonNull CompoundButton compoundButton) {
        this.mView = compoundButton;
    }

    void applyButtonTint() {
        Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(this.mView);
        if (buttonDrawable != null) {
            if (this.mHasButtonTint || this.mHasButtonTintMode) {
                Drawable mutate = DrawableCompat.wrap(buttonDrawable).mutate();
                if (this.mHasButtonTint) {
                    DrawableCompat.setTintList(mutate, this.mButtonTintList);
                }
                if (this.mHasButtonTintMode) {
                    DrawableCompat.setTintMode(mutate, this.mButtonTintMode);
                }
                if (mutate.isStateful()) {
                    mutate.setState(this.mView.getDrawableState());
                }
                this.mView.setButtonDrawable(mutate);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList getSupportButtonTintList() {
        return this.mButtonTintList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode getSupportButtonTintMode() {
        return this.mButtonTintMode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x003d A[Catch: all -> 0x0084, TRY_ENTER, TryCatch #1 {all -> 0x0084, blocks: (B:3:0x001d, B:5:0x0025, B:8:0x002b, B:11:0x003d, B:13:0x0045, B:15:0x004b, B:16:0x0058, B:18:0x0060, B:19:0x0069, B:21:0x0071), top: B:2:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0060 A[Catch: all -> 0x0084, TryCatch #1 {all -> 0x0084, blocks: (B:3:0x001d, B:5:0x0025, B:8:0x002b, B:11:0x003d, B:13:0x0045, B:15:0x004b, B:16:0x0058, B:18:0x0060, B:19:0x0069, B:21:0x0071), top: B:2:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0071 A[Catch: all -> 0x0084, TRY_LEAVE, TryCatch #1 {all -> 0x0084, blocks: (B:3:0x001d, B:5:0x0025, B:8:0x002b, B:11:0x003d, B:13:0x0045, B:15:0x004b, B:16:0x0058, B:18:0x0060, B:19:0x0069, B:21:0x0071), top: B:2:0x001d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void loadFromAttributes(@Nullable AttributeSet attributeSet, int i3) {
        boolean z16;
        int i16;
        int i17;
        int resourceId;
        int resourceId2;
        Context context = this.mView.getContext();
        int[] iArr = R.styleable.CompoundButton;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i3, 0);
        CompoundButton compoundButton = this.mView;
        ViewCompat.saveAttributeDataForStyleable(compoundButton, compoundButton.getContext(), iArr, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i3, 0);
        try {
            int i18 = R.styleable.CompoundButton_buttonCompat;
            if (obtainStyledAttributes.hasValue(i18) && (resourceId2 = obtainStyledAttributes.getResourceId(i18, 0)) != 0) {
                try {
                    CompoundButton compoundButton2 = this.mView;
                    compoundButton2.setButtonDrawable(AppCompatResources.getDrawable(compoundButton2.getContext(), resourceId2));
                    z16 = true;
                } catch (Resources.NotFoundException unused) {
                }
                if (!z16) {
                    int i19 = R.styleable.CompoundButton_android_button;
                    if (obtainStyledAttributes.hasValue(i19) && (resourceId = obtainStyledAttributes.getResourceId(i19, 0)) != 0) {
                        CompoundButton compoundButton3 = this.mView;
                        compoundButton3.setButtonDrawable(AppCompatResources.getDrawable(compoundButton3.getContext(), resourceId));
                    }
                }
                i16 = R.styleable.CompoundButton_buttonTint;
                if (obtainStyledAttributes.hasValue(i16)) {
                    CompoundButtonCompat.setButtonTintList(this.mView, obtainStyledAttributes.getColorStateList(i16));
                }
                i17 = R.styleable.CompoundButton_buttonTintMode;
                if (obtainStyledAttributes.hasValue(i17)) {
                    CompoundButtonCompat.setButtonTintMode(this.mView, DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(i17, -1), null));
                }
            }
            z16 = false;
            if (!z16) {
            }
            i16 = R.styleable.CompoundButton_buttonTint;
            if (obtainStyledAttributes.hasValue(i16)) {
            }
            i17 = R.styleable.CompoundButton_buttonTintMode;
            if (obtainStyledAttributes.hasValue(i17)) {
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onSetButtonDrawable() {
        if (this.mSkipNextApply) {
            this.mSkipNextApply = false;
        } else {
            this.mSkipNextApply = true;
            applyButtonTint();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        this.mButtonTintList = colorStateList;
        this.mHasButtonTint = true;
        applyButtonTint();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSupportButtonTintMode(@Nullable PorterDuff.Mode mode) {
        this.mButtonTintMode = mode;
        this.mHasButtonTintMode = true;
        applyButtonTint();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCompoundPaddingLeft(int i3) {
        return i3;
    }
}
