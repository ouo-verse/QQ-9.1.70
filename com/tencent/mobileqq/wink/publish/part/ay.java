package com.tencent.mobileqq.wink.publish.part;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.richframework.widget.MultiPicViewPager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.mobileqq.winkpublish.publishconst.WinkHostConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import com.tencent.richframework.thread.RFWThreadManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes21.dex */
public class ay extends j implements View.OnClickListener {
    private String C;
    private int D;
    private ArrayList<LocalMediaInfo> E;
    private int F = 0;

    /* renamed from: d, reason: collision with root package name */
    private n93.a f325825d;

    /* renamed from: e, reason: collision with root package name */
    private MultiPicViewPager f325826e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f325827f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f325828h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f325829i;

    /* renamed from: m, reason: collision with root package name */
    private MediaPlayer f325830m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (i3 == 1) {
                ay.this.F9();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F9() {
        getActivity().finish();
    }

    private void G9() {
        n93.a aVar = new n93.a();
        this.f325825d = aVar;
        aVar.e(K9());
        this.f325826e.setAdapter(this.f325825d);
        this.f325826e.setCurrentItem(this.F, false);
        this.f325826e.addOnPageChangeListener(new a());
        L9(this.F);
    }

    private void H9() {
        Intent intent;
        if (getActivity() == null || (intent = getActivity().getIntent()) == null) {
            return;
        }
        if (intent.hasExtra(QQWinkConstants.INPUT_MEDIA)) {
            this.E = (ArrayList) intent.getSerializableExtra(QQWinkConstants.INPUT_MEDIA);
        }
        this.F = intent.getIntExtra(FSPublishConstants.PREVIEW_START_POSITION, 0);
        if (intent.hasExtra(QQWinkConstants.PUBLISH_MUSIC_START_TIME)) {
            this.D = (int) intent.getLongExtra(QQWinkConstants.PUBLISH_MUSIC_START_TIME, 0L);
        }
        if (intent.hasExtra(QQWinkConstants.PUBLISH_MUSIC_LOCAL_PATH)) {
            this.C = intent.getStringExtra(QQWinkConstants.PUBLISH_MUSIC_LOCAL_PATH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I9() {
        MediaPlayer mediaPlayer = this.f325830m;
        if (mediaPlayer == null) {
            this.f325830m = new ReportMediaPlayer();
        } else {
            mediaPlayer.stop();
            this.f325830m.reset();
        }
        if (J9(this.C)) {
            try {
                this.f325830m.setAudioStreamType(3);
                this.f325830m.setDataSource(this.C);
                this.f325830m.setVolume(0.5f, 0.5f);
                this.f325830m.setOnSeekCompleteListener(new c());
                this.f325830m.prepare();
                this.f325830m.seekTo(this.D);
                this.f325830m.setLooping(true);
                this.f325830m.start();
            } catch (Exception e16) {
                QLog.d("QCirclePublishPicPreviewPart", 1, "playImageMusic, exception = " + e16.toString());
            }
        }
    }

    public static boolean J9(@Nullable String str) {
        QLog.d("QCirclePublishPicPreviewPart", 1, "[localMusicExists], localMusicPath=" + str);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    private ArrayList<k93.a> K9() {
        ArrayList<k93.a> arrayList = new ArrayList<>();
        ArrayList<LocalMediaInfo> arrayList2 = this.E;
        if (arrayList2 != null && arrayList2.size() != 0) {
            Iterator<LocalMediaInfo> it = this.E.iterator();
            while (it.hasNext()) {
                LocalMediaInfo next = it.next();
                if (next != null) {
                    arrayList.add(new k93.a(next.path, next));
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L9(int i3) {
        n93.a aVar = this.f325825d;
        if (aVar != null && aVar.d().size() != 0) {
            int size = this.f325825d.d().size();
            this.f325828h.setVisibility(0);
            this.f325828h.setText(getContext().getResources().getString(R.string.f184293lh, Integer.valueOf(i3 + 1), Integer.valueOf(size)));
        } else {
            TextView textView = this.f325828h;
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.publish.part.j
    @NonNull
    public String B9() {
        return "QCirclePublishPicPreviewPart";
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QCirclePublishPicPreviewPart";
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (WinkHostConstants.QQStoryMainActivity.requestCodeTakeVideo() == i3 && i16 == -1) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(WinkHostConstants.PhotoConst.photoPaths());
            HashMap hashMap = (HashMap) intent.getSerializableExtra(WinkHostConstants.QAlbumConstants.selectedMediaInfoHashMap());
            if (stringArrayListExtra != null && stringArrayListExtra.size() != 0) {
                ArrayList arrayList = new ArrayList();
                Iterator<String> it = stringArrayListExtra.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    arrayList.add(new k93.a(next, (LocalMediaInfo) hashMap.get(next)));
                }
                if (arrayList.size() > 0) {
                    this.f325829i = true;
                }
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        if (this.f325829i) {
            b bVar = new b();
            com.tencent.mobileqq.wink.view.o.N(getContext(), HardCodeUtil.qqStr(R.string.f184273lf), null, R.string.cancel, R.string.f184283lg, bVar, bVar).show();
            return true;
        }
        F9();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.du6) {
            onBackEvent();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f325826e = (MultiPicViewPager) view.findViewById(R.id.f12032799);
        this.f325827f = (ImageView) view.findViewById(R.id.du6);
        this.f325828h = (TextView) view.findViewById(R.id.k_3);
        this.f325827f.setOnClickListener(this);
        H9();
        G9();
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.wink.publish.part.ax
            @Override // java.lang.Runnable
            public final void run() {
                ay.this.I9();
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        MediaPlayer mediaPlayer = this.f325830m;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        MediaPlayer mediaPlayer = this.f325830m;
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            this.f325830m.pause();
        }
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        MediaPlayer mediaPlayer = this.f325830m;
        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            this.f325830m.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class a implements ViewPager.OnPageChangeListener {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            ay.this.L9(i3);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class c implements MediaPlayer.OnSeekCompleteListener {
        c() {
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
        }
    }
}
