package com.tencent.qqlive.module.videoreport.storage;

import com.tencent.qqlive.module.videoreport.storage.util.Condition;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface IDataStorage {
    void clear();

    <T> boolean contains(Class<T> cls, String str);

    <T> boolean contains(T t16);

    <T> void delete(Class<T> cls, Condition<T> condition);

    <T> void delete(Class<T> cls, String str);

    <T> void delete(Class<T> cls, List<String> list);

    <T> void delete(T t16);

    <T> void delete(List<T> list);

    <T> void deleteAll(Class<T> cls);

    <T> T load(Class<T> cls, String str);

    <T> List<T> load(Class<T> cls, Condition<T> condition);

    <T> List<T> load(Class<T> cls, List<String> list);

    <T> List<T> loadAll(Class<T> cls);

    <T> void storeOrUpdate(T t16);

    <T> void storeOrUpdate(T t16, String str);

    <T> void storeOrUpdate(List<T> list);

    <T> void storeOrUpdate(List<T> list, List<String> list2);
}
