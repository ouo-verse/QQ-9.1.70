package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.utils.ba;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.Observable;
import java.util.Observer;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopAioFeedsCenterView extends RelativeLayout implements Observer {
    static IPatchRedirector $redirector_;
    protected SessionInfo C;
    protected i D;
    protected boolean E;

    /* renamed from: d, reason: collision with root package name */
    protected RelativeLayout f302434d;

    /* renamed from: e, reason: collision with root package name */
    protected LinearLayout f302435e;

    /* renamed from: f, reason: collision with root package name */
    protected TextView f302436f;

    /* renamed from: h, reason: collision with root package name */
    protected TroopFeedsDataManager f302437h;

    /* renamed from: i, reason: collision with root package name */
    protected QQAppInterface f302438i;

    /* renamed from: m, reason: collision with root package name */
    protected Context f302439m;

    public TroopAioFeedsCenterView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        } else {
            this.E = false;
            View.inflate(context, R.layout.ave, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void a(int i3) {
        TroopFeedsDataManager troopFeedsDataManager;
        TroopFeedItem troopFeedItem;
        String str;
        if (i3 >= 0 && (troopFeedsDataManager = this.f302437h) != null && i3 < troopFeedsDataManager.f294801d.size() && (troopFeedItem = this.f302437h.f294801d.get(i3)) != null) {
            int i16 = troopFeedItem.type;
            if (i3 == 0) {
                str = "0";
            } else {
                str = "1";
            }
            String str2 = str;
            if (i16 != 0) {
                if (i16 != 5) {
                    if (i16 != 10) {
                        if (i16 != 12) {
                            if (i16 != 99) {
                                if (i16 != 18) {
                                    if (i16 != 19) {
                                        if (i16 != 131) {
                                            if (i16 == 132) {
                                                ReportController.o(this.f302438i, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_music", 0, 0, this.C.f179557e, str2, "", "");
                                            }
                                        }
                                    } else {
                                        ReportController.o(this.f302438i, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_know", 0, 0, this.C.f179557e, str2, "", "");
                                    }
                                } else {
                                    ReportController.o(this.f302438i, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_photo", 0, 0, this.C.f179557e, str2, "", "");
                                }
                            } else {
                                ReportController.o(this.f302438i, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_other", 0, 0, this.C.f179557e, str2, troopFeedItem.ex_1, "");
                            }
                        } else {
                            ReportController.o(this.f302438i, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_vote", 0, 0, this.C.f179557e, str2, "", "");
                        }
                    } else {
                        ReportController.o(this.f302438i, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_video", 0, 0, this.C.f179557e, str2, "", "");
                    }
                } else {
                    ReportController.o(this.f302438i, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_bulletin", 0, 0, this.C.f179557e, str2, "", "");
                }
                if (!troopFeedItem.isStoryType()) {
                    ReportController.o(this.f302438i, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_story_pgc", 0, 0, this.C.f179557e, "", "", "");
                    return;
                }
                return;
            }
            ReportController.o(this.f302438i, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_file", 0, 0, this.C.f179557e, str2, "", "");
            if (!troopFeedItem.isStoryType()) {
            }
        }
    }

    public View b(ViewGroup viewGroup, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this, (Object) viewGroup, i3);
        }
        TroopFeedsDataManager troopFeedsDataManager = this.f302437h;
        if (troopFeedsDataManager != null && troopFeedsDataManager.f294801d.size() > i3) {
            View c16 = this.D.c(this.f302437h.f294801d.get(i3), i3, true);
            if (c16 != null) {
                viewGroup.removeAllViews();
                viewGroup.addView(c16, 0);
                int dp2px = (int) ba.dp2px(this.f302439m, 15.0f);
                viewGroup.setPadding(dp2px, 0, dp2px, 0);
            }
            return c16;
        }
        return null;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        int size;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) observable, obj);
            return;
        }
        if (obj instanceof Integer) {
            Integer num = (Integer) obj;
            if (num.intValue() != 101 && num.intValue() != 105) {
                if (num.intValue() == 103) {
                    this.f302434d.setVisibility(8);
                    this.f302435e.setVisibility(0);
                    if (NetworkUtil.isNetSupport(this.f302439m)) {
                        this.f302436f.setText(HardCodeUtil.qqStr(R.string.uae));
                        return;
                    } else {
                        this.f302436f.setText(HardCodeUtil.qqStr(R.string.f172803ua4));
                        return;
                    }
                }
                num.intValue();
                return;
            }
            TroopFeedsDataManager troopFeedsDataManager = this.f302437h;
            if (troopFeedsDataManager == null) {
                size = 0;
            } else {
                size = troopFeedsDataManager.f294801d.size();
            }
            if (size == 0) {
                this.f302434d.setVisibility(8);
                this.f302435e.setVisibility(0);
                this.f302436f.setText(HardCodeUtil.qqStr(R.string.ua6));
            } else {
                this.f302434d.setVisibility(0);
                this.f302435e.setVisibility(8);
                b(this.f302434d, 0);
                a(0);
            }
            if (this.f302434d.getVisibility() == 0) {
                this.f302434d.requestFocus();
            }
        }
    }
}
