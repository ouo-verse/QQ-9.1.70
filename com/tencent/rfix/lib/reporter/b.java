package com.tencent.rfix.lib.reporter;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.rfix.loader.entity.RFixLoadResult;
import com.tencent.rfix.loader.entity.RFixPatchInfo;
import com.tencent.rfix.loader.log.RFixLog;
import com.tencent.rfix.loader.thread.RFixThreadPool;
import com.tencent.rfix.loader.track.TimeTrackType;
import com.tencent.rfix.loader.track.TimeTracker;
import com.tencent.rfix.loader.utils.ProcessUtils;
import com.tencent.rfix.loader.utils.RFixConstants;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected final Context f364995a;

    public b(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f364995a = context;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(RFixLoadResult rFixLoadResult) {
        c(rFixLoadResult);
        e(rFixLoadResult);
    }

    private void c(RFixLoadResult rFixLoadResult) {
        int i3;
        if (!ProcessUtils.isInMainProcess(this.f364995a)) {
            return;
        }
        if (rFixLoadResult.isLoaderSuccess()) {
            i3 = rFixLoadResult.patchInfo.configId;
        } else {
            i3 = 0;
        }
        com.tencent.rfix.lib.covered.b.f(this.f364995a).i(i3, rFixLoadResult.effectImmediate);
    }

    public void d(final RFixLoadResult rFixLoadResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rFixLoadResult);
            return;
        }
        RFixLog.d("RFix.DefaultLoadReporter", "onLoadResult loadResult=" + rFixLoadResult);
        RFixThreadPool.getInstance().execute(new Runnable() { // from class: com.tencent.rfix.lib.reporter.a
            @Override // java.lang.Runnable
            public final void run() {
                b.this.b(rFixLoadResult);
            }
        });
    }

    protected void e(RFixLoadResult rFixLoadResult) {
        String str;
        String str2;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rFixLoadResult);
            return;
        }
        if (rFixLoadResult.result == RFixConstants.LoadResult.LOAD_RESULT_PATCH_INFO_BLANK) {
            return;
        }
        RFixPatchInfo rFixPatchInfo = rFixLoadResult.patchInfo;
        String str3 = null;
        int i16 = 0;
        if (rFixPatchInfo != null) {
            int i17 = rFixPatchInfo.configId;
            if (i17 <= 0) {
                i17 = rFixPatchInfo.lastConfigId;
            }
            i3 = rFixPatchInfo.configType;
            String str4 = rFixPatchInfo.patchType;
            if (!TextUtils.isEmpty(rFixPatchInfo.version) && rFixPatchInfo.version.length() >= 8) {
                str3 = rFixPatchInfo.version.substring(0, 8);
            }
            str2 = str3;
            i16 = i17;
            str = str4;
        } else {
            str = null;
            str2 = null;
            i3 = 0;
        }
        g.b(this.f364995a, rFixLoadResult, String.valueOf(i16));
        f.i(this.f364995a, String.valueOf(i16), String.valueOf(i3), str, str2, "Load", rFixLoadResult.isSuccess(), rFixLoadResult.result.toString(), String.valueOf(rFixLoadResult.subResult), rFixLoadResult.timeCost, null, null, null, String.valueOf(TimeTracker.getTrackTimeMillis(TimeTrackType.PATCH_LOAD_CHECK)), String.valueOf(TimeTracker.getTrackTimeMillis(TimeTrackType.PATCH_LOAD_LOADER)), String.valueOf(TimeTracker.getTrackTimeMillis(TimeTrackType.PATCH_LOAD_LOADER_DEX)), String.valueOf(TimeTracker.getTrackTimeMillis(TimeTrackType.PATCH_LOAD_LOADER_RES)), String.valueOf(TimeTracker.getTrackTimeMillis(TimeTrackType.PATCH_LOAD_LOADER_SO)), null, null, null, null, null);
    }
}
