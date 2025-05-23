package com.tenpay.api;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletFeatureApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tenpay.QwLog;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes27.dex */
public class MyKeyboardWindow extends LinearLayout {
    private static final String TAG = "MyKeyboardWindow";
    public static final int X_MODE_CHARACTER = 1;
    public static final int X_MODE_DONE = 3;
    public static final int X_MODE_DOT = 4;
    public static final int X_MODE_NEXT = 2;
    public static final int X_MODE_NONE = 0;
    private View.OnClickListener keyListener;
    private EditText mInputEditText;
    private Button mKey0;
    private Button mKey1;
    private Button mKey2;
    private Button mKey3;
    private Button mKey4;
    private Button mKey5;
    private Button mKey6;
    private Button mKey7;
    private Button mKey8;
    private Button mKey9;
    private ImageButton mKeyD;
    private Button mKeyX;
    private int mXMode;

    public MyKeyboardWindow(Context context) {
        super(context);
        this.mXMode = 0;
        this.keyListener = new View.OnClickListener() { // from class: com.tenpay.api.MyKeyboardWindow.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i3;
                EventCollector.getInstance().onViewClickedBefore(view);
                if (MyKeyboardWindow.this.mInputEditText != null) {
                    if (view.getId() == R.id.je6) {
                        int i16 = MyKeyboardWindow.this.mXMode;
                        if (i16 != 1) {
                            if (i16 != 2) {
                                if (i16 != 3) {
                                    if (i16 == 4) {
                                        MyKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(0, 56));
                                        MyKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(1, 56));
                                    }
                                } else {
                                    MyKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(0L, 0L, 0, 66, 0, 0, 0, 0, 16));
                                }
                            } else {
                                View focusSearch = MyKeyboardWindow.this.mInputEditText.focusSearch(130);
                                while (focusSearch != null && !(focusSearch instanceof EditText)) {
                                    focusSearch = focusSearch.focusSearch(130);
                                }
                                if (focusSearch != null) {
                                    focusSearch.requestFocus();
                                }
                            }
                        } else {
                            MyKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(0, 59));
                            MyKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(0, 52));
                            MyKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(1, 59));
                        }
                    } else {
                        if (view.getId() == R.id.jdw) {
                            i3 = 8;
                        } else if (view.getId() == R.id.jdx) {
                            i3 = 9;
                        } else if (view.getId() == R.id.jdy) {
                            i3 = 10;
                        } else if (view.getId() == R.id.jdz) {
                            i3 = 11;
                        } else if (view.getId() == R.id.f166954je0) {
                            i3 = 12;
                        } else if (view.getId() == R.id.f166955je1) {
                            i3 = 13;
                        } else if (view.getId() == R.id.f166956je2) {
                            i3 = 14;
                        } else if (view.getId() == R.id.f166957je3) {
                            i3 = 15;
                        } else if (view.getId() == R.id.f166958je4) {
                            i3 = 16;
                        } else if (view.getId() == R.id.jdv) {
                            i3 = 7;
                        } else if (view.getId() == R.id.je5) {
                            i3 = 67;
                        } else {
                            i3 = 0;
                        }
                        MyKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(0, i3));
                        MyKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(1, i3));
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.afd, (ViewGroup) this, true);
        this.mKey1 = (Button) inflate.findViewById(R.id.jdw);
        this.mKey2 = (Button) inflate.findViewById(R.id.jdx);
        this.mKey3 = (Button) inflate.findViewById(R.id.jdy);
        this.mKey4 = (Button) inflate.findViewById(R.id.jdz);
        this.mKey5 = (Button) inflate.findViewById(R.id.f166954je0);
        this.mKey6 = (Button) inflate.findViewById(R.id.f166955je1);
        this.mKey7 = (Button) inflate.findViewById(R.id.f166956je2);
        this.mKey8 = (Button) inflate.findViewById(R.id.f166957je3);
        this.mKey9 = (Button) inflate.findViewById(R.id.f166958je4);
        this.mKeyX = (Button) inflate.findViewById(R.id.je6);
        this.mKey0 = (Button) inflate.findViewById(R.id.jdv);
        this.mKeyD = (ImageButton) inflate.findViewById(R.id.je5);
        if (Build.VERSION.SDK_INT <= 29 || ((IQWalletFeatureApi) QRoute.api(IQWalletFeatureApi.class)).isFeatureSwitch(IQWalletFeatureApi.QWALLET_KEY_BOARD_ACCESSIBLE)) {
            View.AccessibilityDelegate accessibilityDelegate = new View.AccessibilityDelegate() { // from class: com.tenpay.api.MyKeyboardWindow.2
                @Override // android.view.View.AccessibilityDelegate
                public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    return false;
                }

                @Override // android.view.View.AccessibilityDelegate
                public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
                    return null;
                }

                @Override // android.view.View.AccessibilityDelegate
                public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return false;
                }

                @Override // android.view.View.AccessibilityDelegate
                public boolean performAccessibilityAction(View view, int i3, Bundle bundle) {
                    return false;
                }

                @Override // android.view.View.AccessibilityDelegate
                public void sendAccessibilityEvent(View view, int i3) {
                    if (view != null && view.getContentDescription() != null && i3 == 128) {
                        TTSUtil.speak(MyKeyboardWindow.this.getContext(), view.getContentDescription().toString());
                        try {
                            Method method = View.class.getMethod("requestAccessibilityFocus", new Class[0]);
                            method.setAccessible(true);
                            method.invoke(view, new Object[0]);
                        } catch (Exception e16) {
                            QLog.e(MyKeyboardWindow.TAG, 1, "", e16);
                        }
                    }
                }

                @Override // android.view.View.AccessibilityDelegate
                public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                }

                @Override // android.view.View.AccessibilityDelegate
                public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                }

                @Override // android.view.View.AccessibilityDelegate
                public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                }

                @Override // android.view.View.AccessibilityDelegate
                public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                }
            };
            this.mKey1.setAccessibilityDelegate(accessibilityDelegate);
            this.mKey2.setAccessibilityDelegate(accessibilityDelegate);
            this.mKey3.setAccessibilityDelegate(accessibilityDelegate);
            this.mKey4.setAccessibilityDelegate(accessibilityDelegate);
            this.mKey5.setAccessibilityDelegate(accessibilityDelegate);
            this.mKey6.setAccessibilityDelegate(accessibilityDelegate);
            this.mKey7.setAccessibilityDelegate(accessibilityDelegate);
            this.mKey8.setAccessibilityDelegate(accessibilityDelegate);
            this.mKey9.setAccessibilityDelegate(accessibilityDelegate);
            this.mKey0.setAccessibilityDelegate(accessibilityDelegate);
            this.mKeyX.setAccessibilityDelegate(accessibilityDelegate);
            this.mKeyD.setAccessibilityDelegate(accessibilityDelegate);
        }
        this.mKey1.setOnClickListener(this.keyListener);
        this.mKey2.setOnClickListener(this.keyListener);
        this.mKey3.setOnClickListener(this.keyListener);
        this.mKey4.setOnClickListener(this.keyListener);
        this.mKey5.setOnClickListener(this.keyListener);
        this.mKey6.setOnClickListener(this.keyListener);
        this.mKey7.setOnClickListener(this.keyListener);
        this.mKey8.setOnClickListener(this.keyListener);
        this.mKey9.setOnClickListener(this.keyListener);
        this.mKeyX.setOnClickListener(this.keyListener);
        this.mKey0.setOnClickListener(this.keyListener);
        this.mKeyD.setOnClickListener(this.keyListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        TTSUtil.stop();
    }

    public void setInputEditText(EditText editText) {
        QwLog.i("editText = " + editText);
        if (editText != null) {
            this.mInputEditText = editText;
            int imeOptions = editText.getImeOptions();
            CharSequence imeActionLabel = this.mInputEditText.getImeActionLabel();
            if (!TextUtils.isEmpty(imeActionLabel)) {
                this.mKeyX.setText(imeActionLabel);
            }
            if (imeOptions != 1) {
                if (imeOptions != 5) {
                    if (imeOptions == 6) {
                        this.mXMode = 3;
                        if (TextUtils.isEmpty(imeActionLabel)) {
                            this.mKeyX.setText("\u5b8c\u6210");
                            this.mKeyX.setContentDescription("\u5b8c\u6210");
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.mXMode = 2;
                if (TextUtils.isEmpty(imeActionLabel)) {
                    this.mKeyX.setText("\u4e0b\u4e00\u9879");
                    this.mKeyX.setContentDescription("\u4e0b\u4e00\u9879");
                    return;
                }
                return;
            }
            this.mXMode = 0;
            if (TextUtils.isEmpty(imeActionLabel)) {
                this.mKeyX.setText("");
                this.mKeyX.setContentDescription("");
            }
        }
    }

    public void setXMode(int i3) {
        this.mXMode = i3;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            this.mXMode = 0;
                            return;
                        } else {
                            this.mKeyX.setText(".");
                            this.mKeyX.setContentDescription("\u5c0f\u6570\u70b9");
                            return;
                        }
                    }
                    this.mKeyX.setText("\u5b8c\u6210");
                    this.mKeyX.setContentDescription("\u5b8c\u6210");
                    return;
                }
                this.mKeyX.setText("\u4e0b\u4e00\u9879");
                this.mKeyX.setContentDescription("\u4e0b\u4e00\u9879");
                return;
            }
            this.mKeyX.setText("\u5b57\u6bcdX");
            this.mKeyX.setContentDescription("\u5b57\u6bcdX");
            return;
        }
        this.mKeyX.setText("");
    }

    public MyKeyboardWindow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mXMode = 0;
        this.keyListener = new View.OnClickListener() { // from class: com.tenpay.api.MyKeyboardWindow.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i3;
                EventCollector.getInstance().onViewClickedBefore(view);
                if (MyKeyboardWindow.this.mInputEditText != null) {
                    if (view.getId() == R.id.je6) {
                        int i16 = MyKeyboardWindow.this.mXMode;
                        if (i16 != 1) {
                            if (i16 != 2) {
                                if (i16 != 3) {
                                    if (i16 == 4) {
                                        MyKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(0, 56));
                                        MyKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(1, 56));
                                    }
                                } else {
                                    MyKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(0L, 0L, 0, 66, 0, 0, 0, 0, 16));
                                }
                            } else {
                                View focusSearch = MyKeyboardWindow.this.mInputEditText.focusSearch(130);
                                while (focusSearch != null && !(focusSearch instanceof EditText)) {
                                    focusSearch = focusSearch.focusSearch(130);
                                }
                                if (focusSearch != null) {
                                    focusSearch.requestFocus();
                                }
                            }
                        } else {
                            MyKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(0, 59));
                            MyKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(0, 52));
                            MyKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(1, 59));
                        }
                    } else {
                        if (view.getId() == R.id.jdw) {
                            i3 = 8;
                        } else if (view.getId() == R.id.jdx) {
                            i3 = 9;
                        } else if (view.getId() == R.id.jdy) {
                            i3 = 10;
                        } else if (view.getId() == R.id.jdz) {
                            i3 = 11;
                        } else if (view.getId() == R.id.f166954je0) {
                            i3 = 12;
                        } else if (view.getId() == R.id.f166955je1) {
                            i3 = 13;
                        } else if (view.getId() == R.id.f166956je2) {
                            i3 = 14;
                        } else if (view.getId() == R.id.f166957je3) {
                            i3 = 15;
                        } else if (view.getId() == R.id.f166958je4) {
                            i3 = 16;
                        } else if (view.getId() == R.id.jdv) {
                            i3 = 7;
                        } else if (view.getId() == R.id.je5) {
                            i3 = 67;
                        } else {
                            i3 = 0;
                        }
                        MyKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(0, i3));
                        MyKeyboardWindow.this.mInputEditText.dispatchKeyEvent(new KeyEvent(1, i3));
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
        init(context);
    }
}
