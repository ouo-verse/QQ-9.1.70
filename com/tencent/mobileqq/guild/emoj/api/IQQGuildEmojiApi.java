package com.tencent.mobileqq.guild.emoj.api;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.guild.emoj.f;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import oi1.b;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes13.dex */
public interface IQQGuildEmojiApi extends QRouteApi {
    CharSequence createEmojiFaceSpan(int i3, int i16);

    CharSequence fetchEmoSpan(int i3, int i16);

    List<b> fetchRecentEmojiData();

    Drawable getDynamicDrawable(int i3, int i16);

    String getEmoDsc(int i3);

    List<Integer> getFilterEmojiData();

    List<Integer> getFilterSysData();

    Drawable getStaticDrawable(int i3, int i16);

    boolean isGuildEmojiReactionEnable();

    boolean isInFilterList(long j3, String str);

    int localToServer(String str, int i3);

    void requestRecentUseEmo();

    int serverToLocal(String str, int i3);

    void showWithAnim(com.tencent.mobileqq.guild.emoj.b bVar, int i3, f fVar);

    void updateRecentEmojiData(int i3, int i16);
}
