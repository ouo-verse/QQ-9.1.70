package com.tencent.mobileqq.vas.handler.api.impl;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ClubContentUpdateHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.handler.api.IClubContentUpdateHandler;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ClubContentUpdateHandlerImpl implements IClubContentUpdateHandler {
    @Override // com.tencent.mobileqq.vas.handler.api.IClubContentUpdateHandler
    public void checkJsonVersion(Context context) {
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        ClubContentUpdateHandler clubContentUpdateHandler = (ClubContentUpdateHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.CLUBCONTENTUPDATE_HANDLER);
        if (clubContentUpdateHandler != null) {
            clubContentUpdateHandler.checkJsonVersion(qQAppInterface.getApplication().getApplicationContext());
        }
    }

    @Override // com.tencent.mobileqq.vas.handler.api.IClubContentUpdateHandler
    public void saveQVIPResConfigContent(String str) {
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        ClubContentUpdateHandler clubContentUpdateHandler = (ClubContentUpdateHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.CLUBCONTENTUPDATE_HANDLER);
        if (clubContentUpdateHandler != null) {
            clubContentUpdateHandler.U2(qQAppInterface, str);
        }
    }
}
