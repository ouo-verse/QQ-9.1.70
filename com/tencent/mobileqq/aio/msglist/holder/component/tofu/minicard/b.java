package com.tencent.mobileqq.aio.msglist.holder.component.tofu.minicard;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.avatar.AvatarSizeType;
import com.tencent.qqnt.avatar.a;
import com.tencent.qqnt.avatar.b;
import com.tencent.qqnt.avatar.e;
import com.tencent.qqnt.base.widget.RoundRectImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/minicard/b;", "", "", "friendUid", "friendUin", "Lcom/tencent/qqnt/base/widget/RoundRectImageView;", "view", "Lcom/tencent/qqnt/avatar/AvatarSizeType;", "size", "", "a", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/tofu/minicard/b$a;", "", "", "BIG_RADIUS", UserInfo.SEX_FEMALE, "NORMAL_RADIUS", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.tofu.minicard.b$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63709);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull String friendUid, @NotNull String friendUin, @NotNull RoundRectImageView view, @NotNull AvatarSizeType size) {
        float f16;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, friendUid, friendUin, view, size);
            return;
        }
        Intrinsics.checkNotNullParameter(friendUid, "friendUid");
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(size, "size");
        if (TextUtils.isEmpty(friendUin)) {
            return;
        }
        view.setScaleType(ImageView.ScaleType.FIT_XY);
        if (size == AvatarSizeType.BIG) {
            f16 = 50.0f;
        } else {
            f16 = 20.0f;
        }
        view.setCornerRadiusAndMode(ViewUtils.dip2px(f16), 1);
        b.Companion companion = com.tencent.qqnt.avatar.b.INSTANCE;
        b.a aVar = new b.a();
        aVar.f(0);
        aVar.g(size);
        aVar.b(Integer.valueOf(R.drawable.f160830com));
        com.tencent.qqnt.avatar.b a16 = aVar.a();
        try {
            j3 = Long.parseLong(friendUin);
        } catch (NumberFormatException e16) {
            QLog.e("MiniCardAvatarHelper", 1, e16.getMessage(), e16);
            j3 = 0;
        }
        long j16 = j3;
        a.Companion companion2 = com.tencent.qqnt.avatar.a.INSTANCE;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        e.a.b(companion2.b(context).b(view).e(a16), friendUid, j16, null, 4, null);
    }
}
