package com.tencent.mobileqq.colornote.data;

import android.os.Bundle;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {"all"})
/* loaded from: classes5.dex */
public interface IColorNoteHelper extends IRuntimeService {
    boolean addColorNote(Bundle bundle);

    boolean canAddColorNote();

    void clearHistoryNote(int i3);

    void deleteAllColorNote(AppRuntime appRuntime, ProxyListener proxyListener);

    boolean deleteColorNote(int i3, String str);

    boolean deleteColorNote(int i3, String str, int i16);

    boolean deleteColorNote(String str, int i3);

    boolean isColorNoteExit(int i3, String str);

    boolean isColorNoteExit(String str);

    boolean updateColorNote(String str, String str2, Object obj);

    boolean updateColorNote(String str, String str2, Object obj, int i3);

    Bundle updateColorNoteState(int i3, String str, boolean z16);

    Bundle updateColorNoteState(String str, boolean z16);

    boolean updateRecentNote(ColorNote colorNote);
}
