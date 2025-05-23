package com.tencent.qqnt.aio.adapter.api;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u0000  2\u00020\u0001:\u0001!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J0\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\b0\rj\b\u0012\u0004\u0012\u00020\b`\u000eH&J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000bH&J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H&J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J(\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\bH&\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IMiniCardBeancurd;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/view/View;", "view", "", "setUIAlphaOnTouchListener", "Landroid/content/Context;", "context", "", "friendUin", "gotoQZoneUserHome", "", "position", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "originUrl", "gotoBigImagePreview", "actionId", "Landroid/graphics/drawable/BitmapDrawable;", "getSignActionEmoji", "gotoSignatureHistory", "jumpToQuestionListAndAnswer", "", "data", "Lorg/json/JSONObject;", "getSignFromRichStatus", "gotoProfileCard", "content", "dataType", "resId", "defVal", "getResourceText", "Companion", "a", "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IMiniCardBeancurd extends QRouteApi {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String SIGN_ACTION_DATA = "actionAndData";

    @NotNull
    public static final String SIGN_ACTION_ID = "actionId";

    @NotNull
    public static final String SIGN_PLAIN_TEXT = "plainText";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IMiniCardBeancurd$a;", "", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.adapter.api.IMiniCardBeancurd$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f348503a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50468);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f348503a = new Companion();
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(50469), (Class<?>) IMiniCardBeancurd.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.f348503a;
        }
    }

    @NotNull
    String getResourceText(@NotNull Context content, int dataType, int resId, @NotNull String defVal);

    @NotNull
    BitmapDrawable getSignActionEmoji(@NotNull Context context, int actionId);

    @NotNull
    JSONObject getSignFromRichStatus(@NotNull byte[] data);

    void gotoBigImagePreview(@NotNull Context context, int position, @NotNull ArrayList<String> originUrl);

    void gotoProfileCard(@NotNull Context context, @NotNull String friendUin);

    void gotoQZoneUserHome(@NotNull Context context, @NotNull String friendUin);

    void gotoSignatureHistory(@NotNull Context context, @NotNull String friendUin);

    void jumpToQuestionListAndAnswer(@NotNull Context context, @NotNull String friendUin);

    void setUIAlphaOnTouchListener(@NotNull View view);
}
