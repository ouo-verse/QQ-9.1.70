package com.tencent.aelight.camera.aioeditor.capture.control;

import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.capture.music.QIMMusicConfigManager;
import com.tencent.aelight.camera.struct.editor.FlowMusic;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.ParallGroup;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.transaction.PersistOrReplaceTransaction;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import fr.b;
import fr.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class GetAllFullMusicInfoTask extends ParallGroup {
    private String C;
    private List<FlowMusic> D = null;
    private List<FlowMusic> E = new ArrayList();
    private List<FlowMusic> F = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    private QIMMusicConfigManager f66669m = (QIMMusicConfigManager) f.c(2);

    private void h() {
        if (!this.E.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator<FlowMusic> it = this.E.iterator();
            while (it.hasNext()) {
                arrayList.add(new PersistOrReplaceTransaction(it.next()));
            }
            this.f66669m.K.doMultiDBOperateByTransaction(arrayList);
            this.f66669m.F(4, true, this.E);
        }
        QIMMusicConfigManager.H(b.a().getCurrentAccountUin());
    }

    private void i() {
        int i3;
        JSONArray optJSONArray;
        List<FlowMusic> list;
        this.C = (String) this.mParams[0];
        List<? extends Entity> query = this.f66669m.K.query(FlowMusic.class);
        if (query == null || query.isEmpty()) {
            i3 = 0;
        } else {
            ArrayList arrayList = new ArrayList(query);
            this.D = arrayList;
            i3 = arrayList.size();
        }
        if (QLog.isColorLevel()) {
            QLog.d("GetAllFullMusicInfoTask", 2, "load db, has load local, size=" + i3);
            List<FlowMusic> list2 = this.D;
            if (list2 != null) {
                Iterator<FlowMusic> it = list2.iterator();
                while (it.hasNext()) {
                    QLog.d("GetAllFullMusicInfoTask", 2, "load db, local music=" + it.next());
                }
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(this.C);
            if (jSONObject.optInt("ret", -1) != 0 || (optJSONArray = jSONObject.optJSONArray("song_list")) == null || optJSONArray.length() <= 0) {
                return;
            }
            HashSet hashSet = new HashSet();
            List<FlowMusic> list3 = this.D;
            int size = 40 - (list3 != null ? list3.size() : 0);
            if (size > 20) {
                size = 20;
            }
            if (optJSONArray.length() < size) {
                size = optJSONArray.length();
            }
            long currentTimeMillis = System.currentTimeMillis();
            for (int i16 = 0; i16 < size; i16++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i16);
                if (optJSONObject != null) {
                    FlowMusic flowMusic = new FlowMusic();
                    flowMusic.albumId = optJSONObject.optInt(QCircleScheme.AttrQQPublish.PICKER_ALBUM_ID);
                    flowMusic.albumMid = optJSONObject.optString("album_mid");
                    flowMusic.albumName = optJSONObject.optString("album_name");
                    flowMusic.singerId = optJSONObject.optInt("singer_id");
                    flowMusic.singerMid = optJSONObject.optString("singer_mid");
                    flowMusic.singerName = optJSONObject.optString("singer_name");
                    flowMusic.songId = optJSONObject.optInt("song_id");
                    flowMusic.songMid = optJSONObject.optString("song_mid");
                    flowMusic.songName = optJSONObject.optString("song_name");
                    flowMusic.songPlayTime = optJSONObject.optInt("song_play_time");
                    flowMusic.userOwnRule = optJSONObject.optInt("user_own_rule");
                    flowMusic.sourceType = 1;
                    flowMusic.storeTimeStamp = (size + currentTimeMillis) - i16;
                    if (!TextUtils.isEmpty(flowMusic.songMid) && ((list = this.D) == null || !list.contains(flowMusic))) {
                        hashSet.add(flowMusic);
                    }
                }
            }
            this.F.addAll(hashSet);
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("GetAllFullMusicInfoTask", 2, "can not parse json, json = " + this.C, e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.automator.ParallGroup, com.tencent.mobileqq.app.automator.c
    public synchronized void a(AsyncStep asyncStep, int i3) {
        if (asyncStep instanceof GetSingleFullMusicInfoTask) {
            FlowMusic flowMusic = ((GetSingleFullMusicInfoTask) asyncStep).C;
            if (flowMusic == null) {
                flowMusic = ((GetSingleFullMusicInfoTask) asyncStep).f66675m;
            } else {
                if (TextUtils.isEmpty(flowMusic.songMid)) {
                    flowMusic.songMid = ((GetSingleFullMusicInfoTask) asyncStep).f66675m.songMid;
                }
                flowMusic.storeTimeStamp = ((GetSingleFullMusicInfoTask) asyncStep).f66675m.storeTimeStamp;
                flowMusic.sourceType = 1;
            }
            this.E.add(flowMusic);
        }
        int i16 = this.f195312i - 1;
        this.f195312i = i16;
        if (i16 == 0) {
            h();
            setResult(7);
            this.f195313d = null;
        }
        this.mAutomator.i2(this.f195313d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.ParallGroup, com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        this.f195312i = this.F.size();
        if (!this.F.isEmpty()) {
            for (FlowMusic flowMusic : this.F) {
                if (this.mResult == 8) {
                    return 2;
                }
                AsyncStep getSingleFullMusicInfoTask = new GetSingleFullMusicInfoTask(flowMusic, (ns.a) null);
                getSingleFullMusicInfoTask.mResultListener = this;
                this.mAutomator.a2(getSingleFullMusicInfoTask);
            }
            return 2;
        }
        h();
        return 7;
    }

    @Override // com.tencent.mobileqq.app.automator.StepGroup, com.tencent.mobileqq.app.automator.AsyncStep
    public void onCreate() {
        i();
    }
}
