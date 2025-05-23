package com.tencent.mobileqq.aio.input;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.aio.event.InputEvent;
import com.tencent.mobileqq.aio.input.edit.d;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mvi.base.route.k;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IQQTextApi;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J(\u0010\u0012\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0002J2\u0010\u0015\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0002J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0002J2\u0010\u0018\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\u0006\u0010\u001b\u001a\u00020\u0019J\u000e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cJ \u0010%\u001a\u00020$2\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u001eJ\b\u0010&\u001a\u0004\u0018\u00010\nJ\u0006\u0010'\u001a\u00020\u0019J\u001a\u0010)\u001a\u0004\u0018\u00010\u00022\u0006\u0010(\u001a\u00020\u001e2\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0010\u0010*\u001a\u00020$2\b\u0010\r\u001a\u0004\u0018\u00010\u0002J\u0010\u0010+\u001a\u00020$2\b\u0010\r\u001a\u0004\u0018\u00010\u0002R\u001b\u0010/\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010,\u001a\u0004\b-\u0010.R$\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u00101\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/aio/input/AIOInputUtil;", "", "", "c", "Landroid/text/Spannable;", "cachedSpanned", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/text/Spanned;", "selectedText", "a", "", "e", "Landroid/os/Bundle;", "data", "g", "i", "styleData", "requireData", "t", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "p", "Lorg/json/JSONObject;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "", tl.h.F, "l", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "b", "Landroid/text/Editable;", "source", "startIndex", "endIndex", "", ReportConstant.COSTREPORT_PREFIX, "d", "k", "businessFlag", "f", DomainData.DOMAIN_NAME, "o", "Lkotlin/Lazy;", "j", "()Z", "vasInputTopMarginSwitch", "Lkotlin/Pair;", "Lkotlin/Pair;", "mCopyCacheSpannables", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AIOInputUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AIOInputUtil f189159a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy vasInputTopMarginSwitch;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Pair<String, ? extends Spannable> mCopyCacheSpannables;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53093);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        f189159a = new AIOInputUtil();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.aio.input.AIOInputUtil$vasInputTopMarginSwitch$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("aio_vas_inputbar_topmargin", true));
            }
        });
        vasInputTopMarginSwitch = lazy;
    }

    AIOInputUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Spannable a(Spanned selectedText) {
        boolean z16;
        if (selectedText == null) {
            return null;
        }
        com.tencent.mobileqq.aio.input.fullscreen.a[] imageSpanArray = (com.tencent.mobileqq.aio.input.fullscreen.a[]) selectedText.getSpans(0, selectedText.length(), com.tencent.mobileqq.aio.input.fullscreen.a.class);
        boolean z17 = true;
        if (imageSpanArray != null) {
            if (imageSpanArray.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                z17 = false;
            }
        }
        if (z17) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOInputUtil", 2, "setPasteMenu return, imageSpanArray is empty");
            }
            return null;
        }
        Editable newEditable = ((IQQTextApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQTextApi.class)).getInputNotReuseQQTextBuilder().newEditable(selectedText);
        Intrinsics.checkNotNullExpressionValue(newEditable, "AIOAdapterRoute.api(IQQT\u2026newEditable(selectedText)");
        Spannable m3 = m(newEditable);
        Intrinsics.checkNotNullExpressionValue(imageSpanArray, "imageSpanArray");
        for (com.tencent.mobileqq.aio.input.fullscreen.a aVar : imageSpanArray) {
            m3.setSpan(aVar.d(), selectedText.getSpanStart(aVar), selectedText.getSpanEnd(aVar), 33);
        }
        return m3;
    }

    private final String c() {
        ClipData primaryClip;
        Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
        if (applicationContext == null) {
            return "";
        }
        Object systemService = applicationContext.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardManager clipboardManager = (ClipboardManager) systemService;
        if (!ClipboardMonitor.hasPrimaryClip(clipboardManager) || (primaryClip = ClipboardMonitor.getPrimaryClip(clipboardManager)) == null || primaryClip.getItemCount() <= 0) {
            return "";
        }
        String obj = primaryClip.getItemAt(0).coerceToText(applicationContext).toString();
        if (QLog.isColorLevel()) {
            QLog.d("AIOInputUtil", 2, "getKeyFromClipboard");
        }
        return obj;
    }

    private final CharSequence e(Spannable cachedSpanned) {
        boolean z16;
        Editable newEditable = ((IQQTextApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQTextApi.class)).getInputNotReuseQQTextBuilder().newEditable(cachedSpanned);
        com.tencent.mobileqq.aio.input.fullscreen.b[] imageSpanDataArray = (com.tencent.mobileqq.aio.input.fullscreen.b[]) newEditable.getSpans(0, newEditable.length(), com.tencent.mobileqq.aio.input.fullscreen.b.class);
        boolean z17 = true;
        if (imageSpanDataArray != null) {
            if (imageSpanDataArray.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                z17 = false;
            }
        }
        if (z17) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOInputUtil", 2, "getPasteText return, imageSpanDataArray is empty");
                return null;
            }
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(imageSpanDataArray, "imageSpanDataArray");
        for (com.tencent.mobileqq.aio.input.fullscreen.b bVar : imageSpanDataArray) {
            int spanStart = newEditable.getSpanStart(bVar);
            int spanEnd = newEditable.getSpanEnd(bVar);
            newEditable.removeSpan(bVar);
            newEditable.setSpan(bVar.a(), spanStart, spanEnd, 33);
        }
        return newEditable;
    }

    private final String g(Bundle data) {
        if (data == null) {
            return "";
        }
        return t(data.getString("callback", ""), data.getString("style_Data", ""), data.getString("require_data", ""));
    }

    private final boolean h() {
        Context context;
        BaseApplication baseApplication = BaseApplication.context;
        if (baseApplication != null) {
            context = baseApplication.getApplicationContext();
        } else {
            context = null;
        }
        if (context == null) {
            return true;
        }
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(context, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(context, QMMKVFile.FILE_COMMON)");
        return fromV2.getBoolean("robot_ai_draw_revise_switch", true);
    }

    private final String i(Bundle data) {
        ArrayList<HashMap> arrayList;
        if (data == null) {
            return "";
        }
        try {
            Serializable serializable = data.getSerializable("item_data");
            ArrayList<HashMap> arrayList2 = null;
            if (serializable instanceof ArrayList) {
                arrayList = (ArrayList) serializable;
            } else {
                arrayList = null;
            }
            Serializable serializable2 = data.getSerializable("require_data");
            if (serializable2 instanceof ArrayList) {
                arrayList2 = (ArrayList) serializable2;
            }
            JSONObject jSONObject = new JSONObject();
            if (arrayList != null) {
                for (HashMap hashMap : arrayList) {
                    if (hashMap != null) {
                        for (Map.Entry entry : hashMap.entrySet()) {
                            jSONObject.put((String) entry.getKey(), entry.getValue());
                        }
                    }
                }
            }
            if (arrayList2 != null) {
                for (HashMap hashMap2 : arrayList2) {
                    if (hashMap2 != null) {
                        for (Map.Entry entry2 : hashMap2.entrySet()) {
                            jSONObject.put((String) entry2.getKey(), entry2.getValue());
                        }
                    }
                }
            }
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
            byte[] bytes = jSONObject2.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return Base64.encodeToString(bytes, 2);
        } catch (Exception e16) {
            QLog.w("AIOInputUtil", 1, "updateRobotCallbackData Exception:", e16);
            return "";
        }
    }

    private final boolean j() {
        return ((Boolean) vasInputTopMarginSwitch.getValue()).booleanValue();
    }

    private final Spannable m(Spannable cachedSpanned) {
        com.tencent.mobileqq.aio.input.fullscreen.a[] cachedImageSpanArray = (com.tencent.mobileqq.aio.input.fullscreen.a[]) cachedSpanned.getSpans(0, cachedSpanned.length(), com.tencent.mobileqq.aio.input.fullscreen.a.class);
        Intrinsics.checkNotNullExpressionValue(cachedImageSpanArray, "cachedImageSpanArray");
        for (com.tencent.mobileqq.aio.input.fullscreen.a aVar : cachedImageSpanArray) {
            cachedSpanned.removeSpan(aVar);
        }
        return cachedSpanned;
    }

    private final HashMap<String, Object> p(String data) {
        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            JSONObject q16 = q(data);
            if (q16 != null) {
                String optString = q16.optString("style");
                Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(ROBOT_DRAW_DATA_KEY_STYLE)");
                hashMap.put(QQWinkConstants.BUSINESS_MAIGC_STUDIO_STYLE_NAME, optString);
                String optString2 = q16.optString("size");
                Intrinsics.checkNotNullExpressionValue(optString2, "jsonObject.optString(ROBOT_DRAW_DATA_KEY_SIZE)");
                hashMap.put("ae_ratio", optString2);
            }
        } catch (Exception e16) {
            QLog.w("AIOInputUtil", 1, "resolveRobotDrawCallbackData Exception:", e16);
        }
        hashMap.put("is_auto_polish", Integer.valueOf(h() ? 1 : 0));
        return hashMap;
    }

    private final JSONObject q(String data) {
        try {
            byte[] contentBytes = Base64.decode(data, 2);
            Intrinsics.checkNotNullExpressionValue(contentBytes, "contentBytes");
            return new JSONObject(new String(contentBytes, Charsets.UTF_8));
        } catch (Exception e16) {
            QLog.w("AIOInputUtil", 1, "resolveRobotJsonData Exception:", e16);
            return null;
        }
    }

    private final HashMap<String, Object> r(String data) {
        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            JSONObject q16 = q(data);
            if (q16 != null) {
                Object remove = q16.remove("\u7c7b\u578b");
                if (remove != null) {
                    hashMap.put("writing_type", remove);
                }
                q16.remove("\u7ec4\u88c5\u6a21\u7248");
                String jSONObject = q16.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject, "jsonObject.toString()");
                hashMap.put("demand", jSONObject);
            }
        } catch (Exception e16) {
            QLog.w("AIOInputUtil", 1, "resolveRobotWriteCallbackData Exception:", e16);
        }
        return hashMap;
    }

    private final String t(String data, String styleData, String requireData) {
        JSONObject jSONObject;
        try {
            if (TextUtils.isEmpty(data)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(data);
            }
            if (!TextUtils.isEmpty(styleData)) {
                jSONObject.put("style", styleData);
            }
            if (!TextUtils.isEmpty(requireData)) {
                jSONObject.put("size", requireData);
            }
            jSONObject.put("revise", h());
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
            byte[] bytes = jSONObject2.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return Base64.encodeToString(bytes, 2);
        } catch (Exception e16) {
            QLog.w("AIOInputUtil", 1, "updateRobotCallbackData Exception:", e16);
            return data;
        }
    }

    public final int b(@NotNull com.tencent.aio.api.runtime.a aioContext) {
        d.j jVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) aioContext)).intValue();
        }
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        k k3 = aioContext.e().k(InputEvent.GetInputLineCount.f188572d);
        if (k3 instanceof d.j) {
            jVar = (d.j) k3;
        } else {
            jVar = null;
        }
        if (jVar != null) {
            return jVar.a();
        }
        return 0;
    }

    @Nullable
    public final CharSequence d() {
        String str;
        Spannable spannable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (CharSequence) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        String c16 = c();
        Pair<String, ? extends Spannable> pair = mCopyCacheSpannables;
        if (pair != null) {
            str = pair.getFirst();
        } else {
            str = null;
        }
        Pair<String, ? extends Spannable> pair2 = mCopyCacheSpannables;
        if (pair2 != null) {
            spannable = pair2.getSecond();
        } else {
            spannable = null;
        }
        if (str != null && spannable != null && Intrinsics.areEqual(str, c16)) {
            CharSequence e16 = e(spannable);
            if (QLog.isColorLevel()) {
                QLog.d("AIOInputUtil", 2, "getPasteMenu end");
            }
            return e16;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AIOInputUtil", 2, "setPasteMenu return, mCopyEditable not contains");
        }
        return null;
    }

    @Nullable
    public final String f(int businessFlag, @Nullable Bundle data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, businessFlag, (Object) data);
        }
        if (data == null) {
            return "";
        }
        if (businessFlag == 2) {
            return g(data);
        }
        if (businessFlag != 3) {
            return "";
        }
        return i(data);
    }

    public final boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("aio_inputbar_enable_copy_image_9020_120072911", true);
    }

    public final boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (QQTheme.isVasTheme() && j()) {
            return true;
        }
        return false;
    }

    public final void n(@Nullable String data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) data);
        } else {
            com.tencent.mobileqq.aio.utils.b.l("em_bas_ai_draw_floating_send", p(data));
        }
    }

    public final void o(@Nullable String data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) data);
        } else {
            com.tencent.mobileqq.aio.utils.b.l("em_bas_ai_writing_floating_send", r(data));
        }
    }

    public final void s(@Nullable Editable source, int startIndex, int endIndex) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, source, Integer.valueOf(startIndex), Integer.valueOf(endIndex));
            return;
        }
        CharSequence charSequence = source;
        if (source == null) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOInputUtil", 2, "setPasteMenu return, source is empty");
                return;
            }
            return;
        }
        if (startIndex >= 0) {
            int length = source.length();
            charSequence = source;
            if (endIndex <= length) {
                charSequence = source.subSequence(startIndex, endIndex);
            }
        }
        if (!(charSequence instanceof Spanned)) {
            return;
        }
        Spannable a16 = a((Spanned) charSequence);
        if (a16 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOInputUtil", 2, "setPasteMenu return, cachedSpanned is empty");
                return;
            }
            return;
        }
        mCopyCacheSpannables = new Pair<>(charSequence.toString(), a16);
    }
}
