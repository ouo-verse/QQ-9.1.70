package com.tencent.aelight.camera.aioeditor.capture.music;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.aelight.camera.aioeditor.capture.view.MusicProviderView;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager;
import com.tencent.aelight.camera.aioeditor.takevideo.u;
import com.tencent.aelight.camera.aioeditor.takevideo.x;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.aelight.camera.report.api.IAEBaseReportParam;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c extends u implements com.tencent.aelight.camera.aioeditor.takevideo.f, d, View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private boolean f66786d;

    /* renamed from: e, reason: collision with root package name */
    private long f66787e;

    /* renamed from: f, reason: collision with root package name */
    private g f66788f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f66789h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f66790i;

    public c(EditVideoPartManager editVideoPartManager, boolean z16) {
        super(editVideoPartManager);
        this.f66787e = -1L;
        this.f66788f = (g) fr.f.d().g(8);
        this.f66789h = false;
        this.f66790i = true;
        this.f66786d = z16;
    }

    private Bundle j0() {
        Bundle bundle = this.mParent.Y;
        if (bundle != null) {
            return bundle.getBundle(ParseCommon.CONTAINER);
        }
        return null;
    }

    private MusicItemInfo k0() {
        Bundle j06 = j0();
        Bundle bundle = j06 != null ? j06.getBundle(MusicProviderView.class.getSimpleName()) : null;
        if (bundle == null) {
            return null;
        }
        MusicItemInfo musicItemInfo = (MusicItemInfo) bundle.getParcelable(AEEditorConstants.SELECT_MUSIC);
        String string = bundle.getString(AEEditorConstants.SELECT_MUSIC_LOCAL_PATH);
        boolean z16 = bundle.getBoolean(AEEditorConstants.SELECT_MUTE);
        if (musicItemInfo == null) {
            if (!z16) {
                return musicItemInfo;
            }
            MusicItemInfo musicItemInfo2 = new MusicItemInfo();
            musicItemInfo2.mType = 3;
            musicItemInfo2.mItemId = -2;
            return musicItemInfo2;
        }
        if (!TextUtils.isEmpty(string)) {
            musicItemInfo.setPath(string);
        }
        if (!QLog.isColorLevel()) {
            return musicItemInfo;
        }
        QLog.i("EditVideoQimMusic", 2, "restore music" + musicItemInfo.mMusicName);
        return musicItemInfo;
    }

    private void m0(int i3, fs.b bVar, MusicItemInfo musicItemInfo) {
        boolean booleanExtra = bVar.f400387d.getBooleanExtra(PublishVideoEntry.ENTRY_KEY_IS_MIX_ORIGINAL, this.f66786d);
        if (musicItemInfo != null) {
            PublishVideoEntry publishVideoEntry = bVar.f400387d;
            int i16 = musicItemInfo.musicStart;
            publishVideoEntry.backgroundMusicOffset = i16;
            int i17 = musicItemInfo.musicEnd - i16;
            if (!this.mParent.m0()) {
                i17 = Math.min(i17, (int) this.mParent.a0(i3));
            }
            PublishVideoEntry publishVideoEntry2 = bVar.f400387d;
            publishVideoEntry2.backgroundMusicDuration = i17;
            publishVideoEntry2.backgroundMusicPath = musicItemInfo.getLocalPath();
            PublishVideoEntry publishVideoEntry3 = bVar.f400387d;
            publishVideoEntry3.isMuteRecordVoice = !booleanExtra;
            publishVideoEntry3.putExtra("vs_publish_entry_json_key_music_id", Integer.valueOf(musicItemInfo.mItemId));
            bVar.f400387d.putExtra("vs_publish_entry_json_key_music_mid_id", musicItemInfo.mSongMid);
            bVar.f400387d.putExtra("vs_publish_entry_json_key_song_name", musicItemInfo.mMusicName);
            bVar.f400387d.putExtra("vs_publish_entry_json_key_music_album_pic", musicItemInfo.mAlbumUrl);
            return;
        }
        MusicItemInfo m3 = this.f66788f.m();
        if (m3 != null) {
            if (m3.mType == 3 || m3.isDownloading()) {
                bVar.f400387d.backgroundMusicPath = null;
            }
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.f
    public void A() {
        MusicItemInfo j3;
        if (this.f66788f == null) {
            return;
        }
        if (this.f66789h) {
            if (QLog.isColorLevel()) {
                QLog.d("EditVideoQimMusic", 2, "playBgMusic in = null isPause=" + this.f66789h);
                return;
            }
            return;
        }
        g gVar = (g) fr.f.d().g(8);
        this.f66788f = gVar;
        if (this.f66790i) {
            this.f66790i = false;
            j3 = k0();
            if (j3 == null) {
                this.f66788f.i();
            }
        } else {
            j3 = gVar.j();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("EditVideoQimMusic", 2, "playBgMusic in mPreTime=" + this.f66787e + " currentTime=" + currentTimeMillis);
        }
        this.f66788f.y(j3, true, this.mParent.L());
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.music.d
    public void D(boolean z16) {
        x xVar = (x) this.mParent.R(x.class);
        if (xVar != null) {
            xVar.K(z16);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoPrePublish(int i3, fs.b bVar) {
        super.editVideoPrePublish(i3, bVar);
        g gVar = this.f66788f;
        if (gVar == null) {
            return;
        }
        MusicItemInfo j3 = gVar.j();
        if (j3 != null) {
            String str = j3.mTagName;
            if (TextUtils.isEmpty(str)) {
                str = "none";
            }
            ((IAEBaseReportParam) QRoute.api(IAEBaseReportParam.class)).setEditMusicId(str + "_" + j3.mItemId);
        }
        EditVideoParams editVideoParams = this.mParent.C;
        if (editVideoParams != null && editVideoParams.f204055d == 14) {
            m0(i3, bVar, j3);
        } else {
            l0(i3, bVar, j3);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.mParent.t(0);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onCreate() {
        super.onCreate();
        publishEditExport(com.tencent.aelight.camera.aioeditor.takevideo.f.class, this);
        g gVar = this.f66788f;
        if (gVar != null) {
            gVar.B(this);
            this.f66788f.s(this.f66786d);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onDestroy() {
        super.onDestroy();
        this.f66788f.B(null);
        this.f66788f = null;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onPause() {
        super.onPause();
        this.f66789h = true;
        g gVar = this.f66788f;
        if (gVar != null) {
            gVar.q();
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onResume() {
        super.onResume();
        this.f66789h = false;
        if (QLog.isColorLevel()) {
            QLog.d("EditVideoQimMusic", 2, "onResume");
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onStop() {
        super.onStop();
    }

    private void l0(int i3, fs.b bVar, MusicItemInfo musicItemInfo) {
        if (musicItemInfo != null) {
            if (musicItemInfo.isMyMusicInfo()) {
                PublishVideoEntry publishVideoEntry = bVar.f400387d;
                int i16 = musicItemInfo.musicStart;
                publishVideoEntry.backgroundMusicOffset = i16;
                bVar.f400387d.backgroundMusicDuration = Math.min(musicItemInfo.musicEnd - i16, (int) this.mParent.a0(i3));
            } else {
                PublishVideoEntry publishVideoEntry2 = bVar.f400387d;
                publishVideoEntry2.backgroundMusicOffset = 0;
                publishVideoEntry2.backgroundMusicDuration = (int) this.mParent.a0(i3);
            }
            bVar.f400387d.backgroundMusicPath = musicItemInfo.getLocalPath();
            bVar.f400387d.isMuteRecordVoice = true;
            return;
        }
        MusicItemInfo m3 = this.f66788f.m();
        if (m3 == null || m3.mType != 3) {
            return;
        }
        PublishVideoEntry publishVideoEntry3 = bVar.f400387d;
        publishVideoEntry3.backgroundMusicPath = null;
        publishVideoEntry3.isMuteRecordVoice = true;
    }
}
