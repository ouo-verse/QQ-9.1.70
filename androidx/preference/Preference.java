package androidx.preference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.preference.PreferenceManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.apache.httpcore.message.TokenParser;

/* loaded from: classes.dex */
public class Preference implements Comparable<Preference> {
    public static final int DEFAULT_ORDER = Integer.MAX_VALUE;
    private boolean mAllowDividerAbove;
    private boolean mAllowDividerBelow;
    private boolean mBaseMethodCalled;
    private final View.OnClickListener mClickListener;
    private Context mContext;
    private Object mDefaultValue;
    private String mDependencyKey;
    private boolean mDependencyMet;
    private List<Preference> mDependents;
    private boolean mEnabled;
    private Bundle mExtras;
    private String mFragment;
    private boolean mHasId;
    private boolean mHasSingleLineTitleAttr;
    private Drawable mIcon;
    private int mIconResId;
    private boolean mIconSpaceReserved;
    private long mId;
    private Intent mIntent;
    private String mKey;
    private int mLayoutResId;
    private OnPreferenceChangeInternalListener mListener;
    private OnPreferenceChangeListener mOnChangeListener;
    private OnPreferenceClickListener mOnClickListener;
    private int mOrder;
    private boolean mParentDependencyMet;
    private PreferenceGroup mParentGroup;
    private boolean mPersistent;

    @Nullable
    private PreferenceDataStore mPreferenceDataStore;

    @Nullable
    private PreferenceManager mPreferenceManager;
    private boolean mRequiresKey;
    private boolean mSelectable;
    private boolean mShouldDisableView;
    private boolean mSingleLineTitle;
    private CharSequence mSummary;
    private CharSequence mTitle;
    private int mViewId;
    private boolean mVisible;
    private boolean mWasDetached;
    private int mWidgetLayoutResId;

    /* loaded from: classes.dex */
    public static class BaseSavedState extends AbsSavedState {
        public static final Parcelable.Creator<BaseSavedState> CREATOR = new Parcelable.Creator<BaseSavedState>() { // from class: androidx.preference.Preference.BaseSavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public BaseSavedState createFromParcel(Parcel parcel) {
                return new BaseSavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public BaseSavedState[] newArray(int i3) {
                return new BaseSavedState[i3];
            }
        };

        public BaseSavedState(Parcel parcel) {
            super(parcel);
        }

        public BaseSavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface OnPreferenceChangeInternalListener {
        void onPreferenceChange(Preference preference);

        void onPreferenceHierarchyChange(Preference preference);

        void onPreferenceVisibilityChange(Preference preference);
    }

    /* loaded from: classes.dex */
    public interface OnPreferenceChangeListener {
        boolean onPreferenceChange(Preference preference, Object obj);
    }

    /* loaded from: classes.dex */
    public interface OnPreferenceClickListener {
        boolean onPreferenceClick(Preference preference);
    }

