package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.Preference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class PreferenceGroup extends Preference {
    private static final String TAG = "PreferenceGroup";
    private boolean mAttachedToHierarchy;
    private final Runnable mClearRecycleCacheRunnable;
    private int mCurrentPreferenceOrder;
    private final Handler mHandler;
    final SimpleArrayMap<String, Long> mIdRecycleCache;
    private int mInitialExpandedChildrenCount;
    private OnExpandButtonClickListener mOnExpandButtonClickListener;
    private boolean mOrderingAsAdded;
    private List<Preference> mPreferenceList;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public interface OnExpandButtonClickListener {
        void onExpandButtonClick();
    }

    /* loaded from: classes.dex */
    public interface PreferencePositionCallback {
        int getPreferenceAdapterPosition(Preference preference);

        int getPreferenceAdapterPosition(String str);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.mOrderingAsAdded = true;
        this.mCurrentPreferenceOrder = 0;
        this.mAttachedToHierarchy = false;
        this.mInitialExpandedChildrenCount = Integer.MAX_VALUE;
        this.mOnExpandButtonClickListener = null;
        this.mIdRecycleCache = new SimpleArrayMap<>();
        this.mHandler = new Handler();
        this.mClearRecycleCacheRunnable = new Runnable() { // from class: androidx.preference.PreferenceGroup.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (this) {
                    PreferenceGroup.this.mIdRecycleCache.clear();
                }
            }
        };
        this.mPreferenceList = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PreferenceGroup, i3, i16);
        int i17 = R.styleable.PreferenceGroup_orderingFromXml;
        this.mOrderingAsAdded = TypedArrayUtils.getBoolean(obtainStyledAttributes, i17, i17, true);
        int i18 = R.styleable.PreferenceGroup_initialExpandedChildrenCount;
        if (obtainStyledAttributes.hasValue(i18)) {
            setInitialExpandedChildrenCount(TypedArrayUtils.getInt(obtainStyledAttributes, i18, i18, Integer.MAX_VALUE));
        }
        obtainStyledAttributes.recycle();
    }

    private boolean removePreferenceInt(Preference preference) {
        boolean remove;
        synchronized (this) {
            preference.onPrepareForRemoval();
            if (preference.getParent() == this) {
                preference.assignParent(null);
            }
            remove = this.mPreferenceList.remove(preference);
            if (remove) {
                String key = preference.getKey();
                if (key != null) {
                    this.mIdRecycleCache.put(key, Long.valueOf(preference.getId()));
                    this.mHandler.removeCallbacks(this.mClearRecycleCacheRunnable);
                    this.mHandler.post(this.mClearRecycleCacheRunnable);
                }
                if (this.mAttachedToHierarchy) {
                    preference.onDetached();
                }
            }
        }
        return remove;
    }

    public void addItemFromInflater(Preference preference) {
        addPreference(preference);
    }

    public boolean addPreference(Preference preference) {
        long nextId;
        if (this.mPreferenceList.contains(preference)) {
            return true;
        }
        if (preference.getKey() != null) {
            PreferenceGroup preferenceGroup = this;
            while (preferenceGroup.getParent() != null) {
                preferenceGroup = preferenceGroup.getParent();
            }
            String key = preference.getKey();
            if (preferenceGroup.findPreference(key) != null) {
                Log.e(TAG, "Found duplicated key: \"" + key + "\". This can cause unintended behaviour, please use unique keys for every preference.");
            }
        }
        if (preference.getOrder() == Integer.MAX_VALUE) {
            if (this.mOrderingAsAdded) {
                int i3 = this.mCurrentPreferenceOrder;
                this.mCurrentPreferenceOrder = i3 + 1;
                preference.setOrder(i3);
            }
            if (preference instanceof PreferenceGroup) {
                ((PreferenceGroup) preference).setOrderingAsAdded(this.mOrderingAsAdded);
            }
        }
        int binarySearch = Collections.binarySearch(this.mPreferenceList, preference);
        if (binarySearch < 0) {
            binarySearch = (binarySearch * (-1)) - 1;
        }
        if (!onPrepareAddPreference(preference)) {
            return false;
        }
        synchronized (this) {
            this.mPreferenceList.add(binarySearch, preference);
        }
        PreferenceManager preferenceManager = getPreferenceManager();
        String key2 = preference.getKey();
        if (key2 != null && this.mIdRecycleCache.containsKey(key2)) {
            nextId = this.mIdRecycleCache.get(key2).longValue();
            this.mIdRecycleCache.remove(key2);
        } else {
            nextId = preferenceManager.getNextId();
        }
        preference.onAttachedToHierarchy(preferenceManager, nextId);
        preference.assignParent(this);
        if (this.mAttachedToHierarchy) {
            preference.onAttached();
        }
        notifyHierarchyChanged();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.Preference
    public void dispatchRestoreInstanceState(Bundle bundle) {
        super.dispatchRestoreInstanceState(bundle);
        int preferenceCount = getPreferenceCount();
        for (int i3 = 0; i3 < preferenceCount; i3++) {
            getPreference(i3).dispatchRestoreInstanceState(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.Preference
    public void dispatchSaveInstanceState(Bundle bundle) {
        super.dispatchSaveInstanceState(bundle);
        int preferenceCount = getPreferenceCount();
        for (int i3 = 0; i3 < preferenceCount; i3++) {
            getPreference(i3).dispatchSaveInstanceState(bundle);
        }
    }

    public Preference findPreference(CharSequence charSequence) {
        Preference findPreference;
        if (TextUtils.equals(getKey(), charSequence)) {
            return this;
        }
        int preferenceCount = getPreferenceCount();
        for (int i3 = 0; i3 < preferenceCount; i3++) {
            Preference preference = getPreference(i3);
            String key = preference.getKey();
            if (key != null && key.equals(charSequence)) {
                return preference;
            }
            if ((preference instanceof PreferenceGroup) && (findPreference = ((PreferenceGroup) preference).findPreference(charSequence)) != null) {
                return findPreference;
            }
        }
        return null;
    }

    public int getInitialExpandedChildrenCount() {
        return this.mInitialExpandedChildrenCount;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public OnExpandButtonClickListener getOnExpandButtonClickListener() {
        return this.mOnExpandButtonClickListener;
    }

    public Preference getPreference(int i3) {
        return this.mPreferenceList.get(i3);
    }

    public int getPreferenceCount() {
        return this.mPreferenceList.size();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isAttached() {
        return this.mAttachedToHierarchy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isOnSameScreenAsChildren() {
        return true;
    }

    public boolean isOrderingAsAdded() {
        return this.mOrderingAsAdded;
    }

    @Override // androidx.preference.Preference
    public void notifyDependencyChange(boolean z16) {
        super.notifyDependencyChange(z16);
        int preferenceCount = getPreferenceCount();
        for (int i3 = 0; i3 < preferenceCount; i3++) {
            getPreference(i3).onParentChanged(this, z16);
        }
    }

    @Override // androidx.preference.Preference
    public void onAttached() {
        super.onAttached();
        this.mAttachedToHierarchy = true;
        int preferenceCount = getPreferenceCount();
        for (int i3 = 0; i3 < preferenceCount; i3++) {
            getPreference(i3).onAttached();
        }
    }

    @Override // androidx.preference.Preference
    public void onDetached() {
        super.onDetached();
        this.mAttachedToHierarchy = false;
        int preferenceCount = getPreferenceCount();
        for (int i3 = 0; i3 < preferenceCount; i3++) {
            getPreference(i3).onDetached();
        }
    }

    protected boolean onPrepareAddPreference(Preference preference) {
        preference.onParentChanged(this, shouldDisableDependents());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.Preference
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable != null && parcelable.getClass().equals(SavedState.class)) {
            SavedState savedState = (SavedState) parcelable;
            this.mInitialExpandedChildrenCount = savedState.mInitialExpandedChildrenCount;
            super.onRestoreInstanceState(savedState.getSuperState());
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.Preference
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.mInitialExpandedChildrenCount);
    }

    public void removeAll() {
        synchronized (this) {
            List<Preference> list = this.mPreferenceList;
            for (int size = list.size() - 1; size >= 0; size--) {
                removePreferenceInt(list.get(0));
            }
        }
        notifyHierarchyChanged();
    }

    public boolean removePreference(Preference preference) {
        boolean removePreferenceInt = removePreferenceInt(preference);
        notifyHierarchyChanged();
        return removePreferenceInt;
    }

    public void setInitialExpandedChildrenCount(int i3) {
        if (i3 != Integer.MAX_VALUE && !hasKey()) {
            Log.e(TAG, getClass().getSimpleName() + " should have a key defined if it contains an expandable preference");
        }
        this.mInitialExpandedChildrenCount = i3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setOnExpandButtonClickListener(@Nullable OnExpandButtonClickListener onExpandButtonClickListener) {
        this.mOnExpandButtonClickListener = onExpandButtonClickListener;
    }

    public void setOrderingAsAdded(boolean z16) {
        this.mOrderingAsAdded = z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sortPreferences() {
        synchronized (this) {
            Collections.sort(this.mPreferenceList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.preference.PreferenceGroup.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }
        };
        int mInitialExpandedChildrenCount;

        SavedState(Parcel parcel) {
            super(parcel);
            this.mInitialExpandedChildrenCount = parcel.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.mInitialExpandedChildrenCount);
        }

        SavedState(Parcelable parcelable, int i3) {
            super(parcelable);
            this.mInitialExpandedChildrenCount = i3;
        }
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
