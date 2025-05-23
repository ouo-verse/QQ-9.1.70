package com.tencent.av.ui;

import android.content.Context;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.av.business.manager.pendant.EffectPendantBase;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.ui.QavListItemBase;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class t implements iw.b, EffectConfigBase.b<PendantItem> {

    /* renamed from: e, reason: collision with root package name */
    private final String f76626e;

    /* renamed from: f, reason: collision with root package name */
    private final int f76627f;

    /* renamed from: h, reason: collision with root package name */
    private final EffectPendantBase f76628h;

    /* renamed from: d, reason: collision with root package name */
    private final ArrayList<QavListItemBase.c> f76625d = new ArrayList<>(10);

    /* renamed from: i, reason: collision with root package name */
    private QAVPtvTemplateAdapter f76629i = null;

    public t(int i3, EffectPendantBase effectPendantBase) {
        this.f76626e = "QavListItemHelper" + i3;
        this.f76627f = i3;
        this.f76628h = effectPendantBase;
    }

    public static QavListItemBase.c a(int i3, PendantItem pendantItem) {
        QavListItemBase.c cVar = new QavListItemBase.c();
        cVar.f75029f = i3;
        cVar.f75024a = pendantItem.getId();
        cVar.f75026c = pendantItem.getDesc();
        cVar.f75025b = pendantItem.getIconUrl();
        cVar.f75034k = pendantItem.getDesc();
        cVar.f75031h = false;
        cVar.f75027d = pendantItem.isUsable();
        cVar.f75035l = pendantItem;
        if (i3 == 4) {
            cVar.f75036m = true;
        }
        return cVar;
    }

    public ArrayList<QavListItemBase.c> b(Context context) {
        QavListItemBase.c a16;
        long d16 = com.tencent.av.utils.e.d();
        this.f76625d.clear();
        if (this.f76627f == 5) {
            QavListItemBase.c cVar = new QavListItemBase.c();
            cVar.f75036m = false;
            cVar.f75024a = "-1";
            this.f76625d.add(cVar);
        }
        QavListItemBase.c cVar2 = new QavListItemBase.c();
        cVar2.f75024a = "0";
        cVar2.f75025b = String.valueOf(R.drawable.dcp);
        cVar2.f75031h = false;
        int i3 = this.f76627f;
        cVar2.f75029f = i3;
        if (i3 == 4) {
            cVar2.f75036m = true;
            cVar2.f75026c = context.getString(R.string.w2r);
            cVar2.f75034k = context.getString(R.string.w2s);
        } else {
            cVar2.f75036m = false;
            cVar2.f75026c = context.getString(R.string.w2r);
            cVar2.f75034k = context.getString(R.string.w2r);
        }
        this.f76625d.add(cVar2);
        EffectPendantBase effectPendantBase = this.f76628h;
        if (effectPendantBase != null) {
            List<PendantItem> q16 = effectPendantBase.q(null);
            PendantItem u16 = this.f76628h.u();
            if (u16 != null && !q16.contains(u16)) {
                this.f76628h.L(d16, null);
            }
            if (q16 != null && q16.size() > 0) {
                for (PendantItem pendantItem : q16) {
                    if (pendantItem != null && (a16 = a(this.f76627f, pendantItem)) != null) {
                        this.f76625d.add(a16);
                    }
                }
            }
        }
        return this.f76625d;
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase.b
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onDownloadFinish(long j3, PendantItem pendantItem, boolean z16) {
        if (QLog.isDevelopLevel()) {
            QLog.i(this.f76626e, 4, "onDownloadFinish, seq[" + j3 + "], isSuc[" + z16 + "], info[" + pendantItem + "]");
        }
        QAVPtvTemplateAdapter qAVPtvTemplateAdapter = this.f76629i;
        if (qAVPtvTemplateAdapter != null) {
            qAVPtvTemplateAdapter.g(j3, pendantItem.getId(), z16);
        }
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase.b
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onItemSelectedChanged(long j3, PendantItem pendantItem) {
        if (QLog.isDevelopLevel()) {
            QLog.i(this.f76626e, 4, "onItemSelectedChanged, seq[" + j3 + "], current[" + pendantItem + "]");
        }
    }

    @Override // com.tencent.av.business.manager.EffectConfigBase.b
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(PendantItem pendantItem, int i3) {
        QAVPtvTemplateAdapter qAVPtvTemplateAdapter = this.f76629i;
        if (qAVPtvTemplateAdapter != null) {
            qAVPtvTemplateAdapter.h(pendantItem.getId(), i3);
        }
    }

    public void f(QAVPtvTemplateAdapter qAVPtvTemplateAdapter) {
        this.f76629i = qAVPtvTemplateAdapter;
    }

    @Override // iw.b
    public void startDownloadTemplate(AppInterface appInterface, long j3, QavListItemBase.c cVar, QavListItemBase.b bVar) {
        PendantItem pendantItem;
        EffectPendantBase effectPendantBase = this.f76628h;
        if (effectPendantBase != null) {
            pendantItem = effectPendantBase.w(cVar.f75024a);
        } else {
            pendantItem = null;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i(this.f76626e, 4, "startDownloadTemplate, seq[" + j3 + "], item[" + pendantItem + "]");
        }
        if (pendantItem != null) {
            this.f76628h.N(j3, pendantItem);
            return;
        }
        QLog.w(this.f76626e, 1, "startDownloadTemplate, item\u4e3a\u7a7a, seq[" + j3 + "]");
        bVar.s(j3, cVar.f75024a, false);
    }
}
