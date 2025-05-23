package com.tencent.aelight.camera.ae.gif.giftext.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.aelight.camera.ae.gif.video.b;
import com.tencent.aelight.camera.aebase.k;
import java.io.File;
import rq.c;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b extends ViewModel {

    /* renamed from: i, reason: collision with root package name */
    private MutableLiveData<c.a> f65437i = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name */
    private MutableLiveData<String> f65438m = new MutableLiveData<>();
    private MutableLiveData<b.a> C = new MutableLiveData<>();

    public void L1() {
        this.f65437i.postValue(new c.a("#ccffffff", "#000000"));
        this.f65438m.postValue("");
    }

    public MutableLiveData<b.a> M1() {
        return this.C;
    }

    public MutableLiveData<c.a> N1() {
        return this.f65437i;
    }

    public MutableLiveData<String> O1() {
        return this.f65438m;
    }

    public void P1(String str, String str2) {
        b.a aVar = new b.a();
        String[] list = new File(str2).list();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str2);
        String str3 = File.separator;
        sb5.append(str3);
        sb5.append("snapshot.png");
        String sb6 = sb5.toString();
        if (list.length != 0) {
            k.a(str2 + str3 + list[0], 320, 320, sb6);
        }
        aVar.f65547a = str2;
        aVar.f65548b = str;
        aVar.f65549c = sb6;
        this.C.postValue(aVar);
    }

    public void Q1(String str, int i3) {
        this.f65438m.postValue(str);
        this.f65437i.postValue(c.f431900b.get(i3));
    }
}
