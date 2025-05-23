package com.qzone.album.data.model;

import NS_MOBILE_PHOTO.Album;
import NS_MOBILE_PHOTO.stRecommandAlbum;
import NS_MOBILE_PHOTO.stRecommandAlbumEx;
import NS_MOBILE_PHOTO.stRecommandUpload;
import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import t5.b;

/* compiled from: P */
/* loaded from: classes39.dex */
public class RecomAlbumList implements SmartParcelable {
    public static final String TAG = "RecomAlbumList";

    @NeedParcel
    public String albumListDesc;

    @NeedParcel
    public int mDownnerBound;

    @NeedParcel
    public int mUpperBound;
    public stRecommandUpload recommandUploadInfo;

    @NeedParcel
    public boolean hasMore = false;

    @NeedParcel
    public ArrayList<AlbumCacheData> recomAlbumList = new ArrayList<>();

    @NeedParcel
    public ArrayList<RecomAlbumExData> recomAlbumVecExList = new ArrayList<>();

    @NeedParcel
    public boolean mCanBeShown = false;

    private boolean isValidAlbum(Album album) {
        if (album == null) {
            if (QZLog.isColorLevel()) {
                QZLog.e(TAG, "Found Null Album!");
            }
            return false;
        }
        if (album.total > 0) {
            return true;
        }
        if (QZLog.isColorLevel() && !TextUtils.isEmpty(album.name)) {
            QZLog.e(TAG, "Found Empty Album | AlbumName = " + album.name);
        }
        return false;
    }

    private void parseRecommandUploadFeature(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            stRecommandUpload strecommandupload = (stRecommandUpload) b.b(stRecommandUpload.class, bArr);
            this.recommandUploadInfo = strecommandupload;
            if (strecommandupload == null) {
                QZLog.w(TAG, "[parseRecommandUploadFeature] invalid recommandUploadInfo");
                return;
            }
            if (QZLog.isColorLevel()) {
                QZLog.d(TAG, 2, "[parseRecommandUploadFeature] type=" + this.recommandUploadInfo.type + ", leftDays=" + this.recommandUploadInfo.left_days + ", begin=" + this.recommandUploadInfo.begin + ", end=" + this.recommandUploadInfo.end);
                return;
            }
            return;
        }
        QZLog.w(TAG, "[parseRecommandUploadFeature] invalid datas");
    }

    public boolean canBeShown() {
        return this.mCanBeShown;
    }

    public List<RecomAlbumExData> getFullData() {
        ArrayList<RecomAlbumExData> arrayList = this.recomAlbumVecExList;
        if (arrayList == null || !this.mCanBeShown) {
            return null;
        }
        return arrayList;
    }

    public void setUpBoundary(int i3, int i16) {
        this.mUpperBound = i3;
        this.mDownnerBound = i16;
    }

    private void parseRecommandAlbumFeature(byte[] bArr, int i3, int i16) {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        if (i3 == -1 || i16 == -1 || i3 >= i16) {
            setUpBoundary(i3, i16);
            createFromResponse((stRecommandAlbum) b.b(stRecommandAlbum.class, bArr));
        }
    }

    public List<AlbumCacheData[]> changeDataStructure(int i3) {
        if (i3 <= 0 || this.recomAlbumList == null || !this.mCanBeShown) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        AlbumCacheData[] albumCacheDataArr = new AlbumCacheData[i3];
        int i16 = 0;
        for (int i17 = 0; i17 < this.recomAlbumList.size(); i17++) {
            albumCacheDataArr[i16] = this.recomAlbumList.get(i17);
            i16++;
            if (i16 % i3 == 0) {
                arrayList.add(albumCacheDataArr);
                albumCacheDataArr = new AlbumCacheData[i3];
                i16 = 0;
            }
        }
        return arrayList;
    }

    public void createFromResponse(stRecommandAlbum strecommandalbum) {
        if (strecommandalbum != null) {
            if (this.recomAlbumList == null) {
                this.recomAlbumList = new ArrayList<>();
            }
            this.recomAlbumList.clear();
            ArrayList<stRecommandAlbumEx> arrayList = strecommandalbum.recommandAlbumVecEx;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<stRecommandAlbumEx> it = strecommandalbum.recommandAlbumVecEx.iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    stRecommandAlbumEx next = it.next();
                    if (next != null) {
                        this.recomAlbumVecExList.add(RecomAlbumExData.createFromResponse(next));
                        Album album = next.albuminfo;
                        if (isValidAlbum(album)) {
                            AlbumCacheData createFromResponse = AlbumCacheData.createFromResponse(album);
                            createFromResponse.albumOwner = strecommandalbum.summary;
                            this.recomAlbumList.add(createFromResponse);
                            i3++;
                            int i16 = this.mUpperBound;
                            if (i3 == i16 && i16 != -1) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            int size = this.recomAlbumList.size();
            int i17 = this.mDownnerBound;
            if (size < i17 && i17 != -1) {
                this.mCanBeShown = false;
                return;
            }
            this.albumListDesc = strecommandalbum.summary;
            this.hasMore = strecommandalbum.hasMore;
            this.mCanBeShown = true;
        }
    }

    public void parsedFromFeature(Map<Integer, byte[]> map, int i3, int i16) {
        if (map == null || map.size() == 0) {
            return;
        }
        parseRecommandAlbumFeature(map.get(1), i3, i16);
        parseRecommandUploadFeature(map.get(2));
    }
}
