package androidx.preference;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class PreferenceGroupAdapter extends RecyclerView.Adapter<PreferenceViewHolder> implements Preference.OnPreferenceChangeInternalListener, PreferenceGroup.PreferencePositionCallback {
    private Handler mHandler;
    private PreferenceGroup mPreferenceGroup;
    private CollapsiblePreferenceGroupController mPreferenceGroupController;
    private List<PreferenceLayout> mPreferenceLayouts;
    private List<Preference> mPreferenceList;
    private List<Preference> mPreferenceListInternal;
    private Runnable mSyncRunnable;
    private PreferenceLayout mTempPreferenceLayout;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class PreferenceLayout {
        String mName;
        int mResId;
        int mWidgetResId;

        PreferenceLayout() {
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof PreferenceLayout)) {
                return false;
            }
            PreferenceLayout preferenceLayout = (PreferenceLayout) obj;
            if (this.mResId != preferenceLayout.mResId || this.mWidgetResId != preferenceLayout.mWidgetResId || !TextUtils.equals(this.mName, preferenceLayout.mName)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return ((((527 + this.mResId) * 31) + this.mWidgetResId) * 31) + this.mName.hashCode();
        }

        PreferenceLayout(PreferenceLayout preferenceLayout) {
            this.mResId = preferenceLayout.mResId;
            this.mWidgetResId = preferenceLayout.mWidgetResId;
            this.mName = preferenceLayout.mName;
        }
    }

    public PreferenceGroupAdapter(PreferenceGroup preferenceGroup) {
        this(preferenceGroup, new Handler());
    }

    private void addPreferenceClassName(Preference preference) {
        PreferenceLayout createPreferenceLayout = createPreferenceLayout(preference, null);
        if (!this.mPreferenceLayouts.contains(createPreferenceLayout)) {
            this.mPreferenceLayouts.add(createPreferenceLayout);
        }
    }

    @VisibleForTesting
    static PreferenceGroupAdapter createInstanceWithCustomHandler(PreferenceGroup preferenceGroup, Handler handler) {
        return new PreferenceGroupAdapter(preferenceGroup, handler);
    }

    private PreferenceLayout createPreferenceLayout(Preference preference, PreferenceLayout preferenceLayout) {
        if (preferenceLayout == null) {
            preferenceLayout = new PreferenceLayout();
        }
        preferenceLayout.mName = preference.getClass().getName();
        preferenceLayout.mResId = preference.getLayoutResource();
        preferenceLayout.mWidgetResId = preference.getWidgetLayoutResource();
        return preferenceLayout;
    }

    private void flattenPreferenceGroup(List<Preference> list, PreferenceGroup preferenceGroup) {
        preferenceGroup.sortPreferences();
        int preferenceCount = preferenceGroup.getPreferenceCount();
        for (int i3 = 0; i3 < preferenceCount; i3++) {
            Preference preference = preferenceGroup.getPreference(i3);
            list.add(preference);
            addPreferenceClassName(preference);
            if (preference instanceof PreferenceGroup) {
                PreferenceGroup preferenceGroup2 = (PreferenceGroup) preference;
                if (preferenceGroup2.isOnSameScreenAsChildren()) {
                    flattenPreferenceGroup(list, preferenceGroup2);
                }
            }
            preference.setOnPreferenceChangeInternalListener(this);
        }
    }

    public Preference getItem(int i3) {
        if (i3 >= 0 && i3 < getItemCount()) {
            return this.mPreferenceList.get(i3);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mPreferenceList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        if (!hasStableIds()) {
            return -1L;
        }
        return getItem(i3).getId();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        PreferenceLayout createPreferenceLayout = createPreferenceLayout(getItem(i3), this.mTempPreferenceLayout);
        this.mTempPreferenceLayout = createPreferenceLayout;
        int indexOf = this.mPreferenceLayouts.indexOf(createPreferenceLayout);
        if (indexOf != -1) {
            return indexOf;
        }
        int size = this.mPreferenceLayouts.size();
        this.mPreferenceLayouts.add(new PreferenceLayout(this.mTempPreferenceLayout));
        return size;
    }

    @Override // androidx.preference.PreferenceGroup.PreferencePositionCallback
    public int getPreferenceAdapterPosition(String str) {
        int size = this.mPreferenceList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (TextUtils.equals(str, this.mPreferenceList.get(i3).getKey())) {
                return i3;
            }
        }
        return -1;
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeInternalListener
    public void onPreferenceChange(Preference preference) {
        int indexOf = this.mPreferenceList.indexOf(preference);
        if (indexOf != -1) {
            notifyItemChanged(indexOf, preference);
        }
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeInternalListener
    public void onPreferenceHierarchyChange(Preference preference) {
        this.mHandler.removeCallbacks(this.mSyncRunnable);
        this.mHandler.post(this.mSyncRunnable);
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeInternalListener
    public void onPreferenceVisibilityChange(Preference preference) {
        if (!this.mPreferenceListInternal.contains(preference) || this.mPreferenceGroupController.onPreferenceVisibilityChange(preference)) {
            return;
        }
        if (preference.isVisible()) {
            int i3 = -1;
            for (Preference preference2 : this.mPreferenceListInternal) {
                if (preference.equals(preference2)) {
                    break;
                } else if (preference2.isVisible()) {
                    i3++;
                }
            }
            int i16 = i3 + 1;
            this.mPreferenceList.add(i16, preference);
            notifyItemInserted(i16);
            return;
        }
        int size = this.mPreferenceList.size();
        int i17 = 0;
        while (i17 < size && !preference.equals(this.mPreferenceList.get(i17))) {
            if (i17 == size - 1) {
                return;
            } else {
                i17++;
            }
        }
        this.mPreferenceList.remove(i17);
        notifyItemRemoved(i17);
    }

    void syncMyPreferences() {
        Iterator<Preference> it = this.mPreferenceListInternal.iterator();
        while (it.hasNext()) {
            it.next().setOnPreferenceChangeInternalListener(null);
        }
        ArrayList arrayList = new ArrayList(this.mPreferenceListInternal.size());
        flattenPreferenceGroup(arrayList, this.mPreferenceGroup);
        final List<Preference> createVisiblePreferencesList = this.mPreferenceGroupController.createVisiblePreferencesList(this.mPreferenceGroup);
        final List<Preference> list = this.mPreferenceList;
        this.mPreferenceList = createVisiblePreferencesList;
        this.mPreferenceListInternal = arrayList;
        PreferenceManager preferenceManager = this.mPreferenceGroup.getPreferenceManager();
        if (preferenceManager != null && preferenceManager.getPreferenceComparisonCallback() != null) {
            final PreferenceManager.PreferenceComparisonCallback preferenceComparisonCallback = preferenceManager.getPreferenceComparisonCallback();
            DiffUtil.calculateDiff(new DiffUtil.Callback() { // from class: androidx.preference.PreferenceGroupAdapter.2
                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public boolean areContentsTheSame(int i3, int i16) {
                    return preferenceComparisonCallback.arePreferenceContentsTheSame((Preference) list.get(i3), (Preference) createVisiblePreferencesList.get(i16));
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public boolean areItemsTheSame(int i3, int i16) {
                    return preferenceComparisonCallback.arePreferenceItemsTheSame((Preference) list.get(i3), (Preference) createVisiblePreferencesList.get(i16));
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public int getNewListSize() {
                    return createVisiblePreferencesList.size();
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public int getOldListSize() {
                    return list.size();
                }
            }).dispatchUpdatesTo(this);
        } else {
            notifyDataSetChanged();
        }
        Iterator<Preference> it5 = arrayList.iterator();
        while (it5.hasNext()) {
            it5.next().clearWasDetached();
        }
    }

    PreferenceGroupAdapter(PreferenceGroup preferenceGroup, Handler handler) {
        this.mTempPreferenceLayout = new PreferenceLayout();
        this.mSyncRunnable = new Runnable() { // from class: androidx.preference.PreferenceGroupAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                PreferenceGroupAdapter.this.syncMyPreferences();
            }
        };
        this.mPreferenceGroup = preferenceGroup;
        this.mHandler = handler;
        this.mPreferenceGroupController = new CollapsiblePreferenceGroupController(preferenceGroup, this);
        this.mPreferenceGroup.setOnPreferenceChangeInternalListener(this);
        this.mPreferenceList = new ArrayList();
        this.mPreferenceListInternal = new ArrayList();
        this.mPreferenceLayouts = new ArrayList();
        PreferenceGroup preferenceGroup2 = this.mPreferenceGroup;
        if (preferenceGroup2 instanceof PreferenceScreen) {
            setHasStableIds(((PreferenceScreen) preferenceGroup2).shouldUseGeneratedIds());
        } else {
            setHasStableIds(true);
        }
        syncMyPreferences();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder, int i3) {
        getItem(i3).onBindViewHolder(preferenceViewHolder);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public PreferenceViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        PreferenceLayout preferenceLayout = this.mPreferenceLayouts.get(i3);
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        TypedArray obtainStyledAttributes = viewGroup.getContext().obtainStyledAttributes((AttributeSet) null, R.styleable.BackgroundStyle);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.BackgroundStyle_android_selectableItemBackground);
        if (drawable == null) {
            drawable = ContextCompat.getDrawable(viewGroup.getContext(), android.R.drawable.list_selector_background);
        }
        obtainStyledAttributes.recycle();
        View inflate = from.inflate(preferenceLayout.mResId, viewGroup, false);
        if (inflate.getBackground() == null) {
            ViewCompat.setBackground(inflate, drawable);
        }
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(android.R.id.widget_frame);
        if (viewGroup2 != null) {
            int i16 = preferenceLayout.mWidgetResId;
            if (i16 != 0) {
                from.inflate(i16, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        return new PreferenceViewHolder(inflate);
    }

    @Override // androidx.preference.PreferenceGroup.PreferencePositionCallback
    public int getPreferenceAdapterPosition(Preference preference) {
        int size = this.mPreferenceList.size();
        for (int i3 = 0; i3 < size; i3++) {
            Preference preference2 = this.mPreferenceList.get(i3);
            if (preference2 != null && preference2.equals(preference)) {
                return i3;
            }
        }
        return -1;
    }
}
