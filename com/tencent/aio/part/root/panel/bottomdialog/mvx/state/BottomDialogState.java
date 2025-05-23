package com.tencent.aio.part.root.panel.bottomdialog.mvx.state;

import android.view.View;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.mvi.base.mvi.MviUIState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0003\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\t\u0010\u0011R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/aio/part/root/panel/bottomdialog/mvx/state/BottomDialogState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "", "d", "Z", "f", "()Z", ViewStickEventHelper.IS_SHOW, "", "e", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "dialogType", "", "I", "c", "()I", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TYPE, h.F, HippyTKDListViewAdapter.X, "i", "y", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "a", "()Landroid/view/View;", "anchor", "<init>", "(ZLjava/lang/String;IIILandroid/view/View;)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public class BottomDialogState implements MviUIState {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isShow;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String dialogType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int showType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int x;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int y;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final View anchor;

    public BottomDialogState(boolean z16, @NotNull String dialogType, int i3, int i16, int i17, @Nullable View view) {
        Intrinsics.checkNotNullParameter(dialogType, "dialogType");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), dialogType, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), view);
            return;
        }
        this.isShow = z16;
        this.dialogType = dialogType;
        this.showType = i3;
        this.x = i16;
        this.y = i17;
        this.anchor = view;
    }

    @Nullable
    public final View a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.anchor;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.dialogType;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.showType;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.x;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.y;
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this)).booleanValue();
        }
        return this.isShow;
    }

    public /* synthetic */ BottomDialogState(boolean z16, String str, int i3, int i16, int i17, View view, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, (i18 & 2) != 0 ? "" : str, (i18 & 4) != 0 ? 1 : i3, (i18 & 8) != 0 ? 0 : i16, (i18 & 16) != 0 ? 0 : i17, (i18 & 32) != 0 ? null : view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), view, Integer.valueOf(i18), defaultConstructorMarker);
    }
}
