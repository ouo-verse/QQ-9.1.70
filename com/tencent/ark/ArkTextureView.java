package com.tencent.ark;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.FrameLayout;
import com.tencent.ark.ArkViewImplement;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ArkTextureView extends FrameLayout implements ArkViewImplement.ArkViewInterface, View.OnTouchListener, View.OnLongClickListener {
    private static final ArkEnvironmentManager ENV = ArkEnvironmentManager.getInstance();
    protected static String TAG = "ArkApp.ArkTextureView";
    private View mArkView;
    private Context mContext;
    private boolean mIsGpuRendering;
    protected boolean mOnStartTemporaryDetach;
    private ArkTextureViewInterface mTextureViewInterface;
    public ArkViewImplement mViewImpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface ArkTextureViewInterface {
        void checkSurfaceAvailable();

        void createContext();

        void destroyBitmapBuffer();

        Bitmap getBitmapBuffer();

        void initArkView(ArkViewModel arkViewModel);

        boolean onInvalidate(Rect rect);

        Bitmap recreateBitmapBuffer(Rect rect);

        void releaseContext();
    }

    public ArkTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOnStartTemporaryDetach = true;
        this.mContext = context;
        this.mViewImpl = new ArkViewImplement(this, this);
    }

    private void prepareForRendering(ArkViewModel arkViewModel) {
        View arkSoftwareView;
        boolean isGpuRenderingEnabled = arkViewModel.isGpuRenderingEnabled();
        if (isGpuRenderingEnabled != this.mIsGpuRendering) {
            this.mIsGpuRendering = isGpuRenderingEnabled;
        } else if (this.mArkView != null) {
            return;
        }
        if (this.mArkView != null) {
            removeAllViews();
            this.mArkView = null;
        }
        if (this.mIsGpuRendering) {
            arkSoftwareView = new ArkTextureViewImpl(this.mContext, this.mViewImpl);
        } else {
            arkSoftwareView = new ArkSoftwareView(this.mContext, this.mViewImpl, arkViewModel.isMemoryOptimized());
        }
        this.mArkView = arkSoftwareView;
        addView(this.mArkView, new FrameLayout.LayoutParams(-1, -1));
        this.mTextureViewInterface = (ArkTextureViewInterface) this.mArkView;
    }

    @Override // com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void checkSurfaceAvailable() {
        this.mTextureViewInterface.checkSurfaceAvailable();
    }

    @Override // com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void createViewContext() {
        this.mTextureViewInterface.createContext();
    }

    @Override // com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void destroyBitmapBuffer() {
        this.mTextureViewInterface.destroyBitmapBuffer();
    }

    @Override // com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void doDetach(ArkViewModel arkViewModel) {
        this.mViewImpl.doDetach(arkViewModel);
    }

    @Override // com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void doInputCommand(int i3) {
        this.mViewImpl.doInputCommand(i3);
    }

    @Override // com.tencent.ark.ArkViewImplement.ArkViewInterface
    public Bitmap getBitmapBuffer() {
        return this.mTextureViewInterface.getBitmapBuffer();
    }

    @Override // com.tencent.ark.ArkViewImplement.ArkViewInterface
    public Rect getInputRect() {
        return this.mViewImpl.getInputRect();
    }

    @Override // com.tencent.ark.ArkViewImplement.ArkViewInterface
    public View getView() {
        return this.mArkView;
    }

    @Override // com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void initArkView(ArkViewModel arkViewModel) {
        initArkView(arkViewModel, true);
    }

    @Override // android.view.View
    public boolean onCheckIsTextEditor() {
        return this.mViewImpl.onCheckIsTextEditor();
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return this.mViewImpl.onCreateInputConnection(editorInfo);
    }

    @Override // com.tencent.ark.ArkViewImplement.ArkViewInterface
    public boolean onInvalidate(Rect rect) {
        return this.mTextureViewInterface.onInvalidate(rect);
    }

    @Override // com.tencent.ark.ArkViewImplement.ArkViewInterface, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        boolean z16;
        EventCollector.getInstance().onViewLongClickedBefore(view);
        if (view == this) {
            z16 = this.mViewImpl.doOnLongClick(view);
        } else {
            z16 = false;
        }
        EventCollector.getInstance().onViewLongClicked(view);
        return z16;
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        if (this.mOnStartTemporaryDetach) {
            this.mViewImpl.onStartTemporaryDetach();
        }
    }

    @Override // com.tencent.ark.ArkViewImplement.ArkViewInterface, android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == this && this.mViewImpl.doOnTouch(view, motionEvent)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.ark.ArkViewImplement.ArkViewInterface
    public Bitmap recreateBitmapBuffer(Rect rect) {
        return this.mTextureViewInterface.recreateBitmapBuffer(rect);
    }

    @Override // com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void releaseViewContext() {
        this.mTextureViewInterface.releaseContext();
    }

    @Override // com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void setAlignLeft(boolean z16) {
        this.mViewImpl.mAlignLeft = z16;
    }

    @Override // com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void setBorderType(int i3) {
        this.mViewImpl.mBorderType = i3;
    }

    @Override // com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void setClipRadius(float f16) {
        this.mViewImpl.mClipRadius = f16;
    }

    @Override // com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void setClipRadiusTop(float f16) {
        this.mViewImpl.mClipRadiusTop = f16;
    }

    @Override // com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void setFixSize(int i3, int i16) {
        this.mViewImpl.setFixSize(i3, i16);
    }

    @Override // com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void setInputCallback(ArkViewImplement.InputCallback inputCallback) {
        this.mViewImpl.mInputCallback = inputCallback;
    }

    @Override // com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void setInputSetCaretHolderSize(int i3, int i16) {
        this.mViewImpl.setInputSetCaretHolderSize(i3, i16);
    }

    @Override // com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void setInputSetSelectHolderSize(int i3, int i16) {
        this.mViewImpl.setInputSetSelectHolderSize(i3, i16);
    }

    @Override // com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void setLoadCallback(ArkViewImplement.LoadCallback loadCallback) {
        this.mViewImpl.mLoadCallback = loadCallback;
    }

    @Override // com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void setMaxSize(int i3, int i16) {
        this.mViewImpl.setMaxSize(i3, i16);
    }

    @Override // com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void setMinSize(int i3, int i16) {
        this.mViewImpl.setMinSize(i3, i16);
    }

    public void setViewPressed(boolean z16) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pressed", z16);
        } catch (JSONException e16) {
            Logger.logE(TAG, "setViewPressed JSONException e:" + e16.toString());
        }
        this.mViewImpl.doOnViewEvent("ViewPressed", jSONObject.toString());
    }

    @Override // com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void setViewRect(int i3, int i16) {
        this.mViewImpl.setViewRect(i3, i16);
    }

    @Override // com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void initArkView(ArkViewModel arkViewModel, boolean z16) {
        prepareForRendering(arkViewModel);
        this.mTextureViewInterface.initArkView(arkViewModel);
        this.mViewImpl.initArkView(arkViewModel, z16);
    }

    @Override // com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void onFirstPaint() {
    }

    @Override // com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void onLoadSuccess() {
    }

    @Override // com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void onLoading() {
    }

    @Override // com.tencent.ark.ArkViewImplement.ArkViewInterface
    public void onLoadFailed(String str, int i3, boolean z16) {
    }
}
