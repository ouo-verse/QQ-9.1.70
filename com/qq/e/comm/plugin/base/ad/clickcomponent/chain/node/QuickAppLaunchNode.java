package com.qq.e.comm.plugin.base.ad.clickcomponent.chain.node;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.qq.e.comm.plugin.base.ad.clickcomponent.ClickInfo;
import com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode;
import com.qq.e.comm.plugin.base.ad.clickcomponent.d.f;
import com.qq.e.comm.plugin.base.ad.e.a;
import com.qq.e.comm.plugin.k.c;
import com.qq.e.comm.plugin.k.z;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.plugin.stat.b;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.ad.tangram.protocol.sdk_event_log;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QuickAppLaunchNode extends AbsJumpNode {

    /* renamed from: e, reason: collision with root package name */
    private String f38560e;

    public QuickAppLaunchNode(ClickInfo clickInfo) {
        super(clickInfo);
    }

    @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode
    protected boolean a() {
        if (!f.a()) {
            return false;
        }
        this.f38560e = this.f38544b.d().e();
        return !TextUtils.isEmpty(r0);
    }

    @Override // com.qq.e.comm.plugin.base.ad.clickcomponent.chain.AbsJumpNode
    protected int b(AbsJumpNode.a aVar) {
        Context b16 = this.f38544b.b().b();
        if (b16 == null) {
            return 2;
        }
        b a16 = z.a(this.f38544b, false);
        a.a(this.f38544b.e(), this.f38544b.d(), this.f38545c);
        StatTracer.trackEvent(sdk_event_log.SdkEventDimension.EVENT_TRY_TO_OPEN_QUICK_APP, 0, a16);
        if (a(b16, this.f38560e)) {
            a.b(this.f38544b.e(), this.f38544b.d(), this.f38545c);
            StatTracer.trackEvent(sdk_event_log.SdkEventDimension.EVENT_OPEN_QUICK_APP_SUCCESS, 0, a16);
            return 3;
        }
        a.c(this.f38544b.e(), this.f38544b.d(), this.f38545c);
        StatTracer.trackEvent(sdk_event_log.SdkEventDimension.EVENT_OPEN_QUICK_APP_FAILED, 0, a16);
        return 2;
    }

    private boolean a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Intent a16 = com.qq.e.comm.plugin.base.ad.e.a.a.a(context, (String) null, (String) null, Uri.parse(str));
            if (c.a(context, a16) == null) {
                return false;
            }
            context.startActivity(a16);
            return true;
        } catch (Throwable th5) {
            GDTLogger.report("ExceptionIn DownClickRunnable.startInstalledAPP", th5);
            return false;
        }
    }
}
