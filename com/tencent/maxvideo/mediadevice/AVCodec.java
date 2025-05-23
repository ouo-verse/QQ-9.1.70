package com.tencent.maxvideo.mediadevice;

import com.tencent.maxvideo.common.AVIOStruct;
import com.tencent.maxvideo.common.CommonThread;
import com.tencent.maxvideo.common.MessageStruct;
import com.tencent.maxvideo.watermark.WatermarkInfo;
import com.tencent.maxvideo.watermark.WatermarkRecordInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class AVCodec {
    static IPatchRedirector $redirector_ = null;
    private static final int MSG_PARAM_PROCESS_FRAME_WITH_CALLBACK = 16;
    private static final int MSG_PARAM_PROCESS_ONE_FRAME = 8;
    private static AVCodec instance;
    public String TAG;
    private List<AVCodecCallback> mCallbackList;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface AVCodecCallback {
        void onAVCodecEvent(AVCodecCallback aVCodecCallback, MessageStruct messageStruct);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9987);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            instance = new AVCodec();
            CommonThread.post(new Runnable() { // from class: com.tencent.maxvideo.mediadevice.AVCodec.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        try {
                            AVCodec.getCallbackMethods();
                        } catch (UnsatisfiedLinkError unused) {
                        }
                    }
                }
            });
        }
    }

    AVCodec() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.TAG = getClass().getSimpleName();
            this.mCallbackList = new ArrayList();
        }
    }

    private int callFunction(MessageStruct messageStruct) {
        function(messageStruct);
        return 1;
    }

    public static AVCodec get() {
        return instance;
    }

    public static native void getCallbackMethods();

    private void notifyAllCallback(MessageStruct messageStruct) {
        int size;
        AVCodecCallback[] aVCodecCallbackArr;
        int i3;
        synchronized (this) {
            size = this.mCallbackList.size();
            aVCodecCallbackArr = new AVCodecCallback[size];
            for (int i16 = 0; i16 < size; i16++) {
                aVCodecCallbackArr[i16] = this.mCallbackList.get(i16);
            }
        }
        for (i3 = 0; i3 < size; i3++) {
            AVCodecCallback aVCodecCallback = aVCodecCallbackArr[i3];
            aVCodecCallback.onAVCodecEvent(aVCodecCallback, messageStruct);
        }
    }

    public synchronized boolean addCodecCallback(AVCodecCallback aVCodecCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVCodecCallback)).booleanValue();
        }
        if (!this.mCallbackList.contains(aVCodecCallback)) {
            this.mCallbackList.add(aVCodecCallback);
            return true;
        }
        return false;
    }

    public synchronized void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        List<AVCodecCallback> list = this.mCallbackList;
        if (list == null) {
            return;
        }
        list.clear();
    }

    public int copyBuf(byte[] bArr, AVIOStruct aVIOStruct) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this, (Object) bArr, (Object) aVIOStruct)).intValue();
        }
        MessageStruct messageStruct = new MessageStruct(MessageStruct.MSG_RECORD_COPY_BUF);
        messageStruct.mObj0 = bArr;
        messageStruct.mObj1 = aVIOStruct;
        return callFunction(messageStruct);
    }

    public int copyQQBuf(byte[] bArr, AVIOStruct aVIOStruct) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this, (Object) bArr, (Object) aVIOStruct)).intValue();
        }
        MessageStruct messageStruct = new MessageStruct(MessageStruct.MSG_RECORD_COPY_QQ_BUF);
        messageStruct.mObj0 = bArr;
        messageStruct.mObj1 = aVIOStruct;
        return callFunction(messageStruct);
    }

    public int deleteDraft() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
        }
        return callFunction(new MessageStruct(MessageStruct.MSG_RECORD_DISCARD_DRAFT));
    }

    public int encode(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this, (Object) str)).intValue();
        }
        MessageStruct messageStruct = new MessageStruct(MessageStruct.MSG_ENCODE_CMD);
        messageStruct.mObj0 = str;
        return callFunction(messageStruct);
    }

    public int encodeCancel(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this, (Object) str)).intValue();
        }
        MessageStruct messageStruct = new MessageStruct(MessageStruct.MSG_ENCODE_CANCEL);
        messageStruct.mObj0 = str;
        return callFunction(messageStruct);
    }

    public native int function(MessageStruct messageStruct);

    public int getWatermarkFrame(WatermarkInfo watermarkInfo, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Integer) iPatchRedirector.redirect((short) 27, (Object) this, (Object) watermarkInfo, i3)).intValue();
        }
        if (watermarkInfo == null) {
            return -1;
        }
        MessageStruct messageStruct = new MessageStruct(MessageStruct.MSG_MATERIAL_GET_MATERIAL_FRAME);
        messageStruct.mObj0 = watermarkInfo.mDir;
        messageStruct.mParam0 = i3;
        return callFunction(messageStruct);
    }

    public int handleAudio(byte[] bArr, AVIOStruct aVIOStruct, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, this, bArr, aVIOStruct, Integer.valueOf(i3))).intValue();
        }
        MessageStruct messageStruct = new MessageStruct(MessageStruct.MSG_RECORD_CAPTURE_AUDIO);
        messageStruct.mObj0 = bArr;
        messageStruct.mObj1 = aVIOStruct;
        messageStruct.mParam0 = i3;
        return callFunction(messageStruct);
    }

    public int handleQQVideo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return callFunction(new MessageStruct(MessageStruct.MSG_RECORD_CAPTURE_QQ_VIDEO));
    }

    public int handleQQVideoFrameWithCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        MessageStruct messageStruct = new MessageStruct(MessageStruct.MSG_RECORD_CAPTURE_QQ_VIDEO);
        messageStruct.mParam0 = 16;
        return callFunction(messageStruct);
    }

    public int handleQQVideoOneFrame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        MessageStruct messageStruct = new MessageStruct(MessageStruct.MSG_RECORD_CAPTURE_QQ_VIDEO);
        messageStruct.mParam0 = 8;
        return callFunction(messageStruct);
    }

    public int handleVideo(byte[] bArr, AVIOStruct aVIOStruct) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this, (Object) bArr, (Object) aVIOStruct)).intValue();
        }
        MessageStruct messageStruct = new MessageStruct(MessageStruct.MSG_RECORD_CAPTURE_VIDEO);
        messageStruct.mObj0 = bArr;
        messageStruct.mObj1 = aVIOStruct;
        return callFunction(messageStruct);
    }

    public int init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return callFunction(new MessageStruct(33554433));
    }

    public int onNativieCallback(MessageStruct messageStruct) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) messageStruct)).intValue();
        }
        notifyAllCallback(messageStruct);
        return 0;
    }

    public int recordEnd(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str)).intValue();
        }
        MessageStruct messageStruct = new MessageStruct(MessageStruct.MSG_RECORD_END);
        messageStruct.mObj0 = str;
        return callFunction(messageStruct);
    }

    public int recordSubmit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return callFunction(new MessageStruct(MessageStruct.MSG_RECORD_SUBMIT));
    }

    public void recycle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            clear();
        }
    }

    public synchronized boolean removeCodecCallback(AVCodecCallback aVCodecCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVCodecCallback)).booleanValue();
        }
        List<AVCodecCallback> list = this.mCallbackList;
        if (list == null) {
            return false;
        }
        return list.remove(aVCodecCallback);
    }

    public int removeLastCapture() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return callFunction(new MessageStruct(MessageStruct.MSG_RECORD_DEL_LAST_SEGMENT));
    }

    public int retake() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        return callFunction(new MessageStruct(MessageStruct.MSG_RECORD_RESET));
    }

    public int saveDraft() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
        }
        return callFunction(new MessageStruct(MessageStruct.MSG_RECORD_SAVE_DRAFT));
    }

    public int startCapture() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return callFunction(new MessageStruct(MessageStruct.MSG_RECORD_SEGMENT_START));
    }

    public int stopCapture() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return callFunction(new MessageStruct(MessageStruct.MSG_RECORD_SEGMENT_END));
    }

    public int updateWatermarkList(List<WatermarkRecordInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Integer) iPatchRedirector.redirect((short) 28, (Object) this, (Object) list)).intValue();
        }
        if (list != null && !list.isEmpty()) {
            MessageStruct messageStruct = new MessageStruct(MessageStruct.MSG_MATERIAL_UPDATE);
            messageStruct.mObj0 = WatermarkRecordInfo.getJson(list);
            return callFunction(messageStruct);
        }
        return -1;
    }
}
