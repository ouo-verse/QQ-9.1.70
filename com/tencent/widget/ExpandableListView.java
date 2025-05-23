package com.tencent.widget;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ListAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ExpandableListConnector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ExpandableListView extends ListView {
    static IPatchRedirector $redirector_ = null;
    public static final int CHILD_INDICATOR_INHERIT = -1;
    private static final int[] CHILD_LAST_STATE_SET;
    private static final int[] EMPTY_STATE_SET;
    private static final int EXPANDABLELISTVIEW_CHILDDIVIDER;
    private static final int EXPANDABLELISTVIEW_CHILDINDICATOR;
    private static final int EXPANDABLELISTVIEW_CHILDINDICATORLEFT;
    private static final int EXPANDABLELISTVIEW_CHILDINDICATORRIGHT;
    private static final int EXPANDABLELISTVIEW_GROUPINDICATOR;
    private static final int EXPANDABLELISTVIEW_INDICATORLEFT;
    private static final int EXPANDABLELISTVIEW_INDICATORRIGHT;
    private static final int[] GROUP_EMPTY_STATE_SET;
    private static final int[] GROUP_EXPANDED_EMPTY_STATE_SET;
    private static final int[] GROUP_EXPANDED_STATE_SET;
    private static final int[][] GROUP_STATE_SETS;
    private static final long PACKED_POSITION_INT_MASK_CHILD = -1;
    private static final long PACKED_POSITION_INT_MASK_GROUP = 2147483647L;
    private static final long PACKED_POSITION_MASK_CHILD = 4294967295L;
    private static final long PACKED_POSITION_MASK_GROUP = 9223372032559808512L;
    private static final long PACKED_POSITION_MASK_TYPE = Long.MIN_VALUE;
    private static final long PACKED_POSITION_SHIFT_GROUP = 32;
    private static final long PACKED_POSITION_SHIFT_TYPE = 63;
    public static final int PACKED_POSITION_TYPE_CHILD = 1;
    public static final int PACKED_POSITION_TYPE_GROUP = 0;
    public static final int PACKED_POSITION_TYPE_NULL = 2;
    public static final long PACKED_POSITION_VALUE_NULL = 4294967295L;
    private ExpandableListAdapter mAdapter;
    private Drawable mChildDivider;
    private Drawable mChildIndicator;
    private int mChildIndicatorLeft;
    private int mChildIndicatorRight;
    private ExpandableListConnector mConnector;
    private Drawable mGroupIndicator;
    private int mIndicatorLeft;
    private final Rect mIndicatorRect;
    private int mIndicatorRight;
    private boolean mIsDrawIndicator;
    private OnChildClickListener mOnChildClickListener;
    private OnGroupClickListener mOnGroupClickListener;
    private OnGroupCollapseListener mOnGroupCollapseListener;
    private OnGroupExpandListener mOnGroupExpandListener;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class ExpandableListContextMenuInfo implements ContextMenu.ContextMenuInfo {
        static IPatchRedirector $redirector_;

        /* renamed from: id, reason: collision with root package name */
        public long f384546id;
        public long packedPosition;
        public View targetView;

        public ExpandableListContextMenuInfo(View view, long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, view, Long.valueOf(j3), Long.valueOf(j16));
                return;
            }
            this.targetView = view;
            this.packedPosition = j3;
            this.f384546id = j16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnChildClickListener {
        boolean onChildClick(ExpandableListView expandableListView, View view, int i3, int i16, long j3);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnGroupClickListener {
        boolean onGroupClick(ExpandableListView expandableListView, View view, int i3, long j3);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnGroupCollapseListener {
        void onGroupCollapse(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnGroupExpandListener {
        void onGroupExpand(int i3);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38479);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 34)) {
            redirector.redirect((short) 34);
            return;
        }
        EXPANDABLELISTVIEW_CHILDDIVIDER = AdapterView.getStyleableValue("ExpandableListView_childDivider");
        EXPANDABLELISTVIEW_CHILDINDICATORRIGHT = AdapterView.getStyleableValue("ExpandableListView_childIndicatorRight");
        EXPANDABLELISTVIEW_CHILDINDICATORLEFT = AdapterView.getStyleableValue("ExpandableListView_childIndicatorLeft");
        EXPANDABLELISTVIEW_INDICATORRIGHT = AdapterView.getStyleableValue("ExpandableListView_indicatorRight");
        EXPANDABLELISTVIEW_INDICATORLEFT = AdapterView.getStyleableValue("ExpandableListView_indicatorLeft");
        EXPANDABLELISTVIEW_CHILDINDICATOR = AdapterView.getStyleableValue("ExpandableListView_childIndicator");
        EXPANDABLELISTVIEW_GROUPINDICATOR = AdapterView.getStyleableValue("ExpandableListView_groupIndicator");
        int[] iArr = new int[0];
        EMPTY_STATE_SET = iArr;
        int[] iArr2 = {R.attr.state_expanded};
        GROUP_EXPANDED_STATE_SET = iArr2;
        int[] iArr3 = {R.attr.state_empty};
        GROUP_EMPTY_STATE_SET = iArr3;
        int[] iArr4 = {R.attr.state_expanded, R.attr.state_empty};
        GROUP_EXPANDED_EMPTY_STATE_SET = iArr4;
        GROUP_STATE_SETS = new int[][]{iArr, iArr2, iArr3, iArr4};
        CHILD_LAST_STATE_SET = new int[]{R.attr.state_last};
    }

    public ExpandableListView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private int getAbsoluteFlatPosition(int i3) {
        return i3 + getHeaderViewsCount();
    }

    private long getChildOrGroupId(ExpandableListPosition expandableListPosition) {
        if (expandableListPosition.type == 1) {
            return this.mAdapter.getChildId(expandableListPosition.groupPos, expandableListPosition.childPos);
        }
        return this.mAdapter.getGroupId(expandableListPosition.groupPos);
    }

    private int getFlatPositionForConnector(int i3) {
        return i3 - getHeaderViewsCount();
    }

    private Drawable getIndicator(ExpandableListConnector.PositionMetadata positionMetadata) {
        Drawable drawable;
        int[] iArr;
        boolean z16;
        if (!this.mIsDrawIndicator) {
            return null;
        }
        int i3 = 2;
        if (positionMetadata.position.type == 2) {
            drawable = this.mGroupIndicator;
            if (drawable != null && drawable.isStateful()) {
                ExpandableListConnector.GroupMetadata groupMetadata = positionMetadata.groupMetadata;
                if (groupMetadata != null && groupMetadata.lastChildFlPos != groupMetadata.flPos) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                boolean isExpanded = positionMetadata.isExpanded();
                if (!z16) {
                    i3 = 0;
                }
                drawable.setState(GROUP_STATE_SETS[(isExpanded ? 1 : 0) | i3]);
            }
        } else {
            drawable = this.mChildIndicator;
            if (drawable != null && drawable.isStateful()) {
                if (positionMetadata.position.flatListPos == positionMetadata.groupMetadata.lastChildFlPos) {
                    iArr = CHILD_LAST_STATE_SET;
                } else {
                    iArr = EMPTY_STATE_SET;
                }
                drawable.setState(iArr);
            }
        }
        return drawable;
    }

    public static int getPackedPositionChild(long j3) {
        if (j3 == 4294967295L || (j3 & Long.MIN_VALUE) != Long.MIN_VALUE) {
            return -1;
        }
        return (int) (j3 & 4294967295L);
    }

    public static long getPackedPositionForChild(int i3, int i16) {
        return (i16 & (-1)) | ((i3 & 2147483647L) << 32) | Long.MIN_VALUE;
    }

    public static long getPackedPositionForGroup(int i3) {
        return (i3 & 2147483647L) << 32;
    }

    public static int getPackedPositionGroup(long j3) {
        if (j3 == 4294967295L) {
            return -1;
        }
        return (int) ((j3 & PACKED_POSITION_MASK_GROUP) >> 32);
    }

    public static int getPackedPositionType(long j3) {
        if (j3 == 4294967295L) {
            return 2;
        }
        if ((j3 & Long.MIN_VALUE) == Long.MIN_VALUE) {
            return 1;
        }
        return 0;
    }

    private boolean isHeaderOrFooterPosition(int i3) {
        int footerViewsCount = this.mItemCount - getFooterViewsCount();
        if (i3 >= getHeaderViewsCount() && i3 < footerViewsCount) {
            return false;
        }
        return true;
    }

    public boolean collapseGroup(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, i3)).booleanValue();
        }
        boolean collapseGroup = this.mConnector.collapseGroup(i3);
        OnGroupCollapseListener onGroupCollapseListener = this.mOnGroupCollapseListener;
        if (onGroupCollapseListener != null) {
            onGroupCollapseListener.onGroupCollapse(i3);
        }
        return collapseGroup;
    }

    @Override // com.tencent.widget.AbsListView
    ContextMenu.ContextMenuInfo createContextMenuInfo(View view, int i3, long j3) {
        if (isHeaderOrFooterPosition(i3)) {
            return new AdapterView.AdapterContextMenuInfo(view, i3, j3);
        }
        ExpandableListConnector.PositionMetadata unflattenedPos = this.mConnector.getUnflattenedPos(getFlatPositionForConnector(i3));
        ExpandableListPosition expandableListPosition = unflattenedPos.position;
        unflattenedPos.recycle();
        long childOrGroupId = getChildOrGroupId(expandableListPosition);
        long packedPosition = expandableListPosition.getPackedPosition();
        expandableListPosition.recycle();
        return new ExpandableListContextMenuInfo(view, packedPosition, childOrGroupId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas);
            return;
        }
        super.dispatchDraw(canvas);
        if (this.mChildIndicator == null && this.mGroupIndicator == null) {
            return;
        }
        boolean hasBooleanFlag = hasBooleanFlag(34);
        int i16 = 0;
        if (hasBooleanFlag) {
            i3 = canvas.save();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            canvas.clipRect(getPaddingLeft() + scrollX, getPaddingTop() + scrollY, ((scrollX + getRight()) - getLeft()) - getPaddingRight(), ((scrollY + getBottom()) - getTop()) - getPaddingBottom());
        } else {
            i3 = 0;
        }
        int headerViewsCount = getHeaderViewsCount();
        int i17 = 1;
        int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
        int bottom = getBottom();
        Rect rect = this.mIndicatorRect;
        int childCount = getChildCount();
        int i18 = this.mFirstPosition - headerViewsCount;
        int i19 = -4;
        while (i16 < childCount) {
            if (i18 >= 0) {
                if (i18 > footerViewsCount) {
                    break;
                }
                View childAt = getChildAt(i16);
                int top = childAt.getTop();
                int bottom2 = childAt.getBottom();
                if (bottom2 >= 0 && top <= bottom) {
                    ExpandableListConnector.PositionMetadata unflattenedPos = this.mConnector.getUnflattenedPos(i18);
                    int i26 = unflattenedPos.position.type;
                    if (i26 != i19) {
                        if (i26 == i17) {
                            int i27 = this.mChildIndicatorLeft;
                            if (i27 == -1) {
                                i27 = this.mIndicatorLeft;
                            }
                            rect.left = i27;
                            int i28 = this.mChildIndicatorRight;
                            if (i28 == -1) {
                                i28 = this.mIndicatorRight;
                            }
                            rect.right = i28;
                        } else {
                            rect.left = this.mIndicatorLeft;
                            rect.right = this.mIndicatorRight;
                        }
                        rect.left += getPaddingLeft();
                        rect.right += getPaddingLeft();
                        i19 = unflattenedPos.position.type;
                    }
                    if (rect.left != rect.right) {
                        if (this.mStackFromBottom) {
                            rect.top = top;
                            rect.bottom = bottom2;
                        } else {
                            rect.top = top;
                            rect.bottom = bottom2;
                        }
                        Drawable indicator = getIndicator(unflattenedPos);
                        if (indicator != null) {
                            indicator.setBounds(rect);
                            indicator.draw(canvas);
                        }
                    }
                    unflattenedPos.recycle();
                }
            }
            i16++;
            i18++;
            i17 = 1;
        }
        if (hasBooleanFlag) {
            canvas.restoreToCount(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0022, code lost:
    
        if (r1.lastChildFlPos != r1.flPos) goto L12;
     */
    @Override // com.tencent.widget.ListView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void drawDivider(Canvas canvas, Rect rect, int i3) {
        int i16 = i3 + this.mFirstPosition;
        if (i16 >= 0) {
            ExpandableListConnector.PositionMetadata unflattenedPos = this.mConnector.getUnflattenedPos(getFlatPositionForConnector(i16));
            if (unflattenedPos.position.type != 1) {
                if (unflattenedPos.isExpanded()) {
                    ExpandableListConnector.GroupMetadata groupMetadata = unflattenedPos.groupMetadata;
                }
                unflattenedPos.recycle();
            }
            Drawable drawable = this.mChildDivider;
            if (drawable != null) {
                drawable.setBounds(rect);
                drawable.draw(canvas);
            }
            unflattenedPos.recycle();
            return;
        }
        super.drawDivider(canvas, rect, i16);
    }

    public boolean expandGroup(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) ? expandGroup(i3, false) : ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, i3)).booleanValue();
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (ExpandableListAdapter) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.mAdapter;
    }

    public long getExpandableListPosition(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Long) iPatchRedirector.redirect((short) 20, (Object) this, i3)).longValue();
        }
        if (isHeaderOrFooterPosition(i3)) {
            return 4294967295L;
        }
        ExpandableListConnector.PositionMetadata unflattenedPos = this.mConnector.getUnflattenedPos(getFlatPositionForConnector(i3));
        long packedPosition = unflattenedPos.position.getPackedPosition();
        unflattenedPos.recycle();
        return packedPosition;
    }

    public int getFlatListPosition(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this, j3)).intValue();
        }
        ExpandableListPosition obtainPosition = ExpandableListPosition.obtainPosition(j3);
        if (obtainPosition == null) {
            return -1;
        }
        ExpandableListConnector.PositionMetadata flattenedPos = this.mConnector.getFlattenedPos(obtainPosition);
        int i3 = flattenedPos.position.flatListPos;
        flattenedPos.recycle();
        return getAbsoluteFlatPosition(i3);
    }

    public long getSelectedId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Long) iPatchRedirector.redirect((short) 23, (Object) this)).longValue();
        }
        long selectedPosition = getSelectedPosition();
        if (selectedPosition == 4294967295L) {
            return -1L;
        }
        int packedPositionGroup = getPackedPositionGroup(selectedPosition);
        if (getPackedPositionType(selectedPosition) == 0) {
            return this.mAdapter.getGroupId(packedPositionGroup);
        }
        return this.mAdapter.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public long getSelectedPosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Long) iPatchRedirector.redirect((short) 22, (Object) this)).longValue();
        }
        return getExpandableListPosition(getSelectedItemPosition());
    }

    boolean handleItemClick(View view, int i3, long j3) {
        ExpandableListConnector.PositionMetadata unflattenedPos = this.mConnector.getUnflattenedPos(i3);
        long childOrGroupId = getChildOrGroupId(unflattenedPos.position);
        ExpandableListPosition expandableListPosition = unflattenedPos.position;
        boolean z16 = false;
        if (expandableListPosition.type == 2) {
            OnGroupClickListener onGroupClickListener = this.mOnGroupClickListener;
            if (onGroupClickListener != null && onGroupClickListener.onGroupClick(this, view, expandableListPosition.groupPos, childOrGroupId)) {
                unflattenedPos.recycle();
                return true;
            }
            if (unflattenedPos.isExpanded()) {
                this.mConnector.collapseGroup(unflattenedPos);
                playSoundEffect(0);
                OnGroupCollapseListener onGroupCollapseListener = this.mOnGroupCollapseListener;
                if (onGroupCollapseListener != null) {
                    onGroupCollapseListener.onGroupCollapse(unflattenedPos.position.groupPos);
                }
            } else {
                this.mConnector.expandGroup(unflattenedPos);
                playSoundEffect(0);
                OnGroupExpandListener onGroupExpandListener = this.mOnGroupExpandListener;
                if (onGroupExpandListener != null) {
                    onGroupExpandListener.onGroupExpand(unflattenedPos.position.groupPos);
                }
                ExpandableListPosition expandableListPosition2 = unflattenedPos.position;
                int i16 = expandableListPosition2.groupPos;
                int headerViewsCount = expandableListPosition2.flatListPos + getHeaderViewsCount();
                smoothScrollToPosition(this.mAdapter.getChildrenCount(i16) + headerViewsCount, headerViewsCount);
            }
            z16 = true;
        } else if (this.mOnChildClickListener != null) {
            playSoundEffect(0);
            OnChildClickListener onChildClickListener = this.mOnChildClickListener;
            ExpandableListPosition expandableListPosition3 = unflattenedPos.position;
            return onChildClickListener.onChildClick(this, view, expandableListPosition3.groupPos, expandableListPosition3.childPos, childOrGroupId);
        }
        unflattenedPos.recycle();
        return z16;
    }

    public boolean isGroupExpanded(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this, i3)).booleanValue();
        }
        return this.mConnector.isGroupExpanded(i3);
    }

    @Override // com.tencent.widget.AbsListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ArrayList<ExpandableListConnector.GroupMetadata> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) parcelable);
            return;
        }
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.superState);
        ExpandableListConnector expandableListConnector = this.mConnector;
        if (expandableListConnector != null && (arrayList = savedState.expandedGroupMetadataList) != null) {
            expandableListConnector.setExpandedGroupMetadataList(arrayList);
        }
    }

    @Override // com.tencent.widget.AbsListView, android.view.View
    public Parcelable onSaveInstanceState() {
        ArrayList<ExpandableListConnector.GroupMetadata> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (Parcelable) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        ExpandableListConnector expandableListConnector = this.mConnector;
        if (expandableListConnector != null) {
            arrayList = expandableListConnector.getExpandedGroupMetadataList();
        } else {
            arrayList = null;
        }
        return new SavedState(onSaveInstanceState, arrayList);
    }

    @Override // com.tencent.widget.AbsListView, com.tencent.widget.AdapterView
    public boolean performItemClick(View view, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, this, view, Integer.valueOf(i3), Long.valueOf(j3))).booleanValue();
        }
        if (isHeaderOrFooterPosition(i3)) {
            return super.performItemClick(view, i3, j3);
        }
        return handleItemClick(view, getFlatPositionForConnector(i3), j3);
    }

    public void setChildDivider(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) drawable);
        } else {
            this.mChildDivider = drawable;
        }
    }

    public void setChildIndicator(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) drawable);
        } else {
            this.mChildIndicator = drawable;
        }
    }

    public void setChildIndicatorBounds(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.mChildIndicatorLeft = i3;
            this.mChildIndicatorRight = i16;
        }
    }

    public void setGroupIndicator(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) drawable);
            return;
        }
        this.mGroupIndicator = drawable;
        if (this.mIndicatorRight == 0 && drawable != null) {
            this.mIndicatorRight = this.mIndicatorLeft + drawable.getIntrinsicWidth();
        }
    }

    public void setIndicatorBounds(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.mIndicatorLeft = i3;
            this.mIndicatorRight = i16;
        }
    }

    public void setIsDrawIndicator(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.mIsDrawIndicator = z16;
        }
    }

    public void setOnChildClickListener(OnChildClickListener onChildClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) onChildClickListener);
        } else {
            this.mOnChildClickListener = onChildClickListener;
        }
    }

    public void setOnGroupClickListener(OnGroupClickListener onGroupClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) onGroupClickListener);
        } else {
            this.mOnGroupClickListener = onGroupClickListener;
        }
    }

    public void setOnGroupCollapseListener(OnGroupCollapseListener onGroupCollapseListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) onGroupCollapseListener);
        } else {
            this.mOnGroupCollapseListener = onGroupCollapseListener;
        }
    }

    public void setOnGroupExpandListener(OnGroupExpandListener onGroupExpandListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) onGroupExpandListener);
        } else {
            this.mOnGroupExpandListener = onGroupExpandListener;
        }
    }

    @Override // com.tencent.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) onItemClickListener);
        } else {
            super.setOnItemClickListener(onItemClickListener);
        }
    }

    public boolean setSelectedChild(int i3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16))).booleanValue();
        }
        ExpandableListPosition obtainChildPosition = ExpandableListPosition.obtainChildPosition(i3, i16);
        ExpandableListConnector.PositionMetadata flattenedPos = this.mConnector.getFlattenedPos(obtainChildPosition);
        if (flattenedPos == null) {
            if (!z16) {
                return false;
            }
            expandGroup(i3);
            flattenedPos = this.mConnector.getFlattenedPos(obtainChildPosition);
            if (flattenedPos == null) {
                throw new IllegalStateException("Could not find child");
            }
        }
        super.setSelection(getAbsoluteFlatPosition(flattenedPos.position.flatListPos));
        obtainChildPosition.recycle();
        flattenedPos.recycle();
        return true;
    }

    public void setSelectedGroup(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, i3);
            return;
        }
        ExpandableListPosition obtainGroupPosition = ExpandableListPosition.obtainGroupPosition(i3);
        ExpandableListConnector.PositionMetadata flattenedPos = this.mConnector.getFlattenedPos(obtainGroupPosition);
        obtainGroupPosition.recycle();
        super.setSelection(getAbsoluteFlatPosition(flattenedPos.position.flatListPos));
        flattenedPos.recycle();
    }

    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView
    public void smoothScrollToPosition(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, i3);
            return;
        }
        ExpandableListPosition obtainGroupPosition = ExpandableListPosition.obtainGroupPosition(i3);
        ExpandableListConnector.PositionMetadata flattenedPos = this.mConnector.getFlattenedPos(obtainGroupPosition);
        obtainGroupPosition.recycle();
        int headerViewsCount = flattenedPos.position.flatListPos + getHeaderViewsCount();
        smoothScrollToPosition(this.mAdapter.getChildrenCount(i3) + headerViewsCount, headerViewsCount);
        flattenedPos.recycle();
    }

    public ExpandableListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.expandableListViewStyle);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public boolean expandGroup(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Boolean.valueOf(z16))).booleanValue();
        }
        ExpandableListConnector.PositionMetadata flattenedPos = this.mConnector.getFlattenedPos(ExpandableListPosition.obtain(2, i3, -1, -1));
        boolean expandGroup = this.mConnector.expandGroup(flattenedPos);
        OnGroupExpandListener onGroupExpandListener = this.mOnGroupExpandListener;
        if (onGroupExpandListener != null) {
            onGroupExpandListener.onGroupExpand(i3);
        }
        if (z16) {
            int headerViewsCount = flattenedPos.position.flatListPos + getHeaderViewsCount();
            smoothScrollToPosition(this.mAdapter.getChildrenCount(i3) + headerViewsCount, headerViewsCount);
        }
        flattenedPos.recycle();
        return expandGroup;
    }

    @Override // com.tencent.widget.ListView, com.tencent.widget.AdapterView
    public ListAdapter getAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? super.getAdapter() : (ListAdapter) iPatchRedirector.redirect((short) 8, (Object) this);
    }

    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, com.tencent.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            throw new RuntimeException("For ExpandableListView, use setAdapter(ExpandableListAdapter) instead of setAdapter(ListAdapter)");
        }
        iPatchRedirector.redirect((short) 7, (Object) this, (Object) listAdapter);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class SavedState extends View.BaseSavedState {
        static IPatchRedirector $redirector_;
        public static final Parcelable.Creator<SavedState> CREATOR;
        ArrayList<ExpandableListConnector.GroupMetadata> expandedGroupMetadataList;
        private Parcelable superState;

        /* compiled from: P */
        /* loaded from: classes27.dex */
        class a implements Parcelable.Creator<SavedState> {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (SavedState) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (SavedState[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
                return new SavedState[i3];
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38468);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 4)) {
                redirector.redirect((short) 4);
            } else {
                CREATOR = new a();
            }
        }

        SavedState(Parcelable parcelable, ArrayList<ExpandableListConnector.GroupMetadata> arrayList) {
            super(View.BaseSavedState.EMPTY_STATE);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) parcelable, (Object) arrayList);
            } else {
                this.expandedGroupMetadataList = arrayList;
                this.superState = parcelable;
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel, i3);
                return;
            }
            super.writeToParcel(parcel, i3);
            parcel.writeParcelable(this.superState, i3);
            parcel.writeList(this.expandedGroupMetadataList);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                return;
            }
            this.superState = parcel.readParcelable(getClass().getClassLoader());
            ArrayList<ExpandableListConnector.GroupMetadata> arrayList = new ArrayList<>();
            this.expandedGroupMetadataList = arrayList;
            parcel.readList(arrayList, ExpandableListConnector.class.getClassLoader());
        }
    }

    public ExpandableListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mIndicatorRect = new Rect();
        this.mIsDrawIndicator = true;
        TypedArrayWarpper typedArrayWarpper = new TypedArrayWarpper(context.obtainStyledAttributes(attributeSet, AdapterView.getStyleableValues("ExpandableListView"), i3, 0));
        this.mGroupIndicator = typedArrayWarpper.getDrawable(EXPANDABLELISTVIEW_GROUPINDICATOR);
        this.mChildIndicator = typedArrayWarpper.getDrawable(EXPANDABLELISTVIEW_CHILDINDICATOR);
        this.mIndicatorLeft = typedArrayWarpper.getDimensionPixelSize(EXPANDABLELISTVIEW_INDICATORLEFT, 0);
        int dimensionPixelSize = typedArrayWarpper.getDimensionPixelSize(EXPANDABLELISTVIEW_INDICATORRIGHT, 0);
        this.mIndicatorRight = dimensionPixelSize;
        if (dimensionPixelSize == 0 && (drawable = this.mGroupIndicator) != null) {
            this.mIndicatorRight = this.mIndicatorLeft + drawable.getIntrinsicWidth();
        }
        this.mChildIndicatorLeft = typedArrayWarpper.getDimensionPixelSize(EXPANDABLELISTVIEW_CHILDINDICATORLEFT, -1);
        this.mChildIndicatorRight = typedArrayWarpper.getDimensionPixelSize(EXPANDABLELISTVIEW_CHILDINDICATORRIGHT, -1);
        this.mChildDivider = typedArrayWarpper.getDrawable(EXPANDABLELISTVIEW_CHILDDIVIDER);
        typedArrayWarpper.recycle();
    }

    public void setAdapter(ExpandableListAdapter expandableListAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) expandableListAdapter);
            return;
        }
        this.mAdapter = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.mConnector = new ExpandableListConnector(expandableListAdapter);
        } else {
            this.mConnector = null;
        }
        super.setAdapter((ListAdapter) this.mConnector);
    }
}
