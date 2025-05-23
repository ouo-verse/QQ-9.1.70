package com.tencent.mobileqq.guild.feed.jsbridge.methods.publish.helper;

import android.media.ExifInterface;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildMediaProgressState;
import com.tencent.mobileqq.guild.feed.publish.event.GuildFeedThirdContentMediaEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildMediaProgressStateEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildOnPhotoSelectedEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildUploadMediaOperationEvent;
import com.tencent.mobileqq.guild.feed.publish.result.SelectPhotoResult;
import com.tencent.mobileqq.guild.feed.publish.result.ThirdContentResult;
import com.tencent.mobileqq.guild.feed.publish.result.UploadProgressResult;
import com.tencent.mobileqq.guild.feed.util.GuildFeedMediaUtils;
import com.tencent.mobileqq.guild.feed.util.ak;
import com.tencent.mobileqq.guild.feed.util.bl;
import com.tencent.mobileqq.qqalbum.IPicToJpg;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import hj1.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rk1.n;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildUploadHelper implements SimpleEventReceiver {

    /* renamed from: f, reason: collision with root package name */
    private static volatile GuildUploadHelper f220042f;

    /* renamed from: d, reason: collision with root package name */
    private n f220043d;

    /* renamed from: e, reason: collision with root package name */
    private String f220044e;

    GuildUploadHelper() {
    }

    public static String e(String str) {
        com.tencent.mobileqq.qqalbum.a aVar = new com.tencent.mobileqq.qqalbum.a();
        aVar.f262095a = str;
        String filePath = AbsDownloader.getFilePath(str);
        aVar.f262096b = filePath;
        if (FileUtils.fileExistsAndNotEmpty(filePath) || ((IPicToJpg) QRoute.api(IPicToJpg.class)).picToJpg(aVar)) {
            return aVar.f262096b;
        }
        return str;
    }

    public static GuildUploadHelper i() {
        if (f220042f == null) {
            synchronized (GuildUploadHelper.class) {
                if (f220042f == null) {
                    f220042f = new GuildUploadHelper();
                }
            }
        }
        return f220042f;
    }

    private static int j(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt != 3) {
                if (attributeInt != 6) {
                    if (attributeInt != 8) {
                        return 0;
                    }
                    return 270;
                }
                return 90;
            }
            return 180;
        } catch (IOException e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(GuildOnPhotoSelectedEvent guildOnPhotoSelectedEvent) {
        GuildMediaUploadCoroutineHelper.f220036a.h(guildOnPhotoSelectedEvent, this, this.f220043d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00c4 A[Catch: JSONException -> 0x00ac, TryCatch #0 {JSONException -> 0x00ac, blocks: (B:52:0x0057, B:55:0x005e, B:57:0x0064, B:59:0x006a, B:61:0x007a, B:63:0x009f, B:68:0x00a6, B:14:0x00b7, B:17:0x00be, B:19:0x00c4, B:21:0x00ca, B:23:0x00d6, B:25:0x00f8, B:27:0x0102, B:29:0x0108, B:31:0x0122, B:38:0x0125, B:39:0x0128), top: B:51:0x0057 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void l(GuildFeedThirdContentMediaEvent guildFeedThirdContentMediaEvent) {
        String str;
        String str2;
        int i3;
        String str3 = "Guild_Feed_GuildUploadHelper-Guild_Feed_BaseGuildJsBridgeMethod";
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(guildFeedThirdContentMediaEvent.getJsonFeed());
            JSONArray optJSONArray = jSONObject.optJSONArray("images");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("videos");
            QLog.i("Guild_Feed_GuildUploadHelper-Guild_Feed_BaseGuildJsBridgeMethod", 1, "handleOnThirdContentMediaEvent");
            for (LocalMediaInfo localMediaInfo : guildFeedThirdContentMediaEvent.getLocalMediaInfos()) {
                hashMap2.put(localMediaInfo.path, localMediaInfo);
            }
            ArrayList arrayList = new ArrayList();
            try {
                if (optJSONArray != null) {
                    try {
                        if (optJSONArray.length() > 0) {
                            int i16 = 0;
                            while (i16 < optJSONArray.length()) {
                                JSONObject jSONObject2 = optJSONArray.getJSONObject(i16);
                                if (jSONObject2 != null) {
                                    String string = jSONObject2.getString("picUrl");
                                    str2 = str3;
                                    LocalMediaInfo localMediaInfo2 = (LocalMediaInfo) hashMap2.get(string);
                                    if (localMediaInfo2 != null) {
                                        String g16 = g();
                                        arrayList.add(g16);
                                        hashMap.put(g16, localMediaInfo2);
                                        jSONObject2.put("picId", g16);
                                        jSONObject2.put("picUrl", "https://qun.qq.com/guildFeedPublish/localMedia" + string);
                                    }
                                } else {
                                    str2 = str3;
                                }
                                i16++;
                                str3 = str2;
                            }
                            str = str3;
                            jSONObject.put("images", optJSONArray);
                            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                                for (i3 = 0; i3 < optJSONArray2.length(); i3++) {
                                    JSONObject jSONObject3 = optJSONArray2.getJSONObject(i3);
                                    if (jSONObject3 != null) {
                                        String string2 = jSONObject3.getString("playUrl");
                                        LocalMediaInfo localMediaInfo3 = (LocalMediaInfo) hashMap2.get(string2);
                                        if (localMediaInfo3 != null) {
                                            String g17 = g();
                                            arrayList.add(g17);
                                            hashMap.put(g17, localMediaInfo3);
                                            jSONObject3.put("fileId", g17);
                                            jSONObject3.put("playUrl", "");
                                            jSONObject3.put("videoID", string2);
                                            JSONObject jSONObject4 = jSONObject3.getJSONObject("cover");
                                            if (jSONObject4 != null && TextUtils.isEmpty(jSONObject4.optString("picUrl")) && !TextUtils.isEmpty(string2)) {
                                                String b16 = GuildFeedMediaUtils.b(string2);
                                                jSONObject4.put("picUrl", "https://qun.qq.com/guildFeedPublish/localMedia" + b16);
                                                GuildFeedMediaUtils.g(string2, b16, null);
                                            }
                                        }
                                    }
                                }
                                jSONObject.put("videos", optJSONArray2);
                            }
                            Object[] objArr = new Object[2];
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("handleOnThirdContentMediaEvent: mainTaskId[");
                            sb5.append(this.f220044e);
                            sb5.append("] info[");
                            sb5.append(hashMap);
                            sb5.append("]");
                            objArr[0] = sb5.toString();
                            objArr[1] = "";
                            QLog.d(str, 1, objArr);
                            this.f220043d.i(new ThirdContentResult(jSONObject, arrayList).c());
                            p(false, hashMap);
                            return;
                        }
                    } catch (JSONException unused) {
                        return;
                    }
                }
                sb5.append(this.f220044e);
                sb5.append("] info[");
                sb5.append(hashMap);
                sb5.append("]");
                objArr[0] = sb5.toString();
                objArr[1] = "";
                QLog.d(str, 1, objArr);
                this.f220043d.i(new ThirdContentResult(jSONObject, arrayList).c());
                p(false, hashMap);
                return;
            } catch (JSONException unused2) {
                return;
            }
            str = "Guild_Feed_GuildUploadHelper-Guild_Feed_BaseGuildJsBridgeMethod";
            if (optJSONArray2 != null) {
                while (i3 < optJSONArray2.length()) {
                }
                jSONObject.put("videos", optJSONArray2);
            }
            Object[] objArr2 = new Object[2];
            StringBuilder sb52 = new StringBuilder();
            sb52.append("handleOnThirdContentMediaEvent: mainTaskId[");
        } catch (JSONException unused3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(GuildMediaProgressStateEvent guildMediaProgressStateEvent) {
        String errMsg;
        int i3;
        String str;
        int i16;
        GuildMediaProgressState mediaProgressState = guildMediaProgressStateEvent.getMediaProgressState();
        if (mediaProgressState.getState() == 0) {
            return;
        }
        String taskId = mediaProgressState.getTaskId();
        int progress = mediaProgressState.getProgress();
        if (mediaProgressState.getState() == 3) {
            i16 = 0;
            str = "";
            i3 = 0;
        } else if (mediaProgressState.getState() == 1) {
            i16 = 1;
            str = "";
            i3 = 0;
        } else {
            int errCode = mediaProgressState.getErrCode();
            if (errCode == -447) {
                if ("video".equals(mediaProgressState.mType)) {
                    errMsg = "\u8be5\u89c6\u9891\u8d85\u51fa\u9650\u5236";
                } else {
                    errMsg = "\u8be5\u56fe\u7247\u8d85\u51fa\u9650\u5236";
                }
            } else {
                errMsg = mediaProgressState.getErrMsg();
            }
            i3 = errCode;
            str = errMsg;
            i16 = 2;
        }
        this.f220043d.i(new UploadProgressResult(taskId, !TextUtils.equals(mediaProgressState.getType(), "pic") ? 1 : 0, i16, progress, i3, str).c());
    }

    private void t(@Nullable String str, @Nullable String str2) {
        try {
            QLog.i("Guild_Feed_GuildUploadHelper-Guild_Feed_BaseGuildJsBridgeMethod", 1, "[reBindReportTask]: old=" + str + ", new=" + str2);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                ((IGuildFeedMiscApi) QRoute.api(IGuildFeedMiscApi.class)).syncCallGetSimpleDataMethod("sync_bind_report_task", str, str2);
            }
        } catch (Exception e16) {
            QLog.e("Guild_Feed_GuildUploadHelper-Guild_Feed_BaseGuildJsBridgeMethod", 1, "[tryReBindReportTask]: ", e16);
        }
    }

    public void f() {
        if (TextUtils.isEmpty(this.f220044e)) {
            this.f220044e = "GuildMain" + System.nanoTime();
        }
    }

    public String g() {
        return "GuildSon" + System.nanoTime();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(GuildMediaProgressStateEvent.class);
        arrayList.add(GuildOnPhotoSelectedEvent.class);
        arrayList.add(GuildFeedThirdContentMediaEvent.class);
        return arrayList;
    }

    public String h() {
        return this.f220044e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(List<SelectPhotoResult.SelectPhotoBean> list, LocalMediaInfo localMediaInfo, String str, String str2) {
        int j3 = j(str2);
        int i3 = localMediaInfo.mediaWidth;
        int i16 = localMediaInfo.mediaHeight;
        if (j3 == 90 || j3 == 270) {
            i3 = i16;
            i16 = i3;
        }
        b.a("Guild_Feed_GuildUploadHelper-Guild_Feed_BaseGuildJsBridgeMethod", "handleSelectedImageFile: rotate[" + j3 + "] width[" + i3 + "] height[" + i16 + "]");
        list.add(new SelectPhotoResult.SelectPhotoBean(str, str2, i3, i16));
    }

    public void o(n nVar) {
        this.f220043d = nVar;
        bl.c().d(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(final SimpleBaseEvent simpleBaseEvent) {
        QLog.d("Guild_Feed_GuildUploadHelper-Guild_Feed_BaseGuildJsBridgeMethod", 1, "onReceiveEvent-> ", simpleBaseEvent);
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.jsbridge.methods.publish.helper.GuildUploadHelper.1
            @Override // java.lang.Runnable
            public void run() {
                if (GuildUploadHelper.this.f220043d == null) {
                    QLog.d("Guild_Feed_GuildUploadHelper-Guild_Feed_BaseGuildJsBridgeMethod", 1, "mPublishConfigMethod is null, so return!");
                    return;
                }
                SimpleBaseEvent simpleBaseEvent2 = simpleBaseEvent;
                if (simpleBaseEvent2 instanceof GuildMediaProgressStateEvent) {
                    GuildUploadHelper.this.m((GuildMediaProgressStateEvent) simpleBaseEvent2);
                } else if (simpleBaseEvent2 instanceof GuildOnPhotoSelectedEvent) {
                    GuildUploadHelper.this.k((GuildOnPhotoSelectedEvent) simpleBaseEvent2);
                } else if (simpleBaseEvent2 instanceof GuildFeedThirdContentMediaEvent) {
                    GuildUploadHelper.this.l((GuildFeedThirdContentMediaEvent) simpleBaseEvent2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(boolean z16, Map<String, LocalMediaInfo> map) {
        GuildUploadMediaOperationEvent guildUploadMediaOperationEvent = new GuildUploadMediaOperationEvent();
        guildUploadMediaOperationEvent.setMainTaskId(this.f220044e);
        guildUploadMediaOperationEvent.setTaskIdLocalMediaInfoMap(map);
        guildUploadMediaOperationEvent.setOriginalPic(z16);
        bl.c().b(guildUploadMediaOperationEvent, true);
        ak.f(map);
    }

    public void q() {
        bl.c().e(this);
        this.f220044e = null;
        this.f220043d = null;
    }

    public void r() {
        s(null);
        f();
        n nVar = this.f220043d;
        if (nVar != null) {
            nVar.x();
        }
    }

    public void s(String str) {
        String str2 = this.f220044e;
        this.f220044e = str;
        t(str2, str);
    }
}
