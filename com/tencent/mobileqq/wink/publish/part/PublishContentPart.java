package com.tencent.mobileqq.wink.publish.part;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.publish.view.edittext.ExtendEditText;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.publish.event.PublishChangeTagPanelStateEvent;
import com.tencent.mobileqq.wink.publish.event.PublishContentGetFocusEvent;
import com.tencent.mobileqq.wink.publish.event.PublishKeyboardEvent;
import com.tencent.mobileqq.wink.publish.util.PublishTagCounter;
import com.tencent.mobileqq.wink.publish.util.d;
import com.tencent.mobileqq.wink.publish.viewmodel.PublishTagViewModel;
import com.tencent.mobileqq.wink.publish.viewmodel.PublishViewModel;
import com.tencent.mobileqq.wink.view.WinkSoftKeyboardStateHelper;
import com.tencent.mobileqq.winkpublish.common.UploadConstants;
import com.tencent.mobileqq.winkpublish.model.Friend;
import com.tencent.mobileqq.winkpublish.util.FSToastUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.text.rich.parser.RichTextAtParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import org.apache.httpcore.message.TokenParser;

/* loaded from: classes21.dex */
public class PublishContentPart extends com.tencent.mobileqq.wink.publish.part.j implements View.OnClickListener, SimpleEventReceiver {

    /* renamed from: f0, reason: collision with root package name */
    public static Pattern f325693f0 = Pattern.compile("#[\uff0ca-z0-9A-Z\u4e00-\u9fa5]+");

    /* renamed from: g0, reason: collision with root package name */
    private static final String f325694g0 = UploadConstants.TAG + "QCirclePublishContentPart";

    /* renamed from: h0, reason: collision with root package name */
    private static final int f325695h0 = uq3.c.T3();
    private int D;
    private ExtendEditText E;
    private ExtendEditText F;
    private View G;
    private int H;
    private View I;
    private ImageView J;
    private ImageView K;
    private ImageView L;
    private LinearLayout M;
    private WinkSoftKeyboardStateHelper N;
    private String R;
    private String X;

    /* renamed from: a0, reason: collision with root package name */
    private QQToast f325696a0;

    /* renamed from: b0, reason: collision with root package name */
    private String f325697b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f325698c0;

    /* renamed from: d, reason: collision with root package name */
    private PublishViewModel f325699d;

    /* renamed from: d0, reason: collision with root package name */
    private int f325700d0;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.wink.publish.viewmodel.i f325701e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.wink.publish.viewmodel.n f325703f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.wink.publish.viewmodel.m f325704h;

    /* renamed from: i, reason: collision with root package name */
    private PublishTagViewModel f325705i;

