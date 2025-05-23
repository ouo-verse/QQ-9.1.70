package com.tencent.mobileqq.aio.msglist.holder.component.tofu.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.ah;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.api.IAIOTofuApi;
import com.tencent.qqnt.kernel.nativeinterface.TofuContent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/j;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/view/a;", "", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/aio/msg/ah;", "message", "Landroid/view/View;", "B", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", "l", "Landroidx/constraintlayout/utils/widget/ImageFilterView;", "I", "Landroidx/constraintlayout/utils/widget/ImageFilterView;", "mBgIv", "Landroid/widget/ImageView;", "J", "Landroid/widget/ImageView;", "mAvatarIv", "Landroid/widget/TextView;", "K", "Landroid/widget/TextView;", "mTitleTv", "L", "mDescTv", "<init>", "(Landroid/content/Context;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class j extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private ImageFilterView mBgIv;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private ImageView mAvatarIv;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private TextView mTitleTv;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private TextView mDescTv;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NotNull Context context) {
        super(context, true);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        View findViewById = k().findViewById(R.id.zvk);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R\u2026video_beancurd_img_cover)");
        this.mBgIv = (ImageFilterView) findViewById;
        View findViewById2 = k().findViewById(R.id.zvj);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R\u2026ideo_beancurd_img_avatar)");
        this.mAvatarIv = (ImageView) findViewById2;
        View findViewById3 = k().findViewById(R.id.zvm);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R\u2026_video_beancurd_tv_title)");
        this.mTitleTv = (TextView) findViewById3;
        View findViewById4 = k().findViewById(R.id.zvl);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R\u2026t_video_beancurd_iv_desc)");
        this.mDescTv = (TextView) findViewById4;
        k().setOnClickListener(this);
        p(k());
    }

    private final void C() {
        String str;
        String str2;
        TofuContent tofuContent;
        String str3;
        IAIOTofuApi iAIOTofuApi = (IAIOTofuApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOTofuApi.class);
        ImageView imageView = this.mAvatarIv;
        List<String> v26 = h().v2();
        int i3 = 0;
        if (v26 != null) {
            str = v26.get(0);
        } else {
            str = null;
        }
        imageView.setImageDrawable(iAIOTofuApi.getHeadDrawable(str));
        iAIOTofuApi.loadDrawableByUrl(this.mBgIv, h().j2());
        TextView textView = this.mTitleTv;
        TofuContent p26 = h().p2();
        String str4 = "";
        if (p26 == null || (str2 = p26.title) == null) {
            str2 = "";
        }
        textView.setText(str2);
        TextView textView2 = this.mDescTv;
        List<TofuContent> o26 = h().o2();
        if (o26 != null && (tofuContent = o26.get(0)) != null && (str3 = tofuContent.title) != null) {
            str4 = str3;
        }
        textView2.setText(str4);
        TextView textView3 = this.mDescTv;
        if (TextUtils.isEmpty(textView3.getText())) {
            i3 = 4;
        }
        textView3.setVisibility(i3);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a
    @NotNull
    public View B(@NotNull ah message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
        }
        Intrinsics.checkNotNullParameter(message, "message");
        t(message);
        C();
        return k();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a
    @NotNull
    public View l(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        }
        View inflate = View.inflate(context, R.layout.fq7, null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026ncurd_video_layout, null)");
        return inflate;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.tofu.view.a
    public float m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Float) iPatchRedirector.redirect((short) 3, (Object) this)).floatValue();
        }
        return com.tencent.qqnt.aio.utils.l.a(236.0f);
    }
}
