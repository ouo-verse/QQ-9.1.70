package com.tencent.mobileqq.vas.social.config;

import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.state.square.api.IDecodeTaskCompletionListener;
import com.tencent.state.square.api.IFaceDecoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0016J(\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\tH\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/vas/social/config/g;", "Lcom/tencent/state/square/api/IFaceDecoder;", "Lcom/tencent/mobileqq/avatar/listener/DecodeTaskCompletionListener;", "", "destroy", "", "uin", "", "isTroop", "Landroid/graphics/Bitmap;", "getBitmapFromCache", "requestDecodeFace", "Lcom/tencent/state/square/api/IDecodeTaskCompletionListener;", "listener", "setDecodeTaskCompletionListener", "", "remainingTasks", "type", "avatar", "onDecodeTaskCompleted", "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "d", "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "decoder", "e", "Lcom/tencent/state/square/api/IDecodeTaskCompletionListener;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class g implements IFaceDecoder, DecodeTaskCompletionListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.app.face.IFaceDecoder decoder;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private IDecodeTaskCompletionListener listener;

    public g() {
        IQQAvatarService iQQAvatarService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        com.tencent.mobileqq.app.face.IFaceDecoder iFaceDecoder = null;
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface != null && (iQQAvatarService = (IQQAvatarService) appInterface.getRuntimeService(IQQAvatarService.class, "")) != null) {
            iFaceDecoder = iQQAvatarService.getInstance(appInterface);
        }
        this.decoder = iFaceDecoder;
        if (iFaceDecoder != null) {
            iFaceDecoder.setDecodeTaskCompletionListener(this);
        }
    }

    @Override // com.tencent.state.square.api.IFaceDecoder
    public void destroy() {
        com.tencent.mobileqq.app.face.IFaceDecoder iFaceDecoder = this.decoder;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
        }
        this.decoder = null;
    }

    @Override // com.tencent.state.square.api.IFaceDecoder
    public Bitmap getBitmapFromCache(String uin, boolean isTroop) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        int i3 = isTroop ? 4 : 1;
        com.tencent.mobileqq.app.face.IFaceDecoder iFaceDecoder = this.decoder;
        if (iFaceDecoder != null) {
            return iFaceDecoder.getBitmapFromCache(i3, uin);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int remainingTasks, int type, String uin, Bitmap avatar) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        IDecodeTaskCompletionListener iDecodeTaskCompletionListener = this.listener;
        if (iDecodeTaskCompletionListener != null) {
            iDecodeTaskCompletionListener.onDecodeTaskCompleted(remainingTasks, type, uin, avatar);
        }
    }

    @Override // com.tencent.state.square.api.IFaceDecoder
    public boolean requestDecodeFace(String uin, boolean isTroop) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        int i3 = isTroop ? 4 : 1;
        com.tencent.mobileqq.app.face.IFaceDecoder iFaceDecoder = this.decoder;
        if (iFaceDecoder != null) {
            return iFaceDecoder.requestDecodeFace(uin, i3, true);
        }
        return false;
    }

    @Override // com.tencent.state.square.api.IFaceDecoder
    public void setDecodeTaskCompletionListener(IDecodeTaskCompletionListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }
}
