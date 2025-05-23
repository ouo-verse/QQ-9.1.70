package com.tencent.mobileqq.aio.msglist.holder.component.tofu.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.ah;
import com.tencent.mobileqq.aio.msglist.holder.component.tofu.util.ToFuUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IAIOTofuApi;
import com.tencent.widget.RoundRectImageView;
import java.net.MalformedURLException;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 >2\u00020\u00012\u00020\u0002:\u0001\u001aB\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b<\u0010=J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\t\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\u0006\u0010\u0016\u001a\u00020\u0003J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010.\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010+R\u0018\u00101\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00103\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010'R\u0018\u00106\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u00108\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010'R\u0016\u0010;\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010\u001f\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/g;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/a;", "Lcom/tencent/qqnt/aio/api/d;", "", "E", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/mobileqq/aio/msg/ah;", "message", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/aio/k;", "onlineStatus", "H", "G", "D", "Landroid/content/Context;", "context", "Landroid/view/View;", "l", "B", "v", NodeProps.ON_CLICK, BdhLogUtil.LogTag.Tag_Conn, "", "success", "onLoad", "a", "Landroidx/constraintlayout/widget/ConstraintLayout;", "I", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mTofuWithQQShowContainer", "J", "mTofuContainer", "Lcom/tencent/widget/RoundRectImageView;", "K", "Lcom/tencent/widget/RoundRectImageView;", "mTofuBgcView", "Landroid/widget/ImageView;", "L", "Landroid/widget/ImageView;", "mAvatarHeadView", "Landroid/widget/TextView;", "M", "Landroid/widget/TextView;", "mStatusTip", "N", "mStatus", "P", "Landroid/view/View;", "mAvatarStatusView", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mAvatarStatusDefImgView", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/qqnt/aio/k;", "mCurOnlineStatus", ExifInterface.LATITUDE_SOUTH, "mLikeView", "", "T", "mUin", "<init>", "(Landroid/content/Context;)V", "U", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class g extends a implements com.tencent.qqnt.aio.api.d {
    static IPatchRedirector $redirector_;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private ConstraintLayout mTofuWithQQShowContainer;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private ConstraintLayout mTofuContainer;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private RoundRectImageView mTofuBgcView;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private ImageView mAvatarHeadView;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private TextView mStatusTip;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private TextView mStatus;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private View mAvatarStatusView;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private ImageView mAvatarStatusDefImgView;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.aio.k mCurOnlineStatus;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private ImageView mLikeView;

    /* renamed from: T, reason: from kotlin metadata */
    private long mUin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/g$a;", "", "", "CORNER_RADIUS_DP", UserInfo.SEX_FEMALE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.g$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63773);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NotNull Context context) {
        super(context, true);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        E();
        k().setOnClickListener(this);
        p(k());
    }

    private final void D() {
        if (i() == null) {
            QLog.e("OnlineStatusBeancurdView", 1, "not set mOnClickBeancurdListener");
        } else {
            i().a(h());
        }
    }

    private final void E() {
        ImageView imageView;
        View findViewById = k().findViewById(R.id.f99285pd);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        this.mTofuWithQQShowContainer = (ConstraintLayout) findViewById;
        View findViewById2 = k().findViewById(R.id.f99265pb);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        this.mTofuContainer = (ConstraintLayout) findViewById2;
        View findViewById3 = k().findViewById(R.id.f99255pa);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type com.tencent.widget.RoundRectImageView");
        this.mTofuBgcView = (RoundRectImageView) findViewById3;
        View findViewById4 = k().findViewById(R.id.f164551a35);
        Intrinsics.checkNotNull(findViewById4, "null cannot be cast to non-null type android.widget.ImageView");
        this.mAvatarHeadView = (ImageView) findViewById4;
        View findViewById5 = k().findViewById(R.id.f88304wp);
        Intrinsics.checkNotNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
        this.mStatusTip = (TextView) findViewById5;
        View findViewById6 = k().findViewById(R.id.j1x);
        Intrinsics.checkNotNull(findViewById6, "null cannot be cast to non-null type android.widget.TextView");
        this.mStatus = (TextView) findViewById6;
        View findViewById7 = k().findViewById(R.id.t1v);
        Intrinsics.checkNotNull(findViewById7, "null cannot be cast to non-null type android.widget.ImageView");
        this.mAvatarStatusDefImgView = (ImageView) findViewById7;
        View findViewById8 = k().findViewById(R.id.bjn);
        if (findViewById8 instanceof ImageView) {
            imageView = (ImageView) findViewById8;
        } else {
            imageView = null;
        }
        this.mLikeView = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
    }

    private final void F(AppRuntime app, ah message) {
        if (app == null) {
            QLog.d("OnlineStatusBeancurdView", 1, "updateContent but app is null, return");
            return;
        }
        G();
        z((BaseQQAppInterface) app, this.mAvatarHeadView, String.valueOf(message.getMsgRecord().peerUin));
        H(this.mCurOnlineStatus);
        this.mAvatarStatusView = ((IAIOTofuApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOTofuApi.class)).updateAvatarStatusView(message, this.mAvatarStatusView, this.mCurOnlineStatus, this.mTofuWithQQShowContainer, this);
    }

    private final void G() {
        TextView textView;
        String str;
        com.tencent.qqnt.aio.k kVar = this.mCurOnlineStatus;
        if (kVar != null && (textView = this.mStatus) != null) {
            if (kVar == null || (str = kVar.c()) == null) {
                str = "";
            }
            textView.setText(str);
        }
    }

    private final void H(com.tencent.qqnt.aio.k onlineStatus) {
        if (onlineStatus == null) {
            QLog.d("OnlineStatusBeancurdView", 1, "updateTofuSpecialBackground, onlineStatus is null, return");
            return;
        }
        if (TextUtils.isEmpty(onlineStatus.b())) {
            QLog.d("OnlineStatusBeancurdView", 1, "updateTofuSpecialBackground, onlineStatus.bgcPath is empty, set default bg");
            RoundRectImageView roundRectImageView = this.mTofuBgcView;
            if (roundRectImageView != null) {
                roundRectImageView.setImageDrawable(e().getDrawable(R.drawable.n4j));
                return;
            }
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = e().getDrawable(R.drawable.n56);
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        RoundRectImageView roundRectImageView2 = this.mTofuBgcView;
        if (roundRectImageView2 != null) {
            roundRectImageView2.setCornerRadiusAndMode(ViewUtils.dpToPx(8.0f), 1);
        }
        try {
            RoundRectImageView roundRectImageView3 = this.mTofuBgcView;
            if (roundRectImageView3 != null) {
                roundRectImageView3.setImageDrawable(URLDrawable.getDrawable(new URL("file://" + onlineStatus.b()), obtain));
            }
        } catch (MalformedURLException e16) {
            QLog.e("OnlineStatusBeancurdView", 1, "onlineStatus.bgcPath:" + onlineStatus.b() + " parse exception:", e16);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0065, code lost:
    
        if (r1 != r2.intValue()) goto L20;
     */
    @Override // com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View B(@NotNull ah message) {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) message);
        }
        Intrinsics.checkNotNullParameter(message, "message");
        t(message);
        this.mUin = h().getMsgRecord().peerUin;
        com.tencent.qqnt.aio.k t26 = message.t2();
        QLog.d("OnlineStatusBeancurdView", 1, "updateView, OnlineStatus:" + t26);
        if (t26 == null) {
            return k();
        }
        if (this.mCurOnlineStatus != null) {
            int d16 = t26.d();
            com.tencent.qqnt.aio.k kVar = this.mCurOnlineStatus;
            if (kVar != null) {
                num = Integer.valueOf(kVar.d());
            } else {
                num = null;
            }
        }
        this.mCurOnlineStatus = t26;
        F(MobileQQ.sMobileQQ.peekAppRuntime(), message);
        ToFuUtil.f192136a.d(this.mUin, this.mLikeView);
        return k();
    }

    public final void C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QLog.e("OnlineStatusBeancurdView", 1, "aio destroy\u4e86,\u5c06mAvatarStatusView\u8bbe\u7f6e\u6210null");
        ConstraintLayout constraintLayout = this.mTofuWithQQShowContainer;
        if (constraintLayout != null) {
            constraintLayout.removeView(this.mAvatarStatusView);
        }
        this.mAvatarStatusView = null;
        this.mCurOnlineStatus = null;
        ImageView imageView = this.mAvatarStatusDefImgView;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    @Override // com.tencent.qqnt.aio.api.d
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        ImageView imageView = this.mAvatarStatusDefImgView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a
    @NotNull
    public View l(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        View inflate = View.inflate(context, R.layout.fqj, null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, layoutId, null)");
        return inflate;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a, android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            Intrinsics.checkNotNullParameter(v3, "v");
            if (v3.getId() == R.id.bjn) {
                ToFuUtil.f192136a.h(v3, e(), this.mUin, h());
            } else {
                super.onClick(v3);
            }
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) v3);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.qqnt.aio.api.d
    public void onLoad(boolean success) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, success);
            return;
        }
        ImageView imageView = this.mAvatarStatusDefImgView;
        if (imageView != null) {
            if (success) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            imageView.setVisibility(i3);
        }
    }

    @Override // com.tencent.qqnt.aio.api.d
    public void onClick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            D();
        } else {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }
}
