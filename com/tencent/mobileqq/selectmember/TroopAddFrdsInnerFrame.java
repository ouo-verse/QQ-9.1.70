package com.tencent.mobileqq.selectmember;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi;
import com.tencent.mobileqq.adapter.k;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.dpc.DeviceProfileManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.api.ISearchViewCreator;
import com.tencent.mobileqq.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.troopmemberlist.ITroopMemberExtDBApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x777.cmd0x777$AddFrdInfo;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TroopAddFrdsInnerFrame extends SelectMemberInnerFrame implements View.OnClickListener, IndexView.b, PinnedDividerListView.b, SelectMemberActivity.p, AbsListView.OnScrollListener, Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: p0, reason: collision with root package name */
    protected static double f285806p0;

    /* renamed from: q0, reason: collision with root package name */
    public static int f285807q0;

    /* renamed from: r0, reason: collision with root package name */
    public static int f285808r0;

    /* renamed from: s0, reason: collision with root package name */
    private static final int f285809s0;

    /* renamed from: t0, reason: collision with root package name */
    private static int f285810t0;
    int D;
    String E;
    String F;
    Long G;
    private String H;
    private String I;
    private TroopInfo J;
    private int K;
    private String L;
    private String M;
    PinnedDividerListView N;
    private IndexView P;
    e Q;
    Map<String, List<TroopMemberInfo>> R;
    int[] S;
    String[] T;
    int U;
    int V;
    boolean W;

    /* renamed from: a0, reason: collision with root package name */
    protected RelativeLayout f285811a0;

    /* renamed from: b0, reason: collision with root package name */
    protected ProgressBar f285812b0;

    /* renamed from: c0, reason: collision with root package name */
    protected TextView f285813c0;

    /* renamed from: d0, reason: collision with root package name */
    protected double f285814d0;

    /* renamed from: e0, reason: collision with root package name */
    private int f285815e0;

    /* renamed from: f0, reason: collision with root package name */
    private View f285816f0;

    /* renamed from: g0, reason: collision with root package name */
    private EditText f285817g0;

    /* renamed from: h0, reason: collision with root package name */
    boolean f285818h0;

    /* renamed from: i0, reason: collision with root package name */
    int f285819i0;

    /* renamed from: j0, reason: collision with root package name */
    Set<String> f285820j0;

    /* renamed from: k0, reason: collision with root package name */
    Handler f285821k0;

    /* renamed from: l0, reason: collision with root package name */
    Handler f285822l0;

    /* renamed from: m0, reason: collision with root package name */
    com.tencent.mobileqq.friend.observer.a f285823m0;

    /* renamed from: n0, reason: collision with root package name */
    com.tencent.mobileqq.friend.observer.b f285824n0;

    /* renamed from: o0, reason: collision with root package name */
    com.tencent.mobileqq.troop.api.observer.e f285825o0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a extends com.tencent.mobileqq.friend.observer.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAddFrdsInnerFrame.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.friend.observer.a
        public void onUpdateAddFriend(boolean z16, boolean z17, boolean z18, String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), str, bundle);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("TroopAddFrdsInnerFrame", 2, String.format("onUpdateAddFriend isSuc:%d addSuc:%d addDirec:%d uin:%s", Integer.valueOf(z16 ? 1 : 0), Integer.valueOf(z17 ? 1 : 0), Integer.valueOf(z18 ? 1 : 0), str));
            }
            if (z16) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(str);
                Message obtainMessage = TroopAddFrdsInnerFrame.this.f285821k0.obtainMessage(9);
                obtainMessage.obj = arrayList;
                obtainMessage.sendToTarget();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b extends com.tencent.mobileqq.troop.api.observer.e {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAddFrdsInnerFrame.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onTroopBatchReqMemberCmnFrds(boolean z16, String str, String str2, long j3, int i3, boolean z17, boolean z18, HashMap<String, Integer> hashMap, List<String> list) {
            Long l3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, str2, Long.valueOf(j3), Integer.valueOf(i3), Boolean.valueOf(z17), Boolean.valueOf(z18), hashMap, list);
                return;
            }
            if (z16 && (l3 = TroopAddFrdsInnerFrame.this.G) != null && l3.longValue() == j3 && str.equals(TroopAddFrdsInnerFrame.this.F)) {
                if (QLog.isColorLevel()) {
                    QLog.i("TroopAddFrdsInnerFrame", 2, String.format("onTroopBatchReqMemberCmnFrds suc. troopUin:%s, cmnfrds.size:%d", str, Integer.valueOf(hashMap.size())));
                }
                if (hashMap.size() > 0) {
                    Message obtainMessage = TroopAddFrdsInnerFrame.this.f285822l0.obtainMessage(6);
                    obtainMessage.obj = hashMap;
                    TroopAddFrdsInnerFrame.this.f285822l0.sendMessage(obtainMessage);
                    ((ITroopMemberExtDBApi) QRoute.api(ITroopMemberExtDBApi.class)).updateCommonFriendCount(str, hashMap, "TroopAddFrdsInnerFrame");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements com.tencent.qqnt.troopmemberlist.f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f285842a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f285843b;

        c(boolean z16, String str) {
            this.f285842a = z16;
            this.f285843b = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopAddFrdsInnerFrame.this, Boolean.valueOf(z16), str);
            }
        }

        @Override // com.tencent.qqnt.troopmemberlist.f
        public void a(boolean z16, @NonNull List<? extends TroopMemberInfo> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), list);
            } else if (this.f285842a) {
                TroopAddFrdsInnerFrame.this.K(new ArrayList(list));
            } else {
                TroopAddFrdsInnerFrame.this.L(this.f285843b, new ArrayList(list));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class d extends k {
        static IPatchRedirector $redirector_;
        public TextView C;
        public View D;
        public Button E;
        public TextView F;
        public TroopMemberInfo G;
        public CheckBox H;
        public View I;
        public TextView J;
        public int K;

        /* renamed from: i, reason: collision with root package name */
        public TextView f285845i;

        /* renamed from: m, reason: collision with root package name */
        public TextView f285846m;

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class e extends com.tencent.mobileqq.adapter.e implements View.OnClickListener {
        static IPatchRedirector $redirector_;
        public List<ResultRecord> D;
        boolean E;

        public e() {
            super(TroopAddFrdsInnerFrame.this.f285782h, TroopAddFrdsInnerFrame.this.f285784m, TroopAddFrdsInnerFrame.this.N, true);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAddFrdsInnerFrame.this);
                return;
            }
            this.D = new ArrayList();
            this.E = false;
            TroopAddFrdsInnerFrame.this.U = TroopAddFrdsInnerFrame.this.f285782h.getResources().getDimensionPixelOffset(R.dimen.adm);
            TroopAddFrdsInnerFrame.this.V = TroopAddFrdsInnerFrame.this.f285782h.getResources().getDimensionPixelOffset(R.dimen.adn);
        }

        private boolean h(TroopMemberInfo troopMemberInfo) {
            for (int i3 = 0; i3 < this.D.size(); i3++) {
                if (TextUtils.equals(troopMemberInfo.memberuin, this.D.get(i3).uin)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public void configDividerView(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) view, i3);
            } else {
                Arrays.binarySearch(TroopAddFrdsInnerFrame.this.S, i3);
            }
        }

        public void g(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            } else {
                this.E = z16;
                notifyDataSetChanged();
            }
        }

        @Override // com.tencent.mobileqq.adapter.e, android.widget.Adapter
        public int getCount() {
            Map<String, List<TroopMemberInfo>> map;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            TroopAddFrdsInnerFrame troopAddFrdsInnerFrame = TroopAddFrdsInnerFrame.this;
            int[] iArr = troopAddFrdsInnerFrame.S;
            if (iArr == null || (map = troopAddFrdsInnerFrame.R) == null || iArr.length == 0) {
                return 0;
            }
            return iArr[iArr.length - 1] + map.get(troopAddFrdsInnerFrame.T[r0.length - 1]).size() + 1;
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public int getDividerLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            if (TroopAddFrdsInnerFrame.this.T.length > 0) {
                return R.layout.f168254qf;
            }
            return 0;
        }

        @Override // com.tencent.mobileqq.adapter.e, android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            int binarySearch = Arrays.binarySearch(TroopAddFrdsInnerFrame.this.S, i3);
            if (binarySearch >= 0) {
                return null;
            }
            int i16 = (-(binarySearch + 1)) - 1;
            TroopAddFrdsInnerFrame troopAddFrdsInnerFrame = TroopAddFrdsInnerFrame.this;
            return troopAddFrdsInnerFrame.R.get(troopAddFrdsInnerFrame.T[i16]).get((i3 - TroopAddFrdsInnerFrame.this.S[i16]) - 1);
        }

        @Override // com.tencent.mobileqq.adapter.e, android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Long) iPatchRedirector.redirect((short) 5, (Object) this, i3)).longValue();
            }
            return 0L;
        }

        /* JADX WARN: Removed duplicated region for block: B:51:0x02e2  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x02ec  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x02fe  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x02ee  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x02e4  */
        @Override // com.tencent.mobileqq.adapter.e, android.widget.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            View view3;
            StringBuilder sb5;
            d dVar;
            e eVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = true;
            int i16 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                view3 = view;
                view2 = (View) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), view, viewGroup);
            } else {
                int binarySearch = Arrays.binarySearch(TroopAddFrdsInnerFrame.this.S, i3);
                if (view == null) {
                    view2 = TroopAddFrdsInnerFrame.this.C.inflate(R.layout.at7, viewGroup, false);
                    d dVar2 = new d();
                    View findViewById = view2.findViewById(R.id.result_layout);
                    dVar2.D = findViewById;
                    findViewById.setId(R.id.jxj);
                    View findViewById2 = view2.findViewById(R.id.j9t);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById2.getLayoutParams();
                    layoutParams.addRule(0, R.id.jxj);
                    layoutParams.rightMargin = com.tencent.mobileqq.selectmember.util.a.a(10.0f, TroopAddFrdsInnerFrame.this.getResources());
                    findViewById2.setLayoutParams(layoutParams);
                    dVar2.f187212f = (ImageView) view2.findViewById(R.id.f163821d);
                    dVar2.f285846m = (TextView) view2.findViewById(R.id.i95);
                    dVar2.f285845i = (TextView) view2.findViewById(R.id.nickname);
                    dVar2.C = (TextView) view2.findViewById(R.id.iz7);
                    dVar2.E = (Button) view2.findViewById(R.id.i8s);
                    dVar2.F = (TextView) view2.findViewById(R.id.f166787i92);
                    dVar2.H = (CheckBox) view2.findViewById(R.id.ax9);
                    dVar2.J = (TextView) view2.findViewById(R.id.k8u);
                    dVar2.I = view2.findViewById(R.id.gqb);
                    dVar2.J.setFocusableInTouchMode(false);
                    dVar2.I.setFocusableInTouchMode(false);
                    dVar2.J.setFocusable(false);
                    dVar2.I.setFocusable(false);
                    dVar2.D.setDuplicateParentStateEnabled(false);
                    dVar2.E.setDuplicateParentStateEnabled(true);
                    dVar2.F.setDuplicateParentStateEnabled(false);
                    dVar2.E.setClickable(false);
                    dVar2.f285846m.setPadding(0, com.tencent.mobileqq.selectmember.util.a.a(2.0f, TroopAddFrdsInnerFrame.this.getResources()), 0, 0);
                    if (TroopAddFrdsInnerFrame.this.P != null && TroopAddFrdsInnerFrame.this.P.getVisibility() == 0) {
                        view2.findViewById(R.id.jxj).setPadding(0, 0, TroopAddFrdsInnerFrame.this.U, 0);
                    } else {
                        view2.findViewById(R.id.jxj).setPadding(0, 0, TroopAddFrdsInnerFrame.this.V, 0);
                    }
                    view2.setTag(dVar2);
                } else {
                    view2 = view;
                }
                d dVar3 = (d) view2.getTag();
                if (binarySearch < 0) {
                    int i17 = (-(binarySearch + 1)) - 1;
                    TroopAddFrdsInnerFrame troopAddFrdsInnerFrame = TroopAddFrdsInnerFrame.this;
                    TroopMemberInfo troopMemberInfo = troopAddFrdsInnerFrame.R.get(troopAddFrdsInnerFrame.T[i17]).get((i3 - TroopAddFrdsInnerFrame.this.S[i17]) - 1);
                    dVar3.G = troopMemberInfo;
                    if (TroopAddFrdsInnerFrame.this.f285782h.isResultListContainFriend(troopMemberInfo.memberuin)) {
                        dVar3.H.setChecked(true);
                    } else {
                        dVar3.H.setChecked(false);
                    }
                    if (AppSetting.f99565y) {
                        sb5 = new StringBuilder(256);
                        sb5.append("\u7fa4\u6210\u5458");
                    } else {
                        sb5 = null;
                    }
                    dVar3.I.setVisibility(0);
                    dVar3.J.setVisibility(8);
                    dVar3.f187212f.setImageBitmap(b(troopMemberInfo.memberuin));
                    String showName = troopMemberInfo.nickInfo.getShowName();
                    dVar3.f285845i.setText(showName);
                    dVar3.f187210d = troopMemberInfo.memberuin;
                    dVar3.C.setVisibility(8);
                    if (AppSetting.f99565y && sb5 != null) {
                        sb5.append(showName);
                    }
                    if (troopMemberInfo.getCommonFrdCnt() > 0) {
                        dVar3.f285846m.setText(TroopAddFrdsInnerFrame.this.getResources().getString(R.string.f170114gs, Integer.valueOf(troopMemberInfo.getCommonFrdCnt())));
                        dVar3.f285846m.setVisibility(0);
                        if (AppSetting.f99565y && sb5 != null) {
                            sb5.append(dVar3.f285846m.getText());
                        }
                    } else {
                        dVar3.f285846m.setVisibility(8);
                    }
                    if (!this.E) {
                        dVar3.I.setEnabled(true);
                    }
                    int i18 = troopMemberInfo.addState;
                    if (i18 == 1) {
                        i18 = TroopAddFrdsInnerFrame.this.F(troopMemberInfo.memberuin);
                    }
                    if (i18 == 4) {
                        dVar3.E.setVisibility(8);
                        dVar3.F.setVisibility(0);
                        dVar3.F.setText(HardCodeUtil.qqStr(R.string.u_z));
                        if (this.E) {
                            dVar3.I.setEnabled(false);
                            dVar3.H.setEnabled(false);
                            dVar3.H.setChecked(false);
                        }
                        if (AppSetting.f99565y) {
                            dVar3.F.setContentDescription(HardCodeUtil.qqStr(R.string.f172801ua1));
                        }
                    } else if (i18 == 3) {
                        dVar3.E.setVisibility(8);
                        dVar3.F.setVisibility(0);
                        dVar3.F.setText(HardCodeUtil.qqStr(R.string.u_x));
                        if (this.E) {
                            dVar3.I.setEnabled(false);
                            dVar3.H.setEnabled(false);
                            dVar3.H.setChecked(false);
                        }
                        if (AppSetting.f99565y) {
                            dVar3.F.setContentDescription(HardCodeUtil.qqStr(R.string.u_w));
                        }
                    } else {
                        if (this.E) {
                            dVar3.I.setEnabled(true);
                            dVar3.E.setVisibility(8);
                            dVar3.H.setEnabled(true);
                            dVar3.H.setChecked(h(troopMemberInfo));
                            dVar3.H.setTag(dVar3);
                            z16 = false;
                        } else {
                            dVar3.E.setVisibility(0);
                            dVar3.E.setText(HardCodeUtil.qqStr(R.string.f170028dd));
                            if (AppSetting.f99565y) {
                                dVar3.E.setContentDescription(HardCodeUtil.qqStr(R.string.f170028dd));
                            }
                        }
                        dVar3.F.setVisibility(8);
                        View view4 = dVar3.D;
                        if (!z16) {
                            dVar = dVar3;
                        } else {
                            dVar = null;
                        }
                        view4.setTag(dVar);
                        View view5 = dVar3.D;
                        if (!z16) {
                            eVar = this;
                        } else {
                            eVar = null;
                        }
                        view5.setOnClickListener(eVar);
                        dVar3.D.setClickable(z16);
                        CheckBox checkBox = dVar3.H;
                        if (!this.E) {
                            i16 = 8;
                        }
                        checkBox.setVisibility(i16);
                        dVar3.I.setOnClickListener(this);
                        dVar3.I.setTag(dVar3);
                        if (AppSetting.f99565y && sb5 != null) {
                            view2.setContentDescription(sb5.toString());
                        }
                        com.tencent.mobileqq.selectmember.util.c.a(dVar3);
                    }
                    z16 = false;
                    View view42 = dVar3.D;
                    if (!z16) {
                    }
                    view42.setTag(dVar);
                    View view52 = dVar3.D;
                    if (!z16) {
                    }
                    view52.setOnClickListener(eVar);
                    dVar3.D.setClickable(z16);
                    CheckBox checkBox2 = dVar3.H;
                    if (!this.E) {
                    }
                    checkBox2.setVisibility(i16);
                    dVar3.I.setOnClickListener(this);
                    dVar3.I.setTag(dVar3);
                    if (AppSetting.f99565y) {
                        view2.setContentDescription(sb5.toString());
                    }
                    com.tencent.mobileqq.selectmember.util.c.a(dVar3);
                } else {
                    dVar3.I.setVisibility(8);
                    if (TroopAddFrdsInnerFrame.this.f285819i0 == TroopAddFrdsInnerFrame.f285807q0) {
                        dVar3.J.setVisibility(0);
                        String valueOf = String.valueOf(TroopAddFrdsInnerFrame.this.T[binarySearch]);
                        dVar3.J.setText(valueOf);
                        dVar3.J.setContentDescription(String.format(TroopAddFrdsInnerFrame.this.f285782h.getString(R.string.aud), valueOf.toLowerCase()));
                    } else {
                        dVar3.J.setVisibility(8);
                        view2.setBackgroundResource(0);
                    }
                }
                dVar3.K = i3;
                if (TroopAddFrdsInnerFrame.this.K == 6 && dVar3.G != null) {
                    TroopAddFrdsInnerFrame troopAddFrdsInnerFrame2 = TroopAddFrdsInnerFrame.this;
                    troopAddFrdsInnerFrame2.P(troopAddFrdsInnerFrame2.f(), dVar3.f187210d, i3, dVar3.G.troopuin);
                }
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }

        public int i(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str)).intValue();
            }
            if (TroopAddFrdsInnerFrame.this.T != null) {
                int i3 = 0;
                while (true) {
                    String[] strArr = TroopAddFrdsInnerFrame.this.T;
                    if (i3 < strArr.length) {
                        if (strArr[i3].equals(str)) {
                            break;
                        }
                        i3++;
                    } else {
                        i3 = -1;
                        break;
                    }
                }
                if (i3 >= 0) {
                    return TroopAddFrdsInnerFrame.this.S[i3];
                }
            }
            return -1;
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public boolean isDividerView(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, i3)).booleanValue();
            }
            if (Arrays.binarySearch(TroopAddFrdsInnerFrame.this.S, i3) >= 0) {
                return true;
            }
            return false;
        }

        public void j(ResultRecord resultRecord, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, resultRecord, Boolean.valueOf(z16));
                return;
            }
            while (true) {
                if (i3 < this.D.size()) {
                    if (TextUtils.equals(resultRecord.uin, this.D.get(i3).uin)) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (z16) {
                if (i3 == -1) {
                    this.D.add(resultRecord);
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
            if (i3 != -1) {
                this.D.remove(i3);
                notifyDataSetChanged();
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
                if (tag != null) {
                    d dVar = (d) tag;
                    TroopMemberInfo troopMemberInfo = dVar.G;
                    int id5 = view.getId();
                    if (id5 == R.id.jxj) {
                        TroopAddFrdsInnerFrame troopAddFrdsInnerFrame = TroopAddFrdsInnerFrame.this;
                        TroopAddFrdsInnerFrame.C(troopAddFrdsInnerFrame.f285782h, troopMemberInfo, troopAddFrdsInnerFrame.I, false);
                        if (TroopAddFrdsInnerFrame.this.K == 6) {
                            TroopAddFrdsInnerFrame troopAddFrdsInnerFrame2 = TroopAddFrdsInnerFrame.this;
                            troopAddFrdsInnerFrame2.N(troopAddFrdsInnerFrame2.f(), troopMemberInfo.memberuin, dVar.K, troopMemberInfo.troopuin);
                        }
                        com.tencent.mobileqq.selectmember.util.c.c(view, troopMemberInfo.memberuin);
                    } else if (id5 == R.id.gqb) {
                        if (this.E) {
                            boolean h16 = h(dVar.G);
                            ResultRecord resultRecord = new ResultRecord();
                            resultRecord.uin = dVar.G.memberuin;
                            resultRecord.groupUin = troopMemberInfo.troopuin;
                            resultRecord.memberNickInfo = troopMemberInfo.nickInfo;
                            ArrayList arrayList = new ArrayList(1);
                            arrayList.add(resultRecord);
                            if (!h16) {
                                TroopAddFrdsInnerFrame.this.f285782h.addFriendResults(arrayList, false);
                            } else {
                                TroopAddFrdsInnerFrame.this.f285782h.removeFriendFromResultList(dVar.G.memberuin);
                                TroopAddFrdsInnerFrame.this.f285782h.updateMultiAddState(resultRecord, false);
                                TroopAddFrdsInnerFrame.this.f285782h.mSelectedAndSearchBar.p(false);
                                TroopAddFrdsInnerFrame.this.f285782h.setupDoneBtn();
                            }
                            notifyDataSetChanged();
                        } else {
                            Intent profileCardIntentOnly = ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).getProfileCardIntentOnly(TroopAddFrdsInnerFrame.this.f285782h, null);
                            profileCardIntentOnly.putExtra("troopUin", troopMemberInfo.troopuin);
                            profileCardIntentOnly.putExtra("memberUin", troopMemberInfo.memberuin);
                            profileCardIntentOnly.putExtra("fromFlag", 1);
                            profileCardIntentOnly.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, TroopAddFrdsInnerFrame.this.f285782h.getString(R.string.i7y));
                            profileCardIntentOnly.putExtra("custom_leftbackbutton_name", TroopAddFrdsInnerFrame.this.f285782h.getString(R.string.button_back));
                            ISearchPieceFetcher iSearchPieceFetcher = (ISearchPieceFetcher) QRoute.api(ISearchPieceFetcher.class);
                            TroopAddFrdsInnerFrame troopAddFrdsInnerFrame3 = TroopAddFrdsInnerFrame.this;
                            iSearchPieceFetcher.joinFriendProfileIntentWithTroopMemberCardIntent(troopAddFrdsInnerFrame3.f285782h, troopAddFrdsInnerFrame3.f285784m, profileCardIntentOnly, 9);
                            com.tencent.mobileqq.selectmember.util.c.c(view, troopMemberInfo.memberuin);
                        }
                        if (TroopAddFrdsInnerFrame.this.K == 6 && troopMemberInfo != null) {
                            TroopAddFrdsInnerFrame troopAddFrdsInnerFrame4 = TroopAddFrdsInnerFrame.this;
                            troopAddFrdsInnerFrame4.O(troopAddFrdsInnerFrame4.f(), troopMemberInfo.memberuin, dVar.K, troopMemberInfo.troopuin);
                        }
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class f implements Comparator<TroopMemberInfo> {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAddFrdsInnerFrame.this);
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(TroopMemberInfo troopMemberInfo, TroopMemberInfo troopMemberInfo2) {
            String str;
            int commonFrdCnt;
            int commonFrdCnt2;
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopMemberInfo, (Object) troopMemberInfo2)).intValue();
            }
            int i16 = TroopAddFrdsInnerFrame.this.f285819i0;
            int i17 = 0;
            if (i16 == TroopAddFrdsInnerFrame.f285808r0) {
                int i18 = troopMemberInfo.addState - troopMemberInfo2.addState;
                if (i18 == 0) {
                    if (troopMemberInfo.noCommonFrdCnt()) {
                        commonFrdCnt = 0;
                    } else {
                        commonFrdCnt = troopMemberInfo.getCommonFrdCnt();
                    }
                    if (troopMemberInfo2.noCommonFrdCnt()) {
                        commonFrdCnt2 = 0;
                    } else {
                        commonFrdCnt2 = troopMemberInfo2.getCommonFrdCnt();
                    }
                    int i19 = commonFrdCnt2 - commonFrdCnt;
                    if (commonFrdCnt == 0 && commonFrdCnt2 == 0 && TroopAddFrdsInnerFrame.this.J != null) {
                        if (!TroopAddFrdsInnerFrame.this.J.isTroopAdmin(troopMemberInfo.memberuin) && !TroopAddFrdsInnerFrame.this.J.isTroopOwner(troopMemberInfo.memberuin)) {
                            i3 = 0;
                        } else {
                            i3 = 1;
                        }
                        if (TroopAddFrdsInnerFrame.this.J.isTroopAdmin(troopMemberInfo2.memberuin) || TroopAddFrdsInnerFrame.this.J.isTroopOwner(troopMemberInfo2.memberuin)) {
                            i17 = 1;
                        }
                        int i26 = i17 - i3;
                        if (i26 == 0) {
                            return Long.signum(troopMemberInfo2.last_active_time - troopMemberInfo.last_active_time);
                        }
                        return i26;
                    }
                    return i19;
                }
                return i18;
            }
            if (i16 != TroopAddFrdsInnerFrame.f285807q0 || troopMemberInfo == null || (str = troopMemberInfo.displayedNamePinyinFirst) == null || troopMemberInfo2 == null) {
                return 0;
            }
            return str.compareToIgnoreCase(troopMemberInfo2.displayedNamePinyinFirst);
        }

        /* synthetic */ f(TroopAddFrdsInnerFrame troopAddFrdsInnerFrame, a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopAddFrdsInnerFrame, (Object) aVar);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28704);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
            return;
        }
        f285806p0 = 10.0d;
        f285807q0 = 0;
        f285808r0 = 1;
        f285809s0 = ((ISelectMemberRefatorHelperApi) QRoute.api(ISelectMemberRefatorHelperApi.class)).getSCENE_TYPE_DEFAULT_Value();
        f285810t0 = 1000;
    }

    public TroopAddFrdsInnerFrame(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.D = 0;
        this.E = "";
        this.R = Collections.synchronizedMap(new LinkedHashMap());
        this.S = new int[0];
        this.T = new String[0];
        this.U = 0;
        this.V = 0;
        this.W = false;
        this.f285814d0 = 0.0d;
        this.f285815e0 = 0;
        this.f285818h0 = false;
        this.f285819i0 = f285808r0;
        this.f285820j0 = new HashSet();
        this.f285823m0 = new a();
        this.f285824n0 = new com.tencent.mobileqq.friend.observer.b() { // from class: com.tencent.mobileqq.selectmember.TroopAddFrdsInnerFrame.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopAddFrdsInnerFrame.this);
                }
            }

            public void a(boolean z16, String str, ArrayList<cmd0x777$AddFrdInfo> arrayList) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, this, Boolean.valueOf(z16), str, arrayList);
                    return;
                }
                if (!TextUtils.isEmpty(TroopAddFrdsInnerFrame.this.F) && !TroopAddFrdsInnerFrame.this.F.equals(str)) {
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("TroopAddFrdsInnerFrame", 2, String.format("onAddBatchTroopFrd suc:%d troopUin:%s size:%d", Integer.valueOf(z16 ? 1 : 0), str, Integer.valueOf(arrayList.size())));
                }
                TroopAddFrdsInnerFrame.this.f285782h.runOnUiThread(new Runnable(arrayList) { // from class: com.tencent.mobileqq.selectmember.TroopAddFrdsInnerFrame.2.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ ArrayList f285827d;

                    {
                        this.f285827d = arrayList;
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) arrayList);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                            return;
                        }
                        ISelectMemberRefatorHelperApi iSelectMemberRefatorHelperApi = (ISelectMemberRefatorHelperApi) QRoute.api(ISelectMemberRefatorHelperApi.class);
                        TroopAddFrdsInnerFrame troopAddFrdsInnerFrame = TroopAddFrdsInnerFrame.this;
                        iSelectMemberRefatorHelperApi.showResultForBatchAddFriendData(troopAddFrdsInnerFrame.f285784m, troopAddFrdsInnerFrame.f285782h, troopAddFrdsInnerFrame.F, this.f285827d);
                    }
                });
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    arrayList2.add(Long.toString(arrayList.get(i3).uint64_uin.get()));
                }
                if (arrayList2.size() > 0) {
                    Message obtainMessage = TroopAddFrdsInnerFrame.this.f285821k0.obtainMessage(9);
                    obtainMessage.obj = arrayList2;
                    obtainMessage.sendToTarget();
                }
            }

            protected void b(String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, (Object) str);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("TroopAddFrdsInnerFrame", 2, String.format("onAddFriend %s", str));
                }
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(str);
                Message obtainMessage = TroopAddFrdsInnerFrame.this.f285821k0.obtainMessage(9);
                obtainMessage.obj = arrayList;
                obtainMessage.sendToTarget();
            }

            @Override // com.tencent.mobileqq.app.BusinessObserver
            public void onUpdate(int i3, boolean z16, Object obj) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
                    return;
                }
                if (i3 == 107) {
                    Object[] objArr = (Object[]) obj;
                    a(z16, (String) objArr[0], (ArrayList) objArr[1]);
                } else if (i3 == 59 && z16 && obj != null && (obj instanceof String)) {
                    b((String) obj);
                }
            }
        };
        this.f285825o0 = new b();
    }

    public static void C(Context context, TroopMemberInfo troopMemberInfo, String str, boolean z16) {
        int i3;
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
        String showName = troopMemberInfo.nickInfo.getShowName();
        int i16 = 16;
        if (context instanceof Activity) {
            Intent intent = ((Activity) context).getIntent();
            int i17 = f285809s0;
            int intExtra = intent.getIntExtra(ISelectMemberActivityConstants.PARAM_BATCH_ADDFRD_SCENE_TYPE, i17);
            if (intExtra != i17) {
                i16 = ((ISelectMemberRefatorHelperApi) QRoute.api(ISelectMemberRefatorHelperApi.class)).getSubSourceId_single(intExtra);
            }
            if (intExtra == 6) {
                i3 = 3045;
                Intent startAddFriend = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(context, 1, troopMemberInfo.memberuin, str, i3, i16, showName, null, null, null, null);
                startAddFriend.putExtra("need_result_uin", true);
                startAddFriend.putExtra("select_multi_mode", z16);
                startAddFriend.putExtra("troop_uin", troopMemberInfo.troopuin);
                ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriendForResult((Activity) context, startAddFriend, 11);
                ThreadManagerV2.post(new Runnable(z16, appInterface, troopMemberInfo) { // from class: com.tencent.mobileqq.selectmember.TroopAddFrdsInnerFrame.7
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ boolean f285837d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ AppInterface f285838e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ TroopMemberInfo f285839f;

                    {
                        this.f285837d = z16;
                        this.f285838e = appInterface;
                        this.f285839f = troopMemberInfo;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), appInterface, troopMemberInfo);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        String str2;
                        String str3;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        boolean z17 = this.f285837d;
                        if (z17) {
                            str2 = "multiMode_add";
                        } else {
                            str2 = "singleMode_add";
                        }
                        String str4 = str2;
                        AppInterface appInterface2 = this.f285838e;
                        String str5 = this.f285839f.troopuin;
                        if (z17) {
                            str3 = "1";
                        } else {
                            str3 = "0";
                        }
                        ReportController.o(appInterface2, "dc00899", "Grp_addFrd", "", "frd_select", str4, 0, 0, str5, str3, "", "");
                    }
                }, 5, null, true);
            }
        }
        i3 = 3004;
        Intent startAddFriend2 = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(context, 1, troopMemberInfo.memberuin, str, i3, i16, showName, null, null, null, null);
        startAddFriend2.putExtra("need_result_uin", true);
        startAddFriend2.putExtra("select_multi_mode", z16);
        startAddFriend2.putExtra("troop_uin", troopMemberInfo.troopuin);
        ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriendForResult((Activity) context, startAddFriend2, 11);
        ThreadManagerV2.post(new Runnable(z16, appInterface, troopMemberInfo) { // from class: com.tencent.mobileqq.selectmember.TroopAddFrdsInnerFrame.7
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ boolean f285837d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ AppInterface f285838e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ TroopMemberInfo f285839f;

            {
                this.f285837d = z16;
                this.f285838e = appInterface;
                this.f285839f = troopMemberInfo;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), appInterface, troopMemberInfo);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                String str2;
                String str3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                boolean z17 = this.f285837d;
                if (z17) {
                    str2 = "multiMode_add";
                } else {
                    str2 = "singleMode_add";
                }
                String str4 = str2;
                AppInterface appInterface2 = this.f285838e;
                String str5 = this.f285839f.troopuin;
                if (z17) {
                    str3 = "1";
                } else {
                    str3 = "0";
                }
                ReportController.o(appInterface2, "dc00899", "Grp_addFrd", "", "frd_select", str4, 0, 0, str5, str3, "", "");
            }
        }, 5, null, true);
    }

    private void D(String str, boolean z16) {
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberListWithExtInfo(str, this.f285782h, z16, "TroopAddFrdsInnerFrame", new c(z16, str));
    }

    private void E(Map<String, List<TroopMemberInfo>> map) {
        boolean z16;
        ITroopRobotService iTroopRobotService = (ITroopRobotService) this.f285782h.getAppRuntime().getRuntimeService(ITroopRobotService.class, "all");
        boolean b16 = com.tencent.mobileqq.troop.util.a.b(this.f285782h.getAppRuntime(), this.F, this.f285782h.getAppRuntime().getCurrentAccountUin());
        if (!((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).isTroopAdmin(this.f285782h.getAppRuntime(), this.F, this.f285782h.getAppRuntime().getCurrentAccountUin()) && !b16) {
            z16 = true;
        } else {
            z16 = false;
        }
        for (List<TroopMemberInfo> list : map.values()) {
            int i3 = 0;
            while (i3 < list.size()) {
                if (list.get(i3) == null) {
                    list.remove(i3);
                } else if (com.tencent.mobileqq.selectmember.util.a.m(this.f285784m, list.get(i3).memberuin)) {
                    list.remove(i3);
                } else {
                    if (z16 && iTroopRobotService.isRobotUin(list.get(i3).memberuin)) {
                        list.remove(i3);
                    }
                    i3++;
                }
                i3--;
                i3++;
            }
        }
        HashMap hashMap = new HashMap();
        for (String str : map.keySet()) {
            if (map.get(str).size() == 0) {
                hashMap.put(str, 1);
            }
        }
        Iterator it = hashMap.keySet().iterator();
        while (it.hasNext()) {
            map.remove((String) it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int F(String str) {
        boolean z16;
        boolean k3 = com.tencent.mobileqq.selectmember.util.a.k(this.f285784m, str);
        if (!k3) {
            z16 = com.tencent.mobileqq.selectmember.util.a.j(this.f285784m, str);
        } else {
            z16 = false;
        }
        if (k3) {
            return 4;
        }
        if (z16) {
            return 3;
        }
        return 2;
    }

    private String G(String str, int i3) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("exp_uin", str);
            }
            jSONObject.put("exp_position", i3);
            jSONObject.put("algh_id", "sp");
            return jSONObject.toString();
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("", 2, "getTroopMayKnowReportDetail error", e16);
            }
            return "";
        }
    }

    private void H(String str) {
        String str2;
        if (str != null && str.length() > 0) {
            TroopInfo c16 = com.tencent.mobileqq.selectmember.util.a.c(this.f285784m, str);
            if (c16 != null) {
                str2 = c16.troopcode;
            } else {
                str2 = "0";
            }
            if (str2 != null && str2.length() > 0) {
                if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                    this.f285782h.stopTitleProgress();
                    SelectMemberActivity selectMemberActivity = this.f285782h;
                    QQToast.makeText(selectMemberActivity, selectMemberActivity.getString(R.string.b3j), 0).show(this.f285782h.mTitleBar.getHeight());
                    return;
                }
                this.W = true;
                if (QLog.isColorLevel()) {
                    QLog.d("TroopAddFrdsInnerFrame", 2, "get troop members from server, troopUin: " + str + " troopCode: " + str2);
                }
                D(str, true);
            }
        }
    }

    private void I() {
        long j3 = PreferenceManager.getDefaultSharedPreferences(this.f285784m.getApp()).getLong(String.format(Locale.getDefault(), "%s_%s_%s", ((ISelectMemberRefatorHelperApi) QRoute.api(ISelectMemberRefatorHelperApi.class)).getScene_SP_KEY_BAF_DATA_CHECK_FLAG_MEMBERS_KeyString(), this.f285784m.getCurrentAccountUin(), this.F), 0L);
        TroopInfo c16 = com.tencent.mobileqq.selectmember.util.a.c(this.f285784m, this.F);
        this.J = c16;
        if (c16 != null) {
            int i3 = c16.wMemberNum - 1;
            this.D = i3;
            if (i3 > 0) {
                this.f285814d0 = 0.0d;
                Handler handler = this.f285822l0;
                handler.sendMessage(handler.obtainMessage(4));
            }
        }
        if (j3 == 0) {
            H(this.F);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopAddFrdsInnerFrame", 2, "read troop members from database before updating data from server");
        }
        D(this.F, false);
    }

    private void J() {
        this.N = (PinnedDividerListView) findViewById(R.id.atu);
        IndexView indexView = (IndexView) findViewById(R.id.djh);
        this.P = indexView;
        if (this.f285819i0 == f285807q0) {
            indexView.setIndex(new String[]{ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", BdhLogUtil.LogTag.Tag_Conn, "D", "E", UserInfo.SEX_FEMALE, "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, ExifInterface.LATITUDE_SOUTH, "T", "U", "V", "W", "X", "Y", "Z", "#"});
            this.P.setOnIndexChangedListener(this);
        } else {
            indexView.setVisibility(8);
        }
        this.N.setSelector(R.color.ajr);
        this.N.setOnLayoutListener(this);
        this.f285811a0 = (RelativeLayout) findViewById(R.id.jzs);
        this.f285812b0 = (ProgressBar) findViewById(R.id.d7z);
        this.f285813c0 = (TextView) findViewById(R.id.efr);
        View inflate = LayoutInflater.from(this.f285782h).inflate(R.layout.search_box, (ViewGroup) this.N, false);
        this.f285816f0 = inflate;
        inflate.findViewById(R.id.btn_cancel_search).setVisibility(8);
        EditText editText = (EditText) this.f285816f0.findViewById(R.id.et_search_keyword);
        this.f285817g0 = editText;
        editText.setFocusableInTouchMode(false);
        this.f285817g0.setCursorVisible(false);
        this.f285817g0.setOnClickListener(this);
        this.N.addHeaderView(this.f285816f0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(ArrayList<TroopMemberInfo> arrayList) {
        int size;
        try {
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onFetchMemberList:");
                if (arrayList == null) {
                    size = 0;
                } else {
                    size = arrayList.size();
                }
                sb5.append(size);
                QLog.d("TroopAddFrdsInnerFrame", 2, sb5.toString());
            }
            this.f285782h.getSharedPreferences(DeviceProfileManager.KEY_LAST_UPDATE_TIME + this.f285784m.getCurrentAccountUin(), 4).edit().putLong("key_last_update_time" + this.F, System.currentTimeMillis()).commit();
            L(this.F, arrayList);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("TroopAddFrdsInnerFrame", 2, "onFetchMemberList:" + e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void L(String str, List<TroopMemberInfo> list) {
        int i3;
        Map synchronizedMap = Collections.synchronizedMap(new LinkedHashMap());
        ArrayList arrayList = new ArrayList();
        String currentAccountUin = this.f285784m.getCurrentAccountUin();
        if (list == null) {
            this.f285822l0.sendMessage(this.f285822l0.obtainMessage(3));
            return;
        }
        int size = list.size();
        this.D = size - 1;
        if (size > 0) {
            int i16 = f285810t0;
            int i17 = size / i16;
            int i18 = 1;
            if (size % i16 == 0) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            AtomicInteger atomicInteger = new AtomicInteger(i17 + i3);
            if (QLog.isColorLevel()) {
                QLog.d("TroopMemberListInnerFrame.thread", 2, "parallel process mJobCount: " + atomicInteger.get());
            }
            int i19 = 0;
            while (i19 < size) {
                Map map = synchronizedMap;
                Map map2 = synchronizedMap;
                boolean z16 = i18;
                ThreadManagerV2.excute(new Runnable(list, i19, Math.min((f285810t0 + i19) - i18, size), str, currentAccountUin, map, arrayList, atomicInteger) { // from class: com.tencent.mobileqq.selectmember.TroopAddFrdsInnerFrame.4
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ List C;
                    final /* synthetic */ AtomicInteger D;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ List f285829d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ int f285830e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ int f285831f;

                    /* renamed from: h, reason: collision with root package name */
                    final /* synthetic */ String f285832h;

                    /* renamed from: i, reason: collision with root package name */
                    final /* synthetic */ String f285833i;

                    /* renamed from: m, reason: collision with root package name */
                    final /* synthetic */ Map f285834m;

                    {
                        this.f285829d = list;
                        this.f285830e = i19;
                        this.f285831f = r8;
                        this.f285832h = str;
                        this.f285833i = currentAccountUin;
                        this.f285834m = map;
                        this.C = arrayList;
                        this.D = atomicInteger;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, TroopAddFrdsInnerFrame.this, list, Integer.valueOf(i19), Integer.valueOf(r8), str, currentAccountUin, map, arrayList, atomicInteger);
                        }
                    }

                    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
                    @Override // java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void run() {
                        String str2;
                        String str3;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        List<TroopMemberInfo> subList = this.f285829d.subList(this.f285830e, this.f285831f);
                        ArrayList arrayList2 = new ArrayList();
                        int i26 = 0;
                        for (TroopMemberInfo troopMemberInfo : subList) {
                            if (!this.f285832h.equals(TroopAddFrdsInnerFrame.this.F)) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("TroopMemberListInnerFrame.thread", 2, "subThread, curTroopUin != mTroopUin, return, " + this.f285832h + "," + TroopAddFrdsInnerFrame.this.F);
                                    return;
                                }
                                return;
                            }
                            if (TroopAddFrdsInnerFrame.this.f285782h.mShowMyself || !this.f285833i.equalsIgnoreCase(troopMemberInfo.memberuin)) {
                                if (!TroopAddFrdsInnerFrame.this.f285782h.mUinsToHide.contains(troopMemberInfo.memberuin) && Utils.M(troopMemberInfo.memberuin)) {
                                    if (!com.tencent.mobileqq.selectmember.util.a.n(TroopAddFrdsInnerFrame.this.f285784m, troopMemberInfo.memberuin)) {
                                        try {
                                            if (Long.valueOf(troopMemberInfo.memberuin).longValue() >= 0) {
                                                TroopAddFrdsInnerFrame troopAddFrdsInnerFrame = TroopAddFrdsInnerFrame.this;
                                                int i27 = troopAddFrdsInnerFrame.f285819i0;
                                                if (i27 == TroopAddFrdsInnerFrame.f285807q0) {
                                                    String showNamePyFirst = troopMemberInfo.nickInfo.getUIInfo().getShowNamePyFirst();
                                                    troopMemberInfo.displayedNamePinyinFirst = showNamePyFirst;
                                                    if (showNamePyFirst != null && showNamePyFirst.length() != 0) {
                                                        str3 = troopMemberInfo.displayedNamePinyinFirst.substring(0, 1);
                                                    } else {
                                                        str3 = "#";
                                                    }
                                                    char charAt = str3.charAt(0);
                                                    if (('A' <= charAt && charAt <= 'Z') || ('a' <= charAt && charAt <= 'z')) {
                                                        str2 = str3.toUpperCase();
                                                    } else {
                                                        str2 = "#";
                                                    }
                                                } else if (i27 == TroopAddFrdsInnerFrame.f285808r0) {
                                                    if (!TextUtils.isEmpty(troopAddFrdsInnerFrame.M) && TroopAddFrdsInnerFrame.this.M.equalsIgnoreCase(troopMemberInfo.memberuin)) {
                                                        troopMemberInfo.addState = 1;
                                                    } else {
                                                        troopMemberInfo.addState = TroopAddFrdsInnerFrame.this.F(troopMemberInfo.memberuin);
                                                    }
                                                    str2 = "" + troopMemberInfo.addState;
                                                } else {
                                                    str2 = null;
                                                }
                                                if (troopMemberInfo.noCommonFrdCnt() && !troopMemberInfo.memberuin.equals(this.f285833i)) {
                                                    arrayList2.add(troopMemberInfo.memberuin);
                                                }
                                                synchronized (this.f285834m) {
                                                    if (this.f285834m.get(str2) == null) {
                                                        this.f285834m.put(str2, new ArrayList());
                                                    }
                                                    ((List) this.f285834m.get(str2)).add(troopMemberInfo);
                                                    i26++;
                                                }
                                            } else {
                                                continue;
                                            }
                                        } catch (Exception unused) {
                                            continue;
                                        }
                                    }
                                    while (r0.hasNext()) {
                                    }
                                }
                            }
                        }
                        synchronized (this.C) {
                            this.C.addAll(arrayList2);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("TroopMemberListInnerFrame.thread", 2, "subThread end, id=" + Thread.currentThread().getId() + ", threadCnt=" + this.D.get() + ", curTroopUin=" + this.f285832h);
                        }
                        if (this.D.getAndDecrement() <= 1) {
                            Message obtainMessage = TroopAddFrdsInnerFrame.this.f285822l0.obtainMessage(3);
                            obtainMessage.arg1 = i26;
                            obtainMessage.obj = new Object[]{this.f285834m, this.f285832h};
                            TroopAddFrdsInnerFrame.this.f285822l0.sendMessage(obtainMessage);
                            if (this.C.size() > 0) {
                                Message obtainMessage2 = TroopAddFrdsInnerFrame.this.f285821k0.obtainMessage(5);
                                obtainMessage2.obj = this.C;
                                TroopAddFrdsInnerFrame.this.f285821k0.sendMessage(obtainMessage2);
                            }
                        }
                    }
                }, 16, null, z16);
                i19 += f285810t0;
                i18 = z16 ? 1 : 0;
                currentAccountUin = currentAccountUin;
                synchronizedMap = map2;
            }
            return;
        }
        this.f285822l0.sendMessage(this.f285822l0.obtainMessage(3));
    }

    private void M(Message message) {
        Object[] objArr = (Object[]) message.obj;
        this.f285811a0.setVisibility(8);
        if (objArr.length == 3) {
            this.R = (Map) objArr[0];
            this.S = (int[]) objArr[1];
            this.T = (String[]) objArr[2];
        } else {
            this.R = Collections.synchronizedMap(new LinkedHashMap());
            this.S = new int[0];
            this.T = new String[0];
        }
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(AppRuntime appRuntime, String str, int i3, String str2) {
        ReportController.n(appRuntime, "dc00898", "", str, "frd_recom", "frd_list_add", 60, 1, 0, this.L, str2, G("", i3), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(AppRuntime appRuntime, String str, int i3, String str2) {
        ReportController.n(appRuntime, "dc00898", "", str, "frd_recom", "frd_list_clk", 60, 1, 0, this.L, str2, G("", i3), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(AppRuntime appRuntime, String str, int i3, String str2) {
        ReportController.n(appRuntime, "dc00898", "", "", "frd_recom", "frd_list_exp", 0, 1, 0, this.L, str2, G(str, i3), "");
    }

    private Object[] Q() {
        Iterator<String> it = this.R.keySet().iterator();
        if (this.J == null && QLog.isColorLevel()) {
            QLog.d("TroopAddFrdsInnerFrame", 2, "sortMembers: mTroopInfo not exist");
        }
        while (it.hasNext()) {
            Collections.sort(this.R.get(it.next()), new f(this, null));
        }
        Map<String, List<TroopMemberInfo>> map = this.R;
        this.R = Collections.synchronizedMap(new LinkedHashMap());
        int i3 = this.f285819i0;
        if (i3 == f285807q0) {
            for (char c16 = EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET; c16 <= 'Z'; c16 = (char) (c16 + 1)) {
                if (map.get(String.valueOf(c16)) != null) {
                    this.R.put(String.valueOf(c16), map.get(String.valueOf(c16)));
                }
            }
            if (map.get("#") != null) {
                this.R.put("#", map.get("#"));
            }
            map.clear();
        } else if (i3 == f285808r0) {
            for (int i16 = 1; i16 < 5; i16++) {
                if (map.get(String.valueOf(i16)) != null) {
                    this.R.put(String.valueOf(i16), map.get(String.valueOf(i16)));
                }
            }
            map.clear();
        }
        int size = this.R.keySet().size();
        int[] iArr = new int[size];
        String[] strArr = new String[this.R.keySet().size()];
        Iterator<String> it5 = this.R.keySet().iterator();
        if (size == 0) {
            return new Object[0];
        }
        iArr[0] = 0;
        for (int i17 = 1; i17 < size; i17++) {
            iArr[i17] = iArr[i17] + iArr[i17 - 1] + this.R.get(it5.next()).size() + 1;
        }
        Iterator<String> it6 = this.R.keySet().iterator();
        int i18 = 0;
        while (it6.hasNext()) {
            strArr[i18] = it6.next();
            i18++;
        }
        return new Object[]{this.R, iArr, strArr};
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberActivity.p
    public void b(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (!z17) {
            this.f285818h0 = !this.f285818h0;
        }
        if (this.f285818h0) {
            this.N.removeHeaderView(this.f285816f0);
        } else {
            this.N.addHeaderView(this.f285816f0);
        }
        if (z16) {
            this.Q.D.clear();
            this.f285782h.removeAllFriendResult();
        }
        this.Q.g(this.f285818h0);
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberActivity.p
    public void c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            return;
        }
        Iterator<String> it = this.R.keySet().iterator();
        TroopMemberInfo troopMemberInfo = null;
        while (it.hasNext()) {
            List<TroopMemberInfo> list = this.R.get(it.next());
            int i3 = 0;
            while (true) {
                if (i3 >= list.size()) {
                    break;
                }
                if (str.equals(list.get(i3).memberuin)) {
                    troopMemberInfo = list.get(i3);
                    break;
                }
                i3++;
            }
        }
        if (troopMemberInfo != null) {
            C(this.f285782h, troopMemberInfo, this.I, true);
        }
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberActivity.p
    public void d(ResultRecord resultRecord, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, resultRecord, Boolean.valueOf(z16));
        } else if (resultRecord != null) {
            this.Q.j(resultRecord, z16);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) message)).booleanValue();
        }
        switch (message.what) {
            case 1:
            case 2:
                M(message);
                break;
            case 3:
                this.f285815e0 = message.arg1;
                this.f285822l0.removeMessages(4);
                Object obj = message.obj;
                if (obj instanceof Object[]) {
                    Object[] objArr = (Object[]) obj;
                    if (objArr.length > 0) {
                        String str = (String) objArr[1];
                        if (!str.equals(this.F)) {
                            if (QLog.isColorLevel()) {
                                QLog.d("TroopMemberListInnerFrame.thread", 2, "handleMessage, troopUin != mTroopUin, break:" + str + "," + this.F);
                                break;
                            }
                        } else {
                            this.R = (Map) objArr[0];
                        }
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("TroopMemberListInnerFrame.thread", 2, "handleMessage, mIndexedFriends.size=" + this.R.size());
                }
                E(this.R);
                message.obj = Q();
                M(message);
                break;
            case 4:
                double d16 = this.f285814d0 + f285806p0;
                this.f285814d0 = d16;
                if (d16 < 90.0d && this.D > 0) {
                    if (this.f285811a0.getVisibility() == 8) {
                        this.f285811a0.setVisibility(0);
                    }
                    this.f285812b0.setProgress((int) this.f285814d0);
                    TextView textView = this.f285813c0;
                    String qqStr = HardCodeUtil.qqStr(R.string.u_y);
                    int i3 = this.D;
                    textView.setText(String.format(qqStr, Integer.valueOf(Math.min((int) ((i3 * this.f285814d0) / 100.0d), i3)), Integer.valueOf(this.D)));
                    Handler handler = this.f285822l0;
                    handler.sendMessageDelayed(handler.obtainMessage(4), 800L);
                    break;
                }
                break;
            case 5:
                Object obj2 = message.obj;
                if (obj2 != null && (obj2 instanceof List)) {
                    List<String> list = (List) obj2;
                    com.tencent.mobileqq.troop.api.handler.a aVar = (com.tencent.mobileqq.troop.api.handler.a) this.f285784m.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopAddFriendHandlerName());
                    Long valueOf = Long.valueOf(System.currentTimeMillis());
                    this.G = valueOf;
                    aVar.t1(this.F, list, 0, valueOf.longValue(), f285809s0, false);
                    break;
                }
                break;
            case 6:
                Object obj3 = message.obj;
                if (obj3 != null && (obj3 instanceof HashMap)) {
                    HashMap hashMap = (HashMap) obj3;
                    Iterator<String> it = this.R.keySet().iterator();
                    int i16 = 0;
                    while (it.hasNext()) {
                        List<TroopMemberInfo> list2 = this.R.get(it.next());
                        for (int i17 = 0; i17 < list2.size(); i17++) {
                            String str2 = list2.get(i17).memberuin;
                            if (hashMap.containsKey(str2)) {
                                i16++;
                                list2.get(i17).setCommonFrdCnt(((Integer) hashMap.get(str2)).intValue());
                                if (i16 >= hashMap.size()) {
                                    break;
                                }
                            }
                        }
                    }
                    if (i16 > 0) {
                        Q();
                    }
                    p();
                    break;
                }
                break;
            case 7:
                Object obj4 = message.obj;
                if (obj4 != null && (obj4 instanceof HashMap)) {
                    HashMap hashMap2 = (HashMap) obj4;
                    Iterator<String> it5 = this.R.keySet().iterator();
                    int i18 = 0;
                    while (it5.hasNext()) {
                        List<TroopMemberInfo> list3 = this.R.get(it5.next());
                        for (int i19 = 0; i19 < list3.size(); i19++) {
                            String str3 = list3.get(i19).memberuin;
                            if (hashMap2.containsKey(str3)) {
                                i18++;
                                list3.get(i19).addState = ((Integer) hashMap2.get(str3)).intValue();
                            }
                            if (i18 >= hashMap2.size()) {
                                break;
                            }
                        }
                    }
                    p();
                    break;
                }
                break;
            case 8:
                this.N.setSelectionFromTop(0, 0);
                break;
            case 9:
                Object obj5 = message.obj;
                if (obj5 != null && (obj5 instanceof List)) {
                    this.f285820j0.addAll((List) obj5);
                    if (!this.f285821k0.hasMessages(10)) {
                        this.f285821k0.sendEmptyMessageDelayed(10, 300L);
                        break;
                    }
                }
                break;
            case 10:
                if (this.f285820j0.size() > 0) {
                    HashMap hashMap3 = new HashMap(this.f285820j0.size());
                    for (String str4 : this.f285820j0) {
                        hashMap3.put(str4, Integer.valueOf(F(str4)));
                    }
                    this.f285820j0.clear();
                    Message obtainMessage = this.f285822l0.obtainMessage(7);
                    obtainMessage.obj = hashMap3;
                    obtainMessage.sendToTarget();
                    break;
                }
                break;
        }
        return false;
    }

    @Override // com.tencent.common.app.InnerFrame
    public void i(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i3 == 10 && intent != null && i16 == -1) {
            String stringExtra = intent.getStringExtra(((ISelectMemberRefatorHelperApi) QRoute.api(ISelectMemberRefatorHelperApi.class)).getUnitedVerifyMsgEditFragment_VERIFY_MSG_KeyString());
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            List<String> resultUins = this.f285782h.getResultUins();
            ((ISelectMemberRefatorHelperApi) QRoute.api(ISelectMemberRefatorHelperApi.class)).batchAddFriendForTroopMembers(this.f285784m, this.F, this.I, stringExtra, resultUins, true, 3093, ((ISelectMemberRefatorHelperApi) QRoute.api(ISelectMemberRefatorHelperApi.class)).getSubSourceId_multi(this.K));
            Message obtainMessage = this.f285821k0.obtainMessage(9);
            obtainMessage.obj = resultUins;
            obtainMessage.sendToTarget();
            this.f285782h.toggleSelectMode(true, false);
            this.f285822l0.removeMessages(8);
            Handler handler = this.f285822l0;
            handler.sendMessageDelayed(handler.obtainMessage(8), 120L);
            SelectMemberActivity selectMemberActivity = this.f285782h;
            QQToast.makeText(selectMemberActivity, selectMemberActivity.getString(R.string.heo), 0).show();
            p();
            String str = this.F;
            if (!TextUtils.isEmpty(str)) {
                ThreadManagerV2.post(new Runnable(str, resultUins) { // from class: com.tencent.mobileqq.selectmember.TroopAddFrdsInnerFrame.6
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ String f285835d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ List f285836e;

                    {
                        this.f285835d = str;
                        this.f285836e = resultUins;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, TroopAddFrdsInnerFrame.this, str, resultUins);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            ReportController.o(TroopAddFrdsInnerFrame.this.f285782h.getAppRuntime(), "dc00899", "Grp_addFrd", "", "frd_select", "multiMode_send", 0, 0, this.f285835d, String.valueOf(this.f285836e.size()), "", "");
                        }
                    }
                }, 5, null, true);
                return;
            }
            return;
        }
        if (i3 == 11 && intent != null && i16 == -1) {
            String stringExtra2 = intent.getStringExtra("uin");
            if (TextUtils.isEmpty(stringExtra2)) {
                return;
            }
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(stringExtra2);
            if (this.f285818h0) {
                this.f285782h.toggleSelectMode(true, false);
                this.f285822l0.removeMessages(8);
                Handler handler2 = this.f285822l0;
                handler2.sendMessageDelayed(handler2.obtainMessage(8), 120L);
            }
            Message obtainMessage2 = this.f285821k0.obtainMessage(9);
            obtainMessage2.obj = arrayList;
            obtainMessage2.sendToTarget();
        }
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberInnerFrame, com.tencent.common.app.InnerFrame
    public void j(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
            return;
        }
        super.j(bundle);
        setContentView(R.layout.f169084by4);
        this.f285821k0 = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
        this.f285822l0 = new Handler(Looper.getMainLooper(), this);
        this.K = bundle.getInt(ISelectMemberActivityConstants.PARAM_BATCH_ADDFRD_SCENE_TYPE, f285809s0);
        this.L = bundle.getString(ISelectMemberActivityConstants.PARAM_BATCH_ADDFRD_MAYKNOW_STRATEGY, "");
        J();
        e eVar = new e();
        this.Q = eVar;
        this.N.setAdapter((ListAdapter) eVar);
        this.N.setOnScrollListener(this);
        this.f285782h.addObserver(this.f285824n0);
        this.f285782h.addObserver(this.f285823m0);
        this.f285782h.addObserver(this.f285825o0);
        this.f285782h.setOnSelectStateChangeListener(this);
    }

    @Override // com.tencent.common.app.InnerFrame
    public void m(Bundle bundle) {
        String str;
        TroopInfo c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
            return;
        }
        super.m(bundle);
        this.W = false;
        this.f285782h.mSelectedAndSearchBar.v();
        this.F = bundle.getString("group_uin");
        this.H = bundle.getString("group_name");
        this.I = bundle.getString(ISelectMemberActivityConstants.PARAM_GROUPCODE);
        this.M = bundle.getString(ISelectMemberActivityConstants.PARAM_BATCH_ADDFRD_RECOMMAND_UIN);
        String str2 = this.H;
        if ((str2 == null || str2.length() == 0) && (str = this.F) != null && str.length() > 0 && (c16 = com.tencent.mobileqq.selectmember.util.a.c(this.f285784m, this.F)) != null) {
            this.H = c16.getTroopDisplayName();
        }
        SelectMemberActivity selectMemberActivity = this.f285782h;
        if (selectMemberActivity.mOnlyTroopMember) {
            selectMemberActivity.setupTitleBar(false, "", this.H);
        } else {
            selectMemberActivity.setupTitleBar(true, HardCodeUtil.qqStr(R.string.f172800ua0), this.H);
        }
        this.f285811a0.setVisibility(8);
        String str3 = this.F;
        if (str3 != null && str3.length() > 0) {
            if (!this.F.equals(this.E)) {
                this.R = Collections.synchronizedMap(new LinkedHashMap());
                this.S = new int[0];
                this.T = new String[0];
                p();
                I();
                this.N.setSelection(0);
                this.E = this.F;
                return;
            }
            p();
            return;
        }
        this.f285782h.finish();
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberInnerFrame
    public com.tencent.mobileqq.search.view.f n(boolean z16, com.tencent.mobileqq.search.k kVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (com.tencent.mobileqq.search.view.f) iPatchRedirector.redirect((short) 16, this, Boolean.valueOf(z16), kVar);
        }
        ISearchViewCreator iSearchViewCreator = (ISearchViewCreator) QRoute.api(ISearchViewCreator.class);
        String str = this.F;
        SelectMemberActivity selectMemberActivity = this.f285782h;
        return iSearchViewCreator.createContactSearchFragment(24, 1048576, str, selectMemberActivity.mUinsToHide, selectMemberActivity, z16, kVar);
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberInnerFrame
    public String o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.F;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) view);
        } else if (view.getId() == R.id.et_search_keyword) {
            Bundle bundle = new Bundle();
            bundle.putInt(ISelectMemberActivityConstants.PARAM_BATCH_ADDFRD_SCENE_TYPE, this.K);
            ((ISelectMemberRefatorHelperApi) QRoute.api(ISelectMemberRefatorHelperApi.class)).launchContactSearchComponentActivityForResult(this.f285782h, null, this.F, 23, 1048576, 21001, bundle);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.common.app.InnerFrame
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        e eVar = this.Q;
        if (eVar != null) {
            eVar.destroy();
        }
        this.f285822l0.removeCallbacksAndMessages(null);
        this.f285821k0.removeCallbacksAndMessages(null);
        this.f285782h.removeObserver(this.f285824n0);
        this.f285782h.removeObserver(this.f285823m0);
        this.f285782h.removeObserver(this.f285825o0);
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.widget.IndexView.b
    public void onIndexChanged(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
            return;
        }
        if ("$".equals(str)) {
            this.N.setSelection(0);
            return;
        }
        int i3 = this.Q.i(str);
        if (i3 != -1) {
            PinnedDividerListView pinnedDividerListView = this.N;
            pinnedDividerListView.setSelection(i3 + pinnedDividerListView.getHeaderViewsCount());
        }
    }

    @Override // com.tencent.mobileqq.widget.PinnedDividerListView.b
    public void onLayout(View view, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) absListView, i3);
        } else if (i3 != 0) {
            String str = MobileQQ.QQ_PACKAGE_NAME;
            ((InputMethodManager) BaseApplication.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(this.N.getWindowToken(), 0);
        }
    }

    @Override // com.tencent.common.app.InnerFrame
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onStop();
        }
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberInnerFrame
    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            this.Q.notifyDataSetChanged();
        }
    }

    public TroopAddFrdsInnerFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.D = 0;
        this.E = "";
        this.R = Collections.synchronizedMap(new LinkedHashMap());
        this.S = new int[0];
        this.T = new String[0];
        this.U = 0;
        this.V = 0;
        this.W = false;
        this.f285814d0 = 0.0d;
        this.f285815e0 = 0;
        this.f285818h0 = false;
        this.f285819i0 = f285808r0;
        this.f285820j0 = new HashSet();
        this.f285823m0 = new a();
        this.f285824n0 = new com.tencent.mobileqq.friend.observer.b() { // from class: com.tencent.mobileqq.selectmember.TroopAddFrdsInnerFrame.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopAddFrdsInnerFrame.this);
                }
            }

            public void a(boolean z16, String str, ArrayList arrayList) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, this, Boolean.valueOf(z16), str, arrayList);
                    return;
                }
                if (!TextUtils.isEmpty(TroopAddFrdsInnerFrame.this.F) && !TroopAddFrdsInnerFrame.this.F.equals(str)) {
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("TroopAddFrdsInnerFrame", 2, String.format("onAddBatchTroopFrd suc:%d troopUin:%s size:%d", Integer.valueOf(z16 ? 1 : 0), str, Integer.valueOf(arrayList.size())));
                }
                TroopAddFrdsInnerFrame.this.f285782h.runOnUiThread(new Runnable(arrayList) { // from class: com.tencent.mobileqq.selectmember.TroopAddFrdsInnerFrame.2.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ ArrayList f285827d;

                    {
                        this.f285827d = arrayList;
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) arrayList);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                            return;
                        }
                        ISelectMemberRefatorHelperApi iSelectMemberRefatorHelperApi = (ISelectMemberRefatorHelperApi) QRoute.api(ISelectMemberRefatorHelperApi.class);
                        TroopAddFrdsInnerFrame troopAddFrdsInnerFrame = TroopAddFrdsInnerFrame.this;
                        iSelectMemberRefatorHelperApi.showResultForBatchAddFriendData(troopAddFrdsInnerFrame.f285784m, troopAddFrdsInnerFrame.f285782h, troopAddFrdsInnerFrame.F, this.f285827d);
                    }
                });
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    arrayList2.add(Long.toString(arrayList.get(i3).uint64_uin.get()));
                }
                if (arrayList2.size() > 0) {
                    Message obtainMessage = TroopAddFrdsInnerFrame.this.f285821k0.obtainMessage(9);
                    obtainMessage.obj = arrayList2;
                    obtainMessage.sendToTarget();
                }
            }

            protected void b(String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, (Object) str);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("TroopAddFrdsInnerFrame", 2, String.format("onAddFriend %s", str));
                }
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(str);
                Message obtainMessage = TroopAddFrdsInnerFrame.this.f285821k0.obtainMessage(9);
                obtainMessage.obj = arrayList;
                obtainMessage.sendToTarget();
            }

            @Override // com.tencent.mobileqq.app.BusinessObserver
            public void onUpdate(int i3, boolean z16, Object obj) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
                    return;
                }
                if (i3 == 107) {
                    Object[] objArr = (Object[]) obj;
                    a(z16, (String) objArr[0], (ArrayList) objArr[1]);
                } else if (i3 == 59 && z16 && obj != null && (obj instanceof String)) {
                    b((String) obj);
                }
            }
        };
        this.f285825o0 = new b();
    }

    public TroopAddFrdsInnerFrame(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.D = 0;
        this.E = "";
        this.R = Collections.synchronizedMap(new LinkedHashMap());
        this.S = new int[0];
        this.T = new String[0];
        this.U = 0;
        this.V = 0;
        this.W = false;
        this.f285814d0 = 0.0d;
        this.f285815e0 = 0;
        this.f285818h0 = false;
        this.f285819i0 = f285808r0;
        this.f285820j0 = new HashSet();
        this.f285823m0 = new a();
        this.f285824n0 = new com.tencent.mobileqq.friend.observer.b() { // from class: com.tencent.mobileqq.selectmember.TroopAddFrdsInnerFrame.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopAddFrdsInnerFrame.this);
                }
            }

            public void a(boolean z16, String str, ArrayList arrayList) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, this, Boolean.valueOf(z16), str, arrayList);
                    return;
                }
                if (!TextUtils.isEmpty(TroopAddFrdsInnerFrame.this.F) && !TroopAddFrdsInnerFrame.this.F.equals(str)) {
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("TroopAddFrdsInnerFrame", 2, String.format("onAddBatchTroopFrd suc:%d troopUin:%s size:%d", Integer.valueOf(z16 ? 1 : 0), str, Integer.valueOf(arrayList.size())));
                }
                TroopAddFrdsInnerFrame.this.f285782h.runOnUiThread(new Runnable(arrayList) { // from class: com.tencent.mobileqq.selectmember.TroopAddFrdsInnerFrame.2.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ ArrayList f285827d;

                    {
                        this.f285827d = arrayList;
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) arrayList);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                            return;
                        }
                        ISelectMemberRefatorHelperApi iSelectMemberRefatorHelperApi = (ISelectMemberRefatorHelperApi) QRoute.api(ISelectMemberRefatorHelperApi.class);
                        TroopAddFrdsInnerFrame troopAddFrdsInnerFrame = TroopAddFrdsInnerFrame.this;
                        iSelectMemberRefatorHelperApi.showResultForBatchAddFriendData(troopAddFrdsInnerFrame.f285784m, troopAddFrdsInnerFrame.f285782h, troopAddFrdsInnerFrame.F, this.f285827d);
                    }
                });
                ArrayList arrayList2 = new ArrayList();
                for (int i36 = 0; i36 < arrayList.size(); i36++) {
                    arrayList2.add(Long.toString(arrayList.get(i36).uint64_uin.get()));
                }
                if (arrayList2.size() > 0) {
                    Message obtainMessage = TroopAddFrdsInnerFrame.this.f285821k0.obtainMessage(9);
                    obtainMessage.obj = arrayList2;
                    obtainMessage.sendToTarget();
                }
            }

            protected void b(String str) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, (Object) str);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("TroopAddFrdsInnerFrame", 2, String.format("onAddFriend %s", str));
                }
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(str);
                Message obtainMessage = TroopAddFrdsInnerFrame.this.f285821k0.obtainMessage(9);
                obtainMessage.obj = arrayList;
                obtainMessage.sendToTarget();
            }

            @Override // com.tencent.mobileqq.app.BusinessObserver
            public void onUpdate(int i36, boolean z16, Object obj) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i36), Boolean.valueOf(z16), obj);
                    return;
                }
                if (i36 == 107) {
                    Object[] objArr = (Object[]) obj;
                    a(z16, (String) objArr[0], (ArrayList) objArr[1]);
                } else if (i36 == 59 && z16 && obj != null && (obj instanceof String)) {
                    b((String) obj);
                }
            }
        };
        this.f285825o0 = new b();
    }
}
