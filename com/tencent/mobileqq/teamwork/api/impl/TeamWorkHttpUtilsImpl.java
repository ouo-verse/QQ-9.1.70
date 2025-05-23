package com.tencent.mobileqq.teamwork.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.teamwork.TeamWorkHttpUtils;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import java.io.File;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TeamWorkHttpUtilsImpl implements ITeamWorkHttpUtils {
    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils
    public void checkIfExist(String str, String str2, IGetExternalInterface.d dVar) {
        TeamWorkHttpUtils.x(str, str2, dVar);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils
    public String getFileMD5(String str) {
        return TeamWorkHttpUtils.A(str);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils
    public void getTencentDocReddot(String str, String str2, IGetExternalInterface.d dVar) {
        TeamWorkHttpUtils.D(str, str2, dVar);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils
    public void ocrExportUploadImage(AppInterface appInterface, String str, String str2, IGetExternalInterface.d dVar) {
        TeamWorkHttpUtils.b0(appInterface, str, str2, dVar);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils
    public void sendHttpsGet(String str, String str2, String str3, IGetExternalInterface.d dVar) {
        TeamWorkHttpUtils.m0(str, str2, str3, dVar);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils
    public void sendHttpsPost(JSONObject jSONObject, String str, String str2, String str3, IGetExternalInterface.d dVar) {
        TeamWorkHttpUtils.q0(jSONObject, str, str2, str3, dVar);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils
    public void sendHttpsPut(String str, String str2, String str3, String str4, IGetExternalInterface.d dVar) {
        TeamWorkHttpUtils.s0(str, str2, str3, str4, dVar);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils
    public void uploadFile(TeamWorkFileImportInfo teamWorkFileImportInfo, String str, IGetExternalInterface.d dVar) {
        TeamWorkHttpUtils.u0(teamWorkFileImportInfo, str, dVar);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils
    public boolean uploadFile2Cos(File file, String str) {
        return TeamWorkHttpUtils.v0(file, str);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils
    public void uploadFileForH5(TeamWorkFileImportInfo teamWorkFileImportInfo, String str, IGetExternalInterface.d dVar) {
        TeamWorkHttpUtils.w0(teamWorkFileImportInfo, str, dVar);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils
    public void uploadFileInfo(JSONObject jSONObject, String str, AppInterface appInterface, IGetExternalInterface.d dVar) {
        TeamWorkHttpUtils.x0(jSONObject, str, appInterface, dVar);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils
    public void uploadFileInfoForH5(JSONObject jSONObject, TeamWorkFileImportInfo teamWorkFileImportInfo, String str, IGetExternalInterface.d dVar) {
        TeamWorkHttpUtils.y0(jSONObject, teamWorkFileImportInfo, str, dVar);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils
    public void uploadFileWithParam(JSONObject jSONObject, String str, String str2, String str3, IGetExternalInterface.d dVar) {
        TeamWorkHttpUtils.z0(jSONObject, str, str2, str3, dVar);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils
    public void url2Doc(TeamWorkFileImportInfo teamWorkFileImportInfo, String str, IGetExternalInterface.d dVar) {
        TeamWorkHttpUtils.A0(teamWorkFileImportInfo, str, dVar);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils
    public void sendHttpsGet(String str, String str2, String str3, String str4, IGetExternalInterface.d dVar) {
        TeamWorkHttpUtils.n0(str, str2, str3, str4, true, dVar);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils
    public void sendHttpsPost(JSONObject jSONObject, String str, String str2, String str3, String str4, IGetExternalInterface.d dVar) {
        TeamWorkHttpUtils.r0(jSONObject, str, str2, str3, str4, dVar);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils
    public void sendHttpsGet(String str, String str2, String str3, String str4, boolean z16, IGetExternalInterface.d dVar) {
        TeamWorkHttpUtils.n0(str, str2, str3, str4, z16, dVar);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils
    public void sendHttpsPost(String str, String str2, String str3, String str4, IGetExternalInterface.d dVar) {
        TeamWorkHttpUtils.o0(str, str2, str3, str4, dVar);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils
    public void sendHttpsPost(String str, String str2, String str3, String str4, String str5, Map<String, String> map, boolean z16, IGetExternalInterface.d dVar) {
        TeamWorkHttpUtils.p0(str, str2, str3, str4, str5, map, z16, dVar);
    }
}