    /* renamed from: m, reason: collision with root package name */
    private InputMethodManager f325706m;
    private boolean C = true;
    private boolean P = false;
    private boolean Q = false;
    private int S = -1;
    private int T = -1;
    private String U = "";
    private int V = 0;
    private boolean W = false;
    private boolean Y = false;
    private boolean Z = false;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f325702e0 = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class a implements Observer<Friends> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Friends friends) {
            PublishContentPart publishContentPart = PublishContentPart.this;
            publishContentPart.V = publishContentPart.Ha(publishContentPart.F, friends, PublishContentPart.this.V);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class b implements Observer<k> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable k kVar) {
            if (!TextUtils.isEmpty(kVar.f325718a)) {
                QLog.d(PublishContentPart.f325694g0, 4, "onChanged... text:", kVar.f325718a);
                PublishContentPart.this.R = kVar.f325718a;
                String wb5 = PublishContentPart.this.wb(kVar.f325718a);
                kVar.f325718a = wb5;
                PublishContentPart.this.V = wb5.length();
                PublishContentPart.this.F.setText(kVar.f325718a);
                PublishContentPart.this.F.setSelection(Math.min(kVar.f325719b, kVar.f325718a.length()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class c implements EmoticonCallback {
        c() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void delete() {
            if (PublishContentPart.this.F.getSelectionStart() == 0) {
                return;
            }
            try {
                Editable text = PublishContentPart.this.F.getText();
                int selectionStart = PublishContentPart.this.F.getSelectionStart();
                int offsetBefore = TextUtils.getOffsetBefore(PublishContentPart.this.F.getText(), selectionStart);
                if (selectionStart != offsetBefore) {
                    text.delete(Math.min(selectionStart, offsetBefore), Math.max(selectionStart, offsetBefore));
                }
            } catch (Exception e16) {
                e16.printStackTrace();
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
            ExtendEditText extendEditText = PublishContentPart.this.Z ? PublishContentPart.this.E : PublishContentPart.this.F;
            if (emoticonInfo instanceof SystemEmoticonInfo) {
                int selectionStart = extendEditText.getSelectionStart();
                int selectionEnd = extendEditText.getSelectionEnd();
                if (selectionStart < 0 || selectionEnd < 0 || selectionEnd < selectionStart) {
                    return;
                }
                extendEditText.getEditableText().replace(selectionStart, selectionEnd, com.tencent.mobileqq.wink.publish.util.b.c(((SystemEmoticonInfo) emoticonInfo).code));
                return;
            }
            if (emoticonInfo instanceof SystemAndEmojiEmoticonInfo) {
                SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) emoticonInfo;
                int selectionStart2 = extendEditText.getSelectionStart();
                int selectionEnd2 = extendEditText.getSelectionEnd();
                int i3 = systemAndEmojiEmoticonInfo.emotionType;
                int i16 = systemAndEmojiEmoticonInfo.code;
                if (selectionStart2 >= 0 && selectionEnd2 >= 0 && selectionEnd2 >= selectionStart2) {
                    if (i3 == 2 && i16 == -1) {
                        return;
                    }
                    extendEditText.getEditableText().replace(selectionStart2, selectionEnd2, com.tencent.mobileqq.wink.publish.util.b.b(i3, i16));
                    extendEditText.requestFocus();
                }
                com.tencent.mobileqq.wink.publish.util.b.a(systemAndEmojiEmoticonInfo);
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
    /* loaded from: classes21.dex */
    public class d implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RelativeLayout f325710d;

        d(RelativeLayout relativeLayout) {
            this.f325710d = relativeLayout;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            boolean isInMultiWindowMode;
            Rect rect = new Rect();
            this.f325710d.getWindowVisibleDisplayFrame(rect);
            int height = rect.height();
            if (Build.VERSION.SDK_INT >= 24) {
                isInMultiWindowMode = PublishContentPart.this.getActivity().isInMultiWindowMode();
                if (isInMultiWindowMode) {
                    PublishContentPart.this.I.setVisibility(8);
                    return;
                }
            }
            if (rect.width() > rect.height()) {
                PublishContentPart.this.I.setVisibility(8);
                return;
            }
            if (PublishContentPart.this.H - height > 150 && height != ViewUtils.getScreenHeightByContext(this.f325710d.getContext()) && height != ViewUtils.getScreenWidthByContext(this.f325710d.getContext())) {
                int i3 = PublishContentPart.this.H - height;
                if (PublishContentPart.this.M != null) {
                    ((RelativeLayout.LayoutParams) PublishContentPart.this.M.getLayoutParams()).bottomMargin = i3;
                }
                PublishContentPart.this.I.requestLayout();
                PublishContentPart.this.I.setVisibility(0);
            } else if (height - PublishContentPart.this.H > 150 && !PublishContentPart.this.Q) {
                PublishContentPart.this.I.setVisibility(8);
            }
            PublishContentPart.this.H = height;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (PublishContentPart.this.G != null) {
                if (!PublishContentPart.this.P) {
                    PublishContentPart.this.Bb();
                } else {
                    PublishContentPart.this.showKeyboard();
                    PublishContentPart.this.Va();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!PublishContentPart.this.kb()) {
                PublishContentPart.this.Ua();
                w53.b.f(PublishContentPart.f325694g0, "onAtClick");
                com.tencent.mobileqq.wink.publish.util.c.e(PublishContentPart.this.getActivity(), true, 1, uq3.c.Z2(), PublishContentPart.this.f325701e.N1(), 1001);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class h implements TextWatcher {
        h() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (PublishContentPart.this.E != null) {
                PublishContentPart publishContentPart = PublishContentPart.this;
                PublishContentPart.this.f325699d.G3(publishContentPart.Ra(publishContentPart.E.getText()));
                return;
            }
            PublishContentPart.this.f325699d.G3(null);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            PublishContentPart.this.f325697b0 = charSequence.toString();
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            if (PublishContentPart.this.E != null) {
                PublishContentPart publishContentPart = PublishContentPart.this;
                if (publishContentPart.Ta(publishContentPart.E) > 20) {
                    QQToast.makeText(RFWApplication.getApplication(), FSToastUtil.ICON_ERROR, "\u6807\u9898\u6700\u591a20\u4e2a\u5b57\u54e6", 0).show();
                    PublishContentPart.this.E.setText(PublishContentPart.this.f325697b0);
                    PublishContentPart.this.E.setSelection(PublishContentPart.this.E.getText().length());
                } else if (charSequence != null && charSequence.toString().contains("\n")) {
                    PublishContentPart.this.E.setText(charSequence.toString().replace("\n", ""));
                    PublishContentPart.this.E.setSelection(PublishContentPart.this.E.getText().length());
                } else {
                    PublishContentPart.this.E.setBeforeChangeLineCount(PublishContentPart.this.E.getLineCount());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class i implements TextWatcher {
        i() {
        }

        public void a(String str, String str2) {
            if (!str.contains(str2)) {
                com.tencent.mobileqq.wink.model.b.f324006a.h(str2, false);
                if (!PublishContentPart.this.f325702e0) {
                    QCircleToast.k(QCircleToast.f91644d, PublishContentPart.this.getContext().getString(R.string.f196664hx), 0, true);
                    PublishContentPart.this.f325702e0 = true;
                    return;
                }
                return;
            }
            com.tencent.mobileqq.wink.model.b.f324006a.h(str2, true);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (QLog.isColorLevel()) {
                QLog.e(PublishContentPart.f325694g0, 1, "afterTextChanged s:xx");
            }
            if (editable != null) {
                if (editable.toString().equals(PublishContentPart.this.X) && PublishContentPart.this.Y) {
                    PublishContentPart.this.Y = false;
                    return;
                }
                PublishContentPart.this.X = editable.toString();
                PublishContentPart.this.Y = true;
                String Ra = PublishContentPart.this.Ra(editable);
                PublishContentPart publishContentPart = PublishContentPart.this;
                String Qa = publishContentPart.Qa(Ra, publishContentPart.f325701e.M1());
                if (PublishContentPart.this.f325699d.L2()) {
                    if (Qa.length() < PublishContentPart.this.f325699d.q2()) {
                        PublishContentPart.this.F.setText(PublishContentPart.this.f325699d.p2());
                        PublishContentPart.this.F.setSelection(PublishContentPart.this.f325699d.q2());
                        return;
                    } else if (Qa.startsWith(PublishContentPart.this.f325699d.p2())) {
                        PublishContentPart.this.f325699d.C3(Qa.substring(PublishContentPart.this.f325699d.q2()).trim());
                    } else {
                        PublishContentPart.this.f325699d.C3(Qa);
                    }
                } else {
                    PublishContentPart.this.f325699d.C3(Qa);
                }
            } else {
                PublishContentPart.this.f325699d.C3(null);
            }
            PublishContentPart.this.yb(editable, this);
            if (editable != null && PublishContentPart.this.f325705i.tagsFromChallenge != null) {
                a(editable.toString(), PublishContentPart.this.f325705i.tagsFromChallenge);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            if (QLog.isColorLevel()) {
                QLog.e(PublishContentPart.f325694g0, 1, "beforeTextChanged: s:xx start:" + i3 + " count:" + i16 + " after:" + i17);
            }
            try {
                if ((i16 != 1 && i16 != 2) || i17 != 0) {
                    PublishContentPart.this.vb();
                } else {
                    PublishContentPart publishContentPart = PublishContentPart.this;
                    publishContentPart.S = publishContentPart.Oa(charSequence, i3 + i16);
                    if (PublishContentPart.this.S == -1) {
                        PublishContentPart.this.vb();
                    } else {
                        PublishContentPart.this.T = i3;
                        PublishContentPart.this.U = charSequence.toString().substring(PublishContentPart.this.S, PublishContentPart.this.T + i16);
                    }
                }
                if (PublishContentPart.this.F != null) {
                    PublishContentPart.this.F.setBeforeChangeLineCount(PublishContentPart.this.F.getLineCount());
                }
            } catch (Exception unused) {
                PublishContentPart.this.vb();
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            if (QLog.isColorLevel()) {
                QLog.e(PublishContentPart.f325694g0, 1, "onTextChanged s:xx start:" + i3 + " count:" + i17 + " before:" + i16);
            }
            if (charSequence != null && charSequence.toString().equals(PublishContentPart.this.X)) {
                return;
            }
            if (charSequence == null) {
                PublishContentPart.this.vb();
                return;
            }
            if (!TextUtils.isEmpty(PublishContentPart.this.R)) {
                PublishContentPart.this.R = null;
                PublishContentPart.this.f325699d.C3(PublishContentPart.this.F.getText().toString());
                PublishViewModel publishViewModel = PublishContentPart.this.f325699d;
                PublishContentPart publishContentPart = PublishContentPart.this;
                publishViewModel.D3(publishContentPart.hb(publishContentPart.F, PublishContentPart.f325695h0));
                return;
            }
            if (PublishContentPart.this.Ma() && i17 == 1 && i16 == 0 && charSequence.toString().substring(i3, i3 + 1).equals("@")) {
                if (!PublishContentPart.this.kb()) {
                    PublishContentPart.this.W = true;
                    w53.b.f(PublishContentPart.f325694g0, "onAtClick");
                    com.tencent.mobileqq.wink.publish.util.c.e(PublishContentPart.this.getActivity(), true, 1, uq3.c.Z2(), PublishContentPart.this.f325701e.N1(), 1001);
                } else {
                    return;
                }
            }
            PublishContentPart publishContentPart2 = PublishContentPart.this;
            if (publishContentPart2.ib(publishContentPart2.U, true)) {
                PublishContentPart.this.F.getEditableText().delete(PublishContentPart.this.S, PublishContentPart.this.T);
            }
            PublishContentPart.this.vb();
            PublishViewModel publishViewModel2 = PublishContentPart.this.f325699d;
            PublishContentPart publishContentPart3 = PublishContentPart.this;
            publishViewModel2.D3(publishContentPart3.hb(publishContentPart3.F, PublishContentPart.f325695h0));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class j implements ExtendEditText.g {
        j() {
        }

        @Override // com.tencent.biz.qqcircle.publish.view.edittext.ExtendEditText.g
        public void a(int i3, int i16) {
            if (!PublishContentPart.this.f325699d.L2()) {
                PublishContentPart.this.f325698c0 = i3;
                PublishContentPart.this.f325700d0 = i16;
                return;
            }
            String obj = PublishContentPart.this.F.getText().toString();
            if (!TextUtils.isEmpty(obj) && obj.startsWith(PublishContentPart.this.f325699d.p2())) {
                int q26 = PublishContentPart.this.f325699d.q2();
                int length = obj.length();
                if (i16 < q26) {
                    PublishContentPart.this.F.setSelection(Math.max(Math.min(PublishContentPart.this.f325698c0, length), q26), Math.max(Math.min(PublishContentPart.this.f325700d0, length), q26));
                } else if (i3 < q26) {
                    PublishContentPart.this.F.setSelection(q26, Math.max(Math.min(i16, length), q26));
                }
                PublishContentPart publishContentPart = PublishContentPart.this;
                publishContentPart.f325698c0 = publishContentPart.F.getSelectionStart();
                PublishContentPart publishContentPart2 = PublishContentPart.this;
                publishContentPart2.f325700d0 = publishContentPart2.F.getSelectionEnd();
            }
        }
    }

    /* loaded from: classes21.dex */
    public static class k {

        /* renamed from: a, reason: collision with root package name */
        public String f325718a;

        /* renamed from: b, reason: collision with root package name */
        public int f325719b;

        public k(String str, int i3) {
            this.f325718a = str;
            this.f325719b = i3;
        }
    }

    private void Ka() {
        ExtendEditText extendEditText = this.F;
        if (extendEditText == null) {
            return;
        }
        extendEditText.addTextChangedListener(new i());
        this.F.setOnSelectionChangedListener(new j());
    }

    private void La() {
        ExtendEditText extendEditText = this.E;
        if (extendEditText == null) {
            return;
        }
        extendEditText.addTextChangedListener(new h());
    }

    public static String Na(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str.toString().replace("\r\n", " ").replace("\n", " "), " ");
        StringBuffer stringBuffer = new StringBuffer();
        while (stringTokenizer.hasMoreTokens()) {
            stringBuffer.append(stringTokenizer.nextToken() + TokenParser.SP);
        }
        return stringBuffer.toString().trim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Oa(CharSequence charSequence, int i3) {
        return Pa(charSequence, i3, this.V, this.f325701e.M1(), this.S, this.T, this.U);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Ra(Editable editable) {
        return com.tencent.mobileqq.wink.publish.util.b.d(com.tencent.mobileqq.wink.publish.util.e.b(editable).replaceAll(HardCodeUtil.qqStr(R.string.f172111ng0), HardCodeUtil.qqStr(R.string.f172113ng2)).replaceAll(HardCodeUtil.qqStr(R.string.nfz), "/MM").replaceAll(HardCodeUtil.qqStr(R.string.f2192465w), "/chigua"));
    }

    public static String Sa(EditText editText) {
        if (editText == null) {
            return "";
        }
        Editable text = editText.getText();
        if (text instanceof QQTextBuilder) {
            return ((QQTextBuilder) text).toPlainText();
        }
        return text.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Ta(EditText editText) {
        if (editText != null) {
            return Na(Sa(editText)).length();
        }
        return 0;
    }

    private void ab(View view) {
        ExtendEditText extendEditText = (ExtendEditText) view.findViewById(R.id.bzb);
        this.E = extendEditText;
        if (extendEditText != null) {
            extendEditText.setOnClickListener(this);
            this.E.setMaxLineToScrollAlways(2);
            this.E.setEditableFactory(com.tencent.mobileqq.wink.publish.util.e.a());
            this.E.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tencent.mobileqq.wink.publish.part.k
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view2, boolean z16) {
                    PublishContentPart.this.mb(view2, z16);
                }
            });
            La();
        }
        this.F = (ExtendEditText) view.findViewById(R.id.bys);
        if (this.f325699d.B2()) {
            this.F.setHint("\u5206\u4eab\u4f60\u7684\u7cbe\u5f69\u7684\u77ac\u95f4");
        } else if (this.f325699d.A2()) {
            this.F.setHint(uq3.c.S3());
        } else {
            this.F.setHint(uq3.c.R3());
        }
        if (this.f325699d.I0) {
            this.F.setMaxLineToScrollAlways(5);
        } else {
            this.F.setMaxLineToScrollAlways(4);
            this.F.setFixedHeight(true);
        }
        this.F.setOnClickListener(this);
        this.F.setEditableFactory(com.tencent.mobileqq.wink.publish.util.e.a());
        Ka();
    }

    private void eb(View view) {
        WinkSoftKeyboardStateHelper winkSoftKeyboardStateHelper = new WinkSoftKeyboardStateHelper(view);
        this.N = winkSoftKeyboardStateHelper;
        winkSoftKeyboardStateHelper.i(new g());
    }

    public static void fb(String str, int i3, EditText editText) {
        if (editText != null && !TextUtils.isEmpty(str) && i3 >= 0) {
            com.tencent.mobileqq.wink.publish.util.e.a().newEditable(editText.getText()).insert(i3, str);
            if (QLog.isColorLevel()) {
                w53.b.f(f325694g0, "insertStrToEdit:xx");
            }
            editText.setSelection(i3 + str.length());
        }
    }

    public static boolean gb(int i3, int i16, String str) {
        if (i3 != -1 && i16 != -1 && str != null && str.length() > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hb(EditText editText, int i3) {
        int Ta = Ta(editText) - i3;
        if (Ta <= 0) {
            return false;
        }
        String str = "\u8d85\u51fa" + Ta + "\u4e2a\u5b57";
        QQToast qQToast = this.f325696a0;
        if (qQToast == null || !qQToast.isShowing()) {
            QQToast makeText = QQToast.makeText(RFWApplication.getApplication(), FSToastUtil.ICON_DEFAULT, str, 0);
            this.f325696a0 = makeText;
            makeText.show();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ib(String str, boolean z16) {
        return jb(str, z16, this.f325701e.M1(), this.S, this.T, this.U);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean kb() {
        boolean z16;
        com.tencent.mobileqq.wink.publish.viewmodel.n nVar = this.f325703f;
        if (nVar != null && !nVar.M1()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QQToast.makeText(getContext(), R.string.f196714i2, 0).show();
        }
        return z16;
    }

    private boolean lb(Editable editable, SpannableStringBuilder spannableStringBuilder) {
        boolean z16;
        try {
            Object[] spans = editable.getSpans(0, editable.length(), ForegroundColorSpan.class);
            Object[] spans2 = spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), ForegroundColorSpan.class);
            if (spans.length == spans2.length) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                for (int i3 = 0; i3 < spans.length; i3++) {
                    Object obj = spans[i3];
                    Object obj2 = spans2[i3];
                    if (obj.getClass() != obj2.getClass() || editable.getSpanStart(obj) != spannableStringBuilder.getSpanStart(obj2) || editable.getSpanEnd(obj) != spannableStringBuilder.getSpanEnd(obj2) || editable.getSpanFlags(obj) != spannableStringBuilder.getSpanFlags(obj2)) {
                        return false;
                    }
                }
            }
            return z16;
        } catch (Exception e16) {
            w53.b.e(f325694g0, e16);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void mb(View view, boolean z16) {
        this.Z = z16;
        ImageView imageView = this.K;
        if (imageView != null) {
            if (z16) {
                imageView.setVisibility(4);
            } else {
                imageView.setVisibility(0);
            }
        }
        Va();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void nb(List list) {
        HashMap<String, String> hashMap;
        if (list == null || list.size() == 0 || this.f325699d.L2()) {
            return;
        }
        ha3.b bVar = (ha3.b) list.get(0);
        sb(bVar);
        rb(bVar);
        if (this.f325703f != null && (hashMap = bVar.f404635t) != null) {
            this.f325703f.N1(Boolean.valueOf("0".equals(hashMap.get("feedType"))));
        }
    }

    private void ob() {
        if (this.f325703f == null) {
            this.f325703f = (com.tencent.mobileqq.wink.publish.viewmodel.n) getViewModel(com.tencent.mobileqq.wink.publish.viewmodel.n.class);
        }
        if (this.f325704h == null) {
            this.f325704h = (com.tencent.mobileqq.wink.publish.viewmodel.m) getViewModel(com.tencent.mobileqq.wink.publish.viewmodel.m.class);
        }
        if (this.f325705i == null) {
            this.f325705i = (PublishTagViewModel) getViewModel(PublishTagViewModel.class);
        }
        this.f325704h.Q1().observe(getHostFragment(), new a());
        this.f325699d.E.observe(getHostFragment(), new b());
        LiveData<List<ha3.b>> liveData = this.f325699d.H;
        if (liveData != null) {
            liveData.observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.publish.part.l
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    PublishContentPart.this.nb((List) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qb() {
        View view = this.G;
        if (view != null && view.getLayoutParams() != null) {
            if (this.D > 0) {
                this.G.getLayoutParams().height = this.D;
            } else {
                this.G.getLayoutParams().height = ViewUtils.dip2px(250.0f);
            }
            this.G.invalidate();
            QLog.d(f325694g0, 1, "mEmojiPanel onGetKeyBoardHeight() :" + this.D);
        }
    }

    private void rb(ha3.b bVar) {
        String str = bVar.f404619d;
        if ((TextUtils.isEmpty(this.F.getText()) || bVar.f404626k == 0) && !TextUtils.isEmpty(str)) {
            k kVar = new k(str, str.length());
            QLog.d(f325694g0, 4, "[mDraftContent] content: ", kVar.f325718a);
            String str2 = kVar.f325718a;
            this.R = str2;
            String wb5 = wb(str2);
            kVar.f325718a = wb5;
            this.V = wb5.length();
            this.F.setText(kVar.f325718a);
            this.F.setSelection(Math.min(kVar.f325719b, kVar.f325718a.length()));
        }
    }

    private void sb(ha3.b bVar) {
        HashMap<String, String> hashMap = bVar.f404635t;
        if (hashMap != null) {
            String str = hashMap.get("title");
            if (this.E != null && !TextUtils.isEmpty(str)) {
                this.E.setText(str);
            }
        }
    }

    public static String tb(String str, String str2, String str3) {
        int indexOf = str.indexOf(str2, 0);
        if (indexOf == -1) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder(str);
        sb5.replace(indexOf, str2.length() + indexOf, str3);
        return sb5.toString();
    }

    public static String ub(String str, String str2, String str3) {
        try {
            return Pattern.compile(str, 16).matcher(str2).replaceFirst(str3);
        } catch (Exception unused) {
            return tb(str2, str, str3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vb() {
        this.U = "";
        this.S = -1;
        this.T = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yb(CharSequence charSequence, TextWatcher textWatcher) {
        boolean z16;
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(charSequence);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(stringBuffer);
        Matcher matcher = f325693f0.matcher(spannableStringBuilder);
        PublishTagCounter.INSTANCE.a().d();
        boolean z17 = false;
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (end - start != 1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(ie0.a.f().g(getContext(), R.color.qui_common_text_link, 1000)), start, end, 33);
                PublishTagCounter.INSTANCE.a().c();
                z17 = true;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Friend friend : this.f325701e.M1()) {
            Matcher matcher2 = Pattern.compile(Pattern.quote("@" + friend.mName)).matcher(spannableStringBuilder);
            boolean z18 = false;
            while (matcher2.find()) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(ie0.a.f().g(getContext(), R.color.qui_common_text_link, 1000)), matcher2.start(), matcher2.end(), 33);
                z17 = true;
                z18 = true;
            }
            if (!z18) {
                arrayList.add(friend);
            }
        }
        if (!arrayList.isEmpty()) {
            this.f325701e.O1(arrayList);
        }
        if (this.f325699d.L2() && charSequence.toString().startsWith(this.f325699d.p2())) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ie0.a.f().g(getContext(), R.color.qui_common_text_link, 1000)), 3, this.f325699d.p2().trim().length(), 33);
            z16 = true;
        } else {
            z16 = z17;
        }
        if (z16 && !lb(this.F.getText(), spannableStringBuilder)) {
            this.F.removeTextChangedListener(textWatcher);
            int selectionStart = this.F.getSelectionStart();
            int selectionEnd = this.F.getSelectionEnd();
            this.F.setText(spannableStringBuilder);
            this.F.setSelection(selectionStart, selectionEnd);
            this.F.addTextChangedListener(textWatcher);
        }
    }

    protected void Ab() {
        ImageView imageView = this.J;
        if (imageView == null) {
            return;
        }
        imageView.setOnClickListener(new e());
        this.L.setOnClickListener(this);
        xb();
    }

    @Override // com.tencent.mobileqq.wink.publish.part.j
    @NonNull
    public String B9() {
        return f325694g0;
    }

    protected void Bb() {
        if (this.G == null || this.Q) {
            return;
        }
        Wa();
        LinearLayout linearLayout = this.M;
        if (linearLayout != null) {
            ((RelativeLayout.LayoutParams) linearLayout.getLayoutParams()).bottomMargin = 0;
        }
        if (this.Z) {
            this.E.requestFocus();
        } else {
            this.F.requestFocus();
        }
        this.Q = true;
        this.G.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.publish.part.PublishContentPart.5
            @Override // java.lang.Runnable
            public void run() {
                if (PublishContentPart.this.G != null && PublishContentPart.this.J != null) {
                    PublishContentPart.this.G.setVisibility(0);
                    PublishContentPart.this.J.setImageResource(R.drawable.m59);
                    PublishContentPart.this.P = true;
                    PublishContentPart.this.Q = false;
                }
            }
        }, 100L);
    }

    public int Ha(EditText editText, Friends friends, int i3) {
        if (friends == null) {
            return i3;
        }
        Friend friend = new Friend();
        if (!TextUtils.isEmpty(friends.remark)) {
            friend.mName = friends.remark;
        } else if (!TextUtils.isEmpty(friends.name)) {
            friend.mName = friends.name;
        } else {
            friend.mName = friends.uin;
        }
        try {
            long longValue = Long.valueOf(friends.uin).longValue();
            friend.mUin = longValue;
            if (friend.mName != null && longValue != 0) {
                this.f325701e.L1(friend);
                String str = "@" + friend.mName + " ";
                if (i3 < str.length()) {
                    i3 = str.length();
                }
                fb(str, editText.getSelectionStart(), editText);
            }
            return i3;
        } catch (NumberFormatException e16) {
            w53.b.e(f325694g0, e16);
            return i3;
        }
    }

    public int Ia(EditText editText, ArrayList<d.a> arrayList, int i3) {
        if (arrayList == null) {
            return i3;
        }
        Iterator<d.a> it = arrayList.iterator();
        while (it.hasNext()) {
            d.a next = it.next();
            Friend friend = new Friend();
            if (!TextUtils.isEmpty(next.f325977b)) {
                friend.mName = next.f325977b;
            } else {
                friend.mName = next.f325976a;
            }
            try {
                long longValue = Long.valueOf(next.f325976a).longValue();
                friend.mUin = longValue;
                if (friend.mName != null && longValue != 0) {
                    this.f325701e.L1(friend);
                    String str = "@" + friend.mName + " ";
                    if (i3 < str.length()) {
                        i3 = str.length();
                    }
                    fb(str, editText.getSelectionStart(), editText);
                }
            } catch (NumberFormatException unused) {
            }
        }
        return i3;
    }

    public void Ja(ArrayList<d.a> arrayList) {
        ExtendEditText extendEditText = this.F;
        if (extendEditText == null) {
            return;
        }
        if (this.W) {
            int selectionStart = extendEditText.getSelectionStart();
            Editable editableText = this.F.getEditableText();
            if (editableText != null && !TextUtils.isEmpty(editableText.toString()) && selectionStart > 0) {
                int i3 = selectionStart - 1;
                if (editableText.toString().charAt(i3) == '@') {
                    editableText.delete(i3, selectionStart);
                }
            }
            this.W = false;
        }
        this.V = Ia(this.F, arrayList, this.V);
        SimpleEventBus.getInstance().dispatchEvent(new PublishKeyboardEvent(true));
    }

    protected boolean Ma() {
        return true;
    }

    public int Pa(CharSequence charSequence, int i3, int i16, List<Friend> list, int i17, int i18, String str) {
        int length;
        if (charSequence != null) {
            if (charSequence.length() > 1) {
                if (charSequence.length() > i3) {
                    length = i3;
                } else {
                    length = charSequence.length();
                }
                int i19 = length - 1;
                for (int i26 = 1; i19 >= 0 && i26 <= i16; i26++) {
                    if (charSequence.charAt(i19) == '@' && jb(charSequence.toString().substring(i19, length), false, list, i17, i18, str)) {
                        return i19;
                    }
                    i19--;
                }
            }
        }
        return -1;
    }

    public String Qa(String str, List<Friend> list) {
        if (str == null) {
            return null;
        }
        if (list != null && list.size() != 0) {
            for (Friend friend : list) {
                String str2 = friend.mName;
                if (str2 == null) {
                    str2 = friend.mUin + "";
                }
                String str3 = "@{uin:" + friend.mUin + ",nick:" + str2.replace("%", "%25").replace(",", "%2C").replace("}", "%7D").replace("{", "%7B").replace(":", "%3A").replace(">", "%3E") + "}";
                String str4 = "@" + friend.mName;
                if (!TextUtils.isEmpty(friend.mName) && str.contains(str4)) {
                    str = ub(str4, str, str3);
                }
            }
        }
        return str;
    }

    public void Ua() {
        Wa();
        Va();
        View view = this.I;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    protected boolean Va() {
        View view = this.G;
        if (view == null || !this.P) {
            return false;
        }
        this.P = false;
        view.setVisibility(8);
        this.J.setImageResource(R.drawable.m3k);
        return true;
    }

    public boolean Wa() {
        return Xa(false);
    }

    protected boolean Xa(boolean z16) {
        ExtendEditText extendEditText;
        InputMethodManager inputMethodManager = this.f325706m;
        if (inputMethodManager != null && (extendEditText = this.F) != null) {
            if (inputMethodManager.hideSoftInputFromWindow(extendEditText.getWindowToken(), 0)) {
                if (z16) {
                    this.F.clearFocus();
                }
                this.C = true;
                return true;
            }
            this.C = true;
        }
        return false;
    }

    protected void Ya() {
        Za(true);
    }

    protected void Za(boolean z16) {
        if (this.F == null) {
            return;
        }
        Xa(z16);
        Va();
    }

    protected void bb() {
        this.G = new SystemAndEmojiUniversalPanel.Builder(getContext()).setEmoticonCallback(new c()).setShowCommonUsedSystemEmoji(true).create(((IEmoticonMainPanelAppService) QRoute.api(IEmoticonMainPanelAppService.class)).createEmoticonMainPanelApp(MobileQQ.sMobileQQ.waitAppRuntime(null)));
    }

    protected final void cb(View view) {
        qb();
        RelativeLayout relativeLayout = (RelativeLayout) view;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        LinearLayout linearLayout = new LinearLayout(getActivity());
        this.M = linearLayout;
        linearLayout.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
        this.M.setOrientation(1);
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.gux, (ViewGroup) null);
        this.I = inflate;
        inflate.setVisibility(8);
        this.M.addView(this.I, new LinearLayout.LayoutParams(-1, -2));
        View view2 = this.G;
        if (view2 != null) {
            this.M.addView(view2, new LinearLayout.LayoutParams(-1, -2));
            this.G.setVisibility(8);
        }
        relativeLayout.addView(this.M, layoutParams);
        Rect rect = new Rect();
        relativeLayout.getWindowVisibleDisplayFrame(rect);
        this.H = rect.height();
        relativeLayout.getViewTreeObserver().addOnGlobalLayoutListener(new d(relativeLayout));
        this.J = (ImageView) view.findViewById(R.id.ius);
        this.K = (ImageView) view.findViewById(R.id.f85264oh);
        this.L = (ImageView) view.findViewById(R.id.f85274oi);
        Ab();
        eb(view);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(PublishKeyboardEvent.class);
        arrayList.add(PublishContentGetFocusEvent.class);
        return arrayList;
    }

    public boolean jb(String str, boolean z16, List<Friend> list, int i3, int i16, String str2) {
        if ((gb(i3, i16, str2) || !z16) && list != null) {
            int size = list.size();
            for (int i17 = 0; i17 < size; i17++) {
                Friend friend = list.get(i17);
                if (friend != null && friend.mName != null && str != null) {
                    if (!str.equalsIgnoreCase("@" + friend.mName)) {
                        if (str.equalsIgnoreCase("@" + friend.mName + " ")) {
                        }
                    }
                    if (z16) {
                        list.remove(i17);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i3 == 1001) {
            pb(i16, intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() != R.id.bzb && view.getId() != R.id.bys) {
            if (view.getId() == R.id.f85274oi) {
                Ya();
                this.I.setVisibility(8);
            }
        } else {
            Va();
            SimpleEventBus.getInstance().dispatchEvent(new PublishChangeTagPanelStateEvent(1));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f325699d = (PublishViewModel) getViewModel(PublishViewModel.class);
        this.f325701e = (com.tencent.mobileqq.wink.publish.viewmodel.i) getViewModel(com.tencent.mobileqq.wink.publish.viewmodel.i.class);
        ab(view);
        bb();
        cb(view);
        ob();
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
        this.f325706m = (InputMethodManager) getActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        super.onPartDestroy(activity);
        WinkSoftKeyboardStateHelper winkSoftKeyboardStateHelper = this.N;
        if (winkSoftKeyboardStateHelper != null) {
            winkSoftKeyboardStateHelper.o();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        ExtendEditText extendEditText;
        if (simpleBaseEvent instanceof PublishKeyboardEvent) {
            if (((PublishKeyboardEvent) simpleBaseEvent).showKeyboard) {
                Va();
                showKeyboard();
                return;
            } else {
                Ya();
                this.I.setVisibility(8);
                return;
            }
        }
        if ((simpleBaseEvent instanceof PublishContentGetFocusEvent) && (extendEditText = this.F) != null) {
            extendEditText.requestFocus();
        }
    }

    protected void pb(int i3, Intent intent) {
        String str = f325694g0;
        w53.b.f(str, "onAtUserResult resultCode:" + i3);
        if (i3 == -1 && intent != null) {
            Ja(com.tencent.mobileqq.wink.publish.util.d.a(intent));
            return;
        }
        QLog.e(str, 1, "onAtUserResult error, resultCode:" + i3);
    }

    public void showKeyboard() {
        ExtendEditText extendEditText;
        ExtendEditText extendEditText2;
        InputMethodManager inputMethodManager = this.f325706m;
        if (inputMethodManager == null) {
            return;
        }
        if (this.Z && (extendEditText2 = this.E) != null) {
            inputMethodManager.showSoftInput(extendEditText2, 2);
            this.C = false;
        }
        if (!this.Z && (extendEditText = this.F) != null) {
            if (!extendEditText.hasFocus()) {
                this.F.requestFocus();
            }
            this.f325706m.showSoftInput(this.F, 2);
            this.C = false;
        }
    }

    public String wb(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder(str);
        Matcher matcher = RichTextAtParser.AT_PATTERN.matcher(sb5);
        int i3 = 0;
        while (matcher.find()) {
            try {
                int start = matcher.start() - i3;
                int end = matcher.end() - i3;
                String group = matcher.group();
                int indexOf = group.indexOf("uin:") + 4;
                int indexOf2 = group.indexOf(",nick:");
                String substring = group.substring(indexOf, indexOf2);
                String replace = group.substring(indexOf2 + 6, group.length() - 1).replace("%25", "%").replace("%2C", ",").replace("%7D", "}").replace("%7B", "{").replace("%3A", ":").replace("%3E", ">");
                String str2 = "@" + replace;
                sb5.replace(start, end, str2);
                i3 += group.length() - str2.length();
                Friend friend = new Friend();
                friend.mName = replace;
                try {
                    friend.mUin = Long.valueOf(substring).longValue();
                    this.f325701e.L1(friend);
                } catch (NumberFormatException e16) {
                    QLog.e(f325694g0, 1, e16, new Object[0]);
                }
            } catch (Exception e17) {
                QLog.e(f325694g0, 1, e17, new Object[0]);
            }
        }
        return sb5.toString();
    }

    protected void xb() {
        this.K.setOnClickListener(new f());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public class g implements WinkSoftKeyboardStateHelper.a {
        g() {
        }

        @Override // com.tencent.mobileqq.wink.view.WinkSoftKeyboardStateHelper.a
        public void onSoftKeyboardClosed() {
            QLog.d(PublishContentPart.f325694g0, 1, "onSoftKeyboardClosed");
        }

        @Override // com.tencent.mobileqq.wink.view.WinkSoftKeyboardStateHelper.a
        public void onSoftKeyboardOpened(int i3) {
            QLog.d(PublishContentPart.f325694g0, 1, "onSoftKeyboardOpened");
            if (PublishContentPart.this.D != i3) {
                PublishContentPart.this.D = i3;
                PublishContentPart.this.qb();
            }
        }

        @Override // com.tencent.mobileqq.wink.view.WinkSoftKeyboardStateHelper.a
        public void a(int i3) {
        }
    }
}
