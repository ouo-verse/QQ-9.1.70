package com.tencent.mobileqq.emoticonview.searchemo.impl;

import android.content.Context;
import com.tencent.mobileqq.emoticonview.searchemo.IEmoticonEventCallback;
import com.tencent.mobileqq.emoticonview.searchemo.ISearchEmoticonMgrApi;
import com.tencent.mobileqq.emoticonview.searchemo.dialog.SearchEmoticonDialog;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J8\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/searchemo/impl/SearchEmoticonMgrApiImpl;", "Lcom/tencent/mobileqq/emoticonview/searchemo/ISearchEmoticonMgrApi;", "()V", "mDialog", "Lcom/tencent/mobileqq/emoticonview/searchemo/dialog/SearchEmoticonDialog;", "aioDestroy", "", "dialogDismiss", "setFloatingViewDraggable", "draggable", "", "showSearchEmoticonDialog", "context", "Landroid/content/Context;", "appRuntime", "Lmqq/app/AppRuntime;", "emotionEventCallback", "Lcom/tencent/mobileqq/emoticonview/searchemo/IEmoticonEventCallback;", "searchWords", "", IProfileCardConst.KEY_FROM_TYPE, "", "defaultSelectTabIndex", "Companion", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class SearchEmoticonMgrApiImpl implements ISearchEmoticonMgrApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "SearchEmoticonMgrApiImpl";

    @Nullable
    private SearchEmoticonDialog mDialog;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/searchemo/impl/SearchEmoticonMgrApiImpl$Companion;", "", "()V", "TAG", "", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23760);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SearchEmoticonMgrApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.searchemo.ISearchEmoticonMgrApi
    public void aioDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        SearchEmoticonDialog searchEmoticonDialog = this.mDialog;
        if (searchEmoticonDialog != null) {
            searchEmoticonDialog.aioDestroy();
        }
    }

    public final void dialogDismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "dialog dismiss, set mDialog field to null");
        }
        this.mDialog = null;
    }

    @Override // com.tencent.mobileqq.emoticonview.searchemo.ISearchEmoticonMgrApi
    public void setFloatingViewDraggable(boolean draggable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, draggable);
            return;
        }
        SearchEmoticonDialog searchEmoticonDialog = this.mDialog;
        if (searchEmoticonDialog != null) {
            searchEmoticonDialog.setFloatingViewDraggable(draggable);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.searchemo.ISearchEmoticonMgrApi
    public void showSearchEmoticonDialog(@NotNull Context context, @NotNull AppRuntime appRuntime, @NotNull IEmoticonEventCallback emotionEventCallback, @NotNull CharSequence searchWords, int fromType, int defaultSelectTabIndex) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, appRuntime, emotionEventCallback, searchWords, Integer.valueOf(fromType), Integer.valueOf(defaultSelectTabIndex));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(emotionEventCallback, "emotionEventCallback");
        Intrinsics.checkNotNullParameter(searchWords, "searchWords");
        if (this.mDialog == null) {
            this.mDialog = new SearchEmoticonDialog(context, appRuntime, this, emotionEventCallback, searchWords, fromType, defaultSelectTabIndex);
            Unit unit = Unit.INSTANCE;
        }
        SearchEmoticonDialog searchEmoticonDialog = this.mDialog;
        if (searchEmoticonDialog != null) {
            searchEmoticonDialog.show();
        }
    }
}
