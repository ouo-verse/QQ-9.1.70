package fm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.qzone.reborn.base.k;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.webviewplugin.QZoneJsConstants;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends k {
    @Override // com.tencent.biz.richframework.part.Part
    public String getLogTag() {
        return "QZonePublishMoodPageConfigPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        b bVar = (b) getViewModel(b.class);
        Intent intent = activity.getIntent();
        bVar.c2(ro.a.a(intent));
        bVar.Z1("\u52a8\u611f\u5f71\u96c6".equals(intent.getStringExtra("shareSource")));
        boolean booleanExtra = intent.getBooleanExtra(QZoneJsConstants.DYNAMIC_ALBUM_IS_FROM_DRAFT, false);
        bVar.W1(booleanExtra);
        boolean equalsIgnoreCase = QZoneHelper.Constants.INTENT_ACTION_QZONE_OPEN_SHARE.equalsIgnoreCase(intent.getAction());
        bVar.b2(equalsIgnoreCase);
        bVar.a2(intent.getIntExtra(QZoneHelper.Constants.KEY_PUBLISH_COME_FROM, -1) == 4);
        bVar.X1(intent.getBooleanExtra(QZoneShareManager.QZONE_SHARE_FROM_MINI_APP, false));
        bVar.U1(true);
        String action = intent.getAction();
        if (!TextUtils.isEmpty(action) && action.equals(QZoneHelper.Constants.INTENT_ACTION_PUBLISH_QR_CODE)) {
            bVar.U1(false);
        }
        if (equalsIgnoreCase || booleanExtra) {
            bVar.U1(false);
        }
    }
}
