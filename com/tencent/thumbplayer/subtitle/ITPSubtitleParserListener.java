package com.tencent.thumbplayer.subtitle;

import com.tencent.thumbplayer.api.common.TPError;
import com.tencent.thumbplayer.api.common.TPSubtitleData;

/* loaded from: classes26.dex */
public interface ITPSubtitleParserListener {
    void onDeselectError(TPError tPError, long j3);

    void onDeselectSuccess(long j3);

    long onGetCurrentPlayPositionMs();

    void onSelectError(TPError tPError, long j3);

    void onSelectSuccess(long j3);

    void onSubtitleData(TPSubtitleData tPSubtitleData);

    void onSubtitleError(int i3, TPError tPError);

    void onSubtitleNote(int i3, String str);
}
