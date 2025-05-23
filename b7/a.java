package b7;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.qzone.common.business.model.AvatarCacheData;
import com.qzone.cover.ui.QzoneAvatarDecorator;
import com.qzone.cover.ui.QzoneFacadeDecorator;
import com.qzone.cover.ui.QzoneVipAnimateDecorator;
import com.qzone.cover.ui.QzoneVipDecorator;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.qzone.util.am;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private View f28010a;

    public a(Context context) {
        this.f28010a = LayoutInflater.from(context).inflate(R.layout.bj7, (ViewGroup) null, true);
    }

    public View a() {
        return this.f28010a;
    }

    /* compiled from: P */
    /* renamed from: b7.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public static class C0103a extends g {
        public QzoneAvatarDecorator E;
        public QzoneFacadeDecorator F;
        public QzoneVipDecorator G;
        private QzoneVipAnimateDecorator H;
        private ActionSheet I;
        private String J;
        private z6.a K;
        private com.qzone.reborn.feedx.widget.header.c L;
        private ActionSheet.OnButtonClickListener M;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: b7.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes39.dex */
        public class ViewOnClickListenerC0104a implements View.OnClickListener {
            ViewOnClickListenerC0104a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (y6.b.f(C0103a.this.C) && C0103a.this.L != null) {
                    QzoneFacadeDecorator qzoneFacadeDecorator = C0103a.this.F;
                    if (qzoneFacadeDecorator != null && qzoneFacadeDecorator.U != null) {
                        if ("-1".equals(C0103a.this.F.U.strId)) {
                            C0103a.this.L.a();
                            EventCollector.getInstance().onViewClicked(view);
                        }
                        if (C0103a.this.F.U.mapExtInfo != null) {
                            C0103a c0103a = C0103a.this;
                            c0103a.J = c0103a.F.U.mapExtInfo.get(AvatarCacheData.PARAM_NAMEPLATE);
                        }
                        if (C0103a.this.J != null && C0103a.this.J.equals("1")) {
                            C0103a.this.J(R.string.ggb);
                        } else {
                            C0103a.this.J(R.string.ggc);
                        }
                    } else {
                        C0103a.this.L.a();
                    }
                } else {
                    C0103a.this.J(R.string.gnv);
                }
                com.qzone.homepage.diy.util.a.d(6);
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: b7.a$a$b */
        /* loaded from: classes39.dex */
        public class b implements ActionSheet.OnDismissListener {
            b() {
            }

            @Override // com.tencent.widget.ActionSheet.OnDismissListener
            public void onDismiss() {
                if (C0103a.this.K != null) {
                    C0103a.this.K.a();
                }
            }
        }

        /* compiled from: P */
        /* renamed from: b7.a$a$c */
        /* loaded from: classes39.dex */
        class c implements ActionSheet.OnButtonClickListener {
            c() {
            }

            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public void onClick(View view, int i3) {
                String str;
                if (C0103a.this.L == null || C0103a.this.L.getHostActivity() == null) {
                    return;
                }
                if (C0103a.this.I != null) {
                    C0103a.this.I.dismiss();
                }
                switch (C0103a.this.I != null ? C0103a.this.I.getActionMenuItem(i3).action : -1) {
                    case 220:
                        if (!y6.b.f(C0103a.this.C)) {
                            vo.c.c(C0103a.this.L.getHostActivity(), QzoneCoverConst.REFER_USERHOME, C0103a.this.C);
                            return;
                        }
                        QzoneFacadeDecorator qzoneFacadeDecorator = C0103a.this.F;
                        if (qzoneFacadeDecorator != null && qzoneFacadeDecorator.U != null && !"-1".equals(C0103a.this.F.U.strId) && !TextUtils.isEmpty(C0103a.this.F.U.strId)) {
                            if (C0103a.this.J != null && C0103a.this.J.equals("1")) {
                                vo.c.n(C0103a.this.L.getHostActivity());
                                return;
                            } else {
                                vo.c.d(C0103a.this.L.getHostActivity(), C0103a.this.F.U.strId, QzoneCoverConst.REFER_USERHOME, C0103a.this.C);
                                return;
                            }
                        }
                        vo.c.c(C0103a.this.L.getHostActivity(), QzoneCoverConst.REFER_USERHOME, C0103a.this.C);
                        return;
                    case 221:
                        C0103a.this.L.a();
                        return;
                    case 222:
                        if (y6.b.f(C0103a.this.C)) {
                            x6.a aVar = C0103a.this.D;
                            if (aVar != null && (str = aVar.personalizedYellowVipUrl) != null) {
                                String f16 = am.f(str);
                                if (!am.h(f16)) {
                                    vo.c.Q(C0103a.this.L.getHostActivity(), f16);
                                }
                            }
                        } else {
                            vo.c.O(C0103a.this.L.getHostActivity(), C0103a.this.C);
                        }
                        ClickReport.c(308, 65, "1", false, new String[0]);
                        return;
                    default:
                        return;
                }
            }
        }

        public C0103a(String str, View view) {
            super(str, view);
            this.J = null;
            this.M = new c();
        }

        private View.OnClickListener H() {
            return new ViewOnClickListenerC0104a();
        }

        public void G(com.qzone.reborn.feedx.widget.header.c cVar) {
            this.L = cVar;
        }

        public void I(z6.a aVar) {
            this.K = aVar;
        }

        public void J(int i3) {
            x6.a aVar;
            com.qzone.reborn.feedx.widget.header.c cVar = this.L;
            if (cVar != null && cVar.getHostActivity() != null) {
                z6.a aVar2 = this.K;
                if (aVar2 != null) {
                    aVar2.b();
                }
                try {
                    boolean z16 = (y6.b.f(this.C) && ((aVar = this.D) == null || aVar.personalizedYellowVipUrl == null)) ? false : true;
                    ArrayList arrayList = new ArrayList();
                    if (z16) {
                        arrayList.add(new ActionMenuItem(ActionSheetHelper.getStringById(this.f395367e.getContext(), y6.b.f(this.C) ? R.string.ggd : R.string.f173045go1), 222, 0));
                    }
                    arrayList.add(new ActionMenuItem(ActionSheetHelper.getStringById(this.f395367e.getContext(), i3), 220, 0));
                    arrayList.add(new ActionMenuItem(ActionSheetHelper.getStringById(this.f395367e.getContext(), R.string.ggj), 221, 0));
                    if (QLog.isDebugVersion()) {
                        arrayList.add(new ActionMenuItem("\u3010Debug\u3011\u9009\u62e9WNS\u6d4b\u8bd5\u73af\u5883", 228, 0));
                    }
                    ActionSheet createActionSheet = ActionSheetHelper.createActionSheet(this.L.getHostActivity(), arrayList, this.M);
                    this.I = createActionSheet;
                    createActionSheet.addCancelButton(R.string.cancel);
                    this.I.setOutsideDismissEnable(true);
                    this.I.setOnDismissListener(new b());
                    this.I.show();
                    return;
                } catch (Exception e16) {
                    QZLog.w(e16);
                    return;
                }
            }
            QZLog.e("JsonInflateViewModel", 1, "showFacadeActionSheetDialog with context = null");
        }

        @Override // e15.f
        public void p() {
            ViewGroup.MarginLayoutParams marginLayoutParams;
            super.p();
            View view = this.f395367e;
            if (view == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()) == null) {
                return;
            }
            marginLayoutParams.width = ViewUtils.dip2px(120.0f);
            marginLayoutParams.height = ViewUtils.dip2px(115.0f);
            marginLayoutParams.topMargin -= (ViewUtils.dip2px(115.0f) - ViewUtils.dip2px(67.0f)) / 2;
            marginLayoutParams.leftMargin -= (ViewUtils.dip2px(120.0f) - ViewUtils.dip2px(67.0f)) / 2;
            marginLayoutParams.topMargin += (ViewUtils.dip2px(105.0f) - ViewUtils.dip2px(67.0f)) / 2;
            marginLayoutParams.leftMargin += (ViewUtils.dip2px(92.0f) - ViewUtils.dip2px(67.0f)) / 2;
            this.f395367e.setLayoutParams(marginLayoutParams);
        }

        @Override // b7.g
        String u() {
            return "qzone_avatar_view";
        }

        @Override // b7.g
        void v() {
            QzoneAvatarDecorator qzoneAvatarDecorator = (QzoneAvatarDecorator) this.f395367e.findViewById(R.id.f166698hf1);
            this.E = qzoneAvatarDecorator;
            qzoneAvatarDecorator.setContentDescription(this.f395367e.getContext().getResources().getText(R.string.gqm));
            this.F = (QzoneFacadeDecorator) this.f395367e.findViewById(R.id.hex);
            this.E.setLocationOffest((ViewUtils.dip2px(120.0f) - ViewUtils.dip2px(67.0f)) / 2, (ViewUtils.dip2px(115.0f) - ViewUtils.dip2px(67.0f)) / 2);
            this.F.setLocationOffest((ViewUtils.dip2px(120.0f) - ViewUtils.dip2px(67.0f)) / 2, (ViewUtils.dip2px(115.0f) - ViewUtils.dip2px(67.0f)) / 2);
            this.G = (QzoneVipDecorator) this.f395367e.findViewById(R.id.hez);
            this.H = (QzoneVipAnimateDecorator) this.f395367e.findViewById(R.id.f166697hf0);
            this.E.setFacadeDecorator(this.F);
            this.G.setLocationOffest((ViewUtils.dip2px(120.0f) - ViewUtils.dip2px(67.0f)) / 2, 0);
            this.E.setOnClickListener(H());
        }

        @Override // b7.g
        Object w(String str) {
            return null;
        }

        @Override // b7.g
        public void z(long j3, x6.a aVar) {
            super.z(j3, aVar);
            this.E.c((Activity) this.f395367e.getContext(), j3 + "");
            this.F.r((Activity) this.f395367e.getContext(), j3 + "", true);
            this.G.w((Activity) this.f395367e.getContext(), j3 + "", true);
            this.E.d();
            this.F.d();
            this.G.d();
            com.qzone.reborn.feedx.widget.header.c cVar = this.L;
            if (cVar != null) {
                this.G.r(cVar.getLifecycle());
            }
            if (this.H.n(2, String.valueOf(this.C), this.G.u())) {
                this.G.setVisibility(8);
                return;
            }
            this.H.j();
            this.H.setVisibility(8);
            this.G.setVisibility(0);
        }

        @Override // b7.g
        void A(Object obj) {
        }
    }
}
