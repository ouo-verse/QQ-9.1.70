package com.tencent.mobileqq.guild.api.aiopopuppanel.service.api.impl;

import android.util.SparseIntArray;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.aiopopuppanel.service.api.IGuildAIOPopupPanelServiceApi;
import to0.d;
import ze1.a;

/* loaded from: classes33.dex */
public class GuildAIOPopupPanelServiceApiImpl implements IGuildAIOPopupPanelServiceApi {
    private static final SparseIntArray markFlagsArray = new SparseIntArray();

    @Override // com.tencent.mobileqq.guild.api.aiopopuppanel.service.api.IGuildAIOPopupPanelServiceApi
    public int currentPopupPanelType(int i3, int i16) {
        return markFlagsArray.get(i3, 0) & i16;
    }

    @Override // com.tencent.mobileqq.guild.api.aiopopuppanel.service.api.IGuildAIOPopupPanelServiceApi
    public boolean markScenePopupPanelType(int i3, int i16) {
        SparseIntArray sparseIntArray = markFlagsArray;
        int i17 = sparseIntArray.get(i3, 0);
        if ((i17 & i16) != 0) {
            return false;
        }
        sparseIntArray.put(i3, i16 | i17);
        return true;
    }

    @Override // com.tencent.mobileqq.guild.api.aiopopuppanel.service.api.IGuildAIOPopupPanelServiceApi
    public void releasePopupPanel(a<?> aVar) {
        if (aVar instanceof d) {
            ((d) aVar).destroy();
        }
    }

    @Override // com.tencent.mobileqq.guild.api.aiopopuppanel.service.api.IGuildAIOPopupPanelServiceApi
    public boolean unMarkScenePopupPanelType(int i3, int i16) {
        SparseIntArray sparseIntArray = markFlagsArray;
        int i17 = sparseIntArray.get(i3, 0);
        if ((i17 & i16) == 0) {
            return false;
        }
        sparseIntArray.put(i3, (~i16) & i17);
        return true;
    }

    @Override // com.tencent.mobileqq.guild.api.aiopopuppanel.service.api.IGuildAIOPopupPanelServiceApi
    public void toggleSoftKeyBoard(QBaseActivity qBaseActivity) {
    }
}
