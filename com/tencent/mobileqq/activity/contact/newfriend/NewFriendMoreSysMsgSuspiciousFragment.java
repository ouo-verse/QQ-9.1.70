package com.tencent.mobileqq.activity.contact.newfriend;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.adapter.j;
import com.tencent.mobileqq.adapter.k;
import com.tencent.mobileqq.addfriend.strategy.IAddAcceptBlockStrategy;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.data.SysSuspiciousMsg;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ay;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.widget.AbsListView;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipRightMenuBuilder;
import com.tencent.widget.SwipTextViewMenuBuilder;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes10.dex */
public class NewFriendMoreSysMsgSuspiciousFragment extends PublicBaseFragment {
    static IPatchRedirector $redirector_;
    private static boolean G;
    private SwipListView C;
    private View D;
    private SysMsgSuspiciousAdapter E;
    private QUISecNavBar F;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class SysMsgSuspiciousAdapter extends j implements View.OnClickListener, SwipListView.SwipListListener, SwipListView.RightIconMenuListener {
        static IPatchRedirector $redirector_;
        private static final int[] V;
        private static final int[] W;
        private static final int[] X;
        private final Object F;
        private QQAppInterface G;
        private INewFriendService H;
        private Context I;
        private View J;
        private SwipRightMenuBuilder K;
        private List<SysSuspiciousMsg> L;
        private TopGestureLayout M;
        private FriendListHandler N;
        private SparseArray<byte[]> P;
        private int Q;
        private int R;
        private int S;
        private ar T;
        private int U;

        /* compiled from: P */
        /* loaded from: classes10.dex */
        class a extends ar {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SysMsgSuspiciousAdapter.this);
                }
            }

            @Override // com.tencent.mobileqq.app.ar
            public void onAgreeSuspiciousMsg(boolean z16, int i3, long j3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Integer.valueOf(i3), Long.valueOf(j3));
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "onAgreeSuspiciousMsg " + z16 + " " + i3);
                }
                if (z16) {
                    QQToast.makeText(SysMsgSuspiciousAdapter.this.I, HardCodeUtil.qqStr(R.string.ooo), 0).show();
                    SysMsgSuspiciousAdapter.this.v(j3);
                    SysMsgSuspiciousAdapter.this.y();
                    return;
                }
                QQToast.makeText(SysMsgSuspiciousAdapter.this.I, HardCodeUtil.qqStr(R.string.op9), 0).show();
            }

            @Override // com.tencent.mobileqq.app.ar
            public void onSuspiciousDel(boolean z16, int i3, long j3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Integer.valueOf(i3), Long.valueOf(j3));
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "onSuspiciousDel " + z16 + " " + i3 + " " + j3);
                }
                if (z16) {
                    SysMsgSuspiciousAdapter.this.y();
                }
            }

            @Override // com.tencent.mobileqq.app.ar
            public void onSuspiciousGetList(boolean z16, int i3, ArrayList<SysSuspiciousMsg> arrayList, byte[] bArr, Object obj) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), arrayList, bArr, obj);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "onSuspiciousGetList " + z16 + " " + i3 + " " + obj);
                }
                if (z16) {
                    if (obj instanceof Integer) {
                        SysMsgSuspiciousAdapter.this.P.put(((Integer) obj).intValue(), bArr);
                    }
                    if (arrayList != null) {
                        SysMsgSuspiciousAdapter.this.R += arrayList.size();
                    }
                    SysMsgSuspiciousAdapter.this.y();
                }
            }

            @Override // com.tencent.mobileqq.app.ar
            public void onSuspiciousSendReadReport(boolean z16, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Integer.valueOf(i3));
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "onSuspiciousSendReadReport " + z16 + " " + i3);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes10.dex */
        public class b extends SwipTextViewMenuBuilder {
            static IPatchRedirector $redirector_;

            b(int i3, int i16, int[] iArr, int i17, int[] iArr2, int[] iArr3, int[] iArr4) {
                super(i3, i16, iArr, i17, iArr2, iArr3, iArr4);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, SysMsgSuspiciousAdapter.this, Integer.valueOf(i3), Integer.valueOf(i16), iArr, Integer.valueOf(i17), iArr2, iArr3, iArr4);
                }
            }

            @Override // com.tencent.widget.SwipRightMenuBuilder
            public void getRightMenuItemInfo(int i3, Object obj, SwipRightMenuBuilder.SwipRightMenuItem[] swipRightMenuItemArr) {
                IPatchRedirector iPatchRedirector = $redirector_;
                int i16 = 1;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), obj, swipRightMenuItemArr);
                    return;
                }
                if (swipRightMenuItemArr != null && swipRightMenuItemArr.length > 0) {
                    if (swipRightMenuItemArr.length > 0) {
                        SwipRightMenuBuilder.SwipRightMenuItem swipRightMenuItem = swipRightMenuItemArr[0];
                        swipRightMenuItem.menuId = 0;
                        swipRightMenuItem.menuType = 0;
                    } else {
                        i16 = 0;
                    }
                    while (i16 < swipRightMenuItemArr.length) {
                        SwipRightMenuBuilder.SwipRightMenuItem swipRightMenuItem2 = swipRightMenuItemArr[i16];
                        swipRightMenuItem2.menuId = -1;
                        swipRightMenuItem2.menuType = -1;
                        i16++;
                    }
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes10.dex */
        class c implements IAddAcceptBlockStrategy.a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ d f181269a;

            c(d dVar) {
                this.f181269a = dVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SysMsgSuspiciousAdapter.this, (Object) dVar);
                }
            }

            @Override // com.tencent.mobileqq.addfriend.strategy.IAddAcceptBlockStrategy.a
            public void onSuccess() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    SysMsgSuspiciousAdapter.this.N.agreeSuspiciousMsg(this.f181269a.G.uin);
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes10.dex */
        public static class d extends k {
            static IPatchRedirector $redirector_;
            public TextView C;
            public TextView D;
            public Button E;
            public TextView F;
            public SysSuspiciousMsg G;

            /* renamed from: i, reason: collision with root package name */
            public TextView f181271i;

            /* renamed from: m, reason: collision with root package name */
            public TextView f181272m;

            public d() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67922);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 18)) {
                redirector.redirect((short) 18);
                return;
            }
            V = new int[]{R.string.f170822ak3};
            W = new int[]{R.drawable.cja};
            X = new int[]{R.id.epz};
        }

        public SysMsgSuspiciousAdapter(Context context, QQAppInterface qQAppInterface, SwipListView swipListView, View view) {
            super(context, qQAppInterface, swipListView, 1, true);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, context, qQAppInterface, swipListView, view);
                return;
            }
            this.L = new ArrayList(0);
            this.P = new SparseArray<>(20);
            this.R = -1;
            this.S = -1;
            this.T = new a();
            this.U = -1;
            this.G = qQAppInterface;
            this.I = context;
            this.K = t(context);
            this.J = view;
            this.F = new Object();
            swipListView.setRightIconMenuListener(this);
            g(this);
            this.H = (INewFriendService) qQAppInterface.getRuntimeService(INewFriendService.class);
            this.N = (FriendListHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
            z();
            this.N.sendReadReportSuspicious();
        }

        private void A(d dVar, SysSuspiciousMsg sysSuspiciousMsg) {
            int i3;
            int i16 = sysSuspiciousMsg.sex;
            boolean z16 = true;
            if (i16 != 1) {
                if (i16 != 2) {
                    dVar.f181272m.setBackgroundResource(R.drawable.ah8);
                    i3 = 0;
                    z16 = false;
                } else {
                    dVar.f181272m.setBackgroundResource(R.drawable.ah7);
                    i3 = R.drawable.f161849f53;
                }
            } else {
                dVar.f181272m.setBackgroundResource(R.drawable.ah8);
                i3 = R.drawable.f161850f54;
            }
            dVar.f181272m.setText(sysSuspiciousMsg.age + "");
            dVar.f181272m.setCompoundDrawablesWithIntrinsicBounds(i3, 0, 0, 0);
            if (z16) {
                dVar.f181272m.setVisibility(0);
            } else {
                dVar.f181272m.setVisibility(8);
            }
        }

        private void B(Context context, View view, int i3, Object obj, SwipRightMenuBuilder.SwipItemBaseHolder swipItemBaseHolder, View.OnClickListener onClickListener) {
            int i16;
            SwipRightMenuBuilder swipRightMenuBuilder = this.K;
            if (swipRightMenuBuilder != null) {
                i16 = swipRightMenuBuilder.updateRightMenuView(context, view, i3, obj, swipItemBaseHolder, onClickListener);
            } else {
                i16 = 0;
            }
            int i17 = this.U;
            if (i17 != -1) {
                if (i3 != i17) {
                    view.scrollTo(0, 0);
                } else {
                    view.scrollTo(i16, 0);
                }
            }
        }

        private void r(d dVar) {
            if (QQTheme.isNowThemeIsNight()) {
                ((INewFriendApi) QRoute.api(INewFriendApi.class)).setTextNewStyle(dVar.F, dVar.C, dVar.D);
            }
        }

        private void s(d dVar, SysSuspiciousMsg sysSuspiciousMsg) {
            Drawable drawable;
            if (sysSuspiciousMsg == null) {
                dVar.f181271i.setVisibility(8);
                dVar.f181272m.setVisibility(8);
                dVar.C.setVisibility(8);
                dVar.D.setVisibility(8);
                dVar.E.setVisibility(8);
                return;
            }
            dVar.G = sysSuspiciousMsg;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(sysSuspiciousMsg.uin);
            String str = "";
            sb5.append("");
            dVar.f187210d = sb5.toString();
            dVar.leftView.setOnClickListener(this);
            dVar.f187212f.setImageBitmap(c(dVar.f187211e, dVar.f187210d));
            dVar.f181271i.setVisibility(0);
            String b16 = ay.b(String.valueOf(sysSuspiciousMsg.uin));
            if (!TextUtils.isEmpty(b16)) {
                dVar.f181271i.setText(b16);
            } else {
                TextView textView = dVar.f181271i;
                String str2 = sysSuspiciousMsg.nick;
                if (str2 != null) {
                    str = str2;
                }
                textView.setText(str);
            }
            A(dVar, sysSuspiciousMsg);
            if (sysSuspiciousMsg.f203119msg == null) {
                dVar.C.setVisibility(8);
            } else {
                dVar.C.setVisibility(0);
                dVar.C.setText(sysSuspiciousMsg.f203119msg);
            }
            if (sysSuspiciousMsg.reason == null) {
                dVar.D.setVisibility(8);
            } else {
                dVar.D.setVisibility(0);
                dVar.D.setText(sysSuspiciousMsg.reason);
                if (NewFriendMoreSysMsgSuspiciousFragment.G) {
                    drawable = this.I.getResources().getDrawable(R.drawable.nwt);
                } else {
                    drawable = this.I.getResources().getDrawable(R.drawable.qzone_commo_black_tips_icon_caution);
                }
                drawable.setBounds(0, 0, ViewUtils.dip2px(16.0f), ViewUtils.dip2px(16.0f));
                dVar.D.setCompoundDrawablePadding(ViewUtils.dip2px(5.0f));
                dVar.D.setCompoundDrawables(drawable, null, null, null);
            }
            dVar.E.setVisibility(0);
            dVar.E.setText(HardCodeUtil.qqStr(R.string.op_));
            dVar.E.setOnClickListener(this);
            dVar.E.setTag(dVar);
        }

        private SwipRightMenuBuilder t(Context context) {
            return new b(1, 1, new int[]{context.getResources().getDimensionPixelSize(R.dimen.atw), context.getResources().getDimensionPixelSize(R.dimen.atx)}, -1, X, V, W);
        }

        private void u(boolean z16) {
            if (this.M == null) {
                ViewGroup viewGroup = (ViewGroup) ((Activity) this.I).getWindow().getDecorView();
                View childAt = viewGroup.getChildAt(0);
                if (childAt != null && (childAt instanceof DragFrameLayout)) {
                    viewGroup = (ViewGroup) childAt;
                }
                View childAt2 = viewGroup.getChildAt(0);
                if (childAt2 instanceof TopGestureLayout) {
                    this.M = (TopGestureLayout) childAt2;
                }
            }
            TopGestureLayout topGestureLayout = this.M;
            if (topGestureLayout != null) {
                topGestureLayout.setInterceptTouchFlag(z16);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void v(long j3) {
            SysSuspiciousMsg sysSuspiciousMsg;
            Iterator<SysSuspiciousMsg> it = this.L.iterator();
            while (true) {
                if (it.hasNext()) {
                    sysSuspiciousMsg = it.next();
                    if (sysSuspiciousMsg.uin == j3) {
                        break;
                    }
                } else {
                    sysSuspiciousMsg = null;
                    break;
                }
            }
            if (sysSuspiciousMsg != null) {
                Bundle bundle = new Bundle();
                bundle.putString("base_uin", String.valueOf(sysSuspiciousMsg.uin));
                bundle.putString("base_nick", sysSuspiciousMsg.nick);
                bundle.putInt("verfy_type", 0);
                bundle.putString("verfy_msg", sysSuspiciousMsg.f203119msg);
                AutoRemarkActivity.startRemarkAfterAgree((Activity) this.I, 0, sysSuspiciousMsg.uin + "", 0L, bundle);
            }
        }

        private void z() {
            if (QLog.isColorLevel()) {
                QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "requestSuspiciousMsgNextPage " + this.S);
            }
            if (!NetworkUtil.isNetworkAvailable(this.I)) {
                return;
            }
            byte[] bArr = this.P.get(this.S);
            int i3 = this.S;
            if (i3 >= 0 && bArr == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "requestSuspiciousMsgNextPage no cookie");
                }
            } else {
                int i16 = i3 + 1;
                this.S = i16;
                this.N.getSuspiciousMsgList(50, bArr, Integer.valueOf(i16));
            }
        }

        @Override // com.tencent.mobileqq.adapter.j
        public void destroy() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                this.G.removeObserver(this.T);
                super.destroy();
            }
        }

        @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            List<SysSuspiciousMsg> list = this.L;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return iPatchRedirector.redirect((short) 12, (Object) this, i3);
            }
            List<SysSuspiciousMsg> list = this.L;
            if (list != null && i3 < list.size()) {
                return this.L.get(i3);
            }
            return null;
        }

        @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            d dVar;
            SysSuspiciousMsg sysSuspiciousMsg;
            View view2;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                view2 = (View) iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                if (view == null) {
                    d dVar2 = new d();
                    View inflate = LayoutInflater.from(this.I).inflate(R.layout.b3_, (ViewGroup) null);
                    View createView = this.K.createView(this.I, inflate, dVar2, -1);
                    dVar2.f187212f = (ImageView) createView.findViewById(R.id.f163821d);
                    dVar2.f181271i = (TextView) createView.findViewById(R.id.nickname);
                    dVar2.f181272m = (TextView) createView.findViewById(R.id.f164064iz);
                    dVar2.C = (TextView) createView.findViewById(R.id.i95);
                    dVar2.D = (TextView) createView.findViewById(R.id.iz7);
                    dVar2.E = (Button) createView.findViewById(R.id.i8s);
                    dVar2.F = (TextView) createView.findViewById(R.id.f166787i92);
                    ImageView imageView = dVar2.f187212f;
                    if (imageView instanceof ThemeImageView) {
                        ((ThemeImageView) imageView).setSupportMaskView(true);
                    }
                    createView.setTag(dVar2);
                    inflate.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
                    if (SimpleUIUtil.isNowElderMode()) {
                        int dimensionPixelSize = this.I.getResources().getDimensionPixelSize(R.dimen.cai);
                        dVar2.E.setMinimumWidth(dimensionPixelSize);
                        dVar2.E.setMinimumHeight(dimensionPixelSize);
                    }
                    createView.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
                    dVar = dVar2;
                    view = createView;
                } else {
                    dVar = (d) view.getTag();
                }
                B(this.I, view, i3, this.F, dVar, this);
                Object item = getItem(i3);
                if (item instanceof SysSuspiciousMsg) {
                    sysSuspiciousMsg = (SysSuspiciousMsg) item;
                } else {
                    sysSuspiciousMsg = null;
                }
                s(dVar, sysSuspiciousMsg);
                dVar.leftView.setTag(dVar);
                if (i3 == 0) {
                    view.setPadding(0, ViewUtils.dip2px(12.0f), 0, 0);
                } else {
                    view.setPadding(0, 0, 0, 0);
                }
                if (NewFriendMoreSysMsgSuspiciousFragment.G && sysSuspiciousMsg != null) {
                    ((INewFriendApi) QRoute.api(INewFriendApi.class)).showGenderAgeNewStyle(dVar.f181272m, sysSuspiciousMsg.sex, sysSuspiciousMsg.age, null);
                    ((INewFriendApi) QRoute.api(INewFriendApi.class)).setTextNewStyle(dVar.F, dVar.C, dVar.D);
                }
                r(dVar);
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }

        @Override // com.tencent.widget.SwipListView.SwipListListener
        public void hideMenuPop() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                iPatchRedirector.redirect((short) 16, (Object) this);
            }
        }

        @Override // com.tencent.widget.SwipListView.SwipListListener
        public void interceptTouchEvent(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                iPatchRedirector.redirect((short) 17, (Object) this, z16);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this, (Object) view);
            } else {
                Object tag = view.getTag();
                int id5 = view.getId();
                if (id5 == R.id.ibi) {
                    if (tag instanceof d) {
                        ReportController.o(this.G, "dc00898", "", "", "0X800A32E", "0X800A32E", 0, 0, "", "", "", "");
                        Intent intent = new Intent();
                        intent.putExtra("msg_extra", ((d) tag).G);
                        intent.putExtra(QQHealthReportApiImpl.MSG_TYPE_KEY, -1006);
                        ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).startAddRequestSuspiciousPage(this.I, intent);
                    }
                } else if (id5 == R.id.i8s) {
                    if (tag instanceof d) {
                        ReportController.o(this.G, "dc00898", "", "", "0X800A32C", "0X800A32C", 1, 0, "", "", "", "");
                        d dVar = (d) tag;
                        if (NewFriendMoreSysMsgSuspiciousFragment.G && dVar != null) {
                            ReportController.o(this.G, "dc00898", "", "", "0X800C07F", "0X800C07F", 4, 0, dVar.f187210d, "", "", "");
                        }
                        if (!NetworkUtil.isNetworkAvailable(this.I)) {
                            QQToast.makeText(this.I, R.string.cib, 0).show();
                        } else {
                            if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(dVar.f187210d), "NewFriendMoreSysMsgSuspiciousFragment")) {
                                QQToast.makeText(this.I, HardCodeUtil.qqStr(R.string.op5), 0).show();
                            } else if (this.N != null) {
                                ((IAddAcceptBlockStrategy) QRoute.api(IAddAcceptBlockStrategy.class)).checkAccountIdentity(this.G, 10005, this.I, new c(dVar));
                            }
                        }
                    }
                } else if (id5 == R.id.epz) {
                    Object tag2 = view.getTag(-1);
                    if (tag2 instanceof Integer) {
                        ReportController.o(this.G, "dc00898", "", "", "0X800A32D", "0X800A32D", 0, 0, "", "", "", "");
                        int intValue = ((Integer) tag2).intValue();
                        if (!NetworkUtil.isNetworkAvailable(this.I)) {
                            QQToast.makeText(this.I, R.string.cib, 0).show();
                        } else {
                            Object item = getItem(intValue);
                            if (item instanceof SysSuspiciousMsg) {
                                SysSuspiciousMsg sysSuspiciousMsg = (SysSuspiciousMsg) item;
                                FriendListHandler friendListHandler = this.N;
                                if (friendListHandler != null) {
                                    friendListHandler.deleteSuspiciousMsg(sysSuspiciousMsg.uin);
                                }
                            }
                        }
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // com.tencent.widget.SwipListView.RightIconMenuListener
        public void onRightIconMenuHide(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
            } else {
                u(true);
            }
        }

        @Override // com.tencent.widget.SwipListView.RightIconMenuListener
        public void onRightIconMenuShow(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
            } else {
                u(false);
            }
        }

        @Override // com.tencent.mobileqq.adapter.j, com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            } else {
                this.Q = (i3 + i16) - 1;
            }
        }

        @Override // com.tencent.mobileqq.adapter.j, com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) absListView, i3);
                return;
            }
            if (i3 == 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "onScrollStateChanged " + this.Q + " " + this.R);
                }
                if (this.Q == getCount() - 1 || this.Q >= this.R) {
                    z();
                }
            }
        }

        @Override // com.tencent.widget.SwipListView.SwipListListener
        public void updateCurShowRightView(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this, (Object) view);
                return;
            }
            int i3 = -1;
            if (view != null) {
                Object tag = view.getTag(-1);
                if (tag instanceof Integer) {
                    i3 = ((Integer) tag).intValue();
                }
            }
            this.U = i3;
        }

        public void w() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "adapter onPause");
            }
            this.G.removeObserver(this.T);
        }

        public void x() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "adapter onResume");
            }
            this.G.addObserver(this.T);
        }

        public void y() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            } else {
                ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.2
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SysMsgSuspiciousAdapter.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            ThreadManager.getUIHandler().post(new Runnable(SysMsgSuspiciousAdapter.this.H.getAllSysSuspiciousMsg()) { // from class: com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.2.1
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ List f181265d;

                                {
                                    this.f181265d = r5;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) r5);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    SysMsgSuspiciousAdapter.this.L = this.f181265d;
                                    if (SysMsgSuspiciousAdapter.this.L != null && !SysMsgSuspiciousAdapter.this.L.isEmpty()) {
                                        if (SysMsgSuspiciousAdapter.this.J != null) {
                                            SysMsgSuspiciousAdapter.this.J.setVisibility(8);
                                        }
                                    } else if (SysMsgSuspiciousAdapter.this.J != null) {
                                        SysMsgSuspiciousAdapter.this.J.setVisibility(0);
                                    }
                                    SysMsgSuspiciousAdapter.this.notifyDataSetChanged();
                                }
                            });
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements Function2<View, BaseAction, Unit> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewFriendMoreSysMsgSuspiciousFragment.this);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(View view, BaseAction baseAction) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Unit) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) baseAction);
            }
            if (b.f181274a[baseAction.ordinal()] == 1) {
                NewFriendMoreSysMsgSuspiciousFragment.this.getBaseActivity().finish();
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f181274a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67915);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[BaseAction.values().length];
            f181274a = iArr;
            try {
                iArr[BaseAction.ACTION_LEFT_BUTTON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public NewFriendMoreSysMsgSuspiciousFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void initView(View view) {
        getResources();
        View findViewById = view.findViewById(R.id.f_a);
        ((TextView) findViewById.findViewById(R.id.f166986jo4)).setText(R.string.iza);
        SwipListView swipListView = (SwipListView) view.findViewById(R.id.j9u);
        this.C = swipListView;
        swipListView.setDragEnable(true);
        SysMsgSuspiciousAdapter sysMsgSuspiciousAdapter = new SysMsgSuspiciousAdapter(getBaseActivity(), getBaseActivity().app, this.C, findViewById);
        this.E = sysMsgSuspiciousAdapter;
        this.C.setAdapter((ListAdapter) sysMsgSuspiciousAdapter);
        QUISecNavBar qUISecNavBar = (QUISecNavBar) view.findViewById(R.id.zpr);
        this.F = qUISecNavBar;
        qUISecNavBar.setCenterText(HardCodeUtil.qqStr(R.string.iz_));
        this.F.setRightType(0);
        this.F.setOnBaseTitleBarClickListener(new a());
        this.F.S(this);
        G = getActivity().getIntent().getBooleanExtra("isFromNewFriendPage", false);
        ReportController.o(getBaseActivity().app, "dc00898", "", "", "0X800A32B", "0X800A32B", 0, 0, "", "", "", "");
        if (G) {
            this.D = ((INewFriendApi) QRoute.api(INewFriendApi.class)).createUnverifyBlock(getContext());
            ((LinearLayout) view).addView(this.D, 1, new LinearLayout.LayoutParams(-2, -2));
            this.C.setOverScrollMode(2);
            ReportController.o(getBaseActivity().app, "dc00898", "", "", "0X800C081", "0X800C081", 0, 0, getBaseActivity().getCurrentAccountUin(), "", "", "");
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
        } else {
            super.onCreate(bundle);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            inflate = (View) iPatchRedirector.redirect((short) 2, this, layoutInflater, viewGroup, bundle);
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "onCreateView");
            }
            inflate = layoutInflater.inflate(R.layout.ayk, viewGroup, false);
            initView(inflate);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        SysMsgSuspiciousAdapter sysMsgSuspiciousAdapter = this.E;
        if (sysMsgSuspiciousAdapter != null) {
            sysMsgSuspiciousAdapter.destroy();
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onPause();
        SysMsgSuspiciousAdapter sysMsgSuspiciousAdapter = this.E;
        if (sysMsgSuspiciousAdapter != null) {
            sysMsgSuspiciousAdapter.w();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onResume();
        SysMsgSuspiciousAdapter sysMsgSuspiciousAdapter = this.E;
        if (sysMsgSuspiciousAdapter != null) {
            sysMsgSuspiciousAdapter.x();
            this.E.y();
        }
    }
}
