package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import java.util.Arrays;

/* loaded from: classes10.dex */
public class QQSysAndEmojiConfProcessor extends com.tencent.mobileqq.config.l<oa1.d> {
    private void a(oa1.b bVar) {
        if (bVar.e()) {
            String str = bVar.f422278c;
            if (!TextUtils.isEmpty(str)) {
                URLDrawable.getDrawable(str).startDownload(false);
            }
            String str2 = bVar.f422279d;
            if (!TextUtils.isEmpty(str2)) {
                URLDrawable.getDrawable(str2).startDownload(false);
            }
        }
    }

    public static oa1.d b() {
        oa1.d dVar = (oa1.d) com.tencent.mobileqq.config.am.s().x(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_PROXY_AUTHENTICATION_FAILED);
        if (dVar != null) {
            QLog.i("QQSysAndEmojiConfProcessor", 1, "conf exp: " + dVar.f422294a + ", conf url: " + dVar.f422295b);
        }
        return dVar;
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public oa1.d migrateOldOrDefaultContent(int i3) {
        return new oa1.d();
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<oa1.d> clazz() {
        return oa1.d.class;
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public oa1.d onParsed(com.tencent.mobileqq.config.ai[] aiVarArr) {
        if (aiVarArr != null && aiVarArr.length > 0) {
            com.tencent.mobileqq.config.ai aiVar = aiVarArr[aiVarArr.length - 1];
            for (com.tencent.mobileqq.config.ai aiVar2 : aiVarArr) {
                if (aiVar2.f202267a > aiVar.f202267a) {
                    aiVar = aiVar2;
                }
            }
            oa1.d a16 = oa1.d.a(aiVar.f202268b);
            a(a16.f422306m);
            return a16;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onUpdate(oa1.d dVar) {
        if (QLog.isColorLevel()) {
            QLog.i("QQSysAndEmojiConfProcessor", 2, "QQSysAndEmojiConfProcessor onUpdate");
        }
        if (dVar != null) {
            a(dVar.f422306m);
        }
        QQSysAndEmojiResMgr.getInstance().downloadEmoticonRes(Arrays.asList(1, 2, 3));
        QQSysFaceUtil.updateAnimEmoCount();
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isAccountRelated() {
        return false;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedCompressed() {
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedStoreLargeFile() {
        return false;
    }

    @Override // com.tencent.mobileqq.config.l
    public int migrateOldVersion() {
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return TVKQQLiveAssetPlayerMsg.PLAYER_INFO_PROXY_AUTHENTICATION_FAILED;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
    }
}
