package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.TypedArrayUtils;

/* loaded from: classes.dex */
public abstract class DialogPreference extends Preference {
    private Drawable mDialogIcon;
    private int mDialogLayoutResId;
    private CharSequence mDialogMessage;
    private CharSequence mDialogTitle;
    private CharSequence mNegativeButtonText;
    private CharSequence mPositiveButtonText;

    /* loaded from: classes.dex */
    public interface TargetFragment {
        Preference findPreference(CharSequence charSequence);
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DialogPreference, i3, i16);
        String string = TypedArrayUtils.getString(obtainStyledAttributes, R.styleable.DialogPreference_dialogTitle, R.styleable.DialogPreference_android_dialogTitle);
        this.mDialogTitle = string;
        if (string == null) {
            this.mDialogTitle = getTitle();
        }
        this.mDialogMessage = TypedArrayUtils.getString(obtainStyledAttributes, R.styleable.DialogPreference_dialogMessage, R.styleable.DialogPreference_android_dialogMessage);
        this.mDialogIcon = TypedArrayUtils.getDrawable(obtainStyledAttributes, R.styleable.DialogPreference_dialogIcon, R.styleable.DialogPreference_android_dialogIcon);
        this.mPositiveButtonText = TypedArrayUtils.getString(obtainStyledAttributes, R.styleable.DialogPreference_positiveButtonText, R.styleable.DialogPreference_android_positiveButtonText);
        this.mNegativeButtonText = TypedArrayUtils.getString(obtainStyledAttributes, R.styleable.DialogPreference_negativeButtonText, R.styleable.DialogPreference_android_negativeButtonText);
        this.mDialogLayoutResId = TypedArrayUtils.getResourceId(obtainStyledAttributes, R.styleable.DialogPreference_dialogLayout, R.styleable.DialogPreference_android_dialogLayout, 0);
        obtainStyledAttributes.recycle();
    }

    public Drawable getDialogIcon() {
        return this.mDialogIcon;
    }

    public int getDialogLayoutResource() {
        return this.mDialogLayoutResId;
    }

    public CharSequence getDialogMessage() {
        return this.mDialogMessage;
    }

    public CharSequence getDialogTitle() {
        return this.mDialogTitle;
    }

    public CharSequence getNegativeButtonText() {
        return this.mNegativeButtonText;
    }

    public CharSequence getPositiveButtonText() {
        return this.mPositiveButtonText;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.Preference
    public void onClick() {
        getPreferenceManager().showDialog(this);
    }

    public void setDialogIcon(Drawable drawable) {
        this.mDialogIcon = drawable;
    }

    public void setDialogLayoutResource(int i3) {
        this.mDialogLayoutResId = i3;
    }

    public void setDialogMessage(CharSequence charSequence) {
        this.mDialogMessage = charSequence;
    }

    public void setDialogTitle(CharSequence charSequence) {
        this.mDialogTitle = charSequence;
    }

    public void setNegativeButtonText(CharSequence charSequence) {
        this.mNegativeButtonText = charSequence;
    }

    public void setPositiveButtonText(CharSequence charSequence) {
        this.mPositiveButtonText = charSequence;
    }

    public void setDialogIcon(int i3) {
        this.mDialogIcon = ContextCompat.getDrawable(getContext(), i3);
    }

    public void setDialogMessage(int i3) {
        setDialogMessage(getContext().getString(i3));
    }

    public void setDialogTitle(int i3) {
        setDialogTitle(getContext().getString(i3));
    }

    public void setNegativeButtonText(int i3) {
        setNegativeButtonText(getContext().getString(i3));
    }

    public void setPositiveButtonText(int i3) {
        setPositiveButtonText(getContext().getString(i3));
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.getAttr(context, com.tencent.mobileqq.R.attr.aay, android.R.attr.dialogPreferenceStyle));
    }

    public DialogPreference(Context context) {
        this(context, null);
    }
}
