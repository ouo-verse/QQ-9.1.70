package com.tencent.qqnt.aio.bottombar.sectionbar.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IReportControllerApi;
import com.tencent.qqnt.aio.bottombar.sectionbar.viewholder.a;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.LIAConfigManager;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.LIAInjectUtil;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.LIAScene;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.LIAActionItem;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelLiteBusinessService;
import com.tencent.qqnt.kernel.nativeinterface.LiteActionScene;
import com.tencent.qqnt.kernel.nativeinterface.LiteActionType;
import com.tencent.qqnt.msg.f;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ,\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0016R\u0016\u0010\u0019\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/aio/bottombar/sectionbar/adapter/d;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/adapter/b;", "", "objectType", "type", QCircleLpReportDc010001.KEY_SUBTYPE, "", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "p", "o", "c", "b", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "g", "holder", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/model/a;", "model", "f", "", "Z", "isAIOLiteActionExposeForKernel", "<init>", "()V", "d", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class d extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isAIOLiteActionExposeForKernel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/bottombar/sectionbar/adapter/d$a;", "", "", "LIGHT_INTERACTION_TYPE", "Ljava/lang/String;", "OBJECT_TYPE", "SUB_LIGHT_INTERACTION_TYPE", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.bottombar.sectionbar.adapter.d$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65537);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void o() {
        String str;
        boolean z16;
        IKernelLiteBusinessService liteBusinessService;
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        com.tencent.aio.api.runtime.a a16 = a();
        if (a16 == null || (g16 = a16.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || (str = c16.j()) == null) {
            str = "";
        }
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (QLog.isColorLevel()) {
                QLog.d("LiteActionAdapter", 2, "LiteActionAdapter aioLiteActionClickForKernel return\uff0cpeerUid is empty");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LiteActionAdapter", 2, "LiteActionAdapter aioLiteActionClickForKernel success\uff1a[peerUid: " + str + "]");
        }
        IKernelService i3 = f.i();
        if (i3 != null && (liteBusinessService = i3.getLiteBusinessService()) != null) {
            liteBusinessService.clickLiteAction(str, LiteActionScene.KAIO.ordinal());
        }
    }

    private final void p() {
        String str;
        IKernelLiteBusinessService liteBusinessService;
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        if (this.isAIOLiteActionExposeForKernel) {
            if (QLog.isColorLevel()) {
                QLog.d("LiteActionAdapter", 2, "LiteActionAdapter aioLiteActionExposeForKernel return\uff0cisAIOLiteActionExposeForKernel == true");
                return;
            }
            return;
        }
        boolean z16 = true;
        this.isAIOLiteActionExposeForKernel = true;
        com.tencent.aio.api.runtime.a a16 = a();
        if (a16 == null || (g16 = a16.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || (str = c16.j()) == null) {
            str = "";
        }
        if (str.length() != 0) {
            z16 = false;
        }
        if (z16) {
            if (QLog.isColorLevel()) {
                QLog.d("LiteActionAdapter", 2, "LiteActionAdapter aioLiteActionExposeForKernel return\uff0cpeerUid is empty");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LiteActionAdapter", 2, "LiteActionAdapter aioLiteActionExposeForKernel success\uff1a[peerUid: " + str + "]");
        }
        IKernelService i3 = f.i();
        if (i3 != null && (liteBusinessService = i3.getLiteBusinessService()) != null) {
            liteBusinessService.exposeLiteAction(str, LiteActionScene.KAIO.ordinal());
        }
    }

    private final Map<String, Object> q(int objectType, int type, int subType) {
        Map<String, Object> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("object_type", Integer.valueOf(objectType)), TuplesKt.to("light_interaction_type", Integer.valueOf(type)), TuplesKt.to("sub_light_interaction_type", Integer.valueOf(subType)));
        return mapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(d this$0, com.tencent.qqnt.aio.bottombar.sectionbar.model.a model, View view) {
        LIAActionItem lIAActionItem;
        AIOSession aIOSession;
        AIOParam g16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(model, "$model");
        if (QLog.isDevelopLevel()) {
            com.tencent.aio.api.runtime.a a16 = this$0.a();
            if (a16 != null && (g16 = a16.g()) != null) {
                aIOSession = g16.r();
            } else {
                aIOSession = null;
            }
            QLog.d("LiteActionAdapter", 4, "onClick, contact=" + aIOSession);
        }
        Object a17 = model.a();
        if (a17 instanceof LIAActionItem) {
            lIAActionItem = (LIAActionItem) a17;
        } else {
            lIAActionItem = null;
        }
        if (lIAActionItem != null) {
            com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b e16 = LIAConfigManager.INSTANCE.a().e(lIAActionItem.getType(), lIAActionItem.c());
            if (e16 == null) {
                QLog.d("LiteActionAdapter", 1, "no res err. type=" + lIAActionItem.getType() + ", subType=" + lIAActionItem.c());
            } else {
                LIAInjectUtil.f353125a.h(null, LIAScene.AIO, new LIAInjectUtil.a(lIAActionItem, e16, this$0.a(), null, false, 24, null));
                com.tencent.mobileqq.aio.utils.b.l("em_bas_shortcut_bar_above_c2c_input_box", this$0.q(lIAActionItem.b(), lIAActionItem.getType(), lIAActionItem.c()));
                if (e16.n() == LiteActionType.KLOVERSAIGCEMOJI.ordinal()) {
                    ((IReportControllerApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IReportControllerApi.class)).reportWith898(null, "", "", "0X800C606", "0X800C606", 0, 0, "", "", "", "");
                }
                this$0.o();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b
    public void f(@NotNull RecyclerView.ViewHolder holder, @NotNull final com.tencent.qqnt.aio.bottombar.sectionbar.model.a model) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) holder, (Object) model);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(model, "model");
        if (!(holder instanceof com.tencent.qqnt.aio.bottombar.sectionbar.viewholder.a)) {
            return;
        }
        p();
        ((com.tencent.qqnt.aio.bottombar.sectionbar.viewholder.a) holder).l(model);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.bottombar.sectionbar.adapter.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.r(d.this, model, view);
            }
        });
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b
    @NotNull
    public RecyclerView.ViewHolder g(@NotNull ViewGroup parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        a.Companion companion = com.tencent.qqnt.aio.bottombar.sectionbar.viewholder.a.INSTANCE;
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new com.tencent.qqnt.aio.bottombar.sectionbar.viewholder.a(companion.b(context));
    }
}
