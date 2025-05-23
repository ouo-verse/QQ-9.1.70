package com.tencent.mobileqq.troop.widget;

import NearbyGroup.Color;
import NearbyGroup.GroupLabel;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.RecommendLabel;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.al;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopLabelLayout extends ViewGroup {
    static IPatchRedirector $redirector_;
    ArrayList<GroupLabel> C;
    private Runnable D;
    Runnable E;
    boolean F;
    private Map<Integer, TroopLabelTextView> G;
    private Drawable H;

    /* renamed from: d, reason: collision with root package name */
    int f302446d;

    /* renamed from: e, reason: collision with root package name */
    int f302447e;

    /* renamed from: f, reason: collision with root package name */
    TextView f302448f;

    /* renamed from: h, reason: collision with root package name */
    boolean f302449h;

    /* renamed from: i, reason: collision with root package name */
    boolean f302450i;

    /* renamed from: m, reason: collision with root package name */
    private a f302451m;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        void a(ViewGroup viewGroup, String str);
    }

    public TroopLabelLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f302446d = 5;
        this.f302447e = 0;
        this.f302449h = false;
        this.f302450i = false;
        this.C = new ArrayList<>();
        this.D = new Runnable() { // from class: com.tencent.mobileqq.troop.widget.TroopLabelLayout.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopLabelLayout.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                CharSequence contentDescription = TroopLabelLayout.this.getContentDescription();
                if (TextUtils.isEmpty(contentDescription)) {
                    contentDescription = TroopLabelLayout.this.d();
                    TroopLabelLayout.this.setContentDescription(contentDescription);
                }
                TroopLabelLayout.this.f302451m.a(TroopLabelLayout.this, contentDescription.toString());
            }
        };
        this.E = new Runnable() { // from class: com.tencent.mobileqq.troop.widget.TroopLabelLayout.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopLabelLayout.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                synchronized (TroopLabelLayout.this.C) {
                    ArrayList<GroupLabel> arrayList = TroopLabelLayout.this.C;
                    if (arrayList != null && arrayList.size() != 0) {
                        int i16 = 0;
                        for (int i17 = 0; i17 < TroopLabelLayout.this.C.size(); i17++) {
                            GroupLabel groupLabel = TroopLabelLayout.this.C.get(i17);
                            if (i17 == 0) {
                                i16 = 0;
                            } else {
                                if (com.tencent.mobileqq.troop.widget.labelv2.a.a().get((int) TroopLabelLayout.this.C.get(i16).type) <= com.tencent.mobileqq.troop.widget.labelv2.a.a().get((int) groupLabel.type)) {
                                    i16 = i17;
                                }
                            }
                        }
                        GroupLabel groupLabel2 = TroopLabelLayout.this.C.get(i16);
                        for (int i18 = 0; i18 < TroopLabelLayout.this.getChildCount(); i18++) {
                            View childAt = TroopLabelLayout.this.getChildAt(i18);
                            if (childAt instanceof TextView) {
                                TextView textView = (TextView) childAt;
                                if (textView.getText().toString().equals(groupLabel2.strWording)) {
                                    textView.setVisibility(8);
                                    TroopLabelLayout.this.requestLayout();
                                }
                            }
                        }
                    }
                }
            }
        };
        this.H = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d() {
        int childCount = getChildCount();
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && childAt.getWidth() != 0 && childAt.getHeight() != 0) {
                sb5.append(childAt.getContentDescription());
                sb5.append(" ");
            }
        }
        return sb5.toString();
    }

    private String e(TextView textView, String str, int i3) {
        TextPaint paint = textView.getPaint();
        float f16 = i3;
        if (paint.measureText(str) > f16) {
            return str.substring(0, paint.breakText(str, true, f16, null)) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        return str;
    }

    public TroopLabelTextView c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (TroopLabelTextView) iPatchRedirector.redirect((short) 14, (Object) this, i3);
        }
        Map<Integer, TroopLabelTextView> map = this.G;
        if (map == null || !map.containsKey(Integer.valueOf(i3))) {
            return null;
        }
        return this.G.get(Integer.valueOf(i3));
    }

    public boolean f(ArrayList<GroupLabel> arrayList) {
        Map<Integer, Boolean> map;
        int i3;
        Map<Integer, Boolean> map2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) arrayList)).booleanValue();
        }
        synchronized (this.C) {
            this.C.clear();
        }
        if (arrayList != null && arrayList.size() != 0) {
            Map<Integer, Boolean> hashMap = new HashMap<>();
            int size = arrayList.size();
            int i16 = 0;
            int i17 = 0;
            while (i16 < size && i17 < this.f302446d) {
                GroupLabel groupLabel = arrayList.get(i16);
                if (!TextUtils.isEmpty(groupLabel.strWording)) {
                    long j3 = groupLabel.type;
                    if (j3 != 2001) {
                        int i18 = this.f302447e;
                        int i19 = 2;
                        if ((i18 >= 2 || j3 < 1000 || j3 >= 2000) && (i18 != 2 || j3 >= 1000)) {
                            synchronized (this.C) {
                                this.C.add(groupLabel);
                            }
                            if (!this.F && groupLabel.type == 4) {
                                TextView textView = this.f302448f;
                                if (textView != null) {
                                    textView.setText(groupLabel.strWording);
                                }
                            } else {
                                TroopLabelTextView c16 = c(i17);
                                Color color = groupLabel.edging_color;
                                Map<Integer, Boolean> map3 = hashMap;
                                int rgb = android.graphics.Color.rgb((int) color.R, (int) color.G, (int) color.B);
                                Color color2 = groupLabel.text_color;
                                i3 = i16;
                                int rgb2 = android.graphics.Color.rgb((int) color2.R, (int) color2.G, (int) color2.B);
                                if (c16 == null) {
                                    c16 = new TroopLabelTextView(getContext(), rgb, rgb2, this.f302447e);
                                    if (i17 < this.f302446d) {
                                        addView(c16);
                                        setTroopLabel(i17, c16);
                                    } else {
                                        map = map3;
                                        break;
                                    }
                                } else {
                                    c16.setColor(rgb, rgb2);
                                    if (QLog.isColorLevel()) {
                                        QLog.d("TroopLabelLayout", 2, "labeltextview cache");
                                    }
                                }
                                c16.bringToFront();
                                if (this.f302447e == 2) {
                                    int dip2px = ViewUtils.dip2px(42.0f);
                                    int dip2px2 = ViewUtils.dip2px(16.0f);
                                    c16.setWidth(dip2px);
                                    c16.setHeight(dip2px2);
                                    c16.setMaskImage(R.drawable.e5k);
                                    if (groupLabel.strWording.length() < 2) {
                                        i19 = 1;
                                    }
                                    groupLabel.strWording = groupLabel.strWording.substring(0, i19);
                                }
                                if (groupLabel.type == 1) {
                                    SpannableString spannableString = new SpannableString("[icon] " + groupLabel.strWording);
                                    if (this.H == null) {
                                        if (this.f302447e == 0) {
                                            this.H = getContext().getResources().getDrawable(R.drawable.h6x);
                                        } else {
                                            this.H = getContext().getResources().getDrawable(R.drawable.e5j);
                                        }
                                    }
                                    int textSize = (int) ((c16.getTextSize() * 0.8d) + 0.5d);
                                    this.H.setBounds(0, 0, textSize, textSize);
                                    spannableString.setSpan(new ImageSpan(this.H, 1), 0, 6, 17);
                                    c16.setText(spannableString);
                                    c16.setContentDescription(groupLabel.strWording + HardCodeUtil.qqStr(R.string.uio));
                                } else {
                                    c16.setText(groupLabel.strWording + "");
                                    c16.setContentDescription(groupLabel.strWording);
                                }
                                c16.setVisibility(0);
                                map2 = map3;
                                map2.put(Integer.valueOf(i17), Boolean.TRUE);
                                i17++;
                                Map<Integer, Boolean> map4 = map2;
                                i16 = i3 + 1;
                                hashMap = map4;
                            }
                        }
                    }
                }
                i3 = i16;
                map2 = hashMap;
                Map<Integer, Boolean> map42 = map2;
                i16 = i3 + 1;
                hashMap = map42;
            }
            map = hashMap;
            setLabelsUnVisible(map);
            map.clear();
            return true;
        }
        return true;
    }

    public boolean g(ArrayList<GroupLabel> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) arrayList)).booleanValue();
        }
        synchronized (this.C) {
            this.C.clear();
        }
        if (arrayList != null && arrayList.size() != 0) {
            Map<Integer, Boolean> hashMap = new HashMap<>();
            int size = arrayList.size();
            int i3 = 0;
            for (int i16 = 0; i16 < size && i3 < this.f302446d; i16++) {
                GroupLabel groupLabel = arrayList.get(i16);
                if (!TextUtils.isEmpty(groupLabel.strWording)) {
                    synchronized (this.C) {
                        this.C.add(groupLabel);
                    }
                    TroopLabelTextView c16 = c(i3);
                    int defaultColor = getResources().getColorStateList(R.color.qui_common_bg_bottom_standard).getDefaultColor();
                    int defaultColor2 = getResources().getColorStateList(R.color.qui_common_text_secondary).getDefaultColor();
                    long j3 = groupLabel.type;
                    if ((j3 == 1 || j3 == 21) && !com.tencent.mobileqq.troop.exp.a.f295373a.c()) {
                        defaultColor2 = android.graphics.Color.parseColor("#0099FF");
                    }
                    if (c16 == null) {
                        c16 = new TroopLabelTextView(getContext(), defaultColor, defaultColor2, this.f302447e);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, ViewUtils.dip2px(18.0f));
                        layoutParams.rightMargin = ViewUtils.dip2px(5.0f);
                        c16.setLayoutParams(layoutParams);
                        c16.f302455h = ViewUtils.dip2px(3.0f);
                        c16.setTextSize(2, 11.0f);
                        c16.setPadding(ViewUtils.dip2px(6.0f), 0, ViewUtils.dip2px(6.0f), 0);
                        if (i3 >= this.f302446d) {
                            break;
                        }
                        addView(c16);
                        setTroopLabel(i3, c16);
                    } else {
                        c16.setColor(defaultColor, defaultColor2);
                    }
                    c16.bringToFront();
                    if (groupLabel.type == 1) {
                        SpannableString spannableString = new SpannableString("[icon] " + groupLabel.strWording);
                        if (this.H == null) {
                            this.H = getContext().getResources().getDrawable(R.drawable.n9s);
                            if (com.tencent.mobileqq.troop.exp.a.f295373a.c()) {
                                this.H.setColorFilter(defaultColor2, PorterDuff.Mode.SRC_IN);
                            }
                        }
                        int textSize = (int) ((c16.getTextSize() * 0.8d) + 0.5d);
                        this.H.setBounds(0, 0, textSize, textSize);
                        spannableString.setSpan(new ImageSpan(this.H, 1), 0, 6, 17);
                        c16.setText(spannableString);
                        c16.setContentDescription(groupLabel.strWording + HardCodeUtil.qqStr(R.string.uio));
                    } else {
                        c16.setText(groupLabel.strWording + "");
                        c16.setContentDescription(groupLabel.strWording);
                    }
                    c16.setVisibility(0);
                    hashMap.put(Integer.valueOf(i3), Boolean.TRUE);
                    i3++;
                }
            }
            setLabelsUnVisible(hashMap);
            hashMap.clear();
        }
        return true;
    }

    public boolean h(ArrayList<GroupLabel> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) arrayList)).booleanValue();
        }
        synchronized (this.C) {
            this.C.clear();
        }
        if (arrayList != null && arrayList.size() != 0) {
            Map<Integer, Boolean> hashMap = new HashMap<>();
            int size = arrayList.size();
            int i3 = 0;
            for (int i16 = 0; i16 < size && i3 < this.f302446d; i16++) {
                GroupLabel groupLabel = arrayList.get(i16);
                if (!TextUtils.isEmpty(groupLabel.strWording)) {
                    synchronized (this.C) {
                        this.C.add(groupLabel);
                    }
                    TroopLabelTextView c16 = c(i3);
                    int defaultColor = getResources().getColorStateList(R.color.qui_common_fill_standard_primary).getDefaultColor();
                    int defaultColor2 = getResources().getColorStateList(R.color.qui_common_text_secondary).getDefaultColor();
                    long j3 = groupLabel.type;
                    if ((j3 == 1 || j3 == 21) && !com.tencent.mobileqq.troop.exp.a.f295373a.c()) {
                        defaultColor2 = android.graphics.Color.parseColor("#0099FF");
                    }
                    if (c16 == null) {
                        c16 = new TroopLabelTextView(getContext(), defaultColor, defaultColor2, this.f302447e);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, ViewUtils.dip2px(18.0f));
                        layoutParams.rightMargin = ViewUtils.dip2px(5.0f);
                        c16.setLayoutParams(layoutParams);
                        c16.f302455h = ViewUtils.dip2px(3.0f);
                        c16.setTextSize(2, 11.0f);
                        c16.setPadding(ViewUtils.dip2px(6.0f), 0, ViewUtils.dip2px(6.0f), 0);
                        if (i3 >= this.f302446d) {
                            break;
                        }
                        addView(c16);
                        setTroopLabel(i3, c16);
                    } else {
                        c16.setColor(defaultColor, defaultColor2);
                    }
                    c16.bringToFront();
                    if (groupLabel.type == 1) {
                        SpannableString spannableString = new SpannableString("[icon] " + groupLabel.strWording);
                        if (this.H == null) {
                            this.H = getContext().getResources().getDrawable(R.drawable.n9s);
                            if (com.tencent.mobileqq.troop.exp.a.f295373a.c()) {
                                this.H.setColorFilter(defaultColor2, PorterDuff.Mode.SRC_IN);
                            }
                        }
                        int textSize = (int) ((c16.getTextSize() * 0.8d) + 0.5d);
                        this.H.setBounds(0, 0, textSize, textSize);
                        spannableString.setSpan(new ImageSpan(this.H, 1), 0, 6, 17);
                        c16.setText(spannableString);
                        c16.setContentDescription(groupLabel.strWording + HardCodeUtil.qqStr(R.string.uio));
                    } else {
                        c16.setText(groupLabel.strWording + "");
                        c16.setContentDescription(groupLabel.strWording);
                    }
                    c16.setVisibility(0);
                    hashMap.put(Integer.valueOf(i3), Boolean.TRUE);
                    i3++;
                }
            }
            setLabelsUnVisible(hashMap);
            hashMap.clear();
        }
        return true;
    }

    public void i(List<RecommendLabel> list, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, list, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            k(list, i3, i16, false);
        }
    }

    public boolean j(List<RecommendLabel> list, int i3, int i16, int i17) {
        int i18;
        boolean z16;
        int i19;
        String str;
        int rgb;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i26 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, this, list, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17))).booleanValue();
        }
        this.f302447e = i17;
        if (list != null) {
            i18 = list.size();
        } else {
            i18 = 0;
        }
        if (i16 != 0 && i16 != 1) {
            z16 = false;
        } else {
            i18++;
            z16 = true;
        }
        removeAllViews();
        int i27 = 0;
        int i28 = 0;
        while (i27 < i18 && i28 < this.f302446d) {
            if (z16 && i27 == 0) {
                if (i3 > 0) {
                    str = "[icon] " + i3 + "";
                } else {
                    str = "[icon] ";
                }
                SpannableString spannableString = new SpannableString(str);
                if (i16 == 0) {
                    rgb = android.graphics.Color.rgb(i26, 202, 252);
                    this.H = ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.f161850f54, null);
                } else {
                    rgb = android.graphics.Color.rgb(255, 128, 191);
                    this.H = ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.f161849f53, null);
                }
                TroopLabelTextView troopLabelTextView = new TroopLabelTextView(getContext(), rgb, -1, this.f302447e);
                if (i28 >= this.f302446d) {
                    break;
                }
                addView(troopLabelTextView);
                int textSize = (int) ((troopLabelTextView.getTextSize() * 0.8d) + 0.5d);
                this.H.setBounds(i26, i26, textSize, textSize);
                spannableString.setSpan(new ImageSpan(this.H, 1), i26, 6, 17);
                troopLabelTextView.setText(spannableString);
                i28++;
            } else {
                if (z16) {
                    i19 = i27 - 1;
                } else {
                    i19 = i27;
                }
                if (list != null && list.size() > i19) {
                    RecommendLabel recommendLabel = list.get(i19);
                    TroopLabelTextView troopLabelTextView2 = new TroopLabelTextView(getContext(), recommendLabel.edging_color, recommendLabel.text_color, this.f302447e);
                    if (i28 >= this.f302446d) {
                        break;
                    }
                    addView(troopLabelTextView2);
                    troopLabelTextView2.setEllipsize(TextUtils.TruncateAt.END);
                    troopLabelTextView2.bringToFront();
                    String str2 = recommendLabel.bytes_name;
                    if (str2 != null) {
                        troopLabelTextView2.setText(str2);
                        troopLabelTextView2.setContentDescription(recommendLabel.bytes_name);
                        if ((z16 && i27 == 1) || (!z16 && i27 == 0)) {
                            troopLabelTextView2.setMaxWidth(ViewUtils.dip2px(150.0f));
                        }
                    } else {
                        troopLabelTextView2.setText("");
                        troopLabelTextView2.setContentDescription("");
                    }
                    i28++;
                }
            }
            i27++;
            i26 = 0;
        }
        if (i18 == 0) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0200, code lost:
    
        setVisibility(8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:?, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean k(List<RecommendLabel> list, int i3, int i16, boolean z16) {
        boolean z17;
        int i17;
        String str;
        int i18;
        String str2;
        int i19;
        int rgb;
        int i26;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i27 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, this, list, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16))).booleanValue();
        }
        if (list == null || list.isEmpty()) {
            return false;
        }
        if (z16) {
            this.f302447e = 3;
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = ViewUtils.dpToPx(17.0f);
                setLayoutParams(layoutParams);
            }
        }
        int size = list.size();
        if (i3 != 0 && i3 != 1) {
            z17 = false;
        } else {
            size++;
            z17 = true;
        }
        removeAllViews();
        int i28 = 0;
        int i29 = 0;
        while (i28 < size && i29 < this.f302446d) {
            if (z17 && i28 == 0) {
                Context context = getContext();
                if (i3 == 0) {
                    i18 = R.string.c7_;
                } else {
                    i18 = R.string.b5e;
                }
                String string = context.getString(i18);
                if (i16 > 0) {
                    str2 = string + " " + i16 + "";
                    if (z16) {
                        str2 = str2 + "\u5c81";
                    }
                } else {
                    str2 = string + " ";
                }
                SpannableString spannableString = new SpannableString(str2);
                if (z16) {
                    rgb = getResources().getColor(R.color.qui_common_fill_standard_primary);
                    if (i3 == 0) {
                        i26 = R.drawable.ngi;
                    } else {
                        i26 = R.drawable.ngh;
                    }
                    this.H = getContext().getResources().getDrawable(i26);
                    i19 = getResources().getColor(R.color.qui_common_text_secondary);
                } else {
                    i19 = -1;
                    if (i3 == 0) {
                        rgb = android.graphics.Color.rgb(i27, 202, 252);
                        this.H = getContext().getResources().getDrawable(R.drawable.f161850f54);
                    } else {
                        rgb = android.graphics.Color.rgb(255, 128, 191);
                        this.H = getContext().getResources().getDrawable(R.drawable.f161849f53);
                    }
                }
                TroopLabelTextView troopLabelTextView = new TroopLabelTextView(getContext(), rgb, i19, this.f302447e);
                if (i29 >= this.f302446d) {
                    break;
                }
                addView(troopLabelTextView);
                int textSize = (int) ((troopLabelTextView.getTextSize() * 0.8d) + 0.5d);
                this.H.setBounds(0, 0, textSize, textSize);
                spannableString.setSpan(new ImageSpan(this.H, 1), 0, string.length(), 17);
                troopLabelTextView.setText(spannableString);
                troopLabelTextView.setContentDescription(str2);
                i29++;
            } else {
                if (z17) {
                    i17 = i28 - 1;
                } else {
                    i17 = i28;
                }
                if (list.size() > i17) {
                    RecommendLabel recommendLabel = list.get(i17);
                    int i36 = recommendLabel.edging_color;
                    int i37 = recommendLabel.text_color;
                    if (z16) {
                        i36 = getResources().getColor(R.color.qui_common_fill_standard_primary);
                        i37 = getResources().getColor(R.color.qui_common_text_secondary);
                    }
                    TroopLabelTextView troopLabelTextView2 = new TroopLabelTextView(getContext(), i36, i37, this.f302447e);
                    troopLabelTextView2.setEllipsize(TextUtils.TruncateAt.END);
                    troopLabelTextView2.bringToFront();
                    String str3 = recommendLabel.bytes_name;
                    if (str3 != null && !TextUtils.isEmpty(str3)) {
                        String str4 = recommendLabel.bytes_name;
                        troopLabelTextView2.setContentDescription(str4);
                        if ((z17 && i28 == 1) || (!z17 && i28 == 0)) {
                            troopLabelTextView2.setText(e(troopLabelTextView2, str4, ViewUtils.dip2px(150.0f)));
                        } else {
                            troopLabelTextView2.setText(str4);
                        }
                    } else {
                        troopLabelTextView2.setText("");
                        troopLabelTextView2.setContentDescription("");
                    }
                    if (i29 >= this.f302446d || (str = recommendLabel.bytes_name) == null || TextUtils.isEmpty(str)) {
                        break;
                    }
                    addView(troopLabelTextView2);
                    i29++;
                } else {
                    continue;
                }
            }
            i28++;
            i27 = 0;
        }
        setVisibility(0);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z19 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        int paddingLeft = ((i17 - i3) - getPaddingLeft()) - getPaddingRight();
        int a16 = (int) al.a(getContext(), 2.0f);
        int childCount = getChildCount();
        int paddingLeft2 = getPaddingLeft();
        int paddingTop = getPaddingTop();
        StringBuilder sb5 = new StringBuilder();
        StringBuilder sb6 = new StringBuilder();
        int i19 = 0;
        while (i19 < childCount) {
            View childAt = getChildAt(i19);
            if (childAt.getVisibility() == 8) {
                z17 = z19;
            } else {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                int i26 = paddingLeft2 + measuredWidth;
                if (i26 > paddingLeft) {
                    if (this.f302449h) {
                        post(this.E);
                    }
                    if (!this.f302450i) {
                        if (sb6.length() > 0) {
                            QLog.d("TroopLabelLayout", 2, sb6.toString());
                            sb6.setLength(0);
                            return;
                        }
                        return;
                    }
                    z17 = false;
                    z18 = true;
                } else {
                    z17 = false;
                    z18 = false;
                }
                int i27 = paddingLeft2 + a16 + measuredWidth + layoutParams.rightMargin;
                if (!z18) {
                    sb6.append("onLayout  name:");
                    sb6.append(getTag());
                    sb6.append("   left:");
                    sb6.append(paddingLeft2);
                    sb6.append("    right:");
                    sb6.append(i26);
                    sb6.append("\n");
                    childAt.layout(paddingLeft2, paddingTop, i26, measuredHeight + paddingTop);
                } else {
                    int i28 = i17 + measuredWidth;
                    childAt.layout(i28, paddingTop, measuredWidth + i28, measuredHeight + paddingTop);
                }
                sb5.append(childAt.getContentDescription());
                sb5.append(" ");
                paddingLeft2 = i27;
            }
            i19++;
            z19 = z17;
        }
        if (sb6.length() > 0) {
            QLog.d("TroopLabelLayout", 2, sb6.toString());
        }
        String sb7 = sb5.toString();
        setContentDescription(sb7);
        a aVar = this.f302451m;
        if (aVar != null) {
            aVar.a(this, sb7);
            removeCallbacks(this.D);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.onMeasure(i3, i16);
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int size2 = View.MeasureSpec.getSize(i16);
        super.measureChildren(i3, i16);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode != 1073741824) {
                    size = 0;
                }
            } else {
                int i18 = 0;
                for (int i19 = 0; i19 < getChildCount(); i19++) {
                    i18 += getChildAt(i19).getWidth();
                }
                if (i18 <= size) {
                    size = i18;
                }
            }
        }
        if (mode2 != Integer.MIN_VALUE && mode2 != 1073741824) {
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                i17 = 0 + getPaddingBottom() + getPaddingTop();
                if (childAt != null) {
                    i17 += childAt.getMeasuredHeight();
                }
            }
        } else {
            i17 = size2;
        }
        super.setMeasuredDimension(size, i17);
    }

    public void setAutoCreateDistanceTextView(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.F = z16;
        }
    }

    public void setDistanceTextView(TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) textView);
        } else {
            this.f302448f = textView;
        }
    }

    public void setIsInCompleteDrawOutSide(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, z16);
        } else {
            this.f302450i = z16;
        }
    }

    public void setLabelType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.f302447e = i3;
        }
    }

    public void setLabelsUnVisible(Map<Integer, Boolean> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) map);
            return;
        }
        Map<Integer, TroopLabelTextView> map2 = this.G;
        if (map2 == null) {
            return;
        }
        for (Map.Entry<Integer, TroopLabelTextView> entry : map2.entrySet()) {
            if (!map.containsKey(entry.getKey())) {
                entry.getValue().setVisibility(8);
            }
        }
    }

    public void setMaxLabelCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.f302446d = i3;
        }
    }

    public void setOnLayoutCompletedListener(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) aVar);
            return;
        }
        this.f302451m = aVar;
        if (aVar != null) {
            post(this.D);
        }
    }

    public void setTroopLabel(int i3, TroopLabelTextView troopLabelTextView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3, (Object) troopLabelTextView);
            return;
        }
        if (this.G == null) {
            this.G = new HashMap();
        }
        if (!this.G.containsKey(Integer.valueOf(i3))) {
            this.G.put(Integer.valueOf(i3), troopLabelTextView);
        }
    }

    public void setmIsNeedPriority(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        } else {
            this.f302449h = z16;
        }
    }

    public TroopLabelLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f302446d = 5;
        this.f302447e = 0;
        this.f302449h = false;
        this.f302450i = false;
        this.C = new ArrayList<>();
        this.D = new Runnable() { // from class: com.tencent.mobileqq.troop.widget.TroopLabelLayout.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopLabelLayout.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                CharSequence contentDescription = TroopLabelLayout.this.getContentDescription();
                if (TextUtils.isEmpty(contentDescription)) {
                    contentDescription = TroopLabelLayout.this.d();
                    TroopLabelLayout.this.setContentDescription(contentDescription);
                }
                TroopLabelLayout.this.f302451m.a(TroopLabelLayout.this, contentDescription.toString());
            }
        };
        this.E = new Runnable() { // from class: com.tencent.mobileqq.troop.widget.TroopLabelLayout.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopLabelLayout.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                synchronized (TroopLabelLayout.this.C) {
                    ArrayList<GroupLabel> arrayList = TroopLabelLayout.this.C;
                    if (arrayList != null && arrayList.size() != 0) {
                        int i16 = 0;
                        for (int i17 = 0; i17 < TroopLabelLayout.this.C.size(); i17++) {
                            GroupLabel groupLabel = TroopLabelLayout.this.C.get(i17);
                            if (i17 == 0) {
                                i16 = 0;
                            } else {
                                if (com.tencent.mobileqq.troop.widget.labelv2.a.a().get((int) TroopLabelLayout.this.C.get(i16).type) <= com.tencent.mobileqq.troop.widget.labelv2.a.a().get((int) groupLabel.type)) {
                                    i16 = i17;
                                }
                            }
                        }
                        GroupLabel groupLabel2 = TroopLabelLayout.this.C.get(i16);
                        for (int i18 = 0; i18 < TroopLabelLayout.this.getChildCount(); i18++) {
                            View childAt = TroopLabelLayout.this.getChildAt(i18);
                            if (childAt instanceof TextView) {
                                TextView textView = (TextView) childAt;
                                if (textView.getText().toString().equals(groupLabel2.strWording)) {
                                    textView.setVisibility(8);
                                    TroopLabelLayout.this.requestLayout();
                                }
                            }
                        }
                    }
                }
            }
        };
        this.H = null;
    }

    public TroopLabelLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        this.f302446d = 5;
        this.f302447e = 0;
        this.f302449h = false;
        this.f302450i = false;
        this.C = new ArrayList<>();
        this.D = new Runnable() { // from class: com.tencent.mobileqq.troop.widget.TroopLabelLayout.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopLabelLayout.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                CharSequence contentDescription = TroopLabelLayout.this.getContentDescription();
                if (TextUtils.isEmpty(contentDescription)) {
                    contentDescription = TroopLabelLayout.this.d();
                    TroopLabelLayout.this.setContentDescription(contentDescription);
                }
                TroopLabelLayout.this.f302451m.a(TroopLabelLayout.this, contentDescription.toString());
            }
        };
        this.E = new Runnable() { // from class: com.tencent.mobileqq.troop.widget.TroopLabelLayout.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopLabelLayout.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                synchronized (TroopLabelLayout.this.C) {
                    ArrayList<GroupLabel> arrayList = TroopLabelLayout.this.C;
                    if (arrayList != null && arrayList.size() != 0) {
                        int i16 = 0;
                        for (int i17 = 0; i17 < TroopLabelLayout.this.C.size(); i17++) {
                            GroupLabel groupLabel = TroopLabelLayout.this.C.get(i17);
                            if (i17 == 0) {
                                i16 = 0;
                            } else {
                                if (com.tencent.mobileqq.troop.widget.labelv2.a.a().get((int) TroopLabelLayout.this.C.get(i16).type) <= com.tencent.mobileqq.troop.widget.labelv2.a.a().get((int) groupLabel.type)) {
                                    i16 = i17;
                                }
                            }
                        }
                        GroupLabel groupLabel2 = TroopLabelLayout.this.C.get(i16);
                        for (int i18 = 0; i18 < TroopLabelLayout.this.getChildCount(); i18++) {
                            View childAt = TroopLabelLayout.this.getChildAt(i18);
                            if (childAt instanceof TextView) {
                                TextView textView = (TextView) childAt;
                                if (textView.getText().toString().equals(groupLabel2.strWording)) {
                                    textView.setVisibility(8);
                                    TroopLabelLayout.this.requestLayout();
                                }
                            }
                        }
                    }
                }
            }
        };
        this.H = null;
    }
}
