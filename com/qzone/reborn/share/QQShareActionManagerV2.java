package com.qzone.reborn.share;

import android.content.Intent;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.sharepanel.m;
import com.tencent.mobileqq.sharepanel.model.ShareConfirmAction;
import com.tencent.mobileqq.sharepanel.o;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001IB\u0007\u00a2\u0006\u0004\bG\u0010HJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003J\u0010\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fJ\u0016\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012J\u0016\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0012J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0017\u001a\u00020\u0010J\u000e\u0010\u0019\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fJ.\u0010 \u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001c2\u0006\u0010\u001f\u001a\u00020\u001eJ$\u0010\"\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00022\u0006\u0010!\u001a\u00020\u0010J\u001c\u0010#\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0002J\u001e\u0010&\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020%J\u0016\u0010)\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010(\u001a\u00020'J\u0016\u0010*\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010+\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010,\u001a\u00020\u0005J \u00102\u001a\u00020\u00052\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020-2\b\u00101\u001a\u0004\u0018\u000100R0\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000303j\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0003`48\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u00105R$\u00109\u001a\u0012\u0012\u0004\u0012\u00020\u000306j\b\u0012\u0004\u0012\u00020\u0003`78\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u00108R$\u0010@\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R.\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010A\u001a\u0004\u0018\u00010\t8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F\u00a8\u0006J"}, d2 = {"Lcom/qzone/reborn/share/QQShareActionManagerV2;", "", "", "Lcom/qzone/reborn/share/a;", "shareActions", "", "b", "shareAction", "a", "Lcom/qzone/reborn/share/i;", "viewModel", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/qzone/reborn/share/e;", "shareContext", "t", ReportConstant.COSTREPORT_PREFIX, "", "action", "", NodeProps.VISIBLE, "v", NodeProps.ENABLED, "u", "type", tl.h.F, "r", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "Lkotlin/collections/ArrayList;", "targetList", "Lcom/tencent/mobileqq/sharepanel/m;", "callback", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "leaveMsg", "g", "e", "Lcom/tencent/mobileqq/sharepanel/model/ShareConfirmAction;", "Lcom/tencent/mobileqq/sharepanel/o;", "f", "Lcom/qzone/reborn/share/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "d", "l", "c", DomainData.DOMAIN_NAME, "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "k", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "allActions", "Lcom/tencent/mobileqq/sharepanel/f;", "Lcom/tencent/mobileqq/sharepanel/f;", "i", "()Lcom/tencent/mobileqq/sharepanel/f;", "o", "(Lcom/tencent/mobileqq/sharepanel/f;)V", "sharePanel", "value", "Lcom/qzone/reborn/share/i;", "j", "()Lcom/qzone/reborn/share/i;", "p", "(Lcom/qzone/reborn/share/i;)V", "<init>", "()V", "ShareLine", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QQShareActionManagerV2 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final HashMap<String, a> shareActions = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final HashSet<a> allActions = new HashSet<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.sharepanel.f sharePanel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private i viewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/qzone/reborn/share/QQShareActionManagerV2$ShareLine;", "", "(Ljava/lang/String;I)V", "NONE", "SPECIFIED", "FIRST", "SECOND", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes37.dex */
    public enum ShareLine {
        NONE,
        SPECIFIED,
        FIRST,
        SECOND
    }

    public final void a(a shareAction) {
        Intrinsics.checkNotNullParameter(shareAction, "shareAction");
        Iterator<T> it = shareAction.g().iterator();
        while (it.hasNext()) {
            this.shareActions.put((String) it.next(), shareAction);
        }
        this.allActions.add(shareAction);
    }

    public final void b(List<? extends a> shareActions) {
        Intrinsics.checkNotNullParameter(shareActions, "shareActions");
        Iterator<T> it = shareActions.iterator();
        while (it.hasNext()) {
            a((a) it.next());
        }
    }

    public final void c(e shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        com.tencent.mobileqq.sharepanel.f fVar = this.sharePanel;
        if (fVar != null) {
            fVar.dismiss();
        }
        Iterator<T> it = this.allActions.iterator();
        while (it.hasNext()) {
            ((a) it.next()).k(shareContext, false);
        }
    }

    public final void d(e shareContext, b item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        a h16 = h(item.getActionId());
        if (h16 != null) {
            h16.b(shareContext, item);
        }
    }

    public final boolean e(e shareContext, List<? extends ResultRecord> targetList) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(targetList, "targetList");
        Collection<a> values = this.shareActions.values();
        Intrinsics.checkNotNullExpressionValue(values, "shareActions.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).c(shareContext, targetList)) {
                return true;
            }
        }
        return false;
    }

    public final void f(e shareContext, ShareConfirmAction action, o callback) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Collection<a> values = this.shareActions.values();
        Intrinsics.checkNotNullExpressionValue(values, "shareActions.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).d(shareContext, action, callback)) {
                return;
            }
        }
        callback.b();
    }

    public final boolean g(e shareContext, List<? extends ResultRecord> targetList, String leaveMsg) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(targetList, "targetList");
        Intrinsics.checkNotNullParameter(leaveMsg, "leaveMsg");
        Collection<a> values = this.shareActions.values();
        Intrinsics.checkNotNullExpressionValue(values, "shareActions.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            if (((a) it.next()).e(shareContext, targetList, leaveMsg)) {
                return true;
            }
        }
        return false;
    }

    public final a h(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return this.shareActions.get(type);
    }

    /* renamed from: i, reason: from getter */
    public final com.tencent.mobileqq.sharepanel.f getSharePanel() {
        return this.sharePanel;
    }

    /* renamed from: j, reason: from getter */
    public final i getViewModel() {
        return this.viewModel;
    }

    public final void k(int requestCode, int resultCode, Intent data) {
        Iterator<T> it = this.allActions.iterator();
        while (it.hasNext()) {
            ((a) it.next()).l(requestCode, resultCode, data);
        }
    }

    public final void l(e shareContext, String action) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(action, "action");
        a h16 = h(action);
        if (h16 != null) {
            h16.m(shareContext);
        }
    }

    public final void m(e shareContext, ArrayList<ResultRecord> targetList, m callback) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(targetList, "targetList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Collection<a> values = this.shareActions.values();
        Intrinsics.checkNotNullExpressionValue(values, "shareActions.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext() && !((a) it.next()).n(shareContext, targetList, callback)) {
        }
    }

    public final void n() {
        Iterator<T> it = this.allActions.iterator();
        while (it.hasNext()) {
            ((a) it.next()).o();
        }
    }

    public final void o(com.tencent.mobileqq.sharepanel.f fVar) {
        this.sharePanel = fVar;
    }

    public final void p(i iVar) {
        q(iVar);
        this.viewModel = iVar;
    }

    public final void q(i viewModel) {
        Iterator<T> it = this.allActions.iterator();
        while (it.hasNext()) {
            ((a) it.next()).p(viewModel);
        }
    }

    public final void r(e shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        com.tencent.mobileqq.sharepanel.f fVar = this.sharePanel;
        if (fVar != null) {
            fVar.show();
        }
        Iterator<T> it = this.allActions.iterator();
        while (it.hasNext()) {
            ((a) it.next()).k(shareContext, true);
        }
    }

    public final void s(e shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Set<String> keySet = this.shareActions.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "shareActions.keys");
        for (String it : keySet) {
            a aVar = this.shareActions.get(it);
            if (aVar != null) {
                Intrinsics.checkNotNullExpressionValue(aVar, "shareActions[it]?:return@forEach");
                Intrinsics.checkNotNullExpressionValue(it, "it");
                u(it, aVar.i(shareContext));
            }
        }
    }

    public final void t(e shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Set<String> keySet = this.shareActions.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "shareActions.keys");
        for (String it : keySet) {
            a aVar = this.shareActions.get(it);
            if (aVar != null) {
                Intrinsics.checkNotNullExpressionValue(aVar, "shareActions[it]?:return@forEach");
                Intrinsics.checkNotNullExpressionValue(it, "it");
                v(it, aVar.j(shareContext));
            }
        }
    }

    public final void u(String action, boolean enabled) {
        com.tencent.mobileqq.sharepanel.f fVar;
        Intrinsics.checkNotNullParameter(action, "action");
        a aVar = this.shareActions.get(action);
        if (aVar == null) {
            return;
        }
        if (aVar.f() == ShareLine.FIRST) {
            com.tencent.mobileqq.sharepanel.f fVar2 = this.sharePanel;
            if (fVar2 != null) {
                fVar2.j0(action, enabled);
                return;
            }
            return;
        }
        if (aVar.f() != ShareLine.SECOND || (fVar = this.sharePanel) == null) {
            return;
        }
        fVar.o0(action, enabled);
    }

    public final void v(String action, boolean visible) {
        com.tencent.mobileqq.sharepanel.f fVar;
        Intrinsics.checkNotNullParameter(action, "action");
        QLog.d("QQShareActionManagerV2", 4, "action:" + action + ", visible:" + visible);
        a aVar = this.shareActions.get(action);
        if (aVar == null) {
            return;
        }
        if (aVar.f() == ShareLine.FIRST) {
            com.tencent.mobileqq.sharepanel.f fVar2 = this.sharePanel;
            if (fVar2 != null) {
                fVar2.l0(action, visible);
                return;
            }
            return;
        }
        if (aVar.f() != ShareLine.SECOND || (fVar = this.sharePanel) == null) {
            return;
        }
        fVar.c0(action, visible);
    }
}
