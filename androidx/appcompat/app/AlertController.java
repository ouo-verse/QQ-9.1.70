package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes.dex */
public class AlertController {
    ListAdapter mAdapter;
    private int mAlertDialogLayout;
    private final int mButtonIconDimen;
    Button mButtonNegative;
    private Drawable mButtonNegativeIcon;
    Message mButtonNegativeMessage;
    private CharSequence mButtonNegativeText;
    Button mButtonNeutral;
    private Drawable mButtonNeutralIcon;
    Message mButtonNeutralMessage;
    private CharSequence mButtonNeutralText;
    private int mButtonPanelSideLayout;
    Button mButtonPositive;
    private Drawable mButtonPositiveIcon;
    Message mButtonPositiveMessage;
    private CharSequence mButtonPositiveText;
    private final Context mContext;
    private View mCustomTitleView;
    final AppCompatDialog mDialog;
    Handler mHandler;
    private Drawable mIcon;
    private ImageView mIconView;
    int mListItemLayout;
    int mListLayout;
    ListView mListView;
    private CharSequence mMessage;
    private TextView mMessageView;
    int mMultiChoiceItemLayout;
    NestedScrollView mScrollView;
    private boolean mShowTitle;
    int mSingleChoiceItemLayout;
    private CharSequence mTitle;
    private TextView mTitleView;
    private View mView;
    private int mViewLayoutResId;
    private int mViewSpacingBottom;
    private int mViewSpacingLeft;
    private int mViewSpacingRight;
    private int mViewSpacingTop;
    private final Window mWindow;
    private boolean mViewSpacingSpecified = false;
    private int mIconId = 0;
    int mCheckedItem = -1;
    private int mButtonPanelLayoutHint = 0;
    private final View.OnClickListener mButtonHandler = new View.OnClickListener() { // from class: androidx.appcompat.app.AlertController.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message message;
            Message message2;
            Message message3;
            Message message4;
            EventCollector.getInstance().onViewClickedBefore(view);
            AlertController alertController = AlertController.this;
            if (view == alertController.mButtonPositive && (message4 = alertController.mButtonPositiveMessage) != null) {
                message = Message.obtain(message4);
            } else if (view == alertController.mButtonNegative && (message3 = alertController.mButtonNegativeMessage) != null) {
                message = Message.obtain(message3);
            } else if (view == alertController.mButtonNeutral && (message2 = alertController.mButtonNeutralMessage) != null) {
                message = Message.obtain(message2);
            } else {
                message = null;
            }
            if (message != null) {
                message.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.mHandler.obtainMessage(1, alertController2.mDialog).sendToTarget();
            EventCollector.getInstance().onViewClicked(view);
        }
    };

    /* compiled from: P */
    /* renamed from: androidx.appcompat.app.AlertController$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 implements NestedScrollView.OnScrollChangeListener {
        final /* synthetic */ View val$bottom;
        final /* synthetic */ View val$top;

        AnonymousClass2(View view, View view2) {
            this.val$top = view;
            this.val$bottom = view2;
        }

