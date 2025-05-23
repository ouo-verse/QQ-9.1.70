package com.tencent.mobileqq.vas.updatesystem.business;

import com.tencent.upload.uinterface.data.UppUploadTask;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b extends QQVasUpdateBusiness {

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public File f311185a;

        /* renamed from: b, reason: collision with root package name */
        public File f311186b;

        /* renamed from: c, reason: collision with root package name */
        public List<File> f311187c = new ArrayList();
    }

    public a e(int i3, int i16, List<String> list) {
        a aVar = new a();
        aVar.f311186b = new File(getSavePath(i3), "cover.png");
        aVar.f311185a = new File(getSavePath(i3), "lv" + i16 + ".png");
        for (String str : list) {
            aVar.f311187c.add(new File(getSavePath(i3), UppUploadTask.sfUppAppId + File.separator + str + ".png"));
        }
        return aVar;
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public long getBid() {
        return 346L;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    protected String getBusinessDir() {
        return "lover_vip_icon";
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public String getFrom() {
        return "lover";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public String getScid(int i3) {
        return getScidPrefix() + "." + i3 + ".common.zip";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    protected String getScidPrefix() {
        return "loverSVIPIcon";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isEnableCheckFile() {
        return true;
    }
}
