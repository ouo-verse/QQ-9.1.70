package com.tencent.mobileqq.wink.preview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import b93.OutputData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.biz.richframework.compat.RFWThemeUtil;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.QQWinkActivity;
import com.tencent.mobileqq.wink.WinkConfig;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.dailysign.DailySignConfig;
import com.tencent.mobileqq.wink.dailysign.af;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.editor.export.WinkExportUtils;
import com.tencent.mobileqq.wink.editor.model.WinkTavCutScene;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mobileqq.wink.editor.util.m;
import com.tencent.mobileqq.wink.editor.view.video.WinkPlayerContainerView;
import com.tencent.mobileqq.wink.picker.MediaPickerScene;
import com.tencent.mobileqq.wink.preview.WinkPreviewFragment;
import com.tencent.mobileqq.wink.pubcover.WinkCoverSelectFragment;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tavcut.core.render.player.IPlayer;
import com.tencent.tavcut.core.session.ICutStatusCallback;
import com.tencent.videocut.utils.o;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.peak.PeakConstants;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.light.lightAssetKit.Entity;
import u53.i;

/* loaded from: classes21.dex */
public class WinkPreviewFragment extends ImmersivePartFragment implements View.OnClickListener {
    public static final String ACTION_TYPE_PREVIEW = "1000";
    public static final String ENTRY_FROM = "ENTRY_FROM";
    public static final int ENTRY_FROM_ALBUM = 2;
    public static final int ENTRY_FROM_MOOD = 1;
    public static final String KEY_ATTRS = "key_attrs";
    public static final String MEDIA_PATH = "mediapath";
    public static final int PREVIEW_MEDIA_TYPE_IMAGE = 1;
    public static final int PREVIEW_MEDIA_TYPE_VIDEO = 2;
    public static final int PREVIEW_VIDEO_SEEKBAR_DURATION = 1000;
    public static final String SUBACTION_PREVIEW_DELETE_BUTTON_CLK = "3";
    public static final String SUBACTION_PREVIEW_EDIT_BUTTON_CLK = "2";
    public static final String SUBACTION_PREVIEW_EXPOSURE = "1";
    public static final String TAG = "WinkPreviewFragment";
    public static final int TRANSFORM_VALUE_MIN_TO_S = 60;
    public static final int TRANSFORM_VALUE_S_TO_US = 1000000;
    private String businessName;
    private ImageView mDeleteButton;
    private TextView mEditButton;
    private IPlayer.PlayerListener mPlayerListener;
    private ImageView mReturnButton;
    private SeekBar mSeekBar;
    private FrameLayout mSeekFrameLayout;
    private TextView mSelectCoverButton;
    private WinkPlayerContainerView mVideoContainerView;
    private TextView mVideoCurrentProgress;
    private TextView mVideoDurationProgress;
    private ImageView mVideoPauseButton;
    private RelativeLayout mVideoProgressLayout;
    private WinkVideoTavCut mVideoTavCut;
    private WinkEditDataWrapper mWinkEditDataWrapper;
    protected ArrayList<LocalMediaInfo> mediaInfos;
    private String missionId;
    private String pageFrom = "1";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            WinkPreviewFragment.this.mSeekBar.onTouchEvent(motionEvent);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class b implements SeekBar.OnSeekBarChangeListener {
        b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
            if (z16 && WinkPreviewFragment.this.mVideoTavCut != null) {
                long limitDuration = (long) (WinkPreviewFragment.this.getLimitDuration() * (i3 / 1000.0d));
                WinkPreviewFragment.this.mVideoTavCut.seek(limitDuration);
                WinkPreviewFragment.this.mSeekBar.setProgress(i3);
                WinkPreviewFragment.this.mVideoCurrentProgress.setText(com.tencent.mobileqq.wink.editor.music.a.d(limitDuration));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            if (WinkPreviewFragment.this.mVideoTavCut != null) {
                seekBar.getLayoutParams().height = ViewUtils.dpToPx(4.0f);
                seekBar.requestLayout();
                WinkPreviewFragment.this.mVideoTavCut.pause();
                WinkPreviewFragment.this.mVideoProgressLayout.setVisibility(0);
                WinkPreviewFragment.this.mVideoPauseButton.setVisibility(8);
                WinkPreviewFragment.this.mVideoDurationProgress.setText(com.tencent.mobileqq.wink.editor.music.a.d(WinkPreviewFragment.this.getLimitDuration()));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
            if (WinkPreviewFragment.this.mVideoTavCut != null) {
                seekBar.getLayoutParams().height = ViewUtils.dpToPx(2.0f);
                seekBar.requestLayout();
                WinkPreviewFragment.this.mVideoTavCut.play();
                WinkPreviewFragment.this.mVideoPauseButton.setVisibility(8);
                WinkPreviewFragment.this.mVideoProgressLayout.setVisibility(8);
            }
            EventCollector.getInstance().onStopTrackingTouch(seekBar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class c extends s73.b<WinkVideoTavCut> {
        c() {
        }

        @Override // s73.b, s73.a
        @NonNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public HashMap<String, Object> a(@NonNull WinkVideoTavCut winkVideoTavCut) {
            MetaMaterial metaMaterial;
            boolean e16;
            HashMap<String, Object> hashMap = new HashMap<>();
            if (WinkPreviewFragment.this.getActivity() != null && WinkPreviewFragment.this.getActivity().getIntent() != null) {
                metaMaterial = (MetaMaterial) WinkPreviewFragment.this.getActivity().getIntent().getSerializableExtra(QQWinkConstants.PICK_TEMPLATE_MEDIA_MODEL);
            } else {
                metaMaterial = null;
            }
            if (metaMaterial == null) {
                MetaMaterial k3 = com.tencent.mobileqq.wink.editor.draft.c.k(WinkPreviewFragment.this.mWinkEditDataWrapper);
                if (k3 != null) {
                    e16 = com.tencent.mobileqq.wink.editor.c.e1(k3);
                    if (e16) {
                        metaMaterial = k3;
                    }
                } else {
                    e16 = false;
                }
            } else {
                e16 = com.tencent.mobileqq.wink.editor.c.e1(metaMaterial);
            }
            s73.c.i(hashMap, metaMaterial);
            if (e16) {
                s73.c.f(hashMap, MediaPickerScene.TEMPLATE_ZSHOW);
            }
            hashMap.put("need_recovery_template_from_draft", Boolean.TRUE);
            return hashMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public static /* synthetic */ class f {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f325375a;

        static {
            int[] iArr = new int[MusicVolumeControlViewModel.VolumeType.values().length];
            f325375a = iArr;
            try {
                iArr[MusicVolumeControlViewModel.VolumeType.ORIGIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f325375a[MusicVolumeControlViewModel.VolumeType.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f325375a[MusicVolumeControlViewModel.VolumeType.BGM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f325375a[MusicVolumeControlViewModel.VolumeType.TEMPLATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private String genProgressText(long j3) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        long j16 = j3 / 1000000;
        long j17 = j16 % 60;
        long j18 = j16 / 60;
        String str2 = "0";
        if (j18 < 10) {
            str = "0";
        } else {
            str = "";
        }
        sb5.append(str);
        sb5.append(j18);
        sb5.append(":");
        if (j17 >= 10) {
            str2 = "";
        }
        sb5.append(str2);
        sb5.append(j17);
        return sb5.toString();
    }

    private HashMap<String, String> getAssetDataFromEditData() {
        ArrayList<WinkEditData> editDatas;
        WinkEditDataWrapper winkEditDataWrapper = this.mWinkEditDataWrapper;
        if (winkEditDataWrapper != null && (editDatas = winkEditDataWrapper.getEditDatas()) != null && editDatas.size() == 1) {
            WinkEditData winkEditData = editDatas.get(0);
            if (winkEditData.getAssetData() != null) {
                return winkEditData.getAssetData();
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getLimitDuration() {
        WinkVideoTavCut winkVideoTavCut = this.mVideoTavCut;
        if (winkVideoTavCut == null) {
            return 0L;
        }
        return Math.min(this.mVideoTavCut.getDurationUs(), winkVideoTavCut.h());
    }

    private String getMediaPath() {
        String str;
        ArrayList<LocalMediaInfo> arrayList;
        HashMap hashMap;
        if (getActivity() != null && getActivity().getIntent() != null && getActivity().getIntent().getExtras() != null && (hashMap = (HashMap) getActivity().getIntent().getExtras().get("key_attrs")) != null && !hashMap.isEmpty()) {
            str = (String) hashMap.get("mediapath");
        } else {
            str = "";
        }
        if ((str == null || str.isEmpty()) && (arrayList = this.mediaInfos) != null && arrayList.size() > 0) {
            return this.mediaInfos.get(0).path;
        }
        return str;
    }

    private IPlayer.PlayerListener getPlayerListener() {
        if (this.mPlayerListener == null) {
            this.mPlayerListener = new e();
        }
        return this.mPlayerListener;
    }

    private void initParamsFromIntent() {
        ms.a.a(TAG, "initParamsFromIntent, getMissionId");
        Bundle arguments = getArguments();
        if (getActivity().getIntent().getExtras() != null) {
            this.missionId = getActivity().getIntent().getStringExtra(QQWinkConstants.MISSION_ID);
            this.mediaInfos = getActivity().getIntent().getParcelableArrayListExtra(QQWinkConstants.INPUT_MEDIA);
            this.businessName = getActivity().getIntent().getStringExtra(QQWinkConstants.ENTRY_BUSINESS_NAME);
            this.pageFrom = getActivity().getIntent().getIntExtra(ENTRY_FROM, 1) + "";
        }
        if (TextUtils.isEmpty(this.missionId) && arguments != null && arguments.containsKey(QQWinkConstants.MISSION_ID)) {
            this.missionId = arguments.getString(QQWinkConstants.MISSION_ID);
            this.businessName = getActivity().getIntent().getStringExtra(QQWinkConstants.ENTRY_BUSINESS_NAME);
            this.pageFrom = getActivity().getIntent().getIntExtra(ENTRY_FROM, 1) + "";
        }
        ms.a.a(TAG, "missionId = " + this.missionId);
    }

    private void initSeekBar() {
        FrameLayout frameLayout = this.mSeekFrameLayout;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
            this.mSeekFrameLayout.setOnTouchListener(new a());
        }
        this.mVideoProgressLayout.setVisibility(8);
        this.mSeekBar.setMax(1000);
        this.mSeekBar.setOnSeekBarChangeListener(new b());
    }

    private void initUI() {
        if ("QZONE".equals(this.businessName)) {
            this.mEditButton.setVisibility(0);
            this.mEditButton.setOnClickListener(this);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mDeleteButton.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.topMargin -= m.m(getContext());
                this.mDeleteButton.setLayoutParams(layoutParams);
            }
            this.mDeleteButton.setVisibility(0);
            this.mDeleteButton.setOnClickListener(this);
            reportForQzone("1");
        }
        ArrayList<LocalMediaInfo> arrayList = this.mediaInfos;
        if (arrayList == null || arrayList.size() == 0 || isAIGC()) {
            this.mSelectCoverButton.setVisibility(8);
        }
        this.mSelectCoverButton.setOnClickListener(this);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mReturnButton.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.topMargin -= m.m(getContext());
            this.mReturnButton.setLayoutParams(layoutParams2);
        }
    }

    private void initVideoPlayer() {
        WinkPlayerContainerView winkPlayerContainerView = this.mVideoContainerView;
        if (winkPlayerContainerView != null) {
            winkPlayerContainerView.setOnClickListener(this);
        }
        this.mReturnButton.setOnClickListener(this);
    }

    private void initVideoTavCut() {
        boolean booleanValue;
        if (this.mWinkEditDataWrapper != null && getContext() != null) {
            WinkEditorViewModel.EditMode editMode = WinkEditorViewModel.EditMode.Video;
            ArrayList<WinkEditData> editDatas = this.mWinkEditDataWrapper.getEditDatas();
            String templateFilePath = this.mWinkEditDataWrapper.getTemplateFilePath();
            Boolean valueOf = Boolean.valueOf(isFromTemplateColl());
            int g16 = o.g();
            int f16 = m.f(getContext());
            HashMap<String, String> assetDataFromEditData = getAssetDataFromEditData();
            Boolean bool = i.f438428a;
            if (bool == null) {
                booleanValue = false;
            } else {
                booleanValue = bool.booleanValue();
            }
            WinkVideoTavCut d16 = this.mVideoContainerView.d(new dr.WinkTavCutParams(false, editMode, editDatas, templateFilePath, valueOf, g16, f16, null, assetDataFromEditData, booleanValue, i.f438429b.intValue(), WinkConfig.f317649a.b(), true, this.mWinkEditDataWrapper.isFromQzoneText(), this.mWinkEditDataWrapper.getTextQzoneText(), WinkTavCutScene.Preview, true, true, 0, 0, true, null), new c(), null, false);
            this.mVideoTavCut = d16;
            if (d16.getCurrentPlayer() != null) {
                this.mVideoTavCut.getCurrentPlayer().removePlayerListener(getPlayerListener());
                this.mVideoTavCut.getCurrentPlayer().addPlayerListener(getPlayerListener());
                this.mVideoTavCut.getCurrentPlayer().setLoopPlay(true);
            }
            this.mVideoTavCut.m0(new d());
        }
    }

    private boolean isFromDailySign() {
        if (getActivity() == null || getActivity().getIntent() == null || getActivity().getIntent().getIntExtra(QQWinkConstants.PUBLISH_ENTRANCE, -1) != 7) {
            return false;
        }
        return true;
    }

    private boolean isFromTemplateColl() {
        boolean z16;
        WinkEditDataWrapper winkEditDataWrapper = this.mWinkEditDataWrapper;
        if (winkEditDataWrapper == null) {
            return false;
        }
        if (winkEditDataWrapper.getFrom() != null && this.mWinkEditDataWrapper.getFrom().intValue() == 7) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && !this.mWinkEditDataWrapper.isFromTemplateColl()) {
            return false;
        }
        return true;
    }

    private boolean isZShowTemplate() {
        MetaMaterial metaMaterial;
        String str;
        if (getActivity() == null || getActivity().getIntent() == null || (metaMaterial = (MetaMaterial) getActivity().getIntent().getSerializableExtra(QQWinkConstants.PICK_TEMPLATE_MEDIA_MODEL)) == null || (str = metaMaterial.additionalFields.get(QQWinkConstants.ZSHOW_MATERIAL_SCENE_KEY)) == null) {
            return false;
        }
        return str.equals(QQWinkConstants.BUSINESS_ZSHOW_NAME);
    }

    private void onClickDeleteMedia() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        ArrayList<String> stringArrayList = arguments.getStringArrayList(QQWinkConstants.EDITOR_MEDIA_PATH_ARRAY_LIST);
        if (stringArrayList != null && !stringArrayList.isEmpty()) {
            String str = stringArrayList.get(0);
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            OutputData b16 = OutputData.INSTANCE.b(32L, ba3.a.b(arrayList), null, arguments);
            FragmentActivity activity = getActivity();
            WinkContext.INSTANCE.d().m().k(activity, b16);
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        w53.b.c(TAG, "onClickDeleteMedia EDITOR_MEDIA_PATH_ARRAY_LIST is empty");
    }

    private void onSelectCover() {
        ArrayList<LocalMediaInfo> arrayList = this.mediaInfos;
        boolean z16 = false;
        if (arrayList != null && arrayList.size() != 0) {
            Intent intent = new Intent();
            LocalMediaInfo localMediaInfo = this.mediaInfos.get(0);
            intent.putExtra(AEEditorConstants.KEY_VIDEO_MEDIA_PATH, localMediaInfo.path);
            intent.putExtra(QQWinkConstants.MISSION_ID, this.missionId);
            intent.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, WinkContext.INSTANCE.d().getTraceId());
            intent.putExtra(AEEditorConstants.KEY_VIDEO_COVER_POSITION, localMediaInfo.thumbnailProgress);
            intent.putExtra(AEEditorConstants.KEY_VIDEO_COVER_PATH, localMediaInfo.thumbnailPath);
            intent.putExtra(AEEditorConstants.KEY_IS_VIDEO_PROGRESS_COVER, localMediaInfo.isProgressThumbnail);
            ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
            arrayList2.add(localMediaInfo);
            intent.putParcelableArrayListExtra(QQWinkConstants.INPUT_MEDIA, arrayList2);
            startWithPublicFragmentActivityForPeakForResult(getActivity(), intent, 8);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onSelectCover: mediaInfos == null");
        if (this.mediaInfos == null) {
            z16 = true;
        }
        sb5.append(z16);
        w53.b.c(TAG, sb5.toString());
    }

    private void registerDaTongReportPageId(View view) {
        if (view == null) {
            QLog.i(TAG, 1, "reportDaTongRegister mContentView == null , subPage: " + getTAG());
            return;
        }
        VideoReport.addToDetectionWhitelist(getActivity());
        String pageId = getPageId();
        VideoReport.setPageId(view, pageId);
        VideoReport.setPageParams(view, new WinkDTParamBuilder().buildPageParams(null, WinkContext.INSTANCE.d().getDtParams().c()));
        QLog.i(TAG, 1, "reportDaTongRegister subPage: " + getTAG() + ", pageId: " + pageId);
    }

    private void registerElement() {
        VideoReport.setElementId(this.mSelectCoverButton, WinkDaTongReportConstant.ElementId.EM_XSJ_CHOOSE_COVER_BUTTON);
    }

    private void reportForQzone(String str) {
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064("1000", str);
        lpReportInfo_pf00064.reserves = 2;
        lpReportInfo_pf00064.reserves2 = this.pageFrom;
        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false, false);
    }

    private void startWithPublicFragmentActivityForPeakForResult(Context context, Intent intent, int i3) {
        intent.setClass(context, QQWinkActivity.class);
        intent.putExtra(QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE");
        intent.putExtra("public_fragment_class", WinkCoverSelectFragment.class.getName());
        ((Activity) context).startActivityForResult(intent, i3);
    }

    private void updateStickers() {
        WinkEditDataWrapper winkEditDataWrapper;
        ArrayList<WinkEditData> editDatas;
        if (this.mVideoTavCut == null || (winkEditDataWrapper = this.mWinkEditDataWrapper) == null || (editDatas = winkEditDataWrapper.getEditDatas()) == null) {
            return;
        }
        Iterator<WinkEditData> it = editDatas.iterator();
        while (it.hasNext()) {
            WinkEditData next = it.next();
            if (next != null && next.getStickerModelMap() != null) {
                this.mVideoTavCut.B(next.getStickerModelMap());
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        return null;
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment
    public /* bridge */ /* synthetic */ boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        return com.tencent.biz.richframework.compat.f.b(this, i3, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.i76;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return TAG;
    }

    public String getPageId() {
        return WinkDaTongReportConstant.PageId.PG_XSJ_PUBLISH_PREVIEW_PAGE;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return -16777216;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    public void initMediaData(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mWinkEditDataWrapper = com.tencent.mobileqq.wink.editor.draft.a.f(str);
        }
        if (this.mWinkEditDataWrapper == null) {
            String mediaPath = getMediaPath();
            if (!TextUtils.isEmpty(mediaPath)) {
                try {
                    LocalMediaInfo d16 = WinkExportUtils.d(mediaPath);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(d16);
                    this.mWinkEditDataWrapper = com.tencent.mobileqq.wink.editor.draft.c.d(arrayList, 0, 0);
                } catch (Exception e16) {
                    QLog.d(TAG, 1, e16, new Object[0]);
                }
            }
        }
    }

    public /* bridge */ /* synthetic */ void initWindowStyleAndAnimation(Activity activity) {
        com.tencent.biz.richframework.compat.f.c(this, activity);
    }

    public boolean isAIGC() {
        if (getActivity() != null && getActivity().getIntent() != null) {
            return QQWinkConstants.WinkTaskRoute.AIGC.equals(getActivity().getIntent().getStringExtra(QQWinkConstants.WinkTaskRoute.WINK_TASK_ROUTE));
        }
        return false;
    }

    public /* bridge */ /* synthetic */ boolean isSupportScreenShot() {
        return com.tencent.biz.richframework.compat.f.d(this);
    }

    public /* bridge */ /* synthetic */ boolean isWrapContent() {
        return com.tencent.biz.richframework.compat.f.e(this);
    }

    public /* bridge */ /* synthetic */ boolean needImmersive() {
        return com.tencent.biz.richframework.compat.f.f(this);
    }

    public /* bridge */ /* synthetic */ boolean needStatusTrans() {
        return com.tencent.biz.richframework.compat.f.g(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        QLog.d(TAG, 1, "onActivityResult... requestCode:", Integer.valueOf(i3), " resultCode:", Integer.valueOf(i16));
        if (i3 == 8 && i16 == -1) {
            getActivity().setResult(-1, intent);
            getActivity().finish();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        WinkExportUtils.R();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.mVideoTavCut != null && view.getId() == R.id.kou) {
            if (this.mVideoTavCut.isPlaying()) {
                this.mVideoTavCut.pause();
                this.mVideoPauseButton.setVisibility(0);
            } else {
                this.mVideoTavCut.play();
                this.mVideoPauseButton.setVisibility(8);
            }
        } else if (view.getId() == R.id.f644736b && getActivity() != null) {
            getActivity().finish();
        } else if (view.getId() == R.id.f926358e && getActivity() != null) {
            reportForQzone("2");
            WinkEditDataWrapper winkEditDataWrapper = this.mWinkEditDataWrapper;
            if (winkEditDataWrapper != null && winkEditDataWrapper.getFrom().intValue() == 7) {
                DailySignConfig dailySignConfig = new DailySignConfig(new af(null, null, this.missionId));
                Bundle bundle = new Bundle();
                Bundle extras = getActivity().getIntent().getExtras();
                if (extras != null) {
                    bundle.putAll(extras);
                }
                dailySignConfig.setFrom("QZONE");
                bundle.putSerializable(QQWinkConstants.EDITOR_TEXT_TEMPLATE_CONFIG, dailySignConfig);
                com.tencent.mobileqq.wink.f.m(requireContext(), bundle);
            } else {
                com.tencent.mobileqq.wink.f.v(getActivity(), getArguments());
            }
            getActivity().finish();
        } else if (view.getId() == R.id.f926258d && getActivity() != null) {
            reportForQzone("3");
            onClickDeleteMedia();
        } else if (view.getId() == R.id.f81934fi && getActivity() != null) {
            WinkEditDataWrapper winkEditDataWrapper2 = this.mWinkEditDataWrapper;
            if ((winkEditDataWrapper2 != null && (winkEditDataWrapper2.isFromQzoneText() || isZShowTemplate())) || isFromDailySign()) {
                if (WinkExportUtils.x(this.missionId) != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (Boolean.valueOf(z16).booleanValue()) {
                    onSelectCover();
                } else {
                    QQToast.makeText(getActivity(), getActivity().getString(R.string.f241397rr), 0).show();
                }
            } else {
                onSelectCover();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ImmersiveUtils.setStatusTextColor(true, getActivity().getWindow());
        initParamsFromIntent();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        WinkVideoTavCut winkVideoTavCut = this.mVideoTavCut;
        if (winkVideoTavCut != null && this.mWinkEditDataWrapper != null) {
            winkVideoTavCut.release();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        WinkVideoTavCut winkVideoTavCut = this.mVideoTavCut;
        if (winkVideoTavCut != null && winkVideoTavCut.getCurrentPlayer() != null && this.mWinkEditDataWrapper != null) {
            this.mVideoTavCut.getCurrentPlayer().pause();
        }
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public /* bridge */ /* synthetic */ void onPostThemeChanged() {
        com.tencent.biz.richframework.compat.f.k(this);
    }

    public /* bridge */ /* synthetic */ void onPreThemeChanged() {
        com.tencent.biz.richframework.compat.f.l(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        WinkVideoTavCut winkVideoTavCut = this.mVideoTavCut;
        if (winkVideoTavCut != null) {
            winkVideoTavCut.Z();
        }
    }

    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mVideoContainerView = (WinkPlayerContainerView) view.findViewById(R.id.kou);
        this.mSeekFrameLayout = (FrameLayout) view.findViewById(R.id.v9e);
        this.mSeekBar = (SeekBar) view.findViewById(R.id.vad);
        this.mVideoCurrentProgress = (TextView) view.findViewById(R.id.v9f);
        this.mVideoDurationProgress = (TextView) view.findViewById(R.id.v9h);
        this.mVideoProgressLayout = (RelativeLayout) view.findViewById(R.id.f123937i0);
        this.mVideoPauseButton = (ImageView) view.findViewById(R.id.f644836c);
        this.mReturnButton = (ImageView) view.findViewById(R.id.f644736b);
        this.mEditButton = (TextView) view.findViewById(R.id.f926358e);
        this.mDeleteButton = (ImageView) view.findViewById(R.id.f926258d);
        this.mSelectCoverButton = (TextView) view.findViewById(R.id.f81934fi);
        registerElement();
        initMediaData(this.missionId);
        initSeekBar();
        initVideoPlayer();
        initVideoTavCut();
        initUI();
        updateStickers();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View view, Bundle bundle) {
        super.onViewCreatedBeforePartInit(view, bundle);
        registerDaTongReportPageId(view);
        if (needAdjustImmersive()) {
            RFWThemeUtil.setNavigationBarColor(getActivity(), ContextCompat.getColor(requireActivity(), R.color.bd5));
        }
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment
    public /* bridge */ /* synthetic */ boolean overrideFinish() {
        return com.tencent.biz.richframework.compat.f.o(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class d implements ICutStatusCallback {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            if (WinkPreviewFragment.this.mWinkEditDataWrapper != null) {
                int i3 = f.f325375a[WinkPreviewFragment.this.mWinkEditDataWrapper.getBgmVolumeType().ordinal()];
                if (i3 != 2 && i3 != 3) {
                    if (i3 == 4 && WinkPreviewFragment.this.mVideoTavCut != null) {
                        WinkPreviewFragment.this.mVideoTavCut.G3(WinkPreviewFragment.this.mWinkEditDataWrapper.getBgmVolume(), null);
                    }
                } else if (WinkPreviewFragment.this.mVideoTavCut != null) {
                    WinkPreviewFragment.this.mVideoTavCut.W2(false);
                }
                if (WinkPreviewFragment.this.mVideoTavCut != null) {
                    WinkPreviewFragment.this.mVideoTavCut.o(WinkPreviewFragment.this.mWinkEditDataWrapper.getOriginVolume());
                }
                if (WinkPreviewFragment.this.mVideoTavCut != null && WinkPreviewFragment.this.mVideoTavCut.getCurrentPlayer() != null && !WinkPreviewFragment.this.isResumed()) {
                    WinkPreviewFragment.this.mVideoTavCut.getCurrentPlayer().pause();
                }
            }
        }

        @Override // com.tencent.tavcut.core.session.ICutStatusCallback
        public void onLightEntityReload(@Nullable Entity entity) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.preview.a
                @Override // java.lang.Runnable
                public final void run() {
                    WinkPreviewFragment.d.this.b();
                }
            });
        }

        @Override // com.tencent.tavcut.core.session.ICutStatusCallback
        public void onRenderChainReady() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class e implements IPlayer.PlayerListener {
        e() {
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPlayerSourceReady(@NotNull IPlayer iPlayer) {
            if (WinkPreviewFragment.this.mVideoTavCut != null && WinkPreviewFragment.this.mVideoTavCut.getCurrentPlayer() != null && WinkPreviewFragment.this.mWinkEditDataWrapper != null && !WinkPreviewFragment.this.isResumed()) {
                WinkPreviewFragment.this.mVideoTavCut.getCurrentPlayer().pause();
            }
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPositionChanged(long j3, long j16) {
            if (WinkPreviewFragment.this.mSeekBar != null && ((float) j16) > 0.0f) {
                long min = Math.min(j16, WinkPreviewFragment.this.getLimitDuration());
                if (min > 0) {
                    WinkPreviewFragment.this.mSeekBar.setProgress((int) ((j3 / min) * 1000.0d));
                }
            }
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onStatusChanged(@org.jetbrains.annotations.Nullable IPlayer.PlayerStatus playerStatus, @NotNull IPlayer iPlayer) {
        }
    }
}
