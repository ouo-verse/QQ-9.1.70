package com.tencent.aelight.camera.ae.play;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.aelight.camera.ae.g;
import com.tencent.aelight.camera.ae.play.FaceChangeUtils;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.ae.util.e;
import com.tencent.aelight.camera.ae.util.p;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.util.api.IAECameraPrefsUtil;
import com.tencent.aelight.camera.util.api.IPicChooseJumpUtil;
import com.tencent.biz.richframework.compat.f;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.activity.en;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.offlineset.OfflineFileUpdater;
import com.tencent.ttpic.videoshelf.data.Constants;
import com.tencent.ttpic.videoshelf.libpag.PagNotSupportSystemException;
import com.tencent.ttpic.videoshelf.model.edit.NodeGroup;
import com.tencent.ttpic.videoshelf.model.edit.NodeItem;
import com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayer;
import com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayerListener;
import com.tencent.ttpic.videoshelf.model.player.PagShelfPlayer;
import com.tencent.ttpic.videoshelf.model.player.VideoShelfPlayer;
import com.tencent.ttpic.videoshelf.model.template.MaskNodeGroup;
import com.tencent.ttpic.videoshelf.model.template.MaskNodeItem;
import com.tencent.ttpic.videoshelf.model.template.VideoShelfTemplate;
import com.tencent.ttpic.videoshelf.parser.TemplateParser;
import gq.c;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.light.device.OfflineConfig;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AETemplateInfoFragment extends IphoneTitleBarFragment implements View.OnClickListener, en {
    public static final String CACHE_DIR;
    public static final String PREFERENCE_K_QUDONG_LAST_CRAZY_FACE_PHOTO = "ae_preference_k_qudong_last_crazy_face_photo";
    public static final int REQUEST_CODE_TAKE_FACE_PHOTO = 1024;
    private static final String TAG = "AETemplateInfoFragment";
    private List<String> crazyFaceMaterials;
    private boolean isCrazyFace;
    private ImageView mLastImg;
    private ViewGroup mLastLayout;
    private Bitmap mLastPhoto;
    private String mLastPhotoPath;
    private Dialog mLoadingDialog;
    private String mMaterialId;
    private String mMaterialName;
    private String mMaterialPath;
    private TextView mNextButton;
    private FrameLayout mPlayerContainer;
    private PlayerListener mPlayerListener;
    private TextView mPlayerRateView;
    private ArrayList<String> mSelectedPhotoList;
    private String mTakeSameName;
    private VideoShelfTemplate mTemplate;
    private TextView mTipsTextView;
    private TextView mTitleTextView;
    private IVideoShelfPlayer mVideoPlayer;
    private int mVideoPosition;
    private TextureView mVideoView;
    private ImageView playerStatusView;
    private int screenHeight;
    private int screenWidth;
    private Dialog tipDialog;
    private boolean mNeedPlayVideo = true;
    private boolean mSurfaceReady = false;
    private String playShowTabName = "";
    private boolean mIsSimpleChinese = true;
    private boolean mIsEnglish = false;
    private boolean mHasTextNode = false;
    private ArrayList<String> mCropPhotoCacheList = new ArrayList<>();
    private List<NodeGroup> mNodeGroupList = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class PlayerListener implements IVideoShelfPlayerListener {
        private WeakReference<AETemplateInfoFragment> mRef;

        public PlayerListener(AETemplateInfoFragment aETemplateInfoFragment) {
            this.mRef = new WeakReference<>(aETemplateInfoFragment);
        }

        @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayerListener
        public boolean onError(int i3, String str, Object obj) {
            QLog.i(AETemplateInfoFragment.TAG, 1, "[player lifecycle]---PlayerListener onError errCode=" + i3 + ", msg=" + str);
            WeakReference<AETemplateInfoFragment> weakReference = this.mRef;
            if (weakReference != null && weakReference.get() != null) {
                this.mRef.get().onPlayError();
            }
            return true;
        }

        @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayerListener
        public void onUpdateRate(long j3) {
            WeakReference<AETemplateInfoFragment> weakReference = this.mRef;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.mRef.get().onUpdateRate(j3);
        }

        @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayerListener
        public void onCompletion() {
            QLog.i(AETemplateInfoFragment.TAG, 1, "[player lifecycle]---PlayerListener onCompletion");
            WeakReference<AETemplateInfoFragment> weakReference = this.mRef;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.mRef.get().onPlayComplete();
        }

        @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayerListener
        public void onPrepared(IVideoShelfPlayer iVideoShelfPlayer) {
        }

        @Override // com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayerListener
        public void onChangVideoSize(int i3, int i16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class PlayerSurfaceTextureCallback implements TextureView.SurfaceTextureListener {
        private WeakReference<AETemplateInfoFragment> mRef;

        public PlayerSurfaceTextureCallback(AETemplateInfoFragment aETemplateInfoFragment) {
            this.mRef = new WeakReference<>(aETemplateInfoFragment);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            QLog.i(AETemplateInfoFragment.TAG, 1, "[player lifecycle]---onSurfaceTextureDestroyed");
            WeakReference<AETemplateInfoFragment> weakReference = this.mRef;
            if (weakReference != null && weakReference.get() != null) {
                this.mRef.get().surfaceTextureDestroyed();
            }
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
            QLog.i(AETemplateInfoFragment.TAG, 1, "[player lifecycle]---onSurfaceTextureAvailable");
            WeakReference<AETemplateInfoFragment> weakReference = this.mRef;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.mRef.get().surfaceTextureAvailable(surfaceTexture);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
            QLog.i(AETemplateInfoFragment.TAG, 1, "[player lifecycle]---onSurfaceTextureSizeChanged");
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    static {
        String str = g.c.a.f65284b;
        CACHE_DIR = str;
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    private String buildTips(VideoShelfTemplate videoShelfTemplate) {
        int[] tipTemplate;
        String str;
        String str2;
        String str3 = "";
        if (videoShelfTemplate == null || (tipTemplate = videoShelfTemplate.getTipTemplate()) == null || tipTemplate.length == 0) {
            return "";
        }
        int i3 = tipTemplate[0];
        if (getResources() == null) {
            str = "";
        } else {
            str = String.format("\u9700\u9009\u62e9%d\u5f20\u56fe\u7247", Integer.valueOf(i3));
        }
        if (i3 == 0) {
            str = "";
        }
        if ((tipTemplate.length > 1 ? tipTemplate[1] : 0) <= 0) {
            str2 = "";
        } else {
            str2 = "\u53ef\u4fee\u6539\u6587\u5b57";
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && this.mIsEnglish) {
            str3 = " ";
        }
        return str + str3 + str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelTipDialog() {
        Dialog dialog = this.tipDialog;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.tipDialog.dismiss();
    }

    private void changeFace(String str) {
        List<String> list;
        if (TextUtils.isEmpty(str) || (list = this.crazyFaceMaterials) == null || list.isEmpty() || BitmapUtils.decodeSampleBitmap(getBaseActivity(), str, this.screenWidth, this.screenHeight) == null) {
            return;
        }
        AECameraPrefsUtil.f().p(PREFERENCE_K_QUDONG_LAST_CRAZY_FACE_PHOTO, str, 0);
        showLoading(true);
        System.currentTimeMillis();
        this.mNeedPlayVideo = false;
        pauseVideo();
    }

    private String cropHeadOfImage(String str) {
        File file = new File(str);
        File file2 = new File(g.c.a.f65283a);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        final String str2 = file2.getPath() + File.separator + "crop_" + file.getName();
        Bitmap decodeSampleBitmap = BitmapUtils.decodeSampleBitmap(getBaseActivity(), str, this.mTemplate.getVideoWidth(), this.mTemplate.getVideoHeight());
        if (!BitmapUtils.isLegal(decodeSampleBitmap)) {
            return str;
        }
        Bitmap rotateWithExif = VideoShelfBitmapUtils.rotateWithExif(decodeSampleBitmap, str);
        if (rotateWithExif.getWidth() == 1 && rotateWithExif.getHeight() == 1) {
            rotateWithExif = BitmapUtils.scaleBitmap(rotateWithExif, 2.0f, true);
        }
        final boolean[] zArr = {false};
        FaceChangeUtils.cropFace(rotateWithExif, new FaceChangeUtils.CropFaceCallback() { // from class: com.tencent.aelight.camera.ae.play.AETemplateInfoFragment.4
            @Override // com.tencent.aelight.camera.ae.play.FaceChangeUtils.CropFaceCallback
            public void onFail(int i3) {
                zArr[0] = false;
            }

            @Override // com.tencent.aelight.camera.ae.play.FaceChangeUtils.CropFaceCallback
            public void onSuccess(Bitmap bitmap) {
                zArr[0] = true;
                BitmapUtils.saveBitmap(bitmap, str2);
            }
        }, true);
        return zArr[0] ? str2 : str;
    }

    public static int dp2px(Context context, float f16) {
        return (int) TypedValue.applyDimension(1, f16, context.getResources().getDisplayMetrics());
    }

    public static int getFromType(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).getIntent().getIntExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, js.a.f410904d.b());
        }
        return js.a.f410904d.b();
    }

    private void initData() {
        this.screenWidth = zr.a.f(getBaseActivity());
        this.screenHeight = zr.a.e(getBaseActivity());
        Intent intent = getBaseActivity().getIntent();
        if (intent != null) {
            this.mMaterialPath = intent.getStringExtra(Constants.INTENT_KEY_MATERIAL_PATH);
            this.mMaterialId = intent.getStringExtra(Constants.INTENT_KEY_MATERIAL_ID);
            this.mMaterialName = intent.getStringExtra(Constants.INTENT_KEY_MATERIAL_NAME);
            this.playShowTabName = intent.getStringExtra(AECameraConstants.LOC_PLAY_SHOW_TAB_NAME);
            this.mTakeSameName = intent.getStringExtra(AECameraConstants.LOC_PLAY_SHOW_TAKE_SAME_NAME);
        }
        if (this.mTemplate == null && !TextUtils.isEmpty(this.mMaterialPath)) {
            loadTemplate(this.mMaterialPath);
        }
        VideoShelfTemplate videoShelfTemplate = this.mTemplate;
        if (videoShelfTemplate != null) {
            List<String> crazyFaceList = videoShelfTemplate.getCrazyFaceList();
            this.crazyFaceMaterials = crazyFaceList;
            this.isCrazyFace = (crazyFaceList == null || crazyFaceList.isEmpty()) ? false : true;
        }
        if (this.isCrazyFace) {
            String j3 = AECameraPrefsUtil.f().j(PREFERENCE_K_QUDONG_LAST_CRAZY_FACE_PHOTO, null, 0);
            this.mLastPhotoPath = j3;
            if (!TextUtils.isEmpty(j3)) {
                this.mLastPhoto = BitmapUtils.decodeSampleBitmap(getBaseActivity(), this.mLastPhotoPath, getBaseActivity().getResources().getDimensionPixelSize(R.dimen.f158048bb4), getBaseActivity().getResources().getDimensionPixelSize(R.dimen.f158047bb3));
            }
        }
        OfflineFileUpdater.setHttpClient(new UrlConHttpClient());
        OfflineFileUpdater.checkOfflineFile();
    }

    private void initNodeGroup() {
        if (this.mTemplate == null) {
            return;
        }
        for (int i3 = 0; i3 < this.mTemplate.getNodeGroupList().size(); i3++) {
            MaskNodeGroup maskNodeGroup = this.mTemplate.getNodeGroupList().get(i3);
            NodeGroup nodeGroup = new NodeGroup();
            nodeGroup.nodeGroupID = maskNodeGroup.getNodeGroupID();
            List<MaskNodeItem> nodeList = maskNodeGroup.getNodeList();
            nodeGroup.nodeItemList = new ArrayList();
            for (int i16 = 0; i16 < nodeList.size(); i16++) {
                MaskNodeItem maskNodeItem = nodeList.get(i16);
                NodeItem nodeItem = new NodeItem();
                nodeItem.nodeID = maskNodeItem.getNodeID();
                nodeItem.type = maskNodeItem.getType();
                nodeItem.nodeGroupID = maskNodeItem.getNodeGroupID();
                nodeItem.zIndex = maskNodeItem.getZIndex();
                nodeItem.indexLayerForPag = maskNodeItem.getIndexLayerForPag();
                nodeGroup.nodeItemList.add(nodeItem);
            }
            this.mNodeGroupList.add(nodeGroup);
        }
    }

    private void initView() {
        View view = getView();
        this.mNextButton = (TextView) view.findViewById(R.id.rxl);
        this.mLastImg = (ImageView) view.findViewById(R.id.ruv);
        this.mLastLayout = (ViewGroup) view.findViewById(R.id.rw9);
        this.mNextButton.setOnClickListener(this);
        this.mLastLayout.setOnClickListener(this);
        this.mTitleTextView = (TextView) view.findViewById(R.id.s2p);
        this.mTipsTextView = (TextView) view.findViewById(R.id.s2o);
        this.mPlayerRateView = (TextView) view.findViewById(R.id.ryh);
        if (isDebugVersion()) {
            this.mPlayerRateView.setVisibility(0);
            this.mPlayerRateView.setText("0(fps)");
            this.mPlayerRateView.setTextColor(SupportMenu.CATEGORY_MASK);
        }
        this.playerStatusView = (ImageView) view.findViewById(R.id.ryi);
        TextureView textureView = (TextureView) view.findViewById(R.id.ryl);
        this.mVideoView = textureView;
        textureView.setKeepScreenOn(true);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.ryg);
        this.mPlayerContainer = frameLayout;
        frameLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.aelight.camera.ae.play.AETemplateInfoFragment.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                AETemplateInfoFragment.this.mPlayerContainer.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (AETemplateInfoFragment.this.mTemplate == null || AETemplateInfoFragment.this.mTemplate.getVideoHeight() == 0 || AETemplateInfoFragment.this.mTemplate.getVideoWidth() == 0) {
                    return;
                }
                float videoWidth = AETemplateInfoFragment.this.mTemplate.getVideoWidth() / AETemplateInfoFragment.this.mTemplate.getVideoHeight();
                int width = AETemplateInfoFragment.this.mPlayerContainer.getWidth();
                int height = AETemplateInfoFragment.this.mPlayerContainer.getHeight();
                float f16 = width / height;
                if (QLog.isDebugVersion()) {
                    QLog.d(AETemplateInfoFragment.TAG, 2, "adjust player size---origin w:h=", Integer.valueOf(width), ":", Integer.valueOf(height), " availableRatio(w/h)=", Float.valueOf(f16), " video aspectRation(w/h)=" + videoWidth);
                }
                if (videoWidth < f16) {
                    ViewGroup.LayoutParams layoutParams = AETemplateInfoFragment.this.mPlayerContainer.getLayoutParams();
                    layoutParams.width = (int) (AETemplateInfoFragment.this.mPlayerContainer.getHeight() * videoWidth);
                    AETemplateInfoFragment.this.mPlayerContainer.setLayoutParams(layoutParams);
                    return;
                }
                if (videoWidth > f16) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) AETemplateInfoFragment.this.mPlayerContainer.getLayoutParams();
                    marginLayoutParams.height = (int) (AETemplateInfoFragment.this.mPlayerContainer.getWidth() / videoWidth);
                    AETemplateInfoFragment.this.mPlayerContainer.setLayoutParams(marginLayoutParams);
                }
            }
        });
        this.mVideoView.setOnClickListener(this);
        this.mVideoView.setSurfaceTextureListener(new PlayerSurfaceTextureCallback(this));
        this.mPlayerListener = new PlayerListener(this);
        if (this.isCrazyFace) {
            if (this.mLastPhoto != null) {
                this.mLastLayout.setVisibility(0);
                this.mLastImg.setImageBitmap(this.mLastPhoto);
                this.mNextButton.setTextColor(-16777216);
                this.mNextButton.setBackgroundResource(R.drawable.isl);
                this.mNextButton.setText(R.string.y66);
                this.mTipsTextView.setVisibility(8);
                return;
            }
            this.mTipsTextView.setText(R.string.f169895y63);
            this.mTipsTextView.setVisibility(0);
        }
    }

    private boolean isDebugVersion() {
        return false;
    }

    private boolean isNeedRealTimePlay() {
        VideoShelfTemplate videoShelfTemplate = this.mTemplate;
        return (videoShelfTemplate == null || videoShelfTemplate.getPagFileName() == null || this.mTemplate.getPagFilePath() == null || this.mTemplate.getPreviewVideoType() != 1 || OfflineConfig.isNotSuptPagRealTime()) ? false : true;
    }

    private void jumpToEdit() {
        if (this.mTemplate == null) {
            return;
        }
        AEVideoShelfEditFragment.jumpToMe(getBaseActivity(), this.playShowTabName, this.mTemplate.getMaterialPath(), this.mMaterialId, this.mTemplate.getVideoName(), this.mSelectedPhotoList, 1, this.mTakeSameName);
    }

    public static void jumpToMe(Context context, String str, String str2, String str3, String str4, String str5) {
        Intent intent = new Intent();
        intent.putExtra(Constants.INTENT_KEY_MATERIAL_PATH, str2);
        intent.putExtra(Constants.INTENT_KEY_MATERIAL_ID, str3);
        intent.putExtra(Constants.INTENT_KEY_MATERIAL_NAME, str4);
        intent.putExtra(AECameraConstants.LOC_PLAY_SHOW_TAB_NAME, str);
        intent.putExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, getFromType(context));
        intent.putExtra(AECameraConstants.LOC_PLAY_SHOW_TAKE_SAME_NAME, str5);
        PublicFragmentActivity.b.a(context, intent, PublicFragmentActivityForPeak.class, AETemplateInfoFragment.class);
    }

    private void jumpToPagRealtimePreview(boolean z16) {
        Log.i(TAG, "\u672a\u5408\u6210\u89c6\u9891\uff0c\u5c06\u76f4\u63a5\u5b9e\u65f6\u9884\u89c8\u3002");
        ms.a.f(TAG, "\u672a\u5408\u6210\u89c6\u9891\uff0c\u5c06\u76f4\u63a5\u5b9e\u65f6\u9884\u89c8\u3002");
        if (this.mTemplate == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("from", true);
        intent.putExtra(AEVideoShelfPreviewFragment.IS_NEED_EDIT_BTN, !z16);
        intent.putExtra(Constants.USE_PAG_PREVIEW, true);
        intent.putExtra(Constants.VIDEO_OUT_WIDTH, this.mTemplate.getVideoWidth());
        intent.putExtra(Constants.VIDEO_OUT_HEIGHT, this.mTemplate.getVideoHeight());
        intent.putExtra(Constants.PAG_FILE_PATH, this.mTemplate.getPagFilePath());
        intent.putExtra(Constants.AUDIO_FILE_PATH, this.mTemplate.getAudioPath());
        intent.putExtra(Constants.INTENT_KEY_MATERIAL_PATH, this.mTemplate.getMaterialPath());
        intent.putExtra(Constants.INTENT_KEY_MATERIAL_NAME, this.mTemplate.getVideoName());
        intent.putExtra(AECameraConstants.LOC_PLAY_SHOW_TAB_NAME, this.playShowTabName);
        intent.putExtra(AECameraConstants.LOC_PLAY_SHOW_MATERIAL_ID, this.mMaterialId);
        intent.putExtra(AECameraConstants.LOC_PLAY_SHOW_TAKE_SAME_NAME, this.mTakeSameName);
        intent.putExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, getFromType(getBaseActivity()));
        intent.putStringArrayListExtra(AEQuDongConstants.INTENT_KEY_PHOTOLIST, this.mSelectedPhotoList);
        intent.putExtra(Constants.INTENT_KEY_MATERIAL_ID, this.mMaterialId);
        initNodeGroup();
        HashMap hashMap = new HashMap();
        Iterator<NodeGroup> it = this.mNodeGroupList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            for (NodeItem nodeItem : it.next().nodeItemList) {
                ArrayList<String> arrayList = this.mSelectedPhotoList;
                if (arrayList != null && i3 < arrayList.size()) {
                    String str = this.mSelectedPhotoList.get(i3);
                    if (nodeItem.type == 2) {
                        str = cropHeadOfImage(this.mSelectedPhotoList.get(i3));
                        this.mCropPhotoCacheList.add(str);
                    }
                    hashMap.put(str, nodeItem.indexLayerForPag);
                    i3++;
                }
            }
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constants.NODE_IMG_LIST, hashMap);
        intent.putExtras(bundle);
        AEVideoShelfPreviewFragment.jumpToMe(getBaseActivity(), intent, 1);
    }

    private void loadTemplate(String str) {
        try {
            if (this.mTemplate == null) {
                this.mTemplate = TemplateParser.parse(getBaseActivity(), str);
            }
        } catch (IllegalArgumentException unused) {
            ms.a.i(TAG, "loadTemplate Error!");
        }
    }

    private void onNext() {
        VideoShelfTemplate videoShelfTemplate = this.mTemplate;
        if (videoShelfTemplate != null && !TextUtils.isEmpty(videoShelfTemplate.getMaterialPath())) {
            if (this.isCrazyFace) {
                startTakeFacePhotoNext();
                return;
            }
            boolean z16 = false;
            int i3 = 0;
            int i16 = 0;
            for (int i17 = 0; i17 < this.mTemplate.getNodeGroupList().size(); i17++) {
                if (this.mTemplate.getNodeGroupList().get(i17) != null && this.mTemplate.getNodeGroupList().get(i17).getNodeList() != null) {
                    for (int i18 = 0; i18 < this.mTemplate.getNodeGroupList().get(i17).getNodeList().size(); i18++) {
                        if (this.mTemplate.getNodeGroupList().get(i17).getNodeList().get(i18).getType() != 1) {
                            i16++;
                        } else {
                            i3++;
                        }
                    }
                }
            }
            this.mHasTextNode = i3 > 0;
            if (i3 > 0 && i16 == 0) {
                z16 = true;
            }
            if (z16) {
                jumpToEdit();
                return;
            } else {
                startAlumNext(i16);
                return;
            }
        }
        ms.a.i(TAG, "onNext template Error!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPlayError() {
        ms.a.i(TAG, "onPlayError!");
    }

    private void pauseVideo() {
        IVideoShelfPlayer iVideoShelfPlayer = this.mVideoPlayer;
        if (iVideoShelfPlayer != null) {
            if (iVideoShelfPlayer.isPlaying()) {
                this.mVideoPlayer.pause();
                QLog.i(TAG, 1, "[player lifecycle]---pauseVideo done");
                videoViewStatusPause();
                return;
            }
            QLog.i(TAG, 1, "[player lifecycle]---pauseVideo enter, mVideoPlayer is not playing");
            return;
        }
        QLog.i(TAG, 1, "[player lifecycle]---pauseVideo enter, mVideoPlayer is null");
    }

    private void playVideo() {
        IVideoShelfPlayer iVideoShelfPlayer;
        String str;
        if (this.mTemplate == null || (iVideoShelfPlayer = this.mVideoPlayer) == null) {
            return;
        }
        iVideoShelfPlayer.reset();
        this.mVideoPlayer.setVideoShelfPlayerListener(this.mPlayerListener);
        String previewVideoPath = this.mTemplate.getPreviewVideoPath();
        if (this.mVideoPlayer instanceof PagShelfPlayer) {
            previewVideoPath = this.mTemplate.getPagFilePath();
            str = this.mTemplate.getAudioPath();
        } else {
            str = null;
        }
        if (this.mTemplate.isFromAssets()) {
            this.mVideoPlayer.setDataSource(getBaseActivity().getAssets(), previewVideoPath);
            if (str != null && FileUtils.exists(str)) {
                this.mVideoPlayer.setParam(PagShelfPlayer.AUDIO_PATH, Boolean.TRUE, getBaseActivity().getAssets(), str);
            }
        } else {
            this.mVideoPlayer.setDataSource(previewVideoPath);
            if (str != null && FileUtils.exists(str)) {
                this.mVideoPlayer.setParam(PagShelfPlayer.AUDIO_PATH, Boolean.FALSE, str);
            }
        }
        this.mVideoPlayer.prepare();
        this.mVideoPlayer.seekTo(this.mVideoPosition);
        if (this.mNeedPlayVideo) {
            this.mVideoPlayer.start();
            QLog.i(TAG, 1, "[player lifecycle]---mVideoPlayer.start() in playVideo");
        }
    }

    private void previewTemplate() {
        if (this.mTemplate != null) {
            showTemplate();
            playVideo();
        }
    }

    private void resumeVideoToStart() {
        if (this.mVideoPlayer != null) {
            onPlayComplete();
        }
    }

    private void showFirstEntryTipDialog() {
        Dialog dialog = this.tipDialog;
        if (dialog != null) {
            if (dialog.isShowing()) {
                this.tipDialog.dismiss();
            }
        } else {
            ReportDialog reportDialog = new ReportDialog(getBaseActivity(), R.style.qZoneInputDialog);
            this.tipDialog = reportDialog;
            reportDialog.setCancelable(true);
            this.tipDialog.setCanceledOnTouchOutside(true);
            this.tipDialog.setContentView(R.layout.dmg);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = getActivity().getResources().getDrawable(R.color.f158017al3);
            URLDrawable drawable = URLDrawable.getDrawable("https://dl.url.cn/myapp/qq_desk/qqrm/videofilter/Pturenwu/tipss.png", obtain);
            URLImageView uRLImageView = (URLImageView) this.tipDialog.findViewById(R.id.rva);
            TextView textView = (TextView) this.tipDialog.findViewById(R.id.f163805s34);
            uRLImageView.setImageDrawable(drawable);
            this.tipDialog.show();
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.play.AETemplateInfoFragment.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    c.s(AETemplateInfoFragment.this.getBaseActivity(), 1024, js.a.U.b(), null);
                    AETemplateInfoFragment.this.cancelTipDialog();
                    EventCollector.getInstance().onViewClicked(view);
                }
            });
        }
        if (this.tipDialog.isShowing()) {
            return;
        }
        this.tipDialog.show();
    }

    private void showLoading(boolean z16) {
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null || baseActivity.isFinishing()) {
            return;
        }
        if (z16) {
            if (this.mLoadingDialog == null) {
                ReportDialog reportDialog = new ReportDialog(baseActivity, R.style.qZoneInputDialog);
                this.mLoadingDialog = reportDialog;
                reportDialog.setCancelable(false);
                this.mLoadingDialog.setCanceledOnTouchOutside(false);
                this.mLoadingDialog.setContentView(R.layout.f168383uh);
            }
            this.mLoadingDialog.show();
            return;
        }
        Dialog dialog = this.mLoadingDialog;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.mLoadingDialog.dismiss();
    }

    private void showTemplate() {
        if (this.mIsSimpleChinese) {
            this.mTitleTextView.setText(this.mTemplate.getName());
            this.mTipsTextView.setText(this.mTemplate.getTip());
            return;
        }
        this.mTitleTextView.setText(this.mMaterialName);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTipsTextView.getLayoutParams();
        this.mTipsTextView.setLines(2);
        layoutParams.height = (int) (this.mTipsTextView.getContext().getResources().getDisplayMetrics().density * 32.0f);
        this.mTipsTextView.setLayoutParams(layoutParams);
        this.mTipsTextView.setText(buildTips(this.mTemplate));
    }

    private void startAlumNext(int i3) {
        p.b(getBaseActivity(), i3);
    }

    private void startTakeFacePhotoNext() {
        if (!isNeedRealTimePlay()) {
            QQToast.makeText(getBaseActivity(), getBaseActivity().getString(R.string.y5w), 0).show();
        } else if (AECameraPrefsUtil.f().c(IAECameraPrefsUtil.KEY_FIRST_CHANGE_FACE_CLICK, true, 0)) {
            AECameraPrefsUtil.f().l(IAECameraPrefsUtil.KEY_FIRST_CHANGE_FACE_CLICK, false, 0);
            showFirstEntryTipDialog();
        } else {
            c.s(getBaseActivity(), 1024, js.a.U.b(), null);
        }
    }

    private void stopVideo() {
        IVideoShelfPlayer iVideoShelfPlayer = this.mVideoPlayer;
        if (iVideoShelfPlayer != null) {
            if (iVideoShelfPlayer.isPlaying()) {
                this.mVideoPlayer.stop();
                QLog.i(TAG, 1, "[player lifecycle]---stopVideo done");
            } else {
                QLog.i(TAG, 1, "[player lifecycle]---stopVideo enter, mVideoPlayer is not playing");
            }
            try {
                this.mVideoPlayer.setSurface(null);
            } catch (Exception e16) {
                ms.a.d(TAG, "mVideoPlayer.setSurface(null) raise exception: ", e16);
            }
            this.mVideoPosition = this.mVideoPlayer.getCurrentPosition();
            videoViewStatusPause();
            this.mNeedPlayVideo = false;
            this.mVideoPlayer = null;
            return;
        }
        QLog.i(TAG, 1, "[player lifecycle]---stopVideo enter, mVideoPlayer is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
    
        r0 = new com.tencent.ttpic.videoshelf.model.player.PagShelfPlayer();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void surfaceTextureAvailable(SurfaceTexture surfaceTexture) {
        boolean z16 = true;
        QLog.i(TAG, 1, "[player lifecycle]---surfaceTextureAvailable");
        this.mSurfaceReady = true;
        if (this.mTemplate == null && !TextUtils.isEmpty(this.mMaterialPath)) {
            loadTemplate(this.mMaterialPath);
        }
        try {
            if (this.mVideoPlayer == null) {
                VideoShelfTemplate videoShelfTemplate = this.mTemplate;
                if (videoShelfTemplate == null || videoShelfTemplate.getVersion() != 1 || (this.mTemplate.getPreviewVideoPath() != null && FileUtils.exists(this.mTemplate.getPreviewVideoPath()))) {
                    z16 = false;
                }
                IVideoShelfPlayer videoShelfPlayer = new VideoShelfPlayer();
                this.mVideoPlayer = videoShelfPlayer;
            }
            this.mVideoPlayer.setSurface(new Surface(surfaceTexture));
            previewTemplate();
        } catch (PagNotSupportSystemException e16) {
            ms.a.c(TAG, e16.getMessage());
            popNotSupportPagToast("pag\u7248\u672c\u8fc7\u4f4e");
        }
    }

    private void toastInUIThread(final String str) {
        getBaseActivity().runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.play.AETemplateInfoFragment.5
            @Override // java.lang.Runnable
            public void run() {
                QQToast.makeText(BaseApplicationImpl.getApplication(), str, 1).show();
            }
        });
    }

    private void toggleVideoStatus() {
        IVideoShelfPlayer iVideoShelfPlayer = this.mVideoPlayer;
        if (iVideoShelfPlayer != null) {
            if (iVideoShelfPlayer.isPlaying()) {
                this.mVideoPlayer.pause();
                videoViewStatusPause();
            } else {
                this.mNeedPlayVideo = true;
                this.mVideoPlayer.start();
                videoViewStatusPlay();
            }
        }
    }

    private void videoViewStatusPause() {
        this.playerStatusView.setVisibility(0);
    }

    private void videoViewStatusPlay() {
        this.playerStatusView.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    protected int getContentLayoutId() {
        return R.layout.dlu;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i3 == 1024 && i16 == -1) {
            changeFace(intent.getExtras().getString(AECameraConstants.INTENT_RESULT_KEY_TAKE_PHOTO_PATH));
        }
    }

    @Override // com.tencent.mobileqq.activity.en
    public void onBackPressed() {
        getBaseActivity().finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!e.a(view)) {
            switch (view.getId()) {
                case R.id.rw9 /* 2097545591 */:
                    changeFace(this.mLastPhotoPath);
                    com.tencent.aelight.camera.ae.report.b.b().B1();
                    break;
                case R.id.rxl /* 2097545641 */:
                    onNext();
                    if (!this.isCrazyFace) {
                        com.tencent.aelight.camera.ae.report.b.b().x1();
                        break;
                    } else {
                        com.tencent.aelight.camera.ae.report.b.b().A1();
                        break;
                    }
                case R.id.ryl /* 2097545678 */:
                    toggleVideoStatus();
                    break;
                case R.id.amm /* 2131364861 */:
                    onBackPressed();
                    break;
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null && intent.getIntExtra(IPicChooseJumpUtil.PIC_RESULT_BACK_TYPE, -1) == 0) {
            this.mSelectedPhotoList = intent.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
            if (isNeedRealTimePlay() && !this.mHasTextNode) {
                startPreviewNext();
            } else {
                jumpToEdit();
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    public void onUpdateRate(long j3) {
        if (isDebugVersion()) {
            this.mPlayerRateView.setText(j3 + "(fps)");
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.f211156vg.setTitle("\u6a21\u677f\u8be6\u60c5");
        if (!FeatureManager.Features.PAG.init()) {
            ms.a.c(TAG, "pag\u76f8\u5173so\u672a\u521d\u59cb\u5316\u6210\u529f");
            QQToast.makeText(getBaseActivity(), "pag\u76f8\u5173so\u672a\u521d\u59cb\u5316\u6210\u529f", 0).show();
        } else {
            initData();
            initView();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    private void startPreviewNext() {
        showLoading(true);
        jumpToPagRealtimePreview(false);
        showLoading(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void surfaceTextureDestroyed() {
        QLog.i(TAG, 1, "[player lifecycle]---surfaceTextureDestroyed");
        this.mSurfaceReady = false;
        stopVideo();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        QLog.i(TAG, 1, "[player lifecycle]---onDestroy");
        stopVideo();
        super.onDestroy();
        cancelTipDialog();
        BitmapUtils.recycle(this.mLastPhoto);
        Iterator<String> it = this.mCropPhotoCacheList.iterator();
        while (it.hasNext()) {
            FileUtils.delete(it.next());
        }
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 4, "submit clear temp files task");
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.play.AETemplateInfoFragment.2
            @Override // java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                com.tencent.mobileqq.utils.FileUtils.deleteDirectory(AETemplateInfoFragment.CACHE_DIR);
                if (QLog.isDebugVersion()) {
                    QLog.d(AETemplateInfoFragment.TAG, 4, "clear temp files finish, cost=", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }, 64, null, false);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        QLog.i(TAG, 1, "[player lifecycle]---onPause");
        super.onPause();
        this.mNeedPlayVideo = false;
        pauseVideo();
    }

    public void onPlayComplete() {
        QLog.i(TAG, 1, "[player lifecycle]---onPlayComplete");
        IVideoShelfPlayer iVideoShelfPlayer = this.mVideoPlayer;
        if (iVideoShelfPlayer != null) {
            iVideoShelfPlayer.seekTo(0);
        }
        videoViewStatusPause();
        this.mNeedPlayVideo = false;
        if (isDebugVersion()) {
            this.mPlayerRateView.setText("0(fps)");
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        QLog.i(TAG, 1, "[player lifecycle]---onResume");
        super.onResume();
        resumeVideoToStart();
    }

    public static void sendPickedPhotosToMe(Context context, Intent intent) {
        intent.addFlags(67108864);
        intent.addFlags(536870912);
        intent.putExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, getFromType(context));
        PublicFragmentActivity.b.a(context, intent, PublicFragmentActivityForPeak.class, AETemplateInfoFragment.class);
    }

    private void popNotSupportPagToast(String str) {
    }
}
