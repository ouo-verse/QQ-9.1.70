package com.tencent.mobileqq.colornote.api.impl;

import android.content.ContentValues;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.colornote.api.IColorNoteDataService;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.transaction.RemoveTransaction;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ea1.e;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes5.dex */
public class ColorNoteDataServiceImpl implements IColorNoteDataService {
    public static final int COLOR_NOTE_OP_ADD = 1;
    public static final int COLOR_NOTE_OP_DEL = 2;
    private static final String TAG = "ColorNoteProxy";
    private AppRuntime mAppRuntime;
    ArrayList<e> mColorNoteListener;
    private EntityManager mEntityManager;
    private static final Object CACHE_LOCK = new Object();
    static Comparator<ColorNote> mComparator = new a();
    protected List<ColorNote> mCache = new ArrayList();
    private final Comparator<ColorNote> mNewStyleComparator = new Comparator() { // from class: com.tencent.mobileqq.colornote.api.impl.a
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int lambda$new$0;
            lambda$new$0 = ColorNoteDataServiceImpl.lambda$new$0((ColorNote) obj, (ColorNote) obj2);
            return lambda$new$0;
        }
    };

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements Comparator<ColorNote> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ColorNote colorNote, ColorNote colorNote2) {
            boolean z16;
            boolean u16 = com.tencent.mobileqq.colornote.data.a.u(colorNote);
            boolean u17 = com.tencent.mobileqq.colornote.data.a.u(colorNote2);
            if (u16 && u17) {
                return ColorNoteDataServiceImpl.judgeColorNotePosition(colorNote, colorNote2);
            }
            if (u16) {
                return -1;
            }
            if (u17) {
                return 1;
            }
            boolean w3 = com.tencent.mobileqq.colornote.data.a.w(colorNote);
            boolean w16 = com.tencent.mobileqq.colornote.data.a.w(colorNote2);
            if (w3 && w16) {
                return ColorNoteDataServiceImpl.judgeColorNotePosition(colorNote, colorNote2);
            }
            if (w3) {
                return -1;
            }
            if (w16) {
                return 1;
            }
            boolean z17 = false;
            if (colorNote.getServiceType() == 16973824) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (colorNote2.getServiceType() == 16973824) {
                z17 = true;
            }
            if (z16 && z17) {
                return ColorNoteDataServiceImpl.judgeColorNotePosition(colorNote, colorNote2);
            }
            if (z16) {
                return -1;
            }
            if (!z17) {
                return ColorNoteDataServiceImpl.judgeColorNotePosition(colorNote, colorNote2);
            }
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<ColorNote> filterColorNoteForNewVersion(List<ColorNote> list) {
        if (!ia1.a.c()) {
            return list;
        }
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        boolean z16 = false;
        for (ColorNote colorNote : list) {
            if (isSpecialColorNote(colorNote)) {
                if (!com.tencent.mobileqq.colornote.data.a.w(colorNote)) {
                    arrayList.add(colorNote);
                } else if (!z16) {
                    arrayList.add(colorNote);
                    z16 = true;
                } else {
                    arrayList3.add(colorNote);
                }
            } else {
                arrayList2.add(colorNote);
            }
        }
        Collections.sort(arrayList2, mComparator);
        ArrayList arrayList4 = new ArrayList();
        int a16 = ia1.a.a();
        for (int i3 = 0; i3 < arrayList2.size() && i3 < a16; i3++) {
            arrayList4.add((ColorNote) arrayList2.get(i3));
        }
        while (a16 < arrayList2.size()) {
            arrayList3.add((ColorNote) arrayList2.get(a16));
            a16++;
        }
        arrayList4.addAll(arrayList);
        batchDelete(arrayList3);
        return arrayList4;
    }

    private boolean isSpecialColorNote(ColorNote colorNote) {
        if (!com.tencent.mobileqq.colornote.data.a.t(colorNote) && !com.tencent.mobileqq.colornote.data.a.w(colorNote) && (colorNote == null || colorNote.mExtra != 2)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int judgeColorNotePosition(ColorNote colorNote, ColorNote colorNote2) {
        long time = colorNote.getTime() - colorNote2.getTime();
        if (time == 0) {
            return 0;
        }
        if (time < 0) {
            return 1;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$batchDelete$1(List list) {
        if (this.mEntityManager == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ColorNote colorNote = (ColorNote) it.next();
            arrayList.add(new RemoveTransaction(colorNote));
            notifyColorNoteOp(2, colorNote);
        }
        QLog.d(TAG, 1, "[batchDelete] dbOp isSuccess: " + this.mEntityManager.doMultiDBOperateByTransaction(arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$new$0(ColorNote colorNote, ColorNote colorNote2) {
        boolean u16 = com.tencent.mobileqq.colornote.data.a.u(colorNote);
        boolean u17 = com.tencent.mobileqq.colornote.data.a.u(colorNote2);
        if (u16 && u17) {
            return judgeColorNotePosition(colorNote, colorNote2);
        }
        if (u16) {
            return -1;
        }
        if (u17) {
            return 1;
        }
        long j3 = colorNote.mVisibleTime;
        long j16 = colorNote2.mVisibleTime;
        if (j3 > j16) {
            return -1;
        }
        if (j3 != j16) {
            return 1;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyColorNoteOp(int i3, ColorNote colorNote) {
        ArrayList<e> arrayList = this.mColorNoteListener;
        if (arrayList == null) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) arrayList.clone();
        int size = arrayList2.size();
        for (int i16 = 0; i16 < size; i16++) {
            if (i3 == 1) {
                ((e) arrayList2.get(i16)).b(colorNote);
            } else if (i3 == 2) {
                ((e) arrayList2.get(i16)).a(colorNote);
            }
        }
    }

    protected void add(final ColorNote colorNote) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.colornote.api.impl.ColorNoteDataServiceImpl.3
            @Override // java.lang.Runnable
            public void run() {
                if (ColorNoteDataServiceImpl.this.mEntityManager != null) {
                    ColorNoteDataServiceImpl.this.mEntityManager.persist(colorNote);
                }
                ColorNoteDataServiceImpl.this.notifyColorNoteOp(1, colorNote);
            }
        }, 32, null, false);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteDataService
    public boolean addColorNote(String str, ColorNote colorNote, ProxyListener proxyListener, boolean z16) {
        if (!filterColorNote(colorNote) && ColorNoteSmallScreenUtil.i()) {
            if (colorNote.getServiceType() == 16973824) {
                ReportController.o(null, "dc00898", "", "", "0X800A746", "0X800A746", 0, 0, "", "", "", "");
            }
            synchronized (CACHE_LOCK) {
                if (com.tencent.mobileqq.colornote.data.a.w(colorNote)) {
                    this.mCache.add(0, colorNote);
                } else {
                    this.mCache.add(colorNote);
                }
            }
            if (colorNote.getServiceType() != 16973824) {
                saveToDB(str, colorNote, proxyListener, z16);
            }
            QLog.d(TAG, 1, "[addColorNote] add ColorNote: ", colorNote.toString());
            return true;
        }
        QLog.e(TAG, 1, "addColorNote error! isAfterSyncMsg = " + ColorNoteSmallScreenUtil.i());
        return false;
    }

    protected void addSync(ColorNote colorNote) {
        add(colorNote);
    }

    protected void batchDelete(final List<ColorNote> list) {
        if (list != null && list.size() != 0) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.colornote.api.impl.b
                @Override // java.lang.Runnable
                public final void run() {
                    ColorNoteDataServiceImpl.this.lambda$batchDelete$1(list);
                }
            }, 32, null, false);
        }
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteDataService
    public boolean canAddColorNote() {
        List<ColorNote> visiableColorNotes = getVisiableColorNotes();
        int size = visiableColorNotes.size();
        synchronized (CACHE_LOCK) {
            for (ColorNote colorNote : visiableColorNotes) {
                if (com.tencent.mobileqq.colornote.data.a.w(colorNote)) {
                    size--;
                }
                if (colorNote.getServiceType() == 16973824) {
                    size--;
                }
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "[canAddColorNote] notes.size: ", Integer.valueOf(visiableColorNotes.size()), ", count: ", Integer.valueOf(size), ", MAX_COUNT: ", Integer.valueOf(com.tencent.mobileqq.colornote.a.f201327a));
            Iterator<ColorNote> it = visiableColorNotes.iterator();
            while (it.hasNext()) {
                QLog.d(TAG, 4, "[canAddColorNote] query: ", it.next().toString());
            }
        }
        if (size < ia1.a.a()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteDataService
    public void clearAllUpcomingMindFlag() {
        synchronized (CACHE_LOCK) {
            for (ColorNote colorNote : this.mCache) {
                if (com.tencent.mobileqq.colornote.data.a.u(colorNote)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "clearAllUpcomingMindFlag ~~ " + colorNote);
                    }
                    colorNote.mExtLong &= 0;
                    updateColorNoteFieldByKey(this.mAppRuntime.getCurrentUin(), colorNote.getUniKey(), "mExtLong", Long.valueOf(colorNote.mExtLong));
                }
            }
        }
    }

    public ArrayList<ColorNote> deleteAllColorNote(String str, ProxyListener proxyListener, int i3) {
        ArrayList<ColorNote> arrayList = new ArrayList<>();
        synchronized (CACHE_LOCK) {
            for (ColorNote colorNote : this.mCache) {
                if (colorNote.mExtra == i3) {
                    arrayList.add(colorNote);
                }
            }
            this.mCache.removeAll(arrayList);
        }
        batchDelete(arrayList);
        QLog.d(TAG, 1, "[deleteAllColorNote] delete all, extra: ", Integer.valueOf(i3), ", size: ", Integer.valueOf(arrayList.size()));
        return arrayList;
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteDataService
    public void deleteColorNote(String str, final ColorNote colorNote, ProxyListener proxyListener) {
        if (colorNote != null) {
            synchronized (CACHE_LOCK) {
                this.mCache.remove(colorNote);
            }
            QLog.d(TAG, 1, "[deleteColorNote] delete: ", colorNote);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.colornote.api.impl.ColorNoteDataServiceImpl.5
                @Override // java.lang.Runnable
                public void run() {
                    if (ColorNoteDataServiceImpl.this.mEntityManager != null) {
                        ColorNoteDataServiceImpl.this.mEntityManager.remove(colorNote);
                    }
                    ColorNoteDataServiceImpl.this.notifyColorNoteOp(2, colorNote);
                }
            }, 32, null, false);
        }
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteDataService
    public List<ColorNote> extraTypeFilter(List<ColorNote> list, int i3) {
        ArrayList arrayList = new ArrayList();
        for (ColorNote colorNote : list) {
            if (colorNote.mExtra == i3) {
                arrayList.add(colorNote);
            }
        }
        return arrayList;
    }

    boolean filterColorNote(ColorNote colorNote) {
        boolean z16;
        synchronized (CACHE_LOCK) {
            if (!this.mCache.isEmpty() && findColorNoteByKey(colorNote.getUniKey(), colorNote.mExtra) != null) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteDataService
    public ColorNote findColorNoteByKey(String str) {
        return findColorNoteByKey(str, 0);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteDataService
    public final List<ColorNote> getColorNotes(boolean z16) {
        return getColorNotes(z16, 0);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteDataService
    public final int getCurrentColorNoteCount() {
        return getColorNotes(false).size();
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteDataService
    public List<ColorNote> getVisiableColorNotes() {
        return getVisiableColorNotes(this.mCache);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(final AppRuntime appRuntime) {
        this.mAppRuntime = appRuntime;
        this.mEntityManager = appRuntime.getEntityManagerFactory().createEntityManager();
        com.tencent.mobileqq.colornote.a.f201327a = ia1.a.a();
        QLog.d("ColorNoteConfigProcessor", 1, "init MAX_COUNT " + com.tencent.mobileqq.colornote.a.f201327a);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.colornote.api.impl.ColorNoteDataServiceImpl.1
            @Override // java.lang.Runnable
            public void run() {
                final List<? extends Entity> query = ColorNoteDataServiceImpl.this.mEntityManager.query(ColorNote.class, true, null, null, null, null, null, null);
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.colornote.api.impl.ColorNoteDataServiceImpl.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        List list = query;
                        if (list != null && !list.isEmpty()) {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            if (appRuntime != null) {
                                ColorNoteDataServiceImpl colorNoteDataServiceImpl = ColorNoteDataServiceImpl.this;
                                colorNoteDataServiceImpl.mCache = colorNoteDataServiceImpl.filterColorNoteForNewVersion(query);
                                ColorNoteSmallScreenUtil.p(appRuntime, false, false);
                                QLog.d(ColorNoteDataServiceImpl.TAG, 1, "[onCreate] colorNotes.size(query from db): ", Integer.valueOf(query.size()));
                                QLog.d(ColorNoteDataServiceImpl.TAG, 1, "[onCreate] colorNotes.size(filter): ", Integer.valueOf(ColorNoteDataServiceImpl.this.mCache.size()));
                            }
                        }
                        ColorNoteSmallScreenUtil.m(BaseApplication.getContext(), 3, true);
                    }
                });
            }
        }, 32, null, false);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        EntityManager entityManager = this.mEntityManager;
        if (entityManager != null) {
            entityManager.close();
        }
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteDataService
    public void registerColorNoteListener(e eVar) {
        if (this.mColorNoteListener == null) {
            this.mColorNoteListener = new ArrayList<>();
        }
        if (!this.mColorNoteListener.contains(eVar)) {
            this.mColorNoteListener.add(eVar);
        }
    }

    protected void saveToDB(String str, ColorNote colorNote, ProxyListener proxyListener, boolean z16) {
        if (z16) {
            addSync(colorNote);
        } else {
            add(colorNote);
        }
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteDataService
    @Deprecated
    public void setCache(List<ColorNote> list) {
        synchronized (CACHE_LOCK) {
            this.mCache = list;
        }
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteDataService
    public void setEntityManager(EntityManager entityManager) {
        this.mEntityManager = entityManager;
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteDataService
    public void setUpcomingColorNoteExtLong(ColorNote colorNote) {
        synchronized (CACHE_LOCK) {
            Iterator<ColorNote> it = this.mCache.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ColorNote next = it.next();
                if (next.equals(colorNote)) {
                    next.mExtLong |= 1;
                    updateColorNoteFieldByKey(this.mAppRuntime.getCurrentUin(), next.getUniKey(), "mExtLong", Long.valueOf(next.mExtLong));
                    break;
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteDataService
    public void unregisterColorNoteListener(e eVar) {
        ArrayList<e> arrayList = this.mColorNoteListener;
        if (arrayList != null) {
            arrayList.remove(eVar);
        }
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteDataService
    public ColorNote updateColorNoteFieldByKey(String str, String str2, String str3, Object obj) {
        Field declaredField;
        Class<?> type;
        final ColorNote findColorNoteByKey = findColorNoteByKey(str2);
        try {
            declaredField = ColorNote.class.getDeclaredField(str3);
            type = declaredField.getType();
            declaredField.setAccessible(true);
            if (findColorNoteByKey != null) {
                declaredField.set(findColorNoteByKey, obj);
            }
        } catch (IllegalAccessException e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "updateColorNoteFieldByKey error IllegalAccessException! ", e16);
            }
        } catch (NoSuchFieldException e17) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "updateColorNoteFieldByKey error NoSuchFieldException! ", e17);
            }
        }
        if (!Modifier.isStatic(declaredField.getModifiers()) && !declaredField.isAnnotationPresent(notColumn.class)) {
            ContentValues contentValues = new ContentValues();
            if (type == Long.TYPE) {
                contentValues.put(str3, (Long) obj);
            } else if (type == Integer.TYPE) {
                contentValues.put(str3, (Integer) obj);
            } else if (type == String.class) {
                contentValues.put(str3, (String) obj);
            } else if (type == Byte.TYPE) {
                contentValues.put(str3, (Byte) obj);
            } else if (type == byte[].class) {
                contentValues.put(str3, (byte[]) obj);
            } else if (type == Short.TYPE) {
                contentValues.put(str3, (Short) obj);
            } else if (type == Boolean.TYPE) {
                contentValues.put(str3, (Boolean) obj);
            } else if (type == Float.TYPE) {
                contentValues.put(str3, (Float) obj);
            } else if (type == Double.TYPE) {
                contentValues.put(str3, (Double) obj);
            } else if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "updateMsgFieldByUniseq fieldType error! " + type.getClass().getSimpleName());
            }
            if (findColorNoteByKey != null) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.colornote.api.impl.ColorNoteDataServiceImpl.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ColorNoteDataServiceImpl.this.mEntityManager != null) {
                            ColorNoteDataServiceImpl.this.mEntityManager.update(findColorNoteByKey);
                        }
                    }
                }, 32, null, false);
                return findColorNoteByKey;
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteDataService
    public boolean updateRecentNote(String str, ColorNote colorNote) {
        ArrayList arrayList = new ArrayList();
        synchronized (CACHE_LOCK) {
            List<ColorNote> list = this.mCache;
            for (ColorNote colorNote2 : list) {
                if (com.tencent.mobileqq.colornote.data.a.w(colorNote2)) {
                    arrayList.add(colorNote2);
                }
            }
            list.removeAll(arrayList);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            deleteColorNote(str, (ColorNote) it.next(), null);
        }
        if (colorNote != null) {
            addColorNote(str, colorNote, null, false);
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteDataService
    public ColorNote findColorNoteByKey(String str, int i3) {
        List<ColorNote> colorNotes;
        ColorNote colorNote;
        synchronized (CACHE_LOCK) {
            if (i3 == 0) {
                colorNotes = getColorNotes(false);
            } else {
                colorNotes = getColorNotes(false, i3);
            }
            if (colorNotes != null) {
                Iterator<ColorNote> it = colorNotes.iterator();
                while (it.hasNext()) {
                    colorNote = it.next();
                    if (colorNote.getUniKey().equals(str)) {
                        break;
                    }
                }
            }
            colorNote = null;
        }
        return colorNote;
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteDataService
    public List<ColorNote> getColorNotes(boolean z16, int i3) {
        List<ColorNote> extraTypeFilter;
        List query;
        synchronized (CACHE_LOCK) {
            if (this.mCache.isEmpty() && z16 && (query = this.mEntityManager.query(ColorNote.class)) != null && !query.isEmpty()) {
                this.mCache = query;
            }
            extraTypeFilter = extraTypeFilter(this.mCache, i3);
        }
        return extraTypeFilter;
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteDataService
    public List<ColorNote> getVisiableColorNotes(List<ColorNote> list) {
        ArrayList arrayList = new ArrayList();
        synchronized (CACHE_LOCK) {
            if (!list.isEmpty()) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ColorNote colorNote = list.get(size);
                    if (!colorNote.isOpen() || com.tencent.mobileqq.colornote.data.a.x(colorNote)) {
                        arrayList.add(colorNote);
                    }
                }
            }
        }
        Collections.sort(arrayList, ia1.a.c() ? this.mNewStyleComparator : mComparator);
        return extraTypeFilter(arrayList, 0);
    }

    @Override // com.tencent.mobileqq.colornote.api.IColorNoteDataService
    public ArrayList<ColorNote> deleteAllColorNote(String str, ProxyListener proxyListener) {
        return deleteAllColorNote(str, proxyListener, 0);
    }
}
