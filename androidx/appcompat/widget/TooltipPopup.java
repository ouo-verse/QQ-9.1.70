package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.tencent.mobileqq.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
class TooltipPopup {
    private static final String TAG = "TooltipPopup";
    private final View mContentView;
    private final Context mContext;
    private final WindowManager.LayoutParams mLayoutParams;
    private final TextView mMessageView;
    private final int[] mTmpAnchorPos;
    private final int[] mTmpAppPos;
    private final Rect mTmpDisplayFrame;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TooltipPopup(@NonNull Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.mLayoutParams = layoutParams;
        this.mTmpDisplayFrame = new Rect();
        this.mTmpAnchorPos = new int[2];
        this.mTmpAppPos = new int[2];
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.dpr, (ViewGroup) null);
        this.mContentView = inflate;
        this.mMessageView = (TextView) inflate.findViewById(R.id.eqq);
        layoutParams.setTitle(getClass().getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R.style.f243691h;
        layoutParams.flags = 24;
    }

    private void computePosition(View view, int i3, int i16, boolean z16, WindowManager.LayoutParams layoutParams) {
        int height;
        int i17;
        int i18;
        int i19;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.dgl);
        if (view.getWidth() < dimensionPixelOffset) {
            i3 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.mContext.getResources().getDimensionPixelOffset(R.dimen.dgk);
            height = i16 + dimensionPixelOffset2;
            i17 = i16 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i17 = 0;
        }
        layoutParams.gravity = 49;
        Resources resources = this.mContext.getResources();
        if (z16) {
            i18 = R.dimen.dgo;
        } else {
            i18 = R.dimen.dgn;
        }
        int dimensionPixelOffset3 = resources.getDimensionPixelOffset(i18);
        View appRootView = getAppRootView(view);
        if (appRootView == null) {
            Log.e(TAG, "Cannot find app view");
            return;
        }
        appRootView.getWindowVisibleDisplayFrame(this.mTmpDisplayFrame);
        Rect rect = this.mTmpDisplayFrame;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources2 = this.mContext.getResources();
            int identifier = resources2.getIdentifier("status_bar_height", "dimen", "android");
            if (identifier != 0) {
                i19 = resources2.getDimensionPixelSize(identifier);
            } else {
                i19 = 0;
            }
            DisplayMetrics displayMetrics = resources2.getDisplayMetrics();
            this.mTmpDisplayFrame.set(0, i19, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        appRootView.getLocationOnScreen(this.mTmpAppPos);
        view.getLocationOnScreen(this.mTmpAnchorPos);
        int[] iArr = this.mTmpAnchorPos;
        int i26 = iArr[0];
        int[] iArr2 = this.mTmpAppPos;
        int i27 = i26 - iArr2[0];
        iArr[0] = i27;
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (i27 + i3) - (appRootView.getWidth() / 2);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mContentView.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = this.mContentView.getMeasuredHeight();
        int i28 = this.mTmpAnchorPos[1];
        int i29 = ((i17 + i28) - dimensionPixelOffset3) - measuredHeight;
        int i36 = i28 + height + dimensionPixelOffset3;
        if (z16) {
            if (i29 >= 0) {
                layoutParams.y = i29;
                return;
            } else {
                layoutParams.y = i36;
                return;
            }
        }
        if (measuredHeight + i36 <= this.mTmpDisplayFrame.height()) {
            layoutParams.y = i36;
        } else {
            layoutParams.y = i29;
        }
    }

    private static View getAppRootView(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hide() {
        if (!isShowing()) {
            return;
        }
        ((WindowManager) this.mContext.getSystemService("window")).removeView(this.mContentView);
    }

    boolean isShowing() {
        if (this.mContentView.getParent() != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void show(View view, int i3, int i16, boolean z16, CharSequence charSequence) {
        if (isShowing()) {
            hide();
        }
        this.mMessageView.setText(charSequence);
        computePosition(view, i3, i16, z16, this.mLayoutParams);
        ((WindowManager) this.mContext.getSystemService("window")).addView(this.mContentView, this.mLayoutParams);
    }
}
