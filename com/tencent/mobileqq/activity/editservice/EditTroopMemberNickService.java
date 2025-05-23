package com.tencent.mobileqq.activity.editservice;

import ColorNick.QC.GroupNickEmoji;
import ColorNick.QC.GroupNickItem;
import ColorNick.QC.readItemInfoRsp;
import QC.UniBusinessCheckItem;
import QC.UniCheckRsp;
import QQService.EVIPSPEC;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.editservice.EditTroopMemberNickService;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.data.VipTypeParam;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.ISmallEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.activity.TroopNickRuleFragment;
import com.tencent.mobileqq.troop.activity.g;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.widget.PresetWordFlowLayout;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.api.IVasKuiklyNestPageFrame;
import com.tencent.mobileqq.vas.api.IVasPageToggle;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.e;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.troopnick.shop.adapter.TroopNickNewRequest;
import com.tencent.mobileqq.vas.troopnick.shop.adapter.TroopNickRequest;
import com.tencent.mobileqq.vas.troopnick.shop.widget.ShopLayout;
import com.tencent.mobileqq.vas.troopnick.shop.widget.a;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.ColorClearableEditText;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.URLUtil;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc$CommCardNameBuf;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc$RichCardNameElem;

/* compiled from: P */
/* loaded from: classes10.dex */
public class EditTroopMemberNickService implements com.tencent.mobileqq.troop.activity.editinfo.b, EmoticonCallback, View.OnClickListener, Handler.Callback {
    static IPatchRedirector $redirector_;
    private static final boolean C0;
    private final com.tencent.mobileqq.apollo.handler.c A0;
    private final e.c B0;
    protected boolean C;
    TextView D;
    protected int E;
    protected String F;
    protected String G;
    protected int H;
    protected int I;
    String J;
    String K;
    int L;
    boolean M;
    protected com.tencent.mobileqq.troop.activity.g N;
    protected ArrayList<String> P;
    protected String Q;
    RelativeLayout R;
    TextView S;
    TextView T;
    ImageView U;
    ImageView V;
    RelativeLayout W;
    RelativeLayout X;
    RecyclerView Y;
    RecyclerView.LayoutManager Z;

    /* renamed from: a0, reason: collision with root package name */
    com.tencent.mobileqq.vas.e f181924a0;

    /* renamed from: b0, reason: collision with root package name */
    IEmoticonMainPanel f181925b0;

    /* renamed from: c0, reason: collision with root package name */
    RelativeLayout f181926c0;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f181927d;

    /* renamed from: d0, reason: collision with root package name */
    ColorNickTextView f181928d0;

    /* renamed from: e, reason: collision with root package name */
    private Context f181929e;

    /* renamed from: e0, reason: collision with root package name */
    TextView f181930e0;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.troop.activity.editinfo.a f181931f;

    /* renamed from: f0, reason: collision with root package name */
    ImageView f181932f0;

    /* renamed from: g0, reason: collision with root package name */
    LinearLayout f181933g0;

    /* renamed from: h, reason: collision with root package name */
    private View f181934h;

    /* renamed from: h0, reason: collision with root package name */
    PresetWordFlowLayout f181935h0;

    /* renamed from: i, reason: collision with root package name */
    protected EditText f181936i;

    /* renamed from: i0, reason: collision with root package name */
    TextView f181937i0;

    /* renamed from: j0, reason: collision with root package name */
    ImageView f181938j0;

    /* renamed from: k0, reason: collision with root package name */
    ShopLayout f181939k0;

    /* renamed from: l0, reason: collision with root package name */
    protected Handler f181940l0;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f181941m;

    /* renamed from: m0, reason: collision with root package name */
    private ViewTreeObserver.OnGlobalLayoutListener f181942m0;

    /* renamed from: n0, reason: collision with root package name */
    private IVasKuiklyNestPageFrame.b f181943n0;

    /* renamed from: o0, reason: collision with root package name */
    com.tencent.mobileqq.troop.api.observer.e f181944o0;

    /* renamed from: p0, reason: collision with root package name */
    e.InterfaceC8906e f181945p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f181946q0;

    /* renamed from: r0, reason: collision with root package name */
    private int f181947r0;

    /* renamed from: s0, reason: collision with root package name */
    ClearableEditText.d f181948s0;

    /* renamed from: t0, reason: collision with root package name */
    private e.b[] f181949t0;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f181950u0;

    /* renamed from: v0, reason: collision with root package name */
    private int f181951v0;

    /* renamed from: w0, reason: collision with root package name */
    private ArrayList<e.b> f181952w0;

    /* renamed from: x0, reason: collision with root package name */
    private ArrayList<Integer> f181953x0;

    /* renamed from: y0, reason: collision with root package name */
    private int f181954y0;

