package com.tencent.now.pkgame.linkscreen.mutebutton;

import com.tencent.mobileqq.vas.ipc.VasLiveIPCModule;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002J.\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/now/pkgame/linkscreen/mutebutton/g;", "", "", "roomId", VasLiveIPCModule.KEY_ANCHOR_UIN, "", "state", "nowId", "", "a", "pkType", "b", "<init>", "()V", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f338946a = new g();

    g() {
    }

    public final void a(long roomId, long anchorUin, int state, long nowId) {
        HashMap hashMap = new HashMap();
        hashMap.put("qqlive_lp_anchor_id", String.valueOf(nowId));
        hashMap.put("qqlive_lppk_set", String.valueOf(state));
        com.tencent.report.a.f364907a.h("em_qqlive_lp_close_other_voice", hashMap);
    }

    public final void b(long roomId, long anchorUin, int pkType, int state, long nowId) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("qqlive_lp_anchor_id", String.valueOf(nowId));
        hashMap.put("qqlive_lppk_set", String.valueOf(state));
        if (pkType != 2) {
            if (pkType != 3) {
                str = "";
            } else {
                str = "em_qqlive_lppk_close_other_voice";
            }
        } else {
            str = "em_qqlive_pwpk_close_other_voice";
        }
        com.tencent.report.a.f364907a.h(str, hashMap);
    }
}
