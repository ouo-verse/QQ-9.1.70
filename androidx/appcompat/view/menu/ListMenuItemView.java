package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewCompat;
import com.tencent.mobileqq.R;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements MenuView.ItemView, AbsListView.SelectionBoundsAdjuster {
    private static final String TAG = "ListMenuItemView";
    private Drawable mBackground;
    private CheckBox mCheckBox;
    private LinearLayout mContent;
    private boolean mForceShowIcon;
    private ImageView mGroupDivider;
    private boolean mHasListDivider;
    private ImageView mIconView;
    private LayoutInflater mInflater;
    private MenuItemImpl mItemData;
    private boolean mPreserveIconSpacing;
    private RadioButton mRadioButton;
    private TextView mShortcutView;
    private Drawable mSubMenuArrow;
    private ImageView mSubMenuArrowView;
    private int mTextAppearance;
    private Context mTextAppearanceContext;
    private TextView mTitleView;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.ark);
    }

    private void addContentView(View view) {
        addContentView(view, -1);
    }

    private LayoutInflater getInflater() {
        if (this.mInflater == null) {
            this.mInflater = LayoutInflater.from(getContext());
        }
        return this.mInflater;
    }

    private void insertCheckBox() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.dpe, (ViewGroup) this, false);
        this.mCheckBox = checkBox;
        addContentView(checkBox);
    }

    private void insertIconView() {
        ImageView imageView = (ImageView) getInflater().inflate(R.layout.dpf, (ViewGroup) this, false);
        this.mIconView = imageView;
        addContentView(imageView, 0);
    }

    private void insertRadioButton() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.dph, (ViewGroup) this, false);
        this.mRadioButton = radioButton;
        addContentView(radioButton);
    }

    private void setSubMenuArrowVisible(boolean z16) {
        int i3;
        ImageView imageView = this.mSubMenuArrowView;
        if (imageView != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            imageView.setVisibility(i3);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.mGroupDivider;
        if (imageView != null && imageView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mGroupDivider.getLayoutParams();
            rect.top += this.mGroupDivider.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.mItemData;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(MenuItemImpl menuItemImpl, int i3) {
        int i16;
        this.mItemData = menuItemImpl;
        if (menuItemImpl.isVisible()) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        setVisibility(i16);
        setTitle(menuItemImpl.getTitleForItemView(this));
        setCheckable(menuItemImpl.isCheckable());
        setShortcut(menuItemImpl.shouldShowShortcut(), menuItemImpl.getShortcut());
        setIcon(menuItemImpl.getIcon());
        setEnabled(menuItemImpl.isEnabled());
        setSubMenuArrowVisible(menuItemImpl.hasSubMenu());
        setContentDescription(menuItemImpl.getContentDescription());
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        ViewCompat.setBackground(this, this.mBackground);
        TextView textView = (TextView) findViewById(R.id.title);
        this.mTitleView = textView;
        int i3 = this.mTextAppearance;
        if (i3 != -1) {
            textView.setTextAppearance(this.mTextAppearanceContext, i3);
        }
        this.mShortcutView = (TextView) findViewById(R.id.f84774n6);
        ImageView imageView = (ImageView) findViewById(R.id.f9035529);
        this.mSubMenuArrowView = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.mSubMenuArrow);
        }
        this.mGroupDivider = (ImageView) findViewById(R.id.vtn);
        this.mContent = (LinearLayout) findViewById(R.id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        if (this.mIconView != null && this.mPreserveIconSpacing) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mIconView.getLayoutParams();
            int i17 = layoutParams.height;
            if (i17 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i17;
            }
        }
        super.onMeasure(i3, i16);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean z16) {
        CompoundButton compoundButton;
        View view;
        if (!z16 && this.mRadioButton == null && this.mCheckBox == null) {
            return;
        }
        if (this.mItemData.isExclusiveCheckable()) {
            if (this.mRadioButton == null) {
                insertRadioButton();
            }
            compoundButton = this.mRadioButton;
            view = this.mCheckBox;
        } else {
            if (this.mCheckBox == null) {
                insertCheckBox();
            }
            compoundButton = this.mCheckBox;
            view = this.mRadioButton;
        }
        if (z16) {
            compoundButton.setChecked(this.mItemData.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view != null && view.getVisibility() != 8) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        CheckBox checkBox = this.mCheckBox;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.mRadioButton;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean z16) {
        CompoundButton compoundButton;
        if (this.mItemData.isExclusiveCheckable()) {
            if (this.mRadioButton == null) {
                insertRadioButton();
            }
            compoundButton = this.mRadioButton;
        } else {
            if (this.mCheckBox == null) {
                insertCheckBox();
            }
            compoundButton = this.mCheckBox;
        }
        compoundButton.setChecked(z16);
    }

    public void setForceShowIcon(boolean z16) {
        this.mForceShowIcon = z16;
        this.mPreserveIconSpacing = z16;
    }

    public void setGroupDividerEnabled(boolean z16) {
        int i3;
        ImageView imageView = this.mGroupDivider;
        if (imageView != null) {
            if (!this.mHasListDivider && z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            imageView.setVisibility(i3);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(Drawable drawable) {
        boolean z16;
        if (!this.mItemData.shouldShowIcon() && !this.mForceShowIcon) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && !this.mPreserveIconSpacing) {
            return;
        }
        ImageView imageView = this.mIconView;
        if (imageView == null && drawable == null && !this.mPreserveIconSpacing) {
            return;
        }
        if (imageView == null) {
            insertIconView();
        }
        if (drawable == null && !this.mPreserveIconSpacing) {
            this.mIconView.setVisibility(8);
            return;
        }
        ImageView imageView2 = this.mIconView;
        if (!z16) {
            drawable = null;
        }
        imageView2.setImageDrawable(drawable);
        if (this.mIconView.getVisibility() != 0) {
            this.mIconView.setVisibility(0);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean z16, char c16) {
        int i3;
        if (z16 && this.mItemData.shouldShowShortcut()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        if (i3 == 0) {
            this.mShortcutView.setText(this.mItemData.getShortcutLabel());
        }
        if (this.mShortcutView.getVisibility() != i3) {
            this.mShortcutView.setVisibility(i3);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.mTitleView.setText(charSequence);
            if (this.mTitleView.getVisibility() != 0) {
                this.mTitleView.setVisibility(0);
                return;
            }
            return;
        }
        if (this.mTitleView.getVisibility() != 8) {
            this.mTitleView.setVisibility(8);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return this.mForceShowIcon;
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getContext(), attributeSet, androidx.appcompat.R.styleable.MenuView, i3, 0);
        this.mBackground = obtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.MenuView_android_itemBackground);
        this.mTextAppearance = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.MenuView_android_itemTextAppearance, -1);
        this.mPreserveIconSpacing = obtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.MenuView_preserveIconSpacing, false);
        this.mTextAppearanceContext = context;
        this.mSubMenuArrow = obtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.MenuView_subMenuArrow);
        TypedArray obtainStyledAttributes2 = context.getTheme().obtainStyledAttributes(null, new int[]{android.R.attr.divider}, R.attr.f155566ad0, 0);
        this.mHasListDivider = obtainStyledAttributes2.hasValue(0);
        obtainStyledAttributes.recycle();
        obtainStyledAttributes2.recycle();
    }

    private void addContentView(View view, int i3) {
        LinearLayout linearLayout = this.mContent;
        if (linearLayout != null) {
            linearLayout.addView(view, i3);
        } else {
            addView(view, i3);
        }
    }
}