        @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
        public void onScrollChange(NestedScrollView nestedScrollView, int i3, int i16, int i17, int i18) {
            AlertController.manageScrollIndicators(nestedScrollView, this.val$top, this.val$bottom);
        }
    }

    /* compiled from: P */
    /* renamed from: androidx.appcompat.app.AlertController$3, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ View val$bottom;
        final /* synthetic */ View val$top;

        AnonymousClass3(View view, View view2) {
            this.val$top = view;
            this.val$bottom = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.manageScrollIndicators(AlertController.this.mScrollView, this.val$top, this.val$bottom);
        }
    }

    /* compiled from: P */
    /* renamed from: androidx.appcompat.app.AlertController$4, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass4 implements AbsListView.OnScrollListener {
        final /* synthetic */ View val$bottom;
        final /* synthetic */ View val$top;

        AnonymousClass4(View view, View view2) {
            this.val$top = view;
            this.val$bottom = view2;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
            AlertController.manageScrollIndicators(absListView, this.val$top, this.val$bottom);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            EventCollector.getInstance().onListScrollStateChanged(absListView, i3);
        }
    }

    /* compiled from: P */
    /* renamed from: androidx.appcompat.app.AlertController$5, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ View val$bottom;
        final /* synthetic */ View val$top;

        AnonymousClass5(View view, View view2) {
            this.val$top = view;
            this.val$bottom = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.manageScrollIndicators(AlertController.this.mListView, this.val$top, this.val$bottom);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class AlertParams {
        public ListAdapter mAdapter;
        public boolean[] mCheckedItems;
        public final Context mContext;
        public Cursor mCursor;
        public View mCustomTitleView;
        public boolean mForceInverseBackground;
        public Drawable mIcon;
        public final LayoutInflater mInflater;
        public String mIsCheckedColumn;
        public boolean mIsMultiChoice;
        public boolean mIsSingleChoice;
        public CharSequence[] mItems;
        public String mLabelColumn;
        public CharSequence mMessage;
        public Drawable mNegativeButtonIcon;
        public DialogInterface.OnClickListener mNegativeButtonListener;
        public CharSequence mNegativeButtonText;
        public Drawable mNeutralButtonIcon;
        public DialogInterface.OnClickListener mNeutralButtonListener;
        public CharSequence mNeutralButtonText;
        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnMultiChoiceClickListener mOnCheckboxClickListener;
        public DialogInterface.OnClickListener mOnClickListener;
        public DialogInterface.OnDismissListener mOnDismissListener;
        public AdapterView.OnItemSelectedListener mOnItemSelectedListener;
        public DialogInterface.OnKeyListener mOnKeyListener;
        public OnPrepareListViewListener mOnPrepareListViewListener;
        public Drawable mPositiveButtonIcon;
        public DialogInterface.OnClickListener mPositiveButtonListener;
        public CharSequence mPositiveButtonText;
        public CharSequence mTitle;
        public View mView;
        public int mViewLayoutResId;
        public int mViewSpacingBottom;
        public int mViewSpacingLeft;
        public int mViewSpacingRight;
        public int mViewSpacingTop;
        public int mIconId = 0;
        public int mIconAttrId = 0;
        public boolean mViewSpacingSpecified = false;
        public int mCheckedItem = -1;
        public boolean mRecycleOnMeasure = true;
        public boolean mCancelable = true;

        /* compiled from: P */
        /* loaded from: classes.dex */
        public interface OnPrepareListViewListener {
            void onPrepareListView(ListView listView);
        }

        public AlertParams(Context context) {
            this.mContext = context;
            this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        private void createListView(final AlertController alertController) {
            int i3;
            ListAdapter listAdapter;
            final RecycleListView recycleListView = (RecycleListView) this.mInflater.inflate(alertController.mListLayout, (ViewGroup) null);
            if (this.mIsMultiChoice) {
                if (this.mCursor == null) {
                    listAdapter = new ArrayAdapter<CharSequence>(this.mContext, alertController.mMultiChoiceItemLayout, R.id.text1, this.mItems) { // from class: androidx.appcompat.app.AlertController.AlertParams.1
                        @Override // android.widget.ArrayAdapter, android.widget.Adapter
                        public View getView(int i16, View view, ViewGroup viewGroup) {
                            View view2 = super.getView(i16, view, viewGroup);
                            boolean[] zArr = AlertParams.this.mCheckedItems;
                            if (zArr != null && zArr[i16]) {
                                recycleListView.setItemChecked(i16, true);
                            }
                            EventCollector.getInstance().onListGetView(i16, view, viewGroup, getItemId(i16));
                            return view2;
                        }
                    };
                } else {
                    listAdapter = new CursorAdapter(this.mContext, this.mCursor, false) { // from class: androidx.appcompat.app.AlertController.AlertParams.2
                        private final int mIsCheckedIndex;
                        private final int mLabelIndex;

                        {
                            Cursor cursor = getCursor();
                            this.mLabelIndex = cursor.getColumnIndexOrThrow(AlertParams.this.mLabelColumn);
                            this.mIsCheckedIndex = cursor.getColumnIndexOrThrow(AlertParams.this.mIsCheckedColumn);
                        }

                        @Override // android.widget.CursorAdapter
                        public void bindView(View view, Context context, Cursor cursor) {
                            ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor.getString(this.mLabelIndex));
                            RecycleListView recycleListView2 = recycleListView;
                            int position = cursor.getPosition();
                            boolean z16 = true;
                            if (cursor.getInt(this.mIsCheckedIndex) != 1) {
                                z16 = false;
                            }
                            recycleListView2.setItemChecked(position, z16);
                        }

                        @Override // android.widget.CursorAdapter
                        public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                            return AlertParams.this.mInflater.inflate(alertController.mMultiChoiceItemLayout, viewGroup, false);
                        }
                    };
                }
            } else {
                if (this.mIsSingleChoice) {
                    i3 = alertController.mSingleChoiceItemLayout;
                } else {
                    i3 = alertController.mListItemLayout;
                }
                int i16 = i3;
                if (this.mCursor != null) {
                    listAdapter = new SimpleCursorAdapter(this.mContext, i16, this.mCursor, new String[]{this.mLabelColumn}, new int[]{R.id.text1});
                } else {
                    listAdapter = this.mAdapter;
                    if (listAdapter == null) {
                        listAdapter = new CheckedItemAdapter(this.mContext, i16, R.id.text1, this.mItems);
                    }
                }
            }
            OnPrepareListViewListener onPrepareListViewListener = this.mOnPrepareListViewListener;
            if (onPrepareListViewListener != null) {
                onPrepareListViewListener.onPrepareListView(recycleListView);
            }
            alertController.mAdapter = listAdapter;
            alertController.mCheckedItem = this.mCheckedItem;
            if (this.mOnClickListener != null) {
                recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.app.AlertController.AlertParams.3
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i17, long j3) {
                        EventCollector.getInstance().onItemClickBefore(adapterView, view, i17, j3);
                        AlertParams.this.mOnClickListener.onClick(alertController.mDialog, i17);
                        if (!AlertParams.this.mIsSingleChoice) {
                            alertController.mDialog.dismiss();
                        }
                        EventCollector.getInstance().onItemClick(adapterView, view, i17, j3);
                    }
                });
            } else if (this.mOnCheckboxClickListener != null) {
                recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.app.AlertController.AlertParams.4
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(AdapterView<?> adapterView, View view, int i17, long j3) {
                        EventCollector.getInstance().onItemClickBefore(adapterView, view, i17, j3);
                        boolean[] zArr = AlertParams.this.mCheckedItems;
                        if (zArr != null) {
                            zArr[i17] = recycleListView.isItemChecked(i17);
                        }
                        AlertParams.this.mOnCheckboxClickListener.onClick(alertController.mDialog, i17, recycleListView.isItemChecked(i17));
                        EventCollector.getInstance().onItemClick(adapterView, view, i17, j3);
                    }
                });
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.mOnItemSelectedListener;
            if (onItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (this.mIsSingleChoice) {
                recycleListView.setChoiceMode(1);
            } else if (this.mIsMultiChoice) {
                recycleListView.setChoiceMode(2);
            }
            alertController.mListView = recycleListView;
        }

        public void apply(AlertController alertController) {
            View view = this.mCustomTitleView;
            if (view != null) {
                alertController.setCustomTitle(view);
            } else {
                CharSequence charSequence = this.mTitle;
                if (charSequence != null) {
                    alertController.setTitle(charSequence);
                }
                Drawable drawable = this.mIcon;
                if (drawable != null) {
                    alertController.setIcon(drawable);
                }
                int i3 = this.mIconId;
                if (i3 != 0) {
                    alertController.setIcon(i3);
                }
                int i16 = this.mIconAttrId;
                if (i16 != 0) {
                    alertController.setIcon(alertController.getIconAttributeResId(i16));
                }
            }
            CharSequence charSequence2 = this.mMessage;
            if (charSequence2 != null) {
                alertController.setMessage(charSequence2);
            }
            CharSequence charSequence3 = this.mPositiveButtonText;
            if (charSequence3 != null || this.mPositiveButtonIcon != null) {
                alertController.setButton(-1, charSequence3, this.mPositiveButtonListener, null, this.mPositiveButtonIcon);
            }
            CharSequence charSequence4 = this.mNegativeButtonText;
            if (charSequence4 != null || this.mNegativeButtonIcon != null) {
                alertController.setButton(-2, charSequence4, this.mNegativeButtonListener, null, this.mNegativeButtonIcon);
            }
            CharSequence charSequence5 = this.mNeutralButtonText;
            if (charSequence5 != null || this.mNeutralButtonIcon != null) {
                alertController.setButton(-3, charSequence5, this.mNeutralButtonListener, null, this.mNeutralButtonIcon);
            }
            if (this.mItems != null || this.mCursor != null || this.mAdapter != null) {
                createListView(alertController);
            }
            View view2 = this.mView;
            if (view2 != null) {
                if (this.mViewSpacingSpecified) {
                    alertController.setView(view2, this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
                    return;
                } else {
                    alertController.setView(view2);
                    return;
                }
            }
            int i17 = this.mViewLayoutResId;
            if (i17 != 0) {
                alertController.setView(i17);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static final class ButtonHandler extends Handler {
        private static final int MSG_DISMISS_DIALOG = 1;
        private WeakReference<DialogInterface> mDialog;

        public ButtonHandler(DialogInterface dialogInterface) {
            this.mDialog = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 != -3 && i3 != -2 && i3 != -1) {
                if (i3 == 1) {
                    ((DialogInterface) message.obj).dismiss();
                    return;
                }
                return;
            }
            ((DialogInterface.OnClickListener) message.obj).onClick(this.mDialog.get(), message.what);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class CheckedItemAdapter extends ArrayAdapter<CharSequence> {
        public CheckedItemAdapter(Context context, int i3, int i16, CharSequence[] charSequenceArr) {
            super(context, i3, i16, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class RecycleListView extends ListView {
        private final int mPaddingBottomNoButtons;
        private final int mPaddingTopNoTitle;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public void setHasDecor(boolean z16, boolean z17) {
            int i3;
            int i16;
            if (!z17 || !z16) {
                int paddingLeft = getPaddingLeft();
                if (z16) {
                    i3 = getPaddingTop();
                } else {
                    i3 = this.mPaddingTopNoTitle;
                }
                int paddingRight = getPaddingRight();
                if (z17) {
                    i16 = getPaddingBottom();
                } else {
                    i16 = this.mPaddingBottomNoButtons;
                }
                setPadding(paddingLeft, i3, paddingRight, i16);
            }
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.appcompat.R.styleable.RecycleListView);
            this.mPaddingBottomNoButtons = obtainStyledAttributes.getDimensionPixelOffset(androidx.appcompat.R.styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.mPaddingTopNoTitle = obtainStyledAttributes.getDimensionPixelOffset(androidx.appcompat.R.styleable.RecycleListView_paddingTopNoTitle, -1);
        }
    }

    public AlertController(Context context, AppCompatDialog appCompatDialog, Window window) {
        this.mContext = context;
        this.mDialog = appCompatDialog;
        this.mWindow = window;
        this.mHandler = new ButtonHandler(appCompatDialog);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, androidx.appcompat.R.styleable.AlertDialog, com.tencent.mobileqq.R.attr.f4807h, 0);
        this.mAlertDialogLayout = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AlertDialog_android_layout, 0);
        this.mButtonPanelSideLayout = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.mListLayout = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AlertDialog_listLayout, 0);
        this.mMultiChoiceItemLayout = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.mSingleChoiceItemLayout = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.mListItemLayout = obtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AlertDialog_listItemLayout, 0);
        this.mShowTitle = obtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AlertDialog_showTitle, true);
        this.mButtonIconDimen = obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.AlertDialog_buttonIconDimen, 0);
        obtainStyledAttributes.recycle();
        appCompatDialog.supportRequestWindowFeature(1);
    }

    static boolean canTextInput(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (canTextInput(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private void centerButton(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    static void manageScrollIndicators(View view, View view2, View view3) {
        int i3;
        int i16 = 0;
        if (view2 != null) {
            if (view.canScrollVertically(-1)) {
                i3 = 0;
            } else {
                i3 = 4;
            }
            view2.setVisibility(i3);
        }
        if (view3 != null) {
            if (!view.canScrollVertically(1)) {
                i16 = 4;
            }
            view3.setVisibility(i16);
        }
    }

    @Nullable
    private ViewGroup resolvePanel(@Nullable View view, @Nullable View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    private int selectContentView() {
        int i3 = this.mButtonPanelSideLayout;
        if (i3 == 0) {
            return this.mAlertDialogLayout;
        }
        if (this.mButtonPanelLayoutHint == 1) {
            return i3;
        }
        return this.mAlertDialogLayout;
    }

    private void setScrollIndicators(ViewGroup viewGroup, View view, int i3, int i16) {
        View findViewById = this.mWindow.findViewById(com.tencent.mobileqq.R.id.f80444bh);
        View findViewById2 = this.mWindow.findViewById(com.tencent.mobileqq.R.id.f80434bg);
        ViewCompat.setScrollIndicators(view, i3, i16);
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
        }
        if (findViewById2 != null) {
            viewGroup.removeView(findViewById2);
        }
    }

    private void setupButtons(ViewGroup viewGroup) {
        int i3;
        Button button = (Button) viewGroup.findViewById(R.id.button1);
        this.mButtonPositive = button;
        button.setOnClickListener(this.mButtonHandler);
        boolean z16 = true;
        if (TextUtils.isEmpty(this.mButtonPositiveText) && this.mButtonPositiveIcon == null) {
            this.mButtonPositive.setVisibility(8);
            i3 = 0;
        } else {
            this.mButtonPositive.setText(this.mButtonPositiveText);
            Drawable drawable = this.mButtonPositiveIcon;
            if (drawable != null) {
                int i16 = this.mButtonIconDimen;
                drawable.setBounds(0, 0, i16, i16);
                this.mButtonPositive.setCompoundDrawables(this.mButtonPositiveIcon, null, null, null);
            }
            this.mButtonPositive.setVisibility(0);
            i3 = 1;
        }
        Button button2 = (Button) viewGroup.findViewById(R.id.button2);
        this.mButtonNegative = button2;
        button2.setOnClickListener(this.mButtonHandler);
        if (TextUtils.isEmpty(this.mButtonNegativeText) && this.mButtonNegativeIcon == null) {
            this.mButtonNegative.setVisibility(8);
        } else {
            this.mButtonNegative.setText(this.mButtonNegativeText);
            Drawable drawable2 = this.mButtonNegativeIcon;
            if (drawable2 != null) {
                int i17 = this.mButtonIconDimen;
                drawable2.setBounds(0, 0, i17, i17);
                this.mButtonNegative.setCompoundDrawables(this.mButtonNegativeIcon, null, null, null);
            }
            this.mButtonNegative.setVisibility(0);
            i3 |= 2;
        }
        Button button3 = (Button) viewGroup.findViewById(R.id.button3);
        this.mButtonNeutral = button3;
        button3.setOnClickListener(this.mButtonHandler);
        if (TextUtils.isEmpty(this.mButtonNeutralText) && this.mButtonNeutralIcon == null) {
            this.mButtonNeutral.setVisibility(8);
        } else {
            this.mButtonNeutral.setText(this.mButtonNeutralText);
            Drawable drawable3 = this.mButtonNeutralIcon;
            if (drawable3 != null) {
                int i18 = this.mButtonIconDimen;
                drawable3.setBounds(0, 0, i18, i18);
                this.mButtonNeutral.setCompoundDrawables(this.mButtonNeutralIcon, null, null, null);
            }
            this.mButtonNeutral.setVisibility(0);
            i3 |= 4;
        }
        if (shouldCenterSingleButton(this.mContext)) {
            if (i3 == 1) {
                centerButton(this.mButtonPositive);
            } else if (i3 == 2) {
                centerButton(this.mButtonNegative);
            } else if (i3 == 4) {
                centerButton(this.mButtonNeutral);
            }
        }
        if (i3 == 0) {
            z16 = false;
        }
        if (!z16) {
            viewGroup.setVisibility(8);
        }
    }

    private void setupContent(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.mWindow.findViewById(com.tencent.mobileqq.R.id.ii_);
        this.mScrollView = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.mScrollView.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(R.id.message);
        this.mMessageView = textView;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.mMessage;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.mScrollView.removeView(this.mMessageView);
        if (this.mListView != null) {
            ViewGroup viewGroup2 = (ViewGroup) this.mScrollView.getParent();
            int indexOfChild = viewGroup2.indexOfChild(this.mScrollView);
            viewGroup2.removeViewAt(indexOfChild);
            viewGroup2.addView(this.mListView, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void setupCustomContent(ViewGroup viewGroup) {
        View view = this.mView;
        boolean z16 = false;
        if (view == null) {
            if (this.mViewLayoutResId != 0) {
                view = LayoutInflater.from(this.mContext).inflate(this.mViewLayoutResId, viewGroup, false);
            } else {
                view = null;
            }
        }
        if (view != null) {
            z16 = true;
        }
        if (!z16 || !canTextInput(view)) {
            this.mWindow.setFlags(131072, 131072);
        }
        if (z16) {
            FrameLayout frameLayout = (FrameLayout) this.mWindow.findViewById(com.tencent.mobileqq.R.id.ucn);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (this.mViewSpacingSpecified) {
                frameLayout.setPadding(this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
            }
            if (this.mListView != null) {
                ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void setupTitle(ViewGroup viewGroup) {
        if (this.mCustomTitleView != null) {
            viewGroup.addView(this.mCustomTitleView, 0, new ViewGroup.LayoutParams(-1, -2));
            this.mWindow.findViewById(com.tencent.mobileqq.R.id.f98895ob).setVisibility(8);
            return;
        }
        this.mIconView = (ImageView) this.mWindow.findViewById(R.id.icon);
        if ((!TextUtils.isEmpty(this.mTitle)) && this.mShowTitle) {
            TextView textView = (TextView) this.mWindow.findViewById(com.tencent.mobileqq.R.id.sle);
            this.mTitleView = textView;
            textView.setText(this.mTitle);
            int i3 = this.mIconId;
            if (i3 != 0) {
                this.mIconView.setImageResource(i3);
                return;
            }
            Drawable drawable = this.mIcon;
            if (drawable != null) {
                this.mIconView.setImageDrawable(drawable);
                return;
            } else {
                this.mTitleView.setPadding(this.mIconView.getPaddingLeft(), this.mIconView.getPaddingTop(), this.mIconView.getPaddingRight(), this.mIconView.getPaddingBottom());
                this.mIconView.setVisibility(8);
                return;
            }
        }
        this.mWindow.findViewById(com.tencent.mobileqq.R.id.f98895ob).setVisibility(8);
        this.mIconView.setVisibility(8);
        viewGroup.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setupView() {
        boolean z16;
        boolean z17;
        boolean z18;
        View findViewById;
        ListAdapter listAdapter;
        View findViewById2;
        View findViewById3;
        View findViewById4 = this.mWindow.findViewById(com.tencent.mobileqq.R.id.f224703t);
        View findViewById5 = findViewById4.findViewById(com.tencent.mobileqq.R.id.f99605q9);
        View findViewById6 = findViewById4.findViewById(com.tencent.mobileqq.R.id.b9q);
        View findViewById7 = findViewById4.findViewById(com.tencent.mobileqq.R.id.tiq);
        ViewGroup viewGroup = (ViewGroup) findViewById4.findViewById(com.tencent.mobileqq.R.id.uco);
        setupCustomContent(viewGroup);
        View findViewById8 = viewGroup.findViewById(com.tencent.mobileqq.R.id.f99605q9);
        View findViewById9 = viewGroup.findViewById(com.tencent.mobileqq.R.id.b9q);
        View findViewById10 = viewGroup.findViewById(com.tencent.mobileqq.R.id.tiq);
        ViewGroup resolvePanel = resolvePanel(findViewById8, findViewById5);
        ViewGroup resolvePanel2 = resolvePanel(findViewById9, findViewById6);
        ViewGroup resolvePanel3 = resolvePanel(findViewById10, findViewById7);
        setupContent(resolvePanel2);
        setupButtons(resolvePanel3);
        setupTitle(resolvePanel);
        int i3 = 0;
        if (viewGroup.getVisibility() != 8) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (resolvePanel != null && resolvePanel.getVisibility() != 8) {
            z17 = 1;
        } else {
            z17 = 0;
        }
        if (resolvePanel3 != null && resolvePanel3.getVisibility() != 8) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (!z18 && resolvePanel2 != null && (findViewById3 = resolvePanel2.findViewById(com.tencent.mobileqq.R.id.f94935dm)) != null) {
            findViewById3.setVisibility(0);
        }
        if (z17 != 0) {
            NestedScrollView nestedScrollView = this.mScrollView;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            if (this.mMessage == null && this.mListView == null) {
                findViewById2 = null;
            } else {
                findViewById2 = resolvePanel.findViewById(com.tencent.mobileqq.R.id.f98065m3);
            }
            if (findViewById2 != null) {
                findViewById2.setVisibility(0);
            }
        } else if (resolvePanel2 != null && (findViewById = resolvePanel2.findViewById(com.tencent.mobileqq.R.id.f94945dn)) != null) {
            findViewById.setVisibility(0);
        }
        ListView listView = this.mListView;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).setHasDecor(z17, z18);
        }
        if (!z16) {
            View view = this.mListView;
            if (view == null) {
                view = this.mScrollView;
            }
            if (view != null) {
                if (z18) {
                    i3 = 2;
                }
                setScrollIndicators(resolvePanel2, view, z17 | i3, 3);
            }
        }
        ListView listView2 = this.mListView;
        if (listView2 != null && (listAdapter = this.mAdapter) != null) {
            listView2.setAdapter(listAdapter);
            int i16 = this.mCheckedItem;
            if (i16 > -1) {
                listView2.setItemChecked(i16, true);
                listView2.setSelection(i16);
            }
        }
    }

    private static boolean shouldCenterSingleButton(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(com.tencent.mobileqq.R.attr.f4797g, typedValue, true);
        if (typedValue.data != 0) {
            return true;
        }
        return false;
    }

    public Button getButton(int i3) {
        if (i3 != -3) {
            if (i3 != -2) {
                if (i3 != -1) {
                    return null;
                }
                return this.mButtonPositive;
            }
            return this.mButtonNegative;
        }
        return this.mButtonNeutral;
    }

    public int getIconAttributeResId(int i3) {
        TypedValue typedValue = new TypedValue();
        this.mContext.getTheme().resolveAttribute(i3, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public void installContent() {
        this.mDialog.setContentView(selectContentView());
        setupView();
    }

    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.mScrollView;
        if (nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent)) {
            return true;
        }
        return false;
    }

    public boolean onKeyUp(int i3, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.mScrollView;
        if (nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent)) {
            return true;
        }
        return false;
    }

    public void setButton(int i3, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.mHandler.obtainMessage(i3, onClickListener);
        }
        if (i3 != -3) {
            if (i3 != -2) {
                if (i3 == -1) {
                    this.mButtonPositiveText = charSequence;
                    this.mButtonPositiveMessage = message;
                    this.mButtonPositiveIcon = drawable;
                    return;
                }
                throw new IllegalArgumentException("Button does not exist");
            }
            this.mButtonNegativeText = charSequence;
            this.mButtonNegativeMessage = message;
            this.mButtonNegativeIcon = drawable;
            return;
        }
        this.mButtonNeutralText = charSequence;
        this.mButtonNeutralMessage = message;
        this.mButtonNeutralIcon = drawable;
    }

    public void setButtonPanelLayoutHint(int i3) {
        this.mButtonPanelLayoutHint = i3;
    }

    public void setCustomTitle(View view) {
        this.mCustomTitleView = view;
    }

    public void setIcon(int i3) {
        this.mIcon = null;
        this.mIconId = i3;
        ImageView imageView = this.mIconView;
        if (imageView != null) {
            if (i3 != 0) {
                imageView.setVisibility(0);
                this.mIconView.setImageResource(this.mIconId);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    public void setMessage(CharSequence charSequence) {
        this.mMessage = charSequence;
        TextView textView = this.mMessageView;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        TextView textView = this.mTitleView;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void setView(int i3) {
        this.mView = null;
        this.mViewLayoutResId = i3;
        this.mViewSpacingSpecified = false;
    }

    public void setView(View view) {
        this.mView = view;
        this.mViewLayoutResId = 0;
        this.mViewSpacingSpecified = false;
    }

    public void setIcon(Drawable drawable) {
        this.mIcon = drawable;
        this.mIconId = 0;
        ImageView imageView = this.mIconView;
        if (imageView != null) {
            if (drawable != null) {
                imageView.setVisibility(0);
                this.mIconView.setImageDrawable(drawable);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    public void setView(View view, int i3, int i16, int i17, int i18) {
        this.mView = view;
        this.mViewLayoutResId = 0;
        this.mViewSpacingSpecified = true;
        this.mViewSpacingLeft = i3;
        this.mViewSpacingTop = i16;
        this.mViewSpacingRight = i17;
        this.mViewSpacingBottom = i18;
    }
}
