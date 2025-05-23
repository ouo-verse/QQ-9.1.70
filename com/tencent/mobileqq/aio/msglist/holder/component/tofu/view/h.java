package com.tencent.mobileqq.aio.msglist.holder.component.tofu.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.ah;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOTofuApi;
import com.tencent.state.data.SquareJSConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J \u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0012\u0010\u0013\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J$\u0010\u0018\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0010\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0016H\u0004R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/h;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/a;", "", "backgroundUrl", "", "E", BdhLogUtil.LogTag.Tag_Conn, "", "D", "Landroid/view/View;", "headLayout", "headFrd", "headMine", "G", "Lcom/tencent/mobileqq/aio/msg/ah;", "message", "B", "Landroid/content/Context;", "context", "l", "Lcom/tencent/common/app/AppInterface;", "app", "", SquareJSConst.Params.PARAMS_UIN_LIST, UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", "mTvTitle", "J", "mTvContent", "Landroid/widget/FrameLayout;", "K", "Landroid/widget/FrameLayout;", "mHeadLayout", "Landroid/widget/ImageView;", "L", "Landroid/widget/ImageView;", "mHeadFrd", "M", "mHeadMine", "<init>", "(Landroid/content/Context;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class h extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView mTvTitle;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView mTvContent;

    /* renamed from: K, reason: from kotlin metadata */
    private FrameLayout mHeadLayout;

    /* renamed from: L, reason: from kotlin metadata */
    private ImageView mHeadFrd;

    /* renamed from: M, reason: from kotlin metadata */
    private ImageView mHeadMine;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            C();
        }
    }

    private final void C() {
        View findViewById = k().findViewById(R.id.kbs);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.mTvTitle = (TextView) findViewById;
        View findViewById2 = k().findViewById(R.id.f10623686);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.mTvContent = (TextView) findViewById2;
        View findViewById3 = k().findViewById(R.id.head_layout);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.FrameLayout");
        this.mHeadLayout = (FrameLayout) findViewById3;
        View findViewById4 = k().findViewById(R.id.x7x);
        Intrinsics.checkNotNull(findViewById4, "null cannot be cast to non-null type android.widget.ImageView");
        this.mHeadFrd = (ImageView) findViewById4;
        View findViewById5 = k().findViewById(R.id.x7z);
        Intrinsics.checkNotNull(findViewById5, "null cannot be cast to non-null type android.widget.ImageView");
        this.mHeadMine = (ImageView) findViewById5;
    }

    private final boolean D() {
        ImageView imageView = null;
        if (h().n2() == 20) {
            ImageView imageView2 = this.mHeadMine;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHeadMine");
                imageView2 = null;
            }
            imageView2.setVisibility(4);
            ImageView imageView3 = this.mHeadFrd;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHeadFrd");
            } else {
                imageView = imageView3;
            }
            imageView.setVisibility(4);
            QLog.i("SystemNoticeBeancurdView", 1, "vas level hide head");
            return true;
        }
        ImageView imageView4 = this.mHeadMine;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHeadMine");
            imageView4 = null;
        }
        imageView4.setVisibility(0);
        ImageView imageView5 = this.mHeadFrd;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHeadFrd");
        } else {
            imageView = imageView5;
        }
        imageView.setVisibility(0);
        QLog.i("SystemNoticeBeancurdView", 1, "show head");
        return false;
    }

    private final void E(String backgroundUrl) {
        k().setBackground(((IAIOTofuApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOTofuApi.class)).getApngDrawable(backgroundUrl));
    }

    private final void G(View headLayout, View headFrd, View headMine) {
        boolean z16;
        float f16;
        float f17;
        if (headFrd.getVisibility() == com.tencent.aio.view_dsl.dsl.b.o() && headMine.getVisibility() == com.tencent.aio.view_dsl.dsl.b.o()) {
            z16 = true;
        } else {
            z16 = false;
        }
        ViewGroup.LayoutParams layoutParams = headLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (z16) {
            f16 = 20.0f;
        } else {
            f16 = 39.0f;
        }
        marginLayoutParams.rightMargin = ViewUtils.dpToPx(f16);
        ImageView imageView = this.mHeadMine;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHeadMine");
            imageView = null;
        }
        ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
        if (z16) {
            f17 = 38.0f;
        } else {
            f17 = 0.0f;
        }
        marginLayoutParams2.leftMargin = ViewUtils.dpToPx(f17);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a
    @NotNull
    public View B(@NotNull ah message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
        }
        Intrinsics.checkNotNullParameter(message, "message");
        TextView textView = null;
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        t(message);
        TextView textView2 = this.mTvTitle;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvTitle");
            textView2 = null;
        }
        A(textView2, message.p2());
        TextView textView3 = this.mTvContent;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvContent");
        } else {
            textView = textView3;
        }
        y(textView, message.o2());
        Intrinsics.checkNotNull(waitAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.business.BaseQQAppInterface");
        F((BaseQQAppInterface) waitAppRuntime, message.v2());
        String j26 = h().j2();
        if (j26 != null) {
            E(j26);
        }
        return d();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void F(@Nullable AppInterface app, @Nullable List<String> uinList) {
        ImageView imageView;
        ImageView imageView2;
        FrameLayout frameLayout;
        ImageView imageView3;
        ImageView imageView4;
        ImageView imageView5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) app, (Object) uinList);
            return;
        }
        if (!D() && app != null && uinList != null && !uinList.isEmpty()) {
            String currentAccountUin = app.getCurrentAccountUin();
            ImageView imageView6 = null;
            if (TextUtils.equals(currentAccountUin, uinList.get(0))) {
                imageView = this.mHeadMine;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHeadMine");
                    imageView = null;
                }
                z(app, imageView, uinList.get(0));
                if (uinList.size() <= 1) {
                    if (TextUtils.equals(currentAccountUin, uinList.get(1))) {
                        imageView5 = this.mHeadMine;
                        if (imageView5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mHeadMine");
                            imageView5 = null;
                        }
                        z(app, imageView5, uinList.get(1));
                    } else {
                        imageView5 = this.mHeadFrd;
                        if (imageView5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mHeadFrd");
                            imageView5 = null;
                        }
                        z(app, imageView5, uinList.get(1));
                    }
                } else if (TextUtils.equals(currentAccountUin, uinList.get(0))) {
                    imageView2 = this.mHeadFrd;
                    if (imageView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mHeadFrd");
                        imageView2 = null;
                    }
                    imageView2.setVisibility(8);
                } else {
                    imageView2 = this.mHeadMine;
                    if (imageView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mHeadMine");
                        imageView2 = null;
                    }
                    imageView2.setVisibility(8);
                }
                frameLayout = this.mHeadLayout;
                if (frameLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHeadLayout");
                    frameLayout = null;
                }
                imageView3 = this.mHeadFrd;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHeadFrd");
                    imageView3 = null;
                }
                imageView4 = this.mHeadMine;
                if (imageView4 != null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHeadMine");
                } else {
                    imageView6 = imageView4;
                }
                G(frameLayout, imageView3, imageView6);
            }
            imageView = this.mHeadFrd;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHeadFrd");
                imageView = null;
            }
            z(app, imageView, uinList.get(0));
            if (uinList.size() <= 1) {
            }
            frameLayout = this.mHeadLayout;
            if (frameLayout == null) {
            }
            imageView3 = this.mHeadFrd;
            if (imageView3 == null) {
            }
            imageView4 = this.mHeadMine;
            if (imageView4 != null) {
            }
            G(frameLayout, imageView3, imageView6);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a
    @NotNull
    public View l(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        }
        View inflate = View.inflate(context, R.layout.fq6, null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026stem_notice_layout, null)");
        return inflate;
    }
}
