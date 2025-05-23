package com.tencent.mobileqq.qqexpand.utils.impl;

import android.app.Activity;
import com.tencent.mobileqq.qqexpand.utils.CampusHelper;
import com.tencent.mobileqq.qqexpand.utils.ICampusHelper;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/utils/impl/CampusHelperImpl;", "Lcom/tencent/mobileqq/qqexpand/utils/ICampusHelper;", "()V", "jumpToSchoolCertificateWebPage", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "idx", "", "schoolName", "", "schoolID", "jumpToSchoolFillInWebPage", "serverSuggestSchoolName", "qqexpand_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class CampusHelperImpl implements ICampusHelper {
    @Override // com.tencent.mobileqq.qqexpand.utils.ICampusHelper
    public void jumpToSchoolCertificateWebPage(Activity activity, int idx, String schoolName, String schoolID) {
        CampusHelper.e(activity, idx, schoolName, schoolID);
    }

    @Override // com.tencent.mobileqq.qqexpand.utils.ICampusHelper
    public void jumpToSchoolFillInWebPage(Activity activity, String serverSuggestSchoolName) {
        CampusHelper.f(activity, serverSuggestSchoolName);
    }
}
