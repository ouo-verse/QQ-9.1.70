package com.tencent.android.androidbypass.richui.viewdata;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 32\u00020\u0001:\u00014B\u000f\u0012\u0006\u00100\u001a\u00020/\u00a2\u0006\u0004\b1\u00102J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\"\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J4\u0010\u0018\u001a\u00020\u00072*\u0010\u0017\u001a&\u0012\u0004\u0012\u00020\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0013j\u0012\u0012\u0004\u0012\u00020\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0015`\u0016H\u0016J4\u0010\u0019\u001a\u00020\u00072*\u0010\u0017\u001a&\u0012\u0004\u0012\u00020\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0013j\u0012\u0012\u0004\u0012\u00020\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0015`\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0007H\u0016R\u0016\u0010\u001d\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001eR\u0016\u0010!\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001cR\u0018\u0010$\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010#R\u0016\u0010&\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010\u001eR\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010\u001eR\u0016\u0010.\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010\u001e\u00a8\u00065"}, d2 = {"Lcom/tencent/android/androidbypass/richui/viewdata/i;", "Lcom/tencent/android/androidbypass/richui/viewdata/k;", "Lorg/json/JSONObject;", "jsonObject", "", "E", "dataJson", "", "w", "Landroid/content/Context;", "context", "Lcom/tencent/android/androidbypass/richui/view/i;", "viewDelegateFactory", "Lcom/tencent/android/androidbypass/richui/view/j;", "listener", "Landroid/view/View;", "f", "attrData", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/HashMap;", "", "Lcom/tencent/android/androidbypass/richui/view/h;", "Lkotlin/collections/HashMap;", "cache", "e", "d", "u", "t", "Ljava/lang/String;", "text", "I", "textSize", "v", "textColor", "Lcom/tencent/android/androidbypass/richui/view/g;", "Lcom/tencent/android/androidbypass/richui/view/g;", "textViewDelegate", HippyTKDListViewAdapter.X, "maxLine", "", "y", "Z", "fontBold", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "textGravity", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, NodeProps.MIN_HEIGHT, "Lcom/tencent/android/androidbypass/richui/f;", "options", "<init>", "(Lcom/tencent/android/androidbypass/richui/f;)V", "B", "a", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class i extends k {
    static IPatchRedirector $redirector_;

    /* renamed from: B, reason: from kotlin metadata */
    public static final Companion INSTANCE;

    /* renamed from: A, reason: from kotlin metadata */
    private int minHeight;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private String text;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private int textSize;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private String textColor;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private com.tencent.android.androidbypass.richui.view.g textViewDelegate;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private int maxLine;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private boolean fontBold;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private int textGravity;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0004\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/android/androidbypass/richui/viewdata/i$a;", "", "", "JSON_KEY_FONT_BOLD", "Ljava/lang/String;", "JSON_KEY_GRAVITY", "JSON_KEY_MAX_LINE", "JSON_KEY_MIN_HEIGHT", "JSON_KEY_TEXT", "JSON_KEY_TEXT_COLOR", "JSON_KEY_TEXT_SIZE", "TEXT_GRAVITY_BOTTOM", "TEXT_GRAVITY_CENTER", "TEXT_GRAVITY_CENTER_HORIZONTAL", "TEXT_GRAVITY_CENTER_VERTICAL", "TEXT_GRAVITY_RIGHT", "TEXT_SEPARATOR", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.android.androidbypass.richui.viewdata.i$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19054);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NotNull com.tencent.android.androidbypass.richui.f options) {
        super(options);
        Intrinsics.checkNotNullParameter(options, "options");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) options);
            return;
        }
        this.text = "";
        this.textColor = "";
        this.textGravity = 16;
    }

    private final int E(JSONObject jsonObject) {
        String optString = jsonObject.optString("textGravity");
        if (optString == null) {
            return 16;
        }
        switch (optString.hashCode()) {
            case -1383228885:
                if (!optString.equals("bottom")) {
                    return 16;
                }
                return 80;
            case -1364013995:
                if (!optString.equals("center")) {
                    return 16;
                }
                return 17;
            case -266695079:
                if (!optString.equals(LayoutAttrDefine.CENTER_HORIZONTAL)) {
                    return 16;
                }
                return 1;
            case 108511772:
                if (!optString.equals("right")) {
                    return 16;
                }
                return 5;
            case 762737387:
                optString.equals(LayoutAttrDefine.CENTER_VERTICAL);
                return 16;
            default:
                return 16;
        }
    }

    @Override // com.tencent.android.androidbypass.richui.viewdata.k
    public void C(@NotNull JSONObject attrData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) attrData);
            return;
        }
        Intrinsics.checkNotNullParameter(attrData, "attrData");
        super.C(attrData);
        com.tencent.android.androidbypass.richui.view.g gVar = this.textViewDelegate;
        if (gVar != null) {
            TextView textView = gVar.getTextView();
            if (attrData.has("textSize")) {
                int optInt = attrData.optInt("textSize");
                this.textSize = optInt;
                textView.setTextSize(optInt);
            }
            if (attrData.has("text")) {
                String optString = attrData.optString("text");
                Intrinsics.checkNotNullExpressionValue(optString, "attrData.optString(JSON_KEY_TEXT)");
                this.text = optString;
                gVar.h(optString, this.textSize);
            }
            if (attrData.has("textColor")) {
                String optString2 = attrData.optString("textColor");
                Intrinsics.checkNotNullExpressionValue(optString2, "attrData.optString(JSON_KEY_TEXT_COLOR)");
                this.textColor = optString2;
                com.tencent.android.androidbypass.richui.utils.b bVar = com.tencent.android.androidbypass.richui.utils.b.f72344a;
                Context context = textView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "textView.context");
                textView.setTextColor(com.tencent.android.androidbypass.richui.utils.b.c(bVar, context, this.textColor, null, 4, null));
            }
            if (attrData.has("maxLine")) {
                int optInt2 = attrData.optInt("maxLine");
                this.maxLine = optInt2;
                if (optInt2 > 0) {
                    textView.setMaxLines(optInt2);
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                }
            }
            if (attrData.has("fontBold")) {
                boolean optBoolean = attrData.optBoolean("fontBold");
                this.fontBold = optBoolean;
                if (optBoolean) {
                    textView.setTypeface(Typeface.DEFAULT_BOLD);
                } else {
                    textView.setTypeface(Typeface.DEFAULT);
                }
            }
        }
    }

    @Override // com.tencent.android.androidbypass.richui.viewdata.k
    public void d(@NotNull HashMap<String, com.tencent.android.androidbypass.richui.view.h<?>> cache) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) cache);
            return;
        }
        Intrinsics.checkNotNullParameter(cache, "cache");
        com.tencent.android.androidbypass.richui.view.h<?> hVar = cache.get(q());
        if (!(hVar instanceof com.tencent.android.androidbypass.richui.view.g)) {
            hVar = null;
        }
        this.textViewDelegate = (com.tencent.android.androidbypass.richui.view.g) hVar;
    }

    @Override // com.tencent.android.androidbypass.richui.viewdata.k
    public void e(@NotNull HashMap<String, com.tencent.android.androidbypass.richui.view.h<?>> cache) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) cache);
            return;
        }
        Intrinsics.checkNotNullParameter(cache, "cache");
        com.tencent.android.androidbypass.richui.view.g gVar = this.textViewDelegate;
        if (gVar != null) {
            cache.put(q(), gVar);
        }
        this.textViewDelegate = null;
    }

    @Override // com.tencent.android.androidbypass.richui.viewdata.k
    @NotNull
    protected View f(@NotNull Context context, @NotNull com.tencent.android.androidbypass.richui.view.i viewDelegateFactory, @Nullable com.tencent.android.androidbypass.richui.view.j listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, context, viewDelegateFactory, listener);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewDelegateFactory, "viewDelegateFactory");
        com.tencent.android.androidbypass.richui.view.g gVar = this.textViewDelegate;
        if (gVar == null) {
            gVar = viewDelegateFactory.e(context);
        }
        TextView textView = gVar.getTextView();
        boolean z16 = false;
        textView.setIncludeFontPadding(false);
        gVar.h(this.text, this.textSize);
        int i3 = this.textSize;
        if (i3 > 0) {
            textView.setTextSize(i3);
        }
        if (this.textColor.length() > 0) {
            z16 = true;
        }
        if (z16) {
            textView.setTextColor(com.tencent.android.androidbypass.richui.utils.b.c(com.tencent.android.androidbypass.richui.utils.b.f72344a, context, this.textColor, null, 4, null));
        }
        int i16 = this.maxLine;
        if (i16 > 0) {
            textView.setMaxLines(i16);
            textView.setEllipsize(TextUtils.TruncateAt.END);
        }
        if (this.fontBold) {
            textView.setTypeface(Typeface.DEFAULT_BOLD);
        }
        int i17 = this.minHeight;
        if (i17 > 0) {
            textView.setMinHeight(vt.a.a(context, i17));
        }
        textView.setGravity(this.textGravity);
        this.textViewDelegate = gVar;
        return gVar.getTextView();
    }

    @Override // com.tencent.android.androidbypass.richui.viewdata.k
    public void u() {
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.u();
        com.tencent.android.androidbypass.richui.view.g gVar = this.textViewDelegate;
        if (gVar != null && (textView = gVar.getTextView()) != null) {
            com.tencent.android.androidbypass.richui.utils.b bVar = com.tencent.android.androidbypass.richui.utils.b.f72344a;
            Context context = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "it.context");
            textView.setTextColor(com.tencent.android.androidbypass.richui.utils.b.c(bVar, context, this.textColor, null, 4, null));
        }
    }

    @Override // com.tencent.android.androidbypass.richui.viewdata.k
    public void w(@NotNull JSONObject dataJson) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dataJson);
            return;
        }
        Intrinsics.checkNotNullParameter(dataJson, "dataJson");
        super.w(dataJson);
        JSONObject a16 = o().a();
        this.text = com.tencent.android.androidbypass.richui.utils.a.f72343a.a(a16, dataJson, "text");
        this.textSize = a16.optInt("textSize");
        String optString = a16.optString("textColor");
        Intrinsics.checkNotNullExpressionValue(optString, "attrData.optString(JSON_KEY_TEXT_COLOR)");
        this.textColor = optString;
        this.maxLine = a16.optInt("maxLine");
        this.fontBold = a16.optBoolean("fontBold", false);
        this.textGravity = E(a16);
        this.minHeight = a16.optInt(NodeProps.MIN_HEIGHT);
    }
}
