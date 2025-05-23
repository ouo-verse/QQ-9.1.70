package com.tencent.luan.ioc;

import com.tencent.luan.core.SingleLinkedListNode;
import com.tencent.luan.ioc.wrapper.FixObjectWrapper;
import com.tencent.luan.ioc.wrapper.ObjectHolder;
import com.tencent.luan.ioc.wrapper.ObjectWrapper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public class LuanInjector implements Injector {
    static IPatchRedirector $redirector_;
    private SingleLinkedListNode<Object> createObjHeadNode;
    private SingleLinkedListNode<Object> createObjTailNode;
    private boolean isInjected;
    private final Map<String, ObjectWrapper<?>> nameObjectWrapperMap;
    private final LuanInjectService service;
    private final Object source;
    private final Map<String, ObjectWrapper<?>> typeObjectWrapperMap;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LuanInjector(Object obj, LuanInjectService luanInjectService) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, obj, (Object) luanInjectService);
            return;
        }
        this.typeObjectWrapperMap = new HashMap();
        this.nameObjectWrapperMap = new HashMap();
        this.source = obj;
        this.service = luanInjectService;
    }

    private void addCreateObjectToLinkedList(Object obj) {
        SingleLinkedListNode<Object> singleLinkedListNode = new SingleLinkedListNode<>(obj);
        SingleLinkedListNode<Object> singleLinkedListNode2 = this.createObjTailNode;
        if (singleLinkedListNode2 == null) {
            this.createObjHeadNode = singleLinkedListNode;
        } else {
            singleLinkedListNode2.setNext(singleLinkedListNode);
        }
        this.createObjTailNode = singleLinkedListNode;
    }

    private static void combineWrapperAndPutToCache(Map<String, ObjectWrapper<?>> map, ObjectWrapper<?> objectWrapper, Object obj, String str) {
        ObjectWrapper<?> combine = objectWrapper.combine(obj);
        if (objectWrapper != combine) {
            map.put(str, combine);
        }
    }

    private Object getObjectByWrapper(ObjectWrapper<?> objectWrapper) {
        try {
            ObjectHolder<?> createObjectIfAbsent = objectWrapper.createObjectIfAbsent(this);
            Object obj = createObjectIfAbsent.object;
            if (createObjectIfAbsent.needInject) {
                addCreateObjectToLinkedList(obj);
            }
            return obj;
        } catch (IllegalStateException e16) {
            throw new InjectException("failed to inference inject type such as more than one types " + e16);
        }
    }

    private void putArgs(Object... objArr) {
        if (objArr == null) {
            return;
        }
        for (Object obj : objArr) {
            if (obj != null) {
                putObjInAllTypeCache(obj, obj.getClass());
            }
        }
    }

    private void putObjInAllTypeCache(Object obj, Class<?> cls) {
        HashSet hashSet = new HashSet();
        readAllType(cls, hashSet);
        Iterator<Class<?>> it = hashSet.iterator();
        while (it.hasNext()) {
            String name = it.next().getName();
            ObjectWrapper<?> objectWrapper = this.typeObjectWrapperMap.get(name);
            if (objectWrapper == null) {
                this.typeObjectWrapperMap.put(name, new FixObjectWrapper(obj));
            } else {
                combineWrapperAndPutToCache(this.typeObjectWrapperMap, objectWrapper, obj, name);
            }
        }
    }

    private void readAllType(Class<?> cls, Set<Class<?>> set) {
        set.add(cls);
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null) {
            readAllType(superclass, set);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            readAllType(cls2, set);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object get(Class<?> cls, Object... objArr) {
        putArgs(objArr);
        Object orCreateObject = getOrCreateObject(cls);
        SingleLinkedListNode<Object> singleLinkedListNode = this.createObjHeadNode;
        if (singleLinkedListNode != null) {
            Iterator<Object> it = singleLinkedListNode.iterator();
            while (it.hasNext()) {
                inject(it.next());
            }
        }
        this.isInjected = true;
        return orCreateObject;
    }

    @Override // com.tencent.luan.ioc.Injector
    public Object getOrCreateObject(Class<?> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, (Object) cls);
        }
        if (!this.isInjected) {
            String name = cls.getName();
            ObjectWrapper<?> objectWrapper = this.typeObjectWrapperMap.get(name);
            if (objectWrapper == null) {
                objectWrapper = this.service.getInjectConstructor(cls).wrapper();
                this.typeObjectWrapperMap.put(name, objectWrapper);
            }
            Object objectByWrapper = getObjectByWrapper(objectWrapper);
            if (objectWrapper.needCache()) {
                putObjInAllTypeCache(objectByWrapper, cls);
            }
            return objectByWrapper;
        }
        throw new IllegalStateException("injection is already done");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void inject() {
        if (this.isInjected) {
            return;
        }
        Object obj = this.source;
        if (obj != null) {
            putObjInAllTypeCache(obj, obj.getClass());
            inject(this.source);
            SingleLinkedListNode<Object> singleLinkedListNode = this.createObjHeadNode;
            if (singleLinkedListNode != null) {
                Iterator<Object> it = singleLinkedListNode.iterator();
                while (it.hasNext()) {
                    inject(it.next());
                }
            }
            this.isInjected = true;
            return;
        }
        throw new NullPointerException("inject source object is null");
    }

    boolean isInjected() {
        return this.isInjected;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object get(String str, Object... objArr) {
        putArgs(objArr);
        Object orCreateObject = getOrCreateObject(str);
        SingleLinkedListNode<Object> singleLinkedListNode = this.createObjHeadNode;
        if (singleLinkedListNode != null) {
            Iterator<Object> it = singleLinkedListNode.iterator();
            while (it.hasNext()) {
                inject(it.next());
            }
        }
        this.isInjected = true;
        return orCreateObject;
    }

    private void inject(Object obj) {
        Iterator<InjectMethod> it = this.service.getInjectMethods(obj.getClass()).iterator();
        while (it.hasNext()) {
            it.next().invoke(obj, this);
        }
    }

    @Override // com.tencent.luan.ioc.Injector
    public Object getOrCreateObject(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        if (!this.isInjected) {
            ObjectWrapper<?> objectWrapper = this.nameObjectWrapperMap.get(str);
            if (objectWrapper == null) {
                InjectConstructor<?> injectConstructor = this.service.nameInjectConstructorMap.get(str);
                if (injectConstructor != null) {
                    objectWrapper = injectConstructor.wrapper();
                    this.nameObjectWrapperMap.put(str, objectWrapper);
                } else {
                    throw new InjectException("failed to create instance by this name " + str);
                }
            }
            Object objectByWrapper = getObjectByWrapper(objectWrapper);
            if (objectWrapper.needCache()) {
                combineWrapperAndPutToCache(this.nameObjectWrapperMap, objectWrapper, objectByWrapper, str);
            }
            return objectByWrapper;
        }
        throw new IllegalStateException("injection is already done");
    }
}
