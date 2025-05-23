package com.tencent.mobileqq.activity.photo.album;

import android.content.Context;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.querymedia.ICursor;
import com.tencent.mobileqq.activity.photo.album.querymedia.MediaQueryHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes10.dex */
public final class PhotoCommonBaseData<O extends OtherCommonData> {
    static IPatchRedirector $redirector_ = null;
    public static final String FROM_PHOTO_LIST = "FROM_PHOTO_LIST";
    public static final String FROM_QZONE_PHOTO_LIST = "FROM_QZONE_PHOTO_LIST";
    public static final String FROM_WHERE_KEY = "FROM_WHERE";
    public static final int MAX_RECENT_PHOTO_NUM = -1;
    public static final String NEED_NEW_PHOTO_COMMON_DATA = "NEED_NEW_PHOTO_COMMON_DATA";
    public static final String TAG = "QQAlbum";
    private static volatile int holdLogicNumber;
    private static volatile PhotoCommonBaseData instance;
    public String albumId;
    public String albumName;
    public HashMap<String, LocalMediaInfo> allMediaInfoHashMap;
    public String customSendBtnText;
    public MediaFileFilter filter;
    public ICursor.FilterListener filterListener;
    public LocalMediaInfo firstRecentInfo;
    public LocalMediaInfo firstVideoInfo;
    public boolean isShowQzoneAlbum;
    public boolean isSingleMode;
    MediaQueryHelper mMediaQueryHelper;
    private O mOtherCommonData;
    public int maxSelectNum;
    public ArrayList<String> mediaPathsList;
    public int recentCount;
    public int recentCountLimit;
    public ArrayList<Integer> selectedIndex;
    public HashMap<String, LocalMediaInfo> selectedMediaInfoHashMap;
    public ArrayList<String> selectedPhotoList;
    public int showMediaType;
    public int videoCount;

    /* loaded from: classes10.dex */
    public class MyFilterListener implements ICursor.FilterListener {
        static IPatchRedirector $redirector_;

