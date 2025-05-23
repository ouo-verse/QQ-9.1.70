package com.tencent.mobileqq.search.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.imsdk.BaseConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.addfriend.api.IAddFriendServiceApi;
import com.tencent.mobileqq.addfriend.strategy.IAddAcceptBlockStrategy;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.view.q;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.activity.f;
import com.tencent.mobileqq.troop.utils.ax;
import com.tencent.mobileqq.troop.widget.TroopActiveLayout;
import com.tencent.mobileqq.vas.util.PrettyAccountUtil;
import com.tencent.mobileqq.widget.FolderTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.shadow.dynamic.host.Constant;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b extends qn2.f {
    private lo2.c C;
    private com.tencent.mobileqq.troop.api.observer.b D;
    private ax.c E;

    /* renamed from: e, reason: collision with root package name */
    int f283637e;

    /* renamed from: f, reason: collision with root package name */
    boolean f283638f;

    /* renamed from: h, reason: collision with root package name */
    private jn2.c f283639h;

    /* renamed from: i, reason: collision with root package name */
    private QQAppInterface f283640i;

    /* renamed from: m, reason: collision with root package name */
    private View f283641m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends com.tencent.mobileqq.troop.api.observer.b {
        a() {
        }

        @Override // com.tencent.mobileqq.troop.api.observer.b
        public void g(boolean z16, String str, int i3) {
            if (b.this.C != null && b.this.C.H.equals(str)) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "onQueryJoinTroopCanNoVerify result:" + z16 + "highRiskTroop" + i3);
                }
                b.this.f283640i.removeObserver(b.this.D);
                if (b.this.f283641m != null) {
                    if (z16 && i3 != 0) {
                        ax.c(b.this.f283641m.getContext(), b.this.E, b.this.f283641m, b.this.C);
                        return;
                    }
                    b bVar = b.this;
                    bVar.B(bVar.f283641m.getContext(), b.this.C);
                    b.this.G();
                    return;
                }
                return;
            }
            b.this.f283640i.removeObserver(b.this.D);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.search.presenter.b$b, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    class C8541b implements ax.c {
        C8541b() {
        }

        @Override // com.tencent.mobileqq.troop.utils.ax.c
        public void a(Object... objArr) {
            if (objArr != null && objArr.length == 2) {
                View view = (View) objArr[0];
                b.this.B(view.getContext(), (lo2.c) objArr[1]);
                b.this.G();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ lo2.c f283643d;

        /* compiled from: P */
        /* loaded from: classes18.dex */
        class a implements IAddAcceptBlockStrategy.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ View f283645a;

            a(View view) {
                this.f283645a = view;
            }

            @Override // com.tencent.mobileqq.addfriend.strategy.IAddAcceptBlockStrategy.a
            public void onSuccess() {
                c cVar = c.this;
                b.this.z(this.f283645a, cVar.f283643d);
            }
        }

        c(lo2.c cVar) {
            this.f283643d = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if ("ActiveEntitySearchResultPresenter_add_troop".equals(view.getTag())) {
                EventCollector.getInstance().onViewClicked(view);
                ((IAddAcceptBlockStrategy) QRoute.api(IAddAcceptBlockStrategy.class)).checkAccountIdentity(b.this.f283640i, 10002, view.getContext(), new a(view));
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ lo2.c f283647d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ sn2.c f283648e;

        d(lo2.c cVar, sn2.c cVar2) {
            this.f283647d = cVar;
            this.f283648e = cVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i3;
            EventCollector.getInstance().onViewClickedBefore(view);
            EventCollector.getInstance().onViewClicked(view);
            if (this.f283647d.L0 == 1) {
                ReportController.o(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 0, 0, "", "", "", "");
                ReportController.o(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 2, 0, "", "", "", "");
            } else {
                ReportController.o(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 0, 0, "", "", "", "");
                ReportController.o(null, "dc00898", "", "", "0X800A33B", "0X800A33B", 1, 0, "", "", "", "");
            }
            Boolean valueOf = Boolean.valueOf(((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.f283647d.H), "Q.uniteSearch.ActiveEntitySearchResultPresenter"));
            int i16 = 0;
            Boolean valueOf2 = Boolean.valueOf(((IAddFriendServiceApi) b.this.f283640i.getRuntimeService(IAddFriendServiceApi.class)).hasSendAddFriendReq(this.f283647d.H, false));
            if (!valueOf.booleanValue() && !valueOf2.booleanValue()) {
                boolean O = this.f283647d.O();
                if (QLog.isColorLevel()) {
                    QLog.d("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "click add mobileNumberResult = " + O + ",id = " + this.f283647d.H);
                }
                if (O) {
                    IAddFriendApi iAddFriendApi = (IAddFriendApi) QRoute.api(IAddFriendApi.class);
                    Context context = view.getContext();
                    lo2.c cVar = this.f283647d;
                    ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(view.getContext(), iAddFriendApi.startAddFriend(context, 2, cVar.H, null, 3014, 1, cVar.I, null, null, HardCodeUtil.qqStr(R.string.j6l), null));
                } else {
                    if (this.f283648e.getView() != null) {
                        i16 = this.f283647d.I(this.f283648e.getView().getContext());
                    }
                    if (this.f283647d.T != 99 && i16 != 11) {
                        if (i16 == 10) {
                            i3 = 5;
                        } else {
                            i3 = 3;
                        }
                    } else {
                        i3 = 4;
                    }
                    ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(view.getContext(), ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(view.getContext(), 1, this.f283647d.M(), null, 3020, i3, this.f283647d.I, null, null, view.getContext().getString(R.string.f170028dd), null));
                }
            } else if (valueOf.booleanValue()) {
                this.f283647d.K0 = 2;
                b.this.f283639h.notifyDataSetChanged();
            } else {
                this.f283647d.K0 = 1;
                b.this.f283639h.notifyDataSetChanged();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class e implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ lo2.c f283650d;

        e(lo2.c cVar) {
            this.f283650d = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i3;
            EventCollector.getInstance().onViewClickedBefore(view);
            lo2.c cVar = this.f283650d;
            if (cVar.E0 == 0) {
                ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openGuildInTab(view.getContext(), this.f283650d.H, "", null);
            } else {
                if (cVar.T == 99) {
                    i3 = 246613;
                } else {
                    i3 = 246614;
                }
                IQQGuildRouterApi iQQGuildRouterApi = (IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class);
                Context context = view.getContext();
                lo2.c cVar2 = this.f283650d;
                iQQGuildRouterApi.addGuildByAuthSig(context, cVar2.H, cVar2.G0, i3);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public b(IFaceDecoder iFaceDecoder, int i3, jn2.c cVar) {
        super(iFaceDecoder);
        this.f283638f = false;
        this.D = new a();
        this.E = new C8541b();
        this.f283637e = i3;
        this.f283639h = cVar;
        this.f283640i = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void B(Context context, final lo2.c cVar) {
        int i3;
        int i16;
        int i17;
        int i18;
        if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "joinTroop, ctx = " + context + ", model = " + cVar);
        }
        if (context != null && cVar != null) {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (activity.isFinishing()) {
                    return;
                }
                Intent intent = activity.getIntent();
                if (intent != null) {
                    i16 = intent.getIntExtra("from_type_for_report", 0);
                    i3 = intent.getIntExtra(IProfileCardConst.KEY_FROM_TYPE, 0);
                    if (i16 != 9) {
                        i17 = 112;
                    } else {
                        i17 = 103;
                    }
                    if (!(context instanceof ActiveEntitySearchActivity)) {
                        long[] longArrayExtra = ((Activity) context).getIntent().getLongArrayExtra("group_mask_long_array");
                        if (longArrayExtra != null && longArrayExtra.length == 1 && longArrayExtra[0] == Constant.FROM_ID_UNINSTALL_PLUGIN) {
                            if (i16 == 9) {
                                i17 = 113;
                            } else {
                                i17 = 104;
                            }
                        }
                        if (i3 == 99 || i16 == 11) {
                            if (cVar.f415200r0) {
                                i18 = 30003;
                            } else {
                                i18 = 30007;
                            }
                            i17 = i18;
                        }
                        if (i17 != 103 && i17 != 104) {
                            if (i17 == 112 || i17 == 113) {
                                if (cVar.f415200r0) {
                                    i17 = 30017;
                                } else {
                                    i17 = 30019;
                                }
                            }
                        } else if (cVar.f415200r0) {
                            i17 = BaseConstants.ERR_SVR_FRIENDSHIP_BLACKLIST_LIMIT;
                        } else {
                            i17 = 30015;
                        }
                        com.tencent.mobileqq.troop.g gVar = new com.tencent.mobileqq.troop.g();
                        gVar.f296167a = cVar.H;
                        gVar.f296168b = cVar.I;
                        gVar.f296169c = i17;
                        gVar.f296171e = cVar.G0;
                        com.tencent.mobileqq.troop.activity.f.i0(context, gVar, new f.c() { // from class: com.tencent.mobileqq.search.presenter.a
                            @Override // com.tencent.mobileqq.troop.activity.f.c
                            public final void a(String str, int i19) {
                                b.this.C(cVar, str, i19);
                            }
                        });
                        return;
                    }
                    return;
                }
            }
            i3 = 0;
            i16 = 0;
            if (i16 != 9) {
            }
            if (!(context instanceof ActiveEntitySearchActivity)) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(lo2.c cVar, String str, int i3) {
        String str2 = cVar.H;
        if (str2 != null && str2.equals(str)) {
            if (i3 == 3) {
                cVar.E0 = 2;
            } else if (i3 != 2 && i3 != 4) {
                if (i3 == 1) {
                    cVar.E0 = 0;
                }
            } else {
                cVar.E0 = 1;
            }
            D();
        }
    }

    private void E(View view, lo2.c cVar) {
        VideoReport.setElementId(view, "em_group_result_add");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        HashMap hashMap = new HashMap();
        hashMap.put("group_id", cVar.getUin());
        hashMap.put("group_name", cVar.I);
        VideoReport.setElementParams(view, hashMap);
    }

    private void F(q qVar, lo2.c cVar) {
        String str;
        String str2;
        boolean z16 = true;
        if (cVar.L0 != 1) {
            z16 = false;
        }
        if (cVar.T != 99 && !z16) {
            TextView u16 = qVar.u();
            VideoReport.setElementId(u16, "em_single_result_add");
            VideoReport.setElementExposePolicy(u16, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(u16, ClickPolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(u16, EndExposurePolicy.REPORT_ALL);
            HashMap hashMap = new HashMap();
            hashMap.put("to_uin", cVar.getUin());
            VideoReport.setElementParams(u16, hashMap);
            return;
        }
        View view = qVar.getView();
        if (z16) {
            str = "em_search_people_more_unit";
        } else {
            str = "em_search_people_result_people_unit";
        }
        VideoReport.setElementId(view, str);
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        VideoReport.setElementExposePolicy(view, exposurePolicy);
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        VideoReport.setElementClickPolicy(view, clickPolicy);
        TextView u17 = qVar.u();
        if (z16) {
            str2 = "em_search_people_more_add";
        } else {
            str2 = "em_search_people_result_people_add";
        }
        VideoReport.setElementId(u17, str2);
        VideoReport.setElementExposePolicy(u17, exposurePolicy);
        VideoReport.setElementClickPolicy(u17, clickPolicy);
        VideoReport.setElementEndExposePolicy(u17, EndExposurePolicy.REPORT_ALL);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("to_uin", cVar.getUin());
        VideoReport.setElementParams(u17, hashMap2);
        VideoReport.setElementParams(view, hashMap2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        try {
            ReportController.o((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), "P_CliOper", "Grp_find", "", "grptab", "Clk_join", 0, 0, this.C.H, "", "", "");
        } catch (Throwable unused) {
        }
    }

    private void H(TextView textView, String str) {
        if (str != null && (str.startsWith("http://") || str.startsWith("https://"))) {
            URLDrawable drawable = URLDrawable.getDrawable(str);
            if (drawable.getStatus() != 1 && drawable.getStatus() != 0) {
                drawable.restartDownload();
            }
            Resources resources = textView.getContext().getResources();
            drawable.setBounds(0, 0, BaseAIOUtils.f(14.0f, resources), BaseAIOUtils.f(14.0f, resources));
            textView.setCompoundDrawablePadding(BaseAIOUtils.f(4.0f, resources));
            textView.setCompoundDrawables(null, null, drawable, null);
            return;
        }
        textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public static void x(TextView textView, TextView textView2, CharSequence charSequence, TextView textView3) {
        float f16;
        Paint paint = new Paint();
        if (textView != null && textView2 != null && charSequence != null) {
            int i3 = textView.getContext().getResources().getDisplayMetrics().widthPixels;
            if (textView3 != null) {
                paint.setTextSize(textView3.getTextSize());
                f16 = paint.measureText(textView3.getText(), 0, textView3.getText().length()) + BaseAIOUtils.f(4.0f, textView.getContext().getResources());
                textView3.getLayoutParams().width = (int) f16;
                textView3.setLayoutParams(textView3.getLayoutParams());
                textView3.setPadding(BaseAIOUtils.f(2.0f, textView.getContext().getResources()), 0, BaseAIOUtils.f(2.0f, textView.getContext().getResources()), 0);
            } else {
                f16 = 0.0f;
            }
            float f17 = i3 - BaseAIOUtils.f(89.0f, textView.getContext().getResources());
            if (f16 != 0.0f) {
                f17 -= f16 + BaseAIOUtils.f(6.0f, textView.getContext().getResources());
            }
            paint.setTextSize(textView.getTextSize());
            if (paint.measureText(charSequence, 0, charSequence.length()) > f17) {
                textView.setMaxLines(2);
                textView2.setMaxLines(1);
            } else {
                textView.setMaxLines(1);
                textView2.setMaxLines(2);
            }
        }
    }

    public static void y(ImageView imageView, ImageView imageView2, int i3) {
        if (i3 == 1) {
            Drawable drawable = imageView2.getResources().getDrawable(R.drawable.dey);
            imageView.setColorFilter(-1610612736, PorterDuff.Mode.SRC_OVER);
            imageView2.setImageDrawable(drawable);
            imageView2.setScaleType(ImageView.ScaleType.CENTER);
            imageView2.setVisibility(0);
            return;
        }
        if (i3 == 2) {
            Drawable drawable2 = imageView2.getResources().getDrawable(R.drawable.dfd);
            imageView.setColorFilter(-1610612736, PorterDuff.Mode.SRC_OVER);
            imageView2.setImageDrawable(drawable2);
            imageView2.setScaleType(ImageView.ScaleType.CENTER);
            imageView2.setVisibility(0);
            return;
        }
        imageView.setColorFilter(0);
        imageView2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(View view, lo2.c cVar) {
        this.f283641m = view;
        this.C = cVar;
        com.tencent.mobileqq.troop.api.observer.b bVar = this.D;
        if (bVar != null) {
            this.f283640i.addObserver(bVar);
            try {
                ((com.tencent.mobileqq.troop.api.handler.h) this.f283640i.getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER)).v0(Long.parseLong(cVar.H), Long.valueOf(this.f283640i.getCurrentUin()).longValue(), null);
                return;
            } catch (Exception e16) {
                e16.printStackTrace();
                return;
            }
        }
        B(view.getContext(), cVar);
        G();
    }

    public boolean A(int i3) {
        if (i3 == 1001 || i3 == 1002) {
            return false;
        }
        return true;
    }

    public void D() {
        jn2.c cVar = this.f283639h;
        if (cVar != null) {
            cVar.notifyDataSetChanged();
        }
    }

    public void I(View view, CharSequence charSequence, boolean z16) {
        J(view, charSequence, z16, false);
    }

    public void J(View view, CharSequence charSequence, boolean z16, boolean z17) {
        if (view != null) {
            boolean z18 = !TextUtils.isEmpty(charSequence);
            if (z18 && view.getVisibility() != 0) {
                view.setVisibility(0);
                return;
            }
            if (!z18) {
                if (z16 && !z17 && view.getVisibility() != 4) {
                    view.setVisibility(4);
                } else if (view.getVisibility() != 8) {
                    view.setVisibility(8);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x027b  */
    @Override // qn2.f, qn2.d
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(y yVar, sn2.c cVar) {
        int i3;
        int i16;
        int i17;
        if (yVar instanceof lo2.c) {
            lo2.c cVar2 = (lo2.c) yVar;
            this.f283637e = cVar2.J();
            TextView b16 = cVar.b();
            TextView c16 = cVar.c();
            TextView k3 = cVar.k();
            Resources resources = cVar.getView().getContext().getResources();
            if (k3 != null && (i17 = cVar2.Y) != -1) {
                k3.setTextColor(resources.getColor(i17));
            }
            if (cVar instanceof q) {
                q qVar = (q) cVar;
                if (qVar.p() != null) {
                    qVar.p().setVisibility(8);
                }
                if (b16 != null) {
                    H(b16, cVar2.f415187e0);
                }
                if (c16 != null) {
                    H(c16, cVar2.f415188f0);
                }
                int i18 = this.f283637e;
                if (i18 != 1073745984) {
                    switch (i18) {
                        case 1001:
                            if (qVar.s() != null) {
                                qVar.s().j(cVar2.I0, cVar2.f415183a0, cVar2.Z - 1, 1);
                            }
                            if (qVar.v() != null) {
                                if (!TextUtils.isEmpty(cVar2.J0)) {
                                    qVar.v().setText(cVar2.J0);
                                } else {
                                    qVar.v().setText("");
                                }
                            }
                            if (qVar.t() != null && qVar.u() != null) {
                                Boolean valueOf = Boolean.valueOf(((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(cVar2.H), "Q.uniteSearch.ActiveEntitySearchResultPresenter"));
                                Boolean valueOf2 = Boolean.valueOf(((IAddFriendServiceApi) this.f283640i.getRuntimeService(IAddFriendServiceApi.class)).hasSendAddFriendReq(cVar2.H, false));
                                if (valueOf.booleanValue()) {
                                    cVar2.K0 = 2;
                                } else if (valueOf2.booleanValue()) {
                                    cVar2.K0 = 1;
                                }
                                int i19 = cVar2.K0;
                                if (i19 == 0) {
                                    if (!com.tencent.mobileqq.troop.utils.k.l(this.f283640i, cVar2.H)) {
                                        qVar.u().setVisibility(0);
                                        qVar.u().setText(HardCodeUtil.qqStr(R.string.f170028dd));
                                    } else {
                                        qVar.u().setVisibility(8);
                                    }
                                    qVar.t().setVisibility(8);
                                } else if (i19 == 1) {
                                    qVar.u().setVisibility(8);
                                    qVar.t().setVisibility(0);
                                    qVar.t().setText(R.string.f173067h24);
                                } else {
                                    qVar.u().setVisibility(8);
                                    qVar.t().setVisibility(0);
                                    qVar.t().setText(R.string.f170322m9);
                                }
                            }
                            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                            if (qVar.r() != null && qVar.u() != null) {
                                if (com.tencent.mobileqq.troop.utils.k.l(qQAppInterface, cVar2.H)) {
                                    qVar.r().setVisibility(0);
                                    break;
                                } else {
                                    qVar.r().setVisibility(8);
                                    break;
                                }
                            }
                            break;
                        case 1002:
                            if (qVar.q() != null) {
                                qVar.q().setVisibility(0);
                                qVar.q().setLabelType(1);
                                qVar.q().f(cVar2.f415190h0);
                            }
                            ImageView imageView = qVar.N;
                            if (imageView != null) {
                                if ((cVar2.f415186d0 & 2048) != 0) {
                                    imageView.setVisibility(0);
                                } else {
                                    imageView.setVisibility(8);
                                }
                            }
                            ImageView imageView2 = qVar.P;
                            if (imageView2 != null) {
                                imageView2.setVisibility(8);
                                break;
                            }
                            break;
                        case 1003:
                            if (b16 != null) {
                                b16.setCompoundDrawablePadding(BaseAIOUtils.f(4.0f, resources));
                                b16.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.d6u, 0);
                                break;
                            }
                            break;
                        case 1004:
                            break;
                        default:
                            if (k3 != null) {
                                k3.setMaxLines(1);
                                break;
                            }
                            break;
                    }
                    i3 = this.f283637e;
                    if (i3 != 1002) {
                        View h16 = cVar.h("ActiveEntitySearchResultPresenter_add_troop");
                        Pair pair = (Pair) cVar2.n("ActiveEntitySearchResultPresenter_add_troop");
                        if (h16 != null && pair != null) {
                            h16.setVisibility(0);
                            if (h16 instanceof TextView) {
                                TextView textView = (TextView) h16;
                                textView.setText((CharSequence) pair.first);
                                textView.setEnabled(((Boolean) pair.second).booleanValue());
                            }
                        }
                        View h17 = cVar.h("ActiveEntitySearchResultPresenter_pay_troop");
                        Boolean bool = (Boolean) cVar2.n("ActiveEntitySearchResultPresenter_pay_troop");
                        if (bool == null) {
                            bool = Boolean.FALSE;
                        }
                        if (h17 != null) {
                            if (bool.booleanValue()) {
                                i16 = 0;
                            } else {
                                i16 = 8;
                            }
                            h17.setVisibility(i16);
                        }
                        View h18 = cVar.h("ActiveEntitySearchResultPresenter_hot_troop");
                        Integer num = (Integer) cVar2.n("ActiveEntitySearchResultPresenter_hot_troop");
                        if (num == null) {
                            num = 0;
                        }
                        if (h18 instanceof TroopActiveLayout) {
                            if (num.intValue() > 0) {
                                h18.setVisibility(0);
                                ((TroopActiveLayout) h18).setHotLevel(num.intValue());
                            } else {
                                h18.setVisibility(8);
                            }
                        }
                        View h19 = cVar.h("ActiveEntitySearchResultPresenter_expand_desc");
                        CharSequence description = cVar2.getDescription();
                        if ((h19 instanceof FolderTextView) && description != null) {
                            ((FolderTextView) h19).setText(new QQText(description, 11, 16));
                        }
                    } else if (i3 == 1107) {
                        View h26 = cVar.h("ActiveEntitySearchResultPresenter_add_troop");
                        Pair pair2 = (Pair) cVar2.n("ActiveEntitySearchResultPresenter_add_troop");
                        if (h26 != null && pair2 != null) {
                            h26.setVisibility(0);
                            if (h26 instanceof TextView) {
                                TextView textView2 = (TextView) h26;
                                textView2.setText((CharSequence) pair2.first);
                                textView2.setEnabled(((Boolean) pair2.second).booleanValue());
                            }
                        }
                    }
                    super.a(cVar2, cVar);
                    J(cVar.b(), cVar2.getTitleSpans(), true, false);
                    I(cVar.c(), cVar2.getSubTitleSpans(), false);
                    I(cVar.k(), cVar2.getDescription(), false);
                    I(cVar.d(), cVar2.o(), false);
                    if (this.f283637e != 1001 && TextUtils.isEmpty(cVar2.V)) {
                        TextView c17 = cVar.c();
                        c17.setText(cVar2.getSubTitleSpans());
                        PrettyAccountUtil.handleAccountClothForList(c17, cVar2.f415184b0, cVar2.f415185c0, 17);
                        PrettyAccountUtil.reportLhEvent("0X800B237", cVar2.f415184b0, cVar2.f415185c0);
                        return;
                    }
                    return;
                }
                x(b16, k3, cVar2.getTitleSpans(), null);
                i3 = this.f283637e;
                if (i3 != 1002) {
                }
                super.a(cVar2, cVar);
                J(cVar.b(), cVar2.getTitleSpans(), true, false);
                I(cVar.c(), cVar2.getSubTitleSpans(), false);
                I(cVar.k(), cVar2.getDescription(), false);
                I(cVar.d(), cVar2.o(), false);
                if (this.f283637e != 1001) {
                    return;
                } else {
                    return;
                }
            }
            QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "View is not SearchResultFromNetView. View = " + cVar);
            throw new RuntimeException("View is not SearchResultFromNetView. View = " + cVar);
        }
        QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 2, "Model is not GroupBaseNetSearchModelItem type. m = " + yVar);
        throw new RuntimeException("Model is not GroupBaseNetSearchModelItem type. m = " + yVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // qn2.f
    public void h(y yVar, sn2.c cVar) {
        View h16;
        super.h(yVar, cVar);
        if (yVar instanceof lo2.c) {
            lo2.c cVar2 = (lo2.c) yVar;
            if (cVar2.J() == 1002) {
                View h17 = cVar.h("ActiveEntitySearchResultPresenter_add_troop");
                if (h17 != null) {
                    E(h17, cVar2);
                    h17.setOnClickListener(new c(cVar2));
                    return;
                }
                return;
            }
            if (cVar2.J() == 1001) {
                q qVar = (q) cVar;
                if (qVar.u() != null) {
                    F(qVar, cVar2);
                    qVar.u().setOnClickListener(new d(cVar2, cVar));
                    return;
                }
                return;
            }
            if (cVar2.J() == 1107 && (h16 = cVar.h("ActiveEntitySearchResultPresenter_add_troop")) != null) {
                h16.setOnClickListener(new e(cVar2));
            }
        }
    }

    @Override // qn2.f, qn2.c
    /* renamed from: i */
    public void c(y yVar, sn2.c cVar) {
        ImageView f16 = cVar.f();
        if (f16 == null) {
            return;
        }
        try {
            if ((yVar instanceof lo2.c) && (cVar instanceof q)) {
                lo2.c cVar2 = (lo2.c) yVar;
                q qVar = (q) cVar;
                ViewGroup.LayoutParams layoutParams = f16.getLayoutParams();
                if (this.f283638f) {
                    layoutParams.height = BaseAIOUtils.f(30.0f, f16.getContext().getResources());
                } else {
                    if (cVar2.J() != 8192 && cVar2.J() != 16 && cVar2.J() != 8) {
                        if (cVar2.J() == 1001) {
                            layoutParams.height = BaseAIOUtils.f(60.0f, f16.getContext().getResources());
                        } else if (cVar2.J() != 1024 && cVar2.J() != 1002 && cVar2.J() != 1107) {
                            layoutParams.height = f16.getResources().getDimensionPixelSize(R.dimen.ajm);
                        }
                    }
                    layoutParams.height = BaseAIOUtils.f(70.0f, f16.getContext().getResources());
                }
                f16.setLayoutParams(layoutParams);
                if (qVar.o() != null) {
                    qVar.o().setLayoutParams(layoutParams);
                }
                if (cVar2.J() != 1001 && cVar2.J() != 1002) {
                    int dimensionPixelSize = cVar.getView().getResources().getDimensionPixelSize(R.dimen.f159238y4);
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    obtain.mRequestWidth = dimensionPixelSize;
                    obtain.mRequestHeight = dimensionPixelSize;
                    if (cVar2.W) {
                        obtain.mMemoryCacheKeySuffix = "isAvatar";
                    }
                    if (this.f283638f) {
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        gradientDrawable.setColor(Color.parseColor("#ECEAE8"));
                        gradientDrawable.setShape(1);
                        obtain.mLoadingDrawable = gradientDrawable;
                        obtain.mFailedDrawable = gradientDrawable;
                    }
                    URLDrawable drawable = URLDrawable.getDrawable(cVar2.H(), obtain);
                    if (cVar2.W) {
                        drawable.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306322b);
                    }
                    if (drawable.getStatus() != 1 && drawable.getStatus() != 0) {
                        drawable.restartDownload();
                    }
                    cVar.f().setImageDrawable(drawable);
                } else if (cVar2.J() == 1001) {
                    if (cVar.f() != null) {
                        cVar.f().setImageDrawable(SearchUtils.v(this.f429094d, cVar2.M(), cVar2.k()));
                    }
                } else {
                    super.c(yVar, cVar);
                }
                if (cVar.f() != null && qVar.o() != null) {
                    y(cVar.f(), qVar.o(), cVar2.X);
                    return;
                }
                return;
            }
            super.c(yVar, cVar);
        } catch (Exception e16) {
            QLog.e("Q.uniteSearch.ActiveEntitySearchResultPresenter", 1, "get face drawable error:" + e16.toString());
        }
    }

    @Override // qn2.f
    public void m(y yVar, sn2.c cVar) {
        if ((yVar instanceof lo2.c) && !this.f283638f && A(((lo2.c) yVar).J())) {
            rn2.k.b(yVar.p(), yVar.q(), cVar.getView(), ((lo2.c) yVar).f283548i);
        }
    }

    public b(IFaceDecoder iFaceDecoder, int i3) {
        super(iFaceDecoder);
        this.f283638f = false;
        this.D = new a();
        this.E = new C8541b();
        this.f283637e = i3;
        this.f283640i = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
    }
}
