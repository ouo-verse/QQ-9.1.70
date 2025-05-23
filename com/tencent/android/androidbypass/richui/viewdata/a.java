package com.tencent.android.androidbypass.richui.viewdata;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J4\u0010\u0015\u001a\u00020\u00042*\u0010\u0014\u001a&\u0012\u0004\u0012\u00020\u0011\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00120\u0010j\u0012\u0012\u0004\u0012\u00020\u0011\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0012`\u0013H\u0016J4\u0010\u0016\u001a\u00020\u00042*\u0010\u0014\u001a&\u0012\u0004\u0012\u00020\u0011\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00120\u0010j\u0012\u0012\u0004\u0012\u00020\u0011\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0012`\u0013H\u0016R\u0016\u0010\u0019\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006$"}, d2 = {"Lcom/tencent/android/androidbypass/richui/viewdata/a;", "Lcom/tencent/android/androidbypass/richui/viewdata/k;", "Lorg/json/JSONObject;", "dataJson", "", "w", "Landroid/content/Context;", "context", "Lcom/tencent/android/androidbypass/richui/view/i;", "viewDelegateFactory", "Lcom/tencent/android/androidbypass/richui/view/j;", "listener", "Landroid/view/View;", "f", "attrData", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/HashMap;", "", "Lcom/tencent/android/androidbypass/richui/view/h;", "Lkotlin/collections/HashMap;", "cache", "e", "d", "t", "Ljava/lang/String;", "uin", "Lcom/tencent/android/androidbypass/richui/view/c;", "u", "Lcom/tencent/android/androidbypass/richui/view/c;", "avatarDelegate", "Lcom/tencent/android/androidbypass/richui/f;", "options", "<init>", "(Lcom/tencent/android/androidbypass/richui/f;)V", "v", "a", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class a extends k {
    static IPatchRedirector $redirector_;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private String uin;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private com.tencent.android.androidbypass.richui.view.c avatarDelegate;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/android/androidbypass/richui/viewdata/a$a;", "", "", "JSON_KEY_UIN", "Ljava/lang/String;", "TAG", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.android.androidbypass.richui.viewdata.a$a, reason: collision with other inner class name and from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18966);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull com.tencent.android.androidbypass.richui.f options) {
        super(options);
        Intrinsics.checkNotNullParameter(options, "options");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) options);
        } else {
            this.uin = "";
        }
    }

    @Override // com.tencent.android.androidbypass.richui.viewdata.k
    public void C(@NotNull JSONObject attrData) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) attrData);
            return;
        }
        Intrinsics.checkNotNullParameter(attrData, "attrData");
        super.C(attrData);
        com.tencent.android.androidbypass.richui.view.c cVar = this.avatarDelegate;
        if (cVar != null && attrData.has("uin")) {
            String optString = attrData.optString("uin");
            Intrinsics.checkNotNullExpressionValue(optString, "attrData.optString(JSON_KEY_UIN)");
            this.uin = optString;
            if (optString.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                cVar.b(this.uin);
            } else {
                com.tencent.android.androidbypass.config.a.f72049a.i("AvatarViewData", "[update]: uin is empty");
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
        if (!(hVar instanceof com.tencent.android.androidbypass.richui.view.c)) {
            hVar = null;
        }
        this.avatarDelegate = (com.tencent.android.androidbypass.richui.view.c) hVar;
    }

    @Override // com.tencent.android.androidbypass.richui.viewdata.k
    public void e(@NotNull HashMap<String, com.tencent.android.androidbypass.richui.view.h<?>> cache) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) cache);
            return;
        }
        Intrinsics.checkNotNullParameter(cache, "cache");
        com.tencent.android.androidbypass.richui.view.c cVar = this.avatarDelegate;
        if (cVar != null) {
            cache.put(q(), cVar);
        }
        this.avatarDelegate = null;
    }

    @Override // com.tencent.android.androidbypass.richui.viewdata.k
    @NotNull
    protected View f(@NotNull Context context, @NotNull com.tencent.android.androidbypass.richui.view.i viewDelegateFactory, @Nullable com.tencent.android.androidbypass.richui.view.j listener) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, context, viewDelegateFactory, listener);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewDelegateFactory, "viewDelegateFactory");
        com.tencent.android.androidbypass.richui.view.c cVar = this.avatarDelegate;
        if (cVar == null) {
            cVar = viewDelegateFactory.d(context);
        }
        if (this.uin.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            cVar.b(this.uin);
        } else {
            com.tencent.android.androidbypass.config.a.f72049a.i("AvatarViewData", "[applyToView]: uin is empty");
        }
        this.avatarDelegate = cVar;
        return cVar.getTextView();
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
        this.uin = v(o().a(), dataJson, "uin");
    }
}
