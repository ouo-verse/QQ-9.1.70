package com.tencent.mobileqq.zplan.easteregg.manager;

import ci3.a;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.zplan.easteregg.PortraitSource;
import com.tencent.mobileqq.zplan.easteregg.asyntask.AsynTaskHandler;
import com.tencent.mobileqq.zplan.easteregg.model.EasterEggBgParam;
import com.tencent.mobileqq.zplan.easteregg.model.EasterEggBgResult;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J.\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u001e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u0014J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0002H\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/zplan/easteregg/manager/a;", "Lcom/tencent/mobileqq/zplan/easteregg/asyntask/AsynTaskHandler;", "Lcom/tencent/mobileqq/zplan/easteregg/model/a;", "Lcom/tencent/mobileqq/zplan/easteregg/model/b;", "", "bgName", "k", "", "uin", "bgUrl", "backgroundName", "Lcom/tencent/mobileqq/zplan/easteregg/asyntask/a;", "listener", "", "g", "url", tl.h.F, "j", "param", "l", "i", "<init>", "()V", "c", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a extends AsynTaskHandler<EasterEggBgParam, EasterEggBgResult> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/easteregg/manager/a$b", "Lci3/a$a;", "", "isSuccess", "", "onResult", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements a.InterfaceC0194a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f332911a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zplan.easteregg.asyntask.a<EasterEggBgResult> f332912b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f332913c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ File f332914d;

        b(String str, com.tencent.mobileqq.zplan.easteregg.asyntask.a<EasterEggBgResult> aVar, long j3, File file) {
            this.f332911a = str;
            this.f332912b = aVar;
            this.f332913c = j3;
            this.f332914d = file;
        }

        @Override // ci3.a.InterfaceC0194a
        public void onResult(boolean isSuccess) {
            if (isSuccess) {
                QLog.e("EasterEggBackgroundManager", 1, "download image success, " + this.f332911a);
                com.tencent.mobileqq.zplan.easteregg.asyntask.a<EasterEggBgResult> aVar = this.f332912b;
                PortraitSource portraitSource = PortraitSource.REMOTE;
                long j3 = this.f332913c;
                String absolutePath = this.f332914d.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "downloadFile.absolutePath");
                aVar.onResult(new EasterEggBgResult(0, portraitSource, j3, absolutePath, null, 16, null));
                return;
            }
            QLog.e("EasterEggBackgroundManager", 1, "download image fail, " + this.f332911a);
            this.f332912b.onResult(new EasterEggBgResult(MessageRecord.MSG_TYPE_LIFEONLINEACCOUNT, null, 0L, null, null, 30, null));
        }
    }

    private final void g(long uin, String bgUrl, String backgroundName, com.tencent.mobileqq.zplan.easteregg.asyntask.a<EasterEggBgResult> listener) {
        File file = new File(j(backgroundName));
        if (file.exists()) {
            file.delete();
        }
        ci3.a.f30972a.a("scene_easter_egg_avatar_bg", bgUrl, file, new b(bgUrl, listener, uin, file));
    }

    private final String h(String url) {
        String d16 = com.tencent.open.base.g.d(url);
        Intrinsics.checkNotNullExpressionValue(d16, "toMD5(url)");
        return d16;
    }

    private final String j(String backgroundName) {
        return di3.b.f393984a.c("zplan/avatarbackground/") + backgroundName + ".png";
    }

    private final String k(String bgName) {
        String j3 = j(bgName);
        if (new File(j3).exists()) {
            return j3;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.zplan.easteregg.asyntask.AsynTaskHandler
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public String c(EasterEggBgParam param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return param.getBgUrl() + "EasterEggBackgroundManager";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.zplan.easteregg.asyntask.AsynTaskHandler
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void f(EasterEggBgParam param, com.tencent.mobileqq.zplan.easteregg.asyntask.a<EasterEggBgResult> listener) {
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(listener, "listener");
        boolean z16 = true;
        if (param.getBgUrl().length() == 0) {
            listener.onResult(new EasterEggBgResult(-5001, null, 0L, null, null, 30, null));
            return;
        }
        String h16 = h(param.getBgUrl());
        String k3 = k(h16);
        if (k3 != null && k3.length() != 0) {
            z16 = false;
        }
        if (z16) {
            g(param.getUin(), param.getBgUrl(), h16, listener);
        } else {
            listener.onResult(new EasterEggBgResult(0, PortraitSource.LOCAL, param.getUin(), k3, null, 16, null));
        }
    }
}
