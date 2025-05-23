package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IMiniCardBeancurd;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J0\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\b0\rj\b\u0012\u0004\u0012\u00020\b`\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J(\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\bH\u0016\u00a8\u0006$"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/MiniCardBeancurdNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IMiniCardBeancurd;", "Landroid/view/View;", "view", "", "setUIAlphaOnTouchListener", "Landroid/content/Context;", "context", "", "friendUin", "gotoQZoneUserHome", "", "position", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "originUrl", "gotoBigImagePreview", "actionId", "Landroid/graphics/drawable/BitmapDrawable;", "getSignActionEmoji", "gotoSignatureHistory", "jumpToQuestionListAndAnswer", "", "data", "Lorg/json/JSONObject;", "getSignFromRichStatus", "gotoProfileCard", "content", "dataType", "resId", "defText", "getResourceText", "<init>", "()V", "Companion", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class MiniCardBeancurdNtImpl implements IMiniCardBeancurd {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "MiniCardBeancurdNtImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/MiniCardBeancurdNtImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.adapter.api.impl.MiniCardBeancurdNtImpl$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65421);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public MiniCardBeancurdNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IMiniCardBeancurd
    @NotNull
    public String getResourceText(@NotNull Context content, int dataType, int resId, @NotNull String defText) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, this, content, Integer.valueOf(dataType), Integer.valueOf(resId), defText);
        }
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(defText, "defText");
        return defText;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IMiniCardBeancurd
    @NotNull
    public BitmapDrawable getSignActionEmoji(@NotNull Context context, int actionId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (BitmapDrawable) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, actionId);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        QLog.i(TAG, 1, "invokeNT:getSignActionEmoji");
        return new BitmapDrawable();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IMiniCardBeancurd
    @NotNull
    public JSONObject getSignFromRichStatus(@NotNull byte[] data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (JSONObject) iPatchRedirector.redirect((short) 8, (Object) this, (Object) data);
        }
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.i(TAG, 1, "invokeNT:getSignFromRichStatus");
        return new JSONObject();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IMiniCardBeancurd
    public void gotoBigImagePreview(@NotNull Context context, int position, @NotNull ArrayList<String> originUrl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, Integer.valueOf(position), originUrl);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(originUrl, "originUrl");
        QLog.i(TAG, 1, "invokeNT:gotoBigImagePreview");
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IMiniCardBeancurd
    public void gotoProfileCard(@NotNull Context context, @NotNull String friendUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) context, (Object) friendUin);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        QLog.i(TAG, 1, "invokeNT:gotoProfileCard");
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IMiniCardBeancurd
    public void gotoQZoneUserHome(@NotNull Context context, @NotNull String friendUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) friendUin);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        QLog.i(TAG, 1, "invokeNT:gotoQZoneUserHome");
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IMiniCardBeancurd
    public void gotoSignatureHistory(@NotNull Context context, @NotNull String friendUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context, (Object) friendUin);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        QLog.i(TAG, 1, "invokeNT:gotoSignatureHistory");
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IMiniCardBeancurd
    public void jumpToQuestionListAndAnswer(@NotNull Context context, @NotNull String friendUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context, (Object) friendUin);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        QLog.i(TAG, 1, "invokeNT:jumpToQuestionListAndAnswer");
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IMiniCardBeancurd
    public void setUIAlphaOnTouchListener(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "view");
            QLog.i(TAG, 1, "invokeNT:setUIAlphaOnTouchListener");
        }
    }
}
