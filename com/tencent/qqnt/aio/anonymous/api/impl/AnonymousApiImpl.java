package com.tencent.qqnt.aio.anonymous.api.impl;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.anonymous.api.IAnonymousApi;
import com.tencent.qqnt.aio.urldrawable.b;
import com.tencent.qqnt.kernel.nativeinterface.AnonymousExtInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/anonymous/api/impl/AnonymousApiImpl;", "Lcom/tencent/qqnt/aio/anonymous/api/IAnonymousApi;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "Landroid/graphics/drawable/Drawable;", "getAvatarDrawable", "<init>", "()V", "Companion", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AnonymousApiImpl implements IAnonymousApi {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    private static final String ANONYMOUS_HEAD_URL = "https://pub.idqqimg.com/pc/group/anony/portrait/img/";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "AnonymousApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/aio/anonymous/api/impl/AnonymousApiImpl$a;", "", "", "ANONYMOUS_HEAD_URL", "Ljava/lang/String;", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.anonymous.api.impl.AnonymousApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65426);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AnonymousApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.anonymous.api.IAnonymousApi
    @NotNull
    public Drawable getAvatarDrawable(@NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Drawable) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        BaseApplication baseApplication = BaseApplication.context;
        Drawable drawable = baseApplication.getResources().getDrawable(R.drawable.f161530e21);
        Intrinsics.checkNotNullExpressionValue(drawable, "context.getResources().g\u2026mous_default_header_icon)");
        AnonymousExtInfo anonymousExtInfo = msgItem.getMsgRecord().anonymousExtInfo;
        if (anonymousExtInfo != null) {
            String str = ANONYMOUS_HEAD_URL + anonymousExtInfo.headPicIndex + ".png";
            String str2 = anonymousExtInfo.rankColor;
            if (!TextUtils.isEmpty(str2)) {
                try {
                    URLDrawable headerDrawable = URLDrawable.getDrawable(str, drawable, drawable);
                    headerDrawable.setTag(new int[]{Color.parseColor(str2), x.c(baseApplication, 1.0f)});
                    headerDrawable.setDecodeHandler(b.c());
                    headerDrawable.startDownload();
                    Intrinsics.checkNotNullExpressionValue(headerDrawable, "headerDrawable");
                    return headerDrawable;
                } catch (Exception e16) {
                    QLog.i(TAG, 1, "[getAvatarDrawable]: " + e16);
                }
            }
        }
        return drawable;
    }
}
