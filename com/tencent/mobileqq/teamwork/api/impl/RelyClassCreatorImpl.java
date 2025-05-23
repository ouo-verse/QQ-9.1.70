package com.tencent.mobileqq.teamwork.api.impl;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamwork.api.IRelyClassCreator;
import com.tencent.mobileqq.teamwork.api.ISimpleTextView;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class RelyClassCreatorImpl implements IRelyClassCreator {
    @Override // com.tencent.mobileqq.teamwork.api.IRelyClassCreator
    public ISimpleTextView getSimpleTextViewImpl(Context context) {
        return new SimpleTextViewImpl(context);
    }

    @Override // com.tencent.mobileqq.teamwork.api.IRelyClassCreator
    public com.tencent.mobileqq.teamwork.api.a getTeamWorkFileImportForH5(Object obj, AppInterface appInterface) {
        if ((obj instanceof TeamWorkFileImportInfo) && (appInterface instanceof QQAppInterface)) {
            return new com.tencent.mobileqq.teamwork.y((TeamWorkFileImportInfo) obj, (QQAppInterface) appInterface);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.teamwork.api.IRelyClassCreator
    public com.tencent.mobileqq.teamwork.api.a getTeamWorkFileImportJobForC2C(Object obj, AppInterface appInterface) {
        if ((obj instanceof TeamWorkFileImportInfo) && (appInterface instanceof QQAppInterface)) {
            return new com.tencent.mobileqq.teamwork.aa((TeamWorkFileImportInfo) obj, (QQAppInterface) appInterface);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.teamwork.api.IRelyClassCreator
    public com.tencent.mobileqq.teamwork.api.a getTeamWorkFileImportJobForDisc(Object obj, AppInterface appInterface) {
        if ((obj instanceof TeamWorkFileImportInfo) && (appInterface instanceof QQAppInterface)) {
            return new com.tencent.mobileqq.teamwork.ac((TeamWorkFileImportInfo) obj, (QQAppInterface) appInterface);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.teamwork.api.IRelyClassCreator
    public com.tencent.mobileqq.teamwork.api.a getTeamWorkFileImportJobForGroup(Object obj, AppInterface appInterface) {
        if ((obj instanceof TeamWorkFileImportInfo) && (appInterface instanceof QQAppInterface)) {
            return new com.tencent.mobileqq.teamwork.ae((TeamWorkFileImportInfo) obj, (QQAppInterface) appInterface);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.teamwork.api.IRelyClassCreator
    public JSONObject queryFileEntityInfo(Object obj, AppInterface appInterface) {
        if ((obj instanceof TeamWorkFileImportInfo) && (appInterface instanceof QQAppInterface)) {
            return com.tencent.mobileqq.teamwork.aa.e(obj, appInterface);
        }
        return null;
    }
}
