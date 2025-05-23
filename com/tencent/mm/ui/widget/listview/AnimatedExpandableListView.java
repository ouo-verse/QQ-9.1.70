package com.tencent.mm.ui.widget.listview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class AnimatedExpandableListView extends ExpandableListView {

    /* renamed from: b, reason: collision with root package name */
    public static final String f153342b = AnimatedExpandableListAdapter.class.getSimpleName();

    /* renamed from: a, reason: collision with root package name */
    public AnimatedExpandableListAdapter f153343a;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static abstract class AnimatedExpandableListAdapter extends BaseExpandableListAdapter {

        /* renamed from: a, reason: collision with root package name */
        public SparseArray f153344a = new SparseArray();

        /* renamed from: b, reason: collision with root package name */
        public AnimatedExpandableListView f153345b;

        @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
        public final int getChildType(int i3, int i16) {
            if (a(i3).f153362a) {
                return 0;
            }
            return getRealChildType(i3, i16) + 1;
        }

        @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
        public final int getChildTypeCount() {
            return getRealChildTypeCount() + 1;
        }

        @Override // android.widget.ExpandableListAdapter
        public final View getChildView(final int i3, int i16, boolean z16, View view, ViewGroup viewGroup) {
            int i17;
            int i18;
            int intValue;
            boolean z17;
            final GroupInfo a16 = a(i3);
            if (a16.f153362a) {
                View view2 = view;
                boolean z18 = false;
                if (!(view2 instanceof DummyView)) {
                    view2 = new DummyView(viewGroup.getContext());
                    view2.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
                }
                View view3 = view2;
                if (i16 < a16.f153364c) {
                    view3.getLayoutParams().height = 0;
                    return view3;
                }
                final ExpandableListView expandableListView = (ExpandableListView) viewGroup;
                final DummyView dummyView = (DummyView) view3;
                dummyView.clearViews();
                dummyView.a(expandableListView.getDivider(), viewGroup.getMeasuredWidth(), expandableListView.getDividerHeight());
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(viewGroup.getWidth(), 1073741824);
                int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
                int height = viewGroup.getHeight();
                int realChildrenCount = getRealChildrenCount(i3);
                int i19 = a16.f153364c;
                int i26 = 0;
                while (true) {
                    if (i19 < realChildrenCount) {
                        if (i19 == realChildrenCount - 1) {
                            z17 = true;
                        } else {
                            z17 = z18;
                        }
                        i17 = 1;
                        boolean z19 = z17;
                        int i27 = i19;
                        int i28 = realChildrenCount;
                        View realChildView = getRealChildView(i3, i19, z19, null, viewGroup);
                        realChildView.measure(makeMeasureSpec, makeMeasureSpec2);
                        int measuredHeight = i26 + realChildView.getMeasuredHeight();
                        if (measuredHeight < height) {
                            dummyView.addFakeView(realChildView);
                            i19 = i27 + 1;
                            i26 = measuredHeight;
                            realChildrenCount = i28;
                            z18 = false;
                        } else {
                            dummyView.addFakeView(realChildView);
                            i18 = measuredHeight + (((i28 - i27) - 1) * (measuredHeight / (i27 + 1)));
                            break;
                        }
                    } else {
                        i17 = 1;
                        i18 = i26;
                        break;
                    }
                }
                Object tag = dummyView.getTag();
                if (tag == null) {
                    intValue = 0;
                } else {
                    intValue = ((Integer) tag).intValue();
                }
                boolean z26 = a16.f153363b;
                if (z26 && intValue != i17) {
                    ExpandAnimation expandAnimation = new ExpandAnimation(dummyView, 0, i18, a16);
                    expandAnimation.setDuration(this.f153345b.getAnimationDuration());
                    expandAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.AnimatedExpandableListAdapter.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            AnimatedExpandableListAdapter.this.b(i3);
                            AnimatedExpandableListAdapter.this.notifyDataSetChanged();
                            dummyView.setTag(0);
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    dummyView.startAnimation(expandAnimation);
                    dummyView.setTag(Integer.valueOf(i17));
                } else if (!z26 && intValue != 2) {
                    if (a16.f153365d == -1) {
                        a16.f153365d = i18;
                    }
                    ExpandAnimation expandAnimation2 = new ExpandAnimation(dummyView, a16.f153365d, 0, a16);
                    expandAnimation2.setDuration(this.f153345b.getAnimationDuration());
                    expandAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.AnimatedExpandableListAdapter.2
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            AnimatedExpandableListAdapter.this.b(i3);
                            expandableListView.collapseGroup(i3);
                            AnimatedExpandableListAdapter.this.notifyDataSetChanged();
                            a16.f153365d = -1;
                            dummyView.setTag(0);
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    dummyView.startAnimation(expandAnimation2);
                    dummyView.setTag(2);
                }
                return view3;
            }
            return getRealChildView(i3, i16, z16, view, viewGroup);
        }

        @Override // android.widget.ExpandableListAdapter
        public final int getChildrenCount(int i3) {
            GroupInfo a16 = a(i3);
            if (a16.f153362a) {
                return a16.f153364c + 1;
            }
            return getRealChildrenCount(i3);
        }

        public int getRealChildType(int i3, int i16) {
            return 0;
        }

        public int getRealChildTypeCount() {
            return 1;
        }

        public abstract View getRealChildView(int i3, int i16, boolean z16, View view, ViewGroup viewGroup);

        public abstract int getRealChildrenCount(int i3);

        public void notifyGroupExpanded(int i3) {
            a(i3).f153365d = -1;
        }

        public final void b(int i3, int i16) {
            GroupInfo a16 = a(i3);
            a16.f153362a = true;
            a16.f153364c = i16;
            a16.f153363b = true;
        }

        public final void a(AnimatedExpandableListView animatedExpandableListView) {
            this.f153345b = animatedExpandableListView;
        }

        public final GroupInfo a(int i3) {
            GroupInfo groupInfo = (GroupInfo) this.f153344a.get(i3);
            if (groupInfo != null) {
                return groupInfo;
            }
            GroupInfo groupInfo2 = new GroupInfo();
            this.f153344a.put(i3, groupInfo2);
            return groupInfo2;
        }

        public final void b(int i3) {
            a(i3).f153362a = false;
        }

        public final void a(int i3, int i16) {
            GroupInfo a16 = a(i3);
            a16.f153362a = true;
            a16.f153364c = i16;
            a16.f153363b = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class DummyView extends View {

        /* renamed from: a, reason: collision with root package name */
        public List f153354a;

        /* renamed from: b, reason: collision with root package name */
        public Drawable f153355b;

        /* renamed from: c, reason: collision with root package name */
        public int f153356c;

        /* renamed from: d, reason: collision with root package name */
        public int f153357d;

        public void addFakeView(View view) {
            view.layout(0, 0, getWidth(), getHeight());
            this.f153354a.add(view);
        }

        public void clearViews() {
            this.f153354a.clear();
        }

        @Override // android.view.View
        public void dispatchDraw(Canvas canvas) {
            canvas.save();
            Drawable drawable = this.f153355b;
            if (drawable != null) {
                drawable.setBounds(0, 0, this.f153356c, this.f153357d);
            }
            int size = this.f153354a.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((View) this.f153354a.get(i3)).draw(canvas);
                canvas.translate(0.0f, r2.getMeasuredHeight());
                Drawable drawable2 = this.f153355b;
                if (drawable2 != null) {
                    drawable2.draw(canvas);
                    canvas.translate(0.0f, this.f153357d);
                }
            }
            canvas.restore();
        }

        @Override // android.view.View
        public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
            super.onLayout(z16, i3, i16, i17, i18);
            int size = this.f153354a.size();
            for (int i19 = 0; i19 < size; i19++) {
                ((View) this.f153354a.get(i19)).layout(i3, i16, i17, i18);
            }
        }

        DummyView(Context context) {
            super(context);
            this.f153354a = new ArrayList();
        }

        public final void a(Drawable drawable, int i3, int i16) {
            if (drawable != null) {
                this.f153355b = drawable;
                this.f153356c = i3;
                this.f153357d = i16;
                drawable.setBounds(0, 0, i3, i16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class ExpandAnimation extends Animation {

        /* renamed from: a, reason: collision with root package name */
        public int f153358a;

        /* renamed from: b, reason: collision with root package name */
        public int f153359b;

        /* renamed from: c, reason: collision with root package name */
        public View f153360c;

        /* renamed from: d, reason: collision with root package name */
        public GroupInfo f153361d;

        @Override // android.view.animation.Animation
        public void applyTransformation(float f16, Transformation transformation) {
            super.applyTransformation(f16, transformation);
            if (f16 < 1.0f) {
                int i3 = this.f153358a + ((int) (this.f153359b * f16));
                this.f153360c.getLayoutParams().height = i3;
                this.f153361d.f153365d = i3;
                this.f153360c.requestLayout();
                return;
            }
            int i16 = this.f153358a + this.f153359b;
            this.f153360c.getLayoutParams().height = i16;
            this.f153361d.f153365d = i16;
            this.f153360c.requestLayout();
        }

        ExpandAnimation(View view, int i3, int i16, GroupInfo groupInfo) {
            this.f153358a = i3;
            this.f153359b = i16 - i3;
            this.f153360c = view;
            this.f153361d = groupInfo;
            view.getLayoutParams().height = i3;
            this.f153360c.requestLayout();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class GroupInfo {

        /* renamed from: a, reason: collision with root package name */
        public boolean f153362a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f153363b;

        /* renamed from: c, reason: collision with root package name */
        public int f153364c;

        /* renamed from: d, reason: collision with root package name */
        public int f153365d;

        GroupInfo() {
            this.f153362a = false;
            this.f153363b = false;
            this.f153365d = -1;
        }
    }

    public AnimatedExpandableListView(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getAnimationDuration() {
        return 150;
    }

    public boolean collapseGroupWithAnimation(int i3) {
        int flatListPosition = getFlatListPosition(ExpandableListView.getPackedPositionForGroup(i3));
        if (flatListPosition != -1) {
            int firstVisiblePosition = flatListPosition - getFirstVisiblePosition();
            if (firstVisiblePosition >= 0 && firstVisiblePosition < getChildCount()) {
                if (getChildAt(firstVisiblePosition).getBottom() >= getBottom()) {
                    return collapseGroup(i3);
                }
            } else {
                return collapseGroup(i3);
            }
        }
        long expandableListPosition = getExpandableListPosition(getFirstVisiblePosition());
        int packedPositionChild = ExpandableListView.getPackedPositionChild(expandableListPosition);
        int packedPositionGroup = ExpandableListView.getPackedPositionGroup(expandableListPosition);
        if (packedPositionChild == -1 || packedPositionGroup != i3) {
            packedPositionChild = 0;
        }
        this.f153343a.a(i3, packedPositionChild);
        this.f153343a.notifyDataSetChanged();
        return isGroupExpanded(i3);
    }

    @SuppressLint({"NewApi"})
    public boolean expandGroupWithAnimation(int i3) {
        int firstVisiblePosition;
        int flatListPosition = getFlatListPosition(ExpandableListView.getPackedPositionForGroup(i3));
        if (flatListPosition == -1 || (firstVisiblePosition = flatListPosition - getFirstVisiblePosition()) >= getChildCount() || getChildAt(firstVisiblePosition).getBottom() < getBottom()) {
            this.f153343a.b(i3, 0);
            return expandGroup(i3);
        }
        this.f153343a.notifyGroupExpanded(i3);
        return expandGroup(i3);
    }

    @Override // android.widget.ExpandableListView
    public void setAdapter(ExpandableListAdapter expandableListAdapter) {
        super.setAdapter(expandableListAdapter);
        if (expandableListAdapter instanceof AnimatedExpandableListAdapter) {
            AnimatedExpandableListAdapter animatedExpandableListAdapter = (AnimatedExpandableListAdapter) expandableListAdapter;
            this.f153343a = animatedExpandableListAdapter;
            animatedExpandableListAdapter.a(this);
        } else {
            throw new ClassCastException(expandableListAdapter.toString() + " must implement AnimatedExpandableListAdapter");
        }
    }

    public AnimatedExpandableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AnimatedExpandableListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
