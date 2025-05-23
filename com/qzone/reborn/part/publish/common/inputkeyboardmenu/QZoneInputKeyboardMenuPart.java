package com.qzone.reborn.part.publish.common.inputkeyboardmenu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.lifecycle.Observer;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.QZoneFontPanel;
import com.qzone.common.activities.base.QZoneFontTabView;
import com.qzone.common.activities.base.aj;
import com.qzone.common.friend.business.model.Friend;
import com.qzone.publish.ui.model.PersonalFontData;
import com.qzone.reborn.base.k;
import com.qzone.reborn.part.publish.common.inputkeyboardmenu.e;
import com.qzone.util.ar;
import com.qzone.util.l;
import com.qzone.widget.ExtendEditText;
import com.qzone.widget.RapidCommentEmoView;
import com.qzone.widget.RedDotImageView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.api.QZoneContant;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes37.dex */
public class QZoneInputKeyboardMenuPart extends k {
    private static final String T = "QZoneInputKeyboardMenuPart";
    private int C;
    private String D;
    private int E;
    private boolean F;
    public ArrayList<Friend> G;
    private Runnable H;
    private InputMethodManager I;
    private com.qzone.reborn.part.publish.common.inputarea.d J;
    private com.qzone.reborn.part.publish.common.inputkeyboardmenu.d K;
    private ExtendEditText L;
    private com.qzone.reborn.part.publish.common.inputkeyboardmenu.e M;
    private String N;
    private QZoneFontTabView P;
    private RedDotImageView Q;
    private Runnable R;
    private final EmoticonCallback S;

    /* renamed from: d, reason: collision with root package name */
    private com.qzone.reborn.part.publish.common.inputkeyboardmenu.a f58582d;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f58583e;

    /* renamed from: f, reason: collision with root package name */
    protected ImageView f58584f;

    /* renamed from: h, reason: collision with root package name */
    protected RapidCommentEmoView f58585h;

    /* renamed from: i, reason: collision with root package name */
    protected ImageView f58586i;

    /* renamed from: m, reason: collision with root package name */
    private int f58587m;

