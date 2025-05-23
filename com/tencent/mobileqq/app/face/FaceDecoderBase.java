package com.tencent.mobileqq.app.face;

import AvatarInfo.QQHeadInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.util.AvatarOptimiseConfigUtil;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.HeadRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes11.dex */
public abstract class FaceDecoderBase {
    static IPatchRedirector $redirector_ = null;
    static final int LENGTH_LIMIT = 5;
    static final String TAG = "FaceDecoderBase";
    static final long TIMEOUT_REQDECODE = 300000;
    protected int iRunningRequests;
    DecodeTaskCompletionListener mDecodeTaskCompletionListener;
    Hashtable<String, FaceInfo> mInProgress;
    boolean mPause;
    LinkedList<FaceInfo> mReadyRequests;
    Hashtable<String, FaceInfo> mRefreshMap;
    boolean mStatDecodeTime;
    boolean mUserJustTouchDown;
    int maxDecodingTask;

    public FaceDecoderBase() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.maxDecodingTask = 10;
        this.mInProgress = new Hashtable<>();
        this.mRefreshMap = new Hashtable<>();
        this.mReadyRequests = new LinkedList<>();
        this.iRunningRequests = 0;
        this.mDecodeTaskCompletionListener = null;
        this.mPause = false;
        this.mUserJustTouchDown = false;
        this.mStatDecodeTime = false;
    }

    public void cancelPendingRequests() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.mInProgress.clear();
            this.mReadyRequests.clear();
        }
    }

    public void destory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        cancelPendingRequests();
        this.iRunningRequests = 0;
        this.mDecodeTaskCompletionListener = null;
        this.mPause = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void enqueueDecode(FaceInfo faceInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) faceInfo);
            return;
        }
        if (faceInfo == null) {
            return;
        }
        try {
            this.mReadyRequests.remove(faceInfo);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "enqueueDecode", e16);
            }
        }
        if (faceInfo.appendToTail) {
            this.mReadyRequests.addLast(faceInfo);
        } else {
            this.mReadyRequests.addFirst(faceInfo);
        }
        faceInfo.markTime(FaceInfo.TIME_REQ_READY);
        if (this.iRunningRequests < this.maxDecodingTask && !this.mPause) {
            runNextTask();
        }
    }

    public abstract Bitmap getBitmapFromCache(int i3, String str, int i16, byte b16, int i17);

    public abstract Drawable getFaceDrawableByBitmap(Bitmap bitmap);

    public boolean isPausing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.mPause;
    }

    public boolean ismUserJustTouchDown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.mUserJustTouchDown;
    }

    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.mPause = true;
        }
    }

    public abstract boolean preloadFacesWithFaceInfo(ArrayList<HeadRequest> arrayList);

    public abstract void refreshFaceWithTimeStamp(int i3, String str, int i16, long j3, int i17);

    public final boolean requestDecodeFace(String str, int i3, boolean z16, int i16, boolean z17, byte b16, int i17) {
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16), Boolean.valueOf(z17), Byte.valueOf(b16), Integer.valueOf(i17))).booleanValue();
        }
        if (AvatarOptimiseConfigUtil.b()) {
            i18 = 140;
        } else {
            i18 = 100;
        }
        return requestDecodeFace(str, i3, z16, i16, z17, b16, i17, i18, false);
    }

    public abstract boolean requestDecodeFace(String str, int i3, boolean z16, int i16, boolean z17, byte b16, int i17, int i18, boolean z18);

    public abstract boolean requestDecodeFaceWithFaceInfo(String str, int i3, boolean z16, int i16, boolean z17, byte b16, int i17, QQHeadInfo qQHeadInfo);

    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.mPause = false;
        while (this.iRunningRequests < this.maxDecodingTask && !this.mReadyRequests.isEmpty()) {
            runNextTask();
        }
    }

    protected abstract void runNextTask();

    public abstract void setAppRuntime(AppInterface appInterface);

    public void setDecodeTaskCompletionListener(DecodeTaskCompletionListener decodeTaskCompletionListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) decodeTaskCompletionListener);
        } else {
            this.mDecodeTaskCompletionListener = decodeTaskCompletionListener;
        }
    }

    public void setStatDecodeTime(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.mStatDecodeTime = z16;
        }
    }

    public void setUserTouchDown(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.mUserJustTouchDown = z16;
        }
    }
}
