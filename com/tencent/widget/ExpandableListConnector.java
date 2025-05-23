package com.tencent.widget;

import android.annotation.TargetApi;
import android.database.DataSetObserver;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.HeterogeneousExpandableList;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes27.dex */
public class ExpandableListConnector extends BaseAdapter implements Filterable {
    static IPatchRedirector $redirector_;
    private final DataSetObserver mDataSetObserver;
    private ArrayList<GroupMetadata> mExpGroupMetadataList;
    private ExpandableListAdapter mExpandableListAdapter;
    private int mMaxExpGroupCount;
    private int mTotalExpChildrenCount;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        static IPatchRedirector $redirector_ = null;
        public static final Parcelable.Creator<GroupMetadata> CREATOR;
        static final int REFRESH = -1;
        int flPos;
        long gId;
        int gPos;
        int lastChildFlPos;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class a implements Parcelable.Creator<GroupMetadata> {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public GroupMetadata createFromParcel(Parcel parcel) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (GroupMetadata) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }
                return GroupMetadata.obtain(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public GroupMetadata[] newArray(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (GroupMetadata[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
                return new GroupMetadata[i3];
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38386);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 5)) {
                redirector.redirect((short) 5);
            } else {
                CREATOR = new a();
            }
        }

        GroupMetadata() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        static GroupMetadata obtain(int i3, int i16, int i17, long j3) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.flPos = i3;
            groupMetadata.lastChildFlPos = i16;
            groupMetadata.gPos = i17;
            groupMetadata.gId = j3;
            return groupMetadata;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel, i3);
                return;
            }
            parcel.writeInt(this.flPos);
            parcel.writeInt(this.lastChildFlPos);
            parcel.writeInt(this.gPos);
            parcel.writeLong(this.gId);
        }

        @Override // java.lang.Comparable
        public int compareTo(GroupMetadata groupMetadata) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) groupMetadata)).intValue();
            }
            if (groupMetadata != null) {
                return this.gPos - groupMetadata.gPos;
            }
            throw new IllegalArgumentException();
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    protected class MyDataSetObserver extends DataSetObserver {
        static IPatchRedirector $redirector_;

        protected MyDataSetObserver() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ExpandableListConnector.this);
            }
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ExpandableListConnector.this.refreshExpGroupMetadataList(true, true);
                ExpandableListConnector.this.notifyDataSetChanged();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                ExpandableListConnector.this.refreshExpGroupMetadataList(true, true);
                ExpandableListConnector.this.notifyDataSetInvalidated();
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class PositionMetadata {
        static IPatchRedirector $redirector_ = null;
        private static final int MAX_POOL_SIZE = 5;
        private static ArrayList<PositionMetadata> sPool;
        public int groupInsertIndex;
        public GroupMetadata groupMetadata;
        public ExpandableListPosition position;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38392);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 4)) {
                redirector.redirect((short) 4);
            } else {
                sPool = new ArrayList<>(5);
            }
        }

        PositionMetadata() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private static PositionMetadata getRecycledOrCreate() {
            synchronized (sPool) {
                if (sPool.size() > 0) {
                    PositionMetadata remove = sPool.remove(0);
                    remove.resetState();
                    return remove;
                }
                return new PositionMetadata();
            }
        }

        static PositionMetadata obtain(int i3, int i16, int i17, int i18, GroupMetadata groupMetadata, int i19) {
            PositionMetadata recycledOrCreate = getRecycledOrCreate();
            recycledOrCreate.position = ExpandableListPosition.obtain(i16, i17, i18, i3);
            recycledOrCreate.groupMetadata = groupMetadata;
            recycledOrCreate.groupInsertIndex = i19;
            return recycledOrCreate;
        }

        private void resetState() {
            this.position = null;
            this.groupMetadata = null;
            this.groupInsertIndex = 0;
        }

        public boolean isExpanded() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            if (this.groupMetadata != null) {
                return true;
            }
            return false;
        }

        public void recycle() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            synchronized (sPool) {
                if (sPool.size() < 5) {
                    sPool.add(this);
                }
            }
        }
    }

    public ExpandableListConnector(ExpandableListAdapter expandableListAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) expandableListAdapter);
            return;
        }
        this.mMaxExpGroupCount = Integer.MAX_VALUE;
        this.mDataSetObserver = new MyDataSetObserver();
        this.mExpGroupMetadataList = new ArrayList<>();
        setExpandableListAdapter(expandableListAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshExpGroupMetadataList(boolean z16, boolean z17) {
        int childrenCount;
        ArrayList<GroupMetadata> arrayList = this.mExpGroupMetadataList;
        int size = arrayList.size();
        int i3 = 0;
        this.mTotalExpChildrenCount = 0;
        if (z17) {
            boolean z18 = false;
            for (int i16 = size - 1; i16 >= 0; i16--) {
                GroupMetadata groupMetadata = arrayList.get(i16);
                int findGroupPosition = findGroupPosition(groupMetadata.gId, groupMetadata.gPos);
                if (findGroupPosition != groupMetadata.gPos) {
                    if (findGroupPosition == -1) {
                        arrayList.remove(i16);
                        size--;
                    }
                    groupMetadata.gPos = findGroupPosition;
                    if (!z18) {
                        z18 = true;
                    }
                }
            }
            if (z18) {
                Collections.sort(arrayList);
            }
        }
        int i17 = 0;
        int i18 = 0;
        while (i3 < size) {
            GroupMetadata groupMetadata2 = arrayList.get(i3);
            int i19 = groupMetadata2.lastChildFlPos;
            if (i19 != -1 && !z16) {
                childrenCount = i19 - groupMetadata2.flPos;
            } else {
                childrenCount = this.mExpandableListAdapter.getChildrenCount(groupMetadata2.gPos);
            }
            this.mTotalExpChildrenCount += childrenCount;
            int i26 = groupMetadata2.gPos;
            int i27 = i17 + (i26 - i18);
            groupMetadata2.flPos = i27;
            i17 = i27 + childrenCount;
            groupMetadata2.lastChildFlPos = i17;
            i3++;
            i18 = i26;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.mExpandableListAdapter.areAllItemsEnabled();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean collapseGroup(int i3) {
        PositionMetadata flattenedPos = getFlattenedPos(ExpandableListPosition.obtain(2, i3, -1, -1));
        if (flattenedPos == null) {
            return false;
        }
        boolean collapseGroup = collapseGroup(flattenedPos);
        flattenedPos.recycle();
        return collapseGroup;
    }

    boolean expandGroup(int i3) {
        PositionMetadata flattenedPos = getFlattenedPos(ExpandableListPosition.obtain(2, i3, -1, -1));
        boolean expandGroup = expandGroup(flattenedPos);
        flattenedPos.recycle();
        return expandGroup;
    }

    int findGroupPosition(long j3, int i3) {
        boolean z16;
        boolean z17;
        int groupCount = this.mExpandableListAdapter.getGroupCount();
        if (groupCount == 0 || j3 == Long.MIN_VALUE) {
            return -1;
        }
        int i16 = groupCount - 1;
        int min = Math.min(i16, Math.max(0, i3));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        ExpandableListAdapter adapter = getAdapter();
        if (adapter == null) {
            return -1;
        }
        int i17 = min;
        int i18 = i17;
        boolean z18 = false;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (adapter.getGroupId(min) == j3) {
                return min;
            }
            if (i17 == i16) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (i18 == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z16 && z17) {
                break;
            }
            if (!z17 && (!z18 || z16)) {
                if (z16 || (!z18 && !z17)) {
                    i18--;
                    z18 = true;
                    min = i18;
                }
            } else {
                i17++;
                z18 = false;
                min = i17;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExpandableListAdapter getAdapter() {
        return this.mExpandableListAdapter;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.mExpandableListAdapter.getGroupCount() + this.mTotalExpChildrenCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> getExpandedGroupMetadataList() {
        return this.mExpGroupMetadataList;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Filter) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        ExpandableListAdapter adapter = getAdapter();
        if (adapter instanceof Filterable) {
            return ((Filterable) adapter).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PositionMetadata getFlattenedPos(ExpandableListPosition expandableListPosition) {
        ArrayList<GroupMetadata> arrayList = this.mExpGroupMetadataList;
        int size = arrayList.size();
        int i3 = size - 1;
        if (size == 0) {
            int i16 = expandableListPosition.groupPos;
            return PositionMetadata.obtain(i16, expandableListPosition.type, i16, expandableListPosition.childPos, null, 0);
        }
        int i17 = 0;
        int i18 = 0;
        while (i18 <= i3) {
            i17 = ((i3 - i18) / 2) + i18;
            GroupMetadata groupMetadata = arrayList.get(i17);
            int i19 = expandableListPosition.groupPos;
            int i26 = groupMetadata.gPos;
            if (i19 > i26) {
                i18 = i17 + 1;
            } else if (i19 < i26) {
                i3 = i17 - 1;
            } else if (i19 == i26) {
                int i27 = expandableListPosition.type;
                if (i27 == 2) {
                    return PositionMetadata.obtain(groupMetadata.flPos, i27, i19, expandableListPosition.childPos, groupMetadata, i17);
                }
                if (i27 != 1) {
                    return null;
                }
                int i28 = groupMetadata.flPos;
                int i29 = expandableListPosition.childPos;
                return PositionMetadata.obtain(i28 + i29 + 1, i27, i19, i29, groupMetadata, i17);
            }
        }
        if (expandableListPosition.type != 2) {
            return null;
        }
        if (i18 > i17) {
            GroupMetadata groupMetadata2 = arrayList.get(i18 - 1);
            int i36 = groupMetadata2.lastChildFlPos;
            int i37 = expandableListPosition.groupPos;
            return PositionMetadata.obtain(i36 + (i37 - groupMetadata2.gPos), expandableListPosition.type, i37, expandableListPosition.childPos, null, i18);
        }
        if (i3 >= i17) {
            return null;
        }
        int i38 = 1 + i3;
        GroupMetadata groupMetadata3 = arrayList.get(i38);
        int i39 = groupMetadata3.flPos;
        int i46 = groupMetadata3.gPos;
        int i47 = expandableListPosition.groupPos;
        return PositionMetadata.obtain(i39 - (i46 - i47), expandableListPosition.type, i47, expandableListPosition.childPos, null, i38);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        Object child;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
        PositionMetadata unflattenedPos = getUnflattenedPos(i3);
        ExpandableListPosition expandableListPosition = unflattenedPos.position;
        int i16 = expandableListPosition.type;
        if (i16 == 2) {
            child = this.mExpandableListAdapter.getGroup(expandableListPosition.groupPos);
        } else if (i16 == 1) {
            child = this.mExpandableListAdapter.getChild(expandableListPosition.groupPos, expandableListPosition.childPos);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        unflattenedPos.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        long combinedChildId;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this, i3)).longValue();
        }
        PositionMetadata unflattenedPos = getUnflattenedPos(i3);
        long groupId = this.mExpandableListAdapter.getGroupId(unflattenedPos.position.groupPos);
        ExpandableListPosition expandableListPosition = unflattenedPos.position;
        int i16 = expandableListPosition.type;
        if (i16 == 2) {
            combinedChildId = this.mExpandableListAdapter.getCombinedGroupId(groupId);
        } else if (i16 == 1) {
            combinedChildId = this.mExpandableListAdapter.getCombinedChildId(groupId, this.mExpandableListAdapter.getChildId(expandableListPosition.groupPos, expandableListPosition.childPos));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        unflattenedPos.recycle();
        return combinedChildId;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    @TargetApi(8)
    public int getItemViewType(int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, i3)).intValue();
        }
        ExpandableListPosition expandableListPosition = getUnflattenedPos(i3).position;
        if (VersionUtils.isrFroyo()) {
            ExpandableListAdapter expandableListAdapter = this.mExpandableListAdapter;
            if (expandableListAdapter instanceof HeterogeneousExpandableList) {
                HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) expandableListAdapter;
                if (expandableListPosition.type == 2) {
                    i16 = heterogeneousExpandableList.getGroupType(expandableListPosition.groupPos);
                } else {
                    i16 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(expandableListPosition.groupPos, expandableListPosition.childPos);
                }
                expandableListPosition.recycle();
                return i16;
            }
        }
        if (expandableListPosition.type == 2) {
            i16 = 0;
        } else {
            i16 = 1;
        }
        expandableListPosition.recycle();
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PositionMetadata getUnflattenedPos(int i3) {
        int i16;
        ArrayList<GroupMetadata> arrayList = this.mExpGroupMetadataList;
        int size = arrayList.size();
        int i17 = size - 1;
        if (size == 0) {
            return PositionMetadata.obtain(i3, 2, i3, -1, null, 0);
        }
        int i18 = 0;
        int i19 = i17;
        int i26 = 0;
        while (i18 <= i19) {
            int i27 = ((i19 - i18) / 2) + i18;
            GroupMetadata groupMetadata = arrayList.get(i27);
            int i28 = groupMetadata.lastChildFlPos;
            if (i3 > i28) {
                i18 = i27 + 1;
            } else {
                int i29 = groupMetadata.flPos;
                if (i3 < i29) {
                    i19 = i27 - 1;
                } else {
                    if (i3 == i29) {
                        return PositionMetadata.obtain(i3, 2, groupMetadata.gPos, -1, groupMetadata, i27);
                    }
                    if (i3 <= i28) {
                        return PositionMetadata.obtain(i3, 1, groupMetadata.gPos, i3 - (i29 + 1), groupMetadata, i27);
                    }
                }
            }
            i26 = i27;
        }
        if (i18 > i26) {
            GroupMetadata groupMetadata2 = arrayList.get(i18 - 1);
            i16 = (i3 - groupMetadata2.lastChildFlPos) + groupMetadata2.gPos;
        } else if (i19 < i26) {
            i18 = i19 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i18);
            i16 = groupMetadata3.gPos - (groupMetadata3.flPos - i3);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return PositionMetadata.obtain(i3, 2, i16, -1, null, i18);
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        boolean z16;
        View childView;
        View view2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            view2 = (View) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), view, viewGroup);
        } else {
            PositionMetadata unflattenedPos = getUnflattenedPos(i3);
            ExpandableListPosition expandableListPosition = unflattenedPos.position;
            int i16 = expandableListPosition.type;
            if (i16 == 2) {
                childView = this.mExpandableListAdapter.getGroupView(expandableListPosition.groupPos, unflattenedPos.isExpanded(), view, viewGroup);
            } else if (i16 == 1) {
                if (unflattenedPos.groupMetadata.lastChildFlPos == i3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                childView = this.mExpandableListAdapter.getChildView(expandableListPosition.groupPos, expandableListPosition.childPos, z16, view, viewGroup);
            } else {
                throw new RuntimeException("Flat list position is of unknown type");
            }
            unflattenedPos.recycle();
            view2 = childView;
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    @TargetApi(8)
    public int getViewTypeCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        if (VersionUtils.isrFroyo()) {
            ExpandableListAdapter expandableListAdapter = this.mExpandableListAdapter;
            if (expandableListAdapter instanceof HeterogeneousExpandableList) {
                HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) expandableListAdapter;
                return heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildTypeCount();
            }
            return 2;
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.mExpandableListAdapter.hasStableIds();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        ExpandableListAdapter adapter = getAdapter();
        if (adapter != null) {
            return adapter.isEmpty();
        }
        return true;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, i3)).booleanValue();
        }
        ExpandableListPosition expandableListPosition = getUnflattenedPos(i3).position;
        boolean z16 = true;
        if (expandableListPosition.type == 1) {
            z16 = this.mExpandableListAdapter.isChildSelectable(expandableListPosition.groupPos, expandableListPosition.childPos);
        }
        expandableListPosition.recycle();
        return z16;
    }

    public boolean isGroupExpanded(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, i3)).booleanValue();
        }
        for (int size = this.mExpGroupMetadataList.size() - 1; size >= 0; size--) {
            if (this.mExpGroupMetadataList.get(size).gPos == i3) {
                return true;
            }
        }
        return false;
    }

    public void setExpandableListAdapter(ExpandableListAdapter expandableListAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) expandableListAdapter);
            return;
        }
        ExpandableListAdapter expandableListAdapter2 = this.mExpandableListAdapter;
        if (expandableListAdapter2 != null) {
            expandableListAdapter2.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.mExpandableListAdapter = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setExpandedGroupMetadataList(ArrayList<GroupMetadata> arrayList) {
        ExpandableListAdapter expandableListAdapter;
        if (arrayList != null && (expandableListAdapter = this.mExpandableListAdapter) != null) {
            int groupCount = expandableListAdapter.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).gPos >= groupCount) {
                    return;
                }
            }
            this.mExpGroupMetadataList = arrayList;
            refreshExpGroupMetadataList(true, false);
        }
    }

    public void setMaxExpGroupCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            this.mMaxExpGroupCount = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean collapseGroup(PositionMetadata positionMetadata) {
        GroupMetadata groupMetadata = positionMetadata.groupMetadata;
        if (groupMetadata == null) {
            return false;
        }
        this.mExpGroupMetadataList.remove(groupMetadata);
        refreshExpGroupMetadataList(false, false);
        notifyDataSetChanged();
        this.mExpandableListAdapter.onGroupCollapsed(positionMetadata.groupMetadata.gPos);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean expandGroup(PositionMetadata positionMetadata) {
        if (positionMetadata.position.groupPos >= 0) {
            if (this.mMaxExpGroupCount == 0 || positionMetadata.groupMetadata != null) {
                return false;
            }
            if (this.mExpGroupMetadataList.size() >= this.mMaxExpGroupCount) {
                GroupMetadata groupMetadata = this.mExpGroupMetadataList.get(0);
                int indexOf = this.mExpGroupMetadataList.indexOf(groupMetadata);
                collapseGroup(groupMetadata.gPos);
                int i3 = positionMetadata.groupInsertIndex;
                if (i3 > indexOf) {
                    positionMetadata.groupInsertIndex = i3 - 1;
                }
            }
            int i16 = positionMetadata.position.groupPos;
            GroupMetadata obtain = GroupMetadata.obtain(-1, -1, i16, this.mExpandableListAdapter.getGroupId(i16));
            this.mExpGroupMetadataList.add(positionMetadata.groupInsertIndex, obtain);
            refreshExpGroupMetadataList(false, false);
            notifyDataSetChanged();
            this.mExpandableListAdapter.onGroupExpanded(obtain.gPos);
            return true;
        }
        throw new RuntimeException("Need group");
    }
}
