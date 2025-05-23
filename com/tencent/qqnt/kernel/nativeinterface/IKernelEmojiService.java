package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelEmojiService {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelEmojiService {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        CppProxy(long j3) {
            if (j3 != 0) {
                this.nativeRef = j3;
                return;
            }
            throw new RuntimeException("nativeRef is zero");
        }

        private native void nativeDestroy(long j3);

        private native void native_checkImage(long j3, ArrayList<PicMaterial> arrayList, ICheckImageCallback iCheckImageCallback);

        private native void native_getAIGCEmojiList(long j3, GetAIGCEmojiListReq getAIGCEmojiListReq, boolean z16, IGetAIGCEmojiListCallback iGetAIGCEmojiListCallback);

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelEmojiService
        public void checkImage(ArrayList<PicMaterial> arrayList, ICheckImageCallback iCheckImageCallback) {
            native_checkImage(this.nativeRef, arrayList, iCheckImageCallback);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelEmojiService
        public void getAIGCEmojiList(GetAIGCEmojiListReq getAIGCEmojiListReq, boolean z16, IGetAIGCEmojiListCallback iGetAIGCEmojiListCallback) {
            native_getAIGCEmojiList(this.nativeRef, getAIGCEmojiListReq, z16, iGetAIGCEmojiListCallback);
        }
    }

    void checkImage(ArrayList<PicMaterial> arrayList, ICheckImageCallback iCheckImageCallback);

    void getAIGCEmojiList(GetAIGCEmojiListReq getAIGCEmojiListReq, boolean z16, IGetAIGCEmojiListCallback iGetAIGCEmojiListCallback);
}
