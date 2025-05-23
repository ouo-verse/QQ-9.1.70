package com.tencent.mobileqq.tbstool.adapter;

import android.app.Activity;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.tbs.reader.TbsReaderView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J0\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J.\u0010\u0019\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\u001a\u0010\u001a\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/tbstool/adapter/a;", "Lcom/tencent/mobileqq/tbstool/adapter/b;", "", "add", "", "a", "g", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "actionType", "b", "e", "d", "c", "", "strPath", "", "sessionId", "Lcom/tencent/mobileqq/filemanager/fileview/LocalTbsViewManager$e;", "callBack", "Lcom/tencent/tbs/reader/TbsReaderView;", "f", "local", "i", h.F, "<init>", "()V", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a implements b {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.tbstool.adapter.b
    public void a(boolean add) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, add);
        } else {
            LocalTbsViewManager.k().y(add);
        }
    }

    @Override // com.tencent.mobileqq.tbstool.adapter.b
    public void b(@NotNull Activity activity, int actionType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity, actionType);
        } else {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }
    }

    @Override // com.tencent.mobileqq.tbstool.adapter.b
    public boolean c(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) activity)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.tbstool.adapter.b
    public void d(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) activity);
        }
    }

    @Override // com.tencent.mobileqq.tbstool.adapter.b
    public void e(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
        } else {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }
    }

    @Override // com.tencent.mobileqq.tbstool.adapter.b
    @Nullable
    public TbsReaderView f(@Nullable Activity activity, @Nullable String strPath, long sessionId, @Nullable LocalTbsViewManager.e callBack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (TbsReaderView) iPatchRedirector.redirect((short) 11, this, activity, strPath, Long.valueOf(sessionId), callBack);
        }
        return LocalTbsViewManager.k().u(activity, strPath, callBack);
    }

    @Override // com.tencent.mobileqq.tbstool.adapter.b
    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return LocalTbsViewManager.k().s();
    }

    @Override // com.tencent.mobileqq.tbstool.adapter.b
    public void h(@Nullable Activity activity, long sessionId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, activity, Long.valueOf(sessionId));
        }
    }

    @Override // com.tencent.mobileqq.tbstool.adapter.b
    public void i(@Nullable Activity activity, @Nullable String strPath, @Nullable LocalTbsViewManager.e callBack, boolean local) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, activity, strPath, callBack, Boolean.valueOf(local));
        } else {
            LocalTbsViewManager.k().g(activity, strPath, callBack, local);
        }
    }

    @Override // com.tencent.mobileqq.tbstool.adapter.b
    public void onDestroy(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
        } else {
            Intrinsics.checkNotNullParameter(activity, "activity");
            LocalTbsViewManager.k().t(activity);
        }
    }
}
