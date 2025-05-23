package com.tencent.mobileqq.vas.quickupdate;

import android.text.TextUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.qphone.base.util.QLog;
import cooperation.photoplus.sticker.Sticker;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class RingUpdateBusiness extends QQVasUpdateBusiness {
    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public long getBid() {
        return 37L;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    protected String getBusinessDir() {
        return IndividuationUrlHelper.UrlId.RING_HOME;
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public String getFrom() {
        return IndividuationUrlHelper.UrlId.RING_HOME;
    }

    public String getName(int i3) {
        String readFileContent = FileUtils.readFileContent(new File(getSavePath(i3) + File.separator + i3 + Sticker.JSON_SUFFIX));
        if (!TextUtils.isEmpty(readFileContent)) {
            try {
                return new JSONObject(readFileContent).optString("name", null);
            } catch (JSONException e16) {
                QLog.e("VasUpdate_QQBusiness", 1, "getName error", e16);
            }
        } else {
            QLog.e("VasUpdate_QQBusiness", 1, "getName missing json: " + i3);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public String getScid(int i3) {
        return "specialRing." + i3;
    }

    public String getWavPath(int i3) {
        return getSavePath(i3) + File.separator + i3 + ".wav";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isEnableCheckFile() {
        return true;
    }
}
