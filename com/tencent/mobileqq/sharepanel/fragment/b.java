package com.tencent.mobileqq.sharepanel.fragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.dialog.QUICompatDialog;
import com.tencent.mobileqq.sharepanel.input.SharePanelKeyboardAnimationHelper;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\tH\u0016R\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR$\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/fragment/b;", "Lcom/tencent/mobileqq/qui/dialog/QUICompatDialog;", "", "O", "", "", "N", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "flag", "setCancelable", "onBackPressed", BdhLogUtil.LogTag.Tag_Conn, "Z", "cancelable", "Lcom/tencent/mobileqq/sharepanel/fragment/a;", "D", "Lcom/tencent/mobileqq/sharepanel/fragment/a;", "getBackPressedInterceptor", "()Lcom/tencent/mobileqq/sharepanel/fragment/a;", "P", "(Lcom/tencent/mobileqq/sharepanel/fragment/a;)V", "backPressedInterceptor", "Landroid/content/Context;", "context", "", "themeResId", "<init>", "(Landroid/content/Context;I)V", "E", "a", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b extends QUICompatDialog {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final List<String> F;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean cancelable;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private a backPressedInterceptor;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/fragment/b$a;", "", "", "TAG", "Ljava/lang/String;", "", "defaultManufacturerList", "Ljava/util/List;", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.sharepanel.fragment.b$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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
        List<String> listOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35773);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        INSTANCE = new Companion(null);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO);
        F = listOf;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull Context context, int i3) {
        super(context, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, i3);
        } else {
            this.cancelable = true;
        }
    }

    private final List<String> N() {
        boolean z16;
        boolean z17;
        ArrayList arrayList = new ArrayList();
        String str = new String(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig("share_panel_keyboard_adjust_nothing_blacklist", new byte[0]), Charsets.UTF_8);
        QLog.i("SharePanelDialog", 1, "jsonString=" + str);
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return arrayList;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("manufacturer");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    String item = optJSONArray.optString(i3);
                    Intrinsics.checkNotNullExpressionValue(item, "item");
                    if (item.length() > 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        arrayList.add(item);
                    }
                }
            }
        } catch (Exception e16) {
            QLog.e("SharePanelDialog", 1, "isBlackListDevice error: ", e16);
        }
        return arrayList;
    }

    private final boolean O() {
        boolean equals;
        boolean equals2;
        String str = Build.MANUFACTURER;
        if (str == null) {
            return false;
        }
        List<String> N = N();
        if (!N.isEmpty()) {
            Iterator<T> it = N.iterator();
            while (it.hasNext()) {
                equals2 = StringsKt__StringsJVMKt.equals(str, (String) it.next(), true);
                if (equals2) {
                    QLog.i("SharePanelDialog", 1, "isBlackListDevice manufacturer=" + str + " by remote.");
                    return true;
                }
            }
        } else {
            Iterator<T> it5 = F.iterator();
            while (it5.hasNext()) {
                equals = StringsKt__StringsJVMKt.equals(str, (String) it5.next(), true);
                if (equals) {
                    QLog.i("SharePanelDialog", 1, "isBlackListDevice manufacturer=" + str + " by local.");
                    return true;
                }
            }
        }
        return false;
    }

    public final void P(@Nullable a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            this.backPressedInterceptor = aVar;
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (this.cancelable && (aVar = this.backPressedInterceptor) != null) {
            boolean z16 = false;
            if (aVar != null && aVar.Nd(false)) {
                z16 = true;
            }
            if (z16) {
                return;
            }
        }
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        if (SharePanelKeyboardAnimationHelper.INSTANCE.a() && !O()) {
            i3 = 48;
        } else {
            i3 = 16;
        }
        Window window = getWindow();
        if (window != null) {
            window.setSoftInputMode(i3);
        }
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean flag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, flag);
        } else {
            super.setCancelable(flag);
            this.cancelable = flag;
        }
    }
}
