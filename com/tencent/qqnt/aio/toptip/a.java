package com.tencent.qqnt.aio.toptip;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.gamecenter.nt.aio.title.GameMsgTipsEvent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.j;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0007\u0018\u0000 12\u00020\u00012\u00020\u0002:\u0001\fB\u0007\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J)\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b\"\u0004\u0018\u00010\tH\u0016\u00a2\u0006\u0004\b\f\u0010\rJ7\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0016\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b\"\u0004\u0018\u00010\tH\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u0014\u001a\u00020\u0003J\u0006\u0010\u0015\u001a\u00020\u0003J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u000bH\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010*\u001a\u00020\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010'R\u0016\u0010.\u001a\u0004\u0018\u00010+8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b,\u0010-\u00a8\u00062"}, d2 = {"Lcom/tencent/qqnt/aio/toptip/a;", "Lcom/tencent/qqnt/aio/toptips/a;", "Landroid/view/View$OnClickListener;", "", DomainData.DOMAIN_NAME, "o", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "", "", "params", "Landroid/view/View;", "a", "([Ljava/lang/Object;)Landroid/view/View;", "Lcom/tencent/qqnt/aio/toptips/c;", "topTipsManager", "", "eventType", "g", "(Lcom/tencent/qqnt/aio/toptips/c;I[Ljava/lang/Object;)V", "r", "p", "view", NodeProps.ON_CLICK, "d", "Landroid/view/View;", "mView", "", "e", "Ljava/lang/String;", "mTipsContent", "f", "Lcom/tencent/qqnt/aio/toptips/c;", "mManager", "Lcom/tencent/mvi/base/route/a;", tl.h.F, "Lcom/tencent/mvi/base/route/a;", "mAction1", "j", "()I", "barPriority", "getType", "type", "", "b", "()[I", "excludeTypes", "<init>", "()V", "i", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a extends com.tencent.qqnt.aio.toptips.a implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mTipsContent;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.aio.toptips.c mManager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mvi.base.route.a mAction1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/toptip/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.toptip.a$a, reason: collision with other inner class name and from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/aio/toptip/a$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "", "sticky", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
                return;
            }
            Intrinsics.checkNotNullParameter(i3, "i");
            QLog.i("GameMsgTipsBar", 1, "[mAction1] call:" + i3);
            if (i3 instanceof GameMsgTipsEvent.ShowTips) {
                a.this.mTipsContent = ((GameMsgTipsEvent.ShowTips) i3).getTips();
                a.this.r();
            } else if (i3 instanceof GameMsgTipsEvent.HideTips) {
                a.this.p();
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63818);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mAction1 = new b();
        }
    }

    private final void n() {
        q();
    }

    private final void o() {
        p();
        s();
    }

    private final void q() {
        com.tencent.aio.api.runtime.a a16;
        j e16;
        com.tencent.aio.api.runtime.a a17;
        j e17;
        com.tencent.qqnt.aio.toptips.c cVar = this.mManager;
        if (cVar != null && (a17 = cVar.a()) != null && (e17 = a17.e()) != null) {
            e17.d(Reflection.getOrCreateKotlinClass(GameMsgTipsEvent.ShowTips.class).getQualifiedName(), this.mAction1);
        }
        com.tencent.qqnt.aio.toptips.c cVar2 = this.mManager;
        if (cVar2 != null && (a16 = cVar2.a()) != null && (e16 = a16.e()) != null) {
            e16.d(Reflection.getOrCreateKotlinClass(GameMsgTipsEvent.HideTips.class).getQualifiedName(), this.mAction1);
        }
    }

    private final void s() {
        com.tencent.aio.api.runtime.a a16;
        j e16;
        com.tencent.aio.api.runtime.a a17;
        j e17;
        com.tencent.qqnt.aio.toptips.c cVar = this.mManager;
        if (cVar != null && (a17 = cVar.a()) != null && (e17 = a17.e()) != null) {
            e17.b(Reflection.getOrCreateKotlinClass(GameMsgTipsEvent.ShowTips.class).getQualifiedName(), this.mAction1);
        }
        com.tencent.qqnt.aio.toptips.c cVar2 = this.mManager;
        if (cVar2 != null && (a16 = cVar2.a()) != null && (e16 = a16.e()) != null) {
            e16.b(Reflection.getOrCreateKotlinClass(GameMsgTipsEvent.HideTips.class).getQualifiedName(), this.mAction1);
        }
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    @Nullable
    public View a(@NotNull Object... params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this, (Object) params);
        }
        Intrinsics.checkNotNullParameter(params, "params");
        if (this.mView == null) {
            View inflate = LayoutInflater.from(MobileQQ.sMobileQQ).inflate(R.layout.eam, (ViewGroup) null);
            inflate.setOnClickListener(this);
            ((ImageView) inflate.findViewById(R.id.vjm)).setOnClickListener(this);
            TextView textView = (TextView) inflate.findViewById(R.id.f108186cf);
            if (!TextUtils.isEmpty(this.mTipsContent)) {
                textView.setText(this.mTipsContent);
            }
            this.mView = inflate;
        }
        return this.mView;
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    @Nullable
    public int[] b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (int[]) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    public void g(@NotNull com.tencent.qqnt.aio.toptips.c topTipsManager, int eventType, @NotNull Object... params) {
        AIOSession r16;
        AIOContact c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, topTipsManager, Integer.valueOf(eventType), params);
            return;
        }
        Intrinsics.checkNotNullParameter(topTipsManager, "topTipsManager");
        Intrinsics.checkNotNullParameter(params, "params");
        AIOParam g16 = topTipsManager.a().g();
        if (g16 == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || c16.e() != 105) {
            z16 = false;
        }
        if (!z16) {
            return;
        }
        this.mManager = topTipsManager;
        if (eventType != 1004) {
            if (eventType == 1005) {
                n();
                return;
            }
            return;
        }
        o();
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    public int getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 115;
    }

    @Override // com.tencent.qqnt.aio.toptips.b
    public int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 17;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "view");
            if (view.getId() == R.id.vjm) {
                p();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        com.tencent.qqnt.aio.toptips.c cVar = this.mManager;
        if (cVar != null) {
            cVar.h(this);
        }
    }

    public final void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        com.tencent.qqnt.aio.toptips.c cVar = this.mManager;
        if (cVar != null) {
            cVar.e(this);
        }
    }
}
