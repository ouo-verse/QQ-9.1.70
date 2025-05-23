package com.tenpay.sdk.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.QwLog;
import com.tenpay.api.MyKeyboardWindow;
import com.tenpay.proxy.QUIProxy;
import com.tenpay.sdk.view.ClearableEditText;
import com.tenpay.util.Utils;
import java.io.File;

/* compiled from: P */
/* loaded from: classes27.dex */
public class UIUtils {
    public static final int COLOE_NONE = 17170445;
    public static final int CORNER_TYPE_ALL = 3;
    public static final int CORNER_TYPE_BOTTOM = 2;
    public static final int CORNER_TYPE_TOP = 1;
    public static final int ID_NONE = -1;
    private static final int SAVE_H = 1080;
    private static final int SAVE_W = 720;
    private static final String TAG = "UIUtils";
    public static final int TITLE_BAR_STYLE_DEFAULT = 0;
    public static final int TITLE_BAR_STYLE_WHITE = 1;

    public static View addChooseLocalItem(LayoutInflater layoutInflater, ViewGroup viewGroup, int i3, String str, boolean z16) {
        int i16 = 0;
        View inflate = layoutInflater.inflate(R.layout.adh, viewGroup, false);
        viewGroup.addView(inflate);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.b5r);
        TextView textView = (TextView) inflate.findViewById(R.id.b5o);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.b5p);
        if (i3 > 0) {
            imageView.setImageResource(i3);
        }
        textView.setText(str);
        if (!z16) {
            i16 = 8;
        }
        imageView2.setVisibility(i16);
        return inflate;
    }

    public static ColorStateList generateSelectorColor(int i3, int i16, int i17) {
        return new ColorStateList(new int[][]{new int[]{i17}, new int[0]}, new int[]{i16, i3});
    }

    public static Drawable generateSelectorDrawable(Drawable drawable, Drawable drawable2, int i3) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{i3}, drawable2);
        stateListDrawable.addState(new int[0], drawable);
        return stateListDrawable;
    }

    public static GradientDrawable getCornerBg(Context context, int i3, int i16, int i17) {
        float[] fArr;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(context.getResources().getColor(i16));
        float dp2Px = Utils.dp2Px(context, i17);
        if (i3 == 1) {
            fArr = new float[]{dp2Px, dp2Px, dp2Px, dp2Px, 0.0f, 0.0f, 0.0f, 0.0f};
        } else if (i3 == 2) {
            fArr = new float[]{0.0f, 0.0f, 0.0f, 0.0f, dp2Px, dp2Px, dp2Px, dp2Px};
        } else {
            fArr = new float[]{dp2Px, dp2Px, dp2Px, dp2Px, dp2Px, dp2Px, dp2Px, dp2Px};
        }
        gradientDrawable.setCornerRadii(fArr);
        return gradientDrawable;
    }

    public static void handleFocusChange(final MyKeyboardWindow myKeyboardWindow, final View view, boolean z16, final int i3) {
        if (z16) {
            if (view instanceof ClearableEditText) {
                ((ClearableEditText) view).manageClearButton();
            }
            InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
            view.postDelayed(new Runnable() { // from class: com.tenpay.sdk.util.UIUtils.4
                @Override // java.lang.Runnable
                public void run() {
                    MyKeyboardWindow.this.setXMode(i3);
                    MyKeyboardWindow.this.setVisibility(0);
                    MyKeyboardWindow.this.setInputEditText((EditText) view);
                }
            }, 100L);
            return;
        }
        if (view instanceof ClearableEditText) {
            ((ClearableEditText) view).removeClearButton();
        }
        myKeyboardWindow.setVisibility(8);
    }

    public static void initTitleBar(ViewGroup viewGroup, int i3, int i16, String str, String str2, int i17) {
        if (viewGroup == null) {
            QwLog.i("error set title bar, root_statebur is null...");
            return;
        }
        if (17170445 != i3) {
            viewGroup.setBackgroundColor(i3);
        }
        final Resources resources = viewGroup.getContext().getResources();
        final TextView textView = (TextView) viewGroup.findViewById(R.id.ivTitleBtnLeft);
        final TextView textView2 = (TextView) viewGroup.findViewById(R.id.ivTitleBtnRightText);
        final TextView textView3 = (TextView) viewGroup.findViewById(R.id.ivTitleName);
        textView3.setText(str2);
        if (-1 != i17) {
            ((ImageView) viewGroup.findViewById(R.id.ivTitleBtnRightMore)).setBackgroundResource(i17);
        }
        if (i16 == 1) {
            textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ap5, 0, 0, 0);
            textView.post(new Runnable() { // from class: com.tenpay.sdk.util.UIUtils.1
                @Override // java.lang.Runnable
                public void run() {
                    int color = resources.getColor(R.color.a4o);
                    QwLog.i("set text color start...");
                    textView.setTextColor(color);
                    textView3.setTextColor(color);
                    textView2.setTextColor(color);
                    QwLog.i("set text color end...");
                }
            });
        }
    }

    public static boolean isInView(MotionEvent motionEvent, View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (rawX < iArr[0] || rawX > r3 + view.getWidth()) {
            return false;
        }
        if (rawY < iArr[1] || rawY > r0 + view.getHeight()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$saveFace2FaceCode$0(Bitmap bitmap, Handler handler, final Activity activity) {
        String str = Utils.getImagePath() + "qrcode_" + Utils.getCurrentTime() + ".png";
        boolean saveBitmapToFile = Utils.saveBitmapToFile(bitmap, str, Bitmap.CompressFormat.PNG, 100);
        QwLog.i("isOk = " + saveBitmapToFile);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        if (!saveBitmapToFile) {
            return;
        }
        handler.post(new Runnable() { // from class: com.tenpay.sdk.util.UIUtils.2
            @Override // java.lang.Runnable
            public void run() {
                DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.util.UIUtils.2.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        dialogInterface.dismiss();
                    }
                };
                Activity activity2 = activity;
                QUIProxy.createCustomDialog(activity2, 230, activity2.getString(R.string.e5l), activity.getString(R.string.f2184063m), activity.getString(R.string.e5j), null, null, onClickListener);
            }
        });
        try {
            MediaScannerConnection.scanFile(activity, new String[]{new File(str).toString()}, new String[]{"image/png"}, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.tenpay.sdk.util.UIUtils.3
                @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                public void onScanCompleted(String str2, Uri uri) {
                    QwLog.d("onScanCompleted, path=" + str2 + ", uri=" + uri);
                }
            });
        } catch (Throwable th5) {
            QwLog.e("MediaScannerConnection scanFile throw an exception: " + th5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void saveFace2FaceCode(final Activity activity, LayoutInflater layoutInflater, ViewGroup viewGroup, Bitmap bitmap, Bitmap bitmap2, String str, String str2, final Handler handler) {
        final Bitmap bitmap3;
        View inflate = layoutInflater.inflate(R.layout.adv, viewGroup, false);
        if (!TextUtils.isEmpty(str)) {
            QwLog.i("set amount = " + str);
            Float valueOf = Float.valueOf(str);
            View findViewById = inflate.findViewById(R.id.f164309rr);
            findViewById.setVisibility(0);
            ((TextView) findViewById.findViewById(R.id.fj7)).setText(String.format("%.2f", valueOf));
            if (!TextUtils.isEmpty(str2)) {
                TextView textView = (TextView) findViewById.findViewById(R.id.fje);
                textView.setVisibility(0);
                textView.setText(str2);
            }
        }
        ImageView imageView = (ImageView) inflate.findViewById(R.id.jv_);
        imageView.setImageBitmap(bitmap);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.f100765td);
        if (bitmap2 != null) {
            imageView2.setImageBitmap(bitmap2);
        }
        ((TextView) inflate.findViewById(R.id.klg)).setText(com.tencent.mobileqq.base.a.b());
        inflate.measure(View.MeasureSpec.makeMeasureSpec(720, 1073741824), View.MeasureSpec.makeMeasureSpec(1080, 1073741824));
        inflate.layout(0, 0, 720, 1080);
        QwLog.i("saveImg.w = " + inflate.getWidth() + " saveImg.h = " + inflate.getHeight());
        try {
            bitmap3 = Bitmap.createBitmap(inflate.getWidth(), inflate.getHeight(), Bitmap.Config.ARGB_8888);
        } catch (Exception e16) {
            e = e16;
            bitmap3 = null;
        } catch (OutOfMemoryError e17) {
            e = e17;
            bitmap3 = null;
        }
        try {
            inflate.draw(new Canvas(bitmap3));
            imageView.setImageBitmap(null);
            imageView2.setImageBitmap(null);
        } catch (Exception e18) {
            e = e18;
            QLog.e(TAG, 1, "", e);
            if (bitmap3 == null) {
            }
        } catch (OutOfMemoryError e19) {
            e = e19;
            QLog.e(TAG, 1, "", e);
            if (bitmap3 == null) {
            }
        }
        if (bitmap3 == null) {
            QwLog.i("bmp is null...");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tenpay.sdk.util.i
                @Override // java.lang.Runnable
                public final void run() {
                    UIUtils.lambda$saveFace2FaceCode$0(bitmap3, handler, activity);
                }
            }, 64, null, false);
        }
    }
}
