package com.tencent.mobileqq.minigame.api;

import com.tencent.mobileqq.mini.share.MiniArkShareModel;
import com.tencent.mobileqq.mini.share.MiniProgramShareUtils;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public interface OnShareListenerForMiniBox extends MiniProgramShareUtils.OnShareListener {
    void onSharePrepared(MiniArkShareModel miniArkShareModel, JSONObject jSONObject, int i3);
}
