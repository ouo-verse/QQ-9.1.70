package com.tencent.mobileqq.teamwork.api.impl;

import android.app.Activity;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.teamwork.api.ITencentDocConvertABTestUtil;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TencentDocConvertABTestUtilImpl implements ITencentDocConvertABTestUtil {
    @Override // com.tencent.mobileqq.teamwork.api.ITencentDocConvertABTestUtil
    public int calcHeightLayoutParam(AppInterface appInterface) {
        return com.tencent.mobileqq.filemanageraux.util.b.a(appInterface);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITencentDocConvertABTestUtil
    public void configureABTest(AppInterface appInterface, Activity activity, View view, TeamWorkFileImportInfo teamWorkFileImportInfo, ITencentDocConvertABTestUtil.a aVar) {
        com.tencent.mobileqq.filemanageraux.util.b.d(appInterface, activity, view, teamWorkFileImportInfo, aVar);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITencentDocConvertABTestUtil
    public List<ta1.h> getWordingConfig() {
        return com.tencent.mobileqq.filemanageraux.util.b.h();
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITencentDocConvertABTestUtil
    public boolean hasConfig(TeamWorkFileImportInfo teamWorkFileImportInfo) {
        return com.tencent.mobileqq.filemanageraux.util.b.i(teamWorkFileImportInfo);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITencentDocConvertABTestUtil
    public boolean hasConfig(String str) {
        return com.tencent.mobileqq.filemanageraux.util.b.j(str);
    }
}
