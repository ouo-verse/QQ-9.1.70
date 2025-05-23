package com.tencent.qqnt.aio.nick;

import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.nick.api.INickNameApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernel.nativeinterface.VASAIOPersonalElement;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/nick/j;", "", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "c", "(Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;)Ljava/lang/Long;", "", "d", "Lcom/tencent/qqnt/aio/nick/a;", "a", "", "nickName", "Lcom/tencent/qqnt/aio/nick/i;", "b", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f351725a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51213);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f351725a = new j();
        }
    }

    j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final a a(@NotNull AIOMsgItem msgItem) {
        HashMap<String, String> hashMap;
        int i3;
        String str;
        String str2;
        VASAIOPersonalElement vASAIOPersonalElement;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        MsgAttributeInfo msgAttributeInfo = msgItem.getMsgRecord().msgAttrs.get(1);
        if (msgAttributeInfo != null && (vASAIOPersonalElement = msgAttributeInfo.vasPersonalInfo) != null) {
            hashMap = vASAIOPersonalElement.extInfo;
        } else {
            hashMap = null;
        }
        boolean z16 = false;
        if (hashMap != null) {
            i3 = hashMap.size();
        } else {
            i3 = 0;
        }
        if (i3 <= 0) {
            return null;
        }
        if (hashMap == null || (str = hashMap.get("normalColor")) == null) {
            str = "";
        }
        if (hashMap != null && (str2 = hashMap.get("hasCoverAnim")) != null) {
            z16 = Boolean.parseBoolean(str2);
        }
        return new a(str, z16);
    }

    @NotNull
    public final i b(@NotNull CharSequence nickName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (i) iPatchRedirector.redirect((short) 5, (Object) this, (Object) nickName);
        }
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Paint paint = new Paint();
        paint.setTextSize(BaseApplication.context.getResources().getDimension(R.dimen.f158235c01));
        float measureNickName = ((INickNameApi) QRoute.api(INickNameApi.class)).measureNickName(nickName, 13);
        Rect rect = new Rect();
        char[] charArray = nickName.toString().toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
        paint.getTextBounds(charArray, 0, nickName.length(), rect);
        if (QLog.isDevelopLevel()) {
            QLog.i("NickUtils", 1, "[getNickNameDrawInfo]: contentWidth is " + measureNickName + ", bound is " + rect + ", showName is " + ((Object) nickName));
        }
        return new i(measureNickName, rect);
    }

    @Nullable
    public final Long c(@NotNull AIOMsgItem msgItem) {
        VASAIOPersonalElement vASAIOPersonalElement;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Long) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgItem);
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        MsgAttributeInfo msgAttributeInfo = msgItem.getMsgRecord().msgAttrs.get(1);
        if (msgAttributeInfo != null && (vASAIOPersonalElement = msgAttributeInfo.vasPersonalInfo) != null) {
            return vASAIOPersonalElement.troopNameColorId;
        }
        return null;
    }

    public final boolean d(@NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgItem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Long c16 = c(msgItem);
        if (c16 != null && c16.longValue() > 0) {
            return true;
        }
        return false;
    }
}
