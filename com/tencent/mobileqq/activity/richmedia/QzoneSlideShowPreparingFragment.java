package com.tencent.mobileqq.activity.richmedia;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.aelight.camera.qqstory.api.IMediaCodecSendTask;
import com.tencent.aelight.camera.qqstory.api.IPtvFilterUtil;
import com.tencent.aelight.camera.struct.editor.PublishParam;
import com.tencent.aelight.camera.struct.editor.VideoSendPublicParamBase;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.en;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.richmedia.QzoneSlideShowPreparingFragment;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qzonehub.api.utils.IQzoneVideoHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.io.File;
import java.util.ArrayList;
import mqq.util.WeakReference;

/* loaded from: classes10.dex */
public class QzoneSlideShowPreparingFragment extends PublicBaseFragment implements en {
    private static final String K = com.tencent.biz.qqstory.takevideo.slideshow.b.class.getName();
    private TextView C;
    private TextView D;
    private ProgressBar E;
    private ImageView F;
    private int G;
    private QQCustomDialog H;
    private Handler I = new a(Looper.getMainLooper());
    private Runnable J = new Runnable() { // from class: com.tencent.mobileqq.activity.richmedia.QzoneSlideShowPreparingFragment.2
        @Override // java.lang.Runnable
        public void run() {
            if (QzoneSlideShowPreparingFragment.this.E != null && QzoneSlideShowPreparingFragment.this.C != null && QzoneSlideShowPreparingFragment.this.I != null) {
                int progress = QzoneSlideShowPreparingFragment.this.E.getProgress();
                if (progress < 95) {
                    int i3 = progress + 1;
                    QzoneSlideShowPreparingFragment.this.E.setProgress(i3);
                    QzoneSlideShowPreparingFragment.this.C.setText(i3 + "%");
                    QzoneSlideShowPreparingFragment.this.I.sendEmptyMessage(10);
                    return;
                }
                QzoneSlideShowPreparingFragment.this.I.removeCallbacks(this);
            }
        }
    };

    /* loaded from: classes10.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 10) {
                postDelayed(QzoneSlideShowPreparingFragment.this.J, 200L);
            }
        }
    }

    /* loaded from: classes10.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QzoneSlideShowPreparingFragment.this.yh();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QzoneSlideShowPreparingFragment.this.H.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            LpReportInfo_pf00064.allReport(680, 1, 2);
            QzoneSlideShowPreparingFragment.this.H.dismiss();
            QzoneSlideShowPreparingFragment.this.finish();
        }
    }

    /* loaded from: classes10.dex */
    private static class e implements SlideShowPhotoListManager.b {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QzoneSlideShowPreparingFragment> f185820a;

