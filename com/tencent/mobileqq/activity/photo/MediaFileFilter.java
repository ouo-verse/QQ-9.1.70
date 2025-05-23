package com.tencent.mobileqq.activity.photo;

import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MediaFileFilter implements Cloneable {
    static IPatchRedirector $redirector_ = null;
    public static final MediaFileFilter MEDIA_FILTER_DEFAULT;
    public static final MediaFileFilter MEDIA_FILTER_DEFAULT_AND_HEIF;
    public static final SparseArray<MediaFileFilter> MEDIA_FILTER_MAP;
    public static final MediaFileFilter MEDIA_FILTER_NO_GIF;
    public static final MediaFileFilter MEDIA_FILTER_NO_GIF_AND_HEIF;
    public static final MediaFileFilter MEDIA_FILTER_SHOW_IMAGE;
    public static final MediaFileFilter MEDIA_FILTER_SHOW_IMAGE_AND_HEIF;
    public static final MediaFileFilter MEDIA_FILTER_SHOW_IMAGE_NO_GIF;
    public static final MediaFileFilter MEDIA_FILTER_SHOW_VIDEO;
    public static final int MF_DEFAULT = 0;
    public static final int MF_DEFAULT_AND_HEIF = 5;
    public static final int MF_NO_GIF = 3;
    public static final int MF_NO_GIF_AND_HEIF = 7;
    public static final int MF_SHOW_IMAGE = 1;
    public static final int MF_SHOW_IMAGE_AND_HEIF = 6;
    public static final int MF_SHOW_IMAGE_NO_GIF = 4;
    public static final int MF_SHOW_VIDEO = 2;
    public static final int MIN_SIZE = 1000;
    public ArrayList<String> blockPaths;
    public int imageMaxHeight;
    public int imageMaxWidth;
    public int imageMinHeight;
    public long imageMinSize;
    public int imageMinWidth;
    public boolean needGif;
    public boolean needHeif;
    public boolean needImage;
    public boolean needVideo;
    public boolean needWebp;
    public long videoMaxDuration;
    public int videoMaxHeight;
    public int videoMaxWidth;
    public int videoMinHeight;
    public int videoMinWidth;
    public long videoSizeLimit;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12917);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        MediaFileFilter createDefaultAndHeifFilter = createDefaultAndHeifFilter();
        MEDIA_FILTER_DEFAULT_AND_HEIF = createDefaultAndHeifFilter;
        MediaFileFilter createDefaultFilter = createDefaultFilter();
        MEDIA_FILTER_DEFAULT = createDefaultFilter;
        MediaFileFilter createImageAndHeifFilter = createImageAndHeifFilter();
        MEDIA_FILTER_SHOW_IMAGE_AND_HEIF = createImageAndHeifFilter;
        MediaFileFilter createImageFilter = createImageFilter();
        MEDIA_FILTER_SHOW_IMAGE = createImageFilter;
        MediaFileFilter createVideoFilter = createVideoFilter();
        MEDIA_FILTER_SHOW_VIDEO = createVideoFilter;
        MediaFileFilter createNoGifFilter = createNoGifFilter();
        MEDIA_FILTER_NO_GIF = createNoGifFilter;
        MediaFileFilter createNoGifAndHeifFilter = createNoGifAndHeifFilter();
        MEDIA_FILTER_NO_GIF_AND_HEIF = createNoGifAndHeifFilter;
        MediaFileFilter createNoGifAndImageFilter = createNoGifAndImageFilter();
        MEDIA_FILTER_SHOW_IMAGE_NO_GIF = createNoGifAndImageFilter;
        SparseArray<MediaFileFilter> sparseArray = new SparseArray<>();
        MEDIA_FILTER_MAP = sparseArray;
        sparseArray.put(0, createDefaultFilter);
        sparseArray.put(1, createImageFilter);
        sparseArray.put(2, createVideoFilter);
        sparseArray.put(3, createNoGifFilter);
        sparseArray.put(4, createNoGifAndImageFilter);
        sparseArray.put(5, createDefaultAndHeifFilter);
        sparseArray.put(6, createImageAndHeifFilter);
        sparseArray.put(7, createNoGifAndHeifFilter);
    }

    public MediaFileFilter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.imageMinWidth = -1;
        this.imageMinHeight = -1;
        this.imageMaxWidth = -1;
        this.imageMaxHeight = -1;
        this.videoMinWidth = -1;
        this.videoMinHeight = -1;
        this.videoMaxWidth = -1;
        this.videoMaxHeight = -1;
        this.imageMinSize = 1000L;
        this.videoMaxDuration = -1L;
        this.videoSizeLimit = -1L;
        this.needImage = true;
        this.needWebp = false;
        this.needHeif = false;
        this.needGif = true;
        this.needVideo = true;
    }

    private static MediaFileFilter createDefaultAndHeifFilter() {
        MediaFileFilter mediaFileFilter = new MediaFileFilter();
        mediaFileFilter.needHeif = true;
        return mediaFileFilter;
    }

    private static MediaFileFilter createDefaultFilter() {
        return new MediaFileFilter();
    }

    private static MediaFileFilter createImageAndHeifFilter() {
        MediaFileFilter mediaFileFilter = new MediaFileFilter();
        mediaFileFilter.needHeif = true;
        mediaFileFilter.needVideo = false;
        return mediaFileFilter;
    }

    private static MediaFileFilter createImageFilter() {
        MediaFileFilter mediaFileFilter = new MediaFileFilter();
        mediaFileFilter.needVideo = false;
        return mediaFileFilter;
    }

    private static MediaFileFilter createNoGifAndHeifFilter() {
        MediaFileFilter mediaFileFilter = new MediaFileFilter();
        mediaFileFilter.needGif = false;
        mediaFileFilter.needHeif = true;
        return mediaFileFilter;
    }

    private static MediaFileFilter createNoGifAndImageFilter() {
        MediaFileFilter mediaFileFilter = new MediaFileFilter();
        mediaFileFilter.needGif = false;
        mediaFileFilter.needVideo = false;
        return mediaFileFilter;
    }

    private static MediaFileFilter createNoGifFilter() {
        MediaFileFilter mediaFileFilter = new MediaFileFilter();
        mediaFileFilter.needGif = false;
        return mediaFileFilter;
    }

    private static MediaFileFilter createVideoFilter() {
        MediaFileFilter mediaFileFilter = new MediaFileFilter();
        mediaFileFilter.needImage = false;
        return mediaFileFilter;
    }

    public static MediaFileFilter getFilter(int i3) {
        MediaFileFilter mediaFileFilter = MEDIA_FILTER_MAP.get(i3);
        if (mediaFileFilter != null) {
            try {
                return (MediaFileFilter) mediaFileFilter.clone();
            } catch (CloneNotSupportedException e16) {
                e16.printStackTrace();
                return mediaFileFilter;
            }
        }
        return new MediaFileFilter();
    }

    public boolean filter(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        String[] mimeType = MimeHelper.getMimeType(str);
        if (mimeType != null) {
            if ("image".equals(mimeType[0])) {
                if (!this.needImage) {
                    return true;
                }
                if (!this.needGif && MimeHelper.validateImageType(mimeType[1]) && mimeType[1].equals("gif")) {
                    return true;
                }
                if (!this.needWebp && "image/webp".equals(str)) {
                    return true;
                }
                if (!this.needHeif && (MimeHelper.IMAGE_HEIF.equals(str) || MimeHelper.IMAGE_HEIC.equals(str))) {
                    return true;
                }
            } else if (!"video".equals(mimeType[0]) || !MimeHelper.validateVideoType(str) || !this.needVideo) {
                return true;
            }
        }
        return false;
    }

    public boolean showImage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.needImage;
    }

    public boolean showVideo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.needVideo;
    }
}
