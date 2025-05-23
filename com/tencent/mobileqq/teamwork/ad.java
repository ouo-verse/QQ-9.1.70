package com.tencent.mobileqq.teamwork;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.MediaDBValues;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ad extends z {
    public ad(TeamWorkFileImportInfo teamWorkFileImportInfo, AppInterface appInterface) {
        super(teamWorkFileImportInfo, appInterface);
    }

    private boolean c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return !TextUtils.isEmpty(jSONObject.optString("ownertype"));
    }

    @Override // com.tencent.mobileqq.teamwork.z
    public void b(AppInterface appInterface) {
        String str;
        long j3;
        long j16;
        int i3;
        TeamWorkFileImportInfo teamWorkFileImportInfo = this.f292445a;
        if (teamWorkFileImportInfo != null && appInterface != null && this.f292446b != null) {
            String b16 = b.b(teamWorkFileImportInfo);
            TeamWorkFileImportInfo teamWorkFileImportInfo2 = this.f292445a;
            String str2 = teamWorkFileImportInfo2.f292071d0;
            int i16 = teamWorkFileImportInfo2.f292070d;
            if (i16 == 6000 || i16 == 6003) {
                str = "";
            } else {
                str = b16;
                b16 = "";
            }
            if (TextUtils.isEmpty(b16)) {
                if (!TextUtils.isEmpty(str)) {
                    b16 = "";
                } else {
                    if (TextUtils.isEmpty(str2)) {
                        String str3 = this.f292445a.f292077h;
                        if (!new File(str3).exists()) {
                            str2 = "";
                        } else {
                            str2 = ((ITeamWorkHttpUtils) QRoute.api(ITeamWorkHttpUtils.class)).getFileMD5(str3);
                        }
                    }
                    b16 = str2;
                }
            }
            TeamWorkFileImportInfo teamWorkFileImportInfo3 = this.f292445a;
            int i17 = teamWorkFileImportInfo3.f292070d;
            long j17 = 0;
            if (i17 == 1) {
                i3 = 3;
                j16 = 0;
                j17 = Long.valueOf(teamWorkFileImportInfo3.f292072e).longValue();
                j3 = 0;
            } else if (i17 == 3000) {
                j16 = Long.valueOf(teamWorkFileImportInfo3.f292072e).longValue();
                j3 = 0;
                i3 = 2;
            } else {
                IGetExternalInterface iGetExternalInterface = (IGetExternalInterface) QRoute.api(IGetExternalInterface.class);
                TeamWorkFileImportInfo teamWorkFileImportInfo4 = this.f292445a;
                MessageRecord queryMsgItemByUniseq = iGetExternalInterface.queryMsgItemByUniseq(appInterface, teamWorkFileImportInfo4.f292072e, teamWorkFileImportInfo4.f292070d, teamWorkFileImportInfo4.f292079i);
                if (queryMsgItemByUniseq != null && ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).isInstanceMessageForFile(queryMsgItemByUniseq)) {
                    j3 = Long.valueOf(queryMsgItemByUniseq.senderuin).longValue();
                } else {
                    j3 = 0;
                }
                if (TextUtils.isEmpty(str)) {
                    j3 = Long.valueOf(appInterface.getCurrentAccountUin()).longValue();
                }
                j16 = 0;
                i3 = 1;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(str)) {
                    b16 = str;
                }
                jSONObject.put(QCircleSchemeAttr.Detail.FEED_VIDEO_ID, b16);
                jSONObject.put("filename", this.f292445a.f292074f);
                jSONObject.put(MediaDBValues.FILESIZE, this.f292445a.f292078h0);
                jSONObject.put("filetype", i3);
                jSONObject.put("businesstype", this.f292445a.D);
                jSONObject.put("groupuin", j17);
                jSONObject.put("senderuin", j3);
                jSONObject.put("discussuin", j16);
                if (this.f292445a.f292075f0) {
                    jSONObject.put("ownertype", 1);
                } else {
                    jSONObject.put("ownertype", 2);
                }
            } catch (JSONException e16) {
                QLog.e("TeamWorkFileImportJobForFile2Form", 2, "put fileid exception: " + e16.toString());
            }
            try {
                if (!c(jSONObject)) {
                    if (appInterface.getCurrentUin().equals(String.valueOf(j3))) {
                        jSONObject.put("ownertype", 1);
                    } else {
                        jSONObject.put("ownertype", 2);
                    }
                }
            } catch (JSONException e17) {
                QLog.e("TeamWorkFileImportJobForFile2Form", 2, "put ownertype exception: " + e17.toString());
            }
            this.f292445a.I = true;
            if (TextUtils.isEmpty(str)) {
                TeamWorkFileImportInfo teamWorkFileImportInfo5 = this.f292445a;
                if (teamWorkFileImportInfo5.Y == 0) {
                    this.f292446b.addToFileImportingMap(teamWorkFileImportInfo5);
                    this.f292446b.importFormWithLocalFile(jSONObject, this.f292445a);
                    return;
                }
            }
            TeamWorkFileImportInfo teamWorkFileImportInfo6 = this.f292445a;
            if (teamWorkFileImportInfo6.Y == 0) {
                this.f292446b.addToFileImportingMap(teamWorkFileImportInfo6);
                this.f292446b.importFormWithUrl(jSONObject, this.f292445a);
            } else {
                this.f292446b.checkFormCache(jSONObject, teamWorkFileImportInfo6);
            }
        }
    }
}
