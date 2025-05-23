package com.tencent.beacon.a.c;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class d implements FileFilter {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f77654a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        this.f77654a = eVar;
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return Pattern.matches("cpu[0-9]", file.getName());
    }
}
