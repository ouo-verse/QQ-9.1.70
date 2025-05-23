package com.tencent.mobileqq.qqlive.room.prepare.part;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.api.ITimiGameApi;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import nf4.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b&\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003H\u0014J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH&J\u0014\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000fH\u0014J\b\u0010\u0012\u001a\u00020\u0011H&J\b\u0010\u0014\u001a\u00020\u0013H&J\b\u0010\u0015\u001a\u00020\fH&\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/prepare/part/a;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "view", "", "x9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "v", NodeProps.ON_CLICK, "E9", "", "getLogTag", "z9", "", "A9", "", "C9", "", "D9", "B9", "<init>", "()V", "d", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public abstract class a extends Part implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/prepare/part/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.room.prepare.part.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes17.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36105);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void x9(View view) {
        d.a.a(((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil(), view, false, null, z9(), A9(), 4, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public Map<String, String> A9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Map) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new LinkedHashMap();
    }

    @NotNull
    public abstract String B9();

    public abstract int C9();

    public abstract boolean D9();

    protected void E9(@NotNull View v3) {
        boolean z16;
        boolean startsWith$default;
        boolean startsWith$default2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) v3);
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        String B9 = B9();
        if (B9.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(B9, "http://", false, 2, null);
            if (!startsWith$default) {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(B9, "https://", false, 2, null);
                if (!startsWith$default2) {
                    Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
                    intent.setData(Uri.parse(B9));
                    if (!(getContext() instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    getContext().startActivity(intent);
                    return;
                }
            }
            com.tencent.mobileqq.qqlive.anchor.live.utils.c cVar = com.tencent.mobileqq.qqlive.anchor.live.utils.c.f270735a;
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            cVar.f(activity, B9());
            return;
        }
        AegisLogger.INSTANCE.i("QQLivePrepareMenuBasePart", "onRealClick", "click menu " + getClass() + " item but url is empty");
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    public String getLogTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "QQLivePrepareMenuBasePart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) v3);
        } else {
            Intrinsics.checkNotNullParameter(v3, "v");
            if (!FastClickUtils.isFastDoubleClick(getLogTag())) {
                E9(v3);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(C9());
        if (D9()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        findViewById.setVisibility(i3);
        findViewById.setOnClickListener(this);
        Intrinsics.checkNotNullExpressionValue(findViewById, "this");
        x9(findViewById);
    }

    @NotNull
    public abstract String z9();
}
