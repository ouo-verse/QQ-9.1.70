package com.qzone.reborn.feedx.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellTheme;
import com.qzone.proxy.feedcomponent.model.User;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.flashname.IFlashNickNameComponent;
import com.tencent.mobileqq.vip.api.IVipColorName;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Foreground;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneNickNameView extends QZoneRichTextView {
    private CellTheme N;
    private boolean P;
    private QZoneFlashNickNameHelper Q;
    private boolean R;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements IFlashNickNameComponent.a {
        a() {
        }

        @Override // com.tencent.mobileqq.vas.flashname.IFlashNickNameComponent.a
        public void a() {
            QZoneNickNameView.this.c();
        }
    }

    public QZoneNickNameView(Context context) {
        super(context);
        this.P = true;
        this.Q = new QZoneFlashNickNameHelper();
        this.R = ar.b("shouyouye", "2025-01-16", "vas_bug_fix_137127675").isEnable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(String str, String str2, BusinessFeedData businessFeedData) {
        try {
            if (getPaint() != null && this.P) {
                if (this.R) {
                    c();
                    this.Q.b(this);
                }
                if (str.equals("4")) {
                    getPaint().setShader(IVipColorName.INSTANCE.getShaderAct(getWidth()));
                    if (TextUtils.isEmpty(str2)) {
                        o(str);
                        return;
                    }
                    p(str, 100);
                    n(str2);
                    QLog.i("QZoneNickNameView", 1, "nick Url: " + str2 + " data:" + businessFeedData.getUser());
                    return;
                }
                if (str.equals("3")) {
                    getPaint().setShader(IVipColorName.INSTANCE.getShader(getWidth(), getHeight()));
                    o(str);
                    return;
                } else if (!str.equals("0")) {
                    o(str);
                    return;
                } else {
                    j();
                    this.Q.b(this);
                    return;
                }
            }
            if (this.R) {
                c();
                this.Q.b(this);
            }
        } catch (Exception e16) {
            QLog.e("QZoneNickNameView", 1, "parse error " + e16);
        }
    }

    private void n(String str) {
        String str2;
        Context context = getContext();
        if (context instanceof Activity) {
            str2 = String.valueOf(context.hashCode());
        } else {
            Activity topActivity = Foreground.getTopActivity();
            if (topActivity != null) {
                str2 = String.valueOf(topActivity.hashCode());
            } else {
                str2 = "";
            }
        }
        this.Q.a(this, "qzone" + str2, false, str, 3, new a());
    }

    private void p(String str, int i3) {
        j();
        this.f49210d = Integer.parseInt(str);
        this.f49211e = i3;
        this.f49212f = 22.56f;
        i();
    }

    @Override // com.qzone.personalize.flashnickname.ui.FlashCellTextView, com.qzone.proxy.feedcomponent.text.CellTextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setEnableFlash(boolean z16) {
        this.P = z16;
    }

    public void setTheme(User user, CellTheme cellTheme, String str, int i3) {
        this.N = cellTheme;
        if (user == null) {
            return;
        }
        if (user.vip > 0 && !str.equals("0")) {
            if (str.equals("2")) {
                super.setTextColor(getContext().getColor(R.color.cna));
                return;
            } else {
                super.setTextColor(getContext().getColor(R.color.a6v));
                return;
            }
        }
        CellTheme cellTheme2 = this.N;
        if (cellTheme2 != null) {
            super.setTextColor(cellTheme2.majorForeColor);
        } else {
            super.setTextColor(i3);
        }
    }

    private void o(String str) {
        p(str, 1);
    }

    public void setData(final BusinessFeedData businessFeedData, int i3) {
        final String str;
        if (businessFeedData != null && businessFeedData.getUser() != null) {
            User user = businessFeedData.getUser();
            setRichText(user.nickName);
            final String str2 = "";
            if (businessFeedData.cellMallInfo != null) {
                str = "" + businessFeedData.cellMallInfo.nickTypeId;
                str2 = businessFeedData.cellMallInfo.nickUrl;
            } else {
                str = "0";
            }
            setTheme(user, businessFeedData.getCellTheme(), str, i3);
            post(new Runnable() { // from class: com.qzone.reborn.feedx.widget.d
                @Override // java.lang.Runnable
                public final void run() {
                    QZoneNickNameView.this.m(str, str2, businessFeedData);
                }
            });
            return;
        }
        clearText();
    }

    public QZoneNickNameView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.P = true;
        this.Q = new QZoneFlashNickNameHelper();
        this.R = ar.b("shouyouye", "2025-01-16", "vas_bug_fix_137127675").isEnable(true);
    }

    public QZoneNickNameView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.P = true;
        this.Q = new QZoneFlashNickNameHelper();
        this.R = ar.b("shouyouye", "2025-01-16", "vas_bug_fix_137127675").isEnable(true);
    }
}