        public e(QzoneSlideShowPreparingFragment qzoneSlideShowPreparingFragment) {
            this.f185820a = new WeakReference<>(qzoneSlideShowPreparingFragment);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void c(QzoneSlideShowPreparingFragment qzoneSlideShowPreparingFragment) {
            qzoneSlideShowPreparingFragment.E.setProgress(99);
            qzoneSlideShowPreparingFragment.C.setText("99%");
        }

        @Override // com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager.b
        public void a() {
            QLog.d(QzoneSlideShowPreparingFragment.K, 2, "createSlideShowNew AlbumListener - endMerge.");
            final QzoneSlideShowPreparingFragment qzoneSlideShowPreparingFragment = this.f185820a.get();
            if (qzoneSlideShowPreparingFragment == null) {
                QLog.e(QzoneSlideShowPreparingFragment.K, 1, "fragment == null,direct return!");
                return;
            }
            try {
                qzoneSlideShowPreparingFragment.I.removeCallbacks(qzoneSlideShowPreparingFragment.J);
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.richmedia.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        QzoneSlideShowPreparingFragment.e.c(QzoneSlideShowPreparingFragment.this);
                    }
                });
                if (qzoneSlideShowPreparingFragment.G == 18) {
                    LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_TYPE_MOOD_LIST, 15, 8);
                }
            } catch (Throwable th5) {
                QLog.e(QzoneSlideShowPreparingFragment.K, 1, "createSlideShowNew endMerge exception:", Log.getStackTraceString(th5));
            }
        }
    }

    private void Ah(String str, int i3, String str2, String str3, String str4, int i16, qs.c cVar, String str5, int i17, ArrayList<String> arrayList, boolean z16, int i18, int i19, String str6, int i26, String str7, boolean z17, boolean z18, boolean z19) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        String parent = new File(str2).getParent();
        if (!TextUtils.isEmpty(str4)) {
            ((IPtvFilterUtil) QRoute.api(IPtvFilterUtil.class)).createFakeVidConfigFile(parent, str4);
        }
        VideoSendPublicParamBase videoSendPublicParamBase = new VideoSendPublicParamBase();
        videoSendPublicParamBase.mContext = getBaseActivity();
        videoSendPublicParamBase.mVideoCacheDir = parent;
        videoSendPublicParamBase.mEncodeMode = i3;
        videoSendPublicParamBase.mVideoFilePath = str2;
        videoSendPublicParamBase.mThumbFilePath = str3;
        videoSendPublicParamBase.mThumbWidth = 0;
        videoSendPublicParamBase.mThumbHeight = 0;
        videoSendPublicParamBase.fakeVid = str4;
        videoSendPublicParamBase.recordTime = i16;
        videoSendPublicParamBase.mUserCallBack = cVar;
        videoSendPublicParamBase.mContent = str5;
        videoSendPublicParamBase.mPriv = i17;
        videoSendPublicParamBase.mPrivUinList = arrayList;
        videoSendPublicParamBase.mEnableEditVideo = true;
        videoSendPublicParamBase.topicSyncQzone = z16;
        videoSendPublicParamBase.fontId = i18;
        videoSendPublicParamBase.fontFormatType = i19;
        videoSendPublicParamBase.fontUrl = str6;
        videoSendPublicParamBase.superFontId = i26;
        videoSendPublicParamBase.superFontInfo = str7;
        videoSendPublicParamBase.generateGif = z17;
        videoSendPublicParamBase.timerDelete = z18;
        videoSendPublicParamBase.isUploadOrigin = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_P2V_NEED_ORIGINAL, true);
        videoSendPublicParamBase.entrySource = SlideShowPhotoListManager.n().l();
        videoSendPublicParamBase.mUin = "";
        videoSendPublicParamBase.mUinType = 0;
        videoSendPublicParamBase.mTroopUin = "";
        ((IMediaCodecSendTask) QRoute.api(IMediaCodecSendTask.class)).execute(videoSendPublicParamBase);
    }

    private void xh(int i3, Intent intent) {
        int i16;
        if (i3 == -1) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra("key_content");
                if (stringExtra == null) {
                    stringExtra = "";
                }
                String str = stringExtra;
                int intExtra = intent.getIntExtra("key_priv", 1);
                ArrayList<String> arrayList = (ArrayList) intent.getSerializableExtra(AEEditorConstants.KEY_PRIV_UIN_LIST);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                ArrayList<String> arrayList2 = arrayList;
                int intExtra2 = intent.getIntExtra(AEEditorConstants.KEY_FONT_ID, -1);
                int intExtra3 = intent.getIntExtra(AEEditorConstants.KEY_FONT_FORMAT_TYPE, 0);
                String stringExtra2 = intent.getStringExtra(AEEditorConstants.KEY_FONT_URL);
                int intExtra4 = intent.getIntExtra(AEEditorConstants.KEY_SUPER_FONT_ID, -1);
                String stringExtra3 = intent.getStringExtra(AEEditorConstants.KEY_SUPER_FONT_INFO);
                boolean booleanExtra = intent.getBooleanExtra(AEEditorConstants.KEY_GENERATE_GIF, false);
                boolean booleanExtra2 = intent.getBooleanExtra(AEEditorConstants.KEY_TIMER_DELETE, false);
                boolean booleanExtra3 = intent.getBooleanExtra(AEEditorConstants.KEY_SYNC_TO_QQSTORY, false);
                PublishParam publishParam = (PublishParam) intent.getParcelableExtra(PublishParam.Z);
                int i17 = publishParam.I;
                if (i17 <= 5) {
                    i16 = i17;
                } else {
                    i16 = 0;
                }
                int i18 = (int) publishParam.E;
                qs.c cVar = (qs.c) ((IQzoneVideoHelper) QRoute.api(IQzoneVideoHelper.class)).getVideoComponentCallback();
                cVar.setRefer(getClass().getName());
                Ah(publishParam.Q, i16, publishParam.P, publishParam.f69067e, publishParam.f69066d, i18, cVar, str, intExtra, arrayList2, false, intExtra2, intExtra3, stringExtra2, intExtra4, stringExtra3, booleanExtra, booleanExtra2, booleanExtra3);
                if (this.G == 18) {
                    LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_TYPE_MOOD_LIST, 15, 9);
                }
                finish();
                return;
            }
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yh() {
        if (this.H == null) {
            this.H = DialogUtil.createCustomDialog(getBaseActivity(), 230, HardCodeUtil.qqStr(R.string.s9a), (CharSequence) null, HardCodeUtil.qqStr(R.string.s9b), HardCodeUtil.qqStr(R.string.j6l), new c(), new d());
        }
        this.H.show();
    }

    private void zh() {
        BitmapDrawable bitmapDrawable;
        Bitmap bitmap;
        ImageView imageView = this.F;
        if (imageView != null && (bitmapDrawable = (BitmapDrawable) imageView.getDrawable()) != null && (bitmap = bitmapDrawable.getBitmap()) != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
    }

    public void finish() {
        this.I.removeCallbacks(this.J);
        SlideShowPhotoListManager.n().H();
        getBaseActivity().finish();
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        xh(i16, intent);
    }

    @Override // com.tencent.mobileqq.activity.en
    public void onBackPressed() {
        yh();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        QLog.d(K, 2, "QzoneSlideShowPreparingFragment onCreate");
        super.onCreate(bundle);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str = K;
        QLog.d(str, 2, "QzoneSlideShowPreparingFragment onCreateView");
        View inflate = layoutInflater.inflate(R.layout.f167924mu, viewGroup, false);
        this.C = (TextView) inflate.findViewById(R.id.k8d);
        this.D = (TextView) inflate.findViewById(R.id.f167034k61);
        this.E = (ProgressBar) inflate.findViewById(R.id.fk7);
        this.F = (ImageView) inflate.findViewById(R.id.dwz);
        this.E.setProgress(0);
        this.E.setMax(100);
        this.C.setText("0%");
        this.D.setOnClickListener(new b());
        this.I.postDelayed(this.J, 200L);
        Intent intent = getBaseActivity().getIntent();
        if (intent != null) {
            SlideShowPhotoListManager.n().H();
            ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("qzone_slide_show_matters");
            int intExtra = intent.getIntExtra("qqstory_slide_show_scene", 21);
            this.G = intent.getIntExtra("entrance_qzone_p2v", -1);
            if (parcelableArrayListExtra != null && parcelableArrayListExtra.size() > 0 && intExtra == 22) {
                LocalMediaInfo localMediaInfo = (LocalMediaInfo) parcelableArrayListExtra.get(0);
                if (localMediaInfo.mMimeType.contains("image")) {
                    new BitmapFactory.Options().inPreferredConfig = Bitmap.Config.RGB_565;
                    this.F.setImageBitmap(BitmapFactory.decodeFile(localMediaInfo.path));
                } else if (localMediaInfo.mMimeType.contains("video")) {
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(localMediaInfo.path);
                    Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L, 3);
                    mediaMetadataRetriever.release();
                    this.F.setImageBitmap(frameAtTime);
                }
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < parcelableArrayListExtra.size(); i3++) {
                    arrayList.add(new SlideItemInfo((LocalMediaInfo) parcelableArrayListExtra.get(i3)));
                }
                SlideShowPhotoListManager.n().D(arrayList);
                SlideShowPhotoListManager.n().C(arrayList);
                SlideShowPhotoListManager.n().B(intExtra);
                SlideShowPhotoListManager.n().A(this.G);
                SlideShowPhotoListManager.n().i(getBaseActivity(), new e(this), 2);
            } else {
                QLog.e(str, 2, "slideShowLocalMediaInfos is null or SlideShowScene is not QzoneSlideShowPhotoListManager.SCENE_QZONE");
                finish();
            }
        }
        LpReportInfo_pf00064.allReport(680, 1, 1);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        QLog.d(K, 2, "QzoneSlideShowPreparingFragment onDestroy");
        zh();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }
}
