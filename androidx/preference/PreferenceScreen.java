package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.PreferenceManager;

/* loaded from: classes.dex */
public final class PreferenceScreen extends PreferenceGroup {
    private boolean mShouldUseGeneratedIds;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, TypedArrayUtils.getAttr(context, com.tencent.mobileqq.R.attr.b2a, android.R.attr.preferenceScreenStyle));
        this.mShouldUseGeneratedIds = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.PreferenceGroup
    public boolean isOnSameScreenAsChildren() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.Preference
    public void onClick() {
        PreferenceManager.OnNavigateToScreenListener onNavigateToScreenListener;
        if (getIntent() == null && getFragment() == null && getPreferenceCount() != 0 && (onNavigateToScreenListener = getPreferenceManager().getOnNavigateToScreenListener()) != null) {
            onNavigateToScreenListener.onNavigateToScreen(this);
        }
    }

    public void setShouldUseGeneratedIds(boolean z16) {
        if (!isAttached()) {
            this.mShouldUseGeneratedIds = z16;
            return;
        }
        throw new IllegalStateException("Cannot change the usage of generated IDs while attached to the preference hierarchy");
    }

    public boolean shouldUseGeneratedIds() {
        return this.mShouldUseGeneratedIds;
    }
}
