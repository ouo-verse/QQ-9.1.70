package com.tencent.mobileqq.aio.msglist.holder.component.tofu.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.ah;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.TofuContent;
import java.net.URL;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 $2\u00020\u0001:\u0001%B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\"\u0010#J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0014J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0014J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0014R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b \u0010\u001e\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/b;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/i;", "", "background", "", UserInfo.SEX_FEMALE, "", "I", "G", "Lcom/tencent/mobileqq/aio/msg/ah;", "message", "H", BdhLogUtil.LogTag.Tag_Conn, "Landroid/content/Context;", "context", DomainData.DOMAIN_NAME, "E", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/CornerImageView;", "N", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/CornerImageView;", "mIvCover", "P", "mIvMask", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mIvCompleteMask", "Landroid/graphics/drawable/ColorDrawable;", BdhLogUtil.LogTag.Tag_Req, "Landroid/graphics/drawable/ColorDrawable;", "mBgLoadingDrawable", ExifInterface.LATITUDE_SOUTH, "Ljava/lang/String;", "mMaskStartColor", "T", "mMaskEndColor", "<init>", "(Landroid/content/Context;)V", "U", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b extends i {
    static IPatchRedirector $redirector_;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private CornerImageView mIvCover;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private CornerImageView mIvMask;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private CornerImageView mIvCompleteMask;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private ColorDrawable mBgLoadingDrawable;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final String mMaskStartColor;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final String mMaskEndColor;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.b$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63751);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mMaskStartColor = "#80000000";
        this.mMaskEndColor = "#00000000";
        C();
    }

    private final void F(String background) {
        if (!TextUtils.isEmpty(background) && !I(background)) {
            G(background);
        }
    }

    private final void G(String background) {
        if (!TextUtils.isEmpty(background)) {
            try {
                int parseColor = Color.parseColor(background);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(parseColor);
                gradientDrawable.setCornerRadius(j());
                k().setBackgroundDrawable(gradientDrawable);
            } catch (Exception e16) {
                QLog.d("ImageBeancurdView", 1, "updateBackgroundIfNeed err: ", e16);
            }
        }
    }

    private final void H(ah message) {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor(this.mMaskStartColor), Color.parseColor(this.mMaskEndColor)});
        gradientDrawable.setCornerRadii(new float[]{j(), j(), j(), j(), 0.0f, 0.0f, 0.0f, 0.0f});
        CornerImageView cornerImageView = this.mIvMask;
        if (cornerImageView != null) {
            cornerImageView.setBackgroundDrawable(gradientDrawable);
        }
        CornerImageView cornerImageView2 = this.mIvMask;
        if (cornerImageView2 != null) {
            cornerImageView2.setVisibility(0);
        }
        List<TofuContent> o26 = message.o2();
        if (o26 != null && !o26.isEmpty()) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(e().getColor(R.color.qui_common_overlay_dark));
            gradientDrawable2.setCornerRadius(j());
            CornerImageView cornerImageView3 = this.mIvCompleteMask;
            if (cornerImageView3 != null) {
                cornerImageView3.setBackgroundDrawable(gradientDrawable2);
            }
            CornerImageView cornerImageView4 = this.mIvCompleteMask;
            if (cornerImageView4 != null) {
                cornerImageView4.setVisibility(0);
            }
        }
    }

    private final boolean I(String background) {
        boolean endsWith$default;
        if (!URLUtil.isHttpsUrl(background) && !URLUtil.isHttpUrl(background)) {
            if (QLog.isColorLevel()) {
                QLog.i("ImageBeancurdView", 2, "background is not web url : " + background);
            }
            return false;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable colorDrawable = this.mBgLoadingDrawable;
        obtain.mLoadingDrawable = colorDrawable;
        obtain.mFailedDrawable = colorDrawable;
        String path = new URL(background).getPath();
        Intrinsics.checkNotNullExpressionValue(path, "URL(background).path");
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(path, ".png", false, 2, null);
        if (endsWith$default) {
            obtain.mUseApngImage = true;
        }
        URLDrawable drawable = URLDrawable.getDrawable(background, obtain);
        CornerImageView cornerImageView = this.mIvCover;
        if (cornerImageView != null) {
            cornerImageView.setImageDrawable(drawable);
        }
        CornerImageView cornerImageView2 = this.mIvCover;
        if (cornerImageView2 != null) {
            cornerImageView2.setRadius(j());
        }
        CornerImageView cornerImageView3 = this.mIvCover;
        if (cornerImageView3 != null) {
            cornerImageView3.setVisibility(0);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.i
    public void C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.C();
        View findViewById = k().findViewById(R.id.duw);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.CornerImageView");
        this.mIvCover = (CornerImageView) findViewById;
        View findViewById2 = k().findViewById(R.id.dwd);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.CornerImageView");
        this.mIvMask = (CornerImageView) findViewById2;
        View findViewById3 = k().findViewById(R.id.y5m);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.CornerImageView");
        this.mIvCompleteMask = (CornerImageView) findViewById3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.i
    public void E(@NotNull ah message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) message);
            return;
        }
        Intrinsics.checkNotNullParameter(message, "message");
        super.E(message);
        H(message);
        F(message.j2());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.i, com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a
    public void n(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.n(context);
        r(context.getResources().getColor(R.color.qui_common_text_allwhite_primary));
        s(context.getResources().getColor(R.color.qui_common_text_allwhite_primary));
        this.mBgLoadingDrawable = new ColorDrawable(context.getResources().getColor(R.color.qui_common_bubble_guest));
    }
}
