package com.qzone.reborn.feedx.part;

import android.R;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.lifecycle.Observer;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.reborn.feedx.viewmodel.QZoneBlogDetailViewModel;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes37.dex */
public class i extends f {

    /* renamed from: e, reason: collision with root package name */
    private final boolean f55266e;

    /* renamed from: f, reason: collision with root package name */
    private com.qzone.reborn.feedx.viewmodel.h f55267f;

    /* renamed from: h, reason: collision with root package name */
    private BusinessFeedData f55268h;

    public i(boolean z16) {
        this.f55266e = z16;
    }

    private JSONObject E9(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", this.f55267f.T1());
            jSONObject.put(s4.c.CELLID, this.f55267f.U1() + "");
            jSONObject.put("subid", this.f55267f.n2() + "");
            jSONObject.put("uin", this.f55267f.r2());
            jSONObject.put("source", this.f55267f.h2());
            jSONObject.put("mainTitle", str + "");
            jSONObject.put(QCircleLpReportDc010001.KEY_SUBTYPE, str2 + "");
        } catch (JSONException e16) {
            QLog.e("QZoneDetailColorNotePart", 1, e16, new Object[0]);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F9(UIStateData<BusinessFeedData> uIStateData) {
        if (this.f55267f == null) {
            RFWLog.e("QZoneDetailColorNotePart", RFWLog.USR, "view model is null");
            return;
        }
        if (uIStateData == null || uIStateData.getData() == null) {
            return;
        }
        this.f55268h = uIStateData.getData();
        com.qzone.reborn.feedx.viewmodel.h hVar = this.f55267f;
        if (hVar == null || hVar.x2()) {
            return;
        }
        C9();
    }

    private Pair<String, String> G9(String str, String str2) {
        String str3;
        String str4;
        String str5 = this.f55268h.getUser().nickName;
        if (!TextUtils.isEmpty(str5) && str5.length() > 6) {
            str5 = str5.substring(0, 5) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        if (this.f55267f.T1() == 4) {
            str3 = H9(str5);
        } else if (this.f55267f.T1() == 2) {
            str3 = str5 + "\u7684\u65e5\u5fd7";
        } else {
            str3 = str5 + "\u7684\u8bf4\u8bf4";
        }
        if (!TextUtils.isEmpty(this.f55268h.getFeedCommInfo().feedskey)) {
            str4 = "qzone_detail" + this.f55268h.getFeedCommInfo().feedskey;
        } else {
            str4 = "qzone_detail" + this.f55267f.T1() + this.f55267f.U1() + this.f55267f.n2() + this.f55267f.r2() + this.f55267f.h2();
        }
        return new Pair<>(str3, str4);
    }

    private String H9(String str) {
        boolean z16;
        if (this.f55268h.getPictureInfo() != null && this.f55268h.getPictureInfo().pics != null && this.f55268h.getPictureInfo().pics.size() > 0) {
            Iterator<PictureItem> it = this.f55268h.getPictureInfo().pics.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z16 = false;
                    break;
                }
                z16 = true;
                if (it.next().videoflag != 1) {
                    break;
                }
            }
            if (z16) {
                return str + "\u7684\u7167\u7247";
            }
            return str + "\u7684\u89c6\u9891";
        }
        if (this.f55268h.getVideoInfo() == null) {
            return str;
        }
        return str + "\u7684\u89c6\u9891";
    }

    @Override // com.tencent.mobileqq.colornote.f
    public ColorNote getColorNote() {
        String str = "qzone_detail" + toString();
        BusinessFeedData businessFeedData = this.f55268h;
        if (businessFeedData == null || this.f55267f == null) {
            return null;
        }
        String str2 = "\u8be6\u60c5\u9875";
        if (!TextUtils.isEmpty(businessFeedData.getUser().nickName)) {
            Pair<String, String> G9 = G9("\u8be6\u60c5\u9875", str);
            str2 = (String) G9.first;
            str = (String) G9.second;
        } else if (!TextUtils.isEmpty(this.f55267f.k2())) {
            str2 = this.f55267f.k2();
            str = this.f55267f.o2();
        } else if (this.f55266e) {
            QZoneBlogDetailViewModel qZoneBlogDetailViewModel = (QZoneBlogDetailViewModel) this.f55267f;
            if (!TextUtils.isEmpty(qZoneBlogDetailViewModel.T2()) && !TextUtils.isEmpty(qZoneBlogDetailViewModel.S2())) {
                str2 = qZoneBlogDetailViewModel.S2() + "\u7684\u65e5\u5fd7";
                str = "qzone_detail" + qZoneBlogDetailViewModel.T2();
            }
        }
        String str3 = "";
        if (this.f55267f.r2() > 0) {
            str3 = new Uri.Builder().scheme(ProtocolDownloaderConstants.PROTOCAL_UIN_DRAWABLE).appendQueryParameter("type", String.valueOf(1)).appendQueryParameter("uin", this.f55267f.r2() + "").toString();
        }
        return new ColorNote.a().g(R.color.darker_gray).i(str).d(str2).h("QQ\u7a7a\u95f4\u52a8\u6001\u8be6\u60c5").e(str3).f(E9(str2, str).toString().getBytes()).a();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        if (this.f55266e) {
            this.f55267f = (com.qzone.reborn.feedx.viewmodel.h) getViewModel(QZoneBlogDetailViewModel.class);
        } else {
            this.f55267f = (com.qzone.reborn.feedx.viewmodel.h) getViewModel(com.qzone.reborn.feedx.viewmodel.h.class);
        }
        this.f55267f.f55901m.observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.qzone.reborn.feedx.part.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                i.this.F9((UIStateData) obj);
            }
        });
    }
}
