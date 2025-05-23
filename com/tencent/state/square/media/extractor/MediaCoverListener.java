package com.tencent.state.square.media.extractor;

import android.graphics.Bitmap;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0003H&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/state/square/media/extractor/MediaCoverListener;", "", "getCoverDone", "", "cover", "Landroid/graphics/Bitmap;", "onComposeDone", "onComposeStart", "onError", "code", "", "msg", "", "onExtractDone", "onGetFrameDone", "onGetFrameStart", "onInitDone", "onStart", "square_media_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public interface MediaCoverListener {
    void getCoverDone(Bitmap cover);

    void onComposeDone();

    void onComposeStart();

    void onError(int code, String msg2);

    void onExtractDone();

    void onGetFrameDone();

    void onGetFrameStart();

    void onInitDone();

    void onStart();
}
