package com.tencent.mobileqq.selectmember.troop;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AutomatorObserver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchViewCreator;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.SelectedAndSearchBar;
import com.tencent.mobileqq.selectmember.troop.a;
import com.tencent.mobileqq.selectmember.troop.b;
import com.tencent.mobileqq.troop.aivoicechat.api.ITroopAIVoiceChatApi;
import com.tencent.mobileqq.troop.troopmanager.api.ITroopIntelligentManageApi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RoundFrameLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.kernel.nativeinterface.AIVoiceChatType;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SelectTroopListFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;
    protected com.tencent.mobileqq.selectmember.troop.a C;
    protected SwipPinnedHeaderExpandableListView D;
    protected SelectTroopListFooterView E;
    protected q F;
    protected r G;
    protected MyTroopObserver H;
    protected s I;
    private AppInterface J;
    private Context K;
    private View L;
    protected QUISecNavBar M;
    private FrameLayout N;
    private SelectedAndSearchBar P;
    private RelativeLayout Q;
    private View R;
    private RelativeLayout S;
    private Map<String, ResultRecord> T;
    private IFaceDecoder U;
    private InputMethodManager V;
    private QQCustomDialog W;
    private QQCustomDialog X;
    private QQCustomDialog Y;
    private QQCustomDialog Z;

    /* renamed from: a0, reason: collision with root package name */
    private int f285968a0;

    /* renamed from: b0, reason: collision with root package name */
    private String f285969b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f285970c0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f285971d0;

    /* renamed from: e0, reason: collision with root package name */
    private int f285972e0;

    /* renamed from: f0, reason: collision with root package name */
    private String f285973f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f285974g0;

    /* renamed from: h0, reason: collision with root package name */
    private AutomatorObserver f285975h0;

    /* renamed from: i0, reason: collision with root package name */
    private a.c f285976i0;

    /* renamed from: j0, reason: collision with root package name */
    private com.tencent.mobileqq.search.view.f f285977j0;

    /* renamed from: k0, reason: collision with root package name */
    private SelectedAndSearchBar.i f285978k0;

    /* renamed from: l0, reason: collision with root package name */
    private com.tencent.mobileqq.search.view.d f285979l0;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class MyTroopObserver extends com.tencent.mobileqq.troop.api.observer.e {
        static IPatchRedirector $redirector_;

        protected MyTroopObserver() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectTroopListFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onGenNewTroopName(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
                return;
            }
            com.tencent.mobileqq.selectmember.troop.a aVar = SelectTroopListFragment.this.C;
            if (aVar != null) {
                aVar.z();
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onGetMutilTroopInfoResult(boolean z16, ArrayList<TroopInfo> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), arrayList);
            } else if (z16) {
                SelectTroopListFragment.this.pi();
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onGetTroopInfoResult(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), str);
            } else if (z16) {
                SelectTroopListFragment.this.pi();
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onUpdateTroopList(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SelectTroopListFragment", 2, "onUpdateTroopList " + z16);
            }
            if (z16) {
                ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.selectmember.troop.SelectTroopListFragment.MyTroopObserver.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MyTroopObserver.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            SelectTroopListFragment.this.pi();
                        }
                    }
                }, 500L);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onUpdateTroopNickname(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
            } else if (z16) {
                SelectTroopListFragment.this.pi();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements com.tencent.mobileqq.search.view.d {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectTroopListFragment.this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.search.view.d
        public void onAction(View view) {
            int i3;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                return;
            }
            com.tencent.mobileqq.search.model.k kVar = (com.tencent.mobileqq.search.model.k) view.getTag(R.id.kxb);
            if (kVar == 0) {
                return;
            }
            String uin = kVar.getUin();
            String charSequence = kVar.getTitleSpans().toString();
            if (kVar instanceof com.tencent.mobileqq.search.model.m) {
                str = ((com.tencent.mobileqq.search.model.m) kVar).d();
                i3 = 3000;
            } else {
                i3 = 1;
                if (kVar instanceof com.tencent.mobileqq.search.model.o) {
                    str = kVar.getUin();
                } else if (kVar instanceof com.tencent.mobileqq.search.model.r) {
                    str = ((com.tencent.mobileqq.search.model.r) kVar).a().troopuin;
                } else if (!(kVar instanceof com.tencent.mobileqq.search.model.n)) {
                    str = "-1";
                    i3 = -1;
                } else {
                    i3 = 0;
                    str = "-1";
                }
            }
            if (i3 != -1 && SelectTroopListFragment.this.Oh(new ResultRecord(uin, charSequence, i3, str, ""))) {
                SelectTroopListFragment.this.C.notifyDataSetChanged();
            }
        }

        @Override // com.tencent.mobileqq.search.view.d
        public void selectedItemClick(String str, int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                SelectTroopListFragment.this.qi(str, i3);
            } else {
                iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Boolean.valueOf(z16));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectTroopListFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else if (!SelectTroopListFragment.this.requireActivity().isFinishing()) {
                SelectTroopListFragment.this.W.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectTroopListFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else if (!SelectTroopListFragment.this.requireActivity().isFinishing()) {
                SelectTroopListFragment.this.X.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectTroopListFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                SelectTroopListFragment.this.Sh();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class e implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectTroopListFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                SelectTroopListFragment.this.Y.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class f implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectTroopListFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                SelectTroopListFragment.this.Qh();
                com.tencent.mobileqq.troop.dtreport.a.c("clck", SelectTroopListFragment.this.Wh(true));
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class g implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectTroopListFragment.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                SelectTroopListFragment.this.Z.dismiss();
                com.tencent.mobileqq.troop.dtreport.a.c("clck", SelectTroopListFragment.this.Wh(false));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class h implements ITroopIntelligentManageApi.a {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectTroopListFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.troopmanager.api.ITroopIntelligentManageApi.a
        public void a(int i3, @NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i16 = 2;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                if (i3 != 0) {
                    i16 = 1;
                }
                QQToast.makeText(SelectTroopListFragment.this.K, i16, str, 0).show();
            }
            if (i3 == 0) {
                SelectTroopListFragment.this.Sh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class i implements Function2<View, BaseAction, Unit> {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectTroopListFragment.this);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(View view, BaseAction baseAction) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Unit) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) baseAction);
            }
            if (baseAction == BaseAction.ACTION_LEFT_BUTTON) {
                SelectTroopListFragment.this.ki();
                return null;
            }
            if (baseAction == BaseAction.ACTION_RIGHT_TEXT) {
                SelectTroopListFragment.this.li();
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class j implements b.i {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectTroopListFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.selectmember.troop.b.i
        public void a(byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) bArr);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_CHOOSE_RESULT, new String(bArr, StandardCharsets.UTF_8));
            SelectTroopListFragment.this.requireActivity().setResult(-1, intent);
            SelectTroopListFragment.this.requireActivity().finish();
        }

        @Override // com.tencent.mobileqq.selectmember.troop.b.i
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                SelectTroopListFragment.this.Q.setVisibility(8);
            }
        }

        @Override // com.tencent.mobileqq.selectmember.troop.b.i
        public void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                SelectTroopListFragment.this.Q.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class k implements ExpandableListView.OnGroupExpandListener {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectTroopListFragment.this);
            }
        }

        @Override // com.tencent.widget.ExpandableListView.OnGroupExpandListener
        public void onGroupExpand(int i3) {
            SelectTroopListFooterView selectTroopListFooterView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            } else if (i3 == SelectTroopListFragment.this.C.getGroupCount() - 1 && (selectTroopListFooterView = SelectTroopListFragment.this.E) != null) {
                selectTroopListFooterView.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class l implements ExpandableListView.OnGroupCollapseListener {
        static IPatchRedirector $redirector_;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectTroopListFragment.this);
            }
        }

        @Override // com.tencent.widget.ExpandableListView.OnGroupCollapseListener
        public void onGroupCollapse(int i3) {
            SelectTroopListFooterView selectTroopListFooterView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            } else if (i3 == SelectTroopListFragment.this.C.getGroupCount() - 1 && (selectTroopListFooterView = SelectTroopListFragment.this.E) != null) {
                selectTroopListFooterView.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class m implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectTroopListFragment.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                SelectTroopListFragment.this.wi();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class n extends AutomatorObserver {
        static IPatchRedirector $redirector_;

        n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectTroopListFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.app.AutomatorObserver
        protected void onCacheInited(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            if (i3 == 2) {
                if (QLog.isColorLevel()) {
                    QLog.d("SelectTroopListFragment", 2, "onCacheInited " + i3);
                }
                com.tencent.mobileqq.selectmember.troop.a aVar = SelectTroopListFragment.this.C;
                if (aVar != null) {
                    aVar.w();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class o implements a.c {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes18.dex */
        class a implements Function1<com.tencent.mobileqq.selectmember.troop.repo.f, Unit> {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) o.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unit invoke(com.tencent.mobileqq.selectmember.troop.repo.f fVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector.redirect((short) 2, (Object) this, (Object) fVar);
                }
                SelectTroopListFragment.this.Q.setVisibility(8);
                SelectTroopListFragment.this.C.L(fVar);
                return null;
            }
        }

        /* compiled from: P */
        /* loaded from: classes18.dex */
        class b implements Function3<com.tencent.mobileqq.selectmember.troop.repo.f, Integer, String, Unit> {
            static IPatchRedirector $redirector_;

            b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) o.this);
                }
            }

            @Override // kotlin.jvm.functions.Function3
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unit invoke(com.tencent.mobileqq.selectmember.troop.repo.f fVar, Integer num, String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Unit) iPatchRedirector.redirect((short) 2, this, fVar, num, str);
                }
                SelectTroopListFragment.this.Q.setVisibility(8);
                return null;
            }
        }

        o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectTroopListFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.selectmember.troop.a.c
        public boolean a(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return SelectTroopListFragment.this.fi(str, i3);
            }
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3)).booleanValue();
        }

        @Override // com.tencent.mobileqq.selectmember.troop.a.c
        public void b(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                SelectTroopListFragment.this.mi(view);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
            }
        }

        @Override // com.tencent.mobileqq.selectmember.troop.a.c
        public void c(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (i3 != 0 && i16 != 0) {
                SelectTroopListFragment.this.S.setVisibility(8);
                return;
            }
            if (SelectTroopListFragment.this.R == null) {
                SelectTroopListFragment.this.Rh();
            }
            SelectTroopListFragment.this.S.setVisibility(0);
        }

        @Override // com.tencent.mobileqq.selectmember.troop.a.c
        public void d(List<String> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) list);
            } else {
                if (SelectTroopListFragment.this.f285968a0 != 1) {
                    return;
                }
                SelectTroopListFragment.this.Q.setVisibility(0);
                com.tencent.mobileqq.selectmember.troop.repo.c.b(SelectTroopListFragment.this.f285969b0, list, new a(), new b());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class p implements SelectedAndSearchBar.i {
        static IPatchRedirector $redirector_;

        p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectTroopListFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.selectmember.SelectedAndSearchBar.i
        public void a(ResultRecord resultRecord) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) resultRecord);
                return;
            }
            if (resultRecord != null) {
                SelectTroopListFragment.this.qi(resultRecord.uin, resultRecord.getUinType());
            }
            SelectTroopListFragment.this.C.notifyDataSetChanged();
        }

        @Override // com.tencent.mobileqq.selectmember.SelectedAndSearchBar.i
        public void afterTextChanged(Editable editable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) editable);
                return;
            }
            String obj = editable.toString();
            if (TextUtils.isEmpty(obj)) {
                SelectTroopListFragment.this.N.setVisibility(8);
            } else {
                SelectTroopListFragment.this.N.setVisibility(0);
            }
            if (SelectTroopListFragment.this.f285977j0 != null) {
                SelectTroopListFragment.this.f285977j0.startSearch(obj);
            }
        }

        @Override // com.tencent.mobileqq.selectmember.SelectedAndSearchBar.i
        public void b(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
                return;
            }
            if (z16 && SelectTroopListFragment.this.f285977j0 == null) {
                if (SelectTroopListFragment.this.requireArguments().getBoolean(ISelectMemberActivityConstants.PARAM_KEY_SHOW_CREATE_TROOP)) {
                    SelectTroopListFragment.this.f285977j0 = ((ISearchViewCreator) QRoute.api(ISearchViewCreator.class)).createContactSearchFragment(8, 2097168, null, null, SelectTroopListFragment.this.f285979l0, 2, 2L, false, null);
                    SelectTroopListFragment.this.f285977j0.getFragment().requireArguments().putString(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_CHOOSE_TROOP_UIN, SelectTroopListFragment.this.requireArguments().getString(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_CHOOSE_TROOP_UIN));
                    SelectTroopListFragment.this.f285977j0.getFragment().requireArguments().putStringArrayList(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_CHOOSE_FILTER_TROOP_UIN_LIST, SelectTroopListFragment.this.C.E());
                    SelectTroopListFragment.this.f285977j0.getFragment().requireArguments().putBoolean(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_FILTER_BLOCK_GROUP, true);
                } else {
                    SelectTroopListFragment.this.f285977j0 = ((ISearchViewCreator) QRoute.api(ISearchViewCreator.class)).createContactSearchFragment(8, 2097176, null, null, SelectTroopListFragment.this.f285979l0, false, null);
                }
                FragmentTransaction beginTransaction = SelectTroopListFragment.this.requireActivity().getSupportFragmentManager().beginTransaction();
                beginTransaction.add(R.id.result_layout, SelectTroopListFragment.this.f285977j0.getFragment());
                beginTransaction.commitAllowingStateLoss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class q extends com.tencent.mobileqq.avatar.observer.a {
        static IPatchRedirector $redirector_;

        protected q() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectTroopListFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.avatar.observer.a
        protected void onUpdateTroopHead(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
            } else if (z16) {
                SelectTroopListFragment.this.pi();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class r extends com.tencent.mobileqq.troop.roamsetting.b {
        static IPatchRedirector $redirector_;

        protected r() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectTroopListFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.roamsetting.b
        protected void c(String str, GroupMsgMask groupMsgMask) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) groupMsgMask);
            } else {
                SelectTroopListFragment.this.pi();
            }
        }

        @Override // com.tencent.mobileqq.troop.roamsetting.b
        protected void d(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            } else {
                SelectTroopListFragment.this.pi();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class s extends com.tencent.mobileqq.troop.api.observer.b {
        static IPatchRedirector $redirector_;

        protected s() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SelectTroopListFragment.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.troop.api.observer.b
        public void l(int i3, int i16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
                return;
            }
            if (i3 == 6) {
                if (i16 == 0) {
                    SelectTroopListFragment.this.pi();
                }
            } else if (i3 == 2) {
                if (i16 == 0) {
                    SelectTroopListFragment.this.pi();
                }
            } else if (i3 == 9 && i16 == 0) {
                SelectTroopListFragment.this.pi();
            }
        }
    }

    public SelectTroopListFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.T = new LinkedHashMap();
        this.f285971d0 = false;
        this.f285973f0 = "";
        this.f285974g0 = 9;
        this.f285975h0 = new n();
        this.f285976i0 = new o();
        this.f285978k0 = new p();
        this.f285979l0 = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Oh(ResultRecord resultRecord) {
        ArrayList arrayList;
        if (resultRecord == null) {
            return false;
        }
        String Vh = Vh(resultRecord.uin, resultRecord.getUinType());
        ResultRecord resultRecord2 = this.T.get(Vh);
        if (resultRecord2 != null) {
            resultRecord2.lastChooseTime = SystemClock.elapsedRealtime();
            this.P.H(new ArrayList(this.T.values()), false);
            return false;
        }
        if (ji()) {
            QLog.i("SelectTroopListFragment", 1, "[add2ForwardTargetList] clear when single choose on bind robot.");
            this.T.clear();
        }
        if (ii()) {
            this.T.clear();
        }
        if (this.T.size() == this.f285974g0) {
            vi();
            return false;
        }
        ResultRecord copyResultRecord = ResultRecord.copyResultRecord(resultRecord);
        copyResultRecord.lastChooseTime = SystemClock.elapsedRealtime();
        this.T.put(Vh, copyResultRecord);
        oi();
        this.P.H(new ArrayList(this.T.values()), true);
        ArrayList arrayList2 = new ArrayList();
        Iterator<ResultRecord> it = this.T.values().iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().uin);
        }
        com.tencent.mobileqq.search.view.f fVar = this.f285977j0;
        if (fVar != null) {
            if (fVar.K9()) {
                arrayList = null;
            } else {
                arrayList = arrayList2;
            }
            fVar.B5(arrayList2, arrayList);
        }
        return true;
    }

    private void Ph() {
        if (this.F == null) {
            this.F = new q();
        }
        if (this.G == null) {
            this.G = new r();
        }
        if (this.I == null) {
            this.I = new s();
        }
        if (this.H == null) {
            this.H = new MyTroopObserver();
        }
        this.J.addObserver(this.F);
        this.J.addObserver(this.G);
        this.J.addObserver(this.H);
        this.J.addObserver(this.I);
        this.J.addObserver(this.f285975h0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qh() {
        if (!NetworkUtil.isNetSupport(this.K)) {
            QQToast.makeText(this.K, 1, "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 0).show();
            return;
        }
        if (getArguments() == null) {
            requireActivity().finish();
            return;
        }
        ArrayList<Integer> integerArrayList = getArguments().getIntegerArrayList(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_INSTRUCTION_LIST);
        ArrayList arrayList = new ArrayList();
        Iterator<ResultRecord> it = this.T.values().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().uin);
        }
        ((ITroopIntelligentManageApi) QRoute.api(ITroopIntelligentManageApi.class)).applyInstructionCopy(this.f285969b0, integerArrayList, arrayList, new h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rh() {
        this.R = new QUIEmptyState.Builder(getContext()).setImageType(16).setTitle("\u6ca1\u6709\u53ef\u9009\u62e9\u7684\u7fa4\u804a").setBackgroundColorType(2).build();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.S.addView(this.R, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sh() {
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(this.T.values());
        Collections.sort(arrayList, new ResultRecord.DefaultComparator());
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra("selected_target_list", arrayList);
        requireActivity().setResult(-1, intent);
        requireActivity().finish();
    }

    private String Th(CharSequence charSequence) {
        if (charSequence == null) {
            return "";
        }
        return charSequence.toString();
    }

    private String Uh() {
        if (!TextUtils.isEmpty(this.f285973f0)) {
            return this.f285973f0;
        }
        return getString(R.string.f173097hd1);
    }

    private String Vh(String str, int i3) {
        return i3 + "_" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> Wh(boolean z16) {
        int i3;
        if (getArguments() == null) {
            return new HashMap();
        }
        ArrayList<Integer> integerArrayList = getArguments().getIntegerArrayList(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_INSTRUCTION_LIST);
        ArrayList arrayList = new ArrayList();
        Iterator<ResultRecord> it = this.T.values().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().uin);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("group_id", this.f285969b0);
        hashMap.put("order_copy", com.tencent.mobileqq.troop.dtreport.a.a(integerArrayList));
        hashMap.put("copy_group_id", com.tencent.mobileqq.troop.dtreport.a.a(arrayList));
        if (z16) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        hashMap.put("click_pos", Integer.valueOf(i3));
        return hashMap;
    }

    private String Xh(int i3) {
        return "(" + i3 + ")";
    }

    private void Yh() {
        if (this.f285968a0 != 1) {
            return;
        }
        this.D.setOnGroupExpandListener(new k());
        this.D.setOnGroupCollapseListener(new l());
        SelectTroopListFooterView selectTroopListFooterView = new SelectTroopListFooterView(getActivity());
        this.E = selectTroopListFooterView;
        selectTroopListFooterView.setOnClickListener(new m());
        this.D.addFooterView(this.E);
    }

    private void ai() {
        this.V = (InputMethodManager) this.K.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        this.P = (SelectedAndSearchBar) this.L.findViewById(R.id.imi);
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) this.J.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.J);
        this.U = iQQAvatarService;
        this.P.s(null, iQQAvatarService, this.f285978k0);
    }

    private void bi(List<ResultRecord> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<ResultRecord> it = list.iterator();
            while (it.hasNext()) {
                Oh(it.next());
            }
        }
    }

    private boolean ci() {
        if (this.f285968a0 == 3) {
            return true;
        }
        return false;
    }

    private boolean di() {
        if (this.f285968a0 == 2) {
            return true;
        }
        return false;
    }

    private boolean ei() {
        if (gi() && this.T.size() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fi(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.T.containsKey(Vh(str, i3));
    }

    private AppInterface getAppInterface() {
        return (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
    }

    private boolean gi() {
        if (!di()) {
            return false;
        }
        Bundle arguments = getArguments();
        if (arguments == null) {
            QLog.i("SelectTroopListFragment", 1, "[isCancelBindRobotTroop] arguments is null.");
            return false;
        }
        ArrayList parcelableArrayList = arguments.getParcelableArrayList("selected_target_list");
        if (parcelableArrayList == null || parcelableArrayList.isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean hi() {
        if (this.f285968a0 == 4) {
            return true;
        }
        return false;
    }

    private boolean ii() {
        if (hi() && this.f285974g0 == 1) {
            return true;
        }
        return false;
    }

    private void initData() {
        bi(getArguments().getParcelableArrayList("selected_target_list"));
    }

    private void initDtReport() {
        if (ci()) {
            com.tencent.mobileqq.troop.dtreport.a.e("pgin");
        }
    }

    private void initTitleBar() {
        this.M = (QUISecNavBar) this.L.findViewById(R.id.jo9);
        String string = getArguments().getString("extra_forward_title");
        if (!TextUtils.isEmpty(string)) {
            this.M.setCenterText(string);
        } else {
            this.M.setCenterText(getString(R.string.hds));
        }
        this.M.setOnBaseTitleBarClickListener(new i());
        oi();
        if (AppSetting.f99565y) {
            QUISecNavBar qUISecNavBar = this.M;
            qUISecNavBar.setBaseViewDescription(BaseAction.ACTION_CENTER_TEXT, Th(qUISecNavBar.getCenterText()));
            QUISecNavBar qUISecNavBar2 = this.M;
            qUISecNavBar2.setBaseViewDescription(BaseAction.ACTION_RIGHT_TEXT, Th(qUISecNavBar2.getRightText()));
            this.M.setBaseViewDescription(BaseAction.ACTION_LEFT_BUTTON, getString(R.string.hdd));
        }
    }

    private void initView() {
        if (this.f285971d0) {
            ((RoundFrameLayout) this.L.findViewById(R.id.root)).setRadius(ViewUtils.dip2px(10.0f));
        }
        SwipPinnedHeaderExpandableListView swipPinnedHeaderExpandableListView = (SwipPinnedHeaderExpandableListView) this.L.findViewById(R.id.f166069ec1);
        this.D = swipPinnedHeaderExpandableListView;
        swipPinnedHeaderExpandableListView.setSelector(R.color.ajr);
        this.D.setNeedCheckSpringback(true);
        this.D.setGroupIndicator(null);
        this.D.setDivider(null);
        this.D.setPadding(0, 0, 0, com.tencent.mobileqq.selectmember.util.a.a(54.0f, getResources()));
        this.D.setClipToPadding(false);
        this.D.setScrollBarStyle(33554432);
        this.N = (FrameLayout) this.L.findViewById(R.id.result_layout);
        this.Q = (RelativeLayout) this.L.findViewById(R.id.efs);
        this.S = (RelativeLayout) this.L.findViewById(R.id.bwb);
        ai();
        initTitleBar();
        Yh();
    }

    private boolean ji() {
        if (di() && this.f285974g0 == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ki() {
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra("selected_target_list", new ArrayList<>(this.T.values()));
        requireActivity().setResult(0, intent);
        requireActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void li() {
        if (this.f285968a0 == 1) {
            ArrayList arrayList = new ArrayList(this.T.values());
            Collections.sort(arrayList, new ResultRecord.DefaultComparator());
            com.tencent.mobileqq.selectmember.troop.b.g(requireContext(), this.f285969b0, this.f285970c0, arrayList, new j());
            return;
        }
        if (ei()) {
            QLog.i("SelectTroopListFragment", 1, "[onClickTitleRight] cancel bind robot");
            xi();
            return;
        }
        if (ci()) {
            ui();
            return;
        }
        if (hi()) {
            if (this.T.size() != 1) {
                QLog.e("SelectTroopListFragment", 1, "isSelectTroopToUseAIVoice error mForwardTargetMap.size: " + this.T.size());
                return;
            }
            Iterator<ResultRecord> it = this.T.values().iterator();
            String str = "0";
            while (it.hasNext()) {
                str = it.next().uin;
            }
            if (((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(str) == null) {
                QLog.e("SelectTroopListFragment", 1, "isSelectTroopToUseAIVoice error troopInfo is null, troopUin: " + str);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt(ITroopAIVoiceChatApi.PARAM_KEY_OPEN_AI_CHAT_TYPE, AIVoiceChatType.KAIVOICECHATTYPESOUND.ordinal());
            bundle.putBoolean(ITroopAIVoiceChatApi.PARAMS_KEY_SHOW_AI_VOICE_GUIDE_BUBBLE, true);
            ((IAIOStarterApi) QRoute.api(IAIOStarterApi.class)).navigateToAIOActivity(this.K, 2, str, ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(str).getTroopDisplayName(), Long.parseLong(str), bundle);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        Sh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mi(View view) {
        ResultRecord resultRecord = ((SelectTroopListItemView) view).K;
        if (resultRecord != null && fi(resultRecord.uin, resultRecord.getUinType())) {
            qi(resultRecord.uin, resultRecord.getUinType());
        } else {
            Oh(resultRecord);
        }
        this.C.notifyDataSetChanged();
    }

    private void ni() {
        this.V.hideSoftInputFromWindow(requireActivity().getWindow().peekDecorView().getWindowToken(), 0);
        this.P.u();
        this.P.v();
        this.N.setVisibility(8);
    }

    private void oi() {
        if (this.T.isEmpty()) {
            this.M.setRightText(Uh());
            this.M.setBaseViewEnabled(BaseAction.ACTION_RIGHT_TEXT, gi());
        } else {
            this.M.setRightText(Uh() + Xh(this.T.size()));
            this.M.setBaseViewEnabled(BaseAction.ACTION_RIGHT_TEXT, true);
        }
        if (AppSetting.f99565y) {
            QUISecNavBar qUISecNavBar = this.M;
            qUISecNavBar.setBaseViewDescription(BaseAction.ACTION_RIGHT_TEXT, Th(qUISecNavBar.getRightText()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qi(String str, int i3) {
        ArrayList arrayList;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.T.remove(Vh(str, i3));
        oi();
        this.P.H(new ArrayList(this.T.values()), true);
        ArrayList arrayList2 = new ArrayList();
        Iterator<ResultRecord> it = this.T.values().iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().uin);
        }
        com.tencent.mobileqq.search.view.f fVar = this.f285977j0;
        if (fVar != null) {
            if (fVar.K9()) {
                arrayList = null;
            } else {
                arrayList = arrayList2;
            }
            fVar.B5(arrayList2, arrayList);
        }
    }

    private void ri() {
        this.J.removeObserver(this.F);
        this.J.removeObserver(this.G);
        this.J.removeObserver(this.H);
        this.J.removeObserver(this.I);
        this.J.removeObserver(this.f285975h0);
    }

    private void si() {
        if (this.D != null) {
            com.tencent.mobileqq.selectmember.troop.a aVar = this.C;
            if (aVar != null) {
                aVar.destroy();
            }
            com.tencent.mobileqq.selectmember.troop.a aVar2 = new com.tencent.mobileqq.selectmember.troop.a(requireActivity(), this.J, this.D, requireArguments(), this.f285976i0);
            this.C = aVar2;
            this.D.setAdapter(aVar2);
            this.D.setOnGroupClickListener(this.C);
        }
    }

    private void ui() {
        if (this.Z == null) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(requireActivity(), 230);
            this.Z = createCustomDialog;
            createCustomDialog.setMessage("\u5982\u9009\u4e2d\u7fa4\u804a\u5df2\u8bbe\u7f6e\u6307\u4ee4\uff0c\u5c06\u8986\u76d6\u539f\u6709\u8bbe\u7f6e\u3002\u5982\u65e0Q\u7fa4\u7ba1\u5bb6\uff0c\u5c06\u81ea\u52a8\u6dfb\u52a0Q\u7fa4\u7ba1\u5bb6\u8fdb\u7fa4\uff0c\u5e76\u8bbe\u4e3a\u7ba1\u7406\u5458\u3002");
            this.Z.setPositiveButton(R.string.a8j, new f());
            this.Z.setNegativeButton(R.string.cancel, new g());
        }
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing() && !this.Z.isShowing()) {
            this.Z.show();
        }
        com.tencent.mobileqq.troop.dtreport.a.c("imp", Wh(false));
    }

    private void vi() {
        if (this.W == null) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(requireActivity(), 230);
            this.W = createCustomDialog;
            createCustomDialog.setMessage(String.format(requireActivity().getResources().getString(R.string.f199254ox), Integer.valueOf(this.f285974g0)));
            this.W.setPositiveButton(R.string.cpy, new b());
        }
        if (!requireActivity().isFinishing()) {
            this.W.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wi() {
        if (this.X == null) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(requireActivity(), 230);
            this.X = createCustomDialog;
            createCustomDialog.setTitle(requireActivity().getResources().getString(R.string.f224946ka));
            this.X.setMessage(requireActivity().getResources().getString(R.string.f224966kc));
            this.X.setPositiveButton(R.string.cpy, new c());
        }
        if (!requireActivity().isFinishing()) {
            this.X.show();
        }
    }

    private void xi() {
        if (this.Y == null) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(requireActivity(), 230);
            this.Y = createCustomDialog;
            createCustomDialog.setMessage("\u667a\u80fd\u4f53\u8d44\u6599\u5361\u4e2d\u5c06\u4e0d\u518d\u663e\u793a\u7fa4\u804a");
            this.Y.setPositiveButton(R.string.a8j, new d());
            this.Y.setNegativeButton(R.string.cancel, new e());
        }
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing() && !this.Y.isShowing()) {
            this.Y.show();
        }
    }

    public void Zh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (!this.f285971d0) {
            return;
        }
        try {
            ti();
            Window window = requireActivity().getWindow();
            window.setFormat(-3);
            WindowManager.LayoutParams attributes = window.getAttributes();
            int height = requireActivity().getWindowManager().getDefaultDisplay().getHeight() - ViewUtils.dpToPx(88.0f);
            attributes.height = height;
            this.f285972e0 = height;
            attributes.gravity = 81;
            window.setAttributes(attributes);
            View decorView = window.getDecorView();
            decorView.setScaleX(1.0f);
            decorView.setScaleY(1.0f);
        } catch (Exception e16) {
            QLog.e("SelectTroopListFragment", 1, "initMiniWindow ", e16);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!this.f285971d0) {
            return super.dispatchTouchEvent(motionEvent);
        }
        Display defaultDisplay = requireActivity().getWindowManager().getDefaultDisplay();
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        motionEvent.offsetLocation(((x16 - ((defaultDisplay.getWidth() * 0.0f) / 2.0f)) / 1.0f) - x16, ((y16 - ((defaultDisplay.getHeight() * 0.0f) / 2.0f)) / 1.0f) - y16);
        if (!super.dispatchTouchEvent(motionEvent)) {
            if (y16 > this.f285972e0 || y16 < 0.0f) {
                requireActivity().finish();
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
        } else {
            activity.overridePendingTransition(R.anim.f154424l, R.anim.f154423k);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment
    public boolean needDispatchTouchEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        if (this.N.getVisibility() != 8) {
            ni();
            return true;
        }
        if (this.P.E()) {
            ni();
        }
        FragmentActivity requireActivity = requireActivity();
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra("selected_target_list", new ArrayList<>(this.T.values()));
        requireActivity.setResult(0, intent);
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            view = (View) iPatchRedirector.redirect((short) 2, this, layoutInflater, viewGroup, bundle);
        } else {
            if (getArguments() == null) {
                requireActivity().finish();
            }
            this.f285971d0 = getArguments().getBoolean("extra_mini_mode", false);
            this.f285973f0 = getArguments().getString("extra_select_finish_text");
            this.f285968a0 = getArguments().getInt(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_CHOOSE_TROOP_TYPE, 0);
            this.f285969b0 = getArguments().getString(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_CHOOSE_TROOP_UIN);
            this.f285970c0 = getArguments().getString(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_CHOOSE_TROOP_NAME);
            this.f285974g0 = getArguments().getInt(ISelectMemberActivityConstants.PARAM_KEY_EXTRA_CHOOSE_TROOP_MAX_NUM, 9);
            this.J = getAppInterface();
            this.K = requireActivity();
            this.L = layoutInflater.inflate(R.layout.f169085hq0, (ViewGroup) null);
            if (ImmersiveUtils.isSupporImmersive() == 1) {
                this.L.setFitsSystemWindows(true);
                this.L.setPadding(0, ImmersiveUtils.getStatusBarHeight(layoutInflater.getContext()), 0, 0);
            }
            Zh();
            initView();
            initData();
            initDtReport();
            view = this.L;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.onDestroy();
        if (QLog.isColorLevel()) {
            QLog.d("SelectTroopListFragment", 2, "doOnDestroy");
        }
        com.tencent.mobileqq.selectmember.troop.a aVar = this.C;
        if (aVar != null) {
            aVar.destroy();
        }
        this.U.destory();
        ri();
        if (ci()) {
            com.tencent.mobileqq.troop.dtreport.a.e("pgout");
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (this.f285971d0) {
            requireActivity().overridePendingTransition(0, R.anim.f154423k);
        }
        super.onFinish();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            super.onPause();
            ri();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onResume();
        Ph();
        if (this.C == null) {
            si();
        }
        this.D.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.selectmember.troop.SelectTroopListFragment.6
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SelectTroopListFragment.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    SelectTroopListFragment.this.C.notifyDataSetChanged();
                }
            }
        }, 200L);
    }

    void pi() {
        com.tencent.mobileqq.selectmember.troop.a aVar = this.C;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public void ti() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        SystemBarCompact systemBarComp = SystemBarActivityModule.getSystemBarComp((QBaseActivity) requireActivity());
        if (systemBarComp != null) {
            systemBarComp.init();
            systemBarComp.setStatusBarVisible(2, 0);
        }
    }
}
