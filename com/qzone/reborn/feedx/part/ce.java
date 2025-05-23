package com.qzone.reborn.feedx.part;

import android.R;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ce extends f {

    /* renamed from: e, reason: collision with root package name */
    private com.qzone.reborn.feedx.viewmodel.w f55086e;

    /* renamed from: f, reason: collision with root package name */
    private x6.a f55087f;

    /* JADX INFO: Access modifiers changed from: private */
    public void E9(x6.a aVar) {
        this.f55087f = aVar;
        C9();
    }

    @Override // com.tencent.mobileqq.colornote.f
    public ColorNote getColorNote() {
        String str;
        String str2 = "";
        if (this.f55087f == null) {
            return null;
        }
        String str3 = "qzone_userhome" + this.f55087f.uin;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("visitUin", this.f55087f.uin + "");
        } catch (JSONException e16) {
            QLog.e("QZoneUserHomeColorNotePart", 1, e16, new Object[0]);
        }
        x6.a aVar = this.f55087f;
        if (aVar != null) {
            str = aVar.nickName;
            if (aVar.uin > 0) {
                str2 = new Uri.Builder().scheme(ProtocolDownloaderConstants.PROTOCAL_UIN_DRAWABLE).appendQueryParameter("type", String.valueOf(1)).appendQueryParameter("uin", this.f55087f.uin + "").toString();
            }
        } else {
            str = "\u7a7a\u95f4";
        }
        return new ColorNote.a().g(R.color.darker_gray).i(str3).d(str).h("QQ\u7a7a\u95f4\u4e2a\u4eba\u4e3b\u9875").e(str2).f(jSONObject.toString().getBytes()).a();
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneUserHomeColorNotePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        com.qzone.reborn.feedx.viewmodel.w wVar = (com.qzone.reborn.feedx.viewmodel.w) getViewModel(com.qzone.reborn.feedx.viewmodel.w.class);
        this.f55086e = wVar;
        wVar.C2().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.qzone.reborn.feedx.part.cd
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ce.this.E9((x6.a) obj);
            }
        });
    }
}
