package com.tencent.mobileqq.selectfriend.enter.select;

import android.content.Context;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.selectfriend.model.FSForwardData;
import com.tencent.mobileqq.statistics.ReportController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B#\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0010\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0004R$\u0010\t\u001a\u0004\u0018\u00010\b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR,\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/enter/select/SelectEnterBaseAdapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Lcom/tencent/mobileqq/selectfriend/adapter/a;", "", "actionId", "", "reportDataForBusiness", "Landroid/content/Context;", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "Lcom/tencent/mobileqq/selectfriend/model/FSForwardData;", "Landroid/os/Bundle;", "mFsForwardData", "Lcom/tencent/mobileqq/selectfriend/model/FSForwardData;", "getMFsForwardData", "()Lcom/tencent/mobileqq/selectfriend/model/FSForwardData;", "setMFsForwardData", "(Lcom/tencent/mobileqq/selectfriend/model/FSForwardData;)V", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/selectfriend/model/FSForwardData;)V", "qq_selectfriend_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public abstract class SelectEnterBaseAdapter<VH extends RecyclerView.ViewHolder> extends com.tencent.mobileqq.selectfriend.adapter.a<VH> {
    static IPatchRedirector $redirector_;

    @Nullable
    private Context mContext;

    @Nullable
    private FSForwardData<Bundle> mFsForwardData;

    public SelectEnterBaseAdapter(@Nullable Context context, @Nullable FSForwardData<Bundle> fSForwardData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) fSForwardData);
        } else {
            this.mContext = context;
            this.mFsForwardData = fSForwardData;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final Context getMContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final FSForwardData<Bundle> getMFsForwardData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (FSForwardData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mFsForwardData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void reportDataForBusiness(@Nullable String actionId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) actionId);
            return;
        }
        FSForwardData<Bundle> fSForwardData = this.mFsForwardData;
        if (fSForwardData != null) {
            Intrinsics.checkNotNull(fSForwardData);
            if (fSForwardData.b() != null && (this.mContext instanceof AppActivity)) {
                FSForwardData<Bundle> fSForwardData2 = this.mFsForwardData;
                Intrinsics.checkNotNull(fSForwardData2);
                Bundle b16 = fSForwardData2.b();
                Context context = this.mContext;
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type mqq.app.AppActivity");
                AppRuntime appRuntime = ((AppActivity) context).getAppRuntime();
                if (appRuntime == null) {
                    return;
                }
                Intrinsics.checkNotNull(b16);
                if (b16.getBoolean("forward_source_from_shoot_quick", false)) {
                    ReportController.o(appRuntime, "CliOper", "", "", actionId, actionId, 0, 0, "", "", "", "");
                }
            }
        }
    }

    protected final void setMContext(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        } else {
            this.mContext = context;
        }
    }

    protected final void setMFsForwardData(@Nullable FSForwardData<Bundle> fSForwardData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) fSForwardData);
        } else {
            this.mFsForwardData = fSForwardData;
        }
    }
}
