package com.tencent.qqlive.module.videoreport.storage.preference;

import android.util.Pair;
import com.tencent.qqlive.module.videoreport.storage.util.Condition;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
interface ISpOperation {
    void clearSp();

    <T> boolean containsObject(Class<T> cls, String str);

    <T> void deleteAllObjects(Class<T> cls);

    <T> void deleteObject(Class<T> cls, String str);

    <T> void deleteObjects(Class<T> cls, List<String> list);

    <T> List<Pair<String, T>> getAllObjects(Class<T> cls);

    <T> T getObject(Class<T> cls, String str);

    <T> List<Pair<String, T>> getObjects(Class<T> cls, Condition<T> condition);

    <T> void insertObject(T t16, String str);

    <T> void insertObjects(List<T> list, List<String> list2);
}
