package com.tencent.android.androidbypass.richui.viewdata;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010+\u001a\u00020*\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\"\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J4\u0010\u0019\u001a\u00020\b2*\u0010\u0018\u001a&\u0012\u0004\u0012\u00020\u0015\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00160\u0014j\u0012\u0012\u0004\u0012\u00020\u0015\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0016`\u0017H\u0016J4\u0010\u001a\u001a\u00020\b2*\u0010\u0018\u001a&\u0012\u0004\u0012\u00020\u0015\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00160\u0014j\u0012\u0012\u0004\u0012\u00020\u0015\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0016`\u0017H\u0016R\u0016\u0010\u001d\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\"\u0010)\u001a\u00020$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010%\u001a\u0004\b&\u0010'\"\u0004\b%\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/android/androidbypass/richui/viewdata/f;", "Lcom/tencent/android/androidbypass/richui/viewdata/k;", "", "scaleType", "Landroid/widget/ImageView$ScaleType;", "E", "Lorg/json/JSONObject;", "dataJson", "", "w", "Landroid/content/Context;", "context", "Lcom/tencent/android/androidbypass/richui/view/i;", "viewDelegateFactory", "Lcom/tencent/android/androidbypass/richui/view/j;", "listener", "Landroid/view/View;", "f", "attrData", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/HashMap;", "", "Lcom/tencent/android/androidbypass/richui/view/h;", "Lkotlin/collections/HashMap;", "cache", "e", "d", "t", "Ljava/lang/String;", "src", "Lcom/tencent/android/androidbypass/richui/view/e;", "u", "Lcom/tencent/android/androidbypass/richui/view/e;", "imageDelegate", "v", "I", "", UserInfo.SEX_FEMALE, "getRatio", "()F", "(F)V", "ratio", "Lcom/tencent/android/androidbypass/richui/f;", "options", "<init>", "(Lcom/tencent/android/androidbypass/richui/f;)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class f extends k {
    static IPatchRedirector $redirector_;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private String src;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private com.tencent.android.androidbypass.richui.view.e imageDelegate;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private int scaleType;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private float ratio;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull com.tencent.android.androidbypass.richui.f options) {
        super(options);
        Intrinsics.checkNotNullParameter(options, "options");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) options);
        } else {
            this.src = "";
            this.scaleType = 2;
        }
    }

    private final ImageView.ScaleType E(int scaleType) {
        if (scaleType != 0) {
            if (scaleType != 1) {
                if (scaleType != 2) {
                    if (scaleType != 4) {
                        return ImageView.ScaleType.CENTER_CROP;
                    }
                    return ImageView.ScaleType.CENTER;
                }
                return ImageView.ScaleType.CENTER_CROP;
            }
            return ImageView.ScaleType.FIT_CENTER;
        }
        return ImageView.ScaleType.FIT_XY;
    }

    @Override // com.tencent.android.androidbypass.richui.viewdata.k
    public void C(@NotNull JSONObject attrData) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) attrData);
            return;
        }
        Intrinsics.checkNotNullParameter(attrData, "attrData");
        super.C(attrData);
        com.tencent.android.androidbypass.richui.view.e eVar = this.imageDelegate;
        if (eVar != null) {
            if (attrData.has("src") || attrData.has("contentMode")) {
                String optString = attrData.optString("src", this.src);
                Intrinsics.checkNotNullExpressionValue(optString, "attrData.optString(JSON_KEY_SRC, src)");
                this.src = optString;
                this.scaleType = attrData.optInt("contentMode", this.scaleType);
                if (this.src.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    eVar.c(this.src, E(this.scaleType));
                } else {
                    eVar.getTextView().setImageDrawable(null);
                }
            }
        }
    }

    public final void F(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16));
        } else {
            this.ratio = f16;
        }
    }

    @Override // com.tencent.android.androidbypass.richui.viewdata.k
    public void d(@NotNull HashMap<String, com.tencent.android.androidbypass.richui.view.h<?>> cache) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) cache);
            return;
        }
        Intrinsics.checkNotNullParameter(cache, "cache");
        com.tencent.android.androidbypass.richui.view.h<?> hVar = cache.get(q());
        if (!(hVar instanceof com.tencent.android.androidbypass.richui.view.e)) {
            hVar = null;
        }
        this.imageDelegate = (com.tencent.android.androidbypass.richui.view.e) hVar;
    }

    @Override // com.tencent.android.androidbypass.richui.viewdata.k
    public void e(@NotNull HashMap<String, com.tencent.android.androidbypass.richui.view.h<?>> cache) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) cache);
            return;
        }
        Intrinsics.checkNotNullParameter(cache, "cache");
        com.tencent.android.androidbypass.richui.view.e eVar = this.imageDelegate;
        if (eVar != null) {
            cache.put(q(), eVar);
        }
        this.imageDelegate = null;
    }

    @Override // com.tencent.android.androidbypass.richui.viewdata.k
    @NotNull
    protected View f(@NotNull Context context, @NotNull com.tencent.android.androidbypass.richui.view.i viewDelegateFactory, @Nullable com.tencent.android.androidbypass.richui.view.j listener) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, this, context, viewDelegateFactory, listener);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewDelegateFactory, "viewDelegateFactory");
        com.tencent.android.androidbypass.richui.view.e eVar = this.imageDelegate;
        if (eVar == null) {
            eVar = viewDelegateFactory.b(context);
        }
        if (this.src.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            eVar.c(this.src, E(this.scaleType));
        } else {
            eVar.getTextView().setImageDrawable(null);
        }
        this.imageDelegate = eVar;
        eVar.i(this.ratio, r(), m());
        eVar.e(vt.a.a(context, p()), 1);
        return eVar.getTextView();
    }

    @Override // com.tencent.android.androidbypass.richui.viewdata.k
    public void w(@NotNull JSONObject dataJson) {
        String v3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) dataJson);
            return;
        }
        Intrinsics.checkNotNullParameter(dataJson, "dataJson");
        super.w(dataJson);
        JSONObject a16 = o().a();
        JSONObject c16 = o().c();
        if (o().e() != null) {
            v3 = o().e().a(q(), "src", v(a16, dataJson, "src"));
        } else {
            v3 = v(a16, dataJson, "src");
        }
        this.src = v3;
        this.scaleType = a16.optInt("contentMode", this.scaleType);
        this.ratio = (float) c16.optDouble("ratio", 0.0d);
    }
}
