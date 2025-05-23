package com.qzone.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c implements LayoutInflater.Factory {

    /* renamed from: d, reason: collision with root package name */
    static final Class<?>[] f44477d = {Context.class, AttributeSet.class};

    /* renamed from: e, reason: collision with root package name */
    private static final StackTraceElement[] f44478e = new StackTraceElement[0];

    /* renamed from: f, reason: collision with root package name */
    private static final Map<String, Constructor<? extends View>> f44479f = new ConcurrentHashMap();

    /* renamed from: h, reason: collision with root package name */
    private static final ClassLoader f44480h = LayoutInflater.class.getClassLoader();

    /* renamed from: i, reason: collision with root package name */
    private static final String[] f44481i = {"android.view.", "android.widget.", "android.webkit.", "android.app."};

    /* renamed from: m, reason: collision with root package name */
    private static Map<String, Constructor<? extends View>> f44482m;
}
