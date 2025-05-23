package com.tencent.mobileqq.aio.msglist.holder.component.tofu.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.ah;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.tofu.IBeancurdFactory;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IAIOTofuApi;
import com.tencent.qqnt.kernel.nativeinterface.TofuContent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b,\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u0000 h2\u00020\u00012\u00020\u0002:\u0002i\u0015B\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\bd\u00106B\u0019\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010f\u001a\u00020e\u00a2\u0006\u0004\bd\u0010gJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0014J\b\u0010\u000f\u001a\u00020\rH\u0014J\u0010\u0010\u0011\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0004J\u001a\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0014J&\u0010 \u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0012H\u0004J \u0010$\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u00162\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\"H\u0014J\u000e\u0010'\u001a\u00020\r2\u0006\u0010&\u001a\u00020%J\u0010\u0010(\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u0003H\u0016J\b\u0010*\u001a\u00020)H\u0016R\"\u00101\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00107\u001a\u00020\n8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b2\u00104\"\u0004\b5\u00106R\"\u0010?\u001a\u0002088\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010C\u001a\u0002088\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010:\u001a\u0004\bA\u0010<\"\u0004\bB\u0010>R\"\u0010G\u001a\u0002088\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010:\u001a\u0004\bE\u0010<\"\u0004\bF\u0010>R\"\u0010I\u001a\u0002088\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010:\u001a\u0004\b9\u0010<\"\u0004\bH\u0010>R\"\u0010M\u001a\u0002088\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010:\u001a\u0004\bK\u0010<\"\u0004\bL\u0010>R\"\u0010S\u001a\u00020\u00078\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\b@\u0010P\"\u0004\bQ\u0010RR\"\u0010Y\u001a\u00020\u00058\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\b+\u0010V\"\u0004\bW\u0010XR\"\u0010_\u001a\u00020%8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\bD\u0010\\\"\u0004\b]\u0010^R$\u0010c\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b`\u0010,\u001a\u0004\ba\u0010.\"\u0004\bb\u00100\u00a8\u0006j"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/a;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/vas/tofu/IBeancurdFactory$a;", "Landroid/view/View;", "content", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/BoxShadowLayout;", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/aio/msg/ah;", "message", "B", "Landroid/content/Context;", "context", "l", "", DomainData.DOMAIN_NAME, "o", "onClickListener", "w", "", "url", "Lcom/tencent/image/URLDrawable;", "b", "Landroid/widget/TextView;", "titleView", "Lcom/tencent/qqnt/kernel/nativeinterface/TofuContent;", "titleContent", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/common/app/AppInterface;", "app", "Landroid/widget/ImageView;", "headView", "uin", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "tvContent", "", "contentList", "y", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/a$b;", "listener", "v", NodeProps.ON_CLICK, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "d", "Landroid/view/View;", "k", "()Landroid/view/View;", "setMRootView", "(Landroid/view/View;)V", "mRootView", "e", "Landroid/content/Context;", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mContext", "", "f", "I", "j", "()I", "setMRadius", "(I)V", "mRadius", tl.h.F, "getMShadowColor", "setMShadowColor", "mShadowColor", "i", "getMBlurSize", "setMBlurSize", "mBlurSize", "r", "mDefTitleColor", BdhLogUtil.LogTag.Tag_Conn, "g", ReportConstant.COSTREPORT_PREFIX, "mDefaultTextColor", "D", "Lcom/tencent/mobileqq/aio/msg/ah;", "()Lcom/tencent/mobileqq/aio/msg/ah;", "t", "(Lcom/tencent/mobileqq/aio/msg/ah;)V", "mMessage", "E", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/BoxShadowLayout;", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/BoxShadowLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/BoxShadowLayout;)V", "mContainer", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/a$b;", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/a$b;", "u", "(Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/a$b;)V", "mOnClickBeancurdListener", "G", "c", "p", "contentContainer", "<init>", "", "simpleInit", "(Landroid/content/Context;Z)V", "H", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public abstract class a implements View.OnClickListener, IBeancurdFactory.a {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private int mDefaultTextColor;

    /* renamed from: D, reason: from kotlin metadata */
    protected ah mMessage;

    /* renamed from: E, reason: from kotlin metadata */
    protected BoxShadowLayout mContainer;

    /* renamed from: F, reason: from kotlin metadata */
    protected b mOnClickBeancurdListener;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private View contentContainer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View mRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Context mContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mRadius;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mShadowColor;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mBlurSize;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mDefTitleColor;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a$a, reason: collision with other inner class name and from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/a$b;", "", "Lcom/tencent/mobileqq/aio/msg/ah;", "message", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public interface b {
        void a(@NotNull ah message);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63732);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 35)) {
            redirector.redirect((short) 35);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) context);
            return;
        }
        this.mRootView = l(context);
        this.mContext = context;
        n(context);
        o();
        q(x(this.mRootView));
        this.contentContainer = d();
        d().setOnClickListener(this);
    }

    private final BoxShadowLayout x(View content) {
        int dpToPx = ViewUtils.dpToPx(123.0f);
        BoxShadowLayout boxShadowLayout = new BoxShadowLayout(this.mContext);
        boxShadowLayout.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, dpToPx));
        boxShadowLayout.b(content, this.mBlurSize, this.mRadius, this.mShadowColor);
        int f16 = (int) (com.tencent.mobileqq.aio.utils.e.f194142a.f() * 0.14f);
        if (QLog.isColorLevel()) {
            QLog.i("BeancurdView", 2, "beancurdview left margin is " + f16);
        }
        boxShadowLayout.a(f16);
        return boxShadowLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(@NotNull TextView titleView, @Nullable TofuContent titleContent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) titleView, (Object) titleContent);
            return;
        }
        Intrinsics.checkNotNullParameter(titleView, "titleView");
        if (titleContent == null) {
            QLog.d("BeancurdView", 1, "updateTitle err: titleContent is null");
            return;
        }
        titleView.setText(titleContent.title);
        int i3 = this.mDefTitleColor;
        if (!TextUtils.isEmpty(titleContent.color)) {
            try {
                i3 = Color.parseColor(titleContent.color);
            } catch (Exception e16) {
                QLog.d("BeancurdView", 1, "updateTitle parse color err: " + e16);
            }
        }
        titleView.setTextColor(i3);
    }

    @NotNull
    public abstract View B(@NotNull ah message);

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final URLDrawable b(@Nullable String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (URLDrawable) iPatchRedirector.redirect((short) 28, (Object) this, (Object) url);
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.mContext.getResources().getColor(R.color.ajr));
        obtain.mLoadingDrawable = gradientDrawable;
        obtain.mFailedDrawable = gradientDrawable;
        URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
        Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(url, options)");
        return drawable;
    }

    @Nullable
    public final View c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (View) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.contentContainer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final BoxShadowLayout d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (BoxShadowLayout) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        BoxShadowLayout boxShadowLayout = this.mContainer;
        if (boxShadowLayout != null) {
            return boxShadowLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mContainer");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Context e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Context) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.mDefTitleColor;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.mDefaultTextColor;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final ah h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (ah) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        ah ahVar = this.mMessage;
        if (ahVar != null) {
            return ahVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mMessage");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final b i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (b) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        b bVar = this.mOnClickBeancurdListener;
        if (bVar != null) {
            return bVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mOnClickBeancurdListener");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.mRadius;
    }

    @NotNull
    public final View k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (View) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.mRootView;
    }

    @NotNull
    public abstract View l(@Nullable Context context);

    public float m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Float) iPatchRedirector.redirect((short) 34, (Object) this)).floatValue();
        }
        return com.tencent.mobileqq.aio.utils.e.f194142a.f() * 0.72f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRadius = ViewUtils.dpToPx(8.0f);
        this.mShadowColor = context.getResources().getColor(R.color.d_);
        this.mBlurSize = ViewUtils.dpToPx(8.0f);
        this.mDefTitleColor = context.getResources().getColor(R.color.black);
        this.mDefaultTextColor = context.getResources().getColor(R.color.black);
    }

    protected void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        } else {
            this.mRootView.setBackgroundResource(R.drawable.kp7);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) v3);
        } else {
            Intrinsics.checkNotNullParameter(v3, "v");
            if (this.mOnClickBeancurdListener != null && i() != null) {
                i().a(h());
            } else if (QLog.isColorLevel()) {
                QLog.e("BeancurdView", 2, "not set mOnClickBeancurdListener");
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    public final void p(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) view);
        } else {
            this.contentContainer = view;
        }
    }

    protected final void q(@NotNull BoxShadowLayout boxShadowLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) boxShadowLayout);
        } else {
            Intrinsics.checkNotNullParameter(boxShadowLayout, "<set-?>");
            this.mContainer = boxShadowLayout;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void r(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.mDefTitleColor = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void s(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            this.mDefaultTextColor = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void t(@NotNull ah ahVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) ahVar);
        } else {
            Intrinsics.checkNotNullParameter(ahVar, "<set-?>");
            this.mMessage = ahVar;
        }
    }

    protected final void u(@NotNull b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) bVar);
        } else {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.mOnClickBeancurdListener = bVar;
        }
    }

    public final void v(@NotNull b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            u(listener);
        }
    }

    public final void w(@Nullable View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) onClickListener);
        } else {
            this.mRootView.setOnClickListener(onClickListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y(@NotNull TextView tvContent, @Nullable List<TofuContent> contentList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) tvContent, (Object) contentList);
            return;
        }
        Intrinsics.checkNotNullParameter(tvContent, "tvContent");
        if (contentList != null && !contentList.isEmpty()) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (TofuContent tofuContent : contentList) {
                int i3 = this.mDefaultTextColor;
                if (!TextUtils.isEmpty(tofuContent.color)) {
                    try {
                        i3 = Color.parseColor(tofuContent.color);
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("BeancurdView", 2, "updateDetailIfNeed parse color err: ", e16);
                        }
                    }
                }
                spannableStringBuilder.append(tofuContent.title, new ForegroundColorSpan(i3), 33);
            }
            tvContent.setText(spannableStringBuilder);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("BeancurdView", 2, "update content failed, contentList is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void z(@Nullable AppInterface app, @Nullable ImageView headView, @Nullable String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, app, headView, uin);
            return;
        }
        Drawable headDrawable = ((IAIOTofuApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOTofuApi.class)).getHeadDrawable(uin);
        if (headDrawable != null && headView != null) {
            headView.setImageDrawable(headDrawable);
        }
    }

    public a(@NotNull Context context, boolean z16) {
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, context, Boolean.valueOf(z16));
        } else {
            this.mRootView = l(context);
            this.mContext = context;
        }
    }
}
