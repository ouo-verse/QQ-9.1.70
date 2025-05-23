package com.tencent.mobileqq.mini.forward;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.e;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ForwardMiniChooseFriendOption extends ForwardBaseOption {
    public static final String RESULT_LIST = "results";
    private static final String TAG = "ForwardMiniChooseFriendOption";

    public ForwardMiniChooseFriendOption(Intent intent) {
        super(intent);
    }

    private Intent buildMultiResult(Bundle bundle) {
        Intent intent = new Intent();
        ArrayList<ResultRecord> parcelableArrayList = bundle.getParcelableArrayList(AppConstants.Key.FORWARD_MULTI_TARGET);
        ArrayList arrayList = new ArrayList();
        intent.putExtra(RESULT_LIST, arrayList);
        if (parcelableArrayList == null) {
            QLog.e(TAG, 1, "resultRecordList is null");
            return intent;
        }
        for (ResultRecord resultRecord : parcelableArrayList) {
            MiniPluginForwardResult miniPluginForwardResult = new MiniPluginForwardResult();
            miniPluginForwardResult.type = String.valueOf(resultRecord.getUinType());
            miniPluginForwardResult.uin = resultRecord.uin;
            miniPluginForwardResult.name = resultRecord.name;
            arrayList.add(miniPluginForwardResult);
        }
        return intent;
    }

    private Intent buildSingleResult(Bundle bundle) {
        Intent intent = new Intent();
        ArrayList arrayList = new ArrayList();
        intent.putExtra(RESULT_LIST, arrayList);
        MiniPluginForwardResult miniPluginForwardResult = new MiniPluginForwardResult();
        miniPluginForwardResult.uin = bundle.getString("uin", "");
        miniPluginForwardResult.type = String.valueOf(bundle.getInt("uintype", 0));
        miniPluginForwardResult.name = bundle.getString("uinname", "");
        arrayList.add(miniPluginForwardResult);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardAbility() {
        this.mForwardAbilities.add(e.O3);
        this.mForwardAbilities.add(e.Q3);
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardDialog(int i3, Bundle bundle) {
        Intent buildSingleResult;
        if (this.mActivity == null) {
            QLog.e(TAG, 1, "buildForwardDialog but activity is null");
            return;
        }
        if (!bundle.containsKey("uinname")) {
            buildSingleResult = buildMultiResult(bundle);
        } else {
            buildSingleResult = buildSingleResult(bundle);
        }
        this.mActivity.setResult(-1, buildSingleResult);
        this.mActivity.finish();
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean preloadData() {
        return super.preloadData();
    }
}
