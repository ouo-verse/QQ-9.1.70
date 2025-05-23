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
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOTofuApi;
import com.tencent.qqnt.aio.api.INTZPlanAvatarView;
import com.tencent.qqnt.kernel.nativeinterface.TofuContent;
import com.tencent.widget.RoundRectImageView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 72\u00020\u00012\u00020\u0002:\u0001\u0016B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\t\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0006\u0010\u0012\u001a\u00020\u0003J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010+\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00101\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010$R\u0016\u00104\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010\u001c\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/l;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/a;", "Lcom/tencent/qqnt/aio/api/d;", "", "E", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/mobileqq/aio/msg/ah;", "message", UserInfo.SEX_FEMALE, "G", "", "D", "Landroid/content/Context;", "context", "Landroid/view/View;", "l", "B", BdhLogUtil.LogTag.Tag_Conn, "", "success", "onLoad", "a", NodeProps.ON_CLICK, "Landroidx/constraintlayout/widget/ConstraintLayout;", "I", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mTofuWithZPlanAvatarContainer", "J", "mTofuContainer", "Lcom/tencent/widget/RoundRectImageView;", "K", "Lcom/tencent/widget/RoundRectImageView;", "mTofuBgcView", "Landroid/widget/ImageView;", "L", "Landroid/widget/ImageView;", "mAvatarHeadView", "Landroid/widget/TextView;", "M", "Landroid/widget/TextView;", "mTip", "N", "mContent", "Lcom/tencent/qqnt/aio/api/INTZPlanAvatarView;", "P", "Lcom/tencent/qqnt/aio/api/INTZPlanAvatarView;", "mZPlanAvatarView", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mAvatarDefImgView", "", BdhLogUtil.LogTag.Tag_Req, "mUin", "<init>", "(Landroid/content/Context;)V", ExifInterface.LATITUDE_SOUTH, "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class l extends a implements com.tencent.qqnt.aio.api.d {
    static IPatchRedirector $redirector_;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private ConstraintLayout mTofuWithZPlanAvatarContainer;

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
    private TextView mTip;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private TextView mContent;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private INTZPlanAvatarView mZPlanAvatarView;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private ImageView mAvatarDefImgView;

    /* renamed from: R, reason: from kotlin metadata */
    private long mUin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/l$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.l$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63813);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(@NotNull Context context) {
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

    private final int D() {
        if (QQTheme.isNowThemeIsNight()) {
            return R.drawable.f160095j62;
        }
        return R.drawable.f160094j61;
    }

    private final void E() {
        if (!((IAIOTofuApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOTofuApi.class)).isHitZPlanAvatarExperiment()) {
            k().setVisibility(8);
            return;
        }
        View findViewById = k().findViewById(R.id.f99295pe);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        this.mTofuWithZPlanAvatarContainer = (ConstraintLayout) findViewById;
        View findViewById2 = k().findViewById(R.id.f99265pb);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        this.mTofuContainer = (ConstraintLayout) findViewById2;
        View findViewById3 = k().findViewById(R.id.f99255pa);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type com.tencent.widget.RoundRectImageView");
        this.mTofuBgcView = (RoundRectImageView) findViewById3;
        View findViewById4 = k().findViewById(R.id.f164551a35);
        Intrinsics.checkNotNull(findViewById4, "null cannot be cast to non-null type android.widget.ImageView");
        this.mAvatarHeadView = (ImageView) findViewById4;
        View findViewById5 = k().findViewById(R.id.jm8);
        Intrinsics.checkNotNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
        this.mTip = (TextView) findViewById5;
        View findViewById6 = k().findViewById(R.id.content);
        Intrinsics.checkNotNull(findViewById6, "null cannot be cast to non-null type android.widget.TextView");
        this.mContent = (TextView) findViewById6;
        View findViewById7 = k().findViewById(R.id.t1_);
        Intrinsics.checkNotNull(findViewById7, "null cannot be cast to non-null type android.widget.ImageView");
        this.mAvatarDefImgView = (ImageView) findViewById7;
    }

    private final void F(AppRuntime app, ah message) {
        TofuContent tofuContent;
        String str;
        TofuContent tofuContent2;
        TextView textView = this.mTip;
        String str2 = null;
        if (textView != null) {
            List<TofuContent> o26 = message.o2();
            if (o26 != null && (tofuContent2 = o26.get(0)) != null) {
                str = tofuContent2.title;
            } else {
                str = null;
            }
            textView.setText(str);
        }
        TextView textView2 = this.mContent;
        if (textView2 != null) {
            List<TofuContent> o27 = message.o2();
            if (o27 != null && (tofuContent = o27.get(1)) != null) {
                str2 = tofuContent.title;
            }
            textView2.setText(str2);
        }
        String l26 = message.l2();
        if (l26 == null) {
            return;
        }
        G(message);
        if (this.mZPlanAvatarView == null) {
            this.mZPlanAvatarView = ((IAIOTofuApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOTofuApi.class)).updateZPlanAvatarView(l26, this.mTofuWithZPlanAvatarContainer, this);
        }
        if (app != null) {
            z((BaseQQAppInterface) app, this.mAvatarHeadView, String.valueOf(message.getMsgRecord().peerUin));
        }
    }

    private final void G(ah message) {
        String b16;
        b16 = m.b(message, QQTheme.isNowThemeIsNight());
        if (TextUtils.isEmpty(b16)) {
            QLog.d("ZPlanAvatarBeancurdView", 1, "updateTofuBackground, getBackground is empty, set default bg");
            RoundRectImageView roundRectImageView = this.mTofuBgcView;
            if (roundRectImageView != null) {
                roundRectImageView.setImageDrawable(e().getDrawable(D()));
                return;
            }
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = e().getDrawable(D());
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        try {
            RoundRectImageView roundRectImageView2 = this.mTofuBgcView;
            if (roundRectImageView2 != null) {
                roundRectImageView2.setImageDrawable(URLDrawable.getDrawable(b16, obtain));
            }
        } catch (Exception e16) {
            QLog.e("ZPlanAvatarBeancurdView", 1, "onlineStatus.bgcPath:" + b16 + " parse exception:", e16);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a
    @NotNull
    public View B(@NotNull ah message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) message);
        }
        Intrinsics.checkNotNullParameter(message, "message");
        t(message);
        this.mUin = h().getMsgRecord().peerUin;
        QLog.d("ZPlanAvatarBeancurdView", 1, VasPerfReportUtils.WHILE_UPDATE_ITEM);
        F(MobileQQ.sMobileQQ.peekAppRuntime(), message);
        View k3 = k();
        Intrinsics.checkNotNull(k3);
        return k3;
    }

    public final void C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        INTZPlanAvatarView iNTZPlanAvatarView = this.mZPlanAvatarView;
        if (iNTZPlanAvatarView != null) {
            Intrinsics.checkNotNull(iNTZPlanAvatarView);
            iNTZPlanAvatarView.a();
            ConstraintLayout constraintLayout = this.mTofuWithZPlanAvatarContainer;
            if (constraintLayout != null) {
                constraintLayout.removeView(this.mZPlanAvatarView);
            }
            this.mZPlanAvatarView = null;
        }
        ImageView imageView = this.mAvatarDefImgView;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    @Override // com.tencent.qqnt.aio.api.d
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a
    @NotNull
    public View l(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        View inflate = View.inflate(context, R.layout.fq8, null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026plan_avatar_layout, null)");
        return inflate;
    }

    @Override // com.tencent.qqnt.aio.api.d
    public void onClick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.api.d
    public void onLoad(boolean success) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, success);
            return;
        }
        ImageView imageView = this.mAvatarDefImgView;
        if (imageView != null) {
            if (success) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            imageView.setVisibility(i3);
        }
    }
}
