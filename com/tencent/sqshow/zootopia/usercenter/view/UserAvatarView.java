package com.tencent.sqshow.zootopia.usercenter.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.imageview.CircleBoarderImageView;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001+B'\b\u0007\u0012\u0006\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010'\u001a\u00020\n\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\b\u0010\b\u001a\u00020\u0003H\u0014J\b\u0010\t\u001a\u00020\u0003H\u0014J,\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010\"\u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006,"}, d2 = {"Lcom/tencent/sqshow/zootopia/usercenter/view/UserAvatarView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/avatar/listener/DecodeTaskCompletionListener;", "", "e", "", "uin", "setUin", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "", "remainingTasks", "type", "Landroid/graphics/Bitmap;", "avatar", "onDecodeTaskCompleted", "Lcom/tencent/mobileqq/widget/imageview/CircleBoarderImageView;", "d", "Lcom/tencent/mobileqq/widget/imageview/CircleBoarderImageView;", "mAvatarIgv", "Ljava/lang/String;", "mUin", "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "f", "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "mFaceDecoder", "Lcom/tencent/mobileqq/app/BusinessObserver;", h.F, "Lcom/tencent/mobileqq/app/BusinessObserver;", "cardObserver", "Lmqq/app/AppRuntime;", "kotlin.jvm.PlatformType", "i", "Lmqq/app/AppRuntime;", "app", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class UserAvatarView extends FrameLayout implements DecodeTaskCompletionListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final CircleBoarderImageView mAvatarIgv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String mUin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private IFaceDecoder mFaceDecoder;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final BusinessObserver cardObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final AppRuntime app;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UserAvatarView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(UserAvatarView this$0, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mAvatarIgv.setImageBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        IFaceDecoder iFaceDecoder = this.mFaceDecoder;
        if (iFaceDecoder == null) {
            return;
        }
        Bitmap bitmapFromCache = iFaceDecoder.getBitmapFromCache(1, this.mUin);
        if (bitmapFromCache != null) {
            this.mAvatarIgv.setImageBitmap(bitmapFromCache);
        } else {
            iFaceDecoder.requestDecodeFace(this.mUin, 1, true);
            this.mAvatarIgv.setImageResource(R.drawable.ik6);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        AppRuntime appRuntime = this.app;
        if ((appRuntime instanceof AppInterface ? (AppInterface) appRuntime : null) != null) {
            ((AppInterface) appRuntime).addObserver(this.cardObserver);
        }
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int remainingTasks, int type, String uin, final Bitmap avatar) {
        QLog.i("UserAvatarView_", 1, "onDecodeTaskCompleted uin" + uin + ", avatar:" + avatar);
        if (!Intrinsics.areEqual(this.mUin, uin) || avatar == null) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.usercenter.view.a
            @Override // java.lang.Runnable
            public final void run() {
                UserAvatarView.d(UserAvatarView.this, avatar);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AppRuntime appRuntime = this.app;
        if ((appRuntime instanceof AppInterface ? (AppInterface) appRuntime : null) != null) {
            ((AppInterface) appRuntime).removeObserver(this.cardObserver);
        }
    }

    public final void setUin(String uin) {
        boolean z16 = true;
        QLog.i("UserAvatarView_", 1, "setUin uin" + uin);
        if (uin != null && uin.length() != 0) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        this.mUin = uin;
        e();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UserAvatarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ UserAvatarView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserAvatarView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        CircleBoarderImageView circleBoarderImageView = new CircleBoarderImageView(context);
        this.mAvatarIgv = circleBoarderImageView;
        this.mUin = "";
        this.cardObserver = ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).createCardBusinessObserver(new Function3<Boolean, String, Integer, Unit>() { // from class: com.tencent.sqshow.zootopia.usercenter.view.UserAvatarView$cardObserver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str, Integer num) {
                invoke(bool.booleanValue(), str, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, String str, int i16) {
                String str2;
                QLog.d("UserAvatarView_", 1, "update Avatar " + z16 + " ,uin= " + str + " , res = " + i16);
                if (z16) {
                    str2 = UserAvatarView.this.mUin;
                    if (Intrinsics.areEqual(str, str2)) {
                        UserAvatarView.this.e();
                    }
                }
            }
        });
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        this.app = peekAppRuntime;
        addView(circleBoarderImageView, new FrameLayout.LayoutParams(-1, -1));
        try {
            QLog.e("UserAvatarView_", 1, "UserAvatarView init app:" + peekAppRuntime);
            if ((peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null) != null) {
                IFaceDecoder iQQAvatarService = ((IQQAvatarService) peekAppRuntime.getRuntimeService(IQQAvatarService.class, "")).getInstance((AppInterface) peekAppRuntime);
                this.mFaceDecoder = iQQAvatarService;
                if (iQQAvatarService != null) {
                    iQQAvatarService.setDecodeTaskCompletionListener(this);
                }
            }
        } catch (Exception e16) {
            QLog.e("UserAvatarView_", 1, "UserAvatarView init avatarFaceDecoder throw:" + e16);
        }
        QLog.i("UserAvatarView_", 1, "UserAvatarView init, mFaceDecoder=" + this.mFaceDecoder);
    }
}
