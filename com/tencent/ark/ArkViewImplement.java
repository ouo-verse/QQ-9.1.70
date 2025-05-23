package com.tencent.ark;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.tencent.ark.ArkViewModelBase;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ArkViewImplement {
    public static final int INPUTCOMMAD_COPY = 4;
    public static final int INPUTCOMMAD_CUT = 5;
    public static final int INPUTCOMMAD_PASTE = 3;
    public static final int INPUTCOMMAD_SELECT = 1;
    public static final int INPUTCOMMAD_SELECTALL = 2;
    public static final int STATE_LOADING = 0;
    public static final int STATE_LOAD_FAILED = -1;
    public static final int STATE_LOAD_SUCCESS = 1;
    protected static final String TAG = "ArkApp.ArkViewImplement";
    public static final float TRIANGLE_WIDTH = 10.0f;
    static final Paint sPaintCanvas;
    static final Paint sPaintPath;
    protected View mArkView;
    private ArkViewModel mArkViewModel;
    private ScaleGestureDetector mScaleGestureDetector;
    protected ArkViewInterface mViewInterface;
    protected static final ArkEnvironmentManager ENV = ArkEnvironmentManager.getInstance();
    static final Paint sPaint = new Paint(3);
    static final Paint sPaintOpaque = new Paint(3);
    public Rect mRectView = new Rect();
    public float mScale = 1.0f;
    public float mClipRadiusTop = 6.0f;
    public float mClipRadius = 6.0f;
    public boolean mAlignLeft = false;
    private boolean mLongClickTriggered = false;
    public boolean mRound = false;
    public boolean mOpaque = false;
    protected InputMethodManager mImm = null;
    protected boolean mInputFocus = false;
    protected InputCallback mInputCallback = null;
    protected Rect mInputRect = new Rect();
    protected int mHolderWidth = 0;
    protected int mHolderHeight = 0;
    protected boolean mIpnutNeedHide = false;
    protected boolean mInputReadOnly = false;
    protected int mInputType = 0;
    public int mPreferredHeight = 0;
    public int mBorderType = 1;
    protected int mLoadState = 0;
    LoadCallback mLoadCallback = null;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class ArkInputConnection extends BaseInputConnection {
        ArkViewImplement mHolder;

        public ArkInputConnection(View view, ArkViewImplement arkViewImplement, boolean z16) {
            super(view, z16);
            this.mHolder = arkViewImplement;
        }

        @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
        public boolean commitText(CharSequence charSequence, int i3) {
            this.mHolder.setInputText(charSequence);
            return true;
        }

        @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int i3, int i16) {
            int i17;
            if (i16 == 0) {
                while (true) {
                    i17 = i3 - 1;
                    if (i3 <= 0) {
                        break;
                    }
                    this.mHolder.deleteInputText();
                    i3 = i17;
                }
                i3 = i17;
            }
            return super.deleteSurroundingText(i3, i16);
        }

        @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
        public boolean sendKeyEvent(KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (keyCode == 67) {
                    this.mHolder.deleteInputText();
                } else if (keyCode == 66) {
                    this.mHolder.setInputText("\n");
                } else if ((keyCode >= 7 && keyCode <= 18) || (keyCode >= 55 && keyCode <= 56)) {
                    this.mHolder.setInputText(Character.toString((char) keyEvent.getUnicodeChar()));
                }
            }
            return super.sendKeyEvent(keyEvent);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface ArkViewInterface {
        void checkSurfaceAvailable();

        void createViewContext();

        void destroyBitmapBuffer();

        void doDetach(ArkViewModel arkViewModel);

        void doInputCommand(int i3);

        Bitmap getBitmapBuffer();

        Rect getInputRect();

        View getView();

        void initArkView(ArkViewModel arkViewModel);

        void initArkView(ArkViewModel arkViewModel, boolean z16);

        void onFirstPaint();

        boolean onInvalidate(Rect rect);

        void onLoadFailed(String str, int i3, boolean z16);

        void onLoadSuccess();

        void onLoading();

        boolean onLongClick(View view);

        boolean onTouch(View view, MotionEvent motionEvent);

        Bitmap recreateBitmapBuffer(Rect rect);

        void releaseViewContext();

        void setAlignLeft(boolean z16);

        void setBorderType(int i3);

        void setClipRadius(float f16);

        void setClipRadiusTop(float f16);

        void setContentDescription(CharSequence charSequence);

        void setFixSize(int i3, int i16);

        void setInputCallback(InputCallback inputCallback);

        void setInputSetCaretHolderSize(int i3, int i16);

        void setInputSetSelectHolderSize(int i3, int i16);

        void setLoadCallback(LoadCallback loadCallback);

        void setMaxSize(int i3, int i16);

        void setMinSize(int i3, int i16);

        void setOnLongClickListener(View.OnLongClickListener onLongClickListener);

        void setOnTouchListener(View.OnTouchListener onTouchListener);

        void setViewRect(int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface InputCallback {
        void onFocusChanged(View view, boolean z16);

        void onHideMenu(View view);

        void onSelectChanged(View view, int i3, int i16, int i17, int i18);

        void onShowMenu(View view, int i3, int i16, int i17, int i18);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface LoadCallback {
        void onLoadFailed(int i3, int i16, String str, boolean z16);

        void onLoadState(int i3);
    }

    static {
        Paint paint = new Paint(1);
        sPaintPath = paint;
        Paint paint2 = new Paint();
        sPaintCanvas = paint2;
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setColor(0);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArkViewImplement(View view, ArkViewInterface arkViewInterface) {
        this.mArkView = view;
        this.mViewInterface = arkViewInterface;
        view.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tencent.ark.ArkViewImplement.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z16) {
                ArkViewImplement arkViewImplement = ArkViewImplement.this;
                if (arkViewImplement.mArkView == view2) {
                    InputMethodManager inputMethodManager = arkViewImplement.mImm;
                }
            }
        });
        this.mArkView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.ark.ArkViewImplement.2
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view2, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                ArkViewImplement arkViewImplement = ArkViewImplement.this;
                View view3 = arkViewImplement.mArkView;
                if (view2 == view3) {
                    if (i3 != i19 || i17 != i27 || i16 != i26 || i18 != i28) {
                        InputCallback inputCallback = arkViewImplement.mInputCallback;
                        if (inputCallback != null) {
                            inputCallback.onHideMenu(view3);
                            ArkViewImplement arkViewImplement2 = ArkViewImplement.this;
                            arkViewImplement2.mInputCallback.onSelectChanged(arkViewImplement2.mArkView, 0, 0, 0, 0);
                        }
                        ArkViewImplement.this.mIpnutNeedHide = true;
                        ArkDispatchTask.getInstance().postToMainThreadDelayed(new Runnable() { // from class: com.tencent.ark.ArkViewImplement.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ArkViewImplement.this.mIpnutNeedHide = false;
                            }
                        }, 800L);
                    }
                }
            }
        });
    }

    private static int dp2px(float f16, Resources resources) {
        return (int) ((f16 * resources.getDisplayMetrics().density) + 0.5f);
    }

    private void handleScaleGesture(View view, MotionEvent motionEvent) {
        if (this.mScaleGestureDetector == null) {
            this.mScaleGestureDetector = new ScaleGestureDetector(view.getContext(), new ScaleGestureDetector.OnScaleGestureListener() { // from class: com.tencent.ark.ArkViewImplement.3
                @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
                public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                    ClipboardManager clipboardManager;
                    ArkViewImplement arkViewImplement = ArkViewImplement.this;
                    if (arkViewImplement.mArkView == null || arkViewImplement.mArkViewModel == null || (clipboardManager = (ClipboardManager) ArkViewImplement.this.mArkView.getContext().getSystemService("clipboard")) == null) {
                        return false;
                    }
                    String appInfo = ArkViewImplement.this.mArkViewModel.mAppInfo.toString();
                    ClipboardMonitor.setPrimaryClip(clipboardManager, ClipData.newPlainText("text", appInfo));
                    Toast.makeText(ArkViewImplement.this.mArkView.getContext(), "\u5df2\u590d\u5236\u5230\u526a\u5207\u677f", 0).show();
                    Logger.logD(ArkViewImplement.TAG, "ArkDebugLongClick " + appInfo);
                    return true;
                }

                @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
                public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                    return true;
                }

                @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
                public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
                }
            });
        }
        this.mScaleGestureDetector.onTouchEvent(motionEvent);
    }

    public void checkSurfaceAvailable() {
        this.mViewInterface.checkSurfaceAvailable();
    }

    protected void deleteInputText() {
        ArkViewModel arkViewModel = this.mArkViewModel;
        if (arkViewModel == null) {
            return;
        }
        arkViewModel.SafeAsyncRun(new Runnable() { // from class: com.tencent.ark.ArkViewImplement.7
            @Override // java.lang.Runnable
            public void run() {
                if (ArkViewImplement.this.mArkViewModel != null) {
                    ArkViewImplement.this.mArkViewModel.InputDeleteBackward();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void destroyBitmapBuffer() {
        ArkViewInterface arkViewInterface = this.mViewInterface;
        if (arkViewInterface != null) {
            arkViewInterface.destroyBitmapBuffer();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doDetach(ArkViewModelBase arkViewModelBase) {
        this.mViewInterface.releaseViewContext();
        if (arkViewModelBase == this.mArkViewModel) {
            this.mArkViewModel = null;
        }
        resetInputState();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doInputCommand(final int i3) {
        final String str;
        ArkViewModel arkViewModel;
        if (i3 == 3) {
            android.text.ClipboardManager clipboardManager = (android.text.ClipboardManager) this.mArkView.getContext().getSystemService("clipboard");
            if (clipboardManager.getText() != null) {
                str = clipboardManager.getText().toString();
                arkViewModel = this.mArkViewModel;
                if (arkViewModel != null) {
                    return;
                }
                arkViewModel.SafeAsyncRun(new Runnable() { // from class: com.tencent.ark.ArkViewImplement.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ArkViewImplement.this.mArkViewModel == null) {
                            return;
                        }
                        int i16 = i3;
                        if (i16 != 1) {
                            if (i16 != 2) {
                                if (i16 != 3) {
                                    if (i16 != 4) {
                                        if (i16 == 5) {
                                            final String InputGetSelectText = ArkViewImplement.this.mArkViewModel.InputGetSelectText();
                                            ArkDispatchTask.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.ark.ArkViewImplement.8.2
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    ((android.text.ClipboardManager) ArkViewImplement.this.mArkView.getContext().getSystemService("clipboard")).setText(InputGetSelectText);
                                                }
                                            });
                                            ArkViewImplement.this.mArkViewModel.InputDeleteBackward();
                                            return;
                                        }
                                        return;
                                    }
                                    final String InputGetSelectText2 = ArkViewImplement.this.mArkViewModel.InputGetSelectText();
                                    ArkDispatchTask.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.ark.ArkViewImplement.8.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            ((android.text.ClipboardManager) ArkViewImplement.this.mArkView.getContext().getSystemService("clipboard")).setText(InputGetSelectText2);
                                        }
                                    });
                                    return;
                                }
                                ArkViewImplement.this.mArkViewModel.InputInsertText(str);
                                return;
                            }
                            ArkViewImplement.this.mArkViewModel.InputSelectAll();
                            return;
                        }
                        ArkViewImplement.this.mArkViewModel.InputSelect();
                    }
                });
                return;
            }
        }
        str = "";
        arkViewModel = this.mArkViewModel;
        if (arkViewModel != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean doOnLongClick(View view) {
        if (this.mArkViewModel == null) {
            return false;
        }
        this.mLongClickTriggered = true;
        resetInputState();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean doOnTouch(View view, MotionEvent motionEvent) {
        if (this.mArkViewModel == null) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.mLongClickTriggered && actionMasked == 1) {
            this.mLongClickTriggered = false;
            return false;
        }
        int x16 = (int) (motionEvent.getX() / this.mScale);
        int y16 = (int) (motionEvent.getY() / this.mScale);
        if (this.mInputFocus && this.mArkView.getParent() != null && ptInInputArea(x16, y16)) {
            this.mArkView.getParent().requestDisallowInterceptTouchEvent(true);
            if (this.mImm != null && !this.mInputReadOnly) {
                this.mArkView.requestFocus();
                this.mImm.showSoftInput(this.mArkView, 0);
            }
        }
        if (Utils.isScaleGestureLogEnable(view.getContext().getApplicationContext())) {
            handleScaleGesture(view, motionEvent);
        }
        return this.mArkViewModel.onTouch(view, motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean doOnViewEvent(String str, String str2) {
        ArkViewModel arkViewModel = this.mArkViewModel;
        if (arkViewModel == null) {
            Logger.logE(TAG, "doOnViewEvent mArkViewModel is null");
            return false;
        }
        return arkViewModel.onViewEvent(str, str2);
    }

    public View getArkView() {
        return this.mArkView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap getBitmapBuffer() {
        ArkViewInterface arkViewInterface = this.mViewInterface;
        if (arkViewInterface == null) {
            return null;
        }
        return arkViewInterface.getBitmapBuffer();
    }

    public Rect getInputRect() {
        ArkViewModel arkViewModel = this.mArkViewModel;
        if (arkViewModel != null) {
            return arkViewModel.scaleRect(this.mInputRect);
        }
        return new Rect();
    }

    public View getView() {
        return this.mViewInterface.getView();
    }

    public ArkViewModel getViewModel() {
        return this.mArkViewModel;
    }

    void initArkView(ArkViewModel arkViewModel) {
        initArkView(arkViewModel, true);
    }

    public void makePath(RectF rectF, Path path) {
        int i3 = this.mBorderType;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        float f16 = this.mClipRadiusTop;
                        float f17 = this.mScale;
                        float f18 = f16 * f17 * 2.0f;
                        float f19 = this.mClipRadius * f17 * 2.0f;
                        RectF rectF2 = new RectF();
                        float f26 = rectF.left;
                        rectF2.right = f26 + f18;
                        float f27 = rectF.top;
                        rectF2.bottom = f27 + f18;
                        rectF2.left = f26;
                        rectF2.top = f27;
                        path.arcTo(rectF2, 270.0f, -90.0f);
                        rectF2.right = rectF.left + f19;
                        rectF2.bottom = rectF.bottom;
                        rectF2.top = rectF.bottom - f19;
                        path.arcTo(rectF2, 180.0f, -90.0f);
                        rectF2.right = rectF.right;
                        rectF2.left = rectF.right - f19;
                        rectF2.top = rectF.bottom - f19;
                        path.arcTo(rectF2, 90.0f, -90.0f);
                        float f28 = rectF.top;
                        rectF2.bottom = f28 + f18;
                        rectF2.left = rectF.right - f18;
                        rectF2.top = f28;
                        path.arcTo(rectF2, 0.0f, -90.0f);
                        path.close();
                        return;
                    }
                    return;
                }
                Resources resources = this.mArkView.getResources();
                float dp2px = dp2px(10.0f, resources);
                float f29 = this.mClipRadius * this.mScale * 2.0f;
                float dp2px2 = dp2px(5.0f, resources);
                if (this.mAlignLeft) {
                    rectF.left += dp2px;
                    rectF.right -= dp2px;
                    float dp2px3 = dp2px(12.0f, resources);
                    float dp2px4 = dp2px(8.0f, resources);
                    float dp2px5 = dp2px(4.0f, resources);
                    float dp2px6 = dp2px(10.0f, resources);
                    float dp2px7 = dp2px(10.0f, resources);
                    float dp2px8 = dp2px(16.0f, resources);
                    float dp2px9 = dp2px(1.0f, resources);
                    float dp2px10 = dp2px(14.0f, resources);
                    RectF rectF3 = new RectF();
                    path.moveTo(dp2px3, dp2px4);
                    path.quadTo(dp2px5, dp2px6, 0.0f, dp2px2);
                    path.quadTo(dp2px9, dp2px10, dp2px7, dp2px8);
                    float f36 = rectF.left;
                    rectF3.right = f36 + f29;
                    rectF3.bottom = rectF.bottom;
                    rectF3.left = f36;
                    rectF3.top = rectF.bottom - f29;
                    path.arcTo(rectF3, 180.0f, -90.0f);
                    rectF3.right = rectF.right;
                    rectF3.left = rectF.right - f29;
                    path.arcTo(rectF3, 90.0f, -90.0f);
                    float f37 = rectF.top;
                    rectF3.bottom = f37 + f29;
                    rectF3.top = f37;
                    path.arcTo(rectF3, 0.0f, -90.0f);
                    float f38 = rectF.left;
                    rectF3.right = f29 + f38;
                    rectF3.left = f38;
                    path.arcTo(rectF3, 270.0f, -62.0f);
                } else {
                    float width = rectF.width();
                    rectF.left += dp2px;
                    rectF.right -= dp2px;
                    float dp2px11 = width - dp2px(12.0f, resources);
                    float dp2px12 = dp2px(8.0f, resources);
                    float dp2px13 = width - dp2px(4.0f, resources);
                    float dp2px14 = dp2px(10.0f, resources);
                    float dp2px15 = width - dp2px(10.0f, resources);
                    float dp2px16 = dp2px(16.0f, resources);
                    float dp2px17 = width - dp2px(1.0f, resources);
                    float dp2px18 = dp2px(14.0f, resources);
                    RectF rectF4 = new RectF();
                    path.moveTo(dp2px11, dp2px12);
                    path.quadTo(dp2px13, dp2px14, width, dp2px2);
                    path.quadTo(dp2px17, dp2px18, dp2px15, dp2px16);
                    rectF4.right = rectF.right;
                    rectF4.bottom = rectF.bottom;
                    rectF4.left = rectF.right - f29;
                    rectF4.top = rectF.bottom - f29;
                    path.arcTo(rectF4, 0.0f, 90.0f);
                    float f39 = rectF.left;
                    rectF4.right = f39 + f29;
                    rectF4.left = f39;
                    path.arcTo(rectF4, 90.0f, 90.0f);
                    float f46 = rectF.top;
                    rectF4.bottom = f46 + f29;
                    rectF4.top = f46;
                    path.arcTo(rectF4, 180.0f, 90.0f);
                    rectF4.right = rectF.right;
                    rectF4.left = rectF.right - f29;
                    path.arcTo(rectF4, 270.0f, 62.0f);
                }
                path.close();
                return;
            }
            float f47 = this.mClipRadius;
            float f48 = this.mScale;
            path.addRoundRect(rectF, f47 * f48, f47 * f48, Path.Direction.CCW);
            return;
        }
        path.addRect(rectF, Path.Direction.CCW);
    }

    public boolean onCheckIsTextEditor() {
        return true;
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        editorInfo.actionLabel = null;
        editorInfo.label = "TEXT";
        editorInfo.inputType = 1;
        int i3 = this.mInputType;
        if (i3 == 0) {
            editorInfo.inputType = 1;
        } else if (i3 == 1) {
            editorInfo.inputType = 128;
        } else if (i3 == 2) {
            editorInfo.inputType = 4098;
        } else if (i3 == 3) {
            editorInfo.inputType = 32;
        } else if (i3 == 4) {
            editorInfo.inputType = 8194;
        } else if (i3 == 5) {
            editorInfo.inputType = 3;
        }
        editorInfo.imeOptions = 1;
        return new ArkInputConnection(this.mArkView, this, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onDestroy() {
        InputMethodManager inputMethodManager;
        InputCallback inputCallback = this.mInputCallback;
        if (inputCallback != null) {
            inputCallback.onHideMenu(this.mArkView);
        }
        if (this.mInputFocus && (inputMethodManager = this.mImm) != null) {
            inputMethodManager.hideSoftInputFromWindow(this.mArkView.getWindowToken(), 0);
        }
        this.mScaleGestureDetector = null;
    }

    public void onFirstPaint() {
        this.mViewInterface.onFirstPaint();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onInputFocusChanged(boolean z16, boolean z17, int i3, Rect rect) {
        this.mInputFocus = z16;
        this.mInputReadOnly = z17;
        this.mInputType = i3;
        this.mInputRect = rect;
        if (this.mImm == null) {
            this.mImm = (InputMethodManager) this.mArkView.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        }
        if (z16 && !this.mInputReadOnly) {
            this.mArkView.setFocusableInTouchMode(true);
            this.mArkView.setFocusable(true);
            this.mArkView.requestFocus();
            this.mImm.restartInput(this.mArkView);
            this.mImm.showSoftInput(this.mArkView, 0);
            Logger.logI(TAG, "onInputFocusChanged showSoftInput. view: " + this);
        } else {
            this.mImm.hideSoftInputFromWindow(this.mArkView.getWindowToken(), 0);
        }
        InputCallback inputCallback = this.mInputCallback;
        if (inputCallback != null) {
            inputCallback.onFocusChanged(this.mArkView, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onInputMenuChanged(boolean z16, int i3, int i16, int i17, int i18) {
        if (this.mInputCallback == null) {
            return;
        }
        int[] iArr = new int[2];
        this.mArkView.getLocationInWindow(iArr);
        if (z16) {
            if (!this.mIpnutNeedHide) {
                this.mInputCallback.onShowMenu(this.mArkView, i3 + iArr[0], i16 + iArr[1], i17, i18);
                this.mArkView.requestFocus();
                return;
            }
            return;
        }
        this.mInputCallback.onHideMenu(this.mArkView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onInputSelectChanged(int i3, int i16, int i17, int i18, Rect rect) {
        this.mInputRect = rect;
        InputCallback inputCallback = this.mInputCallback;
        if (inputCallback != null && !this.mIpnutNeedHide) {
            inputCallback.onSelectChanged(this.mArkView, i3, i16, i17, i18);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean onInvalidate(Rect rect) {
        ArkViewInterface arkViewInterface;
        if (this.mArkViewModel != null && (arkViewInterface = this.mViewInterface) != null) {
            arkViewInterface.onInvalidate(rect);
            return true;
        }
        Logger.logE(TAG, "onInvalidate.return.1.wrapper: null uiview: " + this);
        return false;
    }

    public void onLoadFailed(String str, int i3, boolean z16) {
        Logger.logI(TAG, "onLoadFailed, this=" + this + ", mLoadCallback=" + this.mLoadCallback);
        if (str == null) {
            str = "";
        }
        this.mViewInterface.onLoadFailed(str, i3, z16);
        this.mLoadState = -1;
        LoadCallback loadCallback = this.mLoadCallback;
        if (loadCallback != null) {
            loadCallback.onLoadFailed(-1, i3, str, z16);
        }
    }

    public void onLoadSuccess() {
        this.mViewInterface.onLoadSuccess();
        Logger.logI(TAG, "onLoadSuccess, this=" + this + ", mLoadCallback=" + this.mLoadCallback);
        if (this.mArkView.getVisibility() != 0) {
            this.mArkView.setVisibility(0);
        }
        this.mViewInterface.checkSurfaceAvailable();
        this.mArkView.requestLayout();
        this.mLoadState = 1;
        LoadCallback loadCallback = this.mLoadCallback;
        if (loadCallback != null) {
            loadCallback.onLoadState(1);
        }
    }

    public void onLoading() {
        this.mViewInterface.onLoading();
        this.mLoadState = 0;
        LoadCallback loadCallback = this.mLoadCallback;
        if (loadCallback != null) {
            loadCallback.onLoadState(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onStartTemporaryDetach() {
        if (this.mArkViewModel != null) {
            if (ENV.mIsDebug) {
                Logger.logE(TAG, "onStartTemporaryDetach.wrapper: " + this.mArkViewModel + " uiview: " + this);
            }
            this.mArkViewModel.activateView(false, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onSyncRect(Rect rect) {
        ArkViewModel arkViewModel = this.mArkViewModel;
        if (arkViewModel == null) {
            Logger.logE(TAG, "onSyncRect.return.mArkViewModel: null uiview: " + this);
            return;
        }
        Rect scaleRect = arkViewModel.scaleRect(rect);
        if (!scaleRect.equals(this.mRectView)) {
            this.mRectView.set(scaleRect);
            ViewGroup.LayoutParams layoutParams = this.mArkView.getLayoutParams();
            if (layoutParams != null) {
                Logger.logI(TAG, "onSyncRect.vm." + this.mArkViewModel + ".measure.(" + this.mRectView.width() + ", " + this.mRectView.height() + "), update layout param");
                layoutParams.width = this.mRectView.width();
                layoutParams.height = this.mRectView.height();
            } else {
                Logger.logI(TAG, "onSyncRect.vm." + this.mArkViewModel + ".measure.(" + this.mRectView.width() + ", " + this.mRectView.height() + "), layout param is null");
            }
        }
        onLoadSuccess();
    }

    boolean ptInInputArea(int i3, int i16) {
        Rect rect = this.mInputRect;
        int i17 = rect.left;
        return new Rect((i17 - r3) - 10, (rect.top - this.mHolderHeight) - 10, rect.right + this.mHolderWidth + 10, rect.bottom + 10).contains(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap recreateBitmapBuffer(Rect rect) {
        ArkViewInterface arkViewInterface;
        if (!rect.isEmpty() && (arkViewInterface = this.mViewInterface) != null) {
            return arkViewInterface.recreateBitmapBuffer(rect);
        }
        Logger.logE(TAG, "recreateBitmapBuffer.return.null uiview: " + this);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void refreshDrawPath(Rect rect, Path path) {
        Path.Direction direction;
        path.reset();
        if (this.mBorderType != 0) {
            RectF rectF = new RectF(0.0f, 0.0f, rect.width(), rect.height());
            if (this.mBorderType == 2 && !this.mAlignLeft) {
                direction = Path.Direction.CCW;
            } else {
                direction = Path.Direction.CW;
            }
            path.addRect(rectF, direction);
            makePath(rectF, path);
        }
    }

    public void resetInputState() {
        InputCallback inputCallback = this.mInputCallback;
        if (inputCallback != null) {
            inputCallback.onHideMenu(this.mArkView);
            this.mInputCallback.onSelectChanged(this.mArkView, 0, 0, 0, 0);
        }
    }

    public void setFixSize(int i3, int i16) {
        ArkViewModel arkViewModel = this.mArkViewModel;
        if (arkViewModel != null) {
            arkViewModel.setFixSize(i3, i16);
        }
    }

    public void setInputSetCaretHolderSize(final int i3, final int i16) {
        ArkViewModel arkViewModel = this.mArkViewModel;
        if (arkViewModel == null) {
            return;
        }
        arkViewModel.SafeAsyncRun(new Runnable() { // from class: com.tencent.ark.ArkViewImplement.5
            @Override // java.lang.Runnable
            public void run() {
                if (ArkViewImplement.this.mArkViewModel != null) {
                    ArkViewImplement.this.mArkViewModel.InputSetCaretHolderSize(i3, i16);
                }
            }
        });
    }

    public void setInputSetSelectHolderSize(final int i3, final int i16) {
        this.mHolderWidth = i3;
        this.mHolderHeight = i16;
        ArkViewModel arkViewModel = this.mArkViewModel;
        if (arkViewModel == null) {
            return;
        }
        arkViewModel.SafeAsyncRun(new Runnable() { // from class: com.tencent.ark.ArkViewImplement.4
            @Override // java.lang.Runnable
            public void run() {
                if (ArkViewImplement.this.mArkViewModel != null) {
                    ArkViewImplement.this.mArkViewModel.InputSetSelectHolderSize(i3, i16);
                }
            }
        });
    }

    protected void setInputText(CharSequence charSequence) {
        if (this.mArkViewModel == null) {
            return;
        }
        final String charSequence2 = charSequence.toString();
        this.mArkViewModel.SafeAsyncRun(new Runnable() { // from class: com.tencent.ark.ArkViewImplement.6
            @Override // java.lang.Runnable
            public void run() {
                if (ArkViewImplement.this.mArkViewModel != null) {
                    ArkViewImplement.this.mArkViewModel.InputInsertText(charSequence2);
                }
            }
        });
    }

    public void setMaxSize(int i3, int i16) {
        ArkViewModel arkViewModel = this.mArkViewModel;
        if (arkViewModel != null) {
            arkViewModel.setMaxSize(i3, i16);
        }
    }

    public void setMinSize(int i3, int i16) {
        ArkViewModel arkViewModel = this.mArkViewModel;
        if (arkViewModel != null) {
            arkViewModel.setMinSize(i3, i16);
        }
    }

    public void setViewRect(int i3, int i16) {
        ArkViewModel arkViewModel = this.mArkViewModel;
        if (arkViewModel != null) {
            float scale = arkViewModel.getScale();
            this.mArkViewModel.setViewRect(new Rect(0, 0, (int) (i3 / scale), (int) (i16 / scale)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initArkView(ArkViewModel arkViewModel, boolean z16) {
        if (arkViewModel == null) {
            Logger.logE(TAG, "initArkView,viewModel this = " + this);
            return;
        }
        if (ENV.mIsDebug) {
            Logger.logI(TAG, "initArkView.viewModel." + arkViewModel);
        }
        if (this.mArkViewModel == arkViewModel) {
            arkViewModel.activateView(true, false);
            arkViewModel.postInvalid();
            LoadCallback loadCallback = this.mLoadCallback;
            if (loadCallback != null) {
                loadCallback.onLoadState(this.mLoadState);
            }
            Logger.logI(TAG, "initArkView.1.same wrapper: " + this.mRectView.toString() + ", wrapper: " + arkViewModel + " view: " + this);
            return;
        }
        if (z16 && this.mArkView.getVisibility() != 8) {
            this.mArkView.setVisibility(4);
        }
        ArkViewModel arkViewModel2 = this.mArkViewModel;
        if (arkViewModel2 != null) {
            arkViewModel2.detachView();
        }
        this.mScale = arkViewModel.getScale();
        this.mRound = arkViewModel.mRoundCorner;
        this.mArkViewModel = arkViewModel;
        arkViewModel.attachView(this);
        StringBuilder sb5 = new StringBuilder();
        Rect containerRect = arkViewModel.getContainerRect();
        if (containerRect.isEmpty()) {
            ArkViewModelBase.Size containerHintSize = arkViewModel.getContainerHintSize();
            int i3 = this.mPreferredHeight;
            if (i3 != 0) {
                containerHintSize.height = i3;
            }
            containerRect.set(0, 0, containerHintSize.width, containerHintSize.height);
            sb5.append("initArkView.vm.");
            sb5.append(arkViewModel.hashCode());
            sb5.append(".use a hint init size.(");
            sb5.append(containerRect.width());
            sb5.append(", ");
            sb5.append(containerRect.height());
            sb5.append(") mPreferredHeight=");
            sb5.append(this.mPreferredHeight);
        }
        this.mPreferredHeight = 0;
        Rect scaleRect = arkViewModel.scaleRect(containerRect);
        this.mRectView = scaleRect;
        if (!scaleRect.isEmpty()) {
            sb5.append(" ,vm.");
            sb5.append(arkViewModel.hashCode());
            sb5.append(".measure.(");
            sb5.append(this.mRectView.width());
            sb5.append(", ");
            sb5.append(this.mRectView.height());
            sb5.append(")");
            ViewGroup.LayoutParams layoutParams = this.mArkView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = this.mRectView.width();
                layoutParams.height = this.mRectView.height();
            }
        }
        Logger.logI(TAG, sb5.toString());
    }
}
