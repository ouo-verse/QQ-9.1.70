package androidx.preference;

import android.content.Context;
import android.text.TextUtils;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
final class CollapsiblePreferenceGroupController {
    private final Context mContext;
    private boolean mHasExpandablePreference = false;
    final PreferenceGroupAdapter mPreferenceGroupAdapter;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ExpandButton extends Preference {
        private long mId;

        ExpandButton(Context context, List<Preference> list, long j3) {
            super(context);
            initLayout();
            setSummary(list);
            this.mId = j3 + 1000000;
        }

        private void initLayout() {
            setLayoutResource(com.tencent.mobileqq.R.layout.e7b);
            setIcon(com.tencent.mobileqq.R.drawable.jsw);
            setTitle(com.tencent.mobileqq.R.string.f170903zw0);
            setOrder(999);
        }

        private void setSummary(List<Preference> list) {
            ArrayList arrayList = new ArrayList();
            CharSequence charSequence = null;
            for (Preference preference : list) {
                CharSequence title = preference.getTitle();
                boolean z16 = preference instanceof PreferenceGroup;
                if (z16 && !TextUtils.isEmpty(title)) {
                    arrayList.add((PreferenceGroup) preference);
                }
                if (arrayList.contains(preference.getParent())) {
                    if (z16) {
                        arrayList.add((PreferenceGroup) preference);
                    }
                } else if (!TextUtils.isEmpty(title)) {
                    if (charSequence == null) {
                        charSequence = title;
                    } else {
                        charSequence = getContext().getString(com.tencent.mobileqq.R.string.f229856xk, charSequence, title);
                    }
                }
            }
            setSummary(charSequence);
        }

        @Override // androidx.preference.Preference
        public long getId() {
            return this.mId;
        }

        @Override // androidx.preference.Preference
        public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
            super.onBindViewHolder(preferenceViewHolder);
            preferenceViewHolder.setDividerAllowedAbove(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CollapsiblePreferenceGroupController(PreferenceGroup preferenceGroup, PreferenceGroupAdapter preferenceGroupAdapter) {
        this.mPreferenceGroupAdapter = preferenceGroupAdapter;
        this.mContext = preferenceGroup.getContext();
    }

    private ExpandButton createExpandButton(final PreferenceGroup preferenceGroup, List<Preference> list) {
        ExpandButton expandButton = new ExpandButton(this.mContext, list, preferenceGroup.getId());
        expandButton.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: androidx.preference.CollapsiblePreferenceGroupController.1
            @Override // androidx.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                preferenceGroup.setInitialExpandedChildrenCount(Integer.MAX_VALUE);
                CollapsiblePreferenceGroupController.this.mPreferenceGroupAdapter.onPreferenceHierarchyChange(preference);
                PreferenceGroup.OnExpandButtonClickListener onExpandButtonClickListener = preferenceGroup.getOnExpandButtonClickListener();
                if (onExpandButtonClickListener != null) {
                    onExpandButtonClickListener.onExpandButtonClick();
                    return true;
                }
                return true;
            }
        });
        return expandButton;
    }

    private List<Preference> createInnerVisiblePreferencesList(PreferenceGroup preferenceGroup) {
        boolean z16;
        this.mHasExpandablePreference = false;
        if (preferenceGroup.getInitialExpandedChildrenCount() != Integer.MAX_VALUE) {
            z16 = true;
        } else {
            z16 = false;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int preferenceCount = preferenceGroup.getPreferenceCount();
        int i3 = 0;
        for (int i16 = 0; i16 < preferenceCount; i16++) {
            Preference preference = preferenceGroup.getPreference(i16);
            if (preference.isVisible()) {
                if (z16 && i3 >= preferenceGroup.getInitialExpandedChildrenCount()) {
                    arrayList2.add(preference);
                } else {
                    arrayList.add(preference);
                }
                if (!(preference instanceof PreferenceGroup)) {
                    i3++;
                } else {
                    PreferenceGroup preferenceGroup2 = (PreferenceGroup) preference;
                    if (preferenceGroup2.isOnSameScreenAsChildren()) {
                        List<Preference> createInnerVisiblePreferencesList = createInnerVisiblePreferencesList(preferenceGroup2);
                        if (z16 && this.mHasExpandablePreference) {
                            throw new IllegalArgumentException("Nested expand buttons are not supported!");
                        }
                        for (Preference preference2 : createInnerVisiblePreferencesList) {
                            if (z16 && i3 >= preferenceGroup.getInitialExpandedChildrenCount()) {
                                arrayList2.add(preference2);
                            } else {
                                arrayList.add(preference2);
                            }
                            i3++;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        if (z16 && i3 > preferenceGroup.getInitialExpandedChildrenCount()) {
            arrayList.add(createExpandButton(preferenceGroup, arrayList2));
        }
        this.mHasExpandablePreference |= z16;
        return arrayList;
    }

    public List<Preference> createVisiblePreferencesList(PreferenceGroup preferenceGroup) {
        return createInnerVisiblePreferencesList(preferenceGroup);
    }

    public boolean onPreferenceVisibilityChange(Preference preference) {
        if (!(preference instanceof PreferenceGroup) && !this.mHasExpandablePreference) {
            return false;
        }
        this.mPreferenceGroupAdapter.onPreferenceHierarchyChange(preference);
        return true;
    }
}