    public Preference(Context context, AttributeSet attributeSet, int i3, int i16) {
        this.mOrder = Integer.MAX_VALUE;
        this.mViewId = 0;
        this.mEnabled = true;
        this.mSelectable = true;
        this.mPersistent = true;
        this.mDependencyMet = true;
        this.mParentDependencyMet = true;
        this.mVisible = true;
        this.mAllowDividerAbove = true;
        this.mAllowDividerBelow = true;
        this.mSingleLineTitle = true;
        this.mShouldDisableView = true;
        this.mLayoutResId = com.tencent.mobileqq.R.layout.frh;
        this.mClickListener = new View.OnClickListener() { // from class: androidx.preference.Preference.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                Preference.this.performClick(view);
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        this.mContext = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Preference, i3, i16);
        this.mIconResId = TypedArrayUtils.getResourceId(obtainStyledAttributes, R.styleable.Preference_icon, R.styleable.Preference_android_icon, 0);
        this.mKey = TypedArrayUtils.getString(obtainStyledAttributes, R.styleable.Preference_key, R.styleable.Preference_android_key);
        this.mTitle = TypedArrayUtils.getText(obtainStyledAttributes, R.styleable.Preference_title, R.styleable.Preference_android_title);
        this.mSummary = TypedArrayUtils.getText(obtainStyledAttributes, R.styleable.Preference_summary, R.styleable.Preference_android_summary);
        this.mOrder = TypedArrayUtils.getInt(obtainStyledAttributes, R.styleable.Preference_order, R.styleable.Preference_android_order, Integer.MAX_VALUE);
        this.mFragment = TypedArrayUtils.getString(obtainStyledAttributes, R.styleable.Preference_fragment, R.styleable.Preference_android_fragment);
        this.mLayoutResId = TypedArrayUtils.getResourceId(obtainStyledAttributes, R.styleable.Preference_layout, R.styleable.Preference_android_layout, com.tencent.mobileqq.R.layout.frh);
        this.mWidgetLayoutResId = TypedArrayUtils.getResourceId(obtainStyledAttributes, R.styleable.Preference_widgetLayout, R.styleable.Preference_android_widgetLayout, 0);
        this.mEnabled = TypedArrayUtils.getBoolean(obtainStyledAttributes, R.styleable.Preference_enabled, R.styleable.Preference_android_enabled, true);
        this.mSelectable = TypedArrayUtils.getBoolean(obtainStyledAttributes, R.styleable.Preference_selectable, R.styleable.Preference_android_selectable, true);
        this.mPersistent = TypedArrayUtils.getBoolean(obtainStyledAttributes, R.styleable.Preference_persistent, R.styleable.Preference_android_persistent, true);
        this.mDependencyKey = TypedArrayUtils.getString(obtainStyledAttributes, R.styleable.Preference_dependency, R.styleable.Preference_android_dependency);
        int i17 = R.styleable.Preference_allowDividerAbove;
        this.mAllowDividerAbove = TypedArrayUtils.getBoolean(obtainStyledAttributes, i17, i17, this.mSelectable);
        int i18 = R.styleable.Preference_allowDividerBelow;
        this.mAllowDividerBelow = TypedArrayUtils.getBoolean(obtainStyledAttributes, i18, i18, this.mSelectable);
        int i19 = R.styleable.Preference_defaultValue;
        if (obtainStyledAttributes.hasValue(i19)) {
            this.mDefaultValue = onGetDefaultValue(obtainStyledAttributes, i19);
        } else {
            int i26 = R.styleable.Preference_android_defaultValue;
            if (obtainStyledAttributes.hasValue(i26)) {
                this.mDefaultValue = onGetDefaultValue(obtainStyledAttributes, i26);
            }
        }
        this.mShouldDisableView = TypedArrayUtils.getBoolean(obtainStyledAttributes, R.styleable.Preference_shouldDisableView, R.styleable.Preference_android_shouldDisableView, true);
        int i27 = R.styleable.Preference_singleLineTitle;
        boolean hasValue = obtainStyledAttributes.hasValue(i27);
        this.mHasSingleLineTitleAttr = hasValue;
        if (hasValue) {
            this.mSingleLineTitle = TypedArrayUtils.getBoolean(obtainStyledAttributes, i27, R.styleable.Preference_android_singleLineTitle, true);
        }
        this.mIconSpaceReserved = TypedArrayUtils.getBoolean(obtainStyledAttributes, R.styleable.Preference_iconSpaceReserved, R.styleable.Preference_android_iconSpaceReserved, false);
        int i28 = R.styleable.Preference_isPreferenceVisible;
        this.mVisible = TypedArrayUtils.getBoolean(obtainStyledAttributes, i28, i28, true);
        obtainStyledAttributes.recycle();
    }

    private void dispatchSetInitialValue() {
        if (getPreferenceDataStore() != null) {
            onSetInitialValue(true, this.mDefaultValue);
            return;
        }
        if (shouldPersist() && getSharedPreferences().contains(this.mKey)) {
            onSetInitialValue(true, null);
            return;
        }
        Object obj = this.mDefaultValue;
        if (obj != null) {
            onSetInitialValue(false, obj);
        }
    }

    private void registerDependency() {
        if (TextUtils.isEmpty(this.mDependencyKey)) {
            return;
        }
        Preference findPreferenceInHierarchy = findPreferenceInHierarchy(this.mDependencyKey);
        if (findPreferenceInHierarchy != null) {
            findPreferenceInHierarchy.registerDependent(this);
            return;
        }
        throw new IllegalStateException("Dependency \"" + this.mDependencyKey + "\" not found for preference \"" + this.mKey + "\" (title: \"" + ((Object) this.mTitle) + "\"");
    }

