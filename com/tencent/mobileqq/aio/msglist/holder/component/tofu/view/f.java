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
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 12\u00020\u0001:\u00012B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010 R\u0018\u0010+\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010 R\u0016\u0010.\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010\u0018\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/f;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/a;", "", BdhLogUtil.LogTag.Tag_Conn, "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/mobileqq/aio/msg/ah;", "message", "D", "", "onlineStatusPath", UserInfo.SEX_FEMALE, "E", "Landroid/content/Context;", "context", "Landroid/view/View;", "l", "v", NodeProps.ON_CLICK, "B", "Landroidx/constraintlayout/widget/ConstraintLayout;", "I", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mTofuWithQQShowContainer", "J", "mTofuContainer", "Lcom/tencent/widget/RoundRectImageView;", "K", "Lcom/tencent/widget/RoundRectImageView;", "mTofuBgcView", "Landroid/widget/ImageView;", "L", "Landroid/widget/ImageView;", "mAvatarHeadView", "Landroid/widget/TextView;", "M", "Landroid/widget/TextView;", "mStatusTip", "N", "mStatus", "P", "mAvatarStatusDefImgView", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mLikeView", "", BdhLogUtil.LogTag.Tag_Req, "mUin", "<init>", "(Landroid/content/Context;)V", ExifInterface.LATITUDE_SOUTH, "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class f extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: S, reason: from kotlin metadata */
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
    private ImageView mAvatarStatusDefImgView;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private ImageView mLikeView;

    /* renamed from: R, reason: from kotlin metadata */
    private long mUin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/f$a;", "", "", "CORNER_RADIUS_DP", UserInfo.SEX_FEMALE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.f$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63769);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull Context context) {
        super(context, true);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        C();
        k().setOnClickListener(this);
        p(k());
    }

    private final void C() {
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
        Intrinsics.checkNotNull(findViewById8, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) findViewById8;
        this.mLikeView = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
    }

    private final void D(AppRuntime app, ah message) {
        if (app == null) {
            QLog.d("OnlineStatusBeancurdView", 1, "updateContent but app is null, return");
            return;
        }
        E();
        z((BaseQQAppInterface) app, this.mAvatarHeadView, String.valueOf(message.getMsgRecord().peerUin));
        F(message.j2());
    }

    private final void E() {
        ImageView imageView;
        TextView textView = this.mStatus;
        if (textView != null && (imageView = this.mAvatarStatusDefImgView) != null) {
            ((IAIOTofuApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOTofuApi.class)).setOnlineStatusTextAndIcon(this.mUin, textView, imageView);
        }
    }

    private final void F(String onlineStatusPath) {
        if (TextUtils.isEmpty(onlineStatusPath)) {
            QLog.d("OnlineStatusBeancurdView", 1, "updateTofuSpecialBackground, onlineStatus is null, return");
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = e().getDrawable(R.drawable.n56);
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        RoundRectImageView roundRectImageView = this.mTofuBgcView;
        if (roundRectImageView != null) {
            try {
                roundRectImageView.setCornerRadiusAndMode(ViewUtils.dpToPx(8.0f), 1);
                roundRectImageView.setImageDrawable(URLDrawable.getDrawable(new URL("file://" + onlineStatusPath), obtain));
            } catch (MalformedURLException e16) {
                QLog.e("OnlineStatusBeancurdView", 1, "onlineStatus.bgcPath:" + onlineStatusPath + " parse exception:", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a
    @NotNull
    public View B(@NotNull ah message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this, (Object) message);
        }
        Intrinsics.checkNotNullParameter(message, "message");
        t(message);
        this.mUin = h().getMsgRecord().peerUin;
        D(MobileQQ.sMobileQQ.peekAppRuntime(), message);
        ToFuUtil.f192136a.d(this.mUin, this.mLikeView);
        return k();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a
    @NotNull
    public View l(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        View inflate = View.inflate(context, R.layout.fqj, null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026us_beancurd_layout, null)");
        return inflate;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a, android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) v3);
        } else {
            Intrinsics.checkNotNullParameter(v3, "v");
            if (v3.getId() == R.id.bjn) {
                ToFuUtil.f192136a.h(v3, e(), this.mUin, h());
            } else {
                super.onClick(v3);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }
}
