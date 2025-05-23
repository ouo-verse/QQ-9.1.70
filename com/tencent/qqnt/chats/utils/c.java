package com.tencent.qqnt.chats.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.x;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.emotion.utils.s;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nJ\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/chats/utils/c;", "", "Landroid/content/Context;", "context", "", "state", "Landroid/graphics/drawable/Drawable;", "c", "Landroid/view/View;", "payloadView", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "d", "", "a", "b", "<init>", "()V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f355544a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45805);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f355544a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Drawable c(Context context, int state) {
        switch (state) {
            case 1:
            case 2:
            case 3:
            case 5:
                return ResourcesCompat.getDrawable(context.getResources(), R.drawable.qui_telephone_filled_feedback_success, null);
            case 4:
                return ResourcesCompat.getDrawable(context.getResources(), R.drawable.mrw, null);
            case 6:
                return ie0.a.f().o(context, R.drawable.qui_music_box, R.color.qui_common_feedback_normal, 1001);
            case 7:
                return ResourcesCompat.getDrawable(context.getResources(), R.drawable.f160589hn0, null);
            case 8:
                return ie0.a.f().o(context, R.drawable.qui_position, R.color.qui_common_icon_aio_nav_active, 1001);
            case 9:
                return ResourcesCompat.getDrawable(context.getResources(), R.drawable.hmy, null);
            case 10:
                return ResourcesCompat.getDrawable(context.getResources(), R.drawable.mrs, null);
            case 11:
                return ResourcesCompat.getDrawable(context.getResources(), R.drawable.f160583ms3, null);
            case 12:
            case 13:
                return ResourcesCompat.getDrawable(context.getResources(), R.drawable.qui_video_on_filled_feedback_success, null);
            case 14:
                return ResourcesCompat.getDrawable(context.getResources(), R.drawable.f160588ms4, null);
            default:
                return null;
        }
    }

    @JvmStatic
    public static final void d(@NotNull View payloadView, @NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
        Intrinsics.checkNotNullParameter(payloadView, "payloadView");
        Intrinsics.checkNotNullParameter(item, "item");
        payloadView.setTag(R.id.f9215574, Long.valueOf(item.m()));
    }

    @NotNull
    public final String a(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
        BaseQQAppInterface baseQQAppInterface;
        String obj;
        CharSequence b16;
        int intValue;
        String str;
        MobileQQ application;
        MobileQQ application2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) item);
        }
        Intrinsics.checkNotNullParameter(item, "item");
        int b17 = (int) item.x().b();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String str2 = null;
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
        } else {
            baseQQAppInterface = null;
        }
        if (item.F()) {
            if (baseQQAppInterface != null && (application2 = baseQQAppInterface.getApplication()) != null) {
                obj = application2.getString(R.string.f230366yy, item.v().f());
            }
            obj = null;
        } else if (item.n() == 16) {
            g.c c16 = item.v().c();
            if (c16 != null && (b16 = c16.b()) != null) {
                obj = b16.toString();
            }
            obj = null;
        } else {
            obj = item.v().f().toString();
        }
        String b18 = s.b(item.v().e() + obj);
        Integer num = item.y().e().vipLevel;
        if (num == null) {
            intValue = 0;
        } else {
            intValue = num.intValue();
        }
        String str3 = "";
        if (intValue <= 0) {
            str = "";
        } else {
            str = "\u94ed\u724c";
        }
        if (item.H()) {
            str3 = ",\u7f6e\u9876\u804a\u5929";
        }
        if (b17 != 0) {
            if (baseQQAppInterface != null && (application = baseQQAppInterface.getApplication()) != null) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = application.getString(R.string.f230426z4);
                Intrinsics.checkNotNullExpressionValue(string, "it.getString(R.string.talkback_message_unread)");
                str2 = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(b17)}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
            }
            String valueOf = String.valueOf(str2);
            return item.w().e() + ", " + str + "," + valueOf + "," + b18 + "," + item.u() + str3;
        }
        return item.w().e() + ", " + str + "," + b18 + "," + item.u() + str3;
    }

    @Nullable
    public final Drawable b(@NotNull Context context, int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Drawable) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, state);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Drawable c16 = c(context, state);
        if (c16 != null) {
            int c17 = x.c(context, 16.0f);
            int c18 = x.c(context, 1.5f);
            c16.setBounds(0, c18, c17, c18 + c17);
        }
        return c16;
    }
}
