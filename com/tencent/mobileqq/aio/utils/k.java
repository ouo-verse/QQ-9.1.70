package com.tencent.mobileqq.aio.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.aio.msg.ArkMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/aio/utils/k;", "", "Lcom/tencent/qqnt/msg/data/a;", "arkMsgModel", "", "b", "Lcom/tencent/mobileqq/aio/msg/ArkMsgItem;", "arkMsgItem", "", "a", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f194164a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65284);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f194164a = new k();
        }
    }

    k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull ArkMsgItem arkMsgItem, @Nullable com.tencent.qqnt.msg.data.a arkMsgModel) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) arkMsgItem, (Object) arkMsgModel);
            return;
        }
        Intrinsics.checkNotNullParameter(arkMsgItem, "arkMsgItem");
        if (b(arkMsgModel)) {
            try {
                if (arkMsgModel != null) {
                    str = arkMsgModel.m();
                } else {
                    str = null;
                }
                JSONObject jSONObject = new JSONObject(str);
                JSONObject optJSONObject = jSONObject.optJSONObject("detail");
                if (optJSONObject != null) {
                    optJSONObject.put("uniseq", String.valueOf(arkMsgItem.getMsgId()));
                }
                if (arkMsgModel != null) {
                    arkMsgModel.q(jSONObject.toString());
                }
            } catch (JSONException e16) {
                QLog.e("ArkMsgUtils", 1, "appendExtraInfo MultiMsg error = " + e16);
            }
        }
    }

    public final boolean b(@Nullable com.tencent.qqnt.msg.data.a arkMsgModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) arkMsgModel)).booleanValue();
        }
        if (arkMsgModel == null || TextUtils.isEmpty(arkMsgModel.d()) || !Intrinsics.areEqual("com.tencent.multimsg", arkMsgModel.d()) || TextUtils.isEmpty(arkMsgModel.e()) || !Intrinsics.areEqual("contact", arkMsgModel.e())) {
            return false;
        }
        return true;
    }
}
