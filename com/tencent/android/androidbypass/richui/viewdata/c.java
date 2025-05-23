package com.tencent.android.androidbypass.richui.viewdata;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00102\u001a\u000201\u00a2\u0006\u0004\b3\u00104J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J4\u0010\u0015\u001a\u00020\u00042*\u0010\u0014\u001a&\u0012\u0004\u0012\u00020\u0011\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00120\u0010j\u0012\u0012\u0004\u0012\u00020\u0011\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0012`\u0013H\u0016J4\u0010\u0016\u001a\u00020\u00042*\u0010\u0014\u001a&\u0012\u0004\u0012\u00020\u0011\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00120\u0010j\u0012\u0012\u0004\u0012\u00020\u0011\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0012`\u0013H\u0016R\u0016\u0010\u0019\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0018R\u0018\u0010\"\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010(\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010!R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00065"}, d2 = {"Lcom/tencent/android/androidbypass/richui/viewdata/c;", "Lcom/tencent/android/androidbypass/richui/viewdata/k;", "Lorg/json/JSONObject;", "dataJson", "", "w", "Landroid/content/Context;", "context", "Lcom/tencent/android/androidbypass/richui/view/i;", "viewDelegateFactory", "Lcom/tencent/android/androidbypass/richui/view/j;", "listener", "Landroid/view/View;", "f", "attrData", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/HashMap;", "", "Lcom/tencent/android/androidbypass/richui/view/h;", "Lkotlin/collections/HashMap;", "cache", "e", "d", "t", "Ljava/lang/String;", "text", "", "u", UserInfo.SEX_FEMALE, "textSize", "v", "textColor", "Lcom/tencent/android/androidbypass/richui/viewdata/h;", "Lcom/tencent/android/androidbypass/richui/viewdata/h;", "borderColorData", "", HippyTKDListViewAdapter.X, "I", NodeProps.BORDER_WIDTH, "y", "solidColorData", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/widget/TextView;", "textView", "Landroid/widget/FrameLayout;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/widget/FrameLayout;", "frameLayout", "Lcom/tencent/android/androidbypass/richui/f;", "options", "<init>", "(Lcom/tencent/android/androidbypass/richui/f;)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class c extends k {
    static IPatchRedirector $redirector_;

    /* renamed from: A, reason: from kotlin metadata */
    private FrameLayout frameLayout;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private String text;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private float textSize;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private String textColor;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private h borderColorData;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private int borderWidth;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private h solidColorData;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private TextView textView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull com.tencent.android.androidbypass.richui.f options) {
        super(options);
        Intrinsics.checkNotNullParameter(options, "options");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) options);
        } else {
            this.text = "";
            this.textColor = "";
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
        TextView textView = this.textView;
        if (textView != null) {
            if (attrData.has("text")) {
                String optString = attrData.optString("text");
                Intrinsics.checkNotNullExpressionValue(optString, "attrData.optString(TextViewNode.JSON_KEY_TEXT)");
                this.text = optString;
                textView.setText(optString);
            }
            if (attrData.has("textSize")) {
                float optInt = attrData.optInt("textSize");
                this.textSize = optInt;
                textView.setTextSize(optInt);
            }
            if (attrData.has("textColor")) {
                String optString2 = attrData.optString("textColor");
                Intrinsics.checkNotNullExpressionValue(optString2, "attrData.optString(TextV\u2026Node.JSON_KEY_TEXT_COLOR)");
                this.textColor = optString2;
                com.tencent.android.androidbypass.richui.utils.b bVar = com.tencent.android.androidbypass.richui.utils.b.f72344a;
                Context context = textView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "innerTextView.context");
                textView.setTextColor(com.tencent.android.androidbypass.richui.utils.b.c(bVar, context, this.textColor, null, 4, null));
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
        if (!(hVar instanceof com.tencent.android.androidbypass.richui.view.a)) {
            hVar = null;
        }
        com.tencent.android.androidbypass.richui.view.a aVar = (com.tencent.android.androidbypass.richui.view.a) hVar;
        if (aVar != null) {
            this.frameLayout = aVar.j();
            this.textView = aVar.k();
        }
    }

    @Override // com.tencent.android.androidbypass.richui.viewdata.k
    public void e(@NotNull HashMap<String, com.tencent.android.androidbypass.richui.view.h<?>> cache) {
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) cache);
            return;
        }
        Intrinsics.checkNotNullParameter(cache, "cache");
        FrameLayout frameLayout = this.frameLayout;
        if (frameLayout != null && (textView = this.textView) != null) {
            cache.put(q(), new com.tencent.android.androidbypass.richui.view.a(frameLayout, textView));
        }
        this.frameLayout = null;
        this.textView = null;
    }

    @Override // com.tencent.android.androidbypass.richui.viewdata.k
    @NotNull
    protected View f(@NotNull Context context, @NotNull com.tencent.android.androidbypass.richui.view.i viewDelegateFactory, @Nullable com.tencent.android.androidbypass.richui.view.j listener) {
        ColorStateList colorStateList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, context, viewDelegateFactory, listener);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewDelegateFactory, "viewDelegateFactory");
        TextView textView = this.textView;
        if (textView == null) {
            textView = new TextView(context);
        }
        textView.setText(this.text);
        float f16 = this.textSize;
        boolean z16 = false;
        if (f16 > 0) {
            textView.setTextSize(f16);
        }
        if (this.textColor.length() > 0) {
            z16 = true;
        }
        if (z16) {
            textView.setTextColor(com.tencent.android.androidbypass.richui.utils.b.c(com.tencent.android.androidbypass.richui.utils.b.f72344a, context, this.textColor, null, 4, null));
        }
        textView.setGravity(17);
        FrameLayout frameLayout = this.frameLayout;
        if (frameLayout == null) {
            frameLayout = new FrameLayout(context);
        }
        h hVar = this.solidColorData;
        ColorStateList colorStateList2 = null;
        if (hVar != null) {
            com.tencent.android.androidbypass.richui.utils.b bVar = com.tencent.android.androidbypass.richui.utils.b.f72344a;
            colorStateList = bVar.e(bVar.b(context, hVar.b(), "_button_").getDefaultColor(), bVar.b(context, hVar.a(), "_button_").getDefaultColor());
        } else {
            colorStateList = null;
        }
        h hVar2 = this.borderColorData;
        if (hVar2 != null) {
            com.tencent.android.androidbypass.richui.utils.b bVar2 = com.tencent.android.androidbypass.richui.utils.b.f72344a;
            colorStateList2 = bVar2.e(bVar2.b(context, hVar2.b(), "_button_").getDefaultColor(), bVar2.b(context, hVar2.a(), "_button_").getDefaultColor());
        }
        if (colorStateList != null) {
            frameLayout.setBackground(com.tencent.android.androidbypass.richui.utils.b.f72344a.d(colorStateList2, colorStateList, vt.a.a(context, this.borderWidth), vt.a.b(context, p())));
        }
        frameLayout.removeAllViews();
        frameLayout.addView(textView);
        return frameLayout;
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
        this.text = v(a16, dataJson, "text");
        this.textSize = a16.optInt("textSize");
        String optString = a16.optString("textColor");
        Intrinsics.checkNotNullExpressionValue(optString, "attrData.optString(TextV\u2026Node.JSON_KEY_TEXT_COLOR)");
        this.textColor = optString;
        this.borderWidth = a16.optInt(NodeProps.BORDER_WIDTH);
        if (a16.has("border")) {
            com.tencent.android.androidbypass.richui.utils.b bVar = com.tencent.android.androidbypass.richui.utils.b.f72344a;
            JSONObject jSONObject = a16.getJSONObject("border");
            Intrinsics.checkNotNullExpressionValue(jSONObject, "attrData.getJSONObject(C\u2026onstants.JSON_KEY_BORDER)");
            this.borderColorData = bVar.f(jSONObject);
        }
        if (a16.has("solid")) {
            com.tencent.android.androidbypass.richui.utils.b bVar2 = com.tencent.android.androidbypass.richui.utils.b.f72344a;
            JSONObject jSONObject2 = a16.getJSONObject("solid");
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "attrData.getJSONObject(C\u2026Constants.JSON_KEY_SOLID)");
            this.solidColorData = bVar2.f(jSONObject2);
        }
    }
}
