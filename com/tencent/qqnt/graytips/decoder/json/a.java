package com.tencent.qqnt.graytips.decoder.json;

import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.aio.nick.api.INickNameApi;
import com.tencent.qqnt.graytips.action.f;
import com.tencent.qqnt.graytips.action.h;
import com.tencent.qqnt.graytips.action.k;
import com.tencent.qqnt.graytips.action.p;
import com.tencent.qqnt.graytips.action.u;
import com.tencent.qqnt.graytips.c;
import com.tencent.qqnt.graytips.util.h;
import com.tencent.qqnt.kernelpublic.nativeinterface.JsonGrayElement;
import com.tencent.xweb.FileReaderHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u000e\u001aB\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ<\u0010\u000e\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0014\u001a\u00020\u0013J\u0010\u0010\u001a\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/qqnt/graytips/decoder/json/a;", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "resultBuilder", "", "text", "Landroid/text/TextPaint;", "textPaint", "", "width", NodeProps.MAX_WIDTH, "", "isHighLight", "a", "Lorg/json/JSONObject;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "f", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/JsonGrayElement;", DTConstants.TAG.ELEMENT, "Lcom/tencent/qqnt/graytips/decoder/json/a$a;", "e", "Lcom/tencent/qqnt/graytips/decoder/json/a$b;", "d", "alignStr", "b", "", "c", "<init>", "()V", "graytips_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f356837a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0003\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/graytips/decoder/json/a$a;", "", "", "a", "I", "getActionType", "()I", "actionType", "Lcom/tencent/qqnt/graytips/action/f;", "b", "Lcom/tencent/qqnt/graytips/action/f;", "()Lcom/tencent/qqnt/graytips/action/f;", "actionInfo", "<init>", "(ILcom/tencent/qqnt/graytips/action/f;)V", "graytips_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.graytips.decoder.json.a$a, reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public static final class C9626a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int actionType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final f actionInfo;

        public C9626a(int i3, @Nullable f fVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) fVar);
            } else {
                this.actionType = i3;
                this.actionInfo = fVar;
            }
        }

        @Nullable
        public final f a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (f) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.actionInfo;
        }

        public /* synthetic */ C9626a(int i3, f fVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? -1 : i3, (i16 & 2) != 0 ? null : fVar);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), fVar, Integer.valueOf(i16), defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0010\u0012\u0016\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001c\u00a2\u0006\u0004\b#\u0010$R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\t\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0012\u001a\u0004\b\u0003\u0010\u0013\"\u0004\b\u0018\u0010\u0015R2\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/qqnt/graytips/decoder/json/a$b;", "", "Landroid/text/SpannableStringBuilder;", "a", "Landroid/text/SpannableStringBuilder;", "c", "()Landroid/text/SpannableStringBuilder;", "content", "", "b", "I", "d", "()I", "setGravity", "(I)V", LayoutAttrDefine.Gravity.Gravity, "", "Landroid/text/style/ClickableSpan;", "Ljava/util/List;", "()Ljava/util/List;", "setClickableSpans", "(Ljava/util/List;)V", "clickableSpans", "Lcom/tencent/qqnt/graytips/span/b;", "setAioInteractions", "aioInteractions", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/graytips/c;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "setHighlightItems", "(Ljava/util/ArrayList;)V", "highlightItems", "<init>", "(Landroid/text/SpannableStringBuilder;ILjava/util/List;Ljava/util/List;Ljava/util/ArrayList;)V", "graytips_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final SpannableStringBuilder content;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int gravity;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private List<? extends ClickableSpan> clickableSpans;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private List<? extends com.tencent.qqnt.graytips.span.b> aioInteractions;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private ArrayList<c> highlightItems;

        public b(@NotNull SpannableStringBuilder content, int i3, @Nullable List<? extends ClickableSpan> list, @Nullable List<? extends com.tencent.qqnt.graytips.span.b> list2, @NotNull ArrayList<c> highlightItems) {
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(highlightItems, "highlightItems");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, content, Integer.valueOf(i3), list, list2, highlightItems);
                return;
            }
            this.content = content;
            this.gravity = i3;
            this.clickableSpans = list;
            this.aioInteractions = list2;
            this.highlightItems = highlightItems;
        }

        @Nullable
        public final List<com.tencent.qqnt.graytips.span.b> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (List) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return this.aioInteractions;
        }

        @Nullable
        public final List<ClickableSpan> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (List) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.clickableSpans;
        }

        @NotNull
        public final SpannableStringBuilder c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (SpannableStringBuilder) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.content;
        }

        public final int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.gravity;
        }

        @NotNull
        public final ArrayList<c> e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (ArrayList) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return this.highlightItems;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30548);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f356837a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final float a(StringBuilder resultBuilder, String text, TextPaint textPaint, float width, float maxWidth, boolean isHighLight) {
        if (TextUtils.isEmpty(text)) {
            return maxWidth;
        }
        float measureText = textPaint.measureText(text);
        float f16 = width + measureText;
        if (f16 > maxWidth) {
            if (isHighLight) {
                resultBuilder.append("\n" + text);
                return measureText;
            }
            resultBuilder.append(text);
            return f16 - maxWidth;
        }
        resultBuilder.append(text);
        return f16;
    }

    private final C9626a e(JSONObject item, JsonGrayElement element) {
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean startsWith$default3;
        com.tencent.qqnt.graytips.handler.b a16;
        String value = item.optString("jp");
        Intrinsics.checkNotNullExpressionValue(value, "value");
        int i3 = 0;
        f fVar = null;
        byte b16 = 0;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(value, "http://", false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(value, "https://", false, 2, null);
            if (!startsWith$default2) {
                startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(value, "mqq", false, 2, null);
                int i16 = 3;
                if (startsWith$default3) {
                    return new C9626a(3, new k(value));
                }
                int optInt = item.optInt("jp", -1);
                if (optInt > 0) {
                    String optString = item.optString("param");
                    if (optString == null) {
                        optString = "";
                    }
                    h hVar = new h(optInt, optString, element);
                    return new C9626a(hVar.getActionType(), hVar);
                }
                int optInt2 = item.optInt("local_jp", -1);
                JSONObject optJSONObject = item.optJSONObject("param");
                if (optInt2 > 0 && optJSONObject != null && (a16 = com.tencent.qqnt.graytips.b.a(optInt2)) != null) {
                    return new C9626a(optInt2, a16.a(optJSONObject));
                }
                return new C9626a(i3, fVar, i16, b16 == true ? 1 : 0);
            }
        }
        return new C9626a(1, new u(value));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0010. Please report as an issue. */
    private final int f(JSONObject item) {
        String optString = item.optString("col", "1");
        if (optString != null) {
            switch (optString.hashCode()) {
                case 50:
                    if (optString.equals("2")) {
                        return 2;
                    }
                    break;
                case 51:
                    if (optString.equals("3")) {
                        return 3;
                    }
                    break;
                case 52:
                    if (optString.equals("4")) {
                        return 4;
                    }
                    break;
            }
        }
        return 1;
    }

    public final int b(@Nullable String alignStr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) alignStr)).intValue();
        }
        if (alignStr == null) {
            return 17;
        }
        switch (alignStr.hashCode()) {
            case -1383228885:
                if (alignStr.equals("bottom")) {
                    return 80;
                }
                break;
            case -1364013995:
                alignStr.equals("center");
                break;
            case 115029:
                if (alignStr.equals("top")) {
                    return 48;
                }
                break;
            case 3317767:
                if (alignStr.equals("left")) {
                    return 3;
                }
                break;
            case 108511772:
                if (alignStr.equals("right")) {
                    return 5;
                }
                break;
        }
        return 17;
    }

    @NotNull
    public final CharSequence c(@Nullable CharSequence text) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CharSequence) iPatchRedirector.redirect((short) 4, (Object) this, (Object) text);
        }
        if (text != null && text.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return "0|0";
        }
        return text.charAt(0) + "|" + text.length();
    }

    /* JADX WARN: Removed duplicated region for block: B:84:0x029a A[Catch: JSONException -> 0x02ed, TryCatch #0 {JSONException -> 0x02ed, blocks: (B:13:0x0050, B:16:0x0071, B:18:0x00ae, B:19:0x00b5, B:21:0x00c2, B:23:0x00c8, B:25:0x00d1, B:37:0x02b8, B:38:0x0101, B:41:0x010b, B:43:0x0155, B:46:0x0167, B:48:0x0178, B:49:0x017c, B:52:0x0186, B:54:0x019b, B:57:0x01a8, B:60:0x01bd, B:62:0x01ca, B:63:0x01d1, B:64:0x0202, B:66:0x021c, B:70:0x0234, B:73:0x0246, B:76:0x0257, B:78:0x0271, B:82:0x027b, B:84:0x029a, B:88:0x0250, B:89:0x023f, B:90:0x022e, B:94:0x02cc), top: B:12:0x0050 }] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final b d(@NotNull JsonGrayElement element) {
        String str;
        JSONArray jSONArray;
        int i3;
        int i16;
        String str2;
        String str3;
        float f16;
        String optString;
        String str4;
        String str5;
        String str6;
        int i17;
        int i18;
        boolean z16;
        JsonGrayElement element2 = element;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this, (Object) element2);
        }
        Intrinsics.checkNotNullParameter(element2, "element");
        if (TextUtils.isEmpty(element2.jsonStr)) {
            return null;
        }
        QLog.d("JsonGrayTipsUtils", 1, "busID " + element2.busiId + " desc " + ((Object) c(element2.recentAbstract)));
        try {
            JSONObject jSONObject = new JSONObject(element2.jsonStr);
            int b16 = b(jSONObject.optString("align"));
            StringBuilder sb5 = new StringBuilder();
            JSONArray optJSONArray = jSONObject.optJSONArray("items");
            if (optJSONArray == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            TextPaint textPaint = new TextPaint();
            textPaint.setTextSize(ViewUtils.dpToPx(12.0f));
            float f17 = e.f194142a.f() - ViewUtils.dpToPx(72.0f);
            String string = BaseApplication.context.getResources().getString(R.string.f214145s4);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026R.string.qqstr_self_nick)");
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str = peekAppRuntime.getCurrentUid();
            } else {
                str = null;
            }
            int length = optJSONArray.length();
            float f18 = 0.0f;
            int i19 = 0;
            while (i19 < length) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i19);
                if (optJSONObject != null && (optString = optJSONObject.optString("type")) != null) {
                    Intrinsics.checkNotNullExpressionValue(optString, "optString(JsonGrayTipConstants.KEY_TYPE)");
                    int hashCode = optString.hashCode();
                    if (hashCode != 3616) {
                        if (hashCode != 104387) {
                            jSONArray = optJSONArray;
                            i3 = i19;
                            if (hashCode != 109265) {
                                if (hashCode == 116079 && optString.equals("url")) {
                                    int length2 = sb5.length();
                                    String text = com.tencent.qqnt.graytips.util.f.a(optJSONObject.optString(FileReaderHelper.TXT_EXT));
                                    a aVar = f356837a;
                                    Intrinsics.checkNotNullExpressionValue(text, "text");
                                    i16 = length;
                                    f16 = f17;
                                    float a16 = aVar.a(sb5, text, textPaint, f18, f17, true);
                                    arrayList.add(new c(length2, sb5.length(), aVar.f(optJSONObject), aVar.e(optJSONObject, element2).a()));
                                    f18 = a16;
                                    str3 = string;
                                    str2 = str;
                                }
                                i16 = length;
                                str4 = str;
                                str5 = string;
                                f16 = f17;
                            } else {
                                i16 = length;
                                str4 = str;
                                str5 = string;
                                f16 = f17;
                                if (optString.equals("nor")) {
                                    String optString2 = optJSONObject.optString(FileReaderHelper.TXT_EXT);
                                    int length3 = sb5.length();
                                    a aVar2 = f356837a;
                                    int f19 = aVar2.f(optJSONObject);
                                    if (f19 != 1) {
                                        optString2 = com.tencent.qqnt.graytips.util.f.a(optString2);
                                    }
                                    String text2 = optString2;
                                    Intrinsics.checkNotNullExpressionValue(text2, "text");
                                    if (f19 != 1) {
                                        z16 = true;
                                    } else {
                                        z16 = false;
                                    }
                                    float a17 = aVar2.a(sb5, text2, textPaint, f18, f16, z16);
                                    int length4 = sb5.length();
                                    if (f19 != 1) {
                                        arrayList.add(new c(length3, length4, f19, null));
                                    }
                                    f18 = a17;
                                }
                            }
                        } else {
                            jSONArray = optJSONArray;
                            i3 = i19;
                            i16 = length;
                            str4 = str;
                            str5 = string;
                            f16 = f17;
                            if (optString.equals("img")) {
                                f18 += ViewUtils.dpToPx(16.0f);
                                if (f18 > f16) {
                                    f18 = ViewUtils.dpToPx(16.0f);
                                }
                                int length5 = sb5.length();
                                sb5.append("icon");
                                arrayList.add(new c(length5, sb5.length(), optJSONObject.optString("src"), optJSONObject.optString(QCircleSchemeAttr.Polymerize.ALT), f356837a.e(optJSONObject, element2).a()));
                            }
                        }
                        str3 = str5;
                        str2 = str4;
                    } else {
                        jSONArray = optJSONArray;
                        i3 = i19;
                        i16 = length;
                        str4 = str;
                        str5 = string;
                        f16 = f17;
                        if (optString.equals("qq")) {
                            int length6 = sb5.length();
                            String optString3 = optJSONObject.optString("uid");
                            String str7 = "";
                            if (optString3 == null) {
                                optString3 = "";
                            } else {
                                Intrinsics.checkNotNullExpressionValue(optString3, "item.optString(JsonGrayTipConstants.KEY_UID) ?: \"\"");
                            }
                            String optString4 = optJSONObject.optString("uin");
                            if (optString4 == null) {
                                str6 = "";
                            } else {
                                Intrinsics.checkNotNullExpressionValue(optString4, "item.optString(JsonGrayTipConstants.KEY_UIN) ?: \"\"");
                                str6 = optString4;
                            }
                            String optString5 = optJSONObject.optString("nm");
                            if (optString5 != null) {
                                Intrinsics.checkNotNullExpressionValue(optString5, "item.optString(JsonGrayT\u2026Constants.KEY_NAME) ?: \"\"");
                                str7 = optString5;
                            }
                            String obj = ((INickNameApi) QRoute.api(INickNameApi.class)).getPurePlainText(str7, true).toString();
                            if (!Intrinsics.areEqual(str5, obj) && !Intrinsics.areEqual(str4, optString3)) {
                                i17 = 3;
                                i18 = i17;
                                str2 = str4;
                                str3 = str5;
                                String str8 = str6;
                                float a18 = f356837a.a(sb5, obj, textPaint, f18, f16, true);
                                int length7 = sb5.length();
                                if (i18 == 3) {
                                    arrayList.add(new c(length6, length7, i18, new p(optString3, obj, str8)));
                                }
                                f18 = a18;
                            }
                            i17 = 1;
                            i18 = i17;
                            str2 = str4;
                            str3 = str5;
                            String str82 = str6;
                            float a182 = f356837a.a(sb5, obj, textPaint, f18, f16, true);
                            int length72 = sb5.length();
                            if (i18 == 3) {
                            }
                            f18 = a182;
                        }
                        str3 = str5;
                        str2 = str4;
                    }
                } else {
                    jSONArray = optJSONArray;
                    i3 = i19;
                    i16 = length;
                    str2 = str;
                    str3 = string;
                    f16 = f17;
                }
                i19 = i3 + 1;
                element2 = element;
                optJSONArray = jSONArray;
                length = i16;
                str = str2;
                f17 = f16;
                string = str3;
            }
            h.a c16 = com.tencent.qqnt.graytips.util.h.c(sb5, arrayList, true);
            Intrinsics.checkNotNullExpressionValue(c16, "getHighlightMsgText(ssb, highlightItems, true)");
            SpannableStringBuilder spannableStringBuilder = c16.f356916a;
            Intrinsics.checkNotNullExpressionValue(spannableStringBuilder, "result.ssbContent");
            return new b(spannableStringBuilder, b16, c16.f356917b, c16.f356918c, arrayList);
        } catch (JSONException e16) {
            QLog.d("JsonGrayTipsUtils", 1, "parse Json error", e16);
            return null;
        }
    }
}