    private void registerDependent(Preference preference) {
        if (this.mDependents == null) {
            this.mDependents = new ArrayList();
        }
        this.mDependents.add(preference);
        preference.onDependencyChanged(this, shouldDisableDependents());
    }

    private void setEnabledStateOnViews(View view, boolean z16) {
        view.setEnabled(z16);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                setEnabledStateOnViews(viewGroup.getChildAt(childCount), z16);
            }
        }
    }

    private void tryCommit(@NonNull SharedPreferences.Editor editor) {
        if (this.mPreferenceManager.shouldCommit()) {
            editor.apply();
        }
    }

    private void unregisterDependency() {
        Preference findPreferenceInHierarchy;
        String str = this.mDependencyKey;
        if (str != null && (findPreferenceInHierarchy = findPreferenceInHierarchy(str)) != null) {
            findPreferenceInHierarchy.unregisterDependent(this);
        }
    }

    private void unregisterDependent(Preference preference) {
        List<Preference> list = this.mDependents;
        if (list != null) {
            list.remove(preference);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void assignParent(@Nullable PreferenceGroup preferenceGroup) {
        this.mParentGroup = preferenceGroup;
    }

    public boolean callChangeListener(Object obj) {
        OnPreferenceChangeListener onPreferenceChangeListener = this.mOnChangeListener;
        if (onPreferenceChangeListener != null && !onPreferenceChangeListener.onPreferenceChange(this, obj)) {
            return false;
        }
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void clearWasDetached() {
        this.mWasDetached = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dispatchRestoreInstanceState(Bundle bundle) {
        Parcelable parcelable;
        if (hasKey() && (parcelable = bundle.getParcelable(this.mKey)) != null) {
            this.mBaseMethodCalled = false;
            onRestoreInstanceState(parcelable);
            if (!this.mBaseMethodCalled) {
                throw new IllegalStateException("Derived class did not call super.onRestoreInstanceState()");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dispatchSaveInstanceState(Bundle bundle) {
        if (hasKey()) {
            this.mBaseMethodCalled = false;
            Parcelable onSaveInstanceState = onSaveInstanceState();
            if (this.mBaseMethodCalled) {
                if (onSaveInstanceState != null) {
                    bundle.putParcelable(this.mKey, onSaveInstanceState);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Derived class did not call super.onSaveInstanceState()");
        }
    }

    protected Preference findPreferenceInHierarchy(String str) {
        PreferenceManager preferenceManager;
        if (!TextUtils.isEmpty(str) && (preferenceManager = this.mPreferenceManager) != null) {
            return preferenceManager.findPreference(str);
        }
        return null;
    }

    public Context getContext() {
        return this.mContext;
    }

    public String getDependency() {
        return this.mDependencyKey;
    }

    public Bundle getExtras() {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        return this.mExtras;
    }

    StringBuilder getFilterableStringBuilder() {
        StringBuilder sb5 = new StringBuilder();
        CharSequence title = getTitle();
        if (!TextUtils.isEmpty(title)) {
            sb5.append(title);
            sb5.append(TokenParser.SP);
        }
        CharSequence summary = getSummary();
        if (!TextUtils.isEmpty(summary)) {
            sb5.append(summary);
            sb5.append(TokenParser.SP);
        }
        if (sb5.length() > 0) {
            sb5.setLength(sb5.length() - 1);
        }
        return sb5;
    }

    public String getFragment() {
        return this.mFragment;
    }

    public Drawable getIcon() {
        int i3;
        if (this.mIcon == null && (i3 = this.mIconResId) != 0) {
            this.mIcon = ContextCompat.getDrawable(this.mContext, i3);
        }
        return this.mIcon;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getId() {
        return this.mId;
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    public String getKey() {
        return this.mKey;
    }

    public final int getLayoutResource() {
        return this.mLayoutResId;
    }

    public OnPreferenceChangeListener getOnPreferenceChangeListener() {
        return this.mOnChangeListener;
    }

    public OnPreferenceClickListener getOnPreferenceClickListener() {
        return this.mOnClickListener;
    }

    public int getOrder() {
        return this.mOrder;
    }

    @Nullable
    public PreferenceGroup getParent() {
        return this.mParentGroup;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean getPersistedBoolean(boolean z16) {
        if (!shouldPersist()) {
            return z16;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            return preferenceDataStore.getBoolean(this.mKey, z16);
        }
        return this.mPreferenceManager.getSharedPreferences().getBoolean(this.mKey, z16);
    }

    protected float getPersistedFloat(float f16) {
        if (!shouldPersist()) {
            return f16;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            return preferenceDataStore.getFloat(this.mKey, f16);
        }
        return this.mPreferenceManager.getSharedPreferences().getFloat(this.mKey, f16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getPersistedInt(int i3) {
        if (!shouldPersist()) {
            return i3;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            return preferenceDataStore.getInt(this.mKey, i3);
        }
        return this.mPreferenceManager.getSharedPreferences().getInt(this.mKey, i3);
    }

    protected long getPersistedLong(long j3) {
        if (!shouldPersist()) {
            return j3;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            return preferenceDataStore.getLong(this.mKey, j3);
        }
        return this.mPreferenceManager.getSharedPreferences().getLong(this.mKey, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getPersistedString(String str) {
        if (!shouldPersist()) {
            return str;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            return preferenceDataStore.getString(this.mKey, str);
        }
        return this.mPreferenceManager.getSharedPreferences().getString(this.mKey, str);
    }

    public Set<String> getPersistedStringSet(Set<String> set) {
        if (!shouldPersist()) {
            return set;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            return preferenceDataStore.getStringSet(this.mKey, set);
        }
        return this.mPreferenceManager.getSharedPreferences().getStringSet(this.mKey, set);
    }

    @Nullable
    public PreferenceDataStore getPreferenceDataStore() {
        PreferenceDataStore preferenceDataStore = this.mPreferenceDataStore;
        if (preferenceDataStore != null) {
            return preferenceDataStore;
        }
        PreferenceManager preferenceManager = this.mPreferenceManager;
        if (preferenceManager != null) {
            return preferenceManager.getPreferenceDataStore();
        }
        return null;
    }

    public PreferenceManager getPreferenceManager() {
        return this.mPreferenceManager;
    }

    public SharedPreferences getSharedPreferences() {
        if (this.mPreferenceManager != null && getPreferenceDataStore() == null) {
            return this.mPreferenceManager.getSharedPreferences();
        }
        return null;
    }

    public boolean getShouldDisableView() {
        return this.mShouldDisableView;
    }

    public CharSequence getSummary() {
        return this.mSummary;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public final int getWidgetLayoutResource() {
        return this.mWidgetLayoutResId;
    }

    public boolean hasKey() {
        return !TextUtils.isEmpty(this.mKey);
    }

    public boolean isEnabled() {
        if (this.mEnabled && this.mDependencyMet && this.mParentDependencyMet) {
            return true;
        }
        return false;
    }

    public boolean isIconSpaceReserved() {
        return this.mIconSpaceReserved;
    }

    public boolean isPersistent() {
        return this.mPersistent;
    }

    public boolean isSelectable() {
        return this.mSelectable;
    }

    public final boolean isShown() {
        if (!isVisible() || getPreferenceManager() == null) {
            return false;
        }
        if (this == getPreferenceManager().getPreferenceScreen()) {
            return true;
        }
        PreferenceGroup parent = getParent();
        if (parent == null) {
            return false;
        }
        return parent.isShown();
    }

    public boolean isSingleLineTitle() {
        return this.mSingleLineTitle;
    }

    public final boolean isVisible() {
        return this.mVisible;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyChanged() {
        OnPreferenceChangeInternalListener onPreferenceChangeInternalListener = this.mListener;
        if (onPreferenceChangeInternalListener != null) {
            onPreferenceChangeInternalListener.onPreferenceChange(this);
        }
    }

    public void notifyDependencyChange(boolean z16) {
        List<Preference> list = this.mDependents;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            list.get(i3).onDependencyChanged(this, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyHierarchyChanged() {
        OnPreferenceChangeInternalListener onPreferenceChangeInternalListener = this.mListener;
        if (onPreferenceChangeInternalListener != null) {
            onPreferenceChangeInternalListener.onPreferenceHierarchyChange(this);
        }
    }

    public void onAttached() {
        registerDependency();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onAttachedToHierarchy(PreferenceManager preferenceManager) {
        this.mPreferenceManager = preferenceManager;
        if (!this.mHasId) {
            this.mId = preferenceManager.getNextId();
        }
        dispatchSetInitialValue();
    }

    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        int i3;
        preferenceViewHolder.itemView.setOnClickListener(this.mClickListener);
        preferenceViewHolder.itemView.setId(this.mViewId);
        TextView textView = (TextView) preferenceViewHolder.findViewById(android.R.id.title);
        int i16 = 8;
        if (textView != null) {
            CharSequence title = getTitle();
            if (!TextUtils.isEmpty(title)) {
                textView.setText(title);
                textView.setVisibility(0);
                if (this.mHasSingleLineTitleAttr) {
                    textView.setSingleLine(this.mSingleLineTitle);
                }
            } else {
                textView.setVisibility(8);
            }
        }
        TextView textView2 = (TextView) preferenceViewHolder.findViewById(android.R.id.summary);
        if (textView2 != null) {
            CharSequence summary = getSummary();
            if (!TextUtils.isEmpty(summary)) {
                textView2.setText(summary);
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
        }
        ImageView imageView = (ImageView) preferenceViewHolder.findViewById(android.R.id.icon);
        if (imageView != null) {
            if (this.mIconResId != 0 || this.mIcon != null) {
                if (this.mIcon == null) {
                    this.mIcon = ContextCompat.getDrawable(getContext(), this.mIconResId);
                }
                Drawable drawable = this.mIcon;
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                }
            }
            if (this.mIcon != null) {
                imageView.setVisibility(0);
            } else {
                if (this.mIconSpaceReserved) {
                    i3 = 4;
                } else {
                    i3 = 8;
                }
                imageView.setVisibility(i3);
            }
        }
        View findViewById = preferenceViewHolder.findViewById(com.tencent.mobileqq.R.id.xdw);
        if (findViewById == null) {
            findViewById = preferenceViewHolder.findViewById(16908350);
        }
        if (findViewById != null) {
            if (this.mIcon != null) {
                findViewById.setVisibility(0);
            } else {
                if (this.mIconSpaceReserved) {
                    i16 = 4;
                }
                findViewById.setVisibility(i16);
            }
        }
        if (this.mShouldDisableView) {
            setEnabledStateOnViews(preferenceViewHolder.itemView, isEnabled());
        } else {
            setEnabledStateOnViews(preferenceViewHolder.itemView, true);
        }
        boolean isSelectable = isSelectable();
        preferenceViewHolder.itemView.setFocusable(isSelectable);
        preferenceViewHolder.itemView.setClickable(isSelectable);
        preferenceViewHolder.setDividerAllowedAbove(this.mAllowDividerAbove);
        preferenceViewHolder.setDividerAllowedBelow(this.mAllowDividerBelow);
    }

    public void onDependencyChanged(Preference preference, boolean z16) {
        if (this.mDependencyMet == z16) {
            this.mDependencyMet = !z16;
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        }
    }

    public void onDetached() {
        unregisterDependency();
        this.mWasDetached = true;
    }

    protected Object onGetDefaultValue(TypedArray typedArray, int i3) {
        return null;
    }

    public void onParentChanged(Preference preference, boolean z16) {
        if (this.mParentDependencyMet == z16) {
            this.mParentDependencyMet = !z16;
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPrepareForRemoval() {
        unregisterDependency();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        this.mBaseMethodCalled = true;
        if (parcelable != AbsSavedState.EMPTY_STATE && parcelable != null) {
            throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        this.mBaseMethodCalled = true;
        return AbsSavedState.EMPTY_STATE;
    }

    protected void onSetInitialValue(@Nullable Object obj) {
    }

    public Bundle peekExtras() {
        return this.mExtras;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void performClick(View view) {
        performClick();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean persistBoolean(boolean z16) {
        if (!shouldPersist()) {
            return false;
        }
        if (z16 == getPersistedBoolean(!z16)) {
            return true;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            preferenceDataStore.putBoolean(this.mKey, z16);
        } else {
            SharedPreferences.Editor editor = this.mPreferenceManager.getEditor();
            editor.putBoolean(this.mKey, z16);
            tryCommit(editor);
        }
        return true;
    }

    protected boolean persistFloat(float f16) {
        if (!shouldPersist()) {
            return false;
        }
        if (f16 == getPersistedFloat(Float.NaN)) {
            return true;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            preferenceDataStore.putFloat(this.mKey, f16);
        } else {
            SharedPreferences.Editor editor = this.mPreferenceManager.getEditor();
            editor.putFloat(this.mKey, f16);
            tryCommit(editor);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean persistInt(int i3) {
        if (!shouldPersist()) {
            return false;
        }
        if (i3 == getPersistedInt(~i3)) {
            return true;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            preferenceDataStore.putInt(this.mKey, i3);
        } else {
            SharedPreferences.Editor editor = this.mPreferenceManager.getEditor();
            editor.putInt(this.mKey, i3);
            tryCommit(editor);
        }
        return true;
    }

    protected boolean persistLong(long j3) {
        if (!shouldPersist()) {
            return false;
        }
        if (j3 == getPersistedLong(~j3)) {
            return true;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            preferenceDataStore.putLong(this.mKey, j3);
        } else {
            SharedPreferences.Editor editor = this.mPreferenceManager.getEditor();
            editor.putLong(this.mKey, j3);
            tryCommit(editor);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean persistString(String str) {
        if (!shouldPersist()) {
            return false;
        }
        if (TextUtils.equals(str, getPersistedString(null))) {
            return true;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            preferenceDataStore.putString(this.mKey, str);
        } else {
            SharedPreferences.Editor editor = this.mPreferenceManager.getEditor();
            editor.putString(this.mKey, str);
            tryCommit(editor);
        }
        return true;
    }

    public boolean persistStringSet(Set<String> set) {
        if (!shouldPersist()) {
            return false;
        }
        if (set.equals(getPersistedStringSet(null))) {
            return true;
        }
        PreferenceDataStore preferenceDataStore = getPreferenceDataStore();
        if (preferenceDataStore != null) {
            preferenceDataStore.putStringSet(this.mKey, set);
        } else {
            SharedPreferences.Editor editor = this.mPreferenceManager.getEditor();
            editor.putStringSet(this.mKey, set);
            tryCommit(editor);
        }
        return true;
    }

    void requireKey() {
        if (!TextUtils.isEmpty(this.mKey)) {
            this.mRequiresKey = true;
            return;
        }
        throw new IllegalStateException("Preference does not have a key assigned.");
    }

    public void restoreHierarchyState(Bundle bundle) {
        dispatchRestoreInstanceState(bundle);
    }

    public void saveHierarchyState(Bundle bundle) {
        dispatchSaveInstanceState(bundle);
    }

    public void setDefaultValue(Object obj) {
        this.mDefaultValue = obj;
    }

    public void setDependency(String str) {
        unregisterDependency();
        this.mDependencyKey = str;
        registerDependency();
    }

    public void setEnabled(boolean z16) {
        if (this.mEnabled != z16) {
            this.mEnabled = z16;
            notifyDependencyChange(shouldDisableDependents());
            notifyChanged();
        }
    }

    public void setFragment(String str) {
        this.mFragment = str;
    }

    public void setIcon(Drawable drawable) {
        if ((drawable != null || this.mIcon == null) && (drawable == null || this.mIcon == drawable)) {
            return;
        }
        this.mIcon = drawable;
        this.mIconResId = 0;
        notifyChanged();
    }

    public void setIconSpaceReserved(boolean z16) {
        this.mIconSpaceReserved = z16;
        notifyChanged();
    }

    public void setIntent(Intent intent) {
        this.mIntent = intent;
    }

    public void setKey(String str) {
        this.mKey = str;
        if (this.mRequiresKey && !hasKey()) {
            requireKey();
        }
    }

    public void setLayoutResource(int i3) {
        this.mLayoutResId = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setOnPreferenceChangeInternalListener(OnPreferenceChangeInternalListener onPreferenceChangeInternalListener) {
        this.mListener = onPreferenceChangeInternalListener;
    }

    public void setOnPreferenceChangeListener(OnPreferenceChangeListener onPreferenceChangeListener) {
        this.mOnChangeListener = onPreferenceChangeListener;
    }

    public void setOnPreferenceClickListener(OnPreferenceClickListener onPreferenceClickListener) {
        this.mOnClickListener = onPreferenceClickListener;
    }

    public void setOrder(int i3) {
        if (i3 != this.mOrder) {
            this.mOrder = i3;
            notifyHierarchyChanged();
        }
    }

    public void setPersistent(boolean z16) {
        this.mPersistent = z16;
    }

    public void setPreferenceDataStore(PreferenceDataStore preferenceDataStore) {
        this.mPreferenceDataStore = preferenceDataStore;
    }

    public void setSelectable(boolean z16) {
        if (this.mSelectable != z16) {
            this.mSelectable = z16;
            notifyChanged();
        }
    }

    public void setShouldDisableView(boolean z16) {
        this.mShouldDisableView = z16;
        notifyChanged();
    }

    public void setSingleLineTitle(boolean z16) {
        this.mHasSingleLineTitleAttr = true;
        this.mSingleLineTitle = z16;
    }

    public void setSummary(CharSequence charSequence) {
        if ((charSequence != null || this.mSummary == null) && (charSequence == null || charSequence.equals(this.mSummary))) {
            return;
        }
        this.mSummary = charSequence;
        notifyChanged();
    }

    public void setTitle(CharSequence charSequence) {
        if ((charSequence != null || this.mTitle == null) && (charSequence == null || charSequence.equals(this.mTitle))) {
            return;
        }
        this.mTitle = charSequence;
        notifyChanged();
    }

    public void setViewId(int i3) {
        this.mViewId = i3;
    }

    public final void setVisible(boolean z16) {
        if (this.mVisible != z16) {
            this.mVisible = z16;
            OnPreferenceChangeInternalListener onPreferenceChangeInternalListener = this.mListener;
            if (onPreferenceChangeInternalListener != null) {
                onPreferenceChangeInternalListener.onPreferenceVisibilityChange(this);
            }
        }
    }

    public void setWidgetLayoutResource(int i3) {
        this.mWidgetLayoutResId = i3;
    }

    public boolean shouldDisableDependents() {
        return !isEnabled();
    }

    protected boolean shouldPersist() {
        if (this.mPreferenceManager != null && isPersistent() && hasKey()) {
            return true;
        }
        return false;
    }

    public String toString() {
        return getFilterableStringBuilder().toString();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final boolean wasDetached() {
        return this.mWasDetached;
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull Preference preference) {
        int i3 = this.mOrder;
        int i16 = preference.mOrder;
        if (i3 != i16) {
            return i3 - i16;
        }
        CharSequence charSequence = this.mTitle;
        CharSequence charSequence2 = preference.mTitle;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference.mTitle.toString());
    }

    @Deprecated
    protected void onSetInitialValue(boolean z16, Object obj) {
        onSetInitialValue(obj);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void performClick() {
        PreferenceManager.OnPreferenceTreeClickListener onPreferenceTreeClickListener;
        if (isEnabled()) {
            onClick();
            OnPreferenceClickListener onPreferenceClickListener = this.mOnClickListener;
            if (onPreferenceClickListener == null || !onPreferenceClickListener.onPreferenceClick(this)) {
                PreferenceManager preferenceManager = getPreferenceManager();
                if ((preferenceManager == null || (onPreferenceTreeClickListener = preferenceManager.getOnPreferenceTreeClickListener()) == null || !onPreferenceTreeClickListener.onPreferenceTreeClick(this)) && this.mIntent != null) {
                    getContext().startActivity(this.mIntent);
                }
            }
        }
    }

    public void setTitle(int i3) {
        setTitle(this.mContext.getString(i3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onAttachedToHierarchy(PreferenceManager preferenceManager, long j3) {
        this.mId = j3;
        this.mHasId = true;
        try {
            onAttachedToHierarchy(preferenceManager);
        } finally {
            this.mHasId = false;
        }
    }

    public void setIcon(int i3) {
        setIcon(ContextCompat.getDrawable(this.mContext, i3));
        this.mIconResId = i3;
    }

    public void setSummary(int i3) {
        setSummary(this.mContext.getString(i3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onClick() {
    }

    @CallSuper
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    public Preference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.getAttr(context, com.tencent.mobileqq.R.attr.b2b, android.R.attr.preferenceStyle));
    }

    public Preference(Context context) {
        this(context, null);
    }
}
