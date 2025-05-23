package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelAvatarService {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelAvatarService {
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

        private native long native_addAvatarListener(long j3, IKernelAvatarListener iKernelAvatarListener);

        private native void native_forceDownloadAvatar(long j3, String str, AvatarSize avatarSize, IOperateCallback iOperateCallback);

        private native void native_forceDownloadAvatarByUin(long j3, long j16, AvatarSize avatarSize, IOperateCallback iOperateCallback);

        private native void native_forceDownloadGroupAvatar(long j3, long j16, AvatarSize avatarSize, IOperateCallback iOperateCallback);

        private native void native_forceDownloadGroupPortrait(long j3, long j16, int i3, AvatarSize avatarSize, IOperateCallback iOperateCallback);

        private native String native_getAvatarPath(long j3, String str, AvatarSize avatarSize);

        private native String native_getAvatarPathByUin(long j3, long j16, AvatarSize avatarSize);

        private native HashMap<String, String> native_getAvatarPaths(long j3, ArrayList<String> arrayList, AvatarSize avatarSize);

        private native String native_getConfGroupAvatarPath(long j3, long j16);

        private native HashMap<Long, String> native_getConfGroupAvatarPaths(long j3, ArrayList<Long> arrayList);

        private native String native_getGroupAvatarPath(long j3, long j16, AvatarSize avatarSize);

        private native HashMap<Long, String> native_getGroupAvatarPaths(long j3, ArrayList<Long> arrayList, AvatarSize avatarSize);

        private native String native_getGroupPortraitPath(long j3, long j16, int i3, AvatarSize avatarSize);

        private native void native_removeAvatarListener(long j3, long j16);

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAvatarService
        public long addAvatarListener(IKernelAvatarListener iKernelAvatarListener) {
            return native_addAvatarListener(this.nativeRef, iKernelAvatarListener);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAvatarService
        public void forceDownloadAvatar(String str, AvatarSize avatarSize, IOperateCallback iOperateCallback) {
            native_forceDownloadAvatar(this.nativeRef, str, avatarSize, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAvatarService
        public void forceDownloadAvatarByUin(long j3, AvatarSize avatarSize, IOperateCallback iOperateCallback) {
            native_forceDownloadAvatarByUin(this.nativeRef, j3, avatarSize, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAvatarService
        public void forceDownloadGroupAvatar(long j3, AvatarSize avatarSize, IOperateCallback iOperateCallback) {
            native_forceDownloadGroupAvatar(this.nativeRef, j3, avatarSize, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAvatarService
        public void forceDownloadGroupPortrait(long j3, int i3, AvatarSize avatarSize, IOperateCallback iOperateCallback) {
            native_forceDownloadGroupPortrait(this.nativeRef, j3, i3, avatarSize, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAvatarService
        public String getAvatarPath(String str, AvatarSize avatarSize) {
            return native_getAvatarPath(this.nativeRef, str, avatarSize);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAvatarService
        public String getAvatarPathByUin(long j3, AvatarSize avatarSize) {
            return native_getAvatarPathByUin(this.nativeRef, j3, avatarSize);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAvatarService
        public HashMap<String, String> getAvatarPaths(ArrayList<String> arrayList, AvatarSize avatarSize) {
            return native_getAvatarPaths(this.nativeRef, arrayList, avatarSize);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAvatarService
        public String getConfGroupAvatarPath(long j3) {
            return native_getConfGroupAvatarPath(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAvatarService
        public HashMap<Long, String> getConfGroupAvatarPaths(ArrayList<Long> arrayList) {
            return native_getConfGroupAvatarPaths(this.nativeRef, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAvatarService
        public String getGroupAvatarPath(long j3, AvatarSize avatarSize) {
            return native_getGroupAvatarPath(this.nativeRef, j3, avatarSize);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAvatarService
        public HashMap<Long, String> getGroupAvatarPaths(ArrayList<Long> arrayList, AvatarSize avatarSize) {
            return native_getGroupAvatarPaths(this.nativeRef, arrayList, avatarSize);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAvatarService
        public String getGroupPortraitPath(long j3, int i3, AvatarSize avatarSize) {
            return native_getGroupPortraitPath(this.nativeRef, j3, i3, avatarSize);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelAvatarService
        public void removeAvatarListener(long j3) {
            native_removeAvatarListener(this.nativeRef, j3);
        }
    }

    long addAvatarListener(IKernelAvatarListener iKernelAvatarListener);

    void forceDownloadAvatar(String str, AvatarSize avatarSize, IOperateCallback iOperateCallback);

    void forceDownloadAvatarByUin(long j3, AvatarSize avatarSize, IOperateCallback iOperateCallback);

    void forceDownloadGroupAvatar(long j3, AvatarSize avatarSize, IOperateCallback iOperateCallback);

    void forceDownloadGroupPortrait(long j3, int i3, AvatarSize avatarSize, IOperateCallback iOperateCallback);

    String getAvatarPath(String str, AvatarSize avatarSize);

    String getAvatarPathByUin(long j3, AvatarSize avatarSize);

    HashMap<String, String> getAvatarPaths(ArrayList<String> arrayList, AvatarSize avatarSize);

    String getConfGroupAvatarPath(long j3);

    HashMap<Long, String> getConfGroupAvatarPaths(ArrayList<Long> arrayList);

    String getGroupAvatarPath(long j3, AvatarSize avatarSize);

    HashMap<Long, String> getGroupAvatarPaths(ArrayList<Long> arrayList, AvatarSize avatarSize);

    String getGroupPortraitPath(long j3, int i3, AvatarSize avatarSize);

    void removeAvatarListener(long j3);
}
