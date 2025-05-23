package com.tencent.mobileqq.thirdsig.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Service(needUin = false, process = {"all"})
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J(\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J(\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0007H&J(\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0007H&J(\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0011H&J \u0010\u0013\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J8\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00042\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0014j\b\u0012\u0004\u0012\u00020\r`\u00152\u0006\u0010\b\u001a\u00020\u0017H&J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019H&J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019H&J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u001e\u001a\u00020\tH&J\b\u0010\u001f\u001a\u00020\tH&\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/thirdsig/api/IThirdSigService;", "Lmqq/app/api/IRuntimeService;", "", "uin", "", "uinType", "loginAppid", "Lcom/tencent/mobileqq/thirdsig/api/d;", "callback", "", "getStWeb", "getSt", "openAppid", "", "appidToken", "getAccessToken", "getOpenKey", "Lcom/tencent/mobileqq/thirdsig/api/b;", "getOpenId", "getSuperKey", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "domains", "Lcom/tencent/mobileqq/thirdsig/api/c;", "getPt4Token", "Lcom/tencent/mobileqq/thirdsig/api/e;", "listener", "addOnSigChangeListener", "removeOnSigChangeListener", "delThirdPartySigByUin", "onAppInit", "onAppDestroy", "third-sig-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface IThirdSigService extends IRuntimeService {
    void addOnSigChangeListener(@NotNull e listener);

    void delThirdPartySigByUin(long uin);

    void getAccessToken(long uin, int openAppid, @NotNull String appidToken, @NotNull d callback);

    void getOpenId(long uin, int openAppid, @NotNull String appidToken, @NotNull b callback);

    void getOpenKey(long uin, int openAppid, @NotNull String appidToken, @NotNull d callback);

    void getPt4Token(long uin, int loginAppid, @NotNull ArrayList<String> domains, @NotNull c callback);

    void getSt(long uin, int uinType, int loginAppid, @NotNull d callback);

    void getStWeb(long uin, int uinType, int loginAppid, @NotNull d callback);

    void getSuperKey(long uin, int loginAppid, @NotNull d callback);

    void onAppDestroy();

    void onAppInit();

    void removeOnSigChangeListener(@NotNull e listener);
}
