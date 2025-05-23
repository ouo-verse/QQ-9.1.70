package com.tencent.mobileqq.selectfriend.part.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.BaseImageUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004B\u000f\u0012\u0006\u0010!\u001a\u00020 \u00a2\u0006\u0004\b\"\u0010#J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J(\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J$\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH$J\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0004J\u0006\u0010\u0012\u001a\u00020\u000fR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u000b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/part/adapter/FacePreloadBaseAdapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Lcom/tencent/mobileqq/selectfriend/adapter/a;", "Lcom/tencent/mobileqq/avatar/listener/DecodeTaskCompletionListener;", "", "uin", "", "type", "", "sourceType", "Landroid/graphics/Bitmap;", "getFaceBitmap", "remainingTasks", "avatar", "", "onDecodeTaskCompleted", "updateChildViewHead", "destroy", "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "mFaceDecoder", "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "getMFaceDecoder", "()Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "setMFaceDecoder", "(Lcom/tencent/mobileqq/app/face/IFaceDecoder;)V", "", "mIsInPreloadStage", "Z", "getDefaultFace", "()Landroid/graphics/Bitmap;", "defaultFace", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "<init>", "(Lcom/tencent/mobileqq/app/QQAppInterface;)V", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public abstract class FacePreloadBaseAdapter<VH extends RecyclerView.ViewHolder> extends com.tencent.mobileqq.selectfriend.adapter.a<VH> implements DecodeTaskCompletionListener {
    private IFaceDecoder mFaceDecoder;
    private boolean mIsInPreloadStage;

    public FacePreloadBaseAdapter(QQAppInterface app) {
        Intrinsics.checkNotNullParameter(app, "app");
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) app.getRuntimeService(IQQAvatarService.class, "")).getInstance(app);
        this.mFaceDecoder = iQQAvatarService;
        Intrinsics.checkNotNull(iQQAvatarService);
        iQQAvatarService.setDecodeTaskCompletionListener(this);
    }

    private final Bitmap getDefaultFace() {
        Bitmap defaultFaceBitmap = BaseImageUtil.getDefaultFaceBitmap();
        Intrinsics.checkNotNullExpressionValue(defaultFaceBitmap, "getDefaultFaceBitmap()");
        return defaultFaceBitmap;
    }

    public final void destroy() {
        IFaceDecoder iFaceDecoder = this.mFaceDecoder;
        if (iFaceDecoder != null) {
            Intrinsics.checkNotNull(iFaceDecoder);
            iFaceDecoder.destory();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Bitmap getFaceBitmap(int type, String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (AppConstants.SEC_MSG_UIN.equals(uin)) {
            try {
                return BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), R.drawable.f162141ft4);
            } catch (OutOfMemoryError unused) {
                return null;
            }
        }
        return getFaceBitmap(uin, type, (byte) 0);
    }

    protected final IFaceDecoder getMFaceDecoder() {
        return this.mFaceDecoder;
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int remainingTasks, int type, String uin, Bitmap avatar) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        if (this.mIsInPreloadStage) {
            if (remainingTasks == 0) {
                this.mIsInPreloadStage = false;
            }
        } else {
            IFaceDecoder iFaceDecoder = this.mFaceDecoder;
            Intrinsics.checkNotNull(iFaceDecoder);
            if (iFaceDecoder.isPausing()) {
                return;
            }
            updateChildViewHead(type, uin, avatar);
        }
    }

    protected final void setMFaceDecoder(IFaceDecoder iFaceDecoder) {
        this.mFaceDecoder = iFaceDecoder;
    }

    protected abstract void updateChildViewHead(int type, String uin, Bitmap avatar);

    private final Bitmap getFaceBitmap(String uin, int type, byte sourceType) {
        IFaceDecoder iFaceDecoder = this.mFaceDecoder;
        Intrinsics.checkNotNull(iFaceDecoder);
        Bitmap bitmapFromCache = iFaceDecoder.getBitmapFromCache(type, uin);
        if (bitmapFromCache != null) {
            return bitmapFromCache;
        }
        if (this.mIsInPreloadStage) {
            IFaceDecoder iFaceDecoder2 = this.mFaceDecoder;
            Intrinsics.checkNotNull(iFaceDecoder2);
            iFaceDecoder2.cancelPendingRequests();
            this.mIsInPreloadStage = false;
        }
        IFaceDecoder iFaceDecoder3 = this.mFaceDecoder;
        Intrinsics.checkNotNull(iFaceDecoder3);
        if (!iFaceDecoder3.isPausing()) {
            IFaceDecoder iFaceDecoder4 = this.mFaceDecoder;
            Intrinsics.checkNotNull(iFaceDecoder4);
            iFaceDecoder4.requestDecodeFace(uin, type, true, sourceType);
        }
        return getDefaultFace();
    }
}
