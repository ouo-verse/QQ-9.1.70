package com.tencent.aelight.camera.struct.editor;

import NS_QQ_STORY_META.META$StMusic;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FlowMusic extends Entity implements Comparable<FlowMusic> {
    public static final int SOURCE_CUSTOM_ADD = 0;
    public static final int SOURCE_QQ_MUSIC_AUTO = 1;
    public int albumId;
    public String albumMid;
    public String albumName;
    public String albumUrl;
    public int duration;
    public String path;

    @notColumn
    public int playable;
    public int singerId;
    public String singerMid;
    public String singerName;

    @notColumn
    public long size;

    @unique
    public int songId;
    public String songMid;
    public String songName;
    public int songPlayTime;
    public int sourceType;
    public long storeTimeStamp;
    public int tryBegin;
    public int tryEnd;

    @notColumn
    public String url;
    public int userOwnRule;

    public FlowMusic() {
        this.tryBegin = -1;
        this.tryEnd = -1;
        this.duration = -1;
        this.path = null;
        this.url = null;
        this.size = -1L;
        this.sourceType = 0;
        this.playable = 1;
        this.storeTimeStamp = -1L;
    }

    public void copyFrom(FlowMusic flowMusic) {
        this.albumId = flowMusic.albumId;
        this.albumMid = flowMusic.albumMid;
        this.albumName = flowMusic.albumName;
        this.albumUrl = flowMusic.albumUrl;
        this.singerId = flowMusic.singerId;
        this.singerMid = flowMusic.singerMid;
        this.singerName = flowMusic.singerName;
        this.songId = flowMusic.songId;
        this.songMid = flowMusic.songMid;
        this.songName = flowMusic.songName;
        this.songPlayTime = flowMusic.songPlayTime;
        this.userOwnRule = flowMusic.userOwnRule;
        this.tryBegin = flowMusic.tryBegin;
        this.tryEnd = flowMusic.tryEnd;
        this.duration = flowMusic.duration;
        this.path = flowMusic.path;
        this.url = flowMusic.url;
        this.size = flowMusic.size;
        this.sourceType = flowMusic.sourceType;
        this.playable = flowMusic.playable;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && this.songId == ((FlowMusic) obj).songId) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.songId;
    }

    public String toString() {
        return "FlowMusic{url='" + this.url + "', songMid='" + this.songMid + "', songName='" + this.songName + "', playable=" + this.playable + ", albumId=" + this.albumId + ", albumMid='" + this.albumMid + "', albumName='" + this.albumName + "', albumUrl='" + this.albumUrl + "', singerId=" + this.singerId + ", singerMid='" + this.singerMid + "', singerName='" + this.singerName + "', songId=" + this.songId + ", songPlayTime=" + this.songPlayTime + ", userOwnRule=" + this.userOwnRule + ", tryBegin=" + this.tryBegin + ", tryEnd=" + this.tryEnd + ", duration=" + this.duration + ", path='" + this.path + "', size=" + this.size + ", sourceType=" + this.sourceType + ", storeTimeStamp=" + this.storeTimeStamp + '}';
    }

    @Override // java.lang.Comparable
    public int compareTo(FlowMusic flowMusic) {
        if (flowMusic == null) {
            return 1;
        }
        if (this != flowMusic && this.songId != flowMusic.songId) {
            int i3 = this.sourceType;
            int i16 = flowMusic.sourceType;
            if (i3 != i16) {
                return i3 - i16;
            }
            long j3 = flowMusic.storeTimeStamp - this.storeTimeStamp;
            if (j3 > 0) {
                return 1;
            }
            if (j3 < 0) {
                return -1;
            }
        }
        return 0;
    }

    public FlowMusic(MusicItemInfo musicItemInfo) {
        this.tryBegin = -1;
        this.tryEnd = -1;
        this.duration = -1;
        this.path = null;
        this.url = null;
        this.size = -1L;
        this.sourceType = 0;
        this.playable = 1;
        this.storeTimeStamp = -1L;
        this.songId = musicItemInfo.mItemId;
        this.singerName = musicItemInfo.mSingername;
        this.songName = musicItemInfo.mMusicName;
        this.url = musicItemInfo.mUrl;
        this.tryBegin = musicItemInfo.musicStart;
        this.tryEnd = musicItemInfo.musicEnd;
        this.songMid = musicItemInfo.mSongMid;
        this.duration = musicItemInfo.musicDuration;
        this.storeTimeStamp = System.currentTimeMillis();
        this.albumUrl = musicItemInfo.mAlbumUrl;
    }

    public FlowMusic(META$StMusic mETA$StMusic) {
        this.tryBegin = -1;
        this.tryEnd = -1;
        this.duration = -1;
        this.path = null;
        this.url = null;
        this.size = -1L;
        this.sourceType = 0;
        this.playable = 1;
        this.storeTimeStamp = -1L;
        this.albumId = (int) mETA$StMusic.uiAlbumId.get();
        this.albumMid = mETA$StMusic.strAlbumMid.get();
        this.albumName = mETA$StMusic.strAlbumName.get();
        this.albumUrl = mETA$StMusic.strAlbumPic.get();
        this.singerId = (int) mETA$StMusic.uiSingerId.get();
        this.singerMid = mETA$StMusic.strSingerMid.get();
        this.singerName = mETA$StMusic.strSingerName.get();
        this.songId = (int) mETA$StMusic.uiSongId.get();
        this.songMid = mETA$StMusic.strSongMid.get();
        this.songName = mETA$StMusic.strSongName.get();
        this.songPlayTime = mETA$StMusic.iPlayTime.get();
        this.userOwnRule = mETA$StMusic.iTrySize.get() > 0 ? 1 : 0;
        this.url = mETA$StMusic.strPlayUrl.get();
        this.size = mETA$StMusic.iSize.get();
        this.playable = mETA$StMusic.copyright.get();
        this.storeTimeStamp = System.currentTimeMillis();
    }
}
