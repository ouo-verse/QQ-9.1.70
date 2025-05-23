package com.tencent.mobileqq.troop.essencemsg.graytip;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.graytips.util.i;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/troop/essencemsg/graytip/c;", "Lcom/tencent/qqnt/graytips/util/i;", "Landroid/view/View;", "view", "", "busiId", "", "text", "", "a", "b", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c implements i {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.graytips.util.i
    public void a(@Nullable View view, long busiId, @NotNull String text) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, view, Long.valueOf(busiId), text);
            return;
        }
        Intrinsics.checkNotNullParameter(text, "text");
        if (((int) busiId) == 2401) {
            HashMap hashMap = new HashMap();
            hashMap.put("aio_graytext_type", "1");
            hashMap.put("sgrp_btn_name", text);
            VideoReport.setElementId(view, "em_group_aio_graytext");
            VideoReport.reportEvent("dt_clck", view, hashMap);
        }
    }

    @Override // com.tencent.qqnt.graytips.util.i
    public void b(@Nullable View view, long busiId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, view, Long.valueOf(busiId));
        } else if (((int) busiId) == 2401) {
            HashMap hashMap = new HashMap();
            VideoReport.setElementId(view, "em_group_aio_graytext");
            hashMap.put("aio_graytext_type", "1");
            VideoReport.reportEvent("dt_imp", view, hashMap);
        }
    }
}
