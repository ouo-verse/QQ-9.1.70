package com.tencent.mobileqq.selectmember;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.dpc.DeviceProfileManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.search.api.ISearchViewCreator;
import com.tencent.mobileqq.search.k;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.ITroopRobotApi;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.data.aa;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.al;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.widget.AbsListView;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TroopMemberListInnerFrame extends SelectMemberInnerFrame implements View.OnClickListener, IndexView.b, PinnedDividerListView.b, CompoundButton.OnCheckedChangeListener {
    static IPatchRedirector $redirector_;

    /* renamed from: l0, reason: collision with root package name */
    protected static double f285890l0;

    /* renamed from: m0, reason: collision with root package name */
    private static int f285891m0;
    int D;
    String E;
    String F;
    private String G;
    private TroopInfo H;
    PinnedDividerListView I;
    private IndexView J;
    h K;
    TextView L;
    RelativeLayout M;
    CheckBox N;
    boolean P;
    TroopMemberInfo Q;
    List<TroopMemberInfo> R;
    Map<String, List<TroopMemberInfo>> S;
    int[] T;
    String[] U;
    boolean V;
    int W;

    /* renamed from: a0, reason: collision with root package name */
    protected TextView f285892a0;

    /* renamed from: b0, reason: collision with root package name */
    protected TextView f285893b0;

    /* renamed from: c0, reason: collision with root package name */
    protected RelativeLayout f285894c0;

    /* renamed from: d0, reason: collision with root package name */
    protected ProgressBar f285895d0;

    /* renamed from: e0, reason: collision with root package name */
    protected TextView f285896e0;

    /* renamed from: f0, reason: collision with root package name */
    protected double f285897f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f285898g0;

    /* renamed from: h0, reason: collision with root package name */
    Handler f285899h0;

    /* renamed from: i0, reason: collision with root package name */
    long f285900i0;

    /* renamed from: j0, reason: collision with root package name */
    private com.tencent.mobileqq.troop.onlinemember.api.b f285901j0;

    /* renamed from: k0, reason: collision with root package name */
    private AbsListView.OnScrollListener f285902k0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ViewGroup f285912d;

        a(ViewGroup viewGroup) {
            this.f285912d = viewGroup;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberListInnerFrame.this, (Object) viewGroup);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            TroopMemberListInnerFrame.this.f285892a0.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            this.f285912d.removeView(TroopMemberListInnerFrame.this.f285892a0);
            TroopMemberListInnerFrame troopMemberListInnerFrame = TroopMemberListInnerFrame.this;
            Bitmap D = troopMemberListInnerFrame.D(troopMemberListInnerFrame.f285892a0);
            if (D == null) {
                return;
            }
            TroopMemberListInnerFrame.this.f285892a0.setTag(D);
            h hVar = TroopMemberListInnerFrame.this.K;
            if (hVar != null) {
                hVar.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ViewGroup f285914d;

        b(ViewGroup viewGroup) {
            this.f285914d = viewGroup;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberListInnerFrame.this, (Object) viewGroup);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            TroopMemberListInnerFrame.this.f285893b0.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            this.f285914d.removeView(TroopMemberListInnerFrame.this.f285893b0);
            TroopMemberListInnerFrame troopMemberListInnerFrame = TroopMemberListInnerFrame.this;
            Bitmap D = troopMemberListInnerFrame.D(troopMemberListInnerFrame.f285893b0);
            if (D == null) {
                return;
            }
            TroopMemberListInnerFrame.this.f285893b0.setTag(D);
            h hVar = TroopMemberListInnerFrame.this.K;
            if (hVar != null) {
                hVar.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements com.tencent.qqnt.troopmemberlist.f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f285916a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f285917b;

        c(boolean z16, String str) {
            this.f285916a = z16;
            this.f285917b = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopMemberListInnerFrame.this, Boolean.valueOf(z16), str);
            }
        }

        @Override // com.tencent.qqnt.troopmemberlist.f
        public void a(boolean z16, @NonNull List<? extends TroopMemberInfo> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), list);
            } else if (this.f285916a) {
                TroopMemberListInnerFrame.this.L(new ArrayList(list));
            } else {
                TroopMemberListInnerFrame.this.N(this.f285917b, new ArrayList(list));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberListInnerFrame.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (i3 == 1) {
                CheckBox checkBox = TroopMemberListInnerFrame.this.N;
                checkBox.setChecked(true ^ checkBox.isChecked());
                TroopMemberListInnerFrame troopMemberListInnerFrame = TroopMemberListInnerFrame.this;
                CheckBox checkBox2 = troopMemberListInnerFrame.N;
                troopMemberListInnerFrame.onCheckedChanged(checkBox2, checkBox2.isChecked());
                if (TroopMemberListInnerFrame.this.f285782h.mEntrance == 32) {
                    IQWalletApi iQWalletApi = (IQWalletApi) QRoute.api(IQWalletApi.class);
                    if (TroopMemberListInnerFrame.this.N.isChecked()) {
                        str = "friendsfinder.all.confirm";
                    } else {
                        str = "friendsfinder.all.cancel";
                    }
                    iQWalletApi.reportTenpay(0, str);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class e extends com.tencent.mobileqq.troop.onlinemember.api.b {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberListInnerFrame.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.onlinemember.api.b
        protected void c(boolean z16, String str, List<String> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, list);
                return;
            }
            if (TextUtils.equals(str, TroopMemberListInnerFrame.this.F)) {
                SelectMemberActivity selectMemberActivity = TroopMemberListInnerFrame.this.f285782h;
                if ((selectMemberActivity == null || !selectMemberActivity.isFinishing()) && ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).isGameClockBusiness(TroopMemberListInnerFrame.this.f285782h)) {
                    ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).onOnlineRsp(TroopMemberListInnerFrame.this.f285784m, list);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class f implements AbsListView.OnScrollListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberListInnerFrame.this);
            }
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) absListView, i3);
                return;
            }
            if (i3 == 0 && ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).isGameClockBusiness(TroopMemberListInnerFrame.this.f285782h) && ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).isNeedReqGameInfo(TroopMemberListInnerFrame.this.f285782h)) {
                ITroopUtilApi iTroopUtilApi = (ITroopUtilApi) QRoute.api(ITroopUtilApi.class);
                TroopMemberListInnerFrame troopMemberListInnerFrame = TroopMemberListInnerFrame.this;
                iTroopUtilApi.reqGameInfoWhenIdle(troopMemberListInnerFrame.f285784m, troopMemberListInnerFrame.I, troopMemberListInnerFrame.f285782h);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class g implements Comparator<TroopMemberInfo> {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberListInnerFrame.this);
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(TroopMemberInfo troopMemberInfo, TroopMemberInfo troopMemberInfo2) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopMemberInfo, (Object) troopMemberInfo2)).intValue();
            }
            if (troopMemberInfo != null && (str = troopMemberInfo.displayedNamePinyinFirst) != null && troopMemberInfo2 != null) {
                return str.compareToIgnoreCase(troopMemberInfo2.displayedNamePinyinFirst);
            }
            return 0;
        }

        /* synthetic */ g(TroopMemberListInnerFrame troopMemberListInnerFrame, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopMemberListInnerFrame, (Object) anonymousClass1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class h extends com.tencent.mobileqq.adapter.e {
        static IPatchRedirector $redirector_;

        public h() {
            super(TroopMemberListInnerFrame.this.f285782h, TroopMemberListInnerFrame.this.f285784m, TroopMemberListInnerFrame.this.I, true);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberListInnerFrame.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public void configDividerView(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) view, i3);
            } else {
                Arrays.binarySearch(TroopMemberListInnerFrame.this.T, i3);
            }
        }

        public int g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
            }
            Iterator<String> it = TroopMemberListInnerFrame.this.S.keySet().iterator();
            int i3 = 0;
            while (it.hasNext()) {
                i3 += TroopMemberListInnerFrame.this.S.get(it.next()).size();
            }
            return i3;
        }

        @Override // com.tencent.mobileqq.adapter.e, android.widget.Adapter
        public int getCount() {
            Map<String, List<TroopMemberInfo>> map;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            TroopMemberListInnerFrame troopMemberListInnerFrame = TroopMemberListInnerFrame.this;
            int[] iArr = troopMemberListInnerFrame.T;
            if (iArr == null || (map = troopMemberListInnerFrame.S) == null || iArr.length == 0) {
                return 0;
            }
            return iArr[iArr.length - 1] + map.get(troopMemberListInnerFrame.U[r0.length - 1]).size() + 1;
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public int getDividerLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            if (TroopMemberListInnerFrame.this.U.length > 0) {
                return R.layout.f168254qf;
            }
            return 0;
        }

        @Override // com.tencent.mobileqq.adapter.e, android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            int binarySearch = Arrays.binarySearch(TroopMemberListInnerFrame.this.T, i3);
            if (binarySearch >= 0) {
                return null;
            }
            int i16 = (-(binarySearch + 1)) - 1;
            TroopMemberListInnerFrame troopMemberListInnerFrame = TroopMemberListInnerFrame.this;
            return troopMemberListInnerFrame.S.get(troopMemberListInnerFrame.U[i16]).get((i3 - TroopMemberListInnerFrame.this.T[i16]) - 1);
        }

        @Override // com.tencent.mobileqq.adapter.e, android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
            }
            return 0L;
        }

        @Override // com.tencent.mobileqq.adapter.e, android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            View view3;
            SpannableString spannableString;
            SpannableString spannableString2;
            TextView textView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                view3 = view;
                view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
            } else {
                int binarySearch = Arrays.binarySearch(TroopMemberListInnerFrame.this.T, i3);
                AnonymousClass1 anonymousClass1 = null;
                if (view == null) {
                    view2 = TroopMemberListInnerFrame.this.C.inflate(R.layout.byd, viewGroup, false);
                    i iVar = new i(TroopMemberListInnerFrame.this, anonymousClass1);
                    view2.setTag(iVar);
                    iVar.f297804i = (RelativeLayout) view2.findViewById(R.id.icx);
                    iVar.f297805m = (TextView) view2.findViewById(R.id.k8u);
                    iVar.E = (CheckBox) view2.findViewById(R.id.axa);
                    iVar.f187212f = (ImageView) view2.findViewById(R.id.icon);
                    iVar.C = (TextView) view2.findViewById(R.id.f5e);
                    iVar.D = view2.findViewById(R.id.kab);
                    iVar.F = (TextView) view2.findViewById(R.id.k9z);
                    iVar.G = (ImageView) view2.findViewById(R.id.f111666lu);
                    iVar.H = (TextView) view2.findViewById(R.id.k_1);
                } else {
                    view2 = view;
                }
                i iVar2 = (i) view2.getTag();
                if (binarySearch < 0) {
                    int i16 = (-(binarySearch + 1)) - 1;
                    TroopMemberListInnerFrame troopMemberListInnerFrame = TroopMemberListInnerFrame.this;
                    TroopMemberInfo troopMemberInfo = troopMemberListInnerFrame.S.get(troopMemberListInnerFrame.U[i16]).get((i3 - TroopMemberListInnerFrame.this.T[i16]) - 1);
                    if (TroopMemberListInnerFrame.this.f285782h.isResultListContainFriend(troopMemberInfo.memberuin)) {
                        iVar2.E.setChecked(true);
                    } else {
                        iVar2.E.setChecked(false);
                    }
                    iVar2.f297804i.setVisibility(0);
                    iVar2.f297805m.setVisibility(8);
                    iVar2.f187212f.setImageBitmap(b(troopMemberInfo.memberuin));
                    String showName = troopMemberInfo.nickInfo.getShowName();
                    TroopMemberListInnerFrame troopMemberListInnerFrame2 = TroopMemberListInnerFrame.this;
                    if (troopMemberListInnerFrame2.f285782h.mEntrance == 21) {
                        if (troopMemberListInnerFrame2.H != null && TroopMemberListInnerFrame.this.H.isTroopOwner(troopMemberInfo.memberuin) && (textView = TroopMemberListInnerFrame.this.f285893b0) != null && textView.getTag() != null) {
                            spannableString2 = new SpannableString("[tag] " + showName);
                            TroopMemberListInnerFrame troopMemberListInnerFrame3 = TroopMemberListInnerFrame.this;
                            spannableString2.setSpan(new ImageSpan(troopMemberListInnerFrame3.f285782h, (Bitmap) troopMemberListInnerFrame3.f285893b0.getTag()), 0, 5, 18);
                        } else {
                            TextView textView2 = TroopMemberListInnerFrame.this.f285892a0;
                            if (textView2 != null && textView2.getTag() != null) {
                                spannableString2 = new SpannableString("[tag] " + showName);
                                TroopMemberListInnerFrame troopMemberListInnerFrame4 = TroopMemberListInnerFrame.this;
                                spannableString2.setSpan(new ImageSpan(troopMemberListInnerFrame4.f285782h, (Bitmap) troopMemberListInnerFrame4.f285892a0.getTag()), 0, 5, 18);
                            } else {
                                spannableString = null;
                                iVar2.C.setText(spannableString);
                            }
                        }
                        spannableString = spannableString2;
                        iVar2.C.setText(spannableString);
                    } else {
                        iVar2.C.setText(troopMemberInfo.nickInfo.getShowName());
                    }
                    iVar2.I = troopMemberInfo;
                    String str = troopMemberInfo.memberuin;
                    iVar2.f187210d = str;
                    if (iVar2.D != null) {
                        if (com.tencent.mobileqq.selectmember.util.a.n(TroopMemberListInnerFrame.this.f285784m, str)) {
                            iVar2.D.setVisibility(0);
                        } else {
                            iVar2.D.setVisibility(8);
                        }
                    }
                    ArrayList<String> arrayList = TroopMemberListInnerFrame.this.f285782h.mUinsSelectedDefault;
                    if (arrayList != null && arrayList.contains(troopMemberInfo.memberuin)) {
                        iVar2.E.setEnabled(false);
                        iVar2.E.setChecked(true);
                    } else {
                        iVar2.E.setEnabled(true);
                    }
                    if (AppSetting.f99565y && iVar2.E.isEnabled()) {
                        if (iVar2.E.isChecked()) {
                            view2.setContentDescription(showName + HardCodeUtil.qqStr(R.string.ukm));
                        } else {
                            view2.setContentDescription(showName + HardCodeUtil.qqStr(R.string.ul_));
                        }
                    } else if (TroopMemberListInnerFrame.this.f285782h.mEntrance == 14 && !iVar2.E.isEnabled()) {
                        view2.setContentDescription(showName + HardCodeUtil.qqStr(R.string.ukz));
                    }
                    view2.setOnClickListener(TroopMemberListInnerFrame.this);
                    if (((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).isGameClockBusiness(TroopMemberListInnerFrame.this.f285782h)) {
                        ITroopUtilApi iTroopUtilApi = (ITroopUtilApi) QRoute.api(ITroopUtilApi.class);
                        TroopMemberListInnerFrame troopMemberListInnerFrame5 = TroopMemberListInnerFrame.this;
                        iTroopUtilApi.updateGameView(troopMemberListInnerFrame5.f285784m, troopMemberListInnerFrame5.f285782h, troopMemberInfo, iVar2.F, iVar2.G, iVar2.H);
                    }
                } else {
                    iVar2.f297804i.setVisibility(8);
                    iVar2.f297805m.setVisibility(0);
                    String valueOf = String.valueOf(TroopMemberListInnerFrame.this.U[binarySearch]);
                    iVar2.f297805m.setText(valueOf);
                    iVar2.f297805m.setContentDescription(String.format(TroopMemberListInnerFrame.this.f285782h.getString(R.string.aud), valueOf.toLowerCase()));
                }
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }

        public int h(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str)).intValue();
            }
            if (TroopMemberListInnerFrame.this.U != null) {
                int i3 = 0;
                while (true) {
                    String[] strArr = TroopMemberListInnerFrame.this.U;
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
                    return TroopMemberListInnerFrame.this.T[i3];
                }
            }
            return -1;
        }

        @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
        public boolean isDividerView(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, i3)).booleanValue();
            }
            if (Arrays.binarySearch(TroopMemberListInnerFrame.this.T, i3) >= 0) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private class i extends com.tencent.mobileqq.troop.memberlist.b {
        static IPatchRedirector $redirector_;
        public CheckBox E;
        public TextView F;
        public ImageView G;
        public TextView H;
        public TroopMemberInfo I;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopMemberListInnerFrame.this);
        }

        /* synthetic */ i(TroopMemberListInnerFrame troopMemberListInnerFrame, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopMemberListInnerFrame, (Object) anonymousClass1);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33366);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            f285890l0 = 10.0d;
            f285891m0 = 1000;
        }
    }

    public TroopMemberListInnerFrame(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.D = 0;
        this.E = "";
        this.R = new ArrayList();
        this.S = Collections.synchronizedMap(new LinkedHashMap());
        this.T = new int[0];
        this.U = new String[0];
        this.V = false;
        this.W = 1;
        this.f285892a0 = null;
        this.f285893b0 = null;
        this.f285897f0 = 0.0d;
        this.f285898g0 = 0;
        this.f285899h0 = new Handler() { // from class: com.tencent.mobileqq.selectmember.TroopMemberListInnerFrame.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopMemberListInnerFrame.this);
                }
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) message);
                    return;
                }
                int i3 = message.what;
                if (i3 == 1 || i3 == 2) {
                    TroopMemberListInnerFrame.this.O(message);
                    return;
                }
                if (i3 == 3) {
                    TroopMemberListInnerFrame.this.f285898g0 = message.arg1;
                    TroopMemberListInnerFrame.this.f285899h0.removeMessages(4);
                    Object obj = message.obj;
                    if (obj instanceof Object[]) {
                        Object[] objArr = (Object[]) obj;
                        if (objArr.length > 0) {
                            String str = (String) objArr[1];
                            if (!str.equals(TroopMemberListInnerFrame.this.F)) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("TroopMemberListInnerFrame.thread", 2, "handleMessage, troopUin != mTroopUin, break:" + str + "," + TroopMemberListInnerFrame.this.F);
                                    return;
                                }
                                return;
                            }
                            TroopMemberListInnerFrame.this.S = (Map) objArr[0];
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopMemberListInnerFrame.thread", 2, "handleMessage, mIndexedFriends.size=" + TroopMemberListInnerFrame.this.S.size());
                    }
                    if (TroopMemberListInnerFrame.this.f285782h.isInviteMemberFromTroopSetting() && TroopMemberListInnerFrame.this.K()) {
                        ArrayList<String> G = TroopMemberListInnerFrame.this.G();
                        if (!G.isEmpty()) {
                            ((ITroopRobotApi) QRoute.api(ITroopRobotApi.class)).fetchRobotInfo(G, new Runnable(message) { // from class: com.tencent.mobileqq.selectmember.TroopMemberListInnerFrame.1.1
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ Message f285904d;

                                {
                                    this.f285904d = message;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) message);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                        TroopMemberListInnerFrame.this.M(this.f285904d);
                                    } else {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                    }
                                }
                            });
                            return;
                        }
                    }
                    TroopMemberListInnerFrame.this.M(message);
                    return;
                }
                if (i3 == 4) {
                    TroopMemberListInnerFrame troopMemberListInnerFrame = TroopMemberListInnerFrame.this;
                    double d16 = troopMemberListInnerFrame.f285897f0 + TroopMemberListInnerFrame.f285890l0;
                    troopMemberListInnerFrame.f285897f0 = d16;
                    if (d16 < 90.0d && troopMemberListInnerFrame.D > 0) {
                        if (troopMemberListInnerFrame.f285894c0.getVisibility() == 8) {
                            TroopMemberListInnerFrame.this.f285894c0.setVisibility(0);
                        }
                        TroopMemberListInnerFrame troopMemberListInnerFrame2 = TroopMemberListInnerFrame.this;
                        troopMemberListInnerFrame2.f285895d0.setProgress((int) troopMemberListInnerFrame2.f285897f0);
                        TextView textView = TroopMemberListInnerFrame.this.f285896e0;
                        String qqStr = HardCodeUtil.qqStr(R.string.ume);
                        TroopMemberListInnerFrame troopMemberListInnerFrame3 = TroopMemberListInnerFrame.this;
                        int i16 = troopMemberListInnerFrame3.D;
                        textView.setText(String.format(qqStr, Integer.valueOf(Math.min((int) ((i16 * troopMemberListInnerFrame3.f285897f0) / 100.0d), i16)), Integer.valueOf(TroopMemberListInnerFrame.this.D)));
                        Handler handler = TroopMemberListInnerFrame.this.f285899h0;
                        handler.sendMessageDelayed(handler.obtainMessage(4), 800L);
                    }
                }
            }
        };
        this.f285900i0 = 0L;
        this.f285901j0 = new e();
        this.f285902k0 = new f();
    }

    private boolean A() {
        int height = e().getWindow().getDecorView().getHeight();
        Rect rect = new Rect();
        e().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        if (rect.bottom - rect.top <= (height * 2) / 3) {
            return true;
        }
        return false;
    }

    private void B(String str, boolean z16) {
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberList(str, this.f285782h, z16, "TroopMemberListInnerFrame", new c(z16, str));
    }

    private int C(Map<String, List<TroopMemberInfo>> map) {
        ITroopRobotService iTroopRobotService = (ITroopRobotService) this.f285784m.getRuntimeService(ITroopRobotService.class, "all");
        boolean z16 = !K();
        SelectMemberActivity selectMemberActivity = this.f285782h;
        int i3 = selectMemberActivity.mEntrance;
        if (i3 == 11 || i3 == 35 || i3 == 36 || selectMemberActivity.mFilterRobot) {
            z16 = true;
        }
        int i16 = 0;
        for (List<TroopMemberInfo> list : map.values()) {
            int i17 = 0;
            while (i17 < list.size()) {
                TroopMemberInfo troopMemberInfo = list.get(i17);
                if (troopMemberInfo == null) {
                    list.remove(i17);
                } else {
                    String str = troopMemberInfo.memberuin;
                    if (com.tencent.mobileqq.selectmember.util.a.m(this.f285784m, str)) {
                        list.remove(i17);
                    } else if (z16 && iTroopRobotService.isRobotUin(str)) {
                        list.remove(i17);
                    } else {
                        if (iTroopRobotService.isRobotUin(str) && this.f285782h.isInviteMemberFromTroopSetting() && !this.f285782h.mUinsSelectedDefault.contains(str) && !((ITroopRobotApi) QRoute.api(ITroopRobotApi.class)).canInviteToTroop(this.f285782h.mGroupCode, str)) {
                            list.remove(i17);
                        }
                        i17++;
                    }
                }
                i17--;
                i17++;
            }
            i16 += list.size();
        }
        HashMap hashMap = new HashMap();
        for (String str2 : map.keySet()) {
            if (map.get(str2).size() == 0) {
                hashMap.put(str2, 1);
            }
        }
        Iterator it = hashMap.keySet().iterator();
        while (it.hasNext()) {
            map.remove((String) it.next());
        }
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap D(View view) {
        try {
            int width = view.getWidth();
            int height = view.getHeight();
            if (width == 0 || height == 0) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            try {
                view.draw(new Canvas(createBitmap));
            } catch (OutOfMemoryError unused) {
            }
            return createBitmap;
        } catch (Exception | OutOfMemoryError unused2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<String> G() {
        ArrayList<String> arrayList = new ArrayList<>();
        ITroopRobotService iTroopRobotService = (ITroopRobotService) this.f285784m.getRuntimeService(ITroopRobotService.class, "all");
        for (List<TroopMemberInfo> list : this.S.values()) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                TroopMemberInfo troopMemberInfo = list.get(i3);
                if (troopMemberInfo != null) {
                    String str = troopMemberInfo.memberuin;
                    if (iTroopRobotService.isRobotUin(str) && !this.f285782h.mUinsSelectedDefault.contains(str)) {
                        arrayList.add(troopMemberInfo.memberUid);
                    }
                }
            }
        }
        return arrayList;
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
                if (QLog.isColorLevel()) {
                    QLog.d("TroopMemberListInnerFrame", 2, "get troop members from server, troopUin: " + str + " troopCode: " + str2);
                }
                B(str, true);
            }
        }
    }

    private void I() {
        long j3 = this.f285782h.getSharedPreferences(DeviceProfileManager.KEY_LAST_UPDATE_TIME + this.f285784m.getCurrentAccountUin(), 4).getLong("key_last_update_time" + this.F, 0L);
        long currentTimeMillis = System.currentTimeMillis();
        long abs = Math.abs(currentTimeMillis - j3);
        if (QLog.isColorLevel()) {
            QLog.d("TroopMemberListInnerFrame", 2, "getTroopMembers, lastUpdateTime=" + j3 + ", curTime=" + currentTimeMillis + ", diff=" + abs + ", " + hashCode());
        }
        TroopInfo c16 = com.tencent.mobileqq.selectmember.util.a.c(this.f285784m, this.F);
        this.H = c16;
        if (this.f285782h.mEntrance != 21 && c16 != null) {
            int i3 = c16.wMemberNum - 1;
            this.D = i3;
            if (i3 > 0) {
                this.f285897f0 = 0.0d;
                Handler handler = this.f285899h0;
                handler.sendMessage(handler.obtainMessage(4));
            }
        }
        if (j3 != 0 && (j3 <= 0 || abs <= MiniBoxNoticeInfo.MIN_5)) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopMemberListInnerFrame", 2, "read troop members from database before updating data from server");
            }
            B(this.F, false);
            return;
        }
        H(this.F);
    }

    private void J() {
        this.I = (PinnedDividerListView) findViewById(R.id.atu);
        IndexView indexView = (IndexView) findViewById(R.id.djh);
        this.J = indexView;
        indexView.setIndex(new String[]{ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", BdhLogUtil.LogTag.Tag_Conn, "D", "E", UserInfo.SEX_FEMALE, "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, ExifInterface.LATITUDE_SOUTH, "T", "U", "V", "W", "X", "Y", "Z", "#"});
        this.J.setOnIndexChangedListener(this);
        this.I.setSelector(R.color.ajr);
        this.I.setOnLayoutListener(this);
        this.L = (TextView) findViewById(R.id.k9v);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.idl);
        this.M = relativeLayout;
        LinearLayout linearLayout = (LinearLayout) relativeLayout.findViewById(R.id.ee_);
        this.N = (CheckBox) findViewById(R.id.f164752as2);
        linearLayout.setOnClickListener(this);
        this.f285894c0 = (RelativeLayout) findViewById(R.id.jzs);
        this.f285895d0 = (ProgressBar) findViewById(R.id.d7z);
        this.f285896e0 = (TextView) findViewById(R.id.efr);
        SelectMemberActivity selectMemberActivity = this.f285782h;
        if (selectMemberActivity.mEntrance == 21) {
            ViewGroup viewGroup = (ViewGroup) selectMemberActivity.getWindow().getDecorView();
            this.f285892a0 = new TextView(this.f285782h);
            this.f285892a0.setLayoutParams(new LinearLayout.LayoutParams(-2, (int) al.a(this.f285782h, 17.0f)));
            int a16 = (int) al.a(this.f285782h, 4.0f);
            this.f285892a0.setPadding(a16, 0, a16, 0);
            this.f285892a0.setTextColor(getResources().getColor(R.color.skin_color_white));
            this.f285892a0.setTextSize(1, 12.0f);
            this.f285892a0.setText(HardCodeUtil.qqStr(R.string.ukl));
            aa.a c16 = aa.a().c(301, false, false, true);
            if (c16 != null) {
                aa.i(this.f285892a0, c16.f294889b);
            }
            this.f285892a0.setVisibility(4);
            viewGroup.addView(this.f285892a0);
            this.f285893b0 = new TextView(this.f285782h);
            this.f285893b0.setLayoutParams(new LinearLayout.LayoutParams(-2, (int) al.a(this.f285782h, 17.0f)));
            this.f285893b0.setPadding(a16, 0, a16, 0);
            this.f285893b0.setTextColor(getResources().getColor(R.color.skin_color_white));
            this.f285893b0.setTextSize(1, 12.0f);
            this.f285893b0.setText(HardCodeUtil.qqStr(R.string.uls));
            aa.a c17 = aa.a().c(300, false, true, false);
            if (c17 != null) {
                aa.i(this.f285893b0, c17.f294889b);
            }
            this.f285893b0.setVisibility(4);
            viewGroup.addView(this.f285893b0);
            this.f285892a0.getViewTreeObserver().addOnGlobalLayoutListener(new a(viewGroup));
            this.f285893b0.getViewTreeObserver().addOnGlobalLayoutListener(new b(viewGroup));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean K() {
        AppInterface appInterface = this.f285784m;
        boolean b16 = com.tencent.mobileqq.troop.util.a.b(appInterface, this.F, appInterface.getCurrentAccountUin());
        ITroopUtilsApi iTroopUtilsApi = (ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class);
        AppInterface appInterface2 = this.f285784m;
        if (!iTroopUtilsApi.isTroopAdmin(appInterface2, this.F, appInterface2.getCurrentAccountUin()) && !b16) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(ArrayList<TroopMemberInfo> arrayList) {
        int size;
        try {
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onFetchMemberListFormServer:");
                if (arrayList == null) {
                    size = 0;
                } else {
                    size = arrayList.size();
                }
                sb5.append(size);
                QLog.d("TroopMemberListInnerFrame", 2, sb5.toString());
            }
            this.f285782h.getSharedPreferences(DeviceProfileManager.KEY_LAST_UPDATE_TIME + this.f285784m.getCurrentAccountUin(), 4).edit().putLong("key_last_update_time" + this.F, System.currentTimeMillis()).commit();
            N(this.F, arrayList);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("TroopMemberListInnerFrame", 2, "onFetchMemberListFormServer:" + e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(Message message) {
        int i3 = this.f285782h.mSubType;
        if (i3 == 1 || i3 == 0 || i3 == 5) {
            this.f285782h.afterMemberFilter(C(this.S));
        }
        message.obj = P();
        O(message);
        if (!this.P && this.f285782h.mIsSelectAllMembers) {
            this.P = true;
            this.N.setChecked(!r4.isChecked());
            CheckBox checkBox = this.N;
            onCheckedChanged(checkBox, checkBox.isChecked());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(String str, List<TroopMemberInfo> list) {
        int i3;
        Map synchronizedMap = Collections.synchronizedMap(new LinkedHashMap());
        TroopInfo i16 = com.tencent.mobileqq.selectmember.util.a.i(this.f285784m, this.F);
        String currentAccountUin = this.f285784m.getCurrentAccountUin();
        if (list == null) {
            this.f285899h0.sendMessage(this.f285899h0.obtainMessage(3));
            return;
        }
        int size = list.size();
        this.D = size - 1;
        if (size > 0) {
            int i17 = f285891m0;
            int i18 = size / i17;
            boolean z16 = false;
            if (size % i17 == 0) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            AtomicInteger atomicInteger = new AtomicInteger(i18 + i3);
            if (QLog.isColorLevel()) {
                QLog.d("TroopMemberListInnerFrame.thread", 2, "parallel process mJobCount: " + atomicInteger.get());
            }
            int i19 = 0;
            while (i19 < size) {
                int i26 = i19;
                int i27 = i19;
                Map map = synchronizedMap;
                Map map2 = synchronizedMap;
                boolean z17 = z16;
                ThreadManagerV2.post(new Runnable(list, i26, Math.min((f285891m0 + i19) - 1, size), str, currentAccountUin, i16, map, atomicInteger) { // from class: com.tencent.mobileqq.selectmember.TroopMemberListInnerFrame.4
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Map C;
                    final /* synthetic */ AtomicInteger D;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ List f285906d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ int f285907e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ int f285908f;

                    /* renamed from: h, reason: collision with root package name */
                    final /* synthetic */ String f285909h;

                    /* renamed from: i, reason: collision with root package name */
                    final /* synthetic */ String f285910i;

                    /* renamed from: m, reason: collision with root package name */
                    final /* synthetic */ TroopInfo f285911m;

                    {
                        this.f285906d = list;
                        this.f285907e = i26;
                        this.f285908f = r8;
                        this.f285909h = str;
                        this.f285910i = currentAccountUin;
                        this.f285911m = i16;
                        this.C = map;
                        this.D = atomicInteger;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, TroopMemberListInnerFrame.this, list, Integer.valueOf(i26), Integer.valueOf(r8), str, currentAccountUin, i16, map, atomicInteger);
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
                        int i28 = 0;
                        for (TroopMemberInfo troopMemberInfo : this.f285906d.subList(this.f285907e, this.f285908f)) {
                            if (!this.f285909h.equals(TroopMemberListInnerFrame.this.F)) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("TroopMemberListInnerFrame.thread", 2, "subThread, curTroopUin != mTroopUin, return, " + this.f285909h + "," + TroopMemberListInnerFrame.this.F);
                                    return;
                                }
                                return;
                            }
                            SelectMemberActivity selectMemberActivity = TroopMemberListInnerFrame.this.f285782h;
                            if ((!selectMemberActivity.mShowMyself || selectMemberActivity.mIsPutMySelfFirst) && this.f285910i.equalsIgnoreCase(troopMemberInfo.memberuin)) {
                                TroopMemberListInnerFrame.this.Q = troopMemberInfo;
                            } else if (!TroopMemberListInnerFrame.this.f285782h.mUinsToHide.contains(troopMemberInfo.memberuin) && Utils.M(troopMemberInfo.memberuin)) {
                                TroopInfo troopInfo = this.f285911m;
                                if (troopInfo != null && TroopMemberListInnerFrame.this.W == 2 && !troopInfo.isTroopAdmin(troopMemberInfo.memberuin) && !this.f285911m.isTroopOwner(troopMemberInfo.memberuin)) {
                                    TroopMemberListInnerFrame.this.f285782h.mUinsToHide.add(troopMemberInfo.memberuin);
                                } else {
                                    String showNamePyFirst = troopMemberInfo.nickInfo.getUIInfo().getShowNamePyFirst();
                                    troopMemberInfo.displayedNamePinyinFirst = showNamePyFirst;
                                    if (showNamePyFirst != null && showNamePyFirst.length() != 0) {
                                        str2 = troopMemberInfo.displayedNamePinyinFirst.substring(0, 1);
                                    } else {
                                        str2 = "#";
                                    }
                                    char charAt = str2.charAt(0);
                                    if (('A' <= charAt && charAt <= 'Z') || ('a' <= charAt && charAt <= 'z')) {
                                        str3 = str2.toUpperCase();
                                    } else {
                                        str3 = "#";
                                    }
                                    synchronized (this.C) {
                                        if (this.C.get(str3) == null) {
                                            this.C.put(str3, new ArrayList());
                                        }
                                        ((List) this.C.get(str3)).add(troopMemberInfo);
                                        i28++;
                                    }
                                }
                            }
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("TroopMemberListInnerFrame.thread", 2, "subThread end, id=" + Thread.currentThread().getId() + ", threadCnt=" + this.D.get() + ", curTroopUin=" + this.f285909h);
                        }
                        if (this.D.getAndDecrement() <= 1) {
                            Message obtainMessage = TroopMemberListInnerFrame.this.f285899h0.obtainMessage(3);
                            obtainMessage.arg1 = i28;
                            obtainMessage.obj = new Object[]{this.C, this.f285909h};
                            TroopMemberListInnerFrame.this.f285899h0.sendMessage(obtainMessage);
                        }
                    }
                }, 8, null, z17);
                i19 = i27 + f285891m0;
                z16 = z17;
                currentAccountUin = currentAccountUin;
                synchronizedMap = map2;
            }
            return;
        }
        this.f285899h0.sendMessage(this.f285899h0.obtainMessage(3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(Message message) {
        Object[] objArr = (Object[]) message.obj;
        this.f285894c0.setVisibility(8);
        boolean z16 = true;
        if (objArr.length == 3) {
            this.S = (Map) objArr[0];
            this.T = (int[]) objArr[1];
            this.U = (String[]) objArr[2];
            this.L.setVisibility(8);
            if (((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).isGameClockBusiness(this.f285782h)) {
                ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).handleGameClockData(this.f285784m);
                ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).sortAndPreloadIfNeed(this.f285784m, ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).getQQGameTroopManager_TASK_NAME_MEMBER_StringValue());
            }
        } else {
            this.S = Collections.synchronizedMap(new LinkedHashMap());
            this.T = new int[0];
            this.U = new String[0];
            this.L.setVisibility(0);
        }
        this.K.notifyDataSetChanged();
        SelectMemberActivity selectMemberActivity = this.f285782h;
        if (this.W != 2) {
            z16 = false;
        }
        selectMemberActivity.refreshGVideoTextView(z16, this.f285898g0);
    }

    private Object[] P() {
        Iterator<String> it = this.S.keySet().iterator();
        while (it.hasNext()) {
            Collections.sort(this.S.get(it.next()), new g(this, null));
        }
        Map<String, List<TroopMemberInfo>> map = this.S;
        this.S = Collections.synchronizedMap(new LinkedHashMap());
        SelectMemberActivity selectMemberActivity = this.f285782h;
        if (selectMemberActivity.mShowMyself && selectMemberActivity.mIsPutMySelfFirst && this.Q != null) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.Q);
            this.S.put(HardCodeUtil.qqStr(R.string.ulv), arrayList);
        }
        for (char c16 = EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET; c16 <= 'Z'; c16 = (char) (c16 + 1)) {
            if (map.get(String.valueOf(c16)) != null) {
                this.S.put(String.valueOf(c16), map.get(String.valueOf(c16)));
            }
        }
        if (map.get("#") != null) {
            this.S.put("#", map.get("#"));
        }
        map.clear();
        int size = this.S.keySet().size();
        int[] iArr = new int[size];
        String[] strArr = new String[this.S.keySet().size()];
        Iterator<String> it5 = this.S.keySet().iterator();
        if (size == 0) {
            return new Object[0];
        }
        iArr[0] = 0;
        for (int i3 = 1; i3 < size; i3++) {
            iArr[i3] = iArr[i3] + iArr[i3 - 1] + this.S.get(it5.next()).size() + 1;
        }
        Iterator<String> it6 = this.S.keySet().iterator();
        int i16 = 0;
        while (it6.hasNext()) {
            strArr[i16] = it6.next();
            i16++;
        }
        return new Object[]{this.S, iArr, strArr};
    }

    private void Q(String str, boolean z16) {
        RelativeLayout relativeLayout = this.M;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            boolean z17 = false;
            if (str == null || z16 || !this.N.isChecked()) {
                int count = this.K.getCount();
                int i3 = 0;
                while (true) {
                    if (i3 < count) {
                        TroopMemberInfo troopMemberInfo = (TroopMemberInfo) this.K.getItem(i3);
                        if (troopMemberInfo != null && !this.f285782h.isResultListContainFriend(troopMemberInfo.memberuin)) {
                            break;
                        } else {
                            i3++;
                        }
                    } else {
                        z17 = true;
                        break;
                    }
                }
            }
            this.N.setChecked(z17);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Map<String, List<TroopMemberInfo>> E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Map) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.S;
    }

    public com.tencent.mobileqq.adapter.e F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (com.tencent.mobileqq.adapter.e) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.K;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void R(Map<String, List<TroopMemberInfo>> map, int[] iArr, String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, map, iArr, strArr);
            return;
        }
        this.S = map;
        this.T = iArr;
        this.U = strArr;
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
        J();
        h hVar = new h();
        this.K = hVar;
        this.I.setAdapter((ListAdapter) hVar);
        this.I.setOnScrollListener(this.f285902k0);
    }

    @Override // com.tencent.common.app.InnerFrame
    public void m(Bundle bundle) {
        int i3;
        String str;
        TroopInfo c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle);
            return;
        }
        super.m(bundle);
        this.f285782h.mSelectedAndSearchBar.v();
        this.F = bundle.getString("group_uin");
        this.G = bundle.getString("group_name");
        this.W = bundle.getInt(ISelectMemberActivityConstants.PARAM_TROOP_MEMBER_SHOW_TYPE, 1);
        boolean z16 = bundle.getBoolean(ISelectMemberActivityConstants.PARAM_ENABLE_ALL_SELECT, false);
        RelativeLayout relativeLayout = this.M;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        relativeLayout.setVisibility(i3);
        String str2 = this.G;
        if ((str2 == null || str2.length() == 0) && (str = this.F) != null && str.length() > 0 && (c16 = com.tencent.mobileqq.selectmember.util.a.c(this.f285784m, this.F)) != null) {
            this.G = c16.getTroopDisplayName();
        }
        SelectMemberActivity selectMemberActivity = this.f285782h;
        if (selectMemberActivity.mOnlyTroopMember) {
            selectMemberActivity.setupTitleBar(false, "", this.G);
        } else {
            selectMemberActivity.setupTitleBar(true, "", this.G);
        }
        this.f285782h.addObserver(this.f285901j0);
        this.f285894c0.setVisibility(8);
        String str3 = this.F;
        if (str3 != null && str3.length() > 0) {
            if (!this.F.equals(this.E)) {
                this.S = Collections.synchronizedMap(new LinkedHashMap());
                this.T = new int[0];
                this.U = new String[0];
                this.K.notifyDataSetChanged();
                this.L.setVisibility(8);
                this.V = false;
                I();
                this.I.setSelection(0);
                this.E = this.F;
                if (((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).isGameClockBusiness(this.f285782h)) {
                    ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).initTaskSet(this.f285784m);
                    ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).doReqGameFriends(this.f285784m, this.F, this.f285782h);
                    ((com.tencent.mobileqq.troop.onlinemember.api.a) this.f285784m.getBusinessHandler(((ITroopHandlerNameApi) QRoute.api(ITroopHandlerNameApi.class)).getTroopOnlineMemberHandlerName())).i0(this.F);
                    return;
                }
                return;
            }
            this.V = true;
            this.K.notifyDataSetChanged();
        }
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberInnerFrame
    public com.tencent.mobileqq.search.view.f n(boolean z16, k kVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (com.tencent.mobileqq.search.view.f) iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), kVar);
        }
        if (this.f285782h.mEntrance != 21) {
            ISearchViewCreator iSearchViewCreator = (ISearchViewCreator) QRoute.api(ISearchViewCreator.class);
            String str = this.F;
            SelectMemberActivity selectMemberActivity = this.f285782h;
            return iSearchViewCreator.createContactSearchFragment(-1, 8192, str, selectMemberActivity.mUinsToHide, selectMemberActivity, z16, kVar);
        }
        ISearchViewCreator iSearchViewCreator2 = (ISearchViewCreator) QRoute.api(ISearchViewCreator.class);
        String str2 = this.F;
        SelectMemberActivity selectMemberActivity2 = this.f285782h;
        return iSearchViewCreator2.createContactSearchFragment(-1, 262144, str2, selectMemberActivity2.mUinsToHide, selectMemberActivity2, z16, kVar);
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberInnerFrame
    public String o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.F;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, compoundButton, Boolean.valueOf(z16));
        } else if (R.id.f164752as2 == compoundButton.getId()) {
            if (z16) {
                ArrayList arrayList = new ArrayList();
                int count = this.K.getCount();
                for (int i3 = 0; i3 < count; i3++) {
                    TroopMemberInfo troopMemberInfo = (TroopMemberInfo) this.K.getItem(i3);
                    if (troopMemberInfo != null) {
                        ResultRecord constructAResultRecord = SelectMemberActivity.constructAResultRecord(troopMemberInfo.memberuin, troopMemberInfo.nickInfo.getShowName(), 1, this.F);
                        constructAResultRecord.memberNickInfo = troopMemberInfo.nickInfo;
                        arrayList.add(constructAResultRecord);
                    }
                    if (this.f285782h.mEntrance == 31) {
                        ReportController.o(this.f285784m, "dc00898", "", "", "0X8007CFB", "0X8007CFB", 0, 0, "", "", "", "");
                    }
                }
                this.f285782h.addFriendResults(arrayList, false, true);
                if (this.f285782h.mEntrance == 35) {
                    ReportController.o(this.f285784m, "CliOper", "", "", "0X8009E2C", "0X8009E2C", 0, 0, "", "", "", "");
                }
            } else {
                this.f285782h.removeAllFriendResult();
                if (this.f285782h.mEntrance == 35) {
                    ReportController.o(this.f285784m, "CliOper", "", "", "0X8009E2D", "0X8009E2D", 0, 0, "", "", "", "");
                }
            }
            this.K.notifyDataSetChanged();
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        CheckBox checkBox;
        int i3;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view);
        } else if (R.id.ee_ != view.getId()) {
            i iVar = (i) view.getTag();
            if (iVar != null && (checkBox = iVar.E) != null && iVar.C != null && checkBox.isEnabled()) {
                boolean onTroopMemberItemClick = this.f285782h.onTroopMemberItemClick(iVar.f187210d, iVar.C.getText().toString(), 1, this.F, iVar.I.nickInfo);
                iVar.E.setChecked(onTroopMemberItemClick);
                Q(iVar.f187210d, onTroopMemberItemClick);
                if (AppSetting.f99565y) {
                    if (iVar.E.isChecked()) {
                        view.setContentDescription(iVar.C.getText().toString() + HardCodeUtil.qqStr(R.string.umn));
                    } else {
                        view.setContentDescription(iVar.C.getText().toString() + HardCodeUtil.qqStr(R.string.um8));
                    }
                    if (iVar.E.isChecked()) {
                        i3 = R.string.ulq;
                    } else {
                        i3 = R.string.ulb;
                    }
                    com.tencent.mobileqq.util.c.a(view, HardCodeUtil.qqStr(i3));
                }
            }
        } else {
            int i16 = this.f285782h.mEntrance;
            if ((i16 == 32 || i16 == 43) && !this.N.isChecked() && this.f285782h.mMaxSelectNumber < this.K.g()) {
                d dVar = new d();
                String format = MessageFormat.format(this.f285782h.getString(R.string.hdc), Integer.valueOf(this.f285782h.mMaxSelectNumber));
                SelectMemberActivity selectMemberActivity = this.f285782h;
                try {
                    DialogUtil.createCustomDialog(selectMemberActivity, 232, selectMemberActivity.getResources().getString(R.string.f173206i10), format, R.string.cancel, R.string.fjw, dVar, dVar).show();
                } catch (Throwable unused) {
                }
            } else {
                CheckBox checkBox2 = this.N;
                checkBox2.setChecked(true ^ checkBox2.isChecked());
                CheckBox checkBox3 = this.N;
                onCheckedChanged(checkBox3, checkBox3.isChecked());
                if (this.f285782h.mEntrance == 32) {
                    IQWalletApi iQWalletApi = (IQWalletApi) QRoute.api(IQWalletApi.class);
                    if (this.N.isChecked()) {
                        str = "friendsfinder.all.confirm";
                    } else {
                        str = "friendsfinder.all.cancel";
                    }
                    iQWalletApi.reportTenpay(0, str);
                }
            }
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
        h hVar = this.K;
        if (hVar != null) {
            hVar.destroy();
        }
        TextView textView = this.f285892a0;
        if (textView != null && textView.getTag() != null) {
            ((Bitmap) this.f285892a0.getTag()).recycle();
            this.f285892a0.setTag(null);
        }
        TextView textView2 = this.f285893b0;
        if (textView2 != null && textView2.getTag() != null) {
            ((Bitmap) this.f285893b0.getTag()).recycle();
            this.f285893b0.setTag(null);
        }
        if (((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).isGameClockBusiness(this.f285782h)) {
            ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).onDestroyForQQGameTroopManager(this.f285784m);
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.widget.IndexView.b
    public void onIndexChanged(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
            return;
        }
        if (((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).isGameClockBusiness(this.f285782h)) {
            return;
        }
        if ("$".equals(str)) {
            this.I.setSelection(0);
            return;
        }
        int h16 = this.K.h(str);
        if (h16 != -1) {
            PinnedDividerListView pinnedDividerListView = this.I;
            pinnedDividerListView.setSelection(h16 + pinnedDividerListView.getHeaderViewsCount());
        }
    }

    @Override // com.tencent.mobileqq.widget.PinnedDividerListView.b
    public void onLayout(View view, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        if ((this.I.getFirstVisiblePosition() > 0 || (this.I.getFirstVisiblePosition() == 0 && this.I.getChildCount() < this.K.getCount() + this.I.getHeaderViewsCount())) && !A() && !((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).isGameClockBusiness(this.f285782h)) {
            this.J.setVisibility(0);
        } else {
            this.J.setVisibility(4);
        }
    }

    @Override // com.tencent.common.app.InnerFrame
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onStop();
            this.f285782h.removeObserver(this.f285901j0);
        }
    }

    @Override // com.tencent.mobileqq.selectmember.SelectMemberInnerFrame
    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.K.notifyDataSetChanged();
            Q(null, false);
        }
    }

    public TroopMemberListInnerFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.D = 0;
        this.E = "";
        this.R = new ArrayList();
        this.S = Collections.synchronizedMap(new LinkedHashMap());
        this.T = new int[0];
        this.U = new String[0];
        this.V = false;
        this.W = 1;
        this.f285892a0 = null;
        this.f285893b0 = null;
        this.f285897f0 = 0.0d;
        this.f285898g0 = 0;
        this.f285899h0 = new Handler() { // from class: com.tencent.mobileqq.selectmember.TroopMemberListInnerFrame.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopMemberListInnerFrame.this);
                }
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) message);
                    return;
                }
                int i3 = message.what;
                if (i3 == 1 || i3 == 2) {
                    TroopMemberListInnerFrame.this.O(message);
                    return;
                }
                if (i3 == 3) {
                    TroopMemberListInnerFrame.this.f285898g0 = message.arg1;
                    TroopMemberListInnerFrame.this.f285899h0.removeMessages(4);
                    Object obj = message.obj;
                    if (obj instanceof Object[]) {
                        Object[] objArr = (Object[]) obj;
                        if (objArr.length > 0) {
                            String str = (String) objArr[1];
                            if (!str.equals(TroopMemberListInnerFrame.this.F)) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("TroopMemberListInnerFrame.thread", 2, "handleMessage, troopUin != mTroopUin, break:" + str + "," + TroopMemberListInnerFrame.this.F);
                                    return;
                                }
                                return;
                            }
                            TroopMemberListInnerFrame.this.S = (Map) objArr[0];
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopMemberListInnerFrame.thread", 2, "handleMessage, mIndexedFriends.size=" + TroopMemberListInnerFrame.this.S.size());
                    }
                    if (TroopMemberListInnerFrame.this.f285782h.isInviteMemberFromTroopSetting() && TroopMemberListInnerFrame.this.K()) {
                        ArrayList<String> G = TroopMemberListInnerFrame.this.G();
                        if (!G.isEmpty()) {
                            ((ITroopRobotApi) QRoute.api(ITroopRobotApi.class)).fetchRobotInfo(G, new Runnable(message) { // from class: com.tencent.mobileqq.selectmember.TroopMemberListInnerFrame.1.1
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ Message f285904d;

                                {
                                    this.f285904d = message;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) message);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                        TroopMemberListInnerFrame.this.M(this.f285904d);
                                    } else {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                    }
                                }
                            });
                            return;
                        }
                    }
                    TroopMemberListInnerFrame.this.M(message);
                    return;
                }
                if (i3 == 4) {
                    TroopMemberListInnerFrame troopMemberListInnerFrame = TroopMemberListInnerFrame.this;
                    double d16 = troopMemberListInnerFrame.f285897f0 + TroopMemberListInnerFrame.f285890l0;
                    troopMemberListInnerFrame.f285897f0 = d16;
                    if (d16 < 90.0d && troopMemberListInnerFrame.D > 0) {
                        if (troopMemberListInnerFrame.f285894c0.getVisibility() == 8) {
                            TroopMemberListInnerFrame.this.f285894c0.setVisibility(0);
                        }
                        TroopMemberListInnerFrame troopMemberListInnerFrame2 = TroopMemberListInnerFrame.this;
                        troopMemberListInnerFrame2.f285895d0.setProgress((int) troopMemberListInnerFrame2.f285897f0);
                        TextView textView = TroopMemberListInnerFrame.this.f285896e0;
                        String qqStr = HardCodeUtil.qqStr(R.string.ume);
                        TroopMemberListInnerFrame troopMemberListInnerFrame3 = TroopMemberListInnerFrame.this;
                        int i16 = troopMemberListInnerFrame3.D;
                        textView.setText(String.format(qqStr, Integer.valueOf(Math.min((int) ((i16 * troopMemberListInnerFrame3.f285897f0) / 100.0d), i16)), Integer.valueOf(TroopMemberListInnerFrame.this.D)));
                        Handler handler = TroopMemberListInnerFrame.this.f285899h0;
                        handler.sendMessageDelayed(handler.obtainMessage(4), 800L);
                    }
                }
            }
        };
        this.f285900i0 = 0L;
        this.f285901j0 = new e();
        this.f285902k0 = new f();
    }

    public TroopMemberListInnerFrame(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.D = 0;
        this.E = "";
        this.R = new ArrayList();
        this.S = Collections.synchronizedMap(new LinkedHashMap());
        this.T = new int[0];
        this.U = new String[0];
        this.V = false;
        this.W = 1;
        this.f285892a0 = null;
        this.f285893b0 = null;
        this.f285897f0 = 0.0d;
        this.f285898g0 = 0;
        this.f285899h0 = new Handler() { // from class: com.tencent.mobileqq.selectmember.TroopMemberListInnerFrame.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopMemberListInnerFrame.this);
                }
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) message);
                    return;
                }
                int i36 = message.what;
                if (i36 == 1 || i36 == 2) {
                    TroopMemberListInnerFrame.this.O(message);
                    return;
                }
                if (i36 == 3) {
                    TroopMemberListInnerFrame.this.f285898g0 = message.arg1;
                    TroopMemberListInnerFrame.this.f285899h0.removeMessages(4);
                    Object obj = message.obj;
                    if (obj instanceof Object[]) {
                        Object[] objArr = (Object[]) obj;
                        if (objArr.length > 0) {
                            String str = (String) objArr[1];
                            if (!str.equals(TroopMemberListInnerFrame.this.F)) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("TroopMemberListInnerFrame.thread", 2, "handleMessage, troopUin != mTroopUin, break:" + str + "," + TroopMemberListInnerFrame.this.F);
                                    return;
                                }
                                return;
                            }
                            TroopMemberListInnerFrame.this.S = (Map) objArr[0];
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopMemberListInnerFrame.thread", 2, "handleMessage, mIndexedFriends.size=" + TroopMemberListInnerFrame.this.S.size());
                    }
                    if (TroopMemberListInnerFrame.this.f285782h.isInviteMemberFromTroopSetting() && TroopMemberListInnerFrame.this.K()) {
                        ArrayList<String> G = TroopMemberListInnerFrame.this.G();
                        if (!G.isEmpty()) {
                            ((ITroopRobotApi) QRoute.api(ITroopRobotApi.class)).fetchRobotInfo(G, new Runnable(message) { // from class: com.tencent.mobileqq.selectmember.TroopMemberListInnerFrame.1.1
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ Message f285904d;

                                {
                                    this.f285904d = message;
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) message);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                        TroopMemberListInnerFrame.this.M(this.f285904d);
                                    } else {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                    }
                                }
                            });
                            return;
                        }
                    }
                    TroopMemberListInnerFrame.this.M(message);
                    return;
                }
                if (i36 == 4) {
                    TroopMemberListInnerFrame troopMemberListInnerFrame = TroopMemberListInnerFrame.this;
                    double d16 = troopMemberListInnerFrame.f285897f0 + TroopMemberListInnerFrame.f285890l0;
                    troopMemberListInnerFrame.f285897f0 = d16;
                    if (d16 < 90.0d && troopMemberListInnerFrame.D > 0) {
                        if (troopMemberListInnerFrame.f285894c0.getVisibility() == 8) {
                            TroopMemberListInnerFrame.this.f285894c0.setVisibility(0);
                        }
                        TroopMemberListInnerFrame troopMemberListInnerFrame2 = TroopMemberListInnerFrame.this;
                        troopMemberListInnerFrame2.f285895d0.setProgress((int) troopMemberListInnerFrame2.f285897f0);
                        TextView textView = TroopMemberListInnerFrame.this.f285896e0;
                        String qqStr = HardCodeUtil.qqStr(R.string.ume);
                        TroopMemberListInnerFrame troopMemberListInnerFrame3 = TroopMemberListInnerFrame.this;
                        int i16 = troopMemberListInnerFrame3.D;
                        textView.setText(String.format(qqStr, Integer.valueOf(Math.min((int) ((i16 * troopMemberListInnerFrame3.f285897f0) / 100.0d), i16)), Integer.valueOf(TroopMemberListInnerFrame.this.D)));
                        Handler handler = TroopMemberListInnerFrame.this.f285899h0;
                        handler.sendMessageDelayed(handler.obtainMessage(4), 800L);
                    }
                }
            }
        };
        this.f285900i0 = 0L;
        this.f285901j0 = new e();
        this.f285902k0 = new f();
    }
}