    /* renamed from: z0, reason: collision with root package name */
    private final SVIPObserver f181955z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.activity.editservice.EditTroopMemberNickService$9, reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass9 extends com.tencent.mobileqq.troop.api.observer.e {
        static IPatchRedirector $redirector_;

        AnonymousClass9() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EditTroopMemberNickService.this);
            }
        }

        private TroopMemberCardInfo b(ArrayList<TroopMemberCardInfo> arrayList) {
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator<TroopMemberCardInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    TroopMemberCardInfo next = it.next();
                    if (!TextUtils.isEmpty(next.troopuin) && next.troopuin.equals(EditTroopMemberNickService.this.J) && !TextUtils.isEmpty(next.memberuin) && next.memberuin.equals(EditTroopMemberNickService.this.K)) {
                        return next;
                    }
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(TroopMemberCardInfo troopMemberCardInfo) {
            Intent intent = new Intent();
            intent.putExtra("result", troopMemberCardInfo.colorNick);
            intent.putExtra("edit_action", EditTroopMemberNickService.this.L);
            EditTroopMemberNickService.this.f181931f.onFinishForResult(-1, intent);
            QLog.i("EditTroopMemberNickService", 1, "[onModifyTroopInfoResult] colorNick = " + troopMemberCardInfo.colorNick);
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onGetTroopMemberAutoRemark(boolean z16, String str, String str2) {
            EditText editText;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str, str2);
                return;
            }
            if (z16) {
                if (str != null && str.equals(EditTroopMemberNickService.this.K) && !TextUtils.isEmpty(str2) && (editText = EditTroopMemberNickService.this.f181936i) != null) {
                    editText.setText(str2);
                    EditTroopMemberNickService.this.f181936i.setSelection(str2.length());
                }
                if (QLog.isColorLevel()) {
                    QLog.d("EditTroopMemberNickService", 2, str, str2);
                }
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onGetTroopMemberCard(boolean z16, Object obj) {
            EditText editText;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), obj);
                return;
            }
            QLog.i("EditTroopMemberNickService", 1, "[onGetTroopMemberCard] isSuccess = " + z16 + ", data = " + obj + ", mTroopUin = " + EditTroopMemberNickService.this.J);
            EditTroopMemberNickService editTroopMemberNickService = EditTroopMemberNickService.this;
            if (!editTroopMemberNickService.M) {
                return;
            }
            editTroopMemberNickService.M = false;
            editTroopMemberNickService.f181931f.loadingProgress(false);
            if (!EditTroopMemberNickService.this.r0(2) && (editText = EditTroopMemberNickService.this.f181936i) != null) {
                o33.a.a(2, ((ColorClearableEditText) editText).h(), 50, 113);
            }
            if (z16) {
                try {
                    Object[] objArr = (Object[]) obj;
                    long longValue = ((Long) objArr[0]).longValue();
                    ((Integer) objArr[1]).intValue();
                    TroopMemberCard troopMemberCard = (TroopMemberCard) objArr[2];
                    if (longValue != Long.parseLong(EditTroopMemberNickService.this.J) || troopMemberCard == null || troopMemberCard.memberUin != Long.parseLong(EditTroopMemberNickService.this.K)) {
                        return;
                    }
                    EditTroopMemberNickService.this.f181940l0.postDelayed(new Runnable(troopMemberCard) { // from class: com.tencent.mobileqq.activity.editservice.EditTroopMemberNickService.9.2
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ TroopMemberCard f181962d;

                        {
                            this.f181962d = troopMemberCard;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass9.this, (Object) troopMemberCard);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            if (this.f181962d != null) {
                                Intent intent = new Intent();
                                intent.putExtra("result", this.f181962d.colorCard);
                                intent.putExtra("edit_action", EditTroopMemberNickService.this.L);
                                EditTroopMemberNickService.this.f181931f.onFinishForResult(-1, intent);
                                QLog.i("EditTroopMemberNickService", 1, "[onGetTroopMemberCard] colorCard = " + this.f181962d.colorCard);
                            }
                        }
                    }, 700L);
                } catch (Exception e16) {
                    QLog.e("EditTroopMemberNickService", 1, "[onGetTroopMemberCard] e = " + e16);
                }
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onModifyTroopInfoResult(boolean z16, ArrayList<TroopMemberCardInfo> arrayList, String str) {
            String str2;
            EditText editText;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), arrayList, str);
                return;
            }
            QLog.i("EditTroopMemberNickService", 1, "[onModifyTroopInfoResult] isSuc = " + z16 + ", list = " + arrayList + ", errorMsg = " + str + ", mTroopUin = " + EditTroopMemberNickService.this.J + ", uin = " + EditTroopMemberNickService.this.K);
            EditTroopMemberNickService editTroopMemberNickService = EditTroopMemberNickService.this;
            if (!editTroopMemberNickService.M) {
                return;
            }
            editTroopMemberNickService.M = false;
            if (z16 && arrayList != null && arrayList.size() != 0) {
                ReportController.o(EditTroopMemberNickService.this.f181927d, "dc00899", "Grp_set", "", "nickname edit", "nickname edit_sub_success", 0, 0, String.valueOf(EditTroopMemberNickService.this.J), "", "", "");
                final TroopMemberCardInfo b16 = b(arrayList);
                if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("9115_no_need_get_member_card", true) && b16 != null) {
                    if (!EditTroopMemberNickService.this.r0(2) && (editText = EditTroopMemberNickService.this.f181936i) != null) {
                        o33.a.a(2, ((ColorClearableEditText) editText).h(), 50, 113);
                    }
                    EditTroopMemberNickService.this.f181940l0.post(new Runnable() { // from class: com.tencent.mobileqq.activity.editservice.m
                        @Override // java.lang.Runnable
                        public final void run() {
                            EditTroopMemberNickService.AnonymousClass9.this.c(b16);
                        }
                    });
                    return;
                }
                try {
                    ((com.tencent.mobileqq.troop.api.handler.e) EditTroopMemberNickService.this.f181927d.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_CARD_HANDLER)).f2(Long.parseLong(EditTroopMemberNickService.this.J), Long.parseLong(EditTroopMemberNickService.this.K));
                    EditTroopMemberNickService.this.M = true;
                    return;
                } catch (Exception unused) {
                    EditTroopMemberNickService.this.f181931f.loadingProgress(false);
                    EditTroopMemberNickService.this.r0(3);
                    return;
                }
            }
            EditTroopMemberNickService.this.f181931f.loadingProgress(false);
            EditTroopMemberNickService.this.r0(3);
            Context context = EditTroopMemberNickService.this.f181929e;
            if (TextUtils.isEmpty(str)) {
                str2 = EditTroopMemberNickService.this.N(R.string.cab);
            } else {
                str2 = str;
            }
            QQToast.makeText(context, 1, str2, 0).show(EditTroopMemberNickService.this.O());
            EditTroopMemberNickService.this.f181940l0.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.editservice.EditTroopMemberNickService.9.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass9.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        EditTroopMemberNickService.this.f181936i.clearFocus();
                        EditTroopMemberNickService.this.g0();
                    }
                }
            }, 1500L);
            ReportController.o(EditTroopMemberNickService.this.f181927d, "dc00899", "Grp_set", "", "nickname edit", "nickname edit_sub_failure", 0, 0, String.valueOf(EditTroopMemberNickService.this.J), "1", "", "");
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements e.InterfaceC8906e {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EditTroopMemberNickService.this);
            }
        }

        @Override // com.tencent.mobileqq.vas.e.InterfaceC8906e
        public void a(e.b bVar) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
                return;
            }
            EditTroopMemberNickService editTroopMemberNickService = EditTroopMemberNickService.this;
            if (editTroopMemberNickService.f181936i instanceof ColorClearableEditText) {
                editTroopMemberNickService.f181950u0 = true;
                ColorClearableEditText colorClearableEditText = (ColorClearableEditText) EditTroopMemberNickService.this.f181936i;
                String g16 = com.tencent.mobileqq.vas.f.g(bVar);
                int i16 = 0;
                com.tencent.mobileqq.vas.i[] iVarArr = (com.tencent.mobileqq.vas.i[]) EditTroopMemberNickService.this.f181936i.getEditableText().getSpans(0, EditTroopMemberNickService.this.f181936i.getEditableText().length(), com.tencent.mobileqq.vas.i.class);
                if (iVarArr != null && iVarArr.length > 0) {
                    int spanStart = EditTroopMemberNickService.this.f181936i.getEditableText().getSpanStart(iVarArr[0]);
                    i3 = EditTroopMemberNickService.this.f181936i.getEditableText().getSpanEnd(iVarArr[0]);
                    EditTroopMemberNickService.this.f181936i.getEditableText().removeSpan(iVarArr[0]);
                    i16 = spanStart;
                } else {
                    i3 = 0;
                }
                EditTroopMemberNickService.this.f181936i.getEditableText().replace(i16, i3, g16);
                int i17 = bVar.f309041a;
                if (i17 != 2) {
                    if (i17 == 3) {
                        colorClearableEditText.setTextColor(-16777216);
                        com.tencent.mobileqq.vas.f.h(EditTroopMemberNickService.this.f181927d).e(bVar.f309044d);
                        return;
                    }
                    return;
                }
                int i18 = bVar.f309044d;
                if (i18 != 0) {
                    colorClearableEditText.setTextColor(i18);
                } else {
                    colorClearableEditText.setTextColor(-16777216);
                }
                colorClearableEditText.setSpecialColor(0, null, null, 0, null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b implements ClearableEditText.d {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EditTroopMemberNickService.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.ClearableEditText.d
        public void E0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            EditTroopMemberNickService editTroopMemberNickService = EditTroopMemberNickService.this;
            EditText editText = editTroopMemberNickService.f181936i;
            if (editText instanceof ColorClearableEditText) {
                ColorClearableEditText colorClearableEditText = (ColorClearableEditText) editText;
                colorClearableEditText.setSpecialColor(0, null, null, 0, null);
                colorClearableEditText.setCustomCloth(0, false);
            } else {
                editText.setTextColor(editTroopMemberNickService.M().getColor(R.color.skin_input));
            }
            EditTroopMemberNickService.this.f181924a0.r(-1);
            EditTroopMemberNickService.this.f181924a0.f309038i.a(-1);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class c extends SVIPObserver {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EditTroopMemberNickService.this);
            }
        }

        @Override // com.tencent.mobileqq.app.SVIPObserver
        public void onGetColorNickData(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                return;
            }
            if (z16 && (obj instanceof readItemInfoRsp)) {
                readItemInfoRsp readiteminforsp = (readItemInfoRsp) obj;
                EditTroopMemberNickService.this.f181951v0 = readiteminforsp.index;
                String str = readiteminforsp.urlprefix;
                ArrayList<GroupNickEmoji> arrayList = readiteminforsp.emojilist;
                if (arrayList != null && arrayList.size() > 0 && EditTroopMemberNickService.this.f181953x0.size() == 0) {
                    Iterator<GroupNickEmoji> it = readiteminforsp.emojilist.iterator();
                    while (it.hasNext()) {
                        EditTroopMemberNickService.this.f181953x0.add(Integer.valueOf(it.next().itemid));
                    }
                    EditTroopMemberNickService.this.f181940l0.sendEmptyMessage(260);
                }
                ArrayList<GroupNickItem> arrayList2 = readiteminforsp.itemlist;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    Iterator<GroupNickItem> it5 = readiteminforsp.itemlist.iterator();
                    while (it5.hasNext()) {
                        GroupNickItem next = it5.next();
                        EditTroopMemberNickService.this.f181952w0.add(new e.b(3, null, next.itemid, str + next.url));
                    }
                    EditTroopMemberNickService editTroopMemberNickService = EditTroopMemberNickService.this;
                    if (readiteminforsp.left == 1) {
                        z17 = true;
                    }
                    editTroopMemberNickService.T(z17);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class d extends e.c {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EditTroopMemberNickService.this);
            }
        }

        @Override // com.tencent.mobileqq.vas.e.c
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                EditTroopMemberNickService editTroopMemberNickService = EditTroopMemberNickService.this;
                editTroopMemberNickService.p0(editTroopMemberNickService.f181951v0);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class e implements com.tencent.mobileqq.widget.navbar.a {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EditTroopMemberNickService.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.navbar.a
        public void onItemSelect(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (i3 == 1) {
                EditTroopMemberNickService.this.f181931f.onFinish();
            }
            if (i3 == 2) {
                EditTroopMemberNickService.this.J();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class f implements TextView.OnEditorActionListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EditTroopMemberNickService.this);
            }
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                z16 = ((Boolean) iPatchRedirector.redirect((short) 2, this, textView, Integer.valueOf(i3), keyEvent)).booleanValue();
            } else if (i3 == 6 || i3 == 5) {
                EditTroopMemberNickService.this.J();
                z16 = true;
            }
            EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
            return z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class g implements com.tencent.mobileqq.vas.troopnick.shop.adapter.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f181970a;

        g(int i3) {
            this.f181970a = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EditTroopMemberNickService.this, i3);
            }
        }

        @Override // com.tencent.mobileqq.vas.troopnick.shop.adapter.a
        public void a(boolean z16, UniCheckRsp uniCheckRsp) {
            ArrayList<UniBusinessCheckItem> arrayList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), uniCheckRsp);
                return;
            }
            if (!z16 && uniCheckRsp != null && (arrayList = uniCheckRsp.uniBusinessItemList) != null && arrayList.size() == 1) {
                EditTroopMemberNickService editTroopMemberNickService = EditTroopMemberNickService.this;
                editTroopMemberNickService.M = false;
                editTroopMemberNickService.f181931f.loadingProgress(false);
                EditTroopMemberNickService.this.r0(3);
                com.tencent.mobileqq.vas.troopnick.shop.adapter.d.d(String.valueOf(this.f181970a));
                com.tencent.mobileqq.vas.troopnick.shop.adapter.d.b(EditTroopMemberNickService.this.f181929e);
                return;
            }
            com.tencent.mobileqq.apollo.handler.b bVar = (com.tencent.mobileqq.apollo.handler.b) EditTroopMemberNickService.this.f181927d.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
            EditTroopMemberNickService editTroopMemberNickService2 = EditTroopMemberNickService.this;
            bVar.A0(editTroopMemberNickService2.J, ((ColorClearableEditText) editTroopMemberNickService2.f181936i).g(), this.f181970a);
            EditTroopMemberNickService.this.M = true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class h implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EditTroopMemberNickService.this);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (EditTroopMemberNickService.this.f181934h == null) {
                return;
            }
            Rect rect = new Rect();
            EditTroopMemberNickService.this.f181934h.getWindowVisibleDisplayFrame(rect);
            if ((ViewUtils.getScreenHeight() - (rect.bottom - rect.top)) - EditTroopMemberNickService.this.O() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            EditTroopMemberNickService.this.j0(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class i implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EditTroopMemberNickService.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                EditTroopMemberNickService.this.a0();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class j implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EditTroopMemberNickService.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                EditTroopMemberNickService.this.a0();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class k implements g.a {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EditTroopMemberNickService.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.activity.g.a
        public void a(View view, int i3, g.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, view, Integer.valueOf(i3), bVar);
            } else if (i3 >= 0 && EditTroopMemberNickService.this.P.size() > i3) {
                EditTroopMemberNickService.this.f181936i.getText().insert(EditTroopMemberNickService.this.f181936i.getSelectionStart(), EditTroopMemberNickService.this.N.getItem(i3));
                ReportController.o(EditTroopMemberNickService.this.f181927d, "dc00899", "Grp_set", "", "nickname edit", "nickname edit_def_click", 0, 0, String.valueOf(EditTroopMemberNickService.this.J), "", "", "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class l implements ShopLayout.d {
        static IPatchRedirector $redirector_;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EditTroopMemberNickService.this);
            }
        }

        @Override // com.tencent.mobileqq.vas.troopnick.shop.widget.ShopLayout.d
        public void hideInputMethod() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            RelativeLayout relativeLayout = EditTroopMemberNickService.this.R;
            if (relativeLayout == null) {
                return;
            }
            if (relativeLayout.getVisibility() == 0 || EditTroopMemberNickService.this.f181946q0) {
                EditTroopMemberNickService.this.f181931f.hideInputMethod();
                EditTroopMemberNickService.this.R.setVisibility(8);
                EditTroopMemberNickService.this.f181936i.setCursorVisible(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class m implements a.c {
        static IPatchRedirector $redirector_;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EditTroopMemberNickService.this);
            }
        }

        @Override // com.tencent.mobileqq.vas.troopnick.shop.widget.a.c
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                EditTroopMemberNickService.this.J();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.vas.troopnick.shop.widget.a.c
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                com.tencent.mobileqq.vas.troopnick.shop.adapter.d.d("Open");
                com.tencent.mobileqq.vas.troopnick.shop.adapter.d.b(EditTroopMemberNickService.this.f181929e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class n implements ShopLayout.e {
        static IPatchRedirector $redirector_;

        n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EditTroopMemberNickService.this);
            }
        }

        @Override // com.tencent.mobileqq.vas.troopnick.shop.widget.ShopLayout.e
        public void a(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            EditText editText = EditTroopMemberNickService.this.f181936i;
            if (editText instanceof ColorClearableEditText) {
                ColorClearableEditText colorClearableEditText = (ColorClearableEditText) editText;
                colorClearableEditText.setCustomCloth(i16, true);
                EditTroopMemberNickService.this.f181931f.updateEditTextAndNum(colorClearableEditText.getText().toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class o extends View.AccessibilityDelegate {
        static IPatchRedirector $redirector_;

        o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) EditTroopMemberNickService.this);
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            String obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) accessibilityNodeInfo);
                return;
            }
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            if (EditTroopMemberNickService.this.f181936i.getText() == null) {
                obj = "";
            } else {
                obj = EditTroopMemberNickService.this.f181936i.getText().toString();
            }
            accessibilityNodeInfo.setText(new QQText(new SpannableStringBuilder(obj), 16, 16).toPlainText());
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class p {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public boolean f181980a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f181981b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f181982c;

        public p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68232);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 29)) {
            redirector.redirect((short) 29);
        } else {
            C0 = ar.b("shouyouye", "2024-08-19", "vas_downline_troop_color_nick").isEnable(true);
        }
    }

    public EditTroopMemberNickService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f181936i = null;
        this.f181941m = false;
        this.C = false;
        this.D = null;
        this.E = -1;
        this.F = null;
        this.G = null;
        this.H = 0;
        this.I = -1;
        this.L = 0;
        this.P = new ArrayList<>();
        this.f181940l0 = new Handler(this);
        this.f181942m0 = new h();
        this.f181944o0 = new AnonymousClass9();
        this.f181945p0 = new a();
        this.f181946q0 = false;
        this.f181947r0 = 0;
        this.f181948s0 = new b();
        this.f181949t0 = new e.b[]{new e.b(2, null, 0, null)};
        this.f181950u0 = false;
        this.f181951v0 = 0;
        this.f181952w0 = new ArrayList<>();
        this.f181953x0 = new ArrayList<>();
        this.f181954y0 = 0;
        this.f181955z0 = new c();
        this.A0 = new com.tencent.mobileqq.apollo.handler.c() { // from class: com.tencent.mobileqq.activity.editservice.EditTroopMemberNickService.13
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.activity.editservice.EditTroopMemberNickService$13$a */
            /* loaded from: classes10.dex */
            public class a implements DialogInterface.OnClickListener {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass13.this);
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    } else {
                        VasH5PayUtil.openH5Pay(EditTroopMemberNickService.this.f181929e, "mvip.g.a.qnc_gc", "CJCLUBT", -1, false, true);
                        dialogInterface.dismiss();
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.activity.editservice.EditTroopMemberNickService$13$b */
            /* loaded from: classes10.dex */
            public class b implements DialogInterface.OnClickListener {
                static IPatchRedirector $redirector_;

                b() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass13.this);
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("ColorNick", 2, "onSetColorNick failed. save colorNick");
                    }
                    EditTroopMemberNickService.this.f181940l0.sendEmptyMessage(259);
                    dialogInterface.dismiss();
                }
            }

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EditTroopMemberNickService.this);
                }
            }

            protected void a(boolean z16, int i3, String str) {
                String str2 = str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, this, Boolean.valueOf(z16), Integer.valueOf(i3), str2);
                    return;
                }
                if (z16) {
                    VasWebviewUtil.reportCommercialDrainage(EditTroopMemberNickService.this.f181927d.getCurrentUin(), "group_nickname", "set", "", 1, 0, 0, "", "", "");
                    if (QLog.isColorLevel()) {
                        QLog.d("ColorNick", 2, "onSetColorNick. clear saved colorNick");
                    }
                    EditTroopMemberNickService.this.q0(true);
                    try {
                        ((com.tencent.mobileqq.troop.api.handler.e) EditTroopMemberNickService.this.f181927d.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_CARD_HANDLER)).f2(Long.parseLong(EditTroopMemberNickService.this.J), Long.parseLong(EditTroopMemberNickService.this.K));
                    } catch (Exception unused) {
                        EditTroopMemberNickService.this.f181931f.loadingProgress(false);
                        EditTroopMemberNickService.this.r0(3);
                    }
                    VasCommonReporter.getServiceQuality("troop_nick_set").setNum1(0L).report(false);
                    return;
                }
                EditTroopMemberNickService.this.f181931f.loadingProgress(false);
                EditTroopMemberNickService.this.r0(3);
                if (i3 == 1282) {
                    VasWebviewUtil.reportCommercialDrainage(EditTroopMemberNickService.this.f181927d.getCurrentUin(), "group_nickname", "group_nickname_9", "", 1, 0, 0, "", "", "");
                    try {
                        DialogUtil.createCustomDialog(EditTroopMemberNickService.this.f181929e, 230, HardCodeUtil.qqStr(R.string.lvn), HardCodeUtil.qqStr(R.string.lvh), HardCodeUtil.qqStr(R.string.lva), HardCodeUtil.qqStr(R.string.lve), new a(), new b()).show();
                    } catch (Exception e16) {
                        QLog.e("EditTroopMemberNickService", 1, "onSetColorNick", e16);
                    }
                    VasCommonReporter.getServiceQuality("troop_nick_set").setNum1(502L).report(false);
                    return;
                }
                if (1283 == i3) {
                    QQToast.makeText(EditTroopMemberNickService.this.f181929e, 1, HardCodeUtil.qqStr(R.string.lvd), 0).show(EditTroopMemberNickService.this.O());
                    VasCommonReporter.getServiceQuality("troop_nick_set").setNum1(503L).report(false);
                    return;
                }
                if (1793 == i3) {
                    Context context = EditTroopMemberNickService.this.f181929e;
                    if (TextUtils.isEmpty(str)) {
                        str2 = EditTroopMemberNickService.this.N(R.string.iqx);
                    }
                    QQToast.makeText(context, 1, str2, 0).show(EditTroopMemberNickService.this.O());
                    VasCommonReporter.getServiceQuality("troop_nick_set").setNum1(701L).report(false);
                    return;
                }
                QLog.e("EditTroopMemberNickService", 1, "retCode=" + i3 + " errorMsg=" + str2);
                QQToast.makeText(EditTroopMemberNickService.this.f181929e, 1, R.string.cab, 0).show(EditTroopMemberNickService.this.O());
                EditTroopMemberNickService.this.f181940l0.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.editservice.EditTroopMemberNickService.13.3
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass13.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                        } else {
                            EditTroopMemberNickService.this.f181936i.clearFocus();
                            EditTroopMemberNickService.this.g0();
                        }
                    }
                }, 1500L);
                VasCommonReporter.getServiceQuality("troop_nick_set").setNum1(999L).report(false);
            }

            @Override // com.tencent.mobileqq.app.BusinessObserver
            public void onUpdate(int i3, boolean z16, Object obj) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
                    return;
                }
                if (i3 == 27) {
                    Object[] objArr = (Object[]) obj;
                    if (objArr != null && objArr.length > 1) {
                        a(z16, ((Integer) objArr[0]).intValue(), (String) objArr[1]);
                    } else {
                        a(z16, 0, "");
                    }
                }
            }
        };
        this.B0 = new d();
    }

    private void H() {
        if (this.W != null && this.f181926c0 != null && this.f181928d0 != null && this.f181936i != null && ThemeUtil.isNowThemeIsNight(ThemeUtil.getCreateAppRuntime(), false, null)) {
            this.W.setBackgroundColor(-16777216);
            this.f181926c0.setBackgroundColor(-16777216);
            this.f181928d0.setBackgroundColor(-16777216);
            this.f181936i.setBackgroundColor(Color.parseColor("#1A1A1A"));
            this.f181936i.setTextColor(-1);
            try {
                ((View) this.f181936i.getParent()).setBackgroundColor(Color.parseColor("#1A1A1A"));
                ((View) this.f181936i.getParent().getParent()).setBackgroundColor(-16777216);
                ((View) this.f181936i.getParent().getParent().getParent()).setBackgroundColor(-16777216);
            } catch (Exception e16) {
                QLog.e("EditTroopMemberNickService", 1, e16, new Object[0]);
            }
        }
    }

    private void I(int i3) {
        boolean z16;
        if (i3 != 1) {
            if (i3 == 2) {
                if (this.f181954y0 == 2) {
                    this.f181931f.showInputMethod();
                } else {
                    this.f181954y0 = 2;
                    this.f181926c0.setVisibility(8);
                    com.tencent.mobileqq.vas.f.h(this.f181927d).f309063f = this.f181940l0;
                    this.V.setImageResource(R.drawable.fmr);
                    this.U.setImageResource(R.drawable.fmx);
                    this.W.setVisibility(0);
                    this.X.setVisibility(8);
                    this.Y.setVisibility(0);
                    ((RelativeLayout.LayoutParams) this.W.getLayoutParams()).height = x.c(this.f181929e, 388.0f);
                    ((RelativeLayout.LayoutParams) this.R.getLayoutParams()).bottomMargin = x.c(this.f181929e, 388.0f);
                }
            }
        } else if (this.f181954y0 == 1) {
            this.f181931f.showInputMethod();
        } else {
            this.f181954y0 = 1;
            this.f181926c0.setVisibility(8);
            com.tencent.mobileqq.vas.f.h(this.f181927d).f309063f = this.f181940l0;
            this.V.setImageResource(R.drawable.fms);
            this.U.setImageResource(R.drawable.fmw);
            this.W.setVisibility(0);
            this.X.setVisibility(0);
            this.Y.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.W.getLayoutParams()).height = x.c(this.f181929e, 387.0f);
            ((RelativeLayout.LayoutParams) this.R.getLayoutParams()).bottomMargin = x.c(this.f181929e, 387.0f);
            if (this.f181925b0 == null) {
                IEmoticonMainPanelService.PanelBuilder newBuilder = ((IEmoticonMainPanelService) this.f181927d.getRuntimeService(IEmoticonMainPanelService.class)).newBuilder(this.f181929e, 100001);
                if (this.I == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                IEmoticonMainPanel create = newBuilder.setFilterSysFaceBeyond255Enable(z16).setCallBack(this).setDisableGuide(true).setDisableMoreEmotionButton(true).setHasBigEmotion(false).setOnlySysAndEmoji(true).setDisableAutoDownload(true).setToastOffset(O()).setEmoticonListProvider(com.tencent.mobileqq.vas.f.h(this.f181927d).f309062e).create();
                this.f181925b0 = create;
                create.setTabListOverScrollMode(2);
                this.X.addView(this.f181925b0.getView());
            }
        }
        this.f181947r0 = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        QQText qQText;
        String qQText2;
        String trim;
        Editable text = this.f181936i.getText();
        if (text != null) {
            qQText = new QQText(text.toString(), 3);
        } else {
            qQText = null;
        }
        if (qQText == null) {
            qQText2 = "";
        } else {
            qQText2 = qQText.toString();
        }
        if (qQText == null) {
            trim = "";
        } else {
            trim = qQText.trim();
        }
        VasWebviewUtil.reportCommercialDrainage(this.f181927d.getCurrentUin(), "group_nickname", "group_nickname_7", "", 1, 0, 0, "", "", "");
        int i3 = 0;
        if (!NetworkUtil.isNetSupport(this.f181927d.getApplication().getApplicationContext())) {
            QQToast.makeText(this.f181929e, 1, R.string.f171139ci4, 0).show(O());
            ReportController.o(this.f181927d, "dc00899", "Grp_set", "", "nickname edit", "nickname edit_sub_failure", 0, 0, String.valueOf(this.J), "1", "", "");
            QLog.i("EditTroopMemberNickService", 1, "clickFinish network disabled");
            return;
        }
        if (this.f181931f.getLength() > this.f181931f.getMaxLength()) {
            QQToast.makeText(this.f181929e, 1, "\u6635\u79f0\u8fc7\u957f", 0).show(O());
            return;
        }
        if (Y()) {
            p pVar = new p();
            if (Q()) {
                QQToast.makeText(this.f181929e, HardCodeUtil.qqStr(R.string.lv_), 0).show(O());
                QLog.i("EditTroopMemberNickService", 1, "hasEmojiButNoText");
                return;
            }
            if (P(pVar)) {
                if (pVar.f181982c && this.f181936i.getText().length() <= 0) {
                    QQToast.makeText(this.f181929e, HardCodeUtil.qqStr(R.string.lv_), 0).show(O());
                    QLog.i("EditTroopMemberNickService", 1, "nick is empty");
                    return;
                }
                this.f181931f.loadingProgress(true);
                r0(1);
                int h16 = ((ColorClearableEditText) this.f181936i).h();
                if (h16 > 0) {
                    new com.tencent.mobileqq.vas.troopnick.shop.adapter.d().e(50, h16, 6, new g(h16));
                    this.M = true;
                    return;
                } else {
                    ((com.tencent.mobileqq.apollo.handler.b) this.f181927d.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).A0(this.J, ((ColorClearableEditText) this.f181936i).g(), h16);
                    this.M = true;
                    QLog.i("EditTroopMemberNickService", 1, "has color nick done.");
                    return;
                }
            }
            if (pVar.f181981b && !pVar.f181980a) {
                trim = "";
            }
        }
        QLog.i("EditTroopMemberNickService", 1, "savetxtTmp=" + trim + ", originalText=" + qQText2 + ", defaultText=" + this.G);
        int i16 = this.L;
        if ((i16 == 3 || i16 == 4) && TextUtils.isEmpty(trim) && !TextUtils.isEmpty(qQText2)) {
            QQToast.makeText(this.f181929e, N(R.string.bue), 0).show(O());
            return;
        }
        int h17 = ((ColorClearableEditText) this.f181936i).h();
        if ((TextUtils.isEmpty(this.G) && TextUtils.isEmpty(trim)) || (!TextUtils.isEmpty(this.G) && this.G.equals(trim) && this.H == h17)) {
            this.f181931f.onFinish();
            return;
        }
        TroopMemberCardInfo troopMemberCardInfo = new TroopMemberCardInfo();
        troopMemberCardInfo.name = trim;
        troopMemberCardInfo.memberuin = this.K;
        troopMemberCardInfo.troopuin = this.J;
        ArrayList<TroopMemberCardInfo> arrayList = new ArrayList<>();
        arrayList.add(troopMemberCardInfo);
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(1);
        com.tencent.mobileqq.troop.api.handler.e eVar = (com.tencent.mobileqq.troop.api.handler.e) this.f181927d.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_CARD_HANDLER);
        if (eVar != null && !TextUtils.isEmpty(this.J)) {
            this.f181931f.loadingProgress(true);
            r0(1);
            QLog.i("EditTroopMemberNickService", 1, "modifyTroopMemberCardInfo troopUin=" + this.J + ", name=" + troopMemberCardInfo.name);
            eVar.V0(this.J, arrayList, arrayList2);
        }
        TroopInfo findTroopInfo = ((ITroopInfoService) this.f181927d.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(this.J);
        if (findTroopInfo != null) {
            if (!findTroopInfo.isOwner()) {
                if (findTroopInfo.isOwnerOrAdmin()) {
                    i3 = 1;
                }
            }
            this.M = true;
            ReportController.o(this.f181927d, "P_CliOper", "Grp_manage", "", "modify_name", "complete", 0, 0, this.J, i3 + "", "" + this.I, "");
        }
        i3 = 2;
        this.M = true;
        ReportController.o(this.f181927d, "P_CliOper", "Grp_manage", "", "modify_name", "complete", 0, 0, this.J, i3 + "", "" + this.I, "");
    }

    private <T extends View> T K(int i3) {
        View view = this.f181934h;
        if (view != null) {
            return (T) view.findViewById(i3);
        }
        QLog.e("EditTroopMemberNickService", 1, "root is null");
        return null;
    }

    private int L() {
        String obj;
        if (P(new p())) {
            ArrayList<ColorClearableEditText.a> g16 = ((ColorClearableEditText) this.f181936i).g();
            ArrayList arrayList = new ArrayList();
            Iterator<ColorClearableEditText.a> it = g16.iterator();
            while (it.hasNext()) {
                ColorClearableEditText.a next = it.next();
                Oidb_0x8fc$RichCardNameElem oidb_0x8fc$RichCardNameElem = new Oidb_0x8fc$RichCardNameElem();
                int i3 = next.f315542e;
                if (i3 != 1) {
                    if (i3 == 2 || i3 == 3) {
                        String str = next.f315540c;
                        if (str.substring(0, 1).equals("<")) {
                            str = str.substring(1);
                        }
                        if (str.substring(str.length() - 1).equals(">")) {
                            str = str.substring(0, str.length() - 1);
                        }
                        oidb_0x8fc$RichCardNameElem.bytes_ctrl.set(ByteStringMicro.copyFrom(str.getBytes()));
                    }
                } else {
                    oidb_0x8fc$RichCardNameElem.bytes_text.set(ByteStringMicro.copyFrom(this.f181936i.getText().toString().getBytes()));
                }
                arrayList.add(oidb_0x8fc$RichCardNameElem);
            }
            Oidb_0x8fc$CommCardNameBuf oidb_0x8fc$CommCardNameBuf = new Oidb_0x8fc$CommCardNameBuf();
            oidb_0x8fc$CommCardNameBuf.rpt_rich_card_name.set(arrayList);
            return oidb_0x8fc$CommCardNameBuf.toByteArray().length + 3;
        }
        Editable text = this.f181936i.getText();
        if (text == null) {
            obj = "";
        } else {
            obj = text.toString();
        }
        int length = obj.trim().length();
        try {
            return obj.getBytes("utf-8").length;
        } catch (UnsupportedEncodingException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ColorNick", 2, "UnsupportedEncodingException:" + e16.getMessage());
                return length;
            }
            return length;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Resources M() {
        return this.f181929e.getResources();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String N(int i3) {
        return HardCodeUtil.qqStr(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int O() {
        return M().getDimensionPixelSize(R.dimen.title_bar_height);
    }

    private boolean P(p pVar) {
        boolean z16;
        boolean z17;
        Throwable th5;
        if (pVar != null) {
            pVar.f181981b = false;
            pVar.f181980a = false;
            pVar.f181982c = false;
        }
        EditText editText = this.f181936i;
        if (editText instanceof ColorClearableEditText) {
            ColorClearableEditText colorClearableEditText = (ColorClearableEditText) editText;
            if (colorClearableEditText.h() > 0 && pVar != null) {
                pVar.f181982c = true;
                return true;
            }
            colorClearableEditText.j();
            ArrayList<ColorClearableEditText.a> g16 = colorClearableEditText.g();
            if (g16 != null && g16.size() > 0) {
                try {
                    Iterator<ColorClearableEditText.a> it = g16.iterator();
                    z16 = false;
                    z17 = false;
                    while (it.hasNext()) {
                        try {
                            int i3 = it.next().f315542e;
                            if (i3 == 1) {
                                z17 = true;
                            } else if (i3 == 3) {
                                z16 = true;
                            } else if (i3 == 2) {
                                if (pVar != null) {
                                    pVar.f181981b = z16;
                                    pVar.f181980a = z17;
                                }
                                return true;
                            }
                            if (z16 && z17) {
                                if (pVar != null) {
                                    pVar.f181981b = z16;
                                    pVar.f181980a = z17;
                                }
                                return true;
                            }
                        } catch (Throwable th6) {
                            th5 = th6;
                            if (pVar != null) {
                                pVar.f181981b = z16;
                                pVar.f181980a = z17;
                            }
                            throw th5;
                        }
                    }
                    if (pVar != null) {
                        pVar.f181981b = z16;
                        pVar.f181980a = z17;
                    }
                } catch (Throwable th7) {
                    z16 = false;
                    z17 = false;
                    th5 = th7;
                }
            }
        }
        return false;
    }

    private boolean Q() {
        boolean z16;
        EditText editText = this.f181936i;
        if (editText instanceof ColorClearableEditText) {
            try {
                ColorClearableEditText colorClearableEditText = (ColorClearableEditText) editText;
                colorClearableEditText.j();
                ArrayList<ColorClearableEditText.a> g16 = colorClearableEditText.g();
                if (g16 != null && g16.size() > 0) {
                    Iterator<ColorClearableEditText.a> it = g16.iterator();
                    boolean z17 = true;
                    while (it.hasNext()) {
                        if (it.next().f315542e == 2) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        z17 &= z16;
                    }
                    return z17;
                }
            } catch (Exception e16) {
                QLog.i("EditTroopMemberNickService", 1, "[hasEmojiButNoText] exception = " + e16);
            }
        }
        return false;
    }

    private boolean R(TroopInfo troopInfo) {
        ArrayList<String> arrayList = troopInfo.groupCardPrefix;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                if (!TextUtils.isEmpty(it.next())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private void S() {
        com.tencent.mobileqq.vas.f.r(this.f181927d, this.f181936i, new com.tencent.mobileqq.text.c(this.f181936i.getText().toString(), 16).j(), this.H, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(boolean z16) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, this.f181949t0);
        arrayList.addAll(this.f181952w0);
        this.f181924a0.q(arrayList, z16);
        NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.K), "EditTroopMemberNickService");
        if (vasSimpleInfoWithUid != null) {
            if (new VipTypeParam(vasSimpleInfoWithUid.qqVipInfo, vasSimpleInfoWithUid.superQqInfo, vasSimpleInfoWithUid.superVipInfo, vasSimpleInfoWithUid.bigClubInfo).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
                this.S.setText(N(R.string.a4b));
                this.T.setText(N(R.string.a4c));
            } else {
                this.S.setText(N(R.string.a4_));
                this.T.setText(N(R.string.a4a));
            }
        }
    }

    private void W() {
        if (QLog.isColorLevel()) {
            QLog.d("EditTroopMemberNickService", 2, "initGetTroopNickRule EditMode isTroopNick");
        }
        LinearLayout linearLayout = (LinearLayout) K(R.id.f102995ze);
        this.f181933g0 = linearLayout;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVerticalScrollBarEnabled(false);
        TextView tipsView = this.f181931f.getTipsView();
        this.D = tipsView;
        if (tipsView == null) {
            return;
        }
        tipsView.setOnClickListener(new i());
        this.f181937i0 = (TextView) K(R.id.f102985zd);
        if (ThemeUtil.isNowThemeIsNight(this.f181927d, false, null)) {
            this.f181937i0.setTextColor(-1);
        }
        ImageView imageView = (ImageView) K(R.id.f102965zb);
        this.f181938j0 = imageView;
        imageView.setOnClickListener(new j());
        if (ThemeUtil.isInNightMode(this.f181927d)) {
            this.f181938j0.setBackgroundDrawable(M().getDrawable(R.drawable.kyj));
        }
        PresetWordFlowLayout presetWordFlowLayout = (PresetWordFlowLayout) K(R.id.f103005zf);
        this.f181935h0 = presetWordFlowLayout;
        presetWordFlowLayout.f302362h = ViewUtils.dpToPx(12.0f);
        this.f181935h0.f302364m = ViewUtils.dpToPx(12.0f);
        this.N = new com.tencent.mobileqq.troop.activity.g();
        if (ThemeUtil.isInNightMode(this.f181927d)) {
            this.N.e();
        }
        this.N.f();
        this.N.f293738i = new k();
        this.f181935h0.setAdapter(this.N);
        u0();
    }

    private boolean Y() {
        return this.K.equals(this.f181927d.getCurrentAccountUin());
    }

    private boolean Z(final ViewGroup viewGroup) {
        return ((IVasPageToggle) QRoute.api(IVasPageToggle.class)).isUseKuiklyShopPage(new Function1() { // from class: com.tencent.mobileqq.activity.editservice.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                String b06;
                b06 = EditTroopMemberNickService.this.b0((String) obj);
                return b06;
            }
        }, new Function1() { // from class: com.tencent.mobileqq.activity.editservice.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit c06;
                c06 = EditTroopMemberNickService.this.c0(viewGroup, (String) obj);
                return c06;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0() {
        TroopInfo findTroopInfo = ((ITroopInfoService) this.f181927d.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(this.J);
        if (findTroopInfo != null) {
            Intent intent = new Intent();
            intent.putExtra(TroopNickRuleFragment.Q, this.J);
            intent.putExtra(TroopNickRuleFragment.R, findTroopInfo.groupCardPrefixIntro);
            if (this.I == 0) {
                intent.putExtra(TroopNickRuleFragment.T, "1");
            } else {
                intent.putExtra(TroopNickRuleFragment.T, "3");
            }
            ArrayList<String> arrayList = findTroopInfo.groupCardPrefix;
            if (arrayList != null) {
                intent.putStringArrayListExtra(TroopNickRuleFragment.S, arrayList);
            }
            PublicFragmentActivity.b.e(this.f181929e, intent, PublicFragmentActivity.class, TroopNickRuleFragment.class, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String b0(String str) {
        return URLUtil.addParameter(str, "troop_uin", this.J);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit c0(ViewGroup viewGroup, String str) {
        t0(viewGroup, str);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(String str, JSONObject jSONObject) {
        QLog.i("EditTroopMemberNickService", 1, "eventName:" + str + " data:" + jSONObject);
        String optString = jSONObject.optString("key");
        if (!"item_click".equals(optString) && !"item_set".equals(optString)) {
            if ("touch_down".equals(optString)) {
                this.f181931f.hideInputMethod();
                return;
            }
            return;
        }
        int optInt = jSONObject.optInt("id");
        EditText editText = this.f181936i;
        if (editText instanceof ColorClearableEditText) {
            ColorClearableEditText colorClearableEditText = (ColorClearableEditText) editText;
            colorClearableEditText.setCustomCloth(optInt, true);
            this.f181931f.updateEditTextAndNum(colorClearableEditText.getText().toString());
        }
        if ("item_set".equals(optString)) {
            J();
        }
        this.f181931f.hideInputMethod();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(ViewGroup viewGroup) {
        this.f181943n0.h0(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0(boolean z16) {
        this.f181946q0 = z16;
        if (z16) {
            this.f181936i.setCursorVisible(true);
            this.f181954y0 = 0;
            RelativeLayout relativeLayout = this.W;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            RelativeLayout relativeLayout2 = this.R;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(0);
                ((RelativeLayout.LayoutParams) this.R.getLayoutParams()).bottomMargin = 0;
                this.U.setImageResource(R.drawable.fmx);
                this.V.setImageResource(R.drawable.fms);
                return;
            }
            return;
        }
        int i3 = this.f181947r0;
        if (i3 > 0) {
            I(i3);
            return;
        }
        this.R.setVisibility(8);
        if (this.f181936i.getVisibility() != 0) {
            this.f181936i.setCursorVisible(false);
        }
    }

    private void m0() {
        int i3;
        com.tencent.mobileqq.troop.activity.g gVar = this.N;
        if (gVar != null) {
            gVar.b();
            Iterator<String> it = this.P.iterator();
            while (it.hasNext()) {
                this.N.a(it.next());
            }
            PresetWordFlowLayout presetWordFlowLayout = this.f181935h0;
            if (this.N.getCount() == 0) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            presetWordFlowLayout.setVisibility(i3);
            this.N.notifyDataSetChanged();
        }
    }

    private void n0() {
        com.tencent.mobileqq.troop.activity.editinfo.a aVar;
        if (this.f181934h != null && (aVar = this.f181931f) != null) {
            if (aVar.getContext() instanceof Activity) {
                ((Activity) this.f181931f.getContext()).getWindow().setSoftInputMode(16);
            }
            this.f181934h.getViewTreeObserver().addOnGlobalLayoutListener(this.f181942m0);
        }
    }

    private void o0() {
        View view = this.f181934h;
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().removeOnGlobalLayoutListener(this.f181942m0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(int i3) {
        if (C0) {
            return;
        }
        this.f181927d.addObserver(this.f181955z0);
        ((SVIPHandler) this.f181927d.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).requestColorNickPanel(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r0(int i3) {
        if (this.f181943n0 == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("state", i3);
            com.tencent.kuikly.core.render.android.expand.module.l.e(this.f181929e, "vas_troop_nick_request_state_changed", jSONObject);
        } catch (JSONException e16) {
            QLog.i("EditTroopMemberNickService", 1, "sendRequestStateToKuikly exception", e16);
        }
        return true;
    }

    private boolean s0() {
        return Y();
    }

    private void t0(final ViewGroup viewGroup, final String str) {
        viewGroup.setVisibility(0);
        this.f181939k0.setVisibility(8);
        if (this.f181943n0 == null) {
            IVasKuiklyNestPageFrame.b newFrame = ((IVasKuiklyNestPageFrame) QRoute.api(IVasKuiklyNestPageFrame.class)).newFrame("vas_troop_nick_height", new Function0() { // from class: com.tencent.mobileqq.activity.editservice.j
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    String d06;
                    d06 = EditTroopMemberNickService.d0(str);
                    return d06;
                }
            });
            this.f181943n0 = newFrame;
            newFrame.a("vas_troop_nick_shop_list_click", new IVasKuiklyNestPageFrame.a() { // from class: com.tencent.mobileqq.activity.editservice.k
                @Override // com.tencent.mobileqq.vas.api.IVasKuiklyNestPageFrame.a
                public final void handle(String str2, JSONObject jSONObject) {
                    EditTroopMemberNickService.this.e0(str2, jSONObject);
                }
            });
            viewGroup.post(new Runnable() { // from class: com.tencent.mobileqq.activity.editservice.l
                @Override // java.lang.Runnable
                public final void run() {
                    EditTroopMemberNickService.this.f0(viewGroup);
                }
            });
        }
    }

    private void u0() {
        boolean z16;
        int i3;
        int i16;
        int i17;
        int i18;
        H();
        TroopInfo findTroopInfo = ((ITroopInfoService) this.f181927d.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(this.J);
        if (findTroopInfo != null) {
            this.P = findTroopInfo.groupCardPrefix;
            PresetWordFlowLayout presetWordFlowLayout = this.f181935h0;
            int i19 = 8;
            if (presetWordFlowLayout != null) {
                if (R(findTroopInfo)) {
                    i18 = 0;
                } else {
                    i18 = 8;
                }
                presetWordFlowLayout.setVisibility(i18);
                m0();
            }
            String str = findTroopInfo.groupCardPrefixIntro;
            this.Q = str;
            TextView textView = this.f181937i0;
            if (textView != null) {
                if (TextUtils.isEmpty(str)) {
                    i17 = 8;
                } else {
                    i17 = 0;
                }
                textView.setVisibility(i17);
                this.f181937i0.setText(this.Q);
            }
            if (this.P.isEmpty() && TextUtils.isEmpty(this.Q)) {
                z16 = false;
            } else {
                z16 = true;
            }
            LinearLayout linearLayout = this.f181933g0;
            if (linearLayout != null) {
                if (z16) {
                    i16 = 0;
                } else {
                    i16 = 8;
                }
                linearLayout.setVisibility(i16);
            }
            boolean isOwnerOrAdmin = findTroopInfo.isOwnerOrAdmin(this.f181927d.getCurrentAccountUin());
            ImageView imageView = this.f181938j0;
            if (imageView != null) {
                if (z16 && isOwnerOrAdmin) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                imageView.setVisibility(i3);
            }
            TextView textView2 = this.D;
            if (textView2 != null) {
                if (!z16 && isOwnerOrAdmin) {
                    i19 = 0;
                }
                textView2.setVisibility(i19);
            }
        }
    }

    protected void U() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        String str = this.G;
        if (str != null && str.length() > 0) {
            if (s0()) {
                this.f181936i.setText(this.G);
            } else {
                this.f181936i.setText(com.tencent.mobileqq.vas.f.o(this.G));
            }
        }
        int i3 = this.H;
        if (i3 > 0) {
            EditText editText = this.f181936i;
            if (editText instanceof ColorClearableEditText) {
                ((ColorClearableEditText) editText).setCustomCloth(i3, true);
            }
        }
        if (s0()) {
            S();
        }
        if (AppSetting.f99565y) {
            this.f181936i.setAccessibilityDelegate(new o());
        }
    }

    public void V() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.f181939k0 = (ShopLayout) K(R.id.f1041162f);
        ViewGroup viewGroup = (ViewGroup) K(R.id.f1041262g);
        if ((viewGroup == null || !Z(viewGroup)) && this.f181939k0 != null && !TextUtils.isEmpty(this.J)) {
            this.f181939k0.setEnableScroll(false);
            this.f181939k0.setHideInputmethod(new l());
            this.f181939k0.f().B(new m());
            if (VasToggle.isEnable("vas_troop_nick_new_request", true)) {
                this.f181939k0.setRequest(new TroopNickNewRequest(50, Long.parseLong(this.J), this.f181939k0.f()));
            } else {
                this.f181939k0.setRequest(new TroopNickRequest(50, Long.parseLong(this.J), this.f181939k0.f()));
            }
            ShopLayout shopLayout = this.f181939k0;
            if (shopLayout != null) {
                shopLayout.setShopCallback(new n());
                this.f181939k0.setAppId(50);
            }
        }
    }

    void X() {
        U();
        if (Y()) {
            VasWebviewUtil.reportCommercialDrainage(this.f181927d.getCurrentUin(), "group_nickname", "uv", "", 1, 0, 0, "", "", "");
        }
        if (s0()) {
            this.f181936i.setEditableFactory(com.tencent.mobileqq.text.e.f292679e);
            this.f181936i.setOnClickListener(this);
            this.W = (RelativeLayout) K(R.id.f164837b22);
            this.Y = (RecyclerView) K(R.id.b1n);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f181929e, 3);
            this.Z = gridLayoutManager;
            this.Y.setLayoutManager(gridLayoutManager);
            com.tencent.mobileqq.vas.e eVar = new com.tencent.mobileqq.vas.e(this.f181929e, this.f181945p0);
            this.f181924a0 = eVar;
            this.Y.setAdapter(eVar);
            this.Y.addOnScrollListener(this.B0);
            RelativeLayout relativeLayout = (RelativeLayout) K(R.id.b1k);
            this.R = relativeLayout;
            relativeLayout.setVisibility(0);
            ImageView imageView = (ImageView) K(R.id.b1l);
            this.V = imageView;
            imageView.setOnClickListener(this);
            ImageView imageView2 = (ImageView) K(R.id.b1o);
            this.U = imageView2;
            imageView2.setOnClickListener(this);
            this.X = (RelativeLayout) K(R.id.b1p);
            this.S = (TextView) K(R.id.f164836b21);
            TextView textView = (TextView) K(R.id.b1z);
            this.T = textView;
            textView.setOnClickListener(this);
            this.f181926c0 = (RelativeLayout) K(R.id.b1v);
            ImageView imageView3 = (ImageView) K(R.id.b1t);
            this.f181932f0 = imageView3;
            imageView3.setOnClickListener(this);
            this.f181928d0 = (ColorNickTextView) K(R.id.b1w);
            TextView textView2 = (TextView) K(R.id.b1u);
            this.f181930e0 = textView2;
            textView2.setOnClickListener(this);
            T(false);
            p0(0);
            String string = this.f181927d.getPreferences().getString("color_nick_last_edit", "");
            if (TextUtils.isEmpty(string)) {
                this.f181926c0.setVisibility(8);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("ColorNick", 2, String.format("showing last nick and clear saved color nick.", new Object[0]));
                }
                this.f181926c0.setVisibility(0);
                SpannableString j3 = new com.tencent.mobileqq.text.c(string, 16).j();
                this.f181928d0.setText(j3);
                com.tencent.mobileqq.vas.f.r(this.f181927d, this.f181928d0, j3, this.H, true);
                q0(true);
            }
            EditText editText = this.f181936i;
            if (editText instanceof ColorClearableEditText) {
                ((ColorClearableEditText) editText).setTextClearedListener(this.f181948s0);
            }
            V();
            this.V.setVisibility(8);
            n0();
        } else if (P(null)) {
            this.f181936i.setText("");
        }
        Selection.setSelection(this.f181936i.getEditableText(), this.f181936i.getText().length());
        W();
        ReportController.o(this.f181927d, "dc00899", "Grp_set", "", "nickname edit", "nickname edit_exp", 0, 0, String.valueOf(this.J), "", "", "");
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public View.OnClickListener a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (View.OnClickListener) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public void b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
            return;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    i0();
                    return;
                }
                return;
            }
            k0();
            return;
        }
        l0();
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public void c(ViewGroup viewGroup, EditText editText, ViewGroup viewGroup2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, viewGroup, editText, viewGroup2);
            return;
        }
        this.f181934h = viewGroup;
        this.f181936i = editText;
        try {
            LayoutInflater.from(this.f181929e).inflate(R.layout.f169151i02, viewGroup2, true);
            if (viewGroup != null && viewGroup2 != null) {
                X();
            } else {
                QLog.e("EditTroopMemberNickService", 1, "initUI error! root or viewExpand is null!");
            }
        } catch (Exception e16) {
            QLog.e("EditTroopMemberNickService", 1, "initUI excption" + e16);
        }
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        return L();
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void delete() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            com.tencent.mobileqq.text.TextUtils.backspace(this.f181936i);
        }
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public EmoticonCallback e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (EmoticonCallback) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void emoticonMall() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public Intent f(Intent intent) {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (Intent) iPatchRedirector.redirect((short) 18, (Object) this, (Object) intent);
        }
        intent.putExtra("count_type", 2);
        this.G = intent.getStringExtra(AppConstants.Key.SHARE_REQ_DEFAULT_COMMENT);
        this.H = intent.getIntExtra("default_nick_id", 0);
        this.J = intent.getStringExtra("troopUin");
        this.K = intent.getStringExtra("uin");
        this.I = intent.getIntExtra("from", -1);
        this.L = intent.getIntExtra("edit_action", 0);
        boolean booleanExtra = intent.getBooleanExtra("auto_remark", false);
        this.f181941m = booleanExtra;
        if (booleanExtra && (qQAppInterface = this.f181927d) != null && qQAppInterface.getCurrentAccountUin() != null && this.K != null && !this.f181927d.getCurrentAccountUin().equals(this.K) && TextUtils.isEmpty(this.G)) {
            com.tencent.mobileqq.troop.api.handler.f fVar = (com.tencent.mobileqq.troop.api.handler.f) this.f181927d.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_INFO_HANDLER);
            if (fVar != null) {
                fVar.x(this.K);
            }
            this.C = true;
        }
        return intent;
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public void g(com.tencent.mobileqq.troop.activity.editinfo.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) aVar);
            return;
        }
        this.f181927d = (QQAppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
        this.f181931f = aVar;
        this.f181929e = aVar.getContext();
        this.f181927d.addObserver(this.f181944o0);
        this.f181927d.addObserver(this.A0);
    }

    protected void g0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        VasWebviewUtil.reportCommercialDrainage(this.f181927d.getCurrentUin(), "group_nickname", "group_nickname_8", "", 1, 0, 0, "", "", "");
        if (QLog.isColorLevel()) {
            QLog.d("ColorNick", 2, "onBackEvent. save colorNick");
        }
        q0(false);
        this.f181931f.onFinish();
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public TextView.OnEditorActionListener h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (TextView.OnEditorActionListener) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return new f();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) message)).booleanValue();
        }
        switch (message.what) {
            case 257:
                IEmoticonMainPanel iEmoticonMainPanel = this.f181925b0;
                if (iEmoticonMainPanel != null) {
                    iEmoticonMainPanel.setSecondTabInited(false);
                    this.f181925b0.switchTabMode(0);
                    return true;
                }
                return true;
            case 258:
                S();
                return true;
            case 259:
                if (QLog.isColorLevel()) {
                    QLog.d("ColorNick", 2, String.format("MSG_TYPE_CLEAR_COLOR_NICK. saveColorNick", new Object[0]));
                }
                q0(false);
                U();
                return true;
            case 260:
                com.tencent.mobileqq.vas.f.h(this.f181927d).f309062e.a(this.f181953x0);
                IEmoticonMainPanel iEmoticonMainPanel2 = this.f181925b0;
                if (iEmoticonMainPanel2 != null) {
                    iEmoticonMainPanel2.init(this.f181927d, 100001, this.f181929e, O(), null, null, false, com.tencent.mobileqq.vas.f.h(this.f181927d).f309062e);
                    return true;
                }
                return true;
            default:
                return true;
        }
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public com.tencent.mobileqq.widget.navbar.a i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (com.tencent.mobileqq.widget.navbar.a) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return new e();
    }

    protected void i0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        QLog.i("EditTroopMemberNickService", 1, "[onDestroy] ");
        o0();
        this.f181927d.removeObserver(this.f181944o0);
        this.f181927d.removeObserver(this.A0);
        Handler handler = this.f181940l0;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        IEmoticonMainPanel iEmoticonMainPanel = this.f181925b0;
        if (iEmoticonMainPanel != null) {
            iEmoticonMainPanel.onDestory();
        }
        this.f181927d.removeObserver(this.f181955z0);
        com.tencent.mobileqq.vas.f.h(this.f181927d).f309063f = null;
        IVasKuiklyNestPageFrame.b bVar = this.f181943n0;
        if (bVar != null) {
            bVar.detachView();
        }
    }

    protected void k0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        IVasKuiklyNestPageFrame.b bVar = this.f181943n0;
        if (bVar != null) {
            bVar.pause();
        }
    }

    protected void l0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        ShopLayout shopLayout = this.f181939k0;
        if (shopLayout != null) {
            shopLayout.j();
        }
        IVasKuiklyNestPageFrame.b bVar = this.f181943n0;
        if (bVar != null) {
            bVar.resume();
        }
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else if (i3 == 1) {
            u0();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.b1l) {
                if (this.f181954y0 == 2) {
                    str2 = "2";
                } else {
                    str2 = "1";
                }
                if (this.f181946q0) {
                    this.f181947r0 = 2;
                    this.f181931f.hideInputMethod();
                } else {
                    I(2);
                }
                VasWebviewUtil.reportCommercialDrainage(this.f181927d.getCurrentUin(), "group_nickname", "group_nickname_6", "", 1, 0, 0, "", str2, "");
            } else if (id5 == R.id.b1o) {
                if (this.f181954y0 == 1) {
                    str = "2";
                } else {
                    str = "1";
                }
                if (this.f181946q0) {
                    this.f181947r0 = 1;
                    this.f181931f.hideInputMethod();
                } else {
                    I(1);
                }
                VasWebviewUtil.reportCommercialDrainage(this.f181927d.getCurrentUin(), "group_nickname", "group_nickname_5", "", 1, 0, 0, "", str, "");
            } else if (id5 == R.id.b1z) {
                VasH5PayUtil.openH5Pay(this.f181929e, "mvip.g.a.qnc_kt", "CJCLUBT", -1, false, true);
                VasWebviewUtil.reportCommercialDrainage(this.f181927d.getCurrentUin(), "group_nickname", "group_nickname_3", "", 1, 0, 0, "", "", "");
            } else if (id5 == R.id.b1t) {
                this.f181926c0.setVisibility(8);
            } else if (id5 == R.id.b1u) {
                SpannableString j3 = new com.tencent.mobileqq.text.c(this.f181928d0.getText().toString(), 32).j();
                this.f181936i.setText(j3);
                com.tencent.mobileqq.vas.f.q(this.f181927d, this.f181936i, j3);
                this.f181926c0.setVisibility(8);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void onHidePopup(EmoticonInfo emoticonInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) emoticonInfo);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public boolean onLongClick(EmoticonInfo emoticonInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) emoticonInfo)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void onShowPopup(EmoticonInfo emoticonInfo, EmoticonInfo emoticonInfo2, Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, emoticonInfo, emoticonInfo2, drawable);
        }
    }

    @Override // com.tencent.mobileqq.troop.activity.editinfo.b
    public void onTextChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        EditText editText = this.f181936i;
        if (editText instanceof ColorClearableEditText) {
            ((ColorClearableEditText) editText).l();
        }
    }

    void q0(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("ColorNick", 2, "saveColorNick. clear = " + z16);
        }
        if (z16) {
            this.f181927d.getPreferences().edit().putString("color_nick_last_edit", "").commit();
        }
        if (!z16 && P(null) && this.f181950u0 && !this.f181936i.getText().toString().equals(this.G)) {
            if (QLog.isColorLevel()) {
                QLog.d("ColorNick", 2, "saveColorNick. save currentText!");
            }
            this.f181927d.getPreferences().edit().putString("color_nick_last_edit", this.f181936i.getText().toString()).commit();
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void send() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, (Object) this);
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void setting() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void send(EmoticonInfo emoticonInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) emoticonInfo);
            return;
        }
        EditText editText = this.f181936i;
        if (editText instanceof ColorClearableEditText) {
            this.f181950u0 = true;
            if (emoticonInfo instanceof SystemAndEmojiEmoticonInfo) {
                SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) emoticonInfo;
                if (systemAndEmojiEmoticonInfo.code == -1) {
                    return;
                }
                this.f181936i.getEditableText().replace(editText.getSelectionStart(), this.f181936i.getSelectionEnd(), com.tencent.mobileqq.text.TextUtils.getColorNickSysEmoticonString(systemAndEmojiEmoticonInfo.code));
                this.f181936i.requestFocus();
                return;
            }
            if (emoticonInfo instanceof ISmallEmoticonInfo) {
                com.tencent.mobileqq.vas.f.c((ISmallEmoticonInfo) emoticonInfo, this.f181927d, editText);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String d0(String str) {
        return str;
    }
}
