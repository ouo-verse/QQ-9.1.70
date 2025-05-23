package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class ConstraintHelper extends View {
    protected int mCount;
    protected Helper mHelperWidget;
    protected int[] mIds;
    private HashMap<Integer, String> mMap;
    protected String mReferenceIds;
    protected String mReferenceTags;
    protected boolean mUseViewMeasure;
    private View[] mViews;
    protected Context myContext;

    public ConstraintHelper(Context context) {
        super(context);
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new HashMap<>();
        this.myContext = context;
        init(null);
    }

    private void addID(String str) {
        if (str == null || str.length() == 0 || this.myContext == null) {
            return;
        }
        String trim = str.trim();
        if (getParent() instanceof ConstraintLayout) {
        }
        int findId = findId(trim);
        if (findId != 0) {
            this.mMap.put(Integer.valueOf(findId), trim);
            addRscID(findId);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
    }

    private void addRscID(int i3) {
        if (i3 == getId()) {
            return;
        }
        int i16 = this.mCount + 1;
        int[] iArr = this.mIds;
        if (i16 > iArr.length) {
            this.mIds = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.mIds;
        int i17 = this.mCount;
        iArr2[i17] = i3;
        this.mCount = i17 + 1;
    }

    private void addTag(String str) {
        ConstraintLayout constraintLayout;
        if (str == null || str.length() == 0 || this.myContext == null) {
            return;
        }
        String trim = str.trim();
        if (getParent() instanceof ConstraintLayout) {
            constraintLayout = (ConstraintLayout) getParent();
        } else {
            constraintLayout = null;
        }
        if (constraintLayout == null) {
            Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
            return;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = constraintLayout.getChildAt(i3);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof ConstraintLayout.LayoutParams) && trim.equals(((ConstraintLayout.LayoutParams) layoutParams).constraintTag)) {
                if (childAt.getId() == -1) {
                    Log.w("ConstraintHelper", "to use ConstraintTag view " + childAt.getClass().getSimpleName() + " must have an ID");
                } else {
                    addRscID(childAt.getId());
                }
            }
        }
    }

    private int[] convertReferenceString(View view, String str) {
        String[] split = str.split(",");
        view.getContext();
        int[] iArr = new int[split.length];
        int i3 = 0;
        for (String str2 : split) {
            int findId = findId(str2.trim());
            if (findId != 0) {
                iArr[i3] = findId;
                i3++;
            }
        }
        if (i3 != split.length) {
            return Arrays.copyOf(iArr, i3);
        }
        return iArr;
    }

    private int findId(String str) {
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int i3 = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object designInformation = constraintLayout.getDesignInformation(0, str);
            if (designInformation instanceof Integer) {
                i3 = ((Integer) designInformation).intValue();
            }
        }
        if (i3 == 0 && constraintLayout != null) {
            i3 = findId(constraintLayout, str);
        }
        if (i3 == 0) {
            try {
                i3 = R.id.class.getField(str).getInt(null);
            } catch (Exception unused) {
            }
        }
        return i3 == 0 ? this.myContext.getResources().getIdentifier(str, "id", this.myContext.getPackageName()) : i3;
    }

    public void addView(View view) {
        if (view == this) {
            return;
        }
        if (view.getId() == -1) {
            Log.e("ConstraintHelper", "Views added to a ConstraintHelper need to have an id");
        } else {
            if (view.getParent() == null) {
                Log.e("ConstraintHelper", "Views added to a ConstraintHelper need to have a parent");
                return;
            }
            this.mReferenceIds = null;
            addRscID(view.getId());
            requestLayout();
        }
    }

    protected void applyLayoutFeatures(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i3 = 0; i3 < this.mCount; i3++) {
            View viewById = constraintLayout.getViewById(this.mIds[i3]);
            if (viewById != null) {
                viewById.setVisibility(visibility);
                if (elevation > 0.0f) {
                    viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                }
            }
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.mIds, this.mCount);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View[] getViews(ConstraintLayout constraintLayout) {
        View[] viewArr = this.mViews;
        if (viewArr == null || viewArr.length != this.mCount) {
            this.mViews = new View[this.mCount];
        }
        for (int i3 = 0; i3 < this.mCount; i3++) {
            this.mViews[i3] = constraintLayout.getViewById(this.mIds[i3]);
        }
        return this.mViews;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == R.styleable.ConstraintLayout_Layout_constraint_referenced_ids) {
                    String string = obtainStyledAttributes.getString(index);
                    this.mReferenceIds = string;
                    setIds(string);
                } else if (index == R.styleable.ConstraintLayout_Layout_constraint_referenced_tags) {
                    String string2 = obtainStyledAttributes.getString(index);
                    this.mReferenceTags = string2;
                    setReferenceTags(string2);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void loadParameters(ConstraintSet.Constraint constraint, HelperWidget helperWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        ConstraintSet.Layout layout = constraint.layout;
        int[] iArr = layout.mReferenceIds;
        if (iArr != null) {
            setReferencedIds(iArr);
        } else {
            String str = layout.mReferenceIdString;
            if (str != null && str.length() > 0) {
                ConstraintSet.Layout layout2 = constraint.layout;
                layout2.mReferenceIds = convertReferenceString(this, layout2.mReferenceIdString);
            }
        }
        helperWidget.removeAllIds();
        if (constraint.layout.mReferenceIds != null) {
            int i3 = 0;
            while (true) {
                int[] iArr2 = constraint.layout.mReferenceIds;
                if (i3 < iArr2.length) {
                    ConstraintWidget constraintWidget = sparseArray.get(iArr2[i3]);
                    if (constraintWidget != null) {
                        helperWidget.add(constraintWidget);
                    }
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.mReferenceIds;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.mReferenceTags;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        if (this.mUseViewMeasure) {
            super.onMeasure(i3, i16);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void removeView(View view) {
        int i3;
        int id5 = view.getId();
        if (id5 == -1) {
            return;
        }
        this.mReferenceIds = null;
        int i16 = 0;
        while (true) {
            if (i16 >= this.mCount) {
                break;
            }
            if (this.mIds[i16] == id5) {
                while (true) {
                    i3 = this.mCount;
                    if (i16 >= i3 - 1) {
                        break;
                    }
                    int[] iArr = this.mIds;
                    int i17 = i16 + 1;
                    iArr[i16] = iArr[i17];
                    i16 = i17;
                }
                this.mIds[i3 - 1] = 0;
                this.mCount = i3 - 1;
            } else {
                i16++;
            }
        }
        requestLayout();
    }

    protected void setIds(String str) {
        this.mReferenceIds = str;
        if (str == null) {
            return;
        }
        int i3 = 0;
        this.mCount = 0;
        while (true) {
            int indexOf = str.indexOf(44, i3);
            if (indexOf == -1) {
                addID(str.substring(i3));
                return;
            } else {
                addID(str.substring(i3, indexOf));
                i3 = indexOf + 1;
            }
        }
    }

    protected void setReferenceTags(String str) {
        this.mReferenceTags = str;
        if (str == null) {
            return;
        }
        int i3 = 0;
        this.mCount = 0;
        while (true) {
            int indexOf = str.indexOf(44, i3);
            if (indexOf == -1) {
                addTag(str.substring(i3));
                return;
            } else {
                addTag(str.substring(i3, indexOf));
                i3 = indexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.mReferenceIds = null;
        this.mCount = 0;
        for (int i3 : iArr) {
            addRscID(i3);
        }
    }

    @Override // android.view.View
    public void setTag(int i3, Object obj) {
        super.setTag(i3, obj);
        if (obj == null && this.mReferenceIds == null) {
            addRscID(i3);
        }
    }

    public void updatePreLayout(ConstraintLayout constraintLayout) {
        String str;
        int findId;
        if (isInEditMode()) {
            setIds(this.mReferenceIds);
        }
        Helper helper = this.mHelperWidget;
        if (helper == null) {
            return;
        }
        helper.removeAllIds();
        for (int i3 = 0; i3 < this.mCount; i3++) {
            int i16 = this.mIds[i3];
            View viewById = constraintLayout.getViewById(i16);
            if (viewById == null && (findId = findId(constraintLayout, (str = this.mMap.get(Integer.valueOf(i16))))) != 0) {
                this.mIds[i3] = findId;
                this.mMap.put(Integer.valueOf(findId), str);
                viewById = constraintLayout.getViewById(findId);
            }
            if (viewById != null) {
                this.mHelperWidget.add(constraintLayout.getViewWidget(viewById));
            }
        }
        this.mHelperWidget.updateConstraints(constraintLayout.mLayoutWidget);
    }

    public void validateParams() {
        if (this.mHelperWidget == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            ((ConstraintLayout.LayoutParams) layoutParams).widget = (ConstraintWidget) this.mHelperWidget;
        }
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new HashMap<>();
        this.myContext = context;
        init(attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applyLayoutFeatures() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        applyLayoutFeatures((ConstraintLayout) parent);
    }

    private int findId(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        String str2;
        if (str == null || constraintLayout == null || (resources = this.myContext.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = constraintLayout.getChildAt(i3);
            if (childAt.getId() != -1) {
                try {
                    str2 = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                    str2 = null;
                }
                if (str.equals(str2)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mIds = new int[32];
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = new HashMap<>();
        this.myContext = context;
        init(attributeSet);
    }

    public void updatePreLayout(ConstraintWidgetContainer constraintWidgetContainer, Helper helper, SparseArray<ConstraintWidget> sparseArray) {
        helper.removeAllIds();
        for (int i3 = 0; i3 < this.mCount; i3++) {
            helper.add(sparseArray.get(this.mIds[i3]));
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    public void updatePostConstraints(ConstraintLayout constraintLayout) {
    }

    public void updatePostLayout(ConstraintLayout constraintLayout) {
    }

    public void updatePostMeasure(ConstraintLayout constraintLayout) {
    }

    public void updatePreDraw(ConstraintLayout constraintLayout) {
    }

    public void resolveRtl(ConstraintWidget constraintWidget, boolean z16) {
    }
}