        public MyFilterListener() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhotoCommonBaseData.this);
            }
        }

        public boolean filterMedia(LocalMediaInfo localMediaInfo) {
            int i3;
            int i16;
            int i17;
            int i18;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) localMediaInfo)).booleanValue();
            }
            int i19 = localMediaInfo.mMediaType;
            if (i19 == 0) {
                MediaFileFilter mediaFileFilter = PhotoCommonBaseData.this.filter;
                int i26 = mediaFileFilter.imageMinHeight;
                if (i26 > 0 && (i18 = localMediaInfo.mediaHeight) > 0 && i18 < i26) {
                    return true;
                }
                int i27 = mediaFileFilter.imageMinWidth;
                if (i27 > 0 && (i17 = localMediaInfo.mediaWidth) > 0 && i17 < i27) {
                    return true;
                }
                int i28 = mediaFileFilter.imageMaxHeight;
                if (i28 > 0 && localMediaInfo.mediaHeight > i28) {
                    return true;
                }
                int i29 = mediaFileFilter.imageMaxWidth;
                if (i29 > 0 && localMediaInfo.mediaWidth > i29) {
                    return true;
                }
                long j3 = mediaFileFilter.imageMinSize;
                if (j3 > 0 && localMediaInfo.fileSize < j3) {
                    return true;
                }
                return false;
            }
            if (i19 == 1) {
                MediaFileFilter mediaFileFilter2 = PhotoCommonBaseData.this.filter;
                int i36 = mediaFileFilter2.videoMinHeight;
                if (i36 > 0 && (i16 = localMediaInfo.mediaHeight) > 0 && i16 < i36) {
                    return true;
                }
                int i37 = mediaFileFilter2.videoMinWidth;
                if (i37 > 0 && (i3 = localMediaInfo.mediaWidth) > 0 && i3 < i37) {
                    return true;
                }
                int i38 = mediaFileFilter2.videoMaxHeight;
                if (i38 > 0 && localMediaInfo.mediaHeight > i38) {
                    return true;
                }
                int i39 = mediaFileFilter2.videoMaxWidth;
                if (i39 > 0 && localMediaInfo.mediaWidth > i39) {
                    return true;
                }
                long j16 = mediaFileFilter2.videoMaxDuration;
                if (j16 > 0 && localMediaInfo.mDuration > j16) {
                    return true;
                }
                long j17 = mediaFileFilter2.videoSizeLimit;
                if (j17 > 0 && localMediaInfo.fileSize > j17) {
                    return true;
                }
                return false;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.activity.photo.album.querymedia.ICursor.FilterListener
        public boolean needMediaInfo(LocalMediaInfo localMediaInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) localMediaInfo)).booleanValue();
            }
            if (localMediaInfo == null) {
                return false;
            }
            MediaFileFilter mediaFileFilter = PhotoCommonBaseData.this.filter;
            if (mediaFileFilter != null) {
                ArrayList<String> arrayList = mediaFileFilter.blockPaths;
                if (arrayList != null && !arrayList.isEmpty()) {
                    Iterator<String> it = PhotoCommonBaseData.this.filter.blockPaths.iterator();
                    while (it.hasNext()) {
                        if (localMediaInfo.path.contains(it.next())) {
                            return false;
                        }
                    }
                }
                if (PhotoCommonBaseData.this.filter.filter(localMediaInfo.mMimeType) || filterMedia(localMediaInfo)) {
                    return false;
                }
                return true;
            }
            return true;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13174);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            holdLogicNumber = 0;
        }
    }

    PhotoCommonBaseData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.selectedPhotoList = new ArrayList<>();
        this.selectedMediaInfoHashMap = new HashMap<>();
        this.selectedIndex = new ArrayList<>();
        this.mediaPathsList = new ArrayList<>();
        this.allMediaInfoHashMap = new HashMap<>();
        this.recentCountLimit = -1;
        this.recentCount = -1;
        this.videoCount = -1;
        this.mOtherCommonData = null;
        this.isShowQzoneAlbum = false;
        this.maxSelectNum = 1;
        this.customSendBtnText = null;
        this.isSingleMode = false;
    }

    public static PhotoCommonBaseData getInstance() {
        return getInstance(false);
    }

    public void addHoldNember() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            synchronized (this) {
                holdLogicNumber++;
            }
        }
    }

    protected O bindCommonData(Class<O> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (O) iPatchRedirector.redirect((short) 4, (Object) this, (Object) cls);
        }
        if (this.mOtherCommonData == null) {
            synchronized (OtherCommonData.class) {
                if (this.mOtherCommonData == null) {
                    try {
                        try {
                            this.mOtherCommonData = cls.newInstance();
                        } catch (InstantiationException e16) {
                            e16.printStackTrace();
                        }
                    } catch (IllegalAccessException e17) {
                        e17.printStackTrace();
                    }
                }
            }
        }
        return this.mOtherCommonData;
    }

    public synchronized void closeMediaQueryHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        MediaQueryHelper mediaQueryHelper = this.mMediaQueryHelper;
        if (mediaQueryHelper != null) {
            mediaQueryHelper.close();
            this.mMediaQueryHelper = null;
        }
    }

    public boolean containNetImage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        Iterator<String> it = this.selectedPhotoList.iterator();
        while (it.hasNext()) {
            if (QAlbumUtil.isNetUrl(it.next())) {
                return true;
            }
        }
        return false;
    }

    public void createFilterListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else if (this.filterListener == null) {
            this.filterListener = new MyFilterListener();
        }
    }

    public synchronized MediaQueryHelper createMediaQueryHelper(Context context) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (MediaQueryHelper) iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
        }
        MediaQueryHelper mediaQueryHelper = this.mMediaQueryHelper;
        if (mediaQueryHelper != null) {
            mediaQueryHelper.close();
        }
        MediaFileFilter mediaFileFilter = this.filter;
        if (mediaFileFilter != null) {
            z16 = mediaFileFilter.showImage();
            z17 = this.filter.showVideo();
        } else {
            z16 = true;
            z17 = true;
        }
        createFilterListener();
        MediaQueryHelper.Builder listener = new MediaQueryHelper.Builder().setAlbumId(this.albumId).setEachCount(50).needImage(z16).needVideo(z17).setListener(this.filterListener);
        if (this.recentCountLimit > 0 && QAlbumCustomAlbumConstants.RECENT_ALBUM_ID.equals(this.albumId)) {
            listener.setLimit(this.recentCountLimit);
        }
        MediaQueryHelper build = listener.build(context);
        this.mMediaQueryHelper = build;
        return build;
    }

    public synchronized MediaQueryHelper getMediaQueryHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (MediaQueryHelper) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.mMediaQueryHelper;
    }

    public void releaseCommonData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        synchronized (this) {
            holdLogicNumber--;
            if (holdLogicNumber == 0) {
                MediaQueryHelper mediaQueryHelper = this.mMediaQueryHelper;
                if (mediaQueryHelper != null) {
                    mediaQueryHelper.close();
                }
                instance = null;
                this.mOtherCommonData = null;
            }
        }
    }

    public static <O extends OtherCommonData> PhotoCommonBaseData<O> getInstance(boolean z16) {
        if (z16) {
            instance = new PhotoCommonBaseData();
            return instance;
        }
        if (instance == null) {
            synchronized (PhotoCommonBaseData.class) {
                if (instance == null) {
                    instance = new PhotoCommonBaseData();
                }
            }
        }
        return instance;
    }

    public O bindCommonData(O o16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (O) iPatchRedirector.redirect((short) 5, (Object) this, (Object) o16);
        }
        if (this.mOtherCommonData == null) {
            synchronized (OtherCommonData.class) {
                if (this.mOtherCommonData == null) {
                    this.mOtherCommonData = o16;
                }
            }
        }
        return this.mOtherCommonData;
    }
}
