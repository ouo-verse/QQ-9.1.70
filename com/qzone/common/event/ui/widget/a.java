package com.qzone.common.event.ui.widget;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.qzone.business.share.ShareUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.FeedActionPanelActivity;
import com.qzone.detail.ui.component.g;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.proxy.feedcomponent.util.d;
import com.qzone.proxy.feedcomponent.util.j;
import com.qzone.reborn.comment.bean.QZoneCommentPanelParams;
import com.qzone.util.ToastUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.api.QZoneContant;
import cooperation.qzone.util.NetworkState;
import ho.i;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private int f45932a;

    /* renamed from: b, reason: collision with root package name */
    private List<Integer> f45933b;

    /* renamed from: c, reason: collision with root package name */
    public g f45934c;

    /* renamed from: d, reason: collision with root package name */
    private Activity f45935d;

    /* renamed from: g, reason: collision with root package name */
    private b f45938g;

    /* renamed from: h, reason: collision with root package name */
    private String f45939h;

    /* renamed from: i, reason: collision with root package name */
    private String f45940i;

    /* renamed from: j, reason: collision with root package name */
    private String f45941j;

    /* renamed from: k, reason: collision with root package name */
    private String f45942k;

    /* renamed from: l, reason: collision with root package name */
    private String f45943l;

    /* renamed from: e, reason: collision with root package name */
    private int f45936e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f45937f = 0;

    /* renamed from: m, reason: collision with root package name */
    private ShareActionSheet.OnItemClickListener f45944m = new C0369a();

    /* compiled from: P */
    /* renamed from: com.qzone.common.event.ui.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    class C0369a implements ShareActionSheet.OnItemClickListener {
        C0369a() {
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
        public void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
            g gVar = a.this.f45934c;
            if (gVar != null) {
                gVar.dismiss();
                a.this.h(actionSheetItem);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface b {
        void X1(int i3);
    }

    public a(Activity activity, List<Integer> list, b bVar) {
        this.f45935d = activity;
        this.f45933b = list;
        this.f45938g = bVar;
    }

    private boolean b(int i3) {
        if (!bl.b(this.f45933b)) {
            return this.f45933b.contains(Integer.valueOf(i3));
        }
        return d.j(this.f45932a, i3);
    }

    private void d(String str, String str2, String str3, String str4, String str5, boolean z16, long j3, int i3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return;
        }
        ShareUtils.e eVar = new ShareUtils.e();
        eVar.f44740a = str3;
        eVar.f44711h = 2;
        eVar.f44712i = str5;
        eVar.f44713j = 1;
        eVar.f44741b = str;
        eVar.f44742c = str2;
        eVar.f44714k = this.f45935d.getString(R.string.gg_);
        eVar.f44715l = true;
        eVar.f44743d = str4;
        eVar.f44716m = z16;
        eVar.f44717n = j3;
        eVar.f44718o = i3;
        if (!TextUtils.isEmpty(this.f45943l)) {
            String str6 = this.f45943l;
            eVar.b(str6, "", f(str6));
        }
        ShareUtils.n(this.f45935d, eVar, 0);
    }

    private void e(String str) {
        ShareUtils.g gVar = new ShareUtils.g();
        gVar.f44743d = this.f45942k;
        gVar.f44741b = this.f45939h;
        gVar.f44742c = this.f45940i;
        gVar.f44740a = str;
        if (j.g()) {
            j.a("QZoneSharePanel", 2, "itemTag: " + this.f45936e);
        }
        ShareUtils.q(this.f45935d, this.f45936e, gVar);
    }

    private String f(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("app")) {
                return "";
            }
            return jSONObject.get("app").toString();
        } catch (JSONException e16) {
            j.d("QZoneSharePanel", "[getViewIdFromArkContent] error: ", e16);
            return "";
        }
    }

    private void g() {
        if (this.f45934c == null) {
            g.a aVar = new g.a();
            Activity activity = this.f45935d;
            if (activity instanceof BasePluginActivity) {
                activity = ((BasePluginActivity) activity).getOutActivity();
            }
            aVar.context = activity;
            g gVar = new g(aVar);
            this.f45934c = gVar;
            gVar.setActionSheetTitle(activity.getString(R.string.hja));
            this.f45934c.setIntentForStartForwardRecentActivity(new Intent());
            this.f45934c.setItemClickListenerV2(this.f45944m);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (b(1)) {
                arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
            }
            if (b(14)) {
                arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
            }
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
            int i3 = this.f45937f;
            if (i3 == 1) {
                arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(102));
            } else if (i3 == 2) {
                arrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(103));
            }
            this.f45934c.setActionSheetItems(arrayList, arrayList2);
        }
    }

    public void i(int i3) {
        this.f45937f = i3;
    }

    public void j(String str, String str2, String str3, String str4, String str5) {
        this.f45939h = str;
        this.f45940i = str2;
        this.f45941j = str3;
        this.f45942k = str4;
        this.f45943l = str5;
    }

    public void k() {
        if (this.f45934c == null) {
            g();
        }
        if (this.f45934c.isShowing()) {
            this.f45934c.dismiss();
        } else {
            this.f45934c.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        b bVar;
        if (actionSheetItem == null) {
            return;
        }
        int i3 = actionSheetItem.action;
        if (i3 == 2) {
            c(this.f45939h, this.f45940i, this.f45941j, this.f45942k, QZoneShareManager.QQ_SHARE_APPID);
            ClickReport.q("629", "3", "2", true);
            return;
        }
        if (i3 == 3) {
            if (this.f45935d != null) {
                if (!NetworkState.isNetSupport()) {
                    ToastUtil.n(R.string.ghi);
                    return;
                }
                i.c().r(new QZoneCommentPanelParams.a().y(QZoneContant.REQUEST_CODE_EVENT_TAG_FORWARD).g(LoginData.getInstance().getUin() + "_" + this.f45939h).A(FeedActionPanelActivity.I1).getParams(), this.f45935d);
            }
            ClickReport.q("629", "3", "3", true);
            return;
        }
        if (i3 == 9) {
            this.f45936e = 9;
            e(this.f45941j);
            return;
        }
        if (i3 == 10) {
            this.f45936e = 10;
            e(this.f45941j);
            return;
        }
        if (i3 == 72) {
            d(this.f45939h, this.f45940i, this.f45941j, this.f45942k, QZoneShareManager.QQ_SHARE_APPID, true, Long.parseLong(actionSheetItem.uin), actionSheetItem.uinType);
            ClickReport.q("629", "3", "2", true);
        } else {
            if (i3 != 102) {
                if (i3 == 103 && (bVar = this.f45938g) != null) {
                    bVar.X1(1);
                    return;
                }
                return;
            }
            b bVar2 = this.f45938g;
            if (bVar2 != null) {
                bVar2.X1(2);
            }
        }
    }

    private void c(String str, String str2, String str3, String str4, String str5) {
        d(str, str2, str3, str4, str5, false, 0L, 0);
    }
}
