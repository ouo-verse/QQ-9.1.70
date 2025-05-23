package com.tencent.aelight.camera.ae.play;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetFontDataRsp;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.videoshelf.model.edit.NodeItem;
import com.tencent.ttpic.videoshelf.model.edit.NodeText;
import java.io.File;

/* compiled from: P */
/* loaded from: classes32.dex */
public class EditTextViewer extends ImageView implements View.OnClickListener {
    private static final int DEFAUT_TEXT_MAX_COUNT = 10;
    private static final String TAG = "EditTextViewer";
    private OnDownloadDialogListener downloadDialogLister;
    private boolean inited;
    private boolean isAnimationPlaying;
    private boolean isFirstRender;
    private OnSaveTextInfoListener listener;
    private int mActionBarHeight;
    private Activity mActivity;
    private LayerDrawable mAnimationDrawable;
    private Drawable mAnimationSolidDrawable;
    private Bitmap mBlankBitmap;
    private EditTextDialog mEditTextDialog;
    private boolean mIsTextSelected;
    private String mLastUseText;
    private Matrix mMatrix;
    private NodeItem mNodeItem;
    private String mTemplateID;
    private ValueAnimator mValueAnimator;
    private String materialId;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface OnDownloadDialogListener {
        void hideDownloadDialog();

        void showDownloadDialog();
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface OnSaveTextInfoListener {
        void onCompleteTextEdit(NodeItem nodeItem);

        void onSaveTextInfo(NodeItem nodeItem);
    }

    public EditTextViewer(Context context) {
        super(context);
        this.mNodeItem = new NodeItem();
        this.mIsTextSelected = false;
        this.inited = false;
        this.mMatrix = new Matrix();
        this.isFirstRender = true;
        this.mActionBarHeight = 0;
        this.isAnimationPlaying = false;
        this.mActivity = (Activity) context;
        setOnClickListener(this);
        this.isFirstRender = true;
        setBackgroundDrawable(getResources().getDrawable(R.drawable.isr));
        LayerDrawable layerDrawable = (LayerDrawable) getResources().getDrawable(R.drawable.isq);
        this.mAnimationDrawable = layerDrawable;
        this.mAnimationSolidDrawable = layerDrawable.findDrawableByLayerId(R.id.ruu);
    }

    private boolean deleteSingleFile(String str) {
        File file = new File(str);
        return file.exists() && file.isFile() && file.delete();
    }

    private void drawAnimationIfNeed(Canvas canvas) {
        if (this.isAnimationPlaying) {
            this.mAnimationDrawable.setBounds(0, 0, getWidth(), getHeight());
            this.mAnimationDrawable.draw(canvas);
        }
    }

    private void drawBlankText() {
        this.mNodeItem.bitmap = this.mBlankBitmap;
    }

    private String getValue() {
        return "";
    }

    private void hideDownloadDialog() {
        OnDownloadDialogListener onDownloadDialogListener = this.downloadDialogLister;
        if (onDownloadDialogListener != null) {
            onDownloadDialogListener.hideDownloadDialog();
        }
    }

    private void onGetFontDataSuccess(GetFontDataRsp getFontDataRsp) {
        saveFontFile(getContext(), getFontDataRsp.FontData);
    }

    private void showDownloadDialog() {
        OnDownloadDialogListener onDownloadDialogListener = this.downloadDialogLister;
        if (onDownloadDialogListener != null) {
            onDownloadDialogListener.showDownloadDialog();
        }
    }

    private void toastInUIThread(final int i3) {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.play.EditTextViewer.1
            @Override // java.lang.Runnable
            public void run() {
                QQToast.makeText(EditTextViewer.this.getContext(), i3, 1).show();
            }
        });
    }

    private void updateParams() {
        NodeItem nodeItem = this.mNodeItem;
        nodeItem.cropBitmap = null;
        Bitmap bitmap = nodeItem.bitmap;
        if (bitmap != null) {
            setImageBitmap(bitmap);
        }
        OnSaveTextInfoListener onSaveTextInfoListener = this.listener;
        if (onSaveTextInfoListener != null) {
            onSaveTextInfoListener.onSaveTextInfo(this.mNodeItem);
        }
        setTextSelected(true);
        this.isFirstRender = false;
    }

    public void clearBitmaps() {
        Bitmap bitmap = this.mNodeItem.bitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.mNodeItem.bitmap.recycle();
        }
        Bitmap bitmap2 = this.mNodeItem.cropBitmap;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.mNodeItem.cropBitmap.recycle();
        }
        setImageBitmap(null);
        clearTextWMElement();
        this.inited = false;
    }

    public NodeItem getNode() {
        return this.mNodeItem;
    }

    public int getNodeGroupID() {
        return this.mNodeItem.nodeGroupID;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!this.inited) {
            initTextWMElement();
        }
        showTextEditDlg();
        setTextSelected(false);
        com.tencent.aelight.camera.ae.report.b.b().w1();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int i3;
        int i16;
        int i17;
        try {
            if (this.mNodeItem.bitmap != null && getWidth() != 0 && getHeight() != 0) {
                int width = this.mNodeItem.bitmap.getWidth();
                int height = this.mNodeItem.bitmap.getHeight();
                int width2 = getWidth();
                int height2 = getHeight();
                NodeText nodeText = this.mNodeItem.nodeTextGroup;
                int i18 = 0;
                if (nodeText == null) {
                    i3 = 0;
                } else if ("left".equals(nodeText.alignment)) {
                    i3 = (height2 / 2) - (height / 2);
                } else {
                    if ("right".equals(this.mNodeItem.nodeTextGroup.alignment)) {
                        i18 = width2 - width;
                        i16 = height2 / 2;
                        i17 = height / 2;
                    } else {
                        i18 = (width2 / 2) - (width / 2);
                        i16 = height2 / 2;
                        i17 = height / 2;
                    }
                    i3 = i16 - i17;
                }
                this.mMatrix.postTranslate(i18, i3);
                setImageMatrix(this.mMatrix);
            }
            super.onDraw(canvas);
            drawAnimationIfNeed(canvas);
        } catch (Throwable unused) {
        }
    }

    public void renderAndSaveTexture(String str) {
        if (!NetworkUtil.isNetworkAvailable(AEModule.getContext())) {
            QQToast.makeText(getContext(), R.string.y6_, 1).show();
        } else {
            if (this.inited) {
                return;
            }
            initTextWMElement();
        }
    }

    public Bitmap renderBitmap() {
        if (this.inited) {
            return null;
        }
        initTextWMElement();
        return null;
    }

    public void setActionBarHeight(int i3) {
        this.mActionBarHeight = i3;
    }

    public void setMaterialId(String str) {
        this.materialId = str;
    }

    public void setNodeBitmap(Bitmap bitmap) {
        this.mNodeItem.bitmap = bitmap;
    }

    public void setNodeInfo(NodeItem nodeItem) {
        NodeItem nodeItem2 = this.mNodeItem;
        nodeItem2.nodeID = nodeItem.nodeID;
        nodeItem2.nodeGroupID = nodeItem.nodeGroupID;
        nodeItem2.once = nodeItem.once;
        nodeItem2.maskRect = nodeItem.maskRect;
        nodeItem2.nodeTextMaxCount = nodeItem.nodeTextMaxCount;
        nodeItem2.zIndex = nodeItem.zIndex;
        nodeItem2.nodeTextGroup.copyFrom(nodeItem.nodeTextGroup);
    }

    public void setOnDownloadDialogListener(OnDownloadDialogListener onDownloadDialogListener) {
        this.downloadDialogLister = onDownloadDialogListener;
    }

    public void setOnSaveTextInfoListener(OnSaveTextInfoListener onSaveTextInfoListener) {
        this.listener = onSaveTextInfoListener;
    }

    public void setTemplateID(String str) {
        this.mTemplateID = str;
    }

    public void setTextSelected(boolean z16) {
        this.mIsTextSelected = z16;
    }

    public void startAnimaterIfNeed() {
        if (this.mValueAnimator == null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(150, 0);
            this.mValueAnimator = ofInt;
            ofInt.setDuration(700L);
            this.mValueAnimator.setRepeatCount(4);
            this.mValueAnimator.setInterpolator(new DecelerateInterpolator());
            this.mValueAnimator.setRepeatMode(2);
            this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.aelight.camera.ae.play.EditTextViewer.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    EditTextViewer.this.mAnimationSolidDrawable.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    EditTextViewer.this.invalidate();
                }
            });
            this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.tencent.aelight.camera.ae.play.EditTextViewer.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    EditTextViewer.this.isAnimationPlaying = false;
                    EditTextViewer.this.invalidate();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    EditTextViewer.this.isAnimationPlaying = true;
                }
            });
        }
        if (this.mValueAnimator.isRunning()) {
            this.mValueAnimator.cancel();
        }
        this.mValueAnimator.start();
    }

    public void updateMatrix(int i3, int i16) {
        int i17;
        int i18;
        int i19;
        int width = this.mNodeItem.bitmap.getWidth();
        int height = this.mNodeItem.bitmap.getHeight();
        NodeText nodeText = this.mNodeItem.nodeTextGroup;
        int i26 = 0;
        if (nodeText == null) {
            i17 = 0;
        } else if ("left".equals(nodeText.alignment)) {
            i17 = (i16 / 2) - (height / 2);
        } else {
            if ("right".equals(this.mNodeItem.nodeTextGroup.alignment)) {
                i26 = i3 - width;
                i18 = i16 / 2;
                i19 = height / 2;
            } else {
                i26 = (i3 / 2) - (width / 2);
                i18 = i16 / 2;
                i19 = height / 2;
            }
            i17 = i18 - i19;
        }
        this.mMatrix.postTranslate(i26, i17);
        setImageMatrix(this.mMatrix);
    }

    public void initTextWMElement() {
        this.inited = true;
        NodeItem nodeItem = this.mNodeItem;
        if (nodeItem.nodeTextMaxCount <= 0) {
            nodeItem.nodeTextMaxCount = 10;
        }
    }

    private String saveFontFile(Context context, byte[] bArr) {
        if (context != null && bArr != null && bArr.length != 0) {
            String str = context.getFilesDir().getAbsolutePath() + File.separator + "temp.ttf";
            FileUtils.writeFile(bArr, str);
            return str;
        }
        return "";
    }

    private void drawText() {
    }

    private void showTextEditDlg() {
    }

    public void clearTextWMElement() {
    }
}
