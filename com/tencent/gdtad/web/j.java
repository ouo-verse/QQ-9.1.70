package com.tencent.gdtad.web;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.gdtad.log.GdtLog;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class j implements h {

    /* renamed from: a, reason: collision with root package name */
    private k f109792a;

    public j(k kVar) {
        this.f109792a = kVar;
    }

    @Nullable
    private String d() {
        Activity activity;
        k kVar = this.f109792a;
        if (kVar != null) {
            activity = kVar.getActivity();
        } else {
            activity = null;
        }
        if (activity != null && activity.getIntent() != null) {
            long longExtra = activity.getIntent().getLongExtra("GdtNocoId", -1L);
            if (longExtra != -1) {
                return String.valueOf(longExtra);
            }
        }
        return null;
    }

    @Override // com.tencent.gdtad.web.h
    public boolean a(String str, long j3, Map<String, Object> map) {
        if (j3 == 8589934594L) {
            try {
                String d16 = d();
                if (!TextUtils.isEmpty(d16)) {
                    this.f109792a.callJs("!function(g,d,t,e,v,n,s){if(g.gdt)return;v=g.gdt=function(){v.tk?v.tk.apply(v,arguments):v.queue.push(arguments)};v.sv=\"1.0\";v.bt=2;v.queue=[];n=d.createElement(t);n.async=!0;n.src=e;s=d.getElementsByTagName(t)[0];s.parentNode.insertBefore(n,s);}(window,document,\"script\",\"//qzonestyle.gtimg.cn/qzone/biz/gdt/dmp/user-action/gdtevent.min.js\");gdt(\"init\",\"userActionSetId\");gdt(\"track\",\"PAGE_VIEW\");".replace("userActionSetId", d16));
                    GdtLog.d("GdtWebReportNoco", "GdtWebReportPlugin Report nocoId :" + d16);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.tencent.gdtad.web.h
    public void b() {
    }

    @Override // com.tencent.gdtad.web.h
    public void onDestroy() {
    }

    @Override // com.tencent.gdtad.web.h
    public void c(CustomWebView customWebView) {
    }
}
