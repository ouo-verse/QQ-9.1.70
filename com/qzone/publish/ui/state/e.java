package com.qzone.publish.ui.state;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.QZoneFontPanel;
import com.qzone.common.activities.base.QZoneFontTabView;
import com.qzone.common.activities.base.QZoneSuperFontPanel;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.publish.ui.activity.QZonePublishMoodBaseActivity;
import com.qzone.publish.ui.model.ShuoshuoContent;
import com.qzone.reborn.util.l;
import com.qzone.widget.ExtendEditText;
import com.tencent.mobileqq.R;
import com.tencent.widget.ActionSheet;
import cooperation.peak.PeakConstants;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.io.File;

/* compiled from: P */
@Deprecated
/* loaded from: classes39.dex */
public class e extends com.qzone.publish.ui.state.a {

    /* renamed from: j, reason: collision with root package name */
    private boolean f52080j;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements ActionSheet.OnButtonClickListener {
        a() {
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            e eVar;
            ActionSheet actionSheet;
            QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity = e.this.f52057a.get();
            if (qZonePublishMoodBaseActivity == null || (actionSheet = (eVar = e.this).f52063g) == null) {
                return;
            }
            if (!eVar.f52059c) {
                if (i3 == 2) {
                    actionSheet.superDismiss();
                    return;
                } else {
                    qZonePublishMoodBaseActivity.U2 = false;
                    qZonePublishMoodBaseActivity.finish();
                    return;
                }
            }
            if (i3 == 0) {
                eVar.o();
                qZonePublishMoodBaseActivity.on();
                qZonePublishMoodBaseActivity.U2 = false;
                qZonePublishMoodBaseActivity.finish();
            } else if (i3 == 1) {
                eVar.t();
                e.this.d();
                qZonePublishMoodBaseActivity.nn();
                qZonePublishMoodBaseActivity.U2 = false;
                Intent intent = new Intent();
                intent.putExtra("finish_video_component", true);
                qZonePublishMoodBaseActivity.getActivity().setResult(-1, intent);
                qZonePublishMoodBaseActivity.finish();
            }
            e.this.f52063g.superDismiss();
        }
    }

    public e(QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity) {
        super(qZonePublishMoodBaseActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        ShuoshuoVideoInfo shuoshuoVideoInfo;
        QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity = this.f52057a.get();
        if (qZonePublishMoodBaseActivity == null || (shuoshuoVideoInfo = qZonePublishMoodBaseActivity.I4) == null || shuoshuoVideoInfo.mVideoType != 0) {
            return;
        }
        u(new File(qZonePublishMoodBaseActivity.I4.mVideoPath));
    }

    @Override // com.qzone.publish.ui.state.a
    public void b() {
        QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity = this.f52057a.get();
        if (qZonePublishMoodBaseActivity == null) {
            return;
        }
        if (!TextUtils.isEmpty(qZonePublishMoodBaseActivity.f45096g1)) {
            qZonePublishMoodBaseActivity.An();
        }
        qZonePublishMoodBaseActivity.setTitle(R.string.glq);
        qZonePublishMoodBaseActivity.jm(qZonePublishMoodBaseActivity.getText(R.string.glp));
        if (!this.f52059c || this.f52080j) {
            return;
        }
        m();
    }

    @Override // com.qzone.publish.ui.state.a
    public void f() {
        QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity = this.f52057a.get();
        if (qZonePublishMoodBaseActivity == null) {
            return;
        }
        ActionSheet actionSheet = this.f52063g;
        if (actionSheet == null || !actionSheet.isShowing()) {
            ActionSheet create = ActionSheet.create(qZonePublishMoodBaseActivity.getActivity());
            this.f52063g = create;
            if (!this.f52059c) {
                if (!qZonePublishMoodBaseActivity.Wj()) {
                    t();
                    qZonePublishMoodBaseActivity.finish();
                    return;
                }
                this.f52063g.addButton(R.string.gd6, 3);
            } else {
                create.setMainTitle(R.string.glm);
                this.f52063g.addButton(R.string.gnh, 1);
                this.f52063g.addButton(R.string.f173019gi3, 3);
            }
            this.f52063g.addCancelButton(R.string.cancel);
            this.f52063g.setOnButtonClickListener(new a());
            this.f52063g.show();
        }
    }

    @Override // com.qzone.publish.ui.state.a
    public int h() {
        return 2;
    }

    @Override // com.qzone.publish.ui.state.a
    public void i(Intent intent) {
        super.i(intent);
        QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity = this.f52057a.get();
        if (qZonePublishMoodBaseActivity == null) {
            return;
        }
        if (!qZonePublishMoodBaseActivity.f45114m1) {
            qZonePublishMoodBaseActivity.Gn(false);
        }
        this.f52080j = intent.getBooleanExtra(PeakConstants.IS_VIDEO_SELECTED, false);
        qZonePublishMoodBaseActivity.Wm();
        int intExtra = intent.getIntExtra(PeakConstants.VIDEO_TYPE, -1);
        qZonePublishMoodBaseActivity.f45111l1 = l.f59550a.p(qZonePublishMoodBaseActivity.bj(), intent);
        QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_PUBLISH, String.valueOf(intExtra), null);
    }

