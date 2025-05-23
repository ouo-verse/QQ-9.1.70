package com.tencent.mobileqq.guild.rolegroup.viewmodel;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.util.GuildDebugUtils;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.dg;
import com.tencent.mobileqq.qqguildsdk.data.dh;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public class e extends ef1.b {
    private String C;
    private int D;
    private final MutableLiveData<List<by1.a>> E = new MutableLiveData<>(new ArrayList());
    private cn<cf1.b> F = new cn<>();

    private void R1(int i3, String str, ArrayList<dg> arrayList, int i16) {
        int size;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("handleChannelAdminInfoList result:");
            sb5.append(i3);
            sb5.append(", errMsg:");
            sb5.append(str);
            sb5.append(", infoListSize:");
            if (arrayList == null) {
                size = 0;
            } else {
                size = arrayList.size();
            }
            sb5.append(size);
            sb5.append(",adminMaxNum:");
            sb5.append(i16);
            QLog.i("Guild.rg.GuildRoleGroupChannelAdminViewModel", 2, sb5.toString());
        }
        if (i3 != 0 && !StringUtil.isEmpty(str)) {
            this.F.setValue(new cf1.b(i3, str));
            return;
        }
        this.D = i16;
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new by1.e("\u5b50\u9891\u9053\u7ba1\u7406\u5458\u6210\u5458"));
            Iterator<dg> it = arrayList.iterator();
            while (it.hasNext()) {
                dg next = it.next();
                ArrayList<dh> a16 = next.a();
                if (a16 != null && !a16.isEmpty()) {
                    if (!TextUtils.isEmpty(next.getCategoryName())) {
                        arrayList2.add(new by1.b(next.getCategoryName()));
                    }
                    Iterator<dh> it5 = a16.iterator();
                    while (it5.hasNext()) {
                        dh next2 = it5.next();
                        by1.c cVar = new by1.c();
                        cVar.g(next2.getChannelId());
                        cVar.h(next2.getChannelName());
                        cVar.i(next2.getChannelType());
                        cVar.f(next2.a());
                        arrayList2.add(cVar);
                    }
                }
            }
            this.E.postValue(arrayList2);
            return;
        }
        this.E.postValue(new ArrayList());
    }

    private void S1(int i3, String str, ArrayList<dg> arrayList, int i16) {
        boolean z16;
        int size;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("handleChannelAdminInfoList result:");
            sb5.append(i3);
            sb5.append(", errMsg:");
            sb5.append(str);
            sb5.append(", infoListSize:");
            if (arrayList == null) {
                size = 0;
            } else {
                size = arrayList.size();
            }
            sb5.append(size);
            sb5.append(",adminMaxNum:");
            sb5.append(i16);
            QLog.i("Guild.rg.GuildRoleGroupChannelAdminViewModel", 2, sb5.toString());
        }
        if (i3 != 0 && !StringUtil.isEmpty(str)) {
            this.F.setValue(new cf1.b(i3, str));
            return;
        }
        this.D = i16;
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new by1.e("\u7248\u5757\u7ba1\u7406\u5458"));
            ArrayList arrayList3 = new ArrayList();
            Iterator<dg> it = arrayList.iterator();
            while (it.hasNext()) {
                ArrayList<dh> a16 = it.next().a();
                if (a16 != null && !a16.isEmpty()) {
                    Iterator<dh> it5 = a16.iterator();
                    while (it5.hasNext()) {
                        dh next = it5.next();
                        if (next.getChannelType() == 7) {
                            by1.c cVar = new by1.c();
                            cVar.g(next.getChannelId());
                            cVar.h(next.getChannelName());
                            cVar.i(next.getChannelType());
                            cVar.f(next.a());
                            arrayList3.add(cVar);
                        }
                    }
                }
            }
            if (arrayList3.isEmpty()) {
                arrayList2.add(new by1.d("\u6682\u65e0\u5e16\u5b50\u7248\u5757"));
            }
            arrayList2.addAll(arrayList3);
            arrayList3.clear();
            new ArrayList();
            arrayList2.add(new by1.e("\u5b50\u9891\u9053\u7ba1\u7406\u5458"));
            Iterator<dg> it6 = arrayList.iterator();
            while (it6.hasNext()) {
                dg next2 = it6.next();
                ArrayList<dh> a17 = next2.a();
                if (a17 != null && !a17.isEmpty() && next2.getCategoryType() != 1) {
                    ArrayList arrayList4 = new ArrayList();
                    if (!TextUtils.isEmpty(next2.getCategoryName())) {
                        arrayList4.add(new by1.b(next2.getCategoryName()));
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    Iterator<dh> it7 = a17.iterator();
                    while (it7.hasNext()) {
                        dh next3 = it7.next();
                        if (next3.getChannelType() != 7) {
                            by1.c cVar2 = new by1.c();
                            cVar2.g(next3.getChannelId());
                            cVar2.h(next3.getChannelName());
                            cVar2.i(next3.getChannelType());
                            cVar2.f(next3.a());
                            arrayList4.add(cVar2);
                        }
                    }
                    if (z16 && arrayList4.size() == 1) {
                        arrayList4.add(new by1.d("\u6682\u65e0\u5b50\u9891\u9053"));
                    }
                    arrayList3.addAll(arrayList4);
                }
            }
            if (arrayList3.isEmpty()) {
                arrayList3.add(new by1.d("\u6682\u65e0\u5b50\u9891\u9053"));
            }
            arrayList2.addAll(arrayList3);
            arrayList3.clear();
            this.E.postValue(arrayList2);
            return;
        }
        this.E.postValue(new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U1(int i3, String str, ArrayList arrayList, int i16, boolean z16) {
        if (GuildDebugUtils.f(this.C)) {
            S1(i3, str, arrayList, i16);
        } else {
            R1(i3, str, arrayList, i16);
        }
    }

    public void O1() {
        ((IGPSService) ch.l().getRuntimeService(IGPSService.class, "")).fetchChannelAdminInfoList(this.C, new vh2.e() { // from class: com.tencent.mobileqq.guild.rolegroup.viewmodel.d
            @Override // vh2.e
            public final void onResult(int i3, String str, ArrayList arrayList, int i16, boolean z16) {
                e.this.U1(i3, str, arrayList, i16, z16);
            }
        });
    }

    public int P1() {
        return this.D;
    }

    public MutableLiveData<List<by1.a>> Q1() {
        return this.E;
    }

    public void T1(String str) {
        this.C = str;
    }

    public LiveData<cf1.b> getToastEvent() {
        return this.F;
    }
}
