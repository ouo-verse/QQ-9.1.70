package com.tencent.biz.videostory.widget.view.smartmusicview;

import NS_QQ_STORY_META.META$StMusic;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import org.json.JSONObject;
import qqcircle.QQCircleSmartMatchMusic$MusicInfo;

/* compiled from: P */
/* loaded from: classes5.dex */
public class VsMusicItemInfo extends MusicItemInfo {

    /* renamed from: d, reason: collision with root package name */
    public String f97246d;

    /* renamed from: e, reason: collision with root package name */
    public String f97247e;

    /* renamed from: f, reason: collision with root package name */
    public int f97248f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f97249h;

    /* renamed from: i, reason: collision with root package name */
    public String f97250i;

    public VsMusicItemInfo() {
        this.f97248f = 1;
        this.f97249h = true;
        this.f97250i = HardCodeUtil.qqStr(R.string.vjc);
    }

    public void a(META$StMusic mETA$StMusic) {
        this.mSongMid = mETA$StMusic.strSongMid.get();
        this.mType = 5;
        this.mUrl = mETA$StMusic.strPlayUrl.get();
        boolean z16 = true;
        if (mETA$StMusic.copyright.get() != 1) {
            z16 = false;
        }
        this.mHasCopyright = z16;
        this.mSingername = mETA$StMusic.strSingerName.get();
        this.mMusicName = mETA$StMusic.strSongName.get();
        this.mAlbumUrl = mETA$StMusic.strAlbumPic.get();
        this.f97247e = mETA$StMusic.strLyric.get();
        this.musicStart = (int) mETA$StMusic.iStartPos.get();
        this.musicEnd = 0;
        this.f97246d = mETA$StMusic.strFormat.get();
        this.mItemId = (int) mETA$StMusic.uiSongId.get();
        this.musicDuration = mETA$StMusic.iPlayTime.get() * 1000;
        this.fileSize = mETA$StMusic.iSize.get();
    }

    public void b(QQCircleSmartMatchMusic$MusicInfo qQCircleSmartMatchMusic$MusicInfo) {
        this.mSongMid = qQCircleSmartMatchMusic$MusicInfo.songInfo.MID.get();
        this.mType = 5;
        this.mUrl = qQCircleSmartMatchMusic$MusicInfo.songInfo.PlayUrl.get();
        boolean z16 = true;
        if (qQCircleSmartMatchMusic$MusicInfo.songInfo.Copyright.get() != 1) {
            z16 = false;
        }
        this.mHasCopyright = z16;
        this.mSingername = qQCircleSmartMatchMusic$MusicInfo.singerInfo.name.get();
        this.mMusicName = qQCircleSmartMatchMusic$MusicInfo.songInfo.name.get();
        this.mAlbumUrl = qQCircleSmartMatchMusic$MusicInfo.albumInfo.picURL.get();
        this.f97247e = qQCircleSmartMatchMusic$MusicInfo.lyricInfo.strLyric.get();
        this.musicStart = qQCircleSmartMatchMusic$MusicInfo.confInfo.startPos.get();
        this.musicEnd = 0;
        this.f97246d = qQCircleSmartMatchMusic$MusicInfo.lyricInfo.strFormat.get();
        this.mItemId = (int) qQCircleSmartMatchMusic$MusicInfo.lyricInfo.uiSongId.get();
        this.musicDuration = qQCircleSmartMatchMusic$MusicInfo.songInfo.IPlayTime.get() * 1000;
        this.fileSize = qQCircleSmartMatchMusic$MusicInfo.songInfo.ISize.get();
    }

    public VsMusicItemInfo(JSONObject jSONObject) {
        this.f97248f = 1;
        this.f97249h = true;
        this.f97250i = HardCodeUtil.qqStr(R.string.vjc);
        this.mType = 5;
        this.mMusicName = jSONObject.optString("title");
        this.mSingername = jSONObject.optString("desc");
        this.mItemId = jSONObject.optInt("id");
        this.mAlbumUrl = jSONObject.optString("image_url");
        this.mSongMid = jSONObject.optString("mid");
        this.mMusicName = jSONObject.optString("strSongName");
        this.mHasCopyright = true;
        this.f97248f = 2;
        this.mUrl = jSONObject.optString("strPlayUrl");
        this.musicDuration = jSONObject.optInt("iPlayTime") * 1000;
    }

    public VsMusicItemInfo(QQCircleSmartMatchMusic$MusicInfo qQCircleSmartMatchMusic$MusicInfo) {
        this.f97248f = 1;
        this.f97249h = true;
        this.f97250i = HardCodeUtil.qqStr(R.string.vjc);
        if (qQCircleSmartMatchMusic$MusicInfo == null) {
            return;
        }
        b(qQCircleSmartMatchMusic$MusicInfo);
    }
}
