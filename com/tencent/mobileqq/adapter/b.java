package com.tencent.mobileqq.adapter;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.subaccount.UpArrowView;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.subaccount.api.impl.SubAccountControlServiceImpl;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.en;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.widget.AlphaClickableRelativeLayout;
import com.tencent.widget.FixSizeImageView;
import com.tencent.widget.RedWidgetUtil;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b extends BaseAdapter {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public LayoutInflater f187131d;

    /* renamed from: e, reason: collision with root package name */
    public QBaseActivity f187132e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList<com.tencent.mobileqq.subaccount.b> f187133f;

    /* renamed from: h, reason: collision with root package name */
    public View.OnClickListener f187134h;

    /* renamed from: i, reason: collision with root package name */
    boolean f187135i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f187136m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a extends C7222b {
        static IPatchRedirector $redirector_;

        /* renamed from: i, reason: collision with root package name */
        public C7222b f187137i;

        /* renamed from: j, reason: collision with root package name */
        public C7222b f187138j;

        /* renamed from: k, reason: collision with root package name */
        public View f187139k;

        /* renamed from: l, reason: collision with root package name */
        public View f187140l;

        /* renamed from: m, reason: collision with root package name */
        public View f187141m;

        public a() {
            super();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.adapter.b$b, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C7222b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public FixSizeImageView f187143a;

        /* renamed from: b, reason: collision with root package name */
        public SingleLineTextView f187144b;

        /* renamed from: c, reason: collision with root package name */
        public SingleLineTextView f187145c;

        /* renamed from: d, reason: collision with root package name */
        public DragTextView f187146d;

        /* renamed from: e, reason: collision with root package name */
        public ImageView f187147e;

        /* renamed from: f, reason: collision with root package name */
        public View f187148f;

        /* renamed from: g, reason: collision with root package name */
        public com.tencent.mobileqq.subaccount.b f187149g;

        public C7222b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }
    }

    public b(QBaseActivity qBaseActivity, ArrayList<com.tencent.mobileqq.subaccount.b> arrayList, View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, qBaseActivity, arrayList, onClickListener);
            return;
        }
        this.f187132e = qBaseActivity;
        this.f187133f = arrayList;
        this.f187131d = LayoutInflater.from(qBaseActivity.getApplication());
        this.f187134h = onClickListener;
        this.f187135i = ThemeUtil.isInNightMode(qBaseActivity.getAppRuntime());
        this.f187136m = SimpleUIUtil.getSimpleUISwitch();
    }

    private void a(View view, com.tencent.mobileqq.subaccount.b bVar) {
        if (view != null && bVar != null) {
            int g16 = g(bVar);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams.leftMargin = (ViewUtils.dip2px(43.0f) + (ViewUtils.dip2px(73.0f) * g16)) - ViewUtils.dip2px(6.0f);
            view.setLayoutParams(layoutParams);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0277  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private View b(int i3, View view, ViewGroup viewGroup) {
        C7222b c7222b;
        View view2;
        int i16;
        int i17;
        boolean z16;
        String str;
        String str2;
        View findViewById;
        int i18;
        CharSequence charSequence;
        int i19;
        if (view == null) {
            View inflate = this.f187131d.inflate(R.layout.bzs, viewGroup, false);
            C7222b c7222b2 = new C7222b();
            c7222b2.f187144b = (SingleLineTextView) inflate.findViewById(R.id.title);
            c7222b2.f187143a = (FixSizeImageView) inflate.findViewById(R.id.icon);
            c7222b2.f187146d = (DragTextView) inflate.findViewById(R.id.unreadmsg);
            c7222b2.f187145c = (SingleLineTextView) inflate.findViewById(R.id.bgt);
            inflate.setTag(c7222b2);
            c7222b = c7222b2;
            view2 = inflate;
        } else {
            c7222b = (C7222b) view.getTag();
            view2 = view;
        }
        com.tencent.mobileqq.subaccount.b bVar = (com.tencent.mobileqq.subaccount.b) getItem(i3);
        c7222b.f187149g = bVar;
        AppInterface appInterface = (AppInterface) this.f187132e.getAppRuntime();
        Resources resources = appInterface.getApplication().getResources();
        if (bVar != null) {
            SubAccountMessage subAccountMessage = (SubAccountMessage) bVar.f291103l;
            String str3 = subAccountMessage.sendername;
            if (subAccountMessage.istroop == 1) {
                str3 = resources.getString(R.string.f229626wy);
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = subAccountMessage.senderuin;
            }
            c7222b.f187144b.setText(str3);
            CharSequence charSequence2 = subAccountMessage.mEmoRecentMsg;
            if ((charSequence2 == null || charSequence2.length() == 0) && subAccountMessage.f203118msg != null) {
                subAccountMessage.mEmoRecentMsg = new QQText(subAccountMessage.f203118msg, 3, 16);
            }
            if (subAccountMessage.istroop == 1) {
                if (subAccountMessage.hasUnreadMsg()) {
                    i19 = R.string.f229636wz;
                } else {
                    i19 = R.string.f229646x0;
                }
                c7222b.f187145c.setText(resources.getString(i19));
            } else {
                c7222b.f187145c.setText(subAccountMessage.mEmoRecentMsg);
            }
            if (subAccountMessage.mTimeString == null || (charSequence = subAccountMessage.mEmoRecentMsg) == null || charSequence.length() == 0) {
                subAccountMessage.mTimeString = en.p(subAccountMessage.time * 1000, true, SubAccountControlServiceImpl.DateFormate);
            }
            if (subAccountMessage.istroop != 1) {
                c7222b.f187144b.setExtendText(subAccountMessage.mTimeString, 0);
            } else {
                c7222b.f187144b.setExtendText("", 0);
            }
            if (AppConstants.SUBACCOUNT_TROOP_UIN.equals(subAccountMessage.senderuin)) {
                try {
                    c7222b.f187143a.setImageBitmap(BaseImageUtil.getCircleFaceBitmap(BitmapFactory.decodeResource(resources, R.drawable.dii), 50, 50));
                } catch (OutOfMemoryError e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("SUB_ACCOUNT_AssocQQ_Adapter", 2, QLog.getStackTraceString(e16));
                    }
                }
            } else {
                FaceDrawable faceDrawable = FaceDrawable.getFaceDrawable(appInterface, 1, subAccountMessage.senderuin);
                c7222b.f187143a.setTag(subAccountMessage.senderuin);
                c7222b.f187143a.setImageDrawable(faceDrawable);
                c7222b.f187143a.setVisibility(0);
            }
            c7222b.f187146d.setTag(Integer.valueOf(i3));
            int i26 = subAccountMessage.unreadNum;
            if (i26 > 0 && subAccountMessage.istroop == 1) {
                z16 = false;
                i16 = R.drawable.skin_tips_dot;
                i17 = 1;
            } else if (i26 > 0) {
                int i27 = bVar.f291097f;
                if (2 != i27 && 3 != i27) {
                    if (SubAccountMessage.SUB_EXTR_RED_PACKET.equals(subAccountMessage.subExtr)) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    i17 = 3;
                    str = "";
                } else {
                    str = "[" + resources.getString(R.string.f172976g92) + "]";
                    z16 = false;
                    i17 = 3;
                }
                i16 = R.drawable.skin_tips_newmessage;
                c7222b.f187145c.setExtendText(str, 1);
                c7222b.f187146d.setDragViewType(0, view2);
                com.tencent.mobileqq.subaccount.c.a(c7222b.f187146d, i17, i26, i16, 99, null);
                RedWidgetUtil.fixTextViewLayout(c7222b.f187146d, i26, 99, i16);
                if (AppSetting.f99565y && TextUtils.isEmpty(bVar.f291099h)) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(str3);
                    sb5.append(",");
                    i18 = bVar.f291098g;
                    if (i18 != 0) {
                        if (i18 == 1) {
                            sb5.append("\u6709\u4e00\u6761\u672a\u8bfb");
                        } else if (i18 == 2) {
                            sb5.append("\u6709\u4e24\u6761\u672a\u8bfb");
                        } else if (i18 > 0) {
                            sb5.append("\u6709");
                            sb5.append(bVar.f291098g);
                            sb5.append("\u6761\u672a\u8bfb,");
                        }
                    }
                    if (str != null) {
                        sb5.append(str + ",");
                    }
                    sb5.append(subAccountMessage.mEmoRecentMsg);
                    sb5.append(",");
                    sb5.append(subAccountMessage.mTimeString);
                    bVar.f291099h = sb5.toString();
                }
                float q16 = com.tencent.mobileqq.utils.ah.q();
                ColorStateList colorStateList = resources.getColorStateList(R.color.qui_common_text_secondary);
                ColorStateList colorStateList2 = resources.getColorStateList(R.color.qui_common_text_primary);
                int color = resources.getColor(R.color.qui_common_feedback_error);
                c7222b.f187144b.setTextColor(colorStateList2);
                c7222b.f187144b.setExtendTextColor(colorStateList, 0);
                c7222b.f187144b.setExtendTextSize(12.0f, 0);
                c7222b.f187144b.setCompoundDrawablePadding((int) (3.0f * q16));
                c7222b.f187144b.setExtendTextPadding((int) (5.0f * q16), 2);
                c7222b.f187144b.setExtendTextColor(colorStateList, 2);
                c7222b.f187144b.setExtendTextSize(17.0f, 2);
                if (!z16) {
                    c7222b.f187145c.setTextColor(color);
                } else {
                    c7222b.f187145c.setTextColor(colorStateList);
                }
                c7222b.f187145c.setExtendTextColor(ColorStateList.valueOf(color), 1);
                c7222b.f187145c.setExtendTextPadding((int) (q16 * 2.0f), 1);
                c7222b.f187145c.setExtendTextSize(14.0f, 1);
                i(view2, bVar);
                view2.setOnClickListener(this.f187134h);
                if (AppSetting.f99565y && !TextUtils.isEmpty(bVar.f291099h)) {
                    view2.setContentDescription(bVar.f291099h);
                }
                if (this.f187135i && (findViewById = view2.findViewById(R.id.bmt)) != null) {
                    findViewById.setVisibility(8);
                }
                VideoReport.setElementId(view2, "em_bas_message_session");
                VideoReport.setElementEndExposePolicy(view2, EndExposurePolicy.REPORT_ALL);
                if (i26 <= 0) {
                    str2 = "1";
                } else {
                    str2 = "2";
                }
                VideoReport.setElementParam(view2, ProfileCardDtReportUtil.IS_REDDOT, str2);
                VideoReport.setElementParam(view2, "nickname", ((Object) c7222b.f187144b.getText()) + "");
                VideoReport.setElementParam(view2, "prefix_content", str);
                VideoReport.setElementParam(view2, "message_digest", ((Object) c7222b.f187145c.getText()) + "");
                VideoReport.setElementParam(view2, "abstract_number", Integer.valueOf(i26));
            } else {
                i16 = 0;
                i17 = 0;
                z16 = false;
            }
            str = "";
            c7222b.f187145c.setExtendText(str, 1);
            c7222b.f187146d.setDragViewType(0, view2);
            com.tencent.mobileqq.subaccount.c.a(c7222b.f187146d, i17, i26, i16, 99, null);
            RedWidgetUtil.fixTextViewLayout(c7222b.f187146d, i26, 99, i16);
            if (AppSetting.f99565y) {
                StringBuilder sb52 = new StringBuilder();
                sb52.append(str3);
                sb52.append(",");
                i18 = bVar.f291098g;
                if (i18 != 0) {
                }
                if (str != null) {
                }
                sb52.append(subAccountMessage.mEmoRecentMsg);
                sb52.append(",");
                sb52.append(subAccountMessage.mTimeString);
                bVar.f291099h = sb52.toString();
            }
            float q162 = com.tencent.mobileqq.utils.ah.q();
            ColorStateList colorStateList3 = resources.getColorStateList(R.color.qui_common_text_secondary);
            ColorStateList colorStateList22 = resources.getColorStateList(R.color.qui_common_text_primary);
            int color2 = resources.getColor(R.color.qui_common_feedback_error);
            c7222b.f187144b.setTextColor(colorStateList22);
            c7222b.f187144b.setExtendTextColor(colorStateList3, 0);
            c7222b.f187144b.setExtendTextSize(12.0f, 0);
            c7222b.f187144b.setCompoundDrawablePadding((int) (3.0f * q162));
            c7222b.f187144b.setExtendTextPadding((int) (5.0f * q162), 2);
            c7222b.f187144b.setExtendTextColor(colorStateList3, 2);
            c7222b.f187144b.setExtendTextSize(17.0f, 2);
            if (!z16) {
            }
            c7222b.f187145c.setExtendTextColor(ColorStateList.valueOf(color2), 1);
            c7222b.f187145c.setExtendTextPadding((int) (q162 * 2.0f), 1);
            c7222b.f187145c.setExtendTextSize(14.0f, 1);
            i(view2, bVar);
            view2.setOnClickListener(this.f187134h);
            if (AppSetting.f99565y) {
                view2.setContentDescription(bVar.f291099h);
            }
            if (this.f187135i) {
                findViewById.setVisibility(8);
            }
            VideoReport.setElementId(view2, "em_bas_message_session");
            VideoReport.setElementEndExposePolicy(view2, EndExposurePolicy.REPORT_ALL);
            if (i26 <= 0) {
            }
            VideoReport.setElementParam(view2, ProfileCardDtReportUtil.IS_REDDOT, str2);
            VideoReport.setElementParam(view2, "nickname", ((Object) c7222b.f187144b.getText()) + "");
            VideoReport.setElementParam(view2, "prefix_content", str);
            VideoReport.setElementParam(view2, "message_digest", ((Object) c7222b.f187145c.getText()) + "");
            VideoReport.setElementParam(view2, "abstract_number", Integer.valueOf(i26));
        }
        return view2;
    }

    private void c(C7222b c7222b, com.tencent.mobileqq.subaccount.b bVar, View view) {
        c7222b.f187144b.setText(bVar.f291093b);
        SubAccountInfo subAccountInfo = (SubAccountInfo) bVar.f291103l;
        if (subAccountInfo != null) {
            AppInterface appInterface = (AppInterface) this.f187132e.getAppRuntime();
            FaceDrawable faceDrawable = FaceDrawable.getFaceDrawable(appInterface, 1, subAccountInfo.subuin);
            if (bVar.f291101j == 0) {
                c7222b.f187147e.setBackgroundDrawable(null);
            } else {
                c7222b.f187147e.setBackgroundResource(R.drawable.skin_subaccount_invalid_status_mask);
            }
            c7222b.f187143a.setImageDrawable(faceDrawable);
            c7222b.f187143a.setTag(subAccountInfo.subuin);
            ISubAccountControlService.a y16 = com.tencent.mobileqq.subaccount.h.y(appInterface, subAccountInfo.subuin);
            if (y16.f291056a > 0 && h()) {
                com.tencent.mobileqq.subaccount.c.a(c7222b.f187146d, 1, y16.f291056a, 0, 99, null);
                RedWidgetUtil.fixTextViewLayout(c7222b.f187146d, y16.f291056a, 99, R.drawable.skin_tips_newmessage);
            } else {
                c7222b.f187146d.setVisibility(8);
            }
        }
        c7222b.f187149g = bVar;
        if (bVar.f291102k) {
            c7222b.f187148f.setScaleX(1.0f);
            c7222b.f187148f.setScaleY(1.0f);
            View view2 = c7222b.f187148f;
            view2.setBackgroundDrawable(view2.getResources().getDrawable(R.drawable.ky5));
        } else {
            c7222b.f187148f.setScaleX(0.93f);
            c7222b.f187148f.setScaleY(0.93f);
            c7222b.f187148f.setBackgroundDrawable(null);
        }
        view.setTag(c7222b);
        if (view instanceof AlphaClickableRelativeLayout) {
            ((AlphaClickableRelativeLayout) view).enableAlphaClick(true);
        }
        view.setOnClickListener(this.f187134h);
        if (AppSetting.f99565y && !TextUtils.isEmpty(bVar.f291099h)) {
            view.setContentDescription(bVar.f291099h);
        }
    }

    private View d(int i3, View view, ViewGroup viewGroup, int i16) {
        C7222b c7222b;
        int i17;
        if (view == null) {
            if (i16 == 7) {
                i17 = R.layout.bzu;
            } else if (i16 == 4) {
                i17 = R.layout.bzw;
            } else {
                i17 = R.layout.bzt;
            }
            view = this.f187131d.inflate(i17, viewGroup, false);
            c7222b = new C7222b();
            view.setTag(c7222b);
        } else {
            c7222b = (C7222b) view.getTag();
        }
        com.tencent.mobileqq.subaccount.b bVar = (com.tencent.mobileqq.subaccount.b) getItem(i3);
        c7222b.f187149g = bVar;
        if (bVar != null) {
            i(view, bVar);
            view.setOnClickListener(this.f187134h);
            if (AppSetting.f99565y && !TextUtils.isEmpty(bVar.f291099h)) {
                view.setContentDescription(bVar.f291099h);
            }
        }
        if (i16 == 4) {
            view.setBackgroundResource(R.drawable.lki);
        }
        return view;
    }

    private View e(int i3, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.f187131d.inflate(R.layout.bzx, viewGroup, false);
            aVar = new a();
            C7222b c7222b = new C7222b();
            aVar.f187137i = c7222b;
            c7222b.f187144b = (SingleLineTextView) view.findViewById(R.id.title);
            aVar.f187137i.f187144b.getPaint().setFakeBoldText(true);
            aVar.f187137i.f187143a = (FixSizeImageView) view.findViewById(R.id.icon);
            aVar.f187137i.f187147e = (ImageView) view.findViewById(R.id.d_c);
            aVar.f187137i.f187146d = (DragTextView) view.findViewById(R.id.kio);
            aVar.f187137i.f187148f = view.findViewById(R.id.vso);
            C7222b c7222b2 = new C7222b();
            aVar.f187138j = c7222b2;
            c7222b2.f187144b = (SingleLineTextView) view.findViewById(R.id.f98195mf);
            aVar.f187138j.f187144b.getPaint().setFakeBoldText(true);
            aVar.f187138j.f187143a = (FixSizeImageView) view.findViewById(R.id.xd_);
            aVar.f187138j.f187147e = (ImageView) view.findViewById(R.id.xdo);
            aVar.f187138j.f187146d = (DragTextView) view.findViewById(R.id.f114366t5);
            aVar.f187138j.f187148f = view.findViewById(R.id.vsp);
            aVar.f187139k = view.findViewById(R.id.d_n);
            aVar.f187140l = view.findViewById(R.id.xe5);
            aVar.f187141m = view.findViewById(R.id.f164031hn);
            ((SingleLineTextView) view.findViewById(R.id.scr)).getPaint().setFakeBoldText(true);
            View view2 = aVar.f187141m;
            if (view2 instanceof AlphaClickableRelativeLayout) {
                ((AlphaClickableRelativeLayout) view2).enableAlphaClick(true);
            }
            aVar.f187141m.setOnClickListener(this.f187134h);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        com.tencent.mobileqq.subaccount.b bVar = (com.tencent.mobileqq.subaccount.b) getItem(i3);
        if (bVar == null) {
            return view;
        }
        aVar.f187149g = bVar;
        i(view, bVar);
        ArrayList arrayList = (ArrayList) bVar.f291103l;
        if (arrayList.size() == 1) {
            aVar.f187139k.setVisibility(0);
            aVar.f187140l.setVisibility(8);
            aVar.f187141m.setVisibility(0);
        } else if (arrayList.size() > 1) {
            aVar.f187139k.setVisibility(0);
            aVar.f187140l.setVisibility(0);
            aVar.f187141m.setVisibility(8);
        }
        for (int i16 = 0; i16 < arrayList.size() && i16 < 2; i16++) {
            com.tencent.mobileqq.subaccount.b bVar2 = (com.tencent.mobileqq.subaccount.b) arrayList.get(i16);
            C7222b c7222b3 = aVar.f187137i;
            View view3 = aVar.f187139k;
            if (i16 == 1) {
                c7222b3 = aVar.f187138j;
                view3 = aVar.f187140l;
            }
            c(c7222b3, bVar2, view3);
        }
        return view;
    }

    private View f(int i3, View view, ViewGroup viewGroup) {
        C7222b c7222b;
        int i16;
        String str;
        int i17 = 0;
        if (view == null) {
            view = this.f187131d.inflate(R.layout.bzy, viewGroup, false);
            c7222b = new C7222b();
            c7222b.f187143a = (FixSizeImageView) view.findViewById(R.id.icon);
            c7222b.f187144b = (SingleLineTextView) view.findViewById(R.id.title);
            c7222b.f187146d = (DragTextView) view.findViewById(R.id.unreadmsg);
            if (view instanceof AlphaClickableRelativeLayout) {
                ((AlphaClickableRelativeLayout) view).enableAlphaClick(true);
            }
            c7222b.f187144b.getPaint().setFakeBoldText(true);
            view.setTag(c7222b);
        } else {
            c7222b = (C7222b) view.getTag();
        }
        com.tencent.mobileqq.subaccount.b bVar = (com.tencent.mobileqq.subaccount.b) getItem(i3);
        if (bVar == null) {
            return view;
        }
        c7222b.f187149g = bVar;
        SimpleAccount simpleAccount = (SimpleAccount) bVar.f291103l;
        FaceDrawable faceDrawable = FaceDrawable.getFaceDrawable((AppInterface) this.f187132e.getAppRuntime(), 1, simpleAccount.getUin());
        c7222b.f187144b.setText(bVar.f291093b);
        c7222b.f187143a.setTag(simpleAccount.getUin());
        c7222b.f187143a.setImageDrawable(faceDrawable);
        c7222b.f187146d.setDragViewType(10, view);
        int i18 = bVar.f291098g;
        if (i18 > 0) {
            i17 = R.drawable.elw;
            i16 = 3;
        } else {
            i16 = 0;
        }
        com.tencent.mobileqq.subaccount.c.a(c7222b.f187146d, i16, i18, i17, 99, null);
        RedWidgetUtil.fixTextViewLayout(c7222b.f187146d, i18, 99, i17);
        view.setOnClickListener(this.f187134h);
        if (AppSetting.f99565y && !TextUtils.isEmpty(bVar.f291099h)) {
            view.setContentDescription(bVar.f291099h);
        }
        VideoReport.setElementId(view, "em_bas_otherqq_accounts");
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementParam(view, "account_uin_clicked", simpleAccount.getUin());
        if (i18 > 0) {
            str = "1";
        } else {
            str = "2";
        }
        VideoReport.setElementParam(view, "is_gray_tips_em", str);
        return view;
    }

    private int g(com.tencent.mobileqq.subaccount.b bVar) {
        String str;
        Object obj;
        int i3 = bVar.f291092a;
        if (i3 != 3 && i3 != 7) {
            return 0;
        }
        Object obj2 = bVar.f291103l;
        if (obj2 instanceof SubAccountMessage) {
            str = ((SubAccountMessage) obj2).subUin;
        } else if (obj2 instanceof SubAccountInfo) {
            str = ((SubAccountInfo) obj2).subuin;
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        com.tencent.mobileqq.subaccount.b bVar2 = this.f187133f.get(0);
        if (bVar2.f291092a == 2 && (obj = bVar2.f291103l) != null && (obj instanceof ArrayList)) {
            ArrayList arrayList = (ArrayList) obj;
            for (int i16 = 0; i16 < arrayList.size(); i16++) {
                SubAccountInfo subAccountInfo = (SubAccountInfo) ((com.tencent.mobileqq.subaccount.b) arrayList.get(i16)).f291103l;
                if (!TextUtils.isEmpty(subAccountInfo.subuin) && subAccountInfo.subuin.equals(str)) {
                    return i16;
                }
            }
        }
        return 0;
    }

    private boolean h() {
        return ((ISubAccountService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(ISubAccountService.class, "")).getNotifySwitch();
    }

    private void i(View view, com.tencent.mobileqq.subaccount.b bVar) {
        if (view != null && bVar != null) {
            int i3 = bVar.f291095d;
            if (i3 != 1 && i3 != 2) {
                if (i3 == 3) {
                    if (bVar.f291102k) {
                        View findViewById = view.findViewById(R.id.dqx);
                        if (findViewById == null) {
                            findViewById = view;
                        }
                        a((UpArrowView) view.findViewById(R.id.f164472yw), bVar);
                        findViewById.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
                    } else {
                        view.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
                    }
                    if (this.f187135i) {
                        View findViewById2 = view.findViewById(R.id.bmt);
                        if (findViewById2 != null) {
                            findViewById2.setVisibility(8);
                        }
                        if (bVar.f291102k) {
                            a((UpArrowView) view.findViewById(R.id.f164472yw), bVar);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            View findViewById3 = view.findViewById(R.id.bmt);
            float q16 = com.tencent.mobileqq.utils.ah.q();
            if (this.f187135i) {
                if (findViewById3 != null) {
                    findViewById3.setVisibility(8);
                }
            } else if (findViewById3 != null) {
                findViewById3.setVisibility(8);
                if (findViewById3.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById3.getLayoutParams();
                    if (bVar.f291095d == 1) {
                        layoutParams.leftMargin = (int) ((q16 * 16.0f) + 0.5d);
                    } else {
                        layoutParams.leftMargin = 0;
                    }
                    findViewById3.setLayoutParams(layoutParams);
                }
            }
            View findViewById4 = view.findViewById(R.id.dre);
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (bVar.f291102k) {
                View findViewById5 = view.findViewById(R.id.dqx);
                if (findViewById5 == null) {
                    findViewById5 = view;
                }
                findViewById5.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
                if (findViewById4 != null) {
                    findViewById4.setVisibility(0);
                }
                layoutParams2.height = (int) view.getResources().getDimension(R.dimen.f158406c35);
                UpArrowView upArrowView = (UpArrowView) view.findViewById(R.id.f164472yw);
                if (upArrowView != null) {
                    a(upArrowView, bVar);
                }
            } else {
                view.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
                if (findViewById4 != null) {
                    findViewById4.setVisibility(8);
                }
                layoutParams2.height = (int) view.getResources().getDimension(R.dimen.f158404f7);
            }
            view.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        ArrayList<com.tencent.mobileqq.subaccount.b> arrayList = this.f187133f;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
        ArrayList<com.tencent.mobileqq.subaccount.b> arrayList = this.f187133f;
        if (arrayList != null && i3 >= 0 && i3 < arrayList.size()) {
            return this.f187133f.get(i3);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this, i3)).longValue();
        }
        if (this.f187133f != null) {
            return i3;
        }
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, i3)).intValue();
        }
        ArrayList<com.tencent.mobileqq.subaccount.b> arrayList = this.f187133f;
        if (arrayList != null && i3 >= 0 && i3 < arrayList.size()) {
            return this.f187133f.get(i3).f291092a;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            d16 = (View) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), view, viewGroup);
        } else {
            int itemViewType = getItemViewType(i3);
            if (QLog.isDevelopLevel()) {
                QLog.d("SUB_ACCOUNT_AssocQQ_Adapter", 2, "getView() position=" + i3 + " viewType=" + itemViewType);
            }
            if (itemViewType != 1) {
                if (itemViewType != 2) {
                    if (itemViewType != 3) {
                        if (itemViewType != 4) {
                            if (itemViewType != 6) {
                                if (itemViewType != 7) {
                                    if (view == null) {
                                        view = this.f187131d.inflate(R.layout.bzv, viewGroup, false);
                                    }
                                    d16 = view;
                                }
                            } else {
                                d16 = f(i3, view, viewGroup);
                            }
                        }
                    } else {
                        d16 = b(i3, view, viewGroup);
                    }
                } else {
                    d16 = e(i3, view, viewGroup);
                }
            }
            d16 = d(i3, view, viewGroup, itemViewType);
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return d16;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 8;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, i3)).booleanValue();
        }
        return false;
    }
}
