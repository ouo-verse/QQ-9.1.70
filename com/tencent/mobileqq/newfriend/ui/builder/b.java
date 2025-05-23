package com.tencent.mobileqq.newfriend.ui.builder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.util.LoadingUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001cB7\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0003H\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/newfriend/ui/builder/b;", "Lcom/tencent/mobileqq/newfriend/ui/builder/d;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "o", DomainData.DOMAIN_NAME, "", "position", "convertView", tl.h.F, "view", "", NodeProps.ON_CLICK, "", BdhLogUtil.LogTag.Tag_Conn, "Z", "isEnd", "Landroid/content/Context;", "context", "Lcom/tencent/common/app/AppInterface;", "app", "Lcom/tencent/mobileqq/newfriend/ui/adapter/SystemMsgListAdapter;", "adapter", "Lcom/tencent/mobileqq/newfriend/msg/i;", "data", "<init>", "(Landroid/content/Context;Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/newfriend/ui/adapter/SystemMsgListAdapter;Lcom/tencent/mobileqq/newfriend/msg/i;Z)V", "D", "a", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b extends d implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private final boolean isEnd;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/newfriend/ui/builder/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.newfriend.ui.builder.b$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24172);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(@Nullable Context context, @Nullable AppInterface appInterface, @Nullable SystemMsgListAdapter systemMsgListAdapter, @Nullable com.tencent.mobileqq.newfriend.msg.i iVar, boolean z16) {
        super(context, appInterface, systemMsgListAdapter, iVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, appInterface, systemMsgListAdapter, iVar, Boolean.valueOf(z16));
        } else {
            this.isEnd = z16;
        }
    }

    private final View n() {
        View loadingDialogTipsRight = LoadingUtil.getLoadingDialogTipsRight(this.f254107d, false);
        if (loadingDialogTipsRight != null) {
            loadingDialogTipsRight.setTag(null);
            return loadingDialogTipsRight;
        }
        return new View(this.f254107d);
    }

    private final View o() {
        if (!this.isEnd) {
            return n();
        }
        Context context = this.f254107d;
        if (context == null) {
            QLog.i("MayKnowMoreBuilder", 1, "getNoMoreOrLoadingView context == null");
            return new View(this.f254107d);
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.gyx, (ViewGroup) null);
        if (inflate == null) {
            QLog.i("MayKnowMoreBuilder", 1, "getNoMoreOrLoadingView view == null");
            return new View(this.f254107d);
        }
        inflate.setClickable(true);
        inflate.setFocusable(true);
        VideoReport.setElementId(inflate, "em_kl_no_more_tag");
        VideoReport.setElementClickPolicy(inflate, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(inflate, ExposurePolicy.REPORT_ALL);
        return inflate;
    }

    @Override // com.tencent.mobileqq.newfriend.ui.builder.d
    @NotNull
    public View h(int position, @Nullable View convertView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, position, (Object) convertView);
        }
        return o();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "view");
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
