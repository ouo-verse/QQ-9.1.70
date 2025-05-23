package com.tencent.comic.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import java.util.Map;
import java.util.Observer;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {"all"})
/* loaded from: classes5.dex */
public interface IQQComicRedTouchService extends IRuntimeService {
    public static final int PATH_CONVERT_MODE_LEBA_2_MORE = 0;
    public static final int PATH_CONVERT_MODE_MORE_2_LEBA = 1;

    void addObserver(Observer observer);

    String convertString(String str, int i3);

    void deleteObserver(Observer observer);

    Map<String, Object> getRedAppInfo(ArrayList<String> arrayList);

    boolean isLebaItemOpen(int i3);

    void reportRedTouchClick(String str);
}
