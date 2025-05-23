package com.tencent.aelight.camera.ae.play;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.aelight.camera.ae.g;
import com.tencent.aelight.camera.ae.play.EditTextViewer;
import com.tencent.aelight.camera.ae.play.FaceImageViewer;
import com.tencent.aelight.camera.ae.play.ScaleMoveImageViewer;
import com.tencent.aelight.camera.ae.play.VideoListAdapter;
import com.tencent.aelight.camera.ae.util.e;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.util.api.IPicChooseJumpUtil;
import com.tencent.biz.qqstory.utils.d;
import com.tencent.biz.richframework.compat.f;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.en;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.aj;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.facedetect.FaceInfo;
import com.tencent.ttpic.util.CosFunUtil;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.videoshelf.data.Constants;
import com.tencent.ttpic.videoshelf.libpag.PagNotSupportSystemException;
import com.tencent.ttpic.videoshelf.model.VideoShelfEngine;
import com.tencent.ttpic.videoshelf.model.edit.NodeGroup;
import com.tencent.ttpic.videoshelf.model.edit.NodeItem;
import com.tencent.ttpic.videoshelf.model.edit.NodeText;
import com.tencent.ttpic.videoshelf.model.edit.ShelfNode;
import com.tencent.ttpic.videoshelf.model.template.MaskNodeGroup;
import com.tencent.ttpic.videoshelf.model.template.MaskNodeItem;
import com.tencent.ttpic.videoshelf.model.template.VideoShelfTemplate;
import com.tencent.ttpic.videoshelf.parser.TemplateParser;
import com.tencent.util.UiThreadUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.light.device.OfflineConfig;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEVideoShelfEditFragment extends PublicBaseFragment implements View.OnClickListener, ScaleMoveImageViewer.OnSaveScrollInfoListener, EditTextViewer.OnSaveTextInfoListener, EditTextViewer.OnDownloadDialogListener, FaceImageViewer.OnSaveScrollInfoListener, en {
    private static int AUDIO_UPDATE_PROGRESS_TIME = 200;
    private static final long INTERVAL_UPDATE_PROGRESS = 200;
    private static final int INVALID_NODEGROUPID = -1;
    private static double PROCESS_STEP = 0.3d;
    private static final String TAG = "AEVideoShelfEditFrag";
    private static final float WIDTH_BY_DESIGNER_USED = 720.0f;
    private static final int ZINDEX_BOUND = 10000;
    private static final float spacingInPixels = 12.0f;
    private static PowerManager.WakeLock wakeLock;
    private String mAudioPath;
    private Bitmap mBackgroundBitmap;
    private ImageView mBackgroundImageView;
    private RecyclerView mBoxRecycleView;
    private View mButtonCancel;
    private View mButtonChangeImage;
    private TextView mButtonOk;
    private RelativeLayout mCenterView;
    private Dialog mDialog;
    private VideoShelfEngine mEngine;
    private String mFinalVideoPath;
    private long mGenerateBegin;
    private int mJumpFrom;
    private long mLastUpdateProgressTimeMs;
    private Dialog mLoadingDialog;
    private String mMaterialId;
    private ArrayList<String> mSourcePhotoList;
    private String mTakeSameName;
    private VideoShelfTemplate mTemplate;
    private String mTemplatePath;
    private VideoListAdapter mVideoListAdapter;
    private String outputDir;
    private String playShowTabName;
    aj ppd;
    private List<NodeGroup> mNodeGroupList = new ArrayList();
    private HashSet<ScaleMoveImageViewer> mImageViewerSet = new HashSet<>();
    private HashSet<EditTextViewer> mTextViewerSet = new HashSet<>();
    private HashSet<FaceImageViewer> mFaceImageViewerSet = new HashSet<>();
    private Boolean mIsSavingVideo = Boolean.FALSE;
    private List<Bitmap> mBitmaps = new ArrayList();
    private int mCenterViewWidth = 0;
    private int mCenterViewHeight = 0;
    private int mPrePos = 0;
    private Timer mTimer = new BaseTimer();
    private double mProgress = 0.0d;
    private Map<String, Bitmap> mSourceBitmaps = new HashMap();
    private SparseIntArray mNodeSourceMap = new SparseIntArray();
    private final String IMAGE_SINGLE_FACE = "0";
    private final String IMAGE_MULTI_FACE = "1";
    private final String IMAGE_NO_FACE = "2";
    private int mCurrentFaceImageViewerNodeId = 0;
    private VideoListAdapter.OnVideoNodeClickedListener mOnVideoNodeClickedListener = new VideoListAdapter.OnVideoNodeClickedListener() { // from class: com.tencent.aelight.camera.ae.play.AEVideoShelfEditFragment.20
        @Override // com.tencent.aelight.camera.ae.play.VideoListAdapter.OnVideoNodeClickedListener
        public void onVideoNodeClick(int i3) {
            AEVideoShelfEditFragment aEVideoShelfEditFragment = AEVideoShelfEditFragment.this;
            aEVideoShelfEditFragment.setListViewBg(aEVideoShelfEditFragment.mPrePos);
            AEVideoShelfEditFragment.this.mPrePos = i3;
            AEVideoShelfEditFragment.this.initCenterView(i3);
            AEVideoShelfEditFragment.this.updateRVListItem(i3);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class EngineCallback implements VideoShelfEngine.Callback {
        private WeakReference<AEVideoShelfEditFragment> mRef;

        public EngineCallback(AEVideoShelfEditFragment aEVideoShelfEditFragment) {
            this.mRef = new WeakReference<>(aEVideoShelfEditFragment);
        }

        @Override // com.tencent.ttpic.videoshelf.model.VideoShelfEngine.Callback
        public void onCancelCompleted() {
            WeakReference<AEVideoShelfEditFragment> weakReference = this.mRef;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.mRef.get().onCancelCompleted();
        }

        @Override // com.tencent.ttpic.videoshelf.model.VideoShelfEngine.Callback
        public void onCompleted() {
            WeakReference<AEVideoShelfEditFragment> weakReference = this.mRef;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.mRef.get().onCompleted();
        }

        @Override // com.tencent.ttpic.videoshelf.model.VideoShelfEngine.Callback
        public void onError(int i3, int i16, String str) {
            WeakReference<AEVideoShelfEditFragment> weakReference = this.mRef;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.mRef.get().onError(i3, i16, str);
        }

        @Override // com.tencent.ttpic.videoshelf.model.VideoShelfEngine.Callback
        public void onProgress(int i3) {
            WeakReference<AEVideoShelfEditFragment> weakReference = this.mRef;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.mRef.get().onProgress(i3);
        }

        @Override // com.tencent.ttpic.videoshelf.model.VideoShelfEngine.Callback
        public void onStartGenerate() {
            WeakReference<AEVideoShelfEditFragment> weakReference = this.mRef;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.mRef.get().onStartGenerate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class OffscreenCaptureRunnable implements Runnable {
        OffscreenCaptureRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RelativeLayout relativeLayout = new RelativeLayout(AEVideoShelfEditFragment.this.getBaseActivity());
            AEVideoShelfEditFragment.layoutView(relativeLayout, AEVideoShelfEditFragment.this.mCenterView.getLeft(), AEVideoShelfEditFragment.this.mCenterView.getTop(), AEVideoShelfEditFragment.this.mCenterViewWidth, AEVideoShelfEditFragment.this.mCenterViewHeight);
            if (AEVideoShelfEditFragment.this.mVideoListAdapter != null) {
                for (int i3 = 0; i3 < AEVideoShelfEditFragment.this.mVideoListAdapter.getItemCount(); i3++) {
                    if (i3 == 0) {
                        AEVideoShelfEditFragment.this.updateRVListItem(i3);
                    } else {
                        AEVideoShelfEditFragment.this.setOffscreenView(relativeLayout, i3);
                        AEVideoShelfEditFragment.this.setListViewBg(relativeLayout, i3);
                    }
                }
            }
            relativeLayout.removeAllViews();
            if (AEVideoShelfEditFragment.this.mVideoListAdapter != null) {
                AEVideoShelfEditFragment.this.mVideoListAdapter.setOnVideoNodeClickedListener(AEVideoShelfEditFragment.this.mOnVideoNodeClickedListener);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private int space;

        public SpacesItemDecoration(int i3) {
            this.space = i3;
        }

        @Override // android.support.v7.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, int i3, RecyclerView recyclerView) {
            super.getItemOffsets(rect, i3, recyclerView);
            if (i3 == 0) {
                rect.left = this.space;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkJumpToPreview(Intent intent) {
        if (this.mJumpFrom == 3) {
            getBaseActivity().setResult(-1, intent);
            getBaseActivity().finish();
        } else {
            AEVideoShelfPreviewFragment.jumpToMe(getBaseActivity(), intent, 2);
        }
    }

    private void clearTempFiles() {
        String[] list;
        File file = new File(this.outputDir);
        if (!file.exists() || !file.isDirectory() || (list = file.list()) == null || list.length <= 0) {
            return;
        }
        for (String str : list) {
            File file2 = new File(this.outputDir, str);
            if (file2.exists()) {
                file2.delete();
            }
        }
    }

    private aj createProgressPie() {
        aj ajVar = new aj(getBaseActivity());
        ajVar.h(BaseAIOUtils.f(50.0f, getBaseActivity().getResources()));
        ajVar.f(true);
        ajVar.o(false);
        ajVar.r(-1);
        ajVar.e(0);
        ajVar.j(-15550475);
        ajVar.l(3);
        ajVar.E = true;
        ajVar.A = 2;
        ajVar.n(true);
        ajVar.g(new aj.b() { // from class: com.tencent.aelight.camera.ae.play.AEVideoShelfEditFragment.3
            @Override // com.tencent.mobileqq.widget.aj.b
            public void onProgressCompleted(aj ajVar2) {
            }

            @Override // com.tencent.mobileqq.widget.aj.b
            public void onProgressChanged(aj ajVar2, int i3, int i16) {
            }
        });
        return ajVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissProgressDialog() {
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public static int dp2px(Context context, float f16) {
        return (int) TypedValue.applyDimension(1, f16, context.getResources().getDisplayMetrics());
    }

    private NodeItem findNodeItemById(NodeGroup nodeGroup, int i3) {
        for (NodeItem nodeItem : nodeGroup.nodeItemList) {
            if (i3 == nodeItem.nodeID) {
                return nodeItem;
            }
        }
        return null;
    }

    private void finishAudioVideoMerge() {
        VideoShelfEngine videoShelfEngine;
        String str;
        String b16;
        String str2;
        if (this.mTemplate == null || (videoShelfEngine = this.mEngine) == null) {
            return;
        }
        this.mFinalVideoPath = videoShelfEngine.getOutputVideoPath();
        String audioPath = this.mTemplate.getAudioPath();
        this.mAudioPath = audioPath;
        File file = audioPath != null ? new File(this.mAudioPath) : null;
        boolean hasStoragePermission = hasStoragePermission(BaseApplication.getContext());
        if (file != null && file.exists() && (str = this.mAudioPath) != null && str.toLowerCase().endsWith(".m4a")) {
            if (hasStoragePermission) {
                b16 = g.b(g.a());
            } else {
                b16 = g.b(g.c.b.f65292f + File.separator);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("outputDir: ");
            sb5.append(b16);
            if (new File(b16).exists()) {
                str2 = " exist";
            } else {
                str2 = " not exist";
            }
            sb5.append(str2);
            ms.a.f(TAG, sb5.toString());
            BaseTimer baseTimer = new BaseTimer();
            this.mTimer = baseTimer;
            baseTimer.schedule(new TimerTask() { // from class: com.tencent.aelight.camera.ae.play.AEVideoShelfEditFragment.16
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.play.AEVideoShelfEditFragment.16.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (AEVideoShelfEditFragment.this.mProgress < 100.0d) {
                                AEVideoShelfEditFragment.this.mProgress += AEVideoShelfEditFragment.PROCESS_STEP;
                                AEVideoShelfEditFragment aEVideoShelfEditFragment = AEVideoShelfEditFragment.this;
                                aEVideoShelfEditFragment.updateProgress((int) aEVideoShelfEditFragment.mProgress);
                            }
                        }
                    });
                }
            }, 0L, AUDIO_UPDATE_PROGRESS_TIME);
            if (com.tencent.aelight.camera.aioeditor.shortvideo.util.b.m(this.mEngine.getOutputVideoPath(), this.mAudioPath, b16, 0) == 0) {
                File file2 = new File(this.mEngine.getOutputVideoPath());
                if (file2.exists()) {
                    ms.a.f(TAG, "finishAudioVideoMerge done!");
                    file2.delete();
                }
                this.mFinalVideoPath = b16;
            }
            this.mTimer.cancel();
            this.mTimer = null;
        }
        if (!hasStoragePermission || this.mFinalVideoPath == null) {
            return;
        }
        d.b(BaseApplication.getContext(), new File(this.mFinalVideoPath));
    }

    private boolean finishEditTemplate() {
        Iterator<ScaleMoveImageViewer> it = this.mImageViewerSet.iterator();
        boolean z16 = false;
        FaceImageViewer faceImageViewer = null;
        boolean z17 = false;
        ScaleMoveImageViewer scaleMoveImageViewer = null;
        while (it.hasNext()) {
            ScaleMoveImageViewer next = it.next();
            if (!next.isImageSelected()) {
                if (scaleMoveImageViewer == null || scaleMoveImageViewer.getNodeGroupID() > next.getNodeGroupID()) {
                    scaleMoveImageViewer = next;
                }
                z17 = true;
            }
            if (!z17) {
                next.updateCropBitmap();
            }
        }
        Iterator<FaceImageViewer> it5 = this.mFaceImageViewerSet.iterator();
        while (it5.hasNext()) {
            FaceImageViewer next2 = it5.next();
            if (!next2.isImageSelected()) {
                if (faceImageViewer == null || faceImageViewer.getNodeGroupID() > next2.getNodeGroupID()) {
                    faceImageViewer = next2;
                }
                z16 = true;
            }
            if (!z16) {
                next2.updateCropBitmap();
            }
        }
        int i3 = -1;
        if (z17 && scaleMoveImageViewer != null) {
            i3 = Math.max(scaleMoveImageViewer.getNodeGroupID(), -1);
        }
        if (z16 && faceImageViewer != null) {
            Math.max(faceImageViewer.getNodeGroupID(), i3);
        }
        return true;
    }

    private Bitmap getCenterViewBitmap() {
        int i3;
        int i16 = this.mCenterViewWidth;
        if (i16 <= 0 || (i3 = this.mCenterViewHeight) <= 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i16, i3, Bitmap.Config.ARGB_8888);
        if (!BitmapUtils.isLegal(createBitmap)) {
            Log.e(TAG, "CenterView bitmap is null");
            return null;
        }
        Canvas canvas = new Canvas(createBitmap);
        RelativeLayout relativeLayout = this.mCenterView;
        if (relativeLayout != null) {
            relativeLayout.draw(canvas);
        }
        return createBitmap;
    }

    private FaceImageViewer getFaceImageViewByNodeId(int i3) {
        Iterator<FaceImageViewer> it = this.mFaceImageViewerSet.iterator();
        while (it.hasNext()) {
            FaceImageViewer next = it.next();
            if (next.getNodeID() == i3) {
                return next;
            }
        }
        return null;
    }

    private ScaleMoveImageViewer getImageViewByNodeId(int i3) {
        Iterator<ScaleMoveImageViewer> it = this.mImageViewerSet.iterator();
        while (it.hasNext()) {
            ScaleMoveImageViewer next = it.next();
            if (next.getNodeID() == i3) {
                return next;
            }
        }
        return null;
    }

    private void goNext() {
        if (finishEditTemplate()) {
            if (!isNeedRealTimePlay()) {
                saveVideoTemplate();
            } else {
                startVideoTemplateSaveActivity(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean hasStoragePermission(Context context) {
        return PermissionUtils.isStorePermissionEnable(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoading() {
        Dialog dialog;
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null || baseActivity.isFinishing() || (dialog = this.mLoadingDialog) == null || !dialog.isShowing()) {
            return;
        }
        this.mLoadingDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void imageLayout(ImageView imageView, int i3, int i16) {
        NodeItem node;
        if (imageView instanceof ScaleMoveImageViewer) {
            node = ((ScaleMoveImageViewer) imageView).getNode();
        } else if (imageView instanceof FaceImageViewer) {
            node = ((FaceImageViewer) imageView).getNode();
        } else {
            node = imageView instanceof EditTextViewer ? ((EditTextViewer) imageView).getNode() : null;
        }
        if (node != null) {
            RectF rectF = node.maskRect;
            float f16 = i3;
            int i17 = (int) (rectF.left * f16);
            float f17 = i16;
            int i18 = (int) (rectF.top * f17);
            int i19 = (int) (rectF.right * f16);
            int i26 = (int) (rectF.bottom * f17);
            int i27 = i19 - i17;
            int i28 = i26 - i18;
            imageView.measure(View.MeasureSpec.makeMeasureSpec(i27, 1073741824), View.MeasureSpec.makeMeasureSpec(i28, 1073741824));
            imageView.layout(i17, i18, i19, i26);
            if (imageView instanceof ScaleMoveImageViewer) {
                ((ScaleMoveImageViewer) imageView).updateMatrix(Math.abs(i27), Math.abs(i28));
                return;
            }
            if (imageView instanceof FaceImageViewer) {
                ((FaceImageViewer) imageView).updateMatrix(Math.abs(i27), Math.abs(i28));
            } else if (imageView instanceof EditTextViewer) {
                EditTextViewer editTextViewer = (EditTextViewer) imageView;
                editTextViewer.updateMatrix(Math.abs(i27), Math.abs(i28));
                editTextViewer.setActionBarHeight(getResources().getDimensionPixelSize(R.dimen.f158523hu));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initAllNodeViewer() {
        this.mNodeSourceMap.clear();
        Iterator<NodeGroup> it = this.mNodeGroupList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            for (final NodeItem nodeItem : it.next().nodeItemList) {
                int i16 = nodeItem.type;
                if (i16 == 0) {
                    final ScaleMoveImageViewer scaleMoveImageViewer = new ScaleMoveImageViewer(getBaseActivity());
                    scaleMoveImageViewer.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.aelight.camera.ae.play.AEVideoShelfEditFragment.6
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            scaleMoveImageViewer.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) scaleMoveImageViewer.getLayoutParams();
                            int i17 = (int) (nodeItem.maskRect.left * AEVideoShelfEditFragment.this.mCenterViewWidth);
                            int i18 = (int) (nodeItem.maskRect.top * AEVideoShelfEditFragment.this.mCenterViewHeight);
                            int i19 = (int) ((1.0f - nodeItem.maskRect.right) * AEVideoShelfEditFragment.this.mCenterViewWidth);
                            int i26 = (int) ((1.0f - nodeItem.maskRect.bottom) * AEVideoShelfEditFragment.this.mCenterViewHeight);
                            marginLayoutParams.leftMargin = i17;
                            marginLayoutParams.topMargin = i18;
                            marginLayoutParams.rightMargin = i19;
                            marginLayoutParams.bottomMargin = i26;
                            marginLayoutParams.width = (AEVideoShelfEditFragment.this.mCenterViewWidth - i19) - i17;
                            marginLayoutParams.height = (AEVideoShelfEditFragment.this.mCenterViewHeight - i26) - i18;
                            scaleMoveImageViewer.setLayoutParams(marginLayoutParams);
                            AEVideoShelfEditFragment aEVideoShelfEditFragment = AEVideoShelfEditFragment.this;
                            aEVideoShelfEditFragment.imageLayout(scaleMoveImageViewer, aEVideoShelfEditFragment.mCenterViewWidth, AEVideoShelfEditFragment.this.mCenterViewHeight);
                            if (QLog.isDebugVersion()) {
                                QLog.d(AEVideoShelfEditFragment.TAG, 2, "initAllNodeViewer onGlobalLayout: wxh=", Integer.valueOf(marginLayoutParams.width), HippyTKDListViewAdapter.X, Integer.valueOf(marginLayoutParams.height));
                            }
                        }
                    });
                    scaleMoveImageViewer.setOnSaveScrollInfoListener(this);
                    scaleMoveImageViewer.setNodeInfo(nodeItem);
                    scaleMoveImageViewer.setMovable(false);
                    scaleMoveImageViewer.setImageSelected(false);
                    this.mImageViewerSet.add(scaleMoveImageViewer);
                    ArrayList<String> arrayList = this.mSourcePhotoList;
                    if (arrayList != null && i3 < arrayList.size()) {
                        onImageChanged(nodeItem.nodeID, this.mSourcePhotoList.get(i3), false);
                        this.mNodeSourceMap.put(nodeItem.nodeID, i3);
                        i3++;
                    }
                } else if (i16 == 1) {
                    final EditTextViewer editTextViewer = new EditTextViewer(getBaseActivity());
                    editTextViewer.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.aelight.camera.ae.play.AEVideoShelfEditFragment.7
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            editTextViewer.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) editTextViewer.getLayoutParams();
                            int i17 = (int) (nodeItem.maskRect.left * AEVideoShelfEditFragment.this.mCenterViewWidth);
                            int i18 = (int) (nodeItem.maskRect.top * AEVideoShelfEditFragment.this.mCenterViewHeight);
                            int i19 = (int) ((1.0f - nodeItem.maskRect.right) * AEVideoShelfEditFragment.this.mCenterViewWidth);
                            int i26 = (int) ((1.0f - nodeItem.maskRect.bottom) * AEVideoShelfEditFragment.this.mCenterViewHeight);
                            marginLayoutParams.leftMargin = i17;
                            marginLayoutParams.topMargin = i18;
                            marginLayoutParams.rightMargin = i19;
                            marginLayoutParams.bottomMargin = i26;
                            marginLayoutParams.width = (AEVideoShelfEditFragment.this.mCenterViewWidth - i19) - i17;
                            marginLayoutParams.height = (AEVideoShelfEditFragment.this.mCenterViewHeight - i26) - i18;
                            editTextViewer.setLayoutParams(marginLayoutParams);
                        }
                    });
                    editTextViewer.setOnSaveTextInfoListener(this);
                    editTextViewer.setOnDownloadDialogListener(this);
                    editTextViewer.setNodeInfo(nodeItem);
                    Bitmap bitmap = nodeItem.bitmap;
                    if (bitmap != null) {
                        editTextViewer.setImageBitmap(bitmap);
                    } else {
                        Bitmap renderBitmap = editTextViewer.renderBitmap();
                        if (renderBitmap != null && !renderBitmap.isRecycled()) {
                            editTextViewer.setImageBitmap(renderBitmap);
                            nodeItem.bitmap = renderBitmap;
                            editTextViewer.setImageBitmap(renderBitmap);
                        }
                    }
                    editTextViewer.setNodeBitmap(nodeItem.bitmap);
                    editTextViewer.setTextSelected(true);
                    editTextViewer.setMaterialId(this.mMaterialId);
                    this.mTextViewerSet.add(editTextViewer);
                } else if (i16 == 2) {
                    final FaceImageViewer faceImageViewer = new FaceImageViewer(getBaseActivity());
                    faceImageViewer.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.aelight.camera.ae.play.AEVideoShelfEditFragment.8
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public void onGlobalLayout() {
                            faceImageViewer.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) faceImageViewer.getLayoutParams();
                            int i17 = (int) (nodeItem.maskRect.left * AEVideoShelfEditFragment.this.mCenterViewWidth);
                            int i18 = (int) (nodeItem.maskRect.top * AEVideoShelfEditFragment.this.mCenterViewHeight);
                            int i19 = (int) ((1.0f - nodeItem.maskRect.right) * AEVideoShelfEditFragment.this.mCenterViewWidth);
                            int i26 = (int) ((1.0f - nodeItem.maskRect.bottom) * AEVideoShelfEditFragment.this.mCenterViewHeight);
                            marginLayoutParams.leftMargin = i17;
                            marginLayoutParams.topMargin = i18;
                            marginLayoutParams.rightMargin = i19;
                            marginLayoutParams.bottomMargin = i26;
                            marginLayoutParams.width = (AEVideoShelfEditFragment.this.mCenterViewWidth - i19) - i17;
                            marginLayoutParams.height = (AEVideoShelfEditFragment.this.mCenterViewHeight - i26) - i18;
                            faceImageViewer.setLayoutParams(marginLayoutParams);
                        }
                    });
                    faceImageViewer.setOnSaveScrollInfoListener(this);
                    faceImageViewer.setNodeInfo(nodeItem);
                    faceImageViewer.setMovable(false);
                    faceImageViewer.setImageSelected(false);
                    this.mFaceImageViewerSet.add(faceImageViewer);
                    ArrayList<String> arrayList2 = this.mSourcePhotoList;
                    if (arrayList2 != null && i3 < arrayList2.size()) {
                        onFaceImageChanged(nodeItem.nodeID, this.mSourcePhotoList.get(i3), false);
                        this.mNodeSourceMap.put(nodeItem.nodeID, i3);
                        i3++;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initBackgroundImageView() {
        this.mBackgroundImageView = new ImageView(getBaseActivity());
        this.mBackgroundImageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initCenterView(int i3) {
        NodeGroup nodeGroup = this.mNodeGroupList.get(i3);
        this.mCenterView.removeAllViews();
        Iterator<ScaleMoveImageViewer> it = this.mImageViewerSet.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            ScaleMoveImageViewer next = it.next();
            if (next.getNodeGroupID() == nodeGroup.nodeGroupID && next.getNode().zIndex < 10000) {
                this.mCenterView.addView(next);
                z16 = true;
            }
        }
        Iterator<EditTextViewer> it5 = this.mTextViewerSet.iterator();
        while (it5.hasNext()) {
            EditTextViewer next2 = it5.next();
            if (next2.getNodeGroupID() == nodeGroup.nodeGroupID && next2.getNode().zIndex < 10000) {
                this.mCenterView.addView(next2);
            }
        }
        Iterator<FaceImageViewer> it6 = this.mFaceImageViewerSet.iterator();
        while (it6.hasNext()) {
            FaceImageViewer next3 = it6.next();
            if (next3.getNodeGroupID() == nodeGroup.nodeGroupID && next3.getNode().zIndex < 10000) {
                this.mCenterView.addView(next3);
            }
        }
        setBackgroundImage(nodeGroup);
        this.mCenterView.addView(this.mBackgroundImageView);
        Iterator<ScaleMoveImageViewer> it7 = this.mImageViewerSet.iterator();
        while (it7.hasNext()) {
            ScaleMoveImageViewer next4 = it7.next();
            if (next4.getNodeGroupID() == nodeGroup.nodeGroupID && next4.getNode().zIndex >= 10000) {
                this.mCenterView.addView(next4);
                z16 = true;
            }
        }
        Iterator<EditTextViewer> it8 = this.mTextViewerSet.iterator();
        while (it8.hasNext()) {
            EditTextViewer next5 = it8.next();
            if (next5.getNodeGroupID() == nodeGroup.nodeGroupID && next5.getNode().zIndex >= 10000) {
                this.mCenterView.addView(next5);
            }
        }
        Iterator<FaceImageViewer> it9 = this.mFaceImageViewerSet.iterator();
        while (it9.hasNext()) {
            FaceImageViewer next6 = it9.next();
            if (next6.getNodeGroupID() == nodeGroup.nodeGroupID && next6.getNode().zIndex >= 10000) {
                this.mCenterView.addView(next6);
            }
        }
        if (z16) {
            this.mButtonChangeImage.setVisibility(0);
        } else {
            this.mButtonChangeImage.setVisibility(8);
        }
    }

    private void initData() {
        Intent intent = getBaseActivity().getIntent();
        if (intent == null) {
            return;
        }
        this.mJumpFrom = intent.getIntExtra(AEQuDongConstants.INTENT_KEY_FROM, 0);
        this.playShowTabName = intent.getStringExtra(AECameraConstants.LOC_PLAY_SHOW_TAB_NAME);
        this.mTemplatePath = intent.getStringExtra(Constants.INTENT_KEY_MATERIAL_PATH);
        this.mMaterialId = intent.getStringExtra(Constants.INTENT_KEY_MATERIAL_ID);
        this.mSourcePhotoList = intent.getStringArrayListExtra(AEQuDongConstants.INTENT_KEY_PHOTOLIST);
        this.mTakeSameName = intent.getStringExtra(AECameraConstants.LOC_PLAY_SHOW_TAKE_SAME_NAME);
        VideoShelfTemplate parse = TemplateParser.parse(getBaseActivity(), this.mTemplatePath);
        this.mTemplate = parse;
        if (parse == null) {
            ms.a.i(TAG, "parse template Error!");
            return;
        }
        try {
            this.mEngine = new VideoShelfEngine(this.mTemplate.getVersion());
        } catch (PagNotSupportSystemException e16) {
            this.mEngine = null;
            ms.a.c(TAG, e16.getMessage());
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.play.AEVideoShelfEditFragment.4
                @Override // java.lang.Runnable
                public void run() {
                    AEVideoShelfEditFragment.this.getBaseActivity().finish();
                }
            }, 2000L);
        }
        if (this.mEngine == null) {
            ms.a.i(TAG, "init Engine Error!");
        } else {
            new AsyncTask<Void, Void, Void>() { // from class: com.tencent.aelight.camera.ae.play.AEVideoShelfEditFragment.5
                @Override // android.os.AsyncTask
                protected void onPreExecute() {
                    AEVideoShelfEditFragment.this.showLoading(null);
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public Void doInBackground(Void... voidArr) {
                    long currentTimeMillis = System.currentTimeMillis();
                    AEVideoShelfEditFragment.this.initNodeGroup();
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (QLog.isDebugVersion()) {
                        QLog.d(AEVideoShelfEditFragment.TAG, 2, "init data doInBackground1---cost: ", Long.valueOf(currentTimeMillis2 - currentTimeMillis));
                    }
                    AEVideoShelfEditFragment.this.loadAllSrcBitmaps();
                    if (!QLog.isDebugVersion()) {
                        return null;
                    }
                    QLog.d(AEVideoShelfEditFragment.TAG, 2, "init data doInBackground2---cost: ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                    return null;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // android.os.AsyncTask
                public void onPostExecute(Void r75) {
                    AEVideoShelfEditFragment.this.hideLoading();
                    if (AEVideoShelfEditFragment.this.mNodeGroupList.isEmpty()) {
                        ms.a.i(AEVideoShelfEditFragment.TAG, "init NodeGroup Error!");
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < AEVideoShelfEditFragment.this.mNodeGroupList.size(); i3++) {
                        ShelfNode shelfNode = new ShelfNode();
                        shelfNode.setCoverUri(((NodeGroup) AEVideoShelfEditFragment.this.mNodeGroupList.get(i3)).nodeCoverImage);
                        arrayList.add(shelfNode);
                    }
                    AEVideoShelfEditFragment.this.mVideoListAdapter = new VideoListAdapter(AEVideoShelfEditFragment.this.getBaseActivity(), arrayList, AEVideoShelfEditFragment.this.mTemplate.getVideoWidth(), AEVideoShelfEditFragment.this.mTemplate.getVideoHeight());
                    AEVideoShelfEditFragment.this.mVideoListAdapter.setMaterialPath(AEVideoShelfEditFragment.this.mTemplate.getMaterialPath());
                    AEVideoShelfEditFragment.this.mBoxRecycleView.setAdapter(AEVideoShelfEditFragment.this.mVideoListAdapter);
                    AEVideoShelfEditFragment.this.initAllNodeViewer();
                    AEVideoShelfEditFragment.this.initBackgroundImageView();
                    AEVideoShelfEditFragment.this.initCenterView(0);
                    new OffscreenCaptureRunnable().run();
                }
            }.execute(new Void[0]);
        }
    }

    private void initProgressDialog() {
        ReportDialog reportDialog = new ReportDialog(getBaseActivity());
        this.mDialog = reportDialog;
        Window window = reportDialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable());
            window.setDimAmount(0.0f);
        }
        this.mDialog.requestWindowFeature(1);
        this.mDialog.setContentView(R.layout.ba8);
        ImageView imageView = (ImageView) this.mDialog.findViewById(R.id.g1f);
        aj createProgressPie = createProgressPie();
        this.ppd = createProgressPie;
        imageView.setImageDrawable(createProgressPie);
        ((TextView) this.mDialog.findViewById(R.id.f166327f13)).setText(R.string.y6c);
        this.mDialog.setCancelable(true);
        this.mDialog.setCanceledOnTouchOutside(false);
        this.mDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.aelight.camera.ae.play.AEVideoShelfEditFragment.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                AEVideoShelfEditFragment.this.mEngine.cancelSave();
            }
        });
        this.ppd.i(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSelectedFacePosition(FaceImageViewer faceImageViewer, FaceParam faceParam) {
        float width = faceImageViewer.getWidth();
        float height = faceImageViewer.getHeight();
        float degrees = ((float) Math.toDegrees(faceParam.angles[2])) * 1.0f;
        float f16 = (width / 2.0f) - ((r11.left + r11.right) / 2);
        float f17 = (height / 2.0f) - ((r11.top + r11.bottom) / 2);
        float width2 = faceParam.mFace.width();
        faceImageViewer.transformCurrentMatrix(width2 > 0.0f ? width / width2 : 1.0f, degrees, f16, f17);
    }

    private void initSoftInputMode() {
        Window window = getBaseActivity().getWindow();
        if (window != null) {
            window.setSoftInputMode(48);
        }
    }

    private void initView() {
        this.mButtonCancel = getBaseActivity().findViewById(R.id.roi);
        TextView textView = (TextView) getBaseActivity().findViewById(R.id.rpg);
        this.mButtonOk = textView;
        textView.setText(R.string.y5z);
        this.mButtonOk.setOnClickListener(this);
        this.mButtonCancel.setOnClickListener(this);
        View findViewById = getBaseActivity().findViewById(R.id.rs8);
        this.mButtonChangeImage = findViewById;
        findViewById.setOnClickListener(this);
        this.mCenterView = (RelativeLayout) getBaseActivity().findViewById(R.id.rqv);
        this.mBoxRecycleView = (RecyclerView) getBaseActivity().findViewById(R.id.roz);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseActivity());
        linearLayoutManager.setOrientation(0);
        this.mBoxRecycleView.addItemDecoration(new SpacesItemDecoration(dp2px(getBaseActivity(), spacingInPixels)));
        this.mBoxRecycleView.setLayoutManager(linearLayoutManager);
        this.mCenterView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.aelight.camera.ae.play.AEVideoShelfEditFragment.1
            /* JADX WARN: Removed duplicated region for block: B:14:0x00cb  */
            /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:18:0x0086  */
            /* JADX WARN: Removed duplicated region for block: B:9:0x0047  */
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onGlobalLayout() {
                double d16;
                boolean z16;
                AEVideoShelfEditFragment.this.mCenterView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (AEVideoShelfEditFragment.this.mTemplate == null || AEVideoShelfEditFragment.this.mTemplate.getVideoHeight() == 0) {
                    d16 = 0.0d;
                } else {
                    d16 = AEVideoShelfEditFragment.this.mTemplate.getVideoWidth() / AEVideoShelfEditFragment.this.mTemplate.getVideoHeight();
                    if (d16 >= 1.0d) {
                        z16 = true;
                        if (z16) {
                            if (d16 > 0.3333333333333333d) {
                                ViewGroup.LayoutParams layoutParams = AEVideoShelfEditFragment.this.mCenterView.getLayoutParams();
                                layoutParams.width = (int) (AEVideoShelfEditFragment.this.mCenterView.getHeight() * d16);
                                AEVideoShelfEditFragment.this.mCenterView.setLayoutParams(layoutParams);
                                AEVideoShelfEditFragment.this.mCenterViewWidth = layoutParams.width;
                                AEVideoShelfEditFragment aEVideoShelfEditFragment = AEVideoShelfEditFragment.this;
                                aEVideoShelfEditFragment.mCenterViewHeight = aEVideoShelfEditFragment.mCenterView.getHeight();
                            }
                        } else if (d16 < 3.0d) {
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) AEVideoShelfEditFragment.this.mCenterView.getLayoutParams();
                            marginLayoutParams.height = (int) (AEVideoShelfEditFragment.this.mCenterView.getWidth() / d16);
                            AEVideoShelfEditFragment.this.mCenterView.setLayoutParams(marginLayoutParams);
                            AEVideoShelfEditFragment aEVideoShelfEditFragment2 = AEVideoShelfEditFragment.this;
                            aEVideoShelfEditFragment2.mCenterViewWidth = aEVideoShelfEditFragment2.mCenterView.getWidth();
                            AEVideoShelfEditFragment.this.mCenterViewHeight = marginLayoutParams.height;
                        }
                        if (QLog.isDebugVersion()) {
                            return;
                        }
                        QLog.d(AEVideoShelfEditFragment.TAG, 2, "centerView onGlobalLayout: ratio=", Double.valueOf(d16), ", wxh=", Integer.valueOf(AEVideoShelfEditFragment.this.mCenterViewWidth), HippyTKDListViewAdapter.X, Integer.valueOf(AEVideoShelfEditFragment.this.mCenterViewHeight));
                        return;
                    }
                }
                z16 = false;
                if (z16) {
                }
                if (QLog.isDebugVersion()) {
                }
            }
        });
        initProgressDialog();
    }

    private boolean isNeedRealTimePlay() {
        VideoShelfTemplate videoShelfTemplate = this.mTemplate;
        return (videoShelfTemplate == null || videoShelfTemplate.getPagFileName() == null || this.mTemplate.getPagFilePath() == null || this.mTemplate.getPreviewVideoType() != 1 || OfflineConfig.isNotSuptPagRealTime()) ? false : true;
    }

    public static void jumpToMe(Context context, String str, String str2, String str3, String str4, ArrayList<String> arrayList, int i3, String str5) {
        Intent intent = new Intent();
        intent.putExtra(Constants.INTENT_KEY_MATERIAL_PATH, str2);
        intent.putExtra(Constants.INTENT_KEY_MATERIAL_ID, str3);
        intent.putExtra(Constants.INTENT_KEY_MATERIAL_NAME, str4);
        intent.putExtra(AECameraConstants.LOC_PLAY_SHOW_TAB_NAME, str);
        intent.putExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, AETemplateInfoFragment.getFromType(context));
        intent.putStringArrayListExtra(AEQuDongConstants.INTENT_KEY_PHOTOLIST, arrayList);
        intent.putExtra(AEQuDongConstants.INTENT_KEY_FROM, i3);
        intent.putExtra(AECameraConstants.LOC_PLAY_SHOW_TAKE_SAME_NAME, str5);
        PublicFragmentActivity.b.a(context, intent, PublicFragmentActivityForPeak.class, AEVideoShelfEditFragment.class);
    }

    public static void jumpToMeForResult(Activity activity, int i3, String str, String str2, String str3, ArrayList<String> arrayList, int i16) {
        Intent intent = new Intent();
        intent.putExtra(Constants.INTENT_KEY_MATERIAL_PATH, str);
        intent.putExtra(Constants.INTENT_KEY_MATERIAL_ID, str2);
        intent.putExtra(Constants.INTENT_KEY_MATERIAL_NAME, str3);
        intent.putStringArrayListExtra(AEQuDongConstants.INTENT_KEY_PHOTOLIST, arrayList);
        intent.putExtra(AEQuDongConstants.INTENT_KEY_FROM, i16);
        PublicFragmentActivity.b.d(activity, intent, PublicFragmentActivityForPeak.class, AEVideoShelfEditFragment.class, i3);
    }

    private void jumpToPagRealtimePreview() {
        Log.i(TAG, "\u672a\u5408\u6210\u89c6\u9891\uff0c\u5c06\u76f4\u63a5\u5b9e\u65f6\u9884\u89c8\u3002");
        ms.a.f(TAG, "\u672a\u5408\u6210\u89c6\u9891\uff0c\u5c06\u76f4\u63a5\u5b9e\u65f6\u9884\u89c8\u3002");
        if (this.mTemplate == null) {
            return;
        }
        new AsyncTask<Void, Void, Void>() { // from class: com.tencent.aelight.camera.ae.play.AEVideoShelfEditFragment.12
            @Override // android.os.AsyncTask
            protected void onPreExecute() {
                super.onPreExecute();
                AEVideoShelfEditFragment.this.showLoading(null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Void doInBackground(Void... voidArr) {
                Intent intent = new Intent();
                intent.putExtra("from", true);
                intent.putExtra(AEVideoShelfPreviewFragment.IS_NEED_EDIT_BTN, true);
                intent.putExtra(Constants.USE_PAG_PREVIEW, true);
                intent.putExtra(Constants.VIDEO_OUT_WIDTH, AEVideoShelfEditFragment.this.mTemplate.getVideoWidth());
                intent.putExtra(Constants.VIDEO_OUT_HEIGHT, AEVideoShelfEditFragment.this.mTemplate.getVideoHeight());
                intent.putExtra(Constants.PAG_FILE_PATH, AEVideoShelfEditFragment.this.mTemplate.getPagFilePath());
                intent.putExtra(Constants.AUDIO_FILE_PATH, AEVideoShelfEditFragment.this.mTemplate.getAudioPath());
                intent.putExtra(Constants.INTENT_KEY_MATERIAL_PATH, AEVideoShelfEditFragment.this.mTemplatePath);
                intent.putExtra(Constants.INTENT_KEY_MATERIAL_ID, AEVideoShelfEditFragment.this.mMaterialId);
                intent.putExtra(Constants.INTENT_KEY_MATERIAL_NAME, AEVideoShelfEditFragment.this.mTemplate.getVideoName());
                intent.putStringArrayListExtra(AEQuDongConstants.INTENT_KEY_PHOTOLIST, AEVideoShelfEditFragment.this.mSourcePhotoList);
                intent.putExtra(AECameraConstants.LOC_PLAY_SHOW_TAB_NAME, AEVideoShelfEditFragment.this.playShowTabName);
                intent.putExtra(AECameraConstants.LOC_PLAY_SHOW_MATERIAL_ID, AEVideoShelfEditFragment.this.mMaterialId);
                intent.putExtra(AECameraConstants.LOC_PLAY_SHOW_TAKE_SAME_NAME, AEVideoShelfEditFragment.this.mTakeSameName);
                intent.putExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, AETemplateInfoFragment.getFromType(AEVideoShelfEditFragment.this.getBaseActivity()));
                HashMap hashMap = new HashMap();
                Iterator it = AEVideoShelfEditFragment.this.mNodeGroupList.iterator();
                while (it.hasNext()) {
                    for (NodeItem nodeItem : ((NodeGroup) it.next()).nodeItemList) {
                        if (nodeItem.type != 1) {
                            hashMap.put(AEVideoShelfEditFragment.this.saveMyBitmap(nodeItem.nodeID, nodeItem.cropBitmap), nodeItem.indexLayerForPag);
                        } else {
                            hashMap.put(AEVideoShelfEditFragment.this.saveMyBitmap(nodeItem.nodeID, nodeItem.bitmap), nodeItem.indexLayerForPag);
                        }
                    }
                }
                Bundle bundle = new Bundle();
                bundle.putSerializable(Constants.NODE_IMG_LIST, hashMap);
                intent.putExtras(bundle);
                AEVideoShelfEditFragment.this.checkJumpToPreview(intent);
                return null;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public void onPostExecute(Void r16) {
                super.onPostExecute((AnonymousClass12) r16);
                AEVideoShelfEditFragment.this.hideLoading();
            }
        }.execute(new Void[0]);
    }

    public static void keepScreenOn(Context context, boolean z16) {
        if (z16) {
            PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(536870918, AEVideoShelfEditFragment.class.getSimpleName());
            wakeLock = newWakeLock;
            newWakeLock.acquire();
            ms.a.f(TAG, "keepScreenOn!");
            return;
        }
        PowerManager.WakeLock wakeLock2 = wakeLock;
        if (wakeLock2 != null) {
            wakeLock2.release();
            wakeLock = null;
        }
        ms.a.f(TAG, "keepScreenOff!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAllSrcBitmaps() {
        ArrayList<String> arrayList = this.mSourcePhotoList;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        for (int i3 = 0; i3 < this.mSourcePhotoList.size(); i3++) {
            String str = this.mSourcePhotoList.get(i3);
            this.mSourceBitmaps.put(str, BitmapUtils.decodeSampleBitmap(getBaseActivity(), str, this.mTemplate.getVideoWidth(), this.mTemplate.getVideoHeight()));
        }
    }

    private void onFaceImageChanged(int i3, String str, boolean z16) {
        this.mCurrentFaceImageViewerNodeId = i3;
        final FaceImageViewer faceImageViewByNodeId = getFaceImageViewByNodeId(i3);
        if (faceImageViewByNodeId == null || TextUtils.isEmpty(str)) {
            return;
        }
        Bitmap bitmap = this.mSourceBitmaps.get(str);
        if (bitmap == null) {
            bitmap = BitmapUtils.decodeSampleBitmap(getBaseActivity(), str, this.mTemplate.getVideoWidth(), this.mTemplate.getVideoHeight());
            this.mSourceBitmaps.put(str, bitmap);
        }
        if (BitmapUtils.isLegal(bitmap)) {
            final Bitmap rotateWithExif = VideoShelfBitmapUtils.rotateWithExif(bitmap, str);
            if (rotateWithExif.getWidth() == 1 && rotateWithExif.getHeight() == 1) {
                rotateWithExif = BitmapUtils.scaleBitmap(rotateWithExif, 2.0f, true);
            }
            faceImageViewByNodeId.setNodeBitmap(rotateWithExif);
            faceImageViewByNodeId.setImageBitmap(rotateWithExif);
            faceImageViewByNodeId.setImageSelected(true);
            faceImageViewByNodeId.setMovable(true);
            faceImageViewByNodeId.setScaleType(ImageView.ScaleType.MATRIX);
            faceImageViewByNodeId.clearSeclected();
            FaceChangeUtils.runInGLThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.play.AEVideoShelfEditFragment.9
                @Override // java.lang.Runnable
                public void run() {
                    AEVideoShelfEditFragment.this.detectFaceInternal(faceImageViewByNodeId, rotateWithExif);
                }
            }, false, "");
            if (z16) {
                updateRVListItem(faceImageViewByNodeId.getNodeGroupID());
            }
        }
    }

    private void onFirstImageViewClick(View view) {
        int i3 = this.mNodeGroupList.get(this.mPrePos).nodeGroupID;
        HashSet<ScaleMoveImageViewer> hashSet = this.mImageViewerSet;
        if (hashSet != null) {
            Iterator<ScaleMoveImageViewer> it = hashSet.iterator();
            while (it.hasNext()) {
                ScaleMoveImageViewer next = it.next();
                if (next.getNodeGroupID() == i3) {
                    next.onClick(view);
                }
            }
        }
    }

    private void onImageChanged(int i3, String str) {
        onImageChanged(i3, str, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String saveMyBitmap(int i3, Bitmap bitmap) {
        FileOutputStream fileOutputStream;
        String str = this.outputDir + File.separator + "output_" + System.currentTimeMillis() + "_" + i3 + ".png";
        File file = new File(str);
        try {
            file.createNewFile();
        } catch (IOException e16) {
            ms.a.i(TAG, "error in saving png:" + e16.toString());
        }
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e17) {
            e17.printStackTrace();
            ms.a.i(TAG, "error in saving file:" + e17.toString());
            fileOutputStream = null;
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            try {
                fileOutputStream.flush();
            } catch (IOException e18) {
                e18.printStackTrace();
                ms.a.i(TAG, "error in flush png:" + e18.toString());
            }
            try {
                fileOutputStream.close();
            } catch (IOException e19) {
                e19.printStackTrace();
                ms.a.i(TAG, "error in close file:" + e19.toString());
            }
            return str;
        } catch (Exception e26) {
            e26.printStackTrace();
            ms.a.i(TAG, "error in compress png:" + e26.toString());
            return null;
        }
    }

    private void saveVideoTemplate() {
        VideoShelfEngine videoShelfEngine;
        String videoPath;
        VideoShelfTemplate videoShelfTemplate = this.mTemplate;
        if (videoShelfTemplate == null || (videoShelfEngine = this.mEngine) == null) {
            return;
        }
        videoShelfEngine.setVideoFrameItemList(videoShelfTemplate.getFrameList());
        this.mEngine.setNodeGroupItemList(this.mNodeGroupList);
        this.mEngine.setVideoTemplateType(this.mTemplate.getVideoTemplateType());
        int version = this.mTemplate.getVersion();
        if (version != 0) {
            videoPath = version != 1 ? null : this.mTemplate.getPagFilePath();
        } else {
            videoPath = this.mTemplate.getVideoPath();
        }
        this.mEngine.setSrcPath(videoPath);
        this.mEngine.setOutputVideoPath(ShortVideoUtils.getLocalShortVideoPath());
        this.mEngine.setCallback(new EngineCallback(this));
        this.mEngine.setLutPath(this.mTemplate.getFilterLutPath());
        if (this.mTemplate.getWatermarkRect() != null) {
            this.mEngine.setWatermarkRect(this.mTemplate.getWatermarkRect());
        }
        this.mIsSavingVideo = Boolean.TRUE;
        this.mEngine.save(this.mTemplate.getVideoWidth(), this.mTemplate.getVideoHeight());
    }

    private void setBackgroundImage(NodeGroup nodeGroup) {
        Bitmap bitmap = this.mBackgroundBitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.mBackgroundBitmap.recycle();
        }
        if (this.mTemplate == null) {
            return;
        }
        String str = this.mTemplate.getMaterialPath() + File.separator + nodeGroup.nodeDefaultMaskCoverImage;
        Bitmap rotateWithExif = VideoShelfBitmapUtils.rotateWithExif(BitmapUtils.decodeSampleBitmap(getBaseActivity(), str, this.mTemplate.getVideoWidth(), this.mTemplate.getVideoHeight()), str);
        this.mBackgroundBitmap = rotateWithExif;
        this.mBackgroundImageView.setImageBitmap(rotateWithExif);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewBg(int i3) {
        RecyclerView recyclerView = this.mBoxRecycleView;
        if (recyclerView != null) {
            VideoListAdapter videoListAdapter = (VideoListAdapter) recyclerView.getAdapter();
            Bitmap centerViewBitmap = getCenterViewBitmap();
            if (videoListAdapter == null || !BitmapUtils.isLegal(centerViewBitmap)) {
                return;
            }
            videoListAdapter.setThumbBackground(i3, centerViewBitmap);
            videoListAdapter.updateThumbBackground();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOffscreenView(ViewGroup viewGroup, int i3) {
        int i16;
        NodeGroup nodeGroup = this.mNodeGroupList.get(i3);
        viewGroup.removeAllViews();
        Iterator<ScaleMoveImageViewer> it = this.mImageViewerSet.iterator();
        while (it.hasNext()) {
            ScaleMoveImageViewer next = it.next();
            if (next.getNodeGroupID() == nodeGroup.nodeGroupID && next.getNode().zIndex < 10000) {
                viewGroup.addView(next);
                imageLayout(next, this.mCenterViewWidth, this.mCenterViewHeight);
            }
        }
        Iterator<EditTextViewer> it5 = this.mTextViewerSet.iterator();
        while (it5.hasNext()) {
            EditTextViewer next2 = it5.next();
            if (next2.getNodeGroupID() == nodeGroup.nodeGroupID && next2.getNode().zIndex < 10000) {
                viewGroup.addView(next2);
                imageLayout(next2, this.mCenterViewWidth, this.mCenterViewHeight);
            }
        }
        Iterator<FaceImageViewer> it6 = this.mFaceImageViewerSet.iterator();
        while (it6.hasNext()) {
            FaceImageViewer next3 = it6.next();
            if (next3.getNodeGroupID() == nodeGroup.nodeGroupID && next3.getNode().zIndex < 10000) {
                viewGroup.addView(next3);
                imageLayout(next3, this.mCenterViewWidth, this.mCenterViewHeight);
            }
        }
        String str = this.mTemplate.getMaterialPath() + File.separator + nodeGroup.nodeDefaultMaskCoverImage;
        Bitmap rotateWithExif = VideoShelfBitmapUtils.rotateWithExif(BitmapUtils.decodeSampleBitmap(getBaseActivity(), str, this.mTemplate.getVideoWidth(), this.mTemplate.getVideoHeight()), str);
        ImageView imageView = new ImageView(getBaseActivity());
        imageView.setImageBitmap(rotateWithExif);
        viewGroup.addView(imageView);
        if (rotateWithExif != null) {
            float width = rotateWithExif.getWidth() / rotateWithExif.getHeight();
            int i17 = this.mCenterViewWidth;
            if (width < i17 / i17) {
                i16 = (int) (i17 / width);
            } else {
                int i18 = this.mCenterViewHeight;
                int i19 = (int) (i18 * width);
                i16 = i18;
                i17 = i19;
            }
            imageView.measure(View.MeasureSpec.makeMeasureSpec(i17, 1073741824), View.MeasureSpec.makeMeasureSpec(i16, 1073741824));
            int i26 = this.mCenterViewWidth;
            int i27 = this.mCenterViewHeight;
            imageView.layout((i26 - i17) / 2, (i27 - i16) / 2, (i26 + i17) / 2, (i27 + i16) / 2);
        }
        Iterator<ScaleMoveImageViewer> it7 = this.mImageViewerSet.iterator();
        while (it7.hasNext()) {
            ScaleMoveImageViewer next4 = it7.next();
            if (next4.getNodeGroupID() == nodeGroup.nodeGroupID && next4.getNode().zIndex >= 10000) {
                viewGroup.addView(next4);
                imageLayout(next4, this.mCenterViewWidth, this.mCenterViewHeight);
            }
        }
        Iterator<EditTextViewer> it8 = this.mTextViewerSet.iterator();
        while (it8.hasNext()) {
            EditTextViewer next5 = it8.next();
            if (next5.getNodeGroupID() == nodeGroup.nodeGroupID && next5.getNode().zIndex >= 10000) {
                viewGroup.addView(next5);
                imageLayout(next5, this.mCenterViewWidth, this.mCenterViewHeight);
            }
        }
        Iterator<FaceImageViewer> it9 = this.mFaceImageViewerSet.iterator();
        while (it9.hasNext()) {
            FaceImageViewer next6 = it9.next();
            if (next6.getNodeGroupID() == nodeGroup.nodeGroupID && next6.getNode().zIndex >= 10000) {
                viewGroup.addView(next6);
                imageLayout(next6, this.mCenterViewWidth, this.mCenterViewHeight);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading(String str) {
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null || baseActivity.isFinishing()) {
            return;
        }
        if (this.mLoadingDialog == null) {
            ReportDialog reportDialog = new ReportDialog(baseActivity, R.style.qZoneInputDialog);
            this.mLoadingDialog = reportDialog;
            reportDialog.setCancelable(false);
            this.mLoadingDialog.setCanceledOnTouchOutside(false);
            this.mLoadingDialog.setContentView(R.layout.f168383uh);
        }
        TextView textView = (TextView) this.mLoadingDialog.findViewById(R.id.photo_prievew_progress_dialog_text);
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
        } else {
            textView.setText(R.string.cuy);
        }
        this.mLoadingDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showProgressDialog() {
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProgress(int i3) {
        aj ajVar = this.ppd;
        if (ajVar == null) {
            return;
        }
        ajVar.t();
        this.ppd.i(i3);
        this.ppd.p(true);
        this.ppd.m(false);
        this.ppd.q(i3 + "%");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRVListItem(final int i3) {
        this.mBoxRecycleView.postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.ae.play.AEVideoShelfEditFragment.19
            @Override // java.lang.Runnable
            public void run() {
                AEVideoShelfEditFragment.this.setListViewBg(i3);
            }
        }, 100L);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.aelight.camera.ae.play.EditTextViewer.OnDownloadDialogListener
    public void hideDownloadDialog() {
        hideLoading();
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // com.tencent.mobileqq.activity.en
    public void onBackPressed() {
        getBaseActivity().finish();
    }

    public void onCancelCompleted() {
        ms.a.f(TAG, "Merge Video step onCancelCompleted");
        this.mGenerateBegin = 0L;
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.play.AEVideoShelfEditFragment.18
            @Override // java.lang.Runnable
            public void run() {
                AEVideoShelfEditFragment.this.dismissProgressDialog();
                AEVideoShelfEditFragment.this.mIsSavingVideo = Boolean.FALSE;
                AEVideoShelfEditFragment.keepScreenOn(AEVideoShelfEditFragment.this.getBaseActivity(), false);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!e.a(view)) {
            int id5 = view.getId();
            if (id5 == R.id.roi) {
                onBackPressed();
            } else if (id5 == R.id.rpg) {
                goNext();
                com.tencent.aelight.camera.ae.report.b.b().y1();
            } else if (id5 == R.id.rs8) {
                onFirstImageViewClick(view);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.aelight.camera.ae.play.EditTextViewer.OnSaveTextInfoListener
    public void onCompleteTextEdit(NodeItem nodeItem) {
        updateRVListItem(nodeItem.nodeGroupID);
    }

    public void onCompleted() {
        ms.a.f(TAG, "Merge Video step onCompleted");
        final long currentTimeMillis = this.mGenerateBegin > 0 ? System.currentTimeMillis() - this.mGenerateBegin : 0L;
        this.mGenerateBegin = 0L;
        finishAudioVideoMerge();
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.play.AEVideoShelfEditFragment.15
            @Override // java.lang.Runnable
            public void run() {
                if (((int) AEVideoShelfEditFragment.this.mProgress) < 100) {
                    AEVideoShelfEditFragment.this.updateProgress(100);
                    new BaseTimer().schedule(new TimerTask() { // from class: com.tencent.aelight.camera.ae.play.AEVideoShelfEditFragment.15.1
                        @Override // java.util.TimerTask, java.lang.Runnable
                        public void run() {
                            AEVideoShelfEditFragment.this.dismissProgressDialog();
                        }
                    }, 500L);
                } else {
                    AEVideoShelfEditFragment.this.dismissProgressDialog();
                }
                AEVideoShelfEditFragment.keepScreenOn(AEVideoShelfEditFragment.this.getBaseActivity(), false);
            }
        });
        startVideoTemplateSaveActivity(false);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        RecyclerView recyclerView = this.mBoxRecycleView;
        if (recyclerView != null) {
            recyclerView.setAdapter(null);
        }
        VideoListAdapter videoListAdapter = this.mVideoListAdapter;
        if (videoListAdapter != null) {
            videoListAdapter.clearBitmaps();
        }
        this.mVideoListAdapter = null;
        Bitmap bitmap = this.mBackgroundBitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.mBackgroundBitmap.recycle();
        }
        View view = this.mButtonCancel;
        if (view != null) {
            view.setOnClickListener(null);
        }
        TextView textView = this.mButtonOk;
        if (textView != null) {
            textView.setOnClickListener(null);
        }
        View view2 = this.mButtonChangeImage;
        if (view2 != null) {
            view2.setOnClickListener(null);
        }
        for (Bitmap bitmap2 : this.mBitmaps) {
            if (BitmapUtils.isLegal(bitmap2)) {
                bitmap2.recycle();
            }
        }
        Iterator<Map.Entry<String, Bitmap>> it = this.mSourceBitmaps.entrySet().iterator();
        while (it.hasNext()) {
            BitmapUtils.recycle(it.next().getValue());
        }
        this.mSourceBitmaps.clear();
        Iterator<ScaleMoveImageViewer> it5 = this.mImageViewerSet.iterator();
        while (it5.hasNext()) {
            it5.next().clearBitmaps();
        }
        Iterator<EditTextViewer> it6 = this.mTextViewerSet.iterator();
        while (it6.hasNext()) {
            EditTextViewer next = it6.next();
            next.clearBitmaps();
            next.setOnDownloadDialogListener(null);
        }
        Iterator<FaceImageViewer> it7 = this.mFaceImageViewerSet.iterator();
        while (it7.hasNext()) {
            it7.next().clearBitmaps();
        }
        dismissProgressDialog();
        keepScreenOn(getBaseActivity(), false);
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null && intent.getIntExtra(IPicChooseJumpUtil.PIC_RESULT_BACK_TYPE, -1) == 1) {
            String stringExtra = intent.getStringExtra("PhotoConst.SELECTED_PATHS");
            int intExtra = intent.getIntExtra(IPicChooseJumpUtil.PIC_NODE_ID, 0);
            NodeItem findNodeItemById = findNodeItemById(this.mNodeGroupList.get(this.mPrePos), intExtra);
            if (findNodeItemById == null) {
                return;
            }
            int i3 = findNodeItemById.type;
            if (i3 == 0) {
                onImageChanged(intExtra, stringExtra);
            } else if (i3 == 2) {
                onFaceImageChanged(intExtra, stringExtra, true);
            }
            if (TextUtils.isEmpty(stringExtra) || this.mNodeSourceMap.indexOfKey(intExtra) < 0) {
                return;
            }
            int i16 = this.mNodeSourceMap.get(intExtra);
            ArrayList<String> arrayList = this.mSourcePhotoList;
            if (arrayList == null || i16 < 0 || i16 >= arrayList.size()) {
                return;
            }
            this.mSourcePhotoList.remove(i16);
            this.mSourcePhotoList.add(i16, stringExtra);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.mIsSavingVideo.booleanValue()) {
            this.mEngine.cancelSave();
        }
    }

    public void onProgress(final int i3) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mLastUpdateProgressTimeMs > INTERVAL_UPDATE_PROGRESS) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.play.AEVideoShelfEditFragment.14
                @Override // java.lang.Runnable
                public void run() {
                    AEVideoShelfEditFragment.this.mProgress = i3 * 0.9d;
                    AEVideoShelfEditFragment aEVideoShelfEditFragment = AEVideoShelfEditFragment.this;
                    aEVideoShelfEditFragment.updateProgress((int) aEVideoShelfEditFragment.mProgress);
                }
            });
            this.mLastUpdateProgressTimeMs = currentTimeMillis;
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Iterator<ScaleMoveImageViewer> it = this.mImageViewerSet.iterator();
        while (it.hasNext()) {
            it.next().clearSeclected();
        }
        Iterator<EditTextViewer> it5 = this.mTextViewerSet.iterator();
        while (it5.hasNext()) {
            it5.next();
        }
        Iterator<FaceImageViewer> it6 = this.mFaceImageViewerSet.iterator();
        while (it6.hasNext()) {
            it6.next().clearSeclected();
        }
        clearTempFiles();
    }

    @Override // com.tencent.aelight.camera.ae.play.ScaleMoveImageViewer.OnSaveScrollInfoListener, com.tencent.aelight.camera.ae.play.FaceImageViewer.OnSaveScrollInfoListener
    public void onSaveScrollInfo(NodeItem nodeItem) {
        NodeGroup nodeGroup = new NodeGroup();
        for (int i3 = 0; i3 < this.mNodeGroupList.size(); i3++) {
            if (nodeItem.nodeGroupID == this.mNodeGroupList.get(i3).nodeGroupID) {
                nodeGroup = this.mNodeGroupList.get(i3);
            }
        }
        for (int i16 = 0; i16 < nodeGroup.nodeItemList.size(); i16++) {
            if (nodeItem.nodeID == nodeGroup.nodeItemList.get(i16).nodeID) {
                nodeGroup.nodeItemList.get(i16).once = nodeItem.once;
                nodeGroup.nodeItemList.get(i16).matrix.set(nodeItem.matrix);
                nodeGroup.nodeItemList.get(i16).bitmap = nodeItem.bitmap;
                nodeGroup.nodeItemList.get(i16).cropBitmap = nodeItem.cropBitmap;
            }
        }
    }

    @Override // com.tencent.aelight.camera.ae.play.EditTextViewer.OnSaveTextInfoListener
    public void onSaveTextInfo(NodeItem nodeItem) {
        NodeGroup nodeGroup = new NodeGroup();
        for (int i3 = 0; i3 < this.mNodeGroupList.size(); i3++) {
            if (nodeItem.nodeGroupID == this.mNodeGroupList.get(i3).nodeGroupID) {
                nodeGroup = this.mNodeGroupList.get(i3);
            }
        }
        for (int i16 = 0; i16 < nodeGroup.nodeItemList.size(); i16++) {
            if (nodeItem.nodeID == nodeGroup.nodeItemList.get(i16).nodeID) {
                nodeGroup.nodeItemList.get(i16).once = nodeItem.once;
                nodeGroup.nodeItemList.get(i16).bitmap = nodeItem.bitmap;
                nodeGroup.nodeItemList.get(i16).cropBitmap = nodeItem.cropBitmap;
                nodeGroup.nodeItemList.get(i16).nodeTextMaxCount = nodeItem.nodeTextMaxCount;
            }
        }
    }

    public void onStartGenerate() {
        ms.a.f(TAG, "Merge Video step onStartGenerate");
        this.mGenerateBegin = System.currentTimeMillis();
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.play.AEVideoShelfEditFragment.13
            @Override // java.lang.Runnable
            public void run() {
                AEVideoShelfEditFragment.this.showProgressDialog();
            }
        });
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        initData();
        initView();
        initSoftInputMode();
        this.outputDir = g.c.a.f65285c;
        File file = new File(this.outputDir);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    @Override // com.tencent.aelight.camera.ae.play.EditTextViewer.OnDownloadDialogListener
    public void showDownloadDialog() {
        showLoading(getResources().getString(R.string.y68));
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    private void onImageChanged(int i3, String str, boolean z16) {
        ScaleMoveImageViewer imageViewByNodeId = getImageViewByNodeId(i3);
        if (imageViewByNodeId == null || TextUtils.isEmpty(str)) {
            return;
        }
        Bitmap bitmap = this.mSourceBitmaps.get(str);
        if (bitmap == null) {
            bitmap = BitmapUtils.decodeSampleBitmap(getBaseActivity(), str, this.mTemplate.getVideoWidth(), this.mTemplate.getVideoHeight());
            this.mSourceBitmaps.put(str, bitmap);
        }
        if (BitmapUtils.isLegal(bitmap)) {
            Bitmap rotateWithExif = VideoShelfBitmapUtils.rotateWithExif(bitmap, str);
            if (rotateWithExif.getWidth() == 1 && rotateWithExif.getHeight() == 1) {
                rotateWithExif = BitmapUtils.scaleBitmap(rotateWithExif, 2.0f, true);
            }
            imageViewByNodeId.setNodeBitmap(rotateWithExif);
            imageViewByNodeId.setImageBitmap(rotateWithExif);
            imageViewByNodeId.setImageSelected(true);
            imageViewByNodeId.setMovable(true);
            imageViewByNodeId.clearSeclected();
            if (z16) {
                updateRVListItem(imageViewByNodeId.getNodeGroupID());
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        activity.requestWindowFeature(1);
        activity.getWindow().setFlags(1024, 1024);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initNodeGroup() {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (this.mTemplate == null) {
            return;
        }
        int i3 = 0;
        int i16 = 0;
        while (i16 < this.mTemplate.getNodeGroupList().size()) {
            MaskNodeGroup maskNodeGroup = this.mTemplate.getNodeGroupList().get(i16);
            NodeGroup nodeGroup = new NodeGroup();
            nodeGroup.nodeCoverImage = maskNodeGroup.getNodeGroupCoverImage();
            nodeGroup.nodeGroupID = maskNodeGroup.getNodeGroupID();
            nodeGroup.nodeDefaultMaskCoverImage = maskNodeGroup.getNodeGroupMaskImage();
            List<MaskNodeItem> nodeList = maskNodeGroup.getNodeList();
            nodeGroup.nodeItemList = new ArrayList();
            int i17 = i3;
            while (i17 < nodeList.size()) {
                MaskNodeItem maskNodeItem = nodeList.get(i17);
                NodeItem nodeItem = new NodeItem();
                nodeItem.nodeID = maskNodeItem.getNodeID();
                String nodeDefaultMaskCoverImage = maskNodeItem.getNodeDefaultMaskCoverImage();
                if (TextUtils.isEmpty(nodeDefaultMaskCoverImage)) {
                    if (maskNodeItem.getType() == 1) {
                        nodeItem.coverURL = null;
                    } else {
                        nodeItem.coverURL = nodeGroup.nodeDefaultMaskCoverImage;
                    }
                } else {
                    nodeItem.coverURL = nodeDefaultMaskCoverImage;
                }
                float[] maskRect = maskNodeItem.getMaskRect();
                RectF rectF = nodeItem.maskRect;
                float f16 = maskRect[i3];
                float f17 = maskRect[1];
                rectF.set(f16, f17, maskRect[2] + f16, f17 + maskRect[3]);
                nodeItem.once = true;
                nodeItem.type = maskNodeItem.getType();
                nodeItem.nodeGroupID = maskNodeItem.getNodeGroupID();
                nodeItem.zIndex = maskNodeItem.getZIndex();
                nodeItem.indexLayerForPag = maskNodeItem.getIndexLayerForPag();
                nodeItem.nodeTextMaxCount = maskNodeItem.getNodeTextMaxCount();
                if (!TextUtils.isEmpty(nodeItem.coverURL)) {
                    String str = this.mTemplate.getMaterialPath() + File.separator + nodeItem.coverURL;
                    Bitmap decodeSampleBitmap = BitmapUtils.decodeSampleBitmap(getBaseActivity(), str, this.mTemplate.getVideoWidth(), this.mTemplate.getVideoHeight());
                    nodeItem.bitmap = decodeSampleBitmap;
                    nodeItem.bitmap = VideoShelfBitmapUtils.rotateWithExif(decodeSampleBitmap, str);
                }
                if (maskNodeItem.getNodeTextGroup() != null) {
                    nodeItem.nodeTextGroup.copyFrom(maskNodeItem.getNodeTextGroup());
                    if (TextUtils.isEmpty(nodeItem.nodeTextGroup.fmtstr)) {
                        nodeItem.nodeTextGroup.fmtstr = "\u8bf7\u8f93\u5165\u6587\u5b57";
                        if (nodeItem.type == 1 && (bitmap2 = nodeItem.bitmap) != null && !bitmap2.isRecycled()) {
                            nodeItem.bitmap.recycle();
                            nodeItem.bitmap = null;
                        }
                    }
                    if (TextUtils.isEmpty(nodeItem.coverURL) && nodeItem.type == 1 && (bitmap = nodeItem.bitmap) != null && !bitmap.isRecycled()) {
                        nodeItem.bitmap.recycle();
                        nodeItem.bitmap = null;
                    }
                    nodeItem.nodeTextGroup.width = (int) (this.mTemplate.getVideoWidth() * maskRect[2]);
                    nodeItem.nodeTextGroup.height = (int) (this.mTemplate.getVideoHeight() * maskRect[3]);
                    NodeText nodeText = nodeItem.nodeTextGroup;
                    nodeText.fontSize = (nodeText.fontSize * this.mTemplate.getVideoWidth()) / WIDTH_BY_DESIGNER_USED;
                }
                this.mBitmaps.add(nodeItem.bitmap);
                nodeGroup.nodeItemList.add(nodeItem);
                i17++;
                i3 = 0;
            }
            this.mNodeGroupList.add(nodeGroup);
            i16++;
            i3 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void layoutView(View view, int i3, int i16, int i17, int i18) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i17, 1073741824), View.MeasureSpec.makeMeasureSpec(i18, 1073741824));
        view.layout(i3, i16, i17 + i3, i18 + i16);
    }

    private void startVideoTemplateSaveActivity(boolean z16) {
        if (!z16) {
            Log.i(TAG, "\u5df2\u7ecf\u5408\u6210\u5b8c\u89c6\u9891\uff0c\u4e0d\u8fdb\u884c\u5b9e\u65f6\u9884\u89c8\u3002");
            ms.a.f(TAG, "\u5df2\u7ecf\u5408\u6210\u5b8c\u89c6\u9891\uff0c\u4e0d\u8fdb\u884c\u5b9e\u65f6\u9884\u89c8\u3002");
            if (this.mTemplate == null || this.mFinalVideoPath == null) {
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("from", true);
            intent.putExtra(Constants.INTENT_KEY_MATERIAL_ID, this.mMaterialId);
            intent.putExtra(Constants.INTENT_KEY_FINAL_VIDEO_PATH, this.mFinalVideoPath);
            intent.putExtra(Constants.USE_PAG_PREVIEW, z16);
            intent.putExtra(Constants.INTENT_KEY_MATERIAL_PATH, this.mTemplatePath);
            intent.putExtra(Constants.INTENT_KEY_MATERIAL_NAME, this.mTemplate.getVideoName());
            intent.putStringArrayListExtra(AEQuDongConstants.INTENT_KEY_PHOTOLIST, this.mSourcePhotoList);
            intent.putExtra(AECameraConstants.LOC_PLAY_SHOW_TAB_NAME, this.playShowTabName);
            intent.putExtra(AECameraConstants.LOC_PLAY_SHOW_MATERIAL_ID, this.mMaterialId);
            intent.putExtra(AECameraConstants.LOC_PLAY_SHOW_TAKE_SAME_NAME, this.mTakeSameName);
            intent.putExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, AETemplateInfoFragment.getFromType(getBaseActivity()));
            intent.putExtra(AEVideoShelfPreviewFragment.IS_NEED_EDIT_BTN, true);
            checkJumpToPreview(intent);
            this.mIsSavingVideo = Boolean.FALSE;
            return;
        }
        jumpToPagRealtimePreview();
    }

    public void onError(int i3, int i16, String str) {
        this.mGenerateBegin = 0L;
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.play.AEVideoShelfEditFragment.17
            @Override // java.lang.Runnable
            public void run() {
                AEVideoShelfEditFragment.this.mIsSavingVideo = Boolean.FALSE;
                AEVideoShelfEditFragment.keepScreenOn(AEVideoShelfEditFragment.this.getBaseActivity(), false);
            }
        });
        ms.a.i(TAG, "Merge Video step onError");
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.dlt, viewGroup, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void detectFaceInternal(final FaceImageViewer faceImageViewer, Bitmap bitmap) {
        PTFaceAttr detectFace = FaceChangeUtils.detectFace(bitmap, 0.16666666666666666d);
        int faceCount = detectFace.getFaceCount();
        ArrayList<FaceParam> arrayList = new ArrayList();
        if (detectFace.getFaceInfoList() != null) {
            for (FaceInfo faceInfo : detectFace.getFaceInfoList()) {
                CosFunUtil.scale(faceInfo.points, 6.0d);
                FaceOffUtil.getFullCoords(faceInfo.points, 1.5f);
                PointF pointF = faceInfo.points.get(99);
                PointF pointF2 = faceInfo.points.get(103);
                FaceParam faceParam = new FaceParam((int) pointF.x, (int) pointF.y, (int) pointF2.x, (int) pointF2.y);
                faceParam.angles = faceInfo.angles;
                arrayList.add(faceParam);
            }
        }
        ms.a.a(TAG, "[PlayShow] onFaceImageChanged faceCount = " + faceCount);
        if (faceCount >= 1) {
            final FaceParam faceParam2 = (FaceParam) arrayList.get(0);
            for (FaceParam faceParam3 : arrayList) {
                if (faceParam3.getArea() > faceParam2.getArea()) {
                    faceParam2 = faceParam3;
                }
            }
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.play.AEVideoShelfEditFragment.10
                @Override // java.lang.Runnable
                public void run() {
                    AEVideoShelfEditFragment.this.initSelectedFacePosition(faceImageViewer, faceParam2);
                }
            });
            return;
        }
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.play.AEVideoShelfEditFragment.11
            @Override // java.lang.Runnable
            public void run() {
                QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.y65), 0).show();
            }
        });
    }

    private static Bitmap getBitmapFromView(RelativeLayout relativeLayout, int i3, int i16) {
        if (relativeLayout == null) {
            return null;
        }
        relativeLayout.setDrawingCacheEnabled(true);
        Bitmap createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
        relativeLayout.draw(new Canvas(createBitmap));
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(createBitmap, i3 / 4, i16 / 4, false);
        createBitmap.recycle();
        return createScaledBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListViewBg(RelativeLayout relativeLayout, int i3) {
        RecyclerView recyclerView = this.mBoxRecycleView;
        if (recyclerView != null) {
            VideoListAdapter videoListAdapter = (VideoListAdapter) recyclerView.getAdapter();
            Bitmap bitmapFromView = getBitmapFromView(relativeLayout, relativeLayout.getWidth(), relativeLayout.getHeight());
            if (videoListAdapter == null || !BitmapUtils.isLegal(bitmapFromView)) {
                return;
            }
            videoListAdapter.setThumbBackground(i3, bitmapFromView);
            videoListAdapter.updateThumbBackground();
        }
    }
}
