package com.tencent.mobileqq.aio.msglist.holder.component.tofu.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.ah;
import com.tencent.mobileqq.aio.msglist.holder.component.tofu.util.ToFuUtil;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOTofuApi;
import com.tencent.qqnt.aio.api.f;
import com.tencent.qqnt.aio.api.g;
import com.tencent.qqnt.kernel.nativeinterface.TofuActionButton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J&\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fJ,\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00142\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0018\u001a\u00020\u0006J\u0006\u0010\u0019\u001a\u00020\u0016J\u0006\u0010\u001a\u001a\u00020\u0016R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001b\u0010 \u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010\"\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b!\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/util/ToFuUtil;", "", "", "uin", "Landroid/widget/ImageView;", "likeView", "", "d", "Landroid/view/View;", "v", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/aio/msg/ah;", "tofuMsgItem", h.F, "", "Lcom/tencent/qqnt/kernel/nativeinterface/TofuActionButton;", "statementData", "Ljava/util/ArrayList;", "Landroid/widget/LinearLayout;", "Lkotlin/collections/ArrayList;", "a", "", "g", "i", "c", "b", "Ljava/lang/Boolean;", "isTofuExperimentC", "Lkotlin/Lazy;", "f", "()Z", "tofuShowSwitch", "e", "tofuResetSwitch", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class ToFuUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ToFuUtil f192136a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Boolean isTofuExperimentC;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy tofuShowSwitch;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy tofuResetSwitch;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/tofu/util/ToFuUtil$a", "Lcom/tencent/qqnt/aio/api/g;", "", "isLike", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a implements g {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageView f192140a;

        a(ImageView imageView) {
            this.f192140a = imageView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) imageView);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(ImageView imageView, boolean z16) {
            if (imageView != null) {
                imageView.setSelected(z16);
            }
        }

        @Override // com.tencent.qqnt.aio.api.g
        public void a(final boolean isLike) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, isLike);
                return;
            }
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final ImageView imageView = this.f192140a;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.tofu.util.a
                @Override // java.lang.Runnable
                public final void run() {
                    ToFuUtil.a.c(imageView, isLike);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/tofu/util/ToFuUtil$b", "Lcom/tencent/qqnt/aio/api/f;", "", "isSuccess", "", "uin", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f192141a;

        b(View view) {
            this.f192141a = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(View v3) {
            Intrinsics.checkNotNullParameter(v3, "$v");
            v3.setSelected(!v3.isSelected());
        }

        @Override // com.tencent.qqnt.aio.api.f
        public void a(boolean isSuccess, long uin) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), Long.valueOf(uin));
            } else {
                if (isSuccess && uin == uin) {
                    return;
                }
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final View view = this.f192141a;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.tofu.util.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        ToFuUtil.b.c(view);
                    }
                });
            }
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63729);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        f192136a = new ToFuUtil();
        lazy = LazyKt__LazyJVMKt.lazy(ToFuUtil$tofuShowSwitch$2.INSTANCE);
        tofuShowSwitch = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(ToFuUtil$tofuResetSwitch$2.INSTANCE);
        tofuResetSwitch = lazy2;
    }

    ToFuUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean e() {
        return ((Boolean) tofuResetSwitch.getValue()).booleanValue();
    }

    private final boolean f() {
        return ((Boolean) tofuShowSwitch.getValue()).booleanValue();
    }

    @NotNull
    public final ArrayList<LinearLayout> a(@NotNull Context context, @NotNull List<TofuActionButton> statementData) {
        Drawable faceDrawable;
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) statementData);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(statementData, "statementData");
        ArrayList<LinearLayout> arrayList = new ArrayList<>();
        boolean isFontSizeLarge = FontSettingManager.isFontSizeLarge();
        for (TofuActionButton tofuActionButton : statementData) {
            int i3 = tofuActionButton.emojiType;
            int convertToLocal = QQSysFaceUtil.convertToLocal(tofuActionButton.emojiId);
            String str = tofuActionButton.text;
            if (i3 >= 0 && convertToLocal >= 0 && !TextUtils.isEmpty(str)) {
                if (i3 == 1) {
                    faceDrawable = QQSysFaceUtil.getFaceGifDrawable(convertToLocal);
                } else {
                    faceDrawable = QQSysFaceUtil.getFaceDrawable(convertToLocal);
                }
                if (faceDrawable == null) {
                    QLog.i("AIOTofuContentComponent", 1, "faceDrawable == null");
                } else {
                    ImageView imageView = new ImageView(context);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewUtils.dpToPx(28.0f), ViewUtils.dpToPx(28.0f));
                    layoutParams.gravity = 1;
                    layoutParams.topMargin = ViewUtils.dpToPx(5.5f);
                    imageView.setLayoutParams(layoutParams);
                    imageView.setImageDrawable(faceDrawable);
                    TextView textView = new TextView(context);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 1;
                    layoutParams2.topMargin = ViewUtils.dpToPx(4.0f);
                    textView.setLayoutParams(layoutParams2);
                    textView.setText(str);
                    textView.setTextColor(context.getResources().getColorStateList(R.color.qui_common_bubble_guest_text_primary, context.getTheme()));
                    if (isFontSizeLarge) {
                        f16 = 14.0f;
                    } else {
                        f16 = 12.0f;
                    }
                    textView.setTextSize(f16);
                    LinearLayout linearLayout = new LinearLayout(context);
                    linearLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewUtils.dpToPx(80.0f), ViewUtils.dpToPx(60.0f)));
                    linearLayout.setOrientation(1);
                    linearLayout.setBackgroundResource(R.drawable.qui_qq_beancurd_default_bg);
                    linearLayout.setTag(tofuActionButton);
                    linearLayout.addView(imageView);
                    linearLayout.addView(textView);
                    if (isFontSizeLarge) {
                        FontSettingManager.resetViewSize2Normal(context, linearLayout);
                    }
                    arrayList.add(linearLayout);
                }
            } else {
                QLog.i("AIOTofuContentComponent", 1, "emojiType " + i3 + " emojiId " + convertToLocal + " desc " + str);
            }
        }
        return arrayList;
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return e();
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return f();
    }

    public final void d(long uin, @Nullable ImageView likeView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(uin), likeView);
        } else {
            ((IAIOTofuApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOTofuApi.class)).getIsLike(uin, new a(likeView));
        }
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (isTofuExperimentC == null) {
            isTofuExperimentC = Boolean.valueOf(((IAIOTofuApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOTofuApi.class)).isTofuExperimentC());
        }
        Boolean bool = isTofuExperimentC;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final void h(@NotNull View v3, @NotNull Context context, long uin, @NotNull ah tofuMsgItem) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, v3, context, Long.valueOf(uin), tofuMsgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(tofuMsgItem, "tofuMsgItem");
        if (!AppNetConnInfo.isNetSupport()) {
            Resources resources = context.getResources();
            if (resources != null) {
                str2 = resources.getString(R.string.f169552in);
            } else {
                str2 = null;
            }
            QQToast.makeText(context, str2, 0).show();
            return;
        }
        v3.setSelected(!v3.isSelected());
        ((IAIOTofuApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOTofuApi.class)).sendLikeStatus(uin, !v3.isSelected() ? 1 : 0, new b(v3));
        HashMap hashMap = new HashMap();
        String m26 = tofuMsgItem.m2();
        if (m26 == null) {
            m26 = "";
        }
        hashMap.put("curd_block_id", m26);
        hashMap.put("curd_block_business_type", String.valueOf(tofuMsgItem.n2()));
        hashMap.put("curd_block_style", Integer.valueOf(tofuMsgItem.k2()));
        if (v3.isSelected()) {
            str = "status_like";
        } else {
            str = "status_notlike";
        }
        hashMap.put("service_custom_field", str);
        com.tencent.mobileqq.aio.utils.b.l("em_bas_aio_bean_curd_cubes", hashMap);
    }

    public final void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            isTofuExperimentC = null;
        }
    }
}