    /* loaded from: classes37.dex */
    class a implements EmoticonCallback {
        a() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void delete() {
            ExtendEditText extendEditText = QZoneInputKeyboardMenuPart.this.L;
            if (extendEditText == null || extendEditText.getSelectionStart() == 0) {
                return;
            }
            try {
                Editable text = extendEditText.getText();
                int selectionStart = extendEditText.getSelectionStart();
                int offsetBefore = TextUtils.getOffsetBefore(extendEditText.getText(), selectionStart);
                if (selectionStart != offsetBefore) {
                    text.delete(Math.min(selectionStart, offsetBefore), Math.max(selectionStart, offsetBefore));
                }
            } catch (Exception e16) {
                RFWLog.fatal(QZoneInputKeyboardMenuPart.T, RFWLog.USR, e16);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public boolean onLongClick(EmoticonInfo emoticonInfo) {
            return true;
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send(EmoticonInfo emoticonInfo) {
            ExtendEditText extendEditText = QZoneInputKeyboardMenuPart.this.L;
            if (extendEditText == null || extendEditText.getEditableText() == null) {
                RFWLog.d(QZoneInputKeyboardMenuPart.T, RFWLog.USR, "emoticonCallback, send, currentForceEdit is null or getEditableText is null ");
                return;
            }
            Editable editableText = extendEditText.getEditableText();
            if (emoticonInfo instanceof SystemEmoticonInfo) {
                int selectionStart = extendEditText.getSelectionStart();
                int selectionEnd = extendEditText.getSelectionEnd();
                if (selectionStart < 0 || selectionEnd < 0 || selectionEnd < selectionStart) {
                    return;
                }
                if (emoticonInfo.type == 1) {
                    editableText.replace(selectionStart, selectionEnd, com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(((SystemEmoticonInfo) emoticonInfo).code));
                } else {
                    editableText.replace(selectionStart, selectionEnd, com.tencent.mobileqq.text.TextUtils.getEmojiString(((SystemEmoticonInfo) emoticonInfo).code));
                }
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void emoticonMall() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void setting() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onHidePopup(EmoticonInfo emoticonInfo) {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onShowPopup(EmoticonInfo emoticonInfo, EmoticonInfo emoticonInfo2, Drawable drawable) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class b implements Observer<ExtendEditText> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(ExtendEditText extendEditText) {
            RFWLog.d(QZoneInputKeyboardMenuPart.T, RFWLog.USR, "initEditText, onChanged, editText: " + extendEditText);
            if (extendEditText != null) {
                QZoneInputKeyboardMenuPart.this.L = extendEditText;
                QZoneInputKeyboardMenuPart qZoneInputKeyboardMenuPart = QZoneInputKeyboardMenuPart.this;
                qZoneInputKeyboardMenuPart.Ka(qZoneInputKeyboardMenuPart.L);
                QZoneInputKeyboardMenuPart.this.ja(extendEditText);
                QZoneInputKeyboardMenuPart.this.ia();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class c implements QZoneFontPanel.e {
        c() {
        }

        @Override // com.qzone.common.activities.base.QZoneFontPanel.e
        public void a(PersonalFontData.FontInfo fontInfo) {
            QZoneInputKeyboardMenuPart qZoneInputKeyboardMenuPart = QZoneInputKeyboardMenuPart.this;
            qZoneInputKeyboardMenuPart.Ka(qZoneInputKeyboardMenuPart.L);
            QZoneInputKeyboardMenuPart.this.oa();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QZoneInputKeyboardMenuPart.this.P.getVisibility() == 0) {
                QZoneInputKeyboardMenuPart.this.Q.setContentDescription(l.a(R.string.p3t));
                QZoneInputKeyboardMenuPart qZoneInputKeyboardMenuPart = QZoneInputKeyboardMenuPart.this;
                qZoneInputKeyboardMenuPart.Ka(qZoneInputKeyboardMenuPart.L);
                QZoneInputKeyboardMenuPart.this.oa();
            } else {
                QZoneInputKeyboardMenuPart.this.Q.setContentDescription(l.a(R.string.p3w));
                QZoneInputKeyboardMenuPart.this.Ja();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class f implements e.a {
        f() {
        }

        @Override // com.qzone.reborn.part.publish.common.inputkeyboardmenu.e.a
        public void onSoftKeyboardClosed() {
            RFWLog.d(QZoneInputKeyboardMenuPart.T, RFWLog.USR, "initContainer, onSoftKeyboardClosed ");
            Integer value = QZoneInputKeyboardMenuPart.this.K.L1().getValue();
            if (value != null && value.intValue() == 2) {
                if (QZoneInputKeyboardMenuPart.this.H != null) {
                    QZoneInputKeyboardMenuPart.this.H.run();
                }
            } else if (value != null && value.intValue() == 3 && QZoneInputKeyboardMenuPart.this.R != null) {
                QZoneInputKeyboardMenuPart.this.R.run();
            }
            if (value == null || value.intValue() == 1 || value.intValue() == 0) {
                QZoneInputKeyboardMenuPart.this.Ha(false);
                QZoneInputKeyboardMenuPart.this.broadcastMessage("keyboard_hide", null);
                QZoneInputKeyboardMenuPart.this.K.L1().postValue(0);
            }
        }

        @Override // com.qzone.reborn.part.publish.common.inputkeyboardmenu.e.a
        public void onSoftKeyboardOpened(int i3) {
            RFWLog.d(QZoneInputKeyboardMenuPart.T, RFWLog.USR, "initContainer, onSoftKeyboardOpened, keyboardHeightInPx: " + i3 + ", mCurrentFocusEditText: " + QZoneInputKeyboardMenuPart.this.L);
            if (QZoneInputKeyboardMenuPart.this.L != null) {
                QZoneInputKeyboardMenuPart.this.La(i3);
                QZoneInputKeyboardMenuPart.this.Ha(true);
            } else {
                QZoneInputKeyboardMenuPart.this.Ha(false);
            }
            QZoneInputKeyboardMenuPart.this.K.L1().postValue(1);
            QZoneInputKeyboardMenuPart.this.H = null;
            QZoneInputKeyboardMenuPart.this.R = null;
            QZoneInputKeyboardMenuPart.this.ra();
            QZoneInputKeyboardMenuPart.this.broadcastMessage("input_menu_open", null);
        }
    }

    public QZoneInputKeyboardMenuPart() {
        this(new com.qzone.reborn.part.publish.common.inputkeyboardmenu.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Aa(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Integer.toHexString(view.getId());
        qa(false, this.L);
        za();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ba(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ExtendEditText extendEditText = this.L;
        if (extendEditText != null) {
            if (wa()) {
                na();
                Ka(extendEditText);
            } else {
                Ia();
                qa(false, extendEditText);
            }
        } else {
            Ha(false);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ea() {
        this.D = "";
        this.f58587m = -1;
        this.C = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ha(boolean z16) {
        LinearLayout linearLayout = this.f58583e;
        if (linearLayout != null) {
            linearLayout.setVisibility(z16 ? 0 : 8);
        }
    }

    private void Ia() {
        this.H = new Runnable() { // from class: com.qzone.reborn.part.publish.common.inputkeyboardmenu.QZoneInputKeyboardMenuPart.8
            @Override // java.lang.Runnable
            public void run() {
                QZoneInputKeyboardMenuPart qZoneInputKeyboardMenuPart = QZoneInputKeyboardMenuPart.this;
                if (qZoneInputKeyboardMenuPart.f58585h == null || qZoneInputKeyboardMenuPart.f58584f == null) {
                    return;
                }
                qZoneInputKeyboardMenuPart.La(0);
                QZoneInputKeyboardMenuPart.this.f58585h.setVisibility(0);
                QZoneInputKeyboardMenuPart.this.f58585h.l();
                QZoneInputKeyboardMenuPart.this.f58584f.setImageResource(R.drawable.qui_keyboard_circle);
            }
        };
        Integer value = this.K.L1().getValue();
        if (value != null && value.intValue() != 0 && value.intValue() != 1) {
            this.H.run();
        }
        this.K.L1().postValue(2);
        oa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ka(View view) {
        RFWLog.d(T, RFWLog.USR, "showKeyboard ");
        if (ma() == null || view == null) {
            return;
        }
        ma().showSoftInput(view, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void La(int i3) {
        ViewGroup.LayoutParams layoutParams = this.f58583e.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = i3;
        }
        this.f58583e.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ia() {
        ViewStub viewStub;
        com.qzone.reborn.part.publish.common.inputkeyboardmenu.a aVar = this.f58582d;
        if (aVar == null || !aVar.b() || this.P != null || (viewStub = (ViewStub) getPartRootView().findViewById(R.id.f68573ge)) == null) {
            return;
        }
        QZoneFontTabView qZoneFontTabView = (QZoneFontTabView) viewStub.inflate();
        this.P = qZoneFontTabView;
        qZoneFontTabView.o(getActivity(), getHostFragment(), this.L, LoginData.getInstance().getUin());
        this.P.setOrientation(1);
        this.P.setVisibility(8);
        RedDotImageView redDotImageView = (RedDotImageView) getPartRootView().findViewById(R.id.hrr);
        this.Q = redDotImageView;
        redDotImageView.setContentDescription(l.a(R.string.p3v));
        this.Q.setVisibility(0);
        this.Q.setOffSet(ar.e(6.0f), 0);
        this.P.e(false);
        this.P.setFontItemClickListener(new c());
        Fa();
        this.J.Z1(this.P);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ja(ExtendEditText extendEditText) {
        extendEditText.addTextChangedListener(new e(extendEditText));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int la(CharSequence charSequence, int i3) {
        return aj.e(charSequence, i3, this.E, this.G, this.f58587m, this.C, this.D);
    }

    private InputMethodManager ma() {
        if (this.I == null) {
            this.I = (InputMethodManager) getActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        }
        return this.I;
    }

    private boolean na() {
        if (this.f58585h == null || this.f58584f == null || !wa()) {
            return false;
        }
        this.f58585h.setVisibility(8);
        this.f58584f.setImageResource(R.drawable.qui_emoticon);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qa(boolean z16, View view) {
        RFWLog.d(T, RFWLog.USR, "hideKeyboard ");
        if (ma() == null || view == null || !ma().hideSoftInputFromWindow(view.getWindowToken(), 0)) {
            return false;
        }
        if (z16) {
            view.clearFocus();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ra() {
        na();
        oa();
    }

    private void ua() {
        this.J.R1().observe(getPartHost().getLifecycleOwner(), new b());
    }

    private boolean wa() {
        RapidCommentEmoView rapidCommentEmoView = this.f58585h;
        return rapidCommentEmoView != null && rapidCommentEmoView.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xa(String str, boolean z16) {
        return aj.j(str, z16, this.G, this.f58587m, this.C, this.D);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void za() {
        if (com.qzone.reborn.util.e.b(T + "jumpSelectMemberPage", 500L)) {
            return;
        }
        Intent intent = new Intent();
        if (TextUtils.isEmpty(this.N)) {
            intent.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_FRIENDS, true);
        } else {
            intent.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_TROOP_MEMBER, true);
            intent.putExtra(ISelectMemberActivityConstants.PARAM_DONOT_NEED_CONTACTS, true);
            intent.putExtra("group_uin", this.N);
            intent.putExtra(ISelectMemberActivityConstants.PARAM_GROUPCODE, this.N);
        }
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MIN, 1);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, QZoneConfigHelper.L());
        ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(getActivity(), intent, QZoneContant.QZ_SEARCH_LOCAL_REQUEST_CODE);
    }

    protected void Fa() {
        RedDotImageView redDotImageView = this.Q;
        if (redDotImageView == null) {
            return;
        }
        redDotImageView.setOnClickListener(new d());
    }

    public void Ga(String str) {
        this.N = str;
    }

    protected void Ja() {
        QZoneFontTabView qZoneFontTabView = this.P;
        if (qZoneFontTabView == null || this.Q == null || qZoneFontTabView.getVisibility() == 0) {
            return;
        }
        this.R = new Runnable() { // from class: com.qzone.reborn.part.publish.common.inputkeyboardmenu.QZoneInputKeyboardMenuPart.5
            @Override // java.lang.Runnable
            public void run() {
                QZoneInputKeyboardMenuPart.this.La(0);
                QZoneInputKeyboardMenuPart.this.P.y();
                long j3 = LocalMultiProcConfig.getLong(LocalMultiProcConfig.QZONE_FONT_RED_DOT, -1L);
                long O = QZoneInputKeyboardMenuPart.this.P.f45368i.O();
                if (QZoneInputKeyboardMenuPart.this.Q.f() && O > j3) {
                    LocalMultiProcConfig.putLong(LocalMultiProcConfig.QZONE_FONT_RED_DOT, O);
                }
                QZoneInputKeyboardMenuPart.this.Q.setImageResource(R.drawable.qui_keyboard_circle);
                QZoneInputKeyboardMenuPart.this.Q.h(false);
            }
        };
        Integer value = this.K.L1().getValue();
        if (value != null && value.intValue() != 0 && value.intValue() != 1) {
            this.R.run();
        }
        this.K.L1().postValue(3);
        na();
        qa(false, this.L);
        this.L.requestFocus();
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return T;
    }

    public void ha(ArrayList<ResultRecord> arrayList) {
        if (this.L == null) {
            return;
        }
        if (this.G == null) {
            this.G = new ArrayList<>();
        }
        if (this.F) {
            int selectionStart = this.L.getSelectionStart();
            Editable editableText = this.L.getEditableText();
            if (editableText != null && !TextUtils.isEmpty(editableText.toString())) {
                int i3 = selectionStart - 1;
                if (editableText.toString().charAt(i3) == '@') {
                    editableText.delete(i3, selectionStart);
                }
            }
            this.F = false;
        }
        this.E = aj.c(this.L, arrayList, this.G, this.E);
        this.J.Q1().postValue(this.G);
        Ka(this.L);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if (TextUtils.equals(str, "close_input_panel")) {
            pa();
        }
    }

    protected boolean oa() {
        QZoneFontTabView qZoneFontTabView = this.P;
        if (qZoneFontTabView == null || this.Q == null || qZoneFontTabView.getVisibility() != 0) {
            return false;
        }
        this.P.n();
        this.Q.setImageResource(R.drawable.qui_aa_method);
        return true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i3 != 20221) {
            return;
        }
        Ca(i16, intent);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        ta(view);
        va(view);
        sa(view);
        ua();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        this.K = (com.qzone.reborn.part.publish.common.inputkeyboardmenu.d) getViewModel(com.qzone.reborn.part.publish.common.inputkeyboardmenu.d.class);
        this.J = (com.qzone.reborn.part.publish.common.inputarea.d) getViewModel(com.qzone.reborn.part.publish.common.inputarea.d.class);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        com.qzone.reborn.part.publish.common.inputkeyboardmenu.e eVar = this.M;
        if (eVar != null) {
            eVar.d();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        pa();
    }

    public QZoneInputKeyboardMenuPart(com.qzone.reborn.part.publish.common.inputkeyboardmenu.a aVar) {
        this.f58587m = -1;
        this.C = -1;
        this.D = "";
        this.F = false;
        this.S = new a();
        this.f58582d = aVar;
    }

    private void pa() {
        Ha(false);
        qa(true, this.L);
    }

    private void Ca(int i3, Intent intent) {
        if (i3 == -1) {
            ArrayList<ResultRecord> parcelableArrayListExtra = intent.getParcelableArrayListExtra(ISelectMemberActivityConstants.PARAM_RESULT_SET);
            Da(parcelableArrayListExtra);
            ha(parcelableArrayListExtra);
            return;
        }
        this.F = false;
    }

    private void sa(View view) {
        this.f58586i = (ImageView) view.findViewById(R.id.hrp);
        if (!this.f58582d.a()) {
            this.f58586i.setVisibility(8);
        } else {
            this.f58586i.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.part.publish.common.inputkeyboardmenu.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    QZoneInputKeyboardMenuPart.this.Aa(view2);
                }
            });
        }
    }

    private void ta(View view) {
        this.f58583e = (LinearLayout) view.findViewById(R.id.f68263fk);
        Ha(false);
        com.qzone.reborn.part.publish.common.inputkeyboardmenu.e eVar = new com.qzone.reborn.part.publish.common.inputkeyboardmenu.e(view);
        this.M = eVar;
        eVar.a(new f());
    }

    private void va(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.f69663jc);
        this.f58584f = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.part.publish.common.inputkeyboardmenu.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    QZoneInputKeyboardMenuPart.this.Ba(view2);
                }
            });
            s5.a.c(this.f58584f, R.color.qui_common_icon_primary);
        }
        try {
            RapidCommentEmoView rapidCommentEmoView = (RapidCommentEmoView) view.findViewById(R.id.f69373ik);
            this.f58585h = rapidCommentEmoView;
            rapidCommentEmoView.j(getActivity(), true, this.S, false, null, false, false, true);
        } catch (Throwable th5) {
            RFWLog.e(T, RFWLog.USR, th5);
        }
    }

    public void Da(ArrayList<ResultRecord> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<ResultRecord> it = arrayList.iterator();
            while (it.hasNext()) {
                ResultRecord next = it.next();
                if (next != null && !TextUtils.isEmpty(next.uin)) {
                    RFWLog.i(T, RFWLog.USR, "at user uin is " + next.uin + " " + next.name);
                } else {
                    RFWLog.e(T, RFWLog.USR, "at user is illegal ");
                }
            }
            return;
        }
        RFWLog.e(T, RFWLog.USR, "at user list is null ");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class e implements TextWatcher {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ExtendEditText f58592d;

        e(ExtendEditText extendEditText) {
            this.f58592d = extendEditText;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            this.f58592d.removeTextChangedListener(this);
            if (charSequence == null) {
                this.f58592d.addTextChangedListener(this);
                QZoneInputKeyboardMenuPart.this.Ea();
                return;
            }
            if (i17 == 1 && i16 == 0 && charSequence.toString().substring(i3, i3 + 1).equals("@")) {
                QZoneInputKeyboardMenuPart qZoneInputKeyboardMenuPart = QZoneInputKeyboardMenuPart.this;
                qZoneInputKeyboardMenuPart.qa(false, qZoneInputKeyboardMenuPart.L);
                QZoneInputKeyboardMenuPart.this.F = true;
                QZoneInputKeyboardMenuPart.this.za();
            }
            QZoneInputKeyboardMenuPart qZoneInputKeyboardMenuPart2 = QZoneInputKeyboardMenuPart.this;
            if (qZoneInputKeyboardMenuPart2.xa(qZoneInputKeyboardMenuPart2.D, true)) {
                this.f58592d.getEditableText().delete(QZoneInputKeyboardMenuPart.this.f58587m, QZoneInputKeyboardMenuPart.this.C);
            }
            QZoneInputKeyboardMenuPart.this.Ea();
            this.f58592d.addTextChangedListener(this);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            if ((i16 == 1 || i16 == 2) && i17 == 0) {
                try {
                    QZoneInputKeyboardMenuPart qZoneInputKeyboardMenuPart = QZoneInputKeyboardMenuPart.this;
                    qZoneInputKeyboardMenuPart.f58587m = qZoneInputKeyboardMenuPart.la(charSequence, i3 + i16);
                    if (QZoneInputKeyboardMenuPart.this.f58587m == -1) {
                        QZoneInputKeyboardMenuPart.this.Ea();
                    } else {
                        QZoneInputKeyboardMenuPart.this.C = i3;
                        QZoneInputKeyboardMenuPart.this.D = charSequence.toString().substring(QZoneInputKeyboardMenuPart.this.f58587m, QZoneInputKeyboardMenuPart.this.C + i16);
                    }
                } catch (Exception unused) {
                    QZoneInputKeyboardMenuPart.this.Ea();
                    return;
                }
            }
            ExtendEditText extendEditText = this.f58592d;
            extendEditText.setBeforeChangeLineCount(extendEditText.getLineCount());
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }
    }
}
