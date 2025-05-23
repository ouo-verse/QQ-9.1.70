package com.tencent.qqnt.aio.menu;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOJumpAction;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0017\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\u0006\u0010\u000b\u001a\u00020\u0002R\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0012R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0012\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/aio/menu/o;", "Lcom/tencent/qqnt/aio/menu/ui/d;", "", "j", "f", "", "c", "", tl.h.F, "b", "e", "i", "Landroid/content/Context;", "d", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Ljava/lang/String;", "title", "makeSamePage", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;)V", "g", "a", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class o extends com.tencent.qqnt.aio.menu.ui.d {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String title;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String makeSamePage;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/aio/menu/o$a;", "", "", "TAG", "Ljava/lang/String;", "defaultMakeSamePage", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.menu.o$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46608);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(@NotNull Context context, @NotNull AIOMsgItem msgItem) {
        super(msgItem);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) msgItem);
            return;
        }
        this.context = context;
        String string = context.getResources().getString(R.string.f207715ar);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026tring.qqcommon_make_same)");
        this.title = string;
    }

    private final String j() {
        PicElement picElement;
        String page = "https://qun.qq.com/ai-emoji-store/index.html?_wwv=8192&_wv=16777219&page_from=3";
        try {
            page = new JSONObject(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("105602", "")).optString("make_same_page", "https://qun.qq.com/ai-emoji-store/index.html?_wwv=8192&_wv=16777219&page_from=3");
        } catch (JSONException unused) {
        }
        MsgElement firstTypeElement = d().getFirstTypeElement(2);
        if (firstTypeElement != null) {
            picElement = firstTypeElement.picElement;
        } else {
            picElement = null;
        }
        if (picElement != null) {
            page = page + "&template_id=" + picElement.templateID;
        }
        Intrinsics.checkNotNullExpressionValue(page, "page");
        return page;
    }

    @Override // com.tencent.qqnt.aio.menu.ui.d
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return R.drawable.jxf;
    }

    @Override // com.tencent.qqnt.aio.menu.ui.d
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return R.id.z48;
    }

    @Override // com.tencent.qqnt.aio.menu.ui.d
    @NotNull
    public String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "MakeSameMenuItem";
    }

    @Override // com.tencent.qqnt.aio.menu.ui.d
    @NotNull
    /* renamed from: f */
    public String getTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.title;
    }

    @Override // com.tencent.qqnt.aio.menu.ui.d
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        String i3 = i();
        ((IAIOJumpAction) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOJumpAction.class)).openBrowser(this.context, i3);
        QLog.i("MakeSameMenuItem", 1, "onClickMenu: " + i3);
    }

    @NotNull
    public final String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        if (this.makeSamePage == null) {
            this.makeSamePage = j();
        }
        String str = this.makeSamePage;
        Intrinsics.checkNotNull(str);
        return str;
    }
}
