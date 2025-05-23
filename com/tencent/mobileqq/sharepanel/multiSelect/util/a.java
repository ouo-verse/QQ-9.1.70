package com.tencent.mobileqq.sharepanel.multiSelect.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.proavatar.QQProAvatarDrawable;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.sharepanel.model.SharePanelContactItem;
import com.tencent.mobileqq.utils.BaseImageUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/multiSelect/util/a;", "", "", "headType", "Lcom/tencent/mobileqq/proavatar/e;", "a", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/sharepanel/model/SharePanelContactItem;", "data", "Landroid/graphics/drawable/Drawable;", "b", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f287480a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39741);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f287480a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final e a(int headType) {
        if (headType == 1) {
            return new e.a(0, false, false, false, 0, false, 0, 0, null, false, false, 0, null, null, 0, 32767, null).e(false).a();
        }
        return null;
    }

    @NotNull
    public final Drawable b(@NotNull Context context, @NotNull SharePanelContactItem data) {
        String guildAvatarUrlIPC;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Drawable) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) data);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        String str = null;
        if (data.g()) {
            if (MobileQQ.sProcessId == 1) {
                guildAvatarUrlIPC = "";
                IGProGuildInfo guildInfo = ((IGPSService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "")).getGuildInfo(data.a());
                if (guildInfo != null) {
                    str = guildInfo.getAvatarUrl(100);
                }
                if (str != null) {
                    guildAvatarUrlIPC = str;
                }
            } else {
                guildAvatarUrlIPC = ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).getGuildAvatarUrlIPC(data.a(), 100);
            }
            Drawable guildFaceIcon = ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).getGuildFaceIcon(guildAvatarUrlIPC, 100, BaseImageUtil.getDefaultFaceDrawable(false), true);
            Intrinsics.checkNotNullExpressionValue(guildFaceIcon, "api(IQQGuildUtilApi::cla\u2026   true\n                )");
            return guildFaceIcon;
        }
        String e16 = data.e();
        if (Intrinsics.areEqual(e16, AppConstants.DATALINE_PHONE_UIN)) {
            Drawable drawable = context.getResources().getDrawable(R.drawable.qfile_dataline_user_aio, null);
            Intrinsics.checkNotNullExpressionValue(drawable, "{\n                    co\u2026, null)\n                }");
            return drawable;
        }
        if (Intrinsics.areEqual(e16, AppConstants.DATALINE_PC_UIN)) {
            Drawable drawable2 = context.getResources().getDrawable(R.drawable.qfile_dataline_pc_recent, null);
            Intrinsics.checkNotNullExpressionValue(drawable2, "{\n                    co\u2026, null)\n                }");
            return drawable2;
        }
        if (Intrinsics.areEqual(e16, AppConstants.DATALINE_IPAD_UIN)) {
            Drawable drawable3 = context.getResources().getDrawable(R.drawable.qfile_dataline_ipad_recent, null);
            Intrinsics.checkNotNullExpressionValue(drawable3, "{\n                    co\u2026, null)\n                }");
            return drawable3;
        }
        int a16 = b.f287481a.a(data.e(), data.f());
        QQProAvatarDrawable qQProAvatarDrawable = new QQProAvatarDrawable();
        qQProAvatarDrawable.r(context, a16, data.e(), f287480a.a(a16));
        return qQProAvatarDrawable;
    }
}
