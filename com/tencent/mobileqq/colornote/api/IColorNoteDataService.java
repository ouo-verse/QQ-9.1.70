package com.tencent.mobileqq.colornote.api;

import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.annotation.Service;
import ea1.e;
import java.util.ArrayList;
import java.util.List;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {"all"})
/* loaded from: classes5.dex */
public interface IColorNoteDataService extends IRuntimeService {
    boolean addColorNote(String str, ColorNote colorNote, ProxyListener proxyListener, boolean z16);

    boolean canAddColorNote();

    void clearAllUpcomingMindFlag();

    ArrayList<ColorNote> deleteAllColorNote(String str, ProxyListener proxyListener);

    void deleteColorNote(String str, ColorNote colorNote, ProxyListener proxyListener);

    List<ColorNote> extraTypeFilter(List<ColorNote> list, int i3);

    ColorNote findColorNoteByKey(String str);

    ColorNote findColorNoteByKey(String str, int i3);

    List<ColorNote> getColorNotes(boolean z16);

    List<ColorNote> getColorNotes(boolean z16, int i3);

    int getCurrentColorNoteCount();

    List<ColorNote> getVisiableColorNotes();

    List<ColorNote> getVisiableColorNotes(List<ColorNote> list);

    void registerColorNoteListener(e eVar);

    void setCache(List<ColorNote> list);

    void setEntityManager(EntityManager entityManager);

    void setUpcomingColorNoteExtLong(ColorNote colorNote);

    void unregisterColorNoteListener(e eVar);

    ColorNote updateColorNoteFieldByKey(String str, String str2, String str3, Object obj);

    boolean updateRecentNote(String str, ColorNote colorNote);
}