    @Override // com.qzone.publish.ui.state.a
    public void m() {
        ShuoshuoVideoInfo Y;
        super.m();
        QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity = this.f52057a.get();
        if (qZonePublishMoodBaseActivity == null || (Y = u5.b.Y("_shuoshuo", this.f52062f)) == null || this.f52060d) {
            return;
        }
        qZonePublishMoodBaseActivity.setTitle(R.string.glq);
        qZonePublishMoodBaseActivity.jm(qZonePublishMoodBaseActivity.getText(R.string.glp));
        qZonePublishMoodBaseActivity.km(Y.mVideoPath);
        qZonePublishMoodBaseActivity.un(Y);
        qZonePublishMoodBaseActivity.f45114m1 = true;
        qZonePublishMoodBaseActivity.Gn(true);
        QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_ENTRANCE, "4", null);
        QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_PUBLISH, "2", null);
    }

    @Override // com.qzone.publish.ui.state.a
    public void o() {
        QZoneSuperFontPanel qZoneSuperFontPanel;
        QZoneFontPanel qZoneFontPanel;
        QZonePublishMoodBaseActivity qZonePublishMoodBaseActivity = this.f52057a.get();
        if (qZonePublishMoodBaseActivity == null) {
            return;
        }
        ShuoshuoContent shuoshuoContent = new ShuoshuoContent();
        shuoshuoContent.setEventTag(qZonePublishMoodBaseActivity.f51489v5);
        shuoshuoContent.setAtFriends(qZonePublishMoodBaseActivity.f45141y0);
        shuoshuoContent.setCurrentPoiInfo(qZonePublishMoodBaseActivity.M0);
        if (qZonePublishMoodBaseActivity.f51472o5 != null) {
            shuoshuoContent.setImageShootInfoLbs(qZonePublishMoodBaseActivity.Xm());
        }
        shuoshuoContent.setmCurrentShootPoiInfo(qZonePublishMoodBaseActivity.L0);
        shuoshuoContent.setmPriv(qZonePublishMoodBaseActivity.k3);
        shuoshuoContent.setmPrivUinList(qZonePublishMoodBaseActivity.l3);
        shuoshuoContent.setVideoInfo(qZonePublishMoodBaseActivity.Ym());
        CheckBox checkBox = qZonePublishMoodBaseActivity.C2;
        if (checkBox != null) {
            shuoshuoContent.setSyncQQ(checkBox.isChecked());
        }
        CheckBox checkBox2 = qZonePublishMoodBaseActivity.G2;
        if (checkBox2 != null) {
            shuoshuoContent.setSyncWechat(checkBox2.isChecked());
        }
        ExtendEditText extendEditText = qZonePublishMoodBaseActivity.f45104j0;
        if (extendEditText != null) {
            shuoshuoContent.setTextDraft(extendEditText.getText().toString());
        }
        QZoneFontTabView qZoneFontTabView = qZonePublishMoodBaseActivity.f45098h0;
        if (qZoneFontTabView != null && (qZoneFontPanel = qZoneFontTabView.f45368i) != null) {
            qZoneFontPanel.g0();
        }
        QZoneFontTabView qZoneFontTabView2 = qZonePublishMoodBaseActivity.f45098h0;
        if (qZoneFontTabView2 != null && (qZoneSuperFontPanel = qZoneFontTabView2.f45369m) != null) {
            qZoneSuperFontPanel.X();
        }
        shuoshuoContent.setState(h());
        u5.b.N0(shuoshuoContent, g());
    }

    private static void u(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    u(file2);
                }
            }
            file.delete();
        }
    }
}
