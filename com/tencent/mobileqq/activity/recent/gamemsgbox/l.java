package com.tencent.mobileqq.activity.recent.gamemsgbox;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\b\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0016R\u0014\u0010\u0011\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0012R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/activity/recent/gamemsgbox/l;", "Lcom/tencent/qqnt/chats/core/data/a;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "Landroid/view/View;", "k", "j", "", "e", tl.h.F, "f", "d", "g", "c", "b", "I", "gameBoxScene", "Landroid/view/View;", "partnerEmptyView", "partnerApplyEmptyView", "<init>", "(I)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class l extends com.tencent.qqnt.chats.core.data.a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int gameBoxScene;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View partnerEmptyView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View partnerApplyEmptyView;

    public l(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.gameBoxScene = i3;
        }
    }

    private final View j() {
        View view = this.partnerApplyEmptyView;
        if (view != null) {
            return view;
        }
        BaseApplication context = BaseApplication.getContext();
        String string = context.getString(R.string.f199294p1);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.te\u2026_box_empty_apply_partner)");
        this.partnerApplyEmptyView = new QUIEmptyState.Builder(context).setImageType(7).setTitle(string).setBackgroundColorType(2).build();
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        View view2 = this.partnerApplyEmptyView;
        if (view2 != null) {
            view2.setLayoutParams(layoutParams);
        }
        return this.partnerApplyEmptyView;
    }

    private final View k() {
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg("", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92053", "989346", "", "", "8", "");
        View view = this.partnerEmptyView;
        if (view != null) {
            return view;
        }
        BaseApplication context = BaseApplication.getContext();
        String string = context.getString(R.string.f199304p2);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.te\u2026me_msg_box_empty_partner)");
        this.partnerEmptyView = new QUIEmptyState.Builder(context).setImageType(7).setTitle(string).setBackgroundColorType(2).build();
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        View view2 = this.partnerEmptyView;
        if (view2 != null) {
            view2.setLayoutParams(layoutParams);
        }
        return this.partnerEmptyView;
    }

    private final boolean l() {
        if (this.gameBoxScene == 3) {
            return true;
        }
        return false;
    }

    private final boolean m() {
        String a16 = e.f185509a.a();
        if (a16 == null) {
            return false;
        }
        return Intrinsics.areEqual(a16, "partner");
    }

    @Override // com.tencent.qqnt.chats.core.data.a
    @Nullable
    public View c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (m()) {
            return k();
        }
        if (l()) {
            return j();
        }
        return null;
    }

    @Override // com.tencent.qqnt.chats.core.data.a
    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.qqnt.chats.core.data.a
    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 7;
    }

    @Override // com.tencent.qqnt.chats.core.data.a
    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.qqnt.chats.core.data.a
    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (!m() && !l()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.chats.core.data.a
    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }
}
