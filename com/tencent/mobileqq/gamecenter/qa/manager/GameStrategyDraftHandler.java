package com.tencent.mobileqq.gamecenter.qa.manager;

import android.text.TextUtils;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.qa.model.GameStrategyAnswer;
import com.tencent.mobileqq.gamecenter.qa.model.GameStrategyPic;
import com.tencent.mobileqq.gamecenter.qa.model.GameStrategyQuestion;
import com.tencent.mobileqq.gamecenter.qa.model.GameStrategyTag;
import com.tencent.mobileqq.gamecenter.qa.model.GameStrategyVideo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GameStrategyDraftHandler {

    /* renamed from: a, reason: collision with root package name */
    private final String f212535a;

    public GameStrategyDraftHandler(int i3) {
        String str;
        if (i3 == 1) {
            str = "_dialog";
        } else {
            str = "_fullscreen";
        }
        this.f212535a = str;
    }

    public static void c() {
        try {
            FileUtils.deleteDirectory(m().getAbsolutePath());
            FileUtils.deleteDirectory(f().getAbsolutePath());
        } catch (Throwable th5) {
            QLog.e("GameStrategyDraftHandler", 1, th5, new Object[0]);
        }
    }

    private static File f() {
        File file = new File(BaseApplication.getContext().getFilesDir(), "gamecenter");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, "answer");
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static File g(long j3) {
        return new File(f(), String.valueOf(j3));
    }

    public static File j(long j3) {
        File file = new File(f() + "/" + QAdVrReportParams.ParamKey.MEDIA, String.valueOf(j3));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private List<GameStrategyPic> l(JSONObject jSONObject) {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("pic_infos")) != null) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i3);
                if (jSONObject2 != null) {
                    GameStrategyPic gameStrategyPic = new GameStrategyPic();
                    gameStrategyPic.mUrl = jSONObject2.optString("url");
                    gameStrategyPic.mWidth = jSONObject2.optInt("width");
                    gameStrategyPic.mHeight = jSONObject2.optInt("height");
                    arrayList.add(gameStrategyPic);
                }
            }
        }
        return arrayList;
    }

    private static File m() {
        File file = new File(BaseApplication.getContext().getFilesDir(), "gamecenter");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, "question");
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static File n(int i3) {
        return new File(m(), String.valueOf(i3));
    }

    public static File p(long j3) {
        File file = new File(m() + "/" + QAdVrReportParams.ParamKey.MEDIA, String.valueOf(j3));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private List<GameStrategyTag> q(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                try {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i3);
                    if (jSONObject != null) {
                        GameStrategyTag gameStrategyTag = new GameStrategyTag();
                        gameStrategyTag.mTagId = jSONObject.optLong("tag_id");
                        gameStrategyTag.mTagName = jSONObject.optString("tag_name");
                        gameStrategyTag.isSelected = true;
                        arrayList.add(gameStrategyTag);
                    }
                } catch (Exception e16) {
                    QLog.e("GameStrategyDraftHandler", 1, "getTagList, exception:", e16);
                }
            }
        }
        return arrayList;
    }

    private List<GameStrategyVideo> r(JSONObject jSONObject) {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("video_infos")) != null) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i3);
                if (jSONObject2 != null) {
                    GameStrategyVideo gameStrategyVideo = new GameStrategyVideo();
                    gameStrategyVideo.mVideoUrl = jSONObject2.optString("video_url");
                    gameStrategyVideo.mDuration = jSONObject2.optLong("duration");
                    JSONObject optJSONObject = jSONObject2.optJSONObject(QZoneJsConstants.DYNAMIC_ALBUM_COVER_PIC);
                    if (optJSONObject != null) {
                        gameStrategyVideo.mCoverUrl = optJSONObject.optString("url");
                        gameStrategyVideo.mCoverWidth = optJSONObject.optInt("width");
                        gameStrategyVideo.mCoverHeight = optJSONObject.optInt("height");
                    }
                    arrayList.add(gameStrategyVideo);
                }
            }
        }
        return arrayList;
    }

    private boolean s(long j3) {
        long abs = Math.abs(NetConnInfoCenter.getServerTimeMillis() - j3);
        QLog.d("GameStrategyDraftHandler", 2, "[isOverTime] gap:" + abs);
        if (abs > 86400000) {
            return true;
        }
        return false;
    }

    public void d(final long j3) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.manager.GameStrategyDraftHandler.2
            @Override // java.lang.Runnable
            public void run() {
                GameStrategyDraftHandler.g(j3).delete();
                FileUtils.deleteFile(GameStrategyDraftHandler.j(j3));
            }
        }, 64, null, false);
    }

    public void e(final int i3) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.manager.GameStrategyDraftHandler.1
            @Override // java.lang.Runnable
            public void run() {
                GameStrategyDraftHandler.n(i3).delete();
                FileUtils.deleteFile(GameStrategyDraftHandler.p(i3));
            }
        }, 64, null, false);
    }

    public GameStrategyAnswer h(long j3, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                GameStrategyAnswer gameStrategyAnswer = new GameStrategyAnswer();
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("answer");
                if (optJSONObject != null) {
                    gameStrategyAnswer.mQuestionId = j3;
                    gameStrategyAnswer.answerId = optJSONObject.optLong("id");
                    gameStrategyAnswer.mContent = optJSONObject.optString("content");
                    gameStrategyAnswer.mRichContent = new JSONObject(optJSONObject.optString("rich_content")).toString();
                    gameStrategyAnswer.addPics(l(optJSONObject.optJSONObject(s4.c.PICS)));
                    gameStrategyAnswer.addVideos(r(optJSONObject.optJSONObject("videos")));
                }
                return gameStrategyAnswer;
            } catch (Exception e16) {
                QLog.e("GameStrategyDraftHandler", 1, "getAnswerDraftFromJson, exception=", e16);
                return null;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0076 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v0, types: [long] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GameStrategyAnswer i(long j3) {
        ObjectInputStream objectInputStream;
        File g16 = g(j3);
        ObjectInputStream objectInputStream2 = null;
        if (g16.exists()) {
            ?? lastModified = g16.lastModified();
            if (s(lastModified)) {
                g16.delete();
                return null;
            }
            try {
                try {
                    try {
                        objectInputStream = new ObjectInputStream(new FileInputStream(g16));
                    } catch (IOException e16) {
                        e = e16;
                        objectInputStream = null;
                    } catch (ClassNotFoundException e17) {
                        e = e17;
                        objectInputStream = null;
                    } catch (Throwable th5) {
                        th = th5;
                        if (objectInputStream2 != null) {
                        }
                        throw th;
                    }
                    try {
                        QLog.d("GameStrategyDraftHandler", 1, "getAnswerDraft, success, questionId=", Long.valueOf(j3));
                        GameStrategyAnswer gameStrategyAnswer = (GameStrategyAnswer) objectInputStream.readObject();
                        try {
                            objectInputStream.close();
                        } catch (IOException e18) {
                            QLog.e("GameStrategyDraftHandler", 1, "getAnswerDraft, IOException2=", e18);
                        }
                        return gameStrategyAnswer;
                    } catch (IOException e19) {
                        e = e19;
                        QLog.e("GameStrategyDraftHandler", 1, "getAnswerDraft, IOException=", e);
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        return null;
                    } catch (ClassNotFoundException e26) {
                        e = e26;
                        QLog.e("GameStrategyDraftHandler", 1, "getAnswerDraft, ClassNotFoundException=", e);
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        return null;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    objectInputStream2 = lastModified;
                    if (objectInputStream2 != null) {
                        try {
                            objectInputStream2.close();
                        } catch (IOException e27) {
                            QLog.e("GameStrategyDraftHandler", 1, "getAnswerDraft, IOException2=", e27);
                        }
                    }
                    throw th;
                }
            } catch (IOException e28) {
                QLog.e("GameStrategyDraftHandler", 1, "getAnswerDraft, IOException2=", e28);
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [long] */
    public GameStrategyQuestion k(int i3) {
        ObjectInputStream objectInputStream;
        File n3 = n(i3);
        ObjectInputStream objectInputStream2 = null;
        if (n3.exists()) {
            ?? lastModified = n3.lastModified();
            if (s(lastModified)) {
                n3.delete();
                return null;
            }
            try {
                try {
                    try {
                        objectInputStream = new ObjectInputStream(new FileInputStream(n3));
                    } catch (IOException e16) {
                        e = e16;
                        objectInputStream = null;
                    } catch (ClassNotFoundException e17) {
                        e = e17;
                        objectInputStream = null;
                    } catch (Throwable th5) {
                        th = th5;
                        if (objectInputStream2 != null) {
                            try {
                                objectInputStream2.close();
                            } catch (IOException e18) {
                                QLog.e("GameStrategyDraftHandler", 1, "getLocalQuestionDraft, IOException2=", e18);
                            }
                        }
                        throw th;
                    }
                    try {
                        Object readObject = objectInputStream.readObject();
                        if (readObject instanceof GameStrategyQuestion) {
                            QLog.d("GameStrategyDraftHandler", 1, "getLocalQuestionDraft, success, appId=", Integer.valueOf(i3));
                            GameStrategyQuestion gameStrategyQuestion = (GameStrategyQuestion) readObject;
                            try {
                                objectInputStream.close();
                            } catch (IOException e19) {
                                QLog.e("GameStrategyDraftHandler", 1, "getLocalQuestionDraft, IOException2=", e19);
                            }
                            return gameStrategyQuestion;
                        }
                        try {
                            objectInputStream.close();
                        } catch (IOException e26) {
                            QLog.e("GameStrategyDraftHandler", 1, "getLocalQuestionDraft, IOException2=", e26);
                        }
                        return null;
                    } catch (IOException e27) {
                        e = e27;
                        QLog.e("GameStrategyDraftHandler", 1, "getLocalQuestionDraft, IOException=", e);
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        return null;
                    } catch (ClassNotFoundException e28) {
                        e = e28;
                        QLog.e("GameStrategyDraftHandler", 1, "getLocalQuestionDraft, ClassNotFoundException=", e);
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        return null;
                    }
                } catch (IOException e29) {
                    QLog.e("GameStrategyDraftHandler", 1, "getLocalQuestionDraft, IOException2=", e29);
                }
            } catch (Throwable th6) {
                th = th6;
                objectInputStream2 = lastModified;
            }
        }
        return null;
    }

    public GameStrategyQuestion o(int i3, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                GameStrategyQuestion gameStrategyQuestion = new GameStrategyQuestion();
                gameStrategyQuestion.mAppId = i3;
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("question");
                if (optJSONObject != null) {
                    gameStrategyQuestion.questionId = optJSONObject.optLong("id");
                    gameStrategyQuestion.mTitle = optJSONObject.optString("title");
                    gameStrategyQuestion.mContent = optJSONObject.optString("content");
                    gameStrategyQuestion.mRichContent = new JSONObject(optJSONObject.optString("rich_content")).toString();
                    gameStrategyQuestion.addTags(q(optJSONObject.optJSONArray(ComicCancelRedPointPopItemData.JSON_KEY_TAGS)));
                    gameStrategyQuestion.addPics(l(optJSONObject.optJSONObject(s4.c.PICS)));
                    gameStrategyQuestion.addVideos(r(optJSONObject.optJSONObject("videos")));
                }
                return gameStrategyQuestion;
            } catch (Exception e16) {
                QLog.e("GameStrategyDraftHandler", 1, "getQuestionDraftFromJson, IOException=", e16);
                return null;
            }
        }
        return null;
    }

    public void t(GameStrategyAnswer gameStrategyAnswer) {
        File g16 = g(gameStrategyAnswer.mQuestionId);
        g16.delete();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(g16));
            objectOutputStream.writeObject(gameStrategyAnswer);
            objectOutputStream.flush();
            objectOutputStream.close();
            QLog.d("GameStrategyDraftHandler", 1, "saveAnswerDraft, success, mQuestionId=", Long.valueOf(gameStrategyAnswer.mQuestionId));
        } catch (IOException e16) {
            QLog.e("GameStrategyDraftHandler", 1, "saveAnswerDraft, IOException=", e16);
        }
    }

    public void u(GameStrategyQuestion gameStrategyQuestion) {
        File n3 = n(gameStrategyQuestion.mAppId);
        n3.delete();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(n3));
            objectOutputStream.writeObject(gameStrategyQuestion);
            objectOutputStream.flush();
            objectOutputStream.close();
            QLog.d("GameStrategyDraftHandler", 1, "saveQuestionDraft, success, appid=", Integer.valueOf(gameStrategyQuestion.mAppId));
        } catch (IOException e16) {
            QLog.e("GameStrategyDraftHandler", 1, "saveQuestionDraft, IOException=", e16);
        }
    }
}
