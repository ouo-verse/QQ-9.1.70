package com.tencent.mobileqq.teamwork.api;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import java.util.List;
import mqq.os.MqqHandler;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ITeamWorkUtilsTemp extends QRouteApi {
    void addTeamWorkGrayTips(AppInterface appInterface, String str, int i3, long j3, long j16, String str2, String str3);

    void configHistoryTabEmptyTips(TextView textView, View.OnClickListener onClickListener);

    List<ChatMessage> createChatMsgListFromTencentDocs(List<TencentDocData> list, String str, String str2);

    void forwardTencentDoc(Activity activity, FileManagerEntity fileManagerEntity);

    String getTroopFormGrayParameter(AppInterface appInterface, String str, int i3);

    void insertTroopFormGrayTips(AppInterface appInterface, MessageMicro messageMicro);

    void insertTroopFormGrayTips(AppInterface appInterface, MessageMicro messageMicro, String str);

    boolean isTencentDocsAssistantEnable(AppInterface appInterface);

    void onGetGroupAuthDocsGrayTipsInfo(AppInterface appInterface, Context context, MqqHandler mqqHandler, boolean z16, Object[] objArr);

    void onGetUserAuthDocsGrayTipsInfo(AppInterface appInterface, Context context, MqqHandler mqqHandler, boolean z16, Object[] objArr);

    void onSetGroupAuthDocsGrayTipsInfo(AppInterface appInterface, Context context, MqqHandler mqqHandler, boolean z16, Object[] objArr);

    void onSetUserAuthDocsGrayTipsInfo(AppInterface appInterface, Context context, MqqHandler mqqHandler, boolean z16, Object[] objArr);

    void openTroopTemplatePreviewUrlWithCheck(AppInterface appInterface, Activity activity, int i3, String str, long j3, long j16, long j17);

    void processTDDocFileUrl(String str);

    void processTDDocFileUrl(String str, ChatMessage chatMessage);

    void sendDocCooperationShare(AppInterface appInterface, Activity activity, TencentDocData tencentDocData, TeamWorkFileImportInfo teamWorkFileImportInfo);

    void sendTDoc2Chat(AppInterface appInterface, FileManagerEntity fileManagerEntity, String str, String str2, int i3);

    void setTencentDocsAssitantEnable(AppInterface appInterface, boolean z16);

    void tryAddTDFileMessageRecord(AppInterface appInterface, MessageRecord messageRecord);

    void tryProcessTDDocMessageRecord(MessageRecord messageRecord, AppInterface appInterface);
}
