package com.tencent.biz.qqcircle.debug.controller;

import android.view.View;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/biz/qqcircle/debug/controller/cg;", "Lcom/tencent/qcircle/cooperation/config/debug/a;", "", "e", "Landroid/view/View;", "view", "", NodeProps.ON_CLICK, "", "b", "d", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class cg extends com.tencent.qcircle.cooperation.config.debug.a {
    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public int b() {
        return 0;
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    @NotNull
    public String d() {
        return "QFSFastShareResetTimesController";
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    @NotNull
    public String e() {
        return "\u91cd\u7f6e\u5e7f\u573afeed\u5206\u4eab\u5f15\u5bfc\u6761-\u6b21\u6570";
    }

    @Override // com.tencent.qcircle.cooperation.config.debug.a
    public void onClick(@Nullable View view) {
        uq3.k.a().n("sp_key_fast_share_view_show_times", 0L);
        QQToastUtil.showQQToast(0, "\u6b21\u6570\u5df2\u91cd\u7f6e");
    }
}
