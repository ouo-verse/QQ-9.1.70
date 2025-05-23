package com.tencent.mobileqq.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.ListView;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QQCustomDialog extends ReportDialog {
    private static final String TAG = "QQCustomDialog";
    static final ArrayList<Integer> UPDATE_BTN_BACKGROUND_LAYOUT;
    public static final int WHICH_CANCEL = 2;
    public static final int WHICH_NEGATIVE = 0;
    public static final int WHICH_POSITIVE = 1;
    private static int screenWidth = -1;
    private BaseAdapter adapter;
    protected LinearLayout bodyLayout;
    CheckBox checkBox;
    TextView checkTxt;
    protected TextView countText;
    protected View dialogDivider;
    protected EditText dialogEdit;
    TextView dummyFirstPreviewImage;
    TextView editPicTag;
    View framePreview;
    public ImageView framePreviewImage;
    LayoutInflater inflater;
    String[] items;
    protected TextView lBtn;
    private int layoutResId;
    ListView list;
    FormSwitchItem mSwitch;
    int mThemeId;
    private ImageView mVideoIcon;
    private TextView mVideoSize;
    private TextView mVideoTime;
    private boolean needUpdateTextColor;
    DialogInterface.OnClickListener onArrayItemClick;
    ImageView operateImage;
    TextView previewImage;
    ProgressBar progressBar;
    protected TextView rBtn;
    ViewGroup rootView;
    Object tag;
    protected TextView text;
    protected TextView title;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    private class CustomDialogItemOnClickListener implements View.OnClickListener {

        /* renamed from: i, reason: collision with root package name */
        int f307134i;

        public CustomDialogItemOnClickListener(int i3) {
            this.f307134i = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QQCustomDialog qQCustomDialog = QQCustomDialog.this;
            DialogInterface.OnClickListener onClickListener = qQCustomDialog.onArrayItemClick;
            if (onClickListener != null) {
                onClickListener.onClick(qQCustomDialog, qQCustomDialog.customWhichToCallBack(this.f307134i));
                try {
                    if (QQCustomDialog.this.isShowing()) {
                        QQCustomDialog.this.dismiss();
                    }
                } catch (Exception unused) {
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    private class Holder {
        TextView text;

        Holder() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f307135d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f307136e;

        a(DialogInterface.OnClickListener onClickListener, boolean z16) {
            this.f307135d = onClickListener;
            this.f307136e = z16;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f307135d;
            if (onClickListener != null) {
                onClickListener.onClick(QQCustomDialog.this, 1);
            }
            try {
                if (QQCustomDialog.this.isShowing() && this.f307136e) {
                    QQCustomDialog.this.dismiss();
                }
            } catch (Exception unused) {
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f307138d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f307139e;

        b(DialogInterface.OnClickListener onClickListener, boolean z16) {
            this.f307138d = onClickListener;
            this.f307139e = z16;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f307138d;
            if (onClickListener != null) {
                onClickListener.onClick(QQCustomDialog.this, 1);
            }
            try {
                if (QQCustomDialog.this.isShowing() && this.f307139e) {
                    QQCustomDialog.this.dismiss();
                }
            } catch (Exception unused) {
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f307141d;

        c(DialogInterface.OnClickListener onClickListener) {
            this.f307141d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f307141d;
            if (onClickListener != null) {
                onClickListener.onClick(QQCustomDialog.this, 0);
            }
            try {
                if (QQCustomDialog.this.isShowing()) {
                    QQCustomDialog.this.dismiss();
                }
            } catch (Exception unused) {
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f307143d;

        d(DialogInterface.OnClickListener onClickListener) {
            this.f307143d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f307143d;
            if (onClickListener != null) {
                onClickListener.onClick(QQCustomDialog.this, 1);
            }
            try {
                if (QQCustomDialog.this.isShowing()) {
                    QQCustomDialog.this.dismiss();
                }
            } catch (Exception unused) {
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class e implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f307145d;

        e(Activity activity) {
            this.f307145d = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (i3 == 1) {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", this.f307145d.getPackageName(), null));
                this.f307145d.startActivity(intent);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class f extends BaseAdapter {
        f() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            String[] strArr = QQCustomDialog.this.items;
            if (strArr != null) {
                return strArr.length;
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            QQCustomDialog qQCustomDialog = QQCustomDialog.this;
            if (qQCustomDialog.inflater == null) {
                qQCustomDialog.inflater = (LayoutInflater) qQCustomDialog.getContext().getSystemService("layout_inflater");
            }
            if (view == null) {
                QQCustomDialog qQCustomDialog2 = QQCustomDialog.this;
                view = qQCustomDialog2.inflater.inflate(qQCustomDialog2.getDialogListItemLayout(), (ViewGroup) null);
                Holder holder = new Holder();
                holder.text = (TextView) view.findViewById(R.id.dr5);
                view.setTag(holder);
            }
            Holder holder2 = (Holder) view.getTag();
            TextView textView = holder2.text;
            if (textView != null) {
                textView.setText(QQCustomDialog.this.items[i3]);
                holder2.text.setOnClickListener(new CustomDialogItemOnClickListener(i3));
                int paddingTop = holder2.text.getPaddingTop();
                int paddingLeft = holder2.text.getPaddingLeft();
                int paddingRight = holder2.text.getPaddingRight();
                int paddingBottom = holder2.text.getPaddingBottom();
                String[] strArr = QQCustomDialog.this.items;
                if (strArr.length == 1) {
                    holder2.text.setBackgroundResource(R.drawable.custom_dialog_list_item_single_bg_selector);
                } else if (i3 == 0) {
                    holder2.text.setBackgroundResource(R.drawable.custom_dialog_list_item_up_bg_selector);
                } else if (i3 == strArr.length - 1) {
                    holder2.text.setBackgroundResource(R.drawable.custom_dialog_list_item_down_bg_selector);
                }
                holder2.text.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class g implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f307147d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f307148e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f307149f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f307150h;

        g(int i3, String str, boolean z16, boolean z17) {
            this.f307147d = i3;
            this.f307148e = str;
            this.f307149f = z16;
            this.f307150h = z17;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            QQCustomDialog.this.text.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            if (QQCustomDialog.this.text.getLineCount() > this.f307147d) {
                int lineEnd = QQCustomDialog.this.text.getLayout().getLineEnd(this.f307147d - 1);
                if (!this.f307149f && !this.f307150h) {
                    QQCustomDialog.this.text.setText(((Object) QQCustomDialog.this.text.getText().subSequence(0, lineEnd - 3)) + MiniBoxNoticeInfo.APPNAME_SUFFIX);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class h implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LinearLayout f307152d;

        h(LinearLayout linearLayout) {
            this.f307152d = linearLayout;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i3;
            QQCustomDialog.this.text.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            int lineCount = QQCustomDialog.this.text.getLineCount();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f307152d.getLayoutParams();
            if (lineCount > 1) {
                i3 = 3;
            } else {
                i3 = 17;
            }
            layoutParams.gravity = i3;
            this.f307152d.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class i implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f307154d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ LinearLayout f307155e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f307156f;

        i(DialogInterface.OnClickListener onClickListener, LinearLayout linearLayout, String str) {
            this.f307154d = onClickListener;
            this.f307155e = linearLayout;
            this.f307156f = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            boolean z16 = !QQCustomDialog.this.checkBox.isChecked();
            QQCustomDialog.this.checkBox.setChecked(z16);
            DialogInterface.OnClickListener onClickListener = this.f307154d;
            if (onClickListener != null) {
                onClickListener.onClick(QQCustomDialog.this, z16 ? 1 : 0);
            }
            if (AppSetting.f99565y) {
                AccessibilityUtil.q(this.f307155e, this.f307156f, QQCustomDialog.this.checkBox.isChecked());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class j implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f307158d;

        j(DialogInterface.OnClickListener onClickListener) {
            this.f307158d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            boolean isChecked = QQCustomDialog.this.checkBox.isChecked();
            DialogInterface.OnClickListener onClickListener = this.f307158d;
            if (onClickListener != null) {
                onClickListener.onClick(QQCustomDialog.this, isChecked ? 1 : 0);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class k implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f307160d;

        k(DialogInterface.OnClickListener onClickListener) {
            this.f307160d = onClickListener;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            this.f307160d.onClick(QQCustomDialog.this, z16 ? 1 : 0);
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class l implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f307162d;

        l(DialogInterface.OnClickListener onClickListener) {
            this.f307162d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f307162d;
            if (onClickListener != null) {
                onClickListener.onClick(QQCustomDialog.this, 0);
            }
            try {
                if (QQCustomDialog.this.isShowing()) {
                    QQCustomDialog.this.dismiss();
                }
            } catch (Exception unused) {
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class m implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f307164d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f307165e;

        m(DialogInterface.OnClickListener onClickListener, boolean z16) {
            this.f307164d = onClickListener;
            this.f307165e = z16;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f307164d;
            if (onClickListener != null) {
                onClickListener.onClick(QQCustomDialog.this, 0);
            }
            try {
                if (this.f307165e && QQCustomDialog.this.isShowing()) {
                    QQCustomDialog.this.dismiss();
                }
            } catch (Exception unused) {
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class n implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f307167d;

        n(DialogInterface.OnClickListener onClickListener) {
            this.f307167d = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DialogInterface.OnClickListener onClickListener = this.f307167d;
            if (onClickListener != null) {
                onClickListener.onClick(QQCustomDialog.this, 1);
            }
            try {
                if (QQCustomDialog.this.isShowing()) {
                    QQCustomDialog.this.dismiss();
                }
            } catch (Exception unused) {
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    static {
        ArrayList<Integer> arrayList = new ArrayList<>();
        UPDATE_BTN_BACKGROUND_LAYOUT = arrayList;
        arrayList.add(Integer.valueOf(R.layout.custom_dialog));
        arrayList.add(Integer.valueOf(R.layout.f167834j4));
        arrayList.add(Integer.valueOf(R.layout.f167839ja));
        arrayList.add(Integer.valueOf(R.layout.f167853jk));
        arrayList.add(Integer.valueOf(R.layout.f167856jn));
        arrayList.add(Integer.valueOf(R.layout.f167859jr));
        arrayList.add(Integer.valueOf(R.layout.f167867jz));
    }

    @TargetApi(14)
    public QQCustomDialog(Context context) {
        super(context);
        this.mThemeId = 1000;
        this.layoutResId = 0;
        this.needUpdateTextColor = true;
        this.adapter = new f();
        super.getWindow().setWindowAnimations(R.style.f173401cf);
        getWindow().setDimAmount(0.5f);
    }

    private void applyThemeId() {
        int i3 = this.layoutResId;
        if (i3 == 0) {
            return;
        }
        if (i3 != R.layout.f167834j4) {
            com.tencent.mobileqq.simpleui.c.g(this, this.mThemeId);
        }
        if (this.needUpdateTextColor) {
            com.tencent.mobileqq.simpleui.c.i(this, this.mThemeId);
        }
        com.tencent.mobileqq.simpleui.c.e(this, this.mThemeId);
        CheckBox checkBox = this.checkBox;
        if (checkBox != null && (checkBox instanceof QUICheckBox)) {
            ((QUICheckBox) checkBox).setThemeId(this.mThemeId);
        }
    }

    private int getScreenWidth() {
        int i3 = screenWidth;
        if (i3 != -1) {
            return i3;
        }
        int i16 = getContext().getResources().getDisplayMetrics().widthPixels;
        screenWidth = i16;
        return i16;
    }

    private void printDialogContent() {
        String valueOf;
        TextView textView = this.title;
        if (textView != null && !TextUtils.isEmpty(textView.getText())) {
            valueOf = this.title.getText().toString();
        } else {
            TextView textView2 = this.text;
            if (textView2 != null && !TextUtils.isEmpty(textView2.getText())) {
                valueOf = this.text.getText().toString();
            } else {
                valueOf = String.valueOf(hashCode());
            }
        }
        QLog.i(TAG, 1, "show, content=" + valueOf);
    }

    public static void showPermissionRequestDialog(Activity activity, String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        QQCustomDialog qQCustomDialog = new QQCustomDialog(activity, R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.f167856jn);
        qQCustomDialog.setCanceledOnTouchOutside(false);
        if (TextUtils.isEmpty(str)) {
            str = com.tencent.mobileqq.widget.az.g(R.string.qo_);
        }
        qQCustomDialog.setTitle(str);
        if (TextUtils.isEmpty(str2)) {
            str2 = com.tencent.mobileqq.widget.az.g(R.string.f172426qo2);
        }
        qQCustomDialog.setMessage(str2);
        if (TextUtils.isEmpty(str3)) {
            str3 = com.tencent.mobileqq.widget.az.g(R.string.j6l);
        }
        if (TextUtils.isEmpty(str4)) {
            str4 = com.tencent.mobileqq.widget.az.g(R.string.qnu);
        }
        qQCustomDialog.setNegativeButton(str4, onClickListener2);
        qQCustomDialog.setPositiveButton(str3, onClickListener);
        qQCustomDialog.show();
    }

    public static void showPermissionSettingDialog(Activity activity, String str) {
        showPermissionSettingDialog(activity, null, str);
    }

    private void widthCompat() {
        ViewGroup.LayoutParams layoutParams;
        int dimension = (int) getContext().getResources().getDimension(R.dimen.f158688md);
        int screenWidth2 = getScreenWidth();
        if (screenWidth2 > 0 && dimension > 0 && screenWidth2 < dimension) {
            ViewGroup viewGroup = this.rootView;
            if (viewGroup != null && (layoutParams = viewGroup.getLayoutParams()) != null) {
                layoutParams.width = screenWidth2;
                this.rootView.setLayoutParams(layoutParams);
            }
            if (this.list != null) {
                int dimension2 = (int) (getContext().getResources().getDimension(R.dimen.m3) * (screenWidth2 / dimension));
                ViewGroup.LayoutParams layoutParams2 = this.list.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.width = dimension2;
                    this.list.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public QQCustomDialog addCenterView(View view, LinearLayout.LayoutParams layoutParams) {
        this.text.setVisibility(8);
        this.countText.setVisibility(8);
        this.bodyLayout.addView(view, layoutParams);
        this.bodyLayout.setGravity(17);
        return this;
    }

    public void addPreviewView(View view) {
        ViewGroup viewGroup;
        if (view == null || (viewGroup = this.rootView) == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.rootView.getChildAt(i3);
            if (childAt != null && childAt.getVisibility() == 0) {
                childAt.setVisibility(4);
            }
        }
        this.rootView.addView(view);
        view.setTag(1001);
    }

    public QQCustomDialog addView(View view) {
        this.text.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.countText.setVisibility(8);
        this.bodyLayout.addView(view, layoutParams);
        return this;
    }

    public void adjustMessageBottomMargin(float f16) {
        LinearLayout linearLayout = this.bodyLayout;
        if (linearLayout != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.bottomMargin = com.tencent.mobileqq.widget.az.a(getContext(), f16);
            this.bodyLayout.setLayoutParams(layoutParams);
        }
    }

    public void adjustMessageLayout(boolean z16) {
        if (z16) {
            if (this.text.getLineCount() > 1) {
                this.text.setGravity(3);
                return;
            } else {
                this.text.setGravity(17);
                return;
            }
        }
        this.text.setGravity(3);
    }

    public void adjustMessageTopBottomMargin(float f16, float f17) {
        LinearLayout linearLayout = this.bodyLayout;
        if (linearLayout != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.bottomMargin = com.tencent.mobileqq.widget.az.a(getContext(), f17);
            layoutParams.topMargin = com.tencent.mobileqq.widget.az.a(getContext(), f16);
            this.bodyLayout.setLayoutParams(layoutParams);
        }
    }

    public void adjustTitle() {
        this.title.setGravity(3);
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception unused) {
        } catch (Throwable th5) {
            sy3.a.a(this);
            throw th5;
        }
        sy3.a.a(this);
    }

    public void dismissMessage() {
        LinearLayout linearLayout = this.bodyLayout;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.getText().add(getContext().getString(R.string.a_q));
        }
        super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Dialog.class.getName());
        return false;
    }

    public TextView getBtnLeft() {
        return this.lBtn;
    }

    public TextView getBtnight() {
        return this.rBtn;
    }

    public boolean getCheckBoxState() {
        CheckBox checkBox = this.checkBox;
        if (checkBox != null && checkBox.getVisibility() == 0) {
            return this.checkBox.isChecked();
        }
        return false;
    }

    public View getDialogDivider() {
        return this.dialogDivider;
    }

    protected int getDialogListItemLayout() {
        return R.layout.custom_dialog_list_item;
    }

    public String getEditString() {
        EditText editText = this.dialogEdit;
        if (editText == null) {
            return null;
        }
        String obj = editText.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            return this.dialogEdit.getHint().toString();
        }
        return obj;
    }

    public EditText getEditText() {
        return null;
    }

    public String getInputValue() {
        return null;
    }

    public TextView getMessageTextView() {
        return this.text;
    }

    public TextView getMessageTextView_Plain_Text() {
        return (TextView) findViewById(R.id.bjg);
    }

    public ViewGroup getRootView() {
        return this.rootView;
    }

    public int getRootViewHeight() {
        ViewGroup viewGroup = this.rootView;
        if (viewGroup == null) {
            return -1;
        }
        return viewGroup.getMeasuredHeight();
    }

    public boolean getSwitchState() {
        FormSwitchItem formSwitchItem = this.mSwitch;
        if (formSwitchItem != null && formSwitchItem.getVisibility() == 0) {
            return this.mSwitch.isChecked();
        }
        return false;
    }

    public Object getTag() {
        return this.tag;
    }

    public TextView getTitleTextView() {
        return this.title;
    }

    public boolean hasPreViewInDialog() {
        int childCount;
        View childAt;
        ViewGroup viewGroup = this.rootView;
        if (viewGroup == null || (childCount = viewGroup.getChildCount() - 1) < 0 || (childAt = this.rootView.getChildAt(childCount)) == null || !(childAt.getTag() instanceof Integer) || ((Integer) childAt.getTag()).intValue() != 1001) {
            return false;
        }
        return true;
    }

    public void hideSoftInputFromWindow() {
        if (this.dialogEdit != null) {
            ((InputMethodManager) getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(this.dialogEdit.getWindowToken(), 0);
        }
    }

    public void removePreviewView() {
        ViewGroup viewGroup = this.rootView;
        if (viewGroup == null) {
            return;
        }
        int childCount = viewGroup.getChildCount() - 1;
        if (childCount >= 0) {
            this.rootView.removeViewAt(childCount);
        }
        for (int i3 = childCount - 1; i3 >= 0; i3--) {
            View childAt = this.rootView.getChildAt(i3);
            if (childAt != null) {
                if ((childAt.getTag() instanceof Integer) && ((Integer) childAt.getTag()).intValue() == 1001) {
                    childAt.setVisibility(0);
                    return;
                }
                childAt.setVisibility(0);
            }
        }
    }

    public void setBackground(int i3) {
        ViewGroup viewGroup = this.rootView;
        if (viewGroup != null) {
            viewGroup.setBackgroundResource(i3);
        }
    }

    public void setBannerDrawable(int i3) {
        setBannerDrawable(getContext().getResources().getDrawable(i3, getContext().getTheme()));
    }

    public void setBodyLayoutNoMargin() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bodyLayout.getLayoutParams();
        layoutParams.setMargins(0, layoutParams.topMargin, 0, 0);
        this.bodyLayout.setLayoutParams(layoutParams);
    }

    public void setBrandColor(int i3) {
        Drawable background;
        View findViewById = findViewById(R.id.bif);
        if (findViewById == null || (background = findViewById.getBackground()) == null) {
            return;
        }
        Drawable mutate = background.mutate();
        if (mutate instanceof GradientDrawable) {
            ((GradientDrawable) mutate).setColor(i3);
        } else {
            QLog.w(TAG, 4, "set band border-color fail");
        }
    }

    public QQCustomDialog setCheckBox(String str, DialogInterface.OnClickListener onClickListener) {
        return setCheckBox(str, true, onClickListener);
    }

    @Override // android.app.Dialog
    public void setContentView(int i3) {
        super.setContentView(i3);
        this.title = (TextView) findViewById(R.id.dialogTitle);
        this.text = (TextView) findViewById(R.id.dialogText);
        this.dialogEdit = (EditText) findViewById(R.id.f164980bj0);
        this.countText = (TextView) findViewById(R.id.bit);
        this.dummyFirstPreviewImage = (TextView) findViewById(R.id.bqm);
        this.previewImage = (TextView) findViewById(R.id.fyd);
        this.operateImage = (ImageView) findViewById(R.id.fe7);
        this.framePreviewImage = (ImageView) findViewById(R.id.cla);
        this.framePreview = findViewById(R.id.cl_);
        this.mVideoIcon = (ImageView) findViewById(R.id.kro);
        this.mVideoSize = (TextView) findViewById(R.id.ehi);
        this.mVideoTime = (TextView) findViewById(R.id.ehj);
        this.dialogDivider = findViewById(R.id.biw);
        this.lBtn = (TextView) findViewById(R.id.dialogLeftBtn);
        this.rBtn = (TextView) findViewById(R.id.dialogRightBtn);
        this.editPicTag = (TextView) findViewById(R.id.f164981bj1);
        this.progressBar = (ProgressBar) findViewById(R.id.bk_);
        this.lBtn.setVisibility(8);
        this.rBtn.setVisibility(8);
        this.bodyLayout = (LinearLayout) findViewById(R.id.abb);
        this.checkBox = (CheckBox) findViewById(R.id.juo);
        this.mSwitch = (FormSwitchItem) findViewById(R.id.juq);
        this.checkTxt = (TextView) findViewById(R.id.kdc);
        this.list = (ListView) findViewById(R.id.eap);
        this.rootView = (ViewGroup) findViewById(R.id.bja);
        this.layoutResId = i3;
        ListView listView = this.list;
        if (listView != null) {
            listView.setOverScrollMode(2);
        }
        applyThemeId();
        widthCompat();
    }

    public void setDialogDividerColor(int i3) {
        View view = this.dialogDivider;
        if (view != null) {
            view.setBackgroundResource(i3);
        }
    }

    public void setEditLint(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.dialogEdit.getVisibility() != 0) {
                this.dialogEdit.setVisibility(0);
            }
            this.dialogEdit.setHint(str);
            return;
        }
        this.dialogEdit.setVisibility(8);
    }

    public QQCustomDialog setFirstDummyPreviewImage(Drawable drawable) {
        this.dummyFirstPreviewImage.setPadding(0, 0, 0, 0);
        this.dummyFirstPreviewImage.setCompoundDrawablePadding(0);
        this.dummyFirstPreviewImage.setCompoundDrawables(null, null, null, drawable);
        if (drawable != null) {
            this.dummyFirstPreviewImage.setVisibility(0);
        } else {
            this.dummyFirstPreviewImage.setVisibility(8);
        }
        return this;
    }

    public QQCustomDialog setImageOnClickListener(View.OnClickListener onClickListener) {
        ImageView imageView;
        if (onClickListener != null && (imageView = this.framePreviewImage) != null) {
            imageView.setOnClickListener(onClickListener);
            this.countText.setVisibility(8);
        }
        return this;
    }

    public QQCustomDialog setItems(String[] strArr, DialogInterface.OnClickListener onClickListener) {
        this.items = strArr;
        this.text.setVisibility(8);
        this.countText.setVisibility(8);
        this.lBtn.setVisibility(8);
        this.rBtn.setVisibility(8);
        this.bodyLayout.setVisibility(8);
        this.onArrayItemClick = onClickListener;
        this.list.setVisibility(0);
        this.list.setAdapter((ListAdapter) this.adapter);
        this.list.setDivider(null);
        this.list.setDividerHeight(0);
        return this;
    }

    public QQCustomDialog setMessage(int i3) {
        this.text.setText(i3);
        this.text.setContentDescription(getContext().getString(i3));
        this.text.setVisibility(0);
        return this;
    }

    public QQCustomDialog setMessageCount(String str) {
        if (str != null) {
            this.countText.setText(str);
            this.countText.setContentDescription(str);
            this.countText.setVisibility(0);
        } else {
            this.countText.setVisibility(8);
        }
        return this;
    }

    public QQCustomDialog setMessageMaxLine(int i3) {
        TextView textView = this.text;
        if (textView != null) {
            textView.setMaxLines(i3);
            this.text.setEllipsize(TextUtils.TruncateAt.END);
        }
        return this;
    }

    public void setMessageTextColor(int i3) {
        ColorStateList colorStateList = getContext().getResources().getColorStateList(i3);
        TextView textView = this.text;
        if (textView != null && textView.getVisibility() == 0) {
            this.text.setTextColor(colorStateList);
        }
    }

    public void setMessageTextSize(float f16) {
        TextView textView = this.text;
        if (textView != null && textView.getVisibility() == 0) {
            this.text.setTextSize(f16);
        }
    }

    public QQCustomDialog setMessageWithEmo(String str, float f16) {
        if (!TextUtils.isEmpty(str)) {
            this.text.setText(new QQText(str, 3));
            this.text.setContentDescription(str);
            this.text.setVisibility(0);
        } else {
            this.text.setVisibility(8);
        }
        return this;
    }

    public QQCustomDialog setMessageWithUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.text.setAutoLinkMask(1);
            this.text.setMovementMethod(LinkMovementMethod.getInstance());
            this.text.setText(str);
            this.text.setContentDescription(str);
            this.text.setLinkTextColor(getContext().getResources().getColor(R.color.login_error_url));
            this.text.setVisibility(0);
        } else {
            this.text.setVisibility(8);
        }
        return this;
    }

    public QQCustomDialog setMessageWithoutAutoLink(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.text.setMovementMethod(LinkMovementMethod.getInstance());
            this.text.setText(charSequence);
            this.text.setContentDescription(charSequence);
            this.text.setVisibility(0);
        } else {
            this.text.setVisibility(8);
        }
        return this;
    }

    public QQCustomDialog setMsgMaxLineWithEnd(String str, int i3, boolean z16, boolean z17) {
        TextView textView = this.text;
        if (textView != null) {
            textView.setMaxLines(i3);
            this.text.getViewTreeObserver().addOnGlobalLayoutListener(new g(i3, str, z16, z17));
        }
        return this;
    }

    public QQCustomDialog setNegativeButton(String str, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.lBtn.setVisibility(8);
            return this;
        }
        this.lBtn.setText(str);
        AccessibilityUtil.c(this.lBtn, str, Button.class.getName());
        this.lBtn.setVisibility(0);
        this.lBtn.setOnClickListener(new l(onClickListener));
        setSeperatorState();
        return this;
    }

    public void setNegativeButtonContentDescription(String str) {
        this.lBtn.setContentDescription(str);
    }

    public QQCustomDialog setOperateImage(Drawable drawable) {
        ImageView imageView = this.operateImage;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
            if (drawable != null) {
                this.operateImage.setVisibility(0);
                ImageView imageView2 = this.operateImage;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                }
            } else {
                this.operateImage.setVisibility(8);
                ImageView imageView3 = this.operateImage;
                if (imageView3 != null) {
                    imageView3.setVisibility(0);
                }
            }
        }
        return this;
    }

    public QQCustomDialog setPositiveButton(String str, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.rBtn.setVisibility(8);
            return this;
        }
        this.rBtn.setText(str);
        AccessibilityUtil.c(this.rBtn, str, Button.class.getName());
        this.rBtn.setVisibility(0);
        this.rBtn.setOnClickListener(new n(onClickListener));
        setSeperatorState();
        return this;
    }

    public void setPositiveButtonContentDescription(String str) {
        this.rBtn.setContentDescription(str);
    }

    public QQCustomDialog setPreviewFixDimension(int i3, int i16) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.framePreview.getLayoutParams();
        marginLayoutParams.width = i3;
        marginLayoutParams.height = i16;
        marginLayoutParams.topMargin = com.tencent.mobileqq.widget.az.a(getContext(), 12.0f);
        this.framePreviewImage.getLayoutParams().width = i3;
        this.framePreviewImage.getLayoutParams().height = i16;
        return this;
    }

    public QQCustomDialog setPreviewImage(Drawable drawable) {
        return setPreviewImage(drawable, false, 0);
    }

    public QQCustomDialog setPreviewImageScaleType(boolean z16) {
        ImageView.ScaleType scaleType;
        ImageView imageView = this.framePreviewImage;
        if (z16) {
            scaleType = ImageView.ScaleType.CENTER_INSIDE;
        } else {
            scaleType = ImageView.ScaleType.CENTER_CROP;
        }
        imageView.setScaleType(scaleType);
        return this;
    }

    public void setProgress(int i3) {
        ProgressBar progressBar = this.progressBar;
        if (progressBar != null) {
            progressBar.setProgress(i3);
        }
    }

    public void setProgressBarVisibility(int i3) {
        ProgressBar progressBar = this.progressBar;
        if (progressBar != null) {
            progressBar.setVisibility(i3);
        }
    }

    public QQCustomDialog setSwitch(String str, boolean z16, DialogInterface.OnClickListener onClickListener) {
        FormSwitchItem formSwitchItem = this.mSwitch;
        if (formSwitchItem != null) {
            formSwitchItem.setVisibility(0);
            this.mSwitch.setText(str);
            this.mSwitch.setChecked(z16);
            if (onClickListener != null) {
                this.mSwitch.setOnCheckedChangeListener(new k(onClickListener));
            }
        }
        return this;
    }

    public void setTag(Object obj) {
        this.tag = obj;
    }

    public QQCustomDialog setText(String str, int i3) {
        TextView textView;
        if ((findViewById(i3) instanceof TextView) && (textView = (TextView) findViewById(i3)) != null) {
            textView.setText(str);
            textView.setContentDescription(str);
        }
        return this;
    }

    public void setTextContentDescription(String str) {
        this.text.setContentDescription(str);
    }

    public QQCustomDialog setTextIsSelectable(boolean z16) {
        this.text.setTextIsSelectable(z16);
        return this;
    }

    public void setThemeId(int i3) {
        if (this.mThemeId == i3) {
            return;
        }
        this.mThemeId = i3;
        applyThemeId();
    }

    public QQCustomDialog setTitle(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.title.setText(str);
            this.title.setContentDescription(str);
            this.title.setVisibility(0);
            this.text.setTextSize(14.0f);
        } else {
            this.title.setVisibility(8);
            this.text.setTextSize(17.0f);
        }
        return this;
    }

    public void setTitleMutiLine() {
        this.title.setSingleLine(false);
    }

    public void setTitleTextColor(int i3) {
        ColorStateList colorStateList = getContext().getResources().getColorStateList(i3);
        TextView textView = this.title;
        if (textView != null && textView.getVisibility() == 0) {
            this.title.setTextColor(colorStateList);
        }
    }

    public QQCustomDialog setTitleWithEmo(CharSequence charSequence) {
        if (charSequence != null) {
            this.title.setText(charSequence);
            this.title.setVisibility(0);
        } else {
            this.title.setVisibility(8);
        }
        return this;
    }

    public void setUpdateTextColor(boolean z16) {
        this.needUpdateTextColor = z16;
    }

    public QQCustomDialog setVideoFormat(boolean z16, boolean z17, String str, String str2) {
        ImageView imageView;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        ImageView imageView2;
        if (z16 && (imageView2 = this.mVideoIcon) != null) {
            imageView2.setVisibility(0);
        } else if (!z16 && (imageView = this.mVideoIcon) != null) {
            imageView.setVisibility(8);
        }
        if (z17 && (textView6 = this.editPicTag) != null) {
            textView6.setVisibility(0);
        } else if (!z17 && (textView = this.editPicTag) != null) {
            textView.setVisibility(8);
        }
        if (!TextUtils.isEmpty(str) && (textView5 = this.mVideoSize) != null) {
            textView5.setVisibility(0);
            this.mVideoSize.setText(str);
        } else if (TextUtils.isEmpty(str) && (textView2 = this.mVideoSize) != null) {
            textView2.setVisibility(8);
        }
        if (!TextUtils.isEmpty(str2) && (textView4 = this.mVideoTime) != null) {
            textView4.setVisibility(0);
            this.mVideoTime.setText(str2);
        } else if (TextUtils.isEmpty(str2) && (textView3 = this.mVideoTime) != null) {
            textView3.setVisibility(8);
        }
        return this;
    }

    public QQCustomDialog setView(View view) {
        this.bodyLayout.addView(view, new LinearLayout.LayoutParams(-1, -2));
        return this;
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        if (UPDATE_BTN_BACKGROUND_LAYOUT.contains(Integer.valueOf(this.layoutResId))) {
            com.tencent.mobileqq.simpleui.c.c(this, this.mThemeId);
        }
        printDialogContent();
        try {
            super.show();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "show error:", th5);
        }
    }

    public static void showPermissionSettingDialog(Activity activity, String str, String str2) {
        e eVar = new e(activity);
        showPermissionSettingDialog(activity, str, str2, eVar, eVar, null);
    }

    public void setBannerDrawable(String str) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = getContext().getResources().getDimensionPixelSize(R.dimen.f158688md);
        obtain.mRequestHeight = getContext().getResources().getDimensionPixelSize(R.dimen.c9f);
        obtain.mFailedDrawable = new ColorDrawable(0);
        obtain.mLoadingDrawable = new ColorDrawable(0);
        setBannerDrawable(URLDrawable.getDrawable(str, obtain));
    }

    public QQCustomDialog setCheckBox(String str, boolean z16, DialogInterface.OnClickListener onClickListener) {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.e2z);
        linearLayout.setVisibility(0);
        linearLayout.requestLayout();
        this.text.getViewTreeObserver().addOnGlobalLayoutListener(new h(linearLayout));
        this.checkTxt.setText(str);
        if (this.checkBox != null) {
            linearLayout.setOnClickListener(new i(onClickListener, linearLayout, str));
            this.checkBox.setOnClickListener(new j(onClickListener));
            this.checkBox.setChecked(z16);
            if (AppSetting.f99565y) {
                AccessibilityUtil.n(this.checkTxt, false);
                AccessibilityUtil.n(this.checkBox, false);
                AccessibilityUtil.q(linearLayout, str, this.checkBox.isChecked());
            }
        }
        setSeperatorState();
        return this;
    }

    public QQCustomDialog setPreviewImage(Drawable drawable, boolean z16, int i3, boolean z17) {
        if (drawable == null) {
            return this;
        }
        if (z16) {
            this.framePreview.setVisibility(0);
            this.previewImage.setVisibility(8);
            if (!z17) {
                this.framePreviewImage.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            } else {
                this.framePreviewImage.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            }
            this.framePreviewImage.setImageDrawable(drawable);
            if (i3 < 2) {
                this.framePreview.setBackgroundDrawable(null);
            } else if (i3 == 2) {
                this.framePreview.setBackgroundResource(R.drawable.cmv);
            } else {
                this.framePreview.setBackgroundResource(R.drawable.cmw);
            }
        } else {
            this.framePreview.setVisibility(8);
            this.previewImage.setVisibility(0);
            this.previewImage.setCompoundDrawablePadding(0);
            this.previewImage.setCompoundDrawables(drawable, null, null, null);
            this.previewImage.setVisibility(0);
        }
        return this;
    }

    public static void showPermissionSettingDialog(Activity activity, String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener) {
        QQCustomDialog qQCustomDialog = new QQCustomDialog(activity, R.style.qZoneInputDialog);
        qQCustomDialog.setContentView(R.layout.f167856jn);
        qQCustomDialog.setTitle(str);
        qQCustomDialog.setMessage(str2);
        qQCustomDialog.setNegativeButton(R.string.cancel, onClickListener);
        qQCustomDialog.setPositiveButton(R.string.f171151ok, onClickListener2);
        qQCustomDialog.setCanceledOnTouchOutside(false);
        if (str == null || str.equals("")) {
            str = com.tencent.mobileqq.widget.az.g(R.string.qo_);
        }
        qQCustomDialog.setTitle(str);
        if (str2 == null || str2.equals("")) {
            str2 = com.tencent.mobileqq.widget.az.g(R.string.f172426qo2);
        }
        qQCustomDialog.setMessage(str2);
        qQCustomDialog.setNegativeButton(com.tencent.mobileqq.widget.az.g(R.string.j6l), onClickListener);
        qQCustomDialog.setPositiveButton(com.tencent.mobileqq.widget.az.g(R.string.qnu), onClickListener2);
        qQCustomDialog.setOnCancelListener(onCancelListener);
        qQCustomDialog.show();
    }

    public QQCustomDialog setMessage(CharSequence charSequence) {
        if (this.text == null) {
            return this;
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.text.setText(charSequence);
            this.text.setVisibility(0);
            this.text.setMovementMethod(ScrollingMovementMethod.getInstance());
        } else {
            this.text.setVisibility(8);
        }
        return this;
    }

    public QQCustomDialog addView(View view, LinearLayout.LayoutParams layoutParams) {
        this.text.setVisibility(8);
        this.countText.setVisibility(8);
        this.bodyLayout.addView(view, layoutParams);
        return this;
    }

    public QQCustomDialog setNegativeButton(String str, DialogInterface.OnClickListener onClickListener, boolean z16) {
        if (onClickListener == null) {
            this.lBtn.setVisibility(8);
            return this;
        }
        this.lBtn.setText(str);
        AccessibilityUtil.c(this.lBtn, str, Button.class.getName());
        this.lBtn.setVisibility(0);
        this.lBtn.setOnClickListener(new m(onClickListener, z16));
        setSeperatorState();
        return this;
    }

    public QQCustomDialog setPositiveButton(String str, int i3, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.rBtn.setVisibility(8);
            return this;
        }
        if (i3 != 0) {
            this.rBtn.setTextColor(i3);
        }
        return setPositiveButton(str, onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @TargetApi(14)
    public QQCustomDialog(Context context, boolean z16, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z16, onCancelListener);
        this.mThemeId = 1000;
        this.layoutResId = 0;
        this.needUpdateTextColor = true;
        this.adapter = new f();
        super.getWindow().setWindowAnimations(R.style.f173401cf);
        getWindow().setDimAmount(0.5f);
    }

    public void setBannerDrawable(Drawable drawable) {
        ImageView imageView = (ImageView) findViewById(R.id.uha);
        if (imageView == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.title.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.addRule(3, imageView.getId());
            this.title.setLayoutParams(layoutParams);
        }
        this.rootView.setPadding(0, 0, 0, 0);
        if (imageView.getVisibility() != 0) {
            imageView.setVisibility(0);
        }
        imageView.setImageDrawable(drawable);
    }

    @Override // android.app.Dialog
    public void setTitle(int i3) {
        this.title.setText(i3);
        this.title.setVisibility(0);
    }

    public QQCustomDialog setPositiveButton(int i3, DialogInterface.OnClickListener onClickListener, boolean z16) {
        if (onClickListener == null) {
            this.rBtn.setVisibility(8);
            return this;
        }
        this.rBtn.setText(i3);
        AccessibilityUtil.c(this.rBtn, getContext().getString(i3), Button.class.getName());
        this.rBtn.setVisibility(0);
        this.rBtn.setOnClickListener(new a(onClickListener, z16));
        setSeperatorState();
        return this;
    }

    public QQCustomDialog setItems(int i3, DialogInterface.OnClickListener onClickListener) {
        String[] strArr;
        try {
            strArr = getContext().getResources().getStringArray(i3);
        } catch (Resources.NotFoundException e16) {
            e16.printStackTrace();
            strArr = null;
        }
        return setItems(strArr, onClickListener);
    }

    public QQCustomDialog setNegativeButton(String str, int i3, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.lBtn.setVisibility(8);
            return this;
        }
        if (i3 != 0) {
            this.lBtn.setTextColor(i3);
        }
        return setNegativeButton(str, onClickListener);
    }

    @TargetApi(14)
    public QQCustomDialog(Context context, int i3) {
        super(context, i3);
        this.mThemeId = 1000;
        this.layoutResId = 0;
        this.needUpdateTextColor = true;
        this.adapter = new f();
        super.getWindow().setWindowAnimations(R.style.f173401cf);
        getWindow().setDimAmount(0.5f);
    }

    public QQCustomDialog setNegativeButton(int i3, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.lBtn.setVisibility(8);
            return this;
        }
        this.lBtn.setText(i3);
        AccessibilityUtil.c(this.lBtn, getContext().getString(i3), Button.class.getName());
        this.lBtn.setVisibility(0);
        this.lBtn.setOnClickListener(new c(onClickListener));
        setSeperatorState();
        return this;
    }

    public QQCustomDialog setPositiveButton(String str, DialogInterface.OnClickListener onClickListener, boolean z16) {
        if (onClickListener == null) {
            this.rBtn.setVisibility(8);
            return this;
        }
        this.rBtn.setText(str);
        AccessibilityUtil.c(this.rBtn, str, Button.class.getName());
        this.rBtn.setVisibility(0);
        this.rBtn.setOnClickListener(new b(onClickListener, z16));
        setSeperatorState();
        return this;
    }

    public QQCustomDialog setPreviewImage(Drawable drawable, boolean z16, int i3) {
        return setPreviewImage(drawable, z16, i3, false);
    }

    public QQCustomDialog setPositiveButton(int i3, DialogInterface.OnClickListener onClickListener) {
        if (onClickListener == null) {
            this.rBtn.setVisibility(8);
            return this;
        }
        this.rBtn.setText(i3);
        AccessibilityUtil.c(this.rBtn, getContext().getString(i3), Button.class.getName());
        this.rBtn.setVisibility(0);
        this.rBtn.setOnClickListener(new d(onClickListener));
        setSeperatorState();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSeperatorState() {
    }

    protected int customWhichToCallBack(int i3) {
        return i3;
    }
}
