package com.tencent.biz.pubaccount;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp$ButtonInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import okhttp3.HttpUrl;

/* loaded from: classes32.dex */
public class PublicAccountMenuBar extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private Context f78824d;

    /* renamed from: e, reason: collision with root package name */
    private QQAppInterface f78825e;

    /* renamed from: f, reason: collision with root package name */
    private String f78826f;

    /* renamed from: h, reason: collision with root package name */
    private MqqHandler f78827h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f78828i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f78829d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ mobileqq_mp$ButtonInfo f78830e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.tencent.biz.ui.c f78831f;

        a(boolean z16, mobileqq_mp$ButtonInfo mobileqq_mp_buttoninfo, com.tencent.biz.ui.c cVar) {
            this.f78829d = z16;
            this.f78830e = mobileqq_mp_buttoninfo;
            this.f78831f = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f78829d) {
                PublicAccountMenuBar.this.l(this.f78830e);
            } else {
                PublicAccountMenuBar.this.f(this.f78831f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f78833d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ActionSheet f78834e;

        b(List list, ActionSheet actionSheet) {
            this.f78833d = list;
            this.f78834e = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            try {
                if (PublicAccountMenuBar.this.f78828i) {
                    return;
                }
                PublicAccountMenuBar.this.f78828i = true;
                if (i3 == 0) {
                    PublicAccountMenuBar.this.f78828i = false;
                    return;
                }
                com.tencent.biz.ui.c cVar = (com.tencent.biz.ui.c) this.f78833d.get(i3 - 1);
                if (cVar == null) {
                    PublicAccountMenuBar.this.f78828i = false;
                } else {
                    PublicAccountMenuBar.this.f(cVar);
                    this.f78834e.dismiss();
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c implements DialogInterface.OnDismissListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            PublicAccountMenuBar.this.f78828i = false;
        }
    }

    public PublicAccountMenuBar(Context context) {
        super(context);
        i(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.tencent.biz.ui.c cVar) {
        if (cVar != null) {
            try {
                String d16 = cVar.d();
                int e16 = cVar.e();
                if (this.f78825e == null || this.f78826f == null || this.f78827h == null) {
                    return;
                }
                ((IPublicAccountManager) QRoute.api(IPublicAccountManager.class)).handleButtonEvent(d16, this.f78824d, this.f78825e, this.f78826f, e16, null, this.f78827h, 2, new SessionInfo());
                mobileqq_mp$ButtonInfo buttonInfoByMenuId = ((IPublicAccountManager) QRoute.api(IPublicAccountManager.class)).getButtonInfoByMenuId(this.f78825e, this.f78826f, e16);
                if (buttonInfoByMenuId != null) {
                    xx.b.INSTANCE.q(this.f78826f, buttonInfoByMenuId.f247282id.get(), buttonInfoByMenuId.name.get());
                }
            } catch (Exception e17) {
                e17.printStackTrace();
            }
        }
    }

    private List<mobileqq_mp$ButtonInfo> g(List<mobileqq_mp$ButtonInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (mobileqq_mp$ButtonInfo mobileqq_mp_buttoninfo : list) {
                if (mobileqq_mp_buttoninfo != null) {
                    if (k(mobileqq_mp_buttoninfo)) {
                        arrayList.add(mobileqq_mp_buttoninfo);
                    } else if (mobileqq_mp_buttoninfo.sub_button.has()) {
                        Iterator<mobileqq_mp$ButtonInfo> it = mobileqq_mp_buttoninfo.sub_button.get().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            if (k(it.next())) {
                                arrayList.add(mobileqq_mp_buttoninfo);
                                break;
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private void i(Context context) {
        this.f78824d = context;
        setVisibility(8);
    }

    public void j(QQAppInterface qQAppInterface, String str, MqqHandler mqqHandler) {
        this.f78825e = qQAppInterface;
        this.f78826f = str;
        this.f78827h = mqqHandler;
    }

    public void setData(List<mobileqq_mp$ButtonInfo> list) {
        String str;
        List<mobileqq_mp$ButtonInfo> g16 = g(list);
        if (g16 == null || g16.size() <= 0) {
            return;
        }
        setVisibility(0);
        int size = g16.size();
        removeAllViews();
        int i3 = 0;
        while (i3 < size) {
            mobileqq_mp$ButtonInfo mobileqq_mp_buttoninfo = g16.get(i3);
            String str2 = "";
            if (!mobileqq_mp_buttoninfo.key.has()) {
                str = "";
            } else {
                str = mobileqq_mp_buttoninfo.key.get();
            }
            if (mobileqq_mp_buttoninfo.name.has()) {
                str2 = mobileqq_mp_buttoninfo.name.get();
            }
            com.tencent.biz.ui.c cVar = new com.tencent.biz.ui.c(str, str2, null, mobileqq_mp_buttoninfo.f247282id.has() ? mobileqq_mp_buttoninfo.f247282id.get() : 0);
            cVar.k(mobileqq_mp_buttoninfo);
            e(cVar, mobileqq_mp_buttoninfo, i3 == size + (-1));
            xx.b.INSTANCE.r(this.f78826f, mobileqq_mp_buttoninfo.f247282id.get(), mobileqq_mp_buttoninfo.name.get());
            i3++;
        }
    }

    public PublicAccountMenuBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i(context);
    }

    private CharSequence h(com.tencent.biz.ui.c cVar) {
        if (cVar == null) {
            return "";
        }
        Drawable drawable = this.f78824d.getResources().getDrawable(R.drawable.qui_chat_settings_icon_tertiary, null);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI + cVar.i());
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        VerticalCenterImageSpan verticalCenterImageSpan = new VerticalCenterImageSpan(drawable, 0);
        verticalCenterImageSpan.setPadding(ViewUtils.dip2px(2.0f), ViewUtils.dip2px(2.0f));
        spannableStringBuilder.setSpan(verticalCenterImageSpan, 0, 2, 18);
        return spannableStringBuilder;
    }

    private void e(com.tencent.biz.ui.c cVar, mobileqq_mp$ButtonInfo mobileqq_mp_buttoninfo, boolean z16) {
        if (cVar == null) {
            return;
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.f78824d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        TextView textView = new TextView(this.f78824d);
        boolean has = mobileqq_mp_buttoninfo.sub_button.has();
        if (has) {
            textView.setText(h(cVar));
        } else {
            textView.setText(cVar.i());
        }
        textView.setTextSize(16.0f);
        textView.setTextColor(this.f78824d.getColor(R.color.qui_common_text_primary));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13, -1);
        relativeLayout.addView(textView, layoutParams2);
        if (!z16) {
            View view = new View(this.f78824d);
            view.setBackgroundResource(R.drawable.llj);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(ViewUtils.dip2px(0.5f), ViewUtils.dip2px(25.0f));
            layoutParams3.addRule(11, -1);
            layoutParams3.addRule(15, -1);
            relativeLayout.addView(view, layoutParams3);
        }
        relativeLayout.setOnClickListener(new a(has, mobileqq_mp_buttoninfo, cVar));
        PublicAccountDetailActivityImpl.setDatatongElement(relativeLayout, "gzh_ele_enter_subprofile", this.f78826f);
        addView(relativeLayout, layoutParams);
    }

    private boolean k(mobileqq_mp$ButtonInfo mobileqq_mp_buttoninfo) {
        if (mobileqq_mp_buttoninfo != null) {
            if ((mobileqq_mp_buttoninfo.type.has() ? mobileqq_mp_buttoninfo.type.get() : 0) == 2 && mobileqq_mp_buttoninfo.url.has() && !TextUtils.isEmpty(mobileqq_mp_buttoninfo.url.get())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(mobileqq_mp$ButtonInfo mobileqq_mp_buttoninfo) {
        String str;
        String str2;
        String str3;
        String str4;
        if (mobileqq_mp_buttoninfo == null) {
            return;
        }
        if (!mobileqq_mp_buttoninfo.key.has()) {
            str = "";
        } else {
            str = mobileqq_mp_buttoninfo.key.get();
        }
        if (!mobileqq_mp_buttoninfo.name.has()) {
            str2 = "";
        } else {
            str2 = mobileqq_mp_buttoninfo.name.get();
        }
        com.tencent.biz.ui.c cVar = new com.tencent.biz.ui.c(str, str2, null, mobileqq_mp_buttoninfo.f247282id.has() ? mobileqq_mp_buttoninfo.f247282id.get() : 0);
        cVar.k(mobileqq_mp_buttoninfo);
        List<mobileqq_mp$ButtonInfo> list = mobileqq_mp_buttoninfo.sub_button.has() ? mobileqq_mp_buttoninfo.sub_button.get() : null;
        if (list != null && list.size() > 0) {
            for (mobileqq_mp$ButtonInfo mobileqq_mp_buttoninfo2 : list) {
                if (k(mobileqq_mp_buttoninfo2)) {
                    if (!mobileqq_mp_buttoninfo2.key.has()) {
                        str3 = "";
                    } else {
                        str3 = mobileqq_mp_buttoninfo2.key.get();
                    }
                    if (!mobileqq_mp_buttoninfo2.name.has()) {
                        str4 = "";
                    } else {
                        str4 = mobileqq_mp_buttoninfo2.name.get();
                    }
                    com.tencent.biz.ui.c cVar2 = new com.tencent.biz.ui.c(str3, str4, null, mobileqq_mp_buttoninfo2.f247282id.has() ? mobileqq_mp_buttoninfo2.f247282id.get() : 0);
                    cVar2.k(mobileqq_mp_buttoninfo2);
                    cVar.a(cVar2);
                }
            }
        }
        List<com.tencent.biz.ui.c> h16 = cVar.h();
        if (h16 == null || h16.size() <= 0) {
            return;
        }
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this.f78824d, null);
        actionSheet.setRoundCornerTop(true);
        actionSheet.addButton(cVar.i(), 11);
        for (com.tencent.biz.ui.c cVar3 : h16) {
            if (cVar3 != null) {
                String c16 = cVar3.c();
                if (!TextUtils.isEmpty(c16)) {
                    actionSheet.addButtonWithLeftUrlIcon(cVar3.i(), c16);
                } else {
                    actionSheet.addButton(cVar3.i());
                }
            }
        }
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnButtonClickListener(new b(h16, actionSheet));
        actionSheet.setOnDismissListener(new c());
        actionSheet.show();
    }

    public PublicAccountMenuBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        i(context);
    }
}
