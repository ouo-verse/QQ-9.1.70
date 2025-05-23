package com.tencent.mobileqq.teamwork.api.impl;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.teamwork.api.ICameraHelper;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFacadeCreator;
import com.tencent.mobileqq.teamwork.api.IVoiceInputHelper;
import com.tencent.mobileqq.teamworkforgroup.ShareUtils;
import com.tencent.mobileqq.teamworkforgroup.TroopTeamWorkFileSearchDialog;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TeamWorkFacadeCreatorImpl implements ITeamWorkFacadeCreator {
    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkFacadeCreator
    public ICameraHelper getCameraHelper(WebViewPlugin webViewPlugin) {
        return new CameraHelperImpl(webViewPlugin);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkFacadeCreator
    public String getExportHandlerName() {
        return TeamWorkFileExportHandlerImpl.getClassName();
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkFacadeCreator
    public String getGroupTeamWorkHandlerName() {
        return GroupTeamWorkHandlerImpl.getClassName();
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkFacadeCreator
    public IVoiceInputHelper getIVoiceInputHelper(WebViewPlugin webViewPlugin) {
        return new VoiceInputHelperImpl(webViewPlugin);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkFacadeCreator
    public String getImportHandlerName() {
        return TeamWorkFileImportHandlerImpl.getClassName();
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkFacadeCreator
    public com.tencent.mobileqq.teamwork.k getShareUtils(Activity activity, AppInterface appInterface) {
        return new ShareUtils(activity, appInterface);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkFacadeCreator
    public Class getTeamWorkHandlerClass() {
        return TeamWorkHandlerImpl.class;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkFacadeCreator
    public String getTeamWorkHandlerName() {
        return TeamWorkHandlerImpl.getClassName();
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkFacadeCreator
    public Dialog getTroopTeamWorkFileSearchDialog(Activity activity, View view, AppInterface appInterface, long j3) {
        return new TroopTeamWorkFileSearchDialog(activity, view, appInterface, j3);
    }
}
